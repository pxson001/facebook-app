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
import com.facebook.groups.memberlist.protocol.GroupMemberAdminMutationsParsers.GroupAddAdminMutationParser;
import com.facebook.groups.memberlist.protocol.GroupMemberAdminMutationsParsers.GroupBlockMutationParser;
import com.facebook.groups.memberlist.protocol.GroupMemberAdminMutationsParsers.GroupRemoveAdminMutationParser;
import com.facebook.groups.memberlist.protocol.GroupMemberAdminMutationsParsers.GroupRemoveMemberMutationParser;
import com.facebook.groups.memberlist.protocol.GroupMemberAdminMutationsParsers.GroupSuggestAdminMutationParser;
import com.facebook.groups.memberlist.protocol.GroupMemberAdminMutationsParsers.GroupUnblockMutationParser;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.nio.ByteBuffer;
import javax.annotation.Nullable;

/* compiled from: extra_cleared_location */
public class GroupMemberAdminMutationsModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -2642782)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: extra_cleared_location */
    public final class GroupAddAdminMutationModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private String f14549d;

        /* compiled from: extra_cleared_location */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(GroupAddAdminMutationModel.class, new Deserializer());
            }

            public Object m16357a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = GroupAddAdminMutationParser.m16387a(jsonParser);
                Object groupAddAdminMutationModel = new GroupAddAdminMutationModel();
                ((BaseModel) groupAddAdminMutationModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (groupAddAdminMutationModel instanceof Postprocessable) {
                    return ((Postprocessable) groupAddAdminMutationModel).a();
                }
                return groupAddAdminMutationModel;
            }
        }

        /* compiled from: extra_cleared_location */
        public class Serializer extends JsonSerializer<GroupAddAdminMutationModel> {
            public final void m16358a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                GroupAddAdminMutationModel groupAddAdminMutationModel = (GroupAddAdminMutationModel) obj;
                if (groupAddAdminMutationModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(groupAddAdminMutationModel.m16360a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    groupAddAdminMutationModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = groupAddAdminMutationModel.w_();
                int u_ = groupAddAdminMutationModel.u_();
                jsonGenerator.f();
                if (mutableFlatBuffer.g(u_, 0) != 0) {
                    jsonGenerator.a("client_mutation_id");
                    jsonGenerator.b(mutableFlatBuffer.c(u_, 0));
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(GroupAddAdminMutationModel.class, new Serializer());
            }
        }

        public GroupAddAdminMutationModel() {
            super(1);
        }

        @Nullable
        private String m16359a() {
            this.f14549d = super.a(this.f14549d, 0);
            return this.f14549d;
        }

        public final int jK_() {
            return -1430372448;
        }

        public final GraphQLVisitableModel m16361a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            h();
            i();
            return this;
        }

        public final int m16360a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int b = flatBufferBuilder.b(m16359a());
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
    /* compiled from: extra_cleared_location */
    public final class GroupBlockMutationModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private String f14550d;

        /* compiled from: extra_cleared_location */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(GroupBlockMutationModel.class, new Deserializer());
            }

            public Object m16362a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = GroupBlockMutationParser.m16388a(jsonParser);
                Object groupBlockMutationModel = new GroupBlockMutationModel();
                ((BaseModel) groupBlockMutationModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (groupBlockMutationModel instanceof Postprocessable) {
                    return ((Postprocessable) groupBlockMutationModel).a();
                }
                return groupBlockMutationModel;
            }
        }

        /* compiled from: extra_cleared_location */
        public class Serializer extends JsonSerializer<GroupBlockMutationModel> {
            public final void m16363a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                GroupBlockMutationModel groupBlockMutationModel = (GroupBlockMutationModel) obj;
                if (groupBlockMutationModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(groupBlockMutationModel.m16365a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    groupBlockMutationModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = groupBlockMutationModel.w_();
                int u_ = groupBlockMutationModel.u_();
                jsonGenerator.f();
                if (mutableFlatBuffer.g(u_, 0) != 0) {
                    jsonGenerator.a("client_mutation_id");
                    jsonGenerator.b(mutableFlatBuffer.c(u_, 0));
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(GroupBlockMutationModel.class, new Serializer());
            }
        }

        public GroupBlockMutationModel() {
            super(1);
        }

        @Nullable
        private String m16364a() {
            this.f14550d = super.a(this.f14550d, 0);
            return this.f14550d;
        }

        public final int jK_() {
            return -182171969;
        }

        public final GraphQLVisitableModel m16366a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            h();
            i();
            return this;
        }

        public final int m16365a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int b = flatBufferBuilder.b(m16364a());
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
    /* compiled from: extra_cleared_location */
    public final class GroupRemoveAdminMutationModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private String f14551d;

        /* compiled from: extra_cleared_location */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(GroupRemoveAdminMutationModel.class, new Deserializer());
            }

            public Object m16367a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = GroupRemoveAdminMutationParser.m16389a(jsonParser);
                Object groupRemoveAdminMutationModel = new GroupRemoveAdminMutationModel();
                ((BaseModel) groupRemoveAdminMutationModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (groupRemoveAdminMutationModel instanceof Postprocessable) {
                    return ((Postprocessable) groupRemoveAdminMutationModel).a();
                }
                return groupRemoveAdminMutationModel;
            }
        }

        /* compiled from: extra_cleared_location */
        public class Serializer extends JsonSerializer<GroupRemoveAdminMutationModel> {
            public final void m16368a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                GroupRemoveAdminMutationModel groupRemoveAdminMutationModel = (GroupRemoveAdminMutationModel) obj;
                if (groupRemoveAdminMutationModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(groupRemoveAdminMutationModel.m16370a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    groupRemoveAdminMutationModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = groupRemoveAdminMutationModel.w_();
                int u_ = groupRemoveAdminMutationModel.u_();
                jsonGenerator.f();
                if (mutableFlatBuffer.g(u_, 0) != 0) {
                    jsonGenerator.a("client_mutation_id");
                    jsonGenerator.b(mutableFlatBuffer.c(u_, 0));
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(GroupRemoveAdminMutationModel.class, new Serializer());
            }
        }

        public GroupRemoveAdminMutationModel() {
            super(1);
        }

        @Nullable
        private String m16369a() {
            this.f14551d = super.a(this.f14551d, 0);
            return this.f14551d;
        }

        public final int jK_() {
            return -351980767;
        }

        public final GraphQLVisitableModel m16371a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            h();
            i();
            return this;
        }

        public final int m16370a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int b = flatBufferBuilder.b(m16369a());
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
    /* compiled from: extra_cleared_location */
    public final class GroupRemoveMemberMutationModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private String f14552d;

        /* compiled from: extra_cleared_location */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(GroupRemoveMemberMutationModel.class, new Deserializer());
            }

            public Object m16372a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = GroupRemoveMemberMutationParser.m16390a(jsonParser);
                Object groupRemoveMemberMutationModel = new GroupRemoveMemberMutationModel();
                ((BaseModel) groupRemoveMemberMutationModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (groupRemoveMemberMutationModel instanceof Postprocessable) {
                    return ((Postprocessable) groupRemoveMemberMutationModel).a();
                }
                return groupRemoveMemberMutationModel;
            }
        }

        /* compiled from: extra_cleared_location */
        public class Serializer extends JsonSerializer<GroupRemoveMemberMutationModel> {
            public final void m16373a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                GroupRemoveMemberMutationModel groupRemoveMemberMutationModel = (GroupRemoveMemberMutationModel) obj;
                if (groupRemoveMemberMutationModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(groupRemoveMemberMutationModel.m16375a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    groupRemoveMemberMutationModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = groupRemoveMemberMutationModel.w_();
                int u_ = groupRemoveMemberMutationModel.u_();
                jsonGenerator.f();
                if (mutableFlatBuffer.g(u_, 0) != 0) {
                    jsonGenerator.a("client_mutation_id");
                    jsonGenerator.b(mutableFlatBuffer.c(u_, 0));
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(GroupRemoveMemberMutationModel.class, new Serializer());
            }
        }

        public GroupRemoveMemberMutationModel() {
            super(1);
        }

        @Nullable
        private String m16374a() {
            this.f14552d = super.a(this.f14552d, 0);
            return this.f14552d;
        }

        public final int jK_() {
            return -2086068208;
        }

        public final GraphQLVisitableModel m16376a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            h();
            i();
            return this;
        }

        public final int m16375a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int b = flatBufferBuilder.b(m16374a());
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
    /* compiled from: extra_cleared_location */
    public final class GroupSuggestAdminMutationModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private String f14553d;

        /* compiled from: extra_cleared_location */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(GroupSuggestAdminMutationModel.class, new Deserializer());
            }

            public Object m16377a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = GroupSuggestAdminMutationParser.m16391a(jsonParser);
                Object groupSuggestAdminMutationModel = new GroupSuggestAdminMutationModel();
                ((BaseModel) groupSuggestAdminMutationModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (groupSuggestAdminMutationModel instanceof Postprocessable) {
                    return ((Postprocessable) groupSuggestAdminMutationModel).a();
                }
                return groupSuggestAdminMutationModel;
            }
        }

        /* compiled from: extra_cleared_location */
        public class Serializer extends JsonSerializer<GroupSuggestAdminMutationModel> {
            public final void m16378a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                GroupSuggestAdminMutationModel groupSuggestAdminMutationModel = (GroupSuggestAdminMutationModel) obj;
                if (groupSuggestAdminMutationModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(groupSuggestAdminMutationModel.m16380a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    groupSuggestAdminMutationModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = groupSuggestAdminMutationModel.w_();
                int u_ = groupSuggestAdminMutationModel.u_();
                jsonGenerator.f();
                if (mutableFlatBuffer.g(u_, 0) != 0) {
                    jsonGenerator.a("client_mutation_id");
                    jsonGenerator.b(mutableFlatBuffer.c(u_, 0));
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(GroupSuggestAdminMutationModel.class, new Serializer());
            }
        }

        public GroupSuggestAdminMutationModel() {
            super(1);
        }

        @Nullable
        private String m16379a() {
            this.f14553d = super.a(this.f14553d, 0);
            return this.f14553d;
        }

        public final int jK_() {
            return -1684492669;
        }

        public final GraphQLVisitableModel m16381a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            h();
            i();
            return this;
        }

        public final int m16380a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int b = flatBufferBuilder.b(m16379a());
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
    /* compiled from: extra_cleared_location */
    public final class GroupUnblockMutationModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private String f14554d;

        /* compiled from: extra_cleared_location */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(GroupUnblockMutationModel.class, new Deserializer());
            }

            public Object m16382a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = GroupUnblockMutationParser.m16392a(jsonParser);
                Object groupUnblockMutationModel = new GroupUnblockMutationModel();
                ((BaseModel) groupUnblockMutationModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (groupUnblockMutationModel instanceof Postprocessable) {
                    return ((Postprocessable) groupUnblockMutationModel).a();
                }
                return groupUnblockMutationModel;
            }
        }

        /* compiled from: extra_cleared_location */
        public class Serializer extends JsonSerializer<GroupUnblockMutationModel> {
            public final void m16383a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                GroupUnblockMutationModel groupUnblockMutationModel = (GroupUnblockMutationModel) obj;
                if (groupUnblockMutationModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(groupUnblockMutationModel.m16385a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    groupUnblockMutationModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = groupUnblockMutationModel.w_();
                int u_ = groupUnblockMutationModel.u_();
                jsonGenerator.f();
                if (mutableFlatBuffer.g(u_, 0) != 0) {
                    jsonGenerator.a("client_mutation_id");
                    jsonGenerator.b(mutableFlatBuffer.c(u_, 0));
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(GroupUnblockMutationModel.class, new Serializer());
            }
        }

        public GroupUnblockMutationModel() {
            super(1);
        }

        @Nullable
        private String m16384a() {
            this.f14554d = super.a(this.f14554d, 0);
            return this.f14554d;
        }

        public final int jK_() {
            return -278877619;
        }

        public final GraphQLVisitableModel m16386a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            h();
            i();
            return this;
        }

        public final int m16385a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int b = flatBufferBuilder.b(m16384a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, b);
            i();
            return flatBufferBuilder.d();
        }
    }
}
