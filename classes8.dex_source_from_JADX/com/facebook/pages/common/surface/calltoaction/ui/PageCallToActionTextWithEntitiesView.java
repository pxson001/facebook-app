package com.facebook.pages.common.surface.calltoaction.ui;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.View;
import com.facebook.content.SecureContextHelper;
import com.facebook.graphql.linkutil.GraphQLLinkExtractor;
import com.facebook.graphql.linkutil.LinkExtractorConverter;
import com.facebook.graphql.querybuilder.common.TextWithEntitiesGraphQLInterfaces.DefaultTextWithEntitiesLongFields;
import com.facebook.graphql.querybuilder.common.TextWithEntitiesGraphQLInterfaces.DefaultTextWithEntitiesLongFields.Ranges;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.Lazy;
import com.facebook.pages.common.surface.calltoaction.ui.PageCallToActionInputFactory.CallToActionFieldLogger;
import com.facebook.pages.common.surface.calltoaction.util.PageCallToActionUtil.PageCallToActionErrorState;
import com.facebook.widget.CustomRelativeLayout;
import com.facebook.widget.text.textwithentitiesview.TextWithEntitiesView;
import com.facebook.widget.text.textwithentitiesview.TextWithEntitiesView.EntityListener;
import javax.inject.Inject;

/* compiled from: could not extract drawable reference from =  */
public class PageCallToActionTextWithEntitiesView extends CustomRelativeLayout implements PageCallToActionInput {
    @Inject
    Lazy<SecureContextHelper> f16872a;
    @Inject
    Lazy<GraphQLLinkExtractor> f16873b;
    TextWithEntitiesView f16874c;

    private static <T extends View> void m20140a(Class<T> cls, T t) {
        m20141a((Object) t, t.getContext());
    }

    private static void m20141a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((PageCallToActionTextWithEntitiesView) obj).m20139a(IdBasedSingletonScopeProvider.b(fbInjector, 968), IdBasedLazy.a(fbInjector, 2189));
    }

    public PageCallToActionTextWithEntitiesView(Context context) {
        super(context);
        m20142f();
    }

    public PageCallToActionTextWithEntitiesView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m20142f();
    }

    public PageCallToActionTextWithEntitiesView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m20142f();
    }

    public View getView() {
        return this;
    }

    public final boolean mo1032a() {
        return false;
    }

    public String getValue() {
        return null;
    }

    public final PageCallToActionErrorState mo1033b() {
        return PageCallToActionErrorState.NONE;
    }

    public final void m20143a(DefaultTextWithEntitiesLongFields defaultTextWithEntitiesLongFields, final CallToActionFieldLogger callToActionFieldLogger) {
        this.f16874c.a(defaultTextWithEntitiesLongFields, new EntityListener(this) {
            final /* synthetic */ PageCallToActionTextWithEntitiesView f16871b;

            public final void m20138a(Ranges ranges) {
                if (ranges != null && ranges.a() != null) {
                    String a = ((GraphQLLinkExtractor) this.f16871b.f16873b.get()).a(LinkExtractorConverter.a(ranges.a()));
                    callToActionFieldLogger.mo1039a(a);
                    Intent intent = new Intent("android.intent.action.VIEW");
                    intent.setData(Uri.parse(a));
                    intent.addFlags(268435456);
                    ((SecureContextHelper) this.f16871b.f16872a.get()).b(intent, this.f16871b.getContext());
                }
            }
        });
    }

    public final void mo1034c() {
    }

    public final void mo1035d() {
    }

    public final void mo1036e() {
    }

    private void m20142f() {
        m20140a(PageCallToActionTextWithEntitiesView.class, (View) this);
        setContentView(2130905990);
        this.f16874c = (TextWithEntitiesView) a(2131565398);
    }

    private void m20139a(Lazy<SecureContextHelper> lazy, Lazy<GraphQLLinkExtractor> lazy2) {
        this.f16872a = lazy;
        this.f16873b = lazy2;
    }
}
