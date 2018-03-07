package com.facebook.downloader;

/* compiled from: The field 'availability' has been assigned the invalid value  */
public class DownloadNetworkPreference {
    private int f24223a;

    /* compiled from: The field 'availability' has been assigned the invalid value  */
    public enum NetworkPreference {
        MOBILE(1),
        WIFI(2),
        DEFAULT(WIFI.value);
        
        public final int value;

        private NetworkPreference(int i) {
            this.value = i;
        }
    }

    public DownloadNetworkPreference() {
        this.f24223a = NetworkPreference.DEFAULT.value;
    }

    public DownloadNetworkPreference(int i) {
        this.f24223a = i;
    }

    public final boolean m26175a() {
        return (this.f24223a & NetworkPreference.MOBILE.value) == NetworkPreference.MOBILE.value;
    }

    public final boolean m26176b() {
        return (this.f24223a & NetworkPreference.WIFI.value) == NetworkPreference.WIFI.value;
    }
}
