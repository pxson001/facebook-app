package com.facebook.search.typeahead.rows;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.common.util.FindViewUtil;
import com.facebook.common.util.StringLocaleUtil;
import com.facebook.fbui.widget.layout.ImageBlockLayout;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
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
import com.facebook.placetips.bootstrap.PresenceDescription;
import com.facebook.placetips.logging.PlaceTipsAnalyticsEvent;
import com.facebook.placetips.logging.PlaceTipsAnalyticsLogger;
import com.facebook.search.model.PlaceTipsTypeaheadUnit;
import com.facebook.search.suggestions.viewbinder.PlaceTipsSuggestionViewBinder;
import com.google.common.collect.ImmutableList;
import javax.inject.Inject;

@ContextScoped
/* compiled from: vault_quota */
public class SearchTypeaheadPlaceTipsPartDefinition extends MultiRowSinglePartDefinition<PlaceTipsTypeaheadUnit, String, AnyEnvironment, ImageBlockLayout> {
    public static final ViewType f594a = new C00531();
    private static SearchTypeaheadPlaceTipsPartDefinition f595c;
    private static final Object f596d = new Object();
    private final PlaceTipsSuggestionViewBinder f597b;

    /* compiled from: vault_quota */
    final class C00531 extends ViewType {
        C00531() {
        }

        public final View m680a(Context context) {
            return (ImageBlockLayout) LayoutInflater.from(context).inflate(2130906284, null);
        }
    }

    private static SearchTypeaheadPlaceTipsPartDefinition m683b(InjectorLike injectorLike) {
        return new SearchTypeaheadPlaceTipsPartDefinition(new PlaceTipsSuggestionViewBinder(ResourcesMethodAutoProvider.a(injectorLike), PlaceTipsAnalyticsLogger.a(injectorLike)));
    }

    public final /* bridge */ /* synthetic */ void m686a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, 1446885323);
        m682a((PlaceTipsTypeaheadUnit) obj, (String) obj2, (ImageBlockLayout) view);
        Logger.a(8, EntryType.MARK_POP, -1460985233, a);
    }

    @Inject
    public SearchTypeaheadPlaceTipsPartDefinition(PlaceTipsSuggestionViewBinder placeTipsSuggestionViewBinder) {
        this.f597b = placeTipsSuggestionViewBinder;
    }

    public final Object m685a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        return "%s";
    }

    public final ViewType m684a() {
        return f594a;
    }

    public final boolean m687a(Object obj) {
        return true;
    }

    public static SearchTypeaheadPlaceTipsPartDefinition m681a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            SearchTypeaheadPlaceTipsPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f596d) {
                SearchTypeaheadPlaceTipsPartDefinition searchTypeaheadPlaceTipsPartDefinition;
                if (a2 != null) {
                    searchTypeaheadPlaceTipsPartDefinition = (SearchTypeaheadPlaceTipsPartDefinition) a2.a(f596d);
                } else {
                    searchTypeaheadPlaceTipsPartDefinition = f595c;
                }
                if (searchTypeaheadPlaceTipsPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m683b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f596d, b3);
                        } else {
                            f595c = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = searchTypeaheadPlaceTipsPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    private void m682a(PlaceTipsTypeaheadUnit placeTipsTypeaheadUnit, String str, ImageBlockLayout imageBlockLayout) {
        PlaceTipsSuggestionViewBinder placeTipsSuggestionViewBinder = this.f597b;
        TextView textView = (TextView) FindViewUtil.b(imageBlockLayout, 2131566053);
        TextView textView2 = (TextView) FindViewUtil.b(imageBlockLayout, 2131566054);
        PresenceDescription presenceDescription = placeTipsTypeaheadUnit.a;
        textView.setText(StringLocaleUtil.a(str, new Object[]{presenceDescription.h()}));
        CharSequence charSequence = "";
        ImmutableList j = presenceDescription.j();
        if (j != null && j.size() > 0) {
            charSequence = placeTipsSuggestionViewBinder.f377a.getString(2131237431, new Object[]{j.get(0)});
        }
        textView2.setText(charSequence);
        placeTipsSuggestionViewBinder.f378b.a(PlaceTipsAnalyticsEvent.SEARCH_NULL_STATE_VPV, presenceDescription.l(), presenceDescription.i(), presenceDescription.d());
    }
}
