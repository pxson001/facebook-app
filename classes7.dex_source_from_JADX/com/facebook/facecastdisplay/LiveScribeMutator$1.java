package com.facebook.facecastdisplay;

import com.facebook.facecastdisplay.protocol.FetchLiveVideoEventsQueryModels.FetchLiveSubscriptionQueryModel.OwnerModel;

/* compiled from: audio/x-flac */
class LiveScribeMutator$1 implements Runnable {
    final /* synthetic */ OwnerModel f18916a;
    final /* synthetic */ LiveScribeMutator f18917b;

    LiveScribeMutator$1(LiveScribeMutator liveScribeMutator, OwnerModel ownerModel) {
        this.f18917b = liveScribeMutator;
        this.f18916a = ownerModel;
    }

    public void run() {
        try {
            this.f18917b.c.a(this.f18916a);
        } catch (Throwable e) {
            this.f18917b.e.a(LiveScribeMutator.a + "_graphFailure", "Failed to update live video subscription GraphQL consistency cache.", e);
        }
    }
}
