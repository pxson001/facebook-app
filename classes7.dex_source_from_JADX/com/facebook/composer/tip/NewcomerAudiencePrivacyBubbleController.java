package com.facebook.composer.tip;

import android.view.ViewGroup;
import com.facebook.composer.audienceeducator.ComposerAudienceEducatorData.ProvidesAudienceEducatorData;
import com.facebook.composer.event.ComposerEvent;
import com.facebook.inject.Assisted;
import com.facebook.ipc.composer.dataaccessor.ComposerBasicDataProviders.ProvidesIsPrivacyPillSupported;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: composer_inline_activity */
public class NewcomerAudiencePrivacyBubbleController<DataProvider extends ProvidesAudienceEducatorData & ProvidesIsPrivacyPillSupported> extends BaseAudienceTooltipController<DataProvider> {

    /* compiled from: composer_inline_activity */
    /* synthetic */ class C13751 {
        static final /* synthetic */ int[] f17024a = new int[ComposerEvent.values().length];

        static {
            try {
                f17024a[ComposerEvent.ON_USER_INTERACTION.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f17024a[ComposerEvent.ON_STATUS_TEXT_CHANGED.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f17024a[ComposerEvent.ON_NEWCOMER_AUDIENCE_SELECTOR_COMPLETED.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
        }
    }

    @Inject
    public NewcomerAudiencePrivacyBubbleController(@Assisted ViewGroup viewGroup, @Nullable @Assisted ViewGroup viewGroup2, @Assisted DataProvider dataProvider) {
        super(viewGroup, viewGroup2, dataProvider);
    }

    protected final int hF_() {
        return 2;
    }

    public final ComposerTip$Action m20970a(ComposerEvent composerEvent) {
        switch (C13751.f17024a[composerEvent.ordinal()]) {
            case 1:
            case 2:
                return ComposerTip$Action.HIDE;
            case 3:
                return ComposerTip$Action.SHOW;
            default:
                return ComposerTip$Action.NONE;
        }
    }
}
