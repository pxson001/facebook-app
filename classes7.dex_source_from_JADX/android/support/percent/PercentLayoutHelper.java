package android.support.percent;

import android.support.v4.view.MarginLayoutParamsCompat;
import android.support.v4.view.ViewCompat;
import android.util.Log;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;

/* compiled from: view_recent_post */
public class PercentLayoutHelper {
    public final ViewGroup f552a;

    /* compiled from: view_recent_post */
    public class PercentLayoutInfo {
        public float f543a = -1.0f;
        public float f544b = -1.0f;
        public float f545c = -1.0f;
        public float f546d = -1.0f;
        public float f547e = -1.0f;
        public float f548f = -1.0f;
        public float f549g = -1.0f;
        public float f550h = -1.0f;
        public final MarginLayoutParams f551i = new MarginLayoutParams(0, 0);

        public final void m566a(LayoutParams layoutParams, int i, int i2) {
            this.f551i.width = layoutParams.width;
            this.f551i.height = layoutParams.height;
            if (this.f543a >= 0.0f) {
                layoutParams.width = (int) (((float) i) * this.f543a);
            }
            if (this.f544b >= 0.0f) {
                layoutParams.height = (int) (((float) i2) * this.f544b);
            }
            if (Log.isLoggable("PercentLayout", 3)) {
                Log.d("PercentLayout", "after fillLayoutParams: (" + layoutParams.width + ", " + layoutParams.height + ")");
            }
        }

        public String toString() {
            return String.format("PercentLayoutInformation width: %f height %f, margins (%f, %f,  %f, %f, %f, %f)", new Object[]{Float.valueOf(this.f543a), Float.valueOf(this.f544b), Float.valueOf(this.f545c), Float.valueOf(this.f546d), Float.valueOf(this.f547e), Float.valueOf(this.f548f), Float.valueOf(this.f549g), Float.valueOf(this.f550h)});
        }

        public final void m565a(LayoutParams layoutParams) {
            layoutParams.width = this.f551i.width;
            layoutParams.height = this.f551i.height;
        }
    }

    /* compiled from: view_recent_post */
    public interface PercentLayoutParams {
        PercentLayoutInfo mo37a();
    }

    public PercentLayoutHelper(ViewGroup viewGroup) {
        this.f552a = viewGroup;
    }

    public final void m569a(int i, int i2) {
        if (Log.isLoggable("PercentLayout", 3)) {
            Log.d("PercentLayout", "adjustChildren: " + this.f552a + " widthMeasureSpec: " + MeasureSpec.toString(i) + " heightMeasureSpec: " + MeasureSpec.toString(i2));
        }
        int size = MeasureSpec.getSize(i);
        int size2 = MeasureSpec.getSize(i2);
        int childCount = this.f552a.getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = this.f552a.getChildAt(i3);
            LayoutParams layoutParams = childAt.getLayoutParams();
            if (Log.isLoggable("PercentLayout", 3)) {
                Log.d("PercentLayout", "should adjust " + childAt + " " + layoutParams);
            }
            if (layoutParams instanceof PercentLayoutParams) {
                PercentLayoutInfo a = ((PercentLayoutParams) layoutParams).mo37a();
                if (Log.isLoggable("PercentLayout", 3)) {
                    Log.d("PercentLayout", "using " + a);
                }
                if (a != null) {
                    if (layoutParams instanceof MarginLayoutParams) {
                        MarginLayoutParams marginLayoutParams = (MarginLayoutParams) layoutParams;
                        a.m566a(marginLayoutParams, size, size2);
                        a.f551i.leftMargin = marginLayoutParams.leftMargin;
                        a.f551i.topMargin = marginLayoutParams.topMargin;
                        a.f551i.rightMargin = marginLayoutParams.rightMargin;
                        a.f551i.bottomMargin = marginLayoutParams.bottomMargin;
                        MarginLayoutParamsCompat.a(a.f551i, MarginLayoutParamsCompat.a(marginLayoutParams));
                        MarginLayoutParamsCompat.b(a.f551i, MarginLayoutParamsCompat.b(marginLayoutParams));
                        if (a.f545c >= 0.0f) {
                            marginLayoutParams.leftMargin = (int) (((float) size) * a.f545c);
                        }
                        if (a.f546d >= 0.0f) {
                            marginLayoutParams.topMargin = (int) (((float) size2) * a.f546d);
                        }
                        if (a.f547e >= 0.0f) {
                            marginLayoutParams.rightMargin = (int) (((float) size) * a.f547e);
                        }
                        if (a.f548f >= 0.0f) {
                            marginLayoutParams.bottomMargin = (int) (((float) size2) * a.f548f);
                        }
                        if (a.f549g >= 0.0f) {
                            MarginLayoutParamsCompat.a(marginLayoutParams, (int) (((float) size) * a.f549g));
                        }
                        if (a.f550h >= 0.0f) {
                            MarginLayoutParamsCompat.b(marginLayoutParams, (int) (((float) size) * a.f550h));
                        }
                        if (Log.isLoggable("PercentLayout", 3)) {
                            Log.d("PercentLayout", "after fillMarginLayoutParams: (" + marginLayoutParams.width + ", " + marginLayoutParams.height + ")");
                        }
                    } else {
                        a.m566a(layoutParams, size, size2);
                    }
                }
            }
        }
    }

    public final boolean m570b() {
        int childCount = this.f552a.getChildCount();
        boolean z = false;
        for (int i = 0; i < childCount; i++) {
            View childAt = this.f552a.getChildAt(i);
            LayoutParams layoutParams = childAt.getLayoutParams();
            if (Log.isLoggable("PercentLayout", 3)) {
                Log.d("PercentLayout", "should handle measured state too small " + childAt + " " + layoutParams);
            }
            if (layoutParams instanceof PercentLayoutParams) {
                PercentLayoutInfo a = ((PercentLayoutParams) layoutParams).mo37a();
                if (a != null) {
                    Object obj;
                    boolean z2;
                    if ((ViewCompat.k(childAt) & -16777216) == 16777216 && a.f543a >= 0.0f && a.f551i.width == -2) {
                        obj = 1;
                    } else {
                        obj = null;
                    }
                    if (obj != null) {
                        layoutParams.width = -2;
                        z2 = true;
                    } else {
                        z2 = z;
                    }
                    if (m568b(childAt, a)) {
                        layoutParams.height = -2;
                        z = true;
                    } else {
                        z = z2;
                    }
                }
            }
        }
        if (Log.isLoggable("PercentLayout", 3)) {
            Log.d("PercentLayout", "should trigger second measure pass: " + z);
        }
        return z;
    }

    private static boolean m568b(View view, PercentLayoutInfo percentLayoutInfo) {
        return (ViewCompat.a.l(view) & -16777216) == 16777216 && percentLayoutInfo.f544b >= 0.0f && percentLayoutInfo.f551i.height == -2;
    }
}
