package com.facebook.feed.rows.photosfeed;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.photosfeed.PhotosFeedBackgroundPartDefinition.StylingData;
import com.facebook.feed.rows.styling.PaddingStyle;
import com.facebook.feedback.reactions.ui.PillsBlingBarView;
import com.facebook.feedplugins.pillsblingbar.ui.PillsBlingBarWithoutBackgroundPartDefinition;
import com.facebook.flatbuffers.Flattenable;
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
import javax.inject.Inject;

@ContextScoped
/* compiled from: _parseComments */
public class PhotosFeedStoryPillsBlingBarPartDefinition<E extends HasPositionInformation & HasPersistentState> extends MultiRowSinglePartDefinition<FeedProps<GraphQLStory>, Void, E, PillsBlingBarView> {
    private static PhotosFeedStoryPillsBlingBarPartDefinition f20315c;
    private static final Object f20316d = new Object();
    private final PillsBlingBarWithoutBackgroundPartDefinition f20317a;
    private final PhotosFeedBackgroundPartDefinition f20318b;

    private static PhotosFeedStoryPillsBlingBarPartDefinition m23441b(InjectorLike injectorLike) {
        return new PhotosFeedStoryPillsBlingBarPartDefinition(PillsBlingBarWithoutBackgroundPartDefinition.b(injectorLike), PhotosFeedBackgroundPartDefinition.m23327a(injectorLike));
    }

    public final Object m23443a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        FeedProps feedProps = (FeedProps) obj;
        Flattenable flattenable = feedProps.a;
        subParts.a(this.f20318b, new StylingData(feedProps, PaddingStyle.o));
        subParts.a(this.f20317a, feedProps);
        return null;
    }

    public final boolean m23444a(Object obj) {
        return this.f20317a.a((FeedProps) obj);
    }

    @Inject
    public PhotosFeedStoryPillsBlingBarPartDefinition(PillsBlingBarWithoutBackgroundPartDefinition pillsBlingBarWithoutBackgroundPartDefinition, PhotosFeedBackgroundPartDefinition photosFeedBackgroundPartDefinition) {
        this.f20317a = pillsBlingBarWithoutBackgroundPartDefinition;
        this.f20318b = photosFeedBackgroundPartDefinition;
    }

    public final ViewType<PillsBlingBarView> m23442a() {
        return PillsBlingBarView.a;
    }

    public static PhotosFeedStoryPillsBlingBarPartDefinition m23440a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            PhotosFeedStoryPillsBlingBarPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f20316d) {
                PhotosFeedStoryPillsBlingBarPartDefinition photosFeedStoryPillsBlingBarPartDefinition;
                if (a2 != null) {
                    photosFeedStoryPillsBlingBarPartDefinition = (PhotosFeedStoryPillsBlingBarPartDefinition) a2.a(f20316d);
                } else {
                    photosFeedStoryPillsBlingBarPartDefinition = f20315c;
                }
                if (photosFeedStoryPillsBlingBarPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m23441b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f20316d, b3);
                        } else {
                            f20315c = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = photosFeedStoryPillsBlingBarPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
