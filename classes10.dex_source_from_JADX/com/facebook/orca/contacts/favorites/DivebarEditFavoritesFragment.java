package com.facebook.orca.contacts.favorites;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.SearchView.OnCloseListener;
import android.support.v7.widget.SearchView.OnQueryTextListener;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.facebook.actionbar.ActionBarOwner;
import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.event.HoneyClientEventFast;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.common.android.LayoutInflaterMethodAutoProvider;
import com.facebook.common.executors.DefaultAndroidThreadUtil;
import com.facebook.common.util.ContextUtils;
import com.facebook.common.util.actionbar.ActionBarContextUtils;
import com.facebook.config.application.Boolean_IsWorkBuildMethodAutoProvider;
import com.facebook.config.application.Product;
import com.facebook.config.application.ProductMethodAutoProvider;
import com.facebook.contacts.cache.FavoriteContactsCache;
import com.facebook.contacts.picker.ContactPickerListFilter.RowCreator;
import com.facebook.contacts.picker.ContactPickerRow;
import com.facebook.contacts.picker.ContactPickerUserRow.ContactRowSectionType;
import com.facebook.contacts.server.UpdateFavoriteContactsParams;
import com.facebook.debug.log.BLog;
import com.facebook.fbservice.ops.DefaultBlueServiceOperationFactory;
import com.facebook.fbservice.ops.DialogBasedProgressIndicator;
import com.facebook.fbui.dialog.AlertDialog;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedProvider;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.messaging.contacts.loader.ContactListsCache;
import com.facebook.messaging.contacts.loader.ContactsLoader;
import com.facebook.messaging.contacts.loader.ContactsLoader.FriendLists;
import com.facebook.messaging.contacts.loader.ContactsLoader.InitParams;
import com.facebook.messaging.contacts.loader.ContactsLoaderFactory;
import com.facebook.messaging.contacts.picker.ContactPickerRows;
import com.facebook.messaging.model.threads.ThreadSummary;
import com.facebook.orca.common.ui.widgets.FavoritesDragSortListView;
import com.facebook.orca.contacts.favorites.DivebarEditFavoritesDataSource.C08741;
import com.facebook.orca.contacts.favorites.DivebarEditFavoritesDataSource.C08752;
import com.facebook.tools.dextr.runtime.detour.AdapterDetour;
import com.facebook.tools.dextr.runtime.detour.BlueServiceOperationFactoryDetour;
import com.facebook.ui.dialogs.FbAlertDialogBuilder;
import com.facebook.ui.drawers.DrawerContentFragment;
import com.facebook.ui.errordialog.ErrorDialogParams;
import com.facebook.ui.errordialog.ErrorDialogParamsBuilder;
import com.facebook.ui.errordialog.ErrorDialogs;
import com.facebook.user.model.User;
import com.facebook.user.model.UserIdentifier;
import com.facebook.widget.listview.DragSortListView.DropListener;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.collect.RegularImmutableList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.Set;
import javax.annotation.Nullable;

/* compiled from: onLargeAssetStateChanged */
public class DivebarEditFavoritesFragment extends DrawerContentFragment {
    public static final Class<?> f5948b = DivebarEditFavoritesFragment.class;
    RowCreator f5949a;
    private boolean al;
    public boolean am;
    private boolean an;
    public MenuItem ao;
    public AlertDialog ap;
    private Product aq;
    public DivebarEditFavoritesRowViewFactory ar;
    private FavoritesEditListAdapterProvider as;
    private DivebarEditFavoritesDataSourceProvider at;
    public DivebarEditFavoritesDataSource au;
    private DropListener av = new C08825(this);
    private FavoritesEditListAdapter f5950c;
    private AnalyticsLogger f5951d;
    private ErrorDialogs f5952e;
    private DialogBasedProgressIndicator f5953f;
    public FaveditPicker f5954g;
    private FavoritesDragSortListView f5955h;
    private Context f5956i;

    /* compiled from: onLargeAssetStateChanged */
    public class C08761 {
        final /* synthetic */ DivebarEditFavoritesFragment f5936a;

        C08761(DivebarEditFavoritesFragment divebarEditFavoritesFragment) {
            this.f5936a = divebarEditFavoritesFragment;
        }

        public final void m5575a() {
            this.f5936a.at();
        }

