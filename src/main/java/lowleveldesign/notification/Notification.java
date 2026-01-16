package lowleveldesign.notification;

import java.util.UUID;

public class Notification {

    private final String id;

    private final String message;

    private final String subject;

    private final NotificationType type;

    private final Recipient recipient;

    private Notification(Builder builder) {

        this.id = UUID.randomUUID().toString();
        message = builder.message;
        subject = builder.subject;
        type = builder.type;
        recipient = builder.recipient;
    }

    public String getId() {
        return id;
    }

    public String getMessage() {
        return message;
    }

    public String getSubject() {
        return subject;
    }

    public NotificationType getType() {
        return type;
    }

    public Recipient getRecipient() {
        return recipient;
    }

    public static class Builder {

        private String message;

        private String subject;

        private final NotificationType type;

        private final Recipient recipient;

        public Builder(NotificationType type, Recipient recipient) {
            this.type = type;
            this.recipient = recipient;
        }

        public Builder withMessage(String message) {
            this.message = message;
            return this;
        }

        public Builder withSubject(String subject) {
            this.subject = subject;
            return this;
        }

        public Notification build() {
            return new Notification(this);
        }


    }
}

