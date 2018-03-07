package com.facebook.feed.photoreminder.common;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.support.annotation.Nullable;
import android.view.View;
import com.facebook.device.ScreenUtil;
import com.facebook.feed.inlinecomposer.multirow.common.views.HasPhotoTray;
import com.facebook.feed.rows.animations.AnimationBuilder;
import com.facebook.productionprompts.model.PromptViewState.Visibility;
import com.facebook.ui.animations.persistent.PersistentAnimation;
import com.facebook.ui.animations.persistent.parts.DefaultAnimationPartFactory;
import com.google.common.collect.ImmutableList;
import java.util.List;

/* compiled from: admin_tapped_event */
public abstract class ScrollingImagePromptViewAnimationBuilder<L extends BaseTrayAnimatorListener, V extends View & HasPhotoTray> implements AnimationBuilder<Visibility, V> {
    public final ScreenUtil f19683a;
    private final DefaultAnimationPartFactory f19684b;
    private final int f19685c;

    /* compiled from: admin_tapped_event */
    public class BaseTrayAnimatorListener implements AnimatorListener {
        final PromptHScrollView f19676a;
        final boolean f19677b;
        final /* synthetic */ ScrollingImagePromptViewAnimationBuilder f19678c;

        public BaseTrayAnimatorListener(ScrollingImagePromptViewAnimationBuilder scrollingImagePromptViewAnimationBuilder, PromptHScrollView promptHScrollView, boolean z) {
            this.f19678c = scrollingImagePromptViewAnimationBuilder;
            this.f19676a = promptHScrollView;
            this.f19677b = z;
        }

        public void onAnimationStart(Animator animator) {
            if (this.f19677b) {
                this.f19676a.setTranslationX((float) this.f19678c.f19683a.c());
                this.f19676a.setVisibility(0);
            }
        }

        public void onAnimationEnd(Animator animator) {
            if (!this.f19677b) {
                this.f19676a.setVisibility(8);
            }
        }

        public void onAnimationCancel(Animator animator) {
        }

        public void onAnimationRepeat(Animator animator) {
        }
    }

    /* compiled from: admin_tapped_event */
    public class SlidePhotoGalleryAnimationUpdateListener implements AnimatorUpdateListener {
        PromptHScrollView f19760a;
        final /* synthetic */ ScrollingImagePromptViewAnimationBuilder f19761b;

        public SlidePhotoGalleryAnimationUpdateListener(ScrollingImagePromptViewAnimationBuilder scrollingImagePromptViewAnimationBuilder, PromptHScrollView promptHScrollView) {
            this.f19761b = scrollingImagePromptViewAnimationBuilder;
            this.f19760a = promptHScrollView;
        }

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            this.f19760a.setTranslationX(((Float) valueAnimator.getAnimatedValue()).floatValue());
        }
    }

    public abstract L mo1465a(V v, PromptHScrollView promptHScrollView, boolean z);

    public final void m22953a(List list, Object obj, Object obj2, View view) {
        Visibility visibility = (Visibility) obj;
        Visibility visibility2 = (Visibility) obj2;
        if (visibility != visibility2) {
            if (visibility == Visibility.MAXIMIZED) {
                list.add(m22948b(view));
            }
            if (visibility2 == Visibility.MAXIMIZED) {
                list.add(this.f19684b.a(400, null));
                list.add(m22947a(view));
            }
        }
    }

    public ScrollingImagePromptViewAnimationBuilder(ScreenUtil screenUtil, DefaultAnimationPartFactory defaultAnimationPartFactory, int i) {
        this.f19683a = screenUtil;
        this.f19684b = defaultAnimationPartFactory;
        this.f19685c = i;
    }

    @Nullable
    public final Runnable m22952a(Object obj, Object obj2, View view) {
        return null;
    }

    private PersistentAnimation m22947a(V v) {
        View c = m22949c(v);
        PromptHScrollView d = m22950d(v);
        return this.f19684b.a(ImmutableList.of(this.f19684b.a(c, 500, c.getHeight(), this.f19685c, mo1465a((View) v, d, true)), this.f19684b.a(new SlidePhotoGalleryAnimationUpdateListener(this, d), 600, (float) this.f19683a.c(), 0.0f, null)), 500, null);
    }

    private PersistentAnimation m22948b(V v) {
        View c = m22949c(v);
        PromptHScrollView d = m22950d(v);
        return this.f19684b.a(ImmutableList.of(this.f19684b.a(new SlidePhotoGalleryAnimationUpdateListener(this, d), 600, 0.0f, (float) this.f19683a.c(), null), this.f19684b.a(c, 500, this.f19685c, c.getHeight(), mo1465a((View) v, d, false))), 500, null);
    }

    private static View m22949c(V v) {
        return v.findViewById(2131561946);
    }

    private static PromptHScrollView m22950d(V v) {
        return (PromptHScrollView) v.findViewById(2131561947);
    }
}
