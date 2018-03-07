package com.facebook.facecast;

import android.annotation.TargetApi;
import android.graphics.SurfaceTexture;
import android.net.Uri;
import android.opengl.GLES20;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;
import com.facebook.common.time.MonotonicClock;
import com.facebook.debug.log.BLog;
import com.facebook.facecast.plugin.FacecastPreviewPlugin.EncoderSurfaceType;
import com.facebook.video.videostreaming.DisplayListenerDelegate;
import com.facebook.video.videostreaming.RealtimeEncoderInputSurface;
import com.facebook.video.videostreaming.RecordingListenerDelegate;
import com.facebook.video.videostreaming.opengl.EglCore;
import com.facebook.video.videostreaming.opengl.EglSurfaceBase;
import com.facebook.video.videostreaming.opengl.FullFrameRect;
import com.facebook.video.videostreaming.opengl.WindowSurface;
import com.facebook.videocodec.effects.GLRenderer;
import com.facebook.videocodec.effects.renderers.DoodleEvent;
import com.google.common.base.Preconditions;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.LinkedBlockingDeque;
import javax.annotation.Nullable;

@TargetApi(18)
/* compiled from: broadcaster_zoom_illegal_argument_exception */
public class PreviewRenderer implements Callback {
    private static final String f18076a = PreviewRenderer.class.getName();
    private volatile boolean f18077A = false;
    private ByteBuffer f18078B;
    private String f18079C;
    private Integer f18080D = null;
    public volatile PreviewRendererHandler f18081b;
    private final WeakReference<SurfaceView> f18082c;
    private int f18083d = -1;
    private final Handler f18084e;
    private final ScreenCaptureUtil f18085f;
    private SurfaceTexture f18086g;
    private final float[] f18087h = new float[16];
    public int f18088i = -1;
    public int f18089j = -1;
    public int f18090k;
    public float f18091l;
    private WeakReference<DisplayListenerDelegate> f18092m;
    private WeakReference<RecordingListenerDelegate> f18093n;
    private volatile Surface f18094o;
    private WindowSurface f18095p;
    public List<LiveStreamOutputSurface> f18096q;
    public FullFrameRect f18097r;
    public EglCore f18098s;
    public volatile boolean f18099t;
    private final Object f18100u;
    public FacecastGLRendererManager f18101v;
    private LinkedBlockingDeque<SecondaryPreviewSurface> f18102w;
    private MonotonicClock f18103x;
    public boolean f18104y = false;
    private volatile boolean f18105z = false;

    /* compiled from: broadcaster_zoom_illegal_argument_exception */
    class PreviewRendererHandler extends Handler {
        final /* synthetic */ PreviewRenderer f18065a;

        PreviewRendererHandler(PreviewRenderer previewRenderer, Looper looper) {
            this.f18065a = previewRenderer;
            super(looper);
        }

