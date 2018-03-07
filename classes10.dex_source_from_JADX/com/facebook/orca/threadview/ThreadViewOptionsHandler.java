package com.facebook.orca.threadview;

import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.Menu;
import android.view.MenuItem;
import com.facebook.analytics.NavigationLogger;
import com.facebook.common.appchoreographer.AppChoreographer;
import com.facebook.common.appchoreographer.DefaultAppChoreographer;
import com.facebook.common.util.TriState;
import com.facebook.config.application.Product;
import com.facebook.config.application.ProductMethodAutoProvider;
import com.facebook.contacts.graphql.Contact;
import com.facebook.contacts.server.FetchContactsResult;
import com.facebook.contacts.util.ContactConverterUtil;
import com.facebook.debug.log.BLog;
import com.facebook.fbservice.service.DataFreshnessParam;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.messaging.cache.DataCache;
import com.facebook.messaging.chatheads.intents.ChatHeadsOpenHelper;
import com.facebook.messaging.chatheads.intents.ChatHeadsOpenHelper.2;
import com.facebook.messaging.chatheads.intents.ChatHeadsOpenHelper.3;
import com.facebook.messaging.contacts.loader.ContactLoader;
import com.facebook.messaging.contacts.loader.ContactLoader.Callback;
import com.facebook.messaging.dialog.MenuDialogFragment.Listener;
import com.facebook.messaging.dialog.MenuDialogItem;
import com.facebook.messaging.groups.threadactions.GroupThreadActionHandler;
import com.facebook.messaging.model.threadkey.ThreadKey;
import com.facebook.messaging.model.threadkey.ThreadKey.Type;
import com.facebook.messaging.model.threads.ThreadSummary;
import com.facebook.messaging.mutators.ThreadNotificationsDialogFragment;
import com.facebook.messaging.prefs.MessagingPrefKeys;
import com.facebook.messaging.util.launchtimeline.LaunchTimelineHelper;
import com.facebook.orca.contactcard.RemoveMembersFragment;
import com.facebook.orca.notify.NotificationSettingsUtil;
import com.facebook.orca.threadview.ThreadViewFragment.C11293;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferences.OnSharedPreferenceChangeListener;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.prefs.shared.PrefKey;
import com.facebook.user.cache.UserCache;
import com.facebook.user.model.UserKey;
import com.google.common.base.Objects;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: media_tray_item_view */
public class ThreadViewOptionsHandler {
    public static final Class<?> f7932b = ThreadViewOptionsHandler.class;
    public Listener f7933a = new C12011(this);
    public final DataCache f7934c;
    public final ContactLoader f7935d;
    public final ThreadViewOperationsHelper f7936e;
    private final Provider<Boolean> f7937f;
    private final NotificationSettingsUtil f7938g;
    private final Lazy<NavigationLogger> f7939h;
    private final FbSharedPreferences f7940i;
    public final GroupPhotoSettingsDialogFactory f7941j;
    private final Provider<TriState> f7942k;
    private final Lazy<LaunchTimelineHelper> f7943l;
    private final Product f7944m;
    public final DefaultAppChoreographer f7945n;
    public final UserCache f7946o;
    public FragmentManager f7947p;
    public C11293 f7948q;
    public ThreadKey f7949r;
    private String f7950s;
    public Contact f7951t;
    private Mode f7952u;
    private OnSharedPreferenceChangeListener f7953v;

    /* compiled from: media_tray_item_view */
    class C12011 implements Listener {
        final /* synthetic */ ThreadViewOptionsHandler f7928a;

        public final boolean m7880a(MenuDialogItem menuDialogItem, Object obj) {
            int i = menuDialogItem.a;
            ThreadSummary f = ThreadViewOptionsHandler.m7886f(this.f7928a);
            if (i == 2131558467) {
                ThreadViewOperationsHelper.m7877c(this.f7928a.f7947p, this.f7928a.f7949r);
            } else if (i == 2131558468) {
                this.f7928a.f7941j.m6570a(f).show();
            } else if (i == 2131558469) {
                r0 = this.f7928a.f7936e;
                r0.f7921b.m6572a(this.f7928a.f7949r);
            } else if (i == 2131558470) {
                r0 = this.f7928a.f7936e;
                FragmentManager fragmentManager = this.f7928a.f7947p;
                ThreadSummary a = this.f7928a.f7934c.a(this.f7928a.f7949r);
                RemoveMembersFragment removeMembersFragment = new RemoveMembersFragment();
                Bundle bundle = new Bundle();
                bundle.putParcelable("thread_summary", a);
                removeMembersFragment.g(bundle);
                DialogFragment dialogFragment = removeMembersFragment;
                FragmentTransaction a2 = fragmentManager.a();
                Fragment a3 = fragmentManager.a("remove_members_fragment");
                if (a3 != null) {
                    a2.a(a3);
                }
                dialogFragment.a(a2, "remove_members_fragment");
            } else if (i == 2131558471) {
                this.f7928a.f7936e.m7879b(this.f7928a.f7947p, f);
            } else if (i != 2131558472) {
                return false;
            } else {
                if (f != null) {
                    r0 = this.f7928a.f7936e;
                    ((GroupThreadActionHandler) r0.f7927h.get()).m2575a(this.f7928a.f7947p, f);
                }
            }
            return true;
        }

