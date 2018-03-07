package com.facebook.messaging.business.common.calltoaction;

import android.content.Context;
import android.net.Uri;
import com.facebook.messaging.model.threadkey.ThreadKey;
import javax.annotation.Nullable;

/* compiled from: newSenderStatus */
public abstract class BusinessUriHandler {
    public abstract boolean mo329a(Context context, Uri uri, @Nullable ThreadKey threadKey);

    public abstract String mo330b();

    public String m8913a() {
        return "business";
    }
}
