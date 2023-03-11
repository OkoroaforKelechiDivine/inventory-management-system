package com.mintyn.inventorymanagement.repository.order;

import com.mintyn.inventorymanagement.dto.OrderReport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderReportRepository extends JpaRepository<OrderReport, Integer> {
}
