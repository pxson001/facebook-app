package com.facebook.groups.memberlist;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.inputmethod.InputMethodManager;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.EditText;
import android.widget.ImageButton;
import com.facebook.auth.annotations.LoggedInUserId;
import com.facebook.auth.module.String_LoggedInUserIdMethodAutoProvider;
import com.facebook.base.fragment.FbFragment;
import com.facebook.common.android.InputMethodManagerMethodAutoProvider;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.common.executors.DefaultAndroidThreadUtil;
import com.facebook.common.util.StringUtil;
import com.facebook.graphql.enums.GraphQLGroupAdminType;
import com.facebook.graphql.enums.GraphQLGroupVisibility;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.groups.memberlist.memberrow.GroupMemberRow.GroupsMemberRowListener;
import com.facebook.groups.memberlist.view.DefaultGroupMembershipViewFactory;
import com.facebook.groups.members.GroupMemberBaseListLoader;
import com.facebook.groups.members.GroupMemberBaseListLoader.MemberListLoaderListener;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.tools.dextr.runtime.detour.AdapterDetour;
import com.facebook.widget.listview.BetterListView;
import com.facebook.widget.listview.FbBaseAdapter;
import com.facebook.widget.text.BetterTextView;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.RegularImmutableList;
import javax.inject.Inject;

/* compiled from: extra_xed_location */
public abstract class GroupMemberListBaseFragment extends FbFragment {
    public String f14190a;
    @Inject
    GraphQLQueryExecutor al;
    @Inject
    InputMethodManager am;
    @Inject
    DefaultAndroidThreadUtil an;
    @Inject
    @LoggedInUserId
    String ao;
    @Inject
    public DefaultGroupMembershipViewFactory ap;
    protected GroupMemberListAdapter aq;
    protected boolean ar;
    public ImageButton as;
    public View at;
    public String au = "";
    public GraphQLGroupVisibility av;
    public final MemberListLoaderListener aw = new C15301(this);
    public GraphQLGroupAdminType f14191b;
    public ImmutableList<GroupMemberListMemberItem> f14192c = RegularImmutableList.a;
    public BetterListView f14193d;
    public C15312 f14194e;
    public GroupMemberBaseListLoader f14195f;
    public EditText f14196g;
    @Inject
    public Resources f14197h;
    @Inject
    GroupMemberListAdapterProvider f14198i;

    /* compiled from: extra_xed_location */
    class C15301 implements MemberListLoaderListener<GroupMemberListMemberItem> {
        final /* synthetic */ GroupMemberListBaseFragment f14237a;

        C15301(GroupMemberListBaseFragment groupMemberListBaseFragment) {
            this.f14237a = groupMemberListBaseFragment;
        }

        public final void m15837a(ImmutableList<GroupMemberListMemberItem> immutableList, GraphQLGroupVisibility graphQLGroupVisibility) {
            this.f14237a.mo847a((ImmutableList) immutableList);
            this.f14237a.mo848a(this.f14237a.aA());
            this.f14237a.av = graphQLGroupVisibility;
        }

        public final void m15838a(boolean z) {
            this.f14237a.m15762b(z);
        }
    }

    /* compiled from: extra_xed_location */
    public class C15312 {
        final /* synthetic */ GroupMemberListBaseFragment f14238a;

        C15312(GroupMemberListBaseFragment groupMemberListBaseFragment) {
            this.f14238a = groupMemberListBaseFragment;
        }
    }

    /* compiled from: extra_xed_location */
    public class C15323 implements OnScrollListener {
        final /* synthetic */ GroupMemberListBaseFragment f14239a;

        public C15323(GroupMemberListBaseFragment groupMemberListBaseFragment) {
            this.f14239a = groupMemberListBaseFragment;
        }

