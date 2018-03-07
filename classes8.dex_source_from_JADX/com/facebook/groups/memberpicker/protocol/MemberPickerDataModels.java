package com.facebook.groups.memberpicker.protocol;

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
import com.facebook.graphql.visitor.GraphQLPersistableNode;
import com.facebook.graphql.visitor.GraphQLVisitableConsistentModel;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.facebook.groups.memberpicker.protocol.MemberPickerDataParsers.GroupFriendsMemberPickerDataParser;
import com.facebook.groups.memberpicker.protocol.MemberPickerDataParsers.GroupFriendsMemberPickerDataParser.GroupMembersParser;
import com.facebook.groups.memberpicker.protocol.MemberPickerDataParsers.GroupFriendsMemberPickerDataParser.GroupMembersParser.NodesParser;
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

/* compiled from: event_card_going_tap */
public class MemberPickerDataModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 1802049933)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: event_card_going_tap */
    public final class GroupFriendsMemberPickerDataModel extends BaseModel implements GraphQLVisitableConsistentModel {
        @Nullable
        private GroupMembersModel f14717d;

        /* compiled from: event_card_going_tap */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(GroupFriendsMemberPickerDataModel.class, new Deserializer());
            }

            public Object m16821a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = GroupFriendsMemberPickerDataParser.m16845a(jsonParser);
                Object groupFriendsMemberPickerDataModel = new GroupFriendsMemberPickerDataModel();
                ((BaseModel) groupFriendsMemberPickerDataModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (groupFriendsMemberPickerDataModel instanceof Postprocessable) {
                    return ((Postprocessable) groupFriendsMemberPickerDataModel).a();
                }
                return groupFriendsMemberPickerDataModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -1096347591)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: event_card_going_tap */
        public final class GroupMembersModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private List<NodesModel> f14716d;

            /* compiled from: event_card_going_tap */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(GroupMembersModel.class, new Deserializer());
                }

                public Object m16822a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(GroupMembersParser.m16843a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object groupMembersModel = new GroupMembersModel();
                    ((BaseModel) groupMembersModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (groupMembersModel instanceof Postprocessable) {
                        return ((Postprocessable) groupMembersModel).a();
                    }
                    return groupMembersModel;
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = 1801334754)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: event_card_going_tap */
            public final class NodesModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
                @Nullable
                private String f14715d;

                /* compiled from: event_card_going_tap */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(NodesModel.class, new Deserializer());
                    }

                    public Object m16823a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(NodesParser.m16842b(jsonParser, flatBufferBuilder));
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

                /* compiled from: event_card_going_tap */
                public class Serializer extends JsonSerializer<NodesModel> {
                    public final void m16824a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        NodesModel nodesModel = (NodesModel) obj;
                        if (nodesModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(nodesModel.m16826a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            nodesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        NodesParser.m16841a(nodesModel.w_(), nodesModel.u_(), jsonGenerator);
                    }

                    static {
                        FbSerializerProvider.a(NodesModel.class, new Serializer());
                    }
                }

                public NodesModel() {
                    super(1);
                }

                public final void m16829a(String str, ConsistencyTuple consistencyTuple) {
                    consistencyTuple.a();
                }

                public final void m16830a(String str, Object obj, boolean z) {
                }

                @Nullable
                private String m16825j() {
                    this.f14715d = super.a(this.f14715d, 0);
                    return this.f14715d;
                }

                @Nullable
                public final String m16828a() {
                    return m16825j();
                }

                public final int jK_() {
                    return 2645995;
                }

                public final GraphQLVisitableModel m16827a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    h();
                    i();
                    return this;
                }

                public final int m16826a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int b = flatBufferBuilder.b(m16825j());
                    flatBufferBuilder.c(1);
                    flatBufferBuilder.b(0, b);
                    i();
                    return flatBufferBuilder.d();
                }
            }

            /* compiled from: event_card_going_tap */
            public class Serializer extends JsonSerializer<GroupMembersModel> {
                public final void m16831a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    GroupMembersModel groupMembersModel = (GroupMembersModel) obj;
                    if (groupMembersModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(groupMembersModel.m16833a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        groupMembersModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    GroupMembersParser.m16844a(groupMembersModel.w_(), groupMembersModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(GroupMembersModel.class, new Serializer());
                }
            }

            public GroupMembersModel() {
                super(1);
            }

            @Nonnull
            private ImmutableList<NodesModel> m16832a() {
                this.f14716d = super.a(this.f14716d, 0, NodesModel.class);
                return (ImmutableList) this.f14716d;
            }

            public final int jK_() {
                return 103365688;
            }

            public final GraphQLVisitableModel m16834a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m16832a() != null) {
                    Builder a = ModelHelper.a(m16832a(), graphQLModelMutatingVisitor);
                    if (a != null) {
                        graphQLVisitableModel = (GroupMembersModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f14716d = a.b();
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m16833a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m16832a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, a);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: event_card_going_tap */
        public class Serializer extends JsonSerializer<GroupFriendsMemberPickerDataModel> {
            public final void m16835a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                GroupFriendsMemberPickerDataModel groupFriendsMemberPickerDataModel = (GroupFriendsMemberPickerDataModel) obj;
                if (groupFriendsMemberPickerDataModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(groupFriendsMemberPickerDataModel.m16837a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    groupFriendsMemberPickerDataModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = groupFriendsMemberPickerDataModel.w_();
                int u_ = groupFriendsMemberPickerDataModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("group_members");
                    GroupMembersParser.m16844a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(GroupFriendsMemberPickerDataModel.class, new Serializer());
            }
        }

        public GroupFriendsMemberPickerDataModel() {
            super(1);
        }

        public final void m16839a(String str, ConsistencyTuple consistencyTuple) {
            consistencyTuple.a();
        }

        public final void m16840a(String str, Object obj, boolean z) {
        }

        @Nullable
        private GroupMembersModel m16836a() {
            this.f14717d = (GroupMembersModel) super.a(this.f14717d, 0, GroupMembersModel.class);
            return this.f14717d;
        }

        public final int jK_() {
            return 69076575;
        }

        public final GraphQLVisitableModel m16838a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m16836a() != null) {
                GroupMembersModel groupMembersModel = (GroupMembersModel) graphQLModelMutatingVisitor.b(m16836a());
                if (m16836a() != groupMembersModel) {
                    graphQLVisitableModel = (GroupFriendsMemberPickerDataModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f14717d = groupMembersModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m16837a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m16836a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }
}
