package com.facebook.intent.thirdparty;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

@JsonIgnoreProperties(b = true)
/* compiled from: mCommunicationRank */
class NativeThirdPartyUriHelper$AppSites {
    @JsonProperty("android")
    List<NativeThirdPartyUriHelper$AppSiteData> appSites;

    private NativeThirdPartyUriHelper$AppSites() {
    }
}
