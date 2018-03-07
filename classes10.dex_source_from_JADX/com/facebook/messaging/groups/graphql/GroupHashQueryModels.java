package com.facebook.messaging.groups.graphql;

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
import com.facebook.messaging.groups.graphql.GroupHashQueryParsers.GroupThreadInfoQueryParser;
import com.facebook.messaging.groups.graphql.GroupHashQueryParsers.GroupThreadInfoQueryParser.ApprovalRequestsParser;
import com.facebook.messaging.groups.graphql.GroupHashQueryParsers.GroupThreadInfoQueryParser.GroupThreadParticipantsParser;
import com.facebook.messaging.groups.graphql.GroupHashQueryParsers.GroupThreadInfoQueryParser.ImageParser;
import com.facebook.messaging.groups.graphql.GroupHashQueryParsers.GroupThreadInfoQueryParser.ThreadAdminsParser;
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

/* compiled from: show_reaction_units */
public class GroupHashQueryModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 887264148)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: show_reaction_units */
    public final class GroupThreadInfoQueryModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableModel {
        private int f2454d;
        @Nullable
        private ApprovalRequestsModel f2455e;
        @Nullable
        private List<GroupThreadParticipantsModel> f2456f;
        @Nullable
        private String f2457g;
        @Nullable
        private ImageModel f2458h;
        private boolean f2459i;
        @Nullable
        private List<ThreadAdminsModel> f2460j;
        @Nullable
        private String f2461k;

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -1723990064)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: show_reaction_units */
        public final class ApprovalRequestsModel extends BaseModel implements GraphQLVisitableModel {
            private int f2446d;

            /* compiled from: show_reaction_units */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(ApprovalRequestsModel.class, new Deserializer());
                }

                public Object m2376a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(ApprovalRequestsParser.m2416a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object approvalRequestsModel = new ApprovalRequestsModel();
                    ((BaseModel) approvalRequestsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (approvalRequestsModel instanceof Postprocessable) {
                        return ((Postprocessable) approvalRequestsModel).a();
                    }
                    return approvalRequestsModel;
                }
            }

            /* compiled from: show_reaction_units */
            public class Serializer extends JsonSerializer<ApprovalRequestsModel> {
                public final void m2377a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    ApprovalRequestsModel approvalRequestsModel = (ApprovalRequestsModel) obj;
                    if (approvalRequestsModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(approvalRequestsModel.m2378a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        approvalRequestsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    ApprovalRequestsParser.m2417a(approvalRequestsModel.w_(), approvalRequestsModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(ApprovalRequestsModel.class, new Serializer());
                }
            }

            public ApprovalRequestsModel() {
                super(1);
            }

            public final int jK_() {
                return -1877787610;
            }

            public final GraphQLVisitableModel m2379a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m2378a(FlatBufferBuilder flatBufferBuilder) {
                h();
                flatBufferBuilder.c(1);
                flatBufferBuilder.a(0, this.f2446d, 0);
                i();
                return flatBufferBuilder.d();
            }

            public final void m2380a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                super.a(mutableFlatBuffer, i, obj);
                this.f2446d = mutableFlatBuffer.a(i, 0, 0);
            }
        }

        /* compiled from: show_reaction_units */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(GroupThreadInfoQueryModel.class, new Deserializer());
            }

            public Object m2381a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(GroupThreadInfoQueryParser.m2426a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object groupThreadInfoQueryModel = new GroupThreadInfoQueryModel();
                ((BaseModel) groupThreadInfoQueryModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (groupThreadInfoQueryModel instanceof Postprocessable) {
                    return ((Postprocessable) groupThreadInfoQueryModel).a();
                }
                return groupThreadInfoQueryModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 1255661007)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: show_reaction_units */
        public final class GroupThreadParticipantsModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableModel {
            @Nullable
            private GraphQLObjectType f2447d;
            @Nullable
            private String f2448e;
            @Nullable
            private String f2449f;

            /* compiled from: show_reaction_units */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(GroupThreadParticipantsModel.class, new Deserializer());
                }

                public Object m2382a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(GroupThreadParticipantsParser.m2420b(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object groupThreadParticipantsModel = new GroupThreadParticipantsModel();
                    ((BaseModel) groupThreadParticipantsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (groupThreadParticipantsModel instanceof Postprocessable) {
                        return ((Postprocessable) groupThreadParticipantsModel).a();
                    }
                    return groupThreadParticipantsModel;
                }
            }

            /* compiled from: show_reaction_units */
            public class Serializer extends JsonSerializer<GroupThreadParticipantsModel> {
                public final void m2383a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    GroupThreadParticipantsModel groupThreadParticipantsModel = (GroupThreadParticipantsModel) obj;
                    if (groupThreadParticipantsModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(groupThreadParticipantsModel.m2387a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        groupThreadParticipantsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    GroupThreadParticipantsParser.m2419a(groupThreadParticipantsModel.w_(), groupThreadParticipantsModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(GroupThreadParticipantsModel.class, new Serializer());
                }
            }

            public GroupThreadParticipantsModel() {
                super(3);
            }

            @Nullable
            private GraphQLObjectType m2384j() {
                if (this.b != null && this.f2447d == null) {
                    this.f2447d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
                }
                return this.f2447d;
            }

            @Nullable
            private String m2385k() {
                this.f2448e = super.a(this.f2448e, 1);
                return this.f2448e;
            }

            @Nullable
            private String m2386l() {
                this.f2449f = super.a(this.f2449f, 2);
                return this.f2449f;
            }

            @Nullable
            public final String m2389a() {
                return m2385k();
            }

            public final int jK_() {
                return -1575218831;
            }

            public final GraphQLVisitableModel m2388a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m2387a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m2384j());
                int b = flatBufferBuilder.b(m2385k());
                int b2 = flatBufferBuilder.b(m2386l());
                flatBufferBuilder.c(3);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.b(1, b);
                flatBufferBuilder.b(2, b2);
                i();
                return flatBufferBuilder.d();
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 842551240)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: show_reaction_units */
        public final class ImageModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private String f2450d;

            /* compiled from: show_reaction_units */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(ImageModel.class, new Deserializer());
                }

                public Object m2390a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(ImageParser.m2421a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object imageModel = new ImageModel();
                    ((BaseModel) imageModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (imageModel instanceof Postprocessable) {
                        return ((Postprocessable) imageModel).a();
                    }
                    return imageModel;
                }
            }

            /* compiled from: show_reaction_units */
            public class Serializer extends JsonSerializer<ImageModel> {
                public final void m2391a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    ImageModel imageModel = (ImageModel) obj;
                    if (imageModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(imageModel.m2393a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        imageModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    ImageParser.m2422a(imageModel.w_(), imageModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(ImageModel.class, new Serializer());
                }
            }

            public ImageModel() {
                super(1);
            }

            @Nullable
            private String m2392a() {
                this.f2450d = super.a(this.f2450d, 0);
                return this.f2450d;
            }

            public final int jK_() {
                return 70760763;
            }

            public final GraphQLVisitableModel m2394a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m2393a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m2392a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, b);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: show_reaction_units */
        public class Serializer extends JsonSerializer<GroupThreadInfoQueryModel> {
            public final void m2395a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                GroupThreadInfoQueryModel groupThreadInfoQueryModel = (GroupThreadInfoQueryModel) obj;
                if (groupThreadInfoQueryModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(groupThreadInfoQueryModel.m2412a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    groupThreadInfoQueryModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                GroupThreadInfoQueryParser.m2427a(groupThreadInfoQueryModel.w_(), groupThreadInfoQueryModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(GroupThreadInfoQueryModel.class, new Serializer());
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 1255661007)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: show_reaction_units */
        public final class ThreadAdminsModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
            @Nullable
            private GraphQLObjectType f2451d;
            @Nullable
            private String f2452e;
            @Nullable
            private String f2453f;

            /* compiled from: show_reaction_units */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(ThreadAdminsModel.class, new Deserializer());
                }

                public Object m2396a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(ThreadAdminsParser.m2425b(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object threadAdminsModel = new ThreadAdminsModel();
                    ((BaseModel) threadAdminsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (threadAdminsModel instanceof Postprocessable) {
                        return ((Postprocessable) threadAdminsModel).a();
                    }
                    return threadAdminsModel;
                }
            }

            /* compiled from: show_reaction_units */
            public class Serializer extends JsonSerializer<ThreadAdminsModel> {
                public final void m2397a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    ThreadAdminsModel threadAdminsModel = (ThreadAdminsModel) obj;
                    if (threadAdminsModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(threadAdminsModel.m2401a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        threadAdminsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    ThreadAdminsParser.m2424a(threadAdminsModel.w_(), threadAdminsModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(ThreadAdminsModel.class, new Serializer());
                }
            }

            public ThreadAdminsModel() {
                super(3);
            }

            public final void m2404a(String str, ConsistencyTuple consistencyTuple) {
                consistencyTuple.a();
            }

            public final void m2405a(String str, Object obj, boolean z) {
            }

            @Nullable
            private GraphQLObjectType m2398j() {
                if (this.b != null && this.f2451d == null) {
                    this.f2451d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
                }
                return this.f2451d;
            }

            @Nullable
            private String m2399k() {
                this.f2452e = super.a(this.f2452e, 1);
                return this.f2452e;
            }

            @Nullable
            private String m2400l() {
                this.f2453f = super.a(this.f2453f, 2);
                return this.f2453f;
            }

            @Nullable
            public final String m2403a() {
                return m2399k();
            }

            public final int jK_() {
                return 63093205;
            }

            public final GraphQLVisitableModel m2402a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m2401a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m2398j());
                int b = flatBufferBuilder.b(m2399k());
                int b2 = flatBufferBuilder.b(m2400l());
                flatBufferBuilder.c(3);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.b(1, b);
                flatBufferBuilder.b(2, b2);
                i();
                return flatBufferBuilder.d();
            }
        }

        public GroupThreadInfoQueryModel() {
            super(8);
        }

        @Nullable
        private ApprovalRequestsModel m2406j() {
            this.f2455e = (ApprovalRequestsModel) super.a(this.f2455e, 1, ApprovalRequestsModel.class);
            return this.f2455e;
        }

        @Nonnull
        private ImmutableList<GroupThreadParticipantsModel> m2407k() {
            this.f2456f = super.a(this.f2456f, 2, GroupThreadParticipantsModel.class);
            return (ImmutableList) this.f2456f;
        }

        @Nullable
        private String m2408l() {
            this.f2457g = super.a(this.f2457g, 3);
            return this.f2457g;
        }

        @Nullable
        private ImageModel m2409m() {
            this.f2458h = (ImageModel) super.a(this.f2458h, 4, ImageModel.class);
            return this.f2458h;
        }

        @Nonnull
        private ImmutableList<ThreadAdminsModel> m2410n() {
            this.f2460j = super.a(this.f2460j, 6, ThreadAdminsModel.class);
            return (ImmutableList) this.f2460j;
        }

        @Nullable
        private String m2411o() {
            this.f2461k = super.a(this.f2461k, 7);
            return this.f2461k;
        }

        @Nullable
        public final String m2414a() {
            return m2408l();
        }

        public final int jK_() {
            return -546639062;
        }

        public final GraphQLVisitableModel m2413a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            Builder a;
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m2406j() != null) {
                ApprovalRequestsModel approvalRequestsModel = (ApprovalRequestsModel) graphQLModelMutatingVisitor.b(m2406j());
                if (m2406j() != approvalRequestsModel) {
                    graphQLVisitableModel = (GroupThreadInfoQueryModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f2455e = approvalRequestsModel;
                }
            }
            if (m2407k() != null) {
                a = ModelHelper.a(m2407k(), graphQLModelMutatingVisitor);
                if (a != null) {
                    GroupThreadInfoQueryModel groupThreadInfoQueryModel = (GroupThreadInfoQueryModel) ModelHelper.a(graphQLVisitableModel, this);
                    groupThreadInfoQueryModel.f2456f = a.b();
                    graphQLVisitableModel = groupThreadInfoQueryModel;
                }
            }
            if (m2409m() != null) {
                ImageModel imageModel = (ImageModel) graphQLModelMutatingVisitor.b(m2409m());
                if (m2409m() != imageModel) {
                    graphQLVisitableModel = (GroupThreadInfoQueryModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f2458h = imageModel;
                }
            }
            if (m2410n() != null) {
                a = ModelHelper.a(m2410n(), graphQLModelMutatingVisitor);
                if (a != null) {
                    groupThreadInfoQueryModel = (GroupThreadInfoQueryModel) ModelHelper.a(graphQLVisitableModel, this);
                    groupThreadInfoQueryModel.f2460j = a.b();
                    graphQLVisitableModel = groupThreadInfoQueryModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m2412a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m2406j());
            int a2 = ModelHelper.a(flatBufferBuilder, m2407k());
            int b = flatBufferBuilder.b(m2408l());
            int a3 = ModelHelper.a(flatBufferBuilder, m2409m());
            int a4 = ModelHelper.a(flatBufferBuilder, m2410n());
            int b2 = flatBufferBuilder.b(m2411o());
            flatBufferBuilder.c(8);
            flatBufferBuilder.a(0, this.f2454d, 0);
            flatBufferBuilder.b(1, a);
            flatBufferBuilder.b(2, a2);
            flatBufferBuilder.b(3, b);
            flatBufferBuilder.b(4, a3);
            flatBufferBuilder.a(5, this.f2459i);
            flatBufferBuilder.b(6, a4);
            flatBufferBuilder.b(7, b2);
            i();
            return flatBufferBuilder.d();
        }

        public final void m2415a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
            super.a(mutableFlatBuffer, i, obj);
            this.f2454d = mutableFlatBuffer.a(i, 0, 0);
            this.f2459i = mutableFlatBuffer.a(i, 5);
        }
    }
}
