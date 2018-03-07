package com.facebook.confirmation.protocol;

/* compiled from: instant_article_fonts */
public enum OpenIDConnectProvider {
    GOOGLE("google", "com.google", "15057814354-80cg059cn49j6kmhhkjam4b00on1gb2n.apps.googleusercontent.com");
    
    public final String clientId;
    public final String name;
    public final String type;

    private OpenIDConnectProvider(String str, String str2, String str3) {
        this.name = str;
        this.type = str2;
        this.clientId = str3;
    }
}
