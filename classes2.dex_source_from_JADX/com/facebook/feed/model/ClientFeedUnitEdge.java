package com.facebook.feed.model;

import com.facebook.graphql.enums.GraphQLBumpReason;
import com.facebook.graphql.executor.filemap.DefaultFlatBufferCorruptionHandler;
import com.facebook.graphql.model.FeedUnit;
import com.facebook.graphql.model.FeedUnitMediaLoadedInfo;
import com.facebook.graphql.model.GraphQLFeedUnitEdge;
import com.facebook.graphql.model.PropertyHelper;
import java.nio.ByteBuffer;

/* compiled from: maximum size can not be combined with weigher */
public class ClientFeedUnitEdge extends GraphQLFeedUnitEdge {
    public final boolean f14817A;
    public final String f14818B;
    public final long f14819C;
    private final String f14820l;
    private final int f14821m;
    private final int f14822n;
    private final int f14823o;
    private final boolean f14824p;
    private final ByteBuffer f14825q;
    private final ByteBuffer f14826r;
    private final String f14827s;
    public final long f14828t;
    private final int f14829u;
    private final int f14830v;
    private final int f14831w;
    private final DefaultFlatBufferCorruptionHandler f14832x;
    private FeedUnitInflater f14833y;
    public final String f14834z;

    public ClientFeedUnitEdge(String str, double d, String str2, GraphQLBumpReason graphQLBumpReason, String str3, String str4, String str5, String str6, int i, int i2, int i3, boolean z, ByteBuffer byteBuffer, ByteBuffer byteBuffer2, String str7, long j, int i4, int i5, int i6, int i7, DefaultFlatBufferCorruptionHandler defaultFlatBufferCorruptionHandler, FeedUnitInflater feedUnitInflater, String str8, String str9, boolean z2, boolean z3, String str10, long j2) {
        super.m19081b(str5);
        super.m19085d(str);
        super.m19074a(d);
        super.m19076a(graphQLBumpReason);
        super.m19078a(str2);
        super.m19083c(str9);
        super.m19079a(z2);
        super.m19077a(null);
        PropertyHelper.m21272a((GraphQLFeedUnitEdge) this, str3);
        PropertyHelper.m21292b((GraphQLFeedUnitEdge) this, str4);
        PropertyHelper.m21297c((GraphQLFeedUnitEdge) this, String.valueOf(i5));
        PropertyHelper.m21270a((GraphQLFeedUnitEdge) this, i6);
        this.f14820l = str6;
        this.f14821m = i;
        this.f14822n = i2;
        this.f14823o = i3;
        this.f14824p = z;
        this.f14825q = byteBuffer;
        this.f14826r = byteBuffer2;
        this.f14827s = str7;
        this.f14828t = j;
        this.f14829u = i4;
        this.f14830v = i5;
        this.f14832x = defaultFlatBufferCorruptionHandler;
        this.f14833y = feedUnitInflater;
        this.f14834z = str8;
        this.f14831w = i7;
        this.f14817A = z3;
        this.f14818B = str10;
        this.f14819C = j2;
    }

    public final FeedUnit mo2540c() {
        FeedUnit n = super.m19091n();
        if (n != null) {
            return n;
        }
        n = this.f14833y.m9276a(this);
        this.f12980i = n;
        return n;
    }

    public final String m21230o() {
        return this.f14820l;
    }

    public final int m21231p() {
        return this.f14821m;
    }

    public final int m21232q() {
        return this.f14822n;
    }

    public final int m21233r() {
        return this.f14823o;
    }

    public final boolean m21234s() {
        return this.f14824p;
    }

    public final ByteBuffer m21235t() {
        return this.f14825q;
    }

    public final ByteBuffer m21236u() {
        return this.f14826r;
    }

    public final String m21237v() {
        return this.f14827s;
    }

    public final long m21238w() {
        return this.f14828t;
    }

    public final int m21239x() {
        return this.f14829u;
    }

    public final DefaultFlatBufferCorruptionHandler m21240y() {
        return this.f14832x;
    }

    public final int m21241z() {
        return Integer.parseInt(PropertyHelper.m21294c((GraphQLFeedUnitEdge) this));
    }

    public final String m21223A() {
        return this.f14834z;
    }

    public final int m21224B() {
        int i;
        FeedUnitMediaLoadedInfo d = PropertyHelper.m21298d(this);
        if (d == null) {
            i = PropertyHelper.m21261a((Object) this).f14866o;
        } else if (d.f14911a.size() == d.m21356a()) {
            i = 2;
        } else if (d.m21356a() == 0) {
            i = 0;
        } else {
            i = 1;
        }
        return i;
    }

    public final String m21225C() {
        return this.f14818B;
    }

    public final long m21226D() {
        return this.f14819C;
    }

    public final boolean m21227E() {
        return this.f14830v == 1;
    }

    public final boolean m21228F() {
        return this.f14817A;
    }
}
