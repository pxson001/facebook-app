package com.facebook.widget.text.html;

import android.text.Editable;
import com.facebook.widget.text.span.ListSpan;
import com.facebook.widget.text.span.SpanUtils;
import org.xml.sax.Attributes;

/* compiled from: com.google.android.gms.location.places.PlaceLikelihoodBuffer.ATTRIBUTIONS_EXTRA_KEY */
public class ListHandler extends SimpleTagHandler {
    public int f19883a = -1;
    private final int[] f19884b = new int[100];
    private final int[] f19885c = new int[100];

    public ListHandler() {
        super(null);
    }

    public final boolean mo1503a(String str, Attributes attributes, Editable editable) {
        if ("ol".equalsIgnoreCase(str)) {
            m28613a(ListSpan.f19897d);
            return true;
        } else if ("ul".equalsIgnoreCase(str)) {
            m28613a(ListSpan.f19896c);
            return true;
        } else if (!"li".equalsIgnoreCase(str)) {
            return super.mo1503a(str, attributes, editable);
        } else {
            SpanUtils.a(editable);
            SimpleTagHandler.m28599a(editable, (Object) this);
            return true;
        }
    }

    public final boolean mo1502a(String str, Editable editable) {
        if ("ol".equalsIgnoreCase(str) || "ul".equalsIgnoreCase(str)) {
            this.f19883a--;
            return true;
        } else if (!"li".equalsIgnoreCase(str)) {
            return super.mo1502a(str, editable);
        } else {
            m28603b(editable, this);
            return true;
        }
    }

    protected final void mo1504a(Object obj, int i, int i2, Editable editable) {
        int i3 = this.f19883a < 100 ? this.f19883a : 99;
        int[] iArr = this.f19885c;
        iArr[i3] = iArr[i3] + 1;
        SpanUtils.a(editable);
        ListSpan listSpan = new ListSpan();
        listSpan.f19900g = this.f19884b[i3];
        listSpan = listSpan;
        listSpan.f19901h = this.f19885c[i3];
        editable.setSpan(listSpan, i, editable.length(), 33);
    }

    private void m28613a(int i) {
        this.f19883a++;
        if (this.f19883a < 100) {
            this.f19885c[this.f19883a] = 0;
            this.f19884b[this.f19883a] = i;
        }
    }
}