        public void handleMessage(Message message) {
            int i = message.what;
            PreviewRenderer previewRenderer;
            int i2;
            int i3;
            PreviewRenderer previewRenderer2;
            switch (i) {
                case 1:
                    this.f18065a.m21910g();
                    return;
                case 2:
                    previewRenderer = this.f18065a;
                    i2 = message.arg1;
                    i3 = message.arg2;
                    if (previewRenderer.f18101v != null) {
                        previewRenderer.f18101v.m21864a(i2, i3);
                    }
                    return;
                case 3:
                    previewRenderer = this.f18065a;
                    if (previewRenderer.f18101v != null) {
                        for (GLRenderer a : previewRenderer.f18101v.f18017f) {
                            a.a();
                        }
                    }
                    return;
                case 4:
                    previewRenderer = this.f18065a;
                    i2 = message.arg1;
                    i3 = message.arg2;
                    Integer.valueOf(i2);
                    Integer.valueOf(i3);
                    if (previewRenderer.f18088i == i2 && previewRenderer.f18089j == i3) {
                        Integer.valueOf(i2);
                        Integer.valueOf(i3);
                    } else {
                        previewRenderer.f18088i = i2;
                        previewRenderer.f18089j = i3;
                        if (previewRenderer.f18099t) {
                            if (previewRenderer.f18101v != null) {
                                previewRenderer.f18101v.m21864a(previewRenderer.f18088i, previewRenderer.f18089j);
                            } else {
                                previewRenderer.f18097r.a(previewRenderer.f18088i, previewRenderer.f18089j, previewRenderer.f18090k, previewRenderer.f18091l);
                            }
                        }
                    }
                    return;
                case 5:
                    PreviewRenderer.m21909e(this.f18065a, message.arg1, message.arg2);
                    return;
                case 6:
                    PreviewRenderer.m21912i(this.f18065a);
                    return;
                case 7:
                    for (LiveStreamOutputSurface liveStreamOutputSurface : this.f18065a.f18096q) {
                        liveStreamOutputSurface.f18064d = true;
                    }
                    return;
                case 8:
                    PreviewRenderer.m21918o(this.f18065a);
                    return;
                case 9:
                    PreviewRenderer.m21914k(this.f18065a);
                    return;
                case 10:
                    PreviewRenderer.m21913j(this.f18065a);
                    return;
                case 11:
                    SecondaryPreviewSurface.m21903i((SecondaryPreviewSurface) message.obj);
                    return;
                case 12:
                    Object obj = message.obj;
                    i = message.arg1;
                    i = message.arg2;
                    return;
                case 13:
                    SecondaryPreviewSurface secondaryPreviewSurface = (SecondaryPreviewSurface) message.obj;
                    SecondaryPreviewSurface.m21896b(secondaryPreviewSurface);
                    secondaryPreviewSurface.f18069d.a();
                    return;
                case 14:
                    PreviewRenderer.m21908b(this.f18065a, (SecondaryPreviewSurface) message.obj);
                    return;
                case 15:
                    PreviewRenderer.m21917n(this.f18065a);
                    return;
                case 16:
                    previewRenderer2 = this.f18065a;
                    previewRenderer2.f18091l = ((Float) message.obj).floatValue();
                    if (previewRenderer2.f18101v != null) {
                        previewRenderer2.f18101v.m21865a(previewRenderer2.f18088i, previewRenderer2.f18089j, previewRenderer2.f18090k, previewRenderer2.f18091l);
                    } else {
                        previewRenderer2.f18097r.a(previewRenderer2.f18088i, previewRenderer2.f18089j, previewRenderer2.f18090k, previewRenderer2.f18091l);
                    }
                    return;
                case 17:
                    previewRenderer2 = this.f18065a;
                    List list = (List) message.obj;
                    if (previewRenderer2.f18101v != null) {
                        FacecastGLRendererManager facecastGLRendererManager = previewRenderer2.f18101v;
                        if (facecastGLRendererManager.f18020i != null) {
                            facecastGLRendererManager.f18020i.m19778a(list);
                        }
                    }
                    return;
                case 18:
                    previewRenderer2 = this.f18065a;
                    Uri uri = (Uri) message.obj;
                    if (previewRenderer2.f18101v != null) {
                        previewRenderer2.f18101v.f18021j.m19788a(uri);
                    }
                    return;
                default:
                    throw new RuntimeException("Unhandled msg what=" + i);
            }
        }
    }

    /* compiled from: broadcaster_zoom_illegal_argument_exception */
    public class SecondaryPreviewSurface implements Callback {
        final /* synthetic */ PreviewRenderer f18066a;
        private final Object f18067b = new Object();
        public final WeakReference<SurfaceView> f18068c;
        public final GLRenderer f18069d;
        private volatile Surface f18070e;
        private WindowSurface f18071f;
        public boolean f18072g;
        private boolean f18073h;

        public SecondaryPreviewSurface(PreviewRenderer previewRenderer, SurfaceView surfaceView, GLRenderer gLRenderer) {
            boolean z = false;
            this.f18066a = previewRenderer;
            Preconditions.checkArgument(surfaceView != null, "Invalid view submitted");
            if (gLRenderer != null) {
                z = true;
            }
            Preconditions.checkArgument(z, "Invalid GLRenderer submitted");
            this.f18068c = new WeakReference(surfaceView);
            this.f18069d = gLRenderer;
            surfaceView.getHolder().addCallback(this);
            this.f18072g = true;
        }

