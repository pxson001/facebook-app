package com.facebook.nearby.v2.network;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbSerializerProvider;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.FragmentModelWithBridge;
import com.facebook.flatbuffers.FragmentModelWithoutBridge;
import com.facebook.flatbuffers.ModelWithFlatBufferFormatHash;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.enums.GraphQLObjectType;
import com.facebook.graphql.enums.GraphQLPageCategoryType;
import com.facebook.graphql.enums.GraphQLPageOpenHoursDisplayDecisionEnum;
import com.facebook.graphql.enums.GraphQLPageSuperCategoryType;
import com.facebook.graphql.enums.GraphQLPermanentlyClosedStatus;
import com.facebook.graphql.enums.GraphQLPlaceType;
import com.facebook.graphql.enums.GraphQLRedirectionReason;
import com.facebook.graphql.enums.GraphQLSavedState;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.ModelHelper;
import com.facebook.graphql.querybuilder.common.CommonGraphQL2Interfaces.DefaultVect2Fields;
import com.facebook.graphql.querybuilder.common.CommonGraphQL2Models.DefaultVect2FieldsModel;
import com.facebook.graphql.querybuilder.common.CommonGraphQLInterfaces.DefaultLocationFields;
import com.facebook.graphql.visitor.ConsistencyTuple;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLPersistableNode;
import com.facebook.graphql.visitor.GraphQLVisitableConsistentModel;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.facebook.nearby.v2.network.BrowseNearbyPlacesGraphQLInterfaces.FullAlbumFragment;
import com.facebook.nearby.v2.network.BrowseNearbyPlacesGraphQLInterfaces.NearbyPagePlaceInfoFragment;
import com.facebook.nearby.v2.network.BrowseNearbyPlacesGraphQLInterfaces.NearbyPlacesFriendsWhoVisitedFragment;
import com.facebook.nearby.v2.network.BrowseNearbyPlacesGraphQLInterfaces.NearbyPlacesHugeResultCellPageInformationFragment;
import com.facebook.nearby.v2.network.BrowseNearbyPlacesGraphQLInterfaces.NearbyPlacesNewBrowsePaginationInfo;
import com.facebook.nearby.v2.network.BrowseNearbyPlacesGraphQLInterfaces.NearbyPlacesPageProfilePhoto;
import com.facebook.nearby.v2.network.BrowseNearbyPlacesGraphQLInterfaces.PageTWEFragment;
import com.facebook.nearby.v2.network.BrowseNearbyPlacesGraphQLInterfaces.PhotoWithoutSizedImagesFragment;
import com.facebook.nearby.v2.network.BrowseNearbyPlacesGraphQLParsers.BrowseNearbyPlacesFullImageFragmentParser;
import com.facebook.nearby.v2.network.BrowseNearbyPlacesGraphQLParsers.FullAlbumFragmentParser;
import com.facebook.nearby.v2.network.BrowseNearbyPlacesGraphQLParsers.FullAlbumFragmentParser.TitleParser;
import com.facebook.nearby.v2.network.BrowseNearbyPlacesGraphQLParsers.GeoRectangleFragmentParser;
import com.facebook.nearby.v2.network.BrowseNearbyPlacesGraphQLParsers.NearbyPagePlaceInfoFragmentParser;
import com.facebook.nearby.v2.network.BrowseNearbyPlacesGraphQLParsers.NearbyPagePlaceInfoFragmentParser.AddressParser;
import com.facebook.nearby.v2.network.BrowseNearbyPlacesGraphQLParsers.NearbyPagePlaceInfoFragmentParser.HoursParser;
import com.facebook.nearby.v2.network.BrowseNearbyPlacesGraphQLParsers.NearbyPagePlaceInfoFragmentParser.LocationParser;
import com.facebook.nearby.v2.network.BrowseNearbyPlacesGraphQLParsers.NearbyPagePlaceInfoFragmentParser.OverallStarRatingParser;
import com.facebook.nearby.v2.network.BrowseNearbyPlacesGraphQLParsers.NearbyPagePlaceInfoFragmentParser.PageLikersParser;
import com.facebook.nearby.v2.network.BrowseNearbyPlacesGraphQLParsers.NearbyPagePlaceInfoFragmentParser.PageVisitsParser;
import com.facebook.nearby.v2.network.BrowseNearbyPlacesGraphQLParsers.NearbyPagePlaceInfoFragmentParser.PlaceOpenStatusParser;
import com.facebook.nearby.v2.network.BrowseNearbyPlacesGraphQLParsers.NearbyPagePlaceInfoFragmentParser.RatersParser;
import com.facebook.nearby.v2.network.BrowseNearbyPlacesGraphQLParsers.NearbyPlacesFriendsWhoVisitedFragmentParser;
import com.facebook.nearby.v2.network.BrowseNearbyPlacesGraphQLParsers.NearbyPlacesFriendsWhoVisitedFragmentParser.FriendsWhoVisitedParser;
import com.facebook.nearby.v2.network.BrowseNearbyPlacesGraphQLParsers.NearbyPlacesFriendsWhoVisitedFragmentParser.FriendsWhoVisitedParser.EdgesParser;
import com.facebook.nearby.v2.network.BrowseNearbyPlacesGraphQLParsers.NearbyPlacesFriendsWhoVisitedFragmentParser.FriendsWhoVisitedParser.EdgesParser.NodeParser;
import com.facebook.nearby.v2.network.BrowseNearbyPlacesGraphQLParsers.NearbyPlacesFriendsWhoVisitedFragmentParser.FriendsWhoVisitedParser.SocialContextParser;
import com.facebook.nearby.v2.network.BrowseNearbyPlacesGraphQLParsers.NearbyPlacesFriendsWhoVisitedFragmentParser.FriendsWhoVisitedParser.SocialContextParser.RangesParser;
import com.facebook.nearby.v2.network.BrowseNearbyPlacesGraphQLParsers.NearbyPlacesHugeResultCellPageInformationFragmentParser;
import com.facebook.nearby.v2.network.BrowseNearbyPlacesGraphQLParsers.NearbyPlacesHugeResultsSearchQueryV2Parser;
import com.facebook.nearby.v2.network.BrowseNearbyPlacesGraphQLParsers.NearbyPlacesNewBrowsePaginationInfoParser;
import com.facebook.nearby.v2.network.BrowseNearbyPlacesGraphQLParsers.NearbyPlacesNewBrowsePaginationInfoParser.PageInfoParser;
import com.facebook.nearby.v2.network.BrowseNearbyPlacesGraphQLParsers.NearbyPlacesNewBrowsePlaceHugeResultsConnectionFragmentParser;
import com.facebook.nearby.v2.network.BrowseNearbyPlacesGraphQLParsers.NearbyPlacesOldBrowseOldResultConnectionFragmentParser;
import com.facebook.nearby.v2.network.BrowseNearbyPlacesGraphQLParsers.NearbyPlacesOldBrowseOldResultsSearchQueryParser;
import com.facebook.nearby.v2.network.BrowseNearbyPlacesGraphQLParsers.NearbyPlacesOldFlowFriendsWhoVisitedFragmentParser;
import com.facebook.nearby.v2.network.BrowseNearbyPlacesGraphQLParsers.NearbyPlacesPageProfilePhotoParser;
import com.facebook.nearby.v2.network.BrowseNearbyPlacesGraphQLParsers.NearbyPlacesPageProfilePhotoParser.ProfilePhotoParser;
import com.facebook.nearby.v2.network.BrowseNearbyPlacesGraphQLParsers.NearbyRecommendationsConnectionFragmentParser;
import com.facebook.nearby.v2.network.BrowseNearbyPlacesGraphQLParsers.PageTWEFragmentParser;
import com.facebook.nearby.v2.network.BrowseNearbyPlacesGraphQLParsers.PageTWEFragmentParser.RedirectionInfoParser;
import com.facebook.nearby.v2.network.BrowseNearbyPlacesGraphQLParsers.Photo320FragmentParser;
import com.facebook.nearby.v2.network.BrowseNearbyPlacesGraphQLParsers.PhotoWithoutSizedImagesFragmentParser;
import com.facebook.nearby.v2.network.BrowseNearbyPlacesGraphQLParsers.PhotoWithoutSizedImagesFragmentParser.AlbumParser;
import com.facebook.reviews.protocol.graphql.ReviewFragmentsInterfaces.ReviewWithCreationFields;
import com.facebook.reviews.protocol.graphql.ReviewFragmentsModels.ReviewBasicFieldsModel.ValueModel;
import com.facebook.reviews.protocol.graphql.ReviewFragmentsModels.ReviewCreationFieldsModel.CreatorModel;
import com.facebook.reviews.protocol.graphql.ReviewFragmentsModels.ReviewCreationFieldsModel.StoryModel;
import com.facebook.reviews.protocol.graphql.ReviewFragmentsModels.SelectedPrivacyOptionFieldsModel;
import com.facebook.richdocument.model.graphql.RichDocumentGraphQlModels.FBTextWithEntitiesModel;
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

