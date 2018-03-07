package com.facebook.feedplugins.worktrending.rows;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import com.facebook.common.android.ResourcesMethodAutoProvider;
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
import com.facebook.graphql.model.GraphQLWorkCommunityTrendingFeedUnit;
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
/* compiled from: android.app.IActivityManager */
public class WorkTrendingHeaderPartDefinition<T extends GraphQLWorkCommunityTrendingFeedUnit> extends MultiRowSinglePartDefinition<FeedProps<T>, String, HasPositionInformation, TextWithMenuButtonView> {
    private static WorkTrendingHeaderPartDefinition f10028d;
    private static final Object f10029e = new Object();
    private final PaddingStyle f10030a;
    private final BackgroundPartDefinition f10031b;
    private final Resources f10032c;

    private static WorkTrendingHeaderPartDefinition m10377b(InjectorLike injectorLike) {
        return new WorkTrendingHeaderPartDefinition(ResourcesMethodAutoProvider.a(injectorLike), BackgroundPartDefinition.a(injectorLike), DefaultPaddingStyleResolver.a(injectorLike));
    }

    public final Object m10379a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        FeedProps feedProps = (FeedProps) obj;
        subParts.a(this.f10031b, new StylingData(feedProps, this.f10030a));
        GraphQLWorkCommunityTrendingFeedUnit graphQLWorkCommunityTrendingFeedUnit = (GraphQLWorkCommunityTrendingFeedUnit) feedProps.a;
        if (!(graphQLWorkCommunityTrendingFeedUnit instanceof GraphQLWorkCommunityTrendingFeedUnit) || graphQLWorkCommunityTrendingFeedUnit.q() == null) {
            return this.f10032c.getString(2131242496);
        }
        return graphQLWorkCommunityTrendingFeedUnit.q().a();
    }

    public final /* bridge */ /* synthetic */ void m10380a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, 1645105297);
        String str = (String) obj2;
        TextWithMenuButtonView textWithMenuButtonView = (TextWithMenuButtonView) view;
        textWithMenuButtonView.setStyle(TextHeaderStyle.SUGGESTED_CONTENT);
        textWithMenuButtonView.a(str, Sponsored.SPONSORED);
        textWithMenuButtonView.setMenuButtonActive(false);
        Logger.a(8, EntryType.MARK_POP, 1771263956, a);
    }

    @Inject
    public WorkTrendingHeaderPartDefinition(Resources resources, BackgroundPartDefinition backgroundPartDefinition, DefaultPaddingStyleResolver defaultPaddingStyleResolver) {
        this.f10032c = resources;
        this.f10031b = backgroundPartDefinition;
        Builder a = Builder.a();
        a.b = -defaultPaddingStyleResolver.d();
        a = a;
        a.c = defaultPaddingStyleResolver.c();
        this.f10030a = a.i();
    }

    public final boolean m10381a(Object obj) {
        return true;
    }

    public final ViewType<TextWithMenuButtonView> m10378a() {
        return TextWithMenuButtonView.b;
    }

    public static WorkTrendingHeaderPartDefinition m10376a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            WorkTrendingHeaderPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f10029e) {
                WorkTrendingHeaderPartDefinition workTrendingHeaderPartDefinition;
                if (a2 != null) {
                    workTrendingHeaderPartDefinition = (WorkTrendingHeaderPartDefinition) a2.a(f10029e);
                } else {
                    workTrendingHeaderPartDefinition = f10028d;
                }
                if (workTrendingHeaderPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m10377b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f10029e, b3);
                        } else {
                            f10028d = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = workTrendingHeaderPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
