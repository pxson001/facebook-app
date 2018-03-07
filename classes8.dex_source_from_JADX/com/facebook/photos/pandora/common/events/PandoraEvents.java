package com.facebook.photos.pandora.common.events;

import android.net.Uri;
import com.facebook.graphql.model.GraphQLPhoto;
import com.facebook.graphql.model.GraphQLVideo;
import com.facebook.photos.pandora.common.data.PandoraInstanceId;
import com.facebook.photos.pandora.common.source.PandoraRequestSource;
import javax.annotation.Nullable;

/* compiled from: commercial_break_start_time_ms */
public class PandoraEvents {

    /* compiled from: commercial_break_start_time_ms */
    public class LaunchConsumptionGalleryEvent extends PandoraEvent {
        public final String f17374a;
        @Nullable
        public final Uri f17375b;
        public final PandoraInstanceId f17376c;
        public final PandoraRequestSource f17377d;
        @Nullable
        public final GraphQLPhoto f17378e;
        @Nullable
        public final GraphQLVideo f17379f;

        public LaunchConsumptionGalleryEvent(String str, Uri uri, PandoraInstanceId pandoraInstanceId, PandoraRequestSource pandoraRequestSource, GraphQLPhoto graphQLPhoto) {
            this.f17374a = str;
            this.f17375b = uri;
            this.f17376c = pandoraInstanceId;
            this.f17377d = pandoraRequestSource;
            this.f17378e = graphQLPhoto;
            this.f17379f = null;
        }

        public LaunchConsumptionGalleryEvent(String str, PandoraInstanceId pandoraInstanceId, PandoraRequestSource pandoraRequestSource, GraphQLVideo graphQLVideo) {
            this.f17374a = str;
            this.f17375b = null;
            this.f17376c = pandoraInstanceId;
            this.f17377d = pandoraRequestSource;
            this.f17378e = null;
            this.f17379f = graphQLVideo;
        }
    }

    /* compiled from: commercial_break_start_time_ms */
    public abstract class LaunchConsumptionGalleryEventSubscriber extends PandoraEventSubscriber<LaunchConsumptionGalleryEvent> {
        public final Class<LaunchConsumptionGalleryEvent> m21376a() {
            return LaunchConsumptionGalleryEvent.class;
        }
    }
}
