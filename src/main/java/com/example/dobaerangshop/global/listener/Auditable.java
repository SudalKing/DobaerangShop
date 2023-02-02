package com.example.dobaerangshop.global.listener;

import java.time.LocalDateTime;

public interface Auditable {

    LocalDateTime getCreatedAt();
    LocalDateTime getUpdatedAt();

}
