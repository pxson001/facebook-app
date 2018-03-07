package com.facebook.dialtone;

/* compiled from: \\r */
enum DialtoneWhitelist$WhitelistType {
    URI("uri"),
    FEATURE_TAG("feature_tag"),
    FACEWEB("faceweb");
    
    String mType;

    private DialtoneWhitelist$WhitelistType(String str) {
        this.mType = str;
    }

    public final String getType() {
        return this.mType;
    }
}
