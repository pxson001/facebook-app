package com.facebook.messaging.threadview.util;

import android.content.Context;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.inject.InjectorLike;
import com.facebook.katana.orca.FbandroidMessagingIntentUris;
import com.facebook.messages.ipc.MessagingIntentUris;
import com.facebook.messaging.chatheads.intents.ChatHeadsIntentDispatcher;
import javax.inject.Inject;

/* compiled from: com.facebook.FacebookSdk */
public class ThreadViewOpenHelper {
    public final Context f17849a;
    public final SecureContextHelper f17850b;
    public final MessagingIntentUris f17851c;
    public final ChatHeadsIntentDispatcher f17852d;

    public static ThreadViewOpenHelper m17845b(InjectorLike injectorLike) {
        return new ThreadViewOpenHelper((Context) injectorLike.getInstance(Context.class), (SecureContextHelper) DefaultSecureContextHelper.a(injectorLike), (MessagingIntentUris) FbandroidMessagingIntentUris.a(injectorLike), ChatHeadsIntentDispatcher.a(injectorLike));
    }

    @Inject
    public ThreadViewOpenHelper(Context context, SecureContextHelper secureContextHelper, MessagingIntentUris messagingIntentUris, ChatHeadsIntentDispatcher chatHeadsIntentDispatcher) {
        this.f17849a = context;
        this.f17850b = secureContextHelper;
        this.f17851c = messagingIntentUris;
        this.f17852d = chatHeadsIntentDispatcher;
    }
}
