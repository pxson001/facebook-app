package com.facebook.privacy.checkup.manager;

import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.auth.userscope.UserScoped;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.fbservice.ops.OperationResultFutureCallback;
import com.facebook.fbservice.service.ServiceException;
import com.facebook.graphql.enums.GraphQLEditablePrivacyScopeType;
import com.facebook.inject.InjectorLike;
import com.facebook.privacy.PrivacyOperationsClient;
import com.facebook.privacy.checkup.abtest.PrivacyCheckupMobileXConfig;
import com.facebook.privacy.checkup.service.PrivacyCheckupAnalyticsLogger;
import com.facebook.privacy.checkup.service.PrivacyCheckupAnalyticsLogger.Event;
import com.facebook.privacy.protocol.ReportPrivacyCheckupActionsParams.PrivacyCheckupAction;
import com.facebook.privacy.protocol.ReportPrivacyCheckupActionsParams.PrivacyCheckupEvent;
import com.facebook.privacy.protocol.ReportPrivacyCheckupActionsParams.PrivacyCheckupItem;
import com.facebook.privacy.protocol.ReportPrivacyCheckupActionsParams.PrivacyCheckupItem.Builder;
import com.facebook.privacy.protocol.options.PrivacyOptionsGraphQLInterfaces.PrivacyOptionFields;
import com.facebook.privacy.protocol.options.PrivacyOptionsGraphQLInterfaces.PrivacyOptionFieldsWithExplanation;
import com.facebook.ui.futures.TasksManager;
import com.facebook.xconfig.core.XConfigReader;
import com.google.common.collect.ImmutableList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import javax.inject.Inject;

@UserScoped
/* compiled from: SuperCategoryType */
public class PrivacyCheckupRequestDispatcher {
    private static final Object f10908w = new Object();
    public boolean f10909a = false;
    public int f10910b;
    public int f10911c;
    public long f10912d;
    public int f10913e;
    public int f10914f;
    private int f10915g;
    private int f10916h;
    public Map<String, PrivacyCheckupItem> f10917i;
    public Map<String, PrivacyCheckupItem> f10918j;
    public Map<String, Integer> f10919k;
    private Set<PrivacyCheckupItem> f10920l;
    private Clock f10921m;
    public AbstractFbErrorReporter f10922n;
    private TasksManager f10923o;
    public PrivacyCheckupAnalyticsLogger f10924p;
    private PrivacyOperationsClient f10925q;
    public XConfigReader f10926r;
    public String f10927s;
    public long f10928t;
    private final OperationResultFutureCallback f10929u = new C12961(this);
    private final OperationResultFutureCallback f10930v = new C12972(this);

    /* compiled from: SuperCategoryType */
    class C12961 extends OperationResultFutureCallback {
        final /* synthetic */ PrivacyCheckupRequestDispatcher f10906a;

        C12961(PrivacyCheckupRequestDispatcher privacyCheckupRequestDispatcher) {
            this.f10906a = privacyCheckupRequestDispatcher;
        }

        protected final void m11347a(Object obj) {
            if (!this.f10906a.f10918j.isEmpty()) {
                this.f10906a.f10924p.m11465a(Event.PRIVACY_CHECKUP_WRITE_REQUEST_SUCCESS, Integer.valueOf(this.f10906a.f10918j.size()), Long.valueOf(PrivacyCheckupRequestDispatcher.m11355c(this.f10906a).longValue() - this.f10906a.f10912d));
            }
            this.f10906a.f10918j.clear();
            if (this.f10906a.f10909a && !this.f10906a.f10917i.isEmpty()) {
                this.f10906a.f10909a = false;
                this.f10906a.m11362a(false);
            }
        }

