package com.facebook.feed.awesomizer.ui;

import android.content.res.Resources;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.timeformat.DefaultTimeFormatUtil;
import com.facebook.common.timeformat.TimeFormatUtil;
import com.facebook.common.timeformat.TimeFormatUtil.TimeFormatStyle;
import com.facebook.common.uri.UriIntentMapper;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.feed.awesomizer.data.FeedAwesomizerGraphQLModels.FeedAwesomizerUnfollowingQueryModel.UnfollowedProfilesModel;
import com.facebook.feed.awesomizer.data.FeedAwesomizerGraphQLModels.FeedAwesomizerUnfollowingQueryModel.UnfollowedProfilesModel.EdgesModel;
import com.facebook.feed.awesomizer.ui.AwesomizerFragment.AwesomizerCards;
import com.facebook.feed.awesomizer.ui.BaseAwesomizerAdapter.ViewHolderItem;
import com.facebook.graphql.enums.GraphQLSubscribeStatus;
import com.facebook.inject.InjectorLike;
import com.facebook.katana.urimap.Fb4aUriIntentMapper;
import com.google.common.util.concurrent.FutureCallback;
import javax.inject.Inject;

/* compiled from: group_user_invite_decline */
public class RefollowAdapter extends BaseAwesomizerAdapter<UnfollowedProfilesModel> {
    private static final CallerContext f11854d = CallerContext.a(RefollowAdapter.class, "feed_awesomizer");
    private final AwesomizerNetworkQueryHelper f11855e;
    public final TimeFormatUtil f11856f;

    public static RefollowAdapter m13951b(InjectorLike injectorLike) {
        return new RefollowAdapter(AwesomizerNetworkQueryHelper.m13867b(injectorLike), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike), (SecureContextHelper) DefaultSecureContextHelper.a(injectorLike), (TimeFormatUtil) DefaultTimeFormatUtil.a(injectorLike), (UriIntentMapper) Fb4aUriIntentMapper.a(injectorLike));
    }

    @Inject
    public RefollowAdapter(AwesomizerNetworkQueryHelper awesomizerNetworkQueryHelper, AbstractFbErrorReporter abstractFbErrorReporter, SecureContextHelper secureContextHelper, TimeFormatUtil timeFormatUtil, UriIntentMapper uriIntentMapper) {
        super(abstractFbErrorReporter, secureContextHelper, uriIntentMapper);
        this.f11855e = awesomizerNetworkQueryHelper;
        this.f11856f = timeFormatUtil;
    }

    public final void m13953a(ViewHolder viewHolder, int i) {
        if (viewHolder instanceof ViewHolderItem) {
            m13950a(m13952h(i), ((ViewHolderItem) viewHolder).f11795l);
        }
    }

    protected final ViewHolderItem mo805c(ViewGroup viewGroup) {
        return new ViewHolderItem(this, LayoutInflater.from(viewGroup.getContext()).inflate(2130903336, viewGroup, false));
    }

    private void m13950a(Object obj, View view) {
        String a;
        EdgesModel edgesModel = (EdgesModel) obj;
        AwesomizerGridItemView awesomizerGridItemView = (AwesomizerGridItemView) view;
        Resources resources = view.getContext().getResources();
        long j = edgesModel.m13756j();
        if (edgesModel.m13753a().m13541o() == GraphQLSubscribeStatus.CAN_SUBSCRIBE) {
            a = this.f11856f.a(TimeFormatStyle.FUZZY_RELATIVE_DATE_STYLE, j * 1000);
        } else {
            a = resources.getString(2131236156);
        }
        awesomizerGridItemView.setAvatarContextViewText(a);
        awesomizerGridItemView.m13852a(edgesModel.m13753a().m13541o() != GraphQLSubscribeStatus.CAN_SUBSCRIBE);
        AwesomizerProfileViewBinder.m13877a(awesomizerGridItemView, edgesModel.m13753a().m13540n(), AwesomizerAvatarUtil.m13831a(edgesModel.m13753a()), edgesModel.m13753a().m13536j().g(), f11854d);
    }

    protected final String mo807g() {
        return AwesomizerCards.REFOLLOW.getName();
    }

    private EdgesModel m13952h(int i) {
        return (this.f11803g == null || i >= aZ_() || i <= 0) ? null : (EdgesModel) ((UnfollowedProfilesModel) this.f11803g).m13769j().get(i - 1);
    }

    public final void mo802a(View view, int i) {
        final UnfollowedProfilesModel unfollowedProfilesModel = (UnfollowedProfilesModel) this.f11803g;
        unfollowedProfilesModel = this.f11855e.m13873a(unfollowedProfilesModel, m13952h(i), new FutureCallback<Void>(this) {
            final /* synthetic */ RefollowAdapter f11853b;

            public /* bridge */ /* synthetic */ void onSuccess(Object obj) {
            }

            public void onFailure(Throwable th) {
                this.f11853b.m13882a(unfollowedProfilesModel, unfollowedProfilesModel.m13770k().m13763j(), unfollowedProfilesModel.m13765a());
            }
        });
        m13882a(unfollowedProfilesModel, unfollowedProfilesModel.m13770k().m13763j(), unfollowedProfilesModel.m13765a());
        this.f11798a.m13943a(i, m13952h(i).m13753a().m13541o() == GraphQLSubscribeStatus.IS_SUBSCRIBED);
    }

    public final int aZ_() {
        return this.f11803g != null ? ((UnfollowedProfilesModel) this.f11803g).m13769j().size() + 1 : 1;
    }
}
