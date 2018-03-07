package com.facebook.omnistore;

import com.facebook.proguard.annotations.DoNotStrip;
import java.nio.ByteBuffer;
import javax.annotation.Nullable;

@DoNotStrip
/* compiled from: mBreadCrumbShortTitleRes=# */
public class Delta {
    @Nullable
    public ByteBuffer mBlob;
    public CollectionName mCollectionName;
    public String mPrimaryKey;
    @Nullable
    public String mSortKey;
    public Status mStatus;
    public Type mType;

    @DoNotStrip
    /* compiled from: mBreadCrumbShortTitleRes=# */
    public enum Type {
        SAVE,
        DELETE
    }

    @DoNotStrip
    /* compiled from: mBreadCrumbShortTitleRes=# */
    public enum Status {
        LOCALLY_COMMITTED,
        ACKED,
        PERSISTED_LOCAL,
        PERSISTED_REMOTE
    }

    @DoNotStrip
    private Delta(CollectionName collectionName, String str, Type type, @Nullable String str2, @Nullable ByteBuffer byteBuffer, Status status) {
        this.mCollectionName = collectionName;
        this.mPrimaryKey = str;
        this.mType = type;
        this.mSortKey = str2;
        this.mBlob = byteBuffer;
        this.mStatus = status;
    }

    public CollectionName getCollectionName() {
        return this.mCollectionName;
    }

    public String getPrimaryKey() {
        return this.mPrimaryKey;
    }

    public Type getType() {
        return this.mType;
    }

    @Nullable
    public String getSortKey() {
        return this.mSortKey;
    }

    @Nullable
    public ByteBuffer getBlob() {
        return this.mBlob;
    }

    public Status getStatus() {
        return this.mStatus;
    }

    public Delta copy() {
        ByteBuffer byteBuffer = null;
        if (this.mBlob != null) {
            byte[] bArr = new byte[this.mBlob.limit()];
            this.mBlob.get(bArr);
            byteBuffer = ByteBuffer.wrap(bArr);
        }
        return new Delta(this.mCollectionName, this.mPrimaryKey, this.mType, this.mSortKey, byteBuffer, this.mStatus);
    }
}
