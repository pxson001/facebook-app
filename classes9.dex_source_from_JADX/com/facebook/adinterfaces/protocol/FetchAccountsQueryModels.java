package com.facebook.adinterfaces.protocol;

import com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.AdAccountsModel;
import com.facebook.adinterfaces.protocol.FetchAccountsQueryParsers.FetchAccountsQueryParser;
import com.facebook.adinterfaces.protocol.FetchAccountsQueryParsers.FetchAccountsQueryParser.AdminInfoParser;
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
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.nio.ByteBuffer;
import javax.annotation.Nullable;

/* compiled from: We should not see this unknown transfer status %s */
public class FetchAccountsQueryModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 2013750853)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: We should not see this unknown transfer status %s */
    public final class FetchAccountsQueryModel extends BaseModel implements GraphQLVisitableConsistentModel {
        @Nullable
        private AdminInfoModel f22334d;

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 1214045378)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: We should not see this unknown transfer status %s */
        public final class AdminInfoModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private AdAccountsModel f22333d;

            /* compiled from: We should not see this unknown transfer status %s */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(AdminInfoModel.class, new Deserializer());
                }

                public Object m24081a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(AdminInfoParser.m24093a(jsonParser, flatBufferBuilder));
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

            /* compiled from: We should not see this unknown transfer status %s */
            public class Serializer extends JsonSerializer<AdminInfoModel> {
                public final void m24082a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    AdminInfoModel adminInfoModel = (AdminInfoModel) obj;
                    if (adminInfoModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(adminInfoModel.m24083a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        adminInfoModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    AdminInfoParser.m24094a(adminInfoModel.w_(), adminInfoModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(AdminInfoModel.class, new Serializer());
                }
            }

            public AdminInfoModel() {
                super(1);
            }

            @Nullable
            public final AdAccountsModel m24084a() {
                this.f22333d = (AdAccountsModel) super.a(this.f22333d, 0, AdAccountsModel.class);
                return this.f22333d;
            }

            public final int jK_() {
                return 888797870;
            }

            public final GraphQLVisitableModel m24085a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m24084a() != null) {
                    AdAccountsModel adAccountsModel = (AdAccountsModel) graphQLModelMutatingVisitor.b(m24084a());
                    if (m24084a() != adAccountsModel) {
                        graphQLVisitableModel = (AdminInfoModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f22333d = adAccountsModel;
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m24083a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m24084a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, a);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: We should not see this unknown transfer status %s */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(FetchAccountsQueryModel.class, new Deserializer());
            }

            public Object m24086a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = FetchAccountsQueryParser.m24095a(jsonParser);
                Object fetchAccountsQueryModel = new FetchAccountsQueryModel();
                ((BaseModel) fetchAccountsQueryModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (fetchAccountsQueryModel instanceof Postprocessable) {
                    return ((Postprocessable) fetchAccountsQueryModel).a();
                }
                return fetchAccountsQueryModel;
            }
        }

        /* compiled from: We should not see this unknown transfer status %s */
        public class Serializer extends JsonSerializer<FetchAccountsQueryModel> {
            public final void m24087a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                FetchAccountsQueryModel fetchAccountsQueryModel = (FetchAccountsQueryModel) obj;
                if (fetchAccountsQueryModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(fetchAccountsQueryModel.m24088a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    fetchAccountsQueryModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = fetchAccountsQueryModel.w_();
                int u_ = fetchAccountsQueryModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("admin_info");
                    AdminInfoParser.m24094a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(FetchAccountsQueryModel.class, new Serializer());
            }
        }

        public FetchAccountsQueryModel() {
            super(1);
        }

        public final void m24091a(String str, ConsistencyTuple consistencyTuple) {
            consistencyTuple.a();
        }

        public final void m24092a(String str, Object obj, boolean z) {
        }

        @Nullable
        public final AdminInfoModel m24089a() {
            this.f22334d = (AdminInfoModel) super.a(this.f22334d, 0, AdminInfoModel.class);
            return this.f22334d;
        }

        public final int jK_() {
            return 2479791;
        }

        public final GraphQLVisitableModel m24090a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m24089a() != null) {
                AdminInfoModel adminInfoModel = (AdminInfoModel) graphQLModelMutatingVisitor.b(m24089a());
                if (m24089a() != adminInfoModel) {
                    graphQLVisitableModel = (FetchAccountsQueryModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f22334d = adminInfoModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m24088a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m24089a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }
}
