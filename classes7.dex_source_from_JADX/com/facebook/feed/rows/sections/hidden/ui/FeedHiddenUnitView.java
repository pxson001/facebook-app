package com.facebook.feed.rows.sections.hidden.ui;

import android.content.Context;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationSet;
import android.view.animation.DecelerateInterpolator;
import android.widget.TextView;
import com.facebook.feed.animation.CollapseAnimation;
import com.facebook.widget.CustomFrameLayout;
import com.facebook.widget.listeners.BaseAnimationListener;

/* compiled from: Unable to find HScrollChainingView. */
public class FeedHiddenUnitView extends CustomFrameLayout {
    public View f21477a = c(2131561915);
    public TextView f21478b = ((TextView) c(2131564235));
    public ViewGroup f21479c = ((ViewGroup) c(2131561911));
    public ViewGroup f21480d = ((ViewGroup) c(2131564234));
    public ViewGroup f21481e = ((ViewGroup) c(2131564236));
    public View f21482f = c(2131564233);
    public FeedHiddenUnitAnimationHelper f21483g;

    /* compiled from: Unable to find HScrollChainingView. */
    public class C18061 extends BaseAnimationListener {
        final /* synthetic */ int f21474a;
        final /* synthetic */ int f21475b;
        final /* synthetic */ FeedHiddenUnitView f21476c;

        public C18061(FeedHiddenUnitView feedHiddenUnitView, int i, int i2) {
            this.f21476c = feedHiddenUnitView;
            this.f21474a = i;
            this.f21475b = i2;
        }

        public void onAnimationEnd(Animation animation) {
            this.f21476c.m24144e();
            this.f21476c.m24143b(this.f21474a, this.f21475b);
        }
    }

    public FeedHiddenUnitView(Context context) {
        super(context);
        setContentView(2130905450);
        this.f21478b.setMovementMethod(LinkMovementMethod.getInstance());
        this.f21483g = new FeedHiddenUnitAnimationHelper();
    }

    public void setContentVisibility(int i) {
        this.f21479c.setVisibility(i);
    }

    public final void m24141a() {
        this.f21482f.setVisibility(0);
        this.f21480d.setVisibility(8);
    }

    public final void m24144e() {
        this.f21482f.setVisibility(8);
        this.f21477a.setVisibility(8);
    }

    public void setHeight(int i) {
        this.f21477a.setVisibility(0);
        this.f21477a.getLayoutParams().height = i;
        this.f21477a.setMinimumHeight(i);
    }

    public final void m24143b(int i, int i2) {
        this.f21480d.setVisibility(0);
        View view = this.f21477a;
        view.setVisibility(0);
        view.getLayoutParams().height = i;
        Animation collapseAnimation = new CollapseAnimation(view, i, i2);
        collapseAnimation.setDuration(200);
        collapseAnimation.setInterpolator(new DecelerateInterpolator(1.0f));
        setAnimation(collapseAnimation);
        this.f21480d.setAnimation(FeedHiddenUnitAnimationHelper.m24139a(null));
        FeedHiddenUnitAnimationHelper feedHiddenUnitAnimationHelper = this.f21483g;
        Animation[] animationArr = new Animation[]{r0, r1};
        int i3 = 0;
        feedHiddenUnitAnimationHelper.f21473a = new AnimationSet(false);
        AnimationSet animationSet = (AnimationSet) feedHiddenUnitAnimationHelper.f21473a;
        int length = animationArr.length;
        while (i3 < length) {
            animationSet.addAnimation(animationArr[i3]);
            i3++;
        }
        animationSet.start();
    }

    public final void m24142a(AnimationListener animationListener) {
        this.f21483g.m24140a(this.f21480d, animationListener);
    }

    public final int m24145g() {
        this.f21480d.measure(-1, -2);
        return this.f21480d.getMeasuredHeight();
    }

    public final FeedHiddenUnitActionItemView m24146h() {
        FeedHiddenUnitActionItemView feedHiddenUnitActionItemView = new FeedHiddenUnitActionItemView(getContext());
        this.f21481e.addView(feedHiddenUnitActionItemView);
        return feedHiddenUnitActionItemView;
    }

    public final void m24147i() {
        this.f21481e.removeAllViews();
    }

    public void setEnabled(boolean z) {
        super.setEnabled(z);
        for (int i = 0; i < this.f21481e.getChildCount(); i++) {
            ((FeedHiddenUnitActionItemView) this.f21481e.getChildAt(i)).setEnabled(z);
        }
        this.f21478b.setEnabled(z);
    }
}
