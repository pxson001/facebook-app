package com.facebook.video.channelfeed.protocol;

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
import com.facebook.graphql.model.GraphQLVideoChannelFeedEdge;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.ModelHelper;
import com.facebook.graphql.modelutil.SerializerHelpers;
import com.facebook.graphql.querybuilder.common.CommonGraphQL2Models.DefaultPageInfoFieldsModel;
import com.facebook.graphql.querybuilder.common.TextWithEntitiesGraphQLModels.DefaultTextWithEntitiesFieldsModel;
import com.facebook.graphql.visitor.ConsistencyTuple;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLPersistableNode;
import com.facebook.graphql.visitor.GraphQLVisitableConsistentModel;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.facebook.video.channelfeed.protocol.FetchVideoChannelQueryOptimizedFragmentsQEParsers.ChannelFeedVideoChannelFeedFragmentQEParser;
import com.facebook.video.channelfeed.protocol.FetchVideoChannelQueryOptimizedFragmentsQEParsers.ChannelFeedVideoChannelFragmentQEParser;
import com.facebook.video.channelfeed.protocol.FetchVideoChannelQueryOptimizedFragmentsQEParsers.FetchVideoChannelByVideoQueryQEParser;
import com.facebook.video.channelfeed.protocol.FetchVideoChannelQueryOptimizedFragmentsQEParsers.FetchVideoChannelByVideoQueryQEParser.OwnerParser;
import com.facebook.video.channelfeed.protocol.FetchVideoChannelQueryOptimizedFragmentsQEParsers.FetchVideosByVideoChannelQueryQEParser;
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

/* compiled from: contacts_db_in_bug_report */
public class FetchVideoChannelQueryOptimizedFragmentsQEModels {

