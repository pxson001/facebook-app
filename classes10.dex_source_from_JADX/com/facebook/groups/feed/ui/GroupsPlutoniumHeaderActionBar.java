package com.facebook.groups.feed.ui;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import com.facebook.bookmark.client.BookmarkClient;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.fragmentconstants.FragmentConstants.ContentFragmentType;
import com.facebook.dracula.api.DraculaReturnValue;
import com.facebook.dracula.runtime.base.DraculaRuntime;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.enums.GraphQLGroupJoinState;
import com.facebook.graphql.enums.GraphQLGroupVisibility;
import com.facebook.graphql.enums.GraphQLSubscribeStatus;
import com.facebook.groups.feed.data.GroupsGraphSearchHelper;
import com.facebook.groups.feed.protocol.FetchGroupInformationGraphQLModels.FetchGroupInformationModel;
import com.facebook.groups.feed.ui.GroupsFeedFragment.AnonymousClass15;
import com.facebook.groups.feed.ui.GroupsPlutoniumHeaderAdapter.GroupsPlutoniumHeaderAdapterListener;
import com.facebook.groups.widget.actionbar.GroupsActionBar;
import com.facebook.groups.widget.actionbar.GroupsActionBar.GroupsActionBarItems;
import com.facebook.groups.widget.actionbar.GroupsActionBar.Listener;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.Lazy;
import com.facebook.search.api.GraphSearchQuery;
import com.facebook.search.util.GraphSearchConfig;
import com.facebook.widget.CustomFrameLayout;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: ThreadViewMessagesFragment.maybeScrollListToBottom */
public class GroupsPlutoniumHeaderActionBar extends CustomFrameLayout implements GroupsPlutoniumHeaderAdapterListener {
    private static final String f22268e = GroupsPlutoniumHeaderActionBar.class.getName();
    @Inject
    public Lazy<FbErrorReporter> f22269a;
    @Inject
    public GroupsPlutoniumHeaderActionBarControllerProvider f22270b;
    @Inject
    public BookmarkClient f22271c;
    @Inject
    public GraphSearchConfig f22272d;
    public FetchGroupInformationModel f22273f;
    public GroupsPlutoniumHeaderActionBarController f22274g;
    public GroupsActionBar f22275h = ((GroupsActionBar) c(2131562756));
    public boolean f22276i;
    public GraphQLSubscribeStatus f22277j;
    private GraphSearchQuery f22278k;

