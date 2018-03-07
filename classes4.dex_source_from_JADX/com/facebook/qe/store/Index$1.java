package com.facebook.qe.store;

import com.facebook.flatbuffers.FlatBuffer;
import java.nio.ByteBuffer;
import java.util.Iterator;

/* compiled from: unsubscribeGenericTopics */
class Index$1 implements Iterable<String> {
    final /* synthetic */ ByteBuffer f9600a;
    final /* synthetic */ Index f9601b;

    Index$1(Index index, ByteBuffer byteBuffer) {
        this.f9601b = index;
        this.f9600a = byteBuffer;
    }

    public Iterator<String> iterator() {
        return Index.b(FlatBuffer.m(this.f9600a, this.f9601b.f, 1));
    }
}
