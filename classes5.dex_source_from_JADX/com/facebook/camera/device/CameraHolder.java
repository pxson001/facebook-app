package com.facebook.camera.device;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.res.Resources;
import android.hardware.Camera;
import android.hardware.Camera.CameraInfo;
import android.hardware.Camera.Parameters;
import android.hardware.Camera.PictureCallback;
import android.hardware.Camera.ShutterCallback;
import android.hardware.Camera.Size;
import android.media.AudioManager;
import android.media.CamcorderProfile;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.media.MediaRecorder;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Handler;
import android.provider.MediaStore.Video.Media;
import android.support.v7.widget.LinearLayoutCompat;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.view.View.OnTouchListener;
import com.facebook.camera.analytics.CameraFlowLogger;
import com.facebook.camera.device.CameraPreview.CreateSurfaceListener;
import com.facebook.camera.device.FocusManager.AutoFocusSource;
import com.facebook.camera.facetracking.FaceDetectionIndicatorView;
import com.facebook.camera.facetracking.FaceDetectionManager;
import com.facebook.camera.facetracking.FaceTracker;
import com.facebook.camera.gating.CameraGating;
import com.facebook.camera.utils.CameraHacks;
import com.facebook.camera.utils.Orientation;
import com.facebook.camera.views.RotateLayout;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.executors.DefaultAndroidThreadUtil;
import com.facebook.common.executors.FbAsyncTask;
import com.facebook.common.executors.FbHandlerThreadFactory;
import com.facebook.debug.log.BLog;
import com.facebook.mediastorage.MediaStorage;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.tools.dextr.runtime.detour.HandlerDetour;
import com.google.common.base.Preconditions;
import java.io.File;
import java.util.List;

/* compiled from: amount */
public class CameraHolder implements OnTouchListener {
    private static final Class<?> f10829b = CameraHolder.class;
    public boolean f10830A;
    public final CameraFlowLogger f10831B;
    private final CameraGating f10832C;
    public final DefaultAndroidThreadUtil f10833D;
    private int f10834E;
    private final FbHandlerThreadFactory f10835F;
    private final AbstractFbErrorReporter f10836G;
    private int f10837H;
    private int f10838I;
    private int f10839J;
    private int f10840K;
    private int f10841L;
    private int f10842M;
    private int f10843N;
    private int f10844O;
    private int f10845P;
    private int f10846Q;
    private int f10847R;
    private int f10848S;
    private final ShutterCallback f10849T;
    private final PictureCallback f10850U;
    public CameraListener f10851a;
    private Activity f10852c;
    public Camera f10853d;
    public CameraPreview f10854e;
    public final CameraFlash f10855f;
    public final Context f10856g;
    public final SurfaceCreatedListener f10857h;
    private MediaRecorder f10858i;
    public MediaStorage f10859j;
    public boolean f10860k;
    private ScaleGestureDetector f10861l;
    private PinchToZoom f10862m;
    public FocusManager f10863n;
    public FaceDetectionManager f10864o;
    private FaceTracker f10865p;
    private final AutoFocusCallback f10866q;
    public CameraLoader f10867r;
    public boolean f10868s;
    private String f10869t;
    private Uri f10870u;
    private ContentResolver f10871v;
    public int f10872w;
    public int f10873x;
    private boolean f10874y;
    private boolean f10875z;

    /* compiled from: amount */
    class C10531 implements ShutterCallback {
        final /* synthetic */ CameraHolder f10808a;

        C10531(CameraHolder cameraHolder) {
            this.f10808a = cameraHolder;
        }

        public void onShutter() {
            this.f10808a.f10833D.a();
            this.f10808a.f10851a.mo1169b();
            if (this.f10808a.f10830A) {
                this.f10808a.m18933o();
            }
        }
    }

    /* compiled from: amount */
    class C10542 implements PictureCallback {
        final /* synthetic */ CameraHolder f10809a;

        C10542(CameraHolder cameraHolder) {
            this.f10809a = cameraHolder;
        }

        public void onPictureTaken(byte[] bArr, Camera camera) {
            this.f10809a.f10833D.a();
            if (bArr == null || bArr.length == 0) {
                CameraHolder.m18909H(this.f10809a);
                CameraHolder.m18906D(this.f10809a);
                return;
            }
            this.f10809a.f10851a.mo1168a(bArr, CameraHolder.m18904A(this.f10809a));
            this.f10809a.f10833D.a(new HandleMediaTask(this.f10809a, bArr), new Void[0]);
        }
    }

    /* compiled from: amount */
    final class AutoFocusCallback implements android.hardware.Camera.AutoFocusCallback {
        final /* synthetic */ CameraHolder f10818a;

