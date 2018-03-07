package com.facebook.groups.feed.ui;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Build.VERSION;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.util.CollectionUtil;
import com.facebook.content.SecureContextHelper;
import com.facebook.dracula.api.DraculaReturnValue;
import com.facebook.dracula.runtime.base.DraculaRuntime;
import com.facebook.fbui.widget.megaphone.Megaphone;
import com.facebook.fbui.widget.megaphone.Megaphone.OnDismissListener;
import com.facebook.feedplugins.groupcommerce.GroupCommerceViewHelper;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.calls.AymtLogEventInputData.EventType;
import com.facebook.graphql.enums.GraphQLGroupAdminType;
import com.facebook.graphql.enums.GraphQLGroupJoinState;
import com.facebook.graphql.enums.GraphQLGroupPostStatus;
import com.facebook.graphql.enums.GraphQLGroupVisibility;
import com.facebook.groupcommerce.util.GroupCommerceComposerHelper;
import com.facebook.groups.feed.protocol.FetchGroupInformationGraphQLModels.FetchGroupInformationModel;
import com.facebook.groups.feed.protocol.FetchGroupInformationGraphQLModels.GroupHeaderInformationModel.GroupConfigsModel.NodesModel;
import com.facebook.groups.feed.protocol.FetchGroupInformationGraphQLModels.GroupSuggestionTipsModel.TipsChannelModel.TipsModel;
import com.facebook.groups.feed.ui.GroupMallMegaphoneController.MallMegaphoneType;
import com.facebook.groups.feed.ui.GroupSuggestionCardView.C31621;
import com.facebook.groups.feed.ui.GroupSuggestionCardView.C31632;
import com.facebook.groups.feed.ui.GroupsFeedFragment.AnonymousClass15;
import com.facebook.groups.feed.ui.GroupsInMallGiantJoinButtonView.C32001;
import com.facebook.groups.feed.ui.contextual.GroupsContextItemsHelper;
import com.facebook.groups.feed.ui.headerstore.GroupsFeedHeaderStore;
import com.facebook.groups.memberlist.intent.MembershipIntentBuilder;
import com.facebook.groups.protocol.GroupInformationInterfaceFactory;
import com.facebook.groups.protocol.GroupInformationInterfaceFactory.1;
import com.facebook.groups.staticadapter.StaticAdapter.AbstractSection;
import com.facebook.groups.staticadapter.StaticAdapter.BindableSection;
import com.facebook.groups.staticadapter.StaticAdapter.Section;
import com.facebook.groups.staticadapter.StaticAdapter.StaticSection;
import com.facebook.groups.staticadapter.StaticAdapter.ViewType;
import com.facebook.inject.Assisted;
import com.facebook.inject.Lazy;
import com.facebook.interstitial.manager.InterstitialIntentController;
import com.facebook.interstitial.manager.InterstitialManager;
import com.facebook.interstitial.manager.InterstitialTrigger;
import com.facebook.interstitial.manager.InterstitialTrigger.Action;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.megaphone.ui.QuickPromotionMegaphoneStoryView;
import com.facebook.qe.api.QeAccessor;
import com.facebook.quickpromotion.model.QuickPromotionDefinition;
import com.facebook.quickpromotion.ui.QuickPromotionMegaphoneController;
import com.facebook.tools.dextr.runtime.detour.AdapterDetour;
import com.facebook.widget.listview.FbBaseAdapter;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.collect.RegularImmutableList;
import javax.inject.Inject;

/* compiled from: ThreadViewMessagesFragment.maybeClearComposerComponents */
public class GroupsPlutoniumHeaderAdapter extends FbBaseAdapter {
    private static final String f22353a = GroupsPlutoniumHeaderAdapter.class.getName();
    public final AnonymousClass15 f22354b;
    private final Lazy<FbErrorReporter> f22355c;
    public final Lazy<SecureContextHelper> f22356d;
    public final Lazy<MembershipIntentBuilder> f22357e;
    private final QeAccessor f22358f;
    private final GroupsContextItemsHelper f22359g;
    private final GroupsFeedMegaphoneControllerProvider f22360h;
    public FetchGroupInformationModel f22361i;
    public GroupsPlutoniumHeaderAdapterListener f22362j;
    private ImmutableList<Section> f22363k = RegularImmutableList.a;
    public boolean f22364l;
    public boolean f22365m;
    private boolean f22366n;
    public boolean f22367o;
    private InterstitialManager f22368p;
    public Context f22369q;
    public GroupMallMegaphoneController f22370r;
    private QuickPromotionDefinition f22371s;

