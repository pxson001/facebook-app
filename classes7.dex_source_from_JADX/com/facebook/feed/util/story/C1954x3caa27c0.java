package com.facebook.feed.util.story;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbSerializerProvider;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.feed.util.story.FeedStoryUtilGraphQLParsers.ShouldRenderOrganicHScrollGraphQLParser.AllSubstoriesParser.NodesParser;
import com.facebook.feed.util.story.FeedStoryUtilGraphQLParsers.ShouldRenderOrganicHScrollGraphQLParser.AllSubstoriesParser.NodesParser.AttachmentsParser;
import com.facebook.feed.util.story.FeedStoryUtilGraphQLParsers.ShouldRenderOrganicHScrollGraphQLParser.AllSubstoriesParser.NodesParser.AttachmentsParser.TargetParser;
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
@ModelWithFlatBufferFormatHash(a = -1941991562)
@JsonSerialize(using = Serializer.class)
@FragmentModelWithoutBridge
/* compiled from: TQUERY_CONSTRUCTION_PARAM; */
public final class C1954x3caa27c0 extends BaseModel implements GraphQLVisitableConsistentModel {
    @Nullable
    private List<AttachmentsModel> f22509d;

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -1247583354)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: TQUERY_CONSTRUCTION_PARAM; */
    public final class AttachmentsModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private TargetModel f22508d;

        /* compiled from: TQUERY_CONSTRUCTION_PARAM; */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(AttachmentsModel.class, new Deserializer());
            }

            public Object m25157a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(AttachmentsParser.m25210b(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object attachmentsModel = new AttachmentsModel();
                ((BaseModel) attachmentsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (attachmentsModel instanceof Postprocessable) {
                    return ((Postprocessable) attachmentsModel).a();
                }
                return attachmentsModel;
            }
        }

        /* compiled from: TQUERY_CONSTRUCTION_PARAM; */
        public class Serializer extends JsonSerializer<AttachmentsModel> {
            public final void m25158a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                AttachmentsModel attachmentsModel = (AttachmentsModel) obj;
                if (attachmentsModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(attachmentsModel.m25169a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    attachmentsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                AttachmentsParser.m25211b(attachmentsModel.w_(), attachmentsModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(AttachmentsModel.class, new Serializer());
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -1787905591)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: TQUERY_CONSTRUCTION_PARAM; */
        public final class TargetModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
            @Nullable
            private GraphQLObjectType f22506d;
            @Nullable
            private String f22507e;

            /* compiled from: TQUERY_CONSTRUCTION_PARAM; */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(TargetModel.class, new Deserializer());
                }

                public Object m25159a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(TargetParser.m25208a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object targetModel = new TargetModel();
                    ((BaseModel) targetModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (targetModel instanceof Postprocessable) {
                        return ((Postprocessable) targetModel).a();
                    }
                    return targetModel;
                }
            }

            /* compiled from: TQUERY_CONSTRUCTION_PARAM; */
            public class Serializer extends JsonSerializer<TargetModel> {
                public final void m25160a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    TargetModel targetModel = (TargetModel) obj;
                    if (targetModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(targetModel.m25163a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        targetModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    TargetParser.m25209a(targetModel.w_(), targetModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(TargetModel.class, new Serializer());
                }
            }

            public TargetModel() {
                super(2);
            }

            public final void m25166a(String str, ConsistencyTuple consistencyTuple) {
                consistencyTuple.a();
            }

            public final void m25167a(String str, Object obj, boolean z) {
            }

            @Nullable
            private GraphQLObjectType m25161j() {
                if (this.b != null && this.f22506d == null) {
                    this.f22506d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
                }
                return this.f22506d;
            }

            @Nullable
            private String m25162k() {
                this.f22507e = super.a(this.f22507e, 1);
                return this.f22507e;
            }

            @Nullable
            public final String m25165a() {
                return m25162k();
            }

            public final int jK_() {
                return 2433570;
            }

            public final GraphQLVisitableModel m25164a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m25163a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m25161j());
                int b = flatBufferBuilder.b(m25162k());
                flatBufferBuilder.c(2);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.b(1, b);
                i();
                return flatBufferBuilder.d();
            }
        }

        public AttachmentsModel() {
            super(1);
        }

        @Nullable
        private TargetModel m25168a() {
            this.f22508d = (TargetModel) super.a(this.f22508d, 0, TargetModel.class);
            return this.f22508d;
        }

        public final int jK_() {
            return -1267730472;
        }

        public final GraphQLVisitableModel m25170a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m25168a() != null) {
                TargetModel targetModel = (TargetModel) graphQLModelMutatingVisitor.b(m25168a());
                if (m25168a() != targetModel) {
                    graphQLVisitableModel = (AttachmentsModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f22508d = targetModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m25169a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m25168a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }

    /* compiled from: TQUERY_CONSTRUCTION_PARAM; */
    public class Deserializer extends FbJsonDeserializer {
        static {
            GlobalAutoGenDeserializerCache.a(C1954x3caa27c0.class, new Deserializer());
        }

        public Object m25171a(JsonParser jsonParser, DeserializationContext deserializationContext) {
            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
            flatBufferBuilder.d(NodesParser.m25212b(jsonParser, flatBufferBuilder));
            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
            wrap.position(0);
            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
            mutableFlatBuffer.a(4, Boolean.valueOf(true));
            MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
            Object c1954x3caa27c0 = new C1954x3caa27c0();
            ((BaseModel) c1954x3caa27c0).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
            if (c1954x3caa27c0 instanceof Postprocessable) {
                return ((Postprocessable) c1954x3caa27c0).a();
            }
            return c1954x3caa27c0;
        }
    }

    /* compiled from: TQUERY_CONSTRUCTION_PARAM; */
    public class Serializer extends JsonSerializer<C1954x3caa27c0> {
        public final void m25172a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            C1954x3caa27c0 c1954x3caa27c0 = (C1954x3caa27c0) obj;
            if (c1954x3caa27c0.w_() == null) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(c1954x3caa27c0.m25173a(flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                c1954x3caa27c0.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
            }
            NodesParser.m25213b(c1954x3caa27c0.w_(), c1954x3caa27c0.u_(), jsonGenerator, serializerProvider);
        }

        static {
            FbSerializerProvider.a(C1954x3caa27c0.class, new Serializer());
        }
    }

    public C1954x3caa27c0() {
        super(1);
    }

    public final void m25176a(String str, ConsistencyTuple consistencyTuple) {
        consistencyTuple.a();
    }

    public final void m25177a(String str, Object obj, boolean z) {
    }

    @Nonnull
    public final ImmutableList<AttachmentsModel> m25175a() {
        this.f22509d = super.a(this.f22509d, 0, AttachmentsModel.class);
        return (ImmutableList) this.f22509d;
    }

    public final int jK_() {
        return 80218325;
    }

    public final GraphQLVisitableModel m25174a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        GraphQLVisitableModel graphQLVisitableModel = null;
        h();
        if (m25175a() != null) {
            Builder a = ModelHelper.a(m25175a(), graphQLModelMutatingVisitor);
            if (a != null) {
                graphQLVisitableModel = (C1954x3caa27c0) ModelHelper.a(null, this);
                graphQLVisitableModel.f22509d = a.b();
            }
        }
        i();
        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
    }

    public final int m25173a(FlatBufferBuilder flatBufferBuilder) {
        h();
        int a = ModelHelper.a(flatBufferBuilder, m25175a());
        flatBufferBuilder.c(1);
        flatBufferBuilder.b(0, a);
        i();
        return flatBufferBuilder.d();
    }
}
