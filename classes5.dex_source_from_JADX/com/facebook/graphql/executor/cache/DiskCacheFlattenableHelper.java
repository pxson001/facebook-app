package com.facebook.graphql.executor.cache;

import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.FlatBuffer$FlattenableWithFlattenerListAccessor;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.Flattenable;
import com.facebook.flatbuffers.Flattener;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.flatbuffers.MutableFlatBuffer.FlatBufferCorruptionHandler;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.RegularImmutableList;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.annotation.Nullable;

/* compiled from: legacy_account_id */
public class DiskCacheFlattenableHelper {

    /* compiled from: legacy_account_id */
    class NestedListFlattener implements Flattener<List<String>> {
        static final NestedListFlattener f3243a = new NestedListFlattener();

        private NestedListFlattener() {
        }

        public final int mo608a(Object obj, FlatBufferBuilder flatBufferBuilder) {
            int c = flatBufferBuilder.c((List) obj);
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, c);
            return flatBufferBuilder.d();
        }

        public final Object mo609a(ByteBuffer byteBuffer, int i) {
            return (ArrayList) FlatBuffer.b(byteBuffer, i, 0, ArrayList.class);
        }
    }

    private DiskCacheFlattenableHelper() {
    }

    public static <T extends Flattenable> byte[] m6306a(List<T> list) {
        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(2048);
        int a = flatBufferBuilder.a(list, false);
        flatBufferBuilder.c(1);
        flatBufferBuilder.b(0, a);
        a = flatBufferBuilder.d();
        if (a < 0) {
            return null;
        }
        flatBufferBuilder.d(a);
        return flatBufferBuilder.e();
    }

    public static <T extends Flattenable> ImmutableList<T> m6304a(ByteBuffer byteBuffer, Class<T> cls, @Nullable ByteBuffer byteBuffer2, @Nullable ByteBuffer byteBuffer3, boolean z, @Nullable FlatBufferCorruptionHandler flatBufferCorruptionHandler) {
        Iterator e = new MutableFlatBuffer(byteBuffer, byteBuffer2, byteBuffer3, z, flatBufferCorruptionHandler).e(FlatBuffer.a(byteBuffer), 0, cls);
        if (e == null) {
            return RegularImmutableList.a;
        }
        return ImmutableList.copyOf(e);
    }

    public static <T extends Flattenable> Map<String, T> m6307b(ByteBuffer byteBuffer, Class<T> cls, @Nullable ByteBuffer byteBuffer2, @Nullable ByteBuffer byteBuffer3, boolean z, @Nullable FlatBufferCorruptionHandler flatBufferCorruptionHandler) {
        int a = FlatBuffer.a(byteBuffer);
        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(byteBuffer, byteBuffer2, byteBuffer3, z, flatBufferCorruptionHandler);
        int g = mutableFlatBuffer.g(a, 0);
        if (g == 0) {
            return new HashMap();
        }
        Iterator f = mutableFlatBuffer.f(g, 0);
        Iterator e = mutableFlatBuffer.e(g, 1, cls);
        if (f == null || e == null) {
            return new HashMap();
        }
        Map<String, T> hashMap = new HashMap();
        while (f.hasNext() && e.hasNext()) {
            hashMap.put(f.next(), e.next());
        }
        return hashMap;
    }

    public static byte[] m6308b(Map<String, List<String>> map) {
        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(2048);
        int a = flatBufferBuilder.a(map, NestedListFlattener.f3243a, false);
        flatBufferBuilder.c(1);
        flatBufferBuilder.b(0, a);
        a = flatBufferBuilder.d();
        if (a < 0) {
            return null;
        }
        flatBufferBuilder.d(a);
        return flatBufferBuilder.e();
    }

    public static Map<String, List<String>> m6305a(byte[] bArr) {
        Map<String, List<String>> map;
        ByteBuffer wrap = ByteBuffer.wrap(bArr);
        int a = FlatBuffer.a(wrap);
        Class cls = HashMap.class;
        NestedListFlattener nestedListFlattener = NestedListFlattener.f3243a;
        int o = FlatBuffer.o(wrap, a, 0);
        if (o == 0) {
            map = null;
        } else {
            map = FlatBuffer.a(cls, FlatBuffer.m(wrap, o, 0), FlatBuffer.b(wrap, o, 1, FlatBuffer$FlattenableWithFlattenerListAccessor.f3158a, nestedListFlattener));
        }
        return map;
    }
}
