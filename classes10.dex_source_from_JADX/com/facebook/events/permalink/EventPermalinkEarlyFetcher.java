package com.facebook.events.permalink;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.facebook.earlyfetch.EarlyFetchResult;
import com.facebook.earlyfetch.EarlyFetcher;
import com.facebook.events.graphql.EventsGraphQLModels.FetchEventPermalinkFragmentModel;
import com.facebook.events.permalink.protocol.EventPermalinkModelFetcher;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.inject.InjectorLike;
import com.google.common.base.Strings;
import com.google.common.util.concurrent.ListenableFuture;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: cant_reply_dialog */
public class EventPermalinkEarlyFetcher extends EarlyFetcher<String, ListenableFuture<GraphQLResult<FetchEventPermalinkFragmentModel>>> {
    private static volatile EventPermalinkEarlyFetcher f17860b;
    private final EventPermalinkModelFetcher f17861a;

    public static com.facebook.events.permalink.EventPermalinkEarlyFetcher m18274a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f17860b;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.events.permalink.EventPermalinkEarlyFetcher.class;
        monitor-enter(r1);
        r0 = f17860b;	 Catch:{ all -> 0x003a }
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
        r0 = m18275b(r0);	 Catch:{ all -> 0x0035 }
        f17860b = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f17860b;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.events.permalink.EventPermalinkEarlyFetcher.a(com.facebook.inject.InjectorLike):com.facebook.events.permalink.EventPermalinkEarlyFetcher");
    }

    private static EventPermalinkEarlyFetcher m18275b(InjectorLike injectorLike) {
        return new EventPermalinkEarlyFetcher(EventPermalinkModelFetcher.m19102b(injectorLike));
    }

    public final void m18277a(Object obj) {
        ListenableFuture listenableFuture = (ListenableFuture) obj;
        if (listenableFuture != null) {
            listenableFuture.cancel(false);
        }
    }

    @Inject
    public EventPermalinkEarlyFetcher(EventPermalinkModelFetcher eventPermalinkModelFetcher) {
        this.f17861a = eventPermalinkModelFetcher;
    }

    protected final EarlyFetchResult<String, ListenableFuture<GraphQLResult<FetchEventPermalinkFragmentModel>>> m18276a(Context context, Intent intent) {
        Bundle extras = intent.getExtras();
        if (extras == null) {
            return null;
        }
        String string = extras.getString("event_id");
        if (Strings.isNullOrEmpty(string)) {
            return null;
        }
        return new EarlyFetchResult(string, this.f17861a.m19103a(context, string));
    }

    protected final boolean m18278b() {
        return true;
    }
}
