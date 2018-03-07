package com.facebook.notifications.protocol;

import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.FragmentModelWithBridge;
import com.facebook.flatbuffers.ModelWithFlatBufferFormatHash;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.enums.GraphQLNotifHighlightState;
import com.facebook.graphql.enums.GraphQLNotifImportanceType;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.ModelHelper;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.facebook.notifications.protocol.FetchNotificationsGraphQLModels.NotificationHighlightOperationFragmentModel;
import com.facebook.notifications.protocol.FetchNotificationsGraphQLModels.NotificationOptionRowModel;
import com.facebook.reaction.protocol.graphql.FetchReactionGraphQLInterfaces.ReactionUnitFragment;
import com.facebook.reaction.protocol.graphql.FetchReactionGraphQLModels.ReactionUnitFragmentModel;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import java.util.List;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

@FragmentModelWithBridge
@JsonDeserialize(using = Deserializer.class)
@ModelWithFlatBufferFormatHash(a = 1649572764)
@JsonSerialize(using = Serializer.class)
/* compiled from: importance_reason_text */
public final class FetchNotificationsGraphQLModels$NotificationsEdgeFieldsModel extends BaseModel implements GraphQLVisitableModel, FetchNotificationsGraphQLInterfaces$NotificationsEdgeFields {
    @Nullable
    private String f10812d;
    @Nullable
    private List<NotificationHighlightOperationFragmentModel> f10813e;
    @Nullable
    private GraphQLNotifHighlightState f10814f;
    @Nullable
    private ImportanceReasonTextModel f10815g;
    private int f10816h;
    @Nullable
    private GraphQLNotifImportanceType f10817i;
    private boolean f10818j;
    private int f10819k;
    private int f10820l;
    @Nullable
    private GraphQLStory f10821m;
    @Nullable
    private List<NotificationOptionRowModel> f10822n;
    @Nullable
    private NotifOptionSetsModel f10823o;
    @Nullable
    private ReactionUnitFragmentModel f10824p;

    @Nullable
    public final /* synthetic */ ImportanceReasonTextModel mo816d() {
        return m11262o();
    }

    @Nullable
    public final /* synthetic */ NotifOptionSetsModel mo824m() {
        return m11263p();
    }

    @Nullable
    public final /* synthetic */ ReactionUnitFragment mo825n() {
        return m11264q();
    }

    public FetchNotificationsGraphQLModels$NotificationsEdgeFieldsModel() {
        super(13);
    }

    public FetchNotificationsGraphQLModels$NotificationsEdgeFieldsModel(MutableFlatBuffer mutableFlatBuffer) {
        super(13);
        a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
    }

    @Nullable
    public final String mo813a() {
        this.f10812d = super.a(this.f10812d, 0);
        return this.f10812d;
    }

    @Nonnull
    public final ImmutableList<NotificationHighlightOperationFragmentModel> mo814b() {
        this.f10813e = super.a(this.f10813e, 1, NotificationHighlightOperationFragmentModel.class);
        return (ImmutableList) this.f10813e;
    }

