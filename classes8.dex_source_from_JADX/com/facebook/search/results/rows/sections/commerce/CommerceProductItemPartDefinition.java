package com.facebook.search.results.rows.sections.commerce;

import android.content.Context;
import android.text.style.StrikethroughSpan;
import android.text.style.TextAppearanceSpan;
import android.view.View;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.common.util.SeparatedSpannableStringBuilder;
import com.facebook.feed.environment.HasContext;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.graphql.enums.GraphQLGraphSearchResultRole;
import com.facebook.graphql.model.GraphQLNode;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.location.FbLocationCache;
import com.facebook.location.ImmutableLocation;
import com.facebook.location.LocationComparisonUtil;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.api.ViewType;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.search.abtest.ExperimentsForSearchAbTestModule;
import com.facebook.search.results.environment.common.CanLogCollectionItemNavigation;
import com.facebook.search.results.model.unit.SearchResultsProductItemUnit;
import com.google.common.base.Strings;
import javax.inject.Inject;

@ContextScoped
/* compiled from: RECENT_VIDEOS */
public class CommerceProductItemPartDefinition<E extends HasContext & CanLogCollectionItemNavigation> extends MultiRowSinglePartDefinition<SearchResultsProductItemUnit, State, E, CommerceProductItemView> {
    public static ViewType<CommerceProductItemView> f23930a = ViewType.a(2130906980);
    public static final CallerContext f23931b = CallerContext.a(CommerceProductItemPartDefinition.class, "search");
    private static CommerceProductItemPartDefinition f23932f;
    private static final Object f23933g = new Object();
    private final CommerceProductItemClickPartDefinition f23934c;
    private final FbLocationCache f23935d;
    private final QeAccessor f23936e;

    /* compiled from: RECENT_VIDEOS */
    public class State {
        public final boolean f23928a;
        public final CharSequence f23929b;

        public State(boolean z, CharSequence charSequence) {
            this.f23928a = z;
            this.f23929b = charSequence;
        }
    }

    private static CommerceProductItemPartDefinition m27519b(InjectorLike injectorLike) {
        return new CommerceProductItemPartDefinition(CommerceProductItemClickPartDefinition.m27513a(injectorLike), FbLocationCache.b(injectorLike), (QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike));
    }

    public final Object m27521a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        CharSequence a;
        SearchResultsProductItemUnit searchResultsProductItemUnit = (SearchResultsProductItemUnit) obj;
        HasContext hasContext = (HasContext) anyEnvironment;
        boolean z = false;
        subParts.a(this.f23934c, searchResultsProductItemUnit);
        if (!searchResultsProductItemUnit.f23494a.dP()) {
            a = m27517a(hasContext.getContext(), null, searchResultsProductItemUnit.f23494a.ec().l());
        } else if (this.f23936e.a(ExperimentsForSearchAbTestModule.f, false)) {
            a = m27517a(hasContext.getContext(), searchResultsProductItemUnit.f23494a.ec().l(), searchResultsProductItemUnit.f23494a.gI().l());
        } else {
            a = m27517a(hasContext.getContext(), null, searchResultsProductItemUnit.f23494a.gI().l());
        }
        if (!this.f23936e.a(ExperimentsForSearchAbTestModule.e, false) || searchResultsProductItemUnit.f23494a.kl() == 0.0d || searchResultsProductItemUnit.f23494a.km() == 0.0d) {
            return new State(false, a);
        }
        ImmutableLocation a2 = ImmutableLocation.a(searchResultsProductItemUnit.f23494a.kl(), searchResultsProductItemUnit.f23494a.km()).a();
        ImmutableLocation a3 = this.f23935d.a();
        if (a3 != null && ((double) LocationComparisonUtil.a(a3, a2)) < 25000.0d) {
            z = true;
        }
        return new State(z, a);
    }

    public final /* bridge */ /* synthetic */ void m27522a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, -1055214072);
        SearchResultsProductItemUnit searchResultsProductItemUnit = (SearchResultsProductItemUnit) obj;
        State state = (State) obj2;
        CommerceProductItemView commerceProductItemView = (CommerceProductItemView) view;
        GraphQLNode graphQLNode = searchResultsProductItemUnit.f23494a;
        commerceProductItemView.m27525a(CommerceThumbnailPartDefinition.m27539a(searchResultsProductItemUnit), f23931b);
        commerceProductItemView.setProductName(graphQLNode.eP());
        commerceProductItemView.setProductPrice(state.f23929b);
        if (searchResultsProductItemUnit.mo1321k() == GraphQLGraphSearchResultRole.COMMERCE_B2C) {
            commerceProductItemView.setProductSubtitle(graphQLNode.gU().aa());
        } else {
            commerceProductItemView.setProductSubtitle(graphQLNode.jT().aJ().U());
        }
        commerceProductItemView.setNearbyIndicatorEnabled(state.f23928a);
        Logger.a(8, EntryType.MARK_POP, 1868795421, a);
    }

    public static CommerceProductItemPartDefinition m27516a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            CommerceProductItemPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f23933g) {
                CommerceProductItemPartDefinition commerceProductItemPartDefinition;
                if (a2 != null) {
                    commerceProductItemPartDefinition = (CommerceProductItemPartDefinition) a2.a(f23933g);
                } else {
                    commerceProductItemPartDefinition = f23932f;
                }
                if (commerceProductItemPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m27519b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f23933g, b3);
                        } else {
                            f23932f = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = commerceProductItemPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Inject
    public CommerceProductItemPartDefinition(CommerceProductItemClickPartDefinition commerceProductItemClickPartDefinition, FbLocationCache fbLocationCache, QeAccessor qeAccessor) {
        this.f23934c = commerceProductItemClickPartDefinition;
        this.f23935d = fbLocationCache;
        this.f23936e = qeAccessor;
    }

    public final ViewType<CommerceProductItemView> m27520a() {
        return f23930a;
    }

    public static boolean m27518a(SearchResultsProductItemUnit searchResultsProductItemUnit) {
        GraphQLNode graphQLNode = searchResultsProductItemUnit.f23494a;
        if (graphQLNode.j() == null || graphQLNode.j().g() != 175920258 || Strings.isNullOrEmpty(graphQLNode.eP())) {
            return false;
        }
        if ((graphQLNode.ec() == null && graphQLNode.gI() == null) || graphQLNode.gU() == null || Strings.isNullOrEmpty(graphQLNode.gU().aa()) || graphQLNode.dq() == null || Strings.isNullOrEmpty(graphQLNode.dq().b())) {
            return false;
        }
        return true;
    }

    private static CharSequence m27517a(Context context, String str, String str2) {
        SeparatedSpannableStringBuilder separatedSpannableStringBuilder = new SeparatedSpannableStringBuilder(" ");
        if (str2 != null) {
            separatedSpannableStringBuilder.a(str2, new TextAppearanceSpan(context, 2131625925), 17);
        }
        if (str != null) {
            separatedSpannableStringBuilder.a(str, new StrikethroughSpan(), 17);
            separatedSpannableStringBuilder.setSpan(new TextAppearanceSpan(context, 2131625927), str2.length(), str.length(), 17);
        }
        return separatedSpannableStringBuilder;
    }
}
