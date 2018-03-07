package com.facebook.messaging.contactsyoumayknow;

import com.facebook.common.time.Clock;
import com.facebook.graphql.enums.GraphQLStructuredNamePart;
import com.facebook.graphql.querybuilder.common.CommonGraphQL2Models.DefaultNameFieldsModel;
import com.facebook.graphql.querybuilder.common.CommonGraphQL2Models.DefaultNamePartFieldsModel;
import com.facebook.messaging.contactsyoumayknow.graphql.ContactsYouMayKnowQueryModels.ContactYouMayKnowInfoModel;
import com.facebook.messaging.contactsyoumayknow.graphql.ContactsYouMayKnowQueryModels.ContactsYouMayKnowQueryModel;
import com.facebook.messaging.contactsyoumayknow.graphql.ContactsYouMayKnowQueryModels.ContactsYouMayKnowQueryModel.MessengerContactsYouMayKnowModel;
import com.facebook.user.model.Name;
import com.facebook.user.model.User;
import com.facebook.user.model.User.Type;
import com.facebook.user.model.UserBuilder;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: sync_thread_prefetch */
public class ContactsYouMayKnowDataDeserializer {
    private final Clock f2096a;

    @Inject
    public ContactsYouMayKnowDataDeserializer(Clock clock) {
        this.f2096a = clock;
    }

    @Nullable
    public final ContactsYouMayKnowData m1914a(ContactsYouMayKnowQueryModel contactsYouMayKnowQueryModel) {
        MessengerContactsYouMayKnowModel a = contactsYouMayKnowQueryModel.m2000a();
        Builder builder = ImmutableList.builder();
        ImmutableList a2 = a.m1996a();
        int size = a2.size();
        for (int i = 0; i < size; i++) {
            ContactYouMayKnowInfoModel contactYouMayKnowInfoModel = (ContactYouMayKnowInfoModel) a2.get(i);
            UserBuilder userBuilder = new UserBuilder();
            userBuilder.a(Type.FACEBOOK, contactYouMayKnowInfoModel.m1986j());
            userBuilder.g = m1913a(contactYouMayKnowInfoModel.m1990n());
            userBuilder.n = contactYouMayKnowInfoModel.m1989m().b();
            User aa = userBuilder.aa();
            if (!(aa == null || contactYouMayKnowInfoModel.m1987k())) {
                builder.c(new ContactSuggestion(aa, contactYouMayKnowInfoModel.m1988l()));
            }
        }
        return new ContactsYouMayKnowData(builder.b(), this.f2096a.a());
    }

    public static Name m1913a(DefaultNameFieldsModel defaultNameFieldsModel) {
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
