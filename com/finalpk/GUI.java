package com.finalpk;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

import org.powerbot.game.api.util.net.GeItem;

import com.finalpk.nodes.AntibanTask;
import com.finalpk.nodes.Banking;
import com.finalpk.nodes.CastHomeTeleport;
import com.finalpk.nodes.Castle;
import com.finalpk.nodes.Deposit;
import com.finalpk.nodes.Dialogue;
import com.finalpk.nodes.DuellRing;
import com.finalpk.nodes.EnterBoat;
import com.finalpk.nodes.LeaveBoat;
import com.finalpk.nodes.Pick;
import com.finalpk.nodes.ToggleRun;

@SuppressWarnings("serial")
public class GUI extends JFrame {

	/**
	 * Create the frame.
	 */
	public GUI() {
		init();
		this.setVisible(true);
	}

	private void init() {
		super.setName("Finalpk's Banana picker");
		setBounds(100, 100, 200, 150);

		final JCheckBox chckbxBaskets = new JCheckBox("Baskets?");

		final JCheckBox chckbxRingOfDuelling = new JCheckBox(
				"Ring of Duelling?");

		JButton btnStart = new JButton("Start");
		btnStart.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				BananaPicker.provide(new AntibanTask());
				BananaPicker.provide(new ToggleRun());
				BananaPicker.provide(new LeaveBoat());
				BananaPicker.provide(new Dialogue());
				BananaPicker.provide(new EnterBoat());
				BananaPicker.provide(new Pick());
				BananaPicker.provide(new LeaveBoat());
				if (chckbxBaskets.isSelected() && chckbxRingOfDuelling.isSelected()) {
					Settings.basket = true;
					BananaPicker.provide(new Castle());
					BananaPicker.provide(new Banking());
					BananaPicker.provide(new DuellRing());
					Settings.price = GeItem.lookup(Settings.baskets).getPrice();
				} else if (chckbxRingOfDuelling.isSelected()) {
					Settings.duellring = true;
					BananaPicker.provide(new Castle());
					BananaPicker.provide(new Banking());
					BananaPicker.provide(new DuellRing());
					Settings.price = GeItem.lookup(Settings.banana).getPrice();
				} else if (!chckbxBaskets.isSelected() && !chckbxRingOfDuelling.isSelected()) {
					BananaPicker.provide(new CastHomeTeleport());
					BananaPicker.provide(new Deposit());
					Settings.price = GeItem.lookup(Settings.banana).getPrice();
				}
				setVisible(false);
				dispose();

			}
		});
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(
				Alignment.LEADING).addGroup(
				groupLayout
						.createSequentialGroup()
						.addContainerGap()
						.addGroup(
								groupLayout
										.createParallelGroup(
												Alignment.LEADING)
										.addComponent(chckbxBaskets)
										.addComponent(chckbxRingOfDuelling)
										.addComponent(btnStart))
						.addContainerGap(73, Short.MAX_VALUE)));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(
				Alignment.LEADING).addGroup(
				groupLayout
						.createSequentialGroup()
						.addContainerGap()
						.addComponent(chckbxBaskets)
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addComponent(chckbxRingOfDuelling)
						.addPreferredGap(ComponentPlacement.RELATED, 22,
								Short.MAX_VALUE).addComponent(btnStart)
						.addContainerGap()));
		getContentPane().setLayout(groupLayout);
	}
}
