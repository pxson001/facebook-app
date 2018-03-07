package com.facebook.facecast.plugin.commercialbreak;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.facecast.FacecastStateManager;
import com.facebook.facecast.abtest.FacecastBroadcasterCommercialBreakConfig;
import com.facebook.facecast.plugin.FacecastAggregatedBasePlugin;
import com.facebook.facecast.plugin.FacecastRecordingAggregatePlugin.CommercialBreakController;
import com.facebook.facecast.plugin.commercialbreak.CommercialBreakBroadcastStateManager.CommercialBreakBroadcastState;
import com.facebook.facecast.plugin.commercialbreak.CommercialBreakBroadcastStateManager.CommercialBreakBroadcastStateChangeListener;
import com.facebook.facecast.plugin.commercialbreak.FacecastCommercialBreakPromptPlugin.FacecastCommercialBreakPromptListener;
import com.facebook.facecast.plugin.commercialbreak.FacecastPlayCommercialBreakPlugin.FacecastPlayCommercialBreakListener;
import com.facebook.facecast.plugin.commercialbreak.FacecastPreCommercialBreakCountdownPlugin.C16032;
import com.facebook.facecast.plugin.commercialbreak.FacecastPreCommercialBreakCountdownPlugin.FacecastPreCommercialBreakCountdownListener;
import com.facebook.facecast.plugin.commercialbreak.FacecastStartCommercialBreakPlugin.CommercialBreakEligibility;
import com.facebook.facecast.plugin.commercialbreak.FacecastStartCommercialBreakPlugin.FacecastStartCommercialBreakListener;
import com.facebook.inject.FbInjector;
import com.facebook.inject.InjectorLike;
import com.facebook.video.commercialbreak.CommercialBreakAnimationUtil;
import com.facebook.video.commercialbreak.CommercialBreakMessagePublisher;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: ble */
public class FacecastCommercialBreakAggregatePlugin extends FacecastAggregatedBasePlugin implements CommercialBreakBroadcastStateChangeListener {
    @Inject
    public FacecastBroadcasterCommercialBreakConfig f18579c;
    @Inject
    public CommercialBreakMessagePublisher f18580d;
    @Inject
    public CommercialBreakBroadcastStateManager f18581e;
    public final FacecastCommercialBreakPromptPlugin f18582f;
    public final FacecastPreCommercialBreakCountdownPlugin f18583g;
    public final FacecastPlayCommercialBreakPlugin f18584h;
    private final int f18585i;
    private final int f18586j;
    public final long f18587k;
    public FacecastStartCommercialBreakPlugin f18588l;

