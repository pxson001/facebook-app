package com.facebook.search.results.rows.sections.derp;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.graphql.enums.GraphQLStoryAttachmentStyle;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.graphql.model.StoryAttachmentHelper;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.Lazy;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.BaseMultiRowGroupPartDefinition;
import com.facebook.multirow.api.BaseMultiRowSubParts;
import com.facebook.multirow.api.MultiRowPartWithIsNeeded;
import com.facebook.search.results.environment.SearchResultsFeedEnvironment;
import com.google.common.collect.ImmutableSet;
import javax.inject.Inject;

@ContextScoped
/* compiled from: REACTION_ERROR */
public class DerpSuperDenseStoryPartDefinition extends BaseMultiRowGroupPartDefinition<FeedProps<GraphQLStory>, Void, SearchResultsFeedEnvironment> {
    private static final ImmutableSet<GraphQLStoryAttachmentStyle> f24088a = ImmutableSet.of(GraphQLStoryAttachmentStyle.IMAGE_SHARE, GraphQLStoryAttachmentStyle.INSTANT_ARTICLE, GraphQLStoryAttachmentStyle.SHARE, GraphQLStoryAttachmentStyle.NOTE);
    private static DerpSuperDenseStoryPartDefinition f24089d;
    private static final Object f24090e = new Object();
    private final DerpSuperDenseHeaderWithBackgroundPartDefinition f24091b;
    private final Lazy<SmallPhotoShareAttachmentWithMarginPartDefinition> f24092c;

    private static DerpSuperDenseStoryPartDefinition m27643b(InjectorLike injectorLike) {
        return new DerpSuperDenseStoryPartDefinition(DerpSuperDenseHeaderWithBackgroundPartDefinition.m27634a(injectorLike), IdBasedLazy.a(injectorLike, 10678));
    }

    public final Object m27644a(BaseMultiRowSubParts baseMultiRowSubParts, Object obj, AnyEnvironment anyEnvironment) {
        FeedProps feedProps = (FeedProps) obj;
        baseMultiRowSubParts.a(this.f24091b, feedProps);
        GraphQLStoryAttachment o = StoryAttachmentHelper.o((GraphQLStory) feedProps.a);
        if (!(o == null || o.w().isEmpty())) {
            if (f24088a.contains((GraphQLStoryAttachmentStyle) o.w().get(0))) {
                baseMultiRowSubParts.a((MultiRowPartWithIsNeeded) this.f24092c.get(), feedProps.a(o));
            }
        }
        return null;
    }

    public final boolean m27645a(Object obj) {
        return DerpSuperDenseHeaderWithBackgroundPartDefinition.m27635a((FeedProps) obj);
    }

    @Inject
    public DerpSuperDenseStoryPartDefinition(DerpSuperDenseHeaderWithBackgroundPartDefinition derpSuperDenseHeaderWithBackgroundPartDefinition, Lazy<SmallPhotoShareAttachmentWithMarginPartDefinition> lazy) {
        this.f24091b = derpSuperDenseHeaderWithBackgroundPartDefinition;
        this.f24092c = lazy;
    }

    public static DerpSuperDenseStoryPartDefinition m27642a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            DerpSuperDenseStoryPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f24090e) {
                DerpSuperDenseStoryPartDefinition derpSuperDenseStoryPartDefinition;
                if (a2 != null) {
                    derpSuperDenseStoryPartDefinition = (DerpSuperDenseStoryPartDefinition) a2.a(f24090e);
                } else {
                    derpSuperDenseStoryPartDefinition = f24089d;
                }
                if (derpSuperDenseStoryPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m27643b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f24090e, b3);
                        } else {
                            f24089d = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = derpSuperDenseStoryPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
