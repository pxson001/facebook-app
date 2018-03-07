package com.facebook.reportaproblem.base;

import android.net.Uri;

/* compiled from: shortcutIcon */
public class ReportAProblemForkOption {
    public final String f4537a;
    public String f4538b;
    public Uri f4539c;
    public final int f4540d;

    /* compiled from: shortcutIcon */
    public enum ForkOptionType {
        FORK_OPTION_ACTIVITY,
        FORK_OPTION_SCREEN
    }

    public ReportAProblemForkOption(String str, String str2, int i) {
        this.f4537a = str;
        this.f4538b = str2;
        this.f4540d = i;
    }

    public ReportAProblemForkOption(String str, Uri uri, int i) {
        this.f4537a = str;
        this.f4539c = uri;
        this.f4540d = i;
    }
}
