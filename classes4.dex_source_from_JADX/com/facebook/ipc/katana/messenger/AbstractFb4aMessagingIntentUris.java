package com.facebook.ipc.katana.messenger;

import android.net.Uri;
import com.facebook.common.fblinks.FBLinks;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.messages.ipc.MessagingIntentUris;
import com.facebook.messaging.model.threadkey.ThreadKey;
import com.facebook.messaging.model.threadkey.ThreadKey.Type;

/* compiled from: share_menu_packages */
public abstract class AbstractFb4aMessagingIntentUris implements MessagingIntentUris {
    public final Uri mo164a() {
        return Uri.parse(FBLinks.O);
    }

    public final Uri mo166a(ThreadKey threadKey) {
        if (threadKey.a == Type.ONE_TO_ONE) {
            return mo167a(Long.toString(threadKey.d));
        }
        if (threadKey.a == Type.GROUP) {
            return mo165a(threadKey.b);
        }
        return mo164a();
    }

    public final Uri mo167a(String str) {
        return Uri.parse(StringFormatUtil.formatStrLocaleSafe(FBLinks.V, Uri.encode(str)));
    }

    public final Uri mo165a(long j) {
        return Uri.parse(StringFormatUtil.formatStrLocaleSafe(FBLinks.X, Uri.encode(Long.toString(j))));
    }
}
