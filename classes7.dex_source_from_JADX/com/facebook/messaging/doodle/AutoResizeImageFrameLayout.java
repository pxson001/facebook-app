package com.facebook.messaging.doodle;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import com.facebook.common.util.ContextUtils;
import com.facebook.common.util.MathUtil;

/* compiled from: onPositiveButtonClicked */
public class AutoResizeImageFrameLayout extends FrameLayout {
    private int f7794a;

    public AutoResizeImageFrameLayout(Context context) {
        super(context);
        m9419a();
    }

    public AutoResizeImageFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m9419a();
    }

    public AutoResizeImageFrameLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m9419a();
    }

    private void m9419a() {
        this.f7794a = ContextUtils.e(getContext(), 16843499, 0);
    }

    protected void onMeasure(int i, int i2) {
        ImageView imageView;
        int childCount = getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = getChildAt(i3);
            if (childAt instanceof ImageView) {
                imageView = (ImageView) childAt;
                break;
            }
        }
        imageView = null;
        if (imageView == null || imageView.getDrawable() == null) {
            super.onMeasure(i, i2);
            return;
        }
        Drawable drawable = imageView.getDrawable();
        float height = (float) getRootView().getHeight();
        int intrinsicWidth = drawable.getIntrinsicWidth();
        int intrinsicHeight = drawable.getIntrinsicHeight();
        float max = Math.max((float) MeasureSpec.getSize(i2), height);
        height = (float) MeasureSpec.getSize(i);
        float f = ((float) intrinsicWidth) / ((float) intrinsicHeight);
        float f2 = f * max;
        float f3 = height / f;
        if (f3 > max) {
            f3 = max * f;
            height = max;
        } else if (f2 > height) {
            float f4 = f3;
            f3 = height;
            height = f4;
        } else {
            height = f3;
            f3 = f2;
        }
        setMeasuredDimension((int) f3, (int) height);
        int makeMeasureSpec = MeasureSpec.makeMeasureSpec((int) f3, 1073741824);
        for (intrinsicWidth = 0; intrinsicWidth < childCount; intrinsicWidth++) {
            View childAt2 = getChildAt(intrinsicWidth);
            if (!(childAt2 == null || childAt2.getVisibility() == 8)) {
                MarginLayoutParams marginLayoutParams = (MarginLayoutParams) childAt2.getLayoutParams();
                childAt2.measure(makeMeasureSpec, MeasureSpec.makeMeasureSpec((int) Math.min(height, (max - ((float) marginLayoutParams.topMargin)) - ((float) marginLayoutParams.bottomMargin)), 1073741824));
            }
        }
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        View findFocus = findFocus();
        if (findFocus instanceof EditText) {
            EditText editText = (EditText) findFocus;
            if (i2 < 0) {
                float abs = (float) Math.abs(i2);
                m9420a((int) MathUtil.b(((float) (((i2 + i4) + this.f7794a) / 2)) - ((float) ((editText.getLineHeight() / 2) + (((((getRootView().getHeight() - ((View) editText.getParent()).getMeasuredHeight()) / 2) + i2) + editText.getTop()) + (m9418a(editText) * editText.getLineHeight())))), -abs, abs));
                return;
            } else if (getMeasuredHeight() <= i4) {
                offsetTopAndBottom(this.f7794a / 2);
            }
        }
        super.onLayout(z, i, i2, i3, i4);
    }

    private void m9420a(int i) {
        int childCount = getChildCount();
        int paddingLeft = getPaddingLeft();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            if (childAt.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                int measuredWidth = childAt.getMeasuredWidth();
                int measuredHeight = childAt.getMeasuredHeight();
                int i3 = layoutParams.leftMargin + paddingLeft;
                int i4 = layoutParams.topMargin + i;
                if (VERSION.SDK_INT < 11) {
                    i4 = i;
                }
                childAt.layout(i3, i4, measuredWidth + i3, measuredHeight + i4);
            }
        }
    }

    private static int m9418a(EditText editText) {
        int selectionStart = editText.getSelectionStart();
        if (selectionStart != -1) {
            return editText.getLayout().getLineForOffset(selectionStart);
        }
        return -1;
    }
}
