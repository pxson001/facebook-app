package com.facebook.feed.analytics.vpvlogging.debugger;

import com.facebook.graphql.model.FeedUnit;
import com.facebook.graphql.model.GraphQLActor;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.GraphQLTextWithEntities;
import com.facebook.ui.toaster.ToastBuilder;
import com.facebook.ui.toaster.Toaster;
import com.google.common.collect.ImmutableList;
import javax.inject.Inject;

/* compiled from: needs_userinfo */
public class VpvLoggingToastDebugger implements VpvLoggingDebugger {
    private final Toaster f10126a;

    @Inject
    public VpvLoggingToastDebugger(Toaster toaster) {
        this.f10126a = toaster;
    }

    public final void m15796a(FeedUnit feedUnit, long j) {
        StringBuilder stringBuilder = new StringBuilder("LOGGED: ");
        stringBuilder.append(j);
        stringBuilder.append("ms");
        if (feedUnit instanceof GraphQLStory) {
            GraphQLStory graphQLStory = (GraphQLStory) feedUnit;
            ImmutableList b = graphQLStory.b();
            if (!(b == null || b.isEmpty())) {
                stringBuilder.append(" - ");
                stringBuilder.append(((GraphQLActor) b.get(0)).aa());
                stringBuilder.append(": ");
            }
            GraphQLTextWithEntities aj = graphQLStory.aj();
            if (aj != null) {
                String a = aj.a();
                if (a.length() >= 20) {
                    a = a.substring(0, 20);
                }
                stringBuilder.append(a);
            }
        }
        this.f10126a.a(new ToastBuilder(stringBuilder.toString()));
    }
}
