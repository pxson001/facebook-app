package com.facebook.composer.location;

import android.location.Location;
import android.util.Pair;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.composer.activity.ComposerDataProviderImpl;
import com.facebook.composer.activity.ComposerFragment;
import com.facebook.composer.activity.ComposerFragment.AnonymousClass30;
import com.facebook.composer.analytics.ComposerLocationProductsPresenterLogger;
import com.facebook.composer.analytics.ComposerLocationProductsPresenterLogger.Mode;
import com.facebook.composer.analytics.ComposerLocationProductsPresenterLogger.Stats;
import com.facebook.composer.attachments.AttachmentUtils;
import com.facebook.composer.attachments.ComposerAttachment.ProvidesAttachments;
import com.facebook.composer.attachments.MediaItemMetaDataExtractor;
import com.facebook.debug.log.BLog;
import com.facebook.inject.Assisted;
import com.facebook.inject.Lazy;
import com.facebook.ipc.composer.dataaccessor.ComposerBasicDataProviders.ProvidesIsCheckinSupported;
import com.facebook.ipc.composer.dataaccessor.ComposerBasicDataProviders.ProvidesSessionId;
import com.facebook.ipc.composer.intent.ComposerConfiguration;
import com.facebook.ipc.composer.intent.ComposerConfigurationSpec.ProvidesConfiguration;
import com.facebook.ipc.composer.model.ComposerLocation;
import com.facebook.ipc.composer.model.ComposerLocationInfo;
import com.facebook.ipc.composer.model.ComposerLocationInfo.Builder;
import com.facebook.ipc.composer.model.ComposerLocationInfo.ProvidesLocationInfo;
import com.facebook.ipc.katana.model.GeoRegion.ImplicitLocation;
import com.facebook.location.FbLocationStatus.State;
import com.facebook.location.FbLocationStatusUtil;
import com.facebook.location.ImmutableLocation;
import com.facebook.places.checkin.ipc.CheckinComposerEntryPoint;
import com.facebook.places.checkin.ipc.SearchType;
import com.facebook.places.checkin.models.SearchResults;
import com.facebook.places.checkin.protocol.CheckinLocationCache;
import com.facebook.places.checkin.protocol.CheckinSearchResultsLoader;
import com.facebook.places.checkin.protocol.PlacePickerFetchParams;
import com.facebook.places.graphql.PlacesGraphQLModels.CheckinPlaceModel;
import com.facebook.places.graphql.PlacesGraphQLModels.CheckinSearchQueryModel.ClosestCityModel;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.PrefKey;
import com.facebook.prefs.shared.SharedPrefKeys;
import com.facebook.tagging.conversion.FriendSuggestionsRunner;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.util.concurrent.FutureCallback;
import java.util.List;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: fundraiser_campaign_fragment_fetch_fail */
public class ComposerLocationProductsPresenter<DataProvider extends ProvidesAttachments & ProvidesIsCheckinSupported & ProvidesSessionId & ProvidesConfiguration & ProvidesLocationInfo> {
    public static final Class<?> f6670a = ComposerLocationProductsPresenter.class;
    public static final PrefKey f6671b = ((PrefKey) SharedPrefKeys.a.a("composer_share_location"));
    public final CheckinLocationCache f6672c;
    private final FbLocationStatusUtil f6673d;
    public final ComposerLocationProductsPresenterLogger f6674e;
    public final Lazy<CheckinSearchResultsLoader> f6675f;
    private final FriendSuggestionsRunner f6676g;
    private final DataProvider f6677h;
    public final AnonymousClass30 f6678i;
    public final FbSharedPreferences f6679j;
    private final Lazy<MediaItemMetaDataExtractor> f6680k;
    public Location f6681l;
    public boolean f6682m;

