package com.facebook.messaging.database.threads;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQueryBuilder;
import android.net.Uri;
import com.facebook.common.util.TriState;
import com.facebook.graphql.enums.GraphQLMessageThreadCannotReplyReason;
import com.facebook.messaging.database.serialization.DbThreadRtcCallInfoSerialization;
import com.facebook.messaging.database.threads.ThreadEventRemindersIterator.Result;
import com.facebook.messaging.database.threads.ThreadParticipantsResultIterator.ThreadParticipantsResult;
import com.facebook.messaging.model.folders.FolderName;
import com.facebook.messaging.model.threadkey.ThreadKey;
import com.facebook.messaging.model.threads.NicknamesMap;
import com.facebook.messaging.model.threads.NotificationSetting;
import com.facebook.messaging.model.threads.ThreadCustomization;
import com.facebook.messaging.model.threads.ThreadCustomization.Builder;
import com.facebook.messaging.model.threads.ThreadEventReminder;
import com.facebook.messaging.model.threads.ThreadJoinRequest;
import com.facebook.messaging.model.threads.ThreadParticipant;
import com.facebook.messaging.model.threads.ThreadRtcCallInfoData;
import com.facebook.messaging.model.threads.ThreadSummary;
import com.facebook.messaging.model.threads.ThreadSummary.GroupType;
import com.facebook.messaging.model.threads.ThreadSummaryBuilder;
import com.fasterxml.jackson.databind.JsonNode;
import com.google.common.base.Strings;
import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Multimap;
import com.google.common.collect.RegularImmutableList;
import java.util.Collection;
import java.util.Iterator;

/* compiled from: max_mfps */
public class ThreadSummaryCursorUtil$Iterator {
    private final int f10593A;
    private final int f10594B;
    private final int f10595C;
    private final int f10596D;
    private final int f10597E;
    private final int f10598F;
    private final int f10599G;
    private final int f10600H;
    public final int f10601I;
    private final int f10602J;
    private final int f10603K;
    private final int f10604L;
    private final int f10605M;
    private final int f10606N;
    private final int f10607O;
    private final int f10608P;
    private final int f10609Q;
    private final int f10610R;
    private ImmutableList<ThreadKey> f10611S;
    private Multimap<ThreadKey, ThreadParticipant> f10612T;
    private Multimap<ThreadKey, ThreadParticipant> f10613U;
    private Multimap<ThreadKey, ThreadParticipant> f10614V;
    private Multimap<ThreadKey, ThreadEventReminder> f10615W;
    private Multimap<ThreadKey, ThreadJoinRequest> f10616X;
    final /* synthetic */ ThreadSummaryCursorUtil f10617a;
    public final Cursor f10618b;
    private final int f10619c;
    private final int f10620d;
    private final int f10621e;
    private final int f10622f;
    private final int f10623g;
    private final int f10624h;
    private final int f10625i;
    private final int f10626j;
    private final int f10627k;
    private final int f10628l;
    private final int f10629m;
    private final int f10630n;
    private final int f10631o;
    private final int f10632p;
    private final int f10633q;
    private final int f10634r;
    private final int f10635s;
    private final int f10636t;
    private final int f10637u;
    private final int f10638v;
    private final int f10639w;
    private final int f10640x;
    private final int f10641y;
    private final int f10642z;

