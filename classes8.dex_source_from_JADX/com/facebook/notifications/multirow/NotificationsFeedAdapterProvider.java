package com.facebook.notifications.multirow;

import com.facebook.api.feed.data.collections.ListItemCollection;
import com.facebook.feed.rows.adapter.MultiRowAdapterBuilder;
import com.facebook.feed.rows.core.ListItemComparator;
import com.facebook.feed.rows.core.MultipleRowsStoriesRecycleCallback;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.inject.IdBasedLazy;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.notifications.protocol.FetchNotificationsGraphQLModels.NotificationsEdgeFieldsModel;

/* compiled from: custom_fonts_file */
public class NotificationsFeedAdapterProvider extends AbstractAssistedProvider<NotificationsFeedAdapter> {
    public final NotificationsFeedAdapter m18830a(AnyEnvironment anyEnvironment, ListItemComparator<NotificationsEdgeFieldsModel> listItemComparator, ListItemCollection listItemCollection) {
        return new NotificationsFeedAdapter(anyEnvironment, listItemComparator, listItemCollection, MultiRowAdapterBuilder.b(this), MultipleRowsStoriesRecycleCallback.a(this), IdBasedLazy.a(this, 8703));
    }
}
