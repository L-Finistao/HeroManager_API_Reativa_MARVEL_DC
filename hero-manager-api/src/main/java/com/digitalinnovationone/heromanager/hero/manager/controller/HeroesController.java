package com.digitalinnovationone.heromanager.hero.manager.controller;
import com.digitalinnovationone.heromanager.hero.manager.entity.Heroes;
import com.digitalinnovationone.heromanager.hero.manager.repository.HeroesReposity;
import com.digitalinnovationone.heromanager.hero.manager.services.HeroesServices;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@Slf4j
public class HeroesController {

        HeroesServices heroesServices;
        HeroesReposity heroesReposity;
        private static final  org.slf4j.Logger log= org.slf4j.LoggerFactory.getLogger(HeroesController.class);

    public HeroesController(HeroesServices heroesServices, HeroesReposity heroesReposity) {
        this.heroesServices = heroesServices;
        this.heroesReposity = heroesReposity;
    }

    @GetMapping("/heroes")
    public Flux<Heroes> getAllItems (){
        log.info("request the list off all heroes");
        return  heroesServices.findAll();
    }

    @GetMapping("/heroes/id")
    public Mono<ResponseEntity<Heroes>> findByHeroes(@PathVariable Long id){
        log.info("request the list off all heroes");
        return  heroesServices.findByIdHero(id).map((item) -> new ResponseEntity<>(item,HttpStatus.OK))
                .defaultIfEmpty(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/")
    @ResponseStatus(code = HttpStatus.CREATED)
    public Mono<Heroes> createHero(@RequestBody Heroes heroes){
        log.info("a new Hero was created");
        return  heroesServices.save(heroes);
    }

    @DeleteMapping("/heroes/id")
    @ResponseStatus(code = HttpStatus.CONTINUE)
        public  Mono<HttpStatus>  deletebyIdHero(@PathVariable Long id){
        heroesServices.deleteByIdHero(id);
        log.info("deleted a hero is {}",id);
        return  Mono.just(HttpStatus.NOT_FOUND);
    }




}
