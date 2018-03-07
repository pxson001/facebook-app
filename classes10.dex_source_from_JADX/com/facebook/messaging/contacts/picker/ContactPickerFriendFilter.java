package com.facebook.messaging.contacts.picker;

import com.facebook.common.executors.FbHandlerThreadFactory;
import com.facebook.contacts.graphql.contactprofiletype.ContactProfileType;
import com.facebook.contacts.iterator.ContactCursorsQuery;
import com.facebook.contacts.iterator.PhoneContactFacebookUserDeduper;
import com.facebook.contacts.iterator.UserIterator;
import com.facebook.contacts.iterator.UserIterators;
import com.facebook.contacts.picker.AbstractContactPickerListFilter;
import com.facebook.contacts.picker.ContactPickerFilterResult;
import com.facebook.contacts.picker.ContactPickerRow;
import com.facebook.contacts.picker.ContactPickerUserRow;
import com.facebook.contacts.picker.UserComparatorByRankingAndName;
import com.facebook.debug.log.BLog;
import com.facebook.debug.tracer.Tracer;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.sms.abtest.SmsIntegrationState;
import com.facebook.messaging.sms.contacts.PhoneContactsLoader;
import com.facebook.messaging.sms.contacts.PhoneContactsLoader.CallerContext;
import com.facebook.messaging.smsbridge.abtest.Boolean_IsSmsBridgeEnabledMethodAutoProvider;
import com.facebook.tools.dextr.runtime.detour.TracerDetour;
import com.facebook.user.model.User;
import com.facebook.user.model.UserIdentifier;
import com.facebook.user.model.UserKey;
import com.facebook.widget.filter.CustomFilter.FilterResults;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: template_data_uri */
public class ContactPickerFriendFilter extends AbstractContactPickerListFilter {
    private final boolean f1787c;
    private final SmsIntegrationState f1788d;
    private final UserIterators f1789e;
    private final PhoneContactsLoader f1790f;
    private final PhoneContactFacebookUserDeduper f1791g;
    private boolean f1792h;
    public boolean f1793i;
    public boolean f1794j = false;
    public boolean f1795k = false;

    public static ContactPickerFriendFilter m1729a(InjectorLike injectorLike) {
        return new ContactPickerFriendFilter(FbHandlerThreadFactory.a(injectorLike), Boolean_IsSmsBridgeEnabledMethodAutoProvider.b(injectorLike), SmsIntegrationState.a(injectorLike), UserIterators.a(injectorLike), PhoneContactsLoader.b(injectorLike), PhoneContactFacebookUserDeduper.a(injectorLike));
    }

    @Inject
    public ContactPickerFriendFilter(FbHandlerThreadFactory fbHandlerThreadFactory, Boolean bool, SmsIntegrationState smsIntegrationState, UserIterators userIterators, PhoneContactsLoader phoneContactsLoader, PhoneContactFacebookUserDeduper phoneContactFacebookUserDeduper) {
        super(fbHandlerThreadFactory);
        this.f1787c = bool.booleanValue();
        this.f1788d = smsIntegrationState;
        this.f1789e = userIterators;
        this.f1790f = phoneContactsLoader;
        this.f1791g = phoneContactFacebookUserDeduper;
    }

    public final void m1734b(boolean z) {
        this.f1792h = z;
    }

    protected final FilterResults m1733b(@Nullable CharSequence charSequence) {
        TracerDetour.a("ContactPickerFriendFilter.Filtering", -1835069673);
        try {
            FilterResults filterResults = new FilterResults();
            String trim = charSequence != null ? charSequence.toString().trim() : "";
            if (trim.length() != 0) {
                Map c = Maps.c();
                m1730a(trim, c);
                List a = Lists.a(c.values());
                ImmutableList a2 = this.f1790f.a(trim, 30, mo56c(), CallerContext.SEARCH);
                if (m1732d()) {
                    int size = a2.size();
                    for (int i = 0; i < size; i++) {
                        User user = (User) a2.get(i);
                        if (!this.f1791g.a(user)) {
                            a.add(user);
                        }
                    }
                } else {
                    a.addAll(a2);
                }
                Collections.sort(a, new UserComparatorByRankingAndName(a));
                Builder builder = ImmutableList.builder();
                m1731a(a, builder);
                ContactPickerFilterResult a3 = ContactPickerFilterResult.a(charSequence, builder.b());
                filterResults.a = a3;
                filterResults.b = a3.c();
            } else {
                filterResults.a = ContactPickerFilterResult.a(charSequence);
                filterResults.b = -1;
            }
            TracerDetour.a(271067312);
            Tracer.c("orca:ContactPickerFriendFilter");
            return filterResults;
        } catch (Throwable e) {
            BLog.b("orca:ContactPickerFriendFilter", "exception while filtering", e);
            throw e;
        } catch (Throwable th) {
            TracerDetour.a(-1389559139);
            Tracer.c("orca:ContactPickerFriendFilter");
        }
    }

    private void m1730a(String str, Map<UserKey, User> map) {
        UserIterator a = this.f1789e.a(ContactCursorsQuery.a().b(str).c(ContactProfileType.MESSAGABLE_TYPES).a(!this.f1792h).b(this.f1793i).e(true).a(30));
        while (a.hasNext()) {
            try {
                User user = (User) a.next();
                map.put(user.e(), user);
            } finally {
                a.close();
            }
        }
    }

    private boolean m1732d() {
        return this.f1787c && !this.f1788d.a();
    }

    private void m1731a(List<User> list, Builder<ContactPickerRow> builder) {
        for (User user : list) {
            UserIdentifier userIdentifier = user.U;
            if (!(userIdentifier == null || a(userIdentifier))) {
                ContactPickerRow a = this.b.a(user);
                if (a != null) {
                    if ((this.f1794j || this.f1795k) && (a instanceof ContactPickerUserRow)) {
                        ContactPickerUserRow contactPickerUserRow = (ContactPickerUserRow) a;
                        contactPickerUserRow.u = this.f1794j;
                        contactPickerUserRow.x = "top_level_call_button";
                        if (!user.ao()) {
                            contactPickerUserRow.v = this.f1795k;
                            contactPickerUserRow.y = "top_level_call_button_video";
                        }
                        builder.c(contactPickerUserRow);
                    } else {
                        builder.c(a);
                    }
                }
            }
        }
    }

    protected boolean mo56c() {
        return !this.f1794j;
    }
}