        public final void m5576b() {
            DivebarEditFavoritesFragment.aC(this.f5936a);
            this.f5936a.av();
        }
    }

    /* compiled from: onLargeAssetStateChanged */
    class C08792 implements RowCreator {
        final /* synthetic */ DivebarEditFavoritesFragment f5939a;

        /* compiled from: onLargeAssetStateChanged */
        public class C08771 {
            final /* synthetic */ C08792 f5937a;

            C08771(C08792 c08792) {
                this.f5937a = c08792;
            }

            public final void m5577a(User user) {
                DivebarEditFavoritesFragment.aC(this.f5937a.f5939a);
                DivebarEditFavoritesFragment.m5595c(this.f5937a.f5939a, user);
            }
        }

        /* compiled from: onLargeAssetStateChanged */
        public class C08782 {
            final /* synthetic */ C08792 f5938a;

            C08782(C08792 c08792) {
                this.f5938a = c08792;
            }

            public final void m5578a() {
                DivebarEditFavoritesFragment.aC(this.f5938a.f5939a);
            }
        }

        C08792(DivebarEditFavoritesFragment divebarEditFavoritesFragment) {
            this.f5939a = divebarEditFavoritesFragment;
        }

        public final ContactPickerRow m5579a(Object obj) {
            if (obj instanceof User) {
                AddFavoriteContactRow addFavoriteContactRow;
                User user = (User) obj;
                int i = -1;
                if (i == -1 || this.f5939a.aw() < i) {
                    addFavoriteContactRow = new AddFavoriteContactRow(user);
                } else {
                    addFavoriteContactRow = new NonAddableFavoriteContactRow(user);
                }
                addFavoriteContactRow.f5912b = new C08771(this);
                return addFavoriteContactRow;
            } else if (obj instanceof ThreadSummary) {
                ContactPickerRow addFavoriteGroupRow = new AddFavoriteGroupRow((ThreadSummary) obj);
                addFavoriteGroupRow.f5922b = new C08782(this);
                return addFavoriteGroupRow;
            } else {
                BLog.a(DivebarEditFavoritesFragment.f5948b, "unexpected rowData of type: " + obj.getClass());
                throw new IllegalArgumentException();
            }
        }
    }

    /* compiled from: onLargeAssetStateChanged */
    class C08803 implements OnCloseListener {
        final /* synthetic */ DivebarEditFavoritesFragment f5940a;

        C08803(DivebarEditFavoritesFragment divebarEditFavoritesFragment) {
            this.f5940a = divebarEditFavoritesFragment;
        }

        public final boolean m5580a() {
            return false;
        }
    }

    /* compiled from: onLargeAssetStateChanged */
    class C08814 implements OnQueryTextListener {
        final /* synthetic */ DivebarEditFavoritesFragment f5941a;

        C08814(DivebarEditFavoritesFragment divebarEditFavoritesFragment) {
            this.f5941a = divebarEditFavoritesFragment;
        }

        public final boolean m5581a(String str) {
            return false;
        }

        public final boolean m5582b(String str) {
            if (MenuItemCompat.c(this.f5941a.ao)) {
                this.f5941a.f5954g.m5635a(str);
            } else {
                this.f5941a.f5954g.m5633a();
            }
            return false;
        }
    }

    /* compiled from: onLargeAssetStateChanged */
    class C08825 implements DropListener {
        final /* synthetic */ DivebarEditFavoritesFragment f5942a;

        C08825(DivebarEditFavoritesFragment divebarEditFavoritesFragment) {
            this.f5942a = divebarEditFavoritesFragment;
        }

        public final void m5583a(int i, int i2) {
            Object obj;
            int b = i - DivebarEditFavoritesFragment.aH(this.f5942a).m5642b();
            int b2 = i2 - DivebarEditFavoritesFragment.aH(this.f5942a).m5642b();
            DivebarEditFavoritesDataSource divebarEditFavoritesDataSource = this.f5942a.au;
            if (b2 < 0 || b2 >= divebarEditFavoritesDataSource.f5932h.size() || b == b2) {
                obj = null;
            } else {
                User user = (User) divebarEditFavoritesDataSource.f5932h.get(b);
                divebarEditFavoritesDataSource.f5932h.remove(user);
                divebarEditFavoritesDataSource.f5932h.add(b2, user);
                obj = 1;
            }
            if (obj != null) {
                DivebarEditFavoritesFragment.aE(this.f5942a);
                DivebarEditFavoritesFragment.aF(this.f5942a);
            }
        }
    }

