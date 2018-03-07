package com.facebook.messaging.quickcam;

import android.content.Context;
import android.graphics.Bitmap;
import android.media.CamcorderProfile;
import android.net.Uri;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.GestureDetectorCompat;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.OrientationEventListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewStub;
import android.widget.ProgressBar;
import com.facebook.common.executors.AndroidThreadUtil;
import com.facebook.common.executors.DefaultAndroidThreadUtil;
import com.facebook.common.quickcam.QuickCamAsync;
import com.facebook.common.quickcam.QuickCamAsync.Listener;
import com.facebook.common.quickcam.QuickCamBitmapUtil;
import com.facebook.common.quickcam.QuickCamPreviewHolder;
import com.facebook.common.quickcam.QuickCamViewportController;
import com.facebook.common.quickcam.QuickCamViewportController.CameraPreviewListener;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.time.Clock;
import com.facebook.common.ui.util.BetterRotationManager;
import com.facebook.common.ui.util.ViewOrientationLockHelper;
import com.facebook.common.ui.util.ViewOrientationLockHelperProvider;
import com.facebook.common.ui.util.ViewPositionUtil;
import com.facebook.inject.Assisted;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.messaging.montage.composer.MontageCameraCanvasFragment.C13761;
import com.facebook.messaging.montage.composer.MontageComposerController;
import com.facebook.messaging.permissions.PermissionRequestIconView;
import com.facebook.messaging.quickcam.PhotoParams.Builder;
import com.facebook.messaging.quickcam.PhotoParams.CaptureType;
import com.facebook.messaging.sounds.MessengerSoundUtil;
import com.facebook.resources.ui.FbTextView;
import com.facebook.runtimepermissions.AbstractRuntimePermissionsListener;
import com.facebook.runtimepermissions.RuntimePermissionsManager;
import com.facebook.springs.SimpleSpringListener;
import com.facebook.springs.Spring;
import com.facebook.springs.SpringConfig;
import com.facebook.springs.SpringSystem;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.ui.choreographer.ChoreographerWrapper;
import com.facebook.ui.choreographer.FrameCallbackWrapper;
import com.facebook.ui.media.attachments.MediaResource.Source;
import com.facebook.widget.ViewStubHolder;
import com.google.common.base.Function;
import com.google.common.util.concurrent.Futures;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: deltaPinCode */
public class QuickCamController {
    public static final SpringConfig f16458a = SpringConfig.a(140.0d, 10.0d);
    private final ViewStub f16459A = this.f16473b.getCameraPreviewViewStub();
    private final ViewStubHolder<PermissionRequestIconView> f16460B = this.f16473b.getRequestPermissionViewStub();
    public final List<View> f16461C = m16502a(this.f16496y, this.f16491t, this.f16492u);
    private final Spring f16462D = this.f16488q.a().a(f16458a).a(new IconRotationSpringListener(this));
    public final FrameCallbackWrapper f16463E = new C19361(this);
    public final OrientationEventListener f16464F;
    public final ViewOrientationLockHelper f16465G;
    public GestureDetectorCompat f16466H;
    public C13761 f16467I;
    public boolean f16468J;
    public boolean f16469K;
    public long f16470L;
    public long f16471M;
    public int f16472N;
    public final QuickCamView f16473b;
    public final Context f16474c;
    public final DefaultAndroidThreadUtil f16475d;
    public final BetterRotationManager f16476e;
    public final BitmapHolder f16477f;
    public final ChoreographerWrapper f16478g;
    public final Clock f16479h;
    private final Executor f16480i;
    public final MediaOperations f16481j;
    public final MessengerSoundUtil f16482k;
    private final Provider<Boolean> f16483l;
    public final QuickCamAsync f16484m;
    private final QuickCamBitmapUtil f16485n;
    public final QuickCamViewportController f16486o;
    public final RuntimePermissionsManager f16487p;
    private final SpringSystem f16488q;
    private final ViewOrientationLockHelperProvider f16489r;
    public final QuickCamPermissionsHolder f16490s;
    @Nullable
    public final View f16491t = this.f16473b.getCameraFlipButton();
    @Nullable
    private final View f16492u = this.f16473b.getCancelButton();
    public final View f16493v = this.f16473b.getCaptureButton();
    private final FbTextView f16494w = this.f16473b.getErrorMessage();
    public final ProgressBar f16495x = this.f16473b.getProgressBar();
    private final FbTextView f16496y = this.f16473b.getTimerText();
    public final View f16497z = this.f16473b.getVideoCancelOverlay();

