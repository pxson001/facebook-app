package com.facebook.rtc.views;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Region;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.ImageButton;
import com.facebook.R;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedLazy;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.qe.api.ExposureLogging;
import com.facebook.qe.api.Liveness;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.rtc.activities.WebrtcIncallActivity;
import com.facebook.rtc.activities.WebrtcIncallActivity.C22604;
import com.facebook.rtc.fbwebrtc.WebrtcUiHandler;
import com.facebook.rtc.fbwebrtc.abtests.ExperimentsForRtcModule;
import com.facebook.rtc.interfaces.RtcRedirectHandler;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.ui.toaster.ToastBuilder;
import com.facebook.ultralight.Lazy;
import com.facebook.ultralight.UltralightRuntime;
import javax.inject.Inject;

/* compiled from: app_section_name */
public class IncallControlButtonsView extends WebrtcLinearLayout {
    @Inject
    QeAccessor f20057a;
    private View f20058b;
    private ImageButton f20059c;
    private ImageButton f20060d;
    private ImageButton f20061e;
    private ImageButton f20062f;
    private ImageButton f20063g;
    private int f20064h;
    private int f20065i;
    private int f20066j;
    private int f20067k;
    private int f20068l;
    private int f20069m;
    public C22604 f20070n;
    public ImageButton f20071o;
    public boolean f20072p;
    @Inject
    @Lazy
    public com.facebook.inject.Lazy<WebrtcUiHandler> f20073q;

    /* compiled from: app_section_name */
    class C23491 implements OnClickListener {
        final /* synthetic */ IncallControlButtonsView f20050a;

