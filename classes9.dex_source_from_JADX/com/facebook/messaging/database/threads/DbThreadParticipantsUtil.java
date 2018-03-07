package com.facebook.messaging.database.threads;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQueryBuilder;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.messaging.database.serialization.DbParticipantsSerialization;
import com.facebook.messaging.database.threads.ThreadsDbSchemaPart.ThreadParticipantsTable.Columns;
import com.facebook.messaging.model.threadkey.ThreadKey;
import com.facebook.messaging.model.threads.ThreadJoinRequest;
import com.facebook.messaging.model.threads.ThreadParticipant;
import com.facebook.tools.dextr.runtime.detour.SQLiteDetour;
import com.facebook.user.model.UserKey;
import com.google.common.base.Objects;
import com.google.common.collect.ImmutableList;
import java.util.List;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

@Singleton
/* compiled from: me/custom_voicemails */
public class DbThreadParticipantsUtil {
    public static final String f10452a = Columns.f10758a.d;
    public static final String f10453b = Columns.f10759b.d;
    public static final String f10454c = Columns.f10760c.d;
    public static final String f10455d = Columns.f10761d.d;
    public static final String f10456e = Columns.f10762e.d;
    public static final String f10457f = Columns.f10766i.d;
    public static final String f10458g = Columns.f10763f.d;
    public static final String f10459h = Columns.f10764g.d;
    public static final String f10460i = Columns.f10765h.d;
    public static final String f10461j = Columns.f10767j.d;
    public static final String[] f10462k = new String[]{f10452a, f10453b, f10454c, f10455d, f10456e, f10457f, f10458g, f10459h, f10460i, f10461j};
    private static final String f10463l = (f10452a + "=? AND " + f10456e + "=?");
    private static final String f10464m = (f10463l + " AND " + f10453b + "=?");
    private static volatile DbThreadParticipantsUtil f10465p;
    private final Lazy<DbParticipantsSerialization> f10466n;
    private final Provider<ThreadsDatabaseSupplier> f10467o;

    /* compiled from: me/custom_voicemails */
    public enum ParticipantType {
        PARTICIPANT("PARTICIPANT"),
        FORMER_PARTICIPANT("FORMER_PARTICIPANT"),
        BOT("BOT"),
        REQUEST("REQUEST");
        
        public final String dbValue;

        private ParticipantType(String str) {
            this.dbValue = str;
        }

        @Nullable
        public static ParticipantType fromDbValue(String str) {
            for (ParticipantType participantType : values()) {
                if (Objects.equal(participantType.dbValue, str)) {
                    return participantType;
                }
            }
            return null;
        }
    }

