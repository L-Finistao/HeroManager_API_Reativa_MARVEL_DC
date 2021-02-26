package com.digitalinnovationone.heromanager.hero.manager.services;

import com.digitalinnovationone.heromanager.hero.manager.entity.Heroes;
import com.digitalinnovationone.heromanager.hero.manager.repository.HeroesReposity;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
import reactor.core.publisher.Flux;

@Service
public class HeroesServices {
    private final HeroesReposity heroesReposity;


    public HeroesServices(HeroesReposity heroesReposity) {
        this.heroesReposity = heroesReposity;
    }

    public Flux<Heroes> findAll(){
        return  Flux.fromIterable(this.heroesReposity.findAll());
    }

    public Mono<Heroes> findByIdHero(Long id){
        return  Mono.justOrEmpty(this.heroesReposity.findById(id));
    }
    public Mono<Heroes> save (Heroes heroes){
        return  Mono.justOrEmpty(this.heroesReposity.save(heroes));
    }

    public Mono<Boolean> deleteByIdHero(Long Id){
        heroesReposity.deleteById(Id);
        return Mono.just(true);
    }


}
