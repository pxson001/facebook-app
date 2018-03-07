package com.facebook.composer.tip;

import android.content.res.Resources;
import android.text.style.StyleSpan;
import android.view.ViewGroup;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.util.StyledStringBuilder;
import com.facebook.common.util.TriState;
import com.facebook.composer.activity.ComposerDataProviderImpl;
import com.facebook.composer.audienceeducator.ComposerAudienceEducatorData.ProvidesAudienceEducatorData;
import com.facebook.composer.audienceeducator.ComposerAudienceEducatorData.TagExpansionExplanationType;
import com.facebook.composer.event.ComposerEvent;
import com.facebook.inject.Assisted;
import com.facebook.inject.Lazy;
import com.facebook.ipc.composer.dataaccessor.ComposerBasicDataProviders.ProvidesIsPrivacyPillSupported;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: composer_privacy_fetch_error */
public class InlinePrivacySurveyBubbleController<DataProvider extends ProvidesAudienceEducatorData & ProvidesIsPrivacyPillSupported> extends BaseAudienceTooltipController<DataProvider> {
    private final Lazy<Resources> f17002b;
    private final Provider<TriState> f17003c;
    public final Lazy<FbErrorReporter> f17004d;

    /* compiled from: composer_privacy_fetch_error */
    /* synthetic */ class C13701 {
        static final /* synthetic */ int[] f17001a = new int[ComposerEvent.values().length];

        static {
            try {
                f17001a[ComposerEvent.ON_USER_INTERACTION.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f17001a[ComposerEvent.ON_STATUS_TEXT_CHANGED.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f17001a[ComposerEvent.ON_PRIVACY_CHANGE_FROM_INLINE_PRIVACY_SURVEY.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
        }
    }

    @Inject
    public InlinePrivacySurveyBubbleController(Lazy<Resources> lazy, Provider<TriState> provider, Lazy<FbErrorReporter> lazy2, @Assisted ViewGroup viewGroup, @Nullable @Assisted ViewGroup viewGroup2, @Assisted DataProvider dataProvider) {
        super(viewGroup, viewGroup2, dataProvider);
        this.f17002b = lazy;
        this.f17003c = provider;
        this.f17004d = lazy2;
    }

    protected final int hF_() {
        return 2;
    }

    public final ComposerTip$Action m20951a(ComposerEvent composerEvent) {
        switch (C13701.f17001a[composerEvent.ordinal()]) {
            case 1:
                return ComposerTip$Action.HIDE;
            case 2:
                return ComposerTip$Action.HIDE;
            case 3:
                return ComposerTip$Action.SHOW;
            default:
                return ComposerTip$Action.NONE;
        }
    }

    protected final CharSequence mo1336d() {
        int i;
        String str = ((ComposerDataProviderImpl) this.f16960a.get()).az().f16678c;
        Resources resources = (Resources) this.f17002b.get();
        if (((TriState) this.f17003c.get()).asBoolean(false)) {
            i = 2131234600;
        } else {
            int i2;
            TagExpansionExplanationType tagExpansionExplanationType = ((ComposerDataProviderImpl) this.f16960a.get()).az().f16679d;
            if (tagExpansionExplanationType == null || tagExpansionExplanationType == TagExpansionExplanationType.NONE) {
                i2 = 2131234601;
            } else if (tagExpansionExplanationType == TagExpansionExplanationType.TAGGEES) {
                i2 = 2131234602;
            } else if (tagExpansionExplanationType == TagExpansionExplanationType.FRIENDS_OF_TAGGEES) {
                i2 = 2131234603;
            } else {
                ((AbstractFbErrorReporter) this.f17004d.get()).b(getClass().getSimpleName(), "Unexpected tag expansion explanation type: " + tagExpansionExplanationType.toString());
                i2 = 2131234601;
            }
            i = i2;
        }
        return new StyledStringBuilder(resources).a(resources.getString(i, new Object[]{"__{TOKEN}__"})).a("__{TOKEN}__", str, new StyleSpan(1), 33).b();
    }
}
