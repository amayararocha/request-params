package com.example.posts.post_params.services;

import com.example.posts.post_params.models.Order;
import com.example.posts.post_params.respositories.OrderRepository;
import com.example.posts.post_params.specifications.OrderSpecifications;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public List<Order> getOrders(String orderNumber, String customerName, String status,
                                 Double minAmount, Double maxAmount,
                                 LocalDate startDate, LocalDate endDate) {
        return orderRepository.findAll(
                Specification.where(OrderSpecifications.hasOrderNumber(orderNumber))
                        .and(OrderSpecifications.hasCustomerName(customerName))
                        .and(OrderSpecifications.hasStatus(status))
                        .and(OrderSpecifications.hasMinAmount(minAmount))
                        .and(OrderSpecifications.hasMaxAmount(maxAmount))
                        .and(OrderSpecifications.isAfterStartDate(startDate))
                        .and(OrderSpecifications.isBeforeEndDate(endDate))
        );
    }
}
