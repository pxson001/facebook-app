package com.facebook.messaging.blocking.graphql;

import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.FragmentModelWithoutBridge;
import com.facebook.flatbuffers.ModelWithFlatBufferFormatHash;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.visitor.ConsistencyTuple;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLVisitableConsistentModel;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import javax.annotation.Nullable;

/* compiled from: offsetted_amount */
public class GetBlockInfoForUserModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 1086467010)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: offsetted_amount */
    public final class GetBlockInfoForUserQueryModel extends BaseModel implements GraphQLVisitableConsistentModel {
        private boolean f8310d;
        private boolean f8311e;
        @Nullable
        private String f8312f;

        public GetBlockInfoForUserQueryModel() {
            super(3);
        }

        public final void m8572a(String str, ConsistencyTuple consistencyTuple) {
            consistencyTuple.a();
        }

        public final void m8573a(String str, Object obj, boolean z) {
        }

        @Nullable
        private String m8568a() {
            this.f8312f = super.a(this.f8312f, 2);
            return this.f8312f;
        }

        public final int jK_() {
            return 2645995;
        }

        public final GraphQLVisitableModel m8570a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            h();
            i();
            return this;
        }

        public final int m8569a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int b = flatBufferBuilder.b(m8568a());
            flatBufferBuilder.c(3);
            flatBufferBuilder.a(0, this.f8310d);
            flatBufferBuilder.a(1, this.f8311e);
            flatBufferBuilder.b(2, b);
            i();
            return flatBufferBuilder.d();
        }

        public final void m8571a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
            super.a(mutableFlatBuffer, i, obj);
            this.f8310d = mutableFlatBuffer.a(i, 0);
            this.f8311e = mutableFlatBuffer.a(i, 1);
        }
    }
}
