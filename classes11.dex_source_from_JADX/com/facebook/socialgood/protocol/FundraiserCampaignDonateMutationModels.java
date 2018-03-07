package com.facebook.socialgood.protocol;

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
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.facebook.socialgood.protocol.FundraiserCampaignDonateMutationParsers.FundraiserCampaignDonateMutationFieldsParser;
import com.facebook.socialgood.protocol.FundraiserCampaignDonateMutationParsers.FundraiserCampaignDonateMutationFieldsParser.FundraiserCampaignParser;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.nio.ByteBuffer;
import javax.annotation.Nullable;

/* compiled from: Onavo_bookmark_click */
public class FundraiserCampaignDonateMutationModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -741898155)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: Onavo_bookmark_click */
    public final class FundraiserCampaignDonateMutationFieldsModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private FundraiserCampaignModel f12738d;

        /* compiled from: Onavo_bookmark_click */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(FundraiserCampaignDonateMutationFieldsModel.class, new Deserializer());
            }

            public Object m13274a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = FundraiserCampaignDonateMutationFieldsParser.m13287a(jsonParser);
                Object fundraiserCampaignDonateMutationFieldsModel = new FundraiserCampaignDonateMutationFieldsModel();
                ((BaseModel) fundraiserCampaignDonateMutationFieldsModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (fundraiserCampaignDonateMutationFieldsModel instanceof Postprocessable) {
                    return ((Postprocessable) fundraiserCampaignDonateMutationFieldsModel).a();
                }
                return fundraiserCampaignDonateMutationFieldsModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 2013917091)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: Onavo_bookmark_click */
        public final class FundraiserCampaignModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private String f12736d;
            @Nullable
            private String f12737e;

            /* compiled from: Onavo_bookmark_click */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(FundraiserCampaignModel.class, new Deserializer());
                }

                public Object m13275a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(FundraiserCampaignParser.m13285a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object fundraiserCampaignModel = new FundraiserCampaignModel();
                    ((BaseModel) fundraiserCampaignModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (fundraiserCampaignModel instanceof Postprocessable) {
                        return ((Postprocessable) fundraiserCampaignModel).a();
                    }
                    return fundraiserCampaignModel;
                }
            }

            /* compiled from: Onavo_bookmark_click */
            public class Serializer extends JsonSerializer<FundraiserCampaignModel> {
                public final void m13276a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    FundraiserCampaignModel fundraiserCampaignModel = (FundraiserCampaignModel) obj;
                    if (fundraiserCampaignModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(fundraiserCampaignModel.m13279a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        fundraiserCampaignModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    FundraiserCampaignParser.m13286a(fundraiserCampaignModel.w_(), fundraiserCampaignModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(FundraiserCampaignModel.class, new Serializer());
                }
            }

            public FundraiserCampaignModel() {
                super(2);
            }

            @Nullable
            private String m13277a() {
                this.f12736d = super.a(this.f12736d, 0);
                return this.f12736d;
            }

            @Nullable
            private String m13278j() {
                this.f12737e = super.a(this.f12737e, 1);
                return this.f12737e;
            }

            public final int jK_() {
                return 98695003;
            }

            public final GraphQLVisitableModel m13280a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m13279a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m13277a());
                int b2 = flatBufferBuilder.b(m13278j());
                flatBufferBuilder.c(2);
                flatBufferBuilder.b(0, b);
                flatBufferBuilder.b(1, b2);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: Onavo_bookmark_click */
        public class Serializer extends JsonSerializer<FundraiserCampaignDonateMutationFieldsModel> {
            public final void m13281a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                FundraiserCampaignDonateMutationFieldsModel fundraiserCampaignDonateMutationFieldsModel = (FundraiserCampaignDonateMutationFieldsModel) obj;
                if (fundraiserCampaignDonateMutationFieldsModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(fundraiserCampaignDonateMutationFieldsModel.m13283a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    fundraiserCampaignDonateMutationFieldsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = fundraiserCampaignDonateMutationFieldsModel.w_();
                int u_ = fundraiserCampaignDonateMutationFieldsModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("fundraiser_campaign");
                    FundraiserCampaignParser.m13286a(mutableFlatBuffer, g, jsonGenerator);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(FundraiserCampaignDonateMutationFieldsModel.class, new Serializer());
            }
        }

        public FundraiserCampaignDonateMutationFieldsModel() {
            super(1);
        }

        @Nullable
        private FundraiserCampaignModel m13282a() {
            this.f12738d = (FundraiserCampaignModel) super.a(this.f12738d, 0, FundraiserCampaignModel.class);
            return this.f12738d;
        }

        public final int jK_() {
            return 307837796;
        }

        public final GraphQLVisitableModel m13284a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m13282a() != null) {
                FundraiserCampaignModel fundraiserCampaignModel = (FundraiserCampaignModel) graphQLModelMutatingVisitor.b(m13282a());
                if (m13282a() != fundraiserCampaignModel) {
                    graphQLVisitableModel = (FundraiserCampaignDonateMutationFieldsModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f12738d = fundraiserCampaignModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m13283a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m13282a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }
}
