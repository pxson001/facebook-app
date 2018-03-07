package com.facebook.appinvites.ui;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.widget.ImageView;
import com.facebook.appinvites.protocol.AppInvitesTextWithEntitiesModels.AppInvitesTextWithEntitiesModel;
import com.facebook.appinvites.protocol.AppInvitesTextWithEntitiesModels.AppInvitesTextWithEntitiesModel.RangesModel;
import com.facebook.appinvites.protocol.AppInvitesTextWithEntitiesModels.AppInvitesTextWithEntitiesModel.RangesModel.EntityModel;
import com.facebook.graphql.model.GraphQLEntity;
import com.facebook.graphql.model.GraphQLEntityAtRange;
import com.facebook.graphql.model.GraphQLHelper;
import com.facebook.graphql.model.GraphQLTextWithEntities;
import com.facebook.graphql.model.GraphQLTextWithEntities.Builder;
import com.facebook.widget.CustomViewGroup;
import com.facebook.widget.text.textwithentitiesview.TextWithEntitiesView;
import com.google.common.collect.ImmutableList;

/* compiled from: downloaded_version */
public class AppInviteView extends CustomViewGroup {
    public ViewPager f14700a = ((ViewPager) getView(2131559665));
    public AppInviteAppDetailsView f14701b;
    public ImageView f14702c;
    private TextWithEntitiesView f14703d;

    public AppInviteView(Context context) {
        super(context);
        setContentView(2130903278);
        this.f14700a.setPageMargin((int) (-1.5d * ((double) getResources().getDimension(2131427416))));
        this.f14700a.setOffscreenPageLimit(2);
        this.f14701b = (AppInviteAppDetailsView) getView(2131559666);
        this.f14702c = (ImageView) getView(2131559664);
        this.f14703d = (TextWithEntitiesView) getView(2131559663);
    }

    public void setSocialContext(AppInvitesTextWithEntitiesModel appInvitesTextWithEntitiesModel) {
        GraphQLTextWithEntities graphQLTextWithEntities;
        TextWithEntitiesView textWithEntitiesView = this.f14703d;
        String b = appInvitesTextWithEntitiesModel.m14893b();
        if (appInvitesTextWithEntitiesModel == null) {
            graphQLTextWithEntities = null;
        } else {
            Builder builder = new Builder();
            if (appInvitesTextWithEntitiesModel.m14892a() != null) {
                ImmutableList.Builder builder2 = ImmutableList.builder();
                for (int i = 0; i < appInvitesTextWithEntitiesModel.m14892a().size(); i++) {
                    GraphQLEntityAtRange graphQLEntityAtRange;
                    RangesModel rangesModel = (RangesModel) appInvitesTextWithEntitiesModel.m14892a().get(i);
                    if (rangesModel == null) {
                        graphQLEntityAtRange = null;
                    } else {
                        GraphQLEntity graphQLEntity;
                        GraphQLEntityAtRange.Builder builder3 = new GraphQLEntityAtRange.Builder();
                        EntityModel a = rangesModel.m14884a();
                        if (a == null) {
                            graphQLEntity = null;
                        } else {
                            GraphQLEntity.Builder builder4 = new GraphQLEntity.Builder();
                            builder4.S = a.m14878b();
                            builder4.m = a.m14879c();
                            builder4.u = a.m14880d();
                            graphQLEntity = builder4.a();
                        }
                        builder3.d = graphQLEntity;
                        builder3.e = rangesModel.m14887b();
                        builder3.f = rangesModel.m14888c();
                        graphQLEntityAtRange = builder3.a();
                    }
                    builder2.c(graphQLEntityAtRange);
                }
                builder.h = builder2.b();
            }
            builder.i = appInvitesTextWithEntitiesModel.m14893b();
            graphQLTextWithEntities = builder.a();
        }
        textWithEntitiesView.a(b, GraphQLHelper.a(graphQLTextWithEntities));
    }
}
