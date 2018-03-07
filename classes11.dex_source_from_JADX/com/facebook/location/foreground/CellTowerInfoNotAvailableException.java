package com.facebook.location.foreground;

/* compiled from: Unknown returned location model */
class CellTowerInfoNotAvailableException extends Exception {
    final Type type;

    /* compiled from: Unknown returned location model */
    enum Type {
        INCOMPATIBLE_DEVICE,
        PERMISSION_DENIED
    }

    CellTowerInfoNotAvailableException(Type type) {
        super("No cell tower information: " + type);
        this.type = type;
    }
}
