package com.facebook.ipc.notifications;

import android.content.Context;
import android.os.Handler;
import com.facebook.common.build.SignatureType;
import com.facebook.content.FacebookOnlyIntentActionFactory;
import com.facebook.inject.ForAppContext;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: method/voicechat.discoverturn */
public class GraphQLNotificationsCrossProcessContract {
    private static final Class<?> f7793a = GraphQLNotificationsCrossProcessContract.class;
    public final Context f7794b;
    private final Provider<String> f7795c;
    public final String f7796d;
    public final String f7797e;
    private final Handler f7798f;

    @Inject
    public GraphQLNotificationsCrossProcessContract(@ForAppContext Context context, Provider<String> provider, SignatureType signatureType, FacebookOnlyIntentActionFactory facebookOnlyIntentActionFactory, Handler handler) {
        this.f7794b = context;
        this.f7795c = provider;
        this.f7796d = signatureType.getPermission();
        this.f7797e = facebookOnlyIntentActionFactory.a("notification.ACTION_UPDATE");
        this.f7798f = handler;
    }
}
