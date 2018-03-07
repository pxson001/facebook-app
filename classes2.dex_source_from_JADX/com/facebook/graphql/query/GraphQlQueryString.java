package com.facebook.graphql.query;

import com.facebook.common.util.TriState;
import com.facebook.debug.log.BLog;
import com.facebook.graphql.calls.GraphQlCallInput;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.collect.Lists;
import java.util.List;
import java.util.Set;
import javax.annotation.Nullable;

/* compiled from: root_unit_id */
public class GraphQlQueryString {
    public GraphQlQueryParamSet f6529a;
    public final String f6530b;
    public final String f6531c;
    public final String f6532d;
    public GraphQlFragmentString[] f6533e;
    public final Set<String> f6534f;
    public boolean f6535g;
    public boolean f6536h;

    public GraphQlQueryString(String str, String str2, @Nullable String str3, @Nullable Set<String> set) {
        this(str, str2, str3, set, false, true);
    }

    public GraphQlQueryString(String str, String str2, @Nullable String str3, @Nullable Set<String> set, boolean z, boolean z2) {
        this.f6529a = new GraphQlQueryParamSet();
        this.f6530b = str;
        this.f6531c = str2;
        this.f6532d = str3;
        this.f6534f = set;
        this.f6536h = z;
        this.f6535g = z2;
    }

    public final String m11324c() {
        return this.f6530b;
    }

    public final boolean m11325d() {
        return this.f6536h;
    }

    public final boolean m11326e() {
        return this.f6535g;
    }

    public final String m11327f() {
        return this.f6532d;
    }

    public TriState mo1607g() {
        return TriState.UNSET;
    }

    public boolean mo1640i() {
        return false;
    }

    public final GraphQlQueryParamSet m11330j() {
        return this.f6529a;
    }

    @Deprecated
    @VisibleForTesting
    public final void m11319a(GraphQlQueryParamSet graphQlQueryParamSet) {
        this.f6529a = graphQlQueryParamSet;
    }

    public GraphQlQueryString mo1608a(boolean z) {
        this.f6536h = z;
        return this;
    }

    public String mo1605a(String str) {
        return str;
    }

    protected boolean mo1606a(String str, Object obj) {
        return false;
    }

    private static void m11309c(String str, String str2) {
        BLog.b("GRAPHQL_QUERY_STRING", "Trying to set unknown parameter '%s' on query '%s'", new Object[]{str, str2});
    }

    public final GraphQlQueryString m11322b(String str, Object obj) {
        String a = mo1605a(str);
        if (a.equals(str)) {
            m11309c(str, this.f6530b);
        }
        if (mo1606a(a, obj)) {
            this.f6529a.m11379b(a);
        } else {
            this.f6529a.m11375a(a, obj);
        }
        return this;
    }

    public final GraphQlQueryString m11315a(String str, @Nullable String str2) {
        String a = mo1605a(str);
        if (a.equals(str)) {
            m11309c(str, this.f6530b);
        }
        if (mo1606a(a, (Object) str2)) {
            this.f6529a.m11379b(a);
        } else {
            this.f6529a.m11376a(a, str2);
        }
        return this;
    }

    public final GraphQlQueryString m11314a(String str, Number number) {
        String a = mo1605a(str);
        if (a.equals(str)) {
            m11309c(str, this.f6530b);
        }
        if (mo1606a(a, (Object) number)) {
            this.f6529a.m11379b(a);
        } else {
            this.f6529a.m11374a(a, number);
        }
        return this;
    }

    public final GraphQlQueryString m11312a(String str, Boolean bool) {
        String a = mo1605a(str);
        if (a.equals(str)) {
            m11309c(str, this.f6530b);
        }
        if (mo1606a(a, (Object) bool)) {
            this.f6529a.m11379b(a);
        } else {
            this.f6529a.m11372a(a, bool);
        }
        return this;
    }

    public final <T> GraphQlQueryString m11316a(String str, @Nullable List<T> list) {
        String a = mo1605a(str);
        if (a.equals(str)) {
            m11309c(str, this.f6530b);
        }
        if (list == null || list.isEmpty() || (list.get(0) instanceof String) || (list.get(0) instanceof GraphQlCallInput)) {
            this.f6529a.m11377a(a, (List) list);
        } else {
            List a2 = Lists.m1296a();
            for (Object next : list) {
                a2.add(next != null ? next.toString() : null);
            }
            this.f6529a.m11377a(a, a2);
        }
        return this;
    }

    public final GraphQlQueryString m11310a(String str, GraphQlCallInput graphQlCallInput) {
        String a = mo1605a(str);
        if (a.equals(str)) {
            m11309c(str, this.f6530b);
        }
        this.f6529a.m11370a(a, graphQlCallInput);
        return this;
    }

    public final GraphQlQueryString m11313a(String str, Enum enumR) {
        String a = mo1605a(str);
        if (a.equals(str)) {
            m11309c(str, this.f6530b);
        }
        if (enumR == null || !mo1606a(a, enumR.toString())) {
            this.f6529a.m11373a(a, enumR);
        } else {
            this.f6529a.m11379b(a);
        }
        return this;
    }

    public final GraphQlQueryString m11311a(String str, GraphQLRefParam graphQLRefParam) {
        String a = mo1605a(str);
        if (a.equals(str)) {
            m11309c(str, this.f6530b);
        }
        this.f6529a.m11371a(a, graphQLRefParam);
        return this;
    }

    public final GraphQlQueryString m11321b(String str, Number number) {
        this.f6529a.m11380b(str, number);
        return this;
    }

    public final GraphQlQueryString m11323b(String str, String str2) {
        this.f6529a.m11380b(str, str2);
        return this;
    }

    public boolean m11331l() {
        return false;
    }

    @Nullable
    public int[][] m11332m() {
        return null;
    }
}
