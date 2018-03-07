package com.facebook.securitycheckup;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.ProgressBar;
import com.facebook.base.activity.FbFragmentActivity;
import com.facebook.common.executors.ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider;
import com.facebook.common.fblinks.FBLinks;
import com.facebook.common.util.StringUtil;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.debug.log.BLog;
import com.facebook.fbui.glyph.GlyphButton;
import com.facebook.graphql.calls.SecurityCheckupLoggingInputData.Event;
import com.facebook.graphql.calls.SecurityCheckupLoggingInputData.Source;
import com.facebook.graphql.executor.GraphQLCachePolicy;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.inject.FbInjector;
import com.facebook.inject.InjectorLike;
import com.facebook.securitycheckup.SecurityCheckupScrollingController.ScrollingState;
import com.facebook.securitycheckup.api.SecurityCheckupQuery.SecurityCheckupQueryString;
import com.facebook.securitycheckup.api.SecurityCheckupQueryModels.SecurityCheckupQueryModel;
import com.facebook.securitycheckup.api.SecurityCheckupQueryModels.SecurityCheckupQueryModel.SecurityCheckupModel;
import com.facebook.securitycheckup.items.SecurityCheckupAdapterProvider;
import com.facebook.widget.recyclerview.BetterRecyclerView;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import java.util.concurrent.ExecutorService;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: inbox_recommend_audio */
public class SecurityCheckupMainActivity extends FbFragmentActivity {
    public static final String f9677p = SecurityCheckupMainActivity.class.getSimpleName();
    private ExecutorService f9678q;
    private GraphQLQueryExecutor f9679r;
    private BetterRecyclerView f9680s;
    private GlyphButton f9681t;
    private ProgressBar f9682u;
    public SecurityCheckupScrollingController f9683v;
    private SecurityCheckupScrollingControllerProvider f9684w;
    private SecurityCheckupLogger f9685x;
    private boolean f9686y;
    private SecureContextHelper f9687z;

    /* compiled from: inbox_recommend_audio */
    class C14411 implements FutureCallback<GraphQLResult<SecurityCheckupQueryModel>> {
        final /* synthetic */ SecurityCheckupMainActivity f9675a;

        C14411(SecurityCheckupMainActivity securityCheckupMainActivity) {
            this.f9675a = securityCheckupMainActivity;
        }

        public void onSuccess(@Nullable Object obj) {
            GraphQLResult graphQLResult = (GraphQLResult) obj;
            if (graphQLResult != null) {
                try {
                    SecurityCheckupQueryModel securityCheckupQueryModel = (SecurityCheckupQueryModel) graphQLResult.d();
                    if (securityCheckupQueryModel != null && securityCheckupQueryModel.m9983a() != null) {
                        this.f9675a.m9907a(securityCheckupQueryModel.m9983a());
                    }
                } catch (Exception e) {
                }
            }
        }

        public void onFailure(Throwable th) {
            BLog.b(SecurityCheckupMainActivity.f9677p, "Failure loading security checkup.");
        }
    }

    /* compiled from: inbox_recommend_audio */
    class C14422 implements Runnable {
        final /* synthetic */ SecurityCheckupMainActivity f9676a;

        C14422(SecurityCheckupMainActivity securityCheckupMainActivity) {
            this.f9676a = securityCheckupMainActivity;
        }

        public void run() {
            this.f9676a.f9683v.m9930a();
            SecurityCheckupMainActivity.m9914k(this.f9676a);
        }
    }

    private static <T extends Context> void m9908a(Class<T> cls, T t) {
        m9909a((Object) t, (Context) t);
    }

    private static void m9909a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        ((SecurityCheckupMainActivity) obj).m9910a((ExecutorService) ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider.a(injectorLike), GraphQLQueryExecutor.a(injectorLike), (SecurityCheckupScrollingControllerProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(SecurityCheckupScrollingControllerProvider.class), SecurityCheckupLogger.m9901a(injectorLike), (SecureContextHelper) DefaultSecureContextHelper.a(injectorLike));
    }

    protected final void m9915b(Bundle bundle) {
        super.b(bundle);
        m9908a(SecurityCheckupMainActivity.class, (Context) this);
        setContentView(2130907033);
        this.f9680s = (BetterRecyclerView) a(2131567351);
        this.f9681t = (GlyphButton) a(2131567352);
        this.f9682u = (ProgressBar) a(2131567353);
        Source source = Source.QP;
        Intent intent = getIntent();
        if (intent != null) {
            Uri data = intent.getData();
            if (data != null) {
                Object queryParameter = data.getQueryParameter("source");
                if (!StringUtil.a(queryParameter)) {
                    try {
                        source = Source.valueOf(queryParameter);
                    } catch (Exception e) {
                    }
                }
                this.f9686y = data.getBooleanQueryParameter("redirect_to_feed", false);
            }
        }
        this.f9685x.m9904a(source);
        m9913j();
    }

    @Inject
    private void m9910a(ExecutorService executorService, GraphQLQueryExecutor graphQLQueryExecutor, SecurityCheckupScrollingControllerProvider securityCheckupScrollingControllerProvider, SecurityCheckupLogger securityCheckupLogger, SecureContextHelper secureContextHelper) {
        this.f9678q = executorService;
        this.f9679r = graphQLQueryExecutor;
        this.f9684w = securityCheckupScrollingControllerProvider;
        this.f9685x = securityCheckupLogger;
        this.f9687z = secureContextHelper;
    }

    private void m9913j() {
        this.f9685x.m9903a(Event.CHECKUP_LOAD_START);
        Futures.a(this.f9679r.a(GraphQLRequest.a(new SecurityCheckupQueryString()).a(GraphQLCachePolicy.c)), new C14411(this), this.f9678q);
    }

    private void m9907a(SecurityCheckupModel securityCheckupModel) {
        this.f9685x.m9903a(Event.CHECKUP_LOAD_COMPLETE);
        InjectorLike injectorLike = this.f9684w;
        BetterRecyclerView betterRecyclerView = this.f9680s;
        this.f9683v = new SecurityCheckupScrollingController(this, securityCheckupModel, betterRecyclerView, this.f9681t, (SecurityCheckupAdapterProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(SecurityCheckupAdapterProvider.class), SecurityCheckupLogger.m9901a(injectorLike));
        runOnUiThread(new C14422(this));
    }

    public static void m9914k(SecurityCheckupMainActivity securityCheckupMainActivity) {
        securityCheckupMainActivity.f9680s.setVisibility(0);
        securityCheckupMainActivity.f9681t.setVisibility(0);
        securityCheckupMainActivity.f9682u.setVisibility(8);
    }

    public void onBackPressed() {
        if (this.f9683v != null && this.f9683v.f9706e == ScrollingState.EXPAND_COMPLETED) {
            this.f9683v.m9931c();
        } else if (this.f9686y) {
            this.f9687z.a(new Intent("android.intent.action.VIEW").setData(Uri.parse(FBLinks.bT)), this);
            finish();
        } else {
            super.onBackPressed();
        }
    }
}
