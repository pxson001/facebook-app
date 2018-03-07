package com.facebook.proxygen;

/* compiled from: psym_android_feed */
public class RewriteRule {
    private String format;
    private String matcher;

    public RewriteRule(String str, String str2) {
        this.matcher = str;
        this.format = str2;
    }

    public String getMatcher() {
        return this.matcher;
    }

    public String getFormat() {
        return this.format;
    }
}
