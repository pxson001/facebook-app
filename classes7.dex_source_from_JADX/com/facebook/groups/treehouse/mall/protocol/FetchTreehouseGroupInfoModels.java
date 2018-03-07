package com.facebook.groups.treehouse.mall.protocol;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbSerializerProvider;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.FragmentModelWithoutBridge;
import com.facebook.flatbuffers.ModelWithFlatBufferFormatHash;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.enums.GraphQLGroupAdminType;
import com.facebook.graphql.enums.GraphQLGroupJoinState;
import com.facebook.graphql.enums.GraphQLGroupPostStatus;
import com.facebook.graphql.enums.GraphQLSubscribeStatus;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.ModelHelper;
import com.facebook.graphql.visitor.ConsistencyTuple;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLPersistableNode;
import com.facebook.graphql.visitor.GraphQLVisitableConsistentModel;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.facebook.groupcommerce.protocol.GroupSellInformationGraphQLInterfaces.GroupSellInformation;
import com.facebook.groupcommerce.protocol.GroupSellInformationGraphQLModels.GroupSellInformationModel.GroupSellConfigModel;
import com.facebook.groups.feed.protocol.FetchGroupInformationGraphQLInterfaces.GroupPinnedPost;
import com.facebook.groups.feed.protocol.FetchGroupInformationGraphQLInterfaces.GroupViewerInviteInformation;
import com.facebook.groups.feed.protocol.FetchGroupInformationGraphQLInterfaces.GroupViewerStatus;
import com.facebook.groups.feed.protocol.FetchGroupInformationGraphQLModels.GroupPinnedPostModel.GroupPinnedStoriesModel;
import com.facebook.groups.feed.protocol.FetchGroupInformationGraphQLModels.GroupViewerInviteInformationModel.ViewerInviteToGroupModel;
import com.facebook.groups.grouppurposes.protocol.GroupPurposesInformationGraphQLInterfaces.GroupPurposesInformation;
import com.facebook.groups.grouppurposes.protocol.GroupPurposesInformationGraphQLModels.GroupPurposesInformationModel.GroupPurposesModel;
import com.facebook.groups.grouppurposes.protocol.GroupPurposesInformationGraphQLModels.GroupPurposesInformationModel.SuggestedPurposeModel;
import com.facebook.groups.treehouse.groupsstore.protocol.GroupsCommonDataModels.GroupCommonDataModel.AdminAwareGroupModel;
import com.facebook.groups.treehouse.mall.protocol.FetchTreehouseGroupInfoParsers.FetchTreehouseGroupInfoParser;
import com.facebook.groups.treehouse.mall.protocol.FetchTreehouseGroupInfoParsers.FetchTreehouseGroupInfoParser.GroupPendingMembersParser;
import com.facebook.groups.treehouse.mall.protocol.FetchTreehouseGroupInfoParsers.FetchTreehouseGroupInfoParser.GroupPendingStoriesParser;
import com.facebook.groups.widget.membersbar.protocol.MembersBarDataModels.MembersBarDataModel;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.nio.ByteBuffer;
import javax.annotation.Nullable;

