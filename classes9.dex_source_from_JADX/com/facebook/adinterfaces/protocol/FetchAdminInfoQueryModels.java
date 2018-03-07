package com.facebook.adinterfaces.protocol;

import com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.AdminInfoModel;
import com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsParsers.AdminInfoParser;
import com.facebook.adinterfaces.protocol.FetchAdminInfoQueryParsers.FetchAdminInfoQueryParser;
import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbSerializerProvider;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.FragmentModelWithBridge;
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

/* compiled from: WY */
public class FetchAdminInfoQueryModels {

    @FragmentModelWithBridge
    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 1098771370)
    @JsonSerialize(using = Serializer.class)
    /* compiled from: WY */
    public final class FetchAdminInfoQueryModel extends BaseModel implements GraphQLVisitableConsistentModel {
        @Nullable
        private AdminInfoModel f22339d;

        /* compiled from: WY */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(FetchAdminInfoQueryModel.class, new Deserializer());
            }

            public Object m24100a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = FetchAdminInfoQueryParser.m24107a(jsonParser);
                Object fetchAdminInfoQueryModel = new FetchAdminInfoQueryModel();
                ((BaseModel) fetchAdminInfoQueryModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (fetchAdminInfoQueryModel instanceof Postprocessable) {
                    return ((Postprocessable) fetchAdminInfoQueryModel).a();
                }
                return fetchAdminInfoQueryModel;
            }
        }

        /* compiled from: WY */
        public class Serializer extends JsonSerializer<FetchAdminInfoQueryModel> {
            public final void m24101a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                FetchAdminInfoQueryModel fetchAdminInfoQueryModel = (FetchAdminInfoQueryModel) obj;
                if (fetchAdminInfoQueryModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(fetchAdminInfoQueryModel.m24102a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    fetchAdminInfoQueryModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = fetchAdminInfoQueryModel.w_();
                int u_ = fetchAdminInfoQueryModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("admin_info");
                    AdminInfoParser.m23780a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(FetchAdminInfoQueryModel.class, new Serializer());
            }
        }

        public FetchAdminInfoQueryModel() {
            super(1);
        }

        public final void m24105a(String str, ConsistencyTuple consistencyTuple) {
            consistencyTuple.a();
        }

        public final void m24106a(String str, Object obj, boolean z) {
        }

        @Nullable
        public final AdminInfoModel m24103a() {
            this.f22339d = (AdminInfoModel) super.a(this.f22339d, 0, AdminInfoModel.class);
            return this.f22339d;
        }

        public final int jK_() {
            return 2479791;
        }

        public final GraphQLVisitableModel m24104a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m24103a() != null) {
                AdminInfoModel adminInfoModel = (AdminInfoModel) graphQLModelMutatingVisitor.b(m24103a());
                if (m24103a() != adminInfoModel) {
                    graphQLVisitableModel = (FetchAdminInfoQueryModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f22339d = adminInfoModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m24102a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m24103a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }
}
