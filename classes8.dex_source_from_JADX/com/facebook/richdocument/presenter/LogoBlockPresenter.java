package com.facebook.richdocument.presenter;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.uri.FbUriIntentHandler;
import com.facebook.common.util.StringUtil;
import com.facebook.fbservice.ops.OperationResultFutureCallback;
import com.facebook.fbservice.service.ServiceException;
import com.facebook.graphql.linkutil.GraphQLLinkExtractor;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.Lazy;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.richdocument.logging.RichDocumentAnalyticsLogger;
import com.facebook.richdocument.model.data.BlockData;
import com.facebook.richdocument.model.data.LogoBlockData;
import com.facebook.richdocument.model.data.impl.LogoBlockDataImpl;
import com.facebook.richdocument.model.graphql.RichDocumentGraphQlInterfaces.FBPage;
import com.facebook.richdocument.model.graphql.RichDocumentGraphQlModels.RichDocumentLogoModel;
import com.facebook.richdocument.utils.UIUtils;
import com.facebook.richdocument.view.block.BlockViewUtil;
import com.facebook.richdocument.view.block.LogoBlockView;
import com.facebook.richdocument.view.block.impl.LogoBlockViewImpl;
import com.facebook.richdocument.view.widget.RichTextUtils;
import com.facebook.ui.futures.TasksManager;
import java.util.HashMap;
import java.util.Map;
import javax.inject.Inject;

/* compiled from: person_card_context_item */
public class LogoBlockPresenter extends AbstractBlockPresenter<LogoBlockView, LogoBlockData> {
    @Inject
    Lazy<FbUriIntentHandler> f6414d;
    @Inject
    Lazy<GraphQLLinkExtractor> f6415e;
    @Inject
    Lazy<TasksManager> f6416f;
    @Inject
    Lazy<PageLikeActionHelper> f6417g;
    @Inject
    Lazy<FbErrorReporter> f6418h;
    @Inject
    Lazy<RichDocumentAnalyticsLogger> f6419i;
    public FBPage f6420j;
    public boolean f6421k;
    private boolean f6422l;
    private String f6423m;

    /* compiled from: person_card_context_item */
    class C07282 implements OnClickListener {
        final /* synthetic */ LogoBlockPresenter f6413a;

        /* compiled from: person_card_context_item */
        class C07271 extends OperationResultFutureCallback {
            final /* synthetic */ C07282 f6412a;

            C07271(C07282 c07282) {
                this.f6412a = c07282;
            }

            protected final void m6802a(Object obj) {
                Map hashMap = new HashMap();
                hashMap.put("interaction", "page_like_tapped");
                hashMap.put("is_page_liked", Boolean.valueOf(this.f6412a.f6413a.f6421k));
                ((RichDocumentAnalyticsLogger) this.f6412a.f6413a.f6419i.get()).m5371c("android_native_article_block_interaction", hashMap);
            }

            protected final void m6801a(ServiceException serviceException) {
                LogoBlockPresenter.m6805b(this.f6412a.f6413a);
            }
        }

