package com.facebook.feed.util.story;

import com.facebook.feed.util.story.FeedStoryUtilGraphQLModels$ShouldDisplayProfilePictureGraphQLModel.ActorsModel.ProfileBadgeModel;
import com.facebook.feed.util.story.FeedStoryUtilGraphQLModels$ShouldDisplayProfilePictureGraphQLModel.AllSubstoriesModel;
import com.facebook.feed.util.story.FeedStoryUtilGraphQLModels$ShouldDisplayProfilePictureGraphQLModel.AttachedStoryModel;
import com.facebook.feed.util.story.FeedStoryUtilGraphQLModels$ShouldDisplayProfilePictureGraphQLModel.Deserializer;
import com.facebook.feed.util.story.FeedStoryUtilGraphQLModels$ShouldDisplayProfilePictureGraphQLModel.MessageModel;
import com.facebook.feed.util.story.FeedStoryUtilGraphQLModels$ShouldDisplayProfilePictureGraphQLModel.Serializer;
import com.facebook.feed.util.story.FeedStoryUtilGraphQLModels.IsPopularObjectsStoryGraphQLModel.AttachmentsModel;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.FragmentModelWithoutBridge;
import com.facebook.flatbuffers.ModelWithFlatBufferFormatHash;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.enums.GraphQLObjectType;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.ModelHelper;
import com.facebook.graphql.story.util.C0843x6e0cef4c;
import com.facebook.graphql.story.util.GraphQLStoryUtilGraphQLInterfaces$ShouldDisplaySubStoryGalleryGraphQL.AllSubstories;
import com.facebook.graphql.visitor.ConsistencyTuple;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLPersistableNode;
import com.facebook.graphql.visitor.GraphQLVisitableConsistentModel;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import java.util.List;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

@JsonDeserialize(using = Deserializer.class)
@ModelWithFlatBufferFormatHash(a = -1011625013)
@JsonSerialize(using = Serializer.class)
@FragmentModelWithoutBridge
/* compiled from: group_feed */
public final class C0870xa5832e5a extends BaseModel implements FeedStoryUtilGraphQLInterfaces$IsPopularObjectsStoryGraphQL, C0843x6e0cef4c, GraphQLVisitableConsistentModel {
    @Nullable
    private List<ActorsModel> f21839d;
    @Nullable
    private AllSubstoriesModel f21840e;
    @Nullable
    private AttachedStoryModel f21841f;
    @Nullable
    private List<AttachmentsModel> f21842g;
    @Nullable
    private FeedbackModel f21843h;
    private boolean f21844i;
    @Nullable
    private MessageModel f21845j;

    @JsonDeserialize(using = ActorsModel.Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 1020368809)
    @JsonSerialize(using = ActorsModel.Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: group_feed */
    public final class ActorsModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
        @Nullable
        private GraphQLObjectType f21846d;
        @Nullable
        private String f21847e;
        @Nullable
        private ProfileBadgeModel f21848f;
        @Nullable
        private ProfilePictureModel f21849g;

        @JsonDeserialize(using = ProfilePictureModel.Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 842551240)
        @JsonSerialize(using = ProfilePictureModel.Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: group_feed */
        public final class ProfilePictureModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private String f21850d;

            public ProfilePictureModel() {
                super(1);
            }

            @Nullable
            private String m29623a() {
                this.f21850d = super.m9948a(this.f21850d, 0);
                return this.f21850d;
            }

            public final int jK_() {
                return 70760763;
            }

            public final GraphQLVisitableModel mo1404a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                m9958h();
                m9959i();
                return this;
            }

            public final int mo1403a(FlatBufferBuilder flatBufferBuilder) {
                m9958h();
                int b = flatBufferBuilder.m21502b(m29623a());
                flatBufferBuilder.m21510c(1);
                flatBufferBuilder.m21507b(0, b);
                m9959i();
                return flatBufferBuilder.m21511d();
            }
        }

        @Nullable
        public final /* synthetic */ ProfilePictureModel m29622b() {
            return m29616m();
        }

        public ActorsModel() {
            super(4);
        }

