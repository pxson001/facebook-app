package com.facebook.messaging.threads.util;

import com.google.common.base.Function;
import javax.annotation.Nullable;

/* compiled from: com.facebook.apptab.ui.TAB_BAR_ITEM_TAP */
public class MessagingIdUtil {

    /* compiled from: com.facebook.apptab.ui.TAB_BAR_ITEM_TAP */
    public final class C21032 implements Function<String, String> {
        @Nullable
        public final Object apply(@Nullable Object obj) {
            return MessagingIdUtil.m17836b((String) obj);
        }
    }

    public static String m17834a(String str) {
        return (str == null || str.startsWith("t_") || str.startsWith("{")) ? str : "t_" + str;
    }

    public static String m17835b(long j) {
        return "gt_" + Long.toString(j);
    }

    public static String m17837c(long j) {
        return "tfbid_" + Long.toString(j);
    }

    @Nullable
    public static String m17836b(@Nullable String str) {
        return (str == null || str.startsWith("m_") || str.startsWith("{")) ? str : "m_" + str;
    }

    public static String m17838c(String str) {
        return (str == null || !str.startsWith("m_")) ? str : str.substring(2);
    }

    public static String m17839d(long j) {
        return j == -1 ? null : "m_action:" + j;
    }
}
