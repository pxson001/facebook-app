package com.facebook.widget.text.html;

import android.text.Editable;
import org.xml.sax.Attributes;

/* compiled from: com.google.android.gms.maps.internal.ICancelableCallback */
public abstract class SimpleTagHandler extends BaseTagHandler {
    private final String f19874a;

    /* compiled from: com.google.android.gms.maps.internal.ICancelableCallback */
    public class Marker {
        public final Object f19887a;

        public Marker(Object obj) {
            this.f19887a = obj;
        }
    }

    protected abstract void mo1504a(Object obj, int i, int i2, Editable editable);

    public SimpleTagHandler(String str) {
        this.f19874a = str != null ? str.toLowerCase() : null;
    }

    public boolean mo1503a(String str, Attributes attributes, Editable editable) {
        if (!str.equalsIgnoreCase(this.f19874a)) {
            return false;
        }
        m28599a(editable, (Object) this);
        return true;
    }

    public boolean mo1502a(String str, Editable editable) {
        if (!str.equalsIgnoreCase(this.f19874a)) {
            return false;
        }
        m28603b(editable, this);
        return true;
    }

    protected static void m28599a(Editable editable, Object obj) {
        int length = editable.length();
        editable.setSpan(new Marker(obj), length, length, 17);
    }

    protected final void m28603b(Editable editable, Object obj) {
        Marker marker;
        Marker[] markerArr = (Marker[]) editable.getSpans(0, editable.length(), Marker.class);
        int length = markerArr.length - 1;
        while (length >= 0) {
            if (markerArr[length].f19887a == obj) {
                marker = markerArr[length];
                break;
            }
        }
        marker = null;
        Marker marker2 = marker;
        if (marker2 != null) {
            int spanStart = editable.getSpanStart(marker2);
            int length2 = editable.length();
            editable.removeSpan(marker2);
            mo1504a(obj, spanStart, length2, editable);
        }
    }
}
