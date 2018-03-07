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
import com.facebook.video.channelfeed.protocol.FetchVideoChannelQueryParsers.ChannelFeedVideoChannelFeedFragmentParser;
import com.facebook.video.channelfeed.protocol.FetchVideoChannelQueryParsers.ChannelFeedVideoChannelFragmentParser;
import com.facebook.video.channelfeed.protocol.FetchVideoChannelQueryParsers.FetchVideoChannelByVideoQueryParser;
import com.facebook.video.channelfeed.protocol.FetchVideoChannelQueryParsers.FetchVideoChannelByVideoQueryParser.OwnerParser;
import com.facebook.video.channelfeed.protocol.FetchVideoChannelQueryParsers.FetchVideosByVideoChannelQueryParser;
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

/* compiled from: contacts_reliability */
public class FetchVideoChannelQueryModels {

    @FragmentModelWithBridge
    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 2120175736)
    @JsonSerialize(using = Serializer.class)
    /* compiled from: contacts_reliability */
    public final class ChannelFeedVideoChannelFeedFragmentModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private List<GraphQLVideoChannelFeedEdge> f18557d;
        @Nullable
        private DefaultPageInfoFieldsModel f18558e;

        /* compiled from: contacts_reliability */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(ChannelFeedVideoChannelFeedFragmentModel.class, new Deserializer());
            }

            public Object m27184a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(ChannelFeedVideoChannelFeedFragmentParser.m27287a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object channelFeedVideoChannelFeedFragmentModel = new ChannelFeedVideoChannelFeedFragmentModel();
                ((BaseModel) channelFeedVideoChannelFeedFragmentModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (channelFeedVideoChannelFeedFragmentModel instanceof Postprocessable) {
                    return ((Postprocessable) channelFeedVideoChannelFeedFragmentModel).a();
                }
                return channelFeedVideoChannelFeedFragmentModel;
            }
        }

        /* compiled from: contacts_reliability */
        public class Serializer extends JsonSerializer<ChannelFeedVideoChannelFeedFragmentModel> {
            public final void m27185a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                ChannelFeedVideoChannelFeedFragmentModel channelFeedVideoChannelFeedFragmentModel = (ChannelFeedVideoChannelFeedFragmentModel) obj;
                if (channelFeedVideoChannelFeedFragmentModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(channelFeedVideoChannelFeedFragmentModel.m27186a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    channelFeedVideoChannelFeedFragmentModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                ChannelFeedVideoChannelFeedFragmentParser.m27288a(channelFeedVideoChannelFeedFragmentModel.w_(), channelFeedVideoChannelFeedFragmentModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(ChannelFeedVideoChannelFeedFragmentModel.class, new Serializer());
            }
        }

        public ChannelFeedVideoChannelFeedFragmentModel() {
            super(2);
        }

        @Nonnull
        public final ImmutableList<GraphQLVideoChannelFeedEdge> m27188a() {
            this.f18557d = super.a(this.f18557d, 0, GraphQLVideoChannelFeedEdge.class);
            return (ImmutableList) this.f18557d;
        }

        @Nullable
        public final DefaultPageInfoFieldsModel m27189j() {
            this.f18558e = (DefaultPageInfoFieldsModel) super.a(this.f18558e, 1, DefaultPageInfoFieldsModel.class);
            return this.f18558e;
        }

        public final int jK_() {
            return -1837884060;
        }

        public final GraphQLVisitableModel m27187a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel;
            DefaultPageInfoFieldsModel defaultPageInfoFieldsModel;
            h();
            if (m27188a() != null) {
                Builder a = ModelHelper.a(m27188a(), graphQLModelMutatingVisitor);
                if (a != null) {
                    ChannelFeedVideoChannelFeedFragmentModel channelFeedVideoChannelFeedFragmentModel = (ChannelFeedVideoChannelFeedFragmentModel) ModelHelper.a(null, this);
                    channelFeedVideoChannelFeedFragmentModel.f18557d = a.b();
                    graphQLVisitableModel = channelFeedVideoChannelFeedFragmentModel;
                    if (m27189j() != null) {
                        defaultPageInfoFieldsModel = (DefaultPageInfoFieldsModel) graphQLModelMutatingVisitor.b(m27189j());
                        if (m27189j() != defaultPageInfoFieldsModel) {
                            graphQLVisitableModel = (ChannelFeedVideoChannelFeedFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                            graphQLVisitableModel.f18558e = defaultPageInfoFieldsModel;
                        }
                    }
                    i();
                    return graphQLVisitableModel != null ? this : graphQLVisitableModel;
                }
            }
            graphQLVisitableModel = null;
            if (m27189j() != null) {
                defaultPageInfoFieldsModel = (DefaultPageInfoFieldsModel) graphQLModelMutatingVisitor.b(m27189j());
                if (m27189j() != defaultPageInfoFieldsModel) {
                    graphQLVisitableModel = (ChannelFeedVideoChannelFeedFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f18558e = defaultPageInfoFieldsModel;
                }
            }
            i();
            if (graphQLVisitableModel != null) {
            }
        }

        public final int m27186a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m27188a());
            int a2 = ModelHelper.a(flatBufferBuilder, m27189j());
            flatBufferBuilder.c(2);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, a2);
            i();
            return flatBufferBuilder.d();
        }
    }

    @FragmentModelWithBridge
    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -10853666)
    @JsonSerialize(using = Serializer.class)
    /* compiled from: contacts_reliability */
    public final class ChannelFeedVideoChannelFragmentModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
        @Nullable
        private GraphQLObjectType f18559d;
        @Nullable
        private String f18560e;
        @Nullable
        private ChannelFeedVideoChannelFeedFragmentModel f18561f;
        @Nullable
        private DefaultTextWithEntitiesFieldsModel f18562g;

        /* compiled from: contacts_reliability */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(ChannelFeedVideoChannelFragmentModel.class, new Deserializer());
            }

            public Object m27190a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(ChannelFeedVideoChannelFragmentParser.m27289a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object channelFeedVideoChannelFragmentModel = new ChannelFeedVideoChannelFragmentModel();
                ((BaseModel) channelFeedVideoChannelFragmentModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (channelFeedVideoChannelFragmentModel instanceof Postprocessable) {
                    return ((Postprocessable) channelFeedVideoChannelFragmentModel).a();
                }
                return channelFeedVideoChannelFragmentModel;
            }
        }

        /* compiled from: contacts_reliability */
        public class Serializer extends JsonSerializer<ChannelFeedVideoChannelFragmentModel> {
            public final void m27191a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                ChannelFeedVideoChannelFragmentModel channelFeedVideoChannelFragmentModel = (ChannelFeedVideoChannelFragmentModel) obj;
                if (channelFeedVideoChannelFragmentModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(channelFeedVideoChannelFragmentModel.m27193a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    channelFeedVideoChannelFragmentModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                ChannelFeedVideoChannelFragmentParser.m27290a(channelFeedVideoChannelFragmentModel.w_(), channelFeedVideoChannelFragmentModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(ChannelFeedVideoChannelFragmentModel.class, new Serializer());
            }
        }

        public ChannelFeedVideoChannelFragmentModel() {
            super(4);
        }

        public final void m27196a(String str, ConsistencyTuple consistencyTuple) {
            consistencyTuple.a();
        }

        public final void m27197a(String str, Object obj, boolean z) {
        }

        @Nullable
        private GraphQLObjectType m27192m() {
            if (this.b != null && this.f18559d == null) {
                this.f18559d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
            }
            return this.f18559d;
        }

        @Nullable
        public final String m27198j() {
            this.f18560e = super.a(this.f18560e, 1);
            return this.f18560e;
        }

        @Nullable
        public final ChannelFeedVideoChannelFeedFragmentModel m27199k() {
            this.f18561f = (ChannelFeedVideoChannelFeedFragmentModel) super.a(this.f18561f, 2, ChannelFeedVideoChannelFeedFragmentModel.class);
            return this.f18561f;
        }

        @Nullable
        public final DefaultTextWithEntitiesFieldsModel m27200l() {
            this.f18562g = (DefaultTextWithEntitiesFieldsModel) super.a(this.f18562g, 3, DefaultTextWithEntitiesFieldsModel.class);
            return this.f18562g;
        }

        @Nullable
        public final String m27195a() {
            return m27198j();
        }

        public final int jK_() {
            return 756114472;
        }

        public final GraphQLVisitableModel m27194a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m27199k() != null) {
                ChannelFeedVideoChannelFeedFragmentModel channelFeedVideoChannelFeedFragmentModel = (ChannelFeedVideoChannelFeedFragmentModel) graphQLModelMutatingVisitor.b(m27199k());
                if (m27199k() != channelFeedVideoChannelFeedFragmentModel) {
                    graphQLVisitableModel = (ChannelFeedVideoChannelFragmentModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f18561f = channelFeedVideoChannelFeedFragmentModel;
                }
            }
            if (m27200l() != null) {
                DefaultTextWithEntitiesFieldsModel defaultTextWithEntitiesFieldsModel = (DefaultTextWithEntitiesFieldsModel) graphQLModelMutatingVisitor.b(m27200l());
                if (m27200l() != defaultTextWithEntitiesFieldsModel) {
                    graphQLVisitableModel = (ChannelFeedVideoChannelFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f18562g = defaultTextWithEntitiesFieldsModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m27193a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m27192m());
            int b = flatBufferBuilder.b(m27198j());
            int a2 = ModelHelper.a(flatBufferBuilder, m27199k());
            int a3 = ModelHelper.a(flatBufferBuilder, m27200l());
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
    @ModelWithFlatBufferFormatHash(a = 765264808)
    @JsonSerialize(using = Serializer.class)
    /* compiled from: contacts_reliability */
    public final class FetchVideoChannelByVideoQueryModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableModel {
        @Nullable
        private String f18566d;
        @Nullable
        private OwnerModel f18567e;
        @Nullable
        private ChannelFeedVideoChannelFragmentModel f18568f;

        /* compiled from: contacts_reliability */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(FetchVideoChannelByVideoQueryModel.class, new Deserializer());
            }

            public Object m27201a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = FetchVideoChannelByVideoQueryParser.m27293a(jsonParser);
                Object fetchVideoChannelByVideoQueryModel = new FetchVideoChannelByVideoQueryModel();
                ((BaseModel) fetchVideoChannelByVideoQueryModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (fetchVideoChannelByVideoQueryModel instanceof Postprocessable) {
                    return ((Postprocessable) fetchVideoChannelByVideoQueryModel).a();
                }
                return fetchVideoChannelByVideoQueryModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 1255661007)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: contacts_reliability */
        public final class OwnerModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
            @Nullable
            private GraphQLObjectType f18563d;
            @Nullable
            private String f18564e;
            @Nullable
            private String f18565f;

            /* compiled from: contacts_reliability */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(OwnerModel.class, new Deserializer());
                }

                public Object m27202a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(OwnerParser.m27291a(jsonParser, flatBufferBuilder));
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

            /* compiled from: contacts_reliability */
            public class Serializer extends JsonSerializer<OwnerModel> {
                public final void m27203a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    OwnerModel ownerModel = (OwnerModel) obj;
                    if (ownerModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(ownerModel.m27207a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        ownerModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    OwnerParser.m27292a(ownerModel.w_(), ownerModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(OwnerModel.class, new Serializer());
                }
            }

            public OwnerModel() {
                super(3);
            }

            public final void m27210a(String str, ConsistencyTuple consistencyTuple) {
                consistencyTuple.a();
            }

            public final void m27211a(String str, Object obj, boolean z) {
            }

            @Nullable
            private GraphQLObjectType m27204j() {
                if (this.b != null && this.f18563d == null) {
                    this.f18563d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
                }
                return this.f18563d;
            }

            @Nullable
            private String m27205k() {
                this.f18564e = super.a(this.f18564e, 1);
                return this.f18564e;
            }

            @Nullable
            private String m27206l() {
                this.f18565f = super.a(this.f18565f, 2);
                return this.f18565f;
            }

            @Nullable
            public final String m27209a() {
                return m27205k();
            }

            public final int jK_() {
                return 63093205;
            }

            public final GraphQLVisitableModel m27208a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m27207a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m27204j());
                int b = flatBufferBuilder.b(m27205k());
                int b2 = flatBufferBuilder.b(m27206l());
                flatBufferBuilder.c(3);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.b(1, b);
                flatBufferBuilder.b(2, b2);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: contacts_reliability */
        public class Serializer extends JsonSerializer<FetchVideoChannelByVideoQueryModel> {
            public final void m27212a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                FetchVideoChannelByVideoQueryModel fetchVideoChannelByVideoQueryModel = (FetchVideoChannelByVideoQueryModel) obj;
                if (fetchVideoChannelByVideoQueryModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(fetchVideoChannelByVideoQueryModel.m27215a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    fetchVideoChannelByVideoQueryModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = fetchVideoChannelByVideoQueryModel.w_();
                int u_ = fetchVideoChannelByVideoQueryModel.u_();
                jsonGenerator.f();
                if (mutableFlatBuffer.g(u_, 0) != 0) {
                    jsonGenerator.a("id");
                    jsonGenerator.b(mutableFlatBuffer.c(u_, 0));
                }
                int g = mutableFlatBuffer.g(u_, 1);
                if (g != 0) {
                    jsonGenerator.a("owner");
                    OwnerParser.m27292a(mutableFlatBuffer, g, jsonGenerator);
                }
                g = mutableFlatBuffer.g(u_, 2);
                if (g != 0) {
                    jsonGenerator.a("video_channel");
                    ChannelFeedVideoChannelFragmentParser.m27290a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(FetchVideoChannelByVideoQueryModel.class, new Serializer());
            }
        }

        public FetchVideoChannelByVideoQueryModel() {
            super(3);
        }

        @Nullable
        private String m27213k() {
            this.f18566d = super.a(this.f18566d, 0);
            return this.f18566d;
        }

        @Nullable
        private OwnerModel m27214l() {
            this.f18567e = (OwnerModel) super.a(this.f18567e, 1, OwnerModel.class);
            return this.f18567e;
        }

        @Nullable
        public final ChannelFeedVideoChannelFragmentModel m27218j() {
            this.f18568f = (ChannelFeedVideoChannelFragmentModel) super.a(this.f18568f, 2, ChannelFeedVideoChannelFragmentModel.class);
            return this.f18568f;
        }

        @Nullable
        public final String m27217a() {
            return m27213k();
        }

        public final int jK_() {
            return 82650203;
        }

        public final GraphQLVisitableModel m27216a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m27214l() != null) {
                OwnerModel ownerModel = (OwnerModel) graphQLModelMutatingVisitor.b(m27214l());
                if (m27214l() != ownerModel) {
                    graphQLVisitableModel = (FetchVideoChannelByVideoQueryModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f18567e = ownerModel;
                }
            }
            if (m27218j() != null) {
                ChannelFeedVideoChannelFragmentModel channelFeedVideoChannelFragmentModel = (ChannelFeedVideoChannelFragmentModel) graphQLModelMutatingVisitor.b(m27218j());
                if (m27218j() != channelFeedVideoChannelFragmentModel) {
                    graphQLVisitableModel = (FetchVideoChannelByVideoQueryModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f18568f = channelFeedVideoChannelFragmentModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m27215a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int b = flatBufferBuilder.b(m27213k());
            int a = ModelHelper.a(flatBufferBuilder, m27214l());
            int a2 = ModelHelper.a(flatBufferBuilder, m27218j());
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
    @ModelWithFlatBufferFormatHash(a = 562139236)
    @JsonSerialize(using = Serializer.class)
    /* compiled from: contacts_reliability */
    public final class FetchVideosByVideoChannelQueryModel extends BaseModel implements GraphQLVisitableConsistentModel {
        @Nullable
        private GraphQLObjectType f18569d;
        @Nullable
        private ChannelFeedVideoChannelFeedFragmentModel f18570e;

        /* compiled from: contacts_reliability */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(FetchVideosByVideoChannelQueryModel.class, new Deserializer());
            }

            public Object m27219a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = FetchVideosByVideoChannelQueryParser.m27294a(jsonParser);
                Object fetchVideosByVideoChannelQueryModel = new FetchVideosByVideoChannelQueryModel();
                ((BaseModel) fetchVideosByVideoChannelQueryModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (fetchVideosByVideoChannelQueryModel instanceof Postprocessable) {
                    return ((Postprocessable) fetchVideosByVideoChannelQueryModel).a();
                }
                return fetchVideosByVideoChannelQueryModel;
            }
        }

        /* compiled from: contacts_reliability */
        public class Serializer extends JsonSerializer<FetchVideosByVideoChannelQueryModel> {
            public final void m27220a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                FetchVideosByVideoChannelQueryModel fetchVideosByVideoChannelQueryModel = (FetchVideosByVideoChannelQueryModel) obj;
                if (fetchVideosByVideoChannelQueryModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(fetchVideosByVideoChannelQueryModel.m27222a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    fetchVideosByVideoChannelQueryModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = fetchVideosByVideoChannelQueryModel.w_();
                int u_ = fetchVideosByVideoChannelQueryModel.u_();
                jsonGenerator.f();
                if (mutableFlatBuffer.g(u_, 0) != 0) {
                    jsonGenerator.a("__type__");
                    SerializerHelpers.b(mutableFlatBuffer, u_, 0, jsonGenerator);
                }
                int g = mutableFlatBuffer.g(u_, 1);
                if (g != 0) {
                    jsonGenerator.a("video_channel_feed");
                    ChannelFeedVideoChannelFeedFragmentParser.m27288a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(FetchVideosByVideoChannelQueryModel.class, new Serializer());
            }
        }

        public FetchVideosByVideoChannelQueryModel() {
            super(2);
        }

        public final void m27225a(String str, ConsistencyTuple consistencyTuple) {
            consistencyTuple.a();
        }

        public final void m27226a(String str, Object obj, boolean z) {
        }

        @Nullable
        private GraphQLObjectType m27221j() {
            if (this.b != null && this.f18569d == null) {
                this.f18569d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
            }
            return this.f18569d;
        }

        @Nullable
        public final ChannelFeedVideoChannelFeedFragmentModel m27224a() {
            this.f18570e = (ChannelFeedVideoChannelFeedFragmentModel) super.a(this.f18570e, 1, ChannelFeedVideoChannelFeedFragmentModel.class);
            return this.f18570e;
        }

        public final int jK_() {
            return 756114472;
        }

        public final GraphQLVisitableModel m27223a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m27224a() != null) {
                ChannelFeedVideoChannelFeedFragmentModel channelFeedVideoChannelFeedFragmentModel = (ChannelFeedVideoChannelFeedFragmentModel) graphQLModelMutatingVisitor.b(m27224a());
                if (m27224a() != channelFeedVideoChannelFeedFragmentModel) {
                    graphQLVisitableModel = (FetchVideosByVideoChannelQueryModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f18570e = channelFeedVideoChannelFeedFragmentModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m27222a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m27221j());
            int a2 = ModelHelper.a(flatBufferBuilder, m27224a());
            flatBufferBuilder.c(2);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, a2);
            i();
            return flatBufferBuilder.d();
        }
    }
}
