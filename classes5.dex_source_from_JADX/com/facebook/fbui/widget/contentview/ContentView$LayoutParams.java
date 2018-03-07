package com.facebook.fbui.widget.contentview;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import com.facebook.R;
import com.facebook.fbui.widget.layout.ImageBlockLayout.LayoutParams;

/* compiled from: XGROUP_ITEMS_FOR_SALE_NOTIFICATION */
public class ContentView$LayoutParams extends LayoutParams {
    public UseViewAs f12231e = UseViewAs.NONE;

    /* compiled from: XGROUP_ITEMS_FOR_SALE_NOTIFICATION */
    public enum UseViewAs {
        TITLE,
        SUBTITLE,
        META,
        NONE
    }

    public ContentView$LayoutParams(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ContentView_LayoutParams);
        this.f12231e = UseViewAs.values()[obtainStyledAttributes.getInt(0, UseViewAs.NONE.ordinal())];
        obtainStyledAttributes.recycle();
    }

    public ContentView$LayoutParams(int i, int i2) {
        super(i, i2);
    }
}
