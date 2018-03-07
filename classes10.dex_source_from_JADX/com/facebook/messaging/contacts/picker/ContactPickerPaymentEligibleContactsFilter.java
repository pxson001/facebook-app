package com.facebook.messaging.contacts.picker;

import android.content.res.Resources;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.executors.FbHandlerThreadFactory;
import com.facebook.contacts.graphql.Contact;
import com.facebook.contacts.picker.AbstractContactPickerListFilter;
import com.facebook.contacts.picker.ContactPickerFilterResult;
import com.facebook.contacts.picker.ContactPickerRow;
import com.facebook.contacts.protocol.methods.FetchPaymentEligibleContactsMethod;
import com.facebook.contacts.server.FetchContactsResult;
import com.facebook.contacts.server.FetchPaymentEligibleContactsParams;
import com.facebook.contacts.util.ContactConverterUtil;
import com.facebook.debug.log.BLog;
import com.facebook.debug.tracer.Tracer;
import com.facebook.http.protocol.AbstractSingleMethodRunner;
import com.facebook.http.protocol.SingleMethodRunnerImpl;
import com.facebook.inject.InjectorLike;
import com.facebook.tools.dextr.runtime.detour.TracerDetour;
import com.facebook.widget.filter.CustomFilter.FilterResults;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import javax.inject.Inject;

/* compiled from: tap_trending_gifs_unit */
public class ContactPickerPaymentEligibleContactsFilter extends AbstractContactPickerListFilter {
    private final Resources f1896c;
    private final AbstractSingleMethodRunner f1897d;
    private final ContactPickerRowsFactory f1898e;
    private final FetchPaymentEligibleContactsMethod f1899f;

    public static ContactPickerPaymentEligibleContactsFilter m1777b(InjectorLike injectorLike) {
        return new ContactPickerPaymentEligibleContactsFilter(ResourcesMethodAutoProvider.a(injectorLike), (AbstractSingleMethodRunner) SingleMethodRunnerImpl.a(injectorLike), FetchPaymentEligibleContactsMethod.b(injectorLike), ContactPickerRowsFactory.m1786b(injectorLike), FbHandlerThreadFactory.a(injectorLike));
    }

    @Inject
    public ContactPickerPaymentEligibleContactsFilter(Resources resources, AbstractSingleMethodRunner abstractSingleMethodRunner, FetchPaymentEligibleContactsMethod fetchPaymentEligibleContactsMethod, ContactPickerRowsFactory contactPickerRowsFactory, FbHandlerThreadFactory fbHandlerThreadFactory) {
        super(fbHandlerThreadFactory);
        this.f1896c = resources;
        this.f1897d = abstractSingleMethodRunner;
        this.f1898e = contactPickerRowsFactory;
        this.f1899f = fetchPaymentEligibleContactsMethod;
    }

    protected final FilterResults m1778b(CharSequence charSequence) {
        FilterResults filterResults = new FilterResults();
        TracerDetour.a("ContactPickerFriendFilter.Filtering", 43178279);
        try {
            if (FetchPaymentEligibleContactsParams.a(charSequence)) {
                Builder builder = ImmutableList.builder();
                m1776a(charSequence.toString().trim(), builder);
                if (!builder.b().isEmpty()) {
                    builder.c(ContactPickerRowsFactory.m1783a(this.f1896c.getString(2131231235)));
                }
                ContactPickerFilterResult a = ContactPickerFilterResult.a(charSequence, builder.b());
                filterResults.a = a;
                filterResults.b = a.c();
                TracerDetour.a(418710924);
                Tracer.c("orca:ContactPickerPaymentEligibleContactsFilter");
            } else {
                filterResults.a = ContactPickerFilterResult.a(charSequence);
                filterResults.b = -1;
            }
        } catch (Throwable e) {
            String str = "Exception during filtering of payment eligible contacts for query: %s";
            Object[] objArr = new Object[1];
            objArr[0] = charSequence != null ? charSequence.toString() : "null";
            Tracer.d(str, objArr);
            BLog.a("orca:ContactPickerPaymentEligibleContactsFilter", "Exception during filtering", e);
            filterResults.a = ContactPickerFilterResult.b(charSequence);
            filterResults.b = 0;
        } finally {
            TracerDetour.a(237677315);
            Tracer.c("orca:ContactPickerPaymentEligibleContactsFilter");
        }
        return filterResults;
    }

    private void m1776a(String str, Builder<ContactPickerRow> builder) {
        try {
            ImmutableList c = ((FetchContactsResult) this.f1897d.a(this.f1899f, new FetchPaymentEligibleContactsParams(str, 100), CallerContext.a(getClass()))).c();
            int size = c.size();
            for (int i = 0; i < size; i++) {
                builder.c(this.b.a(ContactConverterUtil.a((Contact) c.get(i))));
            }
        } catch (Exception e) {
        }
    }
}