        public static void m21895a(SecondaryPreviewSurface secondaryPreviewSurface) {
            ((SurfaceView) secondaryPreviewSurface.f18068c.get()).getHolder().removeCallback(secondaryPreviewSurface);
            m21896b(secondaryPreviewSurface);
        }

        public static void m21896b(SecondaryPreviewSurface secondaryPreviewSurface) {
            if (secondaryPreviewSurface.f18071f != null) {
                secondaryPreviewSurface.f18071f.d();
                secondaryPreviewSurface.f18071f = null;
            }
        }

        public static boolean m21897c(SecondaryPreviewSurface secondaryPreviewSurface) {
            return secondaryPreviewSurface.f18071f != null && (secondaryPreviewSurface.f18072g || secondaryPreviewSurface.f18073h);
        }

        public static void m21898d(SecondaryPreviewSurface secondaryPreviewSurface) {
            secondaryPreviewSurface.f18073h = false;
        }

        public static GLRenderer m21899e(SecondaryPreviewSurface secondaryPreviewSurface) {
            return secondaryPreviewSurface.f18069d;
        }

        public static int m21900f(SecondaryPreviewSurface secondaryPreviewSurface) {
            return ((SurfaceView) secondaryPreviewSurface.f18068c.get()).getWidth();
        }

        public static int m21901g(SecondaryPreviewSurface secondaryPreviewSurface) {
            return ((SurfaceView) secondaryPreviewSurface.f18068c.get()).getHeight();
        }

        public static WindowSurface m21902h(SecondaryPreviewSurface secondaryPreviewSurface) {
            return secondaryPreviewSurface.f18071f;
        }

        public void surfaceCreated(SurfaceHolder surfaceHolder) {
            synchronized (this.f18067b) {
                this.f18070e = surfaceHolder.getSurface();
            }
            this.f18066a.f18081b.sendMessage(this.f18066a.f18081b.obtainMessage(11, this));
        }

        public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
            synchronized (this.f18067b) {
                this.f18070e = surfaceHolder.getSurface();
            }
            this.f18066a.f18081b.sendMessage(this.f18066a.f18081b.obtainMessage(12, i2, i3, this));
        }

