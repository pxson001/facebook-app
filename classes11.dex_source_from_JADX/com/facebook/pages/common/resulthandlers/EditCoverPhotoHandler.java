package com.facebook.pages.common.resulthandlers;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.facebook.abtest.qe.bootstrap.framework.QuickExperimentController;
import com.facebook.auth.viewercontext.ViewerContext;
import com.facebook.base.fragment.FbFragment;
import com.facebook.common.fragmentconstants.FragmentConstants.ContentFragmentType;
import com.facebook.content.SecureContextHelper;
import com.facebook.fbservice.ops.DialogBasedProgressIndicator;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.fbservice.service.ServiceException;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.ipc.media.MediaItem;
import com.facebook.ipc.pages.ProfilePermissions;
import com.facebook.pages.common.resulthandlers.interfaces.ActivityResultHandler;
import com.facebook.pages.common.viewercontextutils.ViewerContextUtil;
import com.facebook.timeline.coverphoto.activity.CoverPhotoRepositionActivity;
import com.facebook.ui.toaster.ToastBuilder;
import com.facebook.ui.toaster.Toaster;
import com.google.common.base.Function;
import com.google.common.collect.ImmutableList;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.MoreExecutors;
import java.util.ArrayList;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: saved_collection_ego_item_image_clicked */
public class EditCoverPhotoHandler implements ActivityResultHandler {
    private final Lazy<Toaster> f2261a;
    private final Lazy<QuickExperimentController> f2262b;
    private final Lazy<ViewerContextUtil> f2263c;
    public final Lazy<SecureContextHelper> f2264d;
    public final Context f2265e;
    public long f2266f;
    private String f2267g;

    /* compiled from: saved_collection_ego_item_image_clicked */
    class C02821 implements Function<ViewerContext, OperationResult> {
        final /* synthetic */ EditCoverPhotoHandler f2260a;

        C02821(EditCoverPhotoHandler editCoverPhotoHandler) {
            this.f2260a = editCoverPhotoHandler;
        }

        @Nullable
        public Object apply(@Nullable Object obj) {
            return OperationResult.a((ViewerContext) obj);
        }
    }

    public static EditCoverPhotoHandler m3215b(InjectorLike injectorLike) {
        return new EditCoverPhotoHandler(IdBasedLazy.a(injectorLike, 3588), IdBasedSingletonScopeProvider.b(injectorLike, 83), IdBasedLazy.a(injectorLike, 9011), IdBasedSingletonScopeProvider.b(injectorLike, 968), (Context) injectorLike.getInstance(Context.class));
    }

    @Inject
    public EditCoverPhotoHandler(Lazy<Toaster> lazy, Lazy<QuickExperimentController> lazy2, Lazy<ViewerContextUtil> lazy3, Lazy<SecureContextHelper> lazy4, Context context) {
        this.f2262b = lazy2;
        this.f2263c = lazy3;
        this.f2264d = lazy4;
        this.f2261a = lazy;
        this.f2265e = context;
    }

    public final ListenableFuture<OperationResult> mo46a(long j, @Nullable ProfilePermissions profilePermissions, FbFragment fbFragment, Intent intent, int i) {
        this.f2266f = j;
        ArrayList parcelableArrayListExtra = intent.getParcelableArrayListExtra("extra_media_items");
        if (parcelableArrayListExtra == null || parcelableArrayListExtra.isEmpty()) {
            return null;
        }
        this.f2267g = ((MediaItem) parcelableArrayListExtra.get(0)).e();
        return Futures.a(((ViewerContextUtil) this.f2263c.get()).a(String.valueOf(j)), new C02821(this), MoreExecutors.a());
    }

    public final void mo47a(OperationResult operationResult) {
        String str = this.f2267g;
        ViewerContext viewerContext = (ViewerContext) operationResult.h();
        Intent intent = new Intent(this.f2265e, CoverPhotoRepositionActivity.class);
        intent.putExtra("cover_photo_uri", str);
        intent.putExtra("target_fragment", ContentFragmentType.PMA_COVERPHOTO_FRAGMENT.ordinal());
        intent.putExtra("com.facebook.orca.auth.OVERRIDDEN_VIEWER_CONTEXT", viewerContext);
        intent.putExtra("profile_id", this.f2266f);
        ((SecureContextHelper) this.f2264d.get()).a(intent, 127, (Activity) this.f2265e);
    }

    public final void mo48a(ServiceException serviceException) {
        ((Toaster) this.f2261a.get()).a(new ToastBuilder(this.f2265e.getResources().getString(2131235536)));
    }

    public final boolean mo50c() {
        return true;
    }

    public final ImmutableList<Integer> mo51d() {
        return ImmutableList.of(Integer.valueOf(124));
    }

    public final DialogBasedProgressIndicator mo45a() {
        return new DialogBasedProgressIndicator(this.f2265e, 2131235433);
    }

    public final boolean mo49b() {
        return false;
    }
}
