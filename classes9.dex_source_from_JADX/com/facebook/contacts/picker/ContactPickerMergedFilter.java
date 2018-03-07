package com.facebook.contacts.picker;

import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.time.Clock;
import com.facebook.contacts.picker.ContactPickerFilterResult.RowResult;
import com.facebook.contacts.picker.ContactPickerFilterResult.Type;
import com.facebook.contacts.picker.ContactPickerListFilter.RowCreator;
import com.facebook.user.model.UserIdentifier;
import com.facebook.widget.filter.CustomFilter.FilterListener;
import com.facebook.widget.filter.CustomFilter.FilteringState;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;

/* compiled from: predicted_topics */
public class ContactPickerMergedFilter implements ContactPickerListFilter {
    private static final Class<?> f6352a = ContactPickerMergedFilter.class;
    public final ImmutableList<ContactPickerFilterInstance> f6353b;
    public final Clock f6354c;
    private final ScheduledExecutorService f6355d;
    private final AbstractFbErrorReporter f6356e;
    private ContactPickerListFilterReceiver f6357f;
    public FilterListener f6358g;
    public FilteringState f6359h = FilteringState.FINISHED;
    private int f6360i = 0;
    @GuardedBy("ui thread")
    @Nullable
    public CharSequence f6361j;
    public ScheduledFuture<?> f6362k;

    /* compiled from: predicted_topics */
    class C06543 implements Runnable {
        final /* synthetic */ ContactPickerMergedFilter f6338a;

        C06543(ContactPickerMergedFilter contactPickerMergedFilter) {
            this.f6338a = contactPickerMergedFilter;
        }

        public void run() {
            this.f6338a.f6362k = null;
            ContactPickerMergedFilter.m6764d(this.f6338a);
        }
    }

    @VisibleForTesting
    /* compiled from: predicted_topics */
    public class ContactPickerFilterInstance {
        final String f6340a;
        public final ContactPickerListFilter f6341b;
        @Nullable
        public final String f6342c;
        private final boolean f6343d;
        public ContactPickerFilterResult f6344e;
        public FilteringState f6345f = FilteringState.FINISHED;
        public boolean f6346g = false;
        public ContactPickerFilterResult f6347h = null;
        public long f6348i = -1;

        public ContactPickerFilterInstance(ContactPickerSubFilterConfig contactPickerSubFilterConfig) {
            this.f6341b = contactPickerSubFilterConfig.f6349a;
            this.f6342c = contactPickerSubFilterConfig.f6350b;
            this.f6343d = contactPickerSubFilterConfig.f6351c;
            this.f6340a = this.f6341b.getClass().getSimpleName();
        }

        public final boolean m6753c() {
            return this.f6343d;
        }

        public final FilteringState m6755e() {
            return this.f6345f;
        }

        public final long m6756f() {
            return this.f6348i;
        }

        public final void m6757g() {
            this.f6346g = true;
            this.f6347h = this.f6344e;
        }

        public final ContactPickerFilterResult m6754d() {
            return this.f6346g ? this.f6347h : this.f6344e;
        }

        public final boolean m6758h() {
            return this.f6346g;
        }
    }

    /* compiled from: predicted_topics */
    public class ContactPickerSubFilterConfig {
        public final ContactPickerListFilter f6349a;
        @Nullable
        public final String f6350b;
        public final boolean f6351c;

        public ContactPickerSubFilterConfig(ContactPickerListFilter contactPickerListFilter, @Nullable String str, boolean z) {
            this.f6349a = contactPickerListFilter;
            this.f6350b = str;
            this.f6351c = z;
        }
    }

