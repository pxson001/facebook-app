package com.facebook.ui.images.fetch;

import android.os.Handler;
import android.os.Message;

/* compiled from: secondary_button */
public abstract class FetchImageProgressHandler extends Handler {
    protected abstract void mo395b(int i);

    public void handleMessage(Message message) {
        switch (message.what) {
            case 1:
                mo395b(message.arg1);
                return;
            default:
                return;
        }
    }
}
