package com.facebook.fbui.draggable;

/* compiled from: research_poll */
public enum Direction {
    UP(1),
    DOWN(2),
    LEFT(4),
    RIGHT(8);
    
    private int mFlag;

    private Direction(int i) {
        this.mFlag = i;
    }

    public final int flag() {
        return this.mFlag;
    }

    public final boolean isSetInFlags(int i) {
        return (this.mFlag & i) == this.mFlag;
    }

    public final boolean isXAxis() {
        return this == LEFT || this == RIGHT;
    }

    public final boolean isYAxis() {
        return this == UP || this == DOWN;
    }
}
