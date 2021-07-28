package com.example.accessingdatajpa.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Objects;

/**
 * @author daniellaera
 * @since 28.07.2021
 */
public abstract class GenericServiceImpl<T, E extends AbstractEntity<T>, D> implements GenericService<T, E, D> {

    /**
     * Logger.
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(GenericServiceImpl.class);

    /**
     * The repository
     */
    protected final JpaRepository<E, T> repository;

    /**
     * Generic Constructor to inject parameters
     *
     * @param repository
     */
    protected GenericServiceImpl(final JpaRepository<E, T> repository) {
        super();
        this.repository = repository;
    }

    /**
     * Gets the repository
     *
     * @return the repository
     */
    protected abstract JpaRepository<E, T> getRepository();

    @Override
    public D create(D dto) throws Exception {
        final E object = this.fromDto(dto);
        final T id = object.getId();
        if (Objects.nonNull(id)) {
            final String objName = object.getClass().getName();
            final String error = String.format("Impossible to create object of type %s : id %s shozld be null", objName, id);
            LOGGER.error(error);
            throw new Exception(error);
        }

        final E createdObject = this.repository.save(object);
        return this.toDto(createdObject);
    }
}
