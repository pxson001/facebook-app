package com.facebook.feed.rows.sections.header;

import android.content.Context;
import android.view.View;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.HasContext;
import com.facebook.feed.environment.HasInvalidate;
import com.facebook.feed.environment.HasMenuButtonProvider;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.core.props.StoryProps;
import com.facebook.feed.rows.sections.header.HeaderTitleWithLayoutPartDefinition.Props;
import com.facebook.feed.rows.sections.header.ui.CanShowHeaderOptionsMenu;
import com.facebook.feed.rows.sections.header.ui.CanShowHeaderTitle;
import com.facebook.feed.rows.sections.header.ui.StyleableTextHeader;
import com.facebook.feed.rows.sections.header.ui.TextHeaderStyle;
import com.facebook.feed.rows.styling.BackgroundPartDefinition;
import com.facebook.feed.rows.styling.BackgroundPartDefinition.StylingData;
import com.facebook.feed.rows.styling.PaddingStyle;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.StoryHierarchyHelper;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.BaseSinglePartDefinition;
import com.facebook.multirow.api.SubParts;
import javax.inject.Inject;

@ContextScoped
/* compiled from: feed_user_left_app */
public class TextHeaderPartDefinition<E extends HasMenuButtonProvider & HasPositionInformation & HasPersistentState & HasInvalidate & HasContext, V extends View & CanShowHeaderTitle & CanShowHeaderOptionsMenu & StyleableTextHeader> extends BaseSinglePartDefinition<FeedProps<GraphQLStory>, Void, E, V> {
    private static final PaddingStyle f24475a = PaddingStyle.f13080j;
    private static TextHeaderPartDefinition f24476d;
    private static final Object f24477e = new Object();
    private final HeaderTitleWithLayoutPartDefinition<E> f24478b;
    private final BackgroundPartDefinition f24479c;

    private static TextHeaderPartDefinition m32785b(InjectorLike injectorLike) {
        return new TextHeaderPartDefinition(BackgroundPartDefinition.m19135a(injectorLike), HeaderTitleWithLayoutPartDefinition.m28427a(injectorLike));
    }

    public final Object mo2541a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        FeedProps feedProps = (FeedProps) obj;
        subParts.mo2756a(this.f24479c, new StylingData(feedProps, f24475a));
        subParts.mo2755a(2131562876, this.f24478b, new Props(feedProps, false, -1));
        return null;
    }

    public final /* bridge */ /* synthetic */ void mo2543a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, -1888057668);
        m32783a(view);
        Logger.a(8, EntryType.MARK_POP, -1662001041, a);
    }

    @Inject
    public TextHeaderPartDefinition(BackgroundPartDefinition backgroundPartDefinition, HeaderTitleWithLayoutPartDefinition headerTitleWithLayoutPartDefinition) {
        this.f24479c = backgroundPartDefinition;
        this.f24478b = headerTitleWithLayoutPartDefinition;
    }

    public static TextHeaderPartDefinition m32782a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.m1499a();
        byte b = a.m1504b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().mo191b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            TextHeaderPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.m1330a(b2);
            synchronized (f24477e) {
                TextHeaderPartDefinition textHeaderPartDefinition;
                if (a2 != null) {
                    textHeaderPartDefinition = (TextHeaderPartDefinition) a2.mo818a(f24477e);
                } else {
                    textHeaderPartDefinition = f24476d;
                }
                if (textHeaderPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.m1333a(b2, injectorThreadStack);
                    try {
                        b3 = m32785b(injectorThreadStack.m1474e());
                        if (a2 != null) {
                            a2.mo822a(f24477e, b3);
                        } else {
                            f24476d = b3;
                        }
                    } finally {
                        ContextScope.m1331a(injectorThreadStack);
                    }
                } else {
                    b3 = textHeaderPartDefinition;
                }
            }
            return b3;
        } finally {
            a.m1505c(b);
        }
    }

    private static void m32783a(V v) {
        ((StyleableTextHeader) v).setStyle(TextHeaderStyle.STORY_HEADER);
    }

    public static boolean m32784a(FeedProps<GraphQLStory> feedProps) {
        return StoryProps.m27464m(feedProps) || StoryHierarchyHelper.m27437d((GraphQLStory) feedProps.f13444a);
    }
}