    /* compiled from: ThreadViewMessagesFragment.maybeClearComposerComponents */
    public interface GroupsPlutoniumHeaderAdapterListener {
        void mo988a();
    }

    @Inject
    public GroupsPlutoniumHeaderAdapter(Lazy<FbErrorReporter> lazy, Lazy<SecureContextHelper> lazy2, Lazy<MembershipIntentBuilder> lazy3, @Assisted GroupsFeedHeaderStore groupsFeedHeaderStore, QeAccessor qeAccessor, GroupsContextItemsHelper groupsContextItemsHelper, GroupsFeedMegaphoneControllerProvider groupsFeedMegaphoneControllerProvider, InterstitialManager interstitialManager, Context context) {
        this.f22355c = lazy;
        this.f22356d = lazy2;
        this.f22357e = lazy3;
        this.f22354b = groupsFeedHeaderStore;
        this.f22358f = qeAccessor;
        this.f22359g = groupsContextItemsHelper;
        this.f22368p = interstitialManager;
        this.f22369q = context;
        this.f22360h = groupsFeedMegaphoneControllerProvider;
    }

    public final void m23433a(FetchGroupInformationModel fetchGroupInformationModel, boolean z, boolean z2, boolean z3, boolean z4) {
        int i = 1;
        if (this.f22361i != fetchGroupInformationModel || this.f22366n != z || this.f22364l != z2 || this.f22365m != z3 || z4) {
            this.f22361i = fetchGroupInformationModel;
            this.f22366n = z;
            this.f22364l = z2;
            boolean z5 = z2 && z3;
            this.f22365m = z5;
            this.f22370r = this.f22360h.m23304a(this.f22361i, this.f22354b);
            if (this.f22361i == null || this.f22361i.gW_() != null) {
                DraculaReturnValue b;
                MutableFlatBuffer mutableFlatBuffer;
                int i2;
                int i3;
                Object obj;
                Builder builder = ImmutableList.builder();
                builder.c(new AbstractSection<GroupsPlutoniumHeader>(this, GroupsPlutoniumHeaderAdapterRows.f22372a) {
                    final /* synthetic */ GroupsPlutoniumHeaderAdapter f22345a;

                    public final void mo11a(View view) {
                        ((GroupsPlutoniumHeader) view).m23382a(this.f22345a.f22361i, this.f22345a.f22364l);
                    }
                });
                if (this.f22366n && m23428k()) {
                    builder.c(new AbstractSection<Megaphone>(this, GroupsPlutoniumHeaderAdapterRows.f22383l) {
                        final /* synthetic */ GroupsPlutoniumHeaderAdapter f22346a;

                        public final void mo11a(View view) {
                            Megaphone megaphone = (Megaphone) view;
                            if (VERSION.SDK_INT >= 16) {
                                megaphone.setBackground(new ColorDrawable(this.f22346a.f22369q.getResources().getColor(2131361920)));
                            } else {
                                megaphone.setBackgroundDrawable(new ColorDrawable(this.f22346a.f22369q.getResources().getColor(2131361920)));
                            }
                            megaphone.setDividerBackground(2130840709);
                            megaphone.setTitle(this.f22346a.f22370r.mo977a());
                            megaphone.setSubtitle(this.f22346a.f22370r.mo978b());
                            megaphone.setPrimaryButtonText(this.f22346a.f22370r.mo980d());
                            megaphone.setOnPrimaryButtonClickListener(this.f22346a.f22370r.mo982f());
                            if (Strings.isNullOrEmpty(this.f22346a.f22370r.mo979c())) {
                                megaphone.setShowSecondaryButton(false);
                            } else {
                                megaphone.setShowSecondaryButton(true);
                                megaphone.setSecondaryButtonText(this.f22346a.f22370r.mo979c());
                                megaphone.setOnSecondaryButtonClickListener(this.f22346a.f22370r.mo983g());
                            }
                            if (this.f22346a.f22370r.mo981e() != null) {
                                megaphone.setImageUri(this.f22346a.f22370r.mo981e());
                            }
                            OnDismissListener h = this.f22346a.f22370r.mo984h();
                            if (h != null) {
                                megaphone.setShowCloseButton(true);
                                megaphone.m = h;
                            } else {
                                megaphone.setShowCloseButton(false);
                            }
                            if (!this.f22346a.f22367o) {
                                this.f22346a.f22367o = true;
                                this.f22346a.f22370r.mo985i();
                            }
                        }
                    });
                    builder.c(new StaticSection(GroupsPlutoniumHeaderAdapterRows.f22384m));
                }
                if (this.f22361i != null) {
                    b = this.f22361i.b();
                    mutableFlatBuffer = b.a;
                    i2 = b.b;
                    i3 = b.c;
                    i3 = !DraculaRuntime.a(mutableFlatBuffer, i2, null, 0) ? 1 : 0;
                } else {
                    i3 = 0;
                }
                if (!(i3 == 0 || this.f22361i.p().equals(GraphQLGroupJoinState.UNSET_OR_UNRECOGNIZED_ENUM_VALUE))) {
                    if (!m23422b()) {
                        builder.c(new AbstractSection<GroupsPlutoniumHeaderActionBar>(this, GroupsPlutoniumHeaderAdapterRows.f22379h) {
                            final /* synthetic */ GroupsPlutoniumHeaderAdapter f22347a;

                            public final void mo11a(View view) {
                                GroupsPlutoniumHeaderActionBar groupsPlutoniumHeaderActionBar = (GroupsPlutoniumHeaderActionBar) view;
                                this.f22347a.f22362j = groupsPlutoniumHeaderActionBar;
                                groupsPlutoniumHeaderActionBar.m23389a(this.f22347a.f22361i, this.f22347a.f22354b);
                            }
                        });
                    } else if (m23423c()) {
                        builder.c(new AbstractSection<GroupsInMallGiantJoinButtonView>(this, GroupsPlutoniumHeaderAdapterRows.f22380i) {
                            final /* synthetic */ GroupsPlutoniumHeaderAdapter f22348a;

                            public final void mo11a(View view) {
                                GroupsInMallGiantJoinButtonView groupsInMallGiantJoinButtonView = (GroupsInMallGiantJoinButtonView) view;
                                FetchGroupInformationModel fetchGroupInformationModel = this.f22348a.f22361i;
                                AnonymousClass15 anonymousClass15 = this.f22348a.f22354b;
                                if (fetchGroupInformationModel.p().equals(GraphQLGroupJoinState.REQUESTED)) {
                                    groupsInMallGiantJoinButtonView.f22189d.setText(2131238073);
                                }
                                groupsInMallGiantJoinButtonView.f22189d.setOnClickListener(new C32001(groupsInMallGiantJoinButtonView, anonymousClass15, fetchGroupInformationModel));
                            }
                        });
                    }
                    for (Section c : this.f22359g.m23500a(this.f22361i)) {
                        builder.c(c);
                    }
                }
                if (this.f22361i != null) {
                    b = this.f22361i.b();
                    mutableFlatBuffer = b.a;
                    i2 = b.b;
                    i3 = b.c;
                    i3 = !DraculaRuntime.a(mutableFlatBuffer, i2, null, 0) ? 1 : 0;
                } else {
                    i3 = 0;
                }
                if (i3 == 0 || this.f22361i.n() == null || this.f22361i.p() == null) {
                    i = 0;
                } else {
                    b = this.f22361i.b();
                    mutableFlatBuffer = b.a;
                    i2 = b.b;
                    i3 = b.c;
                    if (mutableFlatBuffer.f(i2, 17, GraphQLGroupVisibility.class) == null) {
                        i = 0;
                    }
                }
                if (!(i == 0 || !this.f22366n || m23428k())) {
                    QuickPromotionDefinition quickPromotionDefinition;
                    if (this.f22371s != null) {
                        quickPromotionDefinition = this.f22371s;
                    } else {
                        if (m23429l()) {
                            quickPromotionDefinition = m23421a(Action.ADMIN_GROUP_MALL_MULTITIER_ENABLED_VIEW);
                        } else if (m23430m()) {
                            quickPromotionDefinition = m23421a(Action.MOD_GROUP_MALL_MULTITIER_ENABLED_VIEW);
                        } else {
                            quickPromotionDefinition = null;
                        }
                        if (quickPromotionDefinition == null) {
                            quickPromotionDefinition = m23421a(Action.GROUP_MALL_VIEW);
                        }
                        this.f22371s = quickPromotionDefinition;
                    }
                    if (quickPromotionDefinition != null) {
                        builder.c(new StaticSection(GroupsPlutoniumHeaderAdapterRows.f22384m));
                        builder.c(new AbstractSection<QuickPromotionMegaphoneStoryView>(this, GroupsPlutoniumHeaderAdapterRows.f22385n) {
                            final /* synthetic */ GroupsPlutoniumHeaderAdapter f22351b;

                            /* compiled from: ThreadViewMessagesFragment.maybeClearComposerComponents */
                            class C32391 implements OnClickListener {
                                final /* synthetic */ C32405 f22349a;

                                C32391(C32405 c32405) {
                                    this.f22349a = c32405;
                                }

                                public void onClick(View view) {
                                    int a = Logger.a(2, EntryType.UI_INPUT_START, 596990233);
                                    DraculaReturnValue b = this.f22349a.f22351b.f22361i.b();
                                    MutableFlatBuffer mutableFlatBuffer = b.a;
                                    int i = b.b;
                                    int i2 = b.c;
                                    b = this.f22349a.f22351b.f22361i.b();
                                    MutableFlatBuffer mutableFlatBuffer2 = b.a;
                                    int i3 = b.b;
                                    i2 = b.c;
                                    ((SecureContextHelper) this.f22349a.f22351b.f22356d.get()).a(((MembershipIntentBuilder) this.f22349a.f22351b.f22357e.get()).a(this.f22349a.f22351b.f22361i.gW_(), this.f22349a.f22351b.f22361i.n().toString(), this.f22349a.f22351b.f22361i.p().equals(GraphQLGroupJoinState.MEMBER), ((GraphQLGroupVisibility) mutableFlatBuffer.f(i, 17, GraphQLGroupVisibility.class)).toString(), mutableFlatBuffer2.k(i3, 15)), this.f22349a.f22351b.f22369q);
                                    Logger.a(2, EntryType.UI_INPUT_END, 1560030210, a);
                                }
                            }

                            public final void mo11a(View view) {
                                QuickPromotionMegaphoneStoryView quickPromotionMegaphoneStoryView = (QuickPromotionMegaphoneStoryView) view;
                                quickPromotionMegaphoneStoryView.a(quickPromotionDefinition, QuickPromotionMegaphoneController.a);
                                if (quickPromotionDefinition.primaryAction != null && quickPromotionDefinition.primaryAction.url != null) {
                                    if (VERSION.SDK_INT >= 16) {
                                        quickPromotionMegaphoneStoryView.setBackground(new ColorDrawable(this.f22351b.f22369q.getResources().getColor(2131361920)));
                                    } else {
                                        quickPromotionMegaphoneStoryView.setBackgroundDrawable(new ColorDrawable(this.f22351b.f22369q.getResources().getColor(2131361920)));
                                    }
                                    if (quickPromotionDefinition.primaryAction.url.contains("groups/add_moderator_quick_promotion")) {
                                        quickPromotionMegaphoneStoryView.setOnPrimaryButtonClickListener(new C32391(this));
                                    }
                                }
                            }
                        });
                    }
                }
                if (m23425e()) {
                    builder.c(new BindableSection(GroupsPlutoniumHeaderAdapterRows.f22378g, this.f22361i));
                } else if (m23424d()) {
                    builder.c(new BindableSection(GroupsPlutoniumHeaderAdapterRows.f22377f, this.f22361i));
                }
                if (this.f22361i == null || this.f22361i.w() == null || !CollectionUtil.b(this.f22361i.w().c())) {
                    obj = null;
                } else {
                    obj = 1;
                }
                if (obj != null) {
                    builder.c(new AbstractSection<GroupSuggestionCardView>(this, GroupsPlutoniumHeaderAdapterRows.f22381j) {
                        final /* synthetic */ GroupsPlutoniumHeaderAdapter f22352a;

                        public final void mo11a(View view) {
                            GroupSuggestionCardView groupSuggestionCardView = (GroupSuggestionCardView) view;
                            FetchGroupInformationModel fetchGroupInformationModel = this.f22352a.f22361i;
                            AnonymousClass15 anonymousClass15 = this.f22352a.f22354b;
                            TipsModel tipsModel = (TipsModel) fetchGroupInformationModel.w().c().get(0);
                            groupSuggestionCardView.f22065h.setText(tipsModel.m());
                            groupSuggestionCardView.f22066i.setText(tipsModel.d());
                            groupSuggestionCardView.f22069l.a(Uri.parse(tipsModel.n().a()), GroupSuggestionCardView.f22058g);
                            if (tipsModel.b() != null) {
                                groupSuggestionCardView.f22067j.setText(tipsModel.b());
                            }
                            if (!groupSuggestionCardView.f22070m) {
                                GroupSuggestionCardView.m23206a(groupSuggestionCardView, fetchGroupInformationModel, EventType.IMPRESSION);
                            }
                            groupSuggestionCardView.f22067j.setOnClickListener(new C31621(groupSuggestionCardView, tipsModel, fetchGroupInformationModel, anonymousClass15));
                            groupSuggestionCardView.f22068k.setOnClickListener(new C31632(groupSuggestionCardView, fetchGroupInformationModel, anonymousClass15));
                        }
                    });
                }
                if (m23426f()) {
                    builder.c(new BindableSection(GroupsPlutoniumHeaderAdapterRows.f22374c, this.f22361i));
                }
                if (this.f22361i != null && GroupCommerceComposerHelper.a(GroupInformationInterfaceFactory.a(this.f22361i)) && GroupCommerceViewHelper.a(this.f22361i)) {
                    obj = 1;
                } else {
                    obj = null;
                }
                if (obj != null) {
                    builder.c(new BindableSection(GroupsPlutoniumHeaderAdapterRows.f22376e, this.f22361i));
                }
                if (m23427g()) {
                    builder.c(new BindableSection(GroupsPlutoniumHeaderAdapterRows.f22375d, this.f22361i));
                }
                if (this.f22365m) {
                    builder.c(new StaticSection(GroupsPlutoniumHeaderAdapterRows.f22382k));
                }
                this.f22363k = builder.b();
                AdapterDetour.a(this, 782530562);
                return;
            }
            ((AbstractFbErrorReporter) this.f22355c.get()).b(f22353a, "Tried to bind a group without a group id");
        }
    }

