package com.facebook.messaging.actionlinks;

import android.content.Intent;
import android.net.Uri;
import com.facebook.common.android.FbLocalBroadcastManager;
import com.facebook.common.android.FbLocalBroadcastManagerMethodAutoProvider;
import com.facebook.common.build.BuildConstants;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.intents.MessagesBroadcastIntents;
import com.facebook.messaging.model.threadkey.DefaultThreadKeyFactory;
import com.facebook.messaging.model.threadkey.ThreadKey;
import javax.inject.Inject;

/* compiled from: trending_awareness */
public class AutoComposeBroadcastActionLinkHandler implements ActionLinkHandler {
    private final FbLocalBroadcastManager f1426a;
    public final DefaultThreadKeyFactory f1427b;

    public static AutoComposeBroadcastActionLinkHandler m1580b(InjectorLike injectorLike) {
        return new AutoComposeBroadcastActionLinkHandler(FbLocalBroadcastManagerMethodAutoProvider.a(injectorLike), DefaultThreadKeyFactory.b(injectorLike));
    }

    @Inject
    public AutoComposeBroadcastActionLinkHandler(FbLocalBroadcastManager fbLocalBroadcastManager, DefaultThreadKeyFactory defaultThreadKeyFactory) {
        this.f1426a = fbLocalBroadcastManager;
        this.f1427b = defaultThreadKeyFactory;
    }

    public final boolean mo64a(Uri uri) {
        if (!BuildConstants.b.equals(uri.getScheme()) && !BuildConstants.c.equals(uri.getScheme())) {
            return false;
        }
        if (!"autocompose".equals(uri.getAuthority()) && !"compose".equals(uri.getAuthority())) {
            return false;
        }
        String format;
        boolean z;
        String queryParameter = uri.getQueryParameter("tid");
        String queryParameter2 = uri.getQueryParameter("ttype");
        if (queryParameter != null && queryParameter2 != null) {
            int i = -1;
            switch (queryParameter2.hashCode()) {
                case 49:
                    if (queryParameter2.equals("1")) {
                        i = 0;
                        break;
                    }
                    break;
                case 50:
                    if (queryParameter2.equals("2")) {
                        i = 1;
                        break;
                    }
                    break;
            }
            ThreadKey a;
            switch (i) {
                case 0:
                    a = this.f1427b.a(Long.parseLong(queryParameter));
                    format = String.format(MessagesBroadcastIntents.w, new Object[]{a});
                    break;
                case 1:
                    a = ThreadKey.a(Long.parseLong(queryParameter));
                    format = String.format(MessagesBroadcastIntents.w, new Object[]{a});
                    break;
                default:
                    format = MessagesBroadcastIntents.v;
                    break;
            }
        }
        format = MessagesBroadcastIntents.v;
        Intent intent = new Intent(format);
        String str = "send";
        format = uri.getQueryParameter("s");
        if (format == null || format.equals("0")) {
            z = false;
        } else {
            z = true;
        }
        intent.putExtra(str, z);
        str = "text";
        format = uri.getQueryParameter("m");
        if (format == null) {
            format = "";
        } else {
            format = Uri.decode(format);
        }
        intent.putExtra(str, format);
        return this.f1426a.a(intent);
    }
}
