package com.facebook.localcontent.photos;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.analytics.tagging.AnalyticsFragment;
import com.facebook.base.fragment.FbFragment;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.content.event.FbEvent;
import com.facebook.fbui.pagerindicator.TabbedViewPagerIndicator;
import com.facebook.graphql.enums.GraphQLPhotosByCategoryEntryPoint;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.query.GraphQlQueryString;
import com.facebook.inject.FbInjector;
import com.facebook.localcontent.analytics.LocalContentPhotosLogger;
import com.facebook.localcontent.photos.PhotosByCategoryLoader.C16581;
import com.facebook.localcontent.protocol.graphql.FetchPhotosByCategoryGraphQL.AvailableCategoriesQueryString;
import com.facebook.localcontent.protocol.graphql.FetchPhotosByCategoryGraphQLModels.AvailableCategoriesQueryModel;
import com.facebook.localcontent.protocol.graphql.FetchPhotosByCategoryGraphQLModels.AvailableCategoriesQueryModel.PhotosByCategoryModel.AvailableCategoriesModel;
import com.facebook.localcontent.protocol.graphql.FetchPhotosByCategoryGraphQLModels.AvailableCategoriesQueryModel.PhotosByCategoryModel.PrimaryCategoryModel;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.photos.upload.event.MediaUploadEventBus;
import com.facebook.photos.upload.event.MediaUploadEventSubscriber;
import com.facebook.photos.upload.event.MediaUploadSuccessEvent;
import com.facebook.photos.upload.operation.UploadOperation.Type;
import com.facebook.ui.toaster.ToastBuilder;
import com.facebook.ui.toaster.Toaster;
import com.facebook.widget.listview.EmptyListViewItem;
import com.facebook.widget.titlebar.HasTitleBar;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: document_kicker */
public class PhotosByCategoryTabPagerFragment extends FbFragment implements AnalyticsFragment {
    private static final CallerContext f15209e = CallerContext.a(PhotosByCategoryTabPagerFragment.class);
    @Inject
    public MediaUploadEventBus f15210a;
    private ViewPager al;
    private GraphQLPhotosByCategoryEntryPoint am;
    @Inject
    public PhotosByCategoryLoader f15211b;
    @Inject
    public LocalContentPhotosLogger f15212c;
    @Inject
    public Toaster f15213d;
    private final MediaUploadEventSubscriber f15214f = new PlacePhotoUploadEventSubscriber(this);
    private EmptyListViewItem f15215g;
    public String f15216h;
    private TabbedViewPagerIndicator f15217i;

    /* compiled from: document_kicker */
    class C16601 implements OnPageChangeListener {
        final /* synthetic */ PhotosByCategoryTabPagerFragment f15207a;

        C16601(PhotosByCategoryTabPagerFragment photosByCategoryTabPagerFragment) {
            this.f15207a = photosByCategoryTabPagerFragment;
        }

        public final void m17649a(int i, float f, int i2) {
        }

        public final void e_(int i) {
            LocalContentPhotosLogger localContentPhotosLogger = this.f15207a.f15212c;
            String str = this.f15207a.f15216h;
            AnalyticsLogger analyticsLogger = localContentPhotosLogger.f14942a;
            HoneyClientEvent honeyClientEvent = new HoneyClientEvent("photos_by_category_tab_tap");
            honeyClientEvent.c = "photos_by_category";
            analyticsLogger.a(honeyClientEvent.b("page_id", str).a("tab_position", i));
        }

        public final void m17650b(int i) {
        }
    }

    /* compiled from: document_kicker */
    class PlacePhotoUploadEventSubscriber extends MediaUploadEventSubscriber<MediaUploadSuccessEvent> {
        final /* synthetic */ PhotosByCategoryTabPagerFragment f15208a;

        public PlacePhotoUploadEventSubscriber(PhotosByCategoryTabPagerFragment photosByCategoryTabPagerFragment) {
            this.f15208a = photosByCategoryTabPagerFragment;
        }

        public final void m17652b(FbEvent fbEvent) {
            MediaUploadSuccessEvent mediaUploadSuccessEvent = (MediaUploadSuccessEvent) fbEvent;
            if (mediaUploadSuccessEvent.a.r == Type.PLACE_PHOTO) {
                this.f15208a.f15213d.a(new ToastBuilder(this.f15208a.jW_().getQuantityString(2131689726, mediaUploadSuccessEvent.a.c())));
            }
        }

        public final Class m17651a() {
            return MediaUploadSuccessEvent.class;
        }
    }

