package com.facebook.feedplugins.musicstory.animations;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.TransitionDrawable;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationSet;
import com.facebook.feedplugins.musicstory.animations.VinylTransformationAnimation.AnimationType;
import com.google.common.base.Preconditions;

/* compiled from: composer_implicit_location_removed */
public class PlaybackAnimationSet {
    public final AnimationListener f8287a = new C10281(this);
    public final AnimationSet f8288b = new AnimationSet(false);
    public final MusicPlaybackAnimatable f8289c;
    public ProgressCircleAnimation f8290d;
    public VinylTransformationAnimation f8291e;
    public VinylRotationAnimation f8292f;
    public boolean f8293g;

    /* compiled from: composer_implicit_location_removed */
    public interface MusicPlaybackAnimatable {
        View getCoverArt();

        Drawable getCoverArtDrawable();

        TransitionDrawable getPlayButtonDrawable();

        ProgressCircle getProgressView();

        VinylView getVinylView();
    }

    /* compiled from: composer_implicit_location_removed */
    class C10281 implements AnimationListener {
        final /* synthetic */ PlaybackAnimationSet f8286a;

        C10281(PlaybackAnimationSet playbackAnimationSet) {
            this.f8286a = playbackAnimationSet;
        }

        public void onAnimationStart(Animation animation) {
        }

        public void onAnimationEnd(Animation animation) {
            this.f8286a.f8289c.getVinylView().m9238a();
            this.f8286a.f8289c.getVinylView().setVisibility(4);
            this.f8286a.f8289c.getCoverArt().setVisibility(0);
        }

        public void onAnimationRepeat(Animation animation) {
        }
    }

    public PlaybackAnimationSet(MusicPlaybackAnimatable musicPlaybackAnimatable) {
        this.f8289c = (MusicPlaybackAnimatable) Preconditions.checkNotNull(musicPlaybackAnimatable);
        this.f8290d = new ProgressCircleAnimation(this.f8289c.getProgressView());
        Animation vinylTransformationAnimation = new VinylTransformationAnimation(this.f8289c.getVinylView(), AnimationType.SQUARE_TO_CIRCLE);
        vinylTransformationAnimation.setDuration(350);
        this.f8288b.addAnimation(vinylTransformationAnimation);
        this.f8292f = new VinylRotationAnimation(this.f8289c.getVinylView());
        this.f8292f.setFillEnabled(true);
        this.f8292f.setFillAfter(true);
        this.f8292f.setStartOffset(300);
        this.f8292f.setRepeatCount(-1);
        this.f8292f.setRepeatMode(-1);
        this.f8288b.addAnimation(this.f8292f);
        this.f8291e = new VinylTransformationAnimation(this.f8289c.getVinylView(), AnimationType.CIRCLE_TO_SQUARE);
        this.f8291e.setDuration(250);
        this.f8291e.setAnimationListener(this.f8287a);
    }

    public final void m9227a(int i) {
        if (!this.f8293g) {
            this.f8293g = true;
            this.f8290d.m9234a(i);
            m9225d();
            this.f8289c.getVinylView().startAnimation(this.f8288b);
        }
    }

    public final void m9229b(int i) {
        this.f8293g = true;
        this.f8290d.m9236b(i);
        m9225d();
        this.f8289c.getVinylView().startAnimation(this.f8292f);
    }

    private void m9225d() {
        Drawable coverArtDrawable = this.f8289c.getCoverArtDrawable();
        if (coverArtDrawable != null && coverArtDrawable.getBounds() != null && coverArtDrawable.getBounds().width() != 0 && coverArtDrawable.getBounds().height() != 0) {
            this.f8289c.getVinylView().f8309c = coverArtDrawable;
            this.f8289c.getCoverArt().setVisibility(4);
            this.f8289c.getVinylView().setVisibility(0);
        }
    }

    public final void m9228b() {
        this.f8293g = false;
        this.f8290d.m9235b();
        m9226f();
    }

    public final void m9230c() {
        this.f8293g = false;
        this.f8290d.m9233a();
        m9226f();
    }

    private void m9226f() {
        if (this.f8289c.getVinylView().getVisibility() == 0) {
            this.f8291e.reset();
            this.f8292f.f8304d = 0.0f;
            this.f8289c.getPlayButtonDrawable().resetTransition();
            this.f8289c.getVinylView().clearAnimation();
            this.f8289c.getVinylView().startAnimation(this.f8291e);
        }
    }
}
