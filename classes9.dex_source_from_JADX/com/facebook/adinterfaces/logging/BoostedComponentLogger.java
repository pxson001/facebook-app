package com.facebook.adinterfaces.logging;

import com.facebook.adinterfaces.error.AdInterfacesErrorReporter;
import com.facebook.adinterfaces.model.AdInterfacesDataHelper;
import com.facebook.adinterfaces.model.AdInterfacesStatus;
import com.facebook.adinterfaces.model.BaseAdInterfacesData;
import com.facebook.adinterfaces.model.boostpost.AdInterfacesBoostPostDataModel;
import com.facebook.adinterfaces.model.boostpost.AdInterfacesBoostedComponentDataModel;
import com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.BoostedComponentModel;
import com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.StoryPromotionModel;
import com.facebook.adinterfaces.ui.BudgetHelper;
import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.event.HoneyClientEventFast;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.common.json.FbObjectMapperMethodAutoProvider;
import com.facebook.fbservice.service.ServiceException;
import com.facebook.graphql.enums.GraphQLBoostedComponentBudgetType;
import com.facebook.graphql.enums.GraphQLBoostedPostAudienceOption;
import com.facebook.graphql.error.GraphQLException;
import com.facebook.inject.InjectorLike;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: \d{3}[ ]?\d{2} */
public class BoostedComponentLogger {
    private static volatile BoostedComponentLogger f21681g;
    private final AnalyticsLogger f21682a;
    private final ObjectMapper f21683b;
    private final AdInterfacesErrorReporter f21684c;
    private final AdInterfacesDataHelper f21685d;
    public String f21686e;
    public BaseAdInterfacesData f21687f;

    public static com.facebook.adinterfaces.logging.BoostedComponentLogger m22753a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Can't find immediate dominator for block B:24:0x003b in {17, 19, 21, 23, 26, 28} preds:[]
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.computeDominators(BlockProcessor.java:129)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.processBlocksTree(BlockProcessor.java:48)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.rerun(BlockProcessor.java:44)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.visit(BlockFinallyExtract.java:57)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r0 = f21681g;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.adinterfaces.logging.BoostedComponentLogger.class;
        monitor-enter(r1);
        r0 = f21681g;	 Catch:{ all -> 0x003a }
        if (r0 != 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000b:
        if (r5 == 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000d:
        r2 = com.facebook.inject.ScopeSet.a();	 Catch:{ all -> 0x003a }
        r3 = r2.b();	 Catch:{ all -> 0x003a }
        r0 = com.facebook.inject.SingletonScope.class;	 Catch:{ all -> 0x003a }
        r0 = r5.getInstance(r0);	 Catch:{ all -> 0x003a }
        r0 = (com.facebook.inject.SingletonScope) r0;	 Catch:{ all -> 0x003a }
        r4 = r0.enterScope();	 Catch:{ all -> 0x003a }
        r0 = r5.getApplicationInjector();	 Catch:{ all -> 0x0035 }
        r0 = m22758b(r0);	 Catch:{ all -> 0x0035 }
        f21681g = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f21681g;
        return r0;
    L_0x0035:
        r0 = move-exception;
        com.facebook.inject.SingletonScope.a(r4);	 Catch:{ all -> 0x0035 }
        throw r0;	 Catch:{ all -> 0x0035 }
    L_0x003a:
        r0 = move-exception;
        r2.c(r3);	 Catch:{ all -> 0x003a }
        throw r0;	 Catch:{ all -> 0x003a }
    L_0x003f:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x003a }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.adinterfaces.logging.BoostedComponentLogger.a(com.facebook.inject.InjectorLike):com.facebook.adinterfaces.logging.BoostedComponentLogger");
    }

    private static BoostedComponentLogger m22758b(InjectorLike injectorLike) {
        return new BoostedComponentLogger(AnalyticsLoggerMethodAutoProvider.a(injectorLike), (ObjectMapper) FbObjectMapperMethodAutoProvider.a(injectorLike), AdInterfacesErrorReporter.m22724a(injectorLike), AdInterfacesDataHelper.m22789a(injectorLike));
    }

