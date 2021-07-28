package com.example.accessingdatajpa.common;

import org.springframework.transaction.annotation.Transactional;

public interface GenericService<T, E, D> {

    D toDto(final E bean);

    E fromDto(final D dto);

    @Transactional
    D create(final D dto) throws Exception;
}
