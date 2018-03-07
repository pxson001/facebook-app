package com.facebook.push.crossapp;

import com.facebook.content.DynamicSecureBroadcastReceiver;

/* compiled from: hour_ranges */
public class PackageFullyRemovedBroadcastReceiver extends DynamicSecureBroadcastReceiver {
    public PackageFullyRemovedBroadcastReceiver() {
        super("android.intent.action.PACKAGE_FULLY_REMOVED", new PackageFullyRemovedActionReceiver());
    }
}
