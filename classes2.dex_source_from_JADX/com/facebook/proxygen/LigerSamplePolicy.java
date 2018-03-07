package com.facebook.proxygen;

/* compiled from: not a valid Float value */
public class LigerSamplePolicy implements SamplePolicy {
    private boolean mCellTowerSampled;
    private boolean mCertSampled;
    private boolean mFlowTimeSampled;
    private int mFlowTimeWeight;
    private boolean mPrintTraceEvents;

    public LigerSamplePolicy(int i, boolean z) {
        boolean z2;
        boolean z3 = true;
        this.mFlowTimeWeight = i;
        if (Math.random() < 1.0d / ((double) this.mFlowTimeWeight)) {
            z2 = true;
        } else {
            z2 = false;
        }
        this.mFlowTimeSampled = z2;
        if (Math.random() < 2.0E-4d) {
            z2 = true;
        } else {
            z2 = false;
        }
        this.mCertSampled = z2;
        if (Math.random() >= 1.0E-4d) {
            z3 = false;
        }
        this.mCellTowerSampled = z3;
        this.mPrintTraceEvents = z;
    }

    public int getFlowTimeWeight() {
        return this.mFlowTimeWeight;
    }

    public boolean isSampled() {
        return this.mFlowTimeSampled || this.mCertSampled || this.mCellTowerSampled || this.mPrintTraceEvents;
    }

    public boolean isFlowTimeSampled() {
        return this.mFlowTimeSampled;
    }

    public boolean isCertSampled() {
        return this.mCertSampled;
    }

    public boolean isCellTowerSampled() {
        return this.mCellTowerSampled;
    }

    public boolean shouldPrintTraceEvents() {
        return this.mPrintTraceEvents;
    }
}
