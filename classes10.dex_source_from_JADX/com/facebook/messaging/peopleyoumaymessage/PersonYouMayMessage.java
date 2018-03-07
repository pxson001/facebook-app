package com.facebook.messaging.peopleyoumaymessage;

import com.facebook.graphql.enums.GraphQLMessengerPYMMIconType;
import com.facebook.user.model.User;

/* compiled from: removeAdminsOperation */
public class PersonYouMayMessage {
    public final User f3501a;
    public final GraphQLMessengerPYMMIconType f3502b;
    public final InboxUnitPeopleYouMayMessageUserItem f3503c;

    public PersonYouMayMessage(User user, GraphQLMessengerPYMMIconType graphQLMessengerPYMMIconType, InboxUnitPeopleYouMayMessageUserItem inboxUnitPeopleYouMayMessageUserItem) {
        this.f3501a = user;
        this.f3502b = graphQLMessengerPYMMIconType;
        this.f3503c = inboxUnitPeopleYouMayMessageUserItem;
    }
}
