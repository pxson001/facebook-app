package com.facebook.timeline.stagingground;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import com.facebook.base.activity.FbFragmentActivity;
import com.facebook.common.android.PackageManagerMethodAutoProvider;
import com.facebook.common.android.String_PackageNameMethodAutoProvider;
import com.facebook.common.init.INeedInit;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.debug.log.BLog;
import com.facebook.inject.FbInjector;
import com.facebook.inject.InjectorLike;
import com.facebook.ipc.editgallery.CropMode;
import com.facebook.ipc.editgallery.EditFeature;
import com.facebook.ipc.editgallery.EditGalleryIpcBundle;
import com.facebook.ipc.editgallery.EditGalleryLaunchConfiguration;
import com.facebook.ipc.editgallery.EntryPoint;
import com.facebook.photos.base.media.MediaItemFactory.FallbackMediaId;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.timeline.abtest.ExperimentsForTimelineAbTestModule;
import com.facebook.timeline.intent.TimelineIntentFactory;
import com.facebook.timeline.stagingground.StagingGroundLaunchConfig.Builder;
import com.facebook.ultralight.Inject;
import javax.annotation.Nullable;

/* compiled from: like */
public class ProfilePictureShareActivity extends FbFragmentActivity {
    @Inject
    private SecureContextHelper f11468p;
    @Inject
    private TimelineIntentFactory f11469q;
    @Inject
    private QeAccessor f11470r;
    private Uri f11471s;
    private boolean f11472t;

    /* compiled from: like */
    public class InitOnBoot implements INeedInit {
        private final QeAccessor f9362a;
        private final PackageManager f9363b;
        private final String f9364c;

        public static InitOnBoot m9754b(InjectorLike injectorLike) {
            return new InitOnBoot((QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike), PackageManagerMethodAutoProvider.a(injectorLike), String_PackageNameMethodAutoProvider.a(injectorLike));
        }

        public static InitOnBoot m9753a(InjectorLike injectorLike) {
            return m9754b(injectorLike);
        }

        @Inject
        private InitOnBoot(QeAccessor qeAccessor, PackageManager packageManager, String str) {
            this.f9362a = qeAccessor;
            this.f9363b = packageManager;
            this.f9364c = str;
        }

        public void init() {
            if (this.f9362a.a(ExperimentsForTimelineAbTestModule.e, false)) {
                this.f9363b.setComponentEnabledSetting(new ComponentName(this.f9364c, ProfilePictureShareActivity.class.getName()), 1, 1);
            } else {
                this.f9363b.setComponentEnabledSetting(new ComponentName(this.f9364c, ProfilePictureShareActivity.class.getName()), 2, 1);
            }
        }
    }

    private static <T extends Context> void m11961a(Class<T> cls, T t) {
        m11962a((Object) t, (Context) t);
    }

    public static void m11962a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((ProfilePictureShareActivity) obj).m11960a((SecureContextHelper) DefaultSecureContextHelper.a(fbInjector), TimelineIntentFactory.b(fbInjector), (QeAccessor) QeInternalImplMethodAutoProvider.a(fbInjector));
    }

    protected final void m11964a(Bundle bundle) {
        Class cls = ProfilePictureShareActivity.class;
        m11962a((Object) this, (Context) this);
    }

    protected final void m11965b(@Nullable Bundle bundle) {
        super.b(bundle);
        if (bundle != null && bundle.containsKey("uri_key") && bundle.containsKey("has_launched_preview_key")) {
            this.f11471s = (Uri) bundle.getParcelable("uri_key");
            this.f11472t = bundle.getBoolean("has_launched_preview_key");
        } else {
            this.f11471s = (Uri) getIntent().getParcelableExtra("android.intent.extra.STREAM");
            this.f11472t = false;
        }
        if (this.f11471s == null) {
            m11963a("Image Uri is NULL", new Object[0]);
        } else if (!this.f11472t) {
            Builder a = new Builder().a(this.f11471s, Long.toString(FallbackMediaId.REMOTE_MEDIA.getValue()));
            a.d = EntryPoint.NATIVE_SHARE_SHEET.name();
            a = a;
            a.p = false;
            a = a;
            a.r = this.f11470r.a(ExperimentsForTimelineAbTestModule.k, false);
            a = a;
            a.s = this.f11470r.a(ExperimentsForTimelineAbTestModule.l, false);
            StagingGroundLaunchConfig a2 = a.a();
            EditGalleryLaunchConfiguration.Builder a3 = new EditGalleryLaunchConfiguration.Builder().a(this.f11471s, Long.toString(FallbackMediaId.REMOTE_MEDIA.getValue())).a(EditFeature.CROP).a(CropMode.ZOOM_CROP);
            a3.h = false;
            Intent a4 = StagingGroundIntentFactory.a(this, a2, a3.a());
            this.f11472t = true;
            this.f11468p.a(a4, 1001, this);
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        bundle.putParcelable("uri_key", this.f11471s);
        bundle.putBoolean("has_launched_preview_key", this.f11472t);
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        if (i2 != -1) {
            finish();
            return;
        }
        Intent a = this.f11469q.a((EditGalleryIpcBundle) intent.getParcelableExtra(EditGalleryIpcBundle.a), null, intent.getLongExtra("extra_profile_pic_expiration", 0), intent.getStringExtra("staging_ground_photo_caption"), "upload");
        if (a == null) {
            m11963a("Failed to obtain logged in user", new Object[0]);
            return;
        }
        a.putExtra("force_create_new_activity", true);
        this.f11468p.a(a, this);
        finish();
    }

    private void m11963a(String str, Object... objArr) {
        BLog.b(ProfilePictureShareActivity.class.getCanonicalName(), str, objArr);
        finish();
    }

    private void m11960a(SecureContextHelper secureContextHelper, TimelineIntentFactory timelineIntentFactory, QeAccessor qeAccessor) {
        this.f11468p = secureContextHelper;
        this.f11469q = timelineIntentFactory;
        this.f11470r = qeAccessor;
    }
}
