package com.facebook.photos.albums.events;

import com.facebook.graphql.model.GraphQLAlbum;
import com.facebook.graphql.model.GraphQLTextWithEntities;
import com.facebook.photos.albums.protocols.VideosUploadedByUserGraphQLModels.VideoDetailFragmentModel;

/* compiled from: magic_stories_kit_picker_nux_seen */
public class AlbumsEvents {

    /* compiled from: magic_stories_kit_picker_nux_seen */
    public class AlbumCreatedEvent extends AlbumsEvent {
        public final String f9440a;

        public AlbumCreatedEvent(String str) {
            this.f9440a = str;
        }
    }

    /* compiled from: magic_stories_kit_picker_nux_seen */
    public abstract class AlbumCreatedEventSubscriber extends AlbumsEventSubscriber<AlbumCreatedEvent> {
        public final Class<AlbumCreatedEvent> m11401a() {
            return AlbumCreatedEvent.class;
        }
    }

    /* compiled from: magic_stories_kit_picker_nux_seen */
    public class AlbumDeletedEvent extends AlbumsEvent {
        public final String f9441a;

        public AlbumDeletedEvent(String str) {
            this.f9441a = str;
        }
    }

    /* compiled from: magic_stories_kit_picker_nux_seen */
    public abstract class AlbumDeletedEventSubscriber extends AlbumsEventSubscriber<AlbumDeletedEvent> {
        public final Class<AlbumDeletedEvent> m11402a() {
            return AlbumDeletedEvent.class;
        }
    }

    /* compiled from: magic_stories_kit_picker_nux_seen */
    public class AlbumSelectedEvent extends AlbumsEvent {
        public final GraphQLAlbum f9442a;
        public final String f9443b;

        public AlbumSelectedEvent(GraphQLAlbum graphQLAlbum, String str) {
            this.f9442a = graphQLAlbum;
            this.f9443b = str;
        }
    }

    /* compiled from: magic_stories_kit_picker_nux_seen */
    public abstract class AlbumSelectedEventSubscriber extends AlbumsEventSubscriber<AlbumSelectedEvent> {
        public final Class<AlbumSelectedEvent> m11403a() {
            return AlbumSelectedEvent.class;
        }
    }

    /* compiled from: magic_stories_kit_picker_nux_seen */
    public class AlbumTitleRenamedEvent extends AlbumsEvent {
        public final GraphQLTextWithEntities f9444a;

        public AlbumTitleRenamedEvent(GraphQLTextWithEntities graphQLTextWithEntities) {
            this.f9444a = graphQLTextWithEntities;
        }
    }

    /* compiled from: magic_stories_kit_picker_nux_seen */
    public abstract class AlbumTitleRenamedEventSubscriber extends AlbumsEventSubscriber<AlbumTitleRenamedEvent> {
        public final Class<AlbumTitleRenamedEvent> m11404a() {
            return AlbumTitleRenamedEvent.class;
        }
    }

    /* compiled from: magic_stories_kit_picker_nux_seen */
    public class LaunchVideoPlayerEvent extends AlbumsEvent {
        public VideoDetailFragmentModel f9445a;

        public LaunchVideoPlayerEvent(VideoDetailFragmentModel videoDetailFragmentModel) {
            this.f9445a = videoDetailFragmentModel;
        }
    }

    /* compiled from: magic_stories_kit_picker_nux_seen */
    public abstract class LaunchVideoPlayerEventSubscriber extends AlbumsEventSubscriber<LaunchVideoPlayerEvent> {
        public final Class<LaunchVideoPlayerEvent> m11405a() {
            return LaunchVideoPlayerEvent.class;
        }
    }

    /* compiled from: magic_stories_kit_picker_nux_seen */
    public class ToggleContributorsEvent extends AlbumsEvent {
        public final GraphQLAlbum f9446a;

        public ToggleContributorsEvent(GraphQLAlbum graphQLAlbum) {
            this.f9446a = graphQLAlbum;
        }
    }

    /* compiled from: magic_stories_kit_picker_nux_seen */
    public abstract class ToggleContributorsEventSubscriber extends AlbumsEventSubscriber<ToggleContributorsEvent> {
        public final Class<ToggleContributorsEvent> m11406a() {
            return ToggleContributorsEvent.class;
        }
    }

    /* compiled from: magic_stories_kit_picker_nux_seen */
    public class VideoAlbumSelectedEvent extends AlbumsEvent {
    }

    /* compiled from: magic_stories_kit_picker_nux_seen */
    public abstract class VideoAlbumSelectedEventSubscriber extends AlbumsEventSubscriber<VideoAlbumSelectedEvent> {
        public final Class<VideoAlbumSelectedEvent> m11407a() {
            return VideoAlbumSelectedEvent.class;
        }
    }
}
