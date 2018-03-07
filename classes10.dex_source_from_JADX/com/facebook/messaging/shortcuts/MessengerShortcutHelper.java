package com.facebook.messaging.shortcuts;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Vibrator;
import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.auth.userscope.UserScoped;
import com.facebook.common.android.VibratorMethodAutoProvider;
import com.facebook.common.shortcuts.InstallShortcutHelper;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.katana.orca.FbandroidMessagingIntentUris;
import com.facebook.messages.ipc.MessagingIntentUris;
import com.facebook.messaging.model.threadkey.ThreadKey;
import com.facebook.messaging.model.threadkey.ThreadKey.Type;
import com.facebook.messaging.model.threads.ThreadSummary;
import com.facebook.messaging.photos.tiles.MessengerThreadTileViewDataFactory;
import com.facebook.messaging.ui.name.MessengerThreadNameViewDataFactory;
import com.facebook.messaging.ui.name.ThreadNameViewComputer;
import com.facebook.messaging.ui.name.ThreadNameViewComputer_DefaultThreadNameViewComputerMethodAutoProvider;
import com.facebook.resources.FbResources;
import com.facebook.resources.impl.DownloadedFbResources;
import com.facebook.widget.tiles.ThreadTileDrawable;
import com.facebook.widget.tiles.ThreadTileDrawable.DrawableShape;
import com.facebook.widget.tiles.ThreadTileDrawableController;
import com.facebook.widget.tiles.ThreadTileViewData;
import com.google.common.base.Preconditions;
import javax.inject.Inject;
import javax.inject.Provider;

@UserScoped
/* compiled from: qrcode_scanner_rendered */
public class MessengerShortcutHelper {
    private static final Object f4062m = new Object();
    private final Context f4063a;
    public final Resources f4064b;
    public final AnalyticsLogger f4065c;
    public final MessengerThreadNameViewDataFactory f4066d;
    private final MessengerThreadTileViewDataFactory f4067e;
    public final MessagingIntentUris f4068f;
    public final InstallShortcutHelper f4069g;
    public final ThreadNameViewComputer f4070h;
    public final ComponentName f4071i;
    public final Vibrator f4072j;
    private final Provider<ThreadTileDrawableController> f4073k;
    private final Provider<String> f4074l;

