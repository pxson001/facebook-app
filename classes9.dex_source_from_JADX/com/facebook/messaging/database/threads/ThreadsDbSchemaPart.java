package com.facebook.messaging.database.threads;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.json.FbObjectMapper;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.database.properties.DbPropertyUtil;
import com.facebook.database.sqlite.SqlColumn;
import com.facebook.database.sqlite.SqlExpression;
import com.facebook.database.sqlite.SqlExpression.ConjunctionExpression;
import com.facebook.database.sqlite.SqlExpression.Expression;
import com.facebook.database.sqlite.SqlKeys.ForeignKey;
import com.facebook.database.sqlite.SqlKeys.PrimaryKey;
import com.facebook.database.sqlite.SqlKeys.SqlKey;
import com.facebook.database.sqlite.SqlTable;
import com.facebook.database.supplier.TablesDbSchemaPart;
import com.facebook.debug.log.BLog;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.messaging.model.folders.FolderName;
import com.facebook.messaging.model.messages.MessageType;
import com.facebook.tools.dextr.runtime.detour.SQLiteDetour;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.collect.ImmutableBiMap;
import com.google.common.collect.ImmutableList;
import javax.inject.Inject;
import javax.inject.Singleton;
import org.json.JSONObject;

@Singleton
/* compiled from: max_age */
public class ThreadsDbSchemaPart extends TablesDbSchemaPart {
    private static volatile ThreadsDbSchemaPart f10818c;
    private final Lazy<DbThreadParticipantsUtil> f10819a;
    private final Lazy<FbErrorReporter> f10820b;

    /* compiled from: max_age */
    public class EventReminderMembersTable extends SqlTable {
        private static final SqlKey f10664a = new PrimaryKey(ImmutableList.of(Columns.f10661a, Columns.f10662b));
        private static final ImmutableList<SqlColumn> f10665b = ImmutableList.of(Columns.f10661a, Columns.f10662b, Columns.f10663c);

        /* compiled from: max_age */
        public final class Columns {
            public static final SqlColumn f10661a = new SqlColumn("event_reminder_key", "TEXT");
            public static final SqlColumn f10662b = new SqlColumn("user_key", "TEXT");
            public static final SqlColumn f10663c = new SqlColumn("member_guest_status", "TEXT");
        }

        public EventReminderMembersTable() {
            super("event_reminder_members", f10665b, ImmutableList.of(f10664a));
        }

        public final void m11183a(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        }
    }

    /* compiled from: max_age */
    public class EventRemindersTable extends SqlTable {
        private static final SqlKey f10671a = new PrimaryKey(ImmutableList.of(Columns.f10667b));
        private static final SqlKey f10672b = new ForeignKey(ImmutableList.of(Columns.f10666a), "threads", ImmutableList.of(Columns.f10789a), "ON DELETE CASCADE");
        private static final ImmutableList<SqlColumn> f10673c = ImmutableList.of(Columns.f10666a, Columns.f10667b, Columns.f10668c, Columns.f10669d, Columns.f10670e);

        /* compiled from: max_age */
        public final class Columns {
            public static final SqlColumn f10666a = new SqlColumn("thread_key", "TEXT");
            public static final SqlColumn f10667b = new SqlColumn("event_reminder_key", "TEXT");
            public static final SqlColumn f10668c = new SqlColumn("event_reminder_timestamp", "INTEGER");
            public static final SqlColumn f10669d = new SqlColumn("event_reminder_title", "TEXT");
            public static final SqlColumn f10670e = new SqlColumn("allows_rsvp", "INTEGER");
        }

        public EventRemindersTable() {
            super("event_reminders", f10673c, ImmutableList.of(f10671a, f10672b));
        }

        public final void m11184a(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        }
    }

    /* compiled from: max_age */
    public final class FolderCountsTable extends SqlTable {
        private static final SqlKey f10679a = new PrimaryKey(ImmutableList.of(Columns.f10674a));
        private static final ImmutableList<SqlColumn> f10680b = ImmutableList.of(Columns.f10674a, Columns.f10675b, Columns.f10676c, Columns.f10677d, Columns.f10678e);

        /* compiled from: max_age */
        final class Columns {
            public static final SqlColumn f10674a = new SqlColumn("folder", "TEXT");
            public static final SqlColumn f10675b = new SqlColumn("unread_count", "INTEGER");
            public static final SqlColumn f10676c = new SqlColumn("unseen_count", "INTEGER");
            public static final SqlColumn f10677d = new SqlColumn("last_seen_time", "INTEGER");
            public static final SqlColumn f10678e = new SqlColumn("last_action_id", "INTEGER");
        }

        public FolderCountsTable() {
            super("folder_counts", f10680b, f10679a);
        }

        public final void m11185a(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        }
    }

    /* compiled from: max_age */
    public final class FoldersTable extends SqlTable {
        private static final SqlKey f10684a = new PrimaryKey(ImmutableList.of(Columns.f10682b));
        private static final ImmutableList<SqlColumn> f10685b = ImmutableList.of(Columns.f10681a, Columns.f10682b, Columns.f10683c);
        public static final String f10686c = SqlTable.b("folders", "folders_timestamp_index", ImmutableList.of(Columns.f10681a.d, Columns.f10683c.d + " DESC"));

        /* compiled from: max_age */
        public class Columns {
            public static final SqlColumn f10681a = new SqlColumn("folder", "TEXT");
            public static final SqlColumn f10682b = new SqlColumn("thread_key", "TEXT");
            public static final SqlColumn f10683c = new SqlColumn("timestamp_ms", "INTEGER");
        }

        public FoldersTable() {
            super("folders", f10685b, f10684a);
        }

        public final void m11186a(SQLiteDatabase sQLiteDatabase) {
            super.a(sQLiteDatabase);
            String str = f10686c;
            SQLiteDetour.a(-1145788169);
            sQLiteDatabase.execSQL(str);
            SQLiteDetour.a(-907048154);
        }

        public final void m11187a(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        }
    }

    /* compiled from: max_age */
    public class GroupConversationsTable extends SqlTable {
        private static final SqlKey f10690a = new PrimaryKey(ImmutableList.of(Columns.f10687a));
        private static final ImmutableList<SqlColumn> f10691b = ImmutableList.of(Columns.f10687a, Columns.f10688b, Columns.f10689c);

        /* compiled from: max_age */
        final class Columns {
            public static final SqlColumn f10687a = new SqlColumn("thread_key", "TEXT");
            public static final SqlColumn f10688b = new SqlColumn("rank", "FLOAT");
            public static final SqlColumn f10689c = new SqlColumn("group_chat_rank", "FLOAT");
        }

        public GroupConversationsTable() {
            super("group_conversations", f10691b, f10690a);
        }

        public final void m11188a(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        }
    }

    /* compiled from: max_age */
    public final class MessagesTable extends SqlTable {
        private static final SqlKey f10744a = new PrimaryKey(ImmutableList.of(Columns.f10718a));
        private static final ImmutableList<SqlColumn> f10745b = ImmutableList.of(Columns.f10718a, Columns.f10719b, Columns.f10720c, Columns.f10721d, Columns.f10722e, Columns.f10723f, Columns.f10724g, Columns.f10725h, Columns.f10726i, Columns.f10727j, Columns.f10728k, Columns.f10729l, new SqlColumn[]{Columns.f10730m, Columns.f10731n, Columns.f10732o, Columns.f10733p, Columns.f10734q, Columns.f10735r, Columns.f10736s, Columns.f10737t, Columns.f10738u, Columns.f10739v, Columns.f10740w, Columns.f10741x, Columns.f10742y, Columns.f10743z, Columns.f10692A, Columns.f10693B, Columns.f10694C, Columns.f10695D, Columns.f10696E, Columns.f10697F, Columns.f10698G, Columns.f10699H, Columns.f10700I, Columns.f10701J, Columns.f10702K, Columns.f10703L, Columns.f10704M, Columns.f10705N, Columns.f10706O, Columns.f10707P, Columns.f10708Q, Columns.f10709R, Columns.f10710S, Columns.f10711T, Columns.f10712U, Columns.f10713V, Columns.f10714W, Columns.f10715X, Columns.f10716Y, Columns.f10717Z, Columns.aa, Columns.ab, Columns.ac, Columns.ad, Columns.ae, Columns.af, Columns.ag});
        public static final String f10746c = SqlTable.b("messages", "messages_timestamp_index", ImmutableList.of(Columns.f10719b.d, Columns.f10724g + " DESC"));
        public static final String f10747d = SqlTable.a("messages", "messages_offline_threading_id_index", ImmutableList.of(Columns.f10732o));
        public static final String f10748e = SqlTable.a("messages", "messages_type_index", ImmutableList.of(Columns.f10719b, Columns.f10729l, Columns.f10724g));

        /* compiled from: max_age */
        final class Columns {
            public static final SqlColumn f10692A = new SqlColumn("send_error_error_url", "STRING");
            public static final SqlColumn f10693B = new SqlColumn("publicity", "TEXT");
            public static final SqlColumn f10694C = new SqlColumn("send_queue_type", "TEXT");
            public static final SqlColumn f10695D = new SqlColumn("payment_transaction", "TEXT");
            public static final SqlColumn f10696E = new SqlColumn("payment_request", "TEXT");
            public static final SqlColumn f10697F = new SqlColumn("has_unavailable_attachment", "INTEGER");
            public static final SqlColumn f10698G = new SqlColumn("app_attribution", "TEXT");
            public static final SqlColumn f10699H = new SqlColumn("content_app_attribution", "TEXT");
            public static final SqlColumn f10700I = new SqlColumn("xma", "TEXT");
            public static final SqlColumn f10701J = new SqlColumn("admin_text_type", "INTEGER");
            public static final SqlColumn f10702K = new SqlColumn("admin_text_theme_color", "INTEGER");
            public static final SqlColumn f10703L = new SqlColumn("admin_text_thread_icon_emoji", "TEXT");
            public static final SqlColumn f10704M = new SqlColumn("admin_text_nickname", "TEXT");
            public static final SqlColumn f10705N = new SqlColumn("admin_text_target_id", "TEXT");
            public static final SqlColumn f10706O = new SqlColumn("admin_text_thread_message_lifetime", "INTEGER");
            public static final SqlColumn f10707P = new SqlColumn("admin_text_thread_journey_color_choices", "TEXT");
            public static final SqlColumn f10708Q = new SqlColumn("admin_text_thread_journey_emoji_choices", "TEXT");
            public static final SqlColumn f10709R = new SqlColumn("admin_text_thread_journey_nickname_choices", "TEXT");
            public static final SqlColumn f10710S = new SqlColumn("admin_text_thread_journey_bot_choices", "TEXT");
            public static final SqlColumn f10711T = new SqlColumn("message_lifetime", "INTEGER");
            public static final SqlColumn f10712U = new SqlColumn("admin_text_thread_rtc_event", "TEXT");
            public static final SqlColumn f10713V = new SqlColumn("admin_text_thread_rtc_server_info_data", "TEXT");
            public static final SqlColumn f10714W = new SqlColumn("admin_text_thread_rtc_is_video_call", "INTEGER");
            public static final SqlColumn f10715X = new SqlColumn("admin_text_thread_ride_provider_name", "TEXT");
            public static final SqlColumn f10716Y = new SqlColumn("is_sponsored", "INTEGER");
            public static final SqlColumn f10717Z = new SqlColumn("admin_text_thread_ad_properties", "TEXT");
            public static final SqlColumn f10718a = new SqlColumn("msg_id", "TEXT");
            public static final SqlColumn aa = new SqlColumn("admin_text_game_score_data", "TEXT");
            public static final SqlColumn ab = new SqlColumn("admin_text_thread_event_reminder_properties", "TEXT");
            public static final SqlColumn ac = new SqlColumn("commerce_message_type", "TEXT");
            public static final SqlColumn ad = new SqlColumn("customizations", "TEXT");
            public static final SqlColumn ae = new SqlColumn("admin_text_joinable_event_type", "TEXT");
            public static final SqlColumn af = new SqlColumn("metadata_at_text_ranges", "TEXT");
            public static final SqlColumn ag = new SqlColumn("platform_metadata", "TEXT");
            public static final SqlColumn f10719b = new SqlColumn("thread_key", "TEXT");
            public static final SqlColumn f10720c = new SqlColumn("action_id", "INTEGER");
            public static final SqlColumn f10721d = new SqlColumn("text", "TEXT");
            public static final SqlColumn f10722e = new SqlColumn("sender", "TEXT");
            public static final SqlColumn f10723f = new SqlColumn("is_not_forwardable", "INTEGER");
            public static final SqlColumn f10724g = new SqlColumn("timestamp_ms", "INTEGER");
            public static final SqlColumn f10725h = new SqlColumn("timestamp_sent_ms", "INTEGER");
            public static final SqlColumn f10726i = new SqlColumn("attachments", "TEXT");
            public static final SqlColumn f10727j = new SqlColumn("shares", "TEXT");
            public static final SqlColumn f10728k = new SqlColumn("sticker_id", "TEXT");
            public static final SqlColumn f10729l = new SqlColumn("msg_type", "INTEGER");
            public static final SqlColumn f10730m = new SqlColumn("affected_users", "TEXT");
            public static final SqlColumn f10731n = new SqlColumn("coordinates", "TEXT");
            public static final SqlColumn f10732o = new SqlColumn("offline_threading_id", "TEXT");
            public static final SqlColumn f10733p = new SqlColumn("source", "TEXT");
            public static final SqlColumn f10734q = new SqlColumn("channel_source", "TEXT");
            public static final SqlColumn f10735r = new SqlColumn("send_channel", "TEXT");
            public static final SqlColumn f10736s = new SqlColumn("is_non_authoritative", "INTEGER");
            public static final SqlColumn f10737t = new SqlColumn("pending_send_media_attachment", "STRING");
            public static final SqlColumn f10738u = new SqlColumn("sent_share_attachment", "STRING");
            public static final SqlColumn f10739v = new SqlColumn("client_tags", "TEXT");
            public static final SqlColumn f10740w = new SqlColumn("send_error", "STRING");
            public static final SqlColumn f10741x = new SqlColumn("send_error_message", "STRING");
            public static final SqlColumn f10742y = new SqlColumn("send_error_number", "INTEGER");
            public static final SqlColumn f10743z = new SqlColumn("send_error_timestamp_ms", "INTEGER");
        }

