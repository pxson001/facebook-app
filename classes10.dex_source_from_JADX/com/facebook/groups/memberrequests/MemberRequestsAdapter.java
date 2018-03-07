package com.facebook.groups.memberrequests;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.fblinks.FBLinks;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.timeformat.DefaultTimeFormatUtil;
import com.facebook.common.timeformat.TimeFormatUtil.TimeFormatStyle;
import com.facebook.common.uri.UriIntentMapper;
import com.facebook.common.util.ContextUtils;
import com.facebook.content.SecureContextHelper;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.fbui.dialog.AlertDialog.Builder;
import com.facebook.fbui.widget.layout.ImageBlockLayout;
import com.facebook.graphql.calls.GraphQlCallInput;
import com.facebook.graphql.calls.GroupApprovePendingMemberInputData;
import com.facebook.graphql.calls.GroupApprovePendingMemberInputData.Source;
import com.facebook.graphql.calls.GroupRejectPendingMemberInputData;
import com.facebook.graphql.calls.GroupRejectPendingMemberInputData.Consequence;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.query.GraphQlQueryString;
import com.facebook.groups.memberrequests.MemberRequestsController.C33091;
import com.facebook.groups.memberrequests.MemberRequestsController.C33102;
import com.facebook.groups.memberrequests.MemberRequestsController.C33113;
import com.facebook.groups.memberrequests.MemberRequestsController.MemberRequestStates;
import com.facebook.groups.memberrequests.MemberRequestsFragment.C33141;
import com.facebook.groups.memberrequests.protocol.FetchMemberRequestsModels.FetchMemberRequestsModel;
import com.facebook.groups.memberrequests.protocol.FetchMemberRequestsModels.FetchMemberRequestsModel.AdminAwareGroupModel.GroupPendingMembersModel.EdgesModel;
import com.facebook.groups.memberrequests.protocol.MemberRequestsMutations;
import com.facebook.groups.memberrequests.protocol.MemberRequestsMutations.GroupApprovePendingMemberMutationString;
import com.facebook.groups.memberrequests.protocol.MemberRequestsMutations.GroupRejectPendingMemberMutationString;
import com.facebook.groups.staticadapter.StaticAdapter.AbstractSection;
import com.facebook.groups.staticadapter.StaticAdapter.Section;
import com.facebook.groups.staticadapter.StaticAdapter.StaticSection;
import com.facebook.groups.staticadapter.StaticAdapter.ViewType;
import com.facebook.inject.Assisted;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.resources.ui.FbButton;
import com.facebook.tools.dextr.runtime.detour.AdapterDetour;
import com.facebook.widget.listview.FbBaseAdapter;
import com.facebook.widget.text.BetterTextView;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.RegularImmutableList;
import com.google.common.util.concurrent.Futures;
import javax.inject.Inject;

/* compiled from: TVMF-process changes */
public class MemberRequestsAdapter extends FbBaseAdapter {
    public static final CallerContext f22907a = CallerContext.a(MemberRequestsAdapter.class, "member_requests");
    private final ViewType<FrameLayout> f22908b = new C33001(this);
    public final ViewType<LinearLayout> f22909c = new C33012(this);
    public final ViewType<LinearLayout> f22910d = new C33023(this);
    public final ViewType<LinearLayout> f22911e = new C33034(this);
    private final ViewType<LinearLayout> f22912f = new C33045(this);
    private final ViewType<BetterTextView> f22913g = new C33056(this);
    private final ViewType<LinearLayout> f22914h = new C33067(this);
    public final ViewType<LinearLayout> f22915i = new C33078(this);
    public final ViewType<ImageBlockLayout> f22916j = new C33089(this);
    public final C33141 f22917k;
    private ImmutableList<Section> f22918l = ImmutableList.of();
    public Resources f22919m;
    public final UriIntentMapper f22920n;
    public final SecureContextHelper f22921o;
    private final DefaultTimeFormatUtil f22922p;
    public final DefaultMemberRequestsNavigationHandler f22923q;
    private final boolean f22924r;
    private final ImmutableList<ViewType<? extends View>> f22925s = ImmutableList.of(this.f22912f, this.f22908b, this.f22913g, this.f22915i, this.f22910d, this.f22911e, this.f22909c, this.f22914h, this.f22916j);

    /* compiled from: TVMF-process changes */
    public class AnonymousClass10 implements OnClickListener {
        final /* synthetic */ String f22873a;
        final /* synthetic */ String f22874b;
        final /* synthetic */ MemberRequestsAdapter f22875c;

