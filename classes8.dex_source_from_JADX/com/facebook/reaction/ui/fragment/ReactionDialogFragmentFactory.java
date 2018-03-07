package com.facebook.reaction.ui.fragment;

import android.content.Intent;
import android.support.v4.app.Fragment;
import com.facebook.common.fragmentfactory.IFragmentFactory;

/* compiled from: Unknown result type. */
public class ReactionDialogFragmentFactory implements IFragmentFactory {
    public final Fragment m24769a(Intent intent) {
        ReactionDialogFragment reactionDialogFragment = new ReactionDialogFragment();
        reactionDialogFragment.g(intent.getExtras());
        return reactionDialogFragment;
    }
}
