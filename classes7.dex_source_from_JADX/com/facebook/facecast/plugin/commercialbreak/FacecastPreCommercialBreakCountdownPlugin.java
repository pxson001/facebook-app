package com.facebook.facecast.plugin.commercialbreak;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.os.CountDownTimer;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import com.facebook.facecast.abtest.FacecastBroadcasterCommercialBreakConfig;
import com.facebook.facecast.plugin.FacecastBasePlugin;
import com.facebook.facecast.plugin.FacecastRecordingAggregatePlugin.CommercialBreakController;
import com.facebook.facecast.plugin.commercialbreak.CommercialBreakBroadcastStateManager.CommercialBreakBroadcastState;
import com.facebook.facecast.plugin.commercialbreak.CommercialBreakBroadcastStateManager.CommercialBreakBroadcastStateChangeListener;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.resources.ui.FbButton;
import com.facebook.ui.animations.SpringAnimator;
import com.facebook.video.commercialbreak.CommercialBreakAnimationUtil;
import com.facebook.widget.text.BetterTextView;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: bio_impression */
public class FacecastPreCommercialBreakCountdownPlugin extends FacecastBasePlugin implements CommercialBreakBroadcastStateChangeListener {
    @Inject
    public FacecastBroadcasterCommercialBreakConfig f18608c;
    public final BetterTextView f18609d;
    public final long f18610e;
    public final LinearLayout f18611f;
    private final BetterTextView f18612g;
    private final FbButton f18613h;
    @Nullable
    public CommercialBreakController f18614i;
    @Nullable
    public PreCommercialBreakCountdownTimer f18615j;

    /* compiled from: bio_impression */
    class C16021 implements OnClickListener {
        final /* synthetic */ FacecastPreCommercialBreakCountdownPlugin f18604a;

