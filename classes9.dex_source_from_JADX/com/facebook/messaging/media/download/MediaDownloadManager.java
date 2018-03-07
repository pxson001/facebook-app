package com.facebook.messaging.media.download;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.os.Parcelable;
import android.widget.Toast;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.fbservice.ops.BlueServiceOperationFactory;
import com.facebook.fbservice.ops.DefaultBlueServiceOperationFactory;
import com.facebook.fbservice.ops.ErrorPropagation;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.messaging.attachments.AttachmentDataFactory;
import com.facebook.messaging.attachments.ImageAttachmentData;
import com.facebook.messaging.attachments.VideoAttachmentData;
import com.facebook.messaging.model.messages.Message;
import com.facebook.messaging.model.messages.MessageUtil;
import com.facebook.messaging.photos.service.MediaMessageItem;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferences.Editor;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.runtimepermissions.RuntimePermissionsUtil;
import com.facebook.tools.dextr.runtime.detour.BlueServiceOperationFactoryDetour;
import com.facebook.ui.dialogs.FbAlertDialogBuilder;
import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.MoreExecutors;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;

@ContextScoped
/* compiled from: mFallbackMSite */
public class MediaDownloadManager {
    private static MediaDownloadManager f11526h;
    private static final Object f11527i = new Object();
    public final Context f11528a;
    public final DefaultBlueServiceOperationFactory f11529b;
    private final Provider<Boolean> f11530c;
    public final FbSharedPreferences f11531d;
    private final AttachmentDataFactory f11532e;
    public final ExecutorService f11533f;
    private final RuntimePermissionsUtil f11534g;

    /* compiled from: mFallbackMSite */
    class C12881 implements Function<OperationResult, DownloadedMedia> {
        final /* synthetic */ MediaDownloadManager f11517a;

        C12881(MediaDownloadManager mediaDownloadManager) {
            this.f11517a = mediaDownloadManager;
        }

        public Object apply(@Nullable Object obj) {
            OperationResult operationResult = (OperationResult) obj;
            boolean z = true;
            Preconditions.checkNotNull(operationResult);
            ArrayList i = operationResult.i();
            if (i.size() != 1) {
                z = false;
            }
            Preconditions.checkArgument(z);
            return (DownloadedMedia) i.get(0);
        }
    }

    /* compiled from: mFallbackMSite */
    class C12892 implements Function<OperationResult, DownloadedMedia> {
        final /* synthetic */ MediaDownloadManager f11518a;

        C12892(MediaDownloadManager mediaDownloadManager) {
            this.f11518a = mediaDownloadManager;
        }

        public Object apply(@Nullable Object obj) {
            OperationResult operationResult = (OperationResult) obj;
            Preconditions.checkNotNull(operationResult);
            DownloadedMedia downloadedMedia = (DownloadedMedia) operationResult.h();
            Preconditions.checkArgument(downloadedMedia != null);
            return downloadedMedia;
        }
    }

    /* compiled from: mFallbackMSite */
    public class C12903 implements Function<OperationResult, DownloadedMedia> {
        final /* synthetic */ MediaDownloadManager f11519a;

        public C12903(MediaDownloadManager mediaDownloadManager) {
            this.f11519a = mediaDownloadManager;
        }

        public Object apply(@Nullable Object obj) {
            OperationResult operationResult = (OperationResult) obj;
            Preconditions.checkNotNull(operationResult);
            return (DownloadedMedia) operationResult.h();
        }
    }

    /* compiled from: mFallbackMSite */
    class C12914 implements FutureCallback<DownloadedMedia> {
        final /* synthetic */ MediaDownloadManager f11520a;

        C12914(MediaDownloadManager mediaDownloadManager) {
            this.f11520a = mediaDownloadManager;
        }

        public void onSuccess(Object obj) {
            int i;
            switch (((DownloadedMedia) obj).f11515a) {
                case DOWNLOADED:
                    i = 2131231645;
                    break;
                case PRE_EXISTING:
                    i = 2131231646;
                    break;
                case FAILURE:
                    i = 2131231647;
                    break;
                default:
                    i = 0;
                    break;
            }
            Toast.makeText(this.f11520a.f11528a, i, 0).show();
        }

