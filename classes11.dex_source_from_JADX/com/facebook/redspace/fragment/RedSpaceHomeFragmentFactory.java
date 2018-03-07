package com.facebook.redspace.fragment;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;
import com.facebook.common.activitylistener.ListenableActivity;
import com.facebook.common.fblinks.FBLinks;
import com.facebook.common.fragmentfactory.IFragmentFactory;
import com.facebook.common.uri.UriIntentMapper;
import com.facebook.content.SecureContextHelper;
import com.facebook.divebar.DivebarFragmentInitializer;
import com.facebook.divebar.DrawerBasedDivebarControllerImpl;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.redspace.entry.RedSpaceEntryPointCapability;
import com.facebook.ui.drawers.DrawerContentFragment;
import com.facebook.ultralight.Inject;
import com.facebook.ultralight.Lazy;
import com.facebook.ultralight.UltralightRuntime;

/* compiled from: Payload is set but no content-type header specified */
public class RedSpaceHomeFragmentFactory implements IFragmentFactory, DivebarFragmentInitializer {
    @Inject
    @Lazy
    public com.facebook.inject.Lazy<RedSpaceEntryPointCapability> f11959a = UltralightRuntime.b;
    @Inject
    @Lazy
    public com.facebook.inject.Lazy<UriIntentMapper> f11960b = UltralightRuntime.b;
    @Inject
    @Lazy
    public com.facebook.inject.Lazy<Context> f11961c = UltralightRuntime.b;
    @Inject
    @Lazy
    public com.facebook.inject.Lazy<SecureContextHelper> f11962d = UltralightRuntime.b;

    public static RedSpaceHomeFragmentFactory m12405b(InjectorLike injectorLike) {
        RedSpaceHomeFragmentFactory redSpaceHomeFragmentFactory = new RedSpaceHomeFragmentFactory();
        com.facebook.inject.Lazy a = IdBasedLazy.a(injectorLike, 3269);
        com.facebook.inject.Lazy b = IdBasedSingletonScopeProvider.b(injectorLike, 2436);
        com.facebook.inject.Lazy lazy = injectorLike.getLazy(Context.class);
        com.facebook.inject.Lazy b2 = IdBasedSingletonScopeProvider.b(injectorLike, 968);
        redSpaceHomeFragmentFactory.f11959a = a;
        redSpaceHomeFragmentFactory.f11960b = b;
        redSpaceHomeFragmentFactory.f11961c = lazy;
        redSpaceHomeFragmentFactory.f11962d = b2;
        return redSpaceHomeFragmentFactory;
    }

    public final DrawerContentFragment m12407a() {
        return RedSpaceHomeFragment.m12385a(true);
    }

    public final boolean m12410b() {
        return ((RedSpaceEntryPointCapability) this.f11959a.get()).a();
    }

    public final void m12408a(ListenableActivity listenableActivity, DrawerBasedDivebarControllerImpl drawerBasedDivebarControllerImpl) {
    }

    public final void m12409a(boolean z) {
    }

    public final boolean m12411c() {
        return false;
    }

    public final boolean m12412d() {
        Intent a = ((UriIntentMapper) this.f11960b.get()).a((Context) this.f11961c.get(), FBLinks.eT);
        a.putExtra("bundle_show_titlebar", true);
        ((SecureContextHelper) this.f11962d.get()).a(a, (Context) this.f11961c.get());
        return true;
    }

    public final Fragment m12406a(Intent intent) {
        return RedSpaceHomeFragment.m12385a(intent.getBooleanExtra("bundle_show_titlebar", false));
    }
}
