package com.facebook.facecast;

import android.annotation.TargetApi;
import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;
import com.facebook.facecast.plugin.FacecastPreviewPlugin.EncoderSurfaceType;
import com.facebook.video.videostreaming.DisplayListenerDelegate;
import com.facebook.video.videostreaming.RecordingListenerDelegate;
import com.facebook.video.videostreaming.opengl.EglCore;
import com.facebook.video.videostreaming.opengl.EglSurfaceBase;
import com.facebook.video.videostreaming.opengl.FullFrameRect;
import com.facebook.video.videostreaming.opengl.WindowSurface;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import javax.annotation.Nullable;

@TargetApi(18)
/* compiled from: broadcaster_id */
public class PreviewRenderer2 extends PreviewRenderer implements Callback {
    private static final String f18106a = PreviewRenderer.class.getName();
    private volatile PreviewRendererHandler f18107b;
    private final WeakReference<SurfaceView> f18108c;
    public int f18109d = -1;
    private final Handler f18110e;
    private final ScreenCaptureUtil f18111f;
    public SurfaceTexture f18112g;
    private final float[] f18113h = new float[16];
    public int f18114i = -1;
    public int f18115j = -1;
    public int f18116k;
    public WeakReference<DisplayListenerDelegate> f18117l;
    public final EncoderSurface2 f18118m = new EncoderSurface2();
    public final EncoderSurface2 f18119n = new EncoderSurface2();
    private volatile Surface f18120o;
    public WindowSurface f18121p;
    public FullFrameRect f18122q;
    public EglCore f18123r;
    public volatile boolean f18124s;
    private final Object f18125t;
    private volatile boolean f18126u = false;
    private volatile boolean f18127v = false;
    private ByteBuffer f18128w;
    private String f18129x;

    /* compiled from: broadcaster_id */
    class PreviewRendererHandler extends Handler {
        final /* synthetic */ PreviewRenderer2 f18075a;

        PreviewRendererHandler(PreviewRenderer2 previewRenderer2, Looper looper) {
            this.f18075a = previewRenderer2;
            super(looper);
        }

        public void handleMessage(Message message) {
            int i = message.what;
            PreviewRenderer2 previewRenderer2;
            switch (i) {
                case 1:
                    PreviewRenderer2.m21932f(this.f18075a);
                    return;
                case 2:
                    previewRenderer2 = this.f18075a;
                    return;
                case 3:
                    previewRenderer2 = this.f18075a;
                    return;
                case 4:
                    previewRenderer2 = this.f18075a;
                    int i2 = message.arg1;
                    int i3 = message.arg2;
                    Integer.valueOf(i2);
                    Integer.valueOf(i3);
                    if (previewRenderer2.f18114i == i2 && previewRenderer2.f18115j == i3) {
                        Integer.valueOf(i2);
                        Integer.valueOf(i3);
                    } else {
                        previewRenderer2.f18114i = i2;
                        previewRenderer2.f18115j = i3;
                        if (previewRenderer2.f18124s) {
                            previewRenderer2.f18122q.a(previewRenderer2.f18114i, previewRenderer2.f18115j, previewRenderer2.f18116k, 1.0f);
                        }
                    }
                    return;
                case 5:
                    PreviewRenderer2.m21930a(this.f18075a, message.arg1);
                    return;
                case 6:
                    DisplayListenerDelegate displayListenerDelegate;
                    previewRenderer2 = this.f18075a;
                    if (previewRenderer2.f18121p != null) {
                        previewRenderer2.f18121p.b();
                        previewRenderer2.f18121p.d();
                        previewRenderer2.f18121p = null;
                    }
                    previewRenderer2.f18118m.m21756d();
                    previewRenderer2.f18119n.m21756d();
                    if (previewRenderer2.f18112g != null) {
                        previewRenderer2.f18112g.release();
                        previewRenderer2.f18112g = null;
                    }
                    if (previewRenderer2.f18122q != null) {
                        previewRenderer2.f18122q.a(false);
                        previewRenderer2.f18122q = null;
                    }
                    if (previewRenderer2.f18123r != null) {
                        previewRenderer2.f18123r.a();
                        previewRenderer2.f18123r = null;
                    }
                    previewRenderer2.f18114i = -1;
                    previewRenderer2.f18115j = -1;
                    previewRenderer2.f18109d = -1;
                    previewRenderer2.f18124s = false;
                    if (previewRenderer2.f18117l != null) {
                        displayListenerDelegate = (DisplayListenerDelegate) previewRenderer2.f18117l.get();
                    } else {
                        displayListenerDelegate = null;
                    }
                    DisplayListenerDelegate displayListenerDelegate2 = displayListenerDelegate;
                    if (displayListenerDelegate2 != null) {
                        displayListenerDelegate2.b();
                    }
                    return;
                case 7:
                    switch (EncoderSurfaceType.getEncoderSurfaceType(message.arg1)) {
                        case LIVE_STREAM:
                            this.f18075a.f18118m.f17916f = true;
                            this.f18075a.f18118m.m21758f();
                            return;
                        case LOCAL_VIDEO:
                            this.f18075a.f18119n.f17916f = true;
                            this.f18075a.f18119n.m21758f();
                            return;
                        default:
                            return;
                    }
                case 8:
                    switch (EncoderSurfaceType.getEncoderSurfaceType(message.arg1)) {
                        case LIVE_STREAM:
                            this.f18075a.f18118m.f17916f = false;
                            return;
                        case LOCAL_VIDEO:
                            this.f18075a.f18119n.f17916f = false;
                            return;
                        default:
                            return;
                    }
                case 9:
                    previewRenderer2 = this.f18075a;
                    previewRenderer2.f18118m.m21755a(previewRenderer2.f18123r);
                    previewRenderer2.f18119n.m21755a(previewRenderer2.f18123r);
                    return;
                case 10:
                    previewRenderer2 = this.f18075a;
                    previewRenderer2.f18118m.m21756d();
                    previewRenderer2.f18118m.m21757e();
                    previewRenderer2.f18119n.m21756d();
                    previewRenderer2.f18119n.m21757e();
                    return;
                default:
                    throw new RuntimeException("Unhandled msg what=" + i);
            }
        }
    }