    public ContactPickerMergedFilter(ImmutableList<ContactPickerSubFilterConfig> immutableList, Clock clock, ScheduledExecutorService scheduledExecutorService, FbErrorReporter fbErrorReporter) {
        Builder builder = ImmutableList.builder();
        int size = immutableList.size();
        for (int i = 0; i < size; i++) {
            ContactPickerSubFilterConfig contactPickerSubFilterConfig = (ContactPickerSubFilterConfig) immutableList.get(i);
            builder.c(new ContactPickerFilterInstance(contactPickerSubFilterConfig));
            this.f6360i = (contactPickerSubFilterConfig.f6351c ? 1 : 0) + this.f6360i;
        }
        this.f6353b = builder.b();
        this.f6354c = clock;
        this.f6355d = scheduledExecutorService;
        this.f6356e = fbErrorReporter;
    }

    public final void mo245a(ContactPickerListFilterReceiver contactPickerListFilterReceiver) {
        this.f6357f = contactPickerListFilterReceiver;
        int size = this.f6353b.size();
        for (int i = 0; i < size; i++) {
            final ContactPickerFilterInstance contactPickerFilterInstance = (ContactPickerFilterInstance) this.f6353b.get(i);
            contactPickerFilterInstance.f6341b.mo245a(new ContactPickerListFilterReceiver(this) {
                final /* synthetic */ ContactPickerMergedFilter f6335b;

                public final void mo251a(@Nullable CharSequence charSequence, ContactPickerFilterResult contactPickerFilterResult) {
                    if (ContactPickerMergedFilter.m6763b(charSequence, this.f6335b.f6361j)) {
                        contactPickerFilterInstance.f6344e = contactPickerFilterResult;
                        ContactPickerMergedFilter.m6764d(this.f6335b);
                    }
                }
            });
        }
    }

    public final void mo246a(ImmutableList<UserIdentifier> immutableList) {
        int size = this.f6353b.size();
        for (int i = 0; i < size; i++) {
            ((ContactPickerFilterInstance) this.f6353b.get(i)).f6341b.mo246a((ImmutableList) immutableList);
        }
    }

    public final void mo244a(RowCreator rowCreator) {
        int size = this.f6353b.size();
        for (int i = 0; i < size; i++) {
            ((ContactPickerFilterInstance) this.f6353b.get(i)).f6341b.mo244a(rowCreator);
        }
    }

    public final void m6770a(CharSequence charSequence) {
        m6771a(charSequence, null);
    }

    public final void m6771a(@Nullable CharSequence charSequence, FilterListener filterListener) {
        this.f6358g = filterListener;
        this.f6361j = charSequence;
        int size = this.f6353b.size();
        for (int i = 0; i < size; i++) {
            final ContactPickerFilterInstance contactPickerFilterInstance = (ContactPickerFilterInstance) this.f6353b.get(i);
            C06532 c06532 = new FilterListener(this) {
                final /* synthetic */ ContactPickerMergedFilter f6337b;

                public final void m6751a(int i) {
                }

                public final void m6752a(FilteringState filteringState) {
                    FilteringState filteringState2;
                    contactPickerFilterInstance.f6345f = filteringState;
                    if (filteringState == FilteringState.FINISHED) {
                        contactPickerFilterInstance.f6348i = this.f6337b.f6354c.a();
                        ContactPickerMergedFilter.m6764d(this.f6337b);
                    }
                    ContactPickerMergedFilter contactPickerMergedFilter = this.f6337b;
                    FilteringState filteringState3 = FilteringState.FINISHED;
                    int size = contactPickerMergedFilter.f6353b.size();
                    for (int i = 0; i < size; i++) {
                        ContactPickerFilterInstance contactPickerFilterInstance = (ContactPickerFilterInstance) contactPickerMergedFilter.f6353b.get(i);
                        if (!contactPickerFilterInstance.f6346g && FilteringState.FILTERING == contactPickerFilterInstance.f6345f) {
                            filteringState2 = FilteringState.FILTERING;
                            break;
                        }
                    }
                    filteringState2 = filteringState3;
                    if (filteringState2 != contactPickerMergedFilter.f6359h) {
                        contactPickerMergedFilter.f6359h = filteringState2;
                        if (contactPickerMergedFilter.f6358g != null) {
                            contactPickerMergedFilter.f6358g.a(contactPickerMergedFilter.f6359h);
                        }
                    }
                }
            };
            contactPickerFilterInstance.f6346g = false;
            contactPickerFilterInstance.f6347h = null;
            contactPickerFilterInstance.f6348i = -1;
            contactPickerFilterInstance.f6341b.a(charSequence, c06532);
        }
    }

