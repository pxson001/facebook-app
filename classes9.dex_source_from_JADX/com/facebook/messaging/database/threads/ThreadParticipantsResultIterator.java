package com.facebook.messaging.database.threads;

import android.database.Cursor;
import com.facebook.common.cursors.CursorIterator;
import com.facebook.messaging.database.threads.DbThreadParticipantsUtil.ParticipantType;
import com.facebook.messaging.database.threads.ThreadsDbSchemaPart.ThreadUsersTable.Columns;
import com.facebook.messaging.model.messages.ParticipantInfo;
import com.facebook.messaging.model.threadkey.ThreadKey;
import com.facebook.messaging.model.threads.ThreadParticipant;
import com.facebook.messaging.model.threads.ThreadParticipantBuilder;
import com.facebook.user.model.UserKey;
import java.util.Iterator;
import javax.annotation.Nullable;

/* compiled from: max_num_contacts */
public class ThreadParticipantsResultIterator implements Iterable<ThreadParticipantsResult> {
    private final Cursor f10591a;

    /* compiled from: max_num_contacts */
    class ThreadParticipantsCursorIterator extends CursorIterator<ThreadParticipantsResult> {
        private final int f10574b;
        private final int f10575c;
        private final int f10576d;
        private final int f10577e;
        private final int f10578f;
        private final int f10579g;
        private final int f10580h;
        private final int f10581i;
        private final int f10582j;
        private final int f10583k;
        private final int f10584l;
        private final int f10585m;

        protected final Object m11154a(Cursor cursor) {
            boolean z = true;
            ThreadKey a = ThreadKey.a(this.a.getString(this.f10574b));
            UserKey a2 = UserKey.a(this.a.getString(this.f10575c));
            ParticipantType fromDbValue = ParticipantType.fromDbValue(this.a.getString(this.f10580h));
            if (fromDbValue == ParticipantType.REQUEST) {
                return new ThreadParticipantsResult(a, a2, this.a.getLong(this.f10585m));
            }
            ParticipantInfo participantInfo = new ParticipantInfo(a2, this.a.getString(this.f10576d), this.a.getString(this.f10577e), this.a.getString(this.f10578f), this.a.getInt(this.f10579g) != 0);
            ThreadParticipantBuilder threadParticipantBuilder = new ThreadParticipantBuilder();
            threadParticipantBuilder.a = participantInfo;
            ThreadParticipantBuilder threadParticipantBuilder2 = threadParticipantBuilder;
            threadParticipantBuilder2.d = this.a.getLong(this.f10583k);
            threadParticipantBuilder2 = threadParticipantBuilder2;
            threadParticipantBuilder2.b = this.a.getLong(this.f10582j);
            threadParticipantBuilder2 = threadParticipantBuilder2;
            threadParticipantBuilder2.c = this.a.getString(this.f10584l);
            threadParticipantBuilder2 = threadParticipantBuilder2;
            if (this.a.getInt(this.f10581i) != 1) {
                z = false;
            }
            threadParticipantBuilder2.e = z;
            return new ThreadParticipantsResult(a, threadParticipantBuilder.f(), fromDbValue);
        }

        public ThreadParticipantsCursorIterator(Cursor cursor) {
            super(cursor);
            this.f10574b = cursor.getColumnIndexOrThrow(DbThreadParticipantsUtil.f10452a);
            this.f10575c = cursor.getColumnIndexOrThrow(DbThreadParticipantsUtil.f10453b);
            this.f10576d = cursor.getColumnIndexOrThrow(Columns.e.d);
            this.f10577e = cursor.getColumnIndexOrThrow(DbThreadParticipantsUtil.f10454c);
            this.f10578f = cursor.getColumnIndexOrThrow(DbThreadParticipantsUtil.f10455d);
            this.f10579g = cursor.getColumnIndexOrThrow(Columns.i.d);
            this.f10580h = cursor.getColumnIndexOrThrow(DbThreadParticipantsUtil.f10456e);
            this.f10581i = cursor.getColumnIndexOrThrow(DbThreadParticipantsUtil.f10457f);
            this.f10582j = cursor.getColumnIndexOrThrow(DbThreadParticipantsUtil.f10458g);
            this.f10583k = cursor.getColumnIndexOrThrow(DbThreadParticipantsUtil.f10459h);
            this.f10584l = cursor.getColumnIndexOrThrow(DbThreadParticipantsUtil.f10460i);
            this.f10585m = cursor.getColumnIndexOrThrow(DbThreadParticipantsUtil.f10461j);
        }
    }

    /* compiled from: max_num_contacts */
    public class ThreadParticipantsResult {
        public final ThreadKey f10586a;
        public final ParticipantType f10587b;
        @Nullable
        public final ThreadParticipant f10588c;
        @Nullable
        public final UserKey f10589d;
        public final long f10590e;

        public ThreadParticipantsResult(ThreadKey threadKey, ThreadParticipant threadParticipant, ParticipantType participantType) {
            this.f10586a = threadKey;
            this.f10588c = threadParticipant;
            this.f10587b = participantType;
            this.f10589d = null;
            this.f10590e = 0;
        }

        public ThreadParticipantsResult(ThreadKey threadKey, UserKey userKey, long j) {
            this.f10586a = threadKey;
            this.f10589d = userKey;
            this.f10587b = ParticipantType.REQUEST;
            this.f10588c = null;
            this.f10590e = j;
        }
    }

    public ThreadParticipantsResultIterator(Cursor cursor) {
        this.f10591a = cursor;
    }

    public Iterator<ThreadParticipantsResult> iterator() {
        return new ThreadParticipantsCursorIterator(this.f10591a);
    }

    public final void m11155a() {
        this.f10591a.close();
    }
}
