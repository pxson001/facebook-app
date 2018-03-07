package com.facebook.orca.threadview;

import android.content.Context;
import android.support.v4.app.FragmentManager;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import com.facebook.common.android.InputMethodManagerMethodAutoProvider;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.contacts.picker.ContactPickerUserRow;
import com.facebook.contacts.picker.ContactPickerUserRow.MenuHandler;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.Lazy;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.messaging.groups.admin.GroupAdminController;
import com.facebook.messaging.groups.admin.GroupsAdminLogger;
import com.facebook.messaging.groups.threadactions.AdminActionDialogFragment;
import com.facebook.messaging.groups.threadactions.AdminActionDialogParams.Builder;
import com.facebook.messaging.groups.threadactions.GroupThreadActionHandler;
import com.facebook.messaging.model.threads.ThreadSummary;
import com.facebook.orca.threadview.ThreadViewMessagesFragment.AnonymousClass20;
import com.facebook.rtc.helpers.RtcCallHandler;
import com.facebook.user.model.User;
import com.facebook.user.model.UserKey;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;

@ContextScoped
/* compiled from: messenger_flower_border */
public class MessengerContactRowMenuHelper {
    private static MessengerContactRowMenuHelper f7240q;
    private static final Object f7241r = new Object();
    public final Context f7242a;
    public final InputMethodManager f7243b;
    public final RtcCallHandler f7244c;
    public final Provider<Boolean> f7245d;
    public final Provider<Boolean> f7246e;
    public final GroupThreadMembersActions f7247f;
    public final Provider<Boolean> f7248g;
    public final Provider<UserKey> f7249h;
    public final GroupAdminController f7250i;
    public final Lazy<GroupThreadActionHandler> f7251j;
    public final Lazy<GroupsAdminLogger> f7252k;
    public final MenuHandler f7253l;
    public RemoveMembersHelper f7254m;
    public AnonymousClass20 f7255n;
    public FragmentManager f7256o;
    @Nullable
    public ThreadSummary f7257p;

    private static MessengerContactRowMenuHelper m6927b(InjectorLike injectorLike) {
        return new MessengerContactRowMenuHelper((Context) injectorLike.getInstance(Context.class), InputMethodManagerMethodAutoProvider.b(injectorLike), RtcCallHandler.a(injectorLike), IdBasedProvider.a(injectorLike, 4302), GroupThreadMembersActions.m6571b(injectorLike), IdBasedProvider.a(injectorLike, 4314), IdBasedProvider.a(injectorLike, 3902), IdBasedProvider.a(injectorLike, 3597), GroupAdminController.m2341b(injectorLike), IdBasedLazy.a(injectorLike, 7872), IdBasedLazy.a(injectorLike, 7862));
    }

