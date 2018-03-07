package com.facebook.search.results.protocol.video;

import com.facebook.api.graphql.media.NewsFeedMediaGraphQLModels.SphericalMetadataModel.GuidedTourModel;
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
import com.facebook.graphql.enums.GraphQLVideoBroadcastStatus;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.ModelHelper;
import com.facebook.graphql.querybuilder.common.CommonGraphQLInterfaces.DefaultImageFields;
import com.facebook.graphql.querybuilder.common.CommonGraphQLModels.DefaultImageFieldsModel;
import com.facebook.graphql.querybuilder.common.TextWithEntitiesGraphQLInterfaces.DefaultTextWithEntitiesLongFields;
import com.facebook.graphql.querybuilder.common.TextWithEntitiesGraphQLModels.DefaultTextWithEntitiesLongFieldsModel;
import com.facebook.graphql.visitor.ConsistencyTuple;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLPersistableNode;
import com.facebook.graphql.visitor.GraphQLVisitableConsistentModel;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.facebook.search.results.protocol.video.SearchResultsVideoInterfaces.SearchResultsVideo;
import com.facebook.search.results.protocol.video.SearchResultsVideoParsers.SearchResultsVideoParser;
import com.facebook.search.results.protocol.video.SearchResultsVideoParsers.SearchResultsVideoParser.OwnerParser;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.nio.ByteBuffer;
import javax.annotation.Nullable;

/* compiled from: menu_type */
public class SearchResultsVideoModels {

