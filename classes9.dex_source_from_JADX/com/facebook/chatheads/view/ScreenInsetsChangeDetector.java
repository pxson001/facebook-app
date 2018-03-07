package com.facebook.chatheads.view;

import android.content.Context;
import android.view.WindowManager;
import com.facebook.common.android.WindowManagerMethodAutoProvider;
import com.facebook.inject.InjectorLike;
import javax.inject.Inject;

/* compiled from: reaction_gametime_fan_favorite_add_vote */
public class ScreenInsetsChangeDetector {
    private final Context f5832a;
    private final WindowManager f5833b;

    private static ScreenInsetsChangeDetector m6048b(InjectorLike injectorLike) {
        return new ScreenInsetsChangeDetector((Context) injectorLike.getInstance(Context.class), WindowManagerMethodAutoProvider.b(injectorLike));
    }

    @Inject
    public ScreenInsetsChangeDetector(Context context, WindowManager windowManager) {
        this.f5832a = context;
        this.f5833b = windowManager;
    }
}
