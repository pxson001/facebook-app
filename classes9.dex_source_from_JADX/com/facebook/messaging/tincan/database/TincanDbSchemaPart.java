package com.facebook.messaging.tincan.database;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.util.Base64;
import com.facebook.androidcompat.AndroidCompat;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.crypto.exception.CryptoInitializationException;
import com.facebook.crypto.exception.KeyChainException;
import com.facebook.database.properties.DbPropertyUtil;
import com.facebook.database.sqlite.SqlColumn;
import com.facebook.database.sqlite.SqlExpression.Expression;
import com.facebook.database.sqlite.SqlKeys.PrimaryKey;
import com.facebook.database.sqlite.SqlKeys.SqlKey;
import com.facebook.database.sqlite.SqlTable;
import com.facebook.database.supplier.TablesDbSchemaPart;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.tools.dextr.runtime.detour.SQLiteDetour;
import com.google.common.collect.ImmutableList;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: client_image_hash */
public class TincanDbSchemaPart extends TablesDbSchemaPart {
    private static volatile TincanDbSchemaPart f17945c;
    private final Lazy<FbErrorReporter> f17946a;
    private final Lazy<DbCrypto> f17947b;

    /* compiled from: client_image_hash */
    public final class IdentityKeyTable extends SqlTable {
        private static final SqlKey f17918a = new PrimaryKey(ImmutableList.of(Columns.f17916a));
        private static final ImmutableList<SqlColumn> f17919b = ImmutableList.of(Columns.f17916a, Columns.f17917b);

        /* compiled from: client_image_hash */
        final class Columns {
            public static final SqlColumn f17916a = new SqlColumn("remote_name", "TEXT");
            public static final SqlColumn f17917b = new SqlColumn("identity_key", "BLOB");
        }

        public IdentityKeyTable() {
            super("identity_keys", f17919b, f17918a);
        }

        public final void m17931a(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        }
    }

    /* compiled from: client_image_hash */
    public final class MessagesTable extends SqlTable {
        private static final SqlKey f17920a = new PrimaryKey(ImmutableList.of(Columns.a));
        private static final ImmutableList<SqlColumn> f17921b = ImmutableList.of(Columns.a, Columns.b, Columns.c, Columns.d, Columns.e, Columns.f, Columns.g, Columns.h, Columns.i, Columns.k, Columns.j, Columns.l, new SqlColumn[]{Columns.m, Columns.n});
        private static final String f17922c = SqlTable.b("messages", "messages_timestamp_index", ImmutableList.of(Columns.b.d, Columns.e + " DESC"));
        private static final String f17923d = SqlTable.a("messages", "messages_offline_threading_id_index", ImmutableList.of(Columns.i));

        public MessagesTable() {
            super("messages", f17921b, f17920a);
        }

        public final void m17932a(SQLiteDatabase sQLiteDatabase) {
            super.a(sQLiteDatabase);
            String str = f17922c;
            SQLiteDetour.a(1863609696);
            sQLiteDatabase.execSQL(str);
            SQLiteDetour.a(-359866965);
            str = f17923d;
            SQLiteDetour.a(-751158);
            sQLiteDatabase.execSQL(str);
            SQLiteDetour.a(171613248);
        }

        public final void m17933a(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        }
    }

    /* compiled from: client_image_hash */
    public final class PendingSessionsTable extends SqlTable {
        private static final SqlKey f17928a = new PrimaryKey(ImmutableList.of(Columns.f17924a));
        private static final ImmutableList<SqlColumn> f17929b = ImmutableList.of(Columns.f17924a, Columns.f17925b, Columns.f17926c, Columns.f17927d);

        /* compiled from: client_image_hash */
        final class Columns {
            public static final SqlColumn f17924a = new SqlColumn("thread_key", "TEXT");
            public static final SqlColumn f17925b = new SqlColumn("session_state", "BLOB");
            public static final SqlColumn f17926c = new SqlColumn("packet_key", "TEXT");
            public static final SqlColumn f17927d = new SqlColumn("encryption_key", "BLOB");
        }

        public PendingSessionsTable() {
            super("pending_sessions", f17929b, f17928a);
        }

        public final void m17934a(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        }
    }

    /* compiled from: client_image_hash */
    public final class PreKeyTable extends SqlTable {
        private static final SqlKey f17933a = new PrimaryKey(ImmutableList.of(Columns.f17930a));
        private static final ImmutableList<SqlColumn> f17934b = ImmutableList.of(Columns.f17930a, Columns.f17931b, Columns.f17932c);

