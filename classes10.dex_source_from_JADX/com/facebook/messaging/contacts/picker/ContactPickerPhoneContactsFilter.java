package com.facebook.messaging.contacts.picker;

import com.facebook.common.executors.FbHandlerThreadFactory;
import com.facebook.contacts.iterator.MessengerPhoneUserIterator;
import com.facebook.contacts.iterator.PhoneUserIterators;
import com.facebook.contacts.picker.AbstractContactPickerListFilter;
import com.facebook.contacts.picker.ContactPickerFilterResult;
import com.facebook.contacts.picker.ContactPickerRow;
import com.facebook.debug.log.BLog;
import com.facebook.messaging.invites.sms.SmsInviteNumberSelector;
import com.facebook.runtimepermissions.RuntimePermissionsUtil;
import com.facebook.user.model.User;
import com.facebook.user.model.UserKey;
import com.facebook.widget.filter.CustomFilter.FilterResults;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;

/* compiled from: tap_top_right_nav */
public class ContactPickerPhoneContactsFilter extends AbstractContactPickerListFilter {
    private final PhoneUserIterators f1902c;
    private final RuntimePermissionsUtil f1903d;

    /* compiled from: tap_top_right_nav */
    class C03081 implements Comparator<User> {
        final /* synthetic */ ContactPickerPhoneContactsFilter f1901a;

        C03081(ContactPickerPhoneContactsFilter contactPickerPhoneContactsFilter) {
            this.f1901a = contactPickerPhoneContactsFilter;
        }

        public int compare(Object obj, Object obj2) {
            return ((User) obj).k().compareTo(((User) obj2).k());
        }
    }

    @Inject
    public ContactPickerPhoneContactsFilter(FbHandlerThreadFactory fbHandlerThreadFactory, PhoneUserIterators phoneUserIterators, RuntimePermissionsUtil runtimePermissionsUtil) {
        super(fbHandlerThreadFactory);
        this.f1902c = phoneUserIterators;
        this.f1903d = runtimePermissionsUtil;
    }

    protected final FilterResults m1782b(CharSequence charSequence) {
        FilterResults filterResults = new FilterResults();
        if (charSequence != null) {
            try {
                String trim = charSequence.toString().trim();
            } catch (Throwable e) {
                BLog.b("orca:ContactPickerPhoneContactsFilter", "exception while filtering", e);
                throw e;
            }
        }
        trim = "";
        if (!this.f1903d.a("android.permission.READ_CONTACTS") || Strings.isNullOrEmpty(trim)) {
            filterResults.a = ContactPickerFilterResult.a(charSequence);
            filterResults.b = -1;
        } else {
            Map c = Maps.c();
            m1779a(trim, c);
            List a = Lists.a(c.values());
            m1780a(a);
            Builder builder = ImmutableList.builder();
            m1781a(a, builder);
            ContactPickerFilterResult a2 = ContactPickerFilterResult.a(charSequence, builder.b());
            filterResults.a = a2;
            filterResults.b = a2.c();
        }
        return filterResults;
    }

    private void m1779a(String str, Map<UserKey, User> map) {
        MessengerPhoneUserIterator a = this.f1902c.a(str, 30);
        while (a.hasNext()) {
            try {
                User user = (User) a.next();
                if (SmsInviteNumberSelector.a(user) != null) {
                    map.put(user.e(), user);
                }
            } finally {
                a.c();
            }
        }
    }

    private void m1780a(List<User> list) {
        Collections.sort(list, new C03081(this));
    }

    private void m1781a(List<User> list, Builder<ContactPickerRow> builder) {
        for (User a : list) {
            builder.c(this.b.a(a));
        }
    }
}
