package com.facebook.richdocument.utils;

import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.executors.DefaultAndroidThreadUtil;
import com.facebook.common.executors.FbAsyncTask;
import com.facebook.http.common.FbHttpRequest;
import com.facebook.http.common.FbHttpRequestProcessor;
import com.facebook.http.interfaces.RequestPriority;
import com.facebook.http.protocol.ApiResponseChecker;
import com.facebook.http.protocol.StringResponseHandler;
import com.facebook.inject.InjectorLike;
import com.google.common.util.concurrent.FutureCallback;
import java.net.URI;
import java.net.URL;
import javax.annotation.Nullable;
import javax.inject.Inject;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.params.BasicHttpParams;

/* compiled from: people_entity_cards_page_ids */
public class ActionUtils {
    public ApiResponseChecker f6470a;
    private DefaultAndroidThreadUtil f6471b;
    public FbHttpRequestProcessor f6472c;
    public final AbstractFbErrorReporter f6473d;

    /* compiled from: people_entity_cards_page_ids */
    class GetRequestAsyncTask extends FbAsyncTask<Void, Void, GetRequestAsyncTaskResult> {
        final /* synthetic */ ActionUtils f6465a;
        private final String f6466b;
        private final FutureCallback<String> f6467c;

        protected void onPostExecute(Object obj) {
            GetRequestAsyncTaskResult getRequestAsyncTaskResult = (GetRequestAsyncTaskResult) obj;
            if (this.f6467c != null) {
                if (getRequestAsyncTaskResult.f6469b != null) {
                    this.f6467c.onFailure(getRequestAsyncTaskResult.f6469b);
                }
                this.f6467c.onSuccess(getRequestAsyncTaskResult.f6468a);
            }
        }

        public GetRequestAsyncTask(ActionUtils actionUtils, String str, FutureCallback<String> futureCallback) {
            this.f6465a = actionUtils;
            this.f6466b = str;
            this.f6467c = futureCallback;
        }

        protected final Object m6845a(Object[] objArr) {
            return m6844a(this.f6466b);
        }

        private GetRequestAsyncTaskResult m6844a(String str) {
            try {
                URL url = new URL(str);
                HttpUriRequest httpGet = new HttpGet(new URI(url.getProtocol(), url.getAuthority(), url.getPath(), url.getQuery(), url.getRef()));
                StringResponseHandler stringResponseHandler = new StringResponseHandler(this.f6465a.f6470a);
                httpGet.setParams(new BasicHttpParams().setParameter("http.protocol.handle-redirects", Boolean.valueOf(true)));
                return new GetRequestAsyncTaskResult((String) this.f6465a.f6472c.a(FbHttpRequest.newBuilder().a("richdocument_async_get").a(CallerContext.a(getClass())).a(httpGet).a(RequestPriority.NON_INTERACTIVE).a(stringResponseHandler).a()));
            } catch (Exception e) {
                Exception exception = e;
                this.f6465a.f6473d.a("RichDocumentGetAction", "Get request to url: " + str + " failed");
                return new GetRequestAsyncTaskResult(exception);
            }
        }
    }

    /* compiled from: people_entity_cards_page_ids */
    public class GetRequestAsyncTaskResult {
        public String f6468a;
        public Exception f6469b = null;

        public GetRequestAsyncTaskResult(String str) {
            this.f6468a = str;
        }

        public GetRequestAsyncTaskResult(Exception exception) {
            this.f6469b = exception;
        }
    }

    public static ActionUtils m6846b(InjectorLike injectorLike) {
        return new ActionUtils(ApiResponseChecker.a(injectorLike), FbHttpRequestProcessor.a(injectorLike), DefaultAndroidThreadUtil.b(injectorLike), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike));
    }

    @Inject
    public ActionUtils(ApiResponseChecker apiResponseChecker, FbHttpRequestProcessor fbHttpRequestProcessor, DefaultAndroidThreadUtil defaultAndroidThreadUtil, AbstractFbErrorReporter abstractFbErrorReporter) {
        this.f6470a = apiResponseChecker;
        this.f6472c = fbHttpRequestProcessor;
        this.f6471b = defaultAndroidThreadUtil;
        this.f6473d = abstractFbErrorReporter;
    }

    public final void m6847a(final String str) {
        this.f6471b.a(new GetRequestAsyncTask(this, str, new FutureCallback<String>(this) {
            final /* synthetic */ ActionUtils f6464b;

            public /* bridge */ /* synthetic */ void onSuccess(@Nullable Object obj) {
            }

            public void onFailure(Throwable th) {
                this.f6464b.f6473d.a("InstantShoppingGetAction:", "Get action to url " + str + " failed");
            }
        }), new Void[0]);
    }
}
