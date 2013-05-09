package com.finalpk.nodes;

import org.powerbot.core.script.job.state.Node;
import org.powerbot.game.api.methods.interactive.Players;
import org.powerbot.game.api.methods.tab.Inventory;

import com.finalpk.Settings;

public class Fill extends Node {

	@Override
	public boolean activate() {
		return Settings.MusaPoint.contains(Players.getLocal()) && Inventory.isFull()
				&& Players.getLocal().getAnimation() == -1
				&& Settings.basket == true;
	}

	@Override
	public void execute() {
		Inventory.getItem(Settings.baskets).getWidgetChild().click(true);
		Settings.current = 0;
	}
}
