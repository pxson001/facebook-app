package com.facebook.groups.info;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import com.facebook.analytics.tagging.AnalyticsFragmentWithExtraData;
import com.facebook.base.fragment.FbFragment;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.common.shortcuts.InstallShortcutHelper;
import com.facebook.events.model.Event;
import com.facebook.events.model.EventRsvpMutation;
import com.facebook.flatbuffers.helpers.FlatBufferModelHelper;
import com.facebook.graphql.enums.GraphQLEventGuestStatus;
import com.facebook.graphql.enums.GraphQLEventWatchStatus;
import com.facebook.graphql.enums.GraphQLGroupPushSubscriptionLevel;
import com.facebook.graphql.enums.GraphQLGroupRequestToJoinSubscriptionLevel;
import com.facebook.graphql.enums.GraphQLGroupSubscriptionLevel;
import com.facebook.graphql.executor.GraphQLCachePolicy;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.groups.constants.GroupsConstants.GroupMallType;
import com.facebook.groups.create.coverphoto.GroupsCoverPhotoHandler;
import com.facebook.groups.events.GroupEventsController;
import com.facebook.groups.events.GroupEventsController.GroupEventsControllerListener;
import com.facebook.groups.feed.data.GroupsFeedHeaderFetcher;
import com.facebook.groups.feed.protocol.FetchGroupInformationGraphQLModels.FetchGroupInformationModel;
import com.facebook.groups.info.navigation.AbstractGroupInfoSecondaryActionDelegate;
import com.facebook.groups.info.navigation.DefaultGroupInfoSecondaryActionDelegate;
import com.facebook.groups.info.navigation.GroupInfoNavHandler;
import com.facebook.groups.info.protocol.FetchGroupInfoEventsModels.FetchGroupInfoEventsModel.GroupEventsModel;
import com.facebook.groups.info.protocol.FetchGroupInfoEventsModels.FetchGroupInfoEventsModel.GroupEventsModel.EdgesModel;
import com.facebook.groups.info.protocol.FetchGroupInfoPageDataModels.FetchGroupInfoPageDataModel;
import com.facebook.groups.info.protocol.FetchGroupInfoPageDataModels.FetchGroupInfoPageDataModel.Builder;
import com.facebook.groups.navigation.DefaultGroupsNavigationHandler;
import com.facebook.groups.navigation.GroupsNavigationHandler;
import com.facebook.groups.settings.AbstractGroupSubscriptionController;
import com.facebook.groups.settings.DefaultGroupSubscriptionController;
import com.facebook.groups.settings.GroupSubscriptionController;
import com.facebook.groups.settings.GroupSubscriptionController$GroupSubscriptionChangeListener;
import com.facebook.groups.widget.groupeventrow.GroupEventRsvpViewListener;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.ipc.editgallery.EditGalleryIpcBundle;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.tools.dextr.runtime.detour.AdapterDetour;
import com.facebook.ui.toaster.ToastBuilder;
import com.facebook.ui.toaster.Toaster;
import com.facebook.widget.listview.BetterListView;
import com.google.common.base.Objects;
import com.google.common.collect.ImmutableBiMap;
import com.google.common.collect.ImmutableList;
import com.google.common.util.concurrent.FutureCallback;
import java.util.Map;
import javax.inject.Inject;

/* compiled from: ThreadItemView.onMeasure */
public class GroupInfoFragment extends FbFragment implements AnalyticsFragmentWithExtraData {
    @Inject
    @GroupInfoNavHandler
    GroupsNavigationHandler f22702a;
    @Inject
    Lazy<GroupsCoverPhotoHandler> al;
    @Inject
    Lazy<Toaster> am;
    private final GroupSubscriptionController$GroupSubscriptionChangeListener an = new C32901(this);
    private final GroupEventRsvpViewListener ao = new C32912(this);
    private final GroupEventsControllerListener ap = new C32923(this);
    public FetchGroupInfoPageDataModel aq;
    private FetchGroupInformationModel ar;
    private String as;
    public GroupInfoAdapter at;
    private BetterListView au;
    private ProgressBar av;
    private int aw;
    @Inject
    AbstractGroupInfoSecondaryActionDelegate f22703b;
    @Inject
    GroupInfoDataFetcher f22704c;
    @Inject
    GroupInfoAdapterProvider f22705d;
    @Inject
    AbstractGroupSubscriptionController f22706e;
    @Inject
    InstallShortcutHelper f22707f;
    @Inject
    GroupEventsController f22708g;
    @Inject
    Resources f22709h;
    @Inject
    DefaultGroupLeaveActionResponder f22710i;