    /* compiled from: deltaPinCode */
    class C19361 extends FrameCallbackWrapper {
        final /* synthetic */ QuickCamController f16443a;

        C19361(QuickCamController quickCamController) {
            this.f16443a = quickCamController;
        }

        public final void m16485a(long j) {
            int a = (int) (this.f16443a.f16479h.a() - this.f16443a.f16471M);
            if (a < 15300) {
                this.f16443a.f16495x.setProgress(a);
                QuickCamController.m16504b(this.f16443a, Math.max(1, (a + 500) / 1000));
                this.f16443a.f16478g.a(this.f16443a.f16463E);
                return;
            }
            this.f16443a.f16484m.m6385e();
        }
    }

    /* compiled from: deltaPinCode */
    class C19372 implements CameraPreviewListener {
        final /* synthetic */ QuickCamController f16444a;

        C19372(QuickCamController quickCamController) {
            this.f16444a = quickCamController;
        }

        public final void mo687a() {
            QuickCamController.m16498A(this.f16444a);
            if (!QuickCamController.m16513k(this.f16444a)) {
                QuickCamController.m16499B(this.f16444a);
            }
        }
    }

    /* compiled from: deltaPinCode */
    class C19383 implements OnClickListener {
        final /* synthetic */ QuickCamController f16445a;

