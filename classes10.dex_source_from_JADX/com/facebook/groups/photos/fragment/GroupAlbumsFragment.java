package com.facebook.groups.photos.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.facebook.base.fragment.FbFragment;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.flatbuffers.helpers.FlatBufferModelHelper;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.model.GraphQLAlbum;
import com.facebook.groups.photos.adapter.GroupAlbumsAdapter;
import com.facebook.groups.photos.adapter.GroupAlbumsAdapterProvider;
import com.facebook.groups.photos.intent.GroupsPhotosIntentBuilder;
import com.facebook.groups.photos.loader.GroupAlbumsPagedListLoader;
import com.facebook.groups.photos.loader.GroupAlbumsPagedListLoaderProvider;
import com.facebook.groups.photos.protocol.FetchGroupAlbumsModels.FetchGroupAlbumsModel.GroupAlbumsModel.NodesModel;
import com.facebook.groups.photos.view.GroupPhotosDefaultViewFactory;
import com.facebook.groups.photos.view.GroupPhotosViewFactory;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.Lazy;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.photos.albumcreator.AlbumCreatorIntentBuilder;
import com.facebook.ui.futures.TasksManager;
import com.facebook.widget.listview.BetterListView;
import com.facebook.widget.text.BetterTextView;
import java.util.concurrent.ExecutorService;
import javax.inject.Inject;

/* compiled from: TOXICLE_PUBLIC_GOING */
public class GroupAlbumsFragment extends FbFragment {
    @Inject
    GroupAlbumsPagedListLoaderProvider f23007a;
    public GroupAlbumsAdapter al;
    public boolean am;
    public BetterTextView an;
    private BetterListView ao;
    @Inject
    GroupAlbumsAdapterProvider f23008b;
    @Inject
    public SecureContextHelper f23009c;
    @Inject
    GroupsPhotosIntentBuilder f23010d;
    @Inject
    GroupPhotosDefaultViewFactory f23011e;
    @Inject
    public Lazy<AlbumCreatorIntentBuilder> f23012f;
    public String f23013g;
    private String f23014h;
    private GroupAlbumsPagedListLoader f23015i;

    /* compiled from: TOXICLE_PUBLIC_GOING */
    public class C33181 {
        public final /* synthetic */ GroupAlbumsFragment f23003a;

        C33181(GroupAlbumsFragment groupAlbumsFragment) {
            this.f23003a = groupAlbumsFragment;
        }
    }

    /* compiled from: TOXICLE_PUBLIC_GOING */
    public class C33192 {
        public final /* synthetic */ GroupAlbumsFragment f23004a;

        C33192(GroupAlbumsFragment groupAlbumsFragment) {
            this.f23004a = groupAlbumsFragment;
        }

        public final void m24222a(boolean z) {
            this.f23004a.al.m24214a(z);
        }

        public final void m24223a(boolean z, boolean z2) {
            if (this.f23004a.an == null) {
                return;
            }
            if (z) {
                this.f23004a.al.m24214a(false);
                if (z2) {
                    this.f23004a.an.setText(this.f23004a.f23011e.m24420a());
                } else {
                    this.f23004a.an.setText(this.f23004a.f23011e.m24421c());
                }
                this.f23004a.an.setVisibility(0);
                return;
            }
            this.f23004a.an.setVisibility(8);
        }
    }

    /* compiled from: TOXICLE_PUBLIC_GOING */
    class C33203 implements OnScrollListener {
        final /* synthetic */ GroupAlbumsFragment f23005a;

        C33203(GroupAlbumsFragment groupAlbumsFragment) {
            this.f23005a = groupAlbumsFragment;
        }

