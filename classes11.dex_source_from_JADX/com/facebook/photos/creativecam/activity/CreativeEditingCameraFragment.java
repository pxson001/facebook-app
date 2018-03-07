package com.facebook.photos.creativecam.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.RectF;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.ProgressBar;
import com.facebook.base.fragment.FbFragment;
import com.facebook.common.executors.ForUiThread;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.common.time.AwakeTimeSinceBootClockMethodAutoProvider;
import com.facebook.common.time.MonotonicClock;
import com.facebook.common.util.ContextUtils;
import com.facebook.common.util.FindViewUtil;
import com.facebook.common.util.SizeUtil;
import com.facebook.debug.log.BLog;
import com.facebook.drawee.drawable.ScalingUtils.ScaleType;
import com.facebook.drawee.fbpipeline.FbDraweeControllerBuilder;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.fbui.widget.text.caps.AllCapsTransformationMethod;
import com.facebook.imagepipeline.common.ResizeOptions;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.ipc.creativecam.CreativeCamCaptureInfo;
import com.facebook.ipc.creativecam.CreativeCamDelegate;
import com.facebook.ipc.creativecam.CreativeCamLaunchConfig;
import com.facebook.ipc.creativecam.CreativeCamMediaSource;
import com.facebook.ipc.creativecam.CreativeCamSource;
import com.facebook.ipc.creativecam.controller.CreativeCamPickerPreviewController;
import com.facebook.ipc.creativecam.controller.CreativeCamTopBarController;
import com.facebook.ipc.media.MediaItem;
import com.facebook.ipc.media.SupportedMediaType;
import com.facebook.ipc.simplepicker.SimplePickerIntent;
import com.facebook.ipc.simplepicker.SimplePickerLauncherConfiguration;
import com.facebook.ipc.simplepicker.SimplePickerLauncherConfiguration.Action;
import com.facebook.ipc.simplepicker.SimplePickerSource;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.optic.CameraDevice.CameraFacing;
import com.facebook.optic.CameraPreviewView;
import com.facebook.optic.PhotoCaptureInfo;
import com.facebook.photos.creativecam.ui.CameraPreviewController;
import com.facebook.photos.creativecam.ui.CameraPreviewController.1;
import com.facebook.photos.creativecam.ui.CameraPreviewController.3;
import com.facebook.photos.creativecam.ui.CameraPreviewController.8;
import com.facebook.photos.creativecam.ui.CameraPreviewControllerProvider;
import com.facebook.photos.creativecam.ui.CreativeCamCaptureButton;
import com.facebook.photos.creativecam.ui.CreativeCamCaptureButton.CaptureType;
import com.facebook.photos.creativecam.ui.CreativeCamPhotoVideoSwitch;
import com.facebook.photos.creativecam.ui.CreativeCamPhotoVideoSwitch.OnToggleListener;
import com.facebook.photos.creativecam.ui.CreativeCamPickerPreviewControllerImpl;
import com.facebook.photos.creativecam.ui.CreativeCamSwipeableController;
import com.facebook.photos.creativecam.ui.CreativeCamSwipeableController.2;
import com.facebook.photos.creativecam.ui.CreativeCamSwipeableControllerProvider;
import com.facebook.photos.creativecam.ui.CreativeCamTopBarControllerImpl;
import com.facebook.photos.creativecam.ui.FlashButtonController;
import com.facebook.photos.creativecam.ui.FlashButtonControllerProvider;
import com.facebook.photos.creativecam.ui.FocusView;
import com.facebook.photos.creativecam.ui.MultiStateToggleImageButton;
import com.facebook.photos.creativecam.ui.PhotoPreviewController;
import com.facebook.photos.creativecam.ui.PhotoPreviewController.CameraImageScaleType;
import com.facebook.photos.creativecam.ui.PhotoPreviewControllerProvider;
import com.facebook.photos.creativecam.ui.ProgressBarController;
import com.facebook.photos.creativecam.ui.ProgressBarControllerProvider;
import com.facebook.photos.creativeediting.analytics.CreativeEditingLogger;
import com.facebook.photos.creativeediting.model.FrameGraphQLInterfaces.Frame;
import com.facebook.photos.creativeediting.model.FrameGraphQLInterfaces.FramePack;
import com.facebook.photos.creativeediting.model.FrameGraphQLModels.FramePackModel;
import com.facebook.photos.creativeediting.swipeable.common.SwipeableFramesHScrollCirclePageIndicator;
import com.facebook.photos.creativeediting.swipeable.composer.CreativeEditingSwipeableLayout;
import com.facebook.productionprompts.common.PromptPublishIntentHelper;
import com.facebook.productionprompts.logging.PromptAnalytics;
import com.facebook.productionprompts.model.ProductionPromptObject;
import com.facebook.resources.ui.FbTextView;
import com.facebook.runtimepermissions.ActivityRuntimePermissionsManagerProvider;
import com.facebook.runtimepermissions.RuntimePermissionsManager.RuntimePermissionsListener;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.ui.choreographer.ChoreographerWrapper;
import com.facebook.ui.choreographer.DefaultChoreographerWrapper;
import com.facebook.ui.toaster.ToastBuilder;
import com.facebook.ui.toaster.Toaster;
import com.facebook.ultralight.Inject;
import com.facebook.ultralight.UltralightRuntime;
import com.facebook.widget.text.BetterTextView;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.collect.RegularImmutableList;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
import javax.inject.Provider;

