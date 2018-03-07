package com.facebook.reaction.feed.rows.ui;

import com.facebook.feed.environment.HasContext;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.reaction.action.ReactionActionHandler;
import com.facebook.reaction.feed.environment.CanLaunchReactionIntent;
import com.facebook.reaction.feed.environment.HasReactionSession;
import com.facebook.reaction.protocol.graphql.ReactionActionsGraphQLInterfaces.ReactionStoryAttachmentActionFragment;
import com.facebook.widget.popovermenuitemwithuriicon.PopoverMenuItemWithUriIconProvider;
import java.util.List;

/* compiled from: android_feed_megaphone */
public class ReactionSecondaryActionPopoverMenuProvider extends AbstractAssistedProvider<ReactionSecondaryActionPopoverMenu> {
    public final <E extends CanLaunchReactionIntent & HasContext & HasReactionSession> ReactionSecondaryActionPopoverMenu<E> m23441a(E e, List<ReactionStoryAttachmentActionFragment> list, String str, String str2, String str3) {
        return new ReactionSecondaryActionPopoverMenu((CanLaunchReactionIntent) e, list, str, str2, str3, (PopoverMenuItemWithUriIconProvider) getOnDemandAssistedProviderForStaticDi(PopoverMenuItemWithUriIconProvider.class), ReactionActionHandler.m22673a(this));
    }
}
