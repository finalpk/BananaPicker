package com.finalpk.nodes;

import org.powerbot.core.script.job.Task;
import org.powerbot.core.script.job.state.Node;
import org.powerbot.game.api.methods.Calculations;
import org.powerbot.game.api.methods.Walking;

import com.finalpk.Settings;

public class Castle extends Node {

	@Override
	public boolean activate() {
		return Calculations.distanceTo(Settings.castle) < 5;
	}

	@Override
	public void execute() {
		Settings.status = "Banking";
		Walking.walk(Settings.bank);
		Task.sleep(1000, 1500);
	}
}
