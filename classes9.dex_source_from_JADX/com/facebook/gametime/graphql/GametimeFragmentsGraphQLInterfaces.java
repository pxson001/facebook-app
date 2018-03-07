package com.facebook.gametime.graphql;

import com.facebook.gametime.graphql.GametimeFragmentsGraphQLModels.GametimeMatchHeaderFragmentModel.SportsMatchDataModel.AwayTeamObjectModel;
import com.facebook.gametime.graphql.GametimeFragmentsGraphQLModels.GametimeMatchHeaderFragmentModel.SportsMatchDataModel.HomeTeamObjectModel;
import javax.annotation.Nullable;

/* compiled from: TERMS_AND_POLICIES */
public class GametimeFragmentsGraphQLInterfaces {

    /* compiled from: TERMS_AND_POLICIES */
    public interface GametimeMatchHeaderFragment {

        /* compiled from: TERMS_AND_POLICIES */
        public interface SportsMatchData {
            @Nullable
            AwayTeamObjectModel mo1164b();

            @Nullable
            String mo1165c();

            int mo1166d();

            @Nullable
            HomeTeamObjectModel mo1167g();

            @Nullable
            String mo1168j();

            boolean mB_();

            @Nullable
            String mC_();

            int mD_();
        }
    }
}
