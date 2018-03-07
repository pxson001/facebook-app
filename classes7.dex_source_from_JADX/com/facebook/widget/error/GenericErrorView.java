package com.facebook.widget.error;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.facebook.widget.CustomFrameLayout;

/* compiled from: delayAskingMillis */
public class GenericErrorView extends CustomFrameLayout {
    private final ImageView f16016a;
    private final TextView f16017b;

    public GenericErrorView(Context context) {
        this(context, null);
    }

    public GenericErrorView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setContentView(2130904583);
        View c = c(2131562506);
        c.setVisibility(0);
        this.f16016a = (ImageView) c.findViewById(2131562507);
        this.f16017b = (TextView) c.findViewById(2131561724);
    }

    public final void m19992a() {
        m19991a(2131230760, 2130841702);
    }

    public final void m19993b() {
        m19991a(2131230761, -1);
    }

    public void setCustomErrorMessage(int i) {
        m19991a(i, -1);
    }

    private void m19991a(int i, int i2) {
        this.f16017b.setText(i);
        if (i2 >= 0) {
            this.f16016a.setImageResource(i2);
            this.f16016a.setVisibility(0);
            return;
        }
        this.f16016a.setVisibility(8);
    }
}