        C07282(LogoBlockPresenter logoBlockPresenter) {
            this.f6413a = logoBlockPresenter;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -1482645126);
            LogoBlockPresenter.m6805b(this.f6413a);
            ((TasksManager) this.f6413a.f6416f.get()).a("instant_article_like_page", ((PageLikeActionHelper) this.f6413a.f6417g.get()).m6820a(this.f6413a.f6421k, this.f6413a.f6420j.mo312d()), new C07271(this));
            Logger.a(2, EntryType.UI_INPUT_END, 934904931, a);
        }
    }

    public static void m6804a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((LogoBlockPresenter) obj).m6803a(IdBasedSingletonScopeProvider.b(fbInjector, 616), IdBasedLazy.a(fbInjector, 2189), IdBasedLazy.a(fbInjector, 3561), IdBasedLazy.a(fbInjector, 10345), IdBasedSingletonScopeProvider.b(fbInjector, 494), IdBasedLazy.a(fbInjector, 10334));
    }

    public final void mo366a(BlockData blockData) {
        LogoBlockDataImpl logoBlockDataImpl = (LogoBlockDataImpl) blockData;
        ((LogoBlockViewImpl) this.f6382d).mo374a(null);
        this.f6423m = logoBlockDataImpl.mo271l();
        RichDocumentLogoModel richDocumentLogoModel = logoBlockDataImpl.f5730a;
        int color = getContext().getResources().getColor(2131363463);
        if (richDocumentLogoModel == null) {
            ((LogoBlockViewImpl) this.f6382d).m7015a(null, 0);
        } else {
            LogoBlockViewImpl logoBlockViewImpl = (LogoBlockViewImpl) this.f6382d;
            String ii_ = richDocumentLogoModel.ii_();
            int g = richDocumentLogoModel.m6042g();
            richDocumentLogoModel.m6041d();
            logoBlockViewImpl.m7015a(ii_, g);
            if (richDocumentLogoModel.ii_() == null) {
                ((AbstractFbErrorReporter) this.f6418h.get()).a("instant_articles", "IA Logo URL is invalid");
            }
            if (!StringUtil.c(richDocumentLogoModel.m6039b())) {
                UIUtils.m6864a(((LogoBlockViewImpl) this.f6382d).iY_(), RichTextUtils.m1353a(richDocumentLogoModel.m6039b()));
            }
            int a = RichTextUtils.m1353a(richDocumentLogoModel.m6040c());
            if (StringUtil.c(richDocumentLogoModel.m6039b()) && a == 0) {
                color = getContext().getResources().getColor(2131363464);
            } else {
                color = a;
            }
            logoBlockViewImpl = (LogoBlockViewImpl) this.f6382d;
            int a2 = RichTextUtils.m1353a(richDocumentLogoModel.m6037a());
            BlockViewUtil.m6920a(logoBlockViewImpl.f6675j, a2, a2);
        }
        UIUtils.m6864a(((LogoBlockViewImpl) this.f6382d).f6676k, color);
        this.f6420j = logoBlockDataImpl.f5731b;
        if (this.f6420j != null) {
            this.f6415e.get();
            ii_ = GraphQLLinkExtractor.a(2479791, new Object[]{this.f6420j.mo312d()});
            ((LogoBlockViewImpl) this.f6382d).f6674i.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ LogoBlockPresenter f6411b;

                public void onClick(View view) {
                    int a = Logger.a(2, EntryType.UI_INPUT_START, -1041914831);
                    if (ii_ != null) {
                        ((FbUriIntentHandler) this.f6411b.f6414d.get()).a(this.f6411b.getContext(), ii_);
                    }
                    Logger.a(2, EntryType.UI_INPUT_END, -1350068417, a);
                }
            });
            this.f6421k = this.f6420j.mo311c();
            boolean z = this.f6420j.mo310b() && !this.f6421k;
            this.f6422l = z;
            if (!this.f6421k) {
                ((LogoBlockViewImpl) this.f6382d).m7016a(this.f6420j.mo310b(), this.f6421k);
                ((LogoBlockViewImpl) this.f6382d).f6675j.setOnClickListener(new C07282(this));
            }
        }
    }

    public LogoBlockPresenter(LogoBlockViewImpl logoBlockViewImpl) {
        super(logoBlockViewImpl);
        Class cls = LogoBlockPresenter.class;
        m6804a(this, getContext());
    }

    public final void mo367a(Bundle bundle) {
        Map hashMap = new HashMap();
        hashMap.put("block_type", "logo");
        hashMap.put("is_page_like_button_shown", Boolean.valueOf(this.f6422l));
        ((RichDocumentAnalyticsLogger) this.f6419i.get()).m5366a(this.f6423m, hashMap);
    }

    public static void m6805b(LogoBlockPresenter logoBlockPresenter) {
        logoBlockPresenter.f6421k = !logoBlockPresenter.f6421k;
        ((LogoBlockViewImpl) logoBlockPresenter.f6382d).m7016a(logoBlockPresenter.f6420j.mo310b(), logoBlockPresenter.f6421k);
    }

    private void m6803a(Lazy<FbUriIntentHandler> lazy, Lazy<GraphQLLinkExtractor> lazy2, Lazy<TasksManager> lazy3, Lazy<PageLikeActionHelper> lazy4, Lazy<FbErrorReporter> lazy5, Lazy<RichDocumentAnalyticsLogger> lazy6) {
        this.f6414d = lazy;
        this.f6415e = lazy2;
        this.f6416f = lazy3;
        this.f6417g = lazy4;
        this.f6418h = lazy5;
        this.f6419i = lazy6;
    }
}
