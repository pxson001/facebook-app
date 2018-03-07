package com.facebook.search.results.rows.sections.pulse;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.BaseMultiRowGroupPartDefinition;
import com.facebook.multirow.api.BaseMultiRowSubParts;
import com.facebook.search.results.environment.SearchResultsFeedEnvironment;
import com.facebook.search.results.model.unit.SearchResultsPulseContextUnit;
import javax.inject.Inject;

@ContextScoped
@Deprecated
/* compiled from: PROFILE_PHOTO */
public class PulseContextGroupPartDefinition extends BaseMultiRowGroupPartDefinition<FeedProps<SearchResultsPulseContextUnit>, Void, SearchResultsFeedEnvironment> {
    private static PulseContextGroupPartDefinition f24811e;
    private static final Object f24812f = new Object();
    private final PulseContextSummaryPartDefinition f24813a;
    private final PulseContextHeaderTextPartDefinition f24814b;
    private final PulseContextHeaderPhotoPartDefinition f24815c;
    private final PulseContextFooterPartDefinition f24816d;

    private static PulseContextGroupPartDefinition m28204b(InjectorLike injectorLike) {
        return new PulseContextGroupPartDefinition(PulseContextHeaderPhotoPartDefinition.m28212a(injectorLike), PulseContextHeaderTextPartDefinition.m28223a(injectorLike), PulseContextSummaryPartDefinition.m28236a(injectorLike), PulseContextFooterPartDefinition.m28191a(injectorLike));
    }

    public final Object m28205a(BaseMultiRowSubParts baseMultiRowSubParts, Object obj, AnyEnvironment anyEnvironment) {
        SearchResultsPulseContextUnit searchResultsPulseContextUnit = (SearchResultsPulseContextUnit) ((FeedProps) obj).a;
        baseMultiRowSubParts.a(this.f24815c, searchResultsPulseContextUnit);
        baseMultiRowSubParts.a(this.f24814b, searchResultsPulseContextUnit);
        baseMultiRowSubParts.a(this.f24813a, searchResultsPulseContextUnit);
        baseMultiRowSubParts.a(this.f24816d, searchResultsPulseContextUnit);
        return null;
    }

    @Inject
    public PulseContextGroupPartDefinition(PulseContextHeaderPhotoPartDefinition pulseContextHeaderPhotoPartDefinition, PulseContextHeaderTextPartDefinition pulseContextHeaderTextPartDefinition, PulseContextSummaryPartDefinition pulseContextSummaryPartDefinition, PulseContextFooterPartDefinition pulseContextFooterPartDefinition) {
        this.f24813a = pulseContextSummaryPartDefinition;
        this.f24814b = pulseContextHeaderTextPartDefinition;
        this.f24815c = pulseContextHeaderPhotoPartDefinition;
        this.f24816d = pulseContextFooterPartDefinition;
    }

    public final boolean m28206a(Object obj) {
        return true;
    }

    public static PulseContextGroupPartDefinition m28203a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            PulseContextGroupPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f24812f) {
                PulseContextGroupPartDefinition pulseContextGroupPartDefinition;
                if (a2 != null) {
                    pulseContextGroupPartDefinition = (PulseContextGroupPartDefinition) a2.a(f24812f);
                } else {
                    pulseContextGroupPartDefinition = f24811e;
                }
                if (pulseContextGroupPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m28204b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f24812f, b3);
                        } else {
                            f24811e = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = pulseContextGroupPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
