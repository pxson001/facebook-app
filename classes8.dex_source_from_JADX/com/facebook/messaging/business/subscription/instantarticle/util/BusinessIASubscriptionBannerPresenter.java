package com.facebook.messaging.business.subscription.instantarticle.util;

import com.facebook.browser.lite.products.messagingbusiness.banner.AbstractBusinessSubscriptionBannerUtil;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.inject.Assisted;
import com.facebook.messaging.business.subscription.common.analytics.BusinessSubscriptionAnalyticsLogger;
import com.facebook.messaging.business.subscription.instantarticle.view.BusinessIASubscribeBannerView;
import com.facebook.messaging.graphql.fetch.GQLUserConverter;
import com.facebook.messaging.graphql.threads.UserInfoModels.ProfilePhotoInfoModel;
import com.facebook.messaging.photos.tiles.model.MessengerThreadTileViewData.Builder;
import com.facebook.qe.api.QeAccessor;
import com.facebook.richdocument.model.graphql.RichDocumentGraphQlInterfaces.FBPage;
import com.facebook.richdocument.model.graphql.RichDocumentGraphQlInterfaces.RichDocumentMaster;
import com.facebook.richdocument.model.graphql.RichDocumentGraphQlModels.FBMessengerSubscriptionInfoModel.MessengerContentSubscriptionOptionModel;
import com.facebook.springs.SimpleSpringListener;
import com.facebook.springs.Spring;
import com.facebook.springs.SpringConfig;
import com.facebook.springs.SpringSystem;
import com.facebook.user.model.Name;
import com.facebook.user.model.User;
import com.facebook.user.model.User.Type;
import com.facebook.user.model.UserBuilder;
import com.facebook.user.tiles.UserTileViewLogic;
import com.facebook.widget.tiles.TileBadge;
import com.google.common.collect.ImmutableList;
import java.nio.ByteBuffer;
import javax.inject.Inject;

/* compiled from: trackContentId */
public class BusinessIASubscriptionBannerPresenter extends AbstractBusinessSubscriptionBannerUtil {
    private static final SpringConfig f1469d = SpringConfig.a(150.0d, 12.0d);
    private SpringSystem f1470e;
    private Spring f1471f;
    public UserTileViewLogic f1472g;
    private GQLUserConverter f1473h;
    public User f1474i;
    public String f1475j;
    public BusinessSubscriptionAnalyticsLogger f1476k;
    public BusinessIASubscriptionLoader f1477l;
    public QeAccessor f1478m;

    /* compiled from: trackContentId */
    public class C01511 {
        public final /* synthetic */ RichDocumentMaster f1465a;
        public final /* synthetic */ BusinessIASubscriptionBannerPresenter f1466b;

        public C01511(BusinessIASubscriptionBannerPresenter businessIASubscriptionBannerPresenter, RichDocumentMaster richDocumentMaster) {
            this.f1466b = businessIASubscriptionBannerPresenter;
            this.f1465a = richDocumentMaster;
        }
    }

    /* compiled from: trackContentId */
    public class C01522 {
        public final /* synthetic */ BusinessIASubscriptionBannerPresenter f1467a;

        C01522(BusinessIASubscriptionBannerPresenter businessIASubscriptionBannerPresenter) {
            this.f1467a = businessIASubscriptionBannerPresenter;
        }
    }

    /* compiled from: trackContentId */
    class SubscribeBannerSpringListener extends SimpleSpringListener {
        final /* synthetic */ BusinessIASubscriptionBannerPresenter f1468a;

        public SubscribeBannerSpringListener(BusinessIASubscriptionBannerPresenter businessIASubscriptionBannerPresenter) {
            this.f1468a = businessIASubscriptionBannerPresenter;
        }

        public final void m1665a(Spring spring) {
            this.f1468a.c.setTranslationY((float) spring.d());
        }

        public final void m1667c(Spring spring) {
            this.f1468a.c.setVisibility(0);
        }

