package com.facebook.events.create.navigation;

import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.base.activity.FbFragmentActivity;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.widget.titlebar.FbTitleBar;
import com.facebook.widget.titlebar.FbTitleBar.OnToolbarButtonListener;
import com.facebook.widget.titlebar.FbTitleBarUtil;
import com.facebook.widget.titlebar.TitleBarButtonSpec;
import com.facebook.widget.titlebar.TitleBarButtonSpec.Builder;
import com.google.common.collect.ImmutableList;
import javax.inject.Inject;

/* compiled from: contact_invite_list_fetch_success */
public class DefaultEventCreationNavHandler {
    private Resources f16260a;

    public static DefaultEventCreationNavHandler m16638a(InjectorLike injectorLike) {
        return new DefaultEventCreationNavHandler(ResourcesMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public DefaultEventCreationNavHandler(Resources resources) {
        this.f16260a = resources;
    }

    public final void m16639a(FbFragmentActivity fbFragmentActivity, OnClickListener onClickListener, final OnClickListener onClickListener2) {
        FbTitleBarUtil.b(fbFragmentActivity);
        FbTitleBar fbTitleBar = (FbTitleBar) fbFragmentActivity.findViewById(2131558563);
        Builder a = TitleBarButtonSpec.a();
        a.a = 1;
        a = a;
        a.g = this.f16260a.getString(2131236942);
        a = a;
        a.h = -2;
        TitleBarButtonSpec a2 = a.a();
        fbTitleBar.setShowDividers(true);
        fbTitleBar.setCustomTitleView(fbFragmentActivity.getLayoutInflater().inflate(2130904025, null, false));
        fbTitleBar.setButtonSpecs(ImmutableList.of(a2));
        fbTitleBar.setTitlebarAsModal(onClickListener);
        fbTitleBar.setOnToolbarButtonListener(new OnToolbarButtonListener(this) {
            final /* synthetic */ DefaultEventCreationNavHandler f16259b;

            public final void m16637a(View view, TitleBarButtonSpec titleBarButtonSpec) {
                onClickListener2.onClick(view);
            }
        });
    }
}
