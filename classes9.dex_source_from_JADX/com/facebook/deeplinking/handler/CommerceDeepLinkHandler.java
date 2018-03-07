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

/* compiled from: photoObjectsParam */
public class CommerceDeepLinkHandler implements DeepLinkHandler {
    private final DeepLinkingUtils f6615a;

    @Inject
    public CommerceDeepLinkHandler(DeepLinkingUtils deepLinkingUtils) {
        this.f6615a = deepLinkingUtils;
    }

    public final Intent mo269a(Context context, Uri uri) {
        List pathSegments = uri.getPathSegments();
        if (pathSegments.size() != 3 || !StringUtil.a((String) pathSegments.get(0), "commerce") || !StringUtil.a((String) pathSegments.get(1), "products")) {
            return null;
        }
        return this.f6615a.m6910a(StringFormatUtil.formatStrLocaleSafe(FBLinks.eA, (String) pathSegments.get(2)));
    }
}