    @Inject
    public ComposerLocationProductsPresenter(@Assisted DataProvider dataProvider, @Assisted Listener listener, CheckinLocationCache checkinLocationCache, FbLocationStatusUtil fbLocationStatusUtil, FriendSuggestionsRunner friendSuggestionsRunner, ComposerLocationProductsPresenterLogger composerLocationProductsPresenterLogger, Lazy<CheckinSearchResultsLoader> lazy, FbSharedPreferences fbSharedPreferences, Lazy<MediaItemMetaDataExtractor> lazy2) {
        this.f6677h = dataProvider;
        this.f6678i = listener;
        this.f6672c = checkinLocationCache;
        this.f6673d = fbLocationStatusUtil;
        this.f6676g = friendSuggestionsRunner;
        this.f6675f = lazy;
        this.f6674e = composerLocationProductsPresenterLogger;
        this.f6679j = fbSharedPreferences;
        this.f6680k = lazy2;
    }

    private boolean m8100a(DataProvider dataProvider) {
        return !((ProvidesConfiguration) dataProvider).o().getInitialLocationInfo().k() && ((ComposerDataProviderImpl) this.f6677h).m7400A();
    }

    public final void m8101a() {
        if (!m8100a(this.f6677h)) {
            return;
        }
        if (((ProvidesLocationInfo) this.f6677h).g() == null || ((ProvidesLocationInfo) this.f6677h).g().a() == null) {
            Preconditions.checkNotNull(this.f6678i);
            this.f6674e.d = ((ProvidesSessionId) this.f6677h).ab();
            Location a = AttachmentUtils.a(this.f6677h.m(), (MediaItemMetaDataExtractor) this.f6680k.get());
            if (a != null) {
                m8099a(this, a, true);
            }
            this.f6676g.a(null, null);
            if (this.f6673d.b().a == State.OKAY) {
                boolean z;
                if (this.f6682m || a != null) {
                    z = false;
                } else {
                    z = true;
                }
                final boolean z2 = z;
                this.f6674e.a(Mode.REQUESTED);
                ((CheckinSearchResultsLoader) this.f6675f.get()).a(new FutureCallback<ImmutableLocation>(this) {
                    final /* synthetic */ ComposerLocationProductsPresenter f6667b;

                    public void onSuccess(Object obj) {
                        ImmutableLocation immutableLocation = (ImmutableLocation) obj;
                        this.f6667b.f6674e.a(Mode.SUCCEEDED);
                        this.f6667b.f6681l = immutableLocation.l();
                        this.f6667b.f6672c.b = this.f6667b.f6681l;
                        this.f6667b.f6678i.f6061a.aU.m7630b(ComposerFragment.cn).m7675a(ComposerLocation.a(this.f6667b.f6681l)).m7689a();
                        if (z2) {
                            ComposerLocationProductsPresenter.m8099a(this.f6667b, this.f6667b.f6681l, false);
                        }
                    }

                    public void onFailure(Throwable th) {
                        BLog.a(ComposerLocationProductsPresenter.f6670a, "Location not received", th);
                        this.f6667b.f6674e.a(Mode.FAILED);
                    }
                });
            }
        }
    }

    public final void m8102a(boolean z) {
        this.f6674e.d = ((ProvidesSessionId) this.f6677h).ab();
        ComposerLocationProductsPresenterLogger composerLocationProductsPresenterLogger = this.f6674e;
        Stats.a(composerLocationProductsPresenterLogger.c, "location_pin_clicked_" + (z ? "use_prefixed_location" : "use_device_location"));
        Stats stats = composerLocationProductsPresenterLogger.c;
        HoneyClientEvent honeyClientEvent = new HoneyClientEvent("composer_location_pin_clicked_stats");
        honeyClientEvent.f = stats.a.d;
        HoneyClientEvent honeyClientEvent2 = honeyClientEvent;
        for (Pair pair : stats.b) {
            honeyClientEvent2.a((String) pair.first, pair.second);
        }
        stats.a.a.a(honeyClientEvent2);
        stats.b.clear();
    }

