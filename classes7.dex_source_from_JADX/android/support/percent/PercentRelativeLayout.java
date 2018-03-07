package android.support.percent;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.percent.PercentLayoutHelper.PercentLayoutInfo;
import android.support.percent.PercentLayoutHelper.PercentLayoutParams;
import android.support.v4.view.MarginLayoutParamsCompat;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.RelativeLayout;

/* compiled from: view_deeplink_action */
public class PercentRelativeLayout extends RelativeLayout {
    private final PercentLayoutHelper f554a = new PercentLayoutHelper(this);

    /* compiled from: view_deeplink_action */
    public class LayoutParams extends android.widget.RelativeLayout.LayoutParams implements PercentLayoutParams {
        private PercentLayoutInfo f553a;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            PercentLayoutInfo percentLayoutInfo = null;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.PercentLayout_Layout);
            float fraction = obtainStyledAttributes.getFraction(0, 1, 1, -1.0f);
            if (fraction != -1.0f) {
                if (Log.isLoggable("PercentLayout", 2)) {
                    Log.v("PercentLayout", "percent width: " + fraction);
                }
                percentLayoutInfo = new PercentLayoutInfo();
                percentLayoutInfo.f543a = fraction;
            }
            fraction = obtainStyledAttributes.getFraction(1, 1, 1, -1.0f);
            if (fraction != -1.0f) {
                if (Log.isLoggable("PercentLayout", 2)) {
                    Log.v("PercentLayout", "percent height: " + fraction);
                }
                if (percentLayoutInfo == null) {
                    percentLayoutInfo = new PercentLayoutInfo();
                }
                percentLayoutInfo.f544b = fraction;
            }
            fraction = obtainStyledAttributes.getFraction(2, 1, 1, -1.0f);
            if (fraction != -1.0f) {
                if (Log.isLoggable("PercentLayout", 2)) {
                    Log.v("PercentLayout", "percent margin: " + fraction);
                }
                if (percentLayoutInfo == null) {
                    percentLayoutInfo = new PercentLayoutInfo();
                }
                percentLayoutInfo.f545c = fraction;
                percentLayoutInfo.f546d = fraction;
                percentLayoutInfo.f547e = fraction;
                percentLayoutInfo.f548f = fraction;
            }
            fraction = obtainStyledAttributes.getFraction(3, 1, 1, -1.0f);
            if (fraction != -1.0f) {
                if (Log.isLoggable("PercentLayout", 2)) {
                    Log.v("PercentLayout", "percent left margin: " + fraction);
                }
                if (percentLayoutInfo == null) {
                    percentLayoutInfo = new PercentLayoutInfo();
                }
                percentLayoutInfo.f545c = fraction;
            }
            fraction = obtainStyledAttributes.getFraction(4, 1, 1, -1.0f);
            if (fraction != -1.0f) {
                if (Log.isLoggable("PercentLayout", 2)) {
                    Log.v("PercentLayout", "percent top margin: " + fraction);
                }
                if (percentLayoutInfo == null) {
                    percentLayoutInfo = new PercentLayoutInfo();
                }
                percentLayoutInfo.f546d = fraction;
            }
            fraction = obtainStyledAttributes.getFraction(5, 1, 1, -1.0f);
            if (fraction != -1.0f) {
                if (Log.isLoggable("PercentLayout", 2)) {
                    Log.v("PercentLayout", "percent right margin: " + fraction);
                }
                if (percentLayoutInfo == null) {
                    percentLayoutInfo = new PercentLayoutInfo();
                }
                percentLayoutInfo.f547e = fraction;
            }
            fraction = obtainStyledAttributes.getFraction(6, 1, 1, -1.0f);
            if (fraction != -1.0f) {
                if (Log.isLoggable("PercentLayout", 2)) {
                    Log.v("PercentLayout", "percent bottom margin: " + fraction);
                }
                if (percentLayoutInfo == null) {
                    percentLayoutInfo = new PercentLayoutInfo();
                }
                percentLayoutInfo.f548f = fraction;
            }
            fraction = obtainStyledAttributes.getFraction(7, 1, 1, -1.0f);
            if (fraction != -1.0f) {
                if (Log.isLoggable("PercentLayout", 2)) {
                    Log.v("PercentLayout", "percent start margin: " + fraction);
                }
                if (percentLayoutInfo == null) {
                    percentLayoutInfo = new PercentLayoutInfo();
                }
                percentLayoutInfo.f549g = fraction;
            }
            fraction = obtainStyledAttributes.getFraction(8, 1, 1, -1.0f);
            if (fraction != -1.0f) {
                if (Log.isLoggable("PercentLayout", 2)) {
                    Log.v("PercentLayout", "percent end margin: " + fraction);
                }
                if (percentLayoutInfo == null) {
                    percentLayoutInfo = new PercentLayoutInfo();
                }
                percentLayoutInfo.f550h = fraction;
            }
            obtainStyledAttributes.recycle();
            if (Log.isLoggable("PercentLayout", 3)) {
                Log.d("PercentLayout", "constructed: " + percentLayoutInfo);
            }
            this.f553a = percentLayoutInfo;
        }

        public final PercentLayoutInfo mo37a() {
            if (this.f553a == null) {
                this.f553a = new PercentLayoutInfo();
            }
            return this.f553a;
        }

        protected void setBaseAttributes(TypedArray typedArray, int i, int i2) {
            this.width = typedArray.getLayoutDimension(i, 0);
            this.height = typedArray.getLayoutDimension(i2, 0);
        }
    }

    public /* synthetic */ android.view.ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return m572a(attributeSet);
    }

    public /* synthetic */ android.widget.RelativeLayout.LayoutParams m26529generateLayoutParams(AttributeSet attributeSet) {
        return m572a(attributeSet);
    }

    public PercentRelativeLayout(Context context) {
        super(context);
    }

    public PercentRelativeLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public PercentRelativeLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    private LayoutParams m572a(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    protected void onMeasure(int i, int i2) {
        this.f554a.m569a(i, i2);
        super.onMeasure(i, i2);
        if (this.f554a.m570b()) {
            super.onMeasure(i, i2);
        }
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        PercentLayoutHelper percentLayoutHelper = this.f554a;
        int childCount = percentLayoutHelper.f552a.getChildCount();
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = percentLayoutHelper.f552a.getChildAt(i5);
            android.view.ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
            if (Log.isLoggable("PercentLayout", 3)) {
                Log.d("PercentLayout", "should restore " + childAt + " " + layoutParams);
            }
            if (layoutParams instanceof PercentLayoutParams) {
                PercentLayoutInfo a = ((PercentLayoutParams) layoutParams).mo37a();
                if (Log.isLoggable("PercentLayout", 3)) {
                    Log.d("PercentLayout", "using " + a);
                }
                if (a != null) {
                    if (layoutParams instanceof MarginLayoutParams) {
                        MarginLayoutParams marginLayoutParams = (MarginLayoutParams) layoutParams;
                        a.m565a(marginLayoutParams);
                        marginLayoutParams.leftMargin = a.f551i.leftMargin;
                        marginLayoutParams.topMargin = a.f551i.topMargin;
                        marginLayoutParams.rightMargin = a.f551i.rightMargin;
                        marginLayoutParams.bottomMargin = a.f551i.bottomMargin;
                        MarginLayoutParamsCompat.a(marginLayoutParams, MarginLayoutParamsCompat.a(a.f551i));
                        MarginLayoutParamsCompat.b(marginLayoutParams, MarginLayoutParamsCompat.b(a.f551i));
                    } else {
                        a.m565a(layoutParams);
                    }
                }
            }
        }
    }
}
