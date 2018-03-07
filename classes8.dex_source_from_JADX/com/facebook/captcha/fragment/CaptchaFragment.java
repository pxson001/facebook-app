package com.facebook.captcha.fragment;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.net.Uri;
import android.os.Bundle;
import android.text.Editable;
import android.text.style.ClickableSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.base.fragment.FbFragment;
import com.facebook.captcha.helper.CaptchaHelper;
import com.facebook.captcha.logging.CaptchaAnalyticsLogger;
import com.facebook.captcha.logging.CaptchaAnalyticsLogger.EventType;
import com.facebook.captcha.protocol.RequestCaptchaMethod.Result;
import com.facebook.captcha.protocol.SolveCaptchaMethod.Params;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.util.StringUtil;
import com.facebook.common.util.StyledStringBuilder;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.fbservice.ops.DefaultBlueServiceOperationFactory;
import com.facebook.fbservice.ops.ErrorPropagation;
import com.facebook.fbservice.ops.OperationResultFutureCallback;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.fbservice.service.ServiceException;
import com.facebook.fbui.dialog.AlertDialog.Builder;
import com.facebook.inject.FbInjector;
import com.facebook.inject.InjectorLike;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.tools.dextr.runtime.detour.BlueServiceOperationFactoryDetour;
import com.facebook.ui.futures.TasksManager;
import com.facebook.ui.search.SearchEditText;
import com.facebook.ui.search.SearchEditText.OnSubmitListener;
import com.facebook.ui.toaster.ToastBuilder;
import com.facebook.ui.toaster.Toaster;
import com.facebook.widget.text.BetterLinkMovementMethod;
import com.facebook.widget.text.watcher.BaseTextWatcher;
import com.facebook.widget.titlebar.HasTitleBar;
import javax.inject.Inject;

/* compiled from: is_card_number_valid */
public class CaptchaFragment extends FbFragment {
    public static final CallerContext f10656f = CallerContext.a(CaptchaFragment.class);
    @Inject
    BetterLinkMovementMethod f10657a;
    public View al;
    public TextView am;
    public TextView an;
    public FbDraweeView ao;
    public String ap = null;
    public Integer aq = Integer.valueOf(0);
    private Integer ar = Integer.valueOf(0);
    @Inject
    DefaultBlueServiceOperationFactory f10658b;
    @Inject
    public CaptchaAnalyticsLogger f10659c;
    @Inject
    Toaster f10660d;
    @Inject
    TasksManager f10661e;
    public OnCaptchaSolvedListener f10662g;
    public SearchEditText f10663h;
    public Button f10664i;

    /* compiled from: is_card_number_valid */
    class C11281 extends ClickableSpan {
        final /* synthetic */ CaptchaFragment f10649a;

        C11281(CaptchaFragment captchaFragment) {
            this.f10649a = captchaFragment;
        }

        public void onClick(View view) {
            CaptchaFragment captchaFragment = this.f10649a;
            captchaFragment.f10663h.a();
            CaptchaFragment.as(captchaFragment);
            captchaFragment.am.setVisibility(8);
            captchaFragment.am.setVisibility(0);
            captchaFragment.aq = Integer.valueOf(captchaFragment.aq.intValue() + 1);
            CaptchaAnalyticsLogger captchaAnalyticsLogger = captchaFragment.f10659c;
            Integer num = captchaFragment.aq;
            AnalyticsLogger analyticsLogger = captchaAnalyticsLogger.f10666a;
            HoneyClientEvent honeyClientEvent = new HoneyClientEvent(EventType.TRY_ANOTHER_CAPTCHA_CLICKED.getEventName());
            honeyClientEvent.c = "captcha";
            analyticsLogger.b(honeyClientEvent.a("numTryAnotherClicks", num), 1);
        }
    }

    /* compiled from: is_card_number_valid */
    public class C11292 implements OnSubmitListener {
        final /* synthetic */ CaptchaFragment f10650a;

        public C11292(CaptchaFragment captchaFragment) {
            this.f10650a = captchaFragment;
        }

        public final void m12585a() {
            CaptchaFragment.aw(this.f10650a);
        }
    }

    /* compiled from: is_card_number_valid */
    public class C11303 extends BaseTextWatcher {
        final /* synthetic */ CaptchaFragment f10651a;

        public C11303(CaptchaFragment captchaFragment) {
            this.f10651a = captchaFragment;
        }

        public void afterTextChanged(Editable editable) {
            if (this.f10651a.f10663h.getText().length() > 0) {
                this.f10651a.f10664i.setEnabled(true);
            } else {
                this.f10651a.f10664i.setEnabled(false);
            }
        }
    }

