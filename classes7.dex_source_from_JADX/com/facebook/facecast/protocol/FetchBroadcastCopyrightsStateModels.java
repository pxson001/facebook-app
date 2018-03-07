package com.facebook.facecast.protocol;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbSerializerProvider;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.facecast.protocol.FetchBroadcastCopyrightsStateParsers.FetchBroadcastCopyrightsStateQueryParser;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.FragmentModelWithoutBridge;
import com.facebook.flatbuffers.ModelWithFlatBufferFormatHash;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.SerializerHelpers;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.google.common.collect.ImmutableList;
import java.nio.ByteBuffer;
import java.util.List;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/* compiled from: backstage_friend_posted */
public class FetchBroadcastCopyrightsStateModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 36454248)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: backstage_friend_posted */
    public final class FetchBroadcastCopyrightsStateQueryModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private String f18779d;
        @Nullable
        private List<String> f18780e;

        /* compiled from: backstage_friend_posted */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(FetchBroadcastCopyrightsStateQueryModel.class, new Deserializer());
            }

            public Object m22317a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = FetchBroadcastCopyrightsStateQueryParser.m22323a(jsonParser);
                Object fetchBroadcastCopyrightsStateQueryModel = new FetchBroadcastCopyrightsStateQueryModel();
                ((BaseModel) fetchBroadcastCopyrightsStateQueryModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (fetchBroadcastCopyrightsStateQueryModel instanceof Postprocessable) {
                    return ((Postprocessable) fetchBroadcastCopyrightsStateQueryModel).a();
                }
                return fetchBroadcastCopyrightsStateQueryModel;
            }
        }

        /* compiled from: backstage_friend_posted */
        public class Serializer extends JsonSerializer<FetchBroadcastCopyrightsStateQueryModel> {
            public final void m22318a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                FetchBroadcastCopyrightsStateQueryModel fetchBroadcastCopyrightsStateQueryModel = (FetchBroadcastCopyrightsStateQueryModel) obj;
                if (fetchBroadcastCopyrightsStateQueryModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(fetchBroadcastCopyrightsStateQueryModel.m22319a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    fetchBroadcastCopyrightsStateQueryModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = fetchBroadcastCopyrightsStateQueryModel.w_();
                int u_ = fetchBroadcastCopyrightsStateQueryModel.u_();
                jsonGenerator.f();
                if (mutableFlatBuffer.g(u_, 0) != 0) {
                    jsonGenerator.a("copyrights_violation_dialog_state");
                    jsonGenerator.b(mutableFlatBuffer.c(u_, 0));
                }
                if (mutableFlatBuffer.g(u_, 1) != 0) {
                    jsonGenerator.a("copyrights_violation_ui_notification_texts");
                    SerializerHelpers.a(mutableFlatBuffer.f(u_, 1), jsonGenerator);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(FetchBroadcastCopyrightsStateQueryModel.class, new Serializer());
            }
        }

        public FetchBroadcastCopyrightsStateQueryModel() {
            super(2);
        }

        @Nullable
        public final String m22321a() {
            this.f18779d = super.a(this.f18779d, 0);
            return this.f18779d;
        }

        @Nonnull
        public final ImmutableList<String> m22322j() {
            this.f18780e = super.a(this.f18780e, 1);
            return (ImmutableList) this.f18780e;
        }

        public final int jK_() {
            return 82650203;
        }

        public final GraphQLVisitableModel m22320a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            h();
            i();
            return this;
        }

        public final int m22319a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int b = flatBufferBuilder.b(m22321a());
            int c = flatBufferBuilder.c(m22322j());
            flatBufferBuilder.c(2);
            flatBufferBuilder.b(0, b);
            flatBufferBuilder.b(1, c);
            i();
            return flatBufferBuilder.d();
        }
    }
}
