package com.facebook.search.results.rows.sections.unsupported;

import android.content.Context;
import android.view.View;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.styling.BackgroundPartDefinition;
import com.facebook.feed.rows.styling.BackgroundPartDefinition.StylingData;
import com.facebook.feed.rows.styling.PaddingStyle;
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
import com.facebook.search.results.model.unit.SearchResultsUnsupportedFeedUnit;
import com.facebook.search.results.rows.sections.common.SearchResultsCommonViewTypes;
import com.facebook.widget.text.BetterTextView;
import javax.inject.Inject;

@ContextScoped
/* compiled from: PORTRAIT */
public class UnsupportedModulePartDefinition extends MultiRowSinglePartDefinition<FeedProps<SearchResultsUnsupportedFeedUnit>, Void, HasPositionInformation, BetterTextView> {
    public static final ViewType f25109a = SearchResultsCommonViewTypes.f24003a;
    private static UnsupportedModulePartDefinition f25110c;
    private static final Object f25111d = new Object();
    private final BackgroundPartDefinition f25112b;

    private static UnsupportedModulePartDefinition m28406b(InjectorLike injectorLike) {
        return new UnsupportedModulePartDefinition(BackgroundPartDefinition.a(injectorLike));
    }

    public final Object m28408a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        subParts.a(this.f25112b, new StylingData((FeedProps) obj, PaddingStyle.a));
        return null;
    }

    public final /* bridge */ /* synthetic */ void m28409a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, 2077569846);
        BetterTextView betterTextView = (BetterTextView) view;
        SearchResultsUnsupportedFeedUnit searchResultsUnsupportedFeedUnit = (SearchResultsUnsupportedFeedUnit) ((FeedProps) obj).a;
        betterTextView.setGravity(17);
        betterTextView.setText(searchResultsUnsupportedFeedUnit.f23549a);
        Logger.a(8, EntryType.MARK_POP, 436073112, a);
    }

    @Inject
    public UnsupportedModulePartDefinition(BackgroundPartDefinition backgroundPartDefinition) {
        this.f25112b = backgroundPartDefinition;
    }

    public final ViewType m28407a() {
        return f25109a;
    }

    public static UnsupportedModulePartDefinition m28405a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            UnsupportedModulePartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f25111d) {
                UnsupportedModulePartDefinition unsupportedModulePartDefinition;
                if (a2 != null) {
                    unsupportedModulePartDefinition = (UnsupportedModulePartDefinition) a2.a(f25111d);
                } else {
                    unsupportedModulePartDefinition = f25110c;
                }
                if (unsupportedModulePartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m28406b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f25111d, b3);
                        } else {
                            f25110c = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = unsupportedModulePartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    public final boolean m28410a(Object obj) {
        return true;
    }
}
