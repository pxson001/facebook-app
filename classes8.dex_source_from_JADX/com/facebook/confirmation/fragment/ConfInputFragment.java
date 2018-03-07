package com.facebook.confirmation.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.facebook.base.fragment.AbstractNavigableFragment;
import com.facebook.common.executors.ForUiThread;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.common.json.FbObjectMapper;
import com.facebook.common.network.FbNetworkManager;
import com.facebook.common.util.FindViewUtil;
import com.facebook.common.util.StringUtil;
import com.facebook.confirmation.constants.ConfFragmentState;
import com.facebook.confirmation.model.AccountConfirmationData;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.fbservice.service.ServiceException;
import com.facebook.http.protocol.ApiErrorResult;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.resources.ui.FbButton;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.ui.keyboard.KeyboardUtils;
import com.facebook.widget.titlebar.HasTitleBar;
import com.fasterxml.jackson.core.type.TypeReference;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: interstitial_type */
public abstract class ConfInputFragment extends AbstractNavigableFragment {
    private static final Pattern f10734b = Pattern.compile("(\\s*\\(\\d{1,10}\\))");
    @Inject
    public AccountConfirmationData al;
    @Inject
    @ForUiThread
    public Executor am;
    @Inject
    public Lazy<FbObjectMapper> an;
    @Inject
    public FbNetworkManager ao;
    protected FbButton ap;
    protected TextView aq;
    protected TextView ar;

    /* compiled from: interstitial_type */
    class C11561 implements OnClickListener {
        final /* synthetic */ ConfInputFragment f10753a;

        C11561(ConfInputFragment confInputFragment) {
            this.f10753a = confInputFragment;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -2001473441);
            this.f10753a.at();
            Logger.a(2, EntryType.UI_INPUT_END, -22814438, a);
        }
    }

    /* compiled from: interstitial_type */
    class C11572 implements OnEditorActionListener {
        final /* synthetic */ ConfInputFragment f10754a;

        C11572(ConfInputFragment confInputFragment) {
            this.f10754a = confInputFragment;
        }

        public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
            if ((keyEvent == null || keyEvent.getKeyCode() != 66) && i != 6) {
                return false;
            }
            KeyboardUtils.a(this.f10754a.o());
            this.f10754a.at();
            return true;
        }
    }

    /* compiled from: interstitial_type */
    class C11583 extends TypeReference<Map<String, String>> {
        final /* synthetic */ ConfInputFragment f10755b;

        C11583(ConfInputFragment confInputFragment) {
            this.f10755b = confInputFragment;
        }
    }

    public static void m12660a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        ConfInputFragment confInputFragment = (ConfInputFragment) obj;
        AccountConfirmationData a = AccountConfirmationData.m12724a(injectorLike);
        Executor executor = (Executor) ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.a(injectorLike);
        Lazy b = IdBasedSingletonScopeProvider.b(injectorLike, 572);
        FbNetworkManager a2 = FbNetworkManager.a(injectorLike);
        confInputFragment.al = a;
        confInputFragment.am = executor;
        confInputFragment.an = b;
        confInputFragment.ao = a2;
    }

    protected abstract int aB();

    protected abstract int aq();

    protected abstract int ar();

    protected abstract int as();

    protected abstract void at();

    protected abstract ConfFragmentState ay();

    protected abstract int az();

    protected abstract int mo756e();

    public void mo755c(Bundle bundle) {
        super.c(bundle);
        Class cls = ConfInputFragment.class;
        m12660a((Object) this, getContext());
    }

    public final View m12661a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1696365334);
        if (this.g) {
            Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 547723455, a);
            return null;
        }
        View inflate = layoutInflater.inflate(2130903746, viewGroup, false);
        if (mo756e() != 0) {
            ViewStub viewStub = (ViewStub) FindViewUtil.b(inflate, 2131560675);
            viewStub.setLayoutResource(mo756e());
            viewStub.inflate();
        }
        if (aq() != 0) {
            viewStub = (ViewStub) FindViewUtil.b(inflate, 2131560677);
            viewStub.setLayoutResource(aq());
            viewStub.inflate();
        }
        this.ap = (FbButton) FindViewUtil.b(inflate, 2131559172);
        this.aq = (TextView) FindViewUtil.b(inflate, 2131560676);
        this.ar = (TextView) FindViewUtil.b(inflate, 2131560281);
        this.ap.setText(as());
        this.ar.setText(aB());
        this.ar.setContentDescription(jW_().getText(aB()));
        this.ap.setOnClickListener(new C11561(this));
        mo754b(inflate, bundle);
        LogUtils.f(1825803783, a);
        return inflate;
    }

    protected final void q_() {
        super.q_();
        HasTitleBar hasTitleBar = (HasTitleBar) a(HasTitleBar.class);
        if (hasTitleBar != null) {
            hasTitleBar.y_(ar());
        }
    }

    protected void mo754b(View view, Bundle bundle) {
    }

    protected final void m12663a(ConfFragmentState confFragmentState) {
        KeyboardUtils.a(o());
        b(new Intent(confFragmentState.getKey()));
    }

    protected final void m12662a(TextView textView) {
        textView.setOnEditorActionListener(new C11572(this));
    }

    protected final void m12664a(ServiceException serviceException) {
        CharSequence b = m12665b(serviceException);
        if (StringUtil.a(b)) {
            if (this.ao.d()) {
                b = b(2131230758);
            } else {
                b = b(2131230759);
            }
        }
        this.aq.setText(b);
        this.aq.setVisibility(0);
    }

    @Nullable
    protected final String m12665b(ServiceException serviceException) {
        ApiErrorResult apiErrorResult;
        if (serviceException == null) {
            apiErrorResult = null;
        } else {
            OperationResult operationResult = serviceException.result;
            if (operationResult == null) {
                apiErrorResult = null;
            } else {
                Bundle bundle = operationResult.d;
                if (bundle == null) {
                    apiErrorResult = null;
                } else {
                    Object obj = bundle.get("result");
                    apiErrorResult = !(obj instanceof ApiErrorResult) ? null : (ApiErrorResult) obj;
                }
            }
        }
        ApiErrorResult apiErrorResult2 = apiErrorResult;
        if (apiErrorResult2 == null) {
            return null;
        }
        Map map = (Map) m12658a(new C11583(this), apiErrorResult2);
        if (map == null || map.isEmpty()) {
            return m12659a(apiErrorResult2.c());
        }
        if (map.containsKey("error_message")) {
            return (String) map.get("error_message");
        }
        return map.containsKey("error_title") ? (String) map.get("error_title") : null;
    }

    @Nullable
    private <T> T m12658a(TypeReference<T> typeReference, ApiErrorResult apiErrorResult) {
        Object d = apiErrorResult.d();
        if (StringUtil.a(d)) {
            return null;
        }
        try {
            return ((FbObjectMapper) this.an.get()).a(d, typeReference);
        } catch (IOException e) {
            return null;
        }
    }

    @Nullable
    private static String m12659a(String str) {
        if (StringUtil.a(str)) {
            return null;
        }
        Matcher matcher = f10734b.matcher(str);
        return matcher.find() ? matcher.replaceFirst("") : str;
    }
}
