package com.facebook.groups.widget.memberrow.protocol;

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
import com.facebook.groups.widget.memberrow.protocol.MemberDataInterfaces.GroupMemberData;
import com.facebook.groups.widget.memberrow.protocol.MemberDataParsers.GroupMemberDataParser;
import com.facebook.groups.widget.memberrow.protocol.MemberDataParsers.GroupMemberDataParser.LastActiveMessagesStatusParser;
import com.facebook.groups.widget.memberrow.protocol.MemberDataParsers.GroupMemberDataParser.ProfilePictureParser;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.nio.ByteBuffer;
import javax.annotation.Nullable;

/* compiled from: privacy_shortcuts */
public class MemberDataModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 1574228030)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: privacy_shortcuts */
    public final class GroupMemberDataModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel, GroupMemberData {
        @Nullable
        private GraphQLObjectType f6020d;
        @Nullable
        private String f6021e;
        private boolean f6022f;
        @Nullable
        private LastActiveMessagesStatusModel f6023g;
        @Nullable
        private String f6024h;
        @Nullable
        private ProfilePictureModel f6025i;

        /* compiled from: privacy_shortcuts */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(GroupMemberDataModel.class, new Deserializer());
            }

            public Object m7791a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(GroupMemberDataParser.m7821a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object groupMemberDataModel = new GroupMemberDataModel();
                ((BaseModel) groupMemberDataModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (groupMemberDataModel instanceof Postprocessable) {
                    return ((Postprocessable) groupMemberDataModel).a();
                }
                return groupMemberDataModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -24851759)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: privacy_shortcuts */
        public final class LastActiveMessagesStatusModel extends BaseModel implements GraphQLVisitableModel {
            private boolean f6018d;

            /* compiled from: privacy_shortcuts */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(LastActiveMessagesStatusModel.class, new Deserializer());
                }

                public Object m7792a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(LastActiveMessagesStatusParser.m7817a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object lastActiveMessagesStatusModel = new LastActiveMessagesStatusModel();
                    ((BaseModel) lastActiveMessagesStatusModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (lastActiveMessagesStatusModel instanceof Postprocessable) {
                        return ((Postprocessable) lastActiveMessagesStatusModel).a();
                    }
                    return lastActiveMessagesStatusModel;
                }
            }

            /* compiled from: privacy_shortcuts */
            public class Serializer extends JsonSerializer<LastActiveMessagesStatusModel> {
                public final void m7793a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    LastActiveMessagesStatusModel lastActiveMessagesStatusModel = (LastActiveMessagesStatusModel) obj;
                    if (lastActiveMessagesStatusModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(lastActiveMessagesStatusModel.m7794a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        lastActiveMessagesStatusModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    LastActiveMessagesStatusParser.m7818a(lastActiveMessagesStatusModel.w_(), lastActiveMessagesStatusModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(LastActiveMessagesStatusModel.class, new Serializer());
                }
            }

            public LastActiveMessagesStatusModel() {
                super(1);
            }

            public final boolean m7797a() {
                a(0, 0);
                return this.f6018d;
            }

            public final int jK_() {
                return -369762086;
            }

            public final GraphQLVisitableModel m7795a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m7794a(FlatBufferBuilder flatBufferBuilder) {
                h();
                flatBufferBuilder.c(1);
                flatBufferBuilder.a(0, this.f6018d);
                i();
                return flatBufferBuilder.d();
            }

            public final void m7796a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                super.a(mutableFlatBuffer, i, obj);
                this.f6018d = mutableFlatBuffer.a(i, 0);
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 842551240)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: privacy_shortcuts */
        public final class ProfilePictureModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private String f6019d;

            /* compiled from: privacy_shortcuts */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(ProfilePictureModel.class, new Deserializer());
                }

                public Object m7798a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(ProfilePictureParser.m7819a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object profilePictureModel = new ProfilePictureModel();
                    ((BaseModel) profilePictureModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (profilePictureModel instanceof Postprocessable) {
                        return ((Postprocessable) profilePictureModel).a();
                    }
                    return profilePictureModel;
                }
            }

            /* compiled from: privacy_shortcuts */
            public class Serializer extends JsonSerializer<ProfilePictureModel> {
                public final void m7799a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    ProfilePictureModel profilePictureModel = (ProfilePictureModel) obj;
                    if (profilePictureModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(profilePictureModel.m7800a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        profilePictureModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    ProfilePictureParser.m7820a(profilePictureModel.w_(), profilePictureModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(ProfilePictureModel.class, new Serializer());
                }
            }

            public ProfilePictureModel() {
                super(1);
            }

            @Nullable
            public final String m7802a() {
                this.f6019d = super.a(this.f6019d, 0);
                return this.f6019d;
            }

            public final int jK_() {
                return 70760763;
            }

            public final GraphQLVisitableModel m7801a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m7800a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m7802a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, b);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: privacy_shortcuts */
        public class Serializer extends JsonSerializer<GroupMemberDataModel> {
            public final void m7803a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                GroupMemberDataModel groupMemberDataModel = (GroupMemberDataModel) obj;
                if (groupMemberDataModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(groupMemberDataModel.m7807a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    groupMemberDataModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                GroupMemberDataParser.m7822a(groupMemberDataModel.w_(), groupMemberDataModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(GroupMemberDataModel.class, new Serializer());
            }
        }

        @Nullable
        public final /* synthetic */ LastActiveMessagesStatusModel mo336d() {
            return m7805k();
        }

        @Nullable
        public final /* synthetic */ ProfilePictureModel mo337g() {
            return m7806l();
        }

        public GroupMemberDataModel() {
            super(6);
        }

        public final void m7811a(String str, ConsistencyTuple consistencyTuple) {
            consistencyTuple.a();
        }

        public final void m7812a(String str, Object obj, boolean z) {
        }

        @Nullable
        private GraphQLObjectType m7804j() {
            if (this.b != null && this.f6020d == null) {
                this.f6020d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
            }
            return this.f6020d;
        }

        @Nullable
        public final String mo334b() {
            this.f6021e = super.a(this.f6021e, 1);
            return this.f6021e;
        }

        public final boolean mo335c() {
            a(0, 2);
            return this.f6022f;
        }

        @Nullable
        private LastActiveMessagesStatusModel m7805k() {
            this.f6023g = (LastActiveMessagesStatusModel) super.a(this.f6023g, 3, LastActiveMessagesStatusModel.class);
            return this.f6023g;
        }

        @Nullable
        public final String he_() {
            this.f6024h = super.a(this.f6024h, 4);
            return this.f6024h;
        }

        @Nullable
        private ProfilePictureModel m7806l() {
            this.f6025i = (ProfilePictureModel) super.a(this.f6025i, 5, ProfilePictureModel.class);
            return this.f6025i;
        }

        @Nullable
        public final String m7809a() {
            return mo334b();
        }

        public final int jK_() {
            return 1355227529;
        }

        public final GraphQLVisitableModel m7808a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m7805k() != null) {
                LastActiveMessagesStatusModel lastActiveMessagesStatusModel = (LastActiveMessagesStatusModel) graphQLModelMutatingVisitor.b(m7805k());
                if (m7805k() != lastActiveMessagesStatusModel) {
                    graphQLVisitableModel = (GroupMemberDataModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f6023g = lastActiveMessagesStatusModel;
                }
            }
            if (m7806l() != null) {
                ProfilePictureModel profilePictureModel = (ProfilePictureModel) graphQLModelMutatingVisitor.b(m7806l());
                if (m7806l() != profilePictureModel) {
                    graphQLVisitableModel = (GroupMemberDataModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f6025i = profilePictureModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m7807a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m7804j());
            int b = flatBufferBuilder.b(mo334b());
            int a2 = ModelHelper.a(flatBufferBuilder, m7805k());
            int b2 = flatBufferBuilder.b(he_());
            int a3 = ModelHelper.a(flatBufferBuilder, m7806l());
            flatBufferBuilder.c(6);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, b);
            flatBufferBuilder.a(2, this.f6022f);
            flatBufferBuilder.b(3, a2);
            flatBufferBuilder.b(4, b2);
            flatBufferBuilder.b(5, a3);
            i();
            return flatBufferBuilder.d();
        }

        public final void m7810a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
            super.a(mutableFlatBuffer, i, obj);
            this.f6022f = mutableFlatBuffer.a(i, 2);
        }
    }
}
