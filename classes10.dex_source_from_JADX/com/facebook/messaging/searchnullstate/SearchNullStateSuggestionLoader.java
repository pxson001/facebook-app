package com.facebook.messaging.searchnullstate;

import android.util.Pair;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.executors.ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.common.loader.AbstractListenableFutureFbLoader;
import com.facebook.common.loader.AbstractListenableFutureFbLoader.LoaderResult;
import com.facebook.common.util.CollectionUtil;
import com.facebook.contacts.graphql.contactprofiletype.ContactProfileType;
import com.facebook.contacts.iterator.ContactCursorsQuery;
import com.facebook.contacts.iterator.UserIterators;
import com.facebook.contacts.picker.UserComparatorByRankingAndName;
import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.business.pages.BusinessPagesHandler;
import com.facebook.messaging.business.search.BusinessSearchGatekeeperUtil;
import com.facebook.messaging.business.search.BusinessSearchHandler;
import com.facebook.messaging.contacts.loader.ContactPickerConstants;
import com.facebook.messaging.database.threads.ThreadSummaryCursorUtil.Iterator;
import com.facebook.messaging.database.threads.ThreadSummaryIterators;
import com.facebook.messaging.model.threads.ThreadSummaryBuilder;
import com.facebook.messaging.searchnullstate.ContactPickerHScrollItemData.DataSource;
import com.facebook.messaging.sms.abtest.SmsIntegrationState;
import com.facebook.messaging.sms.abtest.SmsTakeoverMultiverseExperimentHelper;
import com.facebook.messaging.sms.contacts.PhoneContactsLoader;
import com.facebook.messaging.sms.contacts.PhoneContactsLoader.CallerContext;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.tools.dextr.runtime.detour.TracerDetour;
import com.facebook.user.model.User;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import javax.inject.Inject;

/* compiled from: ref_mechanism */
public class SearchNullStateSuggestionLoader extends AbstractListenableFutureFbLoader<Void, Result> {
    private final UserIterators f3844a;
    private final ListeningExecutorService f3845b;
    private final ThreadSummaryIterators f3846c;
    public final QeAccessor f3847d;
    private final BusinessPagesHandler f3848e;
    private final BusinessSearchHandler f3849f;
    private final BusinessSearchGatekeeperUtil f3850g;
    private final AbstractFbErrorReporter f3851h;
    private final SmsIntegrationState f3852i;
    private final PhoneContactsLoader f3853j;
    private final SmsTakeoverMultiverseExperimentHelper f3854k;
    public final GatekeeperStoreImpl f3855l;

    /* compiled from: ref_mechanism */
    class C05901 implements Callable<Result> {
        final /* synthetic */ SearchNullStateSuggestionLoader f3838a;

        C05901(SearchNullStateSuggestionLoader searchNullStateSuggestionLoader) {
            this.f3838a = searchNullStateSuggestionLoader;
        }

        public Object call() {
            boolean z;
            ImmutableList k;
            ImmutableList l;
            ImmutableList immutableList = null;
            Pair h = SearchNullStateSuggestionLoader.m3612h(this.f3838a);
            boolean z2 = this.f3838a.f3855l.a(174, false) && this.f3838a.f3847d.a(ExperimentsForMessagingSearchNullStateModule.f3835b, false);
            if (!z2 && this.f3838a.f3855l.a(174, false) && this.f3838a.f3847d.a(ExperimentsForMessagingSearchNullStateModule.f3836c, false)) {
                z = true;
            } else {
                z = false;
            }
            boolean a = this.f3838a.f3855l.a(170, false);
            ImmutableList immutableList2 = (ImmutableList) h.first;
            if (z) {
                k = SearchNullStateSuggestionLoader.m3615k(this.f3838a);
            } else {
                k = null;
            }
            ImmutableList immutableList3 = (ImmutableList) h.second;
            if (z2) {
                l = SearchNullStateSuggestionLoader.m3616l(this.f3838a);
            } else {
                l = null;
            }
            if (a) {
                immutableList = SearchNullStateSuggestionLoader.m3617m(this.f3838a);
            }
            return new Result(immutableList2, k, immutableList3, l, immutableList);
        }
    }