        public AutoFocusCallback(CameraHolder cameraHolder) {
            this.f10818a = cameraHolder;
        }

        public final void onAutoFocus(boolean z, Camera camera) {
            if (this.f10818a.f10863n != null) {
                this.f10818a.f10863n.m18955a(z);
            }
        }
    }

    /* compiled from: amount */
    public interface CameraListener {
        void C_(int i);

        void mo1162a();

        void mo1163a(Uri uri);

        void mo1164a(CameraPreview cameraPreview);

        void mo1165a(AutoFocusSource autoFocusSource);

        void mo1166a(List<Size> list, List<Size> list2, PreviewAndPictureSize previewAndPictureSize);

        void mo1167a(boolean z);

        void mo1168a(byte[] bArr, int i);

        void mo1169b();

        void mo1170b(Uri uri);

        void mo1171b(boolean z);

        RotateLayout mo1172c();

        void mo1173c(Uri uri);

        int mo1174d();

        Orientation mo1175e();

        Orientation mo1176f();

        int mo1177g();

        FaceDetectionIndicatorView mo1178h();
    }

    /* compiled from: amount */
    public class CameraLoader {
        final /* synthetic */ CameraHolder f10820a;
        private int f10821b = 1000;
        private int f10822c = 0;

        /* compiled from: amount */
        class C10571 implements Runnable {
            final /* synthetic */ CameraLoader f10819a;

            C10571(CameraLoader cameraLoader) {
                this.f10819a = cameraLoader;
            }

            public void run() {
                if (this.f10819a.f10820a.f10867r != null) {
                    this.f10819a.m18898a();
                }
            }
        }

        public CameraLoader(CameraHolder cameraHolder) {
            this.f10820a = cameraHolder;
        }

        protected final void m18898a() {
            this.f10820a.f10833D.a();
            this.f10820a.f10831B.mo1154c();
            this.f10820a.f10853d = CameraHolder.m18912a(this.f10820a, this.f10820a.f10873x);
            if (this.f10820a.f10853d != null) {
                Object obj;
                Parameters parameters = this.f10820a.f10853d.getParameters();
                if (parameters == null || parameters.getSupportedPreviewSizes() == null) {
                    obj = null;
                } else {
                    obj = 1;
                }
                if (obj != null) {
                    CameraHolder.m18908G(this.f10820a);
                    this.f10820a.f10867r = null;
                    this.f10820a.f10831B.mo1155d();
                    return;
                }
            }
            if (this.f10820a.f10853d != null) {
                this.f10820a.f10853d.release();
                this.f10820a.f10853d = null;
            }
            int i = this.f10822c;
            this.f10822c = i + 1;
            if (i > 3) {
                this.f10820a.f10831B.mo1147a("CameraLoader failed 3 times", new Exception("getCameraInstance failed"));
                this.f10820a.f10851a.mo1167a(false);
                return;
            }
            new StringBuilder("failed at: ").append(this.f10822c);
            HandlerDetour.b(new Handler(), new C10571(this), (long) this.f10821b, 961031273);
        }
    }

    /* compiled from: amount */
    class HandleMediaTask extends FbAsyncTask<Void, Void, Uri> {
        byte[] f10823a;
        final /* synthetic */ CameraHolder f10824b;

        protected void onPostExecute(Object obj) {
            Uri uri = (Uri) obj;
            this.f10824b.f10833D.a();
            this.f10824b.f10851a.mo1173c(uri);
        }

        public HandleMediaTask(CameraHolder cameraHolder, byte[] bArr) {
            this.f10824b = cameraHolder;
            this.f10823a = bArr;
        }

        protected final Object m18899a(Object[] objArr) {
            this.f10824b.f10833D.b();
            Uri a = this.f10824b.f10859j.a(this.f10823a);
            this.f10824b.f10851a.mo1170b(a);
            return a;
        }
    }

    /* compiled from: amount */
    public class PreviewAndPictureSize {
        public Size f10825a;
        public Size f10826b;
        final /* synthetic */ CameraHolder f10827c;

        public PreviewAndPictureSize(CameraHolder cameraHolder) {
            this.f10827c = cameraHolder;
        }
    }

    /* compiled from: amount */
    class SurfaceCreatedListener extends CreateSurfaceListener {
        final /* synthetic */ CameraHolder f10828a;

        public SurfaceCreatedListener(CameraHolder cameraHolder) {
            this.f10828a = cameraHolder;
        }

        public final void mo1158a(boolean z) {
            if (z) {
                CameraHolder.m18907E(this.f10828a);
                return;
            }
            CameraHolder cameraHolder = this.f10828a;
            cameraHolder.f10833D.a();
            cameraHolder.f10851a.mo1167a(false);
        }

