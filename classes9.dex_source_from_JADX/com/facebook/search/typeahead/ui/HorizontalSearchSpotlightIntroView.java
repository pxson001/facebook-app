package com.facebook.search.typeahead.ui;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import com.facebook.widget.CustomFrameLayout;
import com.facebook.widget.text.BetterTextView;

/* compiled from: user_payment_tokens */
public class HorizontalSearchSpotlightIntroView extends CustomFrameLayout {
    private BetterTextView f708a;

    public HorizontalSearchSpotlightIntroView(Context context) {
        super(context);
        m787a();
    }

    public HorizontalSearchSpotlightIntroView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        m787a();
    }

    protected HorizontalSearchSpotlightIntroView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m787a();
    }

    private void m787a() {
        setContentView(2130904797);
        this.f708a = (BetterTextView) findViewById(2131562924);
    }

    public void setText(CharSequence charSequence) {
        this.f708a.setText(charSequence);
    }
}
