package com.facebook.instantshopping.action;

import android.content.Context;
import android.net.Uri;
import android.os.SystemClock;
import android.widget.Toast;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.executors.DefaultAndroidThreadUtil;
import com.facebook.common.executors.FbAsyncTask;
import com.facebook.common.executors.ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.common.util.FacebookUriUtil;
import com.facebook.graphql.enums.GraphQLInstantShoppingActionType;
import com.facebook.http.common.FbHttpRequest;
import com.facebook.http.common.FbHttpRequestProcessor;
import com.facebook.http.interfaces.RequestPriority;
import com.facebook.http.protocol.ApiMethodRunnerImpl;
import com.facebook.http.protocol.ApiResponseChecker;
import com.facebook.http.protocol.StringResponseHandler;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.instantshopping.InstantShoppingSurveyController;
import com.facebook.instantshopping.InstantShoppingUriIntentBuilder;
import com.facebook.instantshopping.event.InstantShoppingEvents.InstantShoppingReloadDocumentEvent;
import com.facebook.instantshopping.event.InstantShoppingEvents.ItemAddedToCartEvent;
import com.facebook.instantshopping.logging.InstantShoppingAnalyticsLogger;
import com.facebook.instantshopping.logging.InstantShoppingDwellTimeLogger;
import com.facebook.instantshopping.logging.InstantShoppingElementDwellTimeLogger;
import com.facebook.instantshopping.logging.LoggingParams;
import com.facebook.instantshopping.model.graphql.InstantShoppingGraphQLInterfaces.InstantShoppingActionFragment;
import com.facebook.instantshopping.model.graphql.InstantShoppingGraphQLInterfaces.InstantShoppingOptionsActionFragment;
import com.facebook.instantshopping.utils.SizeUtils;
import com.facebook.links.AttachmentLinkLauncher;
import com.facebook.richdocument.event.RichDocumentEventBus;
import com.facebook.tools.dextr.runtime.detour.ExecutorDetour;
import com.google.common.util.concurrent.FutureCallback;
import java.net.URI;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import javax.annotation.Nullable;
import javax.inject.Inject;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.params.BasicHttpParams;

@ContextScoped
/* compiled from: Slide  */
public class InstantShoppingActionUtils {
    private static InstantShoppingActionUtils f23485r;
    private static final Object f23486s = new Object();
    private Context f23487a;
    private ApiMethodRunnerImpl f23488b;
    public ApiResponseChecker f23489c;
    public DefaultAndroidThreadUtil f23490d;
    public FbHttpRequestProcessor f23491e;
    private InstantShoppingDwellTimeLogger f23492f;
    private ExecutorService f23493g;
    public final AbstractFbErrorReporter f23494h;
    private InstantShoppingPostHandlerMethod f23495i = new InstantShoppingPostHandlerMethod();
    private RichDocumentEventBus f23496j;
    private final AttachmentLinkLauncher f23497k;
    private OptionsSelectorAction f23498l;
    private InstantShoppingUriIntentBuilder f23499m;
    private final InstantShoppingAnalyticsLogger f23500n;
    private InstantShoppingSurveyController f23501o;
    private SizeUtils f23502p;
    private InstantShoppingElementDwellTimeLogger f23503q;

    /* compiled from: Slide  */
    public class C33853 implements FutureCallback<String> {
        final /* synthetic */ String f23477a;
        final /* synthetic */ InstantShoppingActionUtils f23478b;

        public C33853(InstantShoppingActionUtils instantShoppingActionUtils, String str) {
            this.f23478b = instantShoppingActionUtils;
            this.f23477a = str;
        }

        public /* bridge */ /* synthetic */ void onSuccess(@Nullable Object obj) {
        }

        public void onFailure(Throwable th) {
            this.f23478b.f23494h.a("InstantShoppingGetAction:", "Get action to url " + this.f23477a + " failed");
        }
    }

