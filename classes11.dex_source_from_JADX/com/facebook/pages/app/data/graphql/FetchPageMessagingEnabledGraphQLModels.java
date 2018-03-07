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
import com.facebook.graphql.modelutil.ModelHelper;
import com.facebook.graphql.visitor.ConsistencyTuple;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLVisitableConsistentModel;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.facebook.pages.app.data.graphql.FetchPageMessagingEnabledGraphQLParsers.FetchPageMessagingEnabledQueryParser;
import com.facebook.pages.app.data.graphql.FetchPageMessagingEnabledGraphQLParsers.FetchPageMessagingEnabledQueryParser.AdminInfoParser;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.nio.ByteBuffer;
import javax.annotation.Nullable;

/* compiled from: tapped_see_more */
public class FetchPageMessagingEnabledGraphQLModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 449863884)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: tapped_see_more */
    public final class FetchPageMessagingEnabledQueryModel extends BaseModel implements GraphQLVisitableConsistentModel {
        @Nullable
        private AdminInfoModel f1122d;

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 1245262807)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: tapped_see_more */
        public final class AdminInfoModel extends BaseModel implements GraphQLVisitableModel {
            private boolean f1121d;

            /* compiled from: tapped_see_more */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(AdminInfoModel.class, new Deserializer());
                }

                public Object m1472a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(AdminInfoParser.m1484a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object adminInfoModel = new AdminInfoModel();
                    ((BaseModel) adminInfoModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (adminInfoModel instanceof Postprocessable) {
                        return ((Postprocessable) adminInfoModel).a();
                    }
                    return adminInfoModel;
                }
            }

            /* compiled from: tapped_see_more */
            public class Serializer extends JsonSerializer<AdminInfoModel> {
                public final void m1473a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    AdminInfoModel adminInfoModel = (AdminInfoModel) obj;
                    if (adminInfoModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(adminInfoModel.m1474a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        adminInfoModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    AdminInfoParser.m1485a(adminInfoModel.w_(), adminInfoModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(AdminInfoModel.class, new Serializer());
                }
            }

            public AdminInfoModel() {
                super(1);
            }

            public final int jK_() {
                return 888797870;
            }

            public final GraphQLVisitableModel m1475a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m1474a(FlatBufferBuilder flatBufferBuilder) {
                h();
                flatBufferBuilder.c(1);
                flatBufferBuilder.a(0, this.f1121d);
                i();
                return flatBufferBuilder.d();
            }

            public final void m1476a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                super.a(mutableFlatBuffer, i, obj);
                this.f1121d = mutableFlatBuffer.a(i, 0);
            }
        }

        /* compiled from: tapped_see_more */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(FetchPageMessagingEnabledQueryModel.class, new Deserializer());
            }

            public Object m1477a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = FetchPageMessagingEnabledQueryParser.m1486a(jsonParser);
                Object fetchPageMessagingEnabledQueryModel = new FetchPageMessagingEnabledQueryModel();
                ((BaseModel) fetchPageMessagingEnabledQueryModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (fetchPageMessagingEnabledQueryModel instanceof Postprocessable) {
                    return ((Postprocessable) fetchPageMessagingEnabledQueryModel).a();
                }
                return fetchPageMessagingEnabledQueryModel;
            }
        }

        /* compiled from: tapped_see_more */
        public class Serializer extends JsonSerializer<FetchPageMessagingEnabledQueryModel> {
            public final void m1478a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                FetchPageMessagingEnabledQueryModel fetchPageMessagingEnabledQueryModel = (FetchPageMessagingEnabledQueryModel) obj;
                if (fetchPageMessagingEnabledQueryModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(fetchPageMessagingEnabledQueryModel.m1480a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    fetchPageMessagingEnabledQueryModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = fetchPageMessagingEnabledQueryModel.w_();
                int u_ = fetchPageMessagingEnabledQueryModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("admin_info");
                    AdminInfoParser.m1485a(mutableFlatBuffer, g, jsonGenerator);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(FetchPageMessagingEnabledQueryModel.class, new Serializer());
            }
        }

        public FetchPageMessagingEnabledQueryModel() {
            super(1);
        }

        public final void m1482a(String str, ConsistencyTuple consistencyTuple) {
            consistencyTuple.a();
        }

        public final void m1483a(String str, Object obj, boolean z) {
        }

        @Nullable
        private AdminInfoModel m1479a() {
            this.f1122d = (AdminInfoModel) super.a(this.f1122d, 0, AdminInfoModel.class);
            return this.f1122d;
        }

        public final int jK_() {
            return 2479791;
        }

        public final GraphQLVisitableModel m1481a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m1479a() != null) {
                AdminInfoModel adminInfoModel = (AdminInfoModel) graphQLModelMutatingVisitor.b(m1479a());
                if (m1479a() != adminInfoModel) {
                    graphQLVisitableModel = (FetchPageMessagingEnabledQueryModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f1122d = adminInfoModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m1480a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m1479a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }
}