    public static void m8099a(ComposerLocationProductsPresenter composerLocationProductsPresenter, Location location, final boolean z) {
        CheckinComposerEntryPoint checkinComposerEntryPoint;
        PlacePickerFetchParams placePickerFetchParams;
        composerLocationProductsPresenter.f6674e.a(z, Mode.REQUESTED);
        CheckinComposerEntryPoint checkinComposerEntryPoint2 = CheckinComposerEntryPoint.Status;
        ComposerConfiguration o = ((ProvidesConfiguration) composerLocationProductsPresenter.f6677h).o();
        if (o != null) {
            if (o.getInitialLocationInfo().d()) {
                checkinComposerEntryPoint = CheckinComposerEntryPoint.Checkin;
            } else if (!o.getInitialAttachments().isEmpty()) {
                checkinComposerEntryPoint = CheckinComposerEntryPoint.Photo;
            }
            placePickerFetchParams = new PlacePickerFetchParams();
            placePickerFetchParams.b = location;
            placePickerFetchParams = placePickerFetchParams;
            placePickerFetchParams.c = SearchType.STATUS;
            placePickerFetchParams = placePickerFetchParams;
            placePickerFetchParams.d = z;
            placePickerFetchParams = placePickerFetchParams;
            placePickerFetchParams.g = checkinComposerEntryPoint;
            ((CheckinSearchResultsLoader) composerLocationProductsPresenter.f6675f.get()).a(placePickerFetchParams, new FutureCallback<SearchResults>(composerLocationProductsPresenter) {
                final /* synthetic */ ComposerLocationProductsPresenter f6669b;

                public void onSuccess(@Nullable Object obj) {
                    SearchResults searchResults = (SearchResults) obj;
                    this.f6669b.f6674e.a(z, Mode.SUCCEEDED);
                    AnonymousClass30 anonymousClass30 = this.f6669b.f6678i;
                    if (searchResults != null) {
                        Builder a = ComposerLocationInfo.a(anonymousClass30.f6061a.aS.m7431g());
                        List<CheckinPlaceModel> list = searchResults.b;
                        ImmutableList.Builder builder = new ImmutableList.Builder();
                        for (CheckinPlaceModel a2 : list) {
                            builder.c(CheckinPlaceModel.a(a2));
                        }
                        a.g = builder.b();
                        a = a;
                        a.i = searchResults.c;
                        a = a;
                        if (anonymousClass30.f6061a.bH.f6679j.a(ComposerLocationProductsPresenter.f6671b, false) && !anonymousClass30.f6061a.aS.m7431g().e()) {
                            ClosestCityModel closestCityModel = searchResults.i;
                            if (!(closestCityModel == null || anonymousClass30.f6061a.aS.m7439o().isEdit())) {
                                a.f = ImplicitLocation.a(closestCityModel.c(), Long.parseLong(closestCityModel.b())).a();
                            }
                        }
                        anonymousClass30.f6061a.aU.m7630b(ComposerFragment.cn).m7692b(a.b()).m7689a();
                    }
                }

                public void onFailure(Throwable th) {
                    this.f6669b.f6674e.a(z, Mode.FAILED);
                }
            });
        }
        checkinComposerEntryPoint = checkinComposerEntryPoint2;
        placePickerFetchParams = new PlacePickerFetchParams();
        placePickerFetchParams.b = location;
        placePickerFetchParams = placePickerFetchParams;
        placePickerFetchParams.c = SearchType.STATUS;
        placePickerFetchParams = placePickerFetchParams;
        placePickerFetchParams.d = z;
        placePickerFetchParams = placePickerFetchParams;
        placePickerFetchParams.g = checkinComposerEntryPoint;
        ((CheckinSearchResultsLoader) composerLocationProductsPresenter.f6675f.get()).a(placePickerFetchParams, /* anonymous class already generated */);
    }

    public final void m8103c(boolean z) {
        this.f6679j.edit().putBoolean(f6671b, z).commit();
    }
}
