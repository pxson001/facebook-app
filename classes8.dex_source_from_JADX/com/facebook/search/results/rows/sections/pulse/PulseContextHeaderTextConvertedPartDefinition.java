package com.facebook.search.results.rows.sections.pulse;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.common.util.StringUtil;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.styling.BackgroundPartDefinition;
import com.facebook.feed.rows.styling.BackgroundPartDefinition.StylingData;
import com.facebook.feed.rows.styling.PaddingStyle;
import com.facebook.feed.rows.styling.PaddingStyle.Builder;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.api.ViewType;
import com.facebook.multirow.parts.TextPartDefinition;
import com.facebook.search.results.protocol.pulse.SearchResultsArticleExternalUrlInterfaces.SearchResultsArticleExternalUrl;
import com.facebook.widget.text.BetterTextView;
import javax.inject.Inject;

@ContextScoped
/* compiled from: PRIVATE_INVITED */
public class PulseContextHeaderTextConvertedPartDefinition extends MultiRowSinglePartDefinition<SearchResultsArticleExternalUrl, Void, HasPositionInformation, BetterTextView> {
    public static final ViewType<BetterTextView> f24845a = ViewType.a(2130906513);
    private static final PaddingStyle f24846b;
    private static PulseContextHeaderTextConvertedPartDefinition f24847e;
    private static final Object f24848f = new Object();
    private final BackgroundPartDefinition f24849c;
    private final TextPartDefinition f24850d;

    private static PulseContextHeaderTextConvertedPartDefinition m28219b(InjectorLike injectorLike) {
        return new PulseContextHeaderTextConvertedPartDefinition(BackgroundPartDefinition.a(injectorLike), TextPartDefinition.a(injectorLike));
    }

    public final Object m28221a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        SearchResultsArticleExternalUrl searchResultsArticleExternalUrl = (SearchResultsArticleExternalUrl) obj;
        subParts.a(this.f24849c, new StylingData(f24846b));
        subParts.a(this.f24850d, searchResultsArticleExternalUrl.ax().mo568a());
        return null;
    }

    public final boolean m28222a(Object obj) {
        SearchResultsArticleExternalUrl searchResultsArticleExternalUrl = (SearchResultsArticleExternalUrl) obj;
        return (searchResultsArticleExternalUrl.ax() == null || StringUtil.a(searchResultsArticleExternalUrl.ax().mo568a())) ? false : true;
    }

    static {
        Builder a = Builder.a();
        a.b = -6.0f;
        a = a;
        a.c = -6.0f;
        f24846b = a.i();
    }

    @Inject
    public PulseContextHeaderTextConvertedPartDefinition(BackgroundPartDefinition backgroundPartDefinition, TextPartDefinition textPartDefinition) {
        this.f24849c = backgroundPartDefinition;
        this.f24850d = textPartDefinition;
    }

    public final ViewType<BetterTextView> m28220a() {
        return f24845a;
    }

    public static PulseContextHeaderTextConvertedPartDefinition m28218a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            PulseContextHeaderTextConvertedPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f24848f) {
                PulseContextHeaderTextConvertedPartDefinition pulseContextHeaderTextConvertedPartDefinition;
                if (a2 != null) {
                    pulseContextHeaderTextConvertedPartDefinition = (PulseContextHeaderTextConvertedPartDefinition) a2.a(f24848f);
                } else {
                    pulseContextHeaderTextConvertedPartDefinition = f24847e;
                }
                if (pulseContextHeaderTextConvertedPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m28219b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f24848f, b3);
                        } else {
                            f24847e = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = pulseContextHeaderTextConvertedPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
