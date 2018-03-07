package com.facebook.richdocument.view.block.impl;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.util.StringUtil;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.inject.FbInjector;
import com.facebook.inject.InjectableComponentWithContext;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.richdocument.abtest.ExperimentsForRichDocumentAbtestModule;
import com.facebook.richdocument.ham.HamViewUtils;
import com.facebook.richdocument.logging.RichDocumentAnalyticsLogger;
import com.facebook.richdocument.model.block.RichText;
import com.facebook.richdocument.presenter.RelatedArticlePresenter;
import com.facebook.richdocument.view.block.CustomBackgroundAware;
import com.facebook.richdocument.view.block.RelatedArticleBlockView;
import com.facebook.richdocument.view.util.RichDocumentLayoutDirection;
import com.facebook.richdocument.view.util.WebViewUtils;
import com.facebook.richdocument.view.widget.RichTextView;
import java.util.HashMap;
import java.util.Map;
import javax.inject.Inject;

/* compiled from: page_cta_enabled */
public class RelatedArticleBlockViewImpl extends AbstractBlockView<RelatedArticlePresenter> implements InjectableComponentWithContext, CustomBackgroundAware, RelatedArticleBlockView {
    private static final CallerContext f6771g = CallerContext.a(RelatedArticleBlockViewImpl.class, "unknown");
    @Inject
    SecureContextHelper f6772a;
    @Inject
    RichDocumentAnalyticsLogger f6773b;
    @Inject
    HamViewUtils f6774c;
    @Inject
    RichDocumentLayoutDirection f6775d;
    @Inject
    public GatekeeperStoreImpl f6776e;
    @Inject
    QeAccessor f6777f;
    private final RichTextView f6778h;
    private final RichTextView f6779i;
    private final RichTextView f6780j;
    private final FbDraweeView f6781k;
    private final View f6782l;
    public int f6783m = getContext().getResources().getColor(2131363478);
    public String f6784n;
    public int f6785o;
    public String f6786p;

