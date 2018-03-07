package com.facebook.appupdate;

import java.io.Serializable;
import javax.annotation.concurrent.Immutable;
import org.json.JSONObject;

@Immutable
/* compiled from: UNFILTERED */
public class ReleaseInfo implements Serializable {
    public final String appName;
    public final long downloadSize;
    public final String downloadUri;
    public final String iconUri;
    public final boolean isHardNag;
    private int mHash;
    public final String packageName;
    public final String releaseNotes;
    public final String source;
    public final int versionCode;
    public final String versionName;

    public ReleaseInfo(String str, int i, String str2, boolean z, String str3, String str4, String str5, String str6, long j, String str7) {
        this.packageName = str;
        this.versionCode = i;
        this.downloadUri = str2;
        this.isHardNag = z;
        this.appName = str3;
        this.iconUri = str4;
        this.versionName = str5;
        this.releaseNotes = str6;
        this.downloadSize = j;
        this.source = str7;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ReleaseInfo) || hashCode() != obj.hashCode()) {
            return false;
        }
        ReleaseInfo releaseInfo = (ReleaseInfo) obj;
        if (this.versionCode == releaseInfo.versionCode && m25827a(this.packageName, releaseInfo.packageName) && m25827a(this.downloadUri, releaseInfo.downloadUri) && this.isHardNag == releaseInfo.isHardNag && m25827a(this.appName, releaseInfo.appName) && m25827a(this.iconUri, releaseInfo.iconUri) && m25827a(this.versionName, releaseInfo.versionName) && m25827a(this.releaseNotes, releaseInfo.releaseNotes) && this.downloadSize == releaseInfo.downloadSize && m25827a(this.source, releaseInfo.source)) {
            return true;
        }
        return false;
    }

    private static boolean m25827a(Object obj, Object obj2) {
        if (obj == null && obj2 == null) {
            return true;
        }
        if (obj == null || obj2 == null) {
            return false;
        }
        return obj.equals(obj2);
    }

    public int hashCode() {
        int i = 1;
        int i2 = 0;
        int i3 = this.mHash;
        if (i3 != 0) {
            return i3;
        }
        i3 = (this.downloadUri == null ? 0 : this.downloadUri.hashCode()) + (this.versionCode + (this.packageName == null ? 1 : this.packageName.hashCode()));
        if (!this.isHardNag) {
            i = 0;
        }
        i3 = (int) (((long) ((this.releaseNotes == null ? 0 : this.releaseNotes.hashCode()) + ((((i + i3) + (this.appName == null ? 0 : this.appName.hashCode())) + (this.iconUri == null ? 0 : this.iconUri.hashCode())) + (this.versionName == null ? 0 : this.versionName.hashCode())))) + this.downloadSize);
        if (this.source != null) {
            i2 = this.source.hashCode();
        }
        i3 += i2;
        this.mHash = i3;
        return i3;
    }

    public final JSONObject m25828a() {
        JSONObject jSONObject = new JSONObject();
        Utils.m25835a(jSONObject, "package_name", this.packageName);
        Utils.m25833a(jSONObject, "version_code", this.versionCode);
        Utils.m25835a(jSONObject, "download_uri", this.downloadUri);
        Utils.m25837a(jSONObject, "is_hard_nag", this.isHardNag);
        Utils.m25835a(jSONObject, "app_name", this.appName);
        Utils.m25835a(jSONObject, "icon_uri", this.iconUri);
        Utils.m25835a(jSONObject, "version_name", this.versionName);
        Utils.m25835a(jSONObject, "release_notes", this.releaseNotes);
        Utils.m25834a(jSONObject, "download_size", this.downloadSize);
        Utils.m25835a(jSONObject, "source", this.source);
        return jSONObject;
    }
}
