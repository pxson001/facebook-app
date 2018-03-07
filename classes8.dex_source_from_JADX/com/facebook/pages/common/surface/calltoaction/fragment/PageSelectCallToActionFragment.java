package com.facebook.pages.common.surface.calltoaction.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.facebook.base.fragment.CanHandleBackPressed;
import com.facebook.base.fragment.FbFragment;
import com.facebook.fbui.widget.layout.ImageBlockLayout;
import com.facebook.fbui.widget.layout.SegmentedLinearLayout;
import com.facebook.flatbuffers.helpers.FlatBufferModelHelper;
import com.facebook.funnellogger.FunnelLoggerImpl;
import com.facebook.funnellogger.FunnelRegistry;
import com.facebook.inject.FbInjector;
import com.facebook.inject.InjectorLike;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.pages.common.surface.calltoaction.analytics.PageCallToActionAnalytics;
import com.facebook.pages.common.surface.calltoaction.graphql.PageAdminCallToActionGraphQLModels.CallToActionAdminConfigModel;
import com.facebook.pages.common.surface.calltoaction.graphql.PageAdminCallToActionGraphQLModels.PageAdminCallToActionModel;
import com.facebook.pages.common.surface.calltoaction.graphql.PageAdminCallToActionGraphQLModels.PageAdminCallToActionModel.PageCallToActionModel.CtaAdminInfoModel.EligibleCallToActionsModel;
import com.facebook.pages.common.surface.calltoaction.ui.PageSelectCallToActionTypeView;
import com.facebook.pages.common.surface.calltoaction.util.PageCallToActionUtil;
import com.facebook.resources.ui.FbTextView;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.widget.FbScrollView;
import com.facebook.widget.titlebar.HasTitleBar;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map.Entry;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: create_home_from_place_creation */
public class PageSelectCallToActionFragment extends FbFragment implements CanHandleBackPressed {
    public static int al = 0;
    @Inject
    public PageCallToActionUtil f16690a;
    @Inject
    public PageCallToActionAnalytics f16691b;
    @Inject
    public FunnelLoggerImpl f16692c;
    public PageAdminCallToActionModel f16693d;
    public String f16694e;
    public boolean f16695f;
    private final OnClickListener f16696g = new CallToActionClickListener(this);
    public FbScrollView f16697h;
    private SegmentedLinearLayout f16698i;

    /* compiled from: create_home_from_place_creation */
    class C18121 implements Runnable {
        final /* synthetic */ PageSelectCallToActionFragment f16688a;

        C18121(PageSelectCallToActionFragment pageSelectCallToActionFragment) {
            this.f16688a = pageSelectCallToActionFragment;
        }

        public void run() {
            this.f16688a.f16697h.scrollTo(0, PageSelectCallToActionFragment.al);
        }
    }

    /* compiled from: create_home_from_place_creation */
    class CallToActionClickListener implements OnClickListener {
        final /* synthetic */ PageSelectCallToActionFragment f16689a;

