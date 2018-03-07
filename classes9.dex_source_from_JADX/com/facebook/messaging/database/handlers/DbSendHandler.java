package com.facebook.messaging.database.handlers;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import com.facebook.config.application.Product;
import com.facebook.config.application.ProductMethodAutoProvider;
import com.facebook.database.sqlite.SqlExpression;
import com.facebook.database.sqlite.SqlExpression.Expression;
import com.facebook.debug.log.BLog;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.abtest.ExperimentsForMessagingAbTestModule;
import com.facebook.messaging.database.threads.DbCache;
import com.facebook.messaging.database.threads.ThreadsDatabaseSupplier;
import com.facebook.messaging.model.messages.Message;
import com.facebook.messaging.model.messages.MessageBuilder;
import com.facebook.messaging.model.messages.MessageType;
import com.facebook.messaging.model.messages.MessagesCollection;
import com.facebook.messaging.model.messages.MessagesCollectionMerger;
import com.facebook.messaging.model.send.PendingSendQueueKey;
import com.facebook.messaging.model.send.SendError;
import com.facebook.messaging.model.send.SendErrorBuilder;
import com.facebook.messaging.model.send.SendErrorType;
import com.facebook.messaging.model.threadkey.ThreadKey;
import com.facebook.messaging.service.model.NewMessageResult;
import com.facebook.messaging.service.model.UpdateMessageSendErrorParams;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.tools.dextr.runtime.detour.SQLiteDetour;
import com.facebook.tools.dextr.runtime.detour.TracerDetour;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

@Singleton
/* compiled from: mechanism_location_sharing_button */
public class DbSendHandler {
    private static final Class<?> f10386a = DbSendHandler.class;
    private static volatile DbSendHandler f10387i;
    private final Provider<ThreadsDatabaseSupplier> f10388b;
    private final DbInsertThreadsHandler f10389c;
    private final Provider<DbCache> f10390d;
    private final MessagesCollectionMerger f10391e;
    private final QeAccessor f10392f;
    private final Product f10393g;
    private final DbFetchThreadHandler f10394h;

