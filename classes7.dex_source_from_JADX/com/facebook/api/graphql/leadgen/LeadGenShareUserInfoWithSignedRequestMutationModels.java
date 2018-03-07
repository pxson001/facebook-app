package com.facebook.api.graphql.leadgen;

import com.facebook.api.graphql.leadgen.LeadGenShareUserInfoWithSignedRequestMutationParsers.LeadGenUserInfoCoreMutationFieldsParser;
import com.facebook.api.graphql.leadgen.LeadGenShareUserInfoWithSignedRequestMutationParsers.LeadGenUserInfoCoreMutationFieldsParser.LeadGenUserStatusParser;
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

/* compiled from: video_editing_module */
public class LeadGenShareUserInfoWithSignedRequestMutationModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 390750356)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: video_editing_module */
    public final class LeadGenUserInfoCoreMutationFieldsModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private LeadGenUserStatusModel f578d;

        /* compiled from: video_editing_module */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(LeadGenUserInfoCoreMutationFieldsModel.class, new Deserializer());
            }

            public Object m614a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = LeadGenUserInfoCoreMutationFieldsParser.m634a(jsonParser);
                Object leadGenUserInfoCoreMutationFieldsModel = new LeadGenUserInfoCoreMutationFieldsModel();
                ((BaseModel) leadGenUserInfoCoreMutationFieldsModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (leadGenUserInfoCoreMutationFieldsModel instanceof Postprocessable) {
                    return ((Postprocessable) leadGenUserInfoCoreMutationFieldsModel).a();
                }
                return leadGenUserInfoCoreMutationFieldsModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 1063199559)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: video_editing_module */
        public final class LeadGenUserStatusModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
            private boolean f574d;
            @Nullable
            private String f575e;
            @Nullable
            private String f576f;
            @Nullable
            private String f577g;

            /* compiled from: video_editing_module */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(LeadGenUserStatusModel.class, new Deserializer());
                }

                public Object m615a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(LeadGenUserStatusParser.m632a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object leadGenUserStatusModel = new LeadGenUserStatusModel();
                    ((BaseModel) leadGenUserStatusModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (leadGenUserStatusModel instanceof Postprocessable) {
                        return ((Postprocessable) leadGenUserStatusModel).a();
                    }
                    return leadGenUserStatusModel;
                }
            }

            /* compiled from: video_editing_module */
            public class Serializer extends JsonSerializer<LeadGenUserStatusModel> {
                public final void m616a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    LeadGenUserStatusModel leadGenUserStatusModel = (LeadGenUserStatusModel) obj;
                    if (leadGenUserStatusModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(leadGenUserStatusModel.m622a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        leadGenUserStatusModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    LeadGenUserStatusParser.m633a(leadGenUserStatusModel.w_(), leadGenUserStatusModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(LeadGenUserStatusModel.class, new Serializer());
                }
            }

            public LeadGenUserStatusModel() {
                super(4);
            }

            public final void m626a(String str, ConsistencyTuple consistencyTuple) {
                if ("has_shared_info".equals(str)) {
                    consistencyTuple.a = Boolean.valueOf(m618j());
                    consistencyTuple.b = u_();
                    consistencyTuple.c = 0;
                    return;
                }
                consistencyTuple.a();
            }

            public final void m627a(String str, Object obj, boolean z) {
                if ("has_shared_info".equals(str)) {
                    m617a(((Boolean) obj).booleanValue());
                }
            }

            private boolean m618j() {
                a(0, 0);
                return this.f574d;
            }

            private void m617a(boolean z) {
                this.f574d = z;
                if (this.b != null && this.b.d) {
                    this.b.a(this.c, 0, z);
                }
            }

            @Nullable
            private String m619k() {
                this.f575e = super.a(this.f575e, 1);
                return this.f575e;
            }

            @Nullable
            private String m620l() {
                this.f576f = super.a(this.f576f, 2);
                return this.f576f;
            }

            @Nullable
            private String m621m() {
                this.f577g = super.a(this.f577g, 3);
                return this.f577g;
            }

            @Nullable
            public final String m624a() {
                return m619k();
            }

            public final int jK_() {
                return 925012209;
            }

            public final GraphQLVisitableModel m623a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m622a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m619k());
                int b2 = flatBufferBuilder.b(m620l());
                int b3 = flatBufferBuilder.b(m621m());
                flatBufferBuilder.c(4);
                flatBufferBuilder.a(0, this.f574d);
                flatBufferBuilder.b(1, b);
                flatBufferBuilder.b(2, b2);
                flatBufferBuilder.b(3, b3);
                i();
                return flatBufferBuilder.d();
            }

            public final void m625a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                super.a(mutableFlatBuffer, i, obj);
                this.f574d = mutableFlatBuffer.a(i, 0);
            }
        }

        /* compiled from: video_editing_module */
        public class Serializer extends JsonSerializer<LeadGenUserInfoCoreMutationFieldsModel> {
            public final void m628a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                LeadGenUserInfoCoreMutationFieldsModel leadGenUserInfoCoreMutationFieldsModel = (LeadGenUserInfoCoreMutationFieldsModel) obj;
                if (leadGenUserInfoCoreMutationFieldsModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(leadGenUserInfoCoreMutationFieldsModel.m630a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    leadGenUserInfoCoreMutationFieldsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = leadGenUserInfoCoreMutationFieldsModel.w_();
                int u_ = leadGenUserInfoCoreMutationFieldsModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("lead_gen_user_status");
                    LeadGenUserStatusParser.m633a(mutableFlatBuffer, g, jsonGenerator);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(LeadGenUserInfoCoreMutationFieldsModel.class, new Serializer());
            }
        }

        public LeadGenUserInfoCoreMutationFieldsModel() {
            super(1);
        }

        @Nullable
        private LeadGenUserStatusModel m629a() {
            this.f578d = (LeadGenUserStatusModel) super.a(this.f578d, 0, LeadGenUserStatusModel.class);
            return this.f578d;
        }

        public final int jK_() {
            return 1081988612;
        }

        public final GraphQLVisitableModel m631a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m629a() != null) {
                LeadGenUserStatusModel leadGenUserStatusModel = (LeadGenUserStatusModel) graphQLModelMutatingVisitor.b(m629a());
                if (m629a() != leadGenUserStatusModel) {
                    graphQLVisitableModel = (LeadGenUserInfoCoreMutationFieldsModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f578d = leadGenUserStatusModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m630a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m629a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }
}
