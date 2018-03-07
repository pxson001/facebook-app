package com.facebook.deeplinking.handler;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.facebook.common.fblinks.FBLinks;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.deeplinking.DeepLinkingUtils;
import java.util.List;
import javax.inject.Inject;

/* compiled from: phone_acquisition_promo */
public class TimelineDeepLinkHandler implements DeepLinkHandler {
    private final DeepLinkingUtils f6628a;

    @Inject
    public TimelineDeepLinkHandler(DeepLinkingUtils deepLinkingUtils) {
        this.f6628a = deepLinkingUtils;
    }

    public final Intent mo269a(Context context, Uri uri) {
        if (uri.getPath() == null || !uri.getPath().startsWith("/fbrdr/2048/")) {
            return null;
        }
        List pathSegments = uri.getPathSegments();
        return this.f6628a.m6910a(StringFormatUtil.formatStrLocaleSafe(FBLinks.aX, (String) pathSegments.get(pathSegments.size() - 1)));
    }
}
