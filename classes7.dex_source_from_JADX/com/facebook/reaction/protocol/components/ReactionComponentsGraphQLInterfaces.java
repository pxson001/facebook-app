package com.facebook.reaction.protocol.components;

import com.facebook.graphql.enums.GraphQLReactionUnitComponentStyle;
import com.facebook.reaction.protocol.components.ReactionComponentsGraphQLModels.GametimeDataFactFeedbackFieldsModel;
import com.facebook.reaction.protocol.components.ReactionComponentsGraphQLModels.GametimeDataFactFragmentModel.ActingTeamModel;
import com.facebook.reaction.protocol.components.ReactionComponentsGraphQLModels.GametimeDataFactFragmentModel.PreviewCommentModel;
import com.facebook.reaction.protocol.components.ReactionComponentsGraphQLModels.GametimeDataFactFragmentModel.StoryModel;
import javax.annotation.Nullable;

/* compiled from: final_text */
public class ReactionComponentsGraphQLInterfaces {

    /* compiled from: final_text */
    public interface GametimeDataFactFragment {
        @Nullable
        ActingTeamModel mo787b();

        @Nullable
        String mo788c();

        @Nullable
        String mo789d();

        @Nullable
        String eP_();

        @Nullable
        String eQ_();

        @Nullable
        String eR_();

        @Nullable
        GametimeDataFactFeedbackFieldsModel mo793g();

        @Nullable
        PreviewCommentModel mo794j();

        @Nullable
        String mo795k();

        int mo796l();

        @Nullable
        StoryModel mo797m();
    }

    /* compiled from: final_text */
    public interface GametimeFanFavoriteMatchFragment {

        /* compiled from: final_text */
        public interface AwayTeamObject {

            /* compiled from: final_text */
            public interface OfficialPage {

                /* compiled from: final_text */
                public interface PageLogo {
                    @Nullable
                    String mo798a();
                }

                @Nullable
                PageLogo mo799a();
            }

            @Nullable
            OfficialPage mo800a();

            @Nullable
            String mo801b();
        }

        /* compiled from: final_text */
        public interface HomeTeamObject {

            /* compiled from: final_text */
            public interface OfficialPage {

                /* compiled from: final_text */
                public interface PageLogo {
                    @Nullable
                    String mo802a();
                }

                @Nullable
                PageLogo mo803a();
            }

            @Nullable
            OfficialPage mo804a();

            @Nullable
            String mo805b();
        }

        /* compiled from: final_text */
        public interface MatchPage {
            @Nullable
            String mo806b();
        }

        int mo807b();

        @Nullable
        AwayTeamObject mo808c();

        @Nullable
        String mo809d();

        int eU_();

        @Nullable
        String eV_();

        @Nullable
        MatchPage eW_();

        @Nullable
        HomeTeamObject mo813g();
    }

    /* compiled from: final_text */
    public interface ReactionPageContextRowsPlaceholderComponentFragment {

        /* compiled from: final_text */
        public interface Page {
        }
    }

    /* compiled from: final_text */
    public interface ReactionReviewUnitComponentFragment {
    }

    /* compiled from: final_text */
    public interface ReactionUnitComponentBaseFields {
        @Nullable
        GraphQLReactionUnitComponentStyle mo848a();
    }

    /* compiled from: final_text */
    public interface ReactionUnitFriendRequestListComponentFragment {
    }

    /* compiled from: final_text */
    public interface ReactionUnitGametimeFanFavoriteComponentFragment {
    }

    /* compiled from: final_text */
    public interface ReactionUnitGametimeTableComponentFragment {
    }

    /* compiled from: final_text */
    public interface ReactionUnitPhotoComponentFragment {
    }

    /* compiled from: final_text */
    public interface ReactionUnitReviewComposerComponentFragment {
    }
}
