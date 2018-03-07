package com.facebook.omnistore.mqtt;

import android.os.RemoteException;
import com.facebook.debug.log.BLog;
import com.facebook.omnistore.mqtt.MessagePublisher.FailedToPublishException;
import com.google.common.util.concurrent.FutureCallback;
import javax.annotation.Nullable;

/* compiled from: fb_server_registered_hash */
public class OmnistoreMqttJniHandler$2 implements FutureCallback<Void> {
    public final /* synthetic */ OmnistoreMqttJniHandler this$0;
    public final /* synthetic */ PublishCallback val$publishCallback;
    final /* synthetic */ String val$topicName;

    OmnistoreMqttJniHandler$2(OmnistoreMqttJniHandler omnistoreMqttJniHandler, String str, PublishCallback publishCallback) {
        this.this$0 = omnistoreMqttJniHandler;
        this.val$topicName = str;
        this.val$publishCallback = publishCallback;
    }

    public /* bridge */ /* synthetic */ void onSuccess(@Nullable Object obj) {
        Void voidR = (Void) obj;
        OmnistoreMqttJniHandler.access$100(this.this$0, this.val$publishCallback);
    }

    public void onFailure(Throwable th) {
        if ((th instanceof FailedToPublishException) || (th instanceof RemoteException)) {
            BLog.a("OmnistoreMqttJniHandler", th, "Publish on topic %s failed", new Object[]{this.val$topicName});
        } else {
            this.this$0.mFbErrorReporter.a("OmnistoreMqttJniHandler", "Unexpected publish failure", th);
        }
        OmnistoreMqttJniHandler.access$300(this.this$0, this.val$publishCallback);
    }
}
