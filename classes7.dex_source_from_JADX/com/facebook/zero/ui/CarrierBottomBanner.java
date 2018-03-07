package com.facebook.zero.ui;

import android.content.Context;
import android.content.res.Resources;
import android.text.method.LinkMovementMethod;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.common.util.StyledStringBuilder;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.widget.CustomViewGroup;
import com.facebook.widget.text.CustomUrlLikeSpan;
import com.facebook.widget.text.CustomUrlLikeSpan.OnUrlClickHandler;
import com.facebook.zero.sdk.request.ZeroIndicatorData;
import com.facebook.zero.sdk.ui.ZeroIndicator;
import com.facebook.zero.ui.ZeroIndicatorController.1;

/* compiled from: web-worker- */
public class CarrierBottomBanner extends CustomViewGroup implements ZeroIndicator {
    public 1 f246a;
    private final Resources f247b;
    private final TextView f248c;
    private final TextView f249d;
    private final Button f250e;

    /* compiled from: web-worker- */
    class C00351 implements OnClickListener {
        final /* synthetic */ CarrierBottomBanner f243a;

        C00351(CarrierBottomBanner carrierBottomBanner) {
            this.f243a = carrierBottomBanner;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -1171020445);
            if (this.f243a.f246a != null) {
                ZeroIndicatorController.f(this.f243a.f246a.a);
            }
            Logger.a(2, EntryType.UI_INPUT_END, -1655779439, a);
        }
    }

    public CarrierBottomBanner(Context context) {
        this(context, null);
    }

    public CarrierBottomBanner(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CarrierBottomBanner(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f247b = ResourcesMethodAutoProvider.a(FbInjector.get(context));
        setContentView(2130903508);
        this.f248c = (TextView) findViewById(2131560222);
        this.f249d = (TextView) findViewById(2131560223);
        this.f250e = (Button) findViewById(2131560224);
        this.f250e.setOnClickListener(new C00351(this));
    }

    public void setIndicatorData(ZeroIndicatorData zeroIndicatorData) {
        final String d = zeroIndicatorData.d();
        CustomUrlLikeSpan customUrlLikeSpan = new CustomUrlLikeSpan();
        customUrlLikeSpan.a = new OnUrlClickHandler(this) {
            final /* synthetic */ CarrierBottomBanner f245b;

            public final void m239a() {
                if (this.f245b.f246a != null) {
                    1 1 = this.f245b.f246a;
                    ZeroIndicatorController.a(1.a, d);
                }
            }
        };
        StyledStringBuilder styledStringBuilder = new StyledStringBuilder(this.f247b);
        styledStringBuilder.a(2131232928);
        styledStringBuilder.a("[[content]]", zeroIndicatorData.b(), null, 33);
        styledStringBuilder.a("[[cta]]", zeroIndicatorData.c(), customUrlLikeSpan, 33);
        this.f248c.setText(zeroIndicatorData.a());
        this.f249d.setText(styledStringBuilder.b());
        this.f249d.setMovementMethod(LinkMovementMethod.getInstance());
    }

    public CharSequence getTitle() {
        return this.f248c.getText();
    }

    public final void m242b() {
        setVisibility(8);
    }

    public final void m241a() {
        setVisibility(0);
    }

    public final boolean m243c() {
        return getVisibility() == 0;
    }

    public void setListener(1 1) {
        this.f246a = 1;
    }
}
