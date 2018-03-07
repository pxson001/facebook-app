package com.facebook.deeplinking.handler;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.facebook.common.fblinks.FBLinks;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.util.StringUtil;
import com.facebook.deeplinking.DeepLinkingUtils;
import java.util.List;
import javax.inject.Inject;

/* compiled from: photoMemImages */
public class EventsDeepLinkHandler implements DeepLinkHandler {
    private final DeepLinkingUtils f6616a;

    @Inject
    public EventsDeepLinkHandler(DeepLinkingUtils deepLinkingUtils) {
        this.f6616a = deepLinkingUtils;
    }

    public final Intent mo269a(Context context, Uri uri) {
        List pathSegments = uri.getPathSegments();
        if (pathSegments.size() != 2 || !StringUtil.a((String) pathSegments.get(0), "events")) {
            return null;
        }
        return this.f6616a.m6910a(StringFormatUtil.formatStrLocaleSafe(FBLinks.t, (String) pathSegments.get(1)));
    }
}
