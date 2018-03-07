package com.facebook.composer.tip;

import android.view.ViewGroup;
import com.facebook.composer.audienceeducator.ComposerAudienceEducatorData.ProvidesAudienceEducatorData;
import com.facebook.composer.event.ComposerEvent;
import com.facebook.inject.Assisted;
import com.facebook.ipc.composer.dataaccessor.ComposerBasicDataProviders.ProvidesIsPrivacyPillSupported;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: composer_text_on_photos */
public class AudienceAlignmentPrivacyBubbleController<DataProvider extends ProvidesAudienceEducatorData & ProvidesIsPrivacyPillSupported> extends BaseAudienceTooltipController<DataProvider> {

    /* compiled from: composer_text_on_photos */
    /* synthetic */ class C13621 {
        static final /* synthetic */ int[] f16959a = new int[ComposerEvent.values().length];

        static {
            try {
                f16959a[ComposerEvent.ON_USER_INTERACTION.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f16959a[ComposerEvent.ON_STATUS_TEXT_CHANGED.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f16959a[ComposerEvent.ON_AAA_TUX_COMPLETED.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f16959a[ComposerEvent.ON_AAA_ONLY_ME_COMPLETED.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
        }
    }

    @Inject
    public AudienceAlignmentPrivacyBubbleController(@Assisted ViewGroup viewGroup, @Nullable @Assisted ViewGroup viewGroup2, @Assisted DataProvider dataProvider) {
        super(viewGroup, viewGroup2, dataProvider);
    }

    protected final int hF_() {
        return 1;
    }

    public final ComposerTip$Action m20926a(ComposerEvent composerEvent) {
        switch (C13621.f16959a[composerEvent.ordinal()]) {
            case 1:
            case 2:
                return ComposerTip$Action.HIDE;
            case 3:
            case 4:
                return ComposerTip$Action.SHOW;
            default:
                return ComposerTip$Action.NONE;
        }
    }
}