    /* compiled from: Slide  */
    /* synthetic */ class C33875 {
        static final /* synthetic */ int[] f23479a = new int[GraphQLInstantShoppingActionType.values().length];

        static {
            try {
                f23479a[GraphQLInstantShoppingActionType.OPEN_URL.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f23479a[GraphQLInstantShoppingActionType.ADD_TO_CART.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f23479a[GraphQLInstantShoppingActionType.SAVE.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f23479a[GraphQLInstantShoppingActionType.UNSAVE.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                f23479a[GraphQLInstantShoppingActionType.POST.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                f23479a[GraphQLInstantShoppingActionType.SHOW_SELECTOR.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
        }
    }

    /* compiled from: Slide  */
    public class GetRequestAsyncTask extends FbAsyncTask<Void, Void, GetRequestAsyncTaskResult> {
        final /* synthetic */ InstantShoppingActionUtils f23480a;
        private final String f23481b;
        private final FutureCallback<String> f23482c;

        protected void onPostExecute(Object obj) {
            GetRequestAsyncTaskResult getRequestAsyncTaskResult = (GetRequestAsyncTaskResult) obj;
            if (this.f23482c != null) {
                if (getRequestAsyncTaskResult.f23484b != null) {
                    this.f23482c.onFailure(getRequestAsyncTaskResult.f23484b);
                }
                this.f23482c.onSuccess(getRequestAsyncTaskResult.f23483a);
            }
        }

        public GetRequestAsyncTask(InstantShoppingActionUtils instantShoppingActionUtils, String str, FutureCallback<String> futureCallback) {
            this.f23480a = instantShoppingActionUtils;
            this.f23481b = str;
            this.f23482c = futureCallback;
        }

        protected final Object m24795a(Object[] objArr) {
            return m24794a(this.f23481b);
        }

        private GetRequestAsyncTaskResult m24794a(String str) {
            try {
                URL url = new URL(str);
                HttpUriRequest httpGet = new HttpGet(new URI(url.getProtocol(), url.getAuthority(), url.getPath(), url.getQuery(), url.getRef()));
                StringResponseHandler stringResponseHandler = new StringResponseHandler(this.f23480a.f23489c);
                httpGet.setParams(new BasicHttpParams().setParameter("http.protocol.handle-redirects", Boolean.valueOf(true)));
                return new GetRequestAsyncTaskResult((String) this.f23480a.f23491e.a(FbHttpRequest.newBuilder().a("instant_shopping_async_get").a(CallerContext.a(getClass())).a(httpGet).a(RequestPriority.NON_INTERACTIVE).a(stringResponseHandler).a()));
            } catch (Exception e) {
                Exception exception = e;
                this.f23480a.f23494h.a("InstantShoppingGetAction", "Get request to url: " + str + " failed");
                return new GetRequestAsyncTaskResult(exception);
            }
        }
    }

    /* compiled from: Slide  */
    public class GetRequestAsyncTaskResult {
        public String f23483a;
        public Exception f23484b = null;

        public GetRequestAsyncTaskResult(String str) {
            this.f23483a = str;
        }

        public GetRequestAsyncTaskResult(Exception exception) {
            this.f23484b = exception;
        }
    }

    private static InstantShoppingActionUtils m24799b(InjectorLike injectorLike) {
        return new InstantShoppingActionUtils((Context) injectorLike.getInstance(Context.class), ApiMethodRunnerImpl.a(injectorLike), ApiResponseChecker.a(injectorLike), FbHttpRequestProcessor.a(injectorLike), DefaultAndroidThreadUtil.a(injectorLike), InstantShoppingDwellTimeLogger.m24863a(injectorLike), (ExecutorService) ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider.a(injectorLike), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike), RichDocumentEventBus.a(injectorLike), AttachmentLinkLauncher.a(injectorLike), OptionsSelectorAction.m24813a(injectorLike), InstantShoppingUriIntentBuilder.m24791a(injectorLike), InstantShoppingAnalyticsLogger.m24853a(injectorLike), InstantShoppingSurveyController.m24787a(injectorLike), SizeUtils.a(injectorLike), InstantShoppingElementDwellTimeLogger.m24873a(injectorLike));
    }

    public static InstantShoppingActionUtils m24796a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            InstantShoppingActionUtils b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f23486s) {
                InstantShoppingActionUtils instantShoppingActionUtils;
                if (a2 != null) {
                    instantShoppingActionUtils = (InstantShoppingActionUtils) a2.a(f23486s);
                } else {
                    instantShoppingActionUtils = f23485r;
                }
                if (instantShoppingActionUtils == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m24799b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f23486s, b3);
                        } else {
                            f23485r = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = instantShoppingActionUtils;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Inject
    public InstantShoppingActionUtils(Context context, ApiMethodRunnerImpl apiMethodRunnerImpl, ApiResponseChecker apiResponseChecker, FbHttpRequestProcessor fbHttpRequestProcessor, DefaultAndroidThreadUtil defaultAndroidThreadUtil, InstantShoppingDwellTimeLogger instantShoppingDwellTimeLogger, ExecutorService executorService, AbstractFbErrorReporter abstractFbErrorReporter, RichDocumentEventBus richDocumentEventBus, AttachmentLinkLauncher attachmentLinkLauncher, OptionsSelectorAction optionsSelectorAction, InstantShoppingUriIntentBuilder instantShoppingUriIntentBuilder, InstantShoppingAnalyticsLogger instantShoppingAnalyticsLogger, InstantShoppingSurveyController instantShoppingSurveyController, SizeUtils sizeUtils, InstantShoppingElementDwellTimeLogger instantShoppingElementDwellTimeLogger) {
        this.f23487a = context;
        this.f23488b = apiMethodRunnerImpl;
        this.f23489c = apiResponseChecker;
        this.f23491e = fbHttpRequestProcessor;
        this.f23490d = defaultAndroidThreadUtil;
        this.f23492f = instantShoppingDwellTimeLogger;
        this.f23493g = executorService;
        this.f23494h = abstractFbErrorReporter;
        this.f23496j = richDocumentEventBus;
        this.f23497k = attachmentLinkLauncher;
        this.f23498l = optionsSelectorAction;
        this.f23499m = instantShoppingUriIntentBuilder;
        this.f23500n = instantShoppingAnalyticsLogger;
        this.f23501o = instantShoppingSurveyController;
        this.f23502p = sizeUtils;
        this.f23503q = instantShoppingElementDwellTimeLogger;
    }

    public final void m24802a(Context context, InstantShoppingActionFragment instantShoppingActionFragment, @Nullable LoggingParams loggingParams, @Nullable Map<String, Object> map) {
        switch (C33875.f23479a[instantShoppingActionFragment.a().ordinal()]) {
            case 1:
                if (instantShoppingActionFragment.d() && AttachmentLinkLauncher.b(Uri.parse(instantShoppingActionFragment.iG_()))) {
                    this.f23496j.a(new InstantShoppingReloadDocumentEvent(this.f23499m.a(context, instantShoppingActionFragment.iG_())));
                } else {
                    this.f23497k.a(context, instantShoppingActionFragment.iG_(), null, null);
                }
                m24798a(loggingParams, instantShoppingActionFragment.a(), instantShoppingActionFragment.iG_(), (Map) map);
                m24797a();
                return;
            case 2:
                if (this.f23502p.a) {
                    this.f23496j.a(new ItemAddedToCartEvent(1));
                    m24800b(instantShoppingActionFragment.c());
                    m24798a(loggingParams, instantShoppingActionFragment.a(), instantShoppingActionFragment.c(), (Map) map);
                    return;
                }
                Toast.makeText(this.f23487a, this.f23487a.getResources().getString(2131239255), 1).show();
                return;
            case 3:
            case 4:
            case 5:
                m24800b(instantShoppingActionFragment.c());
                m24798a(loggingParams, instantShoppingActionFragment.a(), instantShoppingActionFragment.c(), (Map) map);
                return;
            case 6:
                this.f23498l.m24815a(context, instantShoppingActionFragment);
                return;
            default:
                return;
        }
    }

    private void m24797a() {
        this.f23492f.f23542d = SystemClock.uptimeMillis();
        this.f23503q.m24875a();
    }

    public final void m24803a(Context context, InstantShoppingOptionsActionFragment instantShoppingOptionsActionFragment, @Nullable LoggingParams loggingParams, @Nullable Map<String, Object> map) {
        switch (C33875.f23479a[instantShoppingOptionsActionFragment.a().ordinal()]) {
            case 1:
                if (instantShoppingOptionsActionFragment.c() && AttachmentLinkLauncher.b(Uri.parse(instantShoppingOptionsActionFragment.d()))) {
                    this.f23496j.a(new InstantShoppingReloadDocumentEvent(this.f23499m.a(context, instantShoppingOptionsActionFragment.d())));
                } else {
                    this.f23497k.a(context, instantShoppingOptionsActionFragment.d(), null, null);
                }
                m24798a(loggingParams, instantShoppingOptionsActionFragment.a(), instantShoppingOptionsActionFragment.d(), (Map) map);
                m24797a();
                return;
            case 2:
                Toast.makeText(this.f23487a, this.f23487a.getResources().getString(2131239254), 0).show();
                this.f23496j.a(new ItemAddedToCartEvent(1));
                m24800b(instantShoppingOptionsActionFragment.b());
                m24798a(loggingParams, instantShoppingOptionsActionFragment.a(), instantShoppingOptionsActionFragment.b(), (Map) map);
                return;
            case 5:
                m24800b(instantShoppingOptionsActionFragment.b());
                m24798a(loggingParams, instantShoppingOptionsActionFragment.a(), instantShoppingOptionsActionFragment.b(), (Map) map);
                return;
            default:
                return;
        }
    }

    private void m24800b(final String str) {
        ExecutorDetour.a(this.f23493g, new Runnable(this) {
            final /* synthetic */ InstantShoppingActionUtils f23476b;

            public void run() {
                InstantShoppingActionUtils.m24801c(this.f23476b, str);
            }
        }, -627931881);
    }

    public static void m24801c(InstantShoppingActionUtils instantShoppingActionUtils, final String str) {
        try {
            instantShoppingActionUtils.f23488b.a(instantShoppingActionUtils.f23495i, str);
        } catch (Exception e) {
            instantShoppingActionUtils.f23494h.a("InstantShoppingPostAction", "Post action to postUrl: " + str + " failed");
            instantShoppingActionUtils.f23500n.m24859a("instant_shopping_post_action_failure", new HashMap<String, Object>() {
            });
        }
    }

    private void m24798a(LoggingParams loggingParams, GraphQLInstantShoppingActionType graphQLInstantShoppingActionType, String str, Map<String, Object> map) {
        final LoggingParams loggingParams2 = loggingParams;
        final String str2 = str;
        final GraphQLInstantShoppingActionType graphQLInstantShoppingActionType2 = graphQLInstantShoppingActionType;
        final Map<String, Object> map2 = map;
        this.f23500n.m24859a("instant_shopping_element_click", new HashMap<String, Object>() {
        });
        InstantShoppingSurveyController instantShoppingSurveyController = this.f23501o;
        if (graphQLInstantShoppingActionType == GraphQLInstantShoppingActionType.OPEN_URL && str != null) {
            Uri parse = Uri.parse(str);
            if (FacebookUriUtil.a(parse) || !(FacebookUriUtil.c(parse) || FacebookUriUtil.g(parse))) {
                instantShoppingSurveyController.f23470e = true;
            }
        }
    }
}
