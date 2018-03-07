package com.facebook.controller.connectioncontroller.common;

import android.text.TextUtils;
import com.facebook.controller.connectioncontroller.pageinfo.ConnectionControllerPageInfoGraphQLInterfaces.ConnectionControllerPageInfoGraphQL;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.RegularImmutableList;

/* compiled from: ordering_list */
public class ConnectionPage<TEdge> {
    public static final ConnectionPage f8598a = new ConnectionPage(RegularImmutableList.a, null, null, false, false);
    public ImmutableList<TEdge> f8599b;
    private String f8600c;
    private String f8601d;
    private boolean f8602e;
    private boolean f8603f;

    public ConnectionPage(ImmutableList<TEdge> immutableList, String str, String str2, boolean z, boolean z2) {
        this.f8599b = immutableList;
        this.f8600c = str;
        this.f8601d = str2;
        this.f8602e = z;
        this.f8603f = z2;
    }

    public ConnectionPage(ImmutableList<TEdge> immutableList, ConnectionControllerPageInfoGraphQL connectionControllerPageInfoGraphQL) {
        this(immutableList, connectionControllerPageInfoGraphQL.m12444d(), connectionControllerPageInfoGraphQL.m12440a(), connectionControllerPageInfoGraphQL.m12443c(), connectionControllerPageInfoGraphQL.m12442b());
    }

    public final ImmutableList<TEdge> m12401a() {
        return this.f8599b;
    }

    public final String m12402b() {
        return this.f8600c;
    }

    public final String m12403c() {
        return this.f8601d;
    }

    public final boolean m12404d() {
        return this.f8602e;
    }

    public final boolean m12405e() {
        return this.f8603f;
    }

    public final boolean m12406f() {
        return this.f8599b.isEmpty() && TextUtils.isEmpty(this.f8600c) && TextUtils.isEmpty(this.f8601d);
    }
}
