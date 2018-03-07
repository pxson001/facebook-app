package com.facebook.heisman;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;
import android.view.ViewStub;
import com.facebook.analytics.tagging.AnalyticsActivity;
import com.facebook.base.activity.FbFragmentActivity;
import com.facebook.common.identifiers.SafeUUIDGenerator;
import com.facebook.crudolib.urimap.UriMatchPatterns;
import com.facebook.debug.log.BLog;
import com.facebook.heisman.abtest.ExperimentsForProfilePictureOverlayAbTestModule;
import com.facebook.heisman.intent.ProfilePictureOverlayCameraIntentData;
import com.facebook.heisman.protocol.FetchImageOverlayGraphQLModels.ImageOverlayCameraTitleFieldsModel;
import com.facebook.heisman.protocol.imageoverlay.ImageOverlayGraphQLModels.ImageOverlayFieldsModel;
import com.facebook.heisman.protocol.imageoverlay.ImageOverlayGraphQLModels.ImageOverlayFieldsModel.Builder;
import com.facebook.heisman.swipeable.FrameConversions;
import com.facebook.heisman.swipeable.ImageOverlayValidator;
import com.facebook.heisman.swipeable.ProfilePictureOverlaySwipeableFramesLogController;
import com.facebook.inject.FbInjector;
import com.facebook.inject.InjectorLike;
import com.facebook.ipc.creativecam.CreativeCamCaptureInfo;
import com.facebook.ipc.creativecam.CreativeCamDelegate;
import com.facebook.ipc.creativecam.CreativeCamLaunchConfig;
import com.facebook.ipc.creativecam.CreativeCamLauncher;
import com.facebook.ipc.creativecam.controller.CreativeCamPickerPreviewController;
import com.facebook.ipc.creativecam.controller.CreativeCamTopBarController;
import com.facebook.ipc.media.SupportedMediaType;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.photos.creativecam.activity.CreativeCamLauncherImpl;
import com.facebook.photos.creativecam.activity.CreativeEditingCameraFragment;
import com.facebook.photos.creativeediting.model.FrameGraphQLInterfaces.Frame;
import com.facebook.photos.creativeediting.model.FrameGraphQLModels.FrameModel;
import com.facebook.photos.creativeediting.model.FrameGraphQLModels.FramePackModel;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.timeline.abtest.ExperimentsForTimelineAbTestModule;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.util.concurrent.ListenableFuture;
import javax.annotation.Nullable;
import javax.inject.Inject;

@UriMatchPatterns
@TargetApi(16)
/* compiled from: vertical */
public class ProfilePictureOverlayCameraActivity extends FbFragmentActivity implements AnalyticsActivity {
    @Inject
    ProfilePictureOverlayCameraModelStore f620p;
    @Inject
    ProfilePictureOverlayCameraActivityControllerProvider f621q;
    @Inject
    ProfilePictureOverlayCameraActivityResultHandler f622r;
    @Inject
    CreativeCamLauncher f623s;
    @Inject
    QeAccessor f624t;
    private final CreativeCamDelegate f625u = new C00761(this);
    private ProfilePictureOverlayCameraIntentData f626v;
    @Nullable
    public ProfilePictureOverlayCameraActivityController f627w;
    public boolean f628x = false;
    @Nullable
    private ProfilePictureOverlaySwipeableFramesLogController f629y;

    /* compiled from: vertical */
    class C00761 implements CreativeCamDelegate {
        final /* synthetic */ ProfilePictureOverlayCameraActivity f617a;

        C00761(ProfilePictureOverlayCameraActivity profilePictureOverlayCameraActivity) {
            this.f617a = profilePictureOverlayCameraActivity;
        }

        public final void m676a(Uri uri, CreativeCamCaptureInfo creativeCamCaptureInfo) {
            if (this.f617a.f627w != null) {
                this.f617a.f627w.m732a(uri, creativeCamCaptureInfo.c);
            }
        }

        public final void m679b(Uri uri, CreativeCamCaptureInfo creativeCamCaptureInfo) {
            if (this.f617a.f627w != null) {
                this.f617a.f627w.m731a(uri, creativeCamCaptureInfo);
            }
        }

        @Nullable
        public final ListenableFuture<ImmutableList<Frame>> m674a() {
            return this.f617a.f627w.m740d();
        }

