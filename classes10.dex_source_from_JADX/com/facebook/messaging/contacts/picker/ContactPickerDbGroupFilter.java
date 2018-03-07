package com.facebook.messaging.contacts.picker;

import com.facebook.common.executors.FbHandlerThreadFactory;
import com.facebook.contacts.picker.AbstractContactPickerListFilter;
import com.facebook.contacts.picker.ContactPickerFilterResult;
import com.facebook.contacts.picker.ContactPickerGroupRow;
import com.facebook.contacts.picker.ContactPickerRow;
import com.facebook.debug.log.BLog;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.cache.DataCache;
import com.facebook.messaging.database.threads.ThreadSummaryCursorUtil.Iterator;
import com.facebook.messaging.database.threads.ThreadSummaryIterators;
import com.facebook.messaging.model.threads.ThreadSummary;
import com.facebook.messaging.model.threads.ThreadSummaryBuilder;
import com.facebook.widget.filter.CustomFilter.FilterResults;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.collect.Sets;
import java.util.Set;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: template_file */
public class ContactPickerDbGroupFilter extends AbstractContactPickerListFilter {
    private static final Class<?> f1781c = ContactPickerDbGroupFilter.class;
    private final ThreadSummaryIterators f1782d;
    public boolean f1783e;
    private DataCache f1784f;
    public boolean f1785g;
    private boolean f1786h;

    public static ContactPickerDbGroupFilter m1727b(InjectorLike injectorLike) {
        return new ContactPickerDbGroupFilter(FbHandlerThreadFactory.a(injectorLike), ThreadSummaryIterators.a(injectorLike), DataCache.a(injectorLike));
    }

    @Inject
    public ContactPickerDbGroupFilter(FbHandlerThreadFactory fbHandlerThreadFactory, ThreadSummaryIterators threadSummaryIterators, DataCache dataCache) {
        super(fbHandlerThreadFactory);
        this.f1782d = threadSummaryIterators;
        this.f1784f = dataCache;
    }

    protected final FilterResults m1728b(@Nullable CharSequence charSequence) {
        int i = 0;
        String trim = charSequence != null ? charSequence.toString().trim() : "";
        new StringBuilder("starting filtering, constraint=").append(trim);
        FilterResults filterResults = new FilterResults();
        if (trim.length() == 0) {
            filterResults.a = ContactPickerFilterResult.a(charSequence);
            filterResults.b = -1;
            return filterResults;
        }
        Set a = Sets.a();
        if (this.f1783e) {
            ImmutableList a2 = this.f1784f.a();
            int size = a2.size();
            for (int i2 = 0; i2 < size; i2++) {
                a.add(((ThreadSummary) a2.get(i2)).a);
            }
        }
        Iterator a3 = this.f1782d.a(trim, null);
        try {
            Builder builder = ImmutableList.builder();
            while (true) {
                ThreadSummaryBuilder a4 = a3.a();
                if (a4 == null) {
                    break;
                }
                ThreadSummary V = a4.V();
                if (V.h.size() >= 3 && !a.contains(V.a)) {
                    ContactPickerRow a5 = this.b.a(V);
                    if ((a5 instanceof ContactPickerGroupRow) && (this.f1785g || this.f1786h)) {
                        ContactPickerGroupRow contactPickerGroupRow = (ContactPickerGroupRow) a5;
                        if (this.f1785g) {
                            contactPickerGroupRow.d(true);
                            contactPickerGroupRow.a("multiway_call_search");
                        }
                        if (this.f1786h) {
                            contactPickerGroupRow.e(true);
                        }
                    }
                    new StringBuilder("adding group summary: ").append(V);
                    builder.c(a5);
                    int i3 = i + 1;
                    if (i3 >= 6) {
                        break;
                    }
                    i = i3;
                }
            }
            ImmutableList b = builder.b();
            filterResults.b = b.size();
            filterResults.a = ContactPickerFilterResult.a(charSequence, b);
            new StringBuilder("got thread summaries: ").append(b.size());
            return filterResults;
        } catch (Throwable e) {
            BLog.a(f1781c, "exception with filtering groups", e);
            filterResults.b = 0;
            filterResults.a = ContactPickerFilterResult.b(charSequence);
            return filterResults;
        } finally {
            a3.d();
        }
    }
}