        public AnonymousClass10(MemberRequestsAdapter memberRequestsAdapter, String str, String str2) {
            this.f22875c = memberRequestsAdapter;
            this.f22873a = str;
            this.f22874b = str2;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -886959708);
            C33141 c33141 = this.f22875c.f22917k;
            String str = this.f22873a;
            String str2 = this.f22874b;
            Bundle bundle = new Bundle();
            String formatStrLocaleSafe = StringFormatUtil.formatStrLocaleSafe(FBLinks.u, str);
            bundle.putString("group_feed_id", str);
            bundle.putString("group_feed_title", str2);
            c33141.f22939a.f22947f.a(c33141.f22939a.getContext(), formatStrLocaleSafe, bundle);
            Logger.a(2, EntryType.UI_INPUT_END, 690491930, a);
        }
    }

    /* compiled from: TVMF-process changes */
    public class AnonymousClass11 implements OnClickListener {
        final /* synthetic */ EdgesModel f22876a;
        final /* synthetic */ MemberRequestsAdapter f22877b;

        public AnonymousClass11(MemberRequestsAdapter memberRequestsAdapter, EdgesModel edgesModel) {
            this.f22877b = memberRequestsAdapter;
            this.f22876a = edgesModel;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -1993544541);
            C33141 c33141 = this.f22877b.f22917k;
            EdgesModel edgesModel = this.f22876a;
            MemberRequestsController memberRequestsController = c33141.f22939a.f22944c;
            String str = c33141.f22939a.am;
            memberRequestsController.f22934a.put(edgesModel.m24105a().m24096b(), MemberRequestStates.MEMBER_REQUEST_ACCEPTED);
            GroupApprovePendingMemberInputData groupApprovePendingMemberInputData = new GroupApprovePendingMemberInputData();
            groupApprovePendingMemberInputData.a("actor_id", memberRequestsController.f22936c);
            GraphQlCallInput graphQlCallInput = groupApprovePendingMemberInputData;
            graphQlCallInput.a("group_id", str);
            graphQlCallInput = graphQlCallInput;
            graphQlCallInput.a("user_id", edgesModel.m24105a().m24096b());
            graphQlCallInput = graphQlCallInput;
            graphQlCallInput.a("source", Source.UNKNOWN);
            graphQlCallInput = graphQlCallInput;
            GraphQlQueryString groupApprovePendingMemberMutationString = new GroupApprovePendingMemberMutationString();
            groupApprovePendingMemberMutationString.a("input", graphQlCallInput);
            Futures.a(memberRequestsController.f22937d.a(GraphQLRequest.a(groupApprovePendingMemberMutationString)), new C33091(memberRequestsController, edgesModel), memberRequestsController.f22935b);
            c33141.f22939a.f22948g.m24029a(c33141.f22939a.al, c33141.f22939a.f22950i, c33141.f22939a.f22944c, false, c33141.f22939a.f22949h);
            Logger.a(2, EntryType.UI_INPUT_END, -151105822, a);
        }
    }

    /* compiled from: TVMF-process changes */
    public class AnonymousClass12 implements OnClickListener {
        final /* synthetic */ EdgesModel f22878a;
        final /* synthetic */ MemberRequestsAdapter f22879b;

        public AnonymousClass12(MemberRequestsAdapter memberRequestsAdapter, EdgesModel edgesModel) {
            this.f22879b = memberRequestsAdapter;
            this.f22878a = edgesModel;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 1842222906);
            C33141 c33141 = this.f22879b.f22917k;
            EdgesModel edgesModel = this.f22878a;
            MemberRequestsController memberRequestsController = c33141.f22939a.f22944c;
            String str = c33141.f22939a.am;
            memberRequestsController.f22934a.put(edgesModel.m24105a().m24096b(), MemberRequestStates.MEMBER_REQUEST_IGNORED);
            GroupRejectPendingMemberInputData a2 = new GroupRejectPendingMemberInputData().a(memberRequestsController.f22936c).b(str).c(edgesModel.m24105a().m24096b()).a(GroupRejectPendingMemberInputData.Source.UNKNOWN);
            GroupRejectPendingMemberMutationString b = MemberRequestsMutations.m24183b();
            b.a("input", a2);
            Futures.a(memberRequestsController.f22937d.a(GraphQLRequest.a(b)), new C33113(memberRequestsController, edgesModel), memberRequestsController.f22935b);
            c33141.f22939a.f22948g.m24029a(c33141.f22939a.al, c33141.f22939a.f22950i, c33141.f22939a.f22944c, false, c33141.f22939a.f22949h);
            Logger.a(2, EntryType.UI_INPUT_END, -1447700685, a);
        }
    }

    /* compiled from: TVMF-process changes */
    public class AnonymousClass13 implements OnClickListener {
        final /* synthetic */ EdgesModel f22882a;
        final /* synthetic */ MemberRequestsAdapter f22883b;

        /* compiled from: TVMF-process changes */
        class C32981 implements DialogInterface.OnClickListener {
            final /* synthetic */ AnonymousClass13 f22880a;

            C32981(AnonymousClass13 anonymousClass13) {
                this.f22880a = anonymousClass13;
            }

            public void onClick(DialogInterface dialogInterface, int i) {
                C33141 c33141 = this.f22880a.f22883b.f22917k;
                EdgesModel edgesModel = this.f22880a.f22882a;
                MemberRequestsController memberRequestsController = c33141.f22939a.f22944c;
                String str = c33141.f22939a.am;
                memberRequestsController.f22934a.put(edgesModel.m24105a().m24096b(), MemberRequestStates.MEMBER_REQUEST_BLOCKED);
                GroupRejectPendingMemberInputData b = new GroupRejectPendingMemberInputData().a(memberRequestsController.f22936c).b(str);
                b.a("consequence", Consequence.BLOCK);
                b = b.c(edgesModel.m24105a().m24096b()).a(GroupRejectPendingMemberInputData.Source.UNKNOWN);
                GroupRejectPendingMemberMutationString b2 = MemberRequestsMutations.m24183b();
                b2.a("input", b);
                Futures.a(memberRequestsController.f22937d.a(GraphQLRequest.a(b2)), new C33102(memberRequestsController, edgesModel), memberRequestsController.f22935b);
                c33141.f22939a.f22948g.m24029a(c33141.f22939a.al, c33141.f22939a.f22950i, c33141.f22939a.f22944c, false, c33141.f22939a.f22949h);
            }
        }

        /* compiled from: TVMF-process changes */
        class C32992 implements DialogInterface.OnClickListener {
            final /* synthetic */ AnonymousClass13 f22881a;

            C32992(AnonymousClass13 anonymousClass13) {
                this.f22881a = anonymousClass13;
            }

            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        }

        public AnonymousClass13(MemberRequestsAdapter memberRequestsAdapter, EdgesModel edgesModel) {
            this.f22883b = memberRequestsAdapter;
            this.f22882a = edgesModel;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 948076313);
            Builder builder = new Builder(view.getContext());
            builder.a(this.f22883b.f22919m.getString(2131242222), new C32981(this));
            builder.b(this.f22883b.f22919m.getString(2131242219), new C32992(this));
            builder.a(this.f22883b.f22919m.getString(2131242218));
            builder.b(this.f22883b.f22919m.getString(2131239446, new Object[]{this.f22882a.m24109l().m24099l()}));
            builder.a().show();
            Logger.a(2, EntryType.UI_INPUT_END, 2063983317, a);
        }
    }

    /* compiled from: TVMF-process changes */
    class C33001 implements ViewType<FrameLayout> {
        final /* synthetic */ MemberRequestsAdapter f22898a;

        C33001(MemberRequestsAdapter memberRequestsAdapter) {
            this.f22898a = memberRequestsAdapter;
        }

        public final View mo12a(ViewGroup viewGroup) {
            LayoutInflater from = LayoutInflater.from(viewGroup.getContext());
            DefaultMemberRequestsNavigationHandler defaultMemberRequestsNavigationHandler = this.f22898a.f22923q;
            return (FrameLayout) from.inflate(2130904732, viewGroup, false);
        }
    }

    /* compiled from: TVMF-process changes */
    class C33012 implements ViewType<LinearLayout> {
        final /* synthetic */ MemberRequestsAdapter f22899a;

        C33012(MemberRequestsAdapter memberRequestsAdapter) {
            this.f22899a = memberRequestsAdapter;
        }

        public final View mo12a(ViewGroup viewGroup) {
            LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(viewGroup.getContext()).inflate(2130904728, viewGroup, false);
            ViewStub viewStub = (ViewStub) linearLayout.findViewById(2131562786);
            DefaultMemberRequestsNavigationHandler defaultMemberRequestsNavigationHandler = this.f22899a.f22923q;
            viewStub.setLayoutResource(2130904729);
            viewStub.inflate();
            Resources resources = this.f22899a.f22919m;
            defaultMemberRequestsNavigationHandler = this.f22899a.f22923q;
            int dimensionPixelSize = resources.getDimensionPixelSize(2131434347);
            resources = this.f22899a.f22919m;
            DefaultMemberRequestsNavigationHandler defaultMemberRequestsNavigationHandler2 = this.f22899a.f22923q;
            int dimensionPixelSize2 = resources.getDimensionPixelSize(2131434346);
            FbButton fbButton = (FbButton) linearLayout.findViewById(2131562796);
            Resources resources2 = this.f22899a.f22919m;
            DefaultMemberRequestsNavigationHandler defaultMemberRequestsNavigationHandler3 = this.f22899a.f22923q;
            fbButton.setTextColor(resources2.getColor(17170443));
            resources2 = this.f22899a.f22919m;
            defaultMemberRequestsNavigationHandler3 = this.f22899a.f22923q;
            fbButton.setBackgroundDrawable(resources2.getDrawable(2130840712));
            fbButton.setPadding(dimensionPixelSize2, dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize);
            fbButton = (FbButton) linearLayout.findViewById(2131562797);
            resources2 = this.f22899a.f22919m;
            defaultMemberRequestsNavigationHandler3 = this.f22899a.f22923q;
            fbButton.setTextColor(resources2.getColor(17170444));
            resources2 = this.f22899a.f22919m;
            defaultMemberRequestsNavigationHandler3 = this.f22899a.f22923q;
            fbButton.setBackgroundDrawable(resources2.getDrawable(2130840715));
            fbButton.setPadding(dimensionPixelSize2, dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize);
            fbButton = (FbButton) linearLayout.findViewById(2131562798);
            resources2 = this.f22899a.f22919m;
            defaultMemberRequestsNavigationHandler3 = this.f22899a.f22923q;
            fbButton.setTextColor(resources2.getColor(17170444));
            resources2 = this.f22899a.f22919m;
            defaultMemberRequestsNavigationHandler3 = this.f22899a.f22923q;
            fbButton.setBackgroundDrawable(resources2.getDrawable(2130840715));
            fbButton.setPadding(dimensionPixelSize2, dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize);
            return linearLayout;
        }
    }

    /* compiled from: TVMF-process changes */
    class C33023 implements ViewType<LinearLayout> {
        final /* synthetic */ MemberRequestsAdapter f22900a;

        C33023(MemberRequestsAdapter memberRequestsAdapter) {
            this.f22900a = memberRequestsAdapter;
        }

        public final View mo12a(ViewGroup viewGroup) {
            LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(viewGroup.getContext()).inflate(2130904727, viewGroup, false);
            ViewStub viewStub = (ViewStub) linearLayout.findViewById(2131562786);
            DefaultMemberRequestsNavigationHandler defaultMemberRequestsNavigationHandler = this.f22900a.f22923q;
            viewStub.setLayoutResource(2130904729);
            viewStub.inflate();
            return linearLayout;
        }
    }

    /* compiled from: TVMF-process changes */
    class C33034 implements ViewType<LinearLayout> {
        final /* synthetic */ MemberRequestsAdapter f22901a;

        C33034(MemberRequestsAdapter memberRequestsAdapter) {
            this.f22901a = memberRequestsAdapter;
        }

        public final View mo12a(ViewGroup viewGroup) {
            LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(viewGroup.getContext()).inflate(2130904725, viewGroup, false);
            ViewStub viewStub = (ViewStub) linearLayout.findViewById(2131562786);
            DefaultMemberRequestsNavigationHandler defaultMemberRequestsNavigationHandler = this.f22901a.f22923q;
            viewStub.setLayoutResource(2130904729);
            viewStub.inflate();
            return linearLayout;
        }
    }

    /* compiled from: TVMF-process changes */
    class C33045 implements ViewType<LinearLayout> {
        final /* synthetic */ MemberRequestsAdapter f22902a;

        C33045(MemberRequestsAdapter memberRequestsAdapter) {
            this.f22902a = memberRequestsAdapter;
        }

        public final View mo12a(ViewGroup viewGroup) {
            View linearLayout = new LinearLayout(viewGroup.getContext());
            linearLayout.setMinimumHeight(Math.round(viewGroup.getResources().getDimension(2131434332)));
            linearLayout.setBackgroundDrawable(new ColorDrawable(-526345));
            return linearLayout;
        }
    }

    /* compiled from: TVMF-process changes */
    class C33056 implements ViewType<BetterTextView> {
        final /* synthetic */ MemberRequestsAdapter f22903a;

        C33056(MemberRequestsAdapter memberRequestsAdapter) {
            this.f22903a = memberRequestsAdapter;
        }

        public final View mo12a(ViewGroup viewGroup) {
            return (BetterTextView) LayoutInflater.from(viewGroup.getContext()).inflate(2130904730, viewGroup, false);
        }
    }

    /* compiled from: TVMF-process changes */
    class C33067 implements ViewType<LinearLayout> {
        final /* synthetic */ MemberRequestsAdapter f22904a;

        C33067(MemberRequestsAdapter memberRequestsAdapter) {
            this.f22904a = memberRequestsAdapter;
        }

        public final View mo12a(ViewGroup viewGroup) {
            View linearLayout = new LinearLayout(viewGroup.getContext());
            linearLayout.setMinimumHeight(Math.round(viewGroup.getResources().getDimension(2131431927)));
            linearLayout.setBackgroundDrawable(new ColorDrawable(-1776412));
            return linearLayout;
        }
    }

    /* compiled from: TVMF-process changes */
    class C33078 implements ViewType<LinearLayout> {
        final /* synthetic */ MemberRequestsAdapter f22905a;

        C33078(MemberRequestsAdapter memberRequestsAdapter) {
            this.f22905a = memberRequestsAdapter;
        }

        public final View mo12a(ViewGroup viewGroup) {
            LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(viewGroup.getContext()).inflate(2130904726, viewGroup, false);
            View findViewById = linearLayout.findViewById(2131562790);
            Drawable mutate = this.f22905a.f22919m.getDrawable(2130840705).mutate();
            mutate.setColorFilter(this.f22905a.f22919m.getColor(2131363508), Mode.SRC_IN);
            findViewById.setBackgroundDrawable(mutate);
            ViewStub viewStub = (ViewStub) linearLayout.findViewById(2131562786);
            DefaultMemberRequestsNavigationHandler defaultMemberRequestsNavigationHandler = this.f22905a.f22923q;
            viewStub.setLayoutResource(2130904729);
            viewStub.inflate();
            return linearLayout;
        }
    }

    /* compiled from: TVMF-process changes */
    class C33089 implements ViewType<ImageBlockLayout> {
        final /* synthetic */ MemberRequestsAdapter f22906a;

        C33089(MemberRequestsAdapter memberRequestsAdapter) {
            this.f22906a = memberRequestsAdapter;
        }

        public final View mo12a(ViewGroup viewGroup) {
            return (ImageBlockLayout) LayoutInflater.from(viewGroup.getContext()).inflate(2130904691, viewGroup, false);
        }
    }

    @Inject
    public MemberRequestsAdapter(@Assisted C33141 c33141, @Assisted boolean z, DefaultMemberRequestsNavigationHandler defaultMemberRequestsNavigationHandler, UriIntentMapper uriIntentMapper, DefaultTimeFormatUtil defaultTimeFormatUtil, SecureContextHelper secureContextHelper, Resources resources) {
        this.f22921o = secureContextHelper;
        this.f22920n = uriIntentMapper;
        this.f22917k = c33141;
        this.f22919m = resources;
        this.f22922p = defaultTimeFormatUtil;
        this.f22923q = defaultMemberRequestsNavigationHandler;
        this.f22924r = z;
    }

    public final void m24029a(final FetchMemberRequestsModel fetchMemberRequestsModel, ImmutableList<EdgesModel> immutableList, MemberRequestsController memberRequestsController, boolean z, final boolean z2) {
        if (immutableList == null) {
            this.f22918l = RegularImmutableList.a;
            return;
        }
        ImmutableList.Builder builder = ImmutableList.builder();
        if (this.f22924r && fetchMemberRequestsModel != null) {
            builder.c(new AbstractSection<ImageBlockLayout>(this, this.f22916j) {
                final /* synthetic */ MemberRequestsAdapter f22891b;

                public final void mo11a(View view) {
                    ImageBlockLayout imageBlockLayout = (ImageBlockLayout) view;
                    if (fetchMemberRequestsModel == null || fetchMemberRequestsModel.m24150j() == null) {
                        imageBlockLayout.setVisibility(8);
                        return;
                    }
                    ((BetterTextView) imageBlockLayout.findViewById(2131562625)).setText(fetchMemberRequestsModel.m24150j().m24140l());
                    BetterTextView betterTextView = (BetterTextView) imageBlockLayout.findViewById(2131562626);
                    if (fetchMemberRequestsModel.m24150j().m24142n() != null) {
                        betterTextView.setText(fetchMemberRequestsModel.m24150j().m24142n().m24130a());
                    }
                    FbDraweeView fbDraweeView = (FbDraweeView) imageBlockLayout.findViewById(2131562624);
                    if (fetchMemberRequestsModel.m24150j().m24138j() == null || fetchMemberRequestsModel.m24150j().m24138j().m24057a() == null || fetchMemberRequestsModel.m24150j().m24138j().m24057a().m24053a() == null || fetchMemberRequestsModel.m24150j().m24138j().m24057a().m24053a().m24049a() == null) {
                        ((GenericDraweeHierarchy) fbDraweeView.getHierarchy()).b(2130843732);
                    } else {
                        String a = fetchMemberRequestsModel.m24150j().m24138j().m24057a().m24053a().m24049a();
                        ((GenericDraweeHierarchy) fbDraweeView.getHierarchy()).b(null);
                        fbDraweeView.a(Uri.parse(a), MemberRequestsAdapter.f22907a);
                    }
                    imageBlockLayout.setOnClickListener(new AnonymousClass10(this.f22891b, fetchMemberRequestsModel.m24151k(), fetchMemberRequestsModel.m24150j().m24140l()));
                    imageBlockLayout.setVisibility(0);
                }
            });
            builder.c(new StaticSection(this.f22914h));
        }
        if (!immutableList.isEmpty() || z) {
            for (int i = 0; i < immutableList.size(); i++) {
                final EdgesModel edgesModel = (EdgesModel) immutableList.get(i);
                if (edgesModel.m24109l() != null) {
                    Object obj;
                    String b = edgesModel.m24109l().m24096b();
                    if (memberRequestsController.f22934a.containsKey(b) && ((MemberRequestStates) memberRequestsController.f22934a.get(b)).equals(MemberRequestStates.MEMBER_REQUEST_ACCEPTED)) {
                        obj = 1;
                    } else {
                        obj = null;
                    }
                    if (obj != null) {
                        builder.c(new AbstractSection<LinearLayout>(this, this.f22915i) {
                            final /* synthetic */ MemberRequestsAdapter f22893b;

                            public final void mo11a(View view) {
                                LinearLayout linearLayout = (LinearLayout) view;
                                BetterTextView betterTextView = (BetterTextView) linearLayout.findViewById(2131562787);
                                if (!(edgesModel.m24109l() == null || edgesModel.m24109l().m24099l() == null)) {
                                    betterTextView.setText(edgesModel.m24109l().m24099l());
                                }
                                linearLayout.setOnClickListener(MemberRequestsAdapter.m24025a(this.f22893b, linearLayout.getContext(), edgesModel.m24109l().m24096b()));
                                FbDraweeView fbDraweeView = (FbDraweeView) linearLayout.findViewById(2131562799);
                                if (edgesModel.m24109l() == null || edgesModel.m24109l().m24100m() == null || edgesModel.m24109l().m24100m().m24087a() == null) {
                                    fbDraweeView.a(null, MemberRequestsAdapter.f22907a);
                                } else {
                                    fbDraweeView.a(Uri.parse(edgesModel.m24109l().m24100m().m24087a()), MemberRequestsAdapter.f22907a);
                                }
                            }
                        });
                    } else {
                        b = edgesModel.m24109l().m24096b();
                        if (memberRequestsController.f22934a.containsKey(b) && ((MemberRequestStates) memberRequestsController.f22934a.get(b)).equals(MemberRequestStates.MEMBER_REQUEST_IGNORED)) {
                            obj = 1;
                        } else {
                            obj = null;
                        }
                        if (obj != null) {
                            builder.c(new AbstractSection<LinearLayout>(this, this.f22910d) {
                                final /* synthetic */ MemberRequestsAdapter f22897b;

                                public final void mo11a(View view) {
                                    LinearLayout linearLayout = (LinearLayout) view;
                                    BetterTextView betterTextView = (BetterTextView) linearLayout.findViewById(2131562787);
                                    if (!(edgesModel.m24109l() == null || edgesModel.m24109l().m24099l() == null)) {
                                        betterTextView.setText(edgesModel.m24109l().m24099l());
                                    }
                                    linearLayout.setOnClickListener(MemberRequestsAdapter.m24025a(this.f22897b, linearLayout.getContext(), edgesModel.m24109l().m24096b()));
                                    FbDraweeView fbDraweeView = (FbDraweeView) linearLayout.findViewById(2131562799);
                                    if (edgesModel.m24109l() == null || edgesModel.m24109l().m24100m() == null || edgesModel.m24109l().m24100m().m24087a() == null) {
                                        fbDraweeView.a(null, MemberRequestsAdapter.f22907a);
                                    } else {
                                        fbDraweeView.a(Uri.parse(edgesModel.m24109l().m24100m().m24087a()), MemberRequestsAdapter.f22907a);
                                    }
                                }
                            });
                        } else {
                            b = edgesModel.m24109l().m24096b();
                            if (memberRequestsController.f22934a.containsKey(b) && ((MemberRequestStates) memberRequestsController.f22934a.get(b)).equals(MemberRequestStates.MEMBER_REQUEST_BLOCKED)) {
                                obj = 1;
                            } else {
                                obj = null;
                            }
                            if (obj != null) {
                                builder.c(new AbstractSection<LinearLayout>(this, this.f22911e) {
                                    final /* synthetic */ MemberRequestsAdapter f22895b;

                                    public final void mo11a(View view) {
                                        LinearLayout linearLayout = (LinearLayout) view;
                                        BetterTextView betterTextView = (BetterTextView) linearLayout.findViewById(2131562787);
                                        if (!(edgesModel.m24109l() == null || edgesModel.m24109l().m24099l() == null)) {
                                            betterTextView.setText(edgesModel.m24109l().m24099l());
                                        }
                                        linearLayout.setOnClickListener(MemberRequestsAdapter.m24025a(this.f22895b, linearLayout.getContext(), edgesModel.m24109l().m24096b()));
                                        FbDraweeView fbDraweeView = (FbDraweeView) linearLayout.findViewById(2131562799);
                                        if (edgesModel.m24109l() == null || edgesModel.m24109l().m24100m() == null || edgesModel.m24109l().m24100m().m24087a() == null) {
                                            fbDraweeView.a(null, MemberRequestsAdapter.f22907a);
                                        } else {
                                            fbDraweeView.a(Uri.parse(edgesModel.m24109l().m24100m().m24087a()), MemberRequestsAdapter.f22907a);
                                        }
                                    }
                                });
                            } else {
                                builder.c(new AbstractSection<LinearLayout>(this, this.f22909c) {
                                    final /* synthetic */ MemberRequestsAdapter f22886c;

                                    public final void mo11a(View view) {
                                        view = (LinearLayout) view;
                                        Context context = view.getContext();
                                        BetterTextView betterTextView = (BetterTextView) view.findViewById(2131562787);
                                        if (!(edgesModel.m24109l() == null || edgesModel.m24109l().m24099l() == null)) {
                                            betterTextView.setText(edgesModel.m24109l().m24099l());
                                            betterTextView.setOnClickListener(MemberRequestsAdapter.m24025a(this.f22886c, view.getContext(), edgesModel.m24109l().m24096b()));
                                        }
                                        betterTextView = (BetterTextView) view.findViewById(2131562795);
                                        if (edgesModel.m24109l() == null || edgesModel.m24109l().m24098k() == null || edgesModel.m24109l().m24098k().m24079a() <= 0) {
                                            betterTextView.setVisibility(8);
                                        } else {
                                            betterTextView.setText(this.f22886c.f22919m.getQuantityString(2131689817, edgesModel.m24109l().m24098k().m24079a(), new Object[]{Integer.valueOf(edgesModel.m24109l().m24098k().m24079a())}));
                                            betterTextView.setVisibility(0);
                                        }
                                        FbDraweeView fbDraweeView = (FbDraweeView) view.findViewById(2131562799);
                                        if (edgesModel.m24109l() != null) {
                                            fbDraweeView.setOnClickListener(MemberRequestsAdapter.m24025a(this.f22886c, view.getContext(), edgesModel.m24109l().m24096b()));
                                        }
                                        if (edgesModel.m24109l() == null || edgesModel.m24109l().m24100m() == null || edgesModel.m24109l().m24100m().m24087a() == null) {
                                            fbDraweeView.a(null, MemberRequestsAdapter.f22907a);
                                        } else {
                                            fbDraweeView.a(Uri.parse(edgesModel.m24109l().m24100m().m24087a()), MemberRequestsAdapter.f22907a);
                                        }
                                        fbDraweeView.setContentDescription(view.getContext().getString(2131242217, new Object[]{edgesModel.m24109l().m24099l()}));
                                        MemberRequestsAdapter.m24026a(this.f22886c, edgesModel, view);
                                        FbButton fbButton = (FbButton) view.findViewById(2131562796);
                                        fbButton.setOnClickListener(new AnonymousClass11(this.f22886c, edgesModel));
                                        fbButton.setText(context.getResources().getString(2131242213));
                                        fbButton = (FbButton) view.findViewById(2131562797);
                                        fbButton.setOnClickListener(new AnonymousClass12(this.f22886c, edgesModel));
                                        fbButton.setText(context.getResources().getString(2131242215));
                                        fbButton = (FbButton) view.findViewById(2131562798);
                                        if (z2) {
                                            fbButton.setOnClickListener(new AnonymousClass13(this.f22886c, edgesModel));
                                            fbButton.setText(view.getContext().getResources().getString(2131242216));
                                            return;
                                        }
                                        fbButton.setVisibility(4);
                                    }
                                });
                            }
                        }
                    }
                }
                builder.c(new StaticSection(this.f22914h));
            }
            if (z) {
                builder.c(new StaticSection(this.f22908b));
            }
            this.f22918l = builder.b();
            AdapterDetour.a(this, 985325637);
            return;
        }
        builder.c(new StaticSection(this.f22913g));
        this.f22918l = builder.b();
        AdapterDetour.a(this, 1654993635);
    }

    public final void m24028a(int i, Object obj, View view, int i2, ViewGroup viewGroup) {
        ((Section) obj).mo11a(view);
    }

    public int getItemViewType(int i) {
        return this.f22925s.indexOf(((Section) this.f22918l.get(i)).mo10a());
    }

    public int getViewTypeCount() {
        return this.f22925s.size();
    }

    public final View m24027a(int i, ViewGroup viewGroup) {
        return ((ViewType) this.f22925s.get(i)).mo12a(viewGroup);
    }

    public int getCount() {
        this.f22918l.size();
        return this.f22918l.size();
    }

    public Object getItem(int i) {
        return this.f22918l.get(i);
    }

    public long getItemId(int i) {
        return (long) i;
    }

    public static void m24026a(MemberRequestsAdapter memberRequestsAdapter, EdgesModel edgesModel, View view) {
        long n;
        String a;
        BetterTextView betterTextView = (BetterTextView) view.findViewById(2131562793);
        if (edgesModel.m24109l() != null) {
            n = edgesModel.m24109l().m24101n();
        } else {
            n = 0;
        }
        if (n > 0) {
            a = memberRequestsAdapter.f22922p.a(TimeFormatStyle.STREAM_RELATIVE_STYLE, n * 1000);
            betterTextView.setText(memberRequestsAdapter.f22919m.getString(2131242220, new Object[]{a}));
        }
        a = memberRequestsAdapter.f22919m.getString(2131237821);
        betterTextView = (BetterTextView) view.findViewById(2131562792);
        CharSequence a2 = memberRequestsAdapter.f22922p.a(TimeFormatStyle.STREAM_RELATIVE_STYLE, edgesModel.m24110m() * 1000);
        if (edgesModel.m24108k() != null && !edgesModel.m24108k().m24068j().equals(edgesModel.m24109l().m24096b())) {
            betterTextView.setText(a2 + " " + a + " " + memberRequestsAdapter.f22919m.getString(2131242221, new Object[]{edgesModel.m24108k().m24069k()}));
        } else if (edgesModel.m24107j() > 0) {
            betterTextView.setText(a2 + " " + a + " " + memberRequestsAdapter.f22919m.getQuantityString(2131689704, edgesModel.m24107j(), new Object[]{Integer.valueOf(edgesModel.m24107j())}));
        } else {
            betterTextView.setText(a2);
        }
        betterTextView = (BetterTextView) view.findViewById(2131562794);
        if (edgesModel.m24109l().m24097j() == null || edgesModel.m24109l().m24097j().m24073a() <= 0) {
            betterTextView.setVisibility(8);
            return;
        }
        betterTextView.setText(memberRequestsAdapter.f22919m.getQuantityString(2131689816, edgesModel.m24109l().m24097j().m24073a(), new Object[]{Integer.valueOf(edgesModel.m24109l().m24097j().m24073a())}));
        betterTextView.setVisibility(0);
    }

    public static OnClickListener m24025a(MemberRequestsAdapter memberRequestsAdapter, final Context context, final String str) {
        return new OnClickListener(memberRequestsAdapter) {
            final /* synthetic */ MemberRequestsAdapter f22889c;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, 596896831);
                Activity activity = (Activity) ContextUtils.a(context, Activity.class);
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("profile/").append(str).append("?skip_popup");
                this.f22889c.f22921o.b(this.f22889c.f22920n.a(activity, FBLinks.a(stringBuilder.toString())), activity);
                Logger.a(2, EntryType.UI_INPUT_END, -223205245, a);
            }
        };
    }
}
