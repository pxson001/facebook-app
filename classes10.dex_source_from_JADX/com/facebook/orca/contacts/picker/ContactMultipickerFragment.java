package com.facebook.orca.contacts.picker;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.TransitionDrawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver.OnGlobalFocusChangeListener;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.FrameLayout;
import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.auth.annotations.IsMeUserAMessengerOnlyUser;
import com.facebook.auth.annotations.LoggedInUser;
import com.facebook.base.fragment.FbFragment;
import com.facebook.common.appchoreographer.AppChoreographer;
import com.facebook.common.appchoreographer.DefaultAppChoreographer;
import com.facebook.common.build.IsWorkBuild;
import com.facebook.common.loader.FbLoader.Callback;
import com.facebook.common.util.CollectionUtil;
import com.facebook.common.util.ContextUtils;
import com.facebook.common.util.FindViewUtil;
import com.facebook.contacts.picker.BaseSearchableContactPickerListAdapter;
import com.facebook.contacts.picker.ContactPickerGroupRow;
import com.facebook.contacts.picker.ContactPickerListFilter.RowCreator;
import com.facebook.contacts.picker.ContactPickerRow;
import com.facebook.contacts.picker.ContactPickerSectionHeaderRow;
import com.facebook.contacts.picker.ContactPickerUserRow;
import com.facebook.contacts.picker.ContactPickerUserRow.ContactRowSectionType;
import com.facebook.contacts.picker.ContactPickerUserRow.PushableType;
import com.facebook.contacts.picker.ContactPickerUserRow.RowStyle;
import com.facebook.contacts.picker.ContactPickerUserRowBuilder;
import com.facebook.contacts.picker.PickableContactPickerRow;
import com.facebook.contacts.picker.SuggestionType;
import com.facebook.contacts.picker.SuggestionsCache;
import com.facebook.contacts.picker.UserComparatorByRankingAndName;
import com.facebook.debug.log.BLog;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.messaging.activity.CheckBeforeLeaveActivity;
import com.facebook.messaging.activity.CheckBeforeLeaveActivity.LeaveCheckListener;
import com.facebook.messaging.analytics.search.FilterSessionManager;
import com.facebook.messaging.annotations.ForContactMultiPicker;
import com.facebook.messaging.contacts.loader.ContactsLoader;
import com.facebook.messaging.contacts.loader.ContactsLoader.FriendLists;
import com.facebook.messaging.contacts.loader.ContactsLoader.InitParams;
import com.facebook.messaging.contacts.loader.ContactsLoader.Result;
import com.facebook.messaging.contacts.loader.ContactsLoaderFactory;
import com.facebook.messaging.contacts.picker.DefaultMultiPickerRowCreator;
import com.facebook.messaging.contacts.picker.DefaultMultiPickerRowCreator.C03431;
import com.facebook.messaging.contacts.picker.MultiPickerRowCreator;
import com.facebook.messaging.model.threadkey.ThreadKey;
import com.facebook.messaging.model.threads.ThreadSummary;
import com.facebook.messaging.threadview.util.ThreadViewOpenHelper;
import com.facebook.orca.contacts.picker.ContactPickerFragment.ListType;
import com.facebook.orca.contacts.picker.ContactPickerFragment.Mode;
import com.facebook.orca.contacts.picker.ContactPickerFragment.OnContactPickerTextChangedListener;
import com.facebook.orca.contacts.picker.ContactPickerFragment.OnMaxRecipientReachedListener;
import com.facebook.orca.contacts.picker.ContactPickerFragment.OnRowClickedListener;
import com.facebook.orca.contacts.picker.ContactsLoadBroadcastsRegisterHelper.C09261;
import com.facebook.qe.api.ExposureLogging;
import com.facebook.qe.api.Liveness;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.rtc.fbwebrtc.abtests.ExperimentsForRtcModule;
import com.facebook.tools.dextr.runtime.detour.AdapterDetour;
import com.facebook.tools.dextr.runtime.detour.ExecutorDetour;
import com.facebook.ultralight.Inject;
import com.facebook.user.model.User;
import com.facebook.user.model.UserIdentifier;
import com.facebook.user.model.UserKey;
import com.facebook.widget.listview.BetterListView;
import com.facebook.widget.tokenizedtypeahead.TokenizedAutoCompleteTextView;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.RegularImmutableList;
import com.google.common.collect.RegularImmutableSet;
import com.google.common.collect.Sets;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.annotation.Nullable;
import javax.inject.Provider;

