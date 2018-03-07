package com.facebook.video.videohome.liveupdates;

import com.facebook.facecastdisplay.protocol.FetchVideoBroadcastQueryModels.VideoBroadcastFragmentModel;
import com.facebook.graphql.enums.GraphQLVideoBroadcastStatus;
import javax.annotation.Nullable;

/* compiled from: stopRecording */
public interface BroadcastStatusUpdateListener {
    void mo79a(String str);

    void mo80a(String str, GraphQLVideoBroadcastStatus graphQLVideoBroadcastStatus, @Nullable VideoBroadcastFragmentModel videoBroadcastFragmentModel);
}
