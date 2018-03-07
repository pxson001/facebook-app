package com.facebook.deeplinking.handler;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.facebook.common.fblinks.FBLinks;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.util.StringUtil;
import com.facebook.deeplinking.DeepLinkingUtils;
import javax.inject.Inject;

/* compiled from: phone_number_changed */
public class PhotoDeepLinkHandler implements DeepLinkHandler {
    private final DeepLinkingUtils f6627a;

    @Inject
    public PhotoDeepLinkHandler(DeepLinkingUtils deepLinkingUtils) {
        this.f6627a = deepLinkingUtils;
    }

    public final Intent mo269a(Context context, Uri uri) {
        if (StringUtil.a(uri.getPath(), "/photo.php")) {
            String queryParameter = uri.getQueryParameter("fbid");
            if (!StringUtil.a(new CharSequence[]{queryParameter, uri.getQueryParameter("set")})) {
                return this.f6627a.m6910a(StringFormatUtil.formatStrLocaleSafe(FBLinks.bl, queryParameter, uri.getQueryParameter("set")));
            } else if (queryParameter != null) {
                return this.f6627a.m6910a(StringFormatUtil.formatStrLocaleSafe(FBLinks.bk, queryParameter));
            }
        }
        return null;
    }
}
