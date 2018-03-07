package com.facebook.groups.settings;

import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.facebook.graphql.calls.GraphQlCallInput;
import com.facebook.graphql.calls.GroupUpdatePushSubscriptionLevelInputData;
import com.facebook.graphql.calls.GroupUpdateRequestToJoinSubscriptionLevelInputData;
import com.facebook.graphql.calls.GroupUpdateRequestToJoinSubscriptionLevelInputData.Setting;
import com.facebook.graphql.enums.GraphQLGroupAdminType;
import com.facebook.graphql.enums.GraphQLGroupPushSubscriptionLevel;
import com.facebook.graphql.enums.GraphQLGroupRequestToJoinSubscriptionLevel;
import com.facebook.graphql.enums.GraphQLGroupSubscriptionLevel;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.groups.settings.AbstractGroupSubscriptionController.C33322;
import com.facebook.groups.settings.AbstractGroupSubscriptionController.C33333;
import com.facebook.groups.settings.protocol.SettingMutations.GroupUpdatePushSubscriptionMutationString;
import com.facebook.groups.settings.protocol.SettingMutations.GroupUpdateRequestToJoinSubscriptionMutationString;
import com.facebook.groups.staticadapter.StaticAdapter.AbstractSection;
import com.facebook.groups.staticadapter.StaticAdapter.Section;
import com.facebook.groups.staticadapter.StaticAdapter.StaticSection;
import com.facebook.groups.staticadapter.StaticAdapter.ViewType;
import com.facebook.groups.widget.groupsettingsrow.protocol.GroupSettingsRowDataInterfaces.GroupSubscriptionData;
import com.facebook.groups.widget.groupsettingsrow.protocol.GroupSettingsRowDataInterfaces.GroupSubscriptionData.PossiblePushSubscriptionLevels;
import com.facebook.groups.widget.groupsettingsrow.protocol.GroupSettingsRowDataInterfaces.GroupSubscriptionData.PossibleSubscriptionLevels.Edges;
import com.facebook.groups.widget.groupsettingsrow.protocol.GroupSettingsRowDataModels.GroupSubscriptionDataModel.PossiblePushSubscriptionLevelsModel;
import com.facebook.groups.widget.groupsettingsrow.protocol.GroupSettingsRowDataModels.GroupSubscriptionDataModel.PossibleSubscriptionLevelsModel.EdgesModel;
import com.facebook.groups.widget.preferencecategoryheading.PreferenceCategoryHeadingView;
import com.facebook.groups.widget.preferenceview.CheckablePreferenceView;
import com.facebook.groups.widget.preferenceview.SwitchWithDescriptionView;
import com.facebook.groups.widget.preferenceview.delegates.SwitchPreferenceDelegate;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.tools.dextr.runtime.detour.AdapterDetour;
import com.facebook.widget.listview.FbBaseAdapter;
import com.facebook.widget.text.BetterTextView;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.collect.RegularImmutableList;
import com.google.common.util.concurrent.Futures;
import javax.inject.Inject;

/* compiled from: TIMER */
public class GroupSubscriptionAdapter extends FbBaseAdapter {
    public Resources f23139a;
    public AbstractGroupSubscriptionController f23140b;
    public OnClickListener f23141c;
    public OnClickListener f23142d;
    public SwitchPreferenceDelegate f23143e;
    private ImmutableList<Section> f23144f = RegularImmutableList.a;
    public String f23145g;
    private GraphQLGroupPushSubscriptionLevel f23146h = GraphQLGroupPushSubscriptionLevel.UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
    public String f23147i;
    public GraphQLGroupRequestToJoinSubscriptionLevel f23148j;
    public GraphQLGroupAdminType f23149k;
    public ImmutableList<? extends Edges> f23150l;
    public ImmutableList<? extends PossiblePushSubscriptionLevels.Edges> f23151m;
    public GroupSubscriptionData f23152n;
    public String f23153o;
    private final GroupSubscriptionController$GroupSubscriptionChangeListener f23154p = new C33341(this);

