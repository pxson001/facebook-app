package com.facebook.groups.photos.view;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.inject.InjectorLike;
import javax.inject.Inject;

/* compiled from: TINCAN_ROW */
public class GroupPhotosDefaultViewFactory {
    public Resources f23108a;

    public static GroupPhotosDefaultViewFactory m24419b(InjectorLike injectorLike) {
        return new GroupPhotosDefaultViewFactory(ResourcesMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public GroupPhotosDefaultViewFactory(Resources resources) {
        this.f23108a = resources;
    }

    public final String m24420a() {
        return this.f23108a.getString(2131242206);
    }

    public final String m24421c() {
        return this.f23108a.getString(2131242206);
    }

    public final Drawable m24422e() {
        return this.f23108a.getDrawable(2130840032);
    }
}
