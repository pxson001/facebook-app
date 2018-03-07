package com.facebook.oxygen.preloads.sdk.firstparty.settings;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* compiled from: textAlignVertical */
public class AppmanagerRemoteException extends Exception {
    public final int reason;

    @Retention(RetentionPolicy.SOURCE)
    /* compiled from: textAlignVertical */
    public @interface Reason {
    }

    public AppmanagerRemoteException(int i, String str) {
        super(str);
        this.reason = i;
    }

    public AppmanagerRemoteException(int i, String str, Throwable th) {
        super(str, th);
        this.reason = i;
    }
}
