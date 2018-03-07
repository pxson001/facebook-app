package com.facebook.messages.ipc;

import android.content.Intent;
import android.net.Uri;
import com.facebook.common.build.BuildConstants;
import com.facebook.messaging.model.threadkey.ThreadKey;

/* compiled from: shape */
public interface MessagingIntentUris {
    public static final String f2255a = (BuildConstants.e + ".notify.SECURE_VIEW");
    public static final String f2256b = (BuildConstants.e + ".notify.ACTION_LIKE");

    Uri mo164a();

    Uri mo165a(long j);

    Uri mo166a(ThreadKey threadKey);

    Uri mo167a(String str);

    Intent mo163b(ThreadKey threadKey);
}
