package com.facebook.graphql.cursor;

import android.database.Cursor;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;

/* compiled from: mPromptId */
public class GraphConnectionAggregatedRowCursor extends ModelCursor {
    private final int f10962a;
    private final int f10963b;
    private final ModelCursor f10964c;

    public GraphConnectionAggregatedRowCursor(Cursor cursor, int i, int i2) {
        super(cursor);
        this.f10962a = i;
        this.f10963b = i2;
        this.f10964c = (ModelCursor) cursor;
    }

    private int m17605a(int i) {
        int i2 = 1;
        int i3 = i - this.f10962a;
        if (i3 <= 0 || this.f10963b == 1) {
            return i;
        }
        int i4 = (i3 + 1) % this.f10963b;
        i3 = ((i3 + 1) / this.f10963b) + this.f10962a;
        if (i4 == 0) {
            i2 = 0;
        }
        return (i2 + i3) - 1;
    }

    public int getCount() {
        return m17605a(this.f10964c.getCount() - 1) + 1;
    }

    public final Object m17606a() {
        if (this.f10963b == 1) {
            return d();
        }
        Builder builder = ImmutableList.builder();
        int i = this.f10963b;
        do {
            builder.c(this.f10964c.d());
            i--;
            if (i <= 0) {
                break;
            }
        } while (this.f10964c.moveToNext());
        return builder.b();
    }

    public int getPosition() {
        return m17605a(this.f10964c.getPosition());
    }

    public boolean moveToLast() {
        return moveToPosition(getCount() - 1);
    }

    public boolean moveToNext() {
        return moveToPosition(getPosition() + 1);
    }

    public boolean move(int i) {
        return moveToPosition(getPosition() + i);
    }

    public boolean moveToPosition(int i) {
        if (i <= this.f10962a || this.f10963b == 1) {
            return this.f10964c.moveToPosition(i);
        }
        return this.f10964c.moveToPosition(((i - this.f10962a) * this.f10963b) + this.f10962a);
    }

    public boolean moveToPrevious() {
        return moveToPosition(m17605a(this.f10964c.getPosition()) - 1);
    }

    public void close() {
        this.f10964c.close();
    }
}
