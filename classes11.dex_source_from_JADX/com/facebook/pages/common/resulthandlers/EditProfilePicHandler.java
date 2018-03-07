package com.facebook.pages.common.resulthandlers;

import android.content.Context;
import android.content.Intent;
import com.facebook.abtest.qe.bootstrap.framework.QuickExperimentController;
import com.facebook.auth.viewercontext.ViewerContext;
import com.facebook.base.fragment.FbFragment;
import com.facebook.fbservice.ops.DialogBasedProgressIndicator;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.fbservice.service.ServiceException;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.ipc.editgallery.EditGalleryIpcBundle;
import com.facebook.ipc.pages.ProfilePermissions;
import com.facebook.pages.common.resulthandlers.interfaces.ActivityResultHandler;
import com.facebook.pages.common.viewercontextutils.ViewerContextUtil;
import com.facebook.timeline.profilepiccoverphotoupload.ProfilePicUploadHandler;
import com.facebook.ui.toaster.ToastBuilder;
import com.facebook.ui.toaster.Toaster;
import com.google.common.base.Function;
import com.google.common.collect.ImmutableList;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.MoreExecutors;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: saved_collection_ego_item_action_link_clicked */
public class EditProfilePicHandler implements ActivityResultHandler {
    private final Lazy<Toaster> f2269a;
    private final Lazy<QuickExperimentController> f2270b;
    private final Lazy<ViewerContextUtil> f2271c;
    public final Lazy<ProfilePicUploadHandler> f2272d;
    private final Context f2273e;
    private Intent f2274f;

    /* compiled from: saved_collection_ego_item_action_link_clicked */
    class C02831 implements Function<ViewerContext, OperationResult> {
        final /* synthetic */ EditProfilePicHandler f2268a;

        C02831(EditProfilePicHandler editProfilePicHandler) {
            this.f2268a = editProfilePicHandler;
        }

        @Nullable
        public Object apply(@Nullable Object obj) {
            return OperationResult.a((ViewerContext) obj);
        }
    }

    public static EditProfilePicHandler m3223b(InjectorLike injectorLike) {
        return new EditProfilePicHandler(IdBasedLazy.a(injectorLike, 3588), IdBasedSingletonScopeProvider.b(injectorLike, 83), IdBasedLazy.a(injectorLike, 9011), IdBasedLazy.a(injectorLike, 11305), (Context) injectorLike.getInstance(Context.class));
    }

    @Inject
    public EditProfilePicHandler(Lazy<Toaster> lazy, Lazy<QuickExperimentController> lazy2, Lazy<ViewerContextUtil> lazy3, Lazy<ProfilePicUploadHandler> lazy4, Context context) {
        this.f2270b = lazy2;
        this.f2271c = lazy3;
        this.f2272d = lazy4;
        this.f2269a = lazy;
        this.f2273e = context;
    }

    public final ListenableFuture<OperationResult> mo46a(long j, @Nullable ProfilePermissions profilePermissions, FbFragment fbFragment, Intent intent, int i) {
        this.f2274f = intent;
        return Futures.a(((ViewerContextUtil) this.f2271c.get()).a(String.valueOf(j)), new C02831(this), MoreExecutors.a());
    }

    public final void mo47a(OperationResult operationResult) {
        Intent intent = this.f2274f;
        ((ProfilePicUploadHandler) this.f2272d.get()).a((EditGalleryIpcBundle) intent.getParcelableExtra(EditGalleryIpcBundle.a), null, intent.getLongExtra("extra_profile_pic_expiration", 0), intent.getStringExtra("staging_ground_photo_caption"), intent.getStringExtra("profile_photo_method_extra"), (ViewerContext) operationResult.h());
    }

    public final void mo48a(ServiceException serviceException) {
        ((Toaster) this.f2269a.get()).a(new ToastBuilder(this.f2273e.getResources().getString(2131235536)));
    }

    public final boolean mo50c() {
        return true;
    }

    public final ImmutableList<Integer> mo51d() {
        return ImmutableList.of(Integer.valueOf(125));
    }

    public final DialogBasedProgressIndicator mo45a() {
        return new DialogBasedProgressIndicator(this.f2273e, 2131235433);
    }

    public final boolean mo49b() {
        return false;
    }
}
