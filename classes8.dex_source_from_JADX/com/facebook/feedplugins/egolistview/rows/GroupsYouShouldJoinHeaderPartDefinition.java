package com.facebook.feedplugins.egolistview.rows;

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
import com.facebook.feed.rows.styling.DefaultPaddingStyleResolver;
import com.facebook.feed.rows.styling.PaddingStyle;
import com.facebook.feed.rows.styling.PaddingStyle.Builder;
import com.facebook.graphql.model.GroupsYouShouldJoinFeedUnit;
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
/* compiled from: gravity_start_scan_session */
public class GroupsYouShouldJoinHeaderPartDefinition extends MultiRowSinglePartDefinition<FeedProps<? extends GroupsYouShouldJoinFeedUnit>, Void, HasPositionInformation, TextWithMenuButtonView> {
    private static GroupsYouShouldJoinHeaderPartDefinition f12053c;
    private static final Object f12054d = new Object();
    private final PaddingStyle f12055a;
    private final BackgroundPartDefinition f12056b;

    private static GroupsYouShouldJoinHeaderPartDefinition m14095b(InjectorLike injectorLike) {
        return new GroupsYouShouldJoinHeaderPartDefinition(BackgroundPartDefinition.a(injectorLike), DefaultPaddingStyleResolver.a(injectorLike));
    }

    public final Object m14097a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        subParts.a(this.f12056b, new StylingData((FeedProps) obj, this.f12055a));
        return null;
    }

    public final /* bridge */ /* synthetic */ void m14098a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, -1265914189);
        FeedProps feedProps = (FeedProps) obj;
        TextWithMenuButtonView textWithMenuButtonView = (TextWithMenuButtonView) view;
        textWithMenuButtonView.setStyle(TextHeaderStyle.SUGGESTED_CONTENT);
        textWithMenuButtonView.a(((GroupsYouShouldJoinFeedUnit) feedProps.a).m().a(), Sponsored.NOT_SPONSORED);
        textWithMenuButtonView.setMenuButtonActive(false);
        Logger.a(8, EntryType.MARK_POP, 1343210250, a);
    }

    @Inject
    public GroupsYouShouldJoinHeaderPartDefinition(BackgroundPartDefinition backgroundPartDefinition, DefaultPaddingStyleResolver defaultPaddingStyleResolver) {
        this.f12056b = backgroundPartDefinition;
        Builder a = Builder.a();
        a.b = -defaultPaddingStyleResolver.d();
        a = a;
        a.c = defaultPaddingStyleResolver.c();
        this.f12055a = a.i();
    }

    public final ViewType m14096a() {
        return TextWithMenuButtonView.b;
    }

    public final boolean m14099a(Object obj) {
        return true;
    }

    public static GroupsYouShouldJoinHeaderPartDefinition m14094a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            GroupsYouShouldJoinHeaderPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f12054d) {
                GroupsYouShouldJoinHeaderPartDefinition groupsYouShouldJoinHeaderPartDefinition;
                if (a2 != null) {
                    groupsYouShouldJoinHeaderPartDefinition = (GroupsYouShouldJoinHeaderPartDefinition) a2.a(f12054d);
                } else {
                    groupsYouShouldJoinHeaderPartDefinition = f12053c;
                }
                if (groupsYouShouldJoinHeaderPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m14095b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f12054d, b3);
                        } else {
                            f12053c = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = groupsYouShouldJoinHeaderPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
