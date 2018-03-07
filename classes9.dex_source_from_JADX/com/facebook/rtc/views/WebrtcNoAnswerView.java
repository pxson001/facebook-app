package com.facebook.rtc.views;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.resources.ui.FbButton;
import com.facebook.rtc.activities.WebrtcIncallActivity.AnonymousClass21;

/* compiled from: app_discovery_lite_profile_clicked */
public class WebrtcNoAnswerView extends WebrtcLinearLayout {
    public View f20345a = m19719a(2131568525);
    public View f20346b = m19719a(2131568526);
    public FbButton f20347c = ((FbButton) m19719a(2131568527));
    public AnonymousClass21 f20348d;

    /* compiled from: app_discovery_lite_profile_clicked */
    public class C23941 implements OnClickListener {
        final /* synthetic */ WebrtcNoAnswerView f20342a;

        public C23941(WebrtcNoAnswerView webrtcNoAnswerView) {
            this.f20342a = webrtcNoAnswerView;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -1351889417);
            AnonymousClass21 anonymousClass21 = this.f20342a.f20348d;
            anonymousClass21.f19146a.f19203w.a("end_call_action", "voip_voice_clip");
            anonymousClass21.f19146a.f19178G.get();
            long j = anonymousClass21.f19146a.ai;
            Logger.a(2, EntryType.UI_INPUT_END, -1348679241, a);
        }
    }

    /* compiled from: app_discovery_lite_profile_clicked */
    public class C23952 implements OnClickListener {
        final /* synthetic */ WebrtcNoAnswerView f20343a;

        public C23952(WebrtcNoAnswerView webrtcNoAnswerView) {
            this.f20343a = webrtcNoAnswerView;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -692362779);
            AnonymousClass21 anonymousClass21 = this.f20343a.f20348d;
            anonymousClass21.f19146a.f19203w.a("end_call_action", "voip_message");
            anonymousClass21.f19146a.f19178G.get();
            long j = anonymousClass21.f19146a.ai;
            Logger.a(2, EntryType.UI_INPUT_END, 1527138347, a);
        }
    }

    /* compiled from: app_discovery_lite_profile_clicked */
    public class C23963 implements OnClickListener {
        final /* synthetic */ WebrtcNoAnswerView f20344a;

        public C23963(WebrtcNoAnswerView webrtcNoAnswerView) {
            this.f20344a = webrtcNoAnswerView;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 189735726);
            this.f20344a.f20348d.f19146a.finish();
            Logger.a(2, EntryType.UI_INPUT_END, -1335251153, a);
        }
    }

    public WebrtcNoAnswerView(Context context) {
        super(context);
        LayoutInflater.from(context).inflate(2130907771, this);
        this.f20345a.setOnClickListener(new C23941(this));
        this.f20346b.setOnClickListener(new C23952(this));
        this.f20347c.setOnClickListener(new C23963(this));
    }
}
