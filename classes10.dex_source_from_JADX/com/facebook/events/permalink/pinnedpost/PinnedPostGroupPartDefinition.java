package com.facebook.events.permalink.pinnedpost;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.events.feed.ui.environment.EventFeedEnvironment;
import com.facebook.feed.rows.core.parts.SubPartsSelector;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.sections.header.components.HeaderNoMenuComponentPartDefinition;
import com.facebook.feed.rows.sections.text.ContentTextPartDefinition;
import com.facebook.feedplugins.attachments.AttachmentsPartDefinition;
import com.facebook.feedplugins.graphqlstory.footer.BlingBarSelectorPartDefinition;
import com.facebook.feedplugins.graphqlstory.footer.TopLevelFooterPartSelector;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.Lazy;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.BaseMultiRowGroupPartDefinition;
import com.facebook.multirow.api.BaseMultiRowSubParts;
import javax.inject.Inject;

@ContextScoped
/* compiled from: background_location_upsell_miniphone_displayed */
public class PinnedPostGroupPartDefinition extends BaseMultiRowGroupPartDefinition<GraphQLStory, Void, EventFeedEnvironment> {
    private static PinnedPostGroupPartDefinition f18781h;
    private static final Object f18782i = new Object();
    private final TopLevelFooterPartSelector f18783a;
    private final BlingBarSelectorPartDefinition f18784b;
    private final AttachmentsPartDefinition f18785c;
    private final ContentTextPartDefinition f18786d;
    private final Lazy<PinnedPostHeaderPartDefinition<EventFeedEnvironment>> f18787e;
    private final HeaderNoMenuComponentPartDefinition<EventFeedEnvironment> f18788f;
    private final PinnedPostExplanationPartDefinition<EventFeedEnvironment> f18789g;

    private static PinnedPostGroupPartDefinition m19092b(InjectorLike injectorLike) {
        return new PinnedPostGroupPartDefinition(PinnedPostExplanationPartDefinition.m19085a(injectorLike), HeaderNoMenuComponentPartDefinition.a(injectorLike), IdBasedLazy.a(injectorLike, 5672), ContentTextPartDefinition.a(injectorLike), AttachmentsPartDefinition.a(injectorLike), BlingBarSelectorPartDefinition.a(injectorLike), TopLevelFooterPartSelector.a(injectorLike));
    }

    public final Object m19093a(BaseMultiRowSubParts baseMultiRowSubParts, Object obj, AnyEnvironment anyEnvironment) {
        FeedProps c = FeedProps.c((GraphQLStory) obj);
        baseMultiRowSubParts.a(this.f18789g, c);
        SubPartsSelector.a(baseMultiRowSubParts, this.f18788f, c).a(this.f18787e, c);
        baseMultiRowSubParts.a(this.f18786d, c);
        baseMultiRowSubParts.a(this.f18785c, c);
        baseMultiRowSubParts.a(this.f18784b, c);
        baseMultiRowSubParts.a(this.f18783a, c);
        return null;
    }

    @Inject
    public PinnedPostGroupPartDefinition(PinnedPostExplanationPartDefinition pinnedPostExplanationPartDefinition, HeaderNoMenuComponentPartDefinition headerNoMenuComponentPartDefinition, Lazy<PinnedPostHeaderPartDefinition> lazy, ContentTextPartDefinition contentTextPartDefinition, AttachmentsPartDefinition attachmentsPartDefinition, BlingBarSelectorPartDefinition blingBarSelectorPartDefinition, TopLevelFooterPartSelector topLevelFooterPartSelector) {
        this.f18783a = topLevelFooterPartSelector;
        this.f18784b = blingBarSelectorPartDefinition;
        this.f18785c = attachmentsPartDefinition;
        this.f18786d = contentTextPartDefinition;
        this.f18788f = headerNoMenuComponentPartDefinition;
        this.f18787e = lazy;
        this.f18789g = pinnedPostExplanationPartDefinition;
    }

    public final boolean m19094a(Object obj) {
        return true;
    }

    public static PinnedPostGroupPartDefinition m19091a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            PinnedPostGroupPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f18782i) {
                PinnedPostGroupPartDefinition pinnedPostGroupPartDefinition;
                if (a2 != null) {
                    pinnedPostGroupPartDefinition = (PinnedPostGroupPartDefinition) a2.a(f18782i);
                } else {
                    pinnedPostGroupPartDefinition = f18781h;
                }
                if (pinnedPostGroupPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m19092b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f18782i, b3);
                        } else {
                            f18781h = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = pinnedPostGroupPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
