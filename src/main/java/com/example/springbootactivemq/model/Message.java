package com.example.springbootactivemq.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serial;
import java.io.Serializable;

@Getter
@Setter
@ToString
public class Message implements Serializable {

    @Serial
    private static final long serialVersionUID =1L;

    private String source;
    private String message;

}
