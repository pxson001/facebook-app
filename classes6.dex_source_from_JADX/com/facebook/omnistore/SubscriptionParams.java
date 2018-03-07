package com.facebook.omnistore;

/* compiled from: textureID= */
public class SubscriptionParams {
    private Builder mBuilder;

    /* compiled from: textureID= */
    public class Builder {
        public String mCollectionParams = "";
        public String mIdl = "";
        public long mInitialGlobalVersionId = 0;

        public SubscriptionParams build() {
            return new SubscriptionParams(this);
        }

        public Builder collectionParams(String str) {
            this.mCollectionParams = str;
            return this;
        }

        public Builder idl(String str) {
            this.mIdl = str;
            return this;
        }

        public Builder initialGlobalVersionId(long j) {
            this.mInitialGlobalVersionId = j;
            return this;
        }
    }

    public SubscriptionParams(Builder builder) {
        this.mBuilder = builder;
    }

    public String getCollectionParams() {
        return this.mBuilder.mCollectionParams;
    }

    public String getIdl() {
        return this.mBuilder.mIdl;
    }

    public long getInitialGlobalVersionId() {
        return this.mBuilder.mInitialGlobalVersionId;
    }
}
