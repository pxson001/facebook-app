package com.facebook.messaging.tincan.thrift;

import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.thrift.TException;

/* compiled from: checkpoint_cancel */
public class ThriftVersionTooNewException extends TException {
    private final int mCurrentVersion;
    private final int mNewVersion;

    public ThriftVersionTooNewException(int i, int i2) {
        this.mCurrentVersion = i;
        this.mNewVersion = i2;
    }

    public String getMessage() {
        return StringFormatUtil.a("Expected packet version %d, got %d", new Object[]{Integer.valueOf(this.mCurrentVersion), Integer.valueOf(this.mNewVersion)});
    }
}
