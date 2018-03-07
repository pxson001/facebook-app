package com.facebook.adinterfaces.protocol;

/* compiled from: [A-Z]{2}[ ]?[A-Z0-9]{2} */
public class AdInterfacesConstants {

    /* compiled from: [A-Z]{2}[ ]?[A-Z0-9]{2} */
    public enum CampaignStatus {
        UPDATE_BUDGET("RESUME"),
        RESUME("RESUME"),
        PAUSE("STOP");
        
        private final String mCampaignStatus;

        private CampaignStatus(String str) {
            this.mCampaignStatus = str;
        }

        public final String getCampaignStatusString() {
            return this.mCampaignStatus;
        }
    }
}
