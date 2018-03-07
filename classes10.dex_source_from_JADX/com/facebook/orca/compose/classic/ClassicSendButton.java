package com.facebook.orca.compose.classic;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.TextView;
import com.facebook.widget.CustomFrameLayout;

/* compiled from: openDialog */
public class ClassicSendButton extends CustomFrameLayout {
    private final TextView f5770a;
    private final ImageView f5771b;
    public ButtonMode f5772c;

    /* compiled from: openDialog */
    public enum ButtonMode {
        SEND_BUTTON,
        LIKE_BUTTON
    }

    public ClassicSendButton(Context context) {
        this(context, null);
    }

    public ClassicSendButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ClassicSendButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f5772c = ButtonMode.SEND_BUTTON;
        setContentView(2130903651);
        this.f5770a = (TextView) c(2131560484);
        this.f5771b = (ImageView) c(2131560485);
    }

    public void setEnabled(boolean z) {
        super.setEnabled(z);
        if (z) {
            this.f5770a.setShadowLayer(1.0f, 0.0f, 1.0f, 2131362341);
        } else {
            this.f5770a.setShadowLayer(1.0f, 0.0f, 1.0f, 0);
        }
    }

    public final void m5451a() {
        this.f5770a.setVisibility(0);
        this.f5771b.setVisibility(4);
        this.f5772c = ButtonMode.SEND_BUTTON;
    }

    public final void m5452b() {
        this.f5771b.setVisibility(0);
        this.f5770a.setVisibility(4);
        this.f5772c = ButtonMode.LIKE_BUTTON;
    }

    public ButtonMode getButtonMode() {
        return this.f5772c;
    }
}
