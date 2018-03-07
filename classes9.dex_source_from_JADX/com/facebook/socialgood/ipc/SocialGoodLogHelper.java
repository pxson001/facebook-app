package com.facebook.socialgood.ipc;

import android.os.Bundle;
import com.facebook.analytics.logger.HoneyClientEvent;

/* compiled from: user_credential */
public class SocialGoodLogHelper {
    public static HoneyClientEvent m824a(String str) {
        HoneyClientEvent honeyClientEvent = new HoneyClientEvent("tapped_fundraiser_share_attachment");
        honeyClientEvent.c = "social_good";
        return honeyClientEvent.b("fundraiser_campaign_id", str);
    }

    public static HoneyClientEvent m826c(String str) {
        HoneyClientEvent honeyClientEvent = new HoneyClientEvent("viewed_fundraiser_share_attachment");
        honeyClientEvent.c = "social_good";
        return honeyClientEvent.b("fundraiser_campaign_id", str);
    }

    public static HoneyClientEvent m827d(String str) {
        HoneyClientEvent honeyClientEvent = new HoneyClientEvent("fundraiser_page_missing_fields");
        honeyClientEvent.c = "social_good";
        return honeyClientEvent.b("fundraiser_campaign_id", str);
    }

    public static Bundle m825b() {
        Bundle bundle = new Bundle();
        bundle.putString("source", "share_attachment");
        return bundle;
    }
}
