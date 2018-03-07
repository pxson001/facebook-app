package com.facebook.sync.service;

/* compiled from: fecb5d97214fb972f7bdff9356257ac9 */
public class MissedDeltaException extends Exception {
    public MissedDeltaException(long j, long j2) {
        super("New delta with sequenceId " + j + " is ahead of expected. lastSequenceId = " + j2);
    }
}
