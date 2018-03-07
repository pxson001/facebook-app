package com.facebook.video.channelfeed;

import android.content.Context;
import android.content.res.Resources;
import android.support.annotation.ColorRes;
import android.text.Layout;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.common.util.StringUtil;
import com.facebook.feed.environment.HasContext;
import com.facebook.feed.environment.HasInvalidate;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.renderer.DefaultFeedUnitRenderer;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.core.props.StoryProps;
import com.facebook.feed.rows.sections.text.ContentTextLayoutBasePartDefinition;
import com.facebook.feed.rows.sections.text.ContentTextLayoutBuilder;
import com.facebook.feed.rows.sections.text.ContentTextLayoutBuilderProvider;
import com.facebook.feed.rows.sections.text.ExpandingContentTextKey;
import com.facebook.feed.rows.sections.text.ExpandingContentTextPersistentState;
import com.facebook.feed.rows.views.AccessibleTextLayoutView;
import com.facebook.feed.util.render.FeedRenderUtils;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.GraphQLStory.Builder;
import com.facebook.graphql.model.StoryTextHelper;
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
import com.facebook.ufiservices.util.ContinueReadingSpan;
import com.facebook.ufiservices.util.LinkifyUtil.ClickableEntitySpanWithCallback;
import javax.inject.Inject;

@ContextScoped
/* compiled from: task_header_fetch */
public class ChannelFeedExpandingContentTextPartDefinition<E extends HasPositionInformation & HasInvalidate & HasContext & HasPersistentState> extends MultiRowSinglePartDefinition<Props, State, E, AccessibleTextLayoutView> {
    private static ChannelFeedExpandingContentTextPartDefinition f2168e;
    private static final Object f2169f = new Object();
    private final String f2170a;
    private final FeedRenderUtils f2171b;
    private final ContentTextLayoutBuilderProvider f2172c;
    private final ChannelFeedExpandingContentTextUtil f2173d;

    /* compiled from: task_header_fetch */
    public interface OnSeeMoreClickedListener {
    }

    /* compiled from: task_header_fetch */
    public class Props {
        public final FeedProps<GraphQLStory> f2157a;
        public final boolean f2158b;
        @ColorRes
        public final int f2159c;
        public final int f2160d;
        public final OnSeeMoreClickedListener f2161e;

        public Props(FeedProps<GraphQLStory> feedProps) {
            this(feedProps, false, 2131363374, 2, null);
        }

        private Props(FeedProps<GraphQLStory> feedProps, boolean z, @ColorRes int i, int i2, OnSeeMoreClickedListener onSeeMoreClickedListener) {
            this.f2157a = feedProps;
            this.f2158b = z;
            this.f2159c = i;
            this.f2160d = i2;
            this.f2161e = onSeeMoreClickedListener;
        }
    }

    /* compiled from: task_header_fetch */
    public class State {
        public Layout f2162a;
        public int f2163b;
        public SpannableStringBuilder f2164c;
        public boolean f2165d;
        public final ContentTextLayoutBuilder f2166e;
        public final ExpandingContentTextPersistentState f2167f;

        private State(Layout layout, int i, SpannableStringBuilder spannableStringBuilder, ContentTextLayoutBuilder contentTextLayoutBuilder, ExpandingContentTextPersistentState expandingContentTextPersistentState) {
            this.f2162a = layout;
            this.f2163b = i;
            this.f2164c = spannableStringBuilder;
            this.f2166e = contentTextLayoutBuilder;
            this.f2167f = expandingContentTextPersistentState;
            this.f2165d = false;
        }
    }

    private static ChannelFeedExpandingContentTextPartDefinition m2161b(InjectorLike injectorLike) {
        return new ChannelFeedExpandingContentTextPartDefinition((ContentTextLayoutBuilderProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(ContentTextLayoutBuilderProvider.class), FeedRenderUtils.a(injectorLike), ResourcesMethodAutoProvider.a(injectorLike), ChannelFeedExpandingContentTextUtil.m2167a(injectorLike));
    }

    public final Object m2163a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        Props props = (Props) obj;
        HasPositionInformation hasPositionInformation = (HasPositionInformation) anyEnvironment;
        GraphQLStory graphQLStory = (GraphQLStory) props.f2157a.a;
        ContentTextLayoutBuilder a = this.f2172c.a(((HasContext) hasPositionInformation).getContext());
        SpannableStringBuilder a2 = m2155a(a, props, true);
        m2158a(a2, hasPositionInformation, graphQLStory, props);
        return new State(a.a(props.f2157a, a2), this.f2171b.a(), a2, a, m2156a((HasPersistentState) hasPositionInformation, graphQLStory));
    }

