package com.facebook.messaging.sms.defaultapp;

import android.annotation.TargetApi;
import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android_src.provider.Telephony.Sms;
import com.facebook.common.cursors.CachedColumnNameCursorProvider;
import com.facebook.common.executors.DefaultAndroidThreadUtil;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.database.sqlite.SqlExpression;
import com.facebook.database.sqlite.SqlExpression.Expression;
import com.facebook.debug.log.BLog;
import com.facebook.inject.InjectorLike;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
@TargetApi(19)
/* compiled from: com.facebook.user.broadcast.ACTION_USERNAME_UPDATED */
public class MmsSmsPendingMessagesMarker {
    private static final Uri f17549a = Uri.parse("content://sms/queued");
    private static final String[] f17550b = new String[]{"_id"};
    private static volatile MmsSmsPendingMessagesMarker f17551i;
    private final DefaultAndroidThreadUtil f17552c;
    private final CachedColumnNameCursorProvider f17553d;
    private final Context f17554e;
    public boolean f17555f = false;
    private long f17556g;
    private final Object f17557h = new Object();

    public static com.facebook.messaging.sms.defaultapp.MmsSmsPendingMessagesMarker m17541a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f17551i;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.messaging.sms.defaultapp.MmsSmsPendingMessagesMarker.class;
        monitor-enter(r1);
        r0 = f17551i;	 Catch:{ all -> 0x003a }
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
        r0 = m17542b(r0);	 Catch:{ all -> 0x0035 }
        f17551i = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f17551i;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.sms.defaultapp.MmsSmsPendingMessagesMarker.a(com.facebook.inject.InjectorLike):com.facebook.messaging.sms.defaultapp.MmsSmsPendingMessagesMarker");
    }

    private void m17543c() {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Can't find block by offset: 0x0059 in list []
	at jadx.core.utils.BlockUtils.getBlockByOffset(BlockUtils.java:42)
	at jadx.core.dex.instructions.IfNode.initBlocks(IfNode.java:60)
	at jadx.core.dex.visitors.blocksmaker.BlockFinish.initBlocksInIfNodes(BlockFinish.java:48)
	at jadx.core.dex.visitors.blocksmaker.BlockFinish.visit(BlockFinish.java:33)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r10 = this;
        r1 = 0;
        r0 = r10.f17554e;	 Catch:{ Exception -> 0x0049, all -> 0x0060 }
        r0 = android_src.mmsv2.pdu.PduPersister.m3702a(r0);	 Catch:{ Exception -> 0x0049, all -> 0x0060 }
        r2 = r10.f17556g;	 Catch:{ Exception -> 0x0049, all -> 0x0060 }
        r1 = r0.m3718a(r2);	 Catch:{ Exception -> 0x0049, all -> 0x0060 }
        if (r1 == 0) goto L_0x005a;	 Catch:{ Exception -> 0x0049, all -> 0x0060 }
    L_0x000f:
        r1 = com.facebook.common.cursors.CachedColumnNameCursorProvider.a(r1);	 Catch:{ Exception -> 0x0049, all -> 0x0060 }
    L_0x0013:
        r0 = r1.moveToNext();	 Catch:{ Exception -> 0x0049, all -> 0x0060 }
        if (r0 == 0) goto L_0x005a;	 Catch:{ Exception -> 0x0049, all -> 0x0060 }
    L_0x0019:
        r0 = "msg_id";	 Catch:{ Exception -> 0x0049, all -> 0x0060 }
        r2 = com.facebook.common.cursors.CursorHelper.b(r1, r0);	 Catch:{ Exception -> 0x0049, all -> 0x0060 }
        r0 = "err_type";	 Catch:{ Exception -> 0x0049, all -> 0x0060 }
        r4 = com.facebook.common.cursors.CursorHelper.b(r1, r0);	 Catch:{ Exception -> 0x0049, all -> 0x0060 }
        r0 = "msg_type";	 Catch:{ Exception -> 0x0049, all -> 0x0060 }
        r6 = com.facebook.common.cursors.CursorHelper.b(r1, r0);	 Catch:{ Exception -> 0x0049, all -> 0x0060 }
        r8 = 128; // 0x80 float:1.794E-43 double:6.32E-322;	 Catch:{ Exception -> 0x0049, all -> 0x0060 }
        r0 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1));	 Catch:{ Exception -> 0x0049, all -> 0x0060 }
        if (r0 != 0) goto L_0x0013;	 Catch:{ Exception -> 0x0049, all -> 0x0060 }
    L_0x0031:
        r6 = 10;	 Catch:{ Exception -> 0x0049, all -> 0x0060 }
        r0 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1));	 Catch:{ Exception -> 0x0049, all -> 0x0060 }
        if (r0 >= 0) goto L_0x0013;	 Catch:{ Exception -> 0x0049, all -> 0x0060 }
    L_0x0037:
        java.lang.Long.valueOf(r2);	 Catch:{ Exception -> 0x0049, all -> 0x0060 }
        java.lang.Long.valueOf(r4);	 Catch:{ Exception -> 0x0049, all -> 0x0060 }
        r0 = r10.f17554e;	 Catch:{ Exception -> 0x0049, all -> 0x0060 }
        r4 = android_src.provider.Telephony.Mms.a;	 Catch:{ Exception -> 0x0049, all -> 0x0060 }
        r2 = android.content.ContentUris.withAppendedId(r4, r2);	 Catch:{ Exception -> 0x0049, all -> 0x0060 }
        com.facebook.messaging.sms.defaultapp.action.MmsPendingMessageAction.m17595a(r0, r2);	 Catch:{ Exception -> 0x0049, all -> 0x0060 }
        goto L_0x0013;
    L_0x0049:
        r0 = move-exception;
        r2 = "MmsSmsPendingMessagesMarker";	 Catch:{ Exception -> 0x0049, all -> 0x0060 }
        r3 = "Exception when marking pending mms messages as failed";	 Catch:{ Exception -> 0x0049, all -> 0x0060 }
        r4 = 0;	 Catch:{ Exception -> 0x0049, all -> 0x0060 }
        r4 = new java.lang.Object[r4];	 Catch:{ Exception -> 0x0049, all -> 0x0060 }
        com.facebook.debug.log.BLog.b(r2, r0, r3, r4);	 Catch:{ Exception -> 0x0049, all -> 0x0060 }
        if (r1 == 0) goto L_0x0059;
    L_0x0056:
        r1.close();
    L_0x0059:
        return;
    L_0x005a:
        if (r1 == 0) goto L_0x0059;
    L_0x005c:
        r1.close();
        goto L_0x0059;
    L_0x0060:
        r0 = move-exception;
        if (r1 == 0) goto L_0x0066;
    L_0x0063:
        r1.close();
    L_0x0066:
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.sms.defaultapp.MmsSmsPendingMessagesMarker.c():void");
    }

    private static MmsSmsPendingMessagesMarker m17542b(InjectorLike injectorLike) {
        return new MmsSmsPendingMessagesMarker(DefaultAndroidThreadUtil.b(injectorLike), (CachedColumnNameCursorProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(CachedColumnNameCursorProvider.class), (Context) injectorLike.getInstance(Context.class), (Clock) SystemClockMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public MmsSmsPendingMessagesMarker(DefaultAndroidThreadUtil defaultAndroidThreadUtil, CachedColumnNameCursorProvider cachedColumnNameCursorProvider, Context context, Clock clock) {
        this.f17552c = defaultAndroidThreadUtil;
        this.f17553d = cachedColumnNameCursorProvider;
        this.f17554e = context;
        this.f17556g = clock.a();
    }

    public final void m17545b() {
        this.f17552c.b();
        if (!this.f17555f) {
            synchronized (this.f17557h) {
                if (this.f17555f) {
                    return;
                }
                this.f17555f = true;
                Long.valueOf(this.f17556g);
                m17543c();
                m17544d();
            }
        }
    }

    private void m17544d() {
        Throwable e;
        ContentResolver contentResolver = this.f17554e.getContentResolver();
        Cursor query;
        try {
            Expression c = SqlExpression.c("date", String.valueOf(this.f17556g));
            query = contentResolver.query(f17549a, f17550b, c.a(), c.b(), null);
            while (query != null) {
                try {
                    if (!query.moveToNext()) {
                        break;
                    }
                    try {
                        Sms.a(this.f17554e, ContentUris.withAppendedId(Sms.a, (long) query.getInt(0)), 5, 1);
                    } catch (Throwable e2) {
                        BLog.b("MmsSmsPendingMessagesMarker", e2, "Error moving sms to failed folder: %s", new Object[]{r2});
                    }
                } catch (Exception e3) {
                    e2 = e3;
                }
            }
            if (query != null) {
                query.close();
            }
        } catch (Exception e4) {
            e2 = e4;
            query = null;
            try {
                BLog.b("MmsSmsPendingMessagesMarker", e2, "Exception when marking pending sms messages as failed", new Object[0]);
                if (query != null) {
                    query.close();
                }
            } catch (Throwable th) {
                e2 = th;
                if (query != null) {
                    query.close();
                }
                throw e2;
            }
        } catch (Throwable th2) {
            e2 = th2;
            query = null;
            if (query != null) {
                query.close();
            }
            throw e2;
        }
    }
}
