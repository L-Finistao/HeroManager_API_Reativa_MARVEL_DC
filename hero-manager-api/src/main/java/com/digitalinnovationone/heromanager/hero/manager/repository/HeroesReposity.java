package com.digitalinnovationone.heromanager.hero.manager.repository;

import com.digitalinnovationone.heromanager.hero.manager.entity.Heroes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories
public interface HeroesReposity extends JpaRepository<Heroes,Long> {
}
