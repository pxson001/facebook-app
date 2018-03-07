package com.facebook.feedplugins.gysc.partdefinitions;

import android.content.Context;
import android.view.View;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.common.util.CollectionUtil;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.sections.header.ui.CanShowHeaderTitle.Sponsored;
import com.facebook.feed.rows.sections.header.ui.TextHeaderStyle;
import com.facebook.feed.rows.sections.header.ui.TextWithMenuButtonView;
import com.facebook.feed.rows.styling.BackgroundPartDefinition;
import com.facebook.feed.rows.styling.BackgroundPartDefinition.StylingData;
import com.facebook.feed.rows.styling.DefaultPaddingStyleResolver;
import com.facebook.feed.rows.styling.PaddingStyle;
import com.facebook.feed.rows.styling.PaddingStyle.Builder;
import com.facebook.graphql.model.GraphQLGroupsYouShouldCreateFeedUnit;
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
/* compiled from: friends_tab_suggestions */
public class GroupsYouShouldCreateHeaderPartDefinition extends MultiRowSinglePartDefinition<FeedProps<GraphQLGroupsYouShouldCreateFeedUnit>, Void, HasPositionInformation, TextWithMenuButtonView> {
    private static GroupsYouShouldCreateHeaderPartDefinition f12834c;
    private static final Object f12835d = new Object();
    private final PaddingStyle f12836a;
    private final BackgroundPartDefinition f12837b;

    private static GroupsYouShouldCreateHeaderPartDefinition m14604b(InjectorLike injectorLike) {
        return new GroupsYouShouldCreateHeaderPartDefinition(BackgroundPartDefinition.a(injectorLike), DefaultPaddingStyleResolver.a(injectorLike));
    }

    public final Object m14606a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        subParts.a(this.f12837b, new StylingData((FeedProps) obj, this.f12836a));
        return null;
    }

    public final /* bridge */ /* synthetic */ void m14607a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, 970004501);
        FeedProps feedProps = (FeedProps) obj;
        TextWithMenuButtonView textWithMenuButtonView = (TextWithMenuButtonView) view;
        textWithMenuButtonView.setStyle(TextHeaderStyle.SUGGESTED_CONTENT);
        textWithMenuButtonView.a(((GraphQLGroupsYouShouldCreateFeedUnit) feedProps.a).m().a(), Sponsored.NOT_SPONSORED);
        textWithMenuButtonView.setMenuButtonActive(false);
        Logger.a(8, EntryType.MARK_POP, 790680756, a);
    }

    public final boolean m14608a(Object obj) {
        FeedProps feedProps = (FeedProps) obj;
        if (feedProps.a == null) {
            return false;
        }
        return CollectionUtil.b(((GraphQLGroupsYouShouldCreateFeedUnit) feedProps.a).l());
    }

    @Inject
    public GroupsYouShouldCreateHeaderPartDefinition(BackgroundPartDefinition backgroundPartDefinition, DefaultPaddingStyleResolver defaultPaddingStyleResolver) {
        this.f12837b = backgroundPartDefinition;
        Builder a = Builder.a();
        a.b = -defaultPaddingStyleResolver.d();
        a = a;
        a.c = defaultPaddingStyleResolver.c();
        this.f12836a = a.i();
    }

    public final ViewType m14605a() {
        return TextWithMenuButtonView.b;
    }

    public static GroupsYouShouldCreateHeaderPartDefinition m14603a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            GroupsYouShouldCreateHeaderPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f12835d) {
                GroupsYouShouldCreateHeaderPartDefinition groupsYouShouldCreateHeaderPartDefinition;
                if (a2 != null) {
                    groupsYouShouldCreateHeaderPartDefinition = (GroupsYouShouldCreateHeaderPartDefinition) a2.a(f12835d);
                } else {
                    groupsYouShouldCreateHeaderPartDefinition = f12834c;
                }
                if (groupsYouShouldCreateHeaderPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m14604b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f12835d, b3);
                        } else {
                            f12834c = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = groupsYouShouldCreateHeaderPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