    @Nullable
    public final GraphQLNotifHighlightState mo815c() {
        this.f10814f = (GraphQLNotifHighlightState) super.b(this.f10814f, 2, GraphQLNotifHighlightState.class, GraphQLNotifHighlightState.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
        return this.f10814f;
    }

    @Nullable
    public final ImportanceReasonTextModel m11262o() {
        this.f10815g = (ImportanceReasonTextModel) super.a(this.f10815g, 3, ImportanceReasonTextModel.class);
        return this.f10815g;
    }

    public final int gr_() {
        a(0, 4);
        return this.f10816h;
    }

    @Nullable
    public final GraphQLNotifImportanceType mo817g() {
        this.f10817i = (GraphQLNotifImportanceType) super.b(this.f10817i, 5, GraphQLNotifImportanceType.class, GraphQLNotifImportanceType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
        return this.f10817i;
    }

    public final boolean gs_() {
        a(0, 6);
        return this.f10818j;
    }

    public final int gt_() {
        a(0, 7);
        return this.f10819k;
    }

    public final int mo821j() {
        a(1, 0);
        return this.f10820l;
    }

    @Nullable
    public final GraphQLStory mo822k() {
        this.f10821m = (GraphQLStory) super.a(this.f10821m, 9, GraphQLStory.class);
        return this.f10821m;
    }

    @Nonnull
    public final ImmutableList<NotificationOptionRowModel> mo823l() {
        this.f10822n = super.a(this.f10822n, 10, NotificationOptionRowModel.class);
        return (ImmutableList) this.f10822n;
    }

    @Nullable
    public final NotifOptionSetsModel m11263p() {
        this.f10823o = (NotifOptionSetsModel) super.a(this.f10823o, 11, NotifOptionSetsModel.class);
        return this.f10823o;
    }

    @Nullable
    public final ReactionUnitFragmentModel m11264q() {
        this.f10824p = (ReactionUnitFragmentModel) super.a(this.f10824p, 12, ReactionUnitFragmentModel.class);
        return this.f10824p;
    }

    public static FetchNotificationsGraphQLModels$NotificationsEdgeFieldsModel m11248a(FetchNotificationsGraphQLInterfaces$NotificationsEdgeFields fetchNotificationsGraphQLInterfaces$NotificationsEdgeFields) {
        int i = 0;
        if (fetchNotificationsGraphQLInterfaces$NotificationsEdgeFields == null) {
            return null;
        }
        if (fetchNotificationsGraphQLInterfaces$NotificationsEdgeFields instanceof FetchNotificationsGraphQLModels$NotificationsEdgeFieldsModel) {
            return (FetchNotificationsGraphQLModels$NotificationsEdgeFieldsModel) fetchNotificationsGraphQLInterfaces$NotificationsEdgeFields;
        }
        Builder builder = new Builder();
        builder.a = fetchNotificationsGraphQLInterfaces$NotificationsEdgeFields.mo813a();
        Builder builder2 = ImmutableList.builder();
        for (int i2 = 0; i2 < fetchNotificationsGraphQLInterfaces$NotificationsEdgeFields.mo814b().size(); i2++) {
            builder2.c(NotificationHighlightOperationFragmentModel.a((NotificationHighlightOperationFragmentModel) fetchNotificationsGraphQLInterfaces$NotificationsEdgeFields.mo814b().get(i2)));
        }
        builder.b = builder2.b();
        builder.c = fetchNotificationsGraphQLInterfaces$NotificationsEdgeFields.mo815c();
        builder.d = ImportanceReasonTextModel.a(fetchNotificationsGraphQLInterfaces$NotificationsEdgeFields.mo816d());
        builder.e = fetchNotificationsGraphQLInterfaces$NotificationsEdgeFields.gr_();
        builder.f = fetchNotificationsGraphQLInterfaces$NotificationsEdgeFields.mo817g();
        builder.g = fetchNotificationsGraphQLInterfaces$NotificationsEdgeFields.gs_();
        builder.h = fetchNotificationsGraphQLInterfaces$NotificationsEdgeFields.gt_();
        builder.i = fetchNotificationsGraphQLInterfaces$NotificationsEdgeFields.mo821j();
        builder.j = fetchNotificationsGraphQLInterfaces$NotificationsEdgeFields.mo822k();
        Builder builder3 = ImmutableList.builder();
        while (i < fetchNotificationsGraphQLInterfaces$NotificationsEdgeFields.mo823l().size()) {
            builder3.c(NotificationOptionRowModel.a((NotificationOptionRowModel) fetchNotificationsGraphQLInterfaces$NotificationsEdgeFields.mo823l().get(i)));
            i++;
        }
        builder.k = builder3.b();
        builder.l = NotifOptionSetsModel.a(fetchNotificationsGraphQLInterfaces$NotificationsEdgeFields.mo824m());
        builder.m = ReactionUnitFragmentModel.a(fetchNotificationsGraphQLInterfaces$NotificationsEdgeFields.mo825n());
        return builder.a();
    }

    public final int jK_() {
        return -560159067;
    }

    public final GraphQLVisitableModel m11250a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        FetchNotificationsGraphQLModels$NotificationsEdgeFieldsModel fetchNotificationsGraphQLModels$NotificationsEdgeFieldsModel;
        GraphQLVisitableModel graphQLVisitableModel;
        ImportanceReasonTextModel importanceReasonTextModel;
        GraphQLStory graphQLStory;
        Builder a;
        NotifOptionSetsModel notifOptionSetsModel;
        ReactionUnitFragmentModel reactionUnitFragmentModel;
        h();
        if (mo814b() != null) {
            Builder a2 = ModelHelper.a(mo814b(), graphQLModelMutatingVisitor);
            if (a2 != null) {
                fetchNotificationsGraphQLModels$NotificationsEdgeFieldsModel = (FetchNotificationsGraphQLModels$NotificationsEdgeFieldsModel) ModelHelper.a(null, this);
                fetchNotificationsGraphQLModels$NotificationsEdgeFieldsModel.f10813e = a2.b();
                graphQLVisitableModel = fetchNotificationsGraphQLModels$NotificationsEdgeFieldsModel;
                if (m11262o() != null) {
                    importanceReasonTextModel = (ImportanceReasonTextModel) graphQLModelMutatingVisitor.b(m11262o());
                    if (m11262o() != importanceReasonTextModel) {
                        graphQLVisitableModel = (FetchNotificationsGraphQLModels$NotificationsEdgeFieldsModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f10815g = importanceReasonTextModel;
                    }
                }
                if (mo822k() != null) {
                    graphQLStory = (GraphQLStory) graphQLModelMutatingVisitor.b(mo822k());
                    if (mo822k() != graphQLStory) {
                        graphQLVisitableModel = (FetchNotificationsGraphQLModels$NotificationsEdgeFieldsModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f10821m = graphQLStory;
                    }
                }
                if (mo823l() != null) {
                    a = ModelHelper.a(mo823l(), graphQLModelMutatingVisitor);
                    if (a != null) {
                        fetchNotificationsGraphQLModels$NotificationsEdgeFieldsModel = (FetchNotificationsGraphQLModels$NotificationsEdgeFieldsModel) ModelHelper.a(graphQLVisitableModel, this);
                        fetchNotificationsGraphQLModels$NotificationsEdgeFieldsModel.f10822n = a.b();
                        graphQLVisitableModel = fetchNotificationsGraphQLModels$NotificationsEdgeFieldsModel;
                    }
                }
                if (m11263p() != null) {
                    notifOptionSetsModel = (NotifOptionSetsModel) graphQLModelMutatingVisitor.b(m11263p());
                    if (m11263p() != notifOptionSetsModel) {
                        graphQLVisitableModel = (FetchNotificationsGraphQLModels$NotificationsEdgeFieldsModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f10823o = notifOptionSetsModel;
                    }
                }
                if (m11264q() != null) {
                    reactionUnitFragmentModel = (ReactionUnitFragmentModel) graphQLModelMutatingVisitor.b(m11264q());
                    if (m11264q() != reactionUnitFragmentModel) {
                        graphQLVisitableModel = (FetchNotificationsGraphQLModels$NotificationsEdgeFieldsModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f10824p = reactionUnitFragmentModel;
                    }
                }
                i();
                return graphQLVisitableModel != null ? this : graphQLVisitableModel;
            }
        }
        graphQLVisitableModel = null;
        if (m11262o() != null) {
            importanceReasonTextModel = (ImportanceReasonTextModel) graphQLModelMutatingVisitor.b(m11262o());
            if (m11262o() != importanceReasonTextModel) {
                graphQLVisitableModel = (FetchNotificationsGraphQLModels$NotificationsEdgeFieldsModel) ModelHelper.a(graphQLVisitableModel, this);
                graphQLVisitableModel.f10815g = importanceReasonTextModel;
            }
        }
        if (mo822k() != null) {
            graphQLStory = (GraphQLStory) graphQLModelMutatingVisitor.b(mo822k());
            if (mo822k() != graphQLStory) {
                graphQLVisitableModel = (FetchNotificationsGraphQLModels$NotificationsEdgeFieldsModel) ModelHelper.a(graphQLVisitableModel, this);
                graphQLVisitableModel.f10821m = graphQLStory;
            }
        }
        if (mo823l() != null) {
            a = ModelHelper.a(mo823l(), graphQLModelMutatingVisitor);
            if (a != null) {
                fetchNotificationsGraphQLModels$NotificationsEdgeFieldsModel = (FetchNotificationsGraphQLModels$NotificationsEdgeFieldsModel) ModelHelper.a(graphQLVisitableModel, this);
                fetchNotificationsGraphQLModels$NotificationsEdgeFieldsModel.f10822n = a.b();
                graphQLVisitableModel = fetchNotificationsGraphQLModels$NotificationsEdgeFieldsModel;
            }
        }
        if (m11263p() != null) {
            notifOptionSetsModel = (NotifOptionSetsModel) graphQLModelMutatingVisitor.b(m11263p());
            if (m11263p() != notifOptionSetsModel) {
                graphQLVisitableModel = (FetchNotificationsGraphQLModels$NotificationsEdgeFieldsModel) ModelHelper.a(graphQLVisitableModel, this);
                graphQLVisitableModel.f10823o = notifOptionSetsModel;
            }
        }
        if (m11264q() != null) {
            reactionUnitFragmentModel = (ReactionUnitFragmentModel) graphQLModelMutatingVisitor.b(m11264q());
            if (m11264q() != reactionUnitFragmentModel) {
                graphQLVisitableModel = (FetchNotificationsGraphQLModels$NotificationsEdgeFieldsModel) ModelHelper.a(graphQLVisitableModel, this);
                graphQLVisitableModel.f10824p = reactionUnitFragmentModel;
            }
        }
        i();
        if (graphQLVisitableModel != null) {
        }
    }

    public final int m11249a(FlatBufferBuilder flatBufferBuilder) {
        h();
        int b = flatBufferBuilder.b(mo813a());
        int a = ModelHelper.a(flatBufferBuilder, mo814b());
        int a2 = flatBufferBuilder.a(mo815c());
        int a3 = ModelHelper.a(flatBufferBuilder, m11262o());
        int a4 = flatBufferBuilder.a(mo817g());
        int a5 = ModelHelper.a(flatBufferBuilder, mo822k());
        int a6 = ModelHelper.a(flatBufferBuilder, mo823l());
        int a7 = ModelHelper.a(flatBufferBuilder, m11263p());
        int a8 = ModelHelper.a(flatBufferBuilder, m11264q());
        flatBufferBuilder.c(13);
        flatBufferBuilder.b(0, b);
        flatBufferBuilder.b(1, a);
        flatBufferBuilder.b(2, a2);
        flatBufferBuilder.b(3, a3);
        flatBufferBuilder.a(4, this.f10816h, 0);
        flatBufferBuilder.b(5, a4);
        flatBufferBuilder.a(6, this.f10818j);
        flatBufferBuilder.a(7, this.f10819k, 0);
        flatBufferBuilder.a(8, this.f10820l, 0);
        flatBufferBuilder.b(9, a5);
        flatBufferBuilder.b(10, a6);
        flatBufferBuilder.b(11, a7);
        flatBufferBuilder.b(12, a8);
        i();
        return flatBufferBuilder.d();
    }

    public final void m11252a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
        super.a(mutableFlatBuffer, i, obj);
        this.f10816h = mutableFlatBuffer.a(i, 4, 0);
        this.f10818j = mutableFlatBuffer.a(i, 6);
        this.f10819k = mutableFlatBuffer.a(i, 7, 0);
        this.f10820l = mutableFlatBuffer.a(i, 8, 0);
    }
}
