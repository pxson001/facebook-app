package com.facebook.http.entity.mime.apache;

import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/* compiled from: disclaimer_body */
public class Header implements Iterable<MinimalField> {
    public final List<MinimalField> f5027a = new LinkedList();
    public final Map<String, List<MinimalField>> f5028b = new HashMap();

    public final MinimalField m9960a(String str) {
        if (str == null) {
            return null;
        }
        List list = (List) this.f5028b.get(str.toLowerCase(Locale.US));
        return (list == null || list.isEmpty()) ? null : (MinimalField) list.get(0);
    }

    public Iterator<MinimalField> iterator() {
        return Collections.unmodifiableList(this.f5027a).iterator();
    }

    public String toString() {
        return this.f5027a.toString();
    }
}
