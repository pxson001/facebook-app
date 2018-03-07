package com.facebook.attachments.angora;

import com.facebook.api.graphql.saved.SaveDefaultsGraphQLInterfaces.SavableTimelineAppCollection;
import com.facebook.story.UpdateTimelineAppCollectionParams;
import com.google.common.util.concurrent.ListenableFuture;

/* compiled from: videoID */
public interface CollectionUpdateRequestListener {
    ListenableFuture<?> mo38a(CollectionUpdateResultListener collectionUpdateResultListener, SavableTimelineAppCollection savableTimelineAppCollection, UpdateTimelineAppCollectionParams updateTimelineAppCollectionParams);

    ListenableFuture<?> mo39b(CollectionUpdateResultListener collectionUpdateResultListener, SavableTimelineAppCollection savableTimelineAppCollection, UpdateTimelineAppCollectionParams updateTimelineAppCollectionParams);
}
