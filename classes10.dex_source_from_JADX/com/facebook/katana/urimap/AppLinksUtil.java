package com.facebook.katana.urimap;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.common.fblinks.FBLinks;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.util.FacebookUriUtil;
import com.facebook.common.util.StringUtil;
import com.facebook.inject.InjectorLike;
import com.fasterxml.jackson.databind.JsonNode;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/* compiled from: titlebar_back_button */
public class AppLinksUtil {
    public static AppLinksUtil m1231a(InjectorLike injectorLike) {
        return new AppLinksUtil();
    }

    public static HoneyClientEvent m1230a(@Nonnull JsonNode jsonNode, @Nonnull String str) {
        HoneyClientEvent b = new HoneyClientEvent("applink_navigation_event").b("target_url", str);
        if (jsonNode.d("extras")) {
            JsonNode b2 = jsonNode.b("extras");
            if (b2.d("ref")) {
                b.b("ref", b2.f("ref").B());
            } else {
                b.b("ref", "");
            }
        }
        return b;
    }

    @Nullable
    public static String m1232a(Uri uri) {
        if (uri == null || StringUtil.a(uri.getHost()) || StringUtil.a(uri.getPath()) || !FacebookUriUtil.c(uri)) {
            return null;
        }
        return StringFormatUtil.formatStrLocaleSafe(FBLinks.cs, uri.getPath());
    }

    @Nullable
    public static Intent m1229a(@Nonnull Fb4aUriIntentMapper fb4aUriIntentMapper, @Nonnull Context context, @Nonnull String str) {
        Intent a = fb4aUriIntentMapper.a(context, str);
        if (a != null) {
            a.putExtra("extra_launch_uri", str);
            a.putExtra("application_link_type", "applink_navigation_event");
        }
        return a;
    }
}
