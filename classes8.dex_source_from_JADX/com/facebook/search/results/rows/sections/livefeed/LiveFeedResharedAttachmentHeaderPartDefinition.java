package com.facebook.search.results.rows.sections.livefeed;

import android.content.Context;
import android.view.View;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.styling.BackgroundStyler.Position;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.api.ViewType;
import com.facebook.search.results.environment.HasSearchResultsContext;
import com.facebook.search.results.rows.sections.livefeed.ui.LiveFeedResharedHeaderView;
import javax.inject.Inject;

@ContextScoped
/* compiled from: Photo capture failed */
public class LiveFeedResharedAttachmentHeaderPartDefinition extends MultiRowSinglePartDefinition<FeedProps<GraphQLStory>, Void, HasSearchResultsContext, LiveFeedResharedHeaderView> {
    public static final ViewType f24538a = new C25931();
    private static LiveFeedResharedAttachmentHeaderPartDefinition f24539d;
    private static final Object f24540e = new Object();
    private final LiveFeedHeaderPartDefinition f24541b;
    private final LiveFeedResharedAttachmentBackgroundPartDefinition f24542c;

    /* compiled from: Photo capture failed */
    final class C25931 extends ViewType {
        C25931() {
        }

        public final View m27987a(Context context) {
            return new LiveFeedResharedHeaderView(context);
        }
    }

    private static LiveFeedResharedAttachmentHeaderPartDefinition m27989b(InjectorLike injectorLike) {
        return new LiveFeedResharedAttachmentHeaderPartDefinition(LiveFeedHeaderPartDefinition.m27927a(injectorLike), LiveFeedResharedAttachmentBackgroundPartDefinition.m27979a(injectorLike));
    }

    public final Object m27991a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        subParts.a(this.f24541b, (FeedProps) obj);
        subParts.a(this.f24542c, Position.TOP);
        return null;
    }

    @Inject
    public LiveFeedResharedAttachmentHeaderPartDefinition(LiveFeedHeaderPartDefinition liveFeedHeaderPartDefinition, LiveFeedResharedAttachmentBackgroundPartDefinition liveFeedResharedAttachmentBackgroundPartDefinition) {
        this.f24541b = liveFeedHeaderPartDefinition;
        this.f24542c = liveFeedResharedAttachmentBackgroundPartDefinition;
    }

    public final ViewType<LiveFeedResharedHeaderView> m27990a() {
        return f24538a;
    }

    public final boolean m27992a(Object obj) {
        return true;
    }

    public static LiveFeedResharedAttachmentHeaderPartDefinition m27988a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            LiveFeedResharedAttachmentHeaderPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f24540e) {
                LiveFeedResharedAttachmentHeaderPartDefinition liveFeedResharedAttachmentHeaderPartDefinition;
                if (a2 != null) {
                    liveFeedResharedAttachmentHeaderPartDefinition = (LiveFeedResharedAttachmentHeaderPartDefinition) a2.a(f24540e);
                } else {
                    liveFeedResharedAttachmentHeaderPartDefinition = f24539d;
                }
                if (liveFeedResharedAttachmentHeaderPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m27989b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f24540e, b3);
                        } else {
                            f24539d = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = liveFeedResharedAttachmentHeaderPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
