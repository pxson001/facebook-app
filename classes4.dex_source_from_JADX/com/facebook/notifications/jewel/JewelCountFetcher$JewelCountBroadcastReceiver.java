package com.facebook.notifications.jewel;

import com.facebook.content.DynamicSecureBroadcastReceiver;

/* compiled from: search_for_soft_matched_account */
public class JewelCountFetcher$JewelCountBroadcastReceiver extends DynamicSecureBroadcastReceiver {
    public JewelCountFetcher$JewelCountBroadcastReceiver() {
        super(JewelCountFetcher.a, new JewelCountInitiateFetchReceiver());
    }
}
