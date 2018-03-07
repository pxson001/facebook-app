package com.facebook.localcontent.menus;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ListView;
import com.facebook.analytics.tagging.AnalyticsFragment;
import com.facebook.base.fragment.FbFragment;
import com.facebook.common.util.FindViewUtil;
import com.facebook.content.event.FbEvent;
import com.facebook.device.ScreenUtil;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.query.GraphQlQueryString;
import com.facebook.inject.FbInjector;
import com.facebook.localcontent.analytics.LocalContentMenuLogger;
import com.facebook.localcontent.menus.PagePhotoMenuDataLoader.C16231;
import com.facebook.localcontent.menus.PagePhotoMenuDataLoader.C16242;
import com.facebook.localcontent.protocol.graphql.FetchPhotoMenusGraphQL.PhotoMenusDataString;
import com.facebook.localcontent.protocol.graphql.FetchPhotoMenusGraphQLModels.PhotoMenusDataModel.PagePhotoMenusModel.NodesModel.PagePhotoMenuPhotosModel.EdgesModel;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.photos.galleryutil.events.ConsumptionPhotoEventBus;
import com.facebook.photos.galleryutil.events.ConsumptionPhotoEvents.DeletePhotoEvent;
import com.facebook.photos.galleryutil.events.ConsumptionPhotoEvents.DeletePhotoEventSubscriber;
import com.facebook.photos.mediagallery.launcher.MediaGalleryLauncher;
import com.facebook.photos.mediagallery.ui.DefaultMediaGalleryLauncher;
import com.facebook.tools.dextr.runtime.detour.AdapterDetour;
import com.facebook.widget.listview.EmptyListViewItem;
import com.facebook.widget.titlebar.HasTitleBar;
import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.Futures;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: ec_entity_cards_displayed */
public class PagePhotoMenuFragment extends FbFragment implements AnalyticsFragment {
    @Inject
    FoodPhotosHScrollController f15000a;
    public PagePhotoMenuAdapter al;
    private String am;
    @Inject
    LocalContentMenuLogger f15001b;
    @Inject
    PagePhotoMenuAdapterProvider f15002c;
    @Inject
    PagePhotoMenuDataLoader f15003d;
    @Inject
    public ConsumptionPhotoEventBus f15004e;
    @Inject
    ScreenUtil f15005f;
    public DeletePhotoEventSubscriber f15006g;
    public EmptyListViewItem f15007h;
    private FoodPhotosHscrollView f15008i;

    /* compiled from: ec_entity_cards_displayed */
    public class C16251 extends DeletePhotoEventSubscriber {
        final /* synthetic */ PagePhotoMenuFragment f14999a;

        public C16251(PagePhotoMenuFragment pagePhotoMenuFragment) {
            this.f14999a = pagePhotoMenuFragment;
        }

        public final void m17442b(FbEvent fbEvent) {
            DeletePhotoEvent deletePhotoEvent = (DeletePhotoEvent) fbEvent;
            PagePhotoMenuAdapter pagePhotoMenuAdapter = this.f14999a.al;
            String valueOf = String.valueOf(deletePhotoEvent.c);
            for (EdgesModel edgesModel : pagePhotoMenuAdapter.f14991d) {
                if (edgesModel.a().b().equals(valueOf)) {
                    pagePhotoMenuAdapter.f14991d.remove(edgesModel);
                    AdapterDetour.a(pagePhotoMenuAdapter, -389778811);
                    return;
                }
            }
        }
    }