/* compiled from: oAuthToken */
public class ContactMultipickerFragment extends FbFragment {
    public static final Class<?> f6025a = ContactMultipickerFragment.class;
    private OnContactPickerTextChangedListener aA;
    private OnMaxRecipientReachedListener aB;
    private OnRowClickedListener aC;
    private OnGlobalFocusChangeListener aD;
    private boolean aE;
    public ImmutableList<User> aF;
    private final ArrayList<String> aG = new ArrayList();
    private final ArrayList<ImmutableList<User>> aH = new ArrayList();
    public FilterMode aI = FilterMode.DROP_DOWN;
    public boolean aJ = true;
    private boolean aK = true;
    private boolean aL = false;
    private boolean aM = false;
    private boolean aN = false;
    private boolean aO = true;
    private boolean aP;
    private int aQ = -1;
    @Inject
    private DefaultMultiPickerRowCreator al;
    @Inject
    @LoggedInUser
    private Provider<User> am;
    @Inject
    private QeAccessor an;
    @Inject
    private SuggestionsCache ao;
    @Inject
    public ThreadViewOpenHelper ap;
    @IsMeUserAMessengerOnlyUser
    @Inject
    private Provider<Boolean> aq;
    @IsWorkBuild
    @Inject
    private Provider<Boolean> ar;
    private String as;
    public ContactPickerFragment at;
    private View au;
    private FrameLayout av;
    private BetterListView aw;
    private TokenizedAutoCompleteTextView ax;
    private Callback<Void, Result, Throwable> ay;
    private RowCreator az;
    private Context f6026b;
    @Inject
    private AnalyticsLogger f6027c;
    @Inject
    public DefaultAppChoreographer f6028d;
    @ForContactMultiPicker
    @Inject
    private BaseSearchableContactPickerListAdapter f6029e;
    @Inject
    private ContactsLoadBroadcastsRegisterHelper f6030f;
    @Inject
    private ContactsLoaderFactory f6031g;
    @Inject
    public ContactsLoader f6032h;
    @Inject
    public FilterSessionManager f6033i;

    /* compiled from: oAuthToken */
    class C09091 implements Callback<Void, Result, Throwable> {
        final /* synthetic */ ContactMultipickerFragment f6016a;

        public final void m5664c(Object obj, Object obj2) {
            Class cls = ContactMultipickerFragment.f6025a;
        }

        C09091(ContactMultipickerFragment contactMultipickerFragment) {
            this.f6016a = contactMultipickerFragment;
        }

        public final void m5663b(Object obj, Object obj2) {
            Result result = (Result) obj2;
            Class cls = ContactMultipickerFragment.f6025a;
            this.f6016a.m5680a(result);
        }

        public final void m5661a(Object obj, ListenableFuture listenableFuture) {
            this.f6016a.f6028d.a(listenableFuture);
        }
    }

    /* compiled from: oAuthToken */
    class C09102 implements OnContactPickerTextChangedListener {
        final /* synthetic */ ContactMultipickerFragment f6017a;

        C09102(ContactMultipickerFragment contactMultipickerFragment) {
            this.f6017a = contactMultipickerFragment;
        }

        public final void mo223a(String str, boolean z) {
            this.f6017a.f6033i.a(str);
            switch (this.f6017a.aI) {
                case DROP_DOWN:
                    ContactMultipickerFragment.m5695b(this.f6017a, z);
                    return;
                case INLINE:
                    ContactMultipickerFragment.au(this.f6017a);
                    return;
                default:
                    throw new IllegalStateException("Invalid filter mode : " + this.f6017a.aI);
            }
        }
    }

    /* compiled from: oAuthToken */
    class C09113 implements OnMaxRecipientReachedListener {
        final /* synthetic */ ContactMultipickerFragment f6018a;

        C09113(ContactMultipickerFragment contactMultipickerFragment) {
            this.f6018a = contactMultipickerFragment;
        }

        public final void mo224a() {
            this.f6018a.m5717e();
        }
    }

    /* compiled from: oAuthToken */
    class C09124 implements OnRowClickedListener {
        final /* synthetic */ ContactMultipickerFragment f6019a;

        C09124(ContactMultipickerFragment contactMultipickerFragment) {
            this.f6019a = contactMultipickerFragment;
        }

        public final void mo225a(ContactPickerRow contactPickerRow) {
            if (contactPickerRow instanceof ContactPickerGroupRow) {
                this.f6019a.m5681a(((ContactPickerGroupRow) contactPickerRow).a);
            }
        }
    }

    /* compiled from: oAuthToken */
    public class C09135 {
        final /* synthetic */ ContactMultipickerFragment f6020a;

        C09135(ContactMultipickerFragment contactMultipickerFragment) {
            this.f6020a = contactMultipickerFragment;
        }

        public final void m5671a(Intent intent) {
            if (intent.getAction() == "com.facebook.rtc.fbwebrtc.CALL_LOG_UPDATED") {
                this.f6020a.aF = null;
                this.f6020a.f6032h.a();
            }
            ContactMultipickerFragment.ax(this.f6020a);
            this.f6020a.as();
        }
    }

