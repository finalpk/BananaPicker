package com.finalpk.nodes;

import org.powerbot.core.script.job.Task;
import org.powerbot.core.script.job.state.Node;
import org.powerbot.game.api.methods.Widgets;

public class Screen1 extends Node {

	@Override
	public boolean activate() {
		return Widgets.get(1184).validate();
	}

	@Override
	public void execute() {
		Widgets.get(1184).getChild(18).click(true);
		Task.sleep(500, 1000);
	}
}
