package com.facebook.feed.rows.sections.header;

import android.text.Spannable;
import com.facebook.feed.rows.core.persistence.ContextStateKey;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.spannable.PersistentSpannable;
import com.facebook.feedplugins.graphqlstory.explanation.ExplanationSpannableBuilder;
import com.facebook.feedplugins.spannable.PersistentSpannableWithoutLayoutInput;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.GraphQLTextWithEntities;
import com.facebook.graphql.model.interfaces.CacheableEntity;
import javax.annotation.Nullable;

/* compiled from: disk_uri */
public class ExplanationTextSpannableInput extends PersistentSpannableWithoutLayoutInput {
    private final FeedProps<GraphQLStory> f13782a;
    public final ExplanationSpannableBuilder f13783b;
    private final ContextStateKey<String, PersistentSpannable> f13784c = new PersistentSpannableKey(this, this.f13782a);
    private final GraphQLTextWithEntities f13785d = ((GraphQLStory) this.f13782a.a).W();

    /* compiled from: disk_uri */
    class PersistentSpannableKey implements ContextStateKey<String, PersistentSpannable> {
        final /* synthetic */ ExplanationTextSpannableInput f13786a;
        private final String f13787b;
        private final FeedProps<GraphQLStory> f13788c;

        public PersistentSpannableKey(ExplanationTextSpannableInput explanationTextSpannableInput, FeedProps<GraphQLStory> feedProps) {
            this.f13786a = explanationTextSpannableInput;
            GraphQLStory graphQLStory = (GraphQLStory) feedProps.a;
            this.f13787b = "story:explanation:" + (graphQLStory.g() != null ? graphQLStory.g() : String.valueOf(graphQLStory.V()));
            this.f13788c = feedProps;
        }

        public final Object m14497a() {
            return new PersistentSpannable(this.f13786a.f13783b.a(this.f13788c), false);
        }

        public final Object m14498b() {
            return this.f13787b;
        }
    }

    public ExplanationTextSpannableInput(FeedProps<GraphQLStory> feedProps, ExplanationSpannableBuilder explanationSpannableBuilder) {
        this.f13782a = feedProps;
        this.f13783b = explanationSpannableBuilder;
    }

    public final ContextStateKey<String, PersistentSpannable> m14494a() {
        return this.f13784c;
    }

    @Nullable
    public final GraphQLTextWithEntities m14495b() {
        return this.f13785d;
    }

    public final CacheableEntity m14496c() {
        return (CacheableEntity) this.f13782a.a;
    }

    public final int m14493a(Spannable spannable) {
        return 0;
    }
}
