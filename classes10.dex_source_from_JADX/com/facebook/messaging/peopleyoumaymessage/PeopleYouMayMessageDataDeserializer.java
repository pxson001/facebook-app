package com.facebook.messaging.peopleyoumaymessage;

import com.facebook.common.time.Clock;
import com.facebook.graphql.enums.GraphQLStructuredNamePart;
import com.facebook.graphql.querybuilder.common.CommonGraphQL2Models.DefaultNameFieldsModel;
import com.facebook.graphql.querybuilder.common.CommonGraphQL2Models.DefaultNamePartFieldsModel;
import com.facebook.messaging.inbox2.graphql.InboxV2QueryModels.InboxV2QueryModel.MessengerInboxUnitsModel.NodesModel;
import com.facebook.messaging.inbox2.graphql.InboxV2QueryModels.InboxV2QueryModel.MessengerInboxUnitsModel.NodesModel.MessengerInboxUnitItemsModel;
import com.facebook.messaging.inbox2.graphql.InboxV2QueryModels.InboxV2QueryModel.MessengerInboxUnitsModel.NodesModel.MessengerInboxUnitItemsModel.MessengerInboxItemAttachmentModel;
import com.facebook.messaging.peopleyoumaymessage.graphql.PeopleYouMayMessageQueryModels.PeopleYouMayMessageUserInfoModel;
import com.facebook.user.model.Name;
import com.facebook.user.model.User.Type;
import com.facebook.user.model.UserBuilder;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: remove_pin */
public class PeopleYouMayMessageDataDeserializer {
    private final Clock f3479a;

    @Inject
    public PeopleYouMayMessageDataDeserializer(Clock clock) {
        this.f3479a = clock;
    }

    @Nullable
    public final PeopleYouMayMessageData m3360a(NodesModel nodesModel) {
        return new PeopleYouMayMessageData(m3359b(nodesModel), true, this.f3479a.a(), "", "");
    }

    private ImmutableList<PersonYouMayMessage> m3359b(NodesModel nodesModel) {
        Builder builder = ImmutableList.builder();
        ImmutableList m = nodesModel.m();
        int size = m.size();
        int i = 0;
        int i2 = 0;
        while (i < size) {
            int i3;
            MessengerInboxUnitItemsModel messengerInboxUnitItemsModel = (MessengerInboxUnitItemsModel) m.get(i);
            if (messengerInboxUnitItemsModel.m() != 0) {
                PersonYouMayMessage personYouMayMessage;
                MessengerInboxItemAttachmentModel k = messengerInboxUnitItemsModel.k();
                if (k == null) {
                    personYouMayMessage = null;
                } else {
                    PeopleYouMayMessageUserInfoModel t = k.t();
                    UserBuilder userBuilder = new UserBuilder();
                    userBuilder.a(Type.FACEBOOK, t.j());
                    userBuilder.g = m3358a(t.l());
                    userBuilder.A = t.k();
                    personYouMayMessage = new PersonYouMayMessage(userBuilder.aa(), k.o(), new InboxUnitPeopleYouMayMessageUserItem(nodesModel, messengerInboxUnitItemsModel));
                }
                PersonYouMayMessage personYouMayMessage2 = personYouMayMessage;
                if (personYouMayMessage2 != null) {
                    i3 = i2 + 1;
                    personYouMayMessage2.f3503c.a(i2);
                    builder.c(personYouMayMessage2);
                    i++;
                    i2 = i3;
                }
            }
            i3 = i2;
            i++;
            i2 = i3;
        }
        return builder.b();
    }

    public static Name m3358a(DefaultNameFieldsModel defaultNameFieldsModel) {
        String str;
        String str2 = null;
        String s_ = defaultNameFieldsModel.s_();
        if (s_ != null) {
            ImmutableList a = defaultNameFieldsModel.a();
            int size = a.size();
            int i = 0;
            str = null;
            while (i < size) {
                String str3;
                DefaultNamePartFieldsModel defaultNamePartFieldsModel = (DefaultNamePartFieldsModel) a.get(i);
                int t_ = defaultNamePartFieldsModel.t_();
                int t_2 = defaultNamePartFieldsModel.t_() + defaultNamePartFieldsModel.a();
                if (defaultNamePartFieldsModel.c() == GraphQLStructuredNamePart.FIRST) {
                    String str4 = str2;
                    str2 = s_.substring(t_, t_2);
                    str3 = str4;
                } else if (defaultNamePartFieldsModel.c() == GraphQLStructuredNamePart.LAST) {
                    str3 = s_.substring(t_, t_2);
                    str2 = str;
                } else {
                    str3 = str2;
                    str2 = str;
                }
                i++;
                str = str2;
                str2 = str3;
            }
        } else {
            str = null;
        }
        return new Name(str, str2, s_);
    }
}
