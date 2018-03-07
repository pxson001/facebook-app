package com.facebook.drawee.controller;

import android.graphics.drawable.Animatable;
import android.util.Log;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Nullable;
import javax.annotation.concurrent.ThreadSafe;

@ThreadSafe
/* compiled from: marker */
public class ForwardingControllerListener<INFO> implements ControllerListener<INFO> {
    private final List<ControllerListener<? super INFO>> f15043a = new ArrayList(2);

    public final synchronized void m21586a(ControllerListener<? super INFO> controllerListener) {
        this.f15043a.add(controllerListener);
    }

    public final synchronized void m21591b(ControllerListener<? super INFO> controllerListener) {
        this.f15043a.remove(controllerListener);
    }

    public final synchronized void m21585a() {
        this.f15043a.clear();
    }

    private synchronized void m21584c(String str, Throwable th) {
        Log.e("FdingControllerListener", str, th);
    }

    public final synchronized void mo2605a(String str, Object obj) {
        int size = this.f15043a.size();
        for (int i = 0; i < size; i++) {
            try {
                ((ControllerListener) this.f15043a.get(i)).mo2605a(str, obj);
            } catch (Throwable e) {
                m21584c("InternalListener exception in onSubmit", e);
            }
        }
    }

    public final synchronized void mo2603a(String str, @Nullable INFO info, @Nullable Animatable animatable) {
        int size = this.f15043a.size();
        for (int i = 0; i < size; i++) {
            try {
                ((ControllerListener) this.f15043a.get(i)).mo2603a(str, info, animatable);
            } catch (Throwable e) {
                m21584c("InternalListener exception in onFinalImageSet", e);
            }
        }
    }

    public final void mo2607b(String str, @Nullable INFO info) {
        int size = this.f15043a.size();
        for (int i = 0; i < size; i++) {
            try {
                ((ControllerListener) this.f15043a.get(i)).mo2607b(str, (Object) info);
            } catch (Throwable e) {
                m21584c("InternalListener exception in onIntermediateImageSet", e);
            }
        }
    }

    public final void mo2606a(String str, Throwable th) {
        int size = this.f15043a.size();
        for (int i = 0; i < size; i++) {
            try {
                ((ControllerListener) this.f15043a.get(i)).mo2606a(str, th);
            } catch (Throwable e) {
                m21584c("InternalListener exception in onIntermediateImageFailed", e);
            }
        }
    }

    public final synchronized void mo2608b(String str, Throwable th) {
        int size = this.f15043a.size();
        for (int i = 0; i < size; i++) {
            try {
                ((ControllerListener) this.f15043a.get(i)).mo2608b(str, th);
            } catch (Throwable e) {
                m21584c("InternalListener exception in onFailure", e);
            }
        }
    }

    public final synchronized void mo2604a(String str) {
        int size = this.f15043a.size();
        for (int i = 0; i < size; i++) {
            try {
                ((ControllerListener) this.f15043a.get(i)).mo2604a(str);
            } catch (Throwable e) {
                m21584c("InternalListener exception in onRelease", e);
            }
        }
    }
}
