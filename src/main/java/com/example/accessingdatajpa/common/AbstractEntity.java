package com.example.accessingdatajpa.common;

import java.io.Serializable;

public abstract class AbstractEntity<K> implements Serializable {

    private static final long serialVersionUID = 6614393622355048878L;

    public abstract K getId();

    public abstract void setId(K id);
}