    /* compiled from: TIMER */
    /* synthetic */ class AnonymousClass12 {
        static final /* synthetic */ int[] f23126a = new int[GraphQLGroupSubscriptionLevel.values().length];
        static final /* synthetic */ int[] f23127b = new int[GraphQLGroupPushSubscriptionLevel.values().length];

        static {
            try {
                f23127b[GraphQLGroupPushSubscriptionLevel.ON.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f23127b[GraphQLGroupPushSubscriptionLevel.HIGHLIGHTS.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f23127b[GraphQLGroupPushSubscriptionLevel.OFF.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f23126a[GraphQLGroupSubscriptionLevel.ALL_POSTS.ordinal()] = 1;
            } catch (NoSuchFieldError e4) {
            }
            try {
                f23126a[GraphQLGroupSubscriptionLevel.HIGHLIGHTS.ordinal()] = 2;
            } catch (NoSuchFieldError e5) {
            }
            try {
                f23126a[GraphQLGroupSubscriptionLevel.FRIEND_POSTS.ordinal()] = 3;
            } catch (NoSuchFieldError e6) {
            }
            try {
                f23126a[GraphQLGroupSubscriptionLevel.OFF.ordinal()] = 4;
            } catch (NoSuchFieldError e7) {
            }
        }
    }

    /* compiled from: TIMER */
    class C33341 implements GroupSubscriptionController$GroupSubscriptionChangeListener {
        final /* synthetic */ GroupSubscriptionAdapter f23128a;

        C33341(GroupSubscriptionAdapter groupSubscriptionAdapter) {
            this.f23128a = groupSubscriptionAdapter;
        }

        public final void mo992a(GraphQLGroupSubscriptionLevel graphQLGroupSubscriptionLevel) {
            this.f23128a.f23145g = graphQLGroupSubscriptionLevel.toString();
            GroupSubscriptionAdapter.m24440c(this.f23128a);
        }

        public final void mo990a(GraphQLGroupPushSubscriptionLevel graphQLGroupPushSubscriptionLevel) {
            this.f23128a.f23147i = graphQLGroupPushSubscriptionLevel.toString();
            GroupSubscriptionAdapter.m24440c(this.f23128a);
        }

        public final void mo991a(GraphQLGroupRequestToJoinSubscriptionLevel graphQLGroupRequestToJoinSubscriptionLevel) {
            this.f23128a.f23148j = graphQLGroupRequestToJoinSubscriptionLevel;
            GroupSubscriptionAdapter.m24440c(this.f23128a);
        }
    }

    /* compiled from: TIMER */
    public class C33352 implements SwitchPreferenceDelegate {
        final /* synthetic */ GroupSubscriptionAdapter f23129a;

        public C33352(GroupSubscriptionAdapter groupSubscriptionAdapter) {
            this.f23129a = groupSubscriptionAdapter;
        }

        public final String m24430a() {
            return this.f23129a.f23139a.getString(2131237903);
        }

        public final boolean m24432b() {
            return this.f23129a.f23148j == GraphQLGroupRequestToJoinSubscriptionLevel.ON;
        }

        public final void m24431a(boolean z) {
            GraphQLGroupRequestToJoinSubscriptionLevel graphQLGroupRequestToJoinSubscriptionLevel;
            GroupSubscriptionAdapter groupSubscriptionAdapter = this.f23129a;
            if (z) {
                graphQLGroupRequestToJoinSubscriptionLevel = GraphQLGroupRequestToJoinSubscriptionLevel.ON;
            } else {
                graphQLGroupRequestToJoinSubscriptionLevel = GraphQLGroupRequestToJoinSubscriptionLevel.OFF;
            }
            groupSubscriptionAdapter.f23148j = graphQLGroupRequestToJoinSubscriptionLevel;
            GroupSubscriptionAdapter.m24440c(this.f23129a);
            AbstractGroupSubscriptionController abstractGroupSubscriptionController = this.f23129a.f23140b;
            String str = this.f23129a.f23153o;
            GraphQLGroupRequestToJoinSubscriptionLevel g = this.f23129a.f23152n.g();
            GraphQLGroupRequestToJoinSubscriptionLevel graphQLGroupRequestToJoinSubscriptionLevel2 = this.f23129a.f23148j;
            if (abstractGroupSubscriptionController.f23122h != null) {
                abstractGroupSubscriptionController.f23122h.mo991a(graphQLGroupRequestToJoinSubscriptionLevel2);
            }
            GroupUpdateRequestToJoinSubscriptionLevelInputData groupUpdateRequestToJoinSubscriptionLevelInputData = new GroupUpdateRequestToJoinSubscriptionLevelInputData();
            groupUpdateRequestToJoinSubscriptionLevelInputData.a("group_id", str);
            GraphQlCallInput graphQlCallInput = groupUpdateRequestToJoinSubscriptionLevelInputData;
            graphQlCallInput.a("setting", (Setting) AbstractGroupSubscriptionController.f23117c.get(graphQLGroupRequestToJoinSubscriptionLevel2));
            GraphQlCallInput graphQlCallInput2 = graphQlCallInput;
            graphQlCallInput2.a("actor_id", abstractGroupSubscriptionController.f23121g);
            Futures.a(abstractGroupSubscriptionController.f23120f.a(GraphQLRequest.a((GroupUpdateRequestToJoinSubscriptionMutationString) new GroupUpdateRequestToJoinSubscriptionMutationString().a("input", graphQlCallInput2))), new C33333(abstractGroupSubscriptionController, g), abstractGroupSubscriptionController.f23119e);
        }
    }

    /* compiled from: TIMER */
    public class C33363 implements OnClickListener {
        final /* synthetic */ GroupSubscriptionAdapter f23130a;

        public C33363(GroupSubscriptionAdapter groupSubscriptionAdapter) {
            this.f23130a = groupSubscriptionAdapter;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 1717023224);
            String str = ((CheckablePreferenceView) view).d;
            if (!str.equals(this.f23130a.f23145g)) {
                this.f23130a.f23145g = str;
                GroupSubscriptionAdapter.m24439b(this.f23130a);
                GroupSubscriptionAdapter.m24440c(this.f23130a);
                this.f23130a.f23140b.m24423a(this.f23130a.f23153o, this.f23130a.f23152n.hd_(), GraphQLGroupSubscriptionLevel.fromString(this.f23130a.f23145g));
            }
            Logger.a(2, EntryType.UI_INPUT_END, -1241093827, a);
        }
    }

    /* compiled from: TIMER */
    public class C33374 implements OnClickListener {
        final /* synthetic */ GroupSubscriptionAdapter f23131a;

        public C33374(GroupSubscriptionAdapter groupSubscriptionAdapter) {
            this.f23131a = groupSubscriptionAdapter;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 174120120);
            String str = ((CheckablePreferenceView) view).d;
            if (!str.equals(this.f23131a.f23147i)) {
                this.f23131a.f23147i = str;
                GroupSubscriptionAdapter.m24440c(this.f23131a);
                AbstractGroupSubscriptionController abstractGroupSubscriptionController = this.f23131a.f23140b;
                String str2 = this.f23131a.f23153o;
                GraphQLGroupPushSubscriptionLevel hc_ = this.f23131a.f23152n.hc_();
                GraphQLGroupPushSubscriptionLevel valueOf = GraphQLGroupPushSubscriptionLevel.valueOf(this.f23131a.f23147i);
                if (abstractGroupSubscriptionController.f23122h != null) {
                    abstractGroupSubscriptionController.f23122h.mo990a(valueOf);
                }
                GroupUpdatePushSubscriptionLevelInputData groupUpdatePushSubscriptionLevelInputData = new GroupUpdatePushSubscriptionLevelInputData();
                groupUpdatePushSubscriptionLevelInputData.a("group_id", str2);
                GraphQlCallInput graphQlCallInput = groupUpdatePushSubscriptionLevelInputData;
                graphQlCallInput.a("setting", (GroupUpdatePushSubscriptionLevelInputData.Setting) AbstractGroupSubscriptionController.f23116b.get(valueOf));
                GraphQlCallInput graphQlCallInput2 = graphQlCallInput;
                graphQlCallInput2.a("actor_id", abstractGroupSubscriptionController.f23121g);
                Futures.a(abstractGroupSubscriptionController.f23120f.a(GraphQLRequest.a((GroupUpdatePushSubscriptionMutationString) new GroupUpdatePushSubscriptionMutationString().a("input", graphQlCallInput2))), new C33322(abstractGroupSubscriptionController, hc_), abstractGroupSubscriptionController.f23119e);
            }
            Logger.a(2, EntryType.UI_INPUT_END, -2064062678, a);
        }
    }

    public static void m24440c(GroupSubscriptionAdapter groupSubscriptionAdapter) {
        int i;
        groupSubscriptionAdapter.f23144f = RegularImmutableList.a;
        Builder builder = ImmutableList.builder();
        builder.c(new AbstractSection<PreferenceCategoryHeadingView>(groupSubscriptionAdapter, GroupSubscriptionAdapterRows.f23155a) {
            final /* synthetic */ GroupSubscriptionAdapter f23135a;

            public final void mo11a(View view) {
                PreferenceCategoryHeadingView preferenceCategoryHeadingView = (PreferenceCategoryHeadingView) view;
                preferenceCategoryHeadingView.setTitle(this.f23135a.f23139a.getString(2131237904));
                preferenceCategoryHeadingView.setIcon(2130840644);
            }
        });
        builder.c(m24442d());
        int size = groupSubscriptionAdapter.f23150l.size();
        for (int i2 = 0; i2 < size; i2++) {
            final EdgesModel edgesModel = (EdgesModel) groupSubscriptionAdapter.f23150l.get(i2);
            builder.c(new AbstractSection<CheckablePreferenceView>(groupSubscriptionAdapter, GroupSubscriptionAdapterRows.f23156b) {
                final /* synthetic */ GroupSubscriptionAdapter f23137b;

                public final void mo11a(View view) {
                    CheckablePreferenceView checkablePreferenceView = (CheckablePreferenceView) view;
                    checkablePreferenceView.a(edgesModel.b(), edgesModel.a(), edgesModel.c().toString().equals(this.f23137b.f23145g), edgesModel.c().toString());
                    checkablePreferenceView.setOnClickListener(this.f23137b.f23141c);
                }
            });
            builder.c(m24442d());
        }
        groupSubscriptionAdapter.m24441c(builder);
        builder.c(new AbstractSection<PreferenceCategoryHeadingView>(groupSubscriptionAdapter, GroupSubscriptionAdapterRows.f23155a) {
            final /* synthetic */ GroupSubscriptionAdapter f23132a;

            public final void mo11a(View view) {
                PreferenceCategoryHeadingView preferenceCategoryHeadingView = (PreferenceCategoryHeadingView) view;
                preferenceCategoryHeadingView.setTitle(this.f23132a.f23139a.getString(2131237899));
                preferenceCategoryHeadingView.setIcon(2130840643);
            }
        });
        builder.c(m24442d());
        if (groupSubscriptionAdapter.f23148j == null || groupSubscriptionAdapter.f23148j != GraphQLGroupRequestToJoinSubscriptionLevel.ON) {
            i = 2131237900;
        } else if (groupSubscriptionAdapter.f23149k == GraphQLGroupAdminType.ADMIN || groupSubscriptionAdapter.f23149k == GraphQLGroupAdminType.MODERATOR) {
            i = 2131237902;
        } else {
            i = 2131237901;
        }
        builder.c(new AbstractSection<SwitchWithDescriptionView>(groupSubscriptionAdapter, GroupSubscriptionAdapterRows.f23158d) {
            final /* synthetic */ GroupSubscriptionAdapter f23134b;

            public final void mo11a(View view) {
                SwitchWithDescriptionView switchWithDescriptionView = (SwitchWithDescriptionView) view;
                switchWithDescriptionView.setDelegate(this.f23134b.f23143e);
                switchWithDescriptionView.setSwitchDesciption(this.f23134b.f23139a.getString(i));
            }
        });
        groupSubscriptionAdapter.f23144f = builder.b();
        AdapterDetour.a(groupSubscriptionAdapter, -682852864);
    }

    @Inject
    public GroupSubscriptionAdapter(Resources resources, AbstractGroupSubscriptionController abstractGroupSubscriptionController) {
        this.f23139a = resources;
        this.f23140b = abstractGroupSubscriptionController;
        this.f23140b.f23122h = this.f23154p;
        this.f23150l = RegularImmutableList.a;
        this.f23151m = RegularImmutableList.a;
        this.f23143e = new C33352(this);
        this.f23141c = new C33363(this);
        this.f23142d = new C33374(this);
        m24440c(this);
    }

    public static void m24439b(GroupSubscriptionAdapter groupSubscriptionAdapter) {
        switch (AnonymousClass12.f23126a[GraphQLGroupSubscriptionLevel.fromString(groupSubscriptionAdapter.f23145g).ordinal()]) {
            case 1:
                groupSubscriptionAdapter.f23146h = GraphQLGroupPushSubscriptionLevel.ON;
                return;
            case 2:
            case 3:
                groupSubscriptionAdapter.f23146h = GraphQLGroupPushSubscriptionLevel.HIGHLIGHTS;
                if (groupSubscriptionAdapter.f23147i.equals(GraphQLGroupPushSubscriptionLevel.ON.toString())) {
                    groupSubscriptionAdapter.f23147i = GraphQLGroupPushSubscriptionLevel.HIGHLIGHTS.toString();
                    return;
                }
                return;
            case 4:
                groupSubscriptionAdapter.f23146h = GraphQLGroupPushSubscriptionLevel.OFF;
                if (groupSubscriptionAdapter.f23147i.equals(GraphQLGroupPushSubscriptionLevel.ON.toString()) || groupSubscriptionAdapter.f23147i.equals(GraphQLGroupPushSubscriptionLevel.HIGHLIGHTS.toString())) {
                    groupSubscriptionAdapter.f23147i = GraphQLGroupPushSubscriptionLevel.OFF.toString();
                    return;
                }
                return;
            default:
                return;
        }
    }

    private void m24441c(Builder<Section> builder) {
        builder.c(new AbstractSection<PreferenceCategoryHeadingView>(this, GroupSubscriptionAdapterRows.f23155a) {
            final /* synthetic */ GroupSubscriptionAdapter f23138a;

            public final void mo11a(View view) {
                PreferenceCategoryHeadingView preferenceCategoryHeadingView = (PreferenceCategoryHeadingView) view;
                preferenceCategoryHeadingView.setTitle(this.f23138a.f23139a.getString(2131237908));
                preferenceCategoryHeadingView.setIcon(2130840645);
            }
        });
        builder.c(m24442d());
        int size = this.f23151m.size();
        for (int i = 0; i < size; i++) {
            PossiblePushSubscriptionLevelsModel.EdgesModel edgesModel = (PossiblePushSubscriptionLevelsModel.EdgesModel) this.f23151m.get(i);
            switch (AnonymousClass12.f23127b[this.f23146h.ordinal()]) {
                case 1:
                    builder.c(m24438a(edgesModel));
                    builder.c(m24442d());
                    break;
                case 2:
                    if (edgesModel.b() == GraphQLGroupPushSubscriptionLevel.ON) {
                        break;
                    }
                    builder.c(m24438a(edgesModel));
                    builder.c(m24442d());
                    break;
                case 3:
                    if (!(edgesModel.b() == GraphQLGroupPushSubscriptionLevel.ON || edgesModel.b() == GraphQLGroupPushSubscriptionLevel.HIGHLIGHTS)) {
                        builder.c(m24438a(edgesModel));
                        builder.c(m24442d());
                        break;
                    }
                default:
                    break;
            }
        }
        builder.c(new AbstractSection<BetterTextView>(this, GroupSubscriptionAdapterRows.f23157c) {
            final /* synthetic */ GroupSubscriptionAdapter f23123a;

            public final void mo11a(View view) {
                ((BetterTextView) view).setText(this.f23123a.f23139a.getString(2131237910));
            }
        });
    }

    private AbstractSection<CheckablePreferenceView> m24438a(final PossiblePushSubscriptionLevels.Edges edges) {
        return new AbstractSection<CheckablePreferenceView>(this, GroupSubscriptionAdapterRows.f23156b) {
            final /* synthetic */ GroupSubscriptionAdapter f23125b;

            public final void mo11a(View view) {
                CheckablePreferenceView checkablePreferenceView = (CheckablePreferenceView) view;
                checkablePreferenceView.a(edges.a(), null, edges.b().toString().equals(this.f23125b.f23147i), edges.b().toString());
                checkablePreferenceView.setOnClickListener(this.f23125b.f23142d);
            }
        };
    }

    public final void m24444a(int i, Object obj, View view, int i2, ViewGroup viewGroup) {
        ((Section) obj).mo11a(view);
    }

    public static Section<View> m24442d() {
        return new StaticSection(GroupSubscriptionAdapterRows.f23159e);
    }

    public int getItemViewType(int i) {
        return GroupSubscriptionAdapterRows.f23160f.indexOf(((Section) this.f23144f.get(i)).mo10a());
    }

    public int getViewTypeCount() {
        return GroupSubscriptionAdapterRows.f23160f.size();
    }

    public final View m24443a(int i, ViewGroup viewGroup) {
        return ((ViewType) GroupSubscriptionAdapterRows.f23160f.get(i)).mo12a(viewGroup);
    }

    public int getCount() {
        return this.f23144f.size();
    }

    public Object getItem(int i) {
        return this.f23144f.get(i);
    }

    public long getItemId(int i) {
        return (long) i;
    }
}
