package com.facebook.messaging.photos.view;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.debug.log.BLog;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.model.threadkey.ThreadKey;
import com.facebook.messaging.photos.service.MediaMessageItem;
import com.facebook.messaging.photos.view.PhotoViewFragment.AnonymousClass13;
import com.facebook.messaging.sharedimage.MediaResultPage;
import com.facebook.messaging.sharedimage.SharedImage;
import com.facebook.messaging.sharedimage.SharedImageHistoryFetcher;
import com.facebook.messaging.sharedimage.SharedImageHistoryFetcher.C06031;
import com.facebook.messaging.sharedimage.SharedImageHistoryFetcher.SharedImageHistoryRequestCallback;
import com.facebook.messaging.sharedimage.gqlrequest.SharedMediaHistoryRequestFactory;
import com.facebook.tools.dextr.runtime.detour.AdapterDetour;
import com.facebook.ui.futures.TasksManager;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import junit.framework.Assert;

/* compiled from: registration_login_success */
public class SharedImageMessageAdapter extends BaseAdapter {
    private final SharedImageHistoryFetcher f3644a;
    public final List<MediaMessageItem> f3645b = new ArrayList();
    public ThreadKey f3646c;
    public boolean f3647d = false;
    public AnonymousClass13 f3648e;
    private Context f3649f;
    public boolean f3650g;
    public String f3651h = "";
    public int f3652i;

    /* compiled from: registration_login_success */
    public class C05701 {
        public final /* synthetic */ SharedImageMessageAdapter f3643a;

        C05701(SharedImageMessageAdapter sharedImageMessageAdapter) {
            this.f3643a = sharedImageMessageAdapter;
        }

        public final void m3472a(MediaResultPage mediaResultPage) {
            if (mediaResultPage != null) {
                BaseAdapter baseAdapter = this.f3643a;
                ImmutableList immutableList = mediaResultPage.f4001f;
                if (!(baseAdapter.f3647d || immutableList.size() == 0)) {
                    int size = immutableList.size();
                    for (int i = 0; i < size; i++) {
                        baseAdapter.f3645b.add(0, (SharedImage) immutableList.get(i));
                    }
                    AdapterDetour.a(baseAdapter, 1994310288);
                }
                this.f3643a.f3651h = mediaResultPage.f3997b;
                this.f3643a.f3652i = mediaResultPage.f4000e;
            }
            AnonymousClass13 anonymousClass13 = this.f3643a.f3648e;
            if (anonymousClass13.f3621a.aA.getCount() == 0) {
                BLog.b("PhotoViewFragment", "SharedImageMessageAdapter has 0 images");
                anonymousClass13.f3621a.b();
            }
            this.f3643a.f3650g = false;
        }
    }

    public static SharedImageMessageAdapter m3474a(InjectorLike injectorLike) {
        return new SharedImageMessageAdapter((Context) injectorLike.getInstance(Context.class), new SharedImageHistoryFetcher(GraphQLQueryExecutor.a(injectorLike), SharedMediaHistoryRequestFactory.b(injectorLike), ResourcesMethodAutoProvider.a(injectorLike), TasksManager.b(injectorLike)));
    }

    public /* synthetic */ Object getItem(int i) {
        return m3473a(i);
    }

    @Inject
    public SharedImageMessageAdapter(Context context, SharedImageHistoryFetcher sharedImageHistoryFetcher) {
        this.f3649f = context;
        this.f3644a = sharedImageHistoryFetcher;
    }

    public int getCount() {
        return this.f3645b.size();
    }

    private MediaMessageItem m3473a(int i) {
        return (MediaMessageItem) this.f3645b.get(i);
    }

    public long getItemId(int i) {
        return (long) (getCount() - i);
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        MediaMessageItem a = m3473a(i);
        Preconditions.checkNotNull(a, "Null item in PhotoGalleryAdapter.getView");
        view = (PhotoMessageView) view;
        if (view == null) {
            view = new PhotoMessageView(this.f3649f);
        }
        view.setPhotoMessageItem(a);
        if (!(this.f3650g || this.f3651h == null || i > 5)) {
            m3475c();
        }
        return view;
    }

    private void m3475c() {
        this.f3650g = true;
        SharedImageHistoryFetcher sharedImageHistoryFetcher = this.f3644a;
        ThreadKey threadKey = this.f3646c;
        String str = this.f3651h;
        C05701 c05701 = new C05701(this);
        Assert.assertNotNull(c05701);
        sharedImageHistoryFetcher.f4019f = c05701;
        Integer.valueOf(sharedImageHistoryFetcher.f4017d.getDimensionPixelSize(2131428549));
        GraphQLRequest a = sharedImageHistoryFetcher.f4016c.a(threadKey, str);
        boolean a2 = sharedImageHistoryFetcher.f4018e.a(threadKey.g(), new C06031(sharedImageHistoryFetcher, a), new SharedImageHistoryRequestCallback(sharedImageHistoryFetcher));
    }
}
