package com.facebook.messaging.contactsyoumayknow;

import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.graphql.calls.MessengerCymkSuggestionHideInputData;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.query.GraphQlQueryString;
import com.facebook.messaging.contactsyoumayknow.ContactsYouMayKnowItemView.ContactsItemViewListener;
import com.facebook.messaging.contactsyoumayknow.ContactsYouMayKnowMutationHandler.C03573;
import com.facebook.messaging.contactsyoumayknow.ContactsYouMayKnowView.C03633;
import com.facebook.messaging.contactsyoumayknow.ContactsYouMayKnowView.C03633.C03621;
import com.facebook.messaging.contactsyoumayknow.graphql.ContactsYouMayKnowMutations.HideCYMKSuggestionString;
import com.facebook.offlinemode.common.OfflineQueryBehavior;
import com.google.common.base.Objects;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.util.concurrent.Futures;
import java.util.Set;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: t6487242 */
public class ContactsYouMayKnowAdapter extends Adapter<ContactsYouMayKnowItemViewHolder> {
    private final LayoutInflater f2081a;
    public ContactsYouMayKnowData f2082b;
    public ImmutableList<ContactSuggestion> f2083c;
    @Nullable
    public C03633 f2084d;
    public Set<String> f2085e;
    public Set<String> f2086f;
    private final ContactsItemViewListener f2087g = new C03481(this);

    /* compiled from: t6487242 */
    class C03481 implements ContactsItemViewListener {
        final /* synthetic */ ContactsYouMayKnowAdapter f2080a;

        C03481(ContactsYouMayKnowAdapter contactsYouMayKnowAdapter) {
            this.f2080a = contactsYouMayKnowAdapter;
        }

        public final void mo57a(View view) {
            ContactsYouMayKnowAdapter contactsYouMayKnowAdapter = this.f2080a;
            ContactSuggestion contactSuggestion = (ContactSuggestion) view.getTag();
            contactsYouMayKnowAdapter.f2086f.add(contactSuggestion.f2078a.a);
            if (contactSuggestion != null && contactsYouMayKnowAdapter.f2084d != null) {
                C03633 c03633 = contactsYouMayKnowAdapter.f2084d;
                ContactsYouMayKnowLogger contactsYouMayKnowLogger = c03633.f2147a.f2151b;
                HoneyClientEvent honeyClientEvent = new HoneyClientEvent("cymk_click_add");
                honeyClientEvent.c = "contacts_you_may_know_people";
                contactsYouMayKnowLogger.f2123a.a(honeyClientEvent.b("id", contactSuggestion.f2078a.a).b("type", "top"));
                Futures.a(((ContactsYouMayKnowNoticeHelper) c03633.f2147a.f2156g.get()).m1938a(c03633.f2147a.getContext(), contactSuggestion), new C03621(c03633, contactSuggestion), c03633.f2147a.f2154e);
            }
        }

        public final void mo58b(View view) {
            ContactsYouMayKnowAdapter contactsYouMayKnowAdapter = this.f2080a;
            ContactSuggestion contactSuggestion = (ContactSuggestion) view.getTag();
            if (contactSuggestion != null && contactsYouMayKnowAdapter.f2084d != null) {
                ContactsYouMayKnowLogger contactsYouMayKnowLogger = contactsYouMayKnowAdapter.f2084d.f2147a.f2151b;
                HoneyClientEvent honeyClientEvent = new HoneyClientEvent("cymk_click_profile");
                honeyClientEvent.c = "contacts_you_may_know_people";
                contactsYouMayKnowLogger.f2123a.a(honeyClientEvent.b("id", contactSuggestion.f2078a.a).b("type", "top"));
            }
        }

