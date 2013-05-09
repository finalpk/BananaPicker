package com.finalpk.nodes;

import org.powerbot.core.script.job.Task;
import org.powerbot.core.script.job.state.Node;
import org.powerbot.game.api.methods.Widgets;

import com.finalpk.Settings;

public class ConfirmHomeTeleport extends Node {

	@Override
	public boolean activate() {
		return Widgets.get(1092).validate();
	}

	@Override
	public void execute() {
		Settings.status = "Teleporting";
		if (Widgets.get(1092, 48).click(true))
			Task.sleep(2500, 4500);
	}
}