    public static MessengerContactRowMenuHelper m6926a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            MessengerContactRowMenuHelper b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f7241r) {
                MessengerContactRowMenuHelper messengerContactRowMenuHelper;
                if (a2 != null) {
                    messengerContactRowMenuHelper = (MessengerContactRowMenuHelper) a2.a(f7241r);
                } else {
                    messengerContactRowMenuHelper = f7240q;
                }
                if (messengerContactRowMenuHelper == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m6927b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f7241r, b3);
                        } else {
                            f7240q = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = messengerContactRowMenuHelper;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Inject
    public MessengerContactRowMenuHelper(Context context, InputMethodManager inputMethodManager, RtcCallHandler rtcCallHandler, Provider<Boolean> provider, GroupThreadMembersActions groupThreadMembersActions, Provider<Boolean> provider2, Provider<Boolean> provider3, Provider<UserKey> provider4, final GroupAdminController groupAdminController, Lazy<GroupThreadActionHandler> lazy, Lazy<GroupsAdminLogger> lazy2) {
        this.f7242a = context;
        this.f7243b = inputMethodManager;
        this.f7244c = rtcCallHandler;
        this.f7245d = provider;
        this.f7246e = provider2;
        this.f7247f = groupThreadMembersActions;
        this.f7248g = provider3;
        this.f7249h = provider4;
        this.f7250i = groupAdminController;
        this.f7251j = lazy;
        this.f7252k = lazy2;
        this.f7253l = new MenuHandler(this) {
            public final /* synthetic */ MessengerContactRowMenuHelper f7239b;

            public final void m6923a(View view) {
                this.f7239b.f7243b.hideSoftInputFromWindow(view.getWindowToken(), 0);
            }

            public final void m6924a(ContactPickerUserRow contactPickerUserRow, Menu menu, MenuInflater menuInflater) {
                boolean z;
                menuInflater.inflate(2131820558, menu);
                boolean z2 = true;
                User user = contactPickerUserRow.a;
                boolean equals = user.T.equals(this.f7239b.f7249h.get());
                boolean z3 = this.f7239b.f7257p != null && this.f7239b.f7257p.a.b();
                if (!((Boolean) this.f7239b.f7246e.get()).booleanValue() || equals) {
                    z = false;
                } else {
                    z = true;
                }
                C10871.m6922a(menu, 2131568632, z);
                if (!((Boolean) this.f7239b.f7245d.get()).booleanValue() || equals) {
                    z = false;
                } else {
                    z = true;
                }
                C10871.m6922a(menu, 2131568633, z);
                if (equals || user.E || ((Boolean) this.f7239b.f7248g.get()).booleanValue()) {
                    z = false;
                } else {
                    z = true;
                }
                C10871.m6922a(menu, 2131568634, z);
                if (equals || !z3) {
                    z = false;
                } else {
                    z = true;
                }
                C10871.m6922a(menu, 2131568631, z);
                if (!z3 || equals) {
                    z = false;
                } else {
                    z = true;
                }
                C10871.m6922a(menu, 2131568635, z);
                C10871.m6922a(menu, 2131558472, equals);
                z = this.f7239b.f7250i.m2344a(this.f7239b.f7257p);
                boolean c = this.f7239b.f7250i.m2346c(this.f7239b.f7257p);
                if (z3 && z) {
                    if (equals) {
                        z2 = c;
                        z = false;
                    } else {
                        z3 = this.f7239b.f7250i.m2345a(this.f7239b.f7257p, user.T);
                        if (!c || z3) {
                            z = false;
                        } else {
                            z = true;
                        }
                        if (c && z3) {
                        }
                    }
                    C10871.m6922a(menu, 2131568629, z);
                    C10871.m6922a(menu, 2131568630, z2);
                    if (user.A) {
                        menu.removeItem(2131568632);
                        menu.removeItem(2131568633);
                        menu.removeItem(2131568634);
                        menu.removeItem(2131568635);
                        menu.removeItem(2131568629);
                        menu.removeItem(2131568630);
                    }
                }
                z = false;
                z2 = false;
                C10871.m6922a(menu, 2131568629, z);
                C10871.m6922a(menu, 2131568630, z2);
                if (user.A) {
                    menu.removeItem(2131568632);
                    menu.removeItem(2131568633);
                    menu.removeItem(2131568634);
                    menu.removeItem(2131568635);
                    menu.removeItem(2131568629);
                    menu.removeItem(2131568630);
                }
            }

            public final boolean m6925a(MenuItem menuItem, ContactPickerUserRow contactPickerUserRow) {
                final User user = contactPickerUserRow.a;
                int itemId = menuItem.getItemId();
                if (itemId == 2131568631) {
                    this.f7239b.f7247f.m6573a(user);
                    return true;
                } else if (itemId == 2131568635) {
                    groupAdminController.m2343a(this.f7239b.f7257p, new Object(this) {
                        public final /* synthetic */ C10871 f7237b;

                        public final void m6921a() {
                            this.f7237b.f7239b.f7254m.m6997a(this.f7237b.f7239b.f7242a, user, this.f7237b.f7239b.f7257p);
                        }
                    });
                    return true;
                } else if (itemId == 2131568634) {
                    this.f7239b.f7255n.m7448a(user, Boolean.valueOf(true));
                    return true;
                } else if (itemId == 2131568632) {
                    this.f7239b.f7244c.a(this.f7239b.f7242a, user.T, "thread_group_settings");
                    return true;
                } else if (itemId == 2131568633) {
                    this.f7239b.f7244c.b(this.f7239b.f7242a, user.T, "thread_group_settings_video");
                    return true;
                } else if (itemId == 2131568629) {
                    GroupThreadActionHandler groupThreadActionHandler = (GroupThreadActionHandler) this.f7239b.f7251j.get();
                    UserKey userKey = contactPickerUserRow.a.T;
                    String j = contactPickerUserRow.a.j();
                    ThreadSummary threadSummary = this.f7239b.f7257p;
                    FragmentManager fragmentManager = this.f7239b.f7256o;
                    if (groupThreadActionHandler.f2577a.m2344a(threadSummary)) {
                        Builder builder = new Builder();
                        builder.f2545a = threadSummary.a;
                        builder = builder;
                        builder.f2546b = userKey;
                        builder = builder;
                        builder.f2551g = "add_admins_to_group";
                        builder = builder;
                        Builder builder2;
                        if (groupThreadActionHandler.f2577a.m2346c(threadSummary)) {
                            builder.f2547c = groupThreadActionHandler.f2578b.getString(2131231908);
                            builder2 = builder;
                            builder2.f2548d = groupThreadActionHandler.f2578b.getString(2131231909, new Object[]{j});
                            builder2 = builder2;
                            builder2.f2549e = groupThreadActionHandler.f2578b.getString(2131231916);
                            builder2.f2550f = groupThreadActionHandler.f2578b.getString(2131231919);
                            AdminActionDialogFragment.m2560a(builder.m2563h()).a(fragmentManager, "addAdminsDialog");
                        } else if (!groupThreadActionHandler.f2577a.m2347e(threadSummary)) {
                            builder.f2547c = groupThreadActionHandler.f2578b.getString(2131231910);
                            builder2 = builder;
                            builder2.f2548d = groupThreadActionHandler.f2578b.getString(2131231911);
                            builder2 = builder2;
                            builder2.f2549e = groupThreadActionHandler.f2578b.getString(2131231917);
                            builder2.f2550f = groupThreadActionHandler.f2578b.getString(2131231920);
                            AdminActionDialogFragment.m2560a(builder.m2563h()).a(fragmentManager, "becomeAdminsDialog");
                        }
                    }
                    return true;
                } else {
                    if (itemId == 2131568630) {
                        ((GroupThreadActionHandler) this.f7239b.f7251j.get()).m2577b(contactPickerUserRow.a.T, contactPickerUserRow.a.j(), this.f7239b.f7257p, this.f7239b.f7256o);
                    } else if (itemId == 2131558472) {
                        ((GroupThreadActionHandler) this.f7239b.f7251j.get()).m2575a(this.f7239b.f7256o, this.f7239b.f7257p);
                    }
                    return false;
                }
            }

            public static void m6922a(Menu menu, int i, boolean z) {
                if (!z) {
                    menu.removeItem(i);
                }
            }
        };
    }
}
