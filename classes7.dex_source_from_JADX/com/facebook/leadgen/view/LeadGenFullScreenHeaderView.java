package com.facebook.leadgen.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.facebook.funnellogger.FunnelLoggerImpl;
import com.facebook.funnellogger.FunnelRegistry;
import com.facebook.inject.FbInjector;
import com.facebook.inject.InjectorLike;
import com.facebook.leadgen.LeadGenLogger;
import com.facebook.leadgen.LeadGenPagerController;
import com.facebook.leadgen.data.LeadGenDataExtractor;
import com.facebook.leadgen.popover.MultiPagePopoverFragment;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.widget.CustomLinearLayout;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: photo_comment_with_text_posted */
public class LeadGenFullScreenHeaderView extends CustomLinearLayout {
    @Inject
    public LeadGenLogger f6588a;
    @Inject
    public FunnelLoggerImpl f6589b;
    private View f6590c;
    public MultiPagePopoverFragment f6591d;
    private TextView f6592e;
    public LeadGenPagerController f6593f;

    /* compiled from: photo_comment_with_text_posted */
    class C06031 implements OnClickListener {
        final /* synthetic */ LeadGenFullScreenHeaderView f6587a;

        C06031(LeadGenFullScreenHeaderView leadGenFullScreenHeaderView) {
            this.f6587a = leadGenFullScreenHeaderView;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -988795228);
            this.f6587a.f6593f.m8160k();
            this.f6587a.f6591d.mE_();
            int i = this.f6587a.f6593f.f6325h;
            if (this.f6587a.f6593f.m8163o()) {
                this.f6587a.f6588a.m8141a("lead_gen_close_context_card_click", i);
                this.f6587a.f6589b.b(FunnelRegistry.x, "lead_gen_close_context_card_click");
            } else if (this.f6587a.f6593f.m8162n()) {
                this.f6587a.f6588a.m8141a("cta_lead_gen_xout_on_top", i);
                this.f6587a.f6589b.b(FunnelRegistry.x, "click_xout_button_on_disclaimer");
            } else {
                this.f6587a.f6588a.m8141a("cta_lead_gen_xout_on_top", i);
                this.f6587a.f6589b.a(FunnelRegistry.x, "cta_lead_gen_xout_on_top", String.valueOf(i));
            }
            this.f6587a.f6589b.b(FunnelRegistry.x);
            LogUtils.a(-307397903, a);
        }
    }

    private static <T extends View> void m8515a(Class<T> cls, T t) {
        m8516a((Object) t, t.getContext());
    }

    private static void m8516a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        LeadGenFullScreenHeaderView leadGenFullScreenHeaderView = (LeadGenFullScreenHeaderView) obj;
        LeadGenLogger a = LeadGenLogger.m8134a(injectorLike);
        FunnelLoggerImpl a2 = FunnelLoggerImpl.a(injectorLike);
        leadGenFullScreenHeaderView.f6588a = a;
        leadGenFullScreenHeaderView.f6589b = a2;
    }

    public LeadGenFullScreenHeaderView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        setOrientation(1);
        setContentView(2130905022);
        m8515a(LeadGenFullScreenHeaderView.class, (View) this);
    }

    public final void m8520a(LeadGenDataExtractor leadGenDataExtractor, MultiPagePopoverFragment multiPagePopoverFragment, LeadGenPagerController leadGenPagerController) {
        this.f6590c = a(2131563369);
        this.f6592e = (TextView) a(2131559428);
        this.f6591d = multiPagePopoverFragment;
        this.f6592e.setText(leadGenDataExtractor.m8202c());
        this.f6593f = leadGenPagerController;
        m8518b();
    }

    private void m8518b() {
        this.f6590c.setOnClickListener(new C06031(this));
    }

    public final void m8519a() {
        this.f6590c.setOnClickListener(null);
    }
}
