package com.facebook.adinterfaces.ui;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.inputmethod.InputMethodManager;
import com.facebook.adinterfaces.model.AdInterfacesDataValidation;
import com.facebook.adinterfaces.model.BaseAdInterfacesData;
import com.facebook.adinterfaces.model.boostpost.AdInterfacesBoostPostDataModel;
import com.facebook.adinterfaces.ui.AdInterfacesBoostTypeRadioGroupView.OnCheckChangeListener;
import com.facebook.common.android.InputMethodManagerMethodAutoProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: V2_BYMM_PAGE */
public class AdInterfacesPacingViewController extends BaseAdInterfacesViewController<PacingOptionsView, AdInterfacesBoostPostDataModel> {
    public final InputMethodManager f22835a;
    public AdInterfacesBoostPostDataModel f22836b;
    public PacingOptionsView f22837c;
    public AdInterfacesBidAmountEditView f22838d;
    public AdInterfacesCardLayout f22839e;
    public TextWatcher f22840f;
    public int f22841g;

    /* compiled from: V2_BYMM_PAGE */
    public class C26501 implements OnCheckChangeListener {
        final /* synthetic */ AdInterfacesPacingViewController f22831a;

        public C26501(AdInterfacesPacingViewController adInterfacesPacingViewController) {
            this.f22831a = adInterfacesPacingViewController;
        }

        public final void mo1011a(int i) {
            if (i == 0) {
                AdInterfacesPacingViewController.m24776i(this.f22831a);
                this.f22831a.f22838d.setVisibility(8);
                this.f22831a.f22836b.f21787h = 0;
                this.f22831a.f22839e.setFooterText(null);
            } else {
                int m;
                this.f22831a.f22838d.setVisibility(0);
                AdInterfacesBoostPostDataModel adInterfacesBoostPostDataModel = this.f22831a.f22836b;
                if (this.f22831a.m24781b()) {
                    m = AdInterfacesPacingViewController.m24777m(this.f22831a);
                } else {
                    m = this.f22831a.f22841g;
                }
                adInterfacesBoostPostDataModel.f21787h = m;
                this.f22831a.f22838d.setBidAmount(AdInterfacesPacingViewController.m24775a(this.f22831a, this.f22831a.f22836b.f21787h));
                this.f22831a.f22839e.setFooterText(this.f22831a.f22839e.getResources().getString(2131234117));
            }
            this.f22831a.f22440b.m22431a(AdInterfacesDataValidation.INVALID_BID_AMOUNT, this.f22831a.m24781b());
        }
    }

    /* compiled from: V2_BYMM_PAGE */
    public class C26512 implements OnClickListener {
        final /* synthetic */ AdInterfacesPacingViewController f22832a;

