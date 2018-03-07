package com.facebook.search.results.rows.sections.pulse;

import android.content.Context;
import android.view.View;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.HasContext;
import com.facebook.feed.environment.HasInvalidate;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feedplugins.base.footer.DefaultFooterBackgroundPartDefinition;
import com.facebook.feedplugins.base.footer.DefaultFooterBackgroundPartDefinition.Props;
import com.facebook.feedplugins.base.footer.FooterLevel;
import com.facebook.feedplugins.base.footer.ui.Footer;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.api.ViewType;
import com.facebook.search.results.environment.CanReplaceSearchResult;
import com.facebook.search.results.environment.HasSearchResultPosition;
import com.facebook.search.results.environment.HasSearchResultsContext;
import com.facebook.search.results.model.SearchResultsProps;
import com.facebook.search.results.protocol.pulse.SearchResultsArticleExternalUrlInterfaces.SearchResultsArticleExternalUrl;
import javax.inject.Inject;

@ContextScoped
/* compiled from: PROFILE_PILL */
public class PulseContextFooterConvertedPartDefinition<V extends View & Footer, E extends HasSearchResultsContext & HasSearchResultPosition & HasInvalidate & CanReplaceSearchResult & HasContext> extends MultiRowSinglePartDefinition<SearchResultsProps<SearchResultsArticleExternalUrl>, Void, E, V> {
    public static final ViewType f24792a = PulseContextFooterView.f24805a;
    private static PulseContextFooterConvertedPartDefinition f24793d;
    private static final Object f24794e = new Object();
    private final DefaultFooterBackgroundPartDefinition<V> f24795b;
    private final PulseContextFooterButtonsConvertedPartDefinition<E> f24796c;

    private static PulseContextFooterConvertedPartDefinition m28187b(InjectorLike injectorLike) {
        return new PulseContextFooterConvertedPartDefinition(DefaultFooterBackgroundPartDefinition.a(injectorLike), PulseContextFooterButtonsConvertedPartDefinition.m28165a(injectorLike));
    }

    public final Object m28189a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        subParts.a(this.f24796c, (SearchResultsProps) obj);
        subParts.a(this.f24795b, new Props(true, true, true, FooterLevel.TOP, null));
        return null;
    }

    @Inject
    public PulseContextFooterConvertedPartDefinition(DefaultFooterBackgroundPartDefinition defaultFooterBackgroundPartDefinition, PulseContextFooterButtonsConvertedPartDefinition pulseContextFooterButtonsConvertedPartDefinition) {
        this.f24795b = defaultFooterBackgroundPartDefinition;
        this.f24796c = pulseContextFooterButtonsConvertedPartDefinition;
    }

    public final ViewType<V> m28188a() {
        return f24792a;
    }

    public final boolean m28190a(Object obj) {
        return true;
    }

    public static PulseContextFooterConvertedPartDefinition m28186a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            PulseContextFooterConvertedPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f24794e) {
                PulseContextFooterConvertedPartDefinition pulseContextFooterConvertedPartDefinition;
                if (a2 != null) {
                    pulseContextFooterConvertedPartDefinition = (PulseContextFooterConvertedPartDefinition) a2.a(f24794e);
                } else {
                    pulseContextFooterConvertedPartDefinition = f24793d;
                }
                if (pulseContextFooterConvertedPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m28187b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f24794e, b3);
                        } else {
                            f24793d = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = pulseContextFooterConvertedPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
