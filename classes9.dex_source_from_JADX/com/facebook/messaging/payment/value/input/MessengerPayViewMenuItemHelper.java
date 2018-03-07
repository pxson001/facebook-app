package com.facebook.messaging.payment.value.input;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.MenuItemCompat;
import android.view.MenuItem;
import com.facebook.common.util.actionbar.ActionBarContextUtils;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.payment.currency.PaymentCurrencyUtil;
import com.facebook.messaging.payment.model.PaymentCard;
import com.google.common.base.Optional;
import java.math.BigDecimal;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: events_db */
public class MessengerPayViewMenuItemHelper {
    public final Context f15475a;
    public final PaymentCurrencyUtil f15476b;

    public static MessengerPayViewMenuItemHelper m15777b(InjectorLike injectorLike) {
        return new MessengerPayViewMenuItemHelper((Context) injectorLike.getInstance(Context.class), PaymentCurrencyUtil.m13192a(injectorLike));
    }

    @Inject
    public MessengerPayViewMenuItemHelper(Context context, PaymentCurrencyUtil paymentCurrencyUtil) {
        this.f15475a = context;
        this.f15476b = paymentCurrencyUtil;
    }

    public final void m15779a(@Nullable MenuItem menuItem, @Nullable Optional<PaymentCard> optional, MessengerPayAmount messengerPayAmount, MessengerPayState messengerPayState, boolean z) {
        if (menuItem != null) {
            if (z || optional != null) {
                boolean z2 = (z || optional.isPresent()) ? false : true;
                menuItem.setEnabled(this.f15476b.m13201a(messengerPayAmount.f15442a, messengerPayAmount.f15443b).compareTo(BigDecimal.ZERO) > 0);
                switch (messengerPayState) {
                    case PREPARE_PAYMENT:
                        m15776a(menuItem, z2);
                        return;
                    case CHECK_RECIPIENT_ELIGIBILITY:
                    case PROCESSING_CHECK_RECIPIENT_ELIGIBILITY:
                    case CARD_VERIFY:
                        m15778c(menuItem);
                        return;
                    case PROCESSING_CARD_VERIFY:
                    case CHECK_AMOUNT:
                    case PROCESSING_CHECK_AMOUNT:
                    case CHECK_PIN:
                    case PROCESSING_CHECK_PIN:
                        m15776a(menuItem, z2);
                        return;
                    case SEND_PAYMENT:
                    case PROCESSING_SEND_PAYMENT:
                        m15778c(menuItem);
                        return;
                    default:
                        throw new IllegalStateException("Invalid state found + " + messengerPayState);
                }
            }
            menuItem.setTitle(null);
            menuItem.setIcon(null);
            MenuItemCompat.a(menuItem, null);
        }
    }

    private void m15776a(MenuItem menuItem, boolean z) {
        if (z) {
            menuItem.setTitle(2131240386);
            menuItem.setIcon(null);
            MenuItemCompat.a(menuItem, null);
            return;
        }
        menuItem.setTitle(2131240385);
        menuItem.setIcon(ActionBarContextUtils.m6473a(this.f15475a, 2131625159, 2130841433, ContextCompat.b(this.f15475a, 2131362288)));
        MenuItemCompat.a(menuItem, null);
    }

    private static void m15778c(MenuItem menuItem) {
        menuItem.setTitle(null);
        menuItem.setIcon(null);
        MenuItemCompat.b(menuItem, 2130903072);
    }
}
