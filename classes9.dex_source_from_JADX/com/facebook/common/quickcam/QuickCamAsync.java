package com.facebook.common.quickcam;

import android.graphics.Point;
import android.hardware.Camera;
import android.hardware.Camera.PictureCallback;
import android.media.CamcorderProfile;
import android.net.Uri;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.executors.DefaultAndroidThreadUtil;
import com.facebook.common.executors.DefaultSerialListeningExecutorService;
import com.facebook.common.executors.DefaultSerialListeningExecutorService_DefaultExecutorServiceMethodAutoProvider;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.common.quickcam.QuickCamCameraManager.C06342;
import com.facebook.common.quickcam.QuickCamVideoRecordingManager.RecordedVideo;
import com.facebook.common.quickcam.prefs.QuickCamPrefKeys;
import com.facebook.common.ui.util.BetterRotationManager;
import com.facebook.common.util.TriState;
import com.facebook.config.application.Product;
import com.facebook.config.application.ProductMethodAutoProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.tools.dextr.runtime.detour.ExecutorDetour;
import com.facebook.ui.toaster.Toaster;
import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import java.util.Iterator;
import java.util.Queue;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
import javax.annotation.concurrent.Immutable;
import javax.annotation.concurrent.ThreadSafe;
import javax.inject.Inject;

@ThreadSafe
/* compiled from: provider_page_fbid */
public class QuickCamAsync {
    private static final Class<?> f6034a = QuickCamAsync.class;
    private final DefaultSerialListeningExecutorService f6035b;
    private final DefaultAndroidThreadUtil f6036c;
    public final QuickCamCameraManager f6037d;
    private final QuickCamVideoRecordingManager f6038e;
    private final Object f6039f = new Object();
    @GuardedBy("mQueueLock")
    private final Queue<Command> f6040g = Lists.b();
    public volatile boolean f6041h;
    private volatile boolean f6042i;
    public volatile boolean f6043j;
    private volatile float f6044k;
    private volatile boolean f6045l;
    private volatile State f6046m = State.CLOSED;
    private volatile QuickCamPreviewHolder f6047n;
    @GuardedBy("ui-thread")
    private Listener f6048o;

    /* compiled from: provider_page_fbid */
    class C06291 implements Runnable {
        final /* synthetic */ QuickCamAsync f6017a;

        C06291(QuickCamAsync quickCamAsync) {
            this.f6017a = quickCamAsync;
        }

        public void run() {
            QuickCamAsync.m6370l(this.f6017a);
        }
    }

    /* compiled from: provider_page_fbid */
    class C06302 implements PictureCallback {
        final /* synthetic */ QuickCamAsync f6018a;

        C06302(QuickCamAsync quickCamAsync) {
            this.f6018a = quickCamAsync;
        }

        public void onPictureTaken(byte[] bArr, Camera camera) {
            QuickCamAsync.m6363a(this.f6018a, NotifyEventType.TOOK_PICTURE, new PictureTakenParams(bArr, this.f6018a.f6037d.f6065k.width, this.f6018a.f6037d.f6065k.height, this.f6018a.f6037d.m6409j()));
        }
    }

    /* compiled from: provider_page_fbid */
    enum Action {
        OPEN,
        CLOSE,
        FLIP_CAMERA,
        FOCUS_ON_TAP,
        TAKE_PICTURE,
        START_RECORDING,
        START_HIGH_RES_RECORDING,
        STOP_RECORDING,
        FINISH_RECORDING,
        CANCEL_RECORDING,
        START_PREVIEW,
        STOP_PREVIEW
    }

    @Immutable
    /* compiled from: provider_page_fbid */
    class Command<T> {
        public final Action f6024a;
        @Nullable
        public final T f6025b;

        public Command(Action action) {
            this.f6024a = action;
            this.f6025b = null;
        }

        public Command(Action action, T t) {
            this.f6024a = action;
            this.f6025b = t;
        }
    }

    /* compiled from: provider_page_fbid */
    public interface Listener {
        void mo688a();

        void mo689a(@Nullable Uri uri, @Nullable CamcorderProfile camcorderProfile, boolean z, int i);

        void mo690a(byte[] bArr, int i, int i2, boolean z);

