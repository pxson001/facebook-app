package com.facebook.messaging.database.threads;

import android.database.Cursor;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.database.serialization.DbDraftSerialization;
import com.facebook.messaging.database.serialization.DbParticipantsSerialization;
import com.facebook.messaging.database.serialization.DbThreadGameDataSerialization;
import com.facebook.messaging.database.serialization.DbThreadRtcCallInfoSerialization;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

@Singleton
/* compiled from: luke_warm_start */
public class ThreadSummaryCursorUtil {
    public static final String[] f8800a = new String[]{"thread_key", "legacy_thread_id", "action_id", "refetch_action_id", "last_visible_action_id", "sequence_id", "name", "senders", "snippet", "snippet_sender", "admin_snippet", "timestamp_ms", "last_read_timestamp_ms", "approx_total_message_count", "unread_message_count", "pic_hash", "can_reply_to", "cannot_reply_reason", "pic", "is_subscribed", "folder", "draft", "last_fetch_time_ms", "has_missed_call", "mute_until", "me_bubble_color", "other_bubble_color", "wallpaper_color", "last_fetch_action_id", "initial_fetch_complete", "custom_like_emoji", "outgoing_message_lifetime", "custom_nicknames", "invite_uri", "is_last_message_sponsored", "group_chat_rank", "game_data", "group_type", "requires_approval", "rtc_call_info", "last_message_commerce_message_type", "is_thread_queue_enabled"};
    private static volatile ThreadSummaryCursorUtil f8801h;
    public final DbClock f8802b;
    public final DbParticipantsSerialization f8803c;
    public final DbDraftSerialization f8804d;
    public final DbThreadGameDataSerialization f8805e;
    public final DbThreadRtcCallInfoSerialization f8806f;
    public final Provider<ThreadsDatabaseSupplier> f8807g;

    public static com.facebook.messaging.database.threads.ThreadSummaryCursorUtil m9112a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f8801h;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.messaging.database.threads.ThreadSummaryCursorUtil.class;
        monitor-enter(r1);
        r0 = f8801h;	 Catch:{ all -> 0x003a }
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
        r0 = m9113b(r0);	 Catch:{ all -> 0x0035 }
        f8801h = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f8801h;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.database.threads.ThreadSummaryCursorUtil.a(com.facebook.inject.InjectorLike):com.facebook.messaging.database.threads.ThreadSummaryCursorUtil");
    }

    private static ThreadSummaryCursorUtil m9113b(InjectorLike injectorLike) {
        return new ThreadSummaryCursorUtil(DbClock.m9116a(injectorLike), DbParticipantsSerialization.m9122b(injectorLike), DbDraftSerialization.b(injectorLike), DbThreadGameDataSerialization.m9131b(injectorLike), DbThreadRtcCallInfoSerialization.m9135b(injectorLike), IdBasedProvider.a(injectorLike, 7815));
    }

    @Inject
    public ThreadSummaryCursorUtil(DbClock dbClock, DbParticipantsSerialization dbParticipantsSerialization, DbDraftSerialization dbDraftSerialization, DbThreadGameDataSerialization dbThreadGameDataSerialization, DbThreadRtcCallInfoSerialization dbThreadRtcCallInfoSerialization, Provider<ThreadsDatabaseSupplier> provider) {
        this.f8802b = dbClock;
        this.f8803c = dbParticipantsSerialization;
        this.f8804d = dbDraftSerialization;
        this.f8805e = dbThreadGameDataSerialization;
        this.f8806f = dbThreadRtcCallInfoSerialization;
        this.f8807g = provider;
    }

    public final Iterator m9114a(Cursor cursor) {
        return m9115a(cursor, false);
    }

    public final Iterator m9115a(Cursor cursor, boolean z) {
        return new Iterator(this, cursor, z);
    }
}
