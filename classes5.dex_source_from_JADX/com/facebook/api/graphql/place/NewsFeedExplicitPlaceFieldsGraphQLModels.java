package com.facebook.api.graphql.place;

import com.facebook.api.graphql.place.NewsFeedExplicitPlaceFieldsGraphQLInterfaces.NewsFeedDefaultsPlaceFieldsWithoutMedia;
import com.facebook.api.graphql.place.NewsFeedExplicitPlaceFieldsGraphQLParsers.NewsFeedDefaultsPlaceFieldsWithoutMediaParser;
import com.facebook.api.graphql.place.NewsFeedExplicitPlaceFieldsGraphQLParsers.NewsFeedDefaultsPlaceFieldsWithoutMediaParser.CityParser;
import com.facebook.api.graphql.place.NewsFeedExplicitPlaceFieldsGraphQLParsers.NewsFeedDefaultsPlaceFieldsWithoutMediaParser.OverallStarRatingParser;
import com.facebook.api.graphql.place.NewsFeedExplicitPlaceFieldsGraphQLParsers.NewsFeedDefaultsPlaceFieldsWithoutMediaParser.PageVisitsParser;
import com.facebook.api.graphql.place.NewsFeedExplicitPlaceFieldsGraphQLParsers.NewsFeedDefaultsPlaceFieldsWithoutMediaParser.ViewerVisitsParser;
import com.facebook.api.graphql.saved.SaveDefaultsGraphQLModels.SavableTimelineAppCollectionExtraFieldsModel;
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
import com.facebook.graphql.enums.GraphQLPageSuperCategoryType;
import com.facebook.graphql.enums.GraphQLSavedState;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.ModelHelper;
import com.facebook.graphql.querybuilder.common.CommonGraphQLModels.DefaultLocationFieldsModel;
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

