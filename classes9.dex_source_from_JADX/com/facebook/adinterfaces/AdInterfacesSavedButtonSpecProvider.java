package com.facebook.adinterfaces;

import android.content.res.Resources;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.widget.titlebar.TitleBarButtonSpec;
import com.facebook.widget.titlebar.TitleBarButtonSpec.Builder;
import javax.inject.Inject;

/* compiled from: abs_pos */
public class AdInterfacesSavedButtonSpecProvider {
    private final Resources f21542a;

    public static AdInterfacesSavedButtonSpecProvider m22510b(InjectorLike injectorLike) {
        return new AdInterfacesSavedButtonSpecProvider(ResourcesMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public AdInterfacesSavedButtonSpecProvider(Resources resources) {
        this.f21542a = resources;
    }

    public final TitleBarButtonSpec m22511a() {
        Builder a = TitleBarButtonSpec.a();
        a.n = true;
        a = a;
        a.g = this.f21542a.getString(2131233984);
        a = a;
        a.q = true;
        a = a;
        a.h = -2;
        return a.a();
    }
}
