package com.mdymen.pubsub;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

@Data
@ToString
public class TestObject implements Serializable {

    private String text;

    public TestObject(){}

    @Builder
    public TestObject(String text) {
        this.text = text;
    }
}
