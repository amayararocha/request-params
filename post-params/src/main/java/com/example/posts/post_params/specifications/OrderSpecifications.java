package com.example.posts.post_params.specifications;

import com.example.posts.post_params.models.Order;
import org.springframework.data.jpa.domain.Specification;

import java.time.LocalDate;

public class OrderSpecifications {

    public static Specification<Order> hasOrderNumber(String orderNumber) {
        return (orderNumber == null || orderNumber.isEmpty()) ? null : (root, query, criteriaBuilder) ->
                criteriaBuilder.equal(root.get("orderNumber"), orderNumber);
    }

    public static Specification<Order> hasCustomerName(String customerName) {
        return (customerName == null || customerName.isEmpty()) ? null : (root, query, criteriaBuilder) ->
                criteriaBuilder.like(root.get("customerName"), "%" + customerName + "%");
    }

    public static Specification<Order> hasStatus(String status) {
        return (status == null || status.isEmpty()) ? null : (root, query, criteriaBuilder) ->
                criteriaBuilder.equal(root.get("status"), status);
    }

    public static Specification<Order> hasMinAmount(Double minAmount) {
        return (minAmount == null) ? null : (root, query, criteriaBuilder) ->
                criteriaBuilder.greaterThanOrEqualTo(root.get("totalAmount"), minAmount);
    }

    public static Specification<Order> hasMaxAmount(Double maxAmount) {
        return (maxAmount == null) ? null : (root, query, criteriaBuilder) ->
                criteriaBuilder.lessThanOrEqualTo(root.get("totalAmount"), maxAmount);
    }

    public static Specification<Order> isAfterStartDate(LocalDate startDate) {
        return (startDate == null) ? null : (root, query, criteriaBuilder) ->
                criteriaBuilder.greaterThanOrEqualTo(root.get("orderDate"), startDate);
    }

    public static Specification<Order> isBeforeEndDate(LocalDate endDate) {
        return (endDate == null) ? null : (root, query, criteriaBuilder) ->
                criteriaBuilder.lessThanOrEqualTo(root.get("orderDate"), endDate);
    }
}
