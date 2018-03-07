package com.facebook.graphql.query;

import java.util.Set;
import javax.annotation.Nullable;

/* compiled from: route */
public class TypedGraphQlQueryString<T> extends GraphQlQueryString {
    public final Class f6526c;
    public final boolean f6527d;
    public final String f6528e;

    public final /* synthetic */ GraphQlQueryString mo1608a(boolean z) {
        return m11306b(z);
    }

    public TypedGraphQlQueryString(Class cls, boolean z, String str, String str2, String str3, @Nullable String str4, @Nullable Set<String> set) {
        super(str, str2, str4, set);
        this.f6526c = cls;
        this.f6527d = z;
        this.f6528e = str3;
    }

    public final TypedGraphQlQueryString m11306b(boolean z) {
        super.mo1608a(z);
        return this;
    }

    public final Class m11307p() {
        return this.f6526c;
    }

    public final String m11308q() {
        return this.f6528e;
    }
}
