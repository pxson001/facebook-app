package com.facebook.platform.composer.composer;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v4.app.FragmentTransaction;
import com.facebook.base.activity.FbFragmentActivity;
import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.inject.InjectorLike;
import com.facebook.platform.composer.model.PlatformComposerConfiguration;
import com.facebook.platform.composer.model.PlatformComposerConfiguration.HeaderType;
import javax.inject.Inject;

/* compiled from: rich_document_list_item */
public class PlatformComposerLauncher {
    private PlatformComposerFragment f4117a;
    private PlatformComposerControllerFragment f4118b;
    public final GatekeeperStoreImpl f4119c;
    private final PlatformComposerConfiguration f4120d;

    public static PlatformComposerLauncher m4085b(InjectorLike injectorLike) {
        return new PlatformComposerLauncher(GatekeeperStoreImplMethodAutoProvider.a(injectorLike), PlatformComposerConfiguration.m4123a(injectorLike));
    }

    @Inject
    public PlatformComposerLauncher(GatekeeperStoreImpl gatekeeperStoreImpl, PlatformComposerConfiguration platformComposerConfiguration) {
        this.f4119c = gatekeeperStoreImpl;
        this.f4120d = platformComposerConfiguration;
    }

    public final void m4086a(Bundle bundle, FbFragmentActivity fbFragmentActivity, @IdRes int i, Intent intent) {
        if (this.f4120d.f4166c == HeaderType.TARGET_PRIVACY) {
            if (bundle != null) {
                this.f4118b = (PlatformComposerControllerFragment) fbFragmentActivity.kO_().a(i);
            }
            if (this.f4118b == null) {
                Bundle bundle2 = new Bundle();
                bundle2.putAll(intent.getExtras());
                PlatformComposerControllerFragment platformComposerControllerFragment = new PlatformComposerControllerFragment();
                platformComposerControllerFragment.g(bundle2);
                this.f4118b = platformComposerControllerFragment;
                FragmentTransaction a = fbFragmentActivity.kO_().a();
                a.a(i, this.f4118b);
                a.b();
                return;
            }
            return;
        }
        if (bundle != null) {
            this.f4117a = (PlatformComposerFragment) fbFragmentActivity.kO_().a(i);
        }
        if (this.f4117a == null) {
            bundle2 = new Bundle();
            bundle2.putAll(intent.getExtras());
            PlatformComposerFragment platformComposerFragment = new PlatformComposerFragment();
            platformComposerFragment.g(bundle2);
            this.f4117a = platformComposerFragment;
            a = fbFragmentActivity.kO_().a();
            a.a(i, this.f4117a);
            a.b();
        }
    }

    public final void m4087b() {
        if (this.f4117a != null) {
            this.f4117a.ar();
        } else if (this.f4118b != null) {
            this.f4118b.m3973b();
        }
    }

    public static void m4084a(Activity activity) {
        activity.setResult(-1, null);
    }
}
