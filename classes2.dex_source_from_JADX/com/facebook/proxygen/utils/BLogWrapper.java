package com.facebook.proxygen.utils;

import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.debug.log.BLog;
import com.facebook.debug.log.BLogLevelCallback;
import com.facebook.proxygen.HTTPTransportCallback;
import com.facebook.proxygen.utils.GLogHandler.GLogSeverity;
import com.google.common.base.Preconditions;
import javax.annotation.Nullable;

/* compiled from: profilepictureupload */
public class BLogWrapper implements BLogLevelCallback, BLogHandler {
    private static final Class<?> TAG = BLogWrapper.class;
    private final AbstractFbErrorReporter mErrorReporter;
    @Nullable
    private GLogWrapper mGLogWrapper;

    public BLogWrapper(AbstractFbErrorReporter abstractFbErrorReporter) {
        this.mErrorReporter = abstractFbErrorReporter;
    }

    public void init() {
        this.mGLogWrapper = new GLogWrapper(this);
        BLog.a(this);
        onLogLevelChanged(BLog.a());
    }

    public void onLogLevelChanged(int i) {
        Preconditions.checkNotNull(this.mGLogWrapper);
        switch (i) {
            case HTTPTransportCallback.FIRST_BODY_BYTE_FLUSHED /*2*/:
                this.mGLogWrapper.setMinLogLevel(GLogSeverity.INFO);
                this.mGLogWrapper.setVLogLevel(Integer.MAX_VALUE);
                return;
            case 3:
                this.mGLogWrapper.setMinLogLevel(GLogSeverity.INFO);
                this.mGLogWrapper.setVLogLevel(2);
                return;
            case HTTPTransportCallback.LAST_BODY_BYTE_FLUSHED /*4*/:
                this.mGLogWrapper.setMinLogLevel(GLogSeverity.INFO);
                this.mGLogWrapper.setVLogLevel(1);
                return;
            case 5:
                this.mGLogWrapper.setMinLogLevel(GLogSeverity.WARNING);
                this.mGLogWrapper.setVLogLevel(1);
                return;
            default:
                try {
                    this.mGLogWrapper.setVLogLevel(1);
                    this.mGLogWrapper.setMinLogLevel(GLogSeverity.ERROR);
                    return;
                } catch (Throwable th) {
                    BLog.b(TAG, "Exception setting the glog logging level", th);
                    return;
                }
        }
    }

    public void log(GLogSeverity gLogSeverity, String str) {
        switch (1.$SwitchMap$com$facebook$proxygen$utils$GLogHandler$GLogSeverity[gLogSeverity.ordinal()]) {
            case HTTPTransportCallback.FIRST_BODY_BYTE_FLUSHED /*2*/:
                BLog.a(TAG, str);
                return;
            case 3:
            case HTTPTransportCallback.LAST_BODY_BYTE_FLUSHED /*4*/:
                BLog.b(TAG, str);
                this.mErrorReporter.m2340a(TAG.getSimpleName(), str);
                return;
            default:
                return;
        }
    }
}
