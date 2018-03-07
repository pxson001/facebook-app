package com.facebook.ui.animations.stateanimator;

import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPropertyAnimatorCompat;
import android.support.v4.view.ViewPropertyAnimatorListener;
import android.support.v4.view.ViewPropertyAnimatorListenerAdapter;
import android.util.SparseArray;
import android.view.View;
import com.facebook.common.collect.ReentrantCallback;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: comparator */
public class StateAnimator {
    private List<AnimatedView> f5407a;
    public final ReentrantCallback<StateChangeListener> f5408b = new ReentrantCallback();
    public int f5409c = 0;
    public boolean f5410d = false;

    /* compiled from: comparator */
    public class Builder {
        public List<AnimatedView> f5406a = new ArrayList();

        public final com.facebook.ui.animations.stateanimator.AnimatedView.Builder m10302a(View view) {
            return new com.facebook.ui.animations.stateanimator.AnimatedView.Builder(this, view);
        }
    }

    /* compiled from: comparator */
    public interface StateChangeListener {
        void m10303a(int i);

        void m10304b(int i);

        void m10305c(int i);
    }

    public StateAnimator(Builder builder) {
        this.f5407a = builder.f5406a;
    }

    public final void m10306a(int i) {
        Iterator it = this.f5408b.iterator();
        while (it.hasNext()) {
            StateChangeListener stateChangeListener = (StateChangeListener) it.next();
            if (!this.f5410d) {
                stateChangeListener.m10304b(this.f5409c);
            }
            stateChangeListener.m10303a(i);
        }
        for (AnimatedView animatedView : this.f5407a) {
            SparseArray sparseArray = animatedView.f5403b;
            ViewState viewState = (ViewState) sparseArray.get(i, (ViewState) sparseArray.get(0));
            View view = animatedView.f5402a;
            ViewCompat.a(view, viewState.f5421b);
            ViewCompat.b(view, viewState.f5422c);
            ViewCompat.c(view, viewState.f5420a);
            ViewCompat.e(view, viewState.f5423d);
            ViewCompat.f(view, viewState.f5424e);
            ViewCompat.d(view, viewState.f5425f);
        }
        it = this.f5408b.iterator();
        while (it.hasNext()) {
            ((StateChangeListener) it.next()).m10305c(i);
        }
        this.f5410d = false;
        this.f5409c = i;
    }

    public final void m10307a(final int i, int i2) {
        ViewPropertyAnimatorListener c04991 = new ViewPropertyAnimatorListenerAdapter(this) {
            final /* synthetic */ StateAnimator f5405b;

            public final void mo87a(View view) {
                Iterator it = this.f5405b.f5408b.iterator();
                while (it.hasNext()) {
                    StateChangeListener stateChangeListener = (StateChangeListener) it.next();
                    if (!this.f5405b.f5410d) {
                        stateChangeListener.m10304b(this.f5405b.f5409c);
                    }
                    stateChangeListener.m10303a(i);
                }
                this.f5405b.f5410d = true;
            }

            public final void mo88b(View view) {
                Iterator it = this.f5405b.f5408b.iterator();
                while (it.hasNext()) {
                    ((StateChangeListener) it.next()).m10305c(i);
                }
                this.f5405b.f5410d = false;
                this.f5405b.f5409c = i;
            }
        };
        int i3 = 1;
        for (AnimatedView animatedView : this.f5407a) {
            int i4;
            SparseArray sparseArray = animatedView.f5403b;
            ViewState viewState = (ViewState) sparseArray.get(i, (ViewState) sparseArray.get(0));
            ViewPropertyAnimatorCompat t = ViewCompat.t(animatedView.f5402a);
            t.m493b(viewState.f5421b);
            t.m496c(viewState.f5422c);
            t.m487a(viewState.f5420a);
            t.m498e(viewState.f5423d);
            t.m499f(viewState.f5424e);
            t.m497d(viewState.f5425f);
            t.m488a((long) i2);
            if (i3 != 0) {
                t.m489a(c04991);
                i4 = 0;
            } else {
                i4 = i3;
            }
            t.m495b();
            i3 = i4;
        }
    }
}
