package com.facebook.facecast.plugin;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.ShapeDrawable.ShaderFactory;
import android.graphics.drawable.shapes.RectShape;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.facecast.FacecastStateManager;
import com.facebook.facecast.FacecastStateManager.FacecastBroadcastState;
import com.facebook.facecast.FacecastStateManager.FacecastStateChangeListener;
import com.facebook.facecast.plugin.FacecastEndTimerView.FacecastEndTimerViewListener;
import com.facebook.facecast.plugin.commercialbreak.CommercialBreakBroadcastStateManager.CommercialBreakBroadcastState;
import com.facebook.facecast.plugin.commercialbreak.CommercialBreakBroadcastStateManager.CommercialBreakBroadcastStateChangeListener;
import com.facebook.facecastdisplay.LiveStatusPoller;
import com.facebook.facecastdisplay.LiveStatusPoller.LiveStatusListener;
import com.facebook.facecastdisplay.LiveVideoStatusMessage;
import com.facebook.facecastdisplay.LiveVideoStatusMessage.VideoState;
import com.facebook.facecastdisplay.LiveVideoStatusView;
import com.facebook.facecastdisplay.LiveVideoStatusView.IndicatorType;
import com.facebook.facecastdisplay.protocol.FetchVideoBroadcastQueryModels.VideoBroadcastFragmentModel;
import com.facebook.inject.FbInjector;
import com.google.common.base.Preconditions;
import java.util.Map;
import javax.inject.Inject;

@TargetApi(18)
/* compiled from: borderLeftColor */
public class FacecastLiveVideoStatusPlugin extends FacecastBasePlugin implements FacecastStateChangeListener, FacecastEndTimerViewListener, CommercialBreakBroadcastStateChangeListener, LiveStatusListener {
    @Inject
    public LiveStatusPoller f18439c;
    public final LiveVideoStatusView f18440d;
    private final LiveVideoStatusMessage f18441e;
    public final FacecastEndTimerView f18442f;
    private final View f18443g;
    private boolean f18444h;

    /* compiled from: borderLeftColor */
    class BlackOverlayDrawable extends ShapeDrawable {
        public BlackOverlayDrawable(Resources resources) {
            super(new RectShape());
            setShaderFactory(m22093a(resources));
        }

        private ShaderFactory m22093a(Resources resources) {
            final int[] iArr = new int[]{resources.getColor(2131362624), 0};
            final float[] fArr = new float[]{0.0f, 1.0f};
            return new ShaderFactory(this) {
                final /* synthetic */ BlackOverlayDrawable f18438c;

                public Shader resize(int i, int i2) {
                    return new LinearGradient(0.0f, 0.0f, 0.0f, (float) i2, iArr, fArr, TileMode.CLAMP);
                }
            };
        }
    }

    public static void m22094a(Object obj, Context context) {
        ((FacecastLiveVideoStatusPlugin) obj).f18439c = LiveStatusPoller.b(FbInjector.get(context));
    }

    public FacecastLiveVideoStatusPlugin(Context context) {
        this(context, null);
    }

    private FacecastLiveVideoStatusPlugin(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private FacecastLiveVideoStatusPlugin(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Class cls = FacecastLiveVideoStatusPlugin.class;
        m22094a((Object) this, getContext());
        setContentView(2130904222);
        this.f18440d = (LiveVideoStatusView) a(2131561696);
        this.f18440d.setIsLiveNow(true);
        this.f18439c.g = this;
        this.f18441e = (LiveVideoStatusMessage) a(2131561697);
        this.f18442f = (FacecastEndTimerView) a(2131561694);
        this.f18443g = a(2131561695);
        this.f18443g.setBackground(new BlackOverlayDrawable(context.getResources()));
        this.f18440d.m22563b();
    }

    protected final void hE_() {
        super.hE_();
        this.f18166b.m21882a((FacecastStateChangeListener) this);
        this.f18440d.f18978f.start();
        this.f18441e.f18967a.start();
        this.f18442f.f18400e.start();
    }

    protected final void mo1408a(ViewGroup viewGroup, FacecastStateManager facecastStateManager) {
        super.mo1408a(viewGroup, facecastStateManager);
        facecastStateManager.m21884b((FacecastStateChangeListener) this);
        this.f18440d.f18978f.end();
        this.f18441e.f18967a.end();
        this.f18442f.f18400e.end();
    }

    public final void hC_() {
        this.f18166b.m21883b(FacecastBroadcastState.FACECAST_BROADCAST_STATE_FINISHED);
    }

    public final void mo1421a(boolean z) {
        int i = 8;
        LiveVideoStatusMessage liveVideoStatusMessage = this.f18441e;
        int i2 = (z || !this.f18444h) ? 8 : 0;
        liveVideoStatusMessage.setVisibility(i2);
        View view = this.f18443g;
        if (z || this.f18444h) {
            i = 0;
        }
        view.setVisibility(i);
        if (z) {
            this.f18440d.m22562a(false);
        } else {
            this.f18440d.m22564c();
        }
    }

    public Map<String, String> getLoggingInfo() {
        return ((LiveStatusPoller) Preconditions.checkNotNull(this.f18439c)).b();
    }

    public void setWeakConnection(boolean z) {
        this.f18444h = z;
        if (z) {
            this.f18441e.setLiveText(VideoState.WEAK);
            this.f18441e.setVisibility(0);
            this.f18443g.setVisibility(0);
            return;
        }
        this.f18441e.setVisibility(8);
        this.f18443g.setVisibility(8);
    }

    public final void mo1385a(FacecastBroadcastState facecastBroadcastState, FacecastBroadcastState facecastBroadcastState2) {
        this.f18440d.setVisibility(facecastBroadcastState == FacecastBroadcastState.FACECAST_BROADCAST_STATE_RECORDING ? 0 : 8);
    }

    public final void m22098a(VideoBroadcastFragmentModel videoBroadcastFragmentModel) {
    }

    public final void m22101b(VideoBroadcastFragmentModel videoBroadcastFragmentModel) {
    }

    public final void m22099a(String str) {
    }

    public final void r_(int i) {
        this.f18440d.setViewerCount(i);
    }

    public final void mo1386a(CommercialBreakBroadcastState commercialBreakBroadcastState, CommercialBreakBroadcastState commercialBreakBroadcastState2) {
        int[] iArr = C15801.f18435a;
        commercialBreakBroadcastState2.ordinal();
        switch (commercialBreakBroadcastState) {
            case COMMERCIAL_BREAK_BROADCAST_PLAYING:
                this.f18440d.setIndicatorType(IndicatorType.BROADCAST_COMMERCIAL_BREAK);
                return;
            case COMMERCIAL_BREAK_BROADCAST_FINISH:
                this.f18440d.setIndicatorType(IndicatorType.LIVE);
                return;
            default:
                return;
        }
    }
}
