package com.facebook.places.create;

import android.content.Context;
import android.content.Intent;
import com.facebook.crowdsourcing.logging.PlaceCreationAnalyticsLogger.View;
import com.facebook.flatbuffers.helpers.FlatBufferModelHelper;
import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.inject.InjectorLike;
import com.facebook.places.create.NewPlaceCreationFormFragment.AnonymousClass11;
import com.facebook.places.create.NewPlaceCreationFormFragment.DedupCallbacks;
import com.facebook.places.future.SimpleExecutor;
import com.facebook.places.graphql.PlacesGraphQLModels.CheckinPlaceModel;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.collect.Lists;
import com.google.common.util.concurrent.FutureCallback;
import java.util.List;
import javax.inject.Inject;

/* compiled from: center */
public class PlaceCreationBellerophonController {
    private final Context f18189a;
    public final BellerophonLogger f18190b;
    public final PlaceCreationDupSearch f18191c;
    public final GatekeeperStoreImpl f18192d;

    /* compiled from: center */
    public class C19751 implements FutureCallback<PlaceCreationDupSearchResults> {
        final /* synthetic */ DedupCallbacks f18186a;
        final /* synthetic */ AnonymousClass11 f18187b;
        final /* synthetic */ PlaceCreationBellerophonController f18188c;

        public C19751(PlaceCreationBellerophonController placeCreationBellerophonController, DedupCallbacks dedupCallbacks, AnonymousClass11 anonymousClass11) {
            this.f18188c = placeCreationBellerophonController;
            this.f18186a = dedupCallbacks;
            this.f18187b = anonymousClass11;
        }

        public void onSuccess(Object obj) {
            PlaceCreationDupSearchResults placeCreationDupSearchResults = (PlaceCreationDupSearchResults) obj;
            if (placeCreationDupSearchResults == null || placeCreationDupSearchResults.m22173b().isEmpty()) {
                this.f18188c.f18190b.m22105e();
                this.f18186a.m22137b();
                return;
            }
            Builder builder = ImmutableList.builder();
            Builder builder2 = ImmutableList.builder();
            for (CheckinPlaceModel checkinPlaceModel : placeCreationDupSearchResults.m22173b()) {
                builder.c(checkinPlaceModel.cf_());
                builder2.c(Long.valueOf(Long.parseLong(checkinPlaceModel.cf_())));
            }
            BellerophonLoggerData bellerophonLoggerData = this.f18188c.f18190b.f18119a;
            String str = placeCreationDupSearchResults.f18218b;
            ImmutableList b = builder.b();
            bellerophonLoggerData.f18124c = str;
            bellerophonLoggerData.f18125d = b;
            DedupCallbacks dedupCallbacks = this.f18186a;
            b = builder2.b();
            dedupCallbacks.f18156a.f18182i.b(dedupCallbacks.f18156a.ay, View.DEDUPER);
            dedupCallbacks.f18156a.an.addAll(b);
            PlaceCreationBellerophonController.m22152a(this.f18188c, this.f18187b, placeCreationDupSearchResults.m22173b());
        }

        public void onFailure(Throwable th) {
            this.f18188c.f18190b.m22106f();
            this.f18186a.m22137b();
        }
    }

    public static PlaceCreationBellerophonController m22153b(InjectorLike injectorLike) {
        return new PlaceCreationBellerophonController((Context) injectorLike.getInstance(Context.class), BellerophonLogger.m22100b(injectorLike), new PlaceCreationDupSearch(SimpleExecutor.b(injectorLike), GraphQLQueryExecutor.a(injectorLike)), GatekeeperStoreImplMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public PlaceCreationBellerophonController(Context context, BellerophonLogger bellerophonLogger, PlaceCreationDupSearch placeCreationDupSearch, GatekeeperStoreImpl gatekeeperStoreImpl) {
        this.f18189a = context;
        this.f18190b = bellerophonLogger;
        this.f18191c = placeCreationDupSearch;
        this.f18192d = gatekeeperStoreImpl;
    }

    public static void m22152a(PlaceCreationBellerophonController placeCreationBellerophonController, AnonymousClass11 anonymousClass11, List list) {
        Intent intent = new Intent(placeCreationBellerophonController.f18189a, PlaceCreationDupActivity.class);
        FlatBufferModelHelper.a(intent, "possible_dup_places", Lists.a(list));
        intent.putExtra("bellerophon_logger_data", placeCreationBellerophonController.f18190b.f18119a);
        NewPlaceCreationFormFragment.aI(anonymousClass11.f18137a);
        anonymousClass11.f18137a.f18175b.a(intent, 1, anonymousClass11.f18137a);
    }

    public static void m22151a(DedupCallbacks dedupCallbacks, int i, Intent intent) {
        if (i != -1) {
            dedupCallbacks.f18156a.f18182i.b(dedupCallbacks.f18156a.ay, View.FORM);
        } else if (intent.getBooleanExtra("continue_place_creation", true)) {
            dedupCallbacks.m22137b();
        } else if (intent.hasExtra("select_existing_place")) {
            CheckinPlaceModel checkinPlaceModel = (CheckinPlaceModel) FlatBufferModelHelper.a(intent, "select_existing_place");
            Preconditions.checkNotNull(checkinPlaceModel);
            NewPlaceCreationFormFragment.m22138a(dedupCallbacks.f18156a, Long.parseLong(checkinPlaceModel.cf_()), checkinPlaceModel.j(), View.DEDUPER);
        }
    }
}