    public PreviewRenderer2(DisplayListenerDelegate displayListenerDelegate, @Nullable RecordingListenerDelegate recordingListenerDelegate, @Nullable RecordingListenerDelegate recordingListenerDelegate2, SurfaceView surfaceView, ScreenCaptureUtil screenCaptureUtil) {
        super(null, null, null, null, null, null, 1.0f);
        this.f18117l = new WeakReference(displayListenerDelegate);
        this.f18118m.m21754a(recordingListenerDelegate);
        this.f18119n.m21754a(recordingListenerDelegate2);
        this.f18108c = new WeakReference(surfaceView);
        this.f18110e = new Handler();
        this.f18125t = new Object();
        this.f18124s = false;
        this.f18111f = screenCaptureUtil;
    }

    @TargetApi(17)
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        surfaceHolder.getSurface().toString();
        synchronized (this.f18125t) {
            this.f18120o = surfaceHolder.getSurface();
        }
        this.f18107b.sendMessage(this.f18107b.obtainMessage(1));
    }

    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        surfaceHolder.getSurface().toString();
        Integer.valueOf(i);
        Integer.valueOf(i2);
        Integer.valueOf(i3);
        if (this.f18128w != null) {
            m21931b(i2, i3);
        }
        synchronized (this.f18125t) {
            this.f18120o = surfaceHolder.getSurface();
            this.f18116k = ((DisplayListenerDelegate) this.f18117l.get()).c();
        }
    }

    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        surfaceHolder.getSurface();
        synchronized (this.f18125t) {
            if (this.f18120o == surfaceHolder.getSurface()) {
                this.f18120o = null;
            }
        }
    }

    public final void mo1399a(int i, long j) {
        this.f18107b.sendMessage(this.f18107b.obtainMessage(5, i, (int) j, null));
    }

    public final void mo1398a(int i, int i2) {
        this.f18107b.sendMessage(this.f18107b.obtainMessage(4, i, i2, null));
    }

    public final void mo1401a(EncoderSurfaceType encoderSurfaceType) {
        Message obtainMessage = this.f18107b.obtainMessage(7);
        obtainMessage.arg1 = encoderSurfaceType.toInt();
        this.f18107b.sendMessageAtFrontOfQueue(obtainMessage);
    }

    public final void mo1397a() {
        this.f18107b.sendMessageAtFrontOfQueue(this.f18107b.obtainMessage(6));
    }

    public final void mo1402b() {
        this.f18107b.sendMessageAtFrontOfQueue(this.f18107b.obtainMessage(9));
    }

    public final void mo1403c() {
        this.f18107b.sendMessageAtFrontOfQueue(this.f18107b.obtainMessage(10));
    }

    public final void mo1400a(Looper looper) {
        this.f18107b = new PreviewRendererHandler(this, looper);
    }

    private void m21931b(int i, int i2) {
        this.f18128w = ByteBuffer.allocateDirect((i * i2) * 4);
        this.f18128w.order(ByteOrder.LITTLE_ENDIAN);
        this.f18128w.rewind();
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void m21932f(com.facebook.facecast.PreviewRenderer2 r7) {
        /*
        r1 = 0;
        r0 = 1;
        r2 = r7.f18125t;
        monitor-enter(r2);
        r3 = r7.f18120o;	 Catch:{ all -> 0x0095 }
        if (r3 == 0) goto L_0x0015;
    L_0x0009:
        r3 = r7.f18120o;	 Catch:{ all -> 0x0095 }
        r3 = r3.isValid();	 Catch:{ all -> 0x0095 }
        if (r3 == 0) goto L_0x0015;
    L_0x0011:
        r3 = r7.f18124s;	 Catch:{ all -> 0x0095 }
        if (r3 == 0) goto L_0x0024;
    L_0x0015:
        r0 = r7.f18117l;	 Catch:{ all -> 0x0095 }
        r0 = r0.get();	 Catch:{ all -> 0x0095 }
        r0 = (com.facebook.video.videostreaming.DisplayListenerDelegate) r0;	 Catch:{ all -> 0x0095 }
        r1 = r7.f18112g;	 Catch:{ all -> 0x0095 }
        r0.a(r1);	 Catch:{ all -> 0x0095 }
        monitor-exit(r2);	 Catch:{ all -> 0x0095 }
    L_0x0023:
        return;
    L_0x0024:
        r3 = new com.facebook.video.videostreaming.opengl.EglCore;	 Catch:{ all -> 0x0095 }
        r4 = 0;
        r5 = 1;
        r3.<init>(r4, r5);	 Catch:{ all -> 0x0095 }
        r7.f18123r = r3;	 Catch:{ all -> 0x0095 }
        r3 = new com.facebook.video.videostreaming.opengl.WindowSurface;	 Catch:{ all -> 0x0095 }
        r4 = r7.f18123r;	 Catch:{ all -> 0x0095 }
        r5 = r7.f18120o;	 Catch:{ all -> 0x0095 }
        r6 = 0;
        r3.<init>(r4, r5, r6);	 Catch:{ all -> 0x0095 }
        r7.f18121p = r3;	 Catch:{ all -> 0x0095 }
        r3 = r7.f18121p;	 Catch:{ all -> 0x0095 }
        r3.b();	 Catch:{ all -> 0x0095 }
        r3 = new com.facebook.video.videostreaming.opengl.FullFrameRect;	 Catch:{ all -> 0x0095 }
        r4 = new com.facebook.video.videostreaming.opengl.Texture2dProgram;	 Catch:{ all -> 0x0095 }
        r5 = com.facebook.video.videostreaming.opengl.Texture2dProgram.ProgramType.TEXTURE_EXT;	 Catch:{ all -> 0x0095 }
        r4.<init>(r5);	 Catch:{ all -> 0x0095 }
        r3.<init>(r4);	 Catch:{ all -> 0x0095 }
        r7.f18122q = r3;	 Catch:{ all -> 0x0095 }
        r3 = r7.f18122q;	 Catch:{ all -> 0x0095 }
        r3 = r3.a();	 Catch:{ all -> 0x0095 }
        r7.f18109d = r3;	 Catch:{ all -> 0x0095 }
        r3 = new android.graphics.SurfaceTexture;	 Catch:{ all -> 0x0095 }
        r4 = r7.f18109d;	 Catch:{ all -> 0x0095 }
        r3.<init>(r4);	 Catch:{ all -> 0x0095 }
        r7.f18112g = r3;	 Catch:{ all -> 0x0095 }
        r3 = r7.f18117l;	 Catch:{ all -> 0x0095 }
        if (r3 == 0) goto L_0x0098;
    L_0x0061:
        r3 = r7.f18117l;	 Catch:{ all -> 0x0095 }
        r3 = r3.get();	 Catch:{ all -> 0x0095 }
        if (r3 == 0) goto L_0x0098;
    L_0x0069:
        r1 = "Display listener delegate is not set.";
        com.google.common.base.Preconditions.checkState(r0, r1);	 Catch:{ all -> 0x0095 }
        r0 = r7.f18117l;	 Catch:{ all -> 0x0095 }
        r0 = r0.get();	 Catch:{ all -> 0x0095 }
        r0 = (com.facebook.video.videostreaming.DisplayListenerDelegate) r0;	 Catch:{ all -> 0x0095 }
        r1 = r7.f18112g;	 Catch:{ all -> 0x0095 }
        r0.a(r1);	 Catch:{ all -> 0x0095 }
        r0 = 1;
        r7.f18124s = r0;	 Catch:{ all -> 0x0095 }
        r0 = r7.f18114i;	 Catch:{ all -> 0x0095 }
        if (r0 <= 0) goto L_0x0093;
    L_0x0082:
        r0 = r7.f18115j;	 Catch:{ all -> 0x0095 }
        if (r0 <= 0) goto L_0x0093;
    L_0x0086:
        r0 = r7.f18122q;	 Catch:{ all -> 0x0095 }
        r1 = r7.f18114i;	 Catch:{ all -> 0x0095 }
        r3 = r7.f18115j;	 Catch:{ all -> 0x0095 }
        r4 = r7.f18116k;	 Catch:{ all -> 0x0095 }
        r5 = 1065353216; // 0x3f800000 float:1.0 double:5.263544247E-315;
        r0.a(r1, r3, r4, r5);	 Catch:{ all -> 0x0095 }
    L_0x0093:
        monitor-exit(r2);	 Catch:{ all -> 0x0095 }
        goto L_0x0023;
    L_0x0095:
        r0 = move-exception;
        monitor-exit(r2);	 Catch:{ all -> 0x0095 }
        throw r0;
    L_0x0098:
        r0 = r1;
        goto L_0x0069;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.facecast.PreviewRenderer2.f(com.facebook.facecast.PreviewRenderer2):void");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void m21930a(com.facebook.facecast.PreviewRenderer2 r2, int r3) {
        /*
        r1 = r2.f18125t;
        monitor-enter(r1);
        r0 = r2.f18114i;	 Catch:{ all -> 0x003a }
        if (r0 <= 0) goto L_0x000f;
    L_0x0007:
        r0 = r2.f18115j;	 Catch:{ all -> 0x003a }
        if (r0 <= 0) goto L_0x000f;
    L_0x000b:
        r0 = r2.f18124s;	 Catch:{ all -> 0x003a }
        if (r0 != 0) goto L_0x0011;
    L_0x000f:
        monitor-exit(r1);	 Catch:{ all -> 0x003a }
    L_0x0010:
        return;
    L_0x0011:
        r0 = r2.f18121p;	 Catch:{ all -> 0x003a }
        r0.b();	 Catch:{ all -> 0x003a }
        r0 = r2.f18112g;	 Catch:{ all -> 0x003a }
        r0.updateTexImage();	 Catch:{ all -> 0x003a }
        r2.m21933g();	 Catch:{ all -> 0x003a }
        r0 = r2.f18118m;	 Catch:{ all -> 0x003a }
        r0 = r0.m21759g();	 Catch:{ all -> 0x003a }
        if (r0 == 0) goto L_0x002b;
    L_0x0026:
        r0 = r2.f18118m;	 Catch:{ all -> 0x003a }
        r2.m21929a(r0, r3);	 Catch:{ all -> 0x003a }
    L_0x002b:
        r0 = r2.f18119n;	 Catch:{ all -> 0x003a }
        r0 = r0.m21759g();	 Catch:{ all -> 0x003a }
        if (r0 == 0) goto L_0x0038;
    L_0x0033:
        r0 = r2.f18119n;	 Catch:{ all -> 0x003a }
        r2.m21929a(r0, r3);	 Catch:{ all -> 0x003a }
    L_0x0038:
        monitor-exit(r1);	 Catch:{ all -> 0x003a }
        goto L_0x0010;
    L_0x003a:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x003a }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.facecast.PreviewRenderer2.a(com.facebook.facecast.PreviewRenderer2, int):void");
    }

    private void m21929a(EncoderSurface2 encoderSurface2, int i) {
        boolean z = true;
        EglSurfaceBase eglSurfaceBase = encoderSurface2.f17913c;
        if (this.f18112g.getTimestamp() != 0) {
            eglSurfaceBase.b();
            GLES20.glViewport(0, 0, encoderSurface2.f17914d, encoderSurface2.f17915e);
            FullFrameRect fullFrameRect = this.f18122q;
            int i2 = this.f18109d;
            float[] fArr = this.f18113h;
            if (i != 1) {
                z = false;
            }
            fullFrameRect.a(i2, fArr, z);
            eglSurfaceBase.c();
            eglSurfaceBase.a(this.f18112g.getTimestamp());
            ((DisplayListenerDelegate) this.f18117l.get()).a();
        }
    }

    private void m21933g() {
        GLES20.glViewport(0, 0, ((SurfaceView) this.f18108c.get()).getWidth(), ((SurfaceView) this.f18108c.get()).getHeight());
        this.f18112g.getTransformMatrix(this.f18113h);
        this.f18122q.a(this.f18109d, this.f18113h, false);
        if (this.f18126u && !this.f18127v) {
            this.f18127v = true;
            this.f18126u = false;
            if (this.f18128w == null) {
                m21931b(((SurfaceView) this.f18108c.get()).getWidth(), ((SurfaceView) this.f18108c.get()).getHeight());
            }
            this.f18111f.m21944a(this.f18129x, this.f18128w, this.f18113h, ((SurfaceView) this.f18108c.get()).getWidth(), ((SurfaceView) this.f18108c.get()).getHeight());
            this.f18127v = false;
        }
        this.f18121p.c();
    }

    public final void mo1404d() {
        this.f18107b.sendMessageAtFrontOfQueue(this.f18107b.obtainMessage(1));
    }
}
