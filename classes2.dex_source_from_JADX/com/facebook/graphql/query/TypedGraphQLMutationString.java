package com.facebook.graphql.query;

import java.util.Set;
import javax.annotation.Nullable;

/* compiled from: reshares.count */
public class TypedGraphQLMutationString<T> extends TypedGraphQlQueryString<T> {
    public ShimmedMutationRequestParams f7107b;
    public final String f7108f;

    public TypedGraphQLMutationString(Class cls, boolean z, String str, String str2, String str3, String str4, @Nullable String str5, @Nullable Set<String> set) {
        super(cls, z, str, str2, str3, str5, set);
        this.f7108f = str4;
        this.f7107b = null;
    }

    @Deprecated
    public TypedGraphQLMutationString(Class cls, boolean z, String str, String str2, String str3, String str4, @Nullable String str5, @Nullable Set<String> set, ShimmedMutationRequestParams shimmedMutationRequestParams) {
        super(cls, z, str, str2, str3, str5, set);
        this.f7108f = str4;
        this.f7107b = shimmedMutationRequestParams;
    }

    public final boolean mo1640i() {
        return true;
    }

    public final boolean m11618n() {
        return this.f7107b != null;
    }
}
