package com.facebook.feed.rows.sections;

import com.facebook.adinterfaces.external.events.AdInterfacesExternalEvents.BoostedPostStatusChangedEvent;
import com.facebook.adinterfaces.external.events.AdInterfacesExternalEvents.BoostedPostStatusChangedEventSubscriber;
import com.facebook.content.event.FbEvent;
import com.facebook.feed.rows.views.StoryInsightsFooterView;
import com.facebook.graphql.model.GraphQLPagePostPromotionInfo;
import com.facebook.graphql.model.GraphQLPagePostPromotionInfo.Builder;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.modelutil.BaseModel;

/* compiled from: \s+ */
class StoryPromotionPartDefinition$5 extends BoostedPostStatusChangedEventSubscriber {
    final /* synthetic */ StoryPromotionPartDefinition$State f20423a;
    final /* synthetic */ StoryInsightsFooterView f20424b;
    final /* synthetic */ StoryPromotionPartDefinition f20425c;

    StoryPromotionPartDefinition$5(StoryPromotionPartDefinition storyPromotionPartDefinition, StoryPromotionPartDefinition$State storyPromotionPartDefinition$State, StoryInsightsFooterView storyInsightsFooterView) {
        this.f20425c = storyPromotionPartDefinition;
        this.f20423a = storyPromotionPartDefinition$State;
        this.f20424b = storyInsightsFooterView;
    }

    public final void m23533b(FbEvent fbEvent) {
        BoostedPostStatusChangedEvent boostedPostStatusChangedEvent = (BoostedPostStatusChangedEvent) fbEvent;
        if (this.f20423a.f20434h.c() != null && this.f20423a.f20434h.c().equals(boostedPostStatusChangedEvent.a)) {
            GraphQLPagePostPromotionInfo ap = this.f20423a.f20434h.ap();
            Builder builder = new Builder();
            ap.h();
            builder.d = ap.a();
            builder.e = ap.j();
            builder.f = ap.k();
            builder.g = ap.l();
            builder.h = ap.m();
            builder.i = ap.n();
            builder.j = ap.o();
            builder.k = ap.p();
            builder.l = ap.q();
            builder.m = ap.r();
            builder.n = ap.s();
            builder.o = ap.t();
            BaseModel.Builder.a(builder, ap);
            Builder builder2 = builder;
            builder2.n = boostedPostStatusChangedEvent.b;
            ap = new GraphQLPagePostPromotionInfo(builder2);
            StoryPromotionPartDefinition$State storyPromotionPartDefinition$State = this.f20423a;
            GraphQLStory.Builder a = GraphQLStory.Builder.a(this.f20423a.f20434h);
            a.af = ap;
            storyPromotionPartDefinition$State.f20434h = a.a();
            this.f20423a.f20433g = StoryPromotionPartDefinition.a(this.f20425c, this.f20423a.f20434h, this.f20423a.f20427a);
            this.f20424b.setButtonText(this.f20423a.f20433g);
        }
    }
}
