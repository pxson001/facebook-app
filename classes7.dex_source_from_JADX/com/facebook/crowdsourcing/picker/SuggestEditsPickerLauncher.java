package com.facebook.crowdsourcing.picker;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.support.v4.app.Fragment;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.crowdsourcing.enums.SuggestEditsInputType;
import com.facebook.crowdsourcing.protocol.graphql.SuggestEditsModels.SuggestEditsHeaderModel;
import com.facebook.crowdsourcing.suggestedits.data.SuggestEditsFieldHolder;
import com.facebook.crowdsourcing.suggestedits.data.SuggestEditsHeaderHolder;
import com.facebook.crowdsourcing.suggestedits.listener.SuggestEditsFieldChangedListener;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.MultiBinderSet;
import com.facebook.ui.dialogs.FbAlertDialogBuilder;
import com.google.common.base.Absent;
import com.google.common.base.Optional;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMap.Builder;
import java.util.Set;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: com.facebook.livephotos.exoplayer.extractor.mp4.Mp4Extractor */
public class SuggestEditsPickerLauncher<T> {
    public static final String f17454a = SuggestEditsPickerLauncher.class.getSimpleName();
    private static volatile SuggestEditsPickerLauncher f17455f;
    public final AbstractFbErrorReporter f17456b;
    private final SecureContextHelper f17457c;
    public ImmutableMap<SuggestEditsInputType, SuggestEditsPicker> f17458d;
    public String f17459e;

    public static com.facebook.crowdsourcing.picker.SuggestEditsPickerLauncher m21358a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f17455f;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.crowdsourcing.picker.SuggestEditsPickerLauncher.class;
        monitor-enter(r1);
        r0 = f17455f;	 Catch:{ all -> 0x003a }
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
        r0 = m21360b(r0);	 Catch:{ all -> 0x0035 }
        f17455f = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f17455f;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.crowdsourcing.picker.SuggestEditsPickerLauncher.a(com.facebook.inject.InjectorLike):com.facebook.crowdsourcing.picker.SuggestEditsPickerLauncher");
    }

    private static SuggestEditsPickerLauncher m21360b(InjectorLike injectorLike) {
        return new SuggestEditsPickerLauncher((AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike), new MultiBinderSet(injectorLike.getScopeAwareInjector(), new STATICDI_MULTIBIND_PROVIDER$SuggestEditsPicker(injectorLike)), (SecureContextHelper) DefaultSecureContextHelper.a(injectorLike));
    }

    @Inject
    public SuggestEditsPickerLauncher(FbErrorReporter fbErrorReporter, Set<SuggestEditsPicker> set, SecureContextHelper secureContextHelper) {
        this.f17456b = fbErrorReporter;
        this.f17457c = secureContextHelper;
        Builder builder = new Builder();
        for (SuggestEditsPicker suggestEditsPicker : set) {
            builder.b(suggestEditsPicker.mo1363a(), suggestEditsPicker);
        }
        this.f17458d = builder.b();
    }

    public final void m21362a(T t, SuggestEditsInputType suggestEditsInputType, SuggestEditsFieldChangedListener suggestEditsFieldChangedListener, Fragment fragment) {
        if (this.f17458d.get(suggestEditsInputType) == null) {
            this.f17456b.a(f17454a, "No intent found in map for picker");
            return;
        }
        this.f17459e = suggestEditsFieldChangedListener.mo1368a();
        this.f17457c.a(((SuggestEditsPicker) this.f17458d.get(suggestEditsInputType)).mo1362a((Object) t, fragment), suggestEditsInputType.ordinal(), fragment);
    }

    public final void m21361a(SuggestEditsHeaderHolder suggestEditsHeaderHolder, ImmutableList<SuggestEditsFieldHolder> immutableList, int i, int i2, Intent intent, Fragment fragment) {
        if (i2 == -1) {
            SuggestEditsInputType fromOrdinal = SuggestEditsInputType.fromOrdinal(i);
            if (fromOrdinal == null || this.f17458d.get(fromOrdinal) == null) {
                this.f17456b.a(f17454a, "No picker matches the field type");
            } else if (this.f17459e == null) {
                this.f17456b.a(f17454a, "There was no caller stored when the picker activity returned");
            } else {
                Optional optional;
                Object c;
                String str = this.f17459e;
                if (immutableList == null) {
                    this.f17456b.a(f17454a, "Could not handle picker activity result because field holders are not set.");
                    optional = null;
                } else {
                    int size = immutableList.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        SuggestEditsFieldHolder suggestEditsFieldHolder = (SuggestEditsFieldHolder) immutableList.get(i3);
                        if (suggestEditsFieldHolder.mo1368a().equals(str)) {
                            optional = Optional.of(suggestEditsFieldHolder);
                            break;
                        }
                    }
                    optional = Absent.INSTANCE;
                }
                Optional optional2 = optional;
                if (optional2.isPresent()) {
                    c = ((SuggestEditsFieldHolder) optional2.get()).m21489c();
                    suggestEditsHeaderHolder = (SuggestEditsFieldChangedListener) optional2.get();
                } else if (suggestEditsHeaderHolder == null || !this.f17459e.equals(suggestEditsHeaderHolder.mo1368a())) {
                    this.f17456b.a(f17454a, "Unable to determine correct field to handle picker activity result");
                    return;
                } else {
                    SuggestEditsHeaderModel c2 = suggestEditsHeaderHolder.m21511c();
                }
                Object a = ((SuggestEditsPicker) this.f17458d.get(fromOrdinal)).mo1364a(intent, c);
                if (fromOrdinal.equals(SuggestEditsInputType.PHOTO_PICKER)) {
                    m21359a(suggestEditsHeaderHolder, a, fragment);
                } else {
                    suggestEditsHeaderHolder.mo1369a(a);
                }
            }
        }
    }

    private void m21359a(final SuggestEditsFieldChangedListener suggestEditsFieldChangedListener, final Object obj, Fragment fragment) {
        new FbAlertDialogBuilder(fragment.getContext()).b(2131235208).a(true).a(2131235209, new OnClickListener(this) {
            final /* synthetic */ SuggestEditsPickerLauncher f17453c;

            public void onClick(DialogInterface dialogInterface, int i) {
                suggestEditsFieldChangedListener.mo1369a(obj);
            }
        }).b(2131235210, null).a().show();
    }
}
