package com.facebook.api.graphql.textwithentities;

import com.facebook.api.graphql.textwithentities.NewsFeedApplicationGraphQLParsers.AppSocialContextTextWithEntitiesEntityRangeFieldsParser;
import com.facebook.api.graphql.textwithentities.NewsFeedApplicationGraphQLParsers.AppSocialContextTextWithEntitiesEntityRangeFieldsParser.EntityParser;
import com.facebook.api.graphql.textwithentities.NewsFeedApplicationGraphQLParsers.AppSocialContextTextWithEntitiesWithRangesParser;
import com.facebook.api.graphql.textwithentities.NewsFeedApplicationGraphQLParsers.AppStoreApplicationFragmentParser;
import com.facebook.api.graphql.textwithentities.NewsFeedApplicationGraphQLParsers.AppStorePlatformApplicationFieldsParser;
import com.facebook.api.graphql.textwithentities.NewsFeedApplicationGraphQLParsers.InnerApplicationFieldsParser;
import com.facebook.api.graphql.textwithentities.NewsFeedApplicationGraphQLParsers.InnerApplicationFieldsParser.AndroidAppConfigParser;
import com.facebook.api.graphql.textwithentities.NewsFeedTextWithEntitiesGraphQLModels.DefaultTextWithEntitiesWithRangesFieldsModel;
import com.facebook.api.graphql.textwithentities.NewsFeedTextWithEntitiesGraphQLModels.TextWithEntitiesAggregatedRangeFieldsModel;
import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbSerializerProvider;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.FragmentModelWithoutBridge;
import com.facebook.flatbuffers.ModelWithFlatBufferFormatHash;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.enums.GraphQLAppStoreApplicationInstallState;
import com.facebook.graphql.enums.GraphQLAppStoreDownloadConnectivityPolicy;
import com.facebook.graphql.enums.GraphQLDigitalGoodStoreType;
import com.facebook.graphql.enums.GraphQLObjectType;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.ModelHelper;
import com.facebook.graphql.querybuilder.common.CommonGraphQLModels.DefaultImageFieldsModel;
import com.facebook.graphql.querybuilder.common.CommonGraphQLModels.DefaultImageUriFieldsModel;
import com.facebook.graphql.querybuilder.common.TextWithEntitiesGraphQLModels.DefaultTextWithEntitiesFieldsModel;
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
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import java.nio.ByteBuffer;
import java.util.List;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/* compiled from: takeOrQueuePictureTaking denied by CameraHolder */
public class NewsFeedApplicationGraphQLModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 1581768160)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: takeOrQueuePictureTaking denied by CameraHolder */
    public final class AppSocialContextTextWithEntitiesEntityRangeFieldsModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private EntityModel f2175d;
        private int f2176e;
        private int f2177f;

        /* compiled from: takeOrQueuePictureTaking denied by CameraHolder */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(AppSocialContextTextWithEntitiesEntityRangeFieldsModel.class, new Deserializer());
            }

            public Object m2988a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(AppSocialContextTextWithEntitiesEntityRangeFieldsParser.m3071b(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object appSocialContextTextWithEntitiesEntityRangeFieldsModel = new AppSocialContextTextWithEntitiesEntityRangeFieldsModel();
                ((BaseModel) appSocialContextTextWithEntitiesEntityRangeFieldsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (appSocialContextTextWithEntitiesEntityRangeFieldsModel instanceof Postprocessable) {
                    return ((Postprocessable) appSocialContextTextWithEntitiesEntityRangeFieldsModel).a();
                }
                return appSocialContextTextWithEntitiesEntityRangeFieldsModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 702630869)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: takeOrQueuePictureTaking denied by CameraHolder */
        public final class EntityModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableModel {
            @Nullable
            private GraphQLObjectType f2170d;
            @Nullable
            private String f2171e;
            @Nullable
            private String f2172f;
            @Nullable
            private DefaultImageFieldsModel f2173g;
            @Nullable
            private String f2174h;

            /* compiled from: takeOrQueuePictureTaking denied by CameraHolder */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(EntityModel.class, new Deserializer());
                }

                public Object m2989a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(EntityParser.m3069a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object entityModel = new EntityModel();
                    ((BaseModel) entityModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (entityModel instanceof Postprocessable) {
                        return ((Postprocessable) entityModel).a();
                    }
                    return entityModel;
                }
            }

            /* compiled from: takeOrQueuePictureTaking denied by CameraHolder */
            public class Serializer extends JsonSerializer<EntityModel> {
                public final void m2990a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    EntityModel entityModel = (EntityModel) obj;
                    if (entityModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(entityModel.m2996a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        entityModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    EntityParser.m3070a(entityModel.w_(), entityModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(EntityModel.class, new Serializer());
                }
            }

            public EntityModel() {
                super(5);
            }

            @Nullable
            private GraphQLObjectType m2991j() {
                if (this.b != null && this.f2170d == null) {
                    this.f2170d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
                }
                return this.f2170d;
            }

            @Nullable
            private String m2992k() {
                this.f2171e = super.a(this.f2171e, 1);
                return this.f2171e;
            }

            @Nullable
            private String m2993l() {
                this.f2172f = super.a(this.f2172f, 2);
                return this.f2172f;
            }

            @Nullable
            private DefaultImageFieldsModel m2994m() {
                this.f2173g = (DefaultImageFieldsModel) super.a(this.f2173g, 3, DefaultImageFieldsModel.class);
                return this.f2173g;
            }

            @Nullable
            private String m2995n() {
                this.f2174h = super.a(this.f2174h, 4);
                return this.f2174h;
            }

            @Nullable
            public final String m2998a() {
                return m2992k();
            }

            public final int jK_() {
                return 2080559107;
            }

            public final GraphQLVisitableModel m2997a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m2994m() != null) {
                    DefaultImageFieldsModel defaultImageFieldsModel = (DefaultImageFieldsModel) graphQLModelMutatingVisitor.b(m2994m());
                    if (m2994m() != defaultImageFieldsModel) {
                        graphQLVisitableModel = (EntityModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f2173g = defaultImageFieldsModel;
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m2996a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m2991j());
                int b = flatBufferBuilder.b(m2992k());
                int b2 = flatBufferBuilder.b(m2993l());
                int a2 = ModelHelper.a(flatBufferBuilder, m2994m());
                int b3 = flatBufferBuilder.b(m2995n());
                flatBufferBuilder.c(5);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.b(1, b);
                flatBufferBuilder.b(2, b2);
                flatBufferBuilder.b(3, a2);
                flatBufferBuilder.b(4, b3);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: takeOrQueuePictureTaking denied by CameraHolder */
        public class Serializer extends JsonSerializer<AppSocialContextTextWithEntitiesEntityRangeFieldsModel> {
            public final void m2999a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                AppSocialContextTextWithEntitiesEntityRangeFieldsModel appSocialContextTextWithEntitiesEntityRangeFieldsModel = (AppSocialContextTextWithEntitiesEntityRangeFieldsModel) obj;
                if (appSocialContextTextWithEntitiesEntityRangeFieldsModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(appSocialContextTextWithEntitiesEntityRangeFieldsModel.m3001a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    appSocialContextTextWithEntitiesEntityRangeFieldsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                AppSocialContextTextWithEntitiesEntityRangeFieldsParser.m3072b(appSocialContextTextWithEntitiesEntityRangeFieldsModel.w_(), appSocialContextTextWithEntitiesEntityRangeFieldsModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(AppSocialContextTextWithEntitiesEntityRangeFieldsModel.class, new Serializer());
            }
        }

        public AppSocialContextTextWithEntitiesEntityRangeFieldsModel() {
            super(3);
        }

        @Nullable
        private EntityModel m3000a() {
            this.f2175d = (EntityModel) super.a(this.f2175d, 0, EntityModel.class);
            return this.f2175d;
        }

        public final int jK_() {
            return -1024511161;
        }

        public final GraphQLVisitableModel m3002a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m3000a() != null) {
                EntityModel entityModel = (EntityModel) graphQLModelMutatingVisitor.b(m3000a());
                if (m3000a() != entityModel) {
                    graphQLVisitableModel = (AppSocialContextTextWithEntitiesEntityRangeFieldsModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f2175d = entityModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m3001a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m3000a());
            flatBufferBuilder.c(3);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.a(1, this.f2176e, 0);
            flatBufferBuilder.a(2, this.f2177f, 0);
            i();
            return flatBufferBuilder.d();
        }

        public final void m3003a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
            super.a(mutableFlatBuffer, i, obj);
            this.f2176e = mutableFlatBuffer.a(i, 1, 0);
            this.f2177f = mutableFlatBuffer.a(i, 2, 0);
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -182734663)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: takeOrQueuePictureTaking denied by CameraHolder */
    public final class AppSocialContextTextWithEntitiesWithRangesModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private List<TextWithEntitiesAggregatedRangeFieldsModel> f2178d;
        @Nullable
        private List<AppSocialContextTextWithEntitiesEntityRangeFieldsModel> f2179e;
        @Nullable
        private String f2180f;

        /* compiled from: takeOrQueuePictureTaking denied by CameraHolder */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(AppSocialContextTextWithEntitiesWithRangesModel.class, new Deserializer());
            }

            public Object m3004a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(AppSocialContextTextWithEntitiesWithRangesParser.m3073a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object appSocialContextTextWithEntitiesWithRangesModel = new AppSocialContextTextWithEntitiesWithRangesModel();
                ((BaseModel) appSocialContextTextWithEntitiesWithRangesModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (appSocialContextTextWithEntitiesWithRangesModel instanceof Postprocessable) {
                    return ((Postprocessable) appSocialContextTextWithEntitiesWithRangesModel).a();
                }
                return appSocialContextTextWithEntitiesWithRangesModel;
            }
        }

        /* compiled from: takeOrQueuePictureTaking denied by CameraHolder */
        public class Serializer extends JsonSerializer<AppSocialContextTextWithEntitiesWithRangesModel> {
            public final void m3005a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                AppSocialContextTextWithEntitiesWithRangesModel appSocialContextTextWithEntitiesWithRangesModel = (AppSocialContextTextWithEntitiesWithRangesModel) obj;
                if (appSocialContextTextWithEntitiesWithRangesModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(appSocialContextTextWithEntitiesWithRangesModel.m3009a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    appSocialContextTextWithEntitiesWithRangesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                AppSocialContextTextWithEntitiesWithRangesParser.m3074a(appSocialContextTextWithEntitiesWithRangesModel.w_(), appSocialContextTextWithEntitiesWithRangesModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(AppSocialContextTextWithEntitiesWithRangesModel.class, new Serializer());
            }
        }

        public AppSocialContextTextWithEntitiesWithRangesModel() {
            super(3);
        }

        @Nonnull
        private ImmutableList<TextWithEntitiesAggregatedRangeFieldsModel> m3006a() {
            this.f2178d = super.a(this.f2178d, 0, TextWithEntitiesAggregatedRangeFieldsModel.class);
            return (ImmutableList) this.f2178d;
        }

        @Nonnull
        private ImmutableList<AppSocialContextTextWithEntitiesEntityRangeFieldsModel> m3007j() {
            this.f2179e = super.a(this.f2179e, 1, AppSocialContextTextWithEntitiesEntityRangeFieldsModel.class);
            return (ImmutableList) this.f2179e;
        }

        @Nullable
        private String m3008k() {
            this.f2180f = super.a(this.f2180f, 2);
            return this.f2180f;
        }

        public final int jK_() {
            return -1919764332;
        }

        public final GraphQLVisitableModel m3010a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            Builder a;
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m3006a() != null) {
                a = ModelHelper.a(m3006a(), graphQLModelMutatingVisitor);
                if (a != null) {
                    graphQLVisitableModel = (AppSocialContextTextWithEntitiesWithRangesModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f2178d = a.b();
                }
            }
            if (m3007j() != null) {
                a = ModelHelper.a(m3007j(), graphQLModelMutatingVisitor);
                if (a != null) {
                    graphQLVisitableModel = (AppSocialContextTextWithEntitiesWithRangesModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f2179e = a.b();
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m3009a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m3006a());
            int a2 = ModelHelper.a(flatBufferBuilder, m3007j());
            int b = flatBufferBuilder.b(m3008k());
            flatBufferBuilder.c(3);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, a2);
            flatBufferBuilder.b(2, b);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -1418794057)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: takeOrQueuePictureTaking denied by CameraHolder */
    public final class AppStoreApplicationFragmentModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private String f2181d;
        @Nullable
        private String f2182e;
        @Nullable
        private List<DefaultImageFieldsModel> f2183f;
        @Nullable
        private DefaultTextWithEntitiesWithRangesFieldsModel f2184g;
        @Nullable
        private GraphQLAppStoreDownloadConnectivityPolicy f2185h;
        @Nullable
        private String f2186i;
        @Nullable
        private GraphQLAppStoreApplicationInstallState f2187j;
        @Nullable
        private DefaultTextWithEntitiesWithRangesFieldsModel f2188k;
        @Nullable
        private List<String> f2189l;
        @Nullable
        private List<DefaultImageFieldsModel> f2190m;
        @Nullable
        private AppStorePlatformApplicationFieldsModel f2191n;
        @Nullable
        private String f2192o;
        @Nullable
        private List<GraphQLDigitalGoodStoreType> f2193p;
        @Nullable
        private AppSocialContextTextWithEntitiesWithRangesModel f2194q;
        private int f2195r;
        @Nullable
        private String f2196s;

        /* compiled from: takeOrQueuePictureTaking denied by CameraHolder */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(AppStoreApplicationFragmentModel.class, new Deserializer());
            }

            public Object m3011a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(AppStoreApplicationFragmentParser.m3075a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object appStoreApplicationFragmentModel = new AppStoreApplicationFragmentModel();
                ((BaseModel) appStoreApplicationFragmentModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (appStoreApplicationFragmentModel instanceof Postprocessable) {
                    return ((Postprocessable) appStoreApplicationFragmentModel).a();
                }
                return appStoreApplicationFragmentModel;
            }
        }

        /* compiled from: takeOrQueuePictureTaking denied by CameraHolder */
        public class Serializer extends JsonSerializer<AppStoreApplicationFragmentModel> {
            public final void m3012a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                AppStoreApplicationFragmentModel appStoreApplicationFragmentModel = (AppStoreApplicationFragmentModel) obj;
                if (appStoreApplicationFragmentModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(appStoreApplicationFragmentModel.m3028a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    appStoreApplicationFragmentModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                AppStoreApplicationFragmentParser.m3076a(appStoreApplicationFragmentModel.w_(), appStoreApplicationFragmentModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(AppStoreApplicationFragmentModel.class, new Serializer());
            }
        }

        public AppStoreApplicationFragmentModel() {
            super(16);
        }

        @Nullable
        private String m3013a() {
            this.f2181d = super.a(this.f2181d, 0);
            return this.f2181d;
        }

        @Nullable
        private String m3014j() {
            this.f2182e = super.a(this.f2182e, 1);
            return this.f2182e;
        }

        @Nonnull
        private ImmutableList<DefaultImageFieldsModel> m3015k() {
            this.f2183f = super.a(this.f2183f, 2, DefaultImageFieldsModel.class);
            return (ImmutableList) this.f2183f;
        }

        @Nullable
        private DefaultTextWithEntitiesWithRangesFieldsModel m3016l() {
            this.f2184g = (DefaultTextWithEntitiesWithRangesFieldsModel) super.a(this.f2184g, 3, DefaultTextWithEntitiesWithRangesFieldsModel.class);
            return this.f2184g;
        }

        @Nullable
        private GraphQLAppStoreDownloadConnectivityPolicy m3017m() {
            this.f2185h = (GraphQLAppStoreDownloadConnectivityPolicy) super.b(this.f2185h, 4, GraphQLAppStoreDownloadConnectivityPolicy.class, GraphQLAppStoreDownloadConnectivityPolicy.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
            return this.f2185h;
        }

        @Nullable
        private String m3018n() {
            this.f2186i = super.a(this.f2186i, 5);
            return this.f2186i;
        }

        @Nullable
        private GraphQLAppStoreApplicationInstallState m3019o() {
            this.f2187j = (GraphQLAppStoreApplicationInstallState) super.b(this.f2187j, 6, GraphQLAppStoreApplicationInstallState.class, GraphQLAppStoreApplicationInstallState.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
            return this.f2187j;
        }

        @Nullable
        private DefaultTextWithEntitiesWithRangesFieldsModel m3020p() {
            this.f2188k = (DefaultTextWithEntitiesWithRangesFieldsModel) super.a(this.f2188k, 7, DefaultTextWithEntitiesWithRangesFieldsModel.class);
            return this.f2188k;
        }

        @Nonnull
        private ImmutableList<String> m3021q() {
            this.f2189l = super.a(this.f2189l, 8);
            return (ImmutableList) this.f2189l;
        }

        @Nonnull
        private ImmutableList<DefaultImageFieldsModel> m3022r() {
            this.f2190m = super.a(this.f2190m, 9, DefaultImageFieldsModel.class);
            return (ImmutableList) this.f2190m;
        }

        @Nullable
        private AppStorePlatformApplicationFieldsModel m3023s() {
            this.f2191n = (AppStorePlatformApplicationFieldsModel) super.a(this.f2191n, 10, AppStorePlatformApplicationFieldsModel.class);
            return this.f2191n;
        }

        @Nullable
        private String m3024t() {
            this.f2192o = super.a(this.f2192o, 11);
            return this.f2192o;
        }

        @Nonnull
        private ImmutableList<GraphQLDigitalGoodStoreType> m3025u() {
            this.f2193p = super.c(this.f2193p, 12, GraphQLDigitalGoodStoreType.class);
            return (ImmutableList) this.f2193p;
        }

        @Nullable
        private AppSocialContextTextWithEntitiesWithRangesModel m3026v() {
            this.f2194q = (AppSocialContextTextWithEntitiesWithRangesModel) super.a(this.f2194q, 13, AppSocialContextTextWithEntitiesWithRangesModel.class);
            return this.f2194q;
        }

        @Nullable
        private String m3027w() {
            this.f2196s = super.a(this.f2196s, 15);
            return this.f2196s;
        }

        public final int jK_() {
            return 1254437328;
        }

        public final GraphQLVisitableModel m3029a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            AppStoreApplicationFragmentModel appStoreApplicationFragmentModel;
            GraphQLVisitableModel graphQLVisitableModel;
            DefaultTextWithEntitiesWithRangesFieldsModel defaultTextWithEntitiesWithRangesFieldsModel;
            Builder a;
            AppStorePlatformApplicationFieldsModel appStorePlatformApplicationFieldsModel;
            AppSocialContextTextWithEntitiesWithRangesModel appSocialContextTextWithEntitiesWithRangesModel;
            h();
            if (m3015k() != null) {
                Builder a2 = ModelHelper.a(m3015k(), graphQLModelMutatingVisitor);
                if (a2 != null) {
                    appStoreApplicationFragmentModel = (AppStoreApplicationFragmentModel) ModelHelper.a(null, this);
                    appStoreApplicationFragmentModel.f2183f = a2.b();
                    graphQLVisitableModel = appStoreApplicationFragmentModel;
                    if (m3016l() != null) {
                        defaultTextWithEntitiesWithRangesFieldsModel = (DefaultTextWithEntitiesWithRangesFieldsModel) graphQLModelMutatingVisitor.b(m3016l());
                        if (m3016l() != defaultTextWithEntitiesWithRangesFieldsModel) {
                            graphQLVisitableModel = (AppStoreApplicationFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                            graphQLVisitableModel.f2184g = defaultTextWithEntitiesWithRangesFieldsModel;
                        }
                    }
                    if (m3020p() != null) {
                        defaultTextWithEntitiesWithRangesFieldsModel = (DefaultTextWithEntitiesWithRangesFieldsModel) graphQLModelMutatingVisitor.b(m3020p());
                        if (m3020p() != defaultTextWithEntitiesWithRangesFieldsModel) {
                            graphQLVisitableModel = (AppStoreApplicationFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                            graphQLVisitableModel.f2188k = defaultTextWithEntitiesWithRangesFieldsModel;
                        }
                    }
                    if (m3022r() != null) {
                        a = ModelHelper.a(m3022r(), graphQLModelMutatingVisitor);
                        if (a != null) {
                            appStoreApplicationFragmentModel = (AppStoreApplicationFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                            appStoreApplicationFragmentModel.f2190m = a.b();
                            graphQLVisitableModel = appStoreApplicationFragmentModel;
                        }
                    }
                    if (m3023s() != null) {
                        appStorePlatformApplicationFieldsModel = (AppStorePlatformApplicationFieldsModel) graphQLModelMutatingVisitor.b(m3023s());
                        if (m3023s() != appStorePlatformApplicationFieldsModel) {
                            graphQLVisitableModel = (AppStoreApplicationFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                            graphQLVisitableModel.f2191n = appStorePlatformApplicationFieldsModel;
                        }
                    }
                    if (m3026v() != null) {
                        appSocialContextTextWithEntitiesWithRangesModel = (AppSocialContextTextWithEntitiesWithRangesModel) graphQLModelMutatingVisitor.b(m3026v());
                        if (m3026v() != appSocialContextTextWithEntitiesWithRangesModel) {
                            graphQLVisitableModel = (AppStoreApplicationFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                            graphQLVisitableModel.f2194q = appSocialContextTextWithEntitiesWithRangesModel;
                        }
                    }
                    i();
                    return graphQLVisitableModel != null ? this : graphQLVisitableModel;
                }
            }
            graphQLVisitableModel = null;
            if (m3016l() != null) {
                defaultTextWithEntitiesWithRangesFieldsModel = (DefaultTextWithEntitiesWithRangesFieldsModel) graphQLModelMutatingVisitor.b(m3016l());
                if (m3016l() != defaultTextWithEntitiesWithRangesFieldsModel) {
                    graphQLVisitableModel = (AppStoreApplicationFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f2184g = defaultTextWithEntitiesWithRangesFieldsModel;
                }
            }
            if (m3020p() != null) {
                defaultTextWithEntitiesWithRangesFieldsModel = (DefaultTextWithEntitiesWithRangesFieldsModel) graphQLModelMutatingVisitor.b(m3020p());
                if (m3020p() != defaultTextWithEntitiesWithRangesFieldsModel) {
                    graphQLVisitableModel = (AppStoreApplicationFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f2188k = defaultTextWithEntitiesWithRangesFieldsModel;
                }
            }
            if (m3022r() != null) {
                a = ModelHelper.a(m3022r(), graphQLModelMutatingVisitor);
                if (a != null) {
                    appStoreApplicationFragmentModel = (AppStoreApplicationFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                    appStoreApplicationFragmentModel.f2190m = a.b();
                    graphQLVisitableModel = appStoreApplicationFragmentModel;
                }
            }
            if (m3023s() != null) {
                appStorePlatformApplicationFieldsModel = (AppStorePlatformApplicationFieldsModel) graphQLModelMutatingVisitor.b(m3023s());
                if (m3023s() != appStorePlatformApplicationFieldsModel) {
                    graphQLVisitableModel = (AppStoreApplicationFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f2191n = appStorePlatformApplicationFieldsModel;
                }
            }
            if (m3026v() != null) {
                appSocialContextTextWithEntitiesWithRangesModel = (AppSocialContextTextWithEntitiesWithRangesModel) graphQLModelMutatingVisitor.b(m3026v());
                if (m3026v() != appSocialContextTextWithEntitiesWithRangesModel) {
                    graphQLVisitableModel = (AppStoreApplicationFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f2194q = appSocialContextTextWithEntitiesWithRangesModel;
                }
            }
            i();
            if (graphQLVisitableModel != null) {
            }
        }

        public final int m3028a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int b = flatBufferBuilder.b(m3013a());
            int b2 = flatBufferBuilder.b(m3014j());
            int a = ModelHelper.a(flatBufferBuilder, m3015k());
            int a2 = ModelHelper.a(flatBufferBuilder, m3016l());
            int a3 = flatBufferBuilder.a(m3017m());
            int b3 = flatBufferBuilder.b(m3018n());
            int a4 = flatBufferBuilder.a(m3019o());
            int a5 = ModelHelper.a(flatBufferBuilder, m3020p());
            int c = flatBufferBuilder.c(m3021q());
            int a6 = ModelHelper.a(flatBufferBuilder, m3022r());
            int a7 = ModelHelper.a(flatBufferBuilder, m3023s());
            int b4 = flatBufferBuilder.b(m3024t());
            int d = flatBufferBuilder.d(m3025u());
            int a8 = ModelHelper.a(flatBufferBuilder, m3026v());
            int b5 = flatBufferBuilder.b(m3027w());
            flatBufferBuilder.c(16);
            flatBufferBuilder.b(0, b);
            flatBufferBuilder.b(1, b2);
            flatBufferBuilder.b(2, a);
            flatBufferBuilder.b(3, a2);
            flatBufferBuilder.b(4, a3);
            flatBufferBuilder.b(5, b3);
            flatBufferBuilder.b(6, a4);
            flatBufferBuilder.b(7, a5);
            flatBufferBuilder.b(8, c);
            flatBufferBuilder.b(9, a6);
            flatBufferBuilder.b(10, a7);
            flatBufferBuilder.b(11, b4);
            flatBufferBuilder.b(12, d);
            flatBufferBuilder.b(13, a8);
            flatBufferBuilder.a(14, this.f2195r, 0);
            flatBufferBuilder.b(15, b5);
            i();
            return flatBufferBuilder.d();
        }

        public final void m3030a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
            super.a(mutableFlatBuffer, i, obj);
            this.f2195r = mutableFlatBuffer.a(i, 14, 0);
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -1614119866)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: takeOrQueuePictureTaking denied by CameraHolder */
    public final class AppStorePlatformApplicationFieldsModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableModel {
        @Nullable
        private AndroidAppConfigModel f2197d;
        @Nullable
        private String f2198e;
        @Nullable
        private DefaultImageFieldsModel f2199f;
        private double f2200g;
        @Nullable
        private String f2201h;
        @Nullable
        private DefaultTextWithEntitiesFieldsModel f2202i;
        @Nullable
        private String f2203j;
        @Nullable
        private String f2204k;
        @Nullable
        private String f2205l;
        @Nullable
        private DefaultTextWithEntitiesFieldsModel f2206m;
        @Nullable
        private DefaultImageUriFieldsModel f2207n;
        @Nullable
        private String f2208o;

        /* compiled from: takeOrQueuePictureTaking denied by CameraHolder */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(AppStorePlatformApplicationFieldsModel.class, new Deserializer());
            }

            public Object m3031a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(AppStorePlatformApplicationFieldsParser.m3077a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object appStorePlatformApplicationFieldsModel = new AppStorePlatformApplicationFieldsModel();
                ((BaseModel) appStorePlatformApplicationFieldsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (appStorePlatformApplicationFieldsModel instanceof Postprocessable) {
                    return ((Postprocessable) appStorePlatformApplicationFieldsModel).a();
                }
                return appStorePlatformApplicationFieldsModel;
            }
        }

        /* compiled from: takeOrQueuePictureTaking denied by CameraHolder */
        public class Serializer extends JsonSerializer<AppStorePlatformApplicationFieldsModel> {
            public final void m3032a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                AppStorePlatformApplicationFieldsModel appStorePlatformApplicationFieldsModel = (AppStorePlatformApplicationFieldsModel) obj;
                if (appStorePlatformApplicationFieldsModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(appStorePlatformApplicationFieldsModel.m3044a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    appStorePlatformApplicationFieldsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                AppStorePlatformApplicationFieldsParser.m3078a(appStorePlatformApplicationFieldsModel.w_(), appStorePlatformApplicationFieldsModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(AppStorePlatformApplicationFieldsModel.class, new Serializer());
            }
        }

        public AppStorePlatformApplicationFieldsModel() {
            super(12);
        }

        @Nullable
        private AndroidAppConfigModel m3033j() {
            this.f2197d = (AndroidAppConfigModel) super.a(this.f2197d, 0, AndroidAppConfigModel.class);
            return this.f2197d;
        }

        @Nullable
        private String m3034k() {
            this.f2198e = super.a(this.f2198e, 1);
            return this.f2198e;
        }

        @Nullable
        private DefaultImageFieldsModel m3035l() {
            this.f2199f = (DefaultImageFieldsModel) super.a(this.f2199f, 2, DefaultImageFieldsModel.class);
            return this.f2199f;
        }

        @Nullable
        private String m3036m() {
            this.f2201h = super.a(this.f2201h, 4);
            return this.f2201h;
        }

        @Nullable
        private DefaultTextWithEntitiesFieldsModel m3037n() {
            this.f2202i = (DefaultTextWithEntitiesFieldsModel) super.a(this.f2202i, 5, DefaultTextWithEntitiesFieldsModel.class);
            return this.f2202i;
        }

        @Nullable
        private String m3038o() {
            this.f2203j = super.a(this.f2203j, 6);
            return this.f2203j;
        }

        @Nullable
        private String m3039p() {
            this.f2204k = super.a(this.f2204k, 7);
            return this.f2204k;
        }

        @Nullable
        private String m3040q() {
            this.f2205l = super.a(this.f2205l, 8);
            return this.f2205l;
        }

        @Nullable
        private DefaultTextWithEntitiesFieldsModel m3041r() {
            this.f2206m = (DefaultTextWithEntitiesFieldsModel) super.a(this.f2206m, 9, DefaultTextWithEntitiesFieldsModel.class);
            return this.f2206m;
        }

        @Nullable
        private DefaultImageUriFieldsModel m3042s() {
            this.f2207n = (DefaultImageUriFieldsModel) super.a(this.f2207n, 10, DefaultImageUriFieldsModel.class);
            return this.f2207n;
        }

        @Nullable
        private String m3043t() {
            this.f2208o = super.a(this.f2208o, 11);
            return this.f2208o;
        }

        @Nullable
        public final String m3046a() {
            return m3038o();
        }

        public final int jK_() {
            return -1072845520;
        }

        public final GraphQLVisitableModel m3045a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            DefaultTextWithEntitiesFieldsModel defaultTextWithEntitiesFieldsModel;
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m3033j() != null) {
                AndroidAppConfigModel androidAppConfigModel = (AndroidAppConfigModel) graphQLModelMutatingVisitor.b(m3033j());
                if (m3033j() != androidAppConfigModel) {
                    graphQLVisitableModel = (AppStorePlatformApplicationFieldsModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f2197d = androidAppConfigModel;
                }
            }
            if (m3035l() != null) {
                DefaultImageFieldsModel defaultImageFieldsModel = (DefaultImageFieldsModel) graphQLModelMutatingVisitor.b(m3035l());
                if (m3035l() != defaultImageFieldsModel) {
                    graphQLVisitableModel = (AppStorePlatformApplicationFieldsModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f2199f = defaultImageFieldsModel;
                }
            }
            if (m3037n() != null) {
                defaultTextWithEntitiesFieldsModel = (DefaultTextWithEntitiesFieldsModel) graphQLModelMutatingVisitor.b(m3037n());
                if (m3037n() != defaultTextWithEntitiesFieldsModel) {
                    graphQLVisitableModel = (AppStorePlatformApplicationFieldsModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f2202i = defaultTextWithEntitiesFieldsModel;
                }
            }
            if (m3041r() != null) {
                defaultTextWithEntitiesFieldsModel = (DefaultTextWithEntitiesFieldsModel) graphQLModelMutatingVisitor.b(m3041r());
                if (m3041r() != defaultTextWithEntitiesFieldsModel) {
                    graphQLVisitableModel = (AppStorePlatformApplicationFieldsModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f2206m = defaultTextWithEntitiesFieldsModel;
                }
            }
            if (m3042s() != null) {
                DefaultImageUriFieldsModel defaultImageUriFieldsModel = (DefaultImageUriFieldsModel) graphQLModelMutatingVisitor.b(m3042s());
                if (m3042s() != defaultImageUriFieldsModel) {
                    graphQLVisitableModel = (AppStorePlatformApplicationFieldsModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f2207n = defaultImageUriFieldsModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m3044a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m3033j());
            int b = flatBufferBuilder.b(m3034k());
            int a2 = ModelHelper.a(flatBufferBuilder, m3035l());
            int b2 = flatBufferBuilder.b(m3036m());
            int a3 = ModelHelper.a(flatBufferBuilder, m3037n());
            int b3 = flatBufferBuilder.b(m3038o());
            int b4 = flatBufferBuilder.b(m3039p());
            int b5 = flatBufferBuilder.b(m3040q());
            int a4 = ModelHelper.a(flatBufferBuilder, m3041r());
            int a5 = ModelHelper.a(flatBufferBuilder, m3042s());
            int b6 = flatBufferBuilder.b(m3043t());
            flatBufferBuilder.c(12);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, b);
            flatBufferBuilder.b(2, a2);
            flatBufferBuilder.a(3, this.f2200g, 0.0d);
            flatBufferBuilder.b(4, b2);
            flatBufferBuilder.b(5, a3);
            flatBufferBuilder.b(6, b3);
            flatBufferBuilder.b(7, b4);
            flatBufferBuilder.b(8, b5);
            flatBufferBuilder.b(9, a4);
            flatBufferBuilder.b(10, a5);
            flatBufferBuilder.b(11, b6);
            i();
            return flatBufferBuilder.d();
        }

        public final void m3047a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
            super.a(mutableFlatBuffer, i, obj);
            this.f2200g = mutableFlatBuffer.a(i, 3, 0.0d);
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -50187799)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: takeOrQueuePictureTaking denied by CameraHolder */
    public final class InnerApplicationFieldsModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableModel {
        @Nullable
        private AndroidAppConfigModel f2211d;
        @Nullable
        private String f2212e;
        @Nullable
        private DefaultImageFieldsModel f2213f;
        private double f2214g;
        @Nullable
        private String f2215h;
        @Nullable
        private DefaultTextWithEntitiesFieldsModel f2216i;
        @Nullable
        private String f2217j;
        @Nullable
        private String f2218k;
        @Nullable
        private DefaultTextWithEntitiesFieldsModel f2219l;
        @Nullable
        private DefaultImageUriFieldsModel f2220m;

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 1164126715)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: takeOrQueuePictureTaking denied by CameraHolder */
        public final class AndroidAppConfigModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private String f2209d;
            @Nullable
            private String f2210e;

            /* compiled from: takeOrQueuePictureTaking denied by CameraHolder */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(AndroidAppConfigModel.class, new Deserializer());
                }

                public Object m3048a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(AndroidAppConfigParser.m3079a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object androidAppConfigModel = new AndroidAppConfigModel();
                    ((BaseModel) androidAppConfigModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (androidAppConfigModel instanceof Postprocessable) {
                        return ((Postprocessable) androidAppConfigModel).a();
                    }
                    return androidAppConfigModel;
                }
            }

            /* compiled from: takeOrQueuePictureTaking denied by CameraHolder */
            public class Serializer extends JsonSerializer<AndroidAppConfigModel> {
                public final void m3049a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    AndroidAppConfigModel androidAppConfigModel = (AndroidAppConfigModel) obj;
                    if (androidAppConfigModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(androidAppConfigModel.m3052a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        androidAppConfigModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    AndroidAppConfigParser.m3080a(androidAppConfigModel.w_(), androidAppConfigModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(AndroidAppConfigModel.class, new Serializer());
                }
            }

            public AndroidAppConfigModel() {
                super(2);
            }

            @Nullable
            private String m3050a() {
                this.f2209d = super.a(this.f2209d, 0);
                return this.f2209d;
            }

            @Nullable
            private String m3051j() {
                this.f2210e = super.a(this.f2210e, 1);
                return this.f2210e;
            }

            public final int jK_() {
                return -585955532;
            }

            public final GraphQLVisitableModel m3053a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m3052a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m3050a());
                int b2 = flatBufferBuilder.b(m3051j());
                flatBufferBuilder.c(2);
                flatBufferBuilder.b(0, b);
                flatBufferBuilder.b(1, b2);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: takeOrQueuePictureTaking denied by CameraHolder */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(InnerApplicationFieldsModel.class, new Deserializer());
            }

            public Object m3054a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(InnerApplicationFieldsParser.m3081a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object innerApplicationFieldsModel = new InnerApplicationFieldsModel();
                ((BaseModel) innerApplicationFieldsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (innerApplicationFieldsModel instanceof Postprocessable) {
                    return ((Postprocessable) innerApplicationFieldsModel).a();
                }
                return innerApplicationFieldsModel;
            }
        }

        /* compiled from: takeOrQueuePictureTaking denied by CameraHolder */
        public class Serializer extends JsonSerializer<InnerApplicationFieldsModel> {
            public final void m3055a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                InnerApplicationFieldsModel innerApplicationFieldsModel = (InnerApplicationFieldsModel) obj;
                if (innerApplicationFieldsModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(innerApplicationFieldsModel.m3065a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    innerApplicationFieldsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                InnerApplicationFieldsParser.m3082a(innerApplicationFieldsModel.w_(), innerApplicationFieldsModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(InnerApplicationFieldsModel.class, new Serializer());
            }
        }

        public InnerApplicationFieldsModel() {
            super(10);
        }

        @Nullable
        private AndroidAppConfigModel m3056j() {
            this.f2211d = (AndroidAppConfigModel) super.a(this.f2211d, 0, AndroidAppConfigModel.class);
            return this.f2211d;
        }

        @Nullable
        private String m3057k() {
            this.f2212e = super.a(this.f2212e, 1);
            return this.f2212e;
        }

        @Nullable
        private DefaultImageFieldsModel m3058l() {
            this.f2213f = (DefaultImageFieldsModel) super.a(this.f2213f, 2, DefaultImageFieldsModel.class);
            return this.f2213f;
        }

        @Nullable
        private String m3059m() {
            this.f2215h = super.a(this.f2215h, 4);
            return this.f2215h;
        }

        @Nullable
        private DefaultTextWithEntitiesFieldsModel m3060n() {
            this.f2216i = (DefaultTextWithEntitiesFieldsModel) super.a(this.f2216i, 5, DefaultTextWithEntitiesFieldsModel.class);
            return this.f2216i;
        }

        @Nullable
        private String m3061o() {
            this.f2217j = super.a(this.f2217j, 6);
            return this.f2217j;
        }

        @Nullable
        private String m3062p() {
            this.f2218k = super.a(this.f2218k, 7);
            return this.f2218k;
        }

        @Nullable
        private DefaultTextWithEntitiesFieldsModel m3063q() {
            this.f2219l = (DefaultTextWithEntitiesFieldsModel) super.a(this.f2219l, 8, DefaultTextWithEntitiesFieldsModel.class);
            return this.f2219l;
        }

        @Nullable
        private DefaultImageUriFieldsModel m3064r() {
            this.f2220m = (DefaultImageUriFieldsModel) super.a(this.f2220m, 9, DefaultImageUriFieldsModel.class);
            return this.f2220m;
        }

        @Nullable
        public final String m3067a() {
            return m3061o();
        }

        public final int jK_() {
            return -1072845520;
        }

        public final GraphQLVisitableModel m3066a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            DefaultTextWithEntitiesFieldsModel defaultTextWithEntitiesFieldsModel;
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m3056j() != null) {
                AndroidAppConfigModel androidAppConfigModel = (AndroidAppConfigModel) graphQLModelMutatingVisitor.b(m3056j());
                if (m3056j() != androidAppConfigModel) {
                    graphQLVisitableModel = (InnerApplicationFieldsModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f2211d = androidAppConfigModel;
                }
            }
            if (m3058l() != null) {
                DefaultImageFieldsModel defaultImageFieldsModel = (DefaultImageFieldsModel) graphQLModelMutatingVisitor.b(m3058l());
                if (m3058l() != defaultImageFieldsModel) {
                    graphQLVisitableModel = (InnerApplicationFieldsModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f2213f = defaultImageFieldsModel;
                }
            }
            if (m3060n() != null) {
                defaultTextWithEntitiesFieldsModel = (DefaultTextWithEntitiesFieldsModel) graphQLModelMutatingVisitor.b(m3060n());
                if (m3060n() != defaultTextWithEntitiesFieldsModel) {
                    graphQLVisitableModel = (InnerApplicationFieldsModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f2216i = defaultTextWithEntitiesFieldsModel;
                }
            }
            if (m3063q() != null) {
                defaultTextWithEntitiesFieldsModel = (DefaultTextWithEntitiesFieldsModel) graphQLModelMutatingVisitor.b(m3063q());
                if (m3063q() != defaultTextWithEntitiesFieldsModel) {
                    graphQLVisitableModel = (InnerApplicationFieldsModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f2219l = defaultTextWithEntitiesFieldsModel;
                }
            }
            if (m3064r() != null) {
                DefaultImageUriFieldsModel defaultImageUriFieldsModel = (DefaultImageUriFieldsModel) graphQLModelMutatingVisitor.b(m3064r());
                if (m3064r() != defaultImageUriFieldsModel) {
                    graphQLVisitableModel = (InnerApplicationFieldsModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f2220m = defaultImageUriFieldsModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m3065a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m3056j());
            int b = flatBufferBuilder.b(m3057k());
            int a2 = ModelHelper.a(flatBufferBuilder, m3058l());
            int b2 = flatBufferBuilder.b(m3059m());
            int a3 = ModelHelper.a(flatBufferBuilder, m3060n());
            int b3 = flatBufferBuilder.b(m3061o());
            int b4 = flatBufferBuilder.b(m3062p());
            int a4 = ModelHelper.a(flatBufferBuilder, m3063q());
            int a5 = ModelHelper.a(flatBufferBuilder, m3064r());
            flatBufferBuilder.c(10);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, b);
            flatBufferBuilder.b(2, a2);
            flatBufferBuilder.a(3, this.f2214g, 0.0d);
            flatBufferBuilder.b(4, b2);
            flatBufferBuilder.b(5, a3);
            flatBufferBuilder.b(6, b3);
            flatBufferBuilder.b(7, b4);
            flatBufferBuilder.b(8, a4);
            flatBufferBuilder.b(9, a5);
            i();
            return flatBufferBuilder.d();
        }

        public final void m3068a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
            super.a(mutableFlatBuffer, i, obj);
            this.f2214g = mutableFlatBuffer.a(i, 3, 0.0d);
        }
    }
}
