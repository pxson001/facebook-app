package com.facebook.groups.fb4a.discover;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.auth.annotations.LoggedInUserId;
import com.facebook.auth.module.String_LoggedInUserIdMethodAutoProvider;
import com.facebook.base.activity.FragmentChromeActivity;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.executors.ForUiThread;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.common.fragmentconstants.FragmentConstants.ContentFragmentType;
import com.facebook.common.locale.Locales;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.graphql.calls.GraphQlCallInput;
import com.facebook.graphql.calls.GroupHideSuggestionInputData;
import com.facebook.graphql.calls.GroupHideSuggestionInputData.SourceType;
import com.facebook.graphql.calls.GroupLeaveInputData;
import com.facebook.graphql.calls.GroupLeaveInputData.ReaddPolicy;
import com.facebook.graphql.calls.GroupRequestToJoinInputData.Source;
import com.facebook.graphql.enums.GraphQLGroupJoinState;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.query.GraphQlQueryString;
import com.facebook.groups.discover.protocol.DiscoverMutations.GroupHideSuggestionMutationString;
import com.facebook.groups.discover.protocol.FetchSuggestedGroupsModels.FB4ADiscoverRowDataModel;
import com.facebook.groups.discover.protocol.FetchSuggestedGroupsModels.FB4ADiscoverRowDataModel.Builder;
import com.facebook.groups.discover.protocol.FetchSuggestedGroupsModels.FB4ADiscoverRowDataModel.NodeModel;
import com.facebook.groups.discover.protocol.FetchSuggestedGroupsModels.FB4ADiscoverRowDataModel.NodeModel.GroupMembersModel.EdgesModel;
import com.facebook.groups.fb4a.discover.FB4AGroupsDiscoverFragment.C31371;
import com.facebook.groups.mutations.GroupsClient;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedProvider;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.resources.ui.FbButton;
import com.facebook.ui.animations.HeightAnimation;
import com.facebook.ui.toaster.ToastBuilder;
import com.facebook.ui.toaster.Toaster;
import com.facebook.user.model.User.Type;
import com.facebook.user.model.UserKey;
import com.facebook.widget.CustomLinearLayout;
import com.facebook.widget.text.BetterTextView;
import com.facebook.widget.tiles.ThreadTileView;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.RegularImmutableList;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import java.text.NumberFormat;
import java.util.concurrent.ExecutorService;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: Type of protile item should be Photos or Friends. */
public class FB4ADiscoverRowView extends CustomLinearLayout {
    private static final CallerContext f21890i = CallerContext.a(FB4ADiscoverRowView.class, "discovery");
    @Inject
    public Locales f21891a;
    @Inject
    public GroupsClient f21892b;
    @Inject
    @ForUiThread
    public ExecutorService f21893c;
    @Inject
    Toaster f21894d;
    @Inject
    @FragmentChromeActivity
    public Provider<ComponentName> f21895e;
    @Inject
    public SecureContextHelper f21896f;
    @Inject
    @LoggedInUserId
    public String f21897g;
    @Inject
    public GraphQLQueryExecutor f21898h;
    public NumberFormat f21899j = NumberFormat.getInstance(this.f21891a.a());
    public ThreadTileView f21900k = ((ThreadTileView) a(2131561761));
    public BetterTextView f21901l = ((BetterTextView) findViewById(2131561763));
    public BetterTextView f21902m = ((BetterTextView) findViewById(2131561762));
    public BetterTextView f21903n = ((BetterTextView) findViewById(2131561764));
    public FbButton f21904o = ((FbButton) findViewById(2131561765));
    public FbButton f21905p = ((FbButton) findViewById(2131561766));
    public View f21906q = a(2131561760);
    public boolean f21907r;
    public FB4ADiscoverRowDataModel f21908s;
    public C31371 f21909t;

    /* compiled from: Type of protile item should be Photos or Friends. */
    public class C31311 implements OnClickListener {
        final /* synthetic */ FB4ADiscoverRowView f21883a;

