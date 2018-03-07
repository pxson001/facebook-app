package com.facebook.timeline.profilevideo;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.base.activity.FbFragmentActivity;
import com.facebook.common.executors.BackgroundExecutorService;
import com.facebook.common.executors.ListeningExecutorService_BackgroundExecutorServiceMethodAutoProvider;
import com.facebook.common.references.CloseableReference;
import com.facebook.debug.log.BLog;
import com.facebook.inject.FbInjector;
import com.facebook.inject.InjectorLike;
import com.facebook.ipc.videoeditgallery.VideoEditGalleryLaunchConfiguration;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.timeline.abtest.ExperimentsForTimelineAbTestModule;
import com.facebook.timeline.profilevideo.logging.ProfileVideoEvent;
import com.facebook.timeline.profilevideo.logging.ProfileVideoSessionTracker;
import com.facebook.timeline.profilevideo.model.ProfileVideoModel;
import com.facebook.timeline.profilevideo.model.ProfileVideoModel.Builder;
import com.facebook.timeline.profilevideo.model.ProfileVideoModelStore;
import com.facebook.timeline.profilevideo.upload.ProfileVideoUploader;
import com.facebook.timeline.profilevideo.upload.ProfileVideoUploader.C09881;
import com.facebook.timeline.profilevideo.upload.ProfileVideoUploader.C09892;
import com.facebook.timeline.profilevideo.upload.ProfileVideoUploader.C09903;
import com.facebook.tools.dextr.runtime.detour.ExecutorDetour;
import com.facebook.video.creativeediting.VideoEditGalleryFragmentManager;
import com.facebook.video.creativeediting.VideoEditGalleryFragmentManager.VideoEditGalleryCallback;
import com.facebook.video.creativeediting.analytics.VideoCreativeEditingLogger;
import com.facebook.video.creativeediting.analytics.VideoEditingGalleryEntryPoint;
import com.facebook.video.creativeediting.model.VideoCreativeEditingData;
import com.facebook.widget.titlebar.FbTitleBar;
import com.facebook.widget.titlebar.FbTitleBar.OnToolbarButtonListener;
import com.facebook.widget.titlebar.FbTitleBarUtil;
import com.facebook.widget.titlebar.TitleBarButtonSpec;
import com.facebook.widget.titlebar.TitleBarButtonSpecCache;
import com.facebook.widget.titlebar.TitleBarButtonSpecCacheProvider;
import com.google.common.util.concurrent.Futures;
import java.io.File;
import java.util.concurrent.ExecutorService;
import javax.inject.Inject;

@TargetApi(10)
/* compiled from: mPulsarAdvertismentIndicator */
public final class ProfileVideoPreviewActivity extends FbFragmentActivity implements ProfileVideoModelStore {
    public String f9304A;
    private VideoEditGalleryFragmentManager f9305B;
    private int f9306C;
    private final OnClickListener f9307D = new C09691(this);
    private final VideoEditGalleryCallback f9308E = new C09702(this);
    @Inject
    FbTitleBarUtil f9309p;
    @Inject
    ProfileVideoUploader f9310q;
    @BackgroundExecutorService
    @Inject
    ExecutorService f9311r;
    @Inject
    ProfileVideoSessionTracker f9312s;
    @Inject
    QeAccessor f9313t;
    @Inject
    VideoCreativeEditingLogger f9314u;
    @Inject
    TitleBarButtonSpecCacheProvider f9315v;
    private TitleBarButtonSpecCache f9316w;
    public ProfileVideoModel f9317x;
    public ProfileVideoEditFragment f9318y;
    private FbTitleBar f9319z;

    /* compiled from: mPulsarAdvertismentIndicator */
    class C09691 implements OnClickListener {
        final /* synthetic */ ProfileVideoPreviewActivity f9299a;

