package com.facebook.facecast.plugin;

import android.content.Context;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.ViewGroup;
import com.facebook.common.executors.ForUiThread;
import com.facebook.common.executors.Handler_ForUiThreadMethodAutoProvider;
import com.facebook.facecast.FacecastStateManager;
import com.facebook.facecast.FacecastStateManager.FacecastBroadcastState;
import com.facebook.facecast.FacecastStateManager.FacecastStateChangeListener;
import com.facebook.facecast.plugin.FacecastEndTimerView.FacecastEndTimerViewListener;
import com.facebook.facecastdisplay.LiveStatusPoller;
import com.facebook.facecastdisplay.LiveStatusPoller.LiveStatusListener;
import com.facebook.facecastdisplay.LiveStatusView;
import com.facebook.facecastdisplay.LiveStatusView.VideoState;
import com.facebook.facecastdisplay.protocol.FetchVideoBroadcastQueryModels.VideoBroadcastFragmentModel;
import com.facebook.inject.FbInjector;
import com.facebook.tools.dextr.runtime.detour.HandlerDetour;
import java.util.Map;
import javax.inject.Inject;

/* compiled from: borderLeftWidth */
public class FacecastLiveStatusPlugin extends FacecastBasePlugin implements FacecastStateChangeListener, FacecastEndTimerViewListener, LiveStatusListener {
    @Inject
    public LiveStatusPoller f18430c;
    @Inject
    @ForUiThread
    public Handler f18431d;
    public final LiveStatusView f18432e;
    public final FacecastEndTimerView f18433f;
    private boolean f18434g;

    /* compiled from: borderLeftWidth */
    class C15781 implements Runnable {
        final /* synthetic */ FacecastLiveStatusPlugin f18428a;

        C15781(FacecastLiveStatusPlugin facecastLiveStatusPlugin) {
            this.f18428a = facecastLiveStatusPlugin;
        }

        public void run() {
            FacecastLiveStatusPlugin.m22085h(this.f18428a);
        }
    }

    public static void m22084a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        FacecastLiveStatusPlugin facecastLiveStatusPlugin = (FacecastLiveStatusPlugin) obj;
        LiveStatusPoller b = LiveStatusPoller.b(fbInjector);
        Handler b2 = Handler_ForUiThreadMethodAutoProvider.b(fbInjector);
        facecastLiveStatusPlugin.f18430c = b;
        facecastLiveStatusPlugin.f18431d = b2;
    }

    public FacecastLiveStatusPlugin(Context context) {
        this(context, null);
    }

    private FacecastLiveStatusPlugin(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private FacecastLiveStatusPlugin(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Class cls = FacecastLiveStatusPlugin.class;
        m22084a((Object) this, getContext());
        setContentView(2130904221);
        this.f18432e = (LiveStatusView) a(2131561693);
        this.f18433f = (FacecastEndTimerView) a(2131561694);
        this.f18432e.m22528b();
        this.f18430c.g = this;
    }

    protected final void hE_() {
        super.hE_();
        this.f18166b.m21882a((FacecastStateChangeListener) this);
    }

    protected final void mo1408a(ViewGroup viewGroup, FacecastStateManager facecastStateManager) {
        super.mo1408a(viewGroup, facecastStateManager);
        facecastStateManager.m21884b((FacecastStateChangeListener) this);
    }

    public final void m22086a(long j) {
        this.f18433f.m22077a(j, (FacecastEndTimerViewListener) this);
        this.f18432e.m22526a();
    }

    public final void mo1385a(FacecastBroadcastState facecastBroadcastState, FacecastBroadcastState facecastBroadcastState2) {
        switch (facecastBroadcastState) {
            case FACECAST_BROADCAST_STATE_INTERRUPTED:
                this.f18432e.m22527a(VideoState.INTERRUPT);
                m21953f();
                return;
            case FACECAST_BROADCAST_STATE_NETWORK_FAILURE:
                this.f18432e.m22527a(VideoState.RECONNECT);
                m21953f();
                return;
            case FACECAST_BROADCAST_STATE_RECORDING:
                this.f18432e.m22527a(VideoState.PLAYING);
                return;
            default:
                return;
        }
    }

    public final void hC_() {
        this.f18166b.m21883b(FacecastBroadcastState.FACECAST_BROADCAST_STATE_FINISHED);
    }

    public final void mo1421a(boolean z) {
        this.f18432e.setVisibility(z ? 8 : 0);
    }

    public Map<String, String> getLoggingInfo() {
        return this.f18430c.b();
    }

    public void setWeakConnection(boolean z) {
        if (z) {
            this.f18434g = true;
            m22085h(this);
            return;
        }
        this.f18432e.m22527a(VideoState.PLAYING);
        this.f18431d.removeCallbacksAndMessages(null);
    }

    public static void m22085h(FacecastLiveStatusPlugin facecastLiveStatusPlugin) {
        int i;
        if (facecastLiveStatusPlugin.f18434g) {
            facecastLiveStatusPlugin.f18432e.m22527a(VideoState.WEAK);
            i = 2;
        } else {
            facecastLiveStatusPlugin.f18432e.m22527a(VideoState.PLAYING);
            i = 8;
        }
        facecastLiveStatusPlugin.f18434g = !facecastLiveStatusPlugin.f18434g;
        HandlerDetour.b(facecastLiveStatusPlugin.f18431d, new C15781(facecastLiveStatusPlugin), ((long) i) * 1000, -1229500633);
    }

    public final void m22089a(VideoBroadcastFragmentModel videoBroadcastFragmentModel) {
    }

    public final void m22092b(VideoBroadcastFragmentModel videoBroadcastFragmentModel) {
    }

    public final void m22090a(String str) {
    }

    public final void r_(int i) {
        this.f18432e.setViewerCount(i);
    }
}
