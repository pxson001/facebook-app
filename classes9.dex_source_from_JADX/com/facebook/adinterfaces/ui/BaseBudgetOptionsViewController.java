package com.facebook.adinterfaces.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.Editable;
import android.text.Spanned;
import android.text.TextWatcher;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import com.facebook.adinterfaces.error.AdInterfacesErrorReporter;
import com.facebook.adinterfaces.events.AdInterfacesEvents.BudgetValidationEvent;
import com.facebook.adinterfaces.events.AdInterfacesEvents.BudgetValidationEventSubscriber;
import com.facebook.adinterfaces.events.AdInterfacesEvents.DurationChangeEventSubscriber;
import com.facebook.adinterfaces.events.AdInterfacesEvents.ErrorDialogEvent;
import com.facebook.adinterfaces.events.AdInterfacesEvents.InvalidateAccountEvent;
import com.facebook.adinterfaces.events.AdInterfacesEvents.SelectedAdAccountChangeEvent;
import com.facebook.adinterfaces.events.AdInterfacesEvents.SelectedAdAccountChangeEventSubscriber;
import com.facebook.adinterfaces.events.AdInterfacesEvents.SelectedBudgetChangeEvent;
import com.facebook.adinterfaces.events.AdInterfacesEvents.TargetingChangedSubscriber;
import com.facebook.adinterfaces.logging.BoostedComponentLogger;
import com.facebook.adinterfaces.model.AdInterfacesDataHelper;
import com.facebook.adinterfaces.model.AdInterfacesDataModel;
import com.facebook.adinterfaces.model.AdInterfacesDataValidation;
import com.facebook.adinterfaces.model.AdInterfacesStatus;
import com.facebook.adinterfaces.model.BaseAdInterfacesData;
import com.facebook.adinterfaces.model.boostpost.AdInterfacesBoostedComponentDataModel;
import com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.AdAccountModel;
import com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.BudgetRecommendationDataModel;
import com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.BudgetRecommendationModel;
import com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.BudgetRecommendationModel.EdgesModel;
import com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.CurrencyQuantityModel;
import com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.IntervalModel;
import com.facebook.adinterfaces.protocol.FetchBudgetRecommendationsMethod;
import com.facebook.adinterfaces.protocol.FetchBudgetRecommendationsMethod.Key;
import com.facebook.adinterfaces.protocol.SetAdAccountCurrenyTimeZoneMutation.FBPageSetAdAccountCurrenyTimeZoneString;
import com.facebook.adinterfaces.protocol.SetAdAccountCurrenyTimeZoneMutationModels.FBPageSetAdAccountCurrenyTimeZoneModel;
import com.facebook.adinterfaces.ui.AdInterfacesSpinnerAdapter.SpinnerAdapterItem;
import com.facebook.adinterfaces.ui.BaseEditableRadioGroupViewController.EditableRadioButtonState;
import com.facebook.adinterfaces.ui.BudgetHelper.BudgetTipType;
import com.facebook.adinterfaces.ui.EditableRadioGroup.OnCheckedChangeRadioGroupListener;
import com.facebook.adinterfaces.util.AdInterfacesUiUtil;
import com.facebook.common.executors.DefaultAndroidThreadUtil;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.util.StringUtil;
import com.facebook.content.event.FbEvent;
import com.facebook.fbui.dialog.AlertDialog.Builder;
import com.facebook.flatbuffers.helpers.FlatBufferModelHelper;
import com.facebook.graphql.calls.AdAccountSetCurrencyTimezoneInputData;
import com.facebook.graphql.calls.BoostedComponentAppInputBoostedComponentApp;
import com.facebook.graphql.calls.GraphQlCallInput;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.payments.currency.CurrencyConfig;
import com.facebook.quicklog.QuickPerformanceLogger;
import com.facebook.ui.futures.TasksManager;
import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.google.common.util.concurrent.FutureCallback;
import java.math.BigDecimal;
import javax.annotation.Nullable;

/* compiled from: Untrusted identity made a connection request */
public abstract class BaseBudgetOptionsViewController<D extends AdInterfacesDataModel> extends BaseEditableRadioGroupViewController<BudgetOptionsView, D> {
    private BudgetHelper f23043d;
    private TasksManager f23044e;
    private FetchBudgetRecommendationsMethod f23045f;
    public final BoostedComponentLogger f23046g;
    public QuickPerformanceLogger f23047h;
    private AdInterfacesSpinnerAdapterProvider f23048i;
    private GraphQLQueryExecutor f23049j;
    private AdInterfacesSpinnerAdapter f23050k;
    public final AdInterfacesErrorReporter f23051l;
    private final DefaultAndroidThreadUtil f23052m;
    public BaseAdInterfacesData f23053n;
    public BudgetOptionsView f23054o;
    public AdInterfacesCardLayout f23055p;
    private Resources f23056q;

