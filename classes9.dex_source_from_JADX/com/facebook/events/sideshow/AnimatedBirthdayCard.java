package com.facebook.events.sideshow;

import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
import android.support.v7.widget.CardView;
import android.view.KeyEvent;
import android.view.KeyEvent.DispatcherState;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.device.ScreenUtil;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.events.sideshow.graphql.SideshowEventsAndBirthdaysQueryModels.SideshowEventsBirthdaysQueryModel.BirthdayFriendsModel.BirthdayPersonModel;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.resources.ui.FbEditText;
import com.facebook.resources.ui.FbTextView;
import com.facebook.ui.animations.stateanimator.StateAnimator;
import com.facebook.ui.animations.stateanimator.StateAnimator.StateChangeListener;
import com.facebook.ui.animations.stateanimator.ViewState.Builder;
import com.facebook.ui.keyboard.KeyboardUtils;
import javax.inject.Inject;

/* compiled from: TYPE_UINT64 */
public class AnimatedBirthdayCard extends FrameLayout implements StateChangeListener {
    private static final CallerContext f24381b = CallerContext.a(EventsSideshowUnit.class);
    @Inject
    public ScreenUtil f24382a;
    public StateAnimator f24383c;
    private CardView f24384d = ((CardView) findViewById(2131559580));
    private FbDraweeView f24385e = ((FbDraweeView) findViewById(2131559581));
    private FbTextView f24386f = ((FbTextView) findViewById(2131559582));
    private FbTextView f24387g = ((FbTextView) findViewById(2131559583));
    private FbTextView f24388h = ((FbTextView) findViewById(2131559586));
    private FbEditText f24389i = ((FbEditText) findViewById(2131559584));
    private FbTextView f24390j = ((FbTextView) findViewById(2131559585));
    private Context f24391k;
    private Resources f24392l;
    private BirthdayCardController f24393m;
    private String f24394n;
    private boolean f24395o;

    /* compiled from: TYPE_UINT64 */
    class C29231 implements OnEditorActionListener {
        final /* synthetic */ AnimatedBirthdayCard f24377a;

        C29231(AnimatedBirthdayCard animatedBirthdayCard) {
            this.f24377a = animatedBirthdayCard;
        }

