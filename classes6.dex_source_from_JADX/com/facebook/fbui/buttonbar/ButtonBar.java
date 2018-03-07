package com.facebook.fbui.buttonbar;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.facebook.fbui.widget.text.caps.AllCapsTransformationMethod;
import javax.inject.Inject;

/* compiled from: no_face_photo_tag */
public class ButtonBar extends LinearLayout {
    private static final int[] f9952b = new int[]{2130772553};
    @Inject
    AllCapsTransformationMethod f9953a;
    private boolean f9954c;

    public ButtonBar(Context context) {
        super(context);
    }

    public ButtonBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f9952b);
        this.f9954c = obtainStyledAttributes.getBoolean(0, false);
        obtainStyledAttributes.recycle();
    }

    public void addView(View view, int i, LayoutParams layoutParams) {
        super.addView(view, i, layoutParams);
        if (view instanceof TextView) {
            ((TextView) view).setTransformationMethod(this.f9953a);
        }
    }

    protected void onMeasure(int i, int i2) {
        boolean b;
        setOrientation(0);
        super.onMeasure(i, i2);
        if (this.f9954c) {
            b = m15669b();
        } else {
            b = m15668a();
        }
        if (b) {
            setOrientation(1);
            super.onMeasure(i, i2);
        }
    }

    private boolean m15668a() {
        int childCount = getChildCount();
        int i = 0;
        for (int i2 = 0; i2 < childCount; i2++) {
            if (getChildAt(i2).getVisibility() != 8) {
                i++;
            }
        }
        float measuredWidth = ((float) getMeasuredWidth()) / ((float) i);
        for (i = 0; i < childCount; i++) {
            if (((float) getChildAt(i).getMeasuredWidth()) > measuredWidth) {
                return true;
            }
        }
        return false;
    }

    private boolean m15669b() {
        int childCount = getChildCount();
        float measuredWidth = (float) getMeasuredWidth();
        int i = 0;
        int i2 = 0;
        while (i < childCount) {
            int a;
            View childAt = getChildAt(i);
            if (childAt.getVisibility() == 0) {
                if (childAt instanceof TextView) {
                    a = m15667a((TextView) childAt) + i2;
                } else {
                    a = childAt.getMeasuredWidth() + i2;
                }
                if (((float) a) > measuredWidth) {
                    return true;
                }
            } else {
                a = i2;
            }
            i++;
            i2 = a;
        }
        return false;
    }

    private static int m15667a(TextView textView) {
        int i = 0;
        int i2 = 0;
        while (i < textView.getLayout().getLineCount()) {
            i2 = (int) (((float) i2) + textView.getLayout().getLineWidth(i));
            i++;
        }
        return (textView.getCompoundPaddingLeft() + i2) + textView.getCompoundPaddingRight();
    }
}