        public void onScrollStateChanged(AbsListView absListView, int i) {
        }

        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            if (this.f23005a.am) {
                Object obj = null;
                if (!this.f23005a.al.isEmpty() && i2 > 0 && i3 > 0 && (i + i2) + 4 > i3) {
                    obj = 1;
                }
                if (obj != null) {
                    GroupAlbumsFragment.m24227b(this.f23005a);
                }
            }
        }
    }

    /* compiled from: TOXICLE_PUBLIC_GOING */
    class C33214 implements OnItemClickListener {
        final /* synthetic */ GroupAlbumsFragment f23006a;

        C33214(GroupAlbumsFragment groupAlbumsFragment) {
            this.f23006a = groupAlbumsFragment;
        }

        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            NodesModel a = this.f23006a.al.m24212a(i);
            if (a != null) {
                GroupAlbumsFragment.m24224a(this.f23006a, a.m24326c());
            }
        }
    }

    public static void m24226a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((GroupAlbumsFragment) obj).m24225a((GroupAlbumsPagedListLoaderProvider) fbInjector.getOnDemandAssistedProviderForStaticDi(GroupAlbumsPagedListLoaderProvider.class), (GroupAlbumsAdapterProvider) fbInjector.getOnDemandAssistedProviderForStaticDi(GroupAlbumsAdapterProvider.class), (SecureContextHelper) DefaultSecureContextHelper.a(fbInjector), GroupsPhotosIntentBuilder.m24253b(fbInjector), GroupPhotosDefaultViewFactory.m24419b(fbInjector), IdBasedLazy.a(fbInjector, 9243));
    }

    public final void m24231c(Bundle bundle) {
        super.c(bundle);
        Class cls = GroupAlbumsFragment.class;
        m24226a((Object) this, getContext());
        this.f23013g = this.s.getString("group_feed_id");
        this.f23014h = this.s.getString("group_name");
        this.al = new GroupAlbumsAdapter(new C33181(this));
        GroupAlbumsPagedListLoaderProvider groupAlbumsPagedListLoaderProvider = this.f23007a;
        this.f23015i = new GroupAlbumsPagedListLoader(GraphQLQueryExecutor.a(groupAlbumsPagedListLoaderProvider), (ExecutorService) ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.a(groupAlbumsPagedListLoaderProvider), TasksManager.b(groupAlbumsPagedListLoaderProvider), ResourcesMethodAutoProvider.a(groupAlbumsPagedListLoaderProvider), this.f23013g, new C33192(this));
    }

    public final View m24228a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1519486478);
        View inflate = layoutInflater.inflate(2130904639, viewGroup, false);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -2143289392, a);
        return inflate;
    }

    public final void mY_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 341306456);
        super.mY_();
        GroupAlbumsPagedListLoader groupAlbumsPagedListLoader = this.f23015i;
        groupAlbumsPagedListLoader.m24259b();
        groupAlbumsPagedListLoader.f23040e.c();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -1076026534, a);
    }

    public final void m24232g(boolean z) {
        this.am = z;
    }

    public final void m24230a(View view, Bundle bundle) {
        super.a(view, bundle);
        ViewStub viewStub = (ViewStub) e(2131562622);
        GroupPhotosDefaultViewFactory groupPhotosDefaultViewFactory = this.f23011e;
        viewStub.setLayoutResource(2130904734);
        this.an = (BetterTextView) viewStub.inflate();
        this.an.setText(this.f23011e.m24420a());
        this.an.setVisibility(8);
        this.ao = (BetterListView) e(2131562623);
        BetterListView betterListView = (BetterListView) e(2131562623);
        betterListView.setAdapter(this.al);
        betterListView.setOnScrollListener(new C33203(this));
        betterListView.setOnItemClickListener(new C33214(this));
        m24227b(this);
    }

    private void m24225a(GroupAlbumsPagedListLoaderProvider groupAlbumsPagedListLoaderProvider, GroupAlbumsAdapterProvider groupAlbumsAdapterProvider, SecureContextHelper secureContextHelper, GroupsPhotosIntentBuilder groupsPhotosIntentBuilder, GroupPhotosViewFactory groupPhotosViewFactory, Lazy<AlbumCreatorIntentBuilder> lazy) {
        this.f23007a = groupAlbumsPagedListLoaderProvider;
        this.f23008b = groupAlbumsAdapterProvider;
        this.f23009c = secureContextHelper;
        this.f23010d = groupsPhotosIntentBuilder;
        this.f23011e = groupPhotosViewFactory;
        this.f23012f = lazy;
    }

    public final void m24229a(int i, int i2, Intent intent) {
        super.a(i, i2, intent);
        if (i2 == -1) {
            switch (i) {
                case 1991:
                    m24224a(this, ((GraphQLAlbum) FlatBufferModelHelper.a(intent, "extra_album")).u());
                    if (this.f23015i != null) {
                        this.f23015i.m24259b();
                        this.f23015i.m24258a();
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    public static void m24227b(GroupAlbumsFragment groupAlbumsFragment) {
        groupAlbumsFragment.f23015i.m24258a();
    }

    public static void m24224a(GroupAlbumsFragment groupAlbumsFragment, String str) {
        groupAlbumsFragment.f23009c.a(groupAlbumsFragment.f23010d.m24255b(str, groupAlbumsFragment.f23013g, groupAlbumsFragment.f23014h), groupAlbumsFragment.getContext());
    }
}
