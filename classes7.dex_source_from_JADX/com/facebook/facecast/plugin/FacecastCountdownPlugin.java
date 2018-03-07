package com.facebook.facecast.plugin;

import android.content.Context;
import android.os.CountDownTimer;
import android.util.AttributeSet;
import com.facebook.facecast.FacecastStateManager.FacecastBroadcastState;
import com.facebook.inject.FbInjector;
import com.facebook.sounds.FBSoundUtil;
import com.facebook.sounds.fb4a.Fb4aSoundUtil;
import com.facebook.widget.text.BetterTextView;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: boxOnly */
public class FacecastCountdownPlugin extends FacecastBasePlugin {
    @Inject
    public FBSoundUtil f18241c;
    public final BetterTextView f18242d;
    @Nullable
    public FacecastCountdownTimer f18243e;

    /* compiled from: boxOnly */
    public class FacecastCountdownTimer extends CountDownTimer {
        final /* synthetic */ FacecastCountdownPlugin f18240a;

        public FacecastCountdownTimer(FacecastCountdownPlugin facecastCountdownPlugin) {
            this.f18240a = facecastCountdownPlugin;
            super(3000, 500);
        }

        public void onTick(long j) {
            CharSequence valueOf = String.valueOf((j / 1000) + 1);
            if (!this.f18240a.f18242d.getText().equals(valueOf)) {
                this.f18240a.f18242d.setText(valueOf);
                this.f18240a.f18241c.a(2131165218, 2, 0.15f);
            }
        }

        public void onFinish() {
            this.f18240a.f18166b.m21883b(FacecastBroadcastState.FACECAST_BROADCAST_STATE_RECORDING);
        }
    }

    public static void m21998a(Object obj, Context context) {
        ((FacecastCountdownPlugin) obj).f18241c = (FBSoundUtil) Fb4aSoundUtil.a(FbInjector.get(context));
    }

    public FacecastCountdownPlugin(Context context) {
        this(context, null);
    }

    private FacecastCountdownPlugin(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private FacecastCountdownPlugin(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Class cls = FacecastCountdownPlugin.class;
        m21998a(this, getContext());
        setContentView(getContentLayout());
        this.f18242d = (BetterTextView) a(2131561617);
        this.f18242d.setVisibility(8);
    }

    public final void m21999h() {
        if (this.f18243e != null) {
            this.f18243e.cancel();
        }
        this.f18242d.setVisibility(8);
        this.f18242d.setText("");
    }

    protected int getContentLayout() {
        return 2130904191;
    }
}
