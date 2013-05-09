package com.finalpk.nodes;

import org.powerbot.core.script.job.Task;
import org.powerbot.core.script.job.state.Node;
import org.powerbot.game.api.methods.Calculations;
import org.powerbot.game.api.methods.Walking;
import org.powerbot.game.api.methods.interactive.Players;
import org.powerbot.game.api.methods.tab.Inventory;
import org.powerbot.game.api.methods.widget.DepositBox;

import com.finalpk.Settings;

public class Deposit extends Node {

	@Override
	public boolean activate() {
		return Calculations.distanceTo(Settings.deposit) < 3 && Inventory.isFull();
	}

	@Override
	public void execute() {
		Settings.status = "Banking";
		if (!DepositBox.isOpen()) {
			DepositBox.open();
			Task.sleep(500);
		}
		if (DepositBox.isOpen()) {
			DepositBox.depositInventory();
			Settings.current = 0;
			Task.sleep(500);
			DepositBox.close();
		}
		Task.sleep(300, 500);
		Settings.status = "Walking to Boat";
		while(!Settings.MusaPoint.contains(Players.getLocal())
				&& !Inventory.isFull()
				&& Calculations.distanceTo(Settings.seamen) > 5
				&& Calculations.distanceTo(Settings.seamen) < 100) {
			Walking.findPath(Settings.seamen).traverse();
		}
	}
}