    public static void m7084a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((RelatedArticleBlockViewImpl) obj).m7082a((SecureContextHelper) DefaultSecureContextHelper.a(fbInjector), RichDocumentAnalyticsLogger.m5360a(fbInjector), HamViewUtils.m5278a(fbInjector), RichDocumentLayoutDirection.m7366a(fbInjector), GatekeeperStoreImplMethodAutoProvider.a(fbInjector), (QeAccessor) QeInternalImplMethodAutoProvider.a(fbInjector));
    }

    public RelatedArticleBlockViewImpl(View view) {
        super(view);
        this.f6778h = (RichTextView) view.findViewById(2131563018);
        this.f6779i = (RichTextView) view.findViewById(2131563017);
        this.f6780j = (RichTextView) view.findViewById(2131563016);
        this.f6781k = (FbDraweeView) view.findViewById(2131563014);
        this.f6782l = view.findViewById(2131563015);
        Class cls = RelatedArticleBlockViewImpl.class;
        m7084a(this, getContext());
        this.f6774c.m5282b(this.f6778h, 2131558648, 0, 0, 0);
        this.f6774c.m5282b(this.f6779i, 2131558648, 0, 0, 2131558729);
        this.f6774c.m5282b(this.f6780j, 2131558648, 0, 0, 2131558683);
        this.f6774c.m5283c(view.findViewById(2131562974), 0, 0, 0, 2131558649);
        if (!RichDocumentLayoutDirection.m7368c()) {
            return;
        }
        if (this.f6775d.m7370b()) {
            iY_().setLayoutDirection(1);
            this.f6778h.f7393d.setGravity(5);
            return;
        }
        iY_().setLayoutDirection(0);
        this.f6778h.f7393d.setGravity(3);
    }

    public static void m7083a(RelatedArticleBlockViewImpl relatedArticleBlockViewImpl, String str, String str2) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(str == null ? null : Uri.parse(str));
        intent.putExtra("extra_instant_articles_id", str2);
        intent.putExtra("com.android.browser.headers", WebViewUtils.m7371a());
        intent.putExtra("extra_instant_articles_referrer", "ia_related_article_block");
        relatedArticleBlockViewImpl.f6772a.b(intent, relatedArticleBlockViewImpl.getContext());
        int a = relatedArticleBlockViewImpl.f6777f.a(ExperimentsForRichDocumentAbtestModule.r, 3);
        Map hashMap = new HashMap();
        if (!StringUtil.c(str2)) {
            hashMap.put("article_ID", str2);
        }
        hashMap.put("ia_source", relatedArticleBlockViewImpl.f6784n);
        hashMap.put("position", Integer.valueOf(relatedArticleBlockViewImpl.f6785o));
        hashMap.put("num_related_articles", Integer.valueOf(a));
        hashMap.put("is_instant_article", Boolean.valueOf(!StringUtil.c(str2)));
        hashMap.put("click_source", "ia_related_article_block");
        relatedArticleBlockViewImpl.f6773b.m5369b(str, hashMap);
        relatedArticleBlockViewImpl.f6773b.m5368b(str, relatedArticleBlockViewImpl.f6784n);
    }

    public final void m7086a(final String str, String str2, RichText richText, RichText richText2, boolean z, final String str3) {
        if (!StringUtil.a(str)) {
            iY_().setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ RelatedArticleBlockViewImpl f6761c;

                public void onClick(View view) {
                    int a = Logger.a(2, EntryType.UI_INPUT_START, -1196118508);
                    RelatedArticleBlockViewImpl.m7083a(this.f6761c, str, str3);
                    Logger.a(2, EntryType.UI_INPUT_END, -1093775608, a);
                }
            });
        }
        this.f6778h.f7393d.setText(richText);
        this.f6778h.f7393d.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ RelatedArticleBlockViewImpl f6764c;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, -894405532);
                RelatedArticleBlockViewImpl.m7083a(this.f6764c, str, str3);
                Logger.a(2, EntryType.UI_INPUT_END, 147069197, a);
            }
        });
        if (richText2 == null || StringUtil.c(richText2.f5641a)) {
            this.f6779i.setVisibility(8);
        } else {
            this.f6779i.setVisibility(0);
            this.f6779i.f7393d.setText(richText2);
            this.f6779i.f7393d.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ RelatedArticleBlockViewImpl f6767c;

                public void onClick(View view) {
                    int a = Logger.a(2, EntryType.UI_INPUT_START, -199580540);
                    RelatedArticleBlockViewImpl.m7083a(this.f6767c, str, str3);
                    Logger.a(2, EntryType.UI_INPUT_END, 931745542, a);
                }
            });
        }
        if (z) {
            this.f6780j.setVisibility(0);
            this.f6780j.f7393d.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ RelatedArticleBlockViewImpl f6770c;

                public void onClick(View view) {
                    int a = Logger.a(2, EntryType.UI_INPUT_START, 2054943320);
                    RelatedArticleBlockViewImpl.m7083a(this.f6770c, str, str3);
                    Logger.a(2, EntryType.UI_INPUT_END, 730689334, a);
                }
            });
        } else {
            this.f6780j.setVisibility(8);
        }
        this.f6781k.setAspectRatio(1.91f);
        this.f6781k.a(str2 == null ? null : Uri.parse(str2), f6771g);
        if (str3 == null || !this.f6776e.a(751, false)) {
            this.f6782l.setVisibility(8);
        } else {
            this.f6782l.setVisibility(0);
        }
    }

    public final int mo383a() {
        return this.f6783m;
    }

    public final void mo378b(Bundle bundle) {
        int a = this.f6777f.a(ExperimentsForRichDocumentAbtestModule.r, 3);
        Map hashMap = new HashMap();
        hashMap.put("num_related_articles", Integer.valueOf(a));
        hashMap.put("ia_source", this.f6784n);
        hashMap.put("position", Integer.valueOf(this.f6785o));
        this.f6773b.m5366a(this.f6786p, hashMap);
    }

    private void m7082a(SecureContextHelper secureContextHelper, RichDocumentAnalyticsLogger richDocumentAnalyticsLogger, HamViewUtils hamViewUtils, RichDocumentLayoutDirection richDocumentLayoutDirection, GatekeeperStoreImpl gatekeeperStoreImpl, QeAccessor qeAccessor) {
        this.f6772a = secureContextHelper;
        this.f6773b = richDocumentAnalyticsLogger;
        this.f6774c = hamViewUtils;
        this.f6775d = richDocumentLayoutDirection;
        this.f6776e = gatekeeperStoreImpl;
        this.f6777f = qeAccessor;
    }
}
