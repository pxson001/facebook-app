package com.facebook.placetips.common.graphql;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbSerializerProvider;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.FragmentModelWithBridge;
import com.facebook.flatbuffers.ModelWithFlatBufferFormatHash;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.ModelHelper;
import com.facebook.graphql.querybuilder.common.CommonGraphQL2Models.DefaultPageInfoFieldsModel;
import com.facebook.graphql.visitor.ConsistencyTuple;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLPersistableNode;
import com.facebook.graphql.visitor.GraphQLVisitableConsistentModel;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.facebook.placetips.common.graphql.PlaceTipWithReactionUnitsGraphQlFragmentParsers.PlaceTipWithReactionUnitsGraphQlFragmentParser;
import com.facebook.placetips.common.graphql.PlaceTipWithReactionUnitsGraphQlFragmentParsers.PlaceTipWithReactionUnitsGraphQlFragmentParser.PlaceReactionUnitsParser;
import com.facebook.placetips.common.graphql.PlaceTipWithReactionUnitsGraphQlFragmentParsers.PlaceTipWithReactionUnitsGraphQlFragmentParser.PlaceReactionUnitsParser.EdgesParser;
import com.facebook.reaction.protocol.graphql.FetchReactionGraphQLModels.PlaceTipWelcomeHeaderFragmentModel;
import com.facebook.reaction.protocol.graphql.FetchReactionGraphQLModels.PlaceTipsFeedUnitFragmentModel;
import com.facebook.reaction.protocol.graphql.FetchReactionGraphQLModels.ReactionUnitFragmentModel;
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

/* compiled from: scoring_plays */
public class PlaceTipWithReactionUnitsGraphQlFragmentModels {

