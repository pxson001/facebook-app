package com.facebook.graphql.cursor;

import android.database.Cursor;
import android.database.CursorWrapper;
import com.facebook.flatbuffers.Flattenable;
import com.facebook.quicklog.QuickPerformanceLogger;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.RegularImmutableSet;
import javax.annotation.Nullable;

/* compiled from: messenger_contacts_android */
public class ModelCursor extends CursorWrapper implements Cursor {
    private final Cursor f8023a;
    private final int f8024b;
    private final int f8025c;
    private final int f8026d;
    private final int f8027e;
    private final int f8028f;
    private final int f8029g;
    private final QuickPerformanceLogger f8030h;
    private final CursorModelCache f8031i;
    private final ModelReader f8032j;

    public ModelCursor(Cursor cursor) {
        this(cursor, null, null);
    }

    public ModelCursor(Cursor cursor, @Nullable QuickPerformanceLogger quickPerformanceLogger, @Nullable CursorModelCache cursorModelCache) {
        super(cursor);
        this.f8023a = (Cursor) Preconditions.checkNotNull(cursor);
        this.f8032j = new ModelReader(cursor);
        this.f8024b = this.f8023a.getColumnIndexOrThrow("_id");
        this.f8025c = cursor.getColumnIndexOrThrow("flags");
        this.f8026d = cursor.getColumnIndexOrThrow("version");
        this.f8027e = cursor.getColumnIndexOrThrow("tags");
        this.f8028f = cursor.getColumnIndexOrThrow("sort_key");
        this.f8029g = cursor.getColumnIndexOrThrow("is_optimistic");
        this.f8030h = quickPerformanceLogger;
        this.f8031i = cursorModelCache;
    }

    public final long m8326b() {
        return this.f8023a.getLong(this.f8024b);
    }

    public final long m8327c() {
        return this.f8023a.getLong(this.f8026d);
    }

    @Nullable
    public final <T extends Flattenable> T m8328d() {
        m8324a(8716289);
        try {
            T a;
            if (this.f8031i != null) {
                a = this.f8031i.m8184a(m8326b(), m8327c());
                if (a != null) {
                    return a;
                }
            }
            m8324a(8716290);
            try {
                a = this.f8032j.m8336c();
                if (this.f8031i != null) {
                    this.f8031i.m8186a(m8326b(), m8327c(), a);
                }
                m8325b(8716290);
                m8325b(8716289);
                return a;
            } catch (Throwable th) {
                m8325b(8716290);
            }
        } finally {
            m8325b(8716289);
        }
    }

    final void m8329e() {
        this.f8032j.m8337d();
    }

    public final int m8330f() {
        return this.f8023a.getInt(this.f8025c);
    }

    public final ImmutableSet<String> m8331g() {
        String string = this.f8023a.getString(this.f8027e);
        if (string != null) {
            return ImmutableSet.copyOf(string.split(","));
        }
        return RegularImmutableSet.a;
    }

    private void m8324a(int i) {
        if (this.f8030h != null) {
            this.f8030h.b(i);
        }
    }

    private void m8325b(int i) {
        if (this.f8030h != null) {
            this.f8030h.b(i, (short) 2);
        }
    }

    public void close() {
        super.close();
        this.f8032j.close();
    }
}
