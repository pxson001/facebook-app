package com.facebook.messaging.database.threads;

import android.database.Cursor;
import com.facebook.common.cursors.CursorIterator;
import com.facebook.messaging.database.threads.ThreadsDbSchemaPart.EventRemindersTable.Columns;
import com.facebook.messaging.model.threadkey.ThreadKey;
import com.facebook.messaging.model.threads.ThreadEventReminder;
import com.facebook.messaging.model.threads.ThreadEventReminder.Builder;
import java.util.Iterator;

/* compiled from: max_num_emails_in_contact */
public class ThreadEventRemindersIterator implements Iterable<Result> {
    private final Cursor f10573a;

    /* compiled from: max_num_emails_in_contact */
    public class Result {
        public final ThreadKey f10566a;
        public final ThreadEventReminder f10567b;

        public Result(ThreadKey threadKey, ThreadEventReminder threadEventReminder) {
            this.f10566a = threadKey;
            this.f10567b = threadEventReminder;
        }
    }

    /* compiled from: max_num_emails_in_contact */
    class ThreadEventRemindersCursorIterator extends CursorIterator<Result> {
        private final int f10568b;
        private final int f10569c;
        private final int f10570d;
        private final int f10571e;
        private final int f10572f;

        protected final Object m11152a(Cursor cursor) {
            boolean z = true;
            ThreadKey a = ThreadKey.a(this.a.getString(this.f10568b));
            Builder builder = new Builder();
            builder.a = cursor.getString(this.f10569c);
            builder = builder;
            builder.b = cursor.getLong(this.f10570d);
            builder = builder;
            builder.c = cursor.getString(this.f10571e);
            builder = builder;
            if (cursor.getInt(this.f10572f) != 1) {
                z = false;
            }
            builder.f = z;
            return new Result(a, builder.g());
        }

        public ThreadEventRemindersCursorIterator(Cursor cursor) {
            super(cursor);
            this.f10568b = cursor.getColumnIndex(Columns.f10666a.d);
            this.f10569c = cursor.getColumnIndexOrThrow(Columns.f10667b.d);
            this.f10570d = cursor.getColumnIndexOrThrow(Columns.f10668c.d);
            this.f10571e = cursor.getColumnIndexOrThrow(Columns.f10669d.d);
            this.f10572f = cursor.getColumnIndexOrThrow(Columns.f10670e.d);
        }
    }

    public ThreadEventRemindersIterator(Cursor cursor) {
        this.f10573a = cursor;
    }

    public Iterator<Result> iterator() {
        return new ThreadEventRemindersCursorIterator(this.f10573a);
    }

    public final void m11153a() {
        this.f10573a.close();
    }
}
