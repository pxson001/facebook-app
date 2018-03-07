package android.support.design.widget;

import android.content.Context;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import java.util.List;

/* compiled from: pushable */
abstract class HeaderScrollingViewBehavior extends ViewOffsetBehavior<View> {
    abstract View findFirstDependency(List<View> list);

    public HeaderScrollingViewBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public boolean onMeasureChild(CoordinatorLayout coordinatorLayout, View view, int i, int i2, int i3, int i4) {
        int i5 = view.getLayoutParams().height;
        if (i5 != -1 && i5 != -2) {
            return false;
        }
        List c = coordinatorLayout.m10128c(view);
        if (c.isEmpty()) {
            return false;
        }
        View findFirstDependency = findFirstDependency(c);
        if (findFirstDependency == null || !ViewCompat.E(findFirstDependency)) {
            return false;
        }
        if (ViewCompat.A(findFirstDependency)) {
            ViewCompat.a(view, true);
        }
        int size = MeasureSpec.getSize(i3);
        if (size == 0) {
            size = coordinatorLayout.getHeight();
        }
        coordinatorLayout.m10123a(view, i, i2, MeasureSpec.makeMeasureSpec(getScrollRange(findFirstDependency) + (size - findFirstDependency.getMeasuredHeight()), i5 == -1 ? 1073741824 : Integer.MIN_VALUE), i4);
        return true;
    }

    int getScrollRange(View view) {
        return view.getMeasuredHeight();
    }
}
