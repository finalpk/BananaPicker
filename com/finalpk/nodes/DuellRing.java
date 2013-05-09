package com.finalpk.nodes;

import org.powerbot.core.script.job.Task;
import org.powerbot.core.script.job.state.Node;
import org.powerbot.game.api.methods.Tabs;
import org.powerbot.game.api.methods.Widgets;
import org.powerbot.game.api.methods.interactive.Players;
import org.powerbot.game.api.methods.tab.Inventory;

import com.finalpk.Settings;

public class DuellRing extends Node {

	@Override
	public boolean activate() {
		return Settings.MusaPoint.contains(Players.getLocal())
				&& Inventory.getCount(5416) == 23
				&& Players.getLocal().getAnimation() == -1
				&& Settings.basket == true;
	}

	@Override
	public void execute() {
		Tabs.EQUIPMENT.open();
		Widgets.get(387).getChild(33).interact("Castle Wars");
		Task.sleep(1000, 2000);
	}
}