        /* compiled from: client_image_hash */
        final class Columns {
            public static final SqlColumn f17930a = new SqlColumn("id", "TEXT");
            public static final SqlColumn f17931b = new SqlColumn("key", "BLOB");
            public static final SqlColumn f17932c = new SqlColumn("timestamp_ms", "INTEGER");
        }

        public PreKeyTable() {
            super("pre_keys", f17934b, f17933a);
        }

        public final void m17935a(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        }
    }

    /* compiled from: client_image_hash */
    public final class PropertiesTable extends SqlTable {
        private static final ImmutableList<SqlColumn> f17935a = ImmutableList.of(DbPropertyUtil.a, DbPropertyUtil.b);

        public PropertiesTable() {
            super("properties", f17935a);
        }

        public final void m17936a(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        }
    }

    /* compiled from: client_image_hash */
    public final class SignedPreKeyTable extends SqlTable {
        private static final SqlKey f17939a = new PrimaryKey(ImmutableList.of(Columns.f17936a));
        private static final ImmutableList<SqlColumn> f17940b = ImmutableList.of(Columns.f17936a, Columns.f17937b, Columns.f17938c);

        /* compiled from: client_image_hash */
        final class Columns {
            public static final SqlColumn f17936a = new SqlColumn("id", "TEXT");
            public static final SqlColumn f17937b = new SqlColumn("key", "BLOB");
            public static final SqlColumn f17938c = new SqlColumn("timestamp_ms", "INTEGER");
        }

        public SignedPreKeyTable() {
            super("signed_pre_keys", f17940b, f17939a);
        }

        public final void m17937a(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        }
    }

    /* compiled from: client_image_hash */
    public final class ThreadParticipantsTable extends SqlTable {
        private static final SqlKey f17941a = new PrimaryKey(ImmutableList.of(Columns.a));
        private static final ImmutableList<SqlColumn> f17942b = ImmutableList.of(Columns.a, Columns.b, Columns.c, Columns.d, Columns.e, Columns.f);

        public ThreadParticipantsTable() {
            super("thread_participants", f17942b, f17941a);
        }

        public final void m17938a(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        }
    }

    /* compiled from: client_image_hash */
    public final class ThreadsTable extends SqlTable {
        private static final SqlKey f17943a = new PrimaryKey(ImmutableList.of(Columns.a));
        private static final ImmutableList<SqlColumn> f17944b = ImmutableList.of(Columns.a, Columns.b, Columns.c, Columns.d, Columns.e, Columns.f, Columns.g, Columns.h, Columns.i, Columns.j, Columns.k, Columns.l, new SqlColumn[]{Columns.m, Columns.n, Columns.o});

        @Inject
        public ThreadsTable() {
            super("threads", f17944b, f17943a);
        }

        public final void m17939a(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        }
    }

