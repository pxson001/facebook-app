package com.facebook.base.activity;

import android.content.ComponentName;
import android.content.Intent;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.intent.internal.InternalIntentSigner;
import com.facebook.ultralight.Inject;
import com.facebook.ultralight.UltralightRuntime;
import javax.inject.Provider;

/* compiled from: sms_is_default_app_for_settings_ui */
public final class FragmentBaseActivityUtil {
    @Inject
    public volatile Provider<InternalIntentSigner> f2083a = UltralightRuntime.a;
    @Inject
    @FragmentBaseActivity
    public volatile Provider<ComponentName> f2084b = UltralightRuntime.a;

    public static FragmentBaseActivityUtil m2181b(InjectorLike injectorLike) {
        FragmentBaseActivityUtil fragmentBaseActivityUtil = new FragmentBaseActivityUtil();
        Provider a = IdBasedSingletonScopeProvider.a(injectorLike, 2400);
        Provider a2 = IdBasedSingletonScopeProvider.a(injectorLike, 11);
        fragmentBaseActivityUtil.f2083a = a;
        fragmentBaseActivityUtil.f2084b = a2;
        return fragmentBaseActivityUtil;
    }

    public final Intent m2182a() {
        InternalIntentSigner internalIntentSigner = (InternalIntentSigner) this.f2083a.get();
        Intent component = new Intent().setComponent((ComponentName) this.f2084b.get());
        internalIntentSigner.a(component);
        return component;
    }
}
