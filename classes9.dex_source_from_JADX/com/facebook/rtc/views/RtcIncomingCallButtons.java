package com.facebook.rtc.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.common.appstate.AppStateManager;
import com.facebook.config.application.FbAppType;
import com.facebook.fbui.glyph.GlyphButton;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedLazy;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.rtc.activities.WebrtcIncallActivity;
import com.facebook.rtc.activities.WebrtcIncallActivity.AnonymousClass20;
import com.facebook.rtc.fbwebrtc.WebrtcUiHandler;
import com.facebook.ultralight.Lazy;
import com.facebook.ultralight.UltralightRuntime;
import javax.inject.Inject;

/* compiled from: app_invites_notification */
public class RtcIncomingCallButtons extends WebrtcLinearLayout {
    @Inject
    FbAppType f20141a;
    private GlyphButton f20142b;
    private View f20143c;
    private View f20144d;
    private View f20145e;
    public AnonymousClass20 f20146f;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<WebrtcUiHandler> f20147g = UltralightRuntime.b;

    /* compiled from: app_invites_notification */
    class C23661 implements OnClickListener {
        final /* synthetic */ RtcIncomingCallButtons f20137a;

        C23661(RtcIncomingCallButtons rtcIncomingCallButtons) {
            this.f20137a = rtcIncomingCallButtons;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -1372091438);
            AnonymousClass20 anonymousClass20 = this.f20137a.f20146f;
            if (WebrtcIncallActivity.ab(anonymousClass20.f19145a)) {
                anonymousClass20.f19145a.aj = true;
                ((AppStateManager) anonymousClass20.f19145a.f19175D.get()).w.h(anonymousClass20.f19145a);
                WebrtcIncallActivity.m19248w(anonymousClass20.f19145a);
                WebrtcIncallActivity.aa(anonymousClass20.f19145a);
            }
            Logger.a(2, EntryType.UI_INPUT_END, -268335780, a);
        }
    }

    /* compiled from: app_invites_notification */
    class C23672 implements OnClickListener {
        final /* synthetic */ RtcIncomingCallButtons f20138a;

        C23672(RtcIncomingCallButtons rtcIncomingCallButtons) {
            this.f20138a = rtcIncomingCallButtons;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 2065577662);
            AnonymousClass20 anonymousClass20 = this.f20138a.f20146f;
            if (WebrtcIncallActivity.ab(anonymousClass20.f19145a) && !((WebrtcUiHandler) anonymousClass20.f19145a.an.get()).aP) {
                WebrtcIncallActivity.m19250y(anonymousClass20.f19145a);
            }
            Logger.a(2, EntryType.UI_INPUT_END, 936604774, a);
        }
    }

    /* compiled from: app_invites_notification */
    class C23683 implements OnClickListener {
        final /* synthetic */ RtcIncomingCallButtons f20139a;

        C23683(RtcIncomingCallButtons rtcIncomingCallButtons) {
            this.f20139a = rtcIncomingCallButtons;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -2037669064);
            WebrtcIncallActivity.m19201A(this.f20139a.f20146f.f19145a);
            Logger.a(2, EntryType.UI_INPUT_END, 913973899, a);
        }
    }

    /* compiled from: app_invites_notification */
    class C23694 implements OnClickListener {
        final /* synthetic */ RtcIncomingCallButtons f20140a;

        C23694(RtcIncomingCallButtons rtcIncomingCallButtons) {
            this.f20140a = rtcIncomingCallButtons;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 1939699075);
            WebrtcIncallActivity.m19221a(this.f20140a.f20146f.f19145a, null);
            Logger.a(2, EntryType.UI_INPUT_END, 485487782, a);
        }
    }

    private static <T extends View> void m19791a(Class<T> cls, T t) {
        m19792a((Object) t, t.getContext());
    }

    private static void m19792a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((RtcIncomingCallButtons) obj).m19790a((FbAppType) fbInjector.getInstance(FbAppType.class), IdBasedLazy.a(fbInjector, 10375));
    }

    public RtcIncomingCallButtons(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m19794c();
    }

    public void setButtonsEnabled(boolean z) {
        int i = 0;
        View[] viewArr = new View[]{this.f20142b, this.f20143c, this.f20144d, this.f20145e};
        while (i < 4) {
            View view = viewArr[i];
            view.setEnabled(z);
            WebrtcLinearLayout.m19718a(view, z);
            i++;
        }
    }

    public final void m19796a() {
        m19793b();
    }

    private void m19793b() {
        if (((WebrtcUiHandler) this.f20147g.get()).as()) {
            this.f20142b.setImageDrawable(getResources().getDrawable(2130844011));
        } else {
            this.f20142b.setImageDrawable(getResources().getDrawable(2130843942));
        }
    }

    private void m19790a(FbAppType fbAppType, com.facebook.inject.Lazy<WebrtcUiHandler> lazy) {
        this.f20141a = fbAppType;
        this.f20147g = lazy;
    }

    private void m19794c() {
        m19791a(RtcIncomingCallButtons.class, (View) this);
        LayoutInflater.from(getContext()).inflate(2130906917, this);
        this.f20144d = findViewById(2131567157);
        this.f20145e = findViewById(2131567158);
        this.f20143c = findViewById(2131567159);
        this.f20142b = (GlyphButton) findViewById(2131567160);
        m19793b();
        this.f20142b.setOnClickListener(new C23661(this));
        this.f20143c.setOnClickListener(new C23672(this));
        m19795d();
    }

    private void m19795d() {
        this.f20144d.setOnClickListener(new C23683(this));
        this.f20145e.setOnClickListener(new C23694(this));
        this.f20144d.setVisibility(0);
        this.f20145e.setVisibility(0);
    }
}
