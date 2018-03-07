package com.facebook.graphql.query;

import android.support.v7.widget.LinearLayoutCompat;
import com.facebook.graphql.executor.GraphQLRequest;

/* compiled from: education_info */
public class GraphQLRefParam {
    public final GraphQLRequest f4787a;
    public final String f4788b;
    public final BatchQueryFanOutStyle f4789c;
    public final FallbackStyle f4790d;

    /* compiled from: education_info */
    /* synthetic */ class C04691 {
        static final /* synthetic */ int[] f4785a = new int[BatchQueryFanOutStyle.values().length];
        static final /* synthetic */ int[] f4786b = new int[FallbackStyle.values().length];

        static {
            try {
                f4786b[FallbackStyle.ERROR.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f4786b[FallbackStyle.SKIP.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f4786b[FallbackStyle.ALLOW.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f4785a[BatchQueryFanOutStyle.EACH.ordinal()] = 1;
            } catch (NoSuchFieldError e4) {
            }
            try {
                f4785a[BatchQueryFanOutStyle.ALL.ordinal()] = 2;
            } catch (NoSuchFieldError e5) {
            }
            try {
                f4785a[BatchQueryFanOutStyle.FIRST.ordinal()] = 3;
            } catch (NoSuchFieldError e6) {
            }
            try {
                f4785a[BatchQueryFanOutStyle.LAST.ordinal()] = 4;
            } catch (NoSuchFieldError e7) {
            }
            try {
                f4785a[BatchQueryFanOutStyle.NO_FAN_OUT.ordinal()] = 5;
            } catch (NoSuchFieldError e8) {
            }
        }
    }

    /* compiled from: education_info */
    public enum BatchQueryFanOutStyle {
        EACH,
        ALL,
        FIRST,
        LAST,
        NO_FAN_OUT
    }

    /* compiled from: education_info */
    public enum FallbackStyle {
        ERROR,
        SKIP,
        ALLOW,
        NOT_SET
    }

    public GraphQLRefParam(GraphQLRequest graphQLRequest, String str, BatchQueryFanOutStyle batchQueryFanOutStyle, FallbackStyle fallbackStyle) {
        this.f4787a = graphQLRequest;
        this.f4788b = str;
        this.f4789c = batchQueryFanOutStyle;
        this.f4790d = fallbackStyle;
    }

    public static String m9592a(BatchQueryFanOutStyle batchQueryFanOutStyle) {
        switch (C04691.f4785a[batchQueryFanOutStyle.ordinal()]) {
            case 1:
                return "each";
            case LinearLayoutCompat.SHOW_DIVIDER_MIDDLE /*2*/:
                return "all";
            case 3:
                return "first";
            case LinearLayoutCompat.SHOW_DIVIDER_END /*4*/:
                return "last";
            default:
                return null;
        }
    }

    public static String m9593a(FallbackStyle fallbackStyle) {
        switch (C04691.f4786b[fallbackStyle.ordinal()]) {
            case 1:
                return "error";
            case LinearLayoutCompat.SHOW_DIVIDER_MIDDLE /*2*/:
                return "skip";
            case 3:
                return "allow";
            default:
                return null;
        }
    }
}
