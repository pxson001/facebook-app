package com.facebook.leadgen;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.SimpleOnPageChangeListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.api.graphql.leadgen.LeadGenDeepLinkUserInfoCreateMutationModels.LeadGenDeepLinkUserInfoCoreMutationFieldsModel;
import com.facebook.api.graphql.leadgen.LeadGenDeepLinkUserInfoCreateMutationModels.LeadGenDeepLinkUserInfoCoreMutationFieldsModel.LeadGenDeepLinkUserStatusModel;
import com.facebook.base.fragment.FbFragment;
import com.facebook.common.time.AwakeTimeSinceBootClockMethodAutoProvider;
import com.facebook.common.time.MonotonicClock;
import com.facebook.common.util.FindViewUtil;
import com.facebook.feed.rows.core.props.AttachmentProps;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.core.props.TrackableFeedProps;
import com.facebook.funnellogger.FunnelLoggerImpl;
import com.facebook.funnellogger.FunnelRegistry;
import com.facebook.graphql.model.GraphQLLeadGenPage;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.inject.FbInjector;
import com.facebook.inject.InjectorLike;
import com.facebook.leadgen.cache.LeadGenFormPendingInputCache;
import com.facebook.leadgen.cache.LeadGenFormPendingInputEntry;
import com.facebook.leadgen.data.LeadGenDataExtractor;
import com.facebook.leadgen.popover.MultiPageBaseContentFragment;
import com.facebook.leadgen.popover.MultiPagePopoverFragment;
import com.facebook.leadgen.util.LeadGenContinuedFlowController;
import com.facebook.leadgen.util.LeadGenContinuedFlowControllerProvider;
import com.facebook.leadgen.util.LeadGenSharedStatusHelper;
import com.facebook.leadgen.view.LeadGenFullScreenHeaderView;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.rapidfeedback.RapidFeedbackController;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;
import javax.inject.Inject;

/* compiled from: place_delete_inline_rating_tapped */
public class LeadGenUserInputFormFragment extends FbFragment implements MultiPageBaseContentFragment {
    @Inject
    LeadGenUtil f6350a;
    @Inject
    LeadGenSharedStatusHelper al;
    private View am;
    private MultiPagePopoverFragment an;
    public LeadGenFullScreenHeaderView ao;
    public ViewPager ap;
    public LeadGenPagerController aq;
    private long ar;
    public LeadGenActionButtonsView as;
    public LeadGenDataExtractor at;
    private Bundle au;
    private LeadGenContinuedFlowController av;
    @Inject
    LeadGenPagerControllerProvider f6351b;
    @Inject
    LeadGenContinuedFlowControllerProvider f6352c;
    @Inject
    MonotonicClock f6353d;
    @Inject
    public LeadGenFormSubmissionHelper f6354e;
    @Inject
    public LeadGenFormPendingInputCache f6355f;
    @Inject
    LeadGenLogger f6356g;
    @Inject
    RapidFeedbackController f6357h;
    @Inject
    FunnelLoggerImpl f6358i;

    /* compiled from: place_delete_inline_rating_tapped */
    public class C05751 extends SimpleOnPageChangeListener {
        final /* synthetic */ LeadGenUserInputFormFragment f6348a;

        public C05751(LeadGenUserInputFormFragment leadGenUserInputFormFragment) {
            this.f6348a = leadGenUserInputFormFragment;
        }

        public final void e_(int i) {
            this.f6348a.as.m8091b();
        }
    }

    /* compiled from: place_delete_inline_rating_tapped */
    public class C05762 {
        final /* synthetic */ LeadGenUserInputFormFragment f6349a;

        public C05762(LeadGenUserInputFormFragment leadGenUserInputFormFragment) {
            this.f6349a = leadGenUserInputFormFragment;
        }

        public final void m8178a(LeadGenDeepLinkUserInfoCoreMutationFieldsModel leadGenDeepLinkUserInfoCoreMutationFieldsModel, LeadGenUtil$SendInfoMutationStatus leadGenUtil$SendInfoMutationStatus) {
            LeadGenUserInputFormFragment.m8180a(this.f6349a, leadGenDeepLinkUserInfoCoreMutationFieldsModel, leadGenUtil$SendInfoMutationStatus);
        }
    }

