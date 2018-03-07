package com.facebook.messaging.groups.notifications;

import android.content.res.Resources;
import com.facebook.messaging.groups.admin.GroupAdminController;
import com.facebook.messaging.groups.links.gatekeepers.JoinableLinksGatekeepers;
import com.facebook.messaging.notify.MessagesNotificationClient;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: should_open_new_timeline_activity_on_save_success */
public class GroupNotificationsHandler {
    public final JoinableLinksGatekeepers f2489a;
    public final GroupAdminController f2490b;
    public final Provider<MessagesNotificationClient> f2491c;
    public final Resources f2492d;

    @Inject
    public GroupNotificationsHandler(JoinableLinksGatekeepers joinableLinksGatekeepers, GroupAdminController groupAdminController, Provider<MessagesNotificationClient> provider, Resources resources) {
        this.f2489a = joinableLinksGatekeepers;
        this.f2490b = groupAdminController;
        this.f2491c = provider;
        this.f2492d = resources;
    }
}
