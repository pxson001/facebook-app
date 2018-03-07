package com.facebook.feed.rows.styling;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.rows.abtest.ExperimentsForMultipleRowsStoriesAbtestModule;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.core.parts.PartWithViewType;
import com.facebook.feed.rows.core.props.AttachmentProps;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.core.props.HasFeedProps;
import com.facebook.feed.rows.styling.HasSpecialStyling.SpecialStylingType;
import com.facebook.feedplugins.pyma.rows.PagesYouMayAdvertiseHeaderPartDefinition;
import com.facebook.flatbuffers.Flattenable;
import com.facebook.graphql.model.FeedUnit;
import com.facebook.graphql.model.GraphQLHelper;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.graphql.story.util.GraphQLStoryUtil;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.collect.ImmutableList;
import javax.annotation.Nullable;
import javax.inject.Inject;

@ContextScoped
/* compiled from: native_article?article={%s}&canonical={%s}&saved={%s} */
public class PositionResolver {
    private static PositionResolver f13016c;
    private static final Object f13017d = new Object();
    private final GraphQLStoryUtil f13018a;
    private final QeAccessor f13019b;

    private static PositionResolver m19146b(InjectorLike injectorLike) {
        return new PositionResolver(GraphQLStoryUtil.m9565a(injectorLike), QeInternalImplMethodAutoProvider.m3744a(injectorLike));
    }

    @Inject
    public PositionResolver(GraphQLStoryUtil graphQLStoryUtil, QeAccessor qeAccessor) {
        this.f13018a = graphQLStoryUtil;
        this.f13019b = qeAccessor;
    }

    public final BackgroundStyler$Position m19149a(@Nullable FeedProps<? extends FeedUnit> feedProps, int i, PartWithViewType partWithViewType, PartWithViewType partWithViewType2, PartWithViewType partWithViewType3, Object obj, Object obj2) {
        FeedUnit feedUnit;
        if (feedProps != null) {
            feedUnit = (FeedUnit) feedProps.f13444a;
        } else {
            feedUnit = null;
        }
        if (feedUnit != null) {
            FeedProps a = m19140a((MultiRowSinglePartDefinition) partWithViewType2, obj);
            FeedProps a2 = m19140a((MultiRowSinglePartDefinition) partWithViewType3, obj2);
            FeedUnit feedUnit2;
            if (a != null) {
                feedUnit2 = (FeedUnit) a.f13444a;
            } else {
                feedUnit2 = null;
            }
            if ((partWithViewType2 instanceof PagesYouMayAdvertiseHeaderPartDefinition) && ((PagesYouMayAdvertiseHeaderPartDefinition) partWithViewType2).m26988a(r0, feedUnit)) {
                return BackgroundStyler$Position.MIDDLE;
            }
            int m = this.f13018a.m9602m(a);
            int m2 = this.f13018a.m9602m(a2);
            if (m < i) {
                BackgroundStyler$Position backgroundStyler$Position;
                if (i > m2) {
                    backgroundStyler$Position = BackgroundStyler$Position.BOX;
                } else if (m19148d(partWithViewType)) {
                    backgroundStyler$Position = BackgroundStyler$Position.DIVIDER_BOTTOM;
                } else {
                    backgroundStyler$Position = BackgroundStyler$Position.TOP;
                }
                return backgroundStyler$Position;
            } else if (i > m2) {
                return m19141a(feedUnit, (MultiRowSinglePartDefinition) partWithViewType);
            } else {
                if (i == 1 && m2 == 1 && m19145a((MultiRowSinglePartDefinition) partWithViewType3, SpecialStylingType.HEADER) && this.f13019b.mo596a(ExperimentsForMultipleRowsStoriesAbtestModule.f6712b, false)) {
                    return BackgroundStyler$Position.BOTTOM;
                }
                if (m19145a((MultiRowSinglePartDefinition) partWithViewType3, SpecialStylingType.FOLLOWUP_FEEDUNIT)) {
                    return BackgroundStyler$Position.FOLLOW_UP;
                }
                if (m19148d(partWithViewType)) {
                    return BackgroundStyler$Position.DIVIDER_BOTTOM_NON_TOP;
                }
                if (m19144a(m, i, a, feedProps)) {
                    return BackgroundStyler$Position.DIVIDER_TOP;
                }
                return BackgroundStyler$Position.MIDDLE;
            }
        } else if (m19148d(partWithViewType)) {
            return BackgroundStyler$Position.DIVIDER_BOTTOM;
        } else {
            return BackgroundStyler$Position.MIDDLE;
        }
    }

