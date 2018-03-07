package com.facebook.search.typeahead.rows.nullstate;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.view.View;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.common.util.StringUtil;
import com.facebook.fbui.glyph.GlyphColorizer;
import com.facebook.fbui.widget.contentview.ContentView;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.gk.store.GatekeeperStoreImpl;
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
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.search.abtest.ExperimentsForSearchAbTestModule;
import com.facebook.search.abtest.SearchAbTestGatekeepers;
import com.facebook.search.model.NullStateModuleSuggestionUnit;
import com.facebook.search.model.NullStateModuleSuggestionUnit.Type;
import com.facebook.search.suggestions.environment.SearchSuggestionsEnvironment;
import com.facebook.search.suggestions.viewbinder.KeywordSuggestionViewBinder;
import com.facebook.search.util.TypeaheadRowTitleFormatter;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMap.Builder;
import javax.inject.Inject;

@ContextScoped
/* compiled from: validChargeRange */
public class NullStateModuleItemPartDefinition extends MultiRowSinglePartDefinition<NullStateModuleSuggestionUnit, State, SearchSuggestionsEnvironment, ContentView> {
    public static final ViewType<ContentView> f660a = ViewType.a(2130906976);
    private static final ImmutableMap<Type, IconData> f661b = new Builder().b(Type.ns_pulse, new IconData(2130841641, -5624441)).b(Type.ns_trending, new IconData(2130841681, -13266433)).b(Type.ns_local, new IconData(2130841642, -778386)).b(Type.ns_interest, new IconData(2130841641, -12953448)).b(Type.ns_social, new IconData(2130841641, -12953448)).b(Type.ns_suggested, new IconData(2130841641, -12953448)).b(Type.ns_top, new IconData(2130841641, -12953448)).b(Type.unset, new IconData(2130841641, -12953448)).b();
    private static NullStateModuleItemPartDefinition f662i;
    private static final Object f663j = new Object();
    private final QeAccessor f664c;
    private final GlyphColorizer f665d;
    private final NullStateModuleItemClickPartDefinition f666e;
    private final KeywordSuggestionViewBinder f667f;
    private final TypeaheadRowTitleFormatter f668g;
    private final GatekeeperStoreImpl f669h;

    /* compiled from: validChargeRange */
    class IconData {
        public final int f654a;
        public final int f655b;

        public IconData(int i, int i2) {
            this.f654a = i;
            this.f655b = i2;
        }
    }

    /* compiled from: validChargeRange */
    public class State {
        public boolean f656a;
        public Drawable f657b;
        public final CharSequence f658c;
        public final CharSequence f659d;

        public State(boolean z, Drawable drawable, CharSequence charSequence, CharSequence charSequence2) {
            this.f656a = z;
            this.f657b = drawable;
            this.f658c = charSequence;
            this.f659d = charSequence2;
        }
    }

    private static NullStateModuleItemPartDefinition m756b(InjectorLike injectorLike) {
        return new NullStateModuleItemPartDefinition((QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike), GlyphColorizer.a(injectorLike), NullStateModuleItemClickPartDefinition.m749a(injectorLike), KeywordSuggestionViewBinder.m493a(injectorLike), TypeaheadRowTitleFormatter.a(injectorLike), GatekeeperStoreImplMethodAutoProvider.a(injectorLike));
    }

    public final Object m758a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        boolean z;
        IconData iconData;
        CharSequence a;
        NullStateModuleSuggestionUnit nullStateModuleSuggestionUnit = (NullStateModuleSuggestionUnit) obj;
        SearchSuggestionsEnvironment searchSuggestionsEnvironment = (SearchSuggestionsEnvironment) anyEnvironment;
        subParts.a(this.f666e, nullStateModuleSuggestionUnit);
        if (this.f664c.a(ExperimentsForSearchAbTestModule.bj, false) && nullStateModuleSuggestionUnit.a.equals(Type.ns_trending)) {
            z = true;
        } else {
            z = false;
        }
        if (f661b.containsKey(nullStateModuleSuggestionUnit.a)) {
            iconData = (IconData) f661b.get(nullStateModuleSuggestionUnit.a);
        } else {
            iconData = new IconData(2130841641, -12953448);
        }
        if (nullStateModuleSuggestionUnit.l && this.f669h.a(SearchAbTestGatekeepers.s, false)) {
            a = m755a(nullStateModuleSuggestionUnit);
        } else {
            Object obj2 = nullStateModuleSuggestionUnit.b;
        }
        return new State(z, this.f667f.m500a(searchSuggestionsEnvironment.getContext(), this.f665d.a(iconData.f654a, iconData.f655b), false), a, m754a(iconData.f655b, nullStateModuleSuggestionUnit));
    }

    public final /* bridge */ /* synthetic */ void m759a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        boolean z;
        int a = Logger.a(8, EntryType.MARK_PUSH, -1766336321);
        NullStateModuleSuggestionUnit nullStateModuleSuggestionUnit = (NullStateModuleSuggestionUnit) obj;
        State state = (State) obj2;
        ContentView contentView = (ContentView) view;
        contentView.setTitleText(state.f658c);
        contentView.setThumbnailDrawable(state.f657b);
        contentView.setSubtitleText(state.f659d);
        if (!state.f656a || nullStateModuleSuggestionUnit.n) {
            z = false;
        } else {
            z = true;
        }
        contentView.setShowAuxView(z);
        Logger.a(8, EntryType.MARK_POP, 828827870, a);
    }

    public static NullStateModuleItemPartDefinition m753a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            NullStateModuleItemPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f663j) {
                NullStateModuleItemPartDefinition nullStateModuleItemPartDefinition;
                if (a2 != null) {
                    nullStateModuleItemPartDefinition = (NullStateModuleItemPartDefinition) a2.a(f663j);
                } else {
                    nullStateModuleItemPartDefinition = f662i;
                }
                if (nullStateModuleItemPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m756b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f663j, b3);
                        } else {
                            f662i = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = nullStateModuleItemPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Inject
    public NullStateModuleItemPartDefinition(QeAccessor qeAccessor, GlyphColorizer glyphColorizer, NullStateModuleItemClickPartDefinition nullStateModuleItemClickPartDefinition, KeywordSuggestionViewBinder keywordSuggestionViewBinder, TypeaheadRowTitleFormatter typeaheadRowTitleFormatter, GatekeeperStoreImpl gatekeeperStoreImpl) {
        this.f664c = qeAccessor;
        this.f669h = gatekeeperStoreImpl;
        this.f665d = glyphColorizer;
        this.f666e = nullStateModuleItemClickPartDefinition;
        this.f667f = keywordSuggestionViewBinder;
        this.f668g = typeaheadRowTitleFormatter;
    }

    public final ViewType<ContentView> m757a() {
        return f660a;
    }

    public final boolean m760a(Object obj) {
        return true;
    }

    private CharSequence m755a(NullStateModuleSuggestionUnit nullStateModuleSuggestionUnit) {
        return this.f668g.b(new SpannableStringBuilder(nullStateModuleSuggestionUnit.b));
    }

    private static CharSequence m754a(int i, NullStateModuleSuggestionUnit nullStateModuleSuggestionUnit) {
        CharSequence n = nullStateModuleSuggestionUnit.n();
        if (StringUtil.a(nullStateModuleSuggestionUnit.c)) {
            return n;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(n);
        int length = nullStateModuleSuggestionUnit.c.length();
        spannableStringBuilder.setSpan(new ForegroundColorSpan(i), 0, length, 33);
        spannableStringBuilder.setSpan(new StyleSpan(1), 0, length, 33);
        return spannableStringBuilder;
    }
}
