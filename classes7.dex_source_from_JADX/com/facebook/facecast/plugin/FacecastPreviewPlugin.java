package com.facebook.facecast.plugin;

import android.content.Context;
import android.hardware.Camera;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.ScaleGestureDetector.SimpleOnScaleGestureListener;
import android.view.View;
import android.view.View.OnTouchListener;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForNonUiThreadMethodAutoProvider;
import com.facebook.common.time.AwakeTimeSinceBootClockMethodAutoProvider;
import com.facebook.common.time.MonotonicClock;
import com.facebook.facecast.FacecastCamera;
import com.facebook.facecast.FacecastGLRendererManager;
import com.facebook.facecast.FacecastPreviewView;
import com.facebook.facecast.PreviewRenderer;
import com.facebook.facecast.PreviewRenderer2;
import com.facebook.facecast.ScreenCaptureUtil;
import com.facebook.facecast.plugin.commercialbreak.CommercialBreakBroadcastStateManager.CommercialBreakBroadcastState;
import com.facebook.facecast.plugin.commercialbreak.CommercialBreakBroadcastStateManager.CommercialBreakBroadcastStateChangeListener;
import com.facebook.facecastdisplay.FacecastUtil;
import com.facebook.fscam.abtest.FsCamGatekeepers;
import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.gl.ProgramFactory;
import com.facebook.inject.FbInjector;
import com.facebook.inject.InjectorLike;
import com.facebook.video.videostreaming.DisplayListenerDelegate;
import com.facebook.video.videostreaming.RecordingListenerDelegate;
import com.facebook.videocodec.effects.renderers.OverlayRendererProvider;
import com.google.common.base.Preconditions;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: brightness */
public class FacecastPreviewPlugin extends FacecastBasePlugin implements CommercialBreakBroadcastStateChangeListener {
    @Inject
    FacecastAnalyticsLogger f18453c;
    @Inject
    AbstractFbErrorReporter f18454d;
    @Inject
    ScreenCaptureUtil f18455e;
    @Inject
    FsCamGatekeepers f18456f;
    @Inject
    FacecastGLRendererManager f18457g;
    @Inject
    FacecastUtil f18458h;
    @Inject
    MonotonicClock f18459i;
    public final FacecastPreviewView f18460j;
    private final View f18461k;
    public PreviewRenderer f18462l;
    public FacecastCamera f18463m;
    public ScaleGestureDetector f18464n;
    public ZoomHandler f18465o;
    public Listener f18466p;

    /* compiled from: brightness */
    public interface Listener {
        void mo1412g();
    }

    /* compiled from: brightness */
    class C15821 implements OnTouchListener {
        final /* synthetic */ FacecastPreviewPlugin f18445a;

