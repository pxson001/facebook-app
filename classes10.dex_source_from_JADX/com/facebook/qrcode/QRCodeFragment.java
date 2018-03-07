package com.facebook.qrcode;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.graphics.Point;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.hardware.Camera.Parameters;
import android.hardware.Camera.Size;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.Vibrator;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.WindowManager.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.facebook.analytics.impression.NewImpressionId;
import com.facebook.analytics.impression.String_NewImpressionIdMethodAutoProvider;
import com.facebook.auth.annotations.LoggedInUserId;
import com.facebook.auth.module.String_LoggedInUserIdMethodAutoProvider;
import com.facebook.base.fragment.FbFragment;
import com.facebook.bitmaps.BitmapDecodeException;
import com.facebook.bitmaps.BitmapIOException;
import com.facebook.bitmaps.BitmapImageSourceException;
import com.facebook.bitmaps.BitmapOutOfMemoryException;
import com.facebook.bitmaps.BitmapUtils;
import com.facebook.camera.device.CameraHolder;
import com.facebook.camera.device.CameraHolder.CameraListener;
import com.facebook.camera.device.CameraHolder.PreviewAndPictureSize;
import com.facebook.camera.device.CameraPreview;
import com.facebook.camera.device.FocusManager.AutoFocusSource;
import com.facebook.camera.facetracking.FaceDetectionIndicatorView;
import com.facebook.camera.gating.CameraGating;
import com.facebook.camera.utils.CameraUtils;
import com.facebook.camera.utils.Orientation;
import com.facebook.camera.views.RotateLayout;
import com.facebook.common.android.VibratorMethodAutoProvider;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.executors.BackgroundExecutorService;
import com.facebook.common.executors.DefaultAndroidThreadUtil;
import com.facebook.common.executors.FbHandlerThreadFactory;
import com.facebook.common.executors.ListeningExecutorService_BackgroundExecutorServiceMethodAutoProvider;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.common.references.CloseableReference;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.tempfile.TempFileManager;
import com.facebook.common.tempfile.TempFileManager.Privacy;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.config.server.NetworkLogUrl;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.datasource.DataSource;
import com.facebook.drawee.fbpipeline.FbDraweeControllerBuilder;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.DraweeView;
import com.facebook.fbui.widget.inlineactionbar.InlineActionBar;
import com.facebook.graphql.calls.GraphQlCallInput;
import com.facebook.graphql.calls.QrcodeCreateInputData;
import com.facebook.graphql.calls.QrcodeCreateInputData.Style;
import com.facebook.graphql.calls.QrcodeCreateInputData.Type;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.query.GraphQlQueryString;
import com.facebook.imagepipeline.core.ImagePipeline;
import com.facebook.imagepipeline.datasource.BaseBitmapDataSubscriber;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.module.ImagePipelineMethodAutoProvider;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.inject.FbInjector;
import com.facebook.inject.InjectorLike;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.mediastorage.MediaStorage;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.qrcode.analytics.QRCodeAnalyticsLogger;
import com.facebook.qrcode.config.DefaultQRCodeConfig;
import com.facebook.qrcode.fetcher.QRCodeFetcher;
import com.facebook.qrcode.fetcher.QRCodeFetcher.C12911;
import com.facebook.qrcode.graphql.QRCodeGraphQL.CreateQRCodeMutationString;
import com.facebook.qrcode.graphql.QRCodeGraphQL.FetchQRCodesQueryString;
import com.facebook.qrcode.handler.Fb4aQRCodeHandler;
import com.facebook.qrcode.mutator.QRCodeMutator;
import com.facebook.qrcode.mutator.QRCodeMutator.C12921;
import com.facebook.qrcode.promo.constant.QRCodeSource;
import com.facebook.runtimepermissions.AbstractRuntimePermissionsListener;
import com.facebook.runtimepermissions.ActivityRuntimePermissionsManager;
import com.facebook.runtimepermissions.ActivityRuntimePermissionsManagerProvider;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.tools.dextr.runtime.detour.ExecutorDetour;
import com.facebook.ui.futures.TasksManager;
import com.facebook.ui.toaster.ToastBuilder;
import com.facebook.ui.toaster.Toaster;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.DecodeHintType;
import com.google.zxing.EncodeHintType;
import com.google.zxing.NotFoundException;
import com.google.zxing.PlanarYUVLuminanceSource;
import com.google.zxing.RGBLuminanceSource;
import com.google.zxing.Result;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.HybridBinarizer;
import com.google.zxing.qrcode.QRCodeReader;
import com.google.zxing.qrcode.QRCodeWriter;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.EnumMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: live_sport_event */
public class QRCodeFragment extends FbFragment implements CameraListener {
    private static final CallerContext aB = CallerContext.a(QRCodeFragment.class, "qr_code");
    private static final Point aC = new Point(4, 3);
    private static final String[] aD = new String[]{"android.permission.CAMERA"};
    public static final String[] aE = new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"};
    public static final String[] aF = new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"};
    @Inject
    DefaultAndroidThreadUtil f8622a;
    @Inject
    ActivityRuntimePermissionsManagerProvider aA;
    private Mode aG;
    private Orientation aH = Orientation.PORTRAIT;
    private View aI;
    public DraweeView aJ;
    public Bitmap aK;
    private Drawable aL;
    private Uri aM;
    public QRCodeType aN;
    private DraweeController aO;
    private DraweeController aP;
    private CameraHolder aQ;
    private CameraPreview aR;
    private RelativeLayout aS;
    private View aT;
    private RotateLayout aU;
    public View aV;
    public View aW;
    public InlineActionBar aX;
    public View aY;
    private TimerTask aZ;
    @Inject
    @LoggedInUserId
    String al;
    @Inject
    MediaStorage am;
    @Inject
    @NewImpressionId
    String an;
    @Inject
    ImagePipeline ao;
    @Inject
    FbDraweeControllerBuilder ap;
    @Inject
    DefaultQRCodeConfig aq;
    @Inject
    QRCodeFetcher ar;
    @Inject
    Fb4aQRCodeHandler as;
    @Inject
    QRCodeMutator at;
    @Inject
    public QRCodeAnalyticsLogger au;
    @Inject
    SecureContextHelper av;
    @Inject
    public TasksManager aw;
    @Inject
    TempFileManager ax;
    @Inject
    Toaster ay;
    @Inject
    Vibrator az;
    @Inject
    BitmapUtils f8623b;
    private ActivityRuntimePermissionsManager ba;
    private long bb = 0;
    @Inject
    CameraGating f8624c;
    @Inject
    Clock f8625d;
    @Inject
    public Context f8626e;
    @BackgroundExecutorService
    @Inject
    ExecutorService f8627f;
    @Inject
    AbstractFbErrorReporter f8628g;
    @Inject
    FbHandlerThreadFactory f8629h;
    @Inject
    FbSharedPreferences f8630i;

