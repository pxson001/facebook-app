package com.facebook.common.util;

import android.net.Uri;
import android.net.Uri.Builder;
import android.support.v4.util.LruCache;
import com.facebook.common.build.BuildConstants;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Objects;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Sets;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/* compiled from: media_type */
public class FacebookUriUtil {
    @VisibleForTesting
    static final LruCache<Uri, Uri> f14512a = new LruCache(100);
    private static final ImmutableSet<String> f14513b = ImmutableSet.of("code.facebook.com", "research.facebook.com", "developers.facebook.com", "business.facebook.com", "inspired.facebook.com", "canvas.facebook.com", new String[0]);
    public static final Set<String> f14514c = Sets.m1315a("__gda__", "oh", "oe", "hdnea", "logcdn", "efg");
    private static final String[] f14515d = new String[]{"_nc_"};
    public static final ThreadLocal<StringBuilder> f14516e = new ThreadLocal();

    public static boolean m20916a(Uri uri) {
        if (m20919c(uri) && uri.getPath().equals("/l.php")) {
            return true;
        }
        return false;
    }

    public static Uri m20918b(Uri uri) {
        while (m20916a(uri)) {
            String queryParameter = uri.getQueryParameter("u");
            if (Strings.isNullOrEmpty(queryParameter)) {
                break;
            }
            uri = Uri.parse(queryParameter);
        }
        return uri;
    }

    public static boolean m20919c(Uri uri) {
        if (uri == null) {
            return false;
        }
        String host = uri.getHost();
        if (host == null || !m20921f(uri) || !host.endsWith(".facebook.com") || host.startsWith("our.intern.") || f14513b.contains(host)) {
            return false;
        }
        return true;
    }

    public static boolean m20920d(Uri uri) {
        return uri != null && m20919c(uri) && "approval".equals(uri.getQueryParameter("v"));
    }

    public static boolean m20921f(Uri uri) {
        return uri != null && ("http".equals(uri.getScheme()) || "https".equals(uri.getScheme()));
    }

    public static boolean m20922g(Uri uri) {
        return uri != null && ("fb".equals(uri.getScheme()) || "fb-messenger".equals(uri.getScheme()) || "fb-messenger-secure".equals(uri.getScheme()) || "fb-messenger-sametask".equals(uri.getScheme()) || "fbinternal".equals(uri.getScheme()) || "fb-work".equals(uri.getScheme()) || "dialtone".equals(uri.getScheme()) || "fb-service".equals(uri.getScheme()));
    }

    public static boolean m20923h(Uri uri) {
        return uri != null && (BuildConstants.b.equals(uri.getScheme()) || BuildConstants.c.equals(uri.getScheme()) || BuildConstants.d.equals(uri.getScheme()) || (BuildConstants.a.equals(uri.getScheme()) && "messaging".equals(uri.getHost())));
    }

    public static boolean m20927m(Uri uri) {
        if (!m20921f(uri)) {
            return false;
        }
        String host = uri.getHost();
        if (host == null) {
            return false;
        }
        if (host.endsWith(".fbcdn.net")) {
            return true;
        }
        if (!host.endsWith(".akamaihd.net")) {
            return false;
        }
        if (host.startsWith("fbcdn-")) {
            return true;
        }
        if (host.startsWith("fbstatic-")) {
            return true;
        }
        if (host.startsWith("fbexternal-")) {
            return true;
        }
        return false;
    }

    @VisibleForTesting
    private static boolean m20928n(Uri uri) {
        if (!m20921f(uri)) {
            return false;
        }
        String host = uri.getHost();
        if (!host.endsWith(".net")) {
            return false;
        }
        if (host.indexOf(".fbcdn.") != -1) {
            if (host.indexOf("sonar.") == -1) {
                return true;
            }
            return false;
        } else if (host.endsWith(".akamaihd.net") && host.startsWith("fbcdn-")) {
            return true;
        } else {
            return false;
        }
    }

