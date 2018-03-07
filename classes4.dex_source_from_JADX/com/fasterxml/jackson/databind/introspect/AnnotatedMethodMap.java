package com.fasterxml.jackson.databind.introspect;

import java.lang.reflect.Method;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;

/* compiled from: video_data_source */
public final class AnnotatedMethodMap implements Iterable<AnnotatedMethod> {
    protected LinkedHashMap<MemberKey, AnnotatedMethod> f298a;

    public final void m453a(AnnotatedMethod annotatedMethod) {
        if (this.f298a == null) {
            this.f298a = new LinkedHashMap();
        }
        this.f298a.put(new MemberKey(annotatedMethod.f299a), annotatedMethod);
    }

    public final AnnotatedMethod m452a(Method method) {
        if (this.f298a != null) {
            return (AnnotatedMethod) this.f298a.remove(new MemberKey(method));
        }
        return null;
    }

    public final boolean m454a() {
        return this.f298a == null || this.f298a.size() == 0;
    }

    public final AnnotatedMethod m451a(String str, Class<?>[] clsArr) {
        if (this.f298a == null) {
            return null;
        }
        return (AnnotatedMethod) this.f298a.get(new MemberKey(str, clsArr));
    }

    public final AnnotatedMethod m455b(Method method) {
        if (this.f298a == null) {
            return null;
        }
        return (AnnotatedMethod) this.f298a.get(new MemberKey(method));
    }

    public final Iterator<AnnotatedMethod> iterator() {
        if (this.f298a != null) {
            return this.f298a.values().iterator();
        }
        return Collections.emptyList().iterator();
    }
}
