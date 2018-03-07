package com.facebook.groups.settings.protocol;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbSerializerProvider;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.FragmentModelWithoutBridge;
import com.facebook.flatbuffers.ModelWithFlatBufferFormatHash;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.enums.GraphQLGroupPushSubscriptionLevel;
import com.facebook.graphql.enums.GraphQLGroupRequestToJoinSubscriptionLevel;
import com.facebook.graphql.enums.GraphQLGroupSubscriptionLevel;
import com.facebook.graphql.enums.GraphQLObjectType;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.ModelHelper;
import com.facebook.graphql.visitor.ConsistencyTuple;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLPersistableNode;
import com.facebook.graphql.visitor.GraphQLVisitableConsistentModel;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.facebook.groups.settings.protocol.SettingMutationsParsers.GroupUpdatePushSubscriptionMutationParser;
import com.facebook.groups.settings.protocol.SettingMutationsParsers.GroupUpdatePushSubscriptionMutationParser.GroupParser;
import com.facebook.groups.settings.protocol.SettingMutationsParsers.GroupUpdateRequestToJoinSubscriptionMutationParser;
import com.facebook.groups.settings.protocol.SettingMutationsParsers.GroupUpdateSubscriptionMutationParser;
import com.facebook.groups.settings.protocol.SettingMutationsParsers.MutePushNotificationsMutationParser;
import com.facebook.groups.settings.protocol.SettingMutationsParsers.MutePushNotificationsMutationParser.PushTokenParser;
import com.facebook.groups.settings.protocol.SettingMutationsParsers.MutePushNotificationsMutationParser.PushTokenParser.ApplicationParser;
import com.facebook.groups.settings.protocol.SettingMutationsParsers.MutePushNotificationsMutationParser.PushTokenParser.OwnerParser;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.nio.ByteBuffer;
import javax.annotation.Nullable;

