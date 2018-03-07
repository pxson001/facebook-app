package com.facebook.groups.feed.ui.partdefinitions;

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
import com.facebook.feed.rows.styling.HasSpecialStyling;
import com.facebook.feed.rows.styling.HasSpecialStyling.SpecialStylingType;
import com.facebook.feed.rows.styling.PaddingStyle;
import com.facebook.feed.rows.styling.PaddingStyle.Builder;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.groups.feed.ui.ExperimentsForGroupsFeedUiModule;
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
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import javax.inject.Inject;

@ContextScoped
/* compiled from: ThreadViewLoader */
public class GroupsAboveHeaderPartDefinition extends MultiRowSinglePartDefinition<FeedProps<GraphQLStory>, Void, HasPositionInformation, TextWithMenuButtonView> implements HasSpecialStyling {
    private static GroupsAboveHeaderPartDefinition f22431e;
    private static final Object f22432f = new Object();
    public final Context f22433a;
    private final PaddingStyle f22434b;
    private final BackgroundPartDefinition f22435c;
    private final QeAccessor f22436d;

    private static GroupsAboveHeaderPartDefinition m23510b(InjectorLike injectorLike) {
        return new GroupsAboveHeaderPartDefinition((Context) injectorLike.getInstance(Context.class), BackgroundPartDefinition.a(injectorLike), DefaultPaddingStyleResolver.a(injectorLike), (QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike));
    }

    public final Object m23512a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        subParts.a(this.f22435c, new StylingData((FeedProps) obj, this.f22434b));
        return null;
    }

    public final /* bridge */ /* synthetic */ void m23513a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, 1379929608);
        TextWithMenuButtonView textWithMenuButtonView = (TextWithMenuButtonView) view;
        textWithMenuButtonView.setStyle(TextHeaderStyle.SUGGESTED_CONTENT);
        textWithMenuButtonView.a(this.f22433a.getResources().getString(2131238075), Sponsored.NOT_SPONSORED);
        textWithMenuButtonView.setMenuButtonActive(false);
        Logger.a(8, EntryType.MARK_POP, -1720748264, a);
    }

    public final boolean m23514a(Object obj) {
        GraphQLStory graphQLStory = (GraphQLStory) ((FeedProps) obj).a;
        return graphQLStory != null && graphQLStory.u() && this.f22436d.a(ExperimentsForGroupsFeedUiModule.f22012b, true);
    }

    @Inject
    public GroupsAboveHeaderPartDefinition(Context context, BackgroundPartDefinition backgroundPartDefinition, DefaultPaddingStyleResolver defaultPaddingStyleResolver, QeAccessor qeAccessor) {
        this.f22433a = context;
        this.f22435c = backgroundPartDefinition;
        Builder a = Builder.a();
        a.b = -defaultPaddingStyleResolver.d();
        a = a;
        a.c = defaultPaddingStyleResolver.c();
        this.f22434b = a.i();
        this.f22436d = qeAccessor;
    }

    public static GroupsAboveHeaderPartDefinition m23509a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            GroupsAboveHeaderPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f22432f) {
                GroupsAboveHeaderPartDefinition groupsAboveHeaderPartDefinition;
                if (a2 != null) {
                    groupsAboveHeaderPartDefinition = (GroupsAboveHeaderPartDefinition) a2.a(f22432f);
                } else {
                    groupsAboveHeaderPartDefinition = f22431e;
                }
                if (groupsAboveHeaderPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m23510b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f22432f, b3);
                        } else {
                            f22431e = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = groupsAboveHeaderPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    public final ViewType m23511a() {
        return TextWithMenuButtonView.b;
    }

    public final SpecialStylingType m23515b() {
        return SpecialStylingType.NEED_BOTTOM_DIVIDER;
    }
}
