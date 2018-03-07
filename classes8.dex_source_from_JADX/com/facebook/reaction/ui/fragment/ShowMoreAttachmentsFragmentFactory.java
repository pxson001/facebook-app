package com.facebook.reaction.ui.fragment;

import android.content.Intent;
import android.support.v4.app.Fragment;
import com.facebook.common.fragmentfactory.IFragmentFactory;

/* compiled from: Unknown child passed to setViewFlipperDisplayedChild */
public class ShowMoreAttachmentsFragmentFactory implements IFragmentFactory {
    public final Fragment m24793a(Intent intent) {
        ReactionShowMoreAttachmentsFragment reactionShowMoreAttachmentsFragment = new ReactionShowMoreAttachmentsFragment();
        reactionShowMoreAttachmentsFragment.g(intent.getExtras());
        return reactionShowMoreAttachmentsFragment;
    }
}
