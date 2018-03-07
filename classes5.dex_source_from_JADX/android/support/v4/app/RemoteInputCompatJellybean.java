package android.support.v4.app;

import android.os.Bundle;
import android.support.v4.app.RemoteInputCompatBase.RemoteInput;

/* compiled from: warnAcknowledged */
public class RemoteInputCompatJellybean {
    RemoteInputCompatJellybean() {
    }

    public static Bundle[] m213a(RemoteInput[] remoteInputArr) {
        if (remoteInputArr == null) {
            return null;
        }
        Bundle[] bundleArr = new Bundle[remoteInputArr.length];
        for (int i = 0; i < remoteInputArr.length; i++) {
            RemoteInput remoteInput = remoteInputArr[i];
            Bundle bundle = new Bundle();
            bundle.putString("resultKey", remoteInput.mo36a());
            bundle.putCharSequence("label", remoteInput.mo37b());
            bundle.putCharSequenceArray("choices", remoteInput.mo38c());
            bundle.putBoolean("allowFreeFormInput", remoteInput.mo39d());
            bundle.putBundle("extras", remoteInput.mo40e());
            bundleArr[i] = bundle;
        }
        return bundleArr;
    }
}
