package com.facebook.leadgen;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.facebook.content.event.FbEvent;
import com.facebook.funnellogger.FunnelLoggerImpl;
import com.facebook.funnellogger.FunnelRegistry;
import com.facebook.graphql.model.GraphQLLeadGenContextPage;
import com.facebook.inject.FbInjector;
import com.facebook.inject.InjectorLike;
import com.facebook.leadgen.data.LeadGenDataExtractor;
import com.facebook.leadgen.event.LeadGenEventBus;
import com.facebook.leadgen.event.LeadGenEventSubscribers.SubmitButtonEnabledEventSubscriber;
import com.facebook.leadgen.event.LeadGenEvents.SubmitButtonEnabledEvent;
import com.facebook.leadgen.popover.MultiPagePopoverFragment;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.widget.CustomLinearLayout;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: place_question_skip */
public class LeadGenActionButtonsView extends CustomLinearLayout {
    @Inject
    public LeadGenLogger f6219a;
    @Inject
    public LeadGenEventBus f6220b;
    @Inject
    public FunnelLoggerImpl f6221c;
    private TextView f6222d;
    private TextView f6223e;
    private TextView f6224f;
    private TextView f6225g;
    public LeadGenPagerController f6226h;
    public MultiPagePopoverFragment f6227i;
    public LeadGenFormSubmissionHelper f6228j;
    public LeadGenDataExtractor f6229k;
    private final SubmitButtonEnabledEventSubscriber f6230l = new C05581(this);

    /* compiled from: place_question_skip */
    class C05581 extends SubmitButtonEnabledEventSubscriber {
        final /* synthetic */ LeadGenActionButtonsView f6213a;

        C05581(LeadGenActionButtonsView leadGenActionButtonsView) {
            this.f6213a = leadGenActionButtonsView;
        }

        public final void m8076b(FbEvent fbEvent) {
            this.f6213a.m8090a(((SubmitButtonEnabledEvent) fbEvent).f6381a);
        }
    }

    /* compiled from: place_question_skip */
    class C05592 implements OnClickListener {
        final /* synthetic */ LeadGenActionButtonsView f6214a;