/* compiled from: TouchTargetHelper should not allow calling this method when pointer events are NONE */
public class CreativeEditingCameraFragment extends FbFragment {
    public static final String f10570c = CreativeEditingCameraFragment.class.getSimpleName();
    public static final String[] f10571d = new String[]{"android.permission.CAMERA", "android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE"};
    public static final String[] f10572e = new String[]{"android.permission.CAMERA", "android.permission.RECORD_AUDIO", "android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE"};
    @Inject
    public volatile Provider<CreativeCamPickerPreviewControllerImpl> f10573a = UltralightRuntime.a;
    public PhotoPreviewControllerProvider aA;
    private PhotoPreviewController aB;
    public CreativeCamSwipeableControllerProvider aC;
    public CreativeCamSwipeableController aD;
    private FlashButtonControllerProvider aE;
    @Nullable
    public FlashButtonController aF;
    private ProgressBarControllerProvider aG;
    public ProgressBarController aH;
    public SwipeableFramesHScrollCirclePageIndicator aI;
    @Nullable
    public Uri aJ;
    @Nullable
    public Uri aK;
    private AllCapsTransformationMethod aL;
    @ForUiThread
    public Executor aM;
    public boolean aN;
    @Nullable
    private MediaItem aO;
    public SupportedMediaType aP;
    public CreativeCamDelegate aQ;
    public CameraPreviewView aR;
    public CreativeCamSource aS;
    public CreativeCamTopBarController aT;
    public CreativeCamPickerPreviewController aU;
    public String aV;
    public int aW;
    public final C12351 aX = new C12351(this);
    public BetterTextView al;
    public BetterTextView am;
    public FbDraweeView an;
    public CreativeCamCaptureButton ao;
    private ViewStub ap;
    public ViewGroup aq;
    public CreativeCamLaunchConfig ar;
    @Nullable
    public ImmutableList<Frame> as;
    @Nullable
    public ImmutableList<FramePack> at;
    public CreativeEditingLogger au;
    @Nullable
    private PromptAnalytics av;
    public ActivityRuntimePermissionsManagerProvider aw;
    public Toaster ax;
    public CameraPreviewControllerProvider ay;
    public CameraPreviewController az;
    @Inject
    public volatile Provider<CreativeCamTopBarControllerImpl> f10574b = UltralightRuntime.a;
    private View f10575f;
    private View f10576g;
    private View f10577h;
    public CreativeCamPhotoVideoSwitch f10578i;

    /* compiled from: TouchTargetHelper should not allow calling this method when pointer events are NONE */
    public class C12351 {
        final /* synthetic */ CreativeEditingCameraFragment f10560a;

        C12351(CreativeEditingCameraFragment creativeEditingCameraFragment) {
            this.f10560a = creativeEditingCameraFragment;
        }

        public final void m11058a() {
            if (this.f10560a.ao() != null) {
                this.f10560a.ao().setResult(0, CreativeEditingCameraFragment.aD(this.f10560a));
                this.f10560a.ao().finish();
            }
        }

        public final void m11059b() {
            CameraPreviewController cameraPreviewController = this.f10560a.az;
            cameraPreviewController.c.a(new 3(cameraPreviewController));
        }
    }

    /* compiled from: TouchTargetHelper should not allow calling this method when pointer events are NONE */
    public class C12362 implements RuntimePermissionsListener {
        final /* synthetic */ CreativeEditingCameraFragment f10561a;