        C23491(IncallControlButtonsView incallControlButtonsView) {
            this.f20050a = incallControlButtonsView;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 900720156);
            if (this.f20050a.f20070n != null) {
                C22604 c22604 = this.f20050a.f20070n;
                RtcRedirectHandler rtcRedirectHandler = c22604.f19155a.f19173B;
                c22604.f19155a.kO_();
            }
            Logger.a(2, EntryType.UI_INPUT_END, -315319731, a);
        }
    }

    /* compiled from: app_section_name */
    class C23502 implements OnClickListener {
        final /* synthetic */ IncallControlButtonsView f20051a;

        C23502(IncallControlButtonsView incallControlButtonsView) {
            this.f20051a = incallControlButtonsView;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 1582197297);
            if (this.f20051a.f20070n != null) {
                C22604 c22604 = this.f20051a.f20070n;
                if (((WebrtcUiHandler) c22604.f19155a.an.get()).ar()) {
                    c22604.f19155a.al.m19340a();
                } else {
                    WebrtcIncallActivity.m19203D(c22604.f19155a);
                }
            }
            Logger.a(2, EntryType.UI_INPUT_END, -692455475, a);
        }
    }

    /* compiled from: app_section_name */
    class C23513 implements OnClickListener {
        final /* synthetic */ IncallControlButtonsView f20052a;

        C23513(IncallControlButtonsView incallControlButtonsView) {
            this.f20052a = incallControlButtonsView;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -512710968);
            if (this.f20052a.f20070n != null) {
                C22604 c22604 = this.f20052a.f20070n;
                WebrtcIncallActivity webrtcIncallActivity = c22604.f19155a;
                boolean z = !((WebrtcUiHandler) webrtcIncallActivity.an.get()).m19484u();
                Boolean.valueOf(z);
                ((WebrtcUiHandler) webrtcIncallActivity.an.get()).m19469e(z);
                WebrtcIncallActivity.m19245t(webrtcIncallActivity);
                if (c22604.f19155a.aP != null) {
                    c22604.f19155a.aP.m19929p();
                }
            }
            Logger.a(2, EntryType.UI_INPUT_END, 1501197903, a);
        }
    }

    /* compiled from: app_section_name */
    class C23524 implements OnClickListener {
        final /* synthetic */ IncallControlButtonsView f20053a;

        C23524(IncallControlButtonsView incallControlButtonsView) {
            this.f20053a = incallControlButtonsView;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 1929746521);
            if (this.f20053a.f20070n != null) {
                if (((WebrtcUiHandler) this.f20053a.f20073q.get()).m19487z()) {
                    C22604 c22604 = this.f20053a.f20070n;
                    WebrtcIncallActivity.m19204H(c22604.f19155a);
                    if (c22604.f19155a.aP != null) {
                        c22604.f19155a.aP.m19929p();
                    }
                } else if (((WebrtcUiHandler) this.f20053a.f20073q.get()).aH) {
                    ((WebrtcUiHandler) this.f20053a.f20073q.get()).f19562U.a(new ToastBuilder(this.f20053a.getContext().getResources().getString(2131231985)));
                } else {
                    ((WebrtcUiHandler) this.f20053a.f20073q.get()).m19463b(this.f20053a.getContext());
                }
            }
            LogUtils.a(946937371, a);
        }
    }

    /* compiled from: app_section_name */
    class C23535 implements OnClickListener {
        final /* synthetic */ IncallControlButtonsView f20054a;

        C23535(IncallControlButtonsView incallControlButtonsView) {
            this.f20054a = incallControlButtonsView;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -1074696794);
            if (this.f20054a.f20070n != null) {
                if (this.f20054a.f20072p) {
                    this.f20054a.f20070n.m19130e();
                } else {
                    this.f20054a.f20070n.f19155a.finish();
                }
            }
            LogUtils.a(-1336597752, a);
        }
    }

    /* compiled from: app_section_name */
    class C23546 implements OnClickListener {
        final /* synthetic */ IncallControlButtonsView f20055a;

        C23546(IncallControlButtonsView incallControlButtonsView) {
            this.f20055a = incallControlButtonsView;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 1371224283);
            if (this.f20055a.f20070n != null) {
                WebrtcIncallActivity.m19229b(this.f20055a.f20070n.f19155a, false);
            }
            Logger.a(2, EntryType.UI_INPUT_END, -1746370105, a);
        }
    }

    /* compiled from: app_section_name */
    class C23557 implements OnTouchListener {
        final /* synthetic */ IncallControlButtonsView f20056a;

        C23557(IncallControlButtonsView incallControlButtonsView) {
            this.f20056a = incallControlButtonsView;
        }

        public boolean onTouch(View view, MotionEvent motionEvent) {
            int width = view.getWidth() / 8;
            int x = (int) motionEvent.getX();
            if (motionEvent.getAction() != 0 || (x >= width && x <= view.getWidth() - width)) {
                return false;
            }
            return true;
        }
    }

    /* compiled from: app_section_name */
    public enum Theme {
        VOICE,
        VIDEO,
        CONFERENCE,
        VOICE_WITH_ADD_CALLEE,
        CONFERENCE_WITH_ADD_CALLEE
    }

    private static <T extends View> void m19725a(Class<T> cls, T t) {
        m19726a((Object) t, t.getContext());
    }

    private static void m19726a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((IncallControlButtonsView) obj).m19724a((QeAccessor) QeInternalImplMethodAutoProvider.a(fbInjector), IdBasedLazy.a(fbInjector, 10375));
    }

    private void m19724a(QeAccessor qeAccessor, com.facebook.inject.Lazy<WebrtcUiHandler> lazy) {
        this.f20057a = qeAccessor;
        this.f20073q = lazy;
    }

    public View getBackgroundButton() {
        return this.f20071o;
    }

    public IncallControlButtonsView(Context context, Theme theme) {
        super(context);
        this.f20072p = false;
        this.f20073q = UltralightRuntime.b;
        m19723a(context, theme);
    }

    public IncallControlButtonsView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f20072p = false;
        this.f20073q = UltralightRuntime.b();
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R.styleable.WebrtcLinearLayout, 0, 0);
        Theme theme = Theme.VOICE;
        try {
            switch (obtainStyledAttributes.getInteger(0, 0)) {
                case 1:
                    theme = Theme.VIDEO;
                    break;
                case 2:
                    theme = Theme.CONFERENCE;
                    break;
                case 3:
                    theme = Theme.VOICE_WITH_ADD_CALLEE;
                    break;
                case 4:
                    theme = Theme.CONFERENCE_WITH_ADD_CALLEE;
                    break;
            }
            obtainStyledAttributes.recycle();
            m19723a(context, theme);
        } catch (Throwable th) {
            obtainStyledAttributes.recycle();
        }
    }

    private void setTheme(Theme theme) {
        if (theme.equals(Theme.VOICE) || theme.equals(Theme.CONFERENCE) || theme.equals(Theme.VOICE_WITH_ADD_CALLEE) || theme.equals(Theme.CONFERENCE_WITH_ADD_CALLEE)) {
            this.f20064h = 2130843996;
            this.f20065i = 2130843970;
            this.f20066j = 2130843951;
            this.f20067k = 2130843967;
            this.f20068l = 2130843994;
            this.f20069m = 2130844013;
            return;
        }
        this.f20064h = 2130844022;
        this.f20065i = 2130844017;
        this.f20066j = 2130844012;
        this.f20067k = 2130844015;
        this.f20068l = 2130844021;
        this.f20069m = 2130844025;
    }

    public boolean gatherTransparentRegion(Region region) {
        region.setEmpty();
        return super.gatherTransparentRegion(region);
    }

    private void m19723a(Context context, Theme theme) {
        m19725a(IncallControlButtonsView.class, (View) this);
        LayoutInflater from = LayoutInflater.from(context);
        if (theme.equals(Theme.VOICE)) {
            this.f20058b = from.inflate(2130904893, this);
        } else if (theme.equals(Theme.VIDEO)) {
            this.f20058b = from.inflate(2130904892, this);
        } else if (theme.equals(Theme.VOICE_WITH_ADD_CALLEE)) {
            this.f20058b = from.inflate(2130904894, this);
        } else if (theme.equals(Theme.CONFERENCE_WITH_ADD_CALLEE)) {
            this.f20058b = from.inflate(2130904891, this);
        } else {
            this.f20058b = from.inflate(2130904890, this);
        }
        setTheme(theme);
        int a = this.f20057a.a(Liveness.Cached, ExposureLogging.Off, ExperimentsForRtcModule.cv, 1);
        this.f20059c = m19728c(2131563121);
        this.f20060d = m19728c(2131563117);
        this.f20061e = m19728c(2131563119);
        this.f20062f = m19728c(2131563120);
        this.f20071o = m19728c(2131563122);
        if (a == 2 && this.f20071o != null) {
            this.f20071o.setImageDrawable(getContext().getResources().getDrawable(2130843984));
            this.f20072p = true;
        }
        if (a == 3 && this.f20071o != null) {
            this.f20071o.setImageDrawable(getContext().getResources().getDrawable(2130843985));
            this.f20072p = true;
        }
        if (a == 4 && this.f20071o != null) {
            this.f20071o.setImageDrawable(getContext().getResources().getDrawable(2130843986));
        }
        this.f20063g = m19728c(2131563118);
        if (this.f20059c != null) {
            this.f20059c.setOnClickListener(new C23491(this));
        }
        if (this.f20060d != null) {
            this.f20060d.setOnClickListener(new C23502(this));
        }
        this.f20061e.setOnClickListener(new C23513(this));
        if (this.f20062f != null) {
            this.f20062f.setOnClickListener(new C23524(this));
        }
        if (this.f20071o != null) {
            this.f20071o.setOnClickListener(new C23535(this));
        }
        this.f20063g.setOnClickListener(new C23546(this));
        this.f20063g.setOnTouchListener(new C23557(this));
        m19730a();
    }

    public final void m19730a() {
        if (this.f20059c != null) {
            this.f20059c.setEnabled(((WebrtcUiHandler) this.f20073q.get()).m19440Q());
        }
        if (this.f20060d != null) {
            if (((WebrtcUiHandler) this.f20073q.get()).ar()) {
                if (((WebrtcUiHandler) this.f20073q.get()).m19486x()) {
                    this.f20060d.setImageDrawable(getResources().getDrawable(this.f20064h));
                } else if (((WebrtcUiHandler) this.f20073q.get()).m19485w()) {
                    this.f20060d.setImageDrawable(getResources().getDrawable(this.f20066j));
                } else if (((WebrtcUiHandler) this.f20073q.get()).bc) {
                    this.f20060d.setImageDrawable(getResources().getDrawable(this.f20065i));
                } else {
                    this.f20060d.setImageDrawable(getResources().getDrawable(this.f20067k));
                }
                this.f20060d.setContentDescription(m19721b(2131231972));
            } else {
                this.f20060d.setImageDrawable(getResources().getDrawable(this.f20068l));
                if (((WebrtcUiHandler) this.f20073q.get()).m19486x()) {
                    boolean z;
                    ImageButton imageButton = this.f20060d;
                    if (((WebrtcUiHandler) this.f20073q.get()).az()) {
                        z = false;
                    } else {
                        z = true;
                    }
                    imageButton.setEnabled(z);
                    this.f20060d.setSelected(true);
                    this.f20060d.setContentDescription(m19721b(2131231974));
                } else {
                    this.f20060d.setSelected(false);
                    this.f20060d.setContentDescription(m19721b(2131231973));
                }
            }
        }
        if (((WebrtcUiHandler) this.f20073q.get()).m19484u()) {
            this.f20061e.setSelected(true);
            this.f20061e.setContentDescription(m19721b(2131231981));
        } else {
            this.f20061e.setSelected(false);
            this.f20061e.setContentDescription(m19721b(2131231980));
        }
        if (this.f20062f != null) {
            this.f20062f.setVisibility(0);
            if (!((WebrtcUiHandler) this.f20073q.get()).am) {
                this.f20062f.setVisibility(8);
                if (this.f20071o != null) {
                    this.f20071o.setVisibility(0);
                }
            } else if (((WebrtcUiHandler) this.f20073q.get()).az()) {
                this.f20062f.setImageDrawable(getResources().getDrawable(this.f20069m));
                this.f20062f.setSelected(true);
                this.f20062f.setEnabled(false);
            } else {
                if (((WebrtcUiHandler) this.f20073q.get()).m19487z() && ((WebrtcUiHandler) this.f20073q.get()).m19442S()) {
                    this.f20062f.setImageDrawable(getResources().getDrawable(this.f20069m));
                    if (((WebrtcUiHandler) this.f20073q.get()).m19433D()) {
                        this.f20062f.setSelected(true);
                        this.f20062f.setContentDescription(m19721b(2131231983));
                    } else {
                        this.f20062f.setSelected(false);
                        this.f20062f.setContentDescription(m19721b(2131231982));
                    }
                } else {
                    this.f20062f.setImageDrawable(getResources().getDrawable(2130844014));
                    this.f20062f.setContentDescription(m19720a(2131231984, ((WebrtcUiHandler) this.f20073q.get()).aj()));
                }
                this.f20062f.setEnabled(true);
            }
        }
    }

    public void setButtonsEnabled(boolean z) {
        int i = 0;
        View[] viewArr = new View[]{this.f20059c, this.f20060d, this.f20061e, this.f20062f, this.f20071o, this.f20063g};
        while (i < 6) {
            View view = viewArr[i];
            if (view != null) {
                view.setEnabled(z);
            }
            i++;
        }
        WebrtcLinearLayout.m19718a((View) this, z);
    }

    private ImageButton m19728c(int i) {
        return (ImageButton) this.f20058b.findViewById(i);
    }
}
