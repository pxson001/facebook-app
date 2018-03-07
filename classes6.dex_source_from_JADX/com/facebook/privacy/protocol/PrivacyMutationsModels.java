package com.facebook.privacy.protocol;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbSerializerProvider;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.FragmentModelWithBridge;
import com.facebook.flatbuffers.ModelWithFlatBufferFormatHash;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.model.GraphQLPrivacyOption;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.ModelHelper;
import com.facebook.graphql.visitor.ConsistencyTuple;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLPersistableNode;
import com.facebook.graphql.visitor.GraphQLVisitableConsistentModel;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.facebook.privacy.protocol.PrivacyMutationsParsers.SetStoryPrivacyCoreMutationFieldsParser;
import com.facebook.privacy.protocol.PrivacyMutationsParsers.SetStoryPrivacyStoryFieldsParser;
import com.facebook.privacy.protocol.PrivacyMutationsParsers.SetStoryPrivacyStoryFieldsParser.PrivacyScopeParser;
import com.facebook.privacy.protocol.PrivacyMutationsParsers.SetStoryPrivacyStoryFieldsParser.PrivacyScopeParser.EducationInfoParser;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.nio.ByteBuffer;
import javax.annotation.Nullable;

/* compiled from: sticker_pack_download_tapped */
public class PrivacyMutationsModels {

