package com.facebook.katana.urimap.fetchable;

import android.content.ComponentName;
import com.facebook.base.activity.FragmentChromeActivity;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.katana.urimap.fetchable.FacewebUriMap.FacewebUriHandler;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: suggested_option_timestamp */
public class FacewebUriHandlerBuilder {
    Provider<ComponentName> f1571a;

    public static FacewebUriHandlerBuilder m1789b(InjectorLike injectorLike) {
        return new FacewebUriHandlerBuilder(IdBasedProvider.a(injectorLike, 12));
    }

    @Inject
    public FacewebUriHandlerBuilder(@FragmentChromeActivity Provider<ComponentName> provider) {
        this.f1571a = provider;
    }

    public final FacewebUriHandler m1790a(String str) {
        return new FacewebUriHandler(this.f1571a, str);
    }
}
