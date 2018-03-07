package com.facebook.feedplugins.pymi.rows;

import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.feed.environment.HasInvalidate;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.graphql.model.GraphQLPeopleYouMayInviteFeedUnitContactsEdge;
import com.facebook.graphql.model.mutator.GraphQLPeopleYouMayInviteFeedUnitContactsEdgeMutator;
import com.facebook.ui.toaster.ToastBuilder;
import javax.annotation.Nullable;

/* compiled from: cleanup */
public class PeopleYouMayInvitePagePartDefinition$5 extends AbstractDisposableFutureCallback<Void> {
    final /* synthetic */ GraphQLPeopleYouMayInviteFeedUnitContactsEdge f8784a;
    final /* synthetic */ PeopleYouMayInvitePagePartDefinition$Props f8785b;
    final /* synthetic */ HasInvalidate f8786c;
    final /* synthetic */ C1072x343a510a f8787d;
    final /* synthetic */ C1073xf61787c f8788e;
    final /* synthetic */ PeopleYouMayInvitePagePartDefinition f8789f;

    public PeopleYouMayInvitePagePartDefinition$5(PeopleYouMayInvitePagePartDefinition peopleYouMayInvitePagePartDefinition, GraphQLPeopleYouMayInviteFeedUnitContactsEdge graphQLPeopleYouMayInviteFeedUnitContactsEdge, PeopleYouMayInvitePagePartDefinition$Props peopleYouMayInvitePagePartDefinition$Props, HasInvalidate hasInvalidate, C1072x343a510a c1072x343a510a, C1073xf61787c c1073xf61787c) {
        this.f8789f = peopleYouMayInvitePagePartDefinition;
        this.f8784a = graphQLPeopleYouMayInviteFeedUnitContactsEdge;
        this.f8785b = peopleYouMayInvitePagePartDefinition$Props;
        this.f8786c = hasInvalidate;
        this.f8787d = c1072x343a510a;
        this.f8788e = c1073xf61787c;
    }

    public final void m9555a(@Nullable Object obj) {
        this.f8789f.e.a(this.f8785b.f8794b, GraphQLPeopleYouMayInviteFeedUnitContactsEdgeMutator.a(this.f8784a).a(true).a);
        this.f8786c.a(new Object[]{this.f8785b.f8794b});
    }

    public final void m9556a(Throwable th) {
        this.f8789f.m.b(new ToastBuilder(2131230758));
        ((HasPersistentState) this.f8786c).a(this.f8787d, new C1073xf61787c(this.f8788e.f8791a, false));
        this.f8789f.e.a(this.f8785b.f8794b, GraphQLPeopleYouMayInviteFeedUnitContactsEdgeMutator.a(this.f8784a).a(false).a);
        this.f8786c.a(new Object[]{this.f8785b.f8794b});
    }
}
