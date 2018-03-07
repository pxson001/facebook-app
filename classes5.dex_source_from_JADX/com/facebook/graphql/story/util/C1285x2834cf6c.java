package com.facebook.graphql.story.util;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbSerializerProvider;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.FragmentModelWithoutBridge;
import com.facebook.flatbuffers.ModelWithFlatBufferFormatHash;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.enums.GraphQLStoryAttachmentStyle;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.ModelHelper;
import com.facebook.graphql.story.util.C1283x1b3e5f1c.Nodes;
import com.facebook.graphql.story.util.GraphQLStoryUtilGraphQLInterfaces.HasFeedbackTargetOfTypeGraphQL;
import com.facebook.graphql.story.util.GraphQLStoryUtilGraphQLModels.HasFeedbackTargetOfTypeGraphQLModel.TargetModel;
import com.facebook.graphql.story.util.GraphQLStoryUtilGraphQLParsers.ShouldDisplaySubStoryGalleryGraphQLParser.AllSubstoriesParser;
import com.facebook.graphql.story.util.GraphQLStoryUtilGraphQLParsers.ShouldDisplaySubStoryGalleryGraphQLParser.AllSubstoriesParser.NodesParser;
import com.facebook.graphql.story.util.GraphQLStoryUtilGraphQLParsers.ShouldDisplaySubStoryGalleryGraphQLParser.AllSubstoriesParser.NodesParser.AttachmentsParser;
import com.facebook.graphql.visitor.ConsistencyTuple;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
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
@ModelWithFlatBufferFormatHash(a = -1683779753)
@JsonSerialize(using = Serializer.class)
@FragmentModelWithoutBridge
/* compiled from: TRIGHT;TKEY;>; */
public final class C1285x2834cf6c extends BaseModel implements C1283x1b3e5f1c, GraphQLVisitableModel {
    @Nullable
    private List<NodesModel> f13510d;

    /* compiled from: TRIGHT;TKEY;>; */
    public class Deserializer extends FbJsonDeserializer {
        static {
            GlobalAutoGenDeserializerCache.a(C1285x2834cf6c.class, new Deserializer());
        }

        public Object m22675a(JsonParser jsonParser, DeserializationContext deserializationContext) {
            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
            flatBufferBuilder.d(AllSubstoriesParser.m22707a(jsonParser, flatBufferBuilder));
            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
            wrap.position(0);
            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
            mutableFlatBuffer.a(4, Boolean.valueOf(true));
            MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
            Object c1285x2834cf6c = new C1285x2834cf6c();
            ((BaseModel) c1285x2834cf6c).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
            if (c1285x2834cf6c instanceof Postprocessable) {
                return ((Postprocessable) c1285x2834cf6c).a();
            }
            return c1285x2834cf6c;
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -1540619672)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: TRIGHT;TKEY;>; */
    public final class NodesModel extends BaseModel implements Nodes, GraphQLVisitableConsistentModel {
        @Nullable
        private List<AttachmentsModel> f13509d;

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 1578815349)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: TRIGHT;TKEY;>; */
        public final class AttachmentsModel extends BaseModel implements HasFeedbackTargetOfTypeGraphQL, GraphQLVisitableModel {
            @Nullable
            private List<GraphQLStoryAttachmentStyle> f13507d;
            @Nullable
            private TargetModel f13508e;

            /* compiled from: TRIGHT;TKEY;>; */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(AttachmentsModel.class, new Deserializer());
                }

                public Object m22676a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(AttachmentsParser.m22703b(jsonParser, flatBufferBuilder));
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

