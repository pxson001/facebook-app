package com.facebook.controller.connectioncontroller.diskstore;

import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.controller.connectioncontroller.common.ConnectionLocation;
import com.facebook.controller.connectioncontroller.common.ConnectionLocation.LocationType;
import com.facebook.graphql.cursor.database.SortKeyHelper;
import com.google.common.base.Preconditions;

/* compiled from: order_status */
final class ConnectionStatePageHelper {

    /* compiled from: order_status */
    /* synthetic */ class C05681 {
        static final /* synthetic */ int[] f8612a = new int[LocationType.values().length];

        static {
            try {
                f8612a[LocationType.INITIAL.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f8612a[LocationType.AFTER.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f8612a[LocationType.BEFORE.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
        }
    }

    ConnectionStatePageHelper() {
    }

    public static String m12429a(ConnectionLocation connectionLocation, long j) {
        switch (C05681.f8612a[connectionLocation.c.ordinal()]) {
            case 1:
                return SortKeyHelper.m17610a(j);
            case 2:
                return SortKeyHelper.m17614b(((DiskConnectionLocation) connectionLocation).f8614b);
            case 3:
                String str = ((DiskConnectionLocation) connectionLocation).f8614b;
                Preconditions.checkState(str.length() >= 24);
                return StringFormatUtil.formatStrLocaleSafe("%s%08x", SortKeyHelper.m17618f(str), Integer.valueOf(SortKeyHelper.m17619g(str) + 1));
            default:
                throw new IllegalStateException();
        }
    }
}
