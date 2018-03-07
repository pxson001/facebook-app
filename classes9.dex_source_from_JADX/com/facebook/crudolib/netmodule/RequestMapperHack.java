package com.facebook.crudolib.netmodule;

import com.facebook.saved2.graphql.FetchSaved2ItemsGraphQL;

/* compiled from: ThreadDisplayCache */
public class RequestMapperHack {
    public final String m26077a(int i) {
        switch (i) {
            case 0:
                return FetchSaved2ItemsGraphQL.a().d;
            default:
                throw new IllegalArgumentException("requestIdentity=" + i);
        }
    }

    public final String m26078b(int i) {
        switch (i) {
            case 0:
                return FetchSaved2ItemsGraphQL.a().b;
            default:
                throw new IllegalArgumentException("requestIdentity=" + i);
        }
    }
}
