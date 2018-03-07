package com.facebook.pages.app.data.protocol.methods.graphql;

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
import com.facebook.pages.app.data.protocol.methods.graphql.FetchPageContactParsers.FetchPageContactQueryParser;
import com.facebook.pages.app.data.protocol.methods.graphql.FetchPageContactParsers.FetchPageContactQueryParser.ProfilePictureHighResParser;
import com.facebook.pages.app.data.protocol.methods.graphql.FetchPageContactParsers.FetchPageContactQueryParser.RepresentedProfileParser;
import com.facebook.pages.app.data.protocol.methods.graphql.FetchPageContactParsers.PagesManagerContactCoverPhotoParser;
import com.facebook.pages.app.data.protocol.methods.graphql.FetchPageContactParsers.PagesManagerContactCoverPhotoParser.FocusParser;
import com.facebook.pages.app.data.protocol.methods.graphql.FetchPageContactParsers.PagesManagerContactCoverPhotoParser.PhotoParser;
import com.facebook.pages.app.data.protocol.methods.graphql.FetchPageContactParsers.PagesManagerContactCoverPhotoParser.PhotoParser.ImageLandscapeParser;
import com.facebook.pages.app.data.protocol.methods.graphql.FetchPageContactParsers.PagesManagerContactCoverPhotoParser.PhotoParser.ImagePortraitParser;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.nio.ByteBuffer;
import javax.annotation.Nullable;

