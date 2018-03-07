package com.facebook.groups.feed.ui.partdefinitions;

import android.content.Context;
import android.text.Spannable;
import android.view.View;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.fbui.widget.text.TextLayoutView;
import com.facebook.fbui.widget.text.layoutbuilder.TextLayoutBuilder;
import com.facebook.feed.environment.HasInvalidate;
import com.facebook.feed.environment.HasMenuButtonProvider;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.feed.menu.base.BaseFeedStoryMenuHelper;
import com.facebook.feed.rows.core.persistence.ContextStateKey;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.core.props.StoryProps;
import com.facebook.feed.rows.sections.header.HeaderTextLayoutWidthResolver;
import com.facebook.feed.rows.sections.header.TitleTextLayoutBuilderHolder;
import com.facebook.feed.spannable.FeedSpannables;
import com.facebook.feed.spannable.PersistentSpannable;
import com.facebook.feed.ui.api.FeedMenuHelper;
import com.facebook.feed.util.render.FeedRenderUtils;
import com.facebook.feedplugins.graphqlstory.header.HeaderTitlePersistentStateId;
import com.facebook.feedplugins.graphqlstory.header.HeaderTitleSpannableBuilder;
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
import javax.annotation.Nullable;
import javax.inject.Inject;

@ContextScoped
/* compiled from: ThreadListLoader.loadThreads */
public class GroupsHeaderTitlePartDefinition<E extends HasPersistentState & HasMenuButtonProvider & HasInvalidate> extends BaseSinglePartDefinition<FeedProps<GraphQLStory>, Void, E, TextLayoutView> {
    private static GroupsHeaderTitlePartDefinition f22477g;
    private static final Object f22478h = new Object();
    public final FeedHighlighter f22479a;
    private final TitleTextLayoutBuilderHolder f22480b;
    public final HeaderTextLayoutWidthResolver f22481c;
    public final FeedRenderUtils f22482d;
    public final HeaderTitleSpannableBuilder f22483e;
    private final SpannableInTextLayoutPartDefinition<E> f22484f;

    /* compiled from: ThreadListLoader.loadThreads */
    class GroupsHeaderTitlePersistentSpannableInput implements PersistentSpannableInput {
        final /* synthetic */ GroupsHeaderTitlePartDefinition f22468a;
        private final BaseFeedStoryMenuHelper f22469b;
        private final GraphQLTextWithEntities f22470c;
        private final TextLayoutBuilder f22471d;
        private final FeedProps<GraphQLStory> f22472e;
        private final ContextStateKey<String, PersistentSpannable> f22473f;

        public GroupsHeaderTitlePersistentSpannableInput(GroupsHeaderTitlePartDefinition groupsHeaderTitlePartDefinition, TextLayoutBuilder textLayoutBuilder, FeedProps<GraphQLStory> feedProps, FeedMenuHelper feedMenuHelper) {
            this.f22468a = groupsHeaderTitlePartDefinition;
            this.f22471d = textLayoutBuilder;
            this.f22472e = feedProps;
            this.f22470c = ((GraphQLStory) feedProps.a).aH();
            this.f22469b = feedMenuHelper;
            this.f22473f = new PersistentSpannableKey(groupsHeaderTitlePartDefinition, feedProps);
        }

        public final ContextStateKey<String, PersistentSpannable> m23535a() {
            return this.f22473f;
        }

        public final TextLayoutBuilder m23538d() {
            return this.f22471d;
        }

        public final int m23539e() {
            return this.f22468a.f22481c.a(this.f22472e, this.f22469b, this.f22468a.f22482d.a(), -1);
        }

        @Nullable
        public final GraphQLTextWithEntities m23536b() {
            return this.f22470c;
        }

        public final CacheableEntity m23537c() {
            return (CacheableEntity) this.f22472e.a;
        }

        public final int m23534a(Spannable spannable) {
            return 0;
        }
    }

    /* compiled from: ThreadListLoader.loadThreads */
    class PersistentSpannableKey implements ContextStateKey<String, PersistentSpannable> {
        final /* synthetic */ GroupsHeaderTitlePartDefinition f22474a;
        private final FeedProps<GraphQLStory> f22475b;
        private final String f22476c;

        public PersistentSpannableKey(GroupsHeaderTitlePartDefinition groupsHeaderTitlePartDefinition, FeedProps<GraphQLStory> feedProps) {
            this.f22474a = groupsHeaderTitlePartDefinition;
            this.f22475b = feedProps;
            this.f22476c = HeaderTitlePersistentStateId.a((GraphQLStory) feedProps.a);
        }

        public final Object m23540a() {
            CharSequence c = this.f22474a.f22483e.a(this.f22475b).c();
            FeedHighlighter feedHighlighter = this.f22474a.f22479a;
            return new PersistentSpannable(FeedSpannables.a(FeedHighlighter.a((GraphQLStory) this.f22475b.a) ? this.f22474a.f22479a.a((GraphQLStory) this.f22475b.a, c) : c), false);
        }

        public final Object m23541b() {
            return this.f22476c;
        }
    }

    private static GroupsHeaderTitlePartDefinition m23543b(InjectorLike injectorLike) {
        return new GroupsHeaderTitlePartDefinition(FeedHighlighter.a(injectorLike), TitleTextLayoutBuilderHolder.a(injectorLike), HeaderTextLayoutWidthResolver.a(injectorLike), FeedRenderUtils.a(injectorLike), HeaderTitleSpannableBuilder.a(injectorLike), SpannableInTextLayoutPartDefinition.a(injectorLike));
    }

    public final Object m23544a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        subParts.a(this.f22484f, new GroupsHeaderTitlePersistentSpannableInput(this, this.f22480b.a, (FeedProps) obj, ((HasMenuButtonProvider) ((HasPersistentState) anyEnvironment)).e()));
        return null;
    }

    public final /* bridge */ /* synthetic */ void m23545a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, 1571971350);
        ((TextLayoutView) view).setTag(2131558541, Boolean.valueOf(StoryProps.p((FeedProps) obj)));
        Logger.a(8, EntryType.MARK_POP, 1356440541, a);
    }

    public static GroupsHeaderTitlePartDefinition m23542a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            GroupsHeaderTitlePartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f22478h) {
                GroupsHeaderTitlePartDefinition groupsHeaderTitlePartDefinition;
                if (a2 != null) {
                    groupsHeaderTitlePartDefinition = (GroupsHeaderTitlePartDefinition) a2.a(f22478h);
                } else {
                    groupsHeaderTitlePartDefinition = f22477g;
                }
                if (groupsHeaderTitlePartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m23543b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f22478h, b3);
                        } else {
                            f22477g = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = groupsHeaderTitlePartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Inject
    public GroupsHeaderTitlePartDefinition(FeedHighlighter feedHighlighter, TitleTextLayoutBuilderHolder titleTextLayoutBuilderHolder, HeaderTextLayoutWidthResolver headerTextLayoutWidthResolver, FeedRenderUtils feedRenderUtils, HeaderTitleSpannableBuilder headerTitleSpannableBuilder, SpannableInTextLayoutPartDefinition spannableInTextLayoutPartDefinition) {
        this.f22479a = feedHighlighter;
        this.f22480b = titleTextLayoutBuilderHolder;
        this.f22481c = headerTextLayoutWidthResolver;
        this.f22482d = feedRenderUtils;
        this.f22483e = headerTitleSpannableBuilder;
        this.f22484f = spannableInTextLayoutPartDefinition;
    }
}