    /* compiled from: ThreadItemView.onMeasure */
    class C32901 implements GroupSubscriptionController$GroupSubscriptionChangeListener {
        final /* synthetic */ GroupInfoFragment f22698a;

        C32901(GroupInfoFragment groupInfoFragment) {
            this.f22698a = groupInfoFragment;
        }

        public final void mo992a(GraphQLGroupSubscriptionLevel graphQLGroupSubscriptionLevel) {
            GroupInfoFragment groupInfoFragment = this.f22698a;
            Builder a = Builder.m23727a(this.f22698a.aq);
            a.f22743K = graphQLGroupSubscriptionLevel;
            GroupInfoFragment.m23652a(groupInfoFragment, a.m23728a());
        }

        public final void mo990a(GraphQLGroupPushSubscriptionLevel graphQLGroupPushSubscriptionLevel) {
            GroupInfoFragment groupInfoFragment = this.f22698a;
            Builder a = Builder.m23727a(this.f22698a.aq);
            a.f22741I = graphQLGroupPushSubscriptionLevel;
            GroupInfoFragment.m23652a(groupInfoFragment, a.m23728a());
        }

        public final void mo991a(GraphQLGroupRequestToJoinSubscriptionLevel graphQLGroupRequestToJoinSubscriptionLevel) {
            GroupInfoFragment groupInfoFragment = this.f22698a;
            Builder a = Builder.m23727a(this.f22698a.aq);
            a.f22742J = graphQLGroupRequestToJoinSubscriptionLevel;
            GroupInfoFragment.m23652a(groupInfoFragment, a.m23728a());
        }
    }

    /* compiled from: ThreadItemView.onMeasure */
    class C32912 implements GroupEventRsvpViewListener {
        final /* synthetic */ GroupInfoFragment f22699a;

        C32912(GroupInfoFragment groupInfoFragment) {
            this.f22699a = groupInfoFragment;
        }

        public final void mo958a(Event event, GraphQLEventGuestStatus graphQLEventGuestStatus) {
            m23643a(event, graphQLEventGuestStatus, true);
        }

        public final void mo960b(Event event, GraphQLEventGuestStatus graphQLEventGuestStatus) {
            m23643a(event, graphQLEventGuestStatus, false);
        }

        public final void mo959a(Event event, GraphQLEventWatchStatus graphQLEventWatchStatus) {
            m23644a(event, graphQLEventWatchStatus, true);
        }

        public final void mo961b(Event event, GraphQLEventWatchStatus graphQLEventWatchStatus) {
            m23644a(event, graphQLEventWatchStatus, false);
        }

        private void m23643a(Event event, GraphQLEventGuestStatus graphQLEventGuestStatus, boolean z) {
            EventRsvpMutation a = EventRsvpMutation.a(event, graphQLEventGuestStatus);
            GroupInfoFragment.m23651a(this.f22699a, a, z);
            this.f22699a.f22708g.m22936a(a, graphQLEventGuestStatus);
        }

        private void m23644a(Event event, GraphQLEventWatchStatus graphQLEventWatchStatus, boolean z) {
            EventRsvpMutation a = EventRsvpMutation.a(event, graphQLEventWatchStatus);
            GroupInfoFragment.m23651a(this.f22699a, a, z);
            this.f22699a.f22708g.m22937a(a, graphQLEventWatchStatus);
        }

        public final void mo957a() {
            AdapterDetour.a(this.f22699a.at, 765523087);
        }
    }

    /* compiled from: ThreadItemView.onMeasure */
    class C32923 implements GroupEventsControllerListener {
        final /* synthetic */ GroupInfoFragment f22700a;

        C32923(GroupInfoFragment groupInfoFragment) {
            this.f22700a = groupInfoFragment;
        }

        public final void mo962a(EventRsvpMutation eventRsvpMutation) {
            GroupInfoFragment.m23651a(this.f22700a, eventRsvpMutation.c(), true);
        }
    }

    /* compiled from: ThreadItemView.onMeasure */
    class C32934 implements FutureCallback<GraphQLResult<FetchGroupInfoPageDataModel>> {
        final /* synthetic */ GroupInfoFragment f22701a;

