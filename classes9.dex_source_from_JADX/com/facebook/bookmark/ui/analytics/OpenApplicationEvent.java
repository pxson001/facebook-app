package com.facebook.bookmark.ui.analytics;

import com.facebook.analytics.logger.HoneyClientEvent;

/* compiled from: receipt_item */
public class OpenApplicationEvent extends HoneyClientEvent {
    public OpenApplicationEvent(String str, String str2, String str3) {
        super("open_application");
        j(str2);
        this.c = "sidebar_menu";
        b("application_link_type", str);
        b("display_name", str3);
    }
}
