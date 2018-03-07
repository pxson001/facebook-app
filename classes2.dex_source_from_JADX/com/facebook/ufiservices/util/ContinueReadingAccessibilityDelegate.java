package com.facebook.ufiservices.util;

import android.text.Spanned;
import android.text.style.ClickableSpan;
import android.view.View;
import com.facebook.widget.accessibility.ClickableSpanAccessibilityDelegate;
import com.facebook.widget.accessibility.ClickableSpanAccessibilityDelegator;

/* compiled from: is_cancellation_requested */
public class ContinueReadingAccessibilityDelegate<V extends View & ClickableSpanAccessibilityDelegator> extends ClickableSpanAccessibilityDelegate {
    private V f19228b;

    public ContinueReadingAccessibilityDelegate(V v) {
        super(v);
        this.f19228b = v;
    }

    protected final ClickableSpan[] mo3098c(int i, int i2) {
        if (((ClickableSpanAccessibilityDelegator) this.f19228b).getText() instanceof Spanned) {
            return (ClickableSpan[]) ((Spanned) ((ClickableSpanAccessibilityDelegator) this.f19228b).getText()).getSpans(i, i2, ContinueReadingSpan.class);
        }
        return null;
    }
}
