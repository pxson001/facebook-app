package android.support.v7.widget;

import android.support.v7.widget.RecyclerView.Recycler;
import android.support.v7.widget.RecyclerView.State;
import android.view.View;

/* compiled from: trending_topics */
class LayoutState {
    int f1381a;
    int f1382b;
    int f1383c;
    int f1384d;
    int f1385e = 0;
    int f1386f = 0;

    LayoutState() {
    }

    final boolean m1929a(State state) {
        return this.f1382b >= 0 && this.f1382b < state.e();
    }

    final View m1928a(Recycler recycler) {
        View c = recycler.c(this.f1382b);
        this.f1382b += this.f1383c;
        return c;
    }

    public String toString() {
        return "LayoutState{mAvailable=" + this.f1381a + ", mCurrentPosition=" + this.f1382b + ", mItemDirection=" + this.f1383c + ", mLayoutDirection=" + this.f1384d + ", mStartLine=" + this.f1385e + ", mEndLine=" + this.f1386f + '}';
    }
}
