package com.facebook.rtc.views;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.facebook.R;
import com.facebook.common.util.FindViewUtil;
import com.facebook.common.util.StringUtil;
import com.facebook.debug.log.BLog;
import com.facebook.fbui.glyph.GlyphButton;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedProvider;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.qe.api.ExposureLogging;
import com.facebook.qe.api.Liveness;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.resources.ui.FbTextView;
import com.facebook.rtc.fbwebrtc.WebrtcUiHandler;
import com.facebook.rtc.fbwebrtc.WebrtcUiHandler.NameChangedListener;
import com.facebook.rtc.fbwebrtc.abtests.ExperimentsForRtcModule;
import com.facebook.ultralight.Lazy;
import com.facebook.ultralight.UltralightRuntime;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: auto_photo_save_enabled */
public class RtcActionBar extends RelativeLayout {
    private static final Class<?> f20079b = RtcActionBar.class;
    @Inject
    QeAccessor f20080a;
    public Provider<Boolean> f20081c;
    private final int f20082d;
    private final int f20083e;
    private final boolean f20084f;
    public LinearLayout f20085g;
    private FbTextView f20086h;
    private ImageView f20087i;
    private int f20088j;
    private int f20089k;
    private float f20090l;
    private int f20091m;
    private GlyphButton f20092n;
    private ActionBarType f20093o = ActionBarType.VOICE;
    private GlyphButton f20094p;
    private ImageView f20095q;
    private FbTextView f20096r;
    private boolean f20097s;
    @Inject
    @Lazy
    public com.facebook.inject.Lazy<WebrtcUiHandler> f20098t = UltralightRuntime.b();
    public Listener f20099u;
    private NameChangedListener f20100v;

    /* compiled from: auto_photo_save_enabled */
    public interface Listener {
        void mo771a();

        void mo772b();

        void mo773c();
    }

    /* compiled from: auto_photo_save_enabled */
    class C23561 implements OnClickListener {
        final /* synthetic */ RtcActionBar f20074a;

