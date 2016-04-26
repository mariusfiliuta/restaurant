package services;

import model.OrderProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repositories.OrderProductRepository;

import java.util.Set;

@Service
public class OrderProductServiceImpl implements OrderProductService{

    @Autowired
    private OrderProductRepository orderProductRepository;

    @Override
    public void save(Set<OrderProduct> orderProducts){ orderProductRepository.save(orderProducts);}
    @Override
    public void save(OrderProduct orderProduct){ orderProductRepository.save(orderProduct);}
    @Override
    public void delete(Set<OrderProduct> orderProducts){ orderProductRepository.delete(orderProducts);}
    @Override
    public void delete(OrderProduct orderProduct){ orderProductRepository.delete(orderProduct);}

}
