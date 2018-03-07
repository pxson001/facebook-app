package com.facebook.feedplugins.gts.rows;

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
import com.facebook.graphql.model.GraphQLGroupTopStoriesFeedUnit;
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
/* compiled from: d609fa2315a657d0b36a1317f7ff6583 */
public class GroupTopStoriesHeaderPartDefinition extends MultiRowSinglePartDefinition<FeedProps<GraphQLGroupTopStoriesFeedUnit>, Void, FeedEnvironment, TextWithMenuButtonView> {
    private static GroupTopStoriesHeaderPartDefinition f7767c;
    private static final Object f7768d = new Object();
    private final BackgroundPartDefinition f7769a;
    private final MenuButtonPartDefinition f7770b;

    private static GroupTopStoriesHeaderPartDefinition m8937b(InjectorLike injectorLike) {
        return new GroupTopStoriesHeaderPartDefinition(BackgroundPartDefinition.a(injectorLike), MenuButtonPartDefinition.a(injectorLike));
    }

    public final Object m8939a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        FeedProps feedProps = (FeedProps) obj;
        subParts.a(this.f7769a, new StylingData(feedProps, PaddingStyle.j, Position.TOP));
        subParts.a(this.f7770b, new Props(feedProps, MenuConfig.CLICKABLE));
        return null;
    }

    public final /* bridge */ /* synthetic */ void m8940a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, -1900845435);
        FeedProps feedProps = (FeedProps) obj;
        TextWithMenuButtonView textWithMenuButtonView = (TextWithMenuButtonView) view;
        textWithMenuButtonView.setStyle(TextHeaderStyle.SUGGESTED_CONTENT);
        if (!(feedProps.a == null || ((GraphQLGroupTopStoriesFeedUnit) feedProps.a).m() == null)) {
            textWithMenuButtonView.a(((GraphQLGroupTopStoriesFeedUnit) feedProps.a).m().a(), Sponsored.NOT_SPONSORED);
        }
        textWithMenuButtonView.setMenuButtonActive(true);
        Logger.a(8, EntryType.MARK_POP, 1738053440, a);
    }

    public final boolean m8941a(Object obj) {
        FeedProps feedProps = (FeedProps) obj;
        return (feedProps.a == null || ((GraphQLGroupTopStoriesFeedUnit) feedProps.a).l() == null || ((GraphQLGroupTopStoriesFeedUnit) feedProps.a).l().a() == null || ((GraphQLGroupTopStoriesFeedUnit) feedProps.a).l().a().size() <= 1) ? false : true;
    }

    @Inject
    public GroupTopStoriesHeaderPartDefinition(BackgroundPartDefinition backgroundPartDefinition, MenuButtonPartDefinition menuButtonPartDefinition) {
        this.f7769a = backgroundPartDefinition;
        this.f7770b = menuButtonPartDefinition;
    }

    public final ViewType m8938a() {
        return TextWithMenuButtonView.b;
    }

    public static GroupTopStoriesHeaderPartDefinition m8936a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            GroupTopStoriesHeaderPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f7768d) {
                GroupTopStoriesHeaderPartDefinition groupTopStoriesHeaderPartDefinition;
                if (a2 != null) {
                    groupTopStoriesHeaderPartDefinition = (GroupTopStoriesHeaderPartDefinition) a2.a(f7768d);
                } else {
                    groupTopStoriesHeaderPartDefinition = f7767c;
                }
                if (groupTopStoriesHeaderPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m8937b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f7768d, b3);
                        } else {
                            f7767c = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = groupTopStoriesHeaderPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