        public final CreativeCamPickerPreviewController m678b() {
            return this.f617a.f627w;
        }

        public final CreativeCamTopBarController m680c() {
            return this.f617a.f627w;
        }

        public final ProfilePictureOverlaySwipeableFramesLogController m681d() {
            return ProfilePictureOverlayCameraActivity.m690k(this.f617a);
        }

        public final void m675a(int i) {
        }

        public final void m677a(ViewStub viewStub) {
        }
    }

    private static <T extends Context> void m684a(Class<T> cls, T t) {
        m685a((Object) t, (Context) t);
    }

    public static void m685a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        ((ProfilePictureOverlayCameraActivity) obj).m683a(ProfilePictureOverlayCameraModelStore.m761a(injectorLike), (ProfilePictureOverlayCameraActivityControllerProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(ProfilePictureOverlayCameraActivityControllerProvider.class), ProfilePictureOverlayCameraActivityResultHandler.m749b(injectorLike), (CreativeCamLauncher) CreativeCamLauncherImpl.a(injectorLike), (QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike));
    }

    public final void m692b(@Nullable Bundle bundle) {
        ProfilePictureOverlayCameraIntentData profilePictureOverlayCameraIntentData;
        super.b(bundle);
        Class cls = ProfilePictureOverlayCameraActivity.class;
        m685a((Object) this, (Context) this);
        Intent intent = getIntent();
        if (intent.hasExtra("heisman_camera_intent_data")) {
            profilePictureOverlayCameraIntentData = (ProfilePictureOverlayCameraIntentData) intent.getParcelableExtra("heisman_camera_intent_data");
        } else {
            String str = (String) Preconditions.checkNotNull(intent.getStringExtra("entry_point"));
            String str2 = (String) Preconditions.checkNotNull(intent.getStringExtra("frame_id"));
            Builder builder = new Builder();
            builder.b = str2;
            profilePictureOverlayCameraIntentData = new ProfilePictureOverlayCameraIntentData.Builder(builder.a(), SafeUUIDGenerator.a().toString(), str).a();
        }
        this.f626v = profilePictureOverlayCameraIntentData;
        ProfilePictureOverlayCameraModel c = m687c(bundle);
        if (c == null) {
            c = new ProfilePictureOverlayCameraModel.Builder(ImageOverlayFieldsModel.a(this.f626v.b)).m754a();
        }
        this.f620p.m764a(c);
        this.f627w = this.f621q.m741a(this, this.f626v);
        setContentView(2130906463);
    }

    private void m683a(ProfilePictureOverlayCameraModelStore profilePictureOverlayCameraModelStore, ProfilePictureOverlayCameraActivityControllerProvider profilePictureOverlayCameraActivityControllerProvider, ProfilePictureOverlayCameraActivityResultHandler profilePictureOverlayCameraActivityResultHandler, CreativeCamLauncher creativeCamLauncher, QeAccessor qeAccessor) {
        this.f620p = profilePictureOverlayCameraModelStore;
        this.f621q = profilePictureOverlayCameraActivityControllerProvider;
        this.f622r = profilePictureOverlayCameraActivityResultHandler;
        this.f623s = creativeCamLauncher;
        this.f624t = qeAccessor;
    }

    @Nullable
    private static ProfilePictureOverlayCameraModel m687c(@Nullable Bundle bundle) {
        if (bundle == null) {
            return null;
        }
        return (ProfilePictureOverlayCameraModel) bundle.getParcelable("heisman_saved_camera_model");
    }

