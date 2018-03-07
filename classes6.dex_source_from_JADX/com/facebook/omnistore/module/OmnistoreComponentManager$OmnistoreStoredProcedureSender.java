package com.facebook.omnistore.module;

import com.facebook.debug.log.BLog;

/* compiled from: textAppearanceResId is not defined or not a resource. */
public class OmnistoreComponentManager$OmnistoreStoredProcedureSender {
    private final int mStoredProcedureId;
    final /* synthetic */ OmnistoreComponentManager this$0;

    public OmnistoreComponentManager$OmnistoreStoredProcedureSender(OmnistoreComponentManager omnistoreComponentManager, int i) {
        this.this$0 = omnistoreComponentManager;
        this.mStoredProcedureId = i;
    }

    public void callStoredProcedure(byte[] bArr) {
        synchronized (this.this$0.mOmnistoreMutex) {
            if (this.this$0.mOmnistore == null) {
                BLog.b(OmnistoreComponentManager.TAG, "Calling invalid stored procedure sender for storedProcedureId=%d", new Object[]{Integer.valueOf(this.mStoredProcedureId)});
                return;
            }
            this.this$0.mOmnistore.applyStoredProcedure(this.mStoredProcedureId, bArr);
        }
    }
}
