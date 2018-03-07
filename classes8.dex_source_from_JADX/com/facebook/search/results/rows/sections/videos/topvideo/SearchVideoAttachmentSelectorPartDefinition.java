package com.facebook.search.results.rows.sections.videos.topvideo;

import android.content.Context;
import com.facebook.attachments.videos.ui.FullscreenVideoAttachmentView;
import com.facebook.attachments.videos.ui.InlineVideoAttachmentView;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.rows.core.parts.SubPartsSelector;
import com.facebook.feedplugins.video.FullscreenVideoAttachmentPartDefinition;
import com.facebook.feedplugins.video.InlineVideoAttachmentPartDefinition;
import com.facebook.graphql.model.GraphQLStoryAttachment;
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
import javax.inject.Inject;

@ContextScoped
/* compiled from: PICKER_OPEN */
public class SearchVideoAttachmentSelectorPartDefinition extends BaseMultiRowGroupPartDefinition<GraphQLStoryAttachment, Void, SearchResultsFeedEnvironment> {
    private static SearchVideoAttachmentSelectorPartDefinition f25299c;
    private static final Object f25300d = new Object();
    private final SearchVideoAttachmentPartDefinition<SearchResultsFeedEnvironment, InlineVideoAttachmentView> f25301a;
    private final SearchVideoAttachmentPartDefinition<SearchResultsFeedEnvironment, FullscreenVideoAttachmentView> f25302b;

    private static SearchVideoAttachmentSelectorPartDefinition m28543b(InjectorLike injectorLike) {
        return new SearchVideoAttachmentSelectorPartDefinition(InlineVideoAttachmentPartDefinition.a(injectorLike), FullscreenVideoAttachmentPartDefinition.a(injectorLike), (SearchVideoAttachmentPartDefinitionProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(SearchVideoAttachmentPartDefinitionProvider.class));
    }

    public final Object m28544a(BaseMultiRowSubParts baseMultiRowSubParts, Object obj, AnyEnvironment anyEnvironment) {
        GraphQLStoryAttachment graphQLStoryAttachment = (GraphQLStoryAttachment) obj;
        SubPartsSelector.a(baseMultiRowSubParts, this.f25301a, graphQLStoryAttachment).a(this.f25302b, graphQLStoryAttachment);
        return null;
    }

    @Inject
    public SearchVideoAttachmentSelectorPartDefinition(InlineVideoAttachmentPartDefinition inlineVideoAttachmentPartDefinition, FullscreenVideoAttachmentPartDefinition fullscreenVideoAttachmentPartDefinition, SearchVideoAttachmentPartDefinitionProvider searchVideoAttachmentPartDefinitionProvider) {
        this.f25301a = searchVideoAttachmentPartDefinitionProvider.m28541a(inlineVideoAttachmentPartDefinition);
        this.f25302b = searchVideoAttachmentPartDefinitionProvider.m28541a(fullscreenVideoAttachmentPartDefinition);
    }

    public final boolean m28545a(Object obj) {
        return true;
    }

    public static SearchVideoAttachmentSelectorPartDefinition m28542a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            SearchVideoAttachmentSelectorPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f25300d) {
                SearchVideoAttachmentSelectorPartDefinition searchVideoAttachmentSelectorPartDefinition;
                if (a2 != null) {
                    searchVideoAttachmentSelectorPartDefinition = (SearchVideoAttachmentSelectorPartDefinition) a2.a(f25300d);
                } else {
                    searchVideoAttachmentSelectorPartDefinition = f25299c;
                }
                if (searchVideoAttachmentSelectorPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m28543b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f25300d, b3);
                        } else {
                            f25299c = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = searchVideoAttachmentSelectorPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
