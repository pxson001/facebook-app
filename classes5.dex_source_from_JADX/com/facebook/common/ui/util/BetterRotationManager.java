package com.facebook.common.ui.util;

import android.view.WindowManager;
import com.facebook.common.android.WindowManagerMethodAutoProvider;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: should_show_message_button */
public class BetterRotationManager {
    private WindowManager f2745a;
    private boolean f2746b;
    private boolean f2747c;
    private boolean f2748d;

    public static BetterRotationManager m3862b(InjectorLike injectorLike) {
        return new BetterRotationManager(WindowManagerMethodAutoProvider.b(injectorLike), IdBasedProvider.a(injectorLike, 3931), IdBasedProvider.a(injectorLike, 3930), IdBasedProvider.a(injectorLike, 3932));
    }

    @Inject
    public BetterRotationManager(WindowManager windowManager, Provider<Boolean> provider, Provider<Boolean> provider2, Provider<Boolean> provider3) {
        this.f2745a = windowManager;
        this.f2748d = ((Boolean) provider.get()).booleanValue();
        this.f2747c = ((Boolean) provider2.get()).booleanValue();
        this.f2746b = ((Boolean) provider3.get()).booleanValue();
    }

    public final int m3863a() {
        if (this.f2746b) {
            return (this.f2745a.getDefaultDisplay().getRotation() + 5) % 4;
        }
        if (this.f2747c) {
            return (this.f2745a.getDefaultDisplay().getRotation() + 6) % 4;
        }
        if (this.f2748d) {
            return (this.f2745a.getDefaultDisplay().getRotation() + 7) % 4;
        }
        return this.f2745a.getDefaultDisplay().getRotation();
    }

    public static BetterRotationManager m3861a(InjectorLike injectorLike) {
        return m3862b(injectorLike);
    }

    public final int m3864a(int i) {
        if (this.f2746b) {
            return (i + 270) % 360;
        }
        if (this.f2747c) {
            return (i + 180) % 360;
        }
        if (this.f2748d) {
            return (i + 90) % 360;
        }
        return i;
    }

    public final int m3865b() {
        return this.f2745a.getDefaultDisplay().getRotation();
    }
}