    /* compiled from: oAuthToken */
    class C09146 implements OnGlobalFocusChangeListener {
        final /* synthetic */ ContactMultipickerFragment f6021a;

        C09146(ContactMultipickerFragment contactMultipickerFragment) {
            this.f6021a = contactMultipickerFragment;
        }

        public void onGlobalFocusChanged(View view, View view2) {
            this.f6021a.m5694b(view2);
        }
    }

    /* compiled from: oAuthToken */
    class C09157 implements OnClickListener {
        final /* synthetic */ ContactMultipickerFragment f6022a;

        C09157(ContactMultipickerFragment contactMultipickerFragment) {
            this.f6022a = contactMultipickerFragment;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -2145071991);
            this.f6022a.m5717e();
            Logger.a(2, EntryType.UI_INPUT_END, -547060492, a);
        }
    }

    /* compiled from: oAuthToken */
    class C09168 implements OnScrollListener {
        final /* synthetic */ ContactMultipickerFragment f6023a;

        C09168(ContactMultipickerFragment contactMultipickerFragment) {
            this.f6023a = contactMultipickerFragment;
        }

        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (i == 1) {
                this.f6023a.at.ax();
            }
        }

        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        }
    }

    /* compiled from: oAuthToken */
    class C09179 implements OnItemClickListener {
        final /* synthetic */ ContactMultipickerFragment f6024a;

        C09179(ContactMultipickerFragment contactMultipickerFragment) {
            this.f6024a = contactMultipickerFragment;
        }

        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            ContactMultipickerFragment.m5702g(this.f6024a, i);
        }
    }

    /* compiled from: oAuthToken */
    public enum FilterMode {
        DROP_DOWN,
        INLINE
    }

    @Deprecated
    private static <T> void m5687a(Class<T> cls, T t, Context context) {
        m5688a((Object) t, context);
    }

    public static void m5688a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((ContactMultipickerFragment) obj).m5677a(AnalyticsLoggerMethodAutoProvider.a(fbInjector), DefaultAppChoreographer.a(fbInjector), C0898xf6633a8.m5652b(fbInjector), ContactsLoadBroadcastsRegisterHelper.m5786b(fbInjector), ContactsLoaderFactory.a(fbInjector), ContactsLoader.b(fbInjector), FilterSessionManager.b(fbInjector), DefaultMultiPickerRowCreator.m1878b(fbInjector), IdBasedProvider.a(fbInjector, 3595), (QeAccessor) QeInternalImplMethodAutoProvider.a(fbInjector), SuggestionsCache.a(fbInjector), ThreadViewOpenHelper.b(fbInjector), IdBasedProvider.a(fbInjector, 3900), IdBasedSingletonScopeProvider.a(fbInjector, 3923));
    }

    private void m5677a(AnalyticsLogger analyticsLogger, AppChoreographer appChoreographer, BaseSearchableContactPickerListAdapter baseSearchableContactPickerListAdapter, ContactsLoadBroadcastsRegisterHelper contactsLoadBroadcastsRegisterHelper, ContactsLoaderFactory contactsLoaderFactory, ContactsLoader contactsLoader, FilterSessionManager filterSessionManager, MultiPickerRowCreator multiPickerRowCreator, Provider<User> provider, QeAccessor qeAccessor, SuggestionsCache suggestionsCache, ThreadViewOpenHelper threadViewOpenHelper, Provider<Boolean> provider2, Provider<Boolean> provider3) {
        this.f6027c = analyticsLogger;
        this.f6028d = appChoreographer;
        this.f6029e = baseSearchableContactPickerListAdapter;
        this.f6030f = contactsLoadBroadcastsRegisterHelper;
        this.f6031g = contactsLoaderFactory;
        this.f6032h = contactsLoader;
        this.f6033i = filterSessionManager;
        this.al = multiPickerRowCreator;
        this.am = provider;
        this.an = qeAccessor;
        this.ao = suggestionsCache;
        this.ap = threadViewOpenHelper;
        this.aq = provider2;
        this.ar = provider3;
    }

    private void m5679a(ContactPickerUserRow contactPickerUserRow, int i) {
        User user = contactPickerUserRow.a;
        if (!this.aL) {
            boolean z = !contactPickerUserRow.d();
            if (z || this.aK) {
                if (z) {
                    this.at.m5764a(user, contactPickerUserRow, ContactRowSectionType.SUGGESTIONS, i);
                } else {
                    this.at.m5763a(user, (PickableContactPickerRow) contactPickerUserRow, i);
                }
                as();
                m5704h(z);
                this.f6033i.a(user.b.toString(), i, user.a, contactPickerUserRow.m.toString());
                this.f6033i.a("neue", this.as);
            }
        }
    }

    public final void m5714c(Bundle bundle) {
        EnumSet of;
        super.c(bundle);
        if (this.aQ > 0) {
            this.f6026b = new ContextThemeWrapper(getContext(), this.aQ);
        } else {
            this.f6026b = ContextUtils.a(getContext(), 2130772969, 2131625113);
        }
        Class cls = ContactMultipickerFragment.class;
        m5688a((Object) this, this.f6026b);
        this.ay = new C09091(this);
        ContactsLoaderFactory contactsLoaderFactory = this.f6031g;
        if (((Boolean) contactsLoaderFactory.c.get()).booleanValue()) {
            of = EnumSet.of(FriendLists.TOP_CONTACTS, FriendLists.ALL_CONTACTS_WITH_CAP);
        } else {
            of = EnumSet.of(FriendLists.TOP_CONTACTS);
        }
        of.add(FriendLists.TOP_PHONE_CONTACTS_NULL_STATE);
        if (!contactsLoaderFactory.e && contactsLoaderFactory.a.a()) {
            of.add(FriendLists.PROMOTIONAL_CONTACTS);
        }
        ContactsLoader contactsLoader = (ContactsLoader) contactsLoaderFactory.b.get();
        contactsLoader.v = new InitParams(of);
        this.f6032h = contactsLoader;
        this.f6032h.a(this.ay);
        this.az = new C03431(this.al);
        this.aA = new C09102(this);
        this.aB = new C09113(this);
        this.aC = new C09124(this);
    }

    public static void m5695b(ContactMultipickerFragment contactMultipickerFragment, boolean z) {
        if (z) {
            contactMultipickerFragment.ar();
            return;
        }
        contactMultipickerFragment.as();
        contactMultipickerFragment.aq();
    }

    public static void au(ContactMultipickerFragment contactMultipickerFragment) {
        contactMultipickerFragment.aA();
        CharSequence userEnteredPlainText = contactMultipickerFragment.ax.getUserEnteredPlainText();
        BaseSearchableContactPickerListAdapter baseSearchableContactPickerListAdapter = contactMultipickerFragment.at.aq;
        if (baseSearchableContactPickerListAdapter != null) {
            if (!TextUtils.isEmpty(userEnteredPlainText)) {
                baseSearchableContactPickerListAdapter.d().a(userEnteredPlainText);
                contactMultipickerFragment.aw.setAdapter(baseSearchableContactPickerListAdapter);
                contactMultipickerFragment.aq();
            } else if (contactMultipickerFragment.at.m5772e().isEmpty()) {
                baseSearchableContactPickerListAdapter.d().a("");
                contactMultipickerFragment.aw.setAdapter(contactMultipickerFragment.f6029e);
                contactMultipickerFragment.as();
                contactMultipickerFragment.aq();
            } else {
                contactMultipickerFragment.ar();
            }
        }
    }

    private void av() {
        C09135 c09135 = new C09135(this);
        this.f6030f.m5787a("com.facebook.contacts.ACTION_CONTACT_SYNC_PROGRESS", c09135);
        this.f6030f.m5787a("com.facebook.contacts.ACTION_CONTACT_ADDED", c09135);
        this.f6030f.m5787a("com.facebook.contacts.ACTION_CONTACT_DELETED", c09135);
        this.f6030f.m5787a("com.facebook.contacts.FAVORITE_CONTACT_SYNC_PROGRESS", c09135);
        this.f6030f.m5787a("com.facebook.rtc.fbwebrtc.CALL_LOG_UPDATED", c09135);
        ContactsLoadBroadcastsRegisterHelper contactsLoadBroadcastsRegisterHelper = this.f6030f;
        if (null != null) {
            ExecutorDetour.a(contactsLoadBroadcastsRegisterHelper.f6084h, new C09261(contactsLoadBroadcastsRegisterHelper), -2051880865);
        } else {
            contactsLoadBroadcastsRegisterHelper.f6079c.a();
        }
        contactsLoadBroadcastsRegisterHelper.f6082f = contactsLoadBroadcastsRegisterHelper.f6081e.a();
        contactsLoadBroadcastsRegisterHelper.f6082f.b();
    }

    private boolean aw() {
        QeAccessor qeAccessor = this.an;
        Liveness liveness = Liveness.Cached;
        return aF() && (!qeAccessor.a(Liveness.Cached, ExposureLogging.Off, ExperimentsForRtcModule.t, false));
    }

    public static void ax(ContactMultipickerFragment contactMultipickerFragment) {
        if (contactMultipickerFragment.aF()) {
            contactMultipickerFragment.ay();
        } else {
            contactMultipickerFragment.az();
        }
    }

    private void ay() {
        List a = this.ao.a(SuggestionType.TOP_PUSHABLE);
        List a2 = this.ao.a(SuggestionType.RECENT_CALLS);
        if (CollectionUtil.a(a) || (aw() && CollectionUtil.a(a2))) {
            this.aF = null;
            this.f6032h.a();
            return;
        }
        if (aw() && CollectionUtil.b(a2)) {
            a = m5673a((ImmutableList) a, (ImmutableList) a2);
            this.aG.add(b(2131231231));
            this.aH.add(m5675a(a2));
        }
        this.aG.add(b(2131231232));
        this.aH.add(m5675a(a));
    }

    private void az() {
        List c;
        ImmutableList a = this.ao.a(SuggestionType.TOP_CONTACT);
        List a2 = this.ao.a(SuggestionType.TOP_PHONE_CONTACT);
        if (((Boolean) this.aq.get()).booleanValue()) {
            c = m5697c(a, this.ao.a(SuggestionType.ALL_CONTACT_CAPPED));
        } else {
            c = a;
        }
        if (c == null || a2 == null) {
            this.aF = null;
            this.f6032h.a();
            return;
        }
        List arrayList = new ArrayList();
        m5689a(arrayList, c);
        m5689a(arrayList, a2);
        Collections.sort(arrayList, new UserComparatorByRankingAndName(arrayList));
        this.aF = ImmutableList.copyOf(arrayList);
    }

    private void m5689a(List<User> list, @Nullable List<UserKey> list2) {
        if (list2 != null) {
            for (UserKey a : list2) {
                User a2 = this.ao.a(a);
                if (a2 != null) {
                    list.add(a2);
                }
            }
        }
    }

    private static ImmutableList<UserKey> m5673a(ImmutableList<UserKey> immutableList, ImmutableList<UserKey> immutableList2) {
        if (immutableList2 == null || immutableList == null) {
            return immutableList;
        }
        Set b = Sets.b(immutableList2);
        Builder builder = ImmutableList.builder();
        int size = immutableList.size();
        for (int i = 0; i < size; i++) {
            UserKey userKey = (UserKey) immutableList.get(i);
            if (!b.contains(userKey)) {
                builder.c(userKey);
            }
        }
        return builder.b();
    }

    private static ImmutableList<User> m5691b(ImmutableList<User> immutableList, ImmutableList<User> immutableList2) {
        int i = 0;
        if (immutableList2 == null || immutableList == null) {
            return immutableList;
        }
        Set a = Sets.a();
        int size = immutableList2.size();
        for (int i2 = 0; i2 < size; i2++) {
            a.add(((User) immutableList2.get(i2)).a);
        }
        Builder builder = ImmutableList.builder();
        size = immutableList.size();
        while (i < size) {
            User user = (User) immutableList.get(i);
            if (!a.contains(user.a)) {
                builder.c(user);
            }
            i++;
        }
        return builder.b();
    }

    private static ImmutableList<User> m5676a(Set<String> set, ImmutableList<User> immutableList) {
        if (CollectionUtil.a(immutableList)) {
            return RegularImmutableList.a;
        }
        Builder builder = ImmutableList.builder();
        int size = immutableList.size();
        for (int i = 0; i < size; i++) {
            User user = (User) immutableList.get(i);
            if (!set.contains(user.a)) {
                set.add(user.a);
                builder.c(user);
            }
        }
        return builder.b();
    }

    private static ImmutableList<UserKey> m5697c(@Nullable ImmutableList<UserKey> immutableList, @Nullable ImmutableList<UserKey> immutableList2) {
        int i = 0;
        if (immutableList != null && immutableList2 != null) {
            int i2;
            UserKey userKey;
            Builder builder = ImmutableList.builder();
            Set a = Sets.a();
            int size = immutableList.size();
            for (i2 = 0; i2 < size; i2++) {
                userKey = (UserKey) immutableList.get(i2);
                a.add(userKey.b());
                builder.c(userKey);
            }
            i2 = immutableList2.size();
            while (i < i2) {
                userKey = (UserKey) immutableList2.get(i);
                if (!a.contains(userKey.b())) {
                    a.add(userKey.b());
                    builder.c(userKey);
                }
                i++;
            }
            return builder.b();
        } else if (immutableList == null) {
            return immutableList2;
        } else {
            return immutableList;
        }
    }

    private ImmutableList<User> m5675a(List<UserKey> list) {
        Builder builder = ImmutableList.builder();
        for (UserKey a : list) {
            User a2 = this.ao.a(a);
            if (a2 != null) {
                builder.c(a2);
            }
        }
        return builder.b();
    }

    public final void m5708a(ImmutableList<User> immutableList) {
        this.aF = immutableList;
    }

    public final View m5706a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 628785347);
        super.a(layoutInflater, viewGroup, bundle);
        View inflate = layoutInflater.cloneInContext(this.f6026b).inflate(2130905648, viewGroup, false);
        this.aw = (BetterListView) FindViewUtil.b(inflate, 2131564709);
        this.au = FindViewUtil.b(inflate, 2131564689);
        this.av = (FrameLayout) FindViewUtil.b(inflate, 2131564708);
        this.at = (ContactPickerFragment) s().a(2131564726);
        this.at.m5755a(ListType.FACEBOOK_LIST);
        if (((Boolean) this.ar.get()).booleanValue()) {
            this.at.m5766a(jW_().getString(2131231369));
        }
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -1211897938, a);
        return inflate;
    }

    private void aA() {
        if (this.ax == null) {
            this.ax = (TokenizedAutoCompleteTextView) e(2131564404);
        }
    }

    public final void mi_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1453918131);
        super.mi_();
        aH();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 236583371, a);
    }

    public final void m5715d(Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1932441585);
        super.d(bundle);
        av();
        aD();
        this.at.m5776i(this.aw.getPaddingLeft());
        this.at.aH = this.aw.getSelector();
        if (bundle != null && bundle.getBoolean("multipickerCoverShown")) {
            aC();
        }
        this.aD = new C09146(this);
        ax(this);
        as();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -1837765421, a);
    }

    public final void m5705I() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -560427317);
        super.I();
        this.f6032h.b();
        if (this.f6030f != null) {
            ContactsLoadBroadcastsRegisterHelper contactsLoadBroadcastsRegisterHelper = this.f6030f;
            if (contactsLoadBroadcastsRegisterHelper.f6082f != null) {
                contactsLoadBroadcastsRegisterHelper.f6082f.c();
            }
        }
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -1062510, a);
    }

    public final ContactPickerFragment m5711b() {
        return this.at;
    }

    private void aB() {
        this.au.setOnClickListener(new C09157(this));
    }

    public final void m5709a(String str) {
        this.as = str;
        this.f6033i.a("neue", this.as);
    }

    private void aC() {
        Drawable background = this.au.getBackground();
        if (!this.aE && (background instanceof TransitionDrawable)) {
            ((TransitionDrawable) background).startTransition(300);
            aB();
            this.aE = true;
        }
    }

    public final boolean m5717e() {
        Drawable background = this.au.getBackground();
        if (!this.aE || !(background instanceof TransitionDrawable)) {
            return false;
        }
        ((TransitionDrawable) background).reverseTransition(300);
        this.au.setOnClickListener(null);
        this.au.setClickable(false);
        this.aE = false;
        this.at.ax();
        this.aw.requestFocus();
        return true;
    }

    public final void aq() {
        if (this.aJ) {
            this.av.setVisibility(0);
        }
    }

    public final void ar() {
        this.av.setVisibility(4);
        this.av.jumpDrawablesToCurrentState();
    }

    public final void m5710a(boolean z) {
        this.aJ = z;
    }

    public final void m5712b(ImmutableList<String> immutableList) {
        this.f6032h.u = immutableList;
        this.f6032h.a();
    }

    private void aD() {
        this.aw.setDividerHeight(0);
        this.aw.setBroadcastInteractionChanges(true);
        this.aw.setOnScrollListener(new C09168(this));
        this.aw.setOnItemClickListener(new C09179(this));
        this.aw.setAdapter(this.f6029e);
    }

    public final void m5716e(Bundle bundle) {
        super.e(bundle);
        bundle.putBoolean("multipickerCoverShown", this.aE);
    }

    public final void m5707a(Fragment fragment) {
        super.a(fragment);
        if (fragment instanceof ContactPickerFragment) {
            ContactPickerFragment contactPickerFragment = (ContactPickerFragment) fragment;
            contactPickerFragment.au = this.az;
            contactPickerFragment.aC = this.aA;
            contactPickerFragment.aD = this.aB;
            contactPickerFragment.aE = this.aC;
            contactPickerFragment.aR = this.aQ;
        }
    }

    public final void as() {
        ImmutableList aE;
        int i = 0;
        if (aF()) {
            aE = aE();
        } else if (this.aL || this.aK) {
            aE = this.at.aq();
            ImmutableSet copyOf = ImmutableSet.copyOf(aE);
            Builder builder = ImmutableList.builder();
            if (this.aF != null) {
                Class cls = aE.isEmpty() ? null : ((UserIdentifier) aE.get(0)).getClass();
                int size = this.aF.size();
                while (i < size) {
                    r0 = (User) this.aF.get(i);
                    if (cls == null || cls == r0.U.getClass()) {
                        builder.c(r0);
                    }
                    i++;
                }
            }
            aE = m5674a(builder.b(), copyOf);
        } else {
            ImmutableList<User> e = this.at.m5772e();
            Collection arrayList = new ArrayList();
            Builder builder2 = ImmutableList.builder();
            for (User user : e) {
                arrayList.add(user.n());
                builder2.c(user);
            }
            aE = m5674a(builder2.b(), ImmutableSet.copyOf(arrayList));
        }
        this.f6029e.a(aE);
        AdapterDetour.a(this.f6029e, -1597911817);
    }

    private ImmutableList<ContactPickerRow> aE() {
        Builder builder = ImmutableList.builder();
        int i = 0;
        int i2 = 0;
        while (i < this.aG.size() && i2 < 20) {
            int i3;
            ImmutableList immutableList = (ImmutableList) this.aH.get(i);
            if (immutableList.isEmpty()) {
                i3 = i2;
            } else {
                builder.c(new ContactPickerSectionHeaderRow((String) this.aG.get(i)));
                i3 = Math.min(immutableList.size(), 20 - i2);
                builder.b(m5692b(immutableList.subList(0, i3), (ImmutableSet) RegularImmutableSet.a));
                i3 += i2;
            }
            i++;
            i2 = i3;
        }
        return builder.b();
    }

    private ImmutableList<ContactPickerRow> m5674a(ImmutableList<User> immutableList, ImmutableSet<UserIdentifier> immutableSet) {
        Builder builder = ImmutableList.builder();
        if (!this.aK && this.aP) {
            builder.c(aG());
        }
        if (!(immutableList == null || immutableList.isEmpty())) {
            builder.b(m5692b(immutableList.subList(0, Math.min(immutableList.size(), 20)), (ImmutableSet) immutableSet));
        }
        return builder.b();
    }

    private ImmutableList<ContactPickerRow> m5692b(ImmutableList<User> immutableList, ImmutableSet<UserIdentifier> immutableSet) {
        Builder builder = ImmutableList.builder();
        if (!(this.aL || this.aK)) {
            AnonymousClass10 anonymousClass10 = new Object(this) {
                final /* synthetic */ ContactMultipickerFragment f6011a;

                {
                    this.f6011a = r1;
                }

                public final void m5659a(User user) {
                    if (user != null) {
                        this.f6011a.at.m5763a(user, null, -1);
                        this.f6011a.as();
                    }
                }
            };
        }
        int size = immutableList.size();
        for (int i = 0; i < size; i++) {
            ContactRowSectionType contactRowSectionType;
            boolean z;
            User user = (User) immutableList.get(i);
            UserIdentifier userIdentifier = user.U;
            if (this.at.aQ == Mode.OMNI_PICKER) {
                contactRowSectionType = ContactRowSectionType.OMNIPICKER_SUGGESTIONS;
            } else {
                contactRowSectionType = ContactRowSectionType.SUGGESTIONS;
            }
            DefaultMultiPickerRowCreator defaultMultiPickerRowCreator = this.al;
            if (this.aO && immutableSet.contains(userIdentifier)) {
                z = true;
            } else {
                z = false;
            }
            ContactPickerRow a = defaultMultiPickerRowCreator.m1879a(user, z, contactRowSectionType);
            if (aF() && (a instanceof ContactPickerUserRow)) {
                ContactPickerUserRow contactPickerUserRow = (ContactPickerUserRow) a;
                contactPickerUserRow.p = false;
                contactPickerUserRow.u = this.aM;
                contactPickerUserRow.x = "top_level_call_button";
                contactPickerUserRow.v = this.aN;
                contactPickerUserRow.y = "top_level_call_button_video";
            }
            builder.c(a);
        }
        return builder.b();
    }

    public static void m5702g(ContactMultipickerFragment contactMultipickerFragment, int i) {
        if (contactMultipickerFragment.aw.getAdapter() != null) {
            Object item = contactMultipickerFragment.aw.getAdapter().getItem(i);
            if (item instanceof ContactPickerUserRow) {
                contactMultipickerFragment.m5679a((ContactPickerUserRow) item, i);
            } else if (item instanceof ContactPickerGroupRow) {
                contactMultipickerFragment.m5678a((ContactPickerGroupRow) item, i);
            }
        }
    }

    private void m5678a(ContactPickerGroupRow contactPickerGroupRow, int i) {
        this.f6033i.a(contactPickerGroupRow.a.a.a.toString(), i, contactPickerGroupRow.a.a.toString(), contactPickerGroupRow.b.toString());
        m5681a(contactPickerGroupRow.a);
    }

    private void m5681a(final ThreadSummary threadSummary) {
        final Activity ao = ao();
        AnonymousClass11 anonymousClass11 = new LeaveCheckListener(this) {
            final /* synthetic */ ContactMultipickerFragment f6014c;

            public final void m5660a(boolean z) {
                if (z) {
                    if (ao != null) {
                        ao.finish();
                    }
                    ThreadViewOpenHelper threadViewOpenHelper = this.f6014c.ap;
                    ThreadKey threadKey = threadSummary.a;
                    String str = "click_suggestion";
                    Activity activity = (Activity) ContextUtils.a(threadViewOpenHelper.a, Activity.class);
                    if (activity != null) {
                        activity.overridePendingTransition(2130968681, 2130968689);
                    }
                    Intent b = threadViewOpenHelper.c.b(threadKey);
                    b.putExtra("modify_backstack_override", false);
                    Intent intent = b;
                    intent.putExtra("trigger", str);
                    intent.putExtra("prefer_chat_if_possible", false);
                    threadViewOpenHelper.b.a(intent, threadViewOpenHelper.a);
                }
            }
        };
        if (ao instanceof CheckBeforeLeaveActivity) {
            ((CheckBeforeLeaveActivity) ao).a(anonymousClass11);
        } else {
            anonymousClass11.a(true);
        }
    }

    private void m5704h(boolean z) {
        HoneyClientEvent honeyClientEvent = new HoneyClientEvent("click");
        honeyClientEvent.d = "multipicker_list_item";
        honeyClientEvent = honeyClientEvent;
        honeyClientEvent.e = "contact_multipicker_item";
        honeyClientEvent = honeyClientEvent.a("is_picked", z);
        if (this.as != null) {
            honeyClientEvent.c = this.as;
        }
        this.f6027c.a(honeyClientEvent);
    }

    private void m5680a(Result result) {
        if (BLog.b(3) && result != null) {
            result.toString();
        }
        if (result == null) {
            this.aF = RegularImmutableList.a;
        } else if (aF()) {
            this.aG.clear();
            this.aH.clear();
            if (aw()) {
                List a = this.ao.a(SuggestionType.RECENT_CALLS);
                if (a != null) {
                    this.aG.add(b(2131231231));
                    this.aH.add(m5675a(a));
                }
            }
            this.aG.add(b(2131231232));
            this.aH.add(m5693b(m5691b(result.p, result.o)));
        } else {
            List arrayList = new ArrayList();
            Set hashSet = new HashSet();
            arrayList.addAll(m5676a(hashSet, result.i));
            if (((Boolean) this.aq.get()).booleanValue()) {
                arrayList.addAll(m5676a(hashSet, result.r));
            }
            arrayList.addAll(m5676a(hashSet, result.q));
            arrayList.addAll(m5676a(hashSet, result.m));
            Collections.sort(arrayList, new UserComparatorByRankingAndName(arrayList));
            this.aF = m5693b(arrayList);
        }
        as();
    }

    private static ImmutableList<User> m5693b(List<User> list) {
        if (list == null || list.isEmpty()) {
            return RegularImmutableList.a;
        }
        Builder builder = ImmutableList.builder();
        for (User c : list) {
            builder.c(c);
        }
        return builder.b();
    }

    private void m5694b(View view) {
        if (this.at.aQ != Mode.OMNI_PICKER) {
            ViewParent parent = view != null ? view.getParent() : null;
            while (parent != null) {
                if (this.aK) {
                    if (parent == this.at.T) {
                        aC();
                        return;
                    } else if (parent == this.aw) {
                        aC();
                        return;
                    }
                }
                parent = parent.getParent();
            }
        }
    }

    public final void m5713b(String str) {
        this.at.m5769b(str);
    }

    private boolean aF() {
        return this.aM || this.aN;
    }

    private void aH() {
        this.T.getViewTreeObserver().addOnGlobalFocusChangeListener(this.aD);
    }

    private ContactPickerUserRow aG() {
        ContactPickerUserRowBuilder contactPickerUserRowBuilder = new ContactPickerUserRowBuilder();
        contactPickerUserRowBuilder.a = (User) this.am.get();
        ContactPickerUserRowBuilder contactPickerUserRowBuilder2 = contactPickerUserRowBuilder;
        contactPickerUserRowBuilder2.b = RowStyle.NEUE_PICKER;
        contactPickerUserRowBuilder2 = contactPickerUserRowBuilder2;
        contactPickerUserRowBuilder2.j = this.aO;
        contactPickerUserRowBuilder2 = contactPickerUserRowBuilder2;
        contactPickerUserRowBuilder2.q = false;
        contactPickerUserRowBuilder2 = contactPickerUserRowBuilder2;
        contactPickerUserRowBuilder2.l = PushableType.ON_MESSENGER;
        return contactPickerUserRowBuilder2.a();
    }
}
