package com.facebook.feedback.ui;

import com.facebook.common.util.StringUtil;
import com.facebook.feed.rows.core.events.Action;
import com.facebook.feed.rows.core.events.EventsStream;
import com.facebook.feed.rows.core.events.KeyedEvent;
import com.facebook.feed.rows.core.events.Subscription;
import com.facebook.graphql.model.GraphQLComment;
import com.facebook.inject.Assisted;
import com.facebook.ufiservices.event.CommentEvents.DeleteCommentEvent;
import com.facebook.ufiservices.event.CommentEvents.UpdateCommentEvent;
import com.google.common.base.Function;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;

/* compiled from: see_all_ratings_action */
public class CommentEventSubscriber implements Bindable<GraphQLComment> {
    public final EventsStream f4252a;
    public final List<Subscription> f4253b = new ArrayList();
    public final Function<GraphQLComment, Void> f4254c;
    public GraphQLComment f4255d;
    private boolean f4256e;
    private String f4257f;

    /* compiled from: see_all_ratings_action */
    class C03791 implements Action<UpdateCommentEvent> {
        final /* synthetic */ CommentEventSubscriber f4250a;

        C03791(CommentEventSubscriber commentEventSubscriber) {
            this.f4250a = commentEventSubscriber;
        }

        public final void m4856a(Object obj) {
            GraphQLComment graphQLComment = ((UpdateCommentEvent) obj).a;
            if (StringUtil.a(graphQLComment.y(), this.f4250a.f4255d.y())) {
                this.f4250a.f4254c.apply(graphQLComment);
            }
        }
    }

    /* compiled from: see_all_ratings_action */
    class C03802 implements Action<DeleteCommentEvent> {
        final /* synthetic */ CommentEventSubscriber f4251a;

        C03802(CommentEventSubscriber commentEventSubscriber) {
            this.f4251a = commentEventSubscriber;
        }

        public final void m4857a(Object obj) {
            if (StringUtil.a(((DeleteCommentEvent) obj).a.y(), this.f4251a.f4255d.y())) {
                this.f4251a.f4254c.apply(null);
            }
        }
    }

    @Inject
    public CommentEventSubscriber(@Assisted String str, @Assisted Function<GraphQLComment, Void> function, EventsStream eventsStream) {
        this.f4257f = str;
        this.f4254c = function;
        this.f4252a = eventsStream;
    }

    public final void m4860a(GraphQLComment graphQLComment) {
        this.f4255d = graphQLComment;
        if (graphQLComment != null && !this.f4256e && graphQLComment.l() != null && graphQLComment.l().z_() != null) {
            m4859b();
        }
    }

    private void m4859b() {
        m4858a(UpdateCommentEvent.class, new C03791(this));
        m4858a(DeleteCommentEvent.class, new C03802(this));
        this.f4256e = true;
    }

    private <E extends KeyedEvent<String>> void m4858a(Class<E> cls, Action<E> action) {
        this.f4253b.add(this.f4252a.a(cls, this.f4257f, action));
    }
}
