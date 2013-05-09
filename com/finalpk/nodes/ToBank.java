package com.finalpk.nodes;

import org.powerbot.core.script.job.state.Node;
import org.powerbot.game.api.methods.Calculations;
import org.powerbot.game.api.methods.Walking;
import org.powerbot.game.api.methods.interactive.Players;
import org.powerbot.game.api.methods.tab.Inventory;

import com.finalpk.Settings;

public class ToBank extends Node {

	@Override
	public boolean activate() {
		return !Settings.MusaPoint.contains(Players.getLocal())
				&& Inventory.isFull()
				&& Calculations.distanceTo(Settings.deposit) > 3;
	}

	@Override
	public void execute() {
		Settings.status = "Walking to Bank";
		Walking.findPath(Settings.deposit).traverse();
	}
}
