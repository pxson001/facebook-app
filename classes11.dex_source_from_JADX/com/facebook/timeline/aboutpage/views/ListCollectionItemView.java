package com.facebook.timeline.aboutpage.views;

import android.content.Context;
import android.graphics.drawable.StateListDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.facebook.analytics.CurationSurface;
import com.facebook.api.graphql.saved.SaveDefaultsGraphQLInterfaces.SavableTimelineAppCollection;
import com.facebook.attachments.angora.CollectionUpdateRequestListener;
import com.facebook.attachments.angora.CollectionUpdateResultListener;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.executors.ForUiThread;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.common.fblinks.FBLinks;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.fbservice.ops.BlueServiceOperationFactory.OperationFuture;
import com.facebook.fbservice.ops.DefaultBlueServiceOperationFactory;
import com.facebook.fbservice.ops.OperationResultFutureCallback;
import com.facebook.fbservice.service.ServiceException;
import com.facebook.friends.FriendingClient;
import com.facebook.graphql.enums.GraphQLTimelineAppSectionType;
import com.facebook.graphql.linkutil.GraphQLLinkExtractor;
import com.facebook.groups.mutations.GroupsClient;
import com.facebook.inject.FbInjector;
import com.facebook.intent.feed.DefaultFeedIntentBuilder;
import com.facebook.intent.feed.IFeedIntentBuilder;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.profile.api.ProfileViewerContext;
import com.facebook.story.UpdateTimelineAppCollectionParams;
import com.facebook.story.UpdateTimelineAppCollectionParams.Action;
import com.facebook.story.UpdateTimelineAppCollectionParams.Builder;
import com.facebook.timeline.aboutpage.views.ListCollectionItemData.RequestStatus;
import com.facebook.timeline.intent.ModelBundle;
import com.facebook.tools.dextr.runtime.detour.BlueServiceOperationFactoryDetour;
import com.facebook.widget.CustomRelativeLayout;
import com.facebook.widget.touch.TouchDelegateUtils;
import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.List;
import java.util.concurrent.Executor;
import javax.inject.Inject;

/* compiled from: Ljava/util/ArrayDeque */
public class ListCollectionItemView extends CustomRelativeLayout implements CollectionUpdateRequestListener, CollectionButtonStatusListener {
    private static final CallerContext f13854h = CallerContext.a(ListCollectionItemView.class, "collections_collection", "thumbnail");
    @Inject
    FriendingClient f13855a;
    @Inject
    GroupsClient f13856b;
    @Inject
    AbstractFbErrorReporter f13857c;
    @Inject
    GraphQLLinkExtractor f13858d;
    @Inject
    IFeedIntentBuilder f13859e;
    @Inject
    @ForUiThread
    Executor f13860f;
    @Inject
    DefaultBlueServiceOperationFactory f13861g;
    public ListCollectionItemData f13862i;
    private ProfileViewerContext f13863j;
    public TextView f13864k;
    public TextView f13865l;
    public FbDraweeView f13866m;
    public FrameLayout f13867n;
    public IconFacepileView f13868o;
    public UpdateTimelineCollectionConfirmationView f13869p;
    public CollectionFriendingButton f13870q;
    public CollectionSubscribeButton f13871r;
    public CollectionGroupJoinButton f13872s;
    public TimelineCollectionPlusButtonView f13873t;
    public FrameLayout f13874u;
    public String f13875v;
    private final OnClickListener f13876w = new C16121(this);

    /* compiled from: Ljava/util/ArrayDeque */
    class C16121 implements OnClickListener {
        final /* synthetic */ ListCollectionItemView f13850a;

