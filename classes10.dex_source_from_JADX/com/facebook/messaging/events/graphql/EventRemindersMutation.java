package com.facebook.messaging.events.graphql;

import com.facebook.graphql.query.TypedGraphQLMutationString;
import com.facebook.messaging.events.graphql.EventRemindersMutationModels.LightweightEventCreateModel;
import com.facebook.messaging.events.graphql.EventRemindersMutationModels.LightweightEventDeleteModel;
import com.facebook.messaging.events.graphql.EventRemindersMutationModels.LightweightEventRsvpModel;
import com.facebook.messaging.events.graphql.EventRemindersMutationModels.LightweightEventUpdateModel;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: sms_migration_contact_logs_upload_screen_shown */
public final class EventRemindersMutation {

    /* compiled from: sms_migration_contact_logs_upload_screen_shown */
    public class LightweightEventCreateString extends TypedGraphQLMutationString<LightweightEventCreateModel> {
        public LightweightEventCreateString() {
            super(LightweightEventCreateModel.class, false, "LightweightEventCreate", "c208b535e6b6d71f55b821daa983ae61", "lightweight_event_create", "0", "10154446467441729", RegularImmutableSet.a);
        }

        public final String m2209a(String str) {
            switch (str.hashCode()) {
                case 100358090:
                    return "0";
                default:
                    return str;
            }
        }
    }

    /* compiled from: sms_migration_contact_logs_upload_screen_shown */
    public class LightweightEventDeleteString extends TypedGraphQLMutationString<LightweightEventDeleteModel> {
        public LightweightEventDeleteString() {
            super(LightweightEventDeleteModel.class, false, "LightweightEventDelete", "439fbbebf905cbefdbfec9f6bf43e914", "lightweight_event_delete", "0", "10154446467436729", RegularImmutableSet.a);
        }

        public final String m2210a(String str) {
            switch (str.hashCode()) {
                case 100358090:
                    return "0";
                default:
                    return str;
            }
        }
    }

    /* compiled from: sms_migration_contact_logs_upload_screen_shown */
    public class LightweightEventRsvpString extends TypedGraphQLMutationString<LightweightEventRsvpModel> {
        public LightweightEventRsvpString() {
            super(LightweightEventRsvpModel.class, false, "LightweightEventRsvp", "a79811a2b247f11f9c3f43a988588503", "lightweight_event_rsvp", "0", "10154578275676729", RegularImmutableSet.a);
        }

        public final String m2211a(String str) {
            switch (str.hashCode()) {
                case 100358090:
                    return "0";
                default:
                    return str;
            }
        }
    }

    /* compiled from: sms_migration_contact_logs_upload_screen_shown */
    public class LightweightEventUpdateString extends TypedGraphQLMutationString<LightweightEventUpdateModel> {
        public LightweightEventUpdateString() {
            super(LightweightEventUpdateModel.class, false, "LightweightEventUpdate", "bdd5e7dfccfe8cdbbdb20b5a978cc8d7", "lightweight_event_update", "0", "10154446467431729", RegularImmutableSet.a);
        }

        public final String m2212a(String str) {
            switch (str.hashCode()) {
                case 100358090:
                    return "0";
                default:
                    return str;
            }
        }
    }

    public static final LightweightEventUpdateString m2213b() {
        return new LightweightEventUpdateString();
    }
}