    @FragmentModelWithBridge
    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -5873109)
    @JsonSerialize(using = Serializer.class)
    /* compiled from: sticker_pack_download_tapped */
    public final class SetStoryPrivacyCoreMutationFieldsModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private SetStoryPrivacyStoryFieldsModel f4140d;

        /* compiled from: sticker_pack_download_tapped */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(SetStoryPrivacyCoreMutationFieldsModel.class, new Deserializer());
            }

            public Object m6075a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = SetStoryPrivacyCoreMutationFieldsParser.m6101a(jsonParser);
                Object setStoryPrivacyCoreMutationFieldsModel = new SetStoryPrivacyCoreMutationFieldsModel();
                ((BaseModel) setStoryPrivacyCoreMutationFieldsModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (setStoryPrivacyCoreMutationFieldsModel instanceof Postprocessable) {
                    return ((Postprocessable) setStoryPrivacyCoreMutationFieldsModel).a();
                }
                return setStoryPrivacyCoreMutationFieldsModel;
            }
        }

        /* compiled from: sticker_pack_download_tapped */
        public class Serializer extends JsonSerializer<SetStoryPrivacyCoreMutationFieldsModel> {
            public final void m6076a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                SetStoryPrivacyCoreMutationFieldsModel setStoryPrivacyCoreMutationFieldsModel = (SetStoryPrivacyCoreMutationFieldsModel) obj;
                if (setStoryPrivacyCoreMutationFieldsModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(setStoryPrivacyCoreMutationFieldsModel.m6077a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    setStoryPrivacyCoreMutationFieldsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = setStoryPrivacyCoreMutationFieldsModel.w_();
                int u_ = setStoryPrivacyCoreMutationFieldsModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("node");
                    SetStoryPrivacyStoryFieldsParser.m6107a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(SetStoryPrivacyCoreMutationFieldsModel.class, new Serializer());
            }
        }

        public SetStoryPrivacyCoreMutationFieldsModel() {
            super(1);
        }

        @Nullable
        public final SetStoryPrivacyStoryFieldsModel m6079a() {
            this.f4140d = (SetStoryPrivacyStoryFieldsModel) super.a(this.f4140d, 0, SetStoryPrivacyStoryFieldsModel.class);
            return this.f4140d;
        }

        public final int jK_() {
            return -1921792201;
        }

        public final GraphQLVisitableModel m6078a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m6079a() != null) {
                SetStoryPrivacyStoryFieldsModel setStoryPrivacyStoryFieldsModel = (SetStoryPrivacyStoryFieldsModel) graphQLModelMutatingVisitor.b(m6079a());
                if (m6079a() != setStoryPrivacyStoryFieldsModel) {
                    graphQLVisitableModel = (SetStoryPrivacyCoreMutationFieldsModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f4140d = setStoryPrivacyStoryFieldsModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m6077a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m6079a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }

    @FragmentModelWithBridge
    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 568308601)
    @JsonSerialize(using = Serializer.class)
    /* compiled from: sticker_pack_download_tapped */
    public final class SetStoryPrivacyStoryFieldsModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
        @Nullable
        private String f4144d;
        @Nullable
        private PrivacyScopeModel f4145e;

        /* compiled from: sticker_pack_download_tapped */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(SetStoryPrivacyStoryFieldsModel.class, new Deserializer());
            }

            public Object m6080a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(SetStoryPrivacyStoryFieldsParser.m6106a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object setStoryPrivacyStoryFieldsModel = new SetStoryPrivacyStoryFieldsModel();
                ((BaseModel) setStoryPrivacyStoryFieldsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (setStoryPrivacyStoryFieldsModel instanceof Postprocessable) {
                    return ((Postprocessable) setStoryPrivacyStoryFieldsModel).a();
                }
                return setStoryPrivacyStoryFieldsModel;
            }
        }

        @FragmentModelWithBridge
        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -1732414556)
        @JsonSerialize(using = Serializer.class)
        /* compiled from: sticker_pack_download_tapped */
        public final class PrivacyScopeModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private EducationInfoModel f4142d;
            @Nullable
            private String f4143e;

            /* compiled from: sticker_pack_download_tapped */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(PrivacyScopeModel.class, new Deserializer());
                }

                public Object m6081a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(PrivacyScopeParser.m6104a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object privacyScopeModel = new PrivacyScopeModel();
                    ((BaseModel) privacyScopeModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (privacyScopeModel instanceof Postprocessable) {
                        return ((Postprocessable) privacyScopeModel).a();
                    }
                    return privacyScopeModel;
                }
            }

            @FragmentModelWithBridge
            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = 639265383)
            @JsonSerialize(using = Serializer.class)
            /* compiled from: sticker_pack_download_tapped */
            public final class EducationInfoModel extends BaseModel implements GraphQLVisitableModel {
                @Nullable
                private GraphQLPrivacyOption f4141d;

                /* compiled from: sticker_pack_download_tapped */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(EducationInfoModel.class, new Deserializer());
                    }

                    public Object m6082a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(EducationInfoParser.m6102a(jsonParser, flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        mutableFlatBuffer.a(4, Boolean.valueOf(true));
                        MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                        Object educationInfoModel = new EducationInfoModel();
                        ((BaseModel) educationInfoModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                        if (educationInfoModel instanceof Postprocessable) {
                            return ((Postprocessable) educationInfoModel).a();
                        }
                        return educationInfoModel;
                    }
                }

                /* compiled from: sticker_pack_download_tapped */
                public class Serializer extends JsonSerializer<EducationInfoModel> {
                    public final void m6083a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        EducationInfoModel educationInfoModel = (EducationInfoModel) obj;
                        if (educationInfoModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(educationInfoModel.m6084a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            educationInfoModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        EducationInfoParser.m6103a(educationInfoModel.w_(), educationInfoModel.u_(), jsonGenerator, serializerProvider);
                    }

                    static {
                        FbSerializerProvider.a(EducationInfoModel.class, new Serializer());
                    }
                }

                public EducationInfoModel() {
                    super(1);
                }

                @Nullable
                public final GraphQLPrivacyOption m6085a() {
                    this.f4141d = (GraphQLPrivacyOption) super.a(this.f4141d, 0, GraphQLPrivacyOption.class);
                    return this.f4141d;
                }

                public final int jK_() {
                    return 1177119214;
                }

                public final GraphQLVisitableModel m6086a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    GraphQLVisitableModel graphQLVisitableModel = null;
                    h();
                    if (m6085a() != null) {
                        GraphQLPrivacyOption graphQLPrivacyOption = (GraphQLPrivacyOption) graphQLModelMutatingVisitor.b(m6085a());
                        if (m6085a() != graphQLPrivacyOption) {
                            graphQLVisitableModel = (EducationInfoModel) ModelHelper.a(null, this);
                            graphQLVisitableModel.f4141d = graphQLPrivacyOption;
                        }
                    }
                    i();
                    return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                }

                public final int m6084a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int a = ModelHelper.a(flatBufferBuilder, m6085a());
                    flatBufferBuilder.c(1);
                    flatBufferBuilder.b(0, a);
                    i();
                    return flatBufferBuilder.d();
                }
            }

            /* compiled from: sticker_pack_download_tapped */
            public class Serializer extends JsonSerializer<PrivacyScopeModel> {
                public final void m6087a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    PrivacyScopeModel privacyScopeModel = (PrivacyScopeModel) obj;
                    if (privacyScopeModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(privacyScopeModel.m6088a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        privacyScopeModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    PrivacyScopeParser.m6105a(privacyScopeModel.w_(), privacyScopeModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(PrivacyScopeModel.class, new Serializer());
                }
            }

            public PrivacyScopeModel() {
                super(2);
            }

            @Nullable
            public final EducationInfoModel m6090a() {
                this.f4142d = (EducationInfoModel) super.a(this.f4142d, 0, EducationInfoModel.class);
                return this.f4142d;
            }

            @Nullable
            public final String m6092j() {
                this.f4143e = super.a(this.f4143e, 1);
                return this.f4143e;
            }

            public final void m6091a(@Nullable String str) {
                this.f4143e = str;
                if (this.b != null && this.b.d) {
                    this.b.a(this.c, 1, str);
                }
            }

            public final int jK_() {
                return -476351540;
            }

            public final GraphQLVisitableModel m6089a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m6090a() != null) {
                    EducationInfoModel educationInfoModel = (EducationInfoModel) graphQLModelMutatingVisitor.b(m6090a());
                    if (m6090a() != educationInfoModel) {
                        graphQLVisitableModel = (PrivacyScopeModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f4142d = educationInfoModel;
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m6088a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m6090a());
                int b = flatBufferBuilder.b(m6092j());
                flatBufferBuilder.c(2);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.b(1, b);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: sticker_pack_download_tapped */
        public class Serializer extends JsonSerializer<SetStoryPrivacyStoryFieldsModel> {
            public final void m6093a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                SetStoryPrivacyStoryFieldsModel setStoryPrivacyStoryFieldsModel = (SetStoryPrivacyStoryFieldsModel) obj;
                if (setStoryPrivacyStoryFieldsModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(setStoryPrivacyStoryFieldsModel.m6095a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    setStoryPrivacyStoryFieldsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                SetStoryPrivacyStoryFieldsParser.m6107a(setStoryPrivacyStoryFieldsModel.w_(), setStoryPrivacyStoryFieldsModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(SetStoryPrivacyStoryFieldsModel.class, new Serializer());
            }
        }

        public SetStoryPrivacyStoryFieldsModel() {
            super(2);
        }

        public final void m6098a(String str, ConsistencyTuple consistencyTuple) {
            if ("privacy_scope.type".equals(str)) {
                PrivacyScopeModel j = m6100j();
                if (j != null) {
                    consistencyTuple.a = j.m6092j();
                    consistencyTuple.b = j.u_();
                    consistencyTuple.c = 1;
                    return;
                }
            }
            consistencyTuple.a();
        }

        public final void m6099a(String str, Object obj, boolean z) {
            if ("privacy_scope.type".equals(str)) {
                PrivacyScopeModel j = m6100j();
                if (j == null) {
                    return;
                }
                if (z) {
                    j = (PrivacyScopeModel) j.clone();
                    j.m6091a((String) obj);
                    this.f4145e = j;
                    return;
                }
                j.m6091a((String) obj);
            }
        }

        @Nullable
        private String m6094k() {
            this.f4144d = super.a(this.f4144d, 0);
            return this.f4144d;
        }

        @Nullable
        public final PrivacyScopeModel m6100j() {
            this.f4145e = (PrivacyScopeModel) super.a(this.f4145e, 1, PrivacyScopeModel.class);
            return this.f4145e;
        }

        @Nullable
        public final String m6097a() {
            return m6094k();
        }

        public final int jK_() {
            return 80218325;
        }

        public final GraphQLVisitableModel m6096a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m6100j() != null) {
                PrivacyScopeModel privacyScopeModel = (PrivacyScopeModel) graphQLModelMutatingVisitor.b(m6100j());
                if (m6100j() != privacyScopeModel) {
                    graphQLVisitableModel = (SetStoryPrivacyStoryFieldsModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f4145e = privacyScopeModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m6095a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int b = flatBufferBuilder.b(m6094k());
            int a = ModelHelper.a(flatBufferBuilder, m6100j());
            flatBufferBuilder.c(2);
            flatBufferBuilder.b(0, b);
            flatBufferBuilder.b(1, a);
            i();
            return flatBufferBuilder.d();
        }
    }
}