        void mo691b();

        void mo692c();

        void mo693d();

        void mo694e();

        void mo695f();
    }

    /* compiled from: provider_page_fbid */
    enum NotifyEventType {
        OPEN,
        CLOSE,
        FLIPPED_CAMERA,
        TOOK_PICTURE,
        STARTED_RECORDING,
        STOPPING_RECORDING,
        STOPPED_RECORDING,
        ERROR
    }

    @Immutable
    /* compiled from: provider_page_fbid */
    class PictureTakenParams {
        public final byte[] f6026a;
        public final int f6027b;
        public final int f6028c;
        public final boolean f6029d;

        public PictureTakenParams(byte[] bArr, int i, int i2, boolean z) {
            this.f6026a = bArr;
            this.f6027b = i;
            this.f6028c = i2;
            this.f6029d = z;
        }
    }

    @Immutable
    /* compiled from: provider_page_fbid */
    class RecordedVideoParams {
        public final Uri f6030a;
        public final CamcorderProfile f6031b;
        public final boolean f6032c;
        public final int f6033d;

        public RecordedVideoParams() {
            this(null, null, false, -1);
        }

        public RecordedVideoParams(Uri uri, CamcorderProfile camcorderProfile, boolean z, int i) {
            this.f6030a = uri;
            this.f6031b = camcorderProfile;
            this.f6032c = z;
            this.f6033d = i;
        }
    }

    /* compiled from: provider_page_fbid */
    enum State {
        CLOSED,
        OPEN,
        RECORDING
    }

    public static QuickCamAsync m6358a(InjectorLike injectorLike) {
        return new QuickCamAsync(DefaultSerialListeningExecutorService_DefaultExecutorServiceMethodAutoProvider.b(injectorLike), DefaultAndroidThreadUtil.b(injectorLike), new QuickCamCameraManager(BetterRotationManager.b(injectorLike), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike), (FbSharedPreferences) FbSharedPreferencesImpl.a(injectorLike), Toaster.b(injectorLike), (FocusOverlayManagerProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(FocusOverlayManagerProvider.class), CameraUtil.m6329b(injectorLike), (Executor) ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.a(injectorLike), ProductMethodAutoProvider.b(injectorLike)), QuickCamVideoRecordingManager.m6445b(injectorLike));
    }

    @Inject
    public QuickCamAsync(DefaultSerialListeningExecutorService defaultSerialListeningExecutorService, DefaultAndroidThreadUtil defaultAndroidThreadUtil, QuickCamCameraManager quickCamCameraManager, QuickCamVideoRecordingManager quickCamVideoRecordingManager) {
        this.f6035b = defaultSerialListeningExecutorService;
        this.f6036c = defaultAndroidThreadUtil;
        this.f6037d = quickCamCameraManager;
        this.f6038e = quickCamVideoRecordingManager;
    }

    public final void m6380a(Listener listener) {
        this.f6036c.a();
        this.f6048o = listener;
    }

    public final void m6377a() {
        if (!this.f6041h) {
            boolean z;
            QuickCamCameraManager quickCamCameraManager = this.f6037d;
            quickCamCameraManager.f6068n = QuickCamCameraManager.m6399b(1);
            quickCamCameraManager.f6069o = QuickCamCameraManager.m6399b(0);
            quickCamCameraManager.f6066l = TriState.UNSET;
            int a = quickCamCameraManager.f6059e.a(QuickCamPrefKeys.f6121b, -1);
            if (a >= 0) {
                if (a == 1) {
                    a = quickCamCameraManager.f6068n;
                } else {
                    a = quickCamCameraManager.f6069o;
                }
                quickCamCameraManager.f6070p = a;
            } else {
                a = quickCamCameraManager.f6067m == Product.PAA ? quickCamCameraManager.f6069o : quickCamCameraManager.f6068n;
                int i = a == quickCamCameraManager.f6068n ? quickCamCameraManager.f6069o : quickCamCameraManager.f6068n;
                if (a < 0) {
                    a = i;
                }
                quickCamCameraManager.f6070p = a;
            }
            this.f6038e.f6095e = this.f6037d;
            quickCamCameraManager = this.f6037d;
            if (quickCamCameraManager.f6069o == -1 || quickCamCameraManager.f6068n == -1) {
                z = true;
            } else {
                z = false;
            }
            this.f6042i = z;
            if (this.f6037d.f6068n != -1) {
                z = true;
            } else {
                z = false;
            }
            this.f6043j = z;
            this.f6041h = true;
        }
    }

