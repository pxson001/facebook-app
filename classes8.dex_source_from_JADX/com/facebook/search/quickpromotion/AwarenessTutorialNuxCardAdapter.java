package com.facebook.search.quickpromotion;

import android.content.Context;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import com.facebook.common.i18n.RTLUtil;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.inject.Assisted;
import com.facebook.search.abtest.SearchAbTestGatekeepers;
import com.facebook.search.protocol.awareness.SearchAwarenessModels.TutorialNuxCardFieldsFragmentModel;
import com.facebook.search.protocol.awareness.SearchAwarenessModels.TutorialNuxCarouselFieldsFragmentModel;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import javax.inject.Inject;

/* compiled from: TEXT_H2 */
public class AwarenessTutorialNuxCardAdapter extends FragmentPagerAdapter {
    private final SearchAwarenessTutorialNuxAssetManager f22333a;
    private final SearchAwarenessTutorialNuxController f22334b;
    public final ImmutableList<AwarenessTutorialNuxCardConfiguration> f22335c = m25843a(this.f22334b.f22472l.m9064a());
    private final RTLUtil f22336d;

    @Inject
    public AwarenessTutorialNuxCardAdapter(SearchAwarenessTutorialNuxAssetManagerProvider searchAwarenessTutorialNuxAssetManagerProvider, @Assisted FragmentManager fragmentManager, SearchAwarenessTutorialNuxController searchAwarenessTutorialNuxController, Context context, GatekeeperStoreImpl gatekeeperStoreImpl, RTLUtil rTLUtil) {
        super(fragmentManager);
        Preconditions.checkArgument(gatekeeperStoreImpl.a(SearchAbTestGatekeepers.m, false));
        Preconditions.checkNotNull(searchAwarenessTutorialNuxController.f22472l);
        Preconditions.checkNotNull(searchAwarenessTutorialNuxController.f22472l.m9064a());
        this.f22334b = searchAwarenessTutorialNuxController;
        this.f22333a = searchAwarenessTutorialNuxAssetManagerProvider.m25931a(context.getResources().getDisplayMetrics().densityDpi);
        this.f22336d = rTLUtil;
        if (this.f22336d.a() && this.f22335c != null) {
            this.f22335c.reverse();
        }
    }

    private ImmutableList<AwarenessTutorialNuxCardConfiguration> m25843a(TutorialNuxCarouselFieldsFragmentModel tutorialNuxCarouselFieldsFragmentModel) {
        Builder builder = ImmutableList.builder();
        ImmutableList j = tutorialNuxCarouselFieldsFragmentModel.m9049j();
        int size = j.size();
        for (int i = 0; i < size; i++) {
            TutorialNuxCardFieldsFragmentModel tutorialNuxCardFieldsFragmentModel = (TutorialNuxCardFieldsFragmentModel) j.get(i);
            builder.c(new AwarenessTutorialNuxCardConfiguration(tutorialNuxCardFieldsFragmentModel.m9036k(), tutorialNuxCardFieldsFragmentModel.m9041p(), Uri.parse(this.f22333a.m25927a(tutorialNuxCardFieldsFragmentModel)), tutorialNuxCardFieldsFragmentModel.m9034a(), Color.parseColor("#" + tutorialNuxCardFieldsFragmentModel.m9035j())));
        }
        return builder.b();
    }

    public final Fragment m25844a(int i) {
        if (i < 0 || i >= this.f22335c.size()) {
            return null;
        }
        AwarenessTutorialNuxCardConfiguration awarenessTutorialNuxCardConfiguration = (AwarenessTutorialNuxCardConfiguration) this.f22335c.get(i);
        AwarenessTutorialNuxCardFragment awarenessTutorialNuxCardFragment = new AwarenessTutorialNuxCardFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelable("configuration", awarenessTutorialNuxCardConfiguration);
        awarenessTutorialNuxCardFragment.g(bundle);
        return awarenessTutorialNuxCardFragment;
    }

    public final int m25845b() {
        return this.f22335c.size();
    }
}
