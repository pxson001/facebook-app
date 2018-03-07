package com.facebook.feedplugins.storyset.rows;

import android.content.Context;
import android.text.Spannable;
import android.text.SpannableString;
import android.view.View;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.HasMenuButtonProvider;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.core.props.StoryProps;
import com.facebook.feed.rows.sections.header.MenuButtonPartDefinition;
import com.facebook.feed.rows.sections.header.MenuButtonPartDefinition.Props;
import com.facebook.feed.rows.sections.header.ui.MenuConfig;
import com.facebook.feed.util.story.FeedStoryUtil;
import com.facebook.feedplugins.graphqlstory.explanation.ExplanationSpannableBuilder;
import com.facebook.feedplugins.graphqlstory.explanation.SocialContextSpannableBuilder;
import com.facebook.feedplugins.storyset.rows.ui.StoryPageView;
import com.facebook.graphql.model.GraphQLActor;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.GraphQLStorySet;
import com.facebook.graphql.model.StorySetHelper;
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
import javax.annotation.Nullable;
import javax.inject.Inject;

@ContextScoped
/* compiled from: audio_uri */
public class StorySetPageSocialContextPartDefinition extends BaseSinglePartDefinition<FeedProps<GraphQLStory>, Spannable, HasMenuButtonProvider, StoryPageView> {
    private static StorySetPageSocialContextPartDefinition f9745f;
    private static final Object f9746g = new Object();
    private final FeedStoryUtil f9747a;
    public final Context f9748b;
    private final MenuButtonPartDefinition f9749c;
    private final SocialContextSpannableBuilder f9750d;
    private final ExplanationSpannableBuilder f9751e;

    private static StorySetPageSocialContextPartDefinition m10190b(InjectorLike injectorLike) {
        return new StorySetPageSocialContextPartDefinition(FeedStoryUtil.a(injectorLike), (Context) injectorLike.getInstance(Context.class), MenuButtonPartDefinition.a(injectorLike), SocialContextSpannableBuilder.a(injectorLike), ExplanationSpannableBuilder.a(injectorLike));
    }

    public final Object m10191a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        FeedProps feedProps = (FeedProps) obj;
        subParts.a(2131567722, this.f9749c, new Props(feedProps, MenuConfig.CLICKABLE));
        return m10188a(feedProps);
    }

    public final /* bridge */ /* synthetic */ void m10192a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, 1130721033);
        ((StoryPageView) view).setSocialContextText((Spannable) obj2);
        Logger.a(8, EntryType.MARK_POP, -1848134570, a);
    }

    @Inject
    public StorySetPageSocialContextPartDefinition(FeedStoryUtil feedStoryUtil, Context context, MenuButtonPartDefinition menuButtonPartDefinition, SocialContextSpannableBuilder socialContextSpannableBuilder, ExplanationSpannableBuilder explanationSpannableBuilder) {
        this.f9747a = feedStoryUtil;
        this.f9748b = context;
        this.f9749c = menuButtonPartDefinition;
        this.f9750d = socialContextSpannableBuilder;
        this.f9751e = explanationSpannableBuilder;
    }

    public static StorySetPageSocialContextPartDefinition m10189a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            StorySetPageSocialContextPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f9746g) {
                StorySetPageSocialContextPartDefinition storySetPageSocialContextPartDefinition;
                if (a2 != null) {
                    storySetPageSocialContextPartDefinition = (StorySetPageSocialContextPartDefinition) a2.a(f9746g);
                } else {
                    storySetPageSocialContextPartDefinition = f9745f;
                }
                if (storySetPageSocialContextPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m10190b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f9746g, b3);
                        } else {
                            f9745f = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = storySetPageSocialContextPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Nullable
    private Spannable m10188a(FeedProps<GraphQLStory> feedProps) {
        GraphQLStory graphQLStory = (GraphQLStory) feedProps.a;
        if (FeedStoryUtil.a(graphQLStory)) {
            return new SpannableString(this.f9751e.a(feedProps));
        }
        GraphQLStorySet h = StoryProps.h(feedProps);
        if (h == null || StorySetHelper.c(h)) {
            return null;
        }
        Spannable a = this.f9750d.a(feedProps);
        if (a != null) {
            return a;
        }
        CharSequence charSequence;
        if (graphQLStory.b() == null || graphQLStory.b().isEmpty()) {
            charSequence = null;
        } else {
            GraphQLActor graphQLActor = (GraphQLActor) graphQLStory.b().get(0);
            if (graphQLActor == null || graphQLActor.b() == null || graphQLActor.b().g() != 2479791) {
                charSequence = null;
            } else {
                charSequence = new SpannableString(this.f9748b.getResources().getQuantityString(2131689629, r3, new Object[]{Integer.valueOf(graphQLActor.ad() != null ? graphQLActor.ad().a() : 0)}));
            }
        }
        return charSequence;
    }
}
