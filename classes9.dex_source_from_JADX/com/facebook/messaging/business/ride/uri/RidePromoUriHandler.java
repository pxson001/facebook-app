package com.facebook.messaging.business.ride.uri;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.net.Uri;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.query.GraphQlQueryString;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.messages.ipc.MessagingIntentUris;
import com.facebook.messages.links.MessengerLinks;
import com.facebook.messaging.business.common.calltoaction.BusinessUriHandler;
import com.facebook.messaging.business.common.helper.BusinessMessageDialogHelper;
import com.facebook.messaging.business.ride.graphql.RideQueryFragments.RidePromoShareQueryString;
import com.facebook.messaging.business.ride.graphql.RideQueryFragmentsModels.RidePromoShareQueryModel.MessengerCommerceModel.RideProvidersModel.RideInviteModel;
import com.facebook.messaging.business.ride.graphql.RideQueryFragmentsModels.RidePromoShareQueryModel.MessengerCommerceModel.RideProvidersModel.RideInviteModel.ShareImageModel;
import com.facebook.messaging.business.ride.helper.RidePromoShareLoader;
import com.facebook.messaging.business.ride.helper.RidePromoShareLoader.C10662;
import com.facebook.messaging.business.ride.helper.RidePromoShareLoader.RidePromoTask;
import com.facebook.messaging.business.ride.utils.RidePromoShareExtras;
import com.facebook.messaging.cache.DataCache;
import com.facebook.messaging.database.handlers.DbFetchThreadsHandler;
import com.facebook.messaging.model.threadkey.ThreadKey;
import com.facebook.ui.futures.TasksManager;
import com.facebook.ui.media.attachments.MediaResource;
import com.facebook.ui.media.attachments.MediaResource.Source;
import com.facebook.ui.media.attachments.MediaResource.Type;
import com.facebook.ui.media.attachments.MediaResourceBuilder;
import com.google.common.base.Strings;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: mobile_payments_reliability */
public class RidePromoUriHandler extends BusinessUriHandler {
    public final Context f9288a;
    private final SecureContextHelper f9289b;
    private final RidePromoShareLoader f9290c;
    public final BusinessMessageDialogHelper f9291d;

    /* compiled from: mobile_payments_reliability */
    public class C10712 implements OnClickListener {
        final /* synthetic */ String f9284a;
        final /* synthetic */ String f9285b;
        final /* synthetic */ RideInviteModel f9286c;
        final /* synthetic */ RidePromoUriHandler f9287d;

        public C10712(RidePromoUriHandler ridePromoUriHandler, String str, String str2, RideInviteModel rideInviteModel) {
            this.f9287d = ridePromoUriHandler;
            this.f9284a = str;
            this.f9285b = str2;
            this.f9286c = rideInviteModel;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            RidePromoUriHandler.m9757a(this.f9287d, this.f9284a, this.f9285b, this.f9286c);
            dialogInterface.dismiss();
        }
    }

    public static RidePromoUriHandler m9758b(InjectorLike injectorLike) {
        return new RidePromoUriHandler((Context) injectorLike.getInstance(Context.class), (SecureContextHelper) DefaultSecureContextHelper.a(injectorLike), new RidePromoShareLoader(DataCache.a(injectorLike), DbFetchThreadsHandler.m10920a(injectorLike), IdBasedProvider.a(injectorLike, 4442), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike), GraphQLQueryExecutor.a(injectorLike), TasksManager.b(injectorLike)), BusinessMessageDialogHelper.m9018b(injectorLike));
    }

    @Inject
    public RidePromoUriHandler(Context context, SecureContextHelper secureContextHelper, RidePromoShareLoader ridePromoShareLoader, BusinessMessageDialogHelper businessMessageDialogHelper) {
        this.f9288a = context;
        this.f9289b = secureContextHelper;
        this.f9290c = ridePromoShareLoader;
        this.f9291d = businessMessageDialogHelper;
    }

    public final boolean mo329a(Context context, Uri uri, @Nullable ThreadKey threadKey) {
        final String queryParameter = uri.getQueryParameter("provider_name");
        final String queryParameter2 = uri.getQueryParameter("promo_data");
        if (Strings.isNullOrEmpty(queryParameter)) {
            return false;
        }
        RidePromoShareLoader ridePromoShareLoader = this.f9290c;
        C10701 c10701 = new Object(this) {
            public final /* synthetic */ RidePromoUriHandler f9283c;

            public final void m9756a() {
                this.f9283c.f9291d.m9019a();
            }
        };
        GraphQlQueryString ridePromoShareQueryString = new RidePromoShareQueryString();
        ridePromoShareQueryString.a("provider", queryParameter);
        ridePromoShareQueryString.a("promo_data", queryParameter2);
        ridePromoShareLoader.f9249f.a(RidePromoTask.GET_RIDE_PROMO_SHARE, ridePromoShareLoader.f9248e.a(GraphQLRequest.a(ridePromoShareQueryString)), new C10662(ridePromoShareLoader, c10701));
        return true;
    }

    public final String mo330b() {
        return "promo_ride";
    }

    public static void m9757a(RidePromoUriHandler ridePromoUriHandler, String str, String str2, RideInviteModel rideInviteModel) {
        String string;
        MediaResource mediaResource;
        Intent intent = new Intent(MessagingIntentUris.a);
        intent.setData(Uri.parse(MessengerLinks.o));
        intent.putExtra("ShareType", "ShareType.ridePromoShare");
        String str3 = "parcelable_share_extras";
        if (Strings.isNullOrEmpty(rideInviteModel.m9528l())) {
            string = ridePromoUriHandler.f9288a.getString(2131240772);
        } else {
            string = rideInviteModel.m9528l();
        }
        ShareImageModel k = rideInviteModel.m9527k();
        if (k == null) {
            mediaResource = null;
        } else {
            MediaResourceBuilder a = MediaResource.a();
            a.a = Uri.parse(k.m9522a());
            a = a;
            a.c = Source.SHARE;
            a = a;
            a.b = Type.PHOTO;
            mediaResource = a.C();
        }
        MediaResource mediaResource2 = mediaResource;
        if (Strings.isNullOrEmpty(str2)) {
            str2 = "";
        }
        intent.putExtra(str3, new RidePromoShareExtras(str, string, mediaResource2, str2));
        ridePromoUriHandler.f9289b.a(intent, ridePromoUriHandler.f9288a);
    }
}
