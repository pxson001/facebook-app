package com.facebook.feed.permalink;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.api.ufiservices.FetchSingleCommentParams;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.graphql.linkutil.TextWithEntitiesUtil;
import com.facebook.graphql.linkutil.TextWithEntitiesUtil.SpannifyTask;
import com.facebook.graphql.model.GraphQLComment;
import com.facebook.inject.FbInjector;
import com.facebook.ipc.feed.PermalinkStoryIdParams.Builder;
import com.facebook.ipc.feed.ViewPermalinkIntentFactory;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.resources.ui.FbTextView;
import javax.inject.Inject;

/* compiled from: album_creator_opened */
public class CommentPermalinkEscapeHatchView extends FbTextView {
    @Inject
    SecureContextHelper f19546a;
    @Inject
    TextWithEntitiesUtil f19547b;
    @Inject
    ViewPermalinkIntentFactory f19548c;

    private static <T extends View> void m22859a(Class<T> cls, T t) {
        m22860a((Object) t, t.getContext());
    }

    private static void m22860a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((CommentPermalinkEscapeHatchView) obj).m22858a((SecureContextHelper) DefaultSecureContextHelper.a(fbInjector), TextWithEntitiesUtil.b(fbInjector), ViewPermalinkIntentFactory.a(fbInjector));
    }

    private void m22858a(SecureContextHelper secureContextHelper, TextWithEntitiesUtil textWithEntitiesUtil, ViewPermalinkIntentFactory viewPermalinkIntentFactory) {
        this.f19546a = secureContextHelper;
        this.f19547b = textWithEntitiesUtil;
        this.f19548c = viewPermalinkIntentFactory;
    }

    public CommentPermalinkEscapeHatchView(Context context) {
        this(context, null);
    }

    public CommentPermalinkEscapeHatchView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CommentPermalinkEscapeHatchView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m22859a(CommentPermalinkEscapeHatchView.class, (View) this);
    }

    public final void m22861a(GraphQLComment graphQLComment, final FetchSingleCommentParams fetchSingleCommentParams) {
        setText(graphQLComment.E().a());
        TextWithEntitiesUtil textWithEntitiesUtil = this.f19547b;
        textWithEntitiesUtil.a.a(new SpannifyTask(textWithEntitiesUtil, this, graphQLComment.E(), -1), new Object[0]);
        setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ CommentPermalinkEscapeHatchView f19545b;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, -191943411);
                Builder builder = new Builder();
                builder.a = fetchSingleCommentParams.d;
                builder = builder;
                builder.b = fetchSingleCommentParams.e;
                this.f19545b.f19546a.a(this.f19545b.f19548c.a(builder.a()), this.f19545b.getContext());
                Logger.a(2, EntryType.UI_INPUT_END, 111930824, a);
            }
        });
    }
}
