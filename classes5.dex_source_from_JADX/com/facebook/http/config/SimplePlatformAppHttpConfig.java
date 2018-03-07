package com.facebook.http.config;

import android.net.Uri;
import android.net.Uri.Builder;
import com.facebook.config.application.ApiConnectionType;
import javax.inject.Provider;

/* compiled from: displayIntent */
public class SimplePlatformAppHttpConfig implements PlatformAppHttpConfig {
    private final String f5001a;
    private final String f5002b;
    @ApiConnectionType
    private final Provider<String> f5003c;

    public SimplePlatformAppHttpConfig(String str, String str2, Provider<String> provider) {
        this.f5001a = str;
        this.f5002b = str2;
        this.f5003c = provider;
    }

    public final Builder m9929a() {
        return Uri.parse("https://api." + this.f5001a).buildUpon();
    }

    public final Builder m9930b() {
        return Uri.parse("https://graph." + this.f5001a).buildUpon();
    }

    public final Builder m9931c() {
        return Uri.parse("https://graph-video." + this.f5001a).buildUpon();
    }

    public final Builder m9933e() {
        return Uri.parse("https://graph.secure." + this.f5001a).buildUpon();
    }

    public final Builder m9934f() {
        return Uri.parse("https://secure." + this.f5001a).buildUpon();
    }

    public final Builder m9932d() {
        if (this.f5002b.trim().isEmpty()) {
            return Uri.parse("https://rupload.facebook.com").buildUpon();
        }
        return Uri.parse("http://" + this.f5002b).buildUpon();
    }

    public final Builder m9935g() {
        return Uri.parse("http://h." + this.f5001a).buildUpon();
    }

    public final String m9936h() {
        return null;
    }

    public final String m9937i() {
        return (String) this.f5003c.get();
    }
}
