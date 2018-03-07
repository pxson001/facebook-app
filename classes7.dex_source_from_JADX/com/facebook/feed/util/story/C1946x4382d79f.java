package com.facebook.feed.util.story;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbSerializerProvider;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.feed.util.story.FeedStoryUtilGraphQLParsers.ShouldDisplayProfilePictureGraphQLParser.AllSubstoriesParser;
import com.facebook.feed.util.story.FeedStoryUtilGraphQLParsers.ShouldDisplayProfilePictureGraphQLParser.AllSubstoriesParser.NodesParser;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.FragmentModelWithoutBridge;
import com.facebook.flatbuffers.ModelWithFlatBufferFormatHash;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.ModelHelper;
import com.facebook.graphql.story.util.GraphQLStoryUtilGraphQLInterfaces.ShouldDisplaySubStoryGalleryGraphQL.AllSubstories;
import com.facebook.graphql.story.util.GraphQLStoryUtilGraphQLInterfaces.ShouldDisplaySubStoryGalleryGraphQL.AllSubstories.Nodes;
import com.facebook.graphql.story.util.GraphQLStoryUtilGraphQLModels.ShouldDisplaySubStoryGalleryGraphQLModel.AllSubstoriesModel.NodesModel.AttachmentsModel;
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
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import java.nio.ByteBuffer;
import java.util.List;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

@JsonDeserialize(using = Deserializer.class)
@ModelWithFlatBufferFormatHash(a = -1600970972)
@JsonSerialize(using = Serializer.class)
@FragmentModelWithoutBridge
/* compiled from: TQUERY_CONSTRUCTION_PARAM; */
public final class C1946x4382d79f extends BaseModel implements AllSubstories, GraphQLVisitableModel {
    @Nullable
    private List<NodesModel> f22503d;

    /* compiled from: TQUERY_CONSTRUCTION_PARAM; */
    public class Deserializer extends FbJsonDeserializer {
        static {
            GlobalAutoGenDeserializerCache.a(C1946x4382d79f.class, new Deserializer());
        }

        public Object m25125a(JsonParser jsonParser, DeserializationContext deserializationContext) {
            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
            flatBufferBuilder.d(AllSubstoriesParser.m25199a(jsonParser, flatBufferBuilder));
            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
            wrap.position(0);
            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
            mutableFlatBuffer.a(4, Boolean.valueOf(true));
            MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
            Object c1946x4382d79f = new C1946x4382d79f();
            ((BaseModel) c1946x4382d79f).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
            if (c1946x4382d79f instanceof Postprocessable) {
                return ((Postprocessable) c1946x4382d79f).a();
            }
            return c1946x4382d79f;
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -1523022692)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: TQUERY_CONSTRUCTION_PARAM; */
    public final class NodesModel extends BaseModel implements Nodes, GraphQLPersistableNode, GraphQLVisitableConsistentModel {
        @Nullable
        private List<AttachmentsModel> f22501d;
        @Nullable
        private String f22502e;

        /* compiled from: TQUERY_CONSTRUCTION_PARAM; */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(NodesModel.class, new Deserializer());
            }

            public Object m25126a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(NodesParser.m25197b(jsonParser, flatBufferBuilder));
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

        /* compiled from: TQUERY_CONSTRUCTION_PARAM; */
        public class Serializer extends JsonSerializer<NodesModel> {
            public final void m25127a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                NodesModel nodesModel = (NodesModel) obj;
                if (nodesModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(nodesModel.m25129a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    nodesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                NodesParser.m25198b(nodesModel.w_(), nodesModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(NodesModel.class, new Serializer());
            }
        }

        public NodesModel() {
            super(2);
        }

        public final void m25132a(String str, ConsistencyTuple consistencyTuple) {
            consistencyTuple.a();
        }

        public final void m25133a(String str, Object obj, boolean z) {
        }

        @Nonnull
        public final ImmutableList<AttachmentsModel> m25134b() {
            this.f22501d = super.a(this.f22501d, 0, AttachmentsModel.class);
            return (ImmutableList) this.f22501d;
        }

        @Nullable
        private String m25128j() {
            this.f22502e = super.a(this.f22502e, 1);
            return this.f22502e;
        }

        @Nullable
        public final String m25131a() {
            return m25128j();
        }

        public final int jK_() {
            return 80218325;
        }

        public final GraphQLVisitableModel m25130a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m25134b() != null) {
                Builder a = ModelHelper.a(m25134b(), graphQLModelMutatingVisitor);
                if (a != null) {
                    graphQLVisitableModel = (NodesModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f22501d = a.b();
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m25129a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m25134b());
            int b = flatBufferBuilder.b(m25128j());
            flatBufferBuilder.c(2);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, b);
            i();
            return flatBufferBuilder.d();
        }
    }

    /* compiled from: TQUERY_CONSTRUCTION_PARAM; */
    public class Serializer extends JsonSerializer<C1946x4382d79f> {
        public final void m25135a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            C1946x4382d79f c1946x4382d79f = (C1946x4382d79f) obj;
            if (c1946x4382d79f.w_() == null) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(c1946x4382d79f.m25136a(flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                c1946x4382d79f.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
            }
            AllSubstoriesParser.m25200a(c1946x4382d79f.w_(), c1946x4382d79f.u_(), jsonGenerator, serializerProvider);
        }

        static {
            FbSerializerProvider.a(C1946x4382d79f.class, new Serializer());
        }
    }

    public C1946x4382d79f() {
        super(1);
    }

    @Nonnull
    public final ImmutableList<NodesModel> m25138a() {
        this.f22503d = super.a(this.f22503d, 0, NodesModel.class);
        return (ImmutableList) this.f22503d;
    }

    public final int jK_() {
        return 1571057009;
    }

    public final GraphQLVisitableModel m25137a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        GraphQLVisitableModel graphQLVisitableModel = null;
        h();
        if (m25138a() != null) {
            Builder a = ModelHelper.a(m25138a(), graphQLModelMutatingVisitor);
            if (a != null) {
                graphQLVisitableModel = (C1946x4382d79f) ModelHelper.a(null, this);
                graphQLVisitableModel.f22503d = a.b();
            }
        }
        i();
        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
    }

    public final int m25136a(FlatBufferBuilder flatBufferBuilder) {
        h();
        int a = ModelHelper.a(flatBufferBuilder, m25138a());
        flatBufferBuilder.c(1);
        flatBufferBuilder.b(0, a);
        i();
        return flatBufferBuilder.d();
    }
}
