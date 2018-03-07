package com.facebook.pages.identity.contextitems;

import android.content.Intent;
import android.net.Uri;
import android.view.View;
import com.facebook.common.fblinks.FBLinks;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.content.SecureContextHelper;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.pages.identity.contextitems.handler.PageContextItemHandlingData;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: photo_added */
public class PageContextItemsInviteFriendsLikePageHandler {
    private static volatile PageContextItemsInviteFriendsLikePageHandler f3839b;
    private final Lazy<SecureContextHelper> f3840a;

    public static com.facebook.pages.identity.contextitems.PageContextItemsInviteFriendsLikePageHandler m4777a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f3839b;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.pages.identity.contextitems.PageContextItemsInviteFriendsLikePageHandler.class;
        monitor-enter(r1);
        r0 = f3839b;	 Catch:{ all -> 0x003a }
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
        r0 = m4778b(r0);	 Catch:{ all -> 0x0035 }
        f3839b = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f3839b;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.pages.identity.contextitems.PageContextItemsInviteFriendsLikePageHandler.a(com.facebook.inject.InjectorLike):com.facebook.pages.identity.contextitems.PageContextItemsInviteFriendsLikePageHandler");
    }

    private static PageContextItemsInviteFriendsLikePageHandler m4778b(InjectorLike injectorLike) {
        return new PageContextItemsInviteFriendsLikePageHandler(IdBasedSingletonScopeProvider.b(injectorLike, 968));
    }

    @Inject
    public PageContextItemsInviteFriendsLikePageHandler(Lazy<SecureContextHelper> lazy) {
        this.f3840a = lazy;
    }

    public final void m4779a(View view, PageContextItemHandlingData pageContextItemHandlingData) {
        Intent intent = new Intent();
        intent.setData(Uri.parse(StringFormatUtil.formatStrLocaleSafe(FBLinks.aI, Long.toString(pageContextItemHandlingData.a))));
        ((SecureContextHelper) this.f3840a.get()).a(intent, view.getContext());
    }
}
