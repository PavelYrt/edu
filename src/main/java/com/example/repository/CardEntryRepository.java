package com.example.repository;

import com.example.model.CardEntry;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CardEntryRepository extends JpaRepository<CardEntry, Long> {
}
