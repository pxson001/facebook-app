package com.facebook.widget.accessibility;

import android.text.Spanned;
import android.text.style.ClickableSpan;
import android.view.View;

/* compiled from: com.google.android.gms.maps.internal.IOnInfoWindowClickListener */
public class TextViewAccessibilityDelegate<V extends View & ClickableSpanAccessibilityDelegator> extends ClickableSpanAccessibilityDelegate {
    private V f19789b;

    public TextViewAccessibilityDelegate(V v) {
        super(v);
        this.f19789b = v;
    }

    public final ClickableSpan[] m28512f() {
        if (!(((ClickableSpanAccessibilityDelegator) this.f19789b).getText() instanceof Spanned)) {
            return new ClickableSpan[0];
        }
        Spanned spanned = (Spanned) ((ClickableSpanAccessibilityDelegator) this.f19789b).getText();
        return (ClickableSpan[]) spanned.getSpans(0, spanned.length(), ClickableSpan.class);
    }

    public final ClickableSpan m28511c(int i) {
        ClickableSpan[] f = m28512f();
        if (f == null || f.length <= i) {
            return null;
        }
        return f[i];
    }
}