    @Inject
    public BoostedComponentLogger(AnalyticsLogger analyticsLogger, ObjectMapper objectMapper, AdInterfacesErrorReporter adInterfacesErrorReporter, AdInterfacesDataHelper adInterfacesDataHelper) {
        this.f21682a = analyticsLogger;
        this.f21683b = objectMapper;
        this.f21684c = adInterfacesErrorReporter;
        this.f21685d = adInterfacesDataHelper;
    }

    public final void m22765a(BaseAdInterfacesData baseAdInterfacesData) {
        m22754a(baseAdInterfacesData, "create_dialog_open");
    }

    public final void m22769b(BaseAdInterfacesData baseAdInterfacesData) {
        m22754a(baseAdInterfacesData, "create_dialog_close");
    }

    public final void m22771c(BaseAdInterfacesData baseAdInterfacesData) {
        m22754a(baseAdInterfacesData, "create_dialog_cancel");
        m22769b(baseAdInterfacesData);
    }

    public final void m22773d(BaseAdInterfacesData baseAdInterfacesData) {
        m22754a(baseAdInterfacesData, "edit_dialog_open");
    }

    public final void m22775e(BaseAdInterfacesData baseAdInterfacesData) {
        m22754a(baseAdInterfacesData, "edit_dialog_close");
    }

    public final void m22776f(BaseAdInterfacesData baseAdInterfacesData) {
        m22754a(baseAdInterfacesData, "edit_dialog_cancel");
        m22775e(baseAdInterfacesData);
    }

    public final void m22777g(BaseAdInterfacesData baseAdInterfacesData) {
        m22754a(baseAdInterfacesData, "open_payments_flow");
    }

    public final void m22778h(BaseAdInterfacesData baseAdInterfacesData) {
        m22754a(baseAdInterfacesData, "payment_method_added");
    }

    public final void m22779i(BaseAdInterfacesData baseAdInterfacesData) {
        m22754a(baseAdInterfacesData, "payments_flow_closed");
    }

    public final void m22780j(BaseAdInterfacesData baseAdInterfacesData) {
        m22754a(baseAdInterfacesData, "payments_flow_cancel");
    }

    public final void m22781k(BaseAdInterfacesData baseAdInterfacesData) {
        m22754a(baseAdInterfacesData, "client_create_click");
    }

    public final void m22782l(BaseAdInterfacesData baseAdInterfacesData) {
        m22754a(baseAdInterfacesData, "client_create_success");
    }

    public final void m22783m(BaseAdInterfacesData baseAdInterfacesData) {
        m22754a(baseAdInterfacesData, "post_insights_dialog_open");
    }

    public final void m22784n(BaseAdInterfacesData baseAdInterfacesData) {
        m22754a(baseAdInterfacesData, "post_insights_dialog_close");
    }

    public final void m22785o(BaseAdInterfacesData baseAdInterfacesData) {
        m22754a(baseAdInterfacesData, "insights_dialog_open_click");
    }

    public final void m22786p(BaseAdInterfacesData baseAdInterfacesData) {
        m22754a(baseAdInterfacesData, "update_budget");
    }

    public final void m22787q(BaseAdInterfacesData baseAdInterfacesData) {
        m22754a(baseAdInterfacesData, "input_custom_budget");
    }

    public final void m22767a(BaseAdInterfacesData baseAdInterfacesData, Throwable th) {
        m22755a(baseAdInterfacesData, "client_create_fail", null, null, th);
    }

    public final void m22768a(String str) {
        m22755a(this.f21687f, "enter_flow", "walkthrough", str, null);
    }

    public final void m22770b(String str) {
        m22755a(this.f21687f, "exit_flow", "walkthrough", str, null);
    }

    public final void m22772c(String str) {
        m22755a(this.f21687f, "cancel_flow", "walkthrough", str, null);
    }

