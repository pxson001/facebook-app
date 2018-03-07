package com.facebook.platform.composer.targetprivacy;

import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.facebook.base.fragment.FbFragment;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.common.util.StringUtil;
import com.facebook.funnellogger.FunnelLoggerImpl;
import com.facebook.funnellogger.FunnelRegistry;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.querybuilder.common.GraphQlQueryDefaults;
import com.facebook.groups.groupsasprofiles.protocol.FetchGroupGraphQL;
import com.facebook.groups.groupsasprofiles.protocol.FetchGroupGraphQL.GroupsQueryString;
import com.facebook.inject.FbInjector;
import com.facebook.ipc.composer.intent.ComposerTargetData;
import com.facebook.ipc.composer.intent.ComposerTargetData.Builder;
import com.facebook.ipc.composer.model.TargetType;
import com.facebook.ipc.model.FacebookProfile;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.platform.composer.composer.PlatformComposerControllerFragment.C05061;
import com.facebook.platform.composer.composer.PlatformComposerControllerFragment.C05094;
import com.facebook.platform.composer.targetprivacy.PlatformComposerFetchGroupRequest.C05491;
import com.facebook.platform.composer.targetprivacy.PlatformComposerFetchGroupRequest.GroupOrder;
import com.facebook.resources.ui.FbEditText;
import com.facebook.resources.ui.FbTextView;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.ui.futures.TasksManager;
import com.facebook.ui.toaster.ToastBuilder;
import com.facebook.ui.toaster.Toaster;
import com.facebook.widget.listview.BetterListView;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.MoreExecutors.DirectExecutor;
import java.util.List;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: results_module_extra_logging */
public class PlatformComposerGroupFragment extends FbFragment {
    public PlatformGroupSelectorAdapter f4326a;
    public C05094 al;
    public boolean am;
    private final OnItemClickListener an = new C05551(this);
    public C05061 ao;
    protected BetterListView f4327b;
    @Inject
    public PlatformComposerFetchGroupRequest f4328c;
    @Inject
    public TasksManager f4329d;
    @Inject
    public Toaster f4330e;
    @Inject
    public FunnelLoggerImpl f4331f;
    public FbEditText f4332g;
    public FbTextView f4333h;
    public View f4334i;

    /* compiled from: results_module_extra_logging */
    class C05551 implements OnItemClickListener {
        final /* synthetic */ PlatformComposerGroupFragment f4321a;

