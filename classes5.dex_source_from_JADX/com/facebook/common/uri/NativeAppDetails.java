package com.facebook.common.uri;

import android.os.Bundle;
import com.facebook.graphql.enums.GraphQLAppStoreApplicationInstallState;
import com.facebook.graphql.enums.GraphQLAppStoreDownloadConnectivityPolicy;
import com.facebook.graphql.enums.GraphQLDigitalGoodStoreType;
import com.google.common.collect.ImmutableList;
import java.util.Map;
import javax.annotation.Nullable;

/* compiled from: after_party_popular_at_uncategorized */
public class NativeAppDetails {
    public final String f11148a;
    public final String f11149b;
    public final ImmutableList<String> f11150c;
    public final ImmutableList<GraphQLDigitalGoodStoreType> f11151d;
    public final String f11152e;
    public final String f11153f;
    public final String f11154g;
    public final String f11155h;
    public final String f11156i;
    public final String f11157j;
    public final int f11158k;
    public final String f11159l;
    public final String f11160m;
    public final GraphQLAppStoreApplicationInstallState f11161n;
    public final String f11162o;
    @Nullable
    public final String f11163p;
    @Nullable
    public final String f11164q;
    @Nullable
    public Bundle f11165r;
    @Nullable
    public Map<String, Object> f11166s;
    public final GraphQLAppStoreDownloadConnectivityPolicy f11167t;
    @Nullable
    public ImmutableList<Screenshot> f11168u = null;
    @Nullable
    public ImmutableList<Screenshot> f11169v = null;
    @Nullable
    public Object f11170w = null;
    @Nullable
    public Object f11171x = null;

    /* compiled from: after_party_popular_at_uncategorized */
    public class Screenshot {
        public final String f11145a;
        public final int f11146b;
        public final int f11147c;

        public Screenshot(String str, int i, int i2) {
            this.f11145a = str;
            this.f11146b = i;
            this.f11147c = i2;
        }
    }

    public NativeAppDetails(String str, String str2, String str3, ImmutableList<String> immutableList, ImmutableList<GraphQLDigitalGoodStoreType> immutableList2, String str4, String str5, String str6, String str7, String str8, int i, String str9, String str10, GraphQLAppStoreApplicationInstallState graphQLAppStoreApplicationInstallState, @Nullable String str11, @Nullable String str12, String str13, GraphQLAppStoreDownloadConnectivityPolicy graphQLAppStoreDownloadConnectivityPolicy) {
        this.f11148a = str;
        this.f11149b = str2;
        this.f11154g = str3;
        this.f11150c = immutableList;
        this.f11151d = immutableList2;
        this.f11152e = str4;
        this.f11153f = str5;
        this.f11155h = str6;
        this.f11156i = str7;
        this.f11157j = str8;
        this.f11158k = i;
        this.f11159l = str9;
        this.f11160m = str10;
        this.f11161n = graphQLAppStoreApplicationInstallState;
        this.f11163p = str11;
        this.f11164q = str12;
        this.f11162o = str13;
        this.f11165r = null;
        this.f11166s = null;
        this.f11167t = graphQLAppStoreDownloadConnectivityPolicy;
    }

    public final boolean m19128a() {
        return (this.f11152e == null || this.f11158k <= 0 || this.f11157j == null || this.f11150c == null || this.f11151d == null) ? false : true;
    }
}
