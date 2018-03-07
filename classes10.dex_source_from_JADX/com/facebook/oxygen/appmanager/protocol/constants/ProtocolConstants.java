package com.facebook.oxygen.appmanager.protocol.constants;

/* compiled from: mReplyTargetThreadKey == null */
public class ProtocolConstants {

    /* compiled from: mReplyTargetThreadKey == null */
    public enum ClientAction {
        UPDATE_EXPLICIT_APPROVAL(1),
        UPDATE_AUTO_APPROVAL(2),
        UPDATE_NO_APPROVAL(3);
        
        private final int value;

        private ClientAction(int i) {
            this.value = i;
        }

        public final int asInt() {
            return this.value;
        }

        public static ClientAction getDefault() {
            return UPDATE_EXPLICIT_APPROVAL;
        }

        public static ClientAction fromInt(int i) {
            for (ClientAction clientAction : values()) {
                if (clientAction.value == i) {
                    return clientAction;
                }
            }
            return getDefault();
        }
    }

    /* compiled from: mReplyTargetThreadKey == null */
    public enum DownloadNetworks {
        MOBILE(1),
        WIFI(2),
        ALL(3);
        
        private final int value;

        private DownloadNetworks(int i) {
            this.value = i;
        }

        public final int asInt() {
            return this.value;
        }

        public static DownloadNetworks getDefault() {
            return WIFI;
        }

        public static DownloadNetworks fromInt(int i) {
            for (DownloadNetworks downloadNetworks : values()) {
                if (downloadNetworks.value == i) {
                    return downloadNetworks;
                }
            }
            return WIFI;
        }
    }
}
