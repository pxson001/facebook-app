package com.facebook.groups.editsettings.fragment;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.facebook.base.fragment.FbFragment;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.fbui.dialog.AlertDialog.Builder;
import com.facebook.flatbuffers.helpers.FlatBufferModelHelper;
import com.facebook.graphql.calls.GroupEditInputData.GroupPurpose;
import com.facebook.graphql.executor.GraphQLCachePolicy;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.graphql.query.GraphQlQueryString;
import com.facebook.groups.editsettings.GroupEditSettingsController;
import com.facebook.groups.editsettings.annotation.EditGroupPurposeNavigationHandler;
import com.facebook.groups.editsettings.protocol.FetchGroupPossiblePurposes.FetchGroupPossiblePurposesString;
import com.facebook.groups.editsettings.protocol.FetchGroupPossiblePurposesModels.FetchGroupPossiblePurposesModel;
import com.facebook.groups.editsettings.protocol.FetchGroupSettingsModels.FetchGroupSettingsModel;
import com.facebook.groups.editsettings.protocol.GroupPurposeFragmentModels.GroupPurposeModel;
import com.facebook.groups.navigation.DefaultGroupsEditNavigationHandler;
import com.facebook.inject.FbInjector;
import com.facebook.inject.InjectorLike;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.ui.futures.TasksManager;
import com.facebook.widget.recyclerview.DividerDecorator;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Callable;
import javax.inject.Inject;

/* compiled from: Unexpected failure of GetPendingAppCallForMediaUploadOperation call. */
public class GroupEditPurposeFragment extends FbFragment {
    @Inject
    Resources f21645a;
    public final C30961 al = new C30961(this);
    private final OnClickListener am = new C30972(this);
    @Inject
    GraphQLQueryExecutor f21646b;
    @Inject
    GroupEditSettingsController f21647c;
    @Inject
    public TasksManager f21648d;
    @Inject
    @EditGroupPurposeNavigationHandler
    DefaultGroupsEditNavigationHandler f21649e;
    public FetchGroupSettingsModel f21650f;
    public FetchGroupPossiblePurposesModel f21651g;
    public GroupPossiblePurposeListAdapter f21652h;
    public RecyclerView f21653i;

    /* compiled from: Unexpected failure of GetPendingAppCallForMediaUploadOperation call. */
    public class C30961 {
        public final /* synthetic */ GroupEditPurposeFragment f21641a;

        C30961(GroupEditPurposeFragment groupEditPurposeFragment) {
            this.f21641a = groupEditPurposeFragment;
        }
    }

    /* compiled from: Unexpected failure of GetPendingAppCallForMediaUploadOperation call. */
    class C30972 implements OnClickListener {
        final /* synthetic */ GroupEditPurposeFragment f21642a;