/* compiled from: profile_intro_card_event */
public class FetchTreehouseGroupInfoModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -17829733)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: profile_intro_card_event */
    public final class FetchTreehouseGroupInfoModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel, GroupSellInformation, GroupPinnedPost, GroupViewerInviteInformation, GroupViewerStatus, GroupPurposesInformation {
        @Nullable
        private AdminAwareGroupModel f5900d;
        private boolean f5901e;
        @Nullable
        private MembersBarDataModel f5902f;
        @Nullable
        private GroupPendingMembersModel f5903g;
        @Nullable
        private GroupPendingStoriesModel f5904h;
        @Nullable
        private GroupPinnedStoriesModel f5905i;
        @Nullable
        private GroupPurposesModel f5906j;
        @Nullable
        private GroupSellConfigModel f5907k;
        @Nullable
        private String f5908l;
        private boolean f5909m;
        @Nullable
        private GraphQLSubscribeStatus f5910n;
        @Nullable
        private SuggestedPurposeModel f5911o;
        @Nullable
        private GraphQLGroupAdminType f5912p;
        @Nullable
        private ViewerInviteToGroupModel f5913q;
        @Nullable
        private GraphQLGroupJoinState f5914r;
        @Nullable
        private GraphQLGroupPostStatus f5915s;

        /* compiled from: profile_intro_card_event */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(FetchTreehouseGroupInfoModel.class, new Deserializer());
            }

            public Object m7504a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(FetchTreehouseGroupInfoParser.m7542a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object fetchTreehouseGroupInfoModel = new FetchTreehouseGroupInfoModel();
                ((BaseModel) fetchTreehouseGroupInfoModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (fetchTreehouseGroupInfoModel instanceof Postprocessable) {
                    return ((Postprocessable) fetchTreehouseGroupInfoModel).a();
                }
                return fetchTreehouseGroupInfoModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -1723990064)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: profile_intro_card_event */
        public final class GroupPendingMembersModel extends BaseModel implements GraphQLVisitableModel {
            private int f5898d;

            /* compiled from: profile_intro_card_event */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(GroupPendingMembersModel.class, new Deserializer());
                }

                public Object m7505a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(GroupPendingMembersParser.m7538a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object groupPendingMembersModel = new GroupPendingMembersModel();
                    ((BaseModel) groupPendingMembersModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (groupPendingMembersModel instanceof Postprocessable) {
                        return ((Postprocessable) groupPendingMembersModel).a();
                    }
                    return groupPendingMembersModel;
                }
            }

            /* compiled from: profile_intro_card_event */
            public class Serializer extends JsonSerializer<GroupPendingMembersModel> {
                public final void m7506a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    GroupPendingMembersModel groupPendingMembersModel = (GroupPendingMembersModel) obj;
                    if (groupPendingMembersModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(groupPendingMembersModel.m7507a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        groupPendingMembersModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    GroupPendingMembersParser.m7539a(groupPendingMembersModel.w_(), groupPendingMembersModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(GroupPendingMembersModel.class, new Serializer());
                }
            }

            public GroupPendingMembersModel() {
                super(1);
            }

            public final int jK_() {
                return 494751103;
            }

            public final GraphQLVisitableModel m7508a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m7507a(FlatBufferBuilder flatBufferBuilder) {
                h();
                flatBufferBuilder.c(1);
                flatBufferBuilder.a(0, this.f5898d, 0);
                i();
                return flatBufferBuilder.d();
            }

            public final void m7509a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                super.a(mutableFlatBuffer, i, obj);
                this.f5898d = mutableFlatBuffer.a(i, 0, 0);
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -1723990064)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: profile_intro_card_event */
        public final class GroupPendingStoriesModel extends BaseModel implements GraphQLVisitableModel {
            private int f5899d;

            /* compiled from: profile_intro_card_event */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(GroupPendingStoriesModel.class, new Deserializer());
                }

                public Object m7510a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(GroupPendingStoriesParser.m7540a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object groupPendingStoriesModel = new GroupPendingStoriesModel();
                    ((BaseModel) groupPendingStoriesModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (groupPendingStoriesModel instanceof Postprocessable) {
                        return ((Postprocessable) groupPendingStoriesModel).a();
                    }
                    return groupPendingStoriesModel;
                }
            }

            /* compiled from: profile_intro_card_event */
            public class Serializer extends JsonSerializer<GroupPendingStoriesModel> {
                public final void m7511a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    GroupPendingStoriesModel groupPendingStoriesModel = (GroupPendingStoriesModel) obj;
                    if (groupPendingStoriesModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(groupPendingStoriesModel.m7512a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        groupPendingStoriesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    GroupPendingStoriesParser.m7541a(groupPendingStoriesModel.w_(), groupPendingStoriesModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(GroupPendingStoriesModel.class, new Serializer());
                }
            }

            public GroupPendingStoriesModel() {
                super(1);
            }

            public final int jK_() {
                return 1621009465;
            }

            public final GraphQLVisitableModel m7513a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m7512a(FlatBufferBuilder flatBufferBuilder) {
                h();
                flatBufferBuilder.c(1);
                flatBufferBuilder.a(0, this.f5899d, 0);
                i();
                return flatBufferBuilder.d();
            }

            public final void m7514a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                super.a(mutableFlatBuffer, i, obj);
                this.f5899d = mutableFlatBuffer.a(i, 0, 0);
            }
        }

        /* compiled from: profile_intro_card_event */
        public class Serializer extends JsonSerializer<FetchTreehouseGroupInfoModel> {
            public final void m7515a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                FetchTreehouseGroupInfoModel fetchTreehouseGroupInfoModel = (FetchTreehouseGroupInfoModel) obj;
                if (fetchTreehouseGroupInfoModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(fetchTreehouseGroupInfoModel.m7530a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    fetchTreehouseGroupInfoModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                FetchTreehouseGroupInfoParser.m7543a(fetchTreehouseGroupInfoModel.w_(), fetchTreehouseGroupInfoModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(FetchTreehouseGroupInfoModel.class, new Serializer());
            }
        }

        public FetchTreehouseGroupInfoModel() {
            super(16);
        }

        public final void m7534a(String str, ConsistencyTuple consistencyTuple) {
            if ("subscribe_status".equals(str)) {
                consistencyTuple.a = m7526t();
                consistencyTuple.b = u_();
                consistencyTuple.c = 10;
            } else if ("viewer_join_state".equals(str)) {
                consistencyTuple.a = mo288p();
                consistencyTuple.b = u_();
                consistencyTuple.c = 14;
            } else {
                consistencyTuple.a();
            }
        }

        public final void m7535a(String str, Object obj, boolean z) {
            if ("subscribe_status".equals(str)) {
                m7517a((GraphQLSubscribeStatus) obj);
            } else if ("viewer_join_state".equals(str)) {
                m7516a((GraphQLGroupJoinState) obj);
            }
        }

        @Nullable
        private AdminAwareGroupModel m7518j() {
            this.f5900d = (AdminAwareGroupModel) super.a(this.f5900d, 0, AdminAwareGroupModel.class);
            return this.f5900d;
        }

        @Nullable
        private MembersBarDataModel m7519k() {
            this.f5902f = (MembersBarDataModel) super.a(this.f5902f, 2, MembersBarDataModel.class);
            return this.f5902f;
        }

        @Nullable
        private GroupPendingMembersModel m7520l() {
            this.f5903g = (GroupPendingMembersModel) super.a(this.f5903g, 3, GroupPendingMembersModel.class);
            return this.f5903g;
        }

        @Nullable
        private GroupPendingStoriesModel m7521m() {
            this.f5904h = (GroupPendingStoriesModel) super.a(this.f5904h, 4, GroupPendingStoriesModel.class);
            return this.f5904h;
        }

        @Nullable
        private GroupPinnedStoriesModel m7522o() {
            this.f5905i = (GroupPinnedStoriesModel) super.a(this.f5905i, 5, GroupPinnedStoriesModel.class);
            return this.f5905i;
        }

        @Nullable
        private GroupPurposesModel m7523q() {
            this.f5906j = (GroupPurposesModel) super.a(this.f5906j, 6, GroupPurposesModel.class);
            return this.f5906j;
        }

        @Nullable
        private GroupSellConfigModel m7524r() {
            this.f5907k = (GroupSellConfigModel) super.a(this.f5907k, 7, GroupSellConfigModel.class);
            return this.f5907k;
        }

        @Nullable
        private String m7525s() {
            this.f5908l = super.a(this.f5908l, 8);
            return this.f5908l;
        }

        @Nullable
        private GraphQLSubscribeStatus m7526t() {
            this.f5910n = (GraphQLSubscribeStatus) super.b(this.f5910n, 10, GraphQLSubscribeStatus.class, GraphQLSubscribeStatus.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
            return this.f5910n;
        }

        private void m7517a(GraphQLSubscribeStatus graphQLSubscribeStatus) {
            this.f5910n = graphQLSubscribeStatus;
            if (this.b != null && this.b.d) {
                this.b.a(this.c, 10, graphQLSubscribeStatus != null ? graphQLSubscribeStatus.name() : null);
            }
        }

        @Nullable
        private SuggestedPurposeModel m7527u() {
            this.f5911o = (SuggestedPurposeModel) super.a(this.f5911o, 11, SuggestedPurposeModel.class);
            return this.f5911o;
        }

        @Nullable
        public final GraphQLGroupAdminType mo287n() {
            this.f5912p = (GraphQLGroupAdminType) super.b(this.f5912p, 12, GraphQLGroupAdminType.class, GraphQLGroupAdminType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
            return this.f5912p;
        }

        @Nullable
        private ViewerInviteToGroupModel m7528v() {
            this.f5913q = (ViewerInviteToGroupModel) super.a(this.f5913q, 13, ViewerInviteToGroupModel.class);
            return this.f5913q;
        }

        @Nullable
        public final GraphQLGroupJoinState mo288p() {
            this.f5914r = (GraphQLGroupJoinState) super.b(this.f5914r, 14, GraphQLGroupJoinState.class, GraphQLGroupJoinState.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
            return this.f5914r;
        }

        private void m7516a(GraphQLGroupJoinState graphQLGroupJoinState) {
            this.f5914r = graphQLGroupJoinState;
            if (this.b != null && this.b.d) {
                this.b.a(this.c, 14, graphQLGroupJoinState != null ? graphQLGroupJoinState.name() : null);
            }
        }

        @Nullable
        private GraphQLGroupPostStatus m7529w() {
            this.f5915s = (GraphQLGroupPostStatus) super.b(this.f5915s, 15, GraphQLGroupPostStatus.class, GraphQLGroupPostStatus.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
            return this.f5915s;
        }

        @Nullable
        public final String m7532a() {
            return m7525s();
        }

        public final int jK_() {
            return 69076575;
        }

        public final GraphQLVisitableModel m7531a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m7518j() != null) {
                AdminAwareGroupModel adminAwareGroupModel = (AdminAwareGroupModel) graphQLModelMutatingVisitor.b(m7518j());
                if (m7518j() != adminAwareGroupModel) {
                    graphQLVisitableModel = (FetchTreehouseGroupInfoModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f5900d = adminAwareGroupModel;
                }
            }
            if (m7519k() != null) {
                MembersBarDataModel membersBarDataModel = (MembersBarDataModel) graphQLModelMutatingVisitor.b(m7519k());
                if (m7519k() != membersBarDataModel) {
                    graphQLVisitableModel = (FetchTreehouseGroupInfoModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f5902f = membersBarDataModel;
                }
            }
            if (m7520l() != null) {
                GroupPendingMembersModel groupPendingMembersModel = (GroupPendingMembersModel) graphQLModelMutatingVisitor.b(m7520l());
                if (m7520l() != groupPendingMembersModel) {
                    graphQLVisitableModel = (FetchTreehouseGroupInfoModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f5903g = groupPendingMembersModel;
                }
            }
            if (m7521m() != null) {
                GroupPendingStoriesModel groupPendingStoriesModel = (GroupPendingStoriesModel) graphQLModelMutatingVisitor.b(m7521m());
                if (m7521m() != groupPendingStoriesModel) {
                    graphQLVisitableModel = (FetchTreehouseGroupInfoModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f5904h = groupPendingStoriesModel;
                }
            }
            if (m7522o() != null) {
                GroupPinnedStoriesModel groupPinnedStoriesModel = (GroupPinnedStoriesModel) graphQLModelMutatingVisitor.b(m7522o());
                if (m7522o() != groupPinnedStoriesModel) {
                    graphQLVisitableModel = (FetchTreehouseGroupInfoModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f5905i = groupPinnedStoriesModel;
                }
            }
            if (m7523q() != null) {
                GroupPurposesModel groupPurposesModel = (GroupPurposesModel) graphQLModelMutatingVisitor.b(m7523q());
                if (m7523q() != groupPurposesModel) {
                    graphQLVisitableModel = (FetchTreehouseGroupInfoModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f5906j = groupPurposesModel;
                }
            }
            if (m7524r() != null) {
                GroupSellConfigModel groupSellConfigModel = (GroupSellConfigModel) graphQLModelMutatingVisitor.b(m7524r());
                if (m7524r() != groupSellConfigModel) {
                    graphQLVisitableModel = (FetchTreehouseGroupInfoModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f5907k = groupSellConfigModel;
                }
            }
            if (m7527u() != null) {
                SuggestedPurposeModel suggestedPurposeModel = (SuggestedPurposeModel) graphQLModelMutatingVisitor.b(m7527u());
                if (m7527u() != suggestedPurposeModel) {
                    graphQLVisitableModel = (FetchTreehouseGroupInfoModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f5911o = suggestedPurposeModel;
                }
            }
            if (m7528v() != null) {
                ViewerInviteToGroupModel viewerInviteToGroupModel = (ViewerInviteToGroupModel) graphQLModelMutatingVisitor.b(m7528v());
                if (m7528v() != viewerInviteToGroupModel) {
                    graphQLVisitableModel = (FetchTreehouseGroupInfoModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f5913q = viewerInviteToGroupModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m7530a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m7518j());
            int a2 = ModelHelper.a(flatBufferBuilder, m7519k());
            int a3 = ModelHelper.a(flatBufferBuilder, m7520l());
            int a4 = ModelHelper.a(flatBufferBuilder, m7521m());
            int a5 = ModelHelper.a(flatBufferBuilder, m7522o());
            int a6 = ModelHelper.a(flatBufferBuilder, m7523q());
            int a7 = ModelHelper.a(flatBufferBuilder, m7524r());
            int b = flatBufferBuilder.b(m7525s());
            int a8 = flatBufferBuilder.a(m7526t());
            int a9 = ModelHelper.a(flatBufferBuilder, m7527u());
            int a10 = flatBufferBuilder.a(mo287n());
            int a11 = ModelHelper.a(flatBufferBuilder, m7528v());
            int a12 = flatBufferBuilder.a(mo288p());
            int a13 = flatBufferBuilder.a(m7529w());
            flatBufferBuilder.c(16);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.a(1, this.f5901e);
            flatBufferBuilder.b(2, a2);
            flatBufferBuilder.b(3, a3);
            flatBufferBuilder.b(4, a4);
            flatBufferBuilder.b(5, a5);
            flatBufferBuilder.b(6, a6);
            flatBufferBuilder.b(7, a7);
            flatBufferBuilder.b(8, b);
            flatBufferBuilder.a(9, this.f5909m);
            flatBufferBuilder.b(10, a8);
            flatBufferBuilder.b(11, a9);
            flatBufferBuilder.b(12, a10);
            flatBufferBuilder.b(13, a11);
            flatBufferBuilder.b(14, a12);
            flatBufferBuilder.b(15, a13);
            i();
            return flatBufferBuilder.d();
        }

        public final void m7533a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
            super.a(mutableFlatBuffer, i, obj);
            this.f5901e = mutableFlatBuffer.a(i, 1);
            this.f5909m = mutableFlatBuffer.a(i, 9);
        }
    }
}
