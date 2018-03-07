package com.facebook.feedplugins.saved.rows;

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
import com.facebook.feed.rows.styling.PaddingStyle.Builder;
import com.facebook.graphql.model.GraphQLSavedCollectionFeedUnit;
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
/* compiled from: bundle_header_collection */
public class SavedCollectionHeaderPartDefinition<E extends HasPositionInformation & HasMenuButtonProvider> extends MultiRowSinglePartDefinition<FeedProps<GraphQLSavedCollectionFeedUnit>, String, E, TextWithMenuButtonView> {
    private static final PaddingStyle f9296a;
    private static SavedCollectionHeaderPartDefinition f9297d;
    private static final Object f9298e = new Object();
    private final BackgroundPartDefinition f9299b;
    private final MenuButtonPartDefinition f9300c;

    private static SavedCollectionHeaderPartDefinition m9918b(InjectorLike injectorLike) {
        return new SavedCollectionHeaderPartDefinition(BackgroundPartDefinition.a(injectorLike), MenuButtonPartDefinition.a(injectorLike));
    }

    public final Object m9920a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        FeedProps feedProps = (FeedProps) obj;
        GraphQLSavedCollectionFeedUnit graphQLSavedCollectionFeedUnit = (GraphQLSavedCollectionFeedUnit) feedProps.a;
        subParts.a(this.f9299b, new StylingData(feedProps, f9296a));
        subParts.a(2131560877, this.f9300c, new Props(feedProps, MenuConfig.CLICKABLE));
        return graphQLSavedCollectionFeedUnit.m().a();
    }

    public final /* bridge */ /* synthetic */ void m9921a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, 127255828);
        String str = (String) obj2;
        TextWithMenuButtonView textWithMenuButtonView = (TextWithMenuButtonView) view;
        textWithMenuButtonView.setStyle(TextHeaderStyle.SUGGESTED_CONTENT);
        textWithMenuButtonView.a(str, Sponsored.NOT_SPONSORED);
        Logger.a(8, EntryType.MARK_POP, -398813815, a);
    }

    static {
        Builder g = Builder.g();
        g.b = 2.0f;
        g = g;
        g.e = -12.0f;
        g = g;
        g.c = 11.0f;
        f9296a = g.i();
    }

    @Inject
    public SavedCollectionHeaderPartDefinition(BackgroundPartDefinition backgroundPartDefinition, MenuButtonPartDefinition menuButtonPartDefinition) {
        this.f9299b = backgroundPartDefinition;
        this.f9300c = menuButtonPartDefinition;
    }

    public final ViewType m9919a() {
        return TextWithMenuButtonView.b;
    }

    public static SavedCollectionHeaderPartDefinition m9917a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            SavedCollectionHeaderPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f9298e) {
                SavedCollectionHeaderPartDefinition savedCollectionHeaderPartDefinition;
                if (a2 != null) {
                    savedCollectionHeaderPartDefinition = (SavedCollectionHeaderPartDefinition) a2.a(f9298e);
                } else {
                    savedCollectionHeaderPartDefinition = f9297d;
                }
                if (savedCollectionHeaderPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m9918b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f9298e, b3);
                        } else {
                            f9297d = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = savedCollectionHeaderPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    public final boolean m9922a(Object obj) {
        return true;
    }
}