    @FragmentModelWithBridge
    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -410334281)
    @JsonSerialize(using = Serializer.class)
    /* compiled from: contacts_db_in_bug_report */
    public final class ChannelFeedVideoChannelFeedFragmentQEModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private List<GraphQLVideoChannelFeedEdge> f18571d;
        @Nullable
        private DefaultPageInfoFieldsModel f18572e;

        /* compiled from: contacts_db_in_bug_report */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(ChannelFeedVideoChannelFeedFragmentQEModel.class, new Deserializer());
            }

            public Object m27236a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(ChannelFeedVideoChannelFeedFragmentQEParser.m27279a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object channelFeedVideoChannelFeedFragmentQEModel = new ChannelFeedVideoChannelFeedFragmentQEModel();
                ((BaseModel) channelFeedVideoChannelFeedFragmentQEModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (channelFeedVideoChannelFeedFragmentQEModel instanceof Postprocessable) {
                    return ((Postprocessable) channelFeedVideoChannelFeedFragmentQEModel).a();
                }
                return channelFeedVideoChannelFeedFragmentQEModel;
            }
        }

        /* compiled from: contacts_db_in_bug_report */
        public class Serializer extends JsonSerializer<ChannelFeedVideoChannelFeedFragmentQEModel> {
            public final void m27237a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                ChannelFeedVideoChannelFeedFragmentQEModel channelFeedVideoChannelFeedFragmentQEModel = (ChannelFeedVideoChannelFeedFragmentQEModel) obj;
                if (channelFeedVideoChannelFeedFragmentQEModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(channelFeedVideoChannelFeedFragmentQEModel.m27238a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    channelFeedVideoChannelFeedFragmentQEModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                ChannelFeedVideoChannelFeedFragmentQEParser.m27280a(channelFeedVideoChannelFeedFragmentQEModel.w_(), channelFeedVideoChannelFeedFragmentQEModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(ChannelFeedVideoChannelFeedFragmentQEModel.class, new Serializer());
            }
        }

        public ChannelFeedVideoChannelFeedFragmentQEModel() {
            super(2);
        }

        @Nonnull
        public final ImmutableList<GraphQLVideoChannelFeedEdge> m27240a() {
            this.f18571d = super.a(this.f18571d, 0, GraphQLVideoChannelFeedEdge.class);
            return (ImmutableList) this.f18571d;
        }

        @Nullable
        public final DefaultPageInfoFieldsModel m27241j() {
            this.f18572e = (DefaultPageInfoFieldsModel) super.a(this.f18572e, 1, DefaultPageInfoFieldsModel.class);
            return this.f18572e;
        }

        public final int jK_() {
            return -1837884060;
        }

        public final GraphQLVisitableModel m27239a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel;
            DefaultPageInfoFieldsModel defaultPageInfoFieldsModel;
            h();
            if (m27240a() != null) {
                Builder a = ModelHelper.a(m27240a(), graphQLModelMutatingVisitor);
                if (a != null) {
                    ChannelFeedVideoChannelFeedFragmentQEModel channelFeedVideoChannelFeedFragmentQEModel = (ChannelFeedVideoChannelFeedFragmentQEModel) ModelHelper.a(null, this);
                    channelFeedVideoChannelFeedFragmentQEModel.f18571d = a.b();
                    graphQLVisitableModel = channelFeedVideoChannelFeedFragmentQEModel;
                    if (m27241j() != null) {
                        defaultPageInfoFieldsModel = (DefaultPageInfoFieldsModel) graphQLModelMutatingVisitor.b(m27241j());
                        if (m27241j() != defaultPageInfoFieldsModel) {
                            graphQLVisitableModel = (ChannelFeedVideoChannelFeedFragmentQEModel) ModelHelper.a(graphQLVisitableModel, this);
                            graphQLVisitableModel.f18572e = defaultPageInfoFieldsModel;
                        }
                    }
                    i();
                    return graphQLVisitableModel != null ? this : graphQLVisitableModel;
                }
            }
            graphQLVisitableModel = null;
            if (m27241j() != null) {
                defaultPageInfoFieldsModel = (DefaultPageInfoFieldsModel) graphQLModelMutatingVisitor.b(m27241j());
                if (m27241j() != defaultPageInfoFieldsModel) {
                    graphQLVisitableModel = (ChannelFeedVideoChannelFeedFragmentQEModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f18572e = defaultPageInfoFieldsModel;
                }
            }
            i();
            if (graphQLVisitableModel != null) {
            }
        }

        public final int m27238a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m27240a());
            int a2 = ModelHelper.a(flatBufferBuilder, m27241j());
            flatBufferBuilder.c(2);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, a2);
            i();
            return flatBufferBuilder.d();
        }
    }

    @FragmentModelWithBridge
    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -240926510)
    @JsonSerialize(using = Serializer.class)
    /* compiled from: contacts_db_in_bug_report */
    public final class ChannelFeedVideoChannelFragmentQEModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
        @Nullable
        private GraphQLObjectType f18573d;
        @Nullable
        private String f18574e;
        @Nullable
        private ChannelFeedVideoChannelFeedFragmentQEModel f18575f;
        @Nullable
        private DefaultTextWithEntitiesFieldsModel f18576g;

        /* compiled from: contacts_db_in_bug_report */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(ChannelFeedVideoChannelFragmentQEModel.class, new Deserializer());
            }

            public Object m27242a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(ChannelFeedVideoChannelFragmentQEParser.m27281a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object channelFeedVideoChannelFragmentQEModel = new ChannelFeedVideoChannelFragmentQEModel();
                ((BaseModel) channelFeedVideoChannelFragmentQEModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (channelFeedVideoChannelFragmentQEModel instanceof Postprocessable) {
                    return ((Postprocessable) channelFeedVideoChannelFragmentQEModel).a();
                }
                return channelFeedVideoChannelFragmentQEModel;
            }
        }

        /* compiled from: contacts_db_in_bug_report */
        public class Serializer extends JsonSerializer<ChannelFeedVideoChannelFragmentQEModel> {
            public final void m27243a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                ChannelFeedVideoChannelFragmentQEModel channelFeedVideoChannelFragmentQEModel = (ChannelFeedVideoChannelFragmentQEModel) obj;
                if (channelFeedVideoChannelFragmentQEModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(channelFeedVideoChannelFragmentQEModel.m27245a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    channelFeedVideoChannelFragmentQEModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                ChannelFeedVideoChannelFragmentQEParser.m27282a(channelFeedVideoChannelFragmentQEModel.w_(), channelFeedVideoChannelFragmentQEModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(ChannelFeedVideoChannelFragmentQEModel.class, new Serializer());
            }
        }

        public ChannelFeedVideoChannelFragmentQEModel() {
            super(4);
        }

        public final void m27248a(String str, ConsistencyTuple consistencyTuple) {
            consistencyTuple.a();
        }

        public final void m27249a(String str, Object obj, boolean z) {
        }

        @Nullable
        private GraphQLObjectType m27244m() {
            if (this.b != null && this.f18573d == null) {
                this.f18573d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
            }
            return this.f18573d;
        }

        @Nullable
        public final String m27250j() {
            this.f18574e = super.a(this.f18574e, 1);
            return this.f18574e;
        }

        @Nullable
        public final ChannelFeedVideoChannelFeedFragmentQEModel m27251k() {
            this.f18575f = (ChannelFeedVideoChannelFeedFragmentQEModel) super.a(this.f18575f, 2, ChannelFeedVideoChannelFeedFragmentQEModel.class);
            return this.f18575f;
        }

        @Nullable
        public final DefaultTextWithEntitiesFieldsModel m27252l() {
            this.f18576g = (DefaultTextWithEntitiesFieldsModel) super.a(this.f18576g, 3, DefaultTextWithEntitiesFieldsModel.class);
            return this.f18576g;
        }

        @Nullable
        public final String m27247a() {
            return m27250j();
        }

        public final int jK_() {
            return 756114472;
        }

        public final GraphQLVisitableModel m27246a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m27251k() != null) {
                ChannelFeedVideoChannelFeedFragmentQEModel channelFeedVideoChannelFeedFragmentQEModel = (ChannelFeedVideoChannelFeedFragmentQEModel) graphQLModelMutatingVisitor.b(m27251k());
                if (m27251k() != channelFeedVideoChannelFeedFragmentQEModel) {
                    graphQLVisitableModel = (ChannelFeedVideoChannelFragmentQEModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f18575f = channelFeedVideoChannelFeedFragmentQEModel;
                }
            }
            if (m27252l() != null) {
                DefaultTextWithEntitiesFieldsModel defaultTextWithEntitiesFieldsModel = (DefaultTextWithEntitiesFieldsModel) graphQLModelMutatingVisitor.b(m27252l());
                if (m27252l() != defaultTextWithEntitiesFieldsModel) {
                    graphQLVisitableModel = (ChannelFeedVideoChannelFragmentQEModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f18576g = defaultTextWithEntitiesFieldsModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m27245a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m27244m());
            int b = flatBufferBuilder.b(m27250j());
            int a2 = ModelHelper.a(flatBufferBuilder, m27251k());
            int a3 = ModelHelper.a(flatBufferBuilder, m27252l());
            flatBufferBuilder.c(4);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, b);
            flatBufferBuilder.b(2, a2);
            flatBufferBuilder.b(3, a3);
            i();
            return flatBufferBuilder.d();
        }
    }

    @FragmentModelWithBridge
    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 704697611)
    @JsonSerialize(using = Serializer.class)
    /* compiled from: contacts_db_in_bug_report */
    public final class FetchVideoChannelByVideoQueryQEModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableModel {
        @Nullable
        private String f18580d;
        @Nullable
        private OwnerModel f18581e;
        @Nullable
        private ChannelFeedVideoChannelFragmentQEModel f18582f;

        /* compiled from: contacts_db_in_bug_report */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(FetchVideoChannelByVideoQueryQEModel.class, new Deserializer());
            }

            public Object m27253a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = FetchVideoChannelByVideoQueryQEParser.m27285a(jsonParser);
                Object fetchVideoChannelByVideoQueryQEModel = new FetchVideoChannelByVideoQueryQEModel();
                ((BaseModel) fetchVideoChannelByVideoQueryQEModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (fetchVideoChannelByVideoQueryQEModel instanceof Postprocessable) {
                    return ((Postprocessable) fetchVideoChannelByVideoQueryQEModel).a();
                }
                return fetchVideoChannelByVideoQueryQEModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 1255661007)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: contacts_db_in_bug_report */
        public final class OwnerModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
            @Nullable
            private GraphQLObjectType f18577d;
            @Nullable
            private String f18578e;
            @Nullable
            private String f18579f;

            /* compiled from: contacts_db_in_bug_report */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(OwnerModel.class, new Deserializer());
                }

                public Object m27254a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(OwnerParser.m27283a(jsonParser, flatBufferBuilder));
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

            /* compiled from: contacts_db_in_bug_report */
            public class Serializer extends JsonSerializer<OwnerModel> {
                public final void m27255a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    OwnerModel ownerModel = (OwnerModel) obj;
                    if (ownerModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(ownerModel.m27259a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        ownerModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    OwnerParser.m27284a(ownerModel.w_(), ownerModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(OwnerModel.class, new Serializer());
                }
            }

            public OwnerModel() {
                super(3);
            }

            public final void m27262a(String str, ConsistencyTuple consistencyTuple) {
                consistencyTuple.a();
            }

            public final void m27263a(String str, Object obj, boolean z) {
            }

            @Nullable
            private GraphQLObjectType m27256j() {
                if (this.b != null && this.f18577d == null) {
                    this.f18577d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
                }
                return this.f18577d;
            }

            @Nullable
            private String m27257k() {
                this.f18578e = super.a(this.f18578e, 1);
                return this.f18578e;
            }

            @Nullable
            private String m27258l() {
                this.f18579f = super.a(this.f18579f, 2);
                return this.f18579f;
            }

            @Nullable
            public final String m27261a() {
                return m27257k();
            }

            public final int jK_() {
                return 63093205;
            }

            public final GraphQLVisitableModel m27260a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m27259a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m27256j());
                int b = flatBufferBuilder.b(m27257k());
                int b2 = flatBufferBuilder.b(m27258l());
                flatBufferBuilder.c(3);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.b(1, b);
                flatBufferBuilder.b(2, b2);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: contacts_db_in_bug_report */
        public class Serializer extends JsonSerializer<FetchVideoChannelByVideoQueryQEModel> {
            public final void m27264a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                FetchVideoChannelByVideoQueryQEModel fetchVideoChannelByVideoQueryQEModel = (FetchVideoChannelByVideoQueryQEModel) obj;
                if (fetchVideoChannelByVideoQueryQEModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(fetchVideoChannelByVideoQueryQEModel.m27267a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    fetchVideoChannelByVideoQueryQEModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = fetchVideoChannelByVideoQueryQEModel.w_();
                int u_ = fetchVideoChannelByVideoQueryQEModel.u_();
                jsonGenerator.f();
                if (mutableFlatBuffer.g(u_, 0) != 0) {
                    jsonGenerator.a("id");
                    jsonGenerator.b(mutableFlatBuffer.c(u_, 0));
                }
                int g = mutableFlatBuffer.g(u_, 1);
                if (g != 0) {
                    jsonGenerator.a("owner");
                    OwnerParser.m27284a(mutableFlatBuffer, g, jsonGenerator);
                }
                g = mutableFlatBuffer.g(u_, 2);
                if (g != 0) {
                    jsonGenerator.a("video_channel");
                    ChannelFeedVideoChannelFragmentQEParser.m27282a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(FetchVideoChannelByVideoQueryQEModel.class, new Serializer());
            }
        }

        public FetchVideoChannelByVideoQueryQEModel() {
            super(3);
        }

        @Nullable
        private String m27265k() {
            this.f18580d = super.a(this.f18580d, 0);
            return this.f18580d;
        }

        @Nullable
        private OwnerModel m27266l() {
            this.f18581e = (OwnerModel) super.a(this.f18581e, 1, OwnerModel.class);
            return this.f18581e;
        }

        @Nullable
        public final ChannelFeedVideoChannelFragmentQEModel m27270j() {
            this.f18582f = (ChannelFeedVideoChannelFragmentQEModel) super.a(this.f18582f, 2, ChannelFeedVideoChannelFragmentQEModel.class);
            return this.f18582f;
        }

        @Nullable
        public final String m27269a() {
            return m27265k();
        }

        public final int jK_() {
            return 82650203;
        }

        public final GraphQLVisitableModel m27268a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m27266l() != null) {
                OwnerModel ownerModel = (OwnerModel) graphQLModelMutatingVisitor.b(m27266l());
                if (m27266l() != ownerModel) {
                    graphQLVisitableModel = (FetchVideoChannelByVideoQueryQEModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f18581e = ownerModel;
                }
            }
            if (m27270j() != null) {
                ChannelFeedVideoChannelFragmentQEModel channelFeedVideoChannelFragmentQEModel = (ChannelFeedVideoChannelFragmentQEModel) graphQLModelMutatingVisitor.b(m27270j());
                if (m27270j() != channelFeedVideoChannelFragmentQEModel) {
                    graphQLVisitableModel = (FetchVideoChannelByVideoQueryQEModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f18582f = channelFeedVideoChannelFragmentQEModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m27267a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int b = flatBufferBuilder.b(m27265k());
            int a = ModelHelper.a(flatBufferBuilder, m27266l());
            int a2 = ModelHelper.a(flatBufferBuilder, m27270j());
            flatBufferBuilder.c(3);
            flatBufferBuilder.b(0, b);
            flatBufferBuilder.b(1, a);
            flatBufferBuilder.b(2, a2);
            i();
            return flatBufferBuilder.d();
        }
    }

    @FragmentModelWithBridge
    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -751572659)
    @JsonSerialize(using = Serializer.class)
    /* compiled from: contacts_db_in_bug_report */
    public final class FetchVideosByVideoChannelQueryQEModel extends BaseModel implements GraphQLVisitableConsistentModel {
        @Nullable
        private GraphQLObjectType f18583d;
        @Nullable
        private ChannelFeedVideoChannelFeedFragmentQEModel f18584e;

        /* compiled from: contacts_db_in_bug_report */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(FetchVideosByVideoChannelQueryQEModel.class, new Deserializer());
            }

            public Object m27271a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = FetchVideosByVideoChannelQueryQEParser.m27286a(jsonParser);
                Object fetchVideosByVideoChannelQueryQEModel = new FetchVideosByVideoChannelQueryQEModel();
                ((BaseModel) fetchVideosByVideoChannelQueryQEModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (fetchVideosByVideoChannelQueryQEModel instanceof Postprocessable) {
                    return ((Postprocessable) fetchVideosByVideoChannelQueryQEModel).a();
                }
                return fetchVideosByVideoChannelQueryQEModel;
            }
        }

        /* compiled from: contacts_db_in_bug_report */
        public class Serializer extends JsonSerializer<FetchVideosByVideoChannelQueryQEModel> {
            public final void m27272a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                FetchVideosByVideoChannelQueryQEModel fetchVideosByVideoChannelQueryQEModel = (FetchVideosByVideoChannelQueryQEModel) obj;
                if (fetchVideosByVideoChannelQueryQEModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(fetchVideosByVideoChannelQueryQEModel.m27274a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    fetchVideosByVideoChannelQueryQEModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = fetchVideosByVideoChannelQueryQEModel.w_();
                int u_ = fetchVideosByVideoChannelQueryQEModel.u_();
                jsonGenerator.f();
                if (mutableFlatBuffer.g(u_, 0) != 0) {
                    jsonGenerator.a("__type__");
                    SerializerHelpers.b(mutableFlatBuffer, u_, 0, jsonGenerator);
                }
                int g = mutableFlatBuffer.g(u_, 1);
                if (g != 0) {
                    jsonGenerator.a("video_channel_feed");
                    ChannelFeedVideoChannelFeedFragmentQEParser.m27280a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(FetchVideosByVideoChannelQueryQEModel.class, new Serializer());
            }
        }

        public FetchVideosByVideoChannelQueryQEModel() {
            super(2);
        }

        public final void m27277a(String str, ConsistencyTuple consistencyTuple) {
            consistencyTuple.a();
        }

        public final void m27278a(String str, Object obj, boolean z) {
        }

        @Nullable
        private GraphQLObjectType m27273j() {
            if (this.b != null && this.f18583d == null) {
                this.f18583d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
            }
            return this.f18583d;
        }

        @Nullable
        public final ChannelFeedVideoChannelFeedFragmentQEModel m27276a() {
            this.f18584e = (ChannelFeedVideoChannelFeedFragmentQEModel) super.a(this.f18584e, 1, ChannelFeedVideoChannelFeedFragmentQEModel.class);
            return this.f18584e;
        }

        public final int jK_() {
            return 756114472;
        }

        public final GraphQLVisitableModel m27275a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m27276a() != null) {
                ChannelFeedVideoChannelFeedFragmentQEModel channelFeedVideoChannelFeedFragmentQEModel = (ChannelFeedVideoChannelFeedFragmentQEModel) graphQLModelMutatingVisitor.b(m27276a());
                if (m27276a() != channelFeedVideoChannelFeedFragmentQEModel) {
                    graphQLVisitableModel = (FetchVideosByVideoChannelQueryQEModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f18584e = channelFeedVideoChannelFeedFragmentQEModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m27274a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m27273j());
            int a2 = ModelHelper.a(flatBufferBuilder, m27276a());
            flatBufferBuilder.c(2);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, a2);
            i();
            return flatBufferBuilder.d();
        }
    }
}