    public final void m22774d(String str) {
        m22755a(this.f21687f, "submit_flow_click", "walkthrough", str, null);
    }

    public final void m22766a(BaseAdInterfacesData baseAdInterfacesData, String str, String str2) {
        try {
            if (m22759s(baseAdInterfacesData)) {
                HoneyClientEventFast a = this.f21682a.a("render_warning_message", true);
                if (a.a()) {
                    m22756a(a, baseAdInterfacesData, null);
                    a.a("error_description", str);
                    a.a("error_type", str2);
                    String str3 = "edit";
                    if (baseAdInterfacesData.m22845a() == AdInterfacesStatus.INACTIVE || baseAdInterfacesData.m22845a() == AdInterfacesStatus.NEVER_BOOSTED) {
                        str3 = "create";
                    }
                    a.a("flow", str3);
                    a.b();
                }
            }
        } catch (Throwable th) {
            this.f21684c.m22727a(getClass(), "Failed to log event render_warning_message : " + str, th);
        }
    }

    private void m22755a(BaseAdInterfacesData baseAdInterfacesData, String str, String str2, String str3, Throwable th) {
        try {
            if (m22759s(baseAdInterfacesData)) {
                HoneyClientEventFast a = this.f21682a.a(str, true);
                if (a.a()) {
                    m22756a(a, baseAdInterfacesData, th);
                    if (str2 != null) {
                        a.a("flow", str2);
                    }
                    if (str3 != null) {
                        a.a("flow_option", str3);
                    }
                    a.b();
                }
            }
        } catch (Throwable th2) {
            this.f21684c.m22727a(getClass(), "Failed to log event " + str, th2);
        }
    }

    private static int m22763w(BaseAdInterfacesData baseAdInterfacesData) {
        return baseAdInterfacesData.f21752h != null ? baseAdInterfacesData.f21752h.m23471j() : -1;
    }

    private static int m22764x(BaseAdInterfacesData baseAdInterfacesData) {
        return baseAdInterfacesData.f21752h != null ? baseAdInterfacesData.f21752h.m23467a() : -1;
    }

    private void m22754a(BaseAdInterfacesData baseAdInterfacesData, String str) {
        m22755a(baseAdInterfacesData, str, null, null, null);
    }

    private void m22756a(HoneyClientEventFast honeyClientEventFast, BaseAdInterfacesData baseAdInterfacesData, Throwable th) {
        honeyClientEventFast.a(baseAdInterfacesData.m22856l());
        if (baseAdInterfacesData instanceof AdInterfacesBoostPostDataModel) {
            honeyClientEventFast.a("post_id", ((AdInterfacesBoostPostDataModel) baseAdInterfacesData).m22881z());
        }
        try {
            if (baseAdInterfacesData.mo958u() != null) {
                honeyClientEventFast.a("creative_spec", this.f21683b.a(baseAdInterfacesData.mo958u()));
            }
        } catch (JsonProcessingException e) {
            this.f21684c.m22727a(getClass(), "failed processing creative spec for logging", e);
        }
        if (baseAdInterfacesData.m22854j() != null) {
            honeyClientEventFast.a("targeting_spec", baseAdInterfacesData.m22854j().m22843j());
            GraphQLBoostedPostAudienceOption h = baseAdInterfacesData.m22854j().m22841h();
            honeyClientEventFast.a("audience_id", h != null ? h.name() : GraphQLBoostedPostAudienceOption.NCPP.name());
        }
        honeyClientEventFast.a("currency", m22760t(baseAdInterfacesData));
        honeyClientEventFast.a("budget", BudgetHelper.m25098a(baseAdInterfacesData.m22851g()).longValue());
        honeyClientEventFast.a("placement", baseAdInterfacesData.m22855k());
        honeyClientEventFast.a("flow_id", this.f21686e);
        honeyClientEventFast.a("ad_account_id", baseAdInterfacesData.m22853i());
        honeyClientEventFast.a("page_id", baseAdInterfacesData.m22849c());
        honeyClientEventFast.a("duration", m22761u(baseAdInterfacesData));
        honeyClientEventFast.a("start_time", this.f21685d.m22821a());
        honeyClientEventFast.a("end_time", this.f21685d.m22826c(baseAdInterfacesData.m22852h()));
        honeyClientEventFast.a("budget_type", m22762v(baseAdInterfacesData));
        honeyClientEventFast.a("upper_estimate", m22763w(baseAdInterfacesData));
        honeyClientEventFast.a("lower_estimate", m22764x(baseAdInterfacesData));
        m22757a(honeyClientEventFast, th);
    }

