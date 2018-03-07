package com.facebook.messaging.audio.composer;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;
import com.facebook.accessibility.ViewAccessibilityHelper;
import com.facebook.common.correctnesstest.CorrectnessTestConfig;
import com.facebook.common.correctnesstest.CorrectnessTestConfig.MainLoader;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.common.ui.util.ViewPositionUtil;
import com.facebook.common.util.MathUtil;
import com.facebook.inject.FbInjector;
import com.facebook.messaging.prefs.MessagingPrefKeys;
import com.facebook.messaging.sounds.MessengerSoundUtil;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.resources.ui.FbTextView;
import com.facebook.springs.SimpleSpringListener;
import com.facebook.springs.Spring;
import com.facebook.springs.SpringConfig;
import com.facebook.springs.SpringSystem;
import com.facebook.ui.choreographer.ChoreographerWrapper;
import com.facebook.ui.choreographer.DefaultChoreographerWrapper;
import com.facebook.ui.choreographer.FrameCallbackWrapper;
import com.facebook.widget.CustomRelativeLayout;
import com.facebook.widget.text.SimpleVariableTextLayoutView;
import java.util.Random;
import javax.inject.Inject;

/* compiled from: original_height */
public class AudioComposerContentView extends CustomRelativeLayout {
    private static final SpringConfig f7984h = SpringConfig.a(100.0d, 7.0d);
    private static final Random f7985i = new Random(1408665074);
    public Spring f7986A;
    public Spring f7987B;
    private Spring f7988C;
    private Spring f7989D;
    private Spring f7990E;
    public double f7991F;
    public Animation f7992G;
    public AudioComposerCallback f7993H;
    private long f7994I;
    private long f7995J;
    public boolean f7996K;
    public boolean f7997L;
    public boolean f7998M;
    private boolean f7999N;
    private boolean f8000O;
    public float f8001P;
    public float f8002Q;
    public float f8003R;
    public State f8004S = State.NOT_RECORDING;
    @Inject
    Clock f8005a;
    @Inject
    ChoreographerWrapper f8006b;
    @Inject
    SpringSystem f8007c;
    @Inject
    FbSharedPreferences f8008d;
    @Inject
    MessengerSoundUtil f8009e;
    @Inject
    ViewAccessibilityHelper f8010f;
    @Inject
    CorrectnessTestConfig f8011g;
    private String f8012j;
    private String f8013k;
    private String f8014l;
    private String f8015m;
    private String f8016n;
    public int f8017o;
    public int f8018p;
    public int f8019q;
    public FrameCallbackWrapper f8020r;
    public FbTextView f8021s;
    public View f8022t;
    public FbTextView f8023u;
    public SimpleVariableTextLayoutView f8024v;
    public View f8025w;
    public View f8026x;
    public View f8027y;
    private Spring f8028z;

    /* compiled from: original_height */
    class C08951 implements OnTouchListener {
        final /* synthetic */ AudioComposerContentView f7974a;

        C08951(AudioComposerContentView audioComposerContentView) {
            this.f7974a = audioComposerContentView;
        }

        public boolean onTouch(View view, MotionEvent motionEvent) {
            switch (motionEvent.getAction()) {
                case 0:
                    return this.f7974a.m8235a(motionEvent);
                case 1:
                    return this.f7974a.m8244c(motionEvent);
                case 2:
                    return this.f7974a.m8240b(motionEvent);
                case 3:
                    return this.f7974a.f7992G;
                default:
                    return false;
            }
        }
    }

    /* compiled from: original_height */
    class C08962 extends FrameCallbackWrapper {
        final /* synthetic */ AudioComposerContentView f7975a;

        C08962(AudioComposerContentView audioComposerContentView) {
            this.f7975a = audioComposerContentView;
        }

        public final void m8212a(long j) {
            int a = MathUtil.a(Math.round(((float) ((long) AudioComposerContentView.getCurrentTimerTimeMS(this.f7975a))) / 1000.0f), 0, 60000);
            if (a >= 60) {
                this.f7975a.f7993H.m8216d();
                this.f7975a.f8021s;
            } else {
                this.f7975a.f8006b.a(this.f7975a.f8020r);
            }
            this.f7975a.m8230a((TextView) this.f7975a.f8023u, a);
            AudioComposerContentView.m8256j(this.f7975a);
        }
    }

