package com.facebook.timeline.refresher.protocol;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbSerializerProvider;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.FragmentModelWithoutBridge;
import com.facebook.flatbuffers.ModelWithFlatBufferFormatHash;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.enums.GraphQLProfileWizardStepType;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.ModelHelper;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLVisitableConsistentModel;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.facebook.timeline.refresher.protocol.FetchProfileRefresherGraphQLParsers.ProfileWizardNuxFieldsParser;
import com.facebook.timeline.refresher.protocol.FetchProfileRefresherGraphQLParsers.ProfileWizardNuxFieldsParser.CoverPhotoParser;
import com.facebook.timeline.refresher.protocol.FetchProfileRefresherGraphQLParsers.ProfileWizardRefresherFieldsParser;
import com.facebook.timeline.refresher.protocol.FetchProfileRefresherGraphQLParsers.RefresherStepsFieldsParser;
import com.facebook.timeline.refresher.protocol.FetchProfileRefresherGraphQLParsers.RefresherStepsNodeFieldsParser;
import com.facebook.timeline.refresher.protocol.FetchProfileRefresherGraphQLParsers.RefresherStepsNodeFieldsParser.DescriptionWithEntitiesParser;
import com.facebook.timeline.refresher.protocol.FetchProfileRefresherGraphQLParsers.RefresherStepsNodeFieldsParser.TitleParser;
import com.facebook.timeline.refresher.protocol.FetchProfileRefresherGraphQLParsers.TimelineNuxQueryParser;
import com.facebook.timeline.refresher.protocol.FetchProfileRefresherGraphQLParsers.TimelineRefresherQueryParser;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import java.nio.ByteBuffer;
import java.util.List;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/* compiled from: unlink_business */
public class FetchProfileRefresherGraphQLModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 664968925)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: unlink_business */
    public final class ProfileWizardNuxFieldsModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private CoverPhotoModel f1077d;
        @Nullable
        private RefresherStepsFieldsModel f1078e;

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 842551240)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: unlink_business */
        public final class CoverPhotoModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private String f1076d;

            /* compiled from: unlink_business */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(CoverPhotoModel.class, new Deserializer());
                }

                public Object m1072a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(CoverPhotoParser.m1149a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object coverPhotoModel = new CoverPhotoModel();
                    ((BaseModel) coverPhotoModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (coverPhotoModel instanceof Postprocessable) {
                        return ((Postprocessable) coverPhotoModel).a();
                    }
                    return coverPhotoModel;
                }
            }

            /* compiled from: unlink_business */
            public class Serializer extends JsonSerializer<CoverPhotoModel> {
                public final void m1073a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    CoverPhotoModel coverPhotoModel = (CoverPhotoModel) obj;
                    if (coverPhotoModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(coverPhotoModel.m1074a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        coverPhotoModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    CoverPhotoParser.m1150a(coverPhotoModel.w_(), coverPhotoModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(CoverPhotoModel.class, new Serializer());
                }
            }

            public CoverPhotoModel() {
                super(1);
            }

            @Nullable
            public final String m1076a() {
                this.f1076d = super.a(this.f1076d, 0);
                return this.f1076d;
            }

            public final int jK_() {
                return 70760763;
            }

            public final GraphQLVisitableModel m1075a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m1074a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m1076a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, b);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: unlink_business */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(ProfileWizardNuxFieldsModel.class, new Deserializer());
            }

            public Object m1077a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(ProfileWizardNuxFieldsParser.m1151a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object profileWizardNuxFieldsModel = new ProfileWizardNuxFieldsModel();
                ((BaseModel) profileWizardNuxFieldsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (profileWizardNuxFieldsModel instanceof Postprocessable) {
                    return ((Postprocessable) profileWizardNuxFieldsModel).a();
                }
                return profileWizardNuxFieldsModel;
            }
        }

        /* compiled from: unlink_business */
        public class Serializer extends JsonSerializer<ProfileWizardNuxFieldsModel> {
            public final void m1078a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                ProfileWizardNuxFieldsModel profileWizardNuxFieldsModel = (ProfileWizardNuxFieldsModel) obj;
                if (profileWizardNuxFieldsModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(profileWizardNuxFieldsModel.m1079a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    profileWizardNuxFieldsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                ProfileWizardNuxFieldsParser.m1152a(profileWizardNuxFieldsModel.w_(), profileWizardNuxFieldsModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(ProfileWizardNuxFieldsModel.class, new Serializer());
            }
        }

        public ProfileWizardNuxFieldsModel() {
            super(2);
        }

        @Nullable
        public final CoverPhotoModel m1081a() {
            this.f1077d = (CoverPhotoModel) super.a(this.f1077d, 0, CoverPhotoModel.class);
            return this.f1077d;
        }

        @Nullable
        public final RefresherStepsFieldsModel m1082j() {
            this.f1078e = (RefresherStepsFieldsModel) super.a(this.f1078e, 1, RefresherStepsFieldsModel.class);
            return this.f1078e;
        }

        public final int jK_() {
            return -1303636323;
        }

        public final GraphQLVisitableModel m1080a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m1081a() != null) {
                CoverPhotoModel coverPhotoModel = (CoverPhotoModel) graphQLModelMutatingVisitor.b(m1081a());
                if (m1081a() != coverPhotoModel) {
                    graphQLVisitableModel = (ProfileWizardNuxFieldsModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f1077d = coverPhotoModel;
                }
            }
            if (m1082j() != null) {
                RefresherStepsFieldsModel refresherStepsFieldsModel = (RefresherStepsFieldsModel) graphQLModelMutatingVisitor.b(m1082j());
                if (m1082j() != refresherStepsFieldsModel) {
                    graphQLVisitableModel = (ProfileWizardNuxFieldsModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f1078e = refresherStepsFieldsModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m1079a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m1081a());
            int a2 = ModelHelper.a(flatBufferBuilder, m1082j());
            flatBufferBuilder.c(2);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, a2);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -1099120842)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: unlink_business */
    public final class ProfileWizardRefresherFieldsModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private CoverPhotoModel f1080d;
        @Nullable
        private RefresherStepsFieldsModel f1081e;

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 842551240)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: unlink_business */
        public final class CoverPhotoModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private String f1079d;

            /* compiled from: unlink_business */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(CoverPhotoModel.class, new Deserializer());
                }

                public Object m1083a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(ProfileWizardRefresherFieldsParser.CoverPhotoParser.m1153a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object coverPhotoModel = new CoverPhotoModel();
                    ((BaseModel) coverPhotoModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (coverPhotoModel instanceof Postprocessable) {
                        return ((Postprocessable) coverPhotoModel).a();
                    }
                    return coverPhotoModel;
                }
            }

            /* compiled from: unlink_business */
            public class Serializer extends JsonSerializer<CoverPhotoModel> {
                public final void m1084a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    CoverPhotoModel coverPhotoModel = (CoverPhotoModel) obj;
                    if (coverPhotoModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(coverPhotoModel.m1085a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        coverPhotoModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    ProfileWizardRefresherFieldsParser.CoverPhotoParser.m1154a(coverPhotoModel.w_(), coverPhotoModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(CoverPhotoModel.class, new Serializer());
                }
            }

            public CoverPhotoModel() {
                super(1);
            }

            @Nullable
            public final String m1087a() {
                this.f1079d = super.a(this.f1079d, 0);
                return this.f1079d;
            }

            public final int jK_() {
                return 70760763;
            }

            public final GraphQLVisitableModel m1086a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m1085a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m1087a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, b);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: unlink_business */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(ProfileWizardRefresherFieldsModel.class, new Deserializer());
            }

            public Object m1088a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(ProfileWizardRefresherFieldsParser.m1155a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object profileWizardRefresherFieldsModel = new ProfileWizardRefresherFieldsModel();
                ((BaseModel) profileWizardRefresherFieldsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (profileWizardRefresherFieldsModel instanceof Postprocessable) {
                    return ((Postprocessable) profileWizardRefresherFieldsModel).a();
                }
                return profileWizardRefresherFieldsModel;
            }
        }

        /* compiled from: unlink_business */
        public class Serializer extends JsonSerializer<ProfileWizardRefresherFieldsModel> {
            public final void m1089a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                ProfileWizardRefresherFieldsModel profileWizardRefresherFieldsModel = (ProfileWizardRefresherFieldsModel) obj;
                if (profileWizardRefresherFieldsModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(profileWizardRefresherFieldsModel.m1090a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    profileWizardRefresherFieldsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                ProfileWizardRefresherFieldsParser.m1156a(profileWizardRefresherFieldsModel.w_(), profileWizardRefresherFieldsModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(ProfileWizardRefresherFieldsModel.class, new Serializer());
            }
        }

        public ProfileWizardRefresherFieldsModel() {
            super(2);
        }

        @Nullable
        public final CoverPhotoModel m1092a() {
            this.f1080d = (CoverPhotoModel) super.a(this.f1080d, 0, CoverPhotoModel.class);
            return this.f1080d;
        }

        @Nullable
        public final RefresherStepsFieldsModel m1093j() {
            this.f1081e = (RefresherStepsFieldsModel) super.a(this.f1081e, 1, RefresherStepsFieldsModel.class);
            return this.f1081e;
        }

        public final int jK_() {
            return 2141145812;
        }

        public final GraphQLVisitableModel m1091a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m1092a() != null) {
                CoverPhotoModel coverPhotoModel = (CoverPhotoModel) graphQLModelMutatingVisitor.b(m1092a());
                if (m1092a() != coverPhotoModel) {
                    graphQLVisitableModel = (ProfileWizardRefresherFieldsModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f1080d = coverPhotoModel;
                }
            }
            if (m1093j() != null) {
                RefresherStepsFieldsModel refresherStepsFieldsModel = (RefresherStepsFieldsModel) graphQLModelMutatingVisitor.b(m1093j());
                if (m1093j() != refresherStepsFieldsModel) {
                    graphQLVisitableModel = (ProfileWizardRefresherFieldsModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f1081e = refresherStepsFieldsModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m1090a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m1092a());
            int a2 = ModelHelper.a(flatBufferBuilder, m1093j());
            flatBufferBuilder.c(2);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, a2);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 1387020143)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: unlink_business */
    public final class RefresherStepsFieldsModel extends BaseModel implements GraphQLVisitableModel {
        private int f1082d;
        @Nullable
        private List<RefresherStepsNodeFieldsModel> f1083e;

        /* compiled from: unlink_business */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(RefresherStepsFieldsModel.class, new Deserializer());
            }

            public Object m1094a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(RefresherStepsFieldsParser.m1157a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object refresherStepsFieldsModel = new RefresherStepsFieldsModel();
                ((BaseModel) refresherStepsFieldsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (refresherStepsFieldsModel instanceof Postprocessable) {
                    return ((Postprocessable) refresherStepsFieldsModel).a();
                }
                return refresherStepsFieldsModel;
            }
        }

        /* compiled from: unlink_business */
        public class Serializer extends JsonSerializer<RefresherStepsFieldsModel> {
            public final void m1095a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                RefresherStepsFieldsModel refresherStepsFieldsModel = (RefresherStepsFieldsModel) obj;
                if (refresherStepsFieldsModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(refresherStepsFieldsModel.m1096a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    refresherStepsFieldsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                RefresherStepsFieldsParser.m1158a(refresherStepsFieldsModel.w_(), refresherStepsFieldsModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(RefresherStepsFieldsModel.class, new Serializer());
            }
        }

        public RefresherStepsFieldsModel() {
            super(2);
        }

        @Nonnull
        public final ImmutableList<RefresherStepsNodeFieldsModel> m1098a() {
            this.f1083e = super.a(this.f1083e, 1, RefresherStepsNodeFieldsModel.class);
            return (ImmutableList) this.f1083e;
        }

        public final int jK_() {
            return -368253327;
        }

        public final GraphQLVisitableModel m1097a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m1098a() != null) {
                Builder a = ModelHelper.a(m1098a(), graphQLModelMutatingVisitor);
                if (a != null) {
                    graphQLVisitableModel = (RefresherStepsFieldsModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f1083e = a.b();
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m1096a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m1098a());
            flatBufferBuilder.c(2);
            flatBufferBuilder.a(0, this.f1082d, 0);
            flatBufferBuilder.b(1, a);
            i();
            return flatBufferBuilder.d();
        }

        public final void m1099a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
            super.a(mutableFlatBuffer, i, obj);
            this.f1082d = mutableFlatBuffer.a(i, 0, 0);
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -616753744)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: unlink_business */
    public final class RefresherStepsNodeFieldsModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private DescriptionWithEntitiesModel f1086d;
        @Nullable
        private GraphQLProfileWizardStepType f1087e;
        @Nullable
        private TitleModel f1088f;

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -1352864475)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: unlink_business */
        public final class DescriptionWithEntitiesModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private String f1084d;

            /* compiled from: unlink_business */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(DescriptionWithEntitiesModel.class, new Deserializer());
                }

                public Object m1100a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(DescriptionWithEntitiesParser.m1159a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object descriptionWithEntitiesModel = new DescriptionWithEntitiesModel();
                    ((BaseModel) descriptionWithEntitiesModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (descriptionWithEntitiesModel instanceof Postprocessable) {
                        return ((Postprocessable) descriptionWithEntitiesModel).a();
                    }
                    return descriptionWithEntitiesModel;
                }
            }

            /* compiled from: unlink_business */
            public class Serializer extends JsonSerializer<DescriptionWithEntitiesModel> {
                public final void m1101a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    DescriptionWithEntitiesModel descriptionWithEntitiesModel = (DescriptionWithEntitiesModel) obj;
                    if (descriptionWithEntitiesModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(descriptionWithEntitiesModel.m1102a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        descriptionWithEntitiesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    DescriptionWithEntitiesParser.m1160a(descriptionWithEntitiesModel.w_(), descriptionWithEntitiesModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(DescriptionWithEntitiesModel.class, new Serializer());
                }
            }

            public DescriptionWithEntitiesModel() {
                super(1);
            }

            @Nullable
            public final String m1104a() {
                this.f1084d = super.a(this.f1084d, 0);
                return this.f1084d;
            }

            public final int jK_() {
                return -1919764332;
            }

            public final GraphQLVisitableModel m1103a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m1102a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m1104a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, b);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: unlink_business */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(RefresherStepsNodeFieldsModel.class, new Deserializer());
            }

            public Object m1105a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(RefresherStepsNodeFieldsParser.m1163b(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object refresherStepsNodeFieldsModel = new RefresherStepsNodeFieldsModel();
                ((BaseModel) refresherStepsNodeFieldsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (refresherStepsNodeFieldsModel instanceof Postprocessable) {
                    return ((Postprocessable) refresherStepsNodeFieldsModel).a();
                }
                return refresherStepsNodeFieldsModel;
            }
        }

        /* compiled from: unlink_business */
        public class Serializer extends JsonSerializer<RefresherStepsNodeFieldsModel> {
            public final void m1106a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                RefresherStepsNodeFieldsModel refresherStepsNodeFieldsModel = (RefresherStepsNodeFieldsModel) obj;
                if (refresherStepsNodeFieldsModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(refresherStepsNodeFieldsModel.m1112a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    refresherStepsNodeFieldsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                RefresherStepsNodeFieldsParser.m1164b(refresherStepsNodeFieldsModel.w_(), refresherStepsNodeFieldsModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(RefresherStepsNodeFieldsModel.class, new Serializer());
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -1352864475)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: unlink_business */
        public final class TitleModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private String f1085d;

            /* compiled from: unlink_business */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(TitleModel.class, new Deserializer());
                }

                public Object m1107a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(TitleParser.m1161a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object titleModel = new TitleModel();
                    ((BaseModel) titleModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (titleModel instanceof Postprocessable) {
                        return ((Postprocessable) titleModel).a();
                    }
                    return titleModel;
                }
            }

            /* compiled from: unlink_business */
            public class Serializer extends JsonSerializer<TitleModel> {
                public final void m1108a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    TitleModel titleModel = (TitleModel) obj;
                    if (titleModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(titleModel.m1109a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        titleModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    TitleParser.m1162a(titleModel.w_(), titleModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(TitleModel.class, new Serializer());
                }
            }

            public TitleModel() {
                super(1);
            }

            @Nullable
            public final String m1111a() {
                this.f1085d = super.a(this.f1085d, 0);
                return this.f1085d;
            }

            public final int jK_() {
                return -1919764332;
            }

            public final GraphQLVisitableModel m1110a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m1109a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m1111a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, b);
                i();
                return flatBufferBuilder.d();
            }
        }

        public RefresherStepsNodeFieldsModel() {
            super(3);
        }

        @Nullable
        public final DescriptionWithEntitiesModel m1114a() {
            this.f1086d = (DescriptionWithEntitiesModel) super.a(this.f1086d, 0, DescriptionWithEntitiesModel.class);
            return this.f1086d;
        }

        @Nullable
        public final GraphQLProfileWizardStepType m1115j() {
            this.f1087e = (GraphQLProfileWizardStepType) super.b(this.f1087e, 1, GraphQLProfileWizardStepType.class, GraphQLProfileWizardStepType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
            return this.f1087e;
        }

        @Nullable
        public final TitleModel m1116k() {
            this.f1088f = (TitleModel) super.a(this.f1088f, 2, TitleModel.class);
            return this.f1088f;
        }

        public final int jK_() {
            return -1757841088;
        }

        public final GraphQLVisitableModel m1113a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m1114a() != null) {
                DescriptionWithEntitiesModel descriptionWithEntitiesModel = (DescriptionWithEntitiesModel) graphQLModelMutatingVisitor.b(m1114a());
                if (m1114a() != descriptionWithEntitiesModel) {
                    graphQLVisitableModel = (RefresherStepsNodeFieldsModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f1086d = descriptionWithEntitiesModel;
                }
            }
            if (m1116k() != null) {
                TitleModel titleModel = (TitleModel) graphQLModelMutatingVisitor.b(m1116k());
                if (m1116k() != titleModel) {
                    graphQLVisitableModel = (RefresherStepsNodeFieldsModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f1088f = titleModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m1112a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m1114a());
            int a2 = flatBufferBuilder.a(m1115j());
            int a3 = ModelHelper.a(flatBufferBuilder, m1116k());
            flatBufferBuilder.c(3);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, a2);
            flatBufferBuilder.b(2, a3);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 31980957)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: unlink_business */
    public final class TimelineCoverPhotoUriQueryModel extends BaseModel implements GraphQLVisitableConsistentModel {
        @Nullable
        private CoverPhotoModel f1092d;

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 344878870)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: unlink_business */
        public final class CoverPhotoModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private PhotoModel f1091d;

            /* compiled from: unlink_business */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r0 = com.facebook.timeline.refresher.protocol.FetchProfileRefresherGraphQLModels.TimelineCoverPhotoUriQueryModel.CoverPhotoModel.class;
                    r1 = new com.facebook.timeline.refresher.protocol.FetchProfileRefresherGraphQLModels$TimelineCoverPhotoUriQueryModel$CoverPhotoModel$Deserializer;
                    r1.<init>();
                    com.facebook.common.json.GlobalAutoGenDeserializerCache.a(r0, r1);
                    return;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.timeline.refresher.protocol.FetchProfileRefresherGraphQLModels.TimelineCoverPhotoUriQueryModel.CoverPhotoModel.Deserializer.<clinit>():void");
                }

                public java.lang.Object m1117a(com.fasterxml.jackson.core.JsonParser r11, com.fasterxml.jackson.databind.DeserializationContext r12) {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r10 = this;
                    r8 = 1;
                    r6 = 0;
                    r4 = new com.facebook.flatbuffers.FlatBufferBuilder;
                    r5 = 128; // 0x80 float:1.794E-43 double:6.32E-322;
                    r4.<init>(r5);
                    r5 = com.facebook.timeline.refresher.protocol.FetchProfileRefresherGraphQLParsers.TimelineCoverPhotoUriQueryParser.CoverPhotoParser.m1169a(r11, r4);
                    r4.d(r5);
                    r4 = r4.e();
                    r5 = java.nio.ByteBuffer.wrap(r4);
                    r4 = 0;
                    r5.position(r4);
                    r4 = new com.facebook.flatbuffers.MutableFlatBuffer;
                    r7 = r6;
                    r9 = r6;
                    r4.<init>(r5, r6, r7, r8, r9);
                    r5 = 4;
                    r6 = java.lang.Boolean.valueOf(r8);
                    r4.a(r5, r6);
                    r2 = r4;
                    r1 = new com.facebook.timeline.refresher.protocol.FetchProfileRefresherGraphQLModels$TimelineCoverPhotoUriQueryModel$CoverPhotoModel;
                    r1.<init>();
                    r4 = r2.a;
                    r0 = r4;
                    r3 = com.facebook.flatbuffers.FlatBuffer.a(r0);
                    r0 = r1;
                    r0 = (com.facebook.graphql.modelutil.BaseModel) r0;
                    r0.a(r2, r3, r11);
                    r0 = r1 instanceof com.facebook.common.json.Postprocessable;
                    if (r0 == 0) goto L_0x0048;
                L_0x0042:
                    r1 = (com.facebook.common.json.Postprocessable) r1;
                    r1 = r1.a();
                L_0x0048:
                    return r1;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.timeline.refresher.protocol.FetchProfileRefresherGraphQLModels.TimelineCoverPhotoUriQueryModel.CoverPhotoModel.Deserializer.a(com.fasterxml.jackson.core.JsonParser, com.fasterxml.jackson.databind.DeserializationContext):java.lang.Object");
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = 1369454661)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: unlink_business */
            public final class PhotoModel extends BaseModel implements GraphQLVisitableModel {
                @Nullable
                private ImageModel f1090d;

                /* compiled from: unlink_business */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                        /*
                        r0 = com.facebook.timeline.refresher.protocol.FetchProfileRefresherGraphQLModels.TimelineCoverPhotoUriQueryModel.CoverPhotoModel.PhotoModel.class;
                        r1 = new com.facebook.timeline.refresher.protocol.FetchProfileRefresherGraphQLModels$TimelineCoverPhotoUriQueryModel$CoverPhotoModel$PhotoModel$Deserializer;
                        r1.<init>();
                        com.facebook.common.json.GlobalAutoGenDeserializerCache.a(r0, r1);
                        return;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.timeline.refresher.protocol.FetchProfileRefresherGraphQLModels.TimelineCoverPhotoUriQueryModel.CoverPhotoModel.PhotoModel.Deserializer.<clinit>():void");
                    }

                    public java.lang.Object m1118a(com.fasterxml.jackson.core.JsonParser r11, com.fasterxml.jackson.databind.DeserializationContext r12) {
                        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                        /*
                        r10 = this;
                        r8 = 1;
                        r6 = 0;
                        r4 = new com.facebook.flatbuffers.FlatBufferBuilder;
                        r5 = 128; // 0x80 float:1.794E-43 double:6.32E-322;
                        r4.<init>(r5);
                        r5 = com.facebook.timeline.refresher.protocol.FetchProfileRefresherGraphQLParsers.TimelineCoverPhotoUriQueryParser.CoverPhotoParser.PhotoParser.m1167a(r11, r4);
                        r4.d(r5);
                        r4 = r4.e();
                        r5 = java.nio.ByteBuffer.wrap(r4);
                        r4 = 0;
                        r5.position(r4);
                        r4 = new com.facebook.flatbuffers.MutableFlatBuffer;
                        r7 = r6;
                        r9 = r6;
                        r4.<init>(r5, r6, r7, r8, r9);
                        r5 = 4;
                        r6 = java.lang.Boolean.valueOf(r8);
                        r4.a(r5, r6);
                        r2 = r4;
                        r1 = new com.facebook.timeline.refresher.protocol.FetchProfileRefresherGraphQLModels$TimelineCoverPhotoUriQueryModel$CoverPhotoModel$PhotoModel;
                        r1.<init>();
                        r4 = r2.a;
                        r0 = r4;
                        r3 = com.facebook.flatbuffers.FlatBuffer.a(r0);
                        r0 = r1;
                        r0 = (com.facebook.graphql.modelutil.BaseModel) r0;
                        r0.a(r2, r3, r11);
                        r0 = r1 instanceof com.facebook.common.json.Postprocessable;
                        if (r0 == 0) goto L_0x0048;
                    L_0x0042:
                        r1 = (com.facebook.common.json.Postprocessable) r1;
                        r1 = r1.a();
                    L_0x0048:
                        return r1;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.timeline.refresher.protocol.FetchProfileRefresherGraphQLModels.TimelineCoverPhotoUriQueryModel.CoverPhotoModel.PhotoModel.Deserializer.a(com.fasterxml.jackson.core.JsonParser, com.fasterxml.jackson.databind.DeserializationContext):java.lang.Object");
                    }
                }

                @JsonDeserialize(using = Deserializer.class)
                @ModelWithFlatBufferFormatHash(a = 842551240)
                @JsonSerialize(using = Serializer.class)
                @FragmentModelWithoutBridge
                /* compiled from: unlink_business */
                public final class ImageModel extends BaseModel implements GraphQLVisitableModel {
                    @Nullable
                    private String f1089d;

                    /* compiled from: unlink_business */
                    public class Deserializer extends FbJsonDeserializer {
                        static {
                            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                            /*
                            r0 = com.facebook.timeline.refresher.protocol.FetchProfileRefresherGraphQLModels.TimelineCoverPhotoUriQueryModel.CoverPhotoModel.PhotoModel.ImageModel.class;
                            r1 = new com.facebook.timeline.refresher.protocol.FetchProfileRefresherGraphQLModels$TimelineCoverPhotoUriQueryModel$CoverPhotoModel$PhotoModel$ImageModel$Deserializer;
                            r1.<init>();
                            com.facebook.common.json.GlobalAutoGenDeserializerCache.a(r0, r1);
                            return;
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.facebook.timeline.refresher.protocol.FetchProfileRefresherGraphQLModels.TimelineCoverPhotoUriQueryModel.CoverPhotoModel.PhotoModel.ImageModel.Deserializer.<clinit>():void");
                        }

                        public java.lang.Object m1119a(com.fasterxml.jackson.core.JsonParser r11, com.fasterxml.jackson.databind.DeserializationContext r12) {
                            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                            /*
                            r10 = this;
                            r8 = 1;
                            r6 = 0;
                            r4 = new com.facebook.flatbuffers.FlatBufferBuilder;
                            r5 = 128; // 0x80 float:1.794E-43 double:6.32E-322;
                            r4.<init>(r5);
                            r5 = com.facebook.timeline.refresher.protocol.FetchProfileRefresherGraphQLParsers.TimelineCoverPhotoUriQueryParser.CoverPhotoParser.PhotoParser.ImageParser.m1165a(r11, r4);
                            r4.d(r5);
                            r4 = r4.e();
                            r5 = java.nio.ByteBuffer.wrap(r4);
                            r4 = 0;
                            r5.position(r4);
                            r4 = new com.facebook.flatbuffers.MutableFlatBuffer;
                            r7 = r6;
                            r9 = r6;
                            r4.<init>(r5, r6, r7, r8, r9);
                            r5 = 4;
                            r6 = java.lang.Boolean.valueOf(r8);
                            r4.a(r5, r6);
                            r2 = r4;
                            r1 = new com.facebook.timeline.refresher.protocol.FetchProfileRefresherGraphQLModels$TimelineCoverPhotoUriQueryModel$CoverPhotoModel$PhotoModel$ImageModel;
                            r1.<init>();
                            r4 = r2.a;
                            r0 = r4;
                            r3 = com.facebook.flatbuffers.FlatBuffer.a(r0);
                            r0 = r1;
                            r0 = (com.facebook.graphql.modelutil.BaseModel) r0;
                            r0.a(r2, r3, r11);
                            r0 = r1 instanceof com.facebook.common.json.Postprocessable;
                            if (r0 == 0) goto L_0x0048;
                        L_0x0042:
                            r1 = (com.facebook.common.json.Postprocessable) r1;
                            r1 = r1.a();
                        L_0x0048:
                            return r1;
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.facebook.timeline.refresher.protocol.FetchProfileRefresherGraphQLModels.TimelineCoverPhotoUriQueryModel.CoverPhotoModel.PhotoModel.ImageModel.Deserializer.a(com.fasterxml.jackson.core.JsonParser, com.fasterxml.jackson.databind.DeserializationContext):java.lang.Object");
                        }
                    }

                    /* compiled from: unlink_business */
                    public class Serializer extends JsonSerializer<ImageModel> {
                        public final void m1120a(java.lang.Object r8, com.fasterxml.jackson.core.JsonGenerator r9, com.fasterxml.jackson.databind.SerializerProvider r10) {
                            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                            /*
                            r7 = this;
                            r8 = (com.facebook.timeline.refresher.protocol.FetchProfileRefresherGraphQLModels.TimelineCoverPhotoUriQueryModel.CoverPhotoModel.PhotoModel.ImageModel) r8;
                            r2 = 0;
                            r0 = r8.w_();
                            if (r0 != 0) goto L_0x0035;
                        L_0x0009:
                            r0 = new com.facebook.flatbuffers.FlatBufferBuilder;
                            r1 = 128; // 0x80 float:1.794E-43 double:6.32E-322;
                            r0.<init>(r1);
                            r1 = r8.m1121a(r0);
                            r0.d(r1);
                            r0 = r0.e();
                            r1 = java.nio.ByteBuffer.wrap(r0);
                            r0 = 0;
                            r1.position(r0);
                            r0 = new com.facebook.flatbuffers.MutableFlatBuffer;
                            r4 = 1;
                            r3 = r2;
                            r5 = r2;
                            r0.<init>(r1, r2, r3, r4, r5);
                            r6 = r0.a;
                            r1 = r6;
                            r1 = com.facebook.flatbuffers.FlatBuffer.a(r1);
                            r8.a(r0, r1);
                        L_0x0035:
                            r0 = r8.w_();
                            r1 = r8.u_();
                            com.facebook.timeline.refresher.protocol.FetchProfileRefresherGraphQLParsers.TimelineCoverPhotoUriQueryParser.CoverPhotoParser.PhotoParser.ImageParser.m1166a(r0, r1, r9);
                            return;
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.facebook.timeline.refresher.protocol.FetchProfileRefresherGraphQLModels.TimelineCoverPhotoUriQueryModel.CoverPhotoModel.PhotoModel.ImageModel.Serializer.a(java.lang.Object, com.fasterxml.jackson.core.JsonGenerator, com.fasterxml.jackson.databind.SerializerProvider):void");
                        }

                        static {
                            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                            /*
                            r0 = com.facebook.timeline.refresher.protocol.FetchProfileRefresherGraphQLModels.TimelineCoverPhotoUriQueryModel.CoverPhotoModel.PhotoModel.ImageModel.class;
                            r1 = new com.facebook.timeline.refresher.protocol.FetchProfileRefresherGraphQLModels$TimelineCoverPhotoUriQueryModel$CoverPhotoModel$PhotoModel$ImageModel$Serializer;
                            r1.<init>();
                            com.facebook.common.json.FbSerializerProvider.a(r0, r1);
                            return;
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.facebook.timeline.refresher.protocol.FetchProfileRefresherGraphQLModels.TimelineCoverPhotoUriQueryModel.CoverPhotoModel.PhotoModel.ImageModel.Serializer.<clinit>():void");
                        }
                    }

                    public ImageModel() {
                        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                        /*
                        r1 = this;
                        r0 = 1;
                        r1.<init>(r0);
                        return;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.timeline.refresher.protocol.FetchProfileRefresherGraphQLModels.TimelineCoverPhotoUriQueryModel.CoverPhotoModel.PhotoModel.ImageModel.<init>():void");
                    }

                    @javax.annotation.Nullable
                    public final java.lang.String m1123a() {
                        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                        /*
                        r2 = this;
                        r0 = r2.f1089d;
                        r1 = 0;
                        r0 = super.a(r0, r1);
                        r2.f1089d = r0;
                        r0 = r2.f1089d;
                        return r0;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.timeline.refresher.protocol.FetchProfileRefresherGraphQLModels.TimelineCoverPhotoUriQueryModel.CoverPhotoModel.PhotoModel.ImageModel.a():java.lang.String");
                    }

                    public final int jK_() {
                        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                        /*
                        r1 = this;
                        r0 = 70760763; // 0x437b93b float:2.15966E-36 double:3.4960462E-316;
                        return r0;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.timeline.refresher.protocol.FetchProfileRefresherGraphQLModels.TimelineCoverPhotoUriQueryModel.CoverPhotoModel.PhotoModel.ImageModel.jK_():int");
                    }

                    public final com.facebook.graphql.visitor.GraphQLVisitableModel m1122a(com.facebook.graphql.visitor.GraphQLModelMutatingVisitor r1) {
                        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                        /*
                        r0 = this;
                        r0.h();
                        r0.i();
                        return r0;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.timeline.refresher.protocol.FetchProfileRefresherGraphQLModels.TimelineCoverPhotoUriQueryModel.CoverPhotoModel.PhotoModel.ImageModel.a(com.facebook.graphql.visitor.GraphQLModelMutatingVisitor):com.facebook.graphql.visitor.GraphQLVisitableModel");
                    }

                    public final int m1121a(com.facebook.flatbuffers.FlatBufferBuilder r3) {
                        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                        /*
                        r2 = this;
                        r2.h();
                        r0 = r2.m1123a();
                        r0 = r3.b(r0);
                        r1 = 1;
                        r3.c(r1);
                        r1 = 0;
                        r3.b(r1, r0);
                        r2.i();
                        r0 = r3.d();
                        return r0;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.timeline.refresher.protocol.FetchProfileRefresherGraphQLModels.TimelineCoverPhotoUriQueryModel.CoverPhotoModel.PhotoModel.ImageModel.a(com.facebook.flatbuffers.FlatBufferBuilder):int");
                    }
                }

                /* compiled from: unlink_business */
                public class Serializer extends JsonSerializer<PhotoModel> {
                    public final void m1124a(java.lang.Object r8, com.fasterxml.jackson.core.JsonGenerator r9, com.fasterxml.jackson.databind.SerializerProvider r10) {
                        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                        /*
                        r7 = this;
                        r8 = (com.facebook.timeline.refresher.protocol.FetchProfileRefresherGraphQLModels.TimelineCoverPhotoUriQueryModel.CoverPhotoModel.PhotoModel) r8;
                        r2 = 0;
                        r0 = r8.w_();
                        if (r0 != 0) goto L_0x0035;
                    L_0x0009:
                        r0 = new com.facebook.flatbuffers.FlatBufferBuilder;
                        r1 = 128; // 0x80 float:1.794E-43 double:6.32E-322;
                        r0.<init>(r1);
                        r1 = r8.m1125a(r0);
                        r0.d(r1);
                        r0 = r0.e();
                        r1 = java.nio.ByteBuffer.wrap(r0);
                        r0 = 0;
                        r1.position(r0);
                        r0 = new com.facebook.flatbuffers.MutableFlatBuffer;
                        r4 = 1;
                        r3 = r2;
                        r5 = r2;
                        r0.<init>(r1, r2, r3, r4, r5);
                        r6 = r0.a;
                        r1 = r6;
                        r1 = com.facebook.flatbuffers.FlatBuffer.a(r1);
                        r8.a(r0, r1);
                    L_0x0035:
                        r0 = r8.w_();
                        r1 = r8.u_();
                        com.facebook.timeline.refresher.protocol.FetchProfileRefresherGraphQLParsers.TimelineCoverPhotoUriQueryParser.CoverPhotoParser.PhotoParser.m1168a(r0, r1, r9, r10);
                        return;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.timeline.refresher.protocol.FetchProfileRefresherGraphQLModels.TimelineCoverPhotoUriQueryModel.CoverPhotoModel.PhotoModel.Serializer.a(java.lang.Object, com.fasterxml.jackson.core.JsonGenerator, com.fasterxml.jackson.databind.SerializerProvider):void");
                    }

                    static {
                        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                        /*
                        r0 = com.facebook.timeline.refresher.protocol.FetchProfileRefresherGraphQLModels.TimelineCoverPhotoUriQueryModel.CoverPhotoModel.PhotoModel.class;
                        r1 = new com.facebook.timeline.refresher.protocol.FetchProfileRefresherGraphQLModels$TimelineCoverPhotoUriQueryModel$CoverPhotoModel$PhotoModel$Serializer;
                        r1.<init>();
                        com.facebook.common.json.FbSerializerProvider.a(r0, r1);
                        return;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.timeline.refresher.protocol.FetchProfileRefresherGraphQLModels.TimelineCoverPhotoUriQueryModel.CoverPhotoModel.PhotoModel.Serializer.<clinit>():void");
                    }
                }

                public PhotoModel() {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r1 = this;
                    r0 = 1;
                    r1.<init>(r0);
                    return;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.timeline.refresher.protocol.FetchProfileRefresherGraphQLModels.TimelineCoverPhotoUriQueryModel.CoverPhotoModel.PhotoModel.<init>():void");
                }

                @javax.annotation.Nullable
                public final com.facebook.timeline.refresher.protocol.FetchProfileRefresherGraphQLModels.TimelineCoverPhotoUriQueryModel.CoverPhotoModel.PhotoModel.ImageModel m1127a() {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r3 = this;
                    r0 = r3.f1090d;
                    r1 = 0;
                    r2 = com.facebook.timeline.refresher.protocol.FetchProfileRefresherGraphQLModels.TimelineCoverPhotoUriQueryModel.CoverPhotoModel.PhotoModel.ImageModel.class;
                    r0 = super.a(r0, r1, r2);
                    r0 = (com.facebook.timeline.refresher.protocol.FetchProfileRefresherGraphQLModels.TimelineCoverPhotoUriQueryModel.CoverPhotoModel.PhotoModel.ImageModel) r0;
                    r3.f1090d = r0;
                    r0 = r3.f1090d;
                    return r0;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.timeline.refresher.protocol.FetchProfileRefresherGraphQLModels.TimelineCoverPhotoUriQueryModel.CoverPhotoModel.PhotoModel.a():com.facebook.timeline.refresher.protocol.FetchProfileRefresherGraphQLModels$TimelineCoverPhotoUriQueryModel$CoverPhotoModel$PhotoModel$ImageModel");
                }

                public final int jK_() {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r1 = this;
                    r0 = 77090322; // 0x4984e12 float:3.5806725E-36 double:3.80876797E-316;
                    return r0;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.timeline.refresher.protocol.FetchProfileRefresherGraphQLModels.TimelineCoverPhotoUriQueryModel.CoverPhotoModel.PhotoModel.jK_():int");
                }

                public final com.facebook.graphql.visitor.GraphQLVisitableModel m1126a(com.facebook.graphql.visitor.GraphQLModelMutatingVisitor r4) {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r3 = this;
                    r1 = 0;
                    r3.h();
                    r0 = r3.m1127a();
                    if (r0 == 0) goto L_0x0022;
                L_0x000a:
                    r0 = r3.m1127a();
                    r0 = r4.b(r0);
                    r0 = (com.facebook.timeline.refresher.protocol.FetchProfileRefresherGraphQLModels.TimelineCoverPhotoUriQueryModel.CoverPhotoModel.PhotoModel.ImageModel) r0;
                    r2 = r3.m1127a();
                    if (r2 == r0) goto L_0x0022;
                L_0x001a:
                    r1 = com.facebook.graphql.modelutil.ModelHelper.a(r1, r3);
                    r1 = (com.facebook.timeline.refresher.protocol.FetchProfileRefresherGraphQLModels.TimelineCoverPhotoUriQueryModel.CoverPhotoModel.PhotoModel) r1;
                    r1.f1090d = r0;
                L_0x0022:
                    r3.i();
                    if (r1 != 0) goto L_0x0028;
                L_0x0027:
                    return r3;
                L_0x0028:
                    r3 = r1;
                    goto L_0x0027;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.timeline.refresher.protocol.FetchProfileRefresherGraphQLModels.TimelineCoverPhotoUriQueryModel.CoverPhotoModel.PhotoModel.a(com.facebook.graphql.visitor.GraphQLModelMutatingVisitor):com.facebook.graphql.visitor.GraphQLVisitableModel");
                }

                public final int m1125a(com.facebook.flatbuffers.FlatBufferBuilder r3) {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r2 = this;
                    r2.h();
                    r0 = r2.m1127a();
                    r0 = com.facebook.graphql.modelutil.ModelHelper.a(r3, r0);
                    r1 = 1;
                    r3.c(r1);
                    r1 = 0;
                    r3.b(r1, r0);
                    r2.i();
                    r0 = r3.d();
                    return r0;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.timeline.refresher.protocol.FetchProfileRefresherGraphQLModels.TimelineCoverPhotoUriQueryModel.CoverPhotoModel.PhotoModel.a(com.facebook.flatbuffers.FlatBufferBuilder):int");
                }
            }

            /* compiled from: unlink_business */
            public class Serializer extends JsonSerializer<CoverPhotoModel> {
                public final void m1128a(java.lang.Object r8, com.fasterxml.jackson.core.JsonGenerator r9, com.fasterxml.jackson.databind.SerializerProvider r10) {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r7 = this;
                    r8 = (com.facebook.timeline.refresher.protocol.FetchProfileRefresherGraphQLModels.TimelineCoverPhotoUriQueryModel.CoverPhotoModel) r8;
                    r2 = 0;
                    r0 = r8.w_();
                    if (r0 != 0) goto L_0x0035;
                L_0x0009:
                    r0 = new com.facebook.flatbuffers.FlatBufferBuilder;
                    r1 = 128; // 0x80 float:1.794E-43 double:6.32E-322;
                    r0.<init>(r1);
                    r1 = r8.m1129a(r0);
                    r0.d(r1);
                    r0 = r0.e();
                    r1 = java.nio.ByteBuffer.wrap(r0);
                    r0 = 0;
                    r1.position(r0);
                    r0 = new com.facebook.flatbuffers.MutableFlatBuffer;
                    r4 = 1;
                    r3 = r2;
                    r5 = r2;
                    r0.<init>(r1, r2, r3, r4, r5);
                    r6 = r0.a;
                    r1 = r6;
                    r1 = com.facebook.flatbuffers.FlatBuffer.a(r1);
                    r8.a(r0, r1);
                L_0x0035:
                    r0 = r8.w_();
                    r1 = r8.u_();
                    com.facebook.timeline.refresher.protocol.FetchProfileRefresherGraphQLParsers.TimelineCoverPhotoUriQueryParser.CoverPhotoParser.m1170a(r0, r1, r9, r10);
                    return;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.timeline.refresher.protocol.FetchProfileRefresherGraphQLModels.TimelineCoverPhotoUriQueryModel.CoverPhotoModel.Serializer.a(java.lang.Object, com.fasterxml.jackson.core.JsonGenerator, com.fasterxml.jackson.databind.SerializerProvider):void");
                }

                static {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r0 = com.facebook.timeline.refresher.protocol.FetchProfileRefresherGraphQLModels.TimelineCoverPhotoUriQueryModel.CoverPhotoModel.class;
                    r1 = new com.facebook.timeline.refresher.protocol.FetchProfileRefresherGraphQLModels$TimelineCoverPhotoUriQueryModel$CoverPhotoModel$Serializer;
                    r1.<init>();
                    com.facebook.common.json.FbSerializerProvider.a(r0, r1);
                    return;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.timeline.refresher.protocol.FetchProfileRefresherGraphQLModels.TimelineCoverPhotoUriQueryModel.CoverPhotoModel.Serializer.<clinit>():void");
                }
            }

            public CoverPhotoModel() {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r1 = this;
                r0 = 1;
                r1.<init>(r0);
                return;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.timeline.refresher.protocol.FetchProfileRefresherGraphQLModels.TimelineCoverPhotoUriQueryModel.CoverPhotoModel.<init>():void");
            }

            @javax.annotation.Nullable
            public final com.facebook.timeline.refresher.protocol.FetchProfileRefresherGraphQLModels.TimelineCoverPhotoUriQueryModel.CoverPhotoModel.PhotoModel m1131a() {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r3 = this;
                r0 = r3.f1091d;
                r1 = 0;
                r2 = com.facebook.timeline.refresher.protocol.FetchProfileRefresherGraphQLModels.TimelineCoverPhotoUriQueryModel.CoverPhotoModel.PhotoModel.class;
                r0 = super.a(r0, r1, r2);
                r0 = (com.facebook.timeline.refresher.protocol.FetchProfileRefresherGraphQLModels.TimelineCoverPhotoUriQueryModel.CoverPhotoModel.PhotoModel) r0;
                r3.f1091d = r0;
                r0 = r3.f1091d;
                return r0;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.timeline.refresher.protocol.FetchProfileRefresherGraphQLModels.TimelineCoverPhotoUriQueryModel.CoverPhotoModel.a():com.facebook.timeline.refresher.protocol.FetchProfileRefresherGraphQLModels$TimelineCoverPhotoUriQueryModel$CoverPhotoModel$PhotoModel");
            }

            public final int jK_() {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r1 = this;
                r0 = 497264923; // 0x1da3a91b float:4.332059E-21 double:2.456815153E-315;
                return r0;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.timeline.refresher.protocol.FetchProfileRefresherGraphQLModels.TimelineCoverPhotoUriQueryModel.CoverPhotoModel.jK_():int");
            }

            public final com.facebook.graphql.visitor.GraphQLVisitableModel m1130a(com.facebook.graphql.visitor.GraphQLModelMutatingVisitor r4) {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r3 = this;
                r1 = 0;
                r3.h();
                r0 = r3.m1131a();
                if (r0 == 0) goto L_0x0022;
            L_0x000a:
                r0 = r3.m1131a();
                r0 = r4.b(r0);
                r0 = (com.facebook.timeline.refresher.protocol.FetchProfileRefresherGraphQLModels.TimelineCoverPhotoUriQueryModel.CoverPhotoModel.PhotoModel) r0;
                r2 = r3.m1131a();
                if (r2 == r0) goto L_0x0022;
            L_0x001a:
                r1 = com.facebook.graphql.modelutil.ModelHelper.a(r1, r3);
                r1 = (com.facebook.timeline.refresher.protocol.FetchProfileRefresherGraphQLModels.TimelineCoverPhotoUriQueryModel.CoverPhotoModel) r1;
                r1.f1091d = r0;
            L_0x0022:
                r3.i();
                if (r1 != 0) goto L_0x0028;
            L_0x0027:
                return r3;
            L_0x0028:
                r3 = r1;
                goto L_0x0027;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.timeline.refresher.protocol.FetchProfileRefresherGraphQLModels.TimelineCoverPhotoUriQueryModel.CoverPhotoModel.a(com.facebook.graphql.visitor.GraphQLModelMutatingVisitor):com.facebook.graphql.visitor.GraphQLVisitableModel");
            }

            public final int m1129a(com.facebook.flatbuffers.FlatBufferBuilder r3) {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r2 = this;
                r2.h();
                r0 = r2.m1131a();
                r0 = com.facebook.graphql.modelutil.ModelHelper.a(r3, r0);
                r1 = 1;
                r3.c(r1);
                r1 = 0;
                r3.b(r1, r0);
                r2.i();
                r0 = r3.d();
                return r0;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.timeline.refresher.protocol.FetchProfileRefresherGraphQLModels.TimelineCoverPhotoUriQueryModel.CoverPhotoModel.a(com.facebook.flatbuffers.FlatBufferBuilder):int");
            }
        }

        /* compiled from: unlink_business */
        public class Deserializer extends FbJsonDeserializer {
            static {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r0 = com.facebook.timeline.refresher.protocol.FetchProfileRefresherGraphQLModels.TimelineCoverPhotoUriQueryModel.class;
                r1 = new com.facebook.timeline.refresher.protocol.FetchProfileRefresherGraphQLModels$TimelineCoverPhotoUriQueryModel$Deserializer;
                r1.<init>();
                com.facebook.common.json.GlobalAutoGenDeserializerCache.a(r0, r1);
                return;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.timeline.refresher.protocol.FetchProfileRefresherGraphQLModels.TimelineCoverPhotoUriQueryModel.Deserializer.<clinit>():void");
            }

            public java.lang.Object m1132a(com.fasterxml.jackson.core.JsonParser r6, com.fasterxml.jackson.databind.DeserializationContext r7) {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r5 = this;
                r2 = com.facebook.timeline.refresher.protocol.FetchProfileRefresherGraphQLParsers.TimelineCoverPhotoUriQueryParser.m1171a(r6);
                r1 = new com.facebook.timeline.refresher.protocol.FetchProfileRefresherGraphQLModels$TimelineCoverPhotoUriQueryModel;
                r1.<init>();
                r4 = r2.a;
                r0 = r4;
                r3 = com.facebook.flatbuffers.FlatBuffer.a(r0);
                r0 = r1;
                r0 = (com.facebook.graphql.modelutil.BaseModel) r0;
                r0.a(r2, r3, r6);
                r0 = r1 instanceof com.facebook.common.json.Postprocessable;
                if (r0 == 0) goto L_0x0020;
            L_0x001a:
                r1 = (com.facebook.common.json.Postprocessable) r1;
                r1 = r1.a();
            L_0x0020:
                return r1;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.timeline.refresher.protocol.FetchProfileRefresherGraphQLModels.TimelineCoverPhotoUriQueryModel.Deserializer.a(com.fasterxml.jackson.core.JsonParser, com.fasterxml.jackson.databind.DeserializationContext):java.lang.Object");
            }
        }

        /* compiled from: unlink_business */
        public class Serializer extends JsonSerializer<TimelineCoverPhotoUriQueryModel> {
            public final void m1133a(java.lang.Object r9, com.fasterxml.jackson.core.JsonGenerator r10, com.fasterxml.jackson.databind.SerializerProvider r11) {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r8 = this;
                r9 = (com.facebook.timeline.refresher.protocol.FetchProfileRefresherGraphQLModels.TimelineCoverPhotoUriQueryModel) r9;
                r2 = 0;
                r0 = r9.w_();
                if (r0 != 0) goto L_0x0035;
            L_0x0009:
                r0 = new com.facebook.flatbuffers.FlatBufferBuilder;
                r1 = 128; // 0x80 float:1.794E-43 double:6.32E-322;
                r0.<init>(r1);
                r1 = r9.m1134a(r0);
                r0.d(r1);
                r0 = r0.e();
                r1 = java.nio.ByteBuffer.wrap(r0);
                r0 = 0;
                r1.position(r0);
                r0 = new com.facebook.flatbuffers.MutableFlatBuffer;
                r4 = 1;
                r3 = r2;
                r5 = r2;
                r0.<init>(r1, r2, r3, r4, r5);
                r6 = r0.a;
                r1 = r6;
                r1 = com.facebook.flatbuffers.FlatBuffer.a(r1);
                r9.a(r0, r1);
            L_0x0035:
                r0 = r9.w_();
                r1 = r9.u_();
                r10.f();
                r6 = 0;
                r6 = r0.g(r1, r6);
                if (r6 == 0) goto L_0x004f;
            L_0x0047:
                r7 = "cover_photo";
                r10.a(r7);
                com.facebook.timeline.refresher.protocol.FetchProfileRefresherGraphQLParsers.TimelineCoverPhotoUriQueryParser.CoverPhotoParser.m1170a(r0, r6, r10, r11);
            L_0x004f:
                r10.g();
                return;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.timeline.refresher.protocol.FetchProfileRefresherGraphQLModels.TimelineCoverPhotoUriQueryModel.Serializer.a(java.lang.Object, com.fasterxml.jackson.core.JsonGenerator, com.fasterxml.jackson.databind.SerializerProvider):void");
            }

            static {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r0 = com.facebook.timeline.refresher.protocol.FetchProfileRefresherGraphQLModels.TimelineCoverPhotoUriQueryModel.class;
                r1 = new com.facebook.timeline.refresher.protocol.FetchProfileRefresherGraphQLModels$TimelineCoverPhotoUriQueryModel$Serializer;
                r1.<init>();
                com.facebook.common.json.FbSerializerProvider.a(r0, r1);
                return;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.timeline.refresher.protocol.FetchProfileRefresherGraphQLModels.TimelineCoverPhotoUriQueryModel.Serializer.<clinit>():void");
            }
        }

        public TimelineCoverPhotoUriQueryModel() {
            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
            /*
            r1 = this;
            r0 = 1;
            r1.<init>(r0);
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.timeline.refresher.protocol.FetchProfileRefresherGraphQLModels.TimelineCoverPhotoUriQueryModel.<init>():void");
        }

        public final void m1137a(java.lang.String r1, com.facebook.graphql.visitor.ConsistencyTuple r2) {
            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
            /*
            r0 = this;
            r2.a();
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.timeline.refresher.protocol.FetchProfileRefresherGraphQLModels.TimelineCoverPhotoUriQueryModel.a(java.lang.String, com.facebook.graphql.visitor.ConsistencyTuple):void");
        }

        public final void m1138a(java.lang.String r1, java.lang.Object r2, boolean r3) {
            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
            /*
            r0 = this;
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.timeline.refresher.protocol.FetchProfileRefresherGraphQLModels.TimelineCoverPhotoUriQueryModel.a(java.lang.String, java.lang.Object, boolean):void");
        }

        @javax.annotation.Nullable
        public final com.facebook.timeline.refresher.protocol.FetchProfileRefresherGraphQLModels.TimelineCoverPhotoUriQueryModel.CoverPhotoModel m1136a() {
            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
            /*
            r3 = this;
            r0 = r3.f1092d;
            r1 = 0;
            r2 = com.facebook.timeline.refresher.protocol.FetchProfileRefresherGraphQLModels.TimelineCoverPhotoUriQueryModel.CoverPhotoModel.class;
            r0 = super.a(r0, r1, r2);
            r0 = (com.facebook.timeline.refresher.protocol.FetchProfileRefresherGraphQLModels.TimelineCoverPhotoUriQueryModel.CoverPhotoModel) r0;
            r3.f1092d = r0;
            r0 = r3.f1092d;
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.timeline.refresher.protocol.FetchProfileRefresherGraphQLModels.TimelineCoverPhotoUriQueryModel.a():com.facebook.timeline.refresher.protocol.FetchProfileRefresherGraphQLModels$TimelineCoverPhotoUriQueryModel$CoverPhotoModel");
        }

        public final int jK_() {
            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
            /*
            r1 = this;
            r0 = 2645995; // 0x285feb float:3.707829E-39 double:1.307295E-317;
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.timeline.refresher.protocol.FetchProfileRefresherGraphQLModels.TimelineCoverPhotoUriQueryModel.jK_():int");
        }

        public final com.facebook.graphql.visitor.GraphQLVisitableModel m1135a(com.facebook.graphql.visitor.GraphQLModelMutatingVisitor r4) {
            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
            /*
            r3 = this;
            r1 = 0;
            r3.h();
            r0 = r3.m1136a();
            if (r0 == 0) goto L_0x0022;
        L_0x000a:
            r0 = r3.m1136a();
            r0 = r4.b(r0);
            r0 = (com.facebook.timeline.refresher.protocol.FetchProfileRefresherGraphQLModels.TimelineCoverPhotoUriQueryModel.CoverPhotoModel) r0;
            r2 = r3.m1136a();
            if (r2 == r0) goto L_0x0022;
        L_0x001a:
            r1 = com.facebook.graphql.modelutil.ModelHelper.a(r1, r3);
            r1 = (com.facebook.timeline.refresher.protocol.FetchProfileRefresherGraphQLModels.TimelineCoverPhotoUriQueryModel) r1;
            r1.f1092d = r0;
        L_0x0022:
            r3.i();
            if (r1 != 0) goto L_0x0028;
        L_0x0027:
            return r3;
        L_0x0028:
            r3 = r1;
            goto L_0x0027;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.timeline.refresher.protocol.FetchProfileRefresherGraphQLModels.TimelineCoverPhotoUriQueryModel.a(com.facebook.graphql.visitor.GraphQLModelMutatingVisitor):com.facebook.graphql.visitor.GraphQLVisitableModel");
        }

        public final int m1134a(com.facebook.flatbuffers.FlatBufferBuilder r3) {
            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
            /*
            r2 = this;
            r2.h();
            r0 = r2.m1136a();
            r0 = com.facebook.graphql.modelutil.ModelHelper.a(r3, r0);
            r1 = 1;
            r3.c(r1);
            r1 = 0;
            r3.b(r1, r0);
            r2.i();
            r0 = r3.d();
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.timeline.refresher.protocol.FetchProfileRefresherGraphQLModels.TimelineCoverPhotoUriQueryModel.a(com.facebook.flatbuffers.FlatBufferBuilder):int");
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 522539803)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: unlink_business */
    public final class TimelineNuxQueryModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private ProfileWizardNuxFieldsModel f1093d;

        /* compiled from: unlink_business */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(TimelineNuxQueryModel.class, new Deserializer());
            }

            public Object m1139a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = TimelineNuxQueryParser.m1172a(jsonParser);
                Object timelineNuxQueryModel = new TimelineNuxQueryModel();
                ((BaseModel) timelineNuxQueryModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (timelineNuxQueryModel instanceof Postprocessable) {
                    return ((Postprocessable) timelineNuxQueryModel).a();
                }
                return timelineNuxQueryModel;
            }
        }

        /* compiled from: unlink_business */
        public class Serializer extends JsonSerializer<TimelineNuxQueryModel> {
            public final void m1140a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                TimelineNuxQueryModel timelineNuxQueryModel = (TimelineNuxQueryModel) obj;
                if (timelineNuxQueryModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(timelineNuxQueryModel.m1141a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    timelineNuxQueryModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = timelineNuxQueryModel.w_();
                int u_ = timelineNuxQueryModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("profile_wizard_nux");
                    ProfileWizardNuxFieldsParser.m1152a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(TimelineNuxQueryModel.class, new Serializer());
            }
        }

        public TimelineNuxQueryModel() {
            super(1);
        }

        @Nullable
        public final ProfileWizardNuxFieldsModel m1143a() {
            this.f1093d = (ProfileWizardNuxFieldsModel) super.a(this.f1093d, 0, ProfileWizardNuxFieldsModel.class);
            return this.f1093d;
        }

        public final int jK_() {
            return -1732764110;
        }

        public final GraphQLVisitableModel m1142a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m1143a() != null) {
                ProfileWizardNuxFieldsModel profileWizardNuxFieldsModel = (ProfileWizardNuxFieldsModel) graphQLModelMutatingVisitor.b(m1143a());
                if (m1143a() != profileWizardNuxFieldsModel) {
                    graphQLVisitableModel = (TimelineNuxQueryModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f1093d = profileWizardNuxFieldsModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m1141a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m1143a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -735811716)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: unlink_business */
    public final class TimelineRefresherQueryModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private ProfileWizardRefresherFieldsModel f1094d;

        /* compiled from: unlink_business */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(TimelineRefresherQueryModel.class, new Deserializer());
            }

            public Object m1144a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = TimelineRefresherQueryParser.m1173a(jsonParser);
                Object timelineRefresherQueryModel = new TimelineRefresherQueryModel();
                ((BaseModel) timelineRefresherQueryModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (timelineRefresherQueryModel instanceof Postprocessable) {
                    return ((Postprocessable) timelineRefresherQueryModel).a();
                }
                return timelineRefresherQueryModel;
            }
        }

        /* compiled from: unlink_business */
        public class Serializer extends JsonSerializer<TimelineRefresherQueryModel> {
            public final void m1145a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                TimelineRefresherQueryModel timelineRefresherQueryModel = (TimelineRefresherQueryModel) obj;
                if (timelineRefresherQueryModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(timelineRefresherQueryModel.m1146a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    timelineRefresherQueryModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = timelineRefresherQueryModel.w_();
                int u_ = timelineRefresherQueryModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("profile_wizard_refresher");
                    ProfileWizardRefresherFieldsParser.m1156a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(TimelineRefresherQueryModel.class, new Serializer());
            }
        }

        public TimelineRefresherQueryModel() {
            super(1);
        }

        @Nullable
        public final ProfileWizardRefresherFieldsModel m1148a() {
            this.f1094d = (ProfileWizardRefresherFieldsModel) super.a(this.f1094d, 0, ProfileWizardRefresherFieldsModel.class);
            return this.f1094d;
        }

        public final int jK_() {
            return -1732764110;
        }

        public final GraphQLVisitableModel m1147a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m1148a() != null) {
                ProfileWizardRefresherFieldsModel profileWizardRefresherFieldsModel = (ProfileWizardRefresherFieldsModel) graphQLModelMutatingVisitor.b(m1148a());
                if (m1148a() != profileWizardRefresherFieldsModel) {
                    graphQLVisitableModel = (TimelineRefresherQueryModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f1094d = profileWizardRefresherFieldsModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m1146a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m1148a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }
}