        public C31311(FB4ADiscoverRowView fB4ADiscoverRowView) {
            this.f21883a = fB4ADiscoverRowView;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 221511721);
            FB4ADiscoverRowDataModel fB4ADiscoverRowDataModel = ((FB4ADiscoverRowView) view).f21908s;
            FB4ADiscoverRowView fB4ADiscoverRowView = this.f21883a;
            if (!(fB4ADiscoverRowDataModel == null || fB4ADiscoverRowDataModel.m22260a() == null || fB4ADiscoverRowDataModel.m22260a().m22249m() == null)) {
                Intent component = new Intent().setComponent((ComponentName) fB4ADiscoverRowView.f21895e.get());
                component.putExtra("group_feed_id", fB4ADiscoverRowDataModel.m22260a().m22249m());
                component.putExtra("target_fragment", ContentFragmentType.GROUPS_MALL_FRAGMENT.ordinal());
                fB4ADiscoverRowView.f21896f.a(component, fB4ADiscoverRowView.getContext());
            }
            Logger.a(2, EntryType.UI_INPUT_END, -915998806, a);
        }
    }

    /* compiled from: Type of protile item should be Photos or Friends. */
    public class C31322 implements OnClickListener {
        final /* synthetic */ FB4ADiscoverRowView f21884a;

        public C31322(FB4ADiscoverRowView fB4ADiscoverRowView) {
            this.f21884a = fB4ADiscoverRowView;
        }

        public void onClick(View view) {
            ListenableFuture a;
            int a2 = Logger.a(2, EntryType.UI_INPUT_START, 1469555219);
            FB4ADiscoverRowView fB4ADiscoverRowView = this.f21884a;
            if (fB4ADiscoverRowView.f21907r) {
                a = fB4ADiscoverRowView.f21892b.a(fB4ADiscoverRowView.f21908s.m22260a().m22249m(), Source.SUGGESTED_GROUPS);
            } else {
                a = fB4ADiscoverRowView.f21892b.a(fB4ADiscoverRowView.f21908s.m22260a().m22249m(), GroupLeaveInputData.Source.SUGGESTED_GROUPS, ReaddPolicy.ALLOW_READD);
            }
            Builder a3 = Builder.m22190a(fB4ADiscoverRowView.f21908s);
            NodeModel a4 = fB4ADiscoverRowView.f21908s.m22260a();
            NodeModel.Builder builder = new NodeModel.Builder();
            builder.f21291a = a4.m22246j();
            builder.f21292b = a4.m22247k();
            builder.f21293c = a4.m22248l();
            builder.f21294d = a4.m22249m();
            builder.f21295e = a4.m22250n();
            builder.f21296f = a4.m22251o();
            NodeModel.Builder builder2 = builder;
            builder2.f21296f = FB4ADiscoverRowView.m23044a(fB4ADiscoverRowView.f21908s.m22260a().m22251o());
            a3.f21288a = builder2.m22193a();
            FB4ADiscoverRowDataModel a5 = a3.m22191a();
            FB4ADiscoverRowDataModel fB4ADiscoverRowDataModel = fB4ADiscoverRowView.f21908s;
            boolean z = fB4ADiscoverRowView.f21907r;
            fB4ADiscoverRowView.m23048a(a5, false);
            Futures.a(a, new C31344(fB4ADiscoverRowView, fB4ADiscoverRowDataModel, z), fB4ADiscoverRowView.f21893c);
            Logger.a(2, EntryType.UI_INPUT_END, -1405020956, a2);
        }
    }

    /* compiled from: Type of protile item should be Photos or Friends. */
    public class C31333 implements OnClickListener {
        final /* synthetic */ FB4ADiscoverRowView f21885a;

        public C31333(FB4ADiscoverRowView fB4ADiscoverRowView) {
            this.f21885a = fB4ADiscoverRowView;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -875621937);
            FB4ADiscoverRowView fB4ADiscoverRowView = this.f21885a;
            HeightAnimation heightAnimation = new HeightAnimation(fB4ADiscoverRowView.f21906q, 0);
            heightAnimation.setDuration(200);
            fB4ADiscoverRowView.startAnimation(heightAnimation);
            fB4ADiscoverRowView = this.f21885a;
            FB4ADiscoverRowDataModel fB4ADiscoverRowDataModel = this.f21885a.f21908s;
            if (fB4ADiscoverRowDataModel != null) {
                GroupHideSuggestionInputData groupHideSuggestionInputData = new GroupHideSuggestionInputData();
                groupHideSuggestionInputData.a("actor_id", fB4ADiscoverRowView.f21897g);
                GraphQlCallInput graphQlCallInput = groupHideSuggestionInputData;
                graphQlCallInput.a("group_id", fB4ADiscoverRowDataModel.m22260a().m22249m());
                graphQlCallInput = graphQlCallInput;
                graphQlCallInput.a("reason", fB4ADiscoverRowDataModel.m22262k());
                graphQlCallInput = graphQlCallInput;
                graphQlCallInput.a("source_type", SourceType.SUGGESTION);
                graphQlCallInput = graphQlCallInput;
                GraphQlQueryString groupHideSuggestionMutationString = new GroupHideSuggestionMutationString();
                groupHideSuggestionMutationString.a("input", graphQlCallInput);
                fB4ADiscoverRowView.f21898h.a(GraphQLRequest.a(groupHideSuggestionMutationString));
            }
            C31371 c31371 = this.f21885a.f21909t;
            fB4ADiscoverRowDataModel = this.f21885a.f21908s;
            if (fB4ADiscoverRowDataModel != null) {
                c31371.f21918a.f21925b.m23051a(fB4ADiscoverRowDataModel);
                if (!c31371.f21918a.f21925b.m23053a()) {
                    FB4AGroupsDiscoverFragment.ar(c31371.f21918a);
                }
            }
            Logger.a(2, EntryType.UI_INPUT_END, -1356573575, a);
        }
    }

    /* compiled from: Type of protile item should be Photos or Friends. */
    public class C31344 implements FutureCallback<Void> {
        final /* synthetic */ FB4ADiscoverRowDataModel f21886a;
        final /* synthetic */ boolean f21887b;
        final /* synthetic */ FB4ADiscoverRowView f21888c;

        public C31344(FB4ADiscoverRowView fB4ADiscoverRowView, FB4ADiscoverRowDataModel fB4ADiscoverRowDataModel, boolean z) {
            this.f21888c = fB4ADiscoverRowView;
            this.f21886a = fB4ADiscoverRowDataModel;
            this.f21887b = z;
        }

        public /* bridge */ /* synthetic */ void onSuccess(Object obj) {
        }

        public void onFailure(Throwable th) {
            this.f21888c.m23048a(this.f21886a, false);
            Toaster toaster = this.f21888c.f21894d;
            String str = "%s\n\n%s";
            Object[] objArr = new Object[2];
            objArr[0] = this.f21888c.getContext().getString(2131230761);
            objArr[1] = this.f21887b ? this.f21888c.getContext().getString(2131242059) : this.f21888c.getContext().getString(2131242060);
            toaster.b(new ToastBuilder(StringFormatUtil.a(str, objArr)));
        }
    }

    /* compiled from: Type of protile item should be Photos or Friends. */
    public /* synthetic */ class C31355 {
        public static final /* synthetic */ int[] f21889a = new int[GraphQLGroupJoinState.values().length];

        static {
            try {
                f21889a[GraphQLGroupJoinState.CAN_JOIN.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f21889a[GraphQLGroupJoinState.CAN_REQUEST.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f21889a[GraphQLGroupJoinState.MEMBER.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f21889a[GraphQLGroupJoinState.REQUESTED.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
        }
    }

    public static void m23046a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((FB4ADiscoverRowView) obj).m23045a(Locales.a(fbInjector), GroupsClient.b(fbInjector), (ExecutorService) ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.a(fbInjector), Toaster.b(fbInjector), IdBasedProvider.a(fbInjector, 12), (SecureContextHelper) DefaultSecureContextHelper.a(fbInjector), String_LoggedInUserIdMethodAutoProvider.b(fbInjector), GraphQLQueryExecutor.a(fbInjector));
    }

    private void m23045a(Locales locales, GroupsClient groupsClient, ExecutorService executorService, Toaster toaster, Provider<ComponentName> provider, SecureContextHelper secureContextHelper, String str, GraphQLQueryExecutor graphQLQueryExecutor) {
        this.f21891a = locales;
        this.f21892b = groupsClient;
        this.f21893c = executorService;
        this.f21894d = toaster;
        this.f21895e = provider;
        this.f21896f = secureContextHelper;
        this.f21897g = str;
        this.f21898h = graphQLQueryExecutor;
    }

    public FB4ADiscoverRowView(Context context) {
        super(context);
        Class cls = FB4ADiscoverRowView.class;
        m23046a((Object) this, getContext());
        setContentView(2130904253);
    }

    public final void m23048a(FB4ADiscoverRowDataModel fB4ADiscoverRowDataModel, boolean z) {
        if (z) {
            this.f21906q.getLayoutParams().height = 0;
            return;
        }
        if (getAnimation() != null) {
            clearAnimation();
        }
        this.f21908s = fB4ADiscoverRowDataModel;
        NodeModel a = fB4ADiscoverRowDataModel.m22260a();
        this.f21902m.setText(a.m22250n());
        this.f21901l.setText(fB4ADiscoverRowDataModel.m22262k());
        this.f21903n.setText(fB4ADiscoverRowDataModel.m22261j().m22257a());
        this.f21900k.setThreadTileViewData(m23047b(a));
        switch (C31355.f21889a[a.m22251o().ordinal()]) {
            case 1:
            case 2:
                this.f21907r = true;
                this.f21904o.setText(getResources().getString(2131242063));
                break;
            case 3:
                this.f21907r = false;
                this.f21904o.setText(getResources().getString(2131242064));
                break;
            case 4:
                this.f21907r = false;
                this.f21904o.setText(getResources().getString(2131242065));
                break;
        }
        setOnClickListener(new C31311(this));
        this.f21904o.setOnClickListener(new C31322(this));
        this.f21905p.setOnClickListener(new C31333(this));
    }

    private static FB4AGroupsDiscoverTileViewData m23047b(NodeModel nodeModel) {
        if (nodeModel == null) {
            return null;
        }
        Object obj;
        String m = nodeModel.m22249m();
        if (nodeModel.m22246j() == null || nodeModel.m22246j().m22210a() == null || nodeModel.m22246j().m22210a().m22206j() == null || Strings.isNullOrEmpty(nodeModel.m22246j().m22210a().m22206j().m22200a())) {
            obj = null;
        } else {
            obj = 1;
        }
        if (obj != null && nodeModel.m22248l() == 0) {
            return new FB4AGroupsDiscoverTileViewData(m, Uri.parse(nodeModel.m22246j().m22210a().m22206j().m22200a()), RegularImmutableList.a, RegularImmutableList.a);
        }
        int size = nodeModel.m22247k().m22235a().size();
        ImmutableList.Builder builder = ImmutableList.builder();
        ImmutableList.Builder builder2 = ImmutableList.builder();
        int i = 0;
        while (i < size && i < 3) {
            EdgesModel edgesModel = (EdgesModel) nodeModel.m22247k().m22235a().get(i);
            if (!(edgesModel.m22231a() == null || edgesModel.m22231a().m22226j() == null || edgesModel.m22231a().m22227k() == null || edgesModel.m22231a().m22227k().m22219a() == null)) {
                builder.c(new UserKey(Type.FACEBOOK, edgesModel.m22231a().m22226j()));
                builder2.c(Uri.parse(edgesModel.m22231a().m22227k().m22219a()));
            }
            i++;
        }
        return new FB4AGroupsDiscoverTileViewData(m, null, builder.b(), builder2.b());
    }

    public static GraphQLGroupJoinState m23044a(GraphQLGroupJoinState graphQLGroupJoinState) {
        switch (C31355.f21889a[graphQLGroupJoinState.ordinal()]) {
            case 1:
                return GraphQLGroupJoinState.MEMBER;
            case 2:
                return GraphQLGroupJoinState.REQUESTED;
            case 3:
                return GraphQLGroupJoinState.CAN_JOIN;
            case 4:
                return GraphQLGroupJoinState.CAN_REQUEST;
            default:
                return graphQLGroupJoinState;
        }
    }
}
