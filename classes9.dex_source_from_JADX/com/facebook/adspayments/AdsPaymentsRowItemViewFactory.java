package com.facebook.adspayments;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.facebook.adspayments.adinterfaces.abtest.AdsPaymentsExperimentsHelper;
import com.facebook.adspayments.model.AdsAddCardRowItem;
import com.facebook.adspayments.protocol.PostBusinessAddressMethod;
import com.facebook.adspayments.protocol.PostBusinessAddressParams;
import com.facebook.common.locale.Country;
import com.facebook.payments.paymentmethods.model.FbPaymentCardType;
import com.facebook.payments.paymentmethods.picker.PaymentMethodsRowItemViewFactory;
import com.facebook.payments.paymentmethods.picker.model.AddCardRowItem;
import com.facebook.payments.paymentmethods.picker.model.AddPayPalRowItem;
import com.facebook.payments.paymentmethods.picker.model.CountrySelectorRowItem;
import com.facebook.payments.picker.SimpleRowItemViewFactory;
import com.facebook.payments.ui.SimplePaymentsComponentCallback;
import com.google.common.collect.ImmutableSet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;

/* compiled from: Unable to resolve reach string for objective  */
public final class AdsPaymentsRowItemViewFactory extends PaymentMethodsRowItemViewFactory {
    private final AdsPaymentsExperimentsHelper f23524a;
    private final PostBusinessAddressMethod f23525b;

    /* compiled from: Unable to resolve reach string for objective  */
    public /* synthetic */ class C28121 {
        public static final /* synthetic */ int[] f23523a = new int[FbPaymentCardType.values().length];

        static {
            try {
                f23523a[FbPaymentCardType.AMEX.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f23523a[FbPaymentCardType.DISCOVER.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f23523a[FbPaymentCardType.JCB.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f23523a[FbPaymentCardType.MASTER_CARD.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                f23523a[FbPaymentCardType.VISA.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
        }
    }

    @Inject
    public AdsPaymentsRowItemViewFactory(SimpleRowItemViewFactory simpleRowItemViewFactory, AdsPaymentsExperimentsHelper adsPaymentsExperimentsHelper, PostBusinessAddressMethod postBusinessAddressMethod) {
        super(simpleRowItemViewFactory);
        this.f23524a = adsPaymentsExperimentsHelper;
        this.f23525b = postBusinessAddressMethod;
    }

    protected final void mo1082a(CountrySelectorRowItem countrySelectorRowItem, Country country, SimplePaymentsComponentCallback simplePaymentsComponentCallback, Context context) {
        if (this.f23524a.m25614a(country)) {
            simplePaymentsComponentCallback.a(BrazilianTaxIdActivity.m25518a(context, countrySelectorRowItem.f18840c.m18791b()), 301);
            return;
        }
        this.f23525b.c(new PostBusinessAddressParams(countrySelectorRowItem.f18840c.f18789f, country));
        super.mo1082a(countrySelectorRowItem, country, simplePaymentsComponentCallback, context);
    }

    protected final View mo1080a(SimplePaymentsComponentCallback simplePaymentsComponentCallback, AddCardRowItem addCardRowItem, View view, ViewGroup viewGroup) {
        View a = super.mo1080a(simplePaymentsComponentCallback, addCardRowItem, view, viewGroup);
        ((TextView) a.findViewById(2131559357)).setCompoundDrawablesWithIntrinsicBounds(null, null, m25472a(((AdsAddCardRowItem) addCardRowItem).f23679c, a.getContext()), null);
        return a;
    }

    protected final View mo1081a(SimplePaymentsComponentCallback simplePaymentsComponentCallback, AddPayPalRowItem addPayPalRowItem, View view, ViewGroup viewGroup) {
        View a = super.mo1081a(simplePaymentsComponentCallback, addPayPalRowItem, view, viewGroup);
        ((TextView) a.findViewById(2131559366)).setCompoundDrawablesWithIntrinsicBounds(0, 0, 2130842546, 0);
        return a;
    }

    private static LayerDrawable m25472a(ImmutableSet<FbPaymentCardType> immutableSet, Context context) {
        List arrayList = new ArrayList();
        Iterator it = immutableSet.iterator();
        while (it.hasNext()) {
            Drawable a;
            switch (C28121.f23523a[((FbPaymentCardType) it.next()).ordinal()]) {
                case 1:
                    a = ContextCompat.a(context, 2130842538);
                    break;
                case 2:
                    a = ContextCompat.a(context, 2130842541);
                    break;
                case 3:
                    a = ContextCompat.a(context, 2130842543);
                    break;
                case 4:
                    a = ContextCompat.a(context, 2130842544);
                    break;
                case 5:
                    a = ContextCompat.a(context, 2130842558);
                    break;
                default:
                    a = null;
                    break;
            }
            Drawable drawable = a;
            if (drawable != null) {
                arrayList.add(drawable);
            }
        }
        LayerDrawable layerDrawable = new LayerDrawable((Drawable[]) arrayList.toArray(new Drawable[arrayList.size()]));
        int dimension = (int) context.getResources().getDimension(2131433362);
        int i = 0;
        for (int i2 = 0; i2 < layerDrawable.getNumberOfLayers(); i2++) {
            layerDrawable.setLayerInset(i2, -i, 0, i, 0);
            i += layerDrawable.getDrawable(i2).getIntrinsicWidth() + dimension;
        }
        return layerDrawable;
    }
}