        public final void mo2835a(String str, ConsistencyTuple consistencyTuple) {
            consistencyTuple.m26322a();
        }

        public final void mo2836a(String str, Object obj, boolean z) {
        }

        @Nullable
        private GraphQLObjectType m29613j() {
            if (this.f5823b != null && this.f21846d == null) {
                this.f21846d = (GraphQLObjectType) this.f5823b.m21551d(this.f5824c, 0, GraphQLObjectType.class);
            }
            return this.f21846d;
        }

        @Nullable
        private String m29614k() {
            this.f21847e = super.m9948a(this.f21847e, 1);
            return this.f21847e;
        }

        @Nullable
        private ProfileBadgeModel m29615l() {
            this.f21848f = (ProfileBadgeModel) super.m9947a(this.f21848f, 2, ProfileBadgeModel.class);
            return this.f21848f;
        }

        @Nullable
        private ProfilePictureModel m29616m() {
            this.f21849g = (ProfilePictureModel) super.m9947a(this.f21849g, 3, ProfilePictureModel.class);
            return this.f21849g;
        }

        @Nullable
        public final String mo2834a() {
            return m29614k();
        }

        public final int jK_() {
            return 63093205;
        }

        public final GraphQLVisitableModel mo1404a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            m9958h();
            if (m29615l() != null) {
                ProfileBadgeModel profileBadgeModel = (ProfileBadgeModel) graphQLModelMutatingVisitor.mo2928b(m29615l());
                if (m29615l() != profileBadgeModel) {
                    graphQLVisitableModel = (ActorsModel) ModelHelper.m23095a(null, (GraphQLVisitableModel) this);
                    graphQLVisitableModel.f21848f = profileBadgeModel;
                }
            }
            if (m29616m() != null) {
                ProfilePictureModel profilePictureModel = (ProfilePictureModel) graphQLModelMutatingVisitor.mo2928b(m29616m());
                if (m29616m() != profilePictureModel) {
                    graphQLVisitableModel = (ActorsModel) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                    graphQLVisitableModel.f21849g = profilePictureModel;
                }
            }
            m9959i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int mo1403a(FlatBufferBuilder flatBufferBuilder) {
            m9958h();
            int a = ModelHelper.m23093a(flatBufferBuilder, m29613j());
            int b = flatBufferBuilder.m21502b(m29614k());
            int a2 = ModelHelper.m23093a(flatBufferBuilder, m29615l());
            int a3 = ModelHelper.m23093a(flatBufferBuilder, m29616m());
            flatBufferBuilder.m21510c(4);
            flatBufferBuilder.m21507b(0, a);
            flatBufferBuilder.m21507b(1, b);
            flatBufferBuilder.m21507b(2, a2);
            flatBufferBuilder.m21507b(3, a3);
            m9959i();
            return flatBufferBuilder.m21511d();
        }
    }

    @JsonDeserialize(using = FeedbackModel.Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 1801334754)
    @JsonSerialize(using = FeedbackModel.Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: group_feed */
    public final class FeedbackModel extends BaseModel implements GraphQLVisitableConsistentModel {
        @Nullable
        private String f21851d;

        public FeedbackModel() {
            super(1);
        }

        public final void mo2835a(String str, ConsistencyTuple consistencyTuple) {
            consistencyTuple.m26322a();
        }

        public final void mo2836a(String str, Object obj, boolean z) {
        }

        @Nullable
        private String m29626a() {
            this.f21851d = super.m9948a(this.f21851d, 0);
            return this.f21851d;
        }

        public final int jK_() {
            return -126857307;
        }

        public final GraphQLVisitableModel mo1404a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            m9958h();
            m9959i();
            return this;
        }

        public final int mo1403a(FlatBufferBuilder flatBufferBuilder) {
            m9958h();
            int b = flatBufferBuilder.m21502b(m29626a());
            flatBufferBuilder.m21510c(1);
            flatBufferBuilder.m21507b(0, b);
            m9959i();
            return flatBufferBuilder.m21511d();
        }
    }

    @Nullable
    public final /* synthetic */ AllSubstories mo3153b() {
        return m29598j();
    }

    @Nullable
    public final /* synthetic */ AttachedStoryModel m29611g() {
        return m29599k();
    }

    @Nullable
    public final /* synthetic */ MessageModel iA_() {
        return m29601m();
    }

    @Nullable
    public final /* synthetic */ FeedbackModel iB_() {
        return m29600l();
    }

    @Nullable
    public final /* synthetic */ AllSubstoriesModel iC_() {
        return m29598j();
    }

    public C0870xa5832e5a() {
        super(7);
    }

    public C0870xa5832e5a(MutableFlatBuffer mutableFlatBuffer) {
        super(7);
        mo1412a(mutableFlatBuffer, FlatBuffer.m4026a(mutableFlatBuffer.f15021a));
    }

    public final void mo2835a(String str, ConsistencyTuple consistencyTuple) {
        consistencyTuple.m26322a();
    }

    public final void mo2836a(String str, Object obj, boolean z) {
    }

    @Nonnull
    public final ImmutableList<ActorsModel> mo3152a() {
        this.f21839d = super.m9944a(this.f21839d, 0, ActorsModel.class);
        return (ImmutableList) this.f21839d;
    }

    @Nullable
    private AllSubstoriesModel m29598j() {
        this.f21840e = (AllSubstoriesModel) super.m9947a(this.f21840e, 1, AllSubstoriesModel.class);
        return this.f21840e;
    }

    @Nullable
    private AttachedStoryModel m29599k() {
        this.f21841f = (AttachedStoryModel) super.m9947a(this.f21841f, 2, AttachedStoryModel.class);
        return this.f21841f;
    }

    @Nonnull
    public final ImmutableList<AttachmentsModel> mo3206d() {
        this.f21842g = super.m9944a(this.f21842g, 3, AttachmentsModel.class);
        return (ImmutableList) this.f21842g;
    }

    @Nullable
    private FeedbackModel m29600l() {
        this.f21843h = (FeedbackModel) super.m9947a(this.f21843h, 4, FeedbackModel.class);
        return this.f21843h;
    }

    public final boolean mo3154c() {
        m9949a(0, 5);
        return this.f21844i;
    }

    @Nullable
    private MessageModel m29601m() {
        this.f21845j = (MessageModel) super.m9947a(this.f21845j, 6, MessageModel.class);
        return this.f21845j;
    }

    public final int jK_() {
        return 80218325;
    }

    public final GraphQLVisitableModel mo1404a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        C0870xa5832e5a c0870xa5832e5a;
        GraphQLVisitableModel graphQLVisitableModel;
        AllSubstoriesModel allSubstoriesModel;
        AttachedStoryModel attachedStoryModel;
        Builder a;
        FeedbackModel feedbackModel;
        MessageModel messageModel;
        m9958h();
        if (mo3152a() != null) {
            Builder a2 = ModelHelper.m23097a(mo3152a(), graphQLModelMutatingVisitor);
            if (a2 != null) {
                c0870xa5832e5a = (C0870xa5832e5a) ModelHelper.m23095a(null, (GraphQLVisitableModel) this);
                c0870xa5832e5a.f21839d = a2.m1068b();
                graphQLVisitableModel = c0870xa5832e5a;
                if (m29598j() != null) {
                    allSubstoriesModel = (AllSubstoriesModel) graphQLModelMutatingVisitor.mo2928b(m29598j());
                    if (m29598j() != allSubstoriesModel) {
                        graphQLVisitableModel = (C0870xa5832e5a) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                        graphQLVisitableModel.f21840e = allSubstoriesModel;
                    }
                }
                if (m29599k() != null) {
                    attachedStoryModel = (AttachedStoryModel) graphQLModelMutatingVisitor.mo2928b(m29599k());
                    if (m29599k() != attachedStoryModel) {
                        graphQLVisitableModel = (C0870xa5832e5a) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                        graphQLVisitableModel.f21841f = attachedStoryModel;
                    }
                }
                if (mo3206d() != null) {
                    a = ModelHelper.m23097a(mo3206d(), graphQLModelMutatingVisitor);
                    if (a != null) {
                        c0870xa5832e5a = (C0870xa5832e5a) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                        c0870xa5832e5a.f21842g = a.m1068b();
                        graphQLVisitableModel = c0870xa5832e5a;
                    }
                }
                if (m29600l() != null) {
                    feedbackModel = (FeedbackModel) graphQLModelMutatingVisitor.mo2928b(m29600l());
                    if (m29600l() != feedbackModel) {
                        graphQLVisitableModel = (C0870xa5832e5a) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                        graphQLVisitableModel.f21843h = feedbackModel;
                    }
                }
                if (m29601m() != null) {
                    messageModel = (MessageModel) graphQLModelMutatingVisitor.mo2928b(m29601m());
                    if (m29601m() != messageModel) {
                        graphQLVisitableModel = (C0870xa5832e5a) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                        graphQLVisitableModel.f21845j = messageModel;
                    }
                }
                m9959i();
                return graphQLVisitableModel != null ? this : graphQLVisitableModel;
            }
        }
        graphQLVisitableModel = null;
        if (m29598j() != null) {
            allSubstoriesModel = (AllSubstoriesModel) graphQLModelMutatingVisitor.mo2928b(m29598j());
            if (m29598j() != allSubstoriesModel) {
                graphQLVisitableModel = (C0870xa5832e5a) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f21840e = allSubstoriesModel;
            }
        }
        if (m29599k() != null) {
            attachedStoryModel = (AttachedStoryModel) graphQLModelMutatingVisitor.mo2928b(m29599k());
            if (m29599k() != attachedStoryModel) {
                graphQLVisitableModel = (C0870xa5832e5a) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f21841f = attachedStoryModel;
            }
        }
        if (mo3206d() != null) {
            a = ModelHelper.m23097a(mo3206d(), graphQLModelMutatingVisitor);
            if (a != null) {
                c0870xa5832e5a = (C0870xa5832e5a) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                c0870xa5832e5a.f21842g = a.m1068b();
                graphQLVisitableModel = c0870xa5832e5a;
            }
        }
        if (m29600l() != null) {
            feedbackModel = (FeedbackModel) graphQLModelMutatingVisitor.mo2928b(m29600l());
            if (m29600l() != feedbackModel) {
                graphQLVisitableModel = (C0870xa5832e5a) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f21843h = feedbackModel;
            }
        }
        if (m29601m() != null) {
            messageModel = (MessageModel) graphQLModelMutatingVisitor.mo2928b(m29601m());
            if (m29601m() != messageModel) {
                graphQLVisitableModel = (C0870xa5832e5a) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f21845j = messageModel;
            }
        }
        m9959i();
        if (graphQLVisitableModel != null) {
        }
    }

    public final int mo1403a(FlatBufferBuilder flatBufferBuilder) {
        m9958h();
        int a = ModelHelper.m23094a(flatBufferBuilder, mo3152a());
        int a2 = ModelHelper.m23093a(flatBufferBuilder, m29598j());
        int a3 = ModelHelper.m23093a(flatBufferBuilder, m29599k());
        int a4 = ModelHelper.m23094a(flatBufferBuilder, mo3206d());
        int a5 = ModelHelper.m23093a(flatBufferBuilder, m29600l());
        int a6 = ModelHelper.m23093a(flatBufferBuilder, m29601m());
        flatBufferBuilder.m21510c(7);
        flatBufferBuilder.m21507b(0, a);
        flatBufferBuilder.m21507b(1, a2);
        flatBufferBuilder.m21507b(2, a3);
        flatBufferBuilder.m21507b(3, a4);
        flatBufferBuilder.m21507b(4, a5);
        flatBufferBuilder.m21498a(5, this.f21844i);
        flatBufferBuilder.m21507b(6, a6);
        m9959i();
        return flatBufferBuilder.m21511d();
    }

    public final void mo1406a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
        super.mo1406a(mutableFlatBuffer, i, obj);
        this.f21844i = mutableFlatBuffer.m21540a(i, 5);
    }
}
