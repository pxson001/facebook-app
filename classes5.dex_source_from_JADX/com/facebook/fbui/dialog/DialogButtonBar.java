package com.facebook.fbui.dialog;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.facebook.fbui.widget.text.caps.AllCapsTransformationMethod;
import com.facebook.inject.FbInjector;
import javax.inject.Inject;

/* compiled from: reshareOriginalPost */
public class DialogButtonBar extends LinearLayout {
    private static final int[] f3127b = new int[]{2130772459};
    @Inject
    public AllCapsTransformationMethod f3128a;
    private boolean f3129c;

    private static <T extends View> void m4232a(Class<T> cls, T t) {
        m4233a((Object) t, t.getContext());
    }

    private static void m4233a(Object obj, Context context) {
        ((DialogButtonBar) obj).f3128a = AllCapsTransformationMethod.b(FbInjector.get(context));
    }

    public DialogButtonBar(Context context) {
        super(context);
        m4232a(DialogButtonBar.class, (View) this);
    }

    public DialogButtonBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m4232a(DialogButtonBar.class, (View) this);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f3127b);
        this.f3129c = obtainStyledAttributes.getBoolean(0, false);
        obtainStyledAttributes.recycle();
    }

    public void addView(View view, int i, LayoutParams layoutParams) {
        super.addView(view, i, layoutParams);
        if (view instanceof TextView) {
            ((TextView) view).setTransformationMethod(this.f3128a);
        }
    }

    protected void onMeasure(int i, int i2) {
        boolean b;
        setOrientation(0);
        super.onMeasure(i, i2);
        if (this.f3129c) {
            b = m4235b();
        } else {
            b = m4234a();
        }
        if (b) {
            setOrientation(1);
            super.onMeasure(i, i2);
        }
    }

    private boolean m4234a() {
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

    private boolean m4235b() {
        int childCount = getChildCount();
        float measuredWidth = (float) getMeasuredWidth();
        int i = 0;
        int i2 = 0;
        while (i < childCount) {
            int a;
            View childAt = getChildAt(i);
            if (childAt.getVisibility() == 0) {
                if (childAt instanceof TextView) {
                    a = m4230a((TextView) childAt) + i2;
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

    private static int m4230a(TextView textView) {
        int i = 0;
        int lineCount = textView.getLayout().getLineCount();
        int i2 = 0;
        while (i < lineCount) {
            i2 = (int) (((float) i2) + textView.getLayout().getLineWidth(i));
            i++;
        }
        return (textView.getCompoundPaddingLeft() + i2) + (textView.getCompoundPaddingRight() * lineCount);
    }

    private void m4231a(AllCapsTransformationMethod allCapsTransformationMethod) {
        this.f3128a = allCapsTransformationMethod;
    }
}
