package com.facebook.events.photoreminder.protocol;

import com.facebook.events.photoreminder.protocol.EventPhotoReminderMutationsModels.EventSendSharePhotosReminderCoreMutationModel;
import com.facebook.graphql.query.TypedGraphQLMutationString;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: backgroundConfirmationAddPendingContactpoint */
public final class EventPhotoReminderMutations {

    /* compiled from: backgroundConfirmationAddPendingContactpoint */
    public class EventSendSharePhotosReminderCoreMutationString extends TypedGraphQLMutationString<EventSendSharePhotosReminderCoreMutationModel> {
        public EventSendSharePhotosReminderCoreMutationString() {
            super(EventSendSharePhotosReminderCoreMutationModel.class, false, "EventSendSharePhotosReminderCoreMutation", "2497b95dc87554de6412ce61a208688b", "event_send_share_photos_reminder", "0", "10154204802881729", RegularImmutableSet.a);
        }

        public final String m19209a(String str) {
            switch (str.hashCode()) {
                case 100358090:
                    return "0";
                default:
                    return str;
            }
        }
    }
}
