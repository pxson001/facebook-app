package com.facebook.reaction.feed.environment;

import android.content.Context;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.reaction.common.ReactionCardContainer;
import com.facebook.reaction.intent.ReactionIntentLauncher;

/* compiled from: auto_identify_performed */
public class ReactionFeedActionHandlerProvider extends AbstractAssistedProvider<ReactionFeedActionHandler> {
    public final ReactionFeedActionHandler m23162a(Context context, ReactionCardContainer reactionCardContainer) {
        return new ReactionFeedActionHandler(context, reactionCardContainer, ReactionIntentLauncher.m24381a(this));
    }
}