    public void onResume() {
        View inflate;
        int a = Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_START, 381557030);
        super.onResume();
        ImageOverlayCameraTitleFieldsModel imageOverlayCameraTitleFieldsModel = this.f626v.c;
        if (this.f620p.m763a().m758g() == null) {
            inflate = ((ViewStub) a(2131566382)).inflate();
        } else {
            inflate = null;
        }
        this.f627w.m735a(imageOverlayCameraTitleFieldsModel, new Runnable(this) {
            final /* synthetic */ ProfilePictureOverlayCameraActivity f619b;

            public void run() {
                if (inflate != null) {
                    inflate.setVisibility(8);
                }
                ProfilePictureOverlayCameraActivity.m689j(this.f619b);
            }
        });
        LogUtils.c(-552865655, a);
    }

    public static void m689j(ProfilePictureOverlayCameraActivity profilePictureOverlayCameraActivity) {
        CreativeEditingCameraFragment creativeEditingCameraFragment;
        Fragment a = profilePictureOverlayCameraActivity.kO_().a("heisman_creative_cam_fragment");
        if (a != null) {
            Preconditions.checkState(a instanceof CreativeEditingCameraFragment);
            creativeEditingCameraFragment = (CreativeEditingCameraFragment) a;
        } else {
            creativeEditingCameraFragment = null;
        }
        if (creativeEditingCameraFragment == null) {
            int i;
            Preconditions.checkArgument(ImageOverlayValidator.b(profilePictureOverlayCameraActivity.f620p.m763a().f689a));
            String f = profilePictureOverlayCameraActivity.f620p.m763a().m757f();
            FrameModel a2 = FrameConversions.a(f, profilePictureOverlayCameraActivity.f620p.m763a().m758g().toString());
            FramePackModel.Builder builder = new FramePackModel.Builder();
            builder.b = ImmutableList.of(a2);
            FramePackModel a3 = builder.a();
            boolean z = profilePictureOverlayCameraActivity.f624t.a(ExperimentsForTimelineAbTestModule.aK, false) && profilePictureOverlayCameraActivity.f624t.a(ExperimentsForProfilePictureOverlayAbTestModule.g, false);
            SupportedMediaType supportedMediaType = z ? SupportedMediaType.ALL : SupportedMediaType.PHOTO_ONLY;
            int a4 = profilePictureOverlayCameraActivity.f624t.a(ExperimentsForTimelineAbTestModule.aR, 7);
            CreativeCamLaunchConfig.Builder builder2 = new CreativeCamLaunchConfig.Builder();
            builder2.b = true;
            builder2 = builder2;
            builder2.c = true;
            builder2 = builder2;
            builder2.d = true;
            builder2 = builder2;
            builder2.h = ImmutableList.of(a3);
            CreativeCamLaunchConfig.Builder builder3 = builder2;
            builder3.i = f;
            CreativeCamLaunchConfig.Builder builder4 = builder3;
            builder4.j = a4 * 1000;
            builder4 = builder4;
            builder4.f = supportedMediaType;
            builder4 = builder4;
            if (profilePictureOverlayCameraActivity.f626v.i() == 1) {
                i = 1;
            } else {
                i = 0;
            }
            builder4.g = i;
            profilePictureOverlayCameraActivity.kO_().a().b(2131558429, profilePictureOverlayCameraActivity.f623s.a(builder4.a(), profilePictureOverlayCameraActivity.f626v.c(), profilePictureOverlayCameraActivity.f626v.h()), "heisman_creative_cam_fragment").c();
        }
    }

    public final void m691a(Fragment fragment) {
        if (fragment instanceof CreativeEditingCameraFragment) {
            ((CreativeEditingCameraFragment) fragment).aQ = this.f625u;
        }
    }

    public static ProfilePictureOverlaySwipeableFramesLogController m690k(ProfilePictureOverlayCameraActivity profilePictureOverlayCameraActivity) {
        if (profilePictureOverlayCameraActivity.f629y == null) {
            profilePictureOverlayCameraActivity.f629y = new ProfilePictureOverlaySwipeableFramesLogController();
            profilePictureOverlayCameraActivity.f629y.a();
        }
        return profilePictureOverlayCameraActivity.f629y;
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        this.f622r.m753a(i, i2, intent, this.f626v, m690k(this), this);
        super.onActivityResult(i, i2, intent);
    }

    public void onBackPressed() {
        if (this.f627w != null) {
            this.f627w.m738b();
        }
        super.onBackPressed();
    }

    public void onSaveInstanceState(Bundle bundle) {
        bundle.putParcelable("heisman_saved_camera_model", this.f620p.m763a());
    }

    public void onDestroy() {
        int a = Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_START, 1446484482);
        super.onDestroy();
        if (this.f627w != null) {
            this.f627w.m739c();
            this.f627w = null;
        }
        if (this.f622r != null) {
            this.f622r.m752a();
        } else {
            BLog.c("ProfilePictureOverlayCameraActivity", "onDestroy() called before onActivityCreate(), resulting in a null dependency");
        }
        this.f628x = true;
        LogUtils.c(562778534, a);
    }

    public final boolean m693i() {
        return this.f628x;
    }

    public final String am_() {
        return "timeline";
    }
}
