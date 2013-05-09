package com.finalpk.Ability.action.ability;

import org.powerbot.game.api.wrappers.widget.WidgetChild;

import com.finalpk.Ability.action.Ability;
import com.finalpk.Ability.general.Completion;
import com.finalpk.Ability.tab.MainTabs;
import com.finalpk.Ability.tab.Tab;

public enum Prayer implements Ability {
	;

	@Override
	public boolean show() {
		return false;
	}

	@Override
	public boolean isVisible() {
		return false;
	}

	@Override
	public boolean available() {
		return false;
	}

	public Tab getTab() {
		return MainTabs.PRAYER;
	}

	@Override
	public WidgetChild getChild() {
		return null;
	}

	@Override
	public Completion getChange() {
		return null;
	}

	@Override
	public int getAbilityId() {
		return 0;
	}

}
