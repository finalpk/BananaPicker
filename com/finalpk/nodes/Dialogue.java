package com.finalpk.nodes;

import org.powerbot.core.script.job.Task;
import org.powerbot.core.script.job.state.Node;
import org.powerbot.game.api.methods.Widgets;

public class Dialogue extends Node {

	@Override
	public boolean activate() {
		return Widgets.get(1184).validate() || Widgets.get(1188).validate()
				|| Widgets.get(1191).validate();
	}

	@Override
	public void execute() {
		if (Widgets.get(1184).validate()) {
		Widgets.get(1184).getChild(18).click(true);
		Task.sleep(500, 1000);
		} else if (Widgets.get(1188).validate()) {
			Widgets.get(1188).getChild(11).click(true);
			Task.sleep(500, 1000);
		} else {
			Widgets.get(1191).getChild(18).click(true);
			Task.sleep(500, 1000);
		}
	}
}
