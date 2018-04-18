package Taller1db.TBD.rest;

import Taller1db.TBD.Entities.Actor;
import Taller1db.TBD.repository.ActorRepository;
import Taller1db.TBD.repository.FilmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import Taller1db.TBD.Entities.Film;

import java.util.Set;
import java.text.ParseException;
import java.util.Date;
import java.sql.Timestamp;
import java.util.List;


@CrossOrigin
@RestController
@RequestMapping("/actors")
public class ActorService {

    @Autowired
    private ActorRepository actorRepository;
    @Autowired
    private FilmRepository filmRepository;


    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public List<Actor> getAllActors() {
        return actorRepository.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Actor getActor(@PathVariable Integer id) {
        Long actorId = id.longValue();
        return actorRepository.findActorById(actorId);
    }

    @RequestMapping(value = "/{id}/films", method = RequestMethod.GET)
    @ResponseBody
    public Set<Film> movieTheActor (@PathVariable("id") Long id) {
        return actorRepository.findActorById(id).getFilms();
    }

    @PostMapping("/{id}/films/{idFilms}")
    @ResponseBody
    public HttpStatus match (@PathVariable("id") Long id, @PathVariable("idFilms") Long idFilms) {

        Actor actor = actorRepository.findActorById(id);
        Film film = filmRepository.findFilmsById(idFilms);
        if ( actor !=  null &&  film != null) {
            actor.getFilms().add(film);
            actorRepository.save(actor);
            return HttpStatus.OK;
        }
        else
            return HttpStatus.NOT_ACCEPTABLE;
    }

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
