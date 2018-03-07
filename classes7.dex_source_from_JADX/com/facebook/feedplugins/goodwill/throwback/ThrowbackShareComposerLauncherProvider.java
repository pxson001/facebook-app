package com.facebook.feedplugins.goodwill.throwback;

import com.facebook.composer.activity.ComposerLauncherImpl;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.intent.feed.DefaultFeedIntentBuilder;
import com.facebook.intent.feed.IFeedIntentBuilder;
import com.facebook.ipc.composer.launch.ComposerLauncher;
import com.facebook.ipc.composer.model.ComposerSourceType;

/* compiled from: StartMediaId must be set in order to use this feature */
public class ThrowbackShareComposerLauncherProvider extends AbstractAssistedProvider<ThrowbackShareComposerLauncher> {
    public final ThrowbackShareComposerLauncher m25570a(FeedProps<GraphQLStory> feedProps, ComposerSourceType composerSourceType, String str) {
        return new ThrowbackShareComposerLauncher((IFeedIntentBuilder) DefaultFeedIntentBuilder.a(this), (ComposerLauncher) ComposerLauncherImpl.a(this), feedProps, composerSourceType, str);
    }
}