        C32934(GroupInfoFragment groupInfoFragment) {
            this.f22701a = groupInfoFragment;
        }

        public void onSuccess(Object obj) {
            GraphQLResult graphQLResult = (GraphQLResult) obj;
            GroupInfoFragment.m23658h(this.f22701a, false);
            GroupInfoFragment.m23653a(this.f22701a, (FetchGroupInfoPageDataModel) graphQLResult.e, true);
        }

        public void onFailure(Throwable th) {
            GroupInfoFragment.m23658h(this.f22701a, false);
            ((Toaster) this.f22701a.am.get()).b(new ToastBuilder(2131237824));
            if (this.f22701a.aq == null) {
                GroupInfoFragment.m23653a(this.f22701a, null, true);
            }
        }
    }

    public static void m23655a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        ((GroupInfoFragment) obj).m23654a((GroupsNavigationHandler) DefaultGroupsNavigationHandler.a(injectorLike), DefaultGroupInfoSecondaryActionDelegate.m23685b(injectorLike), GroupInfoDataFetcher.m23635b(injectorLike), (GroupInfoAdapterProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(GroupInfoAdapterProvider.class), DefaultGroupSubscriptionController.m24424b(injectorLike), InstallShortcutHelper.b(injectorLike), GroupEventsController.m22935b(injectorLike), ResourcesMethodAutoProvider.a(injectorLike), DefaultGroupLeaveActionResponder.m23588b(injectorLike), IdBasedLazy.a(injectorLike, 6876), IdBasedLazy.a(injectorLike, 3588));
    }

    private void m23654a(GroupsNavigationHandler groupsNavigationHandler, AbstractGroupInfoSecondaryActionDelegate abstractGroupInfoSecondaryActionDelegate, GroupInfoDataFetcher groupInfoDataFetcher, GroupInfoAdapterProvider groupInfoAdapterProvider, GroupSubscriptionController groupSubscriptionController, InstallShortcutHelper installShortcutHelper, GroupEventsController groupEventsController, Resources resources, GroupLeaveActionResponder groupLeaveActionResponder, Lazy<GroupsCoverPhotoHandler> lazy, Lazy<Toaster> lazy2) {
        this.f22702a = groupsNavigationHandler;
        this.f22703b = abstractGroupInfoSecondaryActionDelegate;
        this.f22704c = groupInfoDataFetcher;
        this.f22705d = groupInfoAdapterProvider;
        this.f22706e = groupSubscriptionController;
        this.f22707f = installShortcutHelper;
        this.f22708g = groupEventsController;
        this.f22709h = resources;
        this.f22710i = groupLeaveActionResponder;
        this.al = lazy;
        this.am = lazy2;
    }

    public final void m23663c(Bundle bundle) {
        super.c(bundle);
        Class cls = GroupInfoFragment.class;
        m23655a((Object) this, getContext());
        this.as = (String) this.s.get("group_feed_id");
        this.aw = this.s.getInt("group_mall_type", GroupMallType.WITHOUT_TABS_LEGACY.ordinal());
        this.ar = (FetchGroupInformationModel) FlatBufferModelHelper.a(this.s, "group_feed_model");
        DefaultGroupLeaveActionResponder defaultGroupLeaveActionResponder = this.f22710i;
        if (this == null) {
            defaultGroupLeaveActionResponder.f22595c.b(DefaultGroupLeaveActionResponder.f22593a, "fragment passed is null");
        }
        if (defaultGroupLeaveActionResponder.f22594b != null) {
            defaultGroupLeaveActionResponder.f22595c.b(DefaultGroupLeaveActionResponder.f22593a, "fragment being reset. setupGroupLeaveActionResponder should be called only once");
        }
        defaultGroupLeaveActionResponder.f22594b = this;
    }

