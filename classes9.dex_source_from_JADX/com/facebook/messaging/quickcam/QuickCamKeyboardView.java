package com.facebook.messaging.quickcam;

import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.media.CamcorderProfile;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Environment;
import android.provider.MediaStore.Images.Media;
import android.support.v4.view.GestureDetectorCompat;
import android.support.v4.view.ViewCompat;
import android.support.v7.internal.widget.ViewStubCompat;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.KeyEvent;
import android.view.KeyEvent.DispatcherState;
import android.view.MotionEvent;
import android.view.OrientationEventListener;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewStub;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import com.facebook.abtest.qe.bootstrap.framework.QuickExperimentController;
import com.facebook.abtest.qe.framework.QuickExperimentControllerImpl;
import com.facebook.analytics.event.HoneyClientEventFast;
import com.facebook.common.build.IsWorkBuild;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.errorreporting.SoftError;
import com.facebook.common.errorreporting.SoftErrorBuilder;
import com.facebook.common.executors.AndroidThreadUtil;
import com.facebook.common.executors.DefaultAndroidThreadUtil;
import com.facebook.common.executors.DefaultExecutorService;
import com.facebook.common.executors.ForUiThread;
import com.facebook.common.executors.ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.common.quickcam.QuickCamAsync;
import com.facebook.common.quickcam.QuickCamBitmapUtil;
import com.facebook.common.quickcam.QuickCamPreviewHolder;
import com.facebook.common.quickcam.QuickCamViewportController;
import com.facebook.common.quickcam.QuickCamViewportController.CameraPreviewListener;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.common.ui.util.BetterRotationManager;
import com.facebook.common.ui.util.LayoutParamsUtil;
import com.facebook.common.ui.util.ViewOrientationLockHelper;
import com.facebook.common.ui.util.ViewOrientationLockHelperProvider;
import com.facebook.common.ui.util.ViewPositionUtil;
import com.facebook.common.util.MathUtil;
import com.facebook.common.util.TriState;
import com.facebook.config.application.Boolean_IsWorkBuildMethodAutoProvider;
import com.facebook.fbui.glyph.GlyphColorizer;
import com.facebook.fbui.widget.text.ImageWithTextView;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.messaging.keyboard.PermissionRequestKeyboardView;
import com.facebook.messaging.model.threadkey.ThreadKey;
import com.facebook.messaging.photos.editing.LayerGroupLayout;
import com.facebook.messaging.photos.editing.LayerPresenter;
import com.facebook.messaging.photos.editing.PhotoEditingConfig;
import com.facebook.messaging.photos.editing.PhotoEditingController;
import com.facebook.messaging.photos.editing.PhotoEditingController.Listener;
import com.facebook.messaging.photos.editing.PhotoEditingControllerProvider;
import com.facebook.messaging.photos.editing.PhotoEditingControlsLayout;
import com.facebook.messaging.photos.editing.SceneLayersPresenter;
import com.facebook.messaging.photos.editing.TextStylesLayout;
import com.facebook.messaging.prefs.MessagingPrefKeys;
import com.facebook.messaging.quickcam.MediaOperations.CropPhoto;
import com.facebook.messaging.quickcam.MediaOperations.SaveVideo;
import com.facebook.messaging.quickcam.PhotoParams.Builder;
import com.facebook.messaging.quickcam.PhotoParams.CaptureType;
import com.facebook.messaging.quickcam.abtest.ExperimentsForMessagingQuickCamModule;
import com.facebook.messaging.quickcam.annotations.IsForceFullscreenQuickCamEnabled;
import com.facebook.messaging.quickcam.annotations.IsPhotosAutoSaveAvailable;
import com.facebook.messaging.quickcam.annotations.IsQuickCamVideoEnabled;
import com.facebook.messaging.quickcam.prefkeys.QuickCamPrefKeys;
import com.facebook.messaging.sounds.MessengerSoundUtil;
import com.facebook.orca.compose.ComposerKeyboardManager.QuickcamKeyboardFactory.1;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferences.Editor;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.qe.api.ExposureLogging;
import com.facebook.qe.api.Liveness;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.resources.ui.FbTextView;
import com.facebook.rtc.fbwebrtc.WebrtcUiHandler;
import com.facebook.runtimepermissions.RequestPermissionsPrefKeys;
import com.facebook.runtimepermissions.RuntimePermissionsUtil;
import com.facebook.springs.SimpleSpringListener;
import com.facebook.springs.Spring;
import com.facebook.springs.SpringConfig;
import com.facebook.springs.SpringSystem;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.tools.dextr.runtime.detour.FutureDetour;
import com.facebook.ui.choreographer.ChoreographerWrapper;
import com.facebook.ui.choreographer.DefaultChoreographerWrapper;
import com.facebook.ui.choreographer.FrameCallbackWrapper;
import com.facebook.ui.dialogs.FbAlertDialogBuilder;
import com.facebook.ui.media.attachments.MediaResource;
import com.facebook.ui.media.attachments.MediaResource.Source;
import com.facebook.ui.media.attachments.MediaResource.Type;
import com.facebook.ui.toaster.ToastBuilder;
import com.facebook.ui.toaster.Toaster;
import com.facebook.ultralight.Lazy;
import com.facebook.ultralight.UltralightRuntime;
import com.facebook.video.analytics.VideoAnalytics.EventTriggerType;
import com.facebook.video.analytics.VideoAnalytics.StreamSourceType;
import com.facebook.video.engine.VideoDataSourceBuilder;
import com.facebook.video.engine.VideoPlayerParams;
import com.facebook.video.engine.VideoPlayerParamsBuilder;
import com.facebook.video.player.InlineVideoView;
import com.facebook.widget.ChildSharingFrameLayout;
import com.facebook.widget.ViewStubHolder;
import com.facebook.widget.ViewStubHolder.OnInflateListener;
import com.google.common.base.Function;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import com.google.common.io.Files;
import com.google.common.util.concurrent.AsyncFunction;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;
import com.google.common.util.concurrent.SettableFuture;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.CancellationException;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: deltaPaymentMethodRemoved */
public class QuickCamKeyboardView extends ChildSharingFrameLayout {
    private static final SpringConfig f16541D = SpringConfig.a(140.0d, 10.0d);
    @Inject
    @IsWorkBuild
    Boolean f16542A;
    @Inject
    GlyphColorizer f16543B;
    @Inject
    QeAccessor f16544C;
    @Inject
    @Lazy
    public com.facebook.inject.Lazy<WebrtcUiHandler> f16545E = UltralightRuntime.b;
    public final View f16546F;
    public final View f16547G;
    public final CameraFlash f16548H;
    public final View f16549I;
    public final View f16550J;
    public final View f16551K;
    public final ViewGroup f16552L;
    public final FbTextView f16553M;
    public final View f16554N;
    public final ImageView f16555O;
    public final FbTextView f16556P;
    public final ProgressBar f16557Q;
    public final View f16558R;
    public final FbTextView f16559S;
    public final View f16560T;
    public final InlineVideoView f16561U;
    private final ViewStub f16562V;
    public final List<View> f16563W;
    @Inject
    DefaultAndroidThreadUtil f16564a;
    public boolean aA;
    public boolean aB;
    public long aC;
    public int aD;
    public boolean aE = true;
    public boolean aF = true;
    public long aG;
    private int aH;
    public int aI;
    public final PhotoEditingController aJ;
    public PhotoEditingConfig aK;
    public int aL;
    private final ViewStubHolder<PermissionRequestKeyboardView> aa;
    public ChildSharingFrameLayout ab;
    public final int ac;
    public final int ad;
    public final int ae;
    public ColorDrawable af;
    private final Spring ag;
    public final Spring ah;
    private final Spring ai;
    public final Spring aj;
    private final CaptureButtonListener ak = new CaptureButtonListener(this);
    public final FrameCallbackWrapper al;
    public final OrientationEventListener am = new QuickCamOrientationListener(this);
    public final ViewOrientationLockHelper an;
    private final ImagePreview ao = new ImagePreview(this);
    public final VideoPreview ap = new VideoPreview(this);
    public GestureDetectorCompat aq;
    public 1 ar;
    public ThreadKey as;
    public ThreadKey at;
    public boolean au;
    public boolean av = true;
    public boolean aw;
    private boolean ax;
    public boolean ay;
    public boolean az;
    @Inject
    BetterRotationManager f16565b;
    @Inject
    BitmapHolder f16566c;
    @Inject
    BitmapHolder f16567d;
    @Inject
    ChoreographerWrapper f16568e;
    @Inject
    public Clock f16569f;
    @Inject
    @ForUiThread
    public Executor f16570g;
    @Inject
    AbstractFbErrorReporter f16571h;
    @Inject
    public FbSharedPreferences f16572i;
    @DefaultExecutorService
    @Inject
    public ListeningExecutorService f16573j;
    @Inject
    public MediaOperations f16574k;
    @Inject
    public MessengerSoundUtil f16575l;
    @Inject
    PhotoEditingControllerProvider f16576m;
    @IsQuickCamVideoEnabled
    @Inject
    Provider<Boolean> f16577n;
    @Inject
    @IsForceFullscreenQuickCamEnabled
    Provider<Boolean> f16578o;
    @Inject
    @IsPhotosAutoSaveAvailable
    Provider<Boolean> f16579p;
    @Inject
    public QuickCamAsync f16580q;
    @Inject
    QuickCamBitmapUtil f16581r;
    @Inject
    QuickCamEventLogger f16582s;
    @Inject
    public QuickCamViewportController f16583t;
    @Inject
    QuickExperimentController f16584u;
    @Inject
    public RuntimePermissionsUtil f16585v;
    @Inject
    SpringSystem f16586w;
    @Inject
    Toaster f16587x;
    @Inject
    ViewOrientationLockHelperProvider f16588y;
    @Inject
    QuickCamPermissionsHolder f16589z;

