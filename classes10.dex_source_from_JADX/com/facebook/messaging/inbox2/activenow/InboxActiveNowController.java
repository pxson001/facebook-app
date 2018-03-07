package com.facebook.messaging.inbox2.activenow;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import com.facebook.common.loader.FbLoader.Callback;
import com.facebook.common.time.Clock;
import com.facebook.contacts.picker.ContactPickerUserRow;
import com.facebook.contacts.picker.ContactPickerUserRow.ContactRowSectionType;
import com.facebook.inject.Assisted;
import com.facebook.messaging.contacts.loader.ContactsLoader;
import com.facebook.messaging.contacts.loader.ContactsLoader.FriendLists;
import com.facebook.messaging.contacts.loader.ContactsLoader.InitParams;
import com.facebook.messaging.contacts.loader.ContactsLoaderFactory;
import com.facebook.messaging.contacts.picker.ContactPickerRowsFactory;
import com.facebook.messaging.inbox2.items.InboxAdapter;
import com.facebook.messaging.inbox2.items.InboxItem;
import com.facebook.messaging.inbox2.items.InboxItemType;
import com.facebook.orca.threadlist.ThreadListFragment.AnonymousClass10;
import com.facebook.orca.threadlist.ThreadListFragmentUpdateOrchestrator.Urgency;
import com.facebook.presence.DefaultPresenceManager;
import com.facebook.presence.PresenceManager;
import com.facebook.presence.PresenceManager.PresenceDownloadState;
import com.facebook.presence.PresenceManager.PresenceListener;
import com.facebook.user.model.User;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.EnumSet;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: share_to_app */
public class InboxActiveNowController {
    private static final Class<?> f2594a = InboxActiveNowController.class;
    private final Provider<Boolean> f2595b;
    public final ContactPickerRowsFactory f2596c;
    private final ContactsLoaderFactory f2597d;
    private final DefaultPresenceManager f2598e;
    private final ScheduledExecutorService f2599f;
    private final Clock f2600g;
    public final RecyclerView f2601h;
    public final InboxAdapter f2602i;
    private boolean f2603j;
    private boolean f2604k;
    public int f2605l;
    public AnonymousClass10 f2606m;
    private ContactsLoader f2607n;
    private Callback<Void, com.facebook.messaging.contacts.loader.ContactsLoader.Result, Throwable> f2608o;
    private PresenceListener f2609p = new C04341(this);
    public ScheduledFuture<?> f2610q;
    private long f2611r;
    private boolean f2612s;
    public ImmutableList<ContactPickerUserRow> f2613t;
    public int f2614u;
    public boolean f2615v;
    public boolean f2616w;

    /* compiled from: share_to_app */
    class C04341 extends PresenceListener {
        final /* synthetic */ InboxActiveNowController f2586a;

        C04341(InboxActiveNowController inboxActiveNowController) {
            this.f2586a = inboxActiveNowController;
        }

        public final void m2579a() {
            InboxActiveNowController.m2588g(this.f2586a);
        }
    }

    /* compiled from: share_to_app */
    class C04352 implements Callback<Void, com.facebook.messaging.contacts.loader.ContactsLoader.Result, Throwable> {
        final /* synthetic */ InboxActiveNowController f2587a;

        C04352(InboxActiveNowController inboxActiveNowController) {
            this.f2587a = inboxActiveNowController;
        }

        public final void m2581a(Object obj, Object obj2) {
            com.facebook.messaging.contacts.loader.ContactsLoader.Result result = (com.facebook.messaging.contacts.loader.ContactsLoader.Result) obj2;
            InboxActiveNowController inboxActiveNowController = this.f2587a;
            if (inboxActiveNowController.f2613t == null) {
                ImmutableList immutableList = result.e;
                ImmutableList immutableList2 = result.d;
                if (immutableList != null && immutableList2 != null) {
                    Integer.valueOf(immutableList.size());
                    Builder builder = ImmutableList.builder();
                    int size = immutableList.size();
                    int i = 0;
                    for (int i2 = 0; i2 < size; i2++) {
                        builder.c(inboxActiveNowController.f2596c.m1789a((User) immutableList.get(i2), ContactRowSectionType.TOP_FRIENDS));
                        i++;
                        if (i >= 5) {
                            break;
                        }
                    }
                    inboxActiveNowController.f2613t = builder.b();
                    Integer.valueOf(immutableList2.size());
                    inboxActiveNowController.f2614u = immutableList2.size();
                    if (inboxActiveNowController.f2606m != null) {
                        AnonymousClass10 anonymousClass10 = inboxActiveNowController.f2606m;
                        anonymousClass10.f6598a.cV = true;
                        anonymousClass10.f6598a.ca.m6377a(Urgency.ACTIVE_NOW, "active_now");
                    }
                }
            }
        }

        public final void m2580a(Object obj, ListenableFuture listenableFuture) {
            this.f2587a.f2615v = true;
        }

        public final void m2582b(Object obj, Object obj2) {
            this.f2587a.f2616w = true;
            this.f2587a.f2615v = false;
        }

        public final void m2583c(Object obj, Object obj2) {
            this.f2587a.f2616w = true;
            this.f2587a.f2615v = false;
        }
    }

    /* compiled from: share_to_app */
    class C04363 implements Runnable {
        final /* synthetic */ InboxActiveNowController f2588a;

        C04363(InboxActiveNowController inboxActiveNowController) {
            this.f2588a = inboxActiveNowController;
        }