    /* compiled from: Untrusted identity made a connection request */
    public class C26941 extends DurationChangeEventSubscriber {
        final /* synthetic */ BaseBudgetOptionsViewController f23027a;

        public C26941(BaseBudgetOptionsViewController baseBudgetOptionsViewController) {
            this.f23027a = baseBudgetOptionsViewController;
        }

        public final void m24993b(FbEvent fbEvent) {
            this.f23027a.m25044m();
            this.f23027a.m25043j();
            this.f23027a.m25013r();
            this.f23027a.f22440b.m22429a(new SelectedBudgetChangeEvent(this.f23027a.f23053n.f21750f));
            this.f23027a.f22440b.m22431a(AdInterfacesDataValidation.INVALID_BUDGET, this.f23027a.m25042i());
        }
    }

    /* compiled from: Untrusted identity made a connection request */
    public class C26952 extends SelectedAdAccountChangeEventSubscriber {
        final /* synthetic */ BaseBudgetOptionsViewController f23028a;

        public C26952(BaseBudgetOptionsViewController baseBudgetOptionsViewController) {
            this.f23028a = baseBudgetOptionsViewController;
        }

        public final void m24994b(FbEvent fbEvent) {
            SelectedAdAccountChangeEvent selectedAdAccountChangeEvent = (SelectedAdAccountChangeEvent) fbEvent;
            BaseBudgetOptionsViewController.m25023y(this.f23028a);
            if (!StringUtil.a(AdInterfacesDataHelper.m22792a(this.f23028a.f23053n, selectedAdAccountChangeEvent.f21674a).m23139m().m23419a(), AdInterfacesDataHelper.m22792a(this.f23028a.f23053n, selectedAdAccountChangeEvent.f21675b).m23139m().m23419a())) {
                this.f23028a.f23054o.m25049c();
            }
            BaseBudgetOptionsViewController.m25024z(this.f23028a);
            this.f23028a.m25044m();
        }
    }

    /* compiled from: Untrusted identity made a connection request */
    public class C26963 extends TargetingChangedSubscriber {
        final /* synthetic */ BaseBudgetOptionsViewController f23029a;

        public C26963(BaseBudgetOptionsViewController baseBudgetOptionsViewController) {
            this.f23029a = baseBudgetOptionsViewController;
        }

        public final void m24995b(FbEvent fbEvent) {
            this.f23029a.m25044m();
            String textEditText = this.f23029a.f23040a.getTextEditText();
            if (this.f23029a.m25003a(textEditText) == EditableRadioButtonState.VALID) {
                BaseBudgetOptionsViewController.m25019c(this.f23029a, BudgetHelper.m25095a(new BigDecimal(textEditText).multiply(new BigDecimal(AdInterfacesDataHelper.m22808f(this.f23029a.f23053n))), this.f23029a.f23053n));
            }
        }
    }

    /* compiled from: Untrusted identity made a connection request */
    public class C26974 extends BudgetValidationEventSubscriber {
        final /* synthetic */ BaseBudgetOptionsViewController f23030a;

        public C26974(BaseBudgetOptionsViewController baseBudgetOptionsViewController) {
            this.f23030a = baseBudgetOptionsViewController;
        }

        public final void m24996b(FbEvent fbEvent) {
            this.f23030a.f23055p.m24584a(((BudgetValidationEvent) fbEvent).f21655a);
        }
    }

    /* compiled from: Untrusted identity made a connection request */
    class C26985 implements OnCheckedChangeRadioGroupListener {
        final /* synthetic */ BaseBudgetOptionsViewController f23031a;

        C26985(BaseBudgetOptionsViewController baseBudgetOptionsViewController) {
            this.f23031a = baseBudgetOptionsViewController;
        }

        public final void mo1006a(EditableRadioGroup editableRadioGroup, int i) {
            this.f23031a.f23053n.m22848b(BaseBudgetOptionsViewController.m25022x(this.f23031a), this.f23031a.f23053n.f21752h);
            this.f23031a.f22440b.m22429a(new SelectedBudgetChangeEvent(this.f23031a.f23053n.f21750f));
            this.f23031a.f22440b.m22431a(AdInterfacesDataValidation.INVALID_BUDGET, this.f23031a.m25042i());
            BaseBudgetOptionsViewController.m25020u(this.f23031a);
            this.f23031a.m25043j();
            this.f23031a.m25013r();
            if (i != this.f23031a.f23040a.getId()) {
                this.f23031a.m25012q();
                this.f23031a.f23046g.m22786p(this.f23031a.f23053n);
            }
        }
    }

