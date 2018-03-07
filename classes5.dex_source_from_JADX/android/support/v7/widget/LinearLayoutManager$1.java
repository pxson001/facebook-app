package android.support.v7.widget;

import android.content.Context;
import android.graphics.PointF;

/* compiled from: trending_topic_name */
class LinearLayoutManager$1 extends LinearSmoothScroller {
    final /* synthetic */ LinearLayoutManager f1387a;

    LinearLayoutManager$1(LinearLayoutManager linearLayoutManager, Context context) {
        this.f1387a = linearLayoutManager;
        super(context);
    }

    public final PointF m1930a(int i) {
        return this.f1387a.d(i);
    }
}
