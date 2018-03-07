package com.facebook.timeline.stagingground;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.base.activity.FbFragmentActivity;
import com.facebook.debug.log.BLog;
import com.facebook.fbui.dialog.AlertDialog;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.ipc.editgallery.EditGalleryIpcBundle;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.timeline.abtest.ExperimentsForTimelineAbTestModule;
import com.facebook.timeline.stagingground.StagingGroundController.C10756;
import com.facebook.timeline.stagingground.StagingGroundLaunchConfig.Builder;
import com.facebook.timeline.ui.common.ProfileMediaFragmentLayout;
import com.facebook.widget.SwitchCompat;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: fav_photos_add_prompt_suggested_click */
public class StagingGroundActivity extends FbFragmentActivity {
    @Inject
    private StagingGroundAnalyticsLoggerProvider f14705p;
    private StagingGroundAnalyticsLogger f14706q;
    @Inject
    private StagingGroundControllerProvider f14707r;
    private StagingGroundController f14708s;
    @Inject
    private QeAccessor f14709t;
    @Inject
    private CropBeforeStagingGroundHelper f14710u;
    private StagingGroundLaunchConfig f14711v;
    private long f14712w;
    private boolean f14713x;

    private static <T extends Context> void m18642a(Class<T> cls, T t) {
        m18643a((Object) t, (Context) t);
    }