    public static void m17653a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        PhotosByCategoryTabPagerFragment photosByCategoryTabPagerFragment = (PhotosByCategoryTabPagerFragment) obj;
        MediaUploadEventBus a = MediaUploadEventBus.a(fbInjector);
        PhotosByCategoryLoader a2 = PhotosByCategoryLoader.m17645a(fbInjector);
        LocalContentPhotosLogger localContentPhotosLogger = new LocalContentPhotosLogger(AnalyticsLoggerMethodAutoProvider.a(fbInjector));
        Toaster b = Toaster.b(fbInjector);
        photosByCategoryTabPagerFragment.f15210a = a;
        photosByCategoryTabPagerFragment.f15211b = a2;
        photosByCategoryTabPagerFragment.f15212c = localContentPhotosLogger;
        photosByCategoryTabPagerFragment.f15213d = b;
    }

    public final void m17658c(@Nullable Bundle bundle) {
        super.c(bundle);
        Class cls = PhotosByCategoryTabPagerFragment.class;
        m17653a((Object) this, getContext());
    }

    public final View m17654a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 141934172);
        this.f15216h = (String) Preconditions.checkNotNull(this.s.getString("com.facebook.katana.profile.id"));
        this.am = (GraphQLPhotosByCategoryEntryPoint) this.s.get("local_content_entry_point");
        this.f15210a.a(this.f15214f);
        o().setRequestedOrientation(1);
        if (bundle == null) {
            LocalContentPhotosLogger localContentPhotosLogger = this.f15212c;
            String str = this.f15216h;
            AnalyticsLogger analyticsLogger = localContentPhotosLogger.f14942a;
            HoneyClientEvent honeyClientEvent = new HoneyClientEvent("photos_by_category_impression");
            honeyClientEvent.c = "photos_by_category";
            analyticsLogger.a(honeyClientEvent.b("page_id", str));
        }
        View inflate = layoutInflater.inflate(2130906221, viewGroup, false);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -1349865135, a);
        return inflate;
    }

    public final void m17656a(View view, @Nullable Bundle bundle) {
        super.a(view, bundle);
        this.f15215g = (EmptyListViewItem) e(2131565944);
        this.f15215g.a(true);
        this.f15217i = (TabbedViewPagerIndicator) e(2131565942);
        this.al = (ViewPager) e(2131565943);
        PhotosByCategoryLoader photosByCategoryLoader = this.f15211b;
        String str = this.f15216h;
        GraphQLPhotosByCategoryEntryPoint graphQLPhotosByCategoryEntryPoint = this.am;
        GraphQlQueryString availableCategoriesQueryString = new AvailableCategoriesQueryString();
        availableCategoriesQueryString.a("entry_point", graphQLPhotosByCategoryEntryPoint == null ? null : graphQLPhotosByCategoryEntryPoint.name()).a("page_id", str);
        photosByCategoryLoader.f15196b.a("task_key_load_initial_data" + str, photosByCategoryLoader.f15195a.a(GraphQLRequest.a(availableCategoriesQueryString)), new C16581(photosByCategoryLoader, this));
    }

    public final void mi_() {
        String b;
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -198556622);
        super.mi_();
        String string = this.s.getString("fragment_title");
        if (string == null) {
            b = b(2131239135);
        } else {
            b = string;
        }
        HasTitleBar hasTitleBar = (HasTitleBar) a(HasTitleBar.class);
        if (hasTitleBar != null) {
            hasTitleBar.a_(Strings.nullToEmpty(b));
        }
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -1718078868, a);
    }

    public final void mY_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1787269057);
        super.mY_();
        this.f15210a.b(this.f15214f);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 239829186, a);
    }

    public final String am_() {
        return "photos_by_category";
    }

    public final void m17657a(@Nullable AvailableCategoriesQueryModel availableCategoriesQueryModel) {
        if (availableCategoriesQueryModel == null || availableCategoriesQueryModel.a() == null || availableCategoriesQueryModel.a().a().isEmpty()) {
            aq();
            return;
        }
        this.f15215g.a(false);
        this.f15215g.setVisibility(8);
        this.f15217i.setVisibility(0);
        this.al.setVisibility(0);
        ImmutableList a = availableCategoriesQueryModel.a().a();
        PrimaryCategoryModel c = availableCategoriesQueryModel.a().c();
        int i = 0;
        if (c != null) {
            for (int i2 = 0; i2 < a.size(); i2++) {
                if (((AvailableCategoriesModel) a.get(i2)).a() == c.a()) {
                    i = i2;
                    break;
                }
            }
        }
        int i3 = i;
        this.al.setAdapter(new PhotosByCategoryPagerAdapter(kO_(), f15209e, i3, this.am, availableCategoriesQueryModel.a().b(), this.f15216h, availableCategoriesQueryModel.a().a()));
        this.al.a(i3, false);
        this.f15217i.e_(i3);
        this.f15217i.setViewPager(this.al);
        this.f15217i.l = new C16601(this);
    }

    public final void m17655a() {
        aq();
    }

    private void aq() {
        this.f15215g.setMessage(2131239095);
        this.f15215g.a(false);
    }
}
