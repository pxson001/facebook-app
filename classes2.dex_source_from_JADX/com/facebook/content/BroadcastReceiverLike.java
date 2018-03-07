package com.facebook.content;

import android.os.Bundle;

/* compiled from: upload_batch_now */
public interface BroadcastReceiverLike {
    int getResultCode();

    String getResultData();

    Bundle getResultExtras(boolean z);

    boolean isInitialStickyBroadcast();

    void setResult(int i, String str, Bundle bundle);

    void setResultCode(int i);

    void setResultData(String str);

    void setResultExtras(Bundle bundle);
}