        protected final void m11346a(ServiceException serviceException) {
            long longValue = PrivacyCheckupRequestDispatcher.m11355c(this.f10906a).longValue() - this.f10906a.f10912d;
            if (!this.f10906a.f10918j.isEmpty()) {
                this.f10906a.f10924p.m11465a(Event.PRIVACY_CHECKUP_WRITE_REQUEST_FAILURE, Integer.valueOf(this.f10906a.f10918j.size()), Long.valueOf(longValue));
            }
            HashMap hashMap = new HashMap();
            for (Entry entry : this.f10906a.f10918j.entrySet()) {
                String str = (String) entry.getKey();
                PrivacyCheckupItem privacyCheckupItem = (PrivacyCheckupItem) entry.getValue();
                if (!this.f10906a.f10919k.containsKey(str) || ((Integer) this.f10906a.f10919k.get(str)).intValue() < this.f10906a.f10911c) {
                    Integer num = (Integer) this.f10906a.f10919k.get(str);
                    this.f10906a.f10919k.put(str, Integer.valueOf(num == null ? 1 : num.intValue() + 1));
                    if (this.f10906a.f10917i.containsKey(str)) {
                        Object obj;
                        if (privacyCheckupItem.d == null || privacyCheckupItem.e == null) {
                            obj = null;
                        } else {
                            obj = 1;
                        }
                        PrivacyCheckupRequestDispatcher privacyCheckupRequestDispatcher;
                        if (obj != null) {
                            privacyCheckupRequestDispatcher = this.f10906a;
                            privacyCheckupRequestDispatcher.f10914f--;
                        } else {
                            privacyCheckupRequestDispatcher = this.f10906a;
                            privacyCheckupRequestDispatcher.f10913e--;
                        }
                        if (this.f10906a.f10919k.containsKey(str)) {
                            this.f10906a.f10919k.remove(str);
                        }
                    } else {
                        this.f10906a.f10917i.put(str, privacyCheckupItem);
                    }
                } else {
                    hashMap.put(str, privacyCheckupItem);
                }
            }
            this.f10906a.f10918j.clear();
            if (!hashMap.isEmpty()) {
                this.f10906a.f10924p.m11465a(Event.PRIVACY_CHECKUP_WRITE_REQUEST_DROPPED, Integer.valueOf(hashMap.size()), Long.valueOf(longValue));
                AbstractFbErrorReporter abstractFbErrorReporter = this.f10906a.f10922n;
                str = "privacy_checkup_mobile_write_retry_fail";
                Map map = this.f10906a.f10917i;
                StringBuilder stringBuilder = new StringBuilder(1024);
                for (Entry value : map.entrySet()) {
                    stringBuilder.append(((PrivacyCheckupItem) value.getValue()).a());
                    stringBuilder.append("|");
                }
                abstractFbErrorReporter.b(str, stringBuilder.toString(), serviceException);
            }
            this.f10906a.f10909a = false;
            this.f10906a.m11362a(true);
        }
    }

    /* compiled from: SuperCategoryType */
    class C12972 extends OperationResultFutureCallback {
        final /* synthetic */ PrivacyCheckupRequestDispatcher f10907a;

        C12972(PrivacyCheckupRequestDispatcher privacyCheckupRequestDispatcher) {
            this.f10907a = privacyCheckupRequestDispatcher;
        }

        protected final void m11348a(ServiceException serviceException) {
            this.f10907a.f10924p.m11462a(Event.PRIVACY_CHECKUP_WRITE_REQUEST_FLUSH_FAILURE);
        }

        protected final void m11349a(Object obj) {
            this.f10907a.f10924p.m11462a(Event.PRIVACY_CHECKUP_WRITE_REQUEST_FLUSH_SUCCESS);
        }
    }

    /* compiled from: SuperCategoryType */
    enum Task {
        SEND_REQUESTS,
        FINAL_FLUSH_REQUESTS
    }