            /* compiled from: TRIGHT;TKEY;>; */
            public class Serializer extends JsonSerializer<AttachmentsModel> {
                public final void m22677a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    AttachmentsModel attachmentsModel = (AttachmentsModel) obj;
                    if (attachmentsModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(attachmentsModel.m22679a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        attachmentsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    AttachmentsParser.m22704b(attachmentsModel.w_(), attachmentsModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(AttachmentsModel.class, new Serializer());
                }
            }

            @Nullable
            public final /* synthetic */ TargetModel mo1234a() {
                return m22678j();
            }

            public AttachmentsModel() {
                super(2);
            }

            @Nonnull
            public final ImmutableList<GraphQLStoryAttachmentStyle> m22682b() {
                this.f13507d = super.c(this.f13507d, 0, GraphQLStoryAttachmentStyle.class);
                return (ImmutableList) this.f13507d;
            }

            @Nullable
            private TargetModel m22678j() {
                this.f13508e = (TargetModel) super.a(this.f13508e, 1, TargetModel.class);
                return this.f13508e;
            }

            public final int jK_() {
                return -1267730472;
            }

            public final GraphQLVisitableModel m22681a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m22678j() != null) {
                    TargetModel targetModel = (TargetModel) graphQLModelMutatingVisitor.b(m22678j());
                    if (m22678j() != targetModel) {
                        graphQLVisitableModel = (AttachmentsModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f13508e = targetModel;
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m22679a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int d = flatBufferBuilder.d(m22682b());
                int a = ModelHelper.a(flatBufferBuilder, m22678j());
                flatBufferBuilder.c(2);
                flatBufferBuilder.b(0, d);
                flatBufferBuilder.b(1, a);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: TRIGHT;TKEY;>; */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(NodesModel.class, new Deserializer());
            }

            public Object m22683a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(NodesParser.m22705b(jsonParser, flatBufferBuilder));
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

        /* compiled from: TRIGHT;TKEY;>; */
        public class Serializer extends JsonSerializer<NodesModel> {
            public final void m22684a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                NodesModel nodesModel = (NodesModel) obj;
                if (nodesModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(nodesModel.m22685a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    nodesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                NodesParser.m22706b(nodesModel.w_(), nodesModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(NodesModel.class, new Serializer());
            }
        }

        public NodesModel() {
            super(1);
        }

        public final void m22687a(String str, ConsistencyTuple consistencyTuple) {
            consistencyTuple.a();
        }

        public final void m22688a(String str, Object obj, boolean z) {
        }

        @Nonnull
        public final ImmutableList<AttachmentsModel> mo1235b() {
            this.f13509d = super.a(this.f13509d, 0, AttachmentsModel.class);
            return (ImmutableList) this.f13509d;
        }

        public final int jK_() {
            return 80218325;
        }

        public final GraphQLVisitableModel m22686a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (mo1235b() != null) {
                Builder a = ModelHelper.a(mo1235b(), graphQLModelMutatingVisitor);
                if (a != null) {
                    graphQLVisitableModel = (NodesModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f13509d = a.b();
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m22685a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, mo1235b());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }

    /* compiled from: TRIGHT;TKEY;>; */
    public class Serializer extends JsonSerializer<C1285x2834cf6c> {
        public final void m22690a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            C1285x2834cf6c c1285x2834cf6c = (C1285x2834cf6c) obj;
            if (c1285x2834cf6c.w_() == null) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(c1285x2834cf6c.m22691a(flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                c1285x2834cf6c.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
            }
            AllSubstoriesParser.m22708a(c1285x2834cf6c.w_(), c1285x2834cf6c.u_(), jsonGenerator, serializerProvider);
        }

        static {
            FbSerializerProvider.a(C1285x2834cf6c.class, new Serializer());
        }
    }

    public C1285x2834cf6c() {
        super(1);
    }

    @Nonnull
    public final ImmutableList<NodesModel> mo1236a() {
        this.f13510d = super.a(this.f13510d, 0, NodesModel.class);
        return (ImmutableList) this.f13510d;
    }

    public final int jK_() {
        return 1571057009;
    }

    public final GraphQLVisitableModel m22692a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        GraphQLVisitableModel graphQLVisitableModel = null;
        h();
        if (mo1236a() != null) {
            Builder a = ModelHelper.a(mo1236a(), graphQLModelMutatingVisitor);
            if (a != null) {
                graphQLVisitableModel = (C1285x2834cf6c) ModelHelper.a(null, this);
                graphQLVisitableModel.f13510d = a.b();
            }
        }
        i();
        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
    }

    public final int m22691a(FlatBufferBuilder flatBufferBuilder) {
        h();
        int a = ModelHelper.a(flatBufferBuilder, mo1236a());
        flatBufferBuilder.c(1);
        flatBufferBuilder.b(0, a);
        i();
        return flatBufferBuilder.d();
    }
}
