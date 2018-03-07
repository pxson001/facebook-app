package com.facebook.contacts.picker;

import com.facebook.contacts.picker.ContactPickerListFilter.RowCreator;
import com.facebook.user.model.UserIdentifier;
import com.facebook.widget.filter.CustomFilter.FilterListener;
import com.facebook.widget.filter.CustomFilter.FilteringState;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.collect.ImmutableList;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;

/* compiled from: present_sticker_ids */
public class ContactPickerDelayingListFilter implements ContactPickerListFilter {
    private static final Class<?> f6300b = ContactPickerDelayingListFilter.class;
    @GuardedBy("ui thread")
    @VisibleForTesting
    Future<?> f6301a;
    public final ContactPickerListFilter f6302c;
    private final ScheduledExecutorService f6303d;
    private final DelayPolicy f6304e;

    /* compiled from: present_sticker_ids */
    public interface DelayPolicy {
        long m6716a(CharSequence charSequence);
    }

    public ContactPickerDelayingListFilter(ContactPickerListFilter contactPickerListFilter, ScheduledExecutorService scheduledExecutorService, DelayPolicy delayPolicy) {
        this.f6302c = contactPickerListFilter;
        this.f6303d = scheduledExecutorService;
        this.f6304e = delayPolicy;
    }

    public final void mo245a(ContactPickerListFilterReceiver contactPickerListFilterReceiver) {
        this.f6302c.mo245a(contactPickerListFilterReceiver);
    }

    public final void mo246a(ImmutableList<UserIdentifier> immutableList) {
        this.f6302c.mo246a((ImmutableList) immutableList);
    }

    public final void mo244a(RowCreator rowCreator) {
        this.f6302c.mo244a(rowCreator);
    }

    @GuardedBy("ui thread")
    public final void m6723a(final CharSequence charSequence) {
        long a = this.f6304e.m6716a(charSequence);
        if (a <= 0) {
            m6718c();
            this.f6302c.a(charSequence);
            return;
        }
        this.f6302c.getClass().getSimpleName();
        m6717a(new Runnable(this) {
            final /* synthetic */ ContactPickerDelayingListFilter f6295b;

            public void run() {
                this.f6295b.f6302c.getClass().getSimpleName();
                this.f6295b.f6301a = null;
                this.f6295b.f6302c.a(charSequence);
            }
        }, a);
    }

    @GuardedBy("ui thread")
    public final void m6724a(@Nullable final CharSequence charSequence, final FilterListener filterListener) {
        long a = this.f6304e.m6716a(charSequence);
        if (a <= 0) {
            m6718c();
            this.f6302c.a(charSequence, filterListener);
            return;
        }
        if (this.f6301a == null && this.f6302c.b() != FilteringState.FILTERING) {
            filterListener.a(FilteringState.FILTERING);
        }
        this.f6302c.getClass().getSimpleName();
        m6717a(new Runnable(this) {
            final /* synthetic */ ContactPickerDelayingListFilter f6299c;

            /* compiled from: present_sticker_ids */
            class C06491 implements FilterListener {
                final /* synthetic */ C06502 f6296a;

                C06491(C06502 c06502) {
                    this.f6296a = c06502;
                }

                public final void m6714a(int i) {
                    filterListener.a(i);
                }

                public final void m6715a(FilteringState filteringState) {
                    if (filteringState != FilteringState.FILTERING) {
                        filterListener.a(filteringState);
                    }
                }
            }

            public void run() {
                this.f6299c.f6302c.getClass().getSimpleName();
                this.f6299c.f6301a = null;
                this.f6299c.f6302c.a(charSequence, new C06491(this));
            }
        }, a);
    }

    private void m6717a(Runnable runnable, long j) {
        m6718c();
        this.f6302c.mo247a();
        this.f6301a = this.f6303d.schedule(runnable, j, TimeUnit.MILLISECONDS);
    }

    private void m6718c() {
        if (this.f6301a != null) {
            this.f6301a.cancel(false);
            this.f6301a = null;
        }
    }

    public final FilteringState m6725b() {
        if (this.f6301a != null) {
            return FilteringState.FILTERING;
        }
        return this.f6302c.b();
    }

    public final void mo247a() {
        this.f6302c.mo247a();
    }
}
