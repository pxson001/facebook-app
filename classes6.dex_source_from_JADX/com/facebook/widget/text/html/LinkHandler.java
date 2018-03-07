package com.facebook.widget.text.html;

import android.text.Editable;
import com.facebook.widget.text.span.FbUrlSpan;
import org.xml.sax.Attributes;

/* compiled from: com.google.android.gms.location.places.internal.IGooglePlaceDetectionService */
public class LinkHandler extends SimpleTagHandler {
    private String f19882a;

    public LinkHandler() {
        super("a");
    }

    public final boolean mo1503a(String str, Attributes attributes, Editable editable) {
        if ("a".equalsIgnoreCase(str)) {
            this.f19882a = attributes.getValue("href");
        }
        return super.mo1503a(str, attributes, editable);
    }

    protected final void mo1504a(Object obj, int i, int i2, Editable editable) {
        FbUrlSpan fbUrlSpan = new FbUrlSpan(this.f19882a);
        fbUrlSpan.f19894c = false;
        fbUrlSpan = fbUrlSpan;
        fbUrlSpan.f19893b = false;
        fbUrlSpan = fbUrlSpan;
        fbUrlSpan.f19892a = -13215591;
        editable.setSpan(fbUrlSpan, i, i2, 33);
    }
}
