package com.facebook.groups.memberlist.view;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.inject.InjectorLike;
import javax.inject.Inject;

/* compiled from: extra_cancel_button_enabled */
public class DefaultGroupMembershipViewFactory {
    public Resources f14555a;

    public static DefaultGroupMembershipViewFactory m16393b(InjectorLike injectorLike) {
        return new DefaultGroupMembershipViewFactory(ResourcesMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public DefaultGroupMembershipViewFactory(Resources resources) {
        this.f14555a = resources;
    }

    public final Drawable m16394c() {
        return this.f14555a.getDrawable(2130839815);
    }
}
