package com.facebook.platformattribution.nux;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.executors.ForUiThread;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.common.futures.FutureUtils;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.http.common.FbHttpRequest;
import com.facebook.http.common.FbHttpRequest.Builder;
import com.facebook.http.common.FbHttpRequestProcessor;
import com.facebook.http.common.HttpFutureWrapper;
import com.facebook.http.common.HttpRedirectFetcher;
import com.facebook.http.interfaces.RequestPriority;
import com.facebook.inject.FbInjector;
import com.facebook.inject.InjectorLike;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.platformattribution.PlatformAttributionLaunchHelper;
import com.facebook.ui.dialogs.FbDialogFragment;
import com.google.common.base.Strings;
import com.google.common.util.concurrent.FutureCallback;
import java.net.URI;
import java.util.concurrent.ExecutorService;
import javax.annotation.Nullable;
import javax.inject.Inject;
import org.apache.http.client.methods.HttpGet;

/* compiled from: response_pending */
public class LayoutNuxDialogFragment extends FbDialogFragment {
    public static final CallerContext ap = CallerContext.b(LayoutNuxDialogFragment.class, LayoutNuxDialogFragment.class.getSimpleName());
    @Inject
    public PlatformAttributionLaunchHelper am;
    @Inject
    public HttpRedirectFetcher an;
    @Inject
    @ForUiThread
    public ExecutorService ao;
    public FbDraweeView aq;
    public ProgressBar ar;
    private Button as;
    private ImageButton at;
    public HttpFutureWrapper<URI> au;

    /* compiled from: response_pending */
    class C05851 implements OnClickListener {
        final /* synthetic */ LayoutNuxDialogFragment f4473a;

        C05851(LayoutNuxDialogFragment layoutNuxDialogFragment) {
            this.f4473a = layoutNuxDialogFragment;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 985358597);
            this.f4473a.am.m4308a("881555691867714", "com.instagram.layout", this.f4473a.an());
            this.f4473a.am.m4311b("sprout_nux", "881555691867714", "com.instagram.layout");
            this.f4473a.b();
            Logger.a(2, EntryType.UI_INPUT_END, -2015898085, a);
        }
    }

    /* compiled from: response_pending */
    class C05862 implements OnClickListener {
        final /* synthetic */ LayoutNuxDialogFragment f4474a;

        C05862(LayoutNuxDialogFragment layoutNuxDialogFragment) {
            this.f4474a = layoutNuxDialogFragment;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 9424008);
            this.f4474a.b();
            Logger.a(2, EntryType.UI_INPUT_END, 1462539, a);
        }
    }

    /* compiled from: response_pending */
    public class C05873 implements FutureCallback<URI> {
        final /* synthetic */ LayoutNuxDialogFragment f4475a;

        public C05873(LayoutNuxDialogFragment layoutNuxDialogFragment) {
            this.f4475a = layoutNuxDialogFragment;
        }

        public void onSuccess(@Nullable Object obj) {
            URI uri = (URI) obj;
            if (uri != null) {
                String uri2 = uri.toString();
                if (!Strings.isNullOrEmpty(uri2)) {
                    this.f4475a.aq.setVisibility(0);
                    this.f4475a.ar.setVisibility(8);
                    this.f4475a.aq.a(Uri.parse(uri2), LayoutNuxDialogFragment.ap);
                }
            }
        }

        public void onFailure(Throwable th) {
            this.f4475a.b();
        }
    }

    public static void m4313a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        LayoutNuxDialogFragment layoutNuxDialogFragment = (LayoutNuxDialogFragment) obj;
        PlatformAttributionLaunchHelper a = PlatformAttributionLaunchHelper.m4305a(injectorLike);
        HttpRedirectFetcher a2 = HttpRedirectFetcher.a(injectorLike);
        ExecutorService executorService = (ExecutorService) ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.a(injectorLike);
        layoutNuxDialogFragment.am = a;
        layoutNuxDialogFragment.an = a2;
        layoutNuxDialogFragment.ao = executorService;
    }

    public final View m4314a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 736783785);
        View inflate = layoutInflater.inflate(2130905006, viewGroup);
        this.aq = (FbDraweeView) inflate.findViewById(2131563355);
        this.ar = (ProgressBar) inflate.findViewById(2131563356);
        this.as = (Button) inflate.findViewById(2131563357);
        this.as.setOnClickListener(new C05851(this));
        this.at = (ImageButton) inflate.findViewById(2131559737);
        this.at.setOnClickListener(new C05862(this));
        this.am.m4309a("sprout_nux", "881555691867714", "com.instagram.layout");
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -1591863198, a);
        return inflate;
    }

    public final void m4315a(Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1829501654);
        super.a(bundle);
        Class cls = LayoutNuxDialogFragment.class;
        m4313a(this, getContext());
        a(1, 0);
        this.d = true;
        d_(true);
        HttpRedirectFetcher httpRedirectFetcher = this.an;
        URI create = URI.create("https://www.facebook.com/friendsharing/instagram_layout/nux/");
        FbHttpRequestProcessor fbHttpRequestProcessor = httpRedirectFetcher.a;
        Builder newBuilder = FbHttpRequest.newBuilder();
        newBuilder.b = new HttpGet(create);
        newBuilder = newBuilder;
        newBuilder.h = HttpRedirectFetcher.b;
        newBuilder = newBuilder;
        newBuilder.g = HttpRedirectFetcher.c;
        newBuilder = newBuilder;
        newBuilder.c = "HttpRedirectFetcher";
        newBuilder = newBuilder;
        newBuilder.d = CallerContext.a(httpRedirectFetcher.getClass());
        newBuilder = newBuilder;
        newBuilder.l = RequestPriority.INTERACTIVE;
        this.au = fbHttpRequestProcessor.b(newBuilder.a());
        FutureUtils.a(this.au.b, new C05873(this), this.ao);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -1595173306, a);
    }

    public final void mY_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 159316956);
        super.mY_();
        if (this.au != null) {
            this.au.b();
        }
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -1922342370, a);
    }
}
