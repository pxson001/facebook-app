package com.facebook.video.player.events;

/* compiled from: composer_cancel_privacy */
class RichVideoPlayerEventBus$1 implements Runnable {
    final /* synthetic */ RichVideoPlayerEvent f19297a;
    final /* synthetic */ RichVideoPlayerEventBus f19298b;

    RichVideoPlayerEventBus$1(RichVideoPlayerEventBus richVideoPlayerEventBus, RichVideoPlayerEvent richVideoPlayerEvent) {
        this.f19298b = richVideoPlayerEventBus;
        this.f19297a = richVideoPlayerEvent;
    }

    public void run() {
        this.f19298b.a(this.f19297a);
    }
}