    public int getItemViewType(int i) {
        return GroupsPlutoniumHeaderAdapterRows.f22386o.indexOf(((Section) this.f22363k.get(i)).mo10a());
    }

    public int getViewTypeCount() {
        return GroupsPlutoniumHeaderAdapterRows.f22386o.size();
    }

    public final View m23431a(int i, ViewGroup viewGroup) {
        return ((ViewType) GroupsPlutoniumHeaderAdapterRows.f22386o.get(i)).mo12a(viewGroup);
    }

    public final void m23432a(int i, Object obj, View view, int i2, ViewGroup viewGroup) {
        ((Section) obj).mo11a(view);
    }

    public int getCount() {
        return this.f22363k.size();
    }

    public Object getItem(int i) {
        return this.f22363k.get(i);
    }

    public long getItemId(int i) {
        return (long) i;
    }

    private QuickPromotionDefinition m23421a(Action action) {
        InterstitialIntentController interstitialIntentController = (InterstitialIntentController) this.f22368p.a(new InterstitialTrigger(action), QuickPromotionMegaphoneController.class);
        if (interstitialIntentController == null) {
            return null;
        }
        Intent a = interstitialIntentController.a(this.f22369q);
        if (a == null) {
            return null;
        }
        return (QuickPromotionDefinition) a.getExtras().get("qp_definition");
    }