        public C26512(AdInterfacesPacingViewController adInterfacesPacingViewController) {
            this.f22832a = adInterfacesPacingViewController;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 128556672);
            this.f22832a.f22838d.m24458a();
            Logger.a(2, EntryType.UI_INPUT_END, 1584741211, a);
        }
    }

    /* compiled from: V2_BYMM_PAGE */
    public class C26523 implements TextWatcher {
        final /* synthetic */ AdInterfacesPacingViewController f22833a;

        public C26523(AdInterfacesPacingViewController adInterfacesPacingViewController) {
            this.f22833a = adInterfacesPacingViewController;
        }

        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public void afterTextChanged(Editable editable) {
            if (this.f22833a.m24781b()) {
                this.f22833a.f22836b.f21787h = AdInterfacesPacingViewController.m24777m(this.f22833a);
            }
            this.f22833a.f22440b.m22431a(AdInterfacesDataValidation.INVALID_BID_AMOUNT, this.f22833a.m24781b());
        }
    }

    /* compiled from: V2_BYMM_PAGE */
    public class C26534 implements OnFocusChangeListener {
        final /* synthetic */ AdInterfacesPacingViewController f22834a;

        public C26534(AdInterfacesPacingViewController adInterfacesPacingViewController) {
            this.f22834a = adInterfacesPacingViewController;
        }

        public void onFocusChange(View view, boolean z) {
            if (z) {
                AdInterfacesPacingViewController adInterfacesPacingViewController = this.f22834a;
                view.requestFocus();
                adInterfacesPacingViewController.f22835a.toggleSoftInput(2, 1);
                adInterfacesPacingViewController.f22838d.setCursorVisible(true);
                return;
            }
            AdInterfacesPacingViewController.m24776i(this.f22834a);
            int m = AdInterfacesPacingViewController.m24777m(this.f22834a) > 0 ? AdInterfacesPacingViewController.m24777m(this.f22834a) : this.f22834a.f22841g;
            this.f22834a.f22838d.setBidAmount(AdInterfacesPacingViewController.m24775a(this.f22834a, m));
            this.f22834a.f22836b.f21787h = m;
        }
    }

    public static AdInterfacesPacingViewController m24774a(InjectorLike injectorLike) {
        return new AdInterfacesPacingViewController(InputMethodManagerMethodAutoProvider.b(injectorLike));
    }

    public final void mo982a(View view, @Nullable AdInterfacesCardLayout adInterfacesCardLayout) {
        PacingOptionsView pacingOptionsView = (PacingOptionsView) view;
        super.mo982a(pacingOptionsView, adInterfacesCardLayout);
        this.f22837c = pacingOptionsView;
        this.f22839e = adInterfacesCardLayout;
        Preconditions.checkNotNull(this.f22837c);
        this.f22838d = this.f22837c.f23161b;
        this.f22838d.setCurrencySymbol(BudgetHelper.m25107g(this.f22836b).getCurrency().getSymbol());
        this.f22840f = new C26523(this);
        this.f22838d.m24457a(this.f22840f);
        this.f22838d.setOnClickListener(new C26512(this));
        this.f22838d.setOnFocusChangeListenerEditText(new C26534(this));
        this.f22837c.f22607b = new C26501(this);
        this.f22839e.m24585a(this.f22839e.getResources().getString(2131234109), 2130843653);
    }

    public final void mo983a(BaseAdInterfacesData baseAdInterfacesData) {
        boolean z;
        AdInterfacesBoostPostDataModel adInterfacesBoostPostDataModel = (AdInterfacesBoostPostDataModel) baseAdInterfacesData;
        this.f22836b = adInterfacesBoostPostDataModel;
        if (adInterfacesBoostPostDataModel.f21780a.m23712k().m23701a().m23693a() > 0) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkArgument(z);
        this.f22841g = adInterfacesBoostPostDataModel.f21780a.m23712k().m23701a().m23693a();
    }

    @Inject
    public AdInterfacesPacingViewController(InputMethodManager inputMethodManager) {
        this.f22835a = inputMethodManager;
    }

    public final void mo981a() {
        super.mo981a();
        this.f22837c.f22607b = null;
        this.f22838d.m24459b(this.f22840f);
        this.f22838d.setOnClickListener(null);
        this.f22838d.setOnFocusChangeListenerEditText(null);
        this.f22838d = null;
        this.f22837c = null;
        this.f22839e = null;
    }

    public static void m24776i(AdInterfacesPacingViewController adInterfacesPacingViewController) {
        adInterfacesPacingViewController.f22835a.hideSoftInputFromWindow(adInterfacesPacingViewController.f22838d.getWindowToken(), 0);
        adInterfacesPacingViewController.f22838d.setCursorVisible(false);
    }

    @VisibleForTesting
    public final boolean m24781b() {
        if (this.f22837c.f22608c != 0 && m24777m(this) <= 0) {
            return false;
        }
        return true;
    }

    public static int m24777m(AdInterfacesPacingViewController adInterfacesPacingViewController) {
        try {
            return (int) (Double.parseDouble(adInterfacesPacingViewController.f22838d.getBidAmountText()) * ((double) BudgetHelper.m25108h(adInterfacesPacingViewController.f22836b)));
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    public static String m24775a(AdInterfacesPacingViewController adInterfacesPacingViewController, int i) {
        int h = BudgetHelper.m25108h(adInterfacesPacingViewController.f22836b);
        long j = (long) i;
        NumberFormat g = BudgetHelper.m25107g(adInterfacesPacingViewController.f22836b);
        DecimalFormatSymbols decimalFormatSymbols = ((DecimalFormat) g).getDecimalFormatSymbols();
        decimalFormatSymbols.setCurrencySymbol("");
        ((DecimalFormat) g).setDecimalFormatSymbols(decimalFormatSymbols);
        return BudgetHelper.m25097a(h, j, g);
    }
}