    /* compiled from: original_height */
    class C08973 implements Runnable {
        final /* synthetic */ AudioComposerContentView f7976a;

        C08973(AudioComposerContentView audioComposerContentView) {
            this.f7976a = audioComposerContentView;
        }

        public void run() {
            this.f7976a.f7993H.m8215c();
        }
    }

    /* compiled from: original_height */
    public interface AudioComposerCallback {
        void m8213a();

        void m8214b();

        void m8215c();

        void m8216d();
    }

    /* compiled from: original_height */
    class RecordButtonSpringListener extends SimpleSpringListener {
        final /* synthetic */ AudioComposerContentView f7978a;

        public RecordButtonSpringListener(AudioComposerContentView audioComposerContentView) {
            this.f7978a = audioComposerContentView;
        }

        public final void m8217a(Spring spring) {
            float d = (float) spring.d();
            this.f7978a.f8024v.setScaleX(d);
            this.f7978a.f8024v.setScaleY(d);
            if (d >= 1.0f && this.f7978a.f7998M) {
                this.f7978a.f7998M = false;
                this.f7978a.m8294e();
            }
        }
    }

    /* compiled from: original_height */
    class RedRecordButtonSpringListener extends SimpleSpringListener {
        final /* synthetic */ AudioComposerContentView f7979a;

        public RedRecordButtonSpringListener(AudioComposerContentView audioComposerContentView) {
            this.f7979a = audioComposerContentView;
        }

        public final void m8218a(Spring spring) {
            float d = (float) spring.d();
            this.f7979a.f8026x.setScaleX(d);
            this.f7979a.f8026x.setScaleY(d);
            if (((double) d) > this.f7979a.f7991F && this.f7979a.f7996K) {
                this.f7979a.f7996K = false;
                this.f7979a.f8025w.setVisibility(0);
                this.f7979a.f7986A.b(this.f7979a.f7991F);
                this.f7979a.f7997L = true;
            }
        }
    }

    /* compiled from: original_height */
    enum State {
        NOT_RECORDING,
        TOUCH_DOWN,
        RECORDING_CANCEL,
        MAX_TIME,
        MAX_TIME_CANCEL,
        CANCEL_TOO_SHORT,
        CANCEL_TOO_SHORT_FROM_CANCEL
    }

    /* compiled from: original_height */
    class TimerSizeSpringListener extends SimpleSpringListener {
        final /* synthetic */ AudioComposerContentView f7980a;

        public TimerSizeSpringListener(AudioComposerContentView audioComposerContentView) {
            this.f7980a = audioComposerContentView;
        }

        public final void m8219a(Spring spring) {
            float d = (float) spring.d();
            this.f7980a.f8023u.setTextSize(0, (d * (this.f7980a.f8002Q - this.f7980a.f8001P)) + this.f7980a.f8001P);
        }
    }

    /* compiled from: original_height */
    class TimerSpringListener extends SimpleSpringListener {
        final /* synthetic */ AudioComposerContentView f7981a;

        public TimerSpringListener(AudioComposerContentView audioComposerContentView) {
            this.f7981a = audioComposerContentView;
        }

        public final void m8220a(Spring spring) {
            float d = (float) spring.d();
            this.f7981a.f8022t.setY(d);
            if (this.f7981a.m8280v() && d > ((float) this.f7981a.f8024v.getTop()) && !this.f7981a.m8282w()) {
                this.f7981a.f8023u.setTextColor(this.f7981a.f8018p);
            } else if (this.f7981a.m8280v() && d < ((float) this.f7981a.f8024v.getTop()) && !this.f7981a.m8282w()) {
                this.f7981a.f8023u.setTextColor(this.f7981a.f8017o);
            } else if (this.f7981a.m8280v() && d < ((float) this.f7981a.f8024v.getTop()) && this.f7981a.m8282w()) {
                this.f7981a.f8023u.setTextColor(this.f7981a.f8019q);
            }
        }

        public final void m8221b(Spring spring) {
            if (this.f7981a.f8004S == State.NOT_RECORDING) {
                this.f7981a.f8021s.setVisibility(0);
                this.f7981a.f8022t.setVisibility(4);
            }
        }
    }

    /* compiled from: original_height */
    class VolumeIndicatorSpringListener extends SimpleSpringListener {
        final /* synthetic */ AudioComposerContentView f7982a;

