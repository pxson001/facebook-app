package com.facebook.search.results.rows.sections.livefeed;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.FeedEnvironment;
import com.facebook.feed.rows.core.parts.SubPartsSelector;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.permalink.PermalinkAttachedStoryPartDefinition;
import com.facebook.feedplugins.base.footer.EmptyFooterPartDefinition;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.BaseMultiRowGroupPartDefinition;
import com.facebook.multirow.api.BaseMultiRowSubParts;
import com.facebook.search.results.environment.SearchResultsLiveFeedEnvironment;
import javax.inject.Inject;

@ContextScoped
/* compiled from: Photos */
public class LiveFeedResharedAttachmentGroupPartDefinition extends BaseMultiRowGroupPartDefinition<FeedProps<GraphQLStory>, Void, SearchResultsLiveFeedEnvironment> {
    private static LiveFeedResharedAttachmentGroupPartDefinition f24530g;
    private static final Object f24531h = new Object();
    private final PermalinkAttachedStoryPartDefinition f24532a;
    private final LiveFeedResharedAttachmentHeaderPartDefinition f24533b;
    private final EmptyFooterPartDefinition f24534c;
    private final LiveFeedResharedAttachmentPhotoPartDefinition<FeedEnvironment> f24535d;
    private final LiveFeedResharedAttachmentVideoPartDefinition f24536e;
    private final LiveFeedResharedAttachment360VideoPartDefinition f24537f;

    private static LiveFeedResharedAttachmentGroupPartDefinition m27984b(InjectorLike injectorLike) {
        return new LiveFeedResharedAttachmentGroupPartDefinition(PermalinkAttachedStoryPartDefinition.a(injectorLike), LiveFeedResharedAttachmentHeaderPartDefinition.m27988a(injectorLike), EmptyFooterPartDefinition.a(injectorLike), LiveFeedResharedAttachmentPhotoPartDefinition.m27994a(injectorLike), LiveFeedResharedAttachmentVideoPartDefinition.m28000a(injectorLike), LiveFeedResharedAttachment360VideoPartDefinition.m27974a(injectorLike));
    }

    public final Object m27985a(BaseMultiRowSubParts baseMultiRowSubParts, Object obj, AnyEnvironment anyEnvironment) {
        FeedProps feedProps = (FeedProps) obj;
        FeedProps a = feedProps.a(((GraphQLStory) feedProps.a).L());
        baseMultiRowSubParts.a(this.f24533b, a);
        baseMultiRowSubParts.a(this.f24535d, a);
        SubPartsSelector.a(baseMultiRowSubParts, this.f24537f, a).a(this.f24536e, a);
        baseMultiRowSubParts.a(this.f24534c, a);
        return null;
    }

    public final boolean m27986a(Object obj) {
        return this.f24532a.a((FeedProps) obj);
    }

    @Inject
    public LiveFeedResharedAttachmentGroupPartDefinition(PermalinkAttachedStoryPartDefinition permalinkAttachedStoryPartDefinition, LiveFeedResharedAttachmentHeaderPartDefinition liveFeedResharedAttachmentHeaderPartDefinition, EmptyFooterPartDefinition emptyFooterPartDefinition, LiveFeedResharedAttachmentPhotoPartDefinition liveFeedResharedAttachmentPhotoPartDefinition, LiveFeedResharedAttachmentVideoPartDefinition liveFeedResharedAttachmentVideoPartDefinition, LiveFeedResharedAttachment360VideoPartDefinition liveFeedResharedAttachment360VideoPartDefinition) {
        this.f24532a = permalinkAttachedStoryPartDefinition;
        this.f24533b = liveFeedResharedAttachmentHeaderPartDefinition;
        this.f24534c = emptyFooterPartDefinition;
        this.f24535d = liveFeedResharedAttachmentPhotoPartDefinition;
        this.f24536e = liveFeedResharedAttachmentVideoPartDefinition;
        this.f24537f = liveFeedResharedAttachment360VideoPartDefinition;
    }

    public static LiveFeedResharedAttachmentGroupPartDefinition m27983a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            LiveFeedResharedAttachmentGroupPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f24531h) {
                LiveFeedResharedAttachmentGroupPartDefinition liveFeedResharedAttachmentGroupPartDefinition;
                if (a2 != null) {
                    liveFeedResharedAttachmentGroupPartDefinition = (LiveFeedResharedAttachmentGroupPartDefinition) a2.a(f24531h);
                } else {
                    liveFeedResharedAttachmentGroupPartDefinition = f24530g;
                }
                if (liveFeedResharedAttachmentGroupPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m27984b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f24531h, b3);
                        } else {
                            f24530g = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = liveFeedResharedAttachmentGroupPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
