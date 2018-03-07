package com.facebook.crowdsourcing.picker;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.crowdsourcing.enums.SuggestEditsInputType;
import com.facebook.crowdsourcing.protocol.graphql.SuggestEditsInterfaces.SuggestEditsHeader;
import com.facebook.crowdsourcing.protocol.graphql.SuggestEditsModels.SuggestEditsHeaderModel;
import com.facebook.crowdsourcing.suggestedits.data.SuggestEditsFieldMutator;
import com.facebook.inject.InjectorLike;
import com.facebook.ipc.editgallery.EditGalleryIpcBundle;
import com.facebook.ipc.simplepicker.SimplePickerIntent;
import com.facebook.ipc.simplepicker.SimplePickerLauncherConfiguration.Action;
import com.facebook.ipc.simplepicker.SimplePickerLauncherConfiguration.Builder;
import com.facebook.ipc.simplepicker.SimplePickerSource;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: com.facebook.livephotos.exoplayer.extractor.ogg.OggVorbisExtractor */
public class PhotoPicker implements SuggestEditsPicker<SuggestEditsHeader> {
    private static final String f17446a = PhotoPicker.class.getSimpleName();
    private static volatile PhotoPicker f17447d;
    private final Context f17448b;
    private final AbstractFbErrorReporter f17449c;

    public static com.facebook.crowdsourcing.picker.PhotoPicker m21353a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f17447d;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.crowdsourcing.picker.PhotoPicker.class;
        monitor-enter(r1);
        r0 = f17447d;	 Catch:{ all -> 0x003a }
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
        r0 = m21354b(r0);	 Catch:{ all -> 0x0035 }
        f17447d = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f17447d;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.crowdsourcing.picker.PhotoPicker.a(com.facebook.inject.InjectorLike):com.facebook.crowdsourcing.picker.PhotoPicker");
    }

    private static PhotoPicker m21354b(InjectorLike injectorLike) {
        return new PhotoPicker((Context) injectorLike.getInstance(Context.class), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike));
    }

    public final Object mo1364a(Intent intent, Object obj) {
        String str;
        SuggestEditsHeaderModel suggestEditsHeaderModel = (SuggestEditsHeaderModel) obj;
        EditGalleryIpcBundle editGalleryIpcBundle = (EditGalleryIpcBundle) intent.getParcelableExtra(EditGalleryIpcBundle.a);
        if (editGalleryIpcBundle == null || editGalleryIpcBundle.b == null) {
            this.f17449c.a(f17446a, "No cropped photo URI returned");
            str = null;
        } else {
            str = editGalleryIpcBundle.b.getPath();
        }
        return SuggestEditsFieldMutator.m21505b(suggestEditsHeaderModel, "file://" + str);
    }

    @Inject
    public PhotoPicker(Context context, AbstractFbErrorReporter abstractFbErrorReporter) {
        this.f17448b = context;
        this.f17449c = abstractFbErrorReporter;
    }

    public final Intent mo1362a(Object obj, Fragment fragment) {
        return SimplePickerIntent.a(this.f17448b, new Builder(SimplePickerSource.SUGGEST_EDITS).k().h().i().a(Action.LAUNCH_GENERIC_CROPPER));
    }

    public final SuggestEditsInputType mo1363a() {
        return SuggestEditsInputType.PHOTO_PICKER;
    }
}
