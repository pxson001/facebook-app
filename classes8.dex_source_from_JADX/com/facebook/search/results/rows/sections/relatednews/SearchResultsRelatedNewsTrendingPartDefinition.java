package com.facebook.search.results.rows.sections.relatednews;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.SpannableStringBuilder;
import android.text.style.ImageSpan;
import android.view.View;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.common.timeformat.DefaultTimeFormatUtil;
import com.facebook.common.timeformat.TimeFormatUtil;
import com.facebook.common.timeformat.TimeFormatUtil.TimeFormatStyle;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.styling.BackgroundPartDefinition;
import com.facebook.feed.rows.styling.BackgroundPartDefinition.StylingData;
import com.facebook.feed.rows.styling.PaddingStyle;
import com.facebook.feed.rows.styling.PaddingStyle.Builder;
import com.facebook.graphql.model.GraphQLNode;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.api.ViewType;
import com.facebook.search.results.rows.sections.common.SearchResultsCommonViewTypes;
import com.facebook.widget.text.BetterTextView;
import javax.inject.Inject;

@ContextScoped
/* compiled from: PREVIOUS */
public class SearchResultsRelatedNewsTrendingPartDefinition extends MultiRowSinglePartDefinition<GraphQLNode, SpannableStringBuilder, HasPositionInformation, BetterTextView> {
    private static final PaddingStyle f24961a;
    public static final CharSequence f24962b = "[trending]";
    private static SearchResultsRelatedNewsTrendingPartDefinition f24963f;
    private static final Object f24964g = new Object();
    private final BackgroundPartDefinition f24965c;
    public final TimeFormatUtil f24966d;
    public final Resources f24967e;

    private static SearchResultsRelatedNewsTrendingPartDefinition m28309b(InjectorLike injectorLike) {
        return new SearchResultsRelatedNewsTrendingPartDefinition(BackgroundPartDefinition.a(injectorLike), DefaultTimeFormatUtil.a(injectorLike), ResourcesMethodAutoProvider.a(injectorLike));
    }

    public final Object m28311a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        GraphQLNode graphQLNode = (GraphQLNode) obj;
        subParts.a(this.f24965c, new StylingData(f24961a));
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(f24962b);
        GraphQLNode iw = graphQLNode.iw();
        spannableStringBuilder.append("   ").append(this.f24966d.a(TimeFormatStyle.EVENTS_RELATIVE_DATE_STYLE, (iw != null ? iw.bw() : 0) * 1000));
        Drawable drawable = this.f24967e.getDrawable(2130843759);
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        spannableStringBuilder.setSpan(new ImageSpan(drawable), 0, f24962b.length(), 17);
        return spannableStringBuilder;
    }

    public final /* bridge */ /* synthetic */ void m28312a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, -2062672655);
        SpannableStringBuilder spannableStringBuilder = (SpannableStringBuilder) obj2;
        BetterTextView betterTextView = (BetterTextView) view;
        betterTextView.setTextAppearance(betterTextView.getContext(), 2131625898);
        betterTextView.setText(spannableStringBuilder);
        Logger.a(8, EntryType.MARK_POP, -1399819877, a);
    }

    public final boolean m28313a(Object obj) {
        GraphQLNode iw = ((GraphQLNode) obj).iw();
        return iw != null && iw.bw() > 0;
    }

    static {
        Builder a = Builder.a();
        a.b = -6.0f;
        a = a;
        a.c = 6.0f;
        f24961a = a.i();
    }

    @Inject
    public SearchResultsRelatedNewsTrendingPartDefinition(BackgroundPartDefinition backgroundPartDefinition, DefaultTimeFormatUtil defaultTimeFormatUtil, Resources resources) {
        this.f24965c = backgroundPartDefinition;
        this.f24966d = defaultTimeFormatUtil;
        this.f24967e = resources;
    }

    public final ViewType m28310a() {
        return SearchResultsCommonViewTypes.f24003a;
    }

    public static SearchResultsRelatedNewsTrendingPartDefinition m28308a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            SearchResultsRelatedNewsTrendingPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f24964g) {
                SearchResultsRelatedNewsTrendingPartDefinition searchResultsRelatedNewsTrendingPartDefinition;
                if (a2 != null) {
                    searchResultsRelatedNewsTrendingPartDefinition = (SearchResultsRelatedNewsTrendingPartDefinition) a2.a(f24964g);
                } else {
                    searchResultsRelatedNewsTrendingPartDefinition = f24963f;
                }
                if (searchResultsRelatedNewsTrendingPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m28309b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f24964g, b3);
                        } else {
                            f24963f = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = searchResultsRelatedNewsTrendingPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
