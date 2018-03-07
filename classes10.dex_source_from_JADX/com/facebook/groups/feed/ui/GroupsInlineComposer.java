package com.facebook.groups.feed.ui;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.support.v4.app.FragmentActivity;
import android.util.AttributeSet;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewStub;
import android.widget.LinearLayout;
import com.facebook.auth.datastore.LoggedInUserAuthDataStore;
import com.facebook.auth.datastore.impl.LoggedInUserSessionManager;
import com.facebook.common.build.IsWorkBuild;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.fblinks.FBLinks;
import com.facebook.common.fragmentconstants.FragmentConstants.ContentFragmentType;
import com.facebook.common.locale.Locales;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.util.ContextUtils;
import com.facebook.common.util.TriState;
import com.facebook.composer.abtest.ExperimentsForComposerAbTestModule;
import com.facebook.composer.activity.ComposerLauncherImpl;
import com.facebook.composer.capability.ComposerFacecastCapability;
import com.facebook.composer.gating.ComposerGatekeepers;
import com.facebook.config.application.Boolean_IsWorkBuildMethodAutoProvider;
import com.facebook.content.SecureContextHelper;
import com.facebook.dracula.api.DraculaReturnValue;
import com.facebook.dracula.runtime.base.DraculaRuntime;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.facecast.FacecastActivity;
import com.facebook.fbui.glyph.GlyphView;
import com.facebook.fbui.menu.MenuItemImpl;
import com.facebook.fbui.tooltip.Tooltip;
import com.facebook.fbui.widget.layout.ImageBlockLayout;
import com.facebook.fbui.widget.layout.SegmentedLinearLayout;
import com.facebook.fbui.widget.text.GlyphWithTextView;
import com.facebook.feed.inlinecomposer.model.InlineComposerModel;
import com.facebook.feed.inlinecomposer.model.InlineComposerModelBuilder;
import com.facebook.feed.util.composer.sprout.SproutAnalyticsLogger.SproutSource;
import com.facebook.fig.bottomsheet.FigBottomSheetAdapter;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.gk.store.GatekeeperStore;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.graphql.calls.ReactionTriggerInputTriggerData.Surface;
import com.facebook.graphql.enums.GraphQLGroupVisibility;
import com.facebook.groupcommerce.util.GroupCommerceComposerHelper;
import com.facebook.groups.feed.protocol.FetchGroupInformationGraphQLModels.FetchGroupInformationModel;
import com.facebook.groups.feed.ui.nux.GroupsSeedsComposerNuxInterstitialController;
import com.facebook.groups.feed.ui.nux.GroupsSeedsComposerSellSomethingNuxInterstitialController;
import com.facebook.groups.protocol.GroupInformationInterfaceFactory;
import com.facebook.groups.protocol.GroupInformationInterfaceFactory.1;
import com.facebook.groups.staticadapter.StaticAdapter.Bindable;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.Lazy;
import com.facebook.intent.feed.IFeedIntentBuilder;
import com.facebook.interstitial.manager.InterstitialManager;
import com.facebook.interstitial.manager.InterstitialTrigger;
import com.facebook.interstitial.manager.InterstitialTrigger.Action;
import com.facebook.ipc.composer.intent.ComposerConfiguration;
import com.facebook.ipc.composer.intent.ComposerConfigurationFactory;
import com.facebook.ipc.composer.intent.ComposerTargetData.Builder;
import com.facebook.ipc.composer.intent.DefaultPluginConfigSerializer;
import com.facebook.ipc.composer.intent.EmptyPluginConfig;
import com.facebook.ipc.composer.launch.ComposerLauncher;
import com.facebook.ipc.composer.model.ComposerSourceSurface;
import com.facebook.ipc.composer.model.TargetType;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.messaging.appspecific.AppGlyphResolver;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.resources.ui.FbTextView;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.user.model.User;
import com.facebook.widget.LazyView;
import com.facebook.widget.bottomsheet.BottomSheetDialog;
import com.google.common.base.Preconditions;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: ThreadViewThreadKeyLoader */
public class GroupsInlineComposer extends SegmentedLinearLayout implements Bindable<FetchGroupInformationModel> {
    public static final CallerContext f22205n = CallerContext.a(GroupsInlineComposer.class, "group_feed");
    private final OnClickListener f22206A;
    @Inject
    ComposerLauncher f22207a;
    @Inject
    Provider<IFeedIntentBuilder> f22208b;
    @Inject
    LoggedInUserSessionManager f22209c;
    @Inject
    public Lazy<SecureContextHelper> f22210d;
    @Inject
    GatekeeperStoreImpl f22211e;
    @Inject
    @IsSellActionInInlineComposerEnabled
    Provider<TriState> f22212f;
    @Inject
    GroupsInlineComposerActionOptionController f22213g;
    @Inject
    InterstitialManager f22214h;
    @Inject
    Locales f22215i;
    @Inject
    @IsWorkBuild
    Boolean f22216j;
    @Inject
    public QeAccessor f22217k;
    @Inject
    GroupsInlineComposerSproutUtil f22218l;
    @Inject
    public Lazy<ComposerFacecastCapability> f22219m;
    public User f22220o;
    public FbTextView f22221p;
    public GlyphView f22222q;
    private GlyphView f22223r;
    public FbDraweeView f22224s;
    public FetchGroupInformationModel f22225t;
    public LazyView<LinearLayout> f22226u;
    public ImageBlockLayout f22227v;
    private boolean f22228w;
    private String f22229x;
    private final float f22230y;
    private final OnClickListener f22231z;

