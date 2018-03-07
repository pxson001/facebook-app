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
import com.facebook.graphql.enums.GraphQLGroupVisibility;
import com.facebook.graphql.enums.GraphQLObjectType;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.ModelHelper;
import com.facebook.graphql.visitor.ConsistencyTuple;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLPersistableNode;
import com.facebook.graphql.visitor.GraphQLVisitableConsistentModel;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.facebook.groups.memberlist.protocol.FetchGroupMemberProfilesListParsers.FetchGroupMemberProfilesListParser;
import com.facebook.groups.memberlist.protocol.FetchGroupMemberProfilesListParsers.FetchGroupMemberProfilesListParser.AdminAwareGroupParser;
import com.facebook.groups.memberlist.protocol.FetchGroupMemberProfilesListParsers.InviteeDataParser;
import com.facebook.groups.memberlist.protocol.FetchGroupMemberProfilesListParsers.InviteeDataParser.InviteeParser;
import com.facebook.groups.memberlist.protocol.FetchGroupMemberProfilesListParsers.MemberProfilesAddedByFieldsParser;
import com.facebook.groups.memberlist.protocol.FetchGroupMemberProfilesListParsers.MemberProfilesAddedByFieldsParser.AddedByParser;
import com.facebook.groups.memberlist.protocol.FetchGroupMemberProfilesListParsers.MemberProfilesPageInfoFieldsParser;
import com.facebook.groups.widget.memberrow.protocol.MemberDataInterfaces.GroupMemberData;
import com.facebook.groups.widget.memberrow.protocol.MemberDataModels.GroupMemberDataModel.LastActiveMessagesStatusModel;
import com.facebook.groups.widget.memberrow.protocol.MemberDataModels.GroupMemberDataModel.ProfilePictureModel;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.nio.ByteBuffer;
import java.util.List;
import javax.annotation.Nullable;

