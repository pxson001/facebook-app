package com.facebook.richdocument.view.block.impl;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.LayoutParams;
import android.webkit.SslErrorHandler;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebView.WebViewTransport;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.errorreporting.SoftError;
import com.facebook.common.fblinks.FBLinks;
import com.facebook.common.market.GooglePlayIntentHelper;
import com.facebook.common.time.AwakeTimeSinceBootClockMethodAutoProvider;
import com.facebook.common.time.MonotonicClock;
import com.facebook.common.uri.FbUriIntentHandler;
import com.facebook.common.util.FacebookUriUtil;
import com.facebook.common.util.JSONUtil;
import com.facebook.common.util.StringUtil;
import com.facebook.common.util.TriState;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.content.event.FbEvent;
import com.facebook.entitycards.contextitems.graphql.ContextItemsQueryModels.FBFullImageFragmentModel;
import com.facebook.fbui.glyph.GlyphView;
import com.facebook.fbui.menu.PopoverMenu;
import com.facebook.fbui.popover.PopoverWindow.OnCancelListener;
import com.facebook.fbui.popover.PopoverWindow.Position;
import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.gk.store.GatekeeperStore;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.graphql.enums.GraphQLDocumentNativeAdType;
import com.facebook.graphql.enums.GraphQLDocumentWebviewPresentationStyle;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectableComponentWithContext;
import com.facebook.inject.InjectorLike;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.richdocument.abtest.ExperimentsForRichDocumentAbtestModule;
import com.facebook.richdocument.event.RichDocumentEventBus;
import com.facebook.richdocument.event.RichDocumentEventSubscribers.RichDocumentFragmentLifeCycleSubscriber;
import com.facebook.richdocument.event.RichDocumentEventSubscribers.RichDocumentStartupUiTasksCompletedSubscriber;
import com.facebook.richdocument.event.RichDocumentEvents.RichDocumentFragmentLifeCycleEvent;
import com.facebook.richdocument.event.RichDocumentEvents.RichDocumentFragmentLifeCycleEvent.FragmentLifeCycleEvent;
import com.facebook.richdocument.event.StartupStateMachine;
import com.facebook.richdocument.fetcher.NativeAdFetcher;
import com.facebook.richdocument.gk.IsFallbackNativeAdEnabled;
import com.facebook.richdocument.ham.HamDimensions;
import com.facebook.richdocument.ham.HamViewUtils;
import com.facebook.richdocument.logging.NativeAdsPerfInfoLogger;
import com.facebook.richdocument.logging.RichDocumentAnalyticsLogger;
import com.facebook.richdocument.logging.WebViewAdImpressionLogger;
import com.facebook.richdocument.logging.WebViewPerfInfoLogger;
import com.facebook.richdocument.logging.WebViewPerfInfoLogger.WebViewPerfEventInfo;
import com.facebook.richdocument.model.block.Annotation.AnnotationSlot;
import com.facebook.richdocument.model.block.VideoBlockInput;
import com.facebook.richdocument.model.graphql.RichDocumentGraphQlModels.RichDocumentLocationAnnotationModel;
import com.facebook.richdocument.model.graphql.RichDocumentGraphQlModels.RichDocumentTextAnnotationModel;
import com.facebook.richdocument.model.graphql.RichDocumentNativeAdsGraphqlModels.RichDocumentHTMLNativeAdFragmentModel.FallbackNativeAdModel;
import com.facebook.richdocument.presenter.WebViewBlockPresenter;
import com.facebook.richdocument.utils.UIUtils;
import com.facebook.richdocument.view.autoplay.VideoAutoPlayPolicy;
import com.facebook.richdocument.view.block.BlockViewUtil;
import com.facebook.richdocument.view.block.TextAnnotationAware;
import com.facebook.richdocument.view.block.WebViewBlockView;
import com.facebook.richdocument.view.transition.TransitionStrategyFactory.StrategyType;
import com.facebook.richdocument.view.util.RichDocumentLayoutDirection;
import com.facebook.richdocument.view.util.WebViewUtils;
import com.facebook.richdocument.view.widget.AnnotatableView;
import com.facebook.richdocument.view.widget.AnnotationSlotLinearLayout;
import com.facebook.richdocument.view.widget.AnnotationView;
import com.facebook.richdocument.view.widget.AnnotationViews;
import com.facebook.richdocument.view.widget.DirectionAwarePopoverMenuWindow;
import com.facebook.richdocument.view.widget.IAWebView;
import com.facebook.richdocument.view.widget.RichTextView;
import com.facebook.richdocument.view.widget.WebViewLoader;
import com.facebook.richdocument.view.widget.WebViewLoader.LoadPriority;
import com.facebook.tools.dextr.runtime.detour.HandlerDetour;
import com.facebook.video.server.VideoServer;
import com.facebook.video.server.VideoServerMethodAutoProvider;
import com.facebook.widget.CustomLinearLayout;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.MoreExecutors;
import java.util.ArrayList;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;
import org.json.JSONArray;

