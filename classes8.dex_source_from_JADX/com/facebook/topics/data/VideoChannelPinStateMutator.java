package com.facebook.topics.data;

import com.facebook.auth.module.String_LoggedInUserIdMethodAutoProvider;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.graphql.calls.GraphQlCallInput;
import com.facebook.graphql.calls.VideoChannelSetPinStateInputData;
import com.facebook.graphql.calls.VideoChannelSetPinStateInputData.ChannelType;
import com.facebook.graphql.calls.VideoChannelSetPinStateInputData.PinState;
import com.facebook.graphql.calls.VideoChannelSetPinStateInputData.Surface;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.query.GraphQlQueryString;
import com.facebook.inject.InjectorLike;
import com.facebook.topics.protocol.TopicFavoritesMutations.VideoChannelSetPinStateMutationString;
import com.facebook.topics.protocol.TopicFavoritesQueryInterfaces.VideoTopicFragment;
import com.facebook.topics.protocol.TopicFavoritesQueryModels.VideoTopicFragmentModel;
import com.facebook.topics.protocol.TopicFavoritesQueryModels.VideoTopicFragmentModel.Builder;
import com.facebook.ui.futures.TasksManager;
import javax.inject.Inject;

/* compiled from: mEmailId */
public class VideoChannelPinStateMutator {
    private final TasksManager f9531a;
    private final GraphQLQueryExecutor f9532b;
    private final String f9533c;

    public static VideoChannelPinStateMutator m11213b(InjectorLike injectorLike) {
        return new VideoChannelPinStateMutator(TasksManager.b(injectorLike), GraphQLQueryExecutor.a(injectorLike), String_LoggedInUserIdMethodAutoProvider.b(injectorLike));
    }

    @Inject
    public VideoChannelPinStateMutator(TasksManager tasksManager, GraphQLQueryExecutor graphQLQueryExecutor, String str) {
        this.f9531a = tasksManager;
        this.f9532b = graphQLQueryExecutor;
        this.f9533c = str;
    }

    public final void m11214a(VideoTopicFragment videoTopicFragment, PinState pinState, ChannelType channelType, String str, Surface surface, AbstractDisposableFutureCallback abstractDisposableFutureCallback) {
        boolean z;
        GraphQlQueryString videoChannelSetPinStateMutationString = new VideoChannelSetPinStateMutationString();
        VideoChannelSetPinStateInputData videoChannelSetPinStateInputData = new VideoChannelSetPinStateInputData();
        videoChannelSetPinStateInputData.a("actor_id", this.f9533c);
        GraphQlCallInput graphQlCallInput = videoChannelSetPinStateInputData;
        graphQlCallInput.a("video_channel_id", videoTopicFragment.b());
        graphQlCallInput = graphQlCallInput;
        graphQlCallInput.a("pin_state", pinState);
        graphQlCallInput = graphQlCallInput;
        graphQlCallInput.a("channel_type", channelType);
        graphQlCallInput = graphQlCallInput;
        graphQlCallInput.a("video_home_session_id", str);
        graphQlCallInput = graphQlCallInput;
        graphQlCallInput.a("surface", surface);
        videoChannelSetPinStateMutationString.a("input", graphQlCallInput);
        VideoTopicFragmentModel a = VideoTopicFragmentModel.a(videoTopicFragment);
        Builder builder = new Builder();
        builder.a = a.b();
        builder.b = a.c();
        builder.c = a.k();
        builder.d = a.fe_();
        builder.e = a.g();
        builder.f = a.ff_();
        builder.g = a.l();
        builder.h = a.m();
        Builder builder2 = builder;
        if (pinState == PinState.PINNED) {
            z = true;
        } else {
            z = false;
        }
        builder2.e = z;
        this.f9531a.c("MUTATE_VIDEO_CHANNEL_PIN_STATE_KEY", this.f9532b.a(GraphQLRequest.a(videoChannelSetPinStateMutationString).a(builder2.a())), abstractDisposableFutureCallback);
    }
}
