package com.facebook.omnistore.module;

import java.nio.ByteBuffer;

/* compiled from: target_width */
public interface OmnistoreStoredProcedureComponent {
    void onSenderAvailable(OmnistoreComponentManager$OmnistoreStoredProcedureSender omnistoreComponentManager$OmnistoreStoredProcedureSender);

    void onSenderInvalidated();

    void onStoredProcedureResult(ByteBuffer byteBuffer);

    int provideStoredProcedureId();
}
