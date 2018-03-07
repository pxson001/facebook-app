package com.facebook.contacts.ccu.graphql;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbSerializerProvider;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.contacts.ccu.graphql.ContactsBatchUploadMutationParsers.ContactBatchUploadMutationFieldsParser;
import com.facebook.contacts.ccu.graphql.ContactsBatchUploadMutationParsers.ContactBatchUploadMutationFieldsParser.FriendableContactsParser;
import com.facebook.contacts.ccu.graphql.ContactsBatchUploadMutationParsers.ContactBatchUploadMutationFieldsParser.FriendableContactsParser.MutualFriendsParser;
import com.facebook.contacts.ccu.graphql.ContactsBatchUploadMutationParsers.ContactBatchUploadMutationFieldsParser.FriendableContactsParser.ProfilePictureParser;
import com.facebook.contacts.ccu.graphql.ContactsBatchUploadMutationParsers.ContactBatchUploadMutationFieldsParser.InvitableContactsParser;
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
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.google.common.collect.ImmutableList;
import java.nio.ByteBuffer;
import java.util.List;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/* compiled from: profile.php.* */
public class ContactsBatchUploadMutationModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -487755409)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: profile.php.* */
    public final class ContactBatchUploadMutationFieldsModel extends BaseModel implements GraphQLVisitableModel {
        private int f6240d;
        @Nullable
        private List<FriendableContactsModel> f6241e;
        @Nullable
        private List<InvitableContactsModel> f6242f;

        /* compiled from: profile.php.* */
        public final class Builder {
            public int f6228a;
            @Nullable
            public ImmutableList<FriendableContactsModel> f6229b;
            @Nullable
            public ImmutableList<InvitableContactsModel> f6230c;

            public final ContactBatchUploadMutationFieldsModel m6537a() {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                int a = ModelHelper.a(flatBufferBuilder, this.f6229b);
                int a2 = ModelHelper.a(flatBufferBuilder, this.f6230c);
                flatBufferBuilder.c(3);
                flatBufferBuilder.a(0, this.f6228a, 0);
                flatBufferBuilder.b(1, a);
                flatBufferBuilder.b(2, a2);
                flatBufferBuilder.d(flatBufferBuilder.d());
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                return new ContactBatchUploadMutationFieldsModel(new MutableFlatBuffer(wrap, null, null, true, null));
            }
        }

        /* compiled from: profile.php.* */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(ContactBatchUploadMutationFieldsModel.class, new Deserializer());
            }

            public Object m6538a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(ContactBatchUploadMutationFieldsParser.m6582a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object contactBatchUploadMutationFieldsModel = new ContactBatchUploadMutationFieldsModel();
                ((BaseModel) contactBatchUploadMutationFieldsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (contactBatchUploadMutationFieldsModel instanceof Postprocessable) {
                    return ((Postprocessable) contactBatchUploadMutationFieldsModel).a();
                }
                return contactBatchUploadMutationFieldsModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 295421420)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: profile.php.* */
        public final class FriendableContactsModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
            @Nullable
            private String f6233d;
            @Nullable
            private MutualFriendsModel f6234e;
            @Nullable
            private String f6235f;
            @Nullable
            private ProfilePictureModel f6236g;

            /* compiled from: profile.php.* */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(FriendableContactsModel.class, new Deserializer());
                }

                public Object m6539a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(FriendableContactsParser.m6577b(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object friendableContactsModel = new FriendableContactsModel();
                    ((BaseModel) friendableContactsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (friendableContactsModel instanceof Postprocessable) {
                        return ((Postprocessable) friendableContactsModel).a();
                    }
                    return friendableContactsModel;
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = -1723990064)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: profile.php.* */
            public final class MutualFriendsModel extends BaseModel implements GraphQLVisitableModel {
                private int f6231d;

                /* compiled from: profile.php.* */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(MutualFriendsModel.class, new Deserializer());
                    }

                    public Object m6540a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(MutualFriendsParser.m6573a(jsonParser, flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        mutableFlatBuffer.a(4, Boolean.valueOf(true));
                        MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                        Object mutualFriendsModel = new MutualFriendsModel();
                        ((BaseModel) mutualFriendsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                        if (mutualFriendsModel instanceof Postprocessable) {
                            return ((Postprocessable) mutualFriendsModel).a();
                        }
                        return mutualFriendsModel;
                    }
                }

                /* compiled from: profile.php.* */
                public class Serializer extends JsonSerializer<MutualFriendsModel> {
                    public final void m6541a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        MutualFriendsModel mutualFriendsModel = (MutualFriendsModel) obj;
                        if (mutualFriendsModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(mutualFriendsModel.m6542a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            mutualFriendsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        MutualFriendsParser.m6574a(mutualFriendsModel.w_(), mutualFriendsModel.u_(), jsonGenerator);
                    }

                    static {
                        FbSerializerProvider.a(MutualFriendsModel.class, new Serializer());
                    }
                }

                public MutualFriendsModel() {
                    super(1);
                }

                public final int jK_() {
                    return 1532278911;
                }

                public final GraphQLVisitableModel m6543a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    h();
                    i();
                    return this;
                }

                public final int m6542a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    flatBufferBuilder.c(1);
                    flatBufferBuilder.a(0, this.f6231d, 0);
                    i();
                    return flatBufferBuilder.d();
                }

                public final void m6544a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                    super.a(mutableFlatBuffer, i, obj);
                    this.f6231d = mutableFlatBuffer.a(i, 0, 0);
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = 842551240)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: profile.php.* */
            public final class ProfilePictureModel extends BaseModel implements GraphQLVisitableModel {
                @Nullable
                private String f6232d;

                /* compiled from: profile.php.* */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(ProfilePictureModel.class, new Deserializer());
                    }

                    public Object m6545a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(ProfilePictureParser.m6575a(jsonParser, flatBufferBuilder));
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

                /* compiled from: profile.php.* */
                public class Serializer extends JsonSerializer<ProfilePictureModel> {
                    public final void m6546a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        ProfilePictureModel profilePictureModel = (ProfilePictureModel) obj;
                        if (profilePictureModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(profilePictureModel.m6548a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            profilePictureModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        ProfilePictureParser.m6576a(profilePictureModel.w_(), profilePictureModel.u_(), jsonGenerator);
                    }

                    static {
                        FbSerializerProvider.a(ProfilePictureModel.class, new Serializer());
                    }
                }

                public ProfilePictureModel() {
                    super(1);
                }

                @Nullable
                private String m6547a() {
                    this.f6232d = super.a(this.f6232d, 0);
                    return this.f6232d;
                }

                public final int jK_() {
                    return 70760763;
                }

                public final GraphQLVisitableModel m6549a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    h();
                    i();
                    return this;
                }

                public final int m6548a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int b = flatBufferBuilder.b(m6547a());
                    flatBufferBuilder.c(1);
                    flatBufferBuilder.b(0, b);
                    i();
                    return flatBufferBuilder.d();
                }
            }

            /* compiled from: profile.php.* */
            public class Serializer extends JsonSerializer<FriendableContactsModel> {
                public final void m6550a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    FriendableContactsModel friendableContactsModel = (FriendableContactsModel) obj;
                    if (friendableContactsModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(friendableContactsModel.m6555a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        friendableContactsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    FriendableContactsParser.m6578b(friendableContactsModel.w_(), friendableContactsModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(FriendableContactsModel.class, new Serializer());
                }
            }

            public FriendableContactsModel() {
                super(4);
            }

            public final void m6558a(String str, ConsistencyTuple consistencyTuple) {
                consistencyTuple.a();
            }

            public final void m6559a(String str, Object obj, boolean z) {
            }

            @Nullable
            private String m6551j() {
                this.f6233d = super.a(this.f6233d, 0);
                return this.f6233d;
            }

            @Nullable
            private MutualFriendsModel m6552k() {
                this.f6234e = (MutualFriendsModel) super.a(this.f6234e, 1, MutualFriendsModel.class);
                return this.f6234e;
            }

            @Nullable
            private String m6553l() {
                this.f6235f = super.a(this.f6235f, 2);
                return this.f6235f;
            }

            @Nullable
            private ProfilePictureModel m6554m() {
                this.f6236g = (ProfilePictureModel) super.a(this.f6236g, 3, ProfilePictureModel.class);
                return this.f6236g;
            }

            @Nullable
            public final String m6557a() {
                return m6551j();
            }

            public final int jK_() {
                return 2645995;
            }

            public final GraphQLVisitableModel m6556a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m6552k() != null) {
                    MutualFriendsModel mutualFriendsModel = (MutualFriendsModel) graphQLModelMutatingVisitor.b(m6552k());
                    if (m6552k() != mutualFriendsModel) {
                        graphQLVisitableModel = (FriendableContactsModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f6234e = mutualFriendsModel;
                    }
                }
                if (m6554m() != null) {
                    ProfilePictureModel profilePictureModel = (ProfilePictureModel) graphQLModelMutatingVisitor.b(m6554m());
                    if (m6554m() != profilePictureModel) {
                        graphQLVisitableModel = (FriendableContactsModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f6236g = profilePictureModel;
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m6555a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m6551j());
                int a = ModelHelper.a(flatBufferBuilder, m6552k());
                int b2 = flatBufferBuilder.b(m6553l());
                int a2 = ModelHelper.a(flatBufferBuilder, m6554m());
                flatBufferBuilder.c(4);
                flatBufferBuilder.b(0, b);
                flatBufferBuilder.b(1, a);
                flatBufferBuilder.b(2, b2);
                flatBufferBuilder.b(3, a2);
                i();
                return flatBufferBuilder.d();
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 1025648269)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: profile.php.* */
        public final class InvitableContactsModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private String f6237d;
            @Nullable
            private String f6238e;
            @Nullable
            private String f6239f;

            /* compiled from: profile.php.* */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(InvitableContactsModel.class, new Deserializer());
                }

                public Object m6560a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(InvitableContactsParser.m6581b(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object invitableContactsModel = new InvitableContactsModel();
                    ((BaseModel) invitableContactsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (invitableContactsModel instanceof Postprocessable) {
                        return ((Postprocessable) invitableContactsModel).a();
                    }
                    return invitableContactsModel;
                }
            }

            /* compiled from: profile.php.* */
            public class Serializer extends JsonSerializer<InvitableContactsModel> {
                public final void m6561a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    InvitableContactsModel invitableContactsModel = (InvitableContactsModel) obj;
                    if (invitableContactsModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(invitableContactsModel.m6565a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        invitableContactsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    InvitableContactsParser.m6580a(invitableContactsModel.w_(), invitableContactsModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(InvitableContactsModel.class, new Serializer());
                }
            }

            public InvitableContactsModel() {
                super(3);
            }

            @Nullable
            private String m6562a() {
                this.f6237d = super.a(this.f6237d, 0);
                return this.f6237d;
            }

            @Nullable
            private String m6563j() {
                this.f6238e = super.a(this.f6238e, 1);
                return this.f6238e;
            }

            @Nullable
            private String m6564k() {
                this.f6239f = super.a(this.f6239f, 2);
                return this.f6239f;
            }

            public final int jK_() {
                return 1858192170;
            }

            public final GraphQLVisitableModel m6566a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m6565a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m6562a());
                int b2 = flatBufferBuilder.b(m6563j());
                int b3 = flatBufferBuilder.b(m6564k());
                flatBufferBuilder.c(3);
                flatBufferBuilder.b(0, b);
                flatBufferBuilder.b(1, b2);
                flatBufferBuilder.b(2, b3);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: profile.php.* */
        public class Serializer extends JsonSerializer<ContactBatchUploadMutationFieldsModel> {
            public final void m6567a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                int i;
                ContactBatchUploadMutationFieldsModel contactBatchUploadMutationFieldsModel = (ContactBatchUploadMutationFieldsModel) obj;
                if (contactBatchUploadMutationFieldsModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(contactBatchUploadMutationFieldsModel.m6570a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    contactBatchUploadMutationFieldsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = contactBatchUploadMutationFieldsModel.w_();
                int u_ = contactBatchUploadMutationFieldsModel.u_();
                jsonGenerator.f();
                int a = mutableFlatBuffer.a(u_, 0, 0);
                if (a != 0) {
                    jsonGenerator.a("batch_size");
                    jsonGenerator.b(a);
                }
                a = mutableFlatBuffer.g(u_, 1);
                if (a != 0) {
                    jsonGenerator.a("friendable_contacts");
                    jsonGenerator.d();
                    for (i = 0; i < mutableFlatBuffer.c(a); i++) {
                        FriendableContactsParser.m6578b(mutableFlatBuffer, mutableFlatBuffer.m(a, i), jsonGenerator, serializerProvider);
                    }
                    jsonGenerator.e();
                }
                a = mutableFlatBuffer.g(u_, 2);
                if (a != 0) {
                    jsonGenerator.a("invitable_contacts");
                    jsonGenerator.d();
                    for (i = 0; i < mutableFlatBuffer.c(a); i++) {
                        InvitableContactsParser.m6580a(mutableFlatBuffer, mutableFlatBuffer.m(a, i), jsonGenerator);
                    }
                    jsonGenerator.e();
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(ContactBatchUploadMutationFieldsModel.class, new Serializer());
            }
        }

        public ContactBatchUploadMutationFieldsModel() {
            super(3);
        }

        public ContactBatchUploadMutationFieldsModel(MutableFlatBuffer mutableFlatBuffer) {
            super(3);
            a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
        }

        @Nonnull
        private ImmutableList<FriendableContactsModel> m6568a() {
            this.f6241e = super.a(this.f6241e, 1, FriendableContactsModel.class);
            return (ImmutableList) this.f6241e;
        }

        @Nonnull
        private ImmutableList<InvitableContactsModel> m6569j() {
            this.f6242f = super.a(this.f6242f, 2, InvitableContactsModel.class);
            return (ImmutableList) this.f6242f;
        }

        public final int jK_() {
            return 186092242;
        }

        public final GraphQLVisitableModel m6571a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            com.google.common.collect.ImmutableList.Builder a;
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m6568a() != null) {
                a = ModelHelper.a(m6568a(), graphQLModelMutatingVisitor);
                if (a != null) {
                    graphQLVisitableModel = (ContactBatchUploadMutationFieldsModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f6241e = a.b();
                }
            }
            if (m6569j() != null) {
                a = ModelHelper.a(m6569j(), graphQLModelMutatingVisitor);
                if (a != null) {
                    graphQLVisitableModel = (ContactBatchUploadMutationFieldsModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f6242f = a.b();
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m6570a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m6568a());
            int a2 = ModelHelper.a(flatBufferBuilder, m6569j());
            flatBufferBuilder.c(3);
            flatBufferBuilder.a(0, this.f6240d, 0);
            flatBufferBuilder.b(1, a);
            flatBufferBuilder.b(2, a2);
            i();
            return flatBufferBuilder.d();
        }

        public final void m6572a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
            super.a(mutableFlatBuffer, i, obj);
            this.f6240d = mutableFlatBuffer.a(i, 0, 0);
        }
    }
}
