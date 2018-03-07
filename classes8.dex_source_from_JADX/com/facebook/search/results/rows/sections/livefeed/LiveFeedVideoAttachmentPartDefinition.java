package com.facebook.search.results.rows.sections.livefeed;

import android.content.Context;
import android.view.View;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.CanShowVideoInFullScreen;
import com.facebook.feed.environment.HasFeedListType;
import com.facebook.feed.environment.HasInvalidate;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.environment.HasPrefetcher;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.core.props.StoryProps;
import com.facebook.feedplugins.video.RichVideoAttachmentView;
import com.facebook.feedplugins.video.RichVideoPlayerPartDefinition;
import com.facebook.feedplugins.video.RichVideoPlayerPartDefinition.Props;
import com.facebook.graphql.model.GraphQLStory;
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
import com.google.common.base.Absent;
import java.util.concurrent.atomic.AtomicReference;
import javax.inject.Inject;

@ContextScoped
/* compiled from: People */
public class LiveFeedVideoAttachmentPartDefinition<E extends CanShowVideoInFullScreen & HasPositionInformation & HasFeedListType & HasPersistentState & HasInvalidate & HasPrefetcher> extends BaseSinglePartDefinition<FeedProps<GraphQLStory>, Void, E, RichVideoAttachmentView> {
    private static LiveFeedVideoAttachmentPartDefinition f24554b;
    private static final Object f24555c = new Object();
    private final RichVideoPlayerPartDefinition<E, RichVideoAttachmentView> f24556a;

    private static LiveFeedVideoAttachmentPartDefinition m28006b(InjectorLike injectorLike) {
        return new LiveFeedVideoAttachmentPartDefinition(RichVideoPlayerPartDefinition.a(injectorLike));
    }

    public final Object m28007a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        subParts.a(this.f24556a, new Props(StoryProps.i((FeedProps) obj), -1, Absent.INSTANCE, new AtomicReference()));
        return null;
    }

    public final /* bridge */ /* synthetic */ void m28008a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        Logger.a(8, EntryType.MARK_POP, 568853994, Logger.a(8, EntryType.MARK_PUSH, -13408224));
    }

    @Inject
    public LiveFeedVideoAttachmentPartDefinition(RichVideoPlayerPartDefinition richVideoPlayerPartDefinition) {
        this.f24556a = richVideoPlayerPartDefinition;
    }

    public static LiveFeedVideoAttachmentPartDefinition m28005a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            LiveFeedVideoAttachmentPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f24555c) {
                LiveFeedVideoAttachmentPartDefinition liveFeedVideoAttachmentPartDefinition;
                if (a2 != null) {
                    liveFeedVideoAttachmentPartDefinition = (LiveFeedVideoAttachmentPartDefinition) a2.a(f24555c);
                } else {
                    liveFeedVideoAttachmentPartDefinition = f24554b;
                }
                if (liveFeedVideoAttachmentPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m28006b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f24555c, b3);
                        } else {
                            f24554b = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = liveFeedVideoAttachmentPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
