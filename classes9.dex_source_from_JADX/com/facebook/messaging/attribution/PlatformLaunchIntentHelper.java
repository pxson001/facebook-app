package com.facebook.messaging.attribution;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.model.threadkey.ThreadKey;
import com.google.common.base.Strings;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: outbox */
public class PlatformLaunchIntentHelper {
    public final Context f7907a;
    private final ReplyTokenHelper f7908b;

    /* compiled from: outbox */
    public enum Origin {
        COMPOSE_FLOW,
        REPLY_FLOW
    }

    public static PlatformLaunchIntentHelper m8114a(InjectorLike injectorLike) {
        return new PlatformLaunchIntentHelper((Context) injectorLike.getInstance(Context.class), ReplyTokenHelper.m8124a(injectorLike));
    }

    @Inject
    public PlatformLaunchIntentHelper(Context context, ReplyTokenHelper replyTokenHelper) {
        this.f7907a = context;
        this.f7908b = replyTokenHelper;
    }

    public final Intent m8116a(@Nullable ThreadKey threadKey, String str, String str2, String str3, String str4) {
        Intent a = m8113a(str2, str3, str4);
        a.addCategory("com.facebook.orca.category.PLATFORM_REPLY_20141218");
        Bundle bundle = a.getBundleExtra("al_applink_data").getBundle("extras");
        bundle.putBoolean("com.facebook.orca.extra.IS_REPLY", true);
        bundle.putString("com.facebook.orca.extra.REPLY_TOKEN", this.f7908b.m8130a(threadKey, str, str2));
        return a;
    }

    public final Intent m8115a(Origin origin, @Nullable ThreadKey threadKey, String str, String str2, String str3, String str4) {
        Intent a = m8113a(str2, str3, str4);
        a.addCategory("com.facebook.orca.category.PLATFORM_THREAD_20150311");
        Bundle bundle = a.getBundleExtra("al_applink_data").getBundle("extras");
        switch (origin) {
            case REPLY_FLOW:
                bundle.putBoolean("com.facebook.orca.extra.IS_REPLY", true);
                break;
            case COMPOSE_FLOW:
                bundle.putBoolean("com.facebook.orca.extra.IS_COMPOSE", true);
                break;
        }
        bundle.putString("com.facebook.orca.extra.THREAD_TOKEN", this.f7908b.m8130a(threadKey, str, str2));
        return a;
    }

    public final Intent m8117b(Origin origin, @Nullable ThreadKey threadKey, String str, String str2, String str3, String str4) {
        Intent a = m8113a(str2, str3, str4);
        a.addCategory("com.facebook.orca.category.PLATFORM_THREAD_20150314");
        Bundle bundle = a.getBundleExtra("al_applink_data").getBundle("extras");
        switch (origin) {
            case REPLY_FLOW:
                bundle.putBoolean("com.facebook.orca.extra.IS_REPLY", true);
                break;
            case COMPOSE_FLOW:
                bundle.putBoolean("com.facebook.orca.extra.IS_COMPOSE", true);
                break;
        }
        bundle.putString("com.facebook.orca.extra.THREAD_TOKEN", this.f7908b.m8130a(threadKey, str, str2));
        return a;
    }

    private static Intent m8113a(String str, String str2, String str3) {
        Intent intent = new Intent("android.intent.action.PICK", null);
        intent.addCategory("android.intent.category.DEFAULT");
        intent.setPackage(str);
        Bundle bundle = new Bundle();
        intent.putExtra("al_applink_data", bundle);
        Bundle bundle2 = new Bundle();
        bundle.putBundle("extras", bundle2);
        if (!Strings.isNullOrEmpty(str2)) {
            bundle2.putString("com.facebook.orca.extra.METADATA", str2);
        }
        if (!Strings.isNullOrEmpty(str3)) {
            bundle2.putString("com.facebook.orca.extra.PARTICIPANTS", str3);
        }
        return intent;
    }
}
