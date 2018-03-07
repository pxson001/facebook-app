package com.facebook.messaging.contacts.picker;

import com.facebook.common.executors.FbHandlerThreadFactory;
import com.facebook.contacts.picker.AbstractContactPickerListFilter;
import com.facebook.contacts.picker.ContactPickerFilterResult;
import com.facebook.debug.log.BLog;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.business.search.BusinessSearchHandler;
import com.facebook.messaging.cache.DataCache;
import com.facebook.messaging.database.threads.ThreadSummaryCursorUtil.Iterator;
import com.facebook.messaging.database.threads.ThreadSummaryIterators;
import com.facebook.messaging.model.threadkey.ThreadKey;
import com.facebook.messaging.model.threads.ThreadSummary;
import com.facebook.user.model.User;
import com.facebook.widget.filter.CustomFilter.FilterResults;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.collect.Sets;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: tap_load_more */
public class ContactPickerServerCommercePageFilter extends AbstractContactPickerListFilter {
    private final BusinessSearchHandler f1998c;
    private final DataCache f1999d;
    private final Provider<User> f2000e;
    private final ThreadSummaryIterators f2001f;
    private int f2002g = -1;

    public static ContactPickerServerCommercePageFilter m1830b(InjectorLike injectorLike) {
        return new ContactPickerServerCommercePageFilter(FbHandlerThreadFactory.a(injectorLike), BusinessSearchHandler.b(injectorLike), DataCache.a(injectorLike), IdBasedProvider.a(injectorLike, 3595), ThreadSummaryIterators.a(injectorLike));
    }

    @Inject
    public ContactPickerServerCommercePageFilter(FbHandlerThreadFactory fbHandlerThreadFactory, BusinessSearchHandler businessSearchHandler, DataCache dataCache, Provider<User> provider, ThreadSummaryIterators threadSummaryIterators) {
        super(fbHandlerThreadFactory);
        this.f1998c = businessSearchHandler;
        this.f1999d = dataCache;
        this.f2000e = provider;
        this.f2001f = threadSummaryIterators;
    }

    protected final FilterResults m1832b(@Nullable CharSequence charSequence) {
        String trim = charSequence != null ? charSequence.toString().trim() : "";
        FilterResults filterResults = new FilterResults();
        if (Strings.isNullOrEmpty(trim)) {
            filterResults.a = ContactPickerFilterResult.a(charSequence);
            filterResults.b = -1;
            return filterResults;
        }
        try {
            ImmutableList a = this.f1998c.a(trim, this.f2002g != -1 ? this.f2002g : 6);
            Builder builder = ImmutableList.builder();
            Integer.valueOf(a.size());
            ImmutableList b = m1831b(a);
            int size = b.size();
            for (int i = 0; i < size; i++) {
                builder.c(this.b.a((User) b.get(i)));
            }
            a = builder.b();
            filterResults.b = a.size();
            filterResults.a = ContactPickerFilterResult.a(charSequence, a);
            return filterResults;
        } catch (Throwable e) {
            BLog.a("ContactPickerServerCommercePageFilter", "exception with filtering commerce pages", e);
            filterResults.b = 0;
            filterResults.a = ContactPickerFilterResult.b(charSequence);
            return filterResults;
        }
    }

    private ImmutableList<User> m1831b(ImmutableList<User> immutableList) {
        if (immutableList.isEmpty()) {
            return immutableList;
        }
        User user = (User) this.f2000e.get();
        if (user == null) {
            return immutableList;
        }
        Set a = Sets.a();
        Set a2 = Sets.a();
        int size = immutableList.size();
        for (int i = 0; i < size; i++) {
            User user2 = (User) immutableList.get(i);
            ThreadKey a3 = ThreadKey.a(Long.parseLong(user2.e().b()), Long.parseLong(user.e().b()));
            if (this.f1999d.a(a3) == null) {
                a2.add(a3);
            } else {
                a.add(user2.e().b());
            }
        }
        if (a2.isEmpty()) {
            return immutableList;
        }
        Iterator a4 = this.f2001f.a(a2);
        while (true) {
            try {
                ThreadSummary b = a4.b();
                if (b == null) {
                    break;
                }
                a.add(Long.toString(b.a.d));
            } finally {
                a4.d();
            }
        }
        if (a.size() == immutableList.size()) {
            return immutableList;
        }
        Collection arrayList = new ArrayList();
        Collection arrayList2 = new ArrayList();
        size = immutableList.size();
        for (int i2 = 0; i2 < size; i2++) {
            user = (User) immutableList.get(i2);
            if (a.contains(user.e().b())) {
                arrayList.add(user);
            } else {
                arrayList2.add(user);
            }
        }
        arrayList.addAll(arrayList2);
        return ImmutableList.copyOf(arrayList);
    }
}
