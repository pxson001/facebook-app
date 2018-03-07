package com.facebook.config.server;

import android.net.Uri;
import android.net.Uri.Builder;
import com.facebook.config.application.ApiConnectionType;
import com.facebook.http.config.PlatformAppHttpConfig;
import javax.inject.Provider;

/* compiled from: sent_header_response */
public class BootstrapPlatformAppHttpConfig implements PlatformAppHttpConfig {
    @ApiConnectionType
    private final Provider<String> f5572a;

    public BootstrapPlatformAppHttpConfig(Provider<String> provider) {
        this.f5572a = provider;
    }

    public final Builder mo1359a() {
        return Uri.parse("https://b-api.facebook.com").buildUpon();
    }

    public final Builder mo1360b() {
        return Uri.parse("https://b-graph.facebook.com").buildUpon();
    }

    public final Builder mo1361c() {
        throw new UnsupportedOperationException("BootstrapHttpConfig should be used only for graph and api requests");
    }

    public final Builder mo1362d() {
        throw new UnsupportedOperationException("BootstrapHttpConfig should be used only for graph and api requests");
    }

    public final Builder mo1363e() {
        return Uri.parse("https://b-graph.secure.facebook.com").buildUpon();
    }

    public final Builder mo1364f() {
        throw new UnsupportedOperationException("BootstrapHttpConfig should be used only for graph and api requests");
    }

    public final Builder mo1365g() {
        throw new UnsupportedOperationException("BootstrapHttpConfig should be used only for graph and api requests");
    }

    public final String mo1366h() {
        return null;
    }

    public final String mo1367i() {
        return (String) this.f5572a.get();
    }
}
