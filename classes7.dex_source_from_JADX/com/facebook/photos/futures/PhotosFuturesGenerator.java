package com.facebook.photos.futures;

import android.content.Context;
import android.graphics.RectF;
import android.os.Bundle;
import com.facebook.auth.viewercontext.ViewerContext;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.fbservice.ops.DefaultBlueServiceOperationFactory;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.graphql.enums.GraphQLPhotosAlbumAPIType;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.photos.data.method.CreatePagePhotoAlbumParams;
import com.facebook.photos.data.method.CreatePhotoAlbumParams;
import com.facebook.photos.data.method.CropProfilePictureParams;
import com.facebook.photos.data.method.ModifyAlbumContributorParams;
import com.facebook.photos.data.method.ModifyAlbumContributorParams.ModifyContributorOperationType;
import com.facebook.photos.data.method.UpdatePhotoAlbumParams;
import com.facebook.photos.data.method.UpdatePhotoAlbumParams.ConversionType;
import com.facebook.tools.dextr.runtime.detour.BlueServiceOperationFactoryDetour;
import com.google.common.collect.ImmutableList;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.Set;
import javax.annotation.Nullable;
import javax.inject.Inject;

@ContextScoped
/* compiled from: last_event */
public class PhotosFuturesGenerator {
    private static PhotosFuturesGenerator f10530b;
    private static final Object f10531c = new Object();
    public final DefaultBlueServiceOperationFactory f10532a;

    private static PhotosFuturesGenerator m12390b(InjectorLike injectorLike) {
        return new PhotosFuturesGenerator(DefaultBlueServiceOperationFactory.b(injectorLike));
    }

    @Inject
    public PhotosFuturesGenerator(DefaultBlueServiceOperationFactory defaultBlueServiceOperationFactory) {
        this.f10532a = defaultBlueServiceOperationFactory;
    }

    public static PhotosFuturesGenerator m12388a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            PhotosFuturesGenerator b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f10531c) {
                PhotosFuturesGenerator photosFuturesGenerator;
                if (a2 != null) {
                    photosFuturesGenerator = (PhotosFuturesGenerator) a2.a(f10531c);
                } else {
                    photosFuturesGenerator = f10530b;
                }
                if (photosFuturesGenerator == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m12390b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f10531c, b3);
                        } else {
                            f10530b = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = photosFuturesGenerator;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    public final ListenableFuture<OperationResult> m12394a(String str, String str2, String str3, String str4, String str5) {
        CreatePhotoAlbumParams createPhotoAlbumParams = new CreatePhotoAlbumParams(str, "", str2, str3, "", str4, str5);
        Bundle bundle = new Bundle();
        bundle.putParcelable("createAlbumParams", createPhotoAlbumParams);
        return BlueServiceOperationFactoryDetour.a(this.f10532a, "photos_create_album", bundle, 1564611770).a();
    }

    public final ListenableFuture<OperationResult> m12391a(long j, String str, String str2, String str3, ViewerContext viewerContext) {
        CreatePagePhotoAlbumParams createPagePhotoAlbumParams = new CreatePagePhotoAlbumParams(j, str, str2, str3);
        Bundle bundle = new Bundle();
        bundle.putParcelable("createPageAlbumParams", createPagePhotoAlbumParams);
        bundle.putParcelable("overridden_viewer_context", viewerContext);
        return BlueServiceOperationFactoryDetour.a(this.f10532a, "create_page_album", bundle, -272803924).a();
    }

    private ListenableFuture<OperationResult> m12389a(String str, String str2, String str3, String str4, String str5, Boolean bool) {
        UpdatePhotoAlbumParams updatePhotoAlbumParams = new UpdatePhotoAlbumParams(str, str2, str3, str4, str5, ConversionType.NO_CONVERSION, bool);
        Bundle bundle = new Bundle();
        bundle.putParcelable("updateAlbumParams", updatePhotoAlbumParams);
        return BlueServiceOperationFactoryDetour.a(this.f10532a, "photos_update_album", bundle, 9668559).a();
    }

    public final ListenableFuture<OperationResult> m12395a(String str, String str2, String str3, String str4, String str5, ConversionType conversionType, Boolean bool, GraphQLPhotosAlbumAPIType graphQLPhotosAlbumAPIType, Set<String> set, Set<String> set2) {
        UpdatePhotoAlbumParams updatePhotoAlbumParams = new UpdatePhotoAlbumParams(str, str2, str3, str4, str5, conversionType, bool);
        Bundle bundle = new Bundle();
        bundle.putParcelable("updateAlbumParams", updatePhotoAlbumParams);
        bundle.putBoolean("IsAlbumTypeShared", graphQLPhotosAlbumAPIType == GraphQLPhotosAlbumAPIType.SHARED);
        if (!(set == null || set.isEmpty())) {
            bundle.putParcelable("addContributors", new ModifyAlbumContributorParams(ImmutableList.copyOf(set), str, ModifyContributorOperationType.ADD_OPERATION));
        }
        if (!(set2 == null || set2.isEmpty())) {
            bundle.putParcelable("deleteContributors", new ModifyAlbumContributorParams(ImmutableList.copyOf(set2), str, ModifyContributorOperationType.DELETE_OPERATION));
        }
        return BlueServiceOperationFactoryDetour.a(this.f10532a, "photos_update_album", bundle, 541630646).a();
    }

    public final ListenableFuture<OperationResult> m12393a(String str, String str2) {
        return m12389a(str, str2, null, null, null, null);
    }

    public final ListenableFuture<OperationResult> m12392a(String str, RectF rectF, String str2, long j, @Nullable String str3) {
        Bundle bundle = new Bundle();
        bundle.putParcelable("cropProfilePictureParams", new CropProfilePictureParams(str, rectF, str2, j, str3));
        return BlueServiceOperationFactoryDetour.a(this.f10532a, "crop_profile_picture", bundle, 599917017).a();
    }
}
