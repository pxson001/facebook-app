package com.facebook.richdocument.model.block.entity;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextPaint;
import android.view.View;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.errorreporting.SoftError;
import com.facebook.common.util.FacebookUriUtil;
import com.facebook.common.util.StringUtil;
import com.facebook.graphql.enums.GraphQLUnderlineStyle;
import com.facebook.inject.FbInjector;
import com.facebook.richdocument.logging.RichDocumentAnalyticsLogger;
import com.facebook.richdocument.model.graphql.RichDocumentGraphQlModels.RichDocumentLinkStyleModel;
import com.facebook.richdocument.model.graphql.RichDocumentGraphQlModels.RichDocumentStyleModel;
import com.facebook.richdocument.model.graphql.RichDocumentGraphQlModels.RichDocumentTextModel.EntityRangesModel.EntityModel;
import com.facebook.richdocument.view.util.WebViewUtils;
import com.facebook.richdocument.view.widget.RichTextUtils;
import java.util.HashMap;
import java.util.Map;
import javax.inject.Inject;

/* compiled from: picker_new_media_count */
public class LinkEntity extends BaseEntity {
    private static final String f5661e = LinkEntity.class.getSimpleName();
    @Inject
    public RichDocumentAnalyticsLogger f5662c;
    @Inject
    public AbstractFbErrorReporter f5663d;
    private final RichDocumentStyleModel f5664f;
    public boolean f5665g;
    private int f5666h;
    private int f5667i;

    public static void m5456a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        LinkEntity linkEntity = (LinkEntity) obj;
        RichDocumentAnalyticsLogger a = RichDocumentAnalyticsLogger.m5360a(fbInjector);
        AbstractFbErrorReporter abstractFbErrorReporter = (AbstractFbErrorReporter) FbErrorReporterImpl.a(fbInjector);
        linkEntity.f5662c = a;
        linkEntity.f5663d = abstractFbErrorReporter;
    }

    public LinkEntity(RichDocumentStyleModel richDocumentStyleModel, EntityModel entityModel, Context context) {
        super(entityModel, context);
        Class cls = LinkEntity.class;
        m5456a(this, getContext());
        this.f5664f = richDocumentStyleModel;
        this.f5667i = context.getResources().getColor(2131363479);
    }

    public void updateDrawState(TextPaint textPaint) {
        boolean z = true;
        int i = textPaint.linkColor;
        if (!(this.f5664f == null || this.f5664f.m6365v() == null)) {
            RichDocumentLinkStyleModel v = this.f5664f.m6365v();
            if (!StringUtil.c(v.m5964a())) {
                i = RichTextUtils.m1353a(v.m5964a());
            }
            if (v.m5966c() != GraphQLUnderlineStyle.SIMPLE_UNDERLINE) {
                z = false;
            }
        }
        textPaint.setColor(i);
        textPaint.setUnderlineText(z);
        if (textPaint.bgColor != this.f5667i) {
            this.f5666h = textPaint.bgColor;
        }
        textPaint.bgColor = this.f5665g ? this.f5667i : this.f5666h;
    }

    public void onClick(View view) {
        CharSequence b;
        String B = this.f5658a.m6391B();
        if (this.f5658a.m6418z().g() == 1607392245) {
            b = this.f5658a.mo315b();
        } else {
            b = null;
        }
        if (B != null || !StringUtil.c(b)) {
            Intent intent = new Intent("android.intent.action.VIEW");
            if (B != null) {
                Uri parse = Uri.parse(B);
                if (FacebookUriUtil.f(parse)) {
                    intent.setData(parse);
                } else {
                    return;
                }
            }
            intent.putExtra("com.android.browser.headers", WebViewUtils.m7371a());
            intent.addCategory("android.intent.category.BROWSABLE");
            intent.setComponent(null);
            intent.setSelector(null);
            intent.putExtra("extra_instant_articles_id", b);
            intent.putExtra("extra_instant_articles_referrer", "instant_article_link_entity");
            try {
                Map hashMap = new HashMap();
                if (!StringUtil.c(b)) {
                    hashMap.put("article_ID", b);
                }
                this.f5662c.m5369b(B, hashMap);
                this.f5662c.m5368b(B, "native_article_text_block");
                this.f5659b.b(intent, getContext());
            } catch (Throwable e) {
                this.f5663d.a(SoftError.a(f5661e + "_onClick", "Error trying to launch url:" + B).a(e).g());
            }
        }
    }
}