    public static void m6764d(ContactPickerMergedFilter contactPickerMergedFilter) {
        ContactPickerFilterResult e = contactPickerMergedFilter.m6765e();
        if (e != null) {
            contactPickerMergedFilter.f6357f.mo251a(contactPickerMergedFilter.f6361j, e);
            if (contactPickerMergedFilter.f6358g != null) {
                int i;
                switch (e.f6307a) {
                    case EMPTY_CONSTRAINT:
                        i = -1;
                        break;
                    case OK:
                        i = e.f6310d;
                        break;
                    default:
                        i = 0;
                        break;
                }
                contactPickerMergedFilter.f6358g.a(i);
            }
        }
    }

    private ContactPickerFilterResult m6765e() {
        ContactPickerFilterResult d = ((ContactPickerFilterInstance) this.f6353b.get(0)).m6754d();
        if (d == null || !m6763b(this.f6361j, d.m6731b())) {
            return null;
        }
        if (d.m6730a() == Type.EMPTY_CONSTRAINT || d.m6730a() == Type.EXCEPTION) {
            return d;
        }
        String str;
        Set a = Sets.a();
        Builder builder = ImmutableList.builder();
        List<ContactPickerFilterInstance> a2 = Lists.a(this.f6353b.size());
        if (this.f6362k != null) {
            this.f6362k.cancel(false);
            this.f6362k = null;
        }
        int size = this.f6353b.size();
        for (int i = 0; i < size; i++) {
            ContactPickerFilterInstance contactPickerFilterInstance = (ContactPickerFilterInstance) this.f6353b.get(i);
            if ((contactPickerFilterInstance.m6755e() == FilteringState.FINISHED || contactPickerFilterInstance.m6758h()) && contactPickerFilterInstance.m6756f() != -1) {
                FilteringState filteringState = FilteringState.FINISHED;
                if (!a2.isEmpty()) {
                    Integer.valueOf(a2.size());
                    long f = contactPickerFilterInstance.m6756f();
                    long a3 = this.f6354c.a();
                    if (a3 - f < 4000) {
                        this.f6362k = this.f6355d.schedule(new C06543(this), 4000 - (a3 - f), TimeUnit.MILLISECONDS);
                        str = null;
                        break;
                    }
                    for (ContactPickerFilterInstance contactPickerFilterInstance2 : a2) {
                        contactPickerFilterInstance2.m6757g();
                        m6761a(contactPickerFilterInstance2, a, builder);
                    }
                    a2.clear();
                }
                m6761a(contactPickerFilterInstance, a, builder);
            } else {
                if (contactPickerFilterInstance.m6755e() == FilteringState.FINISHED && contactPickerFilterInstance.m6756f() == -1) {
                    this.f6356e.a("ContactPickerMergedFilter", m6760a(contactPickerFilterInstance));
                }
                a2.add(contactPickerFilterInstance);
                if (contactPickerFilterInstance.m6753c()) {
                    str = contactPickerFilterInstance.f6340a;
                    break;
                }
            }
        }
        str = null;
        if (!a2.isEmpty()) {
            m6761a((ContactPickerFilterInstance) a2.get(0), a, builder);
        }
        if (this.f6360i <= 1 || !a.isEmpty() || r3 == null) {
            return ContactPickerFilterResult.m6727a(this.f6361j, builder.b());
        }
        return null;
    }

