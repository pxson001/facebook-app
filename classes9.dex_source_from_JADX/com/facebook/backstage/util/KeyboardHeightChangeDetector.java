package com.facebook.backstage.util;

import android.annotation.TargetApi;
import android.app.Activity;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.WindowManager;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

@TargetApi(16)
/* compiled from: risk_security_code_fragment_tag */
public class KeyboardHeightChangeDetector {
    private static KeyboardHeightChangeDetector f5572a;
    public final Handler f5573b = new Handler(Looper.getMainLooper());
    public final List<WeakReference<OnKeyboardHeightChangeListener>> f5574c = new ArrayList();
    public WindowManager f5575d;
    public View f5576e;
    public OnGlobalLayoutListener f5577f;
    public int f5578g = -1;
    public int f5579h = -1;
    public boolean f5580i;

    /* compiled from: risk_security_code_fragment_tag */
    public interface OnKeyboardHeightChangeListener {
        void mo159a(int i);
    }

    /* compiled from: risk_security_code_fragment_tag */
    public class C05881 implements OnGlobalLayoutListener {
        final /* synthetic */ View f5568a;
        final /* synthetic */ Activity f5569b;
        final /* synthetic */ KeyboardHeightChangeDetector f5570c;

        public C05881(KeyboardHeightChangeDetector keyboardHeightChangeDetector, View view, Activity activity) {
            this.f5570c = keyboardHeightChangeDetector;
            this.f5568a = view;
            this.f5569b = activity;
        }

        public void onGlobalLayout() {
            this.f5568a.getViewTreeObserver().removeGlobalOnLayoutListener(this);
            KeyboardHeightChangeDetector.m5773a(this.f5570c, this.f5569b, this.f5568a.getWindowToken());
        }
    }

    /* compiled from: risk_security_code_fragment_tag */
    class C05892 implements OnGlobalLayoutListener {
        final /* synthetic */ KeyboardHeightChangeDetector f5571a;

        C05892(KeyboardHeightChangeDetector keyboardHeightChangeDetector) {
            this.f5571a = keyboardHeightChangeDetector;
        }

        public void onGlobalLayout() {
            KeyboardHeightChangeDetector keyboardHeightChangeDetector = this.f5571a;
            int height = this.f5571a.f5576e.getHeight();
            OnKeyboardHeightChangeListener onKeyboardHeightChangeListener;
            if (keyboardHeightChangeDetector.f5579h == -1) {
                keyboardHeightChangeDetector.f5579h = height;
                keyboardHeightChangeDetector.f5578g = height;
                Collection hashSet = new HashSet();
                for (WeakReference weakReference : keyboardHeightChangeDetector.f5574c) {
                    onKeyboardHeightChangeListener = (OnKeyboardHeightChangeListener) weakReference.get();
                    if (onKeyboardHeightChangeListener != null) {
                        onKeyboardHeightChangeListener.mo159a(0);
                    } else {
                        hashSet.add(weakReference);
                    }
                }
                keyboardHeightChangeDetector.f5574c.removeAll(hashSet);
            } else if (keyboardHeightChangeDetector.f5578g != height) {
                int max = Math.max(keyboardHeightChangeDetector.f5579h - height, 0);
                keyboardHeightChangeDetector.f5578g = height;
                Collection hashSet2 = new HashSet();
                for (WeakReference weakReference2 : keyboardHeightChangeDetector.f5574c) {
                    onKeyboardHeightChangeListener = (OnKeyboardHeightChangeListener) weakReference2.get();
                    if (onKeyboardHeightChangeListener != null) {
                        onKeyboardHeightChangeListener.mo159a(max);
                    } else {
                        hashSet2.add(weakReference2);
                    }
                }
                keyboardHeightChangeDetector.f5574c.removeAll(hashSet2);
            }
        }
    }

    public static KeyboardHeightChangeDetector m5772a() {
        if (f5572a == null) {
            f5572a = new KeyboardHeightChangeDetector();
        }
        return f5572a;
    }

    private KeyboardHeightChangeDetector() {
    }

    public static Activity m5774b(Activity activity) {
        return activity.getParent() != null ? activity.getParent() : activity;
    }

    public static void m5773a(KeyboardHeightChangeDetector keyboardHeightChangeDetector, Activity activity, IBinder iBinder) {
        keyboardHeightChangeDetector.f5575d = (WindowManager) activity.getSystemService("window");
        keyboardHeightChangeDetector.f5576e = new View(activity);
        LayoutParams layoutParams = new WindowManager.LayoutParams(-1, -1, 1003, 131096, -3);
        layoutParams.softInputMode = 16;
        layoutParams.token = iBinder;
        keyboardHeightChangeDetector.f5575d.addView(keyboardHeightChangeDetector.f5576e, layoutParams);
        keyboardHeightChangeDetector.f5577f = new C05892(keyboardHeightChangeDetector);
        keyboardHeightChangeDetector.f5576e.getViewTreeObserver().addOnGlobalLayoutListener(keyboardHeightChangeDetector.f5577f);
        keyboardHeightChangeDetector.f5580i = true;
    }

    public final void m5775a(OnKeyboardHeightChangeListener onKeyboardHeightChangeListener) {
        this.f5574c.add(new WeakReference(onKeyboardHeightChangeListener));
    }
}
