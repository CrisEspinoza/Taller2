package Taller1db.TBD.rest;

import Taller1db.TBD.Entities.Actor;
import Taller1db.TBD.repository.ActorRepository;
import Taller1db.TBD.repository.FilmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import Taller1db.TBD.Entities.Film;
import java.util.Set;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import java.sql.Timestamp;


import java.util.List;

@RestController
@RequestMapping("/actors")
public class ActorService {

    @Autowired
    private ActorRepository actorRepository;
    @Autowired
    private FilmRepository filmRepository;


    @CrossOrigin
    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public List<Actor> getAllActors() {
        return actorRepository.findAll();
    }

    @CrossOrigin
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Actor getActor(@PathVariable Integer id) {
        Long actorId = id.longValue();
        return actorRepository.findActorById(actorId);
    }

    @CrossOrigin
    @RequestMapping(value = "/{id}/films", method = RequestMethod.GET)
    @ResponseBody
    public Set<Film> movieTheActor (@PathVariable("id") Long id) {
        return actorRepository.findActorById(id).getFilms();
    }

    @PostMapping("/{id}/films/{idFilms}")
    @ResponseBody
    public ResponseEntity<Set<Film>> match (@PathVariable("id") Long id, @PathVariable("idFilms") Long idFilms) {

        Actor actor = actorRepository.findActorById(id);
        Film film = filmRepository.findFilmsById(idFilms);

        if (film == null || actor == null ){

            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        else{
            Set<Film> films = actor.getFilms();
            films.add(film);
            actor.setFilms(films);
            actorRepository.save(actor);
            return new ResponseEntity<Set<Film>>(actorRepository.findActorById(id).getFilms(), HttpStatus.OK);

        }
    }

    @CrossOrigin
    @PostMapping("/create")
    @ResponseBody
    public Actor create(@RequestBody Actor resource) throws ParseException {

        Date date = new Date();
        long time = date.getTime();
        new Timestamp(time);
        resource.setLastUpdate(new Timestamp(time));
        return actorRepository.save(resource);
    }
}
