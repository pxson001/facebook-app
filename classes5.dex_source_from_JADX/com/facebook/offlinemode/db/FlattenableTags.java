package com.facebook.offlinemode.db;

import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.Flattenable;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import java.nio.ByteBuffer;
import java.util.ArrayList;

/* compiled from: dbl_remove_nonce */
public class FlattenableTags implements Flattenable {
    protected ImmutableList<String> f5205a;

    public FlattenableTags(ImmutableSet<String> immutableSet) {
        this.f5205a = immutableSet.asList();
    }

    public final ImmutableSet<String> m10062a() {
        return ImmutableSet.copyOf(this.f5205a);
    }

    public final int m10061a(FlatBufferBuilder flatBufferBuilder) {
        int b = flatBufferBuilder.b(this.f5205a, false);
        flatBufferBuilder.c(1);
        flatBufferBuilder.b(0, b);
        return flatBufferBuilder.d();
    }

    public final void m10064a(ByteBuffer byteBuffer, int i) {
        ArrayList arrayList = (ArrayList) FlatBuffer.b(byteBuffer, i, 0, ArrayList.class);
        this.f5205a = arrayList != null ? ImmutableList.copyOf(arrayList) : null;
    }

    public final void m10063a(MutableFlatBuffer mutableFlatBuffer, int i) {
        throw new UnsupportedOperationException("initFromMutableFlatBuffer is not supported");
    }
}
