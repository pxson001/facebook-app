package com.facebook.messaging.actionlinks;

import android.content.Intent;
import android.net.Uri;
import com.facebook.common.android.FbLocalBroadcastManager;
import com.facebook.common.android.FbLocalBroadcastManagerMethodAutoProvider;
import com.facebook.common.build.BuildConstants;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.intents.MessagesBroadcastIntents;
import javax.inject.Inject;

/* compiled from: tracking_id */
public class KeyboardBroadcastActionLinkHandler implements ActionLinkHandler {
    private final FbLocalBroadcastManager f1433a;

    public static KeyboardBroadcastActionLinkHandler m1587b(InjectorLike injectorLike) {
        return new KeyboardBroadcastActionLinkHandler(FbLocalBroadcastManagerMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public KeyboardBroadcastActionLinkHandler(FbLocalBroadcastManager fbLocalBroadcastManager) {
        this.f1433a = fbLocalBroadcastManager;
    }

    public final boolean mo64a(Uri uri) {
        if ((!BuildConstants.b.equals(uri.getScheme()) && !BuildConstants.c.equals(uri.getScheme())) || !"keyboard".equals(uri.getAuthority())) {
            return false;
        }
        String queryParameter = uri.getQueryParameter("m");
        queryParameter = queryParameter == null ? "" : Uri.decode(queryParameter);
        Intent intent = new Intent(MessagesBroadcastIntents.x);
        intent.putExtra("keyboard_mode", queryParameter);
        return this.f1433a.a(intent);
    }
}
