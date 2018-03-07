package com.facebook.feedplugins.goodwill;

import android.content.Context;
import android.widget.RelativeLayout;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.core.props.StoryProps;
import com.facebook.feed.rows.sections.header.DefaultHeaderPartDefinition;
import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.api.ViewType;
import com.facebook.multirow.parts.TextOrHiddenPartDefinition;
import com.facebook.multirow.parts.VisibilityPartDefinition;
import javax.annotation.Nullable;
import javax.inject.Inject;

@ContextScoped
/* compiled from: gravity_feed_unit_click */
public class DefaultThrowbackPromotedStoryHeaderPartDefinition<E extends AnyEnvironment> extends MultiRowSinglePartDefinition<FeedProps<GraphQLStory>, Void, E, RelativeLayout> {
    public static final ViewType f12188a = ViewType.a(2130904617);
    private static DefaultThrowbackPromotedStoryHeaderPartDefinition f12189g;
    private static final Object f12190h = new Object();
    private final DefaultHeaderPartDefinition f12191b;
    private final TextOrHiddenPartDefinition f12192c;
    private final VisibilityPartDefinition f12193d = new VisibilityPartDefinition();
    private final Context f12194e;
    private final GatekeeperStoreImpl f12195f;

    private static DefaultThrowbackPromotedStoryHeaderPartDefinition m14181b(InjectorLike injectorLike) {
        return new DefaultThrowbackPromotedStoryHeaderPartDefinition((Context) injectorLike.getInstance(Context.class), DefaultHeaderPartDefinition.a(injectorLike), TextOrHiddenPartDefinition.a(injectorLike), GatekeeperStoreImplMethodAutoProvider.a(injectorLike));
    }

    public final Object m14183a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        Object obj2;
        FeedProps feedProps = (FeedProps) obj;
        int i = 0;
        if (this.f12195f.a(860, false)) {
            obj2 = null;
        } else {
            obj2 = m14180a(feedProps, this.f12194e);
        }
        VisibilityPartDefinition visibilityPartDefinition = this.f12193d;
        if (obj2 == null) {
            i = 8;
        }
        subParts.a(2131562590, visibilityPartDefinition, Integer.valueOf(i));
        subParts.a(2131559441, this.f12191b, feedProps);
        subParts.a(2131558412, this.f12192c, obj2);
        return null;
    }

    @Inject
    public DefaultThrowbackPromotedStoryHeaderPartDefinition(Context context, DefaultHeaderPartDefinition defaultHeaderPartDefinition, TextOrHiddenPartDefinition textOrHiddenPartDefinition, GatekeeperStoreImpl gatekeeperStoreImpl) {
        this.f12191b = defaultHeaderPartDefinition;
        this.f12192c = textOrHiddenPartDefinition;
        this.f12194e = context;
        this.f12195f = gatekeeperStoreImpl;
    }

    public final ViewType m14182a() {
        return f12188a;
    }

    public static DefaultThrowbackPromotedStoryHeaderPartDefinition m14179a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            DefaultThrowbackPromotedStoryHeaderPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f12190h) {
                DefaultThrowbackPromotedStoryHeaderPartDefinition defaultThrowbackPromotedStoryHeaderPartDefinition;
                if (a2 != null) {
                    defaultThrowbackPromotedStoryHeaderPartDefinition = (DefaultThrowbackPromotedStoryHeaderPartDefinition) a2.a(f12190h);
                } else {
                    defaultThrowbackPromotedStoryHeaderPartDefinition = f12189g;
                }
                if (defaultThrowbackPromotedStoryHeaderPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m14181b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f12190h, b3);
                        } else {
                            f12189g = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = defaultThrowbackPromotedStoryHeaderPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    public final boolean m14184a(Object obj) {
        return true;
    }

    @Nullable
    public static String m14180a(FeedProps<GraphQLStory> feedProps, Context context) {
        GraphQLStory graphQLStory = (GraphQLStory) feedProps.a();
        GraphQLStory c = StoryProps.c(feedProps);
        if (graphQLStory == null || c == null || c.aw() == null || c.aw().a() == null) {
            return null;
        }
        try {
            int parseInt = Integer.parseInt(c.aw().a());
            return context.getResources().getQuantityString(2131689730, parseInt, new Object[]{Integer.valueOf(parseInt)});
        } catch (NumberFormatException e) {
            return null;
        }
    }
}