    public static void m23386a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        GroupsPlutoniumHeaderActionBar groupsPlutoniumHeaderActionBar = (GroupsPlutoniumHeaderActionBar) obj;
        Lazy b = IdBasedSingletonScopeProvider.b(fbInjector, 494);
        GroupsPlutoniumHeaderActionBarControllerProvider groupsPlutoniumHeaderActionBarControllerProvider = (GroupsPlutoniumHeaderActionBarControllerProvider) fbInjector.getOnDemandAssistedProviderForStaticDi(GroupsPlutoniumHeaderActionBarControllerProvider.class);
        BookmarkClient a = BookmarkClient.a(fbInjector);
        GraphSearchConfig a2 = GraphSearchConfig.a(fbInjector);
        groupsPlutoniumHeaderActionBar.f22269a = b;
        groupsPlutoniumHeaderActionBar.f22270b = groupsPlutoniumHeaderActionBarControllerProvider;
        groupsPlutoniumHeaderActionBar.f22271c = a;
        groupsPlutoniumHeaderActionBar.f22272d = a2;
    }

    public GroupsPlutoniumHeaderActionBar(final Context context) {
        super(context);
        Class cls = GroupsPlutoniumHeaderActionBar.class;
        m23386a((Object) this, getContext());
        View.inflate(context, 2130904706, this);
        this.f22275h.f23202c = new Listener(this) {
            final /* synthetic */ GroupsPlutoniumHeaderActionBar f22266b;

            public final void mo987a(GroupsActionBarItems groupsActionBarItems) {
                if (this.f22266b.f22274g != null) {
                    GroupsPlutoniumHeaderActionBarController groupsPlutoniumHeaderActionBarController;
                    switch (groupsActionBarItems) {
                        case JOIN:
                            this.f22266b.f22274g.m23407d(this.f22266b.f22273f);
                            return;
                        case REQUESTED:
                        case JOINED:
                            GroupsPlutoniumHeaderActionBarPopoverHelper.m23414a(this.f22266b.f22273f, this.f22266b.f22275h, this.f22266b.f22274g, this.f22266b.f22276i, this.f22266b.f22271c.g(), this.f22266b.f22277j);
                            return;
                        case ADD_MEMBERS:
                            this.f22266b.f22274g.m23410e(this.f22266b.f22273f, context);
                            return;
                        case INFO:
                        case INFO_ICON:
                            this.f22266b.f22274g.m23402a(this.f22266b.f22273f, context);
                            return;
                        case SEARCH:
                            groupsPlutoniumHeaderActionBarController = this.f22266b.f22274g;
                            groupsPlutoniumHeaderActionBarController.f22318p.a(GroupsPlutoniumHeaderActionBar.getSearchQuery(this.f22266b));
                            return;
                        case SHARE_MAYBE:
                        case SHARE:
                            this.f22266b.f22274g.m23401a(this.f22266b.f22273f, context);
                            return;
                        case REPORT_GROUP:
                            this.f22266b.f22274g.m23411f(this.f22266b.f22273f, context);
                            return;
                        case FAVORITE_GROUP:
                            this.f22266b.f22274g.m23400a(this.f22266b.f22273f);
                            return;
                        case UNFAVORITE_GROUP:
                            this.f22266b.f22274g.m23404b(this.f22266b.f22273f);
                            return;
                        case CREATE_SHORTCUT:
                            this.f22266b.f22274g.m23405c(this.f22266b.f22273f);
                            return;
                        case VIEW_PHOTOS:
                            groupsPlutoniumHeaderActionBarController = this.f22266b.f22274g;
                            FetchGroupInformationModel fetchGroupInformationModel = this.f22266b.f22273f;
                            Context context = context;
                            if (fetchGroupInformationModel == null || fetchGroupInformationModel.gW_() == null) {
                                groupsPlutoniumHeaderActionBarController.f22317o.a(GroupsPlutoniumHeaderActionBarController.f22303a.getName(), "groupInformation or groupId is null in viewPhotos");
                            } else {
                                Intent component = new Intent().setComponent((ComponentName) groupsPlutoniumHeaderActionBarController.f22313k.get());
                                component.putExtra("group_feed_id", fetchGroupInformationModel.gW_());
                                component.putExtra("target_fragment", ContentFragmentType.GROUP_PHOTOS_FRAGMENT.ordinal());
                                groupsPlutoniumHeaderActionBarController.f22308f.a(component, context);
                            }
                            return;
                        case CREATE_GROUP:
                            this.f22266b.f22274g.m23398a(context);
                            return;
                        case CREATE_GROUP_CHAT:
                            this.f22266b.f22274g.m23406c(this.f22266b.f22273f, context);
                            return;
                        case CREATE_GROUP_EVENT:
                            this.f22266b.f22274g.m23408d(this.f22266b.f22273f, context);
                            return;
                        case EDIT_NOTIFICATION_SETTING:
                            this.f22266b.f22274g.m23412g(this.f22266b.f22273f, context);
                            return;
                        default:
                            return;
                    }
                }
            }
        };
    }

    public final void m23389a(@Nullable FetchGroupInformationModel fetchGroupInformationModel, AnonymousClass15 anonymousClass15) {
        boolean z;
        this.f22273f = fetchGroupInformationModel;
        if (this.f22274g != null) {
            this.f22274g.m23403a(anonymousClass15);
        } else {
            this.f22274g = this.f22270b.m23413a(anonymousClass15);
        }
        if (this.f22273f == null) {
            z = true;
        } else {
            DraculaReturnValue b = this.f22273f.b();
            MutableFlatBuffer mutableFlatBuffer = b.a;
            int i = b.b;
            int i2 = b.c;
            z = DraculaRuntime.a(mutableFlatBuffer, i, null, 0);
        }
        if (z || this.f22273f.p() == null || this.f22273f.p() == GraphQLGroupJoinState.UNSET_OR_UNRECOGNIZED_ENUM_VALUE) {
            i2 = 1;
        } else {
            b = fetchGroupInformationModel.b();
            mutableFlatBuffer = b.a;
            i = b.b;
            i2 = b.c;
            i2 = mutableFlatBuffer.k(i, 11) == null ? 1 : 0;
        }
        if (i2 != 0) {
            this.f22275h.setItems(ImmutableList.copyOf(Lists.a(new GroupsActionBarItems[]{GroupsActionBarItems.CREATE_GROUP})));
            setVisibility(4);
            return;
        }
        setVisibility(0);
        ArrayList a = Lists.a();
        try {
            if (this.f22271c.b(Long.parseLong(fetchGroupInformationModel.gW_()))) {
                this.f22276i = true;
            } else {
                this.f22276i = false;
            }
        } catch (NumberFormatException e) {
            ((AbstractFbErrorReporter) this.f22269a.get()).b(f22268e, "Group id of this group is not pure numerical");
        }
        this.f22277j = this.f22273f.k();
        if (fetchGroupInformationModel.p() == GraphQLGroupJoinState.MEMBER) {
            a.add(GroupsActionBarItems.JOINED);
            a.add(GroupsActionBarItems.ADD_MEMBERS);
        } else if (fetchGroupInformationModel.p() == GraphQLGroupJoinState.REQUESTED) {
            a.add(GroupsActionBarItems.REQUESTED);
        } else {
            a.add(GroupsActionBarItems.JOIN);
        }
        b = fetchGroupInformationModel.b();
        MutableFlatBuffer mutableFlatBuffer2 = b.a;
        int i3 = b.b;
        i2 = b.c;
        GraphQLGroupVisibility graphQLGroupVisibility = (GraphQLGroupVisibility) mutableFlatBuffer2.f(i3, 17, GraphQLGroupVisibility.class);
        if (graphQLGroupVisibility == null || !(graphQLGroupVisibility == GraphQLGroupVisibility.CLOSED || graphQLGroupVisibility == GraphQLGroupVisibility.OPEN)) {
            i2 = 0;
        } else {
            i2 = 1;
        }
        if (this.f22272d.f(getSearchQuery(this))) {
            a.add(GroupsActionBarItems.SEARCH);
        } else if (i2 != 0) {
            a.add(GroupsActionBarItems.SHARE);
        }
        a.add(GroupsActionBarItems.INFO_ICON);
        Preconditions.checkState(m23387a(a));
        this.f22275h.setItems(ImmutableList.copyOf(a));
    }

    public final void mo988a() {
        if (this.f22274g != null) {
            this.f22274g.mo988a();
        }
    }

    public static GraphSearchQuery getSearchQuery(GroupsPlutoniumHeaderActionBar groupsPlutoniumHeaderActionBar) {
        if (groupsPlutoniumHeaderActionBar.f22278k == null) {
            groupsPlutoniumHeaderActionBar.f22278k = GroupsGraphSearchHelper.b(groupsPlutoniumHeaderActionBar.f22273f, groupsPlutoniumHeaderActionBar.f22273f.gW_(), true, groupsPlutoniumHeaderActionBar.f22272d);
        }
        return groupsPlutoniumHeaderActionBar.f22278k;
    }

    private static boolean m23387a(List<GroupsActionBarItems> list) {
        int i = 0;
        for (GroupsActionBarItems groupsActionBarItems : list) {
            int i2;
            if (groupsActionBarItems.showAsAction == 2) {
                i2 = i + 1;
            } else {
                i2 = i;
            }
            i = i2;
        }
        if (i <= 4) {
            return true;
        }
        return false;
    }
}