        C16021(FacecastPreCommercialBreakCountdownPlugin facecastPreCommercialBreakCountdownPlugin) {
            this.f18604a = facecastPreCommercialBreakCountdownPlugin;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -1572576712);
            if (this.f18604a.f18614i != null) {
                CommercialBreakController commercialBreakController = this.f18604a.f18614i;
                commercialBreakController.f18475a.f18483f.m22185a(CommercialBreakBroadcastState.COMMERCIAL_BREAK_BROADCAST_ELIGIBLE);
                commercialBreakController.f18475a.f18486i.m22196f();
            }
            Logger.a(2, EntryType.UI_INPUT_END, -1473079140, a);
        }
    }

    /* compiled from: bio_impression */
    public class C16032 extends AnimatorListenerAdapter {
        final /* synthetic */ FacecastPreCommercialBreakCountdownPlugin f18605a;

        public C16032(FacecastPreCommercialBreakCountdownPlugin facecastPreCommercialBreakCountdownPlugin) {
            this.f18605a = facecastPreCommercialBreakCountdownPlugin;
        }

        public void onAnimationEnd(Animator animator) {
            this.f18605a.f18611f.setTranslationY(0.0f);
            this.f18605a.f18611f.setVisibility(8);
        }
    }

    /* compiled from: bio_impression */
    class PreCommercialBreakCountdownTimer extends CountDownTimer {
        final /* synthetic */ FacecastPreCommercialBreakCountdownPlugin f18607a;

        public PreCommercialBreakCountdownTimer(FacecastPreCommercialBreakCountdownPlugin facecastPreCommercialBreakCountdownPlugin) {
            this.f18607a = facecastPreCommercialBreakCountdownPlugin;
            super(facecastPreCommercialBreakCountdownPlugin.f18610e, 500);
        }

        public void onTick(long j) {
            CharSequence valueOf = String.valueOf((j / 1000) + 1);
            if (!this.f18607a.f18609d.getText().equals(valueOf)) {
                this.f18607a.f18609d.setText(valueOf);
            }
        }

        public void onFinish() {
            if (this.f18607a.f18614i != null) {
                CommercialBreakController commercialBreakController = this.f18607a.f18614i;
                commercialBreakController.f18475a.f18478B = commercialBreakController.f18475a.f18477A;
                commercialBreakController.f18475a.f18483f.m22185a(CommercialBreakBroadcastState.COMMERCIAL_BREAK_BROADCAST_PLAYING);
                commercialBreakController.f18475a.f18486i.m22197g();
            }
        }
    }

    public static void m22211a(Object obj, Context context) {
        ((FacecastPreCommercialBreakCountdownPlugin) obj).f18608c = FacecastBroadcasterCommercialBreakConfig.m3058a(FbInjector.get(context));
    }

    public FacecastPreCommercialBreakCountdownPlugin(Context context) {
        this(context, null);
    }

    private FacecastPreCommercialBreakCountdownPlugin(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private FacecastPreCommercialBreakCountdownPlugin(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Class cls = FacecastPreCommercialBreakCountdownPlugin.class;
        m22211a((Object) this, getContext());
        setContentView(2130904224);
        this.f18611f = (LinearLayout) a(2131561701);
        this.f18609d = (BetterTextView) a(2131561702);
        this.f18612g = (BetterTextView) a(2131561703);
        int i2 = context.getResources().getDisplayMetrics().densityDpi;
        if (i2 > 640) {
            i2 = 110;
        } else if (i2 >= 640 || i2 <= 480) {
            if (i2 >= 480 || i2 <= 320) {
                if (i2 < 320 && i2 > 240) {
                    i2 = 80;
                } else if (i2 < 240 && i2 > 160) {
                    i2 = 60;
                } else if (i2 < 160 && i2 > 120) {
                    i2 = 40;
                }
            }
            i2 = 90;
        } else {
            i2 = 100;
        }
        this.f18609d.setTextSize(1, (float) i2);
        this.f18613h = (FbButton) a(2131561704);
        this.f18613h.setOnClickListener(new C16021(this));
        this.f18610e = ((long) this.f18608c.f2802d) * 1000;
    }

    public final void mo1386a(CommercialBreakBroadcastState commercialBreakBroadcastState, CommercialBreakBroadcastState commercialBreakBroadcastState2) {
        switch (commercialBreakBroadcastState2) {
            case COMMERCIAL_BREAK_BROADCAST_PRE_COUNTDOWN:
                if (this.f18615j != null) {
                    this.f18615j.cancel();
                }
                this.f18609d.setText("");
                break;
        }
        switch (commercialBreakBroadcastState) {
            case COMMERCIAL_BREAK_BROADCAST_PRE_COUNTDOWN:
                m22212h();
                return;
            default:
                return;
        }
    }

    private void m22212h() {
        this.f18613h.setTextColor(getResources().getColor(2131362106));
        this.f18615j = new PreCommercialBreakCountdownTimer(this);
        this.f18615j.start();
        SpringAnimator a = CommercialBreakAnimationUtil.a(SpringAnimator.a(this.f18609d, "scaleX", 0.5f, 1.0f));
        SpringAnimator a2 = CommercialBreakAnimationUtil.a(SpringAnimator.a(this.f18609d, "scaleY", 0.5f, 1.0f));
        SpringAnimator a3 = CommercialBreakAnimationUtil.a(SpringAnimator.a(this.f18609d, "alpha", 0.0f, 1.0f));
        SpringAnimator a4 = CommercialBreakAnimationUtil.a(SpringAnimator.a(this.f18612g, "scaleX", 0.5f, 1.0f));
        SpringAnimator a5 = CommercialBreakAnimationUtil.a(SpringAnimator.a(this.f18612g, "scaleY", 0.5f, 1.0f));
        SpringAnimator a6 = CommercialBreakAnimationUtil.a(SpringAnimator.a(this.f18612g, "alpha", 0.0f, 1.0f));
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(new Animator[]{a, a2, a3, a4, a5, a6});
        animatorSet.start();
        ObjectAnimator ofInt = ObjectAnimator.ofInt(this.f18613h, "textColor", new int[]{getResources().getColor(2131362084)});
        ofInt.setDuration(600);
        ofInt.setEvaluator(new ArgbEvaluator());
        ofInt.start();
    }
}
