package com.facebook.graphql.cursor.iterator;

import android.util.SparseArray;
import android.util.SparseIntArray;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.flatbuffers.MutableFlattenable;
import com.facebook.graphql.cursor.database.GraphCursorDatabase$BufferRowMapper;
import com.google.common.base.Preconditions;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Collection;
import javax.annotation.Nullable;

/* compiled from: mPrivateLock */
public class BufferRowArrayList implements GraphCursorDatabase$BufferRowMapper {
    private int[] f10980a;
    private Class[] f10981b;
    private SparseArray<String> f10982c;
    private SparseArray<Collection<String>> f10983d;
    private SparseIntArray f10984e;
    private int f10985f;

    public static <T extends MutableFlattenable> T m17620a(T t) {
        return t.w_() != null ? t : (MutableFlattenable) MutableFlatBuffer.a(ByteBuffer.wrap(FlatBufferBuilder.b(t)), t.getClass(), null, null, true, null);
    }

    public BufferRowArrayList() {
        this.f10985f = 0;
        this.f10980a = new int[32];
        this.f10981b = new Class[32];
    }

    public BufferRowArrayList(int i) {
        this.f10985f = 0;
        this.f10980a = new int[i];
        this.f10981b = new Class[i];
    }

    public final int m17631f(int i) {
        Preconditions.checkArgument(i < this.f10985f);
        return this.f10980a[i];
    }

    public final int mo955a() {
        return this.f10985f;
    }

    public final int mo956a(int i) {
        Preconditions.checkArgument(i < this.f10985f);
        return this.f10980a[i];
    }

    public final Class<? extends MutableFlattenable> mo957b(int i) {
        Preconditions.checkArgument(i < this.f10985f);
        return this.f10981b[i];
    }

    public final String mo958c(int i) {
        Preconditions.checkState(this.f10982c != null);
        return (String) Preconditions.checkNotNull(this.f10982c.get(i, null));
    }

    public final int mo960e(int i) {
        if (this.f10984e == null) {
            return 0;
        }
        return this.f10984e.get(i, 0);
    }

    @Nullable
    public final Collection<String> mo959d(int i) {
        if (this.f10983d == null) {
            return null;
        }
        return (Collection) this.f10983d.get(i, null);
    }

    public final boolean m17627b() {
        return this.f10985f == 0;
    }

    public final void m17624a(int i, Class<? extends MutableFlattenable> cls, String str, @Nullable Collection<String> collection, int i2) {
        if (this.f10982c == null) {
            this.f10982c = new SparseArray();
        }
        Preconditions.checkNotNull(str);
        Preconditions.checkArgument(str.length() == 32);
        this.f10982c.append(this.f10985f, str);
        m17625a(i, cls, collection, i2);
    }

    public final void m17625a(int i, Class<? extends MutableFlattenable> cls, @Nullable Collection<String> collection, int i2) {
        if (i2 != 0) {
            if (this.f10984e == null) {
                this.f10984e = new SparseIntArray();
            }
            this.f10984e.append(this.f10985f, i2);
        }
        if (!(collection == null || collection.isEmpty())) {
            if (this.f10983d == null) {
                this.f10983d = new SparseArray();
            }
            this.f10983d.append(this.f10985f, collection);
        }
        m17623a(i, cls);
    }

    public final void m17623a(int i, Class<? extends MutableFlattenable> cls) {
        Preconditions.checkArgument(i > 0);
        Preconditions.checkNotNull(cls);
        if (this.f10980a.length <= this.f10985f) {
            this.f10980a = Arrays.copyOf(this.f10980a, this.f10980a.length * 2);
            this.f10981b = (Class[]) Arrays.copyOf(this.f10981b, this.f10981b.length * 2);
        }
        this.f10980a[this.f10985f] = i;
        this.f10981b[this.f10985f] = cls;
        this.f10985f++;
    }
}
