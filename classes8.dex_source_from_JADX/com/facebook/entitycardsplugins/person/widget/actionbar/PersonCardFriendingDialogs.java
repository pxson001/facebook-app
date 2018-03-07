package com.facebook.entitycardsplugins.person.widget.actionbar;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.util.StringLocaleUtil;
import com.facebook.fbui.dialog.AlertDialog.Builder;
import com.facebook.friends.constants.FriendRequestResponse;
import com.facebook.tools.dextr.runtime.detour.FutureDetour;
import com.facebook.ui.dialogs.ActionSheetDialogBuilder;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.SettableFuture;
import java.util.concurrent.CancellationException;
import javax.inject.Singleton;

@Singleton
/* compiled from: heisman_open_pivot */
public class PersonCardFriendingDialogs {
    private static volatile PersonCardFriendingDialogs f11364a;

    public static com.facebook.entitycardsplugins.person.widget.actionbar.PersonCardFriendingDialogs m13287a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Can't find immediate dominator for block B:24:0x003a in {17, 19, 21, 23, 26, 28} preds:[]
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.computeDominators(BlockProcessor.java:129)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.processBlocksTree(BlockProcessor.java:48)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.rerun(BlockProcessor.java:44)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.visit(BlockFinallyExtract.java:57)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r0 = f11364a;
        if (r0 != 0) goto L_0x0031;
    L_0x0004:
        r1 = com.facebook.entitycardsplugins.person.widget.actionbar.PersonCardFriendingDialogs.class;
        monitor-enter(r1);
        r0 = f11364a;	 Catch:{ all -> 0x0039 }
        if (r0 != 0) goto L_0x0030;	 Catch:{ all -> 0x0039 }
    L_0x000b:
        if (r5 == 0) goto L_0x0030;	 Catch:{ all -> 0x0039 }
    L_0x000d:
        r2 = com.facebook.inject.ScopeSet.a();	 Catch:{ all -> 0x0039 }
        r3 = r2.b();	 Catch:{ all -> 0x0039 }
        r0 = com.facebook.inject.SingletonScope.class;	 Catch:{ all -> 0x0039 }
        r0 = r5.getInstance(r0);	 Catch:{ all -> 0x0039 }
        r0 = (com.facebook.inject.SingletonScope) r0;	 Catch:{ all -> 0x0039 }
        r4 = r0.enterScope();	 Catch:{ all -> 0x0039 }
        r5.getApplicationInjector();	 Catch:{ all -> 0x0034 }
        r0 = m13286a();	 Catch:{ all -> 0x0034 }
        f11364a = r0;	 Catch:{ all -> 0x0034 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0030:
        monitor-exit(r1);	 Catch:{  }
    L_0x0031:
        r0 = f11364a;
        return r0;
    L_0x0034:
        r0 = move-exception;
        com.facebook.inject.SingletonScope.a(r4);	 Catch:{ all -> 0x0034 }
        throw r0;	 Catch:{ all -> 0x0034 }
    L_0x0039:
        r0 = move-exception;
        r2.c(r3);	 Catch:{ all -> 0x0039 }
        throw r0;	 Catch:{ all -> 0x0039 }
    L_0x003e:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x0039 }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.entitycardsplugins.person.widget.actionbar.PersonCardFriendingDialogs.a(com.facebook.inject.InjectorLike):com.facebook.entitycardsplugins.person.widget.actionbar.PersonCardFriendingDialogs");
    }

    private static PersonCardFriendingDialogs m13286a() {
        return new PersonCardFriendingDialogs();
    }

    public final ListenableFuture<Void> m13290a(Context context, String str) {
        return m13288c(context, StringLocaleUtil.a(context.getResources().getString(2131233233), new Object[]{str}));
    }

    public final ListenableFuture<Void> m13291b(Context context, String str) {
        return m13288c(context, StringFormatUtil.formatStrLocaleSafe(context.getResources().getString(2131233241), str));
    }

    public final ListenableFuture<FriendRequestResponse> m13289a(Context context) {
        final SettableFuture f = SettableFuture.f();
        new ActionSheetDialogBuilder(context).a(context.getString(2131233218), new OnClickListener(this) {
            final /* synthetic */ PersonCardFriendingDialogs f11359b;

            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
                FutureDetour.a(f, FriendRequestResponse.CONFIRM, -673363892);
            }
        }).a(context.getString(2131233217), new OnClickListener(this) {
            final /* synthetic */ PersonCardFriendingDialogs f11357b;

            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
                FutureDetour.a(f, FriendRequestResponse.REJECT, 835090522);
            }
        }).a(context.getString(2131230727), new OnClickListener(this) {
            final /* synthetic */ PersonCardFriendingDialogs f11355b;

            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
                f.a(new CancellationException());
            }
        }).show();
        return f;
    }

    private ListenableFuture<Void> m13288c(Context context, String str) {
        final SettableFuture f = SettableFuture.f();
        new Builder(context).b(str).a(2131230729, new OnClickListener(this) {
            final /* synthetic */ PersonCardFriendingDialogs f11363b;

            public void onClick(DialogInterface dialogInterface, int i) {
                FutureDetour.a(f, null, -1681321496);
            }
        }).b(2131230727, new OnClickListener(this) {
            final /* synthetic */ PersonCardFriendingDialogs f11361b;

            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
                f.a(new CancellationException());
            }
        }).a(true).b();
        return f;
    }
}
