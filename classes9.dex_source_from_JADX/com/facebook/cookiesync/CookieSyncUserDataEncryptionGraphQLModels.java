package com.facebook.cookiesync;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbSerializerProvider;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.cookiesync.CookieSyncUserDataEncryptionGraphQLParsers.FetchEncrytedCookieSyncUserDataParser;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.FragmentModelWithoutBridge;
import com.facebook.flatbuffers.ModelWithFlatBufferFormatHash;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.enums.GraphQLObjectType;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.ModelHelper;
import com.facebook.graphql.modelutil.SerializerHelpers;
import com.facebook.graphql.visitor.ConsistencyTuple;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLVisitableConsistentModel;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.nio.ByteBuffer;
import javax.annotation.Nullable;

/* compiled from: plain_text */
public class CookieSyncUserDataEncryptionGraphQLModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -822064023)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: plain_text */
    public final class FetchEncrytedCookieSyncUserDataModel extends BaseModel implements GraphQLVisitableConsistentModel {
        @Nullable
        private GraphQLObjectType f6554d;
        @Nullable
        private String f6555e;

        /* compiled from: plain_text */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(FetchEncrytedCookieSyncUserDataModel.class, new Deserializer());
            }

            public Object m6876a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = FetchEncrytedCookieSyncUserDataParser.m6884a(jsonParser);
                Object fetchEncrytedCookieSyncUserDataModel = new FetchEncrytedCookieSyncUserDataModel();
                ((BaseModel) fetchEncrytedCookieSyncUserDataModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (fetchEncrytedCookieSyncUserDataModel instanceof Postprocessable) {
                    return ((Postprocessable) fetchEncrytedCookieSyncUserDataModel).a();
                }
                return fetchEncrytedCookieSyncUserDataModel;
            }
        }

        /* compiled from: plain_text */
        public class Serializer extends JsonSerializer<FetchEncrytedCookieSyncUserDataModel> {
            public final void m6877a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                FetchEncrytedCookieSyncUserDataModel fetchEncrytedCookieSyncUserDataModel = (FetchEncrytedCookieSyncUserDataModel) obj;
                if (fetchEncrytedCookieSyncUserDataModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(fetchEncrytedCookieSyncUserDataModel.m6879a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    fetchEncrytedCookieSyncUserDataModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = fetchEncrytedCookieSyncUserDataModel.w_();
                int u_ = fetchEncrytedCookieSyncUserDataModel.u_();
                jsonGenerator.f();
                if (mutableFlatBuffer.g(u_, 0) != 0) {
                    jsonGenerator.a("__type__");
                    SerializerHelpers.b(mutableFlatBuffer, u_, 0, jsonGenerator);
                }
                if (mutableFlatBuffer.g(u_, 1) != 0) {
                    jsonGenerator.a("encrypted_cookie_sync_data");
                    jsonGenerator.b(mutableFlatBuffer.c(u_, 1));
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(FetchEncrytedCookieSyncUserDataModel.class, new Serializer());
            }
        }

        public FetchEncrytedCookieSyncUserDataModel() {
            super(2);
        }

        public final void m6882a(String str, ConsistencyTuple consistencyTuple) {
            consistencyTuple.a();
        }

        public final void m6883a(String str, Object obj, boolean z) {
        }

        @Nullable
        private GraphQLObjectType m6878j() {
            if (this.b != null && this.f6554d == null) {
                this.f6554d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
            }
            return this.f6554d;
        }

        @Nullable
        public final String m6881a() {
            this.f6555e = super.a(this.f6555e, 1);
            return this.f6555e;
        }

        public final int jK_() {
            return 63093205;
        }

        public final GraphQLVisitableModel m6880a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            h();
            i();
            return this;
        }

        public final int m6879a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m6878j());
            int b = flatBufferBuilder.b(m6881a());
            flatBufferBuilder.c(2);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, b);
            i();
            return flatBufferBuilder.d();
        }
    }
}