    private static MessengerShortcutHelper m3757b(InjectorLike injectorLike) {
        return new MessengerShortcutHelper((Context) injectorLike.getInstance(Context.class), (FbResources) DownloadedFbResources.a(injectorLike), AnalyticsLoggerMethodAutoProvider.a(injectorLike), MessengerThreadNameViewDataFactory.a(injectorLike), MessengerThreadTileViewDataFactory.a(injectorLike), (MessagingIntentUris) FbandroidMessagingIntentUris.a(injectorLike), InstallShortcutHelper.b(injectorLike), ThreadNameViewComputer_DefaultThreadNameViewComputerMethodAutoProvider.b(injectorLike), ComponentName_ForIntentHandlerActivityMethodAutoProvider.m3753b(injectorLike), VibratorMethodAutoProvider.b(injectorLike), IdBasedProvider.a(injectorLike, 11765), IdBasedProvider.a(injectorLike, 4442));
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.facebook.messaging.shortcuts.MessengerShortcutHelper m3754a(com.facebook.inject.InjectorLike r7) {
        /*
        r2 = com.facebook.inject.ScopeSet.a();
        r0 = com.facebook.auth.userscope.UserScope.class;
        r0 = r7.getInstance(r0);
        r0 = (com.facebook.auth.userscope.UserScope) r0;
        r1 = r7.getScopeAwareInjector();
        r1 = r1.b();
        if (r1 != 0) goto L_0x001e;
    L_0x0016:
        r0 = new com.facebook.inject.ProvisioningException;
        r1 = "Called user scoped provider outside of context scope";
        r0.<init>(r1);
        throw r0;
    L_0x001e:
        r3 = r0.a(r1);
        r4 = r3.b();	 Catch:{ all -> 0x006c }
        r1 = f4062m;	 Catch:{ all -> 0x006c }
        r1 = r4.get(r1);	 Catch:{ all -> 0x006c }
        r5 = com.facebook.auth.userscope.UserScope.a;	 Catch:{ all -> 0x006c }
        if (r1 != r5) goto L_0x0035;
    L_0x0030:
        r3.c();
        r0 = 0;
    L_0x0034:
        return r0;
    L_0x0035:
        if (r1 != 0) goto L_0x007c;
    L_0x0037:
        r1 = 4;
        r5 = r2.b(r1);	 Catch:{  }
        r6 = r0.a(r3);	 Catch:{ all -> 0x0067 }
        r0 = r6.e();	 Catch:{ all -> 0x0062 }
        r1 = m3757b(r0);	 Catch:{ all -> 0x0062 }
        com.facebook.auth.userscope.UserScope.a(r6);	 Catch:{  }
        if (r1 != 0) goto L_0x0071;
    L_0x004d:
        r0 = f4062m;	 Catch:{  }
        r6 = com.facebook.auth.userscope.UserScope.a;	 Catch:{  }
        r0 = r4.putIfAbsent(r0, r6);	 Catch:{  }
        r0 = (com.facebook.messaging.shortcuts.MessengerShortcutHelper) r0;	 Catch:{  }
    L_0x0057:
        if (r0 == 0) goto L_0x007a;
    L_0x0059:
        r2.c(r5);	 Catch:{  }
    L_0x005c:
        r0 = (com.facebook.messaging.shortcuts.MessengerShortcutHelper) r0;	 Catch:{  }
        r3.c();
        goto L_0x0034;
    L_0x0062:
        r0 = move-exception;
        com.facebook.auth.userscope.UserScope.a(r6);	 Catch:{  }
        throw r0;	 Catch:{  }
    L_0x0067:
        r0 = move-exception;
        r2.c(r5);	 Catch:{  }
        throw r0;	 Catch:{  }
    L_0x006c:
        r0 = move-exception;
        r3.c();
        throw r0;
    L_0x0071:
        r0 = f4062m;	 Catch:{  }
        r0 = r4.putIfAbsent(r0, r1);	 Catch:{  }
        r0 = (com.facebook.messaging.shortcuts.MessengerShortcutHelper) r0;	 Catch:{  }
        goto L_0x0057;
    L_0x007a:
        r0 = r1;
        goto L_0x0059;
    L_0x007c:
        r0 = r1;
        goto L_0x005c;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.shortcuts.MessengerShortcutHelper.a(com.facebook.inject.InjectorLike):com.facebook.messaging.shortcuts.MessengerShortcutHelper");
    }

    @Inject
    public MessengerShortcutHelper(Context context, FbResources fbResources, AnalyticsLogger analyticsLogger, MessengerThreadNameViewDataFactory messengerThreadNameViewDataFactory, MessengerThreadTileViewDataFactory messengerThreadTileViewDataFactory, MessagingIntentUris messagingIntentUris, InstallShortcutHelper installShortcutHelper, ThreadNameViewComputer threadNameViewComputer, ComponentName componentName, Vibrator vibrator, Provider<ThreadTileDrawableController> provider, Provider<String> provider2) {
        this.f4063a = context;
        this.f4064b = fbResources;
        this.f4065c = analyticsLogger;
        this.f4066d = messengerThreadNameViewDataFactory;
        this.f4067e = messengerThreadTileViewDataFactory;
        this.f4068f = messagingIntentUris;
        this.f4069g = installShortcutHelper;
        this.f4070h = threadNameViewComputer;
        this.f4071i = componentName;
        this.f4072j = vibrator;
        this.f4073k = provider;
        this.f4074l = provider2;
    }

    private void m3756a(ThreadTileViewData threadTileViewData, ThreadKey threadKey, String str, Intent intent, String str2) {
        final ThreadTileDrawableController a = m3755a();
        final Intent intent2 = intent;
        final String str3 = str;
        final ThreadKey threadKey2 = threadKey;
        final String str4 = str2;
        a.w = new Object(this) {
            public final /* synthetic */ MessengerShortcutHelper f4061f;
        };
        a.a(threadTileViewData);
    }

    public final void m3758a(ThreadSummary threadSummary, String str) {
        Uri a;
        String charSequence = this.f4070h.a(this.f4066d.a(threadSummary), -1).toString();
        ThreadKey threadKey = threadSummary.a;
        Intent intent = new Intent("android.intent.action.MAIN");
        if (threadKey.a == Type.ONE_TO_ONE) {
            a = this.f4068f.a(String.valueOf(threadKey.d));
        } else {
            a = this.f4068f.a(threadKey.b);
        }
        intent.setData(a);
        intent.setComponent(this.f4071i);
        intent.putExtra("from_shortcut", true);
        intent.putExtra("trigger", "shortcut");
        m3756a(this.f4067e.a(threadSummary), threadSummary.a, charSequence, intent, str);
    }

    private ThreadTileDrawableController m3755a() {
        int a = this.f4069g.a();
        ThreadTileDrawableController threadTileDrawableController = (ThreadTileDrawableController) this.f4073k.get();
        threadTileDrawableController.a(this.f4063a, null, 0);
        threadTileDrawableController.u = true;
        ThreadTileDrawable threadTileDrawable = threadTileDrawableController.n;
        boolean z = true;
        boolean z2 = threadTileDrawable.c != DrawableShape.CIRCLE && threadTileDrawable.j == 0;
        Preconditions.checkState(z2);
        if (0.5f <= 0.0f || 0.5f >= 1.0f) {
            z = false;
        }
        Preconditions.checkArgument(z);
        threadTileDrawable.e = 0.5f;
        threadTileDrawableController.n.a();
        threadTileDrawableController.a(a);
        return threadTileDrawableController;
    }
}