        C15821(FacecastPreviewPlugin facecastPreviewPlugin) {
            this.f18445a = facecastPreviewPlugin;
        }

        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() == 0 && this.f18445a.f18466p != null) {
                this.f18445a.f18466p.mo1412g();
            }
            this.f18445a.f18465o.sendMessage(this.f18445a.f18465o.obtainMessage(2, motionEvent));
            return true;
        }
    }

    /* compiled from: brightness */
    public class CameraZoomGestureDetector extends SimpleOnScaleGestureListener {
        final /* synthetic */ FacecastPreviewPlugin f18447a;
        private int f18448b;
        private int f18449c;
        private int f18450d;
        private float f18451e;

        public CameraZoomGestureDetector(FacecastPreviewPlugin facecastPreviewPlugin) {
            this.f18447a = facecastPreviewPlugin;
        }

        public boolean onScaleBegin(ScaleGestureDetector scaleGestureDetector) {
            this.f18448b = this.f18447a.f18463m.m21851e();
            this.f18449c = this.f18448b;
            this.f18450d = ((Camera) Preconditions.checkNotNull(this.f18447a.f18463m.f17982l)).getParameters().getMaxZoom();
            this.f18451e = scaleGestureDetector.getCurrentSpan();
            return true;
        }

        public boolean onScale(ScaleGestureDetector scaleGestureDetector) {
            int min = Math.min(this.f18450d, Math.max(0, ((int) (((scaleGestureDetector.getCurrentSpan() - this.f18451e) / ((float) this.f18447a.f18460j.getWidth())) * ((float) this.f18450d))) + this.f18448b));
            if (min != this.f18449c) {
                this.f18447a.f18463m.m21847a(4, Integer.valueOf(min));
            }
            this.f18449c = min;
            return true;
        }

        public void onScaleEnd(ScaleGestureDetector scaleGestureDetector) {
            FacecastAnalyticsLogger facecastAnalyticsLogger = this.f18447a.f18453c;
            int i = this.f18448b;
            int i2 = this.f18449c;
            Map hashMap = new HashMap();
            hashMap.put("previous_zoom_level", Integer.toString(i));
            hashMap.put("new_zoom_level", Integer.toString(i2));
            facecastAnalyticsLogger.m21965a(hashMap);
        }
    }

    /* compiled from: brightness */
    public enum EncoderSurfaceType {
        LIVE_STREAM,
        LOCAL_VIDEO;

        public final int toInt() {
            return ordinal();
        }

        public static EncoderSurfaceType getEncoderSurfaceType(int i) {
            return values()[i];
        }
    }

    /* compiled from: brightness */
    class ZoomHandler extends Handler {
        final /* synthetic */ FacecastPreviewPlugin f18452a;

        ZoomHandler(FacecastPreviewPlugin facecastPreviewPlugin, Looper looper) {
            this.f18452a = facecastPreviewPlugin;
            super(looper);
        }

        public void handleMessage(Message message) {
            int i = message.what;
            switch (i) {
                case 1:
                    FacecastPreviewPlugin facecastPreviewPlugin = this.f18452a;
                    facecastPreviewPlugin.f18464n = new ScaleGestureDetector(facecastPreviewPlugin.getContext(), new CameraZoomGestureDetector(facecastPreviewPlugin));
                    return;
                case 2:
                    FacecastPreviewPlugin.m22105a(this.f18452a, (MotionEvent) message.obj);
                    return;
                default:
                    throw new RuntimeException("Unhandled msg what=" + i);
            }
        }
    }

    public static void m22106a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        ((FacecastPreviewPlugin) obj).m22104a(FacecastAnalyticsLogger.m21959a(injectorLike), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike), new ScreenCaptureUtil((ExecutorService) ListeningScheduledExecutorService_ForNonUiThreadMethodAutoProvider.a(injectorLike)), new FsCamGatekeepers(GatekeeperStoreImplMethodAutoProvider.a(injectorLike)), new FacecastGLRendererManager(ProgramFactory.b(injectorLike), FacecastUtil.m3107b(injectorLike), (OverlayRendererProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(OverlayRendererProvider.class)), FacecastUtil.m3107b(injectorLike), (MonotonicClock) AwakeTimeSinceBootClockMethodAutoProvider.a(injectorLike));
    }

    private void m22104a(FacecastAnalyticsLogger facecastAnalyticsLogger, AbstractFbErrorReporter abstractFbErrorReporter, ScreenCaptureUtil screenCaptureUtil, FsCamGatekeepers fsCamGatekeepers, FacecastGLRendererManager facecastGLRendererManager, FacecastUtil facecastUtil, MonotonicClock monotonicClock) {
        this.f18453c = facecastAnalyticsLogger;
        this.f18454d = abstractFbErrorReporter;
        this.f18455e = screenCaptureUtil;
        this.f18456f = fsCamGatekeepers;
        this.f18457g = facecastGLRendererManager;
        this.f18458h = facecastUtil;
        this.f18459i = monotonicClock;
    }

    public FacecastPreviewPlugin(Context context) {
        this(context, null);
    }

    private FacecastPreviewPlugin(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private FacecastPreviewPlugin(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Class cls = FacecastPreviewPlugin.class;
        m22106a((Object) this, getContext());
        setContentView(2130904226);
        this.f18460j = (FacecastPreviewView) a(2131561635);
        this.f18461k = a(2131561705);
    }

    public final void m22111a(DisplayListenerDelegate displayListenerDelegate, RecordingListenerDelegate recordingListenerDelegate, float f) {
        FacecastGLRendererManager facecastGLRendererManager = this.f18458h.m3118o() ? this.f18457g : null;
        if (this.f18456f.a.a(142, false)) {
            this.f18462l = new PreviewRenderer2(displayListenerDelegate, null, recordingListenerDelegate, this.f18460j, this.f18455e);
        } else {
            this.f18462l = new PreviewRenderer(displayListenerDelegate, recordingListenerDelegate, this.f18460j, this.f18455e, facecastGLRendererManager, this.f18459i, f);
        }
        this.f18460j.getHolder().addCallback(this.f18462l);
    }

    public final void m22108a(Looper looper) {
        this.f18462l.mo1400a(looper);
        this.f18465o = new ZoomHandler(this, looper);
    }

    public final void m22107a(int i, long j) {
        this.f18462l.mo1399a(i, j);
    }

    public final void m22109a(FacecastCamera facecastCamera) {
        this.f18463m = facecastCamera;
        this.f18462l.mo1404d();
        this.f18462l.mo1398a(facecastCamera.f17979i, facecastCamera.f17980j);
        if (this.f18463m.m21850d()) {
            this.f18465o.sendMessage(this.f18465o.obtainMessage(1));
            this.f18460j.m21876a(new C15821(this));
        }
    }

    public final void m22113h() {
        this.f18462l.mo1397a();
    }

    public final void m22112b(FacecastCamera facecastCamera) {
        this.f18462l.mo1398a(facecastCamera.f17979i, facecastCamera.f17980j);
    }

    public final void mo1386a(CommercialBreakBroadcastState commercialBreakBroadcastState, CommercialBreakBroadcastState commercialBreakBroadcastState2) {
        switch (commercialBreakBroadcastState) {
            case COMMERCIAL_BREAK_BROADCAST_PLAYING:
                this.f18461k.setVisibility(0);
                return;
            case COMMERCIAL_BREAK_BROADCAST_FINISH:
                this.f18461k.setVisibility(8);
                return;
            default:
                return;
        }
    }

    public static void m22105a(FacecastPreviewPlugin facecastPreviewPlugin, MotionEvent motionEvent) {
        try {
            facecastPreviewPlugin.f18464n.onTouchEvent(motionEvent);
        } catch (IllegalArgumentException e) {
            facecastPreviewPlugin.f18454d.a("broadcaster_zoom_illegal_argument_exception", e.getMessage());
        }
    }
}
