package com.facebook.timeline.viewfeaturedcontainers.protocol;

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
import com.facebook.graphql.querybuilder.common.CommonGraphQL2Interfaces.DefaultVect2Fields;
import com.facebook.graphql.querybuilder.common.CommonGraphQL2Models.DefaultVect2FieldsModel;
import com.facebook.graphql.querybuilder.common.CommonGraphQLInterfaces.DefaultImageFields;
import com.facebook.graphql.querybuilder.common.CommonGraphQLModels.DefaultImageFieldsModel;
import com.facebook.graphql.visitor.ConsistencyTuple;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLPersistableNode;
import com.facebook.graphql.visitor.GraphQLVisitableConsistentModel;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.facebook.photos.data.protocol.PhotosDefaultsGraphQLInterfaces.SizeAwareMedia;
import com.facebook.timeline.protocol.FetchTimelineHeaderGraphQLInterfaces.CollageLayoutFields;
import com.facebook.timeline.protocol.FetchTimelineHeaderGraphQLModels.CollageLayoutFieldsModel;
import com.facebook.timeline.viewfeaturedcontainers.protocol.FeaturedContainersGraphQLParsers.FeaturedContainerEdgeParser;
import com.facebook.timeline.viewfeaturedcontainers.protocol.FeaturedContainersGraphQLParsers.FeaturedContainerParser;
import com.facebook.timeline.viewfeaturedcontainers.protocol.FeaturedContainersGraphQLParsers.FeaturedContainerParser.ContainerCoverMediaParser;
import com.facebook.timeline.viewfeaturedcontainers.protocol.FeaturedContainersGraphQLParsers.FeaturedContainerParser.StoriesParser;
import com.facebook.timeline.viewfeaturedcontainers.protocol.FeaturedContainersGraphQLParsers.FeaturedContainerParser.TitleParser;
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

