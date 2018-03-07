package com.facebook.messaging.bball;

import android.content.Context;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.facebook.auth.annotations.LoggedInUser;
import com.facebook.auth.module.User_LoggedInUserMethodAutoProvider;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.sounds.FBSoundUtil;
import com.facebook.sounds.fb4a.Fb4aSoundUtil;
import com.facebook.springs.SimpleSpringListener;
import com.facebook.springs.Spring;
import com.facebook.springs.SpringConfig;
import com.facebook.springs.SpringSystem;
import com.facebook.ui.choreographer.ChoreographerWrapper;
import com.facebook.ui.choreographer.DefaultChoreographerWrapper;
import com.facebook.ui.emoji.BigEmojisMethodAutoProvider;
import com.facebook.ui.emoji.Emojis;
import com.facebook.ui.emoji.model.BigEmojis;
import com.facebook.user.model.User;
import com.facebook.user.model.UserKey;
import com.facebook.user.tiles.UserTileView;
import com.facebook.user.tiles.UserTileViewParams;
import com.facebook.widget.CustomFrameLayout;
import java.util.Random;
import javax.inject.Inject;

/* compiled from: openGroupCreateFlow() not supported yet */
public class BballView extends CustomFrameLayout {
    private static final int[] f8201g = new int[]{128079, 128170, 128076, 128588, 128077};
    private static final int[] f8202h = new int[]{128531, 128563, 128549, 128547, 128530};
    private static final SpringConfig f8203i = SpringConfig.a(40.0d, 7.0d);
    private static final SpringConfig f8204j = SpringConfig.a(10.0d, 3.5d);
    private static final SpringConfig f8205k = SpringConfig.a(20.0d, 3.5d);
    private View f8206A;
    private View f8207B;
    public GestureDetector f8208C;
    public Spring f8209D;
    public Spring f8210E;
    public Spring f8211F;
    public float f8212G;
    public int f8213H;
    public Listener f8214I;
    public final OnTouchListener f8215J = new C09201(this);
    @Inject
    BballScene f8216a;
    @Inject
    BigEmojis f8217b;
    @Inject
    Emojis f8218c;
    @Inject
    FBSoundUtil f8219d;
    @Inject
    @LoggedInUser
    User f8220e;
    @Inject
    SpringSystem f8221f;
    private final Random f8222l = new Random();
    private BballGame f8223m;
    private BballViewHelper f8224n;
    private View f8225o;
    public TextView f8226p;
    public View f8227q;
    private TextView f8228r;
    private View f8229s;
    private UserTileView f8230t;
    private TextView f8231u;
    public ImageView f8232v;
    private View f8233w;
    public View f8234x;
    private View f8235y;
    public View f8236z;

    /* compiled from: openGroupCreateFlow() not supported yet */
    public interface Listener {
        void mo300a();
    }

    /* compiled from: openGroupCreateFlow() not supported yet */
    class C09201 implements OnTouchListener {
        final /* synthetic */ BballView f8192a;

        C09201(BballView bballView) {
            this.f8192a = bballView;
        }

        public boolean onTouch(View view, MotionEvent motionEvent) {
            this.f8192a.f8208C.onTouchEvent(motionEvent);
            return true;
        }
    }

    /* compiled from: openGroupCreateFlow() not supported yet */
    public class C09212 {
        final /* synthetic */ BballView f8193a;

        C09212(BballView bballView) {
            this.f8193a = bballView;
        }

        public final void m8428a() {
            this.f8193a.f8209D;
        }

        public final void m8429a(boolean z) {
            BballView.setRimCoversBall(this.f8193a, z);
        }
    }

    /* compiled from: openGroupCreateFlow() not supported yet */
    class C09223 implements com.facebook.messaging.bball.BballScene.Listener {
        final /* synthetic */ BballView f8194a;

        C09223(BballView bballView) {
            this.f8194a = bballView;
        }

        public final void mo301a() {
            this.f8194a.m8444a(2131165249);
            this.f8194a.f8234x.setOnTouchListener(this.f8194a.f8215J);
        }

        public final void mo302b() {
        }

        public final void mo303c() {
            this.f8194a.m8444a(2131165251);
        }

