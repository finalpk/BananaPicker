package com.finalpk.nodes;

import org.powerbot.core.script.job.Task;
import org.powerbot.core.script.job.state.Node;
import org.powerbot.game.api.methods.Calculations;
import org.powerbot.game.api.methods.node.SceneEntities;
import org.powerbot.game.api.methods.tab.Inventory;
import org.powerbot.game.api.methods.widget.Camera;
import org.powerbot.game.api.wrappers.node.SceneObject;

import com.finalpk.Settings;

public class Pick extends Node {
	
	@Override
	public boolean activate() {
		return Calculations.distanceTo(Settings.plantage) < 15
				&& !Inventory.isFull()
				&& Inventory.getCount(Settings.basketsfull) != 23;
	}

	@Override
	public void execute() {
		Settings.status = "Picking Bananas";
		SceneObject tree = SceneEntities.getNearest(Settings.trees);
		if (!tree.isOnScreen())
			Camera.turnTo(tree);
		tree.interact("Pick");
		Task.sleep(300, 500);
		if (Inventory.getCount(Settings.banana) > Settings.current) {
			Settings.picked = Settings.picked + (Inventory.getCount(Settings.banana) - Settings.current);
			Settings.current = Inventory.getCount(Settings.banana);
		}
	}
}
