package com.facebook.feedplugins.pillsblingbar.ui;

import android.content.Context;
import android.view.View;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.CanShowVideoInFullScreen;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feedback.reactions.ui.PillsBlingBarPartDefinitionHelper;
import com.facebook.feedback.reactions.ui.PillsBlingBarView;
import com.facebook.feedplugins.base.blingbar.BlingBarFlyoutAndVideoLauncherPartDefinition;
import com.facebook.feedplugins.base.blingbar.BlingBarFlyoutPartDefinition;
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
/* compiled from: hd_upload_nux */
public class PillsBlingBarWithoutBackgroundPartDefinition<E extends CanShowVideoInFullScreen & HasPersistentState & HasPositionInformation> extends MultiRowSinglePartDefinition<FeedProps<GraphQLStory>, Integer, E, PillsBlingBarView> {
    private static PillsBlingBarWithoutBackgroundPartDefinition f21195d;
    private static final Object f21196e = new Object();
    private final PillsBlingBarPartDefinitionHelper f21197a;
    private final BlingBarFlyoutPartDefinition f21198b;
    private final BlingBarFlyoutAndVideoLauncherPartDefinition f21199c;

    private static PillsBlingBarWithoutBackgroundPartDefinition m28917a(InjectorLike injectorLike) {
        return new PillsBlingBarWithoutBackgroundPartDefinition(PillsBlingBarPartDefinitionHelper.m28925a(injectorLike), BlingBarFlyoutPartDefinition.m28929a(injectorLike), BlingBarFlyoutAndVideoLauncherPartDefinition.m28932a(injectorLike));
    }

    public final ViewType mo2547a() {
        return PillsBlingBarView.f22227a;
    }

    public final /* bridge */ /* synthetic */ void mo2543a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, 491986850);
        PillsBlingBarPartDefinitionHelper.m28926a(((GraphQLStory) ((FeedProps) obj).f13444a).mo2890l(), (Integer) obj2, (PillsBlingBarView) view);
        Logger.a(8, EntryType.MARK_POP, 123225852, a);
    }

    @Inject
    public PillsBlingBarWithoutBackgroundPartDefinition(PillsBlingBarPartDefinitionHelper pillsBlingBarPartDefinitionHelper, BlingBarFlyoutPartDefinition blingBarFlyoutPartDefinition, BlingBarFlyoutAndVideoLauncherPartDefinition blingBarFlyoutAndVideoLauncherPartDefinition) {
        this.f21197a = pillsBlingBarPartDefinitionHelper;
        this.f21198b = blingBarFlyoutPartDefinition;
        this.f21199c = blingBarFlyoutAndVideoLauncherPartDefinition;
    }

    public static PillsBlingBarWithoutBackgroundPartDefinition m28918b(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.m1499a();
        byte b = a.m1504b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().mo191b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            PillsBlingBarWithoutBackgroundPartDefinition a2;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a3 = ContextScope.m1330a(b2);
            synchronized (f21196e) {
                PillsBlingBarWithoutBackgroundPartDefinition pillsBlingBarWithoutBackgroundPartDefinition;
                if (a3 != null) {
                    pillsBlingBarWithoutBackgroundPartDefinition = (PillsBlingBarWithoutBackgroundPartDefinition) a3.mo818a(f21196e);
                } else {
                    pillsBlingBarWithoutBackgroundPartDefinition = f21195d;
                }
                if (pillsBlingBarWithoutBackgroundPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.m1333a(b2, injectorThreadStack);
                    try {
                        a2 = m28917a(injectorThreadStack.m1474e());
                        if (a3 != null) {
                            a3.mo822a(f21196e, a2);
                        } else {
                            f21195d = a2;
                        }
                    } finally {
                        ContextScope.m1331a(injectorThreadStack);
                    }
                } else {
                    a2 = pillsBlingBarWithoutBackgroundPartDefinition;
                }
            }
            return a2;
        } finally {
            a.m1505c(b);
        }
    }

    public Integer mo3155a(SubParts<E> subParts, FeedProps<GraphQLStory> feedProps, E e) {
        int e2;
        GraphQLStory graphQLStory = (GraphQLStory) feedProps.f13444a;
        if (StoryAttachmentHelper.m28037j(graphQLStory)) {
            subParts.mo2756a(this.f21199c, feedProps);
            e2 = GraphQLStoryHelper.m10203e(graphQLStory);
        } else {
            subParts.mo2756a(this.f21198b, feedProps);
            e2 = 0;
        }
        return Integer.valueOf(e2);
    }

    public final boolean m28923a(FeedProps<GraphQLStory> feedProps) {
        GraphQLStory graphQLStory = (GraphQLStory) feedProps.f13444a;
        return graphQLStory != null && PillsBlingBarPartDefinitionHelper.m28927a(graphQLStory.mo2890l());
    }
}
