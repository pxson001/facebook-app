package com.facebook.video.channelfeed;

import android.content.Context;
import android.text.Spannable;
import android.view.View;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.common.util.ContextUtils;
import com.facebook.fbui.widget.text.TextLayoutView;
import com.facebook.fbui.widget.text.layoutbuilder.TextLayoutBuilder;
import com.facebook.feed.environment.HasContext;
import com.facebook.feed.environment.HasMenuButtonProvider;
import com.facebook.feed.menu.base.BaseFeedStoryMenuHelper;
import com.facebook.feed.rows.core.persistence.ContextStateKey;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.core.props.StoryProps;
import com.facebook.feed.rows.sections.header.TitleTextLayoutBuilderHolder;
import com.facebook.feed.rows.styling.PaddingStyle;
import com.facebook.feed.spannable.FeedSpannables;
import com.facebook.feed.spannable.PersistentSpannable;
import com.facebook.feed.util.render.FeedRenderUtils;
import com.facebook.feed.util.story.FeedStoryUtil;
import com.facebook.feed.util.story.FeedStoryUtilModelConverter;
import com.facebook.feedplugins.graphqlstory.header.HeaderTitlePersistentStateId;
import com.facebook.feedplugins.graphqlstory.header.HeaderTitleSpannableBuilder;
import com.facebook.feedplugins.graphqlstory.header.HeaderTitleSpannableBuilder.Builder;
import com.facebook.feedplugins.highlighter.FeedHighlighter;
import com.facebook.feedplugins.spannable.PersistentSpannableInput;
import com.facebook.feedplugins.spannable.SpannableInTextLayoutPartDefinition;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.GraphQLTextWithEntities;
import com.facebook.graphql.model.interfaces.CacheableEntity;
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
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import javax.annotation.Nullable;
import javax.inject.Inject;

@ContextScoped
/* compiled from: tagged_profile_ids */
public class ChannelFeedHeaderTitlePartDefinition<E extends HasMenuButtonProvider & HasContext> extends BaseSinglePartDefinition<Props, Void, E, TextLayoutView> {
    private static ChannelFeedHeaderTitlePartDefinition f2322g;
    private static final Object f2323h = new Object();
    public final FeedHighlighter f2324a;
    private final TitleTextLayoutBuilderHolder f2325b;
    public final ChannelFeedHeaderTextLayoutWidthResolver f2326c;
    public final FeedRenderUtils f2327d;
    private final SpannableInTextLayoutPartDefinition f2328e;
    public final HeaderTitleSpannableBuilder f2329f;

    /* compiled from: tagged_profile_ids */
    public class HeaderTitlePersistentSpannableInput implements PersistentSpannableInput {
        final /* synthetic */ ChannelFeedHeaderTitlePartDefinition f2311a;
        private final BaseFeedStoryMenuHelper f2312b;
        private final GraphQLTextWithEntities f2313c;
        public final TextLayoutBuilder f2314d;
        private final FeedProps<GraphQLStory> f2315e;
        private final ContextStateKey<String, PersistentSpannable> f2316f;

        public HeaderTitlePersistentSpannableInput(ChannelFeedHeaderTitlePartDefinition channelFeedHeaderTitlePartDefinition, Context context, TextLayoutBuilder textLayoutBuilder, Props props, BaseFeedStoryMenuHelper baseFeedStoryMenuHelper) {
            this.f2311a = channelFeedHeaderTitlePartDefinition;
            this.f2314d = textLayoutBuilder;
            Preconditions.checkNotNull(context);
            Optional b = ContextUtils.b(context, 2130772561);
            if (b.isPresent()) {
                this.f2314d.c(((Integer) b.get()).intValue());
            }
            this.f2315e = props.f2320a;
            this.f2313c = ((GraphQLStory) this.f2315e.a).aH();
            this.f2312b = baseFeedStoryMenuHelper;
            this.f2316f = new PersistentSpannableKey(channelFeedHeaderTitlePartDefinition, props, ChannelFeedHeaderTitlePartDefinition.class.toString());
        }

        public final ContextStateKey<String, PersistentSpannable> m2280a() {
            return this.f2316f;
        }

        public final TextLayoutBuilder m2283d() {
            return this.f2314d;
        }

        public final int m2284e() {
            int i;
            ChannelFeedHeaderTextLayoutWidthResolver channelFeedHeaderTextLayoutWidthResolver = this.f2311a.f2326c;
            FeedProps feedProps = this.f2315e;
            BaseFeedStoryMenuHelper baseFeedStoryMenuHelper = this.f2312b;
            int a = this.f2311a.f2327d.a();
            int i2 = 0;
            GraphQLStory graphQLStory = (GraphQLStory) feedProps.a;
            int a2 = channelFeedHeaderTextLayoutWidthResolver.f2305a.a(PaddingStyle.i, feedProps, channelFeedHeaderTextLayoutWidthResolver.f2307c);
            if (FeedStoryUtil.a(FeedStoryUtilModelConverter.a(graphQLStory))) {
                i = channelFeedHeaderTextLayoutWidthResolver.f2308d;
            } else {
                i = 0;
            }
            if (baseFeedStoryMenuHelper.a(graphQLStory).a(feedProps)) {
                i2 = channelFeedHeaderTextLayoutWidthResolver.f2310f;
            }
            return (((a - (a2 * 2)) - i) - i2) - channelFeedHeaderTextLayoutWidthResolver.f2309e;
        }

