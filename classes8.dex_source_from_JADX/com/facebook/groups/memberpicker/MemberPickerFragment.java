package com.facebook.groups.memberpicker;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.app.DialogFragment;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.analytics.tagging.AnalyticsFragment;
import com.facebook.auth.annotations.LoggedInUserId;
import com.facebook.base.fragment.CanHandleBackPressed;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.common.executors.ForUiThread;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.common.util.StringUtil;
import com.facebook.common.util.Tuple;
import com.facebook.debug.log.BLog;
import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.gk.store.GatekeeperStore;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.graphql.calls.GroupAddMemberInputData.Source;
import com.facebook.graphql.enums.GraphQLGroupVisibility;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.groups.editing.GroupEditFragmentInterface;
import com.facebook.groups.editing.GroupEditFragmentInterface.GroupEditListener;
import com.facebook.groups.editing.GroupEditFragmentInterface.Stage;
import com.facebook.groups.editing.GroupEditFragmentInterface.Type;
import com.facebook.groups.fb4a.memberpicker.FB4AMemberPickerRowViewFactory;
import com.facebook.groups.memberpicker.DefaultMemberPickerNavigationHandler.C15801;
import com.facebook.groups.memberpicker.SuggestedMembersBatchedListLoader.MemberBatchedListLoaderListener;
import com.facebook.groups.memberpicker.abtest.ExperimentsForMemberPickerModule;
import com.facebook.groups.memberpicker.protocol.GroupAddMembersMutationModels.GroupAddMembersMutationModel;
import com.facebook.groups.memberpicker.protocol.GroupAddMembersMutationModels.GroupAddMembersMutationModel.AddedUsersModel;
import com.facebook.groups.memberpicker.protocol.GroupAddMembersMutationModels.GroupAddMembersMutationModel.AlreadyAddedUsersModel;
import com.facebook.groups.memberpicker.protocol.GroupAddMembersMutationModels.GroupAddMembersMutationModel.AlreadyInvitedUsersModel;
import com.facebook.groups.memberpicker.protocol.GroupAddMembersMutationModels.GroupAddMembersMutationModel.InvitedUsersModel;
import com.facebook.groups.memberpicker.protocol.GroupAddMembersMutationModels.GroupAddMembersMutationModel.RequestedUsersModel;
import com.facebook.groups.memberpicker.protocol.MultipleMemberAdder;
import com.facebook.groups.members.GroupMemberBaseListLoader.MemberListLoaderListener;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.tools.dextr.runtime.detour.AdapterDetour;
import com.facebook.ui.dialogs.ProgressDialogFragment;
import com.facebook.ui.futures.TasksManager;
import com.facebook.ui.toaster.ToastBuilder;
import com.facebook.ui.toaster.Toaster;
import com.facebook.user.model.User;
import com.facebook.widget.friendselector.GenericFriendsSelectorFragment;
import com.facebook.widget.listview.ImmutableSectionedListSection;
import com.facebook.widget.listview.SectionedListSection;
import com.facebook.widget.titlebar.HasTitleBar;
import com.facebook.widget.titlebar.TitleBarButtonSpec;
import com.facebook.widget.titlebar.TitleBarButtonSpec.Builder;
import com.facebook.widget.tokenizedtypeahead.TokenizedAutoCompleteTextView;
import com.facebook.widget.tokenizedtypeahead.TokenizedAutoCompleteTextView.TextMode;
import com.facebook.widget.tokenizedtypeahead.model.BaseToken;
import com.facebook.widget.tokenizedtypeahead.model.SimpleUserToken;
import com.facebook.widget.tokenizedtypeahead.ui.listview.TypeaheadAdapter.ViewFactory;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableBiMap;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListeningExecutorService;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: expiry_month */
public class MemberPickerFragment extends GenericFriendsSelectorFragment implements AnalyticsFragment, CanHandleBackPressed, GroupEditFragmentInterface<State> {
    public static String au = "invite_option_section";
    @Inject
    public UserFriendsListLoaderProvider aA;
    @Inject
    DisabledAwareTypeaheadAdapterViewFactory aB;
    @Inject
    DefaultMemberPickerNavigationHandler aC;
    @Inject
    @LoggedInUserId
    public Provider<String> aD;
    @Inject
    SuggestedMembersBatchedListLoaderProvider aE;
    @Inject
    public Lazy<GroupAddMemberSearchListLoader> aF;
    @Inject
    public Lazy<GroupAddInviteMemberSearchListLoader> aG;
    @Inject
    public Lazy<GroupAddMemberFriendSearchListLoader> aH;
    @Inject
    public GatekeeperStoreImpl aI;
    @Inject
    public QeAccessor aJ;
    @Inject
    MemberPickerMutationResultHelper aK;
    public SuggestedMembersBatchedListLoader aL;
    public GroupAddInviteMembersListLoaderDelegate aM;
    public UserFriendsListLoader aN;
    private GroupEditListener<State> aO;
    public String aP;
    private String aQ;
    private String aR;
    public boolean aS;
    public DialogFragment aT;
    private Type aU;
    private SectionedListSection<? extends BaseToken> aV;
    private String aW;
    private List<SimpleUserToken> aX;
    @Inject
    @ForUiThread
    public ListeningExecutorService av;
    @Inject
    Toaster aw;
    @Inject
    GraphQLQueryExecutor ax;
    @Inject
    public Resources ay;
    @Inject
    public MultipleMemberAdder az;

