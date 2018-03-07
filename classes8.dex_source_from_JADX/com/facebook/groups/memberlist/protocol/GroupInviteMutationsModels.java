package com.facebook.groups.memberlist.protocol;

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
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.facebook.groups.memberlist.protocol.GroupInviteMutationsParsers.GroupRemoveInviteMutationParser;
import com.facebook.groups.memberlist.protocol.GroupInviteMutationsParsers.GroupSendReminderMutationParser;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.nio.ByteBuffer;
import javax.annotation.Nullable;

/* compiled from: extra_enable_invite_through_messenger */
public class GroupInviteMutationsModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -2642782)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: extra_enable_invite_through_messenger */
    public final class GroupRemoveInviteMutationModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private String f14547d;

        /* compiled from: extra_enable_invite_through_messenger */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(GroupRemoveInviteMutationModel.class, new Deserializer());
            }

            public Object m16335a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = GroupRemoveInviteMutationParser.m16345a(jsonParser);
                Object groupRemoveInviteMutationModel = new GroupRemoveInviteMutationModel();
                ((BaseModel) groupRemoveInviteMutationModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (groupRemoveInviteMutationModel instanceof Postprocessable) {
                    return ((Postprocessable) groupRemoveInviteMutationModel).a();
                }
                return groupRemoveInviteMutationModel;
            }
        }

        /* compiled from: extra_enable_invite_through_messenger */
        public class Serializer extends JsonSerializer<GroupRemoveInviteMutationModel> {
            public final void m16336a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                GroupRemoveInviteMutationModel groupRemoveInviteMutationModel = (GroupRemoveInviteMutationModel) obj;
                if (groupRemoveInviteMutationModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(groupRemoveInviteMutationModel.m16338a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    groupRemoveInviteMutationModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = groupRemoveInviteMutationModel.w_();
                int u_ = groupRemoveInviteMutationModel.u_();
                jsonGenerator.f();
                if (mutableFlatBuffer.g(u_, 0) != 0) {
                    jsonGenerator.a("client_mutation_id");
                    jsonGenerator.b(mutableFlatBuffer.c(u_, 0));
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(GroupRemoveInviteMutationModel.class, new Serializer());
            }
        }

        public GroupRemoveInviteMutationModel() {
            super(1);
        }

        @Nullable
        private String m16337a() {
            this.f14547d = super.a(this.f14547d, 0);
            return this.f14547d;
        }

        public final int jK_() {
            return 714607199;
        }

        public final GraphQLVisitableModel m16339a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            h();
            i();
            return this;
        }

        public final int m16338a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int b = flatBufferBuilder.b(m16337a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, b);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -2642782)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: extra_enable_invite_through_messenger */
    public final class GroupSendReminderMutationModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private String f14548d;

        /* compiled from: extra_enable_invite_through_messenger */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(GroupSendReminderMutationModel.class, new Deserializer());
            }

            public Object m16340a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = GroupSendReminderMutationParser.m16346a(jsonParser);
                Object groupSendReminderMutationModel = new GroupSendReminderMutationModel();
                ((BaseModel) groupSendReminderMutationModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (groupSendReminderMutationModel instanceof Postprocessable) {
                    return ((Postprocessable) groupSendReminderMutationModel).a();
                }
                return groupSendReminderMutationModel;
            }
        }

        /* compiled from: extra_enable_invite_through_messenger */
        public class Serializer extends JsonSerializer<GroupSendReminderMutationModel> {
            public final void m16341a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                GroupSendReminderMutationModel groupSendReminderMutationModel = (GroupSendReminderMutationModel) obj;
                if (groupSendReminderMutationModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(groupSendReminderMutationModel.m16343a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    groupSendReminderMutationModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = groupSendReminderMutationModel.w_();
                int u_ = groupSendReminderMutationModel.u_();
                jsonGenerator.f();
                if (mutableFlatBuffer.g(u_, 0) != 0) {
                    jsonGenerator.a("client_mutation_id");
                    jsonGenerator.b(mutableFlatBuffer.c(u_, 0));
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(GroupSendReminderMutationModel.class, new Serializer());
            }
        }

        public GroupSendReminderMutationModel() {
            super(1);
        }

        @Nullable
        private String m16342a() {
            this.f14548d = super.a(this.f14548d, 0);
            return this.f14548d;
        }

        public final int jK_() {
            return 1521473362;
        }

        public final GraphQLVisitableModel m16344a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            h();
            i();
            return this;
        }

        public final int m16343a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int b = flatBufferBuilder.b(m16342a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, b);
            i();
            return flatBufferBuilder.d();
        }
    }
}
