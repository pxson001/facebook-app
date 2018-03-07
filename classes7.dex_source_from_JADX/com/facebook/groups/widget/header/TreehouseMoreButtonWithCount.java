package com.facebook.groups.widget.header;

import android.content.Context;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.facebook.widget.CustomLinearLayout;
import com.facebook.widget.text.BetterTextView;

/* compiled from: product_item_change_availability */
public class TreehouseMoreButtonWithCount extends CustomLinearLayout {
    private BetterTextView f5991a;
    private ImageView f5992b;

    public TreehouseMoreButtonWithCount(Context context) {
        super(context);
        m7699a();
    }

    public TreehouseMoreButtonWithCount(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m7699a();
    }

    public TreehouseMoreButtonWithCount(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m7699a();
    }

    private void m7699a() {
        setContentView(2130907558);
        this.f5991a = (BetterTextView) a(2131568136);
        this.f5992b = (ImageView) a(2131561743);
        this.f5992b.setColorFilter(new PorterDuffColorFilter(getResources().getColor(2131361864), Mode.SRC_IN));
    }
}
