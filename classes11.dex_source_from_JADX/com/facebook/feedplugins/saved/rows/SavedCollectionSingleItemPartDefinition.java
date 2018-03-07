package com.facebook.feedplugins.saved.rows;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.styling.BackgroundPartDefinition;
import com.facebook.feed.rows.styling.BackgroundPartDefinition.StylingData;
import com.facebook.feed.rows.styling.PaddingStyle;
import com.facebook.feedplugins.saved.rows.SavedCollectionPageItemPartDefinition.Props;
import com.facebook.feedplugins.saved.rows.ui.SavedCollectionItemView;
import com.facebook.graphql.model.GraphQLSavedCollectionFeedUnit;
import com.facebook.graphql.model.GraphQLSavedCollectionFeedUnitItem;
import com.facebook.graphql.model.ScrollableItemListFeedUnitImpl;
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
/* compiled from: bundle_feed_padding_top */
public class SavedCollectionSingleItemPartDefinition extends MultiRowSinglePartDefinition<FeedProps<GraphQLSavedCollectionFeedUnit>, Void, HasPositionInformation, SavedCollectionItemView> {
    private static SavedCollectionSingleItemPartDefinition f9335c;
    private static final Object f9336d = new Object();
    private final SavedCollectionPageItemPartDefinition f9337a;
    private final BackgroundPartDefinition f9338b;

    private static SavedCollectionSingleItemPartDefinition m9946b(InjectorLike injectorLike) {
        return new SavedCollectionSingleItemPartDefinition(SavedCollectionPageItemPartDefinition.m9925a(injectorLike), BackgroundPartDefinition.a(injectorLike));
    }

    public final Object m9948a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        FeedProps feedProps = (FeedProps) obj;
        GraphQLSavedCollectionFeedUnit graphQLSavedCollectionFeedUnit = (GraphQLSavedCollectionFeedUnit) feedProps.a;
        subParts.a(this.f9338b, new StylingData(feedProps, PaddingStyle.a));
        subParts.a(this.f9337a, new Props(feedProps, (GraphQLSavedCollectionFeedUnitItem) ScrollableItemListFeedUnitImpl.a(graphQLSavedCollectionFeedUnit).get(0), true));
        return null;
    }

    public final boolean m9949a(Object obj) {
        return ((GraphQLSavedCollectionFeedUnit) ((FeedProps) obj).a).l().size() == 1;
    }

    @Inject
    public SavedCollectionSingleItemPartDefinition(SavedCollectionPageItemPartDefinition savedCollectionPageItemPartDefinition, BackgroundPartDefinition backgroundPartDefinition) {
        this.f9337a = savedCollectionPageItemPartDefinition;
        this.f9338b = backgroundPartDefinition;
    }

    public final ViewType m9947a() {
        return SavedCollectionItemView.a;
    }

    public static SavedCollectionSingleItemPartDefinition m9945a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            SavedCollectionSingleItemPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f9336d) {
                SavedCollectionSingleItemPartDefinition savedCollectionSingleItemPartDefinition;
                if (a2 != null) {
                    savedCollectionSingleItemPartDefinition = (SavedCollectionSingleItemPartDefinition) a2.a(f9336d);
                } else {
                    savedCollectionSingleItemPartDefinition = f9335c;
                }
                if (savedCollectionSingleItemPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m9946b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f9336d, b3);
                        } else {
                            f9335c = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = savedCollectionSingleItemPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
