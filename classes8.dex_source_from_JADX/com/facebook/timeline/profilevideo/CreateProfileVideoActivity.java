package com.facebook.timeline.profilevideo;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import com.facebook.base.activity.FbFragmentActivity;
import com.facebook.common.identifiers.SafeUUIDGenerator;
import com.facebook.debug.log.BLog;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.ipc.creativecam.CreativeCamLaunchConfig.Builder;
import com.facebook.ipc.creativecam.CreativeCamLauncher;
import com.facebook.ipc.media.SupportedMediaType;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.photos.creativecam.activity.CreativeCamLauncherImpl;
import com.facebook.photos.creativecam.activity.CreativeEditingCameraFragment;
import com.facebook.platform.common.util.PlatformPackageUtilities;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.runtimepermissions.ActivityRuntimePermissionsManager;
import com.facebook.runtimepermissions.ActivityRuntimePermissionsManagerProvider;
import com.facebook.runtimepermissions.RuntimePermissionsManager.RuntimePermissionsListener;
import com.facebook.share.model.ComposerAppAttribution;
import com.facebook.timeline.abtest.ExperimentsForTimelineAbTestModule;
import com.facebook.timeline.profilevideo.logging.ProfileVideoEvent;
import com.facebook.timeline.profilevideo.logging.ProfileVideoSessionTracker;
import com.facebook.timeline.profilevideo.mediastore.ProfileVideoMediaStoreHelper;
import com.facebook.tools.dextr.runtime.detour.HandlerDetour;
import java.io.File;
import javax.annotation.Nullable;
import javax.inject.Inject;

@TargetApi(16)
/* compiled from: mRedSpaceValue */
public class CreateProfileVideoActivity extends FbFragmentActivity {
    private static final String[] f9257w = new String[]{"android.permission.CAMERA", "android.permission.RECORD_AUDIO", "android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE"};
    private ActivityRuntimePermissionsManager f9258A;
    private Handler f9259B;
    private boolean f9260C = true;
    @Inject
    QeAccessor f9261p;
    @Inject
    CreateProfileVideoControllerProvider f9262q;
    @Inject
    ActivityRuntimePermissionsManagerProvider f9263r;
    @Inject
    ProfileVideoSessionTracker f9264s;
    @Inject
    ProfileVideoPreviewLauncherImpl f9265t;
    @Inject
    CreativeCamLauncher f9266u;
    @Inject
    Lazy<PlatformPackageUtilities> f9267v;
    private String f9268x;
    private boolean f9269y = false;
    private CreateProfileVideoController f9270z;

    /* compiled from: mRedSpaceValue */
    class C09601 implements RuntimePermissionsListener {
        final /* synthetic */ CreateProfileVideoActivity f9254a;

        C09601(CreateProfileVideoActivity createProfileVideoActivity) {
            this.f9254a = createProfileVideoActivity;
        }

        public final void m11019a() {
            this.f9254a.setContentView(2130906484);
            String a = ProfileVideoMediaStoreHelper.m11119a(this.f9254a.getContentResolver(), SupportedMediaType.VIDEO_ONLY);
            CreateProfileVideoActivity.m11031b(this.f9254a, this.f9254a.m11022a(a == null ? null : Uri.fromFile(new File(a))));
        }

        public final void m11020a(String[] strArr, String[] strArr2) {
            this.f9254a.finish();
        }

        public final void m11021b() {
            this.f9254a.finish();
        }
    }

    private static <T extends Context> void m11028a(Class<T> cls, T t) {
        m11029a((Object) t, (Context) t);
    }