    public static PositionResolver m19143a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.m1499a();
        byte b = a.m1504b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().mo191b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            PositionResolver b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.m1330a(b2);
            synchronized (f13017d) {
                PositionResolver positionResolver;
                if (a2 != null) {
                    positionResolver = (PositionResolver) a2.mo818a(f13017d);
                } else {
                    positionResolver = f13016c;
                }
                if (positionResolver == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.m1333a(b2, injectorThreadStack);
                    try {
                        b3 = m19146b(injectorThreadStack.m1474e());
                        if (a2 != null) {
                            a2.mo822a(f13017d, b3);
                        } else {
                            f13016c = b3;
                        }
                    } finally {
                        ContextScope.m1331a(injectorThreadStack);
                    }
                } else {
                    b3 = positionResolver;
                }
            }
            return b3;
        } finally {
            a.m1505c(b);
        }
    }

    private boolean m19144a(int i, int i2, FeedProps<? extends FeedUnit> feedProps, FeedProps<? extends FeedUnit> feedProps2) {
        if (i == i2) {
            if ((m19139a((FeedProps) feedProps) == m19139a((FeedProps) feedProps2) ? 1 : null) == null) {
                return true;
            }
        }
        if (m19147b(feedProps, feedProps2) || m19147b(feedProps2, feedProps)) {
            return false;
        }
        return true;
    }

    @Nullable
    private static FeedProps<? extends FeedUnit> m19140a(@Nullable PartWithViewType partWithViewType, Object obj) {
        if (partWithViewType == null || m19145a((MultiRowSinglePartDefinition) partWithViewType, SpecialStylingType.GAP_PART_DEFINITION)) {
            return null;
        }
        if (obj instanceof FeedProps) {
            FeedProps feedProps = (FeedProps) obj;
            Flattenable flattenable = feedProps.f13444a;
            if (flattenable instanceof FeedUnit) {
                return (FeedProps) obj;
            }
            if (flattenable instanceof GraphQLStoryAttachment) {
                return AttachmentProps.m28715e(feedProps);
            }
        }
        if (obj instanceof HasFeedProps) {
            return ((HasFeedProps) obj).mo2637f();
        }
        return obj instanceof FeedUnit ? FeedProps.m19802c((FeedUnit) obj) : null;
    }

    @Nullable
    private static HasSpecialStyling m19142a(MultiRowSinglePartDefinition multiRowSinglePartDefinition) {
        return multiRowSinglePartDefinition instanceof HasSpecialStyling ? (HasSpecialStyling) multiRowSinglePartDefinition : null;
    }

    public static boolean m19145a(MultiRowSinglePartDefinition multiRowSinglePartDefinition, SpecialStylingType specialStylingType) {
        HasSpecialStyling a = m19142a(multiRowSinglePartDefinition);
        if (a != null && a.mo3125b() == specialStylingType) {
            return true;
        }
        return false;
    }

    public static boolean m19148d(MultiRowSinglePartDefinition multiRowSinglePartDefinition) {
        return m19145a(multiRowSinglePartDefinition, SpecialStylingType.NEED_BOTTOM_DIVIDER);
    }

    private static BackgroundStyler$Position m19141a(FeedUnit feedUnit, MultiRowSinglePartDefinition multiRowSinglePartDefinition) {
        if (m19145a(multiRowSinglePartDefinition, SpecialStylingType.MAYBE_HAS_COMMENTS_BELOW) && (feedUnit instanceof GraphQLStory)) {
            GraphQLStory graphQLStory = (GraphQLStory) feedUnit;
            Object obj = 1;
            if (graphQLStory.mo2890l() == null || GraphQLHelper.m22506g(graphQLStory.mo2890l()) <= 0) {
                if (graphQLStory.mo2890l() == null || graphQLStory.mo2890l().m23211E() == null) {
                    obj = null;
                } else if (graphQLStory.mo2890l().m23211E().m22671a() <= 0) {
                    obj = null;
                }
            }
            if (obj != null) {
                return BackgroundStyler$Position.MIDDLE;
            }
        }
        return BackgroundStyler$Position.BOTTOM;
    }

    @VisibleForTesting
    private boolean m19147b(FeedProps<? extends FeedUnit> feedProps, FeedProps<? extends FeedUnit> feedProps2) {
        FeedUnit feedUnit;
        FeedUnit feedUnit2;
        if (feedProps != null) {
            feedUnit = (FeedUnit) feedProps.f13444a;
        } else {
            feedUnit = null;
        }
        if (feedProps2 != null) {
            feedUnit2 = (FeedUnit) feedProps2.f13444a;
        } else {
            feedUnit2 = null;
        }
        if (GraphQLStoryUtil.m9568a(feedUnit, feedUnit2)) {
            return true;
        }
        if (!(feedUnit2 instanceof GraphQLStory)) {
            return false;
        }
        ImmutableList d = feedProps2.m19808d();
        int size = d.size();
        for (int i = 0; i < size; i++) {
            feedUnit2 = (FeedUnit) ((Flattenable) d.get(i));
            if (GraphQLStoryUtil.m9568a(feedUnit2, feedUnit)) {
                return true;
            }
            if (!(feedUnit2 instanceof GraphQLStory)) {
                return false;
            }
        }
        return false;
    }

    public static int m19139a(FeedProps<? extends FeedUnit> feedProps) {
        if (feedProps == null) {
            return -1;
        }
        return feedProps.m19808d().size();
    }
}
