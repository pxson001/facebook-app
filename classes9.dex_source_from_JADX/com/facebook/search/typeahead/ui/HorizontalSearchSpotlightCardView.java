package com.facebook.search.typeahead.ui;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import com.facebook.widget.CustomFrameLayout;
import com.facebook.widget.text.BetterTextView;

/* compiled from: user_phone_number_add */
public class HorizontalSearchSpotlightCardView extends CustomFrameLayout {
    private BetterTextView f707a;

    public HorizontalSearchSpotlightCardView(Context context) {
        super(context);
        m786a();
    }

    public HorizontalSearchSpotlightCardView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        m786a();
    }

    protected HorizontalSearchSpotlightCardView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m786a();
    }

    private void m786a() {
        setContentView(2130904795);
        this.f707a = (BetterTextView) findViewById(2131562923);
    }

    public void setText(CharSequence charSequence) {
        this.f707a.setText(charSequence);
    }

    public void setBackground(Drawable drawable) {
        if (VERSION.SDK_INT >= 16) {
            this.f707a.setBackground(drawable);
        } else {
            this.f707a.setBackgroundDrawable(drawable);
        }
    }
}