    /* compiled from: deltaPaymentMethodRemoved */
    class C19441 implements OnInflateListener<PermissionRequestKeyboardView> {
        final /* synthetic */ QuickCamKeyboardView f16503a;

        /* compiled from: deltaPaymentMethodRemoved */
        class C19431 implements OnClickListener {
            final /* synthetic */ C19441 f16502a;

            C19431(C19441 c19441) {
                this.f16502a = c19441;
            }

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, -937471126);
                if (this.f16502a.f16503a.ar != null) {
                    1 1 = this.f16502a.f16503a.ar;
                    String[] strArr = this.f16502a.f16503a.f16589z.f16590a;
                    if (1.a.a.s != null) {
                        1.a.a.s.a(strArr);
                    }
                }
                Logger.a(2, EntryType.UI_INPUT_END, 523107662, a);
            }
        }

        C19441(QuickCamKeyboardView quickCamKeyboardView) {
            this.f16503a = quickCamKeyboardView;
        }

        public final void m16546a(View view) {
            ((PermissionRequestKeyboardView) view).setButtonListener(new C19431(this));
        }
    }

    /* compiled from: deltaPaymentMethodRemoved */
    class C19452 extends FrameCallbackWrapper {
        final /* synthetic */ QuickCamKeyboardView f16504a;

        C19452(QuickCamKeyboardView quickCamKeyboardView) {
            this.f16504a = quickCamKeyboardView;
        }

        public final void m16547a(long j) {
            int a = (int) (this.f16504a.f16569f.a() - this.f16504a.aG);
            if (a < 15300) {
                this.f16504a.f16557Q.setProgress(a);
                this.f16504a.f16559S.setText(String.format("0:%02d", new Object[]{Integer.valueOf(Math.max(1, (a + 500) / 1000))}));
                this.f16504a.f16568e.a(this.f16504a.al);
                return;
            }
            this.f16504a.f16580q.m6385e();
        }
    }

    /* compiled from: deltaPaymentMethodRemoved */
    class C19463 implements CameraPreviewListener {
        final /* synthetic */ QuickCamKeyboardView f16505a;

        C19463(QuickCamKeyboardView quickCamKeyboardView) {
            this.f16505a = quickCamKeyboardView;
        }

        public final void mo687a() {
            QuickCamKeyboardView.m16586T(this.f16505a);
        }
    }

    /* compiled from: deltaPaymentMethodRemoved */
    class C19474 implements Listener {
        final /* synthetic */ QuickCamKeyboardView f16506a;

        C19474(QuickCamKeyboardView quickCamKeyboardView) {
            this.f16506a = quickCamKeyboardView;
        }

        public final void mo442a() {
            QuickCamKeyboardView.m16576B(this.f16506a);
        }

        public final void mo443b() {
            this.f16506a.requestFocus();
        }
    }

    /* compiled from: deltaPaymentMethodRemoved */
    public class C19485 implements OnClickListener {
        final /* synthetic */ QuickCamKeyboardView f16507a;

        public C19485(QuickCamKeyboardView quickCamKeyboardView) {
            this.f16507a = quickCamKeyboardView;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -156573952);
            if (this.f16507a.f16551K.isPressed() || this.f16507a.f16558R.isPressed() || this.f16507a.aw) {
                Logger.a(2, EntryType.UI_INPUT_END, 1254789691, a);
                return;
            }
            this.f16507a.f16580q.m6383c();
            LogUtils.a(-868366722, a);
        }
    }

    /* compiled from: deltaPaymentMethodRemoved */
    public class C19496 implements OnClickListener {
        final /* synthetic */ QuickCamKeyboardView f16508a;

        public C19496(QuickCamKeyboardView quickCamKeyboardView) {
            this.f16508a = quickCamKeyboardView;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 741115568);
            if (this.f16508a.f16551K.isPressed() || this.f16508a.f16558R.isPressed() || this.f16508a.aw) {
                Logger.a(2, EntryType.UI_INPUT_END, -595874451, a);
                return;
            }
            if (QuickCamKeyboardView.m16585R(this.f16508a)) {
                this.f16508a.f16582s.m16534c(this.f16508a.f16580q);
                QuickCamKeyboardView.m16578D(this.f16508a);
            } else {
                this.f16508a.f16582s.m16531a(this.f16508a.f16580q);
                this.f16508a.au = true;
                this.f16508a.m16611b();
            }
            LogUtils.a(1975553076, a);
        }
    }

    /* compiled from: deltaPaymentMethodRemoved */
    class C19518 implements DialogInterface.OnClickListener {
        final /* synthetic */ QuickCamKeyboardView f16511a;

        C19518(QuickCamKeyboardView quickCamKeyboardView) {
            this.f16511a = quickCamKeyboardView;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            QuickCamKeyboardView.ad(this.f16511a);
            dialogInterface.dismiss();
        }
    }

    /* compiled from: deltaPaymentMethodRemoved */
    class C19529 implements DialogInterface.OnClickListener {
        final /* synthetic */ QuickCamKeyboardView f16512a;

        C19529(QuickCamKeyboardView quickCamKeyboardView) {
            this.f16512a = quickCamKeyboardView;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            dialogInterface.dismiss();
        }
    }

    /* compiled from: deltaPaymentMethodRemoved */
    public class AddToGallery extends AbstractDisposableFutureCallback<MediaResource> {
        final /* synthetic */ QuickCamKeyboardView f16518a;

        public AddToGallery(QuickCamKeyboardView quickCamKeyboardView) {
            this.f16518a = quickCamKeyboardView;
        }

        protected final void m16554a(Object obj) {
            final MediaResource mediaResource = (MediaResource) obj;
            if (((Boolean) this.f16518a.f16579p.get()).booleanValue() && this.f16518a.f16585v.a("android.permission.WRITE_EXTERNAL_STORAGE") && !ThreadKey.g(this.f16518a.as)) {
                TriState b = this.f16518a.f16572i.b(QuickCamPrefKeys.f16607a);
                if (b == TriState.UNSET && this.f16518a.aF) {
                    final Editor edit = this.f16518a.f16572i.edit();
                    FbAlertDialogBuilder fbAlertDialogBuilder = new FbAlertDialogBuilder(this.f16518a.getContext());
                    fbAlertDialogBuilder.a(2131232219);
                    fbAlertDialogBuilder.b(this.f16518a.f16542A.booleanValue() ? 2131232221 : 2131232220);
                    fbAlertDialogBuilder.a(2131232222, new DialogInterface.OnClickListener(this) {
                        final /* synthetic */ AddToGallery f16515c;

                        public void onClick(DialogInterface dialogInterface, int i) {
                            edit.putBoolean(QuickCamPrefKeys.f16607a, true);
                            edit.commit();
                            HoneyClientEventFast a = this.f16515c.f16518a.f16582s.f16498a.a("messenger_quickcam_save_enabled", false);
                            if (a.a()) {
                                a.b();
                            }
                            AddToGallery.m16553b(this.f16515c, mediaResource);
                        }
                    });
                    fbAlertDialogBuilder.b(2131232223, new DialogInterface.OnClickListener(this) {
                        final /* synthetic */ AddToGallery f16517b;

                        public void onClick(DialogInterface dialogInterface, int i) {
                            edit.putBoolean(QuickCamPrefKeys.f16607a, false);
                            edit.commit();
                        }
                    });
                    fbAlertDialogBuilder.b();
                    HoneyClientEventFast a = this.f16518a.f16582s.f16498a.a("messenger_quickcam_save_dialog_shown", false);
                    if (a.a()) {
                        a.b();
                    }
                } else if (b == TriState.YES) {
                    m16553b(this, mediaResource);
                }
            }
        }

        protected final void m16555a(Throwable th) {
            AbstractFbErrorReporter abstractFbErrorReporter = this.f16518a.f16571h;
            SoftErrorBuilder a = SoftError.a("quick cam popup", th.getMessage());
            a.c = th;
            abstractFbErrorReporter.a(a.g());
            QuickCamKeyboardView.m16578D(this.f16518a);
        }

        public static void m16553b(AddToGallery addToGallery, MediaResource mediaResource) {
            if (mediaResource.d == Type.PHOTO) {
                addToGallery.m16552b(mediaResource.c);
            } else if (mediaResource.d == Type.VIDEO) {
                addToGallery.m16551a(mediaResource.c);
            }
        }

        private void m16551a(Uri uri) {
            try {
                File file = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM), "Camera");
                file.mkdirs();
                File file2 = new File(file, "QuickCam_" + Long.valueOf(this.f16518a.f16569f.a()).toString() + ".mp4");
                Files.a(new File(uri.getPath()), file2);
                Intent intent = new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE");
                intent.setData(Uri.fromFile(file2));
                this.f16518a.getContext().sendBroadcast(intent);
            } catch (IOException e) {
                this.f16518a.f16587x.b(new ToastBuilder(2131232225));
            }
        }

        private void m16552b(Uri uri) {
            try {
                Media.insertImage(this.f16518a.getContext().getContentResolver(), uri.getPath(), String.format(Locale.US, "messenger-quick-cam-%d", new Object[]{Long.valueOf(this.f16518a.f16569f.a())}), null);
                ContentValues contentValues = new ContentValues();
                contentValues.put("datetaken", Long.valueOf(r0));
                String[] strArr = new String[]{r2};
                this.f16518a.getContext().getContentResolver().update(Media.EXTERNAL_CONTENT_URI, contentValues, "title=?", strArr);
            } catch (IOException e) {
                this.f16518a.f16587x.b(new ToastBuilder(2131232224));
            }
        }
    }

    /* compiled from: deltaPaymentMethodRemoved */
    class CaptureButtonListener implements OnClickListener, OnLongClickListener, OnTouchListener {
        final /* synthetic */ QuickCamKeyboardView f16519a;
        private boolean f16520b;

        public CaptureButtonListener(QuickCamKeyboardView quickCamKeyboardView) {
            this.f16519a = quickCamKeyboardView;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 1674837018);
            QuickCamKeyboardView quickCamKeyboardView = this.f16519a;
            long a2 = quickCamKeyboardView.f16569f.a();
            if (a2 > quickCamKeyboardView.aC) {
                quickCamKeyboardView.aw = true;
                quickCamKeyboardView.aC = a2 + 500;
                quickCamKeyboardView.f16575l.d();
                QuickCamPreviewHolder quickCamPreviewHolder = quickCamKeyboardView.f16583t.f6116a;
                if (quickCamPreviewHolder.mo238a()) {
                    Source source = quickCamKeyboardView.f16580q.m6388h() ? Source.QUICKCAM_FRONT : Source.QUICKCAM_BACK;
                    Builder builder = new Builder();
                    builder.f16426a = quickCamKeyboardView.f16583t.m6472d().getWidth();
                    builder = builder;
                    builder.f16427b = quickCamKeyboardView.f16583t.m6472d().getHeight();
                    Builder a3 = builder.m16483b(QuickCamKeyboardView.getCroppedBitmapWidth(quickCamKeyboardView), QuickCamKeyboardView.getCroppedBitmapHeight(quickCamKeyboardView)).m16484c(quickCamKeyboardView.aL).m16481a(source);
                    a3.f16432g = CaptureType.TEXTURE;
                    a3 = a3;
                    a3.f16433h = QuickCamKeyboardView.m16585R(quickCamKeyboardView);
                    QuickCamKeyboardView.m16595a(quickCamKeyboardView, a3.m16482a(), quickCamKeyboardView.f16574k.m16473a(quickCamPreviewHolder));
                } else {
                    quickCamKeyboardView.f16580q.m6384d();
                }
            }
            Logger.a(2, EntryType.UI_INPUT_END, -1903464056, a);
        }

        public boolean onLongClick(View view) {
            boolean z;
            this.f16519a.aw = true;
            this.f16519a.f16580q.m6378a(this.f16519a.aL);
            this.f16520b = true;
            QuickCamKeyboardView quickCamKeyboardView = this.f16519a;
            if (QuickCamKeyboardView.m16585R(this.f16519a) || QuickCamKeyboardView.m16589W(this.f16519a)) {
                z = true;
            } else {
                z = false;
            }
            quickCamKeyboardView.ay = z;
            QuickCamKeyboardView quickCamKeyboardView2 = this.f16519a;
            QuickCamBitmapUtil quickCamBitmapUtil = this.f16519a.f16581r;
            quickCamKeyboardView2.aD = QuickCamBitmapUtil.m6391a(this.f16519a.f16565b.a(), this.f16519a.aL);
            return true;
        }

        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (this.f16520b) {
                motionEvent.offsetLocation(0.0f, (float) this.f16519a.f16546F.getTop());
                switch (motionEvent.getAction()) {
                    case 1:
                        if (ViewPositionUtil.b(motionEvent, view)) {
                            this.f16519a.f16580q.m6386f();
                        } else {
                            this.f16519a.f16580q.m6387g();
                            this.f16519a.aw = false;
                        }
                        this.f16520b = false;
                        break;
                    case 2:
                        QuickCamKeyboardView quickCamKeyboardView;
                        if (!ViewPositionUtil.b(motionEvent, view)) {
                            Object obj;
                            if (this.f16519a.getVisibility() == 0) {
                                obj = 1;
                            } else {
                                obj = null;
                            }
                            if (obj != null) {
                                quickCamKeyboardView = this.f16519a;
                                quickCamKeyboardView.f16560T.setVisibility(0);
                                quickCamKeyboardView.f16556P.setText(2131232218);
                                quickCamKeyboardView.f16557Q.setProgressDrawable(quickCamKeyboardView.getResources().getDrawable(2130842253));
                                break;
                            }
                        }
                        quickCamKeyboardView = this.f16519a;
                        quickCamKeyboardView.f16560T.setVisibility(8);
                        quickCamKeyboardView.f16556P.setText(2131232217);
                        quickCamKeyboardView.f16557Q.setProgressDrawable(quickCamKeyboardView.getResources().getDrawable(2130842254));
                        if (!view.isPressed()) {
                            view.setPressed(true);
                            break;
                        }
                        break;
                    case 3:
                        this.f16519a.f16580q.m6387g();
                        this.f16520b = false;
                        this.f16519a.aw = false;
                        break;
                    default:
                        break;
                }
            }
            return false;
        }
    }

    /* compiled from: deltaPaymentMethodRemoved */
    class ClampedIsRotatedSpringListener extends SimpleSpringListener {
        final /* synthetic */ QuickCamKeyboardView f16521a;

        public ClampedIsRotatedSpringListener(QuickCamKeyboardView quickCamKeyboardView) {
            this.f16521a = quickCamKeyboardView;
        }

        public final void m16556a(Spring spring) {
            QuickCamKeyboardView.m16605v(this.f16521a);
        }
    }

    /* compiled from: deltaPaymentMethodRemoved */
    class Flash implements FutureCallback<Bitmap> {
        final /* synthetic */ QuickCamKeyboardView f16522a;

        public Flash(QuickCamKeyboardView quickCamKeyboardView) {
            this.f16522a = quickCamKeyboardView;
        }

        public void onSuccess(@Nullable Object obj) {
            this.f16522a.f16548H.m16470a();
        }

        public void onFailure(Throwable th) {
        }
    }

    /* compiled from: deltaPaymentMethodRemoved */
    class IconRotationSpringListener extends SimpleSpringListener {
        final /* synthetic */ QuickCamKeyboardView f16523a;

        public IconRotationSpringListener(QuickCamKeyboardView quickCamKeyboardView) {
            this.f16523a = quickCamKeyboardView;
        }

        public final void m16557a(Spring spring) {
            float d = (float) spring.d();
            for (View rotation : this.f16523a.f16563W) {
                rotation.setRotation(d);
            }
            PhotoEditingController photoEditingController = this.f16523a.aJ;
            photoEditingController.f16083d.m16273a(d);
            SceneLayersPresenter sceneLayersPresenter = photoEditingController.f16088i;
            sceneLayersPresenter.f16217k = d;
            for (LayerPresenter a : sceneLayersPresenter.f16210d.values()) {
                a.m16185a(d);
            }
            photoEditingController.f16095p = d;
        }
    }

    /* compiled from: deltaPaymentMethodRemoved */
    public class ImagePreview implements AsyncFunction<Bitmap, Bitmap> {
        final /* synthetic */ QuickCamKeyboardView f16527a;
        public SettableFuture<Bitmap> f16528b;

        /* compiled from: deltaPaymentMethodRemoved */
        class C19551 implements OnClickListener {
            final /* synthetic */ ImagePreview f16524a;

            C19551(ImagePreview imagePreview) {
                this.f16524a = imagePreview;
            }

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, 596142667);
                if (this.f16524a.f16527a.aJ.m16254b()) {
                    QuickCamKeyboardView.m16590Y(this.f16524a.f16527a);
                } else {
                    this.f16524a.m16559a();
                }
                LogUtils.a(-844936498, a);
            }
        }

        public ImagePreview(QuickCamKeyboardView quickCamKeyboardView) {
            this.f16527a = quickCamKeyboardView;
        }

        public final ListenableFuture m16558a(Object obj) {
            final Bitmap bitmap = (Bitmap) obj;
            this.f16527a.f16544C.a(Liveness.Cached, ExperimentsForMessagingQuickCamModule.f16606c);
            this.f16528b = SettableFuture.f();
            this.f16527a.f16555O.setImageBitmap(bitmap);
            this.f16527a.az = true;
            QuickCamKeyboardView.m16576B(this.f16527a);
            this.f16527a.f16550J.setOnClickListener(new C19551(this));
            this.f16527a.f16558R.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ ImagePreview f16526b;

                public void onClick(View view) {
                    int a = Logger.a(2, EntryType.UI_INPUT_START, 1243273004);
                    if (this.f16526b.f16528b == null) {
                        Logger.a(2, EntryType.UI_INPUT_END, 1189894944, a);
                        return;
                    }
                    boolean z = this.f16526b.f16527a.aK.m16227b() && QuickCamKeyboardView.m16585R(this.f16526b.f16527a);
                    FutureDetour.a(this.f16526b.f16528b, z ? this.f16526b.f16527a.aJ.m16251a(bitmap) : bitmap, -470287481);
                    this.f16526b.f16528b = null;
                    this.f16526b.f16527a.az = false;
                    this.f16526b.f16527a.aJ.m16265t();
                    QuickCamKeyboardView.m16576B(this.f16526b.f16527a);
                    LogUtils.a(1943859501, a);
                }
            });
            return this.f16528b;
        }

        public final void m16559a() {
            if (this.f16528b != null) {
                this.f16528b.cancel(true);
                this.f16528b = null;
            }
            this.f16527a.az = false;
            this.f16527a.aJ.m16265t();
            QuickCamKeyboardView.m16576B(this.f16527a);
        }
    }

    /* compiled from: deltaPaymentMethodRemoved */
    class OnCameraGestureListener extends SimpleOnGestureListener {
        final /* synthetic */ QuickCamKeyboardView f16529a;

        public OnCameraGestureListener(QuickCamKeyboardView quickCamKeyboardView) {
            this.f16529a = quickCamKeyboardView;
        }

        public boolean onDown(MotionEvent motionEvent) {
            return true;
        }

        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            this.f16529a.ah.a((double) (((float) this.f16529a.ah.d()) + (f2 / ((float) (this.f16529a.getResources().getDisplayMetrics().heightPixels - this.f16529a.getHeight()))))).l();
            return true;
        }

        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            if (QuickCamKeyboardView.m16589W(this.f16529a) || Math.abs(f2) < ((float) this.f16529a.ad)) {
                return false;
            }
            this.f16529a.ah.c((double) ((-f2) / (((float) this.f16529a.getResources().getDisplayMetrics().heightPixels) - ((float) this.f16529a.getHeight()))));
            if (f2 > 0.0f) {
                this.f16529a.m16612e();
                this.f16529a.f16582s.m16535d(this.f16529a.f16580q);
            } else {
                this.f16529a.au = true;
                this.f16529a.m16611b();
                this.f16529a.f16582s.m16533b(this.f16529a.f16580q);
            }
            return true;
        }

        public boolean onSingleTapUp(MotionEvent motionEvent) {
            this.f16529a.f16583t.m6464a((int) motionEvent.getX(), (int) motionEvent.getY());
            return true;
        }
    }

    /* compiled from: deltaPaymentMethodRemoved */
    public class OnCameraTouchListener implements OnTouchListener {
        final /* synthetic */ QuickCamKeyboardView f16530a;

        public OnCameraTouchListener(QuickCamKeyboardView quickCamKeyboardView) {
            this.f16530a = quickCamKeyboardView;
        }

        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (QuickCamKeyboardView.m16589W(this.f16530a) || this.f16530a.aw) {
                return true;
            }
            if (this.f16530a.aq == null && motionEvent.getAction() == 0) {
                this.f16530a.aq = new GestureDetectorCompat(this.f16530a.getContext(), new OnCameraGestureListener(this.f16530a));
            }
            if (this.f16530a.aq == null) {
                return false;
            }
            float rawY = motionEvent.getRawY() - motionEvent.getY();
            motionEvent.offsetLocation(0.0f, rawY);
            boolean a = this.f16530a.aq.a(motionEvent);
            motionEvent.offsetLocation(0.0f, -rawY);
            if (motionEvent.getAction() == 1) {
                this.f16530a.aq = null;
                if (a) {
                    return a;
                }
                if (this.f16530a.ah.i > 0.5d) {
                    this.f16530a.au = true;
                    this.f16530a.m16611b();
                    this.f16530a.f16582s.m16533b(this.f16530a.f16580q);
                    return a;
                }
                this.f16530a.m16612e();
                this.f16530a.f16582s.m16535d(this.f16530a.f16580q);
                return a;
            } else if (motionEvent.getAction() != 3) {
                return a;
            } else {
                this.f16530a.m16580H();
                return a;
            }
        }
    }

    /* compiled from: deltaPaymentMethodRemoved */
    class PopOutSpringListener extends SimpleSpringListener {
        final /* synthetic */ QuickCamKeyboardView f16531a;

        public PopOutSpringListener(QuickCamKeyboardView quickCamKeyboardView) {
            this.f16531a = quickCamKeyboardView;
        }

        public final void m16562d(Spring spring) {
            QuickCamKeyboardView.m16576B(this.f16531a);
        }

        public final void m16560a(Spring spring) {
            int i = 0;
            if (this.f16531a.getParent() != null && this.f16531a.aE && !QuickCamKeyboardView.m16588V(this.f16531a)) {
                int width;
                float d = (float) this.f16531a.ah.d();
                float d2 = (float) this.f16531a.aj.d();
                float max = Math.max(d, d2);
                if (!(d == 0.0f && d2 == 0.0f)) {
                    QuickCamKeyboardView.aa(this.f16531a);
                }
                float f = ((float) this.f16531a.ac) * d;
                this.f16531a.f16554N.setTranslationY(-f);
                this.f16531a.f16549I.setTranslationY(-f);
                int d3 = this.f16531a.f16583t.m6471d(this.f16531a.getHeight(), this.f16531a.getWidth());
                int width2 = (int) (((float) this.f16531a.f16547G.getWidth()) * 0.75f);
                if (d != 0.0f) {
                    width = this.f16531a.ab.getWidth();
                    i = this.f16531a.ab.getHeight();
                    if (this.f16531a.ab.getFitsSystemWindows()) {
                        width = (width - this.f16531a.ab.getPaddingLeft()) - this.f16531a.ab.getPaddingRight();
                        i = (i - this.f16531a.ab.getPaddingTop()) - this.f16531a.ab.getPaddingBottom();
                    }
                } else {
                    width = 0;
                }
                float max2 = ((float) this.f16531a.ae) * Math.max(0.0f, d2 - Math.max(0.0f, d));
                float b = MathUtil.b(d2, 0.0f, 1.0f);
                float b2 = MathUtil.b(d, 0.0f, 1.0f);
                width = MathUtil.a(MathUtil.a(d3, d3, b), width, b2);
                int a = MathUtil.a(MathUtil.a(this.f16531a.getHeight(), width2, d2), i, d);
                i = MathUtil.a(MathUtil.a(this.f16531a.getHeight(), width2, b), i, b2);
                LayoutParamsUtil.a(this.f16531a.f16547G, width);
                LayoutParamsUtil.a(this.f16531a.f16546F, width, i);
                LayoutParamsUtil.a(this.f16531a.f16560T, width, i);
                LayoutParamsUtil.a(this.f16531a.f16552L, width, i);
                LayoutParamsUtil.a(this.f16531a.f16557Q, width, this.f16531a.aI);
                this.f16531a.f16583t.m6468b(width, i);
                this.f16531a.f16546F.setTranslationY(((float) ((i - a) / 2)) + max2);
                if (this.f16531a.af != null) {
                    this.f16531a.af.mutate().setAlpha((int) (MathUtil.b(max, 0.0f, 1.0f) * 255.0f));
                }
                this.f16531a.f16557Q.getBackground().mutate().setAlpha((int) (100.0f * b2));
                QuickCamKeyboardView.m16576B(this.f16531a);
            }
        }

        public final void m16561b(Spring spring) {
            if (this.f16531a.ah.k() && this.f16531a.aj.k() && this.f16531a.ah.d() == 0.0d && this.f16531a.aj.d() == 0.0d) {
                QuickCamKeyboardView.ac(this.f16531a);
            }
        }
    }

    /* compiled from: deltaPaymentMethodRemoved */
    class QuickCamAsyncListener implements QuickCamAsync.Listener {
        final /* synthetic */ QuickCamKeyboardView f16532a;

        public QuickCamAsyncListener(QuickCamKeyboardView quickCamKeyboardView) {
            this.f16532a = quickCamKeyboardView;
        }

        public final void mo688a() {
            QuickCamKeyboardView.m16586T(this.f16532a);
            this.f16532a.f16583t.m6470c();
            if (this.f16532a.f16546F.getParent() != this) {
                QuickCamKeyboardView.m16594a(this.f16532a, this.f16532a.f16546F.getWidth(), this.f16532a.f16546F.getHeight());
            }
            this.f16532a.f16583t.m6472d().setTranslationX(0.0f);
        }

        public final void mo691b() {
            this.f16532a.f16583t.m6472d().setTranslationX(10000.0f);
        }

        public final void mo692c() {
            if (QuickCamKeyboardView.m16588V(this.f16532a)) {
                QuickCamKeyboardView.m16594a(this.f16532a, this.f16532a.getMeasuredWidth(), this.f16532a.getMeasuredHeight());
            }
            this.f16532a.f16549I.setSelected(this.f16532a.f16580q.m6388h());
        }

        public final void mo690a(byte[] bArr, int i, int i2, boolean z) {
            Builder a = new Builder().m16480a(i, i2).m16483b(QuickCamKeyboardView.getCroppedBitmapWidth(this.f16532a), QuickCamKeyboardView.getCroppedBitmapHeight(this.f16532a)).m16484c(this.f16532a.aL).m16481a(z ? Source.QUICKCAM_FRONT : Source.QUICKCAM_BACK);
            a.f16432g = CaptureType.CAMERA_PREVIEW;
            a = a;
            a.f16433h = QuickCamKeyboardView.m16585R(this.f16532a);
            QuickCamKeyboardView.m16595a(this.f16532a, a.m16482a(), this.f16532a.f16574k.m16474a(bArr));
        }

        public final void mo693d() {
            this.f16532a.f16564a.a();
            this.f16532a.at = this.f16532a.as;
            this.f16532a.aA = true;
            this.f16532a.aG = this.f16532a.f16569f.a() + 400;
            this.f16532a.f16568e.a(this.f16532a.al, 400);
            Spring spring = this.f16532a.aj;
            spring.c = QuickCamKeyboardView.m16585R(this.f16532a);
            spring.b(1.0d);
            QuickCamKeyboardView.m16579G(this.f16532a);
            QuickCamKeyboardView.m16599m(this.f16532a);
        }

        public final void mo694e() {
            this.f16532a.f16564a.a();
            Spring spring = this.f16532a.aj;
            spring.c = true;
            spring.b(0.0d);
            this.f16532a.aA = false;
            this.f16532a.f16568e.b(this.f16532a.al);
            this.f16532a.m16580H();
            QuickCamKeyboardView.m16599m(this.f16532a);
        }

        public final void mo689a(@Nullable Uri uri, @Nullable CamcorderProfile camcorderProfile, boolean z, int i) {
            this.f16532a.f16564a.a();
            if (uri != null) {
                VideoParams.Builder a = new VideoParams.Builder().m16618a(camcorderProfile.videoFrameWidth, camcorderProfile.videoFrameHeight).m16617a(i).m16619a(z ? Source.QUICKCAM_FRONT : Source.QUICKCAM_BACK);
                a.f16596e = this.f16532a.ay;
                VideoParams a2 = a.m16620a();
                QuickCamKeyboardView quickCamKeyboardView = this.f16532a;
                ThreadKey threadKey = this.f16532a.at;
                ListenableFuture a3 = Futures.a(Futures.b(Futures.a(uri), quickCamKeyboardView.ap, quickCamKeyboardView.f16570g), new SaveVideo(quickCamKeyboardView.f16574k, a2), quickCamKeyboardView.f16573j);
                Futures.a(a3, new SendMedia(quickCamKeyboardView, threadKey), quickCamKeyboardView.f16570g);
                Futures.a(a3, new AddToGallery(quickCamKeyboardView), quickCamKeyboardView.f16570g);
            }
        }

        public final void mo695f() {
            QuickCamKeyboardView quickCamKeyboardView = this.f16532a;
            quickCamKeyboardView.f16553M.setVisibility(0);
            quickCamKeyboardView.f16583t.m6463a(8);
            QuickCamKeyboardView.m16576B(quickCamKeyboardView);
        }
    }

    /* compiled from: deltaPaymentMethodRemoved */
    class QuickCamOrientationListener extends OrientationEventListener {
        final /* synthetic */ QuickCamKeyboardView f16533a;

        public QuickCamOrientationListener(QuickCamKeyboardView quickCamKeyboardView) {
            this.f16533a = quickCamKeyboardView;
            super(quickCamKeyboardView.getContext(), 2);
        }

        public void onOrientationChanged(int i) {
            this.f16533a.m16609a(this.f16533a.f16565b.a(i));
        }
    }

    /* compiled from: deltaPaymentMethodRemoved */
    public class SendMedia extends AbstractDisposableFutureCallback<MediaResource> {
        public final /* synthetic */ QuickCamKeyboardView f16534a;
        private final ThreadKey f16535b;

        protected final void m16571a(Object obj) {
            MediaResource mediaResource = (MediaResource) obj;
            Preconditions.checkNotNull(mediaResource);
            this.f16534a.f16564a.a();
            if (this.f16534a.ar != null) {
                1 1 = this.f16534a.ar;
                if (Objects.equal(1.a.a.t, this.f16535b) && 1.a.a.s != null) {
                    1.a.a.s.a(mediaResource);
                }
                int a;
                if (mediaResource.d == Type.PHOTO) {
                    a = this.f16534a.f16572i.a(MessagingPrefKeys.ap, 0);
                    if (a < 3) {
                        this.f16534a.f16572i.edit().a(MessagingPrefKeys.ap, a + 1).commit();
                    }
                    this.f16534a.f16582s.m16532a(this.f16534a.f16580q, QuickCamKeyboardView.m16585R(this.f16534a), this.f16534a.aJ.f16099t, this.f16534a.aJ.f16100u, this.f16534a.aJ.f16101v, this.f16534a.aJ.f16097r, this.f16534a.aJ.f16098s);
                } else if (mediaResource.d == Type.VIDEO) {
                    a = this.f16534a.f16572i.a(MessagingPrefKeys.ao, 0);
                    if (a < 3) {
                        this.f16534a.f16572i.edit().a(MessagingPrefKeys.ao, a + 1).commit();
                    }
                }
                QuickCamKeyboardView.m16605v(this.f16534a);
                this.f16534a.aw = false;
                if (this.f16534a.av) {
                    QuickCamKeyboardView.m16578D(this.f16534a);
                }
            }
        }

        public SendMedia(QuickCamKeyboardView quickCamKeyboardView, ThreadKey threadKey) {
            this.f16534a = quickCamKeyboardView;
            this.f16535b = threadKey;
        }

        protected final void m16572a(Throwable th) {
            AbstractFbErrorReporter abstractFbErrorReporter = this.f16534a.f16571h;
            SoftErrorBuilder a = SoftError.a("quick cam popup", th.getMessage());
            a.c = th;
            abstractFbErrorReporter.a(a.g());
            this.f16534a.f16587x.b(new ToastBuilder(2131230758));
            this.f16534a.aw = false;
            QuickCamKeyboardView.m16578D(this.f16534a);
        }

        protected final void m16573a(CancellationException cancellationException) {
            super.a(cancellationException);
            this.f16534a.aw = false;
        }
    }

    /* compiled from: deltaPaymentMethodRemoved */
    public class VideoPreview implements AsyncFunction<Uri, Uri> {
        public final /* synthetic */ QuickCamKeyboardView f16539a;
        public SettableFuture<Uri> f16540b;

        /* compiled from: deltaPaymentMethodRemoved */
        class C19571 implements OnClickListener {
            final /* synthetic */ VideoPreview f16536a;

            C19571(VideoPreview videoPreview) {
                this.f16536a = videoPreview;
            }

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, 2101317159);
                this.f16536a.m16575a();
                Logger.a(2, EntryType.UI_INPUT_END, -909714001, a);
            }
        }

        public VideoPreview(QuickCamKeyboardView quickCamKeyboardView) {
            this.f16539a = quickCamKeyboardView;
        }

        public final ListenableFuture m16574a(Object obj) {
            final Uri uri = (Uri) obj;
            VideoDataSourceBuilder videoDataSourceBuilder = new VideoDataSourceBuilder();
            videoDataSourceBuilder.a = uri;
            videoDataSourceBuilder = videoDataSourceBuilder;
            videoDataSourceBuilder.f = StreamSourceType.FROM_LOCAL_STORAGE;
            VideoPlayerParamsBuilder a = new VideoPlayerParamsBuilder().a(videoDataSourceBuilder.i());
            a.g = true;
            VideoPlayerParams m = a.m();
            this.f16540b = SettableFuture.f();
            int width = this.f16539a.f16583t.m6472d().getWidth();
            int height = this.f16539a.f16583t.m6472d().getHeight();
            float translationX = this.f16539a.f16583t.m6472d().getTranslationX();
            float translationY = this.f16539a.f16583t.m6472d().getTranslationY();
            float f = (float) (this.f16539a.aD * 90);
            if (this.f16539a.aD == 1 || this.f16539a.aD == 3) {
                translationX += ((float) (width - height)) / 2.0f;
                translationY += ((float) (height - width)) / 2.0f;
                int i = width;
                width = height;
                height = i;
            }
            this.f16539a.f16561U.setRotation(f);
            LayoutParamsUtil.a(this.f16539a.f16561U, width, height);
            this.f16539a.f16561U.setTranslationX(translationX);
            this.f16539a.f16561U.setTranslationY(translationY);
            this.f16539a.f16561U.setVideoData(m);
            this.f16539a.f16561U.b(EventTriggerType.BY_AUTOPLAY);
            this.f16539a.aB = true;
            QuickCamKeyboardView.m16576B(this.f16539a);
            this.f16539a.f16550J.setOnClickListener(new C19571(this));
            this.f16539a.f16558R.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ VideoPreview f16538b;

                public void onClick(View view) {
                    int a = Logger.a(2, EntryType.UI_INPUT_START, 638446454);
                    if (this.f16538b.f16540b == null) {
                        Logger.a(2, EntryType.UI_INPUT_END, -25817426, a);
                        return;
                    }
                    FutureDetour.a(this.f16538b.f16540b, uri, -1744562800);
                    this.f16538b.f16540b = null;
                    this.f16538b.f16539a.f16561U.c(EventTriggerType.BY_USER);
                    this.f16538b.f16539a.aB = false;
                    QuickCamKeyboardView.m16576B(this.f16538b.f16539a);
                    LogUtils.a(-167399789, a);
                }
            });
            return this.f16540b;
        }

        public final void m16575a() {
            if (this.f16540b != null) {
                this.f16540b.cancel(true);
                this.f16540b = null;
            }
            this.f16539a.f16561U.c(EventTriggerType.BY_USER);
            this.f16539a.aB = false;
            QuickCamKeyboardView.m16576B(this.f16539a);
        }
    }

    public static void m16596a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        ((QuickCamKeyboardView) obj).m16593a(DefaultAndroidThreadUtil.a(injectorLike), BetterRotationManager.a(injectorLike), BitmapHolder.m16464a(injectorLike), BitmapHolder.m16464a(injectorLike), (ChoreographerWrapper) DefaultChoreographerWrapper.a(injectorLike), (Clock) SystemClockMethodAutoProvider.a(injectorLike), (Executor) ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.a(injectorLike), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike), (FbSharedPreferences) FbSharedPreferencesImpl.a(injectorLike), ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider.a(injectorLike), MediaOperations.m16471a(injectorLike), MessengerSoundUtil.a(injectorLike), (PhotoEditingControllerProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(PhotoEditingControllerProvider.class), IdBasedProvider.a(injectorLike, 4199), IdBasedProvider.a(injectorLike, 4194), IdBasedProvider.a(injectorLike, 4195), QuickCamAsync.m6358a(injectorLike), QuickCamBitmapUtil.m6392a(injectorLike), QuickCamEventLogger.m16529a(injectorLike), QuickCamViewportController.m6462a(injectorLike), (QuickExperimentController) QuickExperimentControllerImpl.a(injectorLike), RuntimePermissionsUtil.a(injectorLike), SpringSystem.a(injectorLike), Toaster.a(injectorLike), (ViewOrientationLockHelperProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(ViewOrientationLockHelperProvider.class), QuickCamPermissionsHolderMethodAutoProvider.m16616a(injectorLike), Boolean_IsWorkBuildMethodAutoProvider.a(injectorLike), GlyphColorizer.a(injectorLike), (QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike), IdBasedLazy.a(injectorLike, 10375));
    }

    public QuickCamKeyboardView(Context context) {
        super(context);
        Class cls = QuickCamKeyboardView.class;
        m16596a(this, getContext());
        setContentView(2130905831);
        setClickable(true);
        setFocusableInTouchMode(true);
        Drawable colorDrawable = new ColorDrawable(getResources().getColor(2131362543));
        if (VERSION.SDK_INT >= 16) {
            setBackground(colorDrawable);
        } else {
            setBackgroundDrawable(colorDrawable);
        }
        this.f16546F = c(2131565089);
        this.f16547G = c(2131565000);
        this.f16548H = (CameraFlash) c(2131565096);
        this.f16549I = c(2131565093);
        this.f16550J = c(2131560414);
        this.f16551K = c(2131559850);
        this.f16552L = (ViewGroup) c(2131564505);
        this.f16553M = (FbTextView) c(2131559631);
        this.f16554N = c(2131565092);
        this.f16555O = (ImageView) c(2131564009);
        this.f16556P = (FbTextView) c(2131565094);
        this.f16557Q = (ProgressBar) c(2131559418);
        this.f16558R = c(2131562049);
        this.f16559S = (FbTextView) c(2131565091);
        this.f16560T = c(2131565095);
        this.f16561U = (InlineVideoView) c(2131564010);
        this.f16562V = (ViewStub) c(2131565001);
        this.f16563W = Lists.a(new View[]{this.f16554N, this.f16549I, this.f16558R, this.f16559S});
        this.aa = ViewStubHolder.a((ViewStubCompat) c(2131565090));
        this.aa.c = new C19441(this);
        this.aH = getResources().getColor(2131362544);
        this.ac = getResources().getDimensionPixelOffset(2131427988);
        this.ad = ViewConfiguration.get(context).getScaledMinimumFlingVelocity();
        this.ae = getResources().getDimensionPixelOffset(2131427985);
        this.aI = getResources().getDimensionPixelSize(2131427986);
        PopOutSpringListener popOutSpringListener = new PopOutSpringListener(this);
        Spring a = this.f16586w.a().a(f16541D);
        a.c = false;
        this.ag = a.a(new ClampedIsRotatedSpringListener(this));
        a = this.f16586w.a().a(f16541D);
        a.l = 0.01d;
        a = a;
        a.c = true;
        this.ah = a.a(popOutSpringListener);
        this.ai = this.f16586w.a().a(f16541D).a(new IconRotationSpringListener(this));
        this.aj = this.f16586w.a().a(f16541D).a(popOutSpringListener);
        this.al = new C19452(this);
        this.f16580q.m6380a(new QuickCamAsyncListener(this));
        this.f16580q.m6377a();
        this.f16583t.f6119d = this.f16580q;
        this.f16583t.m6465a(this.f16562V, this.f16547G);
        this.an = this.f16588y.a(this);
        this.f16583t.f6118c = new C19463(this);
        this.aK = new PhotoEditingConfig(this.f16544C.a(Liveness.Cached, ExposureLogging.Off, ExperimentsForMessagingQuickCamModule.f16606c, false), this.f16544C.a(Liveness.Cached, ExposureLogging.Off, ExperimentsForMessagingQuickCamModule.f16605b, false), this.f16544C.a(Liveness.Cached, ExposureLogging.Off, ExperimentsForMessagingQuickCamModule.f16604a, false), true);
        this.aJ = this.f16576m.m16266a(this.aK, this.f16552L, (LayerGroupLayout) this.f16552L.findViewById(2131564008), (PhotoEditingControlsLayout) this.f16552L.findViewById(2131565045), (TextStylesLayout) this.f16552L.findViewById(2131565047), (ImageWithTextView) this.f16552L.findViewById(2131565046));
        this.aJ.f16091l = new C19474(this);
        this.f16546F.setOnTouchListener(new OnCameraTouchListener(this));
        if (!this.f16580q.m6390j()) {
            this.f16549I.setOnClickListener(new C19485(this));
        }
        m16602p();
        this.f16554N.setOnClickListener(new C19496(this));
        if (((WebrtcUiHandler) this.f16545E.get()).m19437M()) {
            this.f16556P.setText(2131232216);
        }
        m16606w();
        m16607x();
        m16576B(this);
        requestFocus();
    }

    public static void m16599m(QuickCamKeyboardView quickCamKeyboardView) {
        if (quickCamKeyboardView.m16584Q() || quickCamKeyboardView.aA || quickCamKeyboardView.f16553M.getVisibility() == 0 || quickCamKeyboardView.f16580q.m6390j()) {
            quickCamKeyboardView.f16549I.setVisibility(8);
            return;
        }
        quickCamKeyboardView.f16549I.setVisibility(0);
        quickCamKeyboardView.f16549I.setEnabled(true);
    }

    private void m16600n() {
        if (!m16584Q() || this.aJ.f16093n || this.aJ.f16092m) {
            this.f16550J.setVisibility(8);
        } else {
            this.f16550J.setVisibility(0);
        }
    }

    private boolean m16601o() {
        return ((Boolean) this.f16577n.get()).booleanValue() && !ThreadKey.g(this.as);
    }

    private void m16602p() {
        this.f16551K.setOnClickListener(this.ak);
        if (m16601o()) {
            this.f16551K.setOnLongClickListener(this.ak);
            this.f16551K.setOnTouchListener(this.ak);
            return;
        }
        this.f16560T.setVisibility(8);
    }

    private void m16603q() {
        if (m16584Q() || this.f16553M.getVisibility() == 0) {
            this.f16551K.setVisibility(8);
        } else {
            this.f16551K.setVisibility(0);
            View view = this.f16551K;
            boolean z = this.ah.g(0.0d) || this.ah.g(1.0d);
            view.setEnabled(z);
        }
        if (!m16601o()) {
            this.f16551K.setOnLongClickListener(null);
            this.f16551K.setOnTouchListener(null);
        }
    }

    private void m16604s() {
        if (!m16584Q() && this.aj.i == 0.0d && this.f16553M.getVisibility() == 8) {
            this.f16554N.setVisibility(0);
            this.f16554N.setEnabled(true);
            this.f16554N.setSelected(m16585R(this));
            return;
        }
        this.f16554N.setVisibility(8);
    }

    public static void m16605v(QuickCamKeyboardView quickCamKeyboardView) {
        float d = 1.0f - ((float) quickCamKeyboardView.ag.d());
        int a = quickCamKeyboardView.f16572i.a(MessagingPrefKeys.ap, 0);
        int a2 = quickCamKeyboardView.f16572i.a(MessagingPrefKeys.ao, 0);
        if (d == 0.0f || quickCamKeyboardView.m16584Q() || !quickCamKeyboardView.m16601o() || (a >= 3 && a2 >= 3)) {
            quickCamKeyboardView.f16556P.setVisibility(8);
            return;
        }
        quickCamKeyboardView.f16556P.setVisibility(0);
        quickCamKeyboardView.f16556P.setAlpha(d);
    }

    private void m16606w() {
        this.f16557Q.getBackground().mutate().setAlpha(0);
        if (!m16601o()) {
            this.f16557Q.setVisibility(8);
        }
    }

    private void m16607x() {
        ((ImageButton) this.f16558R).setImageDrawable(this.f16543B.a(2130841434, getResources().getColor(2131362241)));
    }

    private void m16608y() {
        if (!m16584Q() || this.f16553M.getVisibility() == 0 || this.aJ.f16093n || this.aJ.f16092m) {
            this.f16558R.setVisibility(8);
            return;
        }
        this.f16558R.setVisibility(0);
        this.f16558R.setEnabled(true);
    }

    public static void m16576B(QuickCamKeyboardView quickCamKeyboardView) {
        quickCamKeyboardView.m16600n();
        quickCamKeyboardView.m16603q();
        quickCamKeyboardView.m16608y();
        m16599m(quickCamKeyboardView);
        quickCamKeyboardView.m16604s();
        quickCamKeyboardView.f16555O.setVisibility(quickCamKeyboardView.az ? 0 : 8);
        m16605v(quickCamKeyboardView);
        quickCamKeyboardView.f16561U.setScaleX(quickCamKeyboardView.f16580q.m6388h() ? -1.0f : 1.0f);
        quickCamKeyboardView.f16561U.setVisibility(quickCamKeyboardView.aB ? 0 : 8);
        if (quickCamKeyboardView.aK.m16227b()) {
            if (m16585R(quickCamKeyboardView) && quickCamKeyboardView.az) {
                quickCamKeyboardView.aJ.m16257h();
            } else {
                quickCamKeyboardView.aJ.m16258i();
            }
            if (quickCamKeyboardView.az) {
                quickCamKeyboardView.aJ.m16256d();
            } else {
                quickCamKeyboardView.aJ.f16082c.setVisibility(8);
            }
        }
        quickCamKeyboardView.m16577C();
    }

    private void m16577C() {
        if (this.aJ.f16093n || this.aJ.f16092m || m16584Q()) {
            this.f16557Q.setVisibility(8);
        } else {
            this.f16557Q.setVisibility(0);
        }
    }

    public final void m16611b() {
        if (m16582K()) {
            this.ah.b(1.0d);
            requestFocus();
            m16576B(this);
        }
    }

    public static void m16578D(QuickCamKeyboardView quickCamKeyboardView) {
        if (!quickCamKeyboardView.m16582K()) {
            return;
        }
        if (m16589W(quickCamKeyboardView)) {
            if (quickCamKeyboardView.ar != null) {
                quickCamKeyboardView.ar.a.a.i();
            }
            return;
        }
        quickCamKeyboardView.m16612e();
    }

    public final void m16612e() {
        this.ah.b(0.0d);
        this.au = false;
        m16576B(this);
    }

    public static void m16579G(QuickCamKeyboardView quickCamKeyboardView) {
        quickCamKeyboardView.f16559S.setVisibility(0);
        quickCamKeyboardView.f16559S.setRotation((float) quickCamKeyboardView.m16597b(quickCamKeyboardView.aL));
        quickCamKeyboardView.f16559S.setText("0:00");
        quickCamKeyboardView.f16556P.setText(2131232217);
    }

    private void m16580H() {
        this.f16559S.setVisibility(4);
        this.f16557Q.setProgress(0);
        this.aG = 0;
        this.f16556P.setText(((WebrtcUiHandler) this.f16545E.get()).m19437M() ? 2131232216 : 2131232215);
        this.f16560T.setVisibility(8);
        this.f16557Q.setProgressDrawable(getResources().getDrawable(2130842254));
    }

    public void onSizeChanged(int i, int i2, int i3, int i4) {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, -477770990);
        m16587U();
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, 892339310, a);
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() == 4) {
            DispatcherState keyDispatcherState = getKeyDispatcherState();
            switch (keyEvent.getAction()) {
                case 0:
                    keyDispatcherState.startTracking(keyEvent, this);
                    return true;
                case 1:
                    if (!keyEvent.isCanceled() && keyDispatcherState.isTracking(keyEvent)) {
                        if (this.aJ.m16255c()) {
                            this.aJ.m16253a();
                            return true;
                        } else if (m16584Q()) {
                            if (this.aJ.m16254b()) {
                                m16590Y(this);
                                return true;
                            }
                            ad(this);
                            return true;
                        } else if (m16585R(this)) {
                            m16578D(this);
                            return true;
                        }
                    }
                    break;
            }
        }
        return super.dispatchKeyEvent(keyEvent);
    }

    public final void m16613f() {
        this.an.a();
        this.am.enable();
        if (!m16581J()) {
            if (this.f16583t.m6469b()) {
                m16586T(this);
                this.f16580q.m6381a(this.f16583t.f6116a);
            } else {
                this.f16580q.m6377a();
            }
            int i = getResources().getConfiguration().orientation;
            this.ax = (i == 2 ? 1 : 0) | this.ax;
            if (m16588V(this)) {
                m16591Z();
                this.au = true;
                this.ah.b(1.0d).a(1.0d).l();
            }
            requestFocus();
            m16576B(this);
        }
    }

    private boolean m16581J() {
        if (m16582K()) {
            if (VERSION.SDK_INT > 16) {
                this.f16552L.setImportantForAccessibility(0);
                this.f16546F.setImportantForAccessibility(0);
            }
            this.aa.e();
            return false;
        }
        if (VERSION.SDK_INT > 16) {
            this.f16552L.setImportantForAccessibility(4);
            this.f16546F.setImportantForAccessibility(4);
        }
        this.aa.f();
        return true;
    }

    private boolean m16582K() {
        return VERSION.SDK_INT <= 21 || this.f16585v.a(this.f16589z.f16590a);
    }

    public final void m16614g() {
        this.an.b();
        this.am.disable();
        m16580H();
        this.aj.a(0.0d).l();
        this.ah.a(0.0d).l();
        this.au = false;
        ac(this);
        if (this.ab != null) {
            final ChildSharingFrameLayout childSharingFrameLayout = this.ab;
            post(new Runnable(this) {
                final /* synthetic */ QuickCamKeyboardView f16510b;

                public void run() {
                    ViewParent parent = childSharingFrameLayout.getParent();
                    if (parent instanceof ViewGroup) {
                        ((ViewGroup) parent).removeView(childSharingFrameLayout);
                    }
                }
            });
            this.ab = null;
        }
        m16587U();
        this.f16583t.f6116a.mo241d();
        this.f16580q.m6382b();
        if (this.az) {
            this.ao.m16559a();
        } else if (this.aB) {
            this.ap.m16575a();
        }
    }

    public static void m16595a(QuickCamKeyboardView quickCamKeyboardView, PhotoParams photoParams, Function function) {
        ListenableFuture a = quickCamKeyboardView.f16567d.m16466a(photoParams.f16434a, photoParams.f16435b);
        ListenableFuture a2 = quickCamKeyboardView.f16566c.m16466a(photoParams.f16436c, photoParams.f16437d);
        a = Futures.a(a, function, quickCamKeyboardView.f16570g);
        ListenableFuture b = Futures.b(a, quickCamKeyboardView.ao, quickCamKeyboardView.f16570g);
        a2 = Futures.a(Futures.a(Futures.a(new ListenableFuture[]{b, a2}), new CropPhoto(quickCamKeyboardView.f16574k, photoParams), quickCamKeyboardView.f16573j), quickCamKeyboardView.f16574k.m16475b(photoParams), quickCamKeyboardView.f16573j);
        Futures.a(a, new Flash(quickCamKeyboardView), quickCamKeyboardView.f16570g);
        Futures.a(a2, new SendMedia(quickCamKeyboardView, quickCamKeyboardView.as), quickCamKeyboardView.f16570g);
        Futures.a(a2, new AddToGallery(quickCamKeyboardView), quickCamKeyboardView.f16570g);
    }

    public static int getCroppedBitmapWidth(QuickCamKeyboardView quickCamKeyboardView) {
        return quickCamKeyboardView.f16581r.m6396a(quickCamKeyboardView.aL) ? quickCamKeyboardView.f16547G.getHeight() : quickCamKeyboardView.f16547G.getWidth();
    }

    public static int getCroppedBitmapHeight(QuickCamKeyboardView quickCamKeyboardView) {
        return quickCamKeyboardView.f16581r.m6396a(quickCamKeyboardView.aL) ? quickCamKeyboardView.f16547G.getWidth() : quickCamKeyboardView.f16547G.getHeight();
    }

    private boolean m16584Q() {
        return this.az || this.aB;
    }

    public static boolean m16585R(QuickCamKeyboardView quickCamKeyboardView) {
        return quickCamKeyboardView.ah.i == 1.0d;
    }

    public static void m16586T(QuickCamKeyboardView quickCamKeyboardView) {
        quickCamKeyboardView.f16553M.setVisibility(8);
        quickCamKeyboardView.f16583t.m6463a(0);
        m16576B(quickCamKeyboardView);
    }

    private void m16587U() {
        this.f16567d.m16467a();
        this.f16566c.m16467a();
    }

    private void m16592a(View view) {
        if (view.getParent() != this.ab) {
            this.ab.a(view, new LayoutParams(view.getWidth(), view.getHeight(), 80));
        }
    }

    private void m16598c(View view) {
        a(view, new LayoutParams(-1, -1));
    }

    public static boolean m16588V(QuickCamKeyboardView quickCamKeyboardView) {
        return quickCamKeyboardView.ax || ((Boolean) quickCamKeyboardView.f16578o.get()).booleanValue();
    }

    public static boolean m16589W(QuickCamKeyboardView quickCamKeyboardView) {
        return m16588V(quickCamKeyboardView) || quickCamKeyboardView.ag.d() != 0.0d;
    }

    public void setAutoDismissAfterAttachMedia(boolean z) {
        this.av = z;
    }

    public static void m16590Y(QuickCamKeyboardView quickCamKeyboardView) {
        new FbAlertDialogBuilder(quickCamKeyboardView.getContext()).a(2131232207).b(2131232208).b(2131232209, new C19529(quickCamKeyboardView)).a(2131232210, new C19518(quickCamKeyboardView)).b();
    }

    protected void onMeasure(int i, int i2) {
        boolean z = MeasureSpec.getMode(i) == 1073741824 && MeasureSpec.getMode(i2) == 1073741824;
        Preconditions.checkState(z);
        int size = MeasureSpec.getSize(i);
        int size2 = MeasureSpec.getSize(i2);
        if (this.f16546F.getParent() == this) {
            m16594a(this, size, size2);
        }
        ViewGroup.LayoutParams layoutParams = this.f16560T.getLayoutParams();
        ViewGroup.LayoutParams layoutParams2 = this.f16583t.m6472d().getLayoutParams();
        if (!(layoutParams.width == layoutParams2.width && layoutParams.height == layoutParams2.height)) {
            layoutParams.width = layoutParams2.width;
            layoutParams.height = layoutParams2.height;
            this.f16560T.setLayoutParams(layoutParams);
        }
        super.onMeasure(i, i2);
    }

    final void m16609a(int i) {
        if (!this.aA && !m16584Q()) {
            this.aL = Math.round(((float) (360 - i)) / 90.0f) % 4;
            int b = m16597b(this.aL);
            this.ai.b((double) b);
            this.ag.b(b != 0 ? 1.0d : 0.0d);
            if (!((Boolean) this.f16578o.get()).booleanValue()) {
                if (m16585R(this) && !this.au && !m16589W(this)) {
                    m16612e();
                } else if (!m16585R(this) && this.aL != 0) {
                    m16611b();
                    this.aq = null;
                }
            }
        }
    }

    private int m16597b(int i) {
        int a = (i - this.f16565b.a()) * 90;
        if (a < -90) {
            return a + 360;
        }
        if (a > 180) {
            return a - 360;
        }
        return a;
    }

    public static void m16594a(QuickCamKeyboardView quickCamKeyboardView, int i, int i2) {
        if (m16588V(quickCamKeyboardView)) {
            QuickCamViewportController quickCamViewportController = quickCamKeyboardView.f16583t;
            float i3 = quickCamViewportController.f6119d.m6389i();
            if (i != 0 && i2 != 0 && i3 > 0.0f) {
                float f = ((float) i) / ((float) i2);
                View d = quickCamViewportController.m6472d();
                if (f > i3) {
                    LayoutParamsUtil.a(d, (int) (i3 * ((float) i2)), -1);
                    return;
                } else {
                    LayoutParamsUtil.a(d, -1, (int) (((float) i) / i3));
                    return;
                }
            }
            return;
        }
        quickCamKeyboardView.f16583t.m6468b(i, i2);
    }

    public final boolean m16615h() {
        return m16585R(this) && m16584Q();
    }

    private void m16591Z() {
        ViewGroup viewGroup = (ViewGroup) getParent();
        ViewGroup ab = ab();
        if (viewGroup != ab) {
            viewGroup.removeView(this);
            ab.addView(this);
        }
    }

    public static void aa(QuickCamKeyboardView quickCamKeyboardView) {
        if (quickCamKeyboardView.ab == null) {
            quickCamKeyboardView.ab = new ChildSharingFrameLayout(quickCamKeyboardView.getContext());
            quickCamKeyboardView.af = new ColorDrawable(quickCamKeyboardView.aH);
            quickCamKeyboardView.ab.setBackgroundDrawable(quickCamKeyboardView.af);
            ViewCompat.a(quickCamKeyboardView.ab, VERSION.SDK_INT >= 23);
            quickCamKeyboardView.ab().addView(quickCamKeyboardView.ab);
        }
        quickCamKeyboardView.m16592a(quickCamKeyboardView.f16552L);
        quickCamKeyboardView.m16592a(quickCamKeyboardView.f16557Q);
        quickCamKeyboardView.m16592a(quickCamKeyboardView.f16546F);
        quickCamKeyboardView.m16604s();
    }

    private ViewGroup ab() {
        ViewGroup viewGroup = (ViewGroup) getRootView().findViewById(16908290);
        ViewParent viewParent = viewGroup;
        while (true) {
            viewParent = viewParent.getParent();
            if (viewParent == null) {
                return viewGroup;
            }
            if ((viewParent instanceof ViewGroup) && ((ViewGroup) viewParent).getId() == 2131559128) {
                return (ViewGroup) viewParent.getParent();
            }
        }
    }

    public static void ac(QuickCamKeyboardView quickCamKeyboardView) {
        quickCamKeyboardView.m16598c(quickCamKeyboardView.f16552L);
        View view = quickCamKeyboardView.f16557Q;
        quickCamKeyboardView.a(view, new LayoutParams(-1, view.getHeight(), 80));
        quickCamKeyboardView.m16598c(quickCamKeyboardView.f16546F);
        m16599m(quickCamKeyboardView);
        quickCamKeyboardView.m16604s();
    }

    public static void ad(QuickCamKeyboardView quickCamKeyboardView) {
        if (quickCamKeyboardView.az) {
            quickCamKeyboardView.ao.m16559a();
        } else if (quickCamKeyboardView.aB) {
            quickCamKeyboardView.ap.m16575a();
        }
    }

    public final void m16610a(Map<String, Integer> map) {
        Integer num = (Integer) map.get("android.permission.CAMERA");
        Integer num2 = (Integer) map.get("android.permission.RECORD_AUDIO");
        Integer num3 = (Integer) map.get("android.permission.READ_EXTERNAL_STORAGE");
        Integer num4 = (Integer) map.get("android.permission.WRITE_EXTERNAL_STORAGE");
        if (m16582K()) {
            this.aa.e();
        } else if (map.values().contains(Integer.valueOf(2))) {
            if (this.f16572i.a(RequestPermissionsPrefKeys.f20403b, false)) {
                this.f16585v.b();
            } else {
                this.f16572i.edit().putBoolean(RequestPermissionsPrefKeys.f20403b, true).commit();
            }
        }
        if (num != null && num.intValue() == 1) {
            this.f16572i.edit().putBoolean(RequestPermissionsPrefKeys.f20403b, false).commit();
        }
        if (num2 != null && num2.intValue() == 1) {
            this.f16572i.edit().putBoolean(RequestPermissionsPrefKeys.f20402a, false).commit();
        }
        if ((num3 != null && num3.intValue() == 1) || (num4 != null && num4.intValue() == 1)) {
            this.f16572i.edit().putBoolean(RequestPermissionsPrefKeys.f20406e, false).commit();
        }
    }

    private void m16593a(AndroidThreadUtil androidThreadUtil, BetterRotationManager betterRotationManager, BitmapHolder bitmapHolder, BitmapHolder bitmapHolder2, ChoreographerWrapper choreographerWrapper, Clock clock, Executor executor, FbErrorReporter fbErrorReporter, FbSharedPreferences fbSharedPreferences, ListeningExecutorService listeningExecutorService, MediaOperations mediaOperations, MessengerSoundUtil messengerSoundUtil, PhotoEditingControllerProvider photoEditingControllerProvider, Provider<Boolean> provider, Provider<Boolean> provider2, Provider<Boolean> provider3, QuickCamAsync quickCamAsync, QuickCamBitmapUtil quickCamBitmapUtil, QuickCamEventLogger quickCamEventLogger, QuickCamViewportController quickCamViewportController, QuickExperimentController quickExperimentController, RuntimePermissionsUtil runtimePermissionsUtil, SpringSystem springSystem, Toaster toaster, ViewOrientationLockHelperProvider viewOrientationLockHelperProvider, QuickCamPermissionsHolder quickCamPermissionsHolder, Boolean bool, GlyphColorizer glyphColorizer, QeAccessor qeAccessor, com.facebook.inject.Lazy<WebrtcUiHandler> lazy) {
        this.f16564a = androidThreadUtil;
        this.f16565b = betterRotationManager;
        this.f16566c = bitmapHolder;
        this.f16567d = bitmapHolder2;
        this.f16568e = choreographerWrapper;
        this.f16569f = clock;
        this.f16570g = executor;
        this.f16571h = fbErrorReporter;
        this.f16572i = fbSharedPreferences;
        this.f16573j = listeningExecutorService;
        this.f16574k = mediaOperations;
        this.f16575l = messengerSoundUtil;
        this.f16576m = photoEditingControllerProvider;
        this.f16577n = provider;
        this.f16578o = provider2;
        this.f16579p = provider3;
        this.f16580q = quickCamAsync;
        this.f16581r = quickCamBitmapUtil;
        this.f16582s = quickCamEventLogger;
        this.f16583t = quickCamViewportController;
        this.f16584u = quickExperimentController;
        this.f16585v = runtimePermissionsUtil;
        this.f16586w = springSystem;
        this.f16587x = toaster;
        this.f16588y = viewOrientationLockHelperProvider;
        this.f16589z = quickCamPermissionsHolder;
        this.f16542A = bool;
        this.f16543B = glyphColorizer;
        this.f16544C = qeAccessor;
        this.f16545E = lazy;
    }
}
