package com.exemplo.model;

import io.quarkus.hibernate.orm.rest.data.panache.PanacheEntityResource;
import io.quarkus.rest.data.panache.MethodProperties;

public interface ProdutoResource extends PanacheEntityResource<Produto, Long> {
    @MethodProperties(exposed = false)
    boolean delete(Long id);
}
