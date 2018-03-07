package com.facebook.feed.rows.photosfeed;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.rows.core.parts.SubPartsSelector;
import com.facebook.feed.rows.core.props.FeedProps;
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
import javax.inject.Inject;

@ContextScoped
/* compiled from: a1d0eeab0ab0d1f05fb3c99331be8599 */
public class PhotosFeedStoryBlingBarSelectorPartDefinition<E extends HasPersistentState & HasPositionInformation> extends BaseMultiRowGroupPartDefinition<FeedProps<GraphQLStory>, Void, E> {
    private static PhotosFeedStoryBlingBarSelectorPartDefinition f20282c;
    private static final Object f20283d = new Object();
    private final PhotosFeedStoryPillsBlingBarPartDefinition f20284a;
    private final PhotosFeedStoryBlingBarPartDefinition f20285b;

    private static PhotosFeedStoryBlingBarSelectorPartDefinition m23409b(InjectorLike injectorLike) {
        return new PhotosFeedStoryBlingBarSelectorPartDefinition(PhotosFeedStoryPillsBlingBarPartDefinition.m23440a(injectorLike), PhotosFeedStoryBlingBarPartDefinition.m23403a(injectorLike));
    }

    public final Object m23410a(BaseMultiRowSubParts baseMultiRowSubParts, Object obj, AnyEnvironment anyEnvironment) {
        FeedProps feedProps = (FeedProps) obj;
        SubPartsSelector.a(baseMultiRowSubParts, this.f20284a, feedProps).a(this.f20285b, feedProps);
        return null;
    }

    @Inject
    public PhotosFeedStoryBlingBarSelectorPartDefinition(PhotosFeedStoryPillsBlingBarPartDefinition photosFeedStoryPillsBlingBarPartDefinition, PhotosFeedStoryBlingBarPartDefinition photosFeedStoryBlingBarPartDefinition) {
        this.f20284a = photosFeedStoryPillsBlingBarPartDefinition;
        this.f20285b = photosFeedStoryBlingBarPartDefinition;
    }

    public final boolean m23411a(Object obj) {
        return true;
    }

    public static PhotosFeedStoryBlingBarSelectorPartDefinition m23408a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            PhotosFeedStoryBlingBarSelectorPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f20283d) {
                PhotosFeedStoryBlingBarSelectorPartDefinition photosFeedStoryBlingBarSelectorPartDefinition;
                if (a2 != null) {
                    photosFeedStoryBlingBarSelectorPartDefinition = (PhotosFeedStoryBlingBarSelectorPartDefinition) a2.a(f20283d);
                } else {
                    photosFeedStoryBlingBarSelectorPartDefinition = f20282c;
                }
                if (photosFeedStoryBlingBarSelectorPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m23409b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f20283d, b3);
                        } else {
                            f20282c = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = photosFeedStoryBlingBarSelectorPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