    /* compiled from: onLargeAssetStateChanged */
    class C08847 implements OnCancelListener {
        final /* synthetic */ DivebarEditFavoritesFragment f5945a;

        C08847(DivebarEditFavoritesFragment divebarEditFavoritesFragment) {
            this.f5945a = divebarEditFavoritesFragment;
        }

        public void onCancel(DialogInterface dialogInterface) {
            this.f5945a.ap = null;
        }
    }

    /* compiled from: onLargeAssetStateChanged */
    public class C08858 {
        final /* synthetic */ DivebarEditFavoritesFragment f5946a;

        C08858(DivebarEditFavoritesFragment divebarEditFavoritesFragment) {
            this.f5946a = divebarEditFavoritesFragment;
        }

        public final void m5584a(User user) {
            this.f5946a.m5606a(user);
        }
    }

    /* compiled from: onLargeAssetStateChanged */
    class C08869 implements OnClickListener {
        final /* synthetic */ DivebarEditFavoritesFragment f5947a;

        C08869(DivebarEditFavoritesFragment divebarEditFavoritesFragment) {
            this.f5947a = divebarEditFavoritesFragment;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            this.f5947a.av();
        }
    }

    public final void m5609c(Bundle bundle) {
        super.c(bundle);
        this.f5956i = ContextUtils.a(getContext(), 2130772966, 2131625115);
        FbInjector fbInjector = FbInjector.get(this.f5956i);
        this.ar = new DivebarEditFavoritesRowViewFactory((Context) fbInjector.getInstance(Context.class));
        this.as = (FavoritesEditListAdapterProvider) fbInjector.getOnDemandAssistedProviderForStaticDi(FavoritesEditListAdapterProvider.class);
        this.f5951d = AnalyticsLoggerMethodAutoProvider.a(fbInjector);
        this.aq = ProductMethodAutoProvider.b(fbInjector);
        this.f5952e = ErrorDialogs.a(fbInjector);
        this.at = (DivebarEditFavoritesDataSourceProvider) fbInjector.getOnDemandAssistedProviderForStaticDi(DivebarEditFavoritesDataSourceProvider.class);
        this.an = Boolean_IsWorkBuildMethodAutoProvider.a(fbInjector).booleanValue();
        e(az());
    }

