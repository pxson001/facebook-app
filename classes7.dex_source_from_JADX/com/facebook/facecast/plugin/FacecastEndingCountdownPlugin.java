package com.facebook.facecast.plugin;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.AccelerateDecelerateInterpolator;
import com.facebook.facecast.FacecastStateManager.FacecastBroadcastState;
import com.facebook.fbui.glyph.GlyphView;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.resources.ui.FbButton;
import com.facebook.sounds.FBSoundUtil;
import com.facebook.sounds.SoundPlayer;
import com.facebook.sounds.fb4a.Fb4aSoundUtil;
import com.facebook.video.player.CountdownRingContainer;
import com.facebook.video.player.CountdownRingContainer.CountdownRingContainerListener;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: borderStyle */
public class FacecastEndingCountdownPlugin extends FacecastBasePlugin {
    @Inject
    public FBSoundUtil f18410c;
    public final View f18411d;
    public final CountdownRingContainer f18412e;
    public final GlyphView f18413f;
    public final FbButton f18414g;
    public final View f18415h;
    public final View f18416i;
    public final int f18417j;
    public final int f18418k;
    @Nullable
    public SoundPlayer f18419l;

    /* compiled from: borderStyle */
    class C15711 implements CountdownRingContainerListener {
        final /* synthetic */ FacecastEndingCountdownPlugin f18404a;

        C15711(FacecastEndingCountdownPlugin facecastEndingCountdownPlugin) {
            this.f18404a = facecastEndingCountdownPlugin;
        }

        public final void m22078a() {
            FacecastEndingCountdownPlugin facecastEndingCountdownPlugin = this.f18404a;
            facecastEndingCountdownPlugin.f18412e.animate().setInterpolator(new AccelerateDecelerateInterpolator()).alpha(0.0f).setDuration((long) facecastEndingCountdownPlugin.f18418k);
            facecastEndingCountdownPlugin.f18414g.setEnabled(false);
            facecastEndingCountdownPlugin.f18414g.animate().setInterpolator(new AccelerateDecelerateInterpolator()).alpha(0.0f).setDuration((long) facecastEndingCountdownPlugin.f18418k);
            facecastEndingCountdownPlugin.f18415h.setAlpha(0.0f);
            facecastEndingCountdownPlugin.f18415h.setScaleX(0.0f);
            facecastEndingCountdownPlugin.f18415h.setScaleY(0.0f);
            facecastEndingCountdownPlugin.f18415h.setVisibility(0);
            facecastEndingCountdownPlugin.f18415h.animate().setInterpolator(new AccelerateDecelerateInterpolator()).alpha(1.0f).scaleX(1.0f).scaleY(1.0f).setDuration((long) facecastEndingCountdownPlugin.f18418k);
            facecastEndingCountdownPlugin.f18416i.setAlpha(0.0f);
            facecastEndingCountdownPlugin.f18416i.setScaleX(0.0f);
            facecastEndingCountdownPlugin.f18416i.setScaleY(0.0f);
            facecastEndingCountdownPlugin.f18416i.setVisibility(0);
            facecastEndingCountdownPlugin.f18416i.animate().setInterpolator(new AccelerateDecelerateInterpolator()).alpha(1.0f).scaleX(1.0f).scaleY(1.0f).setStartDelay(100).setDuration((long) facecastEndingCountdownPlugin.f18418k);
            facecastEndingCountdownPlugin.f18413f.setAlpha(0.0f);
            facecastEndingCountdownPlugin.f18413f.setScaleX(0.0f);
            facecastEndingCountdownPlugin.f18413f.setScaleY(0.0f);
            facecastEndingCountdownPlugin.f18413f.setRotation(-90.0f);
            facecastEndingCountdownPlugin.f18413f.setVisibility(0);
            facecastEndingCountdownPlugin.f18413f.animate().setInterpolator(new AccelerateDecelerateInterpolator()).alpha(1.0f).scaleX(1.0f).scaleY(1.0f).rotationBy(90.0f).setStartDelay(120).setDuration((long) facecastEndingCountdownPlugin.f18418k).setListener(new C15754(facecastEndingCountdownPlugin));
        }
    }

    /* compiled from: borderStyle */
    class C15722 implements OnClickListener {
        final /* synthetic */ FacecastEndingCountdownPlugin f18405a;

