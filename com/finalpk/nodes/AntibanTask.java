package com.finalpk.nodes;

import java.awt.Point;

import org.powerbot.core.script.job.state.Node;
import org.powerbot.game.api.methods.Tabs;
import org.powerbot.game.api.methods.input.Mouse;
import org.powerbot.game.api.methods.interactive.Players;
import org.powerbot.game.api.methods.tab.Skills;
import org.powerbot.game.api.methods.widget.Camera;
import org.powerbot.game.api.util.Random;
import org.powerbot.game.api.util.Timer;
import org.powerbot.game.api.wrappers.widget.WidgetChild;

public class AntibanTask extends Node {

	private Timer antiBanTimer;

	private int minTime = (20 * 1000);
	private int maxTime = (120 * 1000);

	public AntibanTask() {
		antiBanTimer = new Timer(Random.nextInt(minTime, maxTime));
	}

	@Override
	public boolean activate() {
		return !antiBanTimer.isRunning();
	}

	@Override
	public void execute() {
		int r = Random.nextInt(1, 10);
		switch (r) {
		case 0:
			// Open the skills tab and check a random skill
			int randomSkill = Random.nextInt(0, 24);
			Tabs.STATS.open();
			WidgetChild randStat = Skills.getWidgetChild(randomSkill);
			Point randStatPoint = randStat.getAbsoluteLocation();
			randStatPoint.x += Random.nextInt(-10, 10);
			randStatPoint.y += Random.nextInt(-10, 10);
			Mouse.move(randStatPoint);
			break;
		case 1:
			Tabs.FRIENDS.open();
			Point point = Mouse.getLocation();
			point.x += Random.nextInt(-100, 100);
			point.y += Random.nextInt(-100, 100);
			Mouse.move(point);
			break;
		case 2:
			Tabs.EMOTES.open();
			Point point2 = Mouse.getLocation();
			point2.x += Random.nextInt(-100, 100);
			point2.y += Random.nextInt(-100, 100);
			Mouse.move(point2);
			break;
		case 3:
			Tabs.FRIENDS_CHAT.open();
			Point point3 = Mouse.getLocation();
			point3.x += Random.nextInt(-100, 100);
			point3.y += Random.nextInt(-100, 100);
			Mouse.move(point3);
			break;

		default:
			if (Players.getLocal().getInteracting() != null) {
				Camera.turnTo(Players.getLocal().getInteracting());
				int currentPitch = Camera.getPitch();
				int currentYaw = Camera.getYaw();
				Camera.setPitch(currentPitch + Random.nextInt(-13, 13));
				Camera.setAngle(currentYaw + Random.nextInt(-25, 25));
			} else {
				int currentPitch = Camera.getPitch();
				int currentYaw = Camera.getYaw();
				Camera.setPitch(currentPitch + Random.nextInt(-50, 50));
				Camera.setAngle(currentYaw + Random.nextInt(-70, 70));
			}
		}
		resetAntiBanTime();
	}

	private void resetAntiBanTime() {
		antiBanTimer.setEndIn(Random.nextInt(minTime, maxTime));
	}
}
