package com.facebook.timeline.editfeaturedcontainers.ui;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.base.activity.FbFragmentActivity;
import com.facebook.common.executors.ForUiThread;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.common.util.StringUtil;
import com.facebook.content.SecureContextHelper;
import com.facebook.fbui.dialog.ProgressDialog;
import com.facebook.flatbuffers.helpers.FlatBufferModelHelper;
import com.facebook.graphql.calls.ProfileIntroCardAddFeaturedContainerInputData;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.graphql.model.GraphQLPhoto;
import com.facebook.graphql.query.GraphQlQueryString;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.Lazy;
import com.facebook.ipc.editgallery.EditGalleryIpcBundle;
import com.facebook.ipc.media.MediaItem;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.photos.upload.protocol.UploadPhotoParams.Builder;
import com.facebook.photos.upload.protocol.UploadPhotoSource;
import com.facebook.timeline.editfeaturedcontainers.protocol.AddFeaturedContainerMutation.AddFeaturedContainerMutationString;
import com.facebook.timeline.editfeaturedcontainers.protocol.AddFeaturedContainerMutationModels.AddFeaturedContainerMutationModel;
import com.facebook.timeline.editfeaturedcontainers.ui.views.FeaturedContainersSearchEditText;
import com.facebook.timeline.editfeaturedcontainers.utils.SaveFeaturedContainerController;
import com.facebook.timeline.editfeaturedcontainers.utils.StagingGroundIntentCreator;
import com.facebook.timeline.editfeaturedcontainers.utils.UploadFeaturedPhotoController;
import com.facebook.timeline.editfeaturedcontainers.utils.UploadFeaturedPhotoController.C15941;
import com.facebook.timeline.editfeaturedcontainers.utils.UploadFeaturedPhotoController.C15952;
import com.facebook.tools.dextr.runtime.detour.ExecutorDetour;
import com.facebook.ui.search.SearchEditText.OnSubmitListener;
import com.facebook.ui.toaster.ToastBuilder;
import com.facebook.ui.toaster.Toaster;
import com.facebook.widget.titlebar.FbTitleBar;
import com.facebook.widget.titlebar.FbTitleBarUtil;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.SettableFuture;
import java.util.List;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: geofence_start_time_ms */
public class AddFeaturedContainerActivity extends FbFragmentActivity {
    @Inject
    Provider<SecureContextHelper> f10916p;
    @Inject
    Provider<UploadFeaturedPhotoController> f10917q;
    @Inject
    Provider<SaveFeaturedContainerController> f10918r;
    @Inject
    @ForUiThread
    Executor f10919s;
    @Inject
    Lazy<Toaster> f10920t;

    /* compiled from: geofence_start_time_ms */
    class C15791 implements OnClickListener {
        final /* synthetic */ AddFeaturedContainerActivity f10908a;

