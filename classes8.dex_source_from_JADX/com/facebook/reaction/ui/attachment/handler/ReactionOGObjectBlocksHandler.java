package com.facebook.reaction.ui.attachment.handler;

import android.net.Uri;
import android.view.View;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.controller.mutation.RawLikeHelper;
import com.facebook.fbui.glyph.GlyphColorizer;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.model.GraphQLActorCache;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.reaction.action.ReactionIntentFactory;
import com.facebook.reaction.analytics.ReactionAnalytics.UnitInteractionType;
import com.facebook.reaction.common.ReactionAttachmentIntent;
import com.facebook.reaction.intent.ReactionIntentLauncher;
import com.facebook.reaction.protocol.graphql.FetchReactionGraphQLModels.ReactionStoryAttachmentFragmentModel;
import java.util.concurrent.Executor;
import javax.inject.Inject;

/* compiled from: ViewStub */
public class ReactionOGObjectBlocksHandler extends ReactionProfileHandler {
    private final ReactionIntentFactory f20882a;

    public static ReactionOGObjectBlocksHandler m24511c(InjectorLike injectorLike) {
        return new ReactionOGObjectBlocksHandler(ReactionIntentFactory.m22683a(injectorLike), ReactionIntentLauncher.m24381a(injectorLike), IdBasedSingletonScopeProvider.b(injectorLike, 262), IdBasedSingletonScopeProvider.b(injectorLike, 1275), IdBasedLazy.a(injectorLike, 2164), RawLikeHelper.b(injectorLike), (Executor) ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public ReactionOGObjectBlocksHandler(ReactionIntentFactory reactionIntentFactory, ReactionIntentLauncher reactionIntentLauncher, Lazy<GraphQLActorCache> lazy, Lazy<GlyphColorizer> lazy2, Lazy<GraphQLQueryExecutor> lazy3, RawLikeHelper rawLikeHelper, Executor executor) {
        super(reactionIntentFactory, reactionIntentLauncher, lazy, lazy2, lazy3, rawLikeHelper, executor);
        this.f20882a = reactionIntentFactory;
    }

    public final ReactionAttachmentIntent mo1129a(ReactionStoryAttachmentFragmentModel reactionStoryAttachmentFragmentModel, View view) {
        String l = reactionStoryAttachmentFragmentModel.M().l();
        if (l == null) {
            return null;
        }
        return ReactionIntentFactory.m22690a(Uri.parse(l), UnitInteractionType.FACEWEB_URL_TAP);
    }
}
