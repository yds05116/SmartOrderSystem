package com.SOS.SmartOrderSystem.service;

import com.SOS.SmartOrderSystem.domain.Order;
import com.SOS.SmartOrderSystem.repository.MenuRepository;
import com.SOS.SmartOrderSystem.repository.OrderRepository;
import com.SOS.SmartOrderSystem.repository.jpa.JpaMenuRepository;
import com.SOS.SmartOrderSystem.repository.jpa.JpaOrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final JpaOrderRepository orderRepository;
    private final JpaMenuRepository menuRepository;



    @Override
    public void join(Order order) {
        //validateDuplicateOrder(order);
        orderRepository.save(order);

    }

    @Override
    public Order findOrder(Long orderId) {
        return null;
    }
/*

    private void validateDuplicateOrder(Order order) {
        orderRepository.findByName(order.getName()).ifPresent((m -> {
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        }));
    }
*/
    public List<Order> findMembers() {
        return orderRepository.findAll();
    }
    
    public Optional<Order> findOne(Long memberId){
        return orderRepository.findById(memberId);
    }
}