        C15791(AddFeaturedContainerActivity addFeaturedContainerActivity) {
            this.f10908a = addFeaturedContainerActivity;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 1950490904);
            this.f10908a.setResult(0);
            this.f10908a.finish();
            Logger.a(2, EntryType.UI_INPUT_END, -794839627, a);
        }
    }

    private static <T extends Context> void m11028a(Class<T> cls, T t) {
        m11029a((Object) t, (Context) t);
    }

    public static void m11029a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((AddFeaturedContainerActivity) obj).m11032a(IdBasedSingletonScopeProvider.a(fbInjector, 968), IdBasedProvider.a(fbInjector, 11213), IdBasedProvider.a(fbInjector, 11212), (Executor) ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.a(fbInjector), IdBasedLazy.a(fbInjector, 3588));
    }

    private void m11032a(Provider<SecureContextHelper> provider, Provider<UploadFeaturedPhotoController> provider2, Provider<SaveFeaturedContainerController> provider3, Executor executor, Lazy<Toaster> lazy) {
        this.f10916p = provider;
        this.f10917q = provider2;
        this.f10918r = provider3;
        this.f10919s = executor;
        this.f10920t = lazy;
    }

    protected final void m11037b(@Nullable Bundle bundle) {
        super.b(bundle);
        Class cls = AddFeaturedContainerActivity.class;
        m11029a((Object) this, (Context) this);
        setContentView(2130903160);
        m11034i();
        m11035j();
        if (bundle == null) {
            kO_().a().a(2131559363, new NullStateFragment()).b();
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (i2 == -1) {
            List parcelableArrayList;
            switch (i) {
                case 1:
                    parcelableArrayList = intent.getExtras().getParcelableArrayList("extra_media_items");
                    if (parcelableArrayList == null || parcelableArrayList.isEmpty()) {
                        GraphQLPhoto graphQLPhoto = (GraphQLPhoto) FlatBufferModelHelper.a(intent.getExtras(), "photo");
                        if (graphQLPhoto != null) {
                            m11033a(true, null, graphQLPhoto.K());
                            return;
                        }
                        return;
                    }
                    m11033a(true, ((MediaItem) parcelableArrayList.get(0)).f(), null);
                    return;
                case 2:
                    parcelableArrayList = intent.getExtras().getParcelableArrayList("extra_media_items");
                    if (parcelableArrayList != null && !parcelableArrayList.isEmpty()) {
                        m11033a(true, ((MediaItem) parcelableArrayList.get(0)).f(), null);
                        return;
                    }
                    return;
                case 3:
                    m11031a(intent.getExtras().getString("picked_photo_fbid"), intent.getStringExtra("staging_ground_photo_caption"), m11036k());
                    return;
                case 4:
                    EditGalleryIpcBundle editGalleryIpcBundle = (EditGalleryIpcBundle) intent.getParcelableExtra(EditGalleryIpcBundle.a);
                    String stringExtra = intent.getStringExtra("staging_ground_photo_caption");
                    intent.getBooleanExtra("staging_ground_post_to_news_feed", false);
                    m11030a(editGalleryIpcBundle.b.getPath(), stringExtra);
                    return;
                default:
                    return;
            }
        }
    }

    private void m11034i() {
        FbTitleBarUtil.b(this);
        ((FbTitleBar) a(2131558563)).a(new C15791(this));
    }

    private void m11035j() {
        final FeaturedContainersSearchEditText featuredContainersSearchEditText = (FeaturedContainersSearchEditText) findViewById(2131559362);
        featuredContainersSearchEditText.f = new OnSubmitListener(this) {
            final /* synthetic */ AddFeaturedContainerActivity f10910b;

            public final void m11024a() {
                String obj = featuredContainersSearchEditText.getText().toString();
                if (!StringUtil.c(obj)) {
                    ((SecureContextHelper) this.f10910b.f10916p.get()).a(AddFeaturedEntityActivity.m11049a(this.f10910b, obj), 3, this.f10910b);
                }
            }
        };
    }

    private void m11033a(boolean z, @Nullable Uri uri, @Nullable String str) {
        ((SecureContextHelper) this.f10916p.get()).a(StagingGroundIntentCreator.m11093a(this, z, uri, str), 4, this);
    }

    private void m11030a(String str, final String str2) {
        final ProgressDialog k = m11036k();
        UploadFeaturedPhotoController uploadFeaturedPhotoController = (UploadFeaturedPhotoController) this.f10917q.get();
        SettableFuture f = SettableFuture.f();
        ExecutorDetour.a(uploadFeaturedPhotoController.f10980d, new C15952(uploadFeaturedPhotoController, new Builder(new UploadPhotoSource(str, 0)).a(), new C15941(uploadFeaturedPhotoController, f), f), -277182132);
        Futures.a(f, new FutureCallback<String>(this) {
            final /* synthetic */ AddFeaturedContainerActivity f10913c;

            public void onSuccess(Object obj) {
                this.f10913c.m11031a((String) obj, str2, k);
            }

            public void onFailure(Throwable th) {
                this.f10913c.m11025a(k);
            }
        }, this.f10919s);
    }

    private void m11031a(String str, String str2, final ProgressDialog progressDialog) {
        SaveFeaturedContainerController saveFeaturedContainerController = (SaveFeaturedContainerController) this.f10918r.get();
        ProfileIntroCardAddFeaturedContainerInputData profileIntroCardAddFeaturedContainerInputData = new ProfileIntroCardAddFeaturedContainerInputData();
        profileIntroCardAddFeaturedContainerInputData.a("cover_media_id", str);
        profileIntroCardAddFeaturedContainerInputData.a("title", str2);
        GraphQlQueryString addFeaturedContainerMutationString = new AddFeaturedContainerMutationString();
        addFeaturedContainerMutationString.a("input", profileIntroCardAddFeaturedContainerInputData);
        Futures.a(saveFeaturedContainerController.f10970a.a(GraphQLRequest.a(addFeaturedContainerMutationString)), new FutureCallback<GraphQLResult<AddFeaturedContainerMutationModel>>(this) {
            final /* synthetic */ AddFeaturedContainerActivity f10915b;

            public void onSuccess(Object obj) {
                progressDialog.dismiss();
                this.f10915b.setResult(-1);
                this.f10915b.finish();
            }

            public void onFailure(Throwable th) {
                this.f10915b.m11025a(progressDialog);
            }
        }, this.f10919s);
    }

    private ProgressDialog m11036k() {
        return ProgressDialog.a(this, null, getString(2131241395), true);
    }

    private void m11025a(ProgressDialog progressDialog) {
        progressDialog.dismiss();
        ((Toaster) this.f10920t.get()).b(new ToastBuilder(2131241393));
        setResult(0);
        finish();
    }
}