    @FragmentModelWithBridge
    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -1382012193)
    @JsonSerialize(using = Serializer.class)
    /* compiled from: menu_type */
    public final class SearchResultsVideoModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableModel, SearchResultsVideo {
        @Nullable
        private String f8843A;
        private double f8844B;
        private double f8845C;
        @Nullable
        private String f8846D;
        @Nullable
        private String f8847E;
        private int f8848F;
        private boolean f8849G;
        private int f8850H;
        @Nullable
        private GraphQLVideoBroadcastStatus f8851d;
        private long f8852e;
        @Nullable
        private GraphQLStory f8853f;
        @Nullable
        private GuidedTourModel f8854g;
        private boolean f8855h;
        private boolean f8856i;
        private int f8857j;
        @Nullable
        private String f8858k;
        @Nullable
        private DefaultImageFieldsModel f8859l;
        private int f8860m;
        private int f8861n;
        private int f8862o;
        private boolean f8863p;
        private boolean f8864q;
        private boolean f8865r;
        private boolean f8866s;
        private int f8867t;
        private int f8868u;
        @Nullable
        private DefaultTextWithEntitiesLongFieldsModel f8869v;
        @Nullable
        private OwnerModel f8870w;
        private int f8871x;
        private int f8872y;
        @Nullable
        private String f8873z;

        /* compiled from: menu_type */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(SearchResultsVideoModel.class, new Deserializer());
            }

            public Object m10533a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(SearchResultsVideoParser.m10570a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object searchResultsVideoModel = new SearchResultsVideoModel();
                ((BaseModel) searchResultsVideoModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (searchResultsVideoModel instanceof Postprocessable) {
                    return ((Postprocessable) searchResultsVideoModel).a();
                }
                return searchResultsVideoModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 869696189)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: menu_type */
        public final class OwnerModel extends BaseModel implements GraphQLVisitableConsistentModel {
            @Nullable
            private GraphQLObjectType f8840d;
            private boolean f8841e;
            @Nullable
            private String f8842f;

            /* compiled from: menu_type */
            public final class Builder {
                @Nullable
                public GraphQLObjectType f8837a;
                public boolean f8838b;
                @Nullable
                public String f8839c;

                public final OwnerModel m10534a() {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    int a = ModelHelper.a(flatBufferBuilder, this.f8837a);
                    int b = flatBufferBuilder.b(this.f8839c);
                    flatBufferBuilder.c(3);
                    flatBufferBuilder.b(0, a);
                    flatBufferBuilder.a(1, this.f8838b);
                    flatBufferBuilder.b(2, b);
                    flatBufferBuilder.d(flatBufferBuilder.d());
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    return new OwnerModel(new MutableFlatBuffer(wrap, null, null, true, null));
                }
            }

            /* compiled from: menu_type */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(OwnerModel.class, new Deserializer());
                }

                public Object m10535a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(OwnerParser.m10568a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object ownerModel = new OwnerModel();
                    ((BaseModel) ownerModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (ownerModel instanceof Postprocessable) {
                        return ((Postprocessable) ownerModel).a();
                    }
                    return ownerModel;
                }
            }

            /* compiled from: menu_type */
            public class Serializer extends JsonSerializer<OwnerModel> {
                public final void m10536a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    OwnerModel ownerModel = (OwnerModel) obj;
                    if (ownerModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(ownerModel.m10538a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        ownerModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    OwnerParser.m10569a(ownerModel.w_(), ownerModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(OwnerModel.class, new Serializer());
                }
            }

            public OwnerModel() {
                super(3);
            }

            public OwnerModel(MutableFlatBuffer mutableFlatBuffer) {
                super(3);
                a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
            }

            public final void m10542a(String str, ConsistencyTuple consistencyTuple) {
                consistencyTuple.a();
            }

            public final void m10543a(String str, Object obj, boolean z) {
            }

            @Nullable
            public final GraphQLObjectType m10539a() {
                if (this.b != null && this.f8840d == null) {
                    this.f8840d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
                }
                return this.f8840d;
            }

            public final boolean m10544b() {
                a(0, 1);
                return this.f8841e;
            }

            @Nullable
            public final String m10545c() {
                this.f8842f = super.a(this.f8842f, 2);
                return this.f8842f;
            }

            public static OwnerModel m10537a(OwnerModel ownerModel) {
                if (ownerModel == null) {
                    return null;
                }
                if (ownerModel instanceof OwnerModel) {
                    return ownerModel;
                }
                Builder builder = new Builder();
                builder.f8837a = ownerModel.m10539a();
                builder.f8838b = ownerModel.m10544b();
                builder.f8839c = ownerModel.m10545c();
                return builder.m10534a();
            }

            public final int jK_() {
                return 63093205;
            }

            public final GraphQLVisitableModel m10540a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m10538a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m10539a());
                int b = flatBufferBuilder.b(m10545c());
                flatBufferBuilder.c(3);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.a(1, this.f8841e);
                flatBufferBuilder.b(2, b);
                i();
                return flatBufferBuilder.d();
            }

            public final void m10541a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                super.a(mutableFlatBuffer, i, obj);
                this.f8841e = mutableFlatBuffer.a(i, 1);
            }
        }

        /* compiled from: menu_type */
        public class Serializer extends JsonSerializer<SearchResultsVideoModel> {
            public final void m10546a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                SearchResultsVideoModel searchResultsVideoModel = (SearchResultsVideoModel) obj;
                if (searchResultsVideoModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(searchResultsVideoModel.m10562a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    searchResultsVideoModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                SearchResultsVideoParser.m10571a(searchResultsVideoModel.w_(), searchResultsVideoModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(SearchResultsVideoModel.class, new Serializer());
            }
        }

        @Nullable
        public final /* synthetic */ DefaultImageFields mo575F() {
            return m10550m();
        }

        @Nullable
        public final /* synthetic */ DefaultTextWithEntitiesLongFields mo578R() {
            return m10551n();
        }

        @Nullable
        public final /* synthetic */ OwnerModel mo580Y() {
            return m10552q();
        }

        public SearchResultsVideoModel() {
            super(31);
        }

        @Nullable
        private GraphQLVideoBroadcastStatus m10547j() {
            this.f8851d = (GraphQLVideoBroadcastStatus) super.b(this.f8851d, 0, GraphQLVideoBroadcastStatus.class, GraphQLVideoBroadcastStatus.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
            return this.f8851d;
        }

        public final long mo590o() {
            a(0, 1);
            return this.f8852e;
        }

        @Nullable
        public final GraphQLStory mo591p() {
            this.f8853f = (GraphQLStory) super.a(this.f8853f, 2, GraphQLStory.class);
            return this.f8853f;
        }

        @Nullable
        private GuidedTourModel m10548k() {
            this.f8854g = (GuidedTourModel) super.a(this.f8854g, 3, GuidedTourModel.class);
            return this.f8854g;
        }

        public final boolean mo571A() {
            a(0, 5);
            return this.f8856i;
        }

        @Nullable
        private String m10549l() {
            this.f8858k = super.a(this.f8858k, 7);
            return this.f8858k;
        }

        @Nullable
        private DefaultImageFieldsModel m10550m() {
            this.f8859l = (DefaultImageFieldsModel) super.a(this.f8859l, 8, DefaultImageFieldsModel.class);
            return this.f8859l;
        }

        public final boolean mo576J() {
            a(1, 4);
            return this.f8863p;
        }

        @Nullable
        private DefaultTextWithEntitiesLongFieldsModel m10551n() {
            this.f8869v = (DefaultTextWithEntitiesLongFieldsModel) super.a(this.f8869v, 18, DefaultTextWithEntitiesLongFieldsModel.class);
            return this.f8869v;
        }

        @Nullable
        private OwnerModel m10552q() {
            this.f8870w = (OwnerModel) super.a(this.f8870w, 19, OwnerModel.class);
            return this.f8870w;
        }

        public final int ad() {
            a(2, 4);
            return this.f8871x;
        }

        public final int ae() {
            a(2, 5);
            return this.f8872y;
        }

        @Nullable
        private String m10553r() {
            this.f8873z = super.a(this.f8873z, 22);
            return this.f8873z;
        }

        @Nullable
        private String m10554s() {
            this.f8843A = super.a(this.f8843A, 23);
            return this.f8843A;
        }

        @Nullable
        private String m10555t() {
            this.f8846D = super.a(this.f8846D, 26);
            return this.f8846D;
        }

        @Nullable
        private String m10556u() {
            this.f8847E = super.a(this.f8847E, 27);
            return this.f8847E;
        }

        @Nullable
        public final String m10564a() {
            return m10549l();
        }

        public final int jK_() {
            return 82650203;
        }

        public final GraphQLVisitableModel m10563a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (mo591p() != null) {
                GraphQLStory graphQLStory = (GraphQLStory) graphQLModelMutatingVisitor.b(mo591p());
                if (mo591p() != graphQLStory) {
                    graphQLVisitableModel = (SearchResultsVideoModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f8853f = graphQLStory;
                }
            }
            if (m10548k() != null) {
                GuidedTourModel guidedTourModel = (GuidedTourModel) graphQLModelMutatingVisitor.b(m10548k());
                if (m10548k() != guidedTourModel) {
                    graphQLVisitableModel = (SearchResultsVideoModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f8854g = guidedTourModel;
                }
            }
            if (m10550m() != null) {
                DefaultImageFieldsModel defaultImageFieldsModel = (DefaultImageFieldsModel) graphQLModelMutatingVisitor.b(m10550m());
                if (m10550m() != defaultImageFieldsModel) {
                    graphQLVisitableModel = (SearchResultsVideoModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f8859l = defaultImageFieldsModel;
                }
            }
            if (m10551n() != null) {
                DefaultTextWithEntitiesLongFieldsModel defaultTextWithEntitiesLongFieldsModel = (DefaultTextWithEntitiesLongFieldsModel) graphQLModelMutatingVisitor.b(m10551n());
                if (m10551n() != defaultTextWithEntitiesLongFieldsModel) {
                    graphQLVisitableModel = (SearchResultsVideoModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f8869v = defaultTextWithEntitiesLongFieldsModel;
                }
            }
            if (m10552q() != null) {
                OwnerModel ownerModel = (OwnerModel) graphQLModelMutatingVisitor.b(m10552q());
                if (m10552q() != ownerModel) {
                    graphQLVisitableModel = (SearchResultsVideoModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f8870w = ownerModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m10562a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = flatBufferBuilder.a(m10547j());
            int a2 = ModelHelper.a(flatBufferBuilder, mo591p());
            int a3 = ModelHelper.a(flatBufferBuilder, m10548k());
            int b = flatBufferBuilder.b(m10549l());
            int a4 = ModelHelper.a(flatBufferBuilder, m10550m());
            int a5 = ModelHelper.a(flatBufferBuilder, m10551n());
            int a6 = ModelHelper.a(flatBufferBuilder, m10552q());
            int b2 = flatBufferBuilder.b(m10553r());
            int b3 = flatBufferBuilder.b(m10554s());
            int b4 = flatBufferBuilder.b(m10555t());
            int b5 = flatBufferBuilder.b(m10556u());
            flatBufferBuilder.c(31);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.a(1, this.f8852e, 0);
            flatBufferBuilder.b(2, a2);
            flatBufferBuilder.b(3, a3);
            flatBufferBuilder.a(4, this.f8855h);
            flatBufferBuilder.a(5, this.f8856i);
            flatBufferBuilder.a(6, this.f8857j, 0);
            flatBufferBuilder.b(7, b);
            flatBufferBuilder.b(8, a4);
            flatBufferBuilder.a(9, this.f8860m, 0);
            flatBufferBuilder.a(10, this.f8861n, 0);
            flatBufferBuilder.a(11, this.f8862o, 0);
            flatBufferBuilder.a(12, this.f8863p);
            flatBufferBuilder.a(13, this.f8864q);
            flatBufferBuilder.a(14, this.f8865r);
            flatBufferBuilder.a(15, this.f8866s);
            flatBufferBuilder.a(16, this.f8867t, 0);
            flatBufferBuilder.a(17, this.f8868u, 0);
            flatBufferBuilder.b(18, a5);
            flatBufferBuilder.b(19, a6);
            flatBufferBuilder.a(20, this.f8871x, 0);
            flatBufferBuilder.a(21, this.f8872y, 0);
            flatBufferBuilder.b(22, b2);
            flatBufferBuilder.b(23, b3);
            flatBufferBuilder.a(24, this.f8844B, 0.0d);
            flatBufferBuilder.a(25, this.f8845C, 0.0d);
            flatBufferBuilder.b(26, b4);
            flatBufferBuilder.b(27, b5);
            flatBufferBuilder.a(28, this.f8848F, 0);
            flatBufferBuilder.a(29, this.f8849G);
            flatBufferBuilder.a(30, this.f8850H, 0);
            i();
            return flatBufferBuilder.d();
        }

        public final void m10565a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
            super.a(mutableFlatBuffer, i, obj);
            this.f8852e = mutableFlatBuffer.a(i, 1, 0);
            this.f8855h = mutableFlatBuffer.a(i, 4);
            this.f8856i = mutableFlatBuffer.a(i, 5);
            this.f8857j = mutableFlatBuffer.a(i, 6, 0);
            this.f8860m = mutableFlatBuffer.a(i, 9, 0);
            this.f8861n = mutableFlatBuffer.a(i, 10, 0);
            this.f8862o = mutableFlatBuffer.a(i, 11, 0);
            this.f8863p = mutableFlatBuffer.a(i, 12);
            this.f8864q = mutableFlatBuffer.a(i, 13);
            this.f8865r = mutableFlatBuffer.a(i, 14);
            this.f8866s = mutableFlatBuffer.a(i, 15);
            this.f8867t = mutableFlatBuffer.a(i, 16, 0);
            this.f8868u = mutableFlatBuffer.a(i, 17, 0);
            this.f8871x = mutableFlatBuffer.a(i, 20, 0);
            this.f8872y = mutableFlatBuffer.a(i, 21, 0);
            this.f8844B = mutableFlatBuffer.a(i, 24, 0.0d);
            this.f8845C = mutableFlatBuffer.a(i, 25, 0.0d);
            this.f8848F = mutableFlatBuffer.a(i, 28, 0);
            this.f8849G = mutableFlatBuffer.a(i, 29);
            this.f8850H = mutableFlatBuffer.a(i, 30, 0);
        }
    }
}
