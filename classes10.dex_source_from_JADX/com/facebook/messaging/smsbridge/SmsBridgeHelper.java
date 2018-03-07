package com.facebook.messaging.smsbridge;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.facebook.fbui.dialog.AlertDialog;
import com.facebook.inject.InjectorLike;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferences.Editor;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.prefs.shared.PrefKey;
import com.facebook.ui.dialogs.FbAlertDialogBuilder;
import com.facebook.user.model.User;
import com.google.common.collect.ImmutableList;
import java.util.HashSet;
import java.util.Set;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: publisher_callback */
public class SmsBridgeHelper {
    private static volatile SmsBridgeHelper f4257c;
    public final FbSharedPreferences f4258a;
    private final SmsBridgeDialogs f4259b;

    /* compiled from: publisher_callback */
    public class C06411 implements OnClickListener {
        final /* synthetic */ PrefKey f4251a;
        final /* synthetic */ Runnable f4252b;
        final /* synthetic */ SmsBridgeHelper f4253c;

        public C06411(SmsBridgeHelper smsBridgeHelper, PrefKey prefKey, Runnable runnable) {
            this.f4253c = smsBridgeHelper;
            this.f4251a = prefKey;
            this.f4252b = runnable;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            this.f4253c.f4258a.edit().putBoolean(this.f4251a, true).commit();
            this.f4252b.run();
        }
    }

    public static com.facebook.messaging.smsbridge.SmsBridgeHelper m3878a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f4257c;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.messaging.smsbridge.SmsBridgeHelper.class;
        monitor-enter(r1);
        r0 = f4257c;	 Catch:{ all -> 0x003a }
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
        r0 = m3879b(r0);	 Catch:{ all -> 0x0035 }
        f4257c = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f4257c;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.smsbridge.SmsBridgeHelper.a(com.facebook.inject.InjectorLike):com.facebook.messaging.smsbridge.SmsBridgeHelper");
    }

    private static SmsBridgeHelper m3879b(InjectorLike injectorLike) {
        return new SmsBridgeHelper((FbSharedPreferences) FbSharedPreferencesImpl.a(injectorLike), SmsBridgeDialogs.m3877a(injectorLike));
    }

    @Inject
    public SmsBridgeHelper(FbSharedPreferences fbSharedPreferences, SmsBridgeDialogs smsBridgeDialogs) {
        this.f4258a = fbSharedPreferences;
        this.f4259b = smsBridgeDialogs;
    }

    public final void m3880a(Context context, ImmutableList<User> immutableList, final Runnable runnable) {
        final Set hashSet = new HashSet();
        int size = immutableList.size();
        for (int i = 0; i < size; i++) {
            PrefKey a = SmsBridgePrefKeys.m3881a((User) immutableList.get(i));
            if (!this.f4258a.a(a, false)) {
                hashSet.add(a);
            }
        }
        if (hashSet.isEmpty()) {
            runnable.run();
            return;
        }
        int size2 = immutableList.size();
        AlertDialog b = new FbAlertDialogBuilder(context).a(2131241329).b(context.getString(2131241331, new Object[]{Integer.valueOf(size2)})).a(context.getString(2131230726), new OnClickListener(this) {
            final /* synthetic */ SmsBridgeHelper f4256c;

            public void onClick(DialogInterface dialogInterface, int i) {
                Editor edit = this.f4256c.f4258a.edit();
                for (PrefKey putBoolean : hashSet) {
                    edit.putBoolean(putBoolean, true);
                }
                edit.commit();
                runnable.run();
            }
        }).b();
    }
}
