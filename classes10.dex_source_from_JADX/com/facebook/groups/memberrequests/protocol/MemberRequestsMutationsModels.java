package com.facebook.groups.memberrequests.protocol;

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
import com.facebook.groups.memberrequests.protocol.MemberRequestsMutationsParsers.GroupApproveAllPendingMembersMutationParser;
import com.facebook.groups.memberrequests.protocol.MemberRequestsMutationsParsers.GroupApprovePendingMemberMutationParser;
import com.facebook.groups.memberrequests.protocol.MemberRequestsMutationsParsers.GroupRejectAllPendingMembersMutationParser;
import com.facebook.groups.memberrequests.protocol.MemberRequestsMutationsParsers.GroupRejectPendingMemberMutationParser;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.nio.ByteBuffer;
import javax.annotation.Nullable;

/* compiled from: TRANSIENT */
public class MemberRequestsMutationsModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -2642782)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: TRANSIENT */
    public final class GroupApproveAllPendingMembersMutationModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private String f22987d;

        /* compiled from: TRANSIENT */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(GroupApproveAllPendingMembersMutationModel.class, new Deserializer());
            }

            public Object m24184a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = GroupApproveAllPendingMembersMutationParser.m24204a(jsonParser);
                Object groupApproveAllPendingMembersMutationModel = new GroupApproveAllPendingMembersMutationModel();
                ((BaseModel) groupApproveAllPendingMembersMutationModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (groupApproveAllPendingMembersMutationModel instanceof Postprocessable) {
                    return ((Postprocessable) groupApproveAllPendingMembersMutationModel).a();
                }
                return groupApproveAllPendingMembersMutationModel;
            }
        }

        /* compiled from: TRANSIENT */
        public class Serializer extends JsonSerializer<GroupApproveAllPendingMembersMutationModel> {
            public final void m24185a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                GroupApproveAllPendingMembersMutationModel groupApproveAllPendingMembersMutationModel = (GroupApproveAllPendingMembersMutationModel) obj;
                if (groupApproveAllPendingMembersMutationModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(groupApproveAllPendingMembersMutationModel.m24187a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    groupApproveAllPendingMembersMutationModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = groupApproveAllPendingMembersMutationModel.w_();
                int u_ = groupApproveAllPendingMembersMutationModel.u_();
                jsonGenerator.f();
                if (mutableFlatBuffer.g(u_, 0) != 0) {
                    jsonGenerator.a("client_mutation_id");
                    jsonGenerator.b(mutableFlatBuffer.c(u_, 0));
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(GroupApproveAllPendingMembersMutationModel.class, new Serializer());
            }
        }

        public GroupApproveAllPendingMembersMutationModel() {
            super(1);
        }

        @Nullable
        private String m24186a() {
            this.f22987d = super.a(this.f22987d, 0);
            return this.f22987d;
        }

        public final int jK_() {
            return -1024955368;
        }

        public final GraphQLVisitableModel m24188a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            h();
            i();
            return this;
        }

        public final int m24187a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int b = flatBufferBuilder.b(m24186a());
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
    /* compiled from: TRANSIENT */
    public final class GroupApprovePendingMemberMutationModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private String f22988d;

        /* compiled from: TRANSIENT */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(GroupApprovePendingMemberMutationModel.class, new Deserializer());
            }

            public Object m24189a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = GroupApprovePendingMemberMutationParser.m24205a(jsonParser);
                Object groupApprovePendingMemberMutationModel = new GroupApprovePendingMemberMutationModel();
                ((BaseModel) groupApprovePendingMemberMutationModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (groupApprovePendingMemberMutationModel instanceof Postprocessable) {
                    return ((Postprocessable) groupApprovePendingMemberMutationModel).a();
                }
                return groupApprovePendingMemberMutationModel;
            }
        }

        /* compiled from: TRANSIENT */
        public class Serializer extends JsonSerializer<GroupApprovePendingMemberMutationModel> {
            public final void m24190a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                GroupApprovePendingMemberMutationModel groupApprovePendingMemberMutationModel = (GroupApprovePendingMemberMutationModel) obj;
                if (groupApprovePendingMemberMutationModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(groupApprovePendingMemberMutationModel.m24192a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    groupApprovePendingMemberMutationModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = groupApprovePendingMemberMutationModel.w_();
                int u_ = groupApprovePendingMemberMutationModel.u_();
                jsonGenerator.f();
                if (mutableFlatBuffer.g(u_, 0) != 0) {
                    jsonGenerator.a("client_mutation_id");
                    jsonGenerator.b(mutableFlatBuffer.c(u_, 0));
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(GroupApprovePendingMemberMutationModel.class, new Serializer());
            }
        }

        public GroupApprovePendingMemberMutationModel() {
            super(1);
        }

        @Nullable
        private String m24191a() {
            this.f22988d = super.a(this.f22988d, 0);
            return this.f22988d;
        }

        public final int jK_() {
            return -1723291190;
        }

        public final GraphQLVisitableModel m24193a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            h();
            i();
            return this;
        }

        public final int m24192a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int b = flatBufferBuilder.b(m24191a());
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
    /* compiled from: TRANSIENT */
    public final class GroupRejectAllPendingMembersMutationModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private String f22989d;

        /* compiled from: TRANSIENT */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(GroupRejectAllPendingMembersMutationModel.class, new Deserializer());
            }

            public Object m24194a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = GroupRejectAllPendingMembersMutationParser.m24206a(jsonParser);
                Object groupRejectAllPendingMembersMutationModel = new GroupRejectAllPendingMembersMutationModel();
                ((BaseModel) groupRejectAllPendingMembersMutationModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (groupRejectAllPendingMembersMutationModel instanceof Postprocessable) {
                    return ((Postprocessable) groupRejectAllPendingMembersMutationModel).a();
                }
                return groupRejectAllPendingMembersMutationModel;
            }
        }

        /* compiled from: TRANSIENT */
        public class Serializer extends JsonSerializer<GroupRejectAllPendingMembersMutationModel> {
            public final void m24195a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                GroupRejectAllPendingMembersMutationModel groupRejectAllPendingMembersMutationModel = (GroupRejectAllPendingMembersMutationModel) obj;
                if (groupRejectAllPendingMembersMutationModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(groupRejectAllPendingMembersMutationModel.m24197a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    groupRejectAllPendingMembersMutationModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = groupRejectAllPendingMembersMutationModel.w_();
                int u_ = groupRejectAllPendingMembersMutationModel.u_();
                jsonGenerator.f();
                if (mutableFlatBuffer.g(u_, 0) != 0) {
                    jsonGenerator.a("client_mutation_id");
                    jsonGenerator.b(mutableFlatBuffer.c(u_, 0));
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(GroupRejectAllPendingMembersMutationModel.class, new Serializer());
            }
        }

        public GroupRejectAllPendingMembersMutationModel() {
            super(1);
        }

        @Nullable
        private String m24196a() {
            this.f22989d = super.a(this.f22989d, 0);
            return this.f22989d;
        }

        public final int jK_() {
            return -2038557944;
        }

        public final GraphQLVisitableModel m24198a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            h();
            i();
            return this;
        }

        public final int m24197a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int b = flatBufferBuilder.b(m24196a());
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
    /* compiled from: TRANSIENT */
    public final class GroupRejectPendingMemberMutationModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private String f22990d;

        /* compiled from: TRANSIENT */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(GroupRejectPendingMemberMutationModel.class, new Deserializer());
            }

            public Object m24199a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = GroupRejectPendingMemberMutationParser.m24207a(jsonParser);
                Object groupRejectPendingMemberMutationModel = new GroupRejectPendingMemberMutationModel();
                ((BaseModel) groupRejectPendingMemberMutationModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (groupRejectPendingMemberMutationModel instanceof Postprocessable) {
                    return ((Postprocessable) groupRejectPendingMemberMutationModel).a();
                }
                return groupRejectPendingMemberMutationModel;
            }
        }

        /* compiled from: TRANSIENT */
        public class Serializer extends JsonSerializer<GroupRejectPendingMemberMutationModel> {
            public final void m24200a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                GroupRejectPendingMemberMutationModel groupRejectPendingMemberMutationModel = (GroupRejectPendingMemberMutationModel) obj;
                if (groupRejectPendingMemberMutationModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(groupRejectPendingMemberMutationModel.m24202a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    groupRejectPendingMemberMutationModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = groupRejectPendingMemberMutationModel.w_();
                int u_ = groupRejectPendingMemberMutationModel.u_();
                jsonGenerator.f();
                if (mutableFlatBuffer.g(u_, 0) != 0) {
                    jsonGenerator.a("client_mutation_id");
                    jsonGenerator.b(mutableFlatBuffer.c(u_, 0));
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(GroupRejectPendingMemberMutationModel.class, new Serializer());
            }
        }

        public GroupRejectPendingMemberMutationModel() {
            super(1);
        }

        @Nullable
        private String m24201a() {
            this.f22990d = super.a(this.f22990d, 0);
            return this.f22990d;
        }

        public final int jK_() {
            return 1009207482;
        }

        public final GraphQLVisitableModel m24203a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            h();
            i();
            return this;
        }

        public final int m24202a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int b = flatBufferBuilder.b(m24201a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, b);
            i();
            return flatBufferBuilder.d();
        }
    }
}
