package com.facebook.intent.thirdparty;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

@JsonIgnoreProperties(b = true)
/* compiled from: mCommunicationRank */
class NativeThirdPartyUriHelper$AppSiteData {
    @JsonProperty("app_name")
    String appName;
    @JsonProperty("appsite")
    String appSite;
    @JsonProperty("appsite_url")
    String appSiteUrl;
    @JsonProperty("fallback_url")
    String fallbackUrl;
    @JsonProperty("is_app_link")
    String isAppLink;
    @JsonProperty("key_hashes")
    List<String> keyHashes;
    @JsonProperty("market_uri")
    String marketUri;
    @JsonProperty("package")
    String packageName;

    private NativeThirdPartyUriHelper$AppSiteData() {
    }
}
