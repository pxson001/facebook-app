package com.facebook.omnistore;

import com.facebook.jni.Countable;
import com.facebook.omnistore.CollectionName.Builder;
import com.facebook.proguard.annotations.DoNotStrip;
import com.facebook.xanalytics.XAnalyticsNative;
import java.nio.ByteBuffer;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;

@DoNotStrip
/* compiled from: total_mobile_bytes_received */
public class Omnistore extends Countable {
    @GuardedBy("this")
    private boolean mIsRemoved = false;

    @DoNotStrip
    /* compiled from: total_mobile_bytes_received */
    public interface CollectionIndexerFunction {
        @DoNotStrip
        IndexedFields getIndexedFields(CollectionName collectionName, String str, String str2, ByteBuffer byteBuffer);
    }

    @DoNotStrip
    /* compiled from: total_mobile_bytes_received */
    public interface DeltaReceivedCallback {
        @DoNotStrip
        void onDeltaReceived(Delta[] deltaArr);
    }

    @DoNotStrip
    /* compiled from: total_mobile_bytes_received */
    public interface StoredProcedureResultCallback {
        @DoNotStrip
        void onStoredProcedureResult(int i, ByteBuffer byteBuffer);
    }

    private native void doApplyStoredProcedure(int i, byte[] bArr);

    private native String doGetDebugInfo();

    private native String[] doGetSubscriptionCollectionNames();

    private native void doRemove();

    private native void doStart();

    private native Collection doSubscribeCollection(CollectionName collectionName, String str, String str2, long j);

    private native void doUnsubscribeCollection(CollectionName collectionName);

    private native String[] doWriteBugReport(String str);

    public static native Omnistore open(String str, String str2, MqttProtocolProvider mqttProtocolProvider, OmnistoreErrorReporter omnistoreErrorReporter, XAnalyticsNative xAnalyticsNative, boolean z, boolean z2, boolean z3);

    public native void addDeltaReceivedCallback(DeltaReceivedCallback deltaReceivedCallback);

    public native void addStoredProcedureResultCallback(StoredProcedureResultCallback storedProcedureResultCallback);

    public native Builder createCollectionNameBuilder(String str);

    public native void setCollectionIndexerFunction(@Nullable CollectionIndexerFunction collectionIndexerFunction);

    static {
        Prerequisites.ensure();
    }

    @DoNotStrip
    private Omnistore() {
    }

    public synchronized void start() {
        if (!this.mIsRemoved) {
            doStart();
        }
    }

    public Collection subscribeCollection(CollectionName collectionName) {
        return subscribeCollection(collectionName, new SubscriptionParams.Builder().build());
    }

    public synchronized Collection subscribeCollection(CollectionName collectionName, SubscriptionParams subscriptionParams) {
        if (this.mIsRemoved) {
            throw new OmnistoreException("Called subscribeCollection after remove");
        }
        return doSubscribeCollection(collectionName, subscriptionParams.getCollectionParams(), subscriptionParams.getIdl(), subscriptionParams.getInitialGlobalVersionId());
    }

    public synchronized void unsubscribeCollection(CollectionName collectionName) {
        if (!this.mIsRemoved) {
            doUnsubscribeCollection(collectionName);
        }
    }

    public synchronized void remove() {
        if (!this.mIsRemoved) {
            this.mIsRemoved = true;
            doRemove();
        }
    }

    public synchronized String[] getSubscriptionCollectionNames() {
        String[] strArr;
        if (this.mIsRemoved) {
            strArr = new String[0];
        } else {
            strArr = doGetSubscriptionCollectionNames();
        }
        return strArr;
    }

    public synchronized String getDebugInfo() {
        String str;
        if (this.mIsRemoved) {
            str = "Omnistore removed";
        } else {
            str = doGetDebugInfo();
        }
        return str;
    }

    public synchronized String[] writeBugReport(String str) {
        String[] strArr;
        if (this.mIsRemoved) {
            strArr = new String[0];
        } else {
            strArr = doWriteBugReport(str);
        }
        return strArr;
    }

    public synchronized void applyStoredProcedure(int i, byte[] bArr) {
        if (!this.mIsRemoved) {
            doApplyStoredProcedure(i, bArr);
        }
    }
}
