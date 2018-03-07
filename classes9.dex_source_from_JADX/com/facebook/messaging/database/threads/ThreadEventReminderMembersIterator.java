package com.facebook.messaging.database.threads;

import android.database.Cursor;
import com.facebook.common.cursors.CursorIterator;
import com.facebook.graphql.enums.GraphQLLightweightEventGuestStatus;
import com.facebook.messaging.database.threads.ThreadsDbSchemaPart.EventReminderMembersTable.Columns;
import com.facebook.user.model.UserKey;
import java.util.Iterator;

/* compiled from: max_num_phones_in_contact */
public class ThreadEventReminderMembersIterator implements Iterable<Result> {
    private final Cursor f10565a;

    /* compiled from: max_num_phones_in_contact */
    public class Result {
        public final String f10559a;
        public final UserKey f10560b;
        public final GraphQLLightweightEventGuestStatus f10561c;

        public Result(String str, UserKey userKey, GraphQLLightweightEventGuestStatus graphQLLightweightEventGuestStatus) {
            this.f10559a = str;
            this.f10560b = userKey;
            this.f10561c = graphQLLightweightEventGuestStatus;
        }
    }

    /* compiled from: max_num_phones_in_contact */
    class ThreadEventReminderMemberCursorIterator extends CursorIterator<Result> {
        private final int f10562b;
        private final int f10563c;
        private final int f10564d;

        public ThreadEventReminderMemberCursorIterator(Cursor cursor) {
            super(cursor);
            this.f10562b = cursor.getColumnIndexOrThrow(Columns.f10661a.d);
            this.f10563c = cursor.getColumnIndexOrThrow(Columns.f10663c.d);
            this.f10564d = cursor.getColumnIndexOrThrow(Columns.f10662b.d);
        }

        protected final Object m11150a(Cursor cursor) {
            return new Result(cursor.getString(this.f10562b), UserKey.a(cursor.getString(this.f10564d)), GraphQLLightweightEventGuestStatus.fromString(cursor.getString(this.f10563c)));
        }
    }

    public ThreadEventReminderMembersIterator(Cursor cursor) {
        this.f10565a = cursor;
    }

    public Iterator<Result> iterator() {
        return new ThreadEventReminderMemberCursorIterator(this.f10565a);
    }

    public final void m11151a() {
        this.f10565a.close();
    }
}
