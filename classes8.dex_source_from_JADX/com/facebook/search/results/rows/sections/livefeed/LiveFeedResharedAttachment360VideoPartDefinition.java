package com.facebook.search.results.rows.sections.livefeed;

import android.content.Context;
import android.os.Build.VERSION;
import android.view.View;
import com.facebook.attachments.videos.ui.Inline360VideoAttachmentView;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.HasFeedListType;
import com.facebook.feed.environment.HasInvalidate;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.environment.HasPrefetcher;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.styling.BackgroundStyler.Position;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.graphql.model.StoryAttachmentHelper;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.api.ViewType;
import com.facebook.video.abtest.Video360PlayerConfig;
import javax.inject.Inject;

@ContextScoped
/* compiled from: Place ID didn't match prefetched place ID */
public class LiveFeedResharedAttachment360VideoPartDefinition<E extends HasPositionInformation & HasFeedListType & HasPersistentState & HasInvalidate & HasPrefetcher> extends MultiRowSinglePartDefinition<FeedProps<GraphQLStory>, Void, E, Inline360VideoAttachmentView> {
    public static final ViewType<Inline360VideoAttachmentView> f24519a = new C25911();
    private static LiveFeedResharedAttachment360VideoPartDefinition f24520e;
    private static final Object f24521f = new Object();
    private final LiveFeedResharedAttachmentBackgroundPartDefinition f24522b;
    private final LiveFeed360VideoAttachmentPartDefinition<E> f24523c;
    private final Video360PlayerConfig f24524d;

    /* compiled from: Place ID didn't match prefetched place ID */
    final class C25911 extends ViewType {
        C25911() {
        }

        public final View m27973a(Context context) {
            return new Inline360VideoAttachmentView(context);
        }
    }

    private static LiveFeedResharedAttachment360VideoPartDefinition m27975b(InjectorLike injectorLike) {
        return new LiveFeedResharedAttachment360VideoPartDefinition(LiveFeedResharedAttachmentBackgroundPartDefinition.m27979a(injectorLike), LiveFeed360VideoAttachmentPartDefinition.m27905a(injectorLike), Video360PlayerConfig.b(injectorLike));
    }

    public final Object m27977a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        subParts.a(this.f24523c, (FeedProps) obj);
        subParts.a(this.f24522b, Position.MIDDLE);
        return null;
    }

    public final boolean m27978a(Object obj) {
        GraphQLStoryAttachment o = StoryAttachmentHelper.o((GraphQLStory) ((FeedProps) obj).a);
        return VERSION.SDK_INT >= 18 && o != null && !o.q() && o.r() != null && o.r().ap() && this.f24524d.e;
    }

    @Inject
    public LiveFeedResharedAttachment360VideoPartDefinition(LiveFeedResharedAttachmentBackgroundPartDefinition liveFeedResharedAttachmentBackgroundPartDefinition, LiveFeed360VideoAttachmentPartDefinition liveFeed360VideoAttachmentPartDefinition, Video360PlayerConfig video360PlayerConfig) {
        this.f24522b = liveFeedResharedAttachmentBackgroundPartDefinition;
        this.f24523c = liveFeed360VideoAttachmentPartDefinition;
        this.f24524d = video360PlayerConfig;
    }

    public static LiveFeedResharedAttachment360VideoPartDefinition m27974a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            LiveFeedResharedAttachment360VideoPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f24521f) {
                LiveFeedResharedAttachment360VideoPartDefinition liveFeedResharedAttachment360VideoPartDefinition;
                if (a2 != null) {
                    liveFeedResharedAttachment360VideoPartDefinition = (LiveFeedResharedAttachment360VideoPartDefinition) a2.a(f24521f);
                } else {
                    liveFeedResharedAttachment360VideoPartDefinition = f24520e;
                }
                if (liveFeedResharedAttachment360VideoPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m27975b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f24521f, b3);
                        } else {
                            f24520e = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = liveFeedResharedAttachment360VideoPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    public final ViewType<Inline360VideoAttachmentView> m27976a() {
        return f24519a;
    }
}
