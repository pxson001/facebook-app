package com.facebook.widget.friendselector;

import android.content.ContentResolver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.database.ContentObserver;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.inputmethod.InputMethodManager;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.TextView;
import com.facebook.base.fragment.FbFragment;
import com.facebook.common.android.ContentResolverMethodAutoProvider;
import com.facebook.common.android.InputMethodManagerMethodAutoProvider;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.common.executors.ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.common.userinteraction.DefaultUserInteractionController;
import com.facebook.common.util.StringUtil;
import com.facebook.common.util.Tuple;
import com.facebook.config.application.Boolean_IsWorkBuildMethodAutoProvider;
import com.facebook.contacts.background.AddressBookPeriodicRunner;
import com.facebook.contacts.graphql.ContactLinkType;
import com.facebook.contacts.iterator.ContactCursorsQuery;
import com.facebook.contacts.iterator.ContactCursorsQuery.SortKey;
import com.facebook.contacts.iterator.UserIterator;
import com.facebook.contacts.iterator.UserIterators;
import com.facebook.contacts.module.ContactLinkType_ContactLinkQueryTypeMethodAutoProvider;
import com.facebook.contacts.provider.ContactsConnectionsContract;
import com.facebook.debug.log.BLog;
import com.facebook.fbui.dialog.AlertDialog;
import com.facebook.inject.FbInjector;
import com.facebook.inject.InjectorLike;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.tools.dextr.runtime.detour.AdapterDetour;
import com.facebook.ui.futures.TasksManager;
import com.facebook.ui.toaster.ToastBuilder;
import com.facebook.ui.toaster.Toaster;
import com.facebook.user.model.User;
import com.facebook.user.model.UserKey;
import com.facebook.userfilter.UserTokenMatcher;
import com.facebook.widget.filter.CustomFilter.FilterListener;
import com.facebook.widget.filter.CustomFilter.FilteringState;
import com.facebook.widget.friendselector.FriendSelectorResultBar.Listener;
import com.facebook.widget.listview.BetterListView;
import com.facebook.widget.listview.ImmutableSectionedListSection;
import com.facebook.widget.listview.SectionedListSection;
import com.facebook.widget.tokenizedtypeahead.BaseTokenSpan;
import com.facebook.widget.tokenizedtypeahead.TokenPickerTokenUtil;
import com.facebook.widget.tokenizedtypeahead.TokenSpan;
import com.facebook.widget.tokenizedtypeahead.TokenizedAutoCompleteTextView;
import com.facebook.widget.tokenizedtypeahead.model.BaseToken;
import com.facebook.widget.tokenizedtypeahead.model.SimpleUserToken;
import com.facebook.widget.tokenizedtypeahead.ui.listview.DefaultViewFactory;
import com.facebook.widget.tokenizedtypeahead.ui.listview.TypeaheadAdapter;
import com.facebook.widget.tokenizedtypeahead.ui.listview.TypeaheadAdapter.ViewFactory;
import com.google.common.base.Splitter;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMap.Builder;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import com.google.common.collect.RegularImmutableSet;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: progress_dialog */
public abstract class GenericFriendsSelectorFragment extends FbFragment {
    public static String f5788a = "all_friends_alphabetic_section";
    public static final Class<?> av = GenericFriendsSelectorFragment.class;
    public static String f5789b = "all_coworkers_alphabetic_section";
    public Resources aA;
    private Boolean aB;
    private ContactLinkType aC;
    public FriendSelectorResultBar aD;
    public BetterListView aE;
    public ListView aF;
    public AlertDialog aG;
    public FriendSelectorReviewListAdapter aH;
    private View aI;
    private View aJ;
    public TextView aK;
    public ViewStub aL;
    public boolean aM;
    public final FilterListener aN = new C12621(this);
    public final OnScrollListener aO = new C12632(this);
    public TypeaheadAdapter al;
    protected AddressBookPeriodicRunner am;
    protected ContentResolver an;
    protected FriendSelectorViewFactory ao;
    public ImmutableSet<String> ap = RegularImmutableSet.a;
    public ImmutableSet<String> aq = RegularImmutableSet.a;
    public List<SimpleUserToken> ar = new ArrayList();
    public TokenizedAutoCompleteTextView as;
    public View at;
    private final ContactsContentObserver au = new ContactsContentObserver(this, new Handler());
    public CaspianFriendSelectorViewFactory aw;
    public CaspianTypeaheadAdapterWithStickyHeader ax;
    public Toaster ay;
    public String az;
    public ListeningExecutorService f5790c;
    protected TasksManager f5791d;
    protected UserIterators f5792e;
    protected DefaultUserInteractionController f5793f;
    public InputMethodManager f5794g;
    protected TokenPickerTokenUtil f5795h;
    public UserTokenMatcher f5796i;

