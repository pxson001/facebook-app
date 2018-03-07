package com.facebook.composer.lifeevent.interstitial;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.app.Fragment;
import com.facebook.composer.lifeevent.model.ComposerLifeEventModel;
import com.facebook.graphql.enums.GraphQLLifeEventAPIIdentifier;
import com.facebook.graphql.enums.GraphQLLifeEventEducationExperienceType;

/* compiled from: core_attribute_aspect_ratio_value */
public class ComposerLifeEventInterstitialFragmentFactory {

    /* compiled from: core_attribute_aspect_ratio_value */
    /* synthetic */ class C13371 {
        static final /* synthetic */ int[] f16749a = new int[GraphQLLifeEventAPIIdentifier.values().length];

        static {
            try {
                f16749a[GraphQLLifeEventAPIIdentifier.MARRIED.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f16749a[GraphQLLifeEventAPIIdentifier.ENGAGED.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f16749a[GraphQLLifeEventAPIIdentifier.STARTED_JOB.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f16749a[GraphQLLifeEventAPIIdentifier.GRADUATED.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
        }
    }

    public static ComposerLifeEventInterstitialFragment m20774a(Intent intent) {
        Fragment composerLifeEventMarriageInterstitialFragment;
        Parcelable intent2 = new Intent(intent);
        ComposerLifeEventModel composerLifeEventModel = (ComposerLifeEventModel) intent.getParcelableExtra("life_event_model");
        switch (C13371.f16749a[composerLifeEventModel.b.ordinal()]) {
            case 1:
                composerLifeEventMarriageInterstitialFragment = new ComposerLifeEventMarriageInterstitialFragment();
                break;
            case 2:
                composerLifeEventMarriageInterstitialFragment = new ComposerLifeEventEngagementInterstitialFragment();
                break;
            case 3:
                composerLifeEventMarriageInterstitialFragment = new ComposerLifeEventWorkInterstitialFragment();
                break;
            case 4:
                if (!composerLifeEventModel.i.equals(GraphQLLifeEventEducationExperienceType.COLLEGE)) {
                    if (!composerLifeEventModel.i.equals(GraphQLLifeEventEducationExperienceType.HIGHSCHOOL)) {
                        composerLifeEventMarriageInterstitialFragment = null;
                        break;
                    }
                    composerLifeEventMarriageInterstitialFragment = new ComposerLifeEventHighSchoolInterstitialFragment();
                    break;
                }
                composerLifeEventMarriageInterstitialFragment = new ComposerLifeEventCollegeInterstitialFragment();
                break;
            default:
                throw new IllegalArgumentException();
        }
        Bundle bundle = new Bundle();
        bundle.putParcelable("intent", intent2);
        composerLifeEventMarriageInterstitialFragment.g(bundle);
        return composerLifeEventMarriageInterstitialFragment;
    }
}
