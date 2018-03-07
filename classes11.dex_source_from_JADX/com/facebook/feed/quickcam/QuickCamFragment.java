package com.facebook.feed.quickcam;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.RectF;
import android.media.CamcorderProfile;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.TextureView;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewStub;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import com.facebook.base.fragment.FbFragment;
import com.facebook.common.android.WindowManagerMethodAutoProvider;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.errorreporting.SoftError;
import com.facebook.common.errorreporting.SoftErrorBuilder;
import com.facebook.common.executors.DefaultAndroidThreadUtil;
import com.facebook.common.executors.DefaultExecutorService;
import com.facebook.common.executors.ForUiThread;
import com.facebook.common.executors.ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.common.identifiers.SafeUUIDGenerator;
import com.facebook.common.quickcam.DefaultQuickCamVideoResizingPolicy;
import com.facebook.common.quickcam.QuickCamAsync;
import com.facebook.common.quickcam.QuickCamAsync.Listener;
import com.facebook.common.quickcam.QuickCamVideoUtil;
import com.facebook.common.quickcam.QuickCamVideoUtil.OrientationTag;
import com.facebook.common.quickcam.QuickCamViewportController;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.common.title.IndicatorBarController;
import com.facebook.common.ui.util.ViewPositionUtil;
import com.facebook.common.util.StringUtil;
import com.facebook.composer.privacy.common.ComposerFixedPrivacyData.Builder;
import com.facebook.composer.privacy.common.FixedPrivacyView;
import com.facebook.composer.ui.titlebar.ComposerBaseTitleBar;
import com.facebook.composer.ui.titlebar.ComposerTitleBar;
import com.facebook.composer.ui.titlebar.ComposerTitleBar.StateBuilder;
import com.facebook.composer.ui.titlebar.HarrisonPlusIconType;
import com.facebook.composer.ui.titlebar.HarrisonPlusIconType.Type;
import com.facebook.fbui.tooltip.Tooltip;
import com.facebook.feed.quickcam.ComposerQuickCamAnalyticsLogger.Events;
import com.facebook.feed.quickcam.QuickCamInlineVideoPlayerControl.C09621;
import com.facebook.inject.FbInjector;
import com.facebook.inject.InjectorLike;
import com.facebook.ipc.composer.intent.ComposerTargetData;
import com.facebook.ipc.composer.model.ComposerType;
import com.facebook.ipc.composer.model.MinutiaeTag;
import com.facebook.ipc.composer.model.RedSpaceValue;
import com.facebook.ipc.composer.model.TargetType;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.photos.base.media.MediaItemFactory;
import com.facebook.photos.base.media.VideoItem;
import com.facebook.photos.upload.manager.UploadManager;
import com.facebook.photos.upload.operation.UploadOperationFactory;
import com.facebook.ui.choreographer.ChoreographerWrapper;
import com.facebook.ui.choreographer.DefaultChoreographerWrapper;
import com.facebook.ui.choreographer.FrameCallbackWrapper;
import com.facebook.ui.media.attachments.MediaResource.Source;
import com.facebook.video.analytics.VideoAnalytics.EventTriggerType;
import com.facebook.video.analytics.VideoAnalytics.PlayerOrigin;
import com.facebook.video.analytics.VideoAnalytics.StreamSourceType;
import com.facebook.video.engine.Constants.VideoMediaState;
import com.facebook.video.engine.PlayPosition;
import com.facebook.video.engine.VideoDataSource;
import com.facebook.video.engine.VideoDataSourceBuilder;
import com.facebook.video.engine.VideoPlayerParams;
import com.facebook.video.engine.VideoPlayerParamsBuilder;
import com.facebook.video.player.InlineVideoPlayer;
import com.facebook.widget.titlebar.FbTitleBar.OnBackPressedListener;
import com.facebook.widget.titlebar.FbTitleBar.OnToolbarButtonListener;
import com.facebook.widget.titlebar.TitleBarButtonSpec;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Sets;
import com.google.common.util.concurrent.AsyncFunction;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;
import java.io.File;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
import javax.inject.Inject;

