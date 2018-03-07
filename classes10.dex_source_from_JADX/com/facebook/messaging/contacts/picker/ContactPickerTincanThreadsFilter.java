package com.facebook.messaging.contacts.picker;

import com.facebook.common.executors.FbHandlerThreadFactory;
import com.facebook.contacts.picker.AbstractContactPickerListFilter;
import com.facebook.contacts.picker.ContactPickerFilterResult;
import com.facebook.debug.log.BLog;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.model.threads.ThreadSummary;
import com.facebook.messaging.tincan.database.TincanDbThreadsFetcher;
import com.facebook.messaging.tincan.gatekeepers.TincanGatekeepers;
import com.facebook.widget.filter.CustomFilter.FilterResults;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.collect.RegularImmutableList;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: tap_inbox_announcement */
public class ContactPickerTincanThreadsFilter extends AbstractContactPickerListFilter {
    private static final Class f2003c = ContactPickerTincanThreadsFilter.class;
    private final TincanDbThreadsFetcher f2004d;
    private final TincanGatekeepers f2005e;

    public static ContactPickerTincanThreadsFilter m1833b(InjectorLike injectorLike) {
        return new ContactPickerTincanThreadsFilter(FbHandlerThreadFactory.a(injectorLike), TincanDbThreadsFetcher.a(injectorLike), TincanGatekeepers.b(injectorLike));
    }

    @Inject
    public ContactPickerTincanThreadsFilter(FbHandlerThreadFactory fbHandlerThreadFactory, TincanDbThreadsFetcher tincanDbThreadsFetcher, TincanGatekeepers tincanGatekeepers) {
        super(fbHandlerThreadFactory);
        this.f2004d = tincanDbThreadsFetcher;
        this.f2005e = tincanGatekeepers;
    }

    public final boolean m1835c() {
        TincanGatekeepers tincanGatekeepers = this.f2005e;
        boolean z = false;
        if (tincanGatekeepers.a() && tincanGatekeepers.a.a(308, false)) {
            z = true;
        }
        return z;
    }

    protected final FilterResults m1834b(@Nullable CharSequence charSequence) {
        int i = 0;
        FilterResults filterResults = new FilterResults();
        if (!m1835c()) {
            BLog.c(f2003c, "Filtering called on a disabled filter.");
            filterResults.b = 0;
            filterResults.a = ContactPickerFilterResult.b(charSequence);
            return filterResults;
        } else if (this.a.isEmpty()) {
            String trim = charSequence != null ? charSequence.toString().trim() : "";
            if (trim.isEmpty()) {
                filterResults.a = ContactPickerFilterResult.a(charSequence);
                filterResults.b = -1;
                return filterResults;
            }
            ImmutableList a = this.f2004d.a(trim);
            Builder builder = new Builder();
            int size = a.size();
            while (i < size) {
                builder.c(this.b.a((ThreadSummary) a.get(i)));
                i++;
            }
            ImmutableList b = builder.b();
            filterResults.a = ContactPickerFilterResult.a(charSequence, b);
            filterResults.b = b.size();
            return filterResults;
        } else {
            filterResults.b = 0;
            filterResults.a = ContactPickerFilterResult.a(charSequence, RegularImmutableList.a);
            return filterResults;
        }
    }
}
