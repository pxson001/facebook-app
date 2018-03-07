package com.facebook.reaction.ui.attachment.handler;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.content.event.FbEvent;
import com.facebook.content.event.FbEventSubscriberListManager;
import com.facebook.fbui.widget.contentview.ContentViewWithButton;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.inject.InjectorLike;
import com.facebook.localcontent.event.LocalContentEventBus;
import com.facebook.localcontent.event.LocalContentEvents.PageProductLikeUpdatedEvent;
import com.facebook.localcontent.event.LocalContentEvents.PageProductLikeUpdatedSubscriber;
import com.facebook.localcontent.popular.PageProductViewController;
import com.facebook.localcontent.protocol.graphql.PopularProductFragmentsModels.PageProductModel;
import com.facebook.reaction.common.ReactionAttachmentHandler;
import com.facebook.reaction.common.ReactionAttachmentIntent;
import com.facebook.reaction.intent.ReactionIntentLauncher;
import com.facebook.reaction.protocol.graphql.FetchReactionGraphQLModels.ReactionStoryAttachmentFragmentModel;
import com.facebook.ui.futures.TasksManager;
import com.facebook.ui.toaster.Toaster;
import com.google.common.base.Strings;
import javax.inject.Inject;

/* compiled from: Video Model must be set */
public class ReactionPopularProductHandler extends ReactionAttachmentHandler {
    private final FbEventSubscriberListManager f20915a;
    private final LocalContentEventBus f20916b;
    public final PageProductViewController f20917c;

    public static ReactionPopularProductHandler m24558b(InjectorLike injectorLike) {
        return new ReactionPopularProductHandler(FbEventSubscriberListManager.a(injectorLike), LocalContentEventBus.m17416a(injectorLike), new PageProductViewController((AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike), GraphQLQueryExecutor.a(injectorLike), LocalContentEventBus.m17416a(injectorLike), TasksManager.b(injectorLike), Toaster.b(injectorLike)), ReactionIntentLauncher.m24381a(injectorLike));
    }

    @Inject
    public ReactionPopularProductHandler(FbEventSubscriberListManager fbEventSubscriberListManager, LocalContentEventBus localContentEventBus, PageProductViewController pageProductViewController, ReactionIntentLauncher reactionIntentLauncher) {
        super(reactionIntentLauncher);
        this.f20915a = fbEventSubscriberListManager;
        this.f20916b = localContentEventBus;
        this.f20917c = pageProductViewController;
    }

    public final View mo1118a(ReactionStoryAttachmentFragmentModel reactionStoryAttachmentFragmentModel) {
        final PageProductModel C = reactionStoryAttachmentFragmentModel.C();
        PageProductViewController pageProductViewController = this.f20917c;
        ViewGroup viewGroup = this.f18820c;
        ContentViewWithButton contentViewWithButton = (ContentViewWithButton) LayoutInflater.from(viewGroup.getContext()).inflate(2130906343, viewGroup, false);
        pageProductViewController.m17666a(contentViewWithButton, C);
        final ContentViewWithButton contentViewWithButton2 = contentViewWithButton;
        C22121 c22121 = new PageProductLikeUpdatedSubscriber(this) {
            final /* synthetic */ ReactionPopularProductHandler f20914c;

            public final void m24557b(FbEvent fbEvent) {
                PageProductLikeUpdatedEvent pageProductLikeUpdatedEvent = (PageProductLikeUpdatedEvent) fbEvent;
                if (pageProductLikeUpdatedEvent.f14944a.c() != null && pageProductLikeUpdatedEvent.f14944a.c().equals(C.c())) {
                    this.f20914c.f20917c.m17666a(contentViewWithButton2, pageProductLikeUpdatedEvent.f14944a);
                }
            }
        };
        this.f20915a.a(c22121);
        this.f20916b.a(c22121);
        return contentViewWithButton2;
    }

    public final ReactionAttachmentIntent mo1129a(ReactionStoryAttachmentFragmentModel reactionStoryAttachmentFragmentModel, View view) {
        return null;
    }

    public final boolean mo1119b(ReactionStoryAttachmentFragmentModel reactionStoryAttachmentFragmentModel) {
        return (reactionStoryAttachmentFragmentModel.C() == null || Strings.isNullOrEmpty(reactionStoryAttachmentFragmentModel.C().c()) || Strings.isNullOrEmpty(reactionStoryAttachmentFragmentModel.C().d())) ? false : true;
    }
}
