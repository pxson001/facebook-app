package com.facebook.placetips.pulsarcore.scan;

/* compiled from: TYPEAHEAD_SUGGESTION */
public class BleScanException extends Exception {

    /* compiled from: TYPEAHEAD_SUGGESTION */
    public class BleNotAllowedException extends BleScanException {
    }

    /* compiled from: TYPEAHEAD_SUGGESTION */
    public class BleNotSupportedException extends BleScanException {
    }

    /* compiled from: TYPEAHEAD_SUGGESTION */
    public class BluetoothDiscoveryInterruptException extends BleScanException {
    }

    /* compiled from: TYPEAHEAD_SUGGESTION */
    public class BluetoothTurnedOffException extends BleScanException {
    }

    public BleScanException(String str) {
        super(str);
    }
}
