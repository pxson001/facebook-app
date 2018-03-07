package com.facebook.goodfriends.protocol;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbSerializerProvider;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.FragmentModelWithoutBridge;
import com.facebook.flatbuffers.ModelWithFlatBufferFormatHash;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.goodfriends.protocol.GoodFriendsMutatorsParsers.FriendListUpdateMembersFieldsParser;
import com.facebook.goodfriends.protocol.GoodFriendsMutatorsParsers.FriendListUpdateMembersFieldsParser.FriendListParser;
import com.facebook.goodfriends.protocol.GoodFriendsMutatorsParsers.FriendListUpdateMembersFieldsParser.FriendListParser.MembersParser;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.ModelHelper;
import com.facebook.graphql.visitor.ConsistencyTuple;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLPersistableNode;
import com.facebook.graphql.visitor.GraphQLVisitableConsistentModel;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.nio.ByteBuffer;
import javax.annotation.Nullable;

/* compiled from: mRawJsonConfig */
public class GoodFriendsMutatorsModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -1104635773)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: mRawJsonConfig */
    public final class FriendListUpdateMembersFieldsModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private FriendListModel f10953d;

        /* compiled from: mRawJsonConfig */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(FriendListUpdateMembersFieldsModel.class, new Deserializer());
            }

            public Object m17572a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = FriendListUpdateMembersFieldsParser.m17600a(jsonParser);
                Object friendListUpdateMembersFieldsModel = new FriendListUpdateMembersFieldsModel();
                ((BaseModel) friendListUpdateMembersFieldsModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (friendListUpdateMembersFieldsModel instanceof Postprocessable) {
                    return ((Postprocessable) friendListUpdateMembersFieldsModel).a();
                }
                return friendListUpdateMembersFieldsModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 310403603)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: mRawJsonConfig */
        public final class FriendListModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
            @Nullable
            private String f10950d;
            @Nullable
            private MembersModel f10951e;
            @Nullable
            private String f10952f;

            /* compiled from: mRawJsonConfig */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(FriendListModel.class, new Deserializer());
                }

                public Object m17573a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(FriendListParser.m17598a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object friendListModel = new FriendListModel();
                    ((BaseModel) friendListModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (friendListModel instanceof Postprocessable) {
                        return ((Postprocessable) friendListModel).a();
                    }
                    return friendListModel;
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = -1723990064)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: mRawJsonConfig */
            public final class MembersModel extends BaseModel implements GraphQLVisitableModel {
                private int f10949d;

                /* compiled from: mRawJsonConfig */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(MembersModel.class, new Deserializer());
                    }

                    public Object m17574a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(MembersParser.m17596a(jsonParser, flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        mutableFlatBuffer.a(4, Boolean.valueOf(true));
                        MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                        Object membersModel = new MembersModel();
                        ((BaseModel) membersModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                        if (membersModel instanceof Postprocessable) {
                            return ((Postprocessable) membersModel).a();
                        }
                        return membersModel;
                    }
                }

                /* compiled from: mRawJsonConfig */
                public class Serializer extends JsonSerializer<MembersModel> {
                    public final void m17575a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        MembersModel membersModel = (MembersModel) obj;
                        if (membersModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(membersModel.m17577a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            membersModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        MembersParser.m17597a(membersModel.w_(), membersModel.u_(), jsonGenerator);
                    }

                    static {
                        FbSerializerProvider.a(MembersModel.class, new Serializer());
                    }
                }

                public MembersModel() {
                    super(1);
                }

                public final int m17576a() {
                    a(0, 0);
                    return this.f10949d;
                }

                public final void m17579a(int i) {
                    this.f10949d = i;
                    if (this.b != null && this.b.d) {
                        this.b.b(this.c, 0, i);
                    }
                }

                public final int jK_() {
                    return 1920013243;
                }

                public final GraphQLVisitableModel m17578a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    h();
                    i();
                    return this;
                }

                public final int m17577a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    flatBufferBuilder.c(1);
                    flatBufferBuilder.a(0, this.f10949d, 0);
                    i();
                    return flatBufferBuilder.d();
                }

                public final void m17580a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                    super.a(mutableFlatBuffer, i, obj);
                    this.f10949d = mutableFlatBuffer.a(i, 0, 0);
                }
            }

            /* compiled from: mRawJsonConfig */
            public class Serializer extends JsonSerializer<FriendListModel> {
                public final void m17581a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    FriendListModel friendListModel = (FriendListModel) obj;
                    if (friendListModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(friendListModel.m17587a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        friendListModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    FriendListParser.m17599a(friendListModel.w_(), friendListModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(FriendListModel.class, new Serializer());
                }
            }

            public FriendListModel() {
                super(3);
            }

            public final void m17590a(String str, ConsistencyTuple consistencyTuple) {
                if ("id".equals(str)) {
                    consistencyTuple.a = m17584j();
                    consistencyTuple.b = u_();
                    consistencyTuple.c = 0;
                    return;
                }
                if ("members.count".equals(str)) {
                    MembersModel k = m17585k();
                    if (k != null) {
                        consistencyTuple.a = Integer.valueOf(k.m17576a());
                        consistencyTuple.b = k.u_();
                        consistencyTuple.c = 0;
                        return;
                    }
                } else if ("name".equals(str)) {
                    consistencyTuple.a = m17586l();
                    consistencyTuple.b = u_();
                    consistencyTuple.c = 2;
                    return;
                }
                consistencyTuple.a();
            }

            public final void m17591a(String str, Object obj, boolean z) {
                if ("id".equals(str)) {
                    m17582a((String) obj);
                } else if ("members.count".equals(str)) {
                    MembersModel k = m17585k();
                    if (k == null) {
                        return;
                    }
                    if (z) {
                        k = (MembersModel) k.clone();
                        k.m17579a(((Integer) obj).intValue());
                        this.f10951e = k;
                        return;
                    }
                    k.m17579a(((Integer) obj).intValue());
                } else if ("name".equals(str)) {
                    m17583b((String) obj);
                }
            }

            @Nullable
            private String m17584j() {
                this.f10950d = super.a(this.f10950d, 0);
                return this.f10950d;
            }

            private void m17582a(@Nullable String str) {
                this.f10950d = str;
                if (this.b != null && this.b.d) {
                    this.b.a(this.c, 0, str);
                }
            }

            @Nullable
            private MembersModel m17585k() {
                this.f10951e = (MembersModel) super.a(this.f10951e, 1, MembersModel.class);
                return this.f10951e;
            }

            @Nullable
            private String m17586l() {
                this.f10952f = super.a(this.f10952f, 2);
                return this.f10952f;
            }

            private void m17583b(@Nullable String str) {
                this.f10952f = str;
                if (this.b != null && this.b.d) {
                    this.b.a(this.c, 2, str);
                }
            }

            @Nullable
            public final String m17589a() {
                return m17584j();
            }

            public final int jK_() {
                return 236555388;
            }

            public final GraphQLVisitableModel m17588a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m17585k() != null) {
                    MembersModel membersModel = (MembersModel) graphQLModelMutatingVisitor.b(m17585k());
                    if (m17585k() != membersModel) {
                        graphQLVisitableModel = (FriendListModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f10951e = membersModel;
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m17587a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m17584j());
                int a = ModelHelper.a(flatBufferBuilder, m17585k());
                int b2 = flatBufferBuilder.b(m17586l());
                flatBufferBuilder.c(3);
                flatBufferBuilder.b(0, b);
                flatBufferBuilder.b(1, a);
                flatBufferBuilder.b(2, b2);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: mRawJsonConfig */
        public class Serializer extends JsonSerializer<FriendListUpdateMembersFieldsModel> {
            public final void m17592a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                FriendListUpdateMembersFieldsModel friendListUpdateMembersFieldsModel = (FriendListUpdateMembersFieldsModel) obj;
                if (friendListUpdateMembersFieldsModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(friendListUpdateMembersFieldsModel.m17594a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    friendListUpdateMembersFieldsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = friendListUpdateMembersFieldsModel.w_();
                int u_ = friendListUpdateMembersFieldsModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("friend_list");
                    FriendListParser.m17599a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(FriendListUpdateMembersFieldsModel.class, new Serializer());
            }
        }

        public FriendListUpdateMembersFieldsModel() {
            super(1);
        }

        @Nullable
        private FriendListModel m17593a() {
            this.f10953d = (FriendListModel) super.a(this.f10953d, 0, FriendListModel.class);
            return this.f10953d;
        }

        public final int jK_() {
            return -1325118855;
        }

        public final GraphQLVisitableModel m17595a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m17593a() != null) {
                FriendListModel friendListModel = (FriendListModel) graphQLModelMutatingVisitor.b(m17593a());
                if (m17593a() != friendListModel) {
                    graphQLVisitableModel = (FriendListUpdateMembersFieldsModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f10953d = friendListModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m17594a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m17593a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }
}
