package com.facebook.api.graphql.leadgen;

import com.facebook.api.graphql.leadgen.LeadGenDeepLinkUserInfoCreateMutationParsers.LeadGenDeepLinkUserInfoCoreMutationFieldsParser;
import com.facebook.api.graphql.leadgen.LeadGenDeepLinkUserInfoCreateMutationParsers.LeadGenDeepLinkUserInfoCoreMutationFieldsParser.LeadGenDeepLinkUserStatusParser;
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

/* compiled from: video_editing_zoom_interactions */
public class LeadGenDeepLinkUserInfoCreateMutationModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -1523163635)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: video_editing_zoom_interactions */
    public final class LeadGenDeepLinkUserInfoCoreMutationFieldsModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private LeadGenDeepLinkUserStatusModel f573d;

        /* compiled from: video_editing_zoom_interactions */
        public final class Builder {
            @Nullable
            public LeadGenDeepLinkUserStatusModel f564a;
        }

        /* compiled from: video_editing_zoom_interactions */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(LeadGenDeepLinkUserInfoCoreMutationFieldsModel.class, new Deserializer());
            }

            public Object m593a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = LeadGenDeepLinkUserInfoCoreMutationFieldsParser.m613a(jsonParser);
                Object leadGenDeepLinkUserInfoCoreMutationFieldsModel = new LeadGenDeepLinkUserInfoCoreMutationFieldsModel();
                ((BaseModel) leadGenDeepLinkUserInfoCoreMutationFieldsModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (leadGenDeepLinkUserInfoCoreMutationFieldsModel instanceof Postprocessable) {
                    return ((Postprocessable) leadGenDeepLinkUserInfoCoreMutationFieldsModel).a();
                }
                return leadGenDeepLinkUserInfoCoreMutationFieldsModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 1063199559)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: video_editing_zoom_interactions */
        public final class LeadGenDeepLinkUserStatusModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
            private boolean f569d;
            @Nullable
            private String f570e;
            @Nullable
            private String f571f;
            @Nullable
            private String f572g;

            /* compiled from: video_editing_zoom_interactions */
            public final class Builder {
                public boolean f565a;
                @Nullable
                public String f566b;
                @Nullable
                public String f567c;
                @Nullable
                public String f568d;
            }

            /* compiled from: video_editing_zoom_interactions */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(LeadGenDeepLinkUserStatusModel.class, new Deserializer());
                }

                public Object m594a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(LeadGenDeepLinkUserStatusParser.m611a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object leadGenDeepLinkUserStatusModel = new LeadGenDeepLinkUserStatusModel();
                    ((BaseModel) leadGenDeepLinkUserStatusModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (leadGenDeepLinkUserStatusModel instanceof Postprocessable) {
                        return ((Postprocessable) leadGenDeepLinkUserStatusModel).a();
                    }
                    return leadGenDeepLinkUserStatusModel;
                }
            }

            /* compiled from: video_editing_zoom_interactions */
            public class Serializer extends JsonSerializer<LeadGenDeepLinkUserStatusModel> {
                public final void m595a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    LeadGenDeepLinkUserStatusModel leadGenDeepLinkUserStatusModel = (LeadGenDeepLinkUserStatusModel) obj;
                    if (leadGenDeepLinkUserStatusModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(leadGenDeepLinkUserStatusModel.m598a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        leadGenDeepLinkUserStatusModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    LeadGenDeepLinkUserStatusParser.m612a(leadGenDeepLinkUserStatusModel.w_(), leadGenDeepLinkUserStatusModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(LeadGenDeepLinkUserStatusModel.class, new Serializer());
                }
            }

            public LeadGenDeepLinkUserStatusModel() {
                super(4);
            }

            public LeadGenDeepLinkUserStatusModel(MutableFlatBuffer mutableFlatBuffer) {
                super(4);
                a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
            }

            public final void m602a(String str, ConsistencyTuple consistencyTuple) {
                if ("has_shared_info".equals(str)) {
                    consistencyTuple.a = Boolean.valueOf(m604b());
                    consistencyTuple.b = u_();
                    consistencyTuple.c = 0;
                    return;
                }
                consistencyTuple.a();
            }

            public final void m603a(String str, Object obj, boolean z) {
                if ("has_shared_info".equals(str)) {
                    m596a(((Boolean) obj).booleanValue());
                }
            }

            public final boolean m604b() {
                a(0, 0);
                return this.f569d;
            }

            private void m596a(boolean z) {
                this.f569d = z;
                if (this.b != null && this.b.d) {
                    this.b.a(this.c, 0, z);
                }
            }

            @Nullable
            private String m597j() {
                this.f570e = super.a(this.f570e, 1);
                return this.f570e;
            }

            @Nullable
            public final String m605c() {
                this.f571f = super.a(this.f571f, 2);
                return this.f571f;
            }

            @Nullable
            public final String m606d() {
                this.f572g = super.a(this.f572g, 3);
                return this.f572g;
            }

            @Nullable
            public final String m600a() {
                return m597j();
            }

            public final int jK_() {
                return 771298455;
            }

            public final GraphQLVisitableModel m599a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m598a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m597j());
                int b2 = flatBufferBuilder.b(m605c());
                int b3 = flatBufferBuilder.b(m606d());
                flatBufferBuilder.c(4);
                flatBufferBuilder.a(0, this.f569d);
                flatBufferBuilder.b(1, b);
                flatBufferBuilder.b(2, b2);
                flatBufferBuilder.b(3, b3);
                i();
                return flatBufferBuilder.d();
            }

            public final void m601a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                super.a(mutableFlatBuffer, i, obj);
                this.f569d = mutableFlatBuffer.a(i, 0);
            }
        }

        /* compiled from: video_editing_zoom_interactions */
        public class Serializer extends JsonSerializer<LeadGenDeepLinkUserInfoCoreMutationFieldsModel> {
            public final void m607a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                LeadGenDeepLinkUserInfoCoreMutationFieldsModel leadGenDeepLinkUserInfoCoreMutationFieldsModel = (LeadGenDeepLinkUserInfoCoreMutationFieldsModel) obj;
                if (leadGenDeepLinkUserInfoCoreMutationFieldsModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(leadGenDeepLinkUserInfoCoreMutationFieldsModel.m608a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    leadGenDeepLinkUserInfoCoreMutationFieldsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = leadGenDeepLinkUserInfoCoreMutationFieldsModel.w_();
                int u_ = leadGenDeepLinkUserInfoCoreMutationFieldsModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("lead_gen_deep_link_user_status");
                    LeadGenDeepLinkUserStatusParser.m612a(mutableFlatBuffer, g, jsonGenerator);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(LeadGenDeepLinkUserInfoCoreMutationFieldsModel.class, new Serializer());
            }
        }

        public LeadGenDeepLinkUserInfoCoreMutationFieldsModel() {
            super(1);
        }

        public LeadGenDeepLinkUserInfoCoreMutationFieldsModel(MutableFlatBuffer mutableFlatBuffer) {
            super(1);
            a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
        }

        @Nullable
        public final LeadGenDeepLinkUserStatusModel m609a() {
            this.f573d = (LeadGenDeepLinkUserStatusModel) super.a(this.f573d, 0, LeadGenDeepLinkUserStatusModel.class);
            return this.f573d;
        }

        public final int jK_() {
            return -1047825250;
        }

        public final GraphQLVisitableModel m610a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m609a() != null) {
                LeadGenDeepLinkUserStatusModel leadGenDeepLinkUserStatusModel = (LeadGenDeepLinkUserStatusModel) graphQLModelMutatingVisitor.b(m609a());
                if (m609a() != leadGenDeepLinkUserStatusModel) {
                    graphQLVisitableModel = (LeadGenDeepLinkUserInfoCoreMutationFieldsModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f573d = leadGenDeepLinkUserStatusModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m608a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m609a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }
}
