package com.facebook.selfupdate;

import org.json.JSONObject;

/* compiled from: hide_drop_shadow */
public class AppServerResponse {
    public final String f9941a;
    public final long f9942b;
    public final String f9943c;
    public final int f9944d;
    public final int f9945e;
    public final String f9946f;
    public final String f9947g;
    public final String f9948h;
    public final String f9949i;
    public final int f9950j;
    public final String f9951k;
    public final long f9952l;

    /* compiled from: hide_drop_shadow */
    public enum ClientReleaseClientAction {
        NOTIFY_USER(1),
        FORCE_UPDATE_NOTIFY_USER(2),
        FORCE_UPDATE_SILENT(3),
        DEFAULT(NOTIFY_USER.value);
        
        public final int value;

        private ClientReleaseClientAction(int i) {
            this.value = i;
        }
    }

    /* compiled from: hide_drop_shadow */
    public enum ClientReleaseDownloadNetworks {
        MOBILE(1),
        WIFI(2),
        DEFAULT(WIFI.value);
        
        public final int value;

        private ClientReleaseDownloadNetworks(int i) {
            this.value = i;
        }
    }

    public final boolean m10069a() {
        return this.f9946f != null;
    }

    public final boolean m10070b() {
        return this.f9945e == ClientReleaseClientAction.FORCE_UPDATE_NOTIFY_USER.value;
    }

    public final long m10071c() {
        return this.f9942b > 0 ? (this.f9942b * 60) * 1000 : 43200000;
    }

    public AppServerResponse(JSONObject jSONObject, JSONObject jSONObject2) {
        this.f9942b = jSONObject.optLong("update_check_minutes", 0);
        this.f9943c = jSONObject2.optString("release_package", null);
        this.f9944d = jSONObject2.optInt("release_number", 0);
        this.f9946f = jSONObject2.optString("download_url", null);
        this.f9945e = jSONObject2.optInt("client_action", ClientReleaseClientAction.DEFAULT.value);
        this.f9947g = jSONObject2.optString("release_notes", "");
        this.f9948h = jSONObject2.optString("application_name", "");
        this.f9949i = jSONObject2.optString("application_version", "");
        this.f9950j = jSONObject2.optInt("allowed_networks", ClientReleaseDownloadNetworks.DEFAULT.value);
        String optString = jSONObject2.optString("megaphone", "no_megaphone");
        if (optString == null || optString.equals("null")) {
            this.f9941a = "no_megaphone";
        } else {
            this.f9941a = optString;
        }
        this.f9951k = jSONObject2.optString("file_mime_type", "application/vnd.android.package-archive");
        this.f9952l = jSONObject2.optLong("file_size");
    }
}