/* compiled from: THREAD_NONEXISTENT */
public class SettingMutationsModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 901998476)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: THREAD_NONEXISTENT */
    public final class GroupUpdatePushSubscriptionMutationModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private GroupModel f23178d;

        /* compiled from: THREAD_NONEXISTENT */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(GroupUpdatePushSubscriptionMutationModel.class, new Deserializer());
            }

            public Object m24462a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = GroupUpdatePushSubscriptionMutationParser.m24542a(jsonParser);
                Object groupUpdatePushSubscriptionMutationModel = new GroupUpdatePushSubscriptionMutationModel();
                ((BaseModel) groupUpdatePushSubscriptionMutationModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (groupUpdatePushSubscriptionMutationModel instanceof Postprocessable) {
                    return ((Postprocessable) groupUpdatePushSubscriptionMutationModel).a();
                }
                return groupUpdatePushSubscriptionMutationModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -1244737145)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: THREAD_NONEXISTENT */
        public final class GroupModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
            @Nullable
            private String f23176d;
            @Nullable
            private GraphQLGroupPushSubscriptionLevel f23177e;

            /* compiled from: THREAD_NONEXISTENT */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(GroupModel.class, new Deserializer());
                }

                public Object m24463a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(GroupParser.m24540a(jsonParser, flatBufferBuilder));
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

            /* compiled from: THREAD_NONEXISTENT */
            public class Serializer extends JsonSerializer<GroupModel> {
                public final void m24464a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    GroupModel groupModel = (GroupModel) obj;
                    if (groupModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(groupModel.m24468a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        groupModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    GroupParser.m24541a(groupModel.w_(), groupModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(GroupModel.class, new Serializer());
                }
            }

            public GroupModel() {
                super(2);
            }

            public final void m24471a(String str, ConsistencyTuple consistencyTuple) {
                if ("viewer_push_subscription_level".equals(str)) {
                    consistencyTuple.a = m24467k();
                    consistencyTuple.b = u_();
                    consistencyTuple.c = 1;
                    return;
                }
                consistencyTuple.a();
            }

            public final void m24472a(String str, Object obj, boolean z) {
                if ("viewer_push_subscription_level".equals(str)) {
                    m24465a((GraphQLGroupPushSubscriptionLevel) obj);
                }
            }

            @Nullable
            private String m24466j() {
                this.f23176d = super.a(this.f23176d, 0);
                return this.f23176d;
            }

            @Nullable
            private GraphQLGroupPushSubscriptionLevel m24467k() {
                this.f23177e = (GraphQLGroupPushSubscriptionLevel) super.b(this.f23177e, 1, GraphQLGroupPushSubscriptionLevel.class, GraphQLGroupPushSubscriptionLevel.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
                return this.f23177e;
            }

            private void m24465a(GraphQLGroupPushSubscriptionLevel graphQLGroupPushSubscriptionLevel) {
                this.f23177e = graphQLGroupPushSubscriptionLevel;
                if (this.b != null && this.b.d) {
                    this.b.a(this.c, 1, graphQLGroupPushSubscriptionLevel != null ? graphQLGroupPushSubscriptionLevel.name() : null);
                }
            }

            @Nullable
            public final String m24470a() {
                return m24466j();
            }

            public final int jK_() {
                return 69076575;
            }

            public final GraphQLVisitableModel m24469a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m24468a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m24466j());
                int a = flatBufferBuilder.a(m24467k());
                flatBufferBuilder.c(2);
                flatBufferBuilder.b(0, b);
                flatBufferBuilder.b(1, a);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: THREAD_NONEXISTENT */
        public class Serializer extends JsonSerializer<GroupUpdatePushSubscriptionMutationModel> {
            public final void m24473a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                GroupUpdatePushSubscriptionMutationModel groupUpdatePushSubscriptionMutationModel = (GroupUpdatePushSubscriptionMutationModel) obj;
                if (groupUpdatePushSubscriptionMutationModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(groupUpdatePushSubscriptionMutationModel.m24475a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    groupUpdatePushSubscriptionMutationModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = groupUpdatePushSubscriptionMutationModel.w_();
                int u_ = groupUpdatePushSubscriptionMutationModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("group");
                    GroupParser.m24541a(mutableFlatBuffer, g, jsonGenerator);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(GroupUpdatePushSubscriptionMutationModel.class, new Serializer());
            }
        }

        public GroupUpdatePushSubscriptionMutationModel() {
            super(1);
        }

        @Nullable
        private GroupModel m24474a() {
            this.f23178d = (GroupModel) super.a(this.f23178d, 0, GroupModel.class);
            return this.f23178d;
        }

        public final int jK_() {
            return -442085880;
        }

        public final GraphQLVisitableModel m24476a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m24474a() != null) {
                GroupModel groupModel = (GroupModel) graphQLModelMutatingVisitor.b(m24474a());
                if (m24474a() != groupModel) {
                    graphQLVisitableModel = (GroupUpdatePushSubscriptionMutationModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f23178d = groupModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m24475a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m24474a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 1326857863)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: THREAD_NONEXISTENT */
    public final class GroupUpdateRequestToJoinSubscriptionMutationModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private String f23181d;
        @Nullable
        private GroupModel f23182e;

        /* compiled from: THREAD_NONEXISTENT */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(GroupUpdateRequestToJoinSubscriptionMutationModel.class, new Deserializer());
            }

            public Object m24477a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = GroupUpdateRequestToJoinSubscriptionMutationParser.m24545a(jsonParser);
                Object groupUpdateRequestToJoinSubscriptionMutationModel = new GroupUpdateRequestToJoinSubscriptionMutationModel();
                ((BaseModel) groupUpdateRequestToJoinSubscriptionMutationModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (groupUpdateRequestToJoinSubscriptionMutationModel instanceof Postprocessable) {
                    return ((Postprocessable) groupUpdateRequestToJoinSubscriptionMutationModel).a();
                }
                return groupUpdateRequestToJoinSubscriptionMutationModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -1500429791)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: THREAD_NONEXISTENT */
        public final class GroupModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
            @Nullable
            private String f23179d;
            @Nullable
            private GraphQLGroupRequestToJoinSubscriptionLevel f23180e;

            /* compiled from: THREAD_NONEXISTENT */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(GroupModel.class, new Deserializer());
                }

                public Object m24478a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(GroupUpdateRequestToJoinSubscriptionMutationParser.GroupParser.m24543a(jsonParser, flatBufferBuilder));
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

            /* compiled from: THREAD_NONEXISTENT */
            public class Serializer extends JsonSerializer<GroupModel> {
                public final void m24479a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    GroupModel groupModel = (GroupModel) obj;
                    if (groupModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(groupModel.m24482a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        groupModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    GroupUpdateRequestToJoinSubscriptionMutationParser.GroupParser.m24544a(groupModel.w_(), groupModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(GroupModel.class, new Serializer());
                }
            }

            public GroupModel() {
                super(2);
            }

            public final void m24485a(String str, ConsistencyTuple consistencyTuple) {
                consistencyTuple.a();
            }

            public final void m24486a(String str, Object obj, boolean z) {
            }

            @Nullable
            private String m24480j() {
                this.f23179d = super.a(this.f23179d, 0);
                return this.f23179d;
            }

            @Nullable
            private GraphQLGroupRequestToJoinSubscriptionLevel m24481k() {
                this.f23180e = (GraphQLGroupRequestToJoinSubscriptionLevel) super.b(this.f23180e, 1, GraphQLGroupRequestToJoinSubscriptionLevel.class, GraphQLGroupRequestToJoinSubscriptionLevel.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
                return this.f23180e;
            }

            @Nullable
            public final String m24484a() {
                return m24480j();
            }

            public final int jK_() {
                return 69076575;
            }

            public final GraphQLVisitableModel m24483a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m24482a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m24480j());
                int a = flatBufferBuilder.a(m24481k());
                flatBufferBuilder.c(2);
                flatBufferBuilder.b(0, b);
                flatBufferBuilder.b(1, a);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: THREAD_NONEXISTENT */
        public class Serializer extends JsonSerializer<GroupUpdateRequestToJoinSubscriptionMutationModel> {
            public final void m24487a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                GroupUpdateRequestToJoinSubscriptionMutationModel groupUpdateRequestToJoinSubscriptionMutationModel = (GroupUpdateRequestToJoinSubscriptionMutationModel) obj;
                if (groupUpdateRequestToJoinSubscriptionMutationModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(groupUpdateRequestToJoinSubscriptionMutationModel.m24490a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    groupUpdateRequestToJoinSubscriptionMutationModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = groupUpdateRequestToJoinSubscriptionMutationModel.w_();
                int u_ = groupUpdateRequestToJoinSubscriptionMutationModel.u_();
                jsonGenerator.f();
                if (mutableFlatBuffer.g(u_, 0) != 0) {
                    jsonGenerator.a("client_mutation_id");
                    jsonGenerator.b(mutableFlatBuffer.c(u_, 0));
                }
                int g = mutableFlatBuffer.g(u_, 1);
                if (g != 0) {
                    jsonGenerator.a("group");
                    GroupUpdateRequestToJoinSubscriptionMutationParser.GroupParser.m24544a(mutableFlatBuffer, g, jsonGenerator);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(GroupUpdateRequestToJoinSubscriptionMutationModel.class, new Serializer());
            }
        }

        public GroupUpdateRequestToJoinSubscriptionMutationModel() {
            super(2);
        }

        @Nullable
        private String m24488a() {
            this.f23181d = super.a(this.f23181d, 0);
            return this.f23181d;
        }

        @Nullable
        private GroupModel m24489j() {
            this.f23182e = (GroupModel) super.a(this.f23182e, 1, GroupModel.class);
            return this.f23182e;
        }

        public final int jK_() {
            return -881322670;
        }

        public final GraphQLVisitableModel m24491a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m24489j() != null) {
                GroupModel groupModel = (GroupModel) graphQLModelMutatingVisitor.b(m24489j());
                if (m24489j() != groupModel) {
                    graphQLVisitableModel = (GroupUpdateRequestToJoinSubscriptionMutationModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f23182e = groupModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m24490a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int b = flatBufferBuilder.b(m24488a());
            int a = ModelHelper.a(flatBufferBuilder, m24489j());
            flatBufferBuilder.c(2);
            flatBufferBuilder.b(0, b);
            flatBufferBuilder.b(1, a);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -212819279)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: THREAD_NONEXISTENT */
    public final class GroupUpdateSubscriptionMutationModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private String f23185d;
        @Nullable
        private GroupModel f23186e;

        /* compiled from: THREAD_NONEXISTENT */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(GroupUpdateSubscriptionMutationModel.class, new Deserializer());
            }

            public Object m24492a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = GroupUpdateSubscriptionMutationParser.m24548a(jsonParser);
                Object groupUpdateSubscriptionMutationModel = new GroupUpdateSubscriptionMutationModel();
                ((BaseModel) groupUpdateSubscriptionMutationModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (groupUpdateSubscriptionMutationModel instanceof Postprocessable) {
                    return ((Postprocessable) groupUpdateSubscriptionMutationModel).a();
                }
                return groupUpdateSubscriptionMutationModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -749206132)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: THREAD_NONEXISTENT */
        public final class GroupModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
            @Nullable
            private String f23183d;
            @Nullable
            private GraphQLGroupSubscriptionLevel f23184e;

            /* compiled from: THREAD_NONEXISTENT */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(GroupModel.class, new Deserializer());
                }

                public Object m24493a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(GroupUpdateSubscriptionMutationParser.GroupParser.m24546a(jsonParser, flatBufferBuilder));
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

            /* compiled from: THREAD_NONEXISTENT */
            public class Serializer extends JsonSerializer<GroupModel> {
                public final void m24494a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    GroupModel groupModel = (GroupModel) obj;
                    if (groupModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(groupModel.m24498a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        groupModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    GroupUpdateSubscriptionMutationParser.GroupParser.m24547a(groupModel.w_(), groupModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(GroupModel.class, new Serializer());
                }
            }

            public GroupModel() {
                super(2);
            }

            public final void m24501a(String str, ConsistencyTuple consistencyTuple) {
                if ("viewer_subscription_level".equals(str)) {
                    consistencyTuple.a = m24497k();
                    consistencyTuple.b = u_();
                    consistencyTuple.c = 1;
                    return;
                }
                consistencyTuple.a();
            }

            public final void m24502a(String str, Object obj, boolean z) {
                if ("viewer_subscription_level".equals(str)) {
                    m24495a((GraphQLGroupSubscriptionLevel) obj);
                }
            }

            @Nullable
            private String m24496j() {
                this.f23183d = super.a(this.f23183d, 0);
                return this.f23183d;
            }

            @Nullable
            private GraphQLGroupSubscriptionLevel m24497k() {
                this.f23184e = (GraphQLGroupSubscriptionLevel) super.b(this.f23184e, 1, GraphQLGroupSubscriptionLevel.class, GraphQLGroupSubscriptionLevel.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
                return this.f23184e;
            }

            private void m24495a(GraphQLGroupSubscriptionLevel graphQLGroupSubscriptionLevel) {
                this.f23184e = graphQLGroupSubscriptionLevel;
                if (this.b != null && this.b.d) {
                    this.b.a(this.c, 1, graphQLGroupSubscriptionLevel != null ? graphQLGroupSubscriptionLevel.name() : null);
                }
            }

            @Nullable
            public final String m24500a() {
                return m24496j();
            }

            public final int jK_() {
                return 69076575;
            }

            public final GraphQLVisitableModel m24499a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m24498a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m24496j());
                int a = flatBufferBuilder.a(m24497k());
                flatBufferBuilder.c(2);
                flatBufferBuilder.b(0, b);
                flatBufferBuilder.b(1, a);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: THREAD_NONEXISTENT */
        public class Serializer extends JsonSerializer<GroupUpdateSubscriptionMutationModel> {
            public final void m24503a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                GroupUpdateSubscriptionMutationModel groupUpdateSubscriptionMutationModel = (GroupUpdateSubscriptionMutationModel) obj;
                if (groupUpdateSubscriptionMutationModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(groupUpdateSubscriptionMutationModel.m24506a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    groupUpdateSubscriptionMutationModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = groupUpdateSubscriptionMutationModel.w_();
                int u_ = groupUpdateSubscriptionMutationModel.u_();
                jsonGenerator.f();
                if (mutableFlatBuffer.g(u_, 0) != 0) {
                    jsonGenerator.a("client_mutation_id");
                    jsonGenerator.b(mutableFlatBuffer.c(u_, 0));
                }
                int g = mutableFlatBuffer.g(u_, 1);
                if (g != 0) {
                    jsonGenerator.a("group");
                    GroupUpdateSubscriptionMutationParser.GroupParser.m24547a(mutableFlatBuffer, g, jsonGenerator);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(GroupUpdateSubscriptionMutationModel.class, new Serializer());
            }
        }

        public GroupUpdateSubscriptionMutationModel() {
            super(2);
        }

        @Nullable
        private String m24504a() {
            this.f23185d = super.a(this.f23185d, 0);
            return this.f23185d;
        }

        @Nullable
        private GroupModel m24505j() {
            this.f23186e = (GroupModel) super.a(this.f23186e, 1, GroupModel.class);
            return this.f23186e;
        }

        public final int jK_() {
            return -1728129330;
        }

        public final GraphQLVisitableModel m24507a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m24505j() != null) {
                GroupModel groupModel = (GroupModel) graphQLModelMutatingVisitor.b(m24505j());
                if (m24505j() != groupModel) {
                    graphQLVisitableModel = (GroupUpdateSubscriptionMutationModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f23186e = groupModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m24506a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int b = flatBufferBuilder.b(m24504a());
            int a = ModelHelper.a(flatBufferBuilder, m24505j());
            flatBufferBuilder.c(2);
            flatBufferBuilder.b(0, b);
            flatBufferBuilder.b(1, a);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -567524751)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: THREAD_NONEXISTENT */
    public final class MutePushNotificationsMutationModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private String f23197d;
        @Nullable
        private PushTokenModel f23198e;

        /* compiled from: THREAD_NONEXISTENT */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(MutePushNotificationsMutationModel.class, new Deserializer());
            }

            public Object m24508a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = MutePushNotificationsMutationParser.m24555a(jsonParser);
                Object mutePushNotificationsMutationModel = new MutePushNotificationsMutationModel();
                ((BaseModel) mutePushNotificationsMutationModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (mutePushNotificationsMutationModel instanceof Postprocessable) {
                    return ((Postprocessable) mutePushNotificationsMutationModel).a();
                }
                return mutePushNotificationsMutationModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 49442367)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: THREAD_NONEXISTENT */
        public final class PushTokenModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private ApplicationModel f23194d;
            private long f23195e;
            @Nullable
            private OwnerModel f23196f;

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = 415735059)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: THREAD_NONEXISTENT */
            public final class ApplicationModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableModel {
                @Nullable
                private String f23187d;
                @Nullable
                private String f23188e;
                @Nullable
                private String f23189f;

                /* compiled from: THREAD_NONEXISTENT */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(ApplicationModel.class, new Deserializer());
                    }

                    public Object m24509a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(ApplicationParser.m24549a(jsonParser, flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        mutableFlatBuffer.a(4, Boolean.valueOf(true));
                        MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                        Object applicationModel = new ApplicationModel();
                        ((BaseModel) applicationModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                        if (applicationModel instanceof Postprocessable) {
                            return ((Postprocessable) applicationModel).a();
                        }
                        return applicationModel;
                    }
                }

                /* compiled from: THREAD_NONEXISTENT */
                public class Serializer extends JsonSerializer<ApplicationModel> {
                    public final void m24510a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        ApplicationModel applicationModel = (ApplicationModel) obj;
                        if (applicationModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(applicationModel.m24514a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            applicationModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        ApplicationParser.m24550a(applicationModel.w_(), applicationModel.u_(), jsonGenerator);
                    }

                    static {
                        FbSerializerProvider.a(ApplicationModel.class, new Serializer());
                    }
                }

                public ApplicationModel() {
                    super(3);
                }

                @Nullable
                private String m24511j() {
                    this.f23187d = super.a(this.f23187d, 0);
                    return this.f23187d;
                }

                @Nullable
                private String m24512k() {
                    this.f23188e = super.a(this.f23188e, 1);
                    return this.f23188e;
                }

                @Nullable
                private String m24513l() {
                    this.f23189f = super.a(this.f23189f, 2);
                    return this.f23189f;
                }

                @Nullable
                public final String m24516a() {
                    return m24511j();
                }

                public final int jK_() {
                    return -1072845520;
                }

                public final GraphQLVisitableModel m24515a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    h();
                    i();
                    return this;
                }

                public final int m24514a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int b = flatBufferBuilder.b(m24511j());
                    int b2 = flatBufferBuilder.b(m24512k());
                    int b3 = flatBufferBuilder.b(m24513l());
                    flatBufferBuilder.c(3);
                    flatBufferBuilder.b(0, b);
                    flatBufferBuilder.b(1, b2);
                    flatBufferBuilder.b(2, b3);
                    i();
                    return flatBufferBuilder.d();
                }
            }

            /* compiled from: THREAD_NONEXISTENT */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(PushTokenModel.class, new Deserializer());
                }

                public Object m24517a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(PushTokenParser.m24553a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object pushTokenModel = new PushTokenModel();
                    ((BaseModel) pushTokenModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (pushTokenModel instanceof Postprocessable) {
                        return ((Postprocessable) pushTokenModel).a();
                    }
                    return pushTokenModel;
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = 1821837936)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: THREAD_NONEXISTENT */
            public final class OwnerModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
                @Nullable
                private GraphQLObjectType f23190d;
                @Nullable
                private String f23191e;
                @Nullable
                private String f23192f;
                @Nullable
                private String f23193g;

                /* compiled from: THREAD_NONEXISTENT */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(OwnerModel.class, new Deserializer());
                    }

                    public Object m24518a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(OwnerParser.m24551a(jsonParser, flatBufferBuilder));
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

                /* compiled from: THREAD_NONEXISTENT */
                public class Serializer extends JsonSerializer<OwnerModel> {
                    public final void m24519a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        OwnerModel ownerModel = (OwnerModel) obj;
                        if (ownerModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(ownerModel.m24524a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            ownerModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        OwnerParser.m24552a(ownerModel.w_(), ownerModel.u_(), jsonGenerator);
                    }

                    static {
                        FbSerializerProvider.a(OwnerModel.class, new Serializer());
                    }
                }

                public OwnerModel() {
                    super(4);
                }

                public final void m24527a(String str, ConsistencyTuple consistencyTuple) {
                    consistencyTuple.a();
                }

                public final void m24528a(String str, Object obj, boolean z) {
                }

                @Nullable
                private GraphQLObjectType m24520j() {
                    if (this.b != null && this.f23190d == null) {
                        this.f23190d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
                    }
                    return this.f23190d;
                }

                @Nullable
                private String m24521k() {
                    this.f23191e = super.a(this.f23191e, 1);
                    return this.f23191e;
                }

                @Nullable
                private String m24522l() {
                    this.f23192f = super.a(this.f23192f, 2);
                    return this.f23192f;
                }

                @Nullable
                private String m24523m() {
                    this.f23193g = super.a(this.f23193g, 3);
                    return this.f23193g;
                }

                @Nullable
                public final String m24526a() {
                    return m24521k();
                }

                public final int jK_() {
                    return 63093205;
                }

                public final GraphQLVisitableModel m24525a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    h();
                    i();
                    return this;
                }

                public final int m24524a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int a = ModelHelper.a(flatBufferBuilder, m24520j());
                    int b = flatBufferBuilder.b(m24521k());
                    int b2 = flatBufferBuilder.b(m24522l());
                    int b3 = flatBufferBuilder.b(m24523m());
                    flatBufferBuilder.c(4);
                    flatBufferBuilder.b(0, a);
                    flatBufferBuilder.b(1, b);
                    flatBufferBuilder.b(2, b2);
                    flatBufferBuilder.b(3, b3);
                    i();
                    return flatBufferBuilder.d();
                }
            }

            /* compiled from: THREAD_NONEXISTENT */
            public class Serializer extends JsonSerializer<PushTokenModel> {
                public final void m24529a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    PushTokenModel pushTokenModel = (PushTokenModel) obj;
                    if (pushTokenModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(pushTokenModel.m24532a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        pushTokenModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    PushTokenParser.m24554a(pushTokenModel.w_(), pushTokenModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(PushTokenModel.class, new Serializer());
                }
            }

            public PushTokenModel() {
                super(3);
            }

            @Nullable
            private ApplicationModel m24530a() {
                this.f23194d = (ApplicationModel) super.a(this.f23194d, 0, ApplicationModel.class);
                return this.f23194d;
            }

            @Nullable
            private OwnerModel m24531j() {
                this.f23196f = (OwnerModel) super.a(this.f23196f, 2, OwnerModel.class);
                return this.f23196f;
            }

            public final int jK_() {
                return 1225038559;
            }

            public final GraphQLVisitableModel m24533a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m24530a() != null) {
                    ApplicationModel applicationModel = (ApplicationModel) graphQLModelMutatingVisitor.b(m24530a());
                    if (m24530a() != applicationModel) {
                        graphQLVisitableModel = (PushTokenModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f23194d = applicationModel;
                    }
                }
                if (m24531j() != null) {
                    OwnerModel ownerModel = (OwnerModel) graphQLModelMutatingVisitor.b(m24531j());
                    if (m24531j() != ownerModel) {
                        graphQLVisitableModel = (PushTokenModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f23196f = ownerModel;
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m24532a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m24530a());
                int a2 = ModelHelper.a(flatBufferBuilder, m24531j());
                flatBufferBuilder.c(3);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.a(1, this.f23195e, 0);
                flatBufferBuilder.b(2, a2);
                i();
                return flatBufferBuilder.d();
            }

            public final void m24534a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                super.a(mutableFlatBuffer, i, obj);
                this.f23195e = mutableFlatBuffer.a(i, 1, 0);
            }
        }

        /* compiled from: THREAD_NONEXISTENT */
        public class Serializer extends JsonSerializer<MutePushNotificationsMutationModel> {
            public final void m24535a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                MutePushNotificationsMutationModel mutePushNotificationsMutationModel = (MutePushNotificationsMutationModel) obj;
                if (mutePushNotificationsMutationModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(mutePushNotificationsMutationModel.m24538a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutePushNotificationsMutationModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = mutePushNotificationsMutationModel.w_();
                int u_ = mutePushNotificationsMutationModel.u_();
                jsonGenerator.f();
                if (mutableFlatBuffer.g(u_, 0) != 0) {
                    jsonGenerator.a("client_mutation_id");
                    jsonGenerator.b(mutableFlatBuffer.c(u_, 0));
                }
                int g = mutableFlatBuffer.g(u_, 1);
                if (g != 0) {
                    jsonGenerator.a("push_token");
                    PushTokenParser.m24554a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(MutePushNotificationsMutationModel.class, new Serializer());
            }
        }

        public MutePushNotificationsMutationModel() {
            super(2);
        }

        @Nullable
        private String m24536a() {
            this.f23197d = super.a(this.f23197d, 0);
            return this.f23197d;
        }

        @Nullable
        private PushTokenModel m24537j() {
            this.f23198e = (PushTokenModel) super.a(this.f23198e, 1, PushTokenModel.class);
            return this.f23198e;
        }

        public final int jK_() {
            return -344974915;
        }

        public final GraphQLVisitableModel m24539a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m24537j() != null) {
                PushTokenModel pushTokenModel = (PushTokenModel) graphQLModelMutatingVisitor.b(m24537j());
                if (m24537j() != pushTokenModel) {
                    graphQLVisitableModel = (MutePushNotificationsMutationModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f23198e = pushTokenModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m24538a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int b = flatBufferBuilder.b(m24536a());
            int a = ModelHelper.a(flatBufferBuilder, m24537j());
            flatBufferBuilder.c(2);
            flatBufferBuilder.b(0, b);
            flatBufferBuilder.b(1, a);
            i();
            return flatBufferBuilder.d();
        }
    }
}
