package com.facebook.ufiservices.qe;

import android.content.Context;
import com.facebook.abtest.qe.bootstrap.data.QuickExperimentParameters;
import com.facebook.abtest.qe.bootstrap.framework.QuickExperiment;
import com.facebook.proxygen.HTTPTransportCallback;
import javax.annotation.concurrent.Immutable;
import javax.inject.Inject;

/* compiled from: friending_poke_user */
public class PerAttachmentMessageTruncatorQuickExperiment implements QuickExperiment<Config> {
    private final Context f23107a;

    @Immutable
    /* compiled from: friending_poke_user */
    public class Config {
        public final boolean f23108a;
        private final QuickExperimentParameters f23109b;
        public final Context f23110c;

        public Config(QuickExperimentParameters quickExperimentParameters, Context context) {
            this.f23109b = quickExperimentParameters;
            this.f23110c = context;
            this.f23108a = quickExperimentParameters.m15063a("is_enabled", false);
        }

        public final int m31234a(AttachmentType attachmentType) {
            String str;
            switch (this.f23110c.getResources().getConfiguration().screenLayout & 15) {
                case HTTPTransportCallback.FIRST_HEADER_BYTE_FLUSHED /*1*/:
                    str = "_small";
                    break;
                case 3:
                    str = "_large";
                    break;
                case HTTPTransportCallback.LAST_BODY_BYTE_FLUSHED /*4*/:
                    str = "_xlarge";
                    break;
                default:
                    str = "";
                    break;
            }
            return this.f23109b.m15060a(attachmentType.toString() + str, -1);
        }
    }

    @Inject
    public PerAttachmentMessageTruncatorQuickExperiment(Context context) {
        this.f23107a = context;
    }

    public final Object mo1958a(QuickExperimentParameters quickExperimentParameters) {
        return new Config(quickExperimentParameters, this.f23107a);
    }

    public final String mo1959a() {
        return "fb4a_per_attachment_truncation";
    }
}
