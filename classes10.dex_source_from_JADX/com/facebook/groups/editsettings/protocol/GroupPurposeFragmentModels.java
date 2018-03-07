package com.facebook.groups.editsettings.protocol;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbSerializerProvider;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.FragmentModelWithoutBridge;
import com.facebook.flatbuffers.ModelWithFlatBufferFormatHash;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.enums.GraphQLGroupPurposeType;
import com.facebook.graphql.enums.GraphQLGroupVisibility;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.ModelHelper;
import com.facebook.graphql.querybuilder.common.CommonGraphQLInterfaces.DefaultImageFields;
import com.facebook.graphql.querybuilder.common.CommonGraphQLModels.DefaultImageFieldsModel;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.facebook.groups.editsettings.protocol.GroupPurposeFragmentParsers.DefaultCoverPhotoParser;
import com.facebook.groups.editsettings.protocol.GroupPurposeFragmentParsers.DefaultCoverPhotoParser.PhotoParser;
import com.facebook.groups.editsettings.protocol.GroupPurposeFragmentParsers.GroupPurposeParser;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.nio.ByteBuffer;
import javax.annotation.Nullable;

/* compiled from: Unable to generate key for attachment encryption  */
public class GroupPurposeFragmentModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 1609170459)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: Unable to generate key for attachment encryption  */
    public final class DefaultCoverPhotoModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private PhotoModel f21755d;

        /* compiled from: Unable to generate key for attachment encryption  */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(DefaultCoverPhotoModel.class, new Deserializer());
            }

            public Object m22844a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(DefaultCoverPhotoParser.m22867a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object defaultCoverPhotoModel = new DefaultCoverPhotoModel();
                ((BaseModel) defaultCoverPhotoModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (defaultCoverPhotoModel instanceof Postprocessable) {
                    return ((Postprocessable) defaultCoverPhotoModel).a();
                }
                return defaultCoverPhotoModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -1236209140)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: Unable to generate key for attachment encryption  */
        public final class PhotoModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private DefaultImageFieldsModel f21754d;

            /* compiled from: Unable to generate key for attachment encryption  */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(PhotoModel.class, new Deserializer());
                }

                public Object m22845a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(PhotoParser.m22865a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object photoModel = new PhotoModel();
                    ((BaseModel) photoModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (photoModel instanceof Postprocessable) {
                        return ((Postprocessable) photoModel).a();
                    }
                    return photoModel;
                }
            }

            /* compiled from: Unable to generate key for attachment encryption  */
            public class Serializer extends JsonSerializer<PhotoModel> {
                public final void m22846a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    PhotoModel photoModel = (PhotoModel) obj;
                    if (photoModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(photoModel.m22848a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        photoModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    PhotoParser.m22866a(photoModel.w_(), photoModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(PhotoModel.class, new Serializer());
                }
            }

            public PhotoModel() {
                super(1);
            }

            @Nullable
            private DefaultImageFieldsModel m22847a() {
                this.f21754d = (DefaultImageFieldsModel) super.a(this.f21754d, 0, DefaultImageFieldsModel.class);
                return this.f21754d;
            }

            public final int jK_() {
                return 77090322;
            }

            public final GraphQLVisitableModel m22849a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m22847a() != null) {
                    DefaultImageFieldsModel defaultImageFieldsModel = (DefaultImageFieldsModel) graphQLModelMutatingVisitor.b(m22847a());
                    if (m22847a() != defaultImageFieldsModel) {
                        graphQLVisitableModel = (PhotoModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f21754d = defaultImageFieldsModel;
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m22848a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m22847a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, a);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: Unable to generate key for attachment encryption  */
        public class Serializer extends JsonSerializer<DefaultCoverPhotoModel> {
            public final void m22850a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                DefaultCoverPhotoModel defaultCoverPhotoModel = (DefaultCoverPhotoModel) obj;
                if (defaultCoverPhotoModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(defaultCoverPhotoModel.m22852a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    defaultCoverPhotoModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                DefaultCoverPhotoParser.m22868a(defaultCoverPhotoModel.w_(), defaultCoverPhotoModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(DefaultCoverPhotoModel.class, new Serializer());
            }
        }

        public DefaultCoverPhotoModel() {
            super(1);
        }

        @Nullable
        private PhotoModel m22851a() {
            this.f21755d = (PhotoModel) super.a(this.f21755d, 0, PhotoModel.class);
            return this.f21755d;
        }

        public final int jK_() {
            return 497264923;
        }

        public final GraphQLVisitableModel m22853a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m22851a() != null) {
                PhotoModel photoModel = (PhotoModel) graphQLModelMutatingVisitor.b(m22851a());
                if (m22851a() != photoModel) {
                    graphQLVisitableModel = (DefaultCoverPhotoModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f21755d = photoModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m22852a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m22851a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 1478756391)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: Unable to generate key for attachment encryption  */
    public final class GroupPurposeModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private DefaultCoverPhotoModel f21756d;
        @Nullable
        private String f21757e;
        @Nullable
        private GraphQLGroupPurposeType f21758f;
        @Nullable
        private DefaultImageFieldsModel f21759g;
        @Nullable
        private String f21760h;
        @Nullable
        private GraphQLGroupVisibility f21761i;

        /* compiled from: Unable to generate key for attachment encryption  */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(GroupPurposeModel.class, new Deserializer());
            }

            public Object m22854a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(GroupPurposeParser.m22871b(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object groupPurposeModel = new GroupPurposeModel();
                ((BaseModel) groupPurposeModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (groupPurposeModel instanceof Postprocessable) {
                    return ((Postprocessable) groupPurposeModel).a();
                }
                return groupPurposeModel;
            }
        }

        /* compiled from: Unable to generate key for attachment encryption  */
        public class Serializer extends JsonSerializer<GroupPurposeModel> {
            public final void m22855a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                GroupPurposeModel groupPurposeModel = (GroupPurposeModel) obj;
                if (groupPurposeModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(groupPurposeModel.m22859a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    groupPurposeModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                GroupPurposeParser.m22872b(groupPurposeModel.w_(), groupPurposeModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(GroupPurposeModel.class, new Serializer());
            }
        }

        @Nullable
        public final /* synthetic */ DefaultImageFields m22860a() {
            return m22864k();
        }

        public GroupPurposeModel() {
            super(6);
        }

        @Nullable
        private DefaultCoverPhotoModel m22856l() {
            this.f21756d = (DefaultCoverPhotoModel) super.a(this.f21756d, 0, DefaultCoverPhotoModel.class);
            return this.f21756d;
        }

        @Nullable
        private String m22857m() {
            this.f21757e = super.a(this.f21757e, 1);
            return this.f21757e;
        }

        @Nullable
        public final GraphQLGroupPurposeType m22863j() {
            this.f21758f = (GraphQLGroupPurposeType) super.b(this.f21758f, 2, GraphQLGroupPurposeType.class, GraphQLGroupPurposeType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
            return this.f21758f;
        }

        @Nullable
        public final DefaultImageFieldsModel m22864k() {
            this.f21759g = (DefaultImageFieldsModel) super.a(this.f21759g, 3, DefaultImageFieldsModel.class);
            return this.f21759g;
        }

        @Nullable
        public final String m22862b() {
            this.f21760h = super.a(this.f21760h, 4);
            return this.f21760h;
        }

        @Nullable
        private GraphQLGroupVisibility m22858n() {
            this.f21761i = (GraphQLGroupVisibility) super.b(this.f21761i, 5, GraphQLGroupVisibility.class, GraphQLGroupVisibility.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
            return this.f21761i;
        }

        public final int jK_() {
            return -405572161;
        }

        public final GraphQLVisitableModel m22861a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m22856l() != null) {
                DefaultCoverPhotoModel defaultCoverPhotoModel = (DefaultCoverPhotoModel) graphQLModelMutatingVisitor.b(m22856l());
                if (m22856l() != defaultCoverPhotoModel) {
                    graphQLVisitableModel = (GroupPurposeModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f21756d = defaultCoverPhotoModel;
                }
            }
            if (m22864k() != null) {
                DefaultImageFieldsModel defaultImageFieldsModel = (DefaultImageFieldsModel) graphQLModelMutatingVisitor.b(m22864k());
                if (m22864k() != defaultImageFieldsModel) {
                    graphQLVisitableModel = (GroupPurposeModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f21759g = defaultImageFieldsModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m22859a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m22856l());
            int b = flatBufferBuilder.b(m22857m());
            int a2 = flatBufferBuilder.a(m22863j());
            int a3 = ModelHelper.a(flatBufferBuilder, m22864k());
            int b2 = flatBufferBuilder.b(m22862b());
            int a4 = flatBufferBuilder.a(m22858n());
            flatBufferBuilder.c(6);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, b);
            flatBufferBuilder.b(2, a2);
            flatBufferBuilder.b(3, a3);
            flatBufferBuilder.b(4, b2);
            flatBufferBuilder.b(5, a4);
            i();
            return flatBufferBuilder.d();
        }
    }
}