        public CallToActionClickListener(PageSelectCallToActionFragment pageSelectCallToActionFragment) {
            this.f16689a = pageSelectCallToActionFragment;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -287070743);
            CallToActionAdminConfigModel callToActionAdminConfigModel = (CallToActionAdminConfigModel) view.getTag();
            PageCallToActionUtil pageCallToActionUtil = this.f16689a.f16690a;
            PageCallToActionUtil.m20165a(this.f16689a.kO_(), this.f16689a, PageConfigureCallToActionFragment.m19713a(this.f16689a.f16693d, callToActionAdminConfigModel, this.f16689a.f16694e));
            this.f16689a.f16691b.m19692a(this.f16689a.f16694e, "cta_select_list");
            this.f16689a.f16692c.a(this.f16689a.f16695f ? FunnelRegistry.O : FunnelRegistry.N, "select_from_cta_list", callToActionAdminConfigModel.m19786j().name());
            LogUtils.a(-628160109, a);
        }
    }

    public static void m19726a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        PageSelectCallToActionFragment pageSelectCallToActionFragment = (PageSelectCallToActionFragment) obj;
        PageCallToActionUtil a = PageCallToActionUtil.m20160a(injectorLike);
        PageCallToActionAnalytics b = PageCallToActionAnalytics.m19690b(injectorLike);
        FunnelLoggerImpl a2 = FunnelLoggerImpl.a(injectorLike);
        pageSelectCallToActionFragment.f16690a = a;
        pageSelectCallToActionFragment.f16691b = b;
        pageSelectCallToActionFragment.f16692c = a2;
    }

    public static PageSelectCallToActionFragment m19725a(PageAdminCallToActionModel pageAdminCallToActionModel, String str, boolean z) {
        PageSelectCallToActionFragment pageSelectCallToActionFragment = new PageSelectCallToActionFragment();
        Bundle bundle = new Bundle();
        FlatBufferModelHelper.a(bundle, "arg_page_admin_cta", pageAdminCallToActionModel);
        bundle.putString("arg_page_id", str);
        bundle.putBoolean("arg_is_edit_mode", z);
        pageSelectCallToActionFragment.g(bundle);
        return pageSelectCallToActionFragment;
    }

    public final void m19732c(@Nullable Bundle bundle) {
        super.c(bundle);
        Class cls = PageSelectCallToActionFragment.class;
        m19726a((Object) this, getContext());
        Bundle bundle2 = this.s;
        this.f16693d = (PageAdminCallToActionModel) FlatBufferModelHelper.a(bundle2, "arg_page_admin_cta");
        this.f16694e = bundle2.getString("arg_page_id");
        this.f16695f = bundle2.getBoolean("arg_is_edit_mode");
    }

    public final View m19729a(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -351853053);
        View inflate = layoutInflater.inflate(2130906079, viewGroup, false);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -226718008, a);
        return inflate;
    }

    public final void m19731a(View view, @Nullable Bundle bundle) {
        super.a(view, bundle);
        this.f16697h = (FbScrollView) view;
        this.f16698i = (SegmentedLinearLayout) e(2131565647);
        ((FbTextView) e(2131565646)).setText(this.f16693d.m19902l().m19889j().m19881a());
        ar();
    }

    public final void mi_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -956705953);
        super.mi_();
        HasTitleBar hasTitleBar = (HasTitleBar) a(HasTitleBar.class);
        if (hasTitleBar != null) {
            hasTitleBar.y_(2131239581);
            hasTitleBar.kg_();
            hasTitleBar.c(true);
        }
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 2021094996, a);
    }

    public final void m19728H() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1336322668);
        super.H();
        al = this.f16697h.getScrollY();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -592165858, a);
    }

    public final void m19727G() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1690500624);
        super.G();
        this.f16697h.post(new C18121(this));
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 935665578, a);
    }

    private void ar() {
        EligibleCallToActionsModel j = this.f16693d.m19902l().m19889j().m19882j();
        if (j != null) {
            PageCallToActionUtil pageCallToActionUtil = this.f16690a;
            ViewGroup viewGroup = this.f16698i;
            OnClickListener onClickListener = this.f16696g;
            LinkedHashMap a = PageCallToActionUtil.m20164a(j);
            LayoutInflater from = LayoutInflater.from(pageCallToActionUtil.f16885a);
            boolean z = a.entrySet().size() == 1;
            for (Entry entry : a.entrySet()) {
                if (!z) {
                    FbTextView fbTextView = (FbTextView) from.inflate(2130905976, viewGroup, false);
                    fbTextView.setText((CharSequence) entry.getKey());
                    viewGroup.addView(fbTextView);
                }
                boolean z2 = true;
                for (CallToActionAdminConfigModel callToActionAdminConfigModel : (List) entry.getValue()) {
                    boolean z3;
                    ImageBlockLayout a2 = m19730a(callToActionAdminConfigModel, viewGroup);
                    a2.setTag(callToActionAdminConfigModel);
                    a2.setOnClickListener(onClickListener);
                    if (z2) {
                        a2.a(0, pageCallToActionUtil.f16885a.getResources().getDimensionPixelSize(2131427380), 0, pageCallToActionUtil.f16885a.getResources().getDimensionPixelSize(2131427380));
                        z3 = false;
                    } else {
                        a2.a(0, 0, 0, pageCallToActionUtil.f16885a.getResources().getDimensionPixelSize(2131427380));
                        z3 = z2;
                    }
                    a2.setBorderColor(pageCallToActionUtil.f16885a.getResources().getColor(2131361939));
                    viewGroup.addView(a2);
                    z2 = z3;
                }
            }
        }
    }

    public final ImageBlockLayout m19730a(CallToActionAdminConfigModel callToActionAdminConfigModel, ViewGroup viewGroup) {
        PageSelectCallToActionTypeView pageSelectCallToActionTypeView = (PageSelectCallToActionTypeView) LayoutInflater.from(getContext()).inflate(2130906081, viewGroup, false);
        pageSelectCallToActionTypeView.m20157a(callToActionAdminConfigModel.m19789m()).m20158a(callToActionAdminConfigModel.m19788l().m19780a().m19775a());
        pageSelectCallToActionTypeView.setTag(callToActionAdminConfigModel);
        pageSelectCallToActionTypeView.setOnClickListener(this.f16696g);
        return pageSelectCallToActionTypeView;
    }

    public final boolean O_() {
        this.f16691b.m19693b(this.f16694e, "cta_select_list");
        return false;
    }
}