        @Nullable
        public final GraphQLTextWithEntities m2281b() {
            return this.f2313c;
        }

        public final CacheableEntity m2282c() {
            return (CacheableEntity) this.f2315e.a;
        }

        public final int m2279a(Spannable spannable) {
            return 0;
        }
    }

    /* compiled from: tagged_profile_ids */
    class PersistentSpannableKey implements ContextStateKey<String, PersistentSpannable> {
        final /* synthetic */ ChannelFeedHeaderTitlePartDefinition f2317a;
        private final Props f2318b;
        private final String f2319c;

        public PersistentSpannableKey(ChannelFeedHeaderTitlePartDefinition channelFeedHeaderTitlePartDefinition, Props props, String str) {
            this.f2317a = channelFeedHeaderTitlePartDefinition;
            this.f2318b = props;
            this.f2319c = "story:header:title:" + HeaderTitlePersistentStateId.b((GraphQLStory) props.f2320a.a) + str;
        }

        public final Object m2285a() {
            GraphQLStory graphQLStory = (GraphQLStory) this.f2318b.f2320a.a;
            Builder builder = new Builder(this.f2317a.f2329f, this.f2318b.f2320a, this.f2318b.f2321b);
            builder.f = 17170443;
            CharSequence c = builder.c();
            FeedHighlighter feedHighlighter = this.f2317a.f2324a;
            return new PersistentSpannable(FeedSpannables.a(FeedHighlighter.a(graphQLStory) ? this.f2317a.f2324a.a(graphQLStory, c) : c), false);
        }

        public final Object m2286b() {
            return this.f2319c;
        }
    }

    /* compiled from: tagged_profile_ids */
    public class Props {
        public final FeedProps<GraphQLStory> f2320a;
        public final boolean f2321b;

        public Props(FeedProps<GraphQLStory> feedProps, boolean z) {
            this.f2320a = feedProps;
            this.f2321b = z;
        }
    }

    private static ChannelFeedHeaderTitlePartDefinition m2288b(InjectorLike injectorLike) {
        return new ChannelFeedHeaderTitlePartDefinition(FeedHighlighter.a(injectorLike), TitleTextLayoutBuilderHolder.a(injectorLike), ChannelFeedHeaderTextLayoutWidthResolver.m2277a(injectorLike), FeedRenderUtils.a(injectorLike), SpannableInTextLayoutPartDefinition.a(injectorLike), HeaderTitleSpannableBuilder.a(injectorLike));
    }

    public final Object m2289a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        HasMenuButtonProvider hasMenuButtonProvider = (HasMenuButtonProvider) anyEnvironment;
        subParts.a(this.f2328e, new HeaderTitlePersistentSpannableInput(this, ((HasContext) hasMenuButtonProvider).getContext(), this.f2325b.a, (Props) obj, hasMenuButtonProvider.e()));
        return null;
    }

    public final /* bridge */ /* synthetic */ void m2290a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, -281218400);
        ((TextLayoutView) view).setTag(2131558541, Boolean.valueOf(StoryProps.p(((Props) obj).f2320a)));
        Logger.a(8, EntryType.MARK_POP, 911991941, a);
    }

    public final void m2291b(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        ((TextLayoutView) view).setTag(2131558541, null);
    }

    public static ChannelFeedHeaderTitlePartDefinition m2287a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ChannelFeedHeaderTitlePartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f2323h) {
                ChannelFeedHeaderTitlePartDefinition channelFeedHeaderTitlePartDefinition;
                if (a2 != null) {
                    channelFeedHeaderTitlePartDefinition = (ChannelFeedHeaderTitlePartDefinition) a2.a(f2323h);
                } else {
                    channelFeedHeaderTitlePartDefinition = f2322g;
                }
                if (channelFeedHeaderTitlePartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m2288b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f2323h, b3);
                        } else {
                            f2322g = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = channelFeedHeaderTitlePartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Inject
    public ChannelFeedHeaderTitlePartDefinition(FeedHighlighter feedHighlighter, TitleTextLayoutBuilderHolder titleTextLayoutBuilderHolder, ChannelFeedHeaderTextLayoutWidthResolver channelFeedHeaderTextLayoutWidthResolver, FeedRenderUtils feedRenderUtils, SpannableInTextLayoutPartDefinition spannableInTextLayoutPartDefinition, HeaderTitleSpannableBuilder headerTitleSpannableBuilder) {
        this.f2324a = feedHighlighter;
        this.f2325b = titleTextLayoutBuilderHolder;
        this.f2326c = channelFeedHeaderTextLayoutWidthResolver;
        this.f2327d = feedRenderUtils;
        this.f2328e = spannableInTextLayoutPartDefinition;
        this.f2329f = headerTitleSpannableBuilder;
    }
}
