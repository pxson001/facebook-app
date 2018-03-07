package com.facebook.deeplinking.handler;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.facebook.common.fblinks.FBLinks;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.util.StringUtil;
import com.facebook.deeplinking.DeepLinkingUtils;
import javax.inject.Inject;

/* compiled from: phoneAppPayload */
public class VideoDeepLinkHandler implements DeepLinkHandler {
    private final DeepLinkingUtils f6629a;

    @Inject
    public VideoDeepLinkHandler(DeepLinkingUtils deepLinkingUtils) {
        this.f6629a = deepLinkingUtils;
    }

    public final Intent mo269a(Context context, Uri uri) {
        if (!StringUtil.a(uri.getPath(), "/video.php")) {
            return null;
        }
        return this.f6629a.m6910a(StringFormatUtil.formatStrLocaleSafe(FBLinks.dH, uri.getQueryParameter("v")));
    }
}
