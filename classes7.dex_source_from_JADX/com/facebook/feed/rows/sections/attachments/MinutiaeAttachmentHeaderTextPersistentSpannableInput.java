package com.facebook.feed.rows.sections.attachments;

import android.content.Context;
import android.text.Spannable;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.common.uri.FbUriIntentHandler;
import com.facebook.feed.rows.core.persistence.ContextStateKey;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.core.props.TrackableFeedProps;
import com.facebook.feed.rows.sections.attachments.MinutiaeAttachmentTextPartDefinition.Props;
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

/* compiled from: ZII */
public class MinutiaeAttachmentHeaderTextPersistentSpannableInput extends PersistentSpannableWithoutLayoutInput {
    private final GraphQLStory f20691a;
    private final ContextStateKey<String, PersistentSpannable> f20692b;

    /* compiled from: ZII */
    class PersistentSpannableKey implements ContextStateKey<String, PersistentSpannable> {
        private final GraphQLTextWithEntities f20683a;
        public final GraphQLStoryAttachment f20684b;
        private final FeedProps<GraphQLStoryAttachment> f20685c;
        private final FlyoutClickSource f20686d;
        private final String f20687e;
        public final Context f20688f;
        private final LinkifyUtil f20689g;
        public final Provider<FbUriIntentHandler> f20690h;

        /* compiled from: ZII */
        class C17741 implements OnClickListener {
            final /* synthetic */ PersistentSpannableKey f20682a;

            C17741(PersistentSpannableKey persistentSpannableKey) {
                this.f20682a = persistentSpannableKey;
            }

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, -156114484);
                ((FbUriIntentHandler) this.f20682a.f20690h.get()).a(this.f20682a.f20688f, Strings.nullToEmpty(this.f20682a.f20684b.C()));
                Logger.a(2, EntryType.UI_INPUT_END, 521973640, a);
            }
        }

        public final Object m23692a() {
            if (this.f20683a == null || Strings.isNullOrEmpty(this.f20683a.a())) {
                return new PersistentSpannable(new FeedStorySpannableString(""), false);
            }
            Spannable a = this.f20689g.a(LinkifyUtilConverter.b(this.f20683a), null, this.f20686d, TrackableFeedProps.a(this.f20685c));
            Spannable a2 = this.f20689g.a(a, new C17741(this));
            if (a2 != null) {
                a = a2;
            }
            return new PersistentSpannable(a, false);
        }

        public PersistentSpannableKey(Props props, Context context, LinkifyUtil linkifyUtil, Provider<FbUriIntentHandler> provider) {
            this.f20688f = context;
            this.f20689g = linkifyUtil;
            this.f20690h = provider;
            this.f20684b = (GraphQLStoryAttachment) props.f20701a.a;
            this.f20685c = props.f20701a;
            this.f20683a = props.f20705e;
            this.f20686d = props.f20702b;
            this.f20687e = AttachmentTextPersistentStateId.m23586a((GraphQLStory) props.f20704d.a, props.f20703c);
        }

        public final Object m23693b() {
            return this.f20687e;
        }
    }

    @Inject
    public MinutiaeAttachmentHeaderTextPersistentSpannableInput(@Assisted Props props, Context context, LinkifyUtil linkifyUtil, Provider<FbUriIntentHandler> provider) {
        this.f20691a = (GraphQLStory) props.f20704d.a;
        this.f20692b = new PersistentSpannableKey(props, context, linkifyUtil, provider);
    }

    public final ContextStateKey<String, PersistentSpannable> m23695a() {
        return this.f20692b;
    }

    @Nullable
    public final GraphQLTextWithEntities m23696b() {
        return null;
    }

    public final CacheableEntity m23697c() {
        return this.f20691a;
    }

    public final int m23694a(Spannable spannable) {
        return 0;
    }
}
