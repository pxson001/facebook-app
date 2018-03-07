package com.facebook.deeplinking.activity;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import com.facebook.base.activity.FbFragmentActivity;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.errorreporting.SoftError;
import com.facebook.common.errorreporting.SoftErrorBuilder;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.deeplinking.DeepLinkingUtils;
import com.facebook.deeplinking.graphql.DeepLinkingGraphQlQueryFragments.GetURLInfoString;
import com.facebook.deeplinking.graphql.DeepLinkingGraphQlQueryFragmentsModels.GetURLInfoModel;
import com.facebook.deeplinking.logging.DeepLinkLoggingUtils;
import com.facebook.fbservice.ops.ResultFutureCallback;
import com.facebook.fbservice.service.ServiceException;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.ui.futures.TasksManager;
import com.facebook.ui.toaster.ToastThreadUtil;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: photo_status_thread_view */
public abstract class BaseDeepLinkLoadingActivity extends FbFragmentActivity {
    public static final String f6603w = BaseDeepLinkLoadingActivity.class.getSimpleName();
    @Inject
    GraphQLQueryExecutor f6604p;
    @Inject
    TasksManager f6605q;
    @Inject
    SecureContextHelper f6606r;
    @Inject
    AbstractFbErrorReporter f6607s;
    @Inject
    DeepLinkLoggingUtils f6608t;
    @Inject
    DeepLinkingUtils f6609u;
    @Inject
    Lazy<ToastThreadUtil> f6610v;

    /* compiled from: photo_status_thread_view */
    class C06831 extends ResultFutureCallback<GraphQLResult<GetURLInfoModel>> {
        final /* synthetic */ BaseDeepLinkLoadingActivity f6602a;

        C06831(BaseDeepLinkLoadingActivity baseDeepLinkLoadingActivity) {
            this.f6602a = baseDeepLinkLoadingActivity;
        }

        protected final void m6912a(Object obj) {
            this.f6602a.mo268a(this.f6602a.getIntent().getData(), (GraphQLResult) obj);
            this.f6602a.finish();
        }

        protected final void m6911a(ServiceException serviceException) {
            this.f6602a.m6916a(this.f6602a.getIntent().getData());
            AbstractFbErrorReporter abstractFbErrorReporter = this.f6602a.f6607s;
            SoftErrorBuilder a = SoftError.a(BaseDeepLinkLoadingActivity.f6603w + "_onActivityCreate", "Error retrieving URL info");
            a.c = serviceException;
            abstractFbErrorReporter.a(a.g());
            this.f6602a.finish();
        }

        protected final void m6913b(Throwable th) {
            super.b(th);
            this.f6602a.m6916a(this.f6602a.getIntent().getData());
            AbstractFbErrorReporter abstractFbErrorReporter = this.f6602a.f6607s;
            SoftErrorBuilder a = SoftError.a(BaseDeepLinkLoadingActivity.f6603w + "_onActivityCreate", "Error retrieving URL info");
            a.c = th;
            abstractFbErrorReporter.a(a.g());
            this.f6602a.finish();
        }
    }

    public static void m6915a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        ((BaseDeepLinkLoadingActivity) obj).m6914a(GraphQLQueryExecutor.a(injectorLike), TasksManager.b(injectorLike), (SecureContextHelper) DefaultSecureContextHelper.a(injectorLike), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike), DeepLinkLoggingUtils.m6945b(injectorLike), DeepLinkingUtils.m6909b(injectorLike), IdBasedLazy.a(injectorLike, 11511));
    }

    protected abstract void mo268a(@Nullable Uri uri, @Nullable GraphQLResult<GetURLInfoModel> graphQLResult);

    private void m6914a(GraphQLQueryExecutor graphQLQueryExecutor, TasksManager tasksManager, SecureContextHelper secureContextHelper, FbErrorReporter fbErrorReporter, DeepLinkLoggingUtils deepLinkLoggingUtils, DeepLinkingUtils deepLinkingUtils, Lazy<ToastThreadUtil> lazy) {
        this.f6604p = graphQLQueryExecutor;
        this.f6605q = tasksManager;
        this.f6606r = secureContextHelper;
        this.f6607s = fbErrorReporter;
        this.f6608t = deepLinkLoggingUtils;
        this.f6609u = deepLinkingUtils;
        this.f6610v = lazy;
    }

    protected final void m6918b(Bundle bundle) {
        super.b(bundle);
        Class cls = BaseDeepLinkLoadingActivity.class;
        m6915a((Object) this, (Context) this);
        setContentView(2130903869);
        this.f6605q.a("DeepLinkUrlRequest", this.f6604p.a(GraphQLRequest.a((GetURLInfoString) new GetURLInfoString().a("url", getIntent().getDataString()))), new C06831(this));
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    protected final void m6916a(android.net.Uri r11) {
        /*
        r10 = this;
        if (r11 == 0) goto L_0x0090;
    L_0x0002:
        r0 = r11.buildUpon();
        r1 = "force_faceweb";
        r2 = 1;
        r2 = java.lang.Boolean.toString(r2);
        r0 = r0.appendQueryParameter(r1, r2);
        r0 = r0.build();
    L_0x0015:
        r1 = r10.f6608t;
        r2 = r10.getIntent();
        r3 = r0.toString();
        r4 = r1.f6630a;
        r5 = "unsuccessful_deeplink";
        r6 = 1;
        r4 = r4.a(r5, r6);
        r5 = r4.a();
        if (r5 == 0) goto L_0x007d;
    L_0x002e:
        if (r2 == 0) goto L_0x0098;
    L_0x0030:
        r7 = com.google.common.collect.Maps.c();
        r8 = r2.getDataString();
        if (r8 == 0) goto L_0x0058;
    L_0x003a:
        r8 = "incoming_uri";
        r9 = r2.getDataString();
        r7.put(r8, r9);
        r8 = r2.getData();
        r9 = "ref";
        r8 = r8.getQueryParameter(r9);
        r9 = com.facebook.common.util.StringUtil.a(r8);
        if (r9 != 0) goto L_0x0058;
    L_0x0053:
        r9 = "referral";
        r7.put(r9, r8);
    L_0x0058:
        r8 = r2.getComponent();
        if (r8 == 0) goto L_0x006b;
    L_0x005e:
        r8 = r2.getComponent();
        r9 = "source_component";
        r8 = r8.toString();
        r7.put(r9, r8);
    L_0x006b:
        r8 = r7.isEmpty();
        if (r8 != 0) goto L_0x0098;
    L_0x0071:
        r5 = r7;
        r4.a(r5);
        r5 = "fallback_uri";
        r4.a(r5, r3);
        r4.b();
    L_0x007d:
        r1 = new android.content.Intent;
        r2 = "android.intent.action.VIEW";
        r1.<init>(r2);
        r1.setData(r0);
        r0 = r10.f6606r;
        r0.a(r1, r10);
        r10.finish();
        return;
    L_0x0090:
        r0 = com.facebook.common.fblinks.FBLinks.bT;
        r0 = android.net.Uri.parse(r0);
        goto L_0x0015;
    L_0x0098:
        r7 = 0;
        goto L_0x0071;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.deeplinking.activity.BaseDeepLinkLoadingActivity.a(android.net.Uri):void");
    }
}
