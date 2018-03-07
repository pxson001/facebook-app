package com.facebook.adinterfaces.protocol;

import com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.PCTAAvailableAudiencesConnectionModel;
import com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.PPAvailableAudiencesConnectionModel;
import com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.PWAvailableAudiencesConnectionModel;
import com.facebook.adinterfaces.protocol.FetchAvailableAudiencesQueryParsers.FetchAvailableAudiencesQueryParser;
import com.facebook.adinterfaces.protocol.FetchAvailableAudiencesQueryParsers.FetchAvailableAudiencesQueryParser.AdminInfoParser;
import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbSerializerProvider;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
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

/* compiled from: WITH_BORDER */
public class FetchAvailableAudiencesQueryModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 1678974334)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: WITH_BORDER */
    public final class FetchAvailableAudiencesQueryModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
        @Nullable
        private GraphQLObjectType f22346d;
        @Nullable
        private AdminInfoModel f22347e;
        @Nullable
        private String f22348f;

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 659874864)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: WITH_BORDER */
        public final class AdminInfoModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private PCTAAvailableAudiencesConnectionModel f22343d;
            @Nullable
            private PPAvailableAudiencesConnectionModel f22344e;
            @Nullable
            private PWAvailableAudiencesConnectionModel f22345f;

            /* compiled from: WITH_BORDER */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(AdminInfoModel.class, new Deserializer());
                }

                public Object m24111a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(AdminInfoParser.m24128a(jsonParser, flatBufferBuilder));
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

            /* compiled from: WITH_BORDER */
            public class Serializer extends JsonSerializer<AdminInfoModel> {
                public final void m24112a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    AdminInfoModel adminInfoModel = (AdminInfoModel) obj;
                    if (adminInfoModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(adminInfoModel.m24113a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        adminInfoModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    AdminInfoParser.m24129a(adminInfoModel.w_(), adminInfoModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(AdminInfoModel.class, new Serializer());
                }
            }

            public AdminInfoModel() {
                super(3);
            }

            @Nullable
            public final PCTAAvailableAudiencesConnectionModel m24114a() {
                this.f22343d = (PCTAAvailableAudiencesConnectionModel) super.a(this.f22343d, 0, PCTAAvailableAudiencesConnectionModel.class);
                return this.f22343d;
            }

            @Nullable
            public final PPAvailableAudiencesConnectionModel m24116j() {
                this.f22344e = (PPAvailableAudiencesConnectionModel) super.a(this.f22344e, 1, PPAvailableAudiencesConnectionModel.class);
                return this.f22344e;
            }

            @Nullable
            public final PWAvailableAudiencesConnectionModel m24117k() {
                this.f22345f = (PWAvailableAudiencesConnectionModel) super.a(this.f22345f, 2, PWAvailableAudiencesConnectionModel.class);
                return this.f22345f;
            }

            public final int jK_() {
                return 888797870;
            }

            public final GraphQLVisitableModel m24115a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m24114a() != null) {
                    PCTAAvailableAudiencesConnectionModel pCTAAvailableAudiencesConnectionModel = (PCTAAvailableAudiencesConnectionModel) graphQLModelMutatingVisitor.b(m24114a());
                    if (m24114a() != pCTAAvailableAudiencesConnectionModel) {
                        graphQLVisitableModel = (AdminInfoModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f22343d = pCTAAvailableAudiencesConnectionModel;
                    }
                }
                if (m24116j() != null) {
                    PPAvailableAudiencesConnectionModel pPAvailableAudiencesConnectionModel = (PPAvailableAudiencesConnectionModel) graphQLModelMutatingVisitor.b(m24116j());
                    if (m24116j() != pPAvailableAudiencesConnectionModel) {
                        graphQLVisitableModel = (AdminInfoModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f22344e = pPAvailableAudiencesConnectionModel;
                    }
                }
                if (m24117k() != null) {
                    PWAvailableAudiencesConnectionModel pWAvailableAudiencesConnectionModel = (PWAvailableAudiencesConnectionModel) graphQLModelMutatingVisitor.b(m24117k());
                    if (m24117k() != pWAvailableAudiencesConnectionModel) {
                        graphQLVisitableModel = (AdminInfoModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f22345f = pWAvailableAudiencesConnectionModel;
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m24113a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m24114a());
                int a2 = ModelHelper.a(flatBufferBuilder, m24116j());
                int a3 = ModelHelper.a(flatBufferBuilder, m24117k());
                flatBufferBuilder.c(3);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.b(1, a2);
                flatBufferBuilder.b(2, a3);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: WITH_BORDER */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(FetchAvailableAudiencesQueryModel.class, new Deserializer());
            }

            public Object m24118a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = FetchAvailableAudiencesQueryParser.m24130a(jsonParser);
                Object fetchAvailableAudiencesQueryModel = new FetchAvailableAudiencesQueryModel();
                ((BaseModel) fetchAvailableAudiencesQueryModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (fetchAvailableAudiencesQueryModel instanceof Postprocessable) {
                    return ((Postprocessable) fetchAvailableAudiencesQueryModel).a();
                }
                return fetchAvailableAudiencesQueryModel;
            }
        }

        /* compiled from: WITH_BORDER */
        public class Serializer extends JsonSerializer<FetchAvailableAudiencesQueryModel> {
            public final void m24119a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                FetchAvailableAudiencesQueryModel fetchAvailableAudiencesQueryModel = (FetchAvailableAudiencesQueryModel) obj;
                if (fetchAvailableAudiencesQueryModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(fetchAvailableAudiencesQueryModel.m24122a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    fetchAvailableAudiencesQueryModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = fetchAvailableAudiencesQueryModel.w_();
                int u_ = fetchAvailableAudiencesQueryModel.u_();
                jsonGenerator.f();
                if (mutableFlatBuffer.g(u_, 0) != 0) {
                    jsonGenerator.a("__type__");
                    SerializerHelpers.b(mutableFlatBuffer, u_, 0, jsonGenerator);
                }
                int g = mutableFlatBuffer.g(u_, 1);
                if (g != 0) {
                    jsonGenerator.a("admin_info");
                    AdminInfoParser.m24129a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                if (mutableFlatBuffer.g(u_, 2) != 0) {
                    jsonGenerator.a("id");
                    jsonGenerator.b(mutableFlatBuffer.c(u_, 2));
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(FetchAvailableAudiencesQueryModel.class, new Serializer());
            }
        }

        public FetchAvailableAudiencesQueryModel() {
            super(3);
        }

        public final void m24125a(String str, ConsistencyTuple consistencyTuple) {
            consistencyTuple.a();
        }

        public final void m24126a(String str, Object obj, boolean z) {
        }

        @Nullable
        private GraphQLObjectType m24120k() {
            if (this.b != null && this.f22346d == null) {
                this.f22346d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
            }
            return this.f22346d;
        }

        @Nullable
        public final AdminInfoModel m24127j() {
            this.f22347e = (AdminInfoModel) super.a(this.f22347e, 1, AdminInfoModel.class);
            return this.f22347e;
        }

        @Nullable
        private String m24121l() {
            this.f22348f = super.a(this.f22348f, 2);
            return this.f22348f;
        }

        @Nullable
        public final String m24124a() {
            return m24121l();
        }

        public final int jK_() {
            return 2433570;
        }

        public final GraphQLVisitableModel m24123a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m24127j() != null) {
                AdminInfoModel adminInfoModel = (AdminInfoModel) graphQLModelMutatingVisitor.b(m24127j());
                if (m24127j() != adminInfoModel) {
                    graphQLVisitableModel = (FetchAvailableAudiencesQueryModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f22347e = adminInfoModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m24122a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m24120k());
            int a2 = ModelHelper.a(flatBufferBuilder, m24127j());
            int b = flatBufferBuilder.b(m24121l());
            flatBufferBuilder.c(3);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, a2);
            flatBufferBuilder.b(2, b);
            i();
            return flatBufferBuilder.d();
        }
    }
}