        public final void mo1157a() {
            this.f10828a.f10868s = false;
        }
    }

    public CameraHolder(CameraListener cameraListener, Context context, FbSharedPreferences fbSharedPreferences, CameraFlowLogger cameraFlowLogger, MediaStorage mediaStorage, CameraGating cameraGating, DefaultAndroidThreadUtil defaultAndroidThreadUtil, FbHandlerThreadFactory fbHandlerThreadFactory, AbstractFbErrorReporter abstractFbErrorReporter) {
        this(cameraListener, context, fbSharedPreferences, cameraFlowLogger, mediaStorage, cameraGating, defaultAndroidThreadUtil, fbHandlerThreadFactory, abstractFbErrorReporter, 1, 600000, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1);
    }

    public CameraHolder(CameraListener cameraListener, Context context, FbSharedPreferences fbSharedPreferences, CameraFlowLogger cameraFlowLogger, MediaStorage mediaStorage, CameraGating cameraGating, DefaultAndroidThreadUtil defaultAndroidThreadUtil, FbHandlerThreadFactory fbHandlerThreadFactory, AbstractFbErrorReporter abstractFbErrorReporter, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11, int i12) {
        this.f10857h = new SurfaceCreatedListener(this);
        this.f10864o = null;
        this.f10865p = null;
        this.f10866q = new AutoFocusCallback(this);
        this.f10868s = false;
        this.f10872w = -1;
        this.f10874y = false;
        this.f10834E = -1;
        this.f10849T = new C10531(this);
        this.f10850U = new C10542(this);
        this.f10851a = cameraListener;
        this.f10831B = cameraFlowLogger;
        this.f10832C = cameraGating;
        this.f10833D = defaultAndroidThreadUtil;
        this.f10855f = new CameraFlash(fbSharedPreferences, this.f10831B, this);
        this.f10856g = (Context) Preconditions.checkNotNull(context);
        this.f10871v = this.f10856g.getContentResolver();
        this.f10859j = mediaStorage;
        this.f10835F = fbHandlerThreadFactory;
        this.f10836G = abstractFbErrorReporter;
        this.f10837H = i;
        if (i2 == -1) {
            i2 = 600000;
        }
        this.f10838I = i2;
        this.f10839J = i3;
        this.f10840K = i4;
        this.f10841L = i5;
        this.f10842M = i6;
        this.f10843N = i7;
        this.f10844O = i8;
        this.f10845P = i9;
        this.f10846Q = i10;
        this.f10847R = i11;
        this.f10848S = i12;
        this.f10834E = -1;
    }

    public final boolean m18922b() {
        return this.f10872w > 1;
    }

