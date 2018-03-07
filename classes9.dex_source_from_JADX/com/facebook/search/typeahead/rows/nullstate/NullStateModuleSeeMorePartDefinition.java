package com.facebook.search.typeahead.rows.nullstate;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
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
import com.facebook.multirow.parts.ClickListenerPartDefinition;
import com.facebook.multirow.parts.TextPartDefinition;
import com.facebook.search.model.NullStateModuleCollectionUnit;
import com.facebook.search.model.NullStateModuleCollectionUnit.Builder;
import com.facebook.search.model.NullStateSeeMoreTypeaheadUnit;
import com.facebook.search.suggestions.environment.SearchSuggestionsEnvironment;
import com.facebook.search.typeahead.TypeaheadUnitCollection;
import com.facebook.widget.text.BetterTextView;
import javax.inject.Inject;

@ContextScoped
/* compiled from: v2.1 */
public class NullStateModuleSeeMorePartDefinition extends MultiRowSinglePartDefinition<NullStateModuleCollectionUnit, Void, SearchSuggestionsEnvironment, BetterTextView> {
    public static final ViewType f676a = new C00601();
    private static final PaddingStyle f677b;
    private static NullStateModuleSeeMorePartDefinition f678g;
    private static final Object f679h = new Object();
    private final Context f680c;
    private final TextPartDefinition f681d;
    private final ClickListenerPartDefinition f682e;
    private final BackgroundPartDefinition f683f;

    /* compiled from: v2.1 */
    final class C00601 extends ViewType {
        C00601() {
        }

        public final View m765a(Context context) {
            BetterTextView betterTextView = new BetterTextView(context);
            betterTextView.setTextAppearance(context, 2131625911);
            betterTextView.setGravity(17);
            return betterTextView;
        }
    }

    private static NullStateModuleSeeMorePartDefinition m767b(InjectorLike injectorLike) {
        return new NullStateModuleSeeMorePartDefinition((Context) injectorLike.getInstance(Context.class), TextPartDefinition.a(injectorLike), ClickListenerPartDefinition.a(injectorLike), BackgroundPartDefinition.a(injectorLike));
    }

    public final Object m769a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        final NullStateModuleCollectionUnit nullStateModuleCollectionUnit = (NullStateModuleCollectionUnit) obj;
        final SearchSuggestionsEnvironment searchSuggestionsEnvironment = (SearchSuggestionsEnvironment) anyEnvironment;
        subParts.a(this.f681d, this.f680c.getString(2131237488));
        subParts.a(this.f682e, new OnClickListener(this) {
            final /* synthetic */ NullStateModuleSeeMorePartDefinition f675c;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, -2043269816);
                NullStateModuleCollectionUnit nullStateModuleCollectionUnit = nullStateModuleCollectionUnit;
                Builder a2 = new Builder().a(nullStateModuleCollectionUnit.a.name());
                a2.b = nullStateModuleCollectionUnit.b;
                a2 = a2;
                a2.c = nullStateModuleCollectionUnit.c;
                a2 = a2;
                a2.d = nullStateModuleCollectionUnit.d;
                a2 = a2;
                a2.e = nullStateModuleCollectionUnit.f();
                a2 = a2;
                a2.f = nullStateModuleCollectionUnit.f;
                a2 = a2;
                a2.g = true;
                a2 = a2;
                a2.h = nullStateModuleCollectionUnit.h;
                nullStateModuleCollectionUnit = a2.a();
                searchSuggestionsEnvironment.m206a(new NullStateSeeMoreTypeaheadUnit(nullStateModuleCollectionUnit.k()));
                SearchSuggestionsEnvironment searchSuggestionsEnvironment = searchSuggestionsEnvironment;
                NullStateModuleCollectionUnit nullStateModuleCollectionUnit2 = nullStateModuleCollectionUnit;
                TypeaheadUnitCollection typeaheadUnitCollection = searchSuggestionsEnvironment.f115o;
                int indexOf = typeaheadUnitCollection.f422a.indexOf(nullStateModuleCollectionUnit2);
                if (indexOf != -1) {
                    typeaheadUnitCollection.f422a.set(indexOf, nullStateModuleCollectionUnit);
                }
                searchSuggestionsEnvironment.hL_();
                Logger.a(2, EntryType.UI_INPUT_END, -233542364, a);
            }
        });
        subParts.a(this.f683f, new StylingData(f677b));
        return null;
    }

    public final boolean m770a(Object obj) {
        NullStateModuleCollectionUnit nullStateModuleCollectionUnit = (NullStateModuleCollectionUnit) obj;
        return nullStateModuleCollectionUnit.f().size() > nullStateModuleCollectionUnit.f && !nullStateModuleCollectionUnit.g;
    }

    static {
        PaddingStyle.Builder a = PaddingStyle.Builder.a();
        a.c = 2.0f;
        f677b = a.i();
    }

    @Inject
    public NullStateModuleSeeMorePartDefinition(Context context, TextPartDefinition textPartDefinition, ClickListenerPartDefinition clickListenerPartDefinition, BackgroundPartDefinition backgroundPartDefinition) {
        this.f680c = context;
        this.f681d = textPartDefinition;
        this.f682e = clickListenerPartDefinition;
        this.f683f = backgroundPartDefinition;
    }

    public static NullStateModuleSeeMorePartDefinition m766a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            NullStateModuleSeeMorePartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f679h) {
                NullStateModuleSeeMorePartDefinition nullStateModuleSeeMorePartDefinition;
                if (a2 != null) {
                    nullStateModuleSeeMorePartDefinition = (NullStateModuleSeeMorePartDefinition) a2.a(f679h);
                } else {
                    nullStateModuleSeeMorePartDefinition = f678g;
                }
                if (nullStateModuleSeeMorePartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m767b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f679h, b3);
                        } else {
                            f678g = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = nullStateModuleSeeMorePartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    public final ViewType<BetterTextView> m768a() {
        return f676a;
    }
}
