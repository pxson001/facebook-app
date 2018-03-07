package com.facebook.downloader;

import javax.annotation.Nullable;

/* compiled from: setThreadParticipantNickname */
public class DownloadRequest {
    public final DownloadType f24233a;
    private final String f24234b;
    private final DownloadNetworkPreference f24235c;
    private final String f24236d;
    private final boolean f24237e;
    private final long f24238f;
    public final String f24239g;
    private final String f24240h;
    private final boolean f24241i;

    /* compiled from: setThreadParticipantNickname */
    public class Builder {
        public DownloadType f24224a;
        public String f24225b;
        public DownloadNetworkPreference f24226c;
        public String f24227d;
        public long f24228e = 0;
        public boolean f24229f = false;
        private String f24230g = null;
        public String f24231h = null;
        private boolean f24232i = true;

        public static Builder m26177a() {
            return new Builder();
        }

        private Builder() {
        }

        public final DownloadRequest m26178b() {
            return new DownloadRequest(this.f24224a, this.f24225b, this.f24226c, this.f24227d, this.f24228e, this.f24229f, this.f24230g, this.f24231h, this.f24232i);
        }
    }

    /* compiled from: setThreadParticipantNickname */
    public enum DownloadType {
        APP_UPDATE,
        SIDELOADING,
        VIDEOAD,
        UNKNOWN
    }

    private DownloadRequest(DownloadType downloadType, String str, DownloadNetworkPreference downloadNetworkPreference, String str2, long j, boolean z, @Nullable String str3, String str4, boolean z2) {
        this.f24233a = downloadType;
        this.f24234b = str;
        this.f24235c = downloadNetworkPreference;
        this.f24236d = str2;
        this.f24238f = j;
        this.f24237e = z;
        this.f24239g = str3;
        this.f24240h = str4;
        this.f24241i = z2;
    }

    public final DownloadType m26179a() {
        return this.f24233a;
    }

    public final String m26180b() {
        return this.f24234b;
    }

    public final DownloadNetworkPreference m26181c() {
        return this.f24235c;
    }

    public final String m26182d() {
        return this.f24236d;
    }

    public final long m26183e() {
        return this.f24238f;
    }

    public final boolean m26184f() {
        return this.f24237e;
    }

    public final String m26185g() {
        return this.f24239g;
    }

    public final String m26186h() {
        return this.f24240h;
    }

    public final boolean m26187i() {
        return this.f24241i;
    }
}
