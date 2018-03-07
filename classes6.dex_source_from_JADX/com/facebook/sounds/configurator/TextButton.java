package com.facebook.sounds.configurator;

import android.content.Context;
import android.util.AttributeSet;

/* compiled from: event_purchase_tickets_async */
public class TextButton extends SpringTextView {
    public TextButtonListener f16043b;

    /* compiled from: event_purchase_tickets_async */
    public interface TextButtonListener {
        void mo1233a();
    }

    /* compiled from: event_purchase_tickets_async */
    public interface OnLongPressListener {
    }

    /* compiled from: event_purchase_tickets_async */
    public class TapControllerListener {
        final /* synthetic */ TextButton f16042a;

        public TapControllerListener(TextButton textButton) {
            this.f16042a = textButton;
        }

        public final void m23662a() {
            if (this.f16042a.f16043b != null) {
                this.f16042a.f16043b.mo1233a();
            }
        }
    }

    public TextButton(Context context) {
        this(context, null);
    }

    private TextButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private TextButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f16028e.f16036e = new TapControllerListener(this);
    }
}
