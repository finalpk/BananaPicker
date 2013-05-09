package com.finalpk.nodes;

import org.powerbot.core.script.job.Task;
import org.powerbot.core.script.job.state.Node;
import org.powerbot.game.api.methods.Calculations;
import org.powerbot.game.api.methods.Widgets;
import org.powerbot.game.api.methods.interactive.NPCs;
import org.powerbot.game.api.methods.tab.Inventory;
import org.powerbot.game.api.wrappers.interactive.NPC;

import com.finalpk.Settings;

public class EnterBoat extends Node {

	@Override
	public boolean activate() {
		return Calculations.distanceTo(Settings.seamen) < 5 && !Inventory.isFull()
				&& !Widgets.get(1184).validate()
				&& !Widgets.get(1188).validate()
				&& !Widgets.get(1191).validate();
	}

	@Override
	public void execute() {
		Settings.status = "Entering Boat";
		NPC man = NPCs.getNearest(Settings.seaman);
		man.interact("Pay-fare");
		Task.sleep(500, 1000);
	}
}