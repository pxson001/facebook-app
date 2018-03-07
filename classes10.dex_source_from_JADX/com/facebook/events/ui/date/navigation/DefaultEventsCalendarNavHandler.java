package com.facebook.events.ui.date.navigation;

import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.base.activity.FbFragmentActivity;
import com.facebook.widget.titlebar.FbTitleBar;
import com.facebook.widget.titlebar.FbTitleBar.OnToolbarButtonListener;
import com.facebook.widget.titlebar.FbTitleBarUtil;
import com.facebook.widget.titlebar.TitleBarButtonSpec;
import com.facebook.widget.titlebar.TitleBarButtonSpec.Builder;
import com.google.common.collect.ImmutableList;

/* compiled from: application_id */
public class DefaultEventsCalendarNavHandler {
    public final void m19631a(FbFragmentActivity fbFragmentActivity, String str, String str2, OnClickListener onClickListener, final OnClickListener onClickListener2) {
        FbTitleBarUtil.b(fbFragmentActivity);
        FbTitleBar fbTitleBar = (FbTitleBar) fbFragmentActivity.findViewById(2131558563);
        Builder a = TitleBarButtonSpec.a();
        a.a = 1;
        a = a;
        a.g = str2;
        a = a;
        a.h = -2;
        TitleBarButtonSpec a2 = a.a();
        fbTitleBar.setShowDividers(true);
        fbTitleBar.setTitle(str);
        fbTitleBar.setButtonSpecs(ImmutableList.of(a2));
        fbTitleBar.setHasBackButton(false);
        fbTitleBar.a(onClickListener);
        fbTitleBar.setOnToolbarButtonListener(new OnToolbarButtonListener(this) {
            final /* synthetic */ DefaultEventsCalendarNavHandler f19460b;

            public final void m19630a(View view, TitleBarButtonSpec titleBarButtonSpec) {
                onClickListener2.onClick(view);
            }
        });
    }
}
