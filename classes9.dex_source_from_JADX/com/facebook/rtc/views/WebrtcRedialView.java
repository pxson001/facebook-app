package com.facebook.rtc.views;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import com.facebook.config.application.FbAppType;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedLazy;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.resources.ui.FbTextView;
import com.facebook.rtc.activities.WebrtcIncallActivity;
import com.facebook.rtc.activities.WebrtcIncallActivity.AnonymousClass22;
import com.facebook.rtc.fbwebrtc.WebrtcUiHandler;
import com.facebook.ultralight.Lazy;
import com.facebook.ultralight.UltralightRuntime;
import com.facebook.webrtc.IWebrtcUiInterface.EndCallReason;
import javax.inject.Inject;

/* compiled from: app_discovery_lite_paused */
public class WebrtcRedialView extends WebrtcLinearLayout {
    @Inject
    public FbAppType f20351a;
    public Button f20352b;
    public Button f20353c;
    public AnonymousClass22 f20354d;
    public FbTextView f20355e;
    @Inject
    @Lazy
    public com.facebook.inject.Lazy<WebrtcUiHandler> f20356f = UltralightRuntime.b;

    /* compiled from: app_discovery_lite_paused */
    public class C23971 implements OnClickListener {
        final /* synthetic */ WebrtcRedialView f20349a;

        public C23971(WebrtcRedialView webrtcRedialView) {
            this.f20349a = webrtcRedialView;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 1495057298);
            AnonymousClass22 anonymousClass22 = this.f20349a.f20354d;
            WebrtcIncallActivity.m19212T(anonymousClass22.f19147a);
            WebrtcIncallActivity.aa(anonymousClass22.f19147a);
            Logger.a(2, EntryType.UI_INPUT_END, 1715003964, a);
        }
    }

    /* compiled from: app_discovery_lite_paused */
    public class C23982 implements OnClickListener {
        final /* synthetic */ WebrtcRedialView f20350a;

        public C23982(WebrtcRedialView webrtcRedialView) {
            this.f20350a = webrtcRedialView;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 1751471216);
            this.f20350a.f20354d.f19147a.finish();
            Logger.a(2, EntryType.UI_INPUT_END, -283275626, a);
        }
    }

    public static void m19933a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        WebrtcRedialView webrtcRedialView = (WebrtcRedialView) obj;
        FbAppType fbAppType = (FbAppType) fbInjector.getInstance(FbAppType.class);
        com.facebook.inject.Lazy a = IdBasedLazy.a(fbInjector, 10375);
        webrtcRedialView.f20351a = fbAppType;
        webrtcRedialView.f20356f = a;
    }

    public WebrtcRedialView(Context context) {
        super(context);
        Class cls = WebrtcRedialView.class;
        m19933a(this, getContext());
        LayoutInflater.from(context).inflate(2130907772, this);
        this.f20352b = (Button) m19719a(2131568531);
        this.f20353c = (Button) m19719a(2131568530);
        this.f20355e = (FbTextView) m19719a(2131568529);
        this.f20352b.setOnClickListener(new C23971(this));
        this.f20353c.setOnClickListener(new C23982(this));
        EndCallReason endCallReason = ((WebrtcUiHandler) this.f20356f.get()).bj;
        boolean z = ((WebrtcUiHandler) this.f20356f.get()).aB;
        int i = 2131232052;
        int i2 = 2131232045;
        if (!z && endCallReason == EndCallReason.CallEndClientInterrupted) {
            i = 2131232060;
            i2 = 2131232044;
        } else if (endCallReason == EndCallReason.CallEndClientInterrupted) {
            i = 2131232053;
            i2 = 2131232045;
        } else if (!z) {
            i = 2131232059;
            i2 = 2131232044;
        }
        this.f20352b.setText(m19721b(i2));
        this.f20355e.setText(m19720a(i, ((WebrtcUiHandler) this.f20356f.get()).aj()));
    }
}
