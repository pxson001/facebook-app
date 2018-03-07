package com.facebook.search.results.rows.sections.livefeed;

import android.content.Context;
import android.view.View;
import com.facebook.attachments.videos.ui.Inline360VideoAttachmentView;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.HasFeedListType;
import com.facebook.feed.environment.HasInvalidate;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.environment.HasPrefetcher;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feedplugins.attachments.video.Inline360VideoPartDefinition;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.StoryAttachmentHelper;
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
import javax.inject.Inject;

@ContextScoped
/* compiled from: PmaWarmStartSequence */
public class LiveFeed360VideoAttachmentPartDefinition<E extends HasPositionInformation & HasFeedListType & HasPersistentState & HasInvalidate & HasPrefetcher> extends BaseSinglePartDefinition<FeedProps<GraphQLStory>, Void, E, Inline360VideoAttachmentView> {
    private static LiveFeed360VideoAttachmentPartDefinition f24433b;
    private static final Object f24434c = new Object();
    private final Inline360VideoPartDefinition<E> f24435a;

    private static LiveFeed360VideoAttachmentPartDefinition m27906b(InjectorLike injectorLike) {
        return new LiveFeed360VideoAttachmentPartDefinition(Inline360VideoPartDefinition.a(injectorLike));
    }

    public final Object m27907a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        FeedProps feedProps = (FeedProps) obj;
        subParts.a(this.f24435a, feedProps.a(StoryAttachmentHelper.o((GraphQLStory) feedProps.a)));
        return null;
    }

    public final /* bridge */ /* synthetic */ void m27908a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        Logger.a(8, EntryType.MARK_POP, 1432036092, Logger.a(8, EntryType.MARK_PUSH, 1335515207));
    }

    @Inject
    public LiveFeed360VideoAttachmentPartDefinition(Inline360VideoPartDefinition inline360VideoPartDefinition) {
        this.f24435a = inline360VideoPartDefinition;
    }

    public static LiveFeed360VideoAttachmentPartDefinition m27905a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            LiveFeed360VideoAttachmentPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f24434c) {
                LiveFeed360VideoAttachmentPartDefinition liveFeed360VideoAttachmentPartDefinition;
                if (a2 != null) {
                    liveFeed360VideoAttachmentPartDefinition = (LiveFeed360VideoAttachmentPartDefinition) a2.a(f24434c);
                } else {
                    liveFeed360VideoAttachmentPartDefinition = f24433b;
                }
                if (liveFeed360VideoAttachmentPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m27906b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f24434c, b3);
                        } else {
                            f24433b = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = liveFeed360VideoAttachmentPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
