package com.facebook.groups.editsettings.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import com.facebook.fbui.widget.text.layoutbuilder.TextLayoutBuilder;
import com.facebook.feed.rows.views.AccessibleTextLayoutView;

/* compiled from: URI Widget */
public class SimpleAccessibleTextLayoutView extends AccessibleTextLayoutView {
    public TextLayoutBuilder f21785a;

    public SimpleAccessibleTextLayoutView(Context context) {
        super(context);
    }

    public SimpleAccessibleTextLayoutView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void setLayoutBuilder(TextLayoutBuilder textLayoutBuilder) {
        this.f21785a = textLayoutBuilder;
    }

    protected void onMeasure(int i, int i2) {
        if (this.f21785a == null) {
            super.onMeasure(i, i2);
            return;
        }
        int size = (MeasureSpec.getSize(i) - getPaddingLeft()) - getPaddingRight();
        if (getLayout() == null || size != getLayout().getWidth()) {
            this.a = this.f21785a.a(size).d();
        }
        setMeasuredDimension((size + getPaddingLeft()) + getPaddingRight(), (getPaddingBottom() + getPaddingTop()) + getLayout().getHeight());
    }
}
