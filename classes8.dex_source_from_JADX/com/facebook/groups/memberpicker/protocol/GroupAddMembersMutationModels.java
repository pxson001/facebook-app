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
import com.facebook.groups.memberpicker.protocol.GroupAddMembersMutationParsers.GroupAddMembersMutationParser;
import com.facebook.groups.memberpicker.protocol.GroupAddMembersMutationParsers.GroupAddMembersMutationParser.AddedUsersParser;
import com.facebook.groups.memberpicker.protocol.GroupAddMembersMutationParsers.GroupAddMembersMutationParser.AlreadyAddedUsersParser;
import com.facebook.groups.memberpicker.protocol.GroupAddMembersMutationParsers.GroupAddMembersMutationParser.AlreadyInvitedUsersParser;
import com.facebook.groups.memberpicker.protocol.GroupAddMembersMutationParsers.GroupAddMembersMutationParser.FailedUsersParser;
import com.facebook.groups.memberpicker.protocol.GroupAddMembersMutationParsers.GroupAddMembersMutationParser.InvitedUsersParser;
import com.facebook.groups.memberpicker.protocol.GroupAddMembersMutationParsers.GroupAddMembersMutationParser.RequestedUsersParser;
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

/* compiled from: exact */
public class GroupAddMembersMutationModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 1500659256)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: exact */
    public final class GroupAddMembersMutationModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private List<AddedUsersModel> f14640d;
        @Nullable
        private List<AlreadyAddedUsersModel> f14641e;
        @Nullable
        private List<AlreadyInvitedUsersModel> f14642f;
        @Nullable
        private String f14643g;
        @Nullable
        private List<FailedUsersModel> f14644h;
        @Nullable
        private List<InvitedUsersModel> f14645i;
        @Nullable
        private List<RequestedUsersModel> f14646j;

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 1801334754)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: exact */
        public final class AddedUsersModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
            @Nullable
            private String f14634d;

            /* compiled from: exact */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(AddedUsersModel.class, new Deserializer());
                }

                public Object m16523a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(AddedUsersParser.m16583b(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object addedUsersModel = new AddedUsersModel();
                    ((BaseModel) addedUsersModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (addedUsersModel instanceof Postprocessable) {
                        return ((Postprocessable) addedUsersModel).a();
                    }
                    return addedUsersModel;
                }
            }

            /* compiled from: exact */
            public class Serializer extends JsonSerializer<AddedUsersModel> {
                public final void m16524a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    AddedUsersModel addedUsersModel = (AddedUsersModel) obj;
                    if (addedUsersModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(addedUsersModel.m16525a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        addedUsersModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    AddedUsersParser.m16582a(addedUsersModel.w_(), addedUsersModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(AddedUsersModel.class, new Serializer());
                }
            }

            public AddedUsersModel() {
                super(1);
            }

            public final void m16528a(String str, ConsistencyTuple consistencyTuple) {
                consistencyTuple.a();
            }

            public final void m16529a(String str, Object obj, boolean z) {
            }

            @Nullable
            public final String m16530j() {
                this.f14634d = super.a(this.f14634d, 0);
                return this.f14634d;
            }

            @Nullable
            public final String m16527a() {
                return m16530j();
            }

            public final int jK_() {
                return 2645995;
            }

            public final GraphQLVisitableModel m16526a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m16525a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m16530j());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, b);
                i();
                return flatBufferBuilder.d();
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 1801334754)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: exact */
        public final class AlreadyAddedUsersModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
            @Nullable
            private String f14635d;

            /* compiled from: exact */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(AlreadyAddedUsersModel.class, new Deserializer());
                }

                public Object m16531a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(AlreadyAddedUsersParser.m16586b(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object alreadyAddedUsersModel = new AlreadyAddedUsersModel();
                    ((BaseModel) alreadyAddedUsersModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (alreadyAddedUsersModel instanceof Postprocessable) {
                        return ((Postprocessable) alreadyAddedUsersModel).a();
                    }
                    return alreadyAddedUsersModel;
                }
            }

            /* compiled from: exact */
            public class Serializer extends JsonSerializer<AlreadyAddedUsersModel> {
                public final void m16532a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    AlreadyAddedUsersModel alreadyAddedUsersModel = (AlreadyAddedUsersModel) obj;
                    if (alreadyAddedUsersModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(alreadyAddedUsersModel.m16533a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        alreadyAddedUsersModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    AlreadyAddedUsersParser.m16585a(alreadyAddedUsersModel.w_(), alreadyAddedUsersModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(AlreadyAddedUsersModel.class, new Serializer());
                }
            }

            public AlreadyAddedUsersModel() {
                super(1);
            }

            public final void m16536a(String str, ConsistencyTuple consistencyTuple) {
                consistencyTuple.a();
            }

            public final void m16537a(String str, Object obj, boolean z) {
            }

            @Nullable
            public final String m16538j() {
                this.f14635d = super.a(this.f14635d, 0);
                return this.f14635d;
            }

            @Nullable
            public final String m16535a() {
                return m16538j();
            }

            public final int jK_() {
                return 2645995;
            }

            public final GraphQLVisitableModel m16534a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m16533a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m16538j());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, b);
                i();
                return flatBufferBuilder.d();
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 1801334754)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: exact */
        public final class AlreadyInvitedUsersModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
            @Nullable
            private String f14636d;

            /* compiled from: exact */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(AlreadyInvitedUsersModel.class, new Deserializer());
                }

                public Object m16539a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(AlreadyInvitedUsersParser.m16589b(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object alreadyInvitedUsersModel = new AlreadyInvitedUsersModel();
                    ((BaseModel) alreadyInvitedUsersModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (alreadyInvitedUsersModel instanceof Postprocessable) {
                        return ((Postprocessable) alreadyInvitedUsersModel).a();
                    }
                    return alreadyInvitedUsersModel;
                }
            }

            /* compiled from: exact */
            public class Serializer extends JsonSerializer<AlreadyInvitedUsersModel> {
                public final void m16540a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    AlreadyInvitedUsersModel alreadyInvitedUsersModel = (AlreadyInvitedUsersModel) obj;
                    if (alreadyInvitedUsersModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(alreadyInvitedUsersModel.m16541a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        alreadyInvitedUsersModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    AlreadyInvitedUsersParser.m16588a(alreadyInvitedUsersModel.w_(), alreadyInvitedUsersModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(AlreadyInvitedUsersModel.class, new Serializer());
                }
            }

            public AlreadyInvitedUsersModel() {
                super(1);
            }

            public final void m16544a(String str, ConsistencyTuple consistencyTuple) {
                consistencyTuple.a();
            }

            public final void m16545a(String str, Object obj, boolean z) {
            }

            @Nullable
            public final String m16546j() {
                this.f14636d = super.a(this.f14636d, 0);
                return this.f14636d;
            }

            @Nullable
            public final String m16543a() {
                return m16546j();
            }

            public final int jK_() {
                return 2645995;
            }

            public final GraphQLVisitableModel m16542a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m16541a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m16546j());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, b);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: exact */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(GroupAddMembersMutationModel.class, new Deserializer());
            }

            public Object m16547a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(GroupAddMembersMutationParser.m16599a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object groupAddMembersMutationModel = new GroupAddMembersMutationModel();
                ((BaseModel) groupAddMembersMutationModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (groupAddMembersMutationModel instanceof Postprocessable) {
                    return ((Postprocessable) groupAddMembersMutationModel).a();
                }
                return groupAddMembersMutationModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 1801334754)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: exact */
        public final class FailedUsersModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
            @Nullable
            private String f14637d;

            /* compiled from: exact */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(FailedUsersModel.class, new Deserializer());
                }

                public Object m16548a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(FailedUsersParser.m16592b(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object failedUsersModel = new FailedUsersModel();
                    ((BaseModel) failedUsersModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (failedUsersModel instanceof Postprocessable) {
                        return ((Postprocessable) failedUsersModel).a();
                    }
                    return failedUsersModel;
                }
            }

            /* compiled from: exact */
            public class Serializer extends JsonSerializer<FailedUsersModel> {
                public final void m16549a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    FailedUsersModel failedUsersModel = (FailedUsersModel) obj;
                    if (failedUsersModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(failedUsersModel.m16551a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        failedUsersModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    FailedUsersParser.m16591a(failedUsersModel.w_(), failedUsersModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(FailedUsersModel.class, new Serializer());
                }
            }

            public FailedUsersModel() {
                super(1);
            }

            public final void m16554a(String str, ConsistencyTuple consistencyTuple) {
                consistencyTuple.a();
            }

            public final void m16555a(String str, Object obj, boolean z) {
            }

            @Nullable
            private String m16550j() {
                this.f14637d = super.a(this.f14637d, 0);
                return this.f14637d;
            }

            @Nullable
            public final String m16553a() {
                return m16550j();
            }

            public final int jK_() {
                return 2645995;
            }

            public final GraphQLVisitableModel m16552a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m16551a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m16550j());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, b);
                i();
                return flatBufferBuilder.d();
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 1801334754)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: exact */
        public final class InvitedUsersModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
            @Nullable
            private String f14638d;

            /* compiled from: exact */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(InvitedUsersModel.class, new Deserializer());
                }

                public Object m16556a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(InvitedUsersParser.m16595b(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object invitedUsersModel = new InvitedUsersModel();
                    ((BaseModel) invitedUsersModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (invitedUsersModel instanceof Postprocessable) {
                        return ((Postprocessable) invitedUsersModel).a();
                    }
                    return invitedUsersModel;
                }
            }

            /* compiled from: exact */
            public class Serializer extends JsonSerializer<InvitedUsersModel> {
                public final void m16557a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    InvitedUsersModel invitedUsersModel = (InvitedUsersModel) obj;
                    if (invitedUsersModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(invitedUsersModel.m16558a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        invitedUsersModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    InvitedUsersParser.m16594a(invitedUsersModel.w_(), invitedUsersModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(InvitedUsersModel.class, new Serializer());
                }
            }

            public InvitedUsersModel() {
                super(1);
            }

            public final void m16561a(String str, ConsistencyTuple consistencyTuple) {
                consistencyTuple.a();
            }

            public final void m16562a(String str, Object obj, boolean z) {
            }

            @Nullable
            public final String m16563j() {
                this.f14638d = super.a(this.f14638d, 0);
                return this.f14638d;
            }

            @Nullable
            public final String m16560a() {
                return m16563j();
            }

            public final int jK_() {
                return 2645995;
            }

            public final GraphQLVisitableModel m16559a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m16558a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m16563j());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, b);
                i();
                return flatBufferBuilder.d();
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 1801334754)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: exact */
        public final class RequestedUsersModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
            @Nullable
            private String f14639d;

            /* compiled from: exact */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(RequestedUsersModel.class, new Deserializer());
                }

                public Object m16564a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(RequestedUsersParser.m16598b(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object requestedUsersModel = new RequestedUsersModel();
                    ((BaseModel) requestedUsersModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (requestedUsersModel instanceof Postprocessable) {
                        return ((Postprocessable) requestedUsersModel).a();
                    }
                    return requestedUsersModel;
                }
            }

            /* compiled from: exact */
            public class Serializer extends JsonSerializer<RequestedUsersModel> {
                public final void m16565a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    RequestedUsersModel requestedUsersModel = (RequestedUsersModel) obj;
                    if (requestedUsersModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(requestedUsersModel.m16566a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        requestedUsersModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    RequestedUsersParser.m16597a(requestedUsersModel.w_(), requestedUsersModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(RequestedUsersModel.class, new Serializer());
                }
            }

            public RequestedUsersModel() {
                super(1);
            }

            public final void m16569a(String str, ConsistencyTuple consistencyTuple) {
                consistencyTuple.a();
            }

            public final void m16570a(String str, Object obj, boolean z) {
            }

            @Nullable
            public final String m16571j() {
                this.f14639d = super.a(this.f14639d, 0);
                return this.f14639d;
            }

            @Nullable
            public final String m16568a() {
                return m16571j();
            }

            public final int jK_() {
                return 2645995;
            }

            public final GraphQLVisitableModel m16567a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m16566a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m16571j());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, b);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: exact */
        public class Serializer extends JsonSerializer<GroupAddMembersMutationModel> {
            public final void m16572a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                int i;
                GroupAddMembersMutationModel groupAddMembersMutationModel = (GroupAddMembersMutationModel) obj;
                if (groupAddMembersMutationModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(groupAddMembersMutationModel.m16574a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    groupAddMembersMutationModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = groupAddMembersMutationModel.w_();
                int u_ = groupAddMembersMutationModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("added_users");
                    jsonGenerator.d();
                    for (i = 0; i < mutableFlatBuffer.c(g); i++) {
                        AddedUsersParser.m16582a(mutableFlatBuffer, mutableFlatBuffer.m(g, i), jsonGenerator);
                    }
                    jsonGenerator.e();
                }
                g = mutableFlatBuffer.g(u_, 1);
                if (g != 0) {
                    jsonGenerator.a("already_added_users");
                    jsonGenerator.d();
                    for (i = 0; i < mutableFlatBuffer.c(g); i++) {
                        AlreadyAddedUsersParser.m16585a(mutableFlatBuffer, mutableFlatBuffer.m(g, i), jsonGenerator);
                    }
                    jsonGenerator.e();
                }
                g = mutableFlatBuffer.g(u_, 2);
                if (g != 0) {
                    jsonGenerator.a("already_invited_users");
                    jsonGenerator.d();
                    for (i = 0; i < mutableFlatBuffer.c(g); i++) {
                        AlreadyInvitedUsersParser.m16588a(mutableFlatBuffer, mutableFlatBuffer.m(g, i), jsonGenerator);
                    }
                    jsonGenerator.e();
                }
                if (mutableFlatBuffer.g(u_, 3) != 0) {
                    jsonGenerator.a("client_mutation_id");
                    jsonGenerator.b(mutableFlatBuffer.c(u_, 3));
                }
                g = mutableFlatBuffer.g(u_, 4);
                if (g != 0) {
                    jsonGenerator.a("failed_users");
                    jsonGenerator.d();
                    for (i = 0; i < mutableFlatBuffer.c(g); i++) {
                        FailedUsersParser.m16591a(mutableFlatBuffer, mutableFlatBuffer.m(g, i), jsonGenerator);
                    }
                    jsonGenerator.e();
                }
                g = mutableFlatBuffer.g(u_, 5);
                if (g != 0) {
                    jsonGenerator.a("invited_users");
                    jsonGenerator.d();
                    for (i = 0; i < mutableFlatBuffer.c(g); i++) {
                        InvitedUsersParser.m16594a(mutableFlatBuffer, mutableFlatBuffer.m(g, i), jsonGenerator);
                    }
                    jsonGenerator.e();
                }
                g = mutableFlatBuffer.g(u_, 6);
                if (g != 0) {
                    jsonGenerator.a("requested_users");
                    jsonGenerator.d();
                    for (i = 0; i < mutableFlatBuffer.c(g); i++) {
                        RequestedUsersParser.m16597a(mutableFlatBuffer, mutableFlatBuffer.m(g, i), jsonGenerator);
                    }
                    jsonGenerator.e();
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(GroupAddMembersMutationModel.class, new Serializer());
            }
        }

        public GroupAddMembersMutationModel() {
            super(7);
        }

        @Nonnull
        public final ImmutableList<AddedUsersModel> m16576a() {
            this.f14640d = super.a(this.f14640d, 0, AddedUsersModel.class);
            return (ImmutableList) this.f14640d;
        }

        @Nonnull
        public final ImmutableList<AlreadyAddedUsersModel> m16577j() {
            this.f14641e = super.a(this.f14641e, 1, AlreadyAddedUsersModel.class);
            return (ImmutableList) this.f14641e;
        }

        @Nonnull
        public final ImmutableList<AlreadyInvitedUsersModel> m16578k() {
            this.f14642f = super.a(this.f14642f, 2, AlreadyInvitedUsersModel.class);
            return (ImmutableList) this.f14642f;
        }

        @Nullable
        private String m16573o() {
            this.f14643g = super.a(this.f14643g, 3);
            return this.f14643g;
        }

        @Nonnull
        public final ImmutableList<FailedUsersModel> m16579l() {
            this.f14644h = super.a(this.f14644h, 4, FailedUsersModel.class);
            return (ImmutableList) this.f14644h;
        }

        @Nonnull
        public final ImmutableList<InvitedUsersModel> m16580m() {
            this.f14645i = super.a(this.f14645i, 5, InvitedUsersModel.class);
            return (ImmutableList) this.f14645i;
        }

        @Nonnull
        public final ImmutableList<RequestedUsersModel> m16581n() {
            this.f14646j = super.a(this.f14646j, 6, RequestedUsersModel.class);
            return (ImmutableList) this.f14646j;
        }

        public final int jK_() {
            return -1156471951;
        }

        public final GraphQLVisitableModel m16575a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            Builder a;
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m16576a() != null) {
                a = ModelHelper.a(m16576a(), graphQLModelMutatingVisitor);
                if (a != null) {
                    graphQLVisitableModel = (GroupAddMembersMutationModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f14640d = a.b();
                }
            }
            if (m16577j() != null) {
                a = ModelHelper.a(m16577j(), graphQLModelMutatingVisitor);
                if (a != null) {
                    graphQLVisitableModel = (GroupAddMembersMutationModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f14641e = a.b();
                }
            }
            if (m16578k() != null) {
                a = ModelHelper.a(m16578k(), graphQLModelMutatingVisitor);
                if (a != null) {
                    graphQLVisitableModel = (GroupAddMembersMutationModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f14642f = a.b();
                }
            }
            if (m16579l() != null) {
                a = ModelHelper.a(m16579l(), graphQLModelMutatingVisitor);
                if (a != null) {
                    graphQLVisitableModel = (GroupAddMembersMutationModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f14644h = a.b();
                }
            }
            if (m16580m() != null) {
                a = ModelHelper.a(m16580m(), graphQLModelMutatingVisitor);
                if (a != null) {
                    graphQLVisitableModel = (GroupAddMembersMutationModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f14645i = a.b();
                }
            }
            if (m16581n() != null) {
                a = ModelHelper.a(m16581n(), graphQLModelMutatingVisitor);
                if (a != null) {
                    graphQLVisitableModel = (GroupAddMembersMutationModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f14646j = a.b();
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m16574a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m16576a());
            int a2 = ModelHelper.a(flatBufferBuilder, m16577j());
            int a3 = ModelHelper.a(flatBufferBuilder, m16578k());
            int b = flatBufferBuilder.b(m16573o());
            int a4 = ModelHelper.a(flatBufferBuilder, m16579l());
            int a5 = ModelHelper.a(flatBufferBuilder, m16580m());
            int a6 = ModelHelper.a(flatBufferBuilder, m16581n());
            flatBufferBuilder.c(7);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, a2);
            flatBufferBuilder.b(2, a3);
            flatBufferBuilder.b(3, b);
            flatBufferBuilder.b(4, a4);
            flatBufferBuilder.b(5, a5);
            flatBufferBuilder.b(6, a6);
            i();
            return flatBufferBuilder.d();
        }
    }
}
