package com.facebook.contacts.ccu.graphql;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbSerializerProvider;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.contacts.ccu.graphql.ContactsUploadSettingMutationParsers.ContinuousContactUploadSettingUpdateMutationFieldsParser;
import com.facebook.contacts.ccu.graphql.ContactsUploadSettingMutationParsers.ContinuousContactUploadSettingUpdateMutationFieldsParser.ContinuousContactUploadSettingParser;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.FragmentModelWithoutBridge;
import com.facebook.flatbuffers.ModelWithFlatBufferFormatHash;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.enums.GraphQLContinuousContactUploadSettingStatusEnum;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.ModelHelper;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLPersistableNode;
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

/* compiled from: process_error */
public class ContactsUploadSettingMutationModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -2128453461)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: process_error */
    public final class ContinuousContactUploadSettingUpdateMutationFieldsModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private ContinuousContactUploadSettingModel f6277d;

        /* compiled from: process_error */
        public final class Builder {
            @Nullable
            public ContinuousContactUploadSettingModel f6274a;
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -1988805379)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: process_error */
        public final class ContinuousContactUploadSettingModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableModel {
            @Nullable
            private String f6275d;
            @Nullable
            private GraphQLContinuousContactUploadSettingStatusEnum f6276e;

            /* compiled from: process_error */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(ContinuousContactUploadSettingModel.class, new Deserializer());
                }

                public Object m6676a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(ContinuousContactUploadSettingParser.m6688a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object continuousContactUploadSettingModel = new ContinuousContactUploadSettingModel();
                    ((BaseModel) continuousContactUploadSettingModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (continuousContactUploadSettingModel instanceof Postprocessable) {
                        return ((Postprocessable) continuousContactUploadSettingModel).a();
                    }
                    return continuousContactUploadSettingModel;
                }
            }

            /* compiled from: process_error */
            public class Serializer extends JsonSerializer<ContinuousContactUploadSettingModel> {
                public final void m6677a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    ContinuousContactUploadSettingModel continuousContactUploadSettingModel = (ContinuousContactUploadSettingModel) obj;
                    if (continuousContactUploadSettingModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(continuousContactUploadSettingModel.m6679a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        continuousContactUploadSettingModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    ContinuousContactUploadSettingParser.m6689a(continuousContactUploadSettingModel.w_(), continuousContactUploadSettingModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(ContinuousContactUploadSettingModel.class, new Serializer());
                }
            }

            public ContinuousContactUploadSettingModel() {
                super(2);
            }

            @Nullable
            private String m6678k() {
                this.f6275d = super.a(this.f6275d, 0);
                return this.f6275d;
            }

            @Nullable
            public final GraphQLContinuousContactUploadSettingStatusEnum m6682j() {
                this.f6276e = (GraphQLContinuousContactUploadSettingStatusEnum) super.b(this.f6276e, 1, GraphQLContinuousContactUploadSettingStatusEnum.class, GraphQLContinuousContactUploadSettingStatusEnum.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
                return this.f6276e;
            }

            @Nullable
            public final String m6681a() {
                return m6678k();
            }

            public final int jK_() {
                return -606324066;
            }

            public final GraphQLVisitableModel m6680a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m6679a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m6678k());
                int a = flatBufferBuilder.a(m6682j());
                flatBufferBuilder.c(2);
                flatBufferBuilder.b(0, b);
                flatBufferBuilder.b(1, a);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: process_error */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(ContinuousContactUploadSettingUpdateMutationFieldsModel.class, new Deserializer());
            }

            public Object m6683a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = ContinuousContactUploadSettingUpdateMutationFieldsParser.m6690a(jsonParser);
                Object continuousContactUploadSettingUpdateMutationFieldsModel = new ContinuousContactUploadSettingUpdateMutationFieldsModel();
                ((BaseModel) continuousContactUploadSettingUpdateMutationFieldsModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (continuousContactUploadSettingUpdateMutationFieldsModel instanceof Postprocessable) {
                    return ((Postprocessable) continuousContactUploadSettingUpdateMutationFieldsModel).a();
                }
                return continuousContactUploadSettingUpdateMutationFieldsModel;
            }
        }

        /* compiled from: process_error */
        public class Serializer extends JsonSerializer<ContinuousContactUploadSettingUpdateMutationFieldsModel> {
            public final void m6684a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                ContinuousContactUploadSettingUpdateMutationFieldsModel continuousContactUploadSettingUpdateMutationFieldsModel = (ContinuousContactUploadSettingUpdateMutationFieldsModel) obj;
                if (continuousContactUploadSettingUpdateMutationFieldsModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(continuousContactUploadSettingUpdateMutationFieldsModel.m6685a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    continuousContactUploadSettingUpdateMutationFieldsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = continuousContactUploadSettingUpdateMutationFieldsModel.w_();
                int u_ = continuousContactUploadSettingUpdateMutationFieldsModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("continuous_contact_upload_setting");
                    ContinuousContactUploadSettingParser.m6689a(mutableFlatBuffer, g, jsonGenerator);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(ContinuousContactUploadSettingUpdateMutationFieldsModel.class, new Serializer());
            }
        }

        public ContinuousContactUploadSettingUpdateMutationFieldsModel() {
            super(1);
        }

        public ContinuousContactUploadSettingUpdateMutationFieldsModel(MutableFlatBuffer mutableFlatBuffer) {
            super(1);
            a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
        }

        @Nullable
        public final ContinuousContactUploadSettingModel m6686a() {
            this.f6277d = (ContinuousContactUploadSettingModel) super.a(this.f6277d, 0, ContinuousContactUploadSettingModel.class);
            return this.f6277d;
        }

        public final int jK_() {
            return 1415873030;
        }

        public final GraphQLVisitableModel m6687a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m6686a() != null) {
                ContinuousContactUploadSettingModel continuousContactUploadSettingModel = (ContinuousContactUploadSettingModel) graphQLModelMutatingVisitor.b(m6686a());
                if (m6686a() != continuousContactUploadSettingModel) {
                    graphQLVisitableModel = (ContinuousContactUploadSettingUpdateMutationFieldsModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f6277d = continuousContactUploadSettingModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m6685a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m6686a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }
}
