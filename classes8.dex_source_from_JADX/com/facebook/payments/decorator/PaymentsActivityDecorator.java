package com.facebook.payments.decorator;

import android.app.Activity;
import android.graphics.drawable.ColorDrawable;
import android.support.v4.content.ContextCompat;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.RelativeLayout;
import com.facebook.common.ui.util.StatusBarUtil;
import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.inject.InjectorLike;
import com.facebook.katana.app.module.MainProcessModule;
import javax.inject.Inject;

/* compiled from: target_query_function */
public class PaymentsActivityDecorator {
    public final GatekeeperStoreImpl f1754a;
    private final Integer f1755b;

    public static PaymentsActivityDecorator m1938b(InjectorLike injectorLike) {
        return new PaymentsActivityDecorator(GatekeeperStoreImplMethodAutoProvider.a(injectorLike), MainProcessModule.g());
    }

    @Inject
    public PaymentsActivityDecorator(GatekeeperStoreImpl gatekeeperStoreImpl, Integer num) {
        this.f1754a = gatekeeperStoreImpl;
        this.f1755b = num;
    }

    public final void m1940a(Activity activity, PaymentsActivitySource paymentsActivitySource) {
        activity.getTheme().applyStyle(this.f1755b.intValue(), false);
        if (this.f1754a.a(403, false) && paymentsActivitySource == PaymentsActivitySource.CHECKOUT) {
            Window window = activity.getWindow();
            window.setBackgroundDrawable(new ColorDrawable(0));
            window.setFlags(2, 2);
            LayoutParams attributes = window.getAttributes();
            attributes.dimAmount = 0.6f;
            window.setAttributes(attributes);
            StatusBarUtil.a(activity.getWindow(), ContextCompat.b(activity, 17170445));
        }
    }

    public final void m1941b(Activity activity, PaymentsActivitySource paymentsActivitySource) {
        if (this.f1754a.a(403, false) && paymentsActivitySource == PaymentsActivitySource.CHECKOUT) {
            ViewGroup viewGroup = (ViewGroup) activity.findViewById(2131558429);
            ViewGroup.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            viewGroup.setLayoutParams(layoutParams);
        }
    }

    public static void m1937a(Activity activity, PaymentsDecoratorParams paymentsDecoratorParams) {
        switch (paymentsDecoratorParams.f1758a) {
            case MODAL_BOTTOM:
                activity.overridePendingTransition(2130968618, 2130968737);
                return;
            case SLIDE_RIGHT:
                activity.overridePendingTransition(2130968619, 2130968737);
                return;
            default:
                throw new UnsupportedOperationException("Illegal animation seen: " + paymentsDecoratorParams.f1758a);
        }
    }

    public static void m1939b(Activity activity, PaymentsDecoratorParams paymentsDecoratorParams) {
        switch (paymentsDecoratorParams.f1758a) {
            case MODAL_BOTTOM:
                activity.overridePendingTransition(2130968736, 2130968620);
                return;
            case SLIDE_RIGHT:
                activity.overridePendingTransition(2130968736, 2130968621);
                return;
            default:
                throw new UnsupportedOperationException("Illegal animation seen: " + paymentsDecoratorParams.f1758a);
        }
    }
}
