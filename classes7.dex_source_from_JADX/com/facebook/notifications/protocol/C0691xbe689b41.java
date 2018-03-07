package com.facebook.notifications.protocol;

import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.enums.GraphQLNotifHighlightState;
import com.facebook.graphql.enums.GraphQLNotifImportanceType;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.modelutil.ModelHelper;
import com.facebook.notifications.protocol.FetchNotificationsGraphQLModels.NotificationHighlightOperationFragmentModel;
import com.facebook.notifications.protocol.FetchNotificationsGraphQLModels.NotificationOptionRowModel;
import com.facebook.notifications.protocol.FetchNotificationsGraphQLModels.NotificationsEdgeFieldsModel;
import com.facebook.reaction.protocol.graphql.FetchReactionGraphQLModels.ReactionUnitFragmentModel;
import com.google.common.collect.ImmutableList;
import java.nio.ByteBuffer;
import javax.annotation.Nullable;

/* compiled from: negativeFeedbackActionOnReportableEntity */
public final class C0691xbe689b41 {
    @Nullable
    public String f8519a;
    @Nullable
    public ImmutableList<NotificationHighlightOperationFragmentModel> f8520b;
    @Nullable
    public GraphQLNotifHighlightState f8521c;
    @Nullable
    public C0693x680f492a f8522d;
    public int f8523e;
    @Nullable
    public GraphQLNotifImportanceType f8524f;
    public boolean f8525g;
    public int f8526h;
    public int f8527i;
    @Nullable
    public GraphQLStory f8528j;
    @Nullable
    public ImmutableList<NotificationOptionRowModel> f8529k;
    @Nullable
    public C0694xee63252d f8530l;
    @Nullable
    public ReactionUnitFragmentModel f8531m;

    public static C0691xbe689b41 m10191a(NotificationsEdgeFieldsModel notificationsEdgeFieldsModel) {
        C0691xbe689b41 c0691xbe689b41 = new C0691xbe689b41();
        c0691xbe689b41.f8519a = notificationsEdgeFieldsModel.a();
        c0691xbe689b41.f8520b = notificationsEdgeFieldsModel.b();
        c0691xbe689b41.f8521c = notificationsEdgeFieldsModel.c();
        c0691xbe689b41.f8522d = notificationsEdgeFieldsModel.o();
        c0691xbe689b41.f8523e = notificationsEdgeFieldsModel.gr_();
        c0691xbe689b41.f8524f = notificationsEdgeFieldsModel.g();
        c0691xbe689b41.f8525g = notificationsEdgeFieldsModel.gs_();
        c0691xbe689b41.f8526h = notificationsEdgeFieldsModel.gt_();
        c0691xbe689b41.f8527i = notificationsEdgeFieldsModel.j();
        c0691xbe689b41.f8528j = notificationsEdgeFieldsModel.k();
        c0691xbe689b41.f8529k = notificationsEdgeFieldsModel.l();
        c0691xbe689b41.f8530l = notificationsEdgeFieldsModel.p();
        c0691xbe689b41.f8531m = notificationsEdgeFieldsModel.q();
        return c0691xbe689b41;
    }

    public final C0691xbe689b41 m10200a(@Nullable String str) {
        this.f8519a = str;
        return this;
    }

    public final C0691xbe689b41 m10199a(@Nullable ImmutableList<NotificationHighlightOperationFragmentModel> immutableList) {
        this.f8520b = immutableList;
        return this;
    }

    public final C0691xbe689b41 m10193a(@Nullable GraphQLNotifHighlightState graphQLNotifHighlightState) {
        this.f8521c = graphQLNotifHighlightState;
        return this;
    }

    public final C0691xbe689b41 m10196a(@Nullable C0693x680f492a c0693x680f492a) {
        this.f8522d = c0693x680f492a;
        return this;
    }

    public final C0691xbe689b41 m10192a(int i) {
        this.f8523e = i;
        return this;
    }

    public final C0691xbe689b41 m10194a(@Nullable GraphQLNotifImportanceType graphQLNotifImportanceType) {
        this.f8524f = graphQLNotifImportanceType;
        return this;
    }

    public final C0691xbe689b41 m10201a(boolean z) {
        this.f8525g = z;
        return this;
    }

    public final C0691xbe689b41 m10203b(int i) {
        this.f8527i = i;
        return this;
    }

    public final C0691xbe689b41 m10195a(@Nullable GraphQLStory graphQLStory) {
        this.f8528j = graphQLStory;
        return this;
    }

    public final C0691xbe689b41 m10204b(@Nullable ImmutableList<NotificationOptionRowModel> immutableList) {
        this.f8529k = immutableList;
        return this;
    }

    public final C0691xbe689b41 m10197a(@Nullable C0694xee63252d c0694xee63252d) {
        this.f8530l = c0694xee63252d;
        return this;
    }

    public final C0691xbe689b41 m10198a(@Nullable ReactionUnitFragmentModel reactionUnitFragmentModel) {
        this.f8531m = reactionUnitFragmentModel;
        return this;
    }

    public final NotificationsEdgeFieldsModel m10202a() {
        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
        int b = flatBufferBuilder.b(this.f8519a);
        int a = ModelHelper.a(flatBufferBuilder, this.f8520b);
        int a2 = flatBufferBuilder.a(this.f8521c);
        int a3 = ModelHelper.a(flatBufferBuilder, this.f8522d);
        int a4 = flatBufferBuilder.a(this.f8524f);
        int a5 = ModelHelper.a(flatBufferBuilder, this.f8528j);
        int a6 = ModelHelper.a(flatBufferBuilder, this.f8529k);
        int a7 = ModelHelper.a(flatBufferBuilder, this.f8530l);
        int a8 = ModelHelper.a(flatBufferBuilder, this.f8531m);
        flatBufferBuilder.c(13);
        flatBufferBuilder.b(0, b);
        flatBufferBuilder.b(1, a);
        flatBufferBuilder.b(2, a2);
        flatBufferBuilder.b(3, a3);
        flatBufferBuilder.a(4, this.f8523e, 0);
        flatBufferBuilder.b(5, a4);
        flatBufferBuilder.a(6, this.f8525g);
        flatBufferBuilder.a(7, this.f8526h, 0);
        flatBufferBuilder.a(8, this.f8527i, 0);
        flatBufferBuilder.b(9, a5);
        flatBufferBuilder.b(10, a6);
        flatBufferBuilder.b(11, a7);
        flatBufferBuilder.b(12, a8);
        flatBufferBuilder.d(flatBufferBuilder.d());
        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
        wrap.position(0);
        NotificationsEdgeFieldsModel notificationsEdgeFieldsModel = new NotificationsEdgeFieldsModel(new MutableFlatBuffer(wrap, null, null, true, null));
        if (this.f8528j != null) {
            notificationsEdgeFieldsModel.k().aN = this.f8528j.U_();
        }
        return notificationsEdgeFieldsModel;
    }
}
