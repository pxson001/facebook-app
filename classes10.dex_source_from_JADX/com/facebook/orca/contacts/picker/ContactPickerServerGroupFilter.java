package com.facebook.orca.contacts.picker;

import com.facebook.common.executors.FbHandlerThreadFactory;
import com.facebook.contacts.picker.AbstractContactPickerListFilter;
import com.facebook.contacts.picker.ContactPickerFilterResult;
import com.facebook.contacts.picker.ContactPickerGroupRow;
import com.facebook.contacts.picker.ContactPickerRow;
import com.facebook.debug.log.BLog;
import com.facebook.http.protocol.AbstractSingleMethodRunner;
import com.facebook.http.protocol.SingleMethodRunner;
import com.facebook.http.protocol.SingleMethodRunnerImpl;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.cache.DataCache;
import com.facebook.messaging.model.threadkey.ThreadKey.Type;
import com.facebook.messaging.model.threads.ThreadSummary;
import com.facebook.messaging.service.methods.SearchThreadNameAndParticipantsMethod;
import com.facebook.messaging.service.model.SearchThreadNameAndParticipantsParams;
import com.facebook.messaging.service.model.SearchThreadNameAndParticipantsResult;
import com.facebook.messaging.threads.graphql.GQLSearchThreadNameAndParticipantsHelper;
import com.facebook.widget.filter.CustomFilter.FilterResults;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.collect.Sets;
import java.util.Set;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: number_of_friends_seen */
public class ContactPickerServerGroupFilter extends AbstractContactPickerListFilter {
    private static final Class<?> f6064c = ContactPickerServerGroupFilter.class;
    private final AbstractSingleMethodRunner f6065d;
    private final SearchThreadNameAndParticipantsMethod f6066e;
    private final DataCache f6067f;
    private final Provider<Boolean> f6068g;
    private final GQLSearchThreadNameAndParticipantsHelper f6069h;
    public int f6070i = -1;
    public int f6071j = -1;
    public boolean f6072k;
    public boolean f6073l;
    private boolean f6074m;

    public static ContactPickerServerGroupFilter m5784b(InjectorLike injectorLike) {
        return new ContactPickerServerGroupFilter(FbHandlerThreadFactory.a(injectorLike), (AbstractSingleMethodRunner) SingleMethodRunnerImpl.a(injectorLike), SearchThreadNameAndParticipantsMethod.b(injectorLike), GQLSearchThreadNameAndParticipantsHelper.b(injectorLike), DataCache.a(injectorLike), IdBasedProvider.a(injectorLike, 4211));
    }

    @Inject
    public ContactPickerServerGroupFilter(FbHandlerThreadFactory fbHandlerThreadFactory, SingleMethodRunner singleMethodRunner, SearchThreadNameAndParticipantsMethod searchThreadNameAndParticipantsMethod, GQLSearchThreadNameAndParticipantsHelper gQLSearchThreadNameAndParticipantsHelper, DataCache dataCache, Provider<Boolean> provider) {
        super(fbHandlerThreadFactory);
        this.f6065d = singleMethodRunner;
        this.f6066e = searchThreadNameAndParticipantsMethod;
        this.f6067f = dataCache;
        this.f6068g = provider;
        this.f6069h = gQLSearchThreadNameAndParticipantsHelper;
    }

    protected final FilterResults m5785b(@Nullable CharSequence charSequence) {
        int i = 6;
        int i2 = 0;
        new StringBuilder("starting filtering, constraint=").append(charSequence);
        String trim = charSequence != null ? charSequence.toString().trim() : "";
        FilterResults filterResults = new FilterResults();
        if (Strings.isNullOrEmpty(trim)) {
            filterResults.a = ContactPickerFilterResult.a(charSequence);
            filterResults.b = -1;
            return filterResults;
        }
        int i3 = this.f6070i != -1 ? this.f6070i : 6;
        if (this.f6071j != -1) {
            i = this.f6071j;
        }
        SearchThreadNameAndParticipantsParams d = SearchThreadNameAndParticipantsParams.newBuilder().a(trim).a(i3 + i).a(true).d();
        try {
            SearchThreadNameAndParticipantsResult a;
            ThreadSummary threadSummary;
            if (((Boolean) this.f6068g.get()).booleanValue()) {
                a = this.f6069h.a(d);
            } else {
                a = (SearchThreadNameAndParticipantsResult) this.f6065d.a(this.f6066e, d);
            }
            Set a2 = Sets.a();
            if (this.f6072k) {
                for (ThreadSummary threadSummary2 : this.f6067f.a()) {
                    a2.add(threadSummary2.a);
                }
            }
            Builder builder = ImmutableList.builder();
            new StringBuilder("got thread summaries: ").append(a.d().e());
            ImmutableList b = a.d().b();
            int size = b.size();
            int i4 = 0;
            while (i4 < size) {
                int i5;
                threadSummary2 = (ThreadSummary) b.get(i4);
                if (threadSummary2.a.a != Type.ONE_TO_ONE && !a2.contains(threadSummary2.a)) {
                    ContactPickerRow a3 = this.b.a(threadSummary2);
                    if ((a3 instanceof ContactPickerGroupRow) && (this.f6073l || this.f6074m)) {
                        ContactPickerGroupRow contactPickerGroupRow = (ContactPickerGroupRow) a3;
                        if (this.f6073l) {
                            contactPickerGroupRow.d(true);
                            contactPickerGroupRow.a("multiway_call_search");
                        }
                        if (this.f6074m) {
                            contactPickerGroupRow.e(true);
                        }
                    }
                    new StringBuilder("adding group summary: ").append(threadSummary2);
                    builder.c(a3);
                    i5 = i2 + 1;
                    if (i5 >= i3) {
                        break;
                    }
                } else {
                    i5 = i2;
                }
                i4++;
                i2 = i5;
            }
            ImmutableList b2 = builder.b();
            filterResults.b = b2.size();
            filterResults.a = ContactPickerFilterResult.a(charSequence, b2);
            return filterResults;
        } catch (Throwable e) {
            BLog.a(f6064c, "exception with filtering groups", e);
            filterResults.b = 0;
            filterResults.a = ContactPickerFilterResult.b(charSequence);
            return filterResults;
        }
    }
}
