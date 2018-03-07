package com.facebook.graphql.executor;

import com.facebook.graphql.query.GraphQLRefParam.BatchQueryFanOutStyle;

/* compiled from: lightweight_unit_id */
/* synthetic */ class GraphQLBatchRunner$2 {
    static final /* synthetic */ int[] f3198a = new int[BatchQueryFanOutStyle.values().length];

    static {
        try {
            f3198a[BatchQueryFanOutStyle.NO_FAN_OUT.ordinal()] = 1;
        } catch (NoSuchFieldError e) {
        }
        try {
            f3198a[BatchQueryFanOutStyle.FIRST.ordinal()] = 2;
        } catch (NoSuchFieldError e2) {
        }
        try {
            f3198a[BatchQueryFanOutStyle.LAST.ordinal()] = 3;
        } catch (NoSuchFieldError e3) {
        }
        try {
            f3198a[BatchQueryFanOutStyle.ALL.ordinal()] = 4;
        } catch (NoSuchFieldError e4) {
        }
        try {
            f3198a[BatchQueryFanOutStyle.EACH.ordinal()] = 5;
        } catch (NoSuchFieldError e5) {
        }
    }
}
