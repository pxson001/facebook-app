package com.facebook.localcontent.menus;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.common.fblinks.FBLinks;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.uri.UriIntentMapper;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.graphql.enums.GraphQLPhotosByCategoryEntryPoint;
import com.facebook.inject.InjectorLike;
import com.facebook.katana.urimap.Fb4aUriIntentMapper;
import com.facebook.localcontent.analytics.LocalContentMenuLogger;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.photos.mediagallery.launcher.MediaGalleryLauncher;
import com.facebook.photos.mediagallery.ui.DefaultMediaGalleryLauncher;
import javax.inject.Inject;

/* compiled from: ec_initial_card_cover_photo_configured */
public class FoodPhotosHScrollController {
    private final FoodPhotosHScrollAdapterProvider f14965a;
    public final FoodPhotosHScrollLoader f14966b;
    public final LocalContentMenuLogger f14967c;
    public final SecureContextHelper f14968d;
    public final UriIntentMapper f14969e;
    public FoodPhotosHScrollAdapter f14970f;
    public String f14971g;
    public String f14972h;
    public boolean f14973i;
    public String f14974j;
    public FoodPhotosHscrollView f14975k;

    /* compiled from: ec_initial_card_cover_photo_configured */
    class FoodPhotosScrollListener extends OnScrollListener {
        final /* synthetic */ FoodPhotosHScrollController f14963a;

        public FoodPhotosScrollListener(FoodPhotosHScrollController foodPhotosHScrollController) {
            this.f14963a = foodPhotosHScrollController;
        }

        public final void m17427a(RecyclerView recyclerView, int i, int i2) {
            if (((LinearLayoutManager) recyclerView.getLayoutManager()).n() > this.f14963a.f14970f.aZ_() - 2 && this.f14963a.f14972h != null && !this.f14963a.f14973i) {
                this.f14963a.f14973i = true;
                this.f14963a.f14966b.m17434a(this.f14963a.f14974j, this.f14963a.f14972h, this.f14963a);
            }
        }
    }

    /* compiled from: ec_initial_card_cover_photo_configured */
    class FoodPhotosSeeMoreOnClickListener implements OnClickListener {
        final /* synthetic */ FoodPhotosHScrollController f14964a;

        public FoodPhotosSeeMoreOnClickListener(FoodPhotosHScrollController foodPhotosHScrollController) {
            this.f14964a = foodPhotosHScrollController;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 1989815864);
            this.f14964a.f14967c.f14941a.a(LocalContentMenuLogger.m17408b(this.f14964a.f14971g, "menu_viewer_see_more_food_photos_tap", this.f14964a.f14974j));
            this.f14964a.f14968d.a(this.f14964a.f14969e.a(this.f14964a.f14975k.getContext(), StringFormatUtil.formatStrLocaleSafe(FBLinks.du, this.f14964a.f14974j)).putExtra("local_content_entry_point", GraphQLPhotosByCategoryEntryPoint.FOOD_PHOTOS_OF_PLACE), this.f14964a.f14975k.getContext());
            Logger.a(2, EntryType.UI_INPUT_END, -1846430635, a);
        }
    }

    public static FoodPhotosHScrollController m17428b(InjectorLike injectorLike) {
        return new FoodPhotosHScrollController((FoodPhotosHScrollAdapterProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(FoodPhotosHScrollAdapterProvider.class), FoodPhotosHScrollLoader.m17432a(injectorLike), LocalContentMenuLogger.m17409b(injectorLike), (SecureContextHelper) DefaultSecureContextHelper.a(injectorLike), (UriIntentMapper) Fb4aUriIntentMapper.a(injectorLike));
    }

    @Inject
    public FoodPhotosHScrollController(FoodPhotosHScrollAdapterProvider foodPhotosHScrollAdapterProvider, FoodPhotosHScrollLoader foodPhotosHScrollLoader, LocalContentMenuLogger localContentMenuLogger, SecureContextHelper secureContextHelper, UriIntentMapper uriIntentMapper) {
        this.f14965a = foodPhotosHScrollAdapterProvider;
        this.f14966b = foodPhotosHScrollLoader;
        this.f14967c = localContentMenuLogger;
        this.f14968d = secureContextHelper;
        this.f14969e = uriIntentMapper;
    }

    public final void m17429a(FoodPhotosHscrollView foodPhotosHscrollView, String str, String str2) {
        this.f14975k = foodPhotosHscrollView;
        this.f14974j = str;
        this.f14971g = str2;
        FoodPhotosHScrollAdapterProvider foodPhotosHScrollAdapterProvider = this.f14965a;
        this.f14970f = new FoodPhotosHScrollAdapter(LocalContentMenuLogger.m17409b(foodPhotosHScrollAdapterProvider), (MediaGalleryLauncher) DefaultMediaGalleryLauncher.m2459a(foodPhotosHScrollAdapterProvider), this.f14971g, this.f14974j);
        this.f14975k.setVisibility(8);
        this.f14975k.setRecyclerAdapter(this.f14970f);
        this.f14975k.setRecyclerOnScrollListener(new FoodPhotosScrollListener(this));
        this.f14975k.setSeeMoreOnClickListener(new FoodPhotosSeeMoreOnClickListener(this));
        this.f14966b.m17434a(this.f14974j, this.f14972h, this);
    }
}