        public C12362(CreativeEditingCameraFragment creativeEditingCameraFragment) {
            this.f10561a = creativeEditingCameraFragment;
        }

        public final void m11061a() {
            CreativeEditingCameraFragment.at(this.f10561a);
        }

        public final void m11062a(String[] strArr, String[] strArr2) {
            m11060c();
        }

        public final void m11063b() {
            m11060c();
        }

        private void m11060c() {
            this.f10561a.ax.a(new ToastBuilder(2131234473));
            if (this.f10561a.aX != null) {
                this.f10561a.aX.m11058a();
            }
        }
    }

    /* compiled from: TouchTargetHelper should not allow calling this method when pointer events are NONE */
    class C12383 implements Runnable {
        final /* synthetic */ CreativeEditingCameraFragment f10563a;

        /* compiled from: TouchTargetHelper should not allow calling this method when pointer events are NONE */
        class C12371 extends AbstractDisposableFutureCallback<ImmutableList<Frame>> {
            final /* synthetic */ C12383 f10562a;

            C12371(C12383 c12383) {
                this.f10562a = c12383;
            }

            public final void m11064a(Object obj) {
                ImmutableList immutableList = (ImmutableList) obj;
                CreativeCamSwipeableController creativeCamSwipeableController = this.f10562a.f10563a.aD;
                boolean z = (creativeCamSwipeableController.n == null || creativeCamSwipeableController.n.isEmpty()) ? false : true;
                Preconditions.checkState(z);
                creativeCamSwipeableController.l.b(immutableList, new 2(creativeCamSwipeableController), null);
            }

            public final void m11065a(Throwable th) {
                BLog.b(CreativeEditingCameraFragment.f10570c, "loadMoreFrames failed", th);
            }
        }

        C12383(CreativeEditingCameraFragment creativeEditingCameraFragment) {
            this.f10563a = creativeEditingCameraFragment;
        }

        public void run() {
            this.f10563a.aT.a(this.f10563a.aq, this.f10563a.as);
            if (!this.f10563a.aN) {
                CreativeEditingCameraFragment.aE(this.f10563a);
            }
            ListenableFuture a = this.f10563a.aQ.a();
            if (a != null) {
                Futures.a(a, new C12371(this), this.f10563a.aM);
            }
        }
    }

    /* compiled from: TouchTargetHelper should not allow calling this method when pointer events are NONE */
    public class C12394 implements OnToggleListener {
        final /* synthetic */ CreativeEditingCameraFragment f10564a;

        public C12394(CreativeEditingCameraFragment creativeEditingCameraFragment) {
            this.f10564a = creativeEditingCameraFragment;
        }

        public final void m11066a(int i) {
            if (i == 0) {
                CreativeEditingCameraFragment.aw(this.f10564a);
            } else {
                CreativeEditingCameraFragment.ax(this.f10564a);
            }
            this.f10564a.aW = i;
            CreativeEditingCameraFragment.au(this.f10564a);
        }
    }

    /* compiled from: TouchTargetHelper should not allow calling this method when pointer events are NONE */
    public class C12405 implements OnClickListener {
        final /* synthetic */ CreativeEditingCameraFragment f10565a;

