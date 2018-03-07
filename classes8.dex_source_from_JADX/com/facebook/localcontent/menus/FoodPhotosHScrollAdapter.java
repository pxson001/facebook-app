package com.facebook.localcontent.menus;

import android.net.Uri;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.graphql.calls.CategoryInputCategoryName;
import com.facebook.inject.Assisted;
import com.facebook.localcontent.analytics.LocalContentMenuLogger;
import com.facebook.localcontent.protocol.graphql.StructuredMenuGraphQLInterfaces.PhotosQuery.PhotosByCategory.Nodes;
import com.facebook.localcontent.protocol.graphql.StructuredMenuGraphQLModels.PhotosQueryModel.PhotosByCategoryModel.NodesModel;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.photos.base.analytics.constants.PhotoLoggingConstants.FullscreenGallerySource;
import com.facebook.photos.mediagallery.MediaGalleryLauncherParamsFactory;
import com.facebook.photos.mediagallery.launcher.MediaGalleryLauncher;
import java.util.ArrayList;
import javax.inject.Inject;

/* compiled from: ec_initial_cards_loaded */
public class FoodPhotosHScrollAdapter extends Adapter<PhotoViewHolder> {
    private static final CallerContext f14957a = CallerContext.a(FoodPhotosHScrollAdapter.class);
    public final LocalContentMenuLogger f14958b;
    public final MediaGalleryLauncher f14959c;
    public final String f14960d;
    public final String f14961e;
    public ArrayList<Nodes> f14962f = new ArrayList();

    /* compiled from: ec_initial_cards_loaded */
    public class PhotoViewHolder extends ViewHolder {
        final /* synthetic */ FoodPhotosHScrollAdapter f14956l;

        public PhotoViewHolder(FoodPhotosHScrollAdapter foodPhotosHScrollAdapter, FbDraweeView fbDraweeView) {
            this.f14956l = foodPhotosHScrollAdapter;
            super(fbDraweeView);
        }
    }

    public final void m17426a(ViewHolder viewHolder, int i) {
        final FbDraweeView fbDraweeView = (FbDraweeView) ((PhotoViewHolder) viewHolder).a;
        final NodesModel nodesModel = (NodesModel) this.f14962f.get(i);
        fbDraweeView.a(Uri.parse(nodesModel.c().b()), f14957a);
        fbDraweeView.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ FoodPhotosHScrollAdapter f14955c;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, -1757318969);
                LocalContentMenuLogger localContentMenuLogger = this.f14955c.f14958b;
                String str = this.f14955c.f14960d;
                String str2 = this.f14955c.f14961e;
                String b = nodesModel.b();
                HoneyClientEvent b2 = LocalContentMenuLogger.m17408b(str, "menu_viewer_food_photo_tap", str2);
                b2.b("photo_id", b);
                localContentMenuLogger.f14941a.a(b2);
                this.f14955c.f14959c.a(fbDraweeView.getContext(), MediaGalleryLauncherParamsFactory.a(this.f14955c.f14961e, CategoryInputCategoryName.FOOD, null).a(FullscreenGallerySource.FOOD_PHOTOS).a(nodesModel.b()).b(), null);
                Logger.a(2, EntryType.UI_INPUT_END, 407417378, a);
            }
        });
    }

    @Inject
    public FoodPhotosHScrollAdapter(LocalContentMenuLogger localContentMenuLogger, MediaGalleryLauncher mediaGalleryLauncher, @Assisted String str, @Assisted String str2) {
        this.f14958b = localContentMenuLogger;
        this.f14959c = mediaGalleryLauncher;
        this.f14960d = str;
        this.f14961e = str2;
    }

    public final ViewHolder m17425a(ViewGroup viewGroup, int i) {
        return new PhotoViewHolder(this, (FbDraweeView) LayoutInflater.from(viewGroup.getContext()).inflate(2130906607, viewGroup, false).findViewById(2131566610));
    }

    public final int aZ_() {
        return this.f14962f.size();
    }
}
