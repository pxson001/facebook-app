package com.facebook.feedplugins.graphqlstory.footer;

import android.content.Context;
import android.view.View;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.CanShowVideoInFullScreen;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.rows.core.binding.StoryKeyUtil;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feedplugins.base.TextLinkPartDefinition;
import com.facebook.feedplugins.base.blingbar.BlingBarAnimationsPartDefinition;
import com.facebook.feedplugins.base.blingbar.BlingBarAnimationsPartDefinition.Props;
import com.facebook.feedplugins.base.blingbar.BlingBarFlyoutAndVideoLauncherPartDefinition;
import com.facebook.feedplugins.graphqlstory.footer.ui.VideoPlaysBlingBarView;
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
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.api.ViewType;
import com.facebook.story.GraphQLStoryHelper;
import javax.inject.Inject;

@ContextScoped
/* compiled from: StagingGroundLaunchConfiguration must be set */
public class BaseVideoPlaysBlingBarPartDefinition<E extends HasPositionInformation & HasPersistentState & CanShowVideoInFullScreen> extends MultiRowSinglePartDefinition<FeedProps<GraphQLStory>, Integer, E, VideoPlaysBlingBarView> {
    public static final ViewType f23174a = new C20041();
    private static BaseVideoPlaysBlingBarPartDefinition f23175e;
    private static final Object f23176f = new Object();
    private final BlingBarAnimationsPartDefinition f23177b;
    private final BlingBarFlyoutAndVideoLauncherPartDefinition f23178c;
    private final TextLinkPartDefinition f23179d;

    /* compiled from: StagingGroundLaunchConfiguration must be set */
    final class C20041 extends ViewType {
        C20041() {
        }

        public final View m25571a(Context context) {
            return new VideoPlaysBlingBarView(context);
        }
    }

    private static BaseVideoPlaysBlingBarPartDefinition m25574b(InjectorLike injectorLike) {
        return new BaseVideoPlaysBlingBarPartDefinition(BlingBarAnimationsPartDefinition.m25422a(injectorLike), BlingBarFlyoutAndVideoLauncherPartDefinition.a(injectorLike), TextLinkPartDefinition.a(injectorLike));
    }

    public final Object m25576a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        FeedProps feedProps = (FeedProps) obj;
        GraphQLStory graphQLStory = (GraphQLStory) feedProps.a;
        int e = GraphQLStoryHelper.e(graphQLStory);
        boolean z = graphQLStory.aa_() > 0 || graphQLStory.n() > 0 || e > 0;
        subParts.a(this.f23177b, new Props(graphQLStory, graphQLStory.l(), StoryKeyUtil.a(graphQLStory), z));
        if (graphQLStory.aa_() > 0 || graphQLStory.n() > 0) {
            subParts.a(2131559918, this.f23178c, feedProps);
        }
        subParts.a(this.f23179d, feedProps);
        return Integer.valueOf(e);
    }

    public final /* bridge */ /* synthetic */ void m25577a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, 715776749);
        ((VideoPlaysBlingBarView) view).setPlayCountText(((Integer) obj2).intValue());
        Logger.a(8, EntryType.MARK_POP, -1298358233, a);
    }

    @Inject
    public BaseVideoPlaysBlingBarPartDefinition(BlingBarAnimationsPartDefinition blingBarAnimationsPartDefinition, BlingBarFlyoutAndVideoLauncherPartDefinition blingBarFlyoutAndVideoLauncherPartDefinition, TextLinkPartDefinition textLinkPartDefinition) {
        this.f23177b = blingBarAnimationsPartDefinition;
        this.f23178c = blingBarFlyoutAndVideoLauncherPartDefinition;
        this.f23179d = textLinkPartDefinition;
    }

    public static BaseVideoPlaysBlingBarPartDefinition m25572a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            BaseVideoPlaysBlingBarPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f23176f) {
                BaseVideoPlaysBlingBarPartDefinition baseVideoPlaysBlingBarPartDefinition;
                if (a2 != null) {
                    baseVideoPlaysBlingBarPartDefinition = (BaseVideoPlaysBlingBarPartDefinition) a2.a(f23176f);
                } else {
                    baseVideoPlaysBlingBarPartDefinition = f23175e;
                }
                if (baseVideoPlaysBlingBarPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m25574b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f23176f, b3);
                        } else {
                            f23175e = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = baseVideoPlaysBlingBarPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    public final ViewType m25575a() {
        return f23174a;
    }

    public static boolean m25573a(FeedProps<GraphQLStory> feedProps) {
        return StoryAttachmentHelper.j((GraphQLStory) feedProps.a);
    }
}