    public static com.facebook.messaging.database.threads.DbThreadParticipantsUtil m11119a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f10465p;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.messaging.database.threads.DbThreadParticipantsUtil.class;
        monitor-enter(r1);
        r0 = f10465p;	 Catch:{ all -> 0x003a }
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
        r0 = m11123b(r0);	 Catch:{ all -> 0x0035 }
        f10465p = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f10465p;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.database.threads.DbThreadParticipantsUtil.a(com.facebook.inject.InjectorLike):com.facebook.messaging.database.threads.DbThreadParticipantsUtil");
    }

    private static DbThreadParticipantsUtil m11123b(InjectorLike injectorLike) {
        return new DbThreadParticipantsUtil(IdBasedLazy.a(injectorLike, 2605), IdBasedProvider.a(injectorLike, 7815));
    }

    @Inject
    public DbThreadParticipantsUtil(Lazy<DbParticipantsSerialization> lazy, Provider<ThreadsDatabaseSupplier> provider) {
        this.f10466n = lazy;
        this.f10467o = provider;
    }

    public static void m11122a(SQLiteDatabase sQLiteDatabase, ThreadKey threadKey, List<ThreadParticipant> list, ParticipantType participantType) {
        ContentValues contentValues = new ContentValues();
        SQLiteDetour.a(sQLiteDatabase, -1349481131);
        try {
            for (ThreadParticipant threadParticipant : list) {
                contentValues.put(f10452a, threadKey.g());
                contentValues.put(f10453b, threadParticipant.b().c());
                contentValues.put(f10454c, threadParticipant.c());
                contentValues.put(f10455d, threadParticipant.d());
                contentValues.put(f10458g, Long.valueOf(threadParticipant.b));
                contentValues.put(f10459h, Long.valueOf(threadParticipant.d));
                contentValues.put(f10460i, threadParticipant.c);
                contentValues.put(f10456e, participantType.dbValue);
                contentValues.put(f10457f, Boolean.valueOf(threadParticipant.e));
                SQLiteDetour.a(168006820);
                sQLiteDatabase.replaceOrThrow("thread_participants", null, contentValues);
                SQLiteDetour.a(921994192);
                contentValues.clear();
            }
            sQLiteDatabase.setTransactionSuccessful();
        } finally {
            SQLiteDetour.b(sQLiteDatabase, -83720850);
        }
    }

    public static void m11121a(SQLiteDatabase sQLiteDatabase, ThreadKey threadKey, List<ThreadJoinRequest> list) {
        SQLiteDetour.a(sQLiteDatabase, -1571525067);
        try {
            sQLiteDatabase.delete("thread_participants", f10463l, new String[]{threadKey.g(), ParticipantType.REQUEST.dbValue});
            ContentValues contentValues = new ContentValues();
            ContentValues contentValues2 = contentValues;
            for (ThreadJoinRequest threadJoinRequest : list) {
                contentValues = m11118a(contentValues2, threadKey, threadJoinRequest.a, threadJoinRequest.b);
                SQLiteDetour.a(-466027645);
                sQLiteDatabase.replaceOrThrow("thread_participants", null, contentValues);
                SQLiteDetour.a(-587035725);
                contentValues.clear();
                contentValues2 = contentValues;
            }
            sQLiteDatabase.setTransactionSuccessful();
        } finally {
            SQLiteDetour.b(sQLiteDatabase, -18835215);
        }
    }

    public final void m11127a(ThreadKey threadKey, UserKey userKey, long j) {
        SQLiteDatabase a = ((ThreadsDatabaseSupplier) this.f10467o.get()).a();
        SQLiteDetour.a(a, -2098879235);
        try {
            ContentValues contentValues = new ContentValues();
            m11118a(contentValues, threadKey, userKey, j);
            SQLiteDetour.a(2146249175);
            a.replaceOrThrow("thread_participants", null, contentValues);
            SQLiteDetour.a(-2108497005);
            a.setTransactionSuccessful();
        } finally {
            SQLiteDetour.b(a, -317079604);
        }
    }

    public final void m11126a(ThreadKey threadKey, UserKey userKey) {
        SQLiteDatabase a = ((ThreadsDatabaseSupplier) this.f10467o.get()).a();
        SQLiteDetour.a(a, -1401027780);
        try {
            a.delete("thread_participants", f10464m, new String[]{threadKey.g(), ParticipantType.REQUEST.dbValue, userKey.c()});
            a.setTransactionSuccessful();
        } finally {
            SQLiteDetour.b(a, 529595785);
        }
    }

    public static String m11120a(ImmutableList<ThreadKey> immutableList) {
        String str = "thread_participants";
        String[] strArr = f10462k;
        StringBuilder append = new StringBuilder(100).append(f10452a).append(" IN (");
        int size = immutableList.size();
        for (int i = 0; i < size; i++) {
            append.append('\'').append(((ThreadKey) immutableList.get(i)).g()).append("',");
        }
        if (!immutableList.isEmpty()) {
            append.deleteCharAt(append.length() - 1);
        }
        return "((" + SQLiteQueryBuilder.buildQueryString(false, str, strArr, append.append(')').toString(), null, null, null, null) + ") NATURAL LEFT JOIN thread_users" + " )";
    }

    final void m11125a(SQLiteDatabase sQLiteDatabase) {
        SQLiteDatabase sQLiteDatabase2 = sQLiteDatabase;
        Cursor query = sQLiteDatabase2.query("threads", new String[]{"thread_key", "participants", "former_participants", "bot_participants"}, null, null, null, null, null);
        try {
            int columnIndexOrThrow = query.getColumnIndexOrThrow("thread_key");
            int columnIndexOrThrow2 = query.getColumnIndexOrThrow("participants");
            int columnIndexOrThrow3 = query.getColumnIndexOrThrow("former_participants");
            int columnIndexOrThrow4 = query.getColumnIndexOrThrow("bot_participants");
            while (query.moveToNext()) {
                ThreadKey a = ThreadKey.a(query.getString(columnIndexOrThrow));
                String string = query.getString(columnIndexOrThrow2);
                String string2 = query.getString(columnIndexOrThrow3);
                String string3 = query.getString(columnIndexOrThrow4);
                DbParticipantsSerialization dbParticipantsSerialization = (DbParticipantsSerialization) this.f10466n.get();
                ImmutableList c = dbParticipantsSerialization.c(string);
                ImmutableList c2 = dbParticipantsSerialization.c(string2);
                ImmutableList c3 = dbParticipantsSerialization.c(string3);
                m11124b(sQLiteDatabase, a, c, ParticipantType.PARTICIPANT);
                m11124b(sQLiteDatabase, a, c2, ParticipantType.FORMER_PARTICIPANT);
                m11124b(sQLiteDatabase, a, c3, ParticipantType.BOT);
            }
        } finally {
            query.close();
        }
    }

    private static void m11124b(SQLiteDatabase sQLiteDatabase, ThreadKey threadKey, List<ThreadParticipant> list, ParticipantType participantType) {
        ContentValues contentValues = new ContentValues();
        SQLiteDetour.a(sQLiteDatabase, -959658346);
        try {
            for (ThreadParticipant threadParticipant : list) {
                contentValues.put("thread_key", threadKey.g());
                contentValues.put("user_key", threadParticipant.b().c());
                contentValues.put("email", threadParticipant.c());
                contentValues.put("last_read_receipt_time", Long.valueOf(threadParticipant.b));
                contentValues.put("last_delivered_receipt_time", Long.valueOf(threadParticipant.d));
                contentValues.put("last_delivered_receipt_id", threadParticipant.c);
                contentValues.put("type", participantType.dbValue);
                SQLiteDetour.a(137689917);
                sQLiteDatabase.replaceOrThrow("thread_participants", null, contentValues);
                SQLiteDetour.a(1255460865);
                contentValues.clear();
            }
            sQLiteDatabase.setTransactionSuccessful();
        } finally {
            SQLiteDetour.b(sQLiteDatabase, -282572996);
        }
    }

    private static ContentValues m11118a(ContentValues contentValues, ThreadKey threadKey, UserKey userKey, long j) {
        contentValues.put(f10452a, threadKey.g());
        contentValues.put(f10453b, userKey.c());
        contentValues.put(f10456e, ParticipantType.REQUEST.dbValue);
        contentValues.put(f10461j, Long.valueOf(j));
        return contentValues;
    }
}
