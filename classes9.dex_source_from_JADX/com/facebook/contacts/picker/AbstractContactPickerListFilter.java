package com.facebook.contacts.picker;

import com.facebook.common.executors.FbHandlerThreadFactory;
import com.facebook.contacts.picker.ContactPickerListFilter.RowCreator;
import com.facebook.user.model.UserIdentifier;
import com.facebook.widget.filter.AbstractCustomFilter;
import com.facebook.widget.filter.CustomFilter.FilterResults;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import java.util.HashSet;
import java.util.Set;
import javax.annotation.Nullable;

/* compiled from: pri */
public abstract class AbstractContactPickerListFilter extends AbstractCustomFilter implements ContactPickerListFilter {
    protected Set<UserIdentifier> f6289a;
    public RowCreator f6290b;
    private ContactPickerListFilterReceiver f6291c;
    public boolean f6292d = true;

    public AbstractContactPickerListFilter(FbHandlerThreadFactory fbHandlerThreadFactory) {
        super(fbHandlerThreadFactory);
    }

    public final void mo245a(ContactPickerListFilterReceiver contactPickerListFilterReceiver) {
        this.f6291c = contactPickerListFilterReceiver;
        this.f6289a = new HashSet();
    }

    public final void mo246a(ImmutableList<UserIdentifier> immutableList) {
        this.f6289a.clear();
        if (immutableList != null) {
            int size = immutableList.size();
            for (int i = 0; i < size; i++) {
                this.f6289a.add((UserIdentifier) immutableList.get(i));
            }
        }
    }

    public final void mo244a(RowCreator rowCreator) {
        this.f6290b = rowCreator;
    }

    public final void m6706a(boolean z) {
        this.f6292d = z;
    }

    protected final void m6705a(@Nullable CharSequence charSequence, FilterResults filterResults) {
        Preconditions.checkNotNull(filterResults);
        Preconditions.checkNotNull(filterResults.a);
        this.f6291c.mo251a(charSequence, (ContactPickerFilterResult) filterResults.a);
    }

    public boolean m6707a(UserIdentifier userIdentifier) {
        if (this.f6289a == null || this.f6289a.isEmpty()) {
            return false;
        }
        int i = this.f6292d ? ((UserIdentifier) this.f6289a.iterator().next()).getClass() != userIdentifier.getClass() ? 1 : 0 : 0;
        return this.f6289a.contains(userIdentifier) | i;
    }
}
