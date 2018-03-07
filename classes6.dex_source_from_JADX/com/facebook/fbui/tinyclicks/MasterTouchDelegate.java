package com.facebook.fbui.tinyclicks;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Handler;
import android.os.Looper;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import com.facebook.fbui.tinyclicks.widget.MasterTouchDelegateLayout;
import com.facebook.inject.InjectorLike;
import com.facebook.tools.dextr.runtime.detour.HandlerDetour;
import com.google.common.base.Preconditions;
import javax.inject.Inject;

/* compiled from: nicknamesMap */
public class MasterTouchDelegate {
    private static final Class<?> f10013a = MasterTouchDelegate.class;
    private int f10014b;
    private int f10015c;
    private int f10016d;
    private int f10017e;
    public int f10018f;
    public DefaultTouchTargetFinder f10019g = null;
    public TouchTarget f10020h = null;
    private MasterTouchDelegateController f10021i = null;
    private MasterTouchDelegateLayout f10022j = null;
    public Paint f10023k = null;
    public final Handler f10024l;
    public final Runnable f10025m = new C06061(this);

    /* compiled from: nicknamesMap */
    class C06061 implements Runnable {
        final /* synthetic */ MasterTouchDelegate f10012a;

        C06061(MasterTouchDelegate masterTouchDelegate) {
            this.f10012a = masterTouchDelegate;
        }

        public void run() {
            MasterTouchDelegate masterTouchDelegate = this.f10012a;
            TouchTarget touchTarget = masterTouchDelegate.f10020h;
            if (touchTarget != null && touchTarget.f10033b != null) {
                MotionEvent obtain = MotionEvent.obtain(0, 0, 3, (float) masterTouchDelegate.f10018f, (float) masterTouchDelegate.f10018f, 0);
                touchTarget.f10033b.dispatchTouchEvent(obtain);
                obtain.recycle();
            }
        }
    }

    public static MasterTouchDelegate m15707b(InjectorLike injectorLike) {
        return new MasterTouchDelegate((Context) injectorLike.getInstance(Context.class), MasterTouchDelegateController.m15715a(injectorLike), new DefaultTouchTargetFinder((Context) injectorLike.getInstance(Context.class)));
    }

    @Inject
    public MasterTouchDelegate(Context context, MasterTouchDelegateController masterTouchDelegateController, DefaultTouchTargetFinder defaultTouchTargetFinder) {
        this.f10021i = masterTouchDelegateController;
        this.f10019g = defaultTouchTargetFinder;
        this.f10014b = ViewConfiguration.get(context).getScaledTouchSlop();
        this.f10017e = ViewConfiguration.getTapTimeout();
        this.f10018f = this.f10014b * -2;
        this.f10024l = new Handler(Looper.getMainLooper());
    }

    public final void m15712a(MasterTouchDelegateLayout masterTouchDelegateLayout) {
        Preconditions.checkArgument(masterTouchDelegateLayout instanceof ViewGroup, "MasterTouchDelegateLayout MUST be a ViewGroup");
        this.f10022j = masterTouchDelegateLayout;
    }

    private boolean m15708c() {
        return this.f10021i.f10031d;
    }

