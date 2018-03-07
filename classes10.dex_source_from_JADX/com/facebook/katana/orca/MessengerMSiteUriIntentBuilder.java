package com.facebook.katana.orca;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.facebook.common.fblinks.FBLinks;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.util.FacebookUriUtil;
import com.facebook.inject.InjectorLike;
import com.facebook.katana.util.MSiteUrlUtils;
import java.util.List;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: unfollow_group */
public class MessengerMSiteUriIntentBuilder {
    public static final String f1017a = FBLinks.O;
    private static volatile MessengerMSiteUriIntentBuilder f1018d;
    private final Context f1019b;
    private final MSiteUrlUtils f1020c;

    public static com.facebook.katana.orca.MessengerMSiteUriIntentBuilder m1067a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f1018d;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.katana.orca.MessengerMSiteUriIntentBuilder.class;
        monitor-enter(r1);
        r0 = f1018d;	 Catch:{ all -> 0x003a }
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
        r0 = m1069b(r0);	 Catch:{ all -> 0x0035 }
        f1018d = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f1018d;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.katana.orca.MessengerMSiteUriIntentBuilder.a(com.facebook.inject.InjectorLike):com.facebook.katana.orca.MessengerMSiteUriIntentBuilder");
    }

    private static MessengerMSiteUriIntentBuilder m1069b(InjectorLike injectorLike) {
        return new MessengerMSiteUriIntentBuilder((Context) injectorLike.getInstance(Context.class), MSiteUrlUtils.b(injectorLike));
    }

    @Inject
    public MessengerMSiteUriIntentBuilder(Context context, MSiteUrlUtils mSiteUrlUtils) {
        this.f1019b = context;
        this.f1020c = mSiteUrlUtils;
    }

    @Nullable
    public final Intent m1070a(String str) {
        Uri parse = Uri.parse(str);
        Intent intent = new Intent();
        intent.setAction("android.intent.action.VIEW");
        if (!FacebookUriUtil.h(parse)) {
            return null;
        }
        List pathSegments = parse.getPathSegments();
        if (pathSegments == null || pathSegments.isEmpty()) {
            intent.setData(Uri.parse(this.f1020c.a(this.f1019b, "messages")));
        } else if (str.startsWith(FBLinks.S) || str.startsWith(FBLinks.T)) {
            intent.setData(Uri.parse(this.f1020c.a(this.f1019b, "messages/compose")));
        } else if (str.startsWith(FBLinks.Y)) {
            intent.setData(m1068b(parse.getQueryParameter("id")));
        } else if (str.startsWith(FBLinks.W) || str.startsWith(FBLinks.Q) || str.startsWith(FBLinks.U)) {
            intent.setData(m1068b((String) pathSegments.get(pathSegments.size() - 1)));
        }
        if (intent.getData() == null) {
            return null;
        }
        intent.putExtra("should_hide_menu", true);
        intent.putExtra("iab_origin", "messenger");
        intent.putExtra("custom_user_agent_suffix", "FB4A_Messaging_MSite");
        return intent;
    }

    private Uri m1068b(String str) {
        return Uri.parse(this.f1020c.a(this.f1019b, StringFormatUtil.formatStrLocaleSafe("messages/thread/%s", Uri.encode(str))));
    }
}
