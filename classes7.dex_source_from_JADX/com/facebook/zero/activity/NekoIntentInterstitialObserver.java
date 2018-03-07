package com.facebook.zero.activity;

import android.content.Intent;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.zero.activity.ZeroIntentInterstitialActivity.Observer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import javax.inject.Inject;

/* compiled from: ‌  */
public class NekoIntentInterstitialObserver implements Observer {
    private final AnalyticsLogger f0a;
    private final ObjectMapper f1b;

    @Inject
    public NekoIntentInterstitialObserver(AnalyticsLogger analyticsLogger, ObjectMapper objectMapper) {
        this.f0a = analyticsLogger;
        this.f1b = objectMapper;
    }

    public final void mo1a(Intent intent) {
        if (intent != null && m3c(intent)) {
            this.f0a.a(m2a(intent, "app_install_zero_rating_interstitial_continue"));
        }
    }

    public final void mo2b(Intent intent) {
        if (intent != null && m3c(intent)) {
            this.f0a.a(m2a(intent, "app_install_zero_rating_interstitial_cancel"));
        }
    }

    private static boolean m3c(Intent intent) {
        if (intent == null) {
            return false;
        }
        return intent.getBooleanExtra("neko_log_flag", false);
    }

    private HoneyClientEvent m2a(Intent intent, String str) {
        JsonNode jsonNode;
        String stringExtra = intent.getStringExtra("app_id");
        String stringExtra2 = intent.getStringExtra("unity_type");
        String stringExtra3 = intent.getStringExtra("app_link_type");
        boolean booleanExtra = intent.getBooleanExtra("is_sponsored", false);
        try {
            jsonNode = (JsonNode) this.f1b.a(intent.getStringExtra("tracking_codes"), JsonNode.class);
        } catch (IOException e) {
            jsonNode = null;
        } catch (NullPointerException e2) {
            jsonNode = null;
        }
        if (jsonNode == null || jsonNode.e() == 0 || stringExtra == null || stringExtra2 == null || stringExtra3 == null) {
            return null;
        }
        return new HoneyClientEvent(str).a("tracking", jsonNode).j(stringExtra).b("unit_type", stringExtra2).b("application_link_type", stringExtra3).b(booleanExtra).g("native_newsfeed");
    }
}
