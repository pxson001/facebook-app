package com.facebook.feed.rows.sections.text;

import android.content.Context;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.view.View;
import com.facebook.analytics.view.tracking.TrackingNodes;
import com.facebook.analytics.view.tracking.TrackingNodes.TrackingNode;
import com.facebook.feed.environment.HasContext;
import com.facebook.feed.environment.HasFeedListType;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.renderer.DefaultFeedUnitRenderer;
import com.facebook.feed.rows.core.FeedListName;
import com.facebook.feed.rows.core.FeedListType;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.core.persistence.ContextStateKey;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.core.props.StoryProps;
import com.facebook.feed.rows.views.ContentTextView;
import com.facebook.feed.spannable.PersistentSpannable;
import com.facebook.feedplugins.highlighter.FeedHighlighter;
import com.facebook.feedplugins.spannable.PersistentSpannableWithoutLayoutInput;
import com.facebook.feedplugins.spannable.SpannableInTextViewPartDefinition;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.GraphQLTextWithEntities;
import com.facebook.graphql.model.StoryTextHelper;
import com.facebook.graphql.model.interfaces.CacheableEntity;
import com.facebook.inject.Assisted;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.api.ViewType;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: ufi/reactions/v6/84x84/dorothy */
public class BaseTextPartDefinition<E extends HasContext & HasFeedListType & HasPositionInformation> extends MultiRowSinglePartDefinition<FeedProps<GraphQLStory>, Void, E, ContentTextView> {
    public static final ViewType f19a = new C00001();
    public final boolean f20b;
    public final Provider<DefaultFeedUnitRenderer> f21c;
    public final FeedHighlighter f22d;
    private final CopyTextPartDefinition f23e;
    private final SpannableInTextViewPartDefinition f24f;

    /* compiled from: ufi/reactions/v6/84x84/dorothy */
    final class C00001 extends ViewType {
        C00001() {
        }

        public final View m23a(Context context) {
            ContentTextView contentTextView = new ContentTextView(context);
            contentTextView.setId(2131558553);
            return contentTextView;
        }
    }

    /* compiled from: ufi/reactions/v6/84x84/dorothy */
    class ContentTextPersistentSpannableInput extends PersistentSpannableWithoutLayoutInput {
        final /* synthetic */ BaseTextPartDefinition f25a;
        private final GraphQLTextWithEntities f26b;
        private final FeedProps<GraphQLStory> f27c;
        private final ContextStateKey<String, PersistentSpannable> f28d;

        public ContentTextPersistentSpannableInput(BaseTextPartDefinition baseTextPartDefinition, FeedProps<GraphQLStory> feedProps, @Nullable FeedListType feedListType) {
            this.f25a = baseTextPartDefinition;
            this.f26b = ((GraphQLStory) feedProps.a).aE();
            this.f27c = feedProps;
            this.f28d = new PersistentSpannableKey(baseTextPartDefinition, feedProps, baseTextPartDefinition.f20b, feedListType);
        }

        public final ContextStateKey<String, PersistentSpannable> m25a() {
            return this.f28d;
        }

        @Nullable
        public final GraphQLTextWithEntities m26b() {
            return this.f26b;
        }

        public final CacheableEntity m27c() {
            return (CacheableEntity) this.f27c.a;
        }

        public final int m24a(Spannable spannable) {
            if (this.f26b == null || this.f26b.d() == null || this.f26b.d().isEmpty()) {
                return 0;
            }
            return spannable.length() - this.f26b.a().length();
        }
    }

    /* compiled from: ufi/reactions/v6/84x84/dorothy */
    public class PersistentSpannableKey implements ContextStateKey<String, PersistentSpannable> {
        public final /* synthetic */ BaseTextPartDefinition f29a;
        public final FeedProps<GraphQLStory> f30b;
        private final String f31c;
        public final FeedListType f32d;

        public final Object m28a() {
            GraphQLStory graphQLStory = (GraphQLStory) this.f30b.a;
            if (StoryTextHelper.a(graphQLStory).isEmpty()) {
                return new PersistentSpannable(new SpannableStringBuilder(""), false);
            }
            CharSequence b;
            Spannable spannableStringBuilder;
            if (this.f32d.a() == FeedListName.SEARCH_DENSE_FEED || this.f32d.a() == FeedListName.SEARCH_DENSE_FEED_WITHOUT_UFI) {
                b = ((DefaultFeedUnitRenderer) this.f29a.f21c.get()).b(this.f30b, 0, this.f29a.f20b);
            } else {
                b = ((DefaultFeedUnitRenderer) this.f29a.f21c.get()).a(this.f30b, this.f29a.f20b);
            }
            CharSequence charSequence = b;
            FeedHighlighter feedHighlighter = this.f29a.f22d;
            if (FeedHighlighter.a(graphQLStory)) {
                spannableStringBuilder = new SpannableStringBuilder(this.f29a.f22d.a(graphQLStory, charSequence));
            } else {
                spannableStringBuilder = new SpannableStringBuilder(charSequence);
            }
            return new PersistentSpannable(spannableStringBuilder, false);
        }

        public PersistentSpannableKey(BaseTextPartDefinition baseTextPartDefinition, FeedProps<GraphQLStory> feedProps, boolean z, FeedListType feedListType) {
            this.f29a = baseTextPartDefinition;
            this.f30b = feedProps;
            this.f31c = StoryContentPersistentStateId.a((GraphQLStory) feedProps.a, z);
            this.f32d = feedListType;
        }

        public final Object m29b() {
            return this.f31c;
        }
    }

    public final Object m19a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        FeedProps feedProps = (FeedProps) obj;
        HasContext hasContext = (HasContext) anyEnvironment;
        subParts.a(this.f23e, (GraphQLStory) feedProps.a);
        subParts.a(this.f24f, new ContentTextPersistentSpannableInput(this, feedProps, ((HasFeedListType) hasContext).c()));
        return null;
    }

    public final /* bridge */ /* synthetic */ void m20a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, 1978154193);
        FeedProps feedProps = (FeedProps) obj;
        ContentTextView contentTextView = (ContentTextView) view;
        GraphQLStory graphQLStory = (GraphQLStory) feedProps.a;
        TrackingNodes.a(contentTextView, TrackingNode.DESCRIPTION);
        contentTextView.setTag(2131558541, Boolean.valueOf(StoryProps.p(feedProps)));
        contentTextView.b = graphQLStory;
        contentTextView.b();
        Logger.a(8, EntryType.MARK_POP, -33752914, a);
    }

    public final void m22b(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        ((ContentTextView) view).b = null;
    }

    @Inject
    public BaseTextPartDefinition(Provider<DefaultFeedUnitRenderer> provider, CopyTextPartDefinition copyTextPartDefinition, @Assisted Boolean bool, FeedHighlighter feedHighlighter, SpannableInTextViewPartDefinition spannableInTextViewPartDefinition) {
        this.f21c = provider;
        this.f23e = copyTextPartDefinition;
        this.f20b = bool.booleanValue();
        this.f22d = feedHighlighter;
        this.f24f = spannableInTextViewPartDefinition;
    }

    public final ViewType m18a() {
        return f19a;
    }

    public final boolean m21a(Object obj) {
        return true;
    }
}
