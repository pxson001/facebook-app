package com.facebook.backstage.nub;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.WindowManager;
import com.facebook.backstage.StacksConstants;
import com.facebook.backstage.consumption.ScreenUtil;
import com.facebook.debug.log.BLog;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.runtimepermissions.RuntimePermissionsUtil;
import javax.inject.Inject;

/* compiled from: requestFbId */
public class FloatingWindowManager {
    private static final String f5419a = FloatingWindowManager.class.getSimpleName();
    private final OnTouchListener f5420b = new C05691(this);
    private final C05702 f5421c = new C05702(this);
    private final int[] f5422d = new int[2];
    public final WindowManagerDrawerController f5423e;
    public final Context f5424f;
    private final WindowManager f5425g;
    public final NubWindow f5426h;
    public final FullWindow f5427i;
    public final ProxyFullWindow f5428j;
    public final ScreenUtil f5429k;
    public final FbSharedPreferences f5430l;
    private final RuntimePermissionsUtil f5431m;
    public boolean f5432n;

    /* compiled from: requestFbId */
    class C05691 implements OnTouchListener {
        final /* synthetic */ FloatingWindowManager f5414a;

        C05691(FloatingWindowManager floatingWindowManager) {
            this.f5414a = floatingWindowManager;
        }

        public boolean onTouch(View view, MotionEvent motionEvent) {
            this.f5414a.f5423e.f5475f.onTouchEvent(motionEvent);
            return false;
        }
    }

    /* compiled from: requestFbId */
    public class C05702 {
        public final /* synthetic */ FloatingWindowManager f5415a;

        C05702(FloatingWindowManager floatingWindowManager) {
            this.f5415a = floatingWindowManager;
        }

        public final void m5644a() {
            this.f5415a.f5423e.m5705g();
        }
    }

    @Inject
    public FloatingWindowManager(Context context, WindowManager windowManager, ScreenUtil screenUtil, FbSharedPreferences fbSharedPreferences, RuntimePermissionsUtil runtimePermissionsUtil) {
        this.f5424f = context;
        this.f5425g = windowManager;
        this.f5429k = screenUtil;
        this.f5430l = fbSharedPreferences;
        this.f5431m = runtimePermissionsUtil;
        final FullWindowView opticsCameraFullWindowView = new OpticsCameraFullWindowView(this.f5424f, this.f5429k, this.f5421c);
        this.f5427i = new FullWindow(this.f5425g, opticsCameraFullWindowView);
        this.f5427i.m5651d();
        NubView nubView = new NubView(this.f5424f);
        nubView.setOnTouchListener(this.f5420b);
        this.f5426h = new NubWindow(this.f5425g, nubView);
        this.f5426h.m5681d();
        this.f5422d[0] = 0;
        this.f5422d[1] = this.f5429k.m4552b() / 3;
        this.f5422d[0] = this.f5430l.a(StacksConstants.f4259i, this.f5422d[0]);
        this.f5422d[1] = this.f5430l.a(StacksConstants.f4260j, this.f5422d[1]);
        View view = new View(this.f5424f);
        this.f5428j = new ProxyFullWindow(this.f5425g, view);
        view.setOnTouchListener(new OnTouchListener(this) {
            final /* synthetic */ FloatingWindowManager f5417b;

            public boolean onTouch(View view, MotionEvent motionEvent) {
                opticsCameraFullWindowView.f5442a.m5650d(motionEvent);
                return false;
            }
        });
        this.f5428j.m5695e();
        this.f5428j.m5640b(this.f5429k.m4553c());
        this.f5423e = new WindowManagerDrawerController(this.f5424f, this.f5426h, this.f5427i, this.f5428j, screenUtil, this.f5422d);
    }

    public final void m5646a(BackstageEventListener$EventType backstageEventListener$EventType, boolean z) {
        switch (backstageEventListener$EventType) {
            case SERVICE_STARTED:
            case ACTION_CLOSE_SYSTEM_DIALOGS:
            case ACTION_SCREEN_OFF:
            case ACTION_SCREEN_ON:
            case ACTION_USER_PRESENT:
                if (!this.f5431m.a() || !this.f5431m.a("android.permission.CAMERA")) {
                    return;
                }
                if (z && this.f5430l.a(StacksConstants.f4256f, true)) {
                    if (!this.f5432n) {
                        this.f5428j.m5639b();
                        this.f5426h.m5639b();
                        this.f5427i.m5639b();
                        this.f5423e.mo210e();
                    }
                    this.f5432n = true;
                    return;
                } else if (!this.f5430l.a(StacksConstants.f4261k, false)) {
                    break;
                } else {
                    return;
                }
            case ACTION_HIDE:
                break;
            default:
                BLog.b(f5419a, "Unknown event type : %s", new Object[]{backstageEventListener$EventType.name()});
                break;
        }
        if (this.f5432n) {
            m5645d(this);
        }
        this.f5432n = false;
    }

    public static void m5645d(FloatingWindowManager floatingWindowManager) {
        WindowManagerDrawerController windowManagerDrawerController = floatingWindowManager.f5423e;
        floatingWindowManager.f5430l.edit().a(StacksConstants.f4259i, windowManagerDrawerController.f5474e[0]).a(StacksConstants.f4260j, windowManagerDrawerController.f5474e[1]).commit();
        ((FullWindowView) windowManagerDrawerController.f5472c.f5411b).m5662b();
        floatingWindowManager.f5428j.m5642c();
        floatingWindowManager.f5426h.m5642c();
        floatingWindowManager.f5427i.m5642c();
    }
}
