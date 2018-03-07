package com.facebook.ui.animations.stateanimator;

import android.util.SparseArray;
import android.view.View;
import com.google.common.base.Preconditions;

/* compiled from: completed */
public class AnimatedView {
    public View f5402a;
    public SparseArray<ViewState> f5403b;

    /* compiled from: completed */
    public class Builder {
        private com.facebook.ui.animations.stateanimator.StateAnimator.Builder f5399a;
        public View f5400b;
        public SparseArray<ViewState> f5401c = new SparseArray();

        Builder(com.facebook.ui.animations.stateanimator.StateAnimator.Builder builder, View view) {
            this.f5399a = builder;
            this.f5400b = view;
            new com.facebook.ui.animations.stateanimator.ViewState.Builder(this, this.f5400b, new int[]{0}).m10310b();
        }

        public final Builder m10296a(View view) {
            Preconditions.checkNotNull(view, "Cannot animate a null view");
            m10295b();
            return this.f5399a.m10302a(view);
        }

        private void m10295b() {
            boolean z = true;
            if (this.f5401c.size() <= 1) {
                z = false;
            }
            Preconditions.checkState(z, "Must define at least one state for animated views other than the default.");
            com.facebook.ui.animations.stateanimator.StateAnimator.Builder builder = this.f5399a;
            builder.f5406a.add(new AnimatedView(this));
        }

        public final StateAnimator m10297a() {
            boolean z;
            m10295b();
            com.facebook.ui.animations.stateanimator.StateAnimator.Builder builder = this.f5399a;
            if (builder.f5406a.isEmpty()) {
                z = false;
            } else {
                z = true;
            }
            Preconditions.checkState(z, "Must include at least one view to animate");
            return new StateAnimator(builder);
        }

        public final com.facebook.ui.animations.stateanimator.ViewState.Builder m10298a(int... iArr) {
            return new com.facebook.ui.animations.stateanimator.ViewState.Builder(this, this.f5400b, iArr);
        }

        final void m10299a(int[] iArr, ViewState viewState) {
            for (int i : iArr) {
                if (this.f5401c.get(i) != null) {
                    throw new IllegalStateException("Cannot define a state twice.");
                }
                this.f5401c.put(i, viewState);
            }
        }
    }

    public AnimatedView(Builder builder) {
        this.f5402a = builder.f5400b;
        this.f5403b = builder.f5401c;
    }
}