        public void onFailure(Throwable th) {
            Toast.makeText(this.f11520a.f11528a, 2131231647, 0).show();
        }
    }

    /* compiled from: mFallbackMSite */
    public class C12925 implements FutureCallback<DownloadedMedia> {
        final /* synthetic */ MediaDownloadManager f11521a;

        public C12925(MediaDownloadManager mediaDownloadManager) {
            this.f11521a = mediaDownloadManager;
        }

        public void onSuccess(Object obj) {
            Toast.makeText(this.f11521a.f11528a, 2131231642, 0).show();
        }

        public void onFailure(Throwable th) {
            Toast.makeText(this.f11521a.f11528a, 2131231643, 0).show();
        }
    }

    /* compiled from: mFallbackMSite */
    class C12936 implements FutureCallback<DownloadedMedia> {
        final /* synthetic */ MediaDownloadManager f11522a;

        C12936(MediaDownloadManager mediaDownloadManager) {
            this.f11522a = mediaDownloadManager;
        }

        public void onSuccess(Object obj) {
            int i;
            switch (((DownloadedMedia) obj).f11515a) {
                case DOWNLOADED:
                    i = 2131231649;
                    break;
                case PRE_EXISTING:
                    i = 2131231650;
                    break;
                case FAILURE:
                    i = 2131231743;
                    break;
                default:
                    i = 0;
                    break;
            }
            Toast.makeText(this.f11522a.f11528a, i, 0).show();
        }

        public void onFailure(Throwable th) {
            Toast.makeText(this.f11522a.f11528a, 2131231743, 0).show();
        }
    }

    /* compiled from: mFallbackMSite */
    class C12947 implements OnClickListener {
        final /* synthetic */ MediaDownloadManager f11523a;

        C12947(MediaDownloadManager mediaDownloadManager) {
            this.f11523a = mediaDownloadManager;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            dialogInterface.dismiss();
        }
    }

    /* compiled from: mFallbackMSite */
    class C12958 implements OnClickListener {
        final /* synthetic */ MediaDownloadManager f11524a;

        C12958(MediaDownloadManager mediaDownloadManager) {
            this.f11524a = mediaDownloadManager;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            Editor edit = this.f11524a.f11531d.edit();
            edit.putBoolean(MediaDownloadPrefKeys.f11537c, true);
            edit.commit();
            dialogInterface.dismiss();
        }
    }

    private static MediaDownloadManager m12173b(InjectorLike injectorLike) {
        return new MediaDownloadManager((Context) injectorLike.getInstance(Context.class), IdBasedProvider.a(injectorLike, 4081), (FbSharedPreferences) FbSharedPreferencesImpl.a(injectorLike), DefaultBlueServiceOperationFactory.b(injectorLike), AttachmentDataFactory.a(injectorLike), (ExecutorService) ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.a(injectorLike), RuntimePermissionsUtil.b(injectorLike));
    }

