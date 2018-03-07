package com.facebook.search.quickpromotion;

import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.inject.Assisted;
import com.facebook.search.protocol.awareness.SearchAwarenessModels.TutorialNuxCardFieldsFragmentModel;
import com.facebook.search.protocol.awareness.SearchAwarenessModels.TutorialNuxCarouselFieldsFragmentModel;
import com.facebook.search.protocol.awareness.SearchAwarenessModels.TutorialNuxConfigurationModel;
import com.facebook.ultralight.Inject;
import com.google.common.collect.ImmutableList;
import java.util.HashMap;
import java.util.Map;

/* compiled from: TEST_BOUNCE_FROM_MSITE */
public class SearchAwarenessTutorialNuxAssetManager {
    private final SearchAwarenessImageFetcher f22447a;
    private final Density f22448b;
    public final Map<String, ImageRequest> f22449c;
    public boolean f22450d;

    /* compiled from: TEST_BOUNCE_FROM_MSITE */
    public enum Density {
        MDPI,
        HDPI,
        XHDPI,
        XXHDPI
    }

    @Inject
    public SearchAwarenessTutorialNuxAssetManager(SearchAwarenessImageFetcher searchAwarenessImageFetcher, @Assisted int i) {
        Density density;
        this.f22447a = searchAwarenessImageFetcher;
        if (i < 240) {
            density = Density.MDPI;
        } else if (i < 320) {
            density = Density.HDPI;
        } else if (i < 480) {
            density = Density.XHDPI;
        } else {
            density = Density.XXHDPI;
        }
        this.f22448b = density;
        this.f22450d = false;
        this.f22449c = new HashMap();
    }

    public final boolean m25930a() {
        if (!this.f22450d) {
            return false;
        }
        for (ImageRequest imageRequest : this.f22449c.values()) {
            Object obj;
            SearchAwarenessImageFetcher searchAwarenessImageFetcher = this.f22447a;
            if (imageRequest != null) {
                Object obj2;
                if (imageRequest == null || searchAwarenessImageFetcher.f22380b.b(imageRequest.c)) {
                    obj2 = 1;
                } else {
                    obj2 = null;
                }
                if (obj2 == null && !((Boolean) searchAwarenessImageFetcher.f22382d.get(imageRequest)).booleanValue()) {
                    obj = null;
                    if (obj == null) {
                        return false;
                    }
                }
            }
            obj = 1;
            if (obj == null) {
                return false;
            }
        }
        return true;
    }

    public final void m25929a(TutorialNuxConfigurationModel tutorialNuxConfigurationModel) {
        if (tutorialNuxConfigurationModel != null) {
            TutorialNuxCarouselFieldsFragmentModel a = tutorialNuxConfigurationModel.m9064a();
            if (a != null) {
                ImmutableList j = a.m9049j();
                int size = j.size();
                for (int i = 0; i < size; i++) {
                    TutorialNuxCardFieldsFragmentModel tutorialNuxCardFieldsFragmentModel = (TutorialNuxCardFieldsFragmentModel) j.get(i);
                    this.f22449c.put(m25927a(tutorialNuxCardFieldsFragmentModel), ImageRequest.a(m25927a(tutorialNuxCardFieldsFragmentModel)));
                }
                this.f22449c.put(m25928a(a), ImageRequest.a(m25928a(a)));
                this.f22450d = true;
            }
            this.f22447a.m25875a(this.f22449c.values());
        }
    }

    public final String m25927a(TutorialNuxCardFieldsFragmentModel tutorialNuxCardFieldsFragmentModel) {
        switch (this.f22448b) {
            case MDPI:
                return tutorialNuxCardFieldsFragmentModel.m9038m();
            case HDPI:
                return tutorialNuxCardFieldsFragmentModel.m9037l();
            case XHDPI:
                return tutorialNuxCardFieldsFragmentModel.m9039n();
            case XXHDPI:
                return tutorialNuxCardFieldsFragmentModel.m9040o();
            default:
                return "";
        }
    }

    public final String m25928a(TutorialNuxCarouselFieldsFragmentModel tutorialNuxCarouselFieldsFragmentModel) {
        switch (this.f22448b) {
            case MDPI:
                return tutorialNuxCarouselFieldsFragmentModel.m9052m();
            case HDPI:
                return tutorialNuxCarouselFieldsFragmentModel.m9051l();
            case XHDPI:
                return tutorialNuxCarouselFieldsFragmentModel.m9053n();
            case XXHDPI:
                return tutorialNuxCarouselFieldsFragmentModel.m9054o();
            default:
                return "";
        }
    }
}
