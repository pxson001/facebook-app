package com.facebook.common.memory;

/* compiled from: show_video_home_follow_button */
class MemoryManager$3 implements Runnable {
    final /* synthetic */ MemoryTrimType f2710a;
    final /* synthetic */ MemoryManager f2711b;

    MemoryManager$3(MemoryManager memoryManager, MemoryTrimType memoryTrimType) {
        this.f2711b = memoryManager;
        this.f2710a = memoryTrimType;
    }

    public void run() {
        this.f2711b.a(this.f2710a);
    }
}
