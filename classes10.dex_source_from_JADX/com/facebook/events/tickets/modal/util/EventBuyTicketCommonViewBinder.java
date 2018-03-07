package com.facebook.events.tickets.modal.util;

import android.content.Intent;
import android.net.Uri;
import android.view.View;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.graphql.linkutil.GraphQLLinkExtractor;
import com.facebook.graphql.linkutil.GraphQLLinkExtractorGraphQLInterfaces.GetEntityFbLinkGraphQL;
import com.facebook.graphql.linkutil.GraphQLLinkExtractorGraphQLModels.LinkableTextWithEntitiesModel;
import com.facebook.inject.InjectorLike;
import com.facebook.widget.text.textwithentitiesview.TextWithEntitiesView;
import com.facebook.widget.text.textwithentitiesview.TextWithEntitiesView.LinkableEntityListener;
import javax.inject.Inject;

/* compiled from: approval_mode_thread_summary */
public class EventBuyTicketCommonViewBinder {
    public final SecureContextHelper f19341a;
    public final GraphQLLinkExtractor f19342b;

    public static EventBuyTicketCommonViewBinder m19491b(InjectorLike injectorLike) {
        return new EventBuyTicketCommonViewBinder((SecureContextHelper) DefaultSecureContextHelper.a(injectorLike), GraphQLLinkExtractor.a(injectorLike));
    }

    @Inject
    public EventBuyTicketCommonViewBinder(SecureContextHelper secureContextHelper, GraphQLLinkExtractor graphQLLinkExtractor) {
        this.f19341a = secureContextHelper;
        this.f19342b = graphQLLinkExtractor;
    }

    public final void m19492a(final View view, LinkableTextWithEntitiesModel linkableTextWithEntitiesModel) {
        TextWithEntitiesView textWithEntitiesView = (TextWithEntitiesView) view.findViewById(2131561217);
        if (textWithEntitiesView != null) {
            textWithEntitiesView.a(linkableTextWithEntitiesModel, new LinkableEntityListener(this) {
                final /* synthetic */ EventBuyTicketCommonViewBinder f19340b;

                public final void m19490a(GetEntityFbLinkGraphQL getEntityFbLinkGraphQL) {
                    String a = this.f19340b.f19342b.a(getEntityFbLinkGraphQL);
                    Intent intent = new Intent("android.intent.action.VIEW");
                    intent.setData(Uri.parse(a));
                    intent.addFlags(268435456);
                    this.f19340b.f19341a.b(intent, view.getContext());
                }
            });
        }
    }
}