        C12011(ThreadViewOptionsHandler threadViewOptionsHandler) {
            this.f7928a = threadViewOptionsHandler;
        }
    }

    /* compiled from: media_tray_item_view */
    class C12022 implements Callback {
        final /* synthetic */ ThreadViewOptionsHandler f7929a;

        C12022(ThreadViewOptionsHandler threadViewOptionsHandler) {
            this.f7929a = threadViewOptionsHandler;
        }

        public final void m7881a(OperationResult operationResult) {
            FetchContactsResult fetchContactsResult = (FetchContactsResult) operationResult.k();
            if (fetchContactsResult != null && !fetchContactsResult.a.isEmpty()) {
                Contact contact = (Contact) fetchContactsResult.a.get(0);
                UserKey b = ContactConverterUtil.b(contact);
                UserKey a = ThreadKey.a(this.f7929a.f7949r);
                if (b != null && b.equals(a) && (this.f7929a.f7951t == null || !contact.o().equals(this.f7929a.f7951t.o()))) {
                    this.f7929a.f7948q.m7142a();
                }
                this.f7929a.f7951t = contact;
            }
        }

        public final void m7882a(Throwable th) {
            BLog.b(ThreadViewOptionsHandler.f7932b, "Fetching contact failed, error ", th);
        }
    }

    /* compiled from: media_tray_item_view */
    class C12033 implements OnSharedPreferenceChangeListener {
        final /* synthetic */ ThreadViewOptionsHandler f7930a;

        C12033(ThreadViewOptionsHandler threadViewOptionsHandler) {
            this.f7930a = threadViewOptionsHandler;
        }

        public final void m7883a(FbSharedPreferences fbSharedPreferences, PrefKey prefKey) {
            this.f7930a.f7948q.m7142a();
        }
    }

    /* compiled from: media_tray_item_view */
    public class C12044 implements Runnable {
        final /* synthetic */ ThreadViewOptionsHandler f7931a;

        public C12044(ThreadViewOptionsHandler threadViewOptionsHandler) {
            this.f7931a = threadViewOptionsHandler;
        }

        public void run() {
            this.f7931a.f7935d.a();
            UserKey a = ThreadKey.a(this.f7931a.f7949r);
            if (a != null) {
                this.f7931a.f7935d.a(a, DataFreshnessParam.PREFER_CACHE_IF_UP_TO_DATE);
            }
        }
    }

    /* compiled from: media_tray_item_view */
    public enum Mode {
        FOR_CHAT_HEAD,
        FOR_APP
    }

    public static ThreadViewOptionsHandler m7884a(InjectorLike injectorLike) {
        return new ThreadViewOptionsHandler(DataCache.a(injectorLike), ContactLoader.b(injectorLike), ThreadViewOperationsHelper.m7876b(injectorLike), IdBasedProvider.a(injectorLike, 4128), NotificationSettingsUtil.b(injectorLike), IdBasedSingletonScopeProvider.b(injectorLike, 137), (FbSharedPreferences) FbSharedPreferencesImpl.a(injectorLike), GroupPhotoSettingsDialogFactory.m6569b(injectorLike), IdBasedProvider.a(injectorLike, 643), IdBasedLazy.a(injectorLike, 8599), ProductMethodAutoProvider.b(injectorLike), DefaultAppChoreographer.a(injectorLike), UserCache.a(injectorLike));
    }

    @Inject
    public ThreadViewOptionsHandler(DataCache dataCache, ContactLoader contactLoader, ThreadViewOperationsHelper threadViewOperationsHelper, Provider<Boolean> provider, NotificationSettingsUtil notificationSettingsUtil, Lazy<NavigationLogger> lazy, FbSharedPreferences fbSharedPreferences, GroupPhotoSettingsDialogFactory groupPhotoSettingsDialogFactory, Provider<TriState> provider2, Lazy<LaunchTimelineHelper> lazy2, Product product, AppChoreographer appChoreographer, UserCache userCache) {
        this.f7934c = dataCache;
        this.f7935d = contactLoader;
        this.f7936e = threadViewOperationsHelper;
        this.f7937f = provider;
        this.f7938g = notificationSettingsUtil;
        this.f7939h = lazy;
        this.f7940i = fbSharedPreferences;
        this.f7941j = groupPhotoSettingsDialogFactory;
        this.f7942k = provider2;
        this.f7943l = lazy2;
        this.f7944m = product;
        this.f7945n = appChoreographer;
        this.f7946o = userCache;
    }

