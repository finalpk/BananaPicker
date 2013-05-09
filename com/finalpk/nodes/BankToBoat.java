package com.finalpk.nodes;

import org.powerbot.core.script.job.state.Node;
import org.powerbot.game.api.methods.Calculations;
import org.powerbot.game.api.methods.Walking;
import org.powerbot.game.api.methods.interactive.Players;
import org.powerbot.game.api.methods.tab.Inventory;

import com.finalpk.Settings;

public class BankToBoat extends Node {

	@Override
	public boolean activate() {
		return !Settings.MusaPoint.contains(Players.getLocal())
				&& !Inventory.isFull()
				&& Calculations.distanceTo(Settings.seamen) > 5
				&& Calculations.distanceTo(Settings.seamen) < 100;
	}

	@Override
	public void execute() {
		Settings.status = "Walking to Boat";
		Walking.findPath(Settings.seamen).traverse();
	}
}