    private boolean m15706a(int i, int i2) {
        if (this.f10015c < 0 || this.f10016d < 0) {
            return true;
        }
        int abs = Math.abs(i - this.f10015c);
        int abs2 = Math.abs(i2 - this.f10016d);
        if (abs <= this.f10014b && abs2 <= this.f10014b) {
            return false;
        }
        this.f10015c = -1;
        this.f10016d = -1;
        return true;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean m15713a(android.view.MotionEvent r12) {
        /*
        r11 = this;
        r9 = 0;
        r1 = 1;
        r2 = 0;
        r0 = r11.f10021i;
        r10 = r0.f10030c;
        r0 = r10;
        if (r0 != 0) goto L_0x000b;
    L_0x000a:
        return r2;
    L_0x000b:
        r4 = r12.getX();
        r5 = r12.getY();
        r3 = r11.f10020h;
        r6 = r12.getAction();
        r0 = r12.getAction();
        switch(r0) {
            case 0: goto L_0x004e;
            case 1: goto L_0x006f;
            case 2: goto L_0x0082;
            case 3: goto L_0x006f;
            default: goto L_0x0020;
        };
    L_0x0020:
        r0 = r3;
    L_0x0021:
        if (r0 == 0) goto L_0x0040;
    L_0x0023:
        if (r1 == 0) goto L_0x0090;
    L_0x0025:
        r1 = (int) r4;
        r1 = r0.m15719a(r1);
        r1 = (float) r1;
        r3 = (int) r5;
        r3 = r0.m15721b(r3);
        r3 = (float) r3;
        r12.setLocation(r1, r3);
    L_0x0034:
        r10 = r0.f10032a;
        r0 = r10;
        r0.dispatchTouchEvent(r12);
        r12.setAction(r6);
        r12.setLocation(r4, r5);
    L_0x0040:
        r0 = r11.m15708c();
        if (r0 == 0) goto L_0x000a;
    L_0x0046:
        r0 = r11.f10022j;
        r0 = (android.view.ViewGroup) r0;
        r0.invalidate();
        goto L_0x000a;
    L_0x004e:
        r0 = (int) r4;
        r11.f10015c = r0;
        r0 = (int) r5;
        r11.f10016d = r0;
        r3 = r11.f10019g;
        r0 = r11.f10022j;
        r0 = (android.view.ViewGroup) r0;
        r7 = r11.f10015c;
        r8 = r11.f10016d;
        r0 = r3.m15702a(r0, r7, r8);
        r11.f10020h = r0;
        if (r0 == 0) goto L_0x0021;
    L_0x0066:
        r10 = r0.f10033b;
        r3 = r10;
        if (r3 == 0) goto L_0x0021;
    L_0x006b:
        r11.m15709e();
        goto L_0x0021;
    L_0x006f:
        if (r3 == 0) goto L_0x00a0;
    L_0x0071:
        r0 = (int) r4;
        r7 = (int) r5;
        r0 = r11.m15706a(r0, r7);
        if (r0 != 0) goto L_0x0080;
    L_0x0079:
        r0 = r1;
    L_0x007a:
        r1 = r0;
    L_0x007b:
        r11.f10020h = r9;
        r2 = r0;
        r0 = r3;
        goto L_0x0021;
    L_0x0080:
        r0 = r2;
        goto L_0x007a;
    L_0x0082:
        if (r3 == 0) goto L_0x0020;
    L_0x0084:
        r0 = (int) r4;
        r7 = (int) r5;
        r0 = r11.m15706a(r0, r7);
        if (r0 != 0) goto L_0x008e;
    L_0x008c:
        r0 = r3;
        goto L_0x0021;
    L_0x008e:
        r1 = r2;
        goto L_0x008c;
    L_0x0090:
        r1 = 3;
        r12.setAction(r1);
        r1 = r11.f10018f;
        r1 = (float) r1;
        r3 = r11.f10018f;
        r3 = (float) r3;
        r12.setLocation(r1, r3);
        r11.f10020h = r9;
        goto L_0x0034;
    L_0x00a0:
        r0 = r2;
        goto L_0x007b;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.fbui.tinyclicks.MasterTouchDelegate.a(android.view.MotionEvent):boolean");
    }

    public final void m15710a() {
        MasterTouchDelegateController masterTouchDelegateController = this.f10021i;
        MasterTouchDelegateLayout masterTouchDelegateLayout = this.f10022j;
        masterTouchDelegateController.f10029b.add(masterTouchDelegateLayout);
        masterTouchDelegateLayout.setWillNotDraw(!masterTouchDelegateController.f10031d);
    }

    public final void m15714b() {
        this.f10020h = null;
        MasterTouchDelegateController masterTouchDelegateController = this.f10021i;
        masterTouchDelegateController.f10029b.remove(this.f10022j);
    }

    public final void m15711a(Canvas canvas) {
        if (m15708c() && this.f10020h != null) {
            Rect rect = this.f10020h.f10035d;
            if (this.f10023k == null) {
                this.f10023k = new Paint();
                this.f10023k.setColor(Color.parseColor("#80FF0000"));
            }
            canvas.drawRect(rect, this.f10023k);
        }
    }

    private void m15709e() {
        HandlerDetour.a(this.f10024l, this.f10025m);
        HandlerDetour.b(this.f10024l, this.f10025m, (long) this.f10017e, -65351514);
    }
}
