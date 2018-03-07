package com.facebook.rtc.views;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.rtc.activities.WebrtcIncallActivity;
import com.facebook.rtc.activities.WebrtcIncallActivity.AnonymousClass24;
import com.facebook.rtc.fbwebrtc.WebrtcUiHandler;

/* compiled from: app_discovery_lite_load_started */
public class WebrtcVideoRequestView extends WebrtcLinearLayout {
    public ImageButton f20362a = ((ImageButton) m19719a(2131568533));
    public ImageButton f20363b = ((ImageButton) m19719a(2131568532));
    public AnonymousClass24 f20364c;

    /* compiled from: app_discovery_lite_load_started */
    public class C23991 implements OnClickListener {
        final /* synthetic */ WebrtcVideoRequestView f20360a;

        public C23991(WebrtcVideoRequestView webrtcVideoRequestView) {
            this.f20360a = webrtcVideoRequestView;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 1592924535);
            AnonymousClass24 anonymousClass24 = this.f20360a.f20364c;
            if (!anonymousClass24.f19149a.aa) {
                WebrtcIncallActivity.ai(anonymousClass24.f19149a);
            }
            Logger.a(2, EntryType.UI_INPUT_END, -1379892426, a);
        }
    }

    /* compiled from: app_discovery_lite_load_started */
    public class C24002 implements OnClickListener {
        final /* synthetic */ WebrtcVideoRequestView f20361a;

        public C24002(WebrtcVideoRequestView webrtcVideoRequestView) {
            this.f20361a = webrtcVideoRequestView;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 425534959);
            AnonymousClass24 anonymousClass24 = this.f20361a.f20364c;
            if (!anonymousClass24.f19149a.aa) {
                anonymousClass24.f19149a.aa = true;
                ((WebrtcUiHandler) anonymousClass24.f19149a.an.get()).m19476i(false);
                WebrtcIncallActivity.m19244s(anonymousClass24.f19149a);
            }
            Logger.a(2, EntryType.UI_INPUT_END, 1342627634, a);
        }
    }

    public WebrtcVideoRequestView(Context context) {
        super(context);
        LayoutInflater.from(context).inflate(2130907774, this);
        this.f20362a.setOnClickListener(new C23991(this));
        this.f20363b.setOnClickListener(new C24002(this));
    }
}
