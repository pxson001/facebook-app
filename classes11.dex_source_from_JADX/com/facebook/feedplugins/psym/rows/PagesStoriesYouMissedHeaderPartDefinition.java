package com.facebook.feedplugins.psym.rows;

import android.content.Context;
import android.view.View;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.FeedEnvironment;
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
import com.facebook.feed.rows.styling.BackgroundStyler.Position;
import com.facebook.feed.rows.styling.PaddingStyle;
import com.facebook.graphql.model.GraphQLPageStoriesYouMissedFeedUnit;
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
/* compiled from: collections_per_app */
public class PagesStoriesYouMissedHeaderPartDefinition extends MultiRowSinglePartDefinition<FeedProps<GraphQLPageStoriesYouMissedFeedUnit>, Void, FeedEnvironment, TextWithMenuButtonView> {
    private static PagesStoriesYouMissedHeaderPartDefinition f8605c;
    private static final Object f8606d = new Object();
    private final BackgroundPartDefinition f8607a;
    private final MenuButtonPartDefinition f8608b;

    private static PagesStoriesYouMissedHeaderPartDefinition m9447b(InjectorLike injectorLike) {
        return new PagesStoriesYouMissedHeaderPartDefinition(BackgroundPartDefinition.a(injectorLike), MenuButtonPartDefinition.a(injectorLike));
    }

    public final Object m9449a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        FeedProps feedProps = (FeedProps) obj;
        subParts.a(this.f8607a, new StylingData(feedProps, PaddingStyle.j, Position.TOP));
        subParts.a(this.f8608b, new Props(feedProps, MenuConfig.CLICKABLE));
        return null;
    }

    public final /* bridge */ /* synthetic */ void m9450a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, 885927056);
        FeedProps feedProps = (FeedProps) obj;
        TextWithMenuButtonView textWithMenuButtonView = (TextWithMenuButtonView) view;
        textWithMenuButtonView.setStyle(TextHeaderStyle.SUGGESTED_CONTENT);
        textWithMenuButtonView.a(((GraphQLPageStoriesYouMissedFeedUnit) feedProps.a).s().a(), Sponsored.NOT_SPONSORED);
        textWithMenuButtonView.setMenuButtonActive(true);
        Logger.a(8, EntryType.MARK_POP, -1796601218, a);
    }

    public final boolean m9451a(Object obj) {
        FeedProps feedProps = (FeedProps) obj;
        return (feedProps == null || feedProps.a == null || ((GraphQLPageStoriesYouMissedFeedUnit) feedProps.a).s() == null || ((GraphQLPageStoriesYouMissedFeedUnit) feedProps.a).s().a() == null) ? false : true;
    }

    @Inject
    public PagesStoriesYouMissedHeaderPartDefinition(BackgroundPartDefinition backgroundPartDefinition, MenuButtonPartDefinition menuButtonPartDefinition) {
        this.f8607a = backgroundPartDefinition;
        this.f8608b = menuButtonPartDefinition;
    }

    public final ViewType<TextWithMenuButtonView> m9448a() {
        return TextWithMenuButtonView.b;
    }

    public static PagesStoriesYouMissedHeaderPartDefinition m9446a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            PagesStoriesYouMissedHeaderPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f8606d) {
                PagesStoriesYouMissedHeaderPartDefinition pagesStoriesYouMissedHeaderPartDefinition;
                if (a2 != null) {
                    pagesStoriesYouMissedHeaderPartDefinition = (PagesStoriesYouMissedHeaderPartDefinition) a2.a(f8606d);
                } else {
                    pagesStoriesYouMissedHeaderPartDefinition = f8605c;
                }
                if (pagesStoriesYouMissedHeaderPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m9447b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f8606d, b3);
                        } else {
                            f8605c = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = pagesStoriesYouMissedHeaderPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