    private boolean m23422b() {
        return this.f22360h.m23303a(this.f22361i) == MallMegaphoneType.INVITED_MEMBER || m23423c();
    }

    private boolean m23423c() {
        return (this.f22361i.p().equals(GraphQLGroupJoinState.CAN_JOIN) || this.f22361i.p().equals(GraphQLGroupJoinState.CAN_REQUEST) || this.f22361i.p().equals(GraphQLGroupJoinState.REQUESTED)) && this.f22360h.m23303a(this.f22361i) != MallMegaphoneType.INVITED_MEMBER;
    }

    private boolean m23424d() {
        boolean z;
        if (this.f22361i != null) {
            DraculaReturnValue b = this.f22361i.b();
            MutableFlatBuffer mutableFlatBuffer = b.a;
            int i = b.b;
            int i2 = b.c;
            z = !DraculaRuntime.a(mutableFlatBuffer, i, null, 0);
        } else {
            z = false;
        }
        return z && (this.f22361i.q() == GraphQLGroupPostStatus.CAN_POST_AFTER_APPROVAL || this.f22361i.q() == GraphQLGroupPostStatus.CAN_POST_WITHOUT_APPROVAL);
    }

    private boolean m23425e() {
        return this.f22361i != null && GroupCommerceComposerHelper.a(GroupInformationInterfaceFactory.a(this.f22361i)) && "buttons".equals(this.f22358f.a(ExperimentsForGroupsFeedUiModule.f22011a, null));
    }