/* compiled from: tdd */
public class NewsFeedExplicitPlaceFieldsGraphQLModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -869841039)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: tdd */
    public final class NewsFeedDefaultsPlaceFieldsWithoutMediaModel extends BaseModel implements NewsFeedDefaultsPlaceFieldsWithoutMedia, GraphQLPersistableNode, GraphQLVisitableConsistentModel {
        @Nullable
        private GraphQLObjectType f2101d;
        @Nullable
        private CityModel f2102e;
        @Nullable
        private String f2103f;
        private boolean f2104g;
        @Nullable
        private DefaultLocationFieldsModel f2105h;
        @Nullable
        private String f2106i;
        @Nullable
        private OverallStarRatingModel f2107j;
        @Nullable
        private PageVisitsModel f2108k;
        private boolean f2109l;
        @Nullable
        private SavableTimelineAppCollectionExtraFieldsModel f2110m;
        private boolean f2111n;
        @Nullable
        private GraphQLPageSuperCategoryType f2112o;
        @Nullable
        private String f2113p;
        @Nullable
        private GraphQLSavedState f2114q;
        @Nullable
        private ViewerVisitsModel f2115r;

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 168067168)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: tdd */
        public final class CityModel extends BaseModel implements GraphQLVisitableConsistentModel {
            @Nullable
            private String f2096d;

            /* compiled from: tdd */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(CityModel.class, new Deserializer());
                }

                public Object m2796a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(CityParser.m2844a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object cityModel = new CityModel();
                    ((BaseModel) cityModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (cityModel instanceof Postprocessable) {
                        return ((Postprocessable) cityModel).a();
                    }
                    return cityModel;
                }
            }

            /* compiled from: tdd */
            public class Serializer extends JsonSerializer<CityModel> {
                public final void m2797a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    CityModel cityModel = (CityModel) obj;
                    if (cityModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(cityModel.m2798a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        cityModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    CityParser.m2845a(cityModel.w_(), cityModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(CityModel.class, new Serializer());
                }
            }

            public CityModel() {
                super(1);
            }

            public final void m2801a(String str, ConsistencyTuple consistencyTuple) {
                consistencyTuple.a();
            }

            public final void m2802a(String str, Object obj, boolean z) {
            }

            @Nullable
            public final String m2800a() {
                this.f2096d = super.a(this.f2096d, 0);
                return this.f2096d;
            }

            public final int jK_() {
                return 2479791;
            }

            public final GraphQLVisitableModel m2799a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m2798a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m2800a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, b);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: tdd */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(NewsFeedDefaultsPlaceFieldsWithoutMediaModel.class, new Deserializer());
            }

            public Object m2803a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(NewsFeedDefaultsPlaceFieldsWithoutMediaParser.m2852a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object newsFeedDefaultsPlaceFieldsWithoutMediaModel = new NewsFeedDefaultsPlaceFieldsWithoutMediaModel();
                ((BaseModel) newsFeedDefaultsPlaceFieldsWithoutMediaModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (newsFeedDefaultsPlaceFieldsWithoutMediaModel instanceof Postprocessable) {
                    return ((Postprocessable) newsFeedDefaultsPlaceFieldsWithoutMediaModel).a();
                }
                return newsFeedDefaultsPlaceFieldsWithoutMediaModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -963013398)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: tdd */
        public final class OverallStarRatingModel extends BaseModel implements GraphQLVisitableModel {
            private int f2097d;
            private double f2098e;

            /* compiled from: tdd */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(OverallStarRatingModel.class, new Deserializer());
                }

                public Object m2804a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(OverallStarRatingParser.m2846a(jsonParser, flatBufferBuilder));
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

            /* compiled from: tdd */
            public class Serializer extends JsonSerializer<OverallStarRatingModel> {
                public final void m2805a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    OverallStarRatingModel overallStarRatingModel = (OverallStarRatingModel) obj;
                    if (overallStarRatingModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(overallStarRatingModel.m2807a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        overallStarRatingModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    OverallStarRatingParser.m2847a(overallStarRatingModel.w_(), overallStarRatingModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(OverallStarRatingModel.class, new Serializer());
                }
            }

            public OverallStarRatingModel() {
                super(2);
            }

            public final int m2806a() {
                a(0, 0);
                return this.f2097d;
            }

            public final double m2810b() {
                a(0, 1);
                return this.f2098e;
            }

            public final int jK_() {
                return -1854235203;
            }

            public final GraphQLVisitableModel m2808a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m2807a(FlatBufferBuilder flatBufferBuilder) {
                h();
                flatBufferBuilder.c(2);
                flatBufferBuilder.a(0, this.f2097d, 0);
                flatBufferBuilder.a(1, this.f2098e, 0.0d);
                i();
                return flatBufferBuilder.d();
            }

            public final void m2809a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                super.a(mutableFlatBuffer, i, obj);
                this.f2097d = mutableFlatBuffer.a(i, 0, 0);
                this.f2098e = mutableFlatBuffer.a(i, 1, 0.0d);
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -1723990064)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: tdd */
        public final class PageVisitsModel extends BaseModel implements GraphQLVisitableModel {
            private int f2099d;

            /* compiled from: tdd */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(PageVisitsModel.class, new Deserializer());
                }

                public Object m2811a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(PageVisitsParser.m2848a(jsonParser, flatBufferBuilder));
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

            /* compiled from: tdd */
            public class Serializer extends JsonSerializer<PageVisitsModel> {
                public final void m2812a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    PageVisitsModel pageVisitsModel = (PageVisitsModel) obj;
                    if (pageVisitsModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(pageVisitsModel.m2814a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        pageVisitsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    PageVisitsParser.m2849a(pageVisitsModel.w_(), pageVisitsModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(PageVisitsModel.class, new Serializer());
                }
            }

            public PageVisitsModel() {
                super(1);
            }

            public final int m2813a() {
                a(0, 0);
                return this.f2099d;
            }

            public final int jK_() {
                return -838301099;
            }

            public final GraphQLVisitableModel m2815a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m2814a(FlatBufferBuilder flatBufferBuilder) {
                h();
                flatBufferBuilder.c(1);
                flatBufferBuilder.a(0, this.f2099d, 0);
                i();
                return flatBufferBuilder.d();
            }

            public final void m2816a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                super.a(mutableFlatBuffer, i, obj);
                this.f2099d = mutableFlatBuffer.a(i, 0, 0);
            }
        }

        /* compiled from: tdd */
        public class Serializer extends JsonSerializer<NewsFeedDefaultsPlaceFieldsWithoutMediaModel> {
            public final void m2817a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                NewsFeedDefaultsPlaceFieldsWithoutMediaModel newsFeedDefaultsPlaceFieldsWithoutMediaModel = (NewsFeedDefaultsPlaceFieldsWithoutMediaModel) obj;
                if (newsFeedDefaultsPlaceFieldsWithoutMediaModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(newsFeedDefaultsPlaceFieldsWithoutMediaModel.m2838a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    newsFeedDefaultsPlaceFieldsWithoutMediaModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                NewsFeedDefaultsPlaceFieldsWithoutMediaParser.m2853a(newsFeedDefaultsPlaceFieldsWithoutMediaModel.w_(), newsFeedDefaultsPlaceFieldsWithoutMediaModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(NewsFeedDefaultsPlaceFieldsWithoutMediaModel.class, new Serializer());
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -1723990064)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: tdd */
        public final class ViewerVisitsModel extends BaseModel implements GraphQLVisitableModel {
            private int f2100d;

            /* compiled from: tdd */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(ViewerVisitsModel.class, new Deserializer());
                }

                public Object m2818a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(ViewerVisitsParser.m2850a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object viewerVisitsModel = new ViewerVisitsModel();
                    ((BaseModel) viewerVisitsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (viewerVisitsModel instanceof Postprocessable) {
                        return ((Postprocessable) viewerVisitsModel).a();
                    }
                    return viewerVisitsModel;
                }
            }

            /* compiled from: tdd */
            public class Serializer extends JsonSerializer<ViewerVisitsModel> {
                public final void m2819a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    ViewerVisitsModel viewerVisitsModel = (ViewerVisitsModel) obj;
                    if (viewerVisitsModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(viewerVisitsModel.m2821a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        viewerVisitsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    ViewerVisitsParser.m2851a(viewerVisitsModel.w_(), viewerVisitsModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(ViewerVisitsModel.class, new Serializer());
                }
            }

            public ViewerVisitsModel() {
                super(1);
            }

            public final int m2820a() {
                a(0, 0);
                return this.f2100d;
            }

            public final int jK_() {
                return 1712942040;
            }

            public final GraphQLVisitableModel m2822a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m2821a(FlatBufferBuilder flatBufferBuilder) {
                h();
                flatBufferBuilder.c(1);
                flatBufferBuilder.a(0, this.f2100d, 0);
                i();
                return flatBufferBuilder.d();
            }

            public final void m2823a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                super.a(mutableFlatBuffer, i, obj);
                this.f2100d = mutableFlatBuffer.a(i, 0, 0);
            }
        }

        public NewsFeedDefaultsPlaceFieldsWithoutMediaModel() {
            super(15);
        }

        public final void m2842a(String str, ConsistencyTuple consistencyTuple) {
            if ("name".equals(str)) {
                consistencyTuple.a = m2830n();
                consistencyTuple.b = u_();
                consistencyTuple.c = 5;
            } else if ("viewer_saved_state".equals(str)) {
                consistencyTuple.a = m2836t();
                consistencyTuple.b = u_();
                consistencyTuple.c = 13;
            } else {
                consistencyTuple.a();
            }
        }

        public final void m2843a(String str, Object obj, boolean z) {
            if ("name".equals(str)) {
                m2825a((String) obj);
            } else if ("viewer_saved_state".equals(str)) {
                m2824a((GraphQLSavedState) obj);
            }
        }

        @Nullable
        private GraphQLObjectType m2826j() {
            if (this.b != null && this.f2101d == null) {
                this.f2101d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
            }
            return this.f2101d;
        }

        @Nullable
        private CityModel m2827k() {
            this.f2102e = (CityModel) super.a(this.f2102e, 1, CityModel.class);
            return this.f2102e;
        }

        @Nullable
        private String m2828l() {
            this.f2103f = super.a(this.f2103f, 2);
            return this.f2103f;
        }

        @Nullable
        private DefaultLocationFieldsModel m2829m() {
            this.f2105h = (DefaultLocationFieldsModel) super.a(this.f2105h, 4, DefaultLocationFieldsModel.class);
            return this.f2105h;
        }

        @Nullable
        private String m2830n() {
            this.f2106i = super.a(this.f2106i, 5);
            return this.f2106i;
        }

        private void m2825a(@Nullable String str) {
            this.f2106i = str;
            if (this.b != null && this.b.d) {
                this.b.a(this.c, 5, str);
            }
        }

        @Nullable
        private OverallStarRatingModel m2831o() {
            this.f2107j = (OverallStarRatingModel) super.a(this.f2107j, 6, OverallStarRatingModel.class);
            return this.f2107j;
        }

        @Nullable
        private PageVisitsModel m2832p() {
            this.f2108k = (PageVisitsModel) super.a(this.f2108k, 7, PageVisitsModel.class);
            return this.f2108k;
        }

        @Nullable
        private SavableTimelineAppCollectionExtraFieldsModel m2833q() {
            this.f2110m = (SavableTimelineAppCollectionExtraFieldsModel) super.a(this.f2110m, 9, SavableTimelineAppCollectionExtraFieldsModel.class);
            return this.f2110m;
        }

        @Nullable
        private GraphQLPageSuperCategoryType m2834r() {
            this.f2112o = (GraphQLPageSuperCategoryType) super.b(this.f2112o, 11, GraphQLPageSuperCategoryType.class, GraphQLPageSuperCategoryType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
            return this.f2112o;
        }

        @Nullable
        private String m2835s() {
            this.f2113p = super.a(this.f2113p, 12);
            return this.f2113p;
        }

        @Nullable
        private GraphQLSavedState m2836t() {
            this.f2114q = (GraphQLSavedState) super.b(this.f2114q, 13, GraphQLSavedState.class, GraphQLSavedState.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
            return this.f2114q;
        }

        private void m2824a(GraphQLSavedState graphQLSavedState) {
            this.f2114q = graphQLSavedState;
            if (this.b != null && this.b.d) {
                this.b.a(this.c, 13, graphQLSavedState != null ? graphQLSavedState.name() : null);
            }
        }

        @Nullable
        private ViewerVisitsModel m2837u() {
            this.f2115r = (ViewerVisitsModel) super.a(this.f2115r, 14, ViewerVisitsModel.class);
            return this.f2115r;
        }

        @Nullable
        public final String m2840a() {
            return m2828l();
        }

        public final int jK_() {
            return 77195495;
        }

        public final GraphQLVisitableModel m2839a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m2827k() != null) {
                CityModel cityModel = (CityModel) graphQLModelMutatingVisitor.b(m2827k());
                if (m2827k() != cityModel) {
                    graphQLVisitableModel = (NewsFeedDefaultsPlaceFieldsWithoutMediaModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f2102e = cityModel;
                }
            }
            if (m2829m() != null) {
                DefaultLocationFieldsModel defaultLocationFieldsModel = (DefaultLocationFieldsModel) graphQLModelMutatingVisitor.b(m2829m());
                if (m2829m() != defaultLocationFieldsModel) {
                    graphQLVisitableModel = (NewsFeedDefaultsPlaceFieldsWithoutMediaModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f2105h = defaultLocationFieldsModel;
                }
            }
            if (m2831o() != null) {
                OverallStarRatingModel overallStarRatingModel = (OverallStarRatingModel) graphQLModelMutatingVisitor.b(m2831o());
                if (m2831o() != overallStarRatingModel) {
                    graphQLVisitableModel = (NewsFeedDefaultsPlaceFieldsWithoutMediaModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f2107j = overallStarRatingModel;
                }
            }
            if (m2832p() != null) {
                PageVisitsModel pageVisitsModel = (PageVisitsModel) graphQLModelMutatingVisitor.b(m2832p());
                if (m2832p() != pageVisitsModel) {
                    graphQLVisitableModel = (NewsFeedDefaultsPlaceFieldsWithoutMediaModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f2108k = pageVisitsModel;
                }
            }
            if (m2833q() != null) {
                SavableTimelineAppCollectionExtraFieldsModel savableTimelineAppCollectionExtraFieldsModel = (SavableTimelineAppCollectionExtraFieldsModel) graphQLModelMutatingVisitor.b(m2833q());
                if (m2833q() != savableTimelineAppCollectionExtraFieldsModel) {
                    graphQLVisitableModel = (NewsFeedDefaultsPlaceFieldsWithoutMediaModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f2110m = savableTimelineAppCollectionExtraFieldsModel;
                }
            }
            if (m2837u() != null) {
                ViewerVisitsModel viewerVisitsModel = (ViewerVisitsModel) graphQLModelMutatingVisitor.b(m2837u());
                if (m2837u() != viewerVisitsModel) {
                    graphQLVisitableModel = (NewsFeedDefaultsPlaceFieldsWithoutMediaModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f2115r = viewerVisitsModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m2838a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m2826j());
            int a2 = ModelHelper.a(flatBufferBuilder, m2827k());
            int b = flatBufferBuilder.b(m2828l());
            int a3 = ModelHelper.a(flatBufferBuilder, m2829m());
            int b2 = flatBufferBuilder.b(m2830n());
            int a4 = ModelHelper.a(flatBufferBuilder, m2831o());
            int a5 = ModelHelper.a(flatBufferBuilder, m2832p());
            int a6 = ModelHelper.a(flatBufferBuilder, m2833q());
            int a7 = flatBufferBuilder.a(m2834r());
            int b3 = flatBufferBuilder.b(m2835s());
            int a8 = flatBufferBuilder.a(m2836t());
            int a9 = ModelHelper.a(flatBufferBuilder, m2837u());
            flatBufferBuilder.c(15);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, a2);
            flatBufferBuilder.b(2, b);
            flatBufferBuilder.a(3, this.f2104g);
            flatBufferBuilder.b(4, a3);
            flatBufferBuilder.b(5, b2);
            flatBufferBuilder.b(6, a4);
            flatBufferBuilder.b(7, a5);
            flatBufferBuilder.a(8, this.f2109l);
            flatBufferBuilder.b(9, a6);
            flatBufferBuilder.a(10, this.f2111n);
            flatBufferBuilder.b(11, a7);
            flatBufferBuilder.b(12, b3);
            flatBufferBuilder.b(13, a8);
            flatBufferBuilder.b(14, a9);
            i();
            return flatBufferBuilder.d();
        }

        public final void m2841a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
            super.a(mutableFlatBuffer, i, obj);
            this.f2104g = mutableFlatBuffer.a(i, 3);
            this.f2109l = mutableFlatBuffer.a(i, 8);
            this.f2111n = mutableFlatBuffer.a(i, 10);
        }
    }
}
