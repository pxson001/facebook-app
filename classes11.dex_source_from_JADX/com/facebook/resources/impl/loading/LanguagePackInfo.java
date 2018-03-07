package com.facebook.resources.impl.loading;

import com.facebook.common.json.AutoGenJsonDeserializer;
import com.facebook.common.json.AutoGenJsonSerializer;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.Objects;
import javax.annotation.concurrent.Immutable;

@AutoGenJsonSerializer
@AutoGenJsonDeserializer
@Immutable
/* compiled from: PRIVACY_CHECKUP_APP_STEP_DELETE_DIALOG_CANCEL */
public class LanguagePackInfo {
    @JsonProperty("download_checksum")
    public final String checksum;
    @JsonProperty("download_url")
    public final String downloadUrl;
    @JsonProperty("locale")
    public final String locale;
    @JsonProperty("version_code")
    public final int versionCode;

    public LanguagePackInfo(String str, int i, String str2, String str3) {
        this.downloadUrl = str;
        this.versionCode = i;
        this.checksum = str2;
        this.locale = str3;
    }

    private LanguagePackInfo() {
        this.locale = null;
        this.checksum = null;
        this.downloadUrl = null;
        this.versionCode = 0;
    }

    public int hashCode() {
        return Objects.hashCode(new Object[]{this.downloadUrl, this.checksum, Integer.valueOf(this.versionCode), this.locale});
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof LanguagePackInfo)) {
            return false;
        }
        LanguagePackInfo languagePackInfo = (LanguagePackInfo) obj;
        if (Objects.equal(this.downloadUrl, languagePackInfo.downloadUrl) && Objects.equal(this.checksum, languagePackInfo.checksum) && this.versionCode == languagePackInfo.versionCode && Objects.equal(this.locale, languagePackInfo.locale)) {
            return true;
        }
        return false;
    }
}