    public final int m18923c() {
        if (m18922b()) {
            m18909H(this);
            this.f10873x = (this.f10873x + 1) % this.f10872w;
            this.f10874y = true;
            this.f10834E = this.f10873x;
            m18906D(this);
            return this.f10873x;
        }
        throw new IllegalStateException("Camera toggled without proper support from API");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    @android.annotation.TargetApi(9)
    public final void m18924e() {
        /*
        r7 = this;
        r0 = 0;
        r7.f10874y = r0;
        r1 = android.hardware.Camera.getNumberOfCameras();
        r7.f10872w = r1;
        r1 = r7.f10834E;
        if (r1 < 0) goto L_0x0056;
    L_0x000d:
        r1 = r7.f10834E;
        r2 = r7.f10872w;
        if (r1 >= r2) goto L_0x0056;
    L_0x0013:
        r1 = r7.f10834E;
        r7.f10873x = r1;
    L_0x0017:
        r1 = r7.f10832C;
        r3 = r1.f10961a;
        r3 = r3.get();
        r3 = (java.lang.Boolean) r3;
        r3 = r3.booleanValue();
        r1 = r3;
        r7.f10875z = r1;
        r1 = r7.f10875z;
        if (r1 != 0) goto L_0x0052;
    L_0x002c:
        r1 = r7.f10832C;
        r3 = r1.f10962b;
        r3 = r3.get();
        r3 = (com.facebook.common.util.TriState) r3;
        r4 = android.os.Build.MODEL;
        r5 = "GT-S5830";
        r4 = r4.startsWith(r5);
        if (r4 != 0) goto L_0x004a;
    L_0x0040:
        r4 = android.os.Build.MODEL;
        r5 = "GT-S5363";
        r4 = r4.startsWith(r5);
        if (r4 == 0) goto L_0x0076;
    L_0x004a:
        r4 = 1;
    L_0x004b:
        r3 = r3.asBoolean(r4);
        r1 = r3;
        if (r1 == 0) goto L_0x0053;
    L_0x0052:
        r0 = 1;
    L_0x0053:
        r7.f10830A = r0;
        return;
    L_0x0056:
        r1 = r7.m18922b();
        if (r1 == 0) goto L_0x0017;
    L_0x005c:
        r4 = new android.hardware.Camera$CameraInfo;
        r4.<init>();
        r3 = 0;
    L_0x0062:
        r5 = r7.f10872w;
        if (r3 >= r5) goto L_0x0075;
    L_0x0066:
        android.hardware.Camera.getCameraInfo(r3, r4);
        r5 = r4.facing;
        r6 = r7.f10851a;
        r6 = r6.mo1174d();
        if (r5 != r6) goto L_0x0078;
    L_0x0073:
        r7.f10873x = r3;
    L_0x0075:
        goto L_0x0017;
    L_0x0076:
        r4 = 0;
        goto L_0x004b;
    L_0x0078:
        r3 = r3 + 1;
        goto L_0x0062;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.camera.device.CameraHolder.e():void");
    }

    public final void m18925g() {
        m18917y();
        if (this.f10858i == null) {
            BLog.b(f10829b, "Fail to initialize media recorder");
        } else if (this.f10869t == null) {
            BLog.b(f10829b, "Invalid video output file name");
            m18918z();
        } else {
            try {
                this.f10858i.start();
                this.f10860k = true;
            } catch (Exception e) {
                this.f10831B.mo1147a("start MediaRecorder failed", e);
                m18915w();
                m18918z();
                m18909H(this);
                m18906D(this);
            }
        }
    }

    public final void m18926h() {
        m18914v();
        m18915w();
        m18918z();
        m18909H(this);
    }

    public final void m18927i() {
        m18914v();
        m18916x();
        m18918z();
        this.f10851a.mo1163a(this.f10870u);
    }

    public final void m18919a(Activity activity) {
        this.f10852c = activity;
        m18913u();
    }

    private void m18913u() {
        int i = 0;
        if (this.f10852c != null && this.f10853d != null) {
            CameraInfo cameraInfo = new CameraInfo();
            try {
                Camera.getCameraInfo(this.f10873x, cameraInfo);
                switch (this.f10852c.getWindowManager().getDefaultDisplay().getRotation()) {
                    case 1:
                        i = 90;
                        break;
                    case LinearLayoutCompat.SHOW_DIVIDER_MIDDLE /*2*/:
                        i = 180;
                        break;
                    case 3:
                        i = 270;
                        break;
                }
                if (cameraInfo.facing == 1) {
                    i = (360 - ((i + cameraInfo.orientation) % 360)) % 360;
                } else {
                    i = ((cameraInfo.orientation - i) + 360) % 360;
                }
                this.f10853d.setDisplayOrientation(i);
            } catch (Exception e) {
            }
        }
    }

    private void m18914v() {
        this.f10860k = false;
        try {
            this.f10858i.stop();
        } catch (Exception e) {
            this.f10831B.mo1147a("stop MediaRecorder failed", e);
        }
    }

    private void m18915w() {
        if (this.f10869t != null) {
            if (!new File(this.f10869t).delete()) {
                new StringBuilder("Could not delete ").append(this.f10869t);
            }
            this.f10869t = null;
        }
    }

    private void m18916x() {
        if (this.f10869t != null) {
            String str;
            long currentTimeMillis = System.currentTimeMillis();
            ContentValues contentValues = new ContentValues(2);
            contentValues.put("datetaken", Long.valueOf(currentTimeMillis));
            switch (this.f10839J) {
                case LinearLayoutCompat.SHOW_DIVIDER_MIDDLE /*2*/:
                    str = "video/mp4";
                    break;
                case 3:
                    str = "video/mp4v-es";
                    break;
                default:
                    str = "video/3gpp";
                    break;
            }
            contentValues.put("mime_type", str);
            contentValues.put("_data", this.f10869t);
            contentValues.put("_size", Long.valueOf(new File(this.f10869t).length()));
            try {
                this.f10870u = this.f10871v.insert(Media.EXTERNAL_CONTENT_URI, contentValues);
            } catch (Exception e) {
                this.f10870u = null;
                this.f10831B.mo1147a("save video file failed", e);
            } finally {
                new StringBuilder("Current video URI: ").append(this.f10870u);
            }
        }
    }

    @TargetApi(9)
    private void m18917y() {
        if (MediaStorage.b()) {
            String str;
            this.f10858i = new MediaRecorder();
            try {
                this.f10853d.stopPreview();
            } catch (Exception e) {
                this.f10831B.mo1147a("initializeRecorder/stopPreview failed", e);
            }
            try {
                this.f10853d.unlock();
            } catch (Exception e2) {
                this.f10831B.mo1147a("initializeRecorder/unlock failed", e2);
            }
            this.f10858i.setCamera(this.f10853d);
            this.f10858i.setAudioSource(5);
            this.f10858i.setVideoSource(1);
            try {
                CamcorderProfile camcorderProfile = CamcorderProfile.get(this.f10873x, this.f10837H);
                camcorderProfile.duration = this.f10838I != -1 ? this.f10838I : camcorderProfile.duration;
                camcorderProfile.fileFormat = this.f10839J != -1 ? this.f10839J : camcorderProfile.fileFormat;
                this.f10839J = camcorderProfile.fileFormat;
                camcorderProfile.videoCodec = this.f10840K != -1 ? this.f10840K : camcorderProfile.videoCodec;
                if (!(this.f10841L == -1 || this.f10842M == -1)) {
                    camcorderProfile.videoFrameWidth = this.f10841L;
                    camcorderProfile.videoFrameHeight = this.f10842M;
                }
                camcorderProfile.videoFrameRate = this.f10843N != -1 ? this.f10843N : camcorderProfile.videoFrameRate;
                camcorderProfile.videoBitRate = this.f10844O != -1 ? this.f10844O : camcorderProfile.videoBitRate;
                camcorderProfile.audioCodec = this.f10845P != -1 ? this.f10845P : camcorderProfile.audioCodec;
                camcorderProfile.audioSampleRate = this.f10846Q != -1 ? this.f10846Q : camcorderProfile.audioSampleRate;
                camcorderProfile.audioBitRate = this.f10847R != -1 ? this.f10847R : camcorderProfile.audioBitRate;
                camcorderProfile.audioChannels = this.f10848S != -1 ? this.f10848S : camcorderProfile.audioChannels;
                this.f10858i.setProfile(camcorderProfile);
                this.f10858i.setOrientationHint(m18904A(this));
            } catch (Exception e22) {
                this.f10831B.mo1147a("Setup MediaRecorder failed", e22);
                this.f10858i.reset();
                this.f10858i.setCamera(this.f10853d);
                this.f10858i.setAudioSource(5);
                this.f10858i.setVideoSource(1);
                this.f10858i.setProfile(CamcorderProfile.get(this.f10873x, 1));
                this.f10858i.setMaxDuration(600000);
            }
            this.f10858i.setPreviewDisplay(this.f10854e.getSurface());
            switch (this.f10839J) {
                case 1:
                    str = ".3gp";
                    break;
                case LinearLayoutCompat.SHOW_DIVIDER_MIDDLE /*2*/:
                    str = ".mp4";
                    break;
                default:
                    str = ".3gp";
                    break;
            }
            this.f10869t = this.f10859j.a(str).getPath();
            this.f10858i.setOutputFile(this.f10869t);
            try {
                this.f10858i.prepare();
                return;
            } catch (Exception e222) {
                this.f10831B.mo1147a("prepare MediaRecorder failed for " + this.f10869t, e222);
                m18915w();
                m18918z();
                return;
            }
        }
        BLog.b(f10829b, "prepare failed - external storage is not writable");
    }

    private void m18918z() {
        if (this.f10858i != null) {
            this.f10858i.reset();
            this.f10858i.release();
            this.f10858i = null;
        }
        if (this.f10853d != null) {
            try {
                this.f10853d.reconnect();
            } catch (Exception e) {
                this.f10831B.mo1147a("initializeRecorder/reconnect failed", e);
            }
        }
    }

    public final void m18928j() {
        m18909H(this);
        m18906D(this);
    }

    public final boolean m18929k() {
        this.f10868s = true;
        if (this.f10853d != null) {
            try {
                this.f10853d.startPreview();
                this.f10863n.m18961f();
            } catch (Exception e) {
                this.f10831B.mo1147a("onResumePreview/startPreview failed", e);
                this.f10868s = false;
            }
        }
        if (!this.f10868s) {
            m18909H(this);
            m18906D(this);
        }
        return this.f10868s;
    }

    public final void m18930l() {
        if (this.f10851a.mo1178h() != null) {
            this.f10851a.mo1178h().m18966a();
        }
        if (this.f10860k) {
            m18927i();
            m18918z();
        }
        m18909H(this);
    }

    @TargetApi(9)
    public static int m18904A(CameraHolder cameraHolder) {
        if (cameraHolder.f10853d == null) {
            return 0;
        }
        Orientation e = cameraHolder.f10851a.mo1175e();
        int g = cameraHolder.f10851a.mo1177g();
        CameraInfo cameraInfo = new CameraInfo();
        Camera.getCameraInfo(cameraHolder.f10873x, cameraInfo);
        if (CameraHacks.f10976a) {
            if (cameraInfo.facing == 1) {
                g = cameraInfo.orientation + e.mRotation;
                g = (e == Orientation.PORTRAIT || e == Orientation.REVERSE_PORTRAIT) ? g + 90 : g - 90;
            } else {
                g = cameraInfo.orientation - e.mRotation;
            }
        } else if (cameraInfo.facing == 1) {
            g += cameraInfo.orientation + e.mRotation;
            if ((e == Orientation.PORTRAIT || e == Orientation.REVERSE_PORTRAIT) && ((Boolean) cameraHolder.f10832C.f10964d.get()).booleanValue()) {
                g += 180;
            }
        } else {
            g = (cameraInfo.orientation - e.mRotation) - g;
        }
        return (g + 360) % 360;
    }

    @TargetApi(9)
    private int m18905B() {
        CameraInfo cameraInfo = new CameraInfo();
        Camera.getCameraInfo(this.f10873x, cameraInfo);
        return cameraInfo.facing;
    }

    public final OnTouchListener m18931m() {
        return this.f10855f;
    }

    public final boolean m18932n() {
        return this.f10855f.m18880a();
    }

    @TargetApi(9)
    public static Camera m18912a(CameraHolder cameraHolder, int i) {
        Object obj = null;
        if (cameraHolder.f10853d != null) {
            return cameraHolder.f10853d;
        }
        if (cameraHolder.f10856g.getPackageManager().hasSystemFeature("android.hardware.camera") || cameraHolder.f10856g.getPackageManager().hasSystemFeature("android.hardware.camera.front")) {
            obj = 1;
        }
        if (obj == null) {
            return null;
        }
        try {
            if (cameraHolder.m18922b()) {
                return Camera.open(i);
            }
            return Camera.open(0);
        } catch (Exception e) {
            return null;
        }
    }

    public static void m18906D(CameraHolder cameraHolder) {
        if (cameraHolder.f10853d != null) {
            throw new IllegalStateException("Tried to load camera, even though we already have one");
        }
        cameraHolder.f10831B.mo1138a(cameraHolder.f10873x, cameraHolder.f10874y);
        if (cameraHolder.f10867r == null) {
            cameraHolder.f10867r = new CameraLoader(cameraHolder);
        }
        cameraHolder.f10867r.m18898a();
    }

    public static void m18907E(CameraHolder cameraHolder) {
        cameraHolder.f10833D.a();
        cameraHolder.f10868s = true;
        cameraHolder.f10851a.mo1167a(true);
        cameraHolder.f10851a.mo1171b(cameraHolder.f10855f.m18880a());
        if (!cameraHolder.f10853d.getParameters().isZoomSupported()) {
            return;
        }
        if (!CameraHacks.f10976a || cameraHolder.m18905B() != 1) {
            cameraHolder.f10862m = new PinchToZoom(cameraHolder.f10853d, cameraHolder.f10831B);
            cameraHolder.f10861l = new ScaleGestureDetector(cameraHolder.f10856g, cameraHolder.f10862m);
        }
    }

    public static void m18908G(CameraHolder cameraHolder) {
        String[] strArr;
        Preconditions.checkNotNull(cameraHolder.f10853d);
        cameraHolder.f10833D.a();
        cameraHolder.f10855f.m18879a(cameraHolder.f10853d);
        cameraHolder.f10851a.C_(((Integer) CameraFlash.f10799a.get(cameraHolder.f10855f.f10805g)).intValue());
        Parameters parameters = cameraHolder.f10853d.getParameters();
        List supportedFocusModes = parameters.getSupportedFocusModes();
        if (supportedFocusModes != null) {
            strArr = new String[supportedFocusModes.size()];
        } else {
            strArr = new String[0];
        }
        if (supportedFocusModes != null) {
            supportedFocusModes.toArray(strArr);
        }
        cameraHolder.f10863n = new FocusManager(strArr, cameraHolder.f10831B);
        if (FocusManager.m18944a(parameters) && ((Boolean) cameraHolder.f10832C.f10963c.get()).booleanValue()) {
            cameraHolder.f10864o = new FaceDetectionManager(cameraHolder.f10853d, cameraHolder.f10836G);
            cameraHolder.f10865p = new FaceTracker(cameraHolder.f10864o, cameraHolder.f10835F);
            FaceTracker faceTracker = cameraHolder.f10865p;
            FocusManager focusManager = cameraHolder.f10863n;
            if (focusManager != null) {
                faceTracker.f10941b.add(focusManager);
            }
        } else {
            cameraHolder.f10864o = null;
        }
        cameraHolder.f10833D.a();
        cameraHolder.f10854e = new CameraPreview(cameraHolder.f10856g, cameraHolder.f10853d, cameraHolder.f10863n, cameraHolder.f10864o, cameraHolder.f10831B);
        cameraHolder.f10854e.f10879d = cameraHolder.f10857h;
        cameraHolder.f10854e.setOnTouchListener(cameraHolder);
        cameraHolder.f10851a.mo1164a(cameraHolder.f10854e);
        CameraPreview cameraPreview = cameraHolder.f10854e;
        cameraHolder.m18910I();
        cameraHolder.m18911J();
        if (cameraHolder.f10864o != null) {
            Object obj = cameraHolder.f10864o;
            boolean z = false;
            if (obj.f10932b.getParameters().getMaxNumDetectedFaces() <= 0) {
                obj.f10935e = false;
            } else if (obj.f10935e) {
                obj.f10932b.setFaceDetectionListener(obj);
                z = true;
            } else {
                obj.f10935e = false;
            }
            if (z) {
                cameraHolder.f10864o.f10934d = cameraHolder.m18905B();
            }
        }
        cameraHolder.m18913u();
    }

    @TargetApi(14)
    public static void m18909H(CameraHolder cameraHolder) {
        cameraHolder.f10833D.a();
        cameraHolder.f10868s = false;
        if (cameraHolder.f10855f != null) {
            cameraHolder.f10855f.m18879a(null);
        }
        cameraHolder.f10867r = null;
        if (cameraHolder.f10858i != null) {
            if (cameraHolder.f10860k) {
                cameraHolder.f10858i.stop();
            }
            cameraHolder.f10858i.reset();
            cameraHolder.f10858i.release();
            cameraHolder.f10858i = null;
        }
        if (cameraHolder.f10851a.mo1178h() != null) {
            cameraHolder.f10851a.mo1178h().m18966a();
        }
        if (cameraHolder.f10865p != null) {
            cameraHolder.f10865p.m18978b(cameraHolder.f10851a.mo1178h());
            cameraHolder.f10865p.m18978b(cameraHolder.f10863n);
            cameraHolder.f10865p.m18977a();
            cameraHolder.f10865p = null;
        }
        if (cameraHolder.f10864o != null) {
            if (cameraHolder.f10853d != null) {
                try {
                    cameraHolder.f10853d.setFaceDetectionListener(null);
                } catch (Exception e) {
                    cameraHolder.f10831B.mo1147a("releaseCamera/setFaceDetectionListener failed", e);
                }
            }
            cameraHolder.f10864o = null;
        }
        if (cameraHolder.f10863n != null) {
            cameraHolder.f10863n.m18960e();
            cameraHolder.f10863n = null;
        }
        if (cameraHolder.f10854e != null) {
            cameraHolder.f10854e.m18937a();
            cameraHolder.f10854e = null;
        }
        if (cameraHolder.f10853d != null) {
            try {
                cameraHolder.f10853d.stopPreview();
            } catch (Exception e2) {
                cameraHolder.f10831B.mo1147a("releaseCamera/stopPreview failed", e2);
            }
            try {
                cameraHolder.f10853d.release();
            } catch (Exception e22) {
                cameraHolder.f10831B.mo1147a("releaseCamera/release failed", e22);
            }
            cameraHolder.f10853d = null;
        }
        cameraHolder.f10831B.mo1156e();
        cameraHolder.f10861l = null;
        cameraHolder.f10862m = null;
        cameraHolder.f10851a.mo1162a();
    }

    private void m18910I() {
        boolean z = true;
        FocusManager focusManager = this.f10863n;
        Camera camera = this.f10853d;
        focusManager.f10907u = camera;
        Parameters parameters = camera.getParameters();
        focusManager.f10891e = FocusManager.m18945a("auto", parameters.getSupportedFocusModes());
        focusManager.f10892f = FocusManager.m18944a(parameters);
        if (focusManager.f10892f) {
            focusManager.f10909w = parameters.getMaxNumFocusAreas();
            focusManager.f10910x = parameters.getMaxNumMeteringAreas();
        }
        focusManager = this.f10863n;
        View c = this.f10851a.mo1172c();
        View view = this.f10854e;
        if (m18905B() != 1) {
            z = false;
        }
        focusManager.m18953a(c, view, this, z, this.f10851a.mo1176f().mReverseRotation);
    }

    private void m18911J() {
        Parameters parameters = this.f10853d.getParameters();
        PreviewAndPictureSize previewAndPictureSize = new PreviewAndPictureSize(this);
        this.f10851a.mo1166a(parameters.getSupportedPreviewSizes(), parameters.getSupportedPictureSizes(), previewAndPictureSize);
        if (previewAndPictureSize.f10826b != null) {
            parameters.setPictureSize(previewAndPictureSize.f10826b.width, previewAndPictureSize.f10826b.height);
        }
        parameters.setJpegQuality(85);
        if (previewAndPictureSize.f10825a != null) {
            parameters.setPreviewSize(previewAndPictureSize.f10825a.width, previewAndPictureSize.f10825a.height);
        }
        try {
            this.f10853d.setParameters(parameters);
        } catch (Exception e) {
            this.f10831B.mo1147a("initCameraSettings/setParameters failed", e);
        }
        try {
            if (CameraHacks.m18991c()) {
                this.f10853d.setDisplayOrientation(this.f10851a.mo1176f().mReverseRotation + 180);
            } else {
                this.f10853d.setDisplayOrientation(this.f10851a.mo1176f().mReverseRotation);
            }
        } catch (Exception e2) {
            this.f10831B.mo1147a("initCameraSettings/setDisplayOrientation failed", e2);
        }
    }

    public final void m18933o() {
        final AudioManager audioManager = (AudioManager) this.f10856g.getSystemService("audio");
        final int i = this.f10875z ? 4 : 1;
        final int streamVolume = audioManager.getStreamVolume(i);
        if (this.f10875z) {
            audioManager.setStreamVolume(i, audioManager.getStreamMaxVolume(i), 0);
        }
        Resources resources = this.f10856g.getResources();
        Uri build = new Builder().scheme("android.resource").authority(resources.getResourcePackageName(2131165192)).appendPath(resources.getResourceTypeName(2131165192)).appendPath(resources.getResourceEntryName(2131165192)).build();
        MediaPlayer mediaPlayer = new MediaPlayer();
        mediaPlayer.setAudioStreamType(i);
        try {
            mediaPlayer.setDataSource(this.f10856g, build);
            mediaPlayer.prepare();
            mediaPlayer.setOnErrorListener(new OnErrorListener(this) {
                final /* synthetic */ CameraHolder f10813d;

                public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                    mediaPlayer.release();
                    audioManager.setStreamVolume(i, streamVolume, 0);
                    return false;
                }
            });
            mediaPlayer.setOnCompletionListener(new OnCompletionListener(this) {
                final /* synthetic */ CameraHolder f10817d;

                public void onCompletion(MediaPlayer mediaPlayer) {
                    mediaPlayer.release();
                    audioManager.setStreamVolume(i, streamVolume, 0);
                }
            });
            mediaPlayer.start();
        } catch (Exception e) {
            audioManager.setStreamVolume(i, streamVolume, 0);
            this.f10831B.mo1147a("playShutterSound media player error", e);
        }
    }

    public final boolean m18934q() {
        this.f10868s = false;
        Parameters parameters = this.f10853d.getParameters();
        parameters.setRotation(m18904A(this));
        try {
            this.f10853d.setParameters(parameters);
        } catch (Exception e) {
            this.f10831B.mo1147a("capture/setParameters failed", e);
        }
        try {
            this.f10853d.takePicture(this.f10849T, null, this.f10850U);
        } catch (Exception e2) {
            this.f10831B.mo1147a("capture/takePicture failed", e2);
        }
        return true;
    }

    public final void m18920a(AutoFocusSource autoFocusSource) {
        this.f10833D.a();
        try {
            this.f10853d.autoFocus(this.f10866q);
            this.f10851a.mo1165a(autoFocusSource);
        } catch (Exception e) {
            this.f10831B.mo1147a("autoFocus failed", e);
            this.f10866q.onAutoFocus(false, this.f10853d);
        }
    }

    public final void m18935r() {
        this.f10833D.a();
        if (this.f10853d != null) {
            try {
                this.f10853d.cancelAutoFocus();
            } catch (Exception e) {
                this.f10831B.mo1147a("cancelAutoFocus failed", e);
            }
        }
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (!this.f10868s) {
            return false;
        }
        if (this.f10861l != null) {
            if (motionEvent.getAction() == 0) {
                this.f10862m.f10920h = false;
                this.f10863n.m18956a(motionEvent);
            }
            boolean onTouchEvent = this.f10861l.onTouchEvent(motionEvent);
            if (motionEvent.getAction() != 1 || this.f10862m.f10920h) {
                return onTouchEvent;
            }
            this.f10863n.m18956a(motionEvent);
            return onTouchEvent;
        } else if (this.f10863n != null) {
            return this.f10863n.m18956a(motionEvent);
        } else {
            return false;
        }
    }

    public final boolean m18921a() {
        if (this.f10868s) {
            FocusManager focusManager = this.f10863n;
            Object obj = 1;
            if (!(focusManager.f10889c == 1 || focusManager.f10889c == 2)) {
                obj = null;
            }
            if (obj == null) {
                return true;
            }
        }
        return false;
    }
}
