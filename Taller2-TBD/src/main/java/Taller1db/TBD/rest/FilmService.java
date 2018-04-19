package Taller1db.TBD.rest;

import Taller1db.TBD.Entities.Actor;
import Taller1db.TBD.Entities.Film;
import Taller1db.TBD.repository.ActorRepository;
import Taller1db.TBD.repository.FilmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@CrossOrigin
@RestController
@RequestMapping("/films")
public class FilmService {
    @Autowired
    private FilmRepository filmRepository;
    @Autowired
    private ActorRepository actorRepository;

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public List<Film> getAllFilm() {
        return filmRepository.findAll();
    }

    @GetMapping("{id}/actors")
    @ResponseBody
    public Set<Actor> actorTheMovie (@PathVariable("id") Long id){
        return  filmRepository.findFilmsById(id).getActors();

    }

    @PostMapping("{idFilm}/actors/{idActor}")
    @ResponseBody
    public HttpStatus matchFilm(@PathVariable("idFilm") Long idFilm, @PathVariable("idActor") Long  idActor){

        Actor actor = actorRepository.findActorById(idActor);
        Film film = filmRepository.findFilmsById(idFilm);
        if(actor != null && film != null){
            film.getActors().add(actor);
            filmRepository.save(film);
            return HttpStatus.OK;
        }
        else
            return HttpStatus.NOT_ACCEPTABLE;

    }


}
