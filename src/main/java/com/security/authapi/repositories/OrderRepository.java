package com.security.authapi.repositories;


import com.security.authapi.entities.Order;
import com.security.authapi.model.OrderSearchParams;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {

    @Query("SELECT o FROM Order o WHERE " +
            "(:#{#searchParams.orderNumber} is null or o.id = :#{#searchParams.orderNumber}) " +
            "AND (:#{#searchParams.customerNumber} is null or o.customer.id = :#{#searchParams.customerNumber}) " +
            "AND (:#{#searchParams.orderStatus} is null or o.status = :#{#searchParams.orderStatus}) "
    )
    Page<Order> getOrders(@Param("searchParams") final OrderSearchParams searchParams, final Pageable pageable);
}