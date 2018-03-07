package com.facebook.photos.upload.event;

import com.facebook.photos.upload.operation.UploadOperation;

/* compiled from: graph_search_v2_null_state_keyword_recent_searches */
public class LifeEventUploadEvent extends BaseMediaUploadEvent {
    public final String f13620a;

    /* compiled from: graph_search_v2_null_state_keyword_recent_searches */
    public abstract class LifeEventUploadEventSubscriber extends MediaUploadEventSubscriber<LifeEventUploadEvent> {
        public final Class<LifeEventUploadEvent> m21341a() {
            return LifeEventUploadEvent.class;
        }
    }

    public LifeEventUploadEvent(UploadOperation uploadOperation, BaseMediaUploadEvent$Status baseMediaUploadEvent$Status, String str) {
        super(uploadOperation, baseMediaUploadEvent$Status, -1);
        this.f13620a = str;
    }
}
