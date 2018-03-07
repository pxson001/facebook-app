package com.facebook.apptab.state;

import com.facebook.common.json.AutoGenJsonDeserializer;
import com.facebook.common.json.AutoGenJsonSerializer;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.google.common.base.Objects;

@AutoGenJsonSerializer
@AutoGenJsonDeserializer
@JsonDeserialize(using = NavigationMemoryConfigDeserializer.class)
/* compiled from: profile/%s/info/expanded */
public class NavigationMemoryConfig {
    @JsonProperty("experiment_group_name")
    public final String experimentGroupName;
    @JsonProperty("experiment_name")
    public final String experimentName;
    @JsonProperty("low_memory_optimization_threshold_mb")
    public final int lowMemoryOptimizationThresholdMb;

    NavigationMemoryConfig() {
        this.experimentName = "unknown_experiment";
        this.experimentGroupName = "unknown_experiment_group";
        this.lowMemoryOptimizationThresholdMb = 0;
    }

    NavigationMemoryConfig(Builder builder) {
        this.experimentName = builder.a;
        this.experimentGroupName = builder.b;
        this.lowMemoryOptimizationThresholdMb = builder.c;
    }

    public static NavigationMemoryConfig m13803a() {
        Builder builder = new Builder();
        builder.c = 0;
        return builder.a();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof NavigationMemoryConfig)) {
            return false;
        }
        NavigationMemoryConfig navigationMemoryConfig = (NavigationMemoryConfig) obj;
        if (Objects.equal(this.experimentName, navigationMemoryConfig.experimentName) && Objects.equal(this.experimentGroupName, navigationMemoryConfig.experimentGroupName) && Objects.equal(Integer.valueOf(this.lowMemoryOptimizationThresholdMb), Integer.valueOf(navigationMemoryConfig.lowMemoryOptimizationThresholdMb))) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return Objects.hashCode(this.experimentName, this.experimentGroupName, Integer.valueOf(this.lowMemoryOptimizationThresholdMb));
    }
}
