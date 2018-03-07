package com.facebook.feedplugins.graphqlstory.footer;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.styling.BackgroundPartDefinition;
import com.facebook.feed.rows.styling.BackgroundPartDefinition.StylingData;
import com.facebook.feed.rows.styling.PaddingStyle;
import com.facebook.feed.rows.styling.PaddingStyle.Builder;
import com.facebook.feed.util.event.FeedEventBus;
import com.facebook.feed.util.event.StoryEvents.PaginatedSeeMoreAggregatedStoryEvent;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.GraphQLSubstoriesConnection;
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
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.api.ViewType;
import com.facebook.multirow.parts.ClickListenerPartDefinition;
import javax.inject.Inject;

@ContextScoped
/* compiled from: Size of moveFrom != size of moveTo! */
public class SeeMoreFooterPartDefinition extends MultiRowSinglePartDefinition<FeedProps<GraphQLStory>, Void, HasPositionInformation, TextView> {
    public static final ViewType f23264a = new C20091();
    private static final PaddingStyle f23265b;
    private static SeeMoreFooterPartDefinition f23266f;
    private static final Object f23267g = new Object();
    private final BackgroundPartDefinition f23268c;
    private final ClickListenerPartDefinition f23269d;
    public final FeedEventBus f23270e;

    /* compiled from: Size of moveFrom != size of moveTo! */
    final class C20091 extends ViewType {
        C20091() {
        }

        public final View m25631a(Context context) {
            View textView = new TextView(context);
            textView.setText(2131233416);
            textView.setGravity(1);
            return textView;
        }
    }

    private static SeeMoreFooterPartDefinition m25633b(InjectorLike injectorLike) {
        return new SeeMoreFooterPartDefinition(BackgroundPartDefinition.a(injectorLike), FeedEventBus.a(injectorLike), ClickListenerPartDefinition.a(injectorLike));
    }

    public final Object m25635a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        FeedProps feedProps = (FeedProps) obj;
        final GraphQLStory graphQLStory = (GraphQLStory) feedProps.a;
        subParts.a(this.f23268c, new StylingData(feedProps, f23265b));
        subParts.a(this.f23269d, new OnClickListener(this) {
            final /* synthetic */ SeeMoreFooterPartDefinition f23263b;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, 1856457694);
                this.f23263b.f23270e.a(new PaginatedSeeMoreAggregatedStoryEvent(graphQLStory, 2));
                Logger.a(2, EntryType.UI_INPUT_END, -1307336953, a);
            }
        });
        return null;
    }

    public final boolean m25636a(Object obj) {
        GraphQLSubstoriesConnection a = StoryHierarchyHelper.a((GraphQLStory) ((FeedProps) obj).a);
        return a != null && a.l() > 0;
    }

    static {
        Builder a = Builder.a();
        a.b = 4.0f;
        a = a;
        a.c = 4.0f;
        f23265b = a.i();
    }

    public static SeeMoreFooterPartDefinition m25632a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            SeeMoreFooterPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f23267g) {
                SeeMoreFooterPartDefinition seeMoreFooterPartDefinition;
                if (a2 != null) {
                    seeMoreFooterPartDefinition = (SeeMoreFooterPartDefinition) a2.a(f23267g);
                } else {
                    seeMoreFooterPartDefinition = f23266f;
                }
                if (seeMoreFooterPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m25633b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f23267g, b3);
                        } else {
                            f23266f = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = seeMoreFooterPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Inject
    public SeeMoreFooterPartDefinition(BackgroundPartDefinition backgroundPartDefinition, FeedEventBus feedEventBus, ClickListenerPartDefinition clickListenerPartDefinition) {
        this.f23268c = backgroundPartDefinition;
        this.f23269d = clickListenerPartDefinition;
        this.f23270e = feedEventBus;
    }

    public final ViewType m25634a() {
        return f23264a;
    }
}
