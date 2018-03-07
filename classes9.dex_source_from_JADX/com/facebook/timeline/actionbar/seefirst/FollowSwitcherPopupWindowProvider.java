package com.facebook.timeline.actionbar.seefirst;

import android.content.Context;
import android.view.View;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.tablet.Boolean_IsTabletMethodAutoProvider;

/* compiled from: use_existing_group */
public class FollowSwitcherPopupWindowProvider extends AbstractAssistedProvider<FollowSwitcherPopupWindow> {
    public final FollowSwitcherPopupWindow m839a(View view, Boolean bool, Boolean bool2, Boolean bool3) {
        return new FollowSwitcherPopupWindow(view, bool, bool2, bool3, (Context) getInstance(Context.class), BottomPopoverWindow.m833b(this), Boolean_IsTabletMethodAutoProvider.a(this));
    }
}
