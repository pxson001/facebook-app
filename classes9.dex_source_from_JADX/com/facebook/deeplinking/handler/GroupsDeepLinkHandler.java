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

/* compiled from: photoFbIds */
public class GroupsDeepLinkHandler implements DeepLinkHandler {
    private final DeepLinkingUtils f6618a;

    @Inject
    public GroupsDeepLinkHandler(DeepLinkingUtils deepLinkingUtils) {
        this.f6618a = deepLinkingUtils;
    }

    public final Intent mo269a(Context context, Uri uri) {
        List pathSegments = uri.getPathSegments();
        if (pathSegments.size() != 2 || !StringUtil.a((String) pathSegments.get(0), "groups")) {
            return null;
        }
        return this.f6618a.m6910a(StringFormatUtil.formatStrLocaleSafe(FBLinks.u, (String) pathSegments.get(1)));
    }
}
