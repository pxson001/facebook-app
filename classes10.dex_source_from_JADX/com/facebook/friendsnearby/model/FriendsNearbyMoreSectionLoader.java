package com.facebook.friendsnearby.model;

import android.content.res.Resources;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.debug.log.BLog;
import com.facebook.friendsnearby.server.FriendsNearbyNewQueryModels.FriendsNearbyMoreInSectionQueryModel;
import com.facebook.friendsnearby.server.FriendsNearbyNewQueryModels.FriendsNearbyMoreInSectionQueryModel.SetItemsModel;
import com.facebook.friendsnearby.server.FriendsNearbyNewQueryModels.FriendsNearbyNewListItemModel;
import com.facebook.friendsnearby.server.FriendsNearbyNewQueryModels.FriendsNearbyNewListItemModel.ContactModel;
import com.facebook.friendsnearby.server.FriendsNearbyNewQueryModels.FriendsNearbyNewListItemModel.ContactModel.RepresentedProfileModel;
import com.facebook.friendsnearby.ui.FriendsNearbyFragment.C29583;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.inject.Assisted;
import com.facebook.ui.futures.TasksManager;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.RegularImmutableList;
import javax.inject.Inject;

/* compiled from: a35d3f7a46e8a352212257460eac1b20 */
public class FriendsNearbyMoreSectionLoader {
    public static final Class<?> f20475a = FriendsNearbyMoreSectionLoader.class;
    public final String f20476b;
    public final String f20477c;
    public final TasksManager<FriendsNearbyTask> f20478d;
    public final GraphQLQueryExecutor f20479e;
    public final String f20480f;
    public final AbstractFbErrorReporter f20481g;
    public final FriendsNearbyNewListRowProvider f20482h;

    /* compiled from: a35d3f7a46e8a352212257460eac1b20 */
    public class C29241 extends AbstractDisposableFutureCallback<GraphQLResult<FriendsNearbyMoreInSectionQueryModel>> {
        final /* synthetic */ C29583 f20472a;
        final /* synthetic */ ImmutableSet f20473b;
        final /* synthetic */ FriendsNearbyMoreSectionLoader f20474c;

        public C29241(FriendsNearbyMoreSectionLoader friendsNearbyMoreSectionLoader, C29583 c29583, ImmutableSet immutableSet) {
            this.f20474c = friendsNearbyMoreSectionLoader;
            this.f20472a = c29583;
            this.f20473b = immutableSet;
        }

        protected final void m20858a(Object obj) {
            GraphQLResult graphQLResult = (GraphQLResult) obj;
            if (graphQLResult != null) {
                ImmutableList immutableList;
                FriendsNearbyMoreInSectionQueryModel friendsNearbyMoreInSectionQueryModel = (FriendsNearbyMoreInSectionQueryModel) graphQLResult.e;
                C29583 c29583 = this.f20472a;
                FriendsNearbyMoreSectionLoader friendsNearbyMoreSectionLoader = this.f20474c;
                ImmutableSet immutableSet = this.f20473b;
                if (friendsNearbyMoreInSectionQueryModel == null) {
                    immutableList = RegularImmutableList.a;
                } else {
                    SetItemsModel a = friendsNearbyMoreInSectionQueryModel.m21347a();
                    if (a == null) {
                        immutableList = RegularImmutableList.a;
                    } else {
                        ImmutableList a2 = a.m21344a();
                        Builder builder = ImmutableList.builder();
                        int size = a2.size();
                        for (int i = 0; i < size; i++) {
                            FriendsNearbyNewListItemModel friendsNearbyNewListItemModel = (FriendsNearbyNewListItemModel) a2.get(i);
                            if (friendsNearbyNewListItemModel != null) {
                                ContactModel c = friendsNearbyNewListItemModel.m21398c();
                                if (c != null) {
                                    RepresentedProfileModel a3 = c.m21375a();
                                    if (a3 != null) {
                                        FriendsNearbyNewListRow a4 = FriendsNearbyNewListRow.m20898a(friendsNearbyNewListItemModel, friendsNearbyMoreSectionLoader.f20476b, immutableSet.contains(a3.m21369b()), friendsNearbyMoreSectionLoader.f20482h);
                                        if (a4 != null) {
                                            builder.c(a4);
                                        }
                                    }
                                }
                            }
                        }
                        immutableList = builder.b();
                    }
                }
                c29583.m21760a(immutableList);
            }
        }

        protected final void m20859a(Throwable th) {
            BLog.b(FriendsNearbyMoreSectionLoader.f20475a, "failed to get more section data", th);
            this.f20474c.f20481g.a("friends_nearby_more_section_data_load_fail", th);
            C29583 c29583 = this.f20472a;
            c29583.f20881c.m21977b();
            c29583.f20883e.aL.remove(c29583.f20882d);
        }
    }

    @Inject
    public FriendsNearbyMoreSectionLoader(@Assisted String str, @Assisted String str2, @Assisted TasksManager tasksManager, Resources resources, GraphQLQueryExecutor graphQLQueryExecutor, AbstractFbErrorReporter abstractFbErrorReporter, FriendsNearbyNewListRowProvider friendsNearbyNewListRowProvider) {
        this.f20476b = str;
        this.f20477c = str2;
        this.f20480f = String.valueOf(resources.getDimensionPixelSize(2131434232));
        this.f20479e = graphQLQueryExecutor;
        this.f20478d = tasksManager;
        this.f20481g = abstractFbErrorReporter;
        this.f20482h = friendsNearbyNewListRowProvider;
    }
}
