package com.google.android.gms.common;

import android.content.Intent;

public class GooglePlayServicesRepairableException extends UserRecoverableException {
    private final int zzTQ;

    GooglePlayServicesRepairableException(int i, String str, Intent intent) {
        super(str, intent);
        this.zzTQ = i;
    }

    public final int m289a() {
        return this.zzTQ;
    }
}