        public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
            synchronized (this.f18067b) {
                if (this.f18070e == surfaceHolder.getSurface()) {
                    this.f18070e = null;
                    this.f18066a.f18081b.sendMessage(this.f18066a.f18081b.obtainMessage(13, this));
                }
            }
        }

        public static void m21903i(SecondaryPreviewSurface secondaryPreviewSurface) {
            if (secondaryPreviewSurface.f18071f == null && secondaryPreviewSurface.f18070e != null) {
                secondaryPreviewSurface.f18071f = new WindowSurface(secondaryPreviewSurface.f18066a.f18098s, secondaryPreviewSurface.f18070e, false);
                secondaryPreviewSurface.f18073h = true;
                secondaryPreviewSurface.f18069d.a(secondaryPreviewSurface.f18066a.f18101v.f18013b);
            }
        }
    }

    public PreviewRenderer(DisplayListenerDelegate displayListenerDelegate, RecordingListenerDelegate recordingListenerDelegate, SurfaceView surfaceView, ScreenCaptureUtil screenCaptureUtil, FacecastGLRendererManager facecastGLRendererManager, MonotonicClock monotonicClock, float f) {
        this.f18092m = new WeakReference(displayListenerDelegate);
        this.f18093n = new WeakReference(recordingListenerDelegate);
        this.f18082c = new WeakReference(surfaceView);
        this.f18084e = new Handler();
        this.f18100u = new Object();
        this.f18099t = false;
        this.f18085f = screenCaptureUtil;
        this.f18096q = new ArrayList();
        this.f18101v = facecastGLRendererManager;
        this.f18102w = new LinkedBlockingDeque();
        this.f18103x = monotonicClock;
        this.f18091l = f;
    }

    @TargetApi(17)
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        surfaceHolder.getSurface().toString();
        synchronized (this.f18100u) {
            this.f18094o = surfaceHolder.getSurface();
        }
        this.f18081b.sendMessage(this.f18081b.obtainMessage(1));
    }

    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        surfaceHolder.getSurface().toString();
        Integer.valueOf(i);
        Integer.valueOf(i2);
        Integer.valueOf(i3);
        if (this.f18078B != null) {
            m21907b(i2, i3);
        }
        synchronized (this.f18100u) {
            this.f18094o = surfaceHolder.getSurface();
            this.f18090k = ((DisplayListenerDelegate) this.f18092m.get()).c();
        }
        this.f18081b.sendMessage(this.f18081b.obtainMessage(2, i2, i3));
    }

    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        surfaceHolder.getSurface();
        synchronized (this.f18100u) {
            if (this.f18094o == surfaceHolder.getSurface()) {
                this.f18094o = null;
            }
        }
        this.f18081b.sendMessage(this.f18081b.obtainMessage(3));
    }

    public void mo1399a(int i, long j) {
        this.f18081b.sendMessage(this.f18081b.obtainMessage(5, i, (int) j, null));
    }

    public void mo1398a(int i, int i2) {
        this.f18081b.sendMessage(this.f18081b.obtainMessage(4, i, i2, null));
    }

    public void mo1401a(EncoderSurfaceType encoderSurfaceType) {
        this.f18081b.sendMessageAtFrontOfQueue(this.f18081b.obtainMessage(7));
    }

    public void mo1397a() {
        this.f18081b.sendMessageAtFrontOfQueue(this.f18081b.obtainMessage(6));
    }

    public void mo1402b() {
        this.f18081b.sendMessageAtFrontOfQueue(this.f18081b.obtainMessage(9));
    }

    public void mo1403c() {
        this.f18081b.sendMessageAtFrontOfQueue(this.f18081b.obtainMessage(10));
    }

    public void mo1400a(Looper looper) {
        this.f18081b = new PreviewRendererHandler(this, looper);
    }

    public final SecondaryPreviewSurface m21919a(SurfaceView surfaceView, GLRenderer gLRenderer) {
        SecondaryPreviewSurface secondaryPreviewSurface = null;
        if (this.f18101v != null) {
            synchronized (this.f18102w) {
                Iterator it = this.f18102w.iterator();
                SecondaryPreviewSurface secondaryPreviewSurface2 = null;
                while (it.hasNext()) {
                    secondaryPreviewSurface = (SecondaryPreviewSurface) it.next();
                    if (secondaryPreviewSurface.f18068c.get() == surfaceView) {
                        BLog.a(f18076a, "Secondary preview surface already added");
                    } else {
                        secondaryPreviewSurface = secondaryPreviewSurface2;
                    }
                    secondaryPreviewSurface2 = secondaryPreviewSurface;
                }
                if (secondaryPreviewSurface2 == null) {
                    secondaryPreviewSurface = new SecondaryPreviewSurface(this, surfaceView, gLRenderer);
                    this.f18102w.addFirst(secondaryPreviewSurface);
                } else {
                    secondaryPreviewSurface = secondaryPreviewSurface2;
                }
            }
        }
        return secondaryPreviewSurface;
    }

    public final void m21925a(List<DoodleEvent> list) {
        this.f18081b.sendMessage(this.f18081b.obtainMessage(17, list));
    }

    private void m21907b(int i, int i2) {
        this.f18078B = ByteBuffer.allocateDirect((i * i2) * 4);
        this.f18078B.order(ByteOrder.LITTLE_ENDIAN);
        this.f18078B.rewind();
    }

    public static void m21908b(PreviewRenderer previewRenderer, SecondaryPreviewSurface secondaryPreviewSurface) {
        synchronized (previewRenderer.f18102w) {
            previewRenderer.f18102w.remove(secondaryPreviewSurface);
        }
        SecondaryPreviewSurface.m21895a(secondaryPreviewSurface);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m21910g() {
        /*
        r7 = this;
        r2 = 0;
        r1 = 1;
        r3 = r7.f18100u;
        monitor-enter(r3);
        r0 = r7.f18094o;	 Catch:{ all -> 0x005a }
        if (r0 == 0) goto L_0x0015;
    L_0x0009:
        r0 = r7.f18094o;	 Catch:{ all -> 0x005a }
        r0 = r0.isValid();	 Catch:{ all -> 0x005a }
        if (r0 == 0) goto L_0x0015;
    L_0x0011:
        r0 = r7.f18099t;	 Catch:{ all -> 0x005a }
        if (r0 == 0) goto L_0x0024;
    L_0x0015:
        r0 = r7.f18092m;	 Catch:{ all -> 0x005a }
        r0 = r0.get();	 Catch:{ all -> 0x005a }
        r0 = (com.facebook.video.videostreaming.DisplayListenerDelegate) r0;	 Catch:{ all -> 0x005a }
        r1 = r7.f18086g;	 Catch:{ all -> 0x005a }
        r0.a(r1);	 Catch:{ all -> 0x005a }
        monitor-exit(r3);	 Catch:{ all -> 0x005a }
    L_0x0023:
        return;
    L_0x0024:
        r0 = new com.facebook.video.videostreaming.opengl.EglCore;	 Catch:{ all -> 0x005a }
        r4 = 0;
        r5 = 1;
        r0.<init>(r4, r5);	 Catch:{ all -> 0x005a }
        r7.f18098s = r0;	 Catch:{ all -> 0x005a }
        r0 = new com.facebook.video.videostreaming.opengl.WindowSurface;	 Catch:{ all -> 0x005a }
        r4 = r7.f18098s;	 Catch:{ all -> 0x005a }
        r5 = r7.f18094o;	 Catch:{ all -> 0x005a }
        r6 = 0;
        r0.<init>(r4, r5, r6);	 Catch:{ all -> 0x005a }
        r7.f18095p = r0;	 Catch:{ all -> 0x005a }
        r0 = r7.f18095p;	 Catch:{ all -> 0x005a }
        r0.b();	 Catch:{ all -> 0x005a }
        r4 = r7.f18102w;	 Catch:{ all -> 0x005a }
        monitor-enter(r4);	 Catch:{ all -> 0x005a }
        r0 = r7.f18102w;	 Catch:{ all -> 0x0057 }
        r5 = r0.iterator();	 Catch:{ all -> 0x0057 }
    L_0x0047:
        r0 = r5.hasNext();	 Catch:{ all -> 0x0057 }
        if (r0 == 0) goto L_0x005d;
    L_0x004d:
        r0 = r5.next();	 Catch:{ all -> 0x0057 }
        r0 = (com.facebook.facecast.PreviewRenderer.SecondaryPreviewSurface) r0;	 Catch:{ all -> 0x0057 }
        com.facebook.facecast.PreviewRenderer.SecondaryPreviewSurface.m21903i(r0);	 Catch:{ all -> 0x0057 }
        goto L_0x0047;
    L_0x0057:
        r0 = move-exception;
        monitor-exit(r4);	 Catch:{ all -> 0x0057 }
        throw r0;	 Catch:{  }
    L_0x005a:
        r0 = move-exception;
        monitor-exit(r3);	 Catch:{  }
        throw r0;
    L_0x005d:
        monitor-exit(r4);	 Catch:{  }
        r0 = r7.f18101v;	 Catch:{  }
        if (r0 == 0) goto L_0x00b6;
    L_0x0062:
        r0 = r7.f18101v;	 Catch:{  }
        r0.m21868b();	 Catch:{  }
        r0 = r7.f18101v;	 Catch:{  }
        r0 = r0.m21869d();	 Catch:{  }
        r7.f18083d = r0;	 Catch:{  }
    L_0x006f:
        r0 = new android.graphics.SurfaceTexture;	 Catch:{  }
        r4 = r7.f18083d;	 Catch:{  }
        r0.<init>(r4);	 Catch:{  }
        r7.f18086g = r0;	 Catch:{  }
        r0 = r7.f18092m;	 Catch:{  }
        if (r0 == 0) goto L_0x00cd;
    L_0x007c:
        r0 = r7.f18092m;	 Catch:{  }
        r0 = r0.get();	 Catch:{  }
        if (r0 == 0) goto L_0x00cd;
    L_0x0084:
        r0 = r1;
    L_0x0085:
        r1 = "Display listener delegate is not set.";
        com.google.common.base.Preconditions.checkState(r0, r1);	 Catch:{  }
        r0 = r7.f18092m;	 Catch:{  }
        r0 = r0.get();	 Catch:{  }
        r0 = (com.facebook.video.videostreaming.DisplayListenerDelegate) r0;	 Catch:{  }
        r1 = r7.f18086g;	 Catch:{  }
        r0.a(r1);	 Catch:{  }
        r0 = 1;
        r7.f18099t = r0;	 Catch:{  }
        r0 = r7.f18088i;	 Catch:{  }
        if (r0 <= 0) goto L_0x00b3;
    L_0x009e:
        r0 = r7.f18089j;	 Catch:{  }
        if (r0 <= 0) goto L_0x00b3;
    L_0x00a2:
        r0 = r7.f18101v;	 Catch:{  }
        if (r0 == 0) goto L_0x00cf;
    L_0x00a6:
        r0 = r7.f18101v;	 Catch:{  }
        r1 = r7.f18088i;	 Catch:{  }
        r2 = r7.f18089j;	 Catch:{  }
        r4 = r7.f18090k;	 Catch:{  }
        r5 = r7.f18091l;	 Catch:{  }
        r0.m21865a(r1, r2, r4, r5);	 Catch:{  }
    L_0x00b3:
        monitor-exit(r3);	 Catch:{  }
        goto L_0x0023;
    L_0x00b6:
        r0 = new com.facebook.video.videostreaming.opengl.FullFrameRect;	 Catch:{  }
        r4 = new com.facebook.video.videostreaming.opengl.Texture2dProgram;	 Catch:{  }
        r5 = com.facebook.video.videostreaming.opengl.Texture2dProgram.ProgramType.TEXTURE_EXT;	 Catch:{  }
        r4.<init>(r5);	 Catch:{  }
        r0.<init>(r4);	 Catch:{  }
        r7.f18097r = r0;	 Catch:{  }
        r0 = r7.f18097r;	 Catch:{  }
        r0 = r0.a();	 Catch:{  }
        r7.f18083d = r0;	 Catch:{  }
        goto L_0x006f;
    L_0x00cd:
        r0 = r2;
        goto L_0x0085;
    L_0x00cf:
        r0 = r7.f18097r;	 Catch:{  }
        r1 = r7.f18088i;	 Catch:{  }
        r2 = r7.f18089j;	 Catch:{  }
        r4 = r7.f18090k;	 Catch:{  }
        r5 = r7.f18091l;	 Catch:{  }
        r0.a(r1, r2, r4, r5);	 Catch:{  }
        goto L_0x00b3;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.facecast.PreviewRenderer.g():void");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void m21909e(com.facebook.facecast.PreviewRenderer r4, int r5, int r6) {
        /*
        r1 = r4.f18100u;
        monitor-enter(r1);
        r0 = r4.f18088i;	 Catch:{ all -> 0x003b }
        if (r0 <= 0) goto L_0x000f;
    L_0x0007:
        r0 = r4.f18089j;	 Catch:{ all -> 0x003b }
        if (r0 <= 0) goto L_0x000f;
    L_0x000b:
        r0 = r4.f18099t;	 Catch:{ all -> 0x003b }
        if (r0 != 0) goto L_0x0011;
    L_0x000f:
        monitor-exit(r1);	 Catch:{ all -> 0x003b }
    L_0x0010:
        return;
    L_0x0011:
        r0 = r4.f18103x;	 Catch:{ all -> 0x003b }
        r2 = r0.now();	 Catch:{ all -> 0x003b }
        r0 = r4.f18095p;	 Catch:{ all -> 0x003b }
        r0.b();	 Catch:{ all -> 0x003b }
        r0 = r4.f18086g;	 Catch:{ all -> 0x003b }
        r0.updateTexImage();	 Catch:{ all -> 0x003b }
        r4.m21911h();	 Catch:{ all -> 0x003b }
        r0 = r4.f18080D;	 Catch:{ all -> 0x003b }
        if (r0 == 0) goto L_0x0030;
    L_0x0028:
        r0 = r4.f18080D;	 Catch:{ all -> 0x003b }
        r0 = r0.intValue();	 Catch:{ all -> 0x003b }
        if (r0 == r5) goto L_0x003e;
    L_0x0030:
        r0 = java.lang.Integer.valueOf(r5);	 Catch:{ all -> 0x003b }
        r4.f18080D = r0;	 Catch:{ all -> 0x003b }
    L_0x0036:
        r4.m21905a(r2, r6);	 Catch:{ all -> 0x003b }
        monitor-exit(r1);	 Catch:{ all -> 0x003b }
        goto L_0x0010;
    L_0x003b:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x003b }
        throw r0;
    L_0x003e:
        r4.m21904a(r5);	 Catch:{  }
        goto L_0x0036;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.facecast.PreviewRenderer.e(com.facebook.facecast.PreviewRenderer, int, int):void");
    }

    private void m21904a(int i) {
        if (this.f18086g.getTimestamp() != 0) {
            for (LiveStreamOutputSurface liveStreamOutputSurface : this.f18096q) {
                if (liveStreamOutputSurface.f18064d) {
                    EglSurfaceBase eglSurfaceBase = liveStreamOutputSurface.f18062b;
                    eglSurfaceBase.b();
                    GLES20.glViewport(0, 0, liveStreamOutputSurface.f18063c.a, liveStreamOutputSurface.f18063c.b);
                    if (this.f18101v != null) {
                        this.f18101v.m21866a(this.f18086g, i == 1);
                    } else {
                        this.f18097r.a(this.f18083d, this.f18087h, i == 1);
                    }
                    eglSurfaceBase.c();
                    eglSurfaceBase.a(this.f18086g.getTimestamp());
                }
            }
            ((DisplayListenerDelegate) this.f18092m.get()).a();
        }
    }

    private void m21911h() {
        GLES20.glViewport(0, 0, ((SurfaceView) this.f18082c.get()).getWidth(), ((SurfaceView) this.f18082c.get()).getHeight());
        this.f18086g.getTransformMatrix(this.f18087h);
        if (this.f18101v != null) {
            this.f18101v.m21866a(this.f18086g, false);
        } else {
            this.f18097r.a(this.f18083d, this.f18087h, false);
        }
        if (this.f18105z && !this.f18077A) {
            this.f18077A = true;
            this.f18105z = false;
            if (this.f18078B == null) {
                m21907b(((SurfaceView) this.f18082c.get()).getWidth(), ((SurfaceView) this.f18082c.get()).getHeight());
            }
            this.f18085f.m21944a(this.f18079C, this.f18078B, this.f18087h, ((SurfaceView) this.f18082c.get()).getWidth(), ((SurfaceView) this.f18082c.get()).getHeight());
            this.f18077A = false;
        }
        this.f18095p.c();
    }

    private void m21905a(long j, int i) {
        if (this.f18101v != null && this.f18104y) {
            synchronized (this.f18102w) {
                for (int i2 = 0; i2 < this.f18102w.size(); i2++) {
                    SecondaryPreviewSurface secondaryPreviewSurface = (SecondaryPreviewSurface) this.f18102w.pollFirst();
                    if (SecondaryPreviewSurface.m21897c(secondaryPreviewSurface)) {
                        WindowSurface h = SecondaryPreviewSurface.m21902h(secondaryPreviewSurface);
                        h.b();
                        GLES20.glViewport(0, 0, SecondaryPreviewSurface.m21900f(secondaryPreviewSurface), SecondaryPreviewSurface.m21901g(secondaryPreviewSurface));
                        this.f18101v.m21867a(this.f18086g, false, SecondaryPreviewSurface.m21899e(secondaryPreviewSurface));
                        h.c();
                        SecondaryPreviewSurface.m21898d(secondaryPreviewSurface);
                    }
                    this.f18102w.addLast(secondaryPreviewSurface);
                    if (this.f18103x.now() - j >= ((long) i)) {
                        return;
                    }
                }
            }
        }
    }

    @TargetApi(14)
    public static void m21912i(PreviewRenderer previewRenderer) {
        if (previewRenderer.f18095p != null) {
            previewRenderer.f18095p.d();
            previewRenderer.f18095p = null;
        }
        synchronized (previewRenderer.f18102w) {
            Iterator it = previewRenderer.f18102w.iterator();
            while (it.hasNext()) {
                SecondaryPreviewSurface.m21896b((SecondaryPreviewSurface) it.next());
            }
        }
        for (LiveStreamOutputSurface d : previewRenderer.f18096q) {
            d.m21894d();
        }
        previewRenderer.f18096q.clear();
        if (previewRenderer.f18086g != null) {
            previewRenderer.f18086g.release();
            previewRenderer.f18086g = null;
        }
        if (previewRenderer.f18097r != null) {
            previewRenderer.f18097r.a(false);
            previewRenderer.f18097r = null;
        }
        if (previewRenderer.f18098s != null) {
            previewRenderer.f18098s.a();
            previewRenderer.f18098s = null;
        }
        previewRenderer.f18080D = null;
        previewRenderer.f18088i = -1;
        previewRenderer.f18089j = -1;
        previewRenderer.f18083d = -1;
        m21918o(previewRenderer);
        previewRenderer.f18099t = false;
        DisplayListenerDelegate l = previewRenderer.m21915l();
        if (l != null) {
            l.b();
        }
    }

    public static void m21913j(PreviewRenderer previewRenderer) {
        for (LiveStreamOutputSurface d : previewRenderer.f18096q) {
            d.m21894d();
        }
        previewRenderer.f18096q.clear();
        m21918o(previewRenderer);
        RecordingListenerDelegate m = previewRenderer.m21916m();
        if (m != null) {
            m.k();
        }
    }

    public void mo1404d() {
        this.f18081b.sendMessageAtFrontOfQueue(this.f18081b.obtainMessage(1));
    }

    public static void m21914k(PreviewRenderer previewRenderer) {
        RecordingListenerDelegate m = previewRenderer.m21916m();
        if (m == null || previewRenderer.f18098s == null || previewRenderer.f18096q.size() != 0) {
            BLog.a(f18076a, "Discarding the recorder init surface request.Delegate %s, EglCore %s", new Object[]{m, previewRenderer.f18098s});
            return;
        }
        for (RealtimeEncoderInputSurface realtimeEncoderInputSurface : m.j()) {
            LiveStreamOutputSurface liveStreamOutputSurface = new LiveStreamOutputSurface();
            EglCore eglCore = previewRenderer.f18098s;
            if (liveStreamOutputSurface.f18062b != null || eglCore == null) {
                BLog.a(LiveStreamOutputSurface.f18061a, "Discarding the recorder init surface request.Current encode surface %s, EglCore %s", new Object[]{liveStreamOutputSurface.f18062b, eglCore});
            } else {
                liveStreamOutputSurface.f18063c = realtimeEncoderInputSurface;
                if (liveStreamOutputSurface.f18063c == null || !liveStreamOutputSurface.f18063c.c.isValid()) {
                    BLog.a(LiveStreamOutputSurface.f18061a, "The recorder surface invalid");
                } else {
                    liveStreamOutputSurface.f18062b = new WindowSurface(eglCore, liveStreamOutputSurface.f18063c.c, false);
                }
            }
            previewRenderer.f18096q.add(liveStreamOutputSurface);
        }
        m.l();
    }

    @Nullable
    private DisplayListenerDelegate m21915l() {
        if (this.f18092m != null) {
            return (DisplayListenerDelegate) this.f18092m.get();
        }
        return null;
    }

    @Nullable
    private RecordingListenerDelegate m21916m() {
        if (this.f18093n != null) {
            return (RecordingListenerDelegate) this.f18093n.get();
        }
        return null;
    }

    public static void m21917n(PreviewRenderer previewRenderer) {
        DisplayListenerDelegate l = previewRenderer.m21915l();
        if (l == null) {
            BLog.a(f18076a, "Delegate is null. Not doing any orientation change.");
            return;
        }
        previewRenderer.f18090k = l.c();
        if (previewRenderer.f18101v != null) {
            previewRenderer.f18101v.m21865a(previewRenderer.f18088i, previewRenderer.f18089j, previewRenderer.f18090k, previewRenderer.f18091l);
        } else if (previewRenderer.f18097r != null) {
            previewRenderer.f18097r.a(previewRenderer.f18088i, previewRenderer.f18089j, previewRenderer.f18090k, previewRenderer.f18091l);
        }
    }

    public static void m21918o(PreviewRenderer previewRenderer) {
        for (LiveStreamOutputSurface liveStreamOutputSurface : previewRenderer.f18096q) {
            liveStreamOutputSurface.f18064d = false;
        }
    }
}
