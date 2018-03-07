package com.facebook.feedplugins.base.footer.ui;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.fbui.widget.text.GlyphWithTextView;
import com.facebook.multirow.api.ViewType;
import com.facebook.widget.CustomLinearLayout;

/* compiled from: Sync Exception */
public class TwoButtonFooterView extends CustomLinearLayout {
    public static final ViewType f23036a = new C19901();
    private final GlyphWithTextView f23037b = ((GlyphWithTextView) a(2131568143));
    private final GlyphWithTextView f23038c = ((GlyphWithTextView) a(2131568144));

    /* compiled from: Sync Exception */
    final class C19901 extends ViewType {
        C19901() {
        }

        public final View m25499a(Context context) {
            return new TwoButtonFooterView(context);
        }
    }

    /* compiled from: Sync Exception */
    public enum Button {
        LEFT,
        RIGHT
    }

    public TwoButtonFooterView(Context context) {
        super(context);
        setContentView(2130907569);
        setOrientation(1);
    }

    private GlyphWithTextView m25500a(Button button) {
        switch (button) {
            case LEFT:
                return this.f23037b;
            case RIGHT:
                return this.f23038c;
            default:
                throw new IllegalArgumentException("Invalid button location");
        }
    }

    public final void m25504a(Button button, CharSequence charSequence) {
        m25500a(button).setText(charSequence);
    }

    public final void m25502a(Button button, Drawable drawable) {
        m25500a(button).setImageDrawable(drawable);
    }

    public final void m25501a(Button button, int i) {
        m25500a(button).setGlyphColor(i);
    }

    public final void m25505b(Button button, int i) {
        m25500a(button).setTextColor(getResources().getColor(i));
    }

    public final void m25503a(Button button, OnClickListener onClickListener) {
        m25500a(button).setOnClickListener(onClickListener);
    }
}
