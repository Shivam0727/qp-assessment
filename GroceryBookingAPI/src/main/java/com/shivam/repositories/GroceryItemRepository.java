package com.shivam.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shivam.entities.GroceryItem;

@Repository
public interface GroceryItemRepository extends JpaRepository<GroceryItem, Long> {

}
