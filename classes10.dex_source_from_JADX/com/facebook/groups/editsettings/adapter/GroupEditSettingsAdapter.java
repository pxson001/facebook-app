package com.facebook.groups.editsettings.adapter;

import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.facebook.common.i18n.BasicDateTimeFormat;
import com.facebook.common.uri.UriIntentMapper;
import com.facebook.common.util.TriState;
import com.facebook.content.SecureContextHelper;
import com.facebook.fbui.dialog.AlertDialog;
import com.facebook.fbui.dialog.AlertDialog.Builder;
import com.facebook.graphql.enums.GraphQLGroupJoinApprovalSetting;
import com.facebook.graphql.enums.GraphQLGroupPostPermissionSetting;
import com.facebook.graphql.enums.GraphQLGroupVisibility;
import com.facebook.groups.create.coverphoto.GroupsCoverPhotoHandler;
import com.facebook.groups.editsettings.GroupEditSettingsController;
import com.facebook.groups.editsettings.GroupEditSettingsIntentBuilder;
import com.facebook.groups.editsettings.fragment.GroupEditSettingsFragment.C31001;
import com.facebook.groups.editsettings.protocol.FetchGroupSettingsModels.FetchGroupSettingsModel;
import com.facebook.groups.editsettings.protocol.FetchGroupSettingsModels.FetchGroupSettingsModel.GroupConfigsModel.NodesModel;
import com.facebook.groups.editsettings.protocol.FetchGroupSettingsModels.FetchGroupSettingsModel.PossibleJoinApprovalSettingsModel;
import com.facebook.groups.editsettings.protocol.FetchGroupSettingsModels.FetchGroupSettingsModel.PossiblePostPermissionSettingsModel;
import com.facebook.groups.editsettings.protocol.FetchGroupSettingsModels.FetchGroupSettingsModel.PossibleVisibilitySettingsModel.EdgesModel;
import com.facebook.groups.editsettings.protocol.GroupPurposeFragmentModels.GroupPurposeModel;
import com.facebook.groups.editsettings.util.GroupPrivacyDescriptionUtil;
import com.facebook.groups.editsettings.view.DefaultEditSettingsViewManager;
import com.facebook.groups.editsettings.view.DefaultEditSettingsViewManager.C31062;
import com.facebook.groups.editsettings.view.DefaultEditSettingsViewManager.C31073;
import com.facebook.groups.editsettings.view.GroupEditSettingsViewManager;
import com.facebook.groups.staticadapter.StaticAdapter.AbstractSection;
import com.facebook.groups.staticadapter.StaticAdapter.Section;
import com.facebook.groups.staticadapter.StaticAdapter.ViewType;
import com.facebook.groups.widget.preferenceview.CheckablePreferenceView;
import com.facebook.groups.widget.preferenceview.GeneralPreferenceView;
import com.facebook.groups.widget.preferenceview.SwitchPreferenceView;
import com.facebook.groups.widget.preferenceview.delegates.SwitchPreferenceDelegate;
import com.facebook.inject.Assisted;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.resources.ui.FbTextView;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.tools.dextr.runtime.detour.AdapterDetour;
import com.facebook.widget.listview.FbBaseAdapter;
import com.facebook.widget.text.BetterTextView;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.RegularImmutableList;
import java.util.Date;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: Unexpected type from JSON */
public class GroupEditSettingsAdapter extends FbBaseAdapter {
    public GroupEditSettingsController f21586a;
    public Resources f21587b;
    public GroupEditSettingsIntentBuilder f21588c;
    public SecureContextHelper f21589d;
    public UriIntentMapper f21590e;
    private final BasicDateTimeFormat f21591f;
    public final GroupPrivacyDescriptionUtil f21592g;
    public final Provider<TriState> f21593h;
    public final DefaultEditSettingsViewManager f21594i;
    public FetchGroupSettingsModel f21595j;
    private ImmutableList<Section> f21596k = RegularImmutableList.a;
    public SwitchPreferenceDelegate f21597l;
    public SwitchPreferenceDelegate f21598m;
    public SwitchPreferenceDelegate f21599n;
    public OnClickListener f21600o;
    public OnClickListener f21601p;
    public C31001 f21602q;
    public AlertDialog f21603r;
    public AlertDialog f21604s;
    public String f21605t;
    public String f21606u;
    public boolean f21607v;
    public final C30731 f21608w = new C30731(this);