    private static PrivacyCheckupRequestDispatcher m11353b(InjectorLike injectorLike) {
        return new PrivacyCheckupRequestDispatcher((Clock) SystemClockMethodAutoProvider.a(injectorLike), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike), TasksManager.b(injectorLike), PrivacyCheckupAnalyticsLogger.m11461b(injectorLike), PrivacyOperationsClient.a(injectorLike), XConfigReader.a(injectorLike));
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.facebook.privacy.checkup.manager.PrivacyCheckupRequestDispatcher m11350a(com.facebook.inject.InjectorLike r7) {
        /*
        r2 = com.facebook.inject.ScopeSet.a();
        r0 = com.facebook.auth.userscope.UserScope.class;
        r0 = r7.getInstance(r0);
        r0 = (com.facebook.auth.userscope.UserScope) r0;
        r1 = r7.getScopeAwareInjector();
        r1 = r1.b();
        if (r1 != 0) goto L_0x001e;
    L_0x0016:
        r0 = new com.facebook.inject.ProvisioningException;
        r1 = "Called user scoped provider outside of context scope";
        r0.<init>(r1);
        throw r0;
    L_0x001e:
        r3 = r0.a(r1);
        r4 = r3.b();	 Catch:{ all -> 0x006c }
        r1 = f10908w;	 Catch:{ all -> 0x006c }
        r1 = r4.get(r1);	 Catch:{ all -> 0x006c }
        r5 = com.facebook.auth.userscope.UserScope.a;	 Catch:{ all -> 0x006c }
        if (r1 != r5) goto L_0x0035;
    L_0x0030:
        r3.c();
        r0 = 0;
    L_0x0034:
        return r0;
    L_0x0035:
        if (r1 != 0) goto L_0x007c;
    L_0x0037:
        r1 = 4;
        r5 = r2.b(r1);	 Catch:{  }
        r6 = r0.a(r3);	 Catch:{ all -> 0x0067 }
        r0 = r6.e();	 Catch:{ all -> 0x0062 }
        r1 = m11353b(r0);	 Catch:{ all -> 0x0062 }
        com.facebook.auth.userscope.UserScope.a(r6);	 Catch:{  }
        if (r1 != 0) goto L_0x0071;
    L_0x004d:
        r0 = f10908w;	 Catch:{  }
        r6 = com.facebook.auth.userscope.UserScope.a;	 Catch:{  }
        r0 = r4.putIfAbsent(r0, r6);	 Catch:{  }
        r0 = (com.facebook.privacy.checkup.manager.PrivacyCheckupRequestDispatcher) r0;	 Catch:{  }
    L_0x0057:
        if (r0 == 0) goto L_0x007a;
    L_0x0059:
        r2.c(r5);	 Catch:{  }
    L_0x005c:
        r0 = (com.facebook.privacy.checkup.manager.PrivacyCheckupRequestDispatcher) r0;	 Catch:{  }
        r3.c();
        goto L_0x0034;
    L_0x0062:
        r0 = move-exception;
        com.facebook.auth.userscope.UserScope.a(r6);	 Catch:{  }
        throw r0;	 Catch:{  }
    L_0x0067:
        r0 = move-exception;
        r2.c(r5);	 Catch:{  }
        throw r0;	 Catch:{  }
    L_0x006c:
        r0 = move-exception;
        r3.c();
        throw r0;
    L_0x0071:
        r0 = f10908w;	 Catch:{  }
        r0 = r4.putIfAbsent(r0, r1);	 Catch:{  }
        r0 = (com.facebook.privacy.checkup.manager.PrivacyCheckupRequestDispatcher) r0;	 Catch:{  }
        goto L_0x0057;
    L_0x007a:
        r0 = r1;
        goto L_0x0059;
    L_0x007c:
        r0 = r1;
        goto L_0x005c;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.privacy.checkup.manager.PrivacyCheckupRequestDispatcher.a(com.facebook.inject.InjectorLike):com.facebook.privacy.checkup.manager.PrivacyCheckupRequestDispatcher");
    }

    @Inject
    public PrivacyCheckupRequestDispatcher(Clock clock, AbstractFbErrorReporter abstractFbErrorReporter, TasksManager tasksManager, PrivacyCheckupAnalyticsLogger privacyCheckupAnalyticsLogger, PrivacyOperationsClient privacyOperationsClient, XConfigReader xConfigReader) {
        this.f10921m = clock;
        this.f10922n = abstractFbErrorReporter;
        this.f10923o = tasksManager;
        this.f10924p = privacyCheckupAnalyticsLogger;
        this.f10925q = privacyOperationsClient;
        this.f10926r = xConfigReader;
        this.f10917i = new HashMap();
        this.f10918j = new HashMap();
        this.f10920l = new HashSet();
        this.f10919k = new HashMap();
        this.f10913e = 0;
        this.f10914f = 0;
        this.f10915g = 0;
        this.f10916h = 0;
        this.f10911c = this.f10926r.a(PrivacyCheckupMobileXConfig.d, 3);
        this.f10910b = this.f10926r.a(PrivacyCheckupMobileXConfig.c, 5);
    }

    public final void m11360a(String str, GraphQLEditablePrivacyScopeType graphQLEditablePrivacyScopeType, PrivacyOptionFieldsWithExplanation privacyOptionFieldsWithExplanation) {
        this.f10924p.m11467a(str, "change_privacy", (PrivacyOptionFields) privacyOptionFieldsWithExplanation);
        Builder builder = new Builder();
        builder.a = PrivacyCheckupEvent.MUTATION;
        builder = builder;
        builder.b = m11355c(this);
        builder = builder;
        builder.c = str;
        builder = builder;
        builder.d = graphQLEditablePrivacyScopeType;
        builder = builder;
        builder.e = PrivacyCheckupAction.CHANGE_PRIVACY;
        builder = builder;
        builder.f = privacyOptionFieldsWithExplanation.c();
        m11352a(str, builder.a());
    }

    public final void m11361a(String str, boolean z) {
        this.f10924p.m11467a(str, z ? "delete_app_and_posts" : "delete_app_only", null);
        PrivacyCheckupAction privacyCheckupAction = z ? PrivacyCheckupAction.DELETE_APP_AND_POSTS : PrivacyCheckupAction.DELETE_APP_ONLY;
        Builder builder = new Builder();
        builder.a = PrivacyCheckupEvent.MUTATION;
        builder = builder;
        builder.b = m11355c(this);
        builder = builder;
        builder.c = str;
        builder = builder;
        builder.d = GraphQLEditablePrivacyScopeType.POP_PER_APP;
        builder = builder;
        builder.e = privacyCheckupAction;
        m11352a(str, builder.a());
    }

    public final void m11359a(PrivacyCheckupEvent privacyCheckupEvent, String str) {
        this.f10913e++;
        Builder builder = new Builder();
        builder.a = privacyCheckupEvent;
        builder = builder;
        builder.b = m11355c(this);
        builder = builder;
        builder.g = str;
        this.f10920l.add(builder.a());
    }

    public final void m11362a(boolean z) {
        if (!m11356d()) {
            return;
        }
        if (this.f10918j.isEmpty()) {
            this.f10918j.putAll(this.f10917i);
            this.f10917i.clear();
            this.f10912d = m11355c(this).longValue();
            if (!this.f10918j.isEmpty()) {
                this.f10924p.m11465a(Event.PRIVACY_CHECKUP_WRITE_REQUEST_SENT, Integer.valueOf(this.f10918j.size()), null);
            }
            if (!z && m11356d()) {
                this.f10915g++;
            }
            this.f10923o.a(Task.SEND_REQUESTS, this.f10925q.a(m11351a(this.f10918j, this.f10920l), this.f10927s, this.f10928t), this.f10929u);
            this.f10920l.clear();
            return;
        }
        this.f10909a = true;
    }

    public final void m11357a() {
        if (!m11356d()) {
            m11354b(Event.PRIVACY_CHECKUP_WRITE_REQUEST_ON_EXIT);
        } else if (this.f10918j.isEmpty()) {
            m11362a(false);
            m11354b(Event.PRIVACY_CHECKUP_WRITE_REQUEST_ON_EXIT);
        } else {
            m11358a(Event.PRIVACY_CHECKUP_WRITE_REQUEST_FLUSH);
            Map hashMap = new HashMap();
            hashMap.putAll(this.f10918j);
            hashMap.putAll(this.f10917i);
            this.f10915g++;
            this.f10916h = this.f10918j.size();
            m11354b(Event.PRIVACY_CHECKUP_WRITE_REQUEST_ON_EXIT);
            this.f10923o.a(Task.FINAL_FLUSH_REQUESTS, this.f10925q.a(m11351a(hashMap, this.f10920l), this.f10927s, this.f10928t), this.f10930v);
            this.f10917i.clear();
            this.f10918j.clear();
            this.f10920l.clear();
        }
    }

    public final void m11358a(Event event) {
        PrivacyCheckupAnalyticsLogger privacyCheckupAnalyticsLogger = this.f10924p;
        int size = this.f10917i.size();
        int size2 = this.f10918j.size();
        int size3 = this.f10920l.size();
        HoneyClientEvent a = PrivacyCheckupAnalyticsLogger.m11460a(event.eventName);
        a.a("num_waiting_items", size);
        a.a("num_inflight_items", size2);
        a.a("num_logging_items", size3);
        privacyCheckupAnalyticsLogger.f11080a.a(a);
    }

    private void m11354b(Event event) {
        this.f10924p.m11464a(event, this.f10928t, this.f10917i.size(), this.f10918j.size(), this.f10920l.size(), this.f10913e, this.f10914f, this.f10915g, this.f10916h);
    }

    public final void m11363b() {
        this.f10913e = 0;
        this.f10914f = 0;
        this.f10915g = 0;
        this.f10916h = 0;
    }

    private void m11352a(String str, PrivacyCheckupItem privacyCheckupItem) {
        this.f10914f++;
        this.f10917i.put(str, privacyCheckupItem);
        if (this.f10917i.size() >= this.f10910b) {
            m11362a(false);
        }
    }

    private static ImmutableList<PrivacyCheckupItem> m11351a(Map<String, PrivacyCheckupItem> map, Set<PrivacyCheckupItem> set) {
        ImmutableList.Builder builder = new ImmutableList.Builder();
        for (Entry value : map.entrySet()) {
            builder.c(value.getValue());
        }
        for (PrivacyCheckupItem c : set) {
            builder.c(c);
        }
        return builder.b();
    }

    public static Long m11355c(PrivacyCheckupRequestDispatcher privacyCheckupRequestDispatcher) {
        return Long.valueOf(privacyCheckupRequestDispatcher.f10921m.a() / 1000);
    }

    private boolean m11356d() {
        return (this.f10917i.isEmpty() && this.f10920l.isEmpty()) ? false : true;
    }
}
