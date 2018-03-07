package com.facebook.fbui.widget.header;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import com.facebook.widget.CustomFrameLayout;

@Deprecated
/* compiled from: argument_stack_container_id */
public class SectionHeaderView extends CustomFrameLayout {
    private static final int[] f19119a = new int[]{16843087, 16843049, 16843049};
    private TextView f19120b;
    private View f19121c;
    private View f19122d;

    public SectionHeaderView(Context context) {
        super(context, null, 0);
        m22672a(context, null);
    }

    public SectionHeaderView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        m22672a(context, attributeSet);
    }

    public SectionHeaderView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m22672a(context, attributeSet);
    }

    private void m22672a(Context context, AttributeSet attributeSet) {
        setContentView(2130904272);
        this.f19120b = (TextView) c(2131559201);
        this.f19121c = c(2131561853);
        this.f19122d = c(2131561854);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f19119a);
        int resourceId = obtainStyledAttributes.getResourceId(0, 0);
        if (resourceId != 0) {
            setTitleText(resourceId);
        }
        resourceId = obtainStyledAttributes.getResourceId(1, 0);
        if (resourceId != 0) {
            setTopDivider(resourceId);
        }
        resourceId = obtainStyledAttributes.getResourceId(2, 0);
        if (resourceId != 0) {
            setBottomDivider(resourceId);
        }
        obtainStyledAttributes.recycle();
    }

    public void setTitleText(String str) {
        this.f19120b.setText(str);
    }

    public void setTitleText(int i) {
        this.f19120b.setText(i);
    }

    public void setTopDivider(int i) {
        this.f19121c.setBackgroundResource(i);
    }

    public void setBottomDivider(int i) {
        this.f19122d.setBackgroundResource(i);
    }
}