    /* compiled from: Unexpected type from JSON */
    public class AnonymousClass18 implements DialogInterface.OnClickListener {
        final /* synthetic */ BetterTextView f21568a;
        final /* synthetic */ ImmutableList f21569b;
        final /* synthetic */ View f21570c;
        final /* synthetic */ GroupEditSettingsAdapter f21571d;

        public AnonymousClass18(GroupEditSettingsAdapter groupEditSettingsAdapter, BetterTextView betterTextView, ImmutableList immutableList, View view) {
            this.f21571d = groupEditSettingsAdapter;
            this.f21568a = betterTextView;
            this.f21569b = immutableList;
            this.f21570c = view;
        }

        public void onClick(final DialogInterface dialogInterface, final int i) {
            if (this.f21571d.f21595j.m22805p() == null || this.f21571d.f21595j.m22805p().m22725a() < this.f21571d.f21595j.m22790A()) {
                this.f21568a.setText(((EdgesModel) this.f21569b.get(i)).m22777j());
                this.f21571d.f21586a.m22541a(this.f21571d.f21595j.m22807r(), ((EdgesModel) this.f21569b.get(i)).m22778k(), this.f21571d.f21595j.m22792C());
                dialogInterface.dismiss();
                return;
            }
            DialogInterface.OnClickListener c30721 = new DialogInterface.OnClickListener(this) {
                final /* synthetic */ AnonymousClass18 f21567c;

                public void onClick(DialogInterface dialogInterface, int i) {
                    this.f21567c.f21568a.setText(((EdgesModel) this.f21567c.f21569b.get(i)).m22777j());
                    this.f21567c.f21571d.f21586a.m22541a(this.f21567c.f21571d.f21595j.m22807r(), ((EdgesModel) this.f21567c.f21569b.get(i)).m22778k(), this.f21567c.f21571d.f21595j.m22792C());
                    dialogInterface.dismiss();
                }
            };
            GroupEditSettingsAdapter groupEditSettingsAdapter = this.f21571d;
            View view = this.f21570c;
            Builder builder = new Builder(view.getContext());
            builder.a(groupEditSettingsAdapter.f21587b.getString(2131242152));
            builder.a(2131230729, c30721);
            builder.b(2131230727, new DialogInterface.OnClickListener(groupEditSettingsAdapter) {
                final /* synthetic */ GroupEditSettingsAdapter f21563a;

                {
                    this.f21563a = r1;
                }

                public void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.cancel();
                    this.f21563a.f21604s.cancel();
                }
            });
            Context context = view.getContext();
            String string = groupEditSettingsAdapter.f21587b.getString(2131242154, new Object[]{groupEditSettingsAdapter.f21595j.m22809t()});
            ClickableSpan anonymousClass15 = new ClickableSpan(groupEditSettingsAdapter) {
                final /* synthetic */ GroupEditSettingsAdapter f21562a;

                {
                    this.f21562a = r1;
                }

                public void onClick(View view) {
                    this.f21562a.f21603r.cancel();
                    this.f21562a.f21604s.cancel();
                    this.f21562a.f21589d.a(this.f21562a.f21590e.a(view.getContext(), "https://m.facebook.com/help/286027304749263"), view.getContext());
                }

                public void updateDrawState(TextPaint textPaint) {
                    super.updateDrawState(textPaint);
                    textPaint.setUnderlineText(false);
                }
            };
            FbTextView fbTextView = new FbTextView(context);
            fbTextView.setText(groupEditSettingsAdapter.f21592g.m22876a(string, anonymousClass15));
            fbTextView.setMovementMethod(LinkMovementMethod.getInstance());
            builder.b(fbTextView);
            groupEditSettingsAdapter.f21603r = builder.a();
            groupEditSettingsAdapter.f21603r.show();
        }
    }

    /* compiled from: Unexpected type from JSON */
    public /* synthetic */ class AnonymousClass19 {
        public static final /* synthetic */ int[] f21572a = new int[GraphQLGroupJoinApprovalSetting.values().length];
        public static final /* synthetic */ int[] f21573b = new int[GraphQLGroupPostPermissionSetting.values().length];

        static {
            try {
                f21573b[GraphQLGroupPostPermissionSetting.ADMIN_ONLY.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f21573b[GraphQLGroupPostPermissionSetting.ANYONE.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f21573b[GraphQLGroupPostPermissionSetting.NONE.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f21572a[GraphQLGroupJoinApprovalSetting.ADMIN_ONLY.ordinal()] = 1;
            } catch (NoSuchFieldError e4) {
            }
            try {
                f21572a[GraphQLGroupJoinApprovalSetting.ANYONE.ordinal()] = 2;
            } catch (NoSuchFieldError e5) {
            }
            try {
                f21572a[GraphQLGroupJoinApprovalSetting.NONE.ordinal()] = 3;
            } catch (NoSuchFieldError e6) {
            }
        }
    }

    /* compiled from: Unexpected type from JSON */
    public class C30731 {
        public final /* synthetic */ GroupEditSettingsAdapter f21574a;

        C30731(GroupEditSettingsAdapter groupEditSettingsAdapter) {
            this.f21574a = groupEditSettingsAdapter;
        }
    }

    /* compiled from: Unexpected type from JSON */
    public class C30742 implements SwitchPreferenceDelegate {
        final /* synthetic */ GroupEditSettingsAdapter f21575a;

        public C30742(GroupEditSettingsAdapter groupEditSettingsAdapter) {
            this.f21575a = groupEditSettingsAdapter;
        }

        public final String m22562a() {
            if (this.f21575a.f21607v) {
                return this.f21575a.f21587b.getString(2131242132);
            }
            return this.f21575a.f21587b.getString(2131242131);
        }

        public final boolean m22564b() {
            return this.f21575a.f21595j.m22808s().ordinal() == GraphQLGroupJoinApprovalSetting.ADMIN_ONLY.ordinal();
        }

        public final void m22563a(boolean z) {
            GraphQLGroupJoinApprovalSetting graphQLGroupJoinApprovalSetting;
            GroupEditSettingsController groupEditSettingsController = this.f21575a.f21586a;
            String r = this.f21575a.f21595j.m22807r();
            if (z) {
                graphQLGroupJoinApprovalSetting = GraphQLGroupJoinApprovalSetting.ADMIN_ONLY;
            } else {
                GraphQLGroupJoinApprovalSetting a;
                ImmutableList j = this.f21575a.f21595j.m22811v().m22757j();
                int size = j.size();
                for (int i = 0; i < size; i++) {
                    a = ((PossibleJoinApprovalSettingsModel.EdgesModel) j.get(i)).m22750a();
                    if (a != GraphQLGroupJoinApprovalSetting.ADMIN_ONLY) {
                        break;
                    }
                }
                a = GraphQLGroupJoinApprovalSetting.UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
                graphQLGroupJoinApprovalSetting = a;
            }
            groupEditSettingsController.m22538a(r, graphQLGroupJoinApprovalSetting, this.f21575a.f21595j.m22808s());
        }
    }

    /* compiled from: Unexpected type from JSON */
    public class C30753 implements SwitchPreferenceDelegate {
        final /* synthetic */ GroupEditSettingsAdapter f21576a;

        public C30753(GroupEditSettingsAdapter groupEditSettingsAdapter) {
            this.f21576a = groupEditSettingsAdapter;
        }

        public final String m22565a() {
            return this.f21576a.f21587b.getString(2131242136);
        }

        public final boolean m22567b() {
            return this.f21576a.f21595j.m22814y().ordinal() == GraphQLGroupPostPermissionSetting.ADMIN_ONLY.ordinal();
        }

        public final void m22566a(boolean z) {
            GraphQLGroupPostPermissionSetting graphQLGroupPostPermissionSetting;
            GroupEditSettingsController groupEditSettingsController = this.f21576a.f21586a;
            String r = this.f21576a.f21595j.m22807r();
            if (z) {
                graphQLGroupPostPermissionSetting = GraphQLGroupPostPermissionSetting.ADMIN_ONLY;
            } else {
                GraphQLGroupPostPermissionSetting a;
                ImmutableList j = this.f21576a.f21595j.m22812w().m22770j();
                int size = j.size();
                for (int i = 0; i < size; i++) {
                    a = ((PossiblePostPermissionSettingsModel.EdgesModel) j.get(i)).m22763a();
                    if (a != GraphQLGroupPostPermissionSetting.ADMIN_ONLY) {
                        break;
                    }
                }
                a = GraphQLGroupPostPermissionSetting.UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
                graphQLGroupPostPermissionSetting = a;
            }
            groupEditSettingsController.m22539a(r, graphQLGroupPostPermissionSetting, this.f21576a.f21595j.m22814y());
        }
    }

    /* compiled from: Unexpected type from JSON */
    public class C30764 implements SwitchPreferenceDelegate {
        final /* synthetic */ GroupEditSettingsAdapter f21577a;

        public C30764(GroupEditSettingsAdapter groupEditSettingsAdapter) {
            this.f21577a = groupEditSettingsAdapter;
        }

        public final String m22568a() {
            if (this.f21577a.f21607v) {
                return this.f21577a.f21587b.getString(2131242138);
            }
            return this.f21577a.f21587b.getString(2131242137);
        }

        public final boolean m22570b() {
            return this.f21577a.f21595j.m22791B();
        }

        public final void m22569a(boolean z) {
            this.f21577a.f21586a.m22543a(this.f21577a.f21595j.m22807r(), z, this.f21577a.f21595j.m22791B());
        }
    }

    /* compiled from: Unexpected type from JSON */
    public class C30775 implements OnClickListener {
        final /* synthetic */ GroupEditSettingsAdapter f21578a;

        public C30775(GroupEditSettingsAdapter groupEditSettingsAdapter) {
            this.f21578a = groupEditSettingsAdapter;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 16302802);
            String str = ((CheckablePreferenceView) view).d;
            if (!str.equals(this.f21578a.f21605t)) {
                this.f21578a.f21605t = str;
                this.f21578a.f21586a.m22539a(this.f21578a.f21595j.m22807r(), GraphQLGroupPostPermissionSetting.fromString(this.f21578a.f21605t), this.f21578a.f21595j.m22814y());
            }
            Logger.a(2, EntryType.UI_INPUT_END, 164011902, a);
        }
    }

    /* compiled from: Unexpected type from JSON */
    public class C30786 implements OnClickListener {
        final /* synthetic */ GroupEditSettingsAdapter f21579a;

        public C30786(GroupEditSettingsAdapter groupEditSettingsAdapter) {
            this.f21579a = groupEditSettingsAdapter;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 1171552874);
            String str = ((CheckablePreferenceView) view).d;
            if (!str.equals(this.f21579a.f21606u)) {
                this.f21579a.f21606u = str;
                this.f21579a.f21586a.m22538a(this.f21579a.f21595j.m22807r(), GraphQLGroupJoinApprovalSetting.fromString(this.f21579a.f21606u), this.f21579a.f21595j.m22808s());
            }
            Logger.a(2, EntryType.UI_INPUT_END, -2055642656, a);
        }
    }

    private void m22579e() {
        this.f21596k = RegularImmutableList.a;
        ImmutableList.Builder builder = ImmutableList.builder();
        m22573a(builder);
        m22575b(builder);
        m22577c(builder);
        m22578d(builder);
        this.f21596k = builder.b();
        AdapterDetour.a(this, 361504463);
    }

    @Inject
    public GroupEditSettingsAdapter(@Assisted GroupEditPrivacyRequestListener groupEditPrivacyRequestListener, GroupEditSettingsController groupEditSettingsController, Resources resources, GroupEditSettingsIntentBuilder groupEditSettingsIntentBuilder, SecureContextHelper secureContextHelper, UriIntentMapper uriIntentMapper, BasicDateTimeFormat basicDateTimeFormat, GroupPrivacyDescriptionUtil groupPrivacyDescriptionUtil, Provider<TriState> provider, GroupEditSettingsViewManager groupEditSettingsViewManager) {
        this.f21602q = groupEditPrivacyRequestListener;
        this.f21586a = groupEditSettingsController;
        this.f21587b = resources;
        this.f21588c = groupEditSettingsIntentBuilder;
        this.f21589d = secureContextHelper;
        this.f21590e = uriIntentMapper;
        this.f21591f = basicDateTimeFormat;
        this.f21592g = groupPrivacyDescriptionUtil;
        this.f21593h = provider;
        this.f21594i = groupEditSettingsViewManager;
        this.f21597l = new C30742(this);
        this.f21598m = new C30753(this);
        this.f21599n = new C30764(this);
        this.f21600o = new C30775(this);
        this.f21601p = new C30786(this);
    }

    public static void m22576c(GroupEditSettingsAdapter groupEditSettingsAdapter, FetchGroupSettingsModel fetchGroupSettingsModel) {
        boolean z;
        groupEditSettingsAdapter.f21595j = fetchGroupSettingsModel;
        groupEditSettingsAdapter.f21606u = groupEditSettingsAdapter.f21595j.m22808s().toString();
        groupEditSettingsAdapter.f21605t = groupEditSettingsAdapter.f21595j.m22814y().toString();
        FetchGroupSettingsModel fetchGroupSettingsModel2 = groupEditSettingsAdapter.f21595j;
        if (fetchGroupSettingsModel2 == null || fetchGroupSettingsModel2.m22804o() == null || fetchGroupSettingsModel2.m22804o().m22722a() == null || fetchGroupSettingsModel2.m22804o().m22722a().isEmpty() || fetchGroupSettingsModel2.m22804o().m22722a().get(0) == null || !((NodesModel) fetchGroupSettingsModel2.m22804o().m22722a().get(0)).m22718a()) {
            z = false;
        } else {
            z = true;
        }
        groupEditSettingsAdapter.f21607v = z;
        groupEditSettingsAdapter.m22579e();
    }

    private void m22573a(ImmutableList.Builder<Section> builder) {
        String j;
        m22574a((ImmutableList.Builder) builder, 0);
        builder.c(new AbstractSection<GeneralPreferenceView>(this, GroupEditSettingsAdapterRows.f21613e) {
            final /* synthetic */ GroupEditSettingsAdapter f21581a;

            /* compiled from: Unexpected type from JSON */
            class C30791 implements OnClickListener {
                final /* synthetic */ C30807 f21580a;

                C30791(C30807 c30807) {
                    this.f21580a = c30807;
                }

                public void onClick(View view) {
                    int a = Logger.a(2, EntryType.UI_INPUT_START, 1678138374);
                    this.f21580a.f21581a.f21589d.a(this.f21580a.f21581a.f21588c.m22547a(this.f21580a.f21581a.f21595j), view.getContext());
                    Logger.a(2, EntryType.UI_INPUT_END, 2096504377, a);
                }
            }

            public final void mo11a(View view) {
                GeneralPreferenceView generalPreferenceView = (GeneralPreferenceView) view;
                generalPreferenceView.a(this.f21581a.f21587b.getString(2131242119));
                generalPreferenceView.setOnClickListener(new C30791(this));
            }
        });
        m22582f(builder);
        builder.c(new AbstractSection<GeneralPreferenceView>(this, GroupEditSettingsAdapterRows.f21613e) {
            final /* synthetic */ GroupEditSettingsAdapter f21583a;

            /* compiled from: Unexpected type from JSON */
            class C30811 implements OnClickListener {
                final /* synthetic */ C30828 f21582a;

                C30811(C30828 c30828) {
                    this.f21582a = c30828;
                }

                public void onClick(View view) {
                    int a = Logger.a(2, EntryType.UI_INPUT_START, -715456718);
                    ((GroupsCoverPhotoHandler) this.f21582a.f21583a.f21594i.f21783b.get()).a(view.getContext(), 1964);
                    Logger.a(2, EntryType.UI_INPUT_END, 1746422647, a);
                }
            }

            public final void mo11a(View view) {
                GeneralPreferenceView generalPreferenceView = (GeneralPreferenceView) view;
                if (this.f21583a.f21595j.m22801l() != null) {
                    generalPreferenceView.a(this.f21583a.f21587b.getString(2131242128));
                } else {
                    generalPreferenceView.a(this.f21583a.f21587b.getString(2131242129));
                }
                generalPreferenceView.setOnClickListener(new C30811(this));
            }
        });
        m22582f(builder);
        final ImmutableList a = this.f21595j.m22813x().m22782a();
        OnClickListener c30839 = new OnClickListener(this) {
            final /* synthetic */ GroupEditSettingsAdapter f21585b;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, 888176724);
                if (this.f21585b.f21593h.get() != TriState.YES) {
                    GroupEditSettingsAdapter groupEditSettingsAdapter = this.f21585b;
                    ImmutableList immutableList = a;
                    BetterTextView betterTextView = (BetterTextView) view.findViewById(2131562714);
                    CharSequence[] charSequenceArr = new String[immutableList.size()];
                    GraphQLGroupVisibility C = groupEditSettingsAdapter.f21595j.m22792C();
                    int i = 0;
                    for (int i2 = 0; i2 < immutableList.size(); i2++) {
                        if (((EdgesModel) immutableList.get(i2)).m22778k() == C) {
                            i = i2;
                        }
                        charSequenceArr[i2] = ((EdgesModel) immutableList.get(i2)).m22777j();
                    }
                    Builder builder = new Builder(view.getContext());
                    builder.a(groupEditSettingsAdapter.f21587b.getString(2131242130)).a(charSequenceArr, i, new AnonymousClass18(groupEditSettingsAdapter, betterTextView, immutableList, view)).b(2131230727, new DialogInterface.OnClickListener(groupEditSettingsAdapter) {
                        final /* synthetic */ GroupEditSettingsAdapter f21564a;

                        {
                            this.f21564a = r1;
                        }

                        public void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.cancel();
                        }
                    });
                    groupEditSettingsAdapter.f21604s = builder.a();
                    groupEditSettingsAdapter.f21604s.show();
                } else {
                    C31001 c31001 = this.f21585b.f21602q;
                    c31001.f21654a.f21659c.a(c31001.f21654a.f21658b.m22549c(c31001.f21654a.al), c31001.f21654a.getContext());
                }
                LogUtils.a(-834846646, a);
            }
        };
        DefaultEditSettingsViewManager defaultEditSettingsViewManager = this.f21594i;
        GraphQLGroupVisibility C = this.f21595j.m22792C();
        int size = a.size();
        for (int i = 0; i < size; i++) {
            EdgesModel edgesModel = (EdgesModel) a.get(i);
            if (C == edgesModel.m22778k()) {
                j = edgesModel.m22777j();
                break;
            }
        }
        j = "";
        a = defaultEditSettingsViewManager.m22886a(j, m22581f(), c30839);
        if (a != null) {
            builder.b(a);
        }
    }

    private CharSequence m22581f() {
        String str = null;
        if (this.f21593h.get() != TriState.YES || this.f21595j.m22805p() == null || this.f21595j.m22792C() == null || this.f21595j.m22792C() == GraphQLGroupVisibility.UNSET_OR_UNRECOGNIZED_ENUM_VALUE || GroupPrivacyDescriptionUtil.m22874b(this.f21595j)) {
            return null;
        }
        if (this.f21595j.m22805p().m22725a() < this.f21595j.m22790A()) {
            str = this.f21587b.getString(2131242162, new Object[]{Integer.valueOf(this.f21595j.m22790A())});
        } else if (!this.f21592g.m22878a(this.f21595j)) {
            str = this.f21587b.getString(2131242164, new Object[]{Integer.valueOf(this.f21595j.m22790A())});
        } else if (this.f21592g.m22878a(this.f21595j) && this.f21595j.m22792C() != GraphQLGroupVisibility.OPEN) {
            Date date = new Date(this.f21595j.m22803n() * 1000);
            str = this.f21587b.getString(2131242163, new Object[]{this.f21592g.m22877a(this.f21595j, this.f21595j.m22792C()), this.f21591f.a().format(date), this.f21591f.g().format(date)});
        }
        if (str != null) {
            return this.f21592g.m22875a(str);
        }
        return str;
    }

    private void m22575b(ImmutableList.Builder<Section> builder) {
        String str;
        String str2 = null;
        m22574a((ImmutableList.Builder) builder, 1);
        m22580e(builder);
        if (this.f21595j.m22806q() == null || this.f21595j.m22806q().m22733a() == null || this.f21595j.m22806q().m22733a().isEmpty()) {
            str = null;
        } else {
            GroupPurposeModel groupPurposeModel = (GroupPurposeModel) this.f21595j.m22806q().m22733a().get(0);
            if (groupPurposeModel.m22860a() != null) {
                str2 = groupPurposeModel.m22860a().b();
            }
            String b = groupPurposeModel.m22862b();
            str = str2;
            str2 = b;
        }
        DefaultEditSettingsViewManager defaultEditSettingsViewManager = this.f21594i;
        AnonymousClass10 anonymousClass10 = new OnClickListener(this) {
            final /* synthetic */ GroupEditSettingsAdapter f21555a;

            {
                this.f21555a = r1;
            }

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, -1541345061);
                this.f21555a.f21589d.a(this.f21555a.f21588c.m22548b(this.f21555a.f21595j), view.getContext());
                Logger.a(2, EntryType.UI_INPUT_END, -1945545783, a);
            }
        };
        ImmutableList.Builder builder2 = ImmutableList.builder();
        builder2.c(new C31062(defaultEditSettingsViewManager, GroupEditSettingsAdapterRows.f21615g, str, str2, anonymousClass10));
        builder.b(builder2.b());
    }

    private void m22577c(ImmutableList.Builder<Section> builder) {
        m22574a((ImmutableList.Builder) builder, 2);
        m22580e(builder);
        if (this.f21595j.m22811v().m22753a() <= 2) {
            String string = this.f21595j.m22808s() == GraphQLGroupJoinApprovalSetting.ADMIN_ONLY ? this.f21607v ? this.f21587b.getString(2131242135) : this.f21587b.getString(2131242134) : this.f21587b.getString(2131242133);
            DefaultEditSettingsViewManager defaultEditSettingsViewManager = this.f21594i;
            SwitchPreferenceDelegate switchPreferenceDelegate = this.f21597l;
            ImmutableList.Builder builder2 = ImmutableList.builder();
            builder2.c(new C31073(defaultEditSettingsViewManager, GroupEditSettingsAdapterRows.f21611c, switchPreferenceDelegate, string));
            Iterable b = builder2.b();
            if (b != null) {
                builder.b(b);
                return;
            }
            return;
        }
        ImmutableList j = this.f21595j.m22811v().m22757j();
        int size = j.size();
        for (int i = 0; i < j.size(); i++) {
            final PossibleJoinApprovalSettingsModel.EdgesModel edgesModel = (PossibleJoinApprovalSettingsModel.EdgesModel) j.get(i);
            builder.c(new AbstractSection<CheckablePreferenceView>(this, GroupEditSettingsAdapterRows.f21612d) {
                final /* synthetic */ GroupEditSettingsAdapter f21557b;

                public final void mo11a(View view) {
                    String string;
                    CheckablePreferenceView checkablePreferenceView = (CheckablePreferenceView) view;
                    GroupEditSettingsAdapter groupEditSettingsAdapter = this.f21557b;
                    GraphQLGroupJoinApprovalSetting a = edgesModel.m22750a();
                    String k = this.f21557b.f21595j.m22810u().m22744k();
                    switch (AnonymousClass19.f21572a[a.ordinal()]) {
                        case 1:
                            string = groupEditSettingsAdapter.f21587b.getString(2131242150);
                            break;
                        case 2:
                            string = groupEditSettingsAdapter.f21587b.getString(2131242148, new Object[]{k});
                            break;
                        case 3:
                            string = groupEditSettingsAdapter.f21587b.getString(2131242149);
                            break;
                        default:
                            string = "";
                            break;
                    }
                    checkablePreferenceView.a(string, null, edgesModel.m22750a().toString().equals(this.f21557b.f21606u), edgesModel.m22750a().toString());
                    checkablePreferenceView.setOnClickListener(this.f21557b.f21601p);
                }
            });
            if (i != size - 1) {
                m22582f(builder);
            }
        }
        m22580e(builder);
    }

    private void m22578d(ImmutableList.Builder<Section> builder) {
        m22574a((ImmutableList.Builder) builder, 3);
        if (this.f21595j.m22812w().m22766a() <= 2) {
            builder.c(new AbstractSection<SwitchPreferenceView>(this, GroupEditSettingsAdapterRows.f21610b) {
                final /* synthetic */ GroupEditSettingsAdapter f21558a;

                public final void mo11a(View view) {
                    ((SwitchPreferenceView) view).setDelegate(this.f21558a.f21598m);
                }
            });
        } else {
            ImmutableList j = this.f21595j.m22812w().m22770j();
            int size = j.size();
            for (int i = 0; i < j.size(); i++) {
                final PossiblePostPermissionSettingsModel.EdgesModel edgesModel = (PossiblePostPermissionSettingsModel.EdgesModel) j.get(i);
                builder.c(new AbstractSection<CheckablePreferenceView>(this, GroupEditSettingsAdapterRows.f21612d) {
                    final /* synthetic */ GroupEditSettingsAdapter f21560b;

                    public final void mo11a(View view) {
                        String string;
                        CheckablePreferenceView checkablePreferenceView = (CheckablePreferenceView) view;
                        GroupEditSettingsAdapter groupEditSettingsAdapter = this.f21560b;
                        GraphQLGroupPostPermissionSetting a = edgesModel.m22763a();
                        String k = this.f21560b.f21595j.m22810u().m22744k();
                        switch (AnonymousClass19.f21573b[a.ordinal()]) {
                            case 1:
                                string = groupEditSettingsAdapter.f21587b.getString(2131242146);
                                break;
                            case 2:
                                string = groupEditSettingsAdapter.f21587b.getString(2131242147, new Object[]{k});
                                break;
                            case 3:
                                string = groupEditSettingsAdapter.f21587b.getString(2131242145);
                                break;
                            default:
                                string = "";
                                break;
                        }
                        checkablePreferenceView.a(string, null, edgesModel.m22763a().toString().equals(this.f21560b.f21605t), edgesModel.m22763a().toString());
                        checkablePreferenceView.setOnClickListener(this.f21560b.f21600o);
                    }
                });
                if (i != size - 1) {
                    m22582f(builder);
                }
            }
            m22580e(builder);
        }
        m22580e(builder);
        builder.c(new AbstractSection<SwitchPreferenceView>(this, GroupEditSettingsAdapterRows.f21610b) {
            final /* synthetic */ GroupEditSettingsAdapter f21561a;

            public final void mo11a(View view) {
                ((SwitchPreferenceView) view).setDelegate(this.f21561a.f21599n);
            }
        });
        m22580e(builder);
    }

    private void m22580e(ImmutableList.Builder<Section> builder) {
        DefaultEditSettingsViewManager defaultEditSettingsViewManager = this.f21594i;
        Object obj = null;
        if (obj != null) {
            builder.c(obj);
        }
    }

    private void m22582f(ImmutableList.Builder<Section> builder) {
        DefaultEditSettingsViewManager defaultEditSettingsViewManager = this.f21594i;
        Object obj = null;
        if (obj != null) {
            builder.c(obj);
        }
    }

    private void m22574a(ImmutableList.Builder<Section> builder, int i) {
        ImmutableList a = this.f21594i.m22885a(i);
        if (a != null) {
            builder.b(a);
        }
    }

    public final void m22584a(int i, Object obj, View view, int i2, ViewGroup viewGroup) {
        ((Section) obj).mo11a(view);
    }

    public int getItemViewType(int i) {
        DefaultEditSettingsViewManager defaultEditSettingsViewManager = this.f21594i;
        return GroupEditSettingsAdapterRows.f21617i.indexOf(((Section) this.f21596k.get(i)).mo10a());
    }

    public int getViewTypeCount() {
        DefaultEditSettingsViewManager defaultEditSettingsViewManager = this.f21594i;
        return GroupEditSettingsAdapterRows.f21617i.size();
    }

    public final View m22583a(int i, ViewGroup viewGroup) {
        DefaultEditSettingsViewManager defaultEditSettingsViewManager = this.f21594i;
        return ((ViewType) GroupEditSettingsAdapterRows.f21617i.get(i)).mo12a(viewGroup);
    }

    public int getCount() {
        return this.f21596k.size();
    }

    public Object getItem(int i) {
        return this.f21596k.get(i);
    }

    public long getItemId(int i) {
        return (long) i;
    }
}
