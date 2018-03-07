package com.facebook.richdocument.presenter;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.util.DisplayMetrics;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.util.StringUtil;
import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.gk.store.GatekeeperStore;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.graphql.enums.GraphQLDocumentWebviewPresentationStyle;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.qe.api.QeAccessor;
import com.facebook.richdocument.RichDocumentInfo;
import com.facebook.richdocument.abtest.ExperimentsForRichDocumentAbtestModule;
import com.facebook.richdocument.ham.HamDimensions;
import com.facebook.richdocument.model.data.WebViewBlockData;
import com.facebook.richdocument.model.data.impl.WebViewBlockDataImpl;
import com.facebook.richdocument.view.block.WebViewBlockView;
import com.facebook.richdocument.view.block.impl.WebViewBlockViewImpl;
import com.facebook.richdocument.view.recycler.RichDocumentLayoutManager.SingleBind;
import com.facebook.richdocument.view.util.WebViewUtils;
import com.facebook.richdocument.view.widget.IAWebView;
import com.facebook.richdocument.view.widget.WebViewLoader.LoadPriority;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;

/* compiled from: people_tag_suggestions_fetch */
public class WebViewBlockPresenter extends AbstractBlockPresenter<WebViewBlockView, WebViewBlockData> implements SingleBind {
    @Inject
    WebViewUtils f6455d;
    @Inject
    Lazy<QeAccessor> f6456e;
    @Inject
    Lazy<RichDocumentInfo> f6457f;
    @Inject
    GatekeeperStoreImpl f6458g;
    @Inject
    HamDimensions f6459h;
    private final boolean f6460i;
    public final List<Runnable> f6461j = new ArrayList();
    public boolean f6462k;

