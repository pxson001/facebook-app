package com.facebook.graphql.executor;

import com.facebook.fbservice.service.DataFreshnessParam;
import com.google.common.base.Objects;

/* compiled from: reset_nux_status */
public class GraphQLCachePolicy {
    public static final GraphQLCachePolicy f7109a = new GraphQLCachePolicy("FULLY_CACHED_TO_DISK", true, true, true);
    public static final GraphQLCachePolicy f7110b = new GraphQLCachePolicy("DISK_CACHE_ONLY", true, false, false);
    public static final GraphQLCachePolicy f7111c = new GraphQLCachePolicy("NETWORK_ONLY", false, true, false);
    public static final GraphQLCachePolicy f7112d = new GraphQLCachePolicy("FETCH_AND_FILL_DISK_ONLY", false, true, true);
    public static final GraphQLCachePolicy f7113e = new GraphQLCachePolicy("PREFETCH_TO_DB", false, true, true);
    public final String f7114f;
    public final boolean f7115g;
    public final boolean f7116h;
    public final boolean f7117i;

    /* compiled from: reset_nux_status */
    public /* synthetic */ class C08631 {
        public static final /* synthetic */ int[] f21694a = new int[DataFreshnessParam.values().length];

        static {
            try {
                f21694a[DataFreshnessParam.PREFER_CACHE_IF_UP_TO_DATE.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f21694a[DataFreshnessParam.CHECK_SERVER_FOR_NEW_DATA.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f21694a[DataFreshnessParam.DO_NOT_CHECK_SERVER.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f21694a[DataFreshnessParam.STALE_DATA_OKAY.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
        }
    }

    private GraphQLCachePolicy(String str, boolean z, boolean z2, boolean z3) {
        this.f7114f = str;
        this.f7115g = z;
        this.f7117i = z2;
        this.f7116h = z3;
    }

    public String toString() {
        return Objects.toStringHelper(GraphQLCachePolicy.class).add("policyName", this.f7114f).toString();
    }
}