        C15722(FacecastEndingCountdownPlugin facecastEndingCountdownPlugin) {
            this.f18405a = facecastEndingCountdownPlugin;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 87363489);
            this.f18405a.mo1409a();
            Logger.a(2, EntryType.UI_INPUT_END, -950862145, a);
        }
    }

    /* compiled from: borderStyle */
    public class C15743 implements Runnable {
        final /* synthetic */ FacecastEndingCountdownPlugin f18407a;

        /* compiled from: borderStyle */
        class C15731 extends AnimatorListenerAdapter {
            final /* synthetic */ C15743 f18406a;

            C15731(C15743 c15743) {
                this.f18406a = c15743;
            }

            public void onAnimationEnd(Animator animator) {
                this.f18406a.f18407a.f18412e.a();
                this.f18406a.f18407a.f18419l = this.f18406a.f18407a.f18410c.a(2131165215, 2, 0.17f);
            }
        }

        public C15743(FacecastEndingCountdownPlugin facecastEndingCountdownPlugin) {
            this.f18407a = facecastEndingCountdownPlugin;
        }

        public void run() {
            this.f18407a.f18411d.setTranslationY((float) (this.f18407a.f18417j + (this.f18407a.getHeight() / 2)));
            this.f18407a.f18411d.animate().setInterpolator(new AccelerateDecelerateInterpolator()).alpha(1.0f).yBy((float) (this.f18407a.f18417j * -1)).setDuration((long) this.f18407a.f18418k).setListener(new C15731(this));
        }
    }

    /* compiled from: borderStyle */
    public class C15754 extends AnimatorListenerAdapter {
        final /* synthetic */ FacecastEndingCountdownPlugin f18408a;

        public C15754(FacecastEndingCountdownPlugin facecastEndingCountdownPlugin) {
            this.f18408a = facecastEndingCountdownPlugin;
        }

        public void onAnimationEnd(Animator animator) {
            FacecastEndingCountdownPlugin facecastEndingCountdownPlugin = this.f18408a;
            facecastEndingCountdownPlugin.f18411d.animate().setInterpolator(new AccelerateDecelerateInterpolator()).alpha(0.0f).yBy((float) facecastEndingCountdownPlugin.f18417j).setDuration((long) facecastEndingCountdownPlugin.f18418k).setListener(new C15765(facecastEndingCountdownPlugin));
        }
    }

    /* compiled from: borderStyle */
    public class C15765 extends AnimatorListenerAdapter {
        final /* synthetic */ FacecastEndingCountdownPlugin f18409a;

        public C15765(FacecastEndingCountdownPlugin facecastEndingCountdownPlugin) {
            this.f18409a = facecastEndingCountdownPlugin;
        }

        public void onAnimationEnd(Animator animator) {
            this.f18409a.f18166b.m21883b(FacecastBroadcastState.FACECAST_BROADCAST_STATE_FINISHED);
        }
    }

    public static void m22079a(Object obj, Context context) {
        ((FacecastEndingCountdownPlugin) obj).f18410c = (FBSoundUtil) Fb4aSoundUtil.a(FbInjector.get(context));
    }

    public FacecastEndingCountdownPlugin(Context context) {
        this(context, null);
    }

    private FacecastEndingCountdownPlugin(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private FacecastEndingCountdownPlugin(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Class cls = FacecastEndingCountdownPlugin.class;
        m22079a(this, getContext());
        setContentView(2130904217);
        this.f18411d = a(2131561679);
        this.f18412e = (CountdownRingContainer) a(2131561680);
        this.f18412e.l = 3000;
        this.f18412e.j = new C15711(this);
        this.f18413f = (GlyphView) a(2131561683);
        this.f18414g = (FbButton) a(2131561685);
        this.f18414g.setOnClickListener(new C15722(this));
        this.f18415h = a(2131561681);
        this.f18416i = a(2131561682);
        this.f18417j = getResources().getDimensionPixelOffset(2131432329);
        this.f18418k = getResources().getInteger(17694721);
    }

    protected final void hE_() {
        super.hE_();
        this.f18411d.setAlpha(0.0f);
        post(new C15743(this));
    }

    public final boolean mo1409a() {
        if (this.f18165a == null) {
            return false;
        }
        this.f18412e.b();
        this.f18412e.animate().cancel();
        this.f18411d.animate().setListener(null).cancel();
        this.f18414g.animate().cancel();
        this.f18415h.animate().cancel();
        this.f18416i.animate().cancel();
        this.f18413f.animate().setListener(null).cancel();
        this.f18166b.m21883b(this.f18166b.f18049c);
        if (this.f18419l != null) {
            this.f18419l.a();
            this.f18419l = null;
        }
        return true;
    }
}