/* compiled from: page_categories */
public class WebViewBlockViewImpl extends AbstractBlockView<WebViewBlockPresenter> implements InjectableComponentWithContext, WebViewBlockView, AnnotatableView, TextAnnotationAware, AnnotatableView {
    public static final String f6851x = WebViewBlockViewImpl.class.getSimpleName();
    private static final EnumMap<GraphQLDocumentWebviewPresentationStyle, Float> f6852y = new C07721(GraphQLDocumentWebviewPresentationStyle.class);
    private static final EnumMap<GraphQLDocumentWebviewPresentationStyle, Float> f6853z = new C07732(GraphQLDocumentWebviewPresentationStyle.class);
    private final boolean f6854A;
    public final boolean f6855B;
    private final boolean f6856C;
    private final boolean f6857D;
    public final boolean f6858E;
    public final List<Runnable> f6859F = new ArrayList();
    private final RichDocumentStartupUiTasksCompletedSubscriber f6860G = new C07743(this);
    private final RichDocumentFragmentLifeCycleSubscriber f6861H = new C07754(this);
    private boolean f6862I;
    public int f6863J = 0;
    public GraphQLDocumentWebviewPresentationStyle f6864K;
    public boolean f6865L;
    public String f6866M;
    public boolean f6867N = false;
    public IAWebView f6868O;
    public RichTextView f6869P;
    public GlyphView f6870Q;
    public NativeAdBlockViewImpl f6871R;
    private AnnotationSlotLinearLayout f6872S;
    private AnnotationSlotLinearLayout f6873T;
    private AnnotationSlotLinearLayout f6874U;
    public Bundle f6875V;
    public List<String> f6876W;
    public List<String> f6877X;
    public boolean f6878Y = false;
    public boolean f6879Z = false;
    @Inject
    SecureContextHelper f6880a;
    public boolean aa;
    public boolean ab = false;
    @Inject
    MonotonicClock f6881b;
    @Inject
    public AbstractFbErrorReporter f6882c;
    @Inject
    FbUriIntentHandler f6883d;
    @Inject
    GooglePlayIntentHelper f6884e;
    @Inject
    public RichDocumentAnalyticsLogger f6885f;
    @Inject
    HamViewUtils f6886g;
    @Inject
    public WebViewLoader f6887h;
    @Inject
    WebViewPerfInfoLogger f6888i;
    @Inject
    WebViewAdImpressionLogger f6889j;
    @Inject
    NativeAdsPerfInfoLogger f6890k;
    @Inject
    HamDimensions f6891l;
    @Inject
    WebViewUtils f6892m;
    @Inject
    public GatekeeperStoreImpl f6893n;
    @Inject
    public NativeAdFetcher f6894o;
    @Inject
    @IsFallbackNativeAdEnabled
    Provider<TriState> f6895p;
    @Inject
    RichDocumentEventBus f6896q;
    @Inject
    StartupStateMachine f6897r;
    @Inject
    QeAccessor f6898s;
    @Inject
    public RichDocumentLayoutDirection f6899t;
    @Inject
    public VideoServer f6900u;
    @Inject
    public VideoAutoPlayPolicy f6901v;
    @Inject
    BlockViewUtil f6902w;

    /* compiled from: page_categories */
    final class C07721 extends EnumMap<GraphQLDocumentWebviewPresentationStyle, Float> {
        C07721(Class cls) {
            super(cls);
            put(GraphQLDocumentWebviewPresentationStyle.YOUTUBE, Float.valueOf(1.7777778f));
            put(GraphQLDocumentWebviewPresentationStyle.VINE, Float.valueOf(1.0f));
        }
    }

    /* compiled from: page_categories */
    final class C07732 extends EnumMap<GraphQLDocumentWebviewPresentationStyle, Float> {
        C07732(Class cls) {
            super(cls);
            put(GraphQLDocumentWebviewPresentationStyle.INSTAGRAM, Float.valueOf(1.11f));
            put(GraphQLDocumentWebviewPresentationStyle.TWEET, Float.valueOf(3.3f));
            put(GraphQLDocumentWebviewPresentationStyle.FACEBOOK, Float.valueOf(3.82f));
            put(GraphQLDocumentWebviewPresentationStyle.SOCIAL_EMBED, Float.valueOf(3.82f));
        }
    }

    /* compiled from: page_categories */
    class C07743 extends RichDocumentStartupUiTasksCompletedSubscriber {
        final /* synthetic */ WebViewBlockViewImpl f6823a;

        C07743(WebViewBlockViewImpl webViewBlockViewImpl) {
            this.f6823a = webViewBlockViewImpl;
        }

        public final void m7107b(FbEvent fbEvent) {
            for (Runnable run : this.f6823a.f6859F) {
                run.run();
            }
            this.f6823a.f6859F.clear();
            this.f6823a.f6896q.b(this);
        }
    }

    /* compiled from: page_categories */
    class C07754 extends RichDocumentFragmentLifeCycleSubscriber {
        final /* synthetic */ WebViewBlockViewImpl f6824a;

        C07754(WebViewBlockViewImpl webViewBlockViewImpl) {
            this.f6824a = webViewBlockViewImpl;
        }

        public final void m7108b(FbEvent fbEvent) {
            FragmentLifeCycleEvent fragmentLifeCycleEvent = ((RichDocumentFragmentLifeCycleEvent) fbEvent).f5175a;
            if (fragmentLifeCycleEvent == FragmentLifeCycleEvent.ON_RESUME) {
                WebViewBlockViewImpl.m7128m(this.f6824a);
            } else if (fragmentLifeCycleEvent == FragmentLifeCycleEvent.ON_PAUSE) {
                WebViewBlockViewImpl.m7127l(this.f6824a);
            }
        }
    }

    /* compiled from: page_categories */
    class C07765 implements Runnable {
        final /* synthetic */ WebViewBlockViewImpl f6825a;

        C07765(WebViewBlockViewImpl webViewBlockViewImpl) {
            this.f6825a = webViewBlockViewImpl;
        }

        public void run() {
            WebViewBlockViewImpl.m7125i(this.f6825a);
            if (this.f6825a.iX_() != null) {
                WebViewBlockPresenter webViewBlockPresenter = (WebViewBlockPresenter) this.f6825a.iX_();
                webViewBlockPresenter.f6462k = false;
                for (Runnable run : webViewBlockPresenter.f6461j) {
                    run.run();
                }
                webViewBlockPresenter.f6461j.clear();
            }
        }
    }

    /* compiled from: page_categories */
    class IAWebChromeClient extends WebChromeClient {
        final /* synthetic */ WebViewBlockViewImpl f6826a;

        public IAWebChromeClient(WebViewBlockViewImpl webViewBlockViewImpl) {
            this.f6826a = webViewBlockViewImpl;
        }

        public boolean onCreateWindow(WebView webView, boolean z, boolean z2, Message message) {
            ((WebViewTransport) message.obj).setWebView(new NewWindowWebView(this.f6826a, this.f6826a.getContext()));
            message.sendToTarget();
            return true;
        }
    }

    /* compiled from: page_categories */
    class WebViewClickHandler extends WebViewClient implements OnTouchListener {
        private long f6845a;
        final /* synthetic */ WebViewBlockViewImpl f6846c;

