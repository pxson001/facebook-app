package com.facebook.search.results.rows;

import android.content.Context;
import android.util.TypedValue;
import android.view.View;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.HasContext;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.rows.styling.BackgroundPartDefinition;
import com.facebook.feed.rows.styling.BackgroundPartDefinition.StylingData;
import com.facebook.feed.rows.styling.BackgroundStyler.Position;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.BaseSinglePartDefinition;
import com.facebook.multirow.api.SubParts;
import com.facebook.search.results.model.SearchResultsProps;
import com.google.common.base.Preconditions;
import javax.inject.Inject;

@ContextScoped
/* compiled from: Recent Searches */
public class SearchBackgroundPartDefinition<E extends HasPositionInformation & HasContext> extends BaseSinglePartDefinition<StylingData, Void, E, View> {
    private static SearchBackgroundPartDefinition f23559b;
    private static final Object f23560c = new Object();
    private final BackgroundPartDefinition f23561a;

    private static SearchBackgroundPartDefinition m27226b(InjectorLike injectorLike) {
        return new SearchBackgroundPartDefinition(BackgroundPartDefinition.a(injectorLike));
    }

    public final Object m27227a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        subParts.a(this.f23561a, m27223a((HasContext) ((HasPositionInformation) anyEnvironment), (StylingData) obj));
        return null;
    }

    @Inject
    public SearchBackgroundPartDefinition(BackgroundPartDefinition backgroundPartDefinition) {
        this.f23561a = backgroundPartDefinition;
    }

    public static StylingData m27223a(HasContext hasContext, StylingData stylingData) {
        boolean z = false;
        int i = -1;
        Preconditions.checkArgument(stylingData.c == -1, "innerBackgroundResourceId is already defined");
        if (stylingData.d == -1) {
            z = true;
        }
        Preconditions.checkArgument(z, "touchSelectorResourceId is already defined");
        TypedValue typedValue = new TypedValue();
        hasContext.getContext().getTheme().resolveAttribute(2130773624, typedValue, true);
        if (typedValue.resourceId > 0) {
            i = typedValue.resourceId;
        }
        return new StylingData(stylingData.a, stylingData.b, i, i, stylingData.e);
    }

    public static SearchBackgroundPartDefinition m27225a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            SearchBackgroundPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f23560c) {
                SearchBackgroundPartDefinition searchBackgroundPartDefinition;
                if (a2 != null) {
                    searchBackgroundPartDefinition = (SearchBackgroundPartDefinition) a2.a(f23560c);
                } else {
                    searchBackgroundPartDefinition = f23559b;
                }
                if (searchBackgroundPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m27226b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f23560c, b3);
                        } else {
                            f23559b = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = searchBackgroundPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    public static Position m27224a(SearchResultsProps<?> searchResultsProps, HasPositionInformation hasPositionInformation) {
        return (hasPositionInformation.h() == null && searchResultsProps.m27108f()) ? Position.BOTTOM : Position.MIDDLE;
    }
}
