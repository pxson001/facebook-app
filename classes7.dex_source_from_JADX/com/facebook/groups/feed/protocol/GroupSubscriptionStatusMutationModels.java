package com.facebook.groups.feed.protocol;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbSerializerProvider;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.FragmentModelWithoutBridge;
import com.facebook.flatbuffers.ModelWithFlatBufferFormatHash;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.enums.GraphQLSubscribeStatus;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.ModelHelper;
import com.facebook.graphql.visitor.ConsistencyTuple;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLPersistableNode;
import com.facebook.graphql.visitor.GraphQLVisitableConsistentModel;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.facebook.groups.feed.protocol.GroupSubscriptionStatusMutationParsers.GroupSubscribeMutationFragmentParser;
import com.facebook.groups.feed.protocol.GroupSubscriptionStatusMutationParsers.GroupSubscribeMutationFragmentParser.GroupParser;
import com.facebook.groups.feed.protocol.GroupSubscriptionStatusMutationParsers.GroupSubscribeMutationFragmentParser.GroupParser.AdminAwareGroupParser;
import com.facebook.groups.feed.protocol.GroupSubscriptionStatusMutationParsers.GroupUnsubscribeMutationFragmentParser;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.nio.ByteBuffer;
import javax.annotation.Nullable;

/* compiled from: purpose_type */
public class GroupSubscriptionStatusMutationModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -1305603860)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: purpose_type */
    public final class GroupSubscribeMutationFragmentModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private GroupModel f5685d;

        /* compiled from: purpose_type */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(GroupSubscribeMutationFragmentModel.class, new Deserializer());
            }

            public Object m6871a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = GroupSubscribeMutationFragmentParser.m6927a(jsonParser);
                Object groupSubscribeMutationFragmentModel = new GroupSubscribeMutationFragmentModel();
                ((BaseModel) groupSubscribeMutationFragmentModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (groupSubscribeMutationFragmentModel instanceof Postprocessable) {
                    return ((Postprocessable) groupSubscribeMutationFragmentModel).a();
                }
                return groupSubscribeMutationFragmentModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -326573725)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: purpose_type */
        public final class GroupModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
            @Nullable
            private AdminAwareGroupModel f5682d;
            @Nullable
            private String f5683e;
            @Nullable
            private GraphQLSubscribeStatus f5684f;

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = -1822890225)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: purpose_type */
            public final class AdminAwareGroupModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
                @Nullable
                private String f5680d;
                @Nullable
                private GraphQLSubscribeStatus f5681e;

                /* compiled from: purpose_type */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(AdminAwareGroupModel.class, new Deserializer());
                    }

                    public Object m6872a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(AdminAwareGroupParser.m6923a(jsonParser, flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        mutableFlatBuffer.a(4, Boolean.valueOf(true));
                        MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                        Object adminAwareGroupModel = new AdminAwareGroupModel();
                        ((BaseModel) adminAwareGroupModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                        if (adminAwareGroupModel instanceof Postprocessable) {
                            return ((Postprocessable) adminAwareGroupModel).a();
                        }
                        return adminAwareGroupModel;
                    }
                }

                /* compiled from: purpose_type */
                public class Serializer extends JsonSerializer<AdminAwareGroupModel> {
                    public final void m6873a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        AdminAwareGroupModel adminAwareGroupModel = (AdminAwareGroupModel) obj;
                        if (adminAwareGroupModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(adminAwareGroupModel.m6877a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            adminAwareGroupModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        AdminAwareGroupParser.m6924a(adminAwareGroupModel.w_(), adminAwareGroupModel.u_(), jsonGenerator);
                    }

                    static {
                        FbSerializerProvider.a(AdminAwareGroupModel.class, new Serializer());
                    }
                }

                public AdminAwareGroupModel() {
                    super(2);
                }

                public final void m6880a(String str, ConsistencyTuple consistencyTuple) {
                    if ("subscribe_status".equals(str)) {
                        consistencyTuple.a = m6876k();
                        consistencyTuple.b = u_();
                        consistencyTuple.c = 1;
                        return;
                    }
                    consistencyTuple.a();
                }

                public final void m6881a(String str, Object obj, boolean z) {
                    if ("subscribe_status".equals(str)) {
                        m6874a((GraphQLSubscribeStatus) obj);
                    }
                }

                @Nullable
                private String m6875j() {
                    this.f5680d = super.a(this.f5680d, 0);
                    return this.f5680d;
                }

                @Nullable
                private GraphQLSubscribeStatus m6876k() {
                    this.f5681e = (GraphQLSubscribeStatus) super.b(this.f5681e, 1, GraphQLSubscribeStatus.class, GraphQLSubscribeStatus.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
                    return this.f5681e;
                }

                private void m6874a(GraphQLSubscribeStatus graphQLSubscribeStatus) {
                    this.f5681e = graphQLSubscribeStatus;
                    if (this.b != null && this.b.d) {
                        this.b.a(this.c, 1, graphQLSubscribeStatus != null ? graphQLSubscribeStatus.name() : null);
                    }
                }

                @Nullable
                public final String m6879a() {
                    return m6875j();
                }

                public final int jK_() {
                    return 69076575;
                }

                public final GraphQLVisitableModel m6878a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    h();
                    i();
                    return this;
                }

                public final int m6877a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int b = flatBufferBuilder.b(m6875j());
                    int a = flatBufferBuilder.a(m6876k());
                    flatBufferBuilder.c(2);
                    flatBufferBuilder.b(0, b);
                    flatBufferBuilder.b(1, a);
                    i();
                    return flatBufferBuilder.d();
                }
            }

            /* compiled from: purpose_type */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(GroupModel.class, new Deserializer());
                }

                public Object m6882a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(GroupParser.m6925a(jsonParser, flatBufferBuilder));
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

            /* compiled from: purpose_type */
            public class Serializer extends JsonSerializer<GroupModel> {
                public final void m6883a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    GroupModel groupModel = (GroupModel) obj;
                    if (groupModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(groupModel.m6888a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        groupModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    GroupParser.m6926a(groupModel.w_(), groupModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(GroupModel.class, new Serializer());
                }
            }

            public GroupModel() {
                super(3);
            }

            public final void m6891a(String str, ConsistencyTuple consistencyTuple) {
                if ("subscribe_status".equals(str)) {
                    consistencyTuple.a = m6887l();
                    consistencyTuple.b = u_();
                    consistencyTuple.c = 2;
                    return;
                }
                consistencyTuple.a();
            }

            public final void m6892a(String str, Object obj, boolean z) {
                if ("subscribe_status".equals(str)) {
                    m6884a((GraphQLSubscribeStatus) obj);
                }
            }

            @Nullable
            private AdminAwareGroupModel m6885j() {
                this.f5682d = (AdminAwareGroupModel) super.a(this.f5682d, 0, AdminAwareGroupModel.class);
                return this.f5682d;
            }

            @Nullable
            private String m6886k() {
                this.f5683e = super.a(this.f5683e, 1);
                return this.f5683e;
            }

            @Nullable
            private GraphQLSubscribeStatus m6887l() {
                this.f5684f = (GraphQLSubscribeStatus) super.b(this.f5684f, 2, GraphQLSubscribeStatus.class, GraphQLSubscribeStatus.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
                return this.f5684f;
            }

            private void m6884a(GraphQLSubscribeStatus graphQLSubscribeStatus) {
                this.f5684f = graphQLSubscribeStatus;
                if (this.b != null && this.b.d) {
                    this.b.a(this.c, 2, graphQLSubscribeStatus != null ? graphQLSubscribeStatus.name() : null);
                }
            }

            @Nullable
            public final String m6890a() {
                return m6886k();
            }

            public final int jK_() {
                return 69076575;
            }

            public final GraphQLVisitableModel m6889a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m6885j() != null) {
                    AdminAwareGroupModel adminAwareGroupModel = (AdminAwareGroupModel) graphQLModelMutatingVisitor.b(m6885j());
                    if (m6885j() != adminAwareGroupModel) {
                        graphQLVisitableModel = (GroupModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f5682d = adminAwareGroupModel;
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m6888a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m6885j());
                int b = flatBufferBuilder.b(m6886k());
                int a2 = flatBufferBuilder.a(m6887l());
                flatBufferBuilder.c(3);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.b(1, b);
                flatBufferBuilder.b(2, a2);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: purpose_type */
        public class Serializer extends JsonSerializer<GroupSubscribeMutationFragmentModel> {
            public final void m6893a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                GroupSubscribeMutationFragmentModel groupSubscribeMutationFragmentModel = (GroupSubscribeMutationFragmentModel) obj;
                if (groupSubscribeMutationFragmentModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(groupSubscribeMutationFragmentModel.m6895a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    groupSubscribeMutationFragmentModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = groupSubscribeMutationFragmentModel.w_();
                int u_ = groupSubscribeMutationFragmentModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("group");
                    GroupParser.m6926a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(GroupSubscribeMutationFragmentModel.class, new Serializer());
            }
        }

        public GroupSubscribeMutationFragmentModel() {
            super(1);
        }

        @Nullable
        private GroupModel m6894a() {
            this.f5685d = (GroupModel) super.a(this.f5685d, 0, GroupModel.class);
            return this.f5685d;
        }

        public final int jK_() {
            return 1623811298;
        }

        public final GraphQLVisitableModel m6896a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m6894a() != null) {
                GroupModel groupModel = (GroupModel) graphQLModelMutatingVisitor.b(m6894a());
                if (m6894a() != groupModel) {
                    graphQLVisitableModel = (GroupSubscribeMutationFragmentModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f5685d = groupModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m6895a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m6894a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 959290246)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: purpose_type */
    public final class GroupUnsubscribeMutationFragmentModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private GroupModel f5691d;

        /* compiled from: purpose_type */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(GroupUnsubscribeMutationFragmentModel.class, new Deserializer());
            }

            public Object m6897a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = GroupUnsubscribeMutationFragmentParser.m6932a(jsonParser);
                Object groupUnsubscribeMutationFragmentModel = new GroupUnsubscribeMutationFragmentModel();
                ((BaseModel) groupUnsubscribeMutationFragmentModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (groupUnsubscribeMutationFragmentModel instanceof Postprocessable) {
                    return ((Postprocessable) groupUnsubscribeMutationFragmentModel).a();
                }
                return groupUnsubscribeMutationFragmentModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 398949181)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: purpose_type */
        public final class GroupModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
            @Nullable
            private AdminAwareGroupModel f5688d;
            @Nullable
            private String f5689e;
            @Nullable
            private GraphQLSubscribeStatus f5690f;

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = -1822890225)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: purpose_type */
            public final class AdminAwareGroupModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
                @Nullable
                private String f5686d;
                @Nullable
                private GraphQLSubscribeStatus f5687e;

                /* compiled from: purpose_type */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(AdminAwareGroupModel.class, new Deserializer());
                    }

                    public Object m6898a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(GroupUnsubscribeMutationFragmentParser.GroupParser.AdminAwareGroupParser.m6928a(jsonParser, flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        mutableFlatBuffer.a(4, Boolean.valueOf(true));
                        MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                        Object adminAwareGroupModel = new AdminAwareGroupModel();
                        ((BaseModel) adminAwareGroupModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                        if (adminAwareGroupModel instanceof Postprocessable) {
                            return ((Postprocessable) adminAwareGroupModel).a();
                        }
                        return adminAwareGroupModel;
                    }
                }

                /* compiled from: purpose_type */
                public class Serializer extends JsonSerializer<AdminAwareGroupModel> {
                    public final void m6899a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        AdminAwareGroupModel adminAwareGroupModel = (AdminAwareGroupModel) obj;
                        if (adminAwareGroupModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(adminAwareGroupModel.m6903a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            adminAwareGroupModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        GroupUnsubscribeMutationFragmentParser.GroupParser.AdminAwareGroupParser.m6929a(adminAwareGroupModel.w_(), adminAwareGroupModel.u_(), jsonGenerator);
                    }

                    static {
                        FbSerializerProvider.a(AdminAwareGroupModel.class, new Serializer());
                    }
                }

                public AdminAwareGroupModel() {
                    super(2);
                }

                public final void m6906a(String str, ConsistencyTuple consistencyTuple) {
                    if ("subscribe_status".equals(str)) {
                        consistencyTuple.a = m6902k();
                        consistencyTuple.b = u_();
                        consistencyTuple.c = 1;
                        return;
                    }
                    consistencyTuple.a();
                }

                public final void m6907a(String str, Object obj, boolean z) {
                    if ("subscribe_status".equals(str)) {
                        m6900a((GraphQLSubscribeStatus) obj);
                    }
                }

                @Nullable
                private String m6901j() {
                    this.f5686d = super.a(this.f5686d, 0);
                    return this.f5686d;
                }

                @Nullable
                private GraphQLSubscribeStatus m6902k() {
                    this.f5687e = (GraphQLSubscribeStatus) super.b(this.f5687e, 1, GraphQLSubscribeStatus.class, GraphQLSubscribeStatus.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
                    return this.f5687e;
                }

                private void m6900a(GraphQLSubscribeStatus graphQLSubscribeStatus) {
                    this.f5687e = graphQLSubscribeStatus;
                    if (this.b != null && this.b.d) {
                        this.b.a(this.c, 1, graphQLSubscribeStatus != null ? graphQLSubscribeStatus.name() : null);
                    }
                }

                @Nullable
                public final String m6905a() {
                    return m6901j();
                }

                public final int jK_() {
                    return 69076575;
                }

                public final GraphQLVisitableModel m6904a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    h();
                    i();
                    return this;
                }

                public final int m6903a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int b = flatBufferBuilder.b(m6901j());
                    int a = flatBufferBuilder.a(m6902k());
                    flatBufferBuilder.c(2);
                    flatBufferBuilder.b(0, b);
                    flatBufferBuilder.b(1, a);
                    i();
                    return flatBufferBuilder.d();
                }
            }

            /* compiled from: purpose_type */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(GroupModel.class, new Deserializer());
                }

                public Object m6908a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(GroupUnsubscribeMutationFragmentParser.GroupParser.m6930a(jsonParser, flatBufferBuilder));
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

            /* compiled from: purpose_type */
            public class Serializer extends JsonSerializer<GroupModel> {
                public final void m6909a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    GroupModel groupModel = (GroupModel) obj;
                    if (groupModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(groupModel.m6914a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        groupModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    GroupUnsubscribeMutationFragmentParser.GroupParser.m6931a(groupModel.w_(), groupModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(GroupModel.class, new Serializer());
                }
            }

            public GroupModel() {
                super(3);
            }

            public final void m6917a(String str, ConsistencyTuple consistencyTuple) {
                if ("subscribe_status".equals(str)) {
                    consistencyTuple.a = m6913l();
                    consistencyTuple.b = u_();
                    consistencyTuple.c = 2;
                    return;
                }
                consistencyTuple.a();
            }

            public final void m6918a(String str, Object obj, boolean z) {
                if ("subscribe_status".equals(str)) {
                    m6910a((GraphQLSubscribeStatus) obj);
                }
            }

            @Nullable
            private AdminAwareGroupModel m6911j() {
                this.f5688d = (AdminAwareGroupModel) super.a(this.f5688d, 0, AdminAwareGroupModel.class);
                return this.f5688d;
            }

            @Nullable
            private String m6912k() {
                this.f5689e = super.a(this.f5689e, 1);
                return this.f5689e;
            }

            @Nullable
            private GraphQLSubscribeStatus m6913l() {
                this.f5690f = (GraphQLSubscribeStatus) super.b(this.f5690f, 2, GraphQLSubscribeStatus.class, GraphQLSubscribeStatus.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
                return this.f5690f;
            }

            private void m6910a(GraphQLSubscribeStatus graphQLSubscribeStatus) {
                this.f5690f = graphQLSubscribeStatus;
                if (this.b != null && this.b.d) {
                    this.b.a(this.c, 2, graphQLSubscribeStatus != null ? graphQLSubscribeStatus.name() : null);
                }
            }

            @Nullable
            public final String m6916a() {
                return m6912k();
            }

            public final int jK_() {
                return 69076575;
            }

            public final GraphQLVisitableModel m6915a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m6911j() != null) {
                    AdminAwareGroupModel adminAwareGroupModel = (AdminAwareGroupModel) graphQLModelMutatingVisitor.b(m6911j());
                    if (m6911j() != adminAwareGroupModel) {
                        graphQLVisitableModel = (GroupModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f5688d = adminAwareGroupModel;
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m6914a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m6911j());
                int b = flatBufferBuilder.b(m6912k());
                int a2 = flatBufferBuilder.a(m6913l());
                flatBufferBuilder.c(3);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.b(1, b);
                flatBufferBuilder.b(2, a2);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: purpose_type */
        public class Serializer extends JsonSerializer<GroupUnsubscribeMutationFragmentModel> {
            public final void m6919a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                GroupUnsubscribeMutationFragmentModel groupUnsubscribeMutationFragmentModel = (GroupUnsubscribeMutationFragmentModel) obj;
                if (groupUnsubscribeMutationFragmentModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(groupUnsubscribeMutationFragmentModel.m6921a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    groupUnsubscribeMutationFragmentModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = groupUnsubscribeMutationFragmentModel.w_();
                int u_ = groupUnsubscribeMutationFragmentModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("group");
                    GroupUnsubscribeMutationFragmentParser.GroupParser.m6931a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(GroupUnsubscribeMutationFragmentModel.class, new Serializer());
            }
        }

        public GroupUnsubscribeMutationFragmentModel() {
            super(1);
        }

        @Nullable
        private GroupModel m6920a() {
            this.f5691d = (GroupModel) super.a(this.f5691d, 0, GroupModel.class);
            return this.f5691d;
        }

        public final int jK_() {
            return 925111483;
        }

        public final GraphQLVisitableModel m6922a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m6920a() != null) {
                GroupModel groupModel = (GroupModel) graphQLModelMutatingVisitor.b(m6920a());
                if (m6920a() != groupModel) {
                    graphQLVisitableModel = (GroupUnsubscribeMutationFragmentModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f5691d = groupModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m6921a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m6920a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }
}
