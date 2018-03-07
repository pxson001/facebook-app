package com.facebook.notifications.protocol;

import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.FragmentModelWithBridge;
import com.facebook.flatbuffers.ModelWithFlatBufferFormatHash;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.ModelHelper;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import javax.annotation.Nullable;

@FragmentModelWithBridge
@JsonDeserialize(using = Deserializer.class)
@ModelWithFlatBufferFormatHash(a = -1951989517)
@JsonSerialize(using = Serializer.class)
/* compiled from: importance_reason_text */
public final class FetchNotificationsGraphQLModels$FirstNotificationsQueryModel extends BaseModel implements GraphQLVisitableModel {
    @Nullable
    private NotificationStoriesModel f10460d;

    public FetchNotificationsGraphQLModels$FirstNotificationsQueryModel() {
        super(1);
    }

    @Nullable
    public final NotificationStoriesModel m11006a() {
        this.f10460d = (NotificationStoriesModel) super.a(this.f10460d, 0, NotificationStoriesModel.class);
        return this.f10460d;
    }

    public final int jK_() {
        return -1732764110;
    }

    public final GraphQLVisitableModel m11005a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        GraphQLVisitableModel graphQLVisitableModel = null;
        h();
        if (m11006a() != null) {
            NotificationStoriesModel notificationStoriesModel = (NotificationStoriesModel) graphQLModelMutatingVisitor.b(m11006a());
            if (m11006a() != notificationStoriesModel) {
                graphQLVisitableModel = (FetchNotificationsGraphQLModels$FirstNotificationsQueryModel) ModelHelper.a(null, this);
                graphQLVisitableModel.f10460d = notificationStoriesModel;
            }
        }
        i();
        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
    }

    public final int m11004a(FlatBufferBuilder flatBufferBuilder) {
        h();
        int a = ModelHelper.a(flatBufferBuilder, m11006a());
        flatBufferBuilder.c(1);
        flatBufferBuilder.b(0, a);
        i();
        return flatBufferBuilder.d();
    }
}