/* compiled from: extra_events_discovery_fragment_location_data */
public class FeaturedContainersGraphQLModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 2078717849)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: extra_events_discovery_fragment_location_data */
    public final class FeaturedContainerEdgeModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private CollageLayoutFieldsModel f12843d;
        @Nullable
        private FeaturedContainerModel f12844e;

        /* compiled from: extra_events_discovery_fragment_location_data */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(FeaturedContainerEdgeModel.class, new Deserializer());
            }

            public Object m12799a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(FeaturedContainerEdgeParser.m12865b(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object featuredContainerEdgeModel = new FeaturedContainerEdgeModel();
                ((BaseModel) featuredContainerEdgeModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (featuredContainerEdgeModel instanceof Postprocessable) {
                    return ((Postprocessable) featuredContainerEdgeModel).a();
                }
                return featuredContainerEdgeModel;
            }
        }

        /* compiled from: extra_events_discovery_fragment_location_data */
        public class Serializer extends JsonSerializer<FeaturedContainerEdgeModel> {
            public final void m12800a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                FeaturedContainerEdgeModel featuredContainerEdgeModel = (FeaturedContainerEdgeModel) obj;
                if (featuredContainerEdgeModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(featuredContainerEdgeModel.m12803a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    featuredContainerEdgeModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                FeaturedContainerEdgeParser.m12866b(featuredContainerEdgeModel.w_(), featuredContainerEdgeModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(FeaturedContainerEdgeModel.class, new Serializer());
            }
        }

        @Nullable
        public final /* synthetic */ CollageLayoutFields m12805a() {
            return m12801j();
        }

        @Nullable
        public final /* synthetic */ FeaturedContainerModel m12806b() {
            return m12802k();
        }

        public FeaturedContainerEdgeModel() {
            super(2);
        }

        @Nullable
        private CollageLayoutFieldsModel m12801j() {
            this.f12843d = (CollageLayoutFieldsModel) super.a(this.f12843d, 0, CollageLayoutFieldsModel.class);
            return this.f12843d;
        }

        @Nullable
        private FeaturedContainerModel m12802k() {
            this.f12844e = (FeaturedContainerModel) super.a(this.f12844e, 1, FeaturedContainerModel.class);
            return this.f12844e;
        }

        public final int jK_() {
            return -805861200;
        }

        public final GraphQLVisitableModel m12804a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m12801j() != null) {
                CollageLayoutFieldsModel collageLayoutFieldsModel = (CollageLayoutFieldsModel) graphQLModelMutatingVisitor.b(m12801j());
                if (m12801j() != collageLayoutFieldsModel) {
                    graphQLVisitableModel = (FeaturedContainerEdgeModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f12843d = collageLayoutFieldsModel;
                }
            }
            if (m12802k() != null) {
                FeaturedContainerModel featuredContainerModel = (FeaturedContainerModel) graphQLModelMutatingVisitor.b(m12802k());
                if (m12802k() != featuredContainerModel) {
                    graphQLVisitableModel = (FeaturedContainerEdgeModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f12844e = featuredContainerModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m12803a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m12801j());
            int a2 = ModelHelper.a(flatBufferBuilder, m12802k());
            flatBufferBuilder.c(2);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, a2);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -33609394)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: extra_events_discovery_fragment_location_data */
    public final class FeaturedContainerModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableModel {
        @Nullable
        private ContainerCoverMediaModel f12857d;
        @Nullable
        private String f12858e;
        @Nullable
        private List<StoriesModel> f12859f;
        @Nullable
        private TitleModel f12860g;

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 1553492799)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: extra_events_discovery_fragment_location_data */
        public final class ContainerCoverMediaModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableModel, SizeAwareMedia {
            @Nullable
            private GraphQLObjectType f12845d;
            @Nullable
            private DefaultVect2FieldsModel f12846e;
            private int f12847f;
            @Nullable
            private String f12848g;
            @Nullable
            private DefaultImageFieldsModel f12849h;
            @Nullable
            private DefaultImageFieldsModel f12850i;
            @Nullable
            private DefaultImageFieldsModel f12851j;
            @Nullable
            private DefaultImageFieldsModel f12852k;
            @Nullable
            private String f12853l;
            private int f12854m;

            /* compiled from: extra_events_discovery_fragment_location_data */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(ContainerCoverMediaModel.class, new Deserializer());
                }

                public Object m12807a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(ContainerCoverMediaParser.m12867a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object containerCoverMediaModel = new ContainerCoverMediaModel();
                    ((BaseModel) containerCoverMediaModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (containerCoverMediaModel instanceof Postprocessable) {
                        return ((Postprocessable) containerCoverMediaModel).a();
                    }
                    return containerCoverMediaModel;
                }
            }

            /* compiled from: extra_events_discovery_fragment_location_data */
            public class Serializer extends JsonSerializer<ContainerCoverMediaModel> {
                public final void m12808a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    ContainerCoverMediaModel containerCoverMediaModel = (ContainerCoverMediaModel) obj;
                    if (containerCoverMediaModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(containerCoverMediaModel.m12814a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        containerCoverMediaModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    ContainerCoverMediaParser.m12868a(containerCoverMediaModel.w_(), containerCoverMediaModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(ContainerCoverMediaModel.class, new Serializer());
                }
            }

            @Nullable
            public final /* synthetic */ DefaultImageFields bc_() {
                return m12813q();
            }

            @Nullable
            public final /* synthetic */ DefaultImageFields bd_() {
                return m12812p();
            }

            @Nullable
            public final /* synthetic */ DefaultImageFields be_() {
                return m12810n();
            }

            @Nullable
            public final /* synthetic */ DefaultVect2Fields m12819c() {
                return m12809m();
            }

            @Nullable
            public final /* synthetic */ DefaultImageFields m12821g() {
                return m12811o();
            }

            public ContainerCoverMediaModel() {
                super(10);
            }

            @Nullable
            public final GraphQLObjectType m12818b() {
                if (this.b != null && this.f12845d == null) {
                    this.f12845d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
                }
                return this.f12845d;
            }

            @Nullable
            private DefaultVect2FieldsModel m12809m() {
                this.f12846e = (DefaultVect2FieldsModel) super.a(this.f12846e, 1, DefaultVect2FieldsModel.class);
                return this.f12846e;
            }

            public final int m12822j() {
                a(0, 2);
                return this.f12847f;
            }

            @Nullable
            public final String m12820d() {
                this.f12848g = super.a(this.f12848g, 3);
                return this.f12848g;
            }

            @Nullable
            private DefaultImageFieldsModel m12810n() {
                this.f12849h = (DefaultImageFieldsModel) super.a(this.f12849h, 4, DefaultImageFieldsModel.class);
                return this.f12849h;
            }

            @Nullable
            private DefaultImageFieldsModel m12811o() {
                this.f12850i = (DefaultImageFieldsModel) super.a(this.f12850i, 5, DefaultImageFieldsModel.class);
                return this.f12850i;
            }

            @Nullable
            private DefaultImageFieldsModel m12812p() {
                this.f12851j = (DefaultImageFieldsModel) super.a(this.f12851j, 6, DefaultImageFieldsModel.class);
                return this.f12851j;
            }

            @Nullable
            private DefaultImageFieldsModel m12813q() {
                this.f12852k = (DefaultImageFieldsModel) super.a(this.f12852k, 7, DefaultImageFieldsModel.class);
                return this.f12852k;
            }

            @Nullable
            public final String m12823k() {
                this.f12853l = super.a(this.f12853l, 8);
                return this.f12853l;
            }

            public final int m12824l() {
                a(1, 1);
                return this.f12854m;
            }

            @Nullable
            public final String m12816a() {
                return m12820d();
            }

            public final int jK_() {
                return 74219460;
            }

            public final GraphQLVisitableModel m12815a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                DefaultImageFieldsModel defaultImageFieldsModel;
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m12809m() != null) {
                    DefaultVect2FieldsModel defaultVect2FieldsModel = (DefaultVect2FieldsModel) graphQLModelMutatingVisitor.b(m12809m());
                    if (m12809m() != defaultVect2FieldsModel) {
                        graphQLVisitableModel = (ContainerCoverMediaModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f12846e = defaultVect2FieldsModel;
                    }
                }
                if (m12810n() != null) {
                    defaultImageFieldsModel = (DefaultImageFieldsModel) graphQLModelMutatingVisitor.b(m12810n());
                    if (m12810n() != defaultImageFieldsModel) {
                        graphQLVisitableModel = (ContainerCoverMediaModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f12849h = defaultImageFieldsModel;
                    }
                }
                if (m12811o() != null) {
                    defaultImageFieldsModel = (DefaultImageFieldsModel) graphQLModelMutatingVisitor.b(m12811o());
                    if (m12811o() != defaultImageFieldsModel) {
                        graphQLVisitableModel = (ContainerCoverMediaModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f12850i = defaultImageFieldsModel;
                    }
                }
                if (m12812p() != null) {
                    defaultImageFieldsModel = (DefaultImageFieldsModel) graphQLModelMutatingVisitor.b(m12812p());
                    if (m12812p() != defaultImageFieldsModel) {
                        graphQLVisitableModel = (ContainerCoverMediaModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f12851j = defaultImageFieldsModel;
                    }
                }
                if (m12813q() != null) {
                    defaultImageFieldsModel = (DefaultImageFieldsModel) graphQLModelMutatingVisitor.b(m12813q());
                    if (m12813q() != defaultImageFieldsModel) {
                        graphQLVisitableModel = (ContainerCoverMediaModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f12852k = defaultImageFieldsModel;
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m12814a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m12818b());
                int a2 = ModelHelper.a(flatBufferBuilder, m12809m());
                int b = flatBufferBuilder.b(m12820d());
                int a3 = ModelHelper.a(flatBufferBuilder, m12810n());
                int a4 = ModelHelper.a(flatBufferBuilder, m12811o());
                int a5 = ModelHelper.a(flatBufferBuilder, m12812p());
                int a6 = ModelHelper.a(flatBufferBuilder, m12813q());
                int b2 = flatBufferBuilder.b(m12823k());
                flatBufferBuilder.c(10);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.b(1, a2);
                flatBufferBuilder.a(2, this.f12847f, 0);
                flatBufferBuilder.b(3, b);
                flatBufferBuilder.b(4, a3);
                flatBufferBuilder.b(5, a4);
                flatBufferBuilder.b(6, a5);
                flatBufferBuilder.b(7, a6);
                flatBufferBuilder.b(8, b2);
                flatBufferBuilder.a(9, this.f12854m, 0);
                i();
                return flatBufferBuilder.d();
            }

            public final void m12817a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                super.a(mutableFlatBuffer, i, obj);
                this.f12847f = mutableFlatBuffer.a(i, 2, 0);
                this.f12854m = mutableFlatBuffer.a(i, 9, 0);
            }
        }

        /* compiled from: extra_events_discovery_fragment_location_data */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(FeaturedContainerModel.class, new Deserializer());
            }

            public Object m12825a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(FeaturedContainerParser.m12873a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object featuredContainerModel = new FeaturedContainerModel();
                ((BaseModel) featuredContainerModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (featuredContainerModel instanceof Postprocessable) {
                    return ((Postprocessable) featuredContainerModel).a();
                }
                return featuredContainerModel;
            }
        }

        /* compiled from: extra_events_discovery_fragment_location_data */
        public class Serializer extends JsonSerializer<FeaturedContainerModel> {
            public final void m12826a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                FeaturedContainerModel featuredContainerModel = (FeaturedContainerModel) obj;
                if (featuredContainerModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(featuredContainerModel.m12843a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    featuredContainerModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                FeaturedContainerParser.m12874a(featuredContainerModel.w_(), featuredContainerModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(FeaturedContainerModel.class, new Serializer());
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 1801334754)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: extra_events_discovery_fragment_location_data */
        public final class StoriesModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
            @Nullable
            private String f12855d;

            /* compiled from: extra_events_discovery_fragment_location_data */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(StoriesModel.class, new Deserializer());
                }

                public Object m12827a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(StoriesParser.m12870b(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object storiesModel = new StoriesModel();
                    ((BaseModel) storiesModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (storiesModel instanceof Postprocessable) {
                        return ((Postprocessable) storiesModel).a();
                    }
                    return storiesModel;
                }
            }

            /* compiled from: extra_events_discovery_fragment_location_data */
            public class Serializer extends JsonSerializer<StoriesModel> {
                public final void m12828a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    StoriesModel storiesModel = (StoriesModel) obj;
                    if (storiesModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(storiesModel.m12829a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        storiesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    StoriesParser.m12869a(storiesModel.w_(), storiesModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(StoriesModel.class, new Serializer());
                }
            }

            public StoriesModel() {
                super(1);
            }

            public final void m12832a(String str, ConsistencyTuple consistencyTuple) {
                consistencyTuple.a();
            }

            public final void m12833a(String str, Object obj, boolean z) {
            }

            @Nullable
            public final String m12834b() {
                this.f12855d = super.a(this.f12855d, 0);
                return this.f12855d;
            }

            @Nullable
            public final String m12831a() {
                return m12834b();
            }

            public final int jK_() {
                return 80218325;
            }

            public final GraphQLVisitableModel m12830a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m12829a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m12834b());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, b);
                i();
                return flatBufferBuilder.d();
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -1352864475)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: extra_events_discovery_fragment_location_data */
        public final class TitleModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private String f12856d;

            /* compiled from: extra_events_discovery_fragment_location_data */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(TitleModel.class, new Deserializer());
                }

                public Object m12835a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(TitleParser.m12871a(jsonParser, flatBufferBuilder));
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

            /* compiled from: extra_events_discovery_fragment_location_data */
            public class Serializer extends JsonSerializer<TitleModel> {
                public final void m12836a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    TitleModel titleModel = (TitleModel) obj;
                    if (titleModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(titleModel.m12838a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        titleModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    TitleParser.m12872a(titleModel.w_(), titleModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(TitleModel.class, new Serializer());
                }
            }

            public TitleModel() {
                super(1);
            }

            @Nullable
            private String m12837a() {
                this.f12856d = super.a(this.f12856d, 0);
                return this.f12856d;
            }

            public final int jK_() {
                return -1919764332;
            }

            public final GraphQLVisitableModel m12839a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m12838a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m12837a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, b);
                i();
                return flatBufferBuilder.d();
            }
        }

        @Nullable
        public final /* synthetic */ ContainerCoverMediaModel m12846b() {
            return m12840j();
        }

        public FeaturedContainerModel() {
            super(4);
        }

        @Nullable
        private ContainerCoverMediaModel m12840j() {
            this.f12857d = (ContainerCoverMediaModel) super.a(this.f12857d, 0, ContainerCoverMediaModel.class);
            return this.f12857d;
        }

        @Nullable
        private String m12841k() {
            this.f12858e = super.a(this.f12858e, 1);
            return this.f12858e;
        }

        @Nonnull
        public final ImmutableList<StoriesModel> m12847c() {
            this.f12859f = super.a(this.f12859f, 2, StoriesModel.class);
            return (ImmutableList) this.f12859f;
        }

        @Nullable
        private TitleModel m12842l() {
            this.f12860g = (TitleModel) super.a(this.f12860g, 3, TitleModel.class);
            return this.f12860g;
        }

        @Nullable
        public final String m12845a() {
            return m12841k();
        }

        public final int jK_() {
            return 835091488;
        }

        public final GraphQLVisitableModel m12844a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m12840j() != null) {
                ContainerCoverMediaModel containerCoverMediaModel = (ContainerCoverMediaModel) graphQLModelMutatingVisitor.b(m12840j());
                if (m12840j() != containerCoverMediaModel) {
                    graphQLVisitableModel = (FeaturedContainerModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f12857d = containerCoverMediaModel;
                }
            }
            if (m12847c() != null) {
                Builder a = ModelHelper.a(m12847c(), graphQLModelMutatingVisitor);
                if (a != null) {
                    FeaturedContainerModel featuredContainerModel = (FeaturedContainerModel) ModelHelper.a(graphQLVisitableModel, this);
                    featuredContainerModel.f12859f = a.b();
                    graphQLVisitableModel = featuredContainerModel;
                }
            }
            if (m12842l() != null) {
                TitleModel titleModel = (TitleModel) graphQLModelMutatingVisitor.b(m12842l());
                if (m12842l() != titleModel) {
                    graphQLVisitableModel = (FeaturedContainerModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f12860g = titleModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m12843a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m12840j());
            int b = flatBufferBuilder.b(m12841k());
            int a2 = ModelHelper.a(flatBufferBuilder, m12847c());
            int a3 = ModelHelper.a(flatBufferBuilder, m12842l());
            flatBufferBuilder.c(4);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, b);
            flatBufferBuilder.b(2, a2);
            flatBufferBuilder.b(3, a3);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 1130070131)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: extra_events_discovery_fragment_location_data */
    public final class FeaturedContainersQueryModel extends BaseModel implements GraphQLVisitableConsistentModel {
        @Nullable
        private ProfileIntroCardModel f12863d;

        /* compiled from: extra_events_discovery_fragment_location_data */
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
                r0 = com.facebook.timeline.viewfeaturedcontainers.protocol.FeaturedContainersGraphQLModels.FeaturedContainersQueryModel.class;
                r1 = new com.facebook.timeline.viewfeaturedcontainers.protocol.FeaturedContainersGraphQLModels$FeaturedContainersQueryModel$Deserializer;
                r1.<init>();
                com.facebook.common.json.GlobalAutoGenDeserializerCache.a(r0, r1);
                return;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.timeline.viewfeaturedcontainers.protocol.FeaturedContainersGraphQLModels.FeaturedContainersQueryModel.Deserializer.<clinit>():void");
            }

            public java.lang.Object m12848a(com.fasterxml.jackson.core.JsonParser r6, com.fasterxml.jackson.databind.DeserializationContext r7) {
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
                r2 = com.facebook.timeline.viewfeaturedcontainers.protocol.FeaturedContainersGraphQLParsers.FeaturedContainersQueryParser.m12879a(r6);
                r1 = new com.facebook.timeline.viewfeaturedcontainers.protocol.FeaturedContainersGraphQLModels$FeaturedContainersQueryModel;
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
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.timeline.viewfeaturedcontainers.protocol.FeaturedContainersGraphQLModels.FeaturedContainersQueryModel.Deserializer.a(com.fasterxml.jackson.core.JsonParser, com.fasterxml.jackson.databind.DeserializationContext):java.lang.Object");
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 1791457081)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: extra_events_discovery_fragment_location_data */
        public final class ProfileIntroCardModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private FeaturedContainersModel f12862d;

            /* compiled from: extra_events_discovery_fragment_location_data */
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
                    r0 = com.facebook.timeline.viewfeaturedcontainers.protocol.FeaturedContainersGraphQLModels.FeaturedContainersQueryModel.ProfileIntroCardModel.class;
                    r1 = new com.facebook.timeline.viewfeaturedcontainers.protocol.FeaturedContainersGraphQLModels$FeaturedContainersQueryModel$ProfileIntroCardModel$Deserializer;
                    r1.<init>();
                    com.facebook.common.json.GlobalAutoGenDeserializerCache.a(r0, r1);
                    return;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.timeline.viewfeaturedcontainers.protocol.FeaturedContainersGraphQLModels.FeaturedContainersQueryModel.ProfileIntroCardModel.Deserializer.<clinit>():void");
                }

                public java.lang.Object m12849a(com.fasterxml.jackson.core.JsonParser r11, com.fasterxml.jackson.databind.DeserializationContext r12) {
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
                    r5 = com.facebook.timeline.viewfeaturedcontainers.protocol.FeaturedContainersGraphQLParsers.FeaturedContainersQueryParser.ProfileIntroCardParser.m12877a(r11, r4);
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
                    r1 = new com.facebook.timeline.viewfeaturedcontainers.protocol.FeaturedContainersGraphQLModels$FeaturedContainersQueryModel$ProfileIntroCardModel;
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
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.timeline.viewfeaturedcontainers.protocol.FeaturedContainersGraphQLModels.FeaturedContainersQueryModel.ProfileIntroCardModel.Deserializer.a(com.fasterxml.jackson.core.JsonParser, com.fasterxml.jackson.databind.DeserializationContext):java.lang.Object");
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = -636179041)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: extra_events_discovery_fragment_location_data */
            public final class FeaturedContainersModel extends BaseModel implements GraphQLVisitableModel {
                @Nullable
                private List<FeaturedContainerEdgeModel> f12861d;

                /* compiled from: extra_events_discovery_fragment_location_data */
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
                        r0 = com.facebook.timeline.viewfeaturedcontainers.protocol.FeaturedContainersGraphQLModels.FeaturedContainersQueryModel.ProfileIntroCardModel.FeaturedContainersModel.class;
                        r1 = new com.facebook.timeline.viewfeaturedcontainers.protocol.FeaturedContainersGraphQLModels$FeaturedContainersQueryModel$ProfileIntroCardModel$FeaturedContainersModel$Deserializer;
                        r1.<init>();
                        com.facebook.common.json.GlobalAutoGenDeserializerCache.a(r0, r1);
                        return;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.timeline.viewfeaturedcontainers.protocol.FeaturedContainersGraphQLModels.FeaturedContainersQueryModel.ProfileIntroCardModel.FeaturedContainersModel.Deserializer.<clinit>():void");
                    }

                    public java.lang.Object m12850a(com.fasterxml.jackson.core.JsonParser r11, com.fasterxml.jackson.databind.DeserializationContext r12) {
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
                        r5 = com.facebook.timeline.viewfeaturedcontainers.protocol.FeaturedContainersGraphQLParsers.FeaturedContainersQueryParser.ProfileIntroCardParser.FeaturedContainersParser.m12875a(r11, r4);
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
                        r1 = new com.facebook.timeline.viewfeaturedcontainers.protocol.FeaturedContainersGraphQLModels$FeaturedContainersQueryModel$ProfileIntroCardModel$FeaturedContainersModel;
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
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.timeline.viewfeaturedcontainers.protocol.FeaturedContainersGraphQLModels.FeaturedContainersQueryModel.ProfileIntroCardModel.FeaturedContainersModel.Deserializer.a(com.fasterxml.jackson.core.JsonParser, com.fasterxml.jackson.databind.DeserializationContext):java.lang.Object");
                    }
                }

                /* compiled from: extra_events_discovery_fragment_location_data */
                public class Serializer extends JsonSerializer<FeaturedContainersModel> {
                    public final void m12851a(java.lang.Object r8, com.fasterxml.jackson.core.JsonGenerator r9, com.fasterxml.jackson.databind.SerializerProvider r10) {
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
                        r8 = (com.facebook.timeline.viewfeaturedcontainers.protocol.FeaturedContainersGraphQLModels.FeaturedContainersQueryModel.ProfileIntroCardModel.FeaturedContainersModel) r8;
                        r2 = 0;
                        r0 = r8.w_();
                        if (r0 != 0) goto L_0x0035;
                    L_0x0009:
                        r0 = new com.facebook.flatbuffers.FlatBufferBuilder;
                        r1 = 128; // 0x80 float:1.794E-43 double:6.32E-322;
                        r0.<init>(r1);
                        r1 = r8.m12852a(r0);
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
                        com.facebook.timeline.viewfeaturedcontainers.protocol.FeaturedContainersGraphQLParsers.FeaturedContainersQueryParser.ProfileIntroCardParser.FeaturedContainersParser.m12876a(r0, r1, r9, r10);
                        return;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.timeline.viewfeaturedcontainers.protocol.FeaturedContainersGraphQLModels.FeaturedContainersQueryModel.ProfileIntroCardModel.FeaturedContainersModel.Serializer.a(java.lang.Object, com.fasterxml.jackson.core.JsonGenerator, com.fasterxml.jackson.databind.SerializerProvider):void");
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
                        r0 = com.facebook.timeline.viewfeaturedcontainers.protocol.FeaturedContainersGraphQLModels.FeaturedContainersQueryModel.ProfileIntroCardModel.FeaturedContainersModel.class;
                        r1 = new com.facebook.timeline.viewfeaturedcontainers.protocol.FeaturedContainersGraphQLModels$FeaturedContainersQueryModel$ProfileIntroCardModel$FeaturedContainersModel$Serializer;
                        r1.<init>();
                        com.facebook.common.json.FbSerializerProvider.a(r0, r1);
                        return;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.timeline.viewfeaturedcontainers.protocol.FeaturedContainersGraphQLModels.FeaturedContainersQueryModel.ProfileIntroCardModel.FeaturedContainersModel.Serializer.<clinit>():void");
                    }
                }

                public FeaturedContainersModel() {
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
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.timeline.viewfeaturedcontainers.protocol.FeaturedContainersGraphQLModels.FeaturedContainersQueryModel.ProfileIntroCardModel.FeaturedContainersModel.<init>():void");
                }

                @javax.annotation.Nonnull
                public final com.google.common.collect.ImmutableList<com.facebook.timeline.viewfeaturedcontainers.protocol.FeaturedContainersGraphQLModels.FeaturedContainerEdgeModel> m12854a() {
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
                    r3 = this;
                    r0 = r3.f12861d;
                    r1 = 0;
                    r2 = com.facebook.timeline.viewfeaturedcontainers.protocol.FeaturedContainersGraphQLModels.FeaturedContainerEdgeModel.class;
                    r0 = super.a(r0, r1, r2);
                    r3.f12861d = r0;
                    r0 = r3.f12861d;
                    r0 = (com.google.common.collect.ImmutableList) r0;
                    return r0;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.timeline.viewfeaturedcontainers.protocol.FeaturedContainersGraphQLModels.FeaturedContainersQueryModel.ProfileIntroCardModel.FeaturedContainersModel.a():com.google.common.collect.ImmutableList<com.facebook.timeline.viewfeaturedcontainers.protocol.FeaturedContainersGraphQLModels$FeaturedContainerEdgeModel>");
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
                    r0 = 1142642577; // 0x441b5791 float:621.3682 double:5.64540443E-315;
                    return r0;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.timeline.viewfeaturedcontainers.protocol.FeaturedContainersGraphQLModels.FeaturedContainersQueryModel.ProfileIntroCardModel.FeaturedContainersModel.jK_():int");
                }

                public final com.facebook.graphql.visitor.GraphQLVisitableModel m12853a(com.facebook.graphql.visitor.GraphQLModelMutatingVisitor r3) {
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
                    r0 = 0;
                    r2.h();
                    r1 = r2.m12854a();
                    if (r1 == 0) goto L_0x0020;
                L_0x000a:
                    r1 = r2.m12854a();
                    r1 = com.facebook.graphql.modelutil.ModelHelper.a(r1, r3);
                    if (r1 == 0) goto L_0x0020;
                L_0x0014:
                    r0 = com.facebook.graphql.modelutil.ModelHelper.a(r0, r2);
                    r0 = (com.facebook.timeline.viewfeaturedcontainers.protocol.FeaturedContainersGraphQLModels.FeaturedContainersQueryModel.ProfileIntroCardModel.FeaturedContainersModel) r0;
                    r1 = r1.b();
                    r0.f12861d = r1;
                L_0x0020:
                    r2.i();
                    if (r0 != 0) goto L_0x0026;
                L_0x0025:
                    return r2;
                L_0x0026:
                    r2 = r0;
                    goto L_0x0025;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.timeline.viewfeaturedcontainers.protocol.FeaturedContainersGraphQLModels.FeaturedContainersQueryModel.ProfileIntroCardModel.FeaturedContainersModel.a(com.facebook.graphql.visitor.GraphQLModelMutatingVisitor):com.facebook.graphql.visitor.GraphQLVisitableModel");
                }

                public final int m12852a(com.facebook.flatbuffers.FlatBufferBuilder r3) {
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
                    r0 = r2.m12854a();
                    r0 = com.facebook.graphql.modelutil.ModelHelper.a(r3, r0);
                    r1 = 1;
                    r3.c(r1);
                    r1 = 0;
                    r3.b(r1, r0);
                    r2.i();
                    r0 = r3.d();
                    return r0;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.timeline.viewfeaturedcontainers.protocol.FeaturedContainersGraphQLModels.FeaturedContainersQueryModel.ProfileIntroCardModel.FeaturedContainersModel.a(com.facebook.flatbuffers.FlatBufferBuilder):int");
                }
            }

            /* compiled from: extra_events_discovery_fragment_location_data */
            public class Serializer extends JsonSerializer<ProfileIntroCardModel> {
                public final void m12855a(java.lang.Object r8, com.fasterxml.jackson.core.JsonGenerator r9, com.fasterxml.jackson.databind.SerializerProvider r10) {
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
                    r8 = (com.facebook.timeline.viewfeaturedcontainers.protocol.FeaturedContainersGraphQLModels.FeaturedContainersQueryModel.ProfileIntroCardModel) r8;
                    r2 = 0;
                    r0 = r8.w_();
                    if (r0 != 0) goto L_0x0035;
                L_0x0009:
                    r0 = new com.facebook.flatbuffers.FlatBufferBuilder;
                    r1 = 128; // 0x80 float:1.794E-43 double:6.32E-322;
                    r0.<init>(r1);
                    r1 = r8.m12856a(r0);
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
                    com.facebook.timeline.viewfeaturedcontainers.protocol.FeaturedContainersGraphQLParsers.FeaturedContainersQueryParser.ProfileIntroCardParser.m12878a(r0, r1, r9, r10);
                    return;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.timeline.viewfeaturedcontainers.protocol.FeaturedContainersGraphQLModels.FeaturedContainersQueryModel.ProfileIntroCardModel.Serializer.a(java.lang.Object, com.fasterxml.jackson.core.JsonGenerator, com.fasterxml.jackson.databind.SerializerProvider):void");
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
                    r0 = com.facebook.timeline.viewfeaturedcontainers.protocol.FeaturedContainersGraphQLModels.FeaturedContainersQueryModel.ProfileIntroCardModel.class;
                    r1 = new com.facebook.timeline.viewfeaturedcontainers.protocol.FeaturedContainersGraphQLModels$FeaturedContainersQueryModel$ProfileIntroCardModel$Serializer;
                    r1.<init>();
                    com.facebook.common.json.FbSerializerProvider.a(r0, r1);
                    return;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.timeline.viewfeaturedcontainers.protocol.FeaturedContainersGraphQLModels.FeaturedContainersQueryModel.ProfileIntroCardModel.Serializer.<clinit>():void");
                }
            }

            public ProfileIntroCardModel() {
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
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.timeline.viewfeaturedcontainers.protocol.FeaturedContainersGraphQLModels.FeaturedContainersQueryModel.ProfileIntroCardModel.<init>():void");
            }

            @javax.annotation.Nullable
            public final com.facebook.timeline.viewfeaturedcontainers.protocol.FeaturedContainersGraphQLModels.FeaturedContainersQueryModel.ProfileIntroCardModel.FeaturedContainersModel m12858a() {
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
                r0 = r3.f12862d;
                r1 = 0;
                r2 = com.facebook.timeline.viewfeaturedcontainers.protocol.FeaturedContainersGraphQLModels.FeaturedContainersQueryModel.ProfileIntroCardModel.FeaturedContainersModel.class;
                r0 = super.a(r0, r1, r2);
                r0 = (com.facebook.timeline.viewfeaturedcontainers.protocol.FeaturedContainersGraphQLModels.FeaturedContainersQueryModel.ProfileIntroCardModel.FeaturedContainersModel) r0;
                r3.f12862d = r0;
                r0 = r3.f12862d;
                return r0;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.timeline.viewfeaturedcontainers.protocol.FeaturedContainersGraphQLModels.FeaturedContainersQueryModel.ProfileIntroCardModel.a():com.facebook.timeline.viewfeaturedcontainers.protocol.FeaturedContainersGraphQLModels$FeaturedContainersQueryModel$ProfileIntroCardModel$FeaturedContainersModel");
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
                r0 = 2102913043; // 0x7d57e813 float:1.7936814E37 double:1.0389770907E-314;
                return r0;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.timeline.viewfeaturedcontainers.protocol.FeaturedContainersGraphQLModels.FeaturedContainersQueryModel.ProfileIntroCardModel.jK_():int");
            }

            public final com.facebook.graphql.visitor.GraphQLVisitableModel m12857a(com.facebook.graphql.visitor.GraphQLModelMutatingVisitor r4) {
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
                r0 = r3.m12858a();
                if (r0 == 0) goto L_0x0022;
            L_0x000a:
                r0 = r3.m12858a();
                r0 = r4.b(r0);
                r0 = (com.facebook.timeline.viewfeaturedcontainers.protocol.FeaturedContainersGraphQLModels.FeaturedContainersQueryModel.ProfileIntroCardModel.FeaturedContainersModel) r0;
                r2 = r3.m12858a();
                if (r2 == r0) goto L_0x0022;
            L_0x001a:
                r1 = com.facebook.graphql.modelutil.ModelHelper.a(r1, r3);
                r1 = (com.facebook.timeline.viewfeaturedcontainers.protocol.FeaturedContainersGraphQLModels.FeaturedContainersQueryModel.ProfileIntroCardModel) r1;
                r1.f12862d = r0;
            L_0x0022:
                r3.i();
                if (r1 != 0) goto L_0x0028;
            L_0x0027:
                return r3;
            L_0x0028:
                r3 = r1;
                goto L_0x0027;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.timeline.viewfeaturedcontainers.protocol.FeaturedContainersGraphQLModels.FeaturedContainersQueryModel.ProfileIntroCardModel.a(com.facebook.graphql.visitor.GraphQLModelMutatingVisitor):com.facebook.graphql.visitor.GraphQLVisitableModel");
            }

            public final int m12856a(com.facebook.flatbuffers.FlatBufferBuilder r3) {
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
                r0 = r2.m12858a();
                r0 = com.facebook.graphql.modelutil.ModelHelper.a(r3, r0);
                r1 = 1;
                r3.c(r1);
                r1 = 0;
                r3.b(r1, r0);
                r2.i();
                r0 = r3.d();
                return r0;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.timeline.viewfeaturedcontainers.protocol.FeaturedContainersGraphQLModels.FeaturedContainersQueryModel.ProfileIntroCardModel.a(com.facebook.flatbuffers.FlatBufferBuilder):int");
            }
        }

        /* compiled from: extra_events_discovery_fragment_location_data */
        public class Serializer extends JsonSerializer<FeaturedContainersQueryModel> {
            public final void m12859a(java.lang.Object r9, com.fasterxml.jackson.core.JsonGenerator r10, com.fasterxml.jackson.databind.SerializerProvider r11) {
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
                r9 = (com.facebook.timeline.viewfeaturedcontainers.protocol.FeaturedContainersGraphQLModels.FeaturedContainersQueryModel) r9;
                r2 = 0;
                r0 = r9.w_();
                if (r0 != 0) goto L_0x0035;
            L_0x0009:
                r0 = new com.facebook.flatbuffers.FlatBufferBuilder;
                r1 = 128; // 0x80 float:1.794E-43 double:6.32E-322;
                r0.<init>(r1);
                r1 = r9.m12860a(r0);
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
                r7 = "profile_intro_card";
                r10.a(r7);
                com.facebook.timeline.viewfeaturedcontainers.protocol.FeaturedContainersGraphQLParsers.FeaturedContainersQueryParser.ProfileIntroCardParser.m12878a(r0, r6, r10, r11);
            L_0x004f:
                r10.g();
                return;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.timeline.viewfeaturedcontainers.protocol.FeaturedContainersGraphQLModels.FeaturedContainersQueryModel.Serializer.a(java.lang.Object, com.fasterxml.jackson.core.JsonGenerator, com.fasterxml.jackson.databind.SerializerProvider):void");
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
                r0 = com.facebook.timeline.viewfeaturedcontainers.protocol.FeaturedContainersGraphQLModels.FeaturedContainersQueryModel.class;
                r1 = new com.facebook.timeline.viewfeaturedcontainers.protocol.FeaturedContainersGraphQLModels$FeaturedContainersQueryModel$Serializer;
                r1.<init>();
                com.facebook.common.json.FbSerializerProvider.a(r0, r1);
                return;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.timeline.viewfeaturedcontainers.protocol.FeaturedContainersGraphQLModels.FeaturedContainersQueryModel.Serializer.<clinit>():void");
            }
        }

        public FeaturedContainersQueryModel() {
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
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.timeline.viewfeaturedcontainers.protocol.FeaturedContainersGraphQLModels.FeaturedContainersQueryModel.<init>():void");
        }

        public final void m12863a(java.lang.String r1, com.facebook.graphql.visitor.ConsistencyTuple r2) {
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
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.timeline.viewfeaturedcontainers.protocol.FeaturedContainersGraphQLModels.FeaturedContainersQueryModel.a(java.lang.String, com.facebook.graphql.visitor.ConsistencyTuple):void");
        }

        public final void m12864a(java.lang.String r1, java.lang.Object r2, boolean r3) {
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
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.timeline.viewfeaturedcontainers.protocol.FeaturedContainersGraphQLModels.FeaturedContainersQueryModel.a(java.lang.String, java.lang.Object, boolean):void");
        }

        @javax.annotation.Nullable
        public final com.facebook.timeline.viewfeaturedcontainers.protocol.FeaturedContainersGraphQLModels.FeaturedContainersQueryModel.ProfileIntroCardModel m12862a() {
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
            r0 = r3.f12863d;
            r1 = 0;
            r2 = com.facebook.timeline.viewfeaturedcontainers.protocol.FeaturedContainersGraphQLModels.FeaturedContainersQueryModel.ProfileIntroCardModel.class;
            r0 = super.a(r0, r1, r2);
            r0 = (com.facebook.timeline.viewfeaturedcontainers.protocol.FeaturedContainersGraphQLModels.FeaturedContainersQueryModel.ProfileIntroCardModel) r0;
            r3.f12863d = r0;
            r0 = r3.f12863d;
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.timeline.viewfeaturedcontainers.protocol.FeaturedContainersGraphQLModels.FeaturedContainersQueryModel.a():com.facebook.timeline.viewfeaturedcontainers.protocol.FeaturedContainersGraphQLModels$FeaturedContainersQueryModel$ProfileIntroCardModel");
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
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.timeline.viewfeaturedcontainers.protocol.FeaturedContainersGraphQLModels.FeaturedContainersQueryModel.jK_():int");
        }

        public final com.facebook.graphql.visitor.GraphQLVisitableModel m12861a(com.facebook.graphql.visitor.GraphQLModelMutatingVisitor r4) {
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
            r0 = r3.m12862a();
            if (r0 == 0) goto L_0x0022;
        L_0x000a:
            r0 = r3.m12862a();
            r0 = r4.b(r0);
            r0 = (com.facebook.timeline.viewfeaturedcontainers.protocol.FeaturedContainersGraphQLModels.FeaturedContainersQueryModel.ProfileIntroCardModel) r0;
            r2 = r3.m12862a();
            if (r2 == r0) goto L_0x0022;
        L_0x001a:
            r1 = com.facebook.graphql.modelutil.ModelHelper.a(r1, r3);
            r1 = (com.facebook.timeline.viewfeaturedcontainers.protocol.FeaturedContainersGraphQLModels.FeaturedContainersQueryModel) r1;
            r1.f12863d = r0;
        L_0x0022:
            r3.i();
            if (r1 != 0) goto L_0x0028;
        L_0x0027:
            return r3;
        L_0x0028:
            r3 = r1;
            goto L_0x0027;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.timeline.viewfeaturedcontainers.protocol.FeaturedContainersGraphQLModels.FeaturedContainersQueryModel.a(com.facebook.graphql.visitor.GraphQLModelMutatingVisitor):com.facebook.graphql.visitor.GraphQLVisitableModel");
        }

        public final int m12860a(com.facebook.flatbuffers.FlatBufferBuilder r3) {
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
            r0 = r2.m12862a();
            r0 = com.facebook.graphql.modelutil.ModelHelper.a(r3, r0);
            r1 = 1;
            r3.c(r1);
            r1 = 0;
            r3.b(r1, r0);
            r2.i();
            r0 = r3.d();
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.timeline.viewfeaturedcontainers.protocol.FeaturedContainersGraphQLModels.FeaturedContainersQueryModel.a(com.facebook.flatbuffers.FlatBufferBuilder):int");
        }
    }
}
