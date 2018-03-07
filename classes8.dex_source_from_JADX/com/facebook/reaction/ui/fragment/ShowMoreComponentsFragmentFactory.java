package com.facebook.reaction.ui.fragment;

import android.content.Intent;
import android.support.v4.app.Fragment;
import com.facebook.common.fragmentfactory.IFragmentFactory;

/* compiled from: Unknown card type */
public class ShowMoreComponentsFragmentFactory implements IFragmentFactory {
    public final Fragment m24794a(Intent intent) {
        ReactionShowMoreComponentsFragment reactionShowMoreComponentsFragment = new ReactionShowMoreComponentsFragment();
        reactionShowMoreComponentsFragment.g(intent.getExtras());
        return reactionShowMoreComponentsFragment;
    }
}
