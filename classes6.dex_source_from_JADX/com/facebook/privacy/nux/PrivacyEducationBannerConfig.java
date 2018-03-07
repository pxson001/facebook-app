package com.facebook.privacy.nux;

import com.facebook.common.json.AutoGenJsonDeserializer;
import com.facebook.common.json.AutoGenJsonSerializer;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.google.common.collect.Maps;
import java.util.Map;

@AutoGenJsonDeserializer
@AutoGenJsonSerializer
@JsonDeserialize(using = PrivacyEducationBannerConfigDeserializer.class)
@JsonSerialize(using = PrivacyEducationBannerConfigSerializer.class)
/* compiled from: fbupload_file_upload_started */
public class PrivacyEducationBannerConfig {
    @JsonProperty("banner_expanded")
    public Map<String, Boolean> mBannersExpanded = Maps.c();
    @JsonProperty("seen_counts")
    public Map<String, Integer> mSeenCounts = Maps.c();

    PrivacyEducationBannerConfig() {
    }

    final int m22711a(PrivacyEducationBannerController$EducationType privacyEducationBannerController$EducationType) {
        if (this.mSeenCounts.containsKey(privacyEducationBannerController$EducationType.toString())) {
            return ((Integer) this.mSeenCounts.get(privacyEducationBannerController$EducationType.toString())).intValue();
        }
        return 0;
    }

    final void m22712a(PrivacyEducationBannerController$EducationType privacyEducationBannerController$EducationType, int i) {
        this.mSeenCounts.put(privacyEducationBannerController$EducationType.toString(), Integer.valueOf(i));
    }

    final boolean m22714b(PrivacyEducationBannerController$EducationType privacyEducationBannerController$EducationType) {
        if (this.mBannersExpanded.containsKey(privacyEducationBannerController$EducationType.toString())) {
            return ((Boolean) this.mBannersExpanded.get(privacyEducationBannerController$EducationType.toString())).booleanValue();
        }
        return true;
    }

    final void m22713a(PrivacyEducationBannerController$EducationType privacyEducationBannerController$EducationType, boolean z) {
        this.mBannersExpanded.put(privacyEducationBannerController$EducationType.toString(), Boolean.valueOf(z));
    }
}
