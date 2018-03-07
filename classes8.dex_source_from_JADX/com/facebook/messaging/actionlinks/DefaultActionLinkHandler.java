package com.facebook.messaging.actionlinks;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.inject.InjectorLike;
import com.facebook.messages.ipc.MessagingIntentUris;
import javax.inject.Inject;

/* compiled from: trackingcode_item */
public class DefaultActionLinkHandler implements ActionLinkHandler {
    private final Context f1431a;
    private final SecureContextHelper f1432b;

    public static DefaultActionLinkHandler m1585b(InjectorLike injectorLike) {
        return new DefaultActionLinkHandler((Context) injectorLike.getInstance(Context.class), (SecureContextHelper) DefaultSecureContextHelper.a(injectorLike));
    }

    @Inject
    public DefaultActionLinkHandler(Context context, SecureContextHelper secureContextHelper) {
        this.f1431a = context;
        this.f1432b = secureContextHelper;
    }

    public final boolean mo64a(Uri uri) {
        this.f1432b.a(new Intent(MessagingIntentUris.a, uri), this.f1431a);
        return true;
    }
}
