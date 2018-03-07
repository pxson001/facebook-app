package com.facebook.sequencelogger;

import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.base.lwperf.perfstats.BackgroundChecker;
import com.facebook.common.dextricks.DexLibLoader;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import javax.annotation.Nullable;

/* compiled from: name_search_string */
public class HoneySequenceLoggerEvent extends HoneyClientEvent {
    public HoneySequenceLoggerEvent(String str, String str2, long j, @Nullable JsonNode jsonNode, @Nullable JsonNode jsonNode2, @Nullable JsonNode jsonNode3, @Nullable ArrayNode arrayNode, @Nullable ObjectNode objectNode, @Nullable ObjectNode objectNode2, @Nullable JsonNode jsonNode4, long j2, @Nullable Boolean bool, boolean z) {
        if (str == null) {
            str = "perf_sequence";
        }
        super(str);
        g(str2);
        a("duration_ms", j);
        if (jsonNode != null) {
            a("extra_start_map", jsonNode);
        }
        if (jsonNode2 != null) {
            a("extra_stop_map", jsonNode2);
        }
        if (jsonNode3 != null) {
            a("extra_info_map", jsonNode3);
        }
        if (jsonNode4 != null) {
            a("events", jsonNode4);
        }
        if (arrayNode != null) {
            a("errors", arrayNode);
        }
        if (objectNode != null) {
            a("gks", objectNode);
        }
        if (objectNode2 != null) {
            a("qes", objectNode2);
        }
        if (bool != null) {
            a("guess_was_backgrounded", bool.booleanValue());
        }
        if (z) {
            m7632a("guess_app_start_bg", BackgroundChecker.a().c());
        }
        a("time_since_boot_ms", j2);
        if (DexLibLoader.deoptTaint) {
            m7632a("dex_unopt", Boolean.TRUE);
        }
    }

    private void m7632a(String str, Boolean bool) {
        if (bool == null) {
            bool = "Unknown";
        }
        a(str, bool);
    }
}