    public final View m5603a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1139402299);
        this.f5954g = m5586a(aH(this));
        this.f5954g.setOnButtonClickedListener(new C08761(this));
        this.f5954g.setSearchHint(b(2131231202));
        ViewGroup viewGroup2 = (ViewGroup) layoutInflater.cloneInContext(this.f5956i).inflate(2130905687, null);
        View thisView = this.f5954g.getThisView();
        ViewParent parent = thisView.getParent();
        if (parent != null) {
            ((ViewGroup) parent).removeView(thisView);
        }
        viewGroup2.addView(thisView);
        this.f5949a = new C08792(this);
        aH(this).d().a(this.f5949a);
        this.f5955h = this.f5954g.getDraggableList();
        this.f5955h.m = this.av;
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 557225253, a);
        return viewGroup2;
    }

    public final void m5610d(Bundle bundle) {
        ImmutableList immutableList;
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1837553016);
        super.d(bundle);
        if (bundle != null) {
            this.am = bundle.getBoolean("dirty", false);
        }
        this.au = aL();
        DivebarEditFavoritesDataSource divebarEditFavoritesDataSource = this.au;
        if (divebarEditFavoritesDataSource.f5931g == null) {
            ContactsLoaderFactory contactsLoaderFactory = divebarEditFavoritesDataSource.f5928d;
            ContactsLoader contactsLoader = (ContactsLoader) contactsLoaderFactory.b.get();
            contactsLoader.v = new InitParams(EnumSet.of(FriendLists.FAVORITE_FRIENDS, FriendLists.TOP_FRIENDS_ON_MESSENGER, FriendLists.TOP_FRIENDS, FriendLists.TOP_PHONE_CONTACTS));
            divebarEditFavoritesDataSource.f5931g = contactsLoader;
        }
        divebarEditFavoritesDataSource.f5931g.a(new C08741(divebarEditFavoritesDataSource));
        divebarEditFavoritesDataSource.f5934j = true;
        Collection b = divebarEditFavoritesDataSource.f5926b.b();
        if (bundle != null && bundle.getBoolean("dirty", false) && bundle.containsKey("favorites")) {
            divebarEditFavoritesDataSource.f5934j = false;
            immutableList = ((UpdateFavoriteContactsParams) bundle.getParcelable("favorites")).a;
        } else {
            immutableList = null;
        }
        Collection collection = immutableList;
        if (collection != null) {
            divebarEditFavoritesDataSource.f5932h = new ArrayList(collection);
        } else if (b != null) {
            divebarEditFavoritesDataSource.f5932h = new ArrayList(b);
        } else {
            divebarEditFavoritesDataSource.f5932h = new ArrayList();
        }
        ImmutableList c = divebarEditFavoritesDataSource.f5927c.c();
        if (c != null) {
            divebarEditFavoritesDataSource.f5933i = new ArrayList(c);
        }
        divebarEditFavoritesDataSource.f5931g.a();
        aF(this);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -133914834, a);
    }

    public final void m5605a(Menu menu, MenuInflater menuInflater) {
        this.ao = null;
        if (az()) {
            menuInflater.inflate(2131820571, menu);
            m5598e(menu.findItem(2131568656));
        }
        super.a(menu, menuInflater);
    }

    private boolean az() {
        return aB() != null;
    }

    private void m5598e(MenuItem menuItem) {
        this.ao = menuItem;
        aA();
        SearchView searchView = (SearchView) MenuItemCompat.a(this.ao);
        searchView.setQueryHint(getContext().getString(this.an ? 2131231204 : 2131231203));
        searchView.setIconifiedByDefault(false);
        searchView.mOnCloseListener = new C08803(this);
        searchView.mOnQueryChangeListener = new C08814(this);
    }

    private void aA() {
        Context context = getContext();
        this.ao.setIcon(ActionBarContextUtils.a(context, 2131625159, 2130841432, ContextCompat.b(context, 2131362288)));
    }

    private ActionBar aB() {
        Activity ao = ao();
        if (ao instanceof ActionBarOwner) {
            return ((ActionBarOwner) ao).a();
        }
        return null;
    }

    public final void m5611e(Bundle bundle) {
        super.e(bundle);
        bundle.putBoolean("dirty", this.am);
        if (this.am) {
            DivebarEditFavoritesDataSource divebarEditFavoritesDataSource = this.au;
            if (divebarEditFavoritesDataSource.f5932h != null) {
                bundle.putParcelable("favorites", new UpdateFavoriteContactsParams(divebarEditFavoritesDataSource.f5932h));
            }
        }
    }

    public final void m5601G() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1575705002);
        super.G();
        if (this.al) {
            av();
            this.al = false;
        }
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -1649971281, a);
    }

    public final void m5602H() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1530890892);
        super.H();
        if (this.ap != null) {
            this.ap.dismiss();
            this.ap = null;
        }
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 1332183933, a);
    }

    public final boolean m5612e() {
        aC(this);
        return false;
    }

    public static void aC(DivebarEditFavoritesFragment divebarEditFavoritesFragment) {
        divebarEditFavoritesFragment.f5954g.m5633a();
        if (divebarEditFavoritesFragment.ao != null) {
            SearchView searchView = (SearchView) MenuItemCompat.a(divebarEditFavoritesFragment.ao);
            if (searchView.getQuery().length() != 0) {
                searchView.setQuery("", true);
            }
        }
    }

    final void at() {
        aC(this);
        if (this.am) {
            aG();
        } else {
            av();
        }
    }

    protected final void m5606a(final User user) {
        if (Product.MESSENGER.equals(this.aq)) {
            m5593b(user);
            return;
        }
        OnClickListener c08836 = new OnClickListener(this) {
            final /* synthetic */ DivebarEditFavoritesFragment f5944b;

            public void onClick(DialogInterface dialogInterface, int i) {
                switch (i) {
                    case -1:
                        this.f5944b.m5593b(user);
                        break;
                }
                this.f5944b.ap = null;
            }
        };
        this.ap = new FbAlertDialogBuilder(getContext()).b(b(2131231214)).a(b(2131230735), c08836).b(b(2131230736), c08836).a(new C08847(this)).b();
    }

    private void m5593b(User user) {
        this.au.f5932h.remove(user);
        aE(this);
        aF(this);
    }

    public static void m5595c(DivebarEditFavoritesFragment divebarEditFavoritesFragment, User user) {
        divebarEditFavoritesFragment.au.f5932h.add(user);
        aE(divebarEditFavoritesFragment);
        aF(divebarEditFavoritesFragment);
        int d = divebarEditFavoritesFragment.au.m5574d() - 1;
        if (d < divebarEditFavoritesFragment.f5955h.getFirstVisiblePosition()) {
            divebarEditFavoritesFragment.f5955h.smoothScrollToPosition(d);
        }
    }

    private ImmutableList<UserIdentifier> aD() {
        ImmutableList b = this.au.m5573b();
        Builder builder = ImmutableList.builder();
        int size = b.size();
        for (int i = 0; i < size; i++) {
            builder.c(((User) b.get(i)).U);
        }
        return builder.b();
    }

    final boolean au() {
        return this.am;
    }

    public static void aE(DivebarEditFavoritesFragment divebarEditFavoritesFragment) {
        divebarEditFavoritesFragment.am = true;
    }

    private ImmutableList<ContactPickerRow> m5587a(ImmutableList<User> immutableList) {
        Builder builder = ImmutableList.builder();
        if (immutableList == null || immutableList.isEmpty()) {
            builder.c(ContactPickerRows.f1908e);
            return builder.b();
        }
        ContactRowSectionType contactRowSectionType = ContactRowSectionType.FAVORITES;
        Object obj = null;
        if (obj != null) {
            builder.c(obj);
        }
        int size = immutableList.size();
        for (int i = 0; i < size; i++) {
            FavoriteContactRow favoriteContactRow = new FavoriteContactRow((User) immutableList.get(i));
            favoriteContactRow.f5982b = new C08858(this);
            builder.c(favoriteContactRow);
        }
        return builder.b();
    }

    private ImmutableList<ContactPickerRow> m5591b(ImmutableList<User> immutableList) {
        Builder builder = ImmutableList.builder();
        if (!(immutableList == null || immutableList.isEmpty())) {
            ContactPickerRow contactPickerRow = ContactPickerRows.f1907d;
            if (contactPickerRow != null) {
                builder.c(contactPickerRow);
            }
            ContactRowSectionType contactRowSectionType = ContactRowSectionType.TOP_FRIENDS;
            Object obj = null;
            if (obj != null) {
                builder.c(obj);
            }
            int size = immutableList.size();
            for (int i = 0; i < size; i++) {
                builder.c(this.f5949a.a((User) immutableList.get(i)));
            }
        }
        return builder.b();
    }

    public static void aF(DivebarEditFavoritesFragment divebarEditFavoritesFragment) {
        ImmutableList immutableList;
        int i;
        int i2 = 0;
        ImmutableList b = divebarEditFavoritesFragment.au.m5573b();
        DivebarEditFavoritesDataSource divebarEditFavoritesDataSource = divebarEditFavoritesFragment.au;
        if (divebarEditFavoritesDataSource.f5933i == null || divebarEditFavoritesDataSource.f5933i.isEmpty()) {
            immutableList = RegularImmutableList.a;
        } else {
            immutableList = ImmutableList.copyOf(divebarEditFavoritesDataSource.f5933i);
        }
        ImmutableList immutableList2 = immutableList;
        Builder builder = ImmutableList.builder();
        Set hashSet = new HashSet();
        int size = b.size();
        for (i = 0; i < size; i++) {
            hashSet.add(((User) b.get(i)).T);
        }
        if (immutableList2 != null) {
            i = immutableList2.size();
            while (i2 < i) {
                User user = (User) immutableList2.get(i2);
                if (!hashSet.contains(user.T)) {
                    builder.c(user);
                }
                i2++;
            }
        }
        ImmutableList b2 = builder.b();
        Builder builder2 = ImmutableList.builder();
        builder2.b(divebarEditFavoritesFragment.m5587a(b));
        builder2.b(divebarEditFavoritesFragment.m5591b(b2));
        aH(divebarEditFavoritesFragment).d().a(divebarEditFavoritesFragment.aD());
        divebarEditFavoritesFragment.f5954g.mo219a(builder2.b());
        AdapterDetour.a(aH(divebarEditFavoritesFragment), -1061236177);
    }

    private void aG() {
        HoneyClientEventFast a = this.f5951d.a("update_favorites", false);
        if (a.a()) {
            a.a("favorite_count", this.au.m5574d());
            a.b();
        }
        DivebarEditFavoritesDataSource divebarEditFavoritesDataSource = this.au;
        Bundle bundle = new Bundle();
        bundle.putParcelable("favorites", new UpdateFavoriteContactsParams(divebarEditFavoritesDataSource.f5932h));
        divebarEditFavoritesDataSource.f5930f.a(BlueServiceOperationFactoryDetour.a(divebarEditFavoritesDataSource.f5929e, "update_favorite_contacts", bundle, -1459548212).a(), new C08752(divebarEditFavoritesDataSource));
        this.f5953f = new DialogBasedProgressIndicator(getContext(), 2131231212);
        this.f5953f.a();
    }

    public static FavoritesEditListAdapter aH(DivebarEditFavoritesFragment divebarEditFavoritesFragment) {
        if (divebarEditFavoritesFragment.f5950c == null) {
            FavoritesEditListAdapterProvider favoritesEditListAdapterProvider = divebarEditFavoritesFragment.as;
            divebarEditFavoritesFragment.f5950c = new FavoritesEditListAdapter(divebarEditFavoritesFragment.ar, (Context) favoritesEditListAdapterProvider.getInstance(Context.class), IdBasedProvider.a(favoritesEditListAdapterProvider, 7751), LayoutInflaterMethodAutoProvider.b(favoritesEditListAdapterProvider));
        }
        return divebarEditFavoritesFragment.f5950c;
    }

    public final void m5604a() {
        aF(this);
    }

    public final void m5608b() {
        HoneyClientEventFast a = this.f5951d.a("update_favorites_success", false);
        if (a.a()) {
            a.b();
        }
        this.f5953f.b();
        this.am = false;
        av();
    }

    public final void m5607a(Throwable th) {
        HoneyClientEventFast a = this.f5951d.a("update_favorites_failed", false);
        if (a.a()) {
            a.a("reason", th.getMessage());
            a.b();
        }
        this.f5953f.b();
        ErrorDialogs errorDialogs = this.f5952e;
        ErrorDialogParamsBuilder a2 = ErrorDialogParams.a(jW_()).a(2131230721);
        a2.c = b(2131231213);
        a2 = a2;
        a2.g = new C08869(this);
        errorDialogs.a(a2.l()).show();
    }

    @Nullable
    private static ContactPickerRow aI() {
        return null;
    }

    @Nullable
    private static ContactPickerRow aJ() {
        return ContactPickerRows.f1907d;
    }

    private FaveditPicker m5586a(FavoritesEditListAdapter favoritesEditListAdapter) {
        if (this.f5954g == null) {
            this.f5954g = new FavoritesEditPickerView(this.f5956i, favoritesEditListAdapter);
        }
        return this.f5954g;
    }

    private DivebarEditFavoritesDataSource aL() {
        if (this.au == null) {
            DivebarEditFavoritesDataSourceProvider divebarEditFavoritesDataSourceProvider = this.at;
            this.au = new DivebarEditFavoritesDataSource(this, FavoriteContactsCache.a(divebarEditFavoritesDataSourceProvider), ContactListsCache.a(divebarEditFavoritesDataSourceProvider), ContactsLoaderFactory.a(divebarEditFavoritesDataSourceProvider), DefaultBlueServiceOperationFactory.b(divebarEditFavoritesDataSourceProvider), DefaultAndroidThreadUtil.b(divebarEditFavoritesDataSourceProvider));
        }
        return this.au;
    }

    final void av() {
        FragmentManager fragmentManager = this.D;
        if (fragmentManager.f() <= 0) {
            Activity activity = (Activity) ContextUtils.a(getContext(), Activity.class);
            if (activity != null) {
                activity.finish();
            }
        } else if (fragmentManager.c()) {
            fragmentManager.d();
        } else if (!this.al) {
            this.al = true;
        }
    }

    protected final int aw() {
        return this.au.m5574d();
    }

    protected static int ax() {
        return -1;
    }
}
