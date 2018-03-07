package com.facebook.adinterfaces.ui;

import android.app.DatePickerDialog;
import android.app.DatePickerDialog.OnDateSetListener;
import android.os.Bundle;
import android.text.Html;
import android.text.Spanned;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.DatePicker;
import com.facebook.adinterfaces.AdInterfacesContext;
import com.facebook.adinterfaces.abtest.ExperimentsForAdInterfacesModule;
import com.facebook.adinterfaces.events.AdInterfacesEventBus;
import com.facebook.adinterfaces.events.AdInterfacesEvents.DurationChangeEvent;
import com.facebook.adinterfaces.events.AdInterfacesEvents.ScheduleValidationEvent;
import com.facebook.adinterfaces.events.AdInterfacesEvents.ScheduleValidationEventSubscriber;
import com.facebook.adinterfaces.events.AdInterfacesEvents.SelectedBudgetChangeEventSubscriber;
import com.facebook.adinterfaces.model.AdInterfacesDataHelper;
import com.facebook.adinterfaces.model.AdInterfacesDataHelper.ScheduleOption;
import com.facebook.adinterfaces.model.AdInterfacesDataValidation;
import com.facebook.adinterfaces.model.BaseAdInterfacesData;
import com.facebook.adinterfaces.model.boostpost.AdInterfacesBoostedComponentDataModel;
import com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.CurrencyQuantityModel;
import com.facebook.adinterfaces.ui.EditableRadioGroup.OnCheckedChangeRadioGroupListener;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.content.event.FbEvent;
import com.facebook.content.event.FbEventSubscriberListManager;
import com.facebook.graphql.enums.GraphQLBoostedComponentBudgetType;
import com.facebook.inject.InjectorLike;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import java.util.Calendar;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: Uri may not be null. */
public class AdInterfacesScheduleViewController extends BaseAdInterfacesViewController<AdInterfacesScheduleView, AdInterfacesBoostedComponentDataModel> {
    public AdInterfacesScheduleView f22935a;
    public AdInterfacesBoostedComponentDataModel f22936b;
    private Integer f22937c;
    private FbEventSubscriberListManager f22938d;
    public Integer f22939e;
    public AdInterfacesCardLayout f22940f;
    private AdInterfacesEventBus f22941g;
    private String f22942h;
    private String f22943i;
    public AdInterfacesDataHelper f22944j;
    private QeAccessor f22945k;

    /* compiled from: Uri may not be null. */
    class C26691 implements OnCheckedChangeRadioGroupListener {
        final /* synthetic */ AdInterfacesScheduleViewController f22928a;

        C26691(AdInterfacesScheduleViewController adInterfacesScheduleViewController) {
            this.f22928a = adInterfacesScheduleViewController;
        }

        public final void mo1006a(EditableRadioGroup editableRadioGroup, int i) {
            int selectedIndex = this.f22928a.f22935a.getSelectedIndex();
            if (selectedIndex >= 0 && selectedIndex < ScheduleOption.values().length) {
                ScheduleOption scheduleOption = ScheduleOption.values()[selectedIndex];
                switch (scheduleOption) {
                    case SPECIFIC_DATE:
                        this.f22928a.m24898a(this.f22928a.f22944j.m22820a(this.f22928a.f22935a.f22924c.longValue()), selectedIndex);
                        break;
                    default:
                        this.f22928a.m24898a(scheduleOption.getDuration(), selectedIndex);
                        break;
                }
                this.f22928a.m24903c();
            }
        }
    }

    /* compiled from: Uri may not be null. */
    class C26712 implements OnClickListener {
        final /* synthetic */ AdInterfacesScheduleViewController f22931a;

