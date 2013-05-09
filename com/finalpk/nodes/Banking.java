package com.finalpk.nodes;

import org.powerbot.core.script.job.Task;
import org.powerbot.core.script.job.state.Node;
import org.powerbot.game.api.methods.Calculations;
import org.powerbot.game.api.methods.tab.Inventory;
import org.powerbot.game.api.methods.widget.Bank;

import com.finalpk.Settings;

public class Banking extends Node {

	@Override
	public boolean activate() {
		return Calculations.distanceTo(Settings.bank) < 3
				&& Inventory.getCount(Settings.baskets) == 0
				&& Inventory.getCount() != 0;
	}

	@Override
	public void execute() {
		Settings.status = "Banking";
		if (!Bank.isOpen()) {
			Bank.open();
			Task.sleep(500);
		}
		if (Bank.isOpen()) {
			Bank.depositInventory();
			Settings.current = 0;
			Task.sleep(500);
			if (Settings.basket)
				Bank.withdraw(Settings.baskets, 23);
			if (Settings.newring)
				Bank.withdraw(Settings.ring, 1);
			Bank.close();
			Task.sleep(500, 1000);
			if (Inventory.getCount(Settings.ring) > 0)
				Inventory.getItem(Settings.ring).getWidgetChild().click(true);
		}
	}
}