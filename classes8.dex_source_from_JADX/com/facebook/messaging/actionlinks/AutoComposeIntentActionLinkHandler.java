package com.facebook.messaging.actionlinks;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.facebook.common.build.BuildConstants;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.inject.InjectorLike;
import com.facebook.messages.ipc.MessagingIntentUris;
import javax.inject.Inject;

/* compiled from: tracks */
public class AutoComposeIntentActionLinkHandler implements ActionLinkHandler {
    private final Context f1428a;
    private final SecureContextHelper f1429b;

    public static AutoComposeIntentActionLinkHandler m1582b(InjectorLike injectorLike) {
        return new AutoComposeIntentActionLinkHandler((Context) injectorLike.getInstance(Context.class), (SecureContextHelper) DefaultSecureContextHelper.a(injectorLike));
    }

    @Inject
    public AutoComposeIntentActionLinkHandler(Context context, SecureContextHelper secureContextHelper) {
        this.f1428a = context;
        this.f1429b = secureContextHelper;
    }

    public final boolean mo64a(Uri uri) {
        if (!BuildConstants.b.equals(uri.getScheme()) || !"compose".equals(uri.getAuthority())) {
            return false;
        }
        this.f1429b.a(new Intent(MessagingIntentUris.a, uri.buildUpon().authority("autocompose").build()), this.f1428a);
        return true;
    }
}
