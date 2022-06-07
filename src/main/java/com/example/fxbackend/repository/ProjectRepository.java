package com.example.fxbackend.repository;

import com.example.fxbackend.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository <Project, Long>{
}