    /* compiled from: ref_mechanism */
    public class Result {
        public final ImmutableList<ContactPickerHScrollItemData> f3839a;
        public final ImmutableList<ContactPickerHScrollItemData> f3840b;
        public final ImmutableList<User> f3841c;
        public final ImmutableList<ContactPickerHScrollItemData> f3842d;
        public final ImmutableList<ContactPickerHScrollItemData> f3843e;

        private Result(ImmutableList<ContactPickerHScrollItemData> immutableList, ImmutableList<ContactPickerHScrollItemData> immutableList2, ImmutableList<User> immutableList3, ImmutableList<ContactPickerHScrollItemData> immutableList4, ImmutableList<ContactPickerHScrollItemData> immutableList5) {
            this.f3839a = immutableList;
            this.f3840b = immutableList2;
            this.f3841c = immutableList3;
            this.f3842d = immutableList4;
            this.f3843e = immutableList5;
        }
    }

    private static SearchNullStateSuggestionLoader m3611b(InjectorLike injectorLike) {
        return new SearchNullStateSuggestionLoader(BusinessSearchHandler.b(injectorLike), BusinessSearchGatekeeperUtil.b(injectorLike), ThreadSummaryIterators.a(injectorLike), ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider.a(injectorLike), (Executor) ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.a(injectorLike), UserIterators.a(injectorLike), (QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike), BusinessPagesHandler.b(injectorLike), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike), SmsIntegrationState.a(injectorLike), PhoneContactsLoader.b(injectorLike), SmsTakeoverMultiverseExperimentHelper.b(injectorLike), GatekeeperStoreImplMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public SearchNullStateSuggestionLoader(BusinessSearchHandler businessSearchHandler, BusinessSearchGatekeeperUtil businessSearchGatekeeperUtil, ThreadSummaryIterators threadSummaryIterators, ListeningExecutorService listeningExecutorService, Executor executor, UserIterators userIterators, QeAccessor qeAccessor, BusinessPagesHandler businessPagesHandler, AbstractFbErrorReporter abstractFbErrorReporter, SmsIntegrationState smsIntegrationState, PhoneContactsLoader phoneContactsLoader, SmsTakeoverMultiverseExperimentHelper smsTakeoverMultiverseExperimentHelper, GatekeeperStoreImpl gatekeeperStoreImpl) {
        super(executor);
        this.f3849f = businessSearchHandler;
        this.f3850g = businessSearchGatekeeperUtil;
        this.f3846c = threadSummaryIterators;
        this.f3845b = listeningExecutorService;
        this.f3844a = userIterators;
        this.f3847d = qeAccessor;
        this.f3848e = businessPagesHandler;
        this.f3851h = abstractFbErrorReporter;
        this.f3852i = smsIntegrationState;
        this.f3853j = phoneContactsLoader;
        this.f3854k = smsTakeoverMultiverseExperimentHelper;
        this.f3855l = gatekeeperStoreImpl;
    }

    protected final LoaderResult m3619b(Object obj) {
        return AbstractListenableFutureFbLoader.a;
    }

    protected final ListenableFuture m3618a(Object obj, LoaderResult loaderResult) {
        return this.f3845b.a(new C05901(this));
    }

    public static Pair m3612h(SearchNullStateSuggestionLoader searchNullStateSuggestionLoader) {
        User a;
        Builder builder = ImmutableList.builder();
        Builder builder2 = ImmutableList.builder();
        if (searchNullStateSuggestionLoader.f3850g.a()) {
            try {
                a = searchNullStateSuggestionLoader.f3849f.a();
                if (a != null) {
                    builder2.c(a);
                }
            } catch (Throwable e) {
                searchNullStateSuggestionLoader.f3851h.a("Failed to add M to suggestions.", e);
            }
        }
        List<User> i = searchNullStateSuggestionLoader.m3613i();
        int a2 = searchNullStateSuggestionLoader.f3847d.a(ExperimentsForMessagingSearchNullStateModule.f3834a, 20);
        int i2 = 0;
        for (User a3 : i) {
            if (i2 >= 40) {
                break;
            }
            if (i2 < a2) {
                builder.c(new ContactPickerHScrollItemData(a3, DataSource.TOP_FRIENDS));
            } else {
                builder2.c(a3);
            }
            i2++;
        }
        return new Pair(builder.b(), builder2.b());
    }

    private List<User> m3613i() {
        List j = m3614j();
        if (this.f3852i.a() || this.f3854k.u()) {
            return m3610a(j, this.f3853j.a(10, CallerContext.NULL_STATE));
        }
        return j;
    }

    private List<User> m3614j() {
        TracerDetour.a("getTopFriends", -445871866);
        try {
            List<User> b = this.f3844a.b(ContactCursorsQuery.b(ContactProfileType.MESSAGABLE_TYPES, 40));
            return b;
        } finally {
            TracerDetour.a(1763540115);
        }
    }

    public static ImmutableList m3615k(SearchNullStateSuggestionLoader searchNullStateSuggestionLoader) {
        TracerDetour.a("getGroupThreads", -433360170);
        try {
            Builder builder = ImmutableList.builder();
            Iterator a = searchNullStateSuggestionLoader.f3846c.a("group_chat_rank", ContactPickerConstants.a);
            while (true) {
                try {
                    ThreadSummaryBuilder a2 = a.a();
                    if (a2 == null) {
                        break;
                    }
                    builder.c(new ContactPickerHScrollItemData(a2.V(), DataSource.GROUP_THREADS));
                } finally {
                    a.d();
                }
            }
            ImmutableList b = builder.b();
            return b;
        } finally {
            TracerDetour.a(-1695022227);
        }
    }

    public static ImmutableList m3616l(SearchNullStateSuggestionLoader searchNullStateSuggestionLoader) {
        ImmutableList b;
        TracerDetour.a("getSuggestedBusinesses", -931712075);
        try {
            Builder builder = ImmutableList.builder();
            ImmutableList a = searchNullStateSuggestionLoader.f3848e.a(20);
            if (a != null) {
                int size = a.size();
                for (int i = 0; i < size; i++) {
                    builder.c(new ContactPickerHScrollItemData((User) a.get(i), DataSource.BYMM));
                }
            }
            b = builder.b();
        } catch (Throwable e) {
            searchNullStateSuggestionLoader.f3851h.a("SearchNullStateSuggestionLoader", "getSuggestedBusinesses failed", e);
            b = ImmutableList.of();
        } finally {
            TracerDetour.a(-1019850671);
        }
        return b;
    }

    public static ImmutableList m3617m(SearchNullStateSuggestionLoader searchNullStateSuggestionLoader) {
        ImmutableList b;
        TracerDetour.a("getSuggestedBots", 1953577055);
        try {
            Builder builder = ImmutableList.builder();
            ImmutableList b2 = searchNullStateSuggestionLoader.f3848e.b(20);
            if (b2 != null) {
                int size = b2.size();
                for (int i = 0; i < size; i++) {
                    builder.c(new ContactPickerHScrollItemData((User) b2.get(i), DataSource.BOTS));
                }
            }
            b = builder.b();
        } catch (Throwable e) {
            searchNullStateSuggestionLoader.f3851h.a("SearchNullStateSuggestionLoader", "getSuggestedBots failed", e);
            b = ImmutableList.of();
        } finally {
            TracerDetour.a(925437684);
        }
        return b;
    }

    private static List<User> m3610a(List<User> list, ImmutableList<User> immutableList) {
        if (CollectionUtil.a(immutableList)) {
            return list;
        }
        if (CollectionUtil.a(list)) {
            return new ArrayList(immutableList);
        }
        List<User> arrayList = new ArrayList(list.size() + immutableList.size());
        arrayList.addAll(list);
        arrayList.addAll(immutableList);
        Collections.sort(arrayList, new UserComparatorByRankingAndName(arrayList));
        return arrayList;
    }
}