        public final void m1666b(Spring spring) {
            this.f1468a.c.setVisibility(this.f1468a.a ? 0 : 8);
            if (this.f1468a.a) {
                this.f1468a.f1476k.m1592a("instant_article", this.f1468a.f1474i.a, this.f1468a.f1475j);
            }
            if (!this.f1468a.b) {
                this.f1468a.b();
            }
        }
    }

    @Inject
    public BusinessIASubscriptionBannerPresenter(SpringSystem springSystem, UserTileViewLogic userTileViewLogic, GQLUserConverter gQLUserConverter, BusinessSubscriptionAnalyticsLogger businessSubscriptionAnalyticsLogger, BusinessIASubscriptionLoader businessIASubscriptionLoader, QeAccessor qeAccessor, @Assisted BusinessIASubscribeBannerView businessIASubscribeBannerView) {
        this.c = businessIASubscribeBannerView;
        this.f1470e = springSystem;
        this.f1472g = userTileViewLogic;
        this.f1473h = gQLUserConverter;
        this.f1476k = businessSubscriptionAnalyticsLogger;
        this.f1477l = businessIASubscriptionLoader;
        this.f1478m = qeAccessor;
    }

    public final void m1670a() {
        super.a();
        this.f1476k.m1592a("instant_article", this.f1474i.a, this.f1475j);
        Spring a = this.f1470e.a().a(f1469d);
        a.c = true;
        this.f1471f = a.l().a(new SubscribeBannerSpringListener(this));
    }

    protected final void m1671a(boolean z) {
        int height = this.c.getHeight();
        if (z) {
            this.f1471f.a((double) height).b(0.0d);
        } else {
            this.f1471f.a(0.0d).b((double) height);
        }
    }

    public static void m1669b(BusinessIASubscriptionBannerPresenter businessIASubscriptionBannerPresenter, RichDocumentMaster richDocumentMaster) {
        MessengerContentSubscriptionOptionModel d = richDocumentMaster.mo363d();
        businessIASubscriptionBannerPresenter.f1474i = businessIASubscriptionBannerPresenter.m1668a(richDocumentMaster.mo364g().mo351k());
        businessIASubscriptionBannerPresenter.f1475j = richDocumentMaster.mo362c();
        BusinessIASubscribeBannerView businessIASubscribeBannerView = (BusinessIASubscribeBannerView) businessIASubscriptionBannerPresenter.c;
        String b = d.m5645b();
        String a = d.m5644a();
        User user = businessIASubscriptionBannerPresenter.f1474i;
        Builder builder = new Builder();
        builder.f1536a = businessIASubscriptionBannerPresenter.f1472g;
        builder = builder;
        builder.f1537b = user.T.c();
        builder = builder;
        builder.f1541f = TileBadge.MESSENGER;
        builder = builder;
        builder.f1540e = ImmutableList.of(user.T);
        builder = builder;
        builder.f1543h = user.k();
        businessIASubscribeBannerView.m1676a(b, a, builder.m1713a(), businessIASubscriptionBannerPresenter.f1474i.a, "instant_article", new C01522(businessIASubscriptionBannerPresenter));
        businessIASubscriptionBannerPresenter.a();
    }

    private User m1668a(FBPage fBPage) {
        UserBuilder a = new UserBuilder().a(Type.FACEBOOK, fBPage.mo312d());
        a.g = new Name(fBPage.hR_());
        a = a;
        ProfilePhotoInfoModel.Builder builder = new ProfilePhotoInfoModel.Builder();
        builder.a = fBPage.mo313g().a();
        builder = builder;
        builder.b = fBPage.mo313g().d();
        builder = builder;
        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
        int b = flatBufferBuilder.b(builder.b);
        flatBufferBuilder.c(2);
        flatBufferBuilder.a(0, builder.a, 0);
        flatBufferBuilder.b(1, b);
        flatBufferBuilder.d(flatBufferBuilder.d());
        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
        wrap.position(0);
        a.p = GQLUserConverter.a(new ProfilePhotoInfoModel(new MutableFlatBuffer(wrap, null, null, true, null)), null, null);
        a = a;
        a.z = "page";
        a = a;
        a.A = true;
        return a.aa();
    }
}