/* compiled from: extra_for_phone_number_confirmation */
public class FetchGroupMemberProfilesListModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 1459536434)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: extra_for_phone_number_confirmation */
    public final class FetchGroupMemberProfilesListModel extends BaseModel implements GraphQLVisitableConsistentModel {
        @Nullable
        private AdminAwareGroupModel f14513d;

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 1532607205)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: extra_for_phone_number_confirmation */
        public final class AdminAwareGroupModel extends BaseModel implements GraphQLVisitableConsistentModel {
            @Nullable
            private MemberProfilesConnectionDefaultFieldsModel f14509d;
            @Nullable
            private MemberProfilesConnectionDefaultFieldsModel f14510e;
            @Nullable
            private MemberProfilesConnectionDefaultFieldsModel f14511f;
            @Nullable
            private GraphQLGroupVisibility f14512g;

            /* compiled from: extra_for_phone_number_confirmation */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(AdminAwareGroupModel.class, new Deserializer());
                }

                public Object m16191a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(AdminAwareGroupParser.m16276a(jsonParser, flatBufferBuilder));
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

            /* compiled from: extra_for_phone_number_confirmation */
            public class Serializer extends JsonSerializer<AdminAwareGroupModel> {
                public final void m16192a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    AdminAwareGroupModel adminAwareGroupModel = (AdminAwareGroupModel) obj;
                    if (adminAwareGroupModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(adminAwareGroupModel.m16194a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        adminAwareGroupModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    AdminAwareGroupParser.m16277a(adminAwareGroupModel.w_(), adminAwareGroupModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(AdminAwareGroupModel.class, new Serializer());
                }
            }

            public AdminAwareGroupModel() {
                super(4);
            }

            public final void m16197a(String str, ConsistencyTuple consistencyTuple) {
                if ("visibility".equals(str)) {
                    consistencyTuple.a = m16201l();
                    consistencyTuple.b = u_();
                    consistencyTuple.c = 3;
                    return;
                }
                consistencyTuple.a();
            }

            public final void m16198a(String str, Object obj, boolean z) {
                if ("visibility".equals(str)) {
                    m16193a((GraphQLGroupVisibility) obj);
                }
            }

            @Nullable
            public final MemberProfilesConnectionDefaultFieldsModel m16196a() {
                this.f14509d = (MemberProfilesConnectionDefaultFieldsModel) super.a(this.f14509d, 0, MemberProfilesConnectionDefaultFieldsModel.class);
                return this.f14509d;
            }

            @Nullable
            public final MemberProfilesConnectionDefaultFieldsModel m16199j() {
                this.f14510e = (MemberProfilesConnectionDefaultFieldsModel) super.a(this.f14510e, 1, MemberProfilesConnectionDefaultFieldsModel.class);
                return this.f14510e;
            }

            @Nullable
            public final MemberProfilesConnectionDefaultFieldsModel m16200k() {
                this.f14511f = (MemberProfilesConnectionDefaultFieldsModel) super.a(this.f14511f, 2, MemberProfilesConnectionDefaultFieldsModel.class);
                return this.f14511f;
            }

            @Nullable
            public final GraphQLGroupVisibility m16201l() {
                this.f14512g = (GraphQLGroupVisibility) super.b(this.f14512g, 3, GraphQLGroupVisibility.class, GraphQLGroupVisibility.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
                return this.f14512g;
            }

            private void m16193a(GraphQLGroupVisibility graphQLGroupVisibility) {
                this.f14512g = graphQLGroupVisibility;
                if (this.b != null && this.b.d) {
                    this.b.a(this.c, 3, graphQLGroupVisibility != null ? graphQLGroupVisibility.name() : null);
                }
            }

            public final int jK_() {
                return 69076575;
            }

            public final GraphQLVisitableModel m16195a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                MemberProfilesConnectionDefaultFieldsModel memberProfilesConnectionDefaultFieldsModel;
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m16196a() != null) {
                    memberProfilesConnectionDefaultFieldsModel = (MemberProfilesConnectionDefaultFieldsModel) graphQLModelMutatingVisitor.b(m16196a());
                    if (m16196a() != memberProfilesConnectionDefaultFieldsModel) {
                        graphQLVisitableModel = (AdminAwareGroupModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f14509d = memberProfilesConnectionDefaultFieldsModel;
                    }
                }
                if (m16199j() != null) {
                    memberProfilesConnectionDefaultFieldsModel = (MemberProfilesConnectionDefaultFieldsModel) graphQLModelMutatingVisitor.b(m16199j());
                    if (m16199j() != memberProfilesConnectionDefaultFieldsModel) {
                        graphQLVisitableModel = (AdminAwareGroupModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f14510e = memberProfilesConnectionDefaultFieldsModel;
                    }
                }
                if (m16200k() != null) {
                    memberProfilesConnectionDefaultFieldsModel = (MemberProfilesConnectionDefaultFieldsModel) graphQLModelMutatingVisitor.b(m16200k());
                    if (m16200k() != memberProfilesConnectionDefaultFieldsModel) {
                        graphQLVisitableModel = (AdminAwareGroupModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f14511f = memberProfilesConnectionDefaultFieldsModel;
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m16194a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m16196a());
                int a2 = ModelHelper.a(flatBufferBuilder, m16199j());
                int a3 = ModelHelper.a(flatBufferBuilder, m16200k());
                int a4 = flatBufferBuilder.a(m16201l());
                flatBufferBuilder.c(4);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.b(1, a2);
                flatBufferBuilder.b(2, a3);
                flatBufferBuilder.b(3, a4);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: extra_for_phone_number_confirmation */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(FetchGroupMemberProfilesListModel.class, new Deserializer());
            }

            public Object m16202a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = FetchGroupMemberProfilesListParser.m16278a(jsonParser);
                Object fetchGroupMemberProfilesListModel = new FetchGroupMemberProfilesListModel();
                ((BaseModel) fetchGroupMemberProfilesListModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (fetchGroupMemberProfilesListModel instanceof Postprocessable) {
                    return ((Postprocessable) fetchGroupMemberProfilesListModel).a();
                }
                return fetchGroupMemberProfilesListModel;
            }
        }

        /* compiled from: extra_for_phone_number_confirmation */
        public class Serializer extends JsonSerializer<FetchGroupMemberProfilesListModel> {
            public final void m16203a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                FetchGroupMemberProfilesListModel fetchGroupMemberProfilesListModel = (FetchGroupMemberProfilesListModel) obj;
                if (fetchGroupMemberProfilesListModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(fetchGroupMemberProfilesListModel.m16204a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    fetchGroupMemberProfilesListModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = fetchGroupMemberProfilesListModel.w_();
                int u_ = fetchGroupMemberProfilesListModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("admin_aware_group");
                    AdminAwareGroupParser.m16277a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(FetchGroupMemberProfilesListModel.class, new Serializer());
            }
        }

        public FetchGroupMemberProfilesListModel() {
            super(1);
        }

        public final void m16207a(String str, ConsistencyTuple consistencyTuple) {
            consistencyTuple.a();
        }

        public final void m16208a(String str, Object obj, boolean z) {
        }

        @Nullable
        public final AdminAwareGroupModel m16206a() {
            this.f14513d = (AdminAwareGroupModel) super.a(this.f14513d, 0, AdminAwareGroupModel.class);
            return this.f14513d;
        }

        public final int jK_() {
            return 69076575;
        }

        public final GraphQLVisitableModel m16205a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m16206a() != null) {
                AdminAwareGroupModel adminAwareGroupModel = (AdminAwareGroupModel) graphQLModelMutatingVisitor.b(m16206a());
                if (m16206a() != adminAwareGroupModel) {
                    graphQLVisitableModel = (FetchGroupMemberProfilesListModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f14513d = adminAwareGroupModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m16204a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m16206a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 2079312400)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: extra_for_phone_number_confirmation */
    public final class InviteeDataModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private InviteeModel f14515d;

        /* compiled from: extra_for_phone_number_confirmation */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(InviteeDataModel.class, new Deserializer());
            }

            public Object m16209a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = InviteeDataParser.m16281a(jsonParser);
                Object inviteeDataModel = new InviteeDataModel();
                ((BaseModel) inviteeDataModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (inviteeDataModel instanceof Postprocessable) {
                    return ((Postprocessable) inviteeDataModel).a();
                }
                return inviteeDataModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 1801334754)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: extra_for_phone_number_confirmation */
        public final class InviteeModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
            @Nullable
            private String f14514d;

            /* compiled from: extra_for_phone_number_confirmation */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(InviteeModel.class, new Deserializer());
                }

                public Object m16210a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(InviteeParser.m16279a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object inviteeModel = new InviteeModel();
                    ((BaseModel) inviteeModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (inviteeModel instanceof Postprocessable) {
                        return ((Postprocessable) inviteeModel).a();
                    }
                    return inviteeModel;
                }
            }

            /* compiled from: extra_for_phone_number_confirmation */
            public class Serializer extends JsonSerializer<InviteeModel> {
                public final void m16211a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    InviteeModel inviteeModel = (InviteeModel) obj;
                    if (inviteeModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(inviteeModel.m16212a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        inviteeModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    InviteeParser.m16280a(inviteeModel.w_(), inviteeModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(InviteeModel.class, new Serializer());
                }
            }

            public InviteeModel() {
                super(1);
            }

            public final void m16215a(String str, ConsistencyTuple consistencyTuple) {
                consistencyTuple.a();
            }

            public final void m16216a(String str, Object obj, boolean z) {
            }

            @Nullable
            public final String m16217j() {
                this.f14514d = super.a(this.f14514d, 0);
                return this.f14514d;
            }

            @Nullable
            public final String m16214a() {
                return m16217j();
            }

            public final int jK_() {
                return 2645995;
            }

            public final GraphQLVisitableModel m16213a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m16212a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m16217j());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, b);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: extra_for_phone_number_confirmation */
        public class Serializer extends JsonSerializer<InviteeDataModel> {
            public final void m16218a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                InviteeDataModel inviteeDataModel = (InviteeDataModel) obj;
                if (inviteeDataModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(inviteeDataModel.m16220a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    inviteeDataModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = inviteeDataModel.w_();
                int u_ = inviteeDataModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("invitee");
                    InviteeParser.m16280a(mutableFlatBuffer, g, jsonGenerator);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(InviteeDataModel.class, new Serializer());
            }
        }

        public InviteeDataModel() {
            super(1);
        }

        @Nullable
        private InviteeModel m16219a() {
            this.f14515d = (InviteeModel) super.a(this.f14515d, 0, InviteeModel.class);
            return this.f14515d;
        }

        public final int jK_() {
            return 1476491891;
        }

        public final GraphQLVisitableModel m16221a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m16219a() != null) {
                InviteeModel inviteeModel = (InviteeModel) graphQLModelMutatingVisitor.b(m16219a());
                if (m16219a() != inviteeModel) {
                    graphQLVisitableModel = (InviteeDataModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f14515d = inviteeModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m16220a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m16219a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 579332437)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: extra_for_phone_number_confirmation */
    public final class MemberProfilesAddedByFieldsModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private AddedByModel f14518d;
        private long f14519e;

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -1185712657)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: extra_for_phone_number_confirmation */
        public final class AddedByModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
            @Nullable
            private String f14516d;
            @Nullable
            private String f14517e;

            /* compiled from: extra_for_phone_number_confirmation */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(AddedByModel.class, new Deserializer());
                }

                public Object m16222a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(AddedByParser.m16282a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object addedByModel = new AddedByModel();
                    ((BaseModel) addedByModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (addedByModel instanceof Postprocessable) {
                        return ((Postprocessable) addedByModel).a();
                    }
                    return addedByModel;
                }
            }

            /* compiled from: extra_for_phone_number_confirmation */
            public class Serializer extends JsonSerializer<AddedByModel> {
                public final void m16223a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    AddedByModel addedByModel = (AddedByModel) obj;
                    if (addedByModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(addedByModel.m16224a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        addedByModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    AddedByParser.m16283a(addedByModel.w_(), addedByModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(AddedByModel.class, new Serializer());
                }
            }

            public AddedByModel() {
                super(2);
            }

            public final void m16227a(String str, ConsistencyTuple consistencyTuple) {
                consistencyTuple.a();
            }

            public final void m16228a(String str, Object obj, boolean z) {
            }

            @Nullable
            public final String m16229j() {
                this.f14516d = super.a(this.f14516d, 0);
                return this.f14516d;
            }

            @Nullable
            public final String m16230k() {
                this.f14517e = super.a(this.f14517e, 1);
                return this.f14517e;
            }

            @Nullable
            public final String m16226a() {
                return m16229j();
            }

            public final int jK_() {
                return 2645995;
            }

            public final GraphQLVisitableModel m16225a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m16224a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m16229j());
                int b2 = flatBufferBuilder.b(m16230k());
                flatBufferBuilder.c(2);
                flatBufferBuilder.b(0, b);
                flatBufferBuilder.b(1, b2);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: extra_for_phone_number_confirmation */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(MemberProfilesAddedByFieldsModel.class, new Deserializer());
            }

            public Object m16231a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = MemberProfilesAddedByFieldsParser.m16284a(jsonParser);
                Object memberProfilesAddedByFieldsModel = new MemberProfilesAddedByFieldsModel();
                ((BaseModel) memberProfilesAddedByFieldsModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (memberProfilesAddedByFieldsModel instanceof Postprocessable) {
                    return ((Postprocessable) memberProfilesAddedByFieldsModel).a();
                }
                return memberProfilesAddedByFieldsModel;
            }
        }

        /* compiled from: extra_for_phone_number_confirmation */
        public class Serializer extends JsonSerializer<MemberProfilesAddedByFieldsModel> {
            public final void m16232a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                MemberProfilesAddedByFieldsModel memberProfilesAddedByFieldsModel = (MemberProfilesAddedByFieldsModel) obj;
                if (memberProfilesAddedByFieldsModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(memberProfilesAddedByFieldsModel.m16234a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    memberProfilesAddedByFieldsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = memberProfilesAddedByFieldsModel.w_();
                int u_ = memberProfilesAddedByFieldsModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("added_by");
                    AddedByParser.m16283a(mutableFlatBuffer, g, jsonGenerator);
                }
                long a = mutableFlatBuffer.a(u_, 1, 0);
                if (a != 0) {
                    jsonGenerator.a("added_time");
                    jsonGenerator.a(a);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(MemberProfilesAddedByFieldsModel.class, new Serializer());
            }
        }

        public MemberProfilesAddedByFieldsModel() {
            super(2);
        }

        @Nullable
        private AddedByModel m16233a() {
            this.f14518d = (AddedByModel) super.a(this.f14518d, 0, AddedByModel.class);
            return this.f14518d;
        }

        public final int jK_() {
            return -742467264;
        }

        public final GraphQLVisitableModel m16235a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m16233a() != null) {
                AddedByModel addedByModel = (AddedByModel) graphQLModelMutatingVisitor.b(m16233a());
                if (m16233a() != addedByModel) {
                    graphQLVisitableModel = (MemberProfilesAddedByFieldsModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f14518d = addedByModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m16234a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m16233a());
            flatBufferBuilder.c(2);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.a(1, this.f14519e, 0);
            i();
            return flatBufferBuilder.d();
        }

        public final void m16236a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
            super.a(mutableFlatBuffer, i, obj);
            this.f14519e = mutableFlatBuffer.a(i, 1, 0);
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 45109869)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: extra_for_phone_number_confirmation */
    public final class MemberProfilesConnectionDefaultFieldsModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private List<EdgesModel> f14530d;
        @Nullable
        private MemberProfilesPageInfoFieldsModel f14531e;

        /* compiled from: extra_for_phone_number_confirmation */
        public class Deserializer extends FbJsonDeserializer {
            static {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r0 = com.facebook.groups.memberlist.protocol.FetchGroupMemberProfilesListModels.MemberProfilesConnectionDefaultFieldsModel.class;
                r1 = new com.facebook.groups.memberlist.protocol.FetchGroupMemberProfilesListModels$MemberProfilesConnectionDefaultFieldsModel$Deserializer;
                r1.<init>();
                com.facebook.common.json.GlobalAutoGenDeserializerCache.a(r0, r1);
                return;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.memberlist.protocol.FetchGroupMemberProfilesListModels.MemberProfilesConnectionDefaultFieldsModel.Deserializer.<clinit>():void");
            }

            public java.lang.Object m16237a(com.fasterxml.jackson.core.JsonParser r11, com.fasterxml.jackson.databind.DeserializationContext r12) {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r10 = this;
                r8 = 1;
                r6 = 0;
                r4 = new com.facebook.flatbuffers.FlatBufferBuilder;
                r5 = 128; // 0x80 float:1.794E-43 double:6.32E-322;
                r4.<init>(r5);
                r5 = com.facebook.groups.memberlist.protocol.FetchGroupMemberProfilesListParsers.MemberProfilesConnectionDefaultFieldsParser.m16289a(r11, r4);
                r4.d(r5);
                r4 = r4.e();
                r5 = java.nio.ByteBuffer.wrap(r4);
                r4 = 0;
                r5.position(r4);
                r4 = new com.facebook.flatbuffers.MutableFlatBuffer;
                r7 = r6;
                r9 = r6;
                r4.<init>(r5, r6, r7, r8, r9);
                r5 = 4;
                r6 = java.lang.Boolean.valueOf(r8);
                r4.a(r5, r6);
                r2 = r4;
                r1 = new com.facebook.groups.memberlist.protocol.FetchGroupMemberProfilesListModels$MemberProfilesConnectionDefaultFieldsModel;
                r1.<init>();
                r4 = r2.a;
                r0 = r4;
                r3 = com.facebook.flatbuffers.FlatBuffer.a(r0);
                r0 = r1;
                r0 = (com.facebook.graphql.modelutil.BaseModel) r0;
                r0.a(r2, r3, r11);
                r0 = r1 instanceof com.facebook.common.json.Postprocessable;
                if (r0 == 0) goto L_0x0048;
            L_0x0042:
                r1 = (com.facebook.common.json.Postprocessable) r1;
                r1 = r1.a();
            L_0x0048:
                return r1;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.memberlist.protocol.FetchGroupMemberProfilesListModels.MemberProfilesConnectionDefaultFieldsModel.Deserializer.a(com.fasterxml.jackson.core.JsonParser, com.fasterxml.jackson.databind.DeserializationContext):java.lang.Object");
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 2143695730)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: extra_for_phone_number_confirmation */
        public final class EdgesModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private AddedByModel f14527d;
            private long f14528e;
            @Nullable
            private NodeModel f14529f;

            /* compiled from: extra_for_phone_number_confirmation */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r0 = com.facebook.groups.memberlist.protocol.FetchGroupMemberProfilesListModels.MemberProfilesConnectionDefaultFieldsModel.EdgesModel.class;
                    r1 = new com.facebook.groups.memberlist.protocol.FetchGroupMemberProfilesListModels$MemberProfilesConnectionDefaultFieldsModel$EdgesModel$Deserializer;
                    r1.<init>();
                    com.facebook.common.json.GlobalAutoGenDeserializerCache.a(r0, r1);
                    return;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.memberlist.protocol.FetchGroupMemberProfilesListModels.MemberProfilesConnectionDefaultFieldsModel.EdgesModel.Deserializer.<clinit>():void");
                }

                public java.lang.Object m16238a(com.fasterxml.jackson.core.JsonParser r11, com.fasterxml.jackson.databind.DeserializationContext r12) {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r10 = this;
                    r8 = 1;
                    r6 = 0;
                    r4 = new com.facebook.flatbuffers.FlatBufferBuilder;
                    r5 = 128; // 0x80 float:1.794E-43 double:6.32E-322;
                    r4.<init>(r5);
                    r5 = com.facebook.groups.memberlist.protocol.FetchGroupMemberProfilesListParsers.MemberProfilesConnectionDefaultFieldsParser.EdgesParser.m16287b(r11, r4);
                    r4.d(r5);
                    r4 = r4.e();
                    r5 = java.nio.ByteBuffer.wrap(r4);
                    r4 = 0;
                    r5.position(r4);
                    r4 = new com.facebook.flatbuffers.MutableFlatBuffer;
                    r7 = r6;
                    r9 = r6;
                    r4.<init>(r5, r6, r7, r8, r9);
                    r5 = 4;
                    r6 = java.lang.Boolean.valueOf(r8);
                    r4.a(r5, r6);
                    r2 = r4;
                    r1 = new com.facebook.groups.memberlist.protocol.FetchGroupMemberProfilesListModels$MemberProfilesConnectionDefaultFieldsModel$EdgesModel;
                    r1.<init>();
                    r4 = r2.a;
                    r0 = r4;
                    r3 = com.facebook.flatbuffers.FlatBuffer.a(r0);
                    r0 = r1;
                    r0 = (com.facebook.graphql.modelutil.BaseModel) r0;
                    r0.a(r2, r3, r11);
                    r0 = r1 instanceof com.facebook.common.json.Postprocessable;
                    if (r0 == 0) goto L_0x0048;
                L_0x0042:
                    r1 = (com.facebook.common.json.Postprocessable) r1;
                    r1 = r1.a();
                L_0x0048:
                    return r1;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.memberlist.protocol.FetchGroupMemberProfilesListModels.MemberProfilesConnectionDefaultFieldsModel.EdgesModel.Deserializer.a(com.fasterxml.jackson.core.JsonParser, com.fasterxml.jackson.databind.DeserializationContext):java.lang.Object");
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = -295388479)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: extra_for_phone_number_confirmation */
            public final class NodeModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel, GroupMemberData {
                @Nullable
                private GraphQLObjectType f14520d;
                @Nullable
                private String f14521e;
                @Nullable
                private InviteeModel f14522f;
                private boolean f14523g;
                @Nullable
                private LastActiveMessagesStatusModel f14524h;
                @Nullable
                private String f14525i;
                @Nullable
                private ProfilePictureModel f14526j;

                /* compiled from: extra_for_phone_number_confirmation */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                        /*
                        r0 = com.facebook.groups.memberlist.protocol.FetchGroupMemberProfilesListModels.MemberProfilesConnectionDefaultFieldsModel.EdgesModel.NodeModel.class;
                        r1 = new com.facebook.groups.memberlist.protocol.FetchGroupMemberProfilesListModels$MemberProfilesConnectionDefaultFieldsModel$EdgesModel$NodeModel$Deserializer;
                        r1.<init>();
                        com.facebook.common.json.GlobalAutoGenDeserializerCache.a(r0, r1);
                        return;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.memberlist.protocol.FetchGroupMemberProfilesListModels.MemberProfilesConnectionDefaultFieldsModel.EdgesModel.NodeModel.Deserializer.<clinit>():void");
                    }

                    public java.lang.Object m16239a(com.fasterxml.jackson.core.JsonParser r11, com.fasterxml.jackson.databind.DeserializationContext r12) {
                        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                        /*
                        r10 = this;
                        r8 = 1;
                        r6 = 0;
                        r4 = new com.facebook.flatbuffers.FlatBufferBuilder;
                        r5 = 128; // 0x80 float:1.794E-43 double:6.32E-322;
                        r4.<init>(r5);
                        r5 = com.facebook.groups.memberlist.protocol.FetchGroupMemberProfilesListParsers.MemberProfilesConnectionDefaultFieldsParser.EdgesParser.NodeParser.m16285a(r11, r4);
                        r4.d(r5);
                        r4 = r4.e();
                        r5 = java.nio.ByteBuffer.wrap(r4);
                        r4 = 0;
                        r5.position(r4);
                        r4 = new com.facebook.flatbuffers.MutableFlatBuffer;
                        r7 = r6;
                        r9 = r6;
                        r4.<init>(r5, r6, r7, r8, r9);
                        r5 = 4;
                        r6 = java.lang.Boolean.valueOf(r8);
                        r4.a(r5, r6);
                        r2 = r4;
                        r1 = new com.facebook.groups.memberlist.protocol.FetchGroupMemberProfilesListModels$MemberProfilesConnectionDefaultFieldsModel$EdgesModel$NodeModel;
                        r1.<init>();
                        r4 = r2.a;
                        r0 = r4;
                        r3 = com.facebook.flatbuffers.FlatBuffer.a(r0);
                        r0 = r1;
                        r0 = (com.facebook.graphql.modelutil.BaseModel) r0;
                        r0.a(r2, r3, r11);
                        r0 = r1 instanceof com.facebook.common.json.Postprocessable;
                        if (r0 == 0) goto L_0x0048;
                    L_0x0042:
                        r1 = (com.facebook.common.json.Postprocessable) r1;
                        r1 = r1.a();
                    L_0x0048:
                        return r1;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.memberlist.protocol.FetchGroupMemberProfilesListModels.MemberProfilesConnectionDefaultFieldsModel.EdgesModel.NodeModel.Deserializer.a(com.fasterxml.jackson.core.JsonParser, com.fasterxml.jackson.databind.DeserializationContext):java.lang.Object");
                    }
                }

                /* compiled from: extra_for_phone_number_confirmation */
                public class Serializer extends JsonSerializer<NodeModel> {
                    public final void m16240a(java.lang.Object r8, com.fasterxml.jackson.core.JsonGenerator r9, com.fasterxml.jackson.databind.SerializerProvider r10) {
                        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                        /*
                        r7 = this;
                        r8 = (com.facebook.groups.memberlist.protocol.FetchGroupMemberProfilesListModels.MemberProfilesConnectionDefaultFieldsModel.EdgesModel.NodeModel) r8;
                        r2 = 0;
                        r0 = r8.w_();
                        if (r0 != 0) goto L_0x0035;
                    L_0x0009:
                        r0 = new com.facebook.flatbuffers.FlatBufferBuilder;
                        r1 = 128; // 0x80 float:1.794E-43 double:6.32E-322;
                        r0.<init>(r1);
                        r1 = r8.m16243a(r0);
                        r0.d(r1);
                        r0 = r0.e();
                        r1 = java.nio.ByteBuffer.wrap(r0);
                        r0 = 0;
                        r1.position(r0);
                        r0 = new com.facebook.flatbuffers.MutableFlatBuffer;
                        r4 = 1;
                        r3 = r2;
                        r5 = r2;
                        r0.<init>(r1, r2, r3, r4, r5);
                        r6 = r0.a;
                        r1 = r6;
                        r1 = com.facebook.flatbuffers.FlatBuffer.a(r1);
                        r8.a(r0, r1);
                    L_0x0035:
                        r0 = r8.w_();
                        r1 = r8.u_();
                        com.facebook.groups.memberlist.protocol.FetchGroupMemberProfilesListParsers.MemberProfilesConnectionDefaultFieldsParser.EdgesParser.NodeParser.m16286a(r0, r1, r9, r10);
                        return;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.memberlist.protocol.FetchGroupMemberProfilesListModels.MemberProfilesConnectionDefaultFieldsModel.EdgesModel.NodeModel.Serializer.a(java.lang.Object, com.fasterxml.jackson.core.JsonGenerator, com.fasterxml.jackson.databind.SerializerProvider):void");
                    }

                    static {
                        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                        /*
                        r0 = com.facebook.groups.memberlist.protocol.FetchGroupMemberProfilesListModels.MemberProfilesConnectionDefaultFieldsModel.EdgesModel.NodeModel.class;
                        r1 = new com.facebook.groups.memberlist.protocol.FetchGroupMemberProfilesListModels$MemberProfilesConnectionDefaultFieldsModel$EdgesModel$NodeModel$Serializer;
                        r1.<init>();
                        com.facebook.common.json.FbSerializerProvider.a(r0, r1);
                        return;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.memberlist.protocol.FetchGroupMemberProfilesListModels.MemberProfilesConnectionDefaultFieldsModel.EdgesModel.NodeModel.Serializer.<clinit>():void");
                    }
                }

                @javax.annotation.Nullable
                public final /* synthetic */ com.facebook.groups.widget.memberrow.protocol.MemberDataModels.GroupMemberDataModel.LastActiveMessagesStatusModel m16251d() {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r1 = this;
                    r0 = r1.m16241l();
                    return r0;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.memberlist.protocol.FetchGroupMemberProfilesListModels.MemberProfilesConnectionDefaultFieldsModel.EdgesModel.NodeModel.d():com.facebook.groups.widget.memberrow.protocol.MemberDataModels$GroupMemberDataModel$LastActiveMessagesStatusModel");
                }

                @javax.annotation.Nullable
                public final /* synthetic */ com.facebook.groups.widget.memberrow.protocol.MemberDataModels.GroupMemberDataModel.ProfilePictureModel m16252g() {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r1 = this;
                    r0 = r1.m16242m();
                    return r0;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.memberlist.protocol.FetchGroupMemberProfilesListModels.MemberProfilesConnectionDefaultFieldsModel.EdgesModel.NodeModel.g():com.facebook.groups.widget.memberrow.protocol.MemberDataModels$GroupMemberDataModel$ProfilePictureModel");
                }

                public NodeModel() {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r1 = this;
                    r0 = 7;
                    r1.<init>(r0);
                    return;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.memberlist.protocol.FetchGroupMemberProfilesListModels.MemberProfilesConnectionDefaultFieldsModel.EdgesModel.NodeModel.<init>():void");
                }

                public final void m16247a(java.lang.String r1, com.facebook.graphql.visitor.ConsistencyTuple r2) {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r0 = this;
                    r2.a();
                    return;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.memberlist.protocol.FetchGroupMemberProfilesListModels.MemberProfilesConnectionDefaultFieldsModel.EdgesModel.NodeModel.a(java.lang.String, com.facebook.graphql.visitor.ConsistencyTuple):void");
                }

                public final void m16248a(java.lang.String r1, java.lang.Object r2, boolean r3) {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r0 = this;
                    return;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.memberlist.protocol.FetchGroupMemberProfilesListModels.MemberProfilesConnectionDefaultFieldsModel.EdgesModel.NodeModel.a(java.lang.String, java.lang.Object, boolean):void");
                }

                @javax.annotation.Nullable
                public final com.facebook.graphql.enums.GraphQLObjectType m16253j() {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r4 = this;
                    r0 = r4.b;
                    if (r0 == 0) goto L_0x0017;
                L_0x0004:
                    r0 = r4.f14520d;
                    if (r0 != 0) goto L_0x0017;
                L_0x0008:
                    r0 = r4.b;
                    r1 = r4.c;
                    r2 = 0;
                    r3 = com.facebook.graphql.enums.GraphQLObjectType.class;
                    r0 = r0.d(r1, r2, r3);
                    r0 = (com.facebook.graphql.enums.GraphQLObjectType) r0;
                    r4.f14520d = r0;
                L_0x0017:
                    r0 = r4.f14520d;
                    return r0;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.memberlist.protocol.FetchGroupMemberProfilesListModels.MemberProfilesConnectionDefaultFieldsModel.EdgesModel.NodeModel.j():com.facebook.graphql.enums.GraphQLObjectType");
                }

                @javax.annotation.Nullable
                public final java.lang.String m16249b() {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r2 = this;
                    r0 = r2.f14521e;
                    r1 = 1;
                    r0 = super.a(r0, r1);
                    r2.f14521e = r0;
                    r0 = r2.f14521e;
                    return r0;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.memberlist.protocol.FetchGroupMemberProfilesListModels.MemberProfilesConnectionDefaultFieldsModel.EdgesModel.NodeModel.b():java.lang.String");
                }

                @javax.annotation.Nullable
                public final com.facebook.groups.memberlist.protocol.FetchGroupMemberProfilesListModels.InviteeDataModel.InviteeModel m16254k() {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r3 = this;
                    r0 = r3.f14522f;
                    r1 = 2;
                    r2 = com.facebook.groups.memberlist.protocol.FetchGroupMemberProfilesListModels.InviteeDataModel.InviteeModel.class;
                    r0 = super.a(r0, r1, r2);
                    r0 = (com.facebook.groups.memberlist.protocol.FetchGroupMemberProfilesListModels.InviteeDataModel.InviteeModel) r0;
                    r3.f14522f = r0;
                    r0 = r3.f14522f;
                    return r0;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.memberlist.protocol.FetchGroupMemberProfilesListModels.MemberProfilesConnectionDefaultFieldsModel.EdgesModel.NodeModel.k():com.facebook.groups.memberlist.protocol.FetchGroupMemberProfilesListModels$InviteeDataModel$InviteeModel");
                }

                public final boolean m16250c() {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r2 = this;
                    r0 = 0;
                    r1 = 3;
                    r2.a(r0, r1);
                    r0 = r2.f14523g;
                    return r0;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.memberlist.protocol.FetchGroupMemberProfilesListModels.MemberProfilesConnectionDefaultFieldsModel.EdgesModel.NodeModel.c():boolean");
                }

                @javax.annotation.Nullable
                private com.facebook.groups.widget.memberrow.protocol.MemberDataModels.GroupMemberDataModel.LastActiveMessagesStatusModel m16241l() {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r3 = this;
                    r0 = r3.f14524h;
                    r1 = 4;
                    r2 = com.facebook.groups.widget.memberrow.protocol.MemberDataModels.GroupMemberDataModel.LastActiveMessagesStatusModel.class;
                    r0 = super.a(r0, r1, r2);
                    r0 = (com.facebook.groups.widget.memberrow.protocol.MemberDataModels.GroupMemberDataModel.LastActiveMessagesStatusModel) r0;
                    r3.f14524h = r0;
                    r0 = r3.f14524h;
                    return r0;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.memberlist.protocol.FetchGroupMemberProfilesListModels.MemberProfilesConnectionDefaultFieldsModel.EdgesModel.NodeModel.l():com.facebook.groups.widget.memberrow.protocol.MemberDataModels$GroupMemberDataModel$LastActiveMessagesStatusModel");
                }

                @javax.annotation.Nullable
                public final java.lang.String he_() {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r2 = this;
                    r0 = r2.f14525i;
                    r1 = 5;
                    r0 = super.a(r0, r1);
                    r2.f14525i = r0;
                    r0 = r2.f14525i;
                    return r0;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.memberlist.protocol.FetchGroupMemberProfilesListModels.MemberProfilesConnectionDefaultFieldsModel.EdgesModel.NodeModel.he_():java.lang.String");
                }

                @javax.annotation.Nullable
                private com.facebook.groups.widget.memberrow.protocol.MemberDataModels.GroupMemberDataModel.ProfilePictureModel m16242m() {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r3 = this;
                    r0 = r3.f14526j;
                    r1 = 6;
                    r2 = com.facebook.groups.widget.memberrow.protocol.MemberDataModels.GroupMemberDataModel.ProfilePictureModel.class;
                    r0 = super.a(r0, r1, r2);
                    r0 = (com.facebook.groups.widget.memberrow.protocol.MemberDataModels.GroupMemberDataModel.ProfilePictureModel) r0;
                    r3.f14526j = r0;
                    r0 = r3.f14526j;
                    return r0;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.memberlist.protocol.FetchGroupMemberProfilesListModels.MemberProfilesConnectionDefaultFieldsModel.EdgesModel.NodeModel.m():com.facebook.groups.widget.memberrow.protocol.MemberDataModels$GroupMemberDataModel$ProfilePictureModel");
                }

                @javax.annotation.Nullable
                public final java.lang.String m16245a() {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r1 = this;
                    r0 = r1.m16249b();
                    return r0;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.memberlist.protocol.FetchGroupMemberProfilesListModels.MemberProfilesConnectionDefaultFieldsModel.EdgesModel.NodeModel.a():java.lang.String");
                }

                public final int jK_() {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r1 = this;
                    r0 = 1355227529; // 0x50c72189 float:2.672691E10 double:6.695713644E-315;
                    return r0;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.memberlist.protocol.FetchGroupMemberProfilesListModels.MemberProfilesConnectionDefaultFieldsModel.EdgesModel.NodeModel.jK_():int");
                }

                public final com.facebook.graphql.visitor.GraphQLVisitableModel m16244a(com.facebook.graphql.visitor.GraphQLModelMutatingVisitor r4) {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r3 = this;
                    r1 = 0;
                    r3.h();
                    r0 = r3.m16254k();
                    if (r0 == 0) goto L_0x0022;
                L_0x000a:
                    r0 = r3.m16254k();
                    r0 = r4.b(r0);
                    r0 = (com.facebook.groups.memberlist.protocol.FetchGroupMemberProfilesListModels.InviteeDataModel.InviteeModel) r0;
                    r2 = r3.m16254k();
                    if (r2 == r0) goto L_0x0022;
                L_0x001a:
                    r1 = com.facebook.graphql.modelutil.ModelHelper.a(r1, r3);
                    r1 = (com.facebook.groups.memberlist.protocol.FetchGroupMemberProfilesListModels.MemberProfilesConnectionDefaultFieldsModel.EdgesModel.NodeModel) r1;
                    r1.f14522f = r0;
                L_0x0022:
                    r0 = r3.m16241l();
                    if (r0 == 0) goto L_0x0040;
                L_0x0028:
                    r0 = r3.m16241l();
                    r0 = r4.b(r0);
                    r0 = (com.facebook.groups.widget.memberrow.protocol.MemberDataModels.GroupMemberDataModel.LastActiveMessagesStatusModel) r0;
                    r2 = r3.m16241l();
                    if (r2 == r0) goto L_0x0040;
                L_0x0038:
                    r1 = com.facebook.graphql.modelutil.ModelHelper.a(r1, r3);
                    r1 = (com.facebook.groups.memberlist.protocol.FetchGroupMemberProfilesListModels.MemberProfilesConnectionDefaultFieldsModel.EdgesModel.NodeModel) r1;
                    r1.f14524h = r0;
                L_0x0040:
                    r0 = r3.m16242m();
                    if (r0 == 0) goto L_0x005e;
                L_0x0046:
                    r0 = r3.m16242m();
                    r0 = r4.b(r0);
                    r0 = (com.facebook.groups.widget.memberrow.protocol.MemberDataModels.GroupMemberDataModel.ProfilePictureModel) r0;
                    r2 = r3.m16242m();
                    if (r2 == r0) goto L_0x005e;
                L_0x0056:
                    r1 = com.facebook.graphql.modelutil.ModelHelper.a(r1, r3);
                    r1 = (com.facebook.groups.memberlist.protocol.FetchGroupMemberProfilesListModels.MemberProfilesConnectionDefaultFieldsModel.EdgesModel.NodeModel) r1;
                    r1.f14526j = r0;
                L_0x005e:
                    r3.i();
                    if (r1 != 0) goto L_0x0064;
                L_0x0063:
                    return r3;
                L_0x0064:
                    r3 = r1;
                    goto L_0x0063;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.memberlist.protocol.FetchGroupMemberProfilesListModels.MemberProfilesConnectionDefaultFieldsModel.EdgesModel.NodeModel.a(com.facebook.graphql.visitor.GraphQLModelMutatingVisitor):com.facebook.graphql.visitor.GraphQLVisitableModel");
                }

                public final int m16243a(com.facebook.flatbuffers.FlatBufferBuilder r8) {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r7 = this;
                    r7.h();
                    r0 = r7.m16253j();
                    r0 = com.facebook.graphql.modelutil.ModelHelper.a(r8, r0);
                    r1 = r7.m16249b();
                    r1 = r8.b(r1);
                    r2 = r7.m16254k();
                    r2 = com.facebook.graphql.modelutil.ModelHelper.a(r8, r2);
                    r3 = r7.m16241l();
                    r3 = com.facebook.graphql.modelutil.ModelHelper.a(r8, r3);
                    r4 = r7.he_();
                    r4 = r8.b(r4);
                    r5 = r7.m16242m();
                    r5 = com.facebook.graphql.modelutil.ModelHelper.a(r8, r5);
                    r6 = 7;
                    r8.c(r6);
                    r6 = 0;
                    r8.b(r6, r0);
                    r0 = 1;
                    r8.b(r0, r1);
                    r0 = 2;
                    r8.b(r0, r2);
                    r0 = 3;
                    r1 = r7.f14523g;
                    r8.a(r0, r1);
                    r0 = 4;
                    r8.b(r0, r3);
                    r0 = 5;
                    r8.b(r0, r4);
                    r0 = 6;
                    r8.b(r0, r5);
                    r7.i();
                    r0 = r8.d();
                    return r0;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.memberlist.protocol.FetchGroupMemberProfilesListModels.MemberProfilesConnectionDefaultFieldsModel.EdgesModel.NodeModel.a(com.facebook.flatbuffers.FlatBufferBuilder):int");
                }

                public final void m16246a(com.facebook.flatbuffers.MutableFlatBuffer r2, int r3, java.lang.Object r4) {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r1 = this;
                    super.a(r2, r3, r4);
                    r0 = 3;
                    r0 = r2.a(r3, r0);
                    r1.f14523g = r0;
                    return;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.memberlist.protocol.FetchGroupMemberProfilesListModels.MemberProfilesConnectionDefaultFieldsModel.EdgesModel.NodeModel.a(com.facebook.flatbuffers.MutableFlatBuffer, int, java.lang.Object):void");
                }
            }

            /* compiled from: extra_for_phone_number_confirmation */
            public class Serializer extends JsonSerializer<EdgesModel> {
                public final void m16255a(java.lang.Object r8, com.fasterxml.jackson.core.JsonGenerator r9, com.fasterxml.jackson.databind.SerializerProvider r10) {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r7 = this;
                    r8 = (com.facebook.groups.memberlist.protocol.FetchGroupMemberProfilesListModels.MemberProfilesConnectionDefaultFieldsModel.EdgesModel) r8;
                    r2 = 0;
                    r0 = r8.w_();
                    if (r0 != 0) goto L_0x0035;
                L_0x0009:
                    r0 = new com.facebook.flatbuffers.FlatBufferBuilder;
                    r1 = 128; // 0x80 float:1.794E-43 double:6.32E-322;
                    r0.<init>(r1);
                    r1 = r8.m16256a(r0);
                    r0.d(r1);
                    r0 = r0.e();
                    r1 = java.nio.ByteBuffer.wrap(r0);
                    r0 = 0;
                    r1.position(r0);
                    r0 = new com.facebook.flatbuffers.MutableFlatBuffer;
                    r4 = 1;
                    r3 = r2;
                    r5 = r2;
                    r0.<init>(r1, r2, r3, r4, r5);
                    r6 = r0.a;
                    r1 = r6;
                    r1 = com.facebook.flatbuffers.FlatBuffer.a(r1);
                    r8.a(r0, r1);
                L_0x0035:
                    r0 = r8.w_();
                    r1 = r8.u_();
                    com.facebook.groups.memberlist.protocol.FetchGroupMemberProfilesListParsers.MemberProfilesConnectionDefaultFieldsParser.EdgesParser.m16288b(r0, r1, r9, r10);
                    return;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.memberlist.protocol.FetchGroupMemberProfilesListModels.MemberProfilesConnectionDefaultFieldsModel.EdgesModel.Serializer.a(java.lang.Object, com.fasterxml.jackson.core.JsonGenerator, com.fasterxml.jackson.databind.SerializerProvider):void");
                }

                static {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r0 = com.facebook.groups.memberlist.protocol.FetchGroupMemberProfilesListModels.MemberProfilesConnectionDefaultFieldsModel.EdgesModel.class;
                    r1 = new com.facebook.groups.memberlist.protocol.FetchGroupMemberProfilesListModels$MemberProfilesConnectionDefaultFieldsModel$EdgesModel$Serializer;
                    r1.<init>();
                    com.facebook.common.json.FbSerializerProvider.a(r0, r1);
                    return;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.memberlist.protocol.FetchGroupMemberProfilesListModels.MemberProfilesConnectionDefaultFieldsModel.EdgesModel.Serializer.<clinit>():void");
                }
            }

            public EdgesModel() {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r1 = this;
                r0 = 3;
                r1.<init>(r0);
                return;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.memberlist.protocol.FetchGroupMemberProfilesListModels.MemberProfilesConnectionDefaultFieldsModel.EdgesModel.<init>():void");
            }

            @javax.annotation.Nullable
            public final com.facebook.groups.memberlist.protocol.FetchGroupMemberProfilesListModels.MemberProfilesAddedByFieldsModel.AddedByModel m16258a() {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r3 = this;
                r0 = r3.f14527d;
                r1 = 0;
                r2 = com.facebook.groups.memberlist.protocol.FetchGroupMemberProfilesListModels.MemberProfilesAddedByFieldsModel.AddedByModel.class;
                r0 = super.a(r0, r1, r2);
                r0 = (com.facebook.groups.memberlist.protocol.FetchGroupMemberProfilesListModels.MemberProfilesAddedByFieldsModel.AddedByModel) r0;
                r3.f14527d = r0;
                r0 = r3.f14527d;
                return r0;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.memberlist.protocol.FetchGroupMemberProfilesListModels.MemberProfilesConnectionDefaultFieldsModel.EdgesModel.a():com.facebook.groups.memberlist.protocol.FetchGroupMemberProfilesListModels$MemberProfilesAddedByFieldsModel$AddedByModel");
            }

            public final long m16260j() {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r2 = this;
                r0 = 0;
                r1 = 1;
                r2.a(r0, r1);
                r0 = r2.f14528e;
                return r0;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.memberlist.protocol.FetchGroupMemberProfilesListModels.MemberProfilesConnectionDefaultFieldsModel.EdgesModel.j():long");
            }

            @javax.annotation.Nullable
            public final com.facebook.groups.memberlist.protocol.FetchGroupMemberProfilesListModels.MemberProfilesConnectionDefaultFieldsModel.EdgesModel.NodeModel m16261k() {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r3 = this;
                r0 = r3.f14529f;
                r1 = 2;
                r2 = com.facebook.groups.memberlist.protocol.FetchGroupMemberProfilesListModels.MemberProfilesConnectionDefaultFieldsModel.EdgesModel.NodeModel.class;
                r0 = super.a(r0, r1, r2);
                r0 = (com.facebook.groups.memberlist.protocol.FetchGroupMemberProfilesListModels.MemberProfilesConnectionDefaultFieldsModel.EdgesModel.NodeModel) r0;
                r3.f14529f = r0;
                r0 = r3.f14529f;
                return r0;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.memberlist.protocol.FetchGroupMemberProfilesListModels.MemberProfilesConnectionDefaultFieldsModel.EdgesModel.k():com.facebook.groups.memberlist.protocol.FetchGroupMemberProfilesListModels$MemberProfilesConnectionDefaultFieldsModel$EdgesModel$NodeModel");
            }

            public final int jK_() {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r1 = this;
                r0 = -742467264; // 0xffffffffd3bed940 float:-1.63937727E12 double:NaN;
                return r0;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.memberlist.protocol.FetchGroupMemberProfilesListModels.MemberProfilesConnectionDefaultFieldsModel.EdgesModel.jK_():int");
            }

            public final com.facebook.graphql.visitor.GraphQLVisitableModel m16257a(com.facebook.graphql.visitor.GraphQLModelMutatingVisitor r4) {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r3 = this;
                r1 = 0;
                r3.h();
                r0 = r3.m16258a();
                if (r0 == 0) goto L_0x0022;
            L_0x000a:
                r0 = r3.m16258a();
                r0 = r4.b(r0);
                r0 = (com.facebook.groups.memberlist.protocol.FetchGroupMemberProfilesListModels.MemberProfilesAddedByFieldsModel.AddedByModel) r0;
                r2 = r3.m16258a();
                if (r2 == r0) goto L_0x0022;
            L_0x001a:
                r1 = com.facebook.graphql.modelutil.ModelHelper.a(r1, r3);
                r1 = (com.facebook.groups.memberlist.protocol.FetchGroupMemberProfilesListModels.MemberProfilesConnectionDefaultFieldsModel.EdgesModel) r1;
                r1.f14527d = r0;
            L_0x0022:
                r0 = r3.m16261k();
                if (r0 == 0) goto L_0x0040;
            L_0x0028:
                r0 = r3.m16261k();
                r0 = r4.b(r0);
                r0 = (com.facebook.groups.memberlist.protocol.FetchGroupMemberProfilesListModels.MemberProfilesConnectionDefaultFieldsModel.EdgesModel.NodeModel) r0;
                r2 = r3.m16261k();
                if (r2 == r0) goto L_0x0040;
            L_0x0038:
                r1 = com.facebook.graphql.modelutil.ModelHelper.a(r1, r3);
                r1 = (com.facebook.groups.memberlist.protocol.FetchGroupMemberProfilesListModels.MemberProfilesConnectionDefaultFieldsModel.EdgesModel) r1;
                r1.f14529f = r0;
            L_0x0040:
                r3.i();
                if (r1 != 0) goto L_0x0046;
            L_0x0045:
                return r3;
            L_0x0046:
                r3 = r1;
                goto L_0x0045;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.memberlist.protocol.FetchGroupMemberProfilesListModels.MemberProfilesConnectionDefaultFieldsModel.EdgesModel.a(com.facebook.graphql.visitor.GraphQLModelMutatingVisitor):com.facebook.graphql.visitor.GraphQLVisitableModel");
            }

            public final int m16256a(com.facebook.flatbuffers.FlatBufferBuilder r8) {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r7 = this;
                r7.h();
                r0 = r7.m16258a();
                r0 = com.facebook.graphql.modelutil.ModelHelper.a(r8, r0);
                r1 = r7.m16261k();
                r6 = com.facebook.graphql.modelutil.ModelHelper.a(r8, r1);
                r1 = 3;
                r8.c(r1);
                r1 = 0;
                r8.b(r1, r0);
                r1 = 1;
                r2 = r7.f14528e;
                r4 = 0;
                r0 = r8;
                r0.a(r1, r2, r4);
                r0 = 2;
                r8.b(r0, r6);
                r7.i();
                r0 = r8.d();
                return r0;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.memberlist.protocol.FetchGroupMemberProfilesListModels.MemberProfilesConnectionDefaultFieldsModel.EdgesModel.a(com.facebook.flatbuffers.FlatBufferBuilder):int");
            }

            public final void m16259a(com.facebook.flatbuffers.MutableFlatBuffer r5, int r6, java.lang.Object r7) {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r4 = this;
                super.a(r5, r6, r7);
                r0 = 1;
                r2 = 0;
                r0 = r5.a(r6, r0, r2);
                r4.f14528e = r0;
                return;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.memberlist.protocol.FetchGroupMemberProfilesListModels.MemberProfilesConnectionDefaultFieldsModel.EdgesModel.a(com.facebook.flatbuffers.MutableFlatBuffer, int, java.lang.Object):void");
            }
        }

        /* compiled from: extra_for_phone_number_confirmation */
        public class Serializer extends JsonSerializer<MemberProfilesConnectionDefaultFieldsModel> {
            public final void m16262a(java.lang.Object r8, com.fasterxml.jackson.core.JsonGenerator r9, com.fasterxml.jackson.databind.SerializerProvider r10) {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r7 = this;
                r8 = (com.facebook.groups.memberlist.protocol.FetchGroupMemberProfilesListModels.MemberProfilesConnectionDefaultFieldsModel) r8;
                r2 = 0;
                r0 = r8.w_();
                if (r0 != 0) goto L_0x0035;
            L_0x0009:
                r0 = new com.facebook.flatbuffers.FlatBufferBuilder;
                r1 = 128; // 0x80 float:1.794E-43 double:6.32E-322;
                r0.<init>(r1);
                r1 = r8.m16263a(r0);
                r0.d(r1);
                r0 = r0.e();
                r1 = java.nio.ByteBuffer.wrap(r0);
                r0 = 0;
                r1.position(r0);
                r0 = new com.facebook.flatbuffers.MutableFlatBuffer;
                r4 = 1;
                r3 = r2;
                r5 = r2;
                r0.<init>(r1, r2, r3, r4, r5);
                r6 = r0.a;
                r1 = r6;
                r1 = com.facebook.flatbuffers.FlatBuffer.a(r1);
                r8.a(r0, r1);
            L_0x0035:
                r0 = r8.w_();
                r1 = r8.u_();
                com.facebook.groups.memberlist.protocol.FetchGroupMemberProfilesListParsers.MemberProfilesConnectionDefaultFieldsParser.m16290a(r0, r1, r9, r10);
                return;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.memberlist.protocol.FetchGroupMemberProfilesListModels.MemberProfilesConnectionDefaultFieldsModel.Serializer.a(java.lang.Object, com.fasterxml.jackson.core.JsonGenerator, com.fasterxml.jackson.databind.SerializerProvider):void");
            }

            static {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r0 = com.facebook.groups.memberlist.protocol.FetchGroupMemberProfilesListModels.MemberProfilesConnectionDefaultFieldsModel.class;
                r1 = new com.facebook.groups.memberlist.protocol.FetchGroupMemberProfilesListModels$MemberProfilesConnectionDefaultFieldsModel$Serializer;
                r1.<init>();
                com.facebook.common.json.FbSerializerProvider.a(r0, r1);
                return;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.memberlist.protocol.FetchGroupMemberProfilesListModels.MemberProfilesConnectionDefaultFieldsModel.Serializer.<clinit>():void");
            }
        }

        public MemberProfilesConnectionDefaultFieldsModel() {
            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
            /*
            r1 = this;
            r0 = 2;
            r1.<init>(r0);
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.memberlist.protocol.FetchGroupMemberProfilesListModels.MemberProfilesConnectionDefaultFieldsModel.<init>():void");
        }

        @javax.annotation.Nonnull
        public final com.google.common.collect.ImmutableList<com.facebook.groups.memberlist.protocol.FetchGroupMemberProfilesListModels.MemberProfilesConnectionDefaultFieldsModel.EdgesModel> m16265a() {
            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
            /*
            r3 = this;
            r0 = r3.f14530d;
            r1 = 0;
            r2 = com.facebook.groups.memberlist.protocol.FetchGroupMemberProfilesListModels.MemberProfilesConnectionDefaultFieldsModel.EdgesModel.class;
            r0 = super.a(r0, r1, r2);
            r3.f14530d = r0;
            r0 = r3.f14530d;
            r0 = (com.google.common.collect.ImmutableList) r0;
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.memberlist.protocol.FetchGroupMemberProfilesListModels.MemberProfilesConnectionDefaultFieldsModel.a():com.google.common.collect.ImmutableList<com.facebook.groups.memberlist.protocol.FetchGroupMemberProfilesListModels$MemberProfilesConnectionDefaultFieldsModel$EdgesModel>");
        }

        @javax.annotation.Nullable
        public final com.facebook.groups.memberlist.protocol.FetchGroupMemberProfilesListModels.MemberProfilesPageInfoFieldsModel m16266j() {
            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
            /*
            r3 = this;
            r0 = r3.f14531e;
            r1 = 1;
            r2 = com.facebook.groups.memberlist.protocol.FetchGroupMemberProfilesListModels.MemberProfilesPageInfoFieldsModel.class;
            r0 = super.a(r0, r1, r2);
            r0 = (com.facebook.groups.memberlist.protocol.FetchGroupMemberProfilesListModels.MemberProfilesPageInfoFieldsModel) r0;
            r3.f14531e = r0;
            r0 = r3.f14531e;
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.memberlist.protocol.FetchGroupMemberProfilesListModels.MemberProfilesConnectionDefaultFieldsModel.j():com.facebook.groups.memberlist.protocol.FetchGroupMemberProfilesListModels$MemberProfilesPageInfoFieldsModel");
        }

        public final int jK_() {
            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
            /*
            r1 = this;
            r0 = -894960607; // 0xffffffffcaa7fc21 float:-5504528.5 double:NaN;
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.memberlist.protocol.FetchGroupMemberProfilesListModels.MemberProfilesConnectionDefaultFieldsModel.jK_():int");
        }

        public final com.facebook.graphql.visitor.GraphQLVisitableModel m16264a(com.facebook.graphql.visitor.GraphQLModelMutatingVisitor r4) {
            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
            /*
            r3 = this;
            r0 = 0;
            r3.h();
            r1 = r3.m16265a();
            if (r1 == 0) goto L_0x0047;
        L_0x000a:
            r1 = r3.m16265a();
            r1 = com.facebook.graphql.modelutil.ModelHelper.a(r1, r4);
            if (r1 == 0) goto L_0x0047;
        L_0x0014:
            r0 = com.facebook.graphql.modelutil.ModelHelper.a(r0, r3);
            r0 = (com.facebook.groups.memberlist.protocol.FetchGroupMemberProfilesListModels.MemberProfilesConnectionDefaultFieldsModel) r0;
            r1 = r1.b();
            r0.f14530d = r1;
            r1 = r0;
        L_0x0021:
            r0 = r3.m16266j();
            if (r0 == 0) goto L_0x003f;
        L_0x0027:
            r0 = r3.m16266j();
            r0 = r4.b(r0);
            r0 = (com.facebook.groups.memberlist.protocol.FetchGroupMemberProfilesListModels.MemberProfilesPageInfoFieldsModel) r0;
            r2 = r3.m16266j();
            if (r2 == r0) goto L_0x003f;
        L_0x0037:
            r1 = com.facebook.graphql.modelutil.ModelHelper.a(r1, r3);
            r1 = (com.facebook.groups.memberlist.protocol.FetchGroupMemberProfilesListModels.MemberProfilesConnectionDefaultFieldsModel) r1;
            r1.f14531e = r0;
        L_0x003f:
            r3.i();
            if (r1 != 0) goto L_0x0045;
        L_0x0044:
            return r3;
        L_0x0045:
            r3 = r1;
            goto L_0x0044;
        L_0x0047:
            r1 = r0;
            goto L_0x0021;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.memberlist.protocol.FetchGroupMemberProfilesListModels.MemberProfilesConnectionDefaultFieldsModel.a(com.facebook.graphql.visitor.GraphQLModelMutatingVisitor):com.facebook.graphql.visitor.GraphQLVisitableModel");
        }

        public final int m16263a(com.facebook.flatbuffers.FlatBufferBuilder r4) {
            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
            /*
            r3 = this;
            r3.h();
            r0 = r3.m16265a();
            r0 = com.facebook.graphql.modelutil.ModelHelper.a(r4, r0);
            r1 = r3.m16266j();
            r1 = com.facebook.graphql.modelutil.ModelHelper.a(r4, r1);
            r2 = 2;
            r4.c(r2);
            r2 = 0;
            r4.b(r2, r0);
            r0 = 1;
            r4.b(r0, r1);
            r3.i();
            r0 = r4.d();
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.memberlist.protocol.FetchGroupMemberProfilesListModels.MemberProfilesConnectionDefaultFieldsModel.a(com.facebook.flatbuffers.FlatBufferBuilder):int");
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 1536830492)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: extra_for_phone_number_confirmation */
    public final class MemberProfilesPageInfoFieldsModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private String f14532d;
        @Nullable
        private String f14533e;
        private boolean f14534f;
        private boolean f14535g;
        @Nullable
        private String f14536h;

        /* compiled from: extra_for_phone_number_confirmation */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(MemberProfilesPageInfoFieldsModel.class, new Deserializer());
            }

            public Object m16267a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(MemberProfilesPageInfoFieldsParser.m16291a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object memberProfilesPageInfoFieldsModel = new MemberProfilesPageInfoFieldsModel();
                ((BaseModel) memberProfilesPageInfoFieldsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (memberProfilesPageInfoFieldsModel instanceof Postprocessable) {
                    return ((Postprocessable) memberProfilesPageInfoFieldsModel).a();
                }
                return memberProfilesPageInfoFieldsModel;
            }
        }

        /* compiled from: extra_for_phone_number_confirmation */
        public class Serializer extends JsonSerializer<MemberProfilesPageInfoFieldsModel> {
            public final void m16268a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MemberProfilesPageInfoFieldsModel memberProfilesPageInfoFieldsModel = (MemberProfilesPageInfoFieldsModel) obj;
                if (memberProfilesPageInfoFieldsModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(memberProfilesPageInfoFieldsModel.m16271a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    memberProfilesPageInfoFieldsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                MemberProfilesPageInfoFieldsParser.m16292a(memberProfilesPageInfoFieldsModel.w_(), memberProfilesPageInfoFieldsModel.u_(), jsonGenerator);
            }

            static {
                FbSerializerProvider.a(MemberProfilesPageInfoFieldsModel.class, new Serializer());
            }
        }

        public MemberProfilesPageInfoFieldsModel() {
            super(5);
        }

        @Nullable
        private String m16269k() {
            this.f14532d = super.a(this.f14532d, 0);
            return this.f14532d;
        }

        @Nullable
        public final String m16273a() {
            this.f14533e = super.a(this.f14533e, 1);
            return this.f14533e;
        }

        public final boolean m16275j() {
            a(0, 2);
            return this.f14534f;
        }

        @Nullable
        private String m16270l() {
            this.f14536h = super.a(this.f14536h, 4);
            return this.f14536h;
        }

        public final int jK_() {
            return 923779069;
        }

        public final GraphQLVisitableModel m16272a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            h();
            i();
            return this;
        }

        public final int m16271a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int b = flatBufferBuilder.b(m16269k());
            int b2 = flatBufferBuilder.b(m16273a());
            int b3 = flatBufferBuilder.b(m16270l());
            flatBufferBuilder.c(5);
            flatBufferBuilder.b(0, b);
            flatBufferBuilder.b(1, b2);
            flatBufferBuilder.a(2, this.f14534f);
            flatBufferBuilder.a(3, this.f14535g);
            flatBufferBuilder.b(4, b3);
            i();
            return flatBufferBuilder.d();
        }

        public final void m16274a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
            super.a(mutableFlatBuffer, i, obj);
            this.f14534f = mutableFlatBuffer.a(i, 2);
            this.f14535g = mutableFlatBuffer.a(i, 3);
        }
    }
}