    /* compiled from: progress_dialog */
    public interface FriendSelectorViewFactory {
        View mo1226a(ViewGroup viewGroup, LayoutInflater layoutInflater);

        TextView mo1227a(View view);

        View mo1228b(View view);

        BetterListView mo1229c(View view);

        TokenizedAutoCompleteTextView mo1230d(View view);

        View mo1231e(View view);

        @Nullable
        View mo1232f(View view);

        @Nullable
        ViewStub mo1233g(View view);
    }

    /* compiled from: progress_dialog */
    public class AnonymousClass16 implements OnClickListener {
        final /* synthetic */ View f16097a;
        final /* synthetic */ GenericFriendsSelectorFragment f16098b;

        public AnonymousClass16(GenericFriendsSelectorFragment genericFriendsSelectorFragment, View view) {
            this.f16098b = genericFriendsSelectorFragment;
            this.f16097a = view;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 1498092766);
            this.f16097a.setVisibility(8);
            Logger.a(2, EntryType.UI_INPUT_END, 1581333669, a);
        }
    }

    /* compiled from: progress_dialog */
    class C12621 implements FilterListener {
        final /* synthetic */ GenericFriendsSelectorFragment f16099a;

        C12621(GenericFriendsSelectorFragment genericFriendsSelectorFragment) {
            this.f16099a = genericFriendsSelectorFragment;
        }

        public final void m20119a(int i) {
            if (this.f16099a.al != null) {
                boolean z;
                GenericFriendsSelectorFragment genericFriendsSelectorFragment = this.f16099a;
                TypeaheadAdapter typeaheadAdapter = this.f16099a.al;
                int i2 = 0;
                int i3 = 0;
                while (i2 < typeaheadAdapter.c()) {
                    i3 += typeaheadAdapter.c(i2);
                    i2++;
                }
                if (i3 == 0) {
                    z = true;
                } else {
                    z = false;
                }
                genericFriendsSelectorFragment.m7139b(z);
            }
        }

        public final void m20120a(FilteringState filteringState) {
            if (filteringState == FilteringState.FINISHED) {
                this.f16099a.at.setVisibility(8);
            }
        }
    }

    /* compiled from: progress_dialog */
    class C12632 implements OnScrollListener {
        final /* synthetic */ GenericFriendsSelectorFragment f16100a;

        C12632(GenericFriendsSelectorFragment genericFriendsSelectorFragment) {
            this.f16100a = genericFriendsSelectorFragment;
        }

        public void onScrollStateChanged(AbsListView absListView, int i) {
            switch (i) {
                case 0:
                    this.f16100a.f5793f.b(absListView);
                    return;
                case 1:
                case 2:
                    this.f16100a.f5793f.a(absListView);
                    GenericFriendsSelectorFragment.m7123c(this.f16100a, absListView);
                    return;
                default:
                    return;
            }
        }

        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            Object obj = null;
            if (!this.f16100a.al.isEmpty() && i2 > 0 && i3 > 0 && (i + i2) + 3 > i3) {
                obj = 1;
            }
            if (obj != null) {
                this.f16100a.au();
            }
        }
    }

    /* compiled from: progress_dialog */
    public class C12643 implements TextWatcher {
        final /* synthetic */ GenericFriendsSelectorFragment f16101a;

        public C12643(GenericFriendsSelectorFragment genericFriendsSelectorFragment) {
            this.f16101a = genericFriendsSelectorFragment;
        }

        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public void afterTextChanged(Editable editable) {
            GenericFriendsSelectorFragment.m7115a(this.f16101a, editable);
        }
    }

    /* compiled from: progress_dialog */
    public class C12654 implements OnFocusChangeListener {
        final /* synthetic */ GenericFriendsSelectorFragment f16102a;

        public C12654(GenericFriendsSelectorFragment genericFriendsSelectorFragment) {
            this.f16102a = genericFriendsSelectorFragment;
        }

        public void onFocusChange(View view, boolean z) {
            if (!z) {
                GenericFriendsSelectorFragment.m7123c(this.f16102a, view);
                if (this.f16102a.as.getUserEnteredPlainText().length() == 0 && this.f16102a.ar.isEmpty()) {
                    this.f16102a.m7126h(true);
                }
            }
        }
    }

    /* compiled from: progress_dialog */
    class C12665 implements Callable<ImmutableMap<String, ImmutableList<User>>> {
        final /* synthetic */ GenericFriendsSelectorFragment f16103a;

        C12665(GenericFriendsSelectorFragment genericFriendsSelectorFragment) {
            this.f16103a = genericFriendsSelectorFragment;
        }

        public Object call() {
            Builder builder = ImmutableMap.builder();
            builder.b(this.f16103a.aE(), this.f16103a.az());
            return builder.b();
        }
    }

    /* compiled from: progress_dialog */
    class C12676 implements OnClickListener {
        final /* synthetic */ GenericFriendsSelectorFragment f16104a;

        C12676(GenericFriendsSelectorFragment genericFriendsSelectorFragment) {
            this.f16104a = genericFriendsSelectorFragment;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -789420663);
            if (this.f16104a.at.getVisibility() != 8) {
                Logger.a(2, EntryType.UI_INPUT_END, -2074636550, a);
                return;
            }
            this.f16104a.m7126h(false);
            this.f16104a.as.requestFocus();
            GenericFriendsSelectorFragment genericFriendsSelectorFragment = this.f16104a;
            genericFriendsSelectorFragment.f5794g.showSoftInput(this.f16104a.as, 0);
            LogUtils.a(-956427068, a);
        }
    }

    /* compiled from: progress_dialog */
    public class C12687 implements OnItemClickListener {
        final /* synthetic */ GenericFriendsSelectorFragment f16105a;

        public C12687(GenericFriendsSelectorFragment genericFriendsSelectorFragment) {
            this.f16105a = genericFriendsSelectorFragment;
        }

        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            this.f16105a.mo323g(i);
        }
    }

    /* compiled from: progress_dialog */
    public class C12698 implements Listener {
        final /* synthetic */ GenericFriendsSelectorFragment f16106a;

        public C12698(GenericFriendsSelectorFragment genericFriendsSelectorFragment) {
            this.f16106a = genericFriendsSelectorFragment;
        }

        public final void mo1236a() {
            this.f16106a.aH();
        }

        public final void mo1237a(BaseToken baseToken) {
            GenericFriendsSelectorFragment genericFriendsSelectorFragment = this.f16106a;
            if (genericFriendsSelectorFragment.aG == null) {
                genericFriendsSelectorFragment.aH = new FriendSelectorReviewListAdapter(ImmutableList.copyOf(genericFriendsSelectorFragment.ar));
                genericFriendsSelectorFragment.aF = (ListView) LayoutInflater.from(genericFriendsSelectorFragment.getContext()).inflate(2130904495, (ViewGroup) genericFriendsSelectorFragment.T, false);
                genericFriendsSelectorFragment.aF.setAdapter(genericFriendsSelectorFragment.aH);
                DialogInterface.OnClickListener anonymousClass11 = new DialogInterface.OnClickListener(genericFriendsSelectorFragment) {
                    final /* synthetic */ GenericFriendsSelectorFragment f16092a;

                    {
                        this.f16092a = r1;
                    }

                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                };
                genericFriendsSelectorFragment.aG = new AlertDialog.Builder(genericFriendsSelectorFragment.getContext()).a(genericFriendsSelectorFragment.getContext().getString(2131232665, new Object[]{Integer.valueOf(genericFriendsSelectorFragment.aH.getCount())})).b(genericFriendsSelectorFragment.aF).b(2131232663, anonymousClass11).a(2131232664, new DialogInterface.OnClickListener(genericFriendsSelectorFragment) {
                    final /* synthetic */ GenericFriendsSelectorFragment f16093a;

                    {
                        this.f16093a = r1;
                    }

                    public void onClick(DialogInterface dialogInterface, int i) {
                        GenericFriendsSelectorFragment genericFriendsSelectorFragment = this.f16093a;
                        ImmutableSet<SimpleUserToken> a = this.f16093a.aH.m20113a();
                        genericFriendsSelectorFragment.ar.removeAll(a);
                        for (SimpleUserToken a2 : a) {
                            genericFriendsSelectorFragment.aD.m20070a(a2, false);
                        }
                        AdapterDetour.a(genericFriendsSelectorFragment.al, 256885968);
                        genericFriendsSelectorFragment.aL();
                    }
                }).a(false).a();
                genericFriendsSelectorFragment.aF.setOnItemClickListener(new OnItemClickListener(genericFriendsSelectorFragment) {
                    final /* synthetic */ GenericFriendsSelectorFragment f16094a;

                    {
                        this.f16094a = r1;
                    }

                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                        this.f16094a.aH.m20114a(i);
                        this.f16094a.aG.setTitle(this.f16094a.getContext().getString(2131232665, new Object[]{Integer.valueOf(this.f16094a.aH.m20116b())}));
                    }
                });
            } else {
                genericFriendsSelectorFragment.aH.m20115a(ImmutableList.copyOf(genericFriendsSelectorFragment.ar));
                genericFriendsSelectorFragment.aG.setTitle(genericFriendsSelectorFragment.getContext().getString(2131232665, new Object[]{Integer.valueOf(genericFriendsSelectorFragment.aH.getCount())}));
            }
            genericFriendsSelectorFragment.aF.setSelection(genericFriendsSelectorFragment.aH.m20112a(baseToken));
            genericFriendsSelectorFragment.aG.show();
        }

        public final void mo1238a(boolean z) {
            this.f16106a.aE.setPadding(this.f16106a.aE.getPaddingLeft(), this.f16106a.aE.getPaddingTop(), this.f16106a.aE.getPaddingRight(), z ? this.f16106a.aD.getMeasuredHeight() : 0);
        }
    }

    /* compiled from: progress_dialog */
    public class C12709 implements DialogInterface.OnClickListener {
        final /* synthetic */ GenericFriendsSelectorFragment f16107a;

        public C12709(GenericFriendsSelectorFragment genericFriendsSelectorFragment) {
            this.f16107a = genericFriendsSelectorFragment;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            dialogInterface.dismiss();
        }
    }

    /* compiled from: progress_dialog */
    class ContactsContentObserver extends ContentObserver {
        final /* synthetic */ GenericFriendsSelectorFragment f16108a;

        public ContactsContentObserver(GenericFriendsSelectorFragment genericFriendsSelectorFragment, Handler handler) {
            this.f16108a = genericFriendsSelectorFragment;
            super(handler);
        }

        public void onChange(boolean z) {
            super.onChange(z);
            if (this.f16108a.z()) {
                this.f16108a.aX();
            }
        }
    }

    /* compiled from: progress_dialog */
    public enum Task {
        FETCH_INIT_IDS
    }

    public static void m7119a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        ((GenericFriendsSelectorFragment) obj).m7118a(ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider.a(injectorLike), TasksManager.a(injectorLike), UserIterators.a(injectorLike), DefaultUserInteractionController.a(injectorLike), InputMethodManagerMethodAutoProvider.a(injectorLike), TokenPickerTokenUtil.a(injectorLike), UserTokenMatcher.a(injectorLike), TypeaheadAdapterWithStickyHeader.m20144b(injectorLike), AddressBookPeriodicRunner.a(injectorLike), DefaultFriendSelectorViewFactory.m20042a(injectorLike), ContentResolverMethodAutoProvider.a(injectorLike), CaspianTypeaheadAdapterWithStickyHeader.m20030b(injectorLike), Toaster.a(injectorLike), ResourcesMethodAutoProvider.a(injectorLike), Boolean_IsWorkBuildMethodAutoProvider.a(injectorLike), ContactLinkType_ContactLinkQueryTypeMethodAutoProvider.a(injectorLike));
    }

    private static boolean m7120a(SimpleUserToken simpleUserToken, List<SimpleUserToken> list) {
        String b = simpleUserToken.g.b();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            if (b.equals(((UserKey) ((BaseToken) it.next()).d()).b())) {
                return true;
            }
        }
        return false;
    }

    @Inject
    private void m7118a(ListeningExecutorService listeningExecutorService, TasksManager tasksManager, UserIterators userIterators, DefaultUserInteractionController defaultUserInteractionController, InputMethodManager inputMethodManager, TokenPickerTokenUtil tokenPickerTokenUtil, UserTokenMatcher userTokenMatcher, TypeaheadAdapterWithStickyHeader typeaheadAdapterWithStickyHeader, AddressBookPeriodicRunner addressBookPeriodicRunner, FriendSelectorViewFactory friendSelectorViewFactory, ContentResolver contentResolver, CaspianTypeaheadAdapterWithStickyHeader caspianTypeaheadAdapterWithStickyHeader, Toaster toaster, Resources resources, Boolean bool, ContactLinkType contactLinkType) {
        this.f5790c = listeningExecutorService;
        this.f5791d = tasksManager;
        this.f5792e = userIterators;
        this.f5793f = defaultUserInteractionController;
        this.f5794g = inputMethodManager;
        this.f5795h = tokenPickerTokenUtil;
        this.f5796i = userTokenMatcher;
        this.al = typeaheadAdapterWithStickyHeader;
        this.am = addressBookPeriodicRunner;
        this.an = contentResolver;
        this.ao = friendSelectorViewFactory;
        this.ax = caspianTypeaheadAdapterWithStickyHeader;
        this.ay = toaster;
        this.aA = resources;
        this.aB = bool;
        this.aC = contactLinkType;
        boolean z = false;
        if (mt_() != null) {
            this.aM = mt_().getBoolean("is_show_caspian_style");
            z = mt_().getBoolean("is_sticky_header_off");
            this.ax.m20038b(z);
        }
        if (this.aM) {
            this.aw = new CaspianFriendSelectorViewFactory(true, !z);
            this.ao = this.aw;
            this.al = this.ax;
        }
    }

    public TypeaheadAdapter aq() {
        return this.al;
    }

    public ViewFactory ar() {
        return new DefaultViewFactory(true);
    }

    public void mo321c(Bundle bundle) {
        super.c(bundle);
        Class cls = GenericFriendsSelectorFragment.class;
        m7119a((Object) this, getContext());
        this.am.a();
        this.ar.clear();
        m7145n(this.s);
        if (bundle != null) {
            Iterable stringArrayList = bundle.getStringArrayList("savedSelectedIds");
            if (stringArrayList != null) {
                ImmutableSet.Builder builder = ImmutableSet.builder();
                builder.b(this.ap);
                builder.b(stringArrayList);
                this.ap = builder.b();
            }
        }
        this.an.registerContentObserver(ContactsConnectionsContract.g, true, this.au);
    }

    protected void m7145n(Bundle bundle) {
        if (bundle != null) {
            String string = bundle.getString("friendsSelectorSelected");
            String string2 = bundle.getString("friendsSelectorExcluded");
            this.ap = m7124d(string);
            this.aq = m7124d(string2);
        }
    }

    public boolean at() {
        return false;
    }

    protected void au() {
    }

    public final void m7143e(Bundle bundle) {
        if (ax().size() > 0) {
            ArrayList a = Lists.a();
            a.addAll(ax());
            bundle.putStringArrayList("savedSelectedIds", a);
        }
        super.e(bundle);
    }

    public final View m7129a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 270729813);
        View a2 = this.ao.mo1226a(viewGroup, layoutInflater);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 1369733948, a);
        return a2;
    }

    public void mo322d(Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -654640842);
        super.d(bundle);
        View view = this.T;
        this.as = this.ao.mo1230d(view);
        this.aD = (FriendSelectorResultBar) view.findViewById(2131561549);
        this.as.setInputType((this.as.getInputType() | 65536) | 96);
        this.aE = this.ao.mo1229c(view);
        this.aJ = this.ao.mo1231e(view);
        this.aI = this.ao.mo1232f(view);
        this.at = this.ao.mo1228b(view);
        this.aK = this.ao.mo1227a(view);
        this.aL = this.ao.mo1233g(view);
        this.as.addTextChangedListener(new C12643(this));
        this.as.setOnFocusChangeListener(new C12654(this));
        av();
        aR();
        ViewFactory ar = this.aM ? this.aw : ar();
        this.al = this.aM ? this.ax : aq();
        this.al.a(this.f5796i, ar);
        this.al.i = this.ar;
        this.al.a(ImmutableList.of(new ImmutableSectionedListSection()));
        this.aE.setAdapter(this.al);
        this.aE.setOnScrollListener(this.aO);
        this.aE.setOnItemClickListener(new C12687(this));
        this.aE.setStickyHeaderEnabled(this.aM ? true : at());
        if (this.aM) {
            this.aD.f16053f = new C12698(this);
        }
        aX();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -1199886504, a);
    }

    protected void av() {
    }

    public void mo314H() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1953652974);
        super.H();
        m7123c(this, this.as);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 1248457356, a);
    }

    public void mY_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -2064044918);
        this.aE = null;
        this.aF = null;
        this.aG = null;
        super.mY_();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -410160125, a);
    }

    public final boolean aw() {
        return this.aE == null;
    }

    public void m7128I() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 461708533);
        this.f5791d.c();
        this.an.unregisterContentObserver(this.au);
        super.I();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -645505243, a);
    }

    public final ImmutableList<String> ax() {
        ImmutableList.Builder builder = ImmutableList.builder();
        for (SimpleUserToken simpleUserToken : this.ar) {
            builder.c(simpleUserToken.g.b());
        }
        return builder.b();
    }

    protected ListenableFuture<ImmutableMap<String, ImmutableList<User>>> ay() {
        return this.f5790c.a(new C12665(this));
    }

    public final ImmutableList<User> az() {
        UserIterator a = this.f5792e.a(ContactCursorsQuery.a().d(ImmutableList.of(this.aC)).f(aB()).a(aA()));
        ImmutableList.Builder builder = ImmutableList.builder();
        while (a.hasNext()) {
            try {
                builder.c(a.next());
            } finally {
                a.close();
            }
        }
        ImmutableList<User> b = builder.b();
        return b;
    }

    protected SortKey aA() {
        return SortKey.NAME;
    }

    protected boolean aB() {
        return false;
    }

    protected boolean mo1446a(String str) {
        return true;
    }

    public int aC() {
        return 50;
    }

    protected int mo320b(String str) {
        if (f5788a.equals(str)) {
            return 2131232655;
        }
        if (f5789b.equals(str)) {
            return 2131232656;
        }
        return 0;
    }

    protected boolean m7141c(String str) {
        return false;
    }

    protected ImmutableList<String> aD() {
        return ImmutableList.of(aE());
    }

    protected final String aE() {
        return this.aB.booleanValue() ? f5789b : f5788a;
    }

    public static void m7115a(GenericFriendsSelectorFragment genericFriendsSelectorFragment, Editable editable) {
        genericFriendsSelectorFragment.m7121b(editable);
        genericFriendsSelectorFragment.aG();
    }

    private void m7121b(Editable editable) {
        boolean z = true;
        String obj = editable.toString();
        Object obj2 = 1;
        if (this.az == null || obj.contains(this.az)) {
            obj2 = null;
        }
        this.az = obj;
        if (obj2 == null || this.aM || !this.as.hasFocus()) {
            int i = 0;
        } else {
            boolean z2 = false;
            for (SimpleUserToken simpleUserToken : Lists.a(this.ar)) {
                boolean z3;
                if (editable.subSequence(0, editable.length()).toString().contains(simpleUserToken.b())) {
                    z3 = z2;
                } else {
                    m7122b(simpleUserToken, this.as, this.ar);
                    z3 = true;
                }
                z2 = z3;
            }
        }
        if (i != 0) {
            aF();
        }
        if (this.aM) {
            CaspianTypeaheadAdapterWithStickyHeader caspianTypeaheadAdapterWithStickyHeader = this.ax;
            if (editable.length() == 0) {
                z = false;
            }
            caspianTypeaheadAdapterWithStickyHeader.f16037g = z;
        }
    }

    protected void aF() {
    }

    protected void aG() {
        this.at.setVisibility(0);
        this.al.a().a(this.as.getUserEnteredPlainText(), this.aN);
    }

    protected static ImmutableSet<String> m7124d(String str) {
        if (str == null) {
            return RegularImmutableSet.a;
        }
        if ("-1".equals(str)) {
            return RegularImmutableSet.a;
        }
        return ImmutableSet.copyOf(Splitter.on(',').trimResults().omitEmptyStrings().split(str));
    }

    private void aR() {
        this.at.setVisibility(0);
        if (this.aM) {
            m7126h(true);
        } else {
            m7126h(m7114a(this.as).isEmpty());
        }
        this.aJ.setOnClickListener(new C12676(this));
    }

    protected void aH() {
    }

    public final void aI() {
        if (o() != null) {
            if (this.aM) {
                o().setResult(-1);
                o().finish();
                return;
            }
            o().onBackPressed();
        }
    }

    public final void aJ() {
        if (this.ar.isEmpty()) {
            o().setResult(0);
            o().finish();
            return;
        }
        new AlertDialog.Builder(getContext()).a(2131232660).b(2131232661).b(2131232662, new DialogInterface.OnClickListener(this) {
            final /* synthetic */ GenericFriendsSelectorFragment f16091a;

            {
                this.f16091a = r1;
            }

            public void onClick(DialogInterface dialogInterface, int i) {
                this.f16091a.o().setResult(0);
                this.f16091a.o().finish();
            }
        }).a(2131232663, new C12709(this)).a(false).a().show();
    }

    protected final boolean m7136a(BaseToken baseToken) {
        return this.ar.contains(baseToken);
    }

    protected void mo323g(int i) {
        m7132a((SimpleUserToken) this.al.getItem(i), this.as);
    }

    private List<SimpleUserToken> m7114a(TokenizedAutoCompleteTextView tokenizedAutoCompleteTextView) {
        List<SimpleUserToken> a = Lists.a();
        if (this.aM) {
            return this.ar;
        }
        for (TokenSpan tokenSpan : (BaseTokenSpan[]) tokenizedAutoCompleteTextView.getPickedTokenSpans()) {
            a.add((SimpleUserToken) tokenSpan.f);
        }
        return a;
    }

    protected final void m7135a(Set<SimpleUserToken> set) {
        for (SimpleUserToken simpleUserToken : set) {
            if (!m7120a(simpleUserToken, this.ar)) {
                m7132a(simpleUserToken, this.as);
            }
        }
        AdapterDetour.a(this.al, -1332945811);
        if (!this.aM) {
            this.as.d();
        }
    }

    public void aL() {
        if (this.al != null) {
            AdapterDetour.a(this.al, 1829714657);
        }
    }

    public final void m7132a(SimpleUserToken simpleUserToken, TokenizedAutoCompleteTextView tokenizedAutoCompleteTextView) {
        if (simpleUserToken.a()) {
            if (m7114a(tokenizedAutoCompleteTextView).contains(simpleUserToken) || this.ar.contains(simpleUserToken)) {
                m7122b(simpleUserToken, tokenizedAutoCompleteTextView, this.ar);
            } else {
                m7117a(simpleUserToken, tokenizedAutoCompleteTextView, this.ar);
            }
            AdapterDetour.a(this.al, -643703955);
            if (!this.aM) {
                this.as.d();
            }
        }
    }

    private void m7117a(SimpleUserToken simpleUserToken, TokenizedAutoCompleteTextView tokenizedAutoCompleteTextView, List<SimpleUserToken> list) {
        if (list.size() >= aC()) {
            this.ay.b(new ToastBuilder(2131232667));
            return;
        }
        if (!m7120a(simpleUserToken, this.ar)) {
            if (this.aM) {
                this.aD.m20069a(simpleUserToken);
            } else {
                tokenizedAutoCompleteTextView.a(simpleUserToken);
            }
        }
        tokenizedAutoCompleteTextView.clearComposingText();
        list.add(simpleUserToken);
        aL();
        if (!this.aM && list.size() == 1) {
            m7126h(false);
        }
    }

    private void m7122b(SimpleUserToken simpleUserToken, TokenizedAutoCompleteTextView tokenizedAutoCompleteTextView, List<SimpleUserToken> list) {
        if (m7120a(simpleUserToken, this.ar)) {
            if (this.aM) {
                this.aD.m20070a(simpleUserToken, true);
            } else {
                tokenizedAutoCompleteTextView.a(m7113a(simpleUserToken), false);
            }
        }
        if (list.contains(simpleUserToken)) {
            list.remove(simpleUserToken);
            aL();
        }
        if (!this.aM && list.isEmpty()) {
            m7126h(true);
        }
    }

    @Nullable
    private SimpleUserToken m7113a(SimpleUserToken simpleUserToken) {
        List<SimpleUserToken> a = m7114a(this.as);
        UserKey userKey = simpleUserToken.g;
        for (SimpleUserToken simpleUserToken2 : a) {
            if (simpleUserToken2.g.b().equals(userKey.b())) {
                return simpleUserToken2;
            }
        }
        return null;
    }

    private void m7126h(boolean z) {
        if (this.aI != null) {
            if (!z) {
                this.as.setEnabled(true);
            }
            if (z) {
                this.aI.setVisibility(0);
                this.as.setVisibility(8);
                return;
            }
            this.aI.setVisibility(8);
            this.as.setVisibility(0);
        }
    }

    private void aX() {
        if (!aN()) {
            this.aK.setText("");
            aM();
        }
    }

    protected void aM() {
        this.f5791d.a(Task.FETCH_INIT_IDS, new Callable<ListenableFuture<ImmutableMap<String, ImmutableList<User>>>>(this) {
            final /* synthetic */ GenericFriendsSelectorFragment f16095a;

            {
                this.f16095a = r1;
            }

            public Object call() {
                return this.f16095a.ay();
            }
        }, new AbstractDisposableFutureCallback<ImmutableMap<String, ImmutableList<User>>>(this) {
            final /* synthetic */ GenericFriendsSelectorFragment f16096a;

            {
                this.f16096a = r1;
            }

            protected final void m20117a(Object obj) {
                this.f16096a.m7133a((ImmutableMap) obj);
            }

            protected final void m20118a(Throwable th) {
                GenericFriendsSelectorFragment genericFriendsSelectorFragment = this.f16096a;
                BLog.a(GenericFriendsSelectorFragment.av, "Default loader could not load Users for contact db", th);
                genericFriendsSelectorFragment.aK.setText(2131230758);
                genericFriendsSelectorFragment.m7134a(new HashMap());
                genericFriendsSelectorFragment.at.setVisibility(8);
            }
        });
    }

    protected boolean aN() {
        return false;
    }

    public final void m7133a(ImmutableMap<String, ImmutableList<User>> immutableMap) {
        this.aK.setText(2131232654);
        m7134a((Map) immutableMap);
        this.at.setVisibility(8);
        aO();
    }

    protected void aO() {
        if (!StringUtil.a(this.as.getUserEnteredPlainText().toString())) {
            aG();
        }
    }

    public final void m7139b(boolean z) {
        if (this.aE != null) {
            if (z) {
                this.aK.setText(2131232654);
                this.aE.setVisibility(8);
                this.aK.setVisibility(0);
                return;
            }
            this.aE.setVisibility(0);
            this.aK.setVisibility(8);
        }
    }

    public final void m7134a(Map<String, ImmutableList<User>> map) {
        ImmutableList.Builder builder = ImmutableList.builder();
        ImmutableSet.Builder builder2 = ImmutableSet.builder();
        ImmutableList aD = aD();
        int size = aD.size();
        for (int i = 0; i < size; i++) {
            Tuple a = m7130a((String) aD.get(i), (Map) map);
            if (a != null) {
                if (a.a != null) {
                    builder2.b((Iterable) a.a);
                }
                builder.c(a.b);
            }
        }
        ImmutableList b = builder.b();
        Set b2 = builder2.b();
        m7139b(b.isEmpty());
        this.al.a(b);
        AdapterDetour.a(this.al, 1759453928);
        if (!this.aM) {
            this.as.d();
        }
        if (aP()) {
            m7123c(this, this.as);
        }
        m7135a(b2);
    }

    protected boolean aP() {
        return true;
    }

    protected Tuple<ImmutableSet<SimpleUserToken>, SectionedListSection<? extends BaseToken>> m7130a(String str, Map<String, ImmutableList<User>> map) {
        ImmutableList.Builder builder = ImmutableList.builder();
        ImmutableList immutableList = (ImmutableList) map.get(str);
        ImmutableSet.Builder builder2 = ImmutableSet.builder();
        if (immutableList == null || immutableList.isEmpty()) {
            return null;
        }
        int i;
        String string;
        int size = immutableList.size();
        for (i = 0; i < size; i++) {
            User user = (User) immutableList.get(i);
            User a = TokenPickerTokenUtil.a(user);
            SimpleUserToken a2 = m7131a(user, str);
            if (!this.aq.contains(a.a)) {
                builder.c(a2);
                if (this.ap.contains(a.a)) {
                    builder2.c(a2);
                }
            }
        }
        if (!(this.ap == null || this.ap.isEmpty())) {
            this.ap = RegularImmutableSet.a;
        }
        immutableList = builder.b();
        i = mo320b(str);
        if (i > 0) {
            string = this.aA.getString(i);
        } else {
            string = null;
        }
        return new Tuple(builder2.b(), new ImmutableSectionedListSection(string, immutableList, m7141c(str)));
    }

    protected SimpleUserToken m7131a(User user, String str) {
        boolean z;
        SimpleUserToken simpleUserToken = new SimpleUserToken(TokenPickerTokenUtil.a(user));
        if (simpleUserToken.g == null || mo1446a(simpleUserToken.g.b())) {
            z = true;
        } else {
            z = false;
        }
        simpleUserToken.i = z;
        return simpleUserToken;
    }

    public static void m7123c(GenericFriendsSelectorFragment genericFriendsSelectorFragment, View view) {
        genericFriendsSelectorFragment.f5794g.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }
}
