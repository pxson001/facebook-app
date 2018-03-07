package android.support.v7.media;

import android.os.Messenger;

/* compiled from: current_song_album */
abstract class MediaRouteProviderProtocol {
    MediaRouteProviderProtocol() {
    }

    public static boolean m20337a(Messenger messenger) {
        if (messenger == null) {
            return false;
        }
        try {
            return messenger.getBinder() != null;
        } catch (NullPointerException e) {
            return false;
        }
    }
}