        public MessagesTable() {
            super("messages", f10745b, f10744a);
        }

        public final void m11189a(SQLiteDatabase sQLiteDatabase) {
            super.a(sQLiteDatabase);
            String str = f10746c;
            SQLiteDetour.a(143826636);
            sQLiteDatabase.execSQL(str);
            SQLiteDetour.a(-1107386920);
            str = f10747d;
            SQLiteDetour.a(552394418);
            sQLiteDatabase.execSQL(str);
            SQLiteDetour.a(1950348096);
            str = f10748e;
            SQLiteDetour.a(701751319);
            sQLiteDatabase.execSQL(str);
            SQLiteDetour.a(-742011996);
        }

        public final void m11190a(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        }
    }

    /* compiled from: max_age */
    public class PinnedThreadsTable extends SqlTable {
        private static final SqlKey f10751a = new PrimaryKey(ImmutableList.of(Columns.f10749a));
        private static final ImmutableList<SqlColumn> f10752b = ImmutableList.of(Columns.f10749a, Columns.f10750b);

        /* compiled from: max_age */
        final class Columns {
            public static final SqlColumn f10749a = new SqlColumn("thread_key", "TEXT");
            public static final SqlColumn f10750b = new SqlColumn("display_order", "INTEGER");
        }

        public PinnedThreadsTable() {
            super("pinned_threads", f10752b, f10751a);
        }

        public final void m11191a(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        }
    }

    /* compiled from: max_age */
    public final class PropertiesTable extends SqlTable {
        private static final ImmutableList<SqlColumn> f10753a = ImmutableList.of(DbPropertyUtil.a, DbPropertyUtil.b);

        public PropertiesTable() {
            super("properties", f10753a);
        }

        public final void m11192a(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        }
    }

    /* compiled from: max_age */
    public class RankedThreadsTable extends SqlTable {
        public static final SqlKey f10756a = new PrimaryKey(ImmutableList.of(Columns.f10754a));
        public static final ImmutableList<SqlColumn> f10757b = ImmutableList.of(Columns.f10754a, Columns.f10755b);

        /* compiled from: max_age */
        final class Columns {
            public static final SqlColumn f10754a = new SqlColumn("thread_key", "TEXT");
            public static final SqlColumn f10755b = new SqlColumn("display_order", "INTEGER");
        }

        public RankedThreadsTable() {
            super("ranked_threads", f10757b, f10756a);
        }

        public final void m11193a(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        }
    }

    /* compiled from: max_age */
    public class ThreadParticipantsTable extends SqlTable {
        private static final SqlKey f10768a = new PrimaryKey(ImmutableList.of(Columns.f10758a, Columns.f10759b));
        private static final SqlKey f10769b = new ForeignKey(ImmutableList.of(Columns.f10758a), "threads", ImmutableList.of(Columns.f10789a), "ON DELETE CASCADE");
        private static final ImmutableList<SqlColumn> f10770c = ImmutableList.of(Columns.f10758a, Columns.f10759b, Columns.f10760c, Columns.f10761d, Columns.f10762e, Columns.f10766i, Columns.f10763f, Columns.f10764g, Columns.f10765h, Columns.f10767j);

        /* compiled from: max_age */
        public final class Columns {
            public static final SqlColumn f10758a = new SqlColumn("thread_key", "TEXT");
            public static final SqlColumn f10759b = new SqlColumn("user_key", "TEXT");
            public static final SqlColumn f10760c = new SqlColumn("email", "TEXT");
            public static final SqlColumn f10761d = new SqlColumn("phone", "TEXT");
            public static final SqlColumn f10762e = new SqlColumn("type", "TEXT NOT NULL");
            public static final SqlColumn f10763f = new SqlColumn("last_read_receipt_time", "INTEGER");
            public static final SqlColumn f10764g = new SqlColumn("last_delivered_receipt_time", "INTEGER");
            public static final SqlColumn f10765h = new SqlColumn("last_delivered_receipt_id", "TEXT");
            public static final SqlColumn f10766i = new SqlColumn("is_admin", "INTEGER");
            public static final SqlColumn f10767j = new SqlColumn("request_timestamp_ms", "INTEGER");
        }

        public ThreadParticipantsTable() {
            super("thread_participants", f10770c, ImmutableList.of(f10768a, f10769b));
        }

        public final void m11194a(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        }
    }

    /* compiled from: max_age */
    public final class ThreadUsersTable extends SqlTable {
        private static final SqlKey f10771a = new PrimaryKey(ImmutableList.of(Columns.a));
        private static final ImmutableList<SqlColumn> f10772b = ImmutableList.of(Columns.a, Columns.b, Columns.c, Columns.e, Columns.d, Columns.f, Columns.g, Columns.h, Columns.i, Columns.k, Columns.l, Columns.m, new SqlColumn[]{Columns.n, Columns.j, Columns.o, Columns.p, Columns.q, Columns.r, Columns.s, Columns.t, Columns.u, Columns.v, Columns.w, Columns.x, Columns.y, Columns.z});

        public ThreadUsersTable() {
            super("thread_users", f10772b, f10771a);
        }

        public final void m11195a(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        }
    }

    /* compiled from: max_age */
    public final class ThreadsTable extends SqlTable {
        private static final SqlKey f10815a = new PrimaryKey(ImmutableList.of(Columns.f10789a));
        private static final ImmutableList<SqlColumn> f10816b = ImmutableList.of(Columns.f10789a, Columns.f10790b, Columns.f10791c, Columns.f10792d, Columns.f10793e, Columns.f10794f, Columns.f10795g, Columns.f10796h, Columns.f10797i, Columns.f10798j, Columns.f10799k, Columns.f10800l, new SqlColumn[]{Columns.f10801m, Columns.f10802n, Columns.f10803o, Columns.f10804p, Columns.f10805q, Columns.f10806r, Columns.f10807s, Columns.f10808t, Columns.f10809u, Columns.f10810v, Columns.f10811w, Columns.f10812x, Columns.f10813y, Columns.f10814z, Columns.f10773A, Columns.f10774B, Columns.f10775C, Columns.f10776D, Columns.f10777E, Columns.f10778F, Columns.f10779G, Columns.f10780H, Columns.f10781I, Columns.f10782J, Columns.f10783K, Columns.f10784L, Columns.f10785M, Columns.f10786N, Columns.f10787O, Columns.f10788P});
        public static final String f10817c = SqlTable.a("threads", "threads_legacy_thread_id_index", ImmutableList.of(Columns.f10790b));

        /* compiled from: max_age */
        final class Columns {
            public static final SqlColumn f10773A = new SqlColumn("other_bubble_color", "INTEGER");
            public static final SqlColumn f10774B = new SqlColumn("wallpaper_color", "INTEGER");
            public static final SqlColumn f10775C = new SqlColumn("last_fetch_action_id", "INTEGER");
            public static final SqlColumn f10776D = new SqlColumn("initial_fetch_complete", "INTEGER");
            public static final SqlColumn f10777E = new SqlColumn("custom_like_emoji", "TEXT");
            public static final SqlColumn f10778F = new SqlColumn("outgoing_message_lifetime", "INTEGER");
            public static final SqlColumn f10779G = new SqlColumn("custom_nicknames", "TEXT");
            public static final SqlColumn f10780H = new SqlColumn("invite_uri", "TEXT");
            public static final SqlColumn f10781I = new SqlColumn("is_last_message_sponsored", "INTEGER");
            public static final SqlColumn f10782J = new SqlColumn("group_chat_rank", "FLOAT");
            public static final SqlColumn f10783K = new SqlColumn("game_data", "TEXT");
            public static final SqlColumn f10784L = new SqlColumn("group_type", "TEXT DEFAULT 'private'");
            public static final SqlColumn f10785M = new SqlColumn("requires_approval", "INTEGER DEFAULT 0");
            public static final SqlColumn f10786N = new SqlColumn("rtc_call_info", "TEXT");
            public static final SqlColumn f10787O = new SqlColumn("last_message_commerce_message_type", "TEXT");
            public static final SqlColumn f10788P = new SqlColumn("is_thread_queue_enabled", "INTEGER");
            public static final SqlColumn f10789a = new SqlColumn("thread_key", "TEXT");
            public static final SqlColumn f10790b = new SqlColumn("legacy_thread_id", "TEXT");
            public static final SqlColumn f10791c = new SqlColumn("action_id", "INTEGER");
            public static final SqlColumn f10792d = new SqlColumn("refetch_action_id", "INTEGER");
            public static final SqlColumn f10793e = new SqlColumn("last_visible_action_id", "INTEGER");
            public static final SqlColumn f10794f = new SqlColumn("sequence_id", "INTEGER");
            public static final SqlColumn f10795g = new SqlColumn("name", "TEXT");
            public static final SqlColumn f10796h = new SqlColumn("senders", "TEXT");
            public static final SqlColumn f10797i = new SqlColumn("snippet", "TEXT");
            public static final SqlColumn f10798j = new SqlColumn("snippet_sender", "TEXT");
            public static final SqlColumn f10799k = new SqlColumn("admin_snippet", "TEXT");
            public static final SqlColumn f10800l = new SqlColumn("timestamp_ms", "INTEGER");
            public static final SqlColumn f10801m = new SqlColumn("last_read_timestamp_ms", "INTEGER");
            public static final SqlColumn f10802n = new SqlColumn("approx_total_message_count", "INTEGER");
            public static final SqlColumn f10803o = new SqlColumn("unread_message_count", "INTEGER");
            public static final SqlColumn f10804p = new SqlColumn("last_fetch_time_ms", "INTEGER");
            public static final SqlColumn f10805q = new SqlColumn("pic_hash", "TEXT");
            public static final SqlColumn f10806r = new SqlColumn("pic", "TEXT");
            public static final SqlColumn f10807s = new SqlColumn("can_reply_to", "INTEGER");
            public static final SqlColumn f10808t = new SqlColumn("cannot_reply_reason", "TEXT");
            public static final SqlColumn f10809u = new SqlColumn("mute_until", "INTEGER");
            public static final SqlColumn f10810v = new SqlColumn("is_subscribed", "INTEGER");
            public static final SqlColumn f10811w = new SqlColumn("folder", "TEXT");
            public static final SqlColumn f10812x = new SqlColumn("draft", "TEXT");
            public static final SqlColumn f10813y = new SqlColumn("has_missed_call", "INTEGER");
            public static final SqlColumn f10814z = new SqlColumn("me_bubble_color", "INTEGER");
        }

        @Inject
        public ThreadsTable() {
            super("threads", f10816b, f10815a);
        }

        public final void m11196a(SQLiteDatabase sQLiteDatabase) {
            super.a(sQLiteDatabase);
            String str = f10817c;
            SQLiteDetour.a(48901834);
            sQLiteDatabase.execSQL(str);
            SQLiteDetour.a(-243329258);
        }

        public final void m11197a(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        }
    }

