package com.facebook.react.bridge.queue;

/* compiled from: getSystemAudioRoute */
public class MessageQueueThreadSpec {
    public static final MessageQueueThreadSpec f11564a = new MessageQueueThreadSpec(ThreadType.MAIN_UI, "main_ui");
    public final ThreadType f11565b;
    public final String f11566c;
    public final long f11567d;

    /* compiled from: getSystemAudioRoute */
    public enum ThreadType {
        MAIN_UI,
        NEW_BACKGROUND
    }

    public static MessageQueueThreadSpec m13572a(String str) {
        return new MessageQueueThreadSpec(ThreadType.NEW_BACKGROUND, str);
    }

    public static MessageQueueThreadSpec m13573a(String str, long j) {
        return new MessageQueueThreadSpec(ThreadType.NEW_BACKGROUND, str, j);
    }

    public static MessageQueueThreadSpec m13571a() {
        return f11564a;
    }

    private MessageQueueThreadSpec(ThreadType threadType, String str) {
        this(threadType, str, 0);
    }

    private MessageQueueThreadSpec(ThreadType threadType, String str, long j) {
        this.f11565b = threadType;
        this.f11566c = str;
        this.f11567d = j;
    }

    public final ThreadType m13574b() {
        return this.f11565b;
    }

    public final String m13575c() {
        return this.f11566c;
    }

    public final long m13576d() {
        return this.f11567d;
    }
}
