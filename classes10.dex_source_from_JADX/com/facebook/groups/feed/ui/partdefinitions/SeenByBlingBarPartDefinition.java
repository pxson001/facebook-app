package com.facebook.groups.feed.ui.partdefinitions;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.feed.environment.HasFeedListType;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.styling.BackgroundPartDefinition;
import com.facebook.feed.rows.styling.BackgroundPartDefinition.StylingData;
import com.facebook.feedplugins.base.blingbar.BlingBarPartDefinition;
import com.facebook.feedplugins.base.blingbar.BlingBarPartDefinition.Props;
import com.facebook.feedplugins.base.blingbar.BlingBarRootPartDefinition;
import com.facebook.feedplugins.base.blingbar.ui.BlingBarUtil;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.groups.feed.ui.views.SeenByBlingBarView;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.intent.feed.DefaultFeedIntentBuilder;
import com.facebook.intent.feed.IFeedIntentBuilder;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.api.ViewType;
import com.facebook.multirow.parts.ClickListenerPartDefinition;
import javax.inject.Inject;

@ContextScoped
/* compiled from: ThreadListFragment_QPBanner_NullIntent */
public class SeenByBlingBarPartDefinition<E extends HasFeedListType & HasPersistentState & HasPositionInformation> extends MultiRowSinglePartDefinition<FeedProps<GraphQLStory>, Void, E, SeenByBlingBarView> {
    public static final ViewType f22532a = new C32621();
    private static SeenByBlingBarPartDefinition f22533g;
    private static final Object f22534h = new Object();
    private final ClickListenerPartDefinition f22535b;
    private final BlingBarPartDefinition f22536c;
    private final BackgroundPartDefinition f22537d;
    public final SecureContextHelper f22538e;
    public final IFeedIntentBuilder f22539f;

    /* compiled from: ThreadListFragment_QPBanner_NullIntent */
    final class C32621 extends ViewType {
        C32621() {
        }

        public final View m23567a(Context context) {
            return new SeenByBlingBarView(context);
        }
    }

    private static SeenByBlingBarPartDefinition m23569b(InjectorLike injectorLike) {
        return new SeenByBlingBarPartDefinition(ClickListenerPartDefinition.a(injectorLike), BlingBarPartDefinition.a(injectorLike), BackgroundPartDefinition.a(injectorLike), (IFeedIntentBuilder) DefaultFeedIntentBuilder.a(injectorLike), (SecureContextHelper) DefaultSecureContextHelper.a(injectorLike));
    }

    public final Object m23571a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        FeedProps feedProps = (FeedProps) obj;
        final HasFeedListType hasFeedListType = (HasFeedListType) anyEnvironment;
        final GraphQLStory graphQLStory = (GraphQLStory) feedProps.a;
        subParts.a(this.f22537d, new StylingData(feedProps, BlingBarRootPartDefinition.a));
        subParts.a(2131562039, this.f22535b, new OnClickListener(this) {
            final /* synthetic */ SeenByBlingBarPartDefinition f22531c;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, 943607569);
                Context context = view.getContext();
                Intent a2 = this.f22531c.f22539f.a(graphQLStory, hasFeedListType.c().a());
                a2.putExtra("fragment_title", context.getString(2131233565));
                this.f22531c.f22538e.a(a2, context);
                Logger.a(2, EntryType.UI_INPUT_END, -1179804474, a);
            }
        });
        BlingBarPartDefinition blingBarPartDefinition = this.f22536c;
        boolean z = graphQLStory.aa_() > 0 || graphQLStory.n() > 0 || graphQLStory.D() > 0;
        subParts.a(blingBarPartDefinition, new Props(feedProps, z));
        return null;
    }

    public final /* bridge */ /* synthetic */ void m23572a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, -1194910356);
        SeenByBlingBarView seenByBlingBarView = (SeenByBlingBarView) view;
        BlingBarUtil.a(seenByBlingBarView.f22540b, ((GraphQLStory) ((FeedProps) obj).a).D(), seenByBlingBarView.f22541c, seenByBlingBarView.f22542d);
        Logger.a(8, EntryType.MARK_POP, 1042996838, a);
    }

    @Inject
    public SeenByBlingBarPartDefinition(ClickListenerPartDefinition clickListenerPartDefinition, BlingBarPartDefinition blingBarPartDefinition, BackgroundPartDefinition backgroundPartDefinition, IFeedIntentBuilder iFeedIntentBuilder, SecureContextHelper secureContextHelper) {
        this.f22535b = clickListenerPartDefinition;
        this.f22536c = blingBarPartDefinition;
        this.f22537d = backgroundPartDefinition;
        this.f22539f = iFeedIntentBuilder;
        this.f22538e = secureContextHelper;
    }

    public static SeenByBlingBarPartDefinition m23568a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            SeenByBlingBarPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f22534h) {
                SeenByBlingBarPartDefinition seenByBlingBarPartDefinition;
                if (a2 != null) {
                    seenByBlingBarPartDefinition = (SeenByBlingBarPartDefinition) a2.a(f22534h);
                } else {
                    seenByBlingBarPartDefinition = f22533g;
                }
                if (seenByBlingBarPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m23569b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f22534h, b3);
                        } else {
                            f22533g = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = seenByBlingBarPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    public final ViewType m23570a() {
        return f22532a;
    }

    public final boolean m23573a(Object obj) {
        return true;
    }
}
