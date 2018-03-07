package com.facebook.feed.rows.sections.attachments;

import com.facebook.analytics.tagging.CurrentModuleHolder;
import com.facebook.controller.mutation.gk.ControllerMutationGatekeepers;
import com.facebook.controller.mutation.util.FeedStoryMutator;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.util.event.FeedEventBus;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.ui.futures.TasksManager;

/* compiled from: order_time */
public class EventAttachmentActionListenerProvider extends AbstractAssistedProvider<EventAttachmentActionListener> {
    public final EventAttachmentActionListener m6426a(FeedProps<GraphQLStoryAttachment> feedProps) {
        return new EventAttachmentActionListener(feedProps, CurrentModuleHolder.a(this), FeedEventBus.a(this), FeedStoryMutator.b(this), GraphQLQueryExecutor.a(this), TasksManager.b(this), ControllerMutationGatekeepers.b(this));
    }
}