@TargetApi(18)
/* compiled from: drawee_view_info */
public class QuickCamFragment extends FbFragment {
    @Inject
    QuickCamViewportController f7537a;
    public Button aA;
    public ComposerTitleBar aB;
    public ProgressBar aC;
    public ImageView aD;
    public TextView aE;
    public ImageView aF;
    public ProgressBar aG;
    public boolean aH = false;
    public Uri aI;
    public Uri aJ;
    public CamcorderProfile aK;
    public ComposerTargetData aL;
    public String aM;
    public FrameCallbackWrapper aN;
    public long aO;
    public Bitmap aP;
    public Bitmap aQ;
    public Bitmap aR;
    public ButtonStates aS = ButtonStates.RECORD;
    public String aT;
    public InlineVideoPlayer aU;
    public ListenableFuture aV;
    public ListenableFuture<Void> aW;
    private ListenableFuture<File> aX;
    public final C09531 aY = new C09531(this);
    @Inject
    UploadManager al;
    @Inject
    Clock am;
    @Inject
    ChoreographerWrapper an;
    @Inject
    DefaultQuickCamVideoResizingPolicy ao;
    @Inject
    public QuickCamInlineVideoPlayerControl ap;
    @Inject
    ComposerQuickCamAnalyticsLogger aq;
    @Inject
    IndicatorBarController ar;
    @Inject
    QuickCamVideoUtil as;
    public TextureView at;
    private ViewStub au;
    public View av;
    public Button aw;
    public Button ax;
    public Button ay;
    public Button az;
    @Inject
    public QuickCamAsync f7538b;
    @Inject
    public WindowManager f7539c;
    @Inject
    DefaultAndroidThreadUtil f7540d;
    @DefaultExecutorService
    @Inject
    public ListeningExecutorService f7541e;
    @Inject
    @ForUiThread
    public Executor f7542f;
    @Inject
    MediaItemFactory f7543g;
    @Inject
    AbstractFbErrorReporter f7544h;
    @Inject
    UploadOperationFactory f7545i;

    /* compiled from: drawee_view_info */
    public class AnonymousClass16 extends OnToolbarButtonListener {
        final /* synthetic */ Uri f7524a;
        final /* synthetic */ QuickCamFragment f7525b;

        public AnonymousClass16(QuickCamFragment quickCamFragment, Uri uri) {
            this.f7525b = quickCamFragment;
            this.f7524a = uri;
        }

        public final void m8738a(View view, TitleBarButtonSpec titleBarButtonSpec) {
            VideoItem videoItem = (VideoItem) this.f7525b.f7543g.b(this.f7524a);
            if (videoItem == null) {
                this.f7525b.f7544h.b("video upload error", StringFormatUtil.formatStrLocaleSafe("Null VideoItem for Uri %s", this.f7524a));
                return;
            }
            this.f7525b.al.a(this.f7525b.f7545i.a(videoItem, null, this.f7525b.aL.targetId, this.f7525b.aL.targetType.toString(), "", MinutiaeTag.a, ImmutableList.copyOf(Sets.a()), -1, false, null, false, RedSpaceValue.POST_TO_NEWSFEED, SafeUUIDGenerator.a().toString(), null, 0, this.f7525b.aM, ImmutableList.of()));
            this.f7525b.aq.m8734a(Events.BIRTHDAY_CAM_POST, this.f7525b.aT);
            this.f7525b.ao().finish();
        }
    }

    /* compiled from: drawee_view_info */
    public class C09531 {
        public final /* synthetic */ QuickCamFragment f7527a;

        C09531(QuickCamFragment quickCamFragment) {
            this.f7527a = quickCamFragment;
        }

        public final void m8739a() {
            if (this.f7527a.ap.m8780e()) {
                this.f7527a.az.setVisibility(8);
                this.f7527a.aA.setVisibility(0);
                return;
            }
            this.f7527a.az.setVisibility(0);
            this.f7527a.aA.setVisibility(8);
        }
    }

    /* compiled from: drawee_view_info */
    class C09542 implements OnClickListener {
        final /* synthetic */ QuickCamFragment f7528a;