    public final void m6381a(QuickCamPreviewHolder quickCamPreviewHolder) {
        Preconditions.checkState(this.f6041h);
        m6360a(Action.CLOSE);
        m6361a(new Command(Action.OPEN, quickCamPreviewHolder));
    }

    public final void m6382b() {
        Preconditions.checkState(this.f6041h);
        m6360a(Action.OPEN);
        m6360a(Action.FLIP_CAMERA);
        m6360a(Action.FOCUS_ON_TAP);
        m6360a(Action.TAKE_PICTURE);
        m6360a(Action.START_RECORDING);
        m6360a(Action.START_HIGH_RES_RECORDING);
        m6360a(Action.START_PREVIEW);
        m6360a(Action.STOP_PREVIEW);
        m6366b(Action.CLOSE);
    }

    public final void m6383c() {
        Preconditions.checkState(this.f6041h);
        m6366b(Action.FLIP_CAMERA);
    }

    public final void m6379a(int i, int i2) {
        Preconditions.checkState(this.f6041h);
        m6361a(new Command(Action.FOCUS_ON_TAP, new Point(i, i2)));
    }

    public final void m6384d() {
        Preconditions.checkState(this.f6041h);
        m6366b(Action.TAKE_PICTURE);
    }

    public final void m6378a(int i) {
        Preconditions.checkState(this.f6041h);
        m6361a(new Command(Action.START_RECORDING, Integer.valueOf(i)));
    }

    public final void m6385e() {
        Preconditions.checkState(this.f6041h);
        m6360a(Action.START_RECORDING);
        m6360a(Action.START_HIGH_RES_RECORDING);
        m6366b(Action.STOP_RECORDING);
    }

    public final void m6386f() {
        Preconditions.checkState(this.f6041h);
        m6360a(Action.START_RECORDING);
        m6360a(Action.START_HIGH_RES_RECORDING);
        m6366b(Action.FINISH_RECORDING);
    }

    public final void m6387g() {
        Preconditions.checkState(this.f6041h);
        m6360a(Action.START_RECORDING);
        m6360a(Action.START_HIGH_RES_RECORDING);
        m6366b(Action.CANCEL_RECORDING);
    }

    public final boolean m6388h() {
        Preconditions.checkState(this.f6041h);
        return this.f6045l;
    }

    public final float m6389i() {
        Preconditions.checkState(this.f6041h);
        return this.f6044k;
    }

    public final boolean m6390j() {
        Preconditions.checkState(this.f6041h);
        return this.f6042i;
    }

    private void m6360a(Action action) {
        synchronized (this.f6039f) {
            Iterator it = this.f6040g.iterator();
            while (it.hasNext()) {
                if (((Command) it.next()).f6024a == action) {
                    it.remove();
                }
            }
        }
    }

    private void m6366b(Action action) {
        m6361a(new Command(action));
    }

