package com.facebook.content;

import android.net.Uri;
import com.facebook.common.internal.ImmutableSet;

/* compiled from: seller_info */
public class SafeOAuthUrl {
    public static final ImmutableSet<String> f2848b = ImmutableSet.a(new String[]{"api.instagram.com", "www.tumblr.com", "pinterest.com", "accounts.spotify.com", "www.pinterest.com", "www.flickr.com", "api.flickr.com"});
    private Uri f2849a;

    public SafeOAuthUrl(String str) {
        Uri parse = Uri.parse(str);
        Object obj = null;
        if (f2848b.contains(parse.getHost()) && (parse.toString().contains("oauth") || parse.toString().contains("authorize"))) {
            obj = 1;
        }
        if (obj != null) {
            this.f2849a = parse;
            return;
        }
        throw new IllegalArgumentException("Invalid auth url accessed " + str);
    }

    public String toString() {
        return this.f2849a.toString();
    }
}