    public static void m6836a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        ((WebViewBlockPresenter) obj).m6835a(WebViewUtils.m7372a(injectorLike), IdBasedSingletonScopeProvider.b(injectorLike, 3219), IdBasedLazy.a(injectorLike, 10295), GatekeeperStoreImplMethodAutoProvider.a(injectorLike), HamDimensions.m5268a(injectorLike));
    }

    public final void m6843e() {
        WebViewBlockViewImpl webViewBlockViewImpl = (WebViewBlockViewImpl) this.f6382d;
        webViewBlockViewImpl.f6887h.m7777a(webViewBlockViewImpl.f6868O);
        WebViewUtils.m7377b(webViewBlockViewImpl.f6868O);
    }

    public WebViewBlockPresenter(WebViewBlockViewImpl webViewBlockViewImpl) {
        boolean z;
        super(webViewBlockViewImpl);
        Class cls = WebViewBlockPresenter.class;
        m6836a(this, getContext());
        if (this.f6458g.a(683, false)) {
            this.f6460i = true;
        } else {
            this.f6460i = ((QeAccessor) this.f6456e.get()).a(ExperimentsForRichDocumentAbtestModule.m, false);
        }
        if (webViewBlockViewImpl instanceof WebViewBlockViewImpl) {
            webViewBlockViewImpl = webViewBlockViewImpl;
        } else {
            webViewBlockViewImpl = null;
        }
        if (!this.f6460i || r6 == null || r6.f6867N) {
            z = false;
        } else {
            z = true;
        }
        this.f6462k = z;
    }

    public final void m6839a(final WebViewBlockDataImpl webViewBlockDataImpl) {
        if (this.f6462k) {
            this.f6461j.add(new Runnable(this) {
                final /* synthetic */ WebViewBlockPresenter f6450b;

                public void run() {
                    this.f6450b.m6839a(webViewBlockDataImpl);
                }
            });
            return;
        }
        int a;
        String str = webViewBlockDataImpl.f5797a;
        String str2 = webViewBlockDataImpl.f5798b;
        GraphQLDocumentWebviewPresentationStyle graphQLDocumentWebviewPresentationStyle = webViewBlockDataImpl.f5803g;
        if (graphQLDocumentWebviewPresentationStyle == GraphQLDocumentWebviewPresentationStyle.AD) {
            a = PresenterUtils.m6821a(webViewBlockDataImpl.f5800d, getContext());
        } else {
            a = 0;
        }
        ((WebViewBlockViewImpl) this.f6382d).m7131a(graphQLDocumentWebviewPresentationStyle);
        LoadPriority loadPriority = graphQLDocumentWebviewPresentationStyle == GraphQLDocumentWebviewPresentationStyle.AD ? LoadPriority.BYPASS_LIMITS : LoadPriority.NORMAL;
        String l = webViewBlockDataImpl.mo271l();
        Uri parse = StringUtil.c(str) ? null : Uri.parse(str);
        int i = webViewBlockDataImpl.f5801e;
        int i2 = webViewBlockDataImpl.f5800d;
        if (!StringUtil.a(str2)) {
            ((WebViewBlockViewImpl) this.f6382d).m7136a(l, webViewBlockDataImpl.f5799c, str2, a, loadPriority);
        } else if (StringUtil.a(str) || !this.f6455d.m7379a(parse)) {
            ((WebViewBlockViewImpl) this.f6382d).m7135a(l, str, a, loadPriority);
        } else {
            boolean a2 = this.f6455d.m7380a(graphQLDocumentWebviewPresentationStyle, webViewBlockDataImpl.f5804h);
            DisplayMetrics displayMetrics = getContext().getResources().getDisplayMetrics();
            int i3 = displayMetrics.widthPixels;
            int b = i3 - (this.f6459h.m5276b(2131558653) * 2);
            if (!a2) {
                i3 = b;
            }
            b = Math.round(((float) i3) / displayMetrics.density);
            if (i > b || (a2 && i > 0 && i < b)) {
                i3 = i2 > 0 ? (int) Math.ceil((double) (((float) b) / (((float) i) / ((float) i2)))) : i2;
            } else {
                i3 = i2;
                b = i;
            }
            if (i > 0 && i2 > 0) {
                str2 = StringFormatUtil.a("<html><body style=\"margin:0\"><iframe src=\"%s\" width=\"%d\" height=\"%d\" frameborder=\"0\"/></body></html>", new Object[]{str, Integer.valueOf(b), Integer.valueOf(i3)});
            } else if (i > 0) {
                str2 = StringFormatUtil.a("<html><body style=\"margin:0\"><iframe src=\"%s\" width=\"%d\" frameborder=\"0\"/></body></html>", new Object[]{str, Integer.valueOf(b)});
            } else if (i2 > 0) {
                str2 = StringFormatUtil.a("<html><body style=\"margin:0\"><iframe src=\"%s\" height=\"%d\" width=\"100%%\" frameborder=\"0\"/></body></html>", new Object[]{str, Integer.valueOf(i3)});
            } else {
                str2 = StringFormatUtil.a("<html><body style=\"margin:0\"><iframe src=\"%s\" width=\"100%%\" frameborder=\"0\"/></body></html>", new Object[]{str});
            }
            ((WebViewBlockViewImpl) this.f6382d).m7136a(l, parse == null ? "" : parse.toString(), str2, 0, loadPriority);
        }
        if (graphQLDocumentWebviewPresentationStyle == GraphQLDocumentWebviewPresentationStyle.AD) {
            ((WebViewBlockViewImpl) this.f6382d).m7138b(webViewBlockDataImpl.f5800d, webViewBlockDataImpl.f5801e);
            ((WebViewBlockViewImpl) this.f6382d).f6865L = webViewBlockDataImpl.f5805i;
        }
        PresenterUtils.m6823a(this.f6382d, webViewBlockDataImpl, ((RichDocumentInfo) this.f6457f.get()).f5119g, webViewBlockDataImpl.iQ_());
    }

    public final void mo371b(final Bundle bundle) {
        if (this.f6462k) {
            this.f6461j.add(new Runnable(this) {
                final /* synthetic */ WebViewBlockPresenter f6452b;

                public void run() {
                    this.f6452b.mo371b(bundle);
                }
            });
            return;
        }
        super.mo371b(bundle);
        IAWebView iAWebView = ((WebViewBlockViewImpl) this.f6382d).f6868O;
        int i = iAWebView.getLayoutParams().height;
        if (i == -2 || i <= 0) {
            if (iAWebView.f7186p > 0) {
                i = iAWebView.f7186p;
            } else if (iAWebView.f7180j > 0.0f) {
                i = (int) (((float) iAWebView.getMeasuredWidth()) / iAWebView.f7180j);
            } else {
                i = 0;
            }
        }
        int i2 = i;
        if (i2 > 0) {
            bundle.putInt("extra_webview_height", i2);
        } else {
            bundle.remove("extra_webview_height");
        }
    }

    public final void mo367a(final Bundle bundle) {
        if (this.f6462k) {
            this.f6461j.add(new Runnable(this) {
                final /* synthetic */ WebViewBlockPresenter f6454b;

                public void run() {
                    this.f6454b.mo367a(bundle);
                }
            });
            return;
        }
        super.mo367a(bundle);
        int i = bundle.getInt("extra_webview_height", 0);
        if (i > 0) {
            WebViewBlockViewImpl webViewBlockViewImpl = (WebViewBlockViewImpl) this.f6382d;
            if (webViewBlockViewImpl.f6868O == null) {
                webViewBlockViewImpl.f6863J = i;
            } else {
                IAWebView iAWebView = webViewBlockViewImpl.f6868O;
                iAWebView.f7178h.m7443a();
                iAWebView.getLayoutParams().height = i;
                iAWebView.setLayoutParams(iAWebView.getLayoutParams());
            }
        }
    }

    private void m6835a(WebViewUtils webViewUtils, Lazy<QeAccessor> lazy, Lazy<RichDocumentInfo> lazy2, GatekeeperStore gatekeeperStore, HamDimensions hamDimensions) {
        this.f6455d = webViewUtils;
        this.f6456e = lazy;
        this.f6457f = lazy2;
        this.f6458g = gatekeeperStore;
        this.f6459h = hamDimensions;
    }

    public final boolean mo369b() {
        return true;
    }

    public final boolean mo370c() {
        return true;
    }
}
