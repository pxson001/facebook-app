package com.facebook.api.graphql.gametime;

import com.facebook.api.graphql.gametime.GametimeFanFavoriteUpdateVotesParsers.FBGametimeFanFavoriteUpdateVotesParser;
import com.facebook.api.graphql.gametime.GametimeFanFavoriteUpdateVotesParsers.FBGametimeFanFavoriteUpdateVotesParser.MediaQuestionParser;
import com.facebook.api.graphql.gametime.GametimeFanFavoriteUpdateVotesParsers.FBGametimeFanFavoriteUpdateVotesParser.MediaQuestionParser.MediaQuestionOptionOrderParser;
import com.facebook.api.graphql.gametime.GametimeFanFavoriteUpdateVotesParsers.FBGametimeFanFavoriteUpdateVotesParser.MediaQuestionParser.MediaQuestionOptionOrderParser.EdgesParser;
import com.facebook.api.graphql.gametime.GametimeFanFavoriteUpdateVotesParsers.FBGametimeFanFavoriteUpdateVotesParser.MediaQuestionParser.MediaQuestionOptionOrderParser.EdgesParser.NodeParser;
import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbSerializerProvider;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.FragmentModelWithoutBridge;
import com.facebook.flatbuffers.ModelWithFlatBufferFormatHash;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.ModelHelper;
import com.facebook.graphql.visitor.ConsistencyTuple;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLVisitableConsistentModel;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.facebook.vault.momentsupsell.graphql.MomentsUpsellQueryParsers.MomentsAppPromotionQueryParser;
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

