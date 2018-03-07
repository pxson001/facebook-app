package com.facebook.messaging.contacts.picker;

import com.facebook.common.executors.FbHandlerThreadFactory;
import com.facebook.contacts.graphql.contactprofiletype.ContactProfileType;
import com.facebook.contacts.iterator.ContactCursorsQuery;
import com.facebook.contacts.iterator.UserIterator;
import com.facebook.contacts.iterator.UserIterators;
import com.facebook.contacts.picker.AbstractContactPickerListFilter;
import com.facebook.contacts.picker.ContactPickerFilterResult;
import com.facebook.contacts.picker.ContactPickerRow;
import com.facebook.debug.log.BLog;
import com.facebook.user.model.User;
import com.facebook.user.model.UserFbidIdentifier;
import com.facebook.user.model.UserKey;
import com.facebook.widget.filter.CustomFilter.FilterResults;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;

/* compiled from: tapped_location_filter */
public class ContactPickerNotOnMessengerFriendsFilter extends AbstractContactPickerListFilter {
    private final UserIterators f1895c;

    /* compiled from: tapped_location_filter */
    class C03071 implements Comparator<User> {
        final /* synthetic */ ContactPickerNotOnMessengerFriendsFilter f1894a;

        C03071(ContactPickerNotOnMessengerFriendsFilter contactPickerNotOnMessengerFriendsFilter) {
            this.f1894a = contactPickerNotOnMessengerFriendsFilter;
        }

        public int compare(Object obj, Object obj2) {
            User user = (User) obj2;
            float f = ((User) obj).m;
            float f2 = user.m;
            if (f > f2) {
                return -1;
            }
            if (f < f2) {
                return 1;
            }
            return 0;
        }
    }

    @Inject
    public ContactPickerNotOnMessengerFriendsFilter(FbHandlerThreadFactory fbHandlerThreadFactory, UserIterators userIterators) {
        super(fbHandlerThreadFactory);
        this.f1895c = userIterators;
    }

    protected final FilterResults m1775b(CharSequence charSequence) {
        FilterResults filterResults = new FilterResults();
        if (charSequence != null) {
            try {
                String trim = charSequence.toString().trim();
            } catch (Throwable e) {
                BLog.b("orca:ContactPickerNotOnMessengerFriendsFilter", "exception while filtering", e);
                throw e;
            }
        }
        trim = "";
        if (trim.length() != 0) {
            Map c = Maps.c();
            m1772a(trim, c);
            List a = Lists.a(c.values());
            m1773a(a);
            Builder builder = ImmutableList.builder();
            m1774a(a, builder);
            ContactPickerFilterResult a2 = ContactPickerFilterResult.a(charSequence, builder.b());
            filterResults.a = a2;
            filterResults.b = a2.c();
        } else {
            filterResults.a = ContactPickerFilterResult.a(charSequence);
            filterResults.b = -1;
        }
        return filterResults;
    }

    private void m1772a(String str, Map<UserKey, User> map) {
        UserIterator a = this.f1895c.a(ContactCursorsQuery.a().b(str).c(ContactProfileType.MESSAGABLE_TYPES).a(true).c(true).e(true).a(30));
        while (a.hasNext()) {
            try {
                User user = (User) a.next();
                map.put(user.e(), user);
            } finally {
                a.close();
            }
        }
    }

    private void m1773a(List<User> list) {
        Collections.sort(list, new C03071(this));
    }

    private void m1774a(List<User> list, Builder<ContactPickerRow> builder) {
        for (User user : list) {
            UserFbidIdentifier n = user.n();
            if (!(n == null || a(n))) {
                builder.c(this.b.a(user));
            }
        }
    }
}
