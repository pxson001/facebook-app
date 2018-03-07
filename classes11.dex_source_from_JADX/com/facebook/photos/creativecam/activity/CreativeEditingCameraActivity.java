package com.facebook.photos.creativecam.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.facebook.base.activity.FbFragmentActivity;
import com.facebook.composer.activity.ComposerLauncherImpl;
import com.facebook.inject.FbInjector;
import com.facebook.ipc.composer.launch.ComposerLauncher;
import com.facebook.ipc.creativecam.CreativeCamLaunchConfig;
import com.facebook.photos.base.media.MediaItemFactory;
import com.google.common.base.Preconditions;
import javax.inject.Inject;

/* compiled from: TouchablePagerContainer root view must be a ViewPager */
public class CreativeEditingCameraActivity extends FbFragmentActivity {
    public CreativeCamActivityDelegateProvider f10554p;
    private CreativeEditingCameraFragment f10555q;

    private static <T extends Context> void m11055a(Class<T> cls, T t) {
        m11056a((Object) t, (Context) t);
    }

    public static void m11056a(Object obj, Context context) {
        ((CreativeEditingCameraActivity) obj).f10554p = (CreativeCamActivityDelegateProvider) FbInjector.get(context).getOnDemandAssistedProviderForStaticDi(CreativeCamActivityDelegateProvider.class);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 0) {
            setResult(i2, intent);
            finish();
        }
    }

    @Inject
    private void m11054a(CreativeCamActivityDelegateProvider creativeCamActivityDelegateProvider) {
        this.f10554p = creativeCamActivityDelegateProvider;
    }

    public final void m11057b(Bundle bundle) {
        super.b(bundle);
        Class cls = CreativeEditingCameraActivity.class;
        m11056a((Object) this, (Context) this);
        setContentView(2130903824);
        getWindow().getDecorView().setSystemUiVisibility(1);
        CreativeCamLaunchConfig creativeCamLaunchConfig = (CreativeCamLaunchConfig) getIntent().getParcelableExtra("extra_creativecam_launch_configuration");
        String str = (String) Preconditions.checkNotNull(getIntent().getStringExtra("extra_creativecam_composer_session_id"));
        if (bundle == null) {
            this.f10555q = CreativeEditingCameraFragment.m11073b(getIntent());
            kO_().a().a(2131560846, this.f10555q).b();
        } else {
            this.f10555q = (CreativeEditingCameraFragment) kO_().a(2131560846);
        }
        CreativeEditingCameraFragment creativeEditingCameraFragment = this.f10555q;
        CreativeCamActivityDelegateProvider creativeCamActivityDelegateProvider = this.f10554p;
        creativeEditingCameraFragment.aQ = new CreativeCamActivityDelegate((ComposerLauncher) ComposerLauncherImpl.a(creativeCamActivityDelegateProvider), MediaItemFactory.b(creativeCamActivityDelegateProvider), this, creativeCamLaunchConfig, str);
    }

    public void onBackPressed() {
        if (this.f10555q == null || !this.f10555q.m11078b()) {
            super.onBackPressed();
        }
    }
}