        public final void mo304d() {
            this.f8194a.m8444a(2131165250);
            this.f8194a.m8454a(false);
        }

        public final void mo305e() {
            this.f8194a.m8444a(2131165252);
            this.f8194a.m8454a(true);
        }

        public final void mo306f() {
        }
    }

    /* compiled from: openGroupCreateFlow() not supported yet */
    public class C09234 {
        final /* synthetic */ BballView f8195a;

        C09234(BballView bballView) {
            this.f8195a = bballView;
        }

        public final void m8437a(int i) {
            BballView bballView = this.f8195a;
            BballView.m8451a(this.f8195a.f8209D, false);
            bballView = this.f8195a;
            BballView.m8451a(this.f8195a.f8210E, true);
            BballView.setDisplayScore(this.f8195a, i);
        }

        public final void m8436a() {
            BballView bballView = this.f8195a;
            BballView.m8451a(this.f8195a.f8209D, true);
            bballView = this.f8195a;
            BballView.m8451a(this.f8195a.f8210E, false);
        }
    }

    /* compiled from: openGroupCreateFlow() not supported yet */
    class C09245 extends SimpleOnGestureListener {
        final /* synthetic */ BballView f8196a;

        C09245(BballView bballView) {
            this.f8196a = bballView;
        }

        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            if (f2 >= 0.0f) {
                return false;
            }
            this.f8196a.m8444a(2131165253);
            this.f8196a.f8234x.setOnTouchListener(null);
            BballView bballView = this.f8196a;
            BballView.m8451a(this.f8196a.f8209D, false);
            this.f8196a.f8216a.m8423a(f, f2);
            return true;
        }
    }

    /* compiled from: openGroupCreateFlow() not supported yet */
    class C09256 implements OnClickListener {
        final /* synthetic */ BballView f8197a;

        C09256(BballView bballView) {
            this.f8197a = bballView;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -699772702);
            if (this.f8197a.f8214I != null) {
                this.f8197a.f8214I.mo300a();
            }
            Logger.a(2, EntryType.UI_INPUT_END, -1977602309, a);
        }
    }

    /* compiled from: openGroupCreateFlow() not supported yet */
    class FeedbackEmojiSpringListener extends SimpleSpringListener {
        final /* synthetic */ BballView f8198a;

        public FeedbackEmojiSpringListener(BballView bballView) {
            this.f8198a = bballView;
        }

        public final void m8440c(Spring spring) {
            this.f8198a.f8232v.setVisibility(0);
        }

        public final void m8438a(Spring spring) {
            float d = (float) spring.d();
            this.f8198a.f8232v.setAlpha(d);
            float f = this.f8198a.f8212G;
            float height = this.f8198a.f8212G - ((float) (this.f8198a.f8236z.getHeight() / 2));
            if (spring.i == 1.0d) {
                this.f8198a.f8232v.setTranslationY((d * (height - f)) + f);
            } else {
                this.f8198a.f8232v.setTranslationY(((1.0f - d) * (height - f)) + height);
            }
        }

        public final void m8439b(Spring spring) {
            if (this.f8198a.f8211F.i == 1.0d) {
                Spring spring2 = this.f8198a.f8211F;
                spring2.c = true;
                spring2.b(0.0d);
                return;
            }
            this.f8198a.f8232v.setVisibility(4);
        }
    }

    /* compiled from: openGroupCreateFlow() not supported yet */
    class ShowBestScoreSpringListener extends SimpleSpringListener {
        final /* synthetic */ BballView f8199a;

        public ShowBestScoreSpringListener(BballView bballView) {
            this.f8199a = bballView;
        }

        public final void m8441a(Spring spring) {
            float d = (float) spring.d();
            this.f8199a.f8227q.setAlpha(d);
            this.f8199a.f8227q.setScaleX(d);
            this.f8199a.f8227q.setScaleY(d);
        }
    }

    /* compiled from: openGroupCreateFlow() not supported yet */
    class ShowCurrentScoreSpringListener extends SimpleSpringListener {
        final /* synthetic */ BballView f8200a;

        public ShowCurrentScoreSpringListener(BballView bballView) {
            this.f8200a = bballView;
        }

        public final void m8442a(Spring spring) {
            float d = (float) spring.d();
            this.f8200a.f8226p.setAlpha(d);
            this.f8200a.f8226p.setScaleX(d);
            this.f8200a.f8226p.setScaleY(d);
        }
    }

    private static <T extends View> void m8452a(Class<T> cls, T t) {
        m8453a((Object) t, t.getContext());
    }

    private static void m8453a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((BballView) obj).m8447a(new BballScene((ChoreographerWrapper) DefaultChoreographerWrapper.a(fbInjector)), BigEmojisMethodAutoProvider.a(fbInjector), Emojis.a(fbInjector), (FBSoundUtil) Fb4aSoundUtil.a(fbInjector), User_LoggedInUserMethodAutoProvider.b(fbInjector), SpringSystem.b(fbInjector));
    }

    private void m8447a(BballScene bballScene, BigEmojis bigEmojis, Emojis emojis, FBSoundUtil fBSoundUtil, User user, SpringSystem springSystem) {
        this.f8216a = bballScene;
        this.f8217b = bigEmojis;
        this.f8218c = emojis;
        this.f8219d = fBSoundUtil;
        this.f8220e = user;
        this.f8221f = springSystem;
    }

    public BballView(Context context) {
        super(context);
        m8455b();
    }

    public BballView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m8455b();
    }

    public BballView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m8455b();
    }

    private void m8455b() {
        m8452a(BballView.class, (View) this);
        LayoutInflater.from(getContext()).inflate(2130905311, this);
        this.f8225o = c(2131559455);
        this.f8226p = (TextView) c(2131563947);
        this.f8227q = c(2131563948);
        this.f8228r = (TextView) c(2131563949);
        this.f8229s = c(2131563944);
        this.f8230t = (UserTileView) c(2131563946);
        this.f8231u = (TextView) c(2131563945);
        this.f8232v = (ImageView) c(2131563953);
        this.f8234x = c(2131563955);
        this.f8235y = c(2131563954);
        this.f8236z = c(2131563951);
        this.f8206A = c(2131563950);
        this.f8233w = c(2131563952);
        this.f8207B = c(2131558894);
        this.f8209D = this.f8221f.a().a(f8203i).a(new ShowBestScoreSpringListener(this)).a(0.0d);
        this.f8210E = this.f8221f.a().a(f8203i).a(new ShowCurrentScoreSpringListener(this)).a(0.0d);
        this.f8216a.f8190t = new C09212(this);
        this.f8216a.m8424a(new C09223(this));
        this.f8223m = new BballGame(this.f8216a);
        this.f8223m.f8155g = new C09234(this);
        this.f8224n = new BballViewHelper(this.f8216a);
        this.f8208C = new GestureDetector(getContext(), new C09245(this));
        this.f8208C.setIsLongpressEnabled(false);
        this.f8225o.setOnClickListener(new C09256(this));
        setDisplayScore(this, 0);
        this.f8226p.setText("0");
        this.f8228r.setText("0");
        this.f8223m.f8149a.m8426h();
    }

    private void m8444a(int i) {
        this.f8219d.a(i, 3, 1.0f);
    }

    public void setListener(Listener listener) {
        this.f8214I = listener;
    }

    public final void m8471a(String str, int i) {
        this.f8229s.setVisibility(0);
        this.f8230t.setParams(UserTileViewParams.a(UserKey.b(str)));
        this.f8231u.setText(String.valueOf(i));
    }

    public int getBestScore() {
        return this.f8213H;
    }

    public final boolean m8472a() {
        return this.f8223m.f8153e;
    }

    public int getAttemptCount() {
        return this.f8223m.f8154f;
    }

    private void m8454a(boolean z) {
        Spring a;
        SpringConfig springConfig;
        int[] iArr = z ? f8201g : f8202h;
        this.f8218c.a(iArr[this.f8222l.nextInt(iArr.length)], 0);
        this.f8232v.setImageResource(this.f8217b.a());
        this.f8212G = this.f8224n.m8480g() + ((float) (getHeight() / 2));
        this.f8232v.setTranslationX(this.f8224n.m8479f());
        if (this.f8211F == null) {
            a = this.f8221f.a();
            a.l = 0.03d;
            a = a;
            a.k = 0.03d;
            this.f8211F = a.a(new FeedbackEmojiSpringListener(this));
        }
        Spring spring = this.f8211F;
        if (z) {
            springConfig = f8205k;
        } else {
            springConfig = f8204j;
        }
        a = spring.a(springConfig);
        a.c = false;
        a.a(0.0d).c(0.0d).b(1.0d);
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (z) {
            this.f8224n.m8474a(getWidth(), getHeight());
            m8446a(this.f8234x, this.f8224n.m8473a(), this.f8224n.m8473a());
            m8446a(this.f8235y, this.f8224n.m8477d(), this.f8224n.m8478e());
            m8446a(this.f8233w, this.f8224n.m8484k(), this.f8224n.m8485l());
            m8446a(this.f8236z, this.f8224n.m8482i(), this.f8224n.m8483j());
            m8446a(this.f8206A, this.f8224n.m8486m(), this.f8224n.m8487n());
            m8445a(this.f8207B, this.f8224n.m8488o());
            float height = ((((float) getHeight()) + this.f8224n.m8481h()) - ((float) this.f8207B.getHeight())) / 2.0f;
            this.f8226p.setTranslationY(height);
            this.f8227q.setTranslationY(height);
            this.f8209D;
        }
    }

    public static void m8462e(BballView bballView) {
        float f = bballView.f8224n.m8479f();
        bballView.f8236z.setTranslationX(f);
        bballView.f8206A.setTranslationX(f);
        bballView.f8233w.setTranslationX(f);
        bballView.f8235y.setTranslationX(f);
        bballView.f8235y.setTranslationY(bballView.f8224n.m8480g());
        bballView.f8233w.setTranslationY(bballView.f8224n.m8490q());
        bballView.f8236z.setTranslationY(bballView.f8224n.m8489p());
        bballView.f8206A.setTranslationY(bballView.f8224n.m8491r());
        bballView.f8234x.setScaleX(bballView.f8216a.f8177g);
        bballView.f8234x.setScaleY(bballView.f8216a.f8177g);
        bballView.f8234x.setTranslationX(bballView.f8224n.m8475b());
        bballView.f8234x.setTranslationY(bballView.f8224n.m8476c());
        bballView.f8234x.setRotation(bballView.f8216a.f8179i);
    }

    public static void setRimCoversBall(BballView bballView, boolean z) {
        bballView.removeView(bballView.f8234x);
        if (z) {
            bballView.addView(bballView.f8234x, bballView.indexOfChild(bballView.f8235y));
        } else {
            bballView.addView(bballView.f8234x);
        }
    }

    private static void m8446a(View view, int i, int i2) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        if (layoutParams.width != i || layoutParams.height != i2) {
            layoutParams.width = i;
            layoutParams.height = i2;
            view.setLayoutParams(layoutParams);
        }
    }

    private static void m8445a(View view, int i) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        if (layoutParams.height != i) {
            layoutParams.height = i;
            view.setLayoutParams(layoutParams);
        }
    }

    public static void setDisplayScore(BballView bballView, int i) {
        if (i > 0) {
            bballView.f8210E.a(0.0d).c(0.0d);
            m8451a(bballView.f8210E, true);
            bballView.f8226p.setText(String.valueOf(i));
        }
        if (i > bballView.f8213H) {
            bballView.f8213H = i;
            bballView.f8228r.setText(String.valueOf(bballView.f8213H));
        }
    }

    public static void m8451a(Spring spring, boolean z) {
        boolean z2;
        double d;
        if (z) {
            z2 = false;
        } else {
            z2 = true;
        }
        spring.c = z2;
        Spring spring2 = spring;
        if (z) {
            d = 1.0d;
        } else {
            d = 0.0d;
        }
        spring2.b(d);
    }

    protected void onDetachedFromWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, -495340996);
        super.onDetachedFromWindow();
        if (this.f8209D != null) {
            this.f8209D.a();
            this.f8209D = null;
        }
        if (this.f8210E != null) {
            this.f8210E.a();
            this.f8210E = null;
        }
        if (this.f8211F != null) {
            this.f8211F.a();
            this.f8211F = null;
        }
        if (this.f8216a != null) {
            BballScene bballScene = this.f8216a;
            bballScene.f8171a.b(bballScene.f8191u);
        }
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, -1232704598, a);
    }
}
