package com.facebook.messaging.chatheads.intents;

import android.content.Context;
import android.support.v4.app.FragmentManager;
import com.facebook.common.launcher.LauncherHelper;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.model.threadkey.ThreadKey;
import com.facebook.runtimepermissions.RuntimePermissionsUtil;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: messenger_pay_theme_list */
public class ChatHeadsOpenHelper {
    private static volatile ChatHeadsOpenHelper f9760f;
    private final ChatHeadsIntentDispatcher f9761a;
    private final Context f9762b;
    private final LauncherHelper f9763c;
    public final RuntimePermissionsUtil f9764d;
    public Runnable f9765e;

    /* compiled from: messenger_pay_theme_list */
    public class C11302 implements Runnable {
        final /* synthetic */ long f9753a;
        final /* synthetic */ String f9754b;
        final /* synthetic */ ChatHeadsOpenHelper f9755c;

        public C11302(ChatHeadsOpenHelper chatHeadsOpenHelper, long j, String str) {
            this.f9755c = chatHeadsOpenHelper;
            this.f9753a = j;
            this.f9754b = str;
        }

        public void run() {
            ChatHeadsOpenHelper.m10334a(this.f9755c, this.f9753a, this.f9754b);
        }
    }

    /* compiled from: messenger_pay_theme_list */
    public class C11313 implements Runnable {
        final /* synthetic */ String f9756a;
        final /* synthetic */ String f9757b;
        final /* synthetic */ String f9758c;
        final /* synthetic */ ChatHeadsOpenHelper f9759d;

        public C11313(ChatHeadsOpenHelper chatHeadsOpenHelper, String str, String str2, String str3) {
            this.f9759d = chatHeadsOpenHelper;
            this.f9756a = str;
            this.f9757b = str2;
            this.f9758c = str3;
        }

        public void run() {
            ChatHeadsOpenHelper.m10336a(this.f9759d, this.f9756a, this.f9757b, this.f9758c);
        }
    }

    public static com.facebook.messaging.chatheads.intents.ChatHeadsOpenHelper m10332a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Can't find immediate dominator for block B:24:0x003b in {17, 19, 21, 23, 26, 28} preds:[]
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.computeDominators(BlockProcessor.java:129)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.processBlocksTree(BlockProcessor.java:48)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.rerun(BlockProcessor.java:44)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.visit(BlockFinallyExtract.java:57)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r0 = f9760f;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.messaging.chatheads.intents.ChatHeadsOpenHelper.class;
        monitor-enter(r1);
        r0 = f9760f;	 Catch:{ all -> 0x003a }
        if (r0 != 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000b:
        if (r5 == 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000d:
        r2 = com.facebook.inject.ScopeSet.a();	 Catch:{ all -> 0x003a }
        r3 = r2.b();	 Catch:{ all -> 0x003a }
        r0 = com.facebook.inject.SingletonScope.class;	 Catch:{ all -> 0x003a }
        r0 = r5.getInstance(r0);	 Catch:{ all -> 0x003a }
        r0 = (com.facebook.inject.SingletonScope) r0;	 Catch:{ all -> 0x003a }
        r4 = r0.enterScope();	 Catch:{ all -> 0x003a }
        r0 = r5.getApplicationInjector();	 Catch:{ all -> 0x0035 }
        r0 = m10337b(r0);	 Catch:{ all -> 0x0035 }
        f9760f = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f9760f;
        return r0;
    L_0x0035:
        r0 = move-exception;
        com.facebook.inject.SingletonScope.a(r4);	 Catch:{ all -> 0x0035 }
        throw r0;	 Catch:{ all -> 0x0035 }
    L_0x003a:
        r0 = move-exception;
        r2.c(r3);	 Catch:{ all -> 0x003a }
        throw r0;	 Catch:{ all -> 0x003a }
    L_0x003f:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x003a }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.chatheads.intents.ChatHeadsOpenHelper.a(com.facebook.inject.InjectorLike):com.facebook.messaging.chatheads.intents.ChatHeadsOpenHelper");
    }

    private static ChatHeadsOpenHelper m10337b(InjectorLike injectorLike) {
        return new ChatHeadsOpenHelper(ChatHeadsIntentDispatcher.a(injectorLike), (Context) injectorLike.getInstance(Context.class), new LauncherHelper((SecureContextHelper) DefaultSecureContextHelper.a(injectorLike)), RuntimePermissionsUtil.b(injectorLike));
    }

    @Inject
    public ChatHeadsOpenHelper(ChatHeadsIntentDispatcher chatHeadsIntentDispatcher, Context context, LauncherHelper launcherHelper, RuntimePermissionsUtil runtimePermissionsUtil) {
        this.f9761a = chatHeadsIntentDispatcher;
        this.f9762b = context;
        this.f9763c = launcherHelper;
        this.f9764d = runtimePermissionsUtil;
    }

    public final void m10338a() {
        if (this.f9764d.a() && this.f9765e != null) {
            this.f9765e.run();
        }
        this.f9765e = null;
    }

    public final void m10339a(final ThreadKey threadKey, FragmentManager fragmentManager, final String str) {
        if (this.f9764d.a()) {
            m10335a(this, threadKey, str);
            return;
        }
        this.f9765e = new Runnable(this) {
            final /* synthetic */ ChatHeadsOpenHelper f9752c;

            public void run() {
                ChatHeadsOpenHelper.m10335a(this.f9752c, threadKey, str);
            }
        };
        m10333a(fragmentManager);
    }

    public static void m10333a(FragmentManager fragmentManager) {
        new ChatHeadsInterstitialNuxFragment().a(fragmentManager, "chat_heads_interstitial_tag");
    }

    public static void m10335a(ChatHeadsOpenHelper chatHeadsOpenHelper, ThreadKey threadKey, String str) {
        chatHeadsOpenHelper.f9763c.m6313a(chatHeadsOpenHelper.f9762b);
        chatHeadsOpenHelper.f9761a.a(threadKey, str);
    }

    public static void m10334a(ChatHeadsOpenHelper chatHeadsOpenHelper, long j, String str) {
        chatHeadsOpenHelper.f9763c.m6313a(chatHeadsOpenHelper.f9762b);
        chatHeadsOpenHelper.f9761a.a(j, str);
    }

    public static void m10336a(ChatHeadsOpenHelper chatHeadsOpenHelper, String str, String str2, String str3) {
        chatHeadsOpenHelper.f9763c.m6313a(chatHeadsOpenHelper.f9762b);
        chatHeadsOpenHelper.f9761a.a(str, str2, str3);
    }
}
