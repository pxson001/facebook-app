package com.facebook.richdocument.view.transition;

import com.facebook.richdocument.view.transition.ViewAttribute.ViewAttributeType;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/* compiled from: originalHours */
public final class ViewAttributes {
    public final Map<ViewAttributeType, ViewAttribute> f6999a;

    public ViewAttributes() {
        this.f6999a = new HashMap();
    }

    public ViewAttributes(ViewAttributes viewAttributes) {
        this();
        for (Entry entry : viewAttributes.f6999a.entrySet()) {
            this.f6999a.put(entry.getKey(), ((ViewAttribute) entry.getValue()).mo414c());
        }
    }

    public final void m7297a(ViewAttribute viewAttribute) {
        this.f6999a.put(viewAttribute.mo412a(), viewAttribute);
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return this.f6999a.equals(((ViewAttributes) obj).f6999a);
    }

    public final int hashCode() {
        return this.f6999a.hashCode();
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder(32);
        stringBuilder.append("[");
        for (ViewAttribute append : this.f6999a.values()) {
            stringBuilder.append(append);
            stringBuilder.append(", ");
        }
        int lastIndexOf = stringBuilder.lastIndexOf(", ");
        if (lastIndexOf != -1) {
            stringBuilder.delete(lastIndexOf, lastIndexOf + 2);
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}
