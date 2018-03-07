package com.facebook.timeline.editfeaturedcontainers.rows;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.graphql.calls.SectionTypesInputFeaturedPageSuggestionsSectionType;
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
import com.facebook.multirow.parts.ViewPaddingPartDefinition;
import com.facebook.multirow.parts.ViewPaddingPartDefinition.PaddingData;
import com.facebook.resources.ui.FbTextView;
import com.facebook.timeline.editfeaturedcontainers.protocol.FetchNullStateGraphQLModels.FeaturedPageSectionModel;
import com.facebook.timeline.editfeaturedcontainers.rows.environments.NullStateEnvironment;
import com.facebook.timeline.editfeaturedcontainers.rows.environments.NullStateEnvironmentGenerated;
import com.google.common.collect.ImmutableList;
import javax.inject.Inject;

@ContextScoped
/* compiled from: getInstallerData */
public class NullStateSuggestedPagesSectionFooterPartDefinition extends MultiRowSinglePartDefinition<FeaturedPageSectionModel, Void, NullStateEnvironment, FbTextView> {
    public static final ViewType<FbTextView> f10859a = ViewType.a(2130905510);
    private static NullStateSuggestedPagesSectionFooterPartDefinition f10860e;
    private static final Object f10861f = new Object();
    private final ViewPaddingPartDefinition f10862b;
    private final ClickListenerPartDefinition f10863c;
    public final Resources f10864d;

    private static NullStateSuggestedPagesSectionFooterPartDefinition m10975b(InjectorLike injectorLike) {
        return new NullStateSuggestedPagesSectionFooterPartDefinition(ViewPaddingPartDefinition.a(injectorLike), ClickListenerPartDefinition.a(injectorLike), ResourcesMethodAutoProvider.a(injectorLike));
    }

    public final Object m10977a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        C15731 c15731;
        FeaturedPageSectionModel featuredPageSectionModel = (FeaturedPageSectionModel) obj;
        final NullStateEnvironmentGenerated nullStateEnvironmentGenerated = (NullStateEnvironmentGenerated) anyEnvironment;
        ViewPaddingPartDefinition viewPaddingPartDefinition = this.f10862b;
        int dimensionPixelSize = this.f10864d.getDimensionPixelSize(2131433933);
        subParts.a(viewPaddingPartDefinition, new PaddingData(dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize));
        ClickListenerPartDefinition clickListenerPartDefinition = this.f10863c;
        if (featuredPageSectionModel.m10820j() == null) {
            c15731 = null;
        } else {
            final int dimensionPixelSize2 = this.f10864d.getDimensionPixelSize(2131427471);
            final ImmutableList of = ImmutableList.of(SectionTypesInputFeaturedPageSuggestionsSectionType.valueOf(featuredPageSectionModel.m10820j().name()));
            c15731 = new OnClickListener(this) {
                final /* synthetic */ NullStateSuggestedPagesSectionFooterPartDefinition f10858d;

                public void onClick(View view) {
                    int a = Logger.a(2, EntryType.UI_INPUT_START, 1112370998);
                    nullStateEnvironmentGenerated.mo517a(10, dimensionPixelSize2, of, view.getContext());
                    Logger.a(2, EntryType.UI_INPUT_END, 1241028861, a);
                }
            };
        }
        subParts.a(clickListenerPartDefinition, c15731);
        return null;
    }

    public final boolean m10978a(Object obj) {
        return ((FeaturedPageSectionModel) obj).m10819a().size() < 10;
    }

    @Inject
    public NullStateSuggestedPagesSectionFooterPartDefinition(ViewPaddingPartDefinition viewPaddingPartDefinition, ClickListenerPartDefinition clickListenerPartDefinition, Resources resources) {
        this.f10862b = viewPaddingPartDefinition;
        this.f10863c = clickListenerPartDefinition;
        this.f10864d = resources;
    }

    public final ViewType<FbTextView> m10976a() {
        return f10859a;
    }

    public static NullStateSuggestedPagesSectionFooterPartDefinition m10974a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            NullStateSuggestedPagesSectionFooterPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f10861f) {
                NullStateSuggestedPagesSectionFooterPartDefinition nullStateSuggestedPagesSectionFooterPartDefinition;
                if (a2 != null) {
                    nullStateSuggestedPagesSectionFooterPartDefinition = (NullStateSuggestedPagesSectionFooterPartDefinition) a2.a(f10861f);
                } else {
                    nullStateSuggestedPagesSectionFooterPartDefinition = f10860e;
                }
                if (nullStateSuggestedPagesSectionFooterPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m10975b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f10861f, b3);
                        } else {
                            f10860e = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = nullStateSuggestedPagesSectionFooterPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
