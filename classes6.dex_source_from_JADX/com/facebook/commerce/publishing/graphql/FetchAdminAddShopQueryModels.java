package com.facebook.commerce.publishing.graphql;

import com.facebook.commerce.publishing.graphql.FetchAdminAddShopQueryParsers.FetchAdminAddShopQueryParser;
import com.facebook.commerce.publishing.graphql.FetchAdminAddShopQueryParsers.FetchAdminAddShopQueryParser.AdminInfoParser;
import com.facebook.commerce.publishing.graphql.FetchAdminAddShopQueryParsers.FetchAdminAddShopQueryParser.CommerceStoreParser;
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
import com.facebook.graphql.visitor.GraphQLPersistableNode;
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

/* compiled from: playing_movie */
public class FetchAdminAddShopQueryModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 102966245)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: playing_movie */
    public final class FetchAdminAddShopQueryModel extends BaseModel implements GraphQLVisitableConsistentModel {
        @Nullable
        private AdminInfoModel f7637d;
        @Nullable
        private CommerceStoreModel f7638e;

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 1245262807)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: playing_movie */
        public final class AdminInfoModel extends BaseModel implements GraphQLVisitableModel {
            private boolean f7635d;

            /* compiled from: playing_movie */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(AdminInfoModel.class, new Deserializer());
                }

                public Object m10847a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(AdminInfoParser.m10867a(jsonParser, flatBufferBuilder));
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

            /* compiled from: playing_movie */
            public class Serializer extends JsonSerializer<AdminInfoModel> {
                public final void m10848a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    AdminInfoModel adminInfoModel = (AdminInfoModel) obj;
                    if (adminInfoModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(adminInfoModel.m10849a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        adminInfoModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    AdminInfoParser.m10868a(adminInfoModel.w_(), adminInfoModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(AdminInfoModel.class, new Serializer());
                }
            }

            public AdminInfoModel() {
                super(1);
            }

            public final boolean m10852a() {
                a(0, 0);
                return this.f7635d;
            }

            public final int jK_() {
                return 888797870;
            }

            public final GraphQLVisitableModel m10850a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m10849a(FlatBufferBuilder flatBufferBuilder) {
                h();
                flatBufferBuilder.c(1);
                flatBufferBuilder.a(0, this.f7635d);
                i();
                return flatBufferBuilder.d();
            }

            public final void m10851a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                super.a(mutableFlatBuffer, i, obj);
                this.f7635d = mutableFlatBuffer.a(i, 0);
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 1801334754)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: playing_movie */
        public final class CommerceStoreModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableModel {
            @Nullable
            private String f7636d;

            /* compiled from: playing_movie */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(CommerceStoreModel.class, new Deserializer());
                }

                public Object m10853a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(CommerceStoreParser.m10869a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object commerceStoreModel = new CommerceStoreModel();
                    ((BaseModel) commerceStoreModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (commerceStoreModel instanceof Postprocessable) {
                        return ((Postprocessable) commerceStoreModel).a();
                    }
                    return commerceStoreModel;
                }
            }

            /* compiled from: playing_movie */
            public class Serializer extends JsonSerializer<CommerceStoreModel> {
                public final void m10854a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    CommerceStoreModel commerceStoreModel = (CommerceStoreModel) obj;
                    if (commerceStoreModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(commerceStoreModel.m10856a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        commerceStoreModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    CommerceStoreParser.m10870a(commerceStoreModel.w_(), commerceStoreModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(CommerceStoreModel.class, new Serializer());
                }
            }

            public CommerceStoreModel() {
                super(1);
            }

            @Nullable
            private String m10855j() {
                this.f7636d = super.a(this.f7636d, 0);
                return this.f7636d;
            }

            @Nullable
            public final String m10858a() {
                return m10855j();
            }

            public final int jK_() {
                return 308731558;
            }

            public final GraphQLVisitableModel m10857a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m10856a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m10855j());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, b);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: playing_movie */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(FetchAdminAddShopQueryModel.class, new Deserializer());
            }

            public Object m10859a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = FetchAdminAddShopQueryParser.m10871a(jsonParser);
                Object fetchAdminAddShopQueryModel = new FetchAdminAddShopQueryModel();
                ((BaseModel) fetchAdminAddShopQueryModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (fetchAdminAddShopQueryModel instanceof Postprocessable) {
                    return ((Postprocessable) fetchAdminAddShopQueryModel).a();
                }
                return fetchAdminAddShopQueryModel;
            }
        }

        /* compiled from: playing_movie */
        public class Serializer extends JsonSerializer<FetchAdminAddShopQueryModel> {
            public final void m10860a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                FetchAdminAddShopQueryModel fetchAdminAddShopQueryModel = (FetchAdminAddShopQueryModel) obj;
                if (fetchAdminAddShopQueryModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(fetchAdminAddShopQueryModel.m10861a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    fetchAdminAddShopQueryModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = fetchAdminAddShopQueryModel.w_();
                int u_ = fetchAdminAddShopQueryModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("admin_info");
                    AdminInfoParser.m10868a(mutableFlatBuffer, g, jsonGenerator);
                }
                g = mutableFlatBuffer.g(u_, 1);
                if (g != 0) {
                    jsonGenerator.a("commerce_store");
                    CommerceStoreParser.m10870a(mutableFlatBuffer, g, jsonGenerator);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(FetchAdminAddShopQueryModel.class, new Serializer());
            }
        }

        public FetchAdminAddShopQueryModel() {
            super(2);
        }

        public final void m10864a(String str, ConsistencyTuple consistencyTuple) {
            consistencyTuple.a();
        }

        public final void m10865a(String str, Object obj, boolean z) {
        }

        @Nullable
        public final AdminInfoModel m10862a() {
            this.f7637d = (AdminInfoModel) super.a(this.f7637d, 0, AdminInfoModel.class);
            return this.f7637d;
        }

        @Nullable
        public final CommerceStoreModel m10866j() {
            this.f7638e = (CommerceStoreModel) super.a(this.f7638e, 1, CommerceStoreModel.class);
            return this.f7638e;
        }

        public final int jK_() {
            return 2479791;
        }

        public final GraphQLVisitableModel m10863a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m10862a() != null) {
                AdminInfoModel adminInfoModel = (AdminInfoModel) graphQLModelMutatingVisitor.b(m10862a());
                if (m10862a() != adminInfoModel) {
                    graphQLVisitableModel = (FetchAdminAddShopQueryModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f7637d = adminInfoModel;
                }
            }
            if (m10866j() != null) {
                CommerceStoreModel commerceStoreModel = (CommerceStoreModel) graphQLModelMutatingVisitor.b(m10866j());
                if (m10866j() != commerceStoreModel) {
                    graphQLVisitableModel = (FetchAdminAddShopQueryModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f7638e = commerceStoreModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m10861a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m10862a());
            int a2 = ModelHelper.a(flatBufferBuilder, m10866j());
            flatBufferBuilder.c(2);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, a2);
            i();
            return flatBufferBuilder.d();
        }
    }
}