/* compiled from: device_family */
public class BrowseNearbyPlacesGraphQLModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -1098422116)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: device_family */
    public final class BrowseNearbyPlacesFullImageFragmentModel extends BaseModel implements GraphQLVisitableModel {
        private int f15317d;
        @Nullable
        private String f15318e;
        private double f15319f;
        @Nullable
        private String f15320g;
        private int f15321h;

        /* compiled from: device_family */
        public final class Builder {
            public int f15312a;
            @Nullable
            public String f15313b;
            public double f15314c;
            @Nullable
            public String f15315d;
            public int f15316e;
        }

        /* compiled from: device_family */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(BrowseNearbyPlacesFullImageFragmentModel.class, new Deserializer());
            }

            public Object m17798a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(BrowseNearbyPlacesFullImageFragmentParser.m18324a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object browseNearbyPlacesFullImageFragmentModel = new BrowseNearbyPlacesFullImageFragmentModel();
                ((BaseModel) browseNearbyPlacesFullImageFragmentModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (browseNearbyPlacesFullImageFragmentModel instanceof Postprocessable) {
                    return ((Postprocessable) browseNearbyPlacesFullImageFragmentModel).a();
                }
                return browseNearbyPlacesFullImageFragmentModel;
            }
        }

        /* compiled from: device_family */
        public class Serializer extends JsonSerializer<BrowseNearbyPlacesFullImageFragmentModel> {
            public final void m17799a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                BrowseNearbyPlacesFullImageFragmentModel browseNearbyPlacesFullImageFragmentModel = (BrowseNearbyPlacesFullImageFragmentModel) obj;
                if (browseNearbyPlacesFullImageFragmentModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(browseNearbyPlacesFullImageFragmentModel.m17802a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    browseNearbyPlacesFullImageFragmentModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                BrowseNearbyPlacesFullImageFragmentParser.m18325a(browseNearbyPlacesFullImageFragmentModel.w_(), browseNearbyPlacesFullImageFragmentModel.u_(), jsonGenerator);
            }

            static {
                FbSerializerProvider.a(BrowseNearbyPlacesFullImageFragmentModel.class, new Serializer());
            }
        }

        public BrowseNearbyPlacesFullImageFragmentModel() {
            super(5);
        }

        public BrowseNearbyPlacesFullImageFragmentModel(MutableFlatBuffer mutableFlatBuffer) {
            super(5);
            a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
        }

        public final int m17801a() {
            a(0, 0);
            return this.f15317d;
        }

        @Nullable
        public final String m17805b() {
            this.f15318e = super.a(this.f15318e, 1);
            return this.f15318e;
        }

        public final double m17806c() {
            a(0, 2);
            return this.f15319f;
        }

        @Nullable
        public final String m17807d() {
            this.f15320g = super.a(this.f15320g, 3);
            return this.f15320g;
        }

        public final int jX_() {
            a(0, 4);
            return this.f15321h;
        }

        public static BrowseNearbyPlacesFullImageFragmentModel m17800a(BrowseNearbyPlacesFullImageFragmentModel browseNearbyPlacesFullImageFragmentModel) {
            if (browseNearbyPlacesFullImageFragmentModel == null) {
                return null;
            }
            if (browseNearbyPlacesFullImageFragmentModel instanceof BrowseNearbyPlacesFullImageFragmentModel) {
                return browseNearbyPlacesFullImageFragmentModel;
            }
            Builder builder = new Builder();
            builder.f15312a = browseNearbyPlacesFullImageFragmentModel.m17801a();
            builder.f15313b = browseNearbyPlacesFullImageFragmentModel.m17805b();
            builder.f15314c = browseNearbyPlacesFullImageFragmentModel.m17806c();
            builder.f15315d = browseNearbyPlacesFullImageFragmentModel.m17807d();
            builder.f15316e = browseNearbyPlacesFullImageFragmentModel.jX_();
            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
            int b = flatBufferBuilder.b(builder.f15313b);
            int b2 = flatBufferBuilder.b(builder.f15315d);
            flatBufferBuilder.c(5);
            flatBufferBuilder.a(0, builder.f15312a, 0);
            flatBufferBuilder.b(1, b);
            flatBufferBuilder.a(2, builder.f15314c, 0.0d);
            flatBufferBuilder.b(3, b2);
            flatBufferBuilder.a(4, builder.f15316e, 0);
            flatBufferBuilder.d(flatBufferBuilder.d());
            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
            wrap.position(0);
            return new BrowseNearbyPlacesFullImageFragmentModel(new MutableFlatBuffer(wrap, null, null, true, null));
        }

        public final int jK_() {
            return 70760763;
        }

        public final GraphQLVisitableModel m17803a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            h();
            i();
            return this;
        }

        public final int m17802a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int b = flatBufferBuilder.b(m17805b());
            int b2 = flatBufferBuilder.b(m17807d());
            flatBufferBuilder.c(5);
            flatBufferBuilder.a(0, this.f15317d, 0);
            flatBufferBuilder.b(1, b);
            flatBufferBuilder.a(2, this.f15319f, 0.0d);
            flatBufferBuilder.b(3, b2);
            flatBufferBuilder.a(4, this.f15321h, 0);
            i();
            return flatBufferBuilder.d();
        }

        public final void m17804a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
            super.a(mutableFlatBuffer, i, obj);
            this.f15317d = mutableFlatBuffer.a(i, 0, 0);
            this.f15319f = mutableFlatBuffer.a(i, 2, 0.0d);
            this.f15321h = mutableFlatBuffer.a(i, 4, 0);
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 2017887533)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: device_family */
    public final class FullAlbumFragmentModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableModel, FullAlbumFragment {
        @Nullable
        private String f15324d;
        @Nullable
        private TitleModel f15325e;

        /* compiled from: device_family */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(FullAlbumFragmentModel.class, new Deserializer());
            }

            public Object m17808a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = FullAlbumFragmentParser.m18328a(jsonParser);
                Object fullAlbumFragmentModel = new FullAlbumFragmentModel();
                ((BaseModel) fullAlbumFragmentModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (fullAlbumFragmentModel instanceof Postprocessable) {
                    return ((Postprocessable) fullAlbumFragmentModel).a();
                }
                return fullAlbumFragmentModel;
            }
        }

        /* compiled from: device_family */
        public class Serializer extends JsonSerializer<FullAlbumFragmentModel> {
            public final void m17809a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                FullAlbumFragmentModel fullAlbumFragmentModel = (FullAlbumFragmentModel) obj;
                if (fullAlbumFragmentModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(fullAlbumFragmentModel.m17818a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    fullAlbumFragmentModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = fullAlbumFragmentModel.w_();
                int u_ = fullAlbumFragmentModel.u_();
                jsonGenerator.f();
                if (mutableFlatBuffer.g(u_, 0) != 0) {
                    jsonGenerator.a("id");
                    jsonGenerator.b(mutableFlatBuffer.c(u_, 0));
                }
                int g = mutableFlatBuffer.g(u_, 1);
                if (g != 0) {
                    jsonGenerator.a("title");
                    TitleParser.m18327a(mutableFlatBuffer, g, jsonGenerator);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(FullAlbumFragmentModel.class, new Serializer());
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -1352864475)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: device_family */
        public final class TitleModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private String f15323d;

            /* compiled from: device_family */
            public final class Builder {
                @Nullable
                public String f15322a;
            }

            /* compiled from: device_family */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(TitleModel.class, new Deserializer());
                }

                public Object m17810a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(TitleParser.m18326a(jsonParser, flatBufferBuilder));
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

            /* compiled from: device_family */
            public class Serializer extends JsonSerializer<TitleModel> {
                public final void m17811a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    TitleModel titleModel = (TitleModel) obj;
                    if (titleModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(titleModel.m17813a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        titleModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    TitleParser.m18327a(titleModel.w_(), titleModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(TitleModel.class, new Serializer());
                }
            }

            public TitleModel() {
                super(1);
            }

            public TitleModel(MutableFlatBuffer mutableFlatBuffer) {
                super(1);
                a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
            }

            @Nullable
            public final String m17815a() {
                this.f15323d = super.a(this.f15323d, 0);
                return this.f15323d;
            }

            public static TitleModel m17812a(TitleModel titleModel) {
                if (titleModel == null) {
                    return null;
                }
                if (titleModel instanceof TitleModel) {
                    return titleModel;
                }
                Builder builder = new Builder();
                builder.f15322a = titleModel.m17815a();
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                int b = flatBufferBuilder.b(builder.f15322a);
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, b);
                flatBufferBuilder.d(flatBufferBuilder.d());
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                return new TitleModel(new MutableFlatBuffer(wrap, null, null, true, null));
            }

            public final int jK_() {
                return -1919764332;
            }

            public final GraphQLVisitableModel m17814a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m17813a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m17815a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, b);
                i();
                return flatBufferBuilder.d();
            }
        }

        public FullAlbumFragmentModel() {
            super(2);
        }

        @Nullable
        private String m17816j() {
            this.f15324d = super.a(this.f15324d, 0);
            return this.f15324d;
        }

        @Nullable
        private TitleModel m17817k() {
            this.f15325e = (TitleModel) super.a(this.f15325e, 1, TitleModel.class);
            return this.f15325e;
        }

        @Nullable
        public final String m17820a() {
            return m17816j();
        }

        public final int jK_() {
            return 63344207;
        }

        public final GraphQLVisitableModel m17819a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m17817k() != null) {
                TitleModel titleModel = (TitleModel) graphQLModelMutatingVisitor.b(m17817k());
                if (m17817k() != titleModel) {
                    graphQLVisitableModel = (FullAlbumFragmentModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f15325e = titleModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m17818a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int b = flatBufferBuilder.b(m17816j());
            int a = ModelHelper.a(flatBufferBuilder, m17817k());
            flatBufferBuilder.c(2);
            flatBufferBuilder.b(0, b);
            flatBufferBuilder.b(1, a);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -1076074038)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: device_family */
    public final class GeoRectangleFragmentModel extends BaseModel implements GraphQLVisitableModel {
        private double f15330d;
        private double f15331e;
        private double f15332f;
        private double f15333g;

        /* compiled from: device_family */
        public final class Builder {
            public double f15326a;
            public double f15327b;
            public double f15328c;
            public double f15329d;

            public final GeoRectangleFragmentModel m17821a() {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.c(4);
                flatBufferBuilder.a(0, this.f15326a, 0.0d);
                flatBufferBuilder.a(1, this.f15327b, 0.0d);
                flatBufferBuilder.a(2, this.f15328c, 0.0d);
                flatBufferBuilder.a(3, this.f15329d, 0.0d);
                flatBufferBuilder.d(flatBufferBuilder.d());
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                return new GeoRectangleFragmentModel(new MutableFlatBuffer(wrap, null, null, true, null));
            }
        }

        /* compiled from: device_family */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(GeoRectangleFragmentModel.class, new Deserializer());
            }

            public Object m17822a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(GeoRectangleFragmentParser.m18329a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object geoRectangleFragmentModel = new GeoRectangleFragmentModel();
                ((BaseModel) geoRectangleFragmentModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (geoRectangleFragmentModel instanceof Postprocessable) {
                    return ((Postprocessable) geoRectangleFragmentModel).a();
                }
                return geoRectangleFragmentModel;
            }
        }

        /* compiled from: device_family */
        public class Serializer extends JsonSerializer<GeoRectangleFragmentModel> {
            public final void m17823a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                GeoRectangleFragmentModel geoRectangleFragmentModel = (GeoRectangleFragmentModel) obj;
                if (geoRectangleFragmentModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(geoRectangleFragmentModel.m17826a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    geoRectangleFragmentModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                GeoRectangleFragmentParser.m18330a(geoRectangleFragmentModel.w_(), geoRectangleFragmentModel.u_(), jsonGenerator);
            }

            static {
                FbSerializerProvider.a(GeoRectangleFragmentModel.class, new Serializer());
            }
        }

        public GeoRectangleFragmentModel() {
            super(4);
        }

        public GeoRectangleFragmentModel(MutableFlatBuffer mutableFlatBuffer) {
            super(4);
            a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
        }

        public final double m17825a() {
            a(0, 0);
            return this.f15330d;
        }

        public final double m17829b() {
            a(0, 1);
            return this.f15331e;
        }

        public final double m17830c() {
            a(0, 2);
            return this.f15332f;
        }

        public final double m17831d() {
            a(0, 3);
            return this.f15333g;
        }

        public static GeoRectangleFragmentModel m17824a(GeoRectangleFragmentModel geoRectangleFragmentModel) {
            if (geoRectangleFragmentModel == null) {
                return null;
            }
            if (geoRectangleFragmentModel instanceof GeoRectangleFragmentModel) {
                return geoRectangleFragmentModel;
            }
            Builder builder = new Builder();
            builder.f15326a = geoRectangleFragmentModel.m17825a();
            builder.f15327b = geoRectangleFragmentModel.m17829b();
            builder.f15328c = geoRectangleFragmentModel.m17830c();
            builder.f15329d = geoRectangleFragmentModel.m17831d();
            return builder.m17821a();
        }

        public final int jK_() {
            return -2036384450;
        }

        public final GraphQLVisitableModel m17827a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            h();
            i();
            return this;
        }

        public final int m17826a(FlatBufferBuilder flatBufferBuilder) {
            h();
            flatBufferBuilder.c(4);
            flatBufferBuilder.a(0, this.f15330d, 0.0d);
            flatBufferBuilder.a(1, this.f15331e, 0.0d);
            flatBufferBuilder.a(2, this.f15332f, 0.0d);
            flatBufferBuilder.a(3, this.f15333g, 0.0d);
            i();
            return flatBufferBuilder.d();
        }

        public final void m17828a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
            super.a(mutableFlatBuffer, i, obj);
            this.f15330d = mutableFlatBuffer.a(i, 0, 0.0d);
            this.f15331e = mutableFlatBuffer.a(i, 1, 0.0d);
            this.f15332f = mutableFlatBuffer.a(i, 2, 0.0d);
            this.f15333g = mutableFlatBuffer.a(i, 3, 0.0d);
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -1680739313)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: device_family */
    public final class NearbyPagePlaceInfoFragmentModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel, NearbyPagePlaceInfoFragment {
        @Nullable
        private RatersModel f15362A;
        @Nullable
        private List<RedirectionInfoModel> f15363B;
        @Nullable
        private List<String> f15364C;
        private boolean f15365D;
        @Nullable
        private GraphQLPageSuperCategoryType f15366E;
        @Nullable
        private List<String> f15367F;
        @Nullable
        private GraphQLSavedState f15368G;
        @Nullable
        private AddressModel f15369d;
        private boolean f15370e;
        private boolean f15371f;
        @Nullable
        private List<String> f15372g;
        @Nullable
        private GraphQLPageCategoryType f15373h;
        private boolean f15374i;
        private boolean f15375j;
        @Nullable
        private List<HoursModel> f15376k;
        @Nullable
        private String f15377l;
        private boolean f15378m;
        @Nullable
        private LocationModel f15379n;
        @Nullable
        private String f15380o;
        @Nullable
        private OverallStarRatingModel f15381p;
        @Nullable
        private PageLikersModel f15382q;
        @Nullable
        private PageVisitsModel f15383r;
        @Nullable
        private GraphQLPermanentlyClosedStatus f15384s;
        @Nullable
        private PlaceOpenStatusModel f15385t;
        @Nullable
        private GraphQLPageOpenHoursDisplayDecisionEnum f15386u;
        @Nullable
        private GraphQLPlaceType f15387v;
        @Nullable
        private String f15388w;
        @Nullable
        private BrowseNearbyPlacesFullImageFragmentModel f15389x;
        @Nullable
        private BrowseNearbyPlacesFullImageFragmentModel f15390y;
        private boolean f15391z;

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -1492488211)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: device_family */
        public final class AddressModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private String f15336d;
            @Nullable
            private String f15337e;

            /* compiled from: device_family */
            public final class Builder {
                @Nullable
                public String f15334a;
                @Nullable
                public String f15335b;
            }

            /* compiled from: device_family */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(AddressModel.class, new Deserializer());
                }

                public Object m17832a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(AddressParser.m18331a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object addressModel = new AddressModel();
                    ((BaseModel) addressModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (addressModel instanceof Postprocessable) {
                        return ((Postprocessable) addressModel).a();
                    }
                    return addressModel;
                }
            }

            /* compiled from: device_family */
            public class Serializer extends JsonSerializer<AddressModel> {
                public final void m17833a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    AddressModel addressModel = (AddressModel) obj;
                    if (addressModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(addressModel.m17835a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        addressModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    AddressParser.m18332a(addressModel.w_(), addressModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(AddressModel.class, new Serializer());
                }
            }

            public AddressModel() {
                super(2);
            }

            public AddressModel(MutableFlatBuffer mutableFlatBuffer) {
                super(2);
                a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
            }

            @Nullable
            public final String m17837a() {
                this.f15336d = super.a(this.f15336d, 0);
                return this.f15336d;
            }

            @Nullable
            public final String m17838b() {
                this.f15337e = super.a(this.f15337e, 1);
                return this.f15337e;
            }

            public static AddressModel m17834a(AddressModel addressModel) {
                if (addressModel == null) {
                    return null;
                }
                if (addressModel instanceof AddressModel) {
                    return addressModel;
                }
                Builder builder = new Builder();
                builder.f15334a = addressModel.m17837a();
                builder.f15335b = addressModel.m17838b();
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                int b = flatBufferBuilder.b(builder.f15334a);
                int b2 = flatBufferBuilder.b(builder.f15335b);
                flatBufferBuilder.c(2);
                flatBufferBuilder.b(0, b);
                flatBufferBuilder.b(1, b2);
                flatBufferBuilder.d(flatBufferBuilder.d());
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                return new AddressModel(new MutableFlatBuffer(wrap, null, null, true, null));
            }

            public final int jK_() {
                return 799251025;
            }

            public final GraphQLVisitableModel m17836a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m17835a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m17837a());
                int b2 = flatBufferBuilder.b(m17838b());
                flatBufferBuilder.c(2);
                flatBufferBuilder.b(0, b);
                flatBufferBuilder.b(1, b2);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: device_family */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(NearbyPagePlaceInfoFragmentModel.class, new Deserializer());
            }

            public Object m17839a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(NearbyPagePlaceInfoFragmentParser.m18349a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object nearbyPagePlaceInfoFragmentModel = new NearbyPagePlaceInfoFragmentModel();
                ((BaseModel) nearbyPagePlaceInfoFragmentModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (nearbyPagePlaceInfoFragmentModel instanceof Postprocessable) {
                    return ((Postprocessable) nearbyPagePlaceInfoFragmentModel).a();
                }
                return nearbyPagePlaceInfoFragmentModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 1244528557)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: device_family */
        public final class HoursModel extends BaseModel implements GraphQLVisitableModel {
            private long f15340d;
            private long f15341e;

            /* compiled from: device_family */
            public final class Builder {
                public long f15338a;
                public long f15339b;

                public final HoursModel m17840a() {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.c(2);
                    flatBufferBuilder.a(0, this.f15338a, 0);
                    flatBufferBuilder.a(1, this.f15339b, 0);
                    flatBufferBuilder.d(flatBufferBuilder.d());
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    return new HoursModel(new MutableFlatBuffer(wrap, null, null, true, null));
                }
            }

            /* compiled from: device_family */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(HoursModel.class, new Deserializer());
                }

                public Object m17841a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(HoursParser.m18336b(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object hoursModel = new HoursModel();
                    ((BaseModel) hoursModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (hoursModel instanceof Postprocessable) {
                        return ((Postprocessable) hoursModel).a();
                    }
                    return hoursModel;
                }
            }

            /* compiled from: device_family */
            public class Serializer extends JsonSerializer<HoursModel> {
                public final void m17842a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    HoursModel hoursModel = (HoursModel) obj;
                    if (hoursModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(hoursModel.m17844a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        hoursModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    HoursParser.m18334a(hoursModel.w_(), hoursModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(HoursModel.class, new Serializer());
                }
            }

            public HoursModel() {
                super(2);
            }

            public HoursModel(MutableFlatBuffer mutableFlatBuffer) {
                super(2);
                a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
            }

            public final long m17845a() {
                a(0, 0);
                return this.f15340d;
            }

            public final long m17848b() {
                a(0, 1);
                return this.f15341e;
            }

            public static HoursModel m17843a(HoursModel hoursModel) {
                if (hoursModel == null) {
                    return null;
                }
                if (hoursModel instanceof HoursModel) {
                    return hoursModel;
                }
                Builder builder = new Builder();
                builder.f15338a = hoursModel.m17845a();
                builder.f15339b = hoursModel.m17848b();
                return builder.m17840a();
            }

            public final int jK_() {
                return 2028064336;
            }

            public final GraphQLVisitableModel m17846a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m17844a(FlatBufferBuilder flatBufferBuilder) {
                h();
                flatBufferBuilder.c(2);
                flatBufferBuilder.a(0, this.f15340d, 0);
                flatBufferBuilder.a(1, this.f15341e, 0);
                i();
                return flatBufferBuilder.d();
            }

            public final void m17847a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                super.a(mutableFlatBuffer, i, obj);
                this.f15340d = mutableFlatBuffer.a(i, 0, 0);
                this.f15341e = mutableFlatBuffer.a(i, 1, 0);
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -529014945)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: device_family */
        public final class LocationModel extends BaseModel implements DefaultLocationFields, GraphQLVisitableModel {
            private double f15345d;
            private double f15346e;
            @Nullable
            private String f15347f;

            /* compiled from: device_family */
            public final class Builder {
                public double f15342a;
                public double f15343b;
                @Nullable
                public String f15344c;

                public final LocationModel m17849a() {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    int b = flatBufferBuilder.b(this.f15344c);
                    flatBufferBuilder.c(3);
                    flatBufferBuilder.a(0, this.f15342a, 0.0d);
                    flatBufferBuilder.a(1, this.f15343b, 0.0d);
                    flatBufferBuilder.b(2, b);
                    flatBufferBuilder.d(flatBufferBuilder.d());
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    return new LocationModel(new MutableFlatBuffer(wrap, null, null, true, null));
                }
            }

            /* compiled from: device_family */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(LocationModel.class, new Deserializer());
                }

                public Object m17850a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(LocationParser.m18337a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object locationModel = new LocationModel();
                    ((BaseModel) locationModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (locationModel instanceof Postprocessable) {
                        return ((Postprocessable) locationModel).a();
                    }
                    return locationModel;
                }
            }

            /* compiled from: device_family */
            public class Serializer extends JsonSerializer<LocationModel> {
                public final void m17851a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    LocationModel locationModel = (LocationModel) obj;
                    if (locationModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(locationModel.m17854a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        locationModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    LocationParser.m18338a(locationModel.w_(), locationModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(LocationModel.class, new Serializer());
                }
            }

            public LocationModel() {
                super(3);
            }

            public LocationModel(MutableFlatBuffer mutableFlatBuffer) {
                super(3);
                a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
            }

            public final double m17853a() {
                a(0, 0);
                return this.f15345d;
            }

            public final double m17857b() {
                a(0, 1);
                return this.f15346e;
            }

            @Nullable
            public final String m17858c() {
                this.f15347f = super.a(this.f15347f, 2);
                return this.f15347f;
            }

            public static LocationModel m17852a(LocationModel locationModel) {
                if (locationModel == null) {
                    return null;
                }
                if (locationModel instanceof LocationModel) {
                    return locationModel;
                }
                Builder builder = new Builder();
                builder.f15342a = locationModel.m17853a();
                builder.f15343b = locationModel.m17857b();
                builder.f15344c = locationModel.m17858c();
                return builder.m17849a();
            }

            public final int jK_() {
                return 1965687765;
            }

            public final GraphQLVisitableModel m17855a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m17854a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m17858c());
                flatBufferBuilder.c(3);
                flatBufferBuilder.a(0, this.f15345d, 0.0d);
                flatBufferBuilder.a(1, this.f15346e, 0.0d);
                flatBufferBuilder.b(2, b);
                i();
                return flatBufferBuilder.d();
            }

            public final void m17856a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                super.a(mutableFlatBuffer, i, obj);
                this.f15345d = mutableFlatBuffer.a(i, 0, 0.0d);
                this.f15346e = mutableFlatBuffer.a(i, 1, 0.0d);
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 1671776255)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: device_family */
        public final class OverallStarRatingModel extends BaseModel implements GraphQLVisitableModel {
            private int f15351d;
            private int f15352e;
            private double f15353f;

            /* compiled from: device_family */
            public final class Builder {
                public int f15348a;
                public int f15349b;
                public double f15350c;
            }

            /* compiled from: device_family */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(OverallStarRatingModel.class, new Deserializer());
                }

                public Object m17859a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(OverallStarRatingParser.m18339a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object overallStarRatingModel = new OverallStarRatingModel();
                    ((BaseModel) overallStarRatingModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (overallStarRatingModel instanceof Postprocessable) {
                        return ((Postprocessable) overallStarRatingModel).a();
                    }
                    return overallStarRatingModel;
                }
            }

            /* compiled from: device_family */
            public class Serializer extends JsonSerializer<OverallStarRatingModel> {
                public final void m17860a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    OverallStarRatingModel overallStarRatingModel = (OverallStarRatingModel) obj;
                    if (overallStarRatingModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(overallStarRatingModel.m17863a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        overallStarRatingModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    OverallStarRatingParser.m18340a(overallStarRatingModel.w_(), overallStarRatingModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(OverallStarRatingModel.class, new Serializer());
                }
            }

            public OverallStarRatingModel() {
                super(3);
            }

            public OverallStarRatingModel(MutableFlatBuffer mutableFlatBuffer) {
                super(3);
                a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
            }

            public final int m17862a() {
                a(0, 0);
                return this.f15351d;
            }

            public final int m17866b() {
                a(0, 1);
                return this.f15352e;
            }

            public final double m17867c() {
                a(0, 2);
                return this.f15353f;
            }

            public static OverallStarRatingModel m17861a(OverallStarRatingModel overallStarRatingModel) {
                if (overallStarRatingModel == null) {
                    return null;
                }
                if (overallStarRatingModel instanceof OverallStarRatingModel) {
                    return overallStarRatingModel;
                }
                Builder builder = new Builder();
                builder.f15348a = overallStarRatingModel.m17862a();
                builder.f15349b = overallStarRatingModel.m17866b();
                builder.f15350c = overallStarRatingModel.m17867c();
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.c(3);
                flatBufferBuilder.a(0, builder.f15348a, 0);
                flatBufferBuilder.a(1, builder.f15349b, 0);
                flatBufferBuilder.a(2, builder.f15350c, 0.0d);
                flatBufferBuilder.d(flatBufferBuilder.d());
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                return new OverallStarRatingModel(new MutableFlatBuffer(wrap, null, null, true, null));
            }

            public final int jK_() {
                return -1854235203;
            }

            public final GraphQLVisitableModel m17864a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m17863a(FlatBufferBuilder flatBufferBuilder) {
                h();
                flatBufferBuilder.c(3);
                flatBufferBuilder.a(0, this.f15351d, 0);
                flatBufferBuilder.a(1, this.f15352e, 0);
                flatBufferBuilder.a(2, this.f15353f, 0.0d);
                i();
                return flatBufferBuilder.d();
            }

            public final void m17865a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                super.a(mutableFlatBuffer, i, obj);
                this.f15351d = mutableFlatBuffer.a(i, 0, 0);
                this.f15352e = mutableFlatBuffer.a(i, 1, 0);
                this.f15353f = mutableFlatBuffer.a(i, 2, 0.0d);
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -1723990064)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: device_family */
        public final class PageLikersModel extends BaseModel implements GraphQLVisitableModel {
            private int f15355d;

            /* compiled from: device_family */
            public final class Builder {
                public int f15354a;
            }

            /* compiled from: device_family */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(PageLikersModel.class, new Deserializer());
                }

                public Object m17868a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(PageLikersParser.m18341a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object pageLikersModel = new PageLikersModel();
                    ((BaseModel) pageLikersModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (pageLikersModel instanceof Postprocessable) {
                        return ((Postprocessable) pageLikersModel).a();
                    }
                    return pageLikersModel;
                }
            }

            /* compiled from: device_family */
            public class Serializer extends JsonSerializer<PageLikersModel> {
                public final void m17869a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    PageLikersModel pageLikersModel = (PageLikersModel) obj;
                    if (pageLikersModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(pageLikersModel.m17872a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        pageLikersModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    PageLikersParser.m18342a(pageLikersModel.w_(), pageLikersModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(PageLikersModel.class, new Serializer());
                }
            }

            public PageLikersModel() {
                super(1);
            }

            public PageLikersModel(MutableFlatBuffer mutableFlatBuffer) {
                super(1);
                a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
            }

            public final int m17871a() {
                a(0, 0);
                return this.f15355d;
            }

            public static PageLikersModel m17870a(PageLikersModel pageLikersModel) {
                if (pageLikersModel == null) {
                    return null;
                }
                if (pageLikersModel instanceof PageLikersModel) {
                    return pageLikersModel;
                }
                Builder builder = new Builder();
                builder.f15354a = pageLikersModel.m17871a();
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.c(1);
                flatBufferBuilder.a(0, builder.f15354a, 0);
                flatBufferBuilder.d(flatBufferBuilder.d());
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                return new PageLikersModel(new MutableFlatBuffer(wrap, null, null, true, null));
            }

            public final int jK_() {
                return 637021669;
            }

            public final GraphQLVisitableModel m17873a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m17872a(FlatBufferBuilder flatBufferBuilder) {
                h();
                flatBufferBuilder.c(1);
                flatBufferBuilder.a(0, this.f15355d, 0);
                i();
                return flatBufferBuilder.d();
            }

            public final void m17874a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                super.a(mutableFlatBuffer, i, obj);
                this.f15355d = mutableFlatBuffer.a(i, 0, 0);
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -1723990064)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: device_family */
        public final class PageVisitsModel extends BaseModel implements GraphQLVisitableModel {
            private int f15357d;

            /* compiled from: device_family */
            public final class Builder {
                public int f15356a;
            }

            /* compiled from: device_family */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(PageVisitsModel.class, new Deserializer());
                }

                public Object m17875a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(PageVisitsParser.m18343a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object pageVisitsModel = new PageVisitsModel();
                    ((BaseModel) pageVisitsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (pageVisitsModel instanceof Postprocessable) {
                        return ((Postprocessable) pageVisitsModel).a();
                    }
                    return pageVisitsModel;
                }
            }

            /* compiled from: device_family */
            public class Serializer extends JsonSerializer<PageVisitsModel> {
                public final void m17876a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    PageVisitsModel pageVisitsModel = (PageVisitsModel) obj;
                    if (pageVisitsModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(pageVisitsModel.m17879a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        pageVisitsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    PageVisitsParser.m18344a(pageVisitsModel.w_(), pageVisitsModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(PageVisitsModel.class, new Serializer());
                }
            }

            public PageVisitsModel() {
                super(1);
            }

            public PageVisitsModel(MutableFlatBuffer mutableFlatBuffer) {
                super(1);
                a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
            }

            public final int m17878a() {
                a(0, 0);
                return this.f15357d;
            }

            public static PageVisitsModel m17877a(PageVisitsModel pageVisitsModel) {
                if (pageVisitsModel == null) {
                    return null;
                }
                if (pageVisitsModel instanceof PageVisitsModel) {
                    return pageVisitsModel;
                }
                Builder builder = new Builder();
                builder.f15356a = pageVisitsModel.m17878a();
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.c(1);
                flatBufferBuilder.a(0, builder.f15356a, 0);
                flatBufferBuilder.d(flatBufferBuilder.d());
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                return new PageVisitsModel(new MutableFlatBuffer(wrap, null, null, true, null));
            }

            public final int jK_() {
                return -838301099;
            }

            public final GraphQLVisitableModel m17880a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m17879a(FlatBufferBuilder flatBufferBuilder) {
                h();
                flatBufferBuilder.c(1);
                flatBufferBuilder.a(0, this.f15357d, 0);
                i();
                return flatBufferBuilder.d();
            }

            public final void m17881a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                super.a(mutableFlatBuffer, i, obj);
                this.f15357d = mutableFlatBuffer.a(i, 0, 0);
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -1352864475)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: device_family */
        public final class PlaceOpenStatusModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private String f15359d;

            /* compiled from: device_family */
            public final class Builder {
                @Nullable
                public String f15358a;
            }

            /* compiled from: device_family */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(PlaceOpenStatusModel.class, new Deserializer());
                }

                public Object m17882a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(PlaceOpenStatusParser.m18345a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object placeOpenStatusModel = new PlaceOpenStatusModel();
                    ((BaseModel) placeOpenStatusModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (placeOpenStatusModel instanceof Postprocessable) {
                        return ((Postprocessable) placeOpenStatusModel).a();
                    }
                    return placeOpenStatusModel;
                }
            }

            /* compiled from: device_family */
            public class Serializer extends JsonSerializer<PlaceOpenStatusModel> {
                public final void m17883a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    PlaceOpenStatusModel placeOpenStatusModel = (PlaceOpenStatusModel) obj;
                    if (placeOpenStatusModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(placeOpenStatusModel.m17885a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        placeOpenStatusModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    PlaceOpenStatusParser.m18346a(placeOpenStatusModel.w_(), placeOpenStatusModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(PlaceOpenStatusModel.class, new Serializer());
                }
            }

            public PlaceOpenStatusModel() {
                super(1);
            }

            public PlaceOpenStatusModel(MutableFlatBuffer mutableFlatBuffer) {
                super(1);
                a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
            }

            @Nullable
            public final String m17887a() {
                this.f15359d = super.a(this.f15359d, 0);
                return this.f15359d;
            }

            public static PlaceOpenStatusModel m17884a(PlaceOpenStatusModel placeOpenStatusModel) {
                if (placeOpenStatusModel == null) {
                    return null;
                }
                if (placeOpenStatusModel instanceof PlaceOpenStatusModel) {
                    return placeOpenStatusModel;
                }
                Builder builder = new Builder();
                builder.f15358a = placeOpenStatusModel.m17887a();
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                int b = flatBufferBuilder.b(builder.f15358a);
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, b);
                flatBufferBuilder.d(flatBufferBuilder.d());
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                return new PlaceOpenStatusModel(new MutableFlatBuffer(wrap, null, null, true, null));
            }

            public final int jK_() {
                return -1919764332;
            }

            public final GraphQLVisitableModel m17886a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m17885a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m17887a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, b);
                i();
                return flatBufferBuilder.d();
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -1723990064)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: device_family */
        public final class RatersModel extends BaseModel implements GraphQLVisitableModel {
            private int f15361d;

            /* compiled from: device_family */
            public final class Builder {
                public int f15360a;
            }

            /* compiled from: device_family */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(RatersModel.class, new Deserializer());
                }

                public Object m17888a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(RatersParser.m18347a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object ratersModel = new RatersModel();
                    ((BaseModel) ratersModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (ratersModel instanceof Postprocessable) {
                        return ((Postprocessable) ratersModel).a();
                    }
                    return ratersModel;
                }
            }

            /* compiled from: device_family */
            public class Serializer extends JsonSerializer<RatersModel> {
                public final void m17889a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    RatersModel ratersModel = (RatersModel) obj;
                    if (ratersModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(ratersModel.m17892a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        ratersModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    RatersParser.m18348a(ratersModel.w_(), ratersModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(RatersModel.class, new Serializer());
                }
            }

            public RatersModel() {
                super(1);
            }

            public RatersModel(MutableFlatBuffer mutableFlatBuffer) {
                super(1);
                a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
            }

            public final int m17891a() {
                a(0, 0);
                return this.f15361d;
            }

            public static RatersModel m17890a(RatersModel ratersModel) {
                if (ratersModel == null) {
                    return null;
                }
                if (ratersModel instanceof RatersModel) {
                    return ratersModel;
                }
                Builder builder = new Builder();
                builder.f15360a = ratersModel.m17891a();
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.c(1);
                flatBufferBuilder.a(0, builder.f15360a, 0);
                flatBufferBuilder.d(flatBufferBuilder.d());
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                return new RatersModel(new MutableFlatBuffer(wrap, null, null, true, null));
            }

            public final int jK_() {
                return -24998752;
            }

            public final GraphQLVisitableModel m17893a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m17892a(FlatBufferBuilder flatBufferBuilder) {
                h();
                flatBufferBuilder.c(1);
                flatBufferBuilder.a(0, this.f15361d, 0);
                i();
                return flatBufferBuilder.d();
            }

            public final void m17894a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                super.a(mutableFlatBuffer, i, obj);
                this.f15361d = mutableFlatBuffer.a(i, 0, 0);
            }
        }

        /* compiled from: device_family */
        public class Serializer extends JsonSerializer<NearbyPagePlaceInfoFragmentModel> {
            public final void m17895a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                NearbyPagePlaceInfoFragmentModel nearbyPagePlaceInfoFragmentModel = (NearbyPagePlaceInfoFragmentModel) obj;
                if (nearbyPagePlaceInfoFragmentModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(nearbyPagePlaceInfoFragmentModel.m17921a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    nearbyPagePlaceInfoFragmentModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                NearbyPagePlaceInfoFragmentParser.m18350a(nearbyPagePlaceInfoFragmentModel.w_(), nearbyPagePlaceInfoFragmentModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(NearbyPagePlaceInfoFragmentModel.class, new Serializer());
            }
        }

        public NearbyPagePlaceInfoFragmentModel() {
            super(30);
        }

        public final void m17925a(String str, ConsistencyTuple consistencyTuple) {
            if ("does_viewer_like".equals(str)) {
                consistencyTuple.a = Boolean.valueOf(m17907m());
                consistencyTuple.b = u_();
                consistencyTuple.c = 5;
                return;
            }
            consistencyTuple.a();
        }

        public final void m17926a(String str, Object obj, boolean z) {
            if ("does_viewer_like".equals(str)) {
                m17903a(((Boolean) obj).booleanValue());
            }
        }

        @Nullable
        private AddressModel m17904j() {
            this.f15369d = (AddressModel) super.a(this.f15369d, 0, AddressModel.class);
            return this.f15369d;
        }

        @Nonnull
        private ImmutableList<String> m17905k() {
            this.f15372g = super.a(this.f15372g, 3);
            return (ImmutableList) this.f15372g;
        }

        @Nullable
        private GraphQLPageCategoryType m17906l() {
            this.f15373h = (GraphQLPageCategoryType) super.b(this.f15373h, 4, GraphQLPageCategoryType.class, GraphQLPageCategoryType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
            return this.f15373h;
        }

        private boolean m17907m() {
            a(0, 5);
            return this.f15374i;
        }

        private void m17903a(boolean z) {
            this.f15374i = z;
            if (this.b != null && this.b.d) {
                this.b.a(this.c, 5, z);
            }
        }

        @Nonnull
        private ImmutableList<HoursModel> m17908n() {
            this.f15376k = super.a(this.f15376k, 7, HoursModel.class);
            return (ImmutableList) this.f15376k;
        }

        @Nullable
        private String m17909o() {
            this.f15377l = super.a(this.f15377l, 8);
            return this.f15377l;
        }

        @Nullable
        private LocationModel m17910p() {
            this.f15379n = (LocationModel) super.a(this.f15379n, 10, LocationModel.class);
            return this.f15379n;
        }

        @Nullable
        private String m17911q() {
            this.f15380o = super.a(this.f15380o, 11);
            return this.f15380o;
        }

        @Nullable
        private OverallStarRatingModel m17912r() {
            this.f15381p = (OverallStarRatingModel) super.a(this.f15381p, 12, OverallStarRatingModel.class);
            return this.f15381p;
        }

        @Nullable
        private PageLikersModel m17913s() {
            this.f15382q = (PageLikersModel) super.a(this.f15382q, 13, PageLikersModel.class);
            return this.f15382q;
        }

        @Nullable
        private PageVisitsModel m17914t() {
            this.f15383r = (PageVisitsModel) super.a(this.f15383r, 14, PageVisitsModel.class);
            return this.f15383r;
        }

        @Nullable
        private GraphQLPermanentlyClosedStatus m17915u() {
            this.f15384s = (GraphQLPermanentlyClosedStatus) super.b(this.f15384s, 15, GraphQLPermanentlyClosedStatus.class, GraphQLPermanentlyClosedStatus.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
            return this.f15384s;
        }

        @Nullable
        private PlaceOpenStatusModel m17916v() {
            this.f15385t = (PlaceOpenStatusModel) super.a(this.f15385t, 16, PlaceOpenStatusModel.class);
            return this.f15385t;
        }

        @Nullable
        private GraphQLPageOpenHoursDisplayDecisionEnum m17917w() {
            this.f15386u = (GraphQLPageOpenHoursDisplayDecisionEnum) super.b(this.f15386u, 17, GraphQLPageOpenHoursDisplayDecisionEnum.class, GraphQLPageOpenHoursDisplayDecisionEnum.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
            return this.f15386u;
        }

        @Nullable
        private GraphQLPlaceType m17918x() {
            this.f15387v = (GraphQLPlaceType) super.b(this.f15387v, 18, GraphQLPlaceType.class, GraphQLPlaceType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
            return this.f15387v;
        }

        @Nullable
        private String m17919y() {
            this.f15388w = super.a(this.f15388w, 19);
            return this.f15388w;
        }

        @Nullable
        private BrowseNearbyPlacesFullImageFragmentModel m17920z() {
            this.f15389x = (BrowseNearbyPlacesFullImageFragmentModel) super.a(this.f15389x, 20, BrowseNearbyPlacesFullImageFragmentModel.class);
            return this.f15389x;
        }

        @Nullable
        private BrowseNearbyPlacesFullImageFragmentModel m17896A() {
            this.f15390y = (BrowseNearbyPlacesFullImageFragmentModel) super.a(this.f15390y, 21, BrowseNearbyPlacesFullImageFragmentModel.class);
            return this.f15390y;
        }

        @Nullable
        private RatersModel m17897B() {
            this.f15362A = (RatersModel) super.a(this.f15362A, 23, RatersModel.class);
            return this.f15362A;
        }

        @Nonnull
        private ImmutableList<RedirectionInfoModel> m17898C() {
            this.f15363B = super.a(this.f15363B, 24, RedirectionInfoModel.class);
            return (ImmutableList) this.f15363B;
        }

        @Nonnull
        private ImmutableList<String> m17899D() {
            this.f15364C = super.a(this.f15364C, 25);
            return (ImmutableList) this.f15364C;
        }

        @Nullable
        private GraphQLPageSuperCategoryType m17900E() {
            this.f15366E = (GraphQLPageSuperCategoryType) super.b(this.f15366E, 27, GraphQLPageSuperCategoryType.class, GraphQLPageSuperCategoryType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
            return this.f15366E;
        }

        @Nonnull
        private ImmutableList<String> m17901F() {
            this.f15367F = super.a(this.f15367F, 28);
            return (ImmutableList) this.f15367F;
        }

        @Nullable
        private GraphQLSavedState m17902G() {
            this.f15368G = (GraphQLSavedState) super.b(this.f15368G, 29, GraphQLSavedState.class, GraphQLSavedState.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
            return this.f15368G;
        }

        @Nullable
        public final String m17923a() {
            return m17909o();
        }

        public final int jK_() {
            return 2479791;
        }

        public final GraphQLVisitableModel m17922a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            Builder a;
            BrowseNearbyPlacesFullImageFragmentModel browseNearbyPlacesFullImageFragmentModel;
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m17904j() != null) {
                AddressModel addressModel = (AddressModel) graphQLModelMutatingVisitor.b(m17904j());
                if (m17904j() != addressModel) {
                    graphQLVisitableModel = (NearbyPagePlaceInfoFragmentModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f15369d = addressModel;
                }
            }
            if (m17908n() != null) {
                a = ModelHelper.a(m17908n(), graphQLModelMutatingVisitor);
                if (a != null) {
                    NearbyPagePlaceInfoFragmentModel nearbyPagePlaceInfoFragmentModel = (NearbyPagePlaceInfoFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                    nearbyPagePlaceInfoFragmentModel.f15376k = a.b();
                    graphQLVisitableModel = nearbyPagePlaceInfoFragmentModel;
                }
            }
            if (m17910p() != null) {
                LocationModel locationModel = (LocationModel) graphQLModelMutatingVisitor.b(m17910p());
                if (m17910p() != locationModel) {
                    graphQLVisitableModel = (NearbyPagePlaceInfoFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f15379n = locationModel;
                }
            }
            if (m17912r() != null) {
                OverallStarRatingModel overallStarRatingModel = (OverallStarRatingModel) graphQLModelMutatingVisitor.b(m17912r());
                if (m17912r() != overallStarRatingModel) {
                    graphQLVisitableModel = (NearbyPagePlaceInfoFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f15381p = overallStarRatingModel;
                }
            }
            if (m17913s() != null) {
                PageLikersModel pageLikersModel = (PageLikersModel) graphQLModelMutatingVisitor.b(m17913s());
                if (m17913s() != pageLikersModel) {
                    graphQLVisitableModel = (NearbyPagePlaceInfoFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f15382q = pageLikersModel;
                }
            }
            if (m17914t() != null) {
                PageVisitsModel pageVisitsModel = (PageVisitsModel) graphQLModelMutatingVisitor.b(m17914t());
                if (m17914t() != pageVisitsModel) {
                    graphQLVisitableModel = (NearbyPagePlaceInfoFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f15383r = pageVisitsModel;
                }
            }
            if (m17916v() != null) {
                PlaceOpenStatusModel placeOpenStatusModel = (PlaceOpenStatusModel) graphQLModelMutatingVisitor.b(m17916v());
                if (m17916v() != placeOpenStatusModel) {
                    graphQLVisitableModel = (NearbyPagePlaceInfoFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f15385t = placeOpenStatusModel;
                }
            }
            if (m17920z() != null) {
                browseNearbyPlacesFullImageFragmentModel = (BrowseNearbyPlacesFullImageFragmentModel) graphQLModelMutatingVisitor.b(m17920z());
                if (m17920z() != browseNearbyPlacesFullImageFragmentModel) {
                    graphQLVisitableModel = (NearbyPagePlaceInfoFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f15389x = browseNearbyPlacesFullImageFragmentModel;
                }
            }
            if (m17896A() != null) {
                browseNearbyPlacesFullImageFragmentModel = (BrowseNearbyPlacesFullImageFragmentModel) graphQLModelMutatingVisitor.b(m17896A());
                if (m17896A() != browseNearbyPlacesFullImageFragmentModel) {
                    graphQLVisitableModel = (NearbyPagePlaceInfoFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f15390y = browseNearbyPlacesFullImageFragmentModel;
                }
            }
            if (m17897B() != null) {
                RatersModel ratersModel = (RatersModel) graphQLModelMutatingVisitor.b(m17897B());
                if (m17897B() != ratersModel) {
                    graphQLVisitableModel = (NearbyPagePlaceInfoFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f15362A = ratersModel;
                }
            }
            if (m17898C() != null) {
                a = ModelHelper.a(m17898C(), graphQLModelMutatingVisitor);
                if (a != null) {
                    nearbyPagePlaceInfoFragmentModel = (NearbyPagePlaceInfoFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                    nearbyPagePlaceInfoFragmentModel.f15363B = a.b();
                    graphQLVisitableModel = nearbyPagePlaceInfoFragmentModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m17921a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m17904j());
            int c = flatBufferBuilder.c(m17905k());
            int a2 = flatBufferBuilder.a(m17906l());
            int a3 = ModelHelper.a(flatBufferBuilder, m17908n());
            int b = flatBufferBuilder.b(m17909o());
            int a4 = ModelHelper.a(flatBufferBuilder, m17910p());
            int b2 = flatBufferBuilder.b(m17911q());
            int a5 = ModelHelper.a(flatBufferBuilder, m17912r());
            int a6 = ModelHelper.a(flatBufferBuilder, m17913s());
            int a7 = ModelHelper.a(flatBufferBuilder, m17914t());
            int a8 = flatBufferBuilder.a(m17915u());
            int a9 = ModelHelper.a(flatBufferBuilder, m17916v());
            int a10 = flatBufferBuilder.a(m17917w());
            int a11 = flatBufferBuilder.a(m17918x());
            int b3 = flatBufferBuilder.b(m17919y());
            int a12 = ModelHelper.a(flatBufferBuilder, m17920z());
            int a13 = ModelHelper.a(flatBufferBuilder, m17896A());
            int a14 = ModelHelper.a(flatBufferBuilder, m17897B());
            int a15 = ModelHelper.a(flatBufferBuilder, m17898C());
            int c2 = flatBufferBuilder.c(m17899D());
            int a16 = flatBufferBuilder.a(m17900E());
            int c3 = flatBufferBuilder.c(m17901F());
            int a17 = flatBufferBuilder.a(m17902G());
            flatBufferBuilder.c(30);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.a(1, this.f15370e);
            flatBufferBuilder.a(2, this.f15371f);
            flatBufferBuilder.b(3, c);
            flatBufferBuilder.b(4, a2);
            flatBufferBuilder.a(5, this.f15374i);
            flatBufferBuilder.a(6, this.f15375j);
            flatBufferBuilder.b(7, a3);
            flatBufferBuilder.b(8, b);
            flatBufferBuilder.a(9, this.f15378m);
            flatBufferBuilder.b(10, a4);
            flatBufferBuilder.b(11, b2);
            flatBufferBuilder.b(12, a5);
            flatBufferBuilder.b(13, a6);
            flatBufferBuilder.b(14, a7);
            flatBufferBuilder.b(15, a8);
            flatBufferBuilder.b(16, a9);
            flatBufferBuilder.b(17, a10);
            flatBufferBuilder.b(18, a11);
            flatBufferBuilder.b(19, b3);
            flatBufferBuilder.b(20, a12);
            flatBufferBuilder.b(21, a13);
            flatBufferBuilder.a(22, this.f15391z);
            flatBufferBuilder.b(23, a14);
            flatBufferBuilder.b(24, a15);
            flatBufferBuilder.b(25, c2);
            flatBufferBuilder.a(26, this.f15365D);
            flatBufferBuilder.b(27, a16);
            flatBufferBuilder.b(28, c3);
            flatBufferBuilder.b(29, a17);
            i();
            return flatBufferBuilder.d();
        }

        public final void m17924a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
            super.a(mutableFlatBuffer, i, obj);
            this.f15370e = mutableFlatBuffer.a(i, 1);
            this.f15371f = mutableFlatBuffer.a(i, 2);
            this.f15374i = mutableFlatBuffer.a(i, 5);
            this.f15375j = mutableFlatBuffer.a(i, 6);
            this.f15378m = mutableFlatBuffer.a(i, 9);
            this.f15391z = mutableFlatBuffer.a(i, 22);
            this.f15365D = mutableFlatBuffer.a(i, 26);
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -1727794191)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: device_family */
    public final class NearbyPlacesFriendsWhoVisitedFragmentModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel, NearbyPlacesFriendsWhoVisitedFragment {
        @Nullable
        private FriendsWhoVisitedModel f15412d;
        @Nullable
        private String f15413e;

        /* compiled from: device_family */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(NearbyPlacesFriendsWhoVisitedFragmentModel.class, new Deserializer());
            }

            public Object m17927a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = NearbyPlacesFriendsWhoVisitedFragmentParser.m18361a(jsonParser);
                Object nearbyPlacesFriendsWhoVisitedFragmentModel = new NearbyPlacesFriendsWhoVisitedFragmentModel();
                ((BaseModel) nearbyPlacesFriendsWhoVisitedFragmentModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (nearbyPlacesFriendsWhoVisitedFragmentModel instanceof Postprocessable) {
                    return ((Postprocessable) nearbyPlacesFriendsWhoVisitedFragmentModel).a();
                }
                return nearbyPlacesFriendsWhoVisitedFragmentModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 1392104234)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: device_family */
        public final class FriendsWhoVisitedModel extends BaseModel implements GraphQLVisitableModel {
            private int f15409d;
            @Nullable
            private List<EdgesModel> f15410e;
            @Nullable
            private SocialContextModel f15411f;

            /* compiled from: device_family */
            public final class Builder {
                public int f15392a;
                @Nullable
                public ImmutableList<EdgesModel> f15393b;
                @Nullable
                public SocialContextModel f15394c;
            }

            /* compiled from: device_family */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(FriendsWhoVisitedModel.class, new Deserializer());
                }

                public Object m17928a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(FriendsWhoVisitedParser.m18359a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object friendsWhoVisitedModel = new FriendsWhoVisitedModel();
                    ((BaseModel) friendsWhoVisitedModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (friendsWhoVisitedModel instanceof Postprocessable) {
                        return ((Postprocessable) friendsWhoVisitedModel).a();
                    }
                    return friendsWhoVisitedModel;
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = 1839613139)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: device_family */
            public final class EdgesModel extends BaseModel implements GraphQLVisitableModel {
                @Nullable
                private NodeModel f15400d;

                /* compiled from: device_family */
                public final class Builder {
                    @Nullable
                    public NodeModel f15395a;
                }

                /* compiled from: device_family */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(EdgesModel.class, new Deserializer());
                    }

                    public Object m17929a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(EdgesParser.m18353b(jsonParser, flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        mutableFlatBuffer.a(4, Boolean.valueOf(true));
                        MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                        Object edgesModel = new EdgesModel();
                        ((BaseModel) edgesModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                        if (edgesModel instanceof Postprocessable) {
                            return ((Postprocessable) edgesModel).a();
                        }
                        return edgesModel;
                    }
                }

                @JsonDeserialize(using = Deserializer.class)
                @ModelWithFlatBufferFormatHash(a = -1185712657)
                @JsonSerialize(using = Serializer.class)
                @FragmentModelWithoutBridge
                /* compiled from: device_family */
                public final class NodeModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
                    @Nullable
                    private String f15398d;
                    @Nullable
                    private String f15399e;

                    /* compiled from: device_family */
                    public final class Builder {
                        @Nullable
                        public String f15396a;
                        @Nullable
                        public String f15397b;
                    }

                    /* compiled from: device_family */
                    public class Deserializer extends FbJsonDeserializer {
                        static {
                            GlobalAutoGenDeserializerCache.a(NodeModel.class, new Deserializer());
                        }

                        public Object m17930a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(NodeParser.m18351a(jsonParser, flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            mutableFlatBuffer.a(4, Boolean.valueOf(true));
                            MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                            Object nodeModel = new NodeModel();
                            ((BaseModel) nodeModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                            if (nodeModel instanceof Postprocessable) {
                                return ((Postprocessable) nodeModel).a();
                            }
                            return nodeModel;
                        }
                    }

                    /* compiled from: device_family */
                    public class Serializer extends JsonSerializer<NodeModel> {
                        public final void m17931a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                            NodeModel nodeModel = (NodeModel) obj;
                            if (nodeModel.w_() == null) {
                                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                flatBufferBuilder.d(nodeModel.m17933a(flatBufferBuilder));
                                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                wrap.position(0);
                                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                nodeModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                            }
                            NodeParser.m18352a(nodeModel.w_(), nodeModel.u_(), jsonGenerator);
                        }

                        static {
                            FbSerializerProvider.a(NodeModel.class, new Serializer());
                        }
                    }

                    public NodeModel() {
                        super(2);
                    }

                    public NodeModel(MutableFlatBuffer mutableFlatBuffer) {
                        super(2);
                        a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }

                    public final void m17936a(String str, ConsistencyTuple consistencyTuple) {
                        consistencyTuple.a();
                    }

                    public final void m17937a(String str, Object obj, boolean z) {
                    }

                    @Nullable
                    public final String m17938b() {
                        this.f15398d = super.a(this.f15398d, 0);
                        return this.f15398d;
                    }

                    @Nullable
                    public final String m17939c() {
                        this.f15399e = super.a(this.f15399e, 1);
                        return this.f15399e;
                    }

                    public static NodeModel m17932a(NodeModel nodeModel) {
                        if (nodeModel == null) {
                            return null;
                        }
                        if (nodeModel instanceof NodeModel) {
                            return nodeModel;
                        }
                        Builder builder = new Builder();
                        builder.f15396a = nodeModel.m17938b();
                        builder.f15397b = nodeModel.m17939c();
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        int b = flatBufferBuilder.b(builder.f15396a);
                        int b2 = flatBufferBuilder.b(builder.f15397b);
                        flatBufferBuilder.c(2);
                        flatBufferBuilder.b(0, b);
                        flatBufferBuilder.b(1, b2);
                        flatBufferBuilder.d(flatBufferBuilder.d());
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        return new NodeModel(new MutableFlatBuffer(wrap, null, null, true, null));
                    }

                    @Nullable
                    public final String m17935a() {
                        return m17938b();
                    }

                    public final int jK_() {
                        return 2645995;
                    }

                    public final GraphQLVisitableModel m17934a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                        h();
                        i();
                        return this;
                    }

                    public final int m17933a(FlatBufferBuilder flatBufferBuilder) {
                        h();
                        int b = flatBufferBuilder.b(m17938b());
                        int b2 = flatBufferBuilder.b(m17939c());
                        flatBufferBuilder.c(2);
                        flatBufferBuilder.b(0, b);
                        flatBufferBuilder.b(1, b2);
                        i();
                        return flatBufferBuilder.d();
                    }
                }

                /* compiled from: device_family */
                public class Serializer extends JsonSerializer<EdgesModel> {
                    public final void m17940a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        EdgesModel edgesModel = (EdgesModel) obj;
                        if (edgesModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(edgesModel.m17943a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            edgesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        EdgesParser.m18354b(edgesModel.w_(), edgesModel.u_(), jsonGenerator, serializerProvider);
                    }

                    static {
                        FbSerializerProvider.a(EdgesModel.class, new Serializer());
                    }
                }

                @Nullable
                public final /* synthetic */ NodeModel m17945a() {
                    return m17942j();
                }

                public EdgesModel() {
                    super(1);
                }

                public EdgesModel(MutableFlatBuffer mutableFlatBuffer) {
                    super(1);
                    a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }

                @Nullable
                private NodeModel m17942j() {
                    this.f15400d = (NodeModel) super.a(this.f15400d, 0, NodeModel.class);
                    return this.f15400d;
                }

                public static EdgesModel m17941a(EdgesModel edgesModel) {
                    if (edgesModel == null) {
                        return null;
                    }
                    if (edgesModel instanceof EdgesModel) {
                        return edgesModel;
                    }
                    Builder builder = new Builder();
                    builder.f15395a = NodeModel.m17932a(edgesModel.m17945a());
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    int a = ModelHelper.a(flatBufferBuilder, builder.f15395a);
                    flatBufferBuilder.c(1);
                    flatBufferBuilder.b(0, a);
                    flatBufferBuilder.d(flatBufferBuilder.d());
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    return new EdgesModel(new MutableFlatBuffer(wrap, null, null, true, null));
                }

                public final int jK_() {
                    return -1193695682;
                }

                public final GraphQLVisitableModel m17944a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    GraphQLVisitableModel graphQLVisitableModel = null;
                    h();
                    if (m17942j() != null) {
                        NodeModel nodeModel = (NodeModel) graphQLModelMutatingVisitor.b(m17942j());
                        if (m17942j() != nodeModel) {
                            graphQLVisitableModel = (EdgesModel) ModelHelper.a(null, this);
                            graphQLVisitableModel.f15400d = nodeModel;
                        }
                    }
                    i();
                    return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                }

                public final int m17943a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int a = ModelHelper.a(flatBufferBuilder, m17942j());
                    flatBufferBuilder.c(1);
                    flatBufferBuilder.b(0, a);
                    i();
                    return flatBufferBuilder.d();
                }
            }

            /* compiled from: device_family */
            public class Serializer extends JsonSerializer<FriendsWhoVisitedModel> {
                public final void m17946a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    FriendsWhoVisitedModel friendsWhoVisitedModel = (FriendsWhoVisitedModel) obj;
                    if (friendsWhoVisitedModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(friendsWhoVisitedModel.m17965a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        friendsWhoVisitedModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    FriendsWhoVisitedParser.m18360a(friendsWhoVisitedModel.w_(), friendsWhoVisitedModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(FriendsWhoVisitedModel.class, new Serializer());
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = 1784761953)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: device_family */
            public final class SocialContextModel extends BaseModel implements GraphQLVisitableModel {
                @Nullable
                private List<RangesModel> f15407d;
                @Nullable
                private String f15408e;

                /* compiled from: device_family */
                public final class Builder {
                    @Nullable
                    public ImmutableList<RangesModel> f15401a;
                    @Nullable
                    public String f15402b;
                }

                /* compiled from: device_family */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(SocialContextModel.class, new Deserializer());
                    }

                    public Object m17947a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(SocialContextParser.m18357a(jsonParser, flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        mutableFlatBuffer.a(4, Boolean.valueOf(true));
                        MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                        Object socialContextModel = new SocialContextModel();
                        ((BaseModel) socialContextModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                        if (socialContextModel instanceof Postprocessable) {
                            return ((Postprocessable) socialContextModel).a();
                        }
                        return socialContextModel;
                    }
                }

                @JsonDeserialize(using = Deserializer.class)
                @ModelWithFlatBufferFormatHash(a = 732242581)
                @JsonSerialize(using = Serializer.class)
                @FragmentModelWithoutBridge
                /* compiled from: device_family */
                public final class RangesModel extends BaseModel implements GraphQLVisitableModel {
                    private int f15405d;
                    private int f15406e;

                    /* compiled from: device_family */
                    public final class Builder {
                        public int f15403a;
                        public int f15404b;
                    }

                    /* compiled from: device_family */
                    public class Deserializer extends FbJsonDeserializer {
                        static {
                            GlobalAutoGenDeserializerCache.a(RangesModel.class, new Deserializer());
                        }

                        public Object m17948a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(RangesParser.m18356b(jsonParser, flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            mutableFlatBuffer.a(4, Boolean.valueOf(true));
                            MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                            Object rangesModel = new RangesModel();
                            ((BaseModel) rangesModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                            if (rangesModel instanceof Postprocessable) {
                                return ((Postprocessable) rangesModel).a();
                            }
                            return rangesModel;
                        }
                    }

                    /* compiled from: device_family */
                    public class Serializer extends JsonSerializer<RangesModel> {
                        public final void m17949a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                            RangesModel rangesModel = (RangesModel) obj;
                            if (rangesModel.w_() == null) {
                                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                flatBufferBuilder.d(rangesModel.m17952a(flatBufferBuilder));
                                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                wrap.position(0);
                                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                rangesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                            }
                            RangesParser.m18355a(rangesModel.w_(), rangesModel.u_(), jsonGenerator);
                        }

                        static {
                            FbSerializerProvider.a(RangesModel.class, new Serializer());
                        }
                    }

                    public RangesModel() {
                        super(2);
                    }

                    public RangesModel(MutableFlatBuffer mutableFlatBuffer) {
                        super(2);
                        a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }

                    public final int m17951a() {
                        a(0, 0);
                        return this.f15405d;
                    }

                    public final int m17955b() {
                        a(0, 1);
                        return this.f15406e;
                    }

                    public static RangesModel m17950a(RangesModel rangesModel) {
                        if (rangesModel == null) {
                            return null;
                        }
                        if (rangesModel instanceof RangesModel) {
                            return rangesModel;
                        }
                        Builder builder = new Builder();
                        builder.f15403a = rangesModel.m17951a();
                        builder.f15404b = rangesModel.m17955b();
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.c(2);
                        flatBufferBuilder.a(0, builder.f15403a, 0);
                        flatBufferBuilder.a(1, builder.f15404b, 0);
                        flatBufferBuilder.d(flatBufferBuilder.d());
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        return new RangesModel(new MutableFlatBuffer(wrap, null, null, true, null));
                    }

                    public final int jK_() {
                        return -1024511161;
                    }

                    public final GraphQLVisitableModel m17953a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                        h();
                        i();
                        return this;
                    }

                    public final int m17952a(FlatBufferBuilder flatBufferBuilder) {
                        h();
                        flatBufferBuilder.c(2);
                        flatBufferBuilder.a(0, this.f15405d, 0);
                        flatBufferBuilder.a(1, this.f15406e, 0);
                        i();
                        return flatBufferBuilder.d();
                    }

                    public final void m17954a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                        super.a(mutableFlatBuffer, i, obj);
                        this.f15405d = mutableFlatBuffer.a(i, 0, 0);
                        this.f15406e = mutableFlatBuffer.a(i, 1, 0);
                    }
                }

                /* compiled from: device_family */
                public class Serializer extends JsonSerializer<SocialContextModel> {
                    public final void m17956a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        SocialContextModel socialContextModel = (SocialContextModel) obj;
                        if (socialContextModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(socialContextModel.m17958a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            socialContextModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        SocialContextParser.m18358a(socialContextModel.w_(), socialContextModel.u_(), jsonGenerator, serializerProvider);
                    }

                    static {
                        FbSerializerProvider.a(SocialContextModel.class, new Serializer());
                    }
                }

                public SocialContextModel() {
                    super(2);
                }

                public SocialContextModel(MutableFlatBuffer mutableFlatBuffer) {
                    super(2);
                    a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }

                @Nonnull
                public final ImmutableList<RangesModel> m17960a() {
                    this.f15407d = super.a(this.f15407d, 0, RangesModel.class);
                    return (ImmutableList) this.f15407d;
                }

                @Nullable
                public final String m17961b() {
                    this.f15408e = super.a(this.f15408e, 1);
                    return this.f15408e;
                }

                public static SocialContextModel m17957a(SocialContextModel socialContextModel) {
                    if (socialContextModel == null) {
                        return null;
                    }
                    if (socialContextModel instanceof SocialContextModel) {
                        return socialContextModel;
                    }
                    Builder builder = new Builder();
                    com.google.common.collect.ImmutableList.Builder builder2 = ImmutableList.builder();
                    for (int i = 0; i < socialContextModel.m17960a().size(); i++) {
                        builder2.c(RangesModel.m17950a((RangesModel) socialContextModel.m17960a().get(i)));
                    }
                    builder.f15401a = builder2.b();
                    builder.f15402b = socialContextModel.m17961b();
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    int a = ModelHelper.a(flatBufferBuilder, builder.f15401a);
                    int b = flatBufferBuilder.b(builder.f15402b);
                    flatBufferBuilder.c(2);
                    flatBufferBuilder.b(0, a);
                    flatBufferBuilder.b(1, b);
                    flatBufferBuilder.d(flatBufferBuilder.d());
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    return new SocialContextModel(new MutableFlatBuffer(wrap, null, null, true, null));
                }

                public final int jK_() {
                    return -1919764332;
                }

                public final GraphQLVisitableModel m17959a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    GraphQLVisitableModel graphQLVisitableModel = null;
                    h();
                    if (m17960a() != null) {
                        com.google.common.collect.ImmutableList.Builder a = ModelHelper.a(m17960a(), graphQLModelMutatingVisitor);
                        if (a != null) {
                            graphQLVisitableModel = (SocialContextModel) ModelHelper.a(null, this);
                            graphQLVisitableModel.f15407d = a.b();
                        }
                    }
                    i();
                    return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                }

                public final int m17958a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int a = ModelHelper.a(flatBufferBuilder, m17960a());
                    int b = flatBufferBuilder.b(m17961b());
                    flatBufferBuilder.c(2);
                    flatBufferBuilder.b(0, a);
                    flatBufferBuilder.b(1, b);
                    i();
                    return flatBufferBuilder.d();
                }
            }

            @Nullable
            public final /* synthetic */ SocialContextModel m17969c() {
                return m17963j();
            }

            public FriendsWhoVisitedModel() {
                super(3);
            }

            public FriendsWhoVisitedModel(MutableFlatBuffer mutableFlatBuffer) {
                super(3);
                a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
            }

            public final int m17964a() {
                a(0, 0);
                return this.f15409d;
            }

            @Nonnull
            public final ImmutableList<EdgesModel> m17968b() {
                this.f15410e = super.a(this.f15410e, 1, EdgesModel.class);
                return (ImmutableList) this.f15410e;
            }

            @Nullable
            private SocialContextModel m17963j() {
                this.f15411f = (SocialContextModel) super.a(this.f15411f, 2, SocialContextModel.class);
                return this.f15411f;
            }

            public static FriendsWhoVisitedModel m17962a(FriendsWhoVisitedModel friendsWhoVisitedModel) {
                if (friendsWhoVisitedModel == null) {
                    return null;
                }
                if (friendsWhoVisitedModel instanceof FriendsWhoVisitedModel) {
                    return friendsWhoVisitedModel;
                }
                Builder builder = new Builder();
                builder.f15392a = friendsWhoVisitedModel.m17964a();
                com.google.common.collect.ImmutableList.Builder builder2 = ImmutableList.builder();
                for (int i = 0; i < friendsWhoVisitedModel.m17968b().size(); i++) {
                    builder2.c(EdgesModel.m17941a((EdgesModel) friendsWhoVisitedModel.m17968b().get(i)));
                }
                builder.f15393b = builder2.b();
                builder.f15394c = SocialContextModel.m17957a(friendsWhoVisitedModel.m17969c());
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                int a = ModelHelper.a(flatBufferBuilder, builder.f15393b);
                int a2 = ModelHelper.a(flatBufferBuilder, builder.f15394c);
                flatBufferBuilder.c(3);
                flatBufferBuilder.a(0, builder.f15392a, 0);
                flatBufferBuilder.b(1, a);
                flatBufferBuilder.b(2, a2);
                flatBufferBuilder.d(flatBufferBuilder.d());
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                return new FriendsWhoVisitedModel(new MutableFlatBuffer(wrap, null, null, true, null));
            }

            public final int jK_() {
                return -404188513;
            }

            public final GraphQLVisitableModel m17966a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel;
                SocialContextModel socialContextModel;
                h();
                if (m17968b() != null) {
                    com.google.common.collect.ImmutableList.Builder a = ModelHelper.a(m17968b(), graphQLModelMutatingVisitor);
                    if (a != null) {
                        FriendsWhoVisitedModel friendsWhoVisitedModel = (FriendsWhoVisitedModel) ModelHelper.a(null, this);
                        friendsWhoVisitedModel.f15410e = a.b();
                        graphQLVisitableModel = friendsWhoVisitedModel;
                        if (m17963j() != null) {
                            socialContextModel = (SocialContextModel) graphQLModelMutatingVisitor.b(m17963j());
                            if (m17963j() != socialContextModel) {
                                graphQLVisitableModel = (FriendsWhoVisitedModel) ModelHelper.a(graphQLVisitableModel, this);
                                graphQLVisitableModel.f15411f = socialContextModel;
                            }
                        }
                        i();
                        return graphQLVisitableModel != null ? this : graphQLVisitableModel;
                    }
                }
                graphQLVisitableModel = null;
                if (m17963j() != null) {
                    socialContextModel = (SocialContextModel) graphQLModelMutatingVisitor.b(m17963j());
                    if (m17963j() != socialContextModel) {
                        graphQLVisitableModel = (FriendsWhoVisitedModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f15411f = socialContextModel;
                    }
                }
                i();
                if (graphQLVisitableModel != null) {
                }
            }

            public final int m17965a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m17968b());
                int a2 = ModelHelper.a(flatBufferBuilder, m17963j());
                flatBufferBuilder.c(3);
                flatBufferBuilder.a(0, this.f15409d, 0);
                flatBufferBuilder.b(1, a);
                flatBufferBuilder.b(2, a2);
                i();
                return flatBufferBuilder.d();
            }

            public final void m17967a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                super.a(mutableFlatBuffer, i, obj);
                this.f15409d = mutableFlatBuffer.a(i, 0, 0);
            }
        }

        /* compiled from: device_family */
        public class Serializer extends JsonSerializer<NearbyPlacesFriendsWhoVisitedFragmentModel> {
            public final void m17970a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                NearbyPlacesFriendsWhoVisitedFragmentModel nearbyPlacesFriendsWhoVisitedFragmentModel = (NearbyPlacesFriendsWhoVisitedFragmentModel) obj;
                if (nearbyPlacesFriendsWhoVisitedFragmentModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(nearbyPlacesFriendsWhoVisitedFragmentModel.m17973a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    nearbyPlacesFriendsWhoVisitedFragmentModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = nearbyPlacesFriendsWhoVisitedFragmentModel.w_();
                int u_ = nearbyPlacesFriendsWhoVisitedFragmentModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("friends_who_visited");
                    FriendsWhoVisitedParser.m18360a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                if (mutableFlatBuffer.g(u_, 1) != 0) {
                    jsonGenerator.a("id");
                    jsonGenerator.b(mutableFlatBuffer.c(u_, 1));
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(NearbyPlacesFriendsWhoVisitedFragmentModel.class, new Serializer());
            }
        }

        public NearbyPlacesFriendsWhoVisitedFragmentModel() {
            super(2);
        }

        public final void m17976a(String str, ConsistencyTuple consistencyTuple) {
            consistencyTuple.a();
        }

        public final void m17977a(String str, Object obj, boolean z) {
        }

        @Nullable
        private FriendsWhoVisitedModel m17971j() {
            this.f15412d = (FriendsWhoVisitedModel) super.a(this.f15412d, 0, FriendsWhoVisitedModel.class);
            return this.f15412d;
        }

        @Nullable
        private String m17972k() {
            this.f15413e = super.a(this.f15413e, 1);
            return this.f15413e;
        }

        @Nullable
        public final String m17975a() {
            return m17972k();
        }

        public final int jK_() {
            return 2479791;
        }

        public final GraphQLVisitableModel m17974a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m17971j() != null) {
                FriendsWhoVisitedModel friendsWhoVisitedModel = (FriendsWhoVisitedModel) graphQLModelMutatingVisitor.b(m17971j());
                if (m17971j() != friendsWhoVisitedModel) {
                    graphQLVisitableModel = (NearbyPlacesFriendsWhoVisitedFragmentModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f15412d = friendsWhoVisitedModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m17973a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m17971j());
            int b = flatBufferBuilder.b(m17972k());
            flatBufferBuilder.c(2);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, b);
            i();
            return flatBufferBuilder.d();
        }
    }

    @FragmentModelWithBridge
    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -1041249125)
    @JsonSerialize(using = Serializer.class)
    /* compiled from: device_family */
    public final class NearbyPlacesHugeResultCellPageInformationFragmentModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel, NearbyPlacesHugeResultCellPageInformationFragment {
        @Nullable
        private ProfilePhotoModel f15449A;
        private boolean f15450B;
        @Nullable
        private RatersModel f15451C;
        @Nullable
        private NearbyRecommendationsConnectionFragmentModel f15452D;
        @Nullable
        private List<RedirectionInfoModel> f15453E;
        @Nullable
        private List<Photo320FragmentModel> f15454F;
        @Nullable
        private List<String> f15455G;
        private boolean f15456H;
        @Nullable
        private List<String> f15457I;
        @Nullable
        private GraphQLPageSuperCategoryType f15458J;
        @Nullable
        private List<String> f15459K;
        @Nullable
        private GraphQLSavedState f15460L;
        @Nullable
        private AddressModel f15461d;
        private boolean f15462e;
        private boolean f15463f;
        @Nullable
        private List<String> f15464g;
        @Nullable
        private GraphQLPageCategoryType f15465h;
        private boolean f15466i;
        private boolean f15467j;
        @Nullable
        private FriendsWhoVisitedModel f15468k;
        @Nullable
        private List<HoursModel> f15469l;
        @Nullable
        private String f15470m;
        private boolean f15471n;
        @Nullable
        private LocationModel f15472o;
        @Nullable
        private String f15473p;
        @Nullable
        private OverallStarRatingModel f15474q;
        @Nullable
        private PageLikersModel f15475r;
        @Nullable
        private PageVisitsModel f15476s;
        @Nullable
        private GraphQLPermanentlyClosedStatus f15477t;
        @Nullable
        private PlaceOpenStatusModel f15478u;
        @Nullable
        private GraphQLPageOpenHoursDisplayDecisionEnum f15479v;
        @Nullable
        private GraphQLPlaceType f15480w;
        @Nullable
        private String f15481x;
        @Nullable
        private BrowseNearbyPlacesFullImageFragmentModel f15482y;
        @Nullable
        private BrowseNearbyPlacesFullImageFragmentModel f15483z;

        /* compiled from: device_family */
        public final class Builder {
            @Nullable
            public NearbyRecommendationsConnectionFragmentModel f15414A;
            @Nullable
            public ImmutableList<RedirectionInfoModel> f15415B;
            @Nullable
            public ImmutableList<Photo320FragmentModel> f15416C;
            @Nullable
            public ImmutableList<String> f15417D;
            public boolean f15418E;
            @Nullable
            public ImmutableList<String> f15419F;
            @Nullable
            public GraphQLPageSuperCategoryType f15420G;
            @Nullable
            public ImmutableList<String> f15421H;
            @Nullable
            public GraphQLSavedState f15422I;
            @Nullable
            public AddressModel f15423a;
            public boolean f15424b;
            public boolean f15425c;
            @Nullable
            public ImmutableList<String> f15426d;
            @Nullable
            public GraphQLPageCategoryType f15427e;
            public boolean f15428f;
            public boolean f15429g;
            @Nullable
            public FriendsWhoVisitedModel f15430h;
            @Nullable
            public ImmutableList<HoursModel> f15431i;
            @Nullable
            public String f15432j;
            public boolean f15433k;
            @Nullable
            public LocationModel f15434l;
            @Nullable
            public String f15435m;
            @Nullable
            public OverallStarRatingModel f15436n;
            @Nullable
            public PageLikersModel f15437o;
            @Nullable
            public PageVisitsModel f15438p;
            @Nullable
            public GraphQLPermanentlyClosedStatus f15439q;
            @Nullable
            public PlaceOpenStatusModel f15440r;
            @Nullable
            public GraphQLPageOpenHoursDisplayDecisionEnum f15441s;
            @Nullable
            public GraphQLPlaceType f15442t;
            @Nullable
            public String f15443u;
            @Nullable
            public BrowseNearbyPlacesFullImageFragmentModel f15444v;
            @Nullable
            public BrowseNearbyPlacesFullImageFragmentModel f15445w;
            @Nullable
            public ProfilePhotoModel f15446x;
            public boolean f15447y;
            @Nullable
            public RatersModel f15448z;

            public final NearbyPlacesHugeResultCellPageInformationFragmentModel m17978a() {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                int a = ModelHelper.a(flatBufferBuilder, this.f15423a);
                int c = flatBufferBuilder.c(this.f15426d);
                int a2 = flatBufferBuilder.a(this.f15427e);
                int a3 = ModelHelper.a(flatBufferBuilder, this.f15430h);
                int a4 = ModelHelper.a(flatBufferBuilder, this.f15431i);
                int b = flatBufferBuilder.b(this.f15432j);
                int a5 = ModelHelper.a(flatBufferBuilder, this.f15434l);
                int b2 = flatBufferBuilder.b(this.f15435m);
                int a6 = ModelHelper.a(flatBufferBuilder, this.f15436n);
                int a7 = ModelHelper.a(flatBufferBuilder, this.f15437o);
                int a8 = ModelHelper.a(flatBufferBuilder, this.f15438p);
                int a9 = flatBufferBuilder.a(this.f15439q);
                int a10 = ModelHelper.a(flatBufferBuilder, this.f15440r);
                int a11 = flatBufferBuilder.a(this.f15441s);
                int a12 = flatBufferBuilder.a(this.f15442t);
                int b3 = flatBufferBuilder.b(this.f15443u);
                int a13 = ModelHelper.a(flatBufferBuilder, this.f15444v);
                int a14 = ModelHelper.a(flatBufferBuilder, this.f15445w);
                int a15 = ModelHelper.a(flatBufferBuilder, this.f15446x);
                int a16 = ModelHelper.a(flatBufferBuilder, this.f15448z);
                int a17 = ModelHelper.a(flatBufferBuilder, this.f15414A);
                int a18 = ModelHelper.a(flatBufferBuilder, this.f15415B);
                int a19 = ModelHelper.a(flatBufferBuilder, this.f15416C);
                int c2 = flatBufferBuilder.c(this.f15417D);
                int c3 = flatBufferBuilder.c(this.f15419F);
                int a20 = flatBufferBuilder.a(this.f15420G);
                int c4 = flatBufferBuilder.c(this.f15421H);
                int a21 = flatBufferBuilder.a(this.f15422I);
                flatBufferBuilder.c(35);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.a(1, this.f15424b);
                flatBufferBuilder.a(2, this.f15425c);
                flatBufferBuilder.b(3, c);
                flatBufferBuilder.b(4, a2);
                flatBufferBuilder.a(5, this.f15428f);
                flatBufferBuilder.a(6, this.f15429g);
                flatBufferBuilder.b(7, a3);
                flatBufferBuilder.b(8, a4);
                flatBufferBuilder.b(9, b);
                flatBufferBuilder.a(10, this.f15433k);
                flatBufferBuilder.b(11, a5);
                flatBufferBuilder.b(12, b2);
                flatBufferBuilder.b(13, a6);
                flatBufferBuilder.b(14, a7);
                flatBufferBuilder.b(15, a8);
                flatBufferBuilder.b(16, a9);
                flatBufferBuilder.b(17, a10);
                flatBufferBuilder.b(18, a11);
                flatBufferBuilder.b(19, a12);
                flatBufferBuilder.b(20, b3);
                flatBufferBuilder.b(21, a13);
                flatBufferBuilder.b(22, a14);
                flatBufferBuilder.b(23, a15);
                flatBufferBuilder.a(24, this.f15447y);
                flatBufferBuilder.b(25, a16);
                flatBufferBuilder.b(26, a17);
                flatBufferBuilder.b(27, a18);
                flatBufferBuilder.b(28, a19);
                flatBufferBuilder.b(29, c2);
                flatBufferBuilder.a(30, this.f15418E);
                flatBufferBuilder.b(31, c3);
                flatBufferBuilder.b(32, a20);
                flatBufferBuilder.b(33, c4);
                flatBufferBuilder.b(34, a21);
                flatBufferBuilder.d(flatBufferBuilder.d());
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                return new NearbyPlacesHugeResultCellPageInformationFragmentModel(new MutableFlatBuffer(wrap, null, null, true, null));
            }
        }

        /* compiled from: device_family */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(NearbyPlacesHugeResultCellPageInformationFragmentModel.class, new Deserializer());
            }

            public Object m17979a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(NearbyPlacesHugeResultCellPageInformationFragmentParser.m18362a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object nearbyPlacesHugeResultCellPageInformationFragmentModel = new NearbyPlacesHugeResultCellPageInformationFragmentModel();
                ((BaseModel) nearbyPlacesHugeResultCellPageInformationFragmentModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (nearbyPlacesHugeResultCellPageInformationFragmentModel instanceof Postprocessable) {
                    return ((Postprocessable) nearbyPlacesHugeResultCellPageInformationFragmentModel).a();
                }
                return nearbyPlacesHugeResultCellPageInformationFragmentModel;
            }
        }

        /* compiled from: device_family */
        public class Serializer extends JsonSerializer<NearbyPlacesHugeResultCellPageInformationFragmentModel> {
            public final void m17980a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                NearbyPlacesHugeResultCellPageInformationFragmentModel nearbyPlacesHugeResultCellPageInformationFragmentModel = (NearbyPlacesHugeResultCellPageInformationFragmentModel) obj;
                if (nearbyPlacesHugeResultCellPageInformationFragmentModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(nearbyPlacesHugeResultCellPageInformationFragmentModel.m18006a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    nearbyPlacesHugeResultCellPageInformationFragmentModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                NearbyPlacesHugeResultCellPageInformationFragmentParser.m18363a(nearbyPlacesHugeResultCellPageInformationFragmentModel.w_(), nearbyPlacesHugeResultCellPageInformationFragmentModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(NearbyPlacesHugeResultCellPageInformationFragmentModel.class, new Serializer());
            }
        }

        @Nullable
        public final /* synthetic */ RatersModel mo920B() {
            return m17991V();
        }

        @Nullable
        public final /* synthetic */ NearbyRecommendationsConnectionFragmentModel mo921C() {
            return m17992W();
        }

        @Nullable
        public final /* synthetic */ AddressModel mo930b() {
            return m17981L();
        }

        @Nullable
        public final /* synthetic */ FriendsWhoVisitedModel mo934j() {
            return m17982M();
        }

        @Nullable
        public final /* synthetic */ LocationModel mo941n() {
            return m17983N();
        }

        @Nullable
        public final /* synthetic */ OverallStarRatingModel mo943p() {
            return m17984O();
        }

        @Nullable
        public final /* synthetic */ PageLikersModel mo944q() {
            return m17985P();
        }

        @Nullable
        public final /* synthetic */ PageVisitsModel mo945r() {
            return m17986Q();
        }

        @Nullable
        public final /* synthetic */ PlaceOpenStatusModel mo947t() {
            return m17987R();
        }

        @Nullable
        public final /* synthetic */ BrowseNearbyPlacesFullImageFragmentModel mo951x() {
            return m17988S();
        }

        @Nullable
        public final /* synthetic */ BrowseNearbyPlacesFullImageFragmentModel mo952y() {
            return m17989T();
        }

        @Nullable
        public final /* synthetic */ ProfilePhotoModel mo953z() {
            return m17990U();
        }

        public NearbyPlacesHugeResultCellPageInformationFragmentModel() {
            super(35);
        }

        public NearbyPlacesHugeResultCellPageInformationFragmentModel(MutableFlatBuffer mutableFlatBuffer) {
            super(35);
            a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
        }

        public final void m18010a(String str, ConsistencyTuple consistencyTuple) {
            if ("does_viewer_like".equals(str)) {
                consistencyTuple.a = Boolean.valueOf(jZ_());
                consistencyTuple.b = u_();
                consistencyTuple.c = 5;
                return;
            }
            consistencyTuple.a();
        }

        public final void m18011a(String str, Object obj, boolean z) {
            if ("does_viewer_like".equals(str)) {
                m17994a(((Boolean) obj).booleanValue());
            }
        }

        @Nullable
        private AddressModel m17981L() {
            this.f15461d = (AddressModel) super.a(this.f15461d, 0, AddressModel.class);
            return this.f15461d;
        }

        public final boolean mo931c() {
            a(0, 1);
            return this.f15462e;
        }

        public final boolean mo932d() {
            a(0, 2);
            return this.f15463f;
        }

        @Nonnull
        public final ImmutableList<String> jY_() {
            this.f15464g = super.a(this.f15464g, 3);
            return (ImmutableList) this.f15464g;
        }

        @Nullable
        public final GraphQLPageCategoryType mo933g() {
            this.f15465h = (GraphQLPageCategoryType) super.b(this.f15465h, 4, GraphQLPageCategoryType.class, GraphQLPageCategoryType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
            return this.f15465h;
        }

        public final boolean jZ_() {
            a(0, 5);
            return this.f15466i;
        }

        private void m17994a(boolean z) {
            this.f15466i = z;
            if (this.b != null && this.b.d) {
                this.b.a(this.c, 5, z);
            }
        }

        public final boolean ka_() {
            a(0, 6);
            return this.f15467j;
        }

        @Nullable
        private FriendsWhoVisitedModel m17982M() {
            this.f15468k = (FriendsWhoVisitedModel) super.a(this.f15468k, 7, FriendsWhoVisitedModel.class);
            return this.f15468k;
        }

        @Nonnull
        public final ImmutableList<HoursModel> mo937k() {
            this.f15469l = super.a(this.f15469l, 8, HoursModel.class);
            return (ImmutableList) this.f15469l;
        }

        @Nullable
        public final String mo939l() {
            this.f15470m = super.a(this.f15470m, 9);
            return this.f15470m;
        }

        public final boolean mo940m() {
            a(1, 2);
            return this.f15471n;
        }

        @Nullable
        private LocationModel m17983N() {
            this.f15472o = (LocationModel) super.a(this.f15472o, 11, LocationModel.class);
            return this.f15472o;
        }

        @Nullable
        public final String mo942o() {
            this.f15473p = super.a(this.f15473p, 12);
            return this.f15473p;
        }

        @Nullable
        private OverallStarRatingModel m17984O() {
            this.f15474q = (OverallStarRatingModel) super.a(this.f15474q, 13, OverallStarRatingModel.class);
            return this.f15474q;
        }

        @Nullable
        private PageLikersModel m17985P() {
            this.f15475r = (PageLikersModel) super.a(this.f15475r, 14, PageLikersModel.class);
            return this.f15475r;
        }

        @Nullable
        private PageVisitsModel m17986Q() {
            this.f15476s = (PageVisitsModel) super.a(this.f15476s, 15, PageVisitsModel.class);
            return this.f15476s;
        }

        @Nullable
        public final GraphQLPermanentlyClosedStatus mo946s() {
            this.f15477t = (GraphQLPermanentlyClosedStatus) super.b(this.f15477t, 16, GraphQLPermanentlyClosedStatus.class, GraphQLPermanentlyClosedStatus.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
            return this.f15477t;
        }

        @Nullable
        private PlaceOpenStatusModel m17987R() {
            this.f15478u = (PlaceOpenStatusModel) super.a(this.f15478u, 17, PlaceOpenStatusModel.class);
            return this.f15478u;
        }

        @Nullable
        public final GraphQLPageOpenHoursDisplayDecisionEnum mo948u() {
            this.f15479v = (GraphQLPageOpenHoursDisplayDecisionEnum) super.b(this.f15479v, 18, GraphQLPageOpenHoursDisplayDecisionEnum.class, GraphQLPageOpenHoursDisplayDecisionEnum.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
            return this.f15479v;
        }

        @Nullable
        public final GraphQLPlaceType mo949v() {
            this.f15480w = (GraphQLPlaceType) super.b(this.f15480w, 19, GraphQLPlaceType.class, GraphQLPlaceType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
            return this.f15480w;
        }

        @Nullable
        public final String mo950w() {
            this.f15481x = super.a(this.f15481x, 20);
            return this.f15481x;
        }

        @Nullable
        private BrowseNearbyPlacesFullImageFragmentModel m17988S() {
            this.f15482y = (BrowseNearbyPlacesFullImageFragmentModel) super.a(this.f15482y, 21, BrowseNearbyPlacesFullImageFragmentModel.class);
            return this.f15482y;
        }

        @Nullable
        private BrowseNearbyPlacesFullImageFragmentModel m17989T() {
            this.f15483z = (BrowseNearbyPlacesFullImageFragmentModel) super.a(this.f15483z, 22, BrowseNearbyPlacesFullImageFragmentModel.class);
            return this.f15483z;
        }

        @Nullable
        private ProfilePhotoModel m17990U() {
            this.f15449A = (ProfilePhotoModel) super.a(this.f15449A, 23, ProfilePhotoModel.class);
            return this.f15449A;
        }

        public final boolean mo919A() {
            a(3, 0);
            return this.f15450B;
        }

        @Nullable
        private RatersModel m17991V() {
            this.f15451C = (RatersModel) super.a(this.f15451C, 25, RatersModel.class);
            return this.f15451C;
        }

        @Nullable
        private NearbyRecommendationsConnectionFragmentModel m17992W() {
            this.f15452D = (NearbyRecommendationsConnectionFragmentModel) super.a(this.f15452D, 26, NearbyRecommendationsConnectionFragmentModel.class);
            return this.f15452D;
        }

        @Nonnull
        public final ImmutableList<RedirectionInfoModel> mo922D() {
            this.f15453E = super.a(this.f15453E, 27, RedirectionInfoModel.class);
            return (ImmutableList) this.f15453E;
        }

        @Nonnull
        public final ImmutableList<Photo320FragmentModel> mo923E() {
            this.f15454F = super.a(this.f15454F, 28, Photo320FragmentModel.class);
            return (ImmutableList) this.f15454F;
        }

        @Nonnull
        public final ImmutableList<String> mo924F() {
            this.f15455G = super.a(this.f15455G, 29);
            return (ImmutableList) this.f15455G;
        }

        public final boolean mo925G() {
            a(3, 6);
            return this.f15456H;
        }

        @Nonnull
        public final ImmutableList<String> mo926H() {
            this.f15457I = super.a(this.f15457I, 31);
            return (ImmutableList) this.f15457I;
        }

        @Nullable
        public final GraphQLPageSuperCategoryType mo927I() {
            this.f15458J = (GraphQLPageSuperCategoryType) super.b(this.f15458J, 32, GraphQLPageSuperCategoryType.class, GraphQLPageSuperCategoryType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
            return this.f15458J;
        }

        @Nonnull
        public final ImmutableList<String> mo928J() {
            this.f15459K = super.a(this.f15459K, 33);
            return (ImmutableList) this.f15459K;
        }

        @Nullable
        public final GraphQLSavedState mo929K() {
            this.f15460L = (GraphQLSavedState) super.b(this.f15460L, 34, GraphQLSavedState.class, GraphQLSavedState.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
            return this.f15460L;
        }

        public static NearbyPlacesHugeResultCellPageInformationFragmentModel m17993a(NearbyPlacesHugeResultCellPageInformationFragment nearbyPlacesHugeResultCellPageInformationFragment) {
            int i = 0;
            if (nearbyPlacesHugeResultCellPageInformationFragment == null) {
                return null;
            }
            if (nearbyPlacesHugeResultCellPageInformationFragment instanceof NearbyPlacesHugeResultCellPageInformationFragmentModel) {
                return (NearbyPlacesHugeResultCellPageInformationFragmentModel) nearbyPlacesHugeResultCellPageInformationFragment;
            }
            int i2;
            int i3;
            Builder builder = new Builder();
            builder.f15423a = AddressModel.m17834a(nearbyPlacesHugeResultCellPageInformationFragment.mo930b());
            builder.f15424b = nearbyPlacesHugeResultCellPageInformationFragment.mo931c();
            builder.f15425c = nearbyPlacesHugeResultCellPageInformationFragment.mo932d();
            com.google.common.collect.ImmutableList.Builder builder2 = ImmutableList.builder();
            for (i2 = 0; i2 < nearbyPlacesHugeResultCellPageInformationFragment.jY_().size(); i2++) {
                builder2.c(nearbyPlacesHugeResultCellPageInformationFragment.jY_().get(i2));
            }
            builder.f15426d = builder2.b();
            builder.f15427e = nearbyPlacesHugeResultCellPageInformationFragment.mo933g();
            builder.f15428f = nearbyPlacesHugeResultCellPageInformationFragment.jZ_();
            builder.f15429g = nearbyPlacesHugeResultCellPageInformationFragment.ka_();
            builder.f15430h = FriendsWhoVisitedModel.m17962a(nearbyPlacesHugeResultCellPageInformationFragment.mo934j());
            com.google.common.collect.ImmutableList.Builder builder3 = ImmutableList.builder();
            for (i3 = 0; i3 < nearbyPlacesHugeResultCellPageInformationFragment.mo937k().size(); i3++) {
                builder3.c(HoursModel.m17843a((HoursModel) nearbyPlacesHugeResultCellPageInformationFragment.mo937k().get(i3)));
            }
            builder.f15431i = builder3.b();
            builder.f15432j = nearbyPlacesHugeResultCellPageInformationFragment.mo939l();
            builder.f15433k = nearbyPlacesHugeResultCellPageInformationFragment.mo940m();
            builder.f15434l = LocationModel.m17852a(nearbyPlacesHugeResultCellPageInformationFragment.mo941n());
            builder.f15435m = nearbyPlacesHugeResultCellPageInformationFragment.mo942o();
            builder.f15436n = OverallStarRatingModel.m17861a(nearbyPlacesHugeResultCellPageInformationFragment.mo943p());
            builder.f15437o = PageLikersModel.m17870a(nearbyPlacesHugeResultCellPageInformationFragment.mo944q());
            builder.f15438p = PageVisitsModel.m17877a(nearbyPlacesHugeResultCellPageInformationFragment.mo945r());
            builder.f15439q = nearbyPlacesHugeResultCellPageInformationFragment.mo946s();
            builder.f15440r = PlaceOpenStatusModel.m17884a(nearbyPlacesHugeResultCellPageInformationFragment.mo947t());
            builder.f15441s = nearbyPlacesHugeResultCellPageInformationFragment.mo948u();
            builder.f15442t = nearbyPlacesHugeResultCellPageInformationFragment.mo949v();
            builder.f15443u = nearbyPlacesHugeResultCellPageInformationFragment.mo950w();
            builder.f15444v = BrowseNearbyPlacesFullImageFragmentModel.m17800a(nearbyPlacesHugeResultCellPageInformationFragment.mo951x());
            builder.f15445w = BrowseNearbyPlacesFullImageFragmentModel.m17800a(nearbyPlacesHugeResultCellPageInformationFragment.mo952y());
            builder.f15446x = ProfilePhotoModel.m18213a(nearbyPlacesHugeResultCellPageInformationFragment.mo953z());
            builder.f15447y = nearbyPlacesHugeResultCellPageInformationFragment.mo919A();
            builder.f15448z = RatersModel.m17890a(nearbyPlacesHugeResultCellPageInformationFragment.mo920B());
            builder.f15414A = NearbyRecommendationsConnectionFragmentModel.m18251a(nearbyPlacesHugeResultCellPageInformationFragment.mo921C());
            builder3 = ImmutableList.builder();
            for (i3 = 0; i3 < nearbyPlacesHugeResultCellPageInformationFragment.mo922D().size(); i3++) {
                builder3.c(RedirectionInfoModel.m18270a((RedirectionInfoModel) nearbyPlacesHugeResultCellPageInformationFragment.mo922D().get(i3)));
            }
            builder.f15415B = builder3.b();
            builder3 = ImmutableList.builder();
            for (i3 = 0; i3 < nearbyPlacesHugeResultCellPageInformationFragment.mo923E().size(); i3++) {
                builder3.c(Photo320FragmentModel.m18288a((Photo320FragmentModel) nearbyPlacesHugeResultCellPageInformationFragment.mo923E().get(i3)));
            }
            builder.f15416C = builder3.b();
            builder2 = ImmutableList.builder();
            for (i2 = 0; i2 < nearbyPlacesHugeResultCellPageInformationFragment.mo924F().size(); i2++) {
                builder2.c(nearbyPlacesHugeResultCellPageInformationFragment.mo924F().get(i2));
            }
            builder.f15417D = builder2.b();
            builder.f15418E = nearbyPlacesHugeResultCellPageInformationFragment.mo925G();
            builder2 = ImmutableList.builder();
            for (i2 = 0; i2 < nearbyPlacesHugeResultCellPageInformationFragment.mo926H().size(); i2++) {
                builder2.c(nearbyPlacesHugeResultCellPageInformationFragment.mo926H().get(i2));
            }
            builder.f15419F = builder2.b();
            builder.f15420G = nearbyPlacesHugeResultCellPageInformationFragment.mo927I();
            com.google.common.collect.ImmutableList.Builder builder4 = ImmutableList.builder();
            while (i < nearbyPlacesHugeResultCellPageInformationFragment.mo928J().size()) {
                builder4.c(nearbyPlacesHugeResultCellPageInformationFragment.mo928J().get(i));
                i++;
            }
            builder.f15421H = builder4.b();
            builder.f15422I = nearbyPlacesHugeResultCellPageInformationFragment.mo929K();
            return builder.m17978a();
        }

        @Nullable
        public final String m18008a() {
            return mo939l();
        }

        public final int jK_() {
            return 2479791;
        }

        public final GraphQLVisitableModel m18007a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            com.google.common.collect.ImmutableList.Builder a;
            BrowseNearbyPlacesFullImageFragmentModel browseNearbyPlacesFullImageFragmentModel;
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m17981L() != null) {
                AddressModel addressModel = (AddressModel) graphQLModelMutatingVisitor.b(m17981L());
                if (m17981L() != addressModel) {
                    graphQLVisitableModel = (NearbyPlacesHugeResultCellPageInformationFragmentModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f15461d = addressModel;
                }
            }
            if (m17982M() != null) {
                FriendsWhoVisitedModel friendsWhoVisitedModel = (FriendsWhoVisitedModel) graphQLModelMutatingVisitor.b(m17982M());
                if (m17982M() != friendsWhoVisitedModel) {
                    graphQLVisitableModel = (NearbyPlacesHugeResultCellPageInformationFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f15468k = friendsWhoVisitedModel;
                }
            }
            if (mo937k() != null) {
                a = ModelHelper.a(mo937k(), graphQLModelMutatingVisitor);
                if (a != null) {
                    NearbyPlacesHugeResultCellPageInformationFragmentModel nearbyPlacesHugeResultCellPageInformationFragmentModel = (NearbyPlacesHugeResultCellPageInformationFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                    nearbyPlacesHugeResultCellPageInformationFragmentModel.f15469l = a.b();
                    graphQLVisitableModel = nearbyPlacesHugeResultCellPageInformationFragmentModel;
                }
            }
            if (m17983N() != null) {
                LocationModel locationModel = (LocationModel) graphQLModelMutatingVisitor.b(m17983N());
                if (m17983N() != locationModel) {
                    graphQLVisitableModel = (NearbyPlacesHugeResultCellPageInformationFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f15472o = locationModel;
                }
            }
            if (m17984O() != null) {
                OverallStarRatingModel overallStarRatingModel = (OverallStarRatingModel) graphQLModelMutatingVisitor.b(m17984O());
                if (m17984O() != overallStarRatingModel) {
                    graphQLVisitableModel = (NearbyPlacesHugeResultCellPageInformationFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f15474q = overallStarRatingModel;
                }
            }
            if (m17985P() != null) {
                PageLikersModel pageLikersModel = (PageLikersModel) graphQLModelMutatingVisitor.b(m17985P());
                if (m17985P() != pageLikersModel) {
                    graphQLVisitableModel = (NearbyPlacesHugeResultCellPageInformationFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f15475r = pageLikersModel;
                }
            }
            if (m17986Q() != null) {
                PageVisitsModel pageVisitsModel = (PageVisitsModel) graphQLModelMutatingVisitor.b(m17986Q());
                if (m17986Q() != pageVisitsModel) {
                    graphQLVisitableModel = (NearbyPlacesHugeResultCellPageInformationFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f15476s = pageVisitsModel;
                }
            }
            if (m17987R() != null) {
                PlaceOpenStatusModel placeOpenStatusModel = (PlaceOpenStatusModel) graphQLModelMutatingVisitor.b(m17987R());
                if (m17987R() != placeOpenStatusModel) {
                    graphQLVisitableModel = (NearbyPlacesHugeResultCellPageInformationFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f15478u = placeOpenStatusModel;
                }
            }
            if (m17988S() != null) {
                browseNearbyPlacesFullImageFragmentModel = (BrowseNearbyPlacesFullImageFragmentModel) graphQLModelMutatingVisitor.b(m17988S());
                if (m17988S() != browseNearbyPlacesFullImageFragmentModel) {
                    graphQLVisitableModel = (NearbyPlacesHugeResultCellPageInformationFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f15482y = browseNearbyPlacesFullImageFragmentModel;
                }
            }
            if (m17989T() != null) {
                browseNearbyPlacesFullImageFragmentModel = (BrowseNearbyPlacesFullImageFragmentModel) graphQLModelMutatingVisitor.b(m17989T());
                if (m17989T() != browseNearbyPlacesFullImageFragmentModel) {
                    graphQLVisitableModel = (NearbyPlacesHugeResultCellPageInformationFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f15483z = browseNearbyPlacesFullImageFragmentModel;
                }
            }
            if (m17990U() != null) {
                ProfilePhotoModel profilePhotoModel = (ProfilePhotoModel) graphQLModelMutatingVisitor.b(m17990U());
                if (m17990U() != profilePhotoModel) {
                    graphQLVisitableModel = (NearbyPlacesHugeResultCellPageInformationFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f15449A = profilePhotoModel;
                }
            }
            if (m17991V() != null) {
                RatersModel ratersModel = (RatersModel) graphQLModelMutatingVisitor.b(m17991V());
                if (m17991V() != ratersModel) {
                    graphQLVisitableModel = (NearbyPlacesHugeResultCellPageInformationFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f15451C = ratersModel;
                }
            }
            if (m17992W() != null) {
                NearbyRecommendationsConnectionFragmentModel nearbyRecommendationsConnectionFragmentModel = (NearbyRecommendationsConnectionFragmentModel) graphQLModelMutatingVisitor.b(m17992W());
                if (m17992W() != nearbyRecommendationsConnectionFragmentModel) {
                    graphQLVisitableModel = (NearbyPlacesHugeResultCellPageInformationFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f15452D = nearbyRecommendationsConnectionFragmentModel;
                }
            }
            if (mo922D() != null) {
                a = ModelHelper.a(mo922D(), graphQLModelMutatingVisitor);
                if (a != null) {
                    nearbyPlacesHugeResultCellPageInformationFragmentModel = (NearbyPlacesHugeResultCellPageInformationFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                    nearbyPlacesHugeResultCellPageInformationFragmentModel.f15453E = a.b();
                    graphQLVisitableModel = nearbyPlacesHugeResultCellPageInformationFragmentModel;
                }
            }
            if (mo923E() != null) {
                a = ModelHelper.a(mo923E(), graphQLModelMutatingVisitor);
                if (a != null) {
                    nearbyPlacesHugeResultCellPageInformationFragmentModel = (NearbyPlacesHugeResultCellPageInformationFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                    nearbyPlacesHugeResultCellPageInformationFragmentModel.f15454F = a.b();
                    graphQLVisitableModel = nearbyPlacesHugeResultCellPageInformationFragmentModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m18006a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m17981L());
            int c = flatBufferBuilder.c(jY_());
            int a2 = flatBufferBuilder.a(mo933g());
            int a3 = ModelHelper.a(flatBufferBuilder, m17982M());
            int a4 = ModelHelper.a(flatBufferBuilder, mo937k());
            int b = flatBufferBuilder.b(mo939l());
            int a5 = ModelHelper.a(flatBufferBuilder, m17983N());
            int b2 = flatBufferBuilder.b(mo942o());
            int a6 = ModelHelper.a(flatBufferBuilder, m17984O());
            int a7 = ModelHelper.a(flatBufferBuilder, m17985P());
            int a8 = ModelHelper.a(flatBufferBuilder, m17986Q());
            int a9 = flatBufferBuilder.a(mo946s());
            int a10 = ModelHelper.a(flatBufferBuilder, m17987R());
            int a11 = flatBufferBuilder.a(mo948u());
            int a12 = flatBufferBuilder.a(mo949v());
            int b3 = flatBufferBuilder.b(mo950w());
            int a13 = ModelHelper.a(flatBufferBuilder, m17988S());
            int a14 = ModelHelper.a(flatBufferBuilder, m17989T());
            int a15 = ModelHelper.a(flatBufferBuilder, m17990U());
            int a16 = ModelHelper.a(flatBufferBuilder, m17991V());
            int a17 = ModelHelper.a(flatBufferBuilder, m17992W());
            int a18 = ModelHelper.a(flatBufferBuilder, mo922D());
            int a19 = ModelHelper.a(flatBufferBuilder, mo923E());
            int c2 = flatBufferBuilder.c(mo924F());
            int c3 = flatBufferBuilder.c(mo926H());
            int a20 = flatBufferBuilder.a(mo927I());
            int c4 = flatBufferBuilder.c(mo928J());
            int a21 = flatBufferBuilder.a(mo929K());
            flatBufferBuilder.c(35);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.a(1, this.f15462e);
            flatBufferBuilder.a(2, this.f15463f);
            flatBufferBuilder.b(3, c);
            flatBufferBuilder.b(4, a2);
            flatBufferBuilder.a(5, this.f15466i);
            flatBufferBuilder.a(6, this.f15467j);
            flatBufferBuilder.b(7, a3);
            flatBufferBuilder.b(8, a4);
            flatBufferBuilder.b(9, b);
            flatBufferBuilder.a(10, this.f15471n);
            flatBufferBuilder.b(11, a5);
            flatBufferBuilder.b(12, b2);
            flatBufferBuilder.b(13, a6);
            flatBufferBuilder.b(14, a7);
            flatBufferBuilder.b(15, a8);
            flatBufferBuilder.b(16, a9);
            flatBufferBuilder.b(17, a10);
            flatBufferBuilder.b(18, a11);
            flatBufferBuilder.b(19, a12);
            flatBufferBuilder.b(20, b3);
            flatBufferBuilder.b(21, a13);
            flatBufferBuilder.b(22, a14);
            flatBufferBuilder.b(23, a15);
            flatBufferBuilder.a(24, this.f15450B);
            flatBufferBuilder.b(25, a16);
            flatBufferBuilder.b(26, a17);
            flatBufferBuilder.b(27, a18);
            flatBufferBuilder.b(28, a19);
            flatBufferBuilder.b(29, c2);
            flatBufferBuilder.a(30, this.f15456H);
            flatBufferBuilder.b(31, c3);
            flatBufferBuilder.b(32, a20);
            flatBufferBuilder.b(33, c4);
            flatBufferBuilder.b(34, a21);
            i();
            return flatBufferBuilder.d();
        }

        public final void m18009a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
            super.a(mutableFlatBuffer, i, obj);
            this.f15462e = mutableFlatBuffer.a(i, 1);
            this.f15463f = mutableFlatBuffer.a(i, 2);
            this.f15466i = mutableFlatBuffer.a(i, 5);
            this.f15467j = mutableFlatBuffer.a(i, 6);
            this.f15471n = mutableFlatBuffer.a(i, 10);
            this.f15450B = mutableFlatBuffer.a(i, 24);
            this.f15456H = mutableFlatBuffer.a(i, 30);
        }
    }

    @FragmentModelWithBridge
    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -1327481537)
    @JsonSerialize(using = Serializer.class)
    /* compiled from: device_family */
    public final class NearbyPlacesHugeResultsSearchQueryV2Model extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private NearbyPlacesNewBrowsePlaceHugeResultsConnectionFragmentModel f15484d;

        /* compiled from: device_family */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(NearbyPlacesHugeResultsSearchQueryV2Model.class, new Deserializer());
            }

            public Object m18033a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = NearbyPlacesHugeResultsSearchQueryV2Parser.m18364a(jsonParser);
                Object nearbyPlacesHugeResultsSearchQueryV2Model = new NearbyPlacesHugeResultsSearchQueryV2Model();
                ((BaseModel) nearbyPlacesHugeResultsSearchQueryV2Model).a(a, FlatBuffer.a(a.a), jsonParser);
                if (nearbyPlacesHugeResultsSearchQueryV2Model instanceof Postprocessable) {
                    return ((Postprocessable) nearbyPlacesHugeResultsSearchQueryV2Model).a();
                }
                return nearbyPlacesHugeResultsSearchQueryV2Model;
            }
        }

        /* compiled from: device_family */
        public class Serializer extends JsonSerializer<NearbyPlacesHugeResultsSearchQueryV2Model> {
            public final void m18034a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                NearbyPlacesHugeResultsSearchQueryV2Model nearbyPlacesHugeResultsSearchQueryV2Model = (NearbyPlacesHugeResultsSearchQueryV2Model) obj;
                if (nearbyPlacesHugeResultsSearchQueryV2Model.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(nearbyPlacesHugeResultsSearchQueryV2Model.m18036a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    nearbyPlacesHugeResultsSearchQueryV2Model.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = nearbyPlacesHugeResultsSearchQueryV2Model.w_();
                int u_ = nearbyPlacesHugeResultsSearchQueryV2Model.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("browse_places");
                    NearbyPlacesNewBrowsePlaceHugeResultsConnectionFragmentParser.m18373a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(NearbyPlacesHugeResultsSearchQueryV2Model.class, new Serializer());
            }
        }

        @Nullable
        public final /* synthetic */ NearbyPlacesNewBrowsePlaceHugeResultsConnectionFragmentModel m18038a() {
            return m18035j();
        }

        public NearbyPlacesHugeResultsSearchQueryV2Model() {
            super(1);
        }

        @Nullable
        private NearbyPlacesNewBrowsePlaceHugeResultsConnectionFragmentModel m18035j() {
            this.f15484d = (NearbyPlacesNewBrowsePlaceHugeResultsConnectionFragmentModel) super.a(this.f15484d, 0, NearbyPlacesNewBrowsePlaceHugeResultsConnectionFragmentModel.class);
            return this.f15484d;
        }

        public final int jK_() {
            return 1725273057;
        }

        public final GraphQLVisitableModel m18037a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m18035j() != null) {
                NearbyPlacesNewBrowsePlaceHugeResultsConnectionFragmentModel nearbyPlacesNewBrowsePlaceHugeResultsConnectionFragmentModel = (NearbyPlacesNewBrowsePlaceHugeResultsConnectionFragmentModel) graphQLModelMutatingVisitor.b(m18035j());
                if (m18035j() != nearbyPlacesNewBrowsePlaceHugeResultsConnectionFragmentModel) {
                    graphQLVisitableModel = (NearbyPlacesHugeResultsSearchQueryV2Model) ModelHelper.a(null, this);
                    graphQLVisitableModel.f15484d = nearbyPlacesNewBrowsePlaceHugeResultsConnectionFragmentModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m18036a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m18035j());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -1551961467)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: device_family */
    public final class NearbyPlacesNewBrowsePaginationInfoModel extends BaseModel implements GraphQLVisitableModel, NearbyPlacesNewBrowsePaginationInfo {
        @Nullable
        private PageInfoModel f15489d;

        /* compiled from: device_family */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(NearbyPlacesNewBrowsePaginationInfoModel.class, new Deserializer());
            }

            public Object m18039a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = NearbyPlacesNewBrowsePaginationInfoParser.m18367a(jsonParser);
                Object nearbyPlacesNewBrowsePaginationInfoModel = new NearbyPlacesNewBrowsePaginationInfoModel();
                ((BaseModel) nearbyPlacesNewBrowsePaginationInfoModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (nearbyPlacesNewBrowsePaginationInfoModel instanceof Postprocessable) {
                    return ((Postprocessable) nearbyPlacesNewBrowsePaginationInfoModel).a();
                }
                return nearbyPlacesNewBrowsePaginationInfoModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -2005169142)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: device_family */
        public final class PageInfoModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private String f15487d;
            private boolean f15488e;

            /* compiled from: device_family */
            public final class Builder {
                @Nullable
                public String f15485a;
                public boolean f15486b;
            }

            /* compiled from: device_family */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(PageInfoModel.class, new Deserializer());
                }

                public Object m18040a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(PageInfoParser.m18365a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object pageInfoModel = new PageInfoModel();
                    ((BaseModel) pageInfoModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (pageInfoModel instanceof Postprocessable) {
                        return ((Postprocessable) pageInfoModel).a();
                    }
                    return pageInfoModel;
                }
            }

            /* compiled from: device_family */
            public class Serializer extends JsonSerializer<PageInfoModel> {
                public final void m18041a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    PageInfoModel pageInfoModel = (PageInfoModel) obj;
                    if (pageInfoModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(pageInfoModel.m18043a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        pageInfoModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    PageInfoParser.m18366a(pageInfoModel.w_(), pageInfoModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(PageInfoModel.class, new Serializer());
                }
            }

            public PageInfoModel() {
                super(2);
            }

            public PageInfoModel(MutableFlatBuffer mutableFlatBuffer) {
                super(2);
                a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
            }

            @Nullable
            public final String m18045a() {
                this.f15487d = super.a(this.f15487d, 0);
                return this.f15487d;
            }

            public final boolean m18047b() {
                a(0, 1);
                return this.f15488e;
            }

            public static PageInfoModel m18042a(PageInfoModel pageInfoModel) {
                if (pageInfoModel == null) {
                    return null;
                }
                if (pageInfoModel instanceof PageInfoModel) {
                    return pageInfoModel;
                }
                Builder builder = new Builder();
                builder.f15485a = pageInfoModel.m18045a();
                builder.f15486b = pageInfoModel.m18047b();
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                int b = flatBufferBuilder.b(builder.f15485a);
                flatBufferBuilder.c(2);
                flatBufferBuilder.b(0, b);
                flatBufferBuilder.a(1, builder.f15486b);
                flatBufferBuilder.d(flatBufferBuilder.d());
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                return new PageInfoModel(new MutableFlatBuffer(wrap, null, null, true, null));
            }

            public final int jK_() {
                return 923779069;
            }

            public final GraphQLVisitableModel m18044a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m18043a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m18045a());
                flatBufferBuilder.c(2);
                flatBufferBuilder.b(0, b);
                flatBufferBuilder.a(1, this.f15488e);
                i();
                return flatBufferBuilder.d();
            }

            public final void m18046a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                super.a(mutableFlatBuffer, i, obj);
                this.f15488e = mutableFlatBuffer.a(i, 1);
            }
        }

        /* compiled from: device_family */
        public class Serializer extends JsonSerializer<NearbyPlacesNewBrowsePaginationInfoModel> {
            public final void m18048a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                NearbyPlacesNewBrowsePaginationInfoModel nearbyPlacesNewBrowsePaginationInfoModel = (NearbyPlacesNewBrowsePaginationInfoModel) obj;
                if (nearbyPlacesNewBrowsePaginationInfoModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(nearbyPlacesNewBrowsePaginationInfoModel.m18050a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    nearbyPlacesNewBrowsePaginationInfoModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = nearbyPlacesNewBrowsePaginationInfoModel.w_();
                int u_ = nearbyPlacesNewBrowsePaginationInfoModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("page_info");
                    PageInfoParser.m18366a(mutableFlatBuffer, g, jsonGenerator);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(NearbyPlacesNewBrowsePaginationInfoModel.class, new Serializer());
            }
        }

        public NearbyPlacesNewBrowsePaginationInfoModel() {
            super(1);
        }

        @Nullable
        private PageInfoModel m18049a() {
            this.f15489d = (PageInfoModel) super.a(this.f15489d, 0, PageInfoModel.class);
            return this.f15489d;
        }

        public final int jK_() {
            return -1988813374;
        }

        public final GraphQLVisitableModel m18051a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m18049a() != null) {
                PageInfoModel pageInfoModel = (PageInfoModel) graphQLModelMutatingVisitor.b(m18049a());
                if (m18049a() != pageInfoModel) {
                    graphQLVisitableModel = (NearbyPlacesNewBrowsePaginationInfoModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f15489d = pageInfoModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m18050a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m18049a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }

    @FragmentModelWithBridge
    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -1661232895)
    @JsonSerialize(using = Serializer.class)
    /* compiled from: device_family */
    public final class NearbyPlacesNewBrowsePlaceHugeResultsConnectionFragmentModel extends BaseModel implements GraphQLVisitableModel, NearbyPlacesNewBrowsePaginationInfo {
        @Nullable
        private GeoRectangleFragmentModel f15566d;
        @Nullable
        private List<EdgesModel> f15567e;
        @Nullable
        private PageInfoModel f15568f;
        @Nullable
        private String f15569g;

        /* compiled from: device_family */
        public final class Builder {
            @Nullable
            public GeoRectangleFragmentModel f15490a;
            @Nullable
            public ImmutableList<EdgesModel> f15491b;
            @Nullable
            public PageInfoModel f15492c;
            @Nullable
            public String f15493d;
        }

        /* compiled from: device_family */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(NearbyPlacesNewBrowsePlaceHugeResultsConnectionFragmentModel.class, new Deserializer());
            }

            public Object m18052a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(NearbyPlacesNewBrowsePlaceHugeResultsConnectionFragmentParser.m18372a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object nearbyPlacesNewBrowsePlaceHugeResultsConnectionFragmentModel = new NearbyPlacesNewBrowsePlaceHugeResultsConnectionFragmentModel();
                ((BaseModel) nearbyPlacesNewBrowsePlaceHugeResultsConnectionFragmentModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (nearbyPlacesNewBrowsePlaceHugeResultsConnectionFragmentModel instanceof Postprocessable) {
                    return ((Postprocessable) nearbyPlacesNewBrowsePlaceHugeResultsConnectionFragmentModel).a();
                }
                return nearbyPlacesNewBrowsePlaceHugeResultsConnectionFragmentModel;
            }
        }

        @FragmentModelWithBridge
        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 927605015)
        @JsonSerialize(using = Serializer.class)
        /* compiled from: device_family */
        public final class EdgesModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private NodeModel f15565d;

            /* compiled from: device_family */
            public final class Builder {
                @Nullable
                public NodeModel f15494a;
            }

            /* compiled from: device_family */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(EdgesModel.class, new Deserializer());
                }

                public Object m18053a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(NearbyPlacesNewBrowsePlaceHugeResultsConnectionFragmentParser.EdgesParser.m18370b(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object edgesModel = new EdgesModel();
                    ((BaseModel) edgesModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (edgesModel instanceof Postprocessable) {
                        return ((Postprocessable) edgesModel).a();
                    }
                    return edgesModel;
                }
            }

            @FragmentModelWithBridge
            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = -1041249125)
            @JsonSerialize(using = Serializer.class)
            /* compiled from: device_family */
            public final class NodeModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel, NearbyPlacesHugeResultCellPageInformationFragment {
                @Nullable
                private ProfilePhotoModel f15530A;
                private boolean f15531B;
                @Nullable
                private RatersModel f15532C;
                @Nullable
                private NearbyRecommendationsConnectionFragmentModel f15533D;
                @Nullable
                private List<RedirectionInfoModel> f15534E;
                @Nullable
                private List<Photo320FragmentModel> f15535F;
                @Nullable
                private List<String> f15536G;
                private boolean f15537H;
                @Nullable
                private List<String> f15538I;
                @Nullable
                private GraphQLPageSuperCategoryType f15539J;
                @Nullable
                private List<String> f15540K;
                @Nullable
                private GraphQLSavedState f15541L;
                @Nullable
                private AddressModel f15542d;
                private boolean f15543e;
                private boolean f15544f;
                @Nullable
                private List<String> f15545g;
                @Nullable
                private GraphQLPageCategoryType f15546h;
                private boolean f15547i;
                private boolean f15548j;
                @Nullable
                private FriendsWhoVisitedModel f15549k;
                @Nullable
                private List<HoursModel> f15550l;
                @Nullable
                private String f15551m;
                private boolean f15552n;
                @Nullable
                private LocationModel f15553o;
                @Nullable
                private String f15554p;
                @Nullable
                private OverallStarRatingModel f15555q;
                @Nullable
                private PageLikersModel f15556r;
                @Nullable
                private PageVisitsModel f15557s;
                @Nullable
                private GraphQLPermanentlyClosedStatus f15558t;
                @Nullable
                private PlaceOpenStatusModel f15559u;
                @Nullable
                private GraphQLPageOpenHoursDisplayDecisionEnum f15560v;
                @Nullable
                private GraphQLPlaceType f15561w;
                @Nullable
                private String f15562x;
                @Nullable
                private BrowseNearbyPlacesFullImageFragmentModel f15563y;
                @Nullable
                private BrowseNearbyPlacesFullImageFragmentModel f15564z;

                /* compiled from: device_family */
                public final class Builder {
                    @Nullable
                    public NearbyRecommendationsConnectionFragmentModel f15495A;
                    @Nullable
                    public ImmutableList<RedirectionInfoModel> f15496B;
                    @Nullable
                    public ImmutableList<Photo320FragmentModel> f15497C;
                    @Nullable
                    public ImmutableList<String> f15498D;
                    public boolean f15499E;
                    @Nullable
                    public ImmutableList<String> f15500F;
                    @Nullable
                    public GraphQLPageSuperCategoryType f15501G;
                    @Nullable
                    public ImmutableList<String> f15502H;
                    @Nullable
                    public GraphQLSavedState f15503I;
                    @Nullable
                    public AddressModel f15504a;
                    public boolean f15505b;
                    public boolean f15506c;
                    @Nullable
                    public ImmutableList<String> f15507d;
                    @Nullable
                    public GraphQLPageCategoryType f15508e;
                    public boolean f15509f;
                    public boolean f15510g;
                    @Nullable
                    public FriendsWhoVisitedModel f15511h;
                    @Nullable
                    public ImmutableList<HoursModel> f15512i;
                    @Nullable
                    public String f15513j;
                    public boolean f15514k;
                    @Nullable
                    public LocationModel f15515l;
                    @Nullable
                    public String f15516m;
                    @Nullable
                    public OverallStarRatingModel f15517n;
                    @Nullable
                    public PageLikersModel f15518o;
                    @Nullable
                    public PageVisitsModel f15519p;
                    @Nullable
                    public GraphQLPermanentlyClosedStatus f15520q;
                    @Nullable
                    public PlaceOpenStatusModel f15521r;
                    @Nullable
                    public GraphQLPageOpenHoursDisplayDecisionEnum f15522s;
                    @Nullable
                    public GraphQLPlaceType f15523t;
                    @Nullable
                    public String f15524u;
                    @Nullable
                    public BrowseNearbyPlacesFullImageFragmentModel f15525v;
                    @Nullable
                    public BrowseNearbyPlacesFullImageFragmentModel f15526w;
                    @Nullable
                    public ProfilePhotoModel f15527x;
                    public boolean f15528y;
                    @Nullable
                    public RatersModel f15529z;

                    public final NodeModel m18054a() {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        int a = ModelHelper.a(flatBufferBuilder, this.f15504a);
                        int c = flatBufferBuilder.c(this.f15507d);
                        int a2 = flatBufferBuilder.a(this.f15508e);
                        int a3 = ModelHelper.a(flatBufferBuilder, this.f15511h);
                        int a4 = ModelHelper.a(flatBufferBuilder, this.f15512i);
                        int b = flatBufferBuilder.b(this.f15513j);
                        int a5 = ModelHelper.a(flatBufferBuilder, this.f15515l);
                        int b2 = flatBufferBuilder.b(this.f15516m);
                        int a6 = ModelHelper.a(flatBufferBuilder, this.f15517n);
                        int a7 = ModelHelper.a(flatBufferBuilder, this.f15518o);
                        int a8 = ModelHelper.a(flatBufferBuilder, this.f15519p);
                        int a9 = flatBufferBuilder.a(this.f15520q);
                        int a10 = ModelHelper.a(flatBufferBuilder, this.f15521r);
                        int a11 = flatBufferBuilder.a(this.f15522s);
                        int a12 = flatBufferBuilder.a(this.f15523t);
                        int b3 = flatBufferBuilder.b(this.f15524u);
                        int a13 = ModelHelper.a(flatBufferBuilder, this.f15525v);
                        int a14 = ModelHelper.a(flatBufferBuilder, this.f15526w);
                        int a15 = ModelHelper.a(flatBufferBuilder, this.f15527x);
                        int a16 = ModelHelper.a(flatBufferBuilder, this.f15529z);
                        int a17 = ModelHelper.a(flatBufferBuilder, this.f15495A);
                        int a18 = ModelHelper.a(flatBufferBuilder, this.f15496B);
                        int a19 = ModelHelper.a(flatBufferBuilder, this.f15497C);
                        int c2 = flatBufferBuilder.c(this.f15498D);
                        int c3 = flatBufferBuilder.c(this.f15500F);
                        int a20 = flatBufferBuilder.a(this.f15501G);
                        int c4 = flatBufferBuilder.c(this.f15502H);
                        int a21 = flatBufferBuilder.a(this.f15503I);
                        flatBufferBuilder.c(35);
                        flatBufferBuilder.b(0, a);
                        flatBufferBuilder.a(1, this.f15505b);
                        flatBufferBuilder.a(2, this.f15506c);
                        flatBufferBuilder.b(3, c);
                        flatBufferBuilder.b(4, a2);
                        flatBufferBuilder.a(5, this.f15509f);
                        flatBufferBuilder.a(6, this.f15510g);
                        flatBufferBuilder.b(7, a3);
                        flatBufferBuilder.b(8, a4);
                        flatBufferBuilder.b(9, b);
                        flatBufferBuilder.a(10, this.f15514k);
                        flatBufferBuilder.b(11, a5);
                        flatBufferBuilder.b(12, b2);
                        flatBufferBuilder.b(13, a6);
                        flatBufferBuilder.b(14, a7);
                        flatBufferBuilder.b(15, a8);
                        flatBufferBuilder.b(16, a9);
                        flatBufferBuilder.b(17, a10);
                        flatBufferBuilder.b(18, a11);
                        flatBufferBuilder.b(19, a12);
                        flatBufferBuilder.b(20, b3);
                        flatBufferBuilder.b(21, a13);
                        flatBufferBuilder.b(22, a14);
                        flatBufferBuilder.b(23, a15);
                        flatBufferBuilder.a(24, this.f15528y);
                        flatBufferBuilder.b(25, a16);
                        flatBufferBuilder.b(26, a17);
                        flatBufferBuilder.b(27, a18);
                        flatBufferBuilder.b(28, a19);
                        flatBufferBuilder.b(29, c2);
                        flatBufferBuilder.a(30, this.f15499E);
                        flatBufferBuilder.b(31, c3);
                        flatBufferBuilder.b(32, a20);
                        flatBufferBuilder.b(33, c4);
                        flatBufferBuilder.b(34, a21);
                        flatBufferBuilder.d(flatBufferBuilder.d());
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        return new NodeModel(new MutableFlatBuffer(wrap, null, null, true, null));
                    }
                }

                /* compiled from: device_family */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(NodeModel.class, new Deserializer());
                    }

                    public Object m18055a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(NearbyPlacesNewBrowsePlaceHugeResultsConnectionFragmentParser.EdgesParser.NodeParser.m18368a(jsonParser, flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        mutableFlatBuffer.a(4, Boolean.valueOf(true));
                        MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                        Object nodeModel = new NodeModel();
                        ((BaseModel) nodeModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                        if (nodeModel instanceof Postprocessable) {
                            return ((Postprocessable) nodeModel).a();
                        }
                        return nodeModel;
                    }
                }

                /* compiled from: device_family */
                public class Serializer extends JsonSerializer<NodeModel> {
                    public final void m18056a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        NodeModel nodeModel = (NodeModel) obj;
                        if (nodeModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(nodeModel.m18082a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            nodeModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        NearbyPlacesNewBrowsePlaceHugeResultsConnectionFragmentParser.EdgesParser.NodeParser.m18369a(nodeModel.w_(), nodeModel.u_(), jsonGenerator, serializerProvider);
                    }

                    static {
                        FbSerializerProvider.a(NodeModel.class, new Serializer());
                    }
                }

                @Nullable
                public final /* synthetic */ RatersModel mo920B() {
                    return m18067V();
                }

                @Nullable
                public final /* synthetic */ NearbyRecommendationsConnectionFragmentModel mo921C() {
                    return m18068W();
                }

                @Nullable
                public final /* synthetic */ AddressModel mo930b() {
                    return m18057L();
                }

                @Nullable
                public final /* synthetic */ FriendsWhoVisitedModel mo934j() {
                    return m18058M();
                }

                @Nullable
                public final /* synthetic */ LocationModel mo941n() {
                    return m18059N();
                }

                @Nullable
                public final /* synthetic */ OverallStarRatingModel mo943p() {
                    return m18060O();
                }

                @Nullable
                public final /* synthetic */ PageLikersModel mo944q() {
                    return m18061P();
                }

                @Nullable
                public final /* synthetic */ PageVisitsModel mo945r() {
                    return m18062Q();
                }

                @Nullable
                public final /* synthetic */ PlaceOpenStatusModel mo947t() {
                    return m18063R();
                }

                @Nullable
                public final /* synthetic */ BrowseNearbyPlacesFullImageFragmentModel mo951x() {
                    return m18064S();
                }

                @Nullable
                public final /* synthetic */ BrowseNearbyPlacesFullImageFragmentModel mo952y() {
                    return m18065T();
                }

                @Nullable
                public final /* synthetic */ ProfilePhotoModel mo953z() {
                    return m18066U();
                }

                public NodeModel() {
                    super(35);
                }

                public NodeModel(MutableFlatBuffer mutableFlatBuffer) {
                    super(35);
                    a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }

                public final void m18086a(String str, ConsistencyTuple consistencyTuple) {
                    if ("does_viewer_like".equals(str)) {
                        consistencyTuple.a = Boolean.valueOf(jZ_());
                        consistencyTuple.b = u_();
                        consistencyTuple.c = 5;
                        return;
                    }
                    consistencyTuple.a();
                }

                public final void m18087a(String str, Object obj, boolean z) {
                    if ("does_viewer_like".equals(str)) {
                        m18070a(((Boolean) obj).booleanValue());
                    }
                }

                @Nullable
                private AddressModel m18057L() {
                    this.f15542d = (AddressModel) super.a(this.f15542d, 0, AddressModel.class);
                    return this.f15542d;
                }

                public final boolean mo931c() {
                    a(0, 1);
                    return this.f15543e;
                }

                public final boolean mo932d() {
                    a(0, 2);
                    return this.f15544f;
                }

                @Nonnull
                public final ImmutableList<String> jY_() {
                    this.f15545g = super.a(this.f15545g, 3);
                    return (ImmutableList) this.f15545g;
                }

                @Nullable
                public final GraphQLPageCategoryType mo933g() {
                    this.f15546h = (GraphQLPageCategoryType) super.b(this.f15546h, 4, GraphQLPageCategoryType.class, GraphQLPageCategoryType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
                    return this.f15546h;
                }

                public final boolean jZ_() {
                    a(0, 5);
                    return this.f15547i;
                }

                private void m18070a(boolean z) {
                    this.f15547i = z;
                    if (this.b != null && this.b.d) {
                        this.b.a(this.c, 5, z);
                    }
                }

                public final boolean ka_() {
                    a(0, 6);
                    return this.f15548j;
                }

                @Nullable
                private FriendsWhoVisitedModel m18058M() {
                    this.f15549k = (FriendsWhoVisitedModel) super.a(this.f15549k, 7, FriendsWhoVisitedModel.class);
                    return this.f15549k;
                }

                @Nonnull
                public final ImmutableList<HoursModel> mo937k() {
                    this.f15550l = super.a(this.f15550l, 8, HoursModel.class);
                    return (ImmutableList) this.f15550l;
                }

                @Nullable
                public final String mo939l() {
                    this.f15551m = super.a(this.f15551m, 9);
                    return this.f15551m;
                }

                public final boolean mo940m() {
                    a(1, 2);
                    return this.f15552n;
                }

                @Nullable
                private LocationModel m18059N() {
                    this.f15553o = (LocationModel) super.a(this.f15553o, 11, LocationModel.class);
                    return this.f15553o;
                }

                @Nullable
                public final String mo942o() {
                    this.f15554p = super.a(this.f15554p, 12);
                    return this.f15554p;
                }

                @Nullable
                private OverallStarRatingModel m18060O() {
                    this.f15555q = (OverallStarRatingModel) super.a(this.f15555q, 13, OverallStarRatingModel.class);
                    return this.f15555q;
                }

                @Nullable
                private PageLikersModel m18061P() {
                    this.f15556r = (PageLikersModel) super.a(this.f15556r, 14, PageLikersModel.class);
                    return this.f15556r;
                }

                @Nullable
                private PageVisitsModel m18062Q() {
                    this.f15557s = (PageVisitsModel) super.a(this.f15557s, 15, PageVisitsModel.class);
                    return this.f15557s;
                }

                @Nullable
                public final GraphQLPermanentlyClosedStatus mo946s() {
                    this.f15558t = (GraphQLPermanentlyClosedStatus) super.b(this.f15558t, 16, GraphQLPermanentlyClosedStatus.class, GraphQLPermanentlyClosedStatus.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
                    return this.f15558t;
                }

                @Nullable
                private PlaceOpenStatusModel m18063R() {
                    this.f15559u = (PlaceOpenStatusModel) super.a(this.f15559u, 17, PlaceOpenStatusModel.class);
                    return this.f15559u;
                }

                @Nullable
                public final GraphQLPageOpenHoursDisplayDecisionEnum mo948u() {
                    this.f15560v = (GraphQLPageOpenHoursDisplayDecisionEnum) super.b(this.f15560v, 18, GraphQLPageOpenHoursDisplayDecisionEnum.class, GraphQLPageOpenHoursDisplayDecisionEnum.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
                    return this.f15560v;
                }

                @Nullable
                public final GraphQLPlaceType mo949v() {
                    this.f15561w = (GraphQLPlaceType) super.b(this.f15561w, 19, GraphQLPlaceType.class, GraphQLPlaceType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
                    return this.f15561w;
                }

                @Nullable
                public final String mo950w() {
                    this.f15562x = super.a(this.f15562x, 20);
                    return this.f15562x;
                }

                @Nullable
                private BrowseNearbyPlacesFullImageFragmentModel m18064S() {
                    this.f15563y = (BrowseNearbyPlacesFullImageFragmentModel) super.a(this.f15563y, 21, BrowseNearbyPlacesFullImageFragmentModel.class);
                    return this.f15563y;
                }

                @Nullable
                private BrowseNearbyPlacesFullImageFragmentModel m18065T() {
                    this.f15564z = (BrowseNearbyPlacesFullImageFragmentModel) super.a(this.f15564z, 22, BrowseNearbyPlacesFullImageFragmentModel.class);
                    return this.f15564z;
                }

                @Nullable
                private ProfilePhotoModel m18066U() {
                    this.f15530A = (ProfilePhotoModel) super.a(this.f15530A, 23, ProfilePhotoModel.class);
                    return this.f15530A;
                }

                public final boolean mo919A() {
                    a(3, 0);
                    return this.f15531B;
                }

                @Nullable
                private RatersModel m18067V() {
                    this.f15532C = (RatersModel) super.a(this.f15532C, 25, RatersModel.class);
                    return this.f15532C;
                }

                @Nullable
                private NearbyRecommendationsConnectionFragmentModel m18068W() {
                    this.f15533D = (NearbyRecommendationsConnectionFragmentModel) super.a(this.f15533D, 26, NearbyRecommendationsConnectionFragmentModel.class);
                    return this.f15533D;
                }

                @Nonnull
                public final ImmutableList<RedirectionInfoModel> mo922D() {
                    this.f15534E = super.a(this.f15534E, 27, RedirectionInfoModel.class);
                    return (ImmutableList) this.f15534E;
                }

                @Nonnull
                public final ImmutableList<Photo320FragmentModel> mo923E() {
                    this.f15535F = super.a(this.f15535F, 28, Photo320FragmentModel.class);
                    return (ImmutableList) this.f15535F;
                }

                @Nonnull
                public final ImmutableList<String> mo924F() {
                    this.f15536G = super.a(this.f15536G, 29);
                    return (ImmutableList) this.f15536G;
                }

                public final boolean mo925G() {
                    a(3, 6);
                    return this.f15537H;
                }

                @Nonnull
                public final ImmutableList<String> mo926H() {
                    this.f15538I = super.a(this.f15538I, 31);
                    return (ImmutableList) this.f15538I;
                }

                @Nullable
                public final GraphQLPageSuperCategoryType mo927I() {
                    this.f15539J = (GraphQLPageSuperCategoryType) super.b(this.f15539J, 32, GraphQLPageSuperCategoryType.class, GraphQLPageSuperCategoryType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
                    return this.f15539J;
                }

                @Nonnull
                public final ImmutableList<String> mo928J() {
                    this.f15540K = super.a(this.f15540K, 33);
                    return (ImmutableList) this.f15540K;
                }

                @Nullable
                public final GraphQLSavedState mo929K() {
                    this.f15541L = (GraphQLSavedState) super.b(this.f15541L, 34, GraphQLSavedState.class, GraphQLSavedState.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
                    return this.f15541L;
                }

                public static NodeModel m18069a(NodeModel nodeModel) {
                    int i = 0;
                    if (nodeModel == null) {
                        return null;
                    }
                    if (nodeModel instanceof NodeModel) {
                        return nodeModel;
                    }
                    int i2;
                    int i3;
                    Builder builder = new Builder();
                    builder.f15504a = AddressModel.m17834a(nodeModel.mo930b());
                    builder.f15505b = nodeModel.mo931c();
                    builder.f15506c = nodeModel.mo932d();
                    com.google.common.collect.ImmutableList.Builder builder2 = ImmutableList.builder();
                    for (i2 = 0; i2 < nodeModel.jY_().size(); i2++) {
                        builder2.c(nodeModel.jY_().get(i2));
                    }
                    builder.f15507d = builder2.b();
                    builder.f15508e = nodeModel.mo933g();
                    builder.f15509f = nodeModel.jZ_();
                    builder.f15510g = nodeModel.ka_();
                    builder.f15511h = FriendsWhoVisitedModel.m17962a(nodeModel.mo934j());
                    com.google.common.collect.ImmutableList.Builder builder3 = ImmutableList.builder();
                    for (i3 = 0; i3 < nodeModel.mo937k().size(); i3++) {
                        builder3.c(HoursModel.m17843a((HoursModel) nodeModel.mo937k().get(i3)));
                    }
                    builder.f15512i = builder3.b();
                    builder.f15513j = nodeModel.mo939l();
                    builder.f15514k = nodeModel.mo940m();
                    builder.f15515l = LocationModel.m17852a(nodeModel.mo941n());
                    builder.f15516m = nodeModel.mo942o();
                    builder.f15517n = OverallStarRatingModel.m17861a(nodeModel.mo943p());
                    builder.f15518o = PageLikersModel.m17870a(nodeModel.mo944q());
                    builder.f15519p = PageVisitsModel.m17877a(nodeModel.mo945r());
                    builder.f15520q = nodeModel.mo946s();
                    builder.f15521r = PlaceOpenStatusModel.m17884a(nodeModel.mo947t());
                    builder.f15522s = nodeModel.mo948u();
                    builder.f15523t = nodeModel.mo949v();
                    builder.f15524u = nodeModel.mo950w();
                    builder.f15525v = BrowseNearbyPlacesFullImageFragmentModel.m17800a(nodeModel.mo951x());
                    builder.f15526w = BrowseNearbyPlacesFullImageFragmentModel.m17800a(nodeModel.mo952y());
                    builder.f15527x = ProfilePhotoModel.m18213a(nodeModel.mo953z());
                    builder.f15528y = nodeModel.mo919A();
                    builder.f15529z = RatersModel.m17890a(nodeModel.mo920B());
                    builder.f15495A = NearbyRecommendationsConnectionFragmentModel.m18251a(nodeModel.mo921C());
                    builder3 = ImmutableList.builder();
                    for (i3 = 0; i3 < nodeModel.mo922D().size(); i3++) {
                        builder3.c(RedirectionInfoModel.m18270a((RedirectionInfoModel) nodeModel.mo922D().get(i3)));
                    }
                    builder.f15496B = builder3.b();
                    builder3 = ImmutableList.builder();
                    for (i3 = 0; i3 < nodeModel.mo923E().size(); i3++) {
                        builder3.c(Photo320FragmentModel.m18288a((Photo320FragmentModel) nodeModel.mo923E().get(i3)));
                    }
                    builder.f15497C = builder3.b();
                    builder2 = ImmutableList.builder();
                    for (i2 = 0; i2 < nodeModel.mo924F().size(); i2++) {
                        builder2.c(nodeModel.mo924F().get(i2));
                    }
                    builder.f15498D = builder2.b();
                    builder.f15499E = nodeModel.mo925G();
                    builder2 = ImmutableList.builder();
                    for (i2 = 0; i2 < nodeModel.mo926H().size(); i2++) {
                        builder2.c(nodeModel.mo926H().get(i2));
                    }
                    builder.f15500F = builder2.b();
                    builder.f15501G = nodeModel.mo927I();
                    com.google.common.collect.ImmutableList.Builder builder4 = ImmutableList.builder();
                    while (i < nodeModel.mo928J().size()) {
                        builder4.c(nodeModel.mo928J().get(i));
                        i++;
                    }
                    builder.f15502H = builder4.b();
                    builder.f15503I = nodeModel.mo929K();
                    return builder.m18054a();
                }

                @Nullable
                public final String m18084a() {
                    return mo939l();
                }

                public final int jK_() {
                    return 2479791;
                }

                public final GraphQLVisitableModel m18083a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    com.google.common.collect.ImmutableList.Builder a;
                    BrowseNearbyPlacesFullImageFragmentModel browseNearbyPlacesFullImageFragmentModel;
                    GraphQLVisitableModel graphQLVisitableModel = null;
                    h();
                    if (m18057L() != null) {
                        AddressModel addressModel = (AddressModel) graphQLModelMutatingVisitor.b(m18057L());
                        if (m18057L() != addressModel) {
                            graphQLVisitableModel = (NodeModel) ModelHelper.a(null, this);
                            graphQLVisitableModel.f15542d = addressModel;
                        }
                    }
                    if (m18058M() != null) {
                        FriendsWhoVisitedModel friendsWhoVisitedModel = (FriendsWhoVisitedModel) graphQLModelMutatingVisitor.b(m18058M());
                        if (m18058M() != friendsWhoVisitedModel) {
                            graphQLVisitableModel = (NodeModel) ModelHelper.a(graphQLVisitableModel, this);
                            graphQLVisitableModel.f15549k = friendsWhoVisitedModel;
                        }
                    }
                    if (mo937k() != null) {
                        a = ModelHelper.a(mo937k(), graphQLModelMutatingVisitor);
                        if (a != null) {
                            NodeModel nodeModel = (NodeModel) ModelHelper.a(graphQLVisitableModel, this);
                            nodeModel.f15550l = a.b();
                            graphQLVisitableModel = nodeModel;
                        }
                    }
                    if (m18059N() != null) {
                        LocationModel locationModel = (LocationModel) graphQLModelMutatingVisitor.b(m18059N());
                        if (m18059N() != locationModel) {
                            graphQLVisitableModel = (NodeModel) ModelHelper.a(graphQLVisitableModel, this);
                            graphQLVisitableModel.f15553o = locationModel;
                        }
                    }
                    if (m18060O() != null) {
                        OverallStarRatingModel overallStarRatingModel = (OverallStarRatingModel) graphQLModelMutatingVisitor.b(m18060O());
                        if (m18060O() != overallStarRatingModel) {
                            graphQLVisitableModel = (NodeModel) ModelHelper.a(graphQLVisitableModel, this);
                            graphQLVisitableModel.f15555q = overallStarRatingModel;
                        }
                    }
                    if (m18061P() != null) {
                        PageLikersModel pageLikersModel = (PageLikersModel) graphQLModelMutatingVisitor.b(m18061P());
                        if (m18061P() != pageLikersModel) {
                            graphQLVisitableModel = (NodeModel) ModelHelper.a(graphQLVisitableModel, this);
                            graphQLVisitableModel.f15556r = pageLikersModel;
                        }
                    }
                    if (m18062Q() != null) {
                        PageVisitsModel pageVisitsModel = (PageVisitsModel) graphQLModelMutatingVisitor.b(m18062Q());
                        if (m18062Q() != pageVisitsModel) {
                            graphQLVisitableModel = (NodeModel) ModelHelper.a(graphQLVisitableModel, this);
                            graphQLVisitableModel.f15557s = pageVisitsModel;
                        }
                    }
                    if (m18063R() != null) {
                        PlaceOpenStatusModel placeOpenStatusModel = (PlaceOpenStatusModel) graphQLModelMutatingVisitor.b(m18063R());
                        if (m18063R() != placeOpenStatusModel) {
                            graphQLVisitableModel = (NodeModel) ModelHelper.a(graphQLVisitableModel, this);
                            graphQLVisitableModel.f15559u = placeOpenStatusModel;
                        }
                    }
                    if (m18064S() != null) {
                        browseNearbyPlacesFullImageFragmentModel = (BrowseNearbyPlacesFullImageFragmentModel) graphQLModelMutatingVisitor.b(m18064S());
                        if (m18064S() != browseNearbyPlacesFullImageFragmentModel) {
                            graphQLVisitableModel = (NodeModel) ModelHelper.a(graphQLVisitableModel, this);
                            graphQLVisitableModel.f15563y = browseNearbyPlacesFullImageFragmentModel;
                        }
                    }
                    if (m18065T() != null) {
                        browseNearbyPlacesFullImageFragmentModel = (BrowseNearbyPlacesFullImageFragmentModel) graphQLModelMutatingVisitor.b(m18065T());
                        if (m18065T() != browseNearbyPlacesFullImageFragmentModel) {
                            graphQLVisitableModel = (NodeModel) ModelHelper.a(graphQLVisitableModel, this);
                            graphQLVisitableModel.f15564z = browseNearbyPlacesFullImageFragmentModel;
                        }
                    }
                    if (m18066U() != null) {
                        ProfilePhotoModel profilePhotoModel = (ProfilePhotoModel) graphQLModelMutatingVisitor.b(m18066U());
                        if (m18066U() != profilePhotoModel) {
                            graphQLVisitableModel = (NodeModel) ModelHelper.a(graphQLVisitableModel, this);
                            graphQLVisitableModel.f15530A = profilePhotoModel;
                        }
                    }
                    if (m18067V() != null) {
                        RatersModel ratersModel = (RatersModel) graphQLModelMutatingVisitor.b(m18067V());
                        if (m18067V() != ratersModel) {
                            graphQLVisitableModel = (NodeModel) ModelHelper.a(graphQLVisitableModel, this);
                            graphQLVisitableModel.f15532C = ratersModel;
                        }
                    }
                    if (m18068W() != null) {
                        NearbyRecommendationsConnectionFragmentModel nearbyRecommendationsConnectionFragmentModel = (NearbyRecommendationsConnectionFragmentModel) graphQLModelMutatingVisitor.b(m18068W());
                        if (m18068W() != nearbyRecommendationsConnectionFragmentModel) {
                            graphQLVisitableModel = (NodeModel) ModelHelper.a(graphQLVisitableModel, this);
                            graphQLVisitableModel.f15533D = nearbyRecommendationsConnectionFragmentModel;
                        }
                    }
                    if (mo922D() != null) {
                        a = ModelHelper.a(mo922D(), graphQLModelMutatingVisitor);
                        if (a != null) {
                            nodeModel = (NodeModel) ModelHelper.a(graphQLVisitableModel, this);
                            nodeModel.f15534E = a.b();
                            graphQLVisitableModel = nodeModel;
                        }
                    }
                    if (mo923E() != null) {
                        a = ModelHelper.a(mo923E(), graphQLModelMutatingVisitor);
                        if (a != null) {
                            nodeModel = (NodeModel) ModelHelper.a(graphQLVisitableModel, this);
                            nodeModel.f15535F = a.b();
                            graphQLVisitableModel = nodeModel;
                        }
                    }
                    i();
                    return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                }

                public final int m18082a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int a = ModelHelper.a(flatBufferBuilder, m18057L());
                    int c = flatBufferBuilder.c(jY_());
                    int a2 = flatBufferBuilder.a(mo933g());
                    int a3 = ModelHelper.a(flatBufferBuilder, m18058M());
                    int a4 = ModelHelper.a(flatBufferBuilder, mo937k());
                    int b = flatBufferBuilder.b(mo939l());
                    int a5 = ModelHelper.a(flatBufferBuilder, m18059N());
                    int b2 = flatBufferBuilder.b(mo942o());
                    int a6 = ModelHelper.a(flatBufferBuilder, m18060O());
                    int a7 = ModelHelper.a(flatBufferBuilder, m18061P());
                    int a8 = ModelHelper.a(flatBufferBuilder, m18062Q());
                    int a9 = flatBufferBuilder.a(mo946s());
                    int a10 = ModelHelper.a(flatBufferBuilder, m18063R());
                    int a11 = flatBufferBuilder.a(mo948u());
                    int a12 = flatBufferBuilder.a(mo949v());
                    int b3 = flatBufferBuilder.b(mo950w());
                    int a13 = ModelHelper.a(flatBufferBuilder, m18064S());
                    int a14 = ModelHelper.a(flatBufferBuilder, m18065T());
                    int a15 = ModelHelper.a(flatBufferBuilder, m18066U());
                    int a16 = ModelHelper.a(flatBufferBuilder, m18067V());
                    int a17 = ModelHelper.a(flatBufferBuilder, m18068W());
                    int a18 = ModelHelper.a(flatBufferBuilder, mo922D());
                    int a19 = ModelHelper.a(flatBufferBuilder, mo923E());
                    int c2 = flatBufferBuilder.c(mo924F());
                    int c3 = flatBufferBuilder.c(mo926H());
                    int a20 = flatBufferBuilder.a(mo927I());
                    int c4 = flatBufferBuilder.c(mo928J());
                    int a21 = flatBufferBuilder.a(mo929K());
                    flatBufferBuilder.c(35);
                    flatBufferBuilder.b(0, a);
                    flatBufferBuilder.a(1, this.f15543e);
                    flatBufferBuilder.a(2, this.f15544f);
                    flatBufferBuilder.b(3, c);
                    flatBufferBuilder.b(4, a2);
                    flatBufferBuilder.a(5, this.f15547i);
                    flatBufferBuilder.a(6, this.f15548j);
                    flatBufferBuilder.b(7, a3);
                    flatBufferBuilder.b(8, a4);
                    flatBufferBuilder.b(9, b);
                    flatBufferBuilder.a(10, this.f15552n);
                    flatBufferBuilder.b(11, a5);
                    flatBufferBuilder.b(12, b2);
                    flatBufferBuilder.b(13, a6);
                    flatBufferBuilder.b(14, a7);
                    flatBufferBuilder.b(15, a8);
                    flatBufferBuilder.b(16, a9);
                    flatBufferBuilder.b(17, a10);
                    flatBufferBuilder.b(18, a11);
                    flatBufferBuilder.b(19, a12);
                    flatBufferBuilder.b(20, b3);
                    flatBufferBuilder.b(21, a13);
                    flatBufferBuilder.b(22, a14);
                    flatBufferBuilder.b(23, a15);
                    flatBufferBuilder.a(24, this.f15531B);
                    flatBufferBuilder.b(25, a16);
                    flatBufferBuilder.b(26, a17);
                    flatBufferBuilder.b(27, a18);
                    flatBufferBuilder.b(28, a19);
                    flatBufferBuilder.b(29, c2);
                    flatBufferBuilder.a(30, this.f15537H);
                    flatBufferBuilder.b(31, c3);
                    flatBufferBuilder.b(32, a20);
                    flatBufferBuilder.b(33, c4);
                    flatBufferBuilder.b(34, a21);
                    i();
                    return flatBufferBuilder.d();
                }

                public final void m18085a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                    super.a(mutableFlatBuffer, i, obj);
                    this.f15543e = mutableFlatBuffer.a(i, 1);
                    this.f15544f = mutableFlatBuffer.a(i, 2);
                    this.f15547i = mutableFlatBuffer.a(i, 5);
                    this.f15548j = mutableFlatBuffer.a(i, 6);
                    this.f15552n = mutableFlatBuffer.a(i, 10);
                    this.f15531B = mutableFlatBuffer.a(i, 24);
                    this.f15537H = mutableFlatBuffer.a(i, 30);
                }
            }

            /* compiled from: device_family */
            public class Serializer extends JsonSerializer<EdgesModel> {
                public final void m18109a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    EdgesModel edgesModel = (EdgesModel) obj;
                    if (edgesModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(edgesModel.m18111a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        edgesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    NearbyPlacesNewBrowsePlaceHugeResultsConnectionFragmentParser.EdgesParser.m18371b(edgesModel.w_(), edgesModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(EdgesModel.class, new Serializer());
                }
            }

            @Nullable
            public final /* synthetic */ NodeModel m18113a() {
                return m18114j();
            }

            public EdgesModel() {
                super(1);
            }

            public EdgesModel(MutableFlatBuffer mutableFlatBuffer) {
                super(1);
                a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
            }

            @Nullable
            public final NodeModel m18114j() {
                this.f15565d = (NodeModel) super.a(this.f15565d, 0, NodeModel.class);
                return this.f15565d;
            }

            public static EdgesModel m18110a(EdgesModel edgesModel) {
                if (edgesModel == null) {
                    return null;
                }
                if (edgesModel instanceof EdgesModel) {
                    return edgesModel;
                }
                Builder builder = new Builder();
                builder.f15494a = NodeModel.m18069a(edgesModel.m18113a());
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                int a = ModelHelper.a(flatBufferBuilder, builder.f15494a);
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.d(flatBufferBuilder.d());
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                return new EdgesModel(new MutableFlatBuffer(wrap, null, null, true, null));
            }

            public final int jK_() {
                return -185989215;
            }

            public final GraphQLVisitableModel m18112a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m18114j() != null) {
                    NodeModel nodeModel = (NodeModel) graphQLModelMutatingVisitor.b(m18114j());
                    if (m18114j() != nodeModel) {
                        graphQLVisitableModel = (EdgesModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f15565d = nodeModel;
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m18111a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m18114j());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, a);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: device_family */
        public class Serializer extends JsonSerializer<NearbyPlacesNewBrowsePlaceHugeResultsConnectionFragmentModel> {
            public final void m18115a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                NearbyPlacesNewBrowsePlaceHugeResultsConnectionFragmentModel nearbyPlacesNewBrowsePlaceHugeResultsConnectionFragmentModel = (NearbyPlacesNewBrowsePlaceHugeResultsConnectionFragmentModel) obj;
                if (nearbyPlacesNewBrowsePlaceHugeResultsConnectionFragmentModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(nearbyPlacesNewBrowsePlaceHugeResultsConnectionFragmentModel.m18117a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    nearbyPlacesNewBrowsePlaceHugeResultsConnectionFragmentModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                NearbyPlacesNewBrowsePlaceHugeResultsConnectionFragmentParser.m18373a(nearbyPlacesNewBrowsePlaceHugeResultsConnectionFragmentModel.w_(), nearbyPlacesNewBrowsePlaceHugeResultsConnectionFragmentModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(NearbyPlacesNewBrowsePlaceHugeResultsConnectionFragmentModel.class, new Serializer());
            }
        }

        @Nullable
        public final /* synthetic */ GeoRectangleFragmentModel m18119a() {
            return m18123j();
        }

        @Nullable
        public final /* synthetic */ PageInfoModel m18121c() {
            return m18124k();
        }

        public NearbyPlacesNewBrowsePlaceHugeResultsConnectionFragmentModel() {
            super(4);
        }

        public NearbyPlacesNewBrowsePlaceHugeResultsConnectionFragmentModel(MutableFlatBuffer mutableFlatBuffer) {
            super(4);
            a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
        }

        @Nullable
        public final GeoRectangleFragmentModel m18123j() {
            this.f15566d = (GeoRectangleFragmentModel) super.a(this.f15566d, 0, GeoRectangleFragmentModel.class);
            return this.f15566d;
        }

        @Nonnull
        public final ImmutableList<EdgesModel> m18120b() {
            this.f15567e = super.a(this.f15567e, 1, EdgesModel.class);
            return (ImmutableList) this.f15567e;
        }

        @Nullable
        public final PageInfoModel m18124k() {
            this.f15568f = (PageInfoModel) super.a(this.f15568f, 2, PageInfoModel.class);
            return this.f15568f;
        }

        @Nullable
        public final String m18122d() {
            this.f15569g = super.a(this.f15569g, 3);
            return this.f15569g;
        }

        public static NearbyPlacesNewBrowsePlaceHugeResultsConnectionFragmentModel m18116a(NearbyPlacesNewBrowsePlaceHugeResultsConnectionFragmentModel nearbyPlacesNewBrowsePlaceHugeResultsConnectionFragmentModel) {
            if (nearbyPlacesNewBrowsePlaceHugeResultsConnectionFragmentModel == null) {
                return null;
            }
            if (nearbyPlacesNewBrowsePlaceHugeResultsConnectionFragmentModel instanceof NearbyPlacesNewBrowsePlaceHugeResultsConnectionFragmentModel) {
                return nearbyPlacesNewBrowsePlaceHugeResultsConnectionFragmentModel;
            }
            Builder builder = new Builder();
            builder.f15490a = GeoRectangleFragmentModel.m17824a(nearbyPlacesNewBrowsePlaceHugeResultsConnectionFragmentModel.m18119a());
            com.google.common.collect.ImmutableList.Builder builder2 = ImmutableList.builder();
            for (int i = 0; i < nearbyPlacesNewBrowsePlaceHugeResultsConnectionFragmentModel.m18120b().size(); i++) {
                builder2.c(EdgesModel.m18110a((EdgesModel) nearbyPlacesNewBrowsePlaceHugeResultsConnectionFragmentModel.m18120b().get(i)));
            }
            builder.f15491b = builder2.b();
            builder.f15492c = PageInfoModel.m18042a(nearbyPlacesNewBrowsePlaceHugeResultsConnectionFragmentModel.m18121c());
            builder.f15493d = nearbyPlacesNewBrowsePlaceHugeResultsConnectionFragmentModel.m18122d();
            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
            int a = ModelHelper.a(flatBufferBuilder, builder.f15490a);
            int a2 = ModelHelper.a(flatBufferBuilder, builder.f15491b);
            int a3 = ModelHelper.a(flatBufferBuilder, builder.f15492c);
            int b = flatBufferBuilder.b(builder.f15493d);
            flatBufferBuilder.c(4);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, a2);
            flatBufferBuilder.b(2, a3);
            flatBufferBuilder.b(3, b);
            flatBufferBuilder.d(flatBufferBuilder.d());
            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
            wrap.position(0);
            return new NearbyPlacesNewBrowsePlaceHugeResultsConnectionFragmentModel(new MutableFlatBuffer(wrap, null, null, true, null));
        }

        public final int jK_() {
            return -1988813374;
        }

        public final GraphQLVisitableModel m18118a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m18123j() != null) {
                GeoRectangleFragmentModel geoRectangleFragmentModel = (GeoRectangleFragmentModel) graphQLModelMutatingVisitor.b(m18123j());
                if (m18123j() != geoRectangleFragmentModel) {
                    graphQLVisitableModel = (NearbyPlacesNewBrowsePlaceHugeResultsConnectionFragmentModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f15566d = geoRectangleFragmentModel;
                }
            }
            if (m18120b() != null) {
                com.google.common.collect.ImmutableList.Builder a = ModelHelper.a(m18120b(), graphQLModelMutatingVisitor);
                if (a != null) {
                    NearbyPlacesNewBrowsePlaceHugeResultsConnectionFragmentModel nearbyPlacesNewBrowsePlaceHugeResultsConnectionFragmentModel = (NearbyPlacesNewBrowsePlaceHugeResultsConnectionFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                    nearbyPlacesNewBrowsePlaceHugeResultsConnectionFragmentModel.f15567e = a.b();
                    graphQLVisitableModel = nearbyPlacesNewBrowsePlaceHugeResultsConnectionFragmentModel;
                }
            }
            if (m18124k() != null) {
                PageInfoModel pageInfoModel = (PageInfoModel) graphQLModelMutatingVisitor.b(m18124k());
                if (m18124k() != pageInfoModel) {
                    graphQLVisitableModel = (NearbyPlacesNewBrowsePlaceHugeResultsConnectionFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f15568f = pageInfoModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m18117a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m18123j());
            int a2 = ModelHelper.a(flatBufferBuilder, m18120b());
            int a3 = ModelHelper.a(flatBufferBuilder, m18124k());
            int b = flatBufferBuilder.b(m18122d());
            flatBufferBuilder.c(4);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, a2);
            flatBufferBuilder.b(2, a3);
            flatBufferBuilder.b(3, b);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -272244361)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: device_family */
    public final class NearbyPlacesOldBrowseOldResultConnectionFragmentModel extends BaseModel implements GraphQLVisitableModel {
        private int f15602d;
        @Nullable
        private GeoRectangleFragmentModel f15603e;
        @Nullable
        private List<EdgesModel> f15604f;

        /* compiled from: device_family */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(NearbyPlacesOldBrowseOldResultConnectionFragmentModel.class, new Deserializer());
            }

            public Object m18125a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(NearbyPlacesOldBrowseOldResultConnectionFragmentParser.m18378a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object nearbyPlacesOldBrowseOldResultConnectionFragmentModel = new NearbyPlacesOldBrowseOldResultConnectionFragmentModel();
                ((BaseModel) nearbyPlacesOldBrowseOldResultConnectionFragmentModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (nearbyPlacesOldBrowseOldResultConnectionFragmentModel instanceof Postprocessable) {
                    return ((Postprocessable) nearbyPlacesOldBrowseOldResultConnectionFragmentModel).a();
                }
                return nearbyPlacesOldBrowseOldResultConnectionFragmentModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -917320654)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: device_family */
        public final class EdgesModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private NodeModel f15601d;

            /* compiled from: device_family */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(EdgesModel.class, new Deserializer());
                }

                public Object m18126a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(NearbyPlacesOldBrowseOldResultConnectionFragmentParser.EdgesParser.m18376b(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object edgesModel = new EdgesModel();
                    ((BaseModel) edgesModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (edgesModel instanceof Postprocessable) {
                        return ((Postprocessable) edgesModel).a();
                    }
                    return edgesModel;
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = 236045212)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: device_family */
            public final class NodeModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel, NearbyPagePlaceInfoFragment {
                private boolean f15570A;
                @Nullable
                private RatersModel f15571B;
                @Nullable
                private List<RedirectionInfoModel> f15572C;
                @Nullable
                private List<String> f15573D;
                private boolean f15574E;
                @Nullable
                private GraphQLPageSuperCategoryType f15575F;
                @Nullable
                private List<String> f15576G;
                @Nullable
                private GraphQLSavedState f15577H;
                @Nullable
                private AddressModel f15578d;
                private boolean f15579e;
                private boolean f15580f;
                @Nullable
                private List<String> f15581g;
                @Nullable
                private GraphQLPageCategoryType f15582h;
                private boolean f15583i;
                private boolean f15584j;
                @Nullable
                private FriendsWhoVisitedModel f15585k;
                @Nullable
                private List<HoursModel> f15586l;
                @Nullable
                private String f15587m;
                private boolean f15588n;
                @Nullable
                private LocationModel f15589o;
                @Nullable
                private String f15590p;
                @Nullable
                private OverallStarRatingModel f15591q;
                @Nullable
                private PageLikersModel f15592r;
                @Nullable
                private PageVisitsModel f15593s;
                @Nullable
                private GraphQLPermanentlyClosedStatus f15594t;
                @Nullable
                private PlaceOpenStatusModel f15595u;
                @Nullable
                private GraphQLPageOpenHoursDisplayDecisionEnum f15596v;
                @Nullable
                private GraphQLPlaceType f15597w;
                @Nullable
                private String f15598x;
                @Nullable
                private BrowseNearbyPlacesFullImageFragmentModel f15599y;
                @Nullable
                private BrowseNearbyPlacesFullImageFragmentModel f15600z;

                /* compiled from: device_family */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(NodeModel.class, new Deserializer());
                    }

                    public Object m18127a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(NearbyPlacesOldBrowseOldResultConnectionFragmentParser.EdgesParser.NodeParser.m18374a(jsonParser, flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        mutableFlatBuffer.a(4, Boolean.valueOf(true));
                        MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                        Object nodeModel = new NodeModel();
                        ((BaseModel) nodeModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                        if (nodeModel instanceof Postprocessable) {
                            return ((Postprocessable) nodeModel).a();
                        }
                        return nodeModel;
                    }
                }

                /* compiled from: device_family */
                public class Serializer extends JsonSerializer<NodeModel> {
                    public final void m18128a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        NodeModel nodeModel = (NodeModel) obj;
                        if (nodeModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(nodeModel.m18145a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            nodeModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        NearbyPlacesOldBrowseOldResultConnectionFragmentParser.EdgesParser.NodeParser.m18375a(nodeModel.w_(), nodeModel.u_(), jsonGenerator, serializerProvider);
                    }

                    static {
                        FbSerializerProvider.a(NodeModel.class, new Serializer());
                    }
                }

                public NodeModel() {
                    super(31);
                }

                public final void m18149a(String str, ConsistencyTuple consistencyTuple) {
                    if ("does_viewer_like".equals(str)) {
                        consistencyTuple.a = Boolean.valueOf(m18142x());
                        consistencyTuple.b = u_();
                        consistencyTuple.c = 5;
                        return;
                    }
                    consistencyTuple.a();
                }

                public final void m18150a(String str, Object obj, boolean z) {
                    if ("does_viewer_like".equals(str)) {
                        m18138a(((Boolean) obj).booleanValue());
                    }
                }

                @Nullable
                private AddressModel m18139u() {
                    this.f15578d = (AddressModel) super.a(this.f15578d, 0, AddressModel.class);
                    return this.f15578d;
                }

                @Nonnull
                private ImmutableList<String> m18140v() {
                    this.f15581g = super.a(this.f15581g, 3);
                    return (ImmutableList) this.f15581g;
                }

                @Nullable
                private GraphQLPageCategoryType m18141w() {
                    this.f15582h = (GraphQLPageCategoryType) super.b(this.f15582h, 4, GraphQLPageCategoryType.class, GraphQLPageCategoryType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
                    return this.f15582h;
                }

                private boolean m18142x() {
                    a(0, 5);
                    return this.f15583i;
                }

                private void m18138a(boolean z) {
                    this.f15583i = z;
                    if (this.b != null && this.b.d) {
                        this.b.a(this.c, 5, z);
                    }
                }

                @Nullable
                public final FriendsWhoVisitedModel m18151j() {
                    this.f15585k = (FriendsWhoVisitedModel) super.a(this.f15585k, 7, FriendsWhoVisitedModel.class);
                    return this.f15585k;
                }

                @Nonnull
                private ImmutableList<HoursModel> m18143y() {
                    this.f15586l = super.a(this.f15586l, 8, HoursModel.class);
                    return (ImmutableList) this.f15586l;
                }

                @Nullable
                public final String m18152k() {
                    this.f15587m = super.a(this.f15587m, 9);
                    return this.f15587m;
                }

                @Nullable
                public final LocationModel m18153l() {
                    this.f15589o = (LocationModel) super.a(this.f15589o, 11, LocationModel.class);
                    return this.f15589o;
                }

                @Nullable
                public final String m18154m() {
                    this.f15590p = super.a(this.f15590p, 12);
                    return this.f15590p;
                }

                @Nullable
                public final OverallStarRatingModel m18155n() {
                    this.f15591q = (OverallStarRatingModel) super.a(this.f15591q, 13, OverallStarRatingModel.class);
                    return this.f15591q;
                }

                @Nullable
                private PageLikersModel m18144z() {
                    this.f15592r = (PageLikersModel) super.a(this.f15592r, 14, PageLikersModel.class);
                    return this.f15592r;
                }

                @Nullable
                public final PageVisitsModel m18156o() {
                    this.f15593s = (PageVisitsModel) super.a(this.f15593s, 15, PageVisitsModel.class);
                    return this.f15593s;
                }

                @Nullable
                public final GraphQLPermanentlyClosedStatus m18157p() {
                    this.f15594t = (GraphQLPermanentlyClosedStatus) super.b(this.f15594t, 16, GraphQLPermanentlyClosedStatus.class, GraphQLPermanentlyClosedStatus.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
                    return this.f15594t;
                }

                @Nullable
                private PlaceOpenStatusModel m18129A() {
                    this.f15595u = (PlaceOpenStatusModel) super.a(this.f15595u, 17, PlaceOpenStatusModel.class);
                    return this.f15595u;
                }

                @Nullable
                private GraphQLPageOpenHoursDisplayDecisionEnum m18130B() {
                    this.f15596v = (GraphQLPageOpenHoursDisplayDecisionEnum) super.b(this.f15596v, 18, GraphQLPageOpenHoursDisplayDecisionEnum.class, GraphQLPageOpenHoursDisplayDecisionEnum.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
                    return this.f15596v;
                }

                @Nullable
                private GraphQLPlaceType m18131C() {
                    this.f15597w = (GraphQLPlaceType) super.b(this.f15597w, 19, GraphQLPlaceType.class, GraphQLPlaceType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
                    return this.f15597w;
                }

                @Nullable
                private String m18132D() {
                    this.f15598x = super.a(this.f15598x, 20);
                    return this.f15598x;
                }

                @Nullable
                public final BrowseNearbyPlacesFullImageFragmentModel m18158q() {
                    this.f15599y = (BrowseNearbyPlacesFullImageFragmentModel) super.a(this.f15599y, 21, BrowseNearbyPlacesFullImageFragmentModel.class);
                    return this.f15599y;
                }

                @Nullable
                public final BrowseNearbyPlacesFullImageFragmentModel m18159r() {
                    this.f15600z = (BrowseNearbyPlacesFullImageFragmentModel) super.a(this.f15600z, 22, BrowseNearbyPlacesFullImageFragmentModel.class);
                    return this.f15600z;
                }

                public final boolean m18160s() {
                    a(2, 7);
                    return this.f15570A;
                }

                @Nullable
                private RatersModel m18133E() {
                    this.f15571B = (RatersModel) super.a(this.f15571B, 24, RatersModel.class);
                    return this.f15571B;
                }

                @Nonnull
                private ImmutableList<RedirectionInfoModel> m18134F() {
                    this.f15572C = super.a(this.f15572C, 25, RedirectionInfoModel.class);
                    return (ImmutableList) this.f15572C;
                }

                @Nonnull
                public final ImmutableList<String> m18161t() {
                    this.f15573D = super.a(this.f15573D, 26);
                    return (ImmutableList) this.f15573D;
                }

                @Nullable
                private GraphQLPageSuperCategoryType m18135G() {
                    this.f15575F = (GraphQLPageSuperCategoryType) super.b(this.f15575F, 28, GraphQLPageSuperCategoryType.class, GraphQLPageSuperCategoryType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
                    return this.f15575F;
                }

                @Nonnull
                private ImmutableList<String> m18136H() {
                    this.f15576G = super.a(this.f15576G, 29);
                    return (ImmutableList) this.f15576G;
                }

                @Nullable
                private GraphQLSavedState m18137I() {
                    this.f15577H = (GraphQLSavedState) super.b(this.f15577H, 30, GraphQLSavedState.class, GraphQLSavedState.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
                    return this.f15577H;
                }

                @Nullable
                public final String m18147a() {
                    return m18152k();
                }

                public final int jK_() {
                    return 2479791;
                }

                public final GraphQLVisitableModel m18146a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    Builder a;
                    BrowseNearbyPlacesFullImageFragmentModel browseNearbyPlacesFullImageFragmentModel;
                    GraphQLVisitableModel graphQLVisitableModel = null;
                    h();
                    if (m18139u() != null) {
                        AddressModel addressModel = (AddressModel) graphQLModelMutatingVisitor.b(m18139u());
                        if (m18139u() != addressModel) {
                            graphQLVisitableModel = (NodeModel) ModelHelper.a(null, this);
                            graphQLVisitableModel.f15578d = addressModel;
                        }
                    }
                    if (m18151j() != null) {
                        FriendsWhoVisitedModel friendsWhoVisitedModel = (FriendsWhoVisitedModel) graphQLModelMutatingVisitor.b(m18151j());
                        if (m18151j() != friendsWhoVisitedModel) {
                            graphQLVisitableModel = (NodeModel) ModelHelper.a(graphQLVisitableModel, this);
                            graphQLVisitableModel.f15585k = friendsWhoVisitedModel;
                        }
                    }
                    if (m18143y() != null) {
                        a = ModelHelper.a(m18143y(), graphQLModelMutatingVisitor);
                        if (a != null) {
                            NodeModel nodeModel = (NodeModel) ModelHelper.a(graphQLVisitableModel, this);
                            nodeModel.f15586l = a.b();
                            graphQLVisitableModel = nodeModel;
                        }
                    }
                    if (m18153l() != null) {
                        LocationModel locationModel = (LocationModel) graphQLModelMutatingVisitor.b(m18153l());
                        if (m18153l() != locationModel) {
                            graphQLVisitableModel = (NodeModel) ModelHelper.a(graphQLVisitableModel, this);
                            graphQLVisitableModel.f15589o = locationModel;
                        }
                    }
                    if (m18155n() != null) {
                        OverallStarRatingModel overallStarRatingModel = (OverallStarRatingModel) graphQLModelMutatingVisitor.b(m18155n());
                        if (m18155n() != overallStarRatingModel) {
                            graphQLVisitableModel = (NodeModel) ModelHelper.a(graphQLVisitableModel, this);
                            graphQLVisitableModel.f15591q = overallStarRatingModel;
                        }
                    }
                    if (m18144z() != null) {
                        PageLikersModel pageLikersModel = (PageLikersModel) graphQLModelMutatingVisitor.b(m18144z());
                        if (m18144z() != pageLikersModel) {
                            graphQLVisitableModel = (NodeModel) ModelHelper.a(graphQLVisitableModel, this);
                            graphQLVisitableModel.f15592r = pageLikersModel;
                        }
                    }
                    if (m18156o() != null) {
                        PageVisitsModel pageVisitsModel = (PageVisitsModel) graphQLModelMutatingVisitor.b(m18156o());
                        if (m18156o() != pageVisitsModel) {
                            graphQLVisitableModel = (NodeModel) ModelHelper.a(graphQLVisitableModel, this);
                            graphQLVisitableModel.f15593s = pageVisitsModel;
                        }
                    }
                    if (m18129A() != null) {
                        PlaceOpenStatusModel placeOpenStatusModel = (PlaceOpenStatusModel) graphQLModelMutatingVisitor.b(m18129A());
                        if (m18129A() != placeOpenStatusModel) {
                            graphQLVisitableModel = (NodeModel) ModelHelper.a(graphQLVisitableModel, this);
                            graphQLVisitableModel.f15595u = placeOpenStatusModel;
                        }
                    }
                    if (m18158q() != null) {
                        browseNearbyPlacesFullImageFragmentModel = (BrowseNearbyPlacesFullImageFragmentModel) graphQLModelMutatingVisitor.b(m18158q());
                        if (m18158q() != browseNearbyPlacesFullImageFragmentModel) {
                            graphQLVisitableModel = (NodeModel) ModelHelper.a(graphQLVisitableModel, this);
                            graphQLVisitableModel.f15599y = browseNearbyPlacesFullImageFragmentModel;
                        }
                    }
                    if (m18159r() != null) {
                        browseNearbyPlacesFullImageFragmentModel = (BrowseNearbyPlacesFullImageFragmentModel) graphQLModelMutatingVisitor.b(m18159r());
                        if (m18159r() != browseNearbyPlacesFullImageFragmentModel) {
                            graphQLVisitableModel = (NodeModel) ModelHelper.a(graphQLVisitableModel, this);
                            graphQLVisitableModel.f15600z = browseNearbyPlacesFullImageFragmentModel;
                        }
                    }
                    if (m18133E() != null) {
                        RatersModel ratersModel = (RatersModel) graphQLModelMutatingVisitor.b(m18133E());
                        if (m18133E() != ratersModel) {
                            graphQLVisitableModel = (NodeModel) ModelHelper.a(graphQLVisitableModel, this);
                            graphQLVisitableModel.f15571B = ratersModel;
                        }
                    }
                    if (m18134F() != null) {
                        a = ModelHelper.a(m18134F(), graphQLModelMutatingVisitor);
                        if (a != null) {
                            nodeModel = (NodeModel) ModelHelper.a(graphQLVisitableModel, this);
                            nodeModel.f15572C = a.b();
                            graphQLVisitableModel = nodeModel;
                        }
                    }
                    i();
                    return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                }

                public final int m18145a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int a = ModelHelper.a(flatBufferBuilder, m18139u());
                    int c = flatBufferBuilder.c(m18140v());
                    int a2 = flatBufferBuilder.a(m18141w());
                    int a3 = ModelHelper.a(flatBufferBuilder, m18151j());
                    int a4 = ModelHelper.a(flatBufferBuilder, m18143y());
                    int b = flatBufferBuilder.b(m18152k());
                    int a5 = ModelHelper.a(flatBufferBuilder, m18153l());
                    int b2 = flatBufferBuilder.b(m18154m());
                    int a6 = ModelHelper.a(flatBufferBuilder, m18155n());
                    int a7 = ModelHelper.a(flatBufferBuilder, m18144z());
                    int a8 = ModelHelper.a(flatBufferBuilder, m18156o());
                    int a9 = flatBufferBuilder.a(m18157p());
                    int a10 = ModelHelper.a(flatBufferBuilder, m18129A());
                    int a11 = flatBufferBuilder.a(m18130B());
                    int a12 = flatBufferBuilder.a(m18131C());
                    int b3 = flatBufferBuilder.b(m18132D());
                    int a13 = ModelHelper.a(flatBufferBuilder, m18158q());
                    int a14 = ModelHelper.a(flatBufferBuilder, m18159r());
                    int a15 = ModelHelper.a(flatBufferBuilder, m18133E());
                    int a16 = ModelHelper.a(flatBufferBuilder, m18134F());
                    int c2 = flatBufferBuilder.c(m18161t());
                    int a17 = flatBufferBuilder.a(m18135G());
                    int c3 = flatBufferBuilder.c(m18136H());
                    int a18 = flatBufferBuilder.a(m18137I());
                    flatBufferBuilder.c(31);
                    flatBufferBuilder.b(0, a);
                    flatBufferBuilder.a(1, this.f15579e);
                    flatBufferBuilder.a(2, this.f15580f);
                    flatBufferBuilder.b(3, c);
                    flatBufferBuilder.b(4, a2);
                    flatBufferBuilder.a(5, this.f15583i);
                    flatBufferBuilder.a(6, this.f15584j);
                    flatBufferBuilder.b(7, a3);
                    flatBufferBuilder.b(8, a4);
                    flatBufferBuilder.b(9, b);
                    flatBufferBuilder.a(10, this.f15588n);
                    flatBufferBuilder.b(11, a5);
                    flatBufferBuilder.b(12, b2);
                    flatBufferBuilder.b(13, a6);
                    flatBufferBuilder.b(14, a7);
                    flatBufferBuilder.b(15, a8);
                    flatBufferBuilder.b(16, a9);
                    flatBufferBuilder.b(17, a10);
                    flatBufferBuilder.b(18, a11);
                    flatBufferBuilder.b(19, a12);
                    flatBufferBuilder.b(20, b3);
                    flatBufferBuilder.b(21, a13);
                    flatBufferBuilder.b(22, a14);
                    flatBufferBuilder.a(23, this.f15570A);
                    flatBufferBuilder.b(24, a15);
                    flatBufferBuilder.b(25, a16);
                    flatBufferBuilder.b(26, c2);
                    flatBufferBuilder.a(27, this.f15574E);
                    flatBufferBuilder.b(28, a17);
                    flatBufferBuilder.b(29, c3);
                    flatBufferBuilder.b(30, a18);
                    i();
                    return flatBufferBuilder.d();
                }

                public final void m18148a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                    super.a(mutableFlatBuffer, i, obj);
                    this.f15579e = mutableFlatBuffer.a(i, 1);
                    this.f15580f = mutableFlatBuffer.a(i, 2);
                    this.f15583i = mutableFlatBuffer.a(i, 5);
                    this.f15584j = mutableFlatBuffer.a(i, 6);
                    this.f15588n = mutableFlatBuffer.a(i, 10);
                    this.f15570A = mutableFlatBuffer.a(i, 23);
                    this.f15574E = mutableFlatBuffer.a(i, 27);
                }
            }

            /* compiled from: device_family */
            public class Serializer extends JsonSerializer<EdgesModel> {
                public final void m18162a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    EdgesModel edgesModel = (EdgesModel) obj;
                    if (edgesModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(edgesModel.m18163a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        edgesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    NearbyPlacesOldBrowseOldResultConnectionFragmentParser.EdgesParser.m18377b(edgesModel.w_(), edgesModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(EdgesModel.class, new Serializer());
                }
            }

            public EdgesModel() {
                super(1);
            }

            @Nullable
            public final NodeModel m18165a() {
                this.f15601d = (NodeModel) super.a(this.f15601d, 0, NodeModel.class);
                return this.f15601d;
            }

            public final int jK_() {
                return 76242737;
            }

            public final GraphQLVisitableModel m18164a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m18165a() != null) {
                    NodeModel nodeModel = (NodeModel) graphQLModelMutatingVisitor.b(m18165a());
                    if (m18165a() != nodeModel) {
                        graphQLVisitableModel = (EdgesModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f15601d = nodeModel;
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m18163a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m18165a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, a);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: device_family */
        public class Serializer extends JsonSerializer<NearbyPlacesOldBrowseOldResultConnectionFragmentModel> {
            public final void m18166a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                NearbyPlacesOldBrowseOldResultConnectionFragmentModel nearbyPlacesOldBrowseOldResultConnectionFragmentModel = (NearbyPlacesOldBrowseOldResultConnectionFragmentModel) obj;
                if (nearbyPlacesOldBrowseOldResultConnectionFragmentModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(nearbyPlacesOldBrowseOldResultConnectionFragmentModel.m18168a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    nearbyPlacesOldBrowseOldResultConnectionFragmentModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                NearbyPlacesOldBrowseOldResultConnectionFragmentParser.m18379a(nearbyPlacesOldBrowseOldResultConnectionFragmentModel.w_(), nearbyPlacesOldBrowseOldResultConnectionFragmentModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(NearbyPlacesOldBrowseOldResultConnectionFragmentModel.class, new Serializer());
            }
        }

        public NearbyPlacesOldBrowseOldResultConnectionFragmentModel() {
            super(3);
        }

        @Nullable
        private GeoRectangleFragmentModel m18167j() {
            this.f15603e = (GeoRectangleFragmentModel) super.a(this.f15603e, 1, GeoRectangleFragmentModel.class);
            return this.f15603e;
        }

        @Nonnull
        public final ImmutableList<EdgesModel> m18170a() {
            this.f15604f = super.a(this.f15604f, 2, EdgesModel.class);
            return (ImmutableList) this.f15604f;
        }

        public final int jK_() {
            return -1678079662;
        }

        public final GraphQLVisitableModel m18169a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m18167j() != null) {
                GeoRectangleFragmentModel geoRectangleFragmentModel = (GeoRectangleFragmentModel) graphQLModelMutatingVisitor.b(m18167j());
                if (m18167j() != geoRectangleFragmentModel) {
                    graphQLVisitableModel = (NearbyPlacesOldBrowseOldResultConnectionFragmentModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f15603e = geoRectangleFragmentModel;
                }
            }
            if (m18170a() != null) {
                Builder a = ModelHelper.a(m18170a(), graphQLModelMutatingVisitor);
                if (a != null) {
                    NearbyPlacesOldBrowseOldResultConnectionFragmentModel nearbyPlacesOldBrowseOldResultConnectionFragmentModel = (NearbyPlacesOldBrowseOldResultConnectionFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                    nearbyPlacesOldBrowseOldResultConnectionFragmentModel.f15604f = a.b();
                    graphQLVisitableModel = nearbyPlacesOldBrowseOldResultConnectionFragmentModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m18168a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m18167j());
            int a2 = ModelHelper.a(flatBufferBuilder, m18170a());
            flatBufferBuilder.c(3);
            flatBufferBuilder.a(0, this.f15602d, 0);
            flatBufferBuilder.b(1, a);
            flatBufferBuilder.b(2, a2);
            i();
            return flatBufferBuilder.d();
        }

        public final void m18171a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
            super.a(mutableFlatBuffer, i, obj);
            this.f15602d = mutableFlatBuffer.a(i, 0, 0);
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 867739293)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: device_family */
    public final class NearbyPlacesOldBrowseOldResultsSearchQueryModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private NearbyPlacesOldBrowseOldResultConnectionFragmentModel f15605d;
        @Nullable
        private String f15606e;

        /* compiled from: device_family */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(NearbyPlacesOldBrowseOldResultsSearchQueryModel.class, new Deserializer());
            }

            public Object m18172a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = NearbyPlacesOldBrowseOldResultsSearchQueryParser.m18380a(jsonParser);
                Object nearbyPlacesOldBrowseOldResultsSearchQueryModel = new NearbyPlacesOldBrowseOldResultsSearchQueryModel();
                ((BaseModel) nearbyPlacesOldBrowseOldResultsSearchQueryModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (nearbyPlacesOldBrowseOldResultsSearchQueryModel instanceof Postprocessable) {
                    return ((Postprocessable) nearbyPlacesOldBrowseOldResultsSearchQueryModel).a();
                }
                return nearbyPlacesOldBrowseOldResultsSearchQueryModel;
            }
        }

        /* compiled from: device_family */
        public class Serializer extends JsonSerializer<NearbyPlacesOldBrowseOldResultsSearchQueryModel> {
            public final void m18173a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                NearbyPlacesOldBrowseOldResultsSearchQueryModel nearbyPlacesOldBrowseOldResultsSearchQueryModel = (NearbyPlacesOldBrowseOldResultsSearchQueryModel) obj;
                if (nearbyPlacesOldBrowseOldResultsSearchQueryModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(nearbyPlacesOldBrowseOldResultsSearchQueryModel.m18175a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    nearbyPlacesOldBrowseOldResultsSearchQueryModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = nearbyPlacesOldBrowseOldResultsSearchQueryModel.w_();
                int u_ = nearbyPlacesOldBrowseOldResultsSearchQueryModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("places");
                    NearbyPlacesOldBrowseOldResultConnectionFragmentParser.m18379a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                if (mutableFlatBuffer.g(u_, 1) != 0) {
                    jsonGenerator.a("search_session_key");
                    jsonGenerator.b(mutableFlatBuffer.c(u_, 1));
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(NearbyPlacesOldBrowseOldResultsSearchQueryModel.class, new Serializer());
            }
        }

        public NearbyPlacesOldBrowseOldResultsSearchQueryModel() {
            super(2);
        }

        @Nullable
        public final NearbyPlacesOldBrowseOldResultConnectionFragmentModel m18177a() {
            this.f15605d = (NearbyPlacesOldBrowseOldResultConnectionFragmentModel) super.a(this.f15605d, 0, NearbyPlacesOldBrowseOldResultConnectionFragmentModel.class);
            return this.f15605d;
        }

        @Nullable
        private String m18174j() {
            this.f15606e = super.a(this.f15606e, 1);
            return this.f15606e;
        }

        public final int jK_() {
            return -608734554;
        }

        public final GraphQLVisitableModel m18176a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m18177a() != null) {
                NearbyPlacesOldBrowseOldResultConnectionFragmentModel nearbyPlacesOldBrowseOldResultConnectionFragmentModel = (NearbyPlacesOldBrowseOldResultConnectionFragmentModel) graphQLModelMutatingVisitor.b(m18177a());
                if (m18177a() != nearbyPlacesOldBrowseOldResultConnectionFragmentModel) {
                    graphQLVisitableModel = (NearbyPlacesOldBrowseOldResultsSearchQueryModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f15605d = nearbyPlacesOldBrowseOldResultConnectionFragmentModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m18175a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m18177a());
            int b = flatBufferBuilder.b(m18174j());
            flatBufferBuilder.c(2);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, b);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -1578256212)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: device_family */
    public final class NearbyPlacesOldFlowFriendsWhoVisitedFragmentModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
        @Nullable
        private FriendsWhoVisitedModel f15614d;
        @Nullable
        private String f15615e;

        /* compiled from: device_family */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(NearbyPlacesOldFlowFriendsWhoVisitedFragmentModel.class, new Deserializer());
            }

            public Object m18178a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = NearbyPlacesOldFlowFriendsWhoVisitedFragmentParser.m18387a(jsonParser);
                Object nearbyPlacesOldFlowFriendsWhoVisitedFragmentModel = new NearbyPlacesOldFlowFriendsWhoVisitedFragmentModel();
                ((BaseModel) nearbyPlacesOldFlowFriendsWhoVisitedFragmentModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (nearbyPlacesOldFlowFriendsWhoVisitedFragmentModel instanceof Postprocessable) {
                    return ((Postprocessable) nearbyPlacesOldFlowFriendsWhoVisitedFragmentModel).a();
                }
                return nearbyPlacesOldFlowFriendsWhoVisitedFragmentModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 2116942612)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: device_family */
        public final class FriendsWhoVisitedModel extends BaseModel implements GraphQLVisitableModel {
            private int f15612d;
            @Nullable
            private List<EdgesModel> f15613e;

            /* compiled from: device_family */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(FriendsWhoVisitedModel.class, new Deserializer());
                }

                public Object m18179a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(NearbyPlacesOldFlowFriendsWhoVisitedFragmentParser.FriendsWhoVisitedParser.m18385a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object friendsWhoVisitedModel = new FriendsWhoVisitedModel();
                    ((BaseModel) friendsWhoVisitedModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (friendsWhoVisitedModel instanceof Postprocessable) {
                        return ((Postprocessable) friendsWhoVisitedModel).a();
                    }
                    return friendsWhoVisitedModel;
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = 1696831359)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: device_family */
            public final class EdgesModel extends BaseModel implements GraphQLVisitableModel {
                @Nullable
                private NodeModel f15611d;

                /* compiled from: device_family */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(EdgesModel.class, new Deserializer());
                    }

                    public Object m18180a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(NearbyPlacesOldFlowFriendsWhoVisitedFragmentParser.FriendsWhoVisitedParser.EdgesParser.m18383b(jsonParser, flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        mutableFlatBuffer.a(4, Boolean.valueOf(true));
                        MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                        Object edgesModel = new EdgesModel();
                        ((BaseModel) edgesModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                        if (edgesModel instanceof Postprocessable) {
                            return ((Postprocessable) edgesModel).a();
                        }
                        return edgesModel;
                    }
                }

                @JsonDeserialize(using = Deserializer.class)
                @ModelWithFlatBufferFormatHash(a = 1068082562)
                @JsonSerialize(using = Serializer.class)
                @FragmentModelWithoutBridge
                /* compiled from: device_family */
                public final class NodeModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
                    @Nullable
                    private String f15607d;
                    @Nullable
                    private String f15608e;
                    @Nullable
                    private BrowseNearbyPlacesFullImageFragmentModel f15609f;
                    @Nullable
                    private BrowseNearbyPlacesFullImageFragmentModel f15610g;

                    /* compiled from: device_family */
                    public class Deserializer extends FbJsonDeserializer {
                        static {
                            GlobalAutoGenDeserializerCache.a(NodeModel.class, new Deserializer());
                        }

                        public Object m18181a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(NearbyPlacesOldFlowFriendsWhoVisitedFragmentParser.FriendsWhoVisitedParser.EdgesParser.NodeParser.m18381a(jsonParser, flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            mutableFlatBuffer.a(4, Boolean.valueOf(true));
                            MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                            Object nodeModel = new NodeModel();
                            ((BaseModel) nodeModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                            if (nodeModel instanceof Postprocessable) {
                                return ((Postprocessable) nodeModel).a();
                            }
                            return nodeModel;
                        }
                    }

                    /* compiled from: device_family */
                    public class Serializer extends JsonSerializer<NodeModel> {
                        public final void m18182a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                            NodeModel nodeModel = (NodeModel) obj;
                            if (nodeModel.w_() == null) {
                                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                flatBufferBuilder.d(nodeModel.m18184a(flatBufferBuilder));
                                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                wrap.position(0);
                                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                nodeModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                            }
                            NearbyPlacesOldFlowFriendsWhoVisitedFragmentParser.FriendsWhoVisitedParser.EdgesParser.NodeParser.m18382a(nodeModel.w_(), nodeModel.u_(), jsonGenerator, serializerProvider);
                        }

                        static {
                            FbSerializerProvider.a(NodeModel.class, new Serializer());
                        }
                    }

                    public NodeModel() {
                        super(4);
                    }

                    public final void m18187a(String str, ConsistencyTuple consistencyTuple) {
                        consistencyTuple.a();
                    }

                    public final void m18188a(String str, Object obj, boolean z) {
                    }

                    @Nullable
                    private String m18183m() {
                        this.f15607d = super.a(this.f15607d, 0);
                        return this.f15607d;
                    }

                    @Nullable
                    public final String m18189j() {
                        this.f15608e = super.a(this.f15608e, 1);
                        return this.f15608e;
                    }

                    @Nullable
                    public final BrowseNearbyPlacesFullImageFragmentModel m18190k() {
                        this.f15609f = (BrowseNearbyPlacesFullImageFragmentModel) super.a(this.f15609f, 2, BrowseNearbyPlacesFullImageFragmentModel.class);
                        return this.f15609f;
                    }

                    @Nullable
                    public final BrowseNearbyPlacesFullImageFragmentModel m18191l() {
                        this.f15610g = (BrowseNearbyPlacesFullImageFragmentModel) super.a(this.f15610g, 3, BrowseNearbyPlacesFullImageFragmentModel.class);
                        return this.f15610g;
                    }

                    @Nullable
                    public final String m18186a() {
                        return m18183m();
                    }

                    public final int jK_() {
                        return 2645995;
                    }

                    public final GraphQLVisitableModel m18185a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                        BrowseNearbyPlacesFullImageFragmentModel browseNearbyPlacesFullImageFragmentModel;
                        GraphQLVisitableModel graphQLVisitableModel = null;
                        h();
                        if (m18190k() != null) {
                            browseNearbyPlacesFullImageFragmentModel = (BrowseNearbyPlacesFullImageFragmentModel) graphQLModelMutatingVisitor.b(m18190k());
                            if (m18190k() != browseNearbyPlacesFullImageFragmentModel) {
                                graphQLVisitableModel = (NodeModel) ModelHelper.a(null, this);
                                graphQLVisitableModel.f15609f = browseNearbyPlacesFullImageFragmentModel;
                            }
                        }
                        if (m18191l() != null) {
                            browseNearbyPlacesFullImageFragmentModel = (BrowseNearbyPlacesFullImageFragmentModel) graphQLModelMutatingVisitor.b(m18191l());
                            if (m18191l() != browseNearbyPlacesFullImageFragmentModel) {
                                graphQLVisitableModel = (NodeModel) ModelHelper.a(graphQLVisitableModel, this);
                                graphQLVisitableModel.f15610g = browseNearbyPlacesFullImageFragmentModel;
                            }
                        }
                        i();
                        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                    }

                    public final int m18184a(FlatBufferBuilder flatBufferBuilder) {
                        h();
                        int b = flatBufferBuilder.b(m18183m());
                        int b2 = flatBufferBuilder.b(m18189j());
                        int a = ModelHelper.a(flatBufferBuilder, m18190k());
                        int a2 = ModelHelper.a(flatBufferBuilder, m18191l());
                        flatBufferBuilder.c(4);
                        flatBufferBuilder.b(0, b);
                        flatBufferBuilder.b(1, b2);
                        flatBufferBuilder.b(2, a);
                        flatBufferBuilder.b(3, a2);
                        i();
                        return flatBufferBuilder.d();
                    }
                }

                /* compiled from: device_family */
                public class Serializer extends JsonSerializer<EdgesModel> {
                    public final void m18192a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        EdgesModel edgesModel = (EdgesModel) obj;
                        if (edgesModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(edgesModel.m18193a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            edgesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        NearbyPlacesOldFlowFriendsWhoVisitedFragmentParser.FriendsWhoVisitedParser.EdgesParser.m18384b(edgesModel.w_(), edgesModel.u_(), jsonGenerator, serializerProvider);
                    }

                    static {
                        FbSerializerProvider.a(EdgesModel.class, new Serializer());
                    }
                }

                public EdgesModel() {
                    super(1);
                }

                @Nullable
                public final NodeModel m18195a() {
                    this.f15611d = (NodeModel) super.a(this.f15611d, 0, NodeModel.class);
                    return this.f15611d;
                }

                public final int jK_() {
                    return -1193695682;
                }

                public final GraphQLVisitableModel m18194a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    GraphQLVisitableModel graphQLVisitableModel = null;
                    h();
                    if (m18195a() != null) {
                        NodeModel nodeModel = (NodeModel) graphQLModelMutatingVisitor.b(m18195a());
                        if (m18195a() != nodeModel) {
                            graphQLVisitableModel = (EdgesModel) ModelHelper.a(null, this);
                            graphQLVisitableModel.f15611d = nodeModel;
                        }
                    }
                    i();
                    return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                }

                public final int m18193a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int a = ModelHelper.a(flatBufferBuilder, m18195a());
                    flatBufferBuilder.c(1);
                    flatBufferBuilder.b(0, a);
                    i();
                    return flatBufferBuilder.d();
                }
            }

            /* compiled from: device_family */
            public class Serializer extends JsonSerializer<FriendsWhoVisitedModel> {
                public final void m18196a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    FriendsWhoVisitedModel friendsWhoVisitedModel = (FriendsWhoVisitedModel) obj;
                    if (friendsWhoVisitedModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(friendsWhoVisitedModel.m18198a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        friendsWhoVisitedModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    NearbyPlacesOldFlowFriendsWhoVisitedFragmentParser.FriendsWhoVisitedParser.m18386a(friendsWhoVisitedModel.w_(), friendsWhoVisitedModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(FriendsWhoVisitedModel.class, new Serializer());
                }
            }

            public FriendsWhoVisitedModel() {
                super(2);
            }

            public final int m18197a() {
                a(0, 0);
                return this.f15612d;
            }

            @Nonnull
            public final ImmutableList<EdgesModel> m18201j() {
                this.f15613e = super.a(this.f15613e, 1, EdgesModel.class);
                return (ImmutableList) this.f15613e;
            }

            public final int jK_() {
                return -404188513;
            }

            public final GraphQLVisitableModel m18199a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m18201j() != null) {
                    Builder a = ModelHelper.a(m18201j(), graphQLModelMutatingVisitor);
                    if (a != null) {
                        graphQLVisitableModel = (FriendsWhoVisitedModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f15613e = a.b();
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m18198a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m18201j());
                flatBufferBuilder.c(2);
                flatBufferBuilder.a(0, this.f15612d, 0);
                flatBufferBuilder.b(1, a);
                i();
                return flatBufferBuilder.d();
            }

            public final void m18200a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                super.a(mutableFlatBuffer, i, obj);
                this.f15612d = mutableFlatBuffer.a(i, 0, 0);
            }
        }

        /* compiled from: device_family */
        public class Serializer extends JsonSerializer<NearbyPlacesOldFlowFriendsWhoVisitedFragmentModel> {
            public final void m18202a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                NearbyPlacesOldFlowFriendsWhoVisitedFragmentModel nearbyPlacesOldFlowFriendsWhoVisitedFragmentModel = (NearbyPlacesOldFlowFriendsWhoVisitedFragmentModel) obj;
                if (nearbyPlacesOldFlowFriendsWhoVisitedFragmentModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(nearbyPlacesOldFlowFriendsWhoVisitedFragmentModel.m18205a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    nearbyPlacesOldFlowFriendsWhoVisitedFragmentModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = nearbyPlacesOldFlowFriendsWhoVisitedFragmentModel.w_();
                int u_ = nearbyPlacesOldFlowFriendsWhoVisitedFragmentModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("friends_who_visited");
                    NearbyPlacesOldFlowFriendsWhoVisitedFragmentParser.FriendsWhoVisitedParser.m18386a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                if (mutableFlatBuffer.g(u_, 1) != 0) {
                    jsonGenerator.a("id");
                    jsonGenerator.b(mutableFlatBuffer.c(u_, 1));
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(NearbyPlacesOldFlowFriendsWhoVisitedFragmentModel.class, new Serializer());
            }
        }

        public NearbyPlacesOldFlowFriendsWhoVisitedFragmentModel() {
            super(2);
        }

        public final void m18208a(String str, ConsistencyTuple consistencyTuple) {
            consistencyTuple.a();
        }

        public final void m18209a(String str, Object obj, boolean z) {
        }

        @Nullable
        private FriendsWhoVisitedModel m18203j() {
            this.f15614d = (FriendsWhoVisitedModel) super.a(this.f15614d, 0, FriendsWhoVisitedModel.class);
            return this.f15614d;
        }

        @Nullable
        private String m18204k() {
            this.f15615e = super.a(this.f15615e, 1);
            return this.f15615e;
        }

        @Nullable
        public final String m18207a() {
            return m18204k();
        }

        public final int jK_() {
            return 2479791;
        }

        public final GraphQLVisitableModel m18206a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m18203j() != null) {
                FriendsWhoVisitedModel friendsWhoVisitedModel = (FriendsWhoVisitedModel) graphQLModelMutatingVisitor.b(m18203j());
                if (m18203j() != friendsWhoVisitedModel) {
                    graphQLVisitableModel = (NearbyPlacesOldFlowFriendsWhoVisitedFragmentModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f15614d = friendsWhoVisitedModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m18205a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m18203j());
            int b = flatBufferBuilder.b(m18204k());
            flatBufferBuilder.c(2);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, b);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -955023983)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: device_family */
    public final class NearbyPlacesPageProfilePhotoModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel, NearbyPlacesPageProfilePhoto {
        @Nullable
        private String f15618d;
        @Nullable
        private ProfilePhotoModel f15619e;

        /* compiled from: device_family */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(NearbyPlacesPageProfilePhotoModel.class, new Deserializer());
            }

            public Object m18210a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = NearbyPlacesPageProfilePhotoParser.m18390a(jsonParser);
                Object nearbyPlacesPageProfilePhotoModel = new NearbyPlacesPageProfilePhotoModel();
                ((BaseModel) nearbyPlacesPageProfilePhotoModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (nearbyPlacesPageProfilePhotoModel instanceof Postprocessable) {
                    return ((Postprocessable) nearbyPlacesPageProfilePhotoModel).a();
                }
                return nearbyPlacesPageProfilePhotoModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 1801334754)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: device_family */
        public final class ProfilePhotoModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableModel {
            @Nullable
            private String f15617d;

            /* compiled from: device_family */
            public final class Builder {
                @Nullable
                public String f15616a;
            }

            /* compiled from: device_family */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(ProfilePhotoModel.class, new Deserializer());
                }

                public Object m18211a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(ProfilePhotoParser.m18388a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object profilePhotoModel = new ProfilePhotoModel();
                    ((BaseModel) profilePhotoModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (profilePhotoModel instanceof Postprocessable) {
                        return ((Postprocessable) profilePhotoModel).a();
                    }
                    return profilePhotoModel;
                }
            }

            /* compiled from: device_family */
            public class Serializer extends JsonSerializer<ProfilePhotoModel> {
                public final void m18212a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    ProfilePhotoModel profilePhotoModel = (ProfilePhotoModel) obj;
                    if (profilePhotoModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(profilePhotoModel.m18214a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        profilePhotoModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    ProfilePhotoParser.m18389a(profilePhotoModel.w_(), profilePhotoModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(ProfilePhotoModel.class, new Serializer());
                }
            }

            public ProfilePhotoModel() {
                super(1);
            }

            public ProfilePhotoModel(MutableFlatBuffer mutableFlatBuffer) {
                super(1);
                a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
            }

            @Nullable
            public final String m18217b() {
                this.f15617d = super.a(this.f15617d, 0);
                return this.f15617d;
            }

            public static ProfilePhotoModel m18213a(ProfilePhotoModel profilePhotoModel) {
                if (profilePhotoModel == null) {
                    return null;
                }
                if (profilePhotoModel instanceof ProfilePhotoModel) {
                    return profilePhotoModel;
                }
                Builder builder = new Builder();
                builder.f15616a = profilePhotoModel.m18217b();
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                int b = flatBufferBuilder.b(builder.f15616a);
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, b);
                flatBufferBuilder.d(flatBufferBuilder.d());
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                return new ProfilePhotoModel(new MutableFlatBuffer(wrap, null, null, true, null));
            }

            @Nullable
            public final String m18216a() {
                return m18217b();
            }

            public final int jK_() {
                return 77090322;
            }

            public final GraphQLVisitableModel m18215a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m18214a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m18217b());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, b);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: device_family */
        public class Serializer extends JsonSerializer<NearbyPlacesPageProfilePhotoModel> {
            public final void m18218a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                NearbyPlacesPageProfilePhotoModel nearbyPlacesPageProfilePhotoModel = (NearbyPlacesPageProfilePhotoModel) obj;
                if (nearbyPlacesPageProfilePhotoModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(nearbyPlacesPageProfilePhotoModel.m18221a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    nearbyPlacesPageProfilePhotoModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = nearbyPlacesPageProfilePhotoModel.w_();
                int u_ = nearbyPlacesPageProfilePhotoModel.u_();
                jsonGenerator.f();
                if (mutableFlatBuffer.g(u_, 0) != 0) {
                    jsonGenerator.a("id");
                    jsonGenerator.b(mutableFlatBuffer.c(u_, 0));
                }
                int g = mutableFlatBuffer.g(u_, 1);
                if (g != 0) {
                    jsonGenerator.a("profile_photo");
                    ProfilePhotoParser.m18389a(mutableFlatBuffer, g, jsonGenerator);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(NearbyPlacesPageProfilePhotoModel.class, new Serializer());
            }
        }

        public NearbyPlacesPageProfilePhotoModel() {
            super(2);
        }

        public final void m18224a(String str, ConsistencyTuple consistencyTuple) {
            consistencyTuple.a();
        }

        public final void m18225a(String str, Object obj, boolean z) {
        }

        @Nullable
        private String m18219j() {
            this.f15618d = super.a(this.f15618d, 0);
            return this.f15618d;
        }

        @Nullable
        private ProfilePhotoModel m18220k() {
            this.f15619e = (ProfilePhotoModel) super.a(this.f15619e, 1, ProfilePhotoModel.class);
            return this.f15619e;
        }

        @Nullable
        public final String m18223a() {
            return m18219j();
        }

        public final int jK_() {
            return 2479791;
        }

        public final GraphQLVisitableModel m18222a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m18220k() != null) {
                ProfilePhotoModel profilePhotoModel = (ProfilePhotoModel) graphQLModelMutatingVisitor.b(m18220k());
                if (m18220k() != profilePhotoModel) {
                    graphQLVisitableModel = (NearbyPlacesPageProfilePhotoModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f15619e = profilePhotoModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m18221a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int b = flatBufferBuilder.b(m18219j());
            int a = ModelHelper.a(flatBufferBuilder, m18220k());
            flatBufferBuilder.c(2);
            flatBufferBuilder.b(0, b);
            flatBufferBuilder.b(1, a);
            i();
            return flatBufferBuilder.d();
        }
    }

    @FragmentModelWithBridge
    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 1942618936)
    @JsonSerialize(using = Serializer.class)
    /* compiled from: device_family */
    public final class NearbyRecommendationsConnectionFragmentModel extends BaseModel implements GraphQLVisitableModel {
        private int f15638d;
        @Nullable
        private List<EdgesModel> f15639e;

        /* compiled from: device_family */
        public final class Builder {
            public int f15620a;
            @Nullable
            public ImmutableList<EdgesModel> f15621b;
        }

        /* compiled from: device_family */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(NearbyRecommendationsConnectionFragmentModel.class, new Deserializer());
            }

            public Object m18226a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(NearbyRecommendationsConnectionFragmentParser.m18395a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object nearbyRecommendationsConnectionFragmentModel = new NearbyRecommendationsConnectionFragmentModel();
                ((BaseModel) nearbyRecommendationsConnectionFragmentModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (nearbyRecommendationsConnectionFragmentModel instanceof Postprocessable) {
                    return ((Postprocessable) nearbyRecommendationsConnectionFragmentModel).a();
                }
                return nearbyRecommendationsConnectionFragmentModel;
            }
        }

        @FragmentModelWithBridge
        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -1670637446)
        @JsonSerialize(using = Serializer.class)
        /* compiled from: device_family */
        public final class EdgesModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private NodeModel f15637d;

            /* compiled from: device_family */
            public final class Builder {
                @Nullable
                public NodeModel f15622a;
            }

            /* compiled from: device_family */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(EdgesModel.class, new Deserializer());
                }

                public Object m18227a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(NearbyRecommendationsConnectionFragmentParser.EdgesParser.m18393b(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object edgesModel = new EdgesModel();
                    ((BaseModel) edgesModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (edgesModel instanceof Postprocessable) {
                        return ((Postprocessable) edgesModel).a();
                    }
                    return edgesModel;
                }
            }

            @FragmentModelWithBridge
            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = 394126876)
            @JsonSerialize(using = Serializer.class)
            /* compiled from: device_family */
            public final class NodeModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableModel, ReviewWithCreationFields {
                private long f15630d;
                @Nullable
                private CreatorModel f15631e;
                @Nullable
                private String f15632f;
                private int f15633g;
                @Nullable
                private SelectedPrivacyOptionFieldsModel f15634h;
                @Nullable
                private StoryModel f15635i;
                @Nullable
                private ValueModel f15636j;

                /* compiled from: device_family */
                public final class Builder {
                    public long f15623a;
                    @Nullable
                    public CreatorModel f15624b;
                    @Nullable
                    public String f15625c;
                    public int f15626d;
                    @Nullable
                    public SelectedPrivacyOptionFieldsModel f15627e;
                    @Nullable
                    public StoryModel f15628f;
                    @Nullable
                    public ValueModel f15629g;

                    public final NodeModel m18228a() {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        int a = ModelHelper.a(flatBufferBuilder, this.f15624b);
                        int b = flatBufferBuilder.b(this.f15625c);
                        int a2 = ModelHelper.a(flatBufferBuilder, this.f15627e);
                        int a3 = ModelHelper.a(flatBufferBuilder, this.f15628f);
                        int a4 = ModelHelper.a(flatBufferBuilder, this.f15629g);
                        flatBufferBuilder.c(7);
                        flatBufferBuilder.a(0, this.f15623a, 0);
                        flatBufferBuilder.b(1, a);
                        flatBufferBuilder.b(2, b);
                        flatBufferBuilder.a(3, this.f15626d, 0);
                        flatBufferBuilder.b(4, a2);
                        flatBufferBuilder.b(5, a3);
                        flatBufferBuilder.b(6, a4);
                        flatBufferBuilder.d(flatBufferBuilder.d());
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        return new NodeModel(new MutableFlatBuffer(wrap, null, null, true, null));
                    }
                }

                /* compiled from: device_family */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(NodeModel.class, new Deserializer());
                    }

                    public Object m18229a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(NearbyRecommendationsConnectionFragmentParser.EdgesParser.NodeParser.m18391a(jsonParser, flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        mutableFlatBuffer.a(4, Boolean.valueOf(true));
                        MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                        Object nodeModel = new NodeModel();
                        ((BaseModel) nodeModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                        if (nodeModel instanceof Postprocessable) {
                            return ((Postprocessable) nodeModel).a();
                        }
                        return nodeModel;
                    }
                }

                /* compiled from: device_family */
                public class Serializer extends JsonSerializer<NodeModel> {
                    public final void m18230a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        NodeModel nodeModel = (NodeModel) obj;
                        if (nodeModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(nodeModel.m18236a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            nodeModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        NearbyRecommendationsConnectionFragmentParser.EdgesParser.NodeParser.m18392a(nodeModel.w_(), nodeModel.u_(), jsonGenerator, serializerProvider);
                    }

                    static {
                        FbSerializerProvider.a(NodeModel.class, new Serializer());
                    }
                }

                @Nullable
                public final /* synthetic */ CreatorModel bP_() {
                    return m18232j();
                }

                @Nullable
                public final /* synthetic */ SelectedPrivacyOptionFieldsModel m18241c() {
                    return m18233k();
                }

                @Nullable
                public final /* synthetic */ ValueModel m18242d() {
                    return m18235m();
                }

                @Nullable
                public final /* synthetic */ StoryModel kc_() {
                    return m18234l();
                }

                public NodeModel() {
                    super(7);
                }

                public NodeModel(MutableFlatBuffer mutableFlatBuffer) {
                    super(7);
                    a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }

                public final long m18243g() {
                    a(0, 0);
                    return this.f15630d;
                }

                @Nullable
                private CreatorModel m18232j() {
                    this.f15631e = (CreatorModel) super.a(this.f15631e, 1, CreatorModel.class);
                    return this.f15631e;
                }

                @Nullable
                public final String kb_() {
                    this.f15632f = super.a(this.f15632f, 2);
                    return this.f15632f;
                }

                public final int m18240b() {
                    a(0, 3);
                    return this.f15633g;
                }

                @Nullable
                private SelectedPrivacyOptionFieldsModel m18233k() {
                    this.f15634h = (SelectedPrivacyOptionFieldsModel) super.a(this.f15634h, 4, SelectedPrivacyOptionFieldsModel.class);
                    return this.f15634h;
                }

                @Nullable
                private StoryModel m18234l() {
                    this.f15635i = (StoryModel) super.a(this.f15635i, 5, StoryModel.class);
                    return this.f15635i;
                }

                @Nullable
                private ValueModel m18235m() {
                    this.f15636j = (ValueModel) super.a(this.f15636j, 6, ValueModel.class);
                    return this.f15636j;
                }

                public static NodeModel m18231a(NodeModel nodeModel) {
                    if (nodeModel == null) {
                        return null;
                    }
                    if (nodeModel instanceof NodeModel) {
                        return nodeModel;
                    }
                    Builder builder = new Builder();
                    builder.f15623a = nodeModel.m18243g();
                    builder.f15624b = CreatorModel.a(nodeModel.bP_());
                    builder.f15625c = nodeModel.kb_();
                    builder.f15626d = nodeModel.m18240b();
                    builder.f15627e = SelectedPrivacyOptionFieldsModel.a(nodeModel.m18241c());
                    builder.f15628f = StoryModel.a(nodeModel.kc_());
                    builder.f15629g = ValueModel.a(nodeModel.m18242d());
                    return builder.m18228a();
                }

                @Nullable
                public final String m18238a() {
                    return kb_();
                }

                public final int jK_() {
                    return -131209055;
                }

                public final GraphQLVisitableModel m18237a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    GraphQLVisitableModel graphQLVisitableModel = null;
                    h();
                    if (m18232j() != null) {
                        CreatorModel creatorModel = (CreatorModel) graphQLModelMutatingVisitor.b(m18232j());
                        if (m18232j() != creatorModel) {
                            graphQLVisitableModel = (NodeModel) ModelHelper.a(null, this);
                            graphQLVisitableModel.f15631e = creatorModel;
                        }
                    }
                    if (m18233k() != null) {
                        SelectedPrivacyOptionFieldsModel selectedPrivacyOptionFieldsModel = (SelectedPrivacyOptionFieldsModel) graphQLModelMutatingVisitor.b(m18233k());
                        if (m18233k() != selectedPrivacyOptionFieldsModel) {
                            graphQLVisitableModel = (NodeModel) ModelHelper.a(graphQLVisitableModel, this);
                            graphQLVisitableModel.f15634h = selectedPrivacyOptionFieldsModel;
                        }
                    }
                    if (m18234l() != null) {
                        StoryModel storyModel = (StoryModel) graphQLModelMutatingVisitor.b(m18234l());
                        if (m18234l() != storyModel) {
                            graphQLVisitableModel = (NodeModel) ModelHelper.a(graphQLVisitableModel, this);
                            graphQLVisitableModel.f15635i = storyModel;
                        }
                    }
                    if (m18235m() != null) {
                        ValueModel valueModel = (ValueModel) graphQLModelMutatingVisitor.b(m18235m());
                        if (m18235m() != valueModel) {
                            graphQLVisitableModel = (NodeModel) ModelHelper.a(graphQLVisitableModel, this);
                            graphQLVisitableModel.f15636j = valueModel;
                        }
                    }
                    i();
                    return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                }

                public final int m18236a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int a = ModelHelper.a(flatBufferBuilder, m18232j());
                    int b = flatBufferBuilder.b(kb_());
                    int a2 = ModelHelper.a(flatBufferBuilder, m18233k());
                    int a3 = ModelHelper.a(flatBufferBuilder, m18234l());
                    int a4 = ModelHelper.a(flatBufferBuilder, m18235m());
                    flatBufferBuilder.c(7);
                    flatBufferBuilder.a(0, this.f15630d, 0);
                    flatBufferBuilder.b(1, a);
                    flatBufferBuilder.b(2, b);
                    flatBufferBuilder.a(3, this.f15633g, 0);
                    flatBufferBuilder.b(4, a2);
                    flatBufferBuilder.b(5, a3);
                    flatBufferBuilder.b(6, a4);
                    i();
                    return flatBufferBuilder.d();
                }

                public final void m18239a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                    super.a(mutableFlatBuffer, i, obj);
                    this.f15630d = mutableFlatBuffer.a(i, 0, 0);
                    this.f15633g = mutableFlatBuffer.a(i, 3, 0);
                }
            }

            /* compiled from: device_family */
            public class Serializer extends JsonSerializer<EdgesModel> {
                public final void m18244a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    EdgesModel edgesModel = (EdgesModel) obj;
                    if (edgesModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(edgesModel.m18247a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        edgesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    NearbyRecommendationsConnectionFragmentParser.EdgesParser.m18394b(edgesModel.w_(), edgesModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(EdgesModel.class, new Serializer());
                }
            }

            @Nullable
            public final /* synthetic */ NodeModel m18249a() {
                return m18246j();
            }

            public EdgesModel() {
                super(1);
            }

            public EdgesModel(MutableFlatBuffer mutableFlatBuffer) {
                super(1);
                a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
            }

            @Nullable
            private NodeModel m18246j() {
                this.f15637d = (NodeModel) super.a(this.f15637d, 0, NodeModel.class);
                return this.f15637d;
            }

            public static EdgesModel m18245a(EdgesModel edgesModel) {
                if (edgesModel == null) {
                    return null;
                }
                if (edgesModel instanceof EdgesModel) {
                    return edgesModel;
                }
                Builder builder = new Builder();
                builder.f15622a = NodeModel.m18231a(edgesModel.m18249a());
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                int a = ModelHelper.a(flatBufferBuilder, builder.f15622a);
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.d(flatBufferBuilder.d());
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                return new EdgesModel(new MutableFlatBuffer(wrap, null, null, true, null));
            }

            public final int jK_() {
                return 369678728;
            }

            public final GraphQLVisitableModel m18248a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m18246j() != null) {
                    NodeModel nodeModel = (NodeModel) graphQLModelMutatingVisitor.b(m18246j());
                    if (m18246j() != nodeModel) {
                        graphQLVisitableModel = (EdgesModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f15637d = nodeModel;
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m18247a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m18246j());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, a);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: device_family */
        public class Serializer extends JsonSerializer<NearbyRecommendationsConnectionFragmentModel> {
            public final void m18250a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                NearbyRecommendationsConnectionFragmentModel nearbyRecommendationsConnectionFragmentModel = (NearbyRecommendationsConnectionFragmentModel) obj;
                if (nearbyRecommendationsConnectionFragmentModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(nearbyRecommendationsConnectionFragmentModel.m18253a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    nearbyRecommendationsConnectionFragmentModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                NearbyRecommendationsConnectionFragmentParser.m18396a(nearbyRecommendationsConnectionFragmentModel.w_(), nearbyRecommendationsConnectionFragmentModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(NearbyRecommendationsConnectionFragmentModel.class, new Serializer());
            }
        }

        public NearbyRecommendationsConnectionFragmentModel() {
            super(2);
        }

        public NearbyRecommendationsConnectionFragmentModel(MutableFlatBuffer mutableFlatBuffer) {
            super(2);
            a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
        }

        public final int m18252a() {
            a(0, 0);
            return this.f15638d;
        }

        @Nonnull
        public final ImmutableList<EdgesModel> m18256b() {
            this.f15639e = super.a(this.f15639e, 1, EdgesModel.class);
            return (ImmutableList) this.f15639e;
        }

        public static NearbyRecommendationsConnectionFragmentModel m18251a(NearbyRecommendationsConnectionFragmentModel nearbyRecommendationsConnectionFragmentModel) {
            if (nearbyRecommendationsConnectionFragmentModel == null) {
                return null;
            }
            if (nearbyRecommendationsConnectionFragmentModel instanceof NearbyRecommendationsConnectionFragmentModel) {
                return nearbyRecommendationsConnectionFragmentModel;
            }
            Builder builder = new Builder();
            builder.f15620a = nearbyRecommendationsConnectionFragmentModel.m18252a();
            com.google.common.collect.ImmutableList.Builder builder2 = ImmutableList.builder();
            for (int i = 0; i < nearbyRecommendationsConnectionFragmentModel.m18256b().size(); i++) {
                builder2.c(EdgesModel.m18245a((EdgesModel) nearbyRecommendationsConnectionFragmentModel.m18256b().get(i)));
            }
            builder.f15621b = builder2.b();
            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
            int a = ModelHelper.a(flatBufferBuilder, builder.f15621b);
            flatBufferBuilder.c(2);
            flatBufferBuilder.a(0, builder.f15620a, 0);
            flatBufferBuilder.b(1, a);
            flatBufferBuilder.d(flatBufferBuilder.d());
            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
            wrap.position(0);
            return new NearbyRecommendationsConnectionFragmentModel(new MutableFlatBuffer(wrap, null, null, true, null));
        }

        public final int jK_() {
            return -1909283223;
        }

        public final GraphQLVisitableModel m18254a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m18256b() != null) {
                com.google.common.collect.ImmutableList.Builder a = ModelHelper.a(m18256b(), graphQLModelMutatingVisitor);
                if (a != null) {
                    graphQLVisitableModel = (NearbyRecommendationsConnectionFragmentModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f15639e = a.b();
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m18253a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m18256b());
            flatBufferBuilder.c(2);
            flatBufferBuilder.a(0, this.f15638d, 0);
            flatBufferBuilder.b(1, a);
            i();
            return flatBufferBuilder.d();
        }

        public final void m18255a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
            super.a(mutableFlatBuffer, i, obj);
            this.f15638d = mutableFlatBuffer.a(i, 0, 0);
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -118558404)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: device_family */
    public final class PageTWEFragmentModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel, PageTWEFragment {
        @Nullable
        private String f15650d;
        @Nullable
        private List<RedirectionInfoModel> f15651e;

        /* compiled from: device_family */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(PageTWEFragmentModel.class, new Deserializer());
            }

            public Object m18257a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = PageTWEFragmentParser.m18403a(jsonParser);
                Object pageTWEFragmentModel = new PageTWEFragmentModel();
                ((BaseModel) pageTWEFragmentModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (pageTWEFragmentModel instanceof Postprocessable) {
                    return ((Postprocessable) pageTWEFragmentModel).a();
                }
                return pageTWEFragmentModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -1002116378)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: device_family */
        public final class RedirectionInfoModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private NodeModel f15647d;
            @Nullable
            private GraphQLRedirectionReason f15648e;
            @Nullable
            private String f15649f;

            /* compiled from: device_family */
            public final class Builder {
                @Nullable
                public NodeModel f15640a;
                @Nullable
                public GraphQLRedirectionReason f15641b;
                @Nullable
                public String f15642c;
            }

            /* compiled from: device_family */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(RedirectionInfoModel.class, new Deserializer());
                }

                public Object m18258a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(RedirectionInfoParser.m18401b(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object redirectionInfoModel = new RedirectionInfoModel();
                    ((BaseModel) redirectionInfoModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (redirectionInfoModel instanceof Postprocessable) {
                        return ((Postprocessable) redirectionInfoModel).a();
                    }
                    return redirectionInfoModel;
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = -1787905591)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: device_family */
            public final class NodeModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
                @Nullable
                private GraphQLObjectType f15645d;
                @Nullable
                private String f15646e;

                /* compiled from: device_family */
                public final class Builder {
                    @Nullable
                    public GraphQLObjectType f15643a;
                    @Nullable
                    public String f15644b;
                }

                /* compiled from: device_family */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(NodeModel.class, new Deserializer());
                    }

                    public Object m18259a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(RedirectionInfoParser.NodeParser.m18397a(jsonParser, flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        mutableFlatBuffer.a(4, Boolean.valueOf(true));
                        MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                        Object nodeModel = new NodeModel();
                        ((BaseModel) nodeModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                        if (nodeModel instanceof Postprocessable) {
                            return ((Postprocessable) nodeModel).a();
                        }
                        return nodeModel;
                    }
                }

                /* compiled from: device_family */
                public class Serializer extends JsonSerializer<NodeModel> {
                    public final void m18260a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        NodeModel nodeModel = (NodeModel) obj;
                        if (nodeModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(nodeModel.m18262a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            nodeModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        RedirectionInfoParser.NodeParser.m18398a(nodeModel.w_(), nodeModel.u_(), jsonGenerator);
                    }

                    static {
                        FbSerializerProvider.a(NodeModel.class, new Serializer());
                    }
                }

                public NodeModel() {
                    super(2);
                }

                public NodeModel(MutableFlatBuffer mutableFlatBuffer) {
                    super(2);
                    a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }

                public final void m18265a(String str, ConsistencyTuple consistencyTuple) {
                    consistencyTuple.a();
                }

                public final void m18266a(String str, Object obj, boolean z) {
                }

                @Nullable
                public final GraphQLObjectType m18267b() {
                    if (this.b != null && this.f15645d == null) {
                        this.f15645d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
                    }
                    return this.f15645d;
                }

                @Nullable
                public final String m18268c() {
                    this.f15646e = super.a(this.f15646e, 1);
                    return this.f15646e;
                }

                public static NodeModel m18261a(NodeModel nodeModel) {
                    if (nodeModel == null) {
                        return null;
                    }
                    if (nodeModel instanceof NodeModel) {
                        return nodeModel;
                    }
                    Builder builder = new Builder();
                    builder.f15643a = nodeModel.m18267b();
                    builder.f15644b = nodeModel.m18268c();
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    int a = ModelHelper.a(flatBufferBuilder, builder.f15643a);
                    int b = flatBufferBuilder.b(builder.f15644b);
                    flatBufferBuilder.c(2);
                    flatBufferBuilder.b(0, a);
                    flatBufferBuilder.b(1, b);
                    flatBufferBuilder.d(flatBufferBuilder.d());
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    return new NodeModel(new MutableFlatBuffer(wrap, null, null, true, null));
                }

                @Nullable
                public final String m18264a() {
                    return m18268c();
                }

                public final int jK_() {
                    return 2433570;
                }

                public final GraphQLVisitableModel m18263a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    h();
                    i();
                    return this;
                }

                public final int m18262a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int a = ModelHelper.a(flatBufferBuilder, m18267b());
                    int b = flatBufferBuilder.b(m18268c());
                    flatBufferBuilder.c(2);
                    flatBufferBuilder.b(0, a);
                    flatBufferBuilder.b(1, b);
                    i();
                    return flatBufferBuilder.d();
                }
            }

            /* compiled from: device_family */
            public class Serializer extends JsonSerializer<RedirectionInfoModel> {
                public final void m18269a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    RedirectionInfoModel redirectionInfoModel = (RedirectionInfoModel) obj;
                    if (redirectionInfoModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(redirectionInfoModel.m18272a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        redirectionInfoModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    RedirectionInfoParser.m18402b(redirectionInfoModel.w_(), redirectionInfoModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(RedirectionInfoModel.class, new Serializer());
                }
            }

            @Nullable
            public final /* synthetic */ NodeModel m18274a() {
                return m18271j();
            }

            public RedirectionInfoModel() {
                super(3);
            }

            public RedirectionInfoModel(MutableFlatBuffer mutableFlatBuffer) {
                super(3);
                a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
            }

            @Nullable
            private NodeModel m18271j() {
                this.f15647d = (NodeModel) super.a(this.f15647d, 0, NodeModel.class);
                return this.f15647d;
            }

            @Nullable
            public final GraphQLRedirectionReason m18275b() {
                this.f15648e = (GraphQLRedirectionReason) super.b(this.f15648e, 1, GraphQLRedirectionReason.class, GraphQLRedirectionReason.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
                return this.f15648e;
            }

            @Nullable
            public final String m18276c() {
                this.f15649f = super.a(this.f15649f, 2);
                return this.f15649f;
            }

            public static RedirectionInfoModel m18270a(RedirectionInfoModel redirectionInfoModel) {
                if (redirectionInfoModel == null) {
                    return null;
                }
                if (redirectionInfoModel instanceof RedirectionInfoModel) {
                    return redirectionInfoModel;
                }
                Builder builder = new Builder();
                builder.f15640a = NodeModel.m18261a(redirectionInfoModel.m18274a());
                builder.f15641b = redirectionInfoModel.m18275b();
                builder.f15642c = redirectionInfoModel.m18276c();
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                int a = ModelHelper.a(flatBufferBuilder, builder.f15640a);
                int a2 = flatBufferBuilder.a(builder.f15641b);
                int b = flatBufferBuilder.b(builder.f15642c);
                flatBufferBuilder.c(3);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.b(1, a2);
                flatBufferBuilder.b(2, b);
                flatBufferBuilder.d(flatBufferBuilder.d());
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                return new RedirectionInfoModel(new MutableFlatBuffer(wrap, null, null, true, null));
            }

            public final int jK_() {
                return -986866342;
            }

            public final GraphQLVisitableModel m18273a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m18271j() != null) {
                    NodeModel nodeModel = (NodeModel) graphQLModelMutatingVisitor.b(m18271j());
                    if (m18271j() != nodeModel) {
                        graphQLVisitableModel = (RedirectionInfoModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f15647d = nodeModel;
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m18272a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m18271j());
                int a2 = flatBufferBuilder.a(m18275b());
                int b = flatBufferBuilder.b(m18276c());
                flatBufferBuilder.c(3);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.b(1, a2);
                flatBufferBuilder.b(2, b);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: device_family */
        public class Serializer extends JsonSerializer<PageTWEFragmentModel> {
            public final void m18277a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                PageTWEFragmentModel pageTWEFragmentModel = (PageTWEFragmentModel) obj;
                if (pageTWEFragmentModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(pageTWEFragmentModel.m18280a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    pageTWEFragmentModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = pageTWEFragmentModel.w_();
                int u_ = pageTWEFragmentModel.u_();
                jsonGenerator.f();
                if (mutableFlatBuffer.g(u_, 0) != 0) {
                    jsonGenerator.a("id");
                    jsonGenerator.b(mutableFlatBuffer.c(u_, 0));
                }
                int g = mutableFlatBuffer.g(u_, 1);
                if (g != 0) {
                    jsonGenerator.a("redirection_info");
                    RedirectionInfoParser.m18400a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(PageTWEFragmentModel.class, new Serializer());
            }
        }

        public PageTWEFragmentModel() {
            super(2);
        }

        public final void m18283a(String str, ConsistencyTuple consistencyTuple) {
            consistencyTuple.a();
        }

        public final void m18284a(String str, Object obj, boolean z) {
        }

        @Nullable
        private String m18278j() {
            this.f15650d = super.a(this.f15650d, 0);
            return this.f15650d;
        }

        @Nonnull
        private ImmutableList<RedirectionInfoModel> m18279k() {
            this.f15651e = super.a(this.f15651e, 1, RedirectionInfoModel.class);
            return (ImmutableList) this.f15651e;
        }

        @Nullable
        public final String m18282a() {
            return m18278j();
        }

        public final int jK_() {
            return 2479791;
        }

        public final GraphQLVisitableModel m18281a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m18279k() != null) {
                Builder a = ModelHelper.a(m18279k(), graphQLModelMutatingVisitor);
                if (a != null) {
                    graphQLVisitableModel = (PageTWEFragmentModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f15651e = a.b();
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m18280a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int b = flatBufferBuilder.b(m18278j());
            int a = ModelHelper.a(flatBufferBuilder, m18279k());
            flatBufferBuilder.c(2);
            flatBufferBuilder.b(0, b);
            flatBufferBuilder.b(1, a);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 434119473)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: device_family */
    public final class Photo320FragmentModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableModel, PhotoWithoutSizedImagesFragment {
        @Nullable
        private AlbumModel f15662d;
        private boolean f15663e;
        private long f15664f;
        @Nullable
        private DefaultVect2FieldsModel f15665g;
        @Nullable
        private String f15666h;
        @Nullable
        private BrowseNearbyPlacesFullImageFragmentModel f15667i;
        @Nullable
        private BrowseNearbyPlacesFullImageFragmentModel f15668j;
        private boolean f15669k;
        @Nullable
        private FBTextWithEntitiesModel f15670l;
        private long f15671m;

        /* compiled from: device_family */
        public final class Builder {
            @Nullable
            public AlbumModel f15652a;
            public boolean f15653b;
            public long f15654c;
            @Nullable
            public DefaultVect2FieldsModel f15655d;
            @Nullable
            public String f15656e;
            @Nullable
            public BrowseNearbyPlacesFullImageFragmentModel f15657f;
            @Nullable
            public BrowseNearbyPlacesFullImageFragmentModel f15658g;
            public boolean f15659h;
            @Nullable
            public FBTextWithEntitiesModel f15660i;
            public long f15661j;

            public final Photo320FragmentModel m18285a() {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                int a = ModelHelper.a(flatBufferBuilder, this.f15652a);
                int a2 = ModelHelper.a(flatBufferBuilder, this.f15655d);
                int b = flatBufferBuilder.b(this.f15656e);
                int a3 = ModelHelper.a(flatBufferBuilder, this.f15657f);
                int a4 = ModelHelper.a(flatBufferBuilder, this.f15658g);
                int a5 = ModelHelper.a(flatBufferBuilder, this.f15660i);
                flatBufferBuilder.c(10);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.a(1, this.f15653b);
                flatBufferBuilder.a(2, this.f15654c, 0);
                flatBufferBuilder.b(3, a2);
                flatBufferBuilder.b(4, b);
                flatBufferBuilder.b(5, a3);
                flatBufferBuilder.b(6, a4);
                flatBufferBuilder.a(7, this.f15659h);
                flatBufferBuilder.b(8, a5);
                flatBufferBuilder.a(9, this.f15661j, 0);
                flatBufferBuilder.d(flatBufferBuilder.d());
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                return new Photo320FragmentModel(new MutableFlatBuffer(wrap, null, null, true, null));
            }
        }

        /* compiled from: device_family */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(Photo320FragmentModel.class, new Deserializer());
            }

            public Object m18286a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(Photo320FragmentParser.m18406b(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object photo320FragmentModel = new Photo320FragmentModel();
                ((BaseModel) photo320FragmentModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (photo320FragmentModel instanceof Postprocessable) {
                    return ((Postprocessable) photo320FragmentModel).a();
                }
                return photo320FragmentModel;
            }
        }

        /* compiled from: device_family */
        public class Serializer extends JsonSerializer<Photo320FragmentModel> {
            public final void m18287a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                Photo320FragmentModel photo320FragmentModel = (Photo320FragmentModel) obj;
                if (photo320FragmentModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(photo320FragmentModel.m18294a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    photo320FragmentModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                Photo320FragmentParser.m18407b(photo320FragmentModel.w_(), photo320FragmentModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(Photo320FragmentModel.class, new Serializer());
            }
        }

        @Nullable
        public final /* synthetic */ AlbumModel m18298b() {
            return m18289m();
        }

        @Nullable
        public final /* synthetic */ FBTextWithEntitiesModel m18303k() {
            return m18293q();
        }

        @Nullable
        public final /* synthetic */ BrowseNearbyPlacesFullImageFragmentModel kd_() {
            return m18292p();
        }

        @Nullable
        public final /* synthetic */ BrowseNearbyPlacesFullImageFragmentModel ke_() {
            return m18291o();
        }

        @Nullable
        public final /* synthetic */ DefaultVect2Fields kf_() {
            return m18290n();
        }

        public Photo320FragmentModel() {
            super(10);
        }

        public Photo320FragmentModel(MutableFlatBuffer mutableFlatBuffer) {
            super(10);
            a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
        }

        @Nullable
        private AlbumModel m18289m() {
            this.f15662d = (AlbumModel) super.a(this.f15662d, 0, AlbumModel.class);
            return this.f15662d;
        }

        public final boolean m18299c() {
            a(0, 1);
            return this.f15663e;
        }

        public final long m18300d() {
            a(0, 2);
            return this.f15664f;
        }

        @Nullable
        private DefaultVect2FieldsModel m18290n() {
            this.f15665g = (DefaultVect2FieldsModel) super.a(this.f15665g, 3, DefaultVect2FieldsModel.class);
            return this.f15665g;
        }

        @Nullable
        public final String m18301g() {
            this.f15666h = super.a(this.f15666h, 4);
            return this.f15666h;
        }

        @Nullable
        private BrowseNearbyPlacesFullImageFragmentModel m18291o() {
            this.f15667i = (BrowseNearbyPlacesFullImageFragmentModel) super.a(this.f15667i, 5, BrowseNearbyPlacesFullImageFragmentModel.class);
            return this.f15667i;
        }

        @Nullable
        private BrowseNearbyPlacesFullImageFragmentModel m18292p() {
            this.f15668j = (BrowseNearbyPlacesFullImageFragmentModel) super.a(this.f15668j, 6, BrowseNearbyPlacesFullImageFragmentModel.class);
            return this.f15668j;
        }

        public final boolean m18302j() {
            a(0, 7);
            return this.f15669k;
        }

        @Nullable
        private FBTextWithEntitiesModel m18293q() {
            this.f15670l = (FBTextWithEntitiesModel) super.a(this.f15670l, 8, FBTextWithEntitiesModel.class);
            return this.f15670l;
        }

        public final long m18304l() {
            a(1, 1);
            return this.f15671m;
        }

        public static Photo320FragmentModel m18288a(Photo320FragmentModel photo320FragmentModel) {
            if (photo320FragmentModel == null) {
                return null;
            }
            if (photo320FragmentModel instanceof Photo320FragmentModel) {
                return photo320FragmentModel;
            }
            Builder builder = new Builder();
            builder.f15652a = AlbumModel.m18307a(photo320FragmentModel.m18298b());
            builder.f15653b = photo320FragmentModel.m18299c();
            builder.f15654c = photo320FragmentModel.m18300d();
            builder.f15655d = DefaultVect2FieldsModel.a(photo320FragmentModel.kf_());
            builder.f15656e = photo320FragmentModel.m18301g();
            builder.f15657f = BrowseNearbyPlacesFullImageFragmentModel.m17800a(photo320FragmentModel.ke_());
            builder.f15658g = BrowseNearbyPlacesFullImageFragmentModel.m17800a(photo320FragmentModel.kd_());
            builder.f15659h = photo320FragmentModel.m18302j();
            builder.f15660i = FBTextWithEntitiesModel.m5708a(photo320FragmentModel.m18303k());
            builder.f15661j = photo320FragmentModel.m18304l();
            return builder.m18285a();
        }

        @Nullable
        public final String m18296a() {
            return m18301g();
        }

        public final int jK_() {
            return 77090322;
        }

        public final GraphQLVisitableModel m18295a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            BrowseNearbyPlacesFullImageFragmentModel browseNearbyPlacesFullImageFragmentModel;
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m18289m() != null) {
                AlbumModel albumModel = (AlbumModel) graphQLModelMutatingVisitor.b(m18289m());
                if (m18289m() != albumModel) {
                    graphQLVisitableModel = (Photo320FragmentModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f15662d = albumModel;
                }
            }
            if (m18290n() != null) {
                DefaultVect2FieldsModel defaultVect2FieldsModel = (DefaultVect2FieldsModel) graphQLModelMutatingVisitor.b(m18290n());
                if (m18290n() != defaultVect2FieldsModel) {
                    graphQLVisitableModel = (Photo320FragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f15665g = defaultVect2FieldsModel;
                }
            }
            if (m18291o() != null) {
                browseNearbyPlacesFullImageFragmentModel = (BrowseNearbyPlacesFullImageFragmentModel) graphQLModelMutatingVisitor.b(m18291o());
                if (m18291o() != browseNearbyPlacesFullImageFragmentModel) {
                    graphQLVisitableModel = (Photo320FragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f15667i = browseNearbyPlacesFullImageFragmentModel;
                }
            }
            if (m18292p() != null) {
                browseNearbyPlacesFullImageFragmentModel = (BrowseNearbyPlacesFullImageFragmentModel) graphQLModelMutatingVisitor.b(m18292p());
                if (m18292p() != browseNearbyPlacesFullImageFragmentModel) {
                    graphQLVisitableModel = (Photo320FragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f15668j = browseNearbyPlacesFullImageFragmentModel;
                }
            }
            if (m18293q() != null) {
                FBTextWithEntitiesModel fBTextWithEntitiesModel = (FBTextWithEntitiesModel) graphQLModelMutatingVisitor.b(m18293q());
                if (m18293q() != fBTextWithEntitiesModel) {
                    graphQLVisitableModel = (Photo320FragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f15670l = fBTextWithEntitiesModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m18294a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m18289m());
            int a2 = ModelHelper.a(flatBufferBuilder, m18290n());
            int b = flatBufferBuilder.b(m18301g());
            int a3 = ModelHelper.a(flatBufferBuilder, m18291o());
            int a4 = ModelHelper.a(flatBufferBuilder, m18292p());
            int a5 = ModelHelper.a(flatBufferBuilder, m18293q());
            flatBufferBuilder.c(10);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.a(1, this.f15663e);
            flatBufferBuilder.a(2, this.f15664f, 0);
            flatBufferBuilder.b(3, a2);
            flatBufferBuilder.b(4, b);
            flatBufferBuilder.b(5, a3);
            flatBufferBuilder.b(6, a4);
            flatBufferBuilder.a(7, this.f15669k);
            flatBufferBuilder.b(8, a5);
            flatBufferBuilder.a(9, this.f15671m, 0);
            i();
            return flatBufferBuilder.d();
        }

        public final void m18297a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
            super.a(mutableFlatBuffer, i, obj);
            this.f15663e = mutableFlatBuffer.a(i, 1);
            this.f15664f = mutableFlatBuffer.a(i, 2, 0);
            this.f15669k = mutableFlatBuffer.a(i, 7);
            this.f15671m = mutableFlatBuffer.a(i, 9, 0);
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 125460134)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: device_family */
    public final class PhotoWithoutSizedImagesFragmentModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableModel, PhotoWithoutSizedImagesFragment {
        @Nullable
        private AlbumModel f15676d;
        private boolean f15677e;
        private long f15678f;
        @Nullable
        private String f15679g;
        @Nullable
        private BrowseNearbyPlacesFullImageFragmentModel f15680h;
        private boolean f15681i;
        @Nullable
        private FBTextWithEntitiesModel f15682j;
        private long f15683k;

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 2017887533)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: device_family */
        public final class AlbumModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableModel, FullAlbumFragment {
            @Nullable
            private String f15674d;
            @Nullable
            private TitleModel f15675e;

            /* compiled from: device_family */
            public final class Builder {
                @Nullable
                public String f15672a;
                @Nullable
                public TitleModel f15673b;
            }

            /* compiled from: device_family */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(AlbumModel.class, new Deserializer());
                }

                public Object m18305a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(AlbumParser.m18408a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object albumModel = new AlbumModel();
                    ((BaseModel) albumModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (albumModel instanceof Postprocessable) {
                        return ((Postprocessable) albumModel).a();
                    }
                    return albumModel;
                }
            }

            /* compiled from: device_family */
            public class Serializer extends JsonSerializer<AlbumModel> {
                public final void m18306a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    AlbumModel albumModel = (AlbumModel) obj;
                    if (albumModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(albumModel.m18309a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        albumModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    AlbumParser.m18409a(albumModel.w_(), albumModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(AlbumModel.class, new Serializer());
                }
            }

            @Nullable
            public final /* synthetic */ TitleModel m18313c() {
                return m18308j();
            }

            public AlbumModel() {
                super(2);
            }

            public AlbumModel(MutableFlatBuffer mutableFlatBuffer) {
                super(2);
                a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
            }

            @Nullable
            public final String m18312b() {
                this.f15674d = super.a(this.f15674d, 0);
                return this.f15674d;
            }

            @Nullable
            private TitleModel m18308j() {
                this.f15675e = (TitleModel) super.a(this.f15675e, 1, TitleModel.class);
                return this.f15675e;
            }

            public static AlbumModel m18307a(AlbumModel albumModel) {
                if (albumModel == null) {
                    return null;
                }
                if (albumModel instanceof AlbumModel) {
                    return albumModel;
                }
                Builder builder = new Builder();
                builder.f15672a = albumModel.m18312b();
                builder.f15673b = TitleModel.m17812a(albumModel.m18313c());
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                int b = flatBufferBuilder.b(builder.f15672a);
                int a = ModelHelper.a(flatBufferBuilder, builder.f15673b);
                flatBufferBuilder.c(2);
                flatBufferBuilder.b(0, b);
                flatBufferBuilder.b(1, a);
                flatBufferBuilder.d(flatBufferBuilder.d());
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                return new AlbumModel(new MutableFlatBuffer(wrap, null, null, true, null));
            }

            @Nullable
            public final String m18311a() {
                return m18312b();
            }

            public final int jK_() {
                return 63344207;
            }

            public final GraphQLVisitableModel m18310a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m18308j() != null) {
                    TitleModel titleModel = (TitleModel) graphQLModelMutatingVisitor.b(m18308j());
                    if (m18308j() != titleModel) {
                        graphQLVisitableModel = (AlbumModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f15675e = titleModel;
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m18309a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m18312b());
                int a = ModelHelper.a(flatBufferBuilder, m18308j());
                flatBufferBuilder.c(2);
                flatBufferBuilder.b(0, b);
                flatBufferBuilder.b(1, a);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: device_family */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(PhotoWithoutSizedImagesFragmentModel.class, new Deserializer());
            }

            public Object m18314a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(PhotoWithoutSizedImagesFragmentParser.m18410a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object photoWithoutSizedImagesFragmentModel = new PhotoWithoutSizedImagesFragmentModel();
                ((BaseModel) photoWithoutSizedImagesFragmentModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (photoWithoutSizedImagesFragmentModel instanceof Postprocessable) {
                    return ((Postprocessable) photoWithoutSizedImagesFragmentModel).a();
                }
                return photoWithoutSizedImagesFragmentModel;
            }
        }

        /* compiled from: device_family */
        public class Serializer extends JsonSerializer<PhotoWithoutSizedImagesFragmentModel> {
            public final void m18315a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                PhotoWithoutSizedImagesFragmentModel photoWithoutSizedImagesFragmentModel = (PhotoWithoutSizedImagesFragmentModel) obj;
                if (photoWithoutSizedImagesFragmentModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(photoWithoutSizedImagesFragmentModel.m18320a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    photoWithoutSizedImagesFragmentModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                PhotoWithoutSizedImagesFragmentParser.m18411a(photoWithoutSizedImagesFragmentModel.w_(), photoWithoutSizedImagesFragmentModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(PhotoWithoutSizedImagesFragmentModel.class, new Serializer());
            }
        }

        public PhotoWithoutSizedImagesFragmentModel() {
            super(8);
        }

        @Nullable
        private AlbumModel m18316j() {
            this.f15676d = (AlbumModel) super.a(this.f15676d, 0, AlbumModel.class);
            return this.f15676d;
        }

        @Nullable
        private String m18317k() {
            this.f15679g = super.a(this.f15679g, 3);
            return this.f15679g;
        }

        @Nullable
        private BrowseNearbyPlacesFullImageFragmentModel m18318l() {
            this.f15680h = (BrowseNearbyPlacesFullImageFragmentModel) super.a(this.f15680h, 4, BrowseNearbyPlacesFullImageFragmentModel.class);
            return this.f15680h;
        }

        @Nullable
        private FBTextWithEntitiesModel m18319m() {
            this.f15682j = (FBTextWithEntitiesModel) super.a(this.f15682j, 6, FBTextWithEntitiesModel.class);
            return this.f15682j;
        }

        @Nullable
        public final String m18322a() {
            return m18317k();
        }

        public final int jK_() {
            return 77090322;
        }

        public final GraphQLVisitableModel m18321a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m18316j() != null) {
                AlbumModel albumModel = (AlbumModel) graphQLModelMutatingVisitor.b(m18316j());
                if (m18316j() != albumModel) {
                    graphQLVisitableModel = (PhotoWithoutSizedImagesFragmentModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f15676d = albumModel;
                }
            }
            if (m18318l() != null) {
                BrowseNearbyPlacesFullImageFragmentModel browseNearbyPlacesFullImageFragmentModel = (BrowseNearbyPlacesFullImageFragmentModel) graphQLModelMutatingVisitor.b(m18318l());
                if (m18318l() != browseNearbyPlacesFullImageFragmentModel) {
                    graphQLVisitableModel = (PhotoWithoutSizedImagesFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f15680h = browseNearbyPlacesFullImageFragmentModel;
                }
            }
            if (m18319m() != null) {
                FBTextWithEntitiesModel fBTextWithEntitiesModel = (FBTextWithEntitiesModel) graphQLModelMutatingVisitor.b(m18319m());
                if (m18319m() != fBTextWithEntitiesModel) {
                    graphQLVisitableModel = (PhotoWithoutSizedImagesFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f15682j = fBTextWithEntitiesModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m18320a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m18316j());
            int b = flatBufferBuilder.b(m18317k());
            int a2 = ModelHelper.a(flatBufferBuilder, m18318l());
            int a3 = ModelHelper.a(flatBufferBuilder, m18319m());
            flatBufferBuilder.c(8);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.a(1, this.f15677e);
            flatBufferBuilder.a(2, this.f15678f, 0);
            flatBufferBuilder.b(3, b);
            flatBufferBuilder.b(4, a2);
            flatBufferBuilder.a(5, this.f15681i);
            flatBufferBuilder.b(6, a3);
            flatBufferBuilder.a(7, this.f15683k, 0);
            i();
            return flatBufferBuilder.d();
        }

        public final void m18323a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
            super.a(mutableFlatBuffer, i, obj);
            this.f15677e = mutableFlatBuffer.a(i, 1);
            this.f15678f = mutableFlatBuffer.a(i, 2, 0);
            this.f15681i = mutableFlatBuffer.a(i, 5);
            this.f15683k = mutableFlatBuffer.a(i, 7, 0);
        }
    }
}
