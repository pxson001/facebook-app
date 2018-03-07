package com.facebook.crowdsourcing.protocol.graphql;

import com.facebook.crowdsourcing.protocol.graphql.SuggestEditsModels.CrowdsourcedFieldModel;
import com.facebook.crowdsourcing.protocol.graphql.SuggestEditsModels.SuggestEditsFieldModel.OptionsModel;
import com.facebook.graphql.enums.GraphQLSuggestEditsFieldOptionType;
import com.google.common.collect.ImmutableList;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/* compiled from: sync_resume_queue_connection_attempt */
public class SuggestEditsInterfaces {

    /* compiled from: sync_resume_queue_connection_attempt */
    public interface CrowdsourcedAddress {
    }

    /* compiled from: sync_resume_queue_connection_attempt */
    public interface CrowdsourcedCategory {
    }

    /* compiled from: sync_resume_queue_connection_attempt */
    public interface CrowdsourcedHours {
        @Nonnull
        ImmutableList<? extends Fri> mo99d();

        @Nonnull
        ImmutableList<? extends Mon> et_();

        @Nonnull
        ImmutableList<? extends Sat> eu_();

        @Nonnull
        ImmutableList<? extends Sun> mo102k();

        @Nonnull
        ImmutableList<? extends Thu> mo103m();

        @Nonnull
        ImmutableList<? extends Tue> mo104n();

        @Nonnull
        ImmutableList<? extends Wed> mo105o();
    }

    /* compiled from: sync_resume_queue_connection_attempt */
    public interface CrowdsourcedLocatedIn {
    }

    /* compiled from: sync_resume_queue_connection_attempt */
    public interface CrowdsourcedPhoto {
    }

    /* compiled from: sync_resume_queue_connection_attempt */
    public interface SuggestEditsField {
        @Nullable
        String mo106a();

        @Nullable
        String mo107b();

        @Nullable
        CrowdsourcedFieldModel mo108c();

        @Nullable
        String mo109d();

        @Nullable
        GraphQLSuggestEditsFieldOptionType ew_();

        @Nullable
        String ex_();

        @Nullable
        OptionsModel ey_();

        @Nullable
        String mo113g();

        @Nullable
        String mo114j();
    }
}
