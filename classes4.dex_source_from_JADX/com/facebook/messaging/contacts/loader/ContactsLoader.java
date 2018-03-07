package com.facebook.messaging.contacts.loader;

import com.facebook.common.cache.CacheSizeHelper;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.executors.ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.common.futures.FutureAndCallbackHolder;
import com.facebook.common.loader.FbLoader;
import com.facebook.common.loader.FbLoader.Callback;
import com.facebook.common.util.StringUtil;
import com.facebook.contacts.cache.FavoriteContactsCache;
import com.facebook.contacts.database.ContactsDatabaseSupplier;
import com.facebook.contacts.graphql.ContactLinkType;
import com.facebook.contacts.graphql.contactprofiletype.ContactProfileType;
import com.facebook.contacts.iterator.ContactCursorsQuery;
import com.facebook.contacts.iterator.ContactCursorsQuery.SortKey;
import com.facebook.contacts.iterator.FavoritesQueries;
import com.facebook.contacts.iterator.MessengerPhoneUserIterator;
import com.facebook.contacts.iterator.PhoneUserIterators;
import com.facebook.contacts.iterator.UserIterator;
import com.facebook.contacts.iterator.UserIterators;
import com.facebook.contacts.picker.SuggestionType;
import com.facebook.contacts.picker.SuggestionsCache;
import com.facebook.contacts.properties.DbContactsProperties;
import com.facebook.contacts.properties.DbContactsPropertyUtil;
import com.facebook.debug.log.BLog;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.business.pages.BusinessPagesHandler;
import com.facebook.messaging.business.search.BusinessSearchHandler;
import com.facebook.messaging.sms.contacts.PhoneContactsLoader;
import com.facebook.messaging.sms.contacts.PhoneContactsLoader.CallerContext;
import com.facebook.presence.DefaultPresenceManager;
import com.facebook.rtc.models.RecentCallsDb;
import com.facebook.rtc.models.RtcCallLogInfo;
import com.facebook.tools.dextr.runtime.detour.ExecutorDetour;
import com.facebook.tools.dextr.runtime.detour.TracerDetour;
import com.facebook.user.model.Name;
import com.facebook.user.model.User;
import com.facebook.user.model.UserBuilder;
import com.facebook.user.model.UserKey;
import com.facebook.user.model.UserPhoneNumber;
import com.facebook.user.names.ContactPhoneBookUtils;
import com.facebook.user.names.ContactPhoneBookUtils.NameBucketParamsBuilder;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.collect.Lists;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;
import java.util.Collection;
import java.util.Collections;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
import javax.inject.Inject;

/* compiled from: employee_loggedin */
public class ContactsLoader implements FbLoader<Void, Result, Throwable> {
    public static final Class<?> f13110b = ContactsLoader.class;
    @GuardedBy("ui thread")
    FutureAndCallbackHolder<Result> f13111a;
    private final ContactListsCache f13112c;
    private final FavoriteContactsCache f13113d;
    private final SuggestionsCache f13114e;
    private final UserIterators f13115f;
    private final FavoritesQueries f13116g;
    private final DefaultPresenceManager f13117h;
    public final DbContactsPropertyUtil f13118i;
    private final ListeningExecutorService f13119j;
    private final Executor f13120k;
    private final RecentCallsDb f13121l;
    private final PhoneUserIterators f13122m;
    public final AbstractFbErrorReporter f13123n;
    private final ContactPhoneBookUtils f13124o;
    private final ContactsDatabaseSupplier f13125p;
    private final CacheSizeHelper f13126q;
    private final BusinessSearchHandler f13127r;
    private final PhoneContactsLoader f13128s;
    private final BusinessPagesHandler f13129t;
    @Nullable
    public ImmutableList<String> f13130u;
    @GuardedBy("ui thread")
    public InitParams f13131v;
    @GuardedBy("ui thread")
    public Result f13132w = Result.f13334a;
    @GuardedBy("ui thread")
    @Nullable
    public Callback<Void, Result, Throwable> f13133x;

    /* compiled from: employee_loggedin */
    public enum FriendLists {
        FAVORITE_FRIENDS,
        TOP_FRIENDS,
        ONLINE_FRIENDS,
        FRIENDS_ON_MESSENGER,
        TOP_FRIENDS_ON_MESSENGER,
        NOT_ON_MESSENGER_FRIENDS,
        TOP_CONTACTS,
        ALL_FRIENDS_COEFFICIENT_SORTED,
        ALL_FRIENDS_NAME_SORTED,
        RECENT_CALLS,
        TOP_PUSHABLE_FRIENDS,
        SMS_INVITE_ALL_PHONE_CONTACTS,
        SMS_INVITE_MOBILE_CONTACTS,
        TOP_PHONE_CONTACTS,
        TOP_PHONE_CONTACTS_NULL_STATE,
        PHONE_CONTACTS,
        ALL_CONTACTS_WITH_CAP,
        ALL_CONTACTS,
        PROMOTIONAL_CONTACTS,
        RTC_CALLLOGS,
        RTC_ONGOING_GROUP_CALLS,
        PAGES
    }

    /* compiled from: employee_loggedin */
    public class InitParams {
        private final EnumSet<FriendLists> f13109a;

        public InitParams(EnumSet<FriendLists> enumSet) {
            this.f13109a = enumSet;
        }

        public final boolean m13945a() {
            return this.f13109a.contains(FriendLists.FAVORITE_FRIENDS);
        }

        public final boolean m13946b() {
            return this.f13109a.contains(FriendLists.TOP_FRIENDS);
        }

        public final boolean m13947c() {
            return this.f13109a.contains(FriendLists.ONLINE_FRIENDS);
        }

        public final boolean m13948d() {
            return this.f13109a.contains(FriendLists.FRIENDS_ON_MESSENGER);
        }

        public final boolean m13949e() {
            return this.f13109a.contains(FriendLists.TOP_FRIENDS_ON_MESSENGER);
        }

        public final boolean m13950f() {
            return this.f13109a.contains(FriendLists.NOT_ON_MESSENGER_FRIENDS);
        }

        public final boolean m13951g() {
            return this.f13109a.contains(FriendLists.RECENT_CALLS);
        }

        public final boolean m13952h() {
            return this.f13109a.contains(FriendLists.RTC_CALLLOGS);
        }

        public final boolean m13953i() {
            return this.f13109a.contains(FriendLists.RTC_ONGOING_GROUP_CALLS);
        }

        public final boolean m13954j() {
            return this.f13109a.contains(FriendLists.TOP_PUSHABLE_FRIENDS);
        }

        public final boolean m13955k() {
            return this.f13109a.contains(FriendLists.TOP_CONTACTS);
        }

        public final boolean m13956l() {
            return this.f13109a.contains(FriendLists.ALL_FRIENDS_COEFFICIENT_SORTED);
        }

        public final boolean m13957m() {
            return this.f13109a.contains(FriendLists.ALL_FRIENDS_NAME_SORTED);
        }

        public final boolean m13958n() {
            return this.f13109a.contains(FriendLists.SMS_INVITE_ALL_PHONE_CONTACTS);
        }

        public final boolean m13959o() {
            return this.f13109a.contains(FriendLists.SMS_INVITE_MOBILE_CONTACTS);
        }

        public final boolean m13960p() {
            return this.f13109a.contains(FriendLists.TOP_PHONE_CONTACTS);
        }

        public final boolean m13961q() {
            return this.f13109a.contains(FriendLists.TOP_PHONE_CONTACTS_NULL_STATE);
        }

        public final boolean m13962r() {
            return this.f13109a.contains(FriendLists.PHONE_CONTACTS);
        }

        public final boolean m13963s() {
            return this.f13109a.contains(FriendLists.ALL_CONTACTS_WITH_CAP);
        }

        public final boolean m13964t() {
            return this.f13109a.contains(FriendLists.ALL_CONTACTS);
        }

        public final boolean m13965u() {
            return this.f13109a.contains(FriendLists.PROMOTIONAL_CONTACTS);
        }

