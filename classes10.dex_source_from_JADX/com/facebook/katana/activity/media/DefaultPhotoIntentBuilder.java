package com.facebook.katana.activity.media;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.facebook.inject.ForAppContext;
import com.facebook.inject.InjectorLike;
import com.facebook.ipc.editgallery.CropMode;
import com.facebook.ipc.editgallery.EditFeature;
import com.facebook.ipc.editgallery.EditGalleryIntentCreator;
import com.facebook.ipc.editgallery.EditGalleryLaunchConfiguration.Builder;
import com.facebook.ipc.editgallery.EntryPoint;
import com.facebook.photos.intent.IPhotoIntentBuilder;
import com.facebook.vault.ui.VaultSettingsActivity;
import java.io.File;
import javax.inject.Inject;

/* compiled from: SCREEN_HEIGHT */
public class DefaultPhotoIntentBuilder implements IPhotoIntentBuilder {
    private static volatile DefaultPhotoIntentBuilder f24307b;
    private final Context f24308a;

    public static com.facebook.katana.activity.media.DefaultPhotoIntentBuilder m25603a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Can't find immediate dominator for block B:24:0x003b in {17, 19, 21, 23, 26, 28} preds:[]
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.computeDominators(BlockProcessor.java:129)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.processBlocksTree(BlockProcessor.java:48)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.rerun(BlockProcessor.java:44)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.visit(BlockFinallyExtract.java:57)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r0 = f24307b;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.katana.activity.media.DefaultPhotoIntentBuilder.class;
        monitor-enter(r1);
        r0 = f24307b;	 Catch:{ all -> 0x003a }
        if (r0 != 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000b:
        if (r5 == 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000d:
        r2 = com.facebook.inject.ScopeSet.a();	 Catch:{ all -> 0x003a }
        r3 = r2.b();	 Catch:{ all -> 0x003a }
        r0 = com.facebook.inject.SingletonScope.class;	 Catch:{ all -> 0x003a }
        r0 = r5.getInstance(r0);	 Catch:{ all -> 0x003a }
        r0 = (com.facebook.inject.SingletonScope) r0;	 Catch:{ all -> 0x003a }
        r4 = r0.enterScope();	 Catch:{ all -> 0x003a }
        r0 = r5.getApplicationInjector();	 Catch:{ all -> 0x0035 }
        r0 = m25604b(r0);	 Catch:{ all -> 0x0035 }
        f24307b = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f24307b;
        return r0;
    L_0x0035:
        r0 = move-exception;
        com.facebook.inject.SingletonScope.a(r4);	 Catch:{ all -> 0x0035 }
        throw r0;	 Catch:{ all -> 0x0035 }
    L_0x003a:
        r0 = move-exception;
        r2.c(r3);	 Catch:{ all -> 0x003a }
        throw r0;	 Catch:{ all -> 0x003a }
    L_0x003f:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x003a }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.katana.activity.media.DefaultPhotoIntentBuilder.a(com.facebook.inject.InjectorLike):com.facebook.katana.activity.media.DefaultPhotoIntentBuilder");
    }

    private static DefaultPhotoIntentBuilder m25604b(InjectorLike injectorLike) {
        return new DefaultPhotoIntentBuilder((Context) injectorLike.getInstance(Context.class, ForAppContext.class));
    }

    @Inject
    public DefaultPhotoIntentBuilder(@ForAppContext Context context) {
        this.f24308a = context;
    }

    public final Intent m25606a(String str) {
        return EditGalleryIntentCreator.a(this.f24308a, EntryPoint.LIB_FB4A.name(), new Builder().a(Uri.fromFile(new File(str)), "0").a(EditFeature.CROP).b(EditFeature.DOODLE).b(EditFeature.TEXT).b(EditFeature.STICKER).b(EditFeature.FILTER).a(CropMode.ZOOM_CROP).a());
    }

    public final Intent m25605a() {
        return new Intent(this.f24308a, VaultSettingsActivity.class);
    }
}
