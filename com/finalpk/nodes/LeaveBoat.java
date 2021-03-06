package com.finalpk.nodes;

import org.powerbot.core.script.job.Task;
import org.powerbot.core.script.job.state.Node;
import org.powerbot.game.api.methods.Calculations;
import org.powerbot.game.api.methods.Walking;
import org.powerbot.game.api.methods.interactive.Players;
import org.powerbot.game.api.methods.node.SceneEntities;
import org.powerbot.game.api.methods.tab.Inventory;
import org.powerbot.game.api.wrappers.node.SceneObject;

import com.finalpk.Settings;

public class LeaveBoat extends Node {

	@Override
	public boolean activate() {
		return Calculations.distanceTo(Settings.boat) < 2 && !Inventory.isFull();
	}

	@Override
	public void execute() {
		Settings.status = "Leaving Boat";
		SceneObject plank = SceneEntities.getNearest(Settings.gangplank);
		plank.interact("Cross");
		Task.sleep(500, 1000);
		Settings.status = "Walking to Bananas";
		while(Settings.MusaPoint.contains(Players.getLocal())
				&& Calculations.distanceTo(Settings.plantage) > 15
				&& !Inventory.isFull()) {
			Walking.findPath(Settings.plantage).traverse();
		}
	}
}
