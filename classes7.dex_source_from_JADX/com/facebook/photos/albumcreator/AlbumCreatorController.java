package com.facebook.photos.albumcreator;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.widget.Toast;
import com.facebook.auth.viewercontext.ViewerContext;
import com.facebook.composer.privacy.common.ComposerPrivacyData;
import com.facebook.fbservice.ops.OperationResultFutureCallback;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.fbservice.service.ServiceException;
import com.facebook.fbui.dialog.AlertDialog.Builder;
import com.facebook.flatbuffers.helpers.FlatBufferModelHelper;
import com.facebook.graphql.model.GraphQLAlbum;
import com.facebook.ipc.composer.intent.ComposerTargetData;
import com.facebook.ipc.composer.model.TargetType;
import com.facebook.photos.albumcreator.AlbumCreatorFlowLogger.DialogType;
import com.facebook.photos.albums.events.AlbumsEventBus;
import com.facebook.photos.albums.events.AlbumsEvents.AlbumCreatedEvent;
import com.facebook.photos.futures.PhotosFuturesGenerator;
import com.facebook.places.graphql.PlacesGraphQLModels.CheckinPlaceModel;
import com.facebook.ui.dialogs.ProgressDialogFragment;
import com.facebook.ui.futures.TasksManager;
import com.google.common.base.Strings;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Callable;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: match */
public class AlbumCreatorController {
    public AlbumCreatorFlowLogger f9271a;
    private FragmentManager f9272b;
    public PhotosFuturesGenerator f9273c;
    private TasksManager f9274d;
    public ViewerContext f9275e;
    public AlbumsEventBus f9276f;

    /* compiled from: match */
    class C07402 implements OnClickListener {
        final /* synthetic */ AlbumCreatorController f9256a;

        C07402(AlbumCreatorController albumCreatorController) {
            this.f9256a = albumCreatorController;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    /* compiled from: match */
    public class PagesData {
        public final long f9269a;
        public final ViewerContext f9270b;

        public PagesData(long j, ViewerContext viewerContext) {
            this.f9269a = j;
            this.f9270b = viewerContext;
        }
    }

    @Inject
    public AlbumCreatorController(Context context, AlbumCreatorFlowLogger albumCreatorFlowLogger, PhotosFuturesGenerator photosFuturesGenerator, TasksManager tasksManager, ViewerContext viewerContext, AlbumsEventBus albumsEventBus) {
        this.f9271a = albumCreatorFlowLogger;
        this.f9273c = photosFuturesGenerator;
        this.f9274d = tasksManager;
        this.f9272b = ((FragmentActivity) context).kO_();
        this.f9275e = viewerContext;
        this.f9276f = albumsEventBus;
    }

    public final void m11292a(final Activity activity, boolean z) {
        if (z) {
            CharSequence string = activity.getString(2131237846);
            this.f9271a.m11297a(DialogType.CANCELLATION);
            new Builder(activity).a(activity.getString(2131230727)).b(string).b(2131230727, new C07402(this)).a(2131234584, new OnClickListener(this) {
                final /* synthetic */ AlbumCreatorController f9255b;

                public void onClick(DialogInterface dialogInterface, int i) {
                    AlbumCreatorController.m11290a(this.f9255b, activity);
                }
            }).a().show();
            return;
        }
        m11290a(this, activity);
    }

    public final void m11291a(final Activity activity, final String str, String str2, CheckinPlaceModel checkinPlaceModel, ComposerPrivacyData composerPrivacyData, PagesData pagesData, @Nullable ComposerTargetData composerTargetData) {
        final DialogFragment a = ProgressDialogFragment.a(2131237847, true, false);
        a.a(this.f9272b, "progress_dialog");
        C07413 c07413 = new OperationResultFutureCallback(this) {
            final /* synthetic */ AlbumCreatorController f9260d;

            protected final void m11289a(Object obj) {
                OperationResult operationResult = (OperationResult) obj;
                a.b();
                Toast.makeText(activity.getApplicationContext(), activity.getString(2131237534), 0).show();
                this.f9260d.f9271a.m11298a(Strings.isNullOrEmpty(str));
                GraphQLAlbum graphQLAlbum = (GraphQLAlbum) operationResult.g().get("result");
                this.f9260d.f9276f.a(new AlbumCreatedEvent(graphQLAlbum.u()));
                Intent intent = new Intent();
                FlatBufferModelHelper.a(intent, "extra_album", graphQLAlbum);
                activity.setResult(-1, intent);
                activity.finish();
            }

            protected final void m11288a(ServiceException serviceException) {
                a.b();
                Toast.makeText(activity.getApplicationContext(), activity.getString(2131237533), 1).show();
                this.f9260d.f9271a.m11302c(serviceException.getMessage());
            }
        };
        final String string = Strings.isNullOrEmpty(str) ? activity.getString(2131236720) : str;
        final String cf_ = checkinPlaceModel == null ? "" : checkinPlaceModel.cf_();
        final String a2 = composerPrivacyData.m1946a();
        final PagesData pagesData2 = pagesData;
        final String str3 = str2;
        final CheckinPlaceModel checkinPlaceModel2 = checkinPlaceModel;
        final ComposerTargetData composerTargetData2 = composerTargetData;
        this.f9274d.a(Integer.valueOf(10), new Callable<ListenableFuture<OperationResult>>(this) {
            final /* synthetic */ AlbumCreatorController f9268h;

            public Object call() {
                String str = null;
                PhotosFuturesGenerator photosFuturesGenerator;
                long j;
                String str2;
                String str3;
                if (pagesData2 != null) {
                    photosFuturesGenerator = this.f9268h.f9273c;
                    j = pagesData2.f9269a;
                    str2 = string;
                    str3 = str3;
                    if (checkinPlaceModel2 != null) {
                        str = checkinPlaceModel2.j();
                    }
                    return photosFuturesGenerator.m12391a(j, str2, str3, str, pagesData2.f9270b);
                } else if (this.f9268h.f9275e.mIsPageContext) {
                    photosFuturesGenerator = this.f9268h.f9273c;
                    j = Long.parseLong(this.f9268h.f9275e.mUserId);
                    str2 = string;
                    str3 = str3;
                    if (checkinPlaceModel2 != null) {
                        str = checkinPlaceModel2.j();
                    }
                    return photosFuturesGenerator.m12391a(j, str2, str3, str, this.f9268h.f9275e);
                } else {
                    PhotosFuturesGenerator photosFuturesGenerator2 = this.f9268h.f9273c;
                    String str4 = string;
                    String str5 = cf_;
                    String str6 = str3;
                    str2 = a2;
                    str3 = (composerTargetData2 == null || composerTargetData2.targetType != TargetType.GROUP) ? "" : String.valueOf(composerTargetData2.targetId);
                    return photosFuturesGenerator2.m12394a(str4, str5, str6, str2, str3);
                }
            }
        }, c07413);
    }

    public static void m11290a(AlbumCreatorController albumCreatorController, Activity activity) {
        albumCreatorController.f9271a.m11296a();
        activity.setResult(0);
        activity.finish();
    }
}
