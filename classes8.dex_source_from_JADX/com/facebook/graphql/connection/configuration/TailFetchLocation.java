package com.facebook.graphql.connection.configuration;

import com.facebook.graphql.cursor.database.PageInfo;
import com.facebook.graphql.cursor.database.SortKeyHelper;
import com.google.common.base.Preconditions;
import javax.annotation.Nullable;

/* compiled from: weightSum */
public final class TailFetchLocation {
    public final String f260a;
    @Nullable
    public final String f261b;
    public final boolean f262c;

    public static TailFetchLocation m238a(long j) {
        return new TailFetchLocation(SortKeyHelper.a(j), null, true);
    }

    public static TailFetchLocation m239a(TailFetchLocation tailFetchLocation, @Nullable String str, boolean z) {
        Preconditions.checkNotNull(tailFetchLocation);
        String b = SortKeyHelper.b(tailFetchLocation.f260a);
        boolean z2 = z && str != null;
        return new TailFetchLocation(b, str, z2);
    }

    public static PageInfo m240a(TailFetchLocation tailFetchLocation, int i) {
        return new PageInfo(SortKeyHelper.d(tailFetchLocation.f260a), SortKeyHelper.e(tailFetchLocation.f260a), null, tailFetchLocation.f261b, false, tailFetchLocation.f262c, i);
    }

    public TailFetchLocation(String str, String str2, boolean z) {
        this.f260a = (String) Preconditions.checkNotNull(str);
        this.f261b = str2;
        this.f262c = z;
    }

    public final String m241a(int i) {
        return SortKeyHelper.b(this.f260a, i);
    }
}