    private void m6361a(Command command) {
        synchronized (this.f6039f) {
            this.f6040g.add(command);
            ExecutorDetour.a(this.f6035b, new C06291(this), -299093406);
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void m6370l(com.facebook.common.quickcam.QuickCamAsync r3) {
        /*
    L_0x0000:
        r1 = r3.f6039f;
        monitor-enter(r1);
        r0 = r3.f6040g;	 Catch:{ all -> 0x002c }
        r0 = r0.isEmpty();	 Catch:{ all -> 0x002c }
        if (r0 == 0) goto L_0x000d;
    L_0x000b:
        monitor-exit(r1);	 Catch:{ all -> 0x002c }
        return;
    L_0x000d:
        r0 = r3.f6040g;	 Catch:{ all -> 0x002c }
        r0 = r0.poll();	 Catch:{ all -> 0x002c }
        r0 = (com.facebook.common.quickcam.QuickCamAsync.Command) r0;	 Catch:{ all -> 0x002c }
        monitor-exit(r1);	 Catch:{ all -> 0x002c }
        r1 = com.facebook.common.quickcam.QuickCamAsync.C06324.f6022a;
        r2 = r0.f6024a;
        r2 = r2.ordinal();
        r1 = r1[r2];
        switch(r1) {
            case 1: goto L_0x0024;
            case 2: goto L_0x002f;
            case 3: goto L_0x0033;
            case 4: goto L_0x003b;
            case 5: goto L_0x003f;
            case 6: goto L_0x004b;
            case 7: goto L_0x0057;
            case 8: goto L_0x005b;
            case 9: goto L_0x005f;
            case 10: goto L_0x0063;
            case 11: goto L_0x0067;
            case 12: goto L_0x006d;
            default: goto L_0x0023;
        };
    L_0x0023:
        goto L_0x0000;
    L_0x0024:
        r0 = r0.f6025b;
        r0 = (com.facebook.common.quickcam.QuickCamPreviewHolder) r0;
        r3.m6368b(r0);
        goto L_0x0000;
    L_0x002c:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{  }
        throw r0;
    L_0x002f:
        r3.m6372n();
        goto L_0x0000;
    L_0x0033:
        r0 = r0.f6025b;
        r0 = (android.graphics.Point) r0;
        r3.m6359a(r0);
        goto L_0x0000;
    L_0x003b:
        r3.m6373o();
        goto L_0x0000;
    L_0x003f:
        r0 = r0.f6025b;
        r0 = (java.lang.Integer) r0;
        r0 = r0.intValue();
        r3.m6365b(r0);
        goto L_0x0000;
    L_0x004b:
        r0 = r0.f6025b;
        r0 = (java.lang.Integer) r0;
        r0 = r0.intValue();
        r3.m6369c(r0);
        goto L_0x0000;
    L_0x0057:
        r3.m6374p();
        goto L_0x0000;
    L_0x005b:
        r3.m6376r();
        goto L_0x0000;
    L_0x005f:
        r3.m6375q();
        goto L_0x0000;
    L_0x0063:
        r3.m6371m();
        goto L_0x0000;
    L_0x0067:
        r0 = r3.f6037d;
        r0.m6405c();
        goto L_0x0000;
    L_0x006d:
        r0 = r3.f6037d;
        r0.m6403b();
        goto L_0x0000;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.common.quickcam.QuickCamAsync.l(com.facebook.common.quickcam.QuickCamAsync):void");
    }

    private void m6368b(QuickCamPreviewHolder quickCamPreviewHolder) {
        if (this.f6046m == State.CLOSED) {
            try {
                this.f6037d.m6402a(quickCamPreviewHolder);
                this.f6044k = this.f6037d.m6410m();
                this.f6045l = this.f6037d.m6409j();
                this.f6046m = State.OPEN;
                this.f6047n = quickCamPreviewHolder;
                m6362a(NotifyEventType.OPEN);
            } catch (Throwable e) {
                m6364a(e);
            }
        }
    }

    private void m6371m() {
        m6375q();
        if (this.f6046m != State.CLOSED) {
            QuickCamCameraManager quickCamCameraManager = this.f6037d;
            if (quickCamCameraManager.f6064j != null) {
                quickCamCameraManager.f6064j.stopPreview();
                quickCamCameraManager.f6064j.release();
                quickCamCameraManager.f6064j = null;
            }
            this.f6047n = null;
            this.f6046m = State.CLOSED;
            m6362a(NotifyEventType.CLOSE);
        }
    }

    private void m6372n() {
        if (this.f6046m == State.OPEN) {
            try {
                this.f6037d.m6404b(this.f6047n);
                this.f6044k = this.f6037d.m6410m();
                this.f6045l = this.f6037d.m6409j();
                m6362a(NotifyEventType.FLIPPED_CAMERA);
            } catch (Throwable e) {
                m6364a(e);
            }
        }
    }

    private void m6359a(Point point) {
        if (this.f6046m != State.CLOSED) {
            FocusOverlayManager focusOverlayManager = this.f6037d.f6063i;
            if (focusOverlayManager != null && !this.f6037d.m6409j()) {
                focusOverlayManager.m6348b(point.x, point.y);
            }
        }
    }

    private void m6373o() {
        if (this.f6046m != State.CLOSED) {
            QuickCamCameraManager quickCamCameraManager = this.f6037d;
            quickCamCameraManager.f6064j.setOneShotPreviewCallback(new C06342(quickCamCameraManager, new C06302(this)));
        }
    }

    private void m6365b(int i) {
        if (this.f6046m != State.OPEN) {
            m6364a(new IllegalStateException("Requested starting recording when camera wasn't open."));
        } else if (this.f6038e.m6450a(this.f6047n, i, 0)) {
            this.f6046m = State.RECORDING;
            m6362a(NotifyEventType.STARTED_RECORDING);
        }
    }

    private void m6369c(int i) {
        if (this.f6046m != State.OPEN) {
            m6364a(new IllegalStateException("Requested starting recording when camera wasn't open."));
        } else if (this.f6038e.m6450a(this.f6047n, i, 1)) {
            this.f6046m = State.RECORDING;
            m6362a(NotifyEventType.STARTED_RECORDING);
        }
    }

    private void m6374p() {
        if (this.f6046m == State.RECORDING) {
            this.f6038e.m6449a();
        }
    }

    private void m6375q() {
        if (this.f6046m == State.RECORDING) {
            m6362a(NotifyEventType.STOPPING_RECORDING);
            this.f6038e.m6451b();
            this.f6037d.m6405c();
            this.f6046m = State.OPEN;
            m6363a(this, NotifyEventType.STOPPED_RECORDING, new RecordedVideoParams());
        }
    }

    private void m6376r() {
        if (this.f6046m == State.RECORDING) {
            m6362a(NotifyEventType.STOPPING_RECORDING);
            RecordedVideo c = this.f6038e.m6452c();
            this.f6037d.m6405c();
            this.f6046m = State.OPEN;
            if (c != null) {
                m6363a(this, NotifyEventType.STOPPED_RECORDING, new RecordedVideoParams(c.f6088a, c.f6089b, c.f6090c, this.f6037d.f6071q));
            }
        }
    }

    private void m6362a(NotifyEventType notifyEventType) {
        m6363a(this, notifyEventType, null);
    }

    private void m6364a(Throwable th) {
        m6363a(this, NotifyEventType.ERROR, th);
    }

    public static void m6363a(QuickCamAsync quickCamAsync, final NotifyEventType notifyEventType, final Object obj) {
        quickCamAsync.f6036c.b(new Runnable(quickCamAsync) {
            final /* synthetic */ QuickCamAsync f6021c;

            public void run() {
                QuickCamAsync.m6367b(this.f6021c, notifyEventType, obj);
            }
        });
    }