        public final void mo59c(View view) {
            ContactsYouMayKnowAdapter contactsYouMayKnowAdapter = this.f2080a;
            ContactSuggestion contactSuggestion = (ContactSuggestion) view.getTag();
            if (contactSuggestion != null && contactsYouMayKnowAdapter.f2084d != null) {
                C03633 c03633 = contactsYouMayKnowAdapter.f2084d;
                ContactsYouMayKnowMutationHandler contactsYouMayKnowMutationHandler = (ContactsYouMayKnowMutationHandler) c03633.f2147a.f2153d.get();
                GraphQlQueryString hideCYMKSuggestionString = new HideCYMKSuggestionString();
                MessengerCymkSuggestionHideInputData messengerCymkSuggestionHideInputData = new MessengerCymkSuggestionHideInputData();
                messengerCymkSuggestionHideInputData.a("suggestion_id", contactSuggestion.f2078a.a);
                hideCYMKSuggestionString.a("input", messengerCymkSuggestionHideInputData);
                Futures.a(contactsYouMayKnowMutationHandler.f2128b.a(GraphQLRequest.a(hideCYMKSuggestionString), OfflineQueryBehavior.c), new C03573(contactsYouMayKnowMutationHandler), contactsYouMayKnowMutationHandler.f2130d);
                c03633.f2147a.f2152c.m1909a(contactSuggestion.f2078a.a);
                ContactsYouMayKnowLogger contactsYouMayKnowLogger = c03633.f2147a.f2151b;
                HoneyClientEvent honeyClientEvent = new HoneyClientEvent("cymk_click_hide");
                honeyClientEvent.c = "contacts_you_may_know_people";
                contactsYouMayKnowLogger.f2123a.a(honeyClientEvent.b("id", contactSuggestion.f2078a.a).b("type", "top"));
                ContactsYouMayKnowAdapter contactsYouMayKnowAdapter2 = c03633.f2147a.f2150a;
                Builder builder = ImmutableList.builder();
                int size = contactsYouMayKnowAdapter2.f2083c.size();
                int i = 0;
                int i2 = 0;
                while (i < size) {
                    int i3;
                    ContactSuggestion contactSuggestion2 = (ContactSuggestion) contactsYouMayKnowAdapter2.f2083c.get(i);
                    if (Objects.equal(contactSuggestion2.f2078a.a, contactSuggestion.f2078a.a)) {
                        contactsYouMayKnowAdapter2.l_(i2);
                        i3 = i2;
                    } else {
                        builder.c(contactSuggestion2);
                        i3 = i2 + 1;
                    }
                    i++;
                    i2 = i3;
                }
                contactsYouMayKnowAdapter2.f2083c = builder.b();
                ContactsYouMayKnowCache contactsYouMayKnowCache = c03633.f2147a.f2152c;
                if (contactsYouMayKnowCache.f2091a != null && !contactsYouMayKnowCache.f2091a.f2094a.isEmpty()) {
                }
            }
        }
    }

    public final void m1904a(ViewHolder viewHolder, int i) {
        ContactsYouMayKnowItemView contactsYouMayKnowItemView = (ContactsYouMayKnowItemView) ((ContactsYouMayKnowItemViewHolder) viewHolder).a;
        ContactSuggestion contactSuggestion = (ContactSuggestion) this.f2083c.get(i);
        contactsYouMayKnowItemView.m1930a(contactSuggestion, this.f2085e.contains(contactSuggestion.f2078a.a), this.f2086f.contains(contactSuggestion.f2078a.a));
        contactsYouMayKnowItemView.setTag(contactSuggestion);
    }

    @Inject
    public ContactsYouMayKnowAdapter(LayoutInflater layoutInflater) {
        this.f2081a = layoutInflater;
    }

    public final ViewHolder m1903a(ViewGroup viewGroup, int i) {
        View inflate = this.f2081a.inflate(2130903773, viewGroup, false);
        ((ContactsYouMayKnowItemView) inflate).f2108b = this.f2087g;
        return new ContactsYouMayKnowItemViewHolder(inflate);
    }

    public final int aZ_() {
        return this.f2083c.size();
    }

    public final void m1905c(ContactSuggestion contactSuggestion) {
        int size = this.f2083c.size();
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            if (Objects.equal(((ContactSuggestion) this.f2083c.get(i2)).f2078a.a, contactSuggestion.f2078a.a)) {
                this.f2086f.remove(contactSuggestion.f2078a.a);
                j_(i);
                return;
            }
            i++;
        }
    }
}
