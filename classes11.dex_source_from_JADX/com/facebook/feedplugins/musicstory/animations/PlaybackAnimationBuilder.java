package com.facebook.feedplugins.musicstory.animations;

import android.support.annotation.Nullable;
import android.view.View;
import com.facebook.feed.rows.animations.AnimationBuilder;
import com.facebook.feedplugins.musicstory.MusicPlaybackPartDefinition.PersistentState;
import com.facebook.feedplugins.musicstory.SimpleMusicStoryView;
import java.util.List;

/* compiled from: composer_facecast_inline_sprout */
public class PlaybackAnimationBuilder<V extends SimpleMusicStoryView> implements AnimationBuilder<AnimationData, V> {
    private final PlaybackAnimationListener f8285a;

    /* compiled from: composer_facecast_inline_sprout */
    public class AnimationData {
        public final PersistentState f8284a;

        public AnimationData(PersistentState persistentState) {
            this.f8284a = persistentState;
        }
    }

    /* compiled from: composer_facecast_inline_sprout */
    public class PlaybackAnimationListener {
    }

    public final void m9224a(List list, Object obj, Object obj2, View view) {
        AnimationData animationData = (AnimationData) obj2;
        SimpleMusicStoryView simpleMusicStoryView = (SimpleMusicStoryView) view;
        if (animationData.f8284a != null && animationData.f8284a.f8146a != null) {
            PlaybackAnimationListener playbackAnimationListener;
            switch (animationData.f8284a.f8146a) {
                case LOADING:
                    playbackAnimationListener = this.f8285a;
                    simpleMusicStoryView.f8209e.m9228b();
                    simpleMusicStoryView.setPlayButtonVisibility(4);
                    simpleMusicStoryView.f8205a.setVisibility(0);
                    simpleMusicStoryView.f8205a.a();
                    return;
                case PLAYING:
                    playbackAnimationListener = this.f8285a;
                    int i = animationData.f8284a.f8147b;
                    simpleMusicStoryView.m9194b();
                    if (simpleMusicStoryView.f8209e.f8293g) {
                        simpleMusicStoryView.f8209e.m9229b(i);
                    } else {
                        simpleMusicStoryView.f8213i.startTransition(500);
                        simpleMusicStoryView.setPlayButtonVisibility(0);
                        simpleMusicStoryView.f8209e.m9227a(i);
                    }
                    return;
                case STOPPED:
                    playbackAnimationListener = this.f8285a;
                    simpleMusicStoryView.f8209e.m9228b();
                    simpleMusicStoryView.m9194b();
                    simpleMusicStoryView.setPlayButtonVisibility(0);
                    return;
                default:
                    playbackAnimationListener = this.f8285a;
                    if (simpleMusicStoryView.f8209e.f8293g) {
                        simpleMusicStoryView.f8209e.m9230c();
                        simpleMusicStoryView.m9194b();
                        simpleMusicStoryView.f8213i.startTransition(0);
                        simpleMusicStoryView.f8213i.reverseTransition(500);
                        simpleMusicStoryView.setPlayButtonVisibility(0);
                    }
                    return;
            }
        }
    }

    public PlaybackAnimationBuilder(PlaybackAnimationListener playbackAnimationListener) {
        this.f8285a = playbackAnimationListener;
    }

    @Nullable
    public final Runnable m9223a(Object obj, Object obj2, View view) {
        return null;
    }
}
