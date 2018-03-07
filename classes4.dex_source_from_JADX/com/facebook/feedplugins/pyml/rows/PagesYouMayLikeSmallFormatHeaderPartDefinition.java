package com.facebook.feedplugins.pyml.rows;

import android.content.Context;
import android.view.View;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.HasMenuButtonProvider;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.sections.header.MenuButtonPartDefinition;
import com.facebook.feed.rows.sections.header.MenuButtonPartDefinition.Props;
import com.facebook.feed.rows.sections.header.ui.CanShowHeaderTitle.Sponsored;
import com.facebook.feed.rows.sections.header.ui.MenuConfig;
import com.facebook.feed.rows.sections.header.ui.TextHeaderStyle;
import com.facebook.feed.rows.sections.header.ui.TextWithMenuButtonView;
import com.facebook.feed.rows.styling.BackgroundPartDefinition;
import com.facebook.feed.rows.styling.BackgroundPartDefinition.StylingData;
import com.facebook.feed.rows.styling.PaddingStyle;
import com.facebook.graphql.model.GraphQLCreativePagesYouMayLikeFeedUnit;
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
import javax.inject.Inject;

@ContextScoped
/* compiled from: onSeekComplete */
public class PagesYouMayLikeSmallFormatHeaderPartDefinition<E extends HasPositionInformation & HasMenuButtonProvider> extends MultiRowSinglePartDefinition<FeedProps<GraphQLCreativePagesYouMayLikeFeedUnit>, Void, E, TextWithMenuButtonView> {
    private static final PaddingStyle f6130a = PaddingStyle.j;
    private static PagesYouMayLikeSmallFormatHeaderPartDefinition f6131d;
    private static final Object f6132e = new Object();
    private final BackgroundPartDefinition f6133b;
    private final MenuButtonPartDefinition f6134c;

    private static PagesYouMayLikeSmallFormatHeaderPartDefinition m6607b(InjectorLike injectorLike) {
        return new PagesYouMayLikeSmallFormatHeaderPartDefinition(BackgroundPartDefinition.a(injectorLike), MenuButtonPartDefinition.a(injectorLike));
    }

    public final Object m6609a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        FeedProps feedProps = (FeedProps) obj;
        subParts.a(this.f6133b, new StylingData(feedProps, f6130a));
        subParts.a(2131560877, this.f6134c, new Props(feedProps, MenuConfig.CLICKABLE));
        return null;
    }

    public final /* bridge */ /* synthetic */ void m6610a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, -865471299);
        TextWithMenuButtonView textWithMenuButtonView = (TextWithMenuButtonView) view;
        GraphQLCreativePagesYouMayLikeFeedUnit graphQLCreativePagesYouMayLikeFeedUnit = (GraphQLCreativePagesYouMayLikeFeedUnit) ((FeedProps) obj).a;
        textWithMenuButtonView.setStyle(TextHeaderStyle.SUGGESTED_CONTENT);
        textWithMenuButtonView.a(graphQLCreativePagesYouMayLikeFeedUnit.m().a(), Sponsored.NOT_SPONSORED);
        Logger.a(8, EntryType.MARK_POP, 10501324, a);
    }

    @Inject
    public PagesYouMayLikeSmallFormatHeaderPartDefinition(BackgroundPartDefinition backgroundPartDefinition, MenuButtonPartDefinition menuButtonPartDefinition) {
        this.f6133b = backgroundPartDefinition;
        this.f6134c = menuButtonPartDefinition;
    }

    public final ViewType m6608a() {
        return TextWithMenuButtonView.b;
    }

    public final boolean m6611a(Object obj) {
        return true;
    }

    public static PagesYouMayLikeSmallFormatHeaderPartDefinition m6606a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            PagesYouMayLikeSmallFormatHeaderPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f6132e) {
                PagesYouMayLikeSmallFormatHeaderPartDefinition pagesYouMayLikeSmallFormatHeaderPartDefinition;
                if (a2 != null) {
                    pagesYouMayLikeSmallFormatHeaderPartDefinition = (PagesYouMayLikeSmallFormatHeaderPartDefinition) a2.a(f6132e);
                } else {
                    pagesYouMayLikeSmallFormatHeaderPartDefinition = f6131d;
                }
                if (pagesYouMayLikeSmallFormatHeaderPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m6607b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f6132e, b3);
                        } else {
                            f6131d = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = pagesYouMayLikeSmallFormatHeaderPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
