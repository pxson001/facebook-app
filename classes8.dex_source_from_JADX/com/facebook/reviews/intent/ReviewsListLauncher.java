package com.facebook.reviews.intent;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.fblinks.FBLinks;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.uri.UriIntentMapper;
import com.facebook.content.SecureContextHelper;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.katana.urimap.Fb4aUriIntentMapper;
import com.google.common.base.Preconditions;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: TrendingTypeaheadUnit( */
public class ReviewsListLauncher {
    private static volatile ReviewsListLauncher f21630d;
    private final Lazy<FbErrorReporter> f21631a;
    private final UriIntentMapper f21632b;
    private Lazy<SecureContextHelper> f21633c;

    public static com.facebook.reviews.intent.ReviewsListLauncher m25169a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r0 = f21630d;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.reviews.intent.ReviewsListLauncher.class;
        monitor-enter(r1);
        r0 = f21630d;	 Catch:{ all -> 0x003a }
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
        r0 = m25170b(r0);	 Catch:{ all -> 0x0035 }
        f21630d = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f21630d;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.reviews.intent.ReviewsListLauncher.a(com.facebook.inject.InjectorLike):com.facebook.reviews.intent.ReviewsListLauncher");
    }

    private static ReviewsListLauncher m25170b(InjectorLike injectorLike) {
        return new ReviewsListLauncher(IdBasedSingletonScopeProvider.b(injectorLike, 494), IdBasedSingletonScopeProvider.b(injectorLike, 968), (UriIntentMapper) Fb4aUriIntentMapper.a(injectorLike));
    }

    @Inject
    public ReviewsListLauncher(Lazy<FbErrorReporter> lazy, Lazy<SecureContextHelper> lazy2, UriIntentMapper uriIntentMapper) {
        this.f21631a = lazy;
        this.f21633c = lazy2;
        this.f21632b = uriIntentMapper;
    }

    public final void m25171a(long j, @Nullable String str, @Nullable String str2, @Nullable String str3, Context context) {
        Preconditions.checkArgument(j > 0, "Invalid page Id");
        Intent b = m25172b(j, str, str2, str3, context);
        if (b != null) {
            ((SecureContextHelper) this.f21633c.get()).a(b, context);
        } else {
            ((AbstractFbErrorReporter) this.f21631a.get()).a(ReviewsListLauncher.class.getSimpleName(), "Failed to created intent for page. PageId: " + j);
        }
    }

    @Nullable
    public final Intent m25172b(long j, @Nullable String str, @Nullable String str2, @Nullable String str3, Context context) {
        Preconditions.checkArgument(j > 0, "Invalid page Id");
        UriIntentMapper uriIntentMapper = this.f21632b;
        Preconditions.checkArgument(j > 0, "Invalid page Id");
        Intent a = uriIntentMapper.a(context, StringFormatUtil.formatStrLocaleSafe(FBLinks.dx, Long.valueOf(j)));
        if (a != null) {
            Bundle bundle = new Bundle();
            bundle.putLong("com.facebook.katana.profile.id", j);
            bundle.putString("session_id", str);
            bundle.putString("profile_name", str2);
            bundle.putString("fragment_title", str3);
            a.putExtras(bundle);
        }
        return a;
    }
}
