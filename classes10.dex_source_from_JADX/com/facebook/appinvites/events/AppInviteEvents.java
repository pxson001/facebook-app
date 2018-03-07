package com.facebook.appinvites.events;

import com.facebook.appinvites.protocol.FetchAppInvitesListQueryModels.AppInviteFieldsModel;

/* compiled from: edit_event_reminder_time */
public class AppInviteEvents {

    /* compiled from: edit_event_reminder_time */
    public class AppInviteAllDeletedEvent extends AppInviteEvent {
    }

    /* compiled from: edit_event_reminder_time */
    public class AppInviteAppInstalledEvent extends AppInviteEvent {
        public final String f14578a;

        public AppInviteAppInstalledEvent(String str) {
            this.f14578a = str;
        }
    }

    /* compiled from: edit_event_reminder_time */
    public class AppInviteApplicationBlockedEvent extends AppInviteEvent {
        public final String f14579a;

        public AppInviteApplicationBlockedEvent(String str) {
            this.f14579a = str;
        }
    }

    /* compiled from: edit_event_reminder_time */
    public class AppInviteCollapseAnimationCompleteEvent extends AppInviteEvent {
    }

    /* compiled from: edit_event_reminder_time */
    public class AppInviteDeletedEvent extends AppInviteEvent {
        public final AppInviteFieldsModel f14580a;

        public AppInviteDeletedEvent(AppInviteFieldsModel appInviteFieldsModel) {
            this.f14580a = appInviteFieldsModel;
        }
    }

    /* compiled from: edit_event_reminder_time */
    public class AppInviteUserBlockedEvent extends AppInviteEvent {
        public final String f14581a;

        public AppInviteUserBlockedEvent(String str) {
            this.f14581a = str;
        }
    }
}
