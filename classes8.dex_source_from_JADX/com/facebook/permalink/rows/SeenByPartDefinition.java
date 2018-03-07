package com.facebook.permalink.rows;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.feed.environment.HasFeedListType;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.core.props.StoryProps;
import com.facebook.feed.rows.styling.BackgroundPartDefinition;
import com.facebook.feed.rows.styling.BackgroundPartDefinition.StylingData;
import com.facebook.feed.rows.styling.HasSpecialStyling;
import com.facebook.feed.rows.styling.HasSpecialStyling.SpecialStylingType;
import com.facebook.feed.rows.styling.PaddingStyle;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.story.util.GraphQLStoryUtil;
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
import com.facebook.resources.utils.ResourceUtils;
import javax.inject.Inject;

@ContextScoped
/* compiled from: store_url */
public class SeenByPartDefinition<E extends HasFeedListType & HasPositionInformation> extends MultiRowSinglePartDefinition<FeedProps<GraphQLStory>, Void, E, SeenByView> implements HasSpecialStyling {
    public static final ViewType f2058a = new C02351();
    private static SeenByPartDefinition f2059g;
    private static final Object f2060h = new Object();
    private final BackgroundPartDefinition f2061b;
    private final ClickListenerPartDefinition f2062c;
    public final SecureContextHelper f2063d;
    public final IFeedIntentBuilder f2064e;
    private final GraphQLStoryUtil f2065f;

    /* compiled from: store_url */
    final class C02351 extends ViewType {
        C02351() {
        }

        public final View m2281a(Context context) {
            return new SeenByView(context);
        }
    }

    private static SeenByPartDefinition m2283b(InjectorLike injectorLike) {
        return new SeenByPartDefinition(BackgroundPartDefinition.a(injectorLike), ClickListenerPartDefinition.a(injectorLike), (SecureContextHelper) DefaultSecureContextHelper.a(injectorLike), (IFeedIntentBuilder) DefaultFeedIntentBuilder.a(injectorLike), GraphQLStoryUtil.a(injectorLike));
    }

    public final Object m2285a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        FeedProps feedProps = (FeedProps) obj;
        final HasFeedListType hasFeedListType = (HasFeedListType) anyEnvironment;
        subParts.a(this.f2061b, new StylingData(feedProps, PaddingStyle.e));
        final GraphQLStory graphQLStory = (GraphQLStory) feedProps.a;
        subParts.a(this.f2062c, new OnClickListener(this) {
            final /* synthetic */ SeenByPartDefinition f2057c;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, 1039241168);
                Context context = view.getContext();
                Intent a2 = this.f2057c.f2064e.a(graphQLStory, hasFeedListType.c().a());
                a2.putExtra("fragment_title", context.getString(2131233565));
                this.f2057c.f2063d.a(a2, context);
                Logger.a(2, EntryType.UI_INPUT_END, 927645622, a);
            }
        });
        return null;
    }

    public final /* bridge */ /* synthetic */ void m2286a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, 1043529219);
        FeedProps feedProps = (FeedProps) obj;
        SeenByView seenByView = (SeenByView) view;
        GraphQLStory graphQLStory = (GraphQLStory) feedProps.a;
        if (StoryProps.m(feedProps)) {
            graphQLStory = graphQLStory.L();
        }
        seenByView.setText(ResourceUtils.a(seenByView.getContext().getResources(), 2131233561, 2131233562, graphQLStory.D()));
        seenByView.setId(2131558554);
        Logger.a(8, EntryType.MARK_POP, -417771707, a);
    }

    public final boolean m2287a(Object obj) {
        return ((GraphQLStory) ((FeedProps) obj).a).D() > 0;
    }

    @Inject
    public SeenByPartDefinition(BackgroundPartDefinition backgroundPartDefinition, ClickListenerPartDefinition clickListenerPartDefinition, SecureContextHelper secureContextHelper, IFeedIntentBuilder iFeedIntentBuilder, GraphQLStoryUtil graphQLStoryUtil) {
        this.f2061b = backgroundPartDefinition;
        this.f2062c = clickListenerPartDefinition;
        this.f2063d = secureContextHelper;
        this.f2064e = iFeedIntentBuilder;
        this.f2065f = graphQLStoryUtil;
    }

    public static SeenByPartDefinition m2282a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            SeenByPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f2060h) {
                SeenByPartDefinition seenByPartDefinition;
                if (a2 != null) {
                    seenByPartDefinition = (SeenByPartDefinition) a2.a(f2060h);
                } else {
                    seenByPartDefinition = f2059g;
                }
                if (seenByPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m2283b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f2060h, b3);
                        } else {
                            f2059g = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = seenByPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    public final ViewType m2284a() {
        return f2058a;
    }

    public final SpecialStylingType m2288b() {
        return SpecialStylingType.MAYBE_HAS_COMMENTS_BELOW;
    }
}