        public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
            if (i != 4) {
                return false;
            }
            AnimatedBirthdayCard.m26237c(this.f24377a);
            return true;
        }
    }

    /* compiled from: TYPE_UINT64 */
    class C29242 implements OnClickListener {
        final /* synthetic */ AnimatedBirthdayCard f24378a;

        C29242(AnimatedBirthdayCard animatedBirthdayCard) {
            this.f24378a = animatedBirthdayCard;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -828420435);
            this.f24378a.m26240b();
            Logger.a(2, EntryType.UI_INPUT_END, 706888361, a);
        }
    }

    /* compiled from: TYPE_UINT64 */
    class C29253 implements OnClickListener {
        final /* synthetic */ AnimatedBirthdayCard f24379a;

        C29253(AnimatedBirthdayCard animatedBirthdayCard) {
            this.f24379a = animatedBirthdayCard;
        }

        public void onClick(View view) {
            Logger.a(2, EntryType.UI_INPUT_END, -724345726, Logger.a(2, EntryType.UI_INPUT_START, -2006715330));
        }
    }

    /* compiled from: TYPE_UINT64 */
    class C29264 implements OnClickListener {
        final /* synthetic */ AnimatedBirthdayCard f24380a;

        C29264(AnimatedBirthdayCard animatedBirthdayCard) {
            this.f24380a = animatedBirthdayCard;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -1849036282);
            AnimatedBirthdayCard.m26237c(this.f24380a);
            Logger.a(2, EntryType.UI_INPUT_END, 661984419, a);
        }
    }

    public static void m26236a(Object obj, Context context) {
        ((AnimatedBirthdayCard) obj).f24382a = ScreenUtil.a(FbInjector.get(context));
    }

    public AnimatedBirthdayCard(Context context, int i, int i2) {
        super(context);
        Class cls = AnimatedBirthdayCard.class;
        m26236a((Object) this, getContext());
        this.f24391k = context;
        this.f24392l = context.getResources();
        LayoutInflater.from(context).inflate(2130903251, this);
        float dimension = this.f24392l.getDimension(2131433971);
        int dimensionPixelOffset = this.f24392l.getDimensionPixelOffset(2131433974);
        int c = (this.f24382a.c() - this.f24392l.getDimensionPixelOffset(2131433970)) / 2;
        Builder a = new StateAnimator.Builder().a(this.f24385e).a(new int[]{2, 3});
        a.d = -dimension;
        a = a.a(this.f24386f).a(new int[]{2, 3});
        a.b = 0.0f;
        a = a;
        a.d = -dimension;
        a = a.a(this.f24387g).a(new int[]{2, 3});
        a.b = 0.0f;
        a = a;
        a.d = -dimension;
        a = a.a(this.f24389i).a(new int[]{2});
        a.b = 1.0f;
        a = a.a(new int[]{3});
        a.b = 0.5f;
        a = a.a(new int[]{1, 4});
        a.d = dimension;
        a = a.a(this.f24390j).a(new int[]{2});
        a.b = 1.0f;
        a = a.a(new int[]{3});
        a.b = 0.5f;
        a = a.a(new int[]{1, 4});
        a.d = dimension;
        Builder a2 = a.a(this).a(new int[]{1, 4});
        a2.d = (float) (i - dimensionPixelOffset);
        a2 = a2;
        a2.c = (float) (i2 - c);
        a2 = a2;
        a2.b();
        this.f24383c = a2.i.a();
        this.f24383c.a(1);
        this.f24383c.b.a(this);
    }

    public final void m26239a(BirthdayCardController birthdayCardController, BirthdayPersonModel birthdayPersonModel) {
        this.f24393m = birthdayCardController;
        this.f24394n = birthdayPersonModel.m26326k();
        if (!(birthdayPersonModel.m26328m() == null || birthdayPersonModel.m26328m().m26317a() == null)) {
            this.f24385e.a(Uri.parse(birthdayPersonModel.m26328m().m26317a()), f24381b);
        }
        if (birthdayPersonModel.m26325j() == null || !AgeCalculator.m26234a(birthdayPersonModel.m26325j())) {
            this.f24387g.setVisibility(4);
        } else {
            int b = AgeCalculator.m26235b(birthdayPersonModel.m26325j());
            this.f24387g.setVisibility(0);
            this.f24387g.setText(this.f24392l.getQuantityString(2131689797, b, new Object[]{Integer.valueOf(b)}));
        }
        if (birthdayPersonModel.m26327l() != null) {
            this.f24386f.setText(birthdayPersonModel.m26327l());
            this.f24389i.setHint(this.f24392l.getString(2131241416, new Object[]{birthdayPersonModel.m26327l()}));
            this.f24390j.setText(this.f24392l.getString(2131241418, new Object[]{birthdayPersonModel.m26327l()}));
        }
        this.f24389i.setOnEditorActionListener(new C29231(this));
        setOnClickListener(new C29242(this));
        this.f24384d.setOnClickListener(new C29253(this));
        this.f24384d.requestDisallowInterceptTouchEvent(false);
        this.f24388h.setOnClickListener(new C29264(this));
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() != 4) {
            return super.dispatchKeyEvent(keyEvent);
        }
        if (getKeyDispatcherState() == null) {
            return super.dispatchKeyEvent(keyEvent);
        }
        DispatcherState keyDispatcherState;
        if (keyEvent.getAction() == 0 && keyEvent.getRepeatCount() == 0) {
            keyDispatcherState = getKeyDispatcherState();
            if (keyDispatcherState == null) {
                return true;
            }
            keyDispatcherState.startTracking(keyEvent, this);
            return true;
        }
        if (keyEvent.getAction() == 1) {
            keyDispatcherState = getKeyDispatcherState();
            if (!(keyDispatcherState == null || !keyDispatcherState.isTracking(keyEvent) || keyEvent.isCanceled())) {
                m26240b();
                return true;
            }
        }
        return super.dispatchKeyEvent(keyEvent);
    }

    public final void m26240b() {
        this.f24395o = true;
        this.f24383c.a(4, 250);
    }

    public static void m26237c(AnimatedBirthdayCard animatedBirthdayCard) {
        if (!animatedBirthdayCard.f24395o) {
            animatedBirthdayCard.f24395o = true;
            String obj = animatedBirthdayCard.f24389i.getText().toString();
            if (obj.length() > 0) {
                animatedBirthdayCard.f24393m.m26264a(animatedBirthdayCard.f24394n, obj);
            }
            animatedBirthdayCard.m26240b();
        }
    }

    public final void m26238a(int i) {
        if (i == 4) {
            this.f24393m.m26261a();
        }
        if (i == 2 || i == 3) {
            this.f24388h.setText(2131241417);
        } else {
            this.f24388h.setText(2131241414);
        }
    }

    public final void m26241b(int i) {
        if (i == 2) {
            this.f24389i.setFocusable(false);
            KeyboardUtils.a(this.f24391k, this.f24389i);
        }
    }

    public final void m26242c(int i) {
        if (i == 2) {
            this.f24389i.setFocusable(true);
            KeyboardUtils.b(this.f24391k, this.f24389i);
        } else if (i == 4) {
            this.f24393m.m26266b();
        }
    }
}
