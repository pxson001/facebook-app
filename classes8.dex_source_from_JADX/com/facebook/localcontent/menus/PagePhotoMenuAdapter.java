package com.facebook.localcontent.menus;

import android.net.Uri;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.inject.Assisted;
import com.facebook.localcontent.analytics.LocalContentMenuLogger;
import com.facebook.localcontent.protocol.graphql.FetchPhotoMenusGraphQLInterfaces.PhotoMenusData.PagePhotoMenus.Nodes.PagePhotoMenuPhotos.Edges;
import com.facebook.localcontent.protocol.graphql.FetchPhotoMenusGraphQLModels.PhotoMenusDataModel.PagePhotoMenusModel.NodesModel.PagePhotoMenuPhotosModel.EdgesModel;
import com.facebook.localcontent.protocol.graphql.FetchPhotoMenusGraphQLModels.PhotoMenusDataModel.PagePhotoMenusModel.NodesModel.PagePhotoMenuPhotosModel.EdgesModel.NodeModel;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.photos.base.analytics.constants.PhotoLoggingConstants.FullscreenGallerySource;
import com.facebook.photos.mediafetcher.interfaces.MediaFetcherConstructionRule;
import com.facebook.photos.mediafetcher.query.MenuPhotosMediaQueryProvider;
import com.facebook.photos.mediafetcher.query.param.IdQueryParam;
import com.facebook.photos.mediagallery.MediaGalleryLauncherParamsFactory.Builder;
import com.facebook.photos.mediagallery.launcher.MediaGalleryLauncher;
import com.facebook.widget.listview.FbBaseAdapter;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;

/* compiled from: ec_impression */
public class PagePhotoMenuAdapter extends FbBaseAdapter {
    public final LocalContentMenuLogger f14988a;
    public final MediaGalleryLauncher f14989b;
    public final String f14990c;
    public List<Edges> f14991d = new ArrayList();

    @Inject
    public PagePhotoMenuAdapter(LocalContentMenuLogger localContentMenuLogger, MediaGalleryLauncher mediaGalleryLauncher, @Assisted String str) {
        this.f14988a = localContentMenuLogger;
        this.f14989b = mediaGalleryLauncher;
        this.f14990c = str;
    }

    public final void m17437a(int i, Object obj, View view, int i2, ViewGroup viewGroup) {
        final PagePhotoMenuView pagePhotoMenuView = (PagePhotoMenuView) view;
        EdgesModel edgesModel = (EdgesModel) obj;
        final NodeModel a = edgesModel.a();
        pagePhotoMenuView.f15011b.setText(edgesModel.b());
        pagePhotoMenuView.setTimestamp(a.d());
        if (a.c() != null) {
            String b = a.c().b();
            pagePhotoMenuView.f15013d.setAspectRatio(((float) a.c().c()) / ((float) a.c().a()));
            pagePhotoMenuView.f15013d.a(Uri.parse(b), CallerContext.a(pagePhotoMenuView.getClass()));
        }
        pagePhotoMenuView.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ PagePhotoMenuAdapter f14987c;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, 188271131);
                LocalContentMenuLogger localContentMenuLogger = this.f14987c.f14988a;
                String str = this.f14987c.f14990c;
                String b = a.b();
                HoneyClientEvent b2 = LocalContentMenuLogger.m17408b("photo_menu_viewer", "menu_photo_tap", str);
                b2.b("photo_id", b);
                localContentMenuLogger.f14941a.a(b2);
                Builder builder = new Builder(MediaFetcherConstructionRule.a(MenuPhotosMediaQueryProvider.class, new IdQueryParam(this.f14987c.f14990c)));
                builder.n = false;
                builder.m = true;
                this.f14987c.f14989b.a(pagePhotoMenuView.getContext(), builder.a(FullscreenGallerySource.PAGE_PHOTO_MENUS).a(a.b()).b(), null);
                Logger.a(2, EntryType.UI_INPUT_END, 500407091, a);
            }
        });
    }

    public final View m17436a(int i, ViewGroup viewGroup) {
        return new PagePhotoMenuView(viewGroup.getContext());
    }

    public int getCount() {
        return this.f14991d.size();
    }

    public Object getItem(int i) {
        return this.f14991d.get(i);
    }

    public long getItemId(int i) {
        return (long) i;
    }
}