        public void run() {
            this.f2588a.f2610q = null;
            InboxActiveNowController.m2585c(this.f2588a);
        }
    }

    /* compiled from: share_to_app */
    public class Result {
        public final boolean f2589a;
        public final ImmutableList<ContactPickerUserRow> f2590b;
        public final boolean f2591c;
        public final int f2592d;
        final /* synthetic */ InboxActiveNowController f2593e;

        public Result(InboxActiveNowController inboxActiveNowController, boolean z, ImmutableList<ContactPickerUserRow> immutableList, boolean z2, int i) {
            this.f2593e = inboxActiveNowController;
            this.f2589a = z;
            this.f2590b = immutableList;
            this.f2591c = z2;
            this.f2592d = i;
        }
    }

    @Inject
    public InboxActiveNowController(Provider<Boolean> provider, ContactPickerRowsFactory contactPickerRowsFactory, ContactsLoaderFactory contactsLoaderFactory, PresenceManager presenceManager, ScheduledExecutorService scheduledExecutorService, Clock clock, @Assisted RecyclerView recyclerView, @Assisted InboxAdapter inboxAdapter) {
        this.f2595b = provider;
        this.f2596c = contactPickerRowsFactory;
        this.f2597d = contactsLoaderFactory;
        this.f2598e = presenceManager;
        this.f2599f = scheduledExecutorService;
        this.f2600g = clock;
        this.f2601h = recyclerView;
        this.f2602i = inboxAdapter;
        ContactsLoaderFactory contactsLoaderFactory2 = this.f2597d;
        ContactsLoader contactsLoader = (ContactsLoader) contactsLoaderFactory2.b.get();
        contactsLoader.v = new InitParams(EnumSet.of(FriendLists.ONLINE_FRIENDS, FriendLists.TOP_FRIENDS));
        this.f2607n = contactsLoader;
        this.f2608o = new C04352(this);
    }

    public final void m2590a(AnonymousClass10 anonymousClass10) {
        this.f2606m = anonymousClass10;
    }

    public final void m2591a(boolean z) {
        Boolean.valueOf(z);
        this.f2603j = z;
        m2585c(this);
    }

    public final void m2593b(boolean z) {
        Boolean.valueOf(z);
        this.f2604k = z;
        m2585c(this);
    }

    public final Result m2592b() {
        boolean booleanValue = ((Boolean) this.f2595b.get()).booleanValue();
        boolean z = this.f2613t == null && !this.f2616w;
        return new Result(this, booleanValue, this.f2613t, z, this.f2614u);
    }

    public static void m2585c(InboxActiveNowController inboxActiveNowController) {
        if (!((Boolean) inboxActiveNowController.f2595b.get()).booleanValue()) {
            inboxActiveNowController.m2584a(false, "mobile availability disabled");
        } else if (!inboxActiveNowController.f2603j || !inboxActiveNowController.f2604k) {
            inboxActiveNowController.m2584a(false, "not visible");
        } else if (inboxActiveNowController.f2605l != 2) {
            int max;
            long a = inboxActiveNowController.f2600g.a();
            LinearLayoutManager linearLayoutManager = (LinearLayoutManager) inboxActiveNowController.f2601h.getLayoutManager();
            int m = linearLayoutManager.m();
            int o = linearLayoutManager.o();
            int b = inboxActiveNowController.f2602i.b();
            if (m >= 0 && o < b && m <= o) {
                m = Math.min(b - 1, o + 3);
                for (max = Math.max(0, m - 3); max <= m; max++) {
                    InboxItem b2 = inboxActiveNowController.f2602i.b(max);
                    if (b2.a() == InboxItemType.V2_ACTIVE_NOW_LOADING || b2.a() == InboxItemType.V2_ACTIVE_NOW) {
                        max = 1;
                        break;
                    }
                }
            }
            max = 0;
            if (max != 0) {
                inboxActiveNowController.f2611r = a;
            }
            inboxActiveNowController.m2584a(a - inboxActiveNowController.f2611r < 300000, "viewport");
            if (inboxActiveNowController.f2612s) {
                inboxActiveNowController.m2587f();
            }
        }
    }

    private void m2584a(boolean z, String str) {
        Boolean.valueOf(z);
        if (this.f2612s != z) {
            this.f2612s = z;
            if (this.f2612s) {
                this.f2607n.a(this.f2608o);
                this.f2598e.a(this.f2609p);
                this.f2598e.a(this);
                m2589h();
                return;
            }
            this.f2607n.b();
            this.f2607n.a(null);
            this.f2598e.b(this.f2609p);
            this.f2598e.b(this);
            m2586e();
        }
    }

    private void m2586e() {
        this.f2613t = null;
        this.f2614u = 0;
        this.f2616w = false;
        this.f2615v = false;
    }

    private void m2587f() {
        if (this.f2610q == null) {
            this.f2610q = this.f2599f.schedule(new C04363(this), 1, TimeUnit.MINUTES);
        }
    }

    public static void m2588g(InboxActiveNowController inboxActiveNowController) {
        if (inboxActiveNowController.f2598e.K == PresenceDownloadState.MQTT_DISCONNECTED) {
            inboxActiveNowController.f2607n.b();
            inboxActiveNowController.m2586e();
            return;
        }
        inboxActiveNowController.m2589h();
    }

    private void m2589h() {
        if (!this.f2616w && !this.f2615v && this.f2598e.L == PresenceDownloadState.TP_FULL_LIST_RECEIVED) {
            this.f2607n.a();
        }
    }
}
