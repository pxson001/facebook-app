package com.facebook.heisman;

import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.heisman.protocol.FetchImageOverlayGraphQLModels.ImageOverlayCameraTitleFieldsModel;
import com.facebook.heisman.protocol.HeismanSelfProfilePictureGraphQLModels.SelfProfilePictureFieldsModel;
import com.facebook.heisman.protocol.imageoverlay.ImageOverlayGraphQLModels.ImageOverlayFieldsModel;
import com.facebook.heisman.protocol.swipeable.SwipeableOverlaysGraphQLModels.ImageOverlayWithSwipeableOverlaysModel;
import com.google.common.util.concurrent.ListenableFuture;
import javax.annotation.Nullable;

/* compiled from: var documentBody = document.getElementsByTagName('body')[0];var documentBodyStyle = window.getComputedStyle(documentBody);if (documentBodyStyle.margin === '8px') {documentBody.style.margin = 0;} */
public class ProfilePictureOverlayCameraFetchFutures {
    public final ListenableFuture<GraphQLResult<SelfProfilePictureFieldsModel>> f679a;
    public final ListenableFuture<ImageOverlayFieldsModel> f680b;
    @Nullable
    public final ListenableFuture<GraphQLResult<ImageOverlayWithSwipeableOverlaysModel>> f681c;
    public final ListenableFuture<GraphQLResult<ImageOverlayCameraTitleFieldsModel>> f682d;

    public ProfilePictureOverlayCameraFetchFutures(ListenableFuture<GraphQLResult<SelfProfilePictureFieldsModel>> listenableFuture, ListenableFuture<ImageOverlayFieldsModel> listenableFuture2, @Nullable ListenableFuture<GraphQLResult<ImageOverlayWithSwipeableOverlaysModel>> listenableFuture3, ListenableFuture<GraphQLResult<ImageOverlayCameraTitleFieldsModel>> listenableFuture4) {
        this.f679a = listenableFuture;
        this.f680b = listenableFuture2;
        this.f681c = listenableFuture3;
        this.f682d = listenableFuture4;
    }
}