    public static void m18643a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        StagingGroundActivity stagingGroundActivity = (StagingGroundActivity) obj;
        StagingGroundAnalyticsLoggerProvider stagingGroundAnalyticsLoggerProvider = (StagingGroundAnalyticsLoggerProvider) fbInjector.getOnDemandAssistedProviderForStaticDi(StagingGroundAnalyticsLoggerProvider.class);
        StagingGroundControllerProvider stagingGroundControllerProvider = (StagingGroundControllerProvider) fbInjector.getOnDemandAssistedProviderForStaticDi(StagingGroundControllerProvider.class);
        QeAccessor qeAccessor = (QeAccessor) QeInternalImplMethodAutoProvider.a(fbInjector);
        CropBeforeStagingGroundHelper cropBeforeStagingGroundHelper = new CropBeforeStagingGroundHelper();
        Provider a = IdBasedProvider.a(fbInjector, 1281);
        Provider a2 = IdBasedSingletonScopeProvider.a(fbInjector, 968);
        cropBeforeStagingGroundHelper.f14703a = a;
        cropBeforeStagingGroundHelper.f14704b = a2;
        stagingGroundActivity.m18641a(stagingGroundAnalyticsLoggerProvider, stagingGroundControllerProvider, qeAccessor, cropBeforeStagingGroundHelper);
    }

    private void m18641a(StagingGroundAnalyticsLoggerProvider stagingGroundAnalyticsLoggerProvider, StagingGroundControllerProvider stagingGroundControllerProvider, QeAccessor qeAccessor, CropBeforeStagingGroundHelper cropBeforeStagingGroundHelper) {
        this.f14705p = stagingGroundAnalyticsLoggerProvider;
        this.f14707r = stagingGroundControllerProvider;
        this.f14709t = qeAccessor;
        this.f14710u = cropBeforeStagingGroundHelper;
    }

    public final void m18645b(Bundle bundle) {
        super.b(bundle);
        Class cls = StagingGroundActivity.class;
        m18643a((Object) this, (Context) this);
        setContentView(2130907209);
        Bundle extras = getIntent().getExtras();
        this.f14711v = (StagingGroundLaunchConfig) extras.getParcelable("key_staging_ground_launch_config");
        if (this.f14711v == null) {
            BLog.b(StagingGroundActivity.class, "StagingGroundLaunchConfiguration must be set");
            finish();
            return;
        }
        this.f14706q = new StagingGroundAnalyticsLogger(AnalyticsLoggerMethodAutoProvider.a(this.f14705p), this.f14711v.f14779k);
        if (bundle == null || !bundle.containsKey("expirationKey")) {
            this.f14712w = this.f14711v.f14774f;
        } else {
            this.f14712w = bundle.getLong("expirationKey", 0);
        }
        boolean z = bundle != null && bundle.getBoolean("hasDoneCropBeforeStagingGround", false);
        this.f14713x = z;
        if (extras.containsKey("video_model") || !this.f14709t.a(ExperimentsForTimelineAbTestModule.i, false) || this.f14713x) {
            m18644c(bundle);
            return;
        }
        this.f14710u.m18640a(this, this.f14711v.f14770b, this.f14711v.f14771c, this.f14711v.f14772d, this.f14711v.f14773e, this.f14711v.f14781m);
        this.f14713x = true;
    }

    private void m18644c(@Nullable Bundle bundle) {
        this.f14708s = this.f14707r.m18664a(this.f14712w, this.f14711v.f14773e, this.f14706q);
        this.f14708s.m18658a((FbFragmentActivity) this, bundle, this.f14711v, (ProfileMediaFragmentLayout) a(2131567597));
        if (bundle == null) {
            this.f14706q.m18647a(this.f14708s.m18661c(), this.f14708s.m18662d(), this.f14708s.m18663e());
        }
    }

    public void onDestroy() {
        int a = Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_START, 1328946538);
        if (this.f14708s != null) {
            this.f14708s.f14742o.mo1154a();
        }
        super.onDestroy();
        Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_END, 395965814, a);
    }

    public void onSaveInstanceState(Bundle bundle) {
        bundle.putBoolean("hasDoneCropBeforeStagingGround", this.f14713x);
        if (this.f14708s != null) {
            StagingGroundController stagingGroundController = this.f14708s;
            ProfileMediaFragmentLayout profileMediaFragmentLayout = (ProfileMediaFragmentLayout) a(2131567597);
            stagingGroundController.f14742o.mo1156a(bundle);
            bundle.putBoolean("skippedToEditing", stagingGroundController.f14744q);
            bundle.putLong("expirationKey", stagingGroundController.f14738k.m18773a());
            bundle.putString("captionKey", stagingGroundController.f14741n);
            SwitchCompat switchCompat = (SwitchCompat) profileMediaFragmentLayout.findViewById(2131567613);
            if (switchCompat != null) {
                bundle.putBoolean("postToNewsFeed", switchCompat.isChecked());
            }
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i != 4) {
            this.f14708s.f14742o.mo1155a(this, i, i2, intent);
        } else if (i2 == -1) {
            EditGalleryIpcBundle editGalleryIpcBundle = (EditGalleryIpcBundle) intent.getParcelableExtra(EditGalleryIpcBundle.a);
            Builder builder = new Builder(this.f14711v);
            builder.f14759n = editGalleryIpcBundle.e;
            builder = builder;
            builder.f14768w = editGalleryIpcBundle.g;
            this.f14711v = builder.m18670a();
            m18644c(null);
        } else {
            finish();
        }
    }

    public void onBackPressed() {
        if (this.f14708s.f14742o.mo1163d()) {
            StagingGroundController stagingGroundController = this.f14708s;
            AlertDialog.Builder builder = new AlertDialog.Builder(stagingGroundController.f14734g);
            builder.a(true);
            builder.a(2131234589);
            builder.b(2131234583);
            builder.a(2131234597, stagingGroundController.f14742o.mo1160b((FbFragmentActivity) this));
            builder.b(2131234595, new C10756(stagingGroundController));
            builder.a().show();
            return;
        }
        super.onBackPressed();
        this.f14706q.m18652e(this.f14708s.m18661c(), this.f14708s.m18662d(), this.f14708s.m18663e());
    }

    public void onResume() {
        int a = Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_START, 950600499);
        super.onResume();
        if (this.f14708s != null) {
            StagingGroundController stagingGroundController = this.f14708s;
            stagingGroundController.f14742o.mo1165f();
            if (stagingGroundController.f14744q && stagingGroundController.f14743p != null) {
                stagingGroundController.f14744q = false;
                stagingGroundController.f14743p.performClick();
            }
        }
        Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_END, 1062602248, a);
    }

    public void onPause() {
        int a = Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_START, -1209261347);
        super.onPause();
        if (this.f14708s != null) {
            this.f14708s.f14742o.mo1166g();
        }
        Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_END, -353866435, a);
    }
}
