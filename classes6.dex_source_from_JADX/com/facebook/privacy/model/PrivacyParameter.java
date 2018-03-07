package com.facebook.privacy.model;

import com.facebook.common.json.AutoGenJsonDeserializer;
import com.facebook.common.json.AutoGenJsonSerializer;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.google.common.base.Joiner;
import java.util.ArrayList;
import java.util.List;

@AutoGenJsonDeserializer
@AutoGenJsonSerializer
@JsonDeserialize(using = PrivacyParameterDeserializer.class)
@JsonSerialize(using = PrivacyParameterSerializer.class)
/* compiled from: featured_tag_selected */
public final class PrivacyParameter {
    @JsonProperty("allow")
    public final String allow;
    @JsonProperty("deny")
    public final String deny;
    @JsonProperty("friends")
    public final String friends;
    @JsonProperty("settings")
    public final Settings settings;
    @JsonProperty("value")
    public final String value;

    /* compiled from: featured_tag_selected */
    public enum Allow {
        SOME_FRIENDS,
        ALL_FRIENDS,
        FRIENDS_OF_FRIENDS
    }

    /* compiled from: featured_tag_selected */
    public class Builder {
        public String f15093a;
        public String f15094b;
        public String f15095c;
        public String f15096d;
        public boolean f15097e;
        private final ArrayList<String> f15098f = new ArrayList();
        private final ArrayList<String> f15099g = new ArrayList();

        public static Builder m22683a(PrivacyParameter privacyParameter) {
            Builder builder = new Builder();
            builder.f15093a = privacyParameter.value;
            builder.f15094b = privacyParameter.allow;
            builder.f15095c = privacyParameter.deny;
            builder.f15096d = privacyParameter.friends;
            if (privacyParameter.settings != null) {
                builder.f15097e = privacyParameter.settings.noTagExpansion;
            }
            return builder;
        }

        public final Builder m22684a(List<String> list) {
            this.f15098f.addAll(list);
            return this;
        }

        public final Builder m22687b(List<String> list) {
            this.f15099g.addAll(list);
            return this;
        }

        public final Builder m22685a(boolean z) {
            this.f15097e = z;
            return this;
        }

        public final PrivacyParameter m22686a() {
            if (!this.f15098f.isEmpty()) {
                if (Allow.ALL_FRIENDS.toString().equals(this.f15094b) || Allow.FRIENDS_OF_FRIENDS.toString().equals(this.f15094b)) {
                    this.f15094b = "";
                }
                StringBuilder stringBuilder = new StringBuilder();
                if (this.f15094b != null) {
                    stringBuilder.append(this.f15094b);
                    stringBuilder.append(",");
                }
                for (int i = 0; i < this.f15098f.size(); i++) {
                    if (i != 0) {
                        stringBuilder.append(",");
                    }
                    stringBuilder.append((String) this.f15098f.get(i));
                }
                this.f15094b = stringBuilder.toString();
            } else if (Value.ALL_FRIENDS.toString().equals(this.f15093a) || Value.FRIENDS_OF_FRIENDS.toString().equals(this.f15093a)) {
                this.f15094b = this.f15093a;
            }
            if (!this.f15099g.isEmpty()) {
                this.f15095c = Joiner.on(",").join(this.f15099g);
            }
            this.f15093a = Value.CUSTOM.toString();
            return new PrivacyParameter(this);
        }
    }

    @AutoGenJsonDeserializer
    @AutoGenJsonSerializer
    @JsonDeserialize(using = PrivacyParameter_SettingsDeserializer.class)
    @JsonSerialize(using = PrivacyParameter_SettingsSerializer.class)
    /* compiled from: featured_tag_selected */
    class Settings {
        @JsonProperty("no_tag_expansion")
        public final boolean noTagExpansion;

        private Settings() {
            this.noTagExpansion = false;
        }

        public Settings(boolean z) {
            this.noTagExpansion = z;
        }
    }

    /* compiled from: featured_tag_selected */
    public enum Value {
        EVERYONE,
        ALL_FRIENDS,
        FRIENDS_OF_FRIENDS,
        CUSTOM,
        SELF
    }

    public PrivacyParameter() {
        this.value = null;
        this.allow = null;
        this.deny = null;
        this.friends = null;
        this.settings = null;
    }

    protected PrivacyParameter(Builder builder) {
        this.value = builder.f15093a;
        this.allow = builder.f15094b;
        this.deny = builder.f15095c;
        if (builder.f15097e) {
            this.settings = new Settings(builder.f15097e);
        } else {
            this.settings = null;
        }
        this.friends = builder.f15096d;
    }
}
