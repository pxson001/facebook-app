package com.facebook.notifications.util;

import com.facebook.fbservice.ops.DefaultBlueServiceOperationFactory;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.executor.LegacyConsistencyBridge;
import com.facebook.graphql.modelutil.ModelHelper;
import com.facebook.inject.InjectorLike;
import com.facebook.notifications.model.NotificationSeenStates.NotificationSeenState;
import com.facebook.notifications.protocol.FetchNotificationsGraphQLModels.NotificationStorySeenStateMutationFieldsConnectionModel;
import com.facebook.notifications.protocol.FetchNotificationsGraphQLModels.NotificationStorySeenStateMutationFieldsConnectionModel.EdgesModel;
import com.facebook.notifications.protocol.FetchNotificationsGraphQLModels.NotificationStorySeenStateMutationFieldsModel;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import java.nio.ByteBuffer;
import javax.inject.Inject;

/* compiled from: minutiae_spannable_replace */
public class NotificationsSeenStateMutator {
    public final DefaultBlueServiceOperationFactory f7633a;
    public final LegacyConsistencyBridge f7634b;

    public static NotificationsSeenStateMutator m7966a(InjectorLike injectorLike) {
        return new NotificationsSeenStateMutator(DefaultBlueServiceOperationFactory.b(injectorLike), LegacyConsistencyBridge.b(injectorLike));
    }

    @Inject
    public NotificationsSeenStateMutator(DefaultBlueServiceOperationFactory defaultBlueServiceOperationFactory, LegacyConsistencyBridge legacyConsistencyBridge) {
        this.f7633a = defaultBlueServiceOperationFactory;
        this.f7634b = legacyConsistencyBridge;
    }

    public final void m7967b(ImmutableList<NotificationSeenState> immutableList) {
        Builder builder = ImmutableList.builder();
        int size = immutableList.size();
        for (int i = 0; i < size; i++) {
            NotificationSeenState notificationSeenState = (NotificationSeenState) immutableList.get(i);
            EdgesModel.Builder builder2 = new EdgesModel.Builder();
            NotificationStorySeenStateMutationFieldsModel.Builder builder3 = new NotificationStorySeenStateMutationFieldsModel.Builder();
            builder3.a = notificationSeenState.id;
            builder3 = builder3;
            builder3.b = notificationSeenState.seenState;
            builder2.a = builder3.a();
            EdgesModel.Builder builder4 = builder2;
            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
            int a = ModelHelper.a(flatBufferBuilder, builder4.a);
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.d(flatBufferBuilder.d());
            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
            wrap.position(0);
            builder.c(new EdgesModel(new MutableFlatBuffer(wrap, null, null, true, null)));
        }
        NotificationStorySeenStateMutationFieldsConnectionModel.Builder builder5 = new NotificationStorySeenStateMutationFieldsConnectionModel.Builder();
        builder5.a = builder.b();
        this.f7634b.a(builder5.a());
    }
}
