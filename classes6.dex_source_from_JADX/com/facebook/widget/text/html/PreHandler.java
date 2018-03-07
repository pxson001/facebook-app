package com.facebook.widget.text.html;

import android.text.Editable;
import android.text.style.BackgroundColorSpan;
import android.text.style.TypefaceSpan;
import com.facebook.widget.text.span.FbQuoteSpan;
import com.facebook.widget.text.span.SpanUtils;
import org.xml.sax.Attributes;

/* compiled from: com.google.android.gms.location.places.PlaceDetectionApi */
public class PreHandler extends SimpleTagHandler {
    private boolean f19886a = false;

    public PreHandler() {
        super(null);
    }

    public final boolean mo1503a(String str, Attributes attributes, Editable editable) {
        if ("pre".equals(str)) {
            SpanUtils.a(editable);
            SimpleTagHandler.m28599a(editable, (Object) "pre");
            this.f19886a = true;
            return true;
        } else if (!"code".equals(str)) {
            return false;
        } else {
            SimpleTagHandler.m28599a(editable, (Object) "code");
            return true;
        }
    }

    public final boolean mo1502a(String str, Editable editable) {
        if ("pre".equals(str)) {
            m28603b(editable, "pre");
            this.f19886a = false;
            return true;
        } else if (!"code".equals(str)) {
            return false;
        } else {
            m28603b(editable, "code");
            return true;
        }
    }

    protected final void mo1504a(Object obj, int i, int i2, Editable editable) {
        if (obj.equals("pre")) {
            SpanUtils.a(editable);
            editable.setSpan(new FbQuoteSpan().mo1506a(-7829368), i, editable.length(), 33);
        } else if (obj.equals("code")) {
            if (!this.f19886a) {
                editable.setSpan(new BackgroundColorSpan(-1118482), i, i2, 33);
            }
            editable.setSpan(new TypefaceSpan("monospace"), i, i2, 33);
        }
    }

    public final boolean mo1505a(char[] cArr, int i, int i2, Editable editable) {
        if (!this.f19886a) {
            return false;
        }
        editable.append(new String(cArr, i, i2));
        return true;
    }
}
