package com.facebook.widget.text.html;

import android.text.Editable;
import com.facebook.widget.text.span.HorizontalRuleSpan;
import com.facebook.widget.text.span.SpanUtils;

/* compiled from: com.google.android.gms.location.places.internal.IPlacesCallbacks */
public class HrHandler extends SimpleTagHandler {
    public HrHandler() {
        super("hr");
    }

    protected final void mo1504a(Object obj, int i, int i2, Editable editable) {
        SpanUtils.a(editable).append("---\n");
        int length = editable.length();
        editable.setSpan(new HorizontalRuleSpan(), (length - 3) - 1, length - 1, 33);
    }
}
