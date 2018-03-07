package com.google.android.gms.common;

import android.content.Intent;

public class UserRecoverableException extends Exception {
    private final Intent mIntent;

    public UserRecoverableException(String str, Intent intent) {
        super(str);
        this.mIntent = intent;
    }

    public final Intent m290b() {
        return new Intent(this.mIntent);
    }
}
