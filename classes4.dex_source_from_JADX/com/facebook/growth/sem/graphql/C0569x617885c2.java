package com.facebook.growth.sem.graphql;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.FragmentModelWithoutBridge;
import com.facebook.flatbuffers.ModelWithFlatBufferFormatHash;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.facebook.growth.sem.graphql.UserSemResTrackingMutationsModels$UserSemResTrackingMutationModel.Serializer;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import javax.annotation.Nullable;

@JsonDeserialize(using = Deserializer.class)
@ModelWithFlatBufferFormatHash(a = -2642782)
@JsonSerialize(using = Serializer.class)
@FragmentModelWithoutBridge
/* compiled from: feedback_context */
public final class C0569x617885c2 extends BaseModel implements GraphQLVisitableModel {
    @Nullable
    private String f11807d;

    /* compiled from: feedback_context */
    public class Deserializer extends FbJsonDeserializer {
        static {
            GlobalAutoGenDeserializerCache.a(C0569x617885c2.class, new Deserializer());
        }

        public Object m12467a(JsonParser jsonParser, DeserializationContext deserializationContext) {
            MutableFlatBuffer a = C0571xd27f1e42.m12468a(jsonParser);
            Object c0569x617885c2 = new C0569x617885c2();
            ((BaseModel) c0569x617885c2).a(a, FlatBuffer.a(a.a), jsonParser);
            if (c0569x617885c2 instanceof Postprocessable) {
                return ((Postprocessable) c0569x617885c2).a();
            }
            return c0569x617885c2;
        }
    }

    public C0569x617885c2() {
        super(1);
    }

    @Nullable
    private String m12409a() {
        this.f11807d = super.a(this.f11807d, 0);
        return this.f11807d;
    }

    public final int jK_() {
        return -1738444250;
    }

    public final GraphQLVisitableModel m12411a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        h();
        i();
        return this;
    }

    public final int m12410a(FlatBufferBuilder flatBufferBuilder) {
        h();
        int b = flatBufferBuilder.b(m12409a());
        flatBufferBuilder.c(1);
        flatBufferBuilder.b(0, b);
        i();
        return flatBufferBuilder.d();
    }
}
