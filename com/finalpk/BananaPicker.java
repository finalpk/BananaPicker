package com.finalpk;

import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.powerbot.core.event.events.MessageEvent;
import org.powerbot.core.event.listeners.MessageListener;
import org.powerbot.core.event.listeners.PaintListener;
import org.powerbot.core.script.ActiveScript;
import org.powerbot.core.script.job.state.Node;
import org.powerbot.core.script.job.state.Tree;
import org.powerbot.game.api.Manifest;
import org.powerbot.game.api.methods.input.Mouse;
import org.powerbot.game.api.util.Random;

@Manifest(authors = { "Finalpk" }, name = "BananaPicker", description = "Picks Bananas and banks them for money.", version = 1.50, website = "http://www.powerbot.org/community/topic/792046-finalpks-banana-picker/")
public class BananaPicker extends ActiveScript implements PaintListener,
		MessageListener {

	private final static List<Node> jobsCollection = Collections
			.synchronizedList(new ArrayList<Node>());
	public static Tree jobContainer = null;

	public final static void provide(final Node... jobs) {
		for (final Node job : jobs) {
			if (!jobsCollection.contains(job)) {
				jobsCollection.add(job);
			}
		}
		jobContainer = new Tree(jobsCollection.toArray(new Node[jobsCollection
				.size()]));
	}

	@Override
	public void onRepaint(Graphics g1) {
		long runTime = System.currentTimeMillis() - Settings.time;
		int pickph = (int) ((Settings.picked * 3600000D) / runTime);
		int money;
		if (Settings.basket)
			money = Settings.price * (Settings.picked / 5);
		else
			money = Settings.price * Settings.picked;
		int moneyph = (int) ((money * 3600000D) / runTime);
		Graphics2D g = (Graphics2D) g1;
		g.setRenderingHints(Settings.antialiasing);

		g.setColor(Settings.color1);
		g.fillRoundRect(335, 250, 180, 140, 16, 16);

		g.setFont(Settings.font1);
		g.setColor(Settings.color3);
		g.drawString("Finalpk's Banana Picker", 320, 240);
		g.drawOval(Mouse.getX() - 5, Mouse.getY() - 5, 5 * 2, 5 * 2);
		g.setFont(Settings.font2);
		g.setColor(Settings.color2);
		g.drawString("Time:", 340, 260);
		g.drawString("Bananas:", 340, 280);
		g.drawString("Bananas p/h:", 340, 300);
		g.drawString("Money:", 340, 320);
		g.drawString("Money p/h:", 340, 340);
		g.drawString("Status:", 340, 360);
		g.drawString("" + Settings.timer.toElapsedString(), 420, 260);
		g.drawString("" + Settings.picked, 420, 280);
		g.drawString("" + pickph, 420, 300);
		g.drawString("" + money, 420, 320);
		g.drawString("" + moneyph, 420, 340);
		g.drawString("" + Settings.status, 420, 360);
		g.drawString("Version: 1.40", 440, 380);
	}

	@Override
	public void onStart() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI frame = new GUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		Settings.time = System.currentTimeMillis();
	}

	@Override
	public int loop() {
		if (jobContainer != null) {
			final Node job = jobContainer.state();
			if (job != null) {
				jobContainer.set(job);
				getContainer().submit(job);
				job.join();
			}
		}
		return Random.nextInt(10, 50);
	}

	@Override
	public void messageReceived(MessageEvent e) {
		String message = e.getMessage();
		if (message.contains("crumbles"))
			Settings.newring = true;
	}

}
