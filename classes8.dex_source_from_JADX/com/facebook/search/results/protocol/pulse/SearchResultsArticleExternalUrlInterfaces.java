package com.facebook.search.results.protocol.pulse;

import com.facebook.search.results.protocol.pulse.SearchResultsArticleExternalUrlModels.SearchResultsArticleExternalUrlModel.LinkMediaModel.PulseCoverPhotoModel;
import com.facebook.search.results.protocol.pulse.SearchResultsArticleExternalUrlModels.SearchResultsArticleExternalUrlModel.OpenGraphNodeModel;
import com.facebook.search.results.protocol.pulse.SearchResultsArticleExternalUrlModels.SearchResultsArticleExternalUrlModel.SummaryModel;
import javax.annotation.Nullable;

/* compiled from: moments_promotion */
public class SearchResultsArticleExternalUrlInterfaces {

    /* compiled from: moments_promotion */
    public interface SearchResultsArticleExternalUrl {

        /* compiled from: moments_promotion */
        public interface LinkMedia {
            @Nullable
            PulseCoverPhotoModel mo566c();
        }

        /* compiled from: moments_promotion */
        public interface Title {
            @Nullable
            String mo568a();
        }

        @Nullable
        OpenGraphNodeModel mo574E();

        @Nullable
        SummaryModel mo579T();

        @Nullable
        Title ax();

        @Nullable
        LinkMedia ay();

        @Nullable
        String mo593v();
    }
}