    public static MediaDownloadManager m12170a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            MediaDownloadManager b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f11527i) {
                MediaDownloadManager mediaDownloadManager;
                if (a2 != null) {
                    mediaDownloadManager = (MediaDownloadManager) a2.a(f11527i);
                } else {
                    mediaDownloadManager = f11526h;
                }
                if (mediaDownloadManager == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m12173b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f11527i, b3);
                        } else {
                            f11526h = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = mediaDownloadManager;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Inject
    public MediaDownloadManager(Context context, Provider<Boolean> provider, FbSharedPreferences fbSharedPreferences, BlueServiceOperationFactory blueServiceOperationFactory, AttachmentDataFactory attachmentDataFactory, ExecutorService executorService, RuntimePermissionsUtil runtimePermissionsUtil) {
        this.f11528a = context;
        this.f11530c = provider;
        this.f11531d = fbSharedPreferences;
        this.f11529b = blueServiceOperationFactory;
        this.f11532e = attachmentDataFactory;
        this.f11533f = executorService;
        this.f11534g = runtimePermissionsUtil;
    }

    public final ListenableFuture<DownloadedMedia> m12176a(DownloadPhotosParams downloadPhotosParams, CallerContext callerContext) {
        Bundle bundle = new Bundle();
        bundle.putParcelable("downloadPhotosParams", downloadPhotosParams);
        return Futures.a(BlueServiceOperationFactoryDetour.a(this.f11529b, "photo_download", bundle, ErrorPropagation.BY_EXCEPTION, callerContext, 192862584).a(), new C12881(this), MoreExecutors.a());
    }

    public final ListenableFuture<DownloadedMedia> m12177a(SaveMmsPhotoParams saveMmsPhotoParams, CallerContext callerContext) {
        Bundle bundle = new Bundle();
        bundle.putParcelable("saveMmsPhotoParams", saveMmsPhotoParams);
        return Futures.a(BlueServiceOperationFactoryDetour.a(this.f11529b, "save_mms_photo", bundle, ErrorPropagation.BY_EXCEPTION, callerContext, -1649855668).a(), new C12892(this), MoreExecutors.a());
    }

    public final void m12179a(ImmutableList<Message> immutableList) {
        if (((Boolean) this.f11530c.get()).booleanValue() && this.f11531d.a(MediaDownloadPrefKeys.f11537c, false)) {
            Builder builder = ImmutableList.builder();
            int size = immutableList.size();
            for (int i = 0; i < size; i++) {
                Message message = (Message) immutableList.get(i);
                if (!MessageUtil.V(message)) {
                    builder.c(message);
                }
            }
            ImmutableList b = builder.b();
            if (!b.isEmpty()) {
                if (this.f11534g.a("android.permission.WRITE_EXTERNAL_STORAGE")) {
                    Parcelable downloadPhotosParams = new DownloadPhotosParams(m12174c(b), PhotoDownloadDestination.GALLERY, true);
                    Bundle bundle = new Bundle();
                    bundle.putParcelable("downloadPhotosParams", downloadPhotosParams);
                    BlueServiceOperationFactoryDetour.a(this.f11529b, "photo_download", bundle, ErrorPropagation.BY_EXCEPTION, CallerContext.b(getClass(), "photo_auto_save"), 1672941150).a();
                    return;
                }
                this.f11531d.edit().putBoolean(MediaDownloadPrefKeys.f11537c, false).commit();
            }
        }
    }

    public static PhotoToDownload m12171a(ImageAttachmentData imageAttachmentData) {
        return new PhotoToDownload(imageAttachmentData.f7730e);
    }

    public static PhotoToDownload m12172a(MediaMessageItem mediaMessageItem) {
        return new PhotoToDownload(mediaMessageItem.m16364e().u, mediaMessageItem.m16364e().D);
    }

    private ImmutableList<PhotoToDownload> m12174c(ImmutableList<Message> immutableList) {
        Builder builder = ImmutableList.builder();
        int size = immutableList.size();
        for (int i = 0; i < size; i++) {
            for (ImageAttachmentData a : this.f11532e.f((Message) immutableList.get(i))) {
                builder.c(m12171a(a));
            }
        }
        return builder.b();
    }

    public final ListenableFuture<DownloadedMedia> m12175a(VideoAttachmentData videoAttachmentData, CallerContext callerContext) {
        Bundle bundle = new Bundle();
        bundle.putParcelable("video_attachment_data", videoAttachmentData);
        return Futures.a(BlueServiceOperationFactoryDetour.a(this.f11529b, "video_download", bundle, ErrorPropagation.BY_EXCEPTION, callerContext, 1579798373).a(), new C12903(this), MoreExecutors.a());
    }

    public final void m12180a(ListenableFuture<DownloadedMedia> listenableFuture) {
        Futures.a(listenableFuture, new C12914(this), this.f11533f);
    }

    public final void m12181c(ListenableFuture<DownloadedMedia> listenableFuture) {
        Futures.a(listenableFuture, new C12936(this), this.f11533f);
    }

    public final void m12178a(Context context) {
        if (((Boolean) this.f11530c.get()).booleanValue() && !this.f11531d.a(MediaDownloadPrefKeys.f11537c, false) && !this.f11531d.a(MediaDownloadPrefKeys.f11538d, false)) {
            Editor edit = this.f11531d.edit();
            edit.putBoolean(MediaDownloadPrefKeys.f11538d, true);
            edit.commit();
            new FbAlertDialogBuilder(context).a(2131231651).b(2131231652).a(2131230735, new C12958(this)).b(2131230736, new C12947(this)).b();
        }
    }
}
