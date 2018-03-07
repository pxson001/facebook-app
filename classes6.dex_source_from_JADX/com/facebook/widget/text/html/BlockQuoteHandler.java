package com.facebook.widget.text.html;

import android.text.Editable;
import com.facebook.widget.text.span.FbQuoteSpan;
import com.facebook.widget.text.span.SpanUtils;
import org.xml.sax.Attributes;

/* compiled from: com.google.android.gms.maps.internal.ICameraUpdateFactoryDelegate */
public class BlockQuoteHandler extends SimpleTagHandler {
    public BlockQuoteHandler() {
        super("blockquote");
    }

    public final boolean mo1503a(String str, Attributes attributes, Editable editable) {
        if (!super.mo1503a(str, attributes, editable)) {
            return false;
        }
        SpanUtils.a(editable);
        return true;
    }

    protected final void mo1504a(Object obj, int i, int i2, Editable editable) {
        FbQuoteSpan fbQuoteSpan = new FbQuoteSpan();
        SpanUtils.a(editable);
        editable.setSpan(fbQuoteSpan, i, editable.length(), 33);
    }
}
