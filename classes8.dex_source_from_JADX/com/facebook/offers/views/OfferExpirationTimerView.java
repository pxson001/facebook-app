package com.facebook.offers.views;

import android.content.Context;
import android.os.CountDownTimer;
import android.util.AttributeSet;
import android.view.View;
import com.facebook.common.i18n.BasicDateTimeFormat;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.resources.ui.FbTextView;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: current_contactpoint */
public class OfferExpirationTimerView extends FbTextView {
    @Inject
    Clock f16527a;
    @Inject
    BasicDateTimeFormat f16528b;
    private SimpleDateFormat f16529c;
    @Nullable
    private CountDownTimer f16530d;
    private long f16531e = 0;

    private static <T extends View> void m19478a(Class<T> cls, T t) {
        m19479a((Object) t, t.getContext());
    }

    private static void m19479a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((OfferExpirationTimerView) obj).m19476a((Clock) SystemClockMethodAutoProvider.a(fbInjector), BasicDateTimeFormat.a(fbInjector));
    }

    public OfferExpirationTimerView(Context context) {
        super(context);
        m19475a();
    }

    public OfferExpirationTimerView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        m19475a();
    }

    public OfferExpirationTimerView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m19475a();
    }

    private void m19475a() {
        m19478a(OfferExpirationTimerView.class, (View) this);
        this.f16529c = this.f16528b.h();
    }

    public void setExpiresOn(long j) {
        this.f16531e = j * 1000;
        long a = this.f16531e - this.f16527a.a();
        if (this.f16530d != null) {
            this.f16530d.cancel();
        }
        this.f16530d = null;
        if (a > 604800000) {
            setText(getContext().getString(2131236827, new Object[]{this.f16529c.format(new Date(this.f16531e))}));
        } else if (a > 518400000) {
            setText(getContext().getString(2131236829));
        } else if (a > 172800000) {
            long j2 = a / 86400000;
            setText(getContext().getString(2131236828, new Object[]{Long.valueOf(j2)}));
        } else if (a > 86400000) {
            setText(getContext().getString(2131236830));
        } else if (a > 0) {
            this.f16530d = new CountDownTimer(this, a, 1000) {
                final /* synthetic */ OfferExpirationTimerView f16526a;

                public void onTick(long j) {
                    OfferExpirationTimerView.m19480b(this.f16526a);
                }

                public void onFinish() {
                    OfferExpirationTimerView.m19480b(this.f16526a);
                }
            };
            this.f16530d.start();
        } else {
            setText(getContext().getString(2131236831));
        }
    }

    private void m19476a(Clock clock, BasicDateTimeFormat basicDateTimeFormat) {
        this.f16527a = clock;
        this.f16528b = basicDateTimeFormat;
    }

    public static void m19480b(OfferExpirationTimerView offerExpirationTimerView) {
        long a = offerExpirationTimerView.f16531e - offerExpirationTimerView.f16527a.a();
        long j = a / 3600000;
        long j2 = (a - (3600000 * j)) / 60000;
        a = ((a - (3600000 * j)) - (60000 * j2)) / 1000;
        if (j > 0) {
            offerExpirationTimerView.setText(offerExpirationTimerView.getContext().getString(2131236832, new Object[]{Long.valueOf(j), Long.valueOf(j2), Long.valueOf(a)}));
        } else if (j2 > 0) {
            offerExpirationTimerView.setText(offerExpirationTimerView.getContext().getString(2131236833, new Object[]{Long.valueOf(j2), Long.valueOf(a)}));
        } else if (a > 0) {
            offerExpirationTimerView.setText(offerExpirationTimerView.getContext().getString(2131236834, new Object[]{Long.valueOf(a)}));
        } else {
            offerExpirationTimerView.setText(offerExpirationTimerView.getContext().getString(2131236831));
        }
        offerExpirationTimerView.invalidate();
    }

    protected void onDetachedFromWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, -110156814);
        super.onDetachedFromWindow();
        if (this.f16530d != null) {
            this.f16530d.cancel();
            this.f16530d = null;
        }
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, -766440801, a);
    }
}