    public static void m22199a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        FacecastCommercialBreakAggregatePlugin facecastCommercialBreakAggregatePlugin = (FacecastCommercialBreakAggregatePlugin) obj;
        FacecastBroadcasterCommercialBreakConfig a = FacecastBroadcasterCommercialBreakConfig.m3058a(injectorLike);
        CommercialBreakMessagePublisher a2 = CommercialBreakMessagePublisher.a(injectorLike);
        CommercialBreakBroadcastStateManager a3 = CommercialBreakBroadcastStateManager.m22183a(injectorLike);
        facecastCommercialBreakAggregatePlugin.f18579c = a;
        facecastCommercialBreakAggregatePlugin.f18580d = a2;
        facecastCommercialBreakAggregatePlugin.f18581e = a3;
    }

    public FacecastCommercialBreakAggregatePlugin(Context context) {
        this(context, null);
    }

    private FacecastCommercialBreakAggregatePlugin(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private FacecastCommercialBreakAggregatePlugin(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Class cls = FacecastCommercialBreakAggregatePlugin.class;
        m22199a((Object) this, getContext());
        this.f18582f = new FacecastCommercialBreakPromptPlugin(context);
        this.f18583g = new FacecastPreCommercialBreakCountdownPlugin(context);
        this.f18584h = new FacecastPlayCommercialBreakPlugin(context);
        this.f18585i = this.f18579c.f2800b;
        this.f18586j = this.f18579c.f2801c;
        this.f18587k = (long) this.f18579c.f2803e;
        m21957a(this.f18582f, this.f18583g, this.f18584h);
        this.f18581e.m22186a(this.f18583g);
        this.f18581e.m22186a(this.f18584h);
    }

    public final <T extends FacecastStartCommercialBreakListener & FacecastCommercialBreakPromptListener & FacecastPreCommercialBreakCountdownListener & FacecastPlayCommercialBreakListener> void m22201a(View view, T t) {
        this.f18588l = (FacecastStartCommercialBreakPlugin) view.findViewById(2131561720);
        this.f18581e.m22186a(this.f18588l);
        this.f18588l.m22228a((FacecastStartCommercialBreakListener) t);
        this.f18582f.f18593e = (CommercialBreakController) t;
        this.f18583g.f18614i = (CommercialBreakController) t;
        this.f18584h.f18602i = (CommercialBreakController) t;
    }

    protected final void mo1408a(ViewGroup viewGroup, FacecastStateManager facecastStateManager) {
        super.mo1408a(viewGroup, facecastStateManager);
        this.f18581e.m22188b(this.f18588l);
        this.f18581e.m22188b(this.f18583g);
        this.f18581e.m22188b(this.f18584h);
    }

    public final CommercialBreakEligibility m22200a(long j, long j2) {
        if (this.f18581e.f18570b == CommercialBreakBroadcastState.COMMERCIAL_BREAK_BROADCAST_PLAYING) {
            return CommercialBreakEligibility.IN_COMMERCIAL_BREAK;
        }
        if (j < ((long) this.f18585i) * 1000) {
            return CommercialBreakEligibility.INSUFFICIENT_BEGINNING_LIVE_TIME;
        }
        if (j2 <= 0 || j - j2 >= ((long) this.f18586j) * 1000) {
            return CommercialBreakEligibility.ELIGIBLE;
        }
        return CommercialBreakEligibility.TOO_CLOSE_TO_PREVIOUS_COMMERCIAL_BREAK;
    }

    public final void mo1386a(CommercialBreakBroadcastState commercialBreakBroadcastState, CommercialBreakBroadcastState commercialBreakBroadcastState2) {
        switch (commercialBreakBroadcastState2) {
            case COMMERCIAL_BREAK_BROADCAST_PROMPT:
                FacecastCommercialBreakPromptPlugin facecastCommercialBreakPromptPlugin = this.f18582f;
                facecastCommercialBreakPromptPlugin.f18592d.animate().translationYBy((float) facecastCommercialBreakPromptPlugin.f18592d.getHeight()).setDuration(600).setInterpolator(CommercialBreakAnimationUtil.a).start();
                break;
            case COMMERCIAL_BREAK_BROADCAST_PRE_COUNTDOWN:
                FacecastPreCommercialBreakCountdownPlugin facecastPreCommercialBreakCountdownPlugin = this.f18583g;
                facecastPreCommercialBreakCountdownPlugin.f18611f.animate().translationYBy((float) facecastPreCommercialBreakCountdownPlugin.f18611f.getHeight()).setDuration(600).setInterpolator(CommercialBreakAnimationUtil.a).setListener(new C16032(facecastPreCommercialBreakCountdownPlugin)).start();
                break;
        }
        switch (commercialBreakBroadcastState) {
            case COMMERCIAL_BREAK_BROADCAST_PROMPT:
                this.f18582f.setVisibility(0);
                facecastCommercialBreakPromptPlugin = this.f18582f;
                int height = facecastCommercialBreakPromptPlugin.f18592d.getHeight();
                facecastCommercialBreakPromptPlugin.f18592d.setTranslationY((float) height);
                facecastCommercialBreakPromptPlugin.f18592d.animate().translationYBy((float) (-height)).setDuration(600).setInterpolator(CommercialBreakAnimationUtil.a).start();
                return;
            case COMMERCIAL_BREAK_BROADCAST_PRE_COUNTDOWN:
                this.f18580d.a(this.f18587k);
                this.f18583g.setVisibility(0);
                return;
            case COMMERCIAL_BREAK_BROADCAST_PLAYING:
                this.f18584h.setVisibility(0);
                return;
            case COMMERCIAL_BREAK_BROADCAST_FINISH:
                this.f18588l.setVisibility(0);
                this.f18584h.setVisibility(8);
                return;
            default:
                return;
        }
    }

    public final void m22204a(CommercialBreakEligibility commercialBreakEligibility, long j, long j2) {
        this.f18588l.m22227a(commercialBreakEligibility, this.f18585i, this.f18586j, j, j2);
    }
}
