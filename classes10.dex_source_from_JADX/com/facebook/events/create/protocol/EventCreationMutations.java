package com.facebook.events.create.protocol;

import com.facebook.events.create.protocol.EventCreationMutationsModels.CreateEventCoreMutationFieldsModel;
import com.facebook.events.create.protocol.EventCreationMutationsModels.EditEventCoreMutationFieldsModel;
import com.facebook.graphql.query.TypedGraphQLMutationString;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: contact_invite_list_fetch_failed */
public final class EventCreationMutations {

    /* compiled from: contact_invite_list_fetch_failed */
    public class CreateEventCoreMutationString extends TypedGraphQLMutationString<CreateEventCoreMutationFieldsModel> {
        public CreateEventCoreMutationString() {
            super(CreateEventCoreMutationFieldsModel.class, false, "CreateEventCoreMutation", "4272db55ef88a30ad70274e6ccb474b2", "event_create", "0", "10154339187576729", RegularImmutableSet.a);
        }

        public final String m16640a(String str) {
            switch (str.hashCode()) {
                case 100358090:
                    return "0";
                default:
                    return str;
            }
        }
    }

    /* compiled from: contact_invite_list_fetch_failed */
    public class EditEventCoreMutationString extends TypedGraphQLMutationString<EditEventCoreMutationFieldsModel> {
        public EditEventCoreMutationString() {
            super(EditEventCoreMutationFieldsModel.class, false, "EditEventCoreMutation", "bc72fb48a881c9568114877f6062d8df", "event_edit", "0", "10154339187596729", RegularImmutableSet.a);
        }

        public final String m16641a(String str) {
            switch (str.hashCode()) {
                case 100358090:
                    return "0";
                default:
                    return str;
            }
        }
    }

    public static final CreateEventCoreMutationString m16642a() {
        return new CreateEventCoreMutationString();
    }

    public static final EditEventCoreMutationString m16643b() {
        return new EditEventCoreMutationString();
    }
}