        C23561(RtcActionBar rtcActionBar) {
            this.f20074a = rtcActionBar;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -694749979);
            if (this.f20074a.f20099u != null) {
                this.f20074a.f20099u.mo771a();
            }
            Logger.a(2, EntryType.UI_INPUT_END, -1819387884, a);
        }
    }

    /* compiled from: auto_photo_save_enabled */
    class C23572 implements NameChangedListener {
        final /* synthetic */ RtcActionBar f20075a;

        C23572(RtcActionBar rtcActionBar) {
            this.f20075a = rtcActionBar;
        }

        public final void mo804a() {
            RtcActionBar.m19743h(this.f20075a);
        }
    }

    /* compiled from: auto_photo_save_enabled */
    class C23583 implements OnClickListener {
        final /* synthetic */ RtcActionBar f20076a;

        C23583(RtcActionBar rtcActionBar) {
            this.f20076a = rtcActionBar;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -1556149609);
            ((WebrtcUiHandler) this.f20076a.f20098t.get()).m19432C();
            if (this.f20076a.f20099u != null) {
                this.f20076a.f20099u.mo772b();
            }
            Logger.a(2, EntryType.UI_INPUT_END, -1352473620, a);
        }
    }

    /* compiled from: auto_photo_save_enabled */
    class C23594 implements OnClickListener {
        final /* synthetic */ RtcActionBar f20077a;

        C23594(RtcActionBar rtcActionBar) {
            this.f20077a = rtcActionBar;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -235688865);
            this.f20077a.f20099u.mo773c();
            Logger.a(2, EntryType.UI_INPUT_END, 24015732, a);
        }
    }

    /* compiled from: auto_photo_save_enabled */
    public enum ActionBarType {
        VOICE,
        VIDEO,
        CONFERENCE
    }

    private static <T extends View> void m19735a(Class<T> cls, T t) {
        m19736a((Object) t, t.getContext());
    }

    private static void m19736a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        RtcActionBar rtcActionBar = (RtcActionBar) obj;
        rtcActionBar.f20081c = IdBasedProvider.a(fbInjector, 4309);
        rtcActionBar.m19734a(IdBasedLazy.a(fbInjector, 10375), (QeAccessor) QeInternalImplMethodAutoProvider.a(fbInjector));
    }

    private void m19734a(com.facebook.inject.Lazy<WebrtcUiHandler> lazy, QeAccessor qeAccessor) {
        this.f20098t = lazy;
        this.f20080a = qeAccessor;
    }

    public RtcActionBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R.styleable.RtcActionBar, 0, 0);
        try {
            this.f20088j = obtainStyledAttributes.getResourceId(0, 2130843208);
            this.f20089k = obtainStyledAttributes.getResourceId(4, 2130841331);
            this.f20090l = obtainStyledAttributes.getFloat(5, 1.0f);
            this.f20091m = obtainStyledAttributes.getColor(1, getResources().getColor(2131362292));
            this.f20082d = obtainStyledAttributes.getColor(2, getResources().getColor(2131362502));
            this.f20083e = obtainStyledAttributes.getResourceId(3, 2130843220);
            this.f20084f = obtainStyledAttributes.getBoolean(6, false);
            this.f20093o = ActionBarType.values()[obtainStyledAttributes.getInt(7, 0)];
            LayoutInflater.from(context).inflate(2130906910, this);
            this.f20085g = (LinearLayout) FindViewUtil.b(this, 2131567131);
            this.f20086h = (FbTextView) FindViewUtil.b(this, 2131567133);
            this.f20087i = (ImageView) FindViewUtil.b(this, 2131567132);
            this.f20092n = (GlyphButton) FindViewUtil.b(this, 2131567136);
            this.f20094p = (GlyphButton) FindViewUtil.b(this, 2131567137);
            this.f20095q = (ImageView) FindViewUtil.b(this, 2131567138);
            this.f20096r = (FbTextView) FindViewUtil.b(this, 2131567134);
            m19735a(RtcActionBar.class, (View) this);
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    @Inject
    private void m19737a(Provider<Boolean> provider) {
        this.f20081c = provider;
    }

    protected void onFinishInflate() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, -2001551855);
        super.onFinishInflate();
        m19742g();
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, 1865669572, a);
    }

    private <T extends View> T m19732a(int i) {
        return FindViewUtil.b(this, i);
    }

    public void setListener(Listener listener) {
        this.f20099u = listener;
    }

    private void m19740e() {
        this.f20092n.setVisibility(0);
    }

    private void m19741f() {
        this.f20092n.setVisibility(8);
    }

    public void setSwapCameraButtonClickable(boolean z) {
        this.f20092n.setClickable(z);
    }

    public final void m19744a() {
        ((WebrtcUiHandler) this.f20098t.get()).m19465b(this.f20100v);
    }

    public View getMinimizeButton() {
        return this.f20085g;
    }

    private void m19742g() {
        m19735a(RtcActionBar.class, (View) this);
        this.f20097s = this.f20080a.a(Liveness.Cached, ExposureLogging.Off, ExperimentsForRtcModule.bZ, false);
        setType(this.f20093o);
        this.f20085g.setBackgroundResource(this.f20088j);
        this.f20085g.setOnClickListener(new C23561(this));
        this.f20086h.setTextColor(this.f20091m);
        this.f20087i.setImageDrawable(getResources().getDrawable(this.f20089k));
        this.f20087i.setAlpha(this.f20090l);
        this.f20096r.setTextColor(getResources().getColor(2131362288));
        m19743h(this);
        this.f20100v = new C23572(this);
        ((WebrtcUiHandler) this.f20098t.get()).m19455a(this.f20100v);
        this.f20092n.setGlyphColor(this.f20082d);
        this.f20092n.setBackgroundResource(this.f20083e);
        this.f20092n.setOnClickListener(new C23583(this));
        this.f20094p.setGlyphColor(this.f20082d);
        this.f20094p.setBackgroundResource(this.f20083e);
        this.f20094p.setOnClickListener(new C23594(this));
        if (this.f20080a.a(Liveness.Cached, ExposureLogging.Off, ExperimentsForRtcModule.bY, false)) {
            this.f20095q.setVisibility(0);
        }
    }

    public final void m19746b() {
        if (((WebrtcUiHandler) this.f20098t.get()).m19431B() && (((WebrtcUiHandler) this.f20098t.get()).m19433D() || ((WebrtcUiHandler) this.f20098t.get()).az())) {
            m19740e();
        } else {
            m19741f();
        }
    }

    public final void m19747c() {
        if (((WebrtcUiHandler) this.f20098t.get()).ar() && this.f20084f) {
            if (((WebrtcUiHandler) this.f20098t.get()).m19485w()) {
                this.f20094p.setImageDrawable(getResources().getDrawable(2130843949));
            } else if (((WebrtcUiHandler) this.f20098t.get()).m19486x()) {
                this.f20094p.setImageDrawable(getResources().getDrawable(2130843956));
            } else {
                this.f20094p.setImageDrawable(getResources().getDrawable(2130843954));
            }
            this.f20094p.setVisibility(0);
            return;
        }
        this.f20094p.setVisibility(8);
    }

    public final void m19745a(String str) {
        if (this.f20093o != ActionBarType.CONFERENCE || StringUtil.a(str)) {
            this.f20096r.setVisibility(8);
            return;
        }
        this.f20096r.setVisibility(0);
        this.f20096r.setText(str);
    }

    public void setType(ActionBarType actionBarType) {
        this.f20093o = actionBarType;
        m19743h(this);
    }

    public static void m19743h(RtcActionBar rtcActionBar) {
        if (rtcActionBar.f20098t.get() != null) {
            if (rtcActionBar.f20093o == ActionBarType.CONFERENCE) {
                rtcActionBar.f20086h.setText(((WebrtcUiHandler) rtcActionBar.f20098t.get()).ak());
                return;
            }
            String str = "";
            if (((Boolean) rtcActionBar.f20081c.get()).booleanValue() && ((WebrtcUiHandler) rtcActionBar.f20098t.get()).m19470e()) {
                str = ".";
            }
            if (((WebrtcUiHandler) rtcActionBar.f20098t.get()).bR && rtcActionBar.f20093o == ActionBarType.VIDEO) {
                str = str + "!";
            }
            if (rtcActionBar.f20093o == ActionBarType.VIDEO) {
                rtcActionBar.f20086h.setText(((WebrtcUiHandler) rtcActionBar.f20098t.get()).ai() + str);
            } else if (rtcActionBar.f20093o == ActionBarType.VOICE) {
                rtcActionBar.f20086h.setText(rtcActionBar.getContext().getString(2131232097) + str);
            }
        }
    }

    public final void m19748d() {
        if (this.f20098t.get() != null) {
            Drawable drawable;
            switch (((WebrtcUiHandler) this.f20098t.get()).bV) {
                case DISCONNECTED:
                    if (this.f20093o != ActionBarType.VIDEO && !this.f20097s) {
                        drawable = getResources().getDrawable(2130843376);
                        break;
                    } else {
                        drawable = getResources().getDrawable(2130843375);
                        break;
                    }
                case POOR:
                    if (this.f20093o != ActionBarType.VIDEO && !this.f20097s) {
                        drawable = getResources().getDrawable(2130843382);
                        break;
                    } else {
                        drawable = getResources().getDrawable(2130843381);
                        break;
                    }
                    break;
                case FAIR:
                    if (this.f20093o != ActionBarType.VIDEO && !this.f20097s) {
                        drawable = getResources().getDrawable(2130843378);
                        break;
                    } else {
                        drawable = getResources().getDrawable(2130843377);
                        break;
                    }
                    break;
                case GOOD:
                    if (this.f20093o != ActionBarType.VIDEO && !this.f20097s) {
                        drawable = getResources().getDrawable(2130843380);
                        break;
                    } else {
                        drawable = getResources().getDrawable(2130843379);
                        break;
                    }
                    break;
                default:
                    BLog.b(f20079b, "Unknown connection quality type");
                    return;
            }
            if (!this.f20097s && this.f20093o == ActionBarType.VIDEO) {
                DrawableCompat.a(drawable, -1);
                DrawableCompat.a(drawable, Mode.SRC_IN);
            }
            this.f20095q.setImageDrawable(drawable);
        }
    }
}