    public static void m8182a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        ((LeadGenUserInputFormFragment) obj).m8181a(LeadGenUtil.a(injectorLike), (LeadGenPagerControllerProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(LeadGenPagerControllerProvider.class), (LeadGenContinuedFlowControllerProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(LeadGenContinuedFlowControllerProvider.class), (MonotonicClock) AwakeTimeSinceBootClockMethodAutoProvider.a(injectorLike), LeadGenFormSubmissionHelper.m8123b(injectorLike), LeadGenFormPendingInputCache.m8192a(injectorLike), LeadGenLogger.m8134a(injectorLike), RapidFeedbackController.b(injectorLike), FunnelLoggerImpl.a(injectorLike), LeadGenSharedStatusHelper.m8503a(injectorLike));
    }

    private void m8181a(LeadGenUtil leadGenUtil, LeadGenPagerControllerProvider leadGenPagerControllerProvider, LeadGenContinuedFlowControllerProvider leadGenContinuedFlowControllerProvider, MonotonicClock monotonicClock, LeadGenFormSubmissionHelper leadGenFormSubmissionHelper, LeadGenFormPendingInputCache leadGenFormPendingInputCache, LeadGenLogger leadGenLogger, RapidFeedbackController rapidFeedbackController, FunnelLoggerImpl funnelLoggerImpl, LeadGenSharedStatusHelper leadGenSharedStatusHelper) {
        this.f6350a = leadGenUtil;
        this.f6351b = leadGenPagerControllerProvider;
        this.f6352c = leadGenContinuedFlowControllerProvider;
        this.f6353d = monotonicClock;
        this.f6354e = leadGenFormSubmissionHelper;
        this.f6355f = leadGenFormPendingInputCache;
        this.f6356g = leadGenLogger;
        this.f6357h = rapidFeedbackController;
        this.f6358i = funnelLoggerImpl;
        this.al = leadGenSharedStatusHelper;
    }

    public final View m8186a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -816375053);
        this.am = layoutInflater.inflate(2130905028, viewGroup, false);
        this.au = bundle;
        m8183b(this.am);
        View view = this.am;
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -637570212, a);
        return view;
    }

    public final void m8188c(Bundle bundle) {
        super.c(bundle);
        this.an = (MultiPagePopoverFragment) this.G;
        Class cls = LeadGenUserInputFormFragment.class;
        m8182a(this, getContext());
    }

    public static LeadGenUserInputFormFragment m8179a(FeedProps<GraphQLStoryAttachment> feedProps) {
        LeadGenUserInputFormFragment leadGenUserInputFormFragment = new LeadGenUserInputFormFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelable("story_attachment", feedProps);
        leadGenUserInputFormFragment.g(bundle);
        return leadGenUserInputFormFragment;
    }

    public final void mY_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 457550297);
        super.mY_();
        this.as.m8087a();
        LeadGenPagerController leadGenPagerController = this.aq;
        for (int i = 0; i < leadGenPagerController.f6320c.getChildCount(); i++) {
            View childAt = leadGenPagerController.f6320c.getChildAt(i);
            if (childAt instanceof LeadGenFormPageView) {
                ((LeadGenFormPageView) childAt).mo344a();
            }
        }
        this.f6354e.f6280d = null;
        this.ao.m8519a();
        m8184n(this.au);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 917090723, a);
    }

    public final void m8185I() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1713889584);
        super.I();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -1776025684, a);
    }

    public final void mi_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1484223519);
        super.mi_();
        this.ar = this.f6353d.now();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 1776756546, a);
    }

    public final void mj_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1428952691);
        super.mj_();
        if (this.aq != null) {
            this.aq.m8155d();
        }
        this.f6356g.m8143b(this.f6353d.now() - this.ar, this.aq.f6325h);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -2102148779, a);
    }

    public final void m8190e(Bundle bundle) {
        super.e(bundle);
        m8184n(bundle);
    }

    private boolean m8184n(Bundle bundle) {
        if (this.at == null || this.aq == null) {
            return false;
        }
        Parcelable leadGenFormPendingInputEntry = new LeadGenFormPendingInputEntry(this.at.m8201b(), this.aq.f6325h, this.aq.m8158g());
        LeadGenFormPendingInputCache leadGenFormPendingInputCache = this.f6355f;
        String b = this.at.m8201b();
        if (!Strings.isNullOrEmpty(b)) {
            leadGenFormPendingInputCache.f6361a.a(b, leadGenFormPendingInputEntry);
        }
        if (bundle != null) {
            bundle.putParcelable("LEADGEN_FORM_PENDING_INPUT", leadGenFormPendingInputEntry);
        }
        return true;
    }

    public final boolean mo342b() {
        if (this.aq.f6325h == 0) {
            this.f6356g.m8141a("cta_lead_gen_back_button_click", 0);
            this.f6358i.a(FunnelRegistry.x, "cta_lead_gen_back_button_click", "0");
            this.f6358i.b(FunnelRegistry.x);
        }
        return this.aq.m8154b();
    }

    public final void mo343e() {
        this.f6356g.m8141a("cta_lead_gen_quit_form_without_submission", this.aq.f6325h);
    }

    public final void aq() {
        String str = "";
        if (this.aq.f6325h == 0) {
            str = "730537770401723";
        } else if (this.aq.m8162n()) {
            str = "464514803717009";
        }
        if (!Strings.isNullOrEmpty(str)) {
            this.f6357h.a(str, getContext());
        }
    }

    public static void m8180a(LeadGenUserInputFormFragment leadGenUserInputFormFragment, LeadGenDeepLinkUserInfoCoreMutationFieldsModel leadGenDeepLinkUserInfoCoreMutationFieldsModel, LeadGenUtil$SendInfoMutationStatus leadGenUtil$SendInfoMutationStatus) {
        String F = leadGenUserInputFormFragment.at.m8195F();
        LeadGenSharedStatusHelper leadGenSharedStatusHelper = leadGenUserInputFormFragment.al;
        if (F != null) {
            leadGenSharedStatusHelper.f6566a.put(F, leadGenUtil$SendInfoMutationStatus);
        }
        if (leadGenUtil$SendInfoMutationStatus == LeadGenUtil$SendInfoMutationStatus.SUCCESS && LeadGenUtil.c(leadGenUserInputFormFragment.at.f6370f)) {
            LeadGenDeepLinkUserStatusModel a = leadGenDeepLinkUserInfoCoreMutationFieldsModel.m609a();
            if (a != null) {
                leadGenUserInputFormFragment.av.m8498a(leadGenUserInputFormFragment.at, a.m605c(), a.m606d(), leadGenUserInputFormFragment.am.findViewById(2131563360));
                leadGenUserInputFormFragment.an.mE_();
                return;
            }
            leadGenUtil$SendInfoMutationStatus = LeadGenUtil$SendInfoMutationStatus.FAILURE;
        }
        Parcelable parcelable = leadGenUserInputFormFragment.at.f6367c;
        MultiPageBaseContentFragment leadGenConfirmationFragment = new LeadGenConfirmationFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelable("story_attachment", parcelable);
        bundle.putSerializable("send_info_mutation_status", leadGenUtil$SendInfoMutationStatus);
        leadGenConfirmationFragment.g(bundle);
        leadGenUserInputFormFragment.an.m8496a(leadGenConfirmationFragment);
    }

    private void au() {
        Object obj;
        this.f6358i.a(FunnelRegistry.x, this.at.m8195F());
        this.f6358i.a(FunnelRegistry.x, "pagination_design");
        if (this.at.m8203e()) {
            this.f6358i.a(FunnelRegistry.x, "has_context_card");
        } else {
            this.f6358i.a(FunnelRegistry.x, "no_context_card");
        }
        LeadGenDataExtractor leadGenDataExtractor = this.at;
        if (!leadGenDataExtractor.m8197L()) {
            Object obj2;
            ImmutableList n = leadGenDataExtractor.f6370f.M().n();
            int size = n.size();
            for (int i = 0; i < size; i++) {
                if (LeadGenUtil.b((GraphQLLeadGenPage) n.get(i))) {
                    obj2 = 1;
                    break;
                }
            }
            obj2 = null;
            if (obj2 == null) {
                obj = null;
                if (obj == null) {
                    this.f6358i.a(FunnelRegistry.x, "has_disclaimer");
                } else {
                    this.f6358i.a(FunnelRegistry.x, "no_disclaimer");
                }
            }
        }
        obj = 1;
        if (obj == null) {
            this.f6358i.a(FunnelRegistry.x, "no_disclaimer");
        } else {
            this.f6358i.a(FunnelRegistry.x, "has_disclaimer");
        }
    }

    private void m8183b(View view) {
        FeedProps feedProps = (FeedProps) this.s.getParcelable("story_attachment");
        FeedProps e = AttachmentProps.e(feedProps);
        this.at = new LeadGenDataExtractor(feedProps, getContext());
        if (this.at.m8200a()) {
            LeadGenFormPendingInputEntry leadGenFormPendingInputEntry;
            this.f6358i.a(FunnelRegistry.x);
            au();
            this.ap = (ViewPager) FindViewUtil.b(view, 2131563405);
            this.f6356g.m8139a(TrackableFeedProps.a(e), ((GraphQLStory) e.a).u(), LeadGenUtil.a(feedProps));
            LeadGenFormPendingInputCache leadGenFormPendingInputCache = this.f6355f;
            String b = this.at.m8201b();
            if (Strings.isNullOrEmpty(b)) {
                leadGenFormPendingInputEntry = null;
            } else {
                leadGenFormPendingInputEntry = (LeadGenFormPendingInputEntry) leadGenFormPendingInputCache.f6361a.b(b);
            }
            LeadGenFormPendingInputEntry leadGenFormPendingInputEntry2 = leadGenFormPendingInputEntry;
            if (leadGenFormPendingInputEntry2 == null && this.au != null) {
                leadGenFormPendingInputEntry2 = (LeadGenFormPendingInputEntry) this.au.getParcelable("LEADGEN_FORM_PENDING_INPUT");
            }
            this.aq = this.f6351b.m8164a(this.ap, this.at, leadGenFormPendingInputEntry2);
            InjectorLike injectorLike = this.f6352c;
            this.av = new LeadGenContinuedFlowController((LeadGenLinkHandlerProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(LeadGenLinkHandlerProvider.class), LeadGenLogger.m8134a(injectorLike), this.aq);
            this.as = (LeadGenActionButtonsView) FindViewUtil.b(view, 2131563406);
            this.as.m8089a(this.at, this.aq, this.an);
            this.ao = (LeadGenFullScreenHeaderView) FindViewUtil.b(view, 2131563404);
            this.ao.m8520a(this.at, this.an, this.aq);
            this.as.m8091b();
            this.ap.setOnPageChangeListener(new C05751(this));
            this.f6354e.f6280d = new C05762(this);
            this.as.m8088a(this.f6354e);
        }
    }
}