    /* compiled from: ThreadViewThreadKeyLoader */
    class C32011 implements OnClickListener {
        final /* synthetic */ GroupsInlineComposer f22196a;

        C32011(GroupsInlineComposer groupsInlineComposer) {
            this.f22196a = groupsInlineComposer;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -245202723);
            GroupsInlineComposer.m23341o(this.f22196a);
            Logger.a(2, EntryType.UI_INPUT_END, -887177520, a);
        }
    }

    /* compiled from: ThreadViewThreadKeyLoader */
    class C32022 implements OnClickListener {
        final /* synthetic */ GroupsInlineComposer f22197a;

        C32022(GroupsInlineComposer groupsInlineComposer) {
            this.f22197a = groupsInlineComposer;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -76964254);
            GroupsInlineComposer.m23342p(this.f22197a);
            Logger.a(2, EntryType.UI_INPUT_END, 2006583205, a);
        }
    }

    /* compiled from: ThreadViewThreadKeyLoader */
    class C32033 implements OnClickListener {
        final /* synthetic */ GroupsInlineComposer f22198a;

        C32033(GroupsInlineComposer groupsInlineComposer) {
            this.f22198a = groupsInlineComposer;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 1363919001);
            InlineComposerModel a2 = new InlineComposerModelBuilder(this.f22198a.f22220o.a, this.f22198a.f22220o.x()).a();
            FragmentActivity fragmentActivity = (FragmentActivity) ContextUtils.a(this.f22198a.getContext(), FragmentActivity.class);
            if (fragmentActivity != null) {
                int[] iArr = new int[2];
                GroupsInlineComposerSproutUtil groupsInlineComposerSproutUtil = this.f22198a.f22218l;
                FetchGroupInformationModel fetchGroupInformationModel = this.f22198a.f22225t;
                int i = iArr[1];
                groupsInlineComposerSproutUtil.f22239b.m23220a(SproutSource.GROUPS, fragmentActivity.kO_(), fragmentActivity, fetchGroupInformationModel).m23218a(a2.b, 2131238047, groupsInlineComposerSproutUtil.f22238a.getDimensionPixelOffset(2131427594) + i);
            }
            Logger.a(2, EntryType.UI_INPUT_END, 80022558, a);
        }
    }

    /* compiled from: ThreadViewThreadKeyLoader */
    class C32044 implements OnClickListener {
        final /* synthetic */ GroupsInlineComposer f22199a;

        C32044(GroupsInlineComposer groupsInlineComposer) {
            this.f22199a = groupsInlineComposer;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -284700657);
            1 a2 = GroupInformationInterfaceFactory.a(this.f22199a.f22225t);
            Preconditions.checkNotNull(a2);
            SecureContextHelper secureContextHelper = (SecureContextHelper) this.f22199a.f22210d.get();
            Context context = this.f22199a.getContext();
            String b = GroupCommerceComposerHelper.b(a2, this.f22199a.f22215i);
            Builder builder = new Builder(Long.parseLong(a2.a()), TargetType.GROUP);
            builder.c = a2.b();
            secureContextHelper.a(GroupCommerceComposerHelper.a(context, a2, ComposerConfigurationFactory.a(ComposerSourceSurface.GROUP_FEED, "groupCommerceComposerHelper", b, builder.a(), GroupCommerceComposerHelper.j(a2)).setReactionSurface(Surface.ANDROID_GROUP_COMPOSER).a(), false), 1756, (Activity) ContextUtils.a(this.f22199a.getContext(), Activity.class));
            Logger.a(2, EntryType.UI_INPUT_END, 1484340819, a);
        }
    }

    /* compiled from: ThreadViewThreadKeyLoader */
    class C32055 implements OnClickListener {
        final /* synthetic */ GroupsInlineComposer f22200a;

        C32055(GroupsInlineComposer groupsInlineComposer) {
            this.f22200a = groupsInlineComposer;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 2063338550);
            ((SecureContextHelper) this.f22200a.f22210d.get()).a(GroupCommerceComposerHelper.a(this.f22200a.getContext(), GroupInformationInterfaceFactory.a(this.f22200a.f22225t), ComposerConfigurationFactory.a(ComposerSourceSurface.GROUP_FEED, "groupCommerce").setReactionSurface(Surface.ANDROID_GROUP_COMPOSER).a(), this.f22200a.f22217k.a(ExperimentsForComposerAbTestModule.L, false)), 1756, (Activity) ContextUtils.a(this.f22200a.getContext(), Activity.class));
            Logger.a(2, EntryType.UI_INPUT_END, -1411657574, a);
        }
    }

    /* compiled from: ThreadViewThreadKeyLoader */
    class C32066 implements OnClickListener {
        final /* synthetic */ GroupsInlineComposer f22201a;

        C32066(GroupsInlineComposer groupsInlineComposer) {
            this.f22201a = groupsInlineComposer;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 1269390907);
            if (this.f22201a.f22220o == null) {
                Logger.a(2, EntryType.UI_INPUT_END, -823924495, a);
                return;
            }
            ((IFeedIntentBuilder) this.f22201a.f22208b.get()).a(this.f22201a.getContext(), StringFormatUtil.formatStrLocaleSafe(FBLinks.aX, this.f22201a.f22220o.a));
            LogUtils.a(1916296549, a);
        }
    }

    /* compiled from: ThreadViewThreadKeyLoader */
    class C32077 implements OnClickListener {
        final /* synthetic */ GroupsInlineComposer f22202a;

        C32077(GroupsInlineComposer groupsInlineComposer) {
            this.f22202a = groupsInlineComposer;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -2098560034);
            GroupsInlineComposer.m23333b(this.f22202a, view);
            Logger.a(2, EntryType.UI_INPUT_END, -1216931146, a);
        }
    }

    /* compiled from: ThreadViewThreadKeyLoader */
    class C32088 implements OnMenuItemClickListener {
        final /* synthetic */ GroupsInlineComposer f22203a;

        C32088(GroupsInlineComposer groupsInlineComposer) {
            this.f22203a = groupsInlineComposer;
        }

        public boolean onMenuItemClick(MenuItem menuItem) {
            GroupsInlineComposerActionOptionController groupsInlineComposerActionOptionController = this.f22203a.f22213g;
            GroupsInlineComposerActionOptionController.m23345a("groups_seeds_composer_write_post");
            GroupsInlineComposer.m23341o(this.f22203a);
            return true;
        }
    }

    /* compiled from: ThreadViewThreadKeyLoader */
    class C32099 implements OnMenuItemClickListener {
        final /* synthetic */ GroupsInlineComposer f22204a;

        C32099(GroupsInlineComposer groupsInlineComposer) {
            this.f22204a = groupsInlineComposer;
        }

        public boolean onMenuItemClick(MenuItem menuItem) {
            GroupsInlineComposer groupsInlineComposer = this.f22204a;
            Builder builder = new Builder();
            builder.a = Long.parseLong(groupsInlineComposer.f22225t.gW_());
            DraculaReturnValue b = groupsInlineComposer.f22225t.b();
            MutableFlatBuffer mutableFlatBuffer = b.a;
            int i = b.b;
            int i2 = b.c;
            builder.c = mutableFlatBuffer.k(i, 13);
            builder.b = TargetType.GROUP;
            b = groupsInlineComposer.f22225t.b();
            mutableFlatBuffer = b.a;
            i = b.b;
            i2 = b.c;
            builder.d = mutableFlatBuffer.k(i, 15);
            Intent intent = new Intent(groupsInlineComposer.getContext(), FacecastActivity.class);
            intent.putExtras(FacecastActivity.a(builder.a()));
            ((SecureContextHelper) groupsInlineComposer.f22210d.get()).a(intent, groupsInlineComposer.getContext());
            return true;
        }
    }

    public static void m23332a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((GroupsInlineComposer) obj).m23331a((ComposerLauncher) ComposerLauncherImpl.a(fbInjector), IdBasedSingletonScopeProvider.a(fbInjector, 2347), LoggedInUserSessionManager.a(fbInjector), IdBasedSingletonScopeProvider.b(fbInjector, 968), GatekeeperStoreImplMethodAutoProvider.a(fbInjector), IdBasedProvider.a(fbInjector, 688), GroupsInlineComposerActionOptionController.m23349b(fbInjector), InterstitialManager.a(fbInjector), Locales.a(fbInjector), Boolean_IsWorkBuildMethodAutoProvider.a(fbInjector), (QeAccessor) QeInternalImplMethodAutoProvider.a(fbInjector), GroupsInlineComposerSproutUtil.m23350b(fbInjector), IdBasedLazy.a(fbInjector, 5199));
    }

    public final void mo758a(Object obj) {
        this.f22225t = (FetchGroupInformationModel) obj;
        this.f22220o = this.f22209c.c();
        if (!(this.f22220o == null || this.f22220o.x() == null)) {
            this.f22224s.a(Uri.parse(this.f22220o.x()), f22205n);
        }
        if (this.f22223r == null && !m23335c()) {
            this.f22223r = (GlyphView) ((ViewStub) a(2131562771)).inflate();
            m23330a(this.f22223r);
        }
        if (m23334b()) {
            m23340n();
            this.f22229x = this.f22217k.a(ExperimentsForGroupsFeedUiModule.f22011a, null);
        } else {
            this.f22229x = null;
        }
        if (!this.f22228w) {
            m23338j();
            this.f22228w = true;
        }
    }

    private void m23331a(ComposerLauncher composerLauncher, Provider<IFeedIntentBuilder> provider, LoggedInUserAuthDataStore loggedInUserAuthDataStore, Lazy<SecureContextHelper> lazy, GatekeeperStore gatekeeperStore, Provider<TriState> provider2, GroupsInlineComposerActionOptionController groupsInlineComposerActionOptionController, InterstitialManager interstitialManager, Locales locales, Boolean bool, QeAccessor qeAccessor, GroupsInlineComposerSproutUtil groupsInlineComposerSproutUtil, Lazy<ComposerFacecastCapability> lazy2) {
        this.f22207a = composerLauncher;
        this.f22208b = provider;
        this.f22209c = loggedInUserAuthDataStore;
        this.f22210d = lazy;
        this.f22211e = gatekeeperStore;
        this.f22212f = provider2;
        this.f22213g = groupsInlineComposerActionOptionController;
        this.f22214h = interstitialManager;
        this.f22215i = locales;
        this.f22216j = bool;
        this.f22217k = qeAccessor;
        this.f22218l = groupsInlineComposerSproutUtil;
        this.f22219m = lazy2;
    }

    private ComposerConfiguration getGroupComposerConfiguration() {
        return GroupCommerceComposerHelper.a(GroupInformationInterfaceFactory.a(this.f22225t), this.f22211e.a(ComposerGatekeepers.f), this.f22215i).a();
    }

    public GroupsInlineComposer(Context context) {
        this(context, null);
    }

    private GroupsInlineComposer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f22230y = 0.8f;
        this.f22231z = new C32011(this);
        this.f22206A = new C32022(this);
        Class cls = GroupsInlineComposer.class;
        m23332a(this, getContext());
        setContentView(2130904714);
        setOrientation(1);
        this.f22227v = (ImageBlockLayout) a(2131562767);
        this.f22221p = (FbTextView) a(2131562769);
        this.f22222q = (GlyphView) a(2131562770);
        this.f22224s = (FbDraweeView) a(2131562768);
        this.f22226u = new LazyView((ViewStub) a(2131562773));
        getResources();
        setGravity(16);
        int dimensionPixelSize = getResources().getDimensionPixelSize(2131427593);
        setBackgroundResource(2130840686);
        setPadding(0, dimensionPixelSize, 0, 0);
        setShowSegmentedDividers(2);
        setSegmentedDivider(new ColorDrawable(getResources().getColor(2131363545)));
        setSegmentedDividerThickness(1);
        setSegmentedDividerPadding(getResources().getDimensionPixelSize(2131427642));
    }

    private boolean m23334b() {
        return this.f22225t != null && GroupCommerceComposerHelper.a(GroupInformationInterfaceFactory.a(this.f22225t));
    }

    private void m23330a(View view) {
        GroupsSeedsComposerNuxInterstitialController groupsSeedsComposerNuxInterstitialController = (GroupsSeedsComposerNuxInterstitialController) this.f22214h.a(new InterstitialTrigger(Action.GROUP_SEEDS_COMPOSER), GroupsSeedsComposerNuxInterstitialController.class);
        Tooltip tooltip;
        if (groupsSeedsComposerNuxInterstitialController != null && view != null) {
            if (view != null) {
                tooltip = new Tooltip(view.getContext(), 2);
                tooltip.a(2131238055);
                tooltip.f(view);
            }
            this.f22214h.a().a(groupsSeedsComposerNuxInterstitialController.b());
        } else if (m23337e()) {
            GroupsSeedsComposerSellSomethingNuxInterstitialController groupsSeedsComposerSellSomethingNuxInterstitialController = (GroupsSeedsComposerSellSomethingNuxInterstitialController) this.f22214h.a(new InterstitialTrigger(Action.GROUP_SEEDS_COMPOSER), GroupsSeedsComposerSellSomethingNuxInterstitialController.class);
            if (groupsSeedsComposerSellSomethingNuxInterstitialController != null && view != null) {
                if (view != null) {
                    tooltip = new Tooltip(view.getContext(), 2);
                    tooltip.a(2131238056);
                    tooltip.f(view);
                }
                this.f22214h.a().a(groupsSeedsComposerSellSomethingNuxInterstitialController.m23504b());
            }
        }
    }

    private boolean m23335c() {
        return m23334b() && "inline_buttons".equals(this.f22229x);
    }

    private boolean m23336d() {
        return m23334b() && "inline_sprouts".equals(this.f22229x);
    }

    private boolean m23337e() {
        return this.f22212f.get() == TriState.YES;
    }

    private void m23338j() {
        if (!m23334b()) {
            this.f22227v.setOnClickListener(this.f22231z);
            this.f22222q.setOnClickListener(new C32055(this));
        } else if (m23336d()) {
            this.f22227v.setOnClickListener(new C32033(this));
            this.f22222q.setVisibility(8);
            this.f22223r.setVisibility(8);
        } else {
            this.f22227v.setOnClickListener(this.f22206A);
            this.f22222q.setOnClickListener(new C32044(this));
        }
        this.f22224s.setOnClickListener(new C32066(this));
        if (this.f22223r != null) {
            this.f22223r.setOnClickListener(new C32077(this));
        }
    }

    public static void m23333b(GroupsInlineComposer groupsInlineComposer, View view) {
        MenuItemImpl e;
        FigBottomSheetAdapter figBottomSheetAdapter = new FigBottomSheetAdapter(view.getContext());
        figBottomSheetAdapter.d = true;
        if (groupsInlineComposer.m23334b() && !groupsInlineComposer.m23335c()) {
            e = figBottomSheetAdapter.e(2131238053);
            e.setIcon(2130839809);
            e.setOnMenuItemClickListener(new C32088(groupsInlineComposer));
        }
        if (((ComposerFacecastCapability) groupsInlineComposer.f22219m.get()).a(TargetType.GROUP)) {
            e = figBottomSheetAdapter.e(2131238057);
            e.setIcon(2130839966);
            e.setOnMenuItemClickListener(new C32099(groupsInlineComposer));
        }
        e = figBottomSheetAdapter.e(2131238058);
        e.setIcon(2130839958);
        e.setOnMenuItemClickListener(new OnMenuItemClickListener(groupsInlineComposer) {
            final /* synthetic */ GroupsInlineComposer f22190a;

            {
                this.f22190a = r1;
            }

            public boolean onMenuItemClick(MenuItem menuItem) {
                GroupsInlineComposerActionOptionController groupsInlineComposerActionOptionController = this.f22190a.f22213g;
                GroupsInlineComposerActionOptionController.m23345a("groups_seeds_composer_create_poll");
                GroupsInlineComposer.m23339l(this.f22190a);
                return true;
            }
        });
        if (groupsInlineComposer.m23337e()) {
            e = figBottomSheetAdapter.e(2131238063);
            e.setIcon(2130840122);
            e.setOnMenuItemClickListener(new OnMenuItemClickListener(groupsInlineComposer) {
                final /* synthetic */ GroupsInlineComposer f22191a;

                {
                    this.f22191a = r1;
                }

                public boolean onMenuItemClick(MenuItem menuItem) {
                    GroupsInlineComposerActionOptionController groupsInlineComposerActionOptionController = this.f22191a.f22213g;
                    GroupsInlineComposerActionOptionController.m23345a("groups_seeds_composer_sell_item");
                    GroupsInlineComposer.m23342p(this.f22191a);
                    return true;
                }
            });
        }
        e = figBottomSheetAdapter.e(2131238062);
        e.setIcon(2130840016);
        e.setOnMenuItemClickListener(new OnMenuItemClickListener(groupsInlineComposer) {
            final /* synthetic */ GroupsInlineComposer f22192a;

            {
                this.f22192a = r1;
            }

            public boolean onMenuItemClick(MenuItem menuItem) {
                GroupsInlineComposerActionOptionController groupsInlineComposerActionOptionController = this.f22192a.f22213g;
                GroupsInlineComposerActionOptionController.m23346a(this.f22192a.f22225t.gW_(), (Activity) ContextUtils.a(this.f22192a.getContext(), Activity.class));
                return true;
            }
        });
        if (!groupsInlineComposer.f22216j.booleanValue()) {
            e = figBottomSheetAdapter.e(2131238059);
            e.setIcon(2130839846);
            e.setOnMenuItemClickListener(new OnMenuItemClickListener(groupsInlineComposer) {
                final /* synthetic */ GroupsInlineComposer f22193a;

                {
                    this.f22193a = r1;
                }

                public boolean onMenuItemClick(MenuItem menuItem) {
                    String str;
                    DraculaReturnValue b = this.f22193a.f22225t.b();
                    MutableFlatBuffer mutableFlatBuffer = b.a;
                    int i = b.b;
                    int i2 = b.c;
                    b = this.f22193a.f22225t.b();
                    MutableFlatBuffer mutableFlatBuffer2 = b.a;
                    int i3 = b.b;
                    i2 = b.c;
                    b = this.f22193a.f22225t.b();
                    MutableFlatBuffer mutableFlatBuffer3 = b.a;
                    int i4 = b.b;
                    i2 = b.c;
                    if (DraculaRuntime.a(mutableFlatBuffer3, mutableFlatBuffer3.g(i4, 14), null, 0)) {
                        str = null;
                    } else {
                        DraculaReturnValue b2 = this.f22193a.f22225t.b();
                        MutableFlatBuffer mutableFlatBuffer4 = b2.a;
                        int i5 = b2.b;
                        int i6 = b2.c;
                        str = mutableFlatBuffer4.k(mutableFlatBuffer4.g(i5, 14), 1);
                    }
                    GroupsInlineComposerActionOptionController groupsInlineComposerActionOptionController = this.f22193a.f22213g;
                    GroupsInlineComposerActionOptionController.m23348a(this.f22193a.f22225t.gW_(), mutableFlatBuffer.k(i, 13), (GraphQLGroupVisibility) mutableFlatBuffer2.f(i3, 17, GraphQLGroupVisibility.class), str, this.f22193a.getContext());
                    return true;
                }
            });
        }
        e = figBottomSheetAdapter.e(2131238060);
        e.setIcon(AppGlyphResolver.a());
        e.setOnMenuItemClickListener(new OnMenuItemClickListener(groupsInlineComposer) {
            final /* synthetic */ GroupsInlineComposer f22194a;

            {
                this.f22194a = r1;
            }

            public boolean onMenuItemClick(MenuItem menuItem) {
                GroupsInlineComposerActionOptionController groupsInlineComposerActionOptionController = this.f22194a.f22213g;
                GroupsInlineComposerActionOptionController.m23347a(this.f22194a.f22225t.gW_(), this.f22194a.getContext());
                return true;
            }
        });
        if (groupsInlineComposer.f22217k.a(ExperimentsForGroupsFeedUiModule.f22014d, false)) {
            e = figBottomSheetAdapter.e(2131238061);
            e.setIcon(2130840005);
            e.setOnMenuItemClickListener(new OnMenuItemClickListener(groupsInlineComposer) {
                final /* synthetic */ GroupsInlineComposer f22195a;

                {
                    this.f22195a = r1;
                }

                public boolean onMenuItemClick(MenuItem menuItem) {
                    GroupsInlineComposerActionOptionController groupsInlineComposerActionOptionController = this.f22195a.f22213g;
                    String gW_ = this.f22195a.f22225t.gW_();
                    Context context = this.f22195a.getContext();
                    GroupsInlineComposerActionOptionController.m23345a("groups_seeds_composer_create_file");
                    Intent component = new Intent().setComponent((ComponentName) GroupsInlineComposerActionOptionController.f22233b.get());
                    component.putExtra("group_feed_id", gW_);
                    component.putExtra("groups_launch_file_selector", true);
                    component.putExtra("target_fragment", ContentFragmentType.GROUP_FILES_FRAGMENT.ordinal());
                    GroupsInlineComposerActionOptionController.f22232a.a(component, context);
                    return true;
                }
            });
        }
        BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(view.getContext());
        bottomSheetDialog.a(figBottomSheetAdapter);
        bottomSheetDialog.show();
    }

    public static void m23339l(GroupsInlineComposer groupsInlineComposer) {
        ComposerConfiguration.Builder a = ComposerConfiguration.a(groupsInlineComposer.getGroupComposerConfiguration());
        a.setDisableMentions(true);
        a.setPluginConfig(new DefaultPluginConfigSerializer().a(EmptyPluginConfig.a("GroupsPollComposerPluginConfig")));
        groupsInlineComposer.f22207a.a(null, a.a(), 1756, (Activity) ContextUtils.a(groupsInlineComposer.getContext(), Activity.class));
    }

    private void m23340n() {
        this.f22221p.setText(m23336d() ? 2131238047 : 2131238054);
        if (m23335c()) {
            this.f22226u.a();
            GlyphWithTextView glyphWithTextView = (GlyphWithTextView) a(2131562754);
            glyphWithTextView.setOnClickListener(this.f22231z);
            glyphWithTextView.setVisibility(0);
            glyphWithTextView.setImageScale(0.8f);
        }
    }

    public static void m23341o(GroupsInlineComposer groupsInlineComposer) {
        groupsInlineComposer.f22207a.a(null, groupsInlineComposer.getGroupComposerConfiguration(), 1756, (Activity) ContextUtils.a(groupsInlineComposer.getContext(), Activity.class));
    }

    public static void m23342p(GroupsInlineComposer groupsInlineComposer) {
        groupsInlineComposer.f22207a.a(null, GroupCommerceComposerHelper.a(GroupInformationInterfaceFactory.a(groupsInlineComposer.f22225t), groupsInlineComposer.f22215i).a(), 1756, (Activity) ContextUtils.a(groupsInlineComposer.getContext(), Activity.class));
    }
}
