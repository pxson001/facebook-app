package com.facebook.presence;

/* compiled from: import_from_gallery */
public interface TypingPresenceManager {

    /* compiled from: import_from_gallery */
    public enum TypingState {
        INACTIVE(0),
        ACTIVE(1);
        
        public final int value;

        private TypingState(int i) {
            this.value = i;
        }
    }

    void mo616a(String str, TypingState typingState);
}
