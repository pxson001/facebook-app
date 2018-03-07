package com.facebook.redspace.fetcher;

import android.content.res.Resources;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.redspace.abtest.RedSpaceFriendsLayout;
import com.facebook.ultralight.Inject;

/* compiled from: USER_SEARCH */
public class RedSpaceFriendsImageSizeResolver {
    @Inject
    public Resources f21318a;
    @Inject
    public QeAccessor f21319b;

    public static RedSpaceFriendsImageSizeResolver m24941b(InjectorLike injectorLike) {
        RedSpaceFriendsImageSizeResolver redSpaceFriendsImageSizeResolver = new RedSpaceFriendsImageSizeResolver();
        QeAccessor qeAccessor = (QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike);
        redSpaceFriendsImageSizeResolver.f21318a = ResourcesMethodAutoProvider.a(injectorLike);
        redSpaceFriendsImageSizeResolver.f21319b = qeAccessor;
        return redSpaceFriendsImageSizeResolver;
    }

    public final int m24942a() {
        Object obj;
        int i;
        Resources resources = this.f21318a;
        if (RedSpaceFriendsLayout.getLayout(this.f21319b) == RedSpaceFriendsLayout.LIST) {
            obj = 1;
        } else {
            obj = null;
        }
        if (obj != null) {
            i = 2131430559;
        } else {
            i = 2131430558;
        }
        return Math.max(resources.getDimensionPixelSize(i), this.f21318a.getDimensionPixelSize(2131430518));
    }
}