        public VolumeIndicatorSpringListener(AudioComposerContentView audioComposerContentView) {
            this.f7982a = audioComposerContentView;
        }

        public final void m8222a(Spring spring) {
            float f = 1.0f;
            float d = (float) spring.d();
            if (d != 0.0f) {
                f = 1.0f + (d * this.f7982a.f8003R);
            }
            this.f7982a.f8027y.setScaleX(f);
            this.f7982a.f8027y.setScaleY(f);
        }
    }

    /* compiled from: original_height */
    class WhiteRecordButtonSpringListener extends SimpleSpringListener {
        final /* synthetic */ AudioComposerContentView f7983a;

        public WhiteRecordButtonSpringListener(AudioComposerContentView audioComposerContentView) {
            this.f7983a = audioComposerContentView;
        }

        public final void m8223a(Spring spring) {
            float d = (float) spring.d();
            this.f7983a.f8025w.setScaleX(d);
            this.f7983a.f8025w.setScaleY(d);
            if (((double) d) > this.f7983a.f7991F && this.f7983a.f7997L) {
                this.f7983a.f7997L = false;
                this.f7983a.f8024v.setVisibility(0);
                this.f7983a.f8021s.startAnimation(this.f7983a.f7992G);
                this.f7983a.f7987B.a(0.0d).l().b(1.0d);
                this.f7983a.f7998M = true;
            }
        }
    }

    private static <T extends View> void m8233a(Class<T> cls, T t) {
        m8234a((Object) t, t.getContext());
    }

