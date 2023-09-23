package iq.lavash.repository;


import iq.lavash.entity.LavashOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LavashOrderRepository extends JpaRepository<LavashOrder, Long> {

}
