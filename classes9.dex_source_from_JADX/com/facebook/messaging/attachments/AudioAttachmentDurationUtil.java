package com.facebook.messaging.attachments;

import com.facebook.debug.log.BLog;

/* compiled from: p2p_csc_fail */
public class AudioAttachmentDurationUtil {
    private static final Class<?> f7705a = AudioAttachmentDurationUtil.class;

    public static long m7999a(String str) {
        long j = -1;
        String[] split = str.split("-");
        if (split.length != 3) {
            BLog.b(f7705a, "Invalid fileName does not contain duration.");
            return j;
        }
        String str2 = split[2];
        int lastIndexOf = str2.lastIndexOf(46);
        if (lastIndexOf < 0) {
            BLog.b(f7705a, "Invalid fileName does not contain duration.");
            return j;
        }
        try {
            return (long) Integer.parseInt(str2.substring(0, lastIndexOf));
        } catch (NumberFormatException e) {
            BLog.b(f7705a, "Invalid fileName does not contain duration.");
            return j;
        }
    }
}
