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

/* compiled from: TE;D */
public class SearchAwarenessTutorialNuxConfigurationValidator {
    public final AbstractFbErrorReporter f22458a;
    public StringBuilder f22459b = new StringBuilder();

    /* compiled from: TE;D */
    /* synthetic */ class C23951 {
        static final /* synthetic */ int[] f22457a = new int[GraphQLSearchAwarenessTutorialNUXTemplate.values().length];

        static {
            try {
                f22457a[GraphQLSearchAwarenessTutorialNUXTemplate.BASIC.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
        }
    }

    @Inject
    public SearchAwarenessTutorialNuxConfigurationValidator(AbstractFbErrorReporter abstractFbErrorReporter) {
        this.f22458a = abstractFbErrorReporter;
    }

    public final boolean m25940a(TutorialNuxConfigurationModel tutorialNuxConfigurationModel) {
        if (!tutorialNuxConfigurationModel.m9067k()) {
            return false;
        }
        boolean a = m25937a(tutorialNuxConfigurationModel.m9064a());
        if (!a) {
            this.f22458a.a("SearchAwareness", this.f22459b.toString());
        }
        this.f22459b = new StringBuilder();
        return a;
    }

    private boolean m25937a(@Nullable TutorialNuxCarouselFieldsFragmentModel tutorialNuxCarouselFieldsFragmentModel) {
        if (tutorialNuxCarouselFieldsFragmentModel == null) {
            m25935a("Carousel configuration is null.");
            return false;
        }
        boolean z;
        if (TextUtils.isEmpty(tutorialNuxCarouselFieldsFragmentModel.m9055p())) {
            m25935a("Carousel is missing required primary action label.\n");
            z = false;
        } else {
            z = true;
        }
        if (TextUtils.isEmpty(tutorialNuxCarouselFieldsFragmentModel.m9057r())) {
            m25935a("Carousel is missing required secondary action label.\n");
            z = false;
        }
        if (TextUtils.isEmpty(tutorialNuxCarouselFieldsFragmentModel.m9052m()) || TextUtils.isEmpty(tutorialNuxCarouselFieldsFragmentModel.m9051l()) || TextUtils.isEmpty(tutorialNuxCarouselFieldsFragmentModel.m9053n()) || TextUtils.isEmpty(tutorialNuxCarouselFieldsFragmentModel.m9054o())) {
            m25935a("Carousel is missing required null state image URI(s).\n");
            z = false;
        }
        if (tutorialNuxCarouselFieldsFragmentModel.m9049j().isEmpty()) {
            m25935a("Carousel must have at least one card.\n");
            z = false;
        }
        if (z && m25938a(tutorialNuxCarouselFieldsFragmentModel.m9049j())) {
            return true;
        }
        return false;
    }

    private boolean m25938a(ImmutableList<TutorialNuxCardFieldsFragmentModel> immutableList) {
        int size = immutableList.size();
        int i = 0;
        boolean z = true;
        while (i < size) {
            boolean z2;
            TutorialNuxCardFieldsFragmentModel tutorialNuxCardFieldsFragmentModel = (TutorialNuxCardFieldsFragmentModel) immutableList.get(i);
            if (z && m25936a(tutorialNuxCardFieldsFragmentModel)) {
                z2 = true;
            } else {
                z2 = false;
            }
            i++;
            z = z2;
        }
        return z;
    }

    private boolean m25936a(TutorialNuxCardFieldsFragmentModel tutorialNuxCardFieldsFragmentModel) {
        switch (C23951.f22457a[tutorialNuxCardFieldsFragmentModel.m9042q().ordinal()]) {
            case 1:
                return m25939b(tutorialNuxCardFieldsFragmentModel);
            default:
                m25935a("Unsupported template.\n");
                return false;
        }
    }

    private boolean m25939b(TutorialNuxCardFieldsFragmentModel tutorialNuxCardFieldsFragmentModel) {
        boolean z = true;
        if (TextUtils.isEmpty(tutorialNuxCardFieldsFragmentModel.m9036k())) {
            m25935a("BASIC card is missing required header.\n");
            z = false;
        }
        if (TextUtils.isEmpty(tutorialNuxCardFieldsFragmentModel.m9041p())) {
            m25935a("BASIC card is missing required search term.\n");
            z = false;
        }
        if (TextUtils.isEmpty(tutorialNuxCardFieldsFragmentModel.m9034a())) {
            m25935a("BASIC card is missing required body.\n");
            z = false;
        }
        if (TextUtils.isEmpty(tutorialNuxCardFieldsFragmentModel.m9038m()) || TextUtils.isEmpty(tutorialNuxCardFieldsFragmentModel.m9037l()) || TextUtils.isEmpty(tutorialNuxCardFieldsFragmentModel.m9039n()) || TextUtils.isEmpty(tutorialNuxCardFieldsFragmentModel.m9040o())) {
            m25935a("BASIC card is missing required image URI(s).\n");
            z = false;
        }
        if (!TextUtils.isEmpty(tutorialNuxCardFieldsFragmentModel.m9035j())) {
            return z;
        }
        m25935a("BASIC card is missing required background color value.\n");
        return false;
    }

    private void m25935a(String str) {
        this.f22459b.append(str);
    }
}
