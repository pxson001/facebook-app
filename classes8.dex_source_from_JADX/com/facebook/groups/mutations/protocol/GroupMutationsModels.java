package com.facebook.groups.mutations.protocol;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbSerializerProvider;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.FragmentModelWithoutBridge;
import com.facebook.flatbuffers.ModelWithFlatBufferFormatHash;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.enums.GraphQLGroupJoinState;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.ModelHelper;
import com.facebook.graphql.visitor.ConsistencyTuple;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLPersistableNode;
import com.facebook.graphql.visitor.GraphQLVisitableConsistentModel;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.facebook.groups.mutations.protocol.GroupMutationsParsers.FBGroupPurposeModalSeenCoreMutationParser;
import com.facebook.groups.mutations.protocol.GroupMutationsParsers.FBGroupPurposeModalSeenCoreMutationParser.GroupParser;
import com.facebook.groups.mutations.protocol.GroupMutationsParsers.GroupAcceptInvitationToJoinMutationParser;
import com.facebook.groups.mutations.protocol.GroupMutationsParsers.GroupDeclineInvitationToJoinMutationParser;
import com.facebook.groups.mutations.protocol.GroupMutationsParsers.GroupLeaveCoreMutationParser;
import com.facebook.groups.mutations.protocol.GroupMutationsParsers.GroupRecordNotificationNuxDisplayCoreMutationParser;
import com.facebook.groups.mutations.protocol.GroupMutationsParsers.GroupRequestToJoinCoreMutationParser;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.nio.ByteBuffer;
import javax.annotation.Nullable;