    public static com.facebook.messaging.tincan.database.TincanDbSchemaPart m17940a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f17945c;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.messaging.tincan.database.TincanDbSchemaPart.class;
        monitor-enter(r1);
        r0 = f17945c;	 Catch:{ all -> 0x003a }
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
        r0 = m17942b(r0);	 Catch:{ all -> 0x0035 }
        f17945c = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f17945c;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.tincan.database.TincanDbSchemaPart.a(com.facebook.inject.InjectorLike):com.facebook.messaging.tincan.database.TincanDbSchemaPart");
    }

    private static TincanDbSchemaPart m17942b(InjectorLike injectorLike) {
        return new TincanDbSchemaPart(IdBasedSingletonScopeProvider.b(injectorLike, 494), IdBasedSingletonScopeProvider.b(injectorLike, 2718));
    }

    @Inject
    public TincanDbSchemaPart(Lazy<FbErrorReporter> lazy, Lazy<DbCrypto> lazy2) {
        super("tincan", 16, ImmutableList.of(new PropertiesTable(), new ThreadsTable(), new MessagesTable(), new ThreadParticipantsTable(), new IdentityKeyTable(), new PendingSessionsTable(), new PreKeyTable(), new SignedPreKeyTable()));
        this.f17946a = lazy;
        this.f17947b = lazy2;
    }

    public final void m17951a(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        Integer.valueOf(i);
        Integer.valueOf(i2);
        while (i < i2) {
            i = m17941b(sQLiteDatabase, i, i2);
        }
    }

    public final void m17952b(SQLiteDatabase sQLiteDatabase) {
    }

    private int m17941b(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        int i3 = i + 1;
        if (i == 1) {
            SQLiteDetour.a(1832735119);
            sQLiteDatabase.execSQL("ALTER TABLE threads ADD COLUMN last_read_receipt_time INTEGER");
            SQLiteDetour.a(-1926977911);
            SQLiteDetour.a(1352288639);
            sQLiteDatabase.execSQL("ALTER TABLE threads ADD COLUMN last_delivered_receipt_time INTEGER");
            SQLiteDetour.a(1312181577);
            SQLiteDetour.a(668317543);
            sQLiteDatabase.execSQL("ALTER TABLE threads ADD COLUMN last_delivered_receipt_message_id TEXT");
            SQLiteDetour.a(-1598289789);
            SQLiteDetour.a(-182208352);
            sQLiteDatabase.execSQL("ALTER TABLE thread_participants ADD COLUMN user_fbid INTEGER");
            SQLiteDetour.a(809064612);
            SqlColumn sqlColumn = new SqlColumn("user_fbid", "INTEGER");
            SqlTable.a(sQLiteDatabase, "thread_participants", ImmutableList.of(sqlColumn, new SqlColumn("first_name", "TEXT"), new SqlColumn("last_name", "TEXT"), new SqlColumn("name", "TEXT"), new SqlColumn("profile_pic_square", "TEXT")), new PrimaryKey(ImmutableList.of(sqlColumn)));
            return i3;
        } else if (i == 2) {
            m17943e(sQLiteDatabase);
            return i3;
        } else if (i == 3) {
            SQLiteDetour.a(1888513591);
            sQLiteDatabase.execSQL("ALTER TABLE threads ADD COLUMN other_user_fbid INTEGER");
            SQLiteDetour.a(513363310);
            return i3;
        } else if (i == 4) {
            m17944g(sQLiteDatabase);
            return i3;
        } else if (i == 5) {
            m17945h(sQLiteDatabase);
            return i3;
        } else if (i == 6) {
            SQLiteDetour.a(78416663);
            sQLiteDatabase.execSQL("ALTER TABLE threads ADD COLUMN snippet TEXT");
            SQLiteDetour.a(1580224200);
            SQLiteDetour.a(-1373693792);
            sQLiteDatabase.execSQL("ALTER TABLE threads ADD COLUMN snippet_sender_fbid INTEGER");
            SQLiteDetour.a(-1141645508);
            SQLiteDetour.a(288928879);
            sQLiteDatabase.execSQL("ALTER TABLE threads ADD COLUMN admin_snippet TEXT");
            SQLiteDetour.a(222197338);
            SQLiteDetour.a(595804457);
            sQLiteDatabase.execSQL("ALTER TABLE threads ADD COLUMN can_reply INTEGER");
            SQLiteDetour.a(-894002315);
            return i3;
        } else if (i == 7) {
            m17946j(sQLiteDatabase);
            return i3;
        } else if (i == 8) {
            SQLiteDetour.a(209991031);
            sQLiteDatabase.execSQL("ALTER TABLE thread_participants ADD COLUMN last_fetch_time_ms INTEGER");
            SQLiteDetour.a(-1727825845);
            return i3;
        } else if (i == 9) {
            m17947l(sQLiteDatabase);
            return i3;
        } else if (i == 10) {
            SQLiteDetour.a(-943534168);
            sQLiteDatabase.execSQL("ALTER TABLE pending_sessions ADD COLUMN packet_key TEXT");
            SQLiteDetour.a(-464552891);
            return i3;
        } else if (i == 11) {
            m17948n(sQLiteDatabase);
            return i3;
        } else if (i == 12) {
            SQLiteDetour.a(1308529049);
            sQLiteDatabase.execSQL("ALTER TABLE messages ADD COLUMN client_expiration_time_ms INTEGER");
            SQLiteDetour.a(1487124953);
            return i3;
        } else if (i == 13) {
            SQLiteDetour.a(731891011);
            sQLiteDatabase.execSQL("DELETE FROM threads");
            SQLiteDetour.a(687145213);
            SQLiteDetour.a(780421710);
            sQLiteDatabase.execSQL("DELETE FROM messages");
            SQLiteDetour.a(-337929423);
            SQLiteDetour.a(-331891564);
            sQLiteDatabase.execSQL("DELETE FROM identity_keys");
            SQLiteDetour.a(812428497);
            return i3;
        } else if (i == 14) {
            m17949q(sQLiteDatabase);
            return i3;
        } else if (i == 15) {
            m17950r(sQLiteDatabase);
            return i3;
        } else {
            ((AbstractFbErrorReporter) this.f17946a.get()).b("tincan_upgrade", "Database not upgraded incrementally.");
            String a = SqlTable.a("properties");
            SQLiteDetour.a(-2137844074);
            sQLiteDatabase.execSQL(a);
            SQLiteDetour.a(1011532650);
            a = SqlTable.a("threads");
            SQLiteDetour.a(-601333335);
            sQLiteDatabase.execSQL(a);
            SQLiteDetour.a(-584407464);
            a = SqlTable.a("messages");
            SQLiteDetour.a(-1105473800);
            sQLiteDatabase.execSQL(a);
            SQLiteDetour.a(148243685);
            a = SqlTable.a("thread_participants");
            SQLiteDetour.a(-1144331724);
            sQLiteDatabase.execSQL(a);
            SQLiteDetour.a(829641941);
            a = SqlTable.a("identity_keys");
            SQLiteDetour.a(-1060719348);
            sQLiteDatabase.execSQL(a);
            SQLiteDetour.a(-675773183);
            a = SqlTable.a("pending_sessions");
            SQLiteDetour.a(-1832348255);
            sQLiteDatabase.execSQL(a);
            SQLiteDetour.a(-1909500866);
            a = SqlTable.a("pre_keys");
            SQLiteDetour.a(-666410855);
            sQLiteDatabase.execSQL(a);
            SQLiteDetour.a(-903871515);
            a = SqlTable.a("signed_pre_keys");
            SQLiteDetour.a(-1629501130);
            sQLiteDatabase.execSQL(a);
            SQLiteDetour.a(-1467628774);
            a(sQLiteDatabase);
            return i2;
        }
    }

    private static void m17943e(SQLiteDatabase sQLiteDatabase) {
        SQLiteDetour.a(-1099014351);
        sQLiteDatabase.execSQL("ALTER TABLE messages ADD COLUMN sender_fbid INTEGER");
        SQLiteDetour.a(-1304003412);
        SqlColumn sqlColumn = new SqlColumn("msg_id", "TEXT");
        SQLiteDatabase sQLiteDatabase2 = sQLiteDatabase;
        SqlTable.a(sQLiteDatabase2, "messages", ImmutableList.of(sqlColumn, new SqlColumn("thread_key", "TEXT"), new SqlColumn("text_encrypted", "TEXT"), new SqlColumn("sender_fbid", "INTEGER"), new SqlColumn("timestamp_ms", "INTEGER"), new SqlColumn("timestamp_sent_ms", "INTEGER"), new SqlColumn("attachments_encrypted", "TEXT"), new SqlColumn("msg_type", "INTEGER"), new SqlColumn("offline_threading_id", "TEXT"), new SqlColumn("pending_send_media_attachment", "STRING"), new SqlColumn("send_error", "STRING"), new SqlColumn("send_error_message", "STRING"), new SqlColumn[]{new SqlColumn("send_error_timestamp_ms", "INTEGER"), new SqlColumn("admin_text_thread_message_lifetime", "INTEGER"), new SqlColumn("message_lifetime", "INTEGER")}), new PrimaryKey(ImmutableList.of(sqlColumn)));
        String b = SqlTable.b("messages", "messages_timestamp_index", ImmutableList.of("thread_key", "timestamp_ms DESC"));
        SQLiteDetour.a(1635003692);
        sQLiteDatabase.execSQL(b);
        SQLiteDetour.a(132100673);
        b = SqlTable.a("messages", "messages_offline_threading_id_index", ImmutableList.of(new SqlColumn("offline_threading_id", "TEXT")));
        SQLiteDetour.a(264801867);
        sQLiteDatabase.execSQL(b);
        SQLiteDetour.a(-89060909);
    }

    private static void m17944g(SQLiteDatabase sQLiteDatabase) {
        String a = SqlTable.a("identity_keys", ImmutableList.of(new SqlColumn("remote_name", "TEXT"), new SqlColumn("identity_key", "BLOB")), null);
        SQLiteDetour.a(530264166);
        sQLiteDatabase.execSQL(a);
        SQLiteDetour.a(-234592502);
    }

    private static void m17945h(SQLiteDatabase sQLiteDatabase) {
        String str = "identity_keys_temp";
        String str2 = "ALTER TABLE identity_keys RENAME TO " + str;
        SQLiteDetour.a(1158823887);
        sQLiteDatabase.execSQL(str2);
        SQLiteDetour.a(-757380207);
        str2 = SqlTable.a("identity_keys", ImmutableList.of(new SqlColumn("remote_name", "TEXT"), new SqlColumn("identity_key", "BLOB")), ImmutableList.of(new PrimaryKey(ImmutableList.of(new SqlColumn("remote_name", "TEXT")))));
        SQLiteDetour.a(2076061294);
        sQLiteDatabase.execSQL(str2);
        SQLiteDetour.a(-95854032);
        str2 = "INSERT INTO identity_keys SELECT * FROM " + str;
        SQLiteDetour.a(-484777480);
        sQLiteDatabase.execSQL(str2);
        SQLiteDetour.a(72301935);
        str = SqlTable.a(str);
        SQLiteDetour.a(-2144978324);
        sQLiteDatabase.execSQL(str);
        SQLiteDetour.a(-1093548797);
    }

    private static void m17946j(SQLiteDatabase sQLiteDatabase) {
        String a = SqlTable.a("threads", new SqlColumn("thread_name", "TEXT"));
        SQLiteDetour.a(508529114);
        sQLiteDatabase.execSQL(a);
        SQLiteDetour.a(-1216183177);
        SqlColumn sqlColumn = new SqlColumn("thread_key", "TEXT");
        SQLiteDatabase sQLiteDatabase2 = sQLiteDatabase;
        SqlTable.a(sQLiteDatabase2, "threads", ImmutableList.of(sqlColumn, new SqlColumn("other_user_fbid", "INTEGER"), new SqlColumn("thread_name", "TEXT"), new SqlColumn("timestamp_ms", "INTEGER"), new SqlColumn("last_read_timestamp_ms", "INTEGER"), new SqlColumn("mute_until", "INTEGER"), new SqlColumn("session_state", "TEXT"), new SqlColumn("draft", "TEXT"), new SqlColumn("snippet", "TEXT"), new SqlColumn("snippet_sender_fbid", "INTEGER"), new SqlColumn("admin_snippet", "TEXT"), new SqlColumn("can_reply", "INTEGER"), new SqlColumn[]{new SqlColumn("outgoing_message_lifetime", "INTEGER"), new SqlColumn("last_read_receipt_time", "INTEGER"), new SqlColumn("last_delivered_receipt_time", "INTEGER"), new SqlColumn("last_delivered_receipt_message_id", "TEXT")}), new PrimaryKey(ImmutableList.of(sqlColumn)));
    }

    private static void m17947l(SQLiteDatabase sQLiteDatabase) {
        SqlColumn sqlColumn = new SqlColumn("thread_key", "TEXT");
        String a = SqlTable.a("pending_sessions", ImmutableList.of(sqlColumn, new SqlColumn("session_state", "BLOB")), ImmutableList.of(new PrimaryKey(ImmutableList.of(sqlColumn))));
        SQLiteDetour.a(1374460006);
        sQLiteDatabase.execSQL(a);
        SQLiteDetour.a(-1887054634);
    }

    private static void m17948n(SQLiteDatabase sQLiteDatabase) {
        String a = SqlTable.a("threads", new SqlColumn("outgoing_message_lifetime_ms", "INTEGER"));
        SQLiteDetour.a(798838926);
        sQLiteDatabase.execSQL(a);
        SQLiteDetour.a(708358028);
        a = SqlTable.a("threads", new SqlColumn("last_read_receipt_time_ms", "INTEGER"));
        SQLiteDetour.a(-996972476);
        sQLiteDatabase.execSQL(a);
        SQLiteDetour.a(-1323519454);
        a = SqlTable.a("threads", new SqlColumn("last_delivered_receipt_time_ms", "INTEGER"));
        SQLiteDetour.a(391369620);
        sQLiteDatabase.execSQL(a);
        SQLiteDetour.a(88738273);
        SqlColumn sqlColumn = new SqlColumn("thread_key", "TEXT");
        SQLiteDatabase sQLiteDatabase2 = sQLiteDatabase;
        SqlTable.a(sQLiteDatabase2, "threads", ImmutableList.of(sqlColumn, new SqlColumn("other_user_fbid", "INTEGER"), new SqlColumn("thread_name", "TEXT"), new SqlColumn("timestamp_ms", "INTEGER"), new SqlColumn("last_read_timestamp_ms", "INTEGER"), new SqlColumn("session_state", "TEXT"), new SqlColumn("draft", "TEXT"), new SqlColumn("snippet", "TEXT"), new SqlColumn("snippet_sender_fbid", "INTEGER"), new SqlColumn("admin_snippet", "TEXT"), new SqlColumn("can_reply", "INTEGER"), new SqlColumn("outgoing_message_lifetime_ms", "INTEGER"), new SqlColumn[]{new SqlColumn("last_read_receipt_time_ms", "INTEGER"), new SqlColumn("last_delivered_receipt_time_ms", "INTEGER")}), new PrimaryKey(ImmutableList.of(sqlColumn)));
        sqlColumn = new SqlColumn("msg_id", "TEXT");
        sQLiteDatabase2 = sQLiteDatabase;
        SqlTable.a(sQLiteDatabase2, "messages", ImmutableList.of(sqlColumn, new SqlColumn("thread_key", "TEXT"), new SqlColumn("text_encrypted", "TEXT"), new SqlColumn("sender_fbid", "INTEGER"), new SqlColumn("timestamp_ms", "INTEGER"), new SqlColumn("timestamp_sent_ms", "INTEGER"), new SqlColumn("attachments_encrypted", "TEXT"), new SqlColumn("msg_type", "INTEGER"), new SqlColumn("offline_threading_id", "TEXT"), new SqlColumn("pending_send_media_attachment", "STRING"), new SqlColumn("send_error", "STRING"), new SqlColumn("send_error_message", "STRING"), new SqlColumn[]{new SqlColumn("send_error_timestamp_ms", "INTEGER")}), new PrimaryKey(ImmutableList.of(sqlColumn)));
        a = SqlTable.b("messages", "messages_timestamp_index", ImmutableList.of("thread_key", "timestamp_ms DESC"));
        SQLiteDetour.a(-213376559);
        sQLiteDatabase.execSQL(a);
        SQLiteDetour.a(91030470);
        a = SqlTable.a("messages", "messages_offline_threading_id_index", ImmutableList.of(new SqlColumn("offline_threading_id", "TEXT")));
        SQLiteDetour.a(194096996);
        sQLiteDatabase.execSQL(a);
        SQLiteDetour.a(457734601);
    }

    @SuppressLint({"NewApi"})
    private void m17949q(SQLiteDatabase sQLiteDatabase) {
        Throwable th;
        SQLiteDetour.a(-977370903);
        sQLiteDatabase.execSQL("ALTER TABLE threads ADD COLUMN encryption_key BLOB");
        SQLiteDetour.a(-56045059);
        String str = "threads_temp";
        String str2 = "ALTER TABLE threads RENAME TO " + str;
        SQLiteDetour.a(-693853802);
        sQLiteDatabase.execSQL(str2);
        SQLiteDetour.a(488604285);
        str2 = SqlTable.a("threads", ImmutableList.of(new SqlColumn("thread_key", "TEXT"), new SqlColumn("other_user_fbid", "INTEGER"), new SqlColumn("thread_name", "TEXT"), new SqlColumn("timestamp_ms", "INTEGER"), new SqlColumn("last_read_timestamp_ms", "INTEGER"), new SqlColumn("session_state", "BLOB"), new SqlColumn("draft", "TEXT"), new SqlColumn("snippet", "TEXT"), new SqlColumn("snippet_sender_fbid", "INTEGER"), new SqlColumn("admin_snippet", "TEXT"), new SqlColumn("can_reply", "INTEGER"), new SqlColumn("outgoing_message_lifetime_ms", "INTEGER"), new SqlColumn[]{new SqlColumn("last_read_receipt_time_ms", "INTEGER"), new SqlColumn("last_delivered_receipt_time_ms", "INTEGER"), new SqlColumn("encryption_key", "BLOB")}), ImmutableList.of(new PrimaryKey(ImmutableList.of(new SqlColumn("thread_key", "TEXT")))));
        SQLiteDetour.a(1745847908);
        sQLiteDatabase.execSQL(str2);
        SQLiteDetour.a(-408761653);
        Map hashMap = new HashMap();
        Throwable th2;
        try {
            ContentValues contentValues;
            Cursor rawQuery;
            Cursor rawQuery2 = sQLiteDatabase.rawQuery("SELECT * FROM " + str, null);
            Throwable th3 = null;
            while (rawQuery2.moveToNext()) {
                try {
                    contentValues = new ContentValues();
                    DatabaseUtils.cursorRowToContentValues(rawQuery2, contentValues);
                    Object a = ((DbCrypto) this.f17947b.get()).a();
                    hashMap.put(contentValues.getAsString("thread_key"), a);
                    contentValues.put("encryption_key", ((DbCrypto) this.f17947b.get()).a(a));
                    contentValues.put("session_state", ((DbCrypto) this.f17947b.get()).a(a, contentValues.getAsString("session_state").getBytes()));
                    SQLiteDetour.a(-498644064);
                    sQLiteDatabase.insert("threads", null, contentValues);
                    SQLiteDetour.a(1415420663);
                } catch (Throwable th32) {
                    th = th32;
                    th32 = th2;
                    th2 = th;
                }
            }
            if (rawQuery2 != null) {
                rawQuery2.close();
            }
            str2 = SqlTable.a(str);
            SQLiteDetour.a(-164851405);
            sQLiteDatabase.execSQL(str2);
            SQLiteDetour.a(-445301122);
            str = "messages_temp";
            str2 = "ALTER TABLE messages RENAME TO " + str;
            SQLiteDetour.a(-2108008705);
            sQLiteDatabase.execSQL(str2);
            SQLiteDetour.a(116025153);
            str2 = SqlTable.a("messages", ImmutableList.of(new SqlColumn("msg_id", "TEXT"), new SqlColumn("thread_key", "TEXT"), new SqlColumn("encrypted_content", "BLOB"), new SqlColumn("sender_fbid", "INTEGER"), new SqlColumn("timestamp_ms", "INTEGER"), new SqlColumn("timestamp_sent_ms", "INTEGER"), new SqlColumn("attachments_encrypted", "TEXT"), new SqlColumn("msg_type", "INTEGER"), new SqlColumn("offline_threading_id", "TEXT"), new SqlColumn("pending_send_media_attachment", "STRING"), new SqlColumn("send_error", "STRING"), new SqlColumn("send_error_message", "STRING"), new SqlColumn[]{new SqlColumn("send_error_timestamp_ms", "INTEGER"), new SqlColumn("client_expiration_time_ms", "INTEGER")}), ImmutableList.of(new PrimaryKey(ImmutableList.of(new SqlColumn("msg_id", "TEXT")))));
            SQLiteDetour.a(-1689354097);
            sQLiteDatabase.execSQL(str2);
            SQLiteDetour.a(379276363);
            try {
                byte[] bArr;
                rawQuery = sQLiteDatabase.rawQuery("SELECT * FROM " + str, null);
                while (rawQuery.moveToNext()) {
                    try {
                        ContentValues contentValues2 = new ContentValues();
                        DatabaseUtils.cursorRowToContentValues(rawQuery, contentValues2);
                        str2 = contentValues2.getAsString("thread_key");
                        bArr = (byte[]) hashMap.get(str2);
                        bArr = ((DbCrypto) this.f17947b.get()).a(bArr, Base64.decode(contentValues2.getAsString("text_encrypted"), 0));
                        contentValues2.remove("text_encrypted");
                        contentValues2.put("encrypted_content", bArr);
                        SQLiteDetour.a(-312780577);
                        sQLiteDatabase.insert("messages", null, contentValues2);
                        SQLiteDetour.a(865585425);
                    } catch (Throwable th322) {
                        th = th322;
                        th322 = th2;
                        th2 = th;
                    }
                }
                if (rawQuery != null) {
                    rawQuery.close();
                }
                str2 = SqlTable.a(str);
                SQLiteDetour.a(817355419);
                sQLiteDatabase.execSQL(str2);
                SQLiteDetour.a(1753607775);
                str2 = SqlTable.b("messages", "messages_timestamp_index", ImmutableList.of("thread_key", "timestamp_ms DESC"));
                SQLiteDetour.a(1470614021);
                sQLiteDatabase.execSQL(str2);
                SQLiteDetour.a(-1859734135);
                str2 = SqlTable.a("messages", "messages_offline_threading_id_index", ImmutableList.of(new SqlColumn("offline_threading_id", "TEXT")));
                SQLiteDetour.a(-675223886);
                sQLiteDatabase.execSQL(str2);
                SQLiteDetour.a(2192597);
                SQLiteDetour.a(-1766200681);
                sQLiteDatabase.execSQL("ALTER TABLE pending_sessions ADD COLUMN encryption_key BLOB");
                SQLiteDetour.a(369782768);
                try {
                    rawQuery2 = sQLiteDatabase.rawQuery("SELECT * FROM pending_sessions", null);
                    th322 = null;
                    while (rawQuery2.moveToNext()) {
                        try {
                            contentValues = new ContentValues();
                            DatabaseUtils.cursorRowToContentValues(rawQuery2, contentValues);
                            String asString = contentValues.getAsString("thread_key");
                            byte[] a2 = ((DbCrypto) this.f17947b.get()).a();
                            byte[] a3 = ((DbCrypto) this.f17947b.get()).a(a2);
                            bArr = ((DbCrypto) this.f17947b.get()).a(a2, contentValues.getAsString("session_state").getBytes());
                            contentValues = new ContentValues();
                            contentValues.put("session_state", bArr);
                            contentValues.put("encryption_key", a3);
                            Expression a4 = Columns.f17924a.a(asString);
                            sQLiteDatabase.update("pending_sessions", contentValues, a4.a(), a4.b());
                        } catch (Throwable th3222) {
                            th = th3222;
                            th3222 = th2;
                            th2 = th;
                        }
                    }
                    if (rawQuery2 != null) {
                        rawQuery2.close();
                        return;
                    }
                    return;
                } catch (KeyChainException e) {
                    th2 = e;
                    throw new RuntimeException("Failed to encrypt thread's session during db upgrade to v14", th2);
                } catch (CryptoInitializationException e2) {
                    th2 = e2;
                    throw new RuntimeException("Failed to encrypt thread's session during db upgrade to v14", th2);
                } catch (IOException e3) {
                    th2 = e3;
                    throw new RuntimeException("Failed to encrypt thread's session during db upgrade to v14", th2);
                }
            } catch (KeyChainException e4) {
                th2 = e4;
                throw new RuntimeException("Failed to encrypt thread's session during db upgrade to v14", th2);
            } catch (CryptoInitializationException e5) {
                th2 = e5;
                throw new RuntimeException("Failed to encrypt thread's session during db upgrade to v14", th2);
            } catch (IOException e6) {
                th2 = e6;
                throw new RuntimeException("Failed to encrypt thread's session during db upgrade to v14", th2);
            }
            if (rawQuery != null) {
                if (th3222 != null) {
                    try {
                        rawQuery.close();
                    } catch (Throwable th4) {
                        AndroidCompat.addSuppressed(th3222, th4);
                    }
                } else {
                    rawQuery.close();
                }
            }
            throw th2;
            if (rawQuery2 != null) {
                if (th3222 != null) {
                    try {
                        rawQuery2.close();
                    } catch (Throwable th42) {
                        AndroidCompat.addSuppressed(th3222, th42);
                    }
                } else {
                    rawQuery2.close();
                }
            }
            throw th2;
            if (rawQuery2 != null) {
                if (th3222 != null) {
                    try {
                        rawQuery2.close();
                    } catch (Throwable th422) {
                        AndroidCompat.addSuppressed(th3222, th422);
                    }
                } else {
                    rawQuery2.close();
                }
            }
            throw th2;
            throw th2;
            throw th2;
            throw th2;
        } catch (KeyChainException e7) {
            th2 = e7;
            throw new RuntimeException("Failed to encrypt thread's session during db upgrade to v14", th2);
        } catch (CryptoInitializationException e8) {
            th2 = e8;
            throw new RuntimeException("Failed to encrypt thread's session during db upgrade to v14", th2);
        } catch (IOException e9) {
            th2 = e9;
            throw new RuntimeException("Failed to encrypt thread's session during db upgrade to v14", th2);
        }
    }

    private static void m17950r(SQLiteDatabase sQLiteDatabase) {
        ImmutableList of = ImmutableList.of(new SqlColumn("id", "TEXT"), new SqlColumn("key", "BLOB"), new SqlColumn("timestamp_ms", "INTEGER"));
        String a = SqlTable.a("pre_keys", of, ImmutableList.of(new PrimaryKey(ImmutableList.of(new SqlColumn("id", "TEXT")))));
        SQLiteDetour.a(-174941872);
        sQLiteDatabase.execSQL(a);
        SQLiteDetour.a(28626890);
        String a2 = SqlTable.a("signed_pre_keys", of, ImmutableList.of(new PrimaryKey(ImmutableList.of(new SqlColumn("id", "TEXT")))));
        SQLiteDetour.a(-1383866143);
        sQLiteDatabase.execSQL(a2);
        SQLiteDetour.a(-1406329148);
    }
}
