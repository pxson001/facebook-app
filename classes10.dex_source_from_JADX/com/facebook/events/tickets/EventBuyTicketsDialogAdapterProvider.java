package com.facebook.events.tickets;

import android.content.Context;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.events.logging.BuyTicketsLoggingInfo;
import com.facebook.fbui.glyph.GlyphColorizer;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.payments.paymentsflow.ui.PayViewController;
import com.facebook.ui.dialogs.FbDialogFragment;
import com.facebook.ui.toaster.Toaster;

/* compiled from: attempt_number */
public class EventBuyTicketsDialogAdapterProvider extends AbstractAssistedProvider<EventBuyTicketsDialogAdapter> {
    public final EventBuyTicketsDialogAdapter m19322a(Context context, EventsBuyTicketsDialogArgument eventsBuyTicketsDialogArgument, BuyTicketsLoggingInfo buyTicketsLoggingInfo, int i, FbDialogFragment fbDialogFragment) {
        return new EventBuyTicketsDialogAdapter(BuyTicketPayViewController.m19301a(this), GlyphColorizer.a(this), PayViewController.b(this), (SecureContextHelper) DefaultSecureContextHelper.a(this), Toaster.b(this), context, eventsBuyTicketsDialogArgument, buyTicketsLoggingInfo, i, fbDialogFragment);
    }
}
