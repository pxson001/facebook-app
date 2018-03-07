package com.facebook.deeplinking.handler;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.facebook.common.fblinks.FBLinks;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.deeplinking.DeepLinkingUtils;
import java.util.List;
import javax.inject.Inject;

/* compiled from: phone_number_key */
public class PageDeepLinkHandler implements DeepLinkHandler {
    private final DeepLinkingUtils f6626a;

    @Inject
    public PageDeepLinkHandler(DeepLinkingUtils deepLinkingUtils) {
        this.f6626a = deepLinkingUtils;
    }

    public final Intent mo269a(Context context, Uri uri) {
        if (uri.getPath() == null || !uri.getPath().startsWith("/fbrdr/274/")) {
            return null;
        }
        List pathSegments = uri.getPathSegments();
        return this.f6626a.m6910a(StringFormatUtil.formatStrLocaleSafe(FBLinks.af, (String) pathSegments.get(pathSegments.size() - 1)));
    }
}
