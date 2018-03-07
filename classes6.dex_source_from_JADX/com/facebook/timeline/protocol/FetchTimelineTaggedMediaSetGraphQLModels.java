package com.facebook.timeline.protocol;

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
import com.facebook.graphql.visitor.ConsistencyTuple;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLPersistableNode;
import com.facebook.graphql.visitor.GraphQLVisitableConsistentModel;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.facebook.timeline.protocol.FetchTimelineTaggedMediaSetGraphQLParsers.TimelineTaggedMediaSetFieldsParser;
import com.facebook.timeline.protocol.FetchTimelineTaggedMediaSetGraphQLParsers.TimelineTaggedMediaSetFieldsParser.MediaParser;
import com.facebook.timeline.protocol.FetchTimelineTaggedMediaSetGraphQLParsers.TimelineTaggedMediaSetFieldsParser.MediaParser.NodesParser;
import com.facebook.timeline.protocol.FetchTimelineTaggedMediaSetGraphQLParsers.TimelineTaggedMediaSetQueryParser;
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

/* compiled from: deduper */
public class FetchTimelineTaggedMediaSetGraphQLModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -1925185219)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: deduper */
    public final class TimelineTaggedMediaSetFieldsModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private MediaModel f17839d;

        /* compiled from: deduper */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(TimelineTaggedMediaSetFieldsModel.class, new Deserializer());
            }

            public Object m26190a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(TimelineTaggedMediaSetFieldsParser.m26219a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object timelineTaggedMediaSetFieldsModel = new TimelineTaggedMediaSetFieldsModel();
                ((BaseModel) timelineTaggedMediaSetFieldsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (timelineTaggedMediaSetFieldsModel instanceof Postprocessable) {
                    return ((Postprocessable) timelineTaggedMediaSetFieldsModel).a();
                }
                return timelineTaggedMediaSetFieldsModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 2008804169)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: deduper */
        public final class MediaModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private List<NodesModel> f17838d;

            /* compiled from: deduper */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(MediaModel.class, new Deserializer());
                }

                public Object m26191a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(MediaParser.m26217a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object mediaModel = new MediaModel();
                    ((BaseModel) mediaModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (mediaModel instanceof Postprocessable) {
                        return ((Postprocessable) mediaModel).a();
                    }
                    return mediaModel;
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = -1787905591)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: deduper */
            public final class NodesModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableModel {
                @Nullable
                private GraphQLObjectType f17836d;
                @Nullable
                private String f17837e;

                /* compiled from: deduper */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(NodesModel.class, new Deserializer());
                    }

                    public Object m26192a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(NodesParser.m26216b(jsonParser, flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        mutableFlatBuffer.a(4, Boolean.valueOf(true));
                        MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                        Object nodesModel = new NodesModel();
                        ((BaseModel) nodesModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                        if (nodesModel instanceof Postprocessable) {
                            return ((Postprocessable) nodesModel).a();
                        }
                        return nodesModel;
                    }
                }

                /* compiled from: deduper */
                public class Serializer extends JsonSerializer<NodesModel> {
                    public final void m26193a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        NodesModel nodesModel = (NodesModel) obj;
                        if (nodesModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(nodesModel.m26196a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            nodesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        NodesParser.m26215a(nodesModel.w_(), nodesModel.u_(), jsonGenerator);
                    }

                    static {
                        FbSerializerProvider.a(NodesModel.class, new Serializer());
                    }
                }

                public NodesModel() {
                    super(2);
                }

                @Nullable
                private GraphQLObjectType m26194j() {
                    if (this.b != null && this.f17836d == null) {
                        this.f17836d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
                    }
                    return this.f17836d;
                }

                @Nullable
                private String m26195k() {
                    this.f17837e = super.a(this.f17837e, 1);
                    return this.f17837e;
                }

                @Nullable
                public final String m26198a() {
                    return m26195k();
                }

                public final int jK_() {
                    return 74219460;
                }

                public final GraphQLVisitableModel m26197a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    h();
                    i();
                    return this;
                }

                public final int m26196a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int a = ModelHelper.a(flatBufferBuilder, m26194j());
                    int b = flatBufferBuilder.b(m26195k());
                    flatBufferBuilder.c(2);
                    flatBufferBuilder.b(0, a);
                    flatBufferBuilder.b(1, b);
                    i();
                    return flatBufferBuilder.d();
                }
            }

            /* compiled from: deduper */
            public class Serializer extends JsonSerializer<MediaModel> {
                public final void m26199a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    MediaModel mediaModel = (MediaModel) obj;
                    if (mediaModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(mediaModel.m26200a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        mediaModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    MediaParser.m26218a(mediaModel.w_(), mediaModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(MediaModel.class, new Serializer());
                }
            }

            public MediaModel() {
                super(1);
            }

            @Nonnull
            public final ImmutableList<NodesModel> m26202a() {
                this.f17838d = super.a(this.f17838d, 0, NodesModel.class);
                return (ImmutableList) this.f17838d;
            }

            public final int jK_() {
                return 747633668;
            }

            public final GraphQLVisitableModel m26201a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m26202a() != null) {
                    Builder a = ModelHelper.a(m26202a(), graphQLModelMutatingVisitor);
                    if (a != null) {
                        graphQLVisitableModel = (MediaModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f17838d = a.b();
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m26200a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m26202a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, a);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: deduper */
        public class Serializer extends JsonSerializer<TimelineTaggedMediaSetFieldsModel> {
            public final void m26203a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                TimelineTaggedMediaSetFieldsModel timelineTaggedMediaSetFieldsModel = (TimelineTaggedMediaSetFieldsModel) obj;
                if (timelineTaggedMediaSetFieldsModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(timelineTaggedMediaSetFieldsModel.m26205a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    timelineTaggedMediaSetFieldsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                TimelineTaggedMediaSetFieldsParser.m26220a(timelineTaggedMediaSetFieldsModel.w_(), timelineTaggedMediaSetFieldsModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(TimelineTaggedMediaSetFieldsModel.class, new Serializer());
            }
        }

        @Nullable
        public final /* synthetic */ MediaModel m26207a() {
            return m26204j();
        }

        public TimelineTaggedMediaSetFieldsModel() {
            super(1);
        }

        @Nullable
        private MediaModel m26204j() {
            this.f17839d = (MediaModel) super.a(this.f17839d, 0, MediaModel.class);
            return this.f17839d;
        }

        public final int jK_() {
            return 685632024;
        }

        public final GraphQLVisitableModel m26206a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m26204j() != null) {
                MediaModel mediaModel = (MediaModel) graphQLModelMutatingVisitor.b(m26204j());
                if (m26204j() != mediaModel) {
                    graphQLVisitableModel = (TimelineTaggedMediaSetFieldsModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f17839d = mediaModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m26205a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m26204j());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -1733575470)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: deduper */
    public final class TimelineTaggedMediaSetQueryModel extends BaseModel implements GraphQLVisitableConsistentModel {
        @Nullable
        private TimelineTaggedMediaSetFieldsModel f17840d;

        /* compiled from: deduper */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(TimelineTaggedMediaSetQueryModel.class, new Deserializer());
            }

            public Object m26208a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = TimelineTaggedMediaSetQueryParser.m26221a(jsonParser);
                Object timelineTaggedMediaSetQueryModel = new TimelineTaggedMediaSetQueryModel();
                ((BaseModel) timelineTaggedMediaSetQueryModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (timelineTaggedMediaSetQueryModel instanceof Postprocessable) {
                    return ((Postprocessable) timelineTaggedMediaSetQueryModel).a();
                }
                return timelineTaggedMediaSetQueryModel;
            }
        }

        /* compiled from: deduper */
        public class Serializer extends JsonSerializer<TimelineTaggedMediaSetQueryModel> {
            public final void m26209a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                TimelineTaggedMediaSetQueryModel timelineTaggedMediaSetQueryModel = (TimelineTaggedMediaSetQueryModel) obj;
                if (timelineTaggedMediaSetQueryModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(timelineTaggedMediaSetQueryModel.m26210a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    timelineTaggedMediaSetQueryModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = timelineTaggedMediaSetQueryModel.w_();
                int u_ = timelineTaggedMediaSetQueryModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("tagged_mediaset");
                    TimelineTaggedMediaSetFieldsParser.m26220a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(TimelineTaggedMediaSetQueryModel.class, new Serializer());
            }
        }

        public TimelineTaggedMediaSetQueryModel() {
            super(1);
        }

        public final void m26213a(String str, ConsistencyTuple consistencyTuple) {
            consistencyTuple.a();
        }

        public final void m26214a(String str, Object obj, boolean z) {
        }

        @Nullable
        public final TimelineTaggedMediaSetFieldsModel m26212a() {
            this.f17840d = (TimelineTaggedMediaSetFieldsModel) super.a(this.f17840d, 0, TimelineTaggedMediaSetFieldsModel.class);
            return this.f17840d;
        }

        public final int jK_() {
            return 2645995;
        }

        public final GraphQLVisitableModel m26211a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m26212a() != null) {
                TimelineTaggedMediaSetFieldsModel timelineTaggedMediaSetFieldsModel = (TimelineTaggedMediaSetFieldsModel) graphQLModelMutatingVisitor.b(m26212a());
                if (m26212a() != timelineTaggedMediaSetFieldsModel) {
                    graphQLVisitableModel = (TimelineTaggedMediaSetQueryModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f17840d = timelineTaggedMediaSetFieldsModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m26210a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m26212a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }
}
