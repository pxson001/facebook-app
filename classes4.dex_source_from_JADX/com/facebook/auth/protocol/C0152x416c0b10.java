package com.facebook.auth.protocol;

import com.facebook.auth.protocol.FetchFacebookEmployeeStatusGraphQLModels$FetchFacebookEmployeeStatusQueryModel.Serializer;
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
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonDeserialize(using = Deserializer.class)
@ModelWithFlatBufferFormatHash(a = -72295668)
@JsonSerialize(using = Serializer.class)
@FragmentModelWithoutBridge
/* compiled from: rm_pkg */
public final class C0152x416c0b10 extends BaseModel implements GraphQLVisitableModel {
    private boolean f3330d;

    /* compiled from: rm_pkg */
    public class Deserializer extends FbJsonDeserializer {
        static {
            GlobalAutoGenDeserializerCache.a(C0152x416c0b10.class, new Deserializer());
        }

        public Object m3654a(JsonParser jsonParser, DeserializationContext deserializationContext) {
            MutableFlatBuffer a = C0157x559999c0.m3655a(jsonParser);
            Object c0152x416c0b10 = new C0152x416c0b10();
            ((BaseModel) c0152x416c0b10).a(a, FlatBuffer.a(a.a), jsonParser);
            if (c0152x416c0b10 instanceof Postprocessable) {
                return ((Postprocessable) c0152x416c0b10).a();
            }
            return c0152x416c0b10;
        }
    }

    public C0152x416c0b10() {
        super(1);
    }

    public final boolean m3559a() {
        a(0, 0);
        return this.f3330d;
    }

    public final int jK_() {
        return -1732764110;
    }

    public final GraphQLVisitableModel m3557a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        h();
        i();
        return this;
    }

    public final int m3556a(FlatBufferBuilder flatBufferBuilder) {
        h();
        flatBufferBuilder.c(1);
        flatBufferBuilder.a(0, this.f3330d);
        i();
        return flatBufferBuilder.d();
    }

    public final void m3558a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
        super.a(mutableFlatBuffer, i, obj);
        this.f3330d = mutableFlatBuffer.a(i, 0);
    }
}
