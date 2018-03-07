package com.facebook.uberbar.ui;

import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.text.TextWatcher;
import android.view.ViewGroup;
import android.widget.EditText;
import com.facebook.analytics.InteractionLogger;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.common.android.FragmentActivityMethodAutoProvider;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.uberbar.analytics.SearchClickEvent;
import com.facebook.uberbar.analytics.UberbarResultsAnalyticHelper;
import com.facebook.uberbar.analytics.UberbarResultsAnalyticHelper.SessionEndReason;
import com.google.common.base.Preconditions;
import javax.inject.Inject;
import org.json.JSONArray;

@ContextScoped
/* compiled from: nearbyandroidlayouts */
public class NativeUberbarDelegate extends AbstractUberbarDelegate {
    private static NativeUberbarDelegate f5090j;
    private static final Object f5091k = new Object();
    public UberbarResultsFragment f5092g;
    public UberbarResultsAnalyticHelper f5093h;
    public FragmentManager f5094i;

    private static NativeUberbarDelegate m6377b(InjectorLike injectorLike) {
        return new NativeUberbarDelegate(InteractionLogger.a(injectorLike), FragmentActivityMethodAutoProvider.b(injectorLike), UberbarResultsAnalyticHelper.b(injectorLike));
    }

    public void mo148a(EditText editText, ViewGroup viewGroup, TextWatcher textWatcher) {
        this.f5087d = editText;
        this.f5088e = viewGroup;
        FragmentTransaction a = this.f5094i.a();
        a.a(this.f5088e.getId(), this.f5092g);
        a.b();
        m6373a(textWatcher);
        this.c = true;
    }

    @Inject
    public NativeUberbarDelegate(InteractionLogger interactionLogger, FragmentActivity fragmentActivity, UberbarResultsAnalyticHelper uberbarResultsAnalyticHelper) {
        this(interactionLogger, fragmentActivity, uberbarResultsAnalyticHelper, new UberbarResultsFragment());
    }

    NativeUberbarDelegate(InteractionLogger interactionLogger, FragmentActivity fragmentActivity, UberbarResultsAnalyticHelper uberbarResultsAnalyticHelper, UberbarResultsFragment uberbarResultsFragment) {
        super(interactionLogger, fragmentActivity);
        this.f5094i = fragmentActivity.kO_();
        this.f5092g = uberbarResultsFragment;
        this.f5093h = uberbarResultsAnalyticHelper;
        if (this.f5092g != null) {
            this.f5092g.as = this.f5093h;
        }
    }

    public static NativeUberbarDelegate m6376a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            NativeUberbarDelegate b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f5091k) {
                NativeUberbarDelegate nativeUberbarDelegate;
                if (a2 != null) {
                    nativeUberbarDelegate = (NativeUberbarDelegate) a2.a(f5091k);
                } else {
                    nativeUberbarDelegate = f5090j;
                }
                if (nativeUberbarDelegate == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m6377b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f5091k, b3);
                        } else {
                            f5090j = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = nativeUberbarDelegate;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    public final UberbarResultsAnalyticHelper mo145a() {
        Preconditions.checkState(this.f5086c);
        return this.f5093h;
    }

    public final void m6381c() {
        SessionEndReason sessionEndReason;
        Preconditions.checkState(this.f5086c);
        UberbarResultsAnalyticHelper uberbarResultsAnalyticHelper = this.f5093h;
        String obj = this.f5087d.getText().toString();
        Preconditions.checkNotNull(uberbarResultsAnalyticHelper.a);
        AnalyticsLogger analyticsLogger = uberbarResultsAnalyticHelper.g;
        SessionEndReason sessionEndReason2 = SessionEndReason.APP_BACKGROUNDED;
        if (!uberbarResultsAnalyticHelper.b.isEmpty()) {
            for (SearchClickEvent searchClickEvent : uberbarResultsAnalyticHelper.b) {
                String str = searchClickEvent.a;
                if (!str.equals("click")) {
                    if (str.equals("call_quick_action")) {
                        sessionEndReason = SessionEndReason.USER_CLICKED_INLINE_CALL;
                        break;
                    }
                }
                sessionEndReason = SessionEndReason.USER_CLICKED_RESULT;
                break;
            }
        }
        sessionEndReason = uberbarResultsAnalyticHelper.f ? SessionEndReason.BACK_PRESSED : uberbarResultsAnalyticHelper.e ? SessionEndReason.SEARCH_EXIT_PRESSED : sessionEndReason2;
        SessionEndReason sessionEndReason3 = sessionEndReason;
        HoneyClientEvent honeyClientEvent = new HoneyClientEvent("full_session");
        honeyClientEvent.c = "search_typeahead";
        HoneyClientEvent a = honeyClientEvent.b("query", obj).b("uuid", uberbarResultsAnalyticHelper.a).b("context", "mobile_search_android").a("keys_pressed", uberbarResultsAnalyticHelper.c).a("session_end_reason", sessionEndReason3);
        String str2 = "events";
        JSONArray jSONArray = new JSONArray();
        for (SearchClickEvent searchClickEvent2 : uberbarResultsAnalyticHelper.b) {
            jSONArray.put(searchClickEvent2.b());
        }
        analyticsLogger.c(a.b(str2, jSONArray.toString()));
        uberbarResultsAnalyticHelper.a = null;
    }

    public final void mo146a(String str) {
        this.f5092g.m6405a(str);
    }

    public final void mo147d() {
        this.f5092g.m6405a("");
    }
}
