package com.facebook.video.videohome.protocol;

import com.facebook.common.executors.FbAsyncTask;
import com.facebook.graphql.calls.VideoHomeVisitInputData;
import com.facebook.graphql.calls.VideoHomeVisitInputData.Event;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.query.GraphQlQueryString;
import com.facebook.video.videohome.protocol.VideoHomeMutations.VideoHomeVisitMutationString;

/* compiled from: disable_immersive_hooks */
class VideoHomeMutationsHelper$VideoHomeMutationAsyncTask extends FbAsyncTask<Event, Void, Void> {
    final /* synthetic */ VideoHomeMutationsHelper f15758a;

    public VideoHomeMutationsHelper$VideoHomeMutationAsyncTask(VideoHomeMutationsHelper videoHomeMutationsHelper) {
        this.f15758a = videoHomeMutationsHelper;
    }

    protected final Object m19676a(Object[] objArr) {
        Enum enumR = ((Event[]) objArr)[0];
        VideoHomeMutationsHelper videoHomeMutationsHelper = this.f15758a;
        VideoHomeVisitInputData videoHomeVisitInputData = new VideoHomeVisitInputData();
        videoHomeVisitInputData.a("event", enumR);
        GraphQlQueryString videoHomeVisitMutationString = new VideoHomeVisitMutationString();
        videoHomeVisitMutationString.a("video_home_visit_data", videoHomeVisitInputData);
        videoHomeMutationsHelper.b.b(new VideoHomeMutationsHelper$1(videoHomeMutationsHelper, videoHomeMutationsHelper.c.a(GraphQLRequest.a(videoHomeVisitMutationString))));
        return null;
    }
}
