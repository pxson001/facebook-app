package com.facebook.deeplinking.handler;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.facebook.common.fblinks.FBLinks;
import com.facebook.common.util.StringUtil;
import com.facebook.deeplinking.DeepLinkingUtils;
import javax.inject.Inject;

/* compiled from: photoFromTimeline */
public class FeedDeepLinkHandler implements DeepLinkHandler {
    private final DeepLinkingUtils f6617a;

    @Inject
    public FeedDeepLinkHandler(DeepLinkingUtils deepLinkingUtils) {
        this.f6617a = deepLinkingUtils;
    }

    public final Intent mo269a(Context context, Uri uri) {
        if (StringUtil.a(uri.getPath(), "/") || StringUtil.a(uri.getPath(), "/home.php")) {
            return this.f6617a.m6910a(FBLinks.bT);
        }
        return null;
    }
}