/* compiled from: survey_story_tracking_data */
public class FetchPageContactModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -909975306)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: survey_story_tracking_data */
    public final class FetchPageContactQueryModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
        @Nullable
        private GraphQLObjectType f1168d;
        @Nullable
        private PagesManagerContactCoverPhotoModel f1169e;
        @Nullable
        private String f1170f;
        @Nullable
        private String f1171g;
        @Nullable
        private String f1172h;
        @Nullable
        private ProfilePictureHighResModel f1173i;
        @Nullable
        private RepresentedProfileModel f1174j;

        /* compiled from: survey_story_tracking_data */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(FetchPageContactQueryModel.class, new Deserializer());
            }

            public Object m1634a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = FetchPageContactQueryParser.m1698a(jsonParser);
                Object fetchPageContactQueryModel = new FetchPageContactQueryModel();
                ((BaseModel) fetchPageContactQueryModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (fetchPageContactQueryModel instanceof Postprocessable) {
                    return ((Postprocessable) fetchPageContactQueryModel).a();
                }
                return fetchPageContactQueryModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 842551240)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: survey_story_tracking_data */
        public final class ProfilePictureHighResModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private String f1165d;

            /* compiled from: survey_story_tracking_data */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(ProfilePictureHighResModel.class, new Deserializer());
                }

                public Object m1635a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(ProfilePictureHighResParser.m1694a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object profilePictureHighResModel = new ProfilePictureHighResModel();
                    ((BaseModel) profilePictureHighResModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (profilePictureHighResModel instanceof Postprocessable) {
                        return ((Postprocessable) profilePictureHighResModel).a();
                    }
                    return profilePictureHighResModel;
                }
            }

            /* compiled from: survey_story_tracking_data */
            public class Serializer extends JsonSerializer<ProfilePictureHighResModel> {
                public final void m1636a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    ProfilePictureHighResModel profilePictureHighResModel = (ProfilePictureHighResModel) obj;
                    if (profilePictureHighResModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(profilePictureHighResModel.m1638a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        profilePictureHighResModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    ProfilePictureHighResParser.m1695a(profilePictureHighResModel.w_(), profilePictureHighResModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(ProfilePictureHighResModel.class, new Serializer());
                }
            }

            public ProfilePictureHighResModel() {
                super(1);
            }

            @Nullable
            private String m1637a() {
                this.f1165d = super.a(this.f1165d, 0);
                return this.f1165d;
            }

            public final int jK_() {
                return 70760763;
            }

            public final GraphQLVisitableModel m1639a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m1638a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m1637a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, b);
                i();
                return flatBufferBuilder.d();
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -1787905591)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: survey_story_tracking_data */
        public final class RepresentedProfileModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
            @Nullable
            private GraphQLObjectType f1166d;
            @Nullable
            private String f1167e;

            /* compiled from: survey_story_tracking_data */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(RepresentedProfileModel.class, new Deserializer());
                }

                public Object m1640a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(RepresentedProfileParser.m1696a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object representedProfileModel = new RepresentedProfileModel();
                    ((BaseModel) representedProfileModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (representedProfileModel instanceof Postprocessable) {
                        return ((Postprocessable) representedProfileModel).a();
                    }
                    return representedProfileModel;
                }
            }

            /* compiled from: survey_story_tracking_data */
            public class Serializer extends JsonSerializer<RepresentedProfileModel> {
                public final void m1641a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    RepresentedProfileModel representedProfileModel = (RepresentedProfileModel) obj;
                    if (representedProfileModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(representedProfileModel.m1644a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        representedProfileModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    RepresentedProfileParser.m1697a(representedProfileModel.w_(), representedProfileModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(RepresentedProfileModel.class, new Serializer());
                }
            }

            public RepresentedProfileModel() {
                super(2);
            }

            public final void m1647a(String str, ConsistencyTuple consistencyTuple) {
                consistencyTuple.a();
            }

            public final void m1648a(String str, Object obj, boolean z) {
            }

            @Nullable
            private GraphQLObjectType m1642j() {
                if (this.b != null && this.f1166d == null) {
                    this.f1166d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
                }
                return this.f1166d;
            }

            @Nullable
            private String m1643k() {
                this.f1167e = super.a(this.f1167e, 1);
                return this.f1167e;
            }

            @Nullable
            public final String m1646a() {
                return m1643k();
            }

            public final int jK_() {
                return 63093205;
            }

            public final GraphQLVisitableModel m1645a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m1644a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m1642j());
                int b = flatBufferBuilder.b(m1643k());
                flatBufferBuilder.c(2);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.b(1, b);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: survey_story_tracking_data */
        public class Serializer extends JsonSerializer<FetchPageContactQueryModel> {
            public final void m1649a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                FetchPageContactQueryModel fetchPageContactQueryModel = (FetchPageContactQueryModel) obj;
                if (fetchPageContactQueryModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(fetchPageContactQueryModel.m1657a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    fetchPageContactQueryModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = fetchPageContactQueryModel.w_();
                int u_ = fetchPageContactQueryModel.u_();
                jsonGenerator.f();
                if (mutableFlatBuffer.g(u_, 0) != 0) {
                    jsonGenerator.a("__type__");
                    SerializerHelpers.b(mutableFlatBuffer, u_, 0, jsonGenerator);
                }
                int g = mutableFlatBuffer.g(u_, 1);
                if (g != 0) {
                    jsonGenerator.a("cover_photo");
                    PagesManagerContactCoverPhotoParser.m1708a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                if (mutableFlatBuffer.g(u_, 2) != 0) {
                    jsonGenerator.a("graph_api_write_id");
                    jsonGenerator.b(mutableFlatBuffer.c(u_, 2));
                }
                if (mutableFlatBuffer.g(u_, 3) != 0) {
                    jsonGenerator.a("id");
                    jsonGenerator.b(mutableFlatBuffer.c(u_, 3));
                }
                if (mutableFlatBuffer.g(u_, 4) != 0) {
                    jsonGenerator.a("name");
                    jsonGenerator.b(mutableFlatBuffer.c(u_, 4));
                }
                g = mutableFlatBuffer.g(u_, 5);
                if (g != 0) {
                    jsonGenerator.a("profilePictureHighRes");
                    ProfilePictureHighResParser.m1695a(mutableFlatBuffer, g, jsonGenerator);
                }
                g = mutableFlatBuffer.g(u_, 6);
                if (g != 0) {
                    jsonGenerator.a("represented_profile");
                    RepresentedProfileParser.m1697a(mutableFlatBuffer, g, jsonGenerator);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(FetchPageContactQueryModel.class, new Serializer());
            }
        }

        public FetchPageContactQueryModel() {
            super(7);
        }

        public final void m1660a(String str, ConsistencyTuple consistencyTuple) {
            consistencyTuple.a();
        }

        public final void m1661a(String str, Object obj, boolean z) {
        }

        @Nullable
        private GraphQLObjectType m1650j() {
            if (this.b != null && this.f1168d == null) {
                this.f1168d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
            }
            return this.f1168d;
        }

        @Nullable
        private PagesManagerContactCoverPhotoModel m1651k() {
            this.f1169e = (PagesManagerContactCoverPhotoModel) super.a(this.f1169e, 1, PagesManagerContactCoverPhotoModel.class);
            return this.f1169e;
        }

        @Nullable
        private String m1652l() {
            this.f1170f = super.a(this.f1170f, 2);
            return this.f1170f;
        }

        @Nullable
        private String m1653m() {
            this.f1171g = super.a(this.f1171g, 3);
            return this.f1171g;
        }

        @Nullable
        private String m1654n() {
            this.f1172h = super.a(this.f1172h, 4);
            return this.f1172h;
        }

        @Nullable
        private ProfilePictureHighResModel m1655o() {
            this.f1173i = (ProfilePictureHighResModel) super.a(this.f1173i, 5, ProfilePictureHighResModel.class);
            return this.f1173i;
        }

        @Nullable
        private RepresentedProfileModel m1656p() {
            this.f1174j = (RepresentedProfileModel) super.a(this.f1174j, 6, RepresentedProfileModel.class);
            return this.f1174j;
        }

        @Nullable
        public final String m1659a() {
            return m1653m();
        }

        public final int jK_() {
            return 2433570;
        }

        public final GraphQLVisitableModel m1658a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m1651k() != null) {
                PagesManagerContactCoverPhotoModel pagesManagerContactCoverPhotoModel = (PagesManagerContactCoverPhotoModel) graphQLModelMutatingVisitor.b(m1651k());
                if (m1651k() != pagesManagerContactCoverPhotoModel) {
                    graphQLVisitableModel = (FetchPageContactQueryModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f1169e = pagesManagerContactCoverPhotoModel;
                }
            }
            if (m1655o() != null) {
                ProfilePictureHighResModel profilePictureHighResModel = (ProfilePictureHighResModel) graphQLModelMutatingVisitor.b(m1655o());
                if (m1655o() != profilePictureHighResModel) {
                    graphQLVisitableModel = (FetchPageContactQueryModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f1173i = profilePictureHighResModel;
                }
            }
            if (m1656p() != null) {
                RepresentedProfileModel representedProfileModel = (RepresentedProfileModel) graphQLModelMutatingVisitor.b(m1656p());
                if (m1656p() != representedProfileModel) {
                    graphQLVisitableModel = (FetchPageContactQueryModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f1174j = representedProfileModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m1657a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m1650j());
            int a2 = ModelHelper.a(flatBufferBuilder, m1651k());
            int b = flatBufferBuilder.b(m1652l());
            int b2 = flatBufferBuilder.b(m1653m());
            int b3 = flatBufferBuilder.b(m1654n());
            int a3 = ModelHelper.a(flatBufferBuilder, m1655o());
            int a4 = ModelHelper.a(flatBufferBuilder, m1656p());
            flatBufferBuilder.c(7);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, a2);
            flatBufferBuilder.b(2, b);
            flatBufferBuilder.b(3, b2);
            flatBufferBuilder.b(4, b3);
            flatBufferBuilder.b(5, a3);
            flatBufferBuilder.b(6, a4);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 1181488994)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: survey_story_tracking_data */
    public final class PagesManagerContactCoverPhotoModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private FocusModel f1187d;
        @Nullable
        private PhotoModel f1188e;

        /* compiled from: survey_story_tracking_data */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(PagesManagerContactCoverPhotoModel.class, new Deserializer());
            }

            public Object m1662a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(PagesManagerContactCoverPhotoParser.m1707a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object pagesManagerContactCoverPhotoModel = new PagesManagerContactCoverPhotoModel();
                ((BaseModel) pagesManagerContactCoverPhotoModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (pagesManagerContactCoverPhotoModel instanceof Postprocessable) {
                    return ((Postprocessable) pagesManagerContactCoverPhotoModel).a();
                }
                return pagesManagerContactCoverPhotoModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -496435496)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: survey_story_tracking_data */
        public final class FocusModel extends BaseModel implements GraphQLVisitableModel {
            private double f1175d;
            private double f1176e;

            /* compiled from: survey_story_tracking_data */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(FocusModel.class, new Deserializer());
                }

                public Object m1663a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(FocusParser.m1699a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object focusModel = new FocusModel();
                    ((BaseModel) focusModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (focusModel instanceof Postprocessable) {
                        return ((Postprocessable) focusModel).a();
                    }
                    return focusModel;
                }
            }

            /* compiled from: survey_story_tracking_data */
            public class Serializer extends JsonSerializer<FocusModel> {
                public final void m1664a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    FocusModel focusModel = (FocusModel) obj;
                    if (focusModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(focusModel.m1665a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        focusModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    FocusParser.m1700a(focusModel.w_(), focusModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(FocusModel.class, new Serializer());
                }
            }

            public FocusModel() {
                super(2);
            }

            public final int jK_() {
                return 82530482;
            }

            public final GraphQLVisitableModel m1666a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m1665a(FlatBufferBuilder flatBufferBuilder) {
                h();
                flatBufferBuilder.c(2);
                flatBufferBuilder.a(0, this.f1175d, 0.0d);
                flatBufferBuilder.a(1, this.f1176e, 0.0d);
                i();
                return flatBufferBuilder.d();
            }

            public final void m1667a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                super.a(mutableFlatBuffer, i, obj);
                this.f1175d = mutableFlatBuffer.a(i, 0, 0.0d);
                this.f1176e = mutableFlatBuffer.a(i, 1, 0.0d);
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -2054641744)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: survey_story_tracking_data */
        public final class PhotoModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableModel {
            @Nullable
            private String f1183d;
            @Nullable
            private ImageLandscapeModel f1184e;
            @Nullable
            private ImagePortraitModel f1185f;
            @Nullable
            private String f1186g;

            /* compiled from: survey_story_tracking_data */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(PhotoModel.class, new Deserializer());
                }

                public Object m1668a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(PhotoParser.m1705a(jsonParser, flatBufferBuilder));
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

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = 729935302)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: survey_story_tracking_data */
            public final class ImageLandscapeModel extends BaseModel implements GraphQLVisitableModel {
                private int f1177d;
                @Nullable
                private String f1178e;
                private int f1179f;

                /* compiled from: survey_story_tracking_data */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(ImageLandscapeModel.class, new Deserializer());
                    }

                    public Object m1669a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(ImageLandscapeParser.m1701a(jsonParser, flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        mutableFlatBuffer.a(4, Boolean.valueOf(true));
                        MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                        Object imageLandscapeModel = new ImageLandscapeModel();
                        ((BaseModel) imageLandscapeModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                        if (imageLandscapeModel instanceof Postprocessable) {
                            return ((Postprocessable) imageLandscapeModel).a();
                        }
                        return imageLandscapeModel;
                    }
                }

                /* compiled from: survey_story_tracking_data */
                public class Serializer extends JsonSerializer<ImageLandscapeModel> {
                    public final void m1670a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        ImageLandscapeModel imageLandscapeModel = (ImageLandscapeModel) obj;
                        if (imageLandscapeModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(imageLandscapeModel.m1672a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            imageLandscapeModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        ImageLandscapeParser.m1702a(imageLandscapeModel.w_(), imageLandscapeModel.u_(), jsonGenerator);
                    }

                    static {
                        FbSerializerProvider.a(ImageLandscapeModel.class, new Serializer());
                    }
                }

                public ImageLandscapeModel() {
                    super(3);
                }

                @Nullable
                private String m1671a() {
                    this.f1178e = super.a(this.f1178e, 1);
                    return this.f1178e;
                }

                public final int jK_() {
                    return 70760763;
                }

                public final GraphQLVisitableModel m1673a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    h();
                    i();
                    return this;
                }

                public final int m1672a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int b = flatBufferBuilder.b(m1671a());
                    flatBufferBuilder.c(3);
                    flatBufferBuilder.a(0, this.f1177d, 0);
                    flatBufferBuilder.b(1, b);
                    flatBufferBuilder.a(2, this.f1179f, 0);
                    i();
                    return flatBufferBuilder.d();
                }

                public final void m1674a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                    super.a(mutableFlatBuffer, i, obj);
                    this.f1177d = mutableFlatBuffer.a(i, 0, 0);
                    this.f1179f = mutableFlatBuffer.a(i, 2, 0);
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = 729935302)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: survey_story_tracking_data */
            public final class ImagePortraitModel extends BaseModel implements GraphQLVisitableModel {
                private int f1180d;
                @Nullable
                private String f1181e;
                private int f1182f;

                /* compiled from: survey_story_tracking_data */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(ImagePortraitModel.class, new Deserializer());
                    }

                    public Object m1675a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(ImagePortraitParser.m1703a(jsonParser, flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        mutableFlatBuffer.a(4, Boolean.valueOf(true));
                        MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                        Object imagePortraitModel = new ImagePortraitModel();
                        ((BaseModel) imagePortraitModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                        if (imagePortraitModel instanceof Postprocessable) {
                            return ((Postprocessable) imagePortraitModel).a();
                        }
                        return imagePortraitModel;
                    }
                }

                /* compiled from: survey_story_tracking_data */
                public class Serializer extends JsonSerializer<ImagePortraitModel> {
                    public final void m1676a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        ImagePortraitModel imagePortraitModel = (ImagePortraitModel) obj;
                        if (imagePortraitModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(imagePortraitModel.m1678a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            imagePortraitModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        ImagePortraitParser.m1704a(imagePortraitModel.w_(), imagePortraitModel.u_(), jsonGenerator);
                    }

                    static {
                        FbSerializerProvider.a(ImagePortraitModel.class, new Serializer());
                    }
                }

                public ImagePortraitModel() {
                    super(3);
                }

                @Nullable
                private String m1677a() {
                    this.f1181e = super.a(this.f1181e, 1);
                    return this.f1181e;
                }

                public final int jK_() {
                    return 70760763;
                }

                public final GraphQLVisitableModel m1679a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    h();
                    i();
                    return this;
                }

                public final int m1678a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int b = flatBufferBuilder.b(m1677a());
                    flatBufferBuilder.c(3);
                    flatBufferBuilder.a(0, this.f1180d, 0);
                    flatBufferBuilder.b(1, b);
                    flatBufferBuilder.a(2, this.f1182f, 0);
                    i();
                    return flatBufferBuilder.d();
                }

                public final void m1680a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                    super.a(mutableFlatBuffer, i, obj);
                    this.f1180d = mutableFlatBuffer.a(i, 0, 0);
                    this.f1182f = mutableFlatBuffer.a(i, 2, 0);
                }
            }

            /* compiled from: survey_story_tracking_data */
            public class Serializer extends JsonSerializer<PhotoModel> {
                public final void m1681a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    PhotoModel photoModel = (PhotoModel) obj;
                    if (photoModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(photoModel.m1686a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        photoModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    PhotoParser.m1706a(photoModel.w_(), photoModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(PhotoModel.class, new Serializer());
                }
            }

            public PhotoModel() {
                super(4);
            }

            @Nullable
            private String m1682j() {
                this.f1183d = super.a(this.f1183d, 0);
                return this.f1183d;
            }

            @Nullable
            private ImageLandscapeModel m1683k() {
                this.f1184e = (ImageLandscapeModel) super.a(this.f1184e, 1, ImageLandscapeModel.class);
                return this.f1184e;
            }

            @Nullable
            private ImagePortraitModel m1684l() {
                this.f1185f = (ImagePortraitModel) super.a(this.f1185f, 2, ImagePortraitModel.class);
                return this.f1185f;
            }

            @Nullable
            private String m1685m() {
                this.f1186g = super.a(this.f1186g, 3);
                return this.f1186g;
            }

            @Nullable
            public final String m1688a() {
                return m1682j();
            }

            public final int jK_() {
                return 77090322;
            }

            public final GraphQLVisitableModel m1687a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m1683k() != null) {
                    ImageLandscapeModel imageLandscapeModel = (ImageLandscapeModel) graphQLModelMutatingVisitor.b(m1683k());
                    if (m1683k() != imageLandscapeModel) {
                        graphQLVisitableModel = (PhotoModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f1184e = imageLandscapeModel;
                    }
                }
                if (m1684l() != null) {
                    ImagePortraitModel imagePortraitModel = (ImagePortraitModel) graphQLModelMutatingVisitor.b(m1684l());
                    if (m1684l() != imagePortraitModel) {
                        graphQLVisitableModel = (PhotoModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f1185f = imagePortraitModel;
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m1686a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m1682j());
                int a = ModelHelper.a(flatBufferBuilder, m1683k());
                int a2 = ModelHelper.a(flatBufferBuilder, m1684l());
                int b2 = flatBufferBuilder.b(m1685m());
                flatBufferBuilder.c(4);
                flatBufferBuilder.b(0, b);
                flatBufferBuilder.b(1, a);
                flatBufferBuilder.b(2, a2);
                flatBufferBuilder.b(3, b2);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: survey_story_tracking_data */
        public class Serializer extends JsonSerializer<PagesManagerContactCoverPhotoModel> {
            public final void m1689a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                PagesManagerContactCoverPhotoModel pagesManagerContactCoverPhotoModel = (PagesManagerContactCoverPhotoModel) obj;
                if (pagesManagerContactCoverPhotoModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(pagesManagerContactCoverPhotoModel.m1692a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    pagesManagerContactCoverPhotoModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                PagesManagerContactCoverPhotoParser.m1708a(pagesManagerContactCoverPhotoModel.w_(), pagesManagerContactCoverPhotoModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(PagesManagerContactCoverPhotoModel.class, new Serializer());
            }
        }

        public PagesManagerContactCoverPhotoModel() {
            super(2);
        }

        @Nullable
        private FocusModel m1690a() {
            this.f1187d = (FocusModel) super.a(this.f1187d, 0, FocusModel.class);
            return this.f1187d;
        }

        @Nullable
        private PhotoModel m1691j() {
            this.f1188e = (PhotoModel) super.a(this.f1188e, 1, PhotoModel.class);
            return this.f1188e;
        }

        public final int jK_() {
            return 497264923;
        }

        public final GraphQLVisitableModel m1693a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m1690a() != null) {
                FocusModel focusModel = (FocusModel) graphQLModelMutatingVisitor.b(m1690a());
                if (m1690a() != focusModel) {
                    graphQLVisitableModel = (PagesManagerContactCoverPhotoModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f1187d = focusModel;
                }
            }
            if (m1691j() != null) {
                PhotoModel photoModel = (PhotoModel) graphQLModelMutatingVisitor.b(m1691j());
                if (m1691j() != photoModel) {
                    graphQLVisitableModel = (PagesManagerContactCoverPhotoModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f1188e = photoModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m1692a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m1690a());
            int a2 = ModelHelper.a(flatBufferBuilder, m1691j());
            flatBufferBuilder.c(2);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, a2);
            i();
            return flatBufferBuilder.d();
        }
    }
}
