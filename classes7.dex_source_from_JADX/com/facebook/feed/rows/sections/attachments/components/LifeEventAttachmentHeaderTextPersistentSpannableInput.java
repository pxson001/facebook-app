package com.facebook.feed.rows.sections.attachments.components;

import android.content.Context;
import android.text.Spannable;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.common.uri.FbUriIntentHandler;
import com.facebook.feed.rows.core.persistence.ContextStateKey;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.core.props.TrackableFeedProps;
import com.facebook.feed.rows.sections.attachments.AttachmentTextPersistentStateId;
import com.facebook.feed.spannable.PersistentSpannable;
import com.facebook.feedplugins.spannable.PersistentSpannableWithoutLayoutInput;
import com.facebook.graphql.model.FeedStorySpannableString;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.graphql.model.GraphQLTextWithEntities;
import com.facebook.graphql.model.interfaces.CacheableEntity;
import com.facebook.inject.Assisted;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.ufiservices.flyout.FlyoutClickSource;
import com.facebook.ufiservices.util.LinkifyUtil;
import com.facebook.ufiservices.util.LinkifyUtilConverter;
import com.google.common.base.Strings;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: Visual Feedback for topics prediction */
public class LifeEventAttachmentHeaderTextPersistentSpannableInput extends PersistentSpannableWithoutLayoutInput {
    private final GraphQLStory f20916a;
    private final ContextStateKey<String, PersistentSpannable> f20917b;
    public final Context f20918c;
    public final LinkifyUtil f20919d;
    public final Provider<FbUriIntentHandler> f20920e;

    /* compiled from: Visual Feedback for topics prediction */
    class PersistentSpannableKey implements ContextStateKey<String, PersistentSpannable> {
        final /* synthetic */ LifeEventAttachmentHeaderTextPersistentSpannableInput f20910a;
        private final GraphQLTextWithEntities f20911b;
        public final GraphQLStoryAttachment f20912c;
        private final FeedProps<GraphQLStoryAttachment> f20913d;
        private final FlyoutClickSource f20914e;
        private final String f20915f;

        /* compiled from: Visual Feedback for topics prediction */
        class C17811 implements OnClickListener {
            final /* synthetic */ PersistentSpannableKey f20909a;

            C17811(PersistentSpannableKey persistentSpannableKey) {
                this.f20909a = persistentSpannableKey;
            }

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, 2110125176);
                ((FbUriIntentHandler) this.f20909a.f20910a.f20920e.get()).a(this.f20909a.f20910a.f20918c, Strings.nullToEmpty(this.f20909a.f20912c.C()));
                Logger.a(2, EntryType.UI_INPUT_END, 1234002887, a);
            }
        }

        public final Object m23830a() {
            if (this.f20911b == null || Strings.isNullOrEmpty(this.f20911b.a())) {
                return new PersistentSpannable(new FeedStorySpannableString(""), false);
            }
            Spannable a = this.f20910a.f20919d.a(LinkifyUtilConverter.b(this.f20911b), null, this.f20914e, TrackableFeedProps.a(this.f20913d));
            Spannable a2 = this.f20910a.f20919d.a(a, new C17811(this));
            if (a2 != null) {
                a = a2;
            }
            return new PersistentSpannable(a, false);
        }

        private PersistentSpannableKey(LifeEventAttachmentHeaderTextPersistentSpannableInput lifeEventAttachmentHeaderTextPersistentSpannableInput, FeedProps<GraphQLStoryAttachment> feedProps, FeedProps<GraphQLStory> feedProps2, GraphQLTextWithEntities graphQLTextWithEntities, FlyoutClickSource flyoutClickSource, String str) {
            this.f20910a = lifeEventAttachmentHeaderTextPersistentSpannableInput;
            this.f20913d = feedProps;
            this.f20912c = (GraphQLStoryAttachment) feedProps.a;
            this.f20911b = graphQLTextWithEntities;
            this.f20914e = flyoutClickSource;
            this.f20915f = AttachmentTextPersistentStateId.m23586a((GraphQLStory) feedProps2.a, str);
        }

        public final Object m23831b() {
            return this.f20915f;
        }
    }

    @Inject
    public LifeEventAttachmentHeaderTextPersistentSpannableInput(Context context, LinkifyUtil linkifyUtil, Provider<FbUriIntentHandler> provider, @Assisted FeedProps<GraphQLStoryAttachment> feedProps, @Assisted FeedProps<GraphQLStory> feedProps2, @Assisted GraphQLTextWithEntities graphQLTextWithEntities, @Assisted FlyoutClickSource flyoutClickSource, @Assisted String str) {
        this.f20916a = (GraphQLStory) feedProps2.a();
        this.f20917b = new PersistentSpannableKey(feedProps, feedProps2, graphQLTextWithEntities, flyoutClickSource, str);
        this.f20918c = context;
        this.f20919d = linkifyUtil;
        this.f20920e = provider;
    }

    public final ContextStateKey<String, PersistentSpannable> m23833a() {
        return this.f20917b;
    }

    @Nullable
    public final GraphQLTextWithEntities m23834b() {
        return null;
    }

    public final CacheableEntity m23835c() {
        return this.f20916a;
    }

    public final int m23832a(Spannable spannable) {
        return 0;
    }
}
