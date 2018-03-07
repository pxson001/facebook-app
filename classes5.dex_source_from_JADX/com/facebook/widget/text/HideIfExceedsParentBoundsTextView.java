package com.facebook.widget.text;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.facebook.resources.ui.FbTextView;

/* compiled from: com.facebook.imagepipeline.animated.factory.AnimatedFactoryImplSupport */
public class HideIfExceedsParentBoundsTextView extends FbTextView {
    private int f5871a = 0;

    public HideIfExceedsParentBoundsTextView(Context context) {
        super(context);
    }

    public HideIfExceedsParentBoundsTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public HideIfExceedsParentBoundsTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void setVisibility(int i) {
        this.f5871a = i;
        if (this.f5871a == 0) {
            m10611a();
        } else {
            super.setVisibility(this.f5871a);
        }
    }

    protected void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        super.onTextChanged(charSequence, i, i2, i3);
        m10611a();
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        m10611a();
    }

    private void m10611a() {
        if (this.f5871a == 0) {
            View view = (View) getParent();
            if (view != null) {
                Object obj;
                int i;
                if (getRight() > view.getRight() - view.getPaddingRight()) {
                    obj = 1;
                } else {
                    obj = null;
                }
                if (obj != null) {
                    i = 4;
                } else {
                    i = 0;
                }
                super.setVisibility(i);
            }
        }
    }
}
