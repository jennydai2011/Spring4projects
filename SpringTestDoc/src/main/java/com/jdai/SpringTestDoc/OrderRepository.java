package com.jdai.SpringTestDoc;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {//CrudRepository<Order, Long> {
//    List<Order> findByName(String name){
//        return Stream.of(findAll())
//                .filter(o -> ((Order)o).getName().startsWith(name))
//                .collect(Collectors.toList());
//    }

    Order findById(long id);
}