    /* compiled from: is_card_number_valid */
    public class C11314 implements OnClickListener {
        final /* synthetic */ CaptchaFragment f10652a;

        public C11314(CaptchaFragment captchaFragment) {
            this.f10652a = captchaFragment;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 1882829911);
            CaptchaFragment.aw(this.f10652a);
            Logger.a(2, EntryType.UI_INPUT_END, 600679281, a);
        }
    }

    /* compiled from: is_card_number_valid */
    class C11325 extends OperationResultFutureCallback {
        final /* synthetic */ CaptchaFragment f10653a;

        C11325(CaptchaFragment captchaFragment) {
            this.f10653a = captchaFragment;
        }

        protected final void m12587a(Object obj) {
            OperationResult operationResult = (OperationResult) obj;
            if (operationResult == null) {
                this.f10653a.m12595b();
                return;
            }
            CaptchaFragment captchaFragment = this.f10653a;
            Result result = (Result) operationResult.h();
            captchaFragment.ap = result.m12602a();
            captchaFragment.ao.a(Uri.parse(result.m12603b()), CaptchaFragment.f10656f);
            CaptchaFragment.av(captchaFragment);
            AnalyticsLogger analyticsLogger = this.f10653a.f10659c.f10666a;
            HoneyClientEvent honeyClientEvent = new HoneyClientEvent(EventType.CAPTCHA_FETCH_REQUEST_SUCCEEDED.getEventName());
            honeyClientEvent.c = "captcha";
            analyticsLogger.b(honeyClientEvent, 1);
        }

        protected final void m12586a(ServiceException serviceException) {
            this.f10653a.m12595b();
        }
    }

    /* compiled from: is_card_number_valid */
    class C11336 extends OperationResultFutureCallback {
        final /* synthetic */ CaptchaFragment f10654a;

        C11336(CaptchaFragment captchaFragment) {
            this.f10654a = captchaFragment;
        }

        protected final void m12588a(ServiceException serviceException) {
            if (CaptchaHelper.m12598b(serviceException)) {
                this.f10654a.f10660d.a(new ToastBuilder(2131239742));
                this.f10654a.f10663h.a();
                CaptchaFragment.as(this.f10654a);
                this.f10654a.f10659c.m12601a(Boolean.valueOf(false));
                return;
            }
            this.f10654a.m12597e();
        }

        protected final void m12589a(Object obj) {
            this.f10654a.f10662g.a();
            this.f10654a.f10659c.m12601a(Boolean.valueOf(true));
        }
    }

    /* compiled from: is_card_number_valid */
    class C11347 implements DialogInterface.OnClickListener {
        final /* synthetic */ CaptchaFragment f10655a;

        C11347(CaptchaFragment captchaFragment) {
            this.f10655a = captchaFragment;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            CaptchaFragment.av(this.f10655a);
        }
    }

    public static void m12591a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        ((CaptchaFragment) obj).m12590a(BetterLinkMovementMethod.a(injectorLike), DefaultBlueServiceOperationFactory.b(injectorLike), CaptchaAnalyticsLogger.m12599a(injectorLike), Toaster.b(injectorLike), TasksManager.b(injectorLike));
    }

    private void m12590a(BetterLinkMovementMethod betterLinkMovementMethod, DefaultBlueServiceOperationFactory defaultBlueServiceOperationFactory, CaptchaAnalyticsLogger captchaAnalyticsLogger, Toaster toaster, TasksManager tasksManager) {
        this.f10657a = betterLinkMovementMethod;
        this.f10658b = defaultBlueServiceOperationFactory;
        this.f10659c = captchaAnalyticsLogger;
        this.f10660d = toaster;
        this.f10661e = tasksManager;
    }

    public final void m12596c(Bundle bundle) {
        super.c(bundle);
        Class cls = CaptchaFragment.class;
        m12591a((Object) this, getContext());
    }

    public final View m12592a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1586947072);
        View inflate = layoutInflater.inflate(2130903499, viewGroup, false);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -102026729, a);
        return inflate;
    }

    public final void m12593a(Activity activity) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -234410013);
        super.a(activity);
        try {
            this.f10662g = (OnCaptchaSolvedListener) activity;
            LogUtils.f(563123990, a);
        } catch (ClassCastException e) {
            ClassCastException classCastException = new ClassCastException(activity.toString() + " must implement OnCaptchaSolvedListener");
            LogUtils.f(-1818746640, a);
            throw classCastException;
        }
    }

    public final void m12594a(View view, Bundle bundle) {
        super.a(view, bundle);
        this.ao = (FbDraweeView) e(2131560197);
        this.f10663h = (SearchEditText) e(2131560200);
        this.f10664i = (Button) e(2131560201);
        this.am = (TextView) e(2131560202);
        this.an = (TextView) e(2131560199);
        this.al = e(2131560198);
        StyledStringBuilder styledStringBuilder = new StyledStringBuilder(jW_());
        styledStringBuilder.a(StringFormatUtil.formatStrLocaleSafe(jW_().getString(2131239744), "{CAPTCHA_RETRY_TOKEN}"));
        styledStringBuilder.a("{CAPTCHA_RETRY_TOKEN}", jW_().getString(2131239745), new C11281(this), 33);
        this.am.setMovementMethod(this.f10657a);
        this.am.setText(styledStringBuilder.b());
        this.f10663h.f = new C11292(this);
        this.f10663h.addTextChangedListener(new C11303(this));
        this.f10664i.setOnClickListener(new C11314(this));
        as(this);
        AnalyticsLogger analyticsLogger = this.f10659c.f10666a;
        HoneyClientEvent honeyClientEvent = new HoneyClientEvent(EventType.CAPTCHA_SHOWN.getEventName());
        honeyClientEvent.c = "captcha";
        analyticsLogger.b(honeyClientEvent, 1);
    }

    public final void mi_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 832745707);
        super.mi_();
        HasTitleBar hasTitleBar = (HasTitleBar) a(HasTitleBar.class);
        if (hasTitleBar != null) {
            hasTitleBar.y_(2131239739);
        }
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -1877592984, a);
    }

    public static void as(CaptchaFragment captchaFragment) {
        captchaFragment.ao.setVisibility(8);
        captchaFragment.al.setVisibility(0);
        captchaFragment.an.setVisibility(0);
        Bundle bundle = new Bundle();
        bundle.putParcelable("requestCaptchaParamsKey", null);
        captchaFragment.f10661e.a(null, BlueServiceOperationFactoryDetour.a(captchaFragment.f10658b, "request_captcha", bundle, ErrorPropagation.BY_ERROR_CODE, CallerContext.a(CaptchaFragment.class), -886482704).a(), new C11325(captchaFragment));
    }

    public static void av(CaptchaFragment captchaFragment) {
        captchaFragment.ao.setVisibility(0);
        captchaFragment.al.setVisibility(8);
        captchaFragment.an.setVisibility(8);
    }

    public static void aw(CaptchaFragment captchaFragment) {
        Object obj = captchaFragment.f10663h.getText().toString();
        if (!StringUtil.a(obj)) {
            if (captchaFragment.ap == null) {
                as(captchaFragment);
                return;
            }
            captchaFragment.ar = Integer.valueOf(captchaFragment.ar.intValue() + 1);
            CaptchaAnalyticsLogger captchaAnalyticsLogger = captchaFragment.f10659c;
            Integer num = captchaFragment.ar;
            AnalyticsLogger analyticsLogger = captchaAnalyticsLogger.f10666a;
            HoneyClientEvent honeyClientEvent = new HoneyClientEvent(EventType.SUBMIT_CAPTCHA_INPUT_CLICKED.getEventName());
            honeyClientEvent.c = "captcha";
            analyticsLogger.b(honeyClientEvent.a("numSubmitClicks", num), 1);
            Bundle bundle = new Bundle();
            bundle.putParcelable("solveCaptchaParamsKey", new Params(captchaFragment.ap, obj));
            captchaFragment.f10661e.a(null, BlueServiceOperationFactoryDetour.a(captchaFragment.f10658b, "solve_captcha", bundle, ErrorPropagation.BY_ERROR_CODE, CallerContext.a(CaptchaFragment.class), 1925372640).a(), new C11336(captchaFragment));
        }
    }

    public final void m12595b() {
        ax();
        AnalyticsLogger analyticsLogger = this.f10659c.f10666a;
        HoneyClientEvent honeyClientEvent = new HoneyClientEvent(EventType.CAPTCHA_FETCH_REQUEST_FAILED.getEventName());
        honeyClientEvent.c = "captcha";
        analyticsLogger.b(honeyClientEvent, 1);
    }

    public final void m12597e() {
        ax();
        AnalyticsLogger analyticsLogger = this.f10659c.f10666a;
        HoneyClientEvent honeyClientEvent = new HoneyClientEvent(EventType.CAPTCHA_SOLVE_REQUEST_FAILED.getEventName());
        honeyClientEvent.c = "captcha";
        analyticsLogger.b(honeyClientEvent, 1);
    }

    private void ax() {
        this.f10663h.a();
        new Builder(getContext()).a(b(2131239747)).b(b(2131239748)).a(b(2131230756), new C11347(this)).b();
    }
}
