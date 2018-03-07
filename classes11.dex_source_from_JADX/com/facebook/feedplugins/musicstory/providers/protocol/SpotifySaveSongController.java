package com.facebook.feedplugins.musicstory.providers.protocol;

import android.net.Uri;
import com.facebook.feedplugins.musicstory.providers.SpotifyBuilder.Spotify;
import com.facebook.feedplugins.musicstory.providers.SpotifyBuilder.Spotify.C10372;
import com.facebook.feedplugins.musicstory.providers.SpotifyBuilder.Spotify.C10383;
import com.facebook.feedplugins.musicstory.providers.protocol.SpotifySaveSongMutation.SpotifySaveSongMutationString;
import com.facebook.feedplugins.musicstory.providers.protocol.SpotifySaveSongMutationModels.SpotifySaveSongMutationModel;
import com.facebook.feedplugins.musicstory.utils.MusicStoryLogger.ActionType;
import com.facebook.graphql.calls.GraphQlCallInput;
import com.facebook.graphql.calls.SpotifySaveSongInputData;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.graphql.query.GraphQlQueryString;
import com.facebook.tools.dextr.runtime.detour.ExecutorDetour;
import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import java.util.concurrent.ExecutorService;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: com.facebook.timeline.header.bio.edit.TimelineBioEditActivity */
public class SpotifySaveSongController {
    private ExecutorService f8395a;
    private String f8396b;
    private GraphQLQueryExecutor f8397c;

    /* compiled from: com.facebook.timeline.header.bio.edit.TimelineBioEditActivity */
    public interface SpotifySaveSongFailureCallback {
        void mo247a();
    }

    @Inject
    public SpotifySaveSongController(ExecutorService executorService, String str, GraphQLQueryExecutor graphQLQueryExecutor) {
        this.f8395a = executorService;
        this.f8396b = str;
        this.f8397c = graphQLQueryExecutor;
    }

    public final void m9292a(@Nullable String str, Uri uri, final C10383 c10383, final SpotifySaveSongFailureCallback spotifySaveSongFailureCallback) {
        Preconditions.checkNotNull(uri);
        SpotifySaveSongInputData spotifySaveSongInputData = new SpotifySaveSongInputData();
        spotifySaveSongInputData.a("actor_id", this.f8396b);
        GraphQlCallInput graphQlCallInput = spotifySaveSongInputData;
        graphQlCallInput.a("audio_uri", uri.toString());
        graphQlCallInput = graphQlCallInput;
        if (str != null) {
            graphQlCallInput.a("auth_code", str);
        }
        GraphQlQueryString spotifySaveSongMutationString = new SpotifySaveSongMutationString();
        spotifySaveSongMutationString.a("input", graphQlCallInput);
        Futures.a(this.f8397c.a(GraphQLRequest.a(spotifySaveSongMutationString)), new FutureCallback<GraphQLResult<SpotifySaveSongMutationModel>>(this) {
            final /* synthetic */ SpotifySaveSongController f8394c;

            public void onSuccess(Object obj) {
                if (((SpotifySaveSongMutationModel) ((GraphQLResult) obj).e).m9299a()) {
                    C10383 c10383 = c10383;
                    c10383.f8382a.f8386d.m9315a(ActionType.spotify_save);
                    c10383.f8382a.f8388f.f8236a = true;
                    Spotify spotify = c10383.f8382a;
                    ExecutorDetour.a(spotify.f8383a.f8391c, new C10372(spotify), 1186059264);
                    return;
                }
                spotifySaveSongFailureCallback.mo247a();
            }

            public void onFailure(Throwable th) {
            }
        }, this.f8395a);
    }
}