    private String m6760a(ContactPickerFilterInstance contactPickerFilterInstance) {
        StringBuilder append = new StringBuilder(200).append("Bad results: [");
        int size = this.f6353b.size();
        for (int i = 0; i < size; i++) {
            ContactPickerFilterInstance contactPickerFilterInstance2 = (ContactPickerFilterInstance) this.f6353b.get(i);
            append.append(contactPickerFilterInstance2.f6340a);
            if (contactPickerFilterInstance2 == contactPickerFilterInstance) {
                append.append("*");
            }
            append.append(" : ").append(contactPickerFilterInstance2.m6754d()).append(", ");
        }
        append.append("]");
        return append.toString();
    }

    @VisibleForTesting
    private void m6761a(ContactPickerFilterInstance contactPickerFilterInstance, Set<ContactPickerFilterRowIdentifier> set, Builder<ContactPickerRow> builder) {
        ContactPickerFilterResult d = contactPickerFilterInstance.m6754d();
        if (d != null && d.f6307a == Type.OK && m6763b(this.f6361j, d.f6308b)) {
            m6762a(d.f6309c, builder, set, contactPickerFilterInstance.f6342c);
        }
    }

    private static void m6762a(ImmutableList<RowResult> immutableList, Builder<ContactPickerRow> builder, Set<ContactPickerFilterRowIdentifier> set, @Nullable String str) {
        Object obj = null;
        int size = immutableList.size();
        for (int i = 0; i < size; i++) {
            RowResult rowResult = (RowResult) immutableList.get(i);
            Object obj2 = null;
            ImmutableList immutableList2 = rowResult.f6305a;
            int size2 = immutableList2.size();
            int i2 = 0;
            while (i2 < size2) {
                Object obj3;
                ContactPickerRow contactPickerRow = (ContactPickerRow) immutableList2.get(i2);
                ContactPickerFilterRowIdentifier a = m6759a(contactPickerRow);
                if (a == null || !set.contains(a)) {
                    if (a != null) {
                        set.add(a);
                    }
                    if (obj == null && str != null) {
                        builder.c(new ContactPickerSectionHeaderRow(str));
                    }
                    if (obj2 == null && rowResult.f6306b != null) {
                        builder.c(new ContactPickerSectionHeaderRow(rowResult.f6306b));
                    }
                    builder.c(contactPickerRow);
                    obj2 = 1;
                    obj3 = 1;
                } else {
                    obj3 = obj2;
                    obj2 = obj;
                }
                i2++;
                obj = obj2;
                obj2 = obj3;
            }
        }
    }

    @Nullable
    private static ContactPickerFilterRowIdentifier m6759a(ContactPickerRow contactPickerRow) {
        if (contactPickerRow instanceof ContactPickerGroupRow) {
            return new ContactPickerFilterRowIdentifier(ContactPickerFilterRowIdentifier.m6734a("thread_key", ((ContactPickerGroupRow) contactPickerRow).f6312a.a.g()));
        }
        if (!(contactPickerRow instanceof ContactPickerUserRow)) {
            return null;
        }
        return new ContactPickerFilterRowIdentifier(ContactPickerFilterRowIdentifier.m6734a("user_id", ((ContactPickerUserRow) contactPickerRow).f6386a.a));
    }

    public final FilteringState m6772b() {
        return this.f6359h;
    }

    public static boolean m6763b(@Nullable CharSequence charSequence, @Nullable CharSequence charSequence2) {
        if (charSequence == null) {
            return charSequence2 == null;
        } else {
            if (charSequence2 != null) {
                return charSequence.toString().equals(charSequence2.toString());
            }
            return false;
        }
    }

    public final void mo247a() {
        int size = this.f6353b.size();
        for (int i = 0; i < size; i++) {
            ((ContactPickerFilterInstance) this.f6353b.get(i)).f6341b.mo247a();
        }
    }
}
