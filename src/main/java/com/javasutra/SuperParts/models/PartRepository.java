package com.javasutra.SuperParts.models;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;


public interface PartRepository extends PagingAndSortingRepository<Part, Long> {
    @Query("SELECT p FROM Part p WHERE " +
            "LOWER(p.title) LIKE LOWER(CONCAT('%', :searchTerm, '%'))" +
            "AND p.need in (CONCAT('', :searchNeed, ''))")
    Page<Part> findBySearchParams(@Param("searchTerm") String searchTerm,@Param("searchNeed") String searchNeed, Pageable pageRequest);

    @Query("SELECT p FROM Part p WHERE " +
            "LOWER(p.title) LIKE LOWER(CONCAT('%', :searchTerm, '%'))")
    Page<Part> findBySearchParams(@Param("searchTerm") String searchTerm, Pageable pageRequest);

    @Query("SELECT min(p.partscount) from Part p where need =1")
    int findAssembledComputer();
}
