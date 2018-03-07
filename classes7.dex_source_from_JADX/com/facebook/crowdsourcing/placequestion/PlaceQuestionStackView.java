package com.facebook.crowdsourcing.placequestion;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.DecelerateInterpolator;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.crowdsourcing.placequestion.PlaceQuestionContainerView.C14521;
import com.facebook.crowdsourcing.placequestion.PlaceQuestionViewController.PlaceQuestionInteractionListener;
import com.facebook.crowdsourcing.placequestion.animation.StackPopOffAnimation;
import com.facebook.inject.FbInjector;
import com.facebook.widget.CustomFrameLayout;
import com.google.common.base.Preconditions;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: com.facebook.zero.ZERO_RATING_CLEAR_SETTINGS */
public abstract class PlaceQuestionStackView extends CustomFrameLayout implements PlaceQuestionInteractionListener {
    private static final String f17406a = PlaceQuestionStackView.class.getSimpleName();
    public int f17407b = 0;
    @Inject
    public AbstractFbErrorReporter f17408d;

    private static <T extends View> void m21294a(Class<T> cls, T t) {
        m21295a((Object) t, t.getContext());
    }

    private static void m21295a(Object obj, Context context) {
        ((PlaceQuestionStackView) obj).f17408d = (AbstractFbErrorReporter) FbErrorReporterImpl.a(FbInjector.get(context));
    }

    protected abstract View mo1358a(int i);

    protected abstract void mo1359b(int i);

    public abstract int getNumQuestions();

    public PlaceQuestionStackView(Context context) {
        super(context);
        m21294a(PlaceQuestionStackView.class, (View) this);
    }

    public PlaceQuestionStackView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        m21294a(PlaceQuestionStackView.class, (View) this);
    }

    protected PlaceQuestionStackView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m21294a(PlaceQuestionStackView.class, (View) this);
    }

    public final void m21299a() {
        removeAllViews();
        if (getNumQuestions() - this.f17407b != 0) {
            View a = mo1358a(this.f17407b);
            if (a != null) {
                m21297g(this);
                m21296f(this, 0).m21410a(a, getWidth());
                mo1359b(this.f17407b);
            }
        }
    }

    public static void m21297g(PlaceQuestionStackView placeQuestionStackView) {
        int min = Math.min(3, placeQuestionStackView.getNumQuestions() - placeQuestionStackView.f17407b);
        for (int childCount = placeQuestionStackView.getChildCount(); childCount < min; childCount++) {
            placeQuestionStackView.addView(new PlaceQuestionContainerView(placeQuestionStackView.getContext(), childCount), 0);
            if (childCount != 0) {
                m21296f(placeQuestionStackView, childCount - 1).f17523c.setVisibility(1 != 0 ? 0 : 8);
            }
        }
    }

    protected void onMeasure(int i, int i2) {
        int i3 = 0;
        if (getChildCount() >= 2) {
            m21296f(this, 0).m21411c(i);
            int i4 = m21296f(this, 0).f17525e;
            while (i3 < getChildCount()) {
                m21296f(this, i3).setContentHeight(i4);
                i3++;
            }
        }
        super.onMeasure(i, i2);
    }

    public final void m21300b() {
        this.f17407b++;
        if (getChildCount() > 1) {
            final PlaceQuestionContainerView f = m21296f(this, 0);
            Animation stackPopOffAnimation = new StackPopOffAnimation(f, 1.25f);
            stackPopOffAnimation.setDuration((long) getResources().getInteger(2131492927));
            stackPopOffAnimation.setInterpolator(new DecelerateInterpolator(2.0f));
            stackPopOffAnimation.setAnimationListener(new AnimationListener(this) {
                final /* synthetic */ PlaceQuestionStackView f17528b;

                public void onAnimationStart(Animation animation) {
                }

                public void onAnimationEnd(Animation animation) {
                    this.f17528b.removeView(f);
                    PlaceQuestionStackView.m21296f(this.f17528b, 0).m21410a(this.f17528b.mo1358a(this.f17528b.f17407b), this.f17528b.getWidth());
                    for (int i = 0; i < this.f17528b.getChildCount(); i++) {
                        PlaceQuestionContainerView f = PlaceQuestionStackView.m21296f(this.f17528b, i);
                        int i2 = f.f17525e;
                        int i3 = f.f17526f != 0 ? f.f17526f : i2;
                        int i4 = f.f17522b * f.f17521a;
                        int i5 = f.f17522b - 1;
                        f.f17522b = i5;
                        Animation c14521 = new C14521(f, i4, i5 * f.f17521a, i2, i3);
                        c14521.setDuration((long) f.getResources().getInteger(2131492925));
                        f.f17524d.startAnimation(c14521);
                    }
                    PlaceQuestionStackView.m21297g(this.f17528b);
                    this.f17528b.mo1359b(this.f17528b.f17407b);
                    PlaceQuestionStackView.m21296f(this.f17528b, 0).requestFocus();
                }

                public void onAnimationRepeat(Animation animation) {
                }
            });
            f.startAnimation(stackPopOffAnimation);
            return;
        }
        this.f17408d.a(f17406a, "onChildFinished() called by the last card in the stack");
        removeAllViews();
    }

    public static PlaceQuestionContainerView m21296f(PlaceQuestionStackView placeQuestionStackView, int i) {
        boolean z;
        boolean z2 = true;
        if (i >= 0) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkState(z);
        if (i >= placeQuestionStackView.getChildCount()) {
            z2 = false;
        }
        Preconditions.checkState(z2);
        View childAt = placeQuestionStackView.getChildAt((placeQuestionStackView.getChildCount() - 1) - i);
        Preconditions.checkState(childAt instanceof PlaceQuestionContainerView);
        return (PlaceQuestionContainerView) childAt;
    }

    public final void mo1356e() {
        m21300b();
    }

    public final void mo1357f() {
        m21300b();
    }
}