    public static void m11029a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        ((CreateProfileVideoActivity) obj).m11026a((QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike), (CreateProfileVideoControllerProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(CreateProfileVideoControllerProvider.class), (ActivityRuntimePermissionsManagerProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(ActivityRuntimePermissionsManagerProvider.class), ProfileVideoSessionTracker.m11111a(injectorLike), ProfileVideoPreviewLauncherImpl.m11085b(injectorLike), (CreativeCamLauncher) CreativeCamLauncherImpl.a(injectorLike), IdBasedLazy.a(injectorLike, 9638));
    }

    protected void onSaveInstanceState(Bundle bundle) {
        bundle.putString("session_id", this.f9268x);
        super.onSaveInstanceState(bundle);
    }

    protected final void m11033b(@Nullable Bundle bundle) {
        super.b(bundle);
        Class cls = CreateProfileVideoActivity.class;
        m11029a((Object) this, (Context) this);
        if (bundle == null || !bundle.containsKey("session_id")) {
            this.f9268x = SafeUUIDGenerator.a().toString();
            this.f9264s.m11114a(ProfileVideoEvent.VIDEO_CAMERA_OPEN, this.f9268x);
        } else {
            this.f9268x = bundle.getString("session_id");
        }
        if (this.f9261p.a(ExperimentsForTimelineAbTestModule.aK, false)) {
            this.f9259B = new Handler(Looper.getMainLooper());
            this.f9258A = this.f9263r.a(this);
            this.f9258A.a(f9257w, new C09601(this));
            return;
        }
        BLog.b(CreateProfileVideoActivity.class, "Not in the QE to create profile videos");
        finish();
    }

    protected void onStart() {
        int a = Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_START, 1301388023);
        Fragment a2 = kO_().a(2131558429);
        if (a2 instanceof CreativeEditingCameraFragment) {
            ((CreativeEditingCameraFragment) a2).aQ = this.f9270z;
        }
        super.onStart();
        Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_END, -1972520033, a);
    }

    private Fragment m11022a(Uri uri) {
        return m11030b(uri);
    }

    private Fragment m11030b(Uri uri) {
        int a = this.f9261p.a(ExperimentsForTimelineAbTestModule.aR, 7);
        Builder builder = new Builder();
        builder.b = true;
        builder = builder;
        builder.j = a * 1000;
        Builder builder2 = builder;
        builder2.f = SupportedMediaType.VIDEO_ONLY;
        CreativeEditingCameraFragment a2 = this.f9266u.a(builder2.a(), this.f9268x, null);
        a2.aQ = m11032c(uri);
        return a2;
    }

    private void m11026a(QeAccessor qeAccessor, CreateProfileVideoControllerProvider createProfileVideoControllerProvider, ActivityRuntimePermissionsManagerProvider activityRuntimePermissionsManagerProvider, ProfileVideoSessionTracker profileVideoSessionTracker, ProfileVideoPreviewLauncherImpl profileVideoPreviewLauncherImpl, CreativeCamLauncher creativeCamLauncher, Lazy<PlatformPackageUtilities> lazy) {
        this.f9261p = qeAccessor;
        this.f9262q = createProfileVideoControllerProvider;
        this.f9263r = activityRuntimePermissionsManagerProvider;
        this.f9264s = profileVideoSessionTracker;
        this.f9265t = profileVideoPreviewLauncherImpl;
        this.f9266u = creativeCamLauncher;
        this.f9267v = lazy;
    }

    private CreateProfileVideoController m11032c(Uri uri) {
        if (this.f9270z != null) {
            return this.f9270z;
        }
        InjectorLike injectorLike = this.f9262q;
        this.f9270z = new CreateProfileVideoController(this, this.f9268x, uri, IdBasedSingletonScopeProvider.a(injectorLike, 968), IdBasedProvider.a(injectorLike, 35), ProfileVideoSessionTracker.m11111a(injectorLike), ProfileVideoPreviewLauncherImpl.m11085b(injectorLike), (QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike), IdBasedSingletonScopeProvider.b(injectorLike, 28));
        return this.f9270z;
    }

    protected void onResume() {
        int a = Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_START, -626297403);
        super.onResume();
        setRequestedOrientation(1);
        Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_END, -70195668, a);
    }

    protected void onDestroy() {
        int a = Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_START, 819667860);
        super.onDestroy();
        this.f9269y = true;
        Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_END, -1239479211, a);
    }

    public static void m11031b(CreateProfileVideoActivity createProfileVideoActivity, final Fragment fragment) {
        if (createProfileVideoActivity.f9260C && !createProfileVideoActivity.isFinishing() && !createProfileVideoActivity.f9269y) {
            if (createProfileVideoActivity.kO_().c()) {
                createProfileVideoActivity.kO_().a().b(2131558429, fragment).b();
                createProfileVideoActivity.f9260C = false;
                return;
            }
            HandlerDetour.a(createProfileVideoActivity.f9259B, new Runnable(createProfileVideoActivity) {
                final /* synthetic */ CreateProfileVideoActivity f9256b;

                public void run() {
                    CreateProfileVideoActivity.m11031b(this.f9256b, fragment);
                }
            }, -2033027429);
        }
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        switch (i) {
            case 1:
                if (i2 == -1) {
                    this.f9264s.m11114a(ProfileVideoEvent.USER_CREATION_FINISHED, this.f9268x);
                    setResult(-1);
                    finish();
                    return;
                }
                return;
            case 2:
                if (i2 == -1) {
                    m11025a(intent, null);
                    return;
                }
                return;
            case 5:
                if (i2 != -1) {
                    this.f9264s.m11114a(ProfileVideoEvent.DEEP_LINK_FLOW_CANCELED, this.f9268x);
                    return;
                }
                this.f9264s.m11114a(ProfileVideoEvent.DEEP_LINK_FLOW_SUCCESS, this.f9268x);
                m11025a(intent, m11024a(intent, "com.instagram.boomerang"));
                return;
            case 6:
                if (i2 != -1) {
                    this.f9264s.m11114a(ProfileVideoEvent.DEEP_LINK_FLOW_CANCELED, this.f9268x);
                    return;
                }
                this.f9264s.m11114a(ProfileVideoEvent.DEEP_LINK_FLOW_SUCCESS, this.f9268x);
                m11025a(intent, m11024a(intent, "me.msqrd.android"));
                return;
            default:
                return;
        }
    }

    @Nullable
    private ComposerAppAttribution m11024a(Intent intent, String str) {
        Object stringExtra = intent.getStringExtra("proxied_app_id");
        Object a = ((PlatformPackageUtilities) this.f9267v.get()).a(str, 0);
        if (TextUtils.isEmpty(stringExtra) || TextUtils.isEmpty(a)) {
            return null;
        }
        return new ComposerAppAttribution(stringExtra, "", a, "");
    }

    private void m11025a(Intent intent, @Nullable ComposerAppAttribution composerAppAttribution) {
        Uri data = intent.getData();
        if (data != null) {
            this.f9265t.mo53a(this, this.f9268x, data, 4, 1, null, composerAppAttribution, 0);
        }
    }
}
