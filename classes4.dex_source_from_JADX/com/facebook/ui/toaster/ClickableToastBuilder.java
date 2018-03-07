package com.facebook.ui.toaster;

import android.view.View;
import com.facebook.inject.InjectorLike;
import com.facebook.ui.toaster.ClickableToast.Style;
import javax.inject.Inject;

/* compiled from: experiments_filter */
public class ClickableToastBuilder {
    private final ClickableToastCoordinator f12588a;

    public static ClickableToastBuilder m13373b(InjectorLike injectorLike) {
        return new ClickableToastBuilder(ClickableToastCoordinator.m13375a(injectorLike));
    }

    @Inject
    public ClickableToastBuilder(ClickableToastCoordinator clickableToastCoordinator) {
        this.f12588a = clickableToastCoordinator;
    }

    public final ClickableToast m13374a(View view, int i) {
        ClickableToast clickableToast = new ClickableToast(this.f12588a, Style.SNACKBAR);
        clickableToast.d = view;
        clickableToast.f = i;
        return clickableToast;
    }

    public static ClickableToastBuilder m13372a(InjectorLike injectorLike) {
        return m13373b(injectorLike);
    }
}
