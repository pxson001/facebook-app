package com.facebook.privacy.nux;

/* compiled from: fbqrcode */
public enum PrivacyEducationBannerController$EducationType {
    ReshareEducation("reshare_education_type"),
    TagExpansionEducation("tag_expansion_education_type"),
    FullIndexEducation("fullindex_education_type"),
    GroupMallAdsEducation("group_mall_ads_education_type");
    
    final String name;

    private PrivacyEducationBannerController$EducationType(String str) {
        this.name = str;
    }

    public final String toString() {
        return this.name;
    }
}
