package com.facebook.search.results.rows.sections.commerce;

import android.content.Context;
import android.view.View;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.common.timeformat.DefaultTimeFormatUtil;
import com.facebook.common.timeformat.TimeFormatUtil;
import com.facebook.common.timeformat.TimeFormatUtil.TimeFormatStyle;
import com.facebook.common.util.SeparatedSpannableStringBuilder;
import com.facebook.fbui.widget.contentview.ContentView;
import com.facebook.graphql.enums.GraphQLGraphSearchResultRole;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.BaseSinglePartDefinition;
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.parts.ContentViewSubtitlePartDefinition;
import com.facebook.multirow.parts.ContentViewTitlePartDefinition;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.search.abtest.ExperimentsForSearchAbTestModule;
import com.facebook.search.results.model.unit.SearchResultsProductItemUnit;
import javax.inject.Inject;

@ContextScoped
/* compiled from: RELATED_ARTICLES */
public class CommerceListItemProductInfoPartDefinition extends BaseSinglePartDefinition<SearchResultsProductItemUnit, Boolean, AnyEnvironment, ContentView> {
    private static CommerceListItemProductInfoPartDefinition f23887f;
    private static final Object f23888g = new Object();
    public final TimeFormatUtil f23889a;
    public final ContentViewTitlePartDefinition f23890b;
    public final ContentViewSubtitlePartDefinition f23891c;
    public final CommerceListItemCallToActionPartDefinition f23892d;
    public final QeAccessor f23893e;

    private static CommerceListItemProductInfoPartDefinition m27492b(InjectorLike injectorLike) {
        return new CommerceListItemProductInfoPartDefinition((TimeFormatUtil) DefaultTimeFormatUtil.a(injectorLike), ContentViewTitlePartDefinition.a(injectorLike), ContentViewSubtitlePartDefinition.a(injectorLike), CommerceListItemCallToActionPartDefinition.m27476a(injectorLike), (QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike));
    }

    public final Object m27493a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        Object aa;
        SearchResultsProductItemUnit searchResultsProductItemUnit = (SearchResultsProductItemUnit) obj;
        subParts.a(this.f23890b, searchResultsProductItemUnit.f23494a.gI() != null ? searchResultsProductItemUnit.f23494a.gI().l() : searchResultsProductItemUnit.f23494a.ec().l());
        if (searchResultsProductItemUnit.mo1321k() == GraphQLGraphSearchResultRole.COMMERCE_B2C) {
            aa = searchResultsProductItemUnit.f23494a.gU().aa();
        } else {
            aa = m27491a(searchResultsProductItemUnit);
        }
        subParts.a(this.f23891c, aa);
        boolean a = this.f23893e.a(ExperimentsForSearchAbTestModule.b, false);
        if (a) {
            subParts.a(2131567292, this.f23892d, searchResultsProductItemUnit);
        }
        return Boolean.valueOf(a);
    }

    public final /* bridge */ /* synthetic */ void m27494a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, 1934378556);
        ((ContentView) view).setShowAuxView(((Boolean) obj2).booleanValue());
        Logger.a(8, EntryType.MARK_POP, -1088818909, a);
    }

    public final void m27495b(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        ((ContentView) view).setShowAuxView(!((Boolean) obj2).booleanValue());
    }

    private CharSequence m27491a(SearchResultsProductItemUnit searchResultsProductItemUnit) {
        CharSequence U = searchResultsProductItemUnit.f23494a.jT().aJ().U();
        CharSequence a = this.f23889a.a(TimeFormatStyle.STREAM_RELATIVE_STYLE, searchResultsProductItemUnit.f23494a.bw() * 1000);
        SeparatedSpannableStringBuilder separatedSpannableStringBuilder = new SeparatedSpannableStringBuilder(" • ");
        separatedSpannableStringBuilder.a(U);
        separatedSpannableStringBuilder.a(a);
        return separatedSpannableStringBuilder;
    }

    @Inject
    public CommerceListItemProductInfoPartDefinition(TimeFormatUtil timeFormatUtil, ContentViewTitlePartDefinition contentViewTitlePartDefinition, ContentViewSubtitlePartDefinition contentViewSubtitlePartDefinition, CommerceListItemCallToActionPartDefinition commerceListItemCallToActionPartDefinition, QeAccessor qeAccessor) {
        this.f23889a = timeFormatUtil;
        this.f23890b = contentViewTitlePartDefinition;
        this.f23891c = contentViewSubtitlePartDefinition;
        this.f23892d = commerceListItemCallToActionPartDefinition;
        this.f23893e = qeAccessor;
    }

    public static CommerceListItemProductInfoPartDefinition m27490a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            CommerceListItemProductInfoPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f23888g) {
                CommerceListItemProductInfoPartDefinition commerceListItemProductInfoPartDefinition;
                if (a2 != null) {
                    commerceListItemProductInfoPartDefinition = (CommerceListItemProductInfoPartDefinition) a2.a(f23888g);
                } else {
                    commerceListItemProductInfoPartDefinition = f23887f;
                }
                if (commerceListItemProductInfoPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m27492b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f23888g, b3);
                        } else {
                            f23887f = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = commerceListItemProductInfoPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
