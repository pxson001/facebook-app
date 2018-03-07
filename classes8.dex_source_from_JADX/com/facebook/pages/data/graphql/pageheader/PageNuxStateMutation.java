package com.facebook.pages.data.graphql.pageheader;

import com.facebook.graphql.query.TypedGraphQLMutationString;
import com.facebook.pages.data.graphql.pageheader.PageNuxStateMutationModels.NotifyPageNuxShownMutationModel;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: confirmation_change_contactpoint_country_selected */
public final class PageNuxStateMutation {

    /* compiled from: confirmation_change_contactpoint_country_selected */
    public class NotifyPageNuxShownMutationString extends TypedGraphQLMutationString<NotifyPageNuxShownMutationModel> {
        public NotifyPageNuxShownMutationString() {
            super(NotifyPageNuxShownMutationModel.class, false, "NotifyPageNuxShownMutation", "374e79e764afe6701bb0b1b3a92b34ef", "notify_page_nux_shown", "0", "10154204804611729", RegularImmutableSet.a);
        }

        public final String m21307a(String str) {
            switch (str.hashCode()) {
                case 100358090:
                    return "0";
                default:
                    return str;
            }
        }
    }
}