        C09542(QuickCamFragment quickCamFragment) {
            this.f7528a = quickCamFragment;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -2030997669);
            QuickCamFragment quickCamFragment = this.f7528a;
            if (quickCamFragment.ap.m8780e()) {
                QuickCamInlineVideoPlayerControl quickCamInlineVideoPlayerControl = quickCamFragment.ap;
                if (quickCamInlineVideoPlayerControl.f7547a != null) {
                    QuickCamInlineVideoPlayerControl.m8776f(quickCamInlineVideoPlayerControl);
                    quickCamInlineVideoPlayerControl.f7547a.b(EventTriggerType.BY_USER);
                }
            }
            this.f7528a.aS = ButtonStates.RECORD;
            QuickCamFragment.aC(this.f7528a);
            quickCamFragment = this.f7528a;
            quickCamFragment.aB.a(quickCamFragment.aB.b.a().a(false).a());
            quickCamFragment = this.f7528a;
            if (quickCamFragment.aV != null) {
                quickCamFragment.aV.cancel(true);
            }
            quickCamFragment.aD.setVisibility(8);
            quickCamFragment.aF.setVisibility(8);
            Logger.a(2, EntryType.UI_INPUT_END, -1499531849, a);
        }
    }

    /* compiled from: drawee_view_info */
    class C09553 extends FrameCallbackWrapper {
        final /* synthetic */ QuickCamFragment f7529a;

        C09553(QuickCamFragment quickCamFragment) {
            this.f7529a = quickCamFragment;
        }

        public final void m8740a(long j) {
            long a = this.f7529a.am.a() - this.f7529a.aO;
            if (a < 15000) {
                this.f7529a.aC.setProgress((int) a);
                a = (15200 - a) / 1000;
                this.f7529a.aE.setText(this.f7529a.aE.getResources().getString(2131242469, new Object[]{Long.valueOf(a)}));
                this.f7529a.an.a(this.f7529a.aN);
                return;
            }
            this.f7529a.f7538b.f();
            QuickCamFragment.aq(this.f7529a);
        }
    }

    /* compiled from: drawee_view_info */
    class C09564 extends AbstractDisposableFutureCallback {
        final /* synthetic */ QuickCamFragment f7530a;

        C09564(QuickCamFragment quickCamFragment) {
            this.f7530a = quickCamFragment;
        }

        protected final void m8741a(Object obj) {
            this.f7530a.aD.setVisibility(0);
            this.f7530a.aD.setImageBitmap(this.f7530a.aR);
        }

        public final void m8742a(Throwable th) {
            AbstractFbErrorReporter abstractFbErrorReporter = this.f7530a.f7544h;
            SoftErrorBuilder a = SoftError.a("feed quick cam", th.getMessage());
            a.c = th;
            abstractFbErrorReporter.a(a.g());
            Toast.makeText(this.f7530a.getContext(), this.f7530a.b(2131242473), 0).show();
            this.f7530a.aS = ButtonStates.RECORD;
            if (this.f7530a.hn_()) {
                QuickCamFragment.aC(this.f7530a);
            }
        }
    }

    /* compiled from: drawee_view_info */
    public class C09575 implements AsyncFunction<Void, Void> {
        final /* synthetic */ QuickCamFragment f7531a;

        public C09575(QuickCamFragment quickCamFragment) {
            this.f7531a = quickCamFragment;
        }

        public final ListenableFuture m8743a(@Nullable Object obj) {
            this.f7531a.aP = this.f7531a.at.getBitmap(this.f7531a.aQ);
            QuickCamFragment quickCamFragment = this.f7531a;
            return quickCamFragment.f7541e.a(new C09586(quickCamFragment));
        }
    }

    /* compiled from: drawee_view_info */
    public class C09586 implements Callable<Void> {
        final /* synthetic */ QuickCamFragment f7532a;

        public C09586(QuickCamFragment quickCamFragment) {
            this.f7532a = quickCamFragment;
        }

        public Object call() {
            QuickCamFragment quickCamFragment = this.f7532a;
            int width = quickCamFragment.aR.getWidth();
            int height = quickCamFragment.aR.getHeight();
            int width2 = (quickCamFragment.aP.getWidth() - width) / 2;
            int height2 = (quickCamFragment.aP.getHeight() - height) / 2;
            int i = width2 + width;
            int i2 = height2 + height;
            Canvas canvas = new Canvas(quickCamFragment.aR);
            Paint paint = new Paint();
            paint.setFilterBitmap(true);
            canvas.drawBitmap(quickCamFragment.aP, new Rect(width2, height2, i, i2), new Rect(0, 0, width, height), paint);
            return null;
        }
    }

    /* compiled from: drawee_view_info */
    public class C09597 implements Callable<Void> {
        final /* synthetic */ QuickCamFragment f7533a;

        public C09597(QuickCamFragment quickCamFragment) {
            this.f7533a = quickCamFragment;
        }

        public Object call() {
            if (!QuickCamFragment.aw(this.f7533a)) {
                this.f7533a.aQ = Bitmap.createBitmap(this.f7533a.at.getWidth(), this.f7533a.at.getHeight(), Config.ARGB_8888);
            }
            if (!QuickCamFragment.ax(this.f7533a)) {
                this.f7533a.aR = Bitmap.createBitmap(this.f7533a.av.getWidth(), this.f7533a.av.getHeight(), Config.ARGB_8888);
            }
            return null;
        }
    }

    /* compiled from: drawee_view_info */
    class C09608 implements OnBackPressedListener {
        final /* synthetic */ QuickCamFragment f7534a;

        C09608(QuickCamFragment quickCamFragment) {
            this.f7534a = quickCamFragment;
        }

        public final void m8744a() {
            ((Activity) this.f7534a.getContext()).onBackPressed();
        }
    }

    /* compiled from: drawee_view_info */
    public class C09619 implements OnClickListener {
        final /* synthetic */ QuickCamFragment f7535a;

        public C09619(QuickCamFragment quickCamFragment) {
            this.f7535a = quickCamFragment;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 1085753172);
            Tooltip tooltip = new Tooltip(this.f7535a.ao());
            tooltip.b(2131242475);
            tooltip.a(this.f7535a.aw);
            Logger.a(2, EntryType.UI_INPUT_END, 763666374, a);
        }
    }

    /* compiled from: drawee_view_info */
    public enum ButtonStates {
        RECORD,
        RECORDING,
        PROCESSING,
        PLAY,
        PAUSE
    }

    /* compiled from: drawee_view_info */
    class QuickCamAsyncListener implements Listener {
        final /* synthetic */ QuickCamFragment f7536a;

        public QuickCamAsyncListener(QuickCamFragment quickCamFragment) {
            this.f7536a = quickCamFragment;
        }

        public final void m8745a() {
            int ay = QuickCamFragment.ay(this.f7536a);
            this.f7536a.f7537a.b(ay, ay);
            this.f7536a.f7537a.a(0);
            this.f7536a.f7537a.c();
        }

        public final void m8748b() {
            this.f7536a.f7537a.a(8);
        }

        public final void m8749c() {
        }

        public final void m8747a(byte[] bArr, int i, int i2, boolean z) {
        }

        public final void m8750d() {
            this.f7536a.f7540d.a();
            this.f7536a.aS = ButtonStates.RECORDING;
            QuickCamFragment.aC(this.f7536a);
            this.f7536a.aO = this.f7536a.am.a() + 200;
            this.f7536a.an.a(this.f7536a.aN, 200);
        }

        public final void m8751e() {
            this.f7536a.f7540d.a();
            this.f7536a.an.b(this.f7536a.aN);
            this.f7536a.aO = 0;
            this.f7536a.aC.setProgress(0);
        }

        public final void m8746a(@Nullable Uri uri, @Nullable CamcorderProfile camcorderProfile, boolean z, int i) {
            this.f7536a.f7540d.a();
            if (uri != null) {
                this.f7536a.aS = ButtonStates.PROCESSING;
                QuickCamFragment.aC(this.f7536a);
                this.f7536a.aI = uri;
                this.f7536a.aK = camcorderProfile;
                if (!QuickCamFragment.aN(this.f7536a)) {
                    this.f7536a.aS = ButtonStates.RECORD;
                    QuickCamFragment.aC(this.f7536a);
                    return;
                }
                return;
            }
            this.f7536a.aS = ButtonStates.RECORD;
            QuickCamFragment.aC(this.f7536a);
        }

        public final void m8752f() {
        }
    }

    public static void m8757a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        ((QuickCamFragment) obj).m8755a(QuickCamViewportController.a(injectorLike), QuickCamAsync.a(injectorLike), WindowManagerMethodAutoProvider.a(injectorLike), DefaultAndroidThreadUtil.a(injectorLike), ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider.a(injectorLike), (Executor) ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.a(injectorLike), MediaItemFactory.a(injectorLike), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike), UploadOperationFactory.a(injectorLike), UploadManager.a(injectorLike), (Clock) SystemClockMethodAutoProvider.a(injectorLike), (ChoreographerWrapper) DefaultChoreographerWrapper.a(injectorLike), DefaultQuickCamVideoResizingPolicy.a(injectorLike), QuickCamInlineVideoPlayerControl.m8775a(injectorLike), ComposerQuickCamAnalyticsLogger.m8732a(injectorLike), IndicatorBarController.a(injectorLike), QuickCamVideoUtil.a(injectorLike));
    }

    private void m8755a(QuickCamViewportController quickCamViewportController, QuickCamAsync quickCamAsync, WindowManager windowManager, DefaultAndroidThreadUtil defaultAndroidThreadUtil, ListeningExecutorService listeningExecutorService, Executor executor, MediaItemFactory mediaItemFactory, AbstractFbErrorReporter abstractFbErrorReporter, UploadOperationFactory uploadOperationFactory, UploadManager uploadManager, Clock clock, ChoreographerWrapper choreographerWrapper, DefaultQuickCamVideoResizingPolicy defaultQuickCamVideoResizingPolicy, QuickCamInlineVideoPlayerControl quickCamInlineVideoPlayerControl, ComposerQuickCamAnalyticsLogger composerQuickCamAnalyticsLogger, IndicatorBarController indicatorBarController, QuickCamVideoUtil quickCamVideoUtil) {
        this.f7537a = quickCamViewportController;
        this.f7538b = quickCamAsync;
        this.f7539c = windowManager;
        this.f7540d = defaultAndroidThreadUtil;
        this.f7541e = listeningExecutorService;
        this.f7542f = executor;
        this.f7543g = mediaItemFactory;
        this.f7544h = abstractFbErrorReporter;
        this.f7545i = uploadOperationFactory;
        this.al = uploadManager;
        this.am = clock;
        this.an = choreographerWrapper;
        this.ao = defaultQuickCamVideoResizingPolicy;
        this.ap = quickCamInlineVideoPlayerControl;
        this.aq = composerQuickCamAnalyticsLogger;
        this.ar = indicatorBarController;
        this.as = quickCamVideoUtil;
    }

    public final void m8764c(Bundle bundle) {
        String string;
        super.c(bundle);
        Class cls = QuickCamFragment.class;
        m8757a(this, getContext());
        if (bundle != null) {
            string = bundle.getString("STATE_KEY_SESSION_ID");
        } else {
            string = SafeUUIDGenerator.a().toString();
        }
        this.aT = string;
        this.aq.m8734a(Events.BIRTHDAY_CAM_ENTRY, this.aT);
        Bundle bundle2 = this.s;
        Preconditions.checkArgument(bundle2.getBoolean("STATE_KEY_OVERRIDDEN_ON_BACK_PRESS"), "Please override onBackPress from the activity.");
        this.aL = (ComposerTargetData) bundle2.getParcelable("com.facebook.feed.quickcam.targetData");
        this.aM = bundle2.getString("com.facebook.feed.quickcam.sourceType");
        if (this.aL == null || this.aL.targetName == null) {
            Toast.makeText(getContext(), b(2131242472), 0).show();
            ao().finish();
        }
        this.aM = StringUtil.a(this.aM) ? "unknown" : this.aM;
    }

    public final View m8762a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1191721627);
        ViewGroup viewGroup2 = (LinearLayout) layoutInflater.inflate(2130904329, null);
        this.au = (ViewStub) viewGroup2.findViewById(2131561976);
        this.aD = (ImageView) viewGroup2.findViewById(2131561977);
        this.aF = (ImageView) viewGroup2.findViewById(2131561979);
        this.av = viewGroup2.findViewById(2131561975);
        LayoutParams layoutParams = this.av.getLayoutParams();
        layoutParams.width = ay(this);
        layoutParams.height = (int) (((float) layoutParams.width) * 0.75f);
        this.av.setLayoutParams(layoutParams);
        ViewStub viewStub = (ViewStub) viewGroup2.findViewById(2131561006);
        this.ar.f = (ViewStub) viewGroup2.findViewById(2131568572);
        this.ar.b(viewStub);
        this.aE = (TextView) viewGroup2.findViewById(2131561968);
        this.aE.setOnClickListener(new C09542(this));
        this.aw = (Button) viewGroup2.findViewById(2131561969);
        this.ax = (Button) viewGroup2.findViewById(2131561970);
        this.ay = (Button) viewGroup2.findViewById(2131561971);
        this.az = (Button) viewGroup2.findViewById(2131561972);
        this.aA = (Button) viewGroup2.findViewById(2131561973);
        this.aS = ButtonStates.RECORD;
        this.aU = (InlineVideoPlayer) viewGroup2.findViewById(2131561978);
        this.ap.f7547a = this.aU;
        this.ap.f7548b = this.aD;
        this.ap.f7550d = this.aY;
        this.ap.f7549c = this.aF;
        this.aC = (ProgressBar) viewGroup2.findViewById(2131561967);
        this.aC.getBackground().setAlpha(0);
        this.aG = (ProgressBar) viewGroup2.findViewById(2131561980);
        ((FixedPrivacyView) viewGroup2.findViewById(2131561974)).a(new Builder().a(), null);
        this.aN = new C09553(this);
        this.f7538b.a();
        QuickCamAsync quickCamAsync = this.f7538b;
        Preconditions.checkState(quickCamAsync.h);
        if (!quickCamAsync.j) {
            ao().finish();
        }
        this.f7538b.a(new QuickCamAsyncListener(this));
        this.f7537a.d = this.f7538b;
        this.f7537a.a(this.au, this.av);
        this.f7537a.a(0);
        this.at = (TextureView) this.f7537a.d();
        this.aw.setOnClickListener(new C09619(this));
        this.aw.setOnLongClickListener(new OnLongClickListener(this) {
            final /* synthetic */ QuickCamFragment f7517a;

            {
                this.f7517a = r1;
            }

            public boolean onLongClick(View view) {
                this.f7517a.aq.m8734a(Events.BIRTHDAY_CAM_START_RECORDING, this.f7517a.aT);
                QuickCamFragment quickCamFragment = this.f7517a;
                quickCamFragment.f7538b.a(quickCamFragment.f7539c.getDefaultDisplay().getRotation());
                return true;
            }
        });
        this.aw.setOnTouchListener(new OnTouchListener(this) {
            final /* synthetic */ QuickCamFragment f7518a;

            {
                this.f7518a = r1;
            }

            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() != 1) {
                    if (motionEvent.getAction() != 3) {
                        if (motionEvent.getAction() == 2) {
                            if (ViewPositionUtil.a(motionEvent, this.f7518a.aw)) {
                                if (!this.f7518a.aw.isPressed()) {
                                    this.f7518a.aw.setPressed(true);
                                }
                            }
                        }
                    }
                    QuickCamFragment.aB(this.f7518a);
                } else if (this.f7518a.aS == ButtonStates.RECORDING && ViewPositionUtil.a(motionEvent, this.f7518a.aw)) {
                    this.f7518a.aq.m8734a(Events.BIRTHDAY_CAM_POST_PROCESSING_START, this.f7518a.aT);
                    this.f7518a.f7538b.f();
                    QuickCamFragment.aq(this.f7518a);
                } else {
                    QuickCamFragment.aB(this.f7518a);
                }
                return false;
            }
        });
        m8754a(viewGroup2);
        aC(this);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -653320674, a);
        return viewGroup2;
    }

    public final void m8765e(Bundle bundle) {
        bundle.putString("STATE_KEY_SESSION_ID", this.aT);
        super.e(bundle);
    }

    public final void m8759G() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1305219637);
        super.G();
        this.f7537a.a(0);
        this.ar.d();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 1286696361, a);
    }

    public final void m8760H() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1487774536);
        this.f7538b.g();
        this.ar.f();
        super.H();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 1486294941, a);
    }

    public final void m8761I() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 2134653026);
        m8758e();
        super.I();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 629269979, a);
    }

    public final void m8763b() {
        this.aq.m8734a(Events.BIRTHDAY_CAM_CANCEL, this.aT);
        m8758e();
    }

    private void m8758e() {
        this.f7538b.b();
        m8756a(this.aV);
        m8756a(this.aW);
        m8756a(this.aX);
    }

    private static void m8756a(ListenableFuture listenableFuture) {
        if (listenableFuture != null) {
            listenableFuture.cancel(true);
        }
    }

    public static void aq(QuickCamFragment quickCamFragment) {
        Object obj;
        ListenableFuture a;
        if (aw(quickCamFragment) && ax(quickCamFragment)) {
            obj = 1;
        } else {
            obj = null;
        }
        if (obj != null) {
            a = Futures.a(null);
        } else {
            a = quickCamFragment.f7541e.a(new C09597(quickCamFragment));
        }
        quickCamFragment.aW = a;
        quickCamFragment.aV = Futures.b(quickCamFragment.aW, new C09575(quickCamFragment), quickCamFragment.f7542f);
        Futures.a(quickCamFragment.aV, new C09564(quickCamFragment), quickCamFragment.f7542f);
    }

    public static boolean aw(QuickCamFragment quickCamFragment) {
        return quickCamFragment.aQ != null && quickCamFragment.aQ.getWidth() == quickCamFragment.at.getWidth() && quickCamFragment.aQ.getHeight() == quickCamFragment.at.getHeight();
    }

    public static boolean ax(QuickCamFragment quickCamFragment) {
        return quickCamFragment.aR != null && quickCamFragment.aR.getHeight() == quickCamFragment.av.getHeight() && quickCamFragment.aR.getWidth() == quickCamFragment.av.getWidth();
    }

    private void m8754a(ViewGroup viewGroup) {
        ComposerBaseTitleBar composerBaseTitleBar = (ComposerBaseTitleBar) viewGroup.findViewById(2131560528);
        composerBaseTitleBar.setOnBackPressedListener(new C09608(this));
        TitleBarButtonSpec.Builder a = TitleBarButtonSpec.a();
        a.d = false;
        a = a;
        a.g = b(2131242474);
        a = a;
        a.h = -2;
        a = a;
        a.n = true;
        TitleBarButtonSpec a2 = a.a();
        StateBuilder stateBuilder = new StateBuilder();
        stateBuilder.a = this.aL.targetName;
        stateBuilder = stateBuilder;
        String str = this.aL.targetProfilePicUrl;
        TargetType targetType = TargetType.USER;
        HarrisonPlusIconType harrisonPlusIconType = null != null ? new HarrisonPlusIconType(Type.ALBUM) : (ComposerType.STATUS == ComposerType.SHARE && (targetType == TargetType.USER || targetType == TargetType.UNDIRECTED || targetType == TargetType.PAGE || targetType == TargetType.PAGE_RECOMMENDATION)) ? HarrisonPlusIconType.a(str) : targetType == TargetType.GROUP ? new HarrisonPlusIconType(Type.GROUP) : targetType == TargetType.USER ? HarrisonPlusIconType.a(str) : new HarrisonPlusIconType(Type.DEFAULT, str);
        stateBuilder.d = harrisonPlusIconType;
        stateBuilder = stateBuilder;
        stateBuilder.b = a2;
        this.aB = new ComposerTitleBar(composerBaseTitleBar, stateBuilder.a());
    }

    public static int ay(QuickCamFragment quickCamFragment) {
        Display defaultDisplay = quickCamFragment.f7539c.getDefaultDisplay();
        Point point = new Point();
        defaultDisplay.getSize(point);
        return point.x;
    }

    public static void aB(QuickCamFragment quickCamFragment) {
        quickCamFragment.f7538b.g();
        quickCamFragment.aD();
    }

    public static void aC(QuickCamFragment quickCamFragment) {
        switch (quickCamFragment.aS) {
            case RECORD:
                quickCamFragment.aD();
                return;
            case RECORDING:
                quickCamFragment.aw.setVisibility(8);
                quickCamFragment.ax.setVisibility(0);
                quickCamFragment.ay.setVisibility(8);
                quickCamFragment.az.setVisibility(8);
                quickCamFragment.aA.setVisibility(8);
                quickCamFragment.aG.setVisibility(8);
                quickCamFragment.aE.setTextColor(quickCamFragment.jW_().getColor(2131361938));
                return;
            case PROCESSING:
                quickCamFragment.aw.setVisibility(8);
                quickCamFragment.ax.setVisibility(8);
                quickCamFragment.ay.setVisibility(0);
                quickCamFragment.az.setVisibility(8);
                quickCamFragment.aA.setVisibility(8);
                quickCamFragment.aE.setVisibility(4);
                quickCamFragment.aG.setVisibility(0);
                quickCamFragment.aG.bringToFront();
                return;
            case PLAY:
                quickCamFragment.aw.setVisibility(8);
                quickCamFragment.ax.setVisibility(8);
                quickCamFragment.ay.setVisibility(8);
                quickCamFragment.az.setVisibility(0);
                quickCamFragment.aA.setVisibility(8);
                quickCamFragment.aG.setVisibility(8);
                quickCamFragment.aE.setVisibility(0);
                quickCamFragment.aE.setTextColor(quickCamFragment.jW_().getColor(2131361917));
                quickCamFragment.aE.setText(2131242471);
                quickCamFragment.aE.setClickable(true);
                if (!quickCamFragment.aH) {
                    quickCamFragment.at.setVisibility(8);
                    quickCamFragment.aD.setVisibility(8);
                    quickCamFragment.ap.m8779a(0);
                    QuickCamInlineVideoPlayerControl quickCamInlineVideoPlayerControl = quickCamFragment.ap;
                    Uri uri = quickCamFragment.aJ;
                    VideoDataSourceBuilder newBuilder = VideoDataSource.newBuilder();
                    newBuilder.a = uri;
                    newBuilder = newBuilder;
                    newBuilder.f = StreamSourceType.FROM_LOCAL_STORAGE;
                    VideoDataSource i = newBuilder.i();
                    MediaPlayer create = MediaPlayer.create(null, uri);
                    int duration = create.getDuration();
                    create.release();
                    VideoPlayerParamsBuilder a = VideoPlayerParams.newBuilder().a(i);
                    a.b = StringFormatUtil.formatStrLocaleSafe("qcam_%d", Integer.valueOf(uri.toString().hashCode()));
                    a = a;
                    a.c = duration;
                    VideoPlayerParams m = a.m();
                    if (quickCamInlineVideoPlayerControl.f7547a != null) {
                        quickCamInlineVideoPlayerControl.f7547a.setVideoData(m);
                    }
                    quickCamInlineVideoPlayerControl = quickCamFragment.ap;
                    if (quickCamInlineVideoPlayerControl.f7547a != null) {
                        quickCamInlineVideoPlayerControl.f7547a.setIsVideoCompleted(false);
                        quickCamInlineVideoPlayerControl.f7547a.setPauseMediaPlayerOnVideoPause(true);
                        quickCamInlineVideoPlayerControl.f7547a.setPlayerOrigin(PlayerOrigin.FEED);
                        quickCamInlineVideoPlayerControl.f7547a.setAlwaysPlayVideoUnmuted(true);
                        quickCamInlineVideoPlayerControl.f7547a.y = false;
                        quickCamInlineVideoPlayerControl.f7547a.setPauseMediaPlayerOnVideoPause(true);
                        quickCamInlineVideoPlayerControl.f7547a.setVideoListener(new C09621(quickCamInlineVideoPlayerControl));
                        quickCamInlineVideoPlayerControl.f7547a.g();
                        QuickCamInlineVideoPlayerControl.m8776f(quickCamInlineVideoPlayerControl);
                    }
                    quickCamFragment.aH = true;
                }
                AnonymousClass12 anonymousClass12 = new OnClickListener(quickCamFragment) {
                    final /* synthetic */ QuickCamFragment f7519a;

                    {
                        this.f7519a = r1;
                    }

                    public void onClick(View view) {
                        int a = Logger.a(2, EntryType.UI_INPUT_START, 208618002);
                        QuickCamInlineVideoPlayerControl quickCamInlineVideoPlayerControl = this.f7519a.ap;
                        if (quickCamInlineVideoPlayerControl.f7547a != null) {
                            QuickCamInlineVideoPlayerControl.m8777g(quickCamInlineVideoPlayerControl);
                            quickCamInlineVideoPlayerControl.f7547a.a(EventTriggerType.BY_USER, new PlayPosition(quickCamInlineVideoPlayerControl.f7551e, quickCamInlineVideoPlayerControl.f7551e));
                        }
                        this.f7519a.aS = ButtonStates.PAUSE;
                        QuickCamFragment.aC(this.f7519a);
                        Logger.a(2, EntryType.UI_INPUT_END, -739967700, a);
                    }
                };
                quickCamFragment.az.setOnClickListener(anonymousClass12);
                quickCamFragment.aF.setOnClickListener(anonymousClass12);
                quickCamFragment.aU.getInlineVideoView().setOnClickListener(null);
                quickCamFragment.aY.m8739a();
                return;
            case PAUSE:
                quickCamFragment.aw.setVisibility(8);
                quickCamFragment.ax.setVisibility(8);
                quickCamFragment.ay.setVisibility(8);
                quickCamFragment.az.setVisibility(8);
                quickCamFragment.aA.setVisibility(0);
                AnonymousClass13 anonymousClass13 = new OnClickListener(quickCamFragment) {
                    final /* synthetic */ QuickCamFragment f7520a;

                    {
                        this.f7520a = r1;
                    }

                    public void onClick(View view) {
                        int a = Logger.a(2, EntryType.UI_INPUT_START, -659606567);
                        QuickCamInlineVideoPlayerControl quickCamInlineVideoPlayerControl = this.f7520a.ap;
                        if (quickCamInlineVideoPlayerControl.f7547a != null) {
                            QuickCamInlineVideoPlayerControl.m8776f(quickCamInlineVideoPlayerControl);
                            quickCamInlineVideoPlayerControl.f7551e = quickCamInlineVideoPlayerControl.f7547a.getCurrentPosition();
                            quickCamInlineVideoPlayerControl.f7547a.a(EventTriggerType.BY_USER, VideoMediaState.PAUSED);
                        }
                        this.f7520a.aS = ButtonStates.PLAY;
                        QuickCamFragment.aC(this.f7520a);
                        Logger.a(2, EntryType.UI_INPUT_END, -818238470, a);
                    }
                };
                quickCamFragment.aA.setOnClickListener(anonymousClass13);
                quickCamFragment.aU.getInlineVideoView().setOnClickListener(anonymousClass13);
                quickCamFragment.aY.m8739a();
                return;
            default:
                return;
        }
    }

    private void aD() {
        this.aw.setVisibility(0);
        this.ax.setVisibility(8);
        this.ay.setVisibility(8);
        this.az.setVisibility(8);
        this.aA.setVisibility(8);
        this.aE.setTextColor(jW_().getColor(2131361938));
        this.aE.setText(2131242468);
        this.aE.setClickable(false);
        this.aE.setVisibility(0);
        this.at.setVisibility(0);
        this.aD.setVisibility(8);
        this.ap.m8779a(8);
        this.aG.setVisibility(8);
        this.aH = false;
    }

    public static boolean aN(QuickCamFragment quickCamFragment) {
        if (quickCamFragment.aI == null) {
            return false;
        }
        int i;
        RectF rectF;
        int i2 = quickCamFragment.jW_().getConfiguration().orientation;
        if (i2 == 1) {
            i = quickCamFragment.aK.videoFrameHeight;
        } else {
            i = quickCamFragment.aK.videoFrameWidth;
        }
        int i3 = (quickCamFragment.aK.videoFrameHeight + quickCamFragment.aK.videoFrameWidth) - i;
        float f;
        if (i2 == 1) {
            f = (((float) i) * 0.75f) / ((float) i3);
            rectF = new RectF(0.0f, 0.5f - (f / 2.0f), 1.0f, (f / 2.0f) + 0.5f);
        } else {
            f = (((float) i3) * 1.0f) / ((float) i);
            rectF = new RectF(0.5f - (f / 2.0f), 0.0f, (f / 2.0f) + 0.5f, 1.0f);
        }
        final RectF rectF2 = rectF;
        quickCamFragment.aX = quickCamFragment.f7541e.a(new Callable<File>(quickCamFragment) {
            final /* synthetic */ QuickCamFragment f7522b;

            public Object call() {
                return this.f7522b.as.a(this.f7522b.aI, Source.QUICKCAM_FRONT, rectF2, this.f7522b.ao, "birthday_quick_cam", OrientationTag.PORTRAIT);
            }
        });
        Futures.a(quickCamFragment.aX, new FutureCallback<File>(quickCamFragment) {
            final /* synthetic */ QuickCamFragment f7523a;

            {
                this.f7523a = r1;
            }

            public void onSuccess(Object obj) {
                File file = (File) obj;
                QuickCamFragment.aP(this.f7523a);
                if (file == null) {
                    this.f7523a.f7544h.b("birthday_selfie_cam_optimized_output_not_found", "Optimized output for birthday camera is not found");
                    this.f7523a.aS = ButtonStates.RECORD;
                    QuickCamFragment.aC(this.f7523a);
                    return;
                }
                this.f7523a.aq.m8734a(Events.BIRTHDAY_CAM_POST_PROCESSING_FINISHED, this.f7523a.aT);
                this.f7523a.aJ = Uri.fromFile(file);
                this.f7523a.aS = ButtonStates.PLAY;
                if (this.f7523a.hn_()) {
                    QuickCamFragment.aC(this.f7523a);
                    QuickCamFragment quickCamFragment = this.f7523a;
                    Uri uri = this.f7523a.aJ;
                    ComposerTitleBar composerTitleBar = quickCamFragment.aB;
                    StateBuilder a = quickCamFragment.aB.b.a().a(true);
                    a.c = new AnonymousClass16(quickCamFragment, uri);
                    composerTitleBar.a(a.a());
                }
            }

            public void onFailure(Throwable th) {
                QuickCamFragment.aP(this.f7523a);
                AbstractFbErrorReporter abstractFbErrorReporter = this.f7523a.f7544h;
                SoftErrorBuilder a = SoftError.a("birthday_selfie_cam_processing_failed", th.getMessage());
                a.c = th;
                abstractFbErrorReporter.a(a.g());
                this.f7523a.aS = ButtonStates.RECORD;
                if (this.f7523a.hn_()) {
                    QuickCamFragment.aC(this.f7523a);
                }
            }
        }, quickCamFragment.f7542f);
        return true;
    }

    public static void aP(QuickCamFragment quickCamFragment) {
        new File(quickCamFragment.aI.getPath()).delete();
    }
}
