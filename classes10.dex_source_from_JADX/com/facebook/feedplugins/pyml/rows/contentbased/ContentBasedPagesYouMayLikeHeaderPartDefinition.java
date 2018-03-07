package com.facebook.feedplugins.pyml.rows.contentbased;

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
import com.facebook.graphql.model.GraphQLPagesYouMayLikeFeedUnit;
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
/* compiled from: android.intent.extra.REFERRER_NAME */
public class ContentBasedPagesYouMayLikeHeaderPartDefinition<E extends HasMenuButtonProvider & HasPositionInformation> extends MultiRowSinglePartDefinition<FeedProps<GraphQLPagesYouMayLikeFeedUnit>, Void, E, TextWithMenuButtonView> {
    private static ContentBasedPagesYouMayLikeHeaderPartDefinition f19862c;
    private static final Object f19863d = new Object();
    private final BackgroundPartDefinition f19864a;
    private final MenuButtonPartDefinition f19865b;

    private static ContentBasedPagesYouMayLikeHeaderPartDefinition m20077b(InjectorLike injectorLike) {
        return new ContentBasedPagesYouMayLikeHeaderPartDefinition(MenuButtonPartDefinition.a(injectorLike), BackgroundPartDefinition.a(injectorLike));
    }

    public final Object m20079a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        FeedProps feedProps = (FeedProps) obj;
        subParts.a(this.f19864a, new StylingData(feedProps, PaddingStyle.j));
        subParts.a(2131560877, this.f19865b, new Props(feedProps, MenuConfig.CLICKABLE));
        return null;
    }

    public final /* bridge */ /* synthetic */ void m20080a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, 2089820593);
        TextWithMenuButtonView textWithMenuButtonView = (TextWithMenuButtonView) view;
        GraphQLPagesYouMayLikeFeedUnit graphQLPagesYouMayLikeFeedUnit = (GraphQLPagesYouMayLikeFeedUnit) ((FeedProps) obj).a;
        textWithMenuButtonView.setStyle(TextHeaderStyle.SUGGESTED_CONTENT);
        textWithMenuButtonView.setMenuButtonActive(true);
        textWithMenuButtonView.a(graphQLPagesYouMayLikeFeedUnit.A().a(), Sponsored.NOT_SPONSORED);
        Logger.a(8, EntryType.MARK_POP, -1432175373, a);
    }

    @Inject
    public ContentBasedPagesYouMayLikeHeaderPartDefinition(MenuButtonPartDefinition menuButtonPartDefinition, BackgroundPartDefinition backgroundPartDefinition) {
        this.f19865b = menuButtonPartDefinition;
        this.f19864a = backgroundPartDefinition;
    }

    public final ViewType m20078a() {
        return TextWithMenuButtonView.b;
    }

    public final boolean m20081a(Object obj) {
        return true;
    }

    public static ContentBasedPagesYouMayLikeHeaderPartDefinition m20076a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ContentBasedPagesYouMayLikeHeaderPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f19863d) {
                ContentBasedPagesYouMayLikeHeaderPartDefinition contentBasedPagesYouMayLikeHeaderPartDefinition;
                if (a2 != null) {
                    contentBasedPagesYouMayLikeHeaderPartDefinition = (ContentBasedPagesYouMayLikeHeaderPartDefinition) a2.a(f19863d);
                } else {
                    contentBasedPagesYouMayLikeHeaderPartDefinition = f19862c;
                }
                if (contentBasedPagesYouMayLikeHeaderPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m20077b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f19863d, b3);
                        } else {
                            f19862c = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = contentBasedPagesYouMayLikeHeaderPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
