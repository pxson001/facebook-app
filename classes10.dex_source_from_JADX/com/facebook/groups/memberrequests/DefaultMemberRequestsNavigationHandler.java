package com.facebook.groups.memberrequests;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import com.facebook.base.fragment.FbFragment;
import com.facebook.fbui.glyph.GlyphColorizer;
import com.facebook.fig.bottomsheet.FigBottomSheetAdapter;
import com.facebook.graphql.calls.GraphQlCallInput;
import com.facebook.graphql.calls.GroupApproveAllPendingMembersInputData;
import com.facebook.graphql.calls.GroupApproveAllPendingMembersInputData.Source;
import com.facebook.graphql.calls.GroupRejectAllPendingMembersInputData;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.query.GraphQlQueryString;
import com.facebook.groups.memberrequests.MemberRequestsController.C33124;
import com.facebook.groups.memberrequests.MemberRequestsController.C33135;
import com.facebook.groups.memberrequests.protocol.MemberRequestsMutations.GroupApproveAllPendingMembersMutationString;
import com.facebook.groups.memberrequests.protocol.MemberRequestsMutations.GroupRejectAllPendingMembersMutationString;
import com.facebook.inject.InjectorLike;
import com.facebook.widget.bottomsheet.BottomSheetDialog;
import com.facebook.widget.titlebar.FbTitleBar.OnToolbarButtonListener;
import com.facebook.widget.titlebar.TitleBarButtonSpec;
import com.google.common.util.concurrent.Futures;
import javax.inject.Inject;

/* compiled from: TVMF.update */
public class DefaultMemberRequestsNavigationHandler {
    public final MemberRequestsController f22870a;
    public GlyphColorizer f22871b;
    public String f22872c;

    /* compiled from: TVMF.update */
    public class C32951 extends OnToolbarButtonListener {
        final /* synthetic */ FbFragment f22864a;
        final /* synthetic */ DefaultMemberRequestsNavigationHandler f22865b;

        public C32951(DefaultMemberRequestsNavigationHandler defaultMemberRequestsNavigationHandler, FbFragment fbFragment) {
            this.f22865b = defaultMemberRequestsNavigationHandler;
            this.f22864a = fbFragment;
        }

        public final void m24008a(View view, TitleBarButtonSpec titleBarButtonSpec) {
            DefaultMemberRequestsNavigationHandler defaultMemberRequestsNavigationHandler = this.f22865b;
            FbFragment fbFragment = this.f22864a;
            BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(view.getContext());
            FigBottomSheetAdapter figBottomSheetAdapter = new FigBottomSheetAdapter(view.getContext());
            figBottomSheetAdapter.a(fbFragment.getContext().getResources().getString(2131242212)).setOnMenuItemClickListener(new C32962(defaultMemberRequestsNavigationHandler, fbFragment)).setIcon(defaultMemberRequestsNavigationHandler.f22871b.a(2130839774, 2131361938));
            figBottomSheetAdapter.a(fbFragment.getContext().getResources().getString(2131242210)).setOnMenuItemClickListener(new C32973(defaultMemberRequestsNavigationHandler, fbFragment)).setIcon(defaultMemberRequestsNavigationHandler.f22871b.a(2130839815, 2131361938));
            bottomSheetDialog.a(figBottomSheetAdapter);
            bottomSheetDialog.show();
        }
    }

    /* compiled from: TVMF.update */
    public class C32962 implements OnMenuItemClickListener {
        final /* synthetic */ FbFragment f22866a;
        final /* synthetic */ DefaultMemberRequestsNavigationHandler f22867b;

        public C32962(DefaultMemberRequestsNavigationHandler defaultMemberRequestsNavigationHandler, FbFragment fbFragment) {
            this.f22867b = defaultMemberRequestsNavigationHandler;
            this.f22866a = fbFragment;
        }

        public boolean onMenuItemClick(MenuItem menuItem) {
            MemberRequestsController memberRequestsController = this.f22867b.f22870a;
            String str = this.f22867b.f22872c;
            this.f22866a.getContext();
            GroupApproveAllPendingMembersInputData groupApproveAllPendingMembersInputData = new GroupApproveAllPendingMembersInputData();
            groupApproveAllPendingMembersInputData.a("actor_id", memberRequestsController.f22936c);
            GraphQlCallInput graphQlCallInput = groupApproveAllPendingMembersInputData;
            graphQlCallInput.a("group_id", str);
            graphQlCallInput = graphQlCallInput;
            graphQlCallInput.a("source", Source.UNKNOWN);
            graphQlCallInput = graphQlCallInput;
            GraphQlQueryString groupApproveAllPendingMembersMutationString = new GroupApproveAllPendingMembersMutationString();
            groupApproveAllPendingMembersMutationString.a("input", graphQlCallInput);
            Futures.a(memberRequestsController.f22937d.a(GraphQLRequest.a(groupApproveAllPendingMembersMutationString)), new C33124(memberRequestsController), memberRequestsController.f22935b);
            this.f22866a.o().onBackPressed();
            return true;
        }
    }

    /* compiled from: TVMF.update */
    public class C32973 implements OnMenuItemClickListener {
        final /* synthetic */ FbFragment f22868a;
        final /* synthetic */ DefaultMemberRequestsNavigationHandler f22869b;

        public C32973(DefaultMemberRequestsNavigationHandler defaultMemberRequestsNavigationHandler, FbFragment fbFragment) {
            this.f22869b = defaultMemberRequestsNavigationHandler;
            this.f22868a = fbFragment;
        }

        public boolean onMenuItemClick(MenuItem menuItem) {
            MemberRequestsController memberRequestsController = this.f22869b.f22870a;
            String str = this.f22869b.f22872c;
            this.f22868a.getContext();
            GroupRejectAllPendingMembersInputData groupRejectAllPendingMembersInputData = new GroupRejectAllPendingMembersInputData();
            groupRejectAllPendingMembersInputData.a("actor_id", memberRequestsController.f22936c);
            GraphQlCallInput graphQlCallInput = groupRejectAllPendingMembersInputData;
            graphQlCallInput.a("group_id", str);
            graphQlCallInput = graphQlCallInput;
            graphQlCallInput.a("source", GroupRejectAllPendingMembersInputData.Source.UNKNOWN);
            graphQlCallInput = graphQlCallInput;
            GraphQlQueryString groupRejectAllPendingMembersMutationString = new GroupRejectAllPendingMembersMutationString();
            groupRejectAllPendingMembersMutationString.a("input", graphQlCallInput);
            Futures.a(memberRequestsController.f22937d.a(GraphQLRequest.a(groupRejectAllPendingMembersMutationString)), new C33135(memberRequestsController), memberRequestsController.f22935b);
            this.f22868a.o().onBackPressed();
            return true;
        }
    }

    public static DefaultMemberRequestsNavigationHandler m24009b(InjectorLike injectorLike) {
        return new DefaultMemberRequestsNavigationHandler(MemberRequestsController.m24030b(injectorLike), GlyphColorizer.a(injectorLike));
    }

    @Inject
    public DefaultMemberRequestsNavigationHandler(MemberRequestsController memberRequestsController, GlyphColorizer glyphColorizer) {
        this.f22870a = memberRequestsController;
        this.f22871b = glyphColorizer;
    }
}