        public WebViewClickHandler(WebViewBlockViewImpl webViewBlockViewImpl) {
            this.f6846c = webViewBlockViewImpl;
        }

        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            if (str == null || this.f6846c.f6881b.now() - this.f6845a > 250) {
                return false;
            }
            WebViewBlockViewImpl.m7120a(this.f6846c, str);
            return true;
        }

        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() == 1) {
                this.f6845a = this.f6846c.f6881b.now();
            }
            return false;
        }
    }

    /* compiled from: page_categories */
    public class IAWebViewClient extends WebViewClickHandler {
        String f6847a;
        public final /* synthetic */ WebViewBlockViewImpl f6848b;

        /* compiled from: page_categories */
        class C07815 implements OnClickListener {
            final /* synthetic */ IAWebViewClient f6837a;

            C07815(IAWebViewClient iAWebViewClient) {
                this.f6837a = iAWebViewClient;
            }

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, -1702441894);
                IAWebViewClient iAWebViewClient = this.f6837a;
                DirectionAwarePopoverMenuWindow directionAwarePopoverMenuWindow = new DirectionAwarePopoverMenuWindow(iAWebViewClient.f6848b.f6899t, iAWebViewClient.f6848b.getContext());
                directionAwarePopoverMenuWindow.c(iAWebViewClient.f6848b.f6870Q);
                directionAwarePopoverMenuWindow.a(true);
                directionAwarePopoverMenuWindow.a(Position.BELOW);
                directionAwarePopoverMenuWindow.I = new C07826(iAWebViewClient);
                PopoverMenu c = directionAwarePopoverMenuWindow.c();
                if (c != null) {
                    c.a(2131237734).setIcon(2130839819).setOnMenuItemClickListener(new C07837(iAWebViewClient));
                    c.a(2131233630).setIcon(2130839945).setOnMenuItemClickListener(new C07848(iAWebViewClient));
                    directionAwarePopoverMenuWindow.d();
                }
                Logger.a(2, EntryType.UI_INPUT_END, 922524705, a);
            }
        }

        /* compiled from: page_categories */
        public class C07826 implements OnCancelListener {
            final /* synthetic */ IAWebViewClient f6838a;

            public C07826(IAWebViewClient iAWebViewClient) {
                this.f6838a = iAWebViewClient;
            }

            public final boolean m7109a() {
                return false;
            }
        }

        /* compiled from: page_categories */
        public class C07837 implements OnMenuItemClickListener {
            final /* synthetic */ IAWebViewClient f6839a;

            public C07837(IAWebViewClient iAWebViewClient) {
                this.f6839a = iAWebViewClient;
            }

            public boolean onMenuItemClick(MenuItem menuItem) {
                this.f6839a.f6848b.iY_().setVisibility(8);
                Map hashMap = new HashMap();
                if (this.f6839a.f6848b.f6876W != null) {
                    ArrayNode b = JSONUtil.b(this.f6839a.f6848b.f6876W);
                    JSONArray jSONArray = new JSONArray();
                    jSONArray.put(b);
                    hashMap.put("ad_images_json", jSONArray);
                }
                if (this.f6839a.f6848b.f6877X != null) {
                    b = JSONUtil.b(this.f6839a.f6848b.f6877X);
                    jSONArray = new JSONArray();
                    jSONArray.put(b);
                    hashMap.put("ad_videos_json", jSONArray);
                }
                hashMap.put("is_ad_network", Integer.valueOf(0));
                this.f6839a.f6848b.f6885f.m5371c("android_native_article_webview_ad_report", hashMap);
                return true;
            }
        }

        /* compiled from: page_categories */
        public class C07848 implements OnMenuItemClickListener {
            final /* synthetic */ IAWebViewClient f6840a;

            public C07848(IAWebViewClient iAWebViewClient) {
                this.f6840a = iAWebViewClient;
            }

            public boolean onMenuItemClick(MenuItem menuItem) {
                return this.f6840a.f6848b.f6883d.a(this.f6840a.f6848b.getContext(), FBLinks.q);
            }
        }

        public IAWebViewClient(WebViewBlockViewImpl webViewBlockViewImpl) {
            this.f6848b = webViewBlockViewImpl;
            super(webViewBlockViewImpl);
        }

        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            ((IAWebView) webView).setFallbackAspectRatio(this.f6848b.m7141g());
            return super.shouldOverrideUrlLoading(webView, str);
        }

        public WebResourceResponse shouldInterceptRequest(final WebView webView, final WebResourceRequest webResourceRequest) {
            if (m7112a(webResourceRequest.getUrl())) {
                HandlerDetour.a(new Handler(Looper.getMainLooper()), new Runnable(this) {
                    final /* synthetic */ IAWebViewClient f6829c;

                    public void run() {
                        this.f6829c.f6847a = webResourceRequest.getUrl().getQueryParameter("placement");
                        try {
                            webView.stopLoading();
                        } catch (Throwable e) {
                            this.f6829c.f6848b.f6882c.a(SoftError.a(WebViewBlockViewImpl.f6851x + "_NPE", "NPE while to attempting to stop loading the webview").a(e).g());
                        }
                        this.f6829c.f6848b.ab = true;
                        this.f6829c.f6848b.f6888i.m5430h(this.f6829c.f6848b.f6866M);
                        IAWebViewClient.m7116d(this.f6829c, webView);
                    }
                }, -1064365871);
                return null;
            } else if (m7114b(webResourceRequest.getUrl())) {
                webView.post(new Runnable(this) {
                    final /* synthetic */ IAWebViewClient f6831b;

                    public void run() {
                        try {
                            webView.stopLoading();
                        } catch (Throwable e) {
                            this.f6831b.f6848b.f6882c.a(SoftError.a(WebViewBlockViewImpl.f6851x + "_NPE", "NPE while to attempting to stop loading the webview").a(e).g());
                        }
                        this.f6831b.f6848b.f6885f.m5370c("android_native_article_report_bad_ad_network_request");
                    }
                });
                return null;
            } else {
                if (m7113a(webResourceRequest.getUrl().toString())) {
                    if (this.f6848b.f6876W == null) {
                        this.f6848b.f6876W = new ArrayList();
                    }
                    this.f6848b.f6876W.add(webResourceRequest.getUrl().toString());
                } else if (m7115b(webResourceRequest.getUrl().toString())) {
                    if (this.f6848b.f6877X == null) {
                        this.f6848b.f6877X = new ArrayList();
                    }
                    this.f6848b.f6877X.add(webResourceRequest.getUrl().toString());
                }
                return super.shouldInterceptRequest(webView, webResourceRequest);
            }
        }

        public WebResourceResponse shouldInterceptRequest(final WebView webView, final String str) {
            if (m7112a(Uri.parse(str))) {
                HandlerDetour.a(new Handler(Looper.getMainLooper()), new Runnable(this) {
                    final /* synthetic */ IAWebViewClient f6834c;

                    public void run() {
                        this.f6834c.f6847a = Uri.parse(str).getQueryParameter("placement");
                        try {
                            webView.stopLoading();
                        } catch (Throwable e) {
                            this.f6834c.f6848b.f6882c.a(SoftError.a(WebViewBlockViewImpl.f6851x + "_NPE", "NPE while to attempting to stop loading the webview").a(e).g());
                        }
                        this.f6834c.f6848b.f6888i.m5430h(this.f6834c.f6848b.f6866M);
                        IAWebViewClient.m7116d(this.f6834c, webView);
                    }
                }, 1299080956);
                return null;
            } else if (m7114b(Uri.parse(str))) {
                webView.post(new Runnable(this) {
                    final /* synthetic */ IAWebViewClient f6836b;

                    public void run() {
                        try {
                            webView.stopLoading();
                        } catch (Throwable e) {
                            this.f6836b.f6848b.f6882c.a(SoftError.a(WebViewBlockViewImpl.f6851x + "_NPE", "NPE while to attempting to stop loading the webview").a(e).g());
                        }
                        this.f6836b.f6848b.f6885f.m5370c("android_native_article_report_bad_ad_network_request");
                    }
                });
                return null;
            } else {
                if (m7113a(str)) {
                    if (this.f6848b.f6876W == null) {
                        this.f6848b.f6876W = new ArrayList();
                    }
                    this.f6848b.f6876W.add(str);
                } else if (m7115b(str)) {
                    if (this.f6848b.f6877X == null) {
                        this.f6848b.f6877X = new ArrayList();
                    }
                    this.f6848b.f6877X.add(str);
                }
                return super.shouldInterceptRequest(webView, str);
            }
        }

        public void onReceivedError(WebView webView, int i, String str, String str2) {
            super.onReceivedError(webView, i, str, str2);
            this.f6848b.f6888i.m5429g(this.f6848b.f6866M);
            this.f6848b.f6882c.a(SoftError.a(WebViewBlockViewImpl.f6851x + ".IAWebViewClient.onReceivedError", "Failed to load URI. errorCode:" + i + "|failingUrl:" + str2 + "|description:" + str).g());
        }

        public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
            super.onReceivedSslError(webView, sslErrorHandler, sslError);
            this.f6848b.f6888i.m5429g(this.f6848b.f6866M);
            sslErrorHandler.cancel();
            this.f6848b.f6882c.a(SoftError.a(WebViewBlockViewImpl.f6851x + ".IAWebViewClient.onReceivedSslError", "Got SSL Error loading URI. error:" + sslError.toString()).g());
        }

        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            super.onPageStarted(webView, str, bitmap);
            this.f6848b.f6879Z = false;
            if (this.f6848b.f6864K == GraphQLDocumentWebviewPresentationStyle.AD) {
                this.f6848b.f6869P.setVisibility(0);
                this.f6848b.f6869P.f7393d.setText(2131237721);
                this.f6848b.f6886g.m5283c(this.f6848b.iY_(), 2131558653, 0, 2131558654, 0);
                if (this.f6848b.f6893n.a(879, false)) {
                    this.f6848b.f6870Q.setVisibility(0);
                    this.f6848b.f6870Q.setOnClickListener(new C07815(this));
                }
            }
        }

        public void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            if (this.f6848b.f6864K == GraphQLDocumentWebviewPresentationStyle.AD) {
                UIUtils.m6864a(webView, 0);
                m7110a(webView, "document.body.style.margin=0; document.body.style.padding=0; var viewport = document.querySelector('meta[name=viewport]');if (viewport != null) {  viewport.setAttribute('content', \"width=device-width\");}");
                WebViewAdImpressionLogger webViewAdImpressionLogger = this.f6848b.f6889j;
                CharSequence charSequence = this.f6848b.f6866M;
                boolean z = this.f6848b.ab;
                if (!StringUtil.c(charSequence)) {
                    long now = webViewAdImpressionLogger.f5580b.now();
                    Map hashMap = new HashMap();
                    hashMap.put("block_id", charSequence);
                    hashMap.put("is_ad_network", Boolean.valueOf(z));
                    hashMap.put("finish_loading_raw_time", Long.valueOf(now));
                    webViewAdImpressionLogger.f5579a.m5371c("android_native_article_webview_ad_impression", hashMap);
                }
            } else {
                if (this.f6848b.f6893n.a(108, false)) {
                    webView.getSettings().setUseWideViewPort(true);
                    webView.getSettings().setLoadWithOverviewMode(true);
                    if (this.f6848b.f6893n.a(107, false) && VERSION.SDK_INT < 19) {
                        webView.setInitialScale(1);
                    }
                    m7110a(webView, "var documentHead = document.getElementsByTagName('head')[0];var metas = documentHead.getElementsByTagName('meta');var hasViewportMetaTag = false;for (var i = 0; i < metas.length; i++) {var meta = metas[i];if (meta.getAttribute('name') === 'viewport') {hasViewportMetaTag = true;break;}}if (!hasViewportMetaTag) {var viewportTag = document.createElement('meta');viewportTag.name = 'viewport';viewportTag.content = 'width=device-width';documentHead.appendChild(viewportTag);}");
                }
                if (this.f6848b.f6893n.a(105, false)) {
                    m7110a(webView, "var documentBody = document.getElementsByTagName('body')[0];var documentBodyStyle = window.getComputedStyle(documentBody);if (documentBodyStyle.margin === '8px') {documentBody.style.margin = 0;}");
                }
            }
            this.f6848b.f6879Z = true;
            if (this.f6848b.f6855B && !this.f6848b.aa) {
                WebViewBlockViewImpl.m7127l(this.f6848b);
            }
            if (this.f6848b.f6878Y && this.f6848b.aa) {
                WebViewBlockViewImpl webViewBlockViewImpl = this.f6848b;
                if (webViewBlockViewImpl.f6868O != null) {
                    Object obj;
                    IAWebView iAWebView = webViewBlockViewImpl.f6868O;
                    if (iAWebView.f7184n != 0 || iAWebView.f7180j <= 0.0f) {
                        obj = null;
                    } else {
                        obj = 1;
                    }
                    if (obj != null) {
                        LayoutParams layoutParams = iAWebView.getLayoutParams();
                        layoutParams.height = -2;
                        iAWebView.f7180j = 0.0f;
                        iAWebView.setLayoutParams(layoutParams);
                    }
                }
            }
        }

        public static void m7110a(WebView webView, String str) {
            if (VERSION.SDK_INT >= 19) {
                webView.evaluateJavascript(str, null);
            } else {
                webView.loadUrl("javascript: " + str);
            }
        }

        private boolean m7112a(Uri uri) {
            return this.f6848b.f6864K == GraphQLDocumentWebviewPresentationStyle.AD && this.f6848b.f6865L && ((TriState) this.f6848b.f6895p.get()).asBoolean(false) && uri != null && uri.getPath() != null && uri.getPath().equalsIgnoreCase("/adnw_request") && FacebookUriUtil.c(uri);
        }

        private boolean m7114b(Uri uri) {
            return this.f6848b.f6864K == GraphQLDocumentWebviewPresentationStyle.AD && uri != null && uri.getPath() != null && uri.getPath().toLowerCase().indexOf("/plugins/ad.php") >= 0 && FacebookUriUtil.c(uri);
        }

        private boolean m7113a(String str) {
            if (this.f6848b.f6864K == GraphQLDocumentWebviewPresentationStyle.AD && this.f6848b.f6893n.a(878, false)) {
                return str.endsWith("jpg") || str.endsWith("jpeg") || str.endsWith("gif") || str.endsWith("png") || str.endsWith("bmp");
            } else {
                return false;
            }
        }

        private boolean m7115b(String str) {
            if (this.f6848b.f6864K == GraphQLDocumentWebviewPresentationStyle.AD && this.f6848b.f6893n.a(878, false)) {
                return str.endsWith("mp4") || str.endsWith("webm") || str.endsWith("ogg");
            } else {
                return false;
            }
        }

        public static void m7116d(IAWebViewClient iAWebViewClient, WebView webView) {
            webView.setVisibility(4);
            ((CustomLinearLayout) iAWebViewClient.f6848b.iY_().findViewById(2131563026)).setVisibility(8);
            iAWebViewClient.f6848b.f6886g.m5283c(iAWebViewClient.f6848b.iY_(), 0, 0, 0, 0);
            iAWebViewClient.f6848b.f6871R = (NativeAdBlockViewImpl) NativeAdBlockViewImpl.m7048a(iAWebViewClient.f6848b.iY_());
            iAWebViewClient.f6848b.f6871R.ac = iAWebViewClient.f6848b.f6866M;
            iAWebViewClient.f6848b.f6890k.m5359a(iAWebViewClient.f6848b.f6866M);
            iAWebViewClient.f6848b.f6871R.m7068k();
            Bundle bundle = new Bundle();
            bundle.putString("strategyType", StrategyType.NATIVE_ADS_ASPECT_FIT_ONLY.name());
            iAWebViewClient.f6848b.f6871R.mo374a(bundle);
            String str = iAWebViewClient.f6848b.f6866M;
            String str2 = iAWebViewClient.f6847a;
            final NativeAdBlockViewImpl nativeAdBlockViewImpl = iAWebViewClient.f6848b.f6871R;
            iAWebViewClient.f6848b.f6871R.m7075t();
            Futures.a(iAWebViewClient.f6848b.f6894o.m5167a(iAWebViewClient.f6848b.getContext(), str, str2, nativeAdBlockViewImpl.m7073q(), nativeAdBlockViewImpl.m7074r()), new FutureCallback<FallbackNativeAdModel>(iAWebViewClient) {
                final /* synthetic */ IAWebViewClient f6844b;

                public void onSuccess(@Nullable Object obj) {
                    final FallbackNativeAdModel fallbackNativeAdModel = (FallbackNativeAdModel) obj;
                    HandlerDetour.a(new Handler(Looper.getMainLooper()), new Runnable(this) {
                        final /* synthetic */ C07869 f6842b;

                        public void run() {
                            this.f6842b.f6844b.f6848b.f6871R.m7076u();
                            IAWebViewClient iAWebViewClient = this.f6842b.f6844b;
                            FallbackNativeAdModel fallbackNativeAdModel = fallbackNativeAdModel;
                            VideoBlockViewImpl videoBlockViewImpl = nativeAdBlockViewImpl;
                            if (fallbackNativeAdModel != null) {
                                iAWebViewClient.f6848b.f6871R.m7078w();
                                videoBlockViewImpl.m7069l();
                                videoBlockViewImpl.f6742X = fallbackNativeAdModel.m6716o();
                                if (videoBlockViewImpl.m7071n()) {
                                    videoBlockViewImpl.m7070m();
                                }
                                videoBlockViewImpl.m7058a(fallbackNativeAdModel.m6719r());
                                videoBlockViewImpl.m7061b(fallbackNativeAdModel.m6718q(), fallbackNativeAdModel.m6711j());
                                videoBlockViewImpl.m7060b(fallbackNativeAdModel.m6712k());
                                videoBlockViewImpl.m7063c(fallbackNativeAdModel.m6714m(), fallbackNativeAdModel.m6713l());
                                videoBlockViewImpl.ad = fallbackNativeAdModel.m6710a();
                                if (!WebViewBlockViewImpl.m7124b(fallbackNativeAdModel.m6717p())) {
                                    FBFullImageFragmentModel n = fallbackNativeAdModel.m6715n();
                                    if (n != null) {
                                        videoBlockViewImpl.m7064d(n.d());
                                        return;
                                    }
                                    return;
                                } else if (WebViewBlockViewImpl.m7124b(fallbackNativeAdModel.m6717p())) {
                                    videoBlockViewImpl.m7056a(VideoBlockInput.m5452a(fallbackNativeAdModel, iAWebViewClient.f6848b.f6900u, iAWebViewClient.f6848b.f6901v, iAWebViewClient.f6848b.f6882c, iAWebViewClient.f6848b.f6893n.a(97, false)));
                                    if (videoBlockViewImpl.m7071n()) {
                                        iAWebViewClient.f6848b.f6871R.mo378b(iAWebViewClient.f6848b.f6875V);
                                        videoBlockViewImpl.mo402f(iAWebViewClient.f6848b.f6875V);
                                        return;
                                    }
                                    return;
                                } else {
                                    return;
                                }
                            }
                            iAWebViewClient.f6848b.f6871R.m7081z();
                        }
                    }, 335353057);
                }

                public void onFailure(Throwable th) {
                }
            }, MoreExecutors.a());
        }
    }

    /* compiled from: page_categories */
    class NewWindowWebView extends WebView {
        final /* synthetic */ WebViewBlockViewImpl f6850a;

        /* compiled from: page_categories */
        class NewWindowWebViewClient extends WebViewClient {
            final /* synthetic */ NewWindowWebView f6849a;

            public NewWindowWebViewClient(NewWindowWebView newWindowWebView) {
                this.f6849a = newWindowWebView;
            }

            public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                if (Uri.parse(str).getHost().endsWith("giphy.com") && this.f6849a.f6850a.f6858E) {
                    return false;
                }
                WebViewBlockViewImpl.m7120a(this.f6849a.f6850a, str);
                return true;
            }
        }

        public NewWindowWebView(WebViewBlockViewImpl webViewBlockViewImpl, Context context) {
            this.f6850a = webViewBlockViewImpl;
            super(context);
            setWebViewClient(new NewWindowWebViewClient(this));
        }
    }

    public static void m7122a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        ((WebViewBlockViewImpl) obj).m7119a((SecureContextHelper) DefaultSecureContextHelper.a(injectorLike), (MonotonicClock) AwakeTimeSinceBootClockMethodAutoProvider.a(injectorLike), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike), FbUriIntentHandler.a(injectorLike), GooglePlayIntentHelper.a(injectorLike), RichDocumentAnalyticsLogger.m5360a(injectorLike), HamViewUtils.m5278a(injectorLike), WebViewLoader.m7770a(injectorLike), WebViewPerfInfoLogger.m5422a(injectorLike), WebViewAdImpressionLogger.m5413a(injectorLike), NativeAdsPerfInfoLogger.m5356a(injectorLike), HamDimensions.m5268a(injectorLike), WebViewUtils.m7372a(injectorLike), GatekeeperStoreImplMethodAutoProvider.a(injectorLike), NativeAdFetcher.m5165a(injectorLike), IdBasedProvider.a(injectorLike, 759), RichDocumentEventBus.m5130a(injectorLike), StartupStateMachine.m5147a(injectorLike), (QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike), RichDocumentLayoutDirection.m7366a(injectorLike), VideoServerMethodAutoProvider.a(injectorLike), VideoAutoPlayPolicy.m6889a(injectorLike), BlockViewUtil.m6915a(injectorLike));
    }

    private void m7119a(SecureContextHelper secureContextHelper, MonotonicClock monotonicClock, FbErrorReporter fbErrorReporter, FbUriIntentHandler fbUriIntentHandler, GooglePlayIntentHelper googlePlayIntentHelper, RichDocumentAnalyticsLogger richDocumentAnalyticsLogger, HamViewUtils hamViewUtils, WebViewLoader webViewLoader, WebViewPerfInfoLogger webViewPerfInfoLogger, WebViewAdImpressionLogger webViewAdImpressionLogger, NativeAdsPerfInfoLogger nativeAdsPerfInfoLogger, HamDimensions hamDimensions, WebViewUtils webViewUtils, GatekeeperStore gatekeeperStore, NativeAdFetcher nativeAdFetcher, Provider<TriState> provider, RichDocumentEventBus richDocumentEventBus, StartupStateMachine startupStateMachine, QeAccessor qeAccessor, RichDocumentLayoutDirection richDocumentLayoutDirection, VideoServer videoServer, VideoAutoPlayPolicy videoAutoPlayPolicy, BlockViewUtil blockViewUtil) {
        this.f6880a = secureContextHelper;
        this.f6881b = monotonicClock;
        this.f6882c = fbErrorReporter;
        this.f6883d = fbUriIntentHandler;
        this.f6884e = googlePlayIntentHelper;
        this.f6885f = richDocumentAnalyticsLogger;
        this.f6886g = hamViewUtils;
        this.f6887h = webViewLoader;
        this.f6888i = webViewPerfInfoLogger;
        this.f6889j = webViewAdImpressionLogger;
        this.f6890k = nativeAdsPerfInfoLogger;
        this.f6891l = hamDimensions;
        this.f6892m = webViewUtils;
        this.f6893n = gatekeeperStore;
        this.f6894o = nativeAdFetcher;
        this.f6895p = provider;
        this.f6896q = richDocumentEventBus;
        this.f6897r = startupStateMachine;
        this.f6898s = qeAccessor;
        this.f6899t = richDocumentLayoutDirection;
        this.f6900u = videoServer;
        this.f6901v = videoAutoPlayPolicy;
        this.f6902w = blockViewUtil;
    }

    private WebViewBlockViewImpl(FrameLayout frameLayout) {
        super(frameLayout);
        Class cls = WebViewBlockViewImpl.class;
        m7122a((Object) this, getContext());
        if (this.f6893n.a(683, false)) {
            this.f6854A = true;
        } else {
            this.f6854A = this.f6898s.a(ExperimentsForRichDocumentAbtestModule.m, false);
        }
        this.f6878Y = this.f6893n.a(682, false);
        this.f6855B = this.f6893n.a(114, false);
        this.f6856C = this.f6893n.a(101, false);
        this.f6857D = this.f6893n.a(112, false);
        this.f6858E = this.f6893n.a(98, false);
        if (!this.f6854A || this.f6897r.m5152b()) {
            m7125i(this);
        } else {
            this.f6896q.a(this.f6860G);
            this.f6859F.add(new C07765(this));
        }
        if (this.f6855B) {
            this.f6896q.a(this.f6861H);
        }
    }

    public static void m7125i(WebViewBlockViewImpl webViewBlockViewImpl) {
        CustomLinearLayout customLinearLayout = (CustomLinearLayout) webViewBlockViewImpl.iY_().findViewById(2131563025);
        webViewBlockViewImpl.f6869P = (RichTextView) customLinearLayout.findViewById(2131563027);
        webViewBlockViewImpl.f6870Q = (GlyphView) customLinearLayout.findViewById(2131563028);
        webViewBlockViewImpl.f6872S = (AnnotationSlotLinearLayout) customLinearLayout.findViewById(2131563029);
        webViewBlockViewImpl.f6873T = (AnnotationSlotLinearLayout) customLinearLayout.findViewById(2131563031);
        webViewBlockViewImpl.f6874U = (AnnotationSlotLinearLayout) customLinearLayout.findViewById(2131563032);
        FrameLayout frameLayout = (FrameLayout) customLinearLayout.findViewById(2131563030);
        if (webViewBlockViewImpl.f6899t.m7370b()) {
            webViewBlockViewImpl.f6869P.f7393d.setGravity(5);
        } else {
            webViewBlockViewImpl.f6869P.f7393d.setGravity(3);
        }
        webViewBlockViewImpl.f6886g.m5281a(webViewBlockViewImpl.f6869P, 0, 0, 0, 2131558648);
        if (webViewBlockViewImpl.f6893n.a(706, false)) {
            webViewBlockViewImpl.f6868O = new IAWebView(frameLayout.getContext().getApplicationContext(), frameLayout.getContext());
        } else {
            webViewBlockViewImpl.f6868O = new IAWebView(customLinearLayout.getContext());
        }
        webViewBlockViewImpl.f6868O.setBackgroundColor(0);
        if (VERSION.SDK_INT >= 17) {
            webViewBlockViewImpl.f6868O.getSettings().setMediaPlaybackRequiresUserGesture(false);
        }
        webViewBlockViewImpl.f6879Z = false;
        frameLayout.addView(webViewBlockViewImpl.f6868O, 0, new FrameLayout.LayoutParams(-1, -2));
        webViewBlockViewImpl.f6867N = true;
    }

    public final void mo375a(ViewHolder viewHolder) {
        super.mo375a(viewHolder);
        viewHolder.a(false);
    }

    public final void mo392a(RichDocumentTextAnnotationModel richDocumentTextAnnotationModel, RichDocumentTextAnnotationModel richDocumentTextAnnotationModel2, RichDocumentTextAnnotationModel richDocumentTextAnnotationModel3) {
        BlockViewUtil blockViewUtil = this.f6902w;
        getContext();
        blockViewUtil.m6925a(this, richDocumentTextAnnotationModel, richDocumentTextAnnotationModel2, richDocumentTextAnnotationModel3);
    }

    public final void m7132a(RichDocumentLocationAnnotationModel richDocumentLocationAnnotationModel) {
    }

    public final void mo407a(AnnotationView annotationView) {
        AnnotationSlot annotationSlot = annotationView.getAnnotation().f5612e;
        if (annotationSlot == AnnotationSlot.TOP || annotationSlot == AnnotationSlot.ABOVE) {
            this.f6872S.setVisibility(0);
            this.f6872S.m7389a(annotationView);
        } else if (annotationSlot == AnnotationSlot.CENTER) {
            this.f6873T.setVisibility(0);
            this.f6873T.m7389a(annotationView);
        } else if (annotationSlot == AnnotationSlot.BELOW || annotationSlot == AnnotationSlot.BOTTOM) {
            this.f6874U.setVisibility(0);
            this.f6874U.m7389a(annotationView);
        }
    }

    public AnnotationViews getAnnotationViews() {
        return null;
    }

    public final void m7135a(String str, String str2, int i, LoadPriority loadPriority) {
        if (!this.f6862I) {
            m7121a(this.f6868O);
            this.f6868O.f7169a = str;
            this.f6866M = str;
            this.f6862I = true;
            LayoutParams layoutParams = this.f6868O.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new LayoutParams(-1, -2);
            }
            if (i > 0) {
                layoutParams.height = i;
            } else if (this.f6863J > 0) {
                layoutParams.height = this.f6863J;
            } else {
                layoutParams.height = -2;
            }
            this.f6868O.setLayoutParams(layoutParams);
            this.f6868O.setFallbackAspectRatio(m7141g());
            this.f6868O.clearHistory();
            this.f6887h.m7778a(this.f6868O, str, str2, loadPriority);
        }
    }

    public final void m7136a(String str, String str2, String str3, int i, LoadPriority loadPriority) {
        float f = 0.0f;
        if (!this.f6862I) {
            m7121a(this.f6868O);
            this.f6868O.f7169a = str;
            this.f6866M = str;
            this.f6862I = true;
            if (this.f6878Y) {
                float g = m7141g();
                if (g >= 0.0f) {
                    f = g;
                }
            }
            this.f6868O.setFallbackAspectRatio(f);
            LayoutParams layoutParams = this.f6868O.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new LayoutParams(-1, -2);
            }
            if (i > 0) {
                layoutParams.height = i;
            } else if (this.f6863J > 0) {
                layoutParams.height = this.f6863J;
            } else {
                layoutParams.height = -2;
            }
            this.f6868O.setLayoutParams(layoutParams);
            this.f6868O.clearHistory();
            this.f6887h.m7779a(this.f6868O, str, str3, str2, loadPriority);
        }
    }

    public final void m7138b(int i, int i2) {
        if (i != 0 && i2 != 0) {
            int b = (getContext().getResources().getDisplayMetrics().widthPixels - this.f6891l.m5276b(2131558653)) - this.f6891l.m5276b(2131558654);
            int i3 = (b * i) / i2;
            int i4 = (i3 * 100) / i;
            LayoutParams layoutParams = this.f6868O.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new LayoutParams(-1, -2);
            }
            layoutParams.width = b;
            layoutParams.height = i3;
            this.f6868O.setLayoutParams(layoutParams);
            this.f6868O.setInitialScale(i4);
        }
    }

    public final void m7131a(GraphQLDocumentWebviewPresentationStyle graphQLDocumentWebviewPresentationStyle) {
        if (graphQLDocumentWebviewPresentationStyle != GraphQLDocumentWebviewPresentationStyle.AD) {
            this.f6869P.setVisibility(8);
            this.f6870Q.setVisibility(8);
        }
        if (graphQLDocumentWebviewPresentationStyle == GraphQLDocumentWebviewPresentationStyle.AD) {
            UIUtils.m6864a(this.f6868O, getContext().getResources().getColor(2131363475));
        }
        this.f6864K = graphQLDocumentWebviewPresentationStyle;
    }

    private void m7121a(IAWebView iAWebView) {
        this.f6892m.m7378a((WebView) iAWebView);
        Object iAWebViewClient = new IAWebViewClient(this);
        iAWebView.setWebViewClient(iAWebViewClient);
        iAWebView.setWebChromeClient(new IAWebChromeClient(this));
        iAWebView.setOnTouchListener(iAWebViewClient);
    }

    public final boolean mo377a(int i, int i2) {
        return !this.f6856C || this.f6868O.canScrollHorizontally(-1) || this.f6868O.canScrollHorizontally(1);
    }

    public static void m7120a(WebViewBlockViewImpl webViewBlockViewImpl, String str) {
        if (str != null) {
            try {
                Uri parse = Uri.parse(str);
                if (FacebookUriUtil.f(parse)) {
                    Intent intent = new Intent("android.intent.action.VIEW");
                    intent.setData(parse);
                    intent.putExtra("com.android.browser.headers", WebViewUtils.m7371a());
                    intent.addCategory("android.intent.category.BROWSABLE");
                    intent.setComponent(null);
                    intent.setSelector(null);
                    if (webViewBlockViewImpl.getContext().getPackageManager().resolveActivity(intent, 0) == null) {
                        Object obj = intent.getPackage();
                        if (!StringUtil.a(obj)) {
                            webViewBlockViewImpl.f6884e.a(webViewBlockViewImpl.getContext(), obj);
                            return;
                        }
                    }
                    webViewBlockViewImpl.f6880a.b(intent, webViewBlockViewImpl.getContext());
                    Map hashMap = new HashMap();
                    hashMap.put("webview_type", webViewBlockViewImpl.f6864K);
                    webViewBlockViewImpl.f6885f.m5369b(str, hashMap);
                    webViewBlockViewImpl.f6885f.m5368b(str, "WEBVIEW");
                }
            } catch (Throwable e) {
                webViewBlockViewImpl.f6882c.a(SoftError.a(f6851x + "_startActivityForUrl", "Error trying to launch url:" + str).a(e).g());
            }
        }
    }

    public final float m7141g() {
        if (f6852y.containsKey(this.f6864K)) {
            return ((Float) f6852y.get(this.f6864K)).floatValue();
        }
        if (this.f6878Y && f6853z.containsKey(this.f6864K)) {
            f6853z.get(this.f6864K);
        }
        return -1.0f;
    }

    public static WebViewBlockViewImpl m7118a(View view) {
        return new WebViewBlockViewImpl((FrameLayout) view);
    }

    public final void mo378b(Bundle bundle) {
        super.mo378b(bundle);
        this.aa = true;
        this.f6875V = bundle;
        WebViewPerfInfoLogger webViewPerfInfoLogger = this.f6888i;
        CharSequence charSequence = this.f6866M;
        if (!StringUtil.c(charSequence) && webViewPerfInfoLogger.f5599a.containsKey(charSequence)) {
            WebViewPerfEventInfo webViewPerfEventInfo = (WebViewPerfEventInfo) webViewPerfInfoLogger.f5599a.get(charSequence);
            if (webViewPerfEventInfo.m5418b() && ((float) webViewPerfEventInfo.f5588h) <= 0.0f) {
                webViewPerfEventInfo.f5588h = webViewPerfInfoLogger.f5601c.now();
            }
        }
        if (this.f6864K == GraphQLDocumentWebviewPresentationStyle.AD && this.f6871R != null) {
            this.f6871R.mo378b(bundle);
            this.f6871R.m7079x();
        }
        m7128m(this);
    }

    public final void mo379c(Bundle bundle) {
        super.mo379c(bundle);
        WebViewPerfInfoLogger webViewPerfInfoLogger = this.f6888i;
        CharSequence charSequence = this.f6866M;
        if (!StringUtil.c(charSequence) && webViewPerfInfoLogger.f5599a.containsKey(charSequence)) {
            WebViewPerfEventInfo webViewPerfEventInfo = (WebViewPerfEventInfo) webViewPerfInfoLogger.f5599a.get(charSequence);
            if (webViewPerfEventInfo.m5418b() && ((float) webViewPerfEventInfo.f5589i) <= 0.0f) {
                webViewPerfEventInfo.f5589i = webViewPerfInfoLogger.f5601c.now();
            }
        }
        if (this.f6864K == GraphQLDocumentWebviewPresentationStyle.AD && this.f6871R != null) {
            this.f6871R.mo379c(bundle);
            this.f6871R.m7080y();
        }
        m7127l(this);
        this.aa = false;
    }

    private boolean m7126k() {
        if (this.f6855B && this.f6868O != null && this.f6862I && this.f6867N && this.f6879Z && (this.f6864K != GraphQLDocumentWebviewPresentationStyle.AD || !this.f6857D)) {
            return true;
        }
        return false;
    }

    public static void m7127l(WebViewBlockViewImpl webViewBlockViewImpl) {
        if (webViewBlockViewImpl.m7126k()) {
            webViewBlockViewImpl.f6868O.onPause();
        }
    }

    public static void m7128m(WebViewBlockViewImpl webViewBlockViewImpl) {
        if (webViewBlockViewImpl.m7126k()) {
            webViewBlockViewImpl.f6868O.onResume();
        }
    }

    public static boolean m7124b(GraphQLDocumentNativeAdType graphQLDocumentNativeAdType) {
        return graphQLDocumentNativeAdType == GraphQLDocumentNativeAdType.VIDEO || graphQLDocumentNativeAdType == GraphQLDocumentNativeAdType.APP_VIDEO || graphQLDocumentNativeAdType == GraphQLDocumentNativeAdType.LINK_VIDEO;
    }

    public final void mo374a(Bundle bundle) {
        super.mo374a(bundle);
        this.f6879Z = false;
    }
}