    @VisibleForTesting
    private static Uri m20929o(Uri uri) {
        if (!m20928n(uri)) {
            return uri;
        }
        Set emptySet;
        String encodedQuery = uri.getEncodedQuery();
        if (encodedQuery == null) {
            emptySet = Collections.emptySet();
        } else {
            Set treeSet = new TreeSet();
            int i = 0;
            int length = encodedQuery.length();
            do {
                int indexOf = encodedQuery.indexOf(38, i);
                if (indexOf == -1) {
                    indexOf = length;
                }
                int indexOf2 = encodedQuery.indexOf(61, i);
                if (indexOf2 > indexOf || indexOf2 == -1) {
                    indexOf2 = indexOf;
                }
                String substring = encodedQuery.substring(i, indexOf2);
                if (!(substring.startsWith("_nc_") || f14514c.contains(substring))) {
                    treeSet.add(Uri.decode(substring));
                }
                i = indexOf + 1;
            } while (i < length);
            emptySet = treeSet;
        }
        Set<String> set = emptySet;
        String encodedUserInfo = uri.getEncodedUserInfo();
        int port = uri.getPort();
        if (encodedUserInfo == null && port == -1) {
            encodedUserInfo = "fbcdn.net";
        } else {
            StringBuilder stringBuilder = new StringBuilder();
            if (encodedUserInfo != null) {
                stringBuilder.append(encodedUserInfo).append('@');
            }
            stringBuilder.append("fbcdn.net");
            if (port != -1) {
                stringBuilder.append(':').append(port);
            }
            encodedUserInfo = stringBuilder.toString();
        }
        Builder appendEncodedPath = new Builder().scheme(uri.getScheme()).encodedAuthority(encodedUserInfo).appendEncodedPath(m20930r(uri));
        for (String encodedUserInfo2 : set) {
            appendEncodedPath.appendQueryParameter(encodedUserInfo2, uri.getQueryParameter(encodedUserInfo2));
        }
        appendEncodedPath.fragment(uri.getFragment());
        return appendEncodedPath.build();
    }

    @VisibleForTesting
    public static String m20930r(Uri uri) {
        int i = 1;
        CharSequence encodedPath = uri.getEncodedPath();
        if (!encodedPath.contains("/h")) {
            return encodedPath.substring(1);
        }
        if (encodedPath.startsWith("/h")) {
            i = encodedPath.indexOf(47, 2) + 1;
        }
        StringBuilder stringBuilder = (StringBuilder) f14516e.get();
        if (stringBuilder == null) {
            stringBuilder = new StringBuilder();
            f14516e.set(stringBuilder);
        }
        stringBuilder.setLength(0);
        StringBuilder stringBuilder2 = stringBuilder;
        while (i >= 0) {
            int indexOf = encodedPath.indexOf("/h", i);
            if (indexOf == -1) {
                break;
            }
            stringBuilder2.append(encodedPath, i, indexOf);
            i = encodedPath.indexOf(47, indexOf + 1);
        }
        if (i >= 0) {
            stringBuilder2.append(encodedPath, i, encodedPath.length());
        }
        return stringBuilder2.toString();
    }

    public static Uri m20924i(Uri uri) {
        Uri uri2 = (Uri) f14512a.m4432a((Object) uri);
        if (uri2 != null) {
            return uri2;
        }
        Object o = m20929o(uri);
        f14512a.m4433a((Object) uri, o);
        return o;
    }

    public static boolean m20925k(Uri uri) {
        if (uri != null && m20927m(uri)) {
            String queryParameter = uri.getQueryParameter("oe");
            if (queryParameter != null) {
                return new Date(Long.parseLong(queryParameter, 16) * 1000).before(new Date());
            }
        }
        return false;
    }

    public static Uri m20915a(Uri uri, String str, String str2) {
        Set<String> queryParameterNames = uri.getQueryParameterNames();
        Builder buildUpon = uri.buildUpon();
        buildUpon.query(null);
        Object obj = null;
        for (String str3 : queryParameterNames) {
            if (str3.equals(str)) {
                buildUpon.appendQueryParameter(str3, str2);
                obj = 1;
            } else {
                List<String> queryParameters = uri.getQueryParameters(str3);
                if (queryParameters != null) {
                    for (String appendQueryParameter : queryParameters) {
                        buildUpon.appendQueryParameter(str3, appendQueryParameter);
                    }
                }
            }
        }
        if (obj == null) {
            buildUpon.appendQueryParameter(str, str2);
        }
        return buildUpon.build();
    }

    public static boolean m20917a(Uri uri, Uri uri2) {
        return Objects.equal(uri.getScheme(), uri2.getScheme()) && Objects.equal(uri.getAuthority(), uri2.getAuthority());
    }

    public static boolean m20926l(Uri uri) {
        return uri != null && "fb-service".equals(uri.getScheme());
    }
}