    private boolean m23426f() {
        boolean z;
        if (this.f22361i != null) {
            DraculaReturnValue b = this.f22361i.b();
            MutableFlatBuffer mutableFlatBuffer = b.a;
            int i = b.b;
            int i2 = b.c;
            z = !DraculaRuntime.a(mutableFlatBuffer, i, null, 0);
        } else {
            z = false;
        }
        if (z && GroupCommerceComposerHelper.a(GroupInformationInterfaceFactory.a(this.f22361i))) {
            b = this.f22361i.b();
            mutableFlatBuffer = b.a;
            i = b.b;
            i2 = b.c;
            z = !DraculaRuntime.a(mutableFlatBuffer, mutableFlatBuffer.g(i, 6), null, 0);
        } else {
            z = false;
        }
        if (z) {
            b = this.f22361i.b();
            mutableFlatBuffer = b.a;
            i = b.b;
            i2 = b.c;
            z = mutableFlatBuffer.j(mutableFlatBuffer.g(i, 6), 1) > 0;
        } else {
            z = false;
        }
        return z && GroupCommerceViewHelper.a(this.f22361i);
    }

    private boolean m23427g() {
        boolean z;
        if (this.f22361i != null) {
            DraculaReturnValue b = this.f22361i.b();
            MutableFlatBuffer mutableFlatBuffer = b.a;
            int i = b.b;
            int i2 = b.c;
            z = !DraculaRuntime.a(mutableFlatBuffer, i, null, 0);
        } else {
            z = false;
        }
        if (z) {
            1 a = GroupInformationInterfaceFactory.a(this.f22361i);
            Object obj = null;
            if (GroupCommerceComposerHelper.a(a)) {
                ImmutableList j = GroupCommerceComposerHelper.j(a);
                if (!(j == null || j.isEmpty())) {
                    obj = 1;
                }
            }
            if (obj != null && GroupCommerceViewHelper.a(this.f22361i)) {
                return true;
            }
        }
        return false;
    }

    private boolean m23428k() {
        return this.f22360h.m23303a(this.f22361i) != null;
    }

    private boolean m23429l() {
        return (this.f22361i == null || this.f22361i.n() == null || this.f22361i.n() != GraphQLGroupAdminType.ADMIN || this.f22361i.r() == null || this.f22361i.r().a() == null || this.f22361i.r().a().isEmpty() || this.f22361i.r().a().get(0) == null || !((NodesModel) this.f22361i.r().a().get(0)).a()) ? false : true;
    }

    private boolean m23430m() {
        return (this.f22361i == null || this.f22361i.n() == null || this.f22361i.n() != GraphQLGroupAdminType.MODERATOR || this.f22361i.r() == null || this.f22361i.r().a() == null || this.f22361i.r().a().isEmpty() || this.f22361i.r().a().get(0) == null || !((NodesModel) this.f22361i.r().a().get(0)).a()) ? false : true;
    }
}
