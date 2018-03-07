package com.facebook.graphql.model;

import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.Flattenable;
import com.facebook.flatbuffers.MutableFlatBuffer;

/* compiled from: rtc_sw_ns_uni_2 */
public class ConsistentFeedbackTopReactionsConnection implements Flattenable {
    public GraphQLTopReactionsConnection f3164a;

    public final int m3403a(FlatBufferBuilder flatBufferBuilder) {
        int a = flatBufferBuilder.a(this.f3164a);
        flatBufferBuilder.c(1);
        flatBufferBuilder.b(0, a);
        return flatBufferBuilder.d();
    }

    public final void m3404a(MutableFlatBuffer mutableFlatBuffer, int i) {
        this.f3164a = (GraphQLTopReactionsConnection) mutableFlatBuffer.d(i, 0, GraphQLTopReactionsConnection.class);
    }
}
