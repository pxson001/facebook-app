package com.facebook.messaging.payment.thread.banner;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.TextView;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.resources.ui.FbTextView;
import com.facebook.widget.CustomLinearLayout;
import javax.annotation.Nullable;

/* compiled from: failed processing creative spec for logging */
public class PaymentPlatformContextBannerView extends CustomLinearLayout {
    private View f15103a;
    private TextView f15104b;
    private TextView f15105c;
    private ImageButton f15106d;
    private View f15107e;
    private FbTextView f15108f;
    private FbTextView f15109g;
    @Nullable
    public Listener f15110h;

    /* compiled from: failed processing creative spec for logging */
    public interface Listener {
        void mo605a();

        void mo606b();

        void mo607c();

        void mo608d();
    }

    /* compiled from: failed processing creative spec for logging */
    class C17491 implements OnClickListener {
        final /* synthetic */ PaymentPlatformContextBannerView f15099a;

        C17491(PaymentPlatformContextBannerView paymentPlatformContextBannerView) {
            this.f15099a = paymentPlatformContextBannerView;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 319347034);
            this.f15099a.f15110h.mo605a();
            Logger.a(2, EntryType.UI_INPUT_END, -1580744834, a);
        }
    }

    /* compiled from: failed processing creative spec for logging */
    class C17502 implements OnClickListener {
        final /* synthetic */ PaymentPlatformContextBannerView f15100a;

        C17502(PaymentPlatformContextBannerView paymentPlatformContextBannerView) {
            this.f15100a = paymentPlatformContextBannerView;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 251240390);
            this.f15100a.f15110h.mo606b();
            Logger.a(2, EntryType.UI_INPUT_END, 1949752282, a);
        }
    }

    /* compiled from: failed processing creative spec for logging */
    class C17513 implements OnClickListener {
        final /* synthetic */ PaymentPlatformContextBannerView f15101a;

        C17513(PaymentPlatformContextBannerView paymentPlatformContextBannerView) {
            this.f15101a = paymentPlatformContextBannerView;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 1811183502);
            this.f15101a.f15110h.mo607c();
            Logger.a(2, EntryType.UI_INPUT_END, -631373813, a);
        }
    }

    /* compiled from: failed processing creative spec for logging */
    class C17524 implements OnClickListener {
        final /* synthetic */ PaymentPlatformContextBannerView f15102a;

        C17524(PaymentPlatformContextBannerView paymentPlatformContextBannerView) {
            this.f15102a = paymentPlatformContextBannerView;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 821876226);
            this.f15102a.f15110h.mo608d();
            Logger.a(2, EntryType.UI_INPUT_END, 999201065, a);
        }
    }

    public PaymentPlatformContextBannerView(Context context) {
        super(context);
        m15478a();
    }

    public PaymentPlatformContextBannerView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        m15478a();
    }

    protected PaymentPlatformContextBannerView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m15478a();
    }

    private void m15478a() {
        setContentView(2130904587);
        this.f15103a = a(2131562520);
        this.f15104b = (TextView) a(2131559946);
        this.f15105c = (TextView) a(2131562528);
        this.f15106d = (ImageButton) a(2131562526);
        this.f15107e = a(2131562527);
        this.f15108f = (FbTextView) a(2131559664);
        this.f15109g = (FbTextView) a(2131562530);
    }

    public void setListener(Listener listener) {
        this.f15110h = listener;
        this.f15103a.setOnClickListener(new C17491(this));
        this.f15106d.setOnClickListener(new C17502(this));
        this.f15109g.setOnClickListener(new C17513(this));
        this.f15108f.setOnClickListener(new C17524(this));
    }

    public void setTitle(String str) {
        this.f15104b.setText(str);
        this.f15107e.setVisibility(0);
    }

    public void setDescription(String str) {
        this.f15105c.setText(str);
        this.f15107e.setVisibility(0);
    }

    public void setSecondaryAction(int i) {
        this.f15108f.setText(i);
        this.f15108f.setVisibility(0);
    }

    public void setPrimaryAction(int i) {
        this.f15109g.setText(i);
        this.f15109g.setVisibility(0);
    }
}
