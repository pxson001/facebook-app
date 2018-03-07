package com.facebook.composer.privacy.common;

import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.composer.privacy.common.ComposerPrivacyData.Builder;
import com.facebook.composer.privacy.common.ComposerPrivacyDelegate.PrivacyUpdatedHandler;
import com.facebook.fbservice.ops.ResultFutureCallback;
import com.facebook.fbservice.service.DataFreshnessParam;
import com.facebook.fbservice.service.ErrorCode;
import com.facebook.fbservice.service.ServiceException;
import com.facebook.graphql.model.GraphQLPrivacyOption;
import com.facebook.inject.Lazy;
import com.facebook.privacy.PrivacyOperationsClient;
import com.facebook.privacy.model.PrivacyOptionsResult;
import com.facebook.privacy.model.SelectablePrivacyData;
import com.facebook.privacy.service.PrivacyAnalyticsLogger;
import com.facebook.privacy.service.PrivacyAnalyticsLogger.Events;
import com.facebook.ui.futures.TasksManager;
import com.google.common.base.Preconditions;
import java.lang.ref.WeakReference;

/* compiled from: tapped_save_media_page */
public abstract class ComposerSelectablePrivacyDelegateBase extends ComposerPrivacyDelegate {
    public final PrivacyOperationsClient f2006a;
    public final WeakReference<AnalyticsCallback> f2007b;
    public final Lazy<PrivacyAnalyticsLogger> f2008c;
    public boolean f2009d = false;
    public int f2010e = 0;
    private GraphQLPrivacyOption f2011f;
    private boolean f2012g = true;
    public WeakReference<DataProvider> f2013h;

    /* compiled from: tapped_save_media_page */
    public interface AnalyticsCallback {
        void mo486a();
    }

    /* compiled from: tapped_save_media_page */
    public interface DataProvider {
        boolean mo483a();

        boolean mo484b();

        boolean mo485c();
    }

    protected abstract SelectablePrivacyData mo93a(ComposerPrivacyData composerPrivacyData, PrivacyOptionsResult privacyOptionsResult);

    public static void m1949b(ComposerSelectablePrivacyDelegateBase composerSelectablePrivacyDelegateBase, final ComposerPrivacyData composerPrivacyData) {
        composerSelectablePrivacyDelegateBase.f1956c.a("prefetch_privacy_options", composerSelectablePrivacyDelegateBase.f2006a.a(DataFreshnessParam.CHECK_SERVER_FOR_NEW_DATA), new ResultFutureCallback<PrivacyOptionsResult>(composerSelectablePrivacyDelegateBase) {
            final /* synthetic */ ComposerSelectablePrivacyDelegateBase f2018b;

            protected final void m1958a(ServiceException serviceException) {
                if (serviceException.errorCode == ErrorCode.API_ERROR) {
                    this.f2018b.f1955b.a("composer_privacy_fetch_error", "Privacy options fetch failure", serviceException);
                } else if (this.f2018b.f2010e <= 0) {
                    ComposerSelectablePrivacyDelegateBase composerSelectablePrivacyDelegateBase = this.f2018b;
                    composerSelectablePrivacyDelegateBase.f2010e++;
                    ComposerSelectablePrivacyDelegateBase.m1949b(this.f2018b, composerPrivacyData);
                }
            }

            protected final void m1959a(Object obj) {
                PrivacyOptionsResult privacyOptionsResult = (PrivacyOptionsResult) obj;
                this.f2018b.f2010e = 0;
                this.f2018b.f2009d = true;
                DataProvider dataProvider = (DataProvider) this.f2018b.f2013h.get();
                if (dataProvider == null) {
                    return;
                }
                if (dataProvider.mo485c() || !(dataProvider.mo483a() || dataProvider.mo484b())) {
                    ComposerSelectablePrivacyDelegateBase.m1950b(this.f2018b, composerPrivacyData, privacyOptionsResult);
                } else {
                    ((PrivacyAnalyticsLogger) this.f2018b.f2008c.get()).a(Events.PRIVACY_CHANGE_IGNORED_ON_FETCH);
                }
            }
        });
    }

