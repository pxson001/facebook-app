package com.facebook.timeline.editfeaturedcontainers.rows;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.BaseMultiRowGroupPartDefinition;
import com.facebook.multirow.api.BaseMultiRowSubParts;
import com.facebook.timeline.editfeaturedcontainers.protocol.FetchNullStateGraphQLModels.FeaturedPageSectionModel;
import com.facebook.timeline.editfeaturedcontainers.protocol.FetchNullStateGraphQLModels.FeaturedPageSuggestionModel;
import com.facebook.timeline.editfeaturedcontainers.rows.NullStateSectionTitlePartDefinition.Props;
import com.facebook.timeline.editfeaturedcontainers.rows.environments.NullStateEnvironment;
import com.google.common.collect.ImmutableList;
import javax.inject.Inject;

@ContextScoped
/* compiled from: getInputStream */
public class NullStateSuggestedPagesSectionPartDefinition extends BaseMultiRowGroupPartDefinition<FeaturedPageSectionModel, Void, NullStateEnvironment> {
    private static NullStateSuggestedPagesSectionPartDefinition f10865d;
    private static final Object f10866e = new Object();
    private final NullStateSectionTitlePartDefinition f10867a;
    private final NullStateSuggestedPagePartDefinition f10868b;
    private final NullStateSuggestedPagesSectionFooterPartDefinition f10869c;

    private static NullStateSuggestedPagesSectionPartDefinition m10980b(InjectorLike injectorLike) {
        return new NullStateSuggestedPagesSectionPartDefinition(NullStateSectionTitlePartDefinition.m10961a(injectorLike), NullStateSuggestedPagePartDefinition.m10968a(injectorLike), NullStateSuggestedPagesSectionFooterPartDefinition.m10974a(injectorLike));
    }

    public final Object m10981a(BaseMultiRowSubParts baseMultiRowSubParts, Object obj, AnyEnvironment anyEnvironment) {
        FeaturedPageSectionModel featuredPageSectionModel = (FeaturedPageSectionModel) obj;
        baseMultiRowSubParts.a(this.f10867a, new Props(featuredPageSectionModel.m10821k() == null ? null : featuredPageSectionModel.m10821k().m10816a(), null));
        ImmutableList a = featuredPageSectionModel.m10819a();
        int size = a.size();
        for (int i = 0; i < size; i++) {
            baseMultiRowSubParts.a(this.f10868b, (FeaturedPageSuggestionModel) a.get(i));
        }
        baseMultiRowSubParts.a(this.f10869c, featuredPageSectionModel);
        return null;
    }

    public final boolean m10982a(Object obj) {
        return !((FeaturedPageSectionModel) obj).m10819a().isEmpty();
    }

    @Inject
    public NullStateSuggestedPagesSectionPartDefinition(NullStateSectionTitlePartDefinition nullStateSectionTitlePartDefinition, NullStateSuggestedPagePartDefinition nullStateSuggestedPagePartDefinition, NullStateSuggestedPagesSectionFooterPartDefinition nullStateSuggestedPagesSectionFooterPartDefinition) {
        this.f10867a = nullStateSectionTitlePartDefinition;
        this.f10868b = nullStateSuggestedPagePartDefinition;
        this.f10869c = nullStateSuggestedPagesSectionFooterPartDefinition;
    }

    public static NullStateSuggestedPagesSectionPartDefinition m10979a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            NullStateSuggestedPagesSectionPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f10866e) {
                NullStateSuggestedPagesSectionPartDefinition nullStateSuggestedPagesSectionPartDefinition;
                if (a2 != null) {
                    nullStateSuggestedPagesSectionPartDefinition = (NullStateSuggestedPagesSectionPartDefinition) a2.a(f10866e);
                } else {
                    nullStateSuggestedPagesSectionPartDefinition = f10865d;
                }
                if (nullStateSuggestedPagesSectionPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m10980b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f10866e, b3);
                        } else {
                            f10865d = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = nullStateSuggestedPagesSectionPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
