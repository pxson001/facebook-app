package com.facebook.messaging.emoji;

import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.facebook.inject.InjectorLike;
import com.facebook.tools.dextr.runtime.detour.HandlerDetour;

/* compiled from: mangle_request_packets */
public class KeyRepeaterTouchListener implements OnTouchListener {
    public final Handler f10976a = new Handler();
    private final Runnable f10977b = new C12101(this);
    public Listener f10978c;

    /* compiled from: mangle_request_packets */
    public interface Listener {
        void mo424a();
    }

    /* compiled from: mangle_request_packets */
    class C12101 implements Runnable {
        final /* synthetic */ KeyRepeaterTouchListener f10975a;

        C12101(KeyRepeaterTouchListener keyRepeaterTouchListener) {
            this.f10975a = keyRepeaterTouchListener;
        }

        public void run() {
            KeyRepeaterTouchListener.m11388c(this.f10975a);
            HandlerDetour.b(this.f10975a.f10976a, this, 100, -346869448);
        }
    }

    public static KeyRepeaterTouchListener m11385a(InjectorLike injectorLike) {
        return new KeyRepeaterTouchListener();
    }

    public final void m11389a(Listener listener) {
        this.f10978c = listener;
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        switch (motionEvent.getActionMasked()) {
            case 0:
                m11386a();
                view.performHapticFeedback(3);
                break;
            case 1:
            case 3:
                m11387b();
                break;
        }
        return false;
    }

    private void m11386a() {
        m11387b();
        HandlerDetour.b(this.f10976a, this.f10977b, 400, -168442239);
        m11388c(this);
    }

    private void m11387b() {
        HandlerDetour.a(this.f10976a, this.f10977b);
    }

    public static void m11388c(KeyRepeaterTouchListener keyRepeaterTouchListener) {
        if (keyRepeaterTouchListener.f10978c != null) {
            keyRepeaterTouchListener.f10978c.mo424a();
        }
    }
}
