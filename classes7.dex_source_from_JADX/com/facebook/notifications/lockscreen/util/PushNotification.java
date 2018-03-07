package com.facebook.notifications.lockscreen.util;

import android.database.Cursor;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.notifications.lockscreen.db.PushNotificationsDbSchemaPart.PushNotificationsTable.Columns;
import com.facebook.notifications.logging.NotificationType;
import com.facebook.notifications.provider.GraphQLNotificationsContentProviderHelper;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: newFocus is not a child of any of the children of the list! */
public final class PushNotification extends LockScreenNotification {
    public final int f8229b;
    public final String f8230c;
    public final String f8231d;
    public final String f8232e;
    public final NotificationType f8233f;
    public final FeedProps<GraphQLStory> f8234g;
    public final String f8235h;
    public final String f8236i;

    public PushNotification(Cursor cursor, GraphQLNotificationsContentProviderHelper graphQLNotificationsContentProviderHelper) {
        super(cursor.getLong(Columns.e.a(cursor)));
        int a = Columns.a.a(cursor);
        int a2 = Columns.b.a(cursor);
        int a3 = Columns.d.a(cursor);
        int a4 = Columns.f.a(cursor);
        int a5 = Columns.c.a(cursor);
        int a6 = Columns.g.a(cursor);
        int a7 = Columns.h.a(cursor);
        this.f8229b = cursor.getInt(a);
        this.f8230c = cursor.getString(a2);
        this.f8231d = cursor.getString(a3);
        this.f8233f = NotificationType.valueOf(cursor.getString(a4));
        this.f8232e = cursor.getString(a5);
        GraphQLStory b = graphQLNotificationsContentProviderHelper.b(this.f8232e);
        this.f8234g = b != null ? FeedProps.c(b) : null;
        this.f8235h = cursor.getString(a6);
        this.f8236i = cursor.getString(a7);
    }
}
