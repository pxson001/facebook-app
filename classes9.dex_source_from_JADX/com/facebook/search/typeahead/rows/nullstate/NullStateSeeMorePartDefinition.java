package com.facebook.search.typeahead.rows.nullstate;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.styling.BackgroundPartDefinition.StylingData;
import com.facebook.feed.rows.styling.PaddingStyle;
import com.facebook.feed.rows.styling.PaddingStyle.Builder;
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
import com.facebook.multirow.parts.ClickListenerPartDefinition;
import com.facebook.multirow.parts.TextPartDefinition;
import com.facebook.search.model.NullStateSeeMoreTypeaheadUnit;
import com.facebook.search.results.rows.SearchBackgroundPartDefinition;
import com.facebook.search.suggestions.environment.CanVisitTypeaheadSuggestion;
import com.facebook.search.suggestions.environment.SearchSuggestionsEnvironment;
import com.facebook.widget.text.BetterTextView;
import javax.inject.Inject;

@ContextScoped
/* compiled from: users-named( */
public class NullStateSeeMorePartDefinition<E extends CanVisitTypeaheadSuggestion & HasPositionInformation> extends MultiRowSinglePartDefinition<NullStateSeeMoreTypeaheadUnit, Void, E, BetterTextView> {
    private static final PaddingStyle f694a;
    private static NullStateSeeMorePartDefinition f695f;
    private static final Object f696g = new Object();
    private final Context f697b;
    private final TextPartDefinition f698c;
    private final ClickListenerPartDefinition f699d;
    private final SearchBackgroundPartDefinition f700e;

    private static NullStateSeeMorePartDefinition m778b(InjectorLike injectorLike) {
        return new NullStateSeeMorePartDefinition((Context) injectorLike.getInstance(Context.class), TextPartDefinition.a(injectorLike), ClickListenerPartDefinition.a(injectorLike), SearchBackgroundPartDefinition.a(injectorLike));
    }

    public final Object m780a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        final NullStateSeeMoreTypeaheadUnit nullStateSeeMoreTypeaheadUnit = (NullStateSeeMoreTypeaheadUnit) obj;
        final SearchSuggestionsEnvironment searchSuggestionsEnvironment = (SearchSuggestionsEnvironment) anyEnvironment;
        subParts.a(this.f698c, this.f697b.getString(2131237488));
        subParts.a(this.f699d, new OnClickListener(this) {
            final /* synthetic */ NullStateSeeMorePartDefinition f693c;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, -154043253);
                searchSuggestionsEnvironment.m206a(nullStateSeeMoreTypeaheadUnit);
                Logger.a(2, EntryType.UI_INPUT_END, -1839330852, a);
            }
        });
        subParts.a(this.f700e, new StylingData(f694a));
        return null;
    }

    static {
        Builder c = Builder.c();
        c.b = -4.0f;
        f694a = c.i();
    }

    @Inject
    public NullStateSeeMorePartDefinition(Context context, TextPartDefinition textPartDefinition, ClickListenerPartDefinition clickListenerPartDefinition, SearchBackgroundPartDefinition searchBackgroundPartDefinition) {
        this.f697b = context;
        this.f698c = textPartDefinition;
        this.f699d = clickListenerPartDefinition;
        this.f700e = searchBackgroundPartDefinition;
    }

    public final ViewType<BetterTextView> m779a() {
        return NullStateModuleSeeMorePartDefinition.f676a;
    }

    public final boolean m781a(Object obj) {
        return true;
    }

    public static NullStateSeeMorePartDefinition m777a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            NullStateSeeMorePartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f696g) {
                NullStateSeeMorePartDefinition nullStateSeeMorePartDefinition;
                if (a2 != null) {
                    nullStateSeeMorePartDefinition = (NullStateSeeMorePartDefinition) a2.a(f696g);
                } else {
                    nullStateSeeMorePartDefinition = f695f;
                }
                if (nullStateSeeMorePartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m778b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f696g, b3);
                        } else {
                            f695f = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = nullStateSeeMorePartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