    public static void m17444a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((PagePhotoMenuFragment) obj).m17443a(FoodPhotosHScrollController.m17428b(fbInjector), LocalContentMenuLogger.m17409b(fbInjector), (PagePhotoMenuAdapterProvider) fbInjector.getOnDemandAssistedProviderForStaticDi(PagePhotoMenuAdapterProvider.class), PagePhotoMenuDataLoader.m17440a(fbInjector), ConsumptionPhotoEventBus.a(fbInjector), ScreenUtil.a(fbInjector));
    }

    public final void m17447c(@Nullable Bundle bundle) {
        super.c(bundle);
        Class cls = PagePhotoMenuFragment.class;
        m17444a((Object) this, getContext());
        this.am = this.s.getString("com.facebook.katana.profile.id");
        Preconditions.checkNotNull(this.am);
        if (bundle == null) {
            this.f15001b.f14941a.a(LocalContentMenuLogger.m17408b("photo_menu_viewer", "photo_menu_viewer_impression", this.am));
        }
    }

    public final View m17445a(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1620512473);
        View inflate = layoutInflater.inflate(2130906074, viewGroup, false);
        PagePhotoMenuAdapterProvider pagePhotoMenuAdapterProvider = this.f15002c;
        this.al = new PagePhotoMenuAdapter(LocalContentMenuLogger.m17409b(pagePhotoMenuAdapterProvider), (MediaGalleryLauncher) DefaultMediaGalleryLauncher.m2459a(pagePhotoMenuAdapterProvider), this.am);
        this.f15007h = (EmptyListViewItem) FindViewUtil.b(inflate, 2131565639);
        ListView listView = (ListView) FindViewUtil.b(inflate, 2131565638);
        FrameLayout frameLayout = (FrameLayout) layoutInflater.inflate(2130906073, listView, false);
        this.f15008i = (FoodPhotosHscrollView) frameLayout.findViewById(2131565637);
        listView.addHeaderView(frameLayout);
        listView.addFooterView(new View(getContext()));
        listView.setAdapter(this.al);
        listView.setEmptyView(this.f15007h);
        this.f15006g = new C16251(this);
        this.f15004e.a(this.f15006g);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 1887118734, a);
        return inflate;
    }

    public final void m17446a(View view, @Nullable Bundle bundle) {
        super.a(view, bundle);
        this.f15007h.a(true);
        PagePhotoMenuDataLoader pagePhotoMenuDataLoader = this.f15003d;
        String str = this.am;
        int c = this.f15005f.c();
        GraphQlQueryString photoMenusDataString = new PhotoMenusDataString();
        photoMenusDataString.a("page_id", str).a("count", Integer.valueOf(1000)).a("image_size", Integer.valueOf(c));
        pagePhotoMenuDataLoader.f14998c.a("task_key_load_photo_menus" + str, Futures.a(pagePhotoMenuDataLoader.f14997b.a(GraphQLRequest.a(photoMenusDataString)), new C16242(pagePhotoMenuDataLoader), pagePhotoMenuDataLoader.f14996a), new C16231(pagePhotoMenuDataLoader, this));
        this.f15000a.m17429a(this.f15008i, this.am, am_());
    }

    public final void mi_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1335712291);
        super.mi_();
        HasTitleBar hasTitleBar = (HasTitleBar) a(HasTitleBar.class);
        if (hasTitleBar != null) {
            hasTitleBar.y_(2131239096);
        }
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -146700365, a);
    }

    public final void mY_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1745516100);
        super.mY_();
        this.f15004e.b(this.f15006g);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -1341492291, a);
    }

    public final String am_() {
        return "photo_menu_viewer";
    }

    private void m17443a(FoodPhotosHScrollController foodPhotosHScrollController, LocalContentMenuLogger localContentMenuLogger, PagePhotoMenuAdapterProvider pagePhotoMenuAdapterProvider, PagePhotoMenuDataLoader pagePhotoMenuDataLoader, ConsumptionPhotoEventBus consumptionPhotoEventBus, ScreenUtil screenUtil) {
        this.f15000a = foodPhotosHScrollController;
        this.f15001b = localContentMenuLogger;
        this.f15002c = pagePhotoMenuAdapterProvider;
        this.f15003d = pagePhotoMenuDataLoader;
        this.f15004e = consumptionPhotoEventBus;
        this.f15005f = screenUtil;
    }
}
