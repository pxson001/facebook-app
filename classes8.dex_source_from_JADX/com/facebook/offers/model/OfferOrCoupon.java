package com.facebook.offers.model;

import android.net.Uri;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.offers.graphql.OfferQueriesInterfaces.OfferClaimData;
import com.facebook.offers.graphql.OfferQueriesInterfaces.PhotoData;
import com.facebook.offers.graphql.OfferQueriesInterfaces.VideoData;
import com.facebook.offers.graphql.OfferQueriesModels.CouponDataModel;
import com.facebook.offers.graphql.OfferQueriesModels.ImageDataModel;
import com.facebook.offers.graphql.OfferQueriesModels.OfferDataModel;
import com.facebook.offers.graphql.OfferQueriesModels.OfferOwnerModel;
import com.facebook.offers.graphql.OfferQueriesModels.OfferViewDataModel;
import com.facebook.offers.graphql.OfferQueriesModels.PhotoDataModel;
import com.facebook.offers.graphql.OfferQueriesModels.VideoDataModel;
import com.facebook.offers.graphql.OfferQueriesModels.VideoDataModel.VideoThumbnailsModel.NodesModel;
import com.facebook.video.analytics.VideoAnalytics.StreamSourceType;
import com.facebook.video.engine.VideoDataSource;
import com.facebook.video.engine.VideoDataSourceBuilder;
import com.facebook.video.engine.VideoPlayerParams;
import com.facebook.video.engine.VideoPlayerParamsBuilder;
import com.facebook.video.player.RichVideoPlayerParams;
import com.facebook.video.player.RichVideoPlayerParams.Builder;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.annotation.Nullable;

/* compiled from: current_fragment_id */
public class OfferOrCoupon {
    @Nullable
    public final OfferClaimData f16522a;
    @Nullable
    public final CouponDataModel f16523b;
    @Nullable
    private List<RichVideoPlayerParams> f16524c;

    public OfferOrCoupon(@Nullable OfferClaimData offerClaimData, @Nullable CouponDataModel couponDataModel) {
        this.f16522a = offerClaimData;
        this.f16523b = couponDataModel;
    }

    public final ImageDataModel m19451a() {
        if (!m19467r()) {
            return this.f16523b.m19145u().m19120j();
        }
        if (m19468s()) {
            ImmutableList d = this.f16522a.mo1011z().m19291d();
            if (!(d == null || d.isEmpty())) {
                return ((PhotoDataModel) d.get(0)).m19350a();
            }
        }
        return this.f16522a.mo1006u();
    }

    public final List<? extends PhotoData> m19453b() {
        if (m19467r() && m19468s()) {
            return this.f16522a.mo1011z().m19291d();
        }
        return Collections.emptyList();
    }

    public final int m19454c() {
        if (m19467r() && m19468s()) {
            ImmutableList d = this.f16522a.mo1011z().m19291d();
            if (d != null) {
                return d.size();
            }
        }
        return 1;
    }

    private List<? extends VideoData> m19449w() {
        if (m19467r() && m19468s()) {
            return this.f16522a.mo1011z().jS_();
        }
        return Collections.emptyList();
    }

    public final int m19455d() {
        if (m19467r() && m19468s()) {
            ImmutableList jS_ = this.f16522a.mo1011z().jS_();
            if (jS_ != null) {
                return jS_.size();
            }
        }
        return 0;
    }

    public final OfferOwnerModel m19456e() {
        if (m19467r()) {
            return m19469t().m19192l();
        }
        return this.f16523b.m19144t();
    }

    public final String m19457f() {
        if (m19467r()) {
            return m19469t().m19191k();
        }
        return this.f16523b.m19143s().m19113a();
    }

    public final String m19458g() {
        if (m19467r()) {
            return m19469t().jO_();
        }
        return this.f16523b.mo994l();
    }

    public final long m19459h() {
        if (m19467r()) {
            return m19469t().jP_();
        }
        return this.f16523b.mo986c();
    }

    public final String m19460i() {
        if (m19467r()) {
            return m19469t().m19189g();
        }
        return this.f16523b.mo998p();
    }

    public final String m19461j() {
        if (m19468s()) {
            return this.f16522a.mo1010y();
        }
        if (m19467r()) {
            return m19469t().m19190j();
        }
        return this.f16523b.mo997o();
    }

    public final String m19462k() {
        if (m19467r()) {
            return this.f16522a.mo1003g();
        }
        return this.f16523b.mo988g();
    }

    public final int m19463m() {
        if (m19467r()) {
            return m19469t().m19186b();
        }
        return this.f16523b.mo987d();
    }

    public final boolean m19464n() {
        if (m19467r()) {
            return this.f16522a.mo1007v();
        }
        return false;
    }

    public final boolean m19465o() {
        if (m19467r()) {
            return this.f16522a.mo1008w();
        }
        return false;
    }

    @Nullable
    public final OfferClaimData m19466q() {
        return this.f16522a;
    }

    public final boolean m19467r() {
        return this.f16522a != null;
    }

    public final boolean m19468s() {
        return (this.f16522a == null || this.f16522a.mo1011z() == null) ? false : true;
    }

    public final OfferDataModel m19469t() {
        if (m19468s()) {
            return this.f16522a.mo1011z().m19290c();
        }
        if (m19467r()) {
            return this.f16522a.mo1009x();
        }
        return null;
    }

    @Nullable
    public final OfferViewDataModel m19470u() {
        if (this.f16522a == null) {
            return null;
        }
        return this.f16522a.mo1011z();
    }

    public final boolean m19471v() {
        return this.f16523b != null;
    }

    public static OfferOrCoupon m19448a(OfferClaimData offerClaimData) {
        return new OfferOrCoupon(offerClaimData, null);
    }

    private synchronized List<RichVideoPlayerParams> m19450x() {
        if (this.f16524c == null) {
            this.f16524c = new ArrayList();
        }
        return this.f16524c;
    }

    public final synchronized RichVideoPlayerParams m19452a(int i, boolean z) {
        RichVideoPlayerParams b;
        Uri uri = null;
        synchronized (this) {
            if (i >= m19450x().size()) {
                VideoDataModel videoDataModel = (VideoDataModel) m19449w().get(i);
                String jU_ = videoDataModel.jU_();
                VideoDataSourceBuilder a = VideoDataSource.newBuilder().a(StreamSourceType.FROM_STREAM).a(Uri.parse(videoDataModel.m19387m()));
                if (jU_ != null) {
                    uri = Uri.parse(jU_);
                }
                VideoPlayerParamsBuilder e = VideoPlayerParams.newBuilder().a(a.b(uri).i()).a(videoDataModel.m19384j()).a(videoDataModel.m19386l()).a(false).c(false).a(videoDataModel.m19381c(), videoDataModel.m19383g()).b(videoDataModel.m19380b()).b(videoDataModel.m19385k()).e(z);
                Builder builder = new Builder();
                builder.a(e.m());
                if (!(videoDataModel.m19390p() == null || videoDataModel.m19390p().m19372a() == null || videoDataModel.m19390p().m19372a().size() <= 0)) {
                    builder.a("CoverImageParamsKey", ImageRequest.a(((NodesModel) videoDataModel.m19390p().m19372a().get(0)).m19367a().m19151a()));
                }
                builder.a("IsAutoplayKey", Boolean.valueOf(true));
                builder.a("GraphQLStoryProps", FeedProps.c(null));
                b = builder.b();
                this.f16524c.add(i, b);
            } else {
                b = (RichVideoPlayerParams) this.f16524c.get(i);
            }
        }
        return b;
    }
}
