package com.finalpk.nodes;

import org.powerbot.core.script.job.Task;
import org.powerbot.core.script.job.state.Node;
import org.powerbot.game.api.methods.Widgets;
import org.powerbot.game.api.methods.interactive.Players;
import org.powerbot.game.api.methods.tab.Inventory;

import com.finalpk.Settings;
import com.finalpk.Ability.action.ActionBar;
import com.finalpk.Ability.action.book.magic.Spell;

public class CastHomeTeleport extends Node {

	@Override
	public boolean activate() {
		return Settings.MusaPoint.contains(Players.getLocal())
				&& Inventory.isFull()
				&& Players.getLocal().getAnimation() == -1
				&& !Widgets.get(1092).validate() 
				&& Settings.basket == false;
	}

	@Override
	public void execute() {
		Settings.status = "Teleporting";
		ActionBar.useAbility(Spell.HOME_TELEPORT);
		Task.sleep(500, 1000);
	}
}
