package com.facebook.search.results.rows.sections.pulse;

import android.content.Context;
import android.view.View;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.HasContext;
import com.facebook.feed.environment.HasInvalidate;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.environment.HasPrefetcher;
import com.facebook.feed.environment.HasRowKey;
import com.facebook.feedplugins.base.footer.ui.Footer;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.BaseMultiRowGroupPartDefinition;
import com.facebook.multirow.api.BaseMultiRowSubParts;
import com.facebook.search.results.environment.CanReplaceSearchResult;
import com.facebook.search.results.environment.HasSearchResultPosition;
import com.facebook.search.results.environment.HasSearchResultsContext;
import com.facebook.search.results.model.SearchResultsProps;
import com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel.NodeModel;
import com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel.NodeModel.ModuleResultsModel.EdgesModel;
import com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel.NodeModel.ModuleResultsModel.EdgesModel.EdgesNodeModel;
import com.facebook.search.results.protocol.pulse.PulseContextModuleInterfaces.PulseContextModule;
import javax.inject.Inject;

@ContextScoped
/* compiled from: PROGRESS_BAR */
public class PulseContextConvertedGroupPartDefinition<V extends View & Footer, E extends HasSearchResultsContext & HasSearchResultPosition & HasInvalidate & CanReplaceSearchResult & HasContext & HasPositionInformation & HasPrefetcher & HasRowKey> extends BaseMultiRowGroupPartDefinition<SearchResultsProps<PulseContextModule>, Void, E> {
    private static PulseContextConvertedGroupPartDefinition f24742e;
    private static final Object f24743f = new Object();
    private final PulseContextSummaryConvertedPartDefinition f24744a;
    private final PulseContextHeaderTextConvertedPartDefinition f24745b;
    private final PulseContextHeaderPhotoConvertedPartDefinition f24746c;
    private final PulseContextFooterConvertedPartDefinition<V, E> f24747d;

    private static PulseContextConvertedGroupPartDefinition m28159b(InjectorLike injectorLike) {
        return new PulseContextConvertedGroupPartDefinition(PulseContextHeaderPhotoConvertedPartDefinition.m28207a(injectorLike), PulseContextHeaderTextConvertedPartDefinition.m28218a(injectorLike), PulseContextSummaryConvertedPartDefinition.m28229a(injectorLike), PulseContextFooterConvertedPartDefinition.m28186a(injectorLike));
    }

    public final Object m28160a(BaseMultiRowSubParts baseMultiRowSubParts, Object obj, AnyEnvironment anyEnvironment) {
        SearchResultsProps searchResultsProps = (SearchResultsProps) obj;
        EdgesNodeModel k = ((EdgesModel) ((NodeModel) searchResultsProps.f23388a).bc().m9710a().get(0)).m9702k();
        baseMultiRowSubParts.a(this.f24746c, searchResultsProps.m27104a(k));
        baseMultiRowSubParts.a(this.f24745b, k);
        baseMultiRowSubParts.a(this.f24744a, k);
        baseMultiRowSubParts.a(this.f24747d, searchResultsProps.m27104a(k));
        return null;
    }

    @Inject
    public PulseContextConvertedGroupPartDefinition(PulseContextHeaderPhotoConvertedPartDefinition pulseContextHeaderPhotoConvertedPartDefinition, PulseContextHeaderTextConvertedPartDefinition pulseContextHeaderTextConvertedPartDefinition, PulseContextSummaryConvertedPartDefinition pulseContextSummaryConvertedPartDefinition, PulseContextFooterConvertedPartDefinition pulseContextFooterConvertedPartDefinition) {
        this.f24744a = pulseContextSummaryConvertedPartDefinition;
        this.f24745b = pulseContextHeaderTextConvertedPartDefinition;
        this.f24746c = pulseContextHeaderPhotoConvertedPartDefinition;
        this.f24747d = pulseContextFooterConvertedPartDefinition;
    }

    public static PulseContextConvertedGroupPartDefinition m28158a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            PulseContextConvertedGroupPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f24743f) {
                PulseContextConvertedGroupPartDefinition pulseContextConvertedGroupPartDefinition;
                if (a2 != null) {
                    pulseContextConvertedGroupPartDefinition = (PulseContextConvertedGroupPartDefinition) a2.a(f24743f);
                } else {
                    pulseContextConvertedGroupPartDefinition = f24742e;
                }
                if (pulseContextConvertedGroupPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m28159b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f24743f, b3);
                        } else {
                            f24742e = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = pulseContextConvertedGroupPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    public final boolean m28161a(Object obj) {
        return true;
    }
}
