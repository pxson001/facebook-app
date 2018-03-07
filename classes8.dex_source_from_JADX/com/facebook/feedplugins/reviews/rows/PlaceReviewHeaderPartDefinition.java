package com.facebook.feedplugins.reviews.rows;

import android.content.Context;
import android.view.View;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.sections.header.ui.CanShowHeaderTitle.Sponsored;
import com.facebook.feed.rows.sections.header.ui.TextHeaderStyle;
import com.facebook.feed.rows.sections.header.ui.TextWithMenuButtonView;
import com.facebook.feed.rows.styling.BackgroundPartDefinition;
import com.facebook.feed.rows.styling.BackgroundPartDefinition.StylingData;
import com.facebook.feed.rows.styling.PaddingStyle;
import com.facebook.graphql.model.GraphQLPlaceReviewFeedUnit;
import com.facebook.graphql.model.ItemListFeedUnitImpl;
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
import com.google.common.collect.ImmutableList;
import javax.inject.Inject;

@ContextScoped
/* compiled from: friendMembers */
public class PlaceReviewHeaderPartDefinition extends MultiRowSinglePartDefinition<FeedProps<GraphQLPlaceReviewFeedUnit>, CharSequence, HasPositionInformation, TextWithMenuButtonView> {
    private static final PaddingStyle f12956a = PaddingStyle.j;
    private static PlaceReviewHeaderPartDefinition f12957c;
    private static final Object f12958d = new Object();
    private final BackgroundPartDefinition f12959b;

    private static PlaceReviewHeaderPartDefinition m14687b(InjectorLike injectorLike) {
        return new PlaceReviewHeaderPartDefinition(BackgroundPartDefinition.a(injectorLike));
    }

    public final Object m14689a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        FeedProps feedProps = (FeedProps) obj;
        subParts.a(this.f12959b, new StylingData(feedProps, f12956a));
        return ((GraphQLPlaceReviewFeedUnit) feedProps.a).p().a();
    }

    public final /* bridge */ /* synthetic */ void m14690a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, 1320410167);
        CharSequence charSequence = (CharSequence) obj2;
        TextWithMenuButtonView textWithMenuButtonView = (TextWithMenuButtonView) view;
        textWithMenuButtonView.setStyle(TextHeaderStyle.SUGGESTED_CONTENT);
        textWithMenuButtonView.a(charSequence, Sponsored.NOT_SPONSORED);
        textWithMenuButtonView.setMenuButtonActive(false);
        Logger.a(8, EntryType.MARK_POP, 811451583, a);
    }

    public final boolean m14691a(Object obj) {
        ImmutableList a = ItemListFeedUnitImpl.a((GraphQLPlaceReviewFeedUnit) ((FeedProps) obj).a);
        return (a == null || a.isEmpty()) ? false : true;
    }

    @Inject
    public PlaceReviewHeaderPartDefinition(BackgroundPartDefinition backgroundPartDefinition) {
        this.f12959b = backgroundPartDefinition;
    }

    public final ViewType m14688a() {
        return TextWithMenuButtonView.b;
    }

    public static PlaceReviewHeaderPartDefinition m14686a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            PlaceReviewHeaderPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f12958d) {
                PlaceReviewHeaderPartDefinition placeReviewHeaderPartDefinition;
                if (a2 != null) {
                    placeReviewHeaderPartDefinition = (PlaceReviewHeaderPartDefinition) a2.a(f12958d);
                } else {
                    placeReviewHeaderPartDefinition = f12957c;
                }
                if (placeReviewHeaderPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m14687b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f12958d, b3);
                        } else {
                            f12957c = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = placeReviewHeaderPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
