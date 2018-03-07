package com.facebook.abtest.qe.bootstrap.utils;

import android.annotation.SuppressLint;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.collect.ImmutableList;

/* compiled from: total_reach */
public class ExperimentData {
    private static String f1714a = "unassigned";
    private static String f1715b = "unavailable";
    @JsonProperty("client_override_group_index")
    public final int clientOverrideGroupIndex;
    @JsonProperty("group_names")
    public final ImmutableList<String> groupNames;
    @JsonProperty("is_in_experiment")
    public final boolean isInExperiment;
    @JsonProperty("name")
    public final String name;
    @JsonProperty("quicker")
    public final boolean quicker;
    @JsonProperty("server_assigned_group_index")
    public final int serverAssignedGroupIndex;

    @SuppressLint({"AndroidTrapUsingDefaultJsonDeserializer"})
    public ExperimentData(String str, boolean z, ImmutableList<String> immutableList, int i, int i2, boolean z2) {
        this.name = str;
        this.isInExperiment = z;
        this.groupNames = immutableList;
        this.serverAssignedGroupIndex = i;
        this.clientOverrideGroupIndex = i2;
        this.quicker = z2;
    }

    public final String m2359a() {
        return this.name + " = " + m2360c() + " [" + (this.quicker ? "quicker" : "classic") + "]";
    }

    public final String m2360c() {
        if (!this.isInExperiment) {
            return f1714a;
        }
        if (this.clientOverrideGroupIndex != -1) {
            return ((String) this.groupNames.get(this.clientOverrideGroupIndex)) + " (client override)";
        }
        if (this.serverAssignedGroupIndex != -1) {
            return ((String) this.groupNames.get(this.serverAssignedGroupIndex)) + " (server group)";
        }
        return f1715b;
    }

    public final boolean m2361d() {
        return this.clientOverrideGroupIndex != -1;
    }
}