    public static com.facebook.messaging.database.threads.ThreadsDbSchemaPart m11224a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f10818c;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.messaging.database.threads.ThreadsDbSchemaPart.class;
        monitor-enter(r1);
        r0 = f10818c;	 Catch:{ all -> 0x003a }
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
        r0 = m11227b(r0);	 Catch:{ all -> 0x0035 }
        f10818c = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f10818c;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.database.threads.ThreadsDbSchemaPart.a(com.facebook.inject.InjectorLike):com.facebook.messaging.database.threads.ThreadsDbSchemaPart");
    }

    private static ThreadsDbSchemaPart m11227b(InjectorLike injectorLike) {
        return new ThreadsDbSchemaPart(IdBasedSingletonScopeProvider.b(injectorLike, 7807), IdBasedSingletonScopeProvider.b(injectorLike, 494));
    }

    @Inject
    public ThreadsDbSchemaPart(Lazy<DbThreadParticipantsUtil> lazy, Lazy<FbErrorReporter> lazy2) {
        super("threads", 162, ImmutableList.of(new PropertiesTable(), new FolderCountsTable(), new FoldersTable(), new ThreadsTable(), new MessagesTable(), new ThreadUsersTable(), new GroupConversationsTable(), new RankedThreadsTable(), new PinnedThreadsTable(), new ThreadParticipantsTable(), new EventRemindersTable(), new EventReminderMembersTable(), new SqlTable[0]));
        this.f10819a = lazy;
        this.f10820b = lazy2;
    }

    public final void m11251a(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        Integer.valueOf(i);
        Integer.valueOf(i2);
        while (i < i2) {
            i = m11226b(sQLiteDatabase, i, i2);
        }
    }

    protected final void m11253c(SQLiteDatabase sQLiteDatabase) {
        super.c(sQLiteDatabase);
        if (!sQLiteDatabase.isReadOnly()) {
            SQLiteDetour.a(-330618298);
            sQLiteDatabase.execSQL("PRAGMA foreign_keys=ON;");
            SQLiteDetour.a(-1992165322);
        }
    }

    public final void m11252b(SQLiteDatabase sQLiteDatabase) {
    }

    private int m11226b(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        int i3 = i + 1;
        if (i == 62) {
            m11228d(sQLiteDatabase);
            return 66;
        } else if (i == 66) {
            return i3;
        } else {
            if (i == 67) {
                m11229e(sQLiteDatabase);
                return i3;
            } else if (i == 68) {
                m11230f(sQLiteDatabase);
                return i3;
            } else if (i == 69) {
                m11231g(sQLiteDatabase);
                return i3;
            } else if (i == 70) {
                m11232h(sQLiteDatabase);
                return i3;
            } else if (i == 71) {
                m11233i(sQLiteDatabase);
                return i3;
            } else if (i == 72) {
                m11234j(sQLiteDatabase);
                return i3;
            } else if (i == 73) {
                m11235k(sQLiteDatabase);
                return i3;
            } else if (i == 74) {
                m11236l(sQLiteDatabase);
                return i3;
            } else if (i == 75) {
                m11237m(sQLiteDatabase);
                return i3;
            } else if (i == 76) {
                m11238n(sQLiteDatabase);
                return i3;
            } else if (i == 77) {
                m11239o(sQLiteDatabase);
                return i3;
            } else if (i == 78) {
                m11240p(sQLiteDatabase);
                return i3;
            } else if (i == 79) {
                m11241q(sQLiteDatabase);
                return i3;
            } else if (i == 80) {
                m11242r(sQLiteDatabase);
                return i3;
            } else if (i == 81) {
                m11243s(sQLiteDatabase);
                return i3;
            } else if (i == 82) {
                m11244t(sQLiteDatabase);
                return i3;
            } else if (i == 83) {
                m11245u(sQLiteDatabase);
                return i3;
            } else if (i == 84) {
                m11246v(sQLiteDatabase);
                return i3;
            } else if (i == 85) {
                m11247w(sQLiteDatabase);
                return i3;
            } else if (i == 86) {
                m11248x(sQLiteDatabase);
                return i3;
            } else if (i == 87) {
                m11249y(sQLiteDatabase);
                return i3;
            } else if (i == 88) {
                return 90;
            } else {
                if (i == 89) {
                    m11250z(sQLiteDatabase);
                    return i3;
                } else if (i == 90) {
                    m11198A(sQLiteDatabase);
                    return i3;
                } else if (i == 91) {
                    m11199B(sQLiteDatabase);
                    return i3;
                } else if (i == 92) {
                    m11200C(sQLiteDatabase);
                    return i3;
                } else if (i == 93) {
                    m11201D(sQLiteDatabase);
                    return i3;
                } else if (i == 94) {
                    m11202E(sQLiteDatabase);
                    return i3;
                } else if (i == 95) {
                    m11203F(sQLiteDatabase);
                    return i3;
                } else if (i == 96) {
                    m11204G(sQLiteDatabase);
                    return i3;
                } else if (i == 97) {
                    m11205H(sQLiteDatabase);
                    return i3;
                } else if (i == 98) {
                    m11206I(sQLiteDatabase);
                    return i3;
                } else if (i == 99) {
                    m11207J(sQLiteDatabase);
                    return i3;
                } else if (i == 100) {
                    m11208K(sQLiteDatabase);
                    return i3;
                } else if (i == 101) {
                    m11209L(sQLiteDatabase);
                    return i3;
                } else if (i == 102) {
                    m11210M(sQLiteDatabase);
                    return i3;
                } else if (i == 103) {
                    m11211N(sQLiteDatabase);
                    return i3;
                } else if (i == 104) {
                    m11212O(sQLiteDatabase);
                    return i3;
                } else if (i == 105) {
                    m11213P(sQLiteDatabase);
                    return i3;
                } else if (i == 106) {
                    m11214Q(sQLiteDatabase);
                    return i3;
                } else if (i == 107) {
                    m11215R(sQLiteDatabase);
                    return i3;
                } else if (i == 108) {
                    m11216S(sQLiteDatabase);
                    return i3;
                } else if (i == 109) {
                    m11217T(sQLiteDatabase);
                    return i3;
                } else if (i == 110) {
                    m11218U(sQLiteDatabase);
                    return i3;
                } else if (i == 111) {
                    m11219V(sQLiteDatabase);
                    return i3;
                } else if (i == 112) {
                    m11220W(sQLiteDatabase);
                    return i3;
                } else if (i == 113) {
                    m11221X(sQLiteDatabase);
                    return i3;
                } else if (i == 114) {
                    m11222Y(sQLiteDatabase);
                    return i3;
                } else if (i == 115) {
                    m11223Z(sQLiteDatabase);
                    return i3;
                } else if (i == 116) {
                    aa(sQLiteDatabase);
                    return i3;
                } else if (i == 117) {
                    ab(sQLiteDatabase);
                    return i3;
                } else if (i == 118) {
                    ac(sQLiteDatabase);
                    return i3;
                } else if (i == 119) {
                    ad(sQLiteDatabase);
                    return i3;
                } else if (i == 120) {
                    ae(sQLiteDatabase);
                    return i3;
                } else if (i == 121) {
                    af(sQLiteDatabase);
                    return i3;
                } else if (i == 122) {
                    ag(sQLiteDatabase);
                    return i3;
                } else if (i == 123) {
                    ah(sQLiteDatabase);
                    return i3;
                } else if (i == 124) {
                    ai(sQLiteDatabase);
                    return i3;
                } else if (i == 125) {
                    aj(sQLiteDatabase);
                    return i3;
                } else if (i == 126) {
                    ak(sQLiteDatabase);
                    return i3;
                } else if (i == 127) {
                    try {
                        al(sQLiteDatabase);
                        return i3;
                    } catch (Throwable e) {
                        ((AbstractFbErrorReporter) this.f10820b.get()).a("DbThreadParticipantsUtilParticipantsColumnUpgradeFail", e);
                    }
                } else if (i == 128) {
                    am(sQLiteDatabase);
                    return i3;
                } else if (i == 129) {
                    an(sQLiteDatabase);
                    return i3;
                } else if (i == 130) {
                    ao(sQLiteDatabase);
                    return i3;
                } else if (i == 131) {
                    ap(sQLiteDatabase);
                    return i3;
                } else if (i == 132) {
                    aq(sQLiteDatabase);
                    return i3;
                } else if (i == 133) {
                    ar(sQLiteDatabase);
                    return i3;
                } else if (i == 134) {
                    as(sQLiteDatabase);
                    return i3;
                } else if (i == 135) {
                    at(sQLiteDatabase);
                    return i3;
                } else if (i == 136) {
                    au(sQLiteDatabase);
                    return i3;
                } else if (i == 137) {
                    av(sQLiteDatabase);
                    return i3;
                } else if (i == 138) {
                    aw(sQLiteDatabase);
                    return i3;
                } else if (i == 139) {
                    ax(sQLiteDatabase);
                    return i3;
                } else if (i == 140) {
                    ay(sQLiteDatabase);
                    return i3;
                } else if (i == 141) {
                    az(sQLiteDatabase);
                    return i3;
                } else if (i == 142) {
                    aA(sQLiteDatabase);
                    return i3;
                } else if (i == 143) {
                    aB(sQLiteDatabase);
                    return i3;
                } else if (i == 144) {
                    aC(sQLiteDatabase);
                    return i3;
                } else if (i == 145) {
                    aD(sQLiteDatabase);
                    return i3;
                } else if (i == 146) {
                    aE(sQLiteDatabase);
                    return i3;
                } else if (i == 147) {
                    aF(sQLiteDatabase);
                    return i3;
                } else if (i == 148) {
                    aG(sQLiteDatabase);
                    return i3;
                } else if (i == 149) {
                    aH(sQLiteDatabase);
                    return i3;
                } else if (i == 150) {
                    aI(sQLiteDatabase);
                    return i3;
                } else if (i == 151) {
                    aJ(sQLiteDatabase);
                    return i3;
                } else if (i == 152) {
                    aK(sQLiteDatabase);
                    return i3;
                } else if (i == 153) {
                    aL(sQLiteDatabase);
                    return i3;
                } else if (i == 154) {
                    aM(sQLiteDatabase);
                    return i3;
                } else if (i == 155) {
                    aN(sQLiteDatabase);
                    return i3;
                } else if (i == 156) {
                    aO(sQLiteDatabase);
                    return i3;
                } else if (i == 157) {
                    aP(sQLiteDatabase);
                    return i3;
                } else if (i == 158) {
                    aQ(sQLiteDatabase);
                    return i3;
                } else if (i == 159) {
                    aR(sQLiteDatabase);
                    return i3;
                } else if (i == 160) {
                    aS(sQLiteDatabase);
                    return i3;
                } else {
                    if (i == 161) {
                        aT(sQLiteDatabase);
                        return i3;
                    }
                    aU(sQLiteDatabase);
                    a(sQLiteDatabase);
                    return i2;
                }
            }
        }
    }

    private static void m11228d(SQLiteDatabase sQLiteDatabase) {
        SQLiteDetour.a(-1957812160);
        sQLiteDatabase.execSQL("ALTER TABLE messages ADD COLUMN send_queue_type TEXT");
        SQLiteDetour.a(-564340551);
        String a = SqlTable.a("ranked_threads", RankedThreadsTable.f10757b, ImmutableList.of(RankedThreadsTable.f10756a));
        SQLiteDetour.a(-1510452301);
        sQLiteDatabase.execSQL(a);
        SQLiteDetour.a(-1077843323);
        SqlColumn sqlColumn = new SqlColumn("thread_key", "TEXT");
        SQLiteDatabase sQLiteDatabase2 = sQLiteDatabase;
        SqlTable.a(sQLiteDatabase2, "threads", ImmutableList.of(sqlColumn, new SqlColumn("thread_fbid", "TEXT"), new SqlColumn("legacy_thread_id", "TEXT"), new SqlColumn("action_id", "INTEGER"), new SqlColumn("refetch_action_id", "INTEGER"), new SqlColumn("last_visible_action_id", "INTEGER"), new SqlColumn("sequence_id", "INTEGER"), new SqlColumn("name", "TEXT"), new SqlColumn("participants", "TEXT"), new SqlColumn("former_participants", "TEXT"), new SqlColumn("object_participants", "TEXT"), new SqlColumn("senders", "TEXT"), new SqlColumn[]{new SqlColumn("snippet", "TEXT"), new SqlColumn("snippet_sender", "TEXT"), new SqlColumn("admin_snippet", "TEXT"), new SqlColumn("timestamp_ms", "INTEGER"), new SqlColumn("last_fetch_time_ms", "INTEGER"), new SqlColumn("unread", "INTEGER"), new SqlColumn("pic_hash", "TEXT"), new SqlColumn("pic", "TEXT"), new SqlColumn("can_reply_to", "INTEGER"), new SqlColumn("mute_until", "INTEGER"), new SqlColumn("is_subscribed", "INTEGER"), new SqlColumn("folder", "TEXT"), new SqlColumn("draft", "TEXT")}), new PrimaryKey(ImmutableList.of(sqlColumn)));
        a = ThreadsTable.f10817c;
        SQLiteDetour.a(1271653249);
        sQLiteDatabase.execSQL(a);
        SQLiteDetour.a(-1159682626);
    }

    private static void m11229e(SQLiteDatabase sQLiteDatabase) {
        SQLiteDetour.a(-1330119034);
        sQLiteDatabase.execSQL("ALTER TABLE threads ADD COLUMN num_unread INTEGER");
        SQLiteDetour.a(452797283);
    }

    private static void m11230f(SQLiteDatabase sQLiteDatabase) {
        SQLiteDetour.a(-848522500);
        sQLiteDatabase.execSQL("ALTER TABLE threads ADD COLUMN last_visitied_ms INTEGER");
        SQLiteDetour.a(226419806);
        SQLiteDetour.a(-1250522092);
        sQLiteDatabase.execSQL("ALTER TABLE threads ADD COLUMN last_visitied_ms_type INTEGER");
        SQLiteDetour.a(1814717693);
    }

    private static void m11231g(SQLiteDatabase sQLiteDatabase) {
        Expression a = SqlExpression.a("folder", FolderName.NONE.dbName);
        sQLiteDatabase.delete("threads", a.a(), a.b());
    }

    private static void m11232h(SQLiteDatabase sQLiteDatabase) {
        SQLiteDetour.a(-2101273606);
        sQLiteDatabase.execSQL("ALTER TABLE messages ADD COLUMN payment_transaction TEXT");
        SQLiteDetour.a(-1160488244);
    }

    private static void m11233i(SQLiteDatabase sQLiteDatabase) {
        r1 = new Expression[2];
        r1[0] = SqlExpression.b(new Expression[]{SqlExpression.a("msg_type", String.valueOf(MessageType.FAILED_SEND.dbKeyValue)), SqlExpression.a("msg_type", String.valueOf(MessageType.PENDING_SEND.dbKeyValue))});
        r1[1] = SqlExpression.b("pending_attachment_fbid NOT NULL");
        ConjunctionExpression a = SqlExpression.a(r1);
        sQLiteDatabase.delete("messages", a.a(), a.b());
        SqlColumn sqlColumn = new SqlColumn("msg_id", "TEXT");
        SQLiteDatabase sQLiteDatabase2 = sQLiteDatabase;
        SqlTable.a(sQLiteDatabase2, "messages", ImmutableList.of(sqlColumn, new SqlColumn("thread_key", "TEXT"), new SqlColumn("legacy_thread_id", "TEXT"), new SqlColumn("action_id", "INTEGER"), new SqlColumn("text", "TEXT"), new SqlColumn("sender", "TEXT"), new SqlColumn("timestamp_ms", "INTEGER"), new SqlColumn("timestamp_sent_ms", "INTEGER"), new SqlColumn("attachments", "TEXT"), new SqlColumn("shares", "TEXT"), new SqlColumn("sticker_id", "TEXT"), new SqlColumn("msg_type", "INTEGER"), new SqlColumn[]{new SqlColumn("affected_users", "TEXT"), new SqlColumn("coordinates", "TEXT"), new SqlColumn("offline_threading_id", "TEXT"), new SqlColumn("source", "TEXT"), new SqlColumn("channel_source", "TEXT"), new SqlColumn("is_non_authoritative", "INTEGER"), new SqlColumn("pending_send_media_attachment", "STRING"), new SqlColumn("pending_shares", "STRING"), new SqlColumn("client_tags", "TEXT"), new SqlColumn("send_error", "STRING"), new SqlColumn("send_error_message", "STRING"), new SqlColumn("send_error_timestamp_ms", "INTEGER"), new SqlColumn("publicity", "TEXT"), new SqlColumn("send_queue_type", "TEXT"), new SqlColumn("payment_transaction", "TEXT")}), new PrimaryKey(ImmutableList.of(sqlColumn)));
        String str = MessagesTable.f10746c;
        SQLiteDetour.a(1044512719);
        sQLiteDatabase.execSQL(str);
        SQLiteDetour.a(1056293972);
        str = MessagesTable.f10747d;
        SQLiteDetour.a(619541511);
        sQLiteDatabase.execSQL(str);
        SQLiteDetour.a(1578693431);
        str = MessagesTable.f10748e;
        SQLiteDetour.a(524069774);
        sQLiteDatabase.execSQL(str);
        SQLiteDetour.a(-329339904);
    }

    private static void m11234j(SQLiteDatabase sQLiteDatabase) {
        r1 = new Expression[2];
        r1[0] = SqlExpression.b(new Expression[]{SqlExpression.a("msg_type", String.valueOf(MessageType.FAILED_SEND.dbKeyValue)), SqlExpression.a("msg_type", String.valueOf(MessageType.PENDING_SEND.dbKeyValue))});
        r1[1] = SqlExpression.b("pending_shares NOT NULL");
        ConjunctionExpression a = SqlExpression.a(r1);
        sQLiteDatabase.delete("messages", a.a(), a.b());
        SqlColumn sqlColumn = new SqlColumn("msg_id", "TEXT");
        SQLiteDatabase sQLiteDatabase2 = sQLiteDatabase;
        SqlTable.a(sQLiteDatabase2, "messages", ImmutableList.of(sqlColumn, new SqlColumn("thread_key", "TEXT"), new SqlColumn("legacy_thread_id", "TEXT"), new SqlColumn("action_id", "INTEGER"), new SqlColumn("text", "TEXT"), new SqlColumn("sender", "TEXT"), new SqlColumn("timestamp_ms", "INTEGER"), new SqlColumn("timestamp_sent_ms", "INTEGER"), new SqlColumn("attachments", "TEXT"), new SqlColumn("shares", "TEXT"), new SqlColumn("sticker_id", "TEXT"), new SqlColumn("msg_type", "INTEGER"), new SqlColumn[]{new SqlColumn("affected_users", "TEXT"), new SqlColumn("coordinates", "TEXT"), new SqlColumn("offline_threading_id", "TEXT"), new SqlColumn("source", "TEXT"), new SqlColumn("channel_source", "TEXT"), new SqlColumn("is_non_authoritative", "INTEGER"), new SqlColumn("pending_send_media_attachment", "STRING"), new SqlColumn("client_tags", "TEXT"), new SqlColumn("send_error", "STRING"), new SqlColumn("send_error_message", "STRING"), new SqlColumn("send_error_timestamp_ms", "INTEGER"), new SqlColumn("publicity", "TEXT"), new SqlColumn("send_queue_type", "TEXT"), new SqlColumn("payment_transaction", "TEXT")}), new PrimaryKey(ImmutableList.of(sqlColumn)));
        String str = MessagesTable.f10746c;
        SQLiteDetour.a(1370832960);
        sQLiteDatabase.execSQL(str);
        SQLiteDetour.a(-221756550);
        str = MessagesTable.f10747d;
        SQLiteDetour.a(2051027752);
        sQLiteDatabase.execSQL(str);
        SQLiteDetour.a(-715564400);
        str = MessagesTable.f10748e;
        SQLiteDetour.a(-1022470514);
        sQLiteDatabase.execSQL(str);
        SQLiteDetour.a(1552286930);
        SQLiteDetour.a(-1058948796);
        sQLiteDatabase.execSQL("ALTER TABLE messages ADD COLUMN sent_share_attachment TEXT");
        SQLiteDetour.a(788082957);
    }

    @VisibleForTesting
    private static void m11235k(SQLiteDatabase sQLiteDatabase) {
        SQLiteDetour.a(822077190);
        sQLiteDatabase.execSQL("ALTER TABLE threads ADD COLUMN has_missed_call INTEGER");
        SQLiteDetour.a(-1043711865);
    }

    private static void m11236l(SQLiteDatabase sQLiteDatabase) {
        SQLiteDetour.a(1023224088);
        sQLiteDatabase.execSQL("ALTER TABLE messages ADD COLUMN has_unavailable_attachment INTEGER");
        SQLiteDetour.a(2066303427);
    }

    private static void m11237m(SQLiteDatabase sQLiteDatabase) {
        SqlColumn sqlColumn = new SqlColumn("msg_id", "TEXT");
        SQLiteDatabase sQLiteDatabase2 = sQLiteDatabase;
        SqlTable.a(sQLiteDatabase2, "messages", ImmutableList.of(sqlColumn, new SqlColumn("thread_key", "TEXT"), new SqlColumn("action_id", "INTEGER"), new SqlColumn("text", "TEXT"), new SqlColumn("sender", "TEXT"), new SqlColumn("timestamp_ms", "INTEGER"), new SqlColumn("timestamp_sent_ms", "INTEGER"), new SqlColumn("attachments", "TEXT"), new SqlColumn("shares", "TEXT"), new SqlColumn("sticker_id", "TEXT"), new SqlColumn("msg_type", "INTEGER"), new SqlColumn("affected_users", "TEXT"), new SqlColumn[]{new SqlColumn("coordinates", "TEXT"), new SqlColumn("offline_threading_id", "TEXT"), new SqlColumn("source", "TEXT"), new SqlColumn("channel_source", "TEXT"), new SqlColumn("is_non_authoritative", "INTEGER"), new SqlColumn("pending_send_media_attachment", "STRING"), new SqlColumn("sent_share_attachment", "STRING"), new SqlColumn("client_tags", "TEXT"), new SqlColumn("send_error", "STRING"), new SqlColumn("send_error_message", "STRING"), new SqlColumn("send_error_timestamp_ms", "INTEGER"), new SqlColumn("publicity", "TEXT"), new SqlColumn("send_queue_type", "TEXT"), new SqlColumn("payment_transaction", "TEXT"), new SqlColumn("has_unavailable_attachment", "INTEGER")}), new PrimaryKey(ImmutableList.of(sqlColumn)));
        String str = MessagesTable.f10746c;
        SQLiteDetour.a(-429261307);
        sQLiteDatabase.execSQL(str);
        SQLiteDetour.a(13146289);
        str = MessagesTable.f10747d;
        SQLiteDetour.a(331219474);
        sQLiteDatabase.execSQL(str);
        SQLiteDetour.a(-1591875778);
        str = MessagesTable.f10748e;
        SQLiteDetour.a(-792201233);
        sQLiteDatabase.execSQL(str);
        SQLiteDetour.a(1022567728);
    }

    private static void m11238n(SQLiteDatabase sQLiteDatabase) {
        SQLiteDetour.a(-1199800737);
        sQLiteDatabase.execSQL("ALTER TABLE messages ADD COLUMN send_error_error_url STRING");
        SQLiteDetour.a(430923921);
    }

    private static void m11239o(SQLiteDatabase sQLiteDatabase) {
        SQLiteDetour.a(-227334625);
        sQLiteDatabase.execSQL("ALTER TABLE messages ADD COLUMN app_attribution TEXT");
        SQLiteDetour.a(1263268736);
    }

    @VisibleForTesting
    private static void m11240p(SQLiteDatabase sQLiteDatabase) {
        SQLiteDetour.a(1794972747);
        sQLiteDatabase.execSQL("ALTER TABLE thread_users ADD COLUMN profile_type TEXT");
        SQLiteDetour.a(1556470697);
    }

    private static void m11241q(SQLiteDatabase sQLiteDatabase) {
        SqlColumn sqlColumn = new SqlColumn("thread_key", "TEXT");
        SQLiteDatabase sQLiteDatabase2 = sQLiteDatabase;
        SqlTable.a(sQLiteDatabase2, "threads", ImmutableList.of(sqlColumn, new SqlColumn("thread_fbid", "TEXT"), new SqlColumn("legacy_thread_id", "TEXT"), new SqlColumn("action_id", "INTEGER"), new SqlColumn("refetch_action_id", "INTEGER"), new SqlColumn("last_visible_action_id", "INTEGER"), new SqlColumn("sequence_id", "INTEGER"), new SqlColumn("name", "TEXT"), new SqlColumn("participants", "TEXT"), new SqlColumn("former_participants", "TEXT"), new SqlColumn("senders", "TEXT"), new SqlColumn("snippet", "TEXT"), new SqlColumn[]{new SqlColumn("snippet_sender", "TEXT"), new SqlColumn("admin_snippet", "TEXT"), new SqlColumn("timestamp_ms", "INTEGER"), new SqlColumn("last_fetch_time_ms", "INTEGER"), new SqlColumn("unread", "INTEGER"), new SqlColumn("pic_hash", "TEXT"), new SqlColumn("pic", "TEXT"), new SqlColumn("can_reply_to", "INTEGER"), new SqlColumn("mute_until", "INTEGER"), new SqlColumn("is_subscribed", "INTEGER"), new SqlColumn("folder", "TEXT"), new SqlColumn("draft", "TEXT"), new SqlColumn("num_unread", "INTEGER"), new SqlColumn("last_visitied_ms", "INTEGER"), new SqlColumn("last_visitied_ms_type", "INTEGER"), new SqlColumn("has_missed_call", "INTEGER")}), new PrimaryKey(ImmutableList.of(sqlColumn)));
        String str = ThreadsTable.f10817c;
        SQLiteDetour.a(1221904142);
        sQLiteDatabase.execSQL(str);
        SQLiteDetour.a(-1119060237);
    }

    private static void m11242r(SQLiteDatabase sQLiteDatabase) {
        SqlColumn sqlColumn = new SqlColumn("thread_key", "TEXT");
        SQLiteDatabase sQLiteDatabase2 = sQLiteDatabase;
        SqlTable.a(sQLiteDatabase2, "threads", ImmutableList.of(sqlColumn, new SqlColumn("thread_fbid", "TEXT"), new SqlColumn("legacy_thread_id", "TEXT"), new SqlColumn("action_id", "INTEGER"), new SqlColumn("refetch_action_id", "INTEGER"), new SqlColumn("last_visible_action_id", "INTEGER"), new SqlColumn("sequence_id", "INTEGER"), new SqlColumn("name", "TEXT"), new SqlColumn("participants", "TEXT"), new SqlColumn("former_participants", "TEXT"), new SqlColumn("senders", "TEXT"), new SqlColumn("snippet", "TEXT"), new SqlColumn[]{new SqlColumn("snippet_sender", "TEXT"), new SqlColumn("admin_snippet", "TEXT"), new SqlColumn("timestamp_ms", "INTEGER"), new SqlColumn("last_fetch_time_ms", "INTEGER"), new SqlColumn("unread", "INTEGER"), new SqlColumn("pic_hash", "TEXT"), new SqlColumn("pic", "TEXT"), new SqlColumn("can_reply_to", "INTEGER"), new SqlColumn("mute_until", "INTEGER"), new SqlColumn("is_subscribed", "INTEGER"), new SqlColumn("folder", "TEXT"), new SqlColumn("draft", "TEXT"), new SqlColumn("has_missed_call", "INTEGER")}), new PrimaryKey(ImmutableList.of(sqlColumn)));
        String str = ThreadsTable.f10817c;
        SQLiteDetour.a(-528759791);
        sQLiteDatabase.execSQL(str);
        SQLiteDetour.a(-51352374);
    }

    private static void m11243s(SQLiteDatabase sQLiteDatabase) {
        SQLiteDetour.a(-454126738);
        sQLiteDatabase.execSQL("ALTER TABLE messages ADD COLUMN content_app_attribution TEXT");
        SQLiteDetour.a(-1262267568);
    }

    private static void m11244t(SQLiteDatabase sQLiteDatabase) {
        SqlColumn sqlColumn = new SqlColumn("thread_key", "TEXT");
        SQLiteDatabase sQLiteDatabase2 = sQLiteDatabase;
        SqlTable.a(sQLiteDatabase2, "threads", ImmutableList.of(sqlColumn, new SqlColumn("legacy_thread_id", "TEXT"), new SqlColumn("action_id", "INTEGER"), new SqlColumn("refetch_action_id", "INTEGER"), new SqlColumn("last_visible_action_id", "INTEGER"), new SqlColumn("sequence_id", "INTEGER"), new SqlColumn("name", "TEXT"), new SqlColumn("participants", "TEXT"), new SqlColumn("former_participants", "TEXT"), new SqlColumn("senders", "TEXT"), new SqlColumn("snippet", "TEXT"), new SqlColumn("snippet_sender", "TEXT"), new SqlColumn[]{new SqlColumn("admin_snippet", "TEXT"), new SqlColumn("timestamp_ms", "INTEGER"), new SqlColumn("last_fetch_time_ms", "INTEGER"), new SqlColumn("unread", "INTEGER"), new SqlColumn("pic_hash", "TEXT"), new SqlColumn("pic", "TEXT"), new SqlColumn("can_reply_to", "INTEGER"), new SqlColumn("mute_until", "INTEGER"), new SqlColumn("is_subscribed", "INTEGER"), new SqlColumn("folder", "TEXT"), new SqlColumn("draft", "TEXT"), new SqlColumn("has_missed_call", "INTEGER")}), new PrimaryKey(ImmutableList.of(sqlColumn)));
        String str = ThreadsTable.f10817c;
        SQLiteDetour.a(749078840);
        sQLiteDatabase.execSQL(str);
        SQLiteDetour.a(1343048003);
    }

    private static void m11245u(SQLiteDatabase sQLiteDatabase) {
        SQLiteDetour.a(305843275);
        sQLiteDatabase.execSQL("UPDATE messages SET msg_id = replace(msg_id, 'm_mid', 'mid') WHERE msg_id LIKE 'm_mid%'");
        SQLiteDetour.a(-263925907);
    }

    private static void m11246v(SQLiteDatabase sQLiteDatabase) {
        String a = SqlTable.a("group_clusters");
        SQLiteDetour.a(1783125239);
        sQLiteDatabase.execSQL(a);
        SQLiteDetour.a(1126014276);
    }

    private static void m11247w(SQLiteDatabase sQLiteDatabase) {
        SQLiteDetour.a(1078992620);
        sQLiteDatabase.execSQL("ALTER TABLE messages ADD COLUMN xma TEXT");
        SQLiteDetour.a(-1598738302);
    }

    private static void m11248x(SQLiteDatabase sQLiteDatabase) {
        SQLiteDetour.a(1133467947);
        sQLiteDatabase.execSQL("ALTER TABLE thread_users ADD is_commerce INTEGER");
        SQLiteDetour.a(-1508159729);
    }

    private static void m11249y(SQLiteDatabase sQLiteDatabase) {
        SQLiteDetour.a(1651127211);
        sQLiteDatabase.execSQL("ALTER TABLE messages ADD COLUMN is_not_forwardable INTEGER");
        SQLiteDetour.a(1232783878);
    }

    private static void m11250z(SQLiteDatabase sQLiteDatabase) {
        SqlColumn sqlColumn = new SqlColumn("thread_key", "TEXT");
        SQLiteDatabase sQLiteDatabase2 = sQLiteDatabase;
        SqlTable.a(sQLiteDatabase2, "threads", ImmutableList.of(sqlColumn, new SqlColumn("legacy_thread_id", "TEXT"), new SqlColumn("action_id", "INTEGER"), new SqlColumn("refetch_action_id", "INTEGER"), new SqlColumn("last_visible_action_id", "INTEGER"), new SqlColumn("sequence_id", "INTEGER"), new SqlColumn("name", "TEXT"), new SqlColumn("participants", "TEXT"), new SqlColumn("former_participants", "TEXT"), new SqlColumn("senders", "TEXT"), new SqlColumn("snippet", "TEXT"), new SqlColumn("snippet_sender", "TEXT"), new SqlColumn[]{new SqlColumn("admin_snippet", "TEXT"), new SqlColumn("timestamp_ms", "INTEGER"), new SqlColumn("last_fetch_time_ms", "INTEGER"), new SqlColumn("unread", "INTEGER"), new SqlColumn("pic_hash", "TEXT"), new SqlColumn("pic", "TEXT"), new SqlColumn("can_reply_to", "INTEGER"), new SqlColumn("mute_until", "INTEGER"), new SqlColumn("is_subscribed", "INTEGER"), new SqlColumn("folder", "TEXT"), new SqlColumn("draft", "TEXT"), new SqlColumn("has_missed_call", "INTEGER")}), new PrimaryKey(ImmutableList.of(sqlColumn)));
        String str = ThreadsTable.f10817c;
        SQLiteDetour.a(1002205343);
        sQLiteDatabase.execSQL(str);
        SQLiteDetour.a(1601774407);
    }

    private static void m11198A(SQLiteDatabase sQLiteDatabase) {
        SQLiteDetour.a(1607327529);
        sQLiteDatabase.execSQL("ALTER TABLE thread_users ADD is_partial INTEGER");
        SQLiteDetour.a(827049861);
        SQLiteDetour.a(-1209802804);
        sQLiteDatabase.execSQL("ALTER TABLE thread_users ADD user_rank REAL");
        SQLiteDetour.a(261694588);
    }

    private static void m11199B(SQLiteDatabase sQLiteDatabase) {
        SQLiteDetour.a(-1636084606);
        sQLiteDatabase.execSQL("ALTER TABLE threads ADD COLUMN participants_flat_buffer BLOB");
        SQLiteDetour.a(61088481);
        SQLiteDetour.a(-337370002);
        sQLiteDatabase.execSQL("ALTER TABLE threads ADD COLUMN former_participants_flat_buffer BLOB");
        SQLiteDetour.a(-1471469749);
        SQLiteDetour.a(-1983326256);
        sQLiteDatabase.execSQL("ALTER TABLE threads ADD COLUMN senders_flat_buffer BLOB");
        SQLiteDetour.a(168439970);
        SQLiteDetour.a(-413973727);
        sQLiteDatabase.execSQL("ALTER TABLE threads ADD COLUMN snippet_sender_flat_buffer BLOB");
        SQLiteDetour.a(2111412333);
        SQLiteDetour.a(-696312154);
        sQLiteDatabase.execSQL("ALTER TABLE threads ADD COLUMN mute_until_flat_buffer BLOB");
        SQLiteDetour.a(-1155812519);
        SQLiteDetour.a(-108913330);
        sQLiteDatabase.execSQL("ALTER TABLE threads ADD COLUMN draft_flat_buffer BLOB");
        SQLiteDetour.a(-2063561449);
    }

    private static void m11200C(SQLiteDatabase sQLiteDatabase) {
        SQLiteDetour.a(-993814743);
        sQLiteDatabase.execSQL("ALTER TABLE threads ADD COLUMN me_bubble_color INTEGER");
        SQLiteDetour.a(-1046877173);
        SQLiteDetour.a(-2135798978);
        sQLiteDatabase.execSQL("ALTER TABLE threads ADD COLUMN other_bubble_color INTEGER");
        SQLiteDetour.a(-1139919042);
        SQLiteDetour.a(1588090162);
        sQLiteDatabase.execSQL("ALTER TABLE threads ADD COLUMN wallpaper_color INTEGER");
        SQLiteDetour.a(1200904009);
    }

    private static void m11201D(SQLiteDatabase sQLiteDatabase) {
        String a = SqlTable.a("threads", new SqlColumn("last_fetch_action_id", "INTEGER DEFAULT -1"));
        SQLiteDetour.a(533813765);
        sQLiteDatabase.execSQL(a);
        SQLiteDetour.a(-2102025851);
        a = SqlTable.a("threads", new SqlColumn("initial_fetch_complete", "INTEGER"));
        SQLiteDetour.a(-1558029197);
        sQLiteDatabase.execSQL(a);
        SQLiteDetour.a(-482680538);
        m11225a(sQLiteDatabase, "/sync/last_thread_fetch_action_id/", "last_fetch_action_id");
        m11225a(sQLiteDatabase, "thread_initial_fetch_complete/", "initial_fetch_complete");
    }

    private static void m11202E(SQLiteDatabase sQLiteDatabase) {
        String a = SqlTable.a("threads", new SqlColumn("last_read_timestamp_ms", "INTEGER"));
        SQLiteDetour.a(1857627736);
        sQLiteDatabase.execSQL(a);
        SQLiteDetour.a(791616820);
        a = StringFormatUtil.formatStrLocaleSafe("UPDATE %s SET %s = %s WHERE unread = ?", "threads", "last_read_timestamp_ms", "timestamp_ms");
        Object[] objArr = new Object[]{Integer.valueOf(0)};
        SQLiteDetour.a(-1853078733);
        sQLiteDatabase.execSQL(a, objArr);
        SQLiteDetour.a(-2098929115);
        SqlColumn sqlColumn = new SqlColumn("thread_key", "TEXT");
        SQLiteDatabase sQLiteDatabase2 = sQLiteDatabase;
        SqlTable.a(sQLiteDatabase2, "threads", ImmutableList.of(sqlColumn, new SqlColumn("legacy_thread_id", "TEXT"), new SqlColumn("action_id", "INTEGER"), new SqlColumn("refetch_action_id", "INTEGER"), new SqlColumn("last_visible_action_id", "INTEGER"), new SqlColumn("sequence_id", "INTEGER"), new SqlColumn("name", "TEXT"), new SqlColumn("participants", "TEXT"), new SqlColumn("participants_flat_buffer", "BLOB"), new SqlColumn("former_participants", "TEXT"), new SqlColumn("former_participants_flat_buffer", "BLOB"), new SqlColumn("senders", "TEXT"), new SqlColumn[]{new SqlColumn("senders_flat_buffer", "BLOB"), new SqlColumn("snippet", "TEXT"), new SqlColumn("snippet_sender", "TEXT"), new SqlColumn("snippet_sender_flat_buffer", "BLOB"), new SqlColumn("admin_snippet", "TEXT"), new SqlColumn("timestamp_ms", "INTEGER"), new SqlColumn("last_read_timestamp_ms", "INTEGER"), new SqlColumn("last_fetch_time_ms", "INTEGER"), new SqlColumn("pic_hash", "TEXT"), new SqlColumn("pic", "TEXT"), new SqlColumn("can_reply_to", "INTEGER"), new SqlColumn("mute_until", "INTEGER"), new SqlColumn("mute_until_flat_buffer", "BLOB"), new SqlColumn("is_subscribed", "INTEGER"), new SqlColumn("folder", "TEXT"), new SqlColumn("draft", "TEXT"), new SqlColumn("draft_flat_buffer", "BLOB"), new SqlColumn("has_missed_call", "INTEGER"), new SqlColumn("me_bubble_color", "INTEGER"), new SqlColumn("other_bubble_color", "INTEGER"), new SqlColumn("wallpaper_color", "INTEGER"), new SqlColumn("last_fetch_action_id", "INTEGER"), new SqlColumn("initial_fetch_complete", "INTEGER")}), new PrimaryKey(ImmutableList.of(sqlColumn)));
        a = ThreadsTable.f10817c;
        SQLiteDetour.a(-1694986134);
        sQLiteDatabase.execSQL(a);
        SQLiteDetour.a(237366968);
    }

    private static void m11203F(SQLiteDatabase sQLiteDatabase) {
        SQLiteDetour.a(-439761216);
        sQLiteDatabase.execSQL("ALTER TABLE messages ADD COLUMN admin_text_type INTEGER");
        SQLiteDetour.a(-14284757);
        SQLiteDetour.a(573336681);
        sQLiteDatabase.execSQL("ALTER TABLE messages ADD COLUMN admin_text_theme_color INTEGER");
        SQLiteDetour.a(812703791);
        SQLiteDetour.a(1426771951);
        sQLiteDatabase.execSQL("ALTER TABLE messages ADD COLUMN admin_text_thread_icon_emoji TEXT");
        SQLiteDetour.a(-2015239589);
    }

    private static void m11204G(SQLiteDatabase sQLiteDatabase) {
        SQLiteDetour.a(-1746432368);
        sQLiteDatabase.execSQL("ALTER TABLE threads ADD COLUMN custom_like_emoji TEXT");
        SQLiteDetour.a(1941180462);
    }

    private static void m11205H(SQLiteDatabase sQLiteDatabase) {
        String a = SqlTable.a("threads", new SqlColumn("unread_message_count", "INTEGER"));
        SQLiteDetour.a(440391653);
        sQLiteDatabase.execSQL(a);
        SQLiteDetour.a(-1119936048);
        a = StringFormatUtil.formatStrLocaleSafe("UPDATE %s SET %s = ? WHERE %s < %s", "threads", "unread_message_count", "last_read_timestamp_ms", "timestamp_ms");
        Object[] objArr = new Object[]{Long.valueOf(1)};
        SQLiteDetour.a(1484887462);
        sQLiteDatabase.execSQL(a, objArr);
        SQLiteDetour.a(-231482167);
    }

    private static void m11206I(SQLiteDatabase sQLiteDatabase) {
        SQLiteDetour.a(1290241806);
        sQLiteDatabase.execSQL("ALTER TABLE thread_users ADD COLUMN is_blocked_by_viewer INTEGER");
        SQLiteDetour.a(22424059);
        SQLiteDetour.a(-896479469);
        sQLiteDatabase.execSQL("ALTER TABLE thread_users ADD COLUMN is_message_blocked_by_viewer INTEGER");
        SQLiteDetour.a(543032640);
    }

    private static void m11207J(SQLiteDatabase sQLiteDatabase) {
        SQLiteDetour.a(-108561365);
        sQLiteDatabase.execSQL("ALTER TABLE thread_users ADD COLUMN commerce_page_type TEXT");
        SQLiteDetour.a(795411919);
    }

    private static void m11208K(SQLiteDatabase sQLiteDatabase) {
        SQLiteDetour.a(1848517619);
        sQLiteDatabase.execSQL("ALTER TABLE threads ADD COLUMN cannot_reply_reason TEXT");
        SQLiteDetour.a(748816227);
    }

    private static void m11209L(SQLiteDatabase sQLiteDatabase) {
        SqlColumn sqlColumn = new SqlColumn("thread_key", "TEXT");
        SQLiteDatabase sQLiteDatabase2 = sQLiteDatabase;
        SqlTable.a(sQLiteDatabase2, "threads", ImmutableList.of(sqlColumn, new SqlColumn("legacy_thread_id", "TEXT"), new SqlColumn("action_id", "INTEGER"), new SqlColumn("refetch_action_id", "INTEGER"), new SqlColumn("last_visible_action_id", "INTEGER"), new SqlColumn("sequence_id", "INTEGER"), new SqlColumn("name", "TEXT"), new SqlColumn("participants", "TEXT"), new SqlColumn("former_participants", "TEXT"), new SqlColumn("senders", "TEXT"), new SqlColumn("snippet", "TEXT"), new SqlColumn("snippet_sender", "TEXT"), new SqlColumn[]{new SqlColumn("admin_snippet", "TEXT"), new SqlColumn("timestamp_ms", "INTEGER"), new SqlColumn("last_read_timestamp_ms", "INTEGER"), new SqlColumn("unread_message_count", "INTEGER"), new SqlColumn("last_fetch_time_ms", "INTEGER"), new SqlColumn("pic_hash", "TEXT"), new SqlColumn("pic", "TEXT"), new SqlColumn("can_reply_to", "INTEGER"), new SqlColumn("cannot_reply_reason", "TEXT"), new SqlColumn("mute_until", "INTEGER"), new SqlColumn("is_subscribed", "INTEGER"), new SqlColumn("folder", "TEXT"), new SqlColumn("draft", "TEXT"), new SqlColumn("has_missed_call", "INTEGER"), new SqlColumn("me_bubble_color", "INTEGER"), new SqlColumn("other_bubble_color", "INTEGER"), new SqlColumn("wallpaper_color", "INTEGER"), new SqlColumn("last_fetch_action_id", "INTEGER"), new SqlColumn("initial_fetch_complete", "INTEGER"), new SqlColumn("custom_like_emoji", "TEXT")}), new PrimaryKey(ImmutableList.of(sqlColumn)));
        String str = ThreadsTable.f10817c;
        SQLiteDetour.a(974994327);
        sQLiteDatabase.execSQL(str);
        SQLiteDetour.a(-2074213569);
    }

    private static void m11210M(SQLiteDatabase sQLiteDatabase) {
        SQLiteDetour.a(-1450955760);
        sQLiteDatabase.execSQL("ALTER TABLE threads ADD COLUMN message_lifetime INTEGER");
        SQLiteDetour.a(538322471);
    }

    private static void m11211N(SQLiteDatabase sQLiteDatabase) {
        SQLiteDetour.a(1204624762);
        sQLiteDatabase.execSQL("ALTER TABLE thread_users ADD COLUMN can_viewer_message INTEGER");
        SQLiteDetour.a(-1041471077);
    }

    private static void m11212O(SQLiteDatabase sQLiteDatabase) {
        SQLiteDetour.a(2012144047);
        sQLiteDatabase.execSQL("ALTER TABLE messages ADD COLUMN message_lifetime INTEGER");
        SQLiteDetour.a(-2095021762);
    }

    private static void m11213P(SQLiteDatabase sQLiteDatabase) {
        SQLiteDetour.a(-51377902);
        sQLiteDatabase.execSQL("ALTER TABLE thread_users ADD COLUMN commerce_page_settings TEXT");
        SQLiteDetour.a(2090199477);
    }

    private static void m11214Q(SQLiteDatabase sQLiteDatabase) {
        SQLiteDetour.a(-307193291);
        sQLiteDatabase.execSQL("ALTER TABLE messages ADD COLUMN admin_text_thread_message_lifetime INTEGER");
        SQLiteDetour.a(-923717431);
    }

    private static void m11215R(SQLiteDatabase sQLiteDatabase) {
        SQLiteDetour.a(-335718318);
        sQLiteDatabase.execSQL("ALTER TABLE thread_users ADD COLUMN is_friend INTEGER");
        SQLiteDetour.a(-1170383923);
    }

    private static void m11216S(SQLiteDatabase sQLiteDatabase) {
        SQLiteDetour.a(-742206917);
        sQLiteDatabase.execSQL("ALTER TABLE thread_users ADD COLUMN last_fetch_time INTEGER");
        SQLiteDetour.a(1303437808);
    }

    private static void m11217T(SQLiteDatabase sQLiteDatabase) {
        SQLiteDetour.a(-1898923947);
        sQLiteDatabase.execSQL("ALTER TABLE thread_users ADD COLUMN montage_thread_fbid TEXT");
        SQLiteDetour.a(-1452769025);
        SQLiteDetour.a(1305189149);
        sQLiteDatabase.execSQL("ALTER TABLE thread_users ADD COLUMN can_see_viewer_montage_thread INTEGER");
        SQLiteDetour.a(358173449);
    }

    private static void m11218U(SQLiteDatabase sQLiteDatabase) {
        SQLiteDetour.a(-1011625195);
        sQLiteDatabase.execSQL("ALTER TABLE threads ADD COLUMN bot_participants TEXT");
        SQLiteDetour.a(-54113241);
        SQLiteDetour.a(-1723159044);
        sQLiteDatabase.execSQL("ALTER TABLE thread_users ADD COLUMN is_messenger_bot INTEGER");
        SQLiteDetour.a(-1379666833);
    }

    private static void m11219V(SQLiteDatabase sQLiteDatabase) {
        SqlColumn sqlColumn = new SqlColumn("folder", "TEXT");
        ImmutableList of = ImmutableList.of(sqlColumn, new SqlColumn("unread_count", "INTEGER"), new SqlColumn("unseen_count", "INTEGER"), new SqlColumn("last_seen_time", "INTEGER"), new SqlColumn("last_action_id", "INTEGER"));
        PrimaryKey primaryKey = new PrimaryKey(ImmutableList.of(sqlColumn));
        SqlColumn sqlColumn2 = new SqlColumn("thread_key", "TEXT");
        ImmutableList of2 = ImmutableList.of(sqlColumn, sqlColumn2, new SqlColumn("timestamp_ms", "INTEGER"));
        primaryKey = new PrimaryKey(ImmutableList.of(sqlColumn2));
        ImmutableList of3 = ImmutableList.of(sqlColumn2, new SqlColumn("legacy_thread_id", "TEXT"), new SqlColumn("action_id", "INTEGER"), new SqlColumn("refetch_action_id", "INTEGER"), new SqlColumn("last_visible_action_id", "INTEGER"), new SqlColumn("sequence_id", "INTEGER"), new SqlColumn("name", "TEXT"), new SqlColumn("participants", "TEXT"), new SqlColumn("former_participants", "TEXT"), new SqlColumn("bot_participants", "TEXT"), new SqlColumn("senders", "TEXT"), new SqlColumn("snippet", "TEXT"), new SqlColumn[]{new SqlColumn("snippet_sender", "TEXT"), new SqlColumn("admin_snippet", "TEXT"), new SqlColumn("timestamp_ms", "INTEGER"), new SqlColumn("last_read_timestamp_ms", "INTEGER"), new SqlColumn("unread_message_count", "INTEGER"), new SqlColumn("last_fetch_time_ms", "INTEGER"), new SqlColumn("pic_hash", "TEXT"), new SqlColumn("pic", "TEXT"), new SqlColumn("can_reply_to", "INTEGER"), new SqlColumn("cannot_reply_reason", "TEXT"), new SqlColumn("mute_until", "INTEGER"), new SqlColumn("is_subscribed", "INTEGER"), new SqlColumn("folder", "TEXT"), new SqlColumn("draft", "TEXT"), new SqlColumn("has_missed_call", "INTEGER"), new SqlColumn("me_bubble_color", "INTEGER"), new SqlColumn("other_bubble_color", "INTEGER"), new SqlColumn("wallpaper_color", "INTEGER"), new SqlColumn("last_fetch_action_id", "INTEGER"), new SqlColumn("initial_fetch_complete", "INTEGER"), new SqlColumn("custom_like_emoji", "TEXT"), new SqlColumn("message_lifetime", "INTEGER")});
        PrimaryKey primaryKey2 = new PrimaryKey(ImmutableList.of(sqlColumn2));
        ImmutableBiMap b = ImmutableBiMap.b(sqlColumn, SqlColumn.f(":0123456789"));
        SqlTable.a(sQLiteDatabase, "folder_counts", of, b, primaryKey);
        SqlTable.a(sQLiteDatabase, "folders", of2, b, primaryKey);
        String str = FoldersTable.f10686c;
        SQLiteDetour.a(134762108);
        sQLiteDatabase.execSQL(str);
        SQLiteDetour.a(-2045016241);
        SqlTable.a(sQLiteDatabase, "threads", of3, b, primaryKey2);
        String str2 = ThreadsTable.f10817c;
        SQLiteDetour.a(-994563704);
        sQLiteDatabase.execSQL(str2);
        SQLiteDetour.a(165395755);
    }

    private static void m11220W(SQLiteDatabase sQLiteDatabase) {
        SQLiteDetour.a(-663907761);
        sQLiteDatabase.execSQL("ALTER TABLE messages ADD send_channel TEXT");
        SQLiteDetour.a(1539597954);
    }

    private static void m11221X(SQLiteDatabase sQLiteDatabase) {
        SQLiteDetour.a(1557019122);
        sQLiteDatabase.execSQL("ALTER TABLE messages ADD send_error_number INTEGER");
        SQLiteDetour.a(-388901306);
    }

    private static void m11222Y(SQLiteDatabase sQLiteDatabase) {
        String a = SqlTable.a("threads", new SqlColumn("outgoing_message_lifetime", "INTEGER"));
        SQLiteDetour.a(-1285584450);
        sQLiteDatabase.execSQL(a);
        SQLiteDetour.a(-1994200327);
        a = StringFormatUtil.formatStrLocaleSafe("UPDATE %s SET %s = %s", "threads", "outgoing_message_lifetime", "message_lifetime");
        SQLiteDetour.a(-1013816905);
        sQLiteDatabase.execSQL(a);
        SQLiteDetour.a(-2110939133);
        SqlColumn sqlColumn = new SqlColumn("thread_key", "TEXT");
        SQLiteDatabase sQLiteDatabase2 = sQLiteDatabase;
        SqlTable.a(sQLiteDatabase2, "threads", ImmutableList.of(sqlColumn, new SqlColumn("legacy_thread_id", "TEXT"), new SqlColumn("action_id", "INTEGER"), new SqlColumn("refetch_action_id", "INTEGER"), new SqlColumn("last_visible_action_id", "INTEGER"), new SqlColumn("sequence_id", "INTEGER"), new SqlColumn("name", "TEXT"), new SqlColumn("participants", "TEXT"), new SqlColumn("former_participants", "TEXT"), new SqlColumn("bot_participants", "TEXT"), new SqlColumn("senders", "TEXT"), new SqlColumn("snippet", "TEXT"), new SqlColumn[]{new SqlColumn("snippet_sender", "TEXT"), new SqlColumn("admin_snippet", "TEXT"), new SqlColumn("timestamp_ms", "INTEGER"), new SqlColumn("last_read_timestamp_ms", "INTEGER"), new SqlColumn("unread_message_count", "INTEGER"), new SqlColumn("last_fetch_time_ms", "INTEGER"), new SqlColumn("pic_hash", "TEXT"), new SqlColumn("pic", "TEXT"), new SqlColumn("can_reply_to", "INTEGER"), new SqlColumn("cannot_reply_reason", "TEXT"), new SqlColumn("mute_until", "INTEGER"), new SqlColumn("is_subscribed", "INTEGER"), new SqlColumn("folder", "TEXT"), new SqlColumn("draft", "TEXT"), new SqlColumn("has_missed_call", "INTEGER"), new SqlColumn("me_bubble_color", "INTEGER"), new SqlColumn("other_bubble_color", "INTEGER"), new SqlColumn("wallpaper_color", "INTEGER"), new SqlColumn("last_fetch_action_id", "INTEGER"), new SqlColumn("initial_fetch_complete", "INTEGER"), new SqlColumn("custom_like_emoji", "TEXT"), new SqlColumn("outgoing_message_lifetime", "INTEGER")}), new PrimaryKey(ImmutableList.of(sqlColumn)));
        a = ThreadsTable.f10817c;
        SQLiteDetour.a(-1514056169);
        sQLiteDatabase.execSQL(a);
        SQLiteDetour.a(2096162469);
    }

    private static void m11223Z(SQLiteDatabase sQLiteDatabase) {
        SQLiteDetour.a(-1043976596);
        sQLiteDatabase.execSQL("ALTER TABLE threads ADD COLUMN approx_total_message_count INTEGER");
        SQLiteDetour.a(-775199361);
        SQLiteDetour.a(952992575);
        sQLiteDatabase.execSQL("UPDATE threads SET approx_total_message_count=1");
        SQLiteDetour.a(1939337985);
    }

    private static void aa(SQLiteDatabase sQLiteDatabase) {
        SQLiteDetour.a(-173878146);
        sQLiteDatabase.execSQL("ALTER TABLE messages ADD COLUMN admin_text_thread_journey_color_choices TEXT");
        SQLiteDetour.a(-1714545033);
        SQLiteDetour.a(1694866016);
        sQLiteDatabase.execSQL("ALTER TABLE messages ADD COLUMN admin_text_thread_journey_emoji_choices TEXT");
        SQLiteDetour.a(-893660868);
    }

    private static void ab(SQLiteDatabase sQLiteDatabase) {
        SQLiteDetour.a(-394481963);
        sQLiteDatabase.execSQL("ALTER TABLE messages ADD COLUMN admin_text_thread_journey_nickname_choices TEXT");
        SQLiteDetour.a(1960377578);
    }

    private static void ac(SQLiteDatabase sQLiteDatabase) {
        SQLiteDetour.a(511545185);
        sQLiteDatabase.execSQL("ALTER TABLE threads ADD COLUMN custom_nicknames TEXT");
        SQLiteDetour.a(-1714848331);
    }

    private static void ad(SQLiteDatabase sQLiteDatabase) {
        SQLiteDetour.a(2124816877);
        sQLiteDatabase.execSQL("ALTER TABLE threads ADD COLUMN invite_uri TEXT");
        SQLiteDetour.a(-136314500);
    }

    private static void ae(SQLiteDatabase sQLiteDatabase) {
        SQLiteDetour.a(672390042);
        sQLiteDatabase.execSQL("ALTER TABLE thread_users ADD COLUMN is_messenger_promotion_blocked_by_viewer INTEGER");
        SQLiteDetour.a(-1508842056);
    }

    private static void af(SQLiteDatabase sQLiteDatabase) {
        SQLiteDetour.a(894612171);
        sQLiteDatabase.execSQL("ALTER TABLE messages ADD COLUMN payment_request TEXT");
        SQLiteDetour.a(603805907);
    }

    private static void ag(SQLiteDatabase sQLiteDatabase) {
        SQLiteDetour.a(-2032879558);
        sQLiteDatabase.execSQL("ALTER TABLE messages ADD COLUMN admin_text_thread_rtc_event TEXT");
        SQLiteDetour.a(-539557696);
        SQLiteDetour.a(-90091815);
        sQLiteDatabase.execSQL("ALTER TABLE messages ADD COLUMN admin_text_thread_rtc_server_info_data TEXT");
        SQLiteDetour.a(-188738935);
        SQLiteDetour.a(1591138821);
        sQLiteDatabase.execSQL("ALTER TABLE messages ADD COLUMN admin_text_thread_rtc_is_video_call INTEGER");
        SQLiteDetour.a(-1800797489);
    }

    private static void ah(SQLiteDatabase sQLiteDatabase) {
        SQLiteDetour.a(-1169496200);
        sQLiteDatabase.execSQL("ALTER TABLE messages ADD COLUMN admin_text_target_id TEXT");
        SQLiteDetour.a(674209730);
    }

    private static void ai(SQLiteDatabase sQLiteDatabase) {
        SQLiteDetour.a(1910581187);
        sQLiteDatabase.execSQL("ALTER TABLE messages ADD COLUMN admin_text_nickname TEXT");
        SQLiteDetour.a(-1781991492);
    }

    private static void aj(SQLiteDatabase sQLiteDatabase) {
        SQLiteDetour.a(835847202);
        sQLiteDatabase.execSQL("ALTER TABLE messages ADD COLUMN admin_text_thread_journey_bot_choices TEXT");
        SQLiteDetour.a(-1357132353);
    }

    private static void ak(SQLiteDatabase sQLiteDatabase) {
        Cursor rawQuery = sQLiteDatabase.rawQuery("SELECT msg_id, xma FROM messages WHERE xma IS NOT NULL;", null);
        if (rawQuery != null) {
            try {
                if (rawQuery.moveToFirst()) {
                    do {
                        String string = rawQuery.getString(0);
                        try {
                            JSONObject jSONObject = new JSONObject(rawQuery.getString(1));
                            if (jSONObject.has("story_attachment")) {
                                JSONObject jSONObject2 = jSONObject.getJSONObject("story_attachment");
                                if (jSONObject2.has("properties")) {
                                    Object obj = jSONObject2.get("properties");
                                    jSONObject2.remove("properties");
                                    jSONObject2.put("attachment_properties", obj);
                                    String jSONObject3 = jSONObject.toString();
                                    ContentValues contentValues = new ContentValues();
                                    contentValues.put("xma", jSONObject3);
                                    String[] strArr = new String[]{string};
                                    sQLiteDatabase.updateWithOnConflict("messages", contentValues, "msg_id=?", strArr, 4);
                                }
                            }
                        } catch (Throwable e) {
                            BLog.c("ThreadsDbSchemaPart", "JSONException", e);
                            throw new RuntimeException(e);
                        }
                    } while (rawQuery.moveToNext());
                }
                rawQuery.close();
            } catch (Throwable th) {
                rawQuery.close();
            }
        }
    }

    private void al(SQLiteDatabase sQLiteDatabase) {
        PrimaryKey primaryKey = new PrimaryKey(ImmutableList.of(new SqlColumn("thread_key", "TEXT"), new SqlColumn("user_key", "TEXT")));
        String a = SqlTable.a("thread_participants", ImmutableList.of(new SqlColumn("thread_key", "TEXT"), new SqlColumn("user_key", "TEXT"), new SqlColumn("email", "TEXT"), new SqlColumn("type", "TEXT NOT NULL"), new SqlColumn("last_read_receipt_time", "INTEGER"), new SqlColumn("last_delivered_receipt_time", "INTEGER"), new SqlColumn("last_delivered_receipt_id", "TEXT")), ImmutableList.of(primaryKey));
        SQLiteDetour.a(1939782266);
        sQLiteDatabase.execSQL(a);
        SQLiteDetour.a(-1578415305);
        ((DbThreadParticipantsUtil) this.f10819a.get()).m11125a(sQLiteDatabase);
        SqlColumn sqlColumn = new SqlColumn("thread_key", "TEXT");
        SQLiteDatabase sQLiteDatabase2 = sQLiteDatabase;
        SqlTable.a(sQLiteDatabase2, "threads", ImmutableList.of(sqlColumn, new SqlColumn("legacy_thread_id", "TEXT"), new SqlColumn("action_id", "INTEGER"), new SqlColumn("refetch_action_id", "INTEGER"), new SqlColumn("last_visible_action_id", "INTEGER"), new SqlColumn("sequence_id", "INTEGER"), new SqlColumn("name", "TEXT"), new SqlColumn("senders", "TEXT"), new SqlColumn("snippet", "TEXT"), new SqlColumn("snippet_sender", "TEXT"), new SqlColumn("admin_snippet", "TEXT"), new SqlColumn("timestamp_ms", "INTEGER"), new SqlColumn[]{new SqlColumn("last_read_timestamp_ms", "INTEGER"), new SqlColumn("approx_total_message_count", "INTEGER"), new SqlColumn("unread_message_count", "INTEGER"), new SqlColumn("last_fetch_time_ms", "INTEGER"), new SqlColumn("pic_hash", "TEXT"), new SqlColumn("pic", "TEXT"), new SqlColumn("can_reply_to", "INTEGER"), new SqlColumn("cannot_reply_reason", "TEXT"), new SqlColumn("mute_until", "INTEGER"), new SqlColumn("is_subscribed", "INTEGER"), new SqlColumn("folder", "TEXT"), new SqlColumn("draft", "TEXT"), new SqlColumn("has_missed_call", "INTEGER"), new SqlColumn("me_bubble_color", "INTEGER"), new SqlColumn("other_bubble_color", "INTEGER"), new SqlColumn("wallpaper_color", "INTEGER"), new SqlColumn("last_fetch_action_id", "INTEGER"), new SqlColumn("initial_fetch_complete", "INTEGER"), new SqlColumn("custom_like_emoji", "TEXT"), new SqlColumn("outgoing_message_lifetime", "INTEGER"), new SqlColumn("custom_nicknames", "TEXT"), new SqlColumn("invite_uri", "TEXT")}), new PrimaryKey(ImmutableList.of(sqlColumn)));
        a = ThreadsTable.f10817c;
        SQLiteDetour.a(1729602944);
        sQLiteDatabase.execSQL(a);
        SQLiteDetour.a(2028220388);
    }

    private static void am(SQLiteDatabase sQLiteDatabase) {
        SQLiteDetour.a(505069376);
        sQLiteDatabase.execSQL("ALTER TABLE messages ADD COLUMN admin_text_thread_ride_provider_name TEXT");
        SQLiteDetour.a(2138233600);
    }

    private static void an(SQLiteDatabase sQLiteDatabase) {
        SQLiteDetour.a(-1028679335);
        sQLiteDatabase.execSQL("ALTER TABLE thread_users ADD COLUMN username TEXT");
        SQLiteDetour.a(2015813674);
    }

    private static void ao(SQLiteDatabase sQLiteDatabase) {
        SQLiteDetour.a(522111529);
        sQLiteDatabase.execSQL("ALTER TABLE thread_participants ADD COLUMN is_admin INTEGER");
        SQLiteDetour.a(-533129272);
    }

    private static void ap(SQLiteDatabase sQLiteDatabase) {
        SQLiteDetour.a(506268290);
        sQLiteDatabase.execSQL("ALTER TABLE group_conversations ADD COLUMN group_chat_rank FLOAT");
        SQLiteDetour.a(-1288122243);
    }

    private static void aq(SQLiteDatabase sQLiteDatabase) {
        SQLiteDetour.a(346567425);
        sQLiteDatabase.execSQL("ALTER TABLE threads ADD COLUMN is_last_message_sponsored INTEGER");
        SQLiteDetour.a(1985331669);
    }

    private static void ar(SQLiteDatabase sQLiteDatabase) {
        SQLiteDetour.a(-254625281);
        sQLiteDatabase.execSQL("ALTER TABLE messages ADD COLUMN is_sponsored INTEGER");
        SQLiteDetour.a(537951694);
    }

    private static void as(SQLiteDatabase sQLiteDatabase) {
        SQLiteDetour.a(-953340330);
        sQLiteDatabase.execSQL("ALTER TABLE messages ADD COLUMN admin_text_thread_ad_properties TEXT");
        SQLiteDetour.a(-67372580);
    }

    private static void at(SQLiteDatabase sQLiteDatabase) {
        SQLiteDetour.a(-1075725122);
        sQLiteDatabase.execSQL("ALTER TABLE threads ADD COLUMN group_chat_rank FLOAT");
        SQLiteDetour.a(-811033817);
    }

    private static void au(SQLiteDatabase sQLiteDatabase) {
        PrimaryKey primaryKey = new PrimaryKey(ImmutableList.of(new SqlColumn("event_reminder_key", "TEXT")));
        String a = SqlTable.a("event_reminders", ImmutableList.of(new SqlColumn("thread_key", "TEXT"), new SqlColumn("event_reminder_key", "TEXT"), new SqlColumn("event_reminder_timestamp", "INTEGER")), ImmutableList.of(primaryKey));
        SQLiteDetour.a(-791498844);
        sQLiteDatabase.execSQL(a);
        SQLiteDetour.a(-1957248151);
    }

    private static void av(SQLiteDatabase sQLiteDatabase) {
        SQLiteDetour.a(1307401084);
        sQLiteDatabase.execSQL("ALTER TABLE threads ADD COLUMN game_data TEXT");
        SQLiteDetour.a(565421766);
    }

    private static void aw(SQLiteDatabase sQLiteDatabase) {
        SQLiteDetour.a(-1908319959);
        sQLiteDatabase.execSQL("ALTER TABLE messages ADD COLUMN admin_text_game_score_data TEXT");
        SQLiteDetour.a(-155178596);
    }

    private static void ax(SQLiteDatabase sQLiteDatabase) {
        SQLiteDetour.a(872132233);
        sQLiteDatabase.execSQL("ALTER TABLE messages ADD COLUMN admin_text_thread_event_reminder_properties TEXT");
        SQLiteDetour.a(609835203);
    }

    private static void ay(SQLiteDatabase sQLiteDatabase) {
        SQLiteDetour.a(-1782416805);
        sQLiteDatabase.execSQL("ALTER TABLE thread_users ADD COLUMN user_custom_tags TEXT");
        SQLiteDetour.a(1460419358);
    }

    private static void az(SQLiteDatabase sQLiteDatabase) {
        FbObjectMapper fbObjectMapper = new FbObjectMapper(null);
        JsonFactory jsonFactory = new JsonFactory(fbObjectMapper);
        Cursor rawQuery = sQLiteDatabase.rawQuery("SELECT msg_id, xma FROM messages WHERE xma IS NOT NULL;", null);
        if (rawQuery != null) {
            try {
                if (rawQuery.moveToFirst()) {
                    do {
                        String string = rawQuery.getString(0);
                        try {
                            JsonNode a = fbObjectMapper.a(rawQuery.getString(1));
                            if (a.d("story_attachment")) {
                                ObjectNode objectNode = (ObjectNode) a.b("story_attachment");
                                if (objectNode.d("large_media") && objectNode.d("media")) {
                                    ObjectNode objectNode2 = (ObjectNode) objectNode.b("media");
                                    JsonNode b = objectNode.b("large_media");
                                    objectNode.h("large_media");
                                    if (b.d("image")) {
                                        objectNode2.c("imageLarge", b.b("image"));
                                        String jsonNode = a.toString();
                                        ContentValues contentValues = new ContentValues();
                                        contentValues.put("xma", jsonNode);
                                        SQLiteDatabase sQLiteDatabase2 = sQLiteDatabase;
                                        sQLiteDatabase2.updateWithOnConflict("messages", contentValues, "msg_id=?", new String[]{string}, 4);
                                    }
                                }
                            }
                        } catch (Throwable e) {
                            BLog.c("ThreadsDbSchemaPart", "JSONException", e);
                            throw new RuntimeException(e);
                        }
                    } while (rawQuery.moveToNext());
                }
                rawQuery.close();
            } catch (Throwable th) {
                rawQuery.close();
            }
        }
    }

    private static void aA(SQLiteDatabase sQLiteDatabase) {
        SQLiteDetour.a(770288662);
        sQLiteDatabase.execSQL("ALTER TABLE event_reminders ADD COLUMN event_reminder_title TEXT");
        SQLiteDetour.a(-813837309);
    }

    private static void aB(SQLiteDatabase sQLiteDatabase) {
        SqlColumn sqlColumn = new SqlColumn("thread_key", "TEXT");
        SqlColumn sqlColumn2 = new SqlColumn("user_key", "TEXT");
        SqlTable.a(sQLiteDatabase, "thread_participants", "threads", ImmutableList.of(sqlColumn, sqlColumn2, new SqlColumn("email", "TEXT"), new SqlColumn("type", "TEXT NOT NULL"), new SqlColumn("is_admin", "INTEGER"), new SqlColumn("last_read_receipt_time", "INTEGER"), new SqlColumn("last_delivered_receipt_time", "INTEGER"), new SqlColumn("last_delivered_receipt_id", "TEXT")), ImmutableList.of(sqlColumn, sqlColumn2), ImmutableList.of(sqlColumn), "ON DELETE CASCADE");
        SqlColumn sqlColumn3 = new SqlColumn("event_reminder_key", "TEXT");
        SqlTable.a(sQLiteDatabase, "event_reminders", "threads", ImmutableList.of(sqlColumn, sqlColumn3, new SqlColumn("event_reminder_timestamp", "INTEGER"), new SqlColumn("event_reminder_title", "TEXT")), ImmutableList.of(sqlColumn3), ImmutableList.of(sqlColumn), "ON DELETE CASCADE");
    }

    private static void aC(SQLiteDatabase sQLiteDatabase) {
        SQLiteDetour.a(-581733353);
        sQLiteDatabase.execSQL("ALTER TABLE threads ADD COLUMN group_type TEXT DEFAULT 'private'");
        SQLiteDetour.a(-64284377);
        SQLiteDetour.a(-1730595825);
        sQLiteDatabase.execSQL("ALTER TABLE threads ADD COLUMN requires_approval INTEGER DEFAULT 0");
        SQLiteDetour.a(-1774430234);
    }

    private static void aD(SQLiteDatabase sQLiteDatabase) {
        SQLiteDetour.a(-1551573585);
        sQLiteDatabase.execSQL("ALTER TABLE threads ADD COLUMN rtc_call_info TEXT");
        SQLiteDetour.a(-1397779136);
    }

    private static void aE(SQLiteDatabase sQLiteDatabase) {
        SQLiteDetour.a(-326308075);
        sQLiteDatabase.execSQL("ALTER TABLE thread_users ADD COLUMN is_receiving_subscription_messages INTEGER");
        SQLiteDetour.a(1934173441);
    }

    private static void aF(SQLiteDatabase sQLiteDatabase) {
        SQLiteDetour.a(-423648849);
        sQLiteDatabase.execSQL("ALTER TABLE messages ADD COLUMN commerce_message_type TEXT");
        SQLiteDetour.a(-2016166942);
    }

    private static void aG(SQLiteDatabase sQLiteDatabase) {
        SQLiteDetour.a(-1809729367);
        sQLiteDatabase.execSQL("ALTER TABLE threads ADD COLUMN last_message_commerce_message_type TEXT");
        SQLiteDetour.a(535745131);
    }

    private static void aH(SQLiteDatabase sQLiteDatabase) {
        SqlColumn sqlColumn = new SqlColumn("event_reminder_key", "TEXT");
        SqlColumn sqlColumn2 = new SqlColumn("user_key", "TEXT");
        PrimaryKey primaryKey = new PrimaryKey(ImmutableList.of(sqlColumn, sqlColumn2));
        String a = SqlTable.a("event_reminder_members", ImmutableList.of(sqlColumn, sqlColumn2, new SqlColumn("member_guest_status", "TEXT")), ImmutableList.of(primaryKey));
        SQLiteDetour.a(925946430);
        sQLiteDatabase.execSQL(a);
        SQLiteDetour.a(501559208);
    }

    private static void aI(SQLiteDatabase sQLiteDatabase) {
        SQLiteDetour.a(-826549070);
        sQLiteDatabase.execSQL("ALTER TABLE thread_participants ADD COLUMN phone TEXT");
        SQLiteDetour.a(1325082590);
    }

    private static void aJ(SQLiteDatabase sQLiteDatabase) {
        SQLiteDetour.a(-627708025);
        sQLiteDatabase.execSQL("ALTER TABLE messages ADD COLUMN customizations TEXT");
        SQLiteDetour.a(1220983057);
    }

    private static void aK(SQLiteDatabase sQLiteDatabase) {
        SQLiteDetour.a(397360832);
        sQLiteDatabase.execSQL("ALTER TABLE threads ADD COLUMN is_thread_queue_enabled INTEGER");
        SQLiteDetour.a(-834881261);
    }

    private static void aL(SQLiteDatabase sQLiteDatabase) {
        SQLiteDetour.a(-1862457537);
        sQLiteDatabase.execSQL("ALTER TABLE event_reminders ADD COLUMN allows_rsvp INTEGER");
        SQLiteDetour.a(-429643660);
    }

    private static void aM(SQLiteDatabase sQLiteDatabase) {
        SQLiteDetour.a(1508902128);
        sQLiteDatabase.execSQL("ALTER TABLE messages ADD COLUMN quick_reply TEXT");
        SQLiteDetour.a(-1567264989);
    }

    private static void aN(SQLiteDatabase sQLiteDatabase) {
        SQLiteDetour.a(1175151510);
        sQLiteDatabase.execSQL("ALTER TABLE messages ADD COLUMN admin_text_joinable_event_type TEXT");
        SQLiteDetour.a(1793282709);
    }

    private static void aO(SQLiteDatabase sQLiteDatabase) {
        SQLiteDetour.a(324825916);
        sQLiteDatabase.execSQL("ALTER TABLE thread_users ADD COLUMN is_messenger_platform_bot INTEGER");
        SQLiteDetour.a(1772266022);
    }

    private static void aP(SQLiteDatabase sQLiteDatabase) {
        SQLiteDetour.a(1888994669);
        sQLiteDatabase.execSQL("ALTER TABLE thread_users ADD COLUMN user_call_to_actions TEXT");
        SQLiteDetour.a(-882418342);
    }

    private static void aQ(SQLiteDatabase sQLiteDatabase) {
        SQLiteDetour.a(512946887);
        sQLiteDatabase.execSQL("ALTER TABLE thread_participants ADD COLUMN request_timestamp_ms INTEGER");
        SQLiteDetour.a(-48192690);
    }

    private static void aR(SQLiteDatabase sQLiteDatabase) {
        SQLiteDetour.a(1720288044);
        sQLiteDatabase.execSQL("ALTER TABLE messages ADD COLUMN metadata_at_text_ranges TEXT");
        SQLiteDetour.a(-373559576);
    }

    private static void aS(SQLiteDatabase sQLiteDatabase) {
        SQLiteDetour.a(1986667807);
        sQLiteDatabase.execSQL("ALTER TABLE messages ADD COLUMN platform_metadata TEXT");
        SQLiteDetour.a(1829900865);
    }

    private static void aT(SQLiteDatabase sQLiteDatabase) {
        SqlColumn sqlColumn = new SqlColumn("msg_id", "TEXT");
        SQLiteDatabase sQLiteDatabase2 = sQLiteDatabase;
        SqlTable.a(sQLiteDatabase2, "messages", ImmutableList.of(sqlColumn, new SqlColumn("thread_key", "TEXT"), new SqlColumn("action_id", "INTEGER"), new SqlColumn("text", "TEXT"), new SqlColumn("sender", "TEXT"), new SqlColumn("is_not_forwardable", "INTEGER"), new SqlColumn("timestamp_ms", "INTEGER"), new SqlColumn("timestamp_sent_ms", "INTEGER"), new SqlColumn("attachments", "TEXT"), new SqlColumn("shares", "TEXT"), new SqlColumn("sticker_id", "TEXT"), new SqlColumn("msg_type", "INTEGER"), new SqlColumn[]{new SqlColumn("affected_users", "TEXT"), new SqlColumn("coordinates", "TEXT"), new SqlColumn("offline_threading_id", "TEXT"), new SqlColumn("source", "TEXT"), new SqlColumn("channel_source", "TEXT"), new SqlColumn("send_channel", "TEXT"), new SqlColumn("is_non_authoritative", "INTEGER"), new SqlColumn("pending_send_media_attachment", "STRING"), new SqlColumn("sent_share_attachment", "STRING"), new SqlColumn("client_tags", "TEXT"), new SqlColumn("send_error", "STRING"), new SqlColumn("send_error_message", "STRING"), new SqlColumn("send_error_number", "INTEGER"), new SqlColumn("send_error_timestamp_ms", "INTEGER"), new SqlColumn("send_error_error_url", "STRING"), new SqlColumn("publicity", "TEXT"), new SqlColumn("send_queue_type", "TEXT"), new SqlColumn("payment_transaction", "TEXT"), new SqlColumn("payment_request", "TEXT"), new SqlColumn("has_unavailable_attachment", "INTEGER"), new SqlColumn("app_attribution", "TEXT"), new SqlColumn("content_app_attribution", "TEXT"), new SqlColumn("xma", "TEXT"), new SqlColumn("admin_text_type", "INTEGER"), new SqlColumn("admin_text_theme_color", "INTEGER"), new SqlColumn("admin_text_thread_icon_emoji", "TEXT"), new SqlColumn("admin_text_nickname", "TEXT"), new SqlColumn("admin_text_target_id", "TEXT"), new SqlColumn("admin_text_thread_message_lifetime", "INTEGER"), new SqlColumn("admin_text_thread_journey_color_choices", "TEXT"), new SqlColumn("admin_text_thread_journey_emoji_choices", "TEXT"), new SqlColumn("admin_text_thread_journey_nickname_choices", "TEXT"), new SqlColumn("admin_text_thread_journey_bot_choices", "TEXT"), new SqlColumn("message_lifetime", "INTEGER"), new SqlColumn("admin_text_thread_rtc_event", "TEXT"), new SqlColumn("admin_text_thread_rtc_server_info_data", "TEXT"), new SqlColumn("admin_text_thread_rtc_is_video_call", "INTEGER"), new SqlColumn("admin_text_thread_ride_provider_name", "TEXT"), new SqlColumn("is_sponsored", "INTEGER"), new SqlColumn("admin_text_thread_ad_properties", "TEXT"), new SqlColumn("admin_text_game_score_data", "TEXT"), new SqlColumn("admin_text_thread_event_reminder_properties", "TEXT"), new SqlColumn("commerce_message_type", "TEXT"), new SqlColumn("customizations", "TEXT"), new SqlColumn("admin_text_joinable_event_type", "TEXT"), new SqlColumn("metadata_at_text_ranges", "TEXT"), new SqlColumn("platform_metadata", "TEXT")}), new PrimaryKey(ImmutableList.of(sqlColumn)));
        String str = MessagesTable.f10746c;
        SQLiteDetour.a(1648447766);
        sQLiteDatabase.execSQL(str);
        SQLiteDetour.a(-300554496);
        str = MessagesTable.f10747d;
        SQLiteDetour.a(1637014438);
        sQLiteDatabase.execSQL(str);
        SQLiteDetour.a(213400101);
        str = MessagesTable.f10748e;
        SQLiteDetour.a(457881970);
        sQLiteDatabase.execSQL(str);
        SQLiteDetour.a(299694524);
    }

    private static void m11225a(SQLiteDatabase sQLiteDatabase, String str, String str2) {
        String a = StringFormatUtil.a("UPDATE %s SET %s=(SELECT p.%s FROM %s p WHERE %s=REPLACE(p.%s,'%s',''))", new Object[]{"threads", str2, DbPropertyUtil.b, "properties", Columns.f10789a, DbPropertyUtil.a, str});
        SQLiteDetour.a(-1572849787);
        sQLiteDatabase.execSQL(a);
        SQLiteDetour.a(1969982696);
        a = StringFormatUtil.formatStrLocaleSafe("DELETE FROM %s WHERE key LIKE '%s%%'", "properties", str);
        SQLiteDetour.a(1628524424);
        sQLiteDatabase.execSQL(a);
        SQLiteDetour.a(1943130914);
    }

    private static void aU(SQLiteDatabase sQLiteDatabase) {
        String a = SqlTable.a("users");
        SQLiteDetour.a(-376937270);
        sQLiteDatabase.execSQL(a);
        SQLiteDetour.a(1714080385);
        a = SqlTable.a("friends");
        SQLiteDetour.a(1743021280);
        sQLiteDatabase.execSQL(a);
        SQLiteDetour.a(-884310112);
        a = SqlTable.a("archived_sms_mms_threads");
        SQLiteDetour.a(1580415193);
        sQLiteDatabase.execSQL(a);
        SQLiteDetour.a(-896882091);
        a = SqlTable.a("unread_mms_sms_threads");
        SQLiteDetour.a(1069002663);
        sQLiteDatabase.execSQL(a);
        SQLiteDetour.a(1440761948);
        a = SqlTable.a("group_clusters");
        SQLiteDetour.a(936254714);
        sQLiteDatabase.execSQL(a);
        SQLiteDetour.a(-769856287);
        a = SqlTable.a("properties");
        SQLiteDetour.a(1673914210);
        sQLiteDatabase.execSQL(a);
        SQLiteDetour.a(637972450);
        a = SqlTable.a("folder_counts");
        SQLiteDetour.a(1579520608);
        sQLiteDatabase.execSQL(a);
        SQLiteDetour.a(-696300691);
        a = SqlTable.a("folders");
        SQLiteDetour.a(-1206660113);
        sQLiteDatabase.execSQL(a);
        SQLiteDetour.a(2007523574);
        a = SqlTable.a("threads");
        SQLiteDetour.a(-1375198787);
        sQLiteDatabase.execSQL(a);
        SQLiteDetour.a(293271976);
        a = SqlTable.a("messages");
        SQLiteDetour.a(78911892);
        sQLiteDatabase.execSQL(a);
        SQLiteDetour.a(-1238042616);
        a = SqlTable.a("thread_users");
        SQLiteDetour.a(-1662653402);
        sQLiteDatabase.execSQL(a);
        SQLiteDetour.a(873574391);
        a = SqlTable.a("group_conversations");
        SQLiteDetour.a(1956609009);
        sQLiteDatabase.execSQL(a);
        SQLiteDetour.a(334616655);
        a = SqlTable.a("pinned_threads");
        SQLiteDetour.a(-1382618046);
        sQLiteDatabase.execSQL(a);
        SQLiteDetour.a(964025005);
        a = SqlTable.a("ranked_threads");
        SQLiteDetour.a(-1436899384);
        sQLiteDatabase.execSQL(a);
        SQLiteDetour.a(1453939525);
        a = SqlTable.a("thread_participants");
        SQLiteDetour.a(-1595157805);
        sQLiteDatabase.execSQL(a);
        SQLiteDetour.a(136574905);
    }
}