        C26712(AdInterfacesScheduleViewController adInterfacesScheduleViewController) {
            this.f22931a = adInterfacesScheduleViewController;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -363212943);
            Calendar instance = Calendar.getInstance();
            final long timeInMillis = instance.getTimeInMillis();
            instance.add(5, 10);
            if (this.f22931a.f22935a.f22924c != null) {
                instance.setTimeInMillis(this.f22931a.f22935a.f22924c.longValue());
            }
            DatePickerDialog datePickerDialog = new DatePickerDialog(view.getContext(), new OnDateSetListener(this) {
                final /* synthetic */ C26712 f22930b;

                public void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
                    Calendar instance = Calendar.getInstance();
                    instance.setTimeInMillis(timeInMillis);
                    instance.set(i, i2, i3);
                    if (datePicker.getMinDate() > instance.getTimeInMillis() || datePicker.getMaxDate() < instance.getTimeInMillis()) {
                        this.f22930b.onClick(datePicker);
                        return;
                    }
                    this.f22930b.f22931a.f22935a.setDate(Long.valueOf(instance.getTimeInMillis()));
                    this.f22930b.f22931a.f22939e = Integer.valueOf(this.f22930b.f22931a.f22944j.m22820a(this.f22930b.f22931a.f22935a.f22924c.longValue()));
                    this.f22930b.f22931a.f22936b.f21753i = this.f22930b.f22931a.f22939e.intValue();
                    this.f22930b.f22931a.f22440b.m22429a(new DurationChangeEvent(this.f22930b.f22931a.f22939e.intValue()));
                    this.f22930b.f22931a.f22935a.m24889a();
                    this.f22930b.f22931a.m24909f();
                    this.f22930b.f22931a.m24903c();
                }
            }, instance.get(1), instance.get(2), instance.get(5));
            DatePicker datePicker = datePickerDialog.getDatePicker();
            datePicker.setCalendarViewShown(false);
            Calendar instance2 = Calendar.getInstance();
            instance2.add(5, 1);
            datePicker.setMinDate(instance2.getTimeInMillis() - 60000);
            datePicker.setMaxDate((instance2.getTimeInMillis() + 31536000000L) - 86400000);
            datePickerDialog.show();
            Logger.a(2, EntryType.UI_INPUT_END, -482852226, a);
        }
    }

    /* compiled from: Uri may not be null. */
    class C26723 extends SelectedBudgetChangeEventSubscriber {
        final /* synthetic */ AdInterfacesScheduleViewController f22932a;

        C26723(AdInterfacesScheduleViewController adInterfacesScheduleViewController) {
            this.f22932a = adInterfacesScheduleViewController;
        }

        public final void m24893b(FbEvent fbEvent) {
            this.f22932a.m24909f();
        }
    }

    /* compiled from: Uri may not be null. */
    class C26734 extends ScheduleValidationEventSubscriber {
        final /* synthetic */ AdInterfacesScheduleViewController f22933a;

        C26734(AdInterfacesScheduleViewController adInterfacesScheduleViewController) {
            this.f22933a = adInterfacesScheduleViewController;
        }

        public final void m24894b(FbEvent fbEvent) {
            this.f22933a.f22940f.m24584a(((ScheduleValidationEvent) fbEvent).f21655a);
        }
    }

    public static AdInterfacesScheduleViewController m24901b(InjectorLike injectorLike) {
        return new AdInterfacesScheduleViewController(AdInterfacesEventBus.m22728a(injectorLike), AdInterfacesDataHelper.m22789a(injectorLike), (QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike));
    }

    public final void mo982a(View view, @Nullable AdInterfacesCardLayout adInterfacesCardLayout) {
        AdInterfacesScheduleView adInterfacesScheduleView = (AdInterfacesScheduleView) view;
        super.mo982a(adInterfacesScheduleView, adInterfacesCardLayout);
        this.f22935a = adInterfacesScheduleView;
        this.f22940f = adInterfacesCardLayout;
        this.f22942h = adInterfacesScheduleView.getResources().getString(2131233901);
        this.f22939e = Integer.valueOf(this.f22936b.f21753i);
        if (this.f22939e.intValue() == 0) {
            int ordinal;
            AdInterfacesScheduleView adInterfacesScheduleView2 = this.f22935a;
            if (this.f22945k.a(ExperimentsForAdInterfacesModule.f21613j, false)) {
                ordinal = ScheduleOption.TWENTY_EIGHT_DAYS.ordinal();
            } else {
                ordinal = ScheduleOption.CONTINUOUS.ordinal();
            }
            adInterfacesScheduleView2.m24891c(ordinal);
        } else {
            this.f22935a.m24891c(ScheduleOption.SPECIFIC_DATE.ordinal());
            Calendar instance = Calendar.getInstance();
            instance.add(5, this.f22939e.intValue());
            this.f22935a.setDate(Long.valueOf(instance.getTimeInMillis()));
        }
        this.f22943i = adInterfacesScheduleView.getResources().getString(2131233903);
        this.f22935a.setOnCheckChangedListener(new C26691(this));
        this.f22935a.setDateOnClickListener(new C26712(this));
        if (AdInterfacesDataHelper.m22814j(this.f22936b)) {
            m24903c();
        }
        this.f22938d = new FbEventSubscriberListManager();
        m24906d();
        m24902b();
    }

    public final void mo983a(BaseAdInterfacesData baseAdInterfacesData) {
        this.f22936b = (AdInterfacesBoostedComponentDataModel) baseAdInterfacesData;
    }

    public static AdInterfacesScheduleViewController m24896a(InjectorLike injectorLike) {
        return m24901b(injectorLike);
    }

    @Inject
    public AdInterfacesScheduleViewController(AdInterfacesEventBus adInterfacesEventBus, AdInterfacesDataHelper adInterfacesDataHelper, QeAccessor qeAccessor) {
        this.f22941g = adInterfacesEventBus;
        this.f22944j = adInterfacesDataHelper;
        this.f22945k = qeAccessor;
    }

    private void m24902b() {
        if (this.f22936b.f21797b.m23346m() == GraphQLBoostedComponentBudgetType.LIFETIME_BUDGET) {
            this.f22935a.m24890b();
            this.f22935a.m24891c(ScheduleOption.SPECIFIC_DATE.ordinal());
        }
    }

    private void m24903c() {
        if (AdInterfacesDataHelper.m22814j(this.f22936b)) {
            this.f22440b.m22431a(AdInterfacesDataValidation.UNEDITED_DATA, this.f22944j.m22825b(this.f22936b));
        }
        if (this.f22936b.f21797b.m23346m() == GraphQLBoostedComponentBudgetType.LIFETIME_BUDGET) {
            boolean z;
            Spanned fromHtml = BudgetHelper.m25098a(this.f22936b.f21750f).compareTo(BudgetHelper.m25106f(this.f22936b)) < 0 ? Html.fromHtml(this.f22935a.getResources().getString(2131234107)) : null;
            AdInterfacesContext adInterfacesContext = this.f22440b;
            AdInterfacesDataValidation adInterfacesDataValidation = AdInterfacesDataValidation.INVALID_BUDGET;
            if (fromHtml == null) {
                z = true;
            } else {
                z = false;
            }
            adInterfacesContext.m22431a(adInterfacesDataValidation, z);
            this.f22940f.setFooterSpannableText(fromHtml);
        }
    }

    public final void mo981a() {
        super.mo981a();
        m24908e();
        this.f22935a = null;
    }

    public final void mo985b(@Nullable Bundle bundle) {
        super.mo985b(bundle);
        if (bundle != null) {
            Long l = (Long) bundle.getSerializable("adinterfaces_schedule_date");
            if (l != null) {
                this.f22935a.setDate(l);
            }
            Integer num = (Integer) bundle.getSerializable("adinterfaces_schedule");
            if (num != null) {
                this.f22935a.m24891c(num.intValue());
            }
        }
    }

    public final void mo984a(Bundle bundle) {
        super.mo984a(bundle);
        bundle.putSerializable("adinterfaces_schedule", this.f22937c);
        bundle.putSerializable("adinterfaces_schedule_date", this.f22935a.f22924c);
    }

    private void m24906d() {
        this.f22938d.a(new C26723(this));
        this.f22938d.a(this.f22941g);
        this.f22440b.m22430a(new C26734(this));
    }

    private void m24908e() {
        this.f22938d.b(this.f22941g);
    }

    private void m24909f() {
        CurrencyQuantityModel currencyQuantityModel = this.f22936b.f21750f;
        if (currencyQuantityModel == null) {
            this.f22940f.setFooterSpannableText(null);
            return;
        }
        long longValue = BudgetHelper.m25098a(currencyQuantityModel).longValue();
        if (BudgetHelper.m25102b(this.f22936b)) {
            int i;
            if (this.f22936b.f21753i == 0) {
                i = 1;
            } else {
                i = this.f22936b.f21753i;
            }
            longValue /= (long) i;
        }
        if (this.f22939e.intValue() == ScheduleOption.CONTINUOUS.getDuration()) {
            this.f22940f.setFooterSpannableText(Html.fromHtml(StringFormatUtil.formatStrLocaleSafe(this.f22943i, BudgetHelper.m25097a(currencyQuantityModel.m23421j(), longValue, BudgetHelper.m25107g(this.f22936b)))));
        } else if (this.f22939e.intValue() == 1) {
            this.f22940f.setFooterSpannableText(Html.fromHtml(StringFormatUtil.formatStrLocaleSafe(this.f22935a.getResources().getString(2131233902), BudgetHelper.m25097a(currencyQuantityModel.m23421j(), longValue, BudgetHelper.m25107g(this.f22936b)))));
        } else {
            this.f22940f.setFooterSpannableText(Html.fromHtml(StringFormatUtil.formatStrLocaleSafe(this.f22942h, String.valueOf(this.f22939e), BudgetHelper.m25097a(currencyQuantityModel.m23421j(), longValue, BudgetHelper.m25107g(this.f22936b)))));
        }
    }

    private void m24898a(int i, int i2) {
        this.f22939e = Integer.valueOf(i);
        this.f22936b.f21753i = this.f22939e.intValue();
        this.f22440b.m22429a(new DurationChangeEvent(this.f22939e.intValue()));
        this.f22937c = Integer.valueOf(i2);
        m24909f();
    }
}