    private static void m8234a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((AudioComposerContentView) obj).m8231a((Clock) SystemClockMethodAutoProvider.a(fbInjector), (ChoreographerWrapper) DefaultChoreographerWrapper.a(fbInjector), SpringSystem.b(fbInjector), (FbSharedPreferences) FbSharedPreferencesImpl.a(fbInjector), MessengerSoundUtil.a(fbInjector), ViewAccessibilityHelper.a(fbInjector), CorrectnessTestConfig.m6299a(fbInjector));
    }

    public final void m8290a() {
        this.f7992G;
    }

    public final void m8291b() {
        m8230a(this.f8023u, 0);
        m8230a(this.f8021s, 0);
        this.f8024v.setScaleX(1.0f);
        this.f8024v.setScaleY(1.0f);
    }

    public AudioComposerContentView(Context context) {
        super(context);
        m8250g();
    }

    public AudioComposerContentView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m8250g();
    }

    public AudioComposerContentView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m8250g();
    }

    private void m8250g() {
        this.f8001P = (float) getResources().getDimensionPixelSize(2131428539);
        this.f8002Q = (float) getResources().getDimensionPixelSize(2131428540);
        setContentView(2130905566);
        m8233a(AudioComposerContentView.class, (View) this);
        this.f8021s = (FbTextView) a(2131564444);
        this.f8023u = (FbTextView) a(2131564446);
        this.f8022t = a(2131564445);
        this.f8024v = (SimpleVariableTextLayoutView) a(2131564443);
        this.f8025w = a(2131564442);
        this.f8026x = a(2131564440);
        this.f8027y = a(2131564441);
        this.f8024v.setOnTouchListener(new C08951(this));
        this.f8020r = new C08962(this);
        this.f8012j = getContext().getString(2131231629);
        this.f8014l = getContext().getString(2131231621);
        this.f8013k = getContext().getString(2131231622);
        this.f8015m = getContext().getString(2131231631);
        this.f8016n = getContext().getString(2131231632);
        this.f8017o = getContext().getResources().getColor(2131362357);
        this.f8018p = getContext().getResources().getColor(2131361864);
        this.f8019q = getContext().getResources().getColor(2131362358);
        m8253h();
        m8230a(this.f8023u, 0);
        m8230a(this.f8021s, 0);
    }

    private void m8253h() {
        this.f8028z = m8227B();
        this.f7986A = m8227B();
        this.f7987B = m8227B();
        this.f7988C = m8227B();
        this.f7989D = m8227B();
        this.f7990E = m8227B();
        if (!MainLoader.f5968a) {
            this.f8028z.a(new RedRecordButtonSpringListener(this));
            this.f7986A.a(new WhiteRecordButtonSpringListener(this));
            this.f7987B.a(new RecordButtonSpringListener(this));
            this.f7988C.a(new VolumeIndicatorSpringListener(this));
            this.f7989D.a(new TimerSpringListener(this));
            this.f7990E.a(new TimerSizeSpringListener(this));
        }
        this.f7990E.a(0.0d).l();
        this.f7987B.a(1.0d).l();
        this.f7992G = AnimationUtils.loadAnimation(getContext(), 17432576);
    }

    public void setListener(AudioComposerCallback audioComposerCallback) {
        this.f7993H = audioComposerCallback;
    }

    public final void m8292c() {
        if (m8285x()) {
            this.f8000O = m8287y();
            this.f7999N = true;
            this.f8004S = State.TOUCH_DOWN;
            this.f8003R = ((float) (Math.sqrt(Math.pow((double) (((float) getMeasuredWidth()) / 2.0f), 2.0d) + Math.pow((double) (((float) getMeasuredHeight()) / 2.0f), 2.0d)) / ((double) (((float) this.f8024v.getMeasuredWidth()) / 2.0f)))) * 4.0f;
            this.f8006b.a(this.f8020r, 400);
            this.f8027y.setVisibility(0);
            m8255i();
            this.f8023u.setTextColor(this.f8017o);
            this.f7989D.a((double) getTimerViewTopY()).l();
            this.f7990E.a(0.0d).l();
            this.f7987B.l();
            this.f7987B.b(0.8d);
        }
    }

    public final void m8293d() {
        if (this.f8004S == State.RECORDING_CANCEL) {
            this.f8004S = State.MAX_TIME_CANCEL;
            m8263m();
        } else if (this.f8004S == State.TOUCH_DOWN) {
            this.f8004S = State.MAX_TIME;
            this.f8024v.setText("");
            m8265n();
            this.f8010f.a(this, this.f8014l);
        }
    }

    public final void m8294e() {
        this.f8021s;
        this.f8004S = State.NOT_RECORDING;
        m8276t();
        this.f8026x.setVisibility(8);
        this.f8025w.setVisibility(8);
        this.f8022t.setVisibility(4);
        this.f8024v.setVisibility(0);
        this.f8021s.setVisibility(0);
        m8230a(this.f8023u, 0);
        m8230a(this.f8021s, 0);
        this.f8021s.setTextColor(this.f8019q);
        this.f8024v.setText(this.f8012j);
        this.f8028z.a(0.0d).l();
        this.f7986A.a(0.0d).l();
        setVolumeLevel(0.0d);
    }

    public final void m8295f() {
        this.f8021s;
        m8276t();
        m8230a(this.f8021s, 0);
        m8230a(this.f8023u, 0);
        this.f8021s.setTextColor(this.f8019q);
        this.f8023u.setTextColor(this.f8019q);
        setVolumeLevel(0.0d);
        this.f8027y.setVisibility(8);
        if (this.f8004S == State.CANCEL_TOO_SHORT) {
            m8266o();
        }
        switch (this.f8004S) {
            case NOT_RECORDING:
            case RECORDING_CANCEL:
            case MAX_TIME_CANCEL:
            case CANCEL_TOO_SHORT_FROM_CANCEL:
                this.f8009e.m();
                this.f7987B.a(1.2d).l();
                this.f7987B.b(1.0d);
                break;
            case TOUCH_DOWN:
            case MAX_TIME:
            case CANCEL_TOO_SHORT:
                this.f7987B.a(1.0d).l();
                break;
        }
        this.f8004S = State.NOT_RECORDING;
    }

    public void setVolumeLevel(double d) {
        this.f7988C.b(m8229a(d));
    }

    private static double m8229a(double d) {
        double d2 = 0.0d;
        if (d >= 250.0d) {
            d2 = (0.10000000149011612d + ((0.5d - f7985i.nextDouble()) * 0.05000000074505806d)) * 0.25d;
        }
        return MathUtil.b(d / 12000.0d, d2, 1.0d);
    }

    private void m8255i() {
        if (m8279u()) {
            this.f8021s.setTextColor(this.f8019q);
            this.f8021s.setText(this.f8016n);
            this.f8021s.setVisibility(0);
            this.f8022t.setVisibility(8);
            return;
        }
        this.f8021s.setTextColor(this.f8018p);
        this.f8021s.setVisibility(8);
        this.f8022t.setVisibility(0);
    }

    public static void m8256j(AudioComposerContentView audioComposerContentView) {
        if (!audioComposerContentView.m8279u() && audioComposerContentView.f7999N) {
            audioComposerContentView.f8021s.setVisibility(8);
            audioComposerContentView.f8022t.setVisibility(0);
        }
    }

    private void m8259k() {
        this.f8004S = State.RECORDING_CANCEL;
        m8275s();
        this.f7987B.b(1.0d);
    }

    private void m8261l() {
        this.f8004S = State.TOUCH_DOWN;
        m8276t();
        this.f7987B.b(0.8d);
    }

    private void m8263m() {
        this.f8021s;
        m8275s();
        this.f8022t.setVisibility(0);
        this.f8021s.setTextColor(this.f8018p);
        this.f8021s.setText(this.f8013k);
        this.f8023u.setTextColor(this.f8017o);
    }

    private void m8265n() {
        this.f8021s;
        m8276t();
        this.f7989D.b((double) getTimerViewBottomY());
        this.f7990E.b(1.0d);
        this.f8021s.setVisibility(0);
        this.f8021s.setTextColor(this.f8017o);
        this.f8021s.setText(this.f8014l);
        this.f8023u.setTextColor(this.f8018p);
        this.f8009e.n();
        this.f8024v.setText("");
    }

    private void m8266o() {
        this.f8021s.setText(this.f8015m);
        this.f8022t.setVisibility(4);
        this.f8021s.setVisibility(0);
    }

    private void m8269p() {
        if (!MainLoader.f5968a) {
            m8225A();
            this.f8021s.setVisibility(8);
            this.f8024v.setVisibility(4);
            this.f7996K = true;
            this.f8026x.setVisibility(0);
            this.f8028z.c = false;
            this.f8028z.b(this.f7991F);
            this.f8027y.setVisibility(8);
            setVolumeLevel(0.0d);
        }
    }

    private boolean m8235a(MotionEvent motionEvent) {
        if (ViewPositionUtil.a(motionEvent, this.f8024v)) {
            this.f7994I = this.f8005a.a();
            if (!m8289z()) {
                this.f8004S = State.TOUCH_DOWN;
                this.f7993H.m8213a();
            }
        }
        return true;
    }

    private boolean m8240b(MotionEvent motionEvent) {
        boolean a = ViewPositionUtil.a(motionEvent, this.f8024v);
        if (this.f8004S != State.NOT_RECORDING) {
            if (a && !this.f7999N) {
                if (m8280v()) {
                    this.f8004S = State.MAX_TIME;
                    if (m8282w()) {
                        this.f8023u.setTextColor(this.f8017o);
                    } else {
                        this.f8023u.setTextColor(this.f8018p);
                    }
                    m8265n();
                } else {
                    this.f8004S = State.TOUCH_DOWN;
                    m8261l();
                }
                this.f7999N = true;
            } else if (!a && this.f7999N) {
                this.f7999N = false;
                this.f8023u.setTextColor(this.f8017o);
                if (m8280v()) {
                    m8263m();
                    this.f8004S = State.MAX_TIME_CANCEL;
                } else {
                    m8259k();
                    this.f8004S = State.RECORDING_CANCEL;
                }
            }
        }
        return true;
    }

    public static boolean m8271q(AudioComposerContentView audioComposerContentView) {
        audioComposerContentView.f8004S = State.NOT_RECORDING;
        audioComposerContentView.f7993H.m8214b();
        audioComposerContentView.f7987B.a(1.0d).l();
        return true;
    }

    private boolean m8244c(MotionEvent motionEvent) {
        this.f8021s;
        boolean a = ViewPositionUtil.a(motionEvent, this.f8024v);
        boolean z = this.f8005a.a() - this.f7994I > 500;
        if (a && z && (m8285x() || this.f8004S == State.MAX_TIME)) {
            this.f8004S = State.NOT_RECORDING;
            m8269p();
            postDelayed(new C08973(this), 500);
        } else {
            if (z) {
                this.f8004S = State.NOT_RECORDING;
            } else {
                this.f8021s;
                if (a) {
                    this.f8004S = State.CANCEL_TOO_SHORT;
                } else {
                    this.f8004S = State.CANCEL_TOO_SHORT_FROM_CANCEL;
                }
            }
            this.f7993H.m8214b();
        }
        return true;
    }

    private void m8231a(Clock clock, ChoreographerWrapper choreographerWrapper, SpringSystem springSystem, FbSharedPreferences fbSharedPreferences, MessengerSoundUtil messengerSoundUtil, ViewAccessibilityHelper viewAccessibilityHelper, CorrectnessTestConfig correctnessTestConfig) {
        this.f8005a = clock;
        this.f8006b = choreographerWrapper;
        this.f8007c = springSystem;
        this.f8008d = fbSharedPreferences;
        this.f8009e = messengerSoundUtil;
        this.f8010f = viewAccessibilityHelper;
        this.f8011g = correctnessTestConfig;
    }

    public static void m8273r(AudioComposerContentView audioComposerContentView) {
        audioComposerContentView.f8006b.b(audioComposerContentView.f8020r);
    }

    private void m8230a(TextView textView, int i) {
        int i2 = i / 60;
        int i3 = i % 60;
        textView.setText(StringFormatUtil.formatStrLocaleSafe("%d:%02d", Integer.valueOf(i2), Integer.valueOf(i3)));
        StringBuilder stringBuilder = new StringBuilder();
        if (i2 > 0) {
            stringBuilder.append(getResources().getString(2131231615));
            stringBuilder.append(" ");
        }
        stringBuilder.append(getResources().getQuantityString(2131689495, i3, new Object[]{Integer.valueOf(i3)}));
        textView.setContentDescription(stringBuilder.toString());
    }

    private void m8275s() {
        if (!MainLoader.f5968a) {
            m8225A();
            this.f8022t.setVisibility(0);
            this.f7989D.b((double) getTimerViewBottomY());
            this.f7990E.b(1.0d);
            this.f8024v.setVisibility(4);
            this.f8026x.setVisibility(0);
            this.f8028z.c = false;
            this.f8028z.b(this.f7991F);
            this.f8025w.setVisibility(0);
            this.f7986A.b(1.0d);
            this.f8021s.setTextColor(this.f8018p);
            this.f8021s.setText(this.f8013k);
            this.f8021s.setVisibility(0);
            this.f8010f.a(this, this.f8013k);
        }
    }

    private void m8276t() {
        if (!MainLoader.f5968a) {
            this.f8024v.setVisibility(0);
            this.f8024v.setText(this.f8012j);
            this.f8028z.c = true;
            this.f8028z.b(0.0d);
            this.f7986A.b(0.0d);
            this.f7989D.b((double) getTimerViewTopY());
            this.f7990E.b(0.0d);
            m8255i();
        }
    }

    private boolean m8279u() {
        return this.f8000O && getCurrentTimerTimeMS(this) <= 2000;
    }

    public static int getCurrentTimerTimeMS(AudioComposerContentView audioComposerContentView) {
        return (int) (audioComposerContentView.f8005a.a() - audioComposerContentView.f7994I);
    }

    private boolean m8280v() {
        return this.f8004S == State.MAX_TIME || this.f8004S == State.MAX_TIME_CANCEL;
    }

    private boolean m8282w() {
        return this.f8004S == State.RECORDING_CANCEL || this.f8004S == State.MAX_TIME_CANCEL;
    }

    private boolean m8285x() {
        return this.f8004S == State.TOUCH_DOWN || this.f8004S == State.RECORDING_CANCEL;
    }

    private boolean m8287y() {
        if (!this.f8008d.a()) {
            return false;
        }
        boolean a = this.f8008d.a(MessagingPrefKeys.aq, true);
        if (a) {
            this.f8008d.edit().putBoolean(MessagingPrefKeys.aq, false).commit();
        }
        return a;
    }

    private boolean m8289z() {
        boolean z = this.f8005a.a() - this.f7995J < 500;
        this.f7995J = this.f8005a.a();
        return z;
    }

    private float getTimerViewTopY() {
        return ((float) (this.f8024v.getTop() - this.f8022t.getHeight())) / 2.0f;
    }

    private float getTimerViewBottomY() {
        return ((float) this.f8024v.getTop()) + (((float) (this.f8024v.getHeight() - this.f8022t.getHeight())) / 2.0f);
    }

    private void m8225A() {
        if (this.f7991F == 0.0d) {
            int width = getWidth();
            int height = getHeight();
            this.f7991F = (Math.sqrt((double) ((width * width) + (height * height))) / ((double) this.f8024v.getWidth())) + 1.0d;
        }
    }

    private Spring m8227B() {
        return this.f8007c.a().a(f7984h);
    }
}
