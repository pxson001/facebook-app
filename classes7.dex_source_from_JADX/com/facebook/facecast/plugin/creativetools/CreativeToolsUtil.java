package com.facebook.facecast.plugin.creativetools;

import com.facebook.facecast.plugin.FacecastAnalyticsLogger;
import javax.annotation.Nullable;

/* compiled from: batch_upload_attempt_error */
public class CreativeToolsUtil {
    public static void m22287a(FacecastAnalyticsLogger facecastAnalyticsLogger, boolean z, String str) {
        facecastAnalyticsLogger.m21964a(null, "main", "creative_tool_did_" + (z ? "show" : "hide") + "_" + str, null, null);
    }

    public static void m22286a(FacecastAnalyticsLogger facecastAnalyticsLogger, String str, @Nullable String str2) {
        facecastAnalyticsLogger.m21964a(str2, str, "creative_tool_did_show", null, null);
    }

    public static void m22288b(FacecastAnalyticsLogger facecastAnalyticsLogger, String str, String str2) {
        facecastAnalyticsLogger.m21964a(null, "filter_" + str, "creative_tool_applied_main_filter_" + str2, null, null);
    }
}