    public final View m23659a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 716622201);
        View inflate = layoutInflater.inflate(2130904665, viewGroup, false);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 1952342988, a);
        return inflate;
    }

    public final void m23661a(View view, Bundle bundle) {
        super.a(view, bundle);
        this.f22708g.f21837f = this.ap;
        this.au = (BetterListView) e(2131559373);
        this.av = (ProgressBar) e(2131559418);
        this.f22706e.f23122h = this.an;
        this.f22703b.m23681a(this.aq, getContext());
        this.f22702a.a(this, this.f22709h.getString(2131242188), this.f22703b);
        this.at = this.f22705d.m23628a(this.au, kO_(), this.ao, this.f22710i, GroupMallType.values()[this.aw], this.ar);
        this.au.setAdapter(this.at);
        m23658h(this, true);
        m23657b(true);
        m23656a(true);
    }

    public final void mY_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1513771506);
        super.mY_();
        this.f22708g.m22938b(this.ap);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -1922034820, a);
    }

    public final void m23660a(int i, int i2, Intent intent) {
        super.a(i, i2, intent);
        if (i == 1962 && i2 == -1 && intent.getExtras() != null && intent.hasExtra(EditGalleryIpcBundle.a)) {
            ((GroupsCoverPhotoHandler) this.al.get()).a(this.as, ((EditGalleryIpcBundle) intent.getParcelableExtra(EditGalleryIpcBundle.a)).b);
        }
    }

    public static void m23653a(GroupInfoFragment groupInfoFragment, FetchGroupInfoPageDataModel fetchGroupInfoPageDataModel, boolean z) {
        groupInfoFragment.aq = fetchGroupInfoPageDataModel;
        groupInfoFragment.f22703b.m23681a(groupInfoFragment.aq, groupInfoFragment.getContext());
        groupInfoFragment.f22702a.a(groupInfoFragment, groupInfoFragment.f22703b);
        groupInfoFragment.m23657b(z);
    }

    public static void m23652a(GroupInfoFragment groupInfoFragment, FetchGroupInfoPageDataModel fetchGroupInfoPageDataModel) {
        m23653a(groupInfoFragment, fetchGroupInfoPageDataModel, true);
    }

    public static void m23651a(GroupInfoFragment groupInfoFragment, EventRsvpMutation eventRsvpMutation, boolean z) {
        if (groupInfoFragment.aq != null && groupInfoFragment.aq.m23891q() != null && groupInfoFragment.aq.m23891q().m23710j() != null) {
            GroupEventsModel q = groupInfoFragment.aq.m23891q();
            ImmutableList.Builder builder = ImmutableList.builder();
            ImmutableList j = q.m23710j();
            int size = j.size();
            for (int i = 0; i < size; i++) {
                EdgesModel edgesModel = (EdgesModel) j.get(i);
                if (edgesModel.m23696a() == null || !Objects.equal(edgesModel.m23696a().dL_(), eventRsvpMutation.a())) {
                    builder.c(edgesModel);
                } else {
                    EdgesModel.Builder builder2 = new EdgesModel.Builder();
                    builder2.f22723a = edgesModel.m23696a();
                    EdgesModel.Builder builder3 = builder2;
                    builder3.f22723a = eventRsvpMutation.a(edgesModel.m23696a());
                    builder.c(builder3.m23692a());
                }
            }
            GroupEventsModel.Builder builder4 = new GroupEventsModel.Builder();
            GroupEventsModel.Builder builder5 = new GroupEventsModel.Builder();
            builder5.f22720a = q.m23706a();
            builder5.f22721b = q.m23710j();
            builder5.f22722c = q.m23711k();
            builder4 = builder5;
            builder4.f22721b = builder.b();
            builder4 = builder4;
            Builder a = Builder.m23727a(groupInfoFragment.aq);
            a.f22751f = builder4.m23690a();
            m23653a(groupInfoFragment, a.m23728a(), z);
        }
    }

    private void m23656a(boolean z) {
        if (!this.L) {
            this.f22704c.m23636a(this.as, "2", null, "6", null, Integer.toString(this.f22707f.a()), z ? GroupsFeedHeaderFetcher.a : GraphQLCachePolicy.d, new C32934(this));
        }
    }

    private void m23657b(boolean z) {
        this.at.m23627a(this.aq, z);
    }

    public static void m23658h(GroupInfoFragment groupInfoFragment, boolean z) {
        if (groupInfoFragment.av != null) {
            groupInfoFragment.av.setVisibility(z ? 0 : 8);
        }
    }

    public final String am_() {
        return "group_info";
    }

    public final Map<String, Object> m23662c() {
        Object obj = this.as;
        if (obj == null) {
            obj = this.s.getString("group_feed_id");
        }
        if (obj == null) {
            return null;
        }
        return ImmutableBiMap.b("group_id", obj);
    }
}
