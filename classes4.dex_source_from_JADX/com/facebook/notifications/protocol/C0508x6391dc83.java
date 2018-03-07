package com.facebook.notifications.protocol;

import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.FragmentModelWithBridge;
import com.facebook.flatbuffers.ModelWithFlatBufferFormatHash;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.ModelHelper;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.facebook.notifications.protocol.FetchNotificationsGraphQLModels$NotificationsDeltaConnectionFieldsModel.Deserializer;
import com.facebook.notifications.protocol.FetchNotificationsGraphQLModels$NotificationsDeltaConnectionFieldsModel.Serializer;
import com.facebook.notifications.protocol.FetchNotificationsGraphQLModels.NotificationsDeltaFieldsModel;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import java.util.List;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

@FragmentModelWithBridge
@JsonDeserialize(using = Deserializer.class)
@ModelWithFlatBufferFormatHash(a = 1303223345)
@JsonSerialize(using = Serializer.class)
/* compiled from: importance_reason_text */
public final class C0508x6391dc83 extends BaseModel implements GraphQLVisitableModel {
    @Nullable
    private List<NotificationsDeltaFieldsModel> f10825d;

    public C0508x6391dc83() {
        super(1);
    }

    @Nonnull
    public final ImmutableList<NotificationsDeltaFieldsModel> m11277a() {
        this.f10825d = super.a(this.f10825d, 0, NotificationsDeltaFieldsModel.class);
        return (ImmutableList) this.f10825d;
    }

    public final int jK_() {
        return -1512606002;
    }

    public final GraphQLVisitableModel m11276a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        GraphQLVisitableModel graphQLVisitableModel = null;
        h();
        if (m11277a() != null) {
            Builder a = ModelHelper.a(m11277a(), graphQLModelMutatingVisitor);
            if (a != null) {
                graphQLVisitableModel = (C0508x6391dc83) ModelHelper.a(null, this);
                graphQLVisitableModel.f10825d = a.b();
            }
        }
        i();
        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
    }

    public final int m11275a(FlatBufferBuilder flatBufferBuilder) {
        h();
        int a = ModelHelper.a(flatBufferBuilder, m11277a());
        flatBufferBuilder.c(1);
        flatBufferBuilder.b(0, a);
        i();
        return flatBufferBuilder.d();
    }
}