        public C12405(CreativeEditingCameraFragment creativeEditingCameraFragment) {
            this.f10565a = creativeEditingCameraFragment;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 1165477145);
            if (this.f10565a.aU.a(this.f10565a.aD.a(), this.f10565a.aW)) {
                Logger.a(2, EntryType.UI_INPUT_END, -534386746, a);
                return;
            }
            this.f10565a.au.f(this.f10565a.aS);
            CreativeEditingCameraFragment.aF(this.f10565a);
            LogUtils.a(-940421589, a);
        }
    }

    /* compiled from: TouchTargetHelper should not allow calling this method when pointer events are NONE */
    public class C12416 implements OnClickListener {
        final /* synthetic */ CreativeEditingCameraFragment f10566a;

        public C12416(CreativeEditingCameraFragment creativeEditingCameraFragment) {
            this.f10566a = creativeEditingCameraFragment;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -32487222);
            this.f10566a.m11078b();
            CameraPreviewController cameraPreviewController = this.f10566a.az;
            CameraPreviewController.a(this.f10566a.aK);
            cameraPreviewController = this.f10566a.az;
            CameraPreviewController.a(this.f10566a.aJ);
            this.f10566a.au.e(this.f10566a.aS);
            Logger.a(2, EntryType.UI_INPUT_END, 1275687937, a);
        }
    }

    /* compiled from: TouchTargetHelper should not allow calling this method when pointer events are NONE */
    public class C12427 implements OnClickListener {
        final /* synthetic */ CreativeEditingCameraFragment f10567a;

        public C12427(CreativeEditingCameraFragment creativeEditingCameraFragment) {
            this.f10567a = creativeEditingCameraFragment;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 1009650280);
            CreativeEditingCameraFragment.m11069a(this.f10567a, this.f10567a.aJ);
            Logger.a(2, EntryType.UI_INPUT_END, -673953906, a);
        }
    }

    /* compiled from: TouchTargetHelper should not allow calling this method when pointer events are NONE */
    public class C12438 {
        public final /* synthetic */ CreativeEditingCameraFragment f10568a;

        public C12438(CreativeEditingCameraFragment creativeEditingCameraFragment) {
            this.f10568a = creativeEditingCameraFragment;
        }

        public final void m11067a(boolean z) {
            this.f10568a.aH.a(z);
            if (this.f10568a.aP.supportsPhotos() && this.f10568a.aP.supportsVideos()) {
                this.f10568a.f10578i.setVisibility(0);
            }
            this.f10568a.an.setVisibility(0);
        }
    }

    /* compiled from: TouchTargetHelper should not allow calling this method when pointer events are NONE */
    public class C12449 {
        public final /* synthetic */ CreativeEditingCameraFragment f10569a;

        public C12449(CreativeEditingCameraFragment creativeEditingCameraFragment) {
            this.f10569a = creativeEditingCameraFragment;
        }
    }

    public static void m11072a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        CreativeEditingCameraFragment creativeEditingCameraFragment = (CreativeEditingCameraFragment) obj;
        creativeEditingCameraFragment.m11071a(CreativeEditingLogger.b(fbInjector), (ActivityRuntimePermissionsManagerProvider) fbInjector.getOnDemandAssistedProviderForStaticDi(ActivityRuntimePermissionsManagerProvider.class), Toaster.b(fbInjector), (CameraPreviewControllerProvider) fbInjector.getOnDemandAssistedProviderForStaticDi(CameraPreviewControllerProvider.class), (PhotoPreviewControllerProvider) fbInjector.getOnDemandAssistedProviderForStaticDi(PhotoPreviewControllerProvider.class), (CreativeCamSwipeableControllerProvider) fbInjector.getOnDemandAssistedProviderForStaticDi(CreativeCamSwipeableControllerProvider.class), (FlashButtonControllerProvider) fbInjector.getOnDemandAssistedProviderForStaticDi(FlashButtonControllerProvider.class), (ProgressBarControllerProvider) fbInjector.getOnDemandAssistedProviderForStaticDi(ProgressBarControllerProvider.class), AllCapsTransformationMethod.b(fbInjector), (Executor) ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.a(fbInjector));
        Provider a = IdBasedProvider.a(fbInjector, 9274);
        Provider a2 = IdBasedSingletonScopeProvider.a(fbInjector, 9275);
        creativeEditingCameraFragment.f10573a = a;
        creativeEditingCameraFragment.f10574b = a2;
    }

    @Inject
    private void m11071a(CreativeEditingLogger creativeEditingLogger, ActivityRuntimePermissionsManagerProvider activityRuntimePermissionsManagerProvider, Toaster toaster, CameraPreviewControllerProvider cameraPreviewControllerProvider, PhotoPreviewControllerProvider photoPreviewControllerProvider, CreativeCamSwipeableControllerProvider creativeCamSwipeableControllerProvider, FlashButtonControllerProvider flashButtonControllerProvider, ProgressBarControllerProvider progressBarControllerProvider, AllCapsTransformationMethod allCapsTransformationMethod, Executor executor) {
        this.au = creativeEditingLogger;
        this.aw = activityRuntimePermissionsManagerProvider;
        this.ax = toaster;
        this.ay = cameraPreviewControllerProvider;
        this.aA = photoPreviewControllerProvider;
        this.aC = creativeCamSwipeableControllerProvider;
        this.aE = flashButtonControllerProvider;
        this.aG = progressBarControllerProvider;
        this.aL = allCapsTransformationMethod;
        this.aM = executor;
    }

    public static CreativeEditingCameraFragment m11073b(Intent intent) {
        Bundle bundle = new Bundle();
        bundle.putAll(intent.getExtras());
        CreativeEditingCameraFragment creativeEditingCameraFragment = new CreativeEditingCameraFragment();
        creativeEditingCameraFragment.g(bundle);
        return creativeEditingCameraFragment;
    }

    public final void m11079c(Bundle bundle) {
        super.c(bundle);
        Class cls = CreativeEditingCameraFragment.class;
        m11072a((Object) this, getContext());
        this.ar = (CreativeCamLaunchConfig) this.s.getParcelable("extra_creativecam_launch_configuration");
        Preconditions.checkNotNull(this.ar);
        this.aS = this.ar.k;
        this.aP = this.ar.f;
        this.at = this.ar.h;
        if (this.at == null || this.at.isEmpty()) {
            this.as = RegularImmutableList.a;
        } else {
            Builder builder = new Builder();
            int size = this.at.size();
            for (int i = 0; i < size; i++) {
                builder.b(((FramePackModel) this.at.get(i)).c());
            }
            this.as = builder.b();
        }
        this.aV = (String) Preconditions.checkNotNull(this.s.getString("extra_creativecam_composer_session_id"));
        this.av = (PromptAnalytics) this.s.getParcelable("extra_creativecam_prompt_entrypoint_analytics");
        if (bundle != null) {
            this.aO = (MediaItem) bundle.getParcelable("mediaSelectedFromPicker");
        }
        this.au.b = this.aV;
        this.au.a(this.aS);
    }

    public final View m11076a(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1357837198);
        this.f10575f = layoutInflater.inflate(2130903825, viewGroup, false);
        this.aw.a((Activity) Preconditions.checkNotNull(ContextUtils.a(getContext(), Activity.class))).a(this.aP.supportsVideos() ? f10572e : f10571d, new C12362(this));
        View view = this.f10575f;
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -1337091979, a);
        return view;
    }

    public final void m11074G() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 152243081);
        super.G();
        if (this.az != null) {
            this.az.c.c();
        }
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 1081121685, a);
    }

    public final void m11075H() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1229295194);
        if (this.az != null) {
            CameraPreviewController cameraPreviewController = this.az;
            CameraPreviewView.a();
            cameraPreviewController.d.b();
            if (CameraPreviewView.f()) {
                cameraPreviewController.d.setOnClickListener(cameraPreviewController.l());
            }
            this.aH.a(false);
        }
        super.H();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -1409982558, a);
    }

    public final void m11077a(int i, int i2, Intent intent) {
        super.a(i, i2, intent);
        if (i != 1) {
            return;
        }
        if (i2 != -1) {
            aE(this);
        } else if (intent != null && intent.hasExtra("extra_media_items")) {
            ArrayList parcelableArrayListExtra = intent.getParcelableArrayListExtra("extra_media_items");
            if (parcelableArrayListExtra != null && !parcelableArrayListExtra.isEmpty()) {
                MediaItem mediaItem = (MediaItem) parcelableArrayListExtra.get(0);
                this.aO = mediaItem;
                if (this.aP.supportsPhotos()) {
                    this.aJ = mediaItem.f();
                    if (this.ar.d) {
                        m11069a(this, this.aJ);
                    } else {
                        m11070a(this, this.aJ, null, 0);
                    }
                } else if (this.aQ != null) {
                    this.aQ.b(mediaItem.f(), new CreativeCamCaptureInfo(CreativeCamMediaSource.CREATIVE_CAM_PICKER, this.at, this.aD.a(), this.aD.b()));
                }
            }
        }
    }

    public final boolean m11078b() {
        if (this.aN) {
            if (this.aO != null) {
                aF(this);
            } else {
                aE(this);
            }
            return true;
        }
        ao().setResult(0, aD(this));
        this.au.b(this.aS);
        return false;
    }

    private void ar() {
        this.f10577h = ((ViewStub) FindViewUtil.b(this.f10575f, 2131560847)).inflate();
        this.al = (BetterTextView) FindViewUtil.b(this.f10575f, 2131566212);
        this.al.setTransformationMethod(this.aL);
        this.am = (BetterTextView) FindViewUtil.b(this.f10575f, 2131566213);
        this.am.setTransformationMethod(this.aL);
        FbDraweeView fbDraweeView = (FbDraweeView) FindViewUtil.b(this.f10575f, 2131565912);
        PhotoPreviewControllerProvider photoPreviewControllerProvider = this.aA;
        this.aB = new PhotoPreviewController(new C12449(this), fbDraweeView, (Context) photoPreviewControllerProvider.getInstance(Context.class), FbDraweeControllerBuilder.b(photoPreviewControllerProvider));
        this.al.setOnClickListener(new C12416(this));
        this.am.setOnClickListener(new C12427(this));
    }

    private void as() {
        ((ViewStub) FindViewUtil.b(this.f10575f, 2131560848)).inflate();
        this.aI = (SwipeableFramesHScrollCirclePageIndicator) FindViewUtil.b(this.f10575f, 2131562231);
        CreativeEditingSwipeableLayout creativeEditingSwipeableLayout = (CreativeEditingSwipeableLayout) FindViewUtil.b(this.f10575f, 2131561936);
        CreativeCamSwipeableController a = this.aC.a(creativeEditingSwipeableLayout, this.aI, this.au, this.as, this.ar.i, this.aS, this.aQ.d());
        a.o = new Object(this) {
            public final /* synthetic */ CreativeEditingCameraFragment f10556a;

            {
                this.f10556a = r1;
            }
        };
        this.aD = a;
        this.f10575f.post(new C12383(this));
    }

    public static void at(CreativeEditingCameraFragment creativeEditingCameraFragment) {
        CreativeCamTopBarController c;
        CameraFacing cameraFacing;
        CreativeCamPickerPreviewController b;
        creativeEditingCameraFragment.f10576g = ((ViewStub) FindViewUtil.b(creativeEditingCameraFragment.f10575f, 2131560175)).inflate();
        ViewStub viewStub = (ViewStub) FindViewUtil.b(creativeEditingCameraFragment.f10576g, 2131560176);
        if (creativeEditingCameraFragment.aQ == null || creativeEditingCameraFragment.aQ.c() == null) {
            CreativeCamTopBarControllerImpl creativeCamTopBarControllerImpl = (CreativeCamTopBarControllerImpl) creativeEditingCameraFragment.f10574b.get();
            String str = creativeEditingCameraFragment.aV;
            creativeCamTopBarControllerImpl.c = creativeEditingCameraFragment.ar.k;
            creativeCamTopBarControllerImpl.b.b = str;
        } else {
            c = creativeEditingCameraFragment.aQ.c();
        }
        creativeEditingCameraFragment.aT = c;
        creativeEditingCameraFragment.aq = creativeEditingCameraFragment.aT.a(viewStub, creativeEditingCameraFragment.aX);
        creativeEditingCameraFragment.an = (FbDraweeView) FindViewUtil.b(creativeEditingCameraFragment.f10575f, 2131560179);
        creativeEditingCameraFragment.ao = (CreativeCamCaptureButton) FindViewUtil.b(creativeEditingCameraFragment.f10575f, 2131559850);
        creativeEditingCameraFragment.aR = (CameraPreviewView) FindViewUtil.b(creativeEditingCameraFragment.f10575f, 2131560152);
        creativeEditingCameraFragment.f10578i = (CreativeCamPhotoVideoSwitch) FindViewUtil.b(creativeEditingCameraFragment.f10575f, 2131560180);
        creativeEditingCameraFragment.ap = (ViewStub) FindViewUtil.b(creativeEditingCameraFragment.f10575f, 2131560849);
        if (creativeEditingCameraFragment.aQ != null) {
            creativeEditingCameraFragment.aQ.a(creativeEditingCameraFragment.ap);
        }
        if (creativeEditingCameraFragment.ar.e) {
            creativeEditingCameraFragment.an.setVisibility(8);
        }
        creativeEditingCameraFragment.an.setOnClickListener(new C12405(creativeEditingCameraFragment));
        View a = creativeEditingCameraFragment.aT.a();
        if (a != null) {
            boolean z;
            if (creativeEditingCameraFragment.ar.a || creativeEditingCameraFragment.ar.f != SupportedMediaType.PHOTO_ONLY) {
                z = false;
            } else {
                z = true;
            }
            MultiStateToggleImageButton multiStateToggleImageButton = (MultiStateToggleImageButton) a;
            creativeEditingCameraFragment.aF = new FlashButtonController(new Object(creativeEditingCameraFragment) {
                public final /* synthetic */ CreativeEditingCameraFragment f10557a;

                {
                    this.f10557a = r1;
                }
            }, new Object(creativeEditingCameraFragment) {
                public final /* synthetic */ CreativeEditingCameraFragment f10558a;

                {
                    this.f10558a = r1;
                }
            }, multiStateToggleImageButton, Boolean.valueOf(z));
        }
        View b2 = FindViewUtil.b(creativeEditingCameraFragment.f10575f, 2131559845);
        if (creativeEditingCameraFragment.ar.b) {
            cameraFacing = CameraFacing.FRONT;
        } else {
            cameraFacing = CameraFacing.BACK;
        }
        creativeEditingCameraFragment.az = creativeEditingCameraFragment.ay.a(new C12438(creativeEditingCameraFragment), creativeEditingCameraFragment.aR, (FocusView) FindViewUtil.b(b2, 2131559846), cameraFacing, creativeEditingCameraFragment.ao, creativeEditingCameraFragment.au, creativeEditingCameraFragment.aS);
        CameraPreviewController cameraPreviewController = creativeEditingCameraFragment.az;
        cameraPreviewController.c.p = cameraPreviewController.q;
        cameraPreviewController.c.setCameraInitialisedCallback(new 1(cameraPreviewController));
        cameraPreviewController.c.setFocusCallbackListener(new CameraPreviewController.2(cameraPreviewController));
        creativeEditingCameraFragment.aH = creativeEditingCameraFragment.m11068a((ProgressBar) FindViewUtil.b(creativeEditingCameraFragment.f10575f, 2131560177), (FbTextView) FindViewUtil.b(creativeEditingCameraFragment.f10575f, 2131560178));
        creativeEditingCameraFragment.aW = creativeEditingCameraFragment.ar.g;
        if (creativeEditingCameraFragment.aP.supportsPhotos() && creativeEditingCameraFragment.aP.supportsVideos()) {
            creativeEditingCameraFragment.f10578i.setVisibility(0);
            creativeEditingCameraFragment.f10578i.h = new C12394(creativeEditingCameraFragment);
            creativeEditingCameraFragment.f10578i.setSelectedPosition(creativeEditingCameraFragment.aW);
            if (creativeEditingCameraFragment.aW == 0) {
                aw(creativeEditingCameraFragment);
            } else {
                ax(creativeEditingCameraFragment);
            }
        } else if (creativeEditingCameraFragment.aP.supportsPhotos()) {
            aw(creativeEditingCameraFragment);
            creativeEditingCameraFragment.ar();
        } else {
            ax(creativeEditingCameraFragment);
        }
        creativeEditingCameraFragment.as();
        if (creativeEditingCameraFragment.aQ.b() != null) {
            b = creativeEditingCameraFragment.aQ.b();
        } else {
            CreativeCamPickerPreviewControllerImpl creativeCamPickerPreviewControllerImpl = (CreativeCamPickerPreviewControllerImpl) creativeEditingCameraFragment.f10573a.get();
        }
        creativeEditingCameraFragment.aU = b;
        au(creativeEditingCameraFragment);
    }

    public static void au(CreativeEditingCameraFragment creativeEditingCameraFragment) {
        creativeEditingCameraFragment.aU.a(creativeEditingCameraFragment.an, creativeEditingCameraFragment.aW);
    }

    public static void aw(CreativeEditingCameraFragment creativeEditingCameraFragment) {
        creativeEditingCameraFragment.ao.setCaptureType(CaptureType.IMAGE);
        creativeEditingCameraFragment.ao.setOnClickListener(new 8(creativeEditingCameraFragment.az));
        if (creativeEditingCameraFragment.aQ != null) {
            creativeEditingCameraFragment.aQ.a(0);
        }
    }

    public static void ax(CreativeEditingCameraFragment creativeEditingCameraFragment) {
        creativeEditingCameraFragment.ao.setCaptureType(CaptureType.VIDEO);
        creativeEditingCameraFragment.ao.setOnClickListener(creativeEditingCameraFragment.az.l());
        if (creativeEditingCameraFragment.aQ != null) {
            creativeEditingCameraFragment.aQ.a(1);
        }
    }

    public static void m11069a(CreativeEditingCameraFragment creativeEditingCameraFragment, Uri uri) {
        creativeEditingCameraFragment.aQ.a(uri, new CreativeCamCaptureInfo(creativeEditingCameraFragment.az.e() ? CreativeCamMediaSource.CREATIVE_CAM_FRONT : CreativeCamMediaSource.CREATIVE_CAM_BACK, creativeEditingCameraFragment.at, creativeEditingCameraFragment.aD.a(), creativeEditingCameraFragment.aD.b()));
        creativeEditingCameraFragment.au.b(creativeEditingCameraFragment.aS, creativeEditingCameraFragment.aO != null ? "picker" : "camera");
    }

    private ProgressBarController m11068a(ProgressBar progressBar, FbTextView fbTextView) {
        progressBar.setMax(this.ar.j);
        ProgressBarControllerProvider progressBarControllerProvider = this.aG;
        AnonymousClass13 anonymousClass13 = new Object(this) {
            public final /* synthetic */ CreativeEditingCameraFragment f10559a;

            {
                this.f10559a = r1;
            }
        };
        return new ProgressBarController(anonymousClass13, progressBar, fbTextView, this.aq, (ChoreographerWrapper) DefaultChoreographerWrapper.a(progressBarControllerProvider), (MonotonicClock) AwakeTimeSinceBootClockMethodAutoProvider.a(progressBarControllerProvider));
    }

    public static Intent aD(CreativeEditingCameraFragment creativeEditingCameraFragment) {
        Intent intent = new Intent();
        if (creativeEditingCameraFragment.av != null) {
            intent.putExtras(PromptPublishIntentHelper.a(creativeEditingCameraFragment.av, ProductionPromptObject.class, null));
        }
        return intent;
    }

    public static void m11070a(CreativeEditingCameraFragment creativeEditingCameraFragment, @Nullable Uri uri, PhotoCaptureInfo photoCaptureInfo, int i) {
        creativeEditingCameraFragment.aN = true;
        PhotoPreviewController photoPreviewController = creativeEditingCameraFragment.aB;
        boolean e = creativeEditingCameraFragment.az.e();
        int a = SizeUtil.a(photoPreviewController.e, 220.0f);
        ImageRequestBuilder a2 = ImageRequestBuilder.a(uri);
        a2.d = new ResizeOptions(a, a);
        ImageRequestBuilder imageRequestBuilder = a2;
        imageRequestBuilder.c = false;
        photoPreviewController.d.setController(((FbDraweeControllerBuilder) ((FbDraweeControllerBuilder) photoPreviewController.f.c(imageRequestBuilder.m())).a(photoPreviewController.g)).a(PhotoPreviewController.a).s());
        if (photoCaptureInfo != null) {
            RectF rectF = new RectF(photoCaptureInfo.a);
            RectF rectF2 = new RectF(photoCaptureInfo.a(0));
            CameraImageScaleType cameraImageScaleType = photoPreviewController.b;
            cameraImageScaleType.i = rectF;
            cameraImageScaleType.j = rectF2;
            cameraImageScaleType.k = i;
            cameraImageScaleType.l = e;
            ((GenericDraweeHierarchy) photoPreviewController.d.getHierarchy()).a(photoPreviewController.b);
            photoPreviewController.d.setAspectRatio(rectF2.width() / rectF2.height());
        } else {
            ((GenericDraweeHierarchy) photoPreviewController.d.getHierarchy()).a(ScaleType.g);
        }
        creativeEditingCameraFragment.f10577h.setVisibility(0);
        creativeEditingCameraFragment.f10576g.setVisibility(8);
    }

    public static void aE(CreativeEditingCameraFragment creativeEditingCameraFragment) {
        creativeEditingCameraFragment.aN = false;
        creativeEditingCameraFragment.aD.a(creativeEditingCameraFragment.aR.getMeasuredWidth(), creativeEditingCameraFragment.aR.getMeasuredWidth(), creativeEditingCameraFragment.ar.c);
        creativeEditingCameraFragment.f10576g.setVisibility(0);
        if (creativeEditingCameraFragment.f10577h != null) {
            creativeEditingCameraFragment.f10577h.setVisibility(8);
        }
    }

    public static void aF(CreativeEditingCameraFragment creativeEditingCameraFragment) {
        SimplePickerLauncherConfiguration.Builder h = new SimplePickerLauncherConfiguration.Builder(SimplePickerSource.CREATIVECAM).a(Action.NONE).h();
        h.d.l = false;
        h = h.a();
        if (!creativeEditingCameraFragment.aP.supportsVideos()) {
            h.i();
        } else if (!creativeEditingCameraFragment.aP.supportsPhotos()) {
            h.j();
        }
        if (creativeEditingCameraFragment.aO != null) {
            h.a(ImmutableList.of(creativeEditingCameraFragment.aO));
            creativeEditingCameraFragment.aO = null;
        }
        creativeEditingCameraFragment.a(SimplePickerIntent.a(creativeEditingCameraFragment.getContext(), h), 1);
    }

    public final void m11080e(Bundle bundle) {
        bundle.putParcelable("mediaSelectedFromPicker", this.aO);
        super.e(bundle);
    }
}
