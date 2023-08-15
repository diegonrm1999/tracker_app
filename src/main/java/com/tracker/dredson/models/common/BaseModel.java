package com.tracker.dredson.models.common;

import java.time.Instant;

import org.springframework.data.annotation.Id;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class BaseModel {
    @Id
    private String id;
    private Long modified;
    private Long created;
    private boolean deleted;
    private boolean updated;

    public BaseModel() {
        this.created = Instant.now().toEpochMilli();
        this.modified = Instant.now().toEpochMilli();
        this.deleted = false;
    }

    public void prepare() {
        if(id == null) {
        this.created = Instant.now().toEpochMilli();
        this.modified = Instant.now().toEpochMilli();
        this.deleted = false;
        } else {
            if(this.updated) {
                this.modified = Instant.now().toEpochMilli();
                this.updated = false;
            }
        }
    }
}
