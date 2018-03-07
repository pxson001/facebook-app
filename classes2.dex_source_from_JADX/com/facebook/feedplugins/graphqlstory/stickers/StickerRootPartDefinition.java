package com.facebook.feedplugins.graphqlstory.stickers;

import android.content.Context;
import android.view.View;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.styling.BackgroundPartDefinition;
import com.facebook.feed.rows.styling.BackgroundPartDefinition.StylingData;
import com.facebook.feed.rows.styling.PaddingStyle.Builder;
import com.facebook.feedplugins.graphqlstory.stickers.ui.StickerPostView;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.PropertyHelper;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.api.ViewType;
import javax.inject.Inject;

@ContextScoped
/* compiled from: init_threads_queue */
public class StickerRootPartDefinition<E extends HasPersistentState & HasPositionInformation> extends MultiRowSinglePartDefinition<FeedProps<GraphQLStory>, Void, E, StickerPostView> {
    public static final ViewType f20067a = new C08151();
    private static StickerRootPartDefinition f20068d;
    private static final Object f20069e = new Object();
    private final BackgroundPartDefinition f20070b;
    private final StickerPartDefinition f20071c;

    /* compiled from: init_threads_queue */
    final class C08151 extends ViewType {
        C08151() {
        }

        public final View mo1995a(Context context) {
            return new StickerPostView(context);
        }
    }

    private static StickerRootPartDefinition m27782b(InjectorLike injectorLike) {
        return new StickerRootPartDefinition(BackgroundPartDefinition.m19135a(injectorLike), StickerPartDefinition.m27787a(injectorLike));
    }

    public final Object mo2541a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        FeedProps feedProps = (FeedProps) obj;
        GraphQLStory graphQLStory = (GraphQLStory) feedProps.f13444a;
        subParts.mo2756a(this.f20070b, new StylingData(feedProps, Builder.m19307g().m19313i()));
        subParts.mo2756a(this.f20071c, graphQLStory);
        return null;
    }

    public final boolean m27785a(Object obj) {
        GraphQLStory graphQLStory = (GraphQLStory) ((FeedProps) obj).f13444a;
        return (graphQLStory.ar() == null && PropertyHelper.m21306g(graphQLStory) == null) ? false : true;
    }

    @Inject
    public StickerRootPartDefinition(BackgroundPartDefinition backgroundPartDefinition, StickerPartDefinition stickerPartDefinition) {
        this.f20070b = backgroundPartDefinition;
        this.f20071c = stickerPartDefinition;
    }

    public final ViewType mo2547a() {
        return f20067a;
    }

    public static StickerRootPartDefinition m27781a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.m1499a();
        byte b = a.m1504b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().mo191b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            StickerRootPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.m1330a(b2);
            synchronized (f20069e) {
                StickerRootPartDefinition stickerRootPartDefinition;
                if (a2 != null) {
                    stickerRootPartDefinition = (StickerRootPartDefinition) a2.mo818a(f20069e);
                } else {
                    stickerRootPartDefinition = f20068d;
                }
                if (stickerRootPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.m1333a(b2, injectorThreadStack);
                    try {
                        b3 = m27782b(injectorThreadStack.m1474e());
                        if (a2 != null) {
                            a2.mo822a(f20069e, b3);
                        } else {
                            f20068d = b3;
                        }
                    } finally {
                        ContextScope.m1331a(injectorThreadStack);
                    }
                } else {
                    b3 = stickerRootPartDefinition;
                }
            }
            return b3;
        } finally {
            a.m1505c(b);
        }
    }
}
