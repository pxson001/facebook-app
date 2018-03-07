package com.facebook.pages.identity.fragments.identity;

import android.content.Intent;
import android.support.v4.app.Fragment;
import com.facebook.common.fragmentfactory.IFragmentFactory;
import com.facebook.pages.common.surface.fragments.reaction.BasePagesReactionFragment;

/* compiled from: pages_ids */
public class PageReactionFragmentFactory implements IFragmentFactory {
    public final Fragment m4902a(Intent intent) {
        BasePagesReactionFragment basePagesReactionFragment = new BasePagesReactionFragment();
        basePagesReactionFragment.g(intent.getExtras());
        return basePagesReactionFragment;
    }
}