    public static void m6367b(QuickCamAsync quickCamAsync, NotifyEventType notifyEventType, Object obj) {
        quickCamAsync.f6036c.a();
        if (quickCamAsync.f6048o != null) {
            switch (notifyEventType) {
                case OPEN:
                    quickCamAsync.f6048o.mo688a();
                    return;
                case CLOSE:
                    quickCamAsync.f6048o.mo691b();
                    return;
                case FLIPPED_CAMERA:
                    quickCamAsync.f6048o.mo692c();
                    return;
                case TOOK_PICTURE:
                    PictureTakenParams pictureTakenParams = (PictureTakenParams) obj;
                    quickCamAsync.f6048o.mo690a(pictureTakenParams.f6026a, pictureTakenParams.f6027b, pictureTakenParams.f6028c, pictureTakenParams.f6029d);
                    return;
                case STARTED_RECORDING:
                    quickCamAsync.f6048o.mo693d();
                    return;
                case STOPPING_RECORDING:
                    quickCamAsync.f6048o.mo694e();
                    return;
                case STOPPED_RECORDING:
                    RecordedVideoParams recordedVideoParams = (RecordedVideoParams) obj;
                    quickCamAsync.f6048o.mo689a(recordedVideoParams.f6030a, recordedVideoParams.f6031b, recordedVideoParams.f6032c, recordedVideoParams.f6033d);
                    return;
                case ERROR:
                    quickCamAsync.f6048o.mo695f();
                    return;
                default:
                    return;
            }
        }
    }
}