/* compiled from: entity_ids */
public class GroupMutationsModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 1150042392)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: entity_ids */
    public final class FBGroupPurposeModalSeenCoreMutationModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private GroupModel f14757d;

        /* compiled from: entity_ids */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(FBGroupPurposeModalSeenCoreMutationModel.class, new Deserializer());
            }

            public Object m16974a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = FBGroupPurposeModalSeenCoreMutationParser.m17054a(jsonParser);
                Object fBGroupPurposeModalSeenCoreMutationModel = new FBGroupPurposeModalSeenCoreMutationModel();
                ((BaseModel) fBGroupPurposeModalSeenCoreMutationModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (fBGroupPurposeModalSeenCoreMutationModel instanceof Postprocessable) {
                    return ((Postprocessable) fBGroupPurposeModalSeenCoreMutationModel).a();
                }
                return fBGroupPurposeModalSeenCoreMutationModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -1970293460)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: entity_ids */
        public final class GroupModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
            @Nullable
            private String f14755d;
            private boolean f14756e;

            /* compiled from: entity_ids */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(GroupModel.class, new Deserializer());
                }

                public Object m16975a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(GroupParser.m17052a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object groupModel = new GroupModel();
                    ((BaseModel) groupModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (groupModel instanceof Postprocessable) {
                        return ((Postprocessable) groupModel).a();
                    }
                    return groupModel;
                }
            }

            /* compiled from: entity_ids */
            public class Serializer extends JsonSerializer<GroupModel> {
                public final void m16976a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    GroupModel groupModel = (GroupModel) obj;
                    if (groupModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(groupModel.m16978a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        groupModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    GroupParser.m17053a(groupModel.w_(), groupModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(GroupModel.class, new Serializer());
                }
            }

            public GroupModel() {
                super(2);
            }

            public final void m16982a(String str, ConsistencyTuple consistencyTuple) {
                consistencyTuple.a();
            }

            public final void m16983a(String str, Object obj, boolean z) {
            }

            @Nullable
            private String m16977j() {
                this.f14755d = super.a(this.f14755d, 0);
                return this.f14755d;
            }

            @Nullable
            public final String m16980a() {
                return m16977j();
            }

            public final int jK_() {
                return 69076575;
            }

            public final GraphQLVisitableModel m16979a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m16978a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m16977j());
                flatBufferBuilder.c(2);
                flatBufferBuilder.b(0, b);
                flatBufferBuilder.a(1, this.f14756e);
                i();
                return flatBufferBuilder.d();
            }

            public final void m16981a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                super.a(mutableFlatBuffer, i, obj);
                this.f14756e = mutableFlatBuffer.a(i, 1);
            }
        }

        /* compiled from: entity_ids */
        public class Serializer extends JsonSerializer<FBGroupPurposeModalSeenCoreMutationModel> {
            public final void m16984a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                FBGroupPurposeModalSeenCoreMutationModel fBGroupPurposeModalSeenCoreMutationModel = (FBGroupPurposeModalSeenCoreMutationModel) obj;
                if (fBGroupPurposeModalSeenCoreMutationModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(fBGroupPurposeModalSeenCoreMutationModel.m16986a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    fBGroupPurposeModalSeenCoreMutationModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = fBGroupPurposeModalSeenCoreMutationModel.w_();
                int u_ = fBGroupPurposeModalSeenCoreMutationModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("group");
                    GroupParser.m17053a(mutableFlatBuffer, g, jsonGenerator);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(FBGroupPurposeModalSeenCoreMutationModel.class, new Serializer());
            }
        }

        public FBGroupPurposeModalSeenCoreMutationModel() {
            super(1);
        }

        @Nullable
        private GroupModel m16985a() {
            this.f14757d = (GroupModel) super.a(this.f14757d, 0, GroupModel.class);
            return this.f14757d;
        }

        public final int jK_() {
            return -414976970;
        }

        public final GraphQLVisitableModel m16987a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m16985a() != null) {
                GroupModel groupModel = (GroupModel) graphQLModelMutatingVisitor.b(m16985a());
                if (m16985a() != groupModel) {
                    graphQLVisitableModel = (FBGroupPurposeModalSeenCoreMutationModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f14757d = groupModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m16986a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m16985a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 1493427268)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: entity_ids */
    public final class GroupAcceptInvitationToJoinMutationModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private GroupModel f14760d;

        /* compiled from: entity_ids */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(GroupAcceptInvitationToJoinMutationModel.class, new Deserializer());
            }

            public Object m16988a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = GroupAcceptInvitationToJoinMutationParser.m17057a(jsonParser);
                Object groupAcceptInvitationToJoinMutationModel = new GroupAcceptInvitationToJoinMutationModel();
                ((BaseModel) groupAcceptInvitationToJoinMutationModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (groupAcceptInvitationToJoinMutationModel instanceof Postprocessable) {
                    return ((Postprocessable) groupAcceptInvitationToJoinMutationModel).a();
                }
                return groupAcceptInvitationToJoinMutationModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -1612006214)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: entity_ids */
        public final class GroupModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
            @Nullable
            private String f14758d;
            @Nullable
            private GraphQLGroupJoinState f14759e;

            /* compiled from: entity_ids */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(GroupModel.class, new Deserializer());
                }

                public Object m16989a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(GroupAcceptInvitationToJoinMutationParser.GroupParser.m17055a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object groupModel = new GroupModel();
                    ((BaseModel) groupModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (groupModel instanceof Postprocessable) {
                        return ((Postprocessable) groupModel).a();
                    }
                    return groupModel;
                }
            }

            /* compiled from: entity_ids */
            public class Serializer extends JsonSerializer<GroupModel> {
                public final void m16990a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    GroupModel groupModel = (GroupModel) obj;
                    if (groupModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(groupModel.m16994a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        groupModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    GroupAcceptInvitationToJoinMutationParser.GroupParser.m17056a(groupModel.w_(), groupModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(GroupModel.class, new Serializer());
                }
            }

            public GroupModel() {
                super(2);
            }

            public final void m16997a(String str, ConsistencyTuple consistencyTuple) {
                if ("viewer_join_state".equals(str)) {
                    consistencyTuple.a = m16993k();
                    consistencyTuple.b = u_();
                    consistencyTuple.c = 1;
                    return;
                }
                consistencyTuple.a();
            }

            public final void m16998a(String str, Object obj, boolean z) {
                if ("viewer_join_state".equals(str)) {
                    m16991a((GraphQLGroupJoinState) obj);
                }
            }

            @Nullable
            private String m16992j() {
                this.f14758d = super.a(this.f14758d, 0);
                return this.f14758d;
            }

            @Nullable
            private GraphQLGroupJoinState m16993k() {
                this.f14759e = (GraphQLGroupJoinState) super.b(this.f14759e, 1, GraphQLGroupJoinState.class, GraphQLGroupJoinState.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
                return this.f14759e;
            }

            private void m16991a(GraphQLGroupJoinState graphQLGroupJoinState) {
                this.f14759e = graphQLGroupJoinState;
                if (this.b != null && this.b.d) {
                    this.b.a(this.c, 1, graphQLGroupJoinState != null ? graphQLGroupJoinState.name() : null);
                }
            }

            @Nullable
            public final String m16996a() {
                return m16992j();
            }

            public final int jK_() {
                return 69076575;
            }

            public final GraphQLVisitableModel m16995a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m16994a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m16992j());
                int a = flatBufferBuilder.a(m16993k());
                flatBufferBuilder.c(2);
                flatBufferBuilder.b(0, b);
                flatBufferBuilder.b(1, a);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: entity_ids */
        public class Serializer extends JsonSerializer<GroupAcceptInvitationToJoinMutationModel> {
            public final void m16999a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                GroupAcceptInvitationToJoinMutationModel groupAcceptInvitationToJoinMutationModel = (GroupAcceptInvitationToJoinMutationModel) obj;
                if (groupAcceptInvitationToJoinMutationModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(groupAcceptInvitationToJoinMutationModel.m17001a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    groupAcceptInvitationToJoinMutationModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = groupAcceptInvitationToJoinMutationModel.w_();
                int u_ = groupAcceptInvitationToJoinMutationModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("group");
                    GroupAcceptInvitationToJoinMutationParser.GroupParser.m17056a(mutableFlatBuffer, g, jsonGenerator);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(GroupAcceptInvitationToJoinMutationModel.class, new Serializer());
            }
        }

        public GroupAcceptInvitationToJoinMutationModel() {
            super(1);
        }

        @Nullable
        private GroupModel m17000a() {
            this.f14760d = (GroupModel) super.a(this.f14760d, 0, GroupModel.class);
            return this.f14760d;
        }

        public final int jK_() {
            return -1578662094;
        }

        public final GraphQLVisitableModel m17002a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m17000a() != null) {
                GroupModel groupModel = (GroupModel) graphQLModelMutatingVisitor.b(m17000a());
                if (m17000a() != groupModel) {
                    graphQLVisitableModel = (GroupAcceptInvitationToJoinMutationModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f14760d = groupModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m17001a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m17000a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -2642782)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: entity_ids */
    public final class GroupDeclineInvitationToJoinMutationModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private String f14761d;

        /* compiled from: entity_ids */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(GroupDeclineInvitationToJoinMutationModel.class, new Deserializer());
            }

            public Object m17003a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = GroupDeclineInvitationToJoinMutationParser.m17058a(jsonParser);
                Object groupDeclineInvitationToJoinMutationModel = new GroupDeclineInvitationToJoinMutationModel();
                ((BaseModel) groupDeclineInvitationToJoinMutationModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (groupDeclineInvitationToJoinMutationModel instanceof Postprocessable) {
                    return ((Postprocessable) groupDeclineInvitationToJoinMutationModel).a();
                }
                return groupDeclineInvitationToJoinMutationModel;
            }
        }

        /* compiled from: entity_ids */
        public class Serializer extends JsonSerializer<GroupDeclineInvitationToJoinMutationModel> {
            public final void m17004a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                GroupDeclineInvitationToJoinMutationModel groupDeclineInvitationToJoinMutationModel = (GroupDeclineInvitationToJoinMutationModel) obj;
                if (groupDeclineInvitationToJoinMutationModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(groupDeclineInvitationToJoinMutationModel.m17006a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    groupDeclineInvitationToJoinMutationModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = groupDeclineInvitationToJoinMutationModel.w_();
                int u_ = groupDeclineInvitationToJoinMutationModel.u_();
                jsonGenerator.f();
                if (mutableFlatBuffer.g(u_, 0) != 0) {
                    jsonGenerator.a("client_mutation_id");
                    jsonGenerator.b(mutableFlatBuffer.c(u_, 0));
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(GroupDeclineInvitationToJoinMutationModel.class, new Serializer());
            }
        }

        public GroupDeclineInvitationToJoinMutationModel() {
            super(1);
        }

        @Nullable
        private String m17005a() {
            this.f14761d = super.a(this.f14761d, 0);
            return this.f14761d;
        }

        public final int jK_() {
            return -196799862;
        }

        public final GraphQLVisitableModel m17007a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            h();
            i();
            return this;
        }

        public final int m17006a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int b = flatBufferBuilder.b(m17005a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, b);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 976066357)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: entity_ids */
    public final class GroupLeaveCoreMutationModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private GroupModel f14766d;

        /* compiled from: entity_ids */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(GroupLeaveCoreMutationModel.class, new Deserializer());
            }

            public Object m17008a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = GroupLeaveCoreMutationParser.m17061a(jsonParser);
                Object groupLeaveCoreMutationModel = new GroupLeaveCoreMutationModel();
                ((BaseModel) groupLeaveCoreMutationModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (groupLeaveCoreMutationModel instanceof Postprocessable) {
                    return ((Postprocessable) groupLeaveCoreMutationModel).a();
                }
                return groupLeaveCoreMutationModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -1612006214)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: entity_ids */
        public final class GroupModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
            @Nullable
            private String f14764d;
            @Nullable
            private GraphQLGroupJoinState f14765e;

            /* compiled from: entity_ids */
            public final class Builder {
                @Nullable
                public String f14762a;
                @Nullable
                public GraphQLGroupJoinState f14763b;
            }

            /* compiled from: entity_ids */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(GroupModel.class, new Deserializer());
                }

                public Object m17009a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(GroupLeaveCoreMutationParser.GroupParser.m17059a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object groupModel = new GroupModel();
                    ((BaseModel) groupModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (groupModel instanceof Postprocessable) {
                        return ((Postprocessable) groupModel).a();
                    }
                    return groupModel;
                }
            }

            /* compiled from: entity_ids */
            public class Serializer extends JsonSerializer<GroupModel> {
                public final void m17010a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    GroupModel groupModel = (GroupModel) obj;
                    if (groupModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(groupModel.m17014a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        groupModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    GroupLeaveCoreMutationParser.GroupParser.m17060a(groupModel.w_(), groupModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(GroupModel.class, new Serializer());
                }
            }

            public GroupModel() {
                super(2);
            }

            public GroupModel(MutableFlatBuffer mutableFlatBuffer) {
                super(2);
                a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
            }

            public final void m17017a(String str, ConsistencyTuple consistencyTuple) {
                if ("viewer_join_state".equals(str)) {
                    consistencyTuple.a = m17013k();
                    consistencyTuple.b = u_();
                    consistencyTuple.c = 1;
                    return;
                }
                consistencyTuple.a();
            }

            public final void m17018a(String str, Object obj, boolean z) {
                if ("viewer_join_state".equals(str)) {
                    m17011a((GraphQLGroupJoinState) obj);
                }
            }

            @Nullable
            private String m17012j() {
                this.f14764d = super.a(this.f14764d, 0);
                return this.f14764d;
            }

            @Nullable
            private GraphQLGroupJoinState m17013k() {
                this.f14765e = (GraphQLGroupJoinState) super.b(this.f14765e, 1, GraphQLGroupJoinState.class, GraphQLGroupJoinState.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
                return this.f14765e;
            }

            private void m17011a(GraphQLGroupJoinState graphQLGroupJoinState) {
                this.f14765e = graphQLGroupJoinState;
                if (this.b != null && this.b.d) {
                    this.b.a(this.c, 1, graphQLGroupJoinState != null ? graphQLGroupJoinState.name() : null);
                }
            }

            @Nullable
            public final String m17016a() {
                return m17012j();
            }

            public final int jK_() {
                return 69076575;
            }

            public final GraphQLVisitableModel m17015a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m17014a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m17012j());
                int a = flatBufferBuilder.a(m17013k());
                flatBufferBuilder.c(2);
                flatBufferBuilder.b(0, b);
                flatBufferBuilder.b(1, a);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: entity_ids */
        public class Serializer extends JsonSerializer<GroupLeaveCoreMutationModel> {
            public final void m17019a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                GroupLeaveCoreMutationModel groupLeaveCoreMutationModel = (GroupLeaveCoreMutationModel) obj;
                if (groupLeaveCoreMutationModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(groupLeaveCoreMutationModel.m17021a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    groupLeaveCoreMutationModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = groupLeaveCoreMutationModel.w_();
                int u_ = groupLeaveCoreMutationModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("group");
                    GroupLeaveCoreMutationParser.GroupParser.m17060a(mutableFlatBuffer, g, jsonGenerator);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(GroupLeaveCoreMutationModel.class, new Serializer());
            }
        }

        public GroupLeaveCoreMutationModel() {
            super(1);
        }

        @Nullable
        private GroupModel m17020a() {
            this.f14766d = (GroupModel) super.a(this.f14766d, 0, GroupModel.class);
            return this.f14766d;
        }

        public final int jK_() {
            return 1426318165;
        }

        public final GraphQLVisitableModel m17022a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m17020a() != null) {
                GroupModel groupModel = (GroupModel) graphQLModelMutatingVisitor.b(m17020a());
                if (m17020a() != groupModel) {
                    graphQLVisitableModel = (GroupLeaveCoreMutationModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f14766d = groupModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m17021a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m17020a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 362342428)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: entity_ids */
    public final class GroupRecordNotificationNuxDisplayCoreMutationModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private GroupModel f14769d;

        /* compiled from: entity_ids */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(GroupRecordNotificationNuxDisplayCoreMutationModel.class, new Deserializer());
            }

            public Object m17023a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = GroupRecordNotificationNuxDisplayCoreMutationParser.m17064a(jsonParser);
                Object groupRecordNotificationNuxDisplayCoreMutationModel = new GroupRecordNotificationNuxDisplayCoreMutationModel();
                ((BaseModel) groupRecordNotificationNuxDisplayCoreMutationModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (groupRecordNotificationNuxDisplayCoreMutationModel instanceof Postprocessable) {
                    return ((Postprocessable) groupRecordNotificationNuxDisplayCoreMutationModel).a();
                }
                return groupRecordNotificationNuxDisplayCoreMutationModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 291050959)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: entity_ids */
        public final class GroupModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
            @Nullable
            private String f14767d;
            private boolean f14768e;

            /* compiled from: entity_ids */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(GroupModel.class, new Deserializer());
                }

                public Object m17024a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(GroupRecordNotificationNuxDisplayCoreMutationParser.GroupParser.m17062a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object groupModel = new GroupModel();
                    ((BaseModel) groupModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (groupModel instanceof Postprocessable) {
                        return ((Postprocessable) groupModel).a();
                    }
                    return groupModel;
                }
            }

            /* compiled from: entity_ids */
            public class Serializer extends JsonSerializer<GroupModel> {
                public final void m17025a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    GroupModel groupModel = (GroupModel) obj;
                    if (groupModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(groupModel.m17027a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        groupModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    GroupRecordNotificationNuxDisplayCoreMutationParser.GroupParser.m17063a(groupModel.w_(), groupModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(GroupModel.class, new Serializer());
                }
            }

            public GroupModel() {
                super(2);
            }

            public final void m17031a(String str, ConsistencyTuple consistencyTuple) {
                consistencyTuple.a();
            }

            public final void m17032a(String str, Object obj, boolean z) {
            }

            @Nullable
            private String m17026j() {
                this.f14767d = super.a(this.f14767d, 0);
                return this.f14767d;
            }

            @Nullable
            public final String m17029a() {
                return m17026j();
            }

            public final int jK_() {
                return 69076575;
            }

            public final GraphQLVisitableModel m17028a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m17027a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m17026j());
                flatBufferBuilder.c(2);
                flatBufferBuilder.b(0, b);
                flatBufferBuilder.a(1, this.f14768e);
                i();
                return flatBufferBuilder.d();
            }

            public final void m17030a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                super.a(mutableFlatBuffer, i, obj);
                this.f14768e = mutableFlatBuffer.a(i, 1);
            }
        }

        /* compiled from: entity_ids */
        public class Serializer extends JsonSerializer<GroupRecordNotificationNuxDisplayCoreMutationModel> {
            public final void m17033a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                GroupRecordNotificationNuxDisplayCoreMutationModel groupRecordNotificationNuxDisplayCoreMutationModel = (GroupRecordNotificationNuxDisplayCoreMutationModel) obj;
                if (groupRecordNotificationNuxDisplayCoreMutationModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(groupRecordNotificationNuxDisplayCoreMutationModel.m17035a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    groupRecordNotificationNuxDisplayCoreMutationModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = groupRecordNotificationNuxDisplayCoreMutationModel.w_();
                int u_ = groupRecordNotificationNuxDisplayCoreMutationModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("group");
                    GroupRecordNotificationNuxDisplayCoreMutationParser.GroupParser.m17063a(mutableFlatBuffer, g, jsonGenerator);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(GroupRecordNotificationNuxDisplayCoreMutationModel.class, new Serializer());
            }
        }

        public GroupRecordNotificationNuxDisplayCoreMutationModel() {
            super(1);
        }

        @Nullable
        private GroupModel m17034a() {
            this.f14769d = (GroupModel) super.a(this.f14769d, 0, GroupModel.class);
            return this.f14769d;
        }

        public final int jK_() {
            return 1196541313;
        }

        public final GraphQLVisitableModel m17036a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m17034a() != null) {
                GroupModel groupModel = (GroupModel) graphQLModelMutatingVisitor.b(m17034a());
                if (m17034a() != groupModel) {
                    graphQLVisitableModel = (GroupRecordNotificationNuxDisplayCoreMutationModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f14769d = groupModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m17035a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m17034a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -162868804)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: entity_ids */
    public final class GroupRequestToJoinCoreMutationModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private GroupModel f14774d;

        /* compiled from: entity_ids */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(GroupRequestToJoinCoreMutationModel.class, new Deserializer());
            }

            public Object m17037a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = GroupRequestToJoinCoreMutationParser.m17067a(r6);
                Object groupRequestToJoinCoreMutationModel = new GroupRequestToJoinCoreMutationModel();
                ((BaseModel) groupRequestToJoinCoreMutationModel).a(a, FlatBuffer.a(a.a), r6);
                if (groupRequestToJoinCoreMutationModel instanceof Postprocessable) {
                    return ((Postprocessable) groupRequestToJoinCoreMutationModel).a();
                }
                return groupRequestToJoinCoreMutationModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -1612006214)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: entity_ids */
        public final class GroupModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
            @Nullable
            private String f14772d;
            @Nullable
            private GraphQLGroupJoinState f14773e;

            /* compiled from: entity_ids */
            public final class Builder {
                @Nullable
                public String f14770a;
                @Nullable
                public GraphQLGroupJoinState f14771b;
            }

            /* compiled from: entity_ids */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(GroupModel.class, new Deserializer());
                }

                public Object m17038a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(GroupRequestToJoinCoreMutationParser.GroupParser.m17065a(r11, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object groupModel = new GroupModel();
                    ((BaseModel) groupModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), r11);
                    if (groupModel instanceof Postprocessable) {
                        return ((Postprocessable) groupModel).a();
                    }
                    return groupModel;
                }
            }

            /* compiled from: entity_ids */
            public class Serializer extends JsonSerializer<GroupModel> {
                public final void m17039a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    GroupModel groupModel = (GroupModel) r8;
                    if (groupModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(groupModel.m17043a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        groupModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    GroupRequestToJoinCoreMutationParser.GroupParser.m17066a(groupModel.w_(), groupModel.u_(), r9);
                }

                static {
                    FbSerializerProvider.a(GroupModel.class, new Serializer());
                }
            }

            public GroupModel() {
                super(2);
            }

            public GroupModel(MutableFlatBuffer mutableFlatBuffer) {
                super(2);
                a(r3, FlatBuffer.a(r3.a));
            }

            public final void m17046a(String str, ConsistencyTuple consistencyTuple) {
                if ("viewer_join_state".equals(r2)) {
                    r3.a = m17042k();
                    r3.b = u_();
                    r3.c = 1;
                    return;
                }
                r3.a();
            }

            public final void m17047a(String str, Object obj, boolean z) {
                if ("viewer_join_state".equals(r2)) {
                    m17040a((GraphQLGroupJoinState) r3);
                }
            }

            @Nullable
            private String m17041j() {
                this.f14772d = super.a(this.f14772d, 0);
                return this.f14772d;
            }

            @Nullable
            private GraphQLGroupJoinState m17042k() {
                this.f14773e = (GraphQLGroupJoinState) super.b(this.f14773e, 1, GraphQLGroupJoinState.class, GraphQLGroupJoinState.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
                return this.f14773e;
            }

            private void m17040a(GraphQLGroupJoinState graphQLGroupJoinState) {
                this.f14773e = r6;
                if (this.b != null && this.b.d) {
                    this.b.a(this.c, 1, r6 != null ? r6.name() : null);
                }
            }

            @Nullable
            public final String m17045a() {
                return m17041j();
            }

            public final int jK_() {
                return 69076575;
            }

            public final GraphQLVisitableModel m17044a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m17043a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = r4.b(m17041j());
                int a = r4.a(m17042k());
                r4.c(2);
                r4.b(0, b);
                r4.b(1, a);
                i();
                return r4.d();
            }
        }

        /* compiled from: entity_ids */
        public class Serializer extends JsonSerializer<GroupRequestToJoinCoreMutationModel> {
            public final void m17048a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                GroupRequestToJoinCoreMutationModel groupRequestToJoinCoreMutationModel = (GroupRequestToJoinCoreMutationModel) r9;
                if (groupRequestToJoinCoreMutationModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(groupRequestToJoinCoreMutationModel.m17050a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    groupRequestToJoinCoreMutationModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = groupRequestToJoinCoreMutationModel.w_();
                int u_ = groupRequestToJoinCoreMutationModel.u_();
                r10.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    r10.a("group");
                    GroupRequestToJoinCoreMutationParser.GroupParser.m17066a(mutableFlatBuffer, g, r10);
                }
                r10.g();
            }

            static {
                FbSerializerProvider.a(GroupRequestToJoinCoreMutationModel.class, new Serializer());
            }
        }

        public GroupRequestToJoinCoreMutationModel() {
            super(1);
        }

        @Nullable
        private GroupModel m17049a() {
            this.f14774d = (GroupModel) super.a(this.f14774d, 0, GroupModel.class);
            return this.f14774d;
        }

        public final int jK_() {
            return -1430083656;
        }

        public final GraphQLVisitableModel m17051a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m17049a() != null) {
                GroupModel groupModel = (GroupModel) r4.b(m17049a());
                if (m17049a() != groupModel) {
                    graphQLVisitableModel = (GroupRequestToJoinCoreMutationModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f14774d = groupModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m17050a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(r3, m17049a());
            r3.c(1);
            r3.b(0, a);
            i();
            return r3.d();
        }
    }
}