        C16121(ListCollectionItemView listCollectionItemView) {
            this.f13850a = listCollectionItemView;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -1480134061);
            if (!(this.f13850a.f13862i.f13843g != GraphQLTimelineAppSectionType.FRIENDS || this.f13850a.f13862i.f13840d == null || this.f13850a.f13862i.f13838b == null)) {
                ModelBundle.a(new Bundle(), null, this.f13850a.f13862i.f13840d.b(), this.f13850a.f13862i.f13838b.a());
            }
            this.f13850a.f13859e.a(this.f13850a.getContext(), this.f13850a.f13875v, null, null);
            Logger.a(2, EntryType.UI_INPUT_END, -432068063, a);
        }
    }

    public static void m15005a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((ListCollectionItemView) obj).m15004a(FriendingClient.b(fbInjector), GroupsClient.b(fbInjector), (AbstractFbErrorReporter) FbErrorReporterImpl.a(fbInjector), GraphQLLinkExtractor.a(fbInjector), (IFeedIntentBuilder) DefaultFeedIntentBuilder.a(fbInjector), (Executor) ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.a(fbInjector), DefaultBlueServiceOperationFactory.b(fbInjector));
    }

    public ListCollectionItemView(Context context) {
        super(context);
        Class cls = ListCollectionItemView.class;
        m15005a((Object) this, getContext());
        setContentView(2130903592);
        this.f13864k = (TextView) a(2131560373);
        this.f13865l = (TextView) a(2131560374);
        this.f13866m = (FbDraweeView) a(2131560366);
        this.f13867n = (FrameLayout) a(2131560365);
        this.f13869p = (UpdateTimelineCollectionConfirmationView) a(2131560375);
        this.f13870q = (CollectionFriendingButton) a(2131560369);
        this.f13871r = (CollectionSubscribeButton) a(2131560370);
        this.f13872s = (CollectionGroupJoinButton) a(2131560371);
        this.f13873t = (TimelineCollectionPlusButtonView) a(2131560368);
        this.f13874u = (FrameLayout) a(2131560367);
        this.f13875v = null;
    }

    public final void m15010a(ListCollectionItemData listCollectionItemData, ProfileViewerContext profileViewerContext) {
        CharSequence charSequence;
        this.f13862i = listCollectionItemData;
        this.f13863j = profileViewerContext;
        m15002a(this.f13864k, listCollectionItemData.f13838b == null ? null : listCollectionItemData.f13838b.a());
        TextView textView = this.f13865l;
        if (listCollectionItemData.f13839c == null) {
            charSequence = null;
        } else {
            charSequence = listCollectionItemData.f13839c.a();
        }
        m15002a(textView, charSequence);
        if (listCollectionItemData.f13843g == GraphQLTimelineAppSectionType.GROUPS) {
            if (this.f13868o == null) {
                int dimensionPixelSize = getResources().getDimensionPixelSize(2131429886);
                this.f13868o = (IconFacepileView) LayoutInflater.from(getContext()).inflate(2130903590, null);
                this.f13867n.addView(this.f13868o, new LayoutParams(dimensionPixelSize, dimensionPixelSize));
                this.f13868o = this.f13868o;
            }
            List list = null;
            if (!(listCollectionItemData == null || listCollectionItemData.f13844h == null || listCollectionItemData.f13844h.f13153d == null || listCollectionItemData.f13844h.f13153d.m14417a() == null)) {
                list = listCollectionItemData.f13844h.f13153d.m14417a();
            }
            this.f13868o.m14991b(list);
            this.f13867n.setForeground(null);
            this.f13866m.setVisibility(8);
            this.f13868o.setVisibility(0);
        } else {
            if (this.f13866m != null) {
                if (listCollectionItemData.f13840d != null) {
                    this.f13866m.a(Uri.parse(listCollectionItemData.f13840d.b()), f13854h);
                } else {
                    this.f13866m.a(null, f13854h);
                }
            }
            this.f13866m.setVisibility(0);
            this.f13867n.setForeground(getResources().getDrawable(2130838103));
            this.f13867n.setVisibility(0);
            if (this.f13868o != null) {
                this.f13868o.setVisibility(8);
            }
        }
        setupButton(listCollectionItemData);
        RequestStatus requestStatus = listCollectionItemData.f13848l;
        Action action = listCollectionItemData.f13847k;
        if (requestStatus.equals(RequestStatus.REQUEST_FAILED)) {
            this.f13869p.m15076a(action);
            this.f13869p.setVisibility(0);
        } else if (listCollectionItemData.f13844h == null || !listCollectionItemData.f13844h.m13937c()) {
            r0 = (requestStatus.equals(RequestStatus.REQUEST_NONE) && action == null) || (requestStatus.equals(RequestStatus.REQUEST_PENDING) && action.equals(Action.REMOVE));
            Preconditions.checkState(r0);
            this.f13869p.setVisibility(8);
        } else {
            r0 = (requestStatus.equals(RequestStatus.REQUEST_NONE) && action == null) || (requestStatus.equals(RequestStatus.REQUEST_PENDING) && action.equals(Action.ADD));
            Preconditions.checkState(r0);
            this.f13869p.m15075a(listCollectionItemData.f13844h.m13936b(), Action.ADD);
            this.f13869p.setVisibility(0);
        }
        if (requestStatus.equals(RequestStatus.REQUEST_PENDING)) {
            this.f13873t.setEnabled(false);
        } else {
            this.f13873t.setEnabled(true);
        }
        this.f13875v = getItemUri();
        if (this.f13875v != null) {
            setOnClickListener(this.f13876w);
            m15006c();
            return;
        }
        setOnClickListener(null);
        m15007d();
    }

    private void m15006c() {
        int i = (this.f13862i.f13844h == null || !this.f13862i.f13844h.m13937c()) ? this.f13862i.f13845i ? 2130838107 : 2130838106 : 2130838105;
        setBackgroundResource(i);
    }

    private void m15007d() {
        ListCollectionItemData listCollectionItemData = this.f13862i;
        int i = (listCollectionItemData.f13844h == null || !listCollectionItemData.f13844h.m13937c()) ? listCollectionItemData.f13845i ? 2131364000 : 2131361864 : 2131363999;
        setBackgroundColor(getResources().getColor(i));
    }

    private void m15008e() {
        if (getBackground() instanceof StateListDrawable) {
            m15006c();
        } else {
            m15007d();
        }
    }

    private String getItemUri() {
        if (this.f13862i.f13842f != null && this.f13862i.f13842f.g() == 80218325) {
            return StringFormatUtil.formatStrLocaleSafe(FBLinks.aS, this.f13862i.f13837a, null);
        }
        String a = this.f13858d.a(this.f13862i.f13842f, new Object[]{this.f13862i.f13837a, null});
        return a == null ? this.f13862i.f13841e : a;
    }

    private void m15004a(FriendingClient friendingClient, GroupsClient groupsClient, AbstractFbErrorReporter abstractFbErrorReporter, GraphQLLinkExtractor graphQLLinkExtractor, IFeedIntentBuilder iFeedIntentBuilder, Executor executor, DefaultBlueServiceOperationFactory defaultBlueServiceOperationFactory) {
        this.f13855a = friendingClient;
        this.f13856b = groupsClient;
        this.f13857c = abstractFbErrorReporter;
        this.f13858d = graphQLLinkExtractor;
        this.f13859e = iFeedIntentBuilder;
        this.f13860f = executor;
        this.f13861g = defaultBlueServiceOperationFactory;
    }

    private void setupButton(ListCollectionItemData listCollectionItemData) {
        if (listCollectionItemData.f13843g == GraphQLTimelineAppSectionType.FRIENDS && listCollectionItemData.f13844h != null) {
            this.f13870q.m14899a(this.f13863j, listCollectionItemData, this, this.f13855a, this.f13857c);
            this.f13872s.setVisibility(8);
            this.f13873t.setVisibility(8);
            this.f13871r.setVisibility(8);
        } else if ((listCollectionItemData.f13843g == GraphQLTimelineAppSectionType.SUBSCRIPTIONS || listCollectionItemData.f13843g == GraphQLTimelineAppSectionType.SUBSCRIBERS) && listCollectionItemData.f13844h != null) {
            this.f13871r.m14925a(this.f13863j, listCollectionItemData, this, this.f13855a, this.f13857c, this.f13860f);
            this.f13873t.setVisibility(8);
            this.f13870q.setVisibility(8);
            this.f13872s.setVisibility(8);
        } else if (listCollectionItemData.f13843g != GraphQLTimelineAppSectionType.GROUPS || listCollectionItemData.f13844h == null) {
            if (!this.f13863j.f() || listCollectionItemData.f13845i || listCollectionItemData.f13846j) {
                CurationSurface curationSurface;
                if (this.f13862i.f13845i) {
                    curationSurface = CurationSurface.NATIVE_SELF_ABOUT_RECOMMENDATIONS;
                } else {
                    curationSurface = CurationSurface.NATIVE_FRIEND_ABOUT_PAGE;
                }
                this.f13873t.m15072a(listCollectionItemData.f13844h, (CollectionUpdateRequestListener) this, curationSurface);
            } else {
                this.f13873t.setVisibility(8);
            }
            this.f13870q.setVisibility(8);
            this.f13872s.setVisibility(8);
            this.f13871r.setVisibility(8);
        } else {
            this.f13872s.m14913a(this.f13863j, listCollectionItemData, this, this.f13856b, this.f13857c);
            this.f13873t.setVisibility(8);
            this.f13870q.setVisibility(8);
            this.f13871r.setVisibility(8);
        }
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.f13870q.getVisibility() == 0) {
            this.f13874u.setTouchDelegate(TouchDelegateUtils.a(this.f13870q, getResources().getDimensionPixelSize(2131428983)));
        } else if (this.f13871r.getVisibility() == 0) {
            this.f13874u.setTouchDelegate(TouchDelegateUtils.a(this.f13871r, getResources().getDimensionPixelSize(2131428983)));
        } else if (this.f13872s.getVisibility() == 0) {
            this.f13874u.setTouchDelegate(TouchDelegateUtils.a(this.f13872s, getResources().getDimensionPixelSize(2131428983)));
        } else if (this.f13873t.getVisibility() == 0) {
            this.f13874u.setTouchDelegate(TouchDelegateUtils.a(this.f13873t, getResources().getDimensionPixelSize(2131428983)));
        } else {
            this.f13874u.setTouchDelegate(null);
        }
    }

    private static void m15002a(TextView textView, CharSequence charSequence) {
        if (textView == null) {
            return;
        }
        if (charSequence != null) {
            textView.setVisibility(0);
            textView.setText(charSequence);
            return;
        }
        textView.setVisibility(8);
    }

    public final void K_(int i) {
        Context context = getContext();
        if (this.f13865l != null && context != null) {
            m15002a(this.f13865l, context.getString(i));
        }
    }

    public final ListenableFuture<?> m15009a(CollectionUpdateResultListener collectionUpdateResultListener, SavableTimelineAppCollection savableTimelineAppCollection, UpdateTimelineAppCollectionParams updateTimelineAppCollectionParams) {
        m15003a(savableTimelineAppCollection, Action.ADD);
        Builder builder = new Builder(updateTimelineAppCollectionParams);
        builder.c = Action.ADD;
        ListenableFuture<?> a = m15001a(savableTimelineAppCollection, builder.a());
        m15008e();
        return a;
    }

    public final ListenableFuture<?> m15011b(CollectionUpdateResultListener collectionUpdateResultListener, SavableTimelineAppCollection savableTimelineAppCollection, UpdateTimelineAppCollectionParams updateTimelineAppCollectionParams) {
        m15003a(savableTimelineAppCollection, Action.REMOVE);
        Builder builder = new Builder(updateTimelineAppCollectionParams);
        builder.c = Action.REMOVE;
        ListenableFuture<?> a = m15001a(savableTimelineAppCollection, builder.a());
        m15008e();
        return a;
    }

    private ListenableFuture<?> m15001a(final SavableTimelineAppCollection savableTimelineAppCollection, final UpdateTimelineAppCollectionParams updateTimelineAppCollectionParams) {
        Bundle bundle = new Bundle();
        bundle.putParcelable("timelineAppCollectionParamsKey", updateTimelineAppCollectionParams);
        OperationFuture b = BlueServiceOperationFactoryDetour.a(this.f13861g, "update_timeline_app_collection_in_timeline", bundle, -1471285852).b();
        ListCollectionItemData listCollectionItemData = this.f13862i;
        listCollectionItemData.f13847k = updateTimelineAppCollectionParams.c;
        listCollectionItemData.f13848l = RequestStatus.REQUEST_PENDING;
        Futures.a(b, new OperationResultFutureCallback(this) {
            final /* synthetic */ ListCollectionItemView f13853c;

            protected final void m15000a(Object obj) {
                ListCollectionItemData listCollectionItemData = this.f13853c.f13862i;
                listCollectionItemData.f13847k = null;
                listCollectionItemData.f13848l = RequestStatus.REQUEST_NONE;
                this.f13853c.f13873t.m15070a();
            }

            protected final void m14999a(ServiceException serviceException) {
                this.f13853c.f13862i.f13848l = RequestStatus.REQUEST_FAILED;
                this.f13853c.f13873t.m15071a(savableTimelineAppCollection, updateTimelineAppCollectionParams.c);
                ListCollectionItemView listCollectionItemView = this.f13853c;
                listCollectionItemView.f13869p.m15076a(updateTimelineAppCollectionParams.c);
                this.f13853c.f13857c.a("ListCollectionItemView", "Failed to add item to Timeline Collection due to server exception.", serviceException);
            }
        });
        return b;
    }

    private void m15003a(SavableTimelineAppCollection savableTimelineAppCollection, Action action) {
        this.f13869p.m15075a(savableTimelineAppCollection, action);
        this.f13865l.setVisibility(8);
    }
}