        C05551(PlatformComposerGroupFragment platformComposerGroupFragment) {
            this.f4321a = platformComposerGroupFragment;
        }

        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            PlatformComposerGroupFragment platformComposerGroupFragment = this.f4321a;
            FacebookProfile facebookProfile = (FacebookProfile) platformComposerGroupFragment.f4326a.getItem(i);
            Builder builder = new Builder(facebookProfile.mId, TargetType.GROUP);
            builder.c = facebookProfile.mDisplayName;
            ComposerTargetData a = builder.a();
            if (platformComposerGroupFragment.ao != null) {
                platformComposerGroupFragment.ao.m3966a(a);
            }
            platformComposerGroupFragment.f4331f.b(FunnelRegistry.l, "target_privacy_picker_group_selected");
        }
    }

    /* compiled from: results_module_extra_logging */
    class C05562 implements TextWatcher {
        final /* synthetic */ PlatformComposerGroupFragment f4322a;

        C05562(PlatformComposerGroupFragment platformComposerGroupFragment) {
            this.f4322a = platformComposerGroupFragment;
        }

        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            this.f4322a.f4326a.getFilter().filter(charSequence);
        }

        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public void afterTextChanged(Editable editable) {
        }
    }

    /* compiled from: results_module_extra_logging */
    class C05573 implements Runnable {
        final /* synthetic */ PlatformComposerGroupFragment f4323a;

        C05573(PlatformComposerGroupFragment platformComposerGroupFragment) {
            this.f4323a = platformComposerGroupFragment;
        }

        public void run() {
            ((InputMethodManager) this.f4323a.o().getSystemService("input_method")).showSoftInput(this.f4323a.f4332g, 0);
        }
    }

    /* compiled from: results_module_extra_logging */
    class C05584 implements OnClickListener {
        final /* synthetic */ PlatformComposerGroupFragment f4324a;

        C05584(PlatformComposerGroupFragment platformComposerGroupFragment) {
            this.f4324a = platformComposerGroupFragment;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 1862438994);
            if (this.f4324a.al != null) {
                this.f4324a.al.m3969a(90);
            }
            Logger.a(2, EntryType.UI_INPUT_END, 884691605, a);
        }
    }

    /* compiled from: results_module_extra_logging */
    class C05595 extends AbstractDisposableFutureCallback<List<FacebookProfile>> {
        final /* synthetic */ PlatformComposerGroupFragment f4325a;

        C05595(PlatformComposerGroupFragment platformComposerGroupFragment) {
            this.f4325a = platformComposerGroupFragment;
        }

        protected final void m4229a(Object obj) {
            List list = (List) obj;
            PlatformComposerGroupFragment.m4232b(this.f4325a, false);
            this.f4325a.f4326a.mo62a(list);
            if (!StringUtil.a(new CharSequence[]{this.f4325a.f4332g.getText()})) {
                this.f4325a.f4326a.getFilter().filter(this.f4325a.f4332g.getText());
            }
            this.f4325a.f4333h.setVisibility(8);
        }

        protected final void m4230a(Throwable th) {
            PlatformComposerGroupFragment.m4232b(this.f4325a, false);
            this.f4325a.f4330e.b(new ToastBuilder(2131237362));
        }
    }

    public static void m4231a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        PlatformComposerGroupFragment platformComposerGroupFragment = (PlatformComposerGroupFragment) obj;
        PlatformComposerFetchGroupRequest platformComposerFetchGroupRequest = new PlatformComposerFetchGroupRequest(GraphQLQueryExecutor.a(fbInjector));
        TasksManager b = TasksManager.b(fbInjector);
        Toaster b2 = Toaster.b(fbInjector);
        FunnelLoggerImpl a = FunnelLoggerImpl.a(fbInjector);
        platformComposerGroupFragment.f4328c = platformComposerFetchGroupRequest;
        platformComposerGroupFragment.f4329d = b;
        platformComposerGroupFragment.f4330e = b2;
        platformComposerGroupFragment.f4331f = a;
    }

    public static PlatformComposerGroupFragment m4233n(Bundle bundle) {
        PlatformComposerGroupFragment platformComposerGroupFragment = new PlatformComposerGroupFragment();
        platformComposerGroupFragment.g(bundle);
        return platformComposerGroupFragment;
    }

    public final void m4237c(Bundle bundle) {
        super.c(bundle);
        Class cls = PlatformComposerGroupFragment.class;
        m4231a(this, getContext());
    }

    public final View m4236a(LayoutInflater layoutInflater, ViewGroup viewGroup, @Nullable Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 380752090);
        ViewGroup viewGroup2 = (ViewGroup) layoutInflater.inflate(2130906312, viewGroup, false);
        View findViewById = viewGroup2.findViewById(2131566122);
        this.f4332g = (FbEditText) viewGroup2.findViewById(2131566123);
        this.f4332g.addTextChangedListener(new C05562(this));
        this.f4332g.setFocusable(this.am);
        if (this.am) {
            this.f4332g.requestFocus();
            this.f4332g.postDelayed(new C05573(this), 100);
        } else {
            OnClickListener c05584 = new C05584(this);
            this.f4332g.setOnClickListener(c05584);
            findViewById.setOnClickListener(c05584);
        }
        findViewById = viewGroup2.findViewById(16908292);
        this.f4327b = (BetterListView) viewGroup2.findViewById(16908298);
        this.f4327b.setEmptyView(findViewById);
        this.f4327b.setOnItemClickListener(this.an);
        this.f4326a = new PlatformGroupSelectorAdapter(getContext());
        this.f4327b.setAdapter(this.f4326a);
        this.f4333h = (FbTextView) viewGroup2.findViewById(2131561172);
        this.f4334i = viewGroup2.findViewById(2131561173);
        if (this.f4333h != null) {
            this.f4333h.setText(2131237363);
        }
        LogUtils.f(1868335431, a);
        return viewGroup2;
    }

    public final void m4234G() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1954607774);
        super.G();
        m4232b(this, true);
        PlatformComposerFetchGroupRequest platformComposerFetchGroupRequest = this.f4328c;
        GroupOrder groupOrder = GroupOrder.IMPORTANCE;
        GroupsQueryString a2 = FetchGroupGraphQL.m498a();
        a2.a("group_order", groupOrder.getOrderList()).a("scale", GraphQlQueryDefaults.a());
        this.f4329d.a("fetchGroups", Futures.a(platformComposerFetchGroupRequest.f4299a.a(GraphQLRequest.a(a2)), new C05491(platformComposerFetchGroupRequest), DirectExecutor.INSTANCE), new C05595(this));
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -93377699, a);
    }

    public final void m4235H() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 426964041);
        super.H();
        this.f4329d.c();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -1451215260, a);
    }

    public static void m4232b(PlatformComposerGroupFragment platformComposerGroupFragment, boolean z) {
        int i;
        if (z) {
            platformComposerGroupFragment.f4333h.setVisibility(8);
            platformComposerGroupFragment.f4334i.setVisibility(0);
        } else {
            platformComposerGroupFragment.f4333h.setVisibility(0);
            platformComposerGroupFragment.f4334i.setVisibility(8);
        }
        int i2 = 8;
        if (z) {
            i = 0;
        } else {
            i = 8;
        }
        if (!z) {
            i2 = 0;
        }
        platformComposerGroupFragment.f4334i.setVisibility(i);
        platformComposerGroupFragment.f4333h.setVisibility(i2);
    }
}
