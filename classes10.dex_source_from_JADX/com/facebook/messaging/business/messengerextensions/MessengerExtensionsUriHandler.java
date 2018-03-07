package com.facebook.messaging.business.messengerextensions;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.content.SecureContextHelper;
import com.facebook.messages.links.MessengerLinks;
import com.facebook.messaging.business.common.calltoaction.BusinessUriHandler;
import com.facebook.messaging.model.threadkey.ThreadKey;
import com.google.common.base.Strings;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: threadViewLoader.serviceException.errorCode */
public class MessengerExtensionsUriHandler extends BusinessUriHandler {
    private final MessengerExtensionsManager f1656a;
    private final SecureContextHelper f1657b;

    @Inject
    public MessengerExtensionsUriHandler(MessengerExtensionsManager messengerExtensionsManager, SecureContextHelper secureContextHelper) {
        this.f1656a = messengerExtensionsManager;
        this.f1657b = secureContextHelper;
    }

    public final String m1601a() {
        return "business_extensions";
    }

    public final boolean m1602a(Context context, Uri uri, @Nullable ThreadKey threadKey) {
        int i = (uri.getAuthority() == null || !uri.getAuthority().equals("business_extensions") || uri.getPathSegments() == null || uri.getPathSegments().size() != 1 || Strings.isNullOrEmpty((String) uri.getPathSegments().get(0))) ? 0 : 1;
        if (i == 0) {
            return false;
        }
        String queryParameter = uri.getQueryParameter("extension_uri");
        if (Strings.isNullOrEmpty(queryParameter)) {
            return false;
        }
        if (threadKey != null) {
            return this.f1656a.m1596a(context, queryParameter, threadKey);
        }
        String str = (String) uri.getPathSegments().get(0);
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(Uri.parse(StringFormatUtil.formatStrLocaleSafe(MessengerLinks.w, String.valueOf(str))));
        intent.putExtra("business_extension_uri", queryParameter);
        this.f1657b.a(intent, context);
        return true;
    }

    public final String m1603b() {
        return "*";
    }
}
