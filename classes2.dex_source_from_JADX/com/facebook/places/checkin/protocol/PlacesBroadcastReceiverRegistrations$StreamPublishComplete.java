package com.facebook.places.checkin.protocol;

import android.content.Context;
import android.content.Intent;
import com.facebook.base.broadcast.FbBroadcastManagerType;
import com.facebook.common.init.INeedInitForBroadcastReceiverRegistration;
import com.facebook.composer.publish.optimistic.ComposerActivityBroadcaster.Result;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.inject.Lazy;
import com.facebook.places.checkin.protocol.CheckinHistoryLoader.2;
import com.google.common.util.concurrent.ListenableFuture;
import javax.inject.Inject;

/* compiled from: total_device_bytes_received */
public class PlacesBroadcastReceiverRegistrations$StreamPublishComplete extends INeedInitForBroadcastReceiverRegistration<PlacesAppStateReceiver> {
    protected void onReceive(Context context, Intent intent, Object obj) {
        CheckinHistorySyncHelper checkinHistorySyncHelper = (CheckinHistorySyncHelper) ((PlacesAppStateReceiver) obj).a.get();
        GraphQLStory graphQLStory = (GraphQLStory) intent.getParcelableExtra("graphql_story");
        if (Result.SUCCESS == Result.valueOf(intent.getStringExtra("extra_result")) && graphQLStory != null && graphQLStory.m22339Y() != null) {
            CheckinHistoryLoader checkinHistoryLoader = checkinHistorySyncHelper.a;
            ListenableFuture a = checkinHistoryLoader.b.mo271a(new 2(checkinHistoryLoader));
        }
    }

    @Inject
    public PlacesBroadcastReceiverRegistrations$StreamPublishComplete(Lazy<PlacesAppStateReceiver> lazy) {
        super(FbBroadcastManagerType.LOCAL, (Lazy) lazy, "com.facebook.STREAM_PUBLISH_COMPLETE");
    }
}
