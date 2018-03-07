package com.facebook.messaging.contacts.picker;

import com.facebook.common.executors.FbHandlerThreadFactory;
import com.facebook.contacts.picker.AbstractContactPickerListFilter;
import com.facebook.contacts.picker.ContactPickerFilterResult;
import com.facebook.debug.log.BLog;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.business.search.BusinessSearchHandler;
import com.facebook.widget.filter.CustomFilter.FilterResults;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: tap_message_request */
public class ContactPickerServerAgentPageFilter extends AbstractContactPickerListFilter {
    private final BusinessSearchHandler f1997c;

    public static ContactPickerServerAgentPageFilter m1828b(InjectorLike injectorLike) {
        return new ContactPickerServerAgentPageFilter(FbHandlerThreadFactory.a(injectorLike), BusinessSearchHandler.b(injectorLike));
    }

    @Inject
    public ContactPickerServerAgentPageFilter(FbHandlerThreadFactory fbHandlerThreadFactory, BusinessSearchHandler businessSearchHandler) {
        super(fbHandlerThreadFactory);
        this.f1997c = businessSearchHandler;
    }

    protected final FilterResults m1829b(@Nullable CharSequence charSequence) {
        String trim = charSequence != null ? charSequence.toString().trim() : "";
        FilterResults filterResults = new FilterResults();
        if (Strings.isNullOrEmpty(trim)) {
            filterResults.a = ContactPickerFilterResult.a(charSequence);
            filterResults.b = -1;
            return filterResults;
        } else if (charSequence.toString().equalsIgnoreCase("M")) {
            Object a;
            try {
                a = this.f1997c.a();
            } catch (Throwable e) {
                BLog.a("ContactPickerServerAgentPageFilter", "exception with filtering commerce pages", e);
                a = null;
            }
            if (a != null) {
                Builder builder = ImmutableList.builder();
                builder.c(this.b.a(a));
                ImmutableList b = builder.b();
                filterResults.b = b.size();
                filterResults.a = ContactPickerFilterResult.a(charSequence, b);
                return filterResults;
            }
            filterResults.b = 0;
            filterResults.a = ContactPickerFilterResult.b(charSequence);
            return filterResults;
        } else {
            filterResults.a = ContactPickerFilterResult.a(charSequence, ImmutableList.of());
            filterResults.b = 0;
            return filterResults;
        }
    }
}