        C30972(GroupEditPurposeFragment groupEditPurposeFragment) {
            this.f21642a = groupEditPurposeFragment;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 2143553735);
            if (GroupEditPurposeFragment.m22613e(this.f21642a)) {
                int i;
                GroupEditPurposeFragment groupEditPurposeFragment = this.f21642a;
                if (!GroupEditPurposeFragment.m22613e(groupEditPurposeFragment)) {
                    i = 0;
                } else if (groupEditPurposeFragment.f21650f.m22806q() == null || groupEditPurposeFragment.f21650f.m22806q().m22733a() == null || groupEditPurposeFragment.f21650f.m22806q().m22733a().isEmpty()) {
                    i = 1;
                } else {
                    i = !groupEditPurposeFragment.f21652h.f21670b.m22863j().equals(((GroupPurposeModel) groupEditPurposeFragment.f21650f.m22806q().m22733a().get(0)).m22863j()) ? 1 : 0;
                }
                if (i != 0) {
                    this.f21642a.f21647c.m22537a(this.f21642a.f21650f.m22807r(), (GroupPurpose) Enum.valueOf(GroupPurpose.class, this.f21642a.f21652h.f21670b.m22863j().toString()), this.f21642a.al);
                } else {
                    this.f21642a.o().onBackPressed();
                }
            } else {
                GroupEditPurposeFragment.m22611a(this.f21642a, this.f21642a.jW_().getString(2131242173), this.f21642a.jW_().getString(2131242172));
            }
            LogUtils.a(251506588, a);
        }
    }

    /* compiled from: Unexpected failure of GetPendingAppCallForMediaUploadOperation call. */
    public class C30983 implements Callable<ListenableFuture> {
        final /* synthetic */ GroupEditPurposeFragment f21643a;

        public C30983(GroupEditPurposeFragment groupEditPurposeFragment) {
            this.f21643a = groupEditPurposeFragment;
        }

        public Object call() {
            if (this.f21643a.f21650f == null) {
                return null;
            }
            GraphQlQueryString fetchGroupPossiblePurposesString = new FetchGroupPossiblePurposesString();
            fetchGroupPossiblePurposesString.a("group_id", this.f21643a.f21650f.m22807r());
            fetchGroupPossiblePurposesString.a("purpose_pog_size", Integer.valueOf(this.f21643a.f21645a.getDimensionPixelSize(2131434292)));
            fetchGroupPossiblePurposesString.a("purpose_default_cover_photo_size", Integer.valueOf(this.f21643a.f21645a.getDimensionPixelSize(2131434292)));
            GraphQLQueryExecutor graphQLQueryExecutor = this.f21643a.f21646b;
            GraphQLRequest a = GraphQLRequest.a(fetchGroupPossiblePurposesString).a(GraphQLCachePolicy.d);
            a.b = true;
            return graphQLQueryExecutor.a(a);
        }
    }

    /* compiled from: Unexpected failure of GetPendingAppCallForMediaUploadOperation call. */
    public class C30994 extends AbstractDisposableFutureCallback<GraphQLResult<FetchGroupPossiblePurposesModel>> {
        final /* synthetic */ GroupEditPurposeFragment f21644a;

        public C30994(GroupEditPurposeFragment groupEditPurposeFragment) {
            this.f21644a = groupEditPurposeFragment;
        }

        protected final void m22608a(Object obj) {
            GraphQLResult graphQLResult = (GraphQLResult) obj;
            if (graphQLResult != null && graphQLResult.e != null) {
                this.f21644a.f21651g = (FetchGroupPossiblePurposesModel) graphQLResult.e;
                GroupPurposeModel groupPurposeModel = null;
                if (!(this.f21644a.f21650f.m22806q() == null || this.f21644a.f21650f.m22806q().m22733a() == null || this.f21644a.f21650f.m22806q().m22733a().isEmpty())) {
                    groupPurposeModel = (GroupPurposeModel) this.f21644a.f21650f.m22806q().m22733a().get(0);
                }
                this.f21644a.f21652h = new GroupPossiblePurposeListAdapter(this.f21644a.f21651g.m22693a(), groupPurposeModel);
                this.f21644a.f21653i.setAdapter(this.f21644a.f21652h);
            }
        }

        protected final void m22609a(Throwable th) {
        }
    }

    public static void m22612a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        ((GroupEditPurposeFragment) obj).m22610a(ResourcesMethodAutoProvider.a(injectorLike), GraphQLQueryExecutor.a(injectorLike), GroupEditSettingsController.m22535b(injectorLike), TasksManager.b(injectorLike), DefaultGroupsEditNavigationHandler.b(injectorLike));
    }

    public static void m22611a(GroupEditPurposeFragment groupEditPurposeFragment, CharSequence charSequence, CharSequence charSequence2) {
        new Builder(groupEditPurposeFragment.getContext()).a(charSequence).b(charSequence2).a(groupEditPurposeFragment.f21645a.getString(2131230726), null).b();
    }

    public final View m22615a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1828014666);
        View inflate = layoutInflater.inflate(2130903872, viewGroup, false);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -279618623, a);
        return inflate;
    }

    public final void m22617c(Bundle bundle) {
        super.c(bundle);
        Class cls = GroupEditPurposeFragment.class;
        m22612a((Object) this, getContext());
    }

    public final void m22616a(View view, Bundle bundle) {
        super.a(view, bundle);
        this.f21650f = (FetchGroupSettingsModel) FlatBufferModelHelper.a(this.s, "group_edit_name_description_data");
        this.f21653i = (RecyclerView) e(2131560939);
        this.f21653i.a(new DividerDecorator(this.f21645a.getColor(2131363505), this.f21645a.getDimensionPixelSize(2131427379)));
        this.f21653i.setLayoutManager(new LinearLayoutManager(o()));
        Object obj = null;
        if (!(this.f21650f.m22806q() == null || this.f21650f.m22806q().m22733a() == null || this.f21650f.m22806q().m22733a().isEmpty())) {
            obj = 1;
        }
        this.f21649e.a(this, this.f21645a.getString(obj != null ? 2131242124 : 2131242123), this.f21645a.getString(2131242125), null, this.am);
        this.f21648d.a("fetch_group_possible_purposes", new C30983(this), new C30994(this));
    }

    public final void m22614I() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1850545374);
        super.I();
        this.f21648d.c();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 563188770, a);
    }

    private void m22610a(Resources resources, GraphQLQueryExecutor graphQLQueryExecutor, GroupEditSettingsController groupEditSettingsController, TasksManager tasksManager, DefaultGroupsEditNavigationHandler defaultGroupsEditNavigationHandler) {
        this.f21645a = resources;
        this.f21646b = graphQLQueryExecutor;
        this.f21647c = groupEditSettingsController;
        this.f21648d = tasksManager;
        this.f21649e = defaultGroupsEditNavigationHandler;
    }

    public static boolean m22613e(GroupEditPurposeFragment groupEditPurposeFragment) {
        if (groupEditPurposeFragment.f21650f == null || groupEditPurposeFragment.f21652h == null || groupEditPurposeFragment.f21652h.f21670b == null) {
            return false;
        }
        return true;
    }
}