    @FragmentModelWithBridge
    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -790742292)
    @JsonSerialize(using = Serializer.class)
    /* compiled from: scoring_plays */
    public final class PlaceTipWithReactionUnitsGraphQlFragmentModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
        @Nullable
        private List<String> f3874d;
        @Nullable
        private String f3875e;
        @Nullable
        private String f3876f;
        @Nullable
        private PlaceReactionUnitsModel f3877g;

        /* compiled from: scoring_plays */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(PlaceTipWithReactionUnitsGraphQlFragmentModel.class, new Deserializer());
            }

            public Object m3841a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(PlaceTipWithReactionUnitsGraphQlFragmentParser.m3870a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object placeTipWithReactionUnitsGraphQlFragmentModel = new PlaceTipWithReactionUnitsGraphQlFragmentModel();
                ((BaseModel) placeTipWithReactionUnitsGraphQlFragmentModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (placeTipWithReactionUnitsGraphQlFragmentModel instanceof Postprocessable) {
                    return ((Postprocessable) placeTipWithReactionUnitsGraphQlFragmentModel).a();
                }
                return placeTipWithReactionUnitsGraphQlFragmentModel;
            }
        }

        @FragmentModelWithBridge
        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -2049277384)
        @JsonSerialize(using = Serializer.class)
        /* compiled from: scoring_plays */
        public final class PlaceReactionUnitsModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private List<EdgesModel> f3869d;
            @Nullable
            private DefaultPageInfoFieldsModel f3870e;
            @Nullable
            private PlaceTipsFeedUnitFragmentModel f3871f;
            @Nullable
            private PlaceTipWelcomeHeaderFragmentModel f3872g;
            @Nullable
            private String f3873h;

            /* compiled from: scoring_plays */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(PlaceReactionUnitsModel.class, new Deserializer());
                }

                public Object m3842a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(PlaceReactionUnitsParser.m3868a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object placeReactionUnitsModel = new PlaceReactionUnitsModel();
                    ((BaseModel) placeReactionUnitsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (placeReactionUnitsModel instanceof Postprocessable) {
                        return ((Postprocessable) placeReactionUnitsModel).a();
                    }
                    return placeReactionUnitsModel;
                }
            }

            @FragmentModelWithBridge
            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = 1861402480)
            @JsonSerialize(using = Serializer.class)
            /* compiled from: scoring_plays */
            public final class EdgesModel extends BaseModel implements GraphQLVisitableModel {
                @Nullable
                private ReactionUnitFragmentModel f3868d;

                /* compiled from: scoring_plays */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(EdgesModel.class, new Deserializer());
                    }

                    public Object m3843a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(EdgesParser.m3866b(jsonParser, flatBufferBuilder));
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

                /* compiled from: scoring_plays */
                public class Serializer extends JsonSerializer<EdgesModel> {
                    public final void m3844a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        EdgesModel edgesModel = (EdgesModel) obj;
                        if (edgesModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(edgesModel.m3846a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            edgesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        EdgesParser.m3867b(edgesModel.w_(), edgesModel.u_(), jsonGenerator, serializerProvider);
                    }

                    static {
                        FbSerializerProvider.a(EdgesModel.class, new Serializer());
                    }
                }

                public EdgesModel() {
                    super(1);
                }

                @Nullable
                private ReactionUnitFragmentModel m3845a() {
                    this.f3868d = (ReactionUnitFragmentModel) super.a(this.f3868d, 0, ReactionUnitFragmentModel.class);
                    return this.f3868d;
                }

                public final int jK_() {
                    return -231815123;
                }

                public final GraphQLVisitableModel m3847a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    GraphQLVisitableModel graphQLVisitableModel = null;
                    h();
                    if (m3845a() != null) {
                        ReactionUnitFragmentModel reactionUnitFragmentModel = (ReactionUnitFragmentModel) graphQLModelMutatingVisitor.b(m3845a());
                        if (m3845a() != reactionUnitFragmentModel) {
                            graphQLVisitableModel = (EdgesModel) ModelHelper.a(null, this);
                            graphQLVisitableModel.f3868d = reactionUnitFragmentModel;
                        }
                    }
                    i();
                    return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                }

                public final int m3846a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int a = ModelHelper.a(flatBufferBuilder, m3845a());
                    flatBufferBuilder.c(1);
                    flatBufferBuilder.b(0, a);
                    i();
                    return flatBufferBuilder.d();
                }
            }

            /* compiled from: scoring_plays */
            public class Serializer extends JsonSerializer<PlaceReactionUnitsModel> {
                public final void m3848a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    PlaceReactionUnitsModel placeReactionUnitsModel = (PlaceReactionUnitsModel) obj;
                    if (placeReactionUnitsModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(placeReactionUnitsModel.m3854a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        placeReactionUnitsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    PlaceReactionUnitsParser.m3869a(placeReactionUnitsModel.w_(), placeReactionUnitsModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(PlaceReactionUnitsModel.class, new Serializer());
                }
            }

            public PlaceReactionUnitsModel() {
                super(5);
            }

            @Nonnull
            private ImmutableList<EdgesModel> m3849a() {
                this.f3869d = super.a(this.f3869d, 0, EdgesModel.class);
                return (ImmutableList) this.f3869d;
            }

            @Nullable
            private DefaultPageInfoFieldsModel m3850j() {
                this.f3870e = (DefaultPageInfoFieldsModel) super.a(this.f3870e, 1, DefaultPageInfoFieldsModel.class);
                return this.f3870e;
            }

            @Nullable
            private PlaceTipsFeedUnitFragmentModel m3851k() {
                this.f3871f = (PlaceTipsFeedUnitFragmentModel) super.a(this.f3871f, 2, PlaceTipsFeedUnitFragmentModel.class);
                return this.f3871f;
            }

            @Nullable
            private PlaceTipWelcomeHeaderFragmentModel m3852l() {
                this.f3872g = (PlaceTipWelcomeHeaderFragmentModel) super.a(this.f3872g, 3, PlaceTipWelcomeHeaderFragmentModel.class);
                return this.f3872g;
            }

            @Nullable
            private String m3853m() {
                this.f3873h = super.a(this.f3873h, 4);
                return this.f3873h;
            }

            public final int jK_() {
                return 504513870;
            }

            public final GraphQLVisitableModel m3855a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel;
                DefaultPageInfoFieldsModel defaultPageInfoFieldsModel;
                PlaceTipsFeedUnitFragmentModel placeTipsFeedUnitFragmentModel;
                PlaceTipWelcomeHeaderFragmentModel placeTipWelcomeHeaderFragmentModel;
                h();
                if (m3849a() != null) {
                    Builder a = ModelHelper.a(m3849a(), graphQLModelMutatingVisitor);
                    if (a != null) {
                        PlaceReactionUnitsModel placeReactionUnitsModel = (PlaceReactionUnitsModel) ModelHelper.a(null, this);
                        placeReactionUnitsModel.f3869d = a.b();
                        graphQLVisitableModel = placeReactionUnitsModel;
                        if (m3850j() != null) {
                            defaultPageInfoFieldsModel = (DefaultPageInfoFieldsModel) graphQLModelMutatingVisitor.b(m3850j());
                            if (m3850j() != defaultPageInfoFieldsModel) {
                                graphQLVisitableModel = (PlaceReactionUnitsModel) ModelHelper.a(graphQLVisitableModel, this);
                                graphQLVisitableModel.f3870e = defaultPageInfoFieldsModel;
                            }
                        }
                        if (m3851k() != null) {
                            placeTipsFeedUnitFragmentModel = (PlaceTipsFeedUnitFragmentModel) graphQLModelMutatingVisitor.b(m3851k());
                            if (m3851k() != placeTipsFeedUnitFragmentModel) {
                                graphQLVisitableModel = (PlaceReactionUnitsModel) ModelHelper.a(graphQLVisitableModel, this);
                                graphQLVisitableModel.f3871f = placeTipsFeedUnitFragmentModel;
                            }
                        }
                        if (m3852l() != null) {
                            placeTipWelcomeHeaderFragmentModel = (PlaceTipWelcomeHeaderFragmentModel) graphQLModelMutatingVisitor.b(m3852l());
                            if (m3852l() != placeTipWelcomeHeaderFragmentModel) {
                                graphQLVisitableModel = (PlaceReactionUnitsModel) ModelHelper.a(graphQLVisitableModel, this);
                                graphQLVisitableModel.f3872g = placeTipWelcomeHeaderFragmentModel;
                            }
                        }
                        i();
                        return graphQLVisitableModel != null ? this : graphQLVisitableModel;
                    }
                }
                graphQLVisitableModel = null;
                if (m3850j() != null) {
                    defaultPageInfoFieldsModel = (DefaultPageInfoFieldsModel) graphQLModelMutatingVisitor.b(m3850j());
                    if (m3850j() != defaultPageInfoFieldsModel) {
                        graphQLVisitableModel = (PlaceReactionUnitsModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f3870e = defaultPageInfoFieldsModel;
                    }
                }
                if (m3851k() != null) {
                    placeTipsFeedUnitFragmentModel = (PlaceTipsFeedUnitFragmentModel) graphQLModelMutatingVisitor.b(m3851k());
                    if (m3851k() != placeTipsFeedUnitFragmentModel) {
                        graphQLVisitableModel = (PlaceReactionUnitsModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f3871f = placeTipsFeedUnitFragmentModel;
                    }
                }
                if (m3852l() != null) {
                    placeTipWelcomeHeaderFragmentModel = (PlaceTipWelcomeHeaderFragmentModel) graphQLModelMutatingVisitor.b(m3852l());
                    if (m3852l() != placeTipWelcomeHeaderFragmentModel) {
                        graphQLVisitableModel = (PlaceReactionUnitsModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f3872g = placeTipWelcomeHeaderFragmentModel;
                    }
                }
                i();
                if (graphQLVisitableModel != null) {
                }
            }

            public final int m3854a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m3849a());
                int a2 = ModelHelper.a(flatBufferBuilder, m3850j());
                int a3 = ModelHelper.a(flatBufferBuilder, m3851k());
                int a4 = ModelHelper.a(flatBufferBuilder, m3852l());
                int b = flatBufferBuilder.b(m3853m());
                flatBufferBuilder.c(5);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.b(1, a2);
                flatBufferBuilder.b(2, a3);
                flatBufferBuilder.b(3, a4);
                flatBufferBuilder.b(4, b);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: scoring_plays */
        public class Serializer extends JsonSerializer<PlaceTipWithReactionUnitsGraphQlFragmentModel> {
            public final void m3856a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                PlaceTipWithReactionUnitsGraphQlFragmentModel placeTipWithReactionUnitsGraphQlFragmentModel = (PlaceTipWithReactionUnitsGraphQlFragmentModel) obj;
                if (placeTipWithReactionUnitsGraphQlFragmentModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(placeTipWithReactionUnitsGraphQlFragmentModel.m3861a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    placeTipWithReactionUnitsGraphQlFragmentModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                PlaceTipWithReactionUnitsGraphQlFragmentParser.m3871a(placeTipWithReactionUnitsGraphQlFragmentModel.w_(), placeTipWithReactionUnitsGraphQlFragmentModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(PlaceTipWithReactionUnitsGraphQlFragmentModel.class, new Serializer());
            }
        }

        public PlaceTipWithReactionUnitsGraphQlFragmentModel() {
            super(4);
        }

        public final void m3864a(String str, ConsistencyTuple consistencyTuple) {
            consistencyTuple.a();
        }

        public final void m3865a(String str, Object obj, boolean z) {
        }

        @Nonnull
        private ImmutableList<String> m3857j() {
            this.f3874d = super.a(this.f3874d, 0);
            return (ImmutableList) this.f3874d;
        }

        @Nullable
        private String m3858k() {
            this.f3875e = super.a(this.f3875e, 1);
            return this.f3875e;
        }

        @Nullable
        private String m3859l() {
            this.f3876f = super.a(this.f3876f, 2);
            return this.f3876f;
        }

        @Nullable
        private PlaceReactionUnitsModel m3860m() {
            this.f3877g = (PlaceReactionUnitsModel) super.a(this.f3877g, 3, PlaceReactionUnitsModel.class);
            return this.f3877g;
        }

        @Nullable
        public final String m3863a() {
            return m3858k();
        }

        public final int jK_() {
            return 2479791;
        }

        public final GraphQLVisitableModel m3862a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m3860m() != null) {
                PlaceReactionUnitsModel placeReactionUnitsModel = (PlaceReactionUnitsModel) graphQLModelMutatingVisitor.b(m3860m());
                if (m3860m() != placeReactionUnitsModel) {
                    graphQLVisitableModel = (PlaceTipWithReactionUnitsGraphQlFragmentModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f3877g = placeReactionUnitsModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m3861a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int c = flatBufferBuilder.c(m3857j());
            int b = flatBufferBuilder.b(m3858k());
            int b2 = flatBufferBuilder.b(m3859l());
            int a = ModelHelper.a(flatBufferBuilder, m3860m());
            flatBufferBuilder.c(4);
            flatBufferBuilder.b(0, c);
            flatBufferBuilder.b(1, b);
            flatBufferBuilder.b(2, b2);
            flatBufferBuilder.b(3, a);
            i();
            return flatBufferBuilder.d();
        }
    }
}
