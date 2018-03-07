package com.facebook.leadgen;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.facebook.funnellogger.FunnelLoggerImpl;
import com.facebook.funnellogger.FunnelRegistry;
import com.facebook.inject.FbInjector;
import com.facebook.inject.InjectorLike;
import com.facebook.leadgen.data.LeadGenDataExtractor;
import com.facebook.leadgen.popover.MultiPagePopoverFragment;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.widget.CustomLinearLayout;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: place_question_id */
public class LeadGenConfirmationHeaderView extends CustomLinearLayout {
    @Inject
    public LeadGenLogger f6257a;
    @Inject
    public FunnelLoggerImpl f6258b;
    private View f6259c;
    private View f6260d;
    private TextView f6261e;
    public MultiPagePopoverFragment f6262f;
    private LeadGenDataExtractor f6263g;

    private static <T extends View> void m8103a(Class<T> cls, T t) {
        m8104a((Object) t, t.getContext());
    }

    private static void m8104a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        LeadGenConfirmationHeaderView leadGenConfirmationHeaderView = (LeadGenConfirmationHeaderView) obj;
        LeadGenLogger a = LeadGenLogger.m8134a(injectorLike);
        FunnelLoggerImpl a2 = FunnelLoggerImpl.a(injectorLike);
        leadGenConfirmationHeaderView.f6257a = a;
        leadGenConfirmationHeaderView.f6258b = a2;
    }

    public LeadGenConfirmationHeaderView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        setOrientation(1);
        setContentView(2130905011);
        m8103a(LeadGenConfirmationHeaderView.class, (View) this);
    }

    public final void m8106a(LeadGenDataExtractor leadGenDataExtractor, MultiPagePopoverFragment multiPagePopoverFragment) {
        this.f6259c = a(2131563369);
        this.f6260d = a(2131563371);
        this.f6261e = (TextView) a(2131559428);
        this.f6263g = leadGenDataExtractor;
        this.f6262f = multiPagePopoverFragment;
        this.f6259c.setVisibility(0);
        this.f6260d.setVisibility(0);
        this.f6261e.setText(this.f6263g.m8202c());
    }

    public final void m8107c(final int i) {
        this.f6259c.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ LeadGenConfirmationHeaderView f6256b;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, -313613373);
                this.f6256b.f6262f.mE_();
                this.f6256b.f6257a.m8141a("cta_lead_gen_xout_on_top", i);
                this.f6256b.f6258b.b(FunnelRegistry.x, "click_xout_button_after_submit");
                this.f6256b.f6258b.b(FunnelRegistry.x);
                Logger.a(2, EntryType.UI_INPUT_END, -1306495857, a);
            }
        });
    }

    public final void m8105a() {
        this.f6259c.setOnClickListener(null);
    }
}
