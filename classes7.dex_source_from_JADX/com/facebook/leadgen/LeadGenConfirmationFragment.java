package com.facebook.leadgen;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import com.facebook.analytics.view.tracking.TrackingNodes;
import com.facebook.analytics.view.tracking.TrackingNodes.TrackingNode;
import com.facebook.base.fragment.FbFragment;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.time.AwakeTimeSinceBootClockMethodAutoProvider;
import com.facebook.common.time.MonotonicClock;
import com.facebook.common.util.FindViewUtil;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.funnellogger.FunnelLoggerImpl;
import com.facebook.funnellogger.FunnelRegistry;
import com.facebook.inject.FbInjector;
import com.facebook.inject.InjectorLike;
import com.facebook.leadgen.data.LeadGenDataExtractor;
import com.facebook.leadgen.popover.MultiPageBaseContentFragment;
import com.facebook.leadgen.popover.MultiPagePopoverFragment;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.rapidfeedback.RapidFeedbackController;
import javax.inject.Inject;

/* compiled from: place_question_photo */
public class LeadGenConfirmationFragment extends FbFragment implements MultiPageBaseContentFragment {
    private static final CallerContext f6246f = CallerContext.a(LeadGenConfirmationHeaderView.class, "native_newsfeed");
    @Inject
    LeadGenLinkHandlerProvider f6247a;
    private MultiPagePopoverFragment al;
    private long am;
    public int an;
    public FbDraweeView ao;
    public LeadGenDataExtractor ap;
    @Inject
    LeadGenLogger f6248b;
    @Inject
    MonotonicClock f6249c;
    @Inject
    RapidFeedbackController f6250d;
    @Inject
    FunnelLoggerImpl f6251e;
    private View f6252g;
    private TextView f6253h;
    private LeadGenConfirmationHeaderView f6254i;

    public static void m8096a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        ((LeadGenConfirmationFragment) obj).m8095a((LeadGenLinkHandlerProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(LeadGenLinkHandlerProvider.class), LeadGenLogger.m8134a(injectorLike), (MonotonicClock) AwakeTimeSinceBootClockMethodAutoProvider.a(injectorLike), RapidFeedbackController.b(injectorLike), FunnelLoggerImpl.a(injectorLike));
    }

    public final View m8098a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 87382434);
        this.f6252g = layoutInflater.inflate(2130905010, viewGroup, false);
        m8097b(this.f6252g);
        View view = this.f6252g;
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -2083952652, a);
        return view;
    }

    public final void m8100c(Bundle bundle) {
        super.c(bundle);
        Class cls = LeadGenConfirmationFragment.class;
        m8096a(this, getContext());
        this.al = (MultiPagePopoverFragment) this.G;
    }

    public final boolean mo342b() {
        this.al.mE_();
        this.f6251e.b(FunnelRegistry.x, "click_back_button_after_submit");
        this.f6251e.b(FunnelRegistry.x);
        return true;
    }

    public final void mi_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1504017722);
        super.mi_();
        this.am = this.f6249c.now();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -365124842, a);
    }

    public final void mj_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 375065175);
        super.mj_();
        this.f6248b.m8138a(this.f6249c.now() - this.am, this.an);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -211915210, a);
    }

    public final void mo343e() {
        this.f6248b.m8141a("cta_lead_gen_close_confirmation_dialog_click", this.an);
    }

    public final void aq() {
        this.f6250d.a("109198879416907", getContext());
    }

    private void m8097b(View view) {
        this.ao = (FbDraweeView) this.f6252g.findViewById(2131563365);
        this.ao.setVisibility(0);
        this.ap = new LeadGenDataExtractor((FeedProps) this.s.getParcelable("story_attachment"), getContext());
        if (this.ap.m8200a()) {
            this.an = this.ap.f6370f.M().n().size();
            ar();
            m8094a(view, 2131563368, this.ap.f6370f.E());
            this.f6253h = (TextView) view.findViewById(2131563368);
            View view2 = this.f6253h;
            final String F = LeadGenUtil.a(this.ap.f6368d).F();
            TrackingNodes.a(view2, TrackingNode.GENERIC_CALL_TO_ACTION_BUTTON);
            view2.setTag(2131558543, "cta_lead_gen_visit_offsite_click");
            view2.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ LeadGenConfirmationFragment f6244b;

                public void onClick(View view) {
                    int a = Logger.a(2, EntryType.UI_INPUT_START, 429999974);
                    this.f6244b.f6248b.m8141a("cta_lead_gen_visit_offsite_click", this.f6244b.an);
                    this.f6244b.f6251e.b(FunnelRegistry.x, "cta_lead_gen_visit_offsite_click");
                    this.f6244b.f6251e.b(FunnelRegistry.x);
                    this.f6244b.f6247a.m8133a(this.f6244b.ap.f6367c).m8132b(view, F, false);
                    Logger.a(2, EntryType.UI_INPUT_END, -330861606, a);
                }
            });
        }
    }

    public final void mY_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -771483658);
        super.mY_();
        this.f6254i.m8105a();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -1051791178, a);
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (configuration.orientation == 2) {
            this.ao.setVisibility(8);
        } else {
            this.ao.setVisibility(0);
        }
    }

    private void m8094a(View view, int i, String str) {
        ((TextView) FindViewUtil.b(view, i)).setText(str);
    }

    private void m8095a(LeadGenLinkHandlerProvider leadGenLinkHandlerProvider, LeadGenLogger leadGenLogger, MonotonicClock monotonicClock, RapidFeedbackController rapidFeedbackController, FunnelLoggerImpl funnelLoggerImpl) {
        this.f6247a = leadGenLinkHandlerProvider;
        this.f6248b = leadGenLogger;
        this.f6249c = monotonicClock;
        this.f6250d = rapidFeedbackController;
        this.f6251e = funnelLoggerImpl;
    }

    private void ar() {
        String ao;
        LeadGenUtil$SendInfoMutationStatus leadGenUtil$SendInfoMutationStatus = (LeadGenUtil$SendInfoMutationStatus) this.s.getSerializable("send_info_mutation_status");
        String str = "";
        String str2 = "";
        switch (leadGenUtil$SendInfoMutationStatus) {
            case SUCCESS:
                ao = this.ap.f6370f.ao();
                str = this.ap.f6370f.aD();
                break;
            case FAILURE:
                ao = this.ap.f6370f.y();
                str = this.ap.f6370f.z();
                break;
            default:
                ao = str;
                str = str2;
                break;
        }
        this.f6254i = (LeadGenConfirmationHeaderView) FindViewUtil.b(this.f6252g, 2131563364);
        this.f6254i.m8106a(this.ap, this.al);
        this.f6254i.m8107c(this.an);
        m8094a(this.f6252g, 2131563366, ao);
        m8094a(this.f6252g, 2131563367, str);
        if (leadGenUtil$SendInfoMutationStatus == LeadGenUtil$SendInfoMutationStatus.SUCCESS) {
            this.ao.a(this.ap.m8204m(), f6246f);
        } else {
            this.ao.setImageDrawable(jW_().getDrawable(2130839481));
        }
    }
}
