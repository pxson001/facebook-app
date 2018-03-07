package com.facebook.composer.controller;

import android.content.res.Resources;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.inject.Assisted;
import com.facebook.inject.Lazy;
import com.facebook.ipc.composer.intent.ComposerConfigurationSpec.ProvidesConfiguration;
import com.facebook.ipc.composer.intent.ComposerTargetData.ProvidesTargetData;
import com.facebook.ipc.composer.model.ComposerFacecastInfo.ProvidesFacecastInfo;
import com.facebook.ipc.composer.model.PublishMode;
import com.facebook.ipc.composer.model.PublishMode.ProvidesPublishMode;
import com.facebook.ipc.composer.plugin.ComposerPluginGetters.ProvidesPluginPublishButtonTextGetter;
import com.facebook.qe.api.QeAccessor;
import java.lang.ref.WeakReference;
import javax.inject.Inject;

/* compiled from: hpp_cover_header */
public class ComposerPublishButtonGenerator<DataProvider extends ProvidesConfiguration & ProvidesFacecastInfo & ProvidesPluginPublishButtonTextGetter & ProvidesTargetData & ProvidesPublishMode> {
    public final WeakReference<DataProvider> f6284a;
    public final Resources f6285b;
    public final Lazy<FbErrorReporter> f6286c;
    public final QeAccessor f6287d;

    /* compiled from: hpp_cover_header */
    public /* synthetic */ class C07831 {
        public static final /* synthetic */ int[] f6283a = new int[PublishMode.values().length];

        static {
            try {
                f6283a[PublishMode.NORMAL.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f6283a[PublishMode.SCHEDULE_POST.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f6283a[PublishMode.SAVE_DRAFT.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
        }
    }

    @Inject
    public ComposerPublishButtonGenerator(@Assisted DataProvider dataProvider, Resources resources, Lazy<FbErrorReporter> lazy, QeAccessor qeAccessor) {
        this.f6284a = new WeakReference(dataProvider);
        this.f6285b = resources;
        this.f6286c = lazy;
        this.f6287d = qeAccessor;
    }
}
