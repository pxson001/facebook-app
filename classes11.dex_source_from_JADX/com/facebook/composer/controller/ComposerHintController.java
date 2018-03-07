package com.facebook.composer.controller;

import android.content.res.Resources;
import com.facebook.common.util.StringUtil;
import com.facebook.composer.abtest.ExperimentsForComposerAbTestModule;
import com.facebook.composer.activity.ComposerFragment.C07636;
import com.facebook.composer.event.ComposerEvent;
import com.facebook.composer.event.ComposerEventHandler;
import com.facebook.composer.event.ComposerEventOriginator;
import com.facebook.graphql.model.GraphQLExploreFeed;
import com.facebook.inject.Assisted;
import com.facebook.ipc.composer.intent.ComposerConfigurationSpec.ProvidesConfiguration;
import com.facebook.ipc.composer.model.ComposerContentType;
import com.facebook.ipc.composer.model.ComposerContentType.ProvidesContentType;
import com.facebook.ipc.composer.plugin.ComposerPluginGetters.ProvidesPluginStatusHintGetter;
import com.facebook.qe.api.QeAccessor;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMap.Builder;
import java.lang.ref.WeakReference;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: indeterminate */
public class ComposerHintController<DataProvider extends ProvidesConfiguration & ProvidesContentType & ProvidesPluginStatusHintGetter> implements ComposerEventHandler {
    private static final ImmutableMap<ComposerContentType, Integer> f6260a = new Builder().b(ComposerContentType.NO_ATTACHMENTS, Integer.valueOf(2131234140)).b(ComposerContentType.SINGLE_PHOTO, Integer.valueOf(2131234571)).b(ComposerContentType.MULTIPLE_PHOTOS, Integer.valueOf(2131234572)).b(ComposerContentType.VIDEO, Integer.valueOf(2131234573)).b(ComposerContentType.GIF_VIDEO, Integer.valueOf(2131234574)).b(ComposerContentType.STICKER, Integer.valueOf(2131234140)).b(ComposerContentType.SHARE_ATTACHMENT, Integer.valueOf(2131234538)).b(ComposerContentType.MULTIMEDIA, Integer.valueOf(2131234575)).b(ComposerContentType.FACECAST, Integer.valueOf(2131238225)).b(ComposerContentType.SLIDESHOW, Integer.valueOf(2131234573)).b(ComposerContentType.CHECKIN, Integer.valueOf(2131234140)).b(ComposerContentType.MINUTIAE, Integer.valueOf(2131234140)).b();
    private final WeakReference<Delegate> f6261b;
    private final WeakReference<DataProvider> f6262c;
    private final Resources f6263d;
    private final QeAccessor f6264e;

    /* compiled from: indeterminate */
    /* synthetic */ class C07811 {
        static final /* synthetic */ int[] f6259a = new int[ComposerEvent.values().length];

        static {
            try {
                f6259a[ComposerEvent.ON_DATASET_CHANGE.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
        }
    }

    @Inject
    public ComposerHintController(@Assisted DataProvider dataProvider, @Assisted Delegate delegate, Resources resources, QeAccessor qeAccessor) {
        this.f6262c = new WeakReference(Preconditions.checkNotNull(dataProvider));
        this.f6261b = new WeakReference(Preconditions.checkNotNull(delegate));
        this.f6263d = resources;
        this.f6264e = qeAccessor;
        m7719a();
    }

    public final void m7720a(ComposerEvent composerEvent, @Nullable ComposerEventOriginator composerEventOriginator) {
        switch (C07811.f6259a[composerEvent.ordinal()]) {
            case 1:
                m7719a();
                return;
            default:
                return;
        }
    }

    private void m7719a() {
        ProvidesConfiguration providesConfiguration = (ProvidesConfiguration) Preconditions.checkNotNull(this.f6262c.get());
        C07636 c07636 = (C07636) Preconditions.checkNotNull(this.f6261b.get());
        if (((ProvidesPluginStatusHintGetter) providesConfiguration).au() != null) {
            c07636.m7513a((String) ((ProvidesPluginStatusHintGetter) providesConfiguration).au().a());
        } else if (providesConfiguration.o().getPlatformConfiguration() != null && providesConfiguration.o().getPlatformConfiguration().b()) {
            c07636.m7513a(this.f6263d.getString(2131234529));
        } else if (providesConfiguration.o().getTopics().isEmpty() || providesConfiguration.o().getTopics().get(0) == null || StringUtil.c(((GraphQLExploreFeed) providesConfiguration.o().getTopics().get(0)).G())) {
            int intValue = ((Integer) f6260a.get(((ProvidesContentType) providesConfiguration).c())).intValue();
            if (((ProvidesContentType) providesConfiguration).c() != ComposerContentType.SHARE_ATTACHMENT) {
                c07636.m7513a(this.f6263d.getString(intValue));
            } else if (this.f6264e.a(ExperimentsForComposerAbTestModule.q, false)) {
                c07636.m7513a("");
            } else {
                c07636.m7513a(this.f6264e.a(ExperimentsForComposerAbTestModule.w, intValue, this.f6263d));
            }
        } else {
            c07636.m7513a(((GraphQLExploreFeed) providesConfiguration.o().getTopics().get(0)).G());
        }
    }
}
