package com.facebook.facecast.plugin.commercialbreak;

import android.content.Context;
import android.os.CountDownTimer;
import android.util.AttributeSet;
import android.view.View;
import com.facebook.facecast.abtest.FacecastBroadcasterCommercialBreakConfig;
import com.facebook.facecast.plugin.FacecastBasePlugin;
import com.facebook.facecast.plugin.FacecastRecordingAggregatePlugin.CommercialBreakController;
import com.facebook.facecast.plugin.commercialbreak.CommercialBreakBroadcastStateManager.CommercialBreakBroadcastState;
import com.facebook.facecast.plugin.commercialbreak.CommercialBreakBroadcastStateManager.CommercialBreakBroadcastStateChangeListener;
import com.facebook.inject.FbInjector;
import com.facebook.sounds.FBSoundUtil;
import com.facebook.sounds.fb4a.Fb4aSoundUtil;
import com.facebook.widget.text.BetterTextView;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: biography */
public class FacecastPlayCommercialBreakPlugin extends FacecastBasePlugin implements CommercialBreakBroadcastStateChangeListener {
    @Inject
    public FBSoundUtil f18596c;
    @Inject
    public FacecastBroadcasterCommercialBreakConfig f18597d;
    public float f18598e;
    public final BetterTextView f18599f;
    public final long f18600g;
    public final View f18601h;
    @Nullable
    public CommercialBreakController f18602i;
    @Nullable
    public CommercialBreakCountdownTimer f18603j;

    /* compiled from: biography */
    public class CommercialBreakCountdownTimer extends CountDownTimer {
        final /* synthetic */ FacecastPlayCommercialBreakPlugin f18595a;

        public CommercialBreakCountdownTimer(FacecastPlayCommercialBreakPlugin facecastPlayCommercialBreakPlugin) {
            this.f18595a = facecastPlayCommercialBreakPlugin;
            super(facecastPlayCommercialBreakPlugin.f18600g, 500);
        }

        public void onTick(long j) {
            CharSequence valueOf = String.valueOf((j / 1000) + 1);
            if (!this.f18595a.f18599f.getText().equals(valueOf)) {
                this.f18595a.f18599f.setText(valueOf);
                this.f18595a.f18596c.a(2131165218, 2, this.f18595a.f18598e);
            }
            if (j < 1000) {
                FacecastPlayCommercialBreakPlugin.m22209c(this.f18595a.f18599f);
                FacecastPlayCommercialBreakPlugin.m22209c(this.f18595a.f18601h);
            }
        }

        public void onFinish() {
            if (this.f18595a.f18602i != null) {
                CommercialBreakController commercialBreakController = this.f18595a.f18602i;
                if (commercialBreakController.f18475a.f18495r != null) {
                    commercialBreakController.f18475a.f18495r.l();
                }
                commercialBreakController.f18475a.f18483f.m22185a(CommercialBreakBroadcastState.COMMERCIAL_BREAK_BROADCAST_FINISH);
                commercialBreakController.f18475a.f18486i.m22198h();
            }
        }
    }

    public static void m22207a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        FacecastPlayCommercialBreakPlugin facecastPlayCommercialBreakPlugin = (FacecastPlayCommercialBreakPlugin) obj;
        FBSoundUtil fBSoundUtil = (FBSoundUtil) Fb4aSoundUtil.a(fbInjector);
        FacecastBroadcasterCommercialBreakConfig a = FacecastBroadcasterCommercialBreakConfig.m3058a(fbInjector);
        facecastPlayCommercialBreakPlugin.f18596c = fBSoundUtil;
        facecastPlayCommercialBreakPlugin.f18597d = a;
    }

    public FacecastPlayCommercialBreakPlugin(Context context) {
        this(context, null);
    }

    private FacecastPlayCommercialBreakPlugin(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private FacecastPlayCommercialBreakPlugin(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f18598e = 1.0f;
        Class cls = FacecastPlayCommercialBreakPlugin.class;
        m22207a((Object) this, getContext());
        setContentView(2130904223);
        this.f18599f = (BetterTextView) a(2131561699);
        this.f18601h = a(2131561700);
        this.f18600g = (long) this.f18597d.f2803e;
    }

    public final void mo1386a(CommercialBreakBroadcastState commercialBreakBroadcastState, CommercialBreakBroadcastState commercialBreakBroadcastState2) {
        int[] iArr = C16011.f18594a;
        commercialBreakBroadcastState2.ordinal();
        switch (commercialBreakBroadcastState) {
            case COMMERCIAL_BREAK_BROADCAST_PLAYING:
                if (commercialBreakBroadcastState2 != CommercialBreakBroadcastState.COMMERCIAL_BREAK_BROADCAST_INTERRUPTED) {
                    this.f18603j = new CommercialBreakCountdownTimer(this);
                    this.f18603j.start();
                    m22208b(this.f18599f);
                    m22208b(this.f18601h);
                    return;
                }
                this.f18598e = 1.0f;
                return;
            case COMMERCIAL_BREAK_BROADCAST_FINISH:
                if (this.f18603j != null) {
                    this.f18603j.cancel();
                }
                return;
            case COMMERCIAL_BREAK_BROADCAST_INTERRUPTED:
                this.f18598e = 0.0f;
                return;
            default:
                return;
        }
    }

    public static void m22208b(View view) {
        view.setAlpha(0.0f);
        view.setScaleX(0.8f);
        view.setScaleY(0.8f);
        view.animate().alpha(1.0f).scaleX(1.0f).scaleY(1.0f).setDuration(500);
    }

    public static void m22209c(View view) {
        view.animate().alpha(0.0f).scaleX(0.0f).scaleY(0.0f).setDuration(500);
    }
}
