package com.facebook.pages.app.data.graphql;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbSerializerProvider;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.FragmentModelWithoutBridge;
import com.facebook.flatbuffers.ModelWithFlatBufferFormatHash;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.visitor.ConsistencyTuple;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLVisitableConsistentModel;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.facebook.pages.app.data.graphql.FetchPageAwayToggleGraphQLParsers.FetchPageAwayToggleQueryParser;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.nio.ByteBuffer;

/* compiled from: target_sdk_version */
public class FetchPageAwayToggleGraphQLModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -847047292)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: target_sdk_version */
    public final class FetchPageAwayToggleQueryModel extends BaseModel implements GraphQLVisitableConsistentModel {
        private int f1110d;
        private boolean f1111e;

        /* compiled from: target_sdk_version */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(FetchPageAwayToggleQueryModel.class, new Deserializer());
            }

            public Object m1429a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = FetchPageAwayToggleQueryParser.m1436a(jsonParser);
                Object fetchPageAwayToggleQueryModel = new FetchPageAwayToggleQueryModel();
                ((BaseModel) fetchPageAwayToggleQueryModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (fetchPageAwayToggleQueryModel instanceof Postprocessable) {
                    return ((Postprocessable) fetchPageAwayToggleQueryModel).a();
                }
                return fetchPageAwayToggleQueryModel;
            }
        }

        /* compiled from: target_sdk_version */
        public class Serializer extends JsonSerializer<FetchPageAwayToggleQueryModel> {
            public final void m1430a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                FetchPageAwayToggleQueryModel fetchPageAwayToggleQueryModel = (FetchPageAwayToggleQueryModel) obj;
                if (fetchPageAwayToggleQueryModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(fetchPageAwayToggleQueryModel.m1431a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    fetchPageAwayToggleQueryModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = fetchPageAwayToggleQueryModel.w_();
                int u_ = fetchPageAwayToggleQueryModel.u_();
                jsonGenerator.f();
                int a = mutableFlatBuffer.a(u_, 0, 0);
                if (a != 0) {
                    jsonGenerator.a("away_toggle_expiration");
                    jsonGenerator.b(a);
                }
                boolean a2 = mutableFlatBuffer.a(u_, 1);
                if (a2) {
                    jsonGenerator.a("is_away_toggle_on");
                    jsonGenerator.a(a2);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(FetchPageAwayToggleQueryModel.class, new Serializer());
            }
        }

        public FetchPageAwayToggleQueryModel() {
            super(2);
        }

        public final void m1434a(String str, ConsistencyTuple consistencyTuple) {
            consistencyTuple.a();
        }

        public final void m1435a(String str, Object obj, boolean z) {
        }

        public final int jK_() {
            return 2479791;
        }

        public final GraphQLVisitableModel m1432a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            h();
            i();
            return this;
        }

        public final int m1431a(FlatBufferBuilder flatBufferBuilder) {
            h();
            flatBufferBuilder.c(2);
            flatBufferBuilder.a(0, this.f1110d, 0);
            flatBufferBuilder.a(1, this.f1111e);
            i();
            return flatBufferBuilder.d();
        }

        public final void m1433a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
            super.a(mutableFlatBuffer, i, obj);
            this.f1110d = mutableFlatBuffer.a(i, 0, 0);
            this.f1111e = mutableFlatBuffer.a(i, 1);
        }
    }
}