    public ThreadSummaryCursorUtil$Iterator(ThreadSummaryCursorUtil threadSummaryCursorUtil, Cursor cursor, boolean z) {
        this.f10617a = threadSummaryCursorUtil;
        this.f10618b = cursor;
        this.f10619c = cursor.getColumnIndexOrThrow("thread_key");
        this.f10620d = cursor.getColumnIndexOrThrow("legacy_thread_id");
        this.f10621e = cursor.getColumnIndexOrThrow("action_id");
        this.f10622f = cursor.getColumnIndexOrThrow("refetch_action_id");
        this.f10623g = cursor.getColumnIndexOrThrow("last_visible_action_id");
        this.f10624h = cursor.getColumnIndexOrThrow("sequence_id");
        this.f10625i = cursor.getColumnIndexOrThrow("name");
        this.f10626j = cursor.getColumnIndexOrThrow("senders");
        this.f10627k = cursor.getColumnIndexOrThrow("snippet");
        this.f10628l = cursor.getColumnIndexOrThrow("snippet_sender");
        this.f10629m = cursor.getColumnIndexOrThrow("admin_snippet");
        if (z) {
            this.f10630n = cursor.getColumnIndexOrThrow("timestamp_in_folder_ms");
        } else {
            this.f10630n = cursor.getColumnIndexOrThrow("timestamp_ms");
        }
        this.f10631o = cursor.getColumnIndexOrThrow("last_read_timestamp_ms");
        this.f10632p = cursor.getColumnIndexOrThrow("approx_total_message_count");
        this.f10633q = cursor.getColumnIndexOrThrow("unread_message_count");
        this.f10634r = cursor.getColumnIndexOrThrow("pic_hash");
        this.f10635s = cursor.getColumnIndexOrThrow("can_reply_to");
        this.f10636t = cursor.getColumnIndexOrThrow("cannot_reply_reason");
        this.f10637u = cursor.getColumnIndexOrThrow("pic");
        this.f10638v = cursor.getColumnIndexOrThrow("last_fetch_time_ms");
        this.f10639w = cursor.getColumnIndexOrThrow("is_subscribed");
        this.f10640x = cursor.getColumnIndexOrThrow("folder");
        this.f10641y = cursor.getColumnIndexOrThrow("draft");
        this.f10642z = cursor.getColumnIndexOrThrow("has_missed_call");
        this.f10593A = cursor.getColumnIndexOrThrow("mute_until");
        this.f10594B = cursor.getColumnIndexOrThrow("me_bubble_color");
        this.f10595C = cursor.getColumnIndexOrThrow("other_bubble_color");
        this.f10596D = cursor.getColumnIndexOrThrow("wallpaper_color");
        this.f10597E = cursor.getColumnIndexOrThrow("last_fetch_action_id");
        this.f10598F = cursor.getColumnIndexOrThrow("initial_fetch_complete");
        this.f10599G = cursor.getColumnIndexOrThrow("custom_like_emoji");
        this.f10600H = cursor.getColumnIndexOrThrow("outgoing_message_lifetime");
        this.f10601I = cursor.getColumnIndexOrThrow("custom_nicknames");
        this.f10602J = cursor.getColumnIndexOrThrow("invite_uri");
        this.f10603K = cursor.getColumnIndexOrThrow("is_last_message_sponsored");
        this.f10604L = cursor.getColumnIndexOrThrow("group_chat_rank");
        this.f10605M = cursor.getColumnIndexOrThrow("game_data");
        this.f10606N = cursor.getColumnIndexOrThrow("group_type");
        this.f10607O = cursor.getColumnIndexOrThrow("requires_approval");
        this.f10608P = cursor.getColumnIndexOrThrow("rtc_call_info");
        this.f10609Q = cursor.getColumnIndexOrThrow("last_message_commerce_message_type");
        this.f10610R = cursor.getColumnIndexOrThrow("is_thread_queue_enabled");
    }

    public final ThreadSummaryBuilder m11160a() {
        ThreadSummaryCursorUtil$Result c = m11162c();
        return c != null ? c.f10643a : null;
    }

    public final ThreadSummary m11161b() {
        ThreadSummaryCursorUtil$Result c = m11162c();
        return c != null ? c.f10643a.V() : null;
    }

