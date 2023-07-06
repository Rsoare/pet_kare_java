package com.java_projects.pet_kare_java.repository;

import com.java_projects.pet_kare_java.model.Trait;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TraitRepository extends JpaRepository<Trait, Long> {
}
