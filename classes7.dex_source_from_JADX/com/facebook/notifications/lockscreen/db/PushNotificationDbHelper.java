package com.facebook.notifications.lockscreen.db;

import android.database.Cursor;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.executors.DefaultAndroidThreadUtil;
import com.facebook.common.executors.ListeningExecutorService_BackgroundExecutorServiceMethodAutoProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.notifications.lockscreen.db.PushNotificationsDbSchemaPart.PushNotificationsTable.Columns;
import com.facebook.notifications.lockscreen.util.PushNotification;
import com.facebook.notifications.provider.GraphQLNotificationsContentProviderHelper;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import java.util.List;
import java.util.concurrent.ExecutorService;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: newsfeed_story_like */
public class PushNotificationDbHelper {
    private static volatile PushNotificationDbHelper f8172f;
    private final DefaultAndroidThreadUtil f8173a;
    private final ExecutorService f8174b;
    private final PushNotificationDatabaseSupplier f8175c;
    private final GraphQLNotificationsContentProviderHelper f8176d;
    private final AbstractFbErrorReporter f8177e;

    public static com.facebook.notifications.lockscreen.db.PushNotificationDbHelper m9796a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f8172f;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.notifications.lockscreen.db.PushNotificationDbHelper.class;
        monitor-enter(r1);
        r0 = f8172f;	 Catch:{ all -> 0x003a }
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
        r0 = m9797b(r0);	 Catch:{ all -> 0x0035 }
        f8172f = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f8172f;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.notifications.lockscreen.db.PushNotificationDbHelper.a(com.facebook.inject.InjectorLike):com.facebook.notifications.lockscreen.db.PushNotificationDbHelper");
    }

    private static PushNotificationDbHelper m9797b(InjectorLike injectorLike) {
        return new PushNotificationDbHelper(DefaultAndroidThreadUtil.b(injectorLike), (ExecutorService) ListeningExecutorService_BackgroundExecutorServiceMethodAutoProvider.a(injectorLike), PushNotificationDatabaseSupplier.a(injectorLike), GraphQLNotificationsContentProviderHelper.a(injectorLike), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike));
    }

    @Inject
    public PushNotificationDbHelper(DefaultAndroidThreadUtil defaultAndroidThreadUtil, ExecutorService executorService, PushNotificationDatabaseSupplier pushNotificationDatabaseSupplier, GraphQLNotificationsContentProviderHelper graphQLNotificationsContentProviderHelper, AbstractFbErrorReporter abstractFbErrorReporter) {
        this.f8173a = defaultAndroidThreadUtil;
        this.f8174b = executorService;
        this.f8175c = pushNotificationDatabaseSupplier;
        this.f8176d = graphQLNotificationsContentProviderHelper;
        this.f8177e = abstractFbErrorReporter;
    }

    public final List<PushNotification> m9798a() {
        this.f8173a.b("Trying to access db from ui thread");
        Cursor query = this.f8175c.a().query("push_notifications", null, null, null, null, null, Columns.e.a() + " DESC");
        Builder builder = ImmutableList.builder();
        if (query != null) {
            try {
                if (query.moveToFirst()) {
                    do {
                        builder.c(new PushNotification(query, this.f8176d));
                    } while (query.moveToNext());
                    if (query != null) {
                        query.close();
                    }
                    return builder.b();
                }
            } catch (Throwable e) {
                this.f8177e.a("LockscreenUtil_unseen_push_notif_fetch_error", "Error fetching unseen push notifications", e);
                if (query != null) {
                    query.close();
                }
            } catch (Throwable th) {
                if (query != null) {
                    query.close();
                }
            }
        }
        if (query != null) {
            Integer.valueOf(query.getCount());
        }
        if (query != null) {
            query.close();
        }
        return builder.b();
    }

    public final void m9799b() {
        this.f8173a.b("Trying to access db on ui thread");
        this.f8175c.a().delete("push_notifications", null, null);
    }
}
