package com.finalpk.nodes;

import org.powerbot.core.script.job.state.Node;
import org.powerbot.game.api.methods.Walking;

public class ToggleRun extends Node {

	@Override
	public boolean activate() {
		return !Walking.isRunEnabled() && Walking.getEnergy() > 30;
	}

	@Override
	public void execute() {
		Walking.setRun(true);
	}
}