    public static com.facebook.messaging.database.handlers.DbSendHandler m11027a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f10387i;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.messaging.database.handlers.DbSendHandler.class;
        monitor-enter(r1);
        r0 = f10387i;	 Catch:{ all -> 0x003a }
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
        r0 = m11031b(r0);	 Catch:{ all -> 0x0035 }
        f10387i = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f10387i;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.database.handlers.DbSendHandler.a(com.facebook.inject.InjectorLike):com.facebook.messaging.database.handlers.DbSendHandler");
    }

    private static DbSendHandler m11031b(InjectorLike injectorLike) {
        return new DbSendHandler(IdBasedProvider.a(injectorLike, 7815), DbInsertThreadsHandler.m10941a(injectorLike), IdBasedProvider.a(injectorLike, 7803), MessagesCollectionMerger.a(injectorLike), (QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike), ProductMethodAutoProvider.b(injectorLike), DbFetchThreadHandler.a(injectorLike));
    }

    public final NewMessageResult m11032a(NewMessageResult newMessageResult) {
        Message message = newMessageResult.f17253a;
        MessagesCollection messagesCollection = newMessageResult.f17254b;
        if (!(message == null || messagesCollection == null)) {
            if (!this.f10391e.c(messagesCollection, this.f10394h.a(message.b, 5).f17181d)) {
                MessageBuilder a = Message.newBuilder().a(message);
                a.o = true;
                newMessageResult = new NewMessageResult(newMessageResult.freshness, a.R(), newMessageResult.f17254b, newMessageResult.f17255c, newMessageResult.clientTimeMs);
            }
        }
        return this.f10389c.m10998a(newMessageResult, -1);
    }

    @Inject
    public DbSendHandler(Provider<ThreadsDatabaseSupplier> provider, DbInsertThreadsHandler dbInsertThreadsHandler, Provider<DbCache> provider2, MessagesCollectionMerger messagesCollectionMerger, QeAccessor qeAccessor, Product product, DbFetchThreadHandler dbFetchThreadHandler) {
        this.f10388b = provider;
        this.f10389c = dbInsertThreadsHandler;
        this.f10390d = provider2;
        this.f10391e = messagesCollectionMerger;
        this.f10392f = qeAccessor;
        this.f10393g = product;
        this.f10394h = dbFetchThreadHandler;
    }

    public final void m11034a(Message message) {
        m11029a(message, false);
    }

    public final void m11037b(Message message) {
        m11029a(message, true);
    }

    private void m11029a(Message message, boolean z) {
        TracerDetour.a("DbSendHandler.handleInsertPendingSentMessage", -727566788);
        try {
            SQLiteDatabase a = ((ThreadsDatabaseSupplier) this.f10388b.get()).a();
            SQLiteDetour.a(a, -1685736905);
            try {
                m11033a();
                this.f10389c.m11024b(message);
                if (z) {
                    DbInsertThreadsHandler dbInsertThreadsHandler = this.f10389c;
                    ThreadKey threadKey = message.b;
                }
                a.setTransactionSuccessful();
                SQLiteDetour.b(a, 941679201);
            } finally {
                SQLiteDetour.b(a, -1870443996);
            }
        } finally {
            TracerDetour.a(697237055);
        }
    }

    public final void m11038c(Message message) {
        SendErrorBuilder newBuilder = SendError.newBuilder();
        newBuilder.a = SendErrorType.EARLIER_MESSAGE_FROM_THREAD_FAILED;
        newBuilder = newBuilder;
        newBuilder.c = message.w.e;
        SendError f = newBuilder.f();
        this.f10389c.m11024b(message);
        m11030a(f, message.A);
    }

    public final void m11033a() {
        if (!((DbCache) this.f10390d.get()).f10439e) {
            boolean z = this.f10393g != Product.PAA && this.f10392f.a(ExperimentsForMessagingAbTestModule.d, 0) > 0;
            if (!z) {
                m11030a(SendError.a(SendErrorType.PENDING_SEND_ON_STARTUP), null);
            }
            ((DbCache) this.f10390d.get()).f10439e = true;
        }
    }

    public final void m11035a(SendError sendError, long j) {
        TracerDetour.a("DbSendHandler.changePendingSendsToFailedSends(SendError, long)", -585738966);
        try {
            Expression a = SqlExpression.a();
            a.a(SqlExpression.a("msg_type", Integer.toString(MessageType.PENDING_SEND.dbKeyValue)));
            if (j != -1) {
                a.a(SqlExpression.b("timestamp_ms", Long.toString(j)));
            }
            m11028a(a, sendError);
        } finally {
            TracerDetour.a(1291276550);
        }
    }

    private void m11030a(SendError sendError, @Nullable PendingSendQueueKey pendingSendQueueKey) {
        TracerDetour.a("DbSendHandler.changePendingSendsToFailedSends(SendError, PendingSendQueueKey)", 462155877);
        try {
            Expression a = SqlExpression.a();
            a.a(SqlExpression.a("msg_type", Integer.toString(MessageType.PENDING_SEND.dbKeyValue)));
            if (pendingSendQueueKey != null) {
                a.a(SqlExpression.a("thread_key", pendingSendQueueKey.a.g()));
                a.a(SqlExpression.a("send_queue_type", pendingSendQueueKey.b.serializedValue));
            }
            m11028a(a, sendError);
        } finally {
            TracerDetour.a(-583966545);
        }
    }

    public final void m11036a(UpdateMessageSendErrorParams updateMessageSendErrorParams) {
        TracerDetour.a("DbSendHandler.updateFailedMessageSendError", -1839763621);
        try {
            Expression a = SqlExpression.a();
            a.a(SqlExpression.a("offline_threading_id", updateMessageSendErrorParams.f17341b));
            m11028a(a, updateMessageSendErrorParams.f17340a);
        } finally {
            TracerDetour.a(1513982042);
        }
    }

    private void m11028a(Expression expression, SendError sendError) {
        TracerDetour.a("DbSendHandler.updateMessageDatabase", 551413849);
        try {
            SQLiteDatabase a = ((ThreadsDatabaseSupplier) this.f10388b.get()).a();
            SQLiteDetour.a(a, 1962504524);
            try {
                a.update("messages", m11026a(sendError), expression.a(), expression.b());
                a.setTransactionSuccessful();
                SQLiteDetour.b(a, -266960659);
            } catch (Throwable e) {
                BLog.a(f10386a, "SQLException", e);
                throw e;
            } catch (Throwable th) {
                SQLiteDetour.b(a, -142040500);
            }
        } finally {
            TracerDetour.a(1700733367);
        }
    }

    private static ContentValues m11026a(SendError sendError) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("msg_type", Integer.valueOf(MessageType.FAILED_SEND.dbKeyValue));
        contentValues.put("send_error", sendError.b.serializedString);
        contentValues.put("send_error_message", sendError.c);
        contentValues.put("send_error_timestamp_ms", Long.valueOf(sendError.e));
        contentValues.put("send_error_error_url", sendError.f);
        return contentValues;
    }
}