    public ComposerSelectablePrivacyDelegateBase(PrivacyUpdatedHandler privacyUpdatedHandler, AnalyticsCallback analyticsCallback, GraphQLPrivacyOption graphQLPrivacyOption, DataProvider dataProvider, FbErrorReporter fbErrorReporter, TasksManager<String> tasksManager, PrivacyOperationsClient privacyOperationsClient, Lazy<PrivacyAnalyticsLogger> lazy) {
        super(privacyUpdatedHandler, fbErrorReporter, tasksManager);
        this.f2006a = privacyOperationsClient;
        this.f2007b = new WeakReference(analyticsCallback);
        this.f2008c = lazy;
        this.f2011f = graphQLPrivacyOption;
        this.f2013h = new WeakReference(Preconditions.checkNotNull(dataProvider));
    }

    public final void mo91a() {
        super.mo91a();
        Builder builder = new Builder();
        builder.f1994a = true;
        builder = builder;
        builder.f1995b = true;
        builder = builder;
        builder.f1996c = true;
        final ComposerPrivacyData a = builder.m1944a(new SelectablePrivacyData.Builder().b()).m1945a();
        if (!this.f2009d || this.f2012g) {
            m1904a(a);
        }
        final boolean z = !this.f2009d;
        this.f1956c.a("fetch_privacy_options", this.f2006a.a(DataFreshnessParam.STALE_DATA_OKAY), new ResultFutureCallback<PrivacyOptionsResult>(this) {
            final /* synthetic */ ComposerSelectablePrivacyDelegateBase f2016c;

            protected final void m1956a(ServiceException serviceException) {
                if (serviceException.errorCode == ErrorCode.API_ERROR) {
                    this.f2016c.f1955b.a("composer_privacy_fetch_cached_error", "Privacy options fetch failure", serviceException);
                }
                if (z) {
                    ComposerSelectablePrivacyDelegateBase.m1949b(this.f2016c, a);
                }
            }

            protected final void m1957a(Object obj) {
                PrivacyOptionsResult privacyOptionsResult = (PrivacyOptionsResult) obj;
                this.f2016c.f2009d = true;
                ComposerSelectablePrivacyDelegateBase.m1950b(this.f2016c, a, privacyOptionsResult);
                ((AnalyticsCallback) this.f2016c.f2007b.get()).mo486a();
                if (!z) {
                    return;
                }
                if (privacyOptionsResult == null || !privacyOptionsResult.isResultFromServer) {
                    ComposerSelectablePrivacyDelegateBase.m1949b(this.f2016c, a);
                }
            }
        });
    }

    public final void m1953a(GraphQLPrivacyOption graphQLPrivacyOption) {
        this.f2012g = graphQLPrivacyOption != this.f2011f;
        this.f2011f = graphQLPrivacyOption;
    }

    public static void m1950b(ComposerSelectablePrivacyDelegateBase composerSelectablePrivacyDelegateBase, ComposerPrivacyData composerPrivacyData, PrivacyOptionsResult privacyOptionsResult) {
        SelectablePrivacyData a = composerSelectablePrivacyDelegateBase.mo93a(composerPrivacyData, privacyOptionsResult);
        if (composerSelectablePrivacyDelegateBase.f2011f != null) {
            a = PrivacyOperationsClient.a(a, composerSelectablePrivacyDelegateBase.f2011f);
        }
        Builder builder = new Builder(composerPrivacyData);
        builder.f1995b = false;
        builder = builder;
        builder.f1996c = false;
        composerSelectablePrivacyDelegateBase.m1904a(builder.m1944a(a).m1945a());
    }

    public final String mo92b() {
        return this.f2011f == null ? "selectable" : "selectable:" + String.valueOf(this.f2011f.hashCode());
    }
}