    /* compiled from: live_sport_event */
    interface Callback {
        void mo377a();

        void mo378b();

        void mo379c();
    }

    /* compiled from: live_sport_event */
    public class C12801 implements OnClickListener {
        final /* synthetic */ QRCodeFragment f8606a;

        public C12801(QRCodeFragment qRCodeFragment) {
            this.f8606a = qRCodeFragment;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 1148226564);
            QRCodeFragment.m8515a(this.f8606a, Mode.SHOW);
            Logger.a(2, EntryType.UI_INPUT_END, -1311770028, a);
        }
    }

    /* compiled from: live_sport_event */
    public class C12812 implements OnClickListener {
        final /* synthetic */ QRCodeFragment f8609a;

        public C12812(QRCodeFragment qRCodeFragment) {
            this.f8609a = qRCodeFragment;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -2007369521);
            QRCodeFragment.m8515a(this.f8609a, Mode.SCAN);
            Logger.a(2, EntryType.UI_INPUT_END, 1282271014, a);
        }
    }

    /* compiled from: live_sport_event */
    public class C12823 implements OnClickListener {
        final /* synthetic */ QRCodeFragment f8610a;

        public C12823(QRCodeFragment qRCodeFragment) {
            this.f8610a = qRCodeFragment;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -40761115);
            QRCodeFragment qRCodeFragment = this.f8610a;
            qRCodeFragment.au.m8588i();
            Intent intent = new Intent();
            intent.setType("image/*");
            intent.setAction("android.intent.action.GET_CONTENT");
            qRCodeFragment.a(Intent.createChooser(intent, qRCodeFragment.f8626e.getString(2131241354)), 1);
            Logger.a(2, EntryType.UI_INPUT_END, 1304584335, a);
        }
    }

    /* compiled from: live_sport_event */
    public class C12844 implements OnMenuItemClickListener {
        final /* synthetic */ QRCodeFragment f8612a;

        /* compiled from: live_sport_event */
        class C12831 implements Runnable {
            final /* synthetic */ C12844 f8611a;

            C12831(C12844 c12844) {
                this.f8611a = c12844;
            }

            public void run() {
                QRCodeFragment.ay(this.f8611a.f8612a);
            }
        }

        public C12844(QRCodeFragment qRCodeFragment) {
            this.f8612a = qRCodeFragment;
        }

        public boolean onMenuItemClick(MenuItem menuItem) {
            QRCodeFragment.m8519a(this.f8612a, QRCodeFragment.aE, new C12831(this));
            return true;
        }
    }

    /* compiled from: live_sport_event */
    public class C12865 implements OnMenuItemClickListener {
        final /* synthetic */ QRCodeFragment f8614a;

        /* compiled from: live_sport_event */
        class C12851 implements Runnable {
            final /* synthetic */ C12865 f8613a;

            C12851(C12865 c12865) {
                this.f8613a = c12865;
            }

            public void run() {
                QRCodeFragment.az(this.f8613a.f8614a);
            }
        }

        public C12865(QRCodeFragment qRCodeFragment) {
            this.f8614a = qRCodeFragment;
        }

        public boolean onMenuItemClick(MenuItem menuItem) {
            QRCodeFragment.m8519a(this.f8614a, QRCodeFragment.aF, new C12851(this));
            return true;
        }
    }

    /* compiled from: live_sport_event */
    public class C12876 implements OnClickListener {
        final /* synthetic */ QRCodeFragment f8615a;

        public C12876(QRCodeFragment qRCodeFragment) {
            this.f8615a = qRCodeFragment;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -120508219);
            this.f8615a.au.m8576c(this.f8615a.aN == QRCodeType.VANITY);
            if (this.f8615a.aN == QRCodeType.STANDARD) {
                QRCodeFragment.m8516a(this.f8615a, QRCodeType.VANITY);
            } else {
                QRCodeFragment.m8516a(this.f8615a, QRCodeType.STANDARD);
            }
            LogUtils.a(-848221544, a);
        }
    }

    /* compiled from: live_sport_event */
    class C12887 implements Callable<ListenableFuture<String>> {
        final /* synthetic */ QRCodeFragment f8616a;

        C12887(QRCodeFragment qRCodeFragment) {
            this.f8616a = qRCodeFragment;
        }

        public Object call() {
            QRCodeFetcher qRCodeFetcher = this.f8616a.ar;
            return Futures.a(qRCodeFetcher.f8637b.a(GraphQLRequest.a(new FetchQRCodesQueryString())), new C12911(qRCodeFetcher), qRCodeFetcher.f8636a);
        }
    }

    /* compiled from: live_sport_event */
    class C12898 extends AbstractDisposableFutureCallback<String> {
        final /* synthetic */ QRCodeFragment f8617a;

        C12898(QRCodeFragment qRCodeFragment) {
            this.f8617a = qRCodeFragment;
        }

        public final void m8511a(Object obj) {
            String str = (String) obj;
            if (str == null || str.isEmpty()) {
                QRCodeFragment qRCodeFragment = this.f8617a;
                qRCodeFragment.aw.a(Tasks.CREATE.name(), new C12909(qRCodeFragment), new AbstractDisposableFutureCallback<String>(qRCodeFragment) {
                    final /* synthetic */ QRCodeFragment f8586a;

                    {
                        this.f8586a = r1;
                    }

                    protected final void m8497a(Object obj) {
                        String str = (String) obj;
                        if (str == null || str.isEmpty()) {
                            this.f8586a.au.m8581e("Null create result");
                        } else {
                            QRCodeFragment.m8518a(this.f8586a, str);
                        }
                    }

                    public final void m8498a(Throwable th) {
                        this.f8586a.au.m8581e(th.toString());
                    }
                });
                qRCodeFragment.au.m8591l();
                return;
            }
            QRCodeFragment.m8518a(this.f8617a, str);
        }

        public final void m8512a(Throwable th) {
            this.f8617a.au.m8581e(th.toString());
        }
    }

    /* compiled from: live_sport_event */
    public class C12909 implements Callable<ListenableFuture<String>> {
        final /* synthetic */ QRCodeFragment f8618a;

        public C12909(QRCodeFragment qRCodeFragment) {
            this.f8618a = qRCodeFragment;
        }

        public Object call() {
            QRCodeMutator qRCodeMutator = this.f8618a.at;
            QrcodeCreateInputData qrcodeCreateInputData = new QrcodeCreateInputData();
            qrcodeCreateInputData.a("actor_id", qRCodeMutator.f8670c);
            GraphQlCallInput graphQlCallInput = qrcodeCreateInputData;
            graphQlCallInput.a("style", Style.VANITY);
            graphQlCallInput = graphQlCallInput;
            graphQlCallInput.a("type", Type.PERSONAL_USER);
            graphQlCallInput = graphQlCallInput;
            GraphQlQueryString createQRCodeMutationString = new CreateQRCodeMutationString();
            createQRCodeMutationString.a("input", graphQlCallInput);
            return Futures.a(qRCodeMutator.f8669b.a(GraphQLRequest.a(createQRCodeMutationString)), new C12921(qRCodeMutator), qRCodeMutator.f8668a);
        }
    }

    /* compiled from: live_sport_event */
    enum CallbackState {
        SUCCESS,
        ERROR,
        EXCEPTION
    }

    /* compiled from: live_sport_event */
    enum Mode {
        SHOW,
        SCAN
    }

    /* compiled from: live_sport_event */
    enum QRCodeType {
        STANDARD,
        VANITY
    }

    /* compiled from: live_sport_event */
    class RunnableCallback implements Runnable {
        Callback f8619a;
        CallbackState f8620b;
        Exception f8621c;

        RunnableCallback(Callback callback, CallbackState callbackState) {
            this.f8619a = callback;
            this.f8620b = callbackState;
            this.f8621c = null;
        }

        RunnableCallback(Callback callback, Exception exception) {
            this.f8619a = callback;
            this.f8620b = CallbackState.EXCEPTION;
            this.f8621c = exception;
        }

        public void run() {
            if (this.f8620b == CallbackState.SUCCESS) {
                this.f8619a.mo377a();
            } else if (this.f8620b == CallbackState.ERROR) {
                this.f8619a.mo378b();
            } else if (this.f8620b == CallbackState.EXCEPTION) {
                this.f8619a.mo379c();
            }
        }
    }

    /* compiled from: live_sport_event */
    public enum Tasks {
        FETCH,
        CREATE
    }

    public static void m8521a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        ((QRCodeFragment) obj).m8513a(DefaultAndroidThreadUtil.a(injectorLike), BitmapUtils.a(injectorLike), CameraGating.a(injectorLike), (Clock) SystemClockMethodAutoProvider.a(injectorLike), (Context) injectorLike.getInstance(Context.class), (ExecutorService) ListeningExecutorService_BackgroundExecutorServiceMethodAutoProvider.a(injectorLike), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike), FbHandlerThreadFactory.a(injectorLike), (FbSharedPreferences) FbSharedPreferencesImpl.a(injectorLike), String_LoggedInUserIdMethodAutoProvider.a(injectorLike), MediaStorage.a(injectorLike), String_NewImpressionIdMethodAutoProvider.a(injectorLike), ImagePipelineMethodAutoProvider.a(injectorLike), FbDraweeControllerBuilder.a(injectorLike), DefaultQRCodeConfig.m8594a(injectorLike), QRCodeFetcher.m8599a(injectorLike), Fb4aQRCodeHandler.m8682a(injectorLike), QRCodeMutator.m8685a(injectorLike), QRCodeAnalyticsLogger.m8550a(injectorLike), (SecureContextHelper) DefaultSecureContextHelper.a(injectorLike), TasksManager.a(injectorLike), TempFileManager.a(injectorLike), Toaster.a(injectorLike), VibratorMethodAutoProvider.a(injectorLike), (ActivityRuntimePermissionsManagerProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(ActivityRuntimePermissionsManagerProvider.class));
    }

    public static void m8517a(QRCodeFragment qRCodeFragment, Result result, boolean z) {
        qRCodeFragment.aZ = qRCodeFragment.as.m8684a(result.f13467a);
        if (qRCodeFragment.aZ == null) {
            if (z) {
                if (qRCodeFragment.f8625d.a() - qRCodeFragment.bb >= 5000) {
                    qRCodeFragment.bb = qRCodeFragment.f8625d.a();
                } else {
                    return;
                }
            }
            qRCodeFragment.ay.b(new ToastBuilder(2131241346));
            qRCodeFragment.au.m8575c(result.f13467a, z);
            return;
        }
        if (z) {
            qRCodeFragment.az.vibrate(50);
        }
        qRCodeFragment.aT.setEnabled(false);
        new Timer().schedule(qRCodeFragment.aZ, 100);
        qRCodeFragment.au.m8572b(result.f13467a, z);
    }

    private void m8513a(DefaultAndroidThreadUtil defaultAndroidThreadUtil, BitmapUtils bitmapUtils, CameraGating cameraGating, Clock clock, Context context, ExecutorService executorService, AbstractFbErrorReporter abstractFbErrorReporter, FbHandlerThreadFactory fbHandlerThreadFactory, FbSharedPreferences fbSharedPreferences, String str, MediaStorage mediaStorage, String str2, ImagePipeline imagePipeline, FbDraweeControllerBuilder fbDraweeControllerBuilder, DefaultQRCodeConfig defaultQRCodeConfig, QRCodeFetcher qRCodeFetcher, Fb4aQRCodeHandler fb4aQRCodeHandler, QRCodeMutator qRCodeMutator, QRCodeAnalyticsLogger qRCodeAnalyticsLogger, SecureContextHelper secureContextHelper, TasksManager tasksManager, TempFileManager tempFileManager, Toaster toaster, Vibrator vibrator, ActivityRuntimePermissionsManagerProvider activityRuntimePermissionsManagerProvider) {
        this.f8622a = defaultAndroidThreadUtil;
        this.f8623b = bitmapUtils;
        this.f8624c = cameraGating;
        this.f8625d = clock;
        this.f8626e = context;
        this.f8627f = executorService;
        this.f8628g = abstractFbErrorReporter;
        this.f8629h = fbHandlerThreadFactory;
        this.f8630i = fbSharedPreferences;
        this.al = str;
        this.am = mediaStorage;
        this.an = str2;
        this.ao = imagePipeline;
        this.ap = fbDraweeControllerBuilder;
        this.aq = defaultQRCodeConfig;
        this.ar = qRCodeFetcher;
        this.as = fb4aQRCodeHandler;
        this.at = qRCodeMutator;
        this.au = qRCodeAnalyticsLogger;
        this.av = secureContextHelper;
        this.aw = tasksManager;
        this.ax = tempFileManager;
        this.ay = toaster;
        this.az = vibrator;
        this.aA = activityRuntimePermissionsManagerProvider;
    }

    public final void m8543c(Bundle bundle) {
        super.c(bundle);
        Class cls = QRCodeFragment.class;
        m8521a((Object) this, getContext());
        QRCodeSource fromString = QRCodeSource.fromString(this.s.getString("source"));
        this.au.f8632b = this.an;
        this.au.m8578d(fromString.value);
        this.ap.a(aB);
        this.ba = this.aA.a(o());
    }

    public final View m8528a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 662624409);
        ao().getWindow().addFlags(128);
        View inflate = layoutInflater.inflate(2130906535, viewGroup, false);
        m8522b(inflate);
        this.aV.setOnClickListener(new C12801(this));
        this.aW.setOnClickListener(new C12812(this));
        this.aY.setOnClickListener(new C12823(this));
        this.aX.d(2131241351).setOnMenuItemClickListener(new C12844(this));
        this.aX.d(2131241355).setOnMenuItemClickListener(new C12865(this));
        this.aJ.setOnClickListener(new C12876(this));
        DefaultQRCodeConfig defaultQRCodeConfig = this.aq;
        if (1 != 0) {
            m8515a(this, Mode.SHOW);
        } else {
            m8515a(this, Mode.SCAN);
        }
        LogUtils.f(737443282, a);
        return inflate;
    }

    private void m8522b(View view) {
        this.aI = view.findViewById(2131566467);
        this.aJ = (DraweeView) view.findViewById(2131566469);
        this.aS = (RelativeLayout) view.findViewById(2131559845);
        this.aT = view.findViewById(2131566472);
        this.aU = (RotateLayout) view.findViewById(2131562104);
        this.aV = view.findViewById(2131566465);
        this.aW = view.findViewById(2131566466);
        this.aX = (InlineActionBar) view.findViewById(2131566470);
        this.aY = view.findViewById(2131563066);
        TextView textView = (TextView) view.findViewById(2131566468);
        TextView textView2 = (TextView) view.findViewById(2131566473);
        View findViewById = view.findViewById(2131566464);
        DefaultQRCodeConfig defaultQRCodeConfig = this.aq;
        textView.setText(2131241356);
        DefaultQRCodeConfig defaultQRCodeConfig2 = this.aq;
        textView2.setText(2131241353);
        defaultQRCodeConfig2 = this.aq;
        if (1 == 0) {
            findViewById.setVisibility(8);
        } else {
            au();
        }
        GenericDraweeHierarchyBuilder genericDraweeHierarchyBuilder = new GenericDraweeHierarchyBuilder(jW_());
        genericDraweeHierarchyBuilder.f = this.aL;
        this.aJ.setHierarchy(genericDraweeHierarchyBuilder.u());
    }

    public static void at(QRCodeFragment qRCodeFragment) {
        if (qRCodeFragment.aQ == null) {
            qRCodeFragment.aQ = new CameraHolder(qRCodeFragment, qRCodeFragment.f8626e, qRCodeFragment.f8630i, qRCodeFragment.au, qRCodeFragment.am, qRCodeFragment.f8624c, qRCodeFragment.f8622a, qRCodeFragment.f8629h, qRCodeFragment.f8628g);
            qRCodeFragment.aQ.e();
        }
        qRCodeFragment.aQ.j();
        qRCodeFragment.aT.setEnabled(true);
        qRCodeFragment.aZ = null;
    }

    private void au() {
        try {
            this.aK = ax();
            if (this.aK != null) {
                this.aL = new BitmapDrawable(jW_(), this.aK);
            }
        } catch (WriterException e) {
            this.ay.b(new ToastBuilder(2131241344));
        } catch (OutOfMemoryError e2) {
            this.ay.b(new ToastBuilder(2131241344));
        }
        this.aO = null;
        this.aP = null;
        m8516a(this, QRCodeType.STANDARD);
        av();
    }

    private void av() {
        this.aw.a(Tasks.FETCH.name(), new C12887(this), new C12898(this));
        this.au.m8592o();
    }

    public static void m8518a(QRCodeFragment qRCodeFragment, String str) {
        if (str == null || str.isEmpty()) {
            qRCodeFragment.au.m8581e("Empty uri");
            return;
        }
        qRCodeFragment.aM = Uri.parse(str);
        qRCodeFragment.aP = ((FbDraweeControllerBuilder) qRCodeFragment.ap.b(qRCodeFragment.aP)).b(qRCodeFragment.aM).s();
        qRCodeFragment.f8622a.b(new Runnable(qRCodeFragment) {
            final /* synthetic */ QRCodeFragment f8587a;

            {
                this.f8587a = r1;
            }

            public void run() {
                QRCodeFragment.m8516a(this.f8587a, QRCodeType.VANITY);
            }
        });
        qRCodeFragment.au.m8593p();
    }

    public static void m8516a(QRCodeFragment qRCodeFragment, QRCodeType qRCodeType) {
        DraweeController draweeController = null;
        if (qRCodeType == QRCodeType.STANDARD && qRCodeFragment.aO != null) {
            draweeController = qRCodeFragment.aO;
        } else if (qRCodeType == QRCodeType.VANITY && qRCodeFragment.aP != null) {
            draweeController = qRCodeFragment.aP;
        }
        if (draweeController != null) {
            qRCodeFragment.aN = qRCodeType;
            qRCodeFragment.aJ.setController(draweeController);
        }
    }

    private Bitmap ax() {
        String formatStrLocaleSafe = StringFormatUtil.formatStrLocaleSafe("http://www.%s/qr?id=%s", NetworkLogUrl.a(this.f8626e, "%s"), this.al);
        Map enumMap = new EnumMap(EncodeHintType.class);
        enumMap.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.L);
        enumMap.put(EncodeHintType.MARGIN, Integer.valueOf(1));
        QRCodeWriter qRCodeWriter = new QRCodeWriter();
        int i = this.aJ.getLayoutParams().width;
        BitMatrix a = QRCodeWriter.m13731a(formatStrLocaleSafe, BarcodeFormat.QR_CODE, i, i, enumMap);
        i = a.f13477a;
        int i2 = a.f13478b;
        int[] iArr = new int[(i * i2)];
        for (int i3 = 0; i3 < i2; i3++) {
            int i4 = i3 * i;
            for (int i5 = 0; i5 < i; i5++) {
                iArr[i4 + i5] = a.m13674a(i5, i3) ? -16777216 : -1;
            }
        }
        Bitmap createBitmap = Bitmap.createBitmap(i, i2, Config.ARGB_8888);
        createBitmap.setPixels(iArr, 0, i, 0, 0, i, i2);
        return createBitmap;
    }

    public static void m8515a(QRCodeFragment qRCodeFragment, Mode mode) {
        Mode mode2 = qRCodeFragment.aG;
        if (mode2 != mode) {
            qRCodeFragment.aG = mode;
            if (mode2 == Mode.SCAN && qRCodeFragment.aQ != null) {
                qRCodeFragment.aQ.l();
            }
            if (mode == Mode.SHOW) {
                qRCodeFragment.aV.setEnabled(false);
                qRCodeFragment.aW.setEnabled(true);
                qRCodeFragment.aI.setVisibility(0);
                qRCodeFragment.aS.setVisibility(8);
                qRCodeFragment.au.m8589j();
            } else if (mode == Mode.SCAN) {
                qRCodeFragment.aV.setEnabled(true);
                qRCodeFragment.aW.setEnabled(false);
                qRCodeFragment.aI.setVisibility(8);
                qRCodeFragment.aS.setVisibility(0);
                m8519a(qRCodeFragment, aD, new Runnable(qRCodeFragment) {
                    final /* synthetic */ QRCodeFragment f8588a;

                    {
                        this.f8588a = r1;
                    }

                    public void run() {
                        QRCodeFragment.at(this.f8588a);
                    }
                });
                qRCodeFragment.au.m8590k();
            }
            qRCodeFragment.m8524h(qRCodeFragment.D());
        }
    }

    public final void m8526H() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -159817008);
        if (this.aG == Mode.SCAN && this.aQ != null) {
            this.aQ.l();
        }
        super.H();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -11478470, a);
    }

    public final void m8525G() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1359116420);
        super.G();
        if (this.aG == Mode.SCAN && this.aQ != null) {
            m8519a(this, aD, new Runnable(this) {
                final /* synthetic */ QRCodeFragment f8589a;

                {
                    this.f8589a = r1;
                }

                public void run() {
                    QRCodeFragment.at(this.f8589a);
                }
            });
        }
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 1711005885, a);
    }

    public final void mY_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 630867237);
        ao().getWindow().clearFlags(128);
        m8524h(false);
        super.mY_();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 1844546964, a);
    }

    public final void m8527I() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 957700966);
        if (this.aK != null) {
            this.aK.recycle();
        }
        this.aw.c();
        super.I();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -1789597870, a);
    }

    public final void m8537a(byte[] bArr, Parameters parameters) {
        if (this.aZ == null) {
            Size previewSize = parameters.getPreviewSize();
            try {
                m8517a(this, new QRCodeReader().m13728a(new BinaryBitmap(new HybridBinarizer(new PlanarYUVLuminanceSource(bArr, previewSize.width, previewSize.height, 0, 0, previewSize.width, previewSize.height, false)))), true);
            } catch (NotFoundException e) {
            } catch (Exception e2) {
            }
        }
    }

    public final void m8532a(CameraPreview cameraPreview) {
        this.aS.addView(cameraPreview, 0);
        this.aR = cameraPreview;
    }

    public final void m8535a(boolean z) {
        if (z) {
            this.aU.setVisibility(0);
            if (this.aQ != null) {
                this.aQ.a(AutoFocusSource.LAST_SECOND_AUTOFOCUS);
            }
            CameraPreview cameraPreview = this.aR;
            cameraPreview.e = this;
            cameraPreview.c.setPreviewCallback(cameraPreview);
            return;
        }
        this.ay.b(new ToastBuilder(2131241345));
        this.au.m8568b();
    }

    public final void m8529a() {
        this.aU.setVisibility(8);
        if (this.aR != null) {
            this.aS.removeView(this.aR);
            this.aR = null;
        }
    }

    public final void m8538b() {
    }

    public final void m8536a(byte[] bArr, int i) {
        if (this.aQ != null) {
            this.aQ.j();
        }
    }

    public final void m8531a(Uri uri) {
    }

    public final void C_(int i) {
    }

    public final void m8539b(Uri uri) {
    }

    public final void m8533a(AutoFocusSource autoFocusSource) {
    }

    public final void m8542c(Uri uri) {
    }

    public final RotateLayout m8541c() {
        return this.aU;
    }

    public final int m8544d() {
        return 0;
    }

    public final Orientation m8545e() {
        return m8546f();
    }

    public final Orientation m8546f() {
        return this.aH;
    }

    public final int m8547g() {
        return 0;
    }

    public final FaceDetectionIndicatorView m8549h() {
        return null;
    }

    public final void m8534a(List<Size> list, List<Size> list2, PreviewAndPictureSize previewAndPictureSize) {
        previewAndPictureSize.a = CameraUtils.a(list, aC);
        previewAndPictureSize.b = CameraUtils.a(list2, aC);
    }

    public final void m8540b(boolean z) {
    }

    public final void m8548g(boolean z) {
        super.g(z);
        m8524h(z);
    }

    private void m8524h(boolean z) {
        Activity ao = ao();
        if (ao != null) {
            LayoutParams attributes = ao.getWindow().getAttributes();
            if (this.aG == Mode.SHOW && z) {
                attributes.screenBrightness = Math.max(0.7f, attributes.screenBrightness);
            } else {
                attributes.screenBrightness = -1.0f;
            }
            ao.getWindow().setAttributes(attributes);
        }
    }

    public static void ay(QRCodeFragment qRCodeFragment) {
        qRCodeFragment.au.m8582e(qRCodeFragment.aN == QRCodeType.VANITY);
        try {
            File file = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM), "Facebook");
            if (file.exists() || file.mkdirs()) {
                final File file2 = new File(file, StringFormatUtil.formatStrLocaleSafe("%s_%s%s", "QRCODE", Long.valueOf(qRCodeFragment.f8625d.a()), ".jpg"));
                qRCodeFragment.m8520a(file2, new Callback(qRCodeFragment) {
                    final /* synthetic */ QRCodeFragment f8591b;

                    public final void mo377a() {
                        Intent intent = new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE");
                        intent.setData(Uri.fromFile(file2));
                        this.f8591b.f8626e.sendBroadcast(intent);
                        this.f8591b.ay.b(new ToastBuilder(2131241341));
                        this.f8591b.au.m8579d(this.f8591b.aN == QRCodeType.VANITY);
                    }

                    public final void mo378b() {
                        this.f8591b.ay.b(new ToastBuilder(2131241347));
                    }

                    public final void mo379c() {
                        this.f8591b.ay.b(new ToastBuilder(2131241350));
                    }
                });
            }
        } catch (NullPointerException e) {
            qRCodeFragment.ay.b(new ToastBuilder(2131241350));
        }
    }

    public static void az(QRCodeFragment qRCodeFragment) {
        qRCodeFragment.au.m8586g(qRCodeFragment.aN == QRCodeType.VANITY);
        final File a = qRCodeFragment.ax.a("QRCODE", ".jpg", Privacy.PREFER_SDCARD);
        qRCodeFragment.m8520a(a, new Callback(qRCodeFragment) {
            final /* synthetic */ QRCodeFragment f8593b;

            public final void mo377a() {
                boolean z = true;
                Intent intent = new Intent("android.intent.action.SEND");
                intent.putExtra("android.intent.extra.STREAM", Uri.parse("file://" + a.getAbsolutePath()));
                intent.addFlags(1);
                intent.setType("image/jpeg");
                this.f8593b.av.b(intent, this.f8593b.f8626e);
                QRCodeAnalyticsLogger qRCodeAnalyticsLogger = this.f8593b.au;
                if (this.f8593b.aN != QRCodeType.VANITY) {
                    z = false;
                }
                qRCodeAnalyticsLogger.m8584f(z);
            }

            public final void mo378b() {
                this.f8593b.ay.b(new ToastBuilder(2131241348));
            }

            public final void mo379c() {
                this.f8593b.ay.b(new ToastBuilder(2131241349));
            }
        });
    }

    public static void m8519a(QRCodeFragment qRCodeFragment, @Nullable String[] strArr, final Runnable runnable) {
        qRCodeFragment.ba.a(strArr, new AbstractRuntimePermissionsListener(qRCodeFragment) {
            final /* synthetic */ QRCodeFragment f8595b;

            public final void m8508a() {
                if (runnable != null) {
                    runnable.run();
                }
            }
        });
    }

    private void m8520a(final File file, final Callback callback) {
        if (this.aN == QRCodeType.STANDARD) {
            ExecutorDetour.a(this.f8627f, new Runnable(this) {
                final /* synthetic */ QRCodeFragment f8598c;

                public void run() {
                    QRCodeFragment.m8514a(this.f8598c, this.f8598c.aK, file, callback);
                }
            }, 2000545951);
        } else if (this.aN == QRCodeType.VANITY) {
            this.ao.c(ImageRequest.a(this.aM), aB).a(new BaseBitmapDataSubscriber(this) {
                final /* synthetic */ QRCodeFragment f8601c;

                public final void m8509a(@Nullable Bitmap bitmap) {
                    QRCodeFragment.m8514a(this.f8601c, bitmap, file, callback);
                }

                public final void m8510f(DataSource<CloseableReference<CloseableImage>> dataSource) {
                    this.f8601c.f8622a.b(new RunnableCallback(callback, CallbackState.ERROR));
                }
            }, this.f8627f);
        }
    }

    public static void m8514a(QRCodeFragment qRCodeFragment, Bitmap bitmap, File file, Callback callback) {
        Exception e;
        Throwable th;
        OutputStream outputStream;
        FileOutputStream fileOutputStream = null;
        if (bitmap == null) {
            try {
                throw new IOException();
            } catch (Exception e2) {
                e = e2;
                try {
                    qRCodeFragment.f8622a.b(new RunnableCallback(callback, e));
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException e3) {
                            return;
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException e4) {
                        }
                    }
                    throw th;
                }
            }
        }
        OutputStream fileOutputStream2 = new FileOutputStream(file);
        try {
            qRCodeFragment.f8622a.b(new RunnableCallback(callback, bitmap.compress(CompressFormat.JPEG, 90, fileOutputStream2) ? CallbackState.SUCCESS : CallbackState.ERROR));
            try {
                fileOutputStream2.close();
            } catch (IOException e5) {
            }
        } catch (Exception e6) {
            e = e6;
            outputStream = fileOutputStream2;
            qRCodeFragment.f8622a.b(new RunnableCallback(callback, e));
            if (fileOutputStream != null) {
                fileOutputStream.close();
            }
        } catch (Throwable th3) {
            th = th3;
            outputStream = fileOutputStream2;
            if (fileOutputStream != null) {
                fileOutputStream.close();
            }
            throw th;
        }
    }

    public final void m8530a(int i, int i2, final Intent intent) {
        if (i2 == -1 && i == 1) {
            ExecutorDetour.a(this.f8627f, new Runnable(this) {
                final /* synthetic */ QRCodeFragment f8605b;

                public void run() {
                    this.f8605b.au.m8585g();
                    QRCodeReader qRCodeReader = new QRCodeReader();
                    try {
                        Result a;
                        Bitmap a2 = this.f8605b.f8623b.a(this.f8605b.f8626e, intent.getData(), false);
                        int width = a2.getWidth();
                        int height = a2.getHeight();
                        int[] iArr = new int[(width * height)];
                        a2.getPixels(iArr, 0, width, 0, 0, width, height);
                        a2.recycle();
                        BinaryBitmap binaryBitmap = new BinaryBitmap(new HybridBinarizer(new RGBLuminanceSource(width, height, iArr)));
                        Map hashtable = new Hashtable();
                        hashtable.put(DecodeHintType.TRY_HARDER, Boolean.TRUE);
                        try {
                            a = qRCodeReader.m13729a(binaryBitmap, hashtable);
                        } catch (Exception e) {
                            a = null;
                        }
                        if (a == null) {
                            hashtable.put(DecodeHintType.PURE_BARCODE, Boolean.TRUE);
                            try {
                                a = qRCodeReader.m13729a(binaryBitmap, hashtable);
                            } catch (Exception e2) {
                                a = null;
                            }
                        }
                        if (a == null) {
                            QRCodeFragment.m8523g(this.f8605b, 2131241343);
                            this.f8605b.au.m8583f();
                            return;
                        }
                        this.f8605b.f8622a.a(new Runnable(this) {
                            final /* synthetic */ AnonymousClass19 f8603b;

                            public void run() {
                                QRCodeFragment.m8517a(this.f8603b.f8605b, a, false);
                            }
                        }, 100);
                    } catch (BitmapIOException e3) {
                        QRCodeFragment.m8523g(this.f8605b, 2131241343);
                        this.f8605b.au.m8583f();
                    } catch (BitmapDecodeException e4) {
                        QRCodeFragment.m8523g(this.f8605b, 2131241343);
                        this.f8605b.au.m8583f();
                    } catch (BitmapOutOfMemoryException e5) {
                        QRCodeFragment.m8523g(this.f8605b, 2131241343);
                        this.f8605b.au.m8587h();
                    } catch (BitmapImageSourceException e6) {
                        QRCodeFragment.m8523g(this.f8605b, 2131241343);
                        this.f8605b.au.m8587h();
                    } catch (OutOfMemoryError e7) {
                        QRCodeFragment.m8523g(this.f8605b, 2131241343);
                        this.f8605b.au.m8583f();
                    }
                }
            }, 463623024);
        }
    }

    public static void m8523g(QRCodeFragment qRCodeFragment, final int i) {
        qRCodeFragment.f8622a.b(new Runnable(qRCodeFragment) {
            final /* synthetic */ QRCodeFragment f8608b;

            public void run() {
                this.f8608b.ay.b(new ToastBuilder(i));
            }
        });
    }
}