        public void onScrollStateChanged(AbsListView absListView, int i) {
            switch (i) {
                case 1:
                case 2:
                    GroupMemberListBaseFragment.m15753b(this.f14239a, this.f14239a.f14196g);
                    return;
                default:
                    return;
            }
        }

        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            Object obj = null;
            if (!this.f14239a.mo856e().isEmpty() && i2 > 0 && i3 > 0 && (i + i2) + 3 > i3) {
                obj = 1;
            }
            if (obj != null && this.f14239a.mo854b()) {
                this.f14239a.aw();
            }
        }
    }

    /* compiled from: extra_xed_location */
    public class C15334 implements OnItemClickListener {
        final /* synthetic */ GroupMemberListBaseFragment f14240a;

        public C15334(GroupMemberListBaseFragment groupMemberListBaseFragment) {
            this.f14240a = groupMemberListBaseFragment;
        }

        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            this.f14240a.mo846a(view, this.f14240a.mo857g(i));
        }
    }

    /* compiled from: extra_xed_location */
    public class C15345 implements OnClickListener {
        final /* synthetic */ GroupMemberListBaseFragment f14241a;

        public C15345(GroupMemberListBaseFragment groupMemberListBaseFragment) {
            this.f14241a = groupMemberListBaseFragment;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -1915019696);
            this.f14241a.f14196g.setText("");
            Logger.a(2, EntryType.UI_INPUT_END, -1600692472, a);
        }
    }

    /* compiled from: extra_xed_location */
    public class C15356 implements TextWatcher {
        final /* synthetic */ GroupMemberListBaseFragment f14242a;

        public C15356(GroupMemberListBaseFragment groupMemberListBaseFragment) {
            this.f14242a = groupMemberListBaseFragment;
        }

        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public void afterTextChanged(Editable editable) {
            if (editable.length() == 0) {
                this.f14242a.as.setVisibility(4);
            } else {
                this.f14242a.as.setVisibility(0);
            }
            this.f14242a.au = editable.toString();
            this.f14242a.mo845a(editable);
            this.f14242a.mo848a(false);
        }
    }

    /* compiled from: extra_xed_location */
    class C15367 implements GroupsMemberRowListener {
        final /* synthetic */ GroupMemberListBaseFragment f14243a;

        C15367(GroupMemberListBaseFragment groupMemberListBaseFragment) {
            this.f14243a = groupMemberListBaseFragment;
        }

        public final void mo842a(View view, GroupMemberListMemberItem groupMemberListMemberItem) {
            this.f14243a.mo846a(view, groupMemberListMemberItem);
        }
    }

    public static void m15752a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((GroupMemberListBaseFragment) obj).m15751a(ResourcesMethodAutoProvider.a(fbInjector), (GroupMemberListAdapterProvider) fbInjector.getOnDemandAssistedProviderForStaticDi(GroupMemberListAdapterProvider.class), GraphQLQueryExecutor.a(fbInjector), InputMethodManagerMethodAutoProvider.b(fbInjector), DefaultAndroidThreadUtil.b(fbInjector), String_LoggedInUserIdMethodAutoProvider.b(fbInjector), DefaultGroupMembershipViewFactory.m16393b(fbInjector));
    }

    public abstract GroupMemberBaseListLoader mo844a(String str);

    protected abstract void mo846a(View view, GroupMemberListMemberItem groupMemberListMemberItem);

    protected abstract boolean ar();

    public abstract boolean at();

    public abstract void au();

    private void m15751a(Resources resources, GroupMemberListAdapterProvider groupMemberListAdapterProvider, GraphQLQueryExecutor graphQLQueryExecutor, InputMethodManager inputMethodManager, DefaultAndroidThreadUtil defaultAndroidThreadUtil, String str, DefaultGroupMembershipViewFactory defaultGroupMembershipViewFactory) {
        this.f14197h = resources;
        this.f14198i = groupMemberListAdapterProvider;
        this.al = graphQLQueryExecutor;
        this.am = inputMethodManager;
        this.an = defaultAndroidThreadUtil;
        this.ao = str;
        this.ap = defaultGroupMembershipViewFactory;
    }

    public void mo855c(Bundle bundle) {
        super.c(bundle);
        Class cls = GroupMemberListBaseFragment.class;
        m15752a((Object) this, getContext());
        this.f14190a = this.s.getString("group_feed_id");
        this.f14191b = GraphQLGroupAdminType.fromString(this.s.getString("group_admin_type"));
    }

    public final View m15754a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -420213091);
        this.f14194e = new C15312(this);
        this.f14195f = mo844a("");
        View inflate = layoutInflater.inflate(2130905201, viewGroup, false);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 523579683, a);
        return inflate;
    }

    public void mo871a(View view, Bundle bundle) {
        super.a(view, bundle);
        m15762b(true);
        ViewStub viewStub = (ViewStub) e(2131562622);
        DefaultGroupMembershipViewFactory defaultGroupMembershipViewFactory = this.ap;
        viewStub.setLayoutResource(2130904733);
        BetterTextView betterTextView = (BetterTextView) viewStub.inflate();
        betterTextView.setText(this.f14197h.getText(2131239507));
        betterTextView.setVisibility(8);
        this.at = as();
        mo848a(false);
        this.f14193d = (BetterListView) e(2131563783);
        this.f14193d.setAdapter(mo856e());
        aq().mo867a().f14267e = at();
        AdapterDetour.a(mo856e(), 577032841);
        this.f14193d.setOnScrollListener(new C15323(this));
        au();
        this.f14193d.setOnItemClickListener(new C15334(this));
        this.as = (ImageButton) e(2131562702);
        this.as.setImageDrawable(this.ap.m16394c());
        this.f14196g = (EditText) e(2131562701);
        this.f14196g.setHint(this.f14197h.getString(2131239491));
        ColorFilter porterDuffColorFilter = new PorterDuffColorFilter(this.f14197h.getColor(2131363510), Mode.SRC_ATOP);
        Drawable mutate = this.ap.m16394c().mutate();
        mutate.setColorFilter(porterDuffColorFilter);
        this.as.setImageDrawable(mutate);
        this.as.setOnClickListener(new C15345(this));
        this.f14196g.addTextChangedListener(new C15356(this));
        aw();
    }

    public void mo858g(boolean z) {
        this.ar = z;
        if (!z) {
            m15753b(this, this.f14196g);
        }
    }

    public void mY_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1862498798);
        ax();
        aq().mo867a().m15876a();
        m15753b(this, this.f14196g);
        super.mY_();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 1790081404, a);
    }

    protected final void aw() {
        this.f14195f.f();
    }

    public final void ax() {
        this.f14195f.e();
    }

    public View as() {
        return e(2131559433);
    }

    public final boolean aA() {
        GroupMemberBaseListLoader groupMemberBaseListLoader = this.f14195f;
        Object obj = (groupMemberBaseListLoader.i().isEmpty() && groupMemberBaseListLoader.b) ? 1 : null;
        return obj != null || aq().mo870c();
    }

    protected boolean mo854b() {
        return true;
    }

    protected void mo845a(Editable editable) {
        GroupMemberBaseListLoader a;
        aG();
        Object obj = this.au;
        ax();
        if (StringUtil.c(obj)) {
            a = mo844a("");
        } else {
            a = mo844a(obj.trim());
        }
        this.f14195f = a;
    }

    private void aL() {
        this.aq = new GroupMemberListAdapter(new C15367(this), new GroupMemberListInfoManager(), String_LoggedInUserIdMethodAutoProvider.b(this.f14198i));
    }

    public FbBaseAdapter mo856e() {
        if (this.aq == null) {
            aL();
        }
        return this.aq;
    }

    public GroupMemberListAdapterHelper aq() {
        if (this.aq == null) {
            aL();
        }
        return this.aq;
    }

    protected GroupMemberListMemberItem mo857g(int i) {
        return this.aq.m15830a(i);
    }

    protected void mo847a(ImmutableList<GroupMemberListMemberItem> immutableList) {
        this.f14192c = immutableList;
    }

    public void mo848a(boolean z) {
        this.at.setVisibility(z ? 0 : 8);
    }

    protected final boolean az() {
        return !StringUtil.c(this.au);
    }

    public static void m15753b(GroupMemberListBaseFragment groupMemberListBaseFragment, View view) {
        if (view != null) {
            groupMemberListBaseFragment.am.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }

    protected final void m15762b(boolean z) {
        GroupMemberListInfoManager a = aq().mo867a();
        if (z != a.f14266d) {
            a.f14266d = z;
        }
        AdapterDetour.a(mo856e(), 246184757);
    }

    public final void m15761b(String str) {
        aq().mo868a(str, this.f14193d);
    }

    public final void aG() {
        aq().mo869b();
    }

    protected final void m15768h(boolean z) {
        aq().mo867a().f14268f = z;
        AdapterDetour.a(mo856e(), 1329164061);
    }

    protected final int aH() {
        return this.f14197h.getDimensionPixelSize(2131432961);
    }
}
