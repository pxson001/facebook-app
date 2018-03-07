package com.facebook.search.results.rows.sections.derp;

import android.content.Context;
import android.view.View;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.styling.BackgroundPartDefinition;
import com.facebook.feed.rows.styling.BackgroundPartDefinition.StylingData;
import com.facebook.feed.rows.styling.BackgroundStyler.Position;
import com.facebook.feed.rows.styling.PaddingStyle;
import com.facebook.graphql.enums.GraphQLGraphSearchResultRole;
import com.facebook.graphql.model.StoryTextHelper;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.api.ViewType;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.search.abtest.ExperimentsForSearchAbTestModule;
import com.facebook.search.results.environment.HasSearchResultsContext;
import com.facebook.search.results.model.unit.SearchResultsStoryUnit;
import com.facebook.search.results.rows.sections.livefeed.LiveFeedHeaderPartDefinition;
import com.google.common.base.Strings;
import javax.inject.Inject;

@ContextScoped
/* compiled from: REACTION_HEADER_DISPLAYED */
public class DerpSuperDenseHeaderNoAttachmentPartDefinition<E extends HasPositionInformation & HasSearchResultsContext> extends MultiRowSinglePartDefinition<FeedProps<SearchResultsStoryUnit>, Void, E, DerpSuperDenseHeaderView> {
    public static final ViewType f24072a = new C25651();
    private static DerpSuperDenseHeaderNoAttachmentPartDefinition f24073e;
    private static final Object f24074f = new Object();
    private final LiveFeedHeaderPartDefinition f24075b;
    private final BackgroundPartDefinition f24076c;
    private final QeAccessor f24077d;

    /* compiled from: REACTION_HEADER_DISPLAYED */
    final class C25651 extends ViewType {
        C25651() {
        }

        public final View m27626a(Context context) {
            return new DerpSuperDenseHeaderView(context);
        }
    }

    private static DerpSuperDenseHeaderNoAttachmentPartDefinition m27628b(InjectorLike injectorLike) {
        return new DerpSuperDenseHeaderNoAttachmentPartDefinition(LiveFeedHeaderPartDefinition.m27927a(injectorLike), BackgroundPartDefinition.a(injectorLike), (QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike));
    }

    public final Object m27630a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        FeedProps feedProps = (FeedProps) obj;
        subParts.a(this.f24075b, FeedProps.c(((SearchResultsStoryUnit) feedProps.a).mo1333f()));
        subParts.a(this.f24076c, new StylingData(feedProps, PaddingStyle.a, Position.DIVIDER_BOTTOM_NON_TOP));
        return null;
    }

    public final boolean m27631a(Object obj) {
        FeedProps feedProps = (FeedProps) obj;
        if (feedProps.a == null || ((SearchResultsStoryUnit) feedProps.a).mo1333f() == null) {
            return false;
        }
        if (((SearchResultsStoryUnit) feedProps.a).mo1321k() != GraphQLGraphSearchResultRole.PUBLIC_POSTS) {
            return false;
        }
        if (Strings.isNullOrEmpty(StoryTextHelper.a(((SearchResultsStoryUnit) feedProps.a).mo1333f()))) {
            return false;
        }
        return this.f24077d.a(ExperimentsForSearchAbTestModule.bN, false);
    }

    @Inject
    public DerpSuperDenseHeaderNoAttachmentPartDefinition(LiveFeedHeaderPartDefinition liveFeedHeaderPartDefinition, BackgroundPartDefinition backgroundPartDefinition, QeAccessor qeAccessor) {
        this.f24075b = liveFeedHeaderPartDefinition;
        this.f24076c = backgroundPartDefinition;
        this.f24077d = qeAccessor;
    }

    public static DerpSuperDenseHeaderNoAttachmentPartDefinition m27627a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            DerpSuperDenseHeaderNoAttachmentPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f24074f) {
                DerpSuperDenseHeaderNoAttachmentPartDefinition derpSuperDenseHeaderNoAttachmentPartDefinition;
                if (a2 != null) {
                    derpSuperDenseHeaderNoAttachmentPartDefinition = (DerpSuperDenseHeaderNoAttachmentPartDefinition) a2.a(f24074f);
                } else {
                    derpSuperDenseHeaderNoAttachmentPartDefinition = f24073e;
                }
                if (derpSuperDenseHeaderNoAttachmentPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m27628b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f24074f, b3);
                        } else {
                            f24073e = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = derpSuperDenseHeaderNoAttachmentPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    public final ViewType<DerpSuperDenseHeaderView> m27629a() {
        return f24072a;
    }
}
