package com.facebook.analytics.db;

import com.google.common.collect.ImmutableList;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: timeline_info_review_item_id */
public class AnalyticsStorage$EventBatch {
    public final long f1884a;
    public final String f1885b;
    public final int f1886c;
    public final String f1887d;
    public final int f1888e;
    public final ImmutableList<Long> f1889f;
    public final ImmutableList<String> f1890g;
    final /* synthetic */ AnalyticsStorage f1891h;

    public AnalyticsStorage$EventBatch(AnalyticsStorage analyticsStorage, long j, String str, int i, String str2, int i2, ImmutableList<Long> immutableList, ImmutableList<String> immutableList2) {
        this.f1891h = analyticsStorage;
        this.f1884a = j;
        this.f1885b = str;
        this.f1886c = i;
        this.f1887d = str2;
        this.f1888e = i2;
        this.f1889f = immutableList;
        this.f1890g = immutableList2;
    }

    public final int m2563a() {
        int i = 0;
        for (int i2 = 0; i2 < this.f1890g.size(); i2++) {
            i += ((String) this.f1890g.get(i2)).length();
        }
        return ((this.f1887d.length() + i) + this.f1885b.length()) + 16;
    }
}
