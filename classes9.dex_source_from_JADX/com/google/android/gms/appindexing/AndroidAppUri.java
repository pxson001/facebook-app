package com.google.android.gms.appindexing;

import android.net.Uri;
import android.net.Uri.Builder;
import android.text.TextUtils;
import com.google.android.gms.common.internal.zzw;
import java.util.List;

public final class AndroidAppUri {
    public final Uri f20591a;

    public AndroidAppUri(Uri uri) {
        this.f20591a = uri;
    }

    public static AndroidAppUri m20081a(Uri uri) {
        AndroidAppUri androidAppUri = new AndroidAppUri(uri);
        if (m20082a(androidAppUri)) {
            return androidAppUri;
        }
        throw new IllegalArgumentException("AndroidAppUri validation failed.");
    }

    private static boolean m20082a(AndroidAppUri androidAppUri) {
        if (!"android-app".equals(androidAppUri.f20591a.getScheme())) {
            throw new IllegalArgumentException("android-app scheme is required.");
        } else if (TextUtils.isEmpty(androidAppUri.m20083a())) {
            throw new IllegalArgumentException("Package name is empty.");
        } else {
            String a = androidAppUri.m20083a();
            Uri b = androidAppUri.m20084b();
            Builder authority = new Builder().scheme("android-app").authority(a);
            if (b != null) {
                authority.appendPath(b.getScheme());
                if (b.getAuthority() != null) {
                    authority.appendPath(b.getAuthority());
                }
                for (String appendPath : b.getPathSegments()) {
                    authority.appendPath(appendPath);
                }
                authority.encodedQuery(b.getEncodedQuery()).encodedFragment(b.getEncodedFragment());
            }
            if (androidAppUri.f20591a.equals(new AndroidAppUri(authority.build()).f20591a)) {
                return true;
            }
            throw new IllegalArgumentException("URI is not canonical.");
        }
    }

    public final String m20083a() {
        return this.f20591a.getAuthority();
    }

    public final Uri m20084b() {
        List pathSegments = this.f20591a.getPathSegments();
        if (pathSegments.size() <= 0) {
            return null;
        }
        String str = (String) pathSegments.get(0);
        Builder builder = new Builder();
        builder.scheme(str);
        if (pathSegments.size() > 1) {
            builder.authority((String) pathSegments.get(1));
            for (int i = 2; i < pathSegments.size(); i++) {
                builder.appendPath((String) pathSegments.get(i));
            }
        }
        builder.encodedQuery(this.f20591a.getEncodedQuery());
        builder.encodedFragment(this.f20591a.getEncodedFragment());
        return builder.build();
    }

    public final boolean equals(Object obj) {
        return obj instanceof AndroidAppUri ? this.f20591a.equals(((AndroidAppUri) obj).f20591a) : false;
    }

    public final int hashCode() {
        return zzw.a(new Object[]{this.f20591a});
    }

    public final String toString() {
        return this.f20591a.toString();
    }
}
