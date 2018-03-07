package com.facebook.search.results.rows.sections.videos;

import android.content.Context;
import android.content.res.Resources;
import android.widget.TextView;
import com.facebook.common.numbers.NumberTruncationUtil;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.common.timeformat.DefaultTimeFormatUtil;
import com.facebook.common.timeformat.TimeFormatUtil;
import com.facebook.common.timeformat.TimeFormatUtil.TimeFormatStyle;
import com.facebook.feed.environment.HasContext;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.BaseSinglePartDefinition;
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.parts.TextPartDefinition;
import com.facebook.search.results.model.SearchResultsProps;
import com.facebook.search.results.protocol.video.SearchResultsVideoInterfaces.SearchResultsVideo;
import java.util.Locale;
import javax.inject.Inject;

@ContextScoped
/* compiled from: PLACE_PICKER */
public class SearchResultsVideoMetaTextPartDefinition extends BaseSinglePartDefinition<SearchResultsProps<SearchResultsVideo>, Void, HasContext, TextView> {
    private static SearchResultsVideoMetaTextPartDefinition f25202d;
    private static final Object f25203e = new Object();
    private final TextPartDefinition f25204a;
    private final NumberTruncationUtil f25205b;
    private final TimeFormatUtil f25206c;

    private static SearchResultsVideoMetaTextPartDefinition m28472b(InjectorLike injectorLike) {
        return new SearchResultsVideoMetaTextPartDefinition(TextPartDefinition.a(injectorLike), NumberTruncationUtil.a(injectorLike), (TimeFormatUtil) DefaultTimeFormatUtil.a(injectorLike));
    }

    public final Object m28473a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        HasContext hasContext = (HasContext) anyEnvironment;
        subParts.a(this.f25204a, m28471a((SearchResultsVideo) ((SearchResultsProps) obj).f23388a, hasContext));
        return null;
    }

    @Inject
    public SearchResultsVideoMetaTextPartDefinition(TextPartDefinition textPartDefinition, NumberTruncationUtil numberTruncationUtil, TimeFormatUtil timeFormatUtil) {
        this.f25204a = textPartDefinition;
        this.f25205b = numberTruncationUtil;
        this.f25206c = timeFormatUtil;
    }

    private CharSequence m28471a(SearchResultsVideo searchResultsVideo, HasContext hasContext) {
        Resources resources = hasContext.getContext().getResources();
        CharSequence a = this.f25206c.a(TimeFormatStyle.SHORT_DATE_STYLE, searchResultsVideo.mo590o() * 1000);
        int ad = searchResultsVideo.ad();
        if (ad <= 0) {
            return a;
        }
        String quantityString = resources.getQuantityString(2131689718, ad, new Object[]{this.f25205b.a(ad, 0).toUpperCase(Locale.US)});
        return resources.getString(2131239056, new Object[]{a, quantityString});
    }

    public static SearchResultsVideoMetaTextPartDefinition m28470a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            SearchResultsVideoMetaTextPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f25203e) {
                SearchResultsVideoMetaTextPartDefinition searchResultsVideoMetaTextPartDefinition;
                if (a2 != null) {
                    searchResultsVideoMetaTextPartDefinition = (SearchResultsVideoMetaTextPartDefinition) a2.a(f25203e);
                } else {
                    searchResultsVideoMetaTextPartDefinition = f25202d;
                }
                if (searchResultsVideoMetaTextPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m28472b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f25203e, b3);
                        } else {
                            f25202d = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = searchResultsVideoMetaTextPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
