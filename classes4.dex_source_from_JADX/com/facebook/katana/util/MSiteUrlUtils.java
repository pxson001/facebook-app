package com.facebook.katana.util;

import android.content.Context;
import android.net.Uri;
import android.net.Uri.Builder;
import android.text.TextUtils;
import com.facebook.common.locale.Locales;
import com.facebook.config.application.Boolean_IsWorkBuildMethodAutoProvider;
import com.facebook.config.application.FbAppType;
import com.facebook.config.server.NetworkLogUrl;
import com.facebook.inject.InjectorLike;
import com.facebook.work.config.String_WorkCommunitySubdomainMethodAutoProvider;
import javax.inject.Inject;

/* compiled from: ui thread */
public class MSiteUrlUtils {
    private final Locales f642a;
    private final boolean f643b;
    private final FbAppType f644c;
    private final String f645d;

    public static MSiteUrlUtils m1011b(InjectorLike injectorLike) {
        return new MSiteUrlUtils(Locales.a(injectorLike), Boolean_IsWorkBuildMethodAutoProvider.a(injectorLike), (FbAppType) injectorLike.getInstance(FbAppType.class), String_WorkCommunitySubdomainMethodAutoProvider.m1197b(injectorLike));
    }

    @Inject
    public MSiteUrlUtils(Locales locales, Boolean bool, FbAppType fbAppType, String str) {
        this.f643b = bool.booleanValue();
        this.f644c = fbAppType;
        this.f642a = locales;
        this.f645d = str;
    }

    public static MSiteUrlUtils m1008a(InjectorLike injectorLike) {
        return m1011b(injectorLike);
    }

    public final String m1012a(Context context, String str) {
        String str2 = "https://m.%s/";
        if (this.f643b && this.f645d != null) {
            str2 = m1010a("https");
        }
        StringBuilder stringBuilder = new StringBuilder(NetworkLogUrl.a(context, str2));
        if (!TextUtils.isEmpty(str)) {
            if (str.charAt(0) == '/') {
                stringBuilder.append(str, 1, str.length());
            } else {
                stringBuilder.append(str);
            }
        }
        return stringBuilder.toString();
    }

    public final String m1013b(Context context, String str) {
        return m1009a(context, str, this.f642a.c());
    }

    private String m1009a(Context context, String str, String str2) {
        String str3 = "http://m.%s/";
        if (this.f643b && this.f645d != null) {
            str3 = m1010a("http");
        }
        Builder buildUpon = Uri.parse(NetworkLogUrl.a(context, str3) + str).buildUpon();
        str3 = this.f644c.c();
        if (null != null) {
            str3 = "236820239731947";
        }
        buildUpon.appendQueryParameter("cid", str3).build();
        buildUpon.appendQueryParameter("locale", str2);
        return buildUpon.build().toString();
    }

    private String m1010a(String str) {
        return "://" + this.f645d + ".m.%s/";
    }
}
