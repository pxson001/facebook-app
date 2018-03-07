package com.facebook.feed.awesomizer.ui;

import android.content.res.Resources;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.uri.UriIntentMapper;
import com.facebook.content.SecureContextHelper;
import com.facebook.feed.awesomizer.data.FeedAwesomizerGraphQLModels.FeedAwesomizerSeefirstCardQueryModel.FollowedProfilesModel;
import com.facebook.feed.awesomizer.data.FeedAwesomizerGraphQLModels.FeedAwesomizerSeefirstCardQueryModel.FollowedProfilesModel.EdgesModel;
import com.facebook.feed.awesomizer.ui.AwesomizerFragment.AwesomizerCards;
import com.facebook.feed.awesomizer.ui.BaseAwesomizerAdapter.ViewHolderItem;
import com.facebook.graphql.enums.GraphQLSecondarySubscribeStatus;
import com.facebook.http.protocol.ApiException;
import com.facebook.ui.errordialog.ErrorDialogParams;
import com.facebook.ui.errordialog.ErrorDialogParamsBuilder;
import com.facebook.ui.errordialog.ErrorDialogs;
import com.google.common.util.concurrent.FutureCallback;
import javax.inject.Inject;

/* compiled from: group_unpin_story */
public class SeefirstAdapter extends BaseAwesomizerAdapter<FollowedProfilesModel> {
    private static final CallerContext f11861d = CallerContext.a(SeefirstAdapter.class, "feed_awesomizer");
    private final AwesomizerNetworkQueryHelper f11862e;
    public final ErrorDialogs f11863f;

    @Inject
    public SeefirstAdapter(AwesomizerNetworkQueryHelper awesomizerNetworkQueryHelper, ErrorDialogs errorDialogs, AbstractFbErrorReporter abstractFbErrorReporter, SecureContextHelper secureContextHelper, UriIntentMapper uriIntentMapper) {
        super(abstractFbErrorReporter, secureContextHelper, uriIntentMapper);
        this.f11863f = errorDialogs;
        this.f11862e = awesomizerNetworkQueryHelper;
    }

    public final void m13965a(ViewHolder viewHolder, int i) {
        if (viewHolder instanceof ViewHolderItem) {
            m13964a(m13969h(i), ((ViewHolderItem) viewHolder).f11795l);
        }
    }

    private static void m13964a(Object obj, View view) {
        EdgesModel edgesModel = (EdgesModel) obj;
        AwesomizerGridItemView awesomizerGridItemView = (AwesomizerGridItemView) view;
        awesomizerGridItemView.f11754g = true;
        AwesomizerProfileViewBinder.m13877a(awesomizerGridItemView, edgesModel.m13724a().m13713n(), edgesModel.m13724a().m13711l().m13691a(), edgesModel.m13724a().m13709j().g(), f11861d);
        if (edgesModel.m13724a().m13714o() == GraphQLSecondarySubscribeStatus.SEE_FIRST) {
            awesomizerGridItemView.setAvatarContextViewVisibility(0);
            awesomizerGridItemView.setAvatarContextViewText(view.getContext().getResources().getString(2131236157));
            awesomizerGridItemView.m13852a(true);
            return;
        }
        awesomizerGridItemView.setAvatarContextViewVisibility(4);
        awesomizerGridItemView.m13852a(false);
    }

    protected final String mo807g() {
        return AwesomizerCards.SEEFIRST.getName();
    }

    protected final ViewHolderItem mo805c(ViewGroup viewGroup) {
        return new ViewHolderItem(this, LayoutInflater.from(viewGroup.getContext()).inflate(2130903336, viewGroup, false));
    }

    public final void mo802a(final View view, final int i) {
        final FollowedProfilesModel followedProfilesModel = (FollowedProfilesModel) this.f11803g;
        followedProfilesModel = this.f11862e.m13872a(followedProfilesModel, m13969h(i), new FutureCallback<Void>(this) {
            final /* synthetic */ SeefirstAdapter f11860d;

            public /* bridge */ /* synthetic */ void onSuccess(Object obj) {
            }

            public void onFailure(Throwable th) {
                if ((th instanceof ApiException) && ((ApiException) th).b().a() == 1529005) {
                    SeefirstAdapter seefirstAdapter = this.f11860d;
                    String n = this.f11860d.m13969h(i).m13724a().m13713n();
                    Resources resources = view.getResources();
                    ErrorDialogs errorDialogs = seefirstAdapter.f11863f;
                    ErrorDialogParamsBuilder a = ErrorDialogParams.a(resources).a(2131236162);
                    a.c = resources.getString(2131236163, new Object[]{n});
                    errorDialogs.a(a.l());
                }
                this.f11860d.m13882a(followedProfilesModel, followedProfilesModel.m13739k().m13732j(), followedProfilesModel.m13734a());
            }
        });
        m13882a(followedProfilesModel, followedProfilesModel.m13739k().m13732j(), followedProfilesModel.m13734a());
        this.f11798a.m13943a(i, m13969h(i).m13724a().m13714o() == GraphQLSecondarySubscribeStatus.SEE_FIRST);
    }

    public final int aZ_() {
        return this.f11803g != null ? ((FollowedProfilesModel) this.f11803g).m13738j().size() + 1 : 1;
    }

    public final EdgesModel m13969h(int i) {
        return (this.f11803g == null || i >= aZ_() || i <= 0) ? null : (EdgesModel) ((FollowedProfilesModel) this.f11803g).m13738j().get(i - 1);
    }
}