        C05592(LeadGenActionButtonsView leadGenActionButtonsView) {
            this.f6214a = leadGenActionButtonsView;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -2130778545);
            int i = this.f6214a.f6226h.f6325h;
            if (this.f6214a.f6226h.m8156e()) {
                this.f6214a.f6226h.m8155d();
                this.f6214a.f6227i.mE_();
                Logger.a(2, EntryType.UI_INPUT_END, -1481660985, a);
                return;
            }
            this.f6214a.f6226h.m8160k();
            this.f6214a.f6226h.m8154b();
            this.f6214a.f6219a.m8141a("cta_lead_gen_prev_button_click", i);
            this.f6214a.f6221c.a(FunnelRegistry.x, "cta_lead_gen_prev_button_click", String.valueOf(i));
            LogUtils.a(1641575293, a);
        }
    }

    /* compiled from: place_question_skip */
    class C05614 implements OnClickListener {
        final /* synthetic */ LeadGenActionButtonsView f6217a;

        C05614(LeadGenActionButtonsView leadGenActionButtonsView) {
            this.f6217a = leadGenActionButtonsView;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -721794056);
            this.f6217a.f6226h.m8153a();
            this.f6217a.f6221c.b(FunnelRegistry.x, "lead_gen_context_card_button_click");
            this.f6217a.f6219a.m8140a("lead_gen_context_card_button_click");
            Logger.a(2, EntryType.UI_INPUT_END, -691130809, a);
        }
    }

    /* compiled from: place_question_skip */
    class C05625 implements OnClickListener {
        final /* synthetic */ LeadGenActionButtonsView f6218a;

        C05625(LeadGenActionButtonsView leadGenActionButtonsView) {
            this.f6218a = leadGenActionButtonsView;
        }

        private void m8077a() {
            this.f6218a.f6221c.b(FunnelRegistry.x, "click_submit_button");
            this.f6218a.f6228j.m8124a(this.f6218a.f6229k, this.f6218a.f6226h.m8158g(), this.f6218a.f6226h.m8159i(), this.f6218a.f6226h.f6325h);
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -1347354762);
            if (this.f6218a.f6226h.m8161l().isValid()) {
                m8077a();
            }
            Logger.a(2, EntryType.UI_INPUT_END, -273278213, a);
        }
    }

    private static <T extends View> void m8079a(Class<T> cls, T t) {
        m8080a((Object) t, t.getContext());
    }

    private static void m8080a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        LeadGenActionButtonsView leadGenActionButtonsView = (LeadGenActionButtonsView) obj;
        LeadGenLogger a = LeadGenLogger.m8134a(injectorLike);
        LeadGenEventBus a2 = LeadGenEventBus.m8217a(injectorLike);
        FunnelLoggerImpl a3 = FunnelLoggerImpl.a(injectorLike);
        leadGenActionButtonsView.f6219a = a;
        leadGenActionButtonsView.f6220b = a2;
        leadGenActionButtonsView.f6221c = a3;
    }

    public LeadGenActionButtonsView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        setContentView(2130905008);
        m8079a(LeadGenActionButtonsView.class, (View) this);
    }

    public final void m8089a(LeadGenDataExtractor leadGenDataExtractor, LeadGenPagerController leadGenPagerController, MultiPagePopoverFragment multiPagePopoverFragment) {
        this.f6226h = leadGenPagerController;
        this.f6227i = multiPagePopoverFragment;
        this.f6229k = leadGenDataExtractor;
        this.f6222d = (TextView) a(2131563359);
        this.f6223e = (TextView) a(2131563360);
        this.f6224f = (TextView) a(2131563361);
        this.f6225g = (TextView) a(2131563362);
        this.f6222d.setVisibility(8);
        this.f6223e.setVisibility(8);
        this.f6225g.setVisibility(8);
        this.f6224f.setVisibility(8);
        this.f6220b.a(this.f6230l);
        m8083c();
    }

    public final void m8088a(final LeadGenFormSubmissionHelper leadGenFormSubmissionHelper) {
        this.f6228j = leadGenFormSubmissionHelper;
        this.f6222d.setOnClickListener(new C05592(this));
        this.f6223e.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ LeadGenActionButtonsView f6216b;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, 1888938576);
                LeadGenUtil$ValidationResult l = this.f6216b.f6226h.m8161l();
                int i = this.f6216b.f6226h.f6325h;
                if (l.isValid()) {
                    if (this.f6216b.f6226h.m8157f()) {
                        this.f6216b.f6221c.b(FunnelRegistry.x, "click_submit_button");
                        leadGenFormSubmissionHelper.m8124a(this.f6216b.f6229k, this.f6216b.f6226h.m8158g(), this.f6216b.f6226h.m8159i(), i);
                    } else {
                        this.f6216b.f6226h.m8153a();
                        this.f6216b.f6219a.m8141a("cta_lead_gen_next_button_click", i);
                        this.f6216b.f6221c.a(FunnelRegistry.x, "cta_lead_gen_next_button_click", String.valueOf(i));
                    }
                }
                LogUtils.a(2012734152, a);
            }
        });
        this.f6225g.setOnClickListener(new C05614(this));
    }

    public final void m8087a() {
        this.f6222d.setOnClickListener(null);
        this.f6223e.setOnClickListener(null);
        this.f6225g.setOnClickListener(null);
        this.f6224f.setOnClickListener(null);
        this.f6220b.b(this.f6230l);
    }

    public final void m8091b() {
        if (this.f6226h.m8162n()) {
            setupCustomDisclaimerPageAcceptButton(false);
            this.f6224f.setVisibility(0);
            this.f6222d.setVisibility(0);
            this.f6223e.setVisibility(8);
            this.f6225g.setVisibility(8);
        } else if (this.f6226h.m8163o()) {
            String str;
            TextView textView = this.f6225g;
            GraphQLLeadGenContextPage s = LeadGenUtil.s(this.f6229k.f6368d);
            if (s == null) {
                str = null;
            } else {
                str = s.k();
            }
            textView.setText(str);
            this.f6225g.setVisibility(0);
            this.f6224f.setVisibility(8);
            this.f6222d.setVisibility(8);
            this.f6223e.setVisibility(8);
        } else {
            this.f6222d.setVisibility(0);
            this.f6223e.setVisibility(0);
            this.f6224f.setVisibility(8);
            this.f6225g.setVisibility(8);
            if (!this.f6226h.m8156e() || this.f6229k.m8203e()) {
                this.f6222d.setText(getResources().getString(2131233637));
            } else {
                this.f6222d.setVisibility(8);
            }
            if (this.f6226h.m8157f()) {
                this.f6223e.setText(this.f6229k.f6370f.ad());
                m8086e();
                return;
            }
            this.f6223e.setText(getResources().getString(2131233638));
            m8085d();
        }
    }

    public final void m8090a(boolean z) {
        if (this.f6224f.getVisibility() != 8) {
            setupCustomDisclaimerPageAcceptButton(z);
        }
    }

    private void m8083c() {
        this.f6224f.setAllCaps(true);
        this.f6222d.setAllCaps(true);
        this.f6223e.setAllCaps(true);
        m8085d();
    }

    private void m8085d() {
        LayoutParams layoutParams = new LinearLayout.LayoutParams((int) getResources().getDimension(2131432246), -1);
        LayoutParams layoutParams2 = new LinearLayout.LayoutParams((int) getResources().getDimension(2131432246), -1);
        layoutParams.rightMargin = (int) getResources().getDimension(2131432238);
        layoutParams2.rightMargin = (int) getResources().getDimension(2131432239);
        this.f6222d.setGravity(17);
        this.f6223e.setGravity(17);
        setGravity(5);
        this.f6222d.setLayoutParams(layoutParams);
        this.f6223e.setLayoutParams(layoutParams2);
    }

    private void m8086e() {
        if (this.f6223e.getVisibility() != 8 && this.f6222d.getVisibility() == 8) {
            LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -1, 1.0f);
            this.f6223e.setGravity(17);
            this.f6223e.setLayoutParams(layoutParams);
        }
    }

    public void setupCustomDisclaimerPageAcceptButton(boolean z) {
        this.f6224f.setText(getResources().getString(2131238117));
        this.f6224f.setEnabled(z);
        if (z) {
            this.f6224f.setTextColor(getResources().getColor(2131361917));
        } else {
            this.f6224f.setTextColor(getResources().getColor(2131361937));
        }
        this.f6224f.setOnClickListener(new C05625(this));
    }
}