    private static int m22761u(BaseAdInterfacesData baseAdInterfacesData) {
        return baseAdInterfacesData.f21753i == 0 ? -1 : baseAdInterfacesData.f21753i;
    }

    private static void m22757a(HoneyClientEventFast honeyClientEventFast, Throwable th) {
        if (th != null) {
            if (th instanceof ServiceException) {
                ServiceException serviceException = (ServiceException) th;
                if (!(serviceException.result == null || serviceException.result.d == null)) {
                    honeyClientEventFast.a("error_description", serviceException.result.d.getString("originalExceptionMessage"));
                    honeyClientEventFast.a("error_type", serviceException.errorCode);
                    return;
                }
            }
            if (th instanceof GraphQLException) {
                GraphQLException graphQLException = (GraphQLException) th;
                if (graphQLException.error != null) {
                    honeyClientEventFast.a("error_code", graphQLException.error.code);
                    honeyClientEventFast.a("error_description", graphQLException.error.description);
                    return;
                }
            }
            honeyClientEventFast.a("error_description", th.getMessage());
        }
    }

    private static boolean m22759s(BaseAdInterfacesData baseAdInterfacesData) {
        return baseAdInterfacesData.mo962b().getComponentAppEnum() != null;
    }

    private String m22760t(BaseAdInterfacesData baseAdInterfacesData) {
        if (AdInterfacesDataHelper.m22814j(baseAdInterfacesData)) {
            if (baseAdInterfacesData instanceof AdInterfacesBoostPostDataModel) {
                StoryPromotionModel w = ((AdInterfacesBoostPostDataModel) baseAdInterfacesData).m22880w();
                if (w.m23713l().m23668k() != null) {
                    return w.m23713l().m23668k().m23419a();
                }
            }
            if (baseAdInterfacesData instanceof AdInterfacesBoostedComponentDataModel) {
                BoostedComponentModel z = ((AdInterfacesBoostedComponentDataModel) baseAdInterfacesData).m22891z();
                if (!(z == null || z.m23345l() == null)) {
                    return z.m23345l().m23419a();
                }
            }
        }
        try {
            return AdInterfacesDataHelper.m22811g(baseAdInterfacesData) ? AdInterfacesDataHelper.m22805d(baseAdInterfacesData) : null;
        } catch (Throwable e) {
            this.f21684c.m22727a(getClass(), "failed getting currency for logging", e);
            return null;
        }
    }

    private static String m22762v(BaseAdInterfacesData baseAdInterfacesData) {
        if (baseAdInterfacesData instanceof AdInterfacesBoostPostDataModel) {
            return "lifetime";
        }
        if (baseAdInterfacesData instanceof AdInterfacesBoostedComponentDataModel) {
            AdInterfacesBoostedComponentDataModel adInterfacesBoostedComponentDataModel = (AdInterfacesBoostedComponentDataModel) baseAdInterfacesData;
            if (adInterfacesBoostedComponentDataModel.f21797b.m23346m() == GraphQLBoostedComponentBudgetType.DAILY_BUDGET) {
                return "daily";
            }
            if (adInterfacesBoostedComponentDataModel.f21797b.m23346m() == GraphQLBoostedComponentBudgetType.LIFETIME_BUDGET) {
                return "lifetime";
            }
        }
        return null;
    }
}