    /* compiled from: expiry_month */
    public class C15891 implements OnClickListener {
        final /* synthetic */ MemberPickerFragment f14590a;

        public C15891(MemberPickerFragment memberPickerFragment) {
            this.f14590a = memberPickerFragment;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 2052421413);
            MemberPickerFragment.aS(this.f14590a);
            Logger.a(2, EntryType.UI_INPUT_END, -588370574, a);
        }
    }

    /* compiled from: expiry_month */
    public class C15902 implements OnClickListener {
        final /* synthetic */ MemberPickerFragment f14591a;

        public C15902(MemberPickerFragment memberPickerFragment) {
            this.f14591a = memberPickerFragment;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -1448945215);
            MemberPickerFragment.aQ(this.f14591a);
            Logger.a(2, EntryType.UI_INPUT_END, 1728409868, a);
        }
    }

    /* compiled from: expiry_month */
    class C15924 implements MemberBatchedListLoaderListener<ImmutableList<User>> {
        final /* synthetic */ MemberPickerFragment f14595a;

        C15924(MemberPickerFragment memberPickerFragment) {
            this.f14595a = memberPickerFragment;
        }

        public final void mo890a(ImmutableMap<String, ImmutableList<User>> immutableMap) {
            this.f14595a.a(immutableMap);
        }
    }

    /* compiled from: expiry_month */
    class C15935 implements MemberBatchedListLoaderListener<ImmutableList<User>> {
        final /* synthetic */ MemberPickerFragment f14596a;

        C15935(MemberPickerFragment memberPickerFragment) {
            this.f14596a = memberPickerFragment;
        }

        public final void mo890a(ImmutableMap<String, ImmutableList<User>> immutableMap) {
            if (immutableMap.isEmpty()) {
                this.f14596a.b(true);
            } else {
                this.f14596a.a(immutableMap);
            }
        }
    }

    /* compiled from: expiry_month */
    public class C15946 implements MemberListLoaderListener<User> {
        final /* synthetic */ MemberPickerFragment f14597a;

        public C15946(MemberPickerFragment memberPickerFragment) {
            this.f14597a = memberPickerFragment;
        }

        public final void m16457a(ImmutableList<User> immutableList, GraphQLGroupVisibility graphQLGroupVisibility) {
            this.f14597a.a(ImmutableBiMap.b(GenericFriendsSelectorFragment.a, immutableList));
        }

        public final void m16458a(boolean z) {
        }
    }

    /* compiled from: expiry_month */
    public class State implements Parcelable {
        public static final Creator CREATOR = new C15951();
        List<SimpleUserToken> f14598a;
        private String f14599b;

        /* compiled from: expiry_month */
        final class C15951 implements Creator {
            C15951() {
            }

            public final Object createFromParcel(Parcel parcel) {
                return new State(parcel.readString(), parcel.readArrayList(SimpleUserToken.class.getClassLoader()));
            }

            public final Object[] newArray(int i) {
                return new State[i];
            }
        }

        public State(String str, List<SimpleUserToken> list) {
            this.f14599b = str;
            this.f14598a = list;
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.f14599b);
            parcel.writeList(this.f14598a);
        }
    }

    public static void m16461a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        ((MemberPickerFragment) obj).m16460a((ListeningExecutorService) ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.a(injectorLike), Toaster.a(injectorLike), GraphQLQueryExecutor.a(injectorLike), ResourcesMethodAutoProvider.a(injectorLike), MultipleMemberAdder.m16846a(injectorLike), (UserFriendsListLoaderProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(UserFriendsListLoaderProvider.class), (DisabledAwareTypeaheadAdapterViewFactory) FB4AMemberPickerRowViewFactory.a(injectorLike), DefaultMemberPickerNavigationHandler.m16402a(injectorLike), IdBasedProvider.a(injectorLike, 4442), (SuggestedMembersBatchedListLoaderProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(SuggestedMembersBatchedListLoaderProvider.class), IdBasedLazy.a(injectorLike, 7055), IdBasedLazy.a(injectorLike, 7053), IdBasedLazy.a(injectorLike, 7054), GatekeeperStoreImplMethodAutoProvider.a(injectorLike), (QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike), MemberPickerMutationResultHelper.m16481a(injectorLike));
    }

    private void m16460a(ListeningExecutorService listeningExecutorService, Toaster toaster, GraphQLQueryExecutor graphQLQueryExecutor, Resources resources, MultipleMemberAdder multipleMemberAdder, UserFriendsListLoaderProvider userFriendsListLoaderProvider, DisabledAwareTypeaheadAdapterViewFactory disabledAwareTypeaheadAdapterViewFactory, MemberPickerNavigationHandler memberPickerNavigationHandler, Provider<String> provider, SuggestedMembersBatchedListLoaderProvider suggestedMembersBatchedListLoaderProvider, Lazy<GroupAddMemberSearchListLoader> lazy, Lazy<GroupAddInviteMemberSearchListLoader> lazy2, Lazy<GroupAddMemberFriendSearchListLoader> lazy3, GatekeeperStore gatekeeperStore, QeAccessor qeAccessor, MemberPickerMutationResultHelper memberPickerMutationResultHelper) {
        this.av = listeningExecutorService;
        this.aw = toaster;
        this.ax = graphQLQueryExecutor;
        this.ay = resources;
        this.az = multipleMemberAdder;
        this.aA = userFriendsListLoaderProvider;
        this.aB = disabledAwareTypeaheadAdapterViewFactory;
        this.aC = memberPickerNavigationHandler;
        this.aD = provider;
        this.aE = suggestedMembersBatchedListLoaderProvider;
        this.aF = lazy;
        this.aG = lazy2;
        this.aH = lazy3;
        this.aI = gatekeeperStore;
        this.aJ = qeAccessor;
        this.aK = memberPickerMutationResultHelper;
    }

    public static void aQ(MemberPickerFragment memberPickerFragment) {
        ImmutableList ax = memberPickerFragment.ax();
        if (!memberPickerFragment.m16465d(ax)) {
            memberPickerFragment.aw.b(new ToastBuilder(aW(memberPickerFragment) ? 2131239524 : 2131239523));
        } else if (memberPickerFragment.aU == Type.TYPE_CREATE_FLOW && memberPickerFragment.aO != null) {
            Stage stage = Stage.ADD_MEMBERS;
            State state = new State(m16459a(ax), memberPickerFragment.ar);
        } else if (memberPickerFragment.aU == Type.TYPE_EXISTING_GROUP) {
            memberPickerFragment.m16463b(memberPickerFragment.ax());
        }
    }

    protected final void aH() {
        aQ(this);
    }

    public final boolean O_() {
        DefaultMemberPickerNavigationHandler defaultMemberPickerNavigationHandler = this.aC;
        if (null == null) {
            return false;
        }
        aS(this);
        return true;
    }

    protected final ViewFactory ar() {
        if (this.aP == null) {
            aW(this);
        }
        return this.aB;
    }

    public static void aS(MemberPickerFragment memberPickerFragment) {
        if (memberPickerFragment.aU != Type.TYPE_CREATE_FLOW || memberPickerFragment.aO == null) {
            memberPickerFragment.kO_().d();
            return;
        }
        Stage stage = Stage.ADD_MEMBERS;
        State state = new State(m16459a(memberPickerFragment.ax()), memberPickerFragment.ar);
    }

    protected final void m16478n(Bundle bundle) {
        super.n(bundle);
        if (bundle != null) {
            this.aX = bundle.getParcelableArrayList("selectedTokens");
        }
    }

    protected final void av() {
        if (this.aX != null && !this.aX.isEmpty()) {
            a(new HashSet(this.aX));
            this.aX = null;
        }
    }

    protected final void aL() {
        aT(this);
    }

    protected final void aF() {
        AdapterDetour.a(this.al, -1929602717);
    }

    public static void aT(MemberPickerFragment memberPickerFragment) {
        memberPickerFragment.ax().size();
    }

    private static String m16459a(ImmutableList<String> immutableList) {
        return StringUtil.b(",", new Object[]{immutableList});
    }

    public final void m16475c(Bundle bundle) {
        super.c(bundle);
        Class cls = MemberPickerFragment.class;
        m16461a((Object) this, getContext());
        this.aU = Type.TYPE_EXISTING_GROUP;
        Bundle bundle2 = this.s;
        if (bundle2 != null) {
            if (bundle2.getBoolean("CreateFlowType")) {
                this.aU = Type.TYPE_CREATE_FLOW;
            } else {
                this.aP = bundle2.getString("group_feed_id");
                this.aR = bundle2.getString("group_visibility");
                this.aQ = bundle2.getString("group_url");
            }
        }
        this.aV = new ImmutableSectionedListSection("", ImmutableList.of(new InviteIntentToken()));
    }

    public final void m16469G() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1972617485);
        super.G();
        aT(this);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 1095243352, a);
    }

    protected final void m16477g(int i) {
        BaseToken baseToken = (BaseToken) this.al.getItem(i);
        if (baseToken.a == BaseToken.Type.USER) {
            a((SimpleUserToken) baseToken, this.as);
        } else if (baseToken.a != BaseToken.Type.INVITE) {
        } else {
            if (this.aQ == null) {
                BLog.b("MemberPickerFragment", "group url is null for inviting users via share.");
            } else {
                getContext();
            }
        }
    }

    public final void m16473a(View view, Bundle bundle) {
        super.a(view, bundle);
        DefaultMemberPickerNavigationHandler defaultMemberPickerNavigationHandler = this.aC;
        C15902 c15902 = new C15902(this);
        C15891 c15891 = new C15891(this);
        aW(this);
        HasTitleBar hasTitleBar = (HasTitleBar) a(HasTitleBar.class);
        if (hasTitleBar != null) {
            hasTitleBar.c(true);
            hasTitleBar.y_(2131239522);
            Builder a = TitleBarButtonSpec.a();
            a.g = defaultMemberPickerNavigationHandler.f14559a.getString(2131239516);
            a = a;
            a.h = -2;
            hasTitleBar.a(a.a());
            hasTitleBar.a(new C15801(defaultMemberPickerNavigationHandler, c15902));
        }
        aT(this);
        TokenizedAutoCompleteTextView d = this.ao.d(view);
        d.requestFocus();
        d.setTextMode(TextMode.PLAIN_TEXT);
    }

    public static boolean aW(MemberPickerFragment memberPickerFragment) {
        return memberPickerFragment.aU != null && memberPickerFragment.aU == Type.TYPE_CREATE_FLOW;
    }

    private void m16463b(final ImmutableList<String> immutableList) {
        if (!this.aS) {
            if (this.aP == null) {
                throw new IllegalArgumentException("GroupID has not been set for member picker");
            } else if (m16465d(immutableList)) {
                if (!aW(this)) {
                    this.aT = ProgressDialogFragment.a(this.ay.getQuantityString(2131689737, immutableList.size()), true, false);
                    this.aT.a(s(), null);
                }
                this.aS = true;
                aT(this);
                Futures.a(this.az.m16848a(this.aP, immutableList, aW(this) ? Source.MOBILE_CREATE_GROUP : Source.MOBILE_ADD_MEMBERS), new AbstractDisposableFutureCallback<GraphQLResult<GroupAddMembersMutationModel>>(this) {
                    final /* synthetic */ MemberPickerFragment f14594c;

                    protected final void m16452a(Object obj) {
                        GraphQLResult graphQLResult = (GraphQLResult) obj;
                        int i = 0;
                        this.f14594c.aS = false;
                        ImmutableList.Builder builder = ImmutableList.builder();
                        if (graphQLResult.e != null) {
                            int i2;
                            ImmutableList a = ((GroupAddMembersMutationModel) graphQLResult.e).m16576a();
                            int size = a.size();
                            for (i2 = 0; i2 < size; i2++) {
                                builder.c(((AddedUsersModel) a.get(i2)).m16530j());
                            }
                            a = ((GroupAddMembersMutationModel) graphQLResult.e).m16580m();
                            size = a.size();
                            for (i2 = 0; i2 < size; i2++) {
                                builder.c(((InvitedUsersModel) a.get(i2)).m16563j());
                            }
                            a = ((GroupAddMembersMutationModel) graphQLResult.e).m16577j();
                            size = a.size();
                            for (i2 = 0; i2 < size; i2++) {
                                builder.c(((AlreadyAddedUsersModel) a.get(i2)).m16538j());
                            }
                            a = ((GroupAddMembersMutationModel) graphQLResult.e).m16578k();
                            size = a.size();
                            for (i2 = 0; i2 < size; i2++) {
                                builder.c(((AlreadyInvitedUsersModel) a.get(i2)).m16546j());
                            }
                            a = ((GroupAddMembersMutationModel) graphQLResult.e).m16581n();
                            size = a.size();
                            for (i2 = 0; i2 < size; i2++) {
                                builder.c(((RequestedUsersModel) a.get(i2)).m16571j());
                            }
                        }
                        ImmutableList b = builder.b();
                        if (this.f14594c.y) {
                            MemberPickerFragment.aT(this.f14594c);
                            if (this.f14594c.aT != null) {
                                this.f14594c.aT.b();
                            }
                            if (!MemberPickerFragment.aW(this.f14594c)) {
                                this.f14594c.aw.b(new ToastBuilder(this.f14594c.aK.m16485a(graphQLResult, immutableList.size())));
                                if (b.size() == immutableList.size()) {
                                    this.f14594c.aC.m16404a(this);
                                    return;
                                }
                                ImmutableList copyOf = ImmutableList.copyOf(this.f14594c.ar);
                                int size2 = copyOf.size();
                                while (i < size2) {
                                    SimpleUserToken simpleUserToken = (SimpleUserToken) copyOf.get(i);
                                    if (b.contains(simpleUserToken.p())) {
                                        this.f14594c.a(simpleUserToken, this.f14594c.as);
                                    }
                                    i++;
                                }
                            }
                        }
                    }

                    protected final void m16453a(Throwable th) {
                        this.f14594c.aS = false;
                        if (this.f14594c.y) {
                            MemberPickerFragment.aT(this.f14594c);
                            if (!MemberPickerFragment.aW(this.f14594c)) {
                                this.f14594c.aw.b(new ToastBuilder(this.f14594c.ay.getQuantityString(2131689738, immutableList.size(), new Object[]{Integer.valueOf(immutableList.size())})));
                            }
                            if (this.f14594c.aT != null) {
                                this.f14594c.aT.b();
                            }
                        }
                    }
                }, this.av);
            }
        }
    }

    private boolean m16465d(ImmutableList<String> immutableList) {
        if (immutableList != null && immutableList.size() != 0) {
            if (aW(this)) {
                Object obj;
                for (SimpleUserToken simpleUserToken : this.ar) {
                    if (simpleUserToken instanceof MemberPickerToken) {
                        if (!((MemberPickerToken) simpleUserToken).f14603f) {
                        }
                    }
                    obj = 1;
                }
                obj = null;
                if (obj == null) {
                    return false;
                }
            }
            return true;
        } else if (!aW(this)) {
            return false;
        } else {
            this.aw.b(new ToastBuilder(jW_().getString(2131239523)));
            return false;
        }
    }

    protected final int m16474b(String str) {
        if ("member_suggestions_section".equals(str)) {
            return 2131239518;
        }
        if ("member_picker_merged_section".equals(str)) {
            return 2131239517;
        }
        if ("member_search_result_section".equals(str)) {
            return 2131239519;
        }
        if ("member_search_invite_result_section".equals(str)) {
            return 2131239520;
        }
        return 0;
    }

    protected final boolean m16476c(String str) {
        return "member_search_result_section".equals(str) || "member_search_invite_result_section".equals(str);
    }

    protected final int aC() {
        return 50;
    }

    protected final ImmutableList<String> aD() {
        if (this.aU == Type.TYPE_CREATE_FLOW) {
            return ImmutableList.of(GenericFriendsSelectorFragment.a, "member_search_result_section", "member_search_invite_result_section");
        }
        if (this.aR == null || this.aQ == null || (!this.aR.equals(GraphQLGroupVisibility.OPEN.toString()) && !this.aR.equals(GraphQLGroupVisibility.CLOSED.toString()))) {
            return ImmutableList.of("member_suggestions_section", "member_picker_merged_section", "member_search_result_section", "member_search_invite_result_section");
        }
        return ImmutableList.of(au, "member_suggestions_section", "member_picker_merged_section", "member_search_result_section", "member_search_invite_result_section");
    }

    protected final void aM() {
        m16462a(null, false);
    }

    protected final void au() {
        m16462a(this.as.getUserEnteredPlainText().toString().trim(), false);
    }

    protected final void aG() {
        String trim = this.as.getUserEnteredPlainText().toString().trim();
        if (this.aW == null) {
            this.aW = "";
        }
        if (!this.aW.equals(trim)) {
            this.aW = trim;
            this.al.a(ImmutableList.of(new ImmutableSectionedListSection()));
            m16462a(this.aW, true);
        }
    }

    protected final void aO() {
    }

    protected final Tuple<ImmutableSet<SimpleUserToken>, SectionedListSection<? extends BaseToken>> m16471a(String str, Map<String, ImmutableList<User>> map) {
        if (str.equals(au)) {
            return new Tuple(null, this.aV);
        }
        return super.a(str, map);
    }

    protected final boolean aP() {
        return false;
    }

    public final void m16470H() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1592158948);
        if (this.aM != null) {
            this.aM.mo885a();
        }
        if (this.aN != null) {
            this.aN.e();
        }
        if (this.aL != null) {
            SuggestedMembersBatchedListLoader suggestedMembersBatchedListLoader = this.aL;
            if (suggestedMembersBatchedListLoader.f14614d != null) {
                suggestedMembersBatchedListLoader.f14614d.e();
            }
            if (suggestedMembersBatchedListLoader.f14615e != null) {
                suggestedMembersBatchedListLoader.f14615e.e();
            }
            suggestedMembersBatchedListLoader.f14616f = null;
            suggestedMembersBatchedListLoader.f14617g = null;
            suggestedMembersBatchedListLoader.f14618h = null;
        }
        super.H();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 1114704192, a);
    }

    public final String am_() {
        return "add_member";
    }

    private SuggestedMembersBatchedListLoader aZ() {
        if (this.aL == null) {
            SuggestedMembersBatchedListLoaderProvider suggestedMembersBatchedListLoaderProvider = this.aE;
            String str = this.aP;
            Integer valueOf = Integer.valueOf(7);
            this.aL = new SuggestedMembersBatchedListLoader(str, valueOf, new C15924(this), (SuggestedMemberListLoaderProvider) suggestedMembersBatchedListLoaderProvider.getOnDemandAssistedProviderForStaticDi(SuggestedMemberListLoaderProvider.class), (SuggestedMemberAlphabeticalListLoaderProvider) suggestedMembersBatchedListLoaderProvider.getOnDemandAssistedProviderForStaticDi(SuggestedMemberAlphabeticalListLoaderProvider.class));
        }
        return this.aL;
    }

    protected final SimpleUserToken m16472a(User user, String str) {
        boolean z;
        MemberPickerToken memberPickerToken = new MemberPickerToken(user);
        memberPickerToken.i = a(memberPickerToken.g.b());
        if (Strings.isNullOrEmpty(str) || !str.equals("member_search_invite_result_section")) {
            z = false;
        } else {
            z = true;
        }
        memberPickerToken.f14603f = z;
        return memberPickerToken;
    }

    private GroupAddInviteMembersListLoaderDelegate m16466f(String str) {
        if (this.aM == null) {
            boolean a;
            if (aW(this)) {
                a = this.aI.a(465, false);
            } else {
                a = this.aJ.a(ExperimentsForMemberPickerModule.f14633e, false);
            }
            GroupAddInviteMembersListLoaderDelegate groupAddInviteMembersListLoaderDelegate = a ? (GroupAddInviteMembersListLoaderDelegate) this.aG.get() : aW(this) ? (GroupAddInviteMembersListLoaderDelegate) this.aH.get() : (GroupAddInviteMembersListLoaderDelegate) this.aF.get();
            this.aM = groupAddInviteMembersListLoaderDelegate;
        }
        if (!this.aM.mo888b().equals(str)) {
            this.aM.mo885a();
        }
        if (!this.aM.mo889c()) {
            this.aM.mo887a(this.aP, new C15935(this), this.aU);
        }
        return this.aM;
    }

    private void m16464b(String str, boolean z) {
        if (StringUtil.c(str)) {
            m16468h(z);
        } else {
            m16466f(str).mo886a(str);
        }
    }

    private void m16467g(String str) {
        if (StringUtil.c(str)) {
            if (this.aN == null) {
                UserFriendsListLoaderProvider userFriendsListLoaderProvider = this.aA;
                this.aN = new UserFriendsListLoader(TasksManager.b(userFriendsListLoaderProvider), (String) this.aD.get(), GraphQLQueryExecutor.a(userFriendsListLoaderProvider), new C15946(this));
            }
            this.aN.f();
            if (this.aM != null) {
                this.aM.mo885a();
                return;
            }
            return;
        }
        m16466f(str).mo886a(str);
        if (this.aN != null) {
            this.aN.e();
        }
    }

    private void m16468h(boolean z) {
        if (z) {
            aZ().m16506a(true);
            return;
        }
        aZ().m16505a();
        if (this.aM != null) {
            this.aM.mo885a();
        }
    }

    private void m16462a(String str, boolean z) {
        Object obj;
        if (this.aP == null) {
            obj = 1;
        } else {
            obj = null;
        }
        if (obj != null) {
            m16467g(str);
        } else {
            m16464b(str, z);
        }
    }
}