        public final boolean m13966v() {
            return this.f13109a.contains(FriendLists.PAGES);
        }

        public String toString() {
            return Objects.toStringHelper(InitParams.class).add("listsToLoad", this.f13109a).toString();
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof InitParams)) {
                return false;
            }
            if (this.f13109a.equals(((InitParams) obj).f13109a)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return this.f13109a.hashCode();
        }
    }

    /* compiled from: employee_loggedin */
    public class Result {
        public static final Result f13334a = new Result(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false);
        public final ImmutableList<User> f13335b;
        private final ImmutableList<User> f13336c;
        public final ImmutableList<User> f13337d;
        public final ImmutableList<User> f13338e;
        public final ImmutableList<User> f13339f;
        public final ImmutableList<User> f13340g;
        private final ImmutableList<User> f13341h;
        public final ImmutableList<User> f13342i;
        private final ImmutableList<User> f13343j;
        private final ImmutableList<User> f13344k;
        private final ImmutableList<User> f13345l;
        public final ImmutableList<User> f13346m;
        private final ImmutableList<User> f13347n;
        public final ImmutableList<User> f13348o;
        public final ImmutableList<User> f13349p;
        public final ImmutableList<User> f13350q;
        public final ImmutableList<User> f13351r;
        private final ImmutableList<User> f13352s;
        private final ImmutableList<User> f13353t;
        private final ImmutableList<RtcCallLogInfo> f13354u;
        private final ImmutableList<RtcCallLogInfo> f13355v;
        public final boolean f13356w;

        public Result(@Nullable ImmutableList<User> immutableList, @Nullable ImmutableList<User> immutableList2, @Nullable ImmutableList<User> immutableList3, @Nullable ImmutableList<User> immutableList4, @Nullable ImmutableList<User> immutableList5, @Nullable ImmutableList<User> immutableList6, @Nullable ImmutableList<User> immutableList7, @Nullable ImmutableList<User> immutableList8, @Nullable ImmutableList<User> immutableList9, @Nullable ImmutableList<User> immutableList10, @Nullable ImmutableList<User> immutableList11, @Nullable ImmutableList<User> immutableList12, @Nullable ImmutableList<User> immutableList13, @Nullable ImmutableList<User> immutableList14, @Nullable ImmutableList<User> immutableList15, @Nullable ImmutableList<User> immutableList16, @Nullable ImmutableList<User> immutableList17, @Nullable ImmutableList<User> immutableList18, @Nullable ImmutableList<User> immutableList19, @Nullable ImmutableList<RtcCallLogInfo> immutableList20, @Nullable ImmutableList<RtcCallLogInfo> immutableList21, boolean z) {
            this.f13335b = immutableList;
            this.f13336c = immutableList2;
            this.f13337d = immutableList3;
            this.f13338e = immutableList4;
            this.f13339f = immutableList5;
            this.f13340g = immutableList6;
            this.f13341h = immutableList7;
            this.f13342i = immutableList8;
            this.f13343j = immutableList9;
            this.f13344k = immutableList10;
            this.f13345l = immutableList11;
            this.f13346m = immutableList12;
            this.f13347n = immutableList13;
            this.f13348o = immutableList14;
            this.f13349p = immutableList15;
            this.f13356w = z;
            this.f13350q = immutableList16;
            this.f13351r = immutableList17;
            this.f13352s = immutableList18;
            this.f13353t = immutableList19;
            this.f13354u = immutableList20;
            this.f13355v = immutableList21;
        }

        public String toString() {
            return Objects.toStringHelper(Result.class).add("favoriteFriends", this.f13335b).add("topFriends", this.f13336c).add("onlineFriends", this.f13337d).add("topOnlineFriends", this.f13338e).add("onMessengerFriends", this.f13339f).add("topOnMessengerFriends", this.f13340g).add("notOnMessengerFriends", this.f13341h).add("topContacts", this.f13342i).add("allFriendsByCoefficient", this.f13343j).add("allFriendsByName", this.f13344k).add("smsInviteContacts", this.f13345l).add("phoneContacts", this.f13347n).add("recentCalls", this.f13348o).add("topPushableFriends", this.f13349p).add("specifiedContacts", this.f13350q).add("allContacts", this.f13351r).add("promotionalContacts", this.f13352s).add("hasPendingUpdates", this.f13356w).add("pages", this.f13353t).add("rtcCallLogs", this.f13354u).add("rtcOngoingGroupCalls", this.f13355v).toString();
        }
    }

    /* compiled from: employee_loggedin */
    class C06301 implements Callable<Result> {
        final /* synthetic */ ContactsLoader f13359a;

        C06301(ContactsLoader contactsLoader) {
            this.f13359a = contactsLoader;
        }

        public Object call() {
            return ContactsLoader.m13981e(this.f13359a);
        }
    }

    /* compiled from: employee_loggedin */
    class C06312 extends AbstractDisposableFutureCallback<Result> {
        final /* synthetic */ ContactsLoader f13360a;

        C06312(ContactsLoader contactsLoader) {
            this.f13360a = contactsLoader;
        }

        protected final void m14265a(Object obj) {
            this.f13360a.f13132w = (Result) obj;
            this.f13360a.f13111a = null;
            if (this.f13360a.f13133x != null) {
                this.f13360a.f13133x.mo949a(null, this.f13360a.f13132w);
                this.f13360a.f13133x.mo950b(null, this.f13360a.f13132w);
            }
        }

        protected final void m14266a(Throwable th) {
            BLog.a(ContactsLoader.f13110b, "ContactsLoader.onNonCancellationFailure", th);
            this.f13360a.f13123n.a("ContactsLoader", "onNonCancellationFailure", th);
            this.f13360a.f13111a = null;
            if (this.f13360a.f13133x != null) {
                this.f13360a.f13133x.mo951c(null, th);
            }
        }
    }

    public static com.facebook.messaging.contacts.loader.ContactsLoader.Result m13981e(com.facebook.messaging.contacts.loader.ContactsLoader r30) {
        /* JADX: method processing error */
/*
Error: java.lang.OutOfMemoryError: Java heap space
	at java.util.Arrays.copyOf(Arrays.java:3181)
	at java.util.ArrayList.grow(ArrayList.java:261)
	at java.util.ArrayList.ensureExplicitCapacity(ArrayList.java:235)
	at java.util.ArrayList.ensureCapacityInternal(ArrayList.java:227)
	at java.util.ArrayList.add(ArrayList.java:458)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:463)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
*/
        /*
        r3 = 0;
        r4 = 0;
        r16 = 0;
        r17 = 0;
        r26 = 0;
        r6 = 0;
        r27 = 0;
        r8 = 0;
        r9 = 0;
        r10 = 0;
        r11 = 0;
        r12 = 0;
        r13 = 0;
        r25 = 0;
        r19 = 0;
        r20 = 0;
        r14 = 0;
        r15 = 0;
        r21 = 0;
        r22 = 0;
        r23 = 0;
        r28 = r30.m13984f();
        r2 = "loadInBackground";
        r5 = 1167033778; // 0x458f85b2 float:4592.712 double:5.76591297E-315;
        com.facebook.tools.dextr.runtime.detour.TracerDetour.a(r2, r5);
        r29 = com.google.common.collect.Maps.c();	 Catch:{ all -> 0x030d }
        r0 = r30;	 Catch:{ all -> 0x030d }
        r2 = r0.f13131v;	 Catch:{ all -> 0x030d }
        r2 = r2.m13945a();	 Catch:{ all -> 0x030d }
        if (r2 == 0) goto L_0x0048;	 Catch:{ all -> 0x030d }
    L_0x0039:
        r0 = r30;	 Catch:{ all -> 0x030d }
        r1 = r29;	 Catch:{ all -> 0x030d }
        r3 = r0.m13968a(r1);	 Catch:{ all -> 0x030d }
        r0 = r30;	 Catch:{ all -> 0x030d }
        r2 = r0.f13113d;	 Catch:{ all -> 0x030d }
        r2.m14028a(r3);	 Catch:{ all -> 0x030d }
    L_0x0048:
        r0 = r30;	 Catch:{ all -> 0x030d }
        r2 = r0.f13131v;	 Catch:{ all -> 0x030d }
        r2 = r2.m13946b();	 Catch:{ all -> 0x030d }
        if (r2 == 0) goto L_0x0061;	 Catch:{ all -> 0x030d }
    L_0x0052:
        r0 = r30;	 Catch:{ all -> 0x030d }
        r1 = r29;	 Catch:{ all -> 0x030d }
        r4 = r0.m13976b(r1);	 Catch:{ all -> 0x030d }
        r0 = r30;	 Catch:{ all -> 0x030d }
        r2 = r0.f13112c;	 Catch:{ all -> 0x030d }
        r2.m14007a(r4);	 Catch:{ all -> 0x030d }
    L_0x0061:
        r0 = r30;	 Catch:{ all -> 0x030d }
        r2 = r0.f13131v;	 Catch:{ all -> 0x030d }
        r2 = r2.m13951g();	 Catch:{ all -> 0x030d }
        if (r2 == 0) goto L_0x0078;	 Catch:{ all -> 0x030d }
    L_0x006b:
        r16 = r30.m13987i();	 Catch:{ all -> 0x030d }
        r0 = r30;	 Catch:{ all -> 0x030d }
        r2 = r0.f13112c;	 Catch:{ all -> 0x030d }
        r0 = r16;	 Catch:{ all -> 0x030d }
        r2.m14009b(r0);	 Catch:{ all -> 0x030d }
    L_0x0078:
        r0 = r30;	 Catch:{ all -> 0x030d }
        r2 = r0.f13131v;	 Catch:{ all -> 0x030d }
        r2 = r2.m13952h();	 Catch:{ all -> 0x030d }
        if (r2 == 0) goto L_0x008f;	 Catch:{ all -> 0x030d }
    L_0x0082:
        r22 = r30.m13991k();	 Catch:{ all -> 0x030d }
        r0 = r30;	 Catch:{ all -> 0x030d }
        r2 = r0.f13112c;	 Catch:{ all -> 0x030d }
        r0 = r22;	 Catch:{ all -> 0x030d }
        r2.m14011c(r0);	 Catch:{ all -> 0x030d }
    L_0x008f:
        r0 = r30;	 Catch:{ all -> 0x030d }
        r2 = r0.f13131v;	 Catch:{ all -> 0x030d }
        r2 = r2.m13953i();	 Catch:{ all -> 0x030d }
        if (r2 == 0) goto L_0x00a6;	 Catch:{ all -> 0x030d }
    L_0x0099:
        r23 = r30.m13989j();	 Catch:{ all -> 0x030d }
        r0 = r30;	 Catch:{ all -> 0x030d }
        r2 = r0.f13112c;	 Catch:{ all -> 0x030d }
        r0 = r23;	 Catch:{ all -> 0x030d }
        r2.m14013d(r0);	 Catch:{ all -> 0x030d }
    L_0x00a6:
        r0 = r30;	 Catch:{ all -> 0x030d }
        r2 = r0.f13131v;	 Catch:{ all -> 0x030d }
        r2 = r2.m13954j();	 Catch:{ all -> 0x030d }
        if (r2 == 0) goto L_0x00c1;	 Catch:{ all -> 0x030d }
    L_0x00b0:
        r0 = r30;	 Catch:{ all -> 0x030d }
        r1 = r29;	 Catch:{ all -> 0x030d }
        r17 = r0.m13979c(r1);	 Catch:{ all -> 0x030d }
        r0 = r30;	 Catch:{ all -> 0x030d }
        r2 = r0.f13112c;	 Catch:{ all -> 0x030d }
        r0 = r17;	 Catch:{ all -> 0x030d }
        r2.m14014e(r0);	 Catch:{ all -> 0x030d }
    L_0x00c1:
        r0 = r30;	 Catch:{ all -> 0x030d }
        r2 = r0.f13131v;	 Catch:{ all -> 0x030d }
        r2 = r2.m13948d();	 Catch:{ all -> 0x030d }
        if (r2 != 0) goto L_0x00d5;	 Catch:{ all -> 0x030d }
    L_0x00cb:
        r0 = r30;	 Catch:{ all -> 0x030d }
        r2 = r0.f13131v;	 Catch:{ all -> 0x030d }
        r2 = r2.m13949e();	 Catch:{ all -> 0x030d }
        if (r2 == 0) goto L_0x00e4;	 Catch:{ all -> 0x030d }
    L_0x00d5:
        r0 = r30;	 Catch:{ all -> 0x030d }
        r1 = r29;	 Catch:{ all -> 0x030d }
        r8 = r0.m13980d(r1);	 Catch:{ all -> 0x030d }
        r0 = r30;	 Catch:{ all -> 0x030d }
        r2 = r0.f13112c;	 Catch:{ all -> 0x030d }
        r2.m14018i(r8);	 Catch:{ all -> 0x030d }
    L_0x00e4:
        r0 = r30;	 Catch:{ all -> 0x030d }
        r2 = r0.f13131v;	 Catch:{ all -> 0x030d }
        r2 = r2.m13950f();	 Catch:{ all -> 0x030d }
        if (r2 == 0) goto L_0x00f6;	 Catch:{ all -> 0x030d }
    L_0x00ee:
        r0 = r30;	 Catch:{ all -> 0x030d }
        r1 = r29;	 Catch:{ all -> 0x030d }
        r9 = r0.m13988i(r1);	 Catch:{ all -> 0x030d }
    L_0x00f6:
        r0 = r30;	 Catch:{ all -> 0x030d }
        r2 = r0.f13131v;	 Catch:{ all -> 0x030d }
        r2 = r2.m13955k();	 Catch:{ all -> 0x030d }
        if (r2 == 0) goto L_0x0108;	 Catch:{ all -> 0x030d }
    L_0x0100:
        r0 = r30;	 Catch:{ all -> 0x030d }
        r1 = r29;	 Catch:{ all -> 0x030d }
        r10 = r0.m13982e(r1);	 Catch:{ all -> 0x030d }
    L_0x0108:
        r0 = r30;	 Catch:{ all -> 0x030d }
        r2 = r0.f13131v;	 Catch:{ all -> 0x030d }
        r2 = r2.m13947c();	 Catch:{ all -> 0x030d }
        if (r2 == 0) goto L_0x0121;	 Catch:{ all -> 0x030d }
    L_0x0112:
        r0 = r30;	 Catch:{ all -> 0x030d }
        r1 = r29;	 Catch:{ all -> 0x030d }
        r6 = r0.m13985g(r1);	 Catch:{ all -> 0x030d }
        r0 = r30;	 Catch:{ all -> 0x030d }
        r2 = r0.f13112c;	 Catch:{ all -> 0x030d }
        r2.m14016g(r6);	 Catch:{ all -> 0x030d }
    L_0x0121:
        r0 = r30;	 Catch:{ all -> 0x030d }
        r2 = r0.f13131v;	 Catch:{ all -> 0x030d }
        r2 = r2.m13956l();	 Catch:{ all -> 0x030d }
        if (r2 == 0) goto L_0x0137;	 Catch:{ all -> 0x030d }
    L_0x012b:
        r2 = r30.m13993l();	 Catch:{ all -> 0x030d }
        r0 = r30;	 Catch:{ all -> 0x030d }
        r1 = r29;	 Catch:{ all -> 0x030d }
        r11 = r0.m13969a(r1, r2);	 Catch:{ all -> 0x030d }
    L_0x0137:
        r0 = r30;	 Catch:{ all -> 0x030d }
        r2 = r0.f13131v;	 Catch:{ all -> 0x030d }
        r2 = r2.m13957m();	 Catch:{ all -> 0x030d }
        if (r2 == 0) goto L_0x014d;	 Catch:{ all -> 0x030d }
    L_0x0141:
        r2 = r30.m13995m();	 Catch:{ all -> 0x030d }
        r0 = r30;	 Catch:{ all -> 0x030d }
        r1 = r29;	 Catch:{ all -> 0x030d }
        r12 = r0.m13969a(r1, r2);	 Catch:{ all -> 0x030d }
    L_0x014d:
        r0 = r30;	 Catch:{ all -> 0x030d }
        r2 = r0.f13131v;	 Catch:{ all -> 0x030d }
        r2 = r2.m13964t();	 Catch:{ all -> 0x030d }
        if (r2 == 0) goto L_0x0160;	 Catch:{ all -> 0x030d }
    L_0x0157:
        r2 = 0;	 Catch:{ all -> 0x030d }
        r0 = r30;	 Catch:{ all -> 0x030d }
        r1 = r29;	 Catch:{ all -> 0x030d }
        r19 = r0.m13972a(r1, r2);	 Catch:{ all -> 0x030d }
    L_0x0160:
        r0 = r30;	 Catch:{ all -> 0x030d }
        r2 = r0.f13131v;	 Catch:{ all -> 0x030d }
        r2 = r2.m13965u();	 Catch:{ all -> 0x030d }
        if (r2 == 0) goto L_0x017b;	 Catch:{ all -> 0x030d }
    L_0x016a:
        r0 = r30;	 Catch:{ all -> 0x030d }
        r1 = r29;	 Catch:{ all -> 0x030d }
        r20 = r0.m13992k(r1);	 Catch:{ all -> 0x030d }
        r0 = r30;	 Catch:{ all -> 0x030d }
        r2 = r0.f13112c;	 Catch:{ all -> 0x030d }
        r0 = r20;	 Catch:{ all -> 0x030d }
        r2.m14022m(r0);	 Catch:{ all -> 0x030d }
    L_0x017b:
        if (r19 != 0) goto L_0x0190;	 Catch:{ all -> 0x030d }
    L_0x017d:
        r0 = r30;	 Catch:{ all -> 0x030d }
        r2 = r0.f13131v;	 Catch:{ all -> 0x030d }
        r2 = r2.m13963s();	 Catch:{ all -> 0x030d }
        if (r2 == 0) goto L_0x0190;	 Catch:{ all -> 0x030d }
    L_0x0187:
        r2 = 1;	 Catch:{ all -> 0x030d }
        r0 = r30;	 Catch:{ all -> 0x030d }
        r1 = r29;	 Catch:{ all -> 0x030d }
        r19 = r0.m13972a(r1, r2);	 Catch:{ all -> 0x030d }
    L_0x0190:
        r0 = r30;	 Catch:{ all -> 0x030d }
        r2 = r0.f13131v;	 Catch:{ all -> 0x030d }
        r2 = r2.m13959o();	 Catch:{ all -> 0x030d }
        if (r2 == 0) goto L_0x02f1;	 Catch:{ all -> 0x030d }
    L_0x019a:
        r2 = 1;	 Catch:{ all -> 0x030d }
        r0 = r30;	 Catch:{ all -> 0x030d }
        r1 = r29;	 Catch:{ all -> 0x030d }
        r13 = r0.m13978b(r1, r2);	 Catch:{ all -> 0x030d }
        r0 = r30;	 Catch:{ all -> 0x030d }
        r2 = r0.f13112c;	 Catch:{ all -> 0x030d }
        r2.m14019j(r13);	 Catch:{ all -> 0x030d }
    L_0x01aa:
        r0 = r30;	 Catch:{ all -> 0x030d }
        r2 = r0.f13131v;	 Catch:{ all -> 0x030d }
        r2 = r2.m13960p();	 Catch:{ all -> 0x030d }
        if (r2 == 0) goto L_0x01bc;	 Catch:{ all -> 0x030d }
    L_0x01b4:
        r2 = com.facebook.messaging.sms.contacts.PhoneContactsLoader.CallerContext.PEOPLE_TAB;	 Catch:{ all -> 0x030d }
        r0 = r30;	 Catch:{ all -> 0x030d }
        r14 = r0.m13967a(r2);	 Catch:{ all -> 0x030d }
    L_0x01bc:
        r0 = r30;	 Catch:{ all -> 0x030d }
        r2 = r0.f13131v;	 Catch:{ all -> 0x030d }
        r2 = r2.m13961q();	 Catch:{ all -> 0x030d }
        if (r2 == 0) goto L_0x01ce;	 Catch:{ all -> 0x030d }
    L_0x01c6:
        r2 = com.facebook.messaging.sms.contacts.PhoneContactsLoader.CallerContext.NULL_STATE;	 Catch:{ all -> 0x030d }
        r0 = r30;	 Catch:{ all -> 0x030d }
        r14 = r0.m13967a(r2);	 Catch:{ all -> 0x030d }
    L_0x01ce:
        r0 = r30;	 Catch:{ all -> 0x030d }
        r2 = r0.f13131v;	 Catch:{ all -> 0x030d }
        r2 = r2.m13962r();	 Catch:{ all -> 0x030d }
        if (r2 == 0) goto L_0x01e3;	 Catch:{ all -> 0x030d }
    L_0x01d8:
        r15 = r30.m13997o();	 Catch:{ all -> 0x030d }
        r0 = r30;	 Catch:{ all -> 0x030d }
        r2 = r0.f13112c;	 Catch:{ all -> 0x030d }
        r2.m14020k(r15);	 Catch:{ all -> 0x030d }
    L_0x01e3:
        r0 = r30;	 Catch:{ all -> 0x030d }
        r2 = r0.f13131v;	 Catch:{ all -> 0x030d }
        r2 = r2.m13966v();	 Catch:{ all -> 0x030d }
        if (r2 == 0) goto L_0x01fe;	 Catch:{ all -> 0x030d }
    L_0x01ed:
        r0 = r30;	 Catch:{ all -> 0x030d }
        r1 = r29;	 Catch:{ all -> 0x030d }
        r21 = r0.m13990j(r1);	 Catch:{ all -> 0x030d }
        r0 = r30;	 Catch:{ all -> 0x030d }
        r2 = r0.f13112c;	 Catch:{ all -> 0x030d }
        r0 = r21;	 Catch:{ all -> 0x030d }
        r2.m14023n(r0);	 Catch:{ all -> 0x030d }
    L_0x01fe:
        r2 = com.facebook.common.util.CollectionUtil.b(r3);	 Catch:{ all -> 0x030d }
        if (r2 != 0) goto L_0x026a;	 Catch:{ all -> 0x030d }
    L_0x0204:
        r2 = com.facebook.common.util.CollectionUtil.b(r4);	 Catch:{ all -> 0x030d }
        if (r2 != 0) goto L_0x026a;	 Catch:{ all -> 0x030d }
    L_0x020a:
        r2 = com.facebook.common.util.CollectionUtil.b(r8);	 Catch:{ all -> 0x030d }
        if (r2 != 0) goto L_0x026a;	 Catch:{ all -> 0x030d }
    L_0x0210:
        r2 = com.facebook.common.util.CollectionUtil.b(r6);	 Catch:{ all -> 0x030d }
        if (r2 != 0) goto L_0x026a;	 Catch:{ all -> 0x030d }
    L_0x0216:
        r2 = com.facebook.common.util.CollectionUtil.b(r10);	 Catch:{ all -> 0x030d }
        if (r2 != 0) goto L_0x026a;	 Catch:{ all -> 0x030d }
    L_0x021c:
        r2 = com.facebook.common.util.CollectionUtil.b(r9);	 Catch:{ all -> 0x030d }
        if (r2 != 0) goto L_0x026a;	 Catch:{ all -> 0x030d }
    L_0x0222:
        r2 = com.facebook.common.util.CollectionUtil.b(r11);	 Catch:{ all -> 0x030d }
        if (r2 != 0) goto L_0x026a;	 Catch:{ all -> 0x030d }
    L_0x0228:
        r2 = com.facebook.common.util.CollectionUtil.b(r12);	 Catch:{ all -> 0x030d }
        if (r2 != 0) goto L_0x026a;	 Catch:{ all -> 0x030d }
    L_0x022e:
        r2 = com.facebook.common.util.CollectionUtil.b(r16);	 Catch:{ all -> 0x030d }
        if (r2 != 0) goto L_0x026a;	 Catch:{ all -> 0x030d }
    L_0x0234:
        r2 = com.facebook.common.util.CollectionUtil.b(r17);	 Catch:{ all -> 0x030d }
        if (r2 != 0) goto L_0x026a;	 Catch:{ all -> 0x030d }
    L_0x023a:
        r2 = com.facebook.common.util.CollectionUtil.b(r13);	 Catch:{ all -> 0x030d }
        if (r2 != 0) goto L_0x026a;	 Catch:{ all -> 0x030d }
    L_0x0240:
        r2 = com.facebook.common.util.CollectionUtil.b(r19);	 Catch:{ all -> 0x030d }
        if (r2 != 0) goto L_0x026a;	 Catch:{ all -> 0x030d }
    L_0x0246:
        r2 = com.facebook.common.util.CollectionUtil.b(r21);	 Catch:{ all -> 0x030d }
        if (r2 != 0) goto L_0x026a;	 Catch:{ all -> 0x030d }
    L_0x024c:
        r2 = com.facebook.common.util.CollectionUtil.b(r20);	 Catch:{ all -> 0x030d }
        if (r2 != 0) goto L_0x026a;	 Catch:{ all -> 0x030d }
    L_0x0252:
        r2 = com.facebook.common.util.CollectionUtil.b(r14);	 Catch:{ all -> 0x030d }
        if (r2 != 0) goto L_0x026a;	 Catch:{ all -> 0x030d }
    L_0x0258:
        r2 = com.facebook.common.util.CollectionUtil.b(r15);	 Catch:{ all -> 0x030d }
        if (r2 != 0) goto L_0x026a;	 Catch:{ all -> 0x030d }
    L_0x025e:
        r2 = com.facebook.common.util.CollectionUtil.b(r22);	 Catch:{ all -> 0x030d }
        if (r2 != 0) goto L_0x026a;	 Catch:{ all -> 0x030d }
    L_0x0264:
        r2 = com.facebook.common.util.CollectionUtil.b(r23);	 Catch:{ all -> 0x030d }
        if (r2 == 0) goto L_0x0282;	 Catch:{ all -> 0x030d }
    L_0x026a:
        r2 = new com.facebook.messaging.contacts.loader.ContactsLoader$Result;	 Catch:{ all -> 0x030d }
        r5 = 0;	 Catch:{ all -> 0x030d }
        r7 = 0;	 Catch:{ all -> 0x030d }
        r18 = 0;	 Catch:{ all -> 0x030d }
        r24 = 1;	 Catch:{ all -> 0x030d }
        r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24);	 Catch:{ all -> 0x030d }
        r0 = r30;	 Catch:{ all -> 0x030d }
        r0.f13132w = r2;	 Catch:{ all -> 0x030d }
        r0 = r30;	 Catch:{ all -> 0x030d }
        r2 = r0.f13132w;	 Catch:{ all -> 0x030d }
        r0 = r30;	 Catch:{ all -> 0x030d }
        r0.m13974a(r2);	 Catch:{ all -> 0x030d }
    L_0x0282:
        r0 = r30;	 Catch:{ all -> 0x030d }
        r2 = r0.f13131v;	 Catch:{ all -> 0x030d }
        r2 = r2.m13948d();	 Catch:{ all -> 0x030d }
        if (r2 == 0) goto L_0x0320;	 Catch:{ all -> 0x030d }
    L_0x028c:
        r0 = r30;	 Catch:{ all -> 0x030d }
        r1 = r29;	 Catch:{ all -> 0x030d }
        r7 = r0.m13983f(r1);	 Catch:{ all -> 0x030d }
        r0 = r30;	 Catch:{ all -> 0x030d }
        r2 = r0.f13112c;	 Catch:{ all -> 0x030d }
        r2.m14017h(r7);	 Catch:{ all -> 0x030d }
    L_0x029b:
        r0 = r30;	 Catch:{ all -> 0x030d }
        r2 = r0.f13131v;	 Catch:{ all -> 0x030d }
        r2 = r2.m13947c();	 Catch:{ all -> 0x030d }
        if (r2 == 0) goto L_0x031d;	 Catch:{ all -> 0x030d }
    L_0x02a5:
        r0 = r30;	 Catch:{ all -> 0x030d }
        r1 = r29;	 Catch:{ all -> 0x030d }
        r5 = r0.m13986h(r1);	 Catch:{ all -> 0x030d }
        r0 = r30;	 Catch:{ all -> 0x030d }
        r2 = r0.f13112c;	 Catch:{ all -> 0x030d }
        r2.m14015f(r5);	 Catch:{ all -> 0x030d }
    L_0x02b4:
        r0 = r30;	 Catch:{ all -> 0x030d }
        r2 = r0.f13131v;	 Catch:{ all -> 0x030d }
        r2 = r2.m13964t();	 Catch:{ all -> 0x030d }
        if (r2 == 0) goto L_0x02d0;	 Catch:{ all -> 0x030d }
    L_0x02be:
        r2 = 0;	 Catch:{ all -> 0x030d }
        r0 = r30;	 Catch:{ all -> 0x030d }
        r1 = r29;	 Catch:{ all -> 0x030d }
        r19 = r0.m13972a(r1, r2);	 Catch:{ all -> 0x030d }
        r0 = r30;	 Catch:{ all -> 0x030d }
        r2 = r0.f13112c;	 Catch:{ all -> 0x030d }
        r0 = r19;	 Catch:{ all -> 0x030d }
        r2.m14021l(r0);	 Catch:{ all -> 0x030d }
    L_0x02d0:
        r0 = r30;	 Catch:{ all -> 0x030d }
        r2 = r0.f13130u;	 Catch:{ all -> 0x030d }
        if (r2 == 0) goto L_0x031a;	 Catch:{ all -> 0x030d }
    L_0x02d6:
        r0 = r30;	 Catch:{ all -> 0x030d }
        r1 = r29;	 Catch:{ all -> 0x030d }
        r18 = r0.m13994l(r1);	 Catch:{ all -> 0x030d }
    L_0x02de:
        r2 = new com.facebook.messaging.contacts.loader.ContactsLoader$Result;	 Catch:{ all -> 0x030d }
        r24 = r28;	 Catch:{ all -> 0x030d }
        r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24);	 Catch:{ all -> 0x030d }
        r3 = -49529423; // 0xfffffffffd0c3db1 float:-1.1650765E37 double:NaN;
        com.facebook.tools.dextr.runtime.detour.TracerDetour.a(r3);
        r3 = f13110b;
        com.facebook.debug.tracer.Tracer.a(r3);
        return r2;
    L_0x02f1:
        r0 = r30;	 Catch:{  }
        r2 = r0.f13131v;	 Catch:{  }
        r2 = r2.m13958n();	 Catch:{  }
        if (r2 == 0) goto L_0x01aa;	 Catch:{  }
    L_0x02fb:
        r2 = 0;	 Catch:{  }
        r0 = r30;	 Catch:{  }
        r1 = r29;	 Catch:{  }
        r13 = r0.m13978b(r1, r2);	 Catch:{  }
        r0 = r30;	 Catch:{  }
        r2 = r0.f13112c;	 Catch:{  }
        r2.m14019j(r13);	 Catch:{  }
        goto L_0x01aa;
    L_0x030d:
        r2 = move-exception;
        r3 = 481424767; // 0x1cb1f57f float:1.1776337E-21 double:2.378554384E-315;
        com.facebook.tools.dextr.runtime.detour.TracerDetour.a(r3);
        r3 = f13110b;
        com.facebook.debug.tracer.Tracer.a(r3);
        throw r2;
    L_0x031a:
        r18 = r25;
        goto L_0x02de;
    L_0x031d:
        r5 = r26;
        goto L_0x02b4;
    L_0x0320:
        r7 = r27;
        goto L_0x029b;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.contacts.loader.ContactsLoader.e(com.facebook.messaging.contacts.loader.ContactsLoader):com.facebook.messaging.contacts.loader.ContactsLoader$Result");
    }

    public static ContactsLoader m13975b(InjectorLike injectorLike) {
        return new ContactsLoader(ContactListsCache.m14003a(injectorLike), FavoriteContactsCache.m14024a(injectorLike), SuggestionsCache.m14031a(injectorLike), UserIterators.m14040a(injectorLike), FavoritesQueries.m14044a(injectorLike), DefaultPresenceManager.m7724a(injectorLike), DbContactsPropertyUtil.m8547a(injectorLike), ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider.a(injectorLike), (Executor) ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.a(injectorLike), RecentCallsDb.m14049a(injectorLike), PhoneUserIterators.m12840a(injectorLike), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike), ContactPhoneBookUtils.m14075a(injectorLike), ContactsDatabaseSupplier.m8560a(injectorLike), CacheSizeHelper.m12985a(injectorLike), BusinessSearchHandler.m14112a(injectorLike), PhoneContactsLoader.m14166a(injectorLike), BusinessPagesHandler.m14250a(injectorLike));
    }

    @Nullable
    private String m13973a(User user) {
        Name name = user.e;
        if (!name.b() && !name.d() && !name.h()) {
            return null;
        }
        NameBucketParamsBuilder nameBucketParamsBuilder = new NameBucketParamsBuilder();
        nameBucketParamsBuilder.f3701b = user.h();
        nameBucketParamsBuilder = nameBucketParamsBuilder;
        nameBucketParamsBuilder.f3700a = user.k();
        nameBucketParamsBuilder = nameBucketParamsBuilder;
        nameBucketParamsBuilder.f3702c = user.i();
        return this.f13124o.m14082a(this.f13125p.a(), nameBucketParamsBuilder.m4156a());
    }

    @Inject
    public ContactsLoader(ContactListsCache contactListsCache, FavoriteContactsCache favoriteContactsCache, SuggestionsCache suggestionsCache, UserIterators userIterators, FavoritesQueries favoritesQueries, DefaultPresenceManager defaultPresenceManager, DbContactsPropertyUtil dbContactsPropertyUtil, ListeningExecutorService listeningExecutorService, Executor executor, RecentCallsDb recentCallsDb, PhoneUserIterators phoneUserIterators, AbstractFbErrorReporter abstractFbErrorReporter, ContactPhoneBookUtils contactPhoneBookUtils, ContactsDatabaseSupplier contactsDatabaseSupplier, CacheSizeHelper cacheSizeHelper, BusinessSearchHandler businessSearchHandler, PhoneContactsLoader phoneContactsLoader, BusinessPagesHandler businessPagesHandler) {
        this.f13112c = contactListsCache;
        this.f13113d = favoriteContactsCache;
        this.f13114e = suggestionsCache;
        this.f13115f = userIterators;
        this.f13116g = favoritesQueries;
        this.f13117h = defaultPresenceManager;
        this.f13118i = dbContactsPropertyUtil;
        this.f13119j = listeningExecutorService;
        this.f13120k = executor;
        this.f13121l = recentCallsDb;
        this.f13122m = phoneUserIterators;
        this.f13123n = abstractFbErrorReporter;
        this.f13124o = contactPhoneBookUtils;
        this.f13125p = contactsDatabaseSupplier;
        this.f13126q = cacheSizeHelper;
        this.f13127r = businessSearchHandler;
        this.f13128s = phoneContactsLoader;
        this.f13129t = businessPagesHandler;
    }

    public final void mo903a(@Nullable Callback<Void, Result, Throwable> callback) {
        this.f13133x = callback;
    }

    public final void m13998a() {
        Preconditions.checkNotNull(this.f13131v);
        if (!(this.f13132w == null || this.f13133x == null)) {
            this.f13133x.mo949a(null, this.f13132w);
        }
        if (this.f13111a == null) {
            m14002c();
        }
    }

    public final void m14001b() {
        if (this.f13111a != null) {
            this.f13111a.a(false);
            this.f13111a = null;
        }
        if (this.f13132w.f13356w) {
            this.f13132w = Result.f13334a;
        }
    }

    public final void m14002c() {
        ListenableFuture a = this.f13119j.a(new C06301(this));
        if (this.f13133x != null) {
            this.f13133x.mo948a(null, a);
        }
        C06312 c06312 = new C06312(this);
        Futures.a(a, c06312, this.f13120k);
        this.f13111a = FutureAndCallbackHolder.a(a, c06312);
    }

    private ImmutableList<User> m13970a(Map<UserKey, User> map, List<User> list) {
        return m13971a(map, list, false);
    }

    private ImmutableList<User> m13977b(Map<UserKey, User> map, List<User> list) {
        return m13971a(map, list, true);
    }

    private static ImmutableList<User> m13971a(Map<UserKey, User> map, List<User> list, boolean z) {
        HashSet hashSet;
        if (z) {
            hashSet = new HashSet(list.size());
        } else {
            hashSet = null;
        }
        Builder builder = ImmutableList.builder();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            Object obj = (User) it.next();
            UserKey userKey = obj.T;
            User user = (User) map.get(userKey);
            if (user == null) {
                map.put(userKey, obj);
            } else {
                User user2 = user;
            }
            if (hashSet == null || !hashSet.contains(userKey)) {
                if (hashSet != null) {
                    hashSet.add(userKey);
                }
                builder.c(obj);
            }
        }
        return builder.b();
    }

    private void m13974a(Result result) {
        ExecutorDetour.a(this.f13120k, new 3(this, result), 1567328503);
    }

    private boolean m13984f() {
        if ((this.f13118i.m8550a(DbContactsProperties.f13090a, -1) <= 0 ? 1 : null) != null) {
            return true;
        }
        Object obj = (!this.f13131v.m13945a() || this.f13118i.m8550a(DbContactsProperties.f13094e, -1) >= 0) ? null : 1;
        if (obj == null) {
            return false;
        }
        return true;
    }

    private ImmutableList<User> m13968a(Map<UserKey, User> map) {
        TracerDetour.a("getFavoriteFriends", 552141167);
        try {
            ImmutableList<User> a = m13970a((Map) map, this.f13116g.m14048a());
            return a;
        } finally {
            TracerDetour.a(1713586591);
        }
    }

    private ImmutableList<User> m13987i() {
        Collection a = this.f13121l.m14061a();
        TracerDetour.a("getRecentPeerToPeerCalls", 2102018309);
        Builder builder;
        try {
            builder = ImmutableList.builder();
            UserIterator a2 = this.f13115f.m14042a(ContactCursorsQuery.m11630a().m11646e(a));
            String str = "#fetch";
            TracerDetour.a(str, -1820433767);
            try {
                builder.b(a2);
                TracerDetour.a(str);
                a2.close();
                ImmutableList b = builder.b();
                this.f13114e.m14037a(b);
                this.f13114e.m14036a(SuggestionType.RECENT_CALLS, a);
                return b;
            } finally {
                int i = 1546771362;
                TracerDetour.a(1546771362);
                a2.close();
            }
        } finally {
            builder = 1980036402;
            TracerDetour.a(1980036402);
        }
    }

    private ImmutableList<RtcCallLogInfo> m13989j() {
        ImmutableList<RtcCallLogInfo> c = this.f13121l.m14067c(100);
        this.f13114e.m14036a(SuggestionType.RTC_ONGOING_GROUP_CALLS, c);
        return c;
    }

    private ImmutableList<RtcCallLogInfo> m13991k() {
        ImmutableList<RtcCallLogInfo> b = this.f13121l.m14066b(100);
        Collection collection = null;
        if (b != null) {
            collection = RecentCallsDb.m14052a((ImmutableList) b);
        }
        Builder builder = "getCallLogs";
        TracerDetour.a(builder, -1104357545);
        try {
            builder = ImmutableList.builder();
            UserIterator a = this.f13115f.m14042a(ContactCursorsQuery.m11630a().m11646e(collection));
            String str = "#fetch";
            TracerDetour.a(str, 1035029279);
            try {
                builder.b(a);
                TracerDetour.a(str);
                a.close();
                this.f13114e.m14037a(builder.b());
                this.f13114e.m14038b(SuggestionType.RTC_CALLLOGS, b);
                return b;
            } finally {
                int i = 384221355;
                TracerDetour.a(384221355);
                a.close();
            }
        } finally {
            b = 242489165;
            TracerDetour.a(242489165);
        }
    }

    private ImmutableList<User> m13976b(Map<UserKey, User> map) {
        TracerDetour.a("getTopFriends", -510438941);
        try {
            Builder builder = ImmutableList.builder();
            UserIterator a = this.f13115f.m14042a(ContactCursorsQuery.m11633a(ContactProfileType.MESSAGABLE_TYPES, ContactPickerConstants.a));
            int i = "#fetch";
            TracerDetour.a(i, -967043965);
            try {
                builder.b(a);
                TracerDetour.a(i);
                a.close();
                ImmutableList a2 = m13970a((Map) map, builder.b());
                Builder builder2 = ImmutableList.builder();
                int size = a2.size();
                for (int i2 = 0; i2 < size; i2++) {
                    builder2.c(((User) a2.get(i2)).e());
                }
                this.f13114e.m14037a(a2);
                this.f13114e.m14036a(SuggestionType.TOP, builder2.b());
                return a2;
            } finally {
                i = 1040022015;
                TracerDetour.a(1040022015);
                a.close();
            }
        } finally {
            TracerDetour.a(948416539);
        }
    }

    private ImmutableList<User> m13979c(Map<UserKey, User> map) {
        TracerDetour.a("getTopPushableFriends", -1216782891);
        try {
            Builder builder = ImmutableList.builder();
            UserIterator a = this.f13115f.m14042a(ContactCursorsQuery.m11636c(ContactProfileType.MESSAGABLE_TYPES, ContactPickerConstants.a));
            int i = "#fetch";
            TracerDetour.a(i, -555356347);
            try {
                builder.b(a);
                TracerDetour.a(i);
                a.close();
                ImmutableList a2 = m13970a((Map) map, builder.b());
                Builder builder2 = ImmutableList.builder();
                int size = a2.size();
                for (int i2 = 0; i2 < size; i2++) {
                    builder2.c(((User) a2.get(i2)).e());
                }
                this.f13114e.m14037a(a2);
                this.f13114e.m14036a(SuggestionType.TOP_PUSHABLE, builder2.b());
                return a2;
            } finally {
                i = -1603477932;
                TracerDetour.a(-1603477932);
                a.close();
            }
        } finally {
            TracerDetour.a(-1220096991);
        }
    }

    private ImmutableList<User> m13980d(Map<UserKey, User> map) {
        TracerDetour.a("getTopOnMessenger", 1519900146);
        try {
            Builder builder = ImmutableList.builder();
            UserIterator a = this.f13115f.m14042a(ContactCursorsQuery.m11630a().m11642c(ContactProfileType.MESSAGABLE_TYPES).m11639a(true).m11645d(true).m11647e(true).m11638a(SortKey.COMMUNICATION_RANK).m11648f(true).m11637a(15));
            int i = "#fetch";
            TracerDetour.a(i, -591651513);
            try {
                builder.b(a);
                TracerDetour.a(i);
                a.close();
                return m13970a((Map) map, builder.b());
            } finally {
                i = -139232032;
                TracerDetour.a(-139232032);
                a.close();
            }
        } finally {
            TracerDetour.a(-1964409382);
        }
    }

    private ImmutableList<User> m13982e(Map<UserKey, User> map) {
        TracerDetour.a("getTopContacts", -174324762);
        try {
            Builder builder = ImmutableList.builder();
            UserIterator a = this.f13115f.m14042a(ContactCursorsQuery.m11630a().m11642c(ContactProfileType.MESSAGABLE_TYPES).m11639a(true).m11647e(true).m11638a(SortKey.COMMUNICATION_RANK).m11648f(true).m11637a(15));
            int i = "#fetch";
            TracerDetour.a(i, 700445305);
            try {
                builder.b(a);
                TracerDetour.a(i);
                a.close();
                ImmutableList a2 = m13970a((Map) map, builder.b());
                Builder builder2 = ImmutableList.builder();
                int size = a2.size();
                for (int i2 = 0; i2 < size; i2++) {
                    builder2.c(((User) a2.get(i2)).e());
                }
                this.f13114e.m14037a(a2);
                this.f13114e.m14036a(SuggestionType.TOP_CONTACT, builder2.b());
                return a2;
            } finally {
                i = -383326138;
                TracerDetour.a(-383326138);
                a.close();
            }
        } finally {
            TracerDetour.a(1094586719);
        }
    }

    private ImmutableList<User> m13983f(Map<UserKey, User> map) {
        TracerDetour.a("getOnMessenger", -1937043329);
        try {
            Builder builder = ImmutableList.builder();
            UserIterator a = this.f13115f.m14042a(ContactCursorsQuery.m11630a().m11642c(ContactProfileType.MESSAGABLE_TYPES).m11639a(true).m11645d(true).m11647e(true).m11638a(SortKey.NAME));
            int i = "#fetch";
            TracerDetour.a(i, -35647387);
            try {
                builder.b(a);
                TracerDetour.a(i);
                a.close();
                return m13970a((Map) map, builder.b());
            } finally {
                i = -1110301221;
                TracerDetour.a(-1110301221);
                a.close();
            }
        } finally {
            TracerDetour.a(1312498175);
        }
    }

    private ImmutableList<User> m13985g(Map<UserKey, User> map) {
        TracerDetour.a("getTopOnlineFriends", -394523024);
        try {
            Builder builder = ImmutableList.builder();
            UserIterator a = this.f13115f.m14042a(ContactCursorsQuery.m11630a().m11642c(ContactProfileType.MESSAGABLE_TYPES).m11646e(this.f13117h.m7764c()).m11638a(SortKey.COMMUNICATION_RANK).m11648f(true).m11637a(15));
            int i = "#fetch";
            TracerDetour.a(i, 1581764491);
            try {
                builder.b(a);
                TracerDetour.a(i);
                a.close();
                return m13970a((Map) map, builder.b());
            } finally {
                i = -1474981726;
                TracerDetour.a(-1474981726);
                a.close();
            }
        } finally {
            TracerDetour.a(-346542206);
        }
    }

    private ImmutableList<User> m13986h(Map<UserKey, User> map) {
        TracerDetour.a("getOnlineFriends", 1015867577);
        try {
            Builder builder = ImmutableList.builder();
            Object a = this.f13115f.m14042a(ContactCursorsQuery.m11630a().m11642c(ContactProfileType.MESSAGABLE_TYPES).m11646e(this.f13117h.m7764c()).m11638a(SortKey.NAME));
            try {
                builder.b(a);
                return m13970a((Map) map, builder.b());
            } finally {
                a.close();
            }
        } finally {
            TracerDetour.a(547469870);
        }
    }

    private ImmutableList<User> m13988i(Map<UserKey, User> map) {
        TracerDetour.a("getNotOnMessengerFriends", -975779785);
        try {
            Builder builder = ImmutableList.builder();
            Object a = this.f13115f.m14042a(ContactCursorsQuery.m11630a().m11642c(ContactProfileType.MESSAGABLE_TYPES).m11639a(true).m11643c(true).m11647e(true).m11638a(SortKey.COMMUNICATION_RANK).m11648f(true));
            Object a2 = this.f13115f.m14042a(ContactCursorsQuery.m11630a().m11642c(ContactProfileType.MESSAGABLE_TYPES).m11639a(true).m11643c(true).m11647e(true).m11638a(SortKey.NAME).m11649g(true));
            try {
                builder.b(a);
                builder.b(a2);
                return m13970a((Map) map, builder.b());
            } finally {
                a.close();
                a2.close();
            }
        } finally {
            TracerDetour.a(-1743839341);
        }
    }

    private ImmutableList<User> m13969a(Map<UserKey, User> map, ContactCursorsQuery contactCursorsQuery) {
        TracerDetour.a("getAllFriendsWithCap", 185674668);
        try {
            Builder builder = ImmutableList.builder();
            Object a = this.f13115f.m14042a(contactCursorsQuery);
            try {
                int i = "#fetch";
                TracerDetour.a(i, -2106114896);
                try {
                    builder.b(a);
                    TracerDetour.a(i);
                    ImmutableList<User> a2 = m13970a((Map) map, builder.b());
                    return a2;
                } finally {
                    i = 970260929;
                    TracerDetour.a(970260929);
                }
            } finally {
                a.close();
            }
        } finally {
            TracerDetour.a(637497344);
        }
    }

    private ContactCursorsQuery m13993l() {
        ContactCursorsQuery n = m13996n();
        n.f11227l = true;
        n = n;
        n.f11226k = SortKey.COMMUNICATION_RANK;
        return n;
    }

    private ContactCursorsQuery m13995m() {
        ContactCursorsQuery n = m13996n();
        n.f11227l = false;
        n = n;
        n.f11226k = SortKey.NAME;
        return n;
    }

    private ContactCursorsQuery m13996n() {
        int a = this.f13126q.m12987a(100, 300);
        ContactCursorsQuery a2 = ContactCursorsQuery.m11630a();
        a2.f11216a = ContactProfileType.MESSAGABLE_TYPES;
        a2 = a2;
        a2.f11228m = a;
        ContactCursorsQuery contactCursorsQuery = a2;
        contactCursorsQuery.f11220e = true;
        contactCursorsQuery = contactCursorsQuery;
        contactCursorsQuery.f11224i = true;
        contactCursorsQuery = contactCursorsQuery;
        contactCursorsQuery.f11217b = ImmutableList.of(ContactLinkType.FRIEND);
        return contactCursorsQuery;
    }

    private ImmutableList<User> m13972a(Map<UserKey, User> map, boolean z) {
        if (z) {
            TracerDetour.a("getAllContactsWithCap", -1360826777);
        } else {
            TracerDetour.a("getAllContacts", -82514487);
        }
        try {
            Builder builder = ImmutableList.builder();
            ContactCursorsQuery a = ContactCursorsQuery.m11630a().m11642c(ContactProfileType.MESSAGABLE_TYPES).m11639a(true).m11647e(true).m11638a(SortKey.NAME);
            if (z) {
                a.m11637a(ContactPickerConstants.a);
            }
            Object a2 = this.f13115f.m14042a(a);
            try {
                int i = "#fetch";
                TracerDetour.a(i, -955458682);
                try {
                    builder.b(a2);
                    TracerDetour.a(i);
                    List b = builder.b();
                    if (z) {
                        Builder builder2 = ImmutableList.builder();
                        int size = b.size();
                        for (int i2 = 0; i2 < size; i2++) {
                            builder2.c(((User) b.get(i2)).e());
                        }
                        this.f13114e.m14037a((ImmutableList) b);
                        this.f13114e.m14036a(SuggestionType.ALL_CONTACT_CAPPED, builder2.b());
                    }
                    ImmutableList<User> a3 = m13970a((Map) map, b);
                    return a3;
                } finally {
                    i = -1460176579;
                    TracerDetour.a(-1460176579);
                }
            } finally {
                a2.close();
            }
        } finally {
            TracerDetour.a(1422204053);
        }
    }

    private ImmutableList<User> m13978b(Map<UserKey, User> map, boolean z) {
        Throwable th;
        TracerDetour.a("getSmsInviteContacts", 1013009624);
        try {
            Builder builder = ImmutableList.builder();
            MessengerPhoneUserIterator messengerPhoneUserIterator = null;
            try {
                MessengerPhoneUserIterator a = this.f13122m.m12844a();
                while (a.hasNext()) {
                    try {
                        User user = (User) a.next();
                        if (!(user.r() == null || user.r().isEmpty())) {
                            ImmutableList r = user.r();
                            int size = r.size();
                            for (int i = 0; i < size; i++) {
                                UserPhoneNumber userPhoneNumber = (UserPhoneNumber) r.get(i);
                                if (!z || userPhoneNumber.d() == 2) {
                                    UserBuilder b = new UserBuilder().a(user).a(user.d(), userPhoneNumber.b()).b(ImmutableList.of(userPhoneNumber));
                                    if (StringUtil.a(user.C())) {
                                        b.i(m13973a(user));
                                    }
                                    builder.c(b.aa());
                                }
                            }
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        messengerPhoneUserIterator = a;
                    }
                }
                if (a != null) {
                    a.c();
                }
                Collection b2 = Lists.b(m13977b((Map) map, builder.b()));
                Collections.sort(b2, new 4(this));
                ImmutableList<User> copyOf = ImmutableList.copyOf(b2);
                return copyOf;
            } catch (Throwable th3) {
                th = th3;
                if (messengerPhoneUserIterator != null) {
                    messengerPhoneUserIterator.c();
                }
                throw th;
            }
        } finally {
            TracerDetour.a(-172133139);
        }
    }

    private ImmutableList<User> m13967a(CallerContext callerContext) {
        TracerDetour.a("getTopPhoneContacts", -1375895293);
        try {
            ImmutableList b = this.f13128s.m14179b(callerContext);
            Integer.valueOf(b.size());
            Builder builder = ImmutableList.builder();
            int size = b.size();
            for (int i = 0; i < size; i++) {
                builder.c(((User) b.get(i)).e());
            }
            this.f13114e.m14037a(b);
            this.f13114e.m14036a(SuggestionType.TOP_PHONE_CONTACT, builder.b());
            return b;
        } finally {
            TracerDetour.a(-729640743);
        }
    }

    private ImmutableList<User> m13997o() {
        TracerDetour.a("getPhoneContacts", 1141278570);
        try {
            ImmutableList<User> a = this.f13128s.m14176a(CallerContext.PEOPLE_TAB);
            Integer.valueOf(a.size());
            return a;
        } finally {
            TracerDetour.a(-84485868);
        }
    }

    @Nullable
    private ImmutableList<User> m13990j(Map<UserKey, User> map) {
        TracerDetour.a("getPages", 448912665);
        Builder builder = ImmutableList.builder();
        try {
            Iterable a = this.f13129t.m14254a();
            if (a != null) {
                if (a.size() > 5) {
                    a = a.subList(0, 5);
                }
                builder.b(a);
            }
        } catch (Exception e) {
            TracerDetour.a(1450591642);
        }
        return m13970a((Map) map, builder.b());
    }

    @Nullable
    private ImmutableList<User> m13992k(Map<UserKey, User> map) {
        TracerDetour.a("getPromotionalContacts", -80734898);
        Builder builder = ImmutableList.builder();
        try {
            User a = this.f13127r.m14117a();
            if (a != null) {
                builder.c(a);
            }
        } catch (Exception e) {
            TracerDetour.a(1217617415);
        }
        List b = builder.b();
        Builder builder2 = ImmutableList.builder();
        int size = b.size();
        for (int i = 0; i < size; i++) {
            builder2.c(((User) b.get(i)).e());
        }
        this.f13114e.m14037a((ImmutableList) b);
        this.f13114e.m14036a(SuggestionType.PROMOTION, builder2.b());
        return m13970a((Map) map, b);
    }

    private ImmutableList<User> m13994l(Map<UserKey, User> map) {
        TracerDetour.a("getSpecifiedContacts", 26348112);
        try {
            Builder builder = ImmutableList.builder();
            Object a = this.f13115f.m14042a(ContactCursorsQuery.m11634b(this.f13130u));
            try {
                builder.b(a);
                return m13970a((Map) map, builder.b());
            } finally {
                a.close();
            }
        } finally {
            TracerDetour.a(299495864);
        }
    }
}
