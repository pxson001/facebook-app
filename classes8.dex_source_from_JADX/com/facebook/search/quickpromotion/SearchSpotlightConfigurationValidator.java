package com.facebook.search.quickpromotion;

import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.graphql.enums.GraphQLSearchAwarenessTutorialNUXTemplate;
import com.facebook.search.protocol.awareness.SearchAwarenessModels.TutorialNuxCardFieldsFragmentModel;
import com.facebook.search.protocol.awareness.SearchAwarenessModels.TutorialNuxCarouselFieldsFragmentModel;
import com.facebook.search.protocol.awareness.SearchAwarenessModels.TutorialNuxConfigurationModel;
import com.facebook.ultralight.Inject;
import com.google.common.collect.ImmutableList;

/* compiled from: TAKE_VIDEO */
public class SearchSpotlightConfigurationValidator {
    public final AbstractFbErrorReporter f22509a;
    public StringBuilder f22510b = new StringBuilder();

    /* compiled from: TAKE_VIDEO */
    /* synthetic */ class C24031 {
        static final /* synthetic */ int[] f22508a = new int[GraphQLSearchAwarenessTutorialNUXTemplate.values().length];

        static {
            try {
                f22508a[GraphQLSearchAwarenessTutorialNUXTemplate.CARD.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f22508a[GraphQLSearchAwarenessTutorialNUXTemplate.INTRO.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
        }
    }

    @Inject
    public SearchSpotlightConfigurationValidator(AbstractFbErrorReporter abstractFbErrorReporter) {
        this.f22509a = abstractFbErrorReporter;
    }

    public final boolean m25985a(TutorialNuxConfigurationModel tutorialNuxConfigurationModel) {
        if (!tutorialNuxConfigurationModel.m9067k()) {
            return false;
        }
        if (tutorialNuxConfigurationModel.m9068l()) {
            return true;
        }
        boolean a = m25981a(tutorialNuxConfigurationModel.m9064a());
        if (!a) {
            this.f22509a.a("SearchAwareness", this.f22510b.toString());
        }
        this.f22510b = new StringBuilder();
        return a;
    }

    private boolean m25981a(@Nullable TutorialNuxCarouselFieldsFragmentModel tutorialNuxCarouselFieldsFragmentModel) {
        if (tutorialNuxCarouselFieldsFragmentModel == null) {
            m25979a("Carousel configuration is null.\n");
            return false;
        }
        boolean z;
        if (tutorialNuxCarouselFieldsFragmentModel.m9049j().isEmpty()) {
            m25979a("Carousel must have at least one card/\n");
            z = false;
        } else {
            z = true;
        }
        if (z && m25982a(tutorialNuxCarouselFieldsFragmentModel.m9049j())) {
            return true;
        }
        return false;
    }

    private boolean m25982a(ImmutableList<TutorialNuxCardFieldsFragmentModel> immutableList) {
        boolean z = !immutableList.isEmpty();
        if (!z) {
            m25979a("Carousel must have at least one card.\n");
        }
        int size = immutableList.size();
        int i = 0;
        boolean z2 = z;
        while (i < size) {
            TutorialNuxCardFieldsFragmentModel tutorialNuxCardFieldsFragmentModel = (TutorialNuxCardFieldsFragmentModel) immutableList.get(i);
            if (z2 && m25980a(tutorialNuxCardFieldsFragmentModel)) {
                z = true;
            } else {
                z = false;
            }
            i++;
            z2 = z;
        }
        return z2;
    }

    private boolean m25980a(TutorialNuxCardFieldsFragmentModel tutorialNuxCardFieldsFragmentModel) {
        switch (C24031.f22508a[tutorialNuxCardFieldsFragmentModel.m9042q().ordinal()]) {
            case 1:
                return m25983b(tutorialNuxCardFieldsFragmentModel);
            case 2:
                return m25984c(tutorialNuxCardFieldsFragmentModel);
            default:
                m25979a("Unsupported template.\n");
                return false;
        }
    }

    private boolean m25983b(TutorialNuxCardFieldsFragmentModel tutorialNuxCardFieldsFragmentModel) {
        boolean z = true;
        if (TextUtils.isEmpty(tutorialNuxCardFieldsFragmentModel.m9034a())) {
            m25979a("CARD spotlight template is missing required body text.");
            z = false;
        }
        if (!TextUtils.isEmpty(tutorialNuxCardFieldsFragmentModel.m9035j())) {
            return z;
        }
        m25979a("CARD spotlight template is missing required background color value.\n");
        return false;
    }

    private boolean m25984c(TutorialNuxCardFieldsFragmentModel tutorialNuxCardFieldsFragmentModel) {
        if (!TextUtils.isEmpty(tutorialNuxCardFieldsFragmentModel.m9034a())) {
            return true;
        }
        m25979a("INTRO spotlight template is missing required body text.");
        return false;
    }

    private void m25979a(String str) {
        this.f22510b.append(str);
    }
}
