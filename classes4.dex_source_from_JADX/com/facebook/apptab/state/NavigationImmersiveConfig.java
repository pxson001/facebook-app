package com.facebook.apptab.state;

import com.facebook.common.json.AutoGenJsonDeserializer;
import com.facebook.common.json.AutoGenJsonSerializer;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.google.common.base.Objects;

@AutoGenJsonSerializer
@AutoGenJsonDeserializer
@JsonDeserialize(using = NavigationImmersiveConfigDeserializer.class)
/* compiled from: is_super_primary */
public class NavigationImmersiveConfig {
    @JsonProperty("animation_speed")
    public final String animationSpeed;
    @JsonProperty("button_action")
    public final String buttonAction;
    @JsonProperty("experiment_group_name")
    public final String experimentGroupName;
    @JsonProperty("experiment_name")
    public final String experimentName;
    @JsonProperty("fb_logo_badge_count")
    public final String fbLogoBadgeCount;
    @JsonProperty("fb_logo_badge_style")
    public final String fbLogoBadgeStyle;

    /* compiled from: is_super_primary */
    public class Builder {
        public String f9820a = "unknown_experiment";
        public String f9821b = "unknown_experiment_group";
        public String f9822c;
        public String f9823d;
        public String f9824e;
        public String f9825f;

        public final NavigationImmersiveConfig m10219a() {
            return new NavigationImmersiveConfig(this);
        }
    }

    NavigationImmersiveConfig() {
        this.experimentName = "unknown_experiment";
        this.experimentGroupName = "unknown_experiment_group";
        this.fbLogoBadgeStyle = "none";
        this.fbLogoBadgeCount = "all";
        this.buttonAction = "system_back";
        this.animationSpeed = "medium_speed_animation";
    }

    NavigationImmersiveConfig(Builder builder) {
        this.experimentName = builder.f9820a;
        this.experimentGroupName = builder.f9821b;
        this.fbLogoBadgeStyle = builder.f9822c;
        this.fbLogoBadgeCount = builder.f9823d;
        this.buttonAction = builder.f9824e;
        this.animationSpeed = builder.f9825f;
    }

    public static NavigationImmersiveConfig m10220a() {
        Builder builder = new Builder();
        builder.f9820a = "unknown_experiment";
        builder = builder;
        builder.f9821b = "unknown_experiment_group";
        builder = builder;
        builder.f9822c = "none";
        builder = builder;
        builder.f9824e = "system_back";
        builder = builder;
        builder.f9825f = "medium_speed_animation";
        return builder.m10219a();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof NavigationImmersiveConfig)) {
            return false;
        }
        NavigationImmersiveConfig navigationImmersiveConfig = (NavigationImmersiveConfig) obj;
        if (Objects.equal(this.experimentName, navigationImmersiveConfig.experimentName) && Objects.equal(this.experimentGroupName, navigationImmersiveConfig.experimentGroupName) && Objects.equal(this.buttonAction, navigationImmersiveConfig.buttonAction) && Objects.equal(this.animationSpeed, navigationImmersiveConfig.animationSpeed) && Objects.equal(this.fbLogoBadgeStyle, navigationImmersiveConfig.fbLogoBadgeStyle) && Objects.equal(this.fbLogoBadgeCount, navigationImmersiveConfig.fbLogoBadgeCount)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return Objects.hashCode(new Object[]{this.experimentName, this.experimentGroupName, this.buttonAction, this.animationSpeed, this.fbLogoBadgeStyle, this.fbLogoBadgeCount});
    }
}
