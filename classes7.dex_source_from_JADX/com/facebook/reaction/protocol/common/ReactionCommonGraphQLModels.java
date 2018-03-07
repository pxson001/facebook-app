package com.facebook.reaction.protocol.common;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbSerializerProvider;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.entitycards.contextitems.graphql.ContextItemsQueryModels.ContextItemsConnectionWithPageInfoFragmentModel;
import com.facebook.entitycards.contextitems.graphql.ContextItemsQueryParsers.ContextItemsConnectionWithPageInfoFragmentParser;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.FragmentModelWithoutBridge;
import com.facebook.flatbuffers.ModelWithFlatBufferFormatHash;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.enums.GraphQLObjectType;
import com.facebook.graphql.enums.GraphQLSavedState;
import com.facebook.graphql.enums.GraphQLSubscribeStatus;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.ModelHelper;
import com.facebook.graphql.querybuilder.common.CommonGraphQLInterfaces.DefaultImageFields;
import com.facebook.graphql.querybuilder.common.CommonGraphQLInterfaces.DefaultLocationFields;
import com.facebook.graphql.querybuilder.common.CommonGraphQLModels.DefaultAddressFieldsModel;
import com.facebook.graphql.querybuilder.common.CommonGraphQLModels.DefaultImageFieldsModel;
import com.facebook.graphql.querybuilder.common.CommonGraphQLModels.DefaultLocationFieldsModel;
import com.facebook.graphql.querybuilder.common.CommonGraphQLModels.DefaultTimeRangeFieldsModel;
import com.facebook.graphql.querybuilder.common.CommonGraphQLParsers.DefaultAddressFieldsParser;
import com.facebook.graphql.querybuilder.common.CommonGraphQLParsers.DefaultLocationFieldsParser;
import com.facebook.graphql.querybuilder.common.TextWithEntitiesGraphQLInterfaces.DefaultTextWithEntitiesFields;
import com.facebook.graphql.querybuilder.common.TextWithEntitiesGraphQLModels.DefaultTextWithEntitiesFieldsModel;
import com.facebook.graphql.visitor.ConsistencyTuple;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLPersistableNode;
import com.facebook.graphql.visitor.GraphQLVisitableConsistentModel;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.facebook.reaction.protocol.common.ReactionCommonGraphQLInterfaces.ReactionFacepileProfile;
import com.facebook.reaction.protocol.common.ReactionCommonGraphQLInterfaces.ReactionImageFields;
import com.facebook.reaction.protocol.common.ReactionCommonGraphQLInterfaces.ReactionPageFields;
import com.facebook.reaction.protocol.common.ReactionCommonGraphQLInterfaces.ReactionPlaceTipsPageFields;
import com.facebook.reaction.protocol.common.ReactionCommonGraphQLInterfaces.ReactionProfileFields;
import com.facebook.reaction.protocol.common.ReactionCommonGraphQLInterfaces.ReactionTextWithEntitiesWithImages;
import com.facebook.reaction.protocol.common.ReactionCommonGraphQLParsers.EntityWithImageScaledFragmentParser;
import com.facebook.reaction.protocol.common.ReactionCommonGraphQLParsers.EntityWithImageScaledFragmentParser.ImageParser;
import com.facebook.reaction.protocol.common.ReactionCommonGraphQLParsers.PlaceInfoBlurbFieldsParser;
import com.facebook.reaction.protocol.common.ReactionCommonGraphQLParsers.PlaceInfoBlurbFieldsParser.LocationParser;
import com.facebook.reaction.protocol.common.ReactionCommonGraphQLParsers.PlaceInfoBlurbFieldsParser.OverallStarRatingParser;
import com.facebook.reaction.protocol.common.ReactionCommonGraphQLParsers.ReactionFacepileProfileParser;
import com.facebook.reaction.protocol.common.ReactionCommonGraphQLParsers.ReactionFeedbackFieldsParser;
import com.facebook.reaction.protocol.common.ReactionCommonGraphQLParsers.ReactionGeoRectangleFieldsParser;
import com.facebook.reaction.protocol.common.ReactionCommonGraphQLParsers.ReactionImageFieldsParser;
import com.facebook.reaction.protocol.common.ReactionCommonGraphQLParsers.ReactionPageFieldsParser;
import com.facebook.reaction.protocol.common.ReactionCommonGraphQLParsers.ReactionPageFieldsParser.CoverPhotoParser;
import com.facebook.reaction.protocol.common.ReactionCommonGraphQLParsers.ReactionPageFieldsParser.CoverPhotoParser.PhotoParser;
import com.facebook.reaction.protocol.common.ReactionCommonGraphQLParsers.ReactionPageFieldsWithPlaceTipsInfoParser;
import com.facebook.reaction.protocol.common.ReactionCommonGraphQLParsers.ReactionPlaceTipsPageFieldsParser;
import com.facebook.reaction.protocol.common.ReactionCommonGraphQLParsers.ReactionPlaceTipsPageFieldsParser.MenuInfoParser;
import com.facebook.reaction.protocol.common.ReactionCommonGraphQLParsers.ReactionProfileFieldsParser;
import com.facebook.reaction.protocol.common.ReactionCommonGraphQLParsers.ReactionStoryAttachmentStoryFragmentParser;
import com.facebook.reaction.protocol.common.ReactionCommonGraphQLParsers.ReactionStoryAttachmentStoryFragmentParser.ActorsParser;
import com.facebook.reaction.protocol.common.ReactionCommonGraphQLParsers.ReactionStoryAttachmentStoryFragmentParser.FeedbackParser;
import com.facebook.reaction.protocol.common.ReactionCommonGraphQLParsers.ReactionTextWithEntitiesWithImagesParser;
import com.facebook.reaction.protocol.common.ReactionCommonGraphQLParsers.ReactionTextWithEntitiesWithImagesParser.ImageRangesParser;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.google.common.collect.ImmutableList;
import java.nio.ByteBuffer;
import java.util.List;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/* compiled from: find_friends_view_clicked */
public class ReactionCommonGraphQLModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -418195809)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: find_friends_view_clicked */
    public final class EntityWithImageScaledFragmentModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private GraphQLObjectType f12038d;
        @Nullable
        private ImageModel f12039e;

        /* compiled from: find_friends_view_clicked */
        public final class Builder {
            @Nullable
            public GraphQLObjectType f12034a;
            @Nullable
            public ImageModel f12035b;
        }

        /* compiled from: find_friends_view_clicked */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(EntityWithImageScaledFragmentModel.class, new Deserializer());
            }

            public Object m14416a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(EntityWithImageScaledFragmentParser.m14676a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object entityWithImageScaledFragmentModel = new EntityWithImageScaledFragmentModel();
                ((BaseModel) entityWithImageScaledFragmentModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (entityWithImageScaledFragmentModel instanceof Postprocessable) {
                    return ((Postprocessable) entityWithImageScaledFragmentModel).a();
                }
                return entityWithImageScaledFragmentModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 842551240)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: find_friends_view_clicked */
        public final class ImageModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private String f12037d;

            /* compiled from: find_friends_view_clicked */
            public final class Builder {
                @Nullable
                public String f12036a;
            }

            /* compiled from: find_friends_view_clicked */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(ImageModel.class, new Deserializer());
                }

                public Object m14417a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(ImageParser.m14674a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object imageModel = new ImageModel();
                    ((BaseModel) imageModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (imageModel instanceof Postprocessable) {
                        return ((Postprocessable) imageModel).a();
                    }
                    return imageModel;
                }
            }

            /* compiled from: find_friends_view_clicked */
            public class Serializer extends JsonSerializer<ImageModel> {
                public final void m14418a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    ImageModel imageModel = (ImageModel) obj;
                    if (imageModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(imageModel.m14420a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        imageModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    ImageParser.m14675a(imageModel.w_(), imageModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(ImageModel.class, new Serializer());
                }
            }

            public ImageModel() {
                super(1);
            }

            public ImageModel(MutableFlatBuffer mutableFlatBuffer) {
                super(1);
                a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
            }

            @Nullable
            public final String m14422a() {
                this.f12037d = super.a(this.f12037d, 0);
                return this.f12037d;
            }

            public static ImageModel m14419a(ImageModel imageModel) {
                if (imageModel == null) {
                    return null;
                }
                if (imageModel instanceof ImageModel) {
                    return imageModel;
                }
                Builder builder = new Builder();
                builder.f12036a = imageModel.m14422a();
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                int b = flatBufferBuilder.b(builder.f12036a);
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, b);
                flatBufferBuilder.d(flatBufferBuilder.d());
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                return new ImageModel(new MutableFlatBuffer(wrap, null, null, true, null));
            }

            public final int jK_() {
                return 70760763;
            }

            public final GraphQLVisitableModel m14421a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m14420a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m14422a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, b);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: find_friends_view_clicked */
        public class Serializer extends JsonSerializer<EntityWithImageScaledFragmentModel> {
            public final void m14423a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                EntityWithImageScaledFragmentModel entityWithImageScaledFragmentModel = (EntityWithImageScaledFragmentModel) obj;
                if (entityWithImageScaledFragmentModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(entityWithImageScaledFragmentModel.m14426a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    entityWithImageScaledFragmentModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                EntityWithImageScaledFragmentParser.m14677a(entityWithImageScaledFragmentModel.w_(), entityWithImageScaledFragmentModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(EntityWithImageScaledFragmentModel.class, new Serializer());
            }
        }

        @Nullable
        public final /* synthetic */ ImageModel m14429b() {
            return m14425j();
        }

        public EntityWithImageScaledFragmentModel() {
            super(2);
        }

        public EntityWithImageScaledFragmentModel(MutableFlatBuffer mutableFlatBuffer) {
            super(2);
            a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
        }

        @Nullable
        public final GraphQLObjectType m14427a() {
            if (this.b != null && this.f12038d == null) {
                this.f12038d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
            }
            return this.f12038d;
        }

        @Nullable
        private ImageModel m14425j() {
            this.f12039e = (ImageModel) super.a(this.f12039e, 1, ImageModel.class);
            return this.f12039e;
        }

        public static EntityWithImageScaledFragmentModel m14424a(EntityWithImageScaledFragmentModel entityWithImageScaledFragmentModel) {
            if (entityWithImageScaledFragmentModel == null) {
                return null;
            }
            if (entityWithImageScaledFragmentModel instanceof EntityWithImageScaledFragmentModel) {
                return entityWithImageScaledFragmentModel;
            }
            Builder builder = new Builder();
            builder.f12034a = entityWithImageScaledFragmentModel.m14427a();
            builder.f12035b = ImageModel.m14419a(entityWithImageScaledFragmentModel.m14429b());
            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
            int a = ModelHelper.a(flatBufferBuilder, builder.f12034a);
            int a2 = ModelHelper.a(flatBufferBuilder, builder.f12035b);
            flatBufferBuilder.c(2);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, a2);
            flatBufferBuilder.d(flatBufferBuilder.d());
            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
            wrap.position(0);
            return new EntityWithImageScaledFragmentModel(new MutableFlatBuffer(wrap, null, null, true, null));
        }

        public final int jK_() {
            return 463681394;
        }

        public final GraphQLVisitableModel m14428a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m14425j() != null) {
                ImageModel imageModel = (ImageModel) graphQLModelMutatingVisitor.b(m14425j());
                if (m14425j() != imageModel) {
                    graphQLVisitableModel = (EntityWithImageScaledFragmentModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f12039e = imageModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m14426a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m14427a());
            int a2 = ModelHelper.a(flatBufferBuilder, m14425j());
            flatBufferBuilder.c(2);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, a2);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 945256206)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: find_friends_view_clicked */
    public final class PlaceInfoBlurbFieldsModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
        @Nullable
        private List<DefaultTimeRangeFieldsModel> f12050d;
        @Nullable
        private String f12051e;
        @Nullable
        private LocationModel f12052f;
        @Nullable
        private String f12053g;
        @Nullable
        private OverallStarRatingModel f12054h;
        @Nullable
        private String f12055i;

        /* compiled from: find_friends_view_clicked */
        public final class Builder {
            @Nullable
            public ImmutableList<DefaultTimeRangeFieldsModel> f12040a;
            @Nullable
            public String f12041b;
            @Nullable
            public LocationModel f12042c;
            @Nullable
            public String f12043d;
            @Nullable
            public OverallStarRatingModel f12044e;
            @Nullable
            public String f12045f;
        }

        /* compiled from: find_friends_view_clicked */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(PlaceInfoBlurbFieldsModel.class, new Deserializer());
            }

            public Object m14430a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(PlaceInfoBlurbFieldsParser.m14682a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object placeInfoBlurbFieldsModel = new PlaceInfoBlurbFieldsModel();
                ((BaseModel) placeInfoBlurbFieldsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (placeInfoBlurbFieldsModel instanceof Postprocessable) {
                    return ((Postprocessable) placeInfoBlurbFieldsModel).a();
                }
                return placeInfoBlurbFieldsModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 855047979)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: find_friends_view_clicked */
        public final class LocationModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private String f12047d;

            /* compiled from: find_friends_view_clicked */
            public final class Builder {
                @Nullable
                public String f12046a;
            }

            /* compiled from: find_friends_view_clicked */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(LocationModel.class, new Deserializer());
                }

                public Object m14431a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(LocationParser.m14678a(jsonParser, flatBufferBuilder));
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

            /* compiled from: find_friends_view_clicked */
            public class Serializer extends JsonSerializer<LocationModel> {
                public final void m14432a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    LocationModel locationModel = (LocationModel) obj;
                    if (locationModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(locationModel.m14434a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        locationModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    LocationParser.m14679a(locationModel.w_(), locationModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(LocationModel.class, new Serializer());
                }
            }

            public LocationModel() {
                super(1);
            }

            public LocationModel(MutableFlatBuffer mutableFlatBuffer) {
                super(1);
                a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
            }

            @Nullable
            public final String m14436a() {
                this.f12047d = super.a(this.f12047d, 0);
                return this.f12047d;
            }

            public static LocationModel m14433a(LocationModel locationModel) {
                if (locationModel == null) {
                    return null;
                }
                if (locationModel instanceof LocationModel) {
                    return locationModel;
                }
                Builder builder = new Builder();
                builder.f12046a = locationModel.m14436a();
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                int b = flatBufferBuilder.b(builder.f12046a);
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, b);
                flatBufferBuilder.d(flatBufferBuilder.d());
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                return new LocationModel(new MutableFlatBuffer(wrap, null, null, true, null));
            }

            public final int jK_() {
                return 1965687765;
            }

            public final GraphQLVisitableModel m14435a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m14434a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m14436a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, b);
                i();
                return flatBufferBuilder.d();
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 276562124)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: find_friends_view_clicked */
        public final class OverallStarRatingModel extends BaseModel implements GraphQLVisitableModel {
            private double f12049d;

            /* compiled from: find_friends_view_clicked */
            public final class Builder {
                public double f12048a;
            }

            /* compiled from: find_friends_view_clicked */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(OverallStarRatingModel.class, new Deserializer());
                }

                public Object m14437a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(OverallStarRatingParser.m14680a(jsonParser, flatBufferBuilder));
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

            /* compiled from: find_friends_view_clicked */
            public class Serializer extends JsonSerializer<OverallStarRatingModel> {
                public final void m14438a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    OverallStarRatingModel overallStarRatingModel = (OverallStarRatingModel) obj;
                    if (overallStarRatingModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(overallStarRatingModel.m14441a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        overallStarRatingModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    OverallStarRatingParser.m14681a(overallStarRatingModel.w_(), overallStarRatingModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(OverallStarRatingModel.class, new Serializer());
                }
            }

            public OverallStarRatingModel() {
                super(1);
            }

            public OverallStarRatingModel(MutableFlatBuffer mutableFlatBuffer) {
                super(1);
                a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
            }

            public final double m14440a() {
                a(0, 0);
                return this.f12049d;
            }

            public static OverallStarRatingModel m14439a(OverallStarRatingModel overallStarRatingModel) {
                if (overallStarRatingModel == null) {
                    return null;
                }
                if (overallStarRatingModel instanceof OverallStarRatingModel) {
                    return overallStarRatingModel;
                }
                Builder builder = new Builder();
                builder.f12048a = overallStarRatingModel.m14440a();
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.c(1);
                flatBufferBuilder.a(0, builder.f12048a, 0.0d);
                flatBufferBuilder.d(flatBufferBuilder.d());
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                return new OverallStarRatingModel(new MutableFlatBuffer(wrap, null, null, true, null));
            }

            public final int jK_() {
                return -1854235203;
            }

            public final GraphQLVisitableModel m14442a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m14441a(FlatBufferBuilder flatBufferBuilder) {
                h();
                flatBufferBuilder.c(1);
                flatBufferBuilder.a(0, this.f12049d, 0.0d);
                i();
                return flatBufferBuilder.d();
            }

            public final void m14443a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                super.a(mutableFlatBuffer, i, obj);
                this.f12049d = mutableFlatBuffer.a(i, 0, 0.0d);
            }
        }

        /* compiled from: find_friends_view_clicked */
        public class Serializer extends JsonSerializer<PlaceInfoBlurbFieldsModel> {
            public final void m14444a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                PlaceInfoBlurbFieldsModel placeInfoBlurbFieldsModel = (PlaceInfoBlurbFieldsModel) obj;
                if (placeInfoBlurbFieldsModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(placeInfoBlurbFieldsModel.m14448a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    placeInfoBlurbFieldsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                PlaceInfoBlurbFieldsParser.m14683a(placeInfoBlurbFieldsModel.w_(), placeInfoBlurbFieldsModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(PlaceInfoBlurbFieldsModel.class, new Serializer());
            }
        }

        @Nullable
        public final /* synthetic */ LocationModel m14455d() {
            return m14446j();
        }

        @Nullable
        public final /* synthetic */ OverallStarRatingModel m14456g() {
            return m14447k();
        }

        public PlaceInfoBlurbFieldsModel() {
            super(6);
        }

        public PlaceInfoBlurbFieldsModel(MutableFlatBuffer mutableFlatBuffer) {
            super(6);
            a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
        }

        public final void m14451a(String str, ConsistencyTuple consistencyTuple) {
            consistencyTuple.a();
        }

        public final void m14452a(String str, Object obj, boolean z) {
        }

        @Nonnull
        public final ImmutableList<DefaultTimeRangeFieldsModel> m14453b() {
            this.f12050d = super.a(this.f12050d, 0, DefaultTimeRangeFieldsModel.class);
            return (ImmutableList) this.f12050d;
        }

        @Nullable
        public final String m14454c() {
            this.f12051e = super.a(this.f12051e, 1);
            return this.f12051e;
        }

        @Nullable
        private LocationModel m14446j() {
            this.f12052f = (LocationModel) super.a(this.f12052f, 2, LocationModel.class);
            return this.f12052f;
        }

        @Nullable
        public final String eD_() {
            this.f12053g = super.a(this.f12053g, 3);
            return this.f12053g;
        }

        @Nullable
        private OverallStarRatingModel m14447k() {
            this.f12054h = (OverallStarRatingModel) super.a(this.f12054h, 4, OverallStarRatingModel.class);
            return this.f12054h;
        }

        @Nullable
        public final String eE_() {
            this.f12055i = super.a(this.f12055i, 5);
            return this.f12055i;
        }

        public static PlaceInfoBlurbFieldsModel m14445a(PlaceInfoBlurbFieldsModel placeInfoBlurbFieldsModel) {
            if (placeInfoBlurbFieldsModel == null) {
                return null;
            }
            if (placeInfoBlurbFieldsModel instanceof PlaceInfoBlurbFieldsModel) {
                return placeInfoBlurbFieldsModel;
            }
            Builder builder = new Builder();
            com.google.common.collect.ImmutableList.Builder builder2 = ImmutableList.builder();
            for (int i = 0; i < placeInfoBlurbFieldsModel.m14453b().size(); i++) {
                builder2.c(DefaultTimeRangeFieldsModel.a((DefaultTimeRangeFieldsModel) placeInfoBlurbFieldsModel.m14453b().get(i)));
            }
            builder.f12040a = builder2.b();
            builder.f12041b = placeInfoBlurbFieldsModel.m14454c();
            builder.f12042c = LocationModel.m14433a(placeInfoBlurbFieldsModel.m14455d());
            builder.f12043d = placeInfoBlurbFieldsModel.eD_();
            builder.f12044e = OverallStarRatingModel.m14439a(placeInfoBlurbFieldsModel.m14456g());
            builder.f12045f = placeInfoBlurbFieldsModel.eE_();
            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
            int a = ModelHelper.a(flatBufferBuilder, builder.f12040a);
            int b = flatBufferBuilder.b(builder.f12041b);
            int a2 = ModelHelper.a(flatBufferBuilder, builder.f12042c);
            int b2 = flatBufferBuilder.b(builder.f12043d);
            int a3 = ModelHelper.a(flatBufferBuilder, builder.f12044e);
            int b3 = flatBufferBuilder.b(builder.f12045f);
            flatBufferBuilder.c(6);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, b);
            flatBufferBuilder.b(2, a2);
            flatBufferBuilder.b(3, b2);
            flatBufferBuilder.b(4, a3);
            flatBufferBuilder.b(5, b3);
            flatBufferBuilder.d(flatBufferBuilder.d());
            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
            wrap.position(0);
            return new PlaceInfoBlurbFieldsModel(new MutableFlatBuffer(wrap, null, null, true, null));
        }

        @Nullable
        public final String m14450a() {
            return m14454c();
        }

        public final int jK_() {
            return 2479791;
        }

        public final GraphQLVisitableModel m14449a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel;
            LocationModel locationModel;
            OverallStarRatingModel overallStarRatingModel;
            h();
            if (m14453b() != null) {
                com.google.common.collect.ImmutableList.Builder a = ModelHelper.a(m14453b(), graphQLModelMutatingVisitor);
                if (a != null) {
                    PlaceInfoBlurbFieldsModel placeInfoBlurbFieldsModel = (PlaceInfoBlurbFieldsModel) ModelHelper.a(null, this);
                    placeInfoBlurbFieldsModel.f12050d = a.b();
                    graphQLVisitableModel = placeInfoBlurbFieldsModel;
                    if (m14446j() != null) {
                        locationModel = (LocationModel) graphQLModelMutatingVisitor.b(m14446j());
                        if (m14446j() != locationModel) {
                            graphQLVisitableModel = (PlaceInfoBlurbFieldsModel) ModelHelper.a(graphQLVisitableModel, this);
                            graphQLVisitableModel.f12052f = locationModel;
                        }
                    }
                    if (m14447k() != null) {
                        overallStarRatingModel = (OverallStarRatingModel) graphQLModelMutatingVisitor.b(m14447k());
                        if (m14447k() != overallStarRatingModel) {
                            graphQLVisitableModel = (PlaceInfoBlurbFieldsModel) ModelHelper.a(graphQLVisitableModel, this);
                            graphQLVisitableModel.f12054h = overallStarRatingModel;
                        }
                    }
                    i();
                    return graphQLVisitableModel != null ? this : graphQLVisitableModel;
                }
            }
            graphQLVisitableModel = null;
            if (m14446j() != null) {
                locationModel = (LocationModel) graphQLModelMutatingVisitor.b(m14446j());
                if (m14446j() != locationModel) {
                    graphQLVisitableModel = (PlaceInfoBlurbFieldsModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f12052f = locationModel;
                }
            }
            if (m14447k() != null) {
                overallStarRatingModel = (OverallStarRatingModel) graphQLModelMutatingVisitor.b(m14447k());
                if (m14447k() != overallStarRatingModel) {
                    graphQLVisitableModel = (PlaceInfoBlurbFieldsModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f12054h = overallStarRatingModel;
                }
            }
            i();
            if (graphQLVisitableModel != null) {
            }
        }

        public final int m14448a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m14453b());
            int b = flatBufferBuilder.b(m14454c());
            int a2 = ModelHelper.a(flatBufferBuilder, m14446j());
            int b2 = flatBufferBuilder.b(eD_());
            int a3 = ModelHelper.a(flatBufferBuilder, m14447k());
            int b3 = flatBufferBuilder.b(eE_());
            flatBufferBuilder.c(6);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, b);
            flatBufferBuilder.b(2, a2);
            flatBufferBuilder.b(3, b2);
            flatBufferBuilder.b(4, a3);
            flatBufferBuilder.b(5, b3);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -2006933005)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: find_friends_view_clicked */
    public final class ReactionFacepileProfileModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel, ReactionFacepileProfile {
        @Nullable
        private GraphQLObjectType f12059d;
        @Nullable
        private String f12060e;
        @Nullable
        private ReactionImageFieldsModel f12061f;

        /* compiled from: find_friends_view_clicked */
        public final class Builder {
            @Nullable
            public GraphQLObjectType f12056a;
            @Nullable
            public String f12057b;
            @Nullable
            public ReactionImageFieldsModel f12058c;
        }

        /* compiled from: find_friends_view_clicked */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(ReactionFacepileProfileModel.class, new Deserializer());
            }

            public Object m14457a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(ReactionFacepileProfileParser.m14684a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object reactionFacepileProfileModel = new ReactionFacepileProfileModel();
                ((BaseModel) reactionFacepileProfileModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (reactionFacepileProfileModel instanceof Postprocessable) {
                    return ((Postprocessable) reactionFacepileProfileModel).a();
                }
                return reactionFacepileProfileModel;
            }
        }

        /* compiled from: find_friends_view_clicked */
        public class Serializer extends JsonSerializer<ReactionFacepileProfileModel> {
            public final void m14458a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                ReactionFacepileProfileModel reactionFacepileProfileModel = (ReactionFacepileProfileModel) obj;
                if (reactionFacepileProfileModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(reactionFacepileProfileModel.m14461a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    reactionFacepileProfileModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                ReactionFacepileProfileParser.m14685b(reactionFacepileProfileModel.w_(), reactionFacepileProfileModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(ReactionFacepileProfileModel.class, new Serializer());
            }
        }

        @Nullable
        public final /* synthetic */ ReactionImageFields mo772d() {
            return m14460j();
        }

        public ReactionFacepileProfileModel() {
            super(3);
        }

        public ReactionFacepileProfileModel(MutableFlatBuffer mutableFlatBuffer) {
            super(3);
            a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
        }

        public final void m14464a(String str, ConsistencyTuple consistencyTuple) {
            consistencyTuple.a();
        }

        public final void m14465a(String str, Object obj, boolean z) {
        }

        @Nullable
        public final GraphQLObjectType mo770b() {
            if (this.b != null && this.f12059d == null) {
                this.f12059d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
            }
            return this.f12059d;
        }

        @Nullable
        public final String mo771c() {
            this.f12060e = super.a(this.f12060e, 1);
            return this.f12060e;
        }

        @Nullable
        private ReactionImageFieldsModel m14460j() {
            this.f12061f = (ReactionImageFieldsModel) super.a(this.f12061f, 2, ReactionImageFieldsModel.class);
            return this.f12061f;
        }

        public static ReactionFacepileProfileModel m14459a(ReactionFacepileProfile reactionFacepileProfile) {
            if (reactionFacepileProfile == null) {
                return null;
            }
            if (reactionFacepileProfile instanceof ReactionFacepileProfileModel) {
                return (ReactionFacepileProfileModel) reactionFacepileProfile;
            }
            Builder builder = new Builder();
            builder.f12056a = reactionFacepileProfile.mo770b();
            builder.f12057b = reactionFacepileProfile.mo771c();
            builder.f12058c = ReactionImageFieldsModel.m14497a(reactionFacepileProfile.mo772d());
            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
            int a = ModelHelper.a(flatBufferBuilder, builder.f12056a);
            int b = flatBufferBuilder.b(builder.f12057b);
            int a2 = ModelHelper.a(flatBufferBuilder, builder.f12058c);
            flatBufferBuilder.c(3);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, b);
            flatBufferBuilder.b(2, a2);
            flatBufferBuilder.d(flatBufferBuilder.d());
            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
            wrap.position(0);
            return new ReactionFacepileProfileModel(new MutableFlatBuffer(wrap, null, null, true, null));
        }

        @Nullable
        public final String m14463a() {
            return mo771c();
        }

        public final int jK_() {
            return 1355227529;
        }

        public final GraphQLVisitableModel m14462a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m14460j() != null) {
                ReactionImageFieldsModel reactionImageFieldsModel = (ReactionImageFieldsModel) graphQLModelMutatingVisitor.b(m14460j());
                if (m14460j() != reactionImageFieldsModel) {
                    graphQLVisitableModel = (ReactionFacepileProfileModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f12061f = reactionImageFieldsModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m14461a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, mo770b());
            int b = flatBufferBuilder.b(mo771c());
            int a2 = ModelHelper.a(flatBufferBuilder, m14460j());
            flatBufferBuilder.c(3);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, b);
            flatBufferBuilder.b(2, a2);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -658419788)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: find_friends_view_clicked */
    public final class ReactionFeedbackFieldsModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
        private boolean f12066d;
        private boolean f12067e;
        @Nullable
        private String f12068f;
        @Nullable
        private String f12069g;

        /* compiled from: find_friends_view_clicked */
        public final class Builder {
            public boolean f12062a;
            public boolean f12063b;
            @Nullable
            public String f12064c;
            @Nullable
            public String f12065d;
        }

        /* compiled from: find_friends_view_clicked */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(ReactionFeedbackFieldsModel.class, new Deserializer());
            }

            public Object m14469a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(ReactionFeedbackFieldsParser.m14686a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object reactionFeedbackFieldsModel = new ReactionFeedbackFieldsModel();
                ((BaseModel) reactionFeedbackFieldsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (reactionFeedbackFieldsModel instanceof Postprocessable) {
                    return ((Postprocessable) reactionFeedbackFieldsModel).a();
                }
                return reactionFeedbackFieldsModel;
            }
        }

        /* compiled from: find_friends_view_clicked */
        public class Serializer extends JsonSerializer<ReactionFeedbackFieldsModel> {
            public final void m14470a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                ReactionFeedbackFieldsModel reactionFeedbackFieldsModel = (ReactionFeedbackFieldsModel) obj;
                if (reactionFeedbackFieldsModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(reactionFeedbackFieldsModel.m14474a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    reactionFeedbackFieldsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                ReactionFeedbackFieldsParser.m14687a(reactionFeedbackFieldsModel.w_(), reactionFeedbackFieldsModel.u_(), jsonGenerator);
            }

            static {
                FbSerializerProvider.a(ReactionFeedbackFieldsModel.class, new Serializer());
            }
        }

        public ReactionFeedbackFieldsModel() {
            super(4);
        }

        public ReactionFeedbackFieldsModel(MutableFlatBuffer mutableFlatBuffer) {
            super(4);
            a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
        }

        public final void m14478a(String str, ConsistencyTuple consistencyTuple) {
            if ("can_viewer_like".equals(str)) {
                consistencyTuple.a = Boolean.valueOf(m14480b());
                consistencyTuple.b = u_();
                consistencyTuple.c = 0;
            } else if ("does_viewer_like".equals(str)) {
                consistencyTuple.a = Boolean.valueOf(m14481c());
                consistencyTuple.b = u_();
                consistencyTuple.c = 1;
            } else {
                consistencyTuple.a();
            }
        }

        public final void m14479a(String str, Object obj, boolean z) {
            if ("can_viewer_like".equals(str)) {
                m14472a(((Boolean) obj).booleanValue());
            } else if ("does_viewer_like".equals(str)) {
                m14473b(((Boolean) obj).booleanValue());
            }
        }

        public final boolean m14480b() {
            a(0, 0);
            return this.f12066d;
        }

        private void m14472a(boolean z) {
            this.f12066d = z;
            if (this.b != null && this.b.d) {
                this.b.a(this.c, 0, z);
            }
        }

        public final boolean m14481c() {
            a(0, 1);
            return this.f12067e;
        }

        private void m14473b(boolean z) {
            this.f12067e = z;
            if (this.b != null && this.b.d) {
                this.b.a(this.c, 1, z);
            }
        }

        @Nullable
        public final String m14482d() {
            this.f12068f = super.a(this.f12068f, 2);
            return this.f12068f;
        }

        @Nullable
        public final String eF_() {
            this.f12069g = super.a(this.f12069g, 3);
            return this.f12069g;
        }

        public static ReactionFeedbackFieldsModel m14471a(ReactionFeedbackFieldsModel reactionFeedbackFieldsModel) {
            if (reactionFeedbackFieldsModel == null) {
                return null;
            }
            if (reactionFeedbackFieldsModel instanceof ReactionFeedbackFieldsModel) {
                return reactionFeedbackFieldsModel;
            }
            Builder builder = new Builder();
            builder.f12062a = reactionFeedbackFieldsModel.m14480b();
            builder.f12063b = reactionFeedbackFieldsModel.m14481c();
            builder.f12064c = reactionFeedbackFieldsModel.m14482d();
            builder.f12065d = reactionFeedbackFieldsModel.eF_();
            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
            int b = flatBufferBuilder.b(builder.f12064c);
            int b2 = flatBufferBuilder.b(builder.f12065d);
            flatBufferBuilder.c(4);
            flatBufferBuilder.a(0, builder.f12062a);
            flatBufferBuilder.a(1, builder.f12063b);
            flatBufferBuilder.b(2, b);
            flatBufferBuilder.b(3, b2);
            flatBufferBuilder.d(flatBufferBuilder.d());
            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
            wrap.position(0);
            return new ReactionFeedbackFieldsModel(new MutableFlatBuffer(wrap, null, null, true, null));
        }

        @Nullable
        public final String m14476a() {
            return eF_();
        }

        public final int jK_() {
            return -126857307;
        }

        public final GraphQLVisitableModel m14475a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            h();
            i();
            return this;
        }

        public final int m14474a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int b = flatBufferBuilder.b(m14482d());
            int b2 = flatBufferBuilder.b(eF_());
            flatBufferBuilder.c(4);
            flatBufferBuilder.a(0, this.f12066d);
            flatBufferBuilder.a(1, this.f12067e);
            flatBufferBuilder.b(2, b);
            flatBufferBuilder.b(3, b2);
            i();
            return flatBufferBuilder.d();
        }

        public final void m14477a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
            super.a(mutableFlatBuffer, i, obj);
            this.f12066d = mutableFlatBuffer.a(i, 0);
            this.f12067e = mutableFlatBuffer.a(i, 1);
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -1076074038)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: find_friends_view_clicked */
    public final class ReactionGeoRectangleFieldsModel extends BaseModel implements GraphQLVisitableModel {
        private double f12074d;
        private double f12075e;
        private double f12076f;
        private double f12077g;

        /* compiled from: find_friends_view_clicked */
        public final class Builder {
            public double f12070a;
            public double f12071b;
            public double f12072c;
            public double f12073d;

            public final ReactionGeoRectangleFieldsModel m14483a() {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.c(4);
                flatBufferBuilder.a(0, this.f12070a, 0.0d);
                flatBufferBuilder.a(1, this.f12071b, 0.0d);
                flatBufferBuilder.a(2, this.f12072c, 0.0d);
                flatBufferBuilder.a(3, this.f12073d, 0.0d);
                flatBufferBuilder.d(flatBufferBuilder.d());
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                return new ReactionGeoRectangleFieldsModel(new MutableFlatBuffer(wrap, null, null, true, null));
            }
        }

        /* compiled from: find_friends_view_clicked */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(ReactionGeoRectangleFieldsModel.class, new Deserializer());
            }

            public Object m14484a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(ReactionGeoRectangleFieldsParser.m14688a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object reactionGeoRectangleFieldsModel = new ReactionGeoRectangleFieldsModel();
                ((BaseModel) reactionGeoRectangleFieldsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (reactionGeoRectangleFieldsModel instanceof Postprocessable) {
                    return ((Postprocessable) reactionGeoRectangleFieldsModel).a();
                }
                return reactionGeoRectangleFieldsModel;
            }
        }

        /* compiled from: find_friends_view_clicked */
        public class Serializer extends JsonSerializer<ReactionGeoRectangleFieldsModel> {
            public final void m14485a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                ReactionGeoRectangleFieldsModel reactionGeoRectangleFieldsModel = (ReactionGeoRectangleFieldsModel) obj;
                if (reactionGeoRectangleFieldsModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(reactionGeoRectangleFieldsModel.m14488a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    reactionGeoRectangleFieldsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                ReactionGeoRectangleFieldsParser.m14689a(reactionGeoRectangleFieldsModel.w_(), reactionGeoRectangleFieldsModel.u_(), jsonGenerator);
            }

            static {
                FbSerializerProvider.a(ReactionGeoRectangleFieldsModel.class, new Serializer());
            }
        }

        public ReactionGeoRectangleFieldsModel() {
            super(4);
        }

        public ReactionGeoRectangleFieldsModel(MutableFlatBuffer mutableFlatBuffer) {
            super(4);
            a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
        }

        public final double m14487a() {
            a(0, 0);
            return this.f12074d;
        }

        public final double m14491b() {
            a(0, 1);
            return this.f12075e;
        }

        public final double m14492c() {
            a(0, 2);
            return this.f12076f;
        }

        public final double m14493d() {
            a(0, 3);
            return this.f12077g;
        }

        public static ReactionGeoRectangleFieldsModel m14486a(ReactionGeoRectangleFieldsModel reactionGeoRectangleFieldsModel) {
            if (reactionGeoRectangleFieldsModel == null) {
                return null;
            }
            if (reactionGeoRectangleFieldsModel instanceof ReactionGeoRectangleFieldsModel) {
                return reactionGeoRectangleFieldsModel;
            }
            Builder builder = new Builder();
            builder.f12070a = reactionGeoRectangleFieldsModel.m14487a();
            builder.f12071b = reactionGeoRectangleFieldsModel.m14491b();
            builder.f12072c = reactionGeoRectangleFieldsModel.m14492c();
            builder.f12073d = reactionGeoRectangleFieldsModel.m14493d();
            return builder.m14483a();
        }

        public final int jK_() {
            return -2036384450;
        }

        public final GraphQLVisitableModel m14489a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            h();
            i();
            return this;
        }

        public final int m14488a(FlatBufferBuilder flatBufferBuilder) {
            h();
            flatBufferBuilder.c(4);
            flatBufferBuilder.a(0, this.f12074d, 0.0d);
            flatBufferBuilder.a(1, this.f12075e, 0.0d);
            flatBufferBuilder.a(2, this.f12076f, 0.0d);
            flatBufferBuilder.a(3, this.f12077g, 0.0d);
            i();
            return flatBufferBuilder.d();
        }

        public final void m14490a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
            super.a(mutableFlatBuffer, i, obj);
            this.f12074d = mutableFlatBuffer.a(i, 0, 0.0d);
            this.f12075e = mutableFlatBuffer.a(i, 1, 0.0d);
            this.f12076f = mutableFlatBuffer.a(i, 2, 0.0d);
            this.f12077g = mutableFlatBuffer.a(i, 3, 0.0d);
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 842551240)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: find_friends_view_clicked */
    public final class ReactionImageFieldsModel extends BaseModel implements GraphQLVisitableModel, ReactionImageFields {
        @Nullable
        private String f12079d;

        /* compiled from: find_friends_view_clicked */
        public final class Builder {
            @Nullable
            public String f12078a;

            public final ReactionImageFieldsModel m14494a() {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                int b = flatBufferBuilder.b(this.f12078a);
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, b);
                flatBufferBuilder.d(flatBufferBuilder.d());
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                return new ReactionImageFieldsModel(new MutableFlatBuffer(wrap, null, null, true, null));
            }
        }

        /* compiled from: find_friends_view_clicked */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(ReactionImageFieldsModel.class, new Deserializer());
            }

            public Object m14495a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(ReactionImageFieldsParser.m14690a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object reactionImageFieldsModel = new ReactionImageFieldsModel();
                ((BaseModel) reactionImageFieldsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (reactionImageFieldsModel instanceof Postprocessable) {
                    return ((Postprocessable) reactionImageFieldsModel).a();
                }
                return reactionImageFieldsModel;
            }
        }

        /* compiled from: find_friends_view_clicked */
        public class Serializer extends JsonSerializer<ReactionImageFieldsModel> {
            public final void m14496a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                ReactionImageFieldsModel reactionImageFieldsModel = (ReactionImageFieldsModel) obj;
                if (reactionImageFieldsModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(reactionImageFieldsModel.m14498a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    reactionImageFieldsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                ReactionImageFieldsParser.m14691a(reactionImageFieldsModel.w_(), reactionImageFieldsModel.u_(), jsonGenerator);
            }

            static {
                FbSerializerProvider.a(ReactionImageFieldsModel.class, new Serializer());
            }
        }

        public ReactionImageFieldsModel() {
            super(1);
        }

        public ReactionImageFieldsModel(MutableFlatBuffer mutableFlatBuffer) {
            super(1);
            a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
        }

        @Nullable
        public final String mo773b() {
            this.f12079d = super.a(this.f12079d, 0);
            return this.f12079d;
        }

        public static ReactionImageFieldsModel m14497a(ReactionImageFields reactionImageFields) {
            if (reactionImageFields == null) {
                return null;
            }
            if (reactionImageFields instanceof ReactionImageFieldsModel) {
                return (ReactionImageFieldsModel) reactionImageFields;
            }
            Builder builder = new Builder();
            builder.f12078a = reactionImageFields.mo773b();
            return builder.m14494a();
        }

        public final int jK_() {
            return 70760763;
        }

        public final GraphQLVisitableModel m14499a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            h();
            i();
            return this;
        }

        public final int m14498a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int b = flatBufferBuilder.b(mo773b());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, b);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -1789295761)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: find_friends_view_clicked */
    public final class ReactionPageFieldsModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel, ReactionPageFields {
        @Nullable
        private CoverPhotoModel f12084d;
        @Nullable
        private String f12085e;
        @Nullable
        private String f12086f;

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 1665232034)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: find_friends_view_clicked */
        public final class CoverPhotoModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private PhotoModel f12083d;

            /* compiled from: find_friends_view_clicked */
            public final class Builder {
                @Nullable
                public PhotoModel f12080a;
            }

            /* compiled from: find_friends_view_clicked */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(CoverPhotoModel.class, new Deserializer());
                }

                public Object m14501a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(CoverPhotoParser.m14696a(jsonParser, flatBufferBuilder));
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

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = -1977992031)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: find_friends_view_clicked */
            public final class PhotoModel extends BaseModel implements GraphQLVisitableModel {
                @Nullable
                private DefaultImageFieldsModel f12082d;

                /* compiled from: find_friends_view_clicked */
                public final class Builder {
                    @Nullable
                    public DefaultImageFieldsModel f12081a;
                }

                /* compiled from: find_friends_view_clicked */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(PhotoModel.class, new Deserializer());
                    }

                    public Object m14502a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(PhotoParser.m14694a(jsonParser, flatBufferBuilder));
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

                /* compiled from: find_friends_view_clicked */
                public class Serializer extends JsonSerializer<PhotoModel> {
                    public final void m14503a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        PhotoModel photoModel = (PhotoModel) obj;
                        if (photoModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(photoModel.m14506a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            photoModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        PhotoParser.m14695a(photoModel.w_(), photoModel.u_(), jsonGenerator, serializerProvider);
                    }

                    static {
                        FbSerializerProvider.a(PhotoModel.class, new Serializer());
                    }
                }

                @Nullable
                public final /* synthetic */ DefaultImageFields m14507a() {
                    return m14505j();
                }

                public PhotoModel() {
                    super(1);
                }

                public PhotoModel(MutableFlatBuffer mutableFlatBuffer) {
                    super(1);
                    a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }

                @Nullable
                private DefaultImageFieldsModel m14505j() {
                    this.f12082d = (DefaultImageFieldsModel) super.a(this.f12082d, 0, DefaultImageFieldsModel.class);
                    return this.f12082d;
                }

                public static PhotoModel m14504a(PhotoModel photoModel) {
                    if (photoModel == null) {
                        return null;
                    }
                    if (photoModel instanceof PhotoModel) {
                        return photoModel;
                    }
                    Builder builder = new Builder();
                    builder.f12081a = DefaultImageFieldsModel.a(photoModel.m14507a());
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    int a = ModelHelper.a(flatBufferBuilder, builder.f12081a);
                    flatBufferBuilder.c(1);
                    flatBufferBuilder.b(0, a);
                    flatBufferBuilder.d(flatBufferBuilder.d());
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    return new PhotoModel(new MutableFlatBuffer(wrap, null, null, true, null));
                }

                public final int jK_() {
                    return 77090322;
                }

                public final GraphQLVisitableModel m14508a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    GraphQLVisitableModel graphQLVisitableModel = null;
                    h();
                    if (m14505j() != null) {
                        DefaultImageFieldsModel defaultImageFieldsModel = (DefaultImageFieldsModel) graphQLModelMutatingVisitor.b(m14505j());
                        if (m14505j() != defaultImageFieldsModel) {
                            graphQLVisitableModel = (PhotoModel) ModelHelper.a(null, this);
                            graphQLVisitableModel.f12082d = defaultImageFieldsModel;
                        }
                    }
                    i();
                    return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                }

                public final int m14506a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int a = ModelHelper.a(flatBufferBuilder, m14505j());
                    flatBufferBuilder.c(1);
                    flatBufferBuilder.b(0, a);
                    i();
                    return flatBufferBuilder.d();
                }
            }

            /* compiled from: find_friends_view_clicked */
            public class Serializer extends JsonSerializer<CoverPhotoModel> {
                public final void m14509a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    CoverPhotoModel coverPhotoModel = (CoverPhotoModel) obj;
                    if (coverPhotoModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(coverPhotoModel.m14512a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        coverPhotoModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    CoverPhotoParser.m14697a(coverPhotoModel.w_(), coverPhotoModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(CoverPhotoModel.class, new Serializer());
                }
            }

            @Nullable
            public final /* synthetic */ PhotoModel m14514a() {
                return m14511j();
            }

            public CoverPhotoModel() {
                super(1);
            }

            public CoverPhotoModel(MutableFlatBuffer mutableFlatBuffer) {
                super(1);
                a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
            }

            @Nullable
            private PhotoModel m14511j() {
                this.f12083d = (PhotoModel) super.a(this.f12083d, 0, PhotoModel.class);
                return this.f12083d;
            }

            public static CoverPhotoModel m14510a(CoverPhotoModel coverPhotoModel) {
                if (coverPhotoModel == null) {
                    return null;
                }
                if (coverPhotoModel instanceof CoverPhotoModel) {
                    return coverPhotoModel;
                }
                Builder builder = new Builder();
                builder.f12080a = PhotoModel.m14504a(coverPhotoModel.m14514a());
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                int a = ModelHelper.a(flatBufferBuilder, builder.f12080a);
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.d(flatBufferBuilder.d());
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                return new CoverPhotoModel(new MutableFlatBuffer(wrap, null, null, true, null));
            }

            public final int jK_() {
                return 497264923;
            }

            public final GraphQLVisitableModel m14513a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m14511j() != null) {
                    PhotoModel photoModel = (PhotoModel) graphQLModelMutatingVisitor.b(m14511j());
                    if (m14511j() != photoModel) {
                        graphQLVisitableModel = (CoverPhotoModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f12083d = photoModel;
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m14512a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m14511j());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, a);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: find_friends_view_clicked */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(ReactionPageFieldsModel.class, new Deserializer());
            }

            public Object m14515a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = ReactionPageFieldsParser.m14698a(jsonParser);
                Object reactionPageFieldsModel = new ReactionPageFieldsModel();
                ((BaseModel) reactionPageFieldsModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (reactionPageFieldsModel instanceof Postprocessable) {
                    return ((Postprocessable) reactionPageFieldsModel).a();
                }
                return reactionPageFieldsModel;
            }
        }

        /* compiled from: find_friends_view_clicked */
        public class Serializer extends JsonSerializer<ReactionPageFieldsModel> {
            public final void m14516a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                ReactionPageFieldsModel reactionPageFieldsModel = (ReactionPageFieldsModel) obj;
                if (reactionPageFieldsModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(reactionPageFieldsModel.m14520a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    reactionPageFieldsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = reactionPageFieldsModel.w_();
                int u_ = reactionPageFieldsModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("cover_photo");
                    CoverPhotoParser.m14697a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                if (mutableFlatBuffer.g(u_, 1) != 0) {
                    jsonGenerator.a("id");
                    jsonGenerator.b(mutableFlatBuffer.c(u_, 1));
                }
                if (mutableFlatBuffer.g(u_, 2) != 0) {
                    jsonGenerator.a("name");
                    jsonGenerator.b(mutableFlatBuffer.c(u_, 2));
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(ReactionPageFieldsModel.class, new Serializer());
            }
        }

        public ReactionPageFieldsModel() {
            super(3);
        }

        public final void m14523a(String str, ConsistencyTuple consistencyTuple) {
            consistencyTuple.a();
        }

        public final void m14524a(String str, Object obj, boolean z) {
        }

        @Nullable
        private CoverPhotoModel m14517j() {
            this.f12084d = (CoverPhotoModel) super.a(this.f12084d, 0, CoverPhotoModel.class);
            return this.f12084d;
        }

        @Nullable
        private String m14518k() {
            this.f12085e = super.a(this.f12085e, 1);
            return this.f12085e;
        }

        @Nullable
        private String m14519l() {
            this.f12086f = super.a(this.f12086f, 2);
            return this.f12086f;
        }

        @Nullable
        public final String m14522a() {
            return m14518k();
        }

        public final int jK_() {
            return 2479791;
        }

        public final GraphQLVisitableModel m14521a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m14517j() != null) {
                CoverPhotoModel coverPhotoModel = (CoverPhotoModel) graphQLModelMutatingVisitor.b(m14517j());
                if (m14517j() != coverPhotoModel) {
                    graphQLVisitableModel = (ReactionPageFieldsModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f12084d = coverPhotoModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m14520a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m14517j());
            int b = flatBufferBuilder.b(m14518k());
            int b2 = flatBufferBuilder.b(m14519l());
            flatBufferBuilder.c(3);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, b);
            flatBufferBuilder.b(2, b2);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -946591930)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: find_friends_view_clicked */
    public final class ReactionPageFieldsWithPlaceTipsInfoModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel, ReactionPageFields, ReactionPlaceTipsPageFields {
        @Nullable
        private DefaultAddressFieldsModel f12098d;
        private boolean f12099e;
        @Nullable
        private ContextItemsConnectionWithPageInfoFragmentModel f12100f;
        @Nullable
        private CoverPhotoModel f12101g;
        private boolean f12102h;
        @Nullable
        private String f12103i;
        @Nullable
        private DefaultLocationFieldsModel f12104j;
        @Nullable
        private MenuInfoModel f12105k;
        @Nullable
        private String f12106l;
        @Nullable
        private OverallStarRatingModel f12107m;
        @Nullable
        private GraphQLSubscribeStatus f12108n;

        /* compiled from: find_friends_view_clicked */
        public final class Builder {
            @Nullable
            public DefaultAddressFieldsModel f12087a;
            public boolean f12088b;
            @Nullable
            public ContextItemsConnectionWithPageInfoFragmentModel f12089c;
            @Nullable
            public CoverPhotoModel f12090d;
            public boolean f12091e;
            @Nullable
            public String f12092f;
            @Nullable
            public DefaultLocationFieldsModel f12093g;
            @Nullable
            public MenuInfoModel f12094h;
            @Nullable
            public String f12095i;
            @Nullable
            public OverallStarRatingModel f12096j;
            @Nullable
            public GraphQLSubscribeStatus f12097k;

            public final ReactionPageFieldsWithPlaceTipsInfoModel m14525a() {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                int a = ModelHelper.a(flatBufferBuilder, this.f12087a);
                int a2 = ModelHelper.a(flatBufferBuilder, this.f12089c);
                int a3 = ModelHelper.a(flatBufferBuilder, this.f12090d);
                int b = flatBufferBuilder.b(this.f12092f);
                int a4 = ModelHelper.a(flatBufferBuilder, this.f12093g);
                int a5 = ModelHelper.a(flatBufferBuilder, this.f12094h);
                int b2 = flatBufferBuilder.b(this.f12095i);
                int a6 = ModelHelper.a(flatBufferBuilder, this.f12096j);
                int a7 = flatBufferBuilder.a(this.f12097k);
                flatBufferBuilder.c(11);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.a(1, this.f12088b);
                flatBufferBuilder.b(2, a2);
                flatBufferBuilder.b(3, a3);
                flatBufferBuilder.a(4, this.f12091e);
                flatBufferBuilder.b(5, b);
                flatBufferBuilder.b(6, a4);
                flatBufferBuilder.b(7, a5);
                flatBufferBuilder.b(8, b2);
                flatBufferBuilder.b(9, a6);
                flatBufferBuilder.b(10, a7);
                flatBufferBuilder.d(flatBufferBuilder.d());
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                return new ReactionPageFieldsWithPlaceTipsInfoModel(new MutableFlatBuffer(wrap, null, null, true, null));
            }
        }

        /* compiled from: find_friends_view_clicked */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(ReactionPageFieldsWithPlaceTipsInfoModel.class, new Deserializer());
            }

            public Object m14526a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(ReactionPageFieldsWithPlaceTipsInfoParser.m14699a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object reactionPageFieldsWithPlaceTipsInfoModel = new ReactionPageFieldsWithPlaceTipsInfoModel();
                ((BaseModel) reactionPageFieldsWithPlaceTipsInfoModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (reactionPageFieldsWithPlaceTipsInfoModel instanceof Postprocessable) {
                    return ((Postprocessable) reactionPageFieldsWithPlaceTipsInfoModel).a();
                }
                return reactionPageFieldsWithPlaceTipsInfoModel;
            }
        }

        /* compiled from: find_friends_view_clicked */
        public class Serializer extends JsonSerializer<ReactionPageFieldsWithPlaceTipsInfoModel> {
            public final void m14527a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                ReactionPageFieldsWithPlaceTipsInfoModel reactionPageFieldsWithPlaceTipsInfoModel = (ReactionPageFieldsWithPlaceTipsInfoModel) obj;
                if (reactionPageFieldsWithPlaceTipsInfoModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(reactionPageFieldsWithPlaceTipsInfoModel.m14536a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    reactionPageFieldsWithPlaceTipsInfoModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                ReactionPageFieldsWithPlaceTipsInfoParser.m14700a(reactionPageFieldsWithPlaceTipsInfoModel.w_(), reactionPageFieldsWithPlaceTipsInfoModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(ReactionPageFieldsWithPlaceTipsInfoModel.class, new Serializer());
            }
        }

        @Nullable
        public final /* synthetic */ DefaultAddressFieldsModel m14542b() {
            return m14530n();
        }

        @Nullable
        public final /* synthetic */ ContextItemsConnectionWithPageInfoFragmentModel m14544d() {
            return m14531o();
        }

        @Nullable
        public final /* synthetic */ DefaultLocationFields eH_() {
            return m14533q();
        }

        @Nullable
        public final /* synthetic */ CoverPhotoModel eI_() {
            return m14532p();
        }

        @Nullable
        public final /* synthetic */ MenuInfoModel m14546j() {
            return m14534r();
        }

        @Nullable
        public final /* synthetic */ OverallStarRatingModel m14548l() {
            return m14535s();
        }

        public ReactionPageFieldsWithPlaceTipsInfoModel() {
            super(11);
        }

        public ReactionPageFieldsWithPlaceTipsInfoModel(MutableFlatBuffer mutableFlatBuffer) {
            super(11);
            a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
        }

        public final void m14540a(String str, ConsistencyTuple consistencyTuple) {
            if ("does_viewer_like".equals(str)) {
                consistencyTuple.a = Boolean.valueOf(m14545g());
                consistencyTuple.b = u_();
                consistencyTuple.c = 4;
                return;
            }
            consistencyTuple.a();
        }

        public final void m14541a(String str, Object obj, boolean z) {
            if ("does_viewer_like".equals(str)) {
                m14529a(((Boolean) obj).booleanValue());
            }
        }

        @Nullable
        private DefaultAddressFieldsModel m14530n() {
            this.f12098d = (DefaultAddressFieldsModel) super.a(this.f12098d, 0, DefaultAddressFieldsModel.class);
            return this.f12098d;
        }

        public final boolean m14543c() {
            a(0, 1);
            return this.f12099e;
        }

        @Nullable
        private ContextItemsConnectionWithPageInfoFragmentModel m14531o() {
            this.f12100f = (ContextItemsConnectionWithPageInfoFragmentModel) super.a(this.f12100f, 2, ContextItemsConnectionWithPageInfoFragmentModel.class);
            return this.f12100f;
        }

        @Nullable
        private CoverPhotoModel m14532p() {
            this.f12101g = (CoverPhotoModel) super.a(this.f12101g, 3, CoverPhotoModel.class);
            return this.f12101g;
        }

        public final boolean m14545g() {
            a(0, 4);
            return this.f12102h;
        }

        private void m14529a(boolean z) {
            this.f12102h = z;
            if (this.b != null && this.b.d) {
                this.b.a(this.c, 4, z);
            }
        }

        @Nullable
        public final String eG_() {
            this.f12103i = super.a(this.f12103i, 5);
            return this.f12103i;
        }

        @Nullable
        private DefaultLocationFieldsModel m14533q() {
            this.f12104j = (DefaultLocationFieldsModel) super.a(this.f12104j, 6, DefaultLocationFieldsModel.class);
            return this.f12104j;
        }

        @Nullable
        private MenuInfoModel m14534r() {
            this.f12105k = (MenuInfoModel) super.a(this.f12105k, 7, MenuInfoModel.class);
            return this.f12105k;
        }

        @Nullable
        public final String m14547k() {
            this.f12106l = super.a(this.f12106l, 8);
            return this.f12106l;
        }

        @Nullable
        private OverallStarRatingModel m14535s() {
            this.f12107m = (OverallStarRatingModel) super.a(this.f12107m, 9, OverallStarRatingModel.class);
            return this.f12107m;
        }

        @Nullable
        public final GraphQLSubscribeStatus m14549m() {
            this.f12108n = (GraphQLSubscribeStatus) super.b(this.f12108n, 10, GraphQLSubscribeStatus.class, GraphQLSubscribeStatus.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
            return this.f12108n;
        }

        public static ReactionPageFieldsWithPlaceTipsInfoModel m14528a(ReactionPageFieldsWithPlaceTipsInfoModel reactionPageFieldsWithPlaceTipsInfoModel) {
            if (reactionPageFieldsWithPlaceTipsInfoModel == null) {
                return null;
            }
            if (reactionPageFieldsWithPlaceTipsInfoModel instanceof ReactionPageFieldsWithPlaceTipsInfoModel) {
                return reactionPageFieldsWithPlaceTipsInfoModel;
            }
            Builder builder = new Builder();
            builder.f12087a = DefaultAddressFieldsModel.a(reactionPageFieldsWithPlaceTipsInfoModel.m14542b());
            builder.f12088b = reactionPageFieldsWithPlaceTipsInfoModel.m14543c();
            builder.f12089c = ContextItemsConnectionWithPageInfoFragmentModel.a(reactionPageFieldsWithPlaceTipsInfoModel.m14544d());
            builder.f12090d = CoverPhotoModel.m14510a(reactionPageFieldsWithPlaceTipsInfoModel.eI_());
            builder.f12091e = reactionPageFieldsWithPlaceTipsInfoModel.m14545g();
            builder.f12092f = reactionPageFieldsWithPlaceTipsInfoModel.eG_();
            builder.f12093g = DefaultLocationFieldsModel.a(reactionPageFieldsWithPlaceTipsInfoModel.eH_());
            builder.f12094h = MenuInfoModel.m14553a(reactionPageFieldsWithPlaceTipsInfoModel.m14546j());
            builder.f12095i = reactionPageFieldsWithPlaceTipsInfoModel.m14547k();
            builder.f12096j = OverallStarRatingModel.m14561a(reactionPageFieldsWithPlaceTipsInfoModel.m14548l());
            builder.f12097k = reactionPageFieldsWithPlaceTipsInfoModel.m14549m();
            return builder.m14525a();
        }

        @Nullable
        public final String m14538a() {
            return eG_();
        }

        public final int jK_() {
            return 2479791;
        }

        public final GraphQLVisitableModel m14537a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m14530n() != null) {
                DefaultAddressFieldsModel defaultAddressFieldsModel = (DefaultAddressFieldsModel) graphQLModelMutatingVisitor.b(m14530n());
                if (m14530n() != defaultAddressFieldsModel) {
                    graphQLVisitableModel = (ReactionPageFieldsWithPlaceTipsInfoModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f12098d = defaultAddressFieldsModel;
                }
            }
            if (m14531o() != null) {
                ContextItemsConnectionWithPageInfoFragmentModel contextItemsConnectionWithPageInfoFragmentModel = (ContextItemsConnectionWithPageInfoFragmentModel) graphQLModelMutatingVisitor.b(m14531o());
                if (m14531o() != contextItemsConnectionWithPageInfoFragmentModel) {
                    graphQLVisitableModel = (ReactionPageFieldsWithPlaceTipsInfoModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f12100f = contextItemsConnectionWithPageInfoFragmentModel;
                }
            }
            if (m14532p() != null) {
                CoverPhotoModel coverPhotoModel = (CoverPhotoModel) graphQLModelMutatingVisitor.b(m14532p());
                if (m14532p() != coverPhotoModel) {
                    graphQLVisitableModel = (ReactionPageFieldsWithPlaceTipsInfoModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f12101g = coverPhotoModel;
                }
            }
            if (m14533q() != null) {
                DefaultLocationFieldsModel defaultLocationFieldsModel = (DefaultLocationFieldsModel) graphQLModelMutatingVisitor.b(m14533q());
                if (m14533q() != defaultLocationFieldsModel) {
                    graphQLVisitableModel = (ReactionPageFieldsWithPlaceTipsInfoModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f12104j = defaultLocationFieldsModel;
                }
            }
            if (m14534r() != null) {
                MenuInfoModel menuInfoModel = (MenuInfoModel) graphQLModelMutatingVisitor.b(m14534r());
                if (m14534r() != menuInfoModel) {
                    graphQLVisitableModel = (ReactionPageFieldsWithPlaceTipsInfoModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f12105k = menuInfoModel;
                }
            }
            if (m14535s() != null) {
                OverallStarRatingModel overallStarRatingModel = (OverallStarRatingModel) graphQLModelMutatingVisitor.b(m14535s());
                if (m14535s() != overallStarRatingModel) {
                    graphQLVisitableModel = (ReactionPageFieldsWithPlaceTipsInfoModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f12107m = overallStarRatingModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m14536a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m14530n());
            int a2 = ModelHelper.a(flatBufferBuilder, m14531o());
            int a3 = ModelHelper.a(flatBufferBuilder, m14532p());
            int b = flatBufferBuilder.b(eG_());
            int a4 = ModelHelper.a(flatBufferBuilder, m14533q());
            int a5 = ModelHelper.a(flatBufferBuilder, m14534r());
            int b2 = flatBufferBuilder.b(m14547k());
            int a6 = ModelHelper.a(flatBufferBuilder, m14535s());
            int a7 = flatBufferBuilder.a(m14549m());
            flatBufferBuilder.c(11);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.a(1, this.f12099e);
            flatBufferBuilder.b(2, a2);
            flatBufferBuilder.b(3, a3);
            flatBufferBuilder.a(4, this.f12102h);
            flatBufferBuilder.b(5, b);
            flatBufferBuilder.b(6, a4);
            flatBufferBuilder.b(7, a5);
            flatBufferBuilder.b(8, b2);
            flatBufferBuilder.b(9, a6);
            flatBufferBuilder.b(10, a7);
            i();
            return flatBufferBuilder.d();
        }

        public final void m14539a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
            super.a(mutableFlatBuffer, i, obj);
            this.f12099e = mutableFlatBuffer.a(i, 1);
            this.f12102h = mutableFlatBuffer.a(i, 4);
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -614598759)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: find_friends_view_clicked */
    public final class ReactionPlaceTipsPageFieldsModel extends BaseModel implements GraphQLVisitableConsistentModel, ReactionPlaceTipsPageFields {
        @Nullable
        private DefaultAddressFieldsModel f12117d;
        private boolean f12118e;
        @Nullable
        private ContextItemsConnectionWithPageInfoFragmentModel f12119f;
        private boolean f12120g;
        @Nullable
        private DefaultLocationFieldsModel f12121h;
        @Nullable
        private MenuInfoModel f12122i;
        @Nullable
        private OverallStarRatingModel f12123j;
        @Nullable
        private GraphQLSubscribeStatus f12124k;

        /* compiled from: find_friends_view_clicked */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(ReactionPlaceTipsPageFieldsModel.class, new Deserializer());
            }

            public Object m14550a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(ReactionPlaceTipsPageFieldsParser.m14705a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object reactionPlaceTipsPageFieldsModel = new ReactionPlaceTipsPageFieldsModel();
                ((BaseModel) reactionPlaceTipsPageFieldsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (reactionPlaceTipsPageFieldsModel instanceof Postprocessable) {
                    return ((Postprocessable) reactionPlaceTipsPageFieldsModel).a();
                }
                return reactionPlaceTipsPageFieldsModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -1406037294)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: find_friends_view_clicked */
        public final class MenuInfoModel extends BaseModel implements GraphQLVisitableModel {
            private boolean f12111d;
            private boolean f12112e;

            /* compiled from: find_friends_view_clicked */
            public final class Builder {
                public boolean f12109a;
                public boolean f12110b;
            }

            /* compiled from: find_friends_view_clicked */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(MenuInfoModel.class, new Deserializer());
                }

                public Object m14551a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(MenuInfoParser.m14701a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object menuInfoModel = new MenuInfoModel();
                    ((BaseModel) menuInfoModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (menuInfoModel instanceof Postprocessable) {
                        return ((Postprocessable) menuInfoModel).a();
                    }
                    return menuInfoModel;
                }
            }

            /* compiled from: find_friends_view_clicked */
            public class Serializer extends JsonSerializer<MenuInfoModel> {
                public final void m14552a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    MenuInfoModel menuInfoModel = (MenuInfoModel) obj;
                    if (menuInfoModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(menuInfoModel.m14554a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        menuInfoModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    MenuInfoParser.m14702a(menuInfoModel.w_(), menuInfoModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(MenuInfoModel.class, new Serializer());
                }
            }

            public MenuInfoModel() {
                super(2);
            }

            public MenuInfoModel(MutableFlatBuffer mutableFlatBuffer) {
                super(2);
                a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
            }

            public final boolean m14557a() {
                a(0, 0);
                return this.f12111d;
            }

            public final boolean m14558b() {
                a(0, 1);
                return this.f12112e;
            }

            public static MenuInfoModel m14553a(MenuInfoModel menuInfoModel) {
                if (menuInfoModel == null) {
                    return null;
                }
                if (menuInfoModel instanceof MenuInfoModel) {
                    return menuInfoModel;
                }
                Builder builder = new Builder();
                builder.f12109a = menuInfoModel.m14557a();
                builder.f12110b = menuInfoModel.m14558b();
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.c(2);
                flatBufferBuilder.a(0, builder.f12109a);
                flatBufferBuilder.a(1, builder.f12110b);
                flatBufferBuilder.d(flatBufferBuilder.d());
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                return new MenuInfoModel(new MutableFlatBuffer(wrap, null, null, true, null));
            }

            public final int jK_() {
                return 2056274556;
            }

            public final GraphQLVisitableModel m14555a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m14554a(FlatBufferBuilder flatBufferBuilder) {
                h();
                flatBufferBuilder.c(2);
                flatBufferBuilder.a(0, this.f12111d);
                flatBufferBuilder.a(1, this.f12112e);
                i();
                return flatBufferBuilder.d();
            }

            public final void m14556a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                super.a(mutableFlatBuffer, i, obj);
                this.f12111d = mutableFlatBuffer.a(i, 0);
                this.f12112e = mutableFlatBuffer.a(i, 1);
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -1026989130)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: find_friends_view_clicked */
        public final class OverallStarRatingModel extends BaseModel implements GraphQLVisitableModel {
            private int f12115d;
            private double f12116e;

            /* compiled from: find_friends_view_clicked */
            public final class Builder {
                public int f12113a;
                public double f12114b;
            }

            /* compiled from: find_friends_view_clicked */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(OverallStarRatingModel.class, new Deserializer());
                }

                public Object m14559a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(ReactionPlaceTipsPageFieldsParser.OverallStarRatingParser.m14703a(jsonParser, flatBufferBuilder));
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

            /* compiled from: find_friends_view_clicked */
            public class Serializer extends JsonSerializer<OverallStarRatingModel> {
                public final void m14560a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    OverallStarRatingModel overallStarRatingModel = (OverallStarRatingModel) obj;
                    if (overallStarRatingModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(overallStarRatingModel.m14563a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        overallStarRatingModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    ReactionPlaceTipsPageFieldsParser.OverallStarRatingParser.m14704a(overallStarRatingModel.w_(), overallStarRatingModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(OverallStarRatingModel.class, new Serializer());
                }
            }

            public OverallStarRatingModel() {
                super(2);
            }

            public OverallStarRatingModel(MutableFlatBuffer mutableFlatBuffer) {
                super(2);
                a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
            }

            public final int m14562a() {
                a(0, 0);
                return this.f12115d;
            }

            public final double m14566b() {
                a(0, 1);
                return this.f12116e;
            }

            public static OverallStarRatingModel m14561a(OverallStarRatingModel overallStarRatingModel) {
                if (overallStarRatingModel == null) {
                    return null;
                }
                if (overallStarRatingModel instanceof OverallStarRatingModel) {
                    return overallStarRatingModel;
                }
                Builder builder = new Builder();
                builder.f12113a = overallStarRatingModel.m14562a();
                builder.f12114b = overallStarRatingModel.m14566b();
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.c(2);
                flatBufferBuilder.a(0, builder.f12113a, 0);
                flatBufferBuilder.a(1, builder.f12114b, 0.0d);
                flatBufferBuilder.d(flatBufferBuilder.d());
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                return new OverallStarRatingModel(new MutableFlatBuffer(wrap, null, null, true, null));
            }

            public final int jK_() {
                return -1854235203;
            }

            public final GraphQLVisitableModel m14564a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m14563a(FlatBufferBuilder flatBufferBuilder) {
                h();
                flatBufferBuilder.c(2);
                flatBufferBuilder.a(0, this.f12115d, 0);
                flatBufferBuilder.a(1, this.f12116e, 0.0d);
                i();
                return flatBufferBuilder.d();
            }

            public final void m14565a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                super.a(mutableFlatBuffer, i, obj);
                this.f12115d = mutableFlatBuffer.a(i, 0, 0);
                this.f12116e = mutableFlatBuffer.a(i, 1, 0.0d);
            }
        }

        /* compiled from: find_friends_view_clicked */
        public class Serializer extends JsonSerializer<ReactionPlaceTipsPageFieldsModel> {
            public final void m14567a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                ReactionPlaceTipsPageFieldsModel reactionPlaceTipsPageFieldsModel = (ReactionPlaceTipsPageFieldsModel) obj;
                if (reactionPlaceTipsPageFieldsModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(reactionPlaceTipsPageFieldsModel.m14576a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    reactionPlaceTipsPageFieldsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = reactionPlaceTipsPageFieldsModel.w_();
                int u_ = reactionPlaceTipsPageFieldsModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("address");
                    DefaultAddressFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
                }
                boolean a = mutableFlatBuffer.a(u_, 1);
                if (a) {
                    jsonGenerator.a("can_viewer_like");
                    jsonGenerator.a(a);
                }
                g = mutableFlatBuffer.g(u_, 2);
                if (g != 0) {
                    jsonGenerator.a("contextItemRows");
                    ContextItemsConnectionWithPageInfoFragmentParser.a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                a = mutableFlatBuffer.a(u_, 3);
                if (a) {
                    jsonGenerator.a("does_viewer_like");
                    jsonGenerator.a(a);
                }
                g = mutableFlatBuffer.g(u_, 4);
                if (g != 0) {
                    jsonGenerator.a("location");
                    DefaultLocationFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
                }
                g = mutableFlatBuffer.g(u_, 5);
                if (g != 0) {
                    jsonGenerator.a("menu_info");
                    MenuInfoParser.m14702a(mutableFlatBuffer, g, jsonGenerator);
                }
                g = mutableFlatBuffer.g(u_, 6);
                if (g != 0) {
                    jsonGenerator.a("overall_star_rating");
                    ReactionPlaceTipsPageFieldsParser.OverallStarRatingParser.m14704a(mutableFlatBuffer, g, jsonGenerator);
                }
                if (mutableFlatBuffer.g(u_, 7) != 0) {
                    jsonGenerator.a("subscribe_status");
                    jsonGenerator.b(mutableFlatBuffer.b(u_, 7));
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(ReactionPlaceTipsPageFieldsModel.class, new Serializer());
            }
        }

        public ReactionPlaceTipsPageFieldsModel() {
            super(8);
        }

        public final void m14579a(String str, ConsistencyTuple consistencyTuple) {
            if ("does_viewer_like".equals(str)) {
                consistencyTuple.a = Boolean.valueOf(m14571k());
                consistencyTuple.b = u_();
                consistencyTuple.c = 3;
                return;
            }
            consistencyTuple.a();
        }

        public final void m14580a(String str, Object obj, boolean z) {
            if ("does_viewer_like".equals(str)) {
                m14569a(((Boolean) obj).booleanValue());
            }
        }

        @Nullable
        private DefaultAddressFieldsModel m14568a() {
            this.f12117d = (DefaultAddressFieldsModel) super.a(this.f12117d, 0, DefaultAddressFieldsModel.class);
            return this.f12117d;
        }

        @Nullable
        private ContextItemsConnectionWithPageInfoFragmentModel m14570j() {
            this.f12119f = (ContextItemsConnectionWithPageInfoFragmentModel) super.a(this.f12119f, 2, ContextItemsConnectionWithPageInfoFragmentModel.class);
            return this.f12119f;
        }

        private boolean m14571k() {
            a(0, 3);
            return this.f12120g;
        }

        private void m14569a(boolean z) {
            this.f12120g = z;
            if (this.b != null && this.b.d) {
                this.b.a(this.c, 3, z);
            }
        }

        @Nullable
        private DefaultLocationFieldsModel m14572l() {
            this.f12121h = (DefaultLocationFieldsModel) super.a(this.f12121h, 4, DefaultLocationFieldsModel.class);
            return this.f12121h;
        }

        @Nullable
        private MenuInfoModel m14573m() {
            this.f12122i = (MenuInfoModel) super.a(this.f12122i, 5, MenuInfoModel.class);
            return this.f12122i;
        }

        @Nullable
        private OverallStarRatingModel m14574n() {
            this.f12123j = (OverallStarRatingModel) super.a(this.f12123j, 6, OverallStarRatingModel.class);
            return this.f12123j;
        }

        @Nullable
        private GraphQLSubscribeStatus m14575o() {
            this.f12124k = (GraphQLSubscribeStatus) super.b(this.f12124k, 7, GraphQLSubscribeStatus.class, GraphQLSubscribeStatus.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
            return this.f12124k;
        }

        public final int jK_() {
            return 2479791;
        }

        public final GraphQLVisitableModel m14577a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m14568a() != null) {
                DefaultAddressFieldsModel defaultAddressFieldsModel = (DefaultAddressFieldsModel) graphQLModelMutatingVisitor.b(m14568a());
                if (m14568a() != defaultAddressFieldsModel) {
                    graphQLVisitableModel = (ReactionPlaceTipsPageFieldsModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f12117d = defaultAddressFieldsModel;
                }
            }
            if (m14570j() != null) {
                ContextItemsConnectionWithPageInfoFragmentModel contextItemsConnectionWithPageInfoFragmentModel = (ContextItemsConnectionWithPageInfoFragmentModel) graphQLModelMutatingVisitor.b(m14570j());
                if (m14570j() != contextItemsConnectionWithPageInfoFragmentModel) {
                    graphQLVisitableModel = (ReactionPlaceTipsPageFieldsModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f12119f = contextItemsConnectionWithPageInfoFragmentModel;
                }
            }
            if (m14572l() != null) {
                DefaultLocationFieldsModel defaultLocationFieldsModel = (DefaultLocationFieldsModel) graphQLModelMutatingVisitor.b(m14572l());
                if (m14572l() != defaultLocationFieldsModel) {
                    graphQLVisitableModel = (ReactionPlaceTipsPageFieldsModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f12121h = defaultLocationFieldsModel;
                }
            }
            if (m14573m() != null) {
                MenuInfoModel menuInfoModel = (MenuInfoModel) graphQLModelMutatingVisitor.b(m14573m());
                if (m14573m() != menuInfoModel) {
                    graphQLVisitableModel = (ReactionPlaceTipsPageFieldsModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f12122i = menuInfoModel;
                }
            }
            if (m14574n() != null) {
                OverallStarRatingModel overallStarRatingModel = (OverallStarRatingModel) graphQLModelMutatingVisitor.b(m14574n());
                if (m14574n() != overallStarRatingModel) {
                    graphQLVisitableModel = (ReactionPlaceTipsPageFieldsModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f12123j = overallStarRatingModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m14576a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m14568a());
            int a2 = ModelHelper.a(flatBufferBuilder, m14570j());
            int a3 = ModelHelper.a(flatBufferBuilder, m14572l());
            int a4 = ModelHelper.a(flatBufferBuilder, m14573m());
            int a5 = ModelHelper.a(flatBufferBuilder, m14574n());
            int a6 = flatBufferBuilder.a(m14575o());
            flatBufferBuilder.c(8);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.a(1, this.f12118e);
            flatBufferBuilder.b(2, a2);
            flatBufferBuilder.a(3, this.f12120g);
            flatBufferBuilder.b(4, a3);
            flatBufferBuilder.b(5, a4);
            flatBufferBuilder.b(6, a5);
            flatBufferBuilder.b(7, a6);
            i();
            return flatBufferBuilder.d();
        }

        public final void m14578a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
            super.a(mutableFlatBuffer, i, obj);
            this.f12118e = mutableFlatBuffer.a(i, 1);
            this.f12120g = mutableFlatBuffer.a(i, 3);
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -987927343)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: find_friends_view_clicked */
    public final class ReactionProfileFieldsModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel, ReactionProfileFields {
        @Nullable
        private GraphQLObjectType f12142d;
        private boolean f12143e;
        private boolean f12144f;
        @Nullable
        private List<String> f12145g;
        @Nullable
        private CoverPhotoModel f12146h;
        private boolean f12147i;
        @Nullable
        private String f12148j;
        @Nullable
        private String f12149k;
        @Nullable
        private ReactionImageFieldsModel f12150l;
        @Nullable
        private String f12151m;
        @Nullable
        private GraphQLSavedState f12152n;

        /* compiled from: find_friends_view_clicked */
        public final class Builder {
            @Nullable
            public GraphQLObjectType f12125a;
            public boolean f12126b;
            public boolean f12127c;
            @Nullable
            public ImmutableList<String> f12128d;
            @Nullable
            public CoverPhotoModel f12129e;
            public boolean f12130f;
            @Nullable
            public String f12131g;
            @Nullable
            public String f12132h;
            @Nullable
            public ReactionImageFieldsModel f12133i;
            @Nullable
            public String f12134j;
            @Nullable
            public GraphQLSavedState f12135k;

            public final ReactionProfileFieldsModel m14581a() {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                int a = ModelHelper.a(flatBufferBuilder, this.f12125a);
                int c = flatBufferBuilder.c(this.f12128d);
                int a2 = ModelHelper.a(flatBufferBuilder, this.f12129e);
                int b = flatBufferBuilder.b(this.f12131g);
                int b2 = flatBufferBuilder.b(this.f12132h);
                int a3 = ModelHelper.a(flatBufferBuilder, this.f12133i);
                int b3 = flatBufferBuilder.b(this.f12134j);
                int a4 = flatBufferBuilder.a(this.f12135k);
                flatBufferBuilder.c(11);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.a(1, this.f12126b);
                flatBufferBuilder.a(2, this.f12127c);
                flatBufferBuilder.b(3, c);
                flatBufferBuilder.b(4, a2);
                flatBufferBuilder.a(5, this.f12130f);
                flatBufferBuilder.b(6, b);
                flatBufferBuilder.b(7, b2);
                flatBufferBuilder.b(8, a3);
                flatBufferBuilder.b(9, b3);
                flatBufferBuilder.b(10, a4);
                flatBufferBuilder.d(flatBufferBuilder.d());
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                return new ReactionProfileFieldsModel(new MutableFlatBuffer(wrap, null, null, true, null));
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 1904533872)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: find_friends_view_clicked */
        public final class CoverPhotoModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private PhotoModel f12141d;

            /* compiled from: find_friends_view_clicked */
            public final class Builder {
                @Nullable
                public PhotoModel f12136a;
            }

            /* compiled from: find_friends_view_clicked */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(CoverPhotoModel.class, new Deserializer());
                }

                public Object m14582a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(ReactionProfileFieldsParser.CoverPhotoParser.m14710a(jsonParser, flatBufferBuilder));
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

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = 999451466)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: find_friends_view_clicked */
            public final class PhotoModel extends BaseModel implements GraphQLVisitableModel {
                @Nullable
                private ImageModel f12140d;

                /* compiled from: find_friends_view_clicked */
                public final class Builder {
                    @Nullable
                    public ImageModel f12137a;
                }

                /* compiled from: find_friends_view_clicked */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(PhotoModel.class, new Deserializer());
                    }

                    public Object m14583a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(ReactionProfileFieldsParser.CoverPhotoParser.PhotoParser.m14708a(jsonParser, flatBufferBuilder));
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
                @ModelWithFlatBufferFormatHash(a = 842551240)
                @JsonSerialize(using = Serializer.class)
                @FragmentModelWithoutBridge
                /* compiled from: find_friends_view_clicked */
                public final class ImageModel extends BaseModel implements GraphQLVisitableModel {
                    @Nullable
                    private String f12139d;

                    /* compiled from: find_friends_view_clicked */
                    public final class Builder {
                        @Nullable
                        public String f12138a;
                    }

                    /* compiled from: find_friends_view_clicked */
                    public class Deserializer extends FbJsonDeserializer {
                        static {
                            GlobalAutoGenDeserializerCache.a(ImageModel.class, new Deserializer());
                        }

                        public Object m14584a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(ReactionProfileFieldsParser.CoverPhotoParser.PhotoParser.ImageParser.m14706a(jsonParser, flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            mutableFlatBuffer.a(4, Boolean.valueOf(true));
                            MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                            Object imageModel = new ImageModel();
                            ((BaseModel) imageModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                            if (imageModel instanceof Postprocessable) {
                                return ((Postprocessable) imageModel).a();
                            }
                            return imageModel;
                        }
                    }

                    /* compiled from: find_friends_view_clicked */
                    public class Serializer extends JsonSerializer<ImageModel> {
                        public final void m14585a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                            ImageModel imageModel = (ImageModel) obj;
                            if (imageModel.w_() == null) {
                                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                flatBufferBuilder.d(imageModel.m14587a(flatBufferBuilder));
                                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                wrap.position(0);
                                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                imageModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                            }
                            ReactionProfileFieldsParser.CoverPhotoParser.PhotoParser.ImageParser.m14707a(imageModel.w_(), imageModel.u_(), jsonGenerator);
                        }

                        static {
                            FbSerializerProvider.a(ImageModel.class, new Serializer());
                        }
                    }

                    public ImageModel() {
                        super(1);
                    }

                    public ImageModel(MutableFlatBuffer mutableFlatBuffer) {
                        super(1);
                        a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }

                    @Nullable
                    public final String m14589a() {
                        this.f12139d = super.a(this.f12139d, 0);
                        return this.f12139d;
                    }

                    public static ImageModel m14586a(ImageModel imageModel) {
                        if (imageModel == null) {
                            return null;
                        }
                        if (imageModel instanceof ImageModel) {
                            return imageModel;
                        }
                        Builder builder = new Builder();
                        builder.f12138a = imageModel.m14589a();
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        int b = flatBufferBuilder.b(builder.f12138a);
                        flatBufferBuilder.c(1);
                        flatBufferBuilder.b(0, b);
                        flatBufferBuilder.d(flatBufferBuilder.d());
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        return new ImageModel(new MutableFlatBuffer(wrap, null, null, true, null));
                    }

                    public final int jK_() {
                        return 70760763;
                    }

                    public final GraphQLVisitableModel m14588a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                        h();
                        i();
                        return this;
                    }

                    public final int m14587a(FlatBufferBuilder flatBufferBuilder) {
                        h();
                        int b = flatBufferBuilder.b(m14589a());
                        flatBufferBuilder.c(1);
                        flatBufferBuilder.b(0, b);
                        i();
                        return flatBufferBuilder.d();
                    }
                }

                /* compiled from: find_friends_view_clicked */
                public class Serializer extends JsonSerializer<PhotoModel> {
                    public final void m14590a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        PhotoModel photoModel = (PhotoModel) obj;
                        if (photoModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(photoModel.m14593a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            photoModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        ReactionProfileFieldsParser.CoverPhotoParser.PhotoParser.m14709a(photoModel.w_(), photoModel.u_(), jsonGenerator, serializerProvider);
                    }

                    static {
                        FbSerializerProvider.a(PhotoModel.class, new Serializer());
                    }
                }

                @Nullable
                public final /* synthetic */ ImageModel m14595a() {
                    return m14592j();
                }

                public PhotoModel() {
                    super(1);
                }

                public PhotoModel(MutableFlatBuffer mutableFlatBuffer) {
                    super(1);
                    a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }

                @Nullable
                private ImageModel m14592j() {
                    this.f12140d = (ImageModel) super.a(this.f12140d, 0, ImageModel.class);
                    return this.f12140d;
                }

                public static PhotoModel m14591a(PhotoModel photoModel) {
                    if (photoModel == null) {
                        return null;
                    }
                    if (photoModel instanceof PhotoModel) {
                        return photoModel;
                    }
                    Builder builder = new Builder();
                    builder.f12137a = ImageModel.m14586a(photoModel.m14595a());
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    int a = ModelHelper.a(flatBufferBuilder, builder.f12137a);
                    flatBufferBuilder.c(1);
                    flatBufferBuilder.b(0, a);
                    flatBufferBuilder.d(flatBufferBuilder.d());
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    return new PhotoModel(new MutableFlatBuffer(wrap, null, null, true, null));
                }

                public final int jK_() {
                    return 77090322;
                }

                public final GraphQLVisitableModel m14594a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    GraphQLVisitableModel graphQLVisitableModel = null;
                    h();
                    if (m14592j() != null) {
                        ImageModel imageModel = (ImageModel) graphQLModelMutatingVisitor.b(m14592j());
                        if (m14592j() != imageModel) {
                            graphQLVisitableModel = (PhotoModel) ModelHelper.a(null, this);
                            graphQLVisitableModel.f12140d = imageModel;
                        }
                    }
                    i();
                    return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                }

                public final int m14593a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int a = ModelHelper.a(flatBufferBuilder, m14592j());
                    flatBufferBuilder.c(1);
                    flatBufferBuilder.b(0, a);
                    i();
                    return flatBufferBuilder.d();
                }
            }

            /* compiled from: find_friends_view_clicked */
            public class Serializer extends JsonSerializer<CoverPhotoModel> {
                public final void m14596a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    CoverPhotoModel coverPhotoModel = (CoverPhotoModel) obj;
                    if (coverPhotoModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(coverPhotoModel.m14599a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        coverPhotoModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    ReactionProfileFieldsParser.CoverPhotoParser.m14711a(coverPhotoModel.w_(), coverPhotoModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(CoverPhotoModel.class, new Serializer());
                }
            }

            @Nullable
            public final /* synthetic */ PhotoModel m14601a() {
                return m14598j();
            }

            public CoverPhotoModel() {
                super(1);
            }

            public CoverPhotoModel(MutableFlatBuffer mutableFlatBuffer) {
                super(1);
                a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
            }

            @Nullable
            private PhotoModel m14598j() {
                this.f12141d = (PhotoModel) super.a(this.f12141d, 0, PhotoModel.class);
                return this.f12141d;
            }

            public static CoverPhotoModel m14597a(CoverPhotoModel coverPhotoModel) {
                if (coverPhotoModel == null) {
                    return null;
                }
                if (coverPhotoModel instanceof CoverPhotoModel) {
                    return coverPhotoModel;
                }
                Builder builder = new Builder();
                builder.f12136a = PhotoModel.m14591a(coverPhotoModel.m14601a());
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                int a = ModelHelper.a(flatBufferBuilder, builder.f12136a);
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.d(flatBufferBuilder.d());
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                return new CoverPhotoModel(new MutableFlatBuffer(wrap, null, null, true, null));
            }

            public final int jK_() {
                return 497264923;
            }

            public final GraphQLVisitableModel m14600a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m14598j() != null) {
                    PhotoModel photoModel = (PhotoModel) graphQLModelMutatingVisitor.b(m14598j());
                    if (m14598j() != photoModel) {
                        graphQLVisitableModel = (CoverPhotoModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f12141d = photoModel;
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m14599a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m14598j());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, a);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: find_friends_view_clicked */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(ReactionProfileFieldsModel.class, new Deserializer());
            }

            public Object m14602a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(ReactionProfileFieldsParser.m14712a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object reactionProfileFieldsModel = new ReactionProfileFieldsModel();
                ((BaseModel) reactionProfileFieldsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (reactionProfileFieldsModel instanceof Postprocessable) {
                    return ((Postprocessable) reactionProfileFieldsModel).a();
                }
                return reactionProfileFieldsModel;
            }
        }

        /* compiled from: find_friends_view_clicked */
        public class Serializer extends JsonSerializer<ReactionProfileFieldsModel> {
            public final void m14603a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                ReactionProfileFieldsModel reactionProfileFieldsModel = (ReactionProfileFieldsModel) obj;
                if (reactionProfileFieldsModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(reactionProfileFieldsModel.m14608a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    reactionProfileFieldsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                ReactionProfileFieldsParser.m14713a(reactionProfileFieldsModel.w_(), reactionProfileFieldsModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(ReactionProfileFieldsModel.class, new Serializer());
            }
        }

        @Nullable
        public final /* synthetic */ CoverPhotoModel mo780g() {
            return m14606n();
        }

        @Nullable
        public final /* synthetic */ ReactionImageFields mo782k() {
            return m14607o();
        }

        public ReactionProfileFieldsModel() {
            super(11);
        }

        public ReactionProfileFieldsModel(MutableFlatBuffer mutableFlatBuffer) {
            super(11);
            a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
        }

        public final void m14612a(String str, ConsistencyTuple consistencyTuple) {
            if ("does_viewer_like".equals(str)) {
                consistencyTuple.a = Boolean.valueOf(eK_());
                consistencyTuple.b = u_();
                consistencyTuple.c = 5;
                return;
            }
            consistencyTuple.a();
        }

        public final void m14613a(String str, Object obj, boolean z) {
            if ("does_viewer_like".equals(str)) {
                m14605a(((Boolean) obj).booleanValue());
            }
        }

        @Nullable
        public final GraphQLObjectType mo774b() {
            if (this.b != null && this.f12142d == null) {
                this.f12142d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
            }
            return this.f12142d;
        }

        public final boolean mo775c() {
            a(0, 1);
            return this.f12143e;
        }

        public final boolean mo776d() {
            a(0, 2);
            return this.f12144f;
        }

        @Nonnull
        public final ImmutableList<String> eJ_() {
            this.f12145g = super.a(this.f12145g, 3);
            return (ImmutableList) this.f12145g;
        }

        @Nullable
        private CoverPhotoModel m14606n() {
            this.f12146h = (CoverPhotoModel) super.a(this.f12146h, 4, CoverPhotoModel.class);
            return this.f12146h;
        }

        public final boolean eK_() {
            a(0, 5);
            return this.f12147i;
        }

        private void m14605a(boolean z) {
            this.f12147i = z;
            if (this.b != null && this.b.d) {
                this.b.a(this.c, 5, z);
            }
        }

        @Nullable
        public final String eL_() {
            this.f12148j = super.a(this.f12148j, 6);
            return this.f12148j;
        }

        @Nullable
        public final String mo781j() {
            this.f12149k = super.a(this.f12149k, 7);
            return this.f12149k;
        }

        @Nullable
        private ReactionImageFieldsModel m14607o() {
            this.f12150l = (ReactionImageFieldsModel) super.a(this.f12150l, 8, ReactionImageFieldsModel.class);
            return this.f12150l;
        }

        @Nullable
        public final String mo783l() {
            this.f12151m = super.a(this.f12151m, 9);
            return this.f12151m;
        }

        @Nullable
        public final GraphQLSavedState mo784m() {
            this.f12152n = (GraphQLSavedState) super.b(this.f12152n, 10, GraphQLSavedState.class, GraphQLSavedState.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
            return this.f12152n;
        }

        public static ReactionProfileFieldsModel m14604a(ReactionProfileFields reactionProfileFields) {
            if (reactionProfileFields == null) {
                return null;
            }
            if (reactionProfileFields instanceof ReactionProfileFieldsModel) {
                return (ReactionProfileFieldsModel) reactionProfileFields;
            }
            Builder builder = new Builder();
            builder.f12125a = reactionProfileFields.mo774b();
            builder.f12126b = reactionProfileFields.mo775c();
            builder.f12127c = reactionProfileFields.mo776d();
            com.google.common.collect.ImmutableList.Builder builder2 = ImmutableList.builder();
            for (int i = 0; i < reactionProfileFields.eJ_().size(); i++) {
                builder2.c(reactionProfileFields.eJ_().get(i));
            }
            builder.f12128d = builder2.b();
            builder.f12129e = CoverPhotoModel.m14597a(reactionProfileFields.mo780g());
            builder.f12130f = reactionProfileFields.eK_();
            builder.f12131g = reactionProfileFields.eL_();
            builder.f12132h = reactionProfileFields.mo781j();
            builder.f12133i = ReactionImageFieldsModel.m14497a(reactionProfileFields.mo782k());
            builder.f12134j = reactionProfileFields.mo783l();
            builder.f12135k = reactionProfileFields.mo784m();
            return builder.m14581a();
        }

        @Nullable
        public final String m14610a() {
            return eL_();
        }

        public final int jK_() {
            return 1355227529;
        }

        public final GraphQLVisitableModel m14609a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m14606n() != null) {
                CoverPhotoModel coverPhotoModel = (CoverPhotoModel) graphQLModelMutatingVisitor.b(m14606n());
                if (m14606n() != coverPhotoModel) {
                    graphQLVisitableModel = (ReactionProfileFieldsModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f12146h = coverPhotoModel;
                }
            }
            if (m14607o() != null) {
                ReactionImageFieldsModel reactionImageFieldsModel = (ReactionImageFieldsModel) graphQLModelMutatingVisitor.b(m14607o());
                if (m14607o() != reactionImageFieldsModel) {
                    graphQLVisitableModel = (ReactionProfileFieldsModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f12150l = reactionImageFieldsModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m14608a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, mo774b());
            int c = flatBufferBuilder.c(eJ_());
            int a2 = ModelHelper.a(flatBufferBuilder, m14606n());
            int b = flatBufferBuilder.b(eL_());
            int b2 = flatBufferBuilder.b(mo781j());
            int a3 = ModelHelper.a(flatBufferBuilder, m14607o());
            int b3 = flatBufferBuilder.b(mo783l());
            int a4 = flatBufferBuilder.a(mo784m());
            flatBufferBuilder.c(11);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.a(1, this.f12143e);
            flatBufferBuilder.a(2, this.f12144f);
            flatBufferBuilder.b(3, c);
            flatBufferBuilder.b(4, a2);
            flatBufferBuilder.a(5, this.f12147i);
            flatBufferBuilder.b(6, b);
            flatBufferBuilder.b(7, b2);
            flatBufferBuilder.b(8, a3);
            flatBufferBuilder.b(9, b3);
            flatBufferBuilder.b(10, a4);
            i();
            return flatBufferBuilder.d();
        }

        public final void m14611a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
            super.a(mutableFlatBuffer, i, obj);
            this.f12143e = mutableFlatBuffer.a(i, 1);
            this.f12144f = mutableFlatBuffer.a(i, 2);
            this.f12147i = mutableFlatBuffer.a(i, 5);
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -1387026005)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: find_friends_view_clicked */
    public final class ReactionStoryAttachmentStoryFragmentModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
        @Nullable
        private List<ActorsModel> f12167d;
        @Nullable
        private String f12168e;
        private long f12169f;
        @Nullable
        private FeedbackModel f12170g;
        @Nullable
        private String f12171h;
        @Nullable
        private DefaultTextWithEntitiesFieldsModel f12172i;

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 1683844411)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: find_friends_view_clicked */
        public final class ActorsModel extends BaseModel implements GraphQLVisitableConsistentModel {
            @Nullable
            private GraphQLObjectType f12156d;
            @Nullable
            private String f12157e;
            @Nullable
            private ReactionImageFieldsModel f12158f;

            /* compiled from: find_friends_view_clicked */
            public final class Builder {
                @Nullable
                public GraphQLObjectType f12153a;
                @Nullable
                public String f12154b;
                @Nullable
                public ReactionImageFieldsModel f12155c;
            }

            /* compiled from: find_friends_view_clicked */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(ActorsModel.class, new Deserializer());
                }

                public Object m14622a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(ActorsParser.m14715b(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object actorsModel = new ActorsModel();
                    ((BaseModel) actorsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (actorsModel instanceof Postprocessable) {
                        return ((Postprocessable) actorsModel).a();
                    }
                    return actorsModel;
                }
            }

            /* compiled from: find_friends_view_clicked */
            public class Serializer extends JsonSerializer<ActorsModel> {
                public final void m14623a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    ActorsModel actorsModel = (ActorsModel) obj;
                    if (actorsModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(actorsModel.m14626a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        actorsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    ActorsParser.m14716b(actorsModel.w_(), actorsModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(ActorsModel.class, new Serializer());
                }
            }

            @Nullable
            public final /* synthetic */ ReactionImageFields m14632c() {
                return m14625j();
            }

            public ActorsModel() {
                super(3);
            }

            public ActorsModel(MutableFlatBuffer mutableFlatBuffer) {
                super(3);
                a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
            }

            public final void m14629a(String str, ConsistencyTuple consistencyTuple) {
                consistencyTuple.a();
            }

            public final void m14630a(String str, Object obj, boolean z) {
            }

            @Nullable
            public final GraphQLObjectType m14627a() {
                if (this.b != null && this.f12156d == null) {
                    this.f12156d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
                }
                return this.f12156d;
            }

            @Nullable
            public final String m14631b() {
                this.f12157e = super.a(this.f12157e, 1);
                return this.f12157e;
            }

            @Nullable
            private ReactionImageFieldsModel m14625j() {
                this.f12158f = (ReactionImageFieldsModel) super.a(this.f12158f, 2, ReactionImageFieldsModel.class);
                return this.f12158f;
            }

            public static ActorsModel m14624a(ActorsModel actorsModel) {
                if (actorsModel == null) {
                    return null;
                }
                if (actorsModel instanceof ActorsModel) {
                    return actorsModel;
                }
                Builder builder = new Builder();
                builder.f12153a = actorsModel.m14627a();
                builder.f12154b = actorsModel.m14631b();
                builder.f12155c = ReactionImageFieldsModel.m14497a(actorsModel.m14632c());
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                int a = ModelHelper.a(flatBufferBuilder, builder.f12153a);
                int b = flatBufferBuilder.b(builder.f12154b);
                int a2 = ModelHelper.a(flatBufferBuilder, builder.f12155c);
                flatBufferBuilder.c(3);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.b(1, b);
                flatBufferBuilder.b(2, a2);
                flatBufferBuilder.d(flatBufferBuilder.d());
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                return new ActorsModel(new MutableFlatBuffer(wrap, null, null, true, null));
            }

            public final int jK_() {
                return 63093205;
            }

            public final GraphQLVisitableModel m14628a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m14625j() != null) {
                    ReactionImageFieldsModel reactionImageFieldsModel = (ReactionImageFieldsModel) graphQLModelMutatingVisitor.b(m14625j());
                    if (m14625j() != reactionImageFieldsModel) {
                        graphQLVisitableModel = (ActorsModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f12158f = reactionImageFieldsModel;
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m14626a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m14627a());
                int b = flatBufferBuilder.b(m14631b());
                int a2 = ModelHelper.a(flatBufferBuilder, m14625j());
                flatBufferBuilder.c(3);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.b(1, b);
                flatBufferBuilder.b(2, a2);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: find_friends_view_clicked */
        public final class Builder {
            @Nullable
            public ImmutableList<ActorsModel> f12159a;
            @Nullable
            public String f12160b;
            public long f12161c;
            @Nullable
            public FeedbackModel f12162d;
            @Nullable
            public String f12163e;
            @Nullable
            public DefaultTextWithEntitiesFieldsModel f12164f;

            public final ReactionStoryAttachmentStoryFragmentModel m14633a() {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                int a = ModelHelper.a(flatBufferBuilder, this.f12159a);
                int b = flatBufferBuilder.b(this.f12160b);
                int a2 = ModelHelper.a(flatBufferBuilder, this.f12162d);
                int b2 = flatBufferBuilder.b(this.f12163e);
                int a3 = ModelHelper.a(flatBufferBuilder, this.f12164f);
                flatBufferBuilder.c(6);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.b(1, b);
                flatBufferBuilder.a(2, this.f12161c, 0);
                flatBufferBuilder.b(3, a2);
                flatBufferBuilder.b(4, b2);
                flatBufferBuilder.b(5, a3);
                flatBufferBuilder.d(flatBufferBuilder.d());
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                return new ReactionStoryAttachmentStoryFragmentModel(new MutableFlatBuffer(wrap, null, null, true, null));
            }
        }

        /* compiled from: find_friends_view_clicked */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(ReactionStoryAttachmentStoryFragmentModel.class, new Deserializer());
            }

            public Object m14634a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(ReactionStoryAttachmentStoryFragmentParser.m14719a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object reactionStoryAttachmentStoryFragmentModel = new ReactionStoryAttachmentStoryFragmentModel();
                ((BaseModel) reactionStoryAttachmentStoryFragmentModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (reactionStoryAttachmentStoryFragmentModel instanceof Postprocessable) {
                    return ((Postprocessable) reactionStoryAttachmentStoryFragmentModel).a();
                }
                return reactionStoryAttachmentStoryFragmentModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 989329089)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: find_friends_view_clicked */
        public final class FeedbackModel extends BaseModel implements GraphQLVisitableConsistentModel {
            @Nullable
            private String f12166d;

            /* compiled from: find_friends_view_clicked */
            public final class Builder {
                @Nullable
                public String f12165a;
            }

            /* compiled from: find_friends_view_clicked */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(FeedbackModel.class, new Deserializer());
                }

                public Object m14635a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(FeedbackParser.m14717a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object feedbackModel = new FeedbackModel();
                    ((BaseModel) feedbackModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (feedbackModel instanceof Postprocessable) {
                        return ((Postprocessable) feedbackModel).a();
                    }
                    return feedbackModel;
                }
            }

            /* compiled from: find_friends_view_clicked */
            public class Serializer extends JsonSerializer<FeedbackModel> {
                public final void m14636a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    FeedbackModel feedbackModel = (FeedbackModel) obj;
                    if (feedbackModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(feedbackModel.m14638a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        feedbackModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    FeedbackParser.m14718a(feedbackModel.w_(), feedbackModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(FeedbackModel.class, new Serializer());
                }
            }

            public FeedbackModel() {
                super(1);
            }

            public FeedbackModel(MutableFlatBuffer mutableFlatBuffer) {
                super(1);
                a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
            }

            public final void m14641a(String str, ConsistencyTuple consistencyTuple) {
                consistencyTuple.a();
            }

            public final void m14642a(String str, Object obj, boolean z) {
            }

            @Nullable
            public final String m14640a() {
                this.f12166d = super.a(this.f12166d, 0);
                return this.f12166d;
            }

            public static FeedbackModel m14637a(FeedbackModel feedbackModel) {
                if (feedbackModel == null) {
                    return null;
                }
                if (feedbackModel instanceof FeedbackModel) {
                    return feedbackModel;
                }
                Builder builder = new Builder();
                builder.f12165a = feedbackModel.m14640a();
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                int b = flatBufferBuilder.b(builder.f12165a);
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, b);
                flatBufferBuilder.d(flatBufferBuilder.d());
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                return new FeedbackModel(new MutableFlatBuffer(wrap, null, null, true, null));
            }

            public final int jK_() {
                return -126857307;
            }

            public final GraphQLVisitableModel m14639a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m14638a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m14640a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, b);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: find_friends_view_clicked */
        public class Serializer extends JsonSerializer<ReactionStoryAttachmentStoryFragmentModel> {
            public final void m14643a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                ReactionStoryAttachmentStoryFragmentModel reactionStoryAttachmentStoryFragmentModel = (ReactionStoryAttachmentStoryFragmentModel) obj;
                if (reactionStoryAttachmentStoryFragmentModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(reactionStoryAttachmentStoryFragmentModel.m14647a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    reactionStoryAttachmentStoryFragmentModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                ReactionStoryAttachmentStoryFragmentParser.m14720a(reactionStoryAttachmentStoryFragmentModel.w_(), reactionStoryAttachmentStoryFragmentModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(ReactionStoryAttachmentStoryFragmentModel.class, new Serializer());
            }
        }

        @Nullable
        public final /* synthetic */ DefaultTextWithEntitiesFields eM_() {
            return m14646k();
        }

        @Nullable
        public final /* synthetic */ FeedbackModel eN_() {
            return m14645j();
        }

        public ReactionStoryAttachmentStoryFragmentModel() {
            super(6);
        }

        public ReactionStoryAttachmentStoryFragmentModel(MutableFlatBuffer mutableFlatBuffer) {
            super(6);
            a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
        }

        public final void m14651a(String str, ConsistencyTuple consistencyTuple) {
            consistencyTuple.a();
        }

        public final void m14652a(String str, Object obj, boolean z) {
        }

        @Nonnull
        public final ImmutableList<ActorsModel> m14653b() {
            this.f12167d = super.a(this.f12167d, 0, ActorsModel.class);
            return (ImmutableList) this.f12167d;
        }

        @Nullable
        public final String m14654c() {
            this.f12168e = super.a(this.f12168e, 1);
            return this.f12168e;
        }

        public final long m14655d() {
            a(0, 2);
            return this.f12169f;
        }

        @Nullable
        private FeedbackModel m14645j() {
            this.f12170g = (FeedbackModel) super.a(this.f12170g, 3, FeedbackModel.class);
            return this.f12170g;
        }

        @Nullable
        public final String m14656g() {
            this.f12171h = super.a(this.f12171h, 4);
            return this.f12171h;
        }

        @Nullable
        private DefaultTextWithEntitiesFieldsModel m14646k() {
            this.f12172i = (DefaultTextWithEntitiesFieldsModel) super.a(this.f12172i, 5, DefaultTextWithEntitiesFieldsModel.class);
            return this.f12172i;
        }

        public static ReactionStoryAttachmentStoryFragmentModel m14644a(ReactionStoryAttachmentStoryFragmentModel reactionStoryAttachmentStoryFragmentModel) {
            if (reactionStoryAttachmentStoryFragmentModel == null) {
                return null;
            }
            if (reactionStoryAttachmentStoryFragmentModel instanceof ReactionStoryAttachmentStoryFragmentModel) {
                return reactionStoryAttachmentStoryFragmentModel;
            }
            Builder builder = new Builder();
            com.google.common.collect.ImmutableList.Builder builder2 = ImmutableList.builder();
            for (int i = 0; i < reactionStoryAttachmentStoryFragmentModel.m14653b().size(); i++) {
                builder2.c(ActorsModel.m14624a((ActorsModel) reactionStoryAttachmentStoryFragmentModel.m14653b().get(i)));
            }
            builder.f12159a = builder2.b();
            builder.f12160b = reactionStoryAttachmentStoryFragmentModel.m14654c();
            builder.f12161c = reactionStoryAttachmentStoryFragmentModel.m14655d();
            builder.f12162d = FeedbackModel.m14637a(reactionStoryAttachmentStoryFragmentModel.eN_());
            builder.f12163e = reactionStoryAttachmentStoryFragmentModel.m14656g();
            builder.f12164f = DefaultTextWithEntitiesFieldsModel.a(reactionStoryAttachmentStoryFragmentModel.eM_());
            return builder.m14633a();
        }

        @Nullable
        public final String m14649a() {
            return m14656g();
        }

        public final int jK_() {
            return 80218325;
        }

        public final GraphQLVisitableModel m14648a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel;
            FeedbackModel feedbackModel;
            DefaultTextWithEntitiesFieldsModel defaultTextWithEntitiesFieldsModel;
            h();
            if (m14653b() != null) {
                com.google.common.collect.ImmutableList.Builder a = ModelHelper.a(m14653b(), graphQLModelMutatingVisitor);
                if (a != null) {
                    ReactionStoryAttachmentStoryFragmentModel reactionStoryAttachmentStoryFragmentModel = (ReactionStoryAttachmentStoryFragmentModel) ModelHelper.a(null, this);
                    reactionStoryAttachmentStoryFragmentModel.f12167d = a.b();
                    graphQLVisitableModel = reactionStoryAttachmentStoryFragmentModel;
                    if (m14645j() != null) {
                        feedbackModel = (FeedbackModel) graphQLModelMutatingVisitor.b(m14645j());
                        if (m14645j() != feedbackModel) {
                            graphQLVisitableModel = (ReactionStoryAttachmentStoryFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                            graphQLVisitableModel.f12170g = feedbackModel;
                        }
                    }
                    if (m14646k() != null) {
                        defaultTextWithEntitiesFieldsModel = (DefaultTextWithEntitiesFieldsModel) graphQLModelMutatingVisitor.b(m14646k());
                        if (m14646k() != defaultTextWithEntitiesFieldsModel) {
                            graphQLVisitableModel = (ReactionStoryAttachmentStoryFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                            graphQLVisitableModel.f12172i = defaultTextWithEntitiesFieldsModel;
                        }
                    }
                    i();
                    return graphQLVisitableModel != null ? this : graphQLVisitableModel;
                }
            }
            graphQLVisitableModel = null;
            if (m14645j() != null) {
                feedbackModel = (FeedbackModel) graphQLModelMutatingVisitor.b(m14645j());
                if (m14645j() != feedbackModel) {
                    graphQLVisitableModel = (ReactionStoryAttachmentStoryFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f12170g = feedbackModel;
                }
            }
            if (m14646k() != null) {
                defaultTextWithEntitiesFieldsModel = (DefaultTextWithEntitiesFieldsModel) graphQLModelMutatingVisitor.b(m14646k());
                if (m14646k() != defaultTextWithEntitiesFieldsModel) {
                    graphQLVisitableModel = (ReactionStoryAttachmentStoryFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f12172i = defaultTextWithEntitiesFieldsModel;
                }
            }
            i();
            if (graphQLVisitableModel != null) {
            }
        }

        public final int m14647a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m14653b());
            int b = flatBufferBuilder.b(m14654c());
            int a2 = ModelHelper.a(flatBufferBuilder, m14645j());
            int b2 = flatBufferBuilder.b(m14656g());
            int a3 = ModelHelper.a(flatBufferBuilder, m14646k());
            flatBufferBuilder.c(6);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, b);
            flatBufferBuilder.a(2, this.f12169f, 0);
            flatBufferBuilder.b(3, a2);
            flatBufferBuilder.b(4, b2);
            flatBufferBuilder.b(5, a3);
            i();
            return flatBufferBuilder.d();
        }

        public final void m14650a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
            super.a(mutableFlatBuffer, i, obj);
            this.f12169f = mutableFlatBuffer.a(i, 2, 0);
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -278075691)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: find_friends_view_clicked */
    public final class ReactionTextWithEntitiesWithImagesModel extends BaseModel implements GraphQLVisitableModel, ReactionTextWithEntitiesWithImages {
        @Nullable
        private List<ImageRangesModel> f12181d;
        @Nullable
        private String f12182e;

        /* compiled from: find_friends_view_clicked */
        public final class Builder {
            @Nullable
            public ImmutableList<ImageRangesModel> f12173a;
            @Nullable
            public String f12174b;
        }

        /* compiled from: find_friends_view_clicked */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(ReactionTextWithEntitiesWithImagesModel.class, new Deserializer());
            }

            public Object m14657a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(ReactionTextWithEntitiesWithImagesParser.m14725a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object reactionTextWithEntitiesWithImagesModel = new ReactionTextWithEntitiesWithImagesModel();
                ((BaseModel) reactionTextWithEntitiesWithImagesModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (reactionTextWithEntitiesWithImagesModel instanceof Postprocessable) {
                    return ((Postprocessable) reactionTextWithEntitiesWithImagesModel).a();
                }
                return reactionTextWithEntitiesWithImagesModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -917107340)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: find_friends_view_clicked */
        public final class ImageRangesModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private EntityWithImageScaledFragmentModel f12178d;
            private int f12179e;
            private int f12180f;

            /* compiled from: find_friends_view_clicked */
            public final class Builder {
                @Nullable
                public EntityWithImageScaledFragmentModel f12175a;
                public int f12176b;
                public int f12177c;
            }

            /* compiled from: find_friends_view_clicked */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(ImageRangesModel.class, new Deserializer());
                }

                public Object m14658a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(ImageRangesParser.m14723b(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object imageRangesModel = new ImageRangesModel();
                    ((BaseModel) imageRangesModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (imageRangesModel instanceof Postprocessable) {
                        return ((Postprocessable) imageRangesModel).a();
                    }
                    return imageRangesModel;
                }
            }

            /* compiled from: find_friends_view_clicked */
            public class Serializer extends JsonSerializer<ImageRangesModel> {
                public final void m14659a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    ImageRangesModel imageRangesModel = (ImageRangesModel) obj;
                    if (imageRangesModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(imageRangesModel.m14662a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        imageRangesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    ImageRangesParser.m14724b(imageRangesModel.w_(), imageRangesModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(ImageRangesModel.class, new Serializer());
                }
            }

            @Nullable
            public final /* synthetic */ EntityWithImageScaledFragmentModel m14664a() {
                return m14661j();
            }

            public ImageRangesModel() {
                super(3);
            }

            public ImageRangesModel(MutableFlatBuffer mutableFlatBuffer) {
                super(3);
                a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
            }

            @Nullable
            private EntityWithImageScaledFragmentModel m14661j() {
                this.f12178d = (EntityWithImageScaledFragmentModel) super.a(this.f12178d, 0, EntityWithImageScaledFragmentModel.class);
                return this.f12178d;
            }

            public final int m14666b() {
                a(0, 1);
                return this.f12179e;
            }

            public final int m14667c() {
                a(0, 2);
                return this.f12180f;
            }

            public static ImageRangesModel m14660a(ImageRangesModel imageRangesModel) {
                if (imageRangesModel == null) {
                    return null;
                }
                if (imageRangesModel instanceof ImageRangesModel) {
                    return imageRangesModel;
                }
                Builder builder = new Builder();
                builder.f12175a = EntityWithImageScaledFragmentModel.m14424a(imageRangesModel.m14664a());
                builder.f12176b = imageRangesModel.m14666b();
                builder.f12177c = imageRangesModel.m14667c();
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                int a = ModelHelper.a(flatBufferBuilder, builder.f12175a);
                flatBufferBuilder.c(3);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.a(1, builder.f12176b, 0);
                flatBufferBuilder.a(2, builder.f12177c, 0);
                flatBufferBuilder.d(flatBufferBuilder.d());
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                return new ImageRangesModel(new MutableFlatBuffer(wrap, null, null, true, null));
            }

            public final int jK_() {
                return 55835407;
            }

            public final GraphQLVisitableModel m14663a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m14661j() != null) {
                    EntityWithImageScaledFragmentModel entityWithImageScaledFragmentModel = (EntityWithImageScaledFragmentModel) graphQLModelMutatingVisitor.b(m14661j());
                    if (m14661j() != entityWithImageScaledFragmentModel) {
                        graphQLVisitableModel = (ImageRangesModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f12178d = entityWithImageScaledFragmentModel;
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m14662a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m14661j());
                flatBufferBuilder.c(3);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.a(1, this.f12179e, 0);
                flatBufferBuilder.a(2, this.f12180f, 0);
                i();
                return flatBufferBuilder.d();
            }

            public final void m14665a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                super.a(mutableFlatBuffer, i, obj);
                this.f12179e = mutableFlatBuffer.a(i, 1, 0);
                this.f12180f = mutableFlatBuffer.a(i, 2, 0);
            }
        }

        /* compiled from: find_friends_view_clicked */
        public class Serializer extends JsonSerializer<ReactionTextWithEntitiesWithImagesModel> {
            public final void m14668a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                ReactionTextWithEntitiesWithImagesModel reactionTextWithEntitiesWithImagesModel = (ReactionTextWithEntitiesWithImagesModel) obj;
                if (reactionTextWithEntitiesWithImagesModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(reactionTextWithEntitiesWithImagesModel.m14670a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    reactionTextWithEntitiesWithImagesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                ReactionTextWithEntitiesWithImagesParser.m14726a(reactionTextWithEntitiesWithImagesModel.w_(), reactionTextWithEntitiesWithImagesModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(ReactionTextWithEntitiesWithImagesModel.class, new Serializer());
            }
        }

        public ReactionTextWithEntitiesWithImagesModel() {
            super(2);
        }

        public ReactionTextWithEntitiesWithImagesModel(MutableFlatBuffer mutableFlatBuffer) {
            super(2);
            a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
        }

        @Nonnull
        public final ImmutableList<ImageRangesModel> mo786b() {
            this.f12181d = super.a(this.f12181d, 0, ImageRangesModel.class);
            return (ImmutableList) this.f12181d;
        }

        @Nullable
        public final String mo785a() {
            this.f12182e = super.a(this.f12182e, 1);
            return this.f12182e;
        }

        public static ReactionTextWithEntitiesWithImagesModel m14669a(ReactionTextWithEntitiesWithImages reactionTextWithEntitiesWithImages) {
            if (reactionTextWithEntitiesWithImages == null) {
                return null;
            }
            if (reactionTextWithEntitiesWithImages instanceof ReactionTextWithEntitiesWithImagesModel) {
                return (ReactionTextWithEntitiesWithImagesModel) reactionTextWithEntitiesWithImages;
            }
            Builder builder = new Builder();
            com.google.common.collect.ImmutableList.Builder builder2 = ImmutableList.builder();
            for (int i = 0; i < reactionTextWithEntitiesWithImages.mo786b().size(); i++) {
                builder2.c(ImageRangesModel.m14660a((ImageRangesModel) reactionTextWithEntitiesWithImages.mo786b().get(i)));
            }
            builder.f12173a = builder2.b();
            builder.f12174b = reactionTextWithEntitiesWithImages.mo785a();
            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
            int a = ModelHelper.a(flatBufferBuilder, builder.f12173a);
            int b = flatBufferBuilder.b(builder.f12174b);
            flatBufferBuilder.c(2);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, b);
            flatBufferBuilder.d(flatBufferBuilder.d());
            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
            wrap.position(0);
            return new ReactionTextWithEntitiesWithImagesModel(new MutableFlatBuffer(wrap, null, null, true, null));
        }

        public final int jK_() {
            return -1919764332;
        }

        public final GraphQLVisitableModel m14671a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (mo786b() != null) {
                com.google.common.collect.ImmutableList.Builder a = ModelHelper.a(mo786b(), graphQLModelMutatingVisitor);
                if (a != null) {
                    graphQLVisitableModel = (ReactionTextWithEntitiesWithImagesModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f12181d = a.b();
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m14670a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, mo786b());
            int b = flatBufferBuilder.b(mo785a());
            flatBufferBuilder.c(2);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, b);
            i();
            return flatBufferBuilder.d();
        }
    }
}