    public static ChannelFeedExpandingContentTextPartDefinition m2157a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ChannelFeedExpandingContentTextPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f2169f) {
                ChannelFeedExpandingContentTextPartDefinition channelFeedExpandingContentTextPartDefinition;
                if (a2 != null) {
                    channelFeedExpandingContentTextPartDefinition = (ChannelFeedExpandingContentTextPartDefinition) a2.a(f2169f);
                } else {
                    channelFeedExpandingContentTextPartDefinition = f2168e;
                }
                if (channelFeedExpandingContentTextPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m2161b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f2169f, b3);
                        } else {
                            f2168e = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = channelFeedExpandingContentTextPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Inject
    public ChannelFeedExpandingContentTextPartDefinition(ContentTextLayoutBuilderProvider contentTextLayoutBuilderProvider, FeedRenderUtils feedRenderUtils, Resources resources, ChannelFeedExpandingContentTextUtil channelFeedExpandingContentTextUtil) {
        this.f2171b = feedRenderUtils;
        this.f2172c = contentTextLayoutBuilderProvider;
        this.f2173d = channelFeedExpandingContentTextUtil;
        this.f2170a = resources.getString(2131233416);
    }

    private static SpannableStringBuilder m2155a(ContentTextLayoutBuilder contentTextLayoutBuilder, Props props, boolean z) {
        FeedProps b = props.f2157a.b(Builder.a((GraphQLStory) props.f2157a.a).a());
        GraphQLStory graphQLStory = (GraphQLStory) b.a;
        Spannable spannableStringBuilder = new SpannableStringBuilder(StringUtil.b(StoryTextHelper.a(graphQLStory).length() > 0 ? ((DefaultFeedUnitRenderer) contentTextLayoutBuilder.a.get()).a(b, z) : ""));
        contentTextLayoutBuilder.e.a(spannableStringBuilder, (int) contentTextLayoutBuilder.b.b());
        contentTextLayoutBuilder.c.a(graphQLStory, spannableStringBuilder);
        Spannable spannable = spannableStringBuilder;
        int i = props.f2159c;
        int i2 = 0;
        ClickableEntitySpanWithCallback[] clickableEntitySpanWithCallbackArr = (ClickableEntitySpanWithCallback[]) spannable.getSpans(0, spannable.length(), ClickableEntitySpanWithCallback.class);
        int length = clickableEntitySpanWithCallbackArr.length;
        while (i2 < length) {
            clickableEntitySpanWithCallbackArr[i2].f = i;
            i2++;
        }
        return spannable;
    }

    private void m2159a(Props props, State state, E e, AccessibleTextLayoutView accessibleTextLayoutView) {
        boolean z = state.f2167f.a;
        if (z && !state.f2165d) {
            state.f2164c = m2155a(this.f2172c.a(((HasContext) e).getContext()), props, true);
            state.f2165d = true;
        }
        accessibleTextLayoutView.setTextLayout(m2154a(props.f2157a, state.f2162a, state.f2163b, state.f2164c, this.f2171b.a(), z, state.f2166e));
        accessibleTextLayoutView.setTag(2131558541, Boolean.valueOf(StoryProps.p(props.f2157a)));
    }

    public static boolean m2160a(Props props) {
        return !StringUtil.a(StoryTextHelper.a((GraphQLStory) props.f2157a.a));
    }

    public final ViewType m2162a() {
        return ContentTextLayoutBasePartDefinition.a;
    }

    private static ExpandingContentTextPersistentState m2156a(HasPersistentState hasPersistentState, GraphQLStory graphQLStory) {
        return (ExpandingContentTextPersistentState) hasPersistentState.a(new ExpandingContentTextKey(graphQLStory), graphQLStory);
    }

    private static Layout m2154a(FeedProps<GraphQLStory> feedProps, Layout layout, int i, SpannableStringBuilder spannableStringBuilder, int i2, boolean z, ContentTextLayoutBuilder contentTextLayoutBuilder) {
        return (i != i2 || z) ? contentTextLayoutBuilder.a(feedProps, spannableStringBuilder) : layout;
    }

    private void m2158a(SpannableStringBuilder spannableStringBuilder, E e, GraphQLStory graphQLStory, Props props) {
        final ExpandingContentTextPersistentState a = m2156a((HasPersistentState) e, graphQLStory);
        if (ChannelFeedExpandingContentTextUtil.m2170a(spannableStringBuilder, 80, 2, this.f2170a) || props.f2158b) {
            final E e2 = e;
            final Props props2 = props;
            final GraphQLStory graphQLStory2 = graphQLStory;
            ContinueReadingSpan continueReadingSpan = new ContinueReadingSpan(((HasContext) e).getContext(), new OnClickListener(this) {
                final /* synthetic */ ChannelFeedExpandingContentTextPartDefinition f2156e;

                public void onClick(View view) {
                    int a = Logger.a(2, EntryType.UI_INPUT_START, 1679712316);
                    a.a = true;
                    ((HasInvalidate) e2).hL_();
                    Logger.a(2, EntryType.UI_INPUT_END, 900725881, a);
                }
            });
            continueReadingSpan.b = props.f2159c;
            this.f2173d.m2174a(spannableStringBuilder, 80, this.f2170a, continueReadingSpan);
        }
    }
}
