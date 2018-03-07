package com.facebook.search.results.rows.sections.livefeed;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.rows.core.parts.SubPartsSelector;
import com.facebook.feed.rows.core.props.FeedProps;
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
/* compiled from: PmaHeaderInteractionSequence */
public class LiveFeedGroupPartDefinition extends BaseMultiRowGroupPartDefinition<GraphQLStory, Void, SearchResultsLiveFeedEnvironment> {
    private static LiveFeedGroupPartDefinition f24442h;
    private static final Object f24443i = new Object();
    private final LiveFeedMainHeaderPartDefinition f24444a;
    private final LiveFeedMainPhotoAttachmentPartDefinition f24445b;
    private final EmptyFooterPartDefinition f24446c;
    private final LiveFeedGapPartDefinition f24447d;
    private final LiveFeedMainVideoAttachmentPartDefinition f24448e;
    private final LiveFeedResharedAttachmentGroupPartDefinition f24449f;
    private final LiveFeedMain360VideoAttachmentPartDefinition f24450g;

    private static LiveFeedGroupPartDefinition m27919b(InjectorLike injectorLike) {
        return new LiveFeedGroupPartDefinition(LiveFeedMainHeaderPartDefinition.m27945a(injectorLike), EmptyFooterPartDefinition.a(injectorLike), LiveFeedGapPartDefinition.m27914a(injectorLike), LiveFeedMainVideoAttachmentPartDefinition.m27964a(injectorLike), LiveFeedMainPhotoAttachmentPartDefinition.m27958a(injectorLike), LiveFeedResharedAttachmentGroupPartDefinition.m27983a(injectorLike), LiveFeedMain360VideoAttachmentPartDefinition.m27939a(injectorLike));
    }

    public final Object m27920a(BaseMultiRowSubParts baseMultiRowSubParts, Object obj, AnyEnvironment anyEnvironment) {
        GraphQLStory graphQLStory = (GraphQLStory) obj;
        FeedProps c = FeedProps.c(graphQLStory);
        baseMultiRowSubParts.a(this.f24444a, c);
        SubPartsSelector.a(baseMultiRowSubParts, this.f24450g, c).a(this.f24448e, c);
        baseMultiRowSubParts.a(this.f24445b, c);
        baseMultiRowSubParts.a(this.f24449f, c);
        baseMultiRowSubParts.a(this.f24446c, c);
        baseMultiRowSubParts.a(this.f24447d, graphQLStory);
        return null;
    }

    @Inject
    public LiveFeedGroupPartDefinition(LiveFeedMainHeaderPartDefinition liveFeedMainHeaderPartDefinition, EmptyFooterPartDefinition emptyFooterPartDefinition, LiveFeedGapPartDefinition liveFeedGapPartDefinition, LiveFeedMainVideoAttachmentPartDefinition liveFeedMainVideoAttachmentPartDefinition, LiveFeedMainPhotoAttachmentPartDefinition liveFeedMainPhotoAttachmentPartDefinition, LiveFeedResharedAttachmentGroupPartDefinition liveFeedResharedAttachmentGroupPartDefinition, LiveFeedMain360VideoAttachmentPartDefinition liveFeedMain360VideoAttachmentPartDefinition) {
        this.f24444a = liveFeedMainHeaderPartDefinition;
        this.f24448e = liveFeedMainVideoAttachmentPartDefinition;
        this.f24445b = liveFeedMainPhotoAttachmentPartDefinition;
        this.f24446c = emptyFooterPartDefinition;
        this.f24447d = liveFeedGapPartDefinition;
        this.f24449f = liveFeedResharedAttachmentGroupPartDefinition;
        this.f24450g = liveFeedMain360VideoAttachmentPartDefinition;
    }

    public static LiveFeedGroupPartDefinition m27918a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            LiveFeedGroupPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f24443i) {
                LiveFeedGroupPartDefinition liveFeedGroupPartDefinition;
                if (a2 != null) {
                    liveFeedGroupPartDefinition = (LiveFeedGroupPartDefinition) a2.a(f24443i);
                } else {
                    liveFeedGroupPartDefinition = f24442h;
                }
                if (liveFeedGroupPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m27919b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f24443i, b3);
                        } else {
                            f24442h = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = liveFeedGroupPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    public final boolean m27921a(GraphQLStory graphQLStory) {
        return LiveFeedMainHeaderPartDefinition.m27946a(FeedProps.c(graphQLStory));
    }
}
