package com.facebook.analytics.samplingpolicy;

import com.facebook.analytics.samplingpolicy.AnalyticsLoggingPolicy.ConfigSnapShot;
import com.facebook.quicklog.identifiers.Utils;
import java.util.Random;

/* compiled from: transport_rtt_completed */
public class AnalyticsPerfUtils {
    public static int m4442a(ConfigSnapShot configSnapShot, int i, Random random) {
        return m4441a(configSnapShot.m4373a(Utils.m4445a(i), Utils.m4446b(i)), random);
    }

    public static int m4441a(int i, Random random) {
        if (i == 0) {
            return Integer.MAX_VALUE;
        }
        if (i == 1) {
            return 1;
        }
        if (random.nextInt(i) != 0) {
            return Integer.MAX_VALUE;
        }
        return i;
    }
}