    public final ThreadSummaryCursorUtil$Result m11162c() {
        boolean z = true;
        m11158g();
        m11157f();
        if (!this.f10618b.moveToNext()) {
            return null;
        }
        boolean z2;
        String str;
        String str2;
        TriState triState;
        ThreadSummaryBuilder newBuilder = ThreadSummary.newBuilder();
        ThreadKey a = ThreadKey.a(this.f10618b.getString(this.f10619c));
        newBuilder.a = a;
        newBuilder.b = this.f10618b.getString(this.f10620d);
        newBuilder.c = this.f10618b.getLong(this.f10621e);
        newBuilder.e = this.f10618b.getLong(this.f10622f);
        newBuilder.f = this.f10618b.getLong(this.f10623g);
        newBuilder.d = this.f10618b.getLong(this.f10624h);
        if (!this.f10618b.isNull(this.f10625i)) {
            newBuilder.g = this.f10618b.getString(this.f10625i);
        }
        newBuilder.h = m11156a(this.f10612T, a);
        newBuilder.i = m11156a(this.f10613U, a);
        newBuilder.j = m11156a(this.f10614V, a);
        newBuilder.o = this.f10617a.c.b(this.f10618b.getString(this.f10626j));
        newBuilder.q = this.f10617a.c.a(this.f10618b.getString(this.f10628l));
        newBuilder.p = this.f10618b.getString(this.f10627k);
        newBuilder.r = this.f10618b.getString(this.f10629m);
        newBuilder.k = this.f10618b.getLong(this.f10630n);
        newBuilder.l = this.f10618b.getLong(this.f10631o);
        newBuilder.m = this.f10618b.getLong(this.f10632p);
        newBuilder.n = this.f10618b.getLong(this.f10633q);
        newBuilder.s = Strings.emptyToNull(this.f10618b.getString(this.f10634r));
        if (this.f10618b.getInt(this.f10635s) != 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        newBuilder.u = z2;
        newBuilder.v = GraphQLMessageThreadCannotReplyReason.fromString(this.f10618b.getString(this.f10636t));
        if (!this.f10618b.isNull(this.f10637u)) {
            newBuilder.t = Uri.parse(this.f10618b.getString(this.f10637u));
        }
        if (this.f10618b.getInt(this.f10639w) != 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        newBuilder.w = z2;
        newBuilder.A = FolderName.fromDbName(this.f10618b.getString(this.f10640x));
        newBuilder.B = this.f10617a.d.a(this.f10618b.getString(this.f10641y));
        if (this.f10618b.getInt(this.f10642z) != 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        newBuilder.y = z2;
        newBuilder.C = NotificationSetting.b(this.f10618b.getLong(this.f10593A));
        Builder newBuilder2 = ThreadCustomization.newBuilder();
        newBuilder2.a = this.f10618b.getInt(this.f10596D);
        newBuilder2 = newBuilder2;
        newBuilder2.b = this.f10618b.getInt(this.f10594B);
        newBuilder2 = newBuilder2;
        newBuilder2.c = this.f10618b.getInt(this.f10595C);
        newBuilder2 = newBuilder2;
        newBuilder2.e = this.f10618b.getString(this.f10599G);
        newBuilder2 = newBuilder2;
        if (this.f10618b.isNull(this.f10601I)) {
            str = null;
        } else {
            str = this.f10618b.getString(this.f10601I);
        }
        newBuilder2.f = new NicknamesMap(str);
        newBuilder.D = newBuilder2.g();
        newBuilder.E = this.f10618b.getLong(this.f10597E);
        if (this.f10618b.getInt(this.f10598F) != 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        newBuilder.F = z2;
        newBuilder.G = this.f10618b.getInt(this.f10600H);
        if (!this.f10618b.isNull(this.f10602J)) {
            newBuilder.H = Uri.parse(this.f10618b.getString(this.f10602J));
        }
        if (this.f10618b.getInt(this.f10603K) != 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        newBuilder.J = z2;
        newBuilder.L = this.f10618b.getFloat(this.f10604L);
        newBuilder.M = this.f10617a.e.a(this.f10618b.getString(this.f10605M));
        long j = this.f10618b.getLong(this.f10638v);
        newBuilder.I = m11156a(this.f10615W, a);
        newBuilder.N = GroupType.fromDbValue(this.f10618b.getString(this.f10606N));
        if (this.f10618b.getInt(this.f10607O) == 0) {
            z = false;
        }
        newBuilder.O = z;
        DbThreadRtcCallInfoSerialization dbThreadRtcCallInfoSerialization = this.f10617a.f;
        String string = this.f10618b.getString(this.f10608P);
        String str3 = null;
        if (string != null) {
            JsonNode a2 = dbThreadRtcCallInfoSerialization.a.a(string);
            ThreadRtcCallInfoData.Builder newBuilder3 = ThreadRtcCallInfoData.newBuilder();
            if (a2.b("call_state") != null) {
                str = a2.b("call_state").s();
            } else {
                str = null;
            }
            newBuilder3 = newBuilder3.a(str);
            if (a2.b("server_info") != null) {
                str = a2.b("server_info").s();
            } else {
                str = null;
            }
            newBuilder3.b = str;
            ThreadRtcCallInfoData.Builder builder = newBuilder3;
            if (a2.b("initiator_id") != null) {
                str3 = a2.b("initiator_id").s();
            }
            builder.c = str3;
            str3 = builder.d();
        }
        newBuilder.Q = str3;
        if (this.f10618b.isNull(this.f10609Q)) {
            str2 = null;
        } else {
            str2 = this.f10618b.getString(this.f10609Q);
        }
        newBuilder.R = str2;
        newBuilder.P = m11156a(this.f10616X, a);
        int i = this.f10618b.getInt(this.f10610R);
        if (i == 0) {
            triState = TriState.UNSET;
        } else {
            triState = TriState.fromDbValue(i);
        }
        newBuilder.T = triState;
        return new ThreadSummaryCursorUtil$Result(this.f10617a, newBuilder, j);
    }

    private static <T> ImmutableList<T> m11156a(Multimap<ThreadKey, T> multimap, ThreadKey threadKey) {
        Collection c = multimap.c(threadKey);
        return c != null ? ImmutableList.copyOf(c) : RegularImmutableList.a;
    }

    private void m11157f() {
        if (this.f10615W == null) {
            this.f10615W = ArrayListMultimap.t();
            m11159h();
            if (!this.f10611S.isEmpty()) {
                ThreadEventRemindersIterator threadEventRemindersIterator = new ThreadEventRemindersIterator(DbThreadEventRemindersUtil.m11112a(((ThreadsDatabaseSupplier) this.f10617a.g.get()).a(), this.f10611S, this.f10617a.b.a()));
                try {
                    Iterator it = threadEventRemindersIterator.iterator();
                    while (it.hasNext()) {
                        Result result = (Result) it.next();
                        this.f10615W.a(result.f10566a, result.f10567b);
                    }
                } finally {
                    threadEventRemindersIterator.m11153a();
                }
            }
        }
    }

    private void m11158g() {
        if (this.f10612T == null || this.f10613U == null || this.f10614V == null || this.f10616X == null) {
            this.f10612T = ArrayListMultimap.t();
            this.f10613U = ArrayListMultimap.t();
            this.f10614V = ArrayListMultimap.t();
            this.f10616X = ArrayListMultimap.t();
            m11159h();
            if (!this.f10611S.isEmpty()) {
                SQLiteDatabase a = ((ThreadsDatabaseSupplier) this.f10617a.g.get()).a();
                SQLiteQueryBuilder sQLiteQueryBuilder = new SQLiteQueryBuilder();
                sQLiteQueryBuilder.setTables(DbThreadParticipantsUtil.m11120a(this.f10611S));
                ThreadParticipantsResultIterator threadParticipantsResultIterator = new ThreadParticipantsResultIterator(sQLiteQueryBuilder.query(a, null, null, null, null, null, null));
                try {
                    Iterator it = threadParticipantsResultIterator.iterator();
                    while (it.hasNext()) {
                        ThreadParticipantsResult threadParticipantsResult = (ThreadParticipantsResult) it.next();
                        switch (ThreadSummaryCursorUtil$1.f10592a[threadParticipantsResult.f10587b.ordinal()]) {
                            case 1:
                                this.f10612T.a(threadParticipantsResult.f10586a, threadParticipantsResult.f10588c);
                                break;
                            case 2:
                                this.f10613U.a(threadParticipantsResult.f10586a, threadParticipantsResult.f10588c);
                                break;
                            case 3:
                                this.f10614V.a(threadParticipantsResult.f10586a, threadParticipantsResult.f10588c);
                                break;
                            case 4:
                                this.f10616X.a(threadParticipantsResult.f10586a, new ThreadJoinRequest(threadParticipantsResult.f10589d, threadParticipantsResult.f10590e));
                                break;
                            default:
                                throw new IllegalArgumentException("Improper Thread Participant Type");
                        }
                    }
                } finally {
                    threadParticipantsResultIterator.m11155a();
                }
            }
        }
    }

    private void m11159h() {
        if (this.f10611S == null) {
            ImmutableList.Builder builder = ImmutableList.builder();
            int position = this.f10618b.getPosition();
            try {
                this.f10618b.moveToPosition(-1);
                while (this.f10618b.moveToNext()) {
                    builder.c(ThreadKey.a(this.f10618b.getString(this.f10619c)));
                }
                this.f10611S = builder.b();
            } finally {
                this.f10618b.moveToPosition(position);
            }
        }
    }

    public final void m11163d() {
        this.f10618b.close();
    }
}