        C19383(QuickCamController quickCamController) {
            this.f16445a = quickCamController;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 1128458708);
            QuickCamController quickCamController = this.f16445a;
            Logger.a(2, EntryType.UI_INPUT_END, 1277354076, a);
        }
    }

    /* compiled from: deltaPinCode */
    class C19394 implements OnClickListener {
        final /* synthetic */ QuickCamController f16446a;

        C19394(QuickCamController quickCamController) {
            this.f16446a = quickCamController;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -391740731);
            if (this.f16446a.f16493v.isPressed() || this.f16446a.f16468J) {
                Logger.a(2, EntryType.UI_INPUT_END, 26590306, a);
                return;
            }
            this.f16446a.f16484m.m6383c();
            LogUtils.a(370292868, a);
        }
    }

    /* compiled from: deltaPinCode */
    class C19415 implements OnClickListener {
        final /* synthetic */ QuickCamController f16448a;

        /* compiled from: deltaPinCode */
        class C19401 extends AbstractRuntimePermissionsListener {
            final /* synthetic */ C19415 f16447a;

            C19401(C19415 c19415) {
                this.f16447a = c19415;
            }

            public final void m16487a() {
                this.f16447a.f16448a.m16526b();
            }
        }

        C19415(QuickCamController quickCamController) {
            this.f16448a = quickCamController;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -1881401681);
            this.f16448a.f16487p.a(this.f16448a.f16490s.f16590a, new C19401(this));
            Logger.a(2, EntryType.UI_INPUT_END, -1380043389, a);
        }
    }

    /* compiled from: deltaPinCode */
    class CaptureButtonListener implements OnClickListener, OnLongClickListener, OnTouchListener {
        final /* synthetic */ QuickCamController f16451a;
        private boolean f16452b;

        public CaptureButtonListener(QuickCamController quickCamController) {
            this.f16451a = quickCamController;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -1544743767);
            QuickCamController quickCamController = this.f16451a;
            long a2 = quickCamController.f16479h.a();
            if (a2 > quickCamController.f16470L) {
                quickCamController.f16468J = true;
                quickCamController.f16470L = a2 + 500;
                quickCamController.f16482k.d();
                QuickCamPreviewHolder quickCamPreviewHolder = quickCamController.f16486o.f6116a;
                if (quickCamPreviewHolder.mo238a()) {
                    Source source = quickCamController.f16484m.m6388h() ? Source.QUICKCAM_FRONT : Source.QUICKCAM_BACK;
                    Builder builder = new Builder();
                    builder.f16426a = quickCamController.f16486o.m6472d().getWidth();
                    builder = builder;
                    builder.f16427b = quickCamController.f16486o.m6472d().getHeight();
                    Builder a3 = builder.m16483b(QuickCamController.m16521x(quickCamController), QuickCamController.m16522y(quickCamController)).m16484c(quickCamController.f16472N).m16481a(source);
                    a3.f16432g = CaptureType.TEXTURE;
                    a3 = a3;
                    a3.f16433h = true;
                    QuickCamController.m16503a(quickCamController, a3.m16482a(), quickCamController.f16481j.m16473a(quickCamPreviewHolder));
                } else {
                    quickCamController.f16484m.m6384d();
                }
            }
            Logger.a(2, EntryType.UI_INPUT_END, -2131298097, a);
        }

        public boolean onLongClick(View view) {
            this.f16451a.f16468J = true;
            this.f16451a.f16484m.m6378a(this.f16451a.f16472N);
            this.f16452b = true;
            return true;
        }

        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (this.f16452b) {
                motionEvent.offsetLocation(0.0f, (float) this.f16451a.f16473b.getTop());
                switch (motionEvent.getAction()) {
                    case 1:
                        if (ViewPositionUtil.b(motionEvent, view)) {
                            this.f16451a.f16484m.m6386f();
                        } else {
                            this.f16451a.f16484m.m6387g();
                            this.f16451a.f16468J = false;
                        }
                        this.f16452b = false;
                        break;
                    case 2:
                        QuickCamController quickCamController;
                        if (!ViewPositionUtil.b(motionEvent, view)) {
                            quickCamController = this.f16451a;
                            quickCamController.f16497z.setVisibility(0);
                            quickCamController.f16495x.setProgressDrawable(ContextCompat.a(quickCamController.f16474c, 2130842253));
                            break;
                        }
                        quickCamController = this.f16451a;
                        quickCamController.f16497z.setVisibility(8);
                        quickCamController.f16495x.setProgressDrawable(ContextCompat.a(quickCamController.f16474c, 2130842254));
                        if (!view.isPressed()) {
                            view.setPressed(true);
                            break;
                        }
                        break;
                    case 3:
                        this.f16451a.f16484m.m6387g();
                        this.f16452b = false;
                        this.f16451a.f16468J = false;
                        break;
                    default:
                        break;
                }
            }
            return false;
        }
    }

    /* compiled from: deltaPinCode */
    class IconRotationSpringListener extends SimpleSpringListener {
        final /* synthetic */ QuickCamController f16453a;

        public IconRotationSpringListener(QuickCamController quickCamController) {
            this.f16453a = quickCamController;
        }

        public final void m16488a(Spring spring) {
            float d = (float) spring.d();
            for (View rotation : this.f16453a.f16461C) {
                rotation.setRotation(d);
            }
        }
    }

    /* compiled from: deltaPinCode */
    class OnCameraGestureListener extends SimpleOnGestureListener {
        final /* synthetic */ QuickCamController f16454a;

        public OnCameraGestureListener(QuickCamController quickCamController) {
            this.f16454a = quickCamController;
        }

        public boolean onSingleTapUp(MotionEvent motionEvent) {
            this.f16454a.f16486o.m6464a((int) motionEvent.getX(), (int) motionEvent.getY());
            return true;
        }
    }

    /* compiled from: deltaPinCode */
    class OnCameraTouchListener implements OnTouchListener {
        final /* synthetic */ QuickCamController f16455a;

        public OnCameraTouchListener(QuickCamController quickCamController) {
            this.f16455a = quickCamController;
        }

        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (this.f16455a.f16468J) {
                return true;
            }
            if (this.f16455a.f16466H == null && motionEvent.getAction() == 0) {
                this.f16455a.f16466H = new GestureDetectorCompat(this.f16455a.f16474c, new OnCameraGestureListener(this.f16455a));
            }
            if (this.f16455a.f16466H == null) {
                return false;
            }
            float rawY = motionEvent.getRawY() - motionEvent.getY();
            motionEvent.offsetLocation(0.0f, rawY);
            boolean a = this.f16455a.f16466H.a(motionEvent);
            motionEvent.offsetLocation(0.0f, -rawY);
            if (motionEvent.getAction() != 3) {
                return a;
            }
            QuickCamController.m16517s(this.f16455a);
            return a;
        }
    }

    /* compiled from: deltaPinCode */
    class QuickCamAsyncListener implements Listener {
        final /* synthetic */ QuickCamController f16456a;

        public QuickCamAsyncListener(QuickCamController quickCamController) {
            this.f16456a = quickCamController;
        }

        public final void mo688a() {
            QuickCamController.m16499B(this.f16456a);
            this.f16456a.f16486o.m6470c();
            m16489a(true);
        }

        public final void mo691b() {
            m16489a(false);
        }

        private void m16489a(boolean z) {
            this.f16456a.f16486o.m6472d().setAlpha(z ? 1.0f : 0.0f);
        }

        public final void mo692c() {
            if (this.f16456a.f16491t != null) {
                this.f16456a.f16491t.setSelected(this.f16456a.f16484m.m6388h());
            }
        }

        public final void mo690a(byte[] bArr, int i, int i2, boolean z) {
            Builder a = new Builder().m16480a(i, i2).m16483b(QuickCamController.m16521x(this.f16456a), QuickCamController.m16522y(this.f16456a)).m16484c(this.f16456a.f16472N).m16481a(z ? Source.QUICKCAM_FRONT : Source.QUICKCAM_BACK);
            a.f16432g = CaptureType.CAMERA_PREVIEW;
            a = a;
            a.f16433h = true;
            QuickCamController.m16503a(this.f16456a, a.m16482a(), this.f16456a.f16481j.m16474a(bArr));
        }

        public final void mo693d() {
            this.f16456a.f16475d.a();
            this.f16456a.f16469K = true;
            this.f16456a.f16471M = this.f16456a.f16479h.a() + 400;
            this.f16456a.f16478g.a(this.f16456a.f16463E, 400);
            QuickCamController.m16516r(this.f16456a);
            QuickCamController.m16509g(this.f16456a);
        }

        public final void mo694e() {
            this.f16456a.f16475d.a();
            this.f16456a.f16469K = false;
            this.f16456a.f16478g.b(this.f16456a.f16463E);
            QuickCamController.m16517s(this.f16456a);
            QuickCamController.m16509g(this.f16456a);
        }

        public final void mo689a(@Nullable Uri uri, @Nullable CamcorderProfile camcorderProfile, boolean z, int i) {
            this.f16456a.f16475d.a();
            if (uri != null) {
                VideoParams.Builder a = new VideoParams.Builder().m16618a(camcorderProfile.videoFrameWidth, camcorderProfile.videoFrameHeight).m16617a(i).m16619a(z ? Source.QUICKCAM_FRONT : Source.QUICKCAM_BACK);
                a.f16596e = true;
                VideoParams a2 = a.m16620a();
                QuickCamController quickCamController = this.f16456a;
                if (quickCamController.f16467I != null) {
                    C13761 c13761 = quickCamController.f16467I;
                    if (c13761.f12437a.f12440c != null) {
                        MontageComposerController montageComposerController = c13761.f12437a.f12440c;
                        montageComposerController.f12477l.m12969e();
                        montageComposerController.f12479n.m12219a(uri, a2);
                        MontageComposerController.m12936j(montageComposerController);
                    }
                }
            }
        }

        public final void mo695f() {
            if (!QuickCamController.m16513k(this.f16456a)) {
                QuickCamController.m16523z(this.f16456a);
            }
        }
    }

    /* compiled from: deltaPinCode */
    class QuickCamOrientationListener extends OrientationEventListener {
        final /* synthetic */ QuickCamController f16457a;

        public QuickCamOrientationListener(QuickCamController quickCamController) {
            this.f16457a = quickCamController;
            super(quickCamController.f16474c, 2);
        }

        public void onOrientationChanged(int i) {
            this.f16457a.m16525a(this.f16457a.f16476e.a(i));
        }
    }

    @Inject
    public QuickCamController(@Assisted QuickCamView quickCamView, @Assisted RuntimePermissionsManager runtimePermissionsManager, AndroidThreadUtil androidThreadUtil, BetterRotationManager betterRotationManager, BitmapHolder bitmapHolder, ChoreographerWrapper choreographerWrapper, Clock clock, Executor executor, MediaOperations mediaOperations, MessengerSoundUtil messengerSoundUtil, Provider<Boolean> provider, QuickCamAsync quickCamAsync, QuickCamBitmapUtil quickCamBitmapUtil, QuickCamViewportController quickCamViewportController, SpringSystem springSystem, ViewOrientationLockHelperProvider viewOrientationLockHelperProvider, QuickCamPermissionsHolder quickCamPermissionsHolder) {
        this.f16474c = quickCamView.getContext();
        this.f16475d = androidThreadUtil;
        this.f16476e = betterRotationManager;
        this.f16477f = bitmapHolder;
        this.f16478g = choreographerWrapper;
        this.f16479h = clock;
        this.f16480i = executor;
        this.f16481j = mediaOperations;
        this.f16482k = messengerSoundUtil;
        this.f16483l = provider;
        this.f16484m = quickCamAsync;
        this.f16485n = quickCamBitmapUtil;
        this.f16486o = quickCamViewportController;
        this.f16487p = runtimePermissionsManager;
        this.f16488q = springSystem;
        this.f16489r = viewOrientationLockHelperProvider;
        this.f16490s = quickCamPermissionsHolder;
        this.f16473b = quickCamView;
        this.f16473b.setListener(this);
        this.f16473b.setClickable(true);
        this.f16473b.setFocusableInTouchMode(true);
        this.f16473b.setBackgroundColor(ContextCompat.b(this.f16474c, 2131362543));
        this.f16484m.m6380a(new QuickCamAsyncListener(this));
        this.f16484m.m6377a();
        this.f16464F = new QuickCamOrientationListener(this);
        this.f16465G = this.f16489r.a(this.f16473b);
        this.f16486o.m6466a(this.f16484m);
        this.f16486o.m6465a(this.f16459A, this.f16473b);
        this.f16486o.m6463a(0);
        this.f16486o.m6467a(new C19372(this));
        m16506d();
        m16507e();
        m16508f();
        m16510h();
        m16514l();
        m16515m();
        this.f16473b.requestFocus();
    }

    private static List<View> m16502a(View... viewArr) {
        List arrayList = new ArrayList();
        for (Object obj : viewArr) {
            if (obj != null) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    private void m16506d() {
        this.f16473b.setOnTouchListener(new OnCameraTouchListener(this));
    }

    private void m16507e() {
        if (this.f16492u != null) {
            this.f16492u.setVisibility(0);
            this.f16492u.setOnClickListener(new C19383(this));
        }
    }

    private void m16508f() {
        if (!this.f16484m.m6390j() && this.f16491t != null) {
            this.f16491t.setOnClickListener(new C19394(this));
        }
    }

    public static void m16509g(QuickCamController quickCamController) {
        if (quickCamController.f16491t != null) {
            if (quickCamController.f16469K || quickCamController.m16512j() || m16513k(quickCamController) || quickCamController.f16484m.m6390j()) {
                quickCamController.f16491t.setVisibility(8);
            } else {
                quickCamController.f16491t.setVisibility(0);
            }
        }
    }

    private void m16510h() {
        OnTouchListener captureButtonListener = new CaptureButtonListener(this);
        this.f16493v.setOnClickListener(captureButtonListener);
        if (((Boolean) this.f16483l.get()).booleanValue()) {
            this.f16493v.setOnLongClickListener(captureButtonListener);
            this.f16493v.setOnTouchListener(captureButtonListener);
            return;
        }
        this.f16497z.setVisibility(8);
    }

    private void m16511i() {
        if (m16513k(this) || m16512j()) {
            this.f16493v.setVisibility(8);
        } else {
            this.f16493v.setVisibility(0);
        }
    }

    private boolean m16512j() {
        return this.f16494w.getVisibility() == 0;
    }

    public static boolean m16513k(QuickCamController quickCamController) {
        return quickCamController.f16460B.d();
    }

    private void m16514l() {
        this.f16495x.getBackground().mutate().setAlpha(0);
        if (!((Boolean) this.f16483l.get()).booleanValue()) {
            this.f16495x.setVisibility(8);
        }
    }

    private void m16515m() {
        m16511i();
        m16509g(this);
    }

    public final void m16524a() {
        m16501D();
    }

    public final void m16526b() {
        this.f16465G.a();
        this.f16464F.enable();
        if (!m16518t()) {
            m16499B(this);
            if (this.f16486o.m6469b()) {
                this.f16484m.m6381a(this.f16486o.f6116a);
            } else {
                this.f16484m.m6377a();
            }
            this.f16473b.requestFocus();
            m16515m();
        }
    }

    public final void m16527c() {
        this.f16465G.b();
        this.f16464F.disable();
        m16517s(this);
        m16501D();
        this.f16486o.f6116a.mo241d();
        this.f16484m.m6382b();
    }

    public static void m16516r(QuickCamController quickCamController) {
        quickCamController.f16496y.setVisibility(0);
        quickCamController.f16496y.setRotation((float) quickCamController.m16505c(quickCamController.f16472N));
        m16504b(quickCamController, 0);
        quickCamController.f16495x.setVisibility(0);
    }

    public static void m16504b(QuickCamController quickCamController, int i) {
        quickCamController.f16496y.setText(StringFormatUtil.formatStrLocaleSafe("0:%02d", Integer.valueOf(i)));
    }

    public static void m16517s(QuickCamController quickCamController) {
        quickCamController.f16496y.setVisibility(4);
        quickCamController.f16495x.setProgress(0);
        quickCamController.f16471M = 0;
        quickCamController.f16497z.setVisibility(8);
        quickCamController.f16495x.setProgressDrawable(ContextCompat.a(quickCamController.f16474c, 2130842254));
        quickCamController.f16495x.setVisibility(8);
    }

    private boolean m16518t() {
        if (this.f16487p.a(this.f16490s.f16590a)) {
            return false;
        }
        m16519u();
        return true;
    }

    private void m16519u() {
        m16498A(this);
        m16500C();
        PermissionRequestIconView permissionRequestIconView = (PermissionRequestIconView) this.f16460B.a();
        permissionRequestIconView.setButtonListener(new C19415(this));
        permissionRequestIconView.setVisibility(0);
        m16515m();
    }

    private void m16520v() {
        this.f16460B.e();
    }

    public static void m16503a(QuickCamController quickCamController, final PhotoParams photoParams, Function function) {
        Futures.a(Futures.a(quickCamController.f16477f.m16466a(photoParams.f16434a, photoParams.f16435b), function, quickCamController.f16480i), new Function<Bitmap, Void>(quickCamController) {
            final /* synthetic */ QuickCamController f16450b;

            @Nullable
            public Object apply(@Nullable Object obj) {
                Bitmap bitmap = (Bitmap) obj;
                if (bitmap != null) {
                    bitmap = bitmap.copy(bitmap.getConfig(), false);
                }
                QuickCamController quickCamController = this.f16450b;
                PhotoParams photoParams = photoParams;
                if (quickCamController.f16467I != null) {
                    C13761 c13761 = quickCamController.f16467I;
                    if (c13761.f12437a.f12440c != null) {
                        MontageComposerController montageComposerController = c13761.f12437a.f12440c;
                        montageComposerController.f12477l.m12969e();
                        montageComposerController.f12479n.m12218a(bitmap);
                        MontageComposerController.m12936j(montageComposerController);
                    }
                }
                this.f16450b.f16477f.m16467a();
                return null;
            }
        }, quickCamController.f16480i);
    }

    public static int m16521x(QuickCamController quickCamController) {
        return quickCamController.f16485n.m6396a(quickCamController.f16472N) ? quickCamController.f16473b.getHeight() : quickCamController.f16473b.getWidth();
    }

    public static int m16522y(QuickCamController quickCamController) {
        return quickCamController.f16485n.m6396a(quickCamController.f16472N) ? quickCamController.f16473b.getWidth() : quickCamController.f16473b.getHeight();
    }

    public static void m16523z(QuickCamController quickCamController) {
        quickCamController.f16494w.setVisibility(0);
        quickCamController.m16500C();
        quickCamController.m16520v();
        quickCamController.m16515m();
    }

    public static void m16498A(QuickCamController quickCamController) {
        quickCamController.f16494w.setVisibility(8);
        quickCamController.m16515m();
    }

    public static void m16499B(QuickCamController quickCamController) {
        m16498A(quickCamController);
        quickCamController.m16520v();
        quickCamController.f16486o.m6463a(0);
        quickCamController.m16515m();
    }

    private void m16500C() {
        this.f16486o.m6463a(8);
        m16515m();
    }

    private void m16501D() {
        this.f16477f.m16467a();
    }

    final void m16525a(int i) {
        if (!this.f16469K) {
            this.f16472N = Math.round(((float) (360 - i)) / 90.0f) % 4;
            this.f16462D.b((double) m16505c(this.f16472N));
        }
    }

    private int m16505c(int i) {
        int a = (i - this.f16476e.a()) * 90;
        if (a < -90) {
            return a + 360;
        }
        if (a > 180) {
            return a - 360;
        }
        return a;
    }
}