    public final void m7889a(C11293 c11293, FragmentManager fragmentManager, Mode mode) {
        this.f7948q = c11293;
        this.f7947p = fragmentManager;
        this.f7952u = mode;
        this.f7935d.c = new C12022(this);
        this.f7953v = new C12033(this);
    }

    public final void m7888a(ThreadKey threadKey) {
        if (!Objects.equal(threadKey, this.f7949r)) {
            if (this.f7949r != null) {
                PrefKey a = MessagingPrefKeys.a(this.f7949r);
                if (a != null) {
                    this.f7940i.b(a, this.f7953v);
                }
            }
            this.f7949r = threadKey;
            this.f7951t = null;
            this.f7935d.a();
            if (this.f7949r != null) {
                this.f7940i.a(MessagingPrefKeys.a(this.f7949r), this.f7953v);
                this.f7948q.m7142a();
            }
        }
    }

    public final boolean m7890a(MenuItem menuItem, String str) {
        if (this.f7949r == null) {
            return false;
        }
        int itemId = menuItem.getItemId();
        this.f7950s = str;
        ((NavigationLogger) this.f7939h.get()).a("tap_thread_option");
        if (itemId == 2131568678) {
            ThreadNotificationsDialogFragment.m3248a(this.f7949r).a(this.f7947p, "notificationSettingsDialog");
            return true;
        } else if (itemId == 2131568679) {
            this.f7938g.b(this.f7949r);
            return true;
        } else if (itemId == 2131568611) {
            ThreadViewOperationsHelper threadViewOperationsHelper = this.f7936e;
            ThreadKey threadKey = this.f7949r;
            FragmentManager fragmentManager = this.f7947p;
            ChatHeadsOpenHelper chatHeadsOpenHelper;
            String str2;
            if (threadKey.a == Type.GROUP) {
                chatHeadsOpenHelper = threadViewOperationsHelper.f7923d;
                long j = threadKey.b;
                str2 = "context_pop_out_selected";
                if (chatHeadsOpenHelper.d.a()) {
                    ChatHeadsOpenHelper.a(chatHeadsOpenHelper, j, str2);
                } else {
                    chatHeadsOpenHelper.e = new 2(chatHeadsOpenHelper, j, str2);
                    ChatHeadsOpenHelper.a(fragmentManager);
                }
            } else if (ThreadKey.b(threadKey)) {
                chatHeadsOpenHelper = threadViewOperationsHelper.f7923d;
                str2 = Long.toString(threadKey.d);
                String str3 = "context_pop_out_selected";
                if (chatHeadsOpenHelper.d.a()) {
                    ChatHeadsOpenHelper.a(chatHeadsOpenHelper, str2, null, str3);
                } else {
                    chatHeadsOpenHelper.e = new 3(chatHeadsOpenHelper, str2, null, str3);
                    ChatHeadsOpenHelper.a(fragmentManager);
                }
            } else {
                threadViewOperationsHelper.f7923d.a(threadKey, fragmentManager, "context_pop_out_selected");
            }
            return true;
        } else if (itemId == 2131568646) {
            return true;
        } else {
            if (itemId == 2131568696) {
                ((LaunchTimelineHelper) this.f7943l.get()).a(this.f7951t, this.f7947p);
                return true;
            } else if (itemId == 2131568625) {
                ThreadViewOperationsHelper.m7875a(this.f7947p, this.f7949r);
                return true;
            } else if (itemId != 2131568695) {
                return false;
            } else {
                ThreadViewOperationsHelper.m7874a(this.f7947p, this.f7933a);
                return true;
            }
        }
    }

    private static void m7885a(Menu menu, int i, boolean z) {
        MenuItem findItem = menu.findItem(i);
        if (findItem != null) {
            findItem.setVisible(z);
        }
    }

    public final void m7887a(Menu menu) {
        boolean z;
        ThreadSummary f = m7886f(this);
        if (f != null && f.a.a == Type.GROUP && f.w && f.u) {
            z = true;
        } else {
            z = false;
        }
        boolean z2 = z;
        m7885a(menu, 2131568696, false);
        m7885a(menu, 2131568695, false);
        m7885a(menu, 2131558470, z2);
        m7885a(menu, 2131568611, false);
        m7885a(menu, 2131568646, this.f7952u != Mode.FOR_APP);
        m7885a(menu, 2131568625, false);
        m7885a(menu, 2131568679, false);
        m7885a(menu, 2131568678, false);
    }

    public static ThreadSummary m7886f(ThreadViewOptionsHandler threadViewOptionsHandler) {
        if (threadViewOptionsHandler.f7949r == null) {
            return null;
        }
        return threadViewOptionsHandler.f7934c.a(threadViewOptionsHandler.f7949r);
    }
}