/* compiled from: last4 */
public class GametimeFanFavoriteUpdateVotesModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -192713006)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: last4 */
    public final class FBGametimeFanFavoriteUpdateVotesModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private MediaQuestionModel f10430d;

        /* compiled from: last4 */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(FBGametimeFanFavoriteUpdateVotesModel.class, new Deserializer());
            }

            public Object m12221a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = FBGametimeFanFavoriteUpdateVotesParser.m12259a(jsonParser);
                Object fBGametimeFanFavoriteUpdateVotesModel = new FBGametimeFanFavoriteUpdateVotesModel();
                ((BaseModel) fBGametimeFanFavoriteUpdateVotesModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (fBGametimeFanFavoriteUpdateVotesModel instanceof Postprocessable) {
                    return ((Postprocessable) fBGametimeFanFavoriteUpdateVotesModel).a();
                }
                return fBGametimeFanFavoriteUpdateVotesModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 52069349)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: last4 */
        public final class MediaQuestionModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private MediaQuestionOptionOrderModel f10429d;

            /* compiled from: last4 */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(MediaQuestionModel.class, new Deserializer());
                }

                public Object m12222a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(MediaQuestionParser.m12257a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object mediaQuestionModel = new MediaQuestionModel();
                    ((BaseModel) mediaQuestionModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (mediaQuestionModel instanceof Postprocessable) {
                        return ((Postprocessable) mediaQuestionModel).a();
                    }
                    return mediaQuestionModel;
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = -1118776740)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: last4 */
            public final class MediaQuestionOptionOrderModel extends BaseModel implements GraphQLVisitableModel {
                @Nullable
                private List<EdgesModel> f10428d;

                /* compiled from: last4 */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(MediaQuestionOptionOrderModel.class, new Deserializer());
                    }

                    public Object m12223a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(MediaQuestionOptionOrderParser.m12255a(jsonParser, flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        mutableFlatBuffer.a(4, Boolean.valueOf(true));
                        MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                        Object mediaQuestionOptionOrderModel = new MediaQuestionOptionOrderModel();
                        ((BaseModel) mediaQuestionOptionOrderModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                        if (mediaQuestionOptionOrderModel instanceof Postprocessable) {
                            return ((Postprocessable) mediaQuestionOptionOrderModel).a();
                        }
                        return mediaQuestionOptionOrderModel;
                    }
                }

                @JsonDeserialize(using = Deserializer.class)
                @ModelWithFlatBufferFormatHash(a = -1158021960)
                @JsonSerialize(using = Serializer.class)
                @FragmentModelWithoutBridge
                /* compiled from: last4 */
                public final class EdgesModel extends BaseModel implements GraphQLVisitableModel {
                    @Nullable
                    private NodeModel f10427d;

                    /* compiled from: last4 */
                    public class Deserializer extends FbJsonDeserializer {
                        static {
                            GlobalAutoGenDeserializerCache.a(EdgesModel.class, new Deserializer());
                        }

                        public Object m12224a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(EdgesParser.m12254b(jsonParser, flatBufferBuilder));
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
                    @ModelWithFlatBufferFormatHash(a = -2062767038)
                    @JsonSerialize(using = Serializer.class)
                    @FragmentModelWithoutBridge
                    /* compiled from: last4 */
                    public final class NodeModel extends BaseModel implements GraphQLVisitableConsistentModel {
                        private boolean f10425d;
                        private int f10426e;

                        /* compiled from: last4 */
                        public class Deserializer extends FbJsonDeserializer {
                            static {
                                GlobalAutoGenDeserializerCache.a(NodeModel.class, new Deserializer());
                            }

                            public Object m12225a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                flatBufferBuilder.d(NodeParser.m12252a(jsonParser, flatBufferBuilder));
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

                        /* compiled from: last4 */
                        public class Serializer extends JsonSerializer<NodeModel> {
                            public final void m12226a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                                NodeModel nodeModel = (NodeModel) obj;
                                if (nodeModel.w_() == null) {
                                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                    flatBufferBuilder.d(nodeModel.m12231a(flatBufferBuilder));
                                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                    wrap.position(0);
                                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                    nodeModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                                }
                                NodeParser.m12253a(nodeModel.w_(), nodeModel.u_(), jsonGenerator);
                            }

                            static {
                                FbSerializerProvider.a(NodeModel.class, new Serializer());
                            }
                        }

                        public NodeModel() {
                            super(2);
                        }

                        public final void m12234a(String str, ConsistencyTuple consistencyTuple) {
                            if ("viewer_has_chosen".equals(str)) {
                                consistencyTuple.a = Boolean.valueOf(m12229a());
                                consistencyTuple.b = u_();
                                consistencyTuple.c = 0;
                            } else if ("vote_count".equals(str)) {
                                consistencyTuple.a = Integer.valueOf(m12230j());
                                consistencyTuple.b = u_();
                                consistencyTuple.c = 1;
                            } else {
                                consistencyTuple.a();
                            }
                        }

                        public final void m12235a(String str, Object obj, boolean z) {
                            if ("viewer_has_chosen".equals(str)) {
                                m12228a(((Boolean) obj).booleanValue());
                            } else if ("vote_count".equals(str)) {
                                m12227a(((Integer) obj).intValue());
                            }
                        }

                        private boolean m12229a() {
                            a(0, 0);
                            return this.f10425d;
                        }

                        private void m12228a(boolean z) {
                            this.f10425d = z;
                            if (this.b != null && this.b.d) {
                                this.b.a(this.c, 0, z);
                            }
                        }

                        private int m12230j() {
                            a(0, 1);
                            return this.f10426e;
                        }

                        private void m12227a(int i) {
                            this.f10426e = i;
                            if (this.b != null && this.b.d) {
                                this.b.b(this.c, 1, i);
                            }
                        }

                        public final int jK_() {
                            return -1239871265;
                        }

                        public final GraphQLVisitableModel m12232a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                            h();
                            i();
                            return this;
                        }

                        public final int m12231a(FlatBufferBuilder flatBufferBuilder) {
                            h();
                            flatBufferBuilder.c(2);
                            flatBufferBuilder.a(0, this.f10425d);
                            flatBufferBuilder.a(1, this.f10426e, 0);
                            i();
                            return flatBufferBuilder.d();
                        }

                        public final void m12233a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                            super.a(mutableFlatBuffer, i, obj);
                            this.f10425d = mutableFlatBuffer.a(i, 0);
                            this.f10426e = mutableFlatBuffer.a(i, 1, 0);
                        }
                    }

                    /* compiled from: last4 */
                    public class Serializer extends JsonSerializer<EdgesModel> {
                        public final void m12236a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                            EdgesModel edgesModel = (EdgesModel) obj;
                            if (edgesModel.w_() == null) {
                                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                flatBufferBuilder.d(edgesModel.m12238a(flatBufferBuilder));
                                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                wrap.position(0);
                                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                edgesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                            }
                            MomentsAppPromotionQueryParser.b(edgesModel.w_(), edgesModel.u_(), jsonGenerator, serializerProvider);
                        }

                        static {
                            FbSerializerProvider.a(EdgesModel.class, new Serializer());
                        }
                    }

                    public EdgesModel() {
                        super(1);
                    }

                    @Nullable
                    private NodeModel m12237a() {
                        this.f10427d = (NodeModel) super.a(this.f10427d, 0, NodeModel.class);
                        return this.f10427d;
                    }

                    public final int jK_() {
                        return 34542417;
                    }

                    public final GraphQLVisitableModel m12239a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                        GraphQLVisitableModel graphQLVisitableModel = null;
                        h();
                        if (m12237a() != null) {
                            NodeModel nodeModel = (NodeModel) graphQLModelMutatingVisitor.b(m12237a());
                            if (m12237a() != nodeModel) {
                                graphQLVisitableModel = (EdgesModel) ModelHelper.a(null, this);
                                graphQLVisitableModel.f10427d = nodeModel;
                            }
                        }
                        i();
                        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                    }

                    public final int m12238a(FlatBufferBuilder flatBufferBuilder) {
                        h();
                        int a = ModelHelper.a(flatBufferBuilder, m12237a());
                        flatBufferBuilder.c(1);
                        flatBufferBuilder.b(0, a);
                        i();
                        return flatBufferBuilder.d();
                    }
                }

                /* compiled from: last4 */
                public class Serializer extends JsonSerializer<MediaQuestionOptionOrderModel> {
                    public final void m12240a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        MediaQuestionOptionOrderModel mediaQuestionOptionOrderModel = (MediaQuestionOptionOrderModel) obj;
                        if (mediaQuestionOptionOrderModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(mediaQuestionOptionOrderModel.m12242a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            mediaQuestionOptionOrderModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        MediaQuestionOptionOrderParser.m12256a(mediaQuestionOptionOrderModel.w_(), mediaQuestionOptionOrderModel.u_(), jsonGenerator, serializerProvider);
                    }

                    static {
                        FbSerializerProvider.a(MediaQuestionOptionOrderModel.class, new Serializer());
                    }
                }

                public MediaQuestionOptionOrderModel() {
                    super(1);
                }

                @Nonnull
                private ImmutableList<EdgesModel> m12241a() {
                    this.f10428d = super.a(this.f10428d, 0, EdgesModel.class);
                    return (ImmutableList) this.f10428d;
                }

                public final int jK_() {
                    return -1448172174;
                }

                public final GraphQLVisitableModel m12243a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    GraphQLVisitableModel graphQLVisitableModel = null;
                    h();
                    if (m12241a() != null) {
                        Builder a = ModelHelper.a(m12241a(), graphQLModelMutatingVisitor);
                        if (a != null) {
                            graphQLVisitableModel = (MediaQuestionOptionOrderModel) ModelHelper.a(null, this);
                            graphQLVisitableModel.f10428d = a.b();
                        }
                    }
                    i();
                    return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                }

                public final int m12242a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int a = ModelHelper.a(flatBufferBuilder, m12241a());
                    flatBufferBuilder.c(1);
                    flatBufferBuilder.b(0, a);
                    i();
                    return flatBufferBuilder.d();
                }
            }

            /* compiled from: last4 */
            public class Serializer extends JsonSerializer<MediaQuestionModel> {
                public final void m12244a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    MediaQuestionModel mediaQuestionModel = (MediaQuestionModel) obj;
                    if (mediaQuestionModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(mediaQuestionModel.m12246a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        mediaQuestionModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    MediaQuestionParser.m12258a(mediaQuestionModel.w_(), mediaQuestionModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(MediaQuestionModel.class, new Serializer());
                }
            }

            public MediaQuestionModel() {
                super(1);
            }

            @Nullable
            private MediaQuestionOptionOrderModel m12245a() {
                this.f10429d = (MediaQuestionOptionOrderModel) super.a(this.f10429d, 0, MediaQuestionOptionOrderModel.class);
                return this.f10429d;
            }

            public final int jK_() {
                return 239016906;
            }

            public final GraphQLVisitableModel m12247a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m12245a() != null) {
                    MediaQuestionOptionOrderModel mediaQuestionOptionOrderModel = (MediaQuestionOptionOrderModel) graphQLModelMutatingVisitor.b(m12245a());
                    if (m12245a() != mediaQuestionOptionOrderModel) {
                        graphQLVisitableModel = (MediaQuestionModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f10429d = mediaQuestionOptionOrderModel;
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m12246a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m12245a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, a);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: last4 */
        public class Serializer extends JsonSerializer<FBGametimeFanFavoriteUpdateVotesModel> {
            public final void m12248a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                FBGametimeFanFavoriteUpdateVotesModel fBGametimeFanFavoriteUpdateVotesModel = (FBGametimeFanFavoriteUpdateVotesModel) obj;
                if (fBGametimeFanFavoriteUpdateVotesModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(fBGametimeFanFavoriteUpdateVotesModel.m12250a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    fBGametimeFanFavoriteUpdateVotesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = fBGametimeFanFavoriteUpdateVotesModel.w_();
                int u_ = fBGametimeFanFavoriteUpdateVotesModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("media_question");
                    MediaQuestionParser.m12258a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(FBGametimeFanFavoriteUpdateVotesModel.class, new Serializer());
            }
        }

        public FBGametimeFanFavoriteUpdateVotesModel() {
            super(1);
        }

        @Nullable
        private MediaQuestionModel m12249a() {
            this.f10430d = (MediaQuestionModel) super.a(this.f10430d, 0, MediaQuestionModel.class);
            return this.f10430d;
        }

        public final int jK_() {
            return 825807820;
        }

        public final GraphQLVisitableModel m12251a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m12249a() != null) {
                MediaQuestionModel mediaQuestionModel = (MediaQuestionModel) graphQLModelMutatingVisitor.b(m12249a());
                if (m12249a() != mediaQuestionModel) {
                    graphQLVisitableModel = (FBGametimeFanFavoriteUpdateVotesModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f10430d = mediaQuestionModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m12250a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m12249a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }
}
