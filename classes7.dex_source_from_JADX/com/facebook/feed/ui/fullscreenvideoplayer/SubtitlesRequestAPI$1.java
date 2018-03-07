package com.facebook.feed.ui.fullscreenvideoplayer;

import com.facebook.api.graphql.videocaptions.FetchVideoCaptionsGraphQLModels.FetchVideoCaptionsGraphQLModel;
import com.facebook.api.graphql.videocaptions.FetchVideoCaptionsGraphQLModels.FetchVideoCaptionsGraphQLModel.VideoCaptionsModel;
import com.facebook.api.graphql.videocaptions.FetchVideoCaptionsGraphQLModels.FetchVideoCaptionsGraphQLModel.VideoCaptionsModel.VideoCaptionItemsModel;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.video.subtitles.controller.Subtitles;
import com.facebook.video.subtitles.controller.SubtitlesEntry;
import com.google.common.collect.ImmutableList;
import com.google.common.util.concurrent.FutureCallback;
import javax.annotation.Nullable;

/* compiled from: TimelineUserScrolled */
class SubtitlesRequestAPI$1 implements FutureCallback<GraphQLResult<FetchVideoCaptionsGraphQLModel>> {
    final /* synthetic */ SubtitlesRequestCallback f21964a;
    final /* synthetic */ SubtitlesRequestAPI f21965b;

    SubtitlesRequestAPI$1(SubtitlesRequestAPI subtitlesRequestAPI, SubtitlesRequestCallback subtitlesRequestCallback) {
        this.f21965b = subtitlesRequestAPI;
        this.f21964a = subtitlesRequestCallback;
    }

    public void onSuccess(@Nullable Object obj) {
        try {
            ImmutableList a = ((VideoCaptionsModel) ((FetchVideoCaptionsGraphQLModel) ((GraphQLResult) obj).d()).m695a().get(0)).m692a();
            int size = a.size();
            SubtitlesEntry[] subtitlesEntryArr = new SubtitlesEntry[size];
            for (int i = 0; i < size; i++) {
                subtitlesEntryArr[i] = new SubtitlesEntry(((VideoCaptionItemsModel) a.get(i)).m688k(), ((VideoCaptionItemsModel) a.get(i)).m687j(), ((VideoCaptionItemsModel) a.get(i)).m685a());
            }
            this.f21964a.mo1511a(new Subtitles(subtitlesEntryArr));
        } catch (NullPointerException e) {
            this.f21965b.c.a("VideoSubtitles", "Invalid results on fetching subtitles GraphQL.");
        } catch (IndexOutOfBoundsException e2) {
            this.f21965b.c.a("VideoSubtitles", "Invalid results on fetching subtitles GraphQL.");
        }
    }

    public void onFailure(Throwable th) {
    }
}