    /* compiled from: Untrusted identity made a connection request */
    class C26996 extends AbstractDisposableFutureCallback<BudgetRecommendationModel> {
        final /* synthetic */ BaseBudgetOptionsViewController f23032a;

        C26996(BaseBudgetOptionsViewController baseBudgetOptionsViewController) {
            this.f23032a = baseBudgetOptionsViewController;
        }

        protected final void m24998a(Object obj) {
            BudgetRecommendationModel budgetRecommendationModel = (BudgetRecommendationModel) obj;
            if (this.f23032a.f22439a) {
                this.f23032a.f23047h.b(5898248, Key.FETCH_BUDGET_RECOMMENDATION.hashCode(), (short) 2);
                BaseBudgetOptionsViewController.m25017a(this.f23032a, false);
                if (budgetRecommendationModel != null) {
                    BudgetHelper.m25094a(this.f23032a.f23053n, budgetRecommendationModel);
                    this.f23032a.m25041h();
                    return;
                }
                return;
            }
            this.f23032a.f23047h.b(5898248, Key.FETCH_BUDGET_RECOMMENDATION.hashCode(), (short) 4);
        }

        protected final void m24999a(Throwable th) {
            this.f23032a.f23047h.b(5898248, Key.FETCH_BUDGET_RECOMMENDATION.hashCode(), (short) 3);
            if (this.f23032a.f22439a) {
                this.f23032a.f22440b.m22429a(new ErrorDialogEvent());
                BaseBudgetOptionsViewController.m25017a(this.f23032a, false);
            }
        }
    }

    /* compiled from: Untrusted identity made a connection request */
    class C27007 implements TextWatcher {
        String f23033a;
        int f23034b;
        final /* synthetic */ BaseBudgetOptionsViewController f23035c;

