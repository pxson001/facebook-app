package android.support.v4.app;

import android.app.RemoteInput;
import android.app.RemoteInput.Builder;

/* compiled from: wasFetchSynchronous */
public class RemoteInputCompatApi20 {
    RemoteInputCompatApi20() {
    }

    public static RemoteInput[] m212a(RemoteInputCompatBase.RemoteInput[] remoteInputArr) {
        if (remoteInputArr == null) {
            return null;
        }
        RemoteInput[] remoteInputArr2 = new RemoteInput[remoteInputArr.length];
        for (int i = 0; i < remoteInputArr.length; i++) {
            RemoteInputCompatBase.RemoteInput remoteInput = remoteInputArr[i];
            remoteInputArr2[i] = new Builder(remoteInput.mo36a()).setLabel(remoteInput.mo37b()).setChoices(remoteInput.mo38c()).setAllowFreeFormInput(remoteInput.mo39d()).addExtras(remoteInput.mo40e()).build();
        }
        return remoteInputArr2;
    }
}
