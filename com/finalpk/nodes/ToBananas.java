package com.finalpk.nodes;

import org.powerbot.core.script.job.state.Node;
import org.powerbot.game.api.methods.Calculations;
import org.powerbot.game.api.methods.Walking;
import org.powerbot.game.api.methods.interactive.Players;
import org.powerbot.game.api.methods.tab.Inventory;

import com.finalpk.Settings;

public class ToBananas extends Node {

	@Override
	public boolean activate() {
		return Settings.MusaPoint.contains(Players.getLocal())
				&& Calculations.distanceTo(Settings.plantage) > 15
				&& !Inventory.isFull();
	}

	@Override
	public void execute() {
		Settings.status = "Walking to Bananas";
		Walking.findPath(Settings.plantage).traverse();
	}
}