        C27007(BaseBudgetOptionsViewController baseBudgetOptionsViewController) {
            this.f23035c = baseBudgetOptionsViewController;
        }

        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            this.f23033a = charSequence.toString();
            this.f23034b = this.f23035c.f23040a.getCursorPositionOnEditText();
        }

        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public void afterTextChanged(Editable editable) {
            if (StringUtil.a(editable.toString()) || editable.toString().matches("^0.*")) {
                editable.clear();
                this.f23035c.f23053n.m22846a(null, null);
                this.f23035c.f23053n.m22848b(null, null);
                this.f23035c.m25008a(EditableRadioButtonState.EMPTY_SELECTED);
                this.f23035c.m25043j();
                this.f23035c.f22440b.m22429a(new SelectedBudgetChangeEvent(null));
                this.f23035c.f22440b.m22431a(AdInterfacesDataValidation.INVALID_BUDGET, false);
                return;
            }
            BigDecimal multiply = new BigDecimal(editable.toString()).multiply(new BigDecimal(AdInterfacesDataHelper.m22808f(this.f23035c.f23053n)));
            if (this.f23035c.f23053n.f21751g != null && multiply.compareTo(new BigDecimal(this.f23035c.f23053n.f21751g.m23422k())) == 0) {
                return;
            }
            if (this.f23035c.mo1029d() != BudgetTipType.MAX || this.f23035c.f23053n.f21751g == null || multiply.compareTo(new BigDecimal(this.f23035c.f23053n.f21751g.m23422k())) <= 0) {
                CurrencyQuantityModel b = this.f23035c.mo1028b(BudgetHelper.m25095a(multiply, this.f23035c.f23053n));
                this.f23035c.f23053n.m22846a(b, null);
                this.f23035c.f23053n.m22848b(b, null);
                this.f23035c.f23046g.m22787q(this.f23035c.f23053n);
                this.f23035c.m25043j();
                this.f23035c.f22440b.m22429a(new SelectedBudgetChangeEvent(b));
                this.f23035c.f22440b.m22431a(AdInterfacesDataValidation.INVALID_BUDGET, this.f23035c.m25042i());
                BaseBudgetOptionsViewController.m25019c(this.f23035c, b);
                this.f23035c.m25008a(EditableRadioButtonState.VALID);
                BaseBudgetOptionsViewController.m25020u(this.f23035c);
                return;
            }
            int i = this.f23034b;
            this.f23035c.f23040a.setTextEditText(this.f23033a);
            this.f23035c.f23040a.setSelectionOnEditText(i);
        }
    }

    /* compiled from: Untrusted identity made a connection request */
    class C27018 extends AbstractDisposableFutureCallback<BudgetRecommendationModel> {
        final /* synthetic */ BaseBudgetOptionsViewController f23036a;

        C27018(BaseBudgetOptionsViewController baseBudgetOptionsViewController) {
            this.f23036a = baseBudgetOptionsViewController;
        }

        protected final void m25000a(Object obj) {
            BudgetRecommendationModel budgetRecommendationModel = (BudgetRecommendationModel) obj;
            if (this.f23036a.f22439a) {
                this.f23036a.f23047h.b(5898248, Key.FETCH_SINGLE_BUDGET_RECOMMENDATION.hashCode(), (short) 2);
                BaseBudgetOptionsViewController.m25017a(this.f23036a, false);
                EditableRadioButtonState a = this.f23036a.m25003a(this.f23036a.f23040a.getTextEditText());
                this.f23036a.m25008a(a);
                if (budgetRecommendationModel != null && budgetRecommendationModel.m23380a() == FetchBudgetRecommendationsMethod.f22360a.intValue()) {
                    if (a == EditableRadioButtonState.EMPTY_UNSELECTED) {
                        this.f23036a.f23053n.m22846a(null, this.f23036a.f23053n.f21752h);
                        return;
                    } else if (a == EditableRadioButtonState.EMPTY_SELECTED) {
                        this.f23036a.f23053n.m22846a(null, null);
                        this.f23036a.f23053n.m22848b(null, null);
                        this.f23036a.f22440b.m22429a(new SelectedBudgetChangeEvent(null));
                        this.f23036a.f22440b.m22431a(AdInterfacesDataValidation.INVALID_BUDGET, false);
                        return;
                    } else {
                        BudgetRecommendationDataModel j = ((EdgesModel) budgetRecommendationModel.m23384j().get(0)).m23378j();
                        this.f23036a.f23053n.m22846a(j.m23367a(), j.m23370j());
                        this.f23036a.m25043j();
                        BaseBudgetOptionsViewController.m25015a(this.f23036a, j);
                        if (this.f23036a.f23040a.isChecked()) {
                            this.f23036a.f23053n.m22848b(j.m23367a(), j.m23370j());
                            this.f23036a.f22440b.m22429a(new SelectedBudgetChangeEvent(j.m23367a()));
                            this.f23036a.f22440b.m22431a(AdInterfacesDataValidation.INVALID_BUDGET, this.f23036a.m25042i());
                            return;
                        }
                        return;
                    }
                }
                return;
            }
            this.f23036a.f23047h.b(5898248, Key.FETCH_SINGLE_BUDGET_RECOMMENDATION.hashCode(), (short) 4);
        }

        protected final void m25001a(Throwable th) {
            this.f23036a.f23047h.b(5898248, Key.FETCH_SINGLE_BUDGET_RECOMMENDATION.hashCode(), (short) 3);
            if (this.f23036a.f22439a) {
                BaseBudgetOptionsViewController.m25017a(this.f23036a, false);
                this.f23036a.m25013r();
            }
        }
    }

    /* compiled from: Untrusted identity made a connection request */
    class C27029 implements Function<String, SpinnerAdapterItem> {
        String f23037a = null;
        String f23038b = null;
        final /* synthetic */ BaseBudgetOptionsViewController f23039c;

        C27029(BaseBudgetOptionsViewController baseBudgetOptionsViewController) {
            this.f23039c = baseBudgetOptionsViewController;
        }

        public Object apply(Object obj) {
            String str = (String) obj;
            if (this.f23037a == null) {
                this.f23037a = this.f23039c.f23054o.getContext().getString(2131234006);
            }
            if (this.f23038b == null) {
                this.f23038b = this.f23039c.f23054o.getContext().getString(2131234005);
            }
            String a = CurrencyConfig.a(this.f23039c.f23054o.getContext(), str);
            return new SpinnerAdapterItem(StringFormatUtil.a(this.f23038b, new Object[]{a, str}), null, StringFormatUtil.a(this.f23037a, new Object[]{a, str}));
        }
    }

    protected abstract Spanned mo1023a(IntervalModel intervalModel);

    protected abstract CharSequence mo1024a(CurrencyQuantityModel currencyQuantityModel);

    protected abstract void mo1025a(AdInterfacesStatus adInterfacesStatus);

    protected abstract Spanned mo1027b(IntervalModel intervalModel);

    protected abstract CurrencyQuantityModel mo1028b(CurrencyQuantityModel currencyQuantityModel);

    protected abstract BudgetTipType mo1029d();

    protected abstract String mo1030e();

    protected abstract Spanned mo1031f();

    protected abstract Spanned mo1032g();

    public BaseBudgetOptionsViewController(Resources resources, InputMethodManager inputMethodManager, BudgetHelper budgetHelper, TasksManager tasksManager, FetchBudgetRecommendationsMethod fetchBudgetRecommendationsMethod, AdInterfacesSpinnerAdapterProvider adInterfacesSpinnerAdapterProvider, DefaultAndroidThreadUtil defaultAndroidThreadUtil, GraphQLQueryExecutor graphQLQueryExecutor, AdInterfacesErrorReporter adInterfacesErrorReporter, BoostedComponentLogger boostedComponentLogger, QuickPerformanceLogger quickPerformanceLogger) {
        super(inputMethodManager);
        this.f23056q = resources;
        this.f23043d = budgetHelper;
        this.f23044e = tasksManager;
        this.f23045f = fetchBudgetRecommendationsMethod;
        this.f23046g = boostedComponentLogger;
        this.f23047h = quickPerformanceLogger;
        this.f23048i = adInterfacesSpinnerAdapterProvider;
        this.f23052m = defaultAndroidThreadUtil;
        this.f23049j = graphQLQueryExecutor;
        this.f23051l = adInterfacesErrorReporter;
    }

    public void mo983a(D d) {
        this.f23053n = d;
    }

    public void mo1026a(BudgetOptionsView budgetOptionsView, AdInterfacesCardLayout adInterfacesCardLayout) {
        super.mo1017a((BaseEditableRadioGroupView) budgetOptionsView, adInterfacesCardLayout);
        this.f23054o = budgetOptionsView;
        this.f23055p = adInterfacesCardLayout;
        mo1025a(this.f23053n.f21748d);
        m25024z(this);
        m25041h();
        this.f22440b.m22430a(new C26941(this));
        this.f22440b.m22430a(new C26952(this));
        this.f22440b.m22430a(new C26963(this));
        this.f22440b.m22430a(new C26974(this));
        m25023y(this);
        m25013r();
        this.f22440b.m22431a(AdInterfacesDataValidation.INVALID_BUDGET, m25042i());
        m25043j();
        m25020u(this);
        this.f23055p.m24585a(this.f23055p.getResources().getString(2131233885), 2130843649);
    }

    public final void mo981a() {
        super.mo981a();
        this.f23044e.c();
        this.f23054o.setOnCheckChangedListener(null);
        this.f23054o = null;
        this.f23055p = null;
    }

    public final void mo984a(Bundle bundle) {
        FlatBufferModelHelper.a(bundle, "selected_budget", this.f23053n.f21750f);
        FlatBufferModelHelper.a(bundle, "selected_interval", this.f23053n.f21752h);
    }

    public final void mo985b(@Nullable Bundle bundle) {
        if (bundle == null) {
            m25044m();
        } else {
            this.f23053n.m22848b((CurrencyQuantityModel) FlatBufferModelHelper.a(bundle, "selected_budget"), (IntervalModel) FlatBufferModelHelper.a(bundle, "selected_interval"));
        }
    }

    public static void m25020u(BaseBudgetOptionsViewController baseBudgetOptionsViewController) {
        if (AdInterfacesDataHelper.m22814j(baseBudgetOptionsViewController.f23053n) && (baseBudgetOptionsViewController.f23053n instanceof AdInterfacesBoostedComponentDataModel)) {
            baseBudgetOptionsViewController.f22440b.m22431a(AdInterfacesDataValidation.UNEDITED_DATA, AdInterfacesDataHelper.m22801a((AdInterfacesBoostedComponentDataModel) baseBudgetOptionsViewController.f23053n));
        }
    }

    protected final void m25041h() {
        BaseEditableRadioGroupView baseEditableRadioGroupView = this.f23054o;
        for (int i = 0; i < baseEditableRadioGroupView.f23059c.size(); i++) {
            ((FbCustomRadioButton) baseEditableRadioGroupView.f23059c.get(i)).setVisibility(8);
        }
        if (!this.f23040a.isChecked()) {
            if (this.f23053n.f21745a.m23191o() == null) {
                this.f23054o.f23058b.setChecked(true);
            } else {
                for (int i2 = 0; i2 < this.f23053n.f21745a.m23191o().m23380a(); i2++) {
                    EdgesModel edgesModel = (EdgesModel) this.f23053n.f21745a.m23191o().m23384j().get(i2);
                    if (edgesModel.m23377a()) {
                        this.f23053n.m22848b(edgesModel.m23378j().m23367a(), edgesModel.m23378j().m23370j());
                        this.f23054o.m25050e(i2);
                        break;
                    }
                }
                this.f23054o.m25050e(0);
            }
        }
        if (this.f23053n.f21745a.m23191o() != null) {
            int i3 = 0;
            while (i3 < this.f23053n.f21745a.m23191o().m23380a()) {
                BaseEditableRadioGroupView baseEditableRadioGroupView2 = this.f23054o;
                if (i3 < 0 && i3 >= baseEditableRadioGroupView2.f23059c.size()) {
                    ((FbCustomRadioButton) baseEditableRadioGroupView2.f23059c.get(i3)).setVisibility(0);
                }
                BudgetRecommendationDataModel j = ((EdgesModel) this.f23053n.f21745a.m23191o().m23384j().get(i3)).m23378j();
                CharSequence a = mo1024a(j.m23367a());
                if (a == null) {
                    baseEditableRadioGroupView2 = this.f23054o;
                    if (i3 < 0 && i3 >= baseEditableRadioGroupView2.f23059c.size()) {
                        ((FbCustomRadioButton) baseEditableRadioGroupView2.f23059c.get(i3)).setVisibility(8);
                    }
                } else {
                    BaseEditableRadioGroupView baseEditableRadioGroupView3 = this.f23054o;
                    CharSequence a2 = mo1023a(j.m23370j());
                    boolean z = i3 >= 0 && i3 < baseEditableRadioGroupView3.f23059c.size();
                    Preconditions.checkArgument(z);
                    ((FbCustomRadioButton) baseEditableRadioGroupView3.f23059c.get(i3)).setVisibility(0);
                    ((FbCustomRadioButton) baseEditableRadioGroupView3.f23059c.get(i3)).setTextTextViewStart(a);
                    ((FbCustomRadioButton) baseEditableRadioGroupView3.f23059c.get(i3)).setTextTextViewEnd(a2);
                    BaseEditableRadioGroupView baseEditableRadioGroupView4 = this.f23054o;
                    CharSequence b = mo1027b(j.m23370j());
                    z = i3 >= 0 && i3 < baseEditableRadioGroupView4.f23059c.size();
                    Preconditions.checkArgument(z);
                    ((FbCustomRadioButton) baseEditableRadioGroupView4.f23059c.get(i3)).setContentDescriptionTextViewEnd(b);
                }
                i3++;
            }
            this.f23054o.setOnCheckChangedListener(new C26985(this));
        }
    }

    protected final boolean m25042i() {
        if (m25022x(this) == null) {
            return false;
        }
        BudgetTipType d = mo1029d();
        if (d == BudgetTipType.MAX || d == BudgetTipType.MIN) {
            return false;
        }
        return true;
    }

    private boolean m25021w() {
        return Integer.valueOf(this.f23054o.getSelectedIndex()) == this.f23040a.getTag();
    }

    public static CurrencyQuantityModel m25022x(BaseBudgetOptionsViewController baseBudgetOptionsViewController) {
        int selectedIndex = baseBudgetOptionsViewController.f23054o.getSelectedIndex();
        if (selectedIndex == -1) {
            return null;
        }
        if (Integer.valueOf(selectedIndex) == baseBudgetOptionsViewController.f23040a.getTag()) {
            return baseBudgetOptionsViewController.f23053n.f21751g;
        }
        if (selectedIndex < baseBudgetOptionsViewController.f23053n.f21745a.m23191o().m23380a()) {
            return ((EdgesModel) baseBudgetOptionsViewController.f23053n.f21745a.m23191o().m23384j().get(baseBudgetOptionsViewController.f23054o.getSelectedIndex())).m23378j().m23367a();
        }
        return null;
    }

    protected final void m25043j() {
        switch (mo1029d()) {
            case MAX:
                m25014a(mo1032g());
                return;
            case MIN:
                m25014a(mo1031f());
                return;
            case NONE:
                m25014a(null);
                return;
            default:
                return;
        }
    }

    private void m25014a(Spanned spanned) {
        boolean a = this.f23055p.m24587a();
        this.f23055p.setFooterSpannableText(spanned);
        if (spanned != null && !a) {
            AdInterfacesUiUtil.m25234a(this.f23055p);
        }
    }

    protected final void m25044m() {
        String str;
        String str2 = null;
        this.f23047h.e(5898248, Key.FETCH_BUDGET_RECOMMENDATION.hashCode());
        this.f23047h.b(5898248, Key.FETCH_BUDGET_RECOMMENDATION.hashCode(), this.f23053n.mo962b().name());
        m25017a(this, true);
        if (this.f23053n.f21750f == null || m25021w() || !(this.f23053n.f21748d == AdInterfacesStatus.INACTIVE || this.f23053n.f21748d == AdInterfacesStatus.NEVER_BOOSTED)) {
            str = null;
        } else {
            str = Long.toString(BudgetHelper.m25098a(this.f23053n.f21750f).longValue());
        }
        TasksManager tasksManager = this.f23044e;
        Key key = Key.FETCH_BUDGET_RECOMMENDATION;
        FetchBudgetRecommendationsMethod fetchBudgetRecommendationsMethod = this.f23045f;
        String str3 = this.f23053n.f21747c;
        BoostedComponentAppInputBoostedComponentApp componentAppEnum = this.f23053n.mo962b().getComponentAppEnum();
        String c = BudgetHelper.m25103c(this.f23053n);
        String i = this.f23053n.m22853i();
        String valueOf = String.valueOf(AdInterfacesDataHelper.m22802b(this.f23053n.f21753i));
        if (this.f23053n.f21754j.f21728h != null) {
            str2 = this.f23053n.f21754j.f21728h.name();
        }
        tasksManager.a(key, fetchBudgetRecommendationsMethod.m24150a(str3, componentAppEnum, c, i, valueOf, str, str2, this.f23053n.f21754j.f21729i, this.f23053n.f21754j, FetchBudgetRecommendationsMethod.f22361b), new C26996(this));
    }

    public static void m25023y(BaseBudgetOptionsViewController baseBudgetOptionsViewController) {
        baseBudgetOptionsViewController.f23040a.setTextPrefixTextView(BudgetHelper.m25107g(baseBudgetOptionsViewController.f23053n).getCurrency().getSymbol());
    }

    public static void m25015a(BaseBudgetOptionsViewController baseBudgetOptionsViewController, BudgetRecommendationDataModel budgetRecommendationDataModel) {
        if (budgetRecommendationDataModel == null || budgetRecommendationDataModel.m23370j() == null) {
            baseBudgetOptionsViewController.f23040a.setTextSuffixTextView("");
            return;
        }
        baseBudgetOptionsViewController.f23040a.setTextSuffixTextView(baseBudgetOptionsViewController.mo1023a(budgetRecommendationDataModel.m23370j()));
        baseBudgetOptionsViewController.f23040a.setContentDescriptionSuffixTextView(baseBudgetOptionsViewController.mo1027b(budgetRecommendationDataModel.m23370j()));
        baseBudgetOptionsViewController.f23040a.setContentDescriptionPrefixTextView(BudgetHelper.m25107g(baseBudgetOptionsViewController.f23053n).getCurrency().getSymbol() + baseBudgetOptionsViewController.f23040a.getTextEditText());
    }

    protected final TextWatcher mo1018n() {
        return new C27007(this);
    }

    public static void m25019c(BaseBudgetOptionsViewController baseBudgetOptionsViewController, CurrencyQuantityModel currencyQuantityModel) {
        String str = null;
        m25015a(baseBudgetOptionsViewController, null);
        baseBudgetOptionsViewController.f23047h.e(5898248, Key.FETCH_SINGLE_BUDGET_RECOMMENDATION.hashCode());
        baseBudgetOptionsViewController.f23047h.b(5898248, Key.FETCH_SINGLE_BUDGET_RECOMMENDATION.hashCode(), baseBudgetOptionsViewController.f23053n.mo962b().name());
        m25017a(baseBudgetOptionsViewController, true);
        TasksManager tasksManager = baseBudgetOptionsViewController.f23044e;
        Key key = Key.FETCH_SINGLE_BUDGET_RECOMMENDATION;
        FetchBudgetRecommendationsMethod fetchBudgetRecommendationsMethod = baseBudgetOptionsViewController.f23045f;
        String str2 = baseBudgetOptionsViewController.f23053n.f21747c;
        BoostedComponentAppInputBoostedComponentApp componentAppEnum = baseBudgetOptionsViewController.f23053n.mo962b().getComponentAppEnum();
        String c = BudgetHelper.m25103c(baseBudgetOptionsViewController.f23053n);
        String i = baseBudgetOptionsViewController.f23053n.m22853i();
        String valueOf = String.valueOf(AdInterfacesDataHelper.m22802b(baseBudgetOptionsViewController.f23053n.m22852h()));
        String k = currencyQuantityModel.m23422k();
        if (baseBudgetOptionsViewController.f23053n.m22854j().m22841h() != null) {
            str = baseBudgetOptionsViewController.f23053n.m22854j().m22841h().name();
        }
        tasksManager.a(key, fetchBudgetRecommendationsMethod.m24150a(str2, componentAppEnum, c, i, valueOf, k, str, baseBudgetOptionsViewController.f23053n.m22854j().m22842i(), baseBudgetOptionsViewController.f23053n.m22854j(), FetchBudgetRecommendationsMethod.f22360a), new C27018(baseBudgetOptionsViewController));
    }

    public static void m25017a(BaseBudgetOptionsViewController baseBudgetOptionsViewController, boolean z) {
        baseBudgetOptionsViewController.f23055p.m24586a(z);
    }

    public static void m25024z(BaseBudgetOptionsViewController baseBudgetOptionsViewController) {
        AdAccountModel e = AdInterfacesDataHelper.m22806e(baseBudgetOptionsViewController.f23053n);
        if (e == null || !e.m23142p()) {
            baseBudgetOptionsViewController.f23054o.setSpinnerVisibility(false);
            return;
        }
        String a = e.m23139m().m23419a();
        ImmutableList a2 = CurrencyConfig.a(baseBudgetOptionsViewController.f23054o.getContext());
        if (baseBudgetOptionsViewController.f23050k == null) {
            baseBudgetOptionsViewController.f23050k = baseBudgetOptionsViewController.f23048i.m24920a(Lists.a(a2, new C27029(baseBudgetOptionsViewController)));
        }
        BudgetOptionsView budgetOptionsView = baseBudgetOptionsViewController.f23054o;
        AdInterfacesSpinnerAdapter adInterfacesSpinnerAdapter = baseBudgetOptionsViewController.f23050k;
        final ImmutableList immutableList = a2;
        final String str = a;
        final BudgetOptionsView budgetOptionsView2 = baseBudgetOptionsViewController.f23054o;
        final AdAccountModel adAccountModel = e;
        budgetOptionsView.m25111a(adInterfacesSpinnerAdapter, new OnItemSelectedListener(baseBudgetOptionsViewController) {
            final /* synthetic */ BaseBudgetOptionsViewController f23021e;

            /* compiled from: Untrusted identity made a connection request */
            class C26921 implements OnClickListener {
                final /* synthetic */ AnonymousClass10 f23014a;

                C26921(AnonymousClass10 anonymousClass10) {
                    this.f23014a = anonymousClass10;
                }

                public void onClick(DialogInterface dialogInterface, int i) {
                    budgetOptionsView2.setSpinnerSelected(immutableList.indexOf(str));
                }
            }

            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
                final String str = (String) immutableList.get(i);
                if (!StringUtil.a(str, str)) {
                    String string = budgetOptionsView2.getContext().getString(2131234008);
                    new Builder(budgetOptionsView2.getContext()).a(2131234007).b(StringFormatUtil.a(string, new Object[]{str})).a(2131230726, new OnClickListener(this) {
                        final /* synthetic */ AnonymousClass10 f23016b;

                        public void onClick(DialogInterface dialogInterface, int i) {
                            this.f23016b.f23021e.m25018a(budgetOptionsView2, adAccountModel, str, str, immutableList);
                        }
                    }).b(2131230727, new C26921(this)).b();
                }
            }

            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });
        baseBudgetOptionsViewController.f23054o.setSpinnerSelected(a2.indexOf(a));
    }

    private void m25018a(final BudgetOptionsView budgetOptionsView, AdAccountModel adAccountModel, String str, final String str2, final ImmutableList<String> immutableList) {
        m25017a(this, true);
        AdAccountSetCurrencyTimezoneInputData adAccountSetCurrencyTimezoneInputData = new AdAccountSetCurrencyTimezoneInputData();
        adAccountSetCurrencyTimezoneInputData.a("ad_account_id", adAccountModel.m23146t());
        GraphQlCallInput graphQlCallInput = adAccountSetCurrencyTimezoneInputData;
        graphQlCallInput.a("currency", str);
        graphQlCallInput = graphQlCallInput;
        graphQlCallInput.a("timezone", adAccountModel.m23131A().m23110a());
        this.f23052m.a(this.f23049j.a(GraphQLRequest.a((FBPageSetAdAccountCurrenyTimeZoneString) new FBPageSetAdAccountCurrenyTimeZoneString().a("input", graphQlCallInput))), new FutureCallback<GraphQLResult<FBPageSetAdAccountCurrenyTimeZoneModel>>(this) {
            final /* synthetic */ BaseBudgetOptionsViewController f23025d;

            public void onSuccess(Object obj) {
                if (this.f23025d.f22439a) {
                    BaseBudgetOptionsViewController.m25017a(this.f23025d, false);
                    this.f23025d.f22440b.m22429a(new InvalidateAccountEvent(this.f23025d.f23053n.m22853i()));
                    budgetOptionsView.m25049c();
                    this.f23025d.m25044m();
                }
            }

            public void onFailure(Throwable th) {
                if (this.f23025d.f22439a) {
                    this.f23025d.f23051l.m22727a(getClass(), "Failed to change currency", th);
                    BaseBudgetOptionsViewController.m25017a(this.f23025d, false);
                    budgetOptionsView.setSpinnerSelected(immutableList.indexOf(str2));
                    this.f23025d.f22440b.m22429a(new ErrorDialogEvent(null, budgetOptionsView.getContext().getString(2131234004)));
                }
            }
        });
    }

    protected final CharSequence mo1019o() {
        return " " + this.f23056q.getString(2131233892) + " ";
    }

    protected final CharSequence mo1020p() {
        return " " + this.f23056q.getString(2131233893, new Object[]{mo1030e()}) + " ";
    }
}