        C09691(ProfileVideoPreviewActivity profileVideoPreviewActivity) {
            this.f9299a = profileVideoPreviewActivity;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 675340118);
            this.f9299a.onBackPressed();
            Logger.a(2, EntryType.UI_INPUT_END, -87006605, a);
        }
    }

    /* compiled from: mPulsarAdvertismentIndicator */
    class C09702 implements VideoEditGalleryCallback {
        final /* synthetic */ ProfileVideoPreviewActivity f9300a;

        C09702(ProfileVideoPreviewActivity profileVideoPreviewActivity) {
            this.f9300a = profileVideoPreviewActivity;
        }

        public final void m11058a(VideoCreativeEditingData videoCreativeEditingData, int i) {
            if (this.f9300a.f9317x != null) {
                ProfileVideoPreviewActivity profileVideoPreviewActivity = this.f9300a;
                Builder m = this.f9300a.f9317x.m11136m();
                m.f9364e = videoCreativeEditingData;
                profileVideoPreviewActivity.f9317x = m.m11121a();
                ProfileVideoPreviewActivity.m11069b(this.f9300a, true);
            }
        }

        public final void m11057a(int i) {
            this.f9300a.onBackPressed();
        }
    }

    /* compiled from: mPulsarAdvertismentIndicator */
    class C09724 extends OnToolbarButtonListener {
        final /* synthetic */ ProfileVideoPreviewActivity f9303a;

        C09724(ProfileVideoPreviewActivity profileVideoPreviewActivity) {
            this.f9303a = profileVideoPreviewActivity;
        }

        public final void m11059a(View view, TitleBarButtonSpec titleBarButtonSpec) {
            CloseableReference closeableReference = this.f9303a.f9318y.aq;
            if (closeableReference != null) {
                view.setEnabled(false);
                ProfileVideoUploader profileVideoUploader = this.f9303a.f9310q;
                ProfileVideoModel i = this.f9303a.mo598i();
                String str = this.f9303a.f9304A;
                if (profileVideoUploader.f9463e == null || profileVideoUploader.f9463e.mIsPageContext) {
                    profileVideoUploader.f9464f.a("not_valid_vc", "User VC must be set");
                } else {
                    Futures.a(Futures.b(profileVideoUploader.f9468j.a(new C09903(profileVideoUploader, i)), new C09881(profileVideoUploader, i, closeableReference.b(), str)), new C09892(profileVideoUploader, str), profileVideoUploader.f9469k);
                }
                this.f9303a.f9312s.m11116a(this.f9303a.f9304A, (long) this.f9303a.mo598i().f9370c);
                this.f9303a.setResult(-1);
                this.f9303a.finish();
            }
        }
    }

    private static <T extends Context> void m11066a(Class<T> cls, T t) {
        m11067a((Object) t, (Context) t);
    }

    public static void m11067a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        ((ProfileVideoPreviewActivity) obj).m11065a(FbTitleBarUtil.a(injectorLike), ProfileVideoUploader.m11194a(injectorLike), (ExecutorService) ListeningExecutorService_BackgroundExecutorServiceMethodAutoProvider.a(injectorLike), ProfileVideoSessionTracker.m11111a(injectorLike), (QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike), VideoCreativeEditingLogger.b(injectorLike), (TitleBarButtonSpecCacheProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(TitleBarButtonSpecCacheProvider.class));
    }

    private void m11065a(FbTitleBarUtil fbTitleBarUtil, ProfileVideoUploader profileVideoUploader, ExecutorService executorService, ProfileVideoSessionTracker profileVideoSessionTracker, QeAccessor qeAccessor, VideoCreativeEditingLogger videoCreativeEditingLogger, TitleBarButtonSpecCacheProvider titleBarButtonSpecCacheProvider) {
        this.f9309p = fbTitleBarUtil;
        this.f9310q = profileVideoUploader;
        this.f9311r = executorService;
        this.f9312s = profileVideoSessionTracker;
        this.f9313t = qeAccessor;
        this.f9314u = videoCreativeEditingLogger;
        this.f9315v = titleBarButtonSpecCacheProvider;
    }

    public final void m11075b(Bundle bundle) {
        super.b(bundle);
        Class cls = ProfileVideoPreviewActivity.class;
        m11067a((Object) this, (Context) this);
        if (bundle != null) {
            this.f9317x = (ProfileVideoModel) bundle.getParcelable("profile_video_model");
            this.f9304A = bundle.getString("session_id");
        } else {
            this.f9304A = getIntent().getStringExtra("session_id");
            this.f9317x = (ProfileVideoModel) getIntent().getParcelableExtra("video_model");
            if (this.f9317x == null) {
                BLog.b(ProfileVideoPreviewActivity.class, "Video Model must be set");
                finish();
                return;
            }
            Builder m;
            VideoCreativeEditingData videoCreativeEditingData = (VideoCreativeEditingData) getIntent().getParcelableExtra("video_edit_data");
            if (videoCreativeEditingData != null) {
                m = this.f9317x.m11136m();
                m.f9364e = videoCreativeEditingData;
                this.f9317x = m.m11121a();
            }
            String stringExtra = getIntent().getStringExtra("video_caption");
            long longExtra = getIntent().getLongExtra("video_expiration", 0);
            m = this.f9317x.m11136m();
            m.f9365f = stringExtra;
            Builder builder = m;
            builder.f9366g = longExtra;
            this.f9317x = builder.m11121a();
        }
        setContentView(2130906482);
        m11071j();
        this.f9305B = new VideoEditGalleryFragmentManager(kO_());
        if (m11073l() || (bundle != null && bundle.getInt("current_fragment_id") == 2)) {
            m11069b(this, false);
        } else {
            m11072k();
        }
    }

    public final void onSaveInstanceState(Bundle bundle) {
        bundle.putParcelable("profile_video_model", this.f9317x);
        bundle.putInt("current_fragment_id", this.f9306C);
        bundle.putString("session_id", this.f9304A);
        super.onSaveInstanceState(bundle);
    }

    public final void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        if (bundle.getInt("current_fragment_id") == 1) {
            this.f9305B.a(this.f9308E);
        }
    }

    protected final void onResume() {
        int a = Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_START, 1967533037);
        super.onResume();
        setRequestedOrientation(1);
        Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_END, 373329779, a);
    }

    public final void onBackPressed() {
        if (this.f9306C != 2 || m11073l()) {
            if (1 == this.f9317x.f9371d || 2 == this.f9317x.f9371d) {
                final String b = this.f9317x.m11125b();
                ExecutorDetour.a(this.f9311r, new Runnable(this) {
                    final /* synthetic */ ProfileVideoPreviewActivity f9302b;

                    public void run() {
                        new File(b).delete();
                    }
                }, -239605412);
            }
            this.f9312s.m11114a(ProfileVideoEvent.PREVIEW_CLOSED, this.f9304A);
            setResult(0);
            finish();
            return;
        }
        this.f9312s.m11114a(ProfileVideoEvent.SCRUBBER_CLOSED, this.f9304A);
        m11072k();
    }

    public final ProfileVideoModel mo598i() {
        return this.f9317x;
    }

    public final void mo597a(ProfileVideoModel profileVideoModel) {
        this.f9317x = profileVideoModel;
    }

    private void m11071j() {
        FbTitleBarUtil.b(this);
        this.f9319z = (FbTitleBar) a(2131558563);
        this.f9319z.a(this.f9307D);
    }

    private void m11072k() {
        if (this.f9306C != 1) {
            this.f9312s.m11114a(ProfileVideoEvent.PREVIEW_OPENED, this.f9304A);
            this.f9306C = 1;
            int a = this.f9313t.a(ExperimentsForTimelineAbTestModule.aR, 7);
            VideoEditGalleryLaunchConfiguration.Builder builder = new VideoEditGalleryLaunchConfiguration.Builder();
            builder.b = this.f9304A;
            builder = builder;
            builder.c = this.f9317x.f9372e;
            builder = builder;
            builder.e = false;
            builder = builder;
            builder.g = true;
            builder = builder;
            builder.d = true;
            builder = builder;
            builder.k = 2131239225;
            builder = builder;
            builder.j = a * 1000;
            VideoEditGalleryLaunchConfiguration.Builder builder2 = builder;
            builder2.h = true;
            VideoEditGalleryLaunchConfiguration a2 = builder2.a();
            this.f9314u.a(this.f9317x.m11125b(), VideoEditingGalleryEntryPoint.PROFILE_VIDEO, this.f9304A);
            this.f9305B.a(a2, this.f9317x.f9368a, this.f9308E, VideoEditingGalleryEntryPoint.PROFILE_VIDEO, null);
        }
    }

    public static void m11069b(ProfileVideoPreviewActivity profileVideoPreviewActivity, boolean z) {
        if (profileVideoPreviewActivity.f9306C != 2) {
            profileVideoPreviewActivity.f9312s.m11117a(profileVideoPreviewActivity.f9304A, profileVideoPreviewActivity.mo598i());
            profileVideoPreviewActivity.f9306C = 2;
            Fragment a = profileVideoPreviewActivity.kO_().a(2131558429);
            if (a instanceof ProfileVideoEditFragment) {
                profileVideoPreviewActivity.f9318y = (ProfileVideoEditFragment) a;
            }
            if (profileVideoPreviewActivity.f9318y == null) {
                String str = profileVideoPreviewActivity.f9304A;
                ProfileVideoEditFragment profileVideoEditFragment = new ProfileVideoEditFragment();
                Bundle bundle = new Bundle();
                bundle.putString("session_id", str);
                profileVideoEditFragment.g(bundle);
                profileVideoPreviewActivity.f9318y = profileVideoEditFragment;
            }
            if (profileVideoPreviewActivity.f9316w == null) {
                profileVideoPreviewActivity.f9316w = profileVideoPreviewActivity.f9315v.a(2131234496);
            }
            profileVideoPreviewActivity.f9319z.setButtonSpecs(profileVideoPreviewActivity.f9316w.a());
            profileVideoPreviewActivity.f9319z.setTitle(2131239228);
            profileVideoPreviewActivity.f9319z.setOnToolbarButtonListener(new C09724(profileVideoPreviewActivity));
            profileVideoPreviewActivity.kO_().a().b(2131558429, profileVideoPreviewActivity.f9318y).b();
            if (z) {
                profileVideoPreviewActivity.f9318y.m11053b();
            }
        }
    }

    private boolean m11073l() {
        if (this.f9313t.a(ExperimentsForTimelineAbTestModule.aQ, false) || (mo598i() != null && mo598i().f9372e != null && mo598i().f9372e.f() != null)) {
            return true;
        }
        return false;
    }
}
