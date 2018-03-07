package com.facebook.feedplugins.musicstory;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.TransitionDrawable;
import android.net.Uri;
import android.view.View;
import android.widget.ImageButton;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.feedplugins.musicstory.animations.PlaybackAnimationSet;
import com.facebook.feedplugins.musicstory.animations.PlaybackAnimationSet.MusicPlaybackAnimatable;
import com.facebook.feedplugins.musicstory.animations.ProgressCircle;
import com.facebook.feedplugins.musicstory.animations.VinylView;
import com.facebook.widget.CustomFrameLayout;
import com.facebook.widget.loadingindicator.LoadingIndicatorView;
import javax.annotation.Nullable;

/* compiled from: composer_implicit_location_toggled */
public class SimpleMusicStoryView extends CustomFrameLayout implements MusicPlaybackAnimatable {
    public LoadingIndicatorView f8205a;
    public ImageButton f8206b;
    public FbDraweeView f8207c;
    @Nullable
    public Uri f8208d;
    public PlaybackAnimationSet f8209e;
    public FbDraweeView f8210f;
    public ProgressCircle f8211g;
    public VinylView f8212h;
    public TransitionDrawable f8213i;

    /* compiled from: composer_implicit_location_toggled */
    public enum CardType {
        SingleSong,
        SongInAList
    }

    public SimpleMusicStoryView(Context context, CardType cardType) {
        int i;
        super(context);
        if (cardType == CardType.SingleSong) {
            i = 2130907107;
        } else {
            i = 2130907108;
        }
        setContentView(i);
        this.f8206b = (ImageButton) findViewById(2131566148);
        this.f8205a = (LoadingIndicatorView) findViewById(2131566147);
        this.f8207c = (FbDraweeView) findViewById(2131567453);
        this.f8210f = (FbDraweeView) findViewById(2131567455);
        this.f8211g = (ProgressCircle) findViewById(2131566149);
        this.f8212h = (VinylView) findViewById(2131567456);
        this.f8209e = new PlaybackAnimationSet(this);
        this.f8213i = new TransitionDrawable(new Drawable[]{getResources().getDrawable(2130842697), getResources().getDrawable(2130842533)});
        this.f8213i.setCrossFadeEnabled(true);
        this.f8206b.setImageDrawable(this.f8213i);
    }

    public void setPlayButtonVisibility(int i) {
        this.f8206b.setVisibility(i);
    }

    public final void m9194b() {
        if (this.f8205a.getVisibility() == 0) {
            this.f8205a.b();
            this.f8205a.setVisibility(8);
        }
    }

    public View getCoverArt() {
        return this.f8210f;
    }

    public ProgressCircle getProgressView() {
        return this.f8211g;
    }

    public VinylView getVinylView() {
        return this.f8212h;
    }

    public Drawable getCoverArtDrawable() {
        return this.f8207c.getTopLevelDrawable();
    }

    public TransitionDrawable getPlayButtonDrawable() {
        return this.f8213i;
    }
}
